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

class ProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessData.class);
  private String InitRecordNumber="0";
  public String procedurename;
  public String classname;
  public String isjasper;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("procedurename"))
      return procedurename;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
    else if (fieldName.equalsIgnoreCase("isjasper"))
      return isjasper;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProcessData select(ConnectionProvider connectionProvider, String processId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT p.ProcedureName," +
      "         COALESCE(TO_CHAR(p.ClassName), TO_CHAR(mo.ClassName)) as ClassName, p.IsJasper" +
      "         FROM AD_Process p LEFT JOIN AD_Model_Object mo on p.AD_Process_ID = mo.AD_Process_ID" +
      "        WHERE p.AD_Process_ID = ?";

    ResultSet result;
    ProcessData objectProcessData = new ProcessData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

      result = st.executeQuery();
      if(result.next()) {
        objectProcessData.procedurename = UtilSql.getValue(result, "procedurename");
        objectProcessData.classname = UtilSql.getValue(result, "classname");
        objectProcessData.isjasper = UtilSql.getValue(result, "isjasper");
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
    return(objectProcessData);
  }
}
