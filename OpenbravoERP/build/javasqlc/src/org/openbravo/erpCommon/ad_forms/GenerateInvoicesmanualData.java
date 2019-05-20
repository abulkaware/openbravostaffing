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
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class GenerateInvoicesmanualData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateInvoicesmanualData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String adorgname;
  public String cdoctypename;
  public String documentno;
  public String cbpartnername;
  public String dateordered;
  public String amountlines;
  public String notinvoicedlines;
  public String termname;
  public String termvalue;
  public String pendinglines;
  public String amountlinesgross;
  public String notinvoicedlinesgross;
  public String pendinglinesgross;
  public String qtyordered;
  public String qtydelivered;
  public String linesinvoiced;
  public String totalgross;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("adorgname"))
      return adorgname;
    else if (fieldName.equalsIgnoreCase("cdoctypename"))
      return cdoctypename;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("cbpartnername"))
      return cbpartnername;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("amountlines"))
      return amountlines;
    else if (fieldName.equalsIgnoreCase("notinvoicedlines"))
      return notinvoicedlines;
    else if (fieldName.equalsIgnoreCase("termname"))
      return termname;
    else if (fieldName.equalsIgnoreCase("termvalue"))
      return termvalue;
    else if (fieldName.equalsIgnoreCase("pendinglines"))
      return pendinglines;
    else if (fieldName.equalsIgnoreCase("amountlinesgross"))
      return amountlinesgross;
    else if (fieldName.equalsIgnoreCase("notinvoicedlinesgross"))
      return notinvoicedlinesgross;
    else if (fieldName.equalsIgnoreCase("pendinglinesgross"))
      return pendinglinesgross;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("linesinvoiced"))
      return linesinvoiced;
    else if (fieldName.equalsIgnoreCase("totalgross"))
      return totalgross;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GenerateInvoicesmanualData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adUserOrg, parBPartner, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static GenerateInvoicesmanualData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ic.C_Order_ID, o.Name as adorgname, COALESCE(dttrl.Name, dt.Name) as cdoctypename, ic.DocumentNo, bp.Name as cbpartnername, ic.DateOrdered," +
      "      amountlines, notinvoicedlines, COALESCE(ltrl.Name, l.Name) as TermName, l.Value as TermValue, pendinglines as pendinglines, '' as amountlinesgross, '' as notinvoicedlinesgross," +
      "      '' as pendinglinesgross, ic.qtyordered as qtyordered, ic.qtydelivered as qtydelivered, (amountlines-notinvoicedlines) as linesinvoiced, amountlinesgross as totalgross" +
      "      FROM C_Invoice_Candidate_v ic, C_ORDER ord, AD_Org o, C_BPartner bp, AD_Ref_List l left join AD_Ref_List_trl ltrl on l.AD_Ref_List_ID=ltrl.AD_Ref_List_ID and ltrl.ad_language=?, " +
      "      C_DocType dt left join C_DocType_trl dttrl on dt.C_DocType_ID=dttrl.C_DocType_ID AND dttrl.ad_language=?" +
      "      WHERE ic.AD_Org_ID=o.AD_Org_ID" +
      "      AND ic.C_BPartner_ID=bp.C_BPartner_ID" +
      "      AND ic.C_DocType_ID=dt.C_DocType_ID" +
      "      AND l.value = ic.term" +
      "      AND ord.C_ORDER_ID=ic.C_ORDER_ID" +
      "      AND ((ic.term ='D' AND ic.qtydelivered <>0  AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYDELIVERED-ol.QTYINVOICED <> 0)) OR (ic.term = 'I' AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYORDERED-ol.QTYINVOICED <> 0)) OR (ic.term IN ('O') AND (ic.qtyordered = ic.qtydelivered)) OR (ic.term = 'S' AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYDELIVERED <> 0 AND ol.QTYDELIVERED <> ol.QTYINVOICED)))" +
      "      AND AD_Reference_ID='150'" +
      "      AND ic.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ic.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":" AND ic.C_BPartner_ID= ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND ic.DateOrdered >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND ic.DateOrdered < TO_DATE(?) ");
    strSql = strSql + 
      "      AND 2=2 AND ic.ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      ORDER BY o.Name,bp.Name,DateOrdered";

    ResultSet result;
    Vector<GenerateInvoicesmanualData> vector = new Vector<GenerateInvoicesmanualData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
        objectGenerateInvoicesmanualData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGenerateInvoicesmanualData.adorgname = UtilSql.getValue(result, "adorgname");
        objectGenerateInvoicesmanualData.cdoctypename = UtilSql.getValue(result, "cdoctypename");
        objectGenerateInvoicesmanualData.documentno = UtilSql.getValue(result, "documentno");
        objectGenerateInvoicesmanualData.cbpartnername = UtilSql.getValue(result, "cbpartnername");
        objectGenerateInvoicesmanualData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGenerateInvoicesmanualData.amountlines = UtilSql.getValue(result, "amountlines");
        objectGenerateInvoicesmanualData.notinvoicedlines = UtilSql.getValue(result, "notinvoicedlines");
        objectGenerateInvoicesmanualData.termname = UtilSql.getValue(result, "termname");
        objectGenerateInvoicesmanualData.termvalue = UtilSql.getValue(result, "termvalue");
        objectGenerateInvoicesmanualData.pendinglines = UtilSql.getValue(result, "pendinglines");
        objectGenerateInvoicesmanualData.amountlinesgross = UtilSql.getValue(result, "amountlinesgross");
        objectGenerateInvoicesmanualData.notinvoicedlinesgross = UtilSql.getValue(result, "notinvoicedlinesgross");
        objectGenerateInvoicesmanualData.pendinglinesgross = UtilSql.getValue(result, "pendinglinesgross");
        objectGenerateInvoicesmanualData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectGenerateInvoicesmanualData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectGenerateInvoicesmanualData.linesinvoiced = UtilSql.getValue(result, "linesinvoiced");
        objectGenerateInvoicesmanualData.totalgross = UtilSql.getValue(result, "totalgross");
        objectGenerateInvoicesmanualData.rownum = Long.toString(countRecord);
        objectGenerateInvoicesmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateInvoicesmanualData);
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
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[vector.size()];
    vector.copyInto(objectGenerateInvoicesmanualData);
    return(objectGenerateInvoicesmanualData);
  }

  public static GenerateInvoicesmanualData[] selectGross(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return selectGross(connectionProvider, language, adUserClient, adUserOrg, parBPartner, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static GenerateInvoicesmanualData[] selectGross(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ic.C_Order_ID, o.Name as adorgname, COALESCE(dttrl.Name, dt.Name) as cdoctypename, ic.DocumentNo, bp.Name as cbpartnername, ic.DateOrdered," +
      "      amountlinesgross as amountlines, notinvoicedlinesgross as notinvoicedlines, COALESCE(ltrl.Name, l.Name) as TermName, l.Value as TermValue, pendinglinesgross as pendinglines," +
      "      ic.qtyordered as qtyordered, ic.qtydelivered as qtydelivered, (amountlinesgross-notinvoicedlinesgross) as linesinvoiced, amountlinesgross as totalgross" +
      "      FROM C_Invoice_Candidate_v ic, C_ORDER ord, AD_Org o, C_BPartner bp, AD_Ref_List l left join AD_Ref_List_trl ltrl on l.AD_Ref_List_ID=ltrl.AD_Ref_List_ID and ltrl.ad_language=?, " +
      "      C_DocType dt left join C_DocType_trl dttrl on dt.C_DocType_ID=dttrl.C_DocType_ID AND dttrl.ad_language=?" +
      "      WHERE ic.AD_Org_ID=o.AD_Org_ID" +
      "      AND ic.C_BPartner_ID=bp.C_BPartner_ID" +
      "      AND ic.C_DocType_ID=dt.C_DocType_ID" +
      "      AND l.value = ic.term" +
      "      AND ord.C_ORDER_ID=ic.C_ORDER_ID" +
      "      AND ((ic.term ='D' AND ic.qtydelivered <>0) OR (ic.term = 'I' AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYORDERED-ol.QTYINVOICED <> 0)) OR (ic.term IN ('O') AND (ic.qtyordered = ic.qtydelivered)) OR (ic.term = 'S' AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYDELIVERED <> 0 AND ol.QTYDELIVERED <> ol.QTYINVOICED)))" +
      "      AND AD_Reference_ID='150'" +
      "      AND ic.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ic.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":" AND ic.C_BPartner_ID = ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND ic.DateOrdered >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND ic.DateOrdered < TO_DATE(?) ");
    strSql = strSql + 
      "      AND 2=2 AND ic.ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      ORDER BY o.Name,bp.Name,DateOrdered";

    ResultSet result;
    Vector<GenerateInvoicesmanualData> vector = new Vector<GenerateInvoicesmanualData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
        objectGenerateInvoicesmanualData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGenerateInvoicesmanualData.adorgname = UtilSql.getValue(result, "adorgname");
        objectGenerateInvoicesmanualData.cdoctypename = UtilSql.getValue(result, "cdoctypename");
        objectGenerateInvoicesmanualData.documentno = UtilSql.getValue(result, "documentno");
        objectGenerateInvoicesmanualData.cbpartnername = UtilSql.getValue(result, "cbpartnername");
        objectGenerateInvoicesmanualData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGenerateInvoicesmanualData.amountlines = UtilSql.getValue(result, "amountlines");
        objectGenerateInvoicesmanualData.notinvoicedlines = UtilSql.getValue(result, "notinvoicedlines");
        objectGenerateInvoicesmanualData.termname = UtilSql.getValue(result, "termname");
        objectGenerateInvoicesmanualData.termvalue = UtilSql.getValue(result, "termvalue");
        objectGenerateInvoicesmanualData.pendinglines = UtilSql.getValue(result, "pendinglines");
        objectGenerateInvoicesmanualData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectGenerateInvoicesmanualData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectGenerateInvoicesmanualData.linesinvoiced = UtilSql.getValue(result, "linesinvoiced");
        objectGenerateInvoicesmanualData.totalgross = UtilSql.getValue(result, "totalgross");
        objectGenerateInvoicesmanualData.rownum = Long.toString(countRecord);
        objectGenerateInvoicesmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateInvoicesmanualData);
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
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[vector.size()];
    vector.copyInto(objectGenerateInvoicesmanualData);
    return(objectGenerateInvoicesmanualData);
  }

  public static GenerateInvoicesmanualData[] set()    throws ServletException {
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[1];
    objectGenerateInvoicesmanualData[0] = new GenerateInvoicesmanualData();
    objectGenerateInvoicesmanualData[0].cOrderId = "";
    objectGenerateInvoicesmanualData[0].adorgname = "";
    objectGenerateInvoicesmanualData[0].cdoctypename = "";
    objectGenerateInvoicesmanualData[0].documentno = "";
    objectGenerateInvoicesmanualData[0].cbpartnername = "";
    objectGenerateInvoicesmanualData[0].dateordered = "";
    objectGenerateInvoicesmanualData[0].amountlines = "";
    objectGenerateInvoicesmanualData[0].notinvoicedlines = "";
    objectGenerateInvoicesmanualData[0].termname = "";
    objectGenerateInvoicesmanualData[0].termvalue = "";
    objectGenerateInvoicesmanualData[0].pendinglines = "";
    objectGenerateInvoicesmanualData[0].qtyordered = "";
    objectGenerateInvoicesmanualData[0].qtydelivered = "";
    objectGenerateInvoicesmanualData[0].linesinvoiced = "";
    objectGenerateInvoicesmanualData[0].totalgross = "";
    return objectGenerateInvoicesmanualData;
  }

  public static int initUpdate(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected = 'N'" +
      "      WHERE IsSelected='Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateSelection(Connection conn, ConnectionProvider connectionProvider, String parcOrdersId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='Y' " +
      "      WHERE 1=1";
    strSql = strSql + ((parcOrdersId==null || parcOrdersId.equals(""))?"":" AND C_Order_ID IN" + parcOrdersId);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parcOrdersId != null && !(parcOrdersId.equals(""))) {
        }

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int resetSelection(Connection conn, ConnectionProvider connectionProvider, String parcOrdersId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='N' " +
      "      WHERE 1=1";
    strSql = strSql + ((parcOrdersId==null || parcOrdersId.equals(""))?"":" AND C_Order_ID IN" + parcOrdersId);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parcOrdersId != null && !(parcOrdersId.equals(""))) {
        }

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

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

/**
procedure C_Invoice_Create0
 */
  public static GenerateInvoicesmanualData process134(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Create0(?)";

    GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectGenerateInvoicesmanualData);
  }
}
