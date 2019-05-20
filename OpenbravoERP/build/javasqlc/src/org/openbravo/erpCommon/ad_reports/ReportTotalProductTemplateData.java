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

class ReportTotalProductTemplateData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportTotalProductTemplateData.class);
  private String InitRecordNumber="0";
  public String clientName;
  public String productName;
  public String qty;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("client_name") || fieldName.equals("clientName"))
      return clientName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportTotalProductTemplateData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, 0, 0);
  }

  public static ReportTotalProductTemplateData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BPARTNER.NAME AS CLIENT_NAME, M_PRODUCT.NAME AS PRODUCT_NAME, SUM(M_PRODUCT_TEMPLATE.QTY) AS QTY" +
      "      FROM M_PRODUCT_TEMPLATE left join C_BPARTNER on M_PRODUCT_TEMPLATE.C_BPARTNER_ID=C_BPARTNER.C_BPARTNER_ID, " +
      "            M_PRODUCT " +
      "      WHERE  M_PRODUCT_TEMPLATE.M_PRODUCT_ID=M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_PRODUCT.ISACTIVE='Y'" +
      "      AND C_BPARTNER.ISACTIVE='Y'" +
      "      AND M_PRODUCT_TEMPLATE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND M_PRODUCT_TEMPLATE.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      GROUP BY C_BPARTNER.NAME, M_PRODUCT.NAME";

    ResultSet result;
    Vector<ReportTotalProductTemplateData> vector = new Vector<ReportTotalProductTemplateData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }

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
        ReportTotalProductTemplateData objectReportTotalProductTemplateData = new ReportTotalProductTemplateData();
        objectReportTotalProductTemplateData.clientName = UtilSql.getValue(result, "client_name");
        objectReportTotalProductTemplateData.productName = UtilSql.getValue(result, "product_name");
        objectReportTotalProductTemplateData.qty = UtilSql.getValue(result, "qty");
        objectReportTotalProductTemplateData.rownum = Long.toString(countRecord);
        objectReportTotalProductTemplateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTotalProductTemplateData);
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
    ReportTotalProductTemplateData objectReportTotalProductTemplateData[] = new ReportTotalProductTemplateData[vector.size()];
    vector.copyInto(objectReportTotalProductTemplateData);
    return(objectReportTotalProductTemplateData);
  }
}
