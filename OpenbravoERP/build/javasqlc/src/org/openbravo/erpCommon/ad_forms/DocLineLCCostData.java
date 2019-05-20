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

class DocLineLCCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineLCCostData.class);
  private String InitRecordNumber="0";
  public String mLcMatchedId;
  public String adClientId;
  public String adOrgId;
  public String mLcCostId;
  public String amount;
  public String mLcTypeId;
  public String mProductId;
  public String ismatchingadjusted;
  public String cCurrencyId;
  public String cCampaignId;
  public String cProjectId;
  public String user1id;
  public String user2id;
  public String cCostcenterId;
  public String aAssetId;
  public String cBpartnerId;
  public String cActivityId;
  public String mWarehouseId;
  public String accountId;
  public String name;
  public String glitemDebitAcct;
  public String glitemCreditAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_lc_matched_id") || fieldName.equals("mLcMatchedId"))
      return mLcMatchedId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_lc_cost_id") || fieldName.equals("mLcCostId"))
      return mLcCostId;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("m_lc_type_id") || fieldName.equals("mLcTypeId"))
      return mLcTypeId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("ismatchingadjusted"))
      return ismatchingadjusted;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1id"))
      return user1id;
    else if (fieldName.equalsIgnoreCase("user2id"))
      return user2id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("glitem_debit_acct") || fieldName.equals("glitemDebitAcct"))
      return glitemDebitAcct;
    else if (fieldName.equalsIgnoreCase("glitem_credit_acct") || fieldName.equals("glitemCreditAcct"))
      return glitemCreditAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineLCCostData[] select(ConnectionProvider connectionProvider, String LCCostId)    throws ServletException {
    return select(connectionProvider, LCCostId, 0, 0);
  }

  public static DocLineLCCostData[] select(ConnectionProvider connectionProvider, String LCCostId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LCM.M_LC_MATCHED_ID, LCM.AD_CLIENT_ID, LCM.AD_ORG_ID," +
      "        LCC.M_LC_COST_ID, LCM.AMOUNT * COALESCE(ILA.AMT, IL.LINENETAMT)/IL.LINENETAMT AS AMOUNT, " +
      "        LCC.M_LC_TYPE_ID, IL.M_PRODUCT_ID,   " +
      "        LCC.ISMATCHINGADJUSTED, I.C_CURRENCY_ID, " +
      "        ILA.C_CAMPAIGN_ID, COALESCE(ILA.C_PROJECT_ID, IL.C_PROJECT_ID) AS C_PROJECT_ID," +
      "        COALESCE(ILA.USER1_ID,IL.USER1_ID) AS user1Id," +
      "        COALESCE(ILA.USER2_ID,IL.USER2_ID) AS user2Id," +
      "        COALESCE(ILA.C_COSTCENTER_ID,IL.C_COSTCENTER_ID) AS C_COSTCENTER_ID," +
      "        COALESCE(ILA.A_ASSET_ID,IL.A_ASSET_ID) AS A_ASSET_ID," +
      "        COALESCE(ILA.C_BPARTNER_ID,IL.C_BPARTNER_ID) AS C_BPARTNER_ID, ILA.C_ACTIVITY_ID, " +
      "        '' AS M_WAREHOUSE_ID, '' AS ACCOUNT_ID, '' AS NAME, '' AS GLITEM_DEBIT_ACCT, '' AS GLITEM_CREDIT_ACCT         " +
      "        FROM M_LC_MATCHED LCM, M_LC_COST LCC, C_INVOICE I, C_INVOICELINE IL" +
      "          left join C_INVOICELINE_ACCTDIMENSION ila on il.C_INVOICELINE_ID = ila.C_INVOICELINE_ID" +
      "        WHERE LCM.ISACTIVE='Y'" +
      "        AND LCM.M_LC_COST_ID = LCC.M_LC_COST_ID" +
      "        AND LCM.C_INVOICELINE_ID = IL.C_INVOICELINE_ID" +
      "        AND IL.C_INVOICE_ID = I.C_INVOICE_ID" +
      "        AND LCM.M_LC_COST_ID = ?";

    ResultSet result;
    Vector<DocLineLCCostData> vector = new Vector<DocLineLCCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, LCCostId);

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
        DocLineLCCostData objectDocLineLCCostData = new DocLineLCCostData();
        objectDocLineLCCostData.mLcMatchedId = UtilSql.getValue(result, "m_lc_matched_id");
        objectDocLineLCCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineLCCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineLCCostData.mLcCostId = UtilSql.getValue(result, "m_lc_cost_id");
        objectDocLineLCCostData.amount = UtilSql.getValue(result, "amount");
        objectDocLineLCCostData.mLcTypeId = UtilSql.getValue(result, "m_lc_type_id");
        objectDocLineLCCostData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineLCCostData.ismatchingadjusted = UtilSql.getValue(result, "ismatchingadjusted");
        objectDocLineLCCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineLCCostData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineLCCostData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineLCCostData.user1id = UtilSql.getValue(result, "user1id");
        objectDocLineLCCostData.user2id = UtilSql.getValue(result, "user2id");
        objectDocLineLCCostData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineLCCostData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineLCCostData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineLCCostData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocLineLCCostData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocLineLCCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineLCCostData.name = UtilSql.getValue(result, "name");
        objectDocLineLCCostData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineLCCostData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLCCostData);
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
    DocLineLCCostData objectDocLineLCCostData[] = new DocLineLCCostData[vector.size()];
    vector.copyInto(objectDocLineLCCostData);
    return(objectDocLineLCCostData);
  }

  public static DocLineLCCostData[] selectRcptLineAmt(ConnectionProvider connectionProvider, String LCCostId)    throws ServletException {
    return selectRcptLineAmt(connectionProvider, LCCostId, 0, 0);
  }

  public static DocLineLCCostData[] selectRcptLineAmt(ConnectionProvider connectionProvider, String LCCostId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LCR.AD_CLIENT_ID, LCR.AD_ORG_ID, " +
      "        LCR.M_LC_COST_ID, LCR.AMOUNT * COALESCE(A.QUANTITY, IOL.MOVEMENTQTY)/IOL.MOVEMENTQTY AS AMOUNT, " +
      "        LCC.M_LC_TYPE_ID, L.M_WAREHOUSE_ID, IOL.M_PRODUCT_ID, LCC.C_CURRENCY_ID, " +
      "        A.C_Campaign_ID, COALESCE(A.C_Project_Id, IOL.C_Project_Id) AS C_Project_Id, " +
      "        COALESCE(A.User1_ID, IOL.User1_ID) AS user1Id, COALESCE(A.User2_ID, IOL.User2_ID) AS user2Id, " +
      "        COALESCE(A.C_Costcenter_ID, IOL.C_Costcenter_ID) AS C_Costcenter_ID,COALESCE(A.A_Asset_ID,IOL.A_Asset_ID) AS A_Asset_ID, " +
      "        COALESCE(A.C_BPartner_ID, IOL.C_BPartner_ID) AS C_BPartner_ID, A.C_Activity_ID" +
      "        FROM M_LC_RECEIPTLINE_AMT  LCR, M_INOUT IO, M_LC_COST LCC, M_LOCATOR L, M_INOUTLINE IOL" +
      "           left join M_InOutLine_AcctDimension A ON IOl.M_InOutLine_ID = A.M_InOutLine_ID" +
      "        WHERE LCR.ISACTIVE='Y'" +
      "        AND LCR.M_INOUTLINE_ID = IOL.M_INOUTLINE_ID" +
      "        AND IOL.M_INOUT_ID = IO.M_INOUT_ID" +
      "        AND LCR.M_LC_COST_ID = LCC.M_LC_COST_ID" +
      "        AND IOL.M_LOCATOR_ID = L.M_LOCATOR_ID" +
      "        AND LCR.ISMATCHADJUSTMENT = 'Y'" +
      "        AND LCC.M_LC_COST_ID = ?" +
      "        ORDER BY IO.DOCUMENTNO, IO.M_INOUT_ID, IOL.LINE";

    ResultSet result;
    Vector<DocLineLCCostData> vector = new Vector<DocLineLCCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, LCCostId);

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
        DocLineLCCostData objectDocLineLCCostData = new DocLineLCCostData();
        objectDocLineLCCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineLCCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineLCCostData.mLcCostId = UtilSql.getValue(result, "m_lc_cost_id");
        objectDocLineLCCostData.amount = UtilSql.getValue(result, "amount");
        objectDocLineLCCostData.mLcTypeId = UtilSql.getValue(result, "m_lc_type_id");
        objectDocLineLCCostData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocLineLCCostData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineLCCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineLCCostData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineLCCostData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineLCCostData.user1id = UtilSql.getValue(result, "user1id");
        objectDocLineLCCostData.user2id = UtilSql.getValue(result, "user2id");
        objectDocLineLCCostData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineLCCostData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineLCCostData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineLCCostData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocLineLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLCCostData);
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
    DocLineLCCostData objectDocLineLCCostData[] = new DocLineLCCostData[vector.size()];
    vector.copyInto(objectDocLineLCCostData);
    return(objectDocLineLCCostData);
  }

  public static DocLineLCCostData[] selectLCAccount(ConnectionProvider connectionProvider, String Lc_Type_Id)    throws ServletException {
    return selectLCAccount(connectionProvider, Lc_Type_Id, 0, 0);
  }

  public static DocLineLCCostData[] selectLCAccount(ConnectionProvider connectionProvider, String Lc_Type_Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(LCT.ACCOUNT_ID, '') AS ACCOUNT_ID, COALESCE(LCT.M_PRODUCT_ID, '') AS M_PRODUCT_ID, NAME" +
      "        FROM M_LC_TYPE LCT " +
      "        WHERE LCT.M_LC_TYPE_ID = ?";

    ResultSet result;
    Vector<DocLineLCCostData> vector = new Vector<DocLineLCCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Lc_Type_Id);

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
        DocLineLCCostData objectDocLineLCCostData = new DocLineLCCostData();
        objectDocLineLCCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineLCCostData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineLCCostData.name = UtilSql.getValue(result, "name");
        objectDocLineLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLCCostData);
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
    DocLineLCCostData objectDocLineLCCostData[] = new DocLineLCCostData[vector.size()];
    vector.copyInto(objectDocLineLCCostData);
    return(objectDocLineLCCostData);
  }

  public static DocLineLCCostData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectGlitem(connectionProvider, C_Glitem_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineLCCostData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT GLITEM_DEBIT_ACCT, GLITEM_CREDIT_ACCT" +
      "        FROM C_GLITEM_ACCT " +
      "        WHERE C_GLITEM_id = ?" +
      "        AND C_ACCTSCHEMA_id = ?";

    ResultSet result;
    Vector<DocLineLCCostData> vector = new Vector<DocLineLCCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Glitem_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        DocLineLCCostData objectDocLineLCCostData = new DocLineLCCostData();
        objectDocLineLCCostData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineLCCostData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLCCostData);
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
    DocLineLCCostData objectDocLineLCCostData[] = new DocLineLCCostData[vector.size()];
    vector.copyInto(objectDocLineLCCostData);
    return(objectDocLineLCCostData);
  }

  public static DocLineLCCostData[] selectLCProduct(ConnectionProvider connectionProvider, String M_Product_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectLCProduct(connectionProvider, M_Product_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineLCCostData[] selectLCProduct(ConnectionProvider connectionProvider, String M_Product_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P_EXPENSE_ACCT AS ACCOUNT_ID" +
      "        FROM M_PRODUCT_ACCT " +
      "        WHERE M_PRODUCT_ID = ?" +
      "        AND C_ACCTSCHEMA_id = ?";

    ResultSet result;
    Vector<DocLineLCCostData> vector = new Vector<DocLineLCCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        DocLineLCCostData objectDocLineLCCostData = new DocLineLCCostData();
        objectDocLineLCCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineLCCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLCCostData);
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
    DocLineLCCostData objectDocLineLCCostData[] = new DocLineLCCostData[vector.size()];
    vector.copyInto(objectDocLineLCCostData);
    return(objectDocLineLCCostData);
  }
}
