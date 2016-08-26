package oracle.apps.ozf.offers.dao;

import java.sql.Types;
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
		
		System.out.println(updateSQL);
		
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

	public boolean delete(Budget budget) {
		// TODO Auto-generated method stub
		return false;
	}

	public Budget findByBudgetId(int budgetId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Budget> findByOfferIf(int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Budget budget) {
		
		trxDef = new DefaultTransactionDefinition();
		TransactionStatus trxStatus = trxMgr.getTransaction(trxDef);
		
		System.out.println(insertSQL);
		
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
