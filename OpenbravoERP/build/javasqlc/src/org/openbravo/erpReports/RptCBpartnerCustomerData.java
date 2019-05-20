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

class RptCBpartnerCustomerData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnerCustomerData.class);
  private String InitRecordNumber="0";
  public String invoicerule;
  public String invoiceschedule;
  public String paymentrule;
  public String salesrep;
  public String pricelist;
  public String account;
  public String paymenttermname;
  public String finaccount;
  public String creditlimit;
  public String customerbalance;
  public String availablecredit;
  public String finpaymmethod;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceschedule"))
      return invoiceschedule;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("salesrep"))
      return salesrep;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("account"))
      return account;
    else if (fieldName.equalsIgnoreCase("paymenttermname"))
      return paymenttermname;
    else if (fieldName.equalsIgnoreCase("finaccount"))
      return finaccount;
    else if (fieldName.equalsIgnoreCase("creditlimit"))
      return creditlimit;
    else if (fieldName.equalsIgnoreCase("customerbalance"))
      return customerbalance;
    else if (fieldName.equalsIgnoreCase("availablecredit"))
      return availablecredit;
    else if (fieldName.equalsIgnoreCase("finpaymmethod"))
      return finpaymmethod;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnerCustomerData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, adLanguage, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerCustomerData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT IR.NAME AS INVOICERULE, I.NAME AS INVOICESCHEDULE, PR.NAME AS PAYMENTRULE, BP1.NAME AS SALESREP," +
      "        P.NAME AS PRICELIST, C_ELEMENTVALUE.VALUE||' - '||C_ELEMENTVALUE.NAME AS ACCOUNT, PT.NAME AS PAYMENTTERMNAME," +
      "        FA.NAME AS FINACCOUNT, BP.SO_CREDITLIMIT AS CREDITLIMIT, BP.SO_CREDITUSED AS CUSTOMERBALANCE, '' AS AVAILABLECREDIT, FPM.NAME AS FINPAYMMETHOD" +
      "        FROM C_BPARTNER BP left join (SELECT VALUE, NAME from AD_REF_LIST_V WHERE AD_REFERENCE_ID='150' AND AD_LANGUAGE= ?) IR on BP.INVOICERULE = IR.VALUE" +
      "                           left join C_INVOICESCHEDULE I on BP.C_INVOICESCHEDULE_ID = I.C_INVOICESCHEDULE_ID" +
      "                           left join (SELECT VALUE, NAME from AD_REF_LIST_V WHERE AD_REFERENCE_ID='195' AND AD_LANGUAGE= ?) PR on BP.PAYMENTRULE = PR.VALUE" +
      "                           left join C_PAYMENTTERM PT on  BP.C_PAYMENTTERM_ID = PT.C_PAYMENTTERM_ID" +
      "                           left join C_BPARTNER BP1 on BP.SALESREP_ID = BP1.C_BPARTNER_ID" +
      "                           left join M_PRICELIST P on BP.M_PRICELIST_ID = P.M_PRICELIST_ID" +
      "                           left join C_BP_CUSTOMER_ACCT on BP.C_BPARTNER_ID = C_BP_CUSTOMER_ACCT.C_BPARTNER_ID" +
      "                           left join C_VALIDCOMBINATION on C_BP_CUSTOMER_ACCT.C_RECEIVABLE_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID" +
      "                           left join C_ELEMENTVALUE on C_VALIDCOMBINATION.ACCOUNT_ID = C_ELEMENTVALUE.C_ELEMENTVALUE_ID " +
      "                           left join FIN_FINANCIAL_ACCOUNT FA on FA.FIN_FINANCIAL_ACCOUNT_ID = BP.FIN_FINANCIAL_ACCOUNT_ID" +
      "                           left join FIN_PAYMENTMETHOD FPM on FPM.FIN_PAYMENTMETHOD_ID = BP.FIN_PAYMENTMETHOD_ID" +
      "        WHERE BP.ISCUSTOMER = 'Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND BP.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<RptCBpartnerCustomerData> vector = new Vector<RptCBpartnerCustomerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerCustomerData objectRptCBpartnerCustomerData = new RptCBpartnerCustomerData();
        objectRptCBpartnerCustomerData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectRptCBpartnerCustomerData.invoiceschedule = UtilSql.getValue(result, "invoiceschedule");
        objectRptCBpartnerCustomerData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectRptCBpartnerCustomerData.salesrep = UtilSql.getValue(result, "salesrep");
        objectRptCBpartnerCustomerData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRptCBpartnerCustomerData.account = UtilSql.getValue(result, "account");
        objectRptCBpartnerCustomerData.paymenttermname = UtilSql.getValue(result, "paymenttermname");
        objectRptCBpartnerCustomerData.finaccount = UtilSql.getValue(result, "finaccount");
        objectRptCBpartnerCustomerData.creditlimit = UtilSql.getValue(result, "creditlimit");
        objectRptCBpartnerCustomerData.customerbalance = UtilSql.getValue(result, "customerbalance");
        objectRptCBpartnerCustomerData.availablecredit = UtilSql.getValue(result, "availablecredit");
        objectRptCBpartnerCustomerData.finpaymmethod = UtilSql.getValue(result, "finpaymmethod");
        objectRptCBpartnerCustomerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerCustomerData);
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
    RptCBpartnerCustomerData objectRptCBpartnerCustomerData[] = new RptCBpartnerCustomerData[vector.size()];
    vector.copyInto(objectRptCBpartnerCustomerData);
    return(objectRptCBpartnerCustomerData);
  }

  public static RptCBpartnerCustomerData[] set()    throws ServletException {
    RptCBpartnerCustomerData objectRptCBpartnerCustomerData[] = new RptCBpartnerCustomerData[1];
    objectRptCBpartnerCustomerData[0] = new RptCBpartnerCustomerData();
    objectRptCBpartnerCustomerData[0].invoicerule = "";
    objectRptCBpartnerCustomerData[0].invoiceschedule = "";
    objectRptCBpartnerCustomerData[0].paymentrule = "";
    objectRptCBpartnerCustomerData[0].salesrep = "";
    objectRptCBpartnerCustomerData[0].pricelist = "";
    objectRptCBpartnerCustomerData[0].account = "";
    objectRptCBpartnerCustomerData[0].paymenttermname = "";
    objectRptCBpartnerCustomerData[0].finaccount = "";
    objectRptCBpartnerCustomerData[0].creditlimit = "";
    objectRptCBpartnerCustomerData[0].customerbalance = "";
    objectRptCBpartnerCustomerData[0].availablecredit = "";
    objectRptCBpartnerCustomerData[0].finpaymmethod = "";
    return objectRptCBpartnerCustomerData;
  }
}
