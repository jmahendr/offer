package oracle.apps.ozf.offers;

import java.sql.Date;

public class Budget {
	
	private long fundId;
	private long fundNumber;
	private String fundType;
	private String statusCode;
	private Date startDateActive;
	private Date endDateActive;
	private long budgetAmount;
	private long availableAmount;
	private long distributedAmount;
	private String currencyCode;
	private long owner;
	private long plannedAmount;
	private long commitedAmount;
	private long earnedAmount;
	private long paidAmount;
	private Date activationDate;
	private long objectVersionNumber;
	private long createdBy;
	private Date creationDate;
	private long lastUpdatedBy;
	private Date lastUpdateDate;
	private long lastUpdateLogin;

	public long getObjectVersionNumber() {
		return objectVersionNumber;
	}

	public void setObjectVersionNumber(long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public long getFundId() {
		return fundId;
	}

	public void setFundId(long fundId) {
		this.fundId = fundId;
	}

	public long getFundNumber() {
		return fundNumber;
	}

	public void setFundNumber(long fundNumber) {
		this.fundNumber = fundNumber;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public Date getStartDateActive() {
		return startDateActive;
	}

	public void setStartDateActive(Date startDateActive) {
		this.startDateActive = startDateActive;
	}

	public Date getEndDateActive() {
		return endDateActive;
	}

	public void setEndDateActive(Date endDateActive) {
		this.endDateActive = endDateActive;
	}

	public long getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(long budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public long getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(long availableAmount) {
		this.availableAmount = availableAmount;
	}

	public long getDistributedAmount() {
		return distributedAmount;
	}

	public void setDistributedAmount(long distributedAmount) {
		this.distributedAmount = distributedAmount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public long getOwner() {
		return owner;
	}

	public void setOwner(long owner) {
		this.owner = owner;
	}

	public long getPlannedAmount() {
		return plannedAmount;
	}

	public void setPlannedAmount(long plannedAmount) {
		this.plannedAmount = plannedAmount;
	}

	public long getCommitedAmount() {
		return commitedAmount;
	}

	public void setCommitedAmount(long commitedAmount) {
		this.commitedAmount = commitedAmount;
	}

	public long getEarnedAmount() {
		return earnedAmount;
	}

	public void setEarnedAmount(long earnedAmount) {
		this.earnedAmount = earnedAmount;
	}

	public long getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public Budget()
	{
		this.fundId = 1;
		this.fundNumber = 1;
		this.fundType = "PROMOTION";
		this.startDateActive = new Date(System.currentTimeMillis());
		this.endDateActive = new Date(System.currentTimeMillis());
		this.budgetAmount = 50000;
		this.availableAmount = 50000;
		this.distributedAmount = 0;
		this.currencyCode = "USD";
		this.owner = 1;
		this.plannedAmount = 0;
		this.commitedAmount = 0;
		this.earnedAmount = 0;
		this.paidAmount = 0;
		this.activationDate = new Date(System.currentTimeMillis());
		this.statusCode = "DRAFT";
		this.creationDate =  new Date(System.currentTimeMillis());
		this.createdBy = 1;
		this.lastUpdatedBy = 1;
		this.lastUpdateDate = new Date(System.currentTimeMillis());
		this.lastUpdateLogin = 1;
		this.objectVersionNumber = 1;
	}//end of default constructor
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("fundId = " + this.fundId);
		sb.append(" fundNumber = " + this.fundNumber);
		sb.append(" fundType = " + this.fundType);
		sb.append(" startDateActive = " + this.startDateActive);
		sb.append(" endDateActive = " + this.endDateActive);
		sb.append(" budgetAmount = " + this.budgetAmount);
		sb.append(" availableAmount = " + this.availableAmount);
		sb.append(" distributedAmount = " + this.distributedAmount);
		sb.append(" currencyCode = " + this.currencyCode);
		sb.append(" owner = " + this.owner);
		sb.append(" plannedAmount = " + this.plannedAmount);
		sb.append(" commitedAmount = " + this.commitedAmount);
		sb.append(" earnedAmount = " + this.earnedAmount);
		sb.append(" paidAmount = " + this.paidAmount);
		sb.append(" ActivationDate = " + this.activationDate);
		sb.append( " statusCode = " + this.statusCode);
		sb.append( " objectVersionNumber = " + this.objectVersionNumber);
		sb.append( " createdBy = " + this.createdBy);
		sb.append( " creationDate = " + this.creationDate);
		sb.append( " lastUpdatedBy = " + this.lastUpdatedBy);
		sb.append( " lastUpdateDate = " + this.lastUpdateDate);
		sb.append( " lastUpdateLogin = " + this.lastUpdateLogin);
		
		return sb.toString();
	}//end of toString
	
}
