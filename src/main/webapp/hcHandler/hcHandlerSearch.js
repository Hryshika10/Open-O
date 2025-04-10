
var _hc_windowTimeout;

var _hc_searchHandler = function(args) {
	clearTimeout(_hc_windowTimeout);
		
	var window = jQuery("#_hc_window");
	jQuery(window).find("#_hc_message, #_hc_read, #_hc_actions, #_hc_match, #_hc_noMatch, #_hc_matchSearch, #_hc_closeBtn").hide();
		
	jQuery(window).find("._hc_mismatch").removeClass("_hc_mismatch");
	jQuery(window).find("#_hc_errors").children().remove();
		
	if (!(typeof args["error"] == "undefined")) {
		jQuery(window).find("#_hc_closeBtn").hide();
		
		jQuery(window).find("#_hc_status_text_success").hide();
		jQuery(window).find("#_hc_status_text_error, #_hc_message_tryAgain, #_hc_message").show();
			
		jQuery(window).find("#_hc_status_icon").attr("class", "_hc_inlineBlock _hc_status_error");
			
		if (args["error"] == "INVALID") {
			jQuery(window).find("#_hc_message_readError").css("display", "inline-block");
			jQuery(window).find("#_hc_message_issuerError").css("display", "none");
		} else if (args["error"] == "ISSUER") {
			jQuery(window).find("#_hc_message_readError").css("display", "none");
			jQuery(window).find("#_hc_message_issuerError").css("display", "inline-block");
		} else {
			jQuery(window).find("#_hc_message_readError").css("display", "none");
			jQuery(window).find("#_hc_message_issuerError").css("display", "none");
		}
			
		_hc_windowTimeout = setTimeout(function() {
			jQuery("#_hc_window").css("display", "none");
		}, 3000);
		
			
	} else {
		jQuery(window).find("#_hc_status_text_success, #_hc_read, #_hc_layout").show();
		jQuery(window).find("#_hc_message, #_hc_status_text_error").hide();
		jQuery(window).find("#_hc_status_icon").attr("class", "_hc_inlineBlock _hc_status_success");
			
		jQuery(window).find("#_hc_layout_name").text(args["lastName"] + ", " + args["firstName"]);
		jQuery(window).find("#_hc_layout_hin_num").html(args["hin"].substring(0,4) + "&#149; " + args["hin"].substring(4,7) + "&#149; " + args["hin"].substring(7,10) + "&#149;");
		jQuery(window).find("#_hc_layout_hin_ver").text(args["hinVer"]);
			
		jQuery(window).find("#_hc_layout_info_dob").text(args["dob"].substring(0,4) + "/" + args["dob"].substring(4,6) + "/" + args["dob"].substring(6,8));
		jQuery(window).find("#_hc_layout_info_sex").text((args["sex"] == "1" ? "M" : (args["sex"] == "2" ? "F" : "")));
		
		var issueDate = (args["issueDate"].substring(0,2) <= 30 ? "20" : "19") + args["issueDate"];
		jQuery(window).find("#_hc_layout_valid_from").text(issueDate.substring(0,4) + "/" + issueDate.substring(4,6) + "/" + issueDate.substring(6,8));
		
		var hinExp = (args["hinExp"].substring(0,2) <= 30 ? "20" : "19") + args["hinExp"];
		jQuery(window).find("#_hc_layout_valid_to").text(hinExp.substring(0,4) + "/" + hinExp.substring(4,6));
			
		
		if (hinExp != "0000") {
			var hinExp = (args["hinExp"].substring(0,2) <= 30 ? "20" : "19") + args["hinExp"] + args["dob"].substring(6,8);
			jQuery(window).find("#_hc_layout_valid_to").text(hinExp.substring(0,4) + "/" + hinExp.substring(4,6) + "/" + hinExp.substring(6,8));
		
			var date = new Date();
			var hinExpDate = new Date(hinExp.substring(0,4) + "/" + hinExp.substring(4,6) + "/" + hinExp.substring(6, 8));
			if (hinExpDate <= new Date()) {
				jQuery(window).find("#_hc_layout_valid_to").addClass("_hc_mismatch");
				jQuery(window).find("#_hc_errors").append("<div class='_hc_error'>This health card has expired.</div>");
			}
			
		}
		
		jQuery("input[name='keyword']").val(args["hin"]);
		jQuery("input[name='search_mode'][value='search_hin']").attr("checked", "checked");
		
		jQuery("form[name='titlesearch']").submit();
		
   	 	_hc_windowTimeout = setTimeout(function() {
			jQuery("#_hc_window").css("display", "none");
		}, 3000);
	}
		
	jQuery(window).css("display", "block");
}

jQuery(document).ready(function() {
	jQuery("#_hc_window #_hc_matchSearch img").attr("src", ctx + "/images/DMSLoader.gif");

	jQuery("#_hc_window #_hc_closeBtn").click(function() {
		jQuery("#_hc_window").hide();
	});

	new HealthCardHandler(_hc_searchHandler);
});