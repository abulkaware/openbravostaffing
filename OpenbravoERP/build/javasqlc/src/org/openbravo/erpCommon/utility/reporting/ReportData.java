//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String documentId;
  public String docstatus;
  public String doctypetargetid;
  public String ourreference;
  public String cusreference;
  public String salnam;
  public String bpartnerId;
  public String bpartnerName;
  public String bpartnerLanguage;
  public String issalesordertransaction;
  public String docdate;
  public String minduedate;
  public String maxduedate;
  public String docdesc;
  public String contactName;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("document_id") || fieldName.equals("documentId"))
      return documentId;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("doctypetargetid"))
      return doctypetargetid;
    else if (fieldName.equalsIgnoreCase("ourreference"))
      return ourreference;
    else if (fieldName.equalsIgnoreCase("cusreference"))
      return cusreference;
    else if (fieldName.equalsIgnoreCase("salnam"))
      return salnam;
    else if (fieldName.equalsIgnoreCase("bpartner_id") || fieldName.equals("bpartnerId"))
      return bpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartner_name") || fieldName.equals("bpartnerName"))
      return bpartnerName;
    else if (fieldName.equalsIgnoreCase("bpartner_language") || fieldName.equals("bpartnerLanguage"))
      return bpartnerLanguage;
    else if (fieldName.equalsIgnoreCase("issalesordertransaction"))
      return issalesordertransaction;
    else if (fieldName.equalsIgnoreCase("docdate"))
      return docdate;
    else if (fieldName.equalsIgnoreCase("minduedate"))
      return minduedate;
    else if (fieldName.equalsIgnoreCase("maxduedate"))
      return maxduedate;
    else if (fieldName.equalsIgnoreCase("docdesc"))
      return docdesc;
    else if (fieldName.equalsIgnoreCase("contact_name") || fieldName.equals("contactName"))
      return contactName;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportData[] dummy(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return dummy(connectionProvider, cOrderId, 0, 0);
  }

  public static ReportData[] dummy(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				'' as ad_Org_Id," +
      "				'' as document_id," +
      "				'' as docstatus," +
      "				'' as docTypeTargetId," +
      "				'' as ourreference," +
      "				'' as cusreference," +
      "				'' as salnam," +
      "				'' as bpartner_id," +
      "				'' as bpartner_name," +
      "				'' as bpartner_language," +
      "				'' as isSalesOrderTransaction," +
      "				'' as docdate," +
      "				'' as minduedate," +
      "				'' as maxduedate," +
      "				'' as docdesc," +
      "				'' as contact_name" +
      "			from" +
      "				c_order" +
      "			where" +
      "				1=1";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  			 and c_order.c_order_id in  		" + cOrderId);

    ResultSet result;
    Vector<ReportData> vector = new Vector<ReportData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cOrderId != null && !(cOrderId.equals(""))) {
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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.salnam = UtilSql.getValue(result, "salnam");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.docdate = UtilSql.getValue(result, "docdate");
        objectReportData.minduedate = UtilSql.getValue(result, "minduedate");
        objectReportData.maxduedate = UtilSql.getValue(result, "maxduedate");
        objectReportData.docdesc = UtilSql.getValue(result, "docdesc");
        objectReportData.contactName = UtilSql.getValue(result, "contact_name");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getOrderInfo(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return getOrderInfo(connectionProvider, cOrderId, 0, 0);
  }

  public static ReportData[] getOrderInfo(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				c_order.ad_org_id," +
      "				c_order.c_order_id as document_id," +
      "				c_order.issotrx as isSalesOrderTransaction," +
      "				c_order.docstatus," +
      "				c_order.c_doctypetarget_id as docTypeTargetId," +
      "				c_order.documentno as ourreference," +
      "				c_order.poreference as cusreference," +
      "				salesrep.name as salnam," +
      "				c_order.c_bpartner_id as bpartner_id," +
      "				c_bpartner.name as bpartner_name," +
      "				c_bpartner.ad_language as bpartner_language," +
      "				c_order.dateordered as docdate," +
      "				(select min(fin_payment_schedule.duedate)" +
      "				 from fin_payment_schedule" +
      "				 where c_order.c_order_id = fin_payment_schedule.c_order_id" +
      "				 and fin_payment_schedule.outstandingamt > 0 " +
      "				) as minduedate," +
      "				(select max(fin_payment_schedule.duedate)" +
      "                 from fin_payment_schedule" +
      "                 where c_order.c_order_id = fin_payment_schedule.c_order_id" +
      "                 and fin_payment_schedule.outstandingamt > 0 " +
      "                ) as maxduedate," +
      "				c_order.description as docdesc," +
      "				customercontact.name as contact_name" +
      "			from" +
      "				c_order left join c_doctype on c_order.c_doctypetarget_id = c_doctype.c_doctype_id" +
      "				left join c_bpartner on c_order.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "				left join ad_user salesrep on c_order.salesrep_id = salesrep.ad_user_id" +
      "				left join ad_user customercontact on c_order.ad_user_id = customercontact.ad_user_id" +
      "			where" +
      "				c_order.c_order_id = ?		";

    ResultSet result;
    Vector<ReportData> vector = new Vector<ReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.salnam = UtilSql.getValue(result, "salnam");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.docdate = UtilSql.getDateValue(result, "docdate", "dd-MM-yyyy");
        objectReportData.minduedate = UtilSql.getDateValue(result, "minduedate", "dd-MM-yyyy");
        objectReportData.maxduedate = UtilSql.getDateValue(result, "maxduedate", "dd-MM-yyyy");
        objectReportData.docdesc = UtilSql.getValue(result, "docdesc");
        objectReportData.contactName = UtilSql.getValue(result, "contact_name");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getInvoiceInfo(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return getInvoiceInfo(connectionProvider, cInvoiceId, 0, 0);
  }

  public static ReportData[] getInvoiceInfo(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				c_invoice.ad_org_id," +
      "				c_invoice.c_invoice_id as document_id," +
      "				c_invoice.docstatus," +
      "				c_invoice.c_doctypetarget_id as docTypeTargetId," +
      "				c_invoice.documentno as ourreference," +
      "				c_invoice.poreference as cusreference," +
      "				salesrep.name as salnam," +
      "				c_invoice.c_bpartner_id as bpartner_id," +
      "				c_invoice.issotrx as isSalesOrderTransaction," +
      "				c_bpartner.name as bpartner_name," +
      "				c_bpartner.ad_language as bpartner_language," +
      "				c_invoice.dateinvoiced as docdate," +
      "				(select min(fin_payment_schedule.duedate)" +
      "                 from fin_payment_schedule" +
      "                 where c_invoice.c_invoice_id = fin_payment_schedule.c_invoice_id" +
      "                 and fin_payment_schedule.outstandingamt > 0 " +
      "                ) as minduedate," +
      "                (select max(fin_payment_schedule.duedate)" +
      "                 from fin_payment_schedule" +
      "                 where c_invoice.c_invoice_id = fin_payment_schedule.c_invoice_id" +
      "                 and fin_payment_schedule.outstandingamt > 0 " +
      "                ) as maxduedate," +
      "                c_invoice.description as docdesc," +
      "                customercontact.name as contact_name" +
      "			from" +
      "				c_invoice left join c_doctype on c_invoice.c_doctypetarget_id = c_doctype.c_doctype_id" +
      "				left join c_bpartner on c_invoice.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "				left join ad_user salesrep on c_invoice.salesrep_id = salesrep.ad_user_id" +
      "				left join ad_user customercontact on c_invoice.ad_user_id = customercontact.ad_user_id" +
      "			where" +
      "				c_invoice.c_invoice_id = ?";

    ResultSet result;
    Vector<ReportData> vector = new Vector<ReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.salnam = UtilSql.getValue(result, "salnam");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.docdate = UtilSql.getDateValue(result, "docdate", "dd-MM-yyyy");
        objectReportData.minduedate = UtilSql.getDateValue(result, "minduedate", "dd-MM-yyyy");
        objectReportData.maxduedate = UtilSql.getDateValue(result, "maxduedate", "dd-MM-yyyy");
        objectReportData.docdesc = UtilSql.getValue(result, "docdesc");
        objectReportData.contactName = UtilSql.getValue(result, "contact_name");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getShipmentInfo(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    return getShipmentInfo(connectionProvider, mInoutId, 0, 0);
  }

  public static ReportData[] getShipmentInfo(ConnectionProvider connectionProvider, String mInoutId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				m_inout.ad_org_id," +
      "				m_inout.m_inout_id as document_id," +
      "				m_inout.docstatus," +
      "				m_inout.c_doctype_id as docTypeTargetId," +
      "				m_inout.documentno as ourreference," +
      "				m_inout.poreference as cusreference," +
      "				salesrep.name as salnam," +
      "				m_inout.c_bpartner_id as bpartner_id," +
      "				m_inout.issotrx as isSalesOrderTransaction," +
      "				c_bpartner.name as bpartner_name," +
      "				c_bpartner.ad_language as bpartner_language," +
      "				m_inout.movementdate as docdate," +
      "				null as minduedate," +
      "				null as maxduedate," +
      "				m_inout.description as docdesc," +
      "				customercontact.name as contact_name" +
      "			from" +
      "				m_inout left join c_doctype on m_inout.c_doctype_id = c_doctype.c_doctype_id" +
      "				left join c_bpartner on m_inout.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "				left join ad_user salesrep on m_inout.salesrep_id = salesrep.ad_user_id" +
      "				left join ad_user customercontact on m_inout.ad_user_id = customercontact.ad_user_id" +
      "			where" +
      "				m_inout.m_inout_id = ?";

    ResultSet result;
    Vector<ReportData> vector = new Vector<ReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.salnam = UtilSql.getValue(result, "salnam");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.docdate = UtilSql.getDateValue(result, "docdate", "dd-MM-yyyy");
        objectReportData.minduedate = UtilSql.getValue(result, "minduedate");
        objectReportData.maxduedate = UtilSql.getValue(result, "maxduedate");
        objectReportData.docdesc = UtilSql.getValue(result, "docdesc");
        objectReportData.contactName = UtilSql.getValue(result, "contact_name");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getPaymentInfo(ConnectionProvider connectionProvider, String FinPaymentId)    throws ServletException {
    return getPaymentInfo(connectionProvider, FinPaymentId, 0, 0);
  }

  public static ReportData[] getPaymentInfo(ConnectionProvider connectionProvider, String FinPaymentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select" +
      "                fin_payment.ad_org_id," +
      "                fin_payment.fin_payment_id as document_id," +
      "                fin_payment.status as docstatus," +
      "                fin_payment.c_doctype_id as docTypeTargetId," +
      "                fin_payment.documentno as ourreference," +
      "                fin_payment.referenceno as cusreference," +
      "                fin_payment.c_bpartner_id as bpartner_id," +
      "                fin_payment.isreceipt as isSalesOrderTransaction," +
      "                c_bpartner.name as bpartner_name," +
      "                c_bpartner.ad_language as bpartner_language," +
      "                fin_payment.paymentdate as docdate," +
      "                (select min(fin_payment_detail_v.duedate)" +
      "                 from fin_payment_detail_v" +
      "                 where fin_payment.fin_payment_id = fin_payment_detail_v.fin_payment_id" +
      "                ) as minduedate," +
      "                (select max(fin_payment_detail_v.duedate)" +
      "                 from fin_payment_detail_v" +
      "                 where fin_payment.fin_payment_id = fin_payment_detail_v.fin_payment_id" +
      "                ) as maxduedate," +
      "                fin_payment.description as docdesc," +
      "                '' as contact_name" +
      "            from" +
      "                fin_payment left join c_doctype on fin_payment.c_doctype_id = c_doctype.c_doctype_id" +
      "                left join c_bpartner on fin_payment.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "            where" +
      "                fin_payment.fin_payment_id = ?";

    ResultSet result;
    Vector<ReportData> vector = new Vector<ReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, FinPaymentId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.docdate = UtilSql.getDateValue(result, "docdate", "dd-MM-yyyy");
        objectReportData.minduedate = UtilSql.getDateValue(result, "minduedate", "dd-MM-yyyy");
        objectReportData.maxduedate = UtilSql.getDateValue(result, "maxduedate", "dd-MM-yyyy");
        objectReportData.docdesc = UtilSql.getValue(result, "docdesc");
        objectReportData.contactName = UtilSql.getValue(result, "contact_name");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }
}
