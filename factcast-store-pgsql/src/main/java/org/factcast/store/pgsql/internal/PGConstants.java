package org.factcast.store.pgsql.internal;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@UtilityClass
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class PGConstants {

	String TABLE_FACT = "fact";
	String CHANNEL_NAME = "fact_insert";

	String COLUMN_PAYLOAD = "payload";
	String COLUMN_HEADER = "header";
	String COLUMN_SER = "ser";
	String ALIAS_ID = "id";
	String ALIAS_NS = "ns";
	String ALIAS_TYPE = "type";
	String ALIAS_AGGID = "aggId";

	// String PROJECTION_ID = , "
	// + PGConstants.COLUMN_SER;
	String PROJECTION_FACT = String.join(", ", COLUMN_SER, COLUMN_HEADER, COLUMN_PAYLOAD, fromHeader(ALIAS_ID),
			fromHeader(ALIAS_AGGID), fromHeader(ALIAS_NS), fromHeader(ALIAS_TYPE));

	String INSERT_FACT = "INSERT INTO " + TABLE_FACT + "(" + COLUMN_HEADER + "," + COLUMN_PAYLOAD
			+ ") VALUES (cast(? as jsonb),cast (? as jsonb))";
	String SELECT_BY_ID = "SELECT " + PROJECTION_FACT + " FROM " + TABLE_FACT + " WHERE " + COLUMN_HEADER
			+ " @> cast (? as jsonb)";

	private String fromHeader(String attributeName) {
		return PGConstants.COLUMN_HEADER + "->>'" + attributeName + "' AS " + attributeName;
	}

}