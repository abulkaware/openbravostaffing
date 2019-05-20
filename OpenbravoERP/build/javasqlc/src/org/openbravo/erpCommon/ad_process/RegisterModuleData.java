//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

class RegisterModuleData implements FieldProvider {
static Logger log4j = Logger.getLogger(RegisterModuleData.class);
  private String InitRecordNumber="0";
  public String name;
  public String javapackage;
  public String type;
  public String description;
  public String dbPrefix;
  public String author;
  public String help;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("db_prefix") || fieldName.equals("dbPrefix"))
      return dbPrefix;
    else if (fieldName.equalsIgnoreCase("author"))
      return author;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RegisterModuleData selectModule(ConnectionProvider connectionProvider, String moduleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT M.NAME, JAVAPACKAGE, TYPE," +
      "                DESCRIPTION, P.NAME AS DB_PREFIX, M.AUTHOR, " +
      "                M.HELP                " +
      "           FROM AD_MODULE M LEFT JOIN AD_MODULE_DBPREFIX P" +
      "                                   ON P.AD_MODULE_ID = M.AD_MODULE_ID" +
      "          WHERE M.AD_MODULE_ID = ?        ";

    ResultSet result;
    RegisterModuleData objectRegisterModuleData = new RegisterModuleData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleId);

      result = st.executeQuery();
      if(result.next()) {
        objectRegisterModuleData.name = UtilSql.getValue(result, "name");
        objectRegisterModuleData.javapackage = UtilSql.getValue(result, "javapackage");
        objectRegisterModuleData.type = UtilSql.getValue(result, "type");
        objectRegisterModuleData.description = UtilSql.getValue(result, "description");
        objectRegisterModuleData.dbPrefix = UtilSql.getValue(result, "db_prefix");
        objectRegisterModuleData.author = UtilSql.getValue(result, "author");
        objectRegisterModuleData.help = UtilSql.getValue(result, "help");
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
    return(objectRegisterModuleData);
  }

  public static String getHelp(ConnectionProvider connectionProvider, String adLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT COALESCE(T.HELP, P.HELP) AS NAME" +
      "           FROM AD_PROCESS P LEFT JOIN AD_PROCESS_TRL T " +
      "                                       ON T.AD_PROCESS_ID = P.AD_PROCESS_ID" +
      "                                      AND AD_LANGUAGE = ?" +
      "          WHERE P.AD_PROCESS_ID = '4062D3F4448547C3A2BCDFB09D062BA2'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static int setRegistered(ConnectionProvider connectionProvider, String moduleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          UPDATE AD_MODULE" +
      "            SET ISREGISTERED = 'Y'" +
      "          WHERE AD_MODULE_ID = ?        ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleId);

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
