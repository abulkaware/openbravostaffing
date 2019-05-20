//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLineData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineData.class);
  private String InitRecordNumber="0";
  public String expense;
  public String revenue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("expense"))
      return expense;
    else if (fieldName.equalsIgnoreCase("revenue"))
      return revenue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineData[] select(ConnectionProvider connectionProvider, String C_Charge_ID, String C_AcctSchema_ID)    throws ServletException {
    return select(connectionProvider, C_Charge_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineData[] select(ConnectionProvider connectionProvider, String C_Charge_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT CH_Expense_Acct as expense, CH_Revenue_Acct as revenue FROM C_Charge_Acct WHERE C_Charge_ID=? AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<DocLineData> vector = new Vector<DocLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Charge_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        DocLineData objectDocLineData = new DocLineData();
        objectDocLineData.expense = UtilSql.getValue(result, "expense");
        objectDocLineData.revenue = UtilSql.getValue(result, "revenue");
        objectDocLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineData);
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
    DocLineData objectDocLineData[] = new DocLineData[vector.size()];
    vector.copyInto(objectDocLineData);
    return(objectDocLineData);
  }
}
