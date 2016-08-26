package oracle.apps.ozf.offers.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import oracle.apps.ozf.offers.AccrualOffer;
import oracle.apps.ozf.offers.Budget;
import oracle.apps.ozf.offers.Qualifiers;
import oracle.apps.ozf.offers.Modifier;
import oracle.apps.ozf.offers.dao.mapper.AccrualOfferMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcAccrualOfferDAOImpl implements oracle.apps.ozf.offers.dao.AccrualOfferDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	private final String insertSql = "INSERT into OZF_OFFERS_ALL ("
			+ " OFFER_ID,"
			+ " OFFER_TYPE,"
			+ " OFFER_CODE,"
			+ " OWNER_ID,"
			+ " STATUS_CODE,"
			+ " OFFER_AMOUNT,"
			+ " BUDGET_AMOUNT_FC,"
			+ " BUDGET_AMOUNT_TC,"
			+ " TRANSACTION_CURRENCY_CODE,"
			+ " FUNCTIONAL_CURRENCY_CODE,"
			+ " START_DATE,"
			+ " ORG_ID,"
			+ " SALES_METHOD_FLAG,"
			+ " BENEFICIARY_ACCOUNT_ID,"
			+ " OBJECT_VERSION_NUMBER,"
			+ " CREATION_DATE,"
			+ " CREATED_BY,"
			+ " LAST_UPDATED_BY,"
			+ " LAST_UPDATE_DATE,"
			+ " LAST_UPDATE_LOGIN) "
			+ " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	
	AccrualOffer currInstance = new AccrualOffer();

	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean create(AccrualOffer offer) {
		Object[] args = {};
		Object[] argTypes = {};
		jdbcTemplateObject.update(insertSql, args, argTypes);
		
		System.out.println("Save AccrualOffer invoked.");
		return true;
	}

	public boolean update(AccrualOffer offer) {
		// TODO Auto-generated method stub
		System.out.println("Update AccrualOffer invoked.");
		return true;
	}

	public boolean delete(AccrualOffer offer) {
		// TODO Auto-generated method stub
		System.out.println("Delete AccrualOffer invoked.");
		return true;

	}

	public AccrualOffer findByOfferId(int offerId) {
		
		String SQL = "select * from ozf_offers_all where offer_id = ?";
	      currInstance = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{offerId}, new AccrualOfferMapper());
	     
		
		Budget budget = new Budget();
		ArrayList<Budget> budgetList = new ArrayList<Budget>();
		budgetList.add(budget);
		currInstance.setBudget(budgetList);
		
		Qualifiers me = new Qualifiers();
		ArrayList<Qualifiers> qualifierList = new ArrayList<Qualifiers>();
		qualifierList.add(me);
		currInstance.setMarketEligibility(qualifierList);
		
		Modifier modifier = new Modifier();
		ArrayList<Modifier> modifierList = new ArrayList<Modifier>();
		modifierList.add(modifier);
		currInstance.setModifier(modifierList);
		
		return currInstance;
	}

	
}
