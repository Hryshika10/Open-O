/**
 * Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
 * This software is published under the GPL GNU General Public License.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version. 
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * This software was written for the
 * Department of Family Medicine
 * McMaster University
 * Hamilton
 * Ontario, Canada
 */

/*
 * Survey.java
 *
 * Created on September 10, 2004, 3:04 PM
 */

package oscar.oscarSurveillance;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.Logger;
import org.oscarehr.common.dao.SurveyDataDao;
import org.oscarehr.common.model.SurveyData;
import org.oscarehr.util.DbConnectionFilter;
import org.oscarehr.util.LoggedInInfo;
import org.oscarehr.util.MiscUtils;
import org.oscarehr.util.SpringUtils;
import org.oscarehr.util.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import oscar.util.ConversionUtils;

/**
 *
 * @author  Jay Gallagher
 */
public class Survey {
	private static Logger log = MiscUtils.getLogger();
	private SurveyDataDao surveyDataDao = SpringUtils.getBean(SurveyDataDao.class);

	static long seed = 0;

	String surveyTitle;
	String surveyQuestion;
	String surveyId;
	String exportString = null;
	String exportQuery = null;
	String patientCriteria =null;
	
	String exportDomain = null;
	String exportMethod = null;
	String exportPort = null;
	
	int randomness;
	int period;// num days
	List<String> providersParticipating = null;
	private ArrayList answers = null;
	private Hashtable answerTable = null;
	String surveyStatus = "";

	public static String DEFFERED = "D";
	public static String NOTSELECTED = "P";
	public static String ANSWERED = "A";
	public static String DOESNOTMEETCRITERIA = "C";
	Random random = null;

	/** Creates a new instance of Survey */
	public Survey() {
		initRandom();
	}

	private boolean hasPatientCriteria() {
		log.debug("patientCriteria "+patientCriteria);
		if(patientCriteria == null) {
			return false;
		}
		return true;		
	}

	private void initRandom() {
		while (seed == System.currentTimeMillis())
			;
		seed = System.currentTimeMillis();
		log.debug("setting seed " + seed);
		random = new Random(seed);
	}

	/**
	 * Patient Demographic is used to find out if this patient has been deffered from this Survey
	 */
	boolean isDeffered(String status) {
		boolean isdeffered = false;
		if (status != null && status.equals("D")) {
			isdeffered = true;
		}
		log.debug("Patient deffered: " + isdeffered + " status was " + status);
		return isdeffered; // true;  //TODO
	}

	boolean isPatientSeenInPeriod(String status) {
		boolean patientseen = false;
		if (status != null && (status.equals("P") || status.equals("A") || status.equals("C"))) {
			patientseen = true;
		}
		log.debug("Was patient seen in this period: " + patientseen + " status was " + status);
		return patientseen;//false;  //TODO    
	}

	boolean doesPatientMeetCriteria(LoggedInInfo loggedInInfo, String demographic_no) {
		boolean doespatientmeetcriteria = true;
		if (hasPatientCriteria()) {
			log.debug("Survey " + surveyTitle + " has patientCriteria");
			doespatientmeetcriteria = isDemographicSelected(loggedInInfo, demographic_no);
		}
		log.debug("Does patient Meet Criteria " + doespatientmeetcriteria);
		return doespatientmeetcriteria; //TODO
	}

	public boolean isDemographicSelected(LoggedInInfo loggedInInfo, String demographicNo) {
		try {
			PreparedStatement ps = DbConnectionFilter.getThreadLocalDbConnection().prepareStatement(patientCriteria);
			ps.setString(1, demographicNo);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				return true;
			}
			
		}catch(Exception e) {
			log.error("error executing patientCriteria query "+patientCriteria,e);
		}
		return false;
	}


	boolean isPatientRandomlySelected() {
		boolean isPatientSelect = false;
		int randomValue = random.nextInt(randomness);
		if (randomValue == 0) {
			isPatientSelect = true;
		}
		log.debug("Is Patient Randomly Selected :" + isPatientSelect);
		return isPatientSelect; //true; //TODO
	}

	boolean isInSurvey(LoggedInInfo loggedInInfo, String demographic_no, String provider_no) {
		boolean isinsurvey = false;
		String sStatus = null;
		if (isProviderInSurvey(provider_no)) {
			// Get all records for this period 
			sStatus = getSurveyStatusForPeriod(demographic_no);

			if (isDeffered(sStatus)) { //in this period
				isinsurvey = true;
			} else {
				if (!isPatientSeenInPeriod(sStatus)) {
					if (doesPatientMeetCriteria(loggedInInfo, demographic_no)) {
						if (isPatientRandomlySelected()) {
							isinsurvey = true;
							addPatientToPeriod(demographic_no, provider_no, Survey.DEFFERED);
						} else {
							addPatientToPeriod(demographic_no, provider_no, Survey.NOTSELECTED);
						}
					}
				}
			}
		}
		log.debug("Provider : " + provider_no + " Demo : " + demographic_no + "  in survey :" + isinsurvey);
		return isinsurvey;
	}

	private String getSurveyStatusForPeriod(String demographic_no) {
		SurveyDataDao dao = SpringUtils.getBean(SurveyDataDao.class);
		for (SurveyData i : dao.findByDemoSurveyIdAndPeriod(ConversionUtils.fromIntString(demographic_no), surveyId, period)) {
			return i.getStatus();
		}
		return null;
	}

	private String addPatientToPeriod(String demographic_no, String provider_no, String status) {
		return addPatientToPeriod(demographic_no, provider_no, status, "");
	}

	private String addPatientToPeriod(String demographic_no, String provider_no, String status, String answer) {
		//This will beused to set patient to been seen in this period.
		String insertId = "";

		SurveyData sd = new SurveyData();
		sd.setSurveyId(surveyId);
		sd.setDemographicNo(Integer.parseInt(demographic_no));
		sd.setProviderNo(provider_no);
		sd.setStatus(status);
		sd.setAnswer(answer);
		sd.setPeriod(this.period);
		sd.setRandomness(this.randomness);
		sd.setSurveyDate(new java.util.Date());

		surveyDataDao.persist(sd);
		insertId = sd.getId().toString();

		return insertId;
	}

	public static String YES = "Y";
	public static String NO = "N";
	public static String DONTASKAGAIN = "R";

	private String getSurveyIdForDemographic(String demographic_no) {
		SurveyDataDao dao = SpringUtils.getBean(SurveyDataDao.class);
		for (SurveyData i : dao.findByDemoSurveyIdAndPeriod(ConversionUtils.fromIntString(demographic_no), surveyId, period)) {
			return i.getId().toString();
		}
		return null;
	}

	public void processAnswer(String provider_no, String demographic_no, String answer) {
		String surveyDataId = getSurveyIdForDemographic(demographic_no);
		Answer a = getAnswerByString(answer);
		if (surveyDataId == null) {
			addPatientToPeriod(demographic_no, provider_no, a.answerStatus, a.answerValue);
		} else {
			setAnswer(surveyDataId, answer);
		}

	}

	public void setAnswer(String surveyDataId, String answer) {
		Answer a = getAnswerByString(answer);
		log.debug("Answer a :" + a.answerString + " answer " + answer+ " stat "+a.answerStatus+" val "+ a.answerValue);
		SurveyData s = this.surveyDataDao.find(Integer.parseInt(surveyDataId));
		if (s != null) {
			s.setStatus(a.answerStatus);
			s.setAnswer(a.answerValue);
			surveyDataDao.merge(s);
		}

	}

	public boolean hasExport() {
		boolean export = false;
		if (exportString != null && exportQuery != null) {
			export = true;
		}
		return export;
	}

	//GETTERS AND SETTERS

	/**
	 * Getter for property surveyTitle.
	 * @return Value of property surveyTitle.
	 */
	public java.lang.String getSurveyTitle() {
		return surveyTitle;
	}

	/**
	 * Setter for property surveyTitle.
	 * @param surveyTitle New value of property surveyTitle.
	 */
	public void setSurveyTitle(java.lang.String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	/**
	 * Getter for property surveyQuestion.
	 * @return Value of property surveyQuestion.
	 */
	public java.lang.String getSurveyQuestion() {
		return surveyQuestion;
	}

	/**
	 * Setter for property surveyQuestion.
	 * @param surveyQuestion New value of property surveyQuestion.
	 */
	public void setSurveyQuestion(java.lang.String surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	/**
	 * Getter for property surveyId.
	 * @return Value of property surveyId.
	 */
	public java.lang.String getSurveyId() {
		return surveyId;
	}

	/**
	 * Setter for property surveyId.
	 * @param surveyId New value of property surveyId.
	 */
	public void setSurveyId(java.lang.String surveyId) {
		this.surveyId = surveyId;
	}

	public void addProvider(String p) {
		if (providersParticipating == null) {
			providersParticipating = new ArrayList();
		}
		if (!providersParticipating.contains(p)) {
			providersParticipating.add(p);
		}
	}
	
	public List<String> getProviderList(){
		
		return providersParticipating;
	}
	
	public void setProviderList( List<String> list){
		providersParticipating = list;
		
	}

	public boolean isProviderInSurvey(String p) {
		boolean isproviderinsurvey = false;
		if (providersParticipating != null && providersParticipating.contains(p)) {
			isproviderinsurvey = true;
		}
		log.debug("provider : " + p + " in survey :" + isproviderinsurvey);
		return isproviderinsurvey;
	}

	public void displayProvidersInSurvey() {
		if (providersParticipating != null) {
			for (int i = 0; i < providersParticipating.size(); i++) {
				String pro = (String) providersParticipating.get(i);
				log.debug(pro);
			}
		}
	}

	/**
	 * Getter for property period.
	 * @return Value of property period.
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * Setter for property period.
	 * @param period New value of property period.
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * Getter for property randomness.
	 * @return Value of property randomness.
	 */
	public int getRandomness() {
		return randomness;
	}

	/**
	 * Setter for property randomness.
	 * @param randomness New value of property randomness.
	 */
	public void setRandomness(int randomness) {
		this.randomness = randomness;
	}

	public void addAnswer(String answerString, String answerValue, String answerStatus) {
		log.debug("adding answer ");
		if (answers == null || answerTable == null) {
			clearAnswers();
		}
		Answer a = new Answer(answerString, answerValue, answerStatus);
		answers.add(a);
		answerTable.put(answerString, a);

	}

	public void clearAnswers() {
		answers = null;
		answerTable = null;
		answers = new ArrayList();
		answerTable = new Hashtable();
	}

	public Answer getAnswerByString(String answerString) {
		Answer retval = null;
		if (answerTable != null) {
			retval = (Answer) answerTable.get(answerString);
		}
		return retval;
	}

	public String getAnswerStringById(String answerID) {
		String answerString = "";
		for (int i = 0; i < answers.size(); i++) {
			Answer a = (Answer) answers.get(i);
			if (answerID.equals(a.answerValue)) {
				answerString = a.answerString;
			}
		}
		return answerString;
	}

	public Enumeration getAnswers() {
		return answerTable.keys();
	}

	public ArrayList getAnswersList() {
		return answers;
	}

	public int numAnswers() {
		int numanswer = 0;
		if (answers != null) {
			numanswer = answers.size();
		}
		return numanswer;
	}

	public String getAnswerString(int i) {
		String ansStr = null;
		if (i >= 0 && i < answers.size()) {
			Answer a = (Answer) answers.get(i);
			ansStr = a.answerString;
		}
		return ansStr;
	}

	public void displayAnswers() {
		for (int i = 0; i < answers.size(); i++) {
			Answer a = (Answer) answers.get(i);
			if (a != null) {
				log.debug(" answer " + a.answerString + " value " + a.answerValue + " status " + a.answerStatus);
			} else {
				log.debug(" NO answers ");
			}
		}
	}

	public void displayAnswers2() {
		Enumeration e = getAnswers();
		while (e.hasMoreElements()) {
			String s = (String) e.nextElement();
			Answer a = getAnswerByString(s);
			if (a != null) {
				log.debug("2 answer " + a.answerString + " value " + a.answerValue + " status " + a.answerStatus);
			} else {
				log.debug(" NO answers ");
			}
		}
	}

	public ArrayList<String[]> getStatusCount(String surveyId) {
		SurveyDataDao dao = SpringUtils.getBean(SurveyDataDao.class);
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (Object[] i : dao.countStatuses(surveyId)) {
			String[] s = { String.valueOf(i[0]), String.valueOf(i[1]) };
			list.add(s);
		}
		return list;
	}

	public ArrayList<String[]> getAnswerCount(String surveyId) {
		SurveyDataDao dao = SpringUtils.getBean(SurveyDataDao.class);
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (Object[] i : dao.countAnswers(surveyId)) {
			String[] s = { String.valueOf(i[0]), String.valueOf(i[1]) };
			list.add(s);
		}
		return list;
	}

	/**
	 * Getter for property exportString.
	 * @return Value of property exportString.
	 */
	public java.lang.String getExportString() {
		return exportString;
	}

	/**
	 * Setter for property exportString.
	 * @param exportString New value of property exportString.
	 */
	public void setExportString(java.lang.String exportString) {
		this.exportString = exportString;
	}

	/**
	 * Getter for property exportQuery.
	 * @return Value of property exportQuery.
	 */
	public java.lang.String getExportQuery() {
		return exportQuery;
	}

	/**
	 * Setter for property exportQuery.
	 * @param exportQuery New value of property exportQuery.
	 */
	public void setExportQuery(java.lang.String exportQuery) {
		this.exportQuery = exportQuery;
	}
	

	public static byte[] toBytes(Survey survey) throws ClassCastException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParserConfigurationException{
		Document doc = toDocument(survey);
		return XmlUtils.toBytes(doc, true);
	}
	public static String toXmlString(Survey survey) throws ParserConfigurationException, ClassCastException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Document doc = toDocument(survey);
		return XmlUtils.toString(doc, true);
	}
	
	private static Document toDocument(Survey survey) throws ParserConfigurationException {
		Document doc = XmlUtils.newDocument("surveillance-config");
		Element surveyElement = doc.createElement("survey");
		//doc.appendChild(surveyElement);
		doc.getFirstChild().appendChild(surveyElement);
		
		surveyElement.setAttribute("surveyTitle", survey.getSurveyTitle());
		surveyElement.setAttribute("randomness", ""+survey.getRandomness());
		surveyElement.setAttribute("period", ""+survey.getPeriod());
		surveyElement.setAttribute("surveyId", survey.getSurveyId());
		log.error("is there white space here? "+survey.getSurveyQuestion());
		XmlUtils.appendChild(doc, surveyElement, "surveyQuestion", survey.getSurveyQuestion());
		
		List<String> providerList = survey.getProviderList();
		if(providerList != null) {
			for(String provider: providerList) {
				XmlUtils.appendChild(doc, surveyElement, "provider", provider);
			}
		}
		List<Answer> sanswers = survey.getAnswersList();
		if(sanswers != null){
			for(Answer a: sanswers) {
				Element answerEle = doc.createElement("answer");
				answerEle.setAttribute("status", a.answerStatus);
				answerEle.setAttribute("value", a.answerValue);
				answerEle.setTextContent(a.answerString);
				surveyElement.appendChild(answerEle);
			}
		}
		if(survey.getPatientCriteria() != null) {
			XmlUtils.appendChild(doc, surveyElement, "patientCriteria", survey.getPatientCriteria());
		}
		XmlUtils.appendChild(doc, surveyElement, "exportQuery", survey.getExportQuery());
		XmlUtils.appendChild(doc, surveyElement, "exportString", survey.getExportString());
		
		
		if(survey.getExportDomain() != null && survey.getExportMethod() != null && survey.getExportPort() != null) {
			//<export domain="dc.cnphi-rcrsp.ca" method="FTPS" port="21"/>
			Element exportElement = doc.createElement("export");
			exportElement.setAttribute("domain", survey.getExportDomain());
			exportElement.setAttribute("method", survey.getExportMethod());
			exportElement.setAttribute("port", survey.getExportPort());
			surveyElement.appendChild(exportElement);
		}
		return doc;
		
	}
	                                                                                    
		public String getPatientCriteria() {
		return patientCriteria;
	}

		private static Survey fromDocument(Document doc){
		Survey returnSurvey = new Survey();
		Node rootNode = doc.getFirstChild();
		Node survey = XmlUtils.getChildNode(rootNode, "survey");
		
		
		returnSurvey.surveyTitle = XmlUtils.getAttributeValue(survey, "surveyTitle");
		returnSurvey.surveyQuestion = XmlUtils.getChildNodeTextContents(survey, "surveyQuestion");
		returnSurvey.surveyId = XmlUtils.getAttributeValue(survey, "surveyId");
		returnSurvey.exportString = XmlUtils.getChildNodeTextContents(survey, "exportString");
		returnSurvey.exportQuery = XmlUtils.getChildNodeTextContents(survey, "exportQuery");
		returnSurvey.patientCriteria = XmlUtils.getChildNodeTextContents(survey, "patientCriteria");
		
		try{
			returnSurvey.randomness= Integer.parseInt(XmlUtils.getAttributeValue(survey, "randomness"));
		}catch(Exception e){
			log.error("randomness was not a int value");
		}
		try{
			returnSurvey.period = Integer.parseInt(XmlUtils.getAttributeValue(survey, "period"));
		}catch(Exception e){
			log.error("randomness was not a int value");
		}
		
		for(Node answerNode : XmlUtils.getChildNodes(survey, "answer")){
			String answerString = answerNode.getTextContent();
			String answerValue = XmlUtils.getAttributeValue(answerNode, "value");
			String answerStatus = XmlUtils.getAttributeValue(answerNode, "status");
			returnSurvey.addAnswer(answerString, answerValue, answerStatus);
		}
		
		for(Node exportNode : XmlUtils.getChildNodes(survey, "export")){
			returnSurvey.exportDomain = XmlUtils.getAttributeValue(exportNode, "domain");
			returnSurvey.exportMethod = XmlUtils.getAttributeValue(exportNode, "method");
			returnSurvey.exportPort = XmlUtils.getAttributeValue(exportNode, "port");
		}
		
		
		
		for(Node providerNode : XmlUtils.getChildNodes(survey, "provider")){
			returnSurvey.addProvider(providerNode.getTextContent());
		}
		
		log.debug("title "+returnSurvey.surveyTitle+" q "+returnSurvey.surveyQuestion+" id "+returnSurvey.surveyId+" exString "+returnSurvey.exportString+" exQry "+returnSurvey.exportQuery+" rand "+returnSurvey.randomness+ " period "+returnSurvey.period );
		
		
		
		return returnSurvey;
	}

	
	public static Survey createSurvey(byte[] bArray) throws IOException, SAXException, ParserConfigurationException{
		Document doc = XmlUtils.toDocument(bArray);
		return fromDocument(doc);
	}
	
	public static Survey createSurvey(String str) throws IOException, SAXException, ParserConfigurationException{
		Document doc = XmlUtils.toDocument(str);
		return fromDocument(doc);
	}
	
	public static Survey fromStream(InputStream is) throws Exception {
		Document doc = XmlUtils.toDocument(is);
		return fromDocument(doc);
	}
	
	
	
	

	class Answer {
		public String answerString = "";
		public String answerValue = "";
		public String answerStatus = "";

		public Answer(String answerString, String answerValue, String answerStatus) {
			this.answerString = answerString;
			this.answerValue = answerValue;
			this.answerStatus = answerStatus;

		}
	}





	public String getExportDomain() {
		return exportDomain;
	}

	public String getExportMethod() {
		return exportMethod;
	}

	public String getExportPort() {
		return exportPort;
	}

}
