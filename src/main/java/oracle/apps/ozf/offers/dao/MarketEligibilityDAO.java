package oracle.apps.ozf.offers.dao;

import java.util.List;
import oracle.apps.ozf.offers.Qualifiers;

public interface MarketEligibilityDAO {

	public boolean save(Qualifiers offer);
	public boolean update(Qualifiers offer);
	public boolean delete(Qualifiers offer);
	public Qualifiers findByMarketEligId(int marketEligId);
	public List<Qualifiers> findByOfferIf(int offerId);
	
}
