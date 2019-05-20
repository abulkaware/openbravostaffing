//Sqlc generated V1.O00-1
package org.openbravo.advpaymentmngt.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

public class APRMUtilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(APRMUtilityData.class);
  private String InitRecordNumber="0";
  public String finBankstatementlineId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fin_bankstatementline_id") || fieldName.equals("finBankstatementlineId"))
      return finBankstatementlineId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String getLockedBSL(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT FIN_BankstatementLine_ID" +
      "          FROM FIN_BankstatementLine " +
      "          WHERE FIN_BankstatementLine_ID = ? FOR UPDATE";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "fin_bankstatementline_id");
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
