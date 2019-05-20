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

class ReportExpenseData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportExpenseData.class);
  private String InitRecordNumber="0";
  public String convisosym;
  public String employee;
  public String cost;
  public String name;
  public String descr;
  public String productname;
  public String uomname;
  public String qty;
  public String horas;
  public String dateexpense;
  public String invoiceprice;
  public String processed;
  public String description;
  public String sTimeexpenselineId;
  public String documentno;
  public String cuomid;
  public String count;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
    else if (fieldName.equalsIgnoreCase("employee"))
      return employee;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("descr"))
      return descr;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("horas"))
      return horas;
    else if (fieldName.equalsIgnoreCase("dateexpense"))
      return dateexpense;
    else if (fieldName.equalsIgnoreCase("invoiceprice"))
      return invoiceprice;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("s_timeexpenseline_id") || fieldName.equals("sTimeexpenselineId"))
      return sTimeexpenselineId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("cuomid"))
      return cuomid;
    else if (fieldName.equalsIgnoreCase("count"))
      return count;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportExpenseData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String adLanguage, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String cBpartner, String partner, String project, String time, String expense)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, cCurrencyBase, adLanguage, adUserClient, adOrgClient, parDateFrom, parDateTo, cBpartner, partner, project, time, expense, 0, 0);
  }

  public static ReportExpenseData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String adLanguage, String adUserClient, String adOrgClient, String parDateFrom, String parDateTo, String cBpartner, String partner, String project, String time, String expense, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_CURRENCY_ISOSYM(?) AS CONVISOSYM, CBE.NAME AS EMPLOYEE, (CASE S_L.ISTIMEREPORT WHEN 'Y' THEN S_L.QTY ELSE 0 END) * " +
      "      	 C_Uom_Convert(C_CURRENCY_CONVERT(C_CALCULATECOST_CATSALARY(C_CALCULATE_CATSALARY(s.c_bpartner_id,  (CASE WHEN S_L.DATEEXPENSE IS NULL THEN S.DATEREPORT ELSE S_L.DATEEXPENSE END)), (CASE WHEN S_L.DATEEXPENSE IS NULL THEN S.DATEREPORT ELSE S_L.DATEEXPENSE END))," +
      "      	  ?, ?, (CASE WHEN S_L.DATEEXPENSE IS NULL THEN S.DATEREPORT ELSE S_L.DATEEXPENSE END), NULL, S_L.AD_CLIENT_ID, S_L.AD_ORG_ID),C_UOM.C_UOM_ID, (SELECT C_UOM_ID FROM C_UOM WHERE UOMSYMBOL='h'),'Y') AS COST," +
      "	      CBC.NAME AS NAME, (P.VALUE || ' - ' ||P.NAME) AS DESCR, M_PRODUCT.NAME AS PRODUCTNAME, C_UOM.NAME AS UOMNAME," +
      "	      (CASE S_L.ISTIMEREPORT WHEN 'N' THEN S_L.QTY ELSE 0 END) AS QTY, (CASE S_L.ISTIMEREPORT WHEN 'Y' THEN C_Uom_Convert(S_L.QTY,C_UOM.C_UOM_ID, (SELECT C_UOM_ID FROM C_UOM WHERE UOMSYMBOL='h'),'Y') ELSE 0 END) AS HORAS," +
      "	      (CASE WHEN S_L.DATEEXPENSE IS NULL THEN S.DATEREPORT ELSE S_L.DATEEXPENSE END) AS DATEEXPENSE, " +
      "	      (CASE WHEN S_L.ISTIMEREPORT ='N' THEN C_CURRENCY_CONVERT(COALESCE(S_L.EXPENSEAMT,0), S_L.C_CURRENCY_ID, ?, (CASE WHEN S_L.DATEEXPENSE IS NULL THEN S.DATEREPORT ELSE S_L.DATEEXPENSE END), NULL, S_L.AD_CLIENT_ID, S_L.AD_ORG_ID) ELSE 0 END) AS INVOICEPRICE, " +
      "	      AD_MESSAGE_GET2(S.PROCESSED,?) AS PROCESSED, (CASE WHEN S_L.DESCRIPTION IS NULL THEN S.DESCRIPTION ELSE S_L.DESCRIPTION END) AS DESCRIPTION, S_L.S_TIMEEXPENSELINE_ID, S.DOCUMENTNO,C_UOM.C_UOM_ID AS cUomId, '' AS COUNT" +
      "      FROM S_TIMEEXPENSE S, C_BPARTNER CBE, M_PRODUCT, C_UOM, S_TIMEEXPENSELINE S_L" +
      "      LEFT JOIN C_PROJECT P ON S_L.C_PROJECT_ID = P.C_PROJECT_ID" +
      "      LEFT JOIN C_BPARTNER CBC ON S_L.C_BPARTNER_ID = CBC.C_BPARTNER_ID" +
      "      WHERE S.S_TIMEEXPENSE_ID = S_L.S_TIMEEXPENSE_ID" +
      "	      AND s.C_BPARTNER_ID=CBE.C_BPARTNER_ID" +
      "	      AND S_L.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "	      AND S_L.C_UOM_ID = C_UOM.C_UOM_ID" +
      "	      AND S.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "	      AND S.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "	      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND S.DATEREPORT >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND S.DATEREPORT < TO_DATE(?) ");
    strSql = strSql + ((cBpartner==null || cBpartner.equals(""))?"":"  AND S_L.C_BPARTNER_ID = ? ");
    strSql = strSql + ((partner==null || partner.equals(""))?"":"  AND S.C_BPARTNER_ID = ? ");
    strSql = strSql + ((project==null || project.equals(""))?"":"  AND S_L.C_PROJECT_ID = ? ");
    strSql = strSql + ((time==null || time.equals(""))?"":"  AND S_L.ISTIMEREPORT = ? ");
    strSql = strSql + ((expense==null || expense.equals(""))?"":"  AND S_L.ISTIMEREPORT = ? ");
    strSql = strSql + 
      "      ORDER BY NAME, DESCR, EMPLOYEE, PRODUCTNAME, DATEEXPENSE DESC";

    ResultSet result;
    Vector<ReportExpenseData> vector = new Vector<ReportExpenseData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (cBpartner != null && !(cBpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartner);
      }
      if (partner != null && !(partner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, partner);
      }
      if (project != null && !(project.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, project);
      }
      if (time != null && !(time.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, time);
      }
      if (expense != null && !(expense.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, expense);
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
        ReportExpenseData objectReportExpenseData = new ReportExpenseData();
        objectReportExpenseData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportExpenseData.employee = UtilSql.getValue(result, "employee");
        objectReportExpenseData.cost = UtilSql.getValue(result, "cost");
        objectReportExpenseData.name = UtilSql.getValue(result, "name");
        objectReportExpenseData.descr = UtilSql.getValue(result, "descr");
        objectReportExpenseData.productname = UtilSql.getValue(result, "productname");
        objectReportExpenseData.uomname = UtilSql.getValue(result, "uomname");
        objectReportExpenseData.qty = UtilSql.getValue(result, "qty");
        objectReportExpenseData.horas = UtilSql.getValue(result, "horas");
        objectReportExpenseData.dateexpense = UtilSql.getDateValue(result, "dateexpense", "dd-MM-yyyy");
        objectReportExpenseData.invoiceprice = UtilSql.getValue(result, "invoiceprice");
        objectReportExpenseData.processed = UtilSql.getValue(result, "processed");
        objectReportExpenseData.description = UtilSql.getValue(result, "description");
        objectReportExpenseData.sTimeexpenselineId = UtilSql.getValue(result, "s_timeexpenseline_id");
        objectReportExpenseData.documentno = UtilSql.getValue(result, "documentno");
        objectReportExpenseData.cuomid = UtilSql.getValue(result, "cuomid");
        objectReportExpenseData.count = UtilSql.getValue(result, "count");
        objectReportExpenseData.rownum = Long.toString(countRecord);
        objectReportExpenseData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportExpenseData);
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
    ReportExpenseData objectReportExpenseData[] = new ReportExpenseData[vector.size()];
    vector.copyInto(objectReportExpenseData);
    return(objectReportExpenseData);
  }

  public static String selectBpartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BPARTNER.NAME" +
      "      FROM C_BPARTNER" +
      "      WHERE C_BPARTNER.C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static String selectUOM(ConnectionProvider connectionProvider, String cUomId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(C_UOM_CONVERSION.C_UOM_ID) AS COUNT FROM C_UOM_CONVERSION,C_UOM " +
      "      WHERE C_UOM_CONVERSION.C_UOM_ID = ?" +
      "      AND C_UOM_CONVERSION.C_UOM_TO_ID = C_UOM.C_UOM_ID" +
      "      AND C_UOM.UOMSYMBOL='h' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String selectUOM2(ConnectionProvider connectionProvider, String cUomId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS COUNT FROM C_UOM" +
      "      WHERE C_UOM_ID = ? AND UOMSYMBOL='h'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static ReportExpenseData[] set()    throws ServletException {
    ReportExpenseData objectReportExpenseData[] = new ReportExpenseData[1];
    objectReportExpenseData[0] = new ReportExpenseData();
    objectReportExpenseData[0].count = "";
    return objectReportExpenseData;
  }
}
