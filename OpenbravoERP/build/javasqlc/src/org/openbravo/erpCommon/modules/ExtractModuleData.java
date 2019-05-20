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

class ExtractModuleData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExtractModuleData.class);
  private String InitRecordNumber="0";
  public String javapackage;
  public String type;
  public String adModuleId;
  public String version;
  public String total;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("version"))
      return version;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExtractModuleData selectDirectory(ConnectionProvider connectionProvider, String moduleID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT JAVAPACKAGE, TYPE, AD_MODULE_ID, VERSION, '' AS TOTAL" +
      "        FROM AD_MODULE" +
      "       WHERE AD_MODULE_ID = ?";

    ResultSet result;
    ExtractModuleData objectExtractModuleData = new ExtractModuleData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleID);

      result = st.executeQuery();
      if(result.next()) {
        objectExtractModuleData.javapackage = UtilSql.getValue(result, "javapackage");
        objectExtractModuleData.type = UtilSql.getValue(result, "type");
        objectExtractModuleData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectExtractModuleData.version = UtilSql.getValue(result, "version");
        objectExtractModuleData.total = UtilSql.getValue(result, "total");
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
    return(objectExtractModuleData);
  }

  public static ExtractModuleData[] selectContainedModules(ConnectionProvider connectionProvider, String moduleID, String includeDependencies)    throws ServletException {
    return selectContainedModules(connectionProvider, moduleID, includeDependencies, 0, 0);
  }

  public static ExtractModuleData[] selectContainedModules(ConnectionProvider connectionProvider, String moduleID, String includeDependencies, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT JAVAPACKAGE, TYPE, M.AD_MODULE_ID, VERSION" +
      "        FROM AD_MODULE_DEPENDENCY D, AD_MODULE M" +
      "       WHERE D.AD_MODULE_ID = ?" +
      "         AND M.AD_MODULE_ID = D.AD_DEPENDENT_MODULE_ID" +
      "         AND (D.ISINCLUDED = 'Y' or ? = 'Y')";

    ResultSet result;
    Vector<ExtractModuleData> vector = new Vector<ExtractModuleData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includeDependencies);

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
        ExtractModuleData objectExtractModuleData = new ExtractModuleData();
        objectExtractModuleData.javapackage = UtilSql.getValue(result, "javapackage");
        objectExtractModuleData.type = UtilSql.getValue(result, "type");
        objectExtractModuleData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectExtractModuleData.version = UtilSql.getValue(result, "version");
        objectExtractModuleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExtractModuleData);
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
    ExtractModuleData objectExtractModuleData[] = new ExtractModuleData[vector.size()];
    vector.copyInto(objectExtractModuleData);
    return(objectExtractModuleData);
  }

  public static boolean hasReferenceData(ConnectionProvider connectionProvider, String moduleID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS TOTAL" +
      "        FROM AD_MODULE M" +
      "       WHERE AD_MODULE_ID = ?" +
      "         AND HASREFERENCEDATA = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleID);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static String selectID(ConnectionProvider connectionProvider, String name)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_MODULE_ID" +
      "        FROM AD_MODULE M" +
      "       WHERE JAVAPACKAGE = ?" +
      "         AND ISACTIVE = 'Y' ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_module_id");
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
