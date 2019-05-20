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

class TaxPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxPaymentData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cTaxpaymentId;
  public String name;
  public String datefrom;
  public String dateto;
  public String generatepayment;
  public String processing;
  public String processed;
  public String cSettlementId;
  public String glJournalId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_taxpayment_id") || fieldName.equals("cTaxpaymentId"))
      return cTaxpaymentId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("generatepayment"))
      return generatepayment;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("c_settlement_id") || fieldName.equals("cSettlementId"))
      return cSettlementId;
    else if (fieldName.equalsIgnoreCase("gl_journal_id") || fieldName.equals("glJournalId"))
      return glJournalId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Tax Payment for a period
 */
  public static TaxPaymentData[] select(ConnectionProvider connectionProvider, String parTaxPaymId)    throws ServletException {
    return select(connectionProvider, parTaxPaymId, 0, 0);
  }

/**
Tax Payment for a period
 */
  public static TaxPaymentData[] select(ConnectionProvider connectionProvider, String parTaxPaymId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Client_ID, AD_Org_ID, C_TaxPayment_ID, Name, DateFrom, DateTo, GeneratePayment, Processing, Processed, C_Settlement_ID,GL_Journal_ID" +
      "		FROM C_TAXPAYMENT" +
      "		WHERE 1=1";
    strSql = strSql + ((parTaxPaymId==null || parTaxPaymId.equals(""))?"":"  and c_taxpayment_id in ( ? )   ");

    ResultSet result;
    Vector<TaxPaymentData> vector = new Vector<TaxPaymentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parTaxPaymId != null && !(parTaxPaymId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaxPaymId);
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
        TaxPaymentData objectTaxPaymentData = new TaxPaymentData();
        objectTaxPaymentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxPaymentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxPaymentData.cTaxpaymentId = UtilSql.getValue(result, "c_taxpayment_id");
        objectTaxPaymentData.name = UtilSql.getValue(result, "name");
        objectTaxPaymentData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectTaxPaymentData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectTaxPaymentData.generatepayment = UtilSql.getValue(result, "generatepayment");
        objectTaxPaymentData.processing = UtilSql.getValue(result, "processing");
        objectTaxPaymentData.processed = UtilSql.getValue(result, "processed");
        objectTaxPaymentData.cSettlementId = UtilSql.getValue(result, "c_settlement_id");
        objectTaxPaymentData.glJournalId = UtilSql.getValue(result, "gl_journal_id");
        objectTaxPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxPaymentData);
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
    TaxPaymentData objectTaxPaymentData[] = new TaxPaymentData[vector.size()];
    vector.copyInto(objectTaxPaymentData);
    return(objectTaxPaymentData);
  }
}
