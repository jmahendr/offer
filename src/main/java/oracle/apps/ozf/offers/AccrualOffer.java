package oracle.apps.ozf.offers;

import java.util.Date;
import java.util.ArrayList;

public class AccrualOffer {

	int offerId = 0;
	String offerCode = "";
	Date startDate;
	Date endDate;
	long commitedAmount;
	String offerType = "ACCRUAL";
	
	ArrayList<Qualifiers> qualifiers;
	ArrayList<Modifier> modifier;
	ArrayList<Budget> budget;
	
	public AccrualOffer() {
		this.offerCode = null;
		this.startDate = null;
		this.endDate = null;
		this.commitedAmount = 0;
		
		this.budget = new ArrayList<Budget>();
		this.qualifiers = new ArrayList<Qualifiers>();
		this.modifier = new ArrayList<Modifier>();
	}//end of constructor;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getCommitedAmount() {
		return commitedAmount;
	}

	public void setCommitedAmount(long commitedAmount) {
		this.commitedAmount = commitedAmount;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public ArrayList<Qualifiers> getMarketEligibility() {
		return qualifiers;
	}

	public void setMarketEligibility(ArrayList<Qualifiers> qualifiers) {
		this.qualifiers = qualifiers;
	}

	public ArrayList<Modifier> getModifier() {
		return modifier;
	}

	public void setModifier(ArrayList<Modifier> modifier) {
		this.modifier = modifier;
	}

	public ArrayList<Budget> getBudget() {
		return budget;
	}

	public void setBudget(ArrayList<Budget> budget) {
		this.budget = budget;
	}
	

}
