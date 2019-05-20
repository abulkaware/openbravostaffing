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

class ReferencedTablesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReferencedTablesData.class);
  private String InitRecordNumber="0";
  public String adColumnId;
  public String columnname;
  public String adReferenceId;
  public String adReferenceValueId;
  public String adValRuleId;
  public String tablename;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_id") || fieldName.equals("adReferenceValueId"))
      return adReferenceValueId;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReferencedTablesData[] select(ConnectionProvider connectionProvider, String filterField, String adTableId)    throws ServletException {
    return select(connectionProvider, filterField, adTableId, 0, 0);
  }

  public static ReferencedTablesData[] select(ConnectionProvider connectionProvider, String filterField, String adTableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_ID, COLUMNNAME, AD_REFERENCE_ID, AD_REFERENCE_VALUE_ID, AD_VAL_RULE_ID, '' AS TABLENAME " +
      "        FROM AD_COLUMN " +
      "        WHERE ";
    strSql = strSql + ((filterField==null || filterField.equals(""))?"":" UPPER(AD_COLUMN.COLUMNNAME) = UPPER(?) AND  ");
    strSql = strSql + 
      "AD_COLUMN.AD_TABLE_ID = ? " +
      "        AND AD_COLUMN.ISPARENT = 'Y'" +
      "        ORDER BY AD_REFERENCE_ID";

    ResultSet result;
    Vector<ReferencedTablesData> vector = new Vector<ReferencedTablesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (filterField != null && !(filterField.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, filterField);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
        ReferencedTablesData objectReferencedTablesData = new ReferencedTablesData();
        objectReferencedTablesData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectReferencedTablesData.columnname = UtilSql.getValue(result, "columnname");
        objectReferencedTablesData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectReferencedTablesData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectReferencedTablesData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectReferencedTablesData.tablename = UtilSql.getValue(result, "tablename");
        objectReferencedTablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedTablesData);
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
    ReferencedTablesData objectReferencedTablesData[] = new ReferencedTablesData[vector.size()];
    vector.copyInto(objectReferencedTablesData);
    return(objectReferencedTablesData);
  }

  public static ReferencedTablesData[] selectRefTable(ConnectionProvider connectionProvider, String referencevalue)    throws ServletException {
    return selectRefTable(connectionProvider, referencevalue, 0, 0);
  }

  public static ReferencedTablesData[] selectRefTable(ConnectionProvider connectionProvider, String referencevalue, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TABLE.TABLENAME, AD_COLUMN.COLUMNNAME " +
      "        FROM AD_REF_TABLE, AD_TABLE, AD_COLUMN" +
      "        WHERE AD_REF_TABLE.AD_TABLE_ID = AD_TABLE.AD_TABLE_ID " +
      "        AND AD_REF_TABLE.AD_KEY = AD_COLUMN.AD_COLUMN_ID" +
      "        AND AD_REF_TABLE.AD_REFERENCE_ID = ?";

    ResultSet result;
    Vector<ReferencedTablesData> vector = new Vector<ReferencedTablesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencevalue);

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
        ReferencedTablesData objectReferencedTablesData = new ReferencedTablesData();
        objectReferencedTablesData.tablename = UtilSql.getValue(result, "tablename");
        objectReferencedTablesData.columnname = UtilSql.getValue(result, "columnname");
        objectReferencedTablesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedTablesData);
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
    ReferencedTablesData objectReferencedTablesData[] = new ReferencedTablesData[vector.size()];
    vector.copyInto(objectReferencedTablesData);
    return(objectReferencedTablesData);
  }

  public static String selectKeyId(ConnectionProvider connectionProvider, String field, String table, String keyName, String keyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      " AS TABLENAME" +
      "        FROM ";
    strSql = strSql + ((table==null || table.equals(""))?"":table);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((keyName==null || keyName.equals(""))?"":keyName);
    strSql = strSql + 
      " = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (field != null && !(field.equals(""))) {
        }
      if (table != null && !(table.equals(""))) {
        }
      if (keyName != null && !(keyName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keyId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tablename");
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

  public static String selectTableName(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TABLENAME" +
      "        FROM AD_TABLE " +
      "        WHERE AD_TABLE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tablename");
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

  public static String selectTableId(ConnectionProvider connectionProvider, String tablename)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TABLE_ID" +
      "        FROM AD_TABLE " +
      "        WHERE UPPER(TABLENAME) = UPPER(?)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablename);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_table_id");
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

  public static boolean selectSOTrx(ConnectionProvider connectionProvider, String table, String keyName, String keyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (case ISSOTRX when 'Y' then 1 else 0 end) AS ISSOTRX " +
      "        FROM ";
    strSql = strSql + ((table==null || table.equals(""))?"":table);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((keyName==null || keyName.equals(""))?"":keyName);
    strSql = strSql + 
      " = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (table != null && !(table.equals(""))) {
        }
      if (keyName != null && !(keyName.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keyId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "issotrx").equals("0");
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

  public static boolean selectNotManual(ConnectionProvider connectionProvider, String keyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (case SETTLEMENTTYPE when 'I' then 0 else 1 end) AS ISSOTRX " +
      "        FROM C_SETTLEMENT " +
      "        WHERE C_SETTLEMENT_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keyId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "issotrx").equals("0");
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

  public static boolean hasIsSOTrx(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "        FROM AD_COLUMN " +
      "        WHERE AD_TABLE_ID = ? " +
      "        AND UPPER(COLUMNNAME) = 'ISSOTRX'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
}
