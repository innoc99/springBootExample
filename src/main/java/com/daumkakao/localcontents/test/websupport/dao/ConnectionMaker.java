package com.daumkakao.localcontents.test.websupport.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by illy on 2016. 1. 4..
 */
public interface ConnectionMaker {
    Connection makeConnection() throws ClassNotFoundException, SQLException;

}
