//Sqlc generated V1.O00-1
package org.openbravo.base.secureApp;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SystemPreferencesData implements FieldProvider {
static Logger log4j = Logger.getLogger(SystemPreferencesData.class);
  private String InitRecordNumber="0";
  public String tadRecordrange;
  public String tadRecordrangeInfo;
  public String tadTransactionalrange;
  public String tadTheme;
  public String id;
  public String classname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tad_recordrange") || fieldName.equals("tadRecordrange"))
      return tadRecordrange;
    else if (fieldName.equalsIgnoreCase("tad_recordrange_info") || fieldName.equals("tadRecordrangeInfo"))
      return tadRecordrangeInfo;
    else if (fieldName.equalsIgnoreCase("tad_transactionalrange") || fieldName.equals("tadTransactionalrange"))
      return tadTransactionalrange;
    else if (fieldName.equalsIgnoreCase("tad_theme") || fieldName.equals("tadTheme"))
      return tadTheme;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SystemPreferencesData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SystemPreferencesData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TAD_RecordRange, TAD_RecordRange_Info, TAD_TransactionalRange, TAD_THEME, " +
      "        '' AS ID, '' AS CLASSNAME " +
      "        FROM AD_SYSTEM " +
      "        WHERE AD_SYSTEM_ID = '0'";

    ResultSet result;
    Vector<SystemPreferencesData> vector = new Vector<SystemPreferencesData>(0);
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
        SystemPreferencesData objectSystemPreferencesData = new SystemPreferencesData();
        objectSystemPreferencesData.tadRecordrange = UtilSql.getValue(result, "tad_recordrange");
        objectSystemPreferencesData.tadRecordrangeInfo = UtilSql.getValue(result, "tad_recordrange_info");
        objectSystemPreferencesData.tadTransactionalrange = UtilSql.getValue(result, "tad_transactionalrange");
        objectSystemPreferencesData.tadTheme = UtilSql.getValue(result, "tad_theme");
        objectSystemPreferencesData.id = UtilSql.getValue(result, "id");
        objectSystemPreferencesData.classname = UtilSql.getValue(result, "classname");
        objectSystemPreferencesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSystemPreferencesData);
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
    SystemPreferencesData objectSystemPreferencesData[] = new SystemPreferencesData[vector.size()];
    vector.copyInto(objectSystemPreferencesData);
    return(objectSystemPreferencesData);
  }
}
