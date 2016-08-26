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
		
		//AccrualOfferDAO accrualOfferDAO = (AccrualOfferDAO) context.getBean("JdbcAccrualOfferDAOImpl");
		//AccrualOffer offer = accrualOfferDAO.findByOfferId(1);
		
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("JdbcBudgetDAOImpl");
		
		//Budget budget = new Budget();
		
		//budget.setFundId(2);
		//budgetDAO.insert(budget);
		//budget.setFundNumber(234);
		//budgetDAO.update(budget);
		
		ArrayList<Budget> bList = budgetDAO.findByOfferId(1);
		//bList.add(budget);
		//offer.setBudget(bList);
		
		System.out.println(bList.size());
		System.out.println(bList.get(0).getFundNumber());
		System.out.println(bList.get(1).getFundNumber());
		
		System.out.println((budgetDAO.findByBudgetId(3)).getFundNumber());
		
		Budget b5 = new Budget();
		b5.setFundId(4);
		budgetDAO.delete(b5);

		((ClassPathXmlApplicationContext) context).close();
	}

}
