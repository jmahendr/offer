package oracle.apps.ozf.offers.dao.mapper;

import oracle.apps.ozf.offers.Budget;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BudgetMapper implements RowMapper<Budget>{

	public Budget mapRow(ResultSet rs, int rowNum) throws SQLException {
		Budget budget = new Budget();
		budget.setFundId(rs.getLong("FUND_ID"));
		budget.setFundNumber(rs.getLong("FUND_NUMBER"));
		budget.setFundType(rs.getString("FUND_TYPE"));
		budget.setStatusCode(rs.getString("STATUS_CODE"));
		budget.setStartDateActive(rs.getDate("START_DATE_ACTIVE"));
		budget.setEndDateActive(rs.getDate("END_DATE_ACTIVE"));
		budget.setBudgetAmount(rs.getLong("BUDGET_AMOUNT"));
		budget.setAvailableAmount(rs.getLong("AVAILABLE_AMOUNT"));
		budget.setDistributedAmount(rs.getLong("DISTRIBUTED_AMOUNT"));
		budget.setCurrencyCode(rs.getString("CURRENCY_CODE"));
		budget.setOwner(rs.getLong("OWNER"));
		budget.setPlannedAmount(rs.getLong("PLANNED_AMT"));
		budget.setCommitedAmount(rs.getLong("COMMITED_AMT"));
		budget.setEarnedAmount(rs.getLong("EARNED_AMT"));
		budget.setPaidAmount(rs.getLong("PAID_AMT"));
		budget.setActivationDate(rs.getDate("ACTIVATION_DATE"));
		budget.setObjectVersionNumber(rs.getLong("OBJECT_VERSION_NUMBER"));
		budget.setCreatedBy(rs.getLong("CREATED_BY"));
		budget.setCreationDate(rs.getDate("CREATION_DATE"));
		budget.setLastUpdatedBy(rs.getLong("LAST_UPDATED_BY"));
		budget.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
		budget.setLastUpdateLogin(rs.getLong("LAST_UPDATE_LOGIN"));
		
		return budget;
	}

}
