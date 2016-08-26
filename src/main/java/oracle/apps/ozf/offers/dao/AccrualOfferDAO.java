package oracle.apps.ozf.offers.dao;

import oracle.apps.ozf.offers.AccrualOffer;

public interface AccrualOfferDAO {

	public boolean create(AccrualOffer offer);
	public boolean update(AccrualOffer offer);
	public boolean delete(AccrualOffer offer);
	public AccrualOffer findByOfferId(int offerId);

}
