//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class AcctServerProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(AcctServerProcessData.class);
  private String InitRecordNumber="0";
  public String adUserId;
  public String adOrgId;
  public String adTableId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AcctServerProcessData[] selectUserOrg(ConnectionProvider connectionProvider, String adProcessId)    throws ServletException {
    return selectUserOrg(connectionProvider, adProcessId, 0, 0);
  }

  public static AcctServerProcessData[] selectUserOrg(ConnectionProvider connectionProvider, String adProcessId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT CREATEDBY AS AD_USER_ID, AD_ORG_ID, '' AS AD_TABLE_ID FROM AD_PROCESS" +
      "      WHERE AD_PROCESS_ID = ?";

    ResultSet result;
    Vector<AcctServerProcessData> vector = new Vector<AcctServerProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

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
        AcctServerProcessData objectAcctServerProcessData = new AcctServerProcessData();
        objectAcctServerProcessData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectAcctServerProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAcctServerProcessData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectAcctServerProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerProcessData);
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
    AcctServerProcessData objectAcctServerProcessData[] = new AcctServerProcessData[vector.size()];
    vector.copyInto(objectAcctServerProcessData);
    return(objectAcctServerProcessData);
  }

  public static String selectTable(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT P_STRING FROM AD_PINSTANCE_PARA" +
      "      WHERE AD_PINSTANCE_ID = ?" +
      "      AND PARAMETERNAME = 'AD_Table_ID'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_string");
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
    return(strReturn);
  }

  public static AcctServerProcessData[] selectAcctTable(ConnectionProvider connectionProvider)    throws ServletException {
    return selectAcctTable(connectionProvider, 0, 0);
  }

  public static AcctServerProcessData[] selectAcctTable(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT ad_table_id" +
      "      FROM C_ACCTSCHEMA_TABLE" +
      "      WHERE isactive = 'Y'" +
      "      AND isBackgroundDisabled = 'N'" +
      "      ORDER BY ad_table_id";

    ResultSet result;
    Vector<AcctServerProcessData> vector = new Vector<AcctServerProcessData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
        AcctServerProcessData objectAcctServerProcessData = new AcctServerProcessData();
        objectAcctServerProcessData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectAcctServerProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerProcessData);
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
    AcctServerProcessData objectAcctServerProcessData[] = new AcctServerProcessData[vector.size()];
    vector.copyInto(objectAcctServerProcessData);
    return(objectAcctServerProcessData);
  }

  public static AcctServerProcessData[] selectAcctTable(ConnectionProvider connectionProvider, String client)    throws ServletException {
    return selectAcctTable(connectionProvider, client, 0, 0);
  }

  public static AcctServerProcessData[] selectAcctTable(ConnectionProvider connectionProvider, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT ad_table_id" +
      "      FROM C_ACCTSCHEMA_TABLE" +
      "      WHERE isactive = 'Y'" +
      "      AND isBackgroundDisabled = 'N'" +
      "      AND AD_Client_ID = ?" +
      "      ORDER BY ad_table_id";

    ResultSet result;
    Vector<AcctServerProcessData> vector = new Vector<AcctServerProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        AcctServerProcessData objectAcctServerProcessData = new AcctServerProcessData();
        objectAcctServerProcessData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectAcctServerProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerProcessData);
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
    AcctServerProcessData objectAcctServerProcessData[] = new AcctServerProcessData[vector.size()];
    vector.copyInto(objectAcctServerProcessData);
    return(objectAcctServerProcessData);
  }

  public static AcctServerProcessData[] selectAcctTable(ConnectionProvider connectionProvider, String client, String org)    throws ServletException {
    return selectAcctTable(connectionProvider, client, org, 0, 0);
  }

  public static AcctServerProcessData[] selectAcctTable(ConnectionProvider connectionProvider, String client, String org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT at.ad_table_id" +
      "      FROM c_acctschema_table at" +
      "      WHERE at.isactive = 'Y'" +
      "      AND at.ad_client_id = ?" +
      "      AND EXISTS (" +
      "        SELECT 1" +
      "        FROM c_acctschema a" +
      "        JOIN ad_org_acctschema oa" +
      "        ON a.c_acctschema_id = oa.c_acctschema_id" +
      "        WHERE at.c_acctschema_id = a.c_acctschema_id" +
      "        AND (ad_org_isinnaturaltree(?, oa.ad_org_id, oa.ad_client_id) = 'Y')" +
      "        AND a.isactive = 'Y'" +
      "        AND oa.isactive = 'Y'" +
      "      )" +
      "      GROUP BY at.ad_table_id" +
      "      HAVING sum(case when at.isBackgroundDisabled = 'N' then 1 else 0 end) > 0" +
      "      AND sum(case when at.isBackgroundDisabled = 'Y' then 1 else 0 end) = 0" +
      "      ORDER BY at.ad_table_id";

    ResultSet result;
    Vector<AcctServerProcessData> vector = new Vector<AcctServerProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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
        AcctServerProcessData objectAcctServerProcessData = new AcctServerProcessData();
        objectAcctServerProcessData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectAcctServerProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctServerProcessData);
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
    AcctServerProcessData objectAcctServerProcessData[] = new AcctServerProcessData[vector.size()];
    vector.copyInto(objectAcctServerProcessData);
    return(objectAcctServerProcessData);
  }

  public static String selectDescription(ConnectionProvider connectionProvider, String language, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT (case when ad_table.po_window_id is null then '' else ad_column_identifier('AD_Window',TO_CHAR(ad_table.po_window_id),?) end)||" +
      "                  (case when ad_table.po_window_id is null then '' else ' - ' end)||" +
      "                  ad_column_identifier('AD_Window',TO_CHAR(ad_table.ad_window_id),?)" +
      "                FROM AD_TABLE" +
      "                WHERE AD_TABLE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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
    return(strReturn);
  }

  public static String selectOrg(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT P_STRING FROM AD_PINSTANCE_PARA" +
      "       WHERE AD_PINSTANCE_ID = ?" +
      "       AND PARAMETERNAME = 'AD_Org_ID'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_string");
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
    return(strReturn);
  }

  public static String selectDateFrom(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT P_STRING FROM AD_PINSTANCE_PARA" +
      "       WHERE AD_PINSTANCE_ID = ?" +
      "       AND PARAMETERNAME = 'DateFrom'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_string");
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
    return(strReturn);
  }

  public static String selectDateTo(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT P_STRING FROM AD_PINSTANCE_PARA" +
      "       WHERE AD_PINSTANCE_ID = ?" +
      "       AND PARAMETERNAME = 'DateTo'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_string");
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
    return(strReturn);
  }

  public static boolean useRequestProcessOrg(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) as exist" +
      "        FROM DUAL" +
      "        WHERE EXISTS (SELECT 1 FROM ad_preference" +
      "                      WHERE attribute = 'UseRequestOrganizationExecutingRequestProcess')";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "exist").equals("0");
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
    return(boolReturn);
  }
}
