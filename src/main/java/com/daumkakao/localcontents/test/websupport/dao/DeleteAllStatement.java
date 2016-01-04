package com.daumkakao.localcontents.test.websupport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by illy on 2016. 1. 5..
 */
public class DeleteAllStatement implements StatementStrategy {
    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("DELETE FROM users");
        return ps;
    }
}
