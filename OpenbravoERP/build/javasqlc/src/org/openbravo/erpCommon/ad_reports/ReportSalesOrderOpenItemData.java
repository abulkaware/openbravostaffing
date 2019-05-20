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

class ReportSalesOrderOpenItemData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportSalesOrderOpenItemData.class);
  private String InitRecordNumber="0";
  public String clientName;
  public String documentno;
  public String dateordered;
  public String linenetamt;
  public String cashname;
  public String cCashlineId;
  public String line;
  public String description;
  public String amount;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("client_name") || fieldName.equals("clientName"))
      return clientName;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("cashname"))
      return cashname;
    else if (fieldName.equalsIgnoreCase("c_cashline_id") || fieldName.equals("cCashlineId"))
      return cCashlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportSalesOrderOpenItemData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String mWarehouseId)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, mWarehouseId, 0, 0);
  }

  public static ReportSalesOrderOpenItemData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String mWarehouseId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT A.CLIENT_NAME, A.DOCUMENTNO, A.DATEORDERED,A.LINENETAMT, " +
      "      C_CASH.NAME AS CASHNAME, C_CASHLINE.C_CASHLINE_ID, C_CASHLINE.LINE, C_CASHLINE.DESCRIPTION, C_CASHLINE.AMOUNT" +
      "      FROM   C_CASHLINE right join" +
      "      (SELECT CORDER.C_ORDER_ID, C_BPARTNER.NAME AS CLIENT_NAME, CORDER.DOCUMENTNO AS DOCUMENTNO, CORDER.DATEORDERED AS DATEORDERED," +
      "      CORDER.GRANDTOTAL AS LINENETAMT" +
      "      FROM C_ORDER CORDER, (SELECT C_ORDER_ID FROM C_ORDERLINE WHERE qtydelivered <> qtyinvoiced) CO, " +
      "      C_BPARTNER" +
      "      WHERE CORDER.C_ORDER_ID=CO.C_ORDER_ID" +
      "      AND CORDER.PROCESSED= 'Y'" +
      "      AND CORDER.PAYMENTRULE='C'" +
      "      AND NOT EXISTS (SELECT 1 FROM C_CASHLINE" +
      "                      WHERE C_CASHLINE.C_ORDER_ID=CORDER.C_ORDER_ID" +
      "                      HAVING SUM(C_CASHLINE.AMOUNT)=CORDER.GRANDTOTAL)" +
      "      AND CORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND CORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND CORDER.C_BPARTNER_ID=C_BPARTNER.C_BPARTNER_ID" +
      "      AND 1=1";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND CORDER.M_WAREHOUSE_ID = ? ");
    strSql = strSql + 
      "      GROUP BY CORDER.C_ORDER_ID, C_BPARTNER.NAME , CORDER.DOCUMENTNO, CORDER.DATEORDERED,CORDER.GRANDTOTAL) A on A.C_ORDER_ID = C_CASHLINE.C_ORDER_ID" +
      "          left join C_CASH on C_CASHLINE.C_CASH_ID = C_CASH.C_CASH_ID" +
      "      ORDER BY CLIENT_NAME";

    ResultSet result;
    Vector<ReportSalesOrderOpenItemData> vector = new Vector<ReportSalesOrderOpenItemData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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
        ReportSalesOrderOpenItemData objectReportSalesOrderOpenItemData = new ReportSalesOrderOpenItemData();
        objectReportSalesOrderOpenItemData.clientName = UtilSql.getValue(result, "client_name");
        objectReportSalesOrderOpenItemData.documentno = UtilSql.getValue(result, "documentno");
        objectReportSalesOrderOpenItemData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectReportSalesOrderOpenItemData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportSalesOrderOpenItemData.cashname = UtilSql.getValue(result, "cashname");
        objectReportSalesOrderOpenItemData.cCashlineId = UtilSql.getValue(result, "c_cashline_id");
        objectReportSalesOrderOpenItemData.line = UtilSql.getValue(result, "line");
        objectReportSalesOrderOpenItemData.description = UtilSql.getValue(result, "description");
        objectReportSalesOrderOpenItemData.amount = UtilSql.getValue(result, "amount");
        objectReportSalesOrderOpenItemData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesOrderOpenItemData);
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
    ReportSalesOrderOpenItemData objectReportSalesOrderOpenItemData[] = new ReportSalesOrderOpenItemData[vector.size()];
    vector.copyInto(objectReportSalesOrderOpenItemData);
    return(objectReportSalesOrderOpenItemData);
  }

  public static ReportSalesOrderOpenItemData[] set()    throws ServletException {
    ReportSalesOrderOpenItemData objectReportSalesOrderOpenItemData[] = new ReportSalesOrderOpenItemData[1];
    objectReportSalesOrderOpenItemData[0] = new ReportSalesOrderOpenItemData();
    objectReportSalesOrderOpenItemData[0].clientName = "";
    objectReportSalesOrderOpenItemData[0].documentno = "";
    objectReportSalesOrderOpenItemData[0].dateordered = "";
    objectReportSalesOrderOpenItemData[0].linenetamt = "";
    objectReportSalesOrderOpenItemData[0].cashname = "";
    objectReportSalesOrderOpenItemData[0].cCashlineId = "";
    objectReportSalesOrderOpenItemData[0].line = "";
    objectReportSalesOrderOpenItemData[0].description = "";
    objectReportSalesOrderOpenItemData[0].amount = "";
    return objectReportSalesOrderOpenItemData;
  }
}
