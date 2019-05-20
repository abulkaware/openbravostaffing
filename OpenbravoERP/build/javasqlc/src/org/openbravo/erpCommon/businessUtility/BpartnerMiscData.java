//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.businessUtility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class BpartnerMiscData implements FieldProvider {
static Logger log4j = Logger.getLogger(BpartnerMiscData.class);
  private String InitRecordNumber="0";
  public String cPaymenttermId;
  public String mPricelistId;
  public String paymentrule;
  public String poreference;
  public String soDescription;
  public String isdiscountprinted;
  public String invoicerule;
  public String deliveryrule;
  public String deliveryviarule;
  public String creditavailable;
  public String poPricelistId;
  public String paymentrulepo;
  public String poPaymenttermId;
  public String salesrepId;
  public String finPaymentmethodId;
  public String poPaymentmethodId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("so_description") || fieldName.equals("soDescription"))
      return soDescription;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("creditavailable"))
      return creditavailable;
    else if (fieldName.equalsIgnoreCase("po_pricelist_id") || fieldName.equals("poPricelistId"))
      return poPricelistId;
    else if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_id") || fieldName.equals("poPaymenttermId"))
      return poPaymenttermId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("po_paymentmethod_id") || fieldName.equals("poPaymentmethodId"))
      return poPaymentmethodId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static BpartnerMiscData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static BpartnerMiscData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT p.C_PaymentTerm_ID," +
      "      p.M_PriceList_ID,p.PaymentRule,p.POReference," +
      "      p.SO_Description,COALESCE(p.IsDiscountPrinted,'N') AS IsDiscountPrinted," +
      "      p.InvoiceRule,p.DeliveryRule,DeliveryViaRule," +
      "      COALESCE(p.SO_CreditLimit-p.SO_CreditUsed,-1) AS CreditAvailable," +
      "      p.PO_PriceList_ID, p.PaymentRulePO, p.PO_PaymentTerm_ID, p.salesrep_Id," +
      "      p.fin_paymentmethod_id, p.po_paymentmethod_id" +
      "      FROM C_BPartner p" +
      "      WHERE p.C_BPartner_ID=?";

    ResultSet result;
    Vector<BpartnerMiscData> vector = new Vector<BpartnerMiscData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        BpartnerMiscData objectBpartnerMiscData = new BpartnerMiscData();
        objectBpartnerMiscData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectBpartnerMiscData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectBpartnerMiscData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectBpartnerMiscData.poreference = UtilSql.getValue(result, "poreference");
        objectBpartnerMiscData.soDescription = UtilSql.getValue(result, "so_description");
        objectBpartnerMiscData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectBpartnerMiscData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectBpartnerMiscData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectBpartnerMiscData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectBpartnerMiscData.creditavailable = UtilSql.getValue(result, "creditavailable");
        objectBpartnerMiscData.poPricelistId = UtilSql.getValue(result, "po_pricelist_id");
        objectBpartnerMiscData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectBpartnerMiscData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectBpartnerMiscData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectBpartnerMiscData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectBpartnerMiscData.poPaymentmethodId = UtilSql.getValue(result, "po_paymentmethod_id");
        objectBpartnerMiscData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBpartnerMiscData);
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
    BpartnerMiscData objectBpartnerMiscData[] = new BpartnerMiscData[vector.size()];
    vector.copyInto(objectBpartnerMiscData);
    return(objectBpartnerMiscData);
  }

  public static BpartnerMiscData[] selectPaymentTerm(ConnectionProvider connectionProvider, String adOrgId, String adClientId)    throws ServletException {
    return selectPaymentTerm(connectionProvider, adOrgId, adClientId, 0, 0);
  }

  public static BpartnerMiscData[] selectPaymentTerm(ConnectionProvider connectionProvider, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT pt.C_PaymentTerm_ID" +
      "      FROM C_PaymentTerm pt" +
      "      WHERE AD_ISORGINCLUDED(?, pt.ad_org_id, ?) <> -1" +
      "      AND ad_client_id = ?" +
      "      AND isdefault = 'Y'";

    ResultSet result;
    Vector<BpartnerMiscData> vector = new Vector<BpartnerMiscData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        BpartnerMiscData objectBpartnerMiscData = new BpartnerMiscData();
        objectBpartnerMiscData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectBpartnerMiscData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBpartnerMiscData);
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
    BpartnerMiscData objectBpartnerMiscData[] = new BpartnerMiscData[vector.size()];
    vector.copyInto(objectBpartnerMiscData);
    return(objectBpartnerMiscData);
  }
}
