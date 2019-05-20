//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.modules;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class UninstallModuleData implements FieldProvider {
static Logger log4j = Logger.getLogger(UninstallModuleData.class);
  private String InitRecordNumber="0";
  public String name;
  public String adModuleId;
  public String version;
  public String adDependentModuleId;
  public String javapackage;
  public String origname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("version"))
      return version;
    else if (fieldName.equalsIgnoreCase("ad_dependent_module_id") || fieldName.equals("adDependentModuleId"))
      return adDependentModuleId;
    else if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
    else if (fieldName.equalsIgnoreCase("origname"))
      return origname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static UninstallModuleData[] selectDependencies(ConnectionProvider connectionProvider, String modules)    throws ServletException {
    return selectDependencies(connectionProvider, modules, 0, 0);
  }

  public static UninstallModuleData[] selectDependencies(ConnectionProvider connectionProvider, String modules, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M.NAME, M.AD_MODULE_ID, M.VERSION, D.AD_DEPENDENT_MODULE_ID, '' AS JAVAPACKAGE, M2.NAME AS ORIGNAME" +
      "          FROM AD_MODULE_DEPENDENCY D, AD_MODULE M, AD_MODULE M2" +
      "         WHERE AD_DEPENDENT_MODULE_ID IN (";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      ")" +
      "           AND D.AD_MODULE_ID = M.AD_MODULE_ID" +
      "           AND M.ISACTIVE = 'Y'" +
      "           AND M.STATUS != 'U'" +
      "           AND M2.STATUS != 'U' " +
      "           AND M2.AD_MODULE_ID = AD_DEPENDENT_MODULE_ID" +
      "           AND D.AD_MODULE_ID NOT IN (";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<UninstallModuleData> vector = new Vector<UninstallModuleData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (modules != null && !(modules.equals(""))) {
        }
      if (modules != null && !(modules.equals(""))) {
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
        UninstallModuleData objectUninstallModuleData = new UninstallModuleData();
        objectUninstallModuleData.name = UtilSql.getValue(result, "name");
        objectUninstallModuleData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectUninstallModuleData.version = UtilSql.getValue(result, "version");
        objectUninstallModuleData.adDependentModuleId = UtilSql.getValue(result, "ad_dependent_module_id");
        objectUninstallModuleData.javapackage = UtilSql.getValue(result, "javapackage");
        objectUninstallModuleData.origname = UtilSql.getValue(result, "origname");
        objectUninstallModuleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUninstallModuleData);
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
    UninstallModuleData objectUninstallModuleData[] = new UninstallModuleData[vector.size()];
    vector.copyInto(objectUninstallModuleData);
    return(objectUninstallModuleData);
  }

  public static String selectStatus(ConnectionProvider connectionProvider, String module)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT STATUS" +
      "          FROM AD_MODULE M" +
      "         WHERE M.AD_MODULE_ID IN (";
    strSql = strSql + ((module==null || module.equals(""))?"":module);
    strSql = strSql + 
      ")" +
      "         UNION" +
      "         SELECT STATUS" +
      "          FROM AD_MODULE_INSTALL MI" +
      "         WHERE MI.AD_MODULE_ID IN (";
    strSql = strSql + ((module==null || module.equals(""))?"":module);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (module != null && !(module.equals(""))) {
        }
      if (module != null && !(module.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "status");
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

  public static UninstallModuleData[] selectDirectories(ConnectionProvider connectionProvider, String module)    throws ServletException {
    return selectDirectories(connectionProvider, module, 0, 0);
  }

  public static UninstallModuleData[] selectDirectories(ConnectionProvider connectionProvider, String module, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, JAVAPACKAGE, VERSION " +
      "          FROM AD_MODULE M" +
      "         WHERE M.AD_MODULE_ID IN (";
    strSql = strSql + ((module==null || module.equals(""))?"":module);
    strSql = strSql + 
      ")" +
      "        UNION" +
      "        SELECT NAME, JAVAPACKAGE, VERSION " +
      "          FROM AD_MODULE_INSTALL MI" +
      "         WHERE MI.AD_MODULE_ID IN (";
    strSql = strSql + ((module==null || module.equals(""))?"":module);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<UninstallModuleData> vector = new Vector<UninstallModuleData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (module != null && !(module.equals(""))) {
        }
      if (module != null && !(module.equals(""))) {
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
        UninstallModuleData objectUninstallModuleData = new UninstallModuleData();
        objectUninstallModuleData.name = UtilSql.getValue(result, "name");
        objectUninstallModuleData.javapackage = UtilSql.getValue(result, "javapackage");
        objectUninstallModuleData.version = UtilSql.getValue(result, "version");
        objectUninstallModuleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUninstallModuleData);
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
    UninstallModuleData objectUninstallModuleData[] = new UninstallModuleData[vector.size()];
    vector.copyInto(objectUninstallModuleData);
    return(objectUninstallModuleData);
  }

  public static UninstallModuleData[] selectContent(ConnectionProvider connectionProvider, String module)    throws ServletException {
    return selectContent(connectionProvider, module, 0, 0);
  }

  public static UninstallModuleData[] selectContent(ConnectionProvider connectionProvider, String module, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_DEPENDENT_MODULE_ID AS AD_MODULE_ID " +
      "          FROM AD_MODULE_DEPENDENCY" +
      "         WHERE AD_MODULE_ID = ? " +
      "           AND ISINCLUDED = 'Y'";

    ResultSet result;
    Vector<UninstallModuleData> vector = new Vector<UninstallModuleData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, module);

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
        UninstallModuleData objectUninstallModuleData = new UninstallModuleData();
        objectUninstallModuleData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectUninstallModuleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUninstallModuleData);
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
    UninstallModuleData objectUninstallModuleData[] = new UninstallModuleData[vector.size()];
    vector.copyInto(objectUninstallModuleData);
    return(objectUninstallModuleData);
  }

  public static int updateUninstall(ConnectionProvider connectionProvider, String modules)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_MODULE" +
      "           SET STATUS = 'U'" +
      "         WHERE AD_MODULE_ID IN (";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      ")           ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (modules != null && !(modules.equals(""))) {
        }

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

  public static int deleteTmpModule(ConnectionProvider connectionProvider, String modules)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_MODULE_INSTALL" +
      "         WHERE AD_MODULE_ID IN (";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      ")           ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (modules != null && !(modules.equals(""))) {
        }

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

  public static int deleteTmpDependency(ConnectionProvider connectionProvider, String modules)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_MODULE_DEPENDENCY_INST" +
      "         WHERE AD_MODULE_ID IN (";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      ")           ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (modules != null && !(modules.equals(""))) {
        }

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

  public static int deleteTmpDBPrefix(ConnectionProvider connectionProvider, String modules)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_MODULE_DBPREFIX_INSTALL" +
      "         WHERE AD_MODULE_ID IN (";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      ")           ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (modules != null && !(modules.equals(""))) {
        }

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

  public static int insertLog(ConnectionProvider connectionProvider, String user, String moduleId, String moduleVersionId, String name, String log, String action)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO AD_MODULE_LOG" +
      "              (AD_MODULE_LOG_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "              ISACTIVE, CREATED, CREATEDBY," +
      "              UPDATED, UPDATEDBY, AD_MODULE_ID, " +
      "              AD_MODULE_VERSION_ID, MODULENAME, LOG, " +
      "              ACTION)" +
      "            VALUES" +
      "              (get_uuid(), '0', '0'," +
      "              'Y', now(), ?," +
      "              now(), ?, ?," +
      "              ?, ?, ?," +
      "              ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, log);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);

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
