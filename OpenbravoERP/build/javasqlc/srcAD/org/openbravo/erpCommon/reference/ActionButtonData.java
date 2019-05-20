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
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

public class ActionButtonData implements FieldProvider {
static Logger log4j = Logger.getLogger(ActionButtonData.class);
  private String InitRecordNumber="0";
  public String dummy;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dummy"))
      return dummy;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
empty select
 */
  public static ActionButtonData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

/**
empty select
 */
  public static ActionButtonData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM DUAL";

    ResultSet result;
    Vector<ActionButtonData> vector = new Vector<ActionButtonData>(0);
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
        ActionButtonData objectActionButtonData = new ActionButtonData();
        objectActionButtonData.dummy = UtilSql.getValue(result, "dummy");
        objectActionButtonData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActionButtonData);
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
    ActionButtonData objectActionButtonData[] = new ActionButtonData[vector.size()];
    vector.copyInto(objectActionButtonData);
    return(objectActionButtonData);
  }

/**
procedure C_YearPeriods
 */
  public static ActionButtonData process100(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_YearPeriods(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_UPDATE_PARETO_PRODUCT0LEGACY
 */
  public static ActionButtonData process1000500001(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_UPDATE_PARETO_PRODUCT0LEGACY(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_TAXPAYMENT_POST
 */
  public static ActionButtonData process1003900000(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_TAXPAYMENT_POST(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Requisition_CreatePO
 */
  public static ActionButtonData process1004400000(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Requisition_CreatePO(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_RequisitionLine_Status0
 */
  public static ActionButtonData process1004400002(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_RequisitionLine_Status0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Requisition_Post
 */
  public static ActionButtonData process1004400003(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Requisition_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure 
 */
  public static ActionButtonData process1004400004(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL (?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_DiscountSchema_ReSeq
 */
  public static ActionButtonData process101(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_DiscountSchema_ReSeq(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_PriceList_Create
 */
  public static ActionButtonData process103(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_PriceList_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Order_Post
 */
  public static ActionButtonData process104(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Order_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Inventory_ListCreate
 */
  public static ActionButtonData process105(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Inventory_ListCreate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Inventory_ListUpdate
 */
  public static ActionButtonData process106(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Inventory_ListUpdate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_AcctSchema_Default_Copy
 */
  public static ActionButtonData process108(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_AcctSchema_Default_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_InOut_Post0
 */
  public static ActionButtonData process109(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_InOut_Post0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Invoice_Post0
 */
  public static ActionButtonData process111(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Post0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_BP_Group_Acct_Copy
 */
  public static ActionButtonData process112(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_BP_Group_Acct_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Window_Copy
 */
  public static ActionButtonData process113(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Window_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Tab_Copy
 */
  public static ActionButtonData process114(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Tab_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Invoice_Create0
 */
  public static ActionButtonData process119(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Create0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Movement_Post
 */
  public static ActionButtonData process122(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Movement_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Commission_Process
 */
  public static ActionButtonData process123(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Commission_Process(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Invoice_Create0
 */
  public static ActionButtonData process134(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Create0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Production_Run
 */
  public static ActionButtonData process137(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Production_Run(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Product_Category_Acct_Copy
 */
  public static ActionButtonData process140(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Product_Category_Acct_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Invoice_CreateReceipt
 */
  public static ActionButtonData process142(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_CreateReceipt(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Cash_Post
 */
  public static ActionButtonData process144(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Cash_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_BankStatement_Post
 */
  public static ActionButtonData process147(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_BankStatement_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_InOut_CreateInvoice
 */
  public static ActionButtonData process154(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_InOut_CreateInvoice(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_PaySelection_Post
 */
  public static ActionButtonData process155(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_PaySelection_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_GenerateSOFromProjectOrder
 */
  public static ActionButtonData process164(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_GenerateSOFromProjectOrder(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Commission_Copy
 */
  public static ActionButtonData process165(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Commission_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_CommissionRun_Process
 */
  public static ActionButtonData process166(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_CommissionRun_Process(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Period_Process
 */
  public static ActionButtonData process167(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Period_Process(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_PeriodControl_Process
 */
  public static ActionButtonData process168(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_PeriodControl_Process(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure GL_Journal_Post0
 */
  public static ActionButtonData process169(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL GL_Journal_Post0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Synchronize
 */
  public static ActionButtonData process172(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Synchronize(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Table_Import0
 */
  public static ActionButtonData process173(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Table_Import0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Tab_Import0
 */
  public static ActionButtonData process174(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Tab_Import0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure Fact_Acct_Reset
 */
  public static ActionButtonData process175(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL Fact_Acct_Reset(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Language_Create
 */
  public static ActionButtonData process179(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Language_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure T_InventoryValue_Create
 */
  public static ActionButtonData process180(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL T_InventoryValue_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Product_CostingUpdate
 */
  public static ActionButtonData process182(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Product_CostingUpdate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure S_TimeExpense_Post
 */
  public static ActionButtonData process184(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL S_TimeExpense_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure DBA_Recompile
 */
  public static ActionButtonData process185(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL DBA_Recompile(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure GL_JournalBatch_Post
 */
  public static ActionButtonData process188(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL GL_JournalBatch_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Order_PO_Create
 */
  public static ActionButtonData process193(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Order_PO_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_InOut_Create0
 */
  public static ActionButtonData process199(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_InOut_Create0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_GenerateSOFromProjectPhase
 */
  public static ActionButtonData process216(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_GenerateSOFromProjectPhase(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Org_Ready
 */
  public static ActionButtonData process53863D4359114ADE92133F772135AEEB(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Org_Ready(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Reservation_Post0
 */
  public static ActionButtonData process5A2A0AF88AF54BB085DCC52FCC9B17B7(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Reservation_Post0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Create_Audit_Triggers
 */
  public static ActionButtonData process65D1E895C7FD47B48F3D18BC9E28BE9F(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Create_Audit_Triggers(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_INVEXPLODEBOMNOTSTOCK
 */
  public static ActionButtonData process6E1ADD5C8B6B4ACB82237DAA8114451E(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_INVEXPLODEBOMNOTSTOCK(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_ChangeProjectStatus
 */
  public static ActionButtonData process800002(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_ChangeProjectStatus(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Copy_Project_Lines
 */
  public static ActionButtonData process800003(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Copy_Project_Lines(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure 
 */
  public static ActionButtonData process800004(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL (?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_GenerateSOFromProject
 */
  public static ActionButtonData process800005(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_GenerateSOFromProject(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_GeneratePOFromProject
 */
  public static ActionButtonData process800006(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_GeneratePOFromProject(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_InOut_UpdateQuantityes
 */
  public static ActionButtonData process800010(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_InOut_UpdateQuantityes(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Copy_Product_Template
 */
  public static ActionButtonData process800022(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Copy_Product_Template(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Debt_Payment_Change
 */
  public static ActionButtonData process800024(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Debt_Payment_Change(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Settlement_Post0
 */
  public static ActionButtonData process800025(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Settlement_Post0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Move_Locator
 */
  public static ActionButtonData process800048(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Move_Locator(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Rappel_Invoice_Create
 */
  public static ActionButtonData process800068(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Rappel_Invoice_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_PriceListVersionGenerate
 */
  public static ActionButtonData process800069(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_PriceListVersionGenerate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Create_PInvoice_From_Outs
 */
  public static ActionButtonData process800075(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Create_PInvoice_From_Outs(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Debt_Payment_Balancing_Rep
 */
  public static ActionButtonData process800077(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Debt_Payment_Balancing_Rep(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Generate_Average_Costs
 */
  public static ActionButtonData process800085(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Generate_Average_Costs(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure AD_Update_Table_Identifier0
 */
  public static ActionButtonData process800087(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Update_Table_Identifier0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Project_Won
 */
  public static ActionButtonData process800094(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Project_Won(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_WorkRequirement_Process
 */
  public static ActionButtonData process800103(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_WorkRequirement_Process(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_ProductionRun_Standard
 */
  public static ActionButtonData process800105(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_ProductionRun_Standard(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_WorkEffort_Validate
 */
  public static ActionButtonData process800106(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_WorkEffort_Validate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure Ma_Standard_Cost
 */
  public static ActionButtonData process800109(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL Ma_Standard_Cost(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_Copy_Version
 */
  public static ActionButtonData process800112(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_Copy_Version(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_Measure_Time_Explode0
 */
  public static ActionButtonData process800114(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_Measure_Time_Explode0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_WorkRequirement_Close
 */
  public static ActionButtonData process800117(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_WorkRequirement_Close(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_WRPhase_Close
 */
  public static ActionButtonData process800118(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_WRPhase_Close(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_PC_CASE_CREATE
 */
  public static ActionButtonData process800120(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_PC_CASE_CREATE(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure A_Asset_Post0
 */
  public static ActionButtonData process800125(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL A_Asset_Post0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Debt_Payment_Create
 */
  public static ActionButtonData process800126(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Debt_Payment_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_Measure_Shift_Explode
 */
  public static ActionButtonData process800127(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_Measure_Shift_Explode(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_Maint_All
 */
  public static ActionButtonData process800130(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_Maint_All(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Internal_Consumption_Post
 */
  public static ActionButtonData process800131(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Internal_Consumption_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure A_Amortization_Process
 */
  public static ActionButtonData process800134(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL A_Amortization_Process(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Budget_Copy
 */
  public static ActionButtonData process800135(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Budget_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure A_Asset_Group_Acct_Copy
 */
  public static ActionButtonData process800136(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL A_Asset_Group_Acct_Copy(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_DP_Management_Post
 */
  public static ActionButtonData process800140(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_DP_Management_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Freight_Calculate
 */
  public static ActionButtonData process800141(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Freight_Calculate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_Remittance_Post
 */
  public static ActionButtonData process800142(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Remittance_Post(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_Production_Cost_Generate
 */
  public static ActionButtonData process800151(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_Production_Cost_Generate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MA_Indirect_Cost_Calculate
 */
  public static ActionButtonData process800152(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MA_Indirect_Cost_Calculate(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MRP_Requisition
 */
  public static ActionButtonData process800159(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MRP_Requisition(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MRP_WorkRequirement
 */
  public static ActionButtonData process800160(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MRP_WorkRequirement(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MRP_ProcessPlan_Recalculate0
 */
  public static ActionButtonData process800161(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MRP_ProcessPlan_Recalculate0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MRP_Production_Run
 */
  public static ActionButtonData process800162(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MRP_Production_Run(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MRP_PurchaseOrder
 */
  public static ActionButtonData process800163(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MRP_PurchaseOrder(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure MRP_Purchase_Run
 */
  public static ActionButtonData process800164(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL MRP_Purchase_Run(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_UPDATE_PARETO_PRODUCT0
 */
  public static ActionButtonData process9CD67D41E43242CDA034FB994B75812A(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_UPDATE_PARETO_PRODUCT0(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure 
 */
  public static ActionButtonData processD234AE084F7040DCB66E281A4237FF99(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL (?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure C_PayInAdvance_Create
 */
  public static ActionButtonData processD56220370A774B7FA51323BE3C6E0F22(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_PayInAdvance_Create(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_INOUTEXPLODEBOMNOTSTOCK
 */
  public static ActionButtonData processDAE719940FE9463F8A3E3C401BBAFC53(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_INOUTEXPLODEBOMNOTSTOCK(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_EXPLODEBOMNOTSTOCK
 */
  public static ActionButtonData processDFC78024B1F54CBB95DC73425BA6687F(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_EXPLODEBOMNOTSTOCK(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }

/**
procedure M_Get_Stock
 */
  public static ActionButtonData processFF80818132C964E30132C9747257002E(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_Get_Stock(?)";

    ActionButtonData objectActionButtonData = new ActionButtonData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectActionButtonData);
  }
}
