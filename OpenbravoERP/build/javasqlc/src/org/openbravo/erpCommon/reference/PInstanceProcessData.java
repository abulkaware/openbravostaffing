//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.reference;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class PInstanceProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(PInstanceProcessData.class);
  private String InitRecordNumber="0";
  public String result;
  public String errormsg;
  public String pMsg;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("result"))
      return result;
    else if (fieldName.equalsIgnoreCase("errormsg"))
      return errormsg;
    else if (fieldName.equalsIgnoreCase("p_msg") || fieldName.equals("pMsg"))
      return pMsg;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PInstanceProcessData[] select(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    return select(connectionProvider, adPinstanceId, 0, 0);
  }

  public static PInstanceProcessData[] select(ConnectionProvider connectionProvider, String adPinstanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT P.RESULT, REPLACE(REPLACE(P.ERRORMSG, CHR(10), CHR(92) || CHR(92) || 'n'), CHR(13), CHR(92) || CHR(92) || 'n') AS ERRORMSG, " +
      "      '' AS P_MSG " +
      "      FROM AD_PINSTANCE P" +
      "      WHERE P.AD_PINSTANCE_ID = ?";

    ResultSet result;
    Vector<PInstanceProcessData> vector = new Vector<PInstanceProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

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
        PInstanceProcessData objectPInstanceProcessData = new PInstanceProcessData();
        objectPInstanceProcessData.result = UtilSql.getValue(result, "result");
        objectPInstanceProcessData.errormsg = UtilSql.getValue(result, "errormsg");
        objectPInstanceProcessData.pMsg = UtilSql.getValue(result, "p_msg");
        objectPInstanceProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPInstanceProcessData);
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
    PInstanceProcessData objectPInstanceProcessData[] = new PInstanceProcessData[vector.size()];
    vector.copyInto(objectPInstanceProcessData);
    return(objectPInstanceProcessData);
  }

  public static PInstanceProcessData[] select(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    return select(conn, connectionProvider, adPinstanceId, 0, 0);
  }

  public static PInstanceProcessData[] select(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT P.RESULT, REPLACE(REPLACE(P.ERRORMSG, CHR(10), CHR(92) || CHR(92) || 'n'), CHR(13), CHR(92) || CHR(92) || 'n') AS ERRORMSG, " +
      "      '' AS P_MSG " +
      "      FROM AD_PINSTANCE P" +
      "      WHERE P.AD_PINSTANCE_ID = ?";

    ResultSet result;
    Vector<PInstanceProcessData> vector = new Vector<PInstanceProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

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
        PInstanceProcessData objectPInstanceProcessData = new PInstanceProcessData();
        objectPInstanceProcessData.result = UtilSql.getValue(result, "result");
        objectPInstanceProcessData.errormsg = UtilSql.getValue(result, "errormsg");
        objectPInstanceProcessData.pMsg = UtilSql.getValue(result, "p_msg");
        objectPInstanceProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPInstanceProcessData);
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
    PInstanceProcessData objectPInstanceProcessData[] = new PInstanceProcessData[vector.size()];
    vector.copyInto(objectPInstanceProcessData);
    return(objectPInstanceProcessData);
  }

  public static PInstanceProcessData[] selectConnection(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    return selectConnection(conn, connectionProvider, adPinstanceId, 0, 0);
  }

  public static PInstanceProcessData[] selectConnection(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT P.RESULT, REPLACE(REPLACE(P.ERRORMSG, CHR(10), CHR(92) || CHR(92) || 'n'), CHR(13), CHR(92) || CHR(92) || 'n') AS ERRORMSG, " +
      "      '' AS P_MSG " +
      "      FROM AD_PINSTANCE P " +
      "      WHERE P.AD_PINSTANCE_ID = ?";

    ResultSet result;
    Vector<PInstanceProcessData> vector = new Vector<PInstanceProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

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
        PInstanceProcessData objectPInstanceProcessData = new PInstanceProcessData();
        objectPInstanceProcessData.result = UtilSql.getValue(result, "result");
        objectPInstanceProcessData.errormsg = UtilSql.getValue(result, "errormsg");
        objectPInstanceProcessData.pMsg = UtilSql.getValue(result, "p_msg");
        objectPInstanceProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPInstanceProcessData);
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
    PInstanceProcessData objectPInstanceProcessData[] = new PInstanceProcessData[vector.size()];
    vector.copyInto(objectPInstanceProcessData);
    return(objectPInstanceProcessData);
  }

  public static int insertPInstance(ConnectionProvider connectionProvider, String adPinstanceId, String adProcessId, String recordId, String isprocessing, String adUserId, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE (AD_PINSTANCE_ID, AD_PROCESS_ID, RECORD_ID, ISPROCESSING, CREATED, AD_USER_ID, UPDATED, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY)" +
      "      VALUES(?, ?, ?,?,now(), ?,now(), ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertPInstance(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId, String adProcessId, String recordId, String isprocessing, String adUserId, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE (AD_PINSTANCE_ID, AD_PROCESS_ID, RECORD_ID, ISPROCESSING, CREATED, AD_USER_ID, UPDATED, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY)" +
      "      VALUES(?,?,?,?,now(),?,now(), ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprocessing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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

  public static int insertPInstanceParam(ConnectionProvider connectionProvider, String adPinstanceId, String seqno, String parametername, String pString, String adClientId, String adOrgId, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE_PARA (ad_pinstance_para_id, AD_PINSTANCE_ID, SEQNO, PARAMETERNAME, P_STRING, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY)" +
      "      VALUES(get_uuid(), ?,TO_NUMBER(?),?,?, ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parametername);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pString);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertPInstanceParamNumber(ConnectionProvider connectionProvider, String adPinstanceId, String seqno, String parametername, String pNumber, String adClientId, String adOrgId, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE_PARA (ad_pinstance_para_id, AD_PINSTANCE_ID, SEQNO, PARAMETERNAME, P_NUMBER, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY)" +
      "      VALUES(get_uuid(), ?,TO_NUMBER(?),?,TO_NUMBER(?), ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parametername);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertPInstanceParamDate(ConnectionProvider connectionProvider, String adPinstanceId, String seqno, String parametername, String pDate, String adClientId, String adOrgId, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE_PARA (ad_pinstance_para_id, AD_PINSTANCE_ID, SEQNO, PARAMETERNAME, P_DATE, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY)" +
      "      VALUES(get_uuid(),?,TO_NUMBER(?),?,TO_DATE(?), ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parametername);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertPInstanceParamTime(ConnectionProvider connectionProvider, String adPinstanceId, String seqno, String parametername, String pDate, String adClientId, String adOrgId, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE_PARA (ad_pinstance_para_id, AD_PINSTANCE_ID, SEQNO, PARAMETERNAME, P_DATE, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY)" +
      "      VALUES(get_uuid(),?,TO_NUMBER(?),?,to_timestamp(?, 'HH24:MI:SS'), ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parametername);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
