//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SEOrderBPartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEOrderBPartnerData.class);
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEOrderBPartnerData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static SEOrderBPartnerData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT p.C_PaymentTerm_ID," +
      "      p.M_PriceList_ID,p.PaymentRule,p.POReference," +
      "      p.SO_Description,COALESCE(p.IsDiscountPrinted,'N') AS IsDiscountPrinted," +
      "      p.InvoiceRule,p.DeliveryRule,DeliveryViaRule," +
      "      COALESCE(p.SO_CreditLimit-p.SO_CreditUsed,-1) AS CreditAvailable," +
      "      p.PO_PriceList_ID, p.PaymentRulePO, p.PO_PaymentTerm_ID, p.salesrep_Id" +
      "      FROM C_BPartner p" +
      "      WHERE p.C_BPartner_ID=?";

    ResultSet result;
    Vector<SEOrderBPartnerData> vector = new Vector<SEOrderBPartnerData>(0);
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
        SEOrderBPartnerData objectSEOrderBPartnerData = new SEOrderBPartnerData();
        objectSEOrderBPartnerData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectSEOrderBPartnerData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSEOrderBPartnerData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectSEOrderBPartnerData.poreference = UtilSql.getValue(result, "poreference");
        objectSEOrderBPartnerData.soDescription = UtilSql.getValue(result, "so_description");
        objectSEOrderBPartnerData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectSEOrderBPartnerData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSEOrderBPartnerData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectSEOrderBPartnerData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectSEOrderBPartnerData.creditavailable = UtilSql.getValue(result, "creditavailable");
        objectSEOrderBPartnerData.poPricelistId = UtilSql.getValue(result, "po_pricelist_id");
        objectSEOrderBPartnerData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectSEOrderBPartnerData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectSEOrderBPartnerData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectSEOrderBPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEOrderBPartnerData);
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
    SEOrderBPartnerData objectSEOrderBPartnerData[] = new SEOrderBPartnerData[vector.size()];
    vector.copyInto(objectSEOrderBPartnerData);
    return(objectSEOrderBPartnerData);
  }

  public static String mWarehouse(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(M_WAREHOUSE_ID) AS ID FROM M_WAREHOUSE_SHIPPER" +
      "        WHERE M_WAREHOUSE_SHIPPER.C_BPARTNER_ID = ?" +
      "        AND (SELECT ISACTIVE FROM M_WAREHOUSE WHERE M_WAREHOUSE_ID=M_WAREHOUSE_SHIPPER.M_WAREHOUSE_ID)='Y'";

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
        strReturn = UtilSql.getValue(result, "id");
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

  public static String mWarehouseOnhand(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select m_warehouse_id AS ID from ad_org_warehouse" +
      "        where ad_org_id = ?" +
      "        and (select isactive from m_warehouse where m_warehouse_id=ad_org_warehouse.m_warehouse_id)='Y'" +
      "        group by m_warehouse_id, priority" +
      "        having min(priority) = priority";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String getIsDicountPrinted(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(IsDiscountPrinted,'N') AS IsDiscountPrinted FROM C_BPARTNER WHERE C_BPARTNER_ID = ?";

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
        strReturn = UtilSql.getValue(result, "isdiscountprinted");
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

  public static String selectPaymentTerm(ConnectionProvider connectionProvider, String clientlist)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_paymentterm_id " +
      "        from c_paymentterm " +
      "        where isactive='Y' " +
      "        AND isdefault='Y' " +
      "        AND AD_Client_ID IN (";
    strSql = strSql + ((clientlist==null || clientlist.equals(""))?"":clientlist);
    strSql = strSql + 
      ") ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (clientlist != null && !(clientlist.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_paymentterm_id");
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

  public static String userIdSalesRep(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select max(ad_user_id) AS ID" +
      "        from ad_user, c_bpartner" +
      "        where ad_user.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "        and c_bpartner.issalesrep='Y'" +
      "        and ad_user.isactive='Y' " +
      "        and ad_user.c_bpartner_id= ?";

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
        strReturn = UtilSql.getValue(result, "id");
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

  public static String defaultPriceList(ConnectionProvider connectionProvider, String isreceipt, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select m_pricelist_id" +
      "        from m_pricelist" +
      "        where isdefault = 'Y' " +
      "        and issopricelist = ?" +
      "        and ad_client_id = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_pricelist_id");
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
