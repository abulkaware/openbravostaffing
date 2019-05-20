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

class SLCostcenterEmployeeSalaryCategoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLCostcenterEmployeeSalaryCategoryData.class);
  private String InitRecordNumber="0";
  public String costuom;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String select(ConnectionProvider connectionProvider, String cSalaryCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT scc.costuom " +
      "        FROM  C_SALARY_CATEGORY_COST scc" +
      "        WHERE scc.c_salary_category_cost_id = (SELECT MAX(scc1.c_salary_category_cost_id) " +
      "                                               FROM C_SALARY_CATEGORY_COST scc1 " +
      "                                               WHERE scc1.c_salary_category_id = ?" +
      "                                               AND scc1.datefrom = (SELECT MAX(scc2.datefrom) " +
      "                                                                    FROM C_SALARY_CATEGORY_COST scc2 " +
      "                                                                    WHERE scc2.c_salary_category_id = scc1.c_salary_category_id" +
      "                                                                    AND scc2.datefrom < now()))";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "costuom");
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
