//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SEPeriodNoData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEPeriodNoData.class);
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

  public static SEPeriodNoData[] getPeriodNo(ConnectionProvider connectionProvider, String CYearId)    throws ServletException {
    return getPeriodNo(connectionProvider, CYearId, 0, 0);
  }

  public static SEPeriodNoData[] getPeriodNo(ConnectionProvider connectionProvider, String CYearId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Period_ID AS ID, Name AS NAME" +
      "        FROM C_Period" +
      "        WHERE C_Year_ID=?" +
      "        ORDER BY StartDate ASC";

    ResultSet result;
    Vector<SEPeriodNoData> vector = new Vector<SEPeriodNoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CYearId);

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
        SEPeriodNoData objectSEPeriodNoData = new SEPeriodNoData();
        objectSEPeriodNoData.id = UtilSql.getValue(result, "id");
        objectSEPeriodNoData.name = UtilSql.getValue(result, "name");
        objectSEPeriodNoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEPeriodNoData);
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
    SEPeriodNoData objectSEPeriodNoData[] = new SEPeriodNoData[vector.size()];
    vector.copyInto(objectSEPeriodNoData);
    return(objectSEPeriodNoData);
  }

  public static SEPeriodNoData[] getCalendar(ConnectionProvider connectionProvider, String AdOrgId)    throws ServletException {
    return getCalendar(connectionProvider, AdOrgId, 0, 0);
  }

  public static SEPeriodNoData[] getCalendar(ConnectionProvider connectionProvider, String AdOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Org.C_Calendar_ID AS ID, C_Calendar.Name" +
      "        FROM AD_Org, C_Calendar" +
      "        WHERE AD_Org.C_Calendar_ID = C_Calendar.C_Calendar_ID" +
      "        AND AD_Org.AD_Org_ID=AD_ORG_GETCALENDAROWNER(?)";

    ResultSet result;
    Vector<SEPeriodNoData> vector = new Vector<SEPeriodNoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdOrgId);

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
        SEPeriodNoData objectSEPeriodNoData = new SEPeriodNoData();
        objectSEPeriodNoData.id = UtilSql.getValue(result, "id");
        objectSEPeriodNoData.name = UtilSql.getValue(result, "name");
        objectSEPeriodNoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEPeriodNoData);
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
    SEPeriodNoData objectSEPeriodNoData[] = new SEPeriodNoData[vector.size()];
    vector.copyInto(objectSEPeriodNoData);
    return(objectSEPeriodNoData);
  }

  public static SEPeriodNoData[] getYears(ConnectionProvider connectionProvider, String CCalendarId)    throws ServletException {
    return getYears(connectionProvider, CCalendarId, 0, 0);
  }

  public static SEPeriodNoData[] getYears(ConnectionProvider connectionProvider, String CCalendarId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT(C_Year.C_Year_ID) AS ID, C_Year.Year as Name" +
      "        FROM C_Year, AD_Org" +
      "        WHERE AD_Org.C_Calendar_ID=C_Year.C_Calendar_ID" +
      "        AND AD_Org.C_Calendar_ID=?" +
      "        ORDER BY Name DESC";

    ResultSet result;
    Vector<SEPeriodNoData> vector = new Vector<SEPeriodNoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CCalendarId);

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
        SEPeriodNoData objectSEPeriodNoData = new SEPeriodNoData();
        objectSEPeriodNoData.id = UtilSql.getValue(result, "id");
        objectSEPeriodNoData.name = UtilSql.getValue(result, "name");
        objectSEPeriodNoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEPeriodNoData);
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
    SEPeriodNoData objectSEPeriodNoData[] = new SEPeriodNoData[vector.size()];
    vector.copyInto(objectSEPeriodNoData);
    return(objectSEPeriodNoData);
  }
}
