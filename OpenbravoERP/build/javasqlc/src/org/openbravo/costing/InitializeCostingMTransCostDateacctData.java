//Sqlc generated V1.O00-1
package org.openbravo.costing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class InitializeCostingMTransCostDateacctData implements FieldProvider {
static Logger log4j = Logger.getLogger(InitializeCostingMTransCostDateacctData.class);
  private String InitRecordNumber="0";
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InitializeCostingMTransCostDateacctData[] select(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    return select(conn, connectionProvider, 0, 0);
  }

  public static InitializeCostingMTransCostDateacctData[] select(Connection conn, ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select '' as name" +
      "        from dual";

    ResultSet result;
    Vector<InitializeCostingMTransCostDateacctData> vector = new Vector<InitializeCostingMTransCostDateacctData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        InitializeCostingMTransCostDateacctData objectInitializeCostingMTransCostDateacctData = new InitializeCostingMTransCostDateacctData();
        objectInitializeCostingMTransCostDateacctData.name = UtilSql.getValue(result, "name");
        objectInitializeCostingMTransCostDateacctData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInitializeCostingMTransCostDateacctData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    InitializeCostingMTransCostDateacctData objectInitializeCostingMTransCostDateacctData[] = new InitializeCostingMTransCostDateacctData[vector.size()];
    vector.copyInto(objectInitializeCostingMTransCostDateacctData);
    return(objectInitializeCostingMTransCostDateacctData);
  }

  public static int initializeCostingMTransCostDateacct(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE m_transaction_cost" +
      "            SET dateacct = (" +
      "                SELECT m.movementdate " +
      "                FROM m_transaction m " +
      "                WHERE  m.m_transaction_id = m_transaction_cost.m_transaction_id" +
      "                )" +
      "            WHERE dateacct = to_date('01/01/1970', 'DD/MM/YYYY')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int initializeCostingMTransCostDateacct2(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE m_transaction_cost" +
      "        SET dateacct = (" +
      "            SELECT COALESCE (inot.dateacct, m.movementdate)" +
      "            FROM m_transaction_cost mc" +
      "              LEFT JOIN m_transaction m ON m.m_transaction_id = mc.m_transaction_id" +
      "              LEFT JOIN m_inoutline inoutl ON inoutl.m_inoutline_id = m.m_inoutline_id" +
      "              LEFT JOIN m_inout inot ON inoutl.m_inout_id = inot.m_inout_id" +
      "            WHERE m_transaction_cost.m_transaction_cost_id = mc.m_transaction_cost_id" +
      "            )" +
      "        WHERE m_transaction_id in (SELECT m.m_transaction_id" +
      "                                   FROM m_transaction m" +
      "                                     LEFT JOIN m_inoutline inoutl ON inoutl.m_inoutline_id = m.m_inoutline_id" +
      "                                     LEFT JOIN m_inout inot ON inoutl.m_inout_id = inot.m_inout_id" +
      "                                   where  inot.dateacct <> inot.movementdate)";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
