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

class SLIsDefaultData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLIsDefaultData.class);
  private String InitRecordNumber="0";
  public String tablename;
  public String columnname;
  public String total;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLIsDefaultData[] select(ConnectionProvider connectionProvider, String tableId)    throws ServletException {
    return select(connectionProvider, tableId, 0, 0);
  }

  public static SLIsDefaultData[] select(ConnectionProvider connectionProvider, String tableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TableName, ColumnName, '' as total" +
      "        FROM AD_TABLE T, AD_Column C" +
      "       WHERE T.AD_Table_ID = ?" +
      "         AND C.AD_Table_ID = T.AD_Table_ID" +
      "         AND (C.Iskey = 'Y' or C.IsSecondaryKey = 'Y')         ";

    ResultSet result;
    Vector<SLIsDefaultData> vector = new Vector<SLIsDefaultData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableId);

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
        SLIsDefaultData objectSLIsDefaultData = new SLIsDefaultData();
        objectSLIsDefaultData.tablename = UtilSql.getValue(result, "tablename");
        objectSLIsDefaultData.columnname = UtilSql.getValue(result, "columnname");
        objectSLIsDefaultData.total = UtilSql.getValue(result, "total");
        objectSLIsDefaultData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLIsDefaultData);
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
    SLIsDefaultData objectSLIsDefaultData[] = new SLIsDefaultData[vector.size()];
    vector.copyInto(objectSLIsDefaultData);
    return(objectSLIsDefaultData);
  }

  public static String selectHasDefaults(ConnectionProvider connectionProvider, String tablename, String parentClause, String currentClause, String orgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) as total" +
      "        FROM ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      "       WHERE isDefault = 'Y'" +
      "         AND 1=1 ";
    strSql = strSql + ((parentClause==null || parentClause.equals(""))?"":parentClause);
    strSql = strSql + 
      "         AND 3=3 ";
    strSql = strSql + ((currentClause==null || currentClause.equals(""))?"":currentClause);
    strSql = strSql + 
      "         AND AD_Org_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (parentClause != null && !(parentClause.equals(""))) {
        }
      if (currentClause != null && !(currentClause.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);

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
}
