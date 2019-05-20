//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportRegisterLineJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportRegisterLineJRData.class);
  private String InitRecordNumber="0";
  public String name;
  public String docnum;
  public String regdate;
  public String docinv;
  public String ragsoc;
  public String totamt;
  public String taxbaseamt;
  public String exemptamt;
  public String taxundamt;
  public String taxamt;
  public String aliquota;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("docnum"))
      return docnum;
    else if (fieldName.equalsIgnoreCase("regdate"))
      return regdate;
    else if (fieldName.equalsIgnoreCase("docinv"))
      return docinv;
    else if (fieldName.equalsIgnoreCase("ragsoc"))
      return ragsoc;
    else if (fieldName.equalsIgnoreCase("totamt"))
      return totamt;
    else if (fieldName.equalsIgnoreCase("taxbaseamt"))
      return taxbaseamt;
    else if (fieldName.equalsIgnoreCase("exemptamt"))
      return exemptamt;
    else if (fieldName.equalsIgnoreCase("taxundamt"))
      return taxundamt;
    else if (fieldName.equalsIgnoreCase("taxamt"))
      return taxamt;
    else if (fieldName.equalsIgnoreCase("aliquota"))
      return aliquota;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportRegisterLineJRData[] select(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, String parTaxPaymId, String parTaxRegisId)    throws ServletException {
    return select(connectionProvider, parDateFrom, parDateTo, parTaxPaymId, parTaxRegisId, 0, 0);
  }

  public static ReportRegisterLineJRData[] select(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, String parTaxPaymId, String parTaxRegisId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      " select taxreg.name,taxregline.documentno as DocNum,taxregline.created as RegDate , " +
      " inv.documentno as DocInv, bp.name as RagSoc," +
      " coalesce(taxregline.totalamt,0) as TotAmt, coalesce(taxregline.taxbaseamt,0) as TaxBaseAmt, coalesce(taxregline.exemptamt,0) as ExemptAmt , " +
      " coalesce(taxregline.taxundamt,0) as TaxUndAmt, coalesce(taxregline.taxamt,0) as TaxAmt , (tax.name||'-'||tax.rate || '%') as aliquota" +
      " from c_taxregister taxreg , c_taxregisterline taxregline , c_invoicetax invtax, c_invoice inv ,c_bpartner bp, c_tax tax" +
      " where taxreg.c_taxregister_id = taxregline.c_taxregister_id " +
      " and taxregline.c_invoicetax_id = invtax.c_invoicetax_id" +
      " and inv.c_invoice_id = invtax.c_invoice_id" +
      " and inv.c_bpartner_id = bp.c_bpartner_id" +
      " and taxregline.c_tax_id = tax.c_tax_id" +
      " and 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  and taxregline.invoicedate >= to_date(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  and taxregline.invoicedate <= to_date(?) ");
    strSql = strSql + ((parTaxPaymId==null || parTaxPaymId.equals(""))?"":"  and taxreg.c_taxpayment_id in ( ? )   ");
    strSql = strSql + ((parTaxRegisId==null || parTaxRegisId.equals(""))?"":"  and taxreg.c_taxregister_id in ( ? )   ");
    strSql = strSql + 
      " order by taxreg.name";

    ResultSet result;
    Vector<ReportRegisterLineJRData> vector = new Vector<ReportRegisterLineJRData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parTaxPaymId != null && !(parTaxPaymId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaxPaymId);
      }
      if (parTaxRegisId != null && !(parTaxRegisId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaxRegisId);
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
        ReportRegisterLineJRData objectReportRegisterLineJRData = new ReportRegisterLineJRData();
        objectReportRegisterLineJRData.name = UtilSql.getValue(result, "name");
        objectReportRegisterLineJRData.docnum = UtilSql.getValue(result, "docnum");
        objectReportRegisterLineJRData.regdate = UtilSql.getDateValue(result, "regdate", "dd-MM-yyyy");
        objectReportRegisterLineJRData.docinv = UtilSql.getValue(result, "docinv");
        objectReportRegisterLineJRData.ragsoc = UtilSql.getValue(result, "ragsoc");
        objectReportRegisterLineJRData.totamt = UtilSql.getValue(result, "totamt");
        objectReportRegisterLineJRData.taxbaseamt = UtilSql.getValue(result, "taxbaseamt");
        objectReportRegisterLineJRData.exemptamt = UtilSql.getValue(result, "exemptamt");
        objectReportRegisterLineJRData.taxundamt = UtilSql.getValue(result, "taxundamt");
        objectReportRegisterLineJRData.taxamt = UtilSql.getValue(result, "taxamt");
        objectReportRegisterLineJRData.aliquota = UtilSql.getValue(result, "aliquota");
        objectReportRegisterLineJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRegisterLineJRData);
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
    ReportRegisterLineJRData objectReportRegisterLineJRData[] = new ReportRegisterLineJRData[vector.size()];
    vector.copyInto(objectReportRegisterLineJRData);
    return(objectReportRegisterLineJRData);
  }
}
