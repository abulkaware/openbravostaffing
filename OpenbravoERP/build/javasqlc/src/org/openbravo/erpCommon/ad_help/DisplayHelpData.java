//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_help;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DisplayHelpData implements FieldProvider {
static Logger log4j = Logger.getLogger(DisplayHelpData.class);
  private String InitRecordNumber="0";
  public String tabid;
  public String tabname;
  public String tabhelp;
  public String tabhelpname;
  public String tabidname;
  public String fieldid;
  public String fieldname;
  public String fieldhelp;
  public String fieldhelpname;
  public String fieldidname;
  public String windowname;
  public String moduleid;
  public String basename;
  public String name;
  public String help;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tabid"))
      return tabid;
    else if (fieldName.equalsIgnoreCase("tabname"))
      return tabname;
    else if (fieldName.equalsIgnoreCase("tabhelp"))
      return tabhelp;
    else if (fieldName.equalsIgnoreCase("tabhelpname"))
      return tabhelpname;
    else if (fieldName.equalsIgnoreCase("tabidname"))
      return tabidname;
    else if (fieldName.equalsIgnoreCase("fieldid"))
      return fieldid;
    else if (fieldName.equalsIgnoreCase("fieldname"))
      return fieldname;
    else if (fieldName.equalsIgnoreCase("fieldhelp"))
      return fieldhelp;
    else if (fieldName.equalsIgnoreCase("fieldhelpname"))
      return fieldhelpname;
    else if (fieldName.equalsIgnoreCase("fieldidname"))
      return fieldidname;
    else if (fieldName.equalsIgnoreCase("windowname"))
      return windowname;
    else if (fieldName.equalsIgnoreCase("moduleid"))
      return moduleid;
    else if (fieldName.equalsIgnoreCase("basename"))
      return basename;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DisplayHelpData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String windowId)    throws ServletException {
    return selectTrl(connectionProvider, adLanguage, windowId, 0, 0);
  }

  public static DisplayHelpData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String windowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TAB.ad_tab_id AS tabid, " +
      "        COALESCE(AD_TAB_TRL.NAME, AD_TAB.NAME) AS tabname," +
      "        COALESCE(AD_TAB_TRL.HELP, AD_TAB.HELP) AS tabhelp," +
      "        ('paramTabHelp' || AD_TAB.AD_TAB_ID) AS tabhelpname, " +
      "        ('paramTabName' || AD_TAB.AD_TAB_ID) AS tabidname, " +
      "        AD_FIELD.ad_field_id AS fieldid, " +
      "        COALESCE(AD_FIELD_TRL.NAME, AD_FIELD.NAME) AS fieldname," +
      "        COALESCE(AD_FIELD_TRL.HELP, AD_FIELD.HELP) AS fieldhelp," +
      "        ('paramFieldHelp' || AD_FIELD.AD_FIELD_ID) AS fieldhelpname, " +
      "        ('paramFieldName' || AD_FIELD.AD_FIELD_ID) AS fieldidname," +
      "        COALESCE(AD_WINDOW_TRL.NAME, AD_WINDOW.NAME) AS windowname," +
      "        AD_WINDOW.AD_MODULE_ID as moduleId," +
      "        AD_WINDOW.NAME AS basename," +
      "        '' AS NAME, '' AS HELP" +
      "        FROM AD_TAB left join AD_TAB_TRL on AD_TAB.AD_TAB_ID = AD_TAB_TRL.AD_TAB_ID" +
      "                                        and AD_TAB_TRL.AD_LANGUAGE = ?,                     " +
      "             AD_FIELD left join AD_FIELD_TRL on AD_FIELD.AD_FIELD_ID = AD_FIELD_TRL.AD_FIELD_ID" +
      "                                        and AD_FIELD_TRL.AD_LANGUAGE = ?," +
      "             AD_WINDOW left join AD_WINDOW_TRL on AD_WINDOW.AD_WINDOW_ID = AD_WINDOW_TRL.AD_WINDOW_ID" +
      "                                        and AD_WINDOW_TRL.AD_LANGUAGE = ?" +
      "        WHERE AD_TAB.ad_tab_id = AD_FIELD.ad_tab_id" +
      "        AND AD_TAB.isactive='Y'" +
      "        AND AD_FIELD.isactive = 'Y'" +
      "        AND AD_FIELD.ISDISPLAYED = 'Y'" +
      "        AND AD_TAB.ad_window_id = ? " +
      "        AND AD_WINDOW.AD_WINDOW_ID = AD_TAB.ad_window_id" +
      "        ORDER BY AD_TAB.seqno, AD_TAB.AD_TAB_ID, AD_FIELD.SEQNO, AD_FIELD.AD_FIELD_ID";

    ResultSet result;
    Vector<DisplayHelpData> vector = new Vector<DisplayHelpData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.tabid = UtilSql.getValue(result, "tabid");
        objectDisplayHelpData.tabname = UtilSql.getValue(result, "tabname");
        objectDisplayHelpData.tabhelp = UtilSql.getValue(result, "tabhelp");
        objectDisplayHelpData.tabhelpname = UtilSql.getValue(result, "tabhelpname");
        objectDisplayHelpData.tabidname = UtilSql.getValue(result, "tabidname");
        objectDisplayHelpData.fieldid = UtilSql.getValue(result, "fieldid");
        objectDisplayHelpData.fieldname = UtilSql.getValue(result, "fieldname");
        objectDisplayHelpData.fieldhelp = UtilSql.getValue(result, "fieldhelp");
        objectDisplayHelpData.fieldhelpname = UtilSql.getValue(result, "fieldhelpname");
        objectDisplayHelpData.fieldidname = UtilSql.getValue(result, "fieldidname");
        objectDisplayHelpData.windowname = UtilSql.getValue(result, "windowname");
        objectDisplayHelpData.moduleid = UtilSql.getValue(result, "moduleid");
        objectDisplayHelpData.basename = UtilSql.getValue(result, "basename");
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] set()    throws ServletException {
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[1];
    objectDisplayHelpData[0] = new DisplayHelpData();
    objectDisplayHelpData[0].tabid = "";
    objectDisplayHelpData[0].tabname = "";
    objectDisplayHelpData[0].tabhelp = "";
    objectDisplayHelpData[0].tabhelpname = "";
    objectDisplayHelpData[0].tabidname = "";
    objectDisplayHelpData[0].fieldid = "";
    objectDisplayHelpData[0].fieldname = "";
    objectDisplayHelpData[0].fieldhelp = "";
    objectDisplayHelpData[0].fieldhelpname = "";
    objectDisplayHelpData[0].fieldidname = "";
    objectDisplayHelpData[0].windowname = "";
    objectDisplayHelpData[0].moduleid = "";
    objectDisplayHelpData[0].basename = "";
    objectDisplayHelpData[0].name = "";
    objectDisplayHelpData[0].help = "";
    return objectDisplayHelpData;
  }

  public static DisplayHelpData[] selectFormTrl(ConnectionProvider connectionProvider, String adLanguage, String formName)    throws ServletException {
    return selectFormTrl(connectionProvider, adLanguage, formName, 0, 0);
  }

  public static DisplayHelpData[] selectFormTrl(ConnectionProvider connectionProvider, String adLanguage, String formName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(AD_FORM_TRL.NAME, AD_FORM.NAME) AS NAME," +
      "               COALESCE(AD_FORM_TRL.HELP, AD_FORM.HELP) AS HELP," +
      "               AD_FORM.NAME AS BASENAME," +
      "               AD_FORM.AD_MODULE_ID as moduleId" +
      "        FROM AD_FORM left join AD_FORM_TRL on AD_FORM.AD_FORM_ID = AD_FORM_TRL.AD_FORM_ID " +
      "                                              AND AD_FORM_TRL.AD_LANGUAGE =?" +
      "        WHERE AD_FORM.AD_FORM_ID = ? ";

    ResultSet result;
    Vector<DisplayHelpData> vector = new Vector<DisplayHelpData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formName);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.basename = UtilSql.getValue(result, "basename");
        objectDisplayHelpData.moduleid = UtilSql.getValue(result, "moduleid");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static DisplayHelpData[] selectProcessTrl(ConnectionProvider connectionProvider, String adLanguage, String processName)    throws ServletException {
    return selectProcessTrl(connectionProvider, adLanguage, processName, 0, 0);
  }

  public static DisplayHelpData[] selectProcessTrl(ConnectionProvider connectionProvider, String adLanguage, String processName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(AD_PROCESS_TRL.NAME, AD_PROCESS.NAME) AS NAME," +
      "               COALESCE(AD_PROCESS_TRL.HELP, AD_PROCESS.HELP) AS HELP," +
      "               AD_PROCESS.NAME AS BASENAME," +
      "               AD_PROCESS.AD_MODULE_ID as moduleId" +
      "        FROM AD_PROCESS left join AD_PROCESS_TRL on AD_PROCESS.AD_PROCESS_ID = AD_PROCESS_TRL.AD_PROCESS_ID " +
      "                                                    AND AD_PROCESS_TRL.AD_LANGUAGE =?" +
      "        WHERE AD_PROCESS.AD_PROCESS_ID = ? ";

    ResultSet result;
    Vector<DisplayHelpData> vector = new Vector<DisplayHelpData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processName);

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
        DisplayHelpData objectDisplayHelpData = new DisplayHelpData();
        objectDisplayHelpData.name = UtilSql.getValue(result, "name");
        objectDisplayHelpData.help = UtilSql.getValue(result, "help");
        objectDisplayHelpData.basename = UtilSql.getValue(result, "basename");
        objectDisplayHelpData.moduleid = UtilSql.getValue(result, "moduleid");
        objectDisplayHelpData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDisplayHelpData);
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
    DisplayHelpData objectDisplayHelpData[] = new DisplayHelpData[vector.size()];
    vector.copyInto(objectDisplayHelpData);
    return(objectDisplayHelpData);
  }

  public static String windowHelpTrl(ConnectionProvider connectionProvider, String windowId, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(AD_WINDOW_TRL.HELP, AD_WINDOW.HELP) AS HELP " +
      "        FROM AD_WINDOW left join AD_WINDOW_TRL on AD_WINDOW.AD_WINDOW_ID = AD_WINDOW_TRL.AD_WINDOW_ID" +
      "                                              and AD_WINDOW_TRL.AD_LANGUAGE = ?" +
      "        WHERE AD_WINDOW.AD_WINDOW_ID = ? " +
      "        AND AD_WINDOW.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "help");
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
