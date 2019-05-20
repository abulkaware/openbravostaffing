//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting.printing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PocData implements FieldProvider {
static Logger log4j = Logger.getLogger(PocData.class);
  private String InitRecordNumber="0";
  public String documentId;
  public String docstatus;
  public String ourreference;
  public String yourreference;
  public String salesrepUserId;
  public String salesrepEmail;
  public String salesrepName;
  public String bpartnerId;
  public String bpartnerName;
  public String contactUserId;
  public String contactEmail;
  public String contactName;
  public String adUserId;
  public String userEmail;
  public String userName;
  public String reportLocation;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("document_id") || fieldName.equals("documentId"))
      return documentId;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("ourreference"))
      return ourreference;
    else if (fieldName.equalsIgnoreCase("yourreference"))
      return yourreference;
    else if (fieldName.equalsIgnoreCase("salesrep_user_id") || fieldName.equals("salesrepUserId"))
      return salesrepUserId;
    else if (fieldName.equalsIgnoreCase("salesrep_email") || fieldName.equals("salesrepEmail"))
      return salesrepEmail;
    else if (fieldName.equalsIgnoreCase("salesrep_name") || fieldName.equals("salesrepName"))
      return salesrepName;
    else if (fieldName.equalsIgnoreCase("bpartner_id") || fieldName.equals("bpartnerId"))
      return bpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartner_name") || fieldName.equals("bpartnerName"))
      return bpartnerName;
    else if (fieldName.equalsIgnoreCase("contact_user_id") || fieldName.equals("contactUserId"))
      return contactUserId;
    else if (fieldName.equalsIgnoreCase("contact_email") || fieldName.equals("contactEmail"))
      return contactEmail;
    else if (fieldName.equalsIgnoreCase("contact_name") || fieldName.equals("contactName"))
      return contactName;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("user_email") || fieldName.equals("userEmail"))
      return userEmail;
    else if (fieldName.equalsIgnoreCase("user_name") || fieldName.equals("userName"))
      return userName;
    else if (fieldName.equalsIgnoreCase("report_location") || fieldName.equals("reportLocation"))
      return reportLocation;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PocData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static PocData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			'' as document_id," +
      "			'' as docstatus," +
      "			'' as ourreference," +
      "			'' as yourreference," +
      "			'' as salesrep_user_id," +
      "			'' as salesrep_email," +
      "			'' as salesrep_name," +
      "			'' as bpartner_id," +
      "			'' as bpartner_name," +
      "			'' as contact_user_id," +
      "			'' as contact_email," +
      "			'' as contact_name," +
      "			'' as ad_user_id," +
      "			'' as user_email," +
      "			'' as user_name," +
      "			'' as report_location" +
      "		from" +
      "			dual";

    ResultSet result;
    Vector<PocData> vector = new Vector<PocData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        PocData objectPocData = new PocData();
        objectPocData.documentId = UtilSql.getValue(result, "document_id");
        objectPocData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPocData.ourreference = UtilSql.getValue(result, "ourreference");
        objectPocData.yourreference = UtilSql.getValue(result, "yourreference");
        objectPocData.salesrepUserId = UtilSql.getValue(result, "salesrep_user_id");
        objectPocData.salesrepEmail = UtilSql.getValue(result, "salesrep_email");
        objectPocData.salesrepName = UtilSql.getValue(result, "salesrep_name");
        objectPocData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectPocData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectPocData.contactUserId = UtilSql.getValue(result, "contact_user_id");
        objectPocData.contactEmail = UtilSql.getValue(result, "contact_email");
        objectPocData.contactName = UtilSql.getValue(result, "contact_name");
        objectPocData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectPocData.userEmail = UtilSql.getValue(result, "user_email");
        objectPocData.userName = UtilSql.getValue(result, "user_name");
        objectPocData.reportLocation = UtilSql.getValue(result, "report_location");
        objectPocData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocData);
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
    PocData objectPocData[] = new PocData[vector.size()];
    vector.copyInto(objectPocData);
    return(objectPocData);
  }

  public static PocData[] getContactDetailsForOrders(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return getContactDetailsForOrders(connectionProvider, cOrderId, 0, 0);
  }

  public static PocData[] getContactDetailsForOrders(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			c_order.c_order_id as document_id," +
      "			c_order.docstatus as docstatus," +
      "			c_order.documentno as ourreference," +
      "			c_order.poreference as yourreference," +
      "			c_order.salesrep_id as salesrep_user_id," +
      "			salesrep.email as salesrep_email," +
      "			salesrep.name as salesrep_name," +
      "			c_order.c_bpartner_id as bpartner_id," +
      "			c_bpartner.name as bpartner_name," +
      "			c_order.ad_user_id as contact_user_id," +
      "			customercontact.email as contact_email," +
      "			customercontact.name as contact_name" +
      "		from" +
      "			c_order" +
      "				left join ad_user customercontact on c_order.ad_user_id = customercontact.ad_user_id" +
      "				left join ad_user salesrep on c_order.salesrep_id = salesrep.ad_user_id" +
      "				left join c_bpartner on c_order.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "		where" +
      "			1=1";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"              and c_order.c_order_id in          " + cOrderId);

    ResultSet result;
    Vector<PocData> vector = new Vector<PocData>(0);
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
        PocData objectPocData = new PocData();
        objectPocData.documentId = UtilSql.getValue(result, "document_id");
        objectPocData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPocData.ourreference = UtilSql.getValue(result, "ourreference");
        objectPocData.yourreference = UtilSql.getValue(result, "yourreference");
        objectPocData.salesrepUserId = UtilSql.getValue(result, "salesrep_user_id");
        objectPocData.salesrepEmail = UtilSql.getValue(result, "salesrep_email");
        objectPocData.salesrepName = UtilSql.getValue(result, "salesrep_name");
        objectPocData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectPocData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectPocData.contactUserId = UtilSql.getValue(result, "contact_user_id");
        objectPocData.contactEmail = UtilSql.getValue(result, "contact_email");
        objectPocData.contactName = UtilSql.getValue(result, "contact_name");
        objectPocData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocData);
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
    PocData objectPocData[] = new PocData[vector.size()];
    vector.copyInto(objectPocData);
    return(objectPocData);
  }

  public static PocData[] getContactDetailsForInvoices(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return getContactDetailsForInvoices(connectionProvider, cInvoiceId, 0, 0);
  }

  public static PocData[] getContactDetailsForInvoices(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			c_invoice.c_invoice_id as document_id," +
      "			c_invoice.docstatus as docstatus," +
      "			c_invoice.documentno as ourreference," +
      "			c_invoice.poreference as yourreference," +
      "			c_invoice.salesrep_id as salesrep_user_id," +
      "			salesrep.email as salesrep_email," +
      "			salesrep.name as salesrep_name," +
      "			c_invoice.c_bpartner_id as bpartner_id," +
      "			c_bpartner.name as bpartner_name," +
      "			c_invoice.ad_user_id as contact_user_id," +
      "			customercontact.email as contact_email," +
      "			customercontact.name as contact_name" +
      "		from" +
      "			c_invoice" +
      "				left join ad_user customercontact on c_invoice.ad_user_id = customercontact.ad_user_id" +
      "				left join ad_user salesrep on c_invoice.salesrep_id = salesrep.ad_user_id" +
      "				left join c_bpartner on c_invoice.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "		where" +
      "			1=1";
    strSql = strSql + ((cInvoiceId==null || cInvoiceId.equals(""))?"":"              and c_invoice.c_invoice_id in          " + cInvoiceId);

    ResultSet result;
    Vector<PocData> vector = new Vector<PocData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cInvoiceId != null && !(cInvoiceId.equals(""))) {
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
        PocData objectPocData = new PocData();
        objectPocData.documentId = UtilSql.getValue(result, "document_id");
        objectPocData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPocData.ourreference = UtilSql.getValue(result, "ourreference");
        objectPocData.yourreference = UtilSql.getValue(result, "yourreference");
        objectPocData.salesrepUserId = UtilSql.getValue(result, "salesrep_user_id");
        objectPocData.salesrepEmail = UtilSql.getValue(result, "salesrep_email");
        objectPocData.salesrepName = UtilSql.getValue(result, "salesrep_name");
        objectPocData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectPocData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectPocData.contactUserId = UtilSql.getValue(result, "contact_user_id");
        objectPocData.contactEmail = UtilSql.getValue(result, "contact_email");
        objectPocData.contactName = UtilSql.getValue(result, "contact_name");
        objectPocData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocData);
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
    PocData objectPocData[] = new PocData[vector.size()];
    vector.copyInto(objectPocData);
    return(objectPocData);
  }

  public static PocData[] getContactDetailsForShipments(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    return getContactDetailsForShipments(connectionProvider, mInoutId, 0, 0);
  }

  public static PocData[] getContactDetailsForShipments(ConnectionProvider connectionProvider, String mInoutId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				m_inout.m_inout_id as document_id," +
      "				m_inout.docstatus as docstatus," +
      "				m_inout.documentno as ourreference," +
      "				m_inout.poreference as yourreference," +
      "				m_inout.salesrep_id as salesrep_user_id," +
      "				salesrep.email as salesrep_email," +
      "				salesrep.name as salesrep_name," +
      "				m_inout.c_bpartner_id as bpartner_id," +
      "				c_bpartner.name as bpartner_name," +
      "				m_inout.ad_user_id as contact_user_id," +
      "				customercontact.email as contact_email," +
      "				customercontact.name as contact_name" +
      "			from" +
      "				m_inout" +
      "					left join ad_user customercontact on m_inout.ad_user_id = customercontact.ad_user_id" +
      "					left join ad_user salesrep on m_inout.salesrep_id = salesrep.ad_user_id" +
      "					left join c_bpartner on m_inout.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "			where" +
      "				1=1";
    strSql = strSql + ((mInoutId==null || mInoutId.equals(""))?"":"              and m_inout.m_inout_id in          " + mInoutId);

    ResultSet result;
    Vector<PocData> vector = new Vector<PocData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (mInoutId != null && !(mInoutId.equals(""))) {
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
        PocData objectPocData = new PocData();
        objectPocData.documentId = UtilSql.getValue(result, "document_id");
        objectPocData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPocData.ourreference = UtilSql.getValue(result, "ourreference");
        objectPocData.yourreference = UtilSql.getValue(result, "yourreference");
        objectPocData.salesrepUserId = UtilSql.getValue(result, "salesrep_user_id");
        objectPocData.salesrepEmail = UtilSql.getValue(result, "salesrep_email");
        objectPocData.salesrepName = UtilSql.getValue(result, "salesrep_name");
        objectPocData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectPocData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectPocData.contactUserId = UtilSql.getValue(result, "contact_user_id");
        objectPocData.contactEmail = UtilSql.getValue(result, "contact_email");
        objectPocData.contactName = UtilSql.getValue(result, "contact_name");
        objectPocData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocData);
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
    PocData objectPocData[] = new PocData[vector.size()];
    vector.copyInto(objectPocData);
    return(objectPocData);
  }

  public static PocData[] getContactDetailsForPayments(ConnectionProvider connectionProvider, String finPaymentId)    throws ServletException {
    return getContactDetailsForPayments(connectionProvider, finPaymentId, 0, 0);
  }

  public static PocData[] getContactDetailsForPayments(ConnectionProvider connectionProvider, String finPaymentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select" +
      "                fin_payment.fin_payment_id as document_id," +
      "                fin_payment.status as docstatus," +
      "                fin_payment.documentno as ourreference," +
      "                fin_payment.referenceno as yourreference," +
      "                salesrep.ad_user_id as salesrep_user_id," +
      "                salesrep.email as salesrep_email," +
      "                salesrep.name as salesrep_name," +
      "                fin_payment.c_bpartner_id as bpartner_id," +
      "                bp.name as bpartner_name," +
      "                contact.ad_user_id as contact_user_id," +
      "                contact.email as contact_email," +
      "                contact.name as contact_name" +
      "            from" +
      "                fin_payment" +
      "                    join c_bpartner bp on fin_payment.c_bpartner_id = bp.c_bpartner_id" +
      "                    left join ad_user contact on bp.c_bpartner_id = contact.c_bpartner_id" +
      "                    left join ad_user salesrep on bp.salesrep_id = salesrep.c_bpartner_id" +
      "            where" +
      "                1=1";
    strSql = strSql + ((finPaymentId==null || finPaymentId.equals(""))?"":"              and fin_payment.fin_payment_id in          " + finPaymentId);

    ResultSet result;
    Vector<PocData> vector = new Vector<PocData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (finPaymentId != null && !(finPaymentId.equals(""))) {
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
        PocData objectPocData = new PocData();
        objectPocData.documentId = UtilSql.getValue(result, "document_id");
        objectPocData.docstatus = UtilSql.getValue(result, "docstatus");
        objectPocData.ourreference = UtilSql.getValue(result, "ourreference");
        objectPocData.yourreference = UtilSql.getValue(result, "yourreference");
        objectPocData.salesrepUserId = UtilSql.getValue(result, "salesrep_user_id");
        objectPocData.salesrepEmail = UtilSql.getValue(result, "salesrep_email");
        objectPocData.salesrepName = UtilSql.getValue(result, "salesrep_name");
        objectPocData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectPocData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectPocData.contactUserId = UtilSql.getValue(result, "contact_user_id");
        objectPocData.contactEmail = UtilSql.getValue(result, "contact_email");
        objectPocData.contactName = UtilSql.getValue(result, "contact_name");
        objectPocData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocData);
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
    PocData objectPocData[] = new PocData[vector.size()];
    vector.copyInto(objectPocData);
    return(objectPocData);
  }

  public static PocData[] getContactDetailsForUser(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    return getContactDetailsForUser(connectionProvider, adUserId, 0, 0);
  }

  public static PocData[] getContactDetailsForUser(ConnectionProvider connectionProvider, String adUserId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			ad_user.ad_user_id," +
      "			ad_user.email as user_email," +
      "			ad_user.name as user_name" +
      "		from" +
      "			ad_user" +
      "		where" +
      "			ad_user.ad_user_id = ?";

    ResultSet result;
    Vector<PocData> vector = new Vector<PocData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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
        PocData objectPocData = new PocData();
        objectPocData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectPocData.userEmail = UtilSql.getValue(result, "user_email");
        objectPocData.userName = UtilSql.getValue(result, "user_name");
        objectPocData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocData);
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
    PocData objectPocData[] = new PocData[vector.size()];
    vector.copyInto(objectPocData);
    return(objectPocData);
  }
}
