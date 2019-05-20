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

class ReportWorkRequirementJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportWorkRequirementJRData.class);
  private String InitRecordNumber="0";
  public String wrid;
  public String wrname;
  public String processplan;
  public String startdate;
  public String enddate;
  public String seqno;
  public String wrpname;
  public String process;
  public String quantity;
  public String needqty;
  public String productid;
  public String product;
  public String stock;
  public String needed;
  public String inprocess;
  public String wrpid;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("wrid"))
      return wrid;
    else if (fieldName.equalsIgnoreCase("wrname"))
      return wrname;
    else if (fieldName.equalsIgnoreCase("processplan"))
      return processplan;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("wrpname"))
      return wrpname;
    else if (fieldName.equalsIgnoreCase("process"))
      return process;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("needqty"))
      return needqty;
    else if (fieldName.equalsIgnoreCase("productid"))
      return productid;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("stock"))
      return stock;
    else if (fieldName.equalsIgnoreCase("needed"))
      return needed;
    else if (fieldName.equalsIgnoreCase("inprocess"))
      return inprocess;
    else if (fieldName.equalsIgnoreCase("wrpid"))
      return wrpid;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportWorkRequirementJRData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parStartDateFrom, String parStartDateTo, String parEndDateFrom, String parEndDateTo, String parProcessPlan)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adUserOrg, parStartDateFrom, parStartDateTo, parEndDateFrom, parEndDateTo, parProcessPlan, 0, 0);
  }

  public static ReportWorkRequirementJRData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parStartDateFrom, String parStartDateTo, String parEndDateFrom, String parEndDateTo, String parProcessPlan, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT wr.MA_WorkRequirement_ID AS wrid, AD_COLUMN_IDENTIFIER('MA_WorkRequirement', to_char(wr.MA_WORKREQUIREMENT_ID), ?) AS wrname, " +
      "             AD_COLUMN_IDENTIFIER('MA_ProcessPlan', to_char(pp.MA_ProcessPlan_ID), ?) AS processplan, " +
      "             wr.STARTDATE AS startdate, wr.ENDDATE AS enddate, wrp.SeqNO," +
      "             AD_COLUMN_IDENTIFIER('MA_WRPhase', to_char(wrp.MA_WRPhase_ID), ?) AS wrpname, " +
      "             AD_COLUMN_IDENTIFIER('MA_Process', to_char(ps.MA_Process_ID), ?) AS process, " +
      "             wrp.DONEQUANTITY AS quantity, wrp.QUANTITY AS needqty, wrpp.M_PRODUCT_ID AS productid, " +
      "             AD_COLUMN_IDENTIFIER('M_Product', to_char(pd.M_Product_ID), ?) AS product, " +
      "             SUM(T.QTYONHAND) AS stock, (wrp.QUANTITY - wrp.DONEQUANTITY) * wrpp.MOVEMENTQTY AS needed, 123 AS inprocess, wrp.MA_WRPhase_ID AS WRPID" +
      "      FROM MA_WorkRequirement wr, MA_WRPhase wrp, MA_WRPhaseProduct wrpp, MA_Process ps, MA_ProcessPlan pp, M_Product pd, M_STORAGE_DETAIL T" +
      "      WHERE wr.MA_WORKREQUIREMENT_ID = wrp.MA_WORKREQUIREMENT_ID" +
      "        AND wr.MA_PROCESSPLAN_ID = pp.MA_PROCESSPLAN_ID" +
      "        AND wrp.MA_WRPHASE_ID = wrpp.MA_WRPHASE_ID" +
      "        AND wrpp.M_PRODUCT_ID = pd.M_PRODUCT_ID" +
      "        AND wrp.MA_PROCESS_ID = ps.MA_PROCESS_ID" +
      "        AND pd.M_PRODUCT_ID = T.M_PRODUCT_ID" +
      "        AND wrp.CLOSED = 'N'" +
      "        AND wrpp.PRODUCTIONTYPE = '-'" +
      "        AND wr.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND wr.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((parStartDateFrom==null || parStartDateFrom.equals(""))?"":" AND wr.STARTDATE >= TO_DATE(?) ");
    strSql = strSql + ((parStartDateTo==null || parStartDateTo.equals(""))?"":" AND wr.STARTDATE < TO_DATE(?)+1 ");
    strSql = strSql + ((parEndDateFrom==null || parEndDateFrom.equals(""))?"":" AND wr.ENDDATE >= TO_DATE(?) ");
    strSql = strSql + ((parEndDateTo==null || parEndDateTo.equals(""))?"":" AND wr.ENDDATE < TO_DATE(?)+1 ");
    strSql = strSql + ((parProcessPlan==null || parProcessPlan.equals(""))?"":" AND pp.MA_ProcessPlan_id =? ");
    strSql = strSql + 
      "      GROUP BY wr.MA_WorkRequirement_ID, wrp.MA_WRPHASE_ID, wr.DOCUMENTNO, pp.MA_ProcessPlan_ID, wr.STARTDATE, wr.ENDDATE," +
      "               ps.MA_Process_ID, wrp.DONEQUANTITY, wrp.QUANTITY, pd.M_PRODUCT_ID, wrpp.MOVEMENTQTY, wrp.SeqNo, wrpp.M_PRODUCT_ID" +
      "      ORDER BY enddate, wr.MA_WorkRequirement_ID, wrp.SeqNo, wrp.MA_WRPHASE_ID ";

    ResultSet result;
    Vector<ReportWorkRequirementJRData> vector = new Vector<ReportWorkRequirementJRData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parStartDateFrom != null && !(parStartDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parStartDateFrom);
      }
      if (parStartDateTo != null && !(parStartDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parStartDateTo);
      }
      if (parEndDateFrom != null && !(parEndDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parEndDateFrom);
      }
      if (parEndDateTo != null && !(parEndDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parEndDateTo);
      }
      if (parProcessPlan != null && !(parProcessPlan.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parProcessPlan);
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
        ReportWorkRequirementJRData objectReportWorkRequirementJRData = new ReportWorkRequirementJRData();
        objectReportWorkRequirementJRData.wrid = UtilSql.getValue(result, "wrid");
        objectReportWorkRequirementJRData.wrname = UtilSql.getValue(result, "wrname");
        objectReportWorkRequirementJRData.processplan = UtilSql.getValue(result, "processplan");
        objectReportWorkRequirementJRData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectReportWorkRequirementJRData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectReportWorkRequirementJRData.seqno = UtilSql.getValue(result, "seqno");
        objectReportWorkRequirementJRData.wrpname = UtilSql.getValue(result, "wrpname");
        objectReportWorkRequirementJRData.process = UtilSql.getValue(result, "process");
        objectReportWorkRequirementJRData.quantity = UtilSql.getValue(result, "quantity");
        objectReportWorkRequirementJRData.needqty = UtilSql.getValue(result, "needqty");
        objectReportWorkRequirementJRData.productid = UtilSql.getValue(result, "productid");
        objectReportWorkRequirementJRData.product = UtilSql.getValue(result, "product");
        objectReportWorkRequirementJRData.stock = UtilSql.getValue(result, "stock");
        objectReportWorkRequirementJRData.needed = UtilSql.getValue(result, "needed");
        objectReportWorkRequirementJRData.inprocess = UtilSql.getValue(result, "inprocess");
        objectReportWorkRequirementJRData.wrpid = UtilSql.getValue(result, "wrpid");
        objectReportWorkRequirementJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportWorkRequirementJRData);
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
    ReportWorkRequirementJRData objectReportWorkRequirementJRData[] = new ReportWorkRequirementJRData[vector.size()];
    vector.copyInto(objectReportWorkRequirementJRData);
    return(objectReportWorkRequirementJRData);
  }

  public static String inprocess(ConnectionProvider connectionProvider, String wrid, String wrppproduct)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT sum((wrp.QUANTITY - wrp.DONEQUANTITY) * wrpp.MOVEMENTQTY) AS cantidad" +
      "        FROM MA_WRPhaseProduct wrpp, MA_WRPhase wrp " +
      "        WHERE wrpp.MA_WRPHASE_ID = wrp.MA_WRPHASE_ID" +
      "        AND wrpp.PRODUCTIONTYPE = '+'" +
      "        AND wrp.MA_WORKREQUIREMENT_ID = ?" +
      "          AND wrpp.M_PRODUCT_ID = ?" +
      "        AND wrp.CLOSED = 'N'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wrid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wrppproduct);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "cantidad");
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
