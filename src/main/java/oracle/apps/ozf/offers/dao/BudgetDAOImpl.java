package oracle.apps.ozf.offers.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import oracle.apps.ozf.offers.Budget;
import oracle.apps.ozf.offers.dao.mapper.BudgetMapper;

@Repository("BudgetDAO")
public class BudgetDAOImpl implements BudgetDAO{
	
	private JdbcTemplate jdbcTemplateObject;
	private DataSource dataSource;
	private PlatformTransactionManager trxMgr;
	private TransactionDefinition trxDef;

	private final String insertSQL = "INSERT into OZF_FUNDS_ALL_B ( "
			+ "fund_id,"
			+ "fund_number,"
			+ "fund_type,"
			+ "status_code,"
			+ "start_date_active,"
			+ "end_date_active,"
			+ "budget_amount,"
			+ "available_amount,"
			+ "distributed_amount,"
			+ "currency_code,"
			+ "owner,"
			+ "planned_amt,"
			+ "commited_amt,"
			+ "earned_amt,"
			+ "paid_amt,"
			+ "activation_date," 
			+ "object_version_number,"
			+ "created_by,"
			+ "creation_date,"
			+ "last_updated_by,"
			+ "last_update_date,"
			+ "last_update_login)"
			+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String updateSQL = "update OZF_FUNDS_ALL_B set "
			+ "fund_number = ?,"
			+ "fund_type = ?,"
			+ "status_code = ?,"
			+ "start_date_active = ?,"
			+ "end_date_active = ?,"
			+ "budget_amount = ?,"
			+ "available_amount = ?,"
			+ "distributed_amount = ?,"
			+ "currency_code = ?,"
			+ "owner = ?,"
			+ "planned_amt = ?,"
			+ "commited_amt = ?,"
			+ "earned_amt = ?,"
			+ "paid_amt = ?,"
			+ "activation_date = ?," 
			+ "object_version_number = ?,"
			+ "created_by = ?,"
			+ "creation_date = ?,"
			+ "last_updated_by = ?,"
			+ "last_update_date = ?,"
			+ "last_update_login = ?"
			+ " where fund_id = ?";
	
	private final String deleteSQL = "DELETE from OZF_FUNDS_ALL_B where FUND_ID = ?";
	private final String findByBudgetSQL = "SELECT * from OZF_FUNDS_ALL_B where FUND_ID = ?";
	private final String findByOfferSQL = "SELECT F.* from OZF_FUNDS_ALL_B F, OZF_ACT_BUDGETS B " 
			                              + "where B.ACT_BUDGET_USED_BY_ID = ? and "
			                              + "b.ACT_BUDGET_USED_BY = 'OFFER' and "
			                              + "F.FUND_ID = B.BUDGET_SOURCE_ID and "
			                              + "B.BUDGET_SOURCE_TYPE = 'FUND'";
			                              
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	@Autowired
	public void setTransactionMgr(PlatformTransactionManager trxMgr) {
		this.trxMgr = trxMgr;
	}

	public boolean update(Budget budget) {
		
		trxDef = new DefaultTransactionDefinition();
		TransactionStatus trxStatus = trxMgr.getTransaction(trxDef);
			
		Object[] params = {
				budget.getFundNumber(),
				budget.getFundType(),
				budget.getStatusCode(),
				budget.getStartDateActive(),
				budget.getEndDateActive(),
				budget.getBudgetAmount(),
				budget.getAvailableAmount(),
				budget.getDistributedAmount(),
				budget.getCurrencyCode(),
				budget.getOwner(),
				budget.getPlannedAmount(),
				budget.getCommitedAmount(),
				budget.getEarnedAmount(),
				budget.getPaidAmount(),
				budget.getActivationDate(),
				budget.getObjectVersionNumber(),
				budget.getCreatedBy(),
				budget.getCreationDate(),
				budget.getLastUpdatedBy(),
				budget.getLastUpdateDate(),
				budget.getLastUpdateLogin(),
				budget.getFundId() };
		
		int[] types = {	
				Types.BIGINT, 
				Types.VARCHAR, 
				Types.VARCHAR, 
				Types.DATE,
				Types.DATE,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.VARCHAR,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.DATE,
				Types.BIGINT,
				Types.BIGINT,
				Types.DATE,
				Types.BIGINT,
				Types.DATE,
				Types.BIGINT,
				Types.BIGINT };

		System.out.println(budget.toString());
		try {
			jdbcTemplateObject.update(updateSQL, params, types);
			trxMgr.commit(trxStatus);
			
		} catch (DataAccessException e) {
			trxMgr.commit(trxStatus);
			throw new RuntimeException(e);
		}
		
		return true;
	}//end of update

	/**
	 * Method to delete a budget.
	 * @param Budget an instance of budget bean,
	 * the fundId of the bean is used to perform the delete.
	 */
	public boolean delete(Budget budget) {
		trxDef = new DefaultTransactionDefinition();
		TransactionStatus trxStatus = trxMgr.getTransaction(trxDef);
		
		Object[] param = {budget.getFundId()};
		Object[] paramType = {Types.BIGINT};
		
		try {
			jdbcTemplateObject.update(deleteSQL, param, paramType);
			trxMgr.commit(trxStatus);
		}catch (DataAccessException e) {
			trxMgr.rollback(trxStatus);
			throw new RuntimeException(e);
		}
		return true;
	}//end of delete

	public Budget findByBudgetId(int budgetId) {
		trxDef = new DefaultTransactionDefinition();
		TransactionStatus trxStatus = trxMgr.getTransaction(trxDef);

		Budget budget = null;
		try {
			budget = jdbcTemplateObject.queryForObject(findByBudgetSQL, new Object[] {budgetId}, new BudgetMapper());
			trxMgr.commit(trxStatus);
		}catch (DataAccessException e) {
			trxMgr.rollback(trxStatus);
			throw new RuntimeException(e);
		}
		
		return budget;
	}//end of find by budget id

	public ArrayList<Budget> findByOfferId(int offerId) {
		trxDef = new DefaultTransactionDefinition();
		TransactionStatus trxStatus = trxMgr.getTransaction(trxDef);

		ArrayList<Budget> listOfBudgets = null;
		try {
			listOfBudgets = (ArrayList<Budget>) jdbcTemplateObject.query(findByOfferSQL, new Object[] {offerId}, new BudgetMapper());
			trxMgr.commit(trxStatus);
		}catch (DataAccessException e) {
			trxMgr.rollback(trxStatus);
		}
		
		return listOfBudgets;
	}//end of find by offer id
	

	public boolean insert(Budget budget) {
		
		trxDef = new DefaultTransactionDefinition();
		TransactionStatus trxStatus = trxMgr.getTransaction(trxDef);
		
		Object[] params = {
				budget.getFundId(),
				budget.getFundNumber(),
				budget.getFundType(),
				budget.getStatusCode(),
				budget.getStartDateActive(),
				budget.getEndDateActive(),
				budget.getBudgetAmount(),
				budget.getAvailableAmount(),
				budget.getDistributedAmount(),
				budget.getCurrencyCode(),
				budget.getOwner(),
				budget.getPlannedAmount(),
				budget.getCommitedAmount(),
				budget.getEarnedAmount(),
				budget.getPaidAmount(),
				budget.getActivationDate(),
				budget.getObjectVersionNumber(),
				budget.getCreatedBy(),
				budget.getCreationDate(),
				budget.getLastUpdatedBy(),
				budget.getLastUpdateDate(),
				budget.getLastUpdateLogin() };
		
		int[] types = {	
				Types.BIGINT, 
				Types.BIGINT, 
				Types.VARCHAR, 
				Types.VARCHAR, 
				Types.DATE,
				Types.DATE,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.VARCHAR,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.BIGINT,
				Types.DATE,
				Types.BIGINT,
				Types.BIGINT,
				Types.DATE,
				Types.BIGINT,
				Types.DATE,
				Types.BIGINT};

		System.out.println(budget.toString());
		try {
				jdbcTemplateObject.update(insertSQL, params, types);
				trxMgr.commit(trxStatus);
		} catch (DataAccessException e) {
			trxMgr.commit(trxStatus);
			throw new RuntimeException(e);
		}
		
		return true;
	}//end of insert

}//end of class
