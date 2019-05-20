//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DropRegFactAcctData implements FieldProvider {
static Logger log4j = Logger.getLogger(DropRegFactAcctData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String regFactAcctGroupId;
  public String closeFactAcctGroupId;
  public String divideupFactAcctGroupId;
  public String openFactAcctGroupId;
  public String adOrgClosingId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("reg_fact_acct_group_id") || fieldName.equals("regFactAcctGroupId"))
      return regFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("close_fact_acct_group_id") || fieldName.equals("closeFactAcctGroupId"))
      return closeFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("divideup_fact_acct_group_id") || fieldName.equals("divideupFactAcctGroupId"))
      return divideupFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("open_fact_acct_group_id") || fieldName.equals("openFactAcctGroupId"))
      return openFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("ad_org_closing_id") || fieldName.equals("adOrgClosingId"))
      return adOrgClosingId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DropRegFactAcctData[] select(ConnectionProvider connectionProvider, String adlanguage, String cYearId)    throws ServletException {
    return select(connectionProvider, adlanguage, cYearId, 0, 0);
  }

  public static DropRegFactAcctData[] select(ConnectionProvider connectionProvider, String adlanguage, String cYearId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT AD_ORG_CLOSING.AD_ORG_ID AS ID, AD_COLUMN_IDENTIFIER('AD_ORG', AD_ORG_CLOSING.AD_ORG_ID, ?) AS NAME," +
      "		'' AS REG_FACT_ACCT_GROUP_ID, '' AS CLOSE_FACT_ACCT_GROUP_ID, '' AS DIVIDEUP_FACT_ACCT_GROUP_ID," +
      "		'' AS OPEN_FACT_ACCT_GROUP_ID, '' AS AD_ORG_CLOSING_ID" +
      "        FROM AD_ORG_CLOSING" +
      "        WHERE C_YEAR_ID = ?";

    ResultSet result;
    Vector<DropRegFactAcctData> vector = new Vector<DropRegFactAcctData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);

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
        DropRegFactAcctData objectDropRegFactAcctData = new DropRegFactAcctData();
        objectDropRegFactAcctData.id = UtilSql.getValue(result, "id");
        objectDropRegFactAcctData.name = UtilSql.getValue(result, "name");
        objectDropRegFactAcctData.regFactAcctGroupId = UtilSql.getValue(result, "reg_fact_acct_group_id");
        objectDropRegFactAcctData.closeFactAcctGroupId = UtilSql.getValue(result, "close_fact_acct_group_id");
        objectDropRegFactAcctData.divideupFactAcctGroupId = UtilSql.getValue(result, "divideup_fact_acct_group_id");
        objectDropRegFactAcctData.openFactAcctGroupId = UtilSql.getValue(result, "open_fact_acct_group_id");
        objectDropRegFactAcctData.adOrgClosingId = UtilSql.getValue(result, "ad_org_closing_id");
        objectDropRegFactAcctData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDropRegFactAcctData);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    DropRegFactAcctData objectDropRegFactAcctData[] = new DropRegFactAcctData[vector.size()];
    vector.copyInto(objectDropRegFactAcctData);
    return(objectDropRegFactAcctData);
  }

  public static int updatePeriodsOpen(Connection conn, ConnectionProvider connectionProvider, String user, String cYearId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PERIODCONTROL" +
      "        SET PERIODSTATUS = 'C', UPDATED = now(), UPDATEDBY = ?" +
      "        WHERE C_PERIOD_ID IN (SELECT C_PERIOD_ID" +
      "                FROM C_PERIOD" +
      "                WHERE C_YEAR_ID = ?)" +
      "        AND AD_ORG_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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

  public static DropRegFactAcctData[] selectFactAcctGroupId(ConnectionProvider connectionProvider, String adOrgId, String cYearId)    throws ServletException {
    return selectFactAcctGroupId(connectionProvider, adOrgId, cYearId, 0, 0);
  }

  public static DropRegFactAcctData[] selectFactAcctGroupId(ConnectionProvider connectionProvider, String adOrgId, String cYearId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT REG_FACT_ACCT_GROUP_ID, CLOSE_FACT_ACCT_GROUP_ID, DIVIDEUP_FACT_ACCT_GROUP_ID, OPEN_FACT_ACCT_GROUP_ID, AD_ORG_CLOSING_ID" +
      "        FROM AD_ORG_CLOSING" +
      "        WHERE AD_ORG_ID = ?" +
      "        AND C_YEAR_ID = ?";

    ResultSet result;
    Vector<DropRegFactAcctData> vector = new Vector<DropRegFactAcctData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);

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
        DropRegFactAcctData objectDropRegFactAcctData = new DropRegFactAcctData();
        objectDropRegFactAcctData.regFactAcctGroupId = UtilSql.getValue(result, "reg_fact_acct_group_id");
        objectDropRegFactAcctData.closeFactAcctGroupId = UtilSql.getValue(result, "close_fact_acct_group_id");
        objectDropRegFactAcctData.divideupFactAcctGroupId = UtilSql.getValue(result, "divideup_fact_acct_group_id");
        objectDropRegFactAcctData.openFactAcctGroupId = UtilSql.getValue(result, "open_fact_acct_group_id");
        objectDropRegFactAcctData.adOrgClosingId = UtilSql.getValue(result, "ad_org_closing_id");
        objectDropRegFactAcctData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDropRegFactAcctData);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    DropRegFactAcctData objectDropRegFactAcctData[] = new DropRegFactAcctData[vector.size()];
    vector.copyInto(objectDropRegFactAcctData);
    return(objectDropRegFactAcctData);
  }

  public static int deleteOrgClosing(Connection conn, ConnectionProvider connectionProvider, String adOrgClosingId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  DELETE FROM AD_ORG_CLOSING WHERE AD_ORG_CLOSING_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgClosingId);

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

  public static int deleteFactAcctClose(Connection conn, ConnectionProvider connectionProvider, String fact_acct_group_id, String open_acct_group_id, String divideup_fact_acct_group_id, String reg_fact_acct_group_id, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  DELETE FROM FACT_ACCT" +
      "	  WHERE FACT_ACCT_GROUP_ID IN (?, ?, ?, ?)" +
      "  	  AND AD_ISORGINCLUDED(FACT_ACCT.AD_ORG_ID, ?, FACT_ACCT.AD_CLIENT_ID)<>-1";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, open_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideup_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reg_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
