package oracle.apps.ozf.offers.dao;

import java.util.List;

import oracle.apps.ozf.offers.Modifier;

public interface ModifierDAO {

	public boolean save(Modifier offer);
	public boolean update(Modifier offer);
	public boolean delete(Modifier offer);
	public Modifier findByModifierId(int modifierId);
	public List<Modifier> findByOfferIf(int offerId);
	
}
