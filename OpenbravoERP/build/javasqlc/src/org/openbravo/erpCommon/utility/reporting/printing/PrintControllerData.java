//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting.printing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PrintControllerData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintControllerData.class);
  private String InitRecordNumber="0";
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PrintControllerData[] selectInvoices(ConnectionProvider connectionProvider, String Id)    throws ServletException {
    return selectInvoices(connectionProvider, Id, 0, 0);
  }

  public static PrintControllerData[] selectInvoices(ConnectionProvider connectionProvider, String Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT C_Invoice_ID as ID" +
      "            FROM C_Invoice" +
      "            WHERE C_Invoice_ID IN (";
    strSql = strSql + ((Id==null || Id.equals(""))?"":Id);
    strSql = strSql + 
      ")" +
      "            ORDER BY DocumentNo ASC";

    ResultSet result;
    Vector<PrintControllerData> vector = new Vector<PrintControllerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (Id != null && !(Id.equals(""))) {
        }

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
        PrintControllerData objectPrintControllerData = new PrintControllerData();
        objectPrintControllerData.id = UtilSql.getValue(result, "id");
        objectPrintControllerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintControllerData);
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
    PrintControllerData objectPrintControllerData[] = new PrintControllerData[vector.size()];
    vector.copyInto(objectPrintControllerData);
    return(objectPrintControllerData);
  }

  public static PrintControllerData[] selectOrders(ConnectionProvider connectionProvider, String Id)    throws ServletException {
    return selectOrders(connectionProvider, Id, 0, 0);
  }

  public static PrintControllerData[] selectOrders(ConnectionProvider connectionProvider, String Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT C_Order_ID as ID" +
      "            FROM C_Order" +
      "            WHERE C_Order_ID IN (";
    strSql = strSql + ((Id==null || Id.equals(""))?"":Id);
    strSql = strSql + 
      ")" +
      "            ORDER BY DocumentNo ASC";

    ResultSet result;
    Vector<PrintControllerData> vector = new Vector<PrintControllerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (Id != null && !(Id.equals(""))) {
        }

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
        PrintControllerData objectPrintControllerData = new PrintControllerData();
        objectPrintControllerData.id = UtilSql.getValue(result, "id");
        objectPrintControllerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintControllerData);
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
    PrintControllerData objectPrintControllerData[] = new PrintControllerData[vector.size()];
    vector.copyInto(objectPrintControllerData);
    return(objectPrintControllerData);
  }

  public static PrintControllerData[] selectPayments(ConnectionProvider connectionProvider, String Id)    throws ServletException {
    return selectPayments(connectionProvider, Id, 0, 0);
  }

  public static PrintControllerData[] selectPayments(ConnectionProvider connectionProvider, String Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT fin_payment_id as ID" +
      "            FROM fin_payment" +
      "            WHERE fin_payment_id IN (";
    strSql = strSql + ((Id==null || Id.equals(""))?"":Id);
    strSql = strSql + 
      ")" +
      "            ORDER BY documentno ASC";

    ResultSet result;
    Vector<PrintControllerData> vector = new Vector<PrintControllerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (Id != null && !(Id.equals(""))) {
        }

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
        PrintControllerData objectPrintControllerData = new PrintControllerData();
        objectPrintControllerData.id = UtilSql.getValue(result, "id");
        objectPrintControllerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintControllerData);
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
    PrintControllerData objectPrintControllerData[] = new PrintControllerData[vector.size()];
    vector.copyInto(objectPrintControllerData);
    return(objectPrintControllerData);
  }

  public static int updateOrderDatePrinted(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Order" +
      "        SET DATEPRINTED=now() WHERE C_Order_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
