//Sqlc generated V1.O00-1
package org.openbravo.scheduling;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

class PinstanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(PinstanceData.class);
  private String InitRecordNumber="0";
  public String adProcessId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PinstanceData select(ConnectionProvider connectionProvider, String pinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT AD_Process_ID" +
      "      	FROM AD_Pinstance" +
      "      	WHERE AD_Pinstance_ID = ?";

    ResultSet result;
    PinstanceData objectPinstanceData = new PinstanceData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        objectPinstanceData.adProcessId = UtilSql.getValue(result, "ad_process_id");
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
    return(objectPinstanceData);
  }
}
