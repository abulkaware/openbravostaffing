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

class ModuleManagementData implements FieldProvider {
static Logger log4j = Logger.getLogger(ModuleManagementData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdhour;
  public String action;
  public String createdby;
  public String modulename;
  public String log;
  public String total;
  public String adModuleId;
  public String adModuleVersionId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdhour"))
      return createdhour;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("modulename"))
      return modulename;
    else if (fieldName.equalsIgnoreCase("log"))
      return log;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_version_id") || fieldName.equals("adModuleVersionId"))
      return adModuleVersionId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ModuleManagementData[] selectLog(ConnectionProvider connectionProvider, String lang, String parUser, String parDateFrom, String parDateTo)    throws ServletException {
    return selectLog(connectionProvider, lang, parUser, parDateFrom, parDateTo, 0, 0);
  }

  public static ModuleManagementData[] selectLog(ConnectionProvider connectionProvider, String lang, String parUser, String parDateFrom, String parDateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT L.CREATED," +
      "               to_char(l.created, 'HH24:MI:SS') AS CREATEDHOUR," +
      "               COALESCE(TO_CHAR(RLT.NAME), TO_CHAR(RL.NAME), TO_CHAR(L.ACTION)) AS ACTION," +
      "               COALESCE(TO_CHAR(U.NAME), TO_CHAR(L.CREATEDBY)) AS CREATEDBY," +
      "               L.MODULENAME," +
      "               L.LOG, " +
      "               '' as total," +
      "               '' as AD_MODULE_ID," +
      "               '' as ad_module_version_id" +
      "          FROM AD_MODULE_LOG L LEFT JOIN AD_REF_LIST RL" +
      "                                  ON L.ACTION = RL.VALUE" +
      "                                  AND  RL.AD_REFERENCE_ID = '7CD9193198B94EF5B174D0F8512B0857'" +
      "                               LEFT JOIN AD_REF_LIST_TRL RLT" +
      "                                  ON RL.AD_REF_LIST_ID = RLT.AD_REF_LIST_ID" +
      "                                  AND RLT.AD_LANGUAGE=?" +
      "                               LEFT JOIN AD_USER U" +
      "                                 ON L.CREATEDBY = U.AD_USER_ID" +
      "         WHERE 1=1";
    strSql = strSql + ((parUser==null || parUser.equals(""))?"":"  AND L.CREATEDBY = ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND L.CREATED >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND L.CREATED < TO_DATE(?) ");
    strSql = strSql + 
      "         ORDER BY L.CREATED DESC";

    ResultSet result;
    Vector<ModuleManagementData> vector = new Vector<ModuleManagementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      if (parUser != null && !(parUser.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parUser);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
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
        ModuleManagementData objectModuleManagementData = new ModuleManagementData();
        objectModuleManagementData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectModuleManagementData.createdhour = UtilSql.getValue(result, "createdhour");
        objectModuleManagementData.action = UtilSql.getValue(result, "action");
        objectModuleManagementData.createdby = UtilSql.getValue(result, "createdby");
        objectModuleManagementData.modulename = UtilSql.getValue(result, "modulename");
        objectModuleManagementData.log = UtilSql.getValue(result, "log");
        objectModuleManagementData.total = UtilSql.getValue(result, "total");
        objectModuleManagementData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectModuleManagementData.adModuleVersionId = UtilSql.getValue(result, "ad_module_version_id");
        objectModuleManagementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleManagementData);
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
    ModuleManagementData objectModuleManagementData[] = new ModuleManagementData[vector.size()];
    vector.copyInto(objectModuleManagementData);
    return(objectModuleManagementData);
  }

  public static ModuleManagementData[] selectInstalled(ConnectionProvider connectionProvider)    throws ServletException {
    return selectInstalled(connectionProvider, 0, 0);
  }

  public static ModuleManagementData[] selectInstalled(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_MODULE_ID" +
      "          FROM AD_MODULE" +
      "         UNION " +
      "        SELECT AD_MODULE_ID" +
      "          FROM AD_MODULE_INSTALL";

    ResultSet result;
    Vector<ModuleManagementData> vector = new Vector<ModuleManagementData>(0);
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
        ModuleManagementData objectModuleManagementData = new ModuleManagementData();
        objectModuleManagementData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectModuleManagementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleManagementData);
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
    ModuleManagementData objectModuleManagementData[] = new ModuleManagementData[vector.size()];
    vector.copyInto(objectModuleManagementData);
    return(objectModuleManagementData);
  }

  public static ModuleManagementData[] selectUpdateable(ConnectionProvider connectionProvider)    throws ServletException {
    return selectUpdateable(connectionProvider, 0, 0);
  }

  public static ModuleManagementData[] selectUpdateable(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT UPDATE_VER_ID AS ad_module_version_id" +
      "          FROM AD_MODULE" +
      "         WHERE UPDATE_AVAILABLE IS NOT NULL";

    ResultSet result;
    Vector<ModuleManagementData> vector = new Vector<ModuleManagementData>(0);
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
        ModuleManagementData objectModuleManagementData = new ModuleManagementData();
        objectModuleManagementData.adModuleVersionId = UtilSql.getValue(result, "ad_module_version_id");
        objectModuleManagementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleManagementData);
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
    ModuleManagementData objectModuleManagementData[] = new ModuleManagementData[vector.size()];
    vector.copyInto(objectModuleManagementData);
    return(objectModuleManagementData);
  }

  public static String selectRebuild(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT COUNT(*) AS TOTAL" +
      "           FROM (SELECT AD_MODULE_ID " +
      "                   FROM AD_MODULE " +
      "                  WHERE STATUS IN ('I','U','P')" +
      "                  UNION" +
      "                 SELECT AD_MODULE_ID" +
      "                   FROM AD_MODULE_INSTALL) A";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String selectRestartTomcat(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT COUNT(*) AS TOTAL" +
      "           FROM AD_SYSTEM_INFO WHERE SYSTEM_STATUS='RB60'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String selectUpdate(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT COUNT(*) AS TOTAL" +
      "           FROM AD_MODULE " +
      "          WHERE UPDATE_AVAILABLE IS NOT NULL" +
      "            AND ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static int cleanModulesUpdates(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE  AD_MODULE " +
      "            SET update_available=null, " +
      "                update_ver_id=null      ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
