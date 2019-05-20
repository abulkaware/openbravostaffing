//Sqlc generated V1.O00-1
package org.openbravo.cluster;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ClusterServiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ClusterServiceData.class);
  private String InitRecordNumber="0";
  public String nodeId;
  public String nodeName;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("node_name") || fieldName.equals("nodeName"))
      return nodeName;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ClusterServiceData[] getNodeHandlingService(Connection conn, ConnectionProvider connectionProvider, String service)    throws ServletException {
    return getNodeHandlingService(conn, connectionProvider, service, 0, 0);
  }

  public static ClusterServiceData[] getNodeHandlingService(Connection conn, ConnectionProvider connectionProvider, String service, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT NODE_ID AS NODE_ID, NODE_NAME AS NODE_NAME" +
      "            FROM AD_CLUSTER_SERVICE" +
      "            WHERE SERVICE = ?";

    ResultSet result;
    Vector<ClusterServiceData> vector = new Vector<ClusterServiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, service);

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
        ClusterServiceData objectClusterServiceData = new ClusterServiceData();
        objectClusterServiceData.nodeId = UtilSql.getValue(result, "node_id");
        objectClusterServiceData.nodeName = UtilSql.getValue(result, "node_name");
        objectClusterServiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClusterServiceData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    ClusterServiceData objectClusterServiceData[] = new ClusterServiceData[vector.size()];
    vector.copyInto(objectClusterServiceData);
    return(objectClusterServiceData);
  }

  public static String getServiceTimeout(Connection conn, ConnectionProvider connectionProvider, String service)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT TIMEOUT AS TIMEOUT" +
      "            FROM AD_CLUSTER_SERVICE_SETTINGS" +
      "            WHERE SERVICE = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, service);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "timeout");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static int deregisterService(Connection conn, ConnectionProvider connectionProvider, String service, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "           DELETE FROM AD_CLUSTER_SERVICE" +
      "           WHERE SERVICE = ?" +
      "           AND NODE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, service);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
