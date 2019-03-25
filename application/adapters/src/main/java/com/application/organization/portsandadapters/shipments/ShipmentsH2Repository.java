package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.cachedShipments.ImmutableSimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.SimplifiedCoreShipment;
import com.application.organization.shipments.cachedShipments.ShipmentsRepository;
import com.application.organization.shipments.cachedShipments.ShipmentsRepositoryError;
import io.vavr.control.Either;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShipmentsH2Repository implements ShipmentsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ShipmentsH2Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Either<ShipmentsRepositoryError, List<SimplifiedCoreShipment>> findAll() {
        List<SimplifiedCoreShipment> shipments = namedParameterJdbcTemplate.query("SELECT * from SHIPMENTS", new RowMapper<SimplifiedCoreShipment>() {
            @Override
            public SimplifiedCoreShipment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return ImmutableSimplifiedCoreShipment.builder().destination(resultSet.getString("DESTINATION")).build();
            }
        });

        return Either.right(shipments);
    }
}
