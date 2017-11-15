package com.infrrd.roostifyapitest.pojocollection;

public class UpdateALoanApplicationPOJO {
	public String id;
	public String reference_id;
    public String application_type;
    public String amortization_term;
    public int loan_amount;
    public int down_payment;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReference_id() {
		return reference_id;
	}
	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}
	public String getApplication_type() {
		return application_type;
	}
	public void setApplication_type(String application_type) {
		this.application_type = application_type;
	}
	public String getAmortization_term() {
		return amortization_term;
	}
	public void setAmortization_term(String amortization_term) {
		this.amortization_term = amortization_term;
	}
	public int getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(int loan_amount) {
		this.loan_amount = loan_amount;
	}
	public int getDown_payment() {
		return down_payment;
	}
	public void setDown_payment(int down_payment) {
		this.down_payment = down_payment;
	}
    
    

}
