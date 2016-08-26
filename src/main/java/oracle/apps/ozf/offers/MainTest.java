package oracle.apps.ozf.offers;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.apps.ozf.offers.dao.AccrualOfferDAO;
import oracle.apps.ozf.offers.dao.BudgetDAO;
import oracle.apps.ozf.offers.AccrualOffer;


public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");
		
		AccrualOfferDAO accrualOfferDAO = (AccrualOfferDAO) context.getBean("JdbcAccrualOfferDAOImpl");
		AccrualOffer offer = accrualOfferDAO.findByOfferId(1);
		
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("JdbcBudgetDAOImpl");
		
		Budget budget = new Budget();
		
		budgetDAO.insert(budget);
		budget.setFundNumber(12345);
		budgetDAO.update(budget);
		
		ArrayList<Budget> bList = new ArrayList<Budget>();
		bList.add(budget);
		offer.setBudget(bList);
		System.out.println(offer.getOfferCode());

		((ClassPathXmlApplicationContext) context).close();
	}

}
