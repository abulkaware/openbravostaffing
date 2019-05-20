//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportAcctRedirectUtilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportAcctRedirectUtilityData.class);
  private String InitRecordNumber="0";
  public String columnname;
  public String adTabId;
  public String tabName;
  public String windowName;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("tab_name") || fieldName.equals("tabName"))
      return tabName;
    else if (fieldName.equalsIgnoreCase("window_name") || fieldName.equals("windowName"))
      return windowName;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportAcctRedirectUtilityData[] select(ConnectionProvider connectionProvider, String adTableId, String docbasetype, String adClientId)    throws ServletException {
    return select(connectionProvider, adTableId, docbasetype, adClientId, 0, 0);
  }

  public static ReportAcctRedirectUtilityData[] select(ConnectionProvider connectionProvider, String adTableId, String docbasetype, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select C.COLUMNNAME, tb.ad_tab_id, TB.NAME AS TAB_NAME, W.NAME AS WINDOW_NAME" +
      "        from ad_table t, ad_tab tb, ad_window w, ad_column c" +
      "        where t.ad_table_id = ?" +
      "        and t.ad_table_id = tb.ad_table_id" +
      "        and tb.ad_window_id = w.ad_window_id" +
      "        and t.ad_table_id = c.ad_table_id" +
      "        AND (CASE (SELECT MAX(ISSOTRX) FROM C_DOCTYPE D" +
      "            WHERE D.DOCBASETYPE = ?" +
      "            AND D.AD_CLIENT_ID = ?) WHEN 'N' THEN COALESCE(T.PO_WINDOW_ID, T.AD_WINDOW_ID) ELSE T.AD_WINDOW_ID END) = W.AD_WINDOW_ID" +
      "        and c.iskey = 'Y'";

    ResultSet result;
    Vector<ReportAcctRedirectUtilityData> vector = new Vector<ReportAcctRedirectUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        ReportAcctRedirectUtilityData objectReportAcctRedirectUtilityData = new ReportAcctRedirectUtilityData();
        objectReportAcctRedirectUtilityData.columnname = UtilSql.getValue(result, "columnname");
        objectReportAcctRedirectUtilityData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectReportAcctRedirectUtilityData.tabName = UtilSql.getValue(result, "tab_name");
        objectReportAcctRedirectUtilityData.windowName = UtilSql.getValue(result, "window_name");
        objectReportAcctRedirectUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAcctRedirectUtilityData);
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
    ReportAcctRedirectUtilityData objectReportAcctRedirectUtilityData[] = new ReportAcctRedirectUtilityData[vector.size()];
    vector.copyInto(objectReportAcctRedirectUtilityData);
    return(objectReportAcctRedirectUtilityData);
  }
}
