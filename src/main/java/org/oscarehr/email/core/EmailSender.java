package org.oscarehr.email.core;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.logging.log4j.Logger;
import org.oscarehr.common.model.EmailAttachment;
import org.oscarehr.common.model.EmailConfig;
import org.oscarehr.email.helpers.APISendGridEmailSender;
import org.oscarehr.email.helpers.SMTPEmailSender;
import org.oscarehr.managers.SecurityInfoManager;
import org.oscarehr.util.EmailSendingException;
import org.oscarehr.util.LoggedInInfo;
import org.oscarehr.util.MiscUtils;
import org.oscarehr.util.SpringUtils;

public class EmailSender {
    private final Logger logger = MiscUtils.getLogger();
    private LoggedInInfo loggedInInfo;

    private SecurityInfoManager securityInfoManager = SpringUtils.getBean(SecurityInfoManager.class);

    private EmailConfig emailConfig;
    private String[] recipients = new String[0];
    private String subject;
    private String body;
    private String additionalParams;
    private List<EmailAttachment> attachments;

    private EmailSender() { }

    public EmailSender(LoggedInInfo loggedInInfo, EmailConfig emailConfig, EmailData emailData) {
        this.loggedInInfo = loggedInInfo;
        this.emailConfig = emailConfig;
        this.recipients = emailData.getRecipients();
        this.subject = emailData.getSubject();
        this.body = emailData.getBody();
        this.attachments = emailData.getAttachments();
        this.additionalParams = emailData.getAdditionalParams();
    }

    public EmailSender(LoggedInInfo loggedInInfo, EmailConfig emailConfig, String[] recipients, String subject, String body, List<EmailAttachment> attachments) {
        this.loggedInInfo = loggedInInfo;
        this.emailConfig = emailConfig;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    public EmailSender(LoggedInInfo loggedInInfo, EmailConfig emailConfig, String[] recipients, String subject, String body, String additionalParams, List<EmailAttachment> attachments) {
        this.loggedInInfo = loggedInInfo;
        this.emailConfig = emailConfig;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
        this.additionalParams = additionalParams;
    }
    
    public void send() throws EmailSendingException {
        if (!securityInfoManager.hasPrivilege(loggedInInfo, "_email", SecurityInfoManager.WRITE, null)) {
			throw new RuntimeException("missing required security object (_email)");
		}

        switch (emailConfig.getEmailType()) {
            case SMTP:
                SMTPEmailSender smtpSendHelper = new SMTPEmailSender(loggedInInfo, emailConfig, recipients, subject, body, attachments);
                smtpSendHelper.send();
                break;
            case API:
                sendAPIMail();
                break;
            default:
                throw new EmailSendingException("Invalid email configuration");
        }
    }

    private void sendAPIMail() throws EmailSendingException {
        switch (emailConfig.getEmailProvider()) {
            case SENDGRID:
                APISendGridEmailSender apiSendGridSendHelper = new APISendGridEmailSender(loggedInInfo, emailConfig, recipients, subject, body, additionalParams, attachments);
                apiSendGridSendHelper.send();
                break;
            default:
                throw new EmailSendingException("Invalid email configuration");
        }
    }

    // For debugging
    private void checkProtocolSupport() {
        logger.info("JavaMail version: " + javax.mail.Session.class.getPackage().getImplementationVersion());
        try {
            logger.info(String.join(" ", SSLContext.getDefault().getSupportedSSLParameters().getProtocols()));
        } catch (NoSuchAlgorithmException e) {
            logger.info("NoSuchAlgorithmException", e);
        }
    }
}
