package com.infrrd.roostifyapitest.pojocollection;

public class CreatingAMessagePOJO {
	
	public String content;
		public String sender_email;
		public String subject;
		public String loan_application_id;
		
		public String getLoan_application_id() {
			return loan_application_id;
		}
		public void setLoan_application_id(String loan_application_id) {
			this.loan_application_id = loan_application_id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSender_email() {
			return sender_email;
		}
		public void setSender_email(String sender_email) {
			this.sender_email = sender_email;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		
		

}
