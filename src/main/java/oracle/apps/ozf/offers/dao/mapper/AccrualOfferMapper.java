package oracle.apps.ozf.offers.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import oracle.apps.ozf.offers.AccrualOffer;

public class AccrualOfferMapper implements RowMapper<AccrualOffer> {

	public AccrualOffer mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccrualOffer offer = new AccrualOffer();
		offer.setOfferCode(rs.getString("OFFER_CODE"));
		
		return offer;
	}
}
