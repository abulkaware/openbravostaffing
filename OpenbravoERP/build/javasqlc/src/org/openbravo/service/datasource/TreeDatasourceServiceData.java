//Sqlc generated V1.O00-1
package org.openbravo.service.datasource;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class TreeDatasourceServiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(TreeDatasourceServiceData.class);
  private String InitRecordNumber="0";
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TreeDatasourceServiceData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static TreeDatasourceServiceData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 as name from dual";

    ResultSet result;
    Vector<TreeDatasourceServiceData> vector = new Vector<TreeDatasourceServiceData>(0);
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
        TreeDatasourceServiceData objectTreeDatasourceServiceData = new TreeDatasourceServiceData();
        objectTreeDatasourceServiceData.name = UtilSql.getValue(result, "name");
        objectTreeDatasourceServiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTreeDatasourceServiceData);
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
    TreeDatasourceServiceData objectTreeDatasourceServiceData[] = new TreeDatasourceServiceData[vector.size()];
    vector.copyInto(objectTreeDatasourceServiceData);
    return(objectTreeDatasourceServiceData);
  }

  public static int reparentChildrenADTree(ConnectionProvider connectionProvider, String newParentId, String adTreeId, String oldParentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE ad_treenode set parent_id = ?" +
      "      WHERE ad_tree_id = ?" +
      "      AND parent_id= ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, newParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, oldParentId);

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

  public static int reparentChildrenLinkToParent(ConnectionProvider connectionProvider, String tableName, String parentColumn, String newParentId, String oldParentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " set ";
    strSql = strSql + ((parentColumn==null || parentColumn.equals(""))?"":parentColumn);
    strSql = strSql + 
      " = ?" +
      "      WHERE ";
    strSql = strSql + ((parentColumn==null || parentColumn.equals(""))?"":parentColumn);
    strSql = strSql + 
      " = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (parentColumn != null && !(parentColumn.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, newParentId);
      if (parentColumn != null && !(parentColumn.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, oldParentId);

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
