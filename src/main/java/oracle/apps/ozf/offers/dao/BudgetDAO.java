package oracle.apps.ozf.offers.dao;

import java.util.List;
import oracle.apps.ozf.offers.Budget;

public interface BudgetDAO {

	public boolean insert(Budget budget);
	public boolean update(Budget budget);
	public boolean delete(Budget budget);
	public Budget findByBudgetId(int budgetId);
	public List<Budget> findByOfferIf(int offerId);
	
}
