//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ShowSessionVariablesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ShowSessionVariablesData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ShowSessionVariablesData[] select(ConnectionProvider connectionProvider, String windows)    throws ServletException {
    return select(connectionProvider, windows, 0, 0);
  }

  public static ShowSessionVariablesData[] select(ConnectionProvider connectionProvider, String windows, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_WINDOW_ID AS ID, NAME FROM AD_WINDOW WHERE ISACTIVE='Y' ";
    strSql = strSql + ((windows==null || windows.equals(""))?"":" AND AD_WINDOW.AD_WINDOW_ID IN " + windows);
    strSql = strSql + 
      "      ORDER BY NAME";

    ResultSet result;
    Vector<ShowSessionVariablesData> vector = new Vector<ShowSessionVariablesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (windows != null && !(windows.equals(""))) {
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
        ShowSessionVariablesData objectShowSessionVariablesData = new ShowSessionVariablesData();
        objectShowSessionVariablesData.id = UtilSql.getValue(result, "id");
        objectShowSessionVariablesData.name = UtilSql.getValue(result, "name");
        objectShowSessionVariablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShowSessionVariablesData);
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
    ShowSessionVariablesData objectShowSessionVariablesData[] = new ShowSessionVariablesData[vector.size()];
    vector.copyInto(objectShowSessionVariablesData);
    return(objectShowSessionVariablesData);
  }

  public static ShowSessionVariablesData[] selectTrl(ConnectionProvider connectionProvider, String windows, String adLanguage)    throws ServletException {
    return selectTrl(connectionProvider, windows, adLanguage, 0, 0);
  }

  public static ShowSessionVariablesData[] selectTrl(ConnectionProvider connectionProvider, String windows, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_WINDOW.AD_WINDOW_ID AS ID, (CASE WHEN AD_WINDOW_TRL.NAME IS NULL THEN AD_WINDOW.NAME ELSE AD_WINDOW_TRL.NAME END) AS NAME " +
      "      FROM AD_WINDOW, AD_WINDOW_TRL " +
      "      WHERE AD_WINDOW.ISACTIVE='Y' ";
    strSql = strSql + ((windows==null || windows.equals(""))?"":" AND AD_WINDOW.AD_WINDOW_ID IN " + windows);
    strSql = strSql + 
      "      AND AD_WINDOW.AD_WINDOW_ID = AD_WINDOW_TRL.AD_WINDOW_ID" +
      "      AND AD_WINDOW_TRL.AD_LANGUAGE = ? " +
      "      ORDER BY 2";

    ResultSet result;
    Vector<ShowSessionVariablesData> vector = new Vector<ShowSessionVariablesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (windows != null && !(windows.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

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
        ShowSessionVariablesData objectShowSessionVariablesData = new ShowSessionVariablesData();
        objectShowSessionVariablesData.id = UtilSql.getValue(result, "id");
        objectShowSessionVariablesData.name = UtilSql.getValue(result, "name");
        objectShowSessionVariablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShowSessionVariablesData);
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
    ShowSessionVariablesData objectShowSessionVariablesData[] = new ShowSessionVariablesData[vector.size()];
    vector.copyInto(objectShowSessionVariablesData);
    return(objectShowSessionVariablesData);
  }
}
