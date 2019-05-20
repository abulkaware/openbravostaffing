//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CreateVatRegistersData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateVatRegistersData.class);
  private String InitRecordNumber="0";
  public String cInvoiceId;
  public String documentno;
  public String cInvoicetaxId;
  public String taxdate;
  public String taxamt;
  public String taxbaseamt;
  public String cTaxId;
  public String istaxexempt;
  public String istaxundeductable;
  public String isnovat;
  public String docbasetype;
  public String isreversal;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("c_invoicetax_id") || fieldName.equals("cInvoicetaxId"))
      return cInvoicetaxId;
    else if (fieldName.equalsIgnoreCase("taxdate"))
      return taxdate;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("taxbaseamt"))
      return taxbaseamt;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("istaxexempt"))
      return istaxexempt;
    else if (fieldName.equalsIgnoreCase("istaxundeductable"))
      return istaxundeductable;
    else if (fieldName.equalsIgnoreCase("isnovat"))
      return isnovat;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("isreversal"))
      return isreversal;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Tax Payment for a period
 */
  public static CreateVatRegistersData[] select(ConnectionProvider connectionProvider, String taxPaymentID, String parTaxRegType_id, String parDateFrom, String parDateTo, String adUserOrg)    throws ServletException {
    return select(connectionProvider, taxPaymentID, parTaxRegType_id, parDateFrom, parDateTo, adUserOrg, 0, 0);
  }

/**
Tax Payment for a period
 */
  public static CreateVatRegistersData[] select(ConnectionProvider connectionProvider, String taxPaymentID, String parTaxRegType_id, String parDateFrom, String parDateTo, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select C_invoice.C_invoice_ID, C_invoice.DocumentNo, " +
      "         C_InvoiceTax.C_InvoiceTax_ID, coalesce(C_invoice.TaxDate, C_invoice.DateAcct) as TaxDate, " +
      "         case when C_Invoice.C_Currency_ID = (select c_currency_id from c_taxpayment where c_taxpayment_id = ? ) then C_InvoiceTax.TaxAmt else" +
      "         case when (select rate from c_conversion_rate_document WHERE c_invoice_id = C_invoice.C_invoice_ID AND c_currency_id = C_Invoice.C_Currency_ID AND c_currency_id_to = (select c_currency_id from c_taxpayment where c_taxpayment_id = ? )) IS NOT NULL" +
      "         then ROUND (C_InvoiceTax.TaxAmt * (select rate from c_conversion_rate_document WHERE c_invoice_id = C_invoice.C_invoice_ID AND c_currency_id = C_Invoice.C_Currency_ID AND c_currency_id_to = (select c_currency_id from c_taxpayment where c_taxpayment_id = ? )) , " +
      "         C_get_currency_precision ((select c_currency_id from c_taxpayment where c_taxpayment_id = ? ), 'A')) else" +
      "         C_Currency_Convert(C_InvoiceTax.TaxAmt ,C_Invoice.C_Currency_ID, (select c_currency_id from c_taxpayment where c_taxpayment_id = ? )," +
      "         coalesce(C_invoice.TaxDate, C_invoice.DateAcct), 'S', c_invoice.ad_client_id, c_invoice.ad_org_id) end end as TaxAmt," +
      "         case when C_Invoice.C_Currency_ID = (select c_currency_id from c_taxpayment where c_taxpayment_id = ? ) then C_InvoiceTax.TaxBaseAmt else" +
      "         case when (select rate from c_conversion_rate_document WHERE c_invoice_id = C_invoice.C_invoice_ID AND c_currency_id = C_Invoice.C_Currency_ID AND c_currency_id_to = (select c_currency_id from c_taxpayment where c_taxpayment_id = ? )) IS NOT NULL" +
      "         then ROUND (C_InvoiceTax.TaxBaseAmt * (select rate from c_conversion_rate_document WHERE c_invoice_id = C_invoice.C_invoice_ID AND c_currency_id = C_Invoice.C_Currency_ID AND c_currency_id_to = (select c_currency_id from c_taxpayment where c_taxpayment_id = ? )) , " +
      "         C_get_currency_precision ((select c_currency_id from c_taxpayment where c_taxpayment_id = ? ), 'A')) else" +
      "         C_Currency_Convert(C_InvoiceTax.TaxBaseAmt ,C_Invoice.C_Currency_ID, (select c_currency_id from c_taxpayment where c_taxpayment_id = ? )," +
      "         coalesce(C_invoice.TaxDate, C_invoice.DateAcct), 'S', c_invoice.ad_client_id, c_invoice.ad_org_id) end end as TaxBaseAmt," +
      "         C_Tax.C_Tax_ID, C_Tax.IsTaxExempt ,C_Tax.IsTaxUndeductable, C_Tax.IsNoVat, C_DocType.DocBaseType, C_DocType.isreversal" +
      "         from C_Invoice," +
      "         C_TaxRegister_Type_Lines," +
      "         C_InvoiceTax," +
      "         C_Tax," +
      "         C_TaxRegister_Type," +
      "         C_DocType" +
      "         where" +
      "         C_Invoice.C_DocType_ID=C_TaxRegister_Type_Lines.C_DocType_ID" +
      "         and C_TaxRegister_Type_Lines.ISACTIVE = 'Y'" +
      "         and C_Invoice.C_DocType_ID=C_DocType.C_DocType_ID" +
      "         and C_InvoiceTax.C_Invoice_ID=C_Invoice.C_Invoice_ID " +
      "         and C_InvoiceTax.C_Tax_ID = C_TaxRegister_Type_Lines.C_Tax_ID" +
      "         and C_InvoiceTax.C_Tax_ID = C_Tax.C_Tax_ID" +
      "         and C_Invoice.IsSoTrx=C_TaxRegister_Type.IsSoTrx" +
      "         and C_TaxRegister_Type_Lines.C_TaxRegister_Type_ID=C_TaxRegister_Type.C_TaxRegister_Type_ID" +
      "         and C_Invoice.Processed= 'Y'" +
      "         and 1=1";
    strSql = strSql + ((parTaxRegType_id==null || parTaxRegType_id.equals(""))?"":"  and C_TaxRegister_Type.C_TaxRegister_Type_ID= ?   ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  and coalesce(C_invoice.TaxDate, C_invoice.DateAcct) >= to_date(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  and coalesce(C_invoice.TaxDate, C_invoice.DateAcct) < to_date(?) ");
    strSql = strSql + 
      "         and C_Invoice.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<CreateVatRegistersData> vector = new Vector<CreateVatRegistersData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxPaymentID);
      if (parTaxRegType_id != null && !(parTaxRegType_id.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaxRegType_id);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
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
        CreateVatRegistersData objectCreateVatRegistersData = new CreateVatRegistersData();
        objectCreateVatRegistersData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateVatRegistersData.documentno = UtilSql.getValue(result, "documentno");
        objectCreateVatRegistersData.cInvoicetaxId = UtilSql.getValue(result, "c_invoicetax_id");
        objectCreateVatRegistersData.taxdate = UtilSql.getDateValue(result, "taxdate", "dd-MM-yyyy");
        objectCreateVatRegistersData.taxamt = UtilSql.getValue(result, "taxamt");
        objectCreateVatRegistersData.taxbaseamt = UtilSql.getValue(result, "taxbaseamt");
        objectCreateVatRegistersData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectCreateVatRegistersData.istaxexempt = UtilSql.getValue(result, "istaxexempt");
        objectCreateVatRegistersData.istaxundeductable = UtilSql.getValue(result, "istaxundeductable");
        objectCreateVatRegistersData.isnovat = UtilSql.getValue(result, "isnovat");
        objectCreateVatRegistersData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectCreateVatRegistersData.isreversal = UtilSql.getValue(result, "isreversal");
        objectCreateVatRegistersData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateVatRegistersData);
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
    CreateVatRegistersData objectCreateVatRegistersData[] = new CreateVatRegistersData[vector.size()];
    vector.copyInto(objectCreateVatRegistersData);
    return(objectCreateVatRegistersData);
  }
}
