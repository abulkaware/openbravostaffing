//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.reference;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ListData implements FieldProvider {
static Logger log4j = Logger.getLogger(ListData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ListData[] select(ConnectionProvider connectionProvider, String list, String value)    throws ServletException {
    return select(connectionProvider, list, value, 0, 0);
  }

  public static ListData[] select(ConnectionProvider connectionProvider, String list, String value, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT value as id, ((CASE ad_ref_list.isActive WHEN 'N' THEN '**' ELSE '' END) || name) AS name, description FROM ad_ref_list " +
      "      WHERE ad_ref_list.ad_reference_id = ? " +
      "      AND (ad_ref_list.isActive = 'Y' " +
      "      OR ad_ref_list.value = ?)" +
      "      ORDER BY NAME";

    ResultSet result;
    Vector<ListData> vector = new Vector<ListData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, list);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
        ListData objectListData = new ListData();
        objectListData.id = UtilSql.getValue(result, "id");
        objectListData.name = UtilSql.getValue(result, "name");
        objectListData.description = UtilSql.getValue(result, "description");
        objectListData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectListData);
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
    ListData objectListData[] = new ListData[vector.size()];
    vector.copyInto(objectListData);
    return(objectListData);
  }

  public static ListData[] selectLanguage(ConnectionProvider connectionProvider, String language, String list, String value)    throws ServletException {
    return selectLanguage(connectionProvider, language, list, value, 0, 0);
  }

  public static ListData[] selectLanguage(ConnectionProvider connectionProvider, String language, String list, String value, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT arl.value as id, ((CASE arl.isActive WHEN 'N' THEN '**' ELSE '' END) || (CASE WHEN arl_t.name IS NULL THEN arl.name ELSE arl_t.name END)) AS NAME, " +
      "      (CASE WHEN arl_t.description IS NULL THEN arl.description ELSE arl_t.description END) AS DESCRIPTION " +
      "      FROM ad_ref_list arl left join ad_ref_list_trl arl_t  on arl.ad_ref_list_id = arl_t.ad_ref_list_id " +
      "                                                           AND arl_t.ad_language = ? " +
      "      WHERE arl.ad_reference_id = ? " +
      "      AND (arl.isActive = 'Y' " +
      "      OR arl.Value = ? )" +
      "      ORDER BY (CASE WHEN arl_t.name IS NULL THEN arl.name ELSE arl_t.name END)";

    ResultSet result;
    Vector<ListData> vector = new Vector<ListData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, list);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
        ListData objectListData = new ListData();
        objectListData.id = UtilSql.getValue(result, "id");
        objectListData.name = UtilSql.getValue(result, "name");
        objectListData.description = UtilSql.getValue(result, "description");
        objectListData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectListData);
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
    ListData objectListData[] = new ListData[vector.size()];
    vector.copyInto(objectListData);
    return(objectListData);
  }

  public static String selectName(ConnectionProvider connectionProvider, String list, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT name FROM ad_ref_list " +
      "      WHERE ad_ref_list.ad_reference_id = ?" +
      "        AND value = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, list);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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

  public static String selectNameTrl(ConnectionProvider connectionProvider, String language, String list, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE WHEN arl_t.name IS NULL THEN arl.name ELSE arl_t.name END) AS NAME " +
      "      FROM ad_ref_list arl left join ad_ref_list_trl arl_t  on arl.ad_ref_list_id = arl_t.ad_ref_list_id " +
      "                                                           AND arl_t.ad_language = ? " +
      "      WHERE arl.ad_reference_id = ? " +
      "      AND arl.Value = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, list);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
}
