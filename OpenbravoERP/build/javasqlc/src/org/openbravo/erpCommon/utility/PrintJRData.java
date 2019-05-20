//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class PrintJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintJRData.class);
  private String InitRecordNumber="0";
  public String paramname;
  public String reference;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("paramname"))
      return paramname;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PrintJRData[] getProcessParams(ConnectionProvider connectionProvider, String adProcessId)    throws ServletException {
    return getProcessParams(connectionProvider, adProcessId, 0, 0);
  }

  public static PrintJRData[] getProcessParams(ConnectionProvider connectionProvider, String adProcessId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select columnname AS paramname, AD_Reference_ID AS reference " +
      "        FROM AD_Process_Para " +
      "        WHERE AD_Process_ID = ? ";

    ResultSet result;
    Vector<PrintJRData> vector = new Vector<PrintJRData>(0);
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
        PrintJRData objectPrintJRData = new PrintJRData();
        objectPrintJRData.paramname = UtilSql.getValue(result, "paramname");
        objectPrintJRData.reference = UtilSql.getValue(result, "reference");
        objectPrintJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintJRData);
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
    PrintJRData objectPrintJRData[] = new PrintJRData[vector.size()];
    vector.copyInto(objectPrintJRData);
    return(objectPrintJRData);
  }

  public static String getReportName(ConnectionProvider connectionProvider, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select JRName AS paramname" +
      "        FROM AD_Process " +
      "        WHERE AD_Process_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paramname");
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

  public static String getReportTitle(ConnectionProvider connectionProvider, String adLanguage, String adProcessId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select COALESCE(pt.name, p.name) AS paramname" +
      "              FROM  ad_process p LEFT JOIN AD_process_Trl pt ON p.AD_process_ID  = pt.AD_process_ID" +
      "                                  AND pt.AD_Language = ?" +
      "              where p.ad_process_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "paramname");
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
}
