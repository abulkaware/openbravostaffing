//Sqlc generated V1.O00-1
package org.openbravo.materialmgmt;

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

class ReservationUtilsData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReservationUtilsData.class);
  private String InitRecordNumber="0";
  public String a;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("a"))
      return a;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReservationUtilsData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ReservationUtilsData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select 1 as a from dual";

    ResultSet result;
    Vector<ReservationUtilsData> vector = new Vector<ReservationUtilsData>(0);
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
        ReservationUtilsData objectReservationUtilsData = new ReservationUtilsData();
        objectReservationUtilsData.a = UtilSql.getValue(result, "a");
        objectReservationUtilsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReservationUtilsData);
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
    ReservationUtilsData objectReservationUtilsData[] = new ReservationUtilsData[vector.size()];
    vector.copyInto(objectReservationUtilsData);
    return(objectReservationUtilsData);
  }

  public static CSResponse createReserveFromSalesOrderLine(Connection conn, ConnectionProvider connectionProvider, String cOrderLineId, String doProcess, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_CREATE_RESERVE_FROM_SOL(?,?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doProcess);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      int iParameterreturnValue = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
      objectCSResponse.returnValue= UtilSql.getStringCallableStatement(st, iParameterreturnValue);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(cOrderLineId);
      parametersTypes.addElement("in");
      parametersData.addElement(doProcess);
      parametersTypes.addElement("in");
      parametersData.addElement(adUserId);
      parametersTypes.addElement("in");
      parametersData.addElement("returnValue");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.returnValue = vecTotal.elementAt(0);
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
    return(objectCSResponse);
  }

  public static CSResponse reserveStockAuto(Connection conn, ConnectionProvider connectionProvider, String mReservationId, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_RESERVE_STOCK_AUTO(?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mReservationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      int iParameterreturnValue = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
      objectCSResponse.returnValue= UtilSql.getStringCallableStatement(st, iParameterreturnValue);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(mReservationId);
      parametersTypes.addElement("in");
      parametersData.addElement(adUserId);
      parametersTypes.addElement("in");
      parametersData.addElement("returnValue");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.returnValue = vecTotal.elementAt(0);
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
    return(objectCSResponse);
  }

  public static CSResponse reserveStockManual(Connection conn, ConnectionProvider connectionProvider, String mReservationId, String type, String stockId, String quantity, String adUserId, String allocated)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_RESERVE_STOCK_MANUAL(?,?,?,to_number(?),?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mReservationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allocated);
      int iParameterreturnValue = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
      objectCSResponse.returnValue= UtilSql.getStringCallableStatement(st, iParameterreturnValue);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(mReservationId);
      parametersTypes.addElement("in");
      parametersData.addElement(type);
      parametersTypes.addElement("in");
      parametersData.addElement(stockId);
      parametersTypes.addElement("in");
      parametersData.addElement(quantity);
      parametersTypes.addElement("in");
      parametersData.addElement(adUserId);
      parametersTypes.addElement("in");
      parametersData.addElement(allocated);
      parametersTypes.addElement("in");
      parametersData.addElement("returnValue");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.returnValue = vecTotal.elementAt(0);
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
    return(objectCSResponse);
  }

  public static CSResponse reallocateStock(Connection conn, ConnectionProvider connectionProvider, String mReservationId, String mLocatorId, String mAttributeSetInstanceId, String quantity, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_RESERVATION_REALLOCATE(?, ?, ?, to_number(?), ?, ?, ?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mReservationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      int iParameterreturnValue = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      int iParameterreturnValueMsg = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
      objectCSResponse.returnValue= UtilSql.getStringCallableStatement(st, iParameterreturnValue);
      objectCSResponse.returnValueMsg= UtilSql.getStringCallableStatement(st, iParameterreturnValueMsg);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(mReservationId);
      parametersTypes.addElement("in");
      parametersData.addElement(mLocatorId);
      parametersTypes.addElement("in");
      parametersData.addElement(mAttributeSetInstanceId);
      parametersTypes.addElement("in");
      parametersData.addElement(quantity);
      parametersTypes.addElement("in");
      parametersData.addElement(adUserId);
      parametersTypes.addElement("in");
      parametersData.addElement("returnValue");
      parametersTypes.addElement("out");
      parametersData.addElement("returnValueMsg");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 2);
      objectCSResponse.returnValue = vecTotal.elementAt(0);
      objectCSResponse.returnValueMsg = vecTotal.elementAt(1);
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
    return(objectCSResponse);
  }
}
