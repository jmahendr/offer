package oracle.apps.ozf.offers.dao;

import oracle.apps.ozf.offers.ActBudget;

public interface ActBudgetDAO {
	public boolean insert(ActBudget actBudget);
	public boolean update(ActBudget actBudget);
	public boolean delete(ActBudget actBudget);
	public ActBudget findById(int id);
}
