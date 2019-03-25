package com.application.organization.portsandadapters.shipments;

import com.application.organization.shipments.CoreShipment;
import com.application.organization.shipments.ImmutableCoreShipment;
import com.application.organization.shipments.ShipmentsRepository;
import com.application.organization.shipments.ShipmentsRepositoryError;
import io.vavr.control.Either;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipmentsH2Repository implements ShipmentsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ShipmentsH2Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Either<ShipmentsRepositoryError, List<CoreShipment>> findAll() {
        List<CoreShipment> shipments = namedParameterJdbcTemplate.query("SELECT * from SHIPMENTS", new RowMapper<CoreShipment>() {
            @Override
            public CoreShipment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return ImmutableCoreShipment.builder().destination(resultSet.getString("DESTINATION")).build();
            }
        });

        return Either.right(shipments);
    }
}
