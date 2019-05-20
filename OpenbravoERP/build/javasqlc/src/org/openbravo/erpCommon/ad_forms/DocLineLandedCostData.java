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

class DocLineLandedCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineLandedCostData.class);
  private String InitRecordNumber="0";
  public String mLcReceiptlineAmtId;
  public String adClientId;
  public String adOrgId;
  public String mLcCostId;
  public String amount;
  public String mLcTypeId;
  public String mWarehouseId;
  public String mProductId;
  public String cCurrencyId;
  public String accountId;
  public String name;
  public String glitemDebitAcct;
  public String glitemCreditAcct;
  public String cCampaignId;
  public String cProjectId;
  public String user1id;
  public String user2id;
  public String cCostcenterId;
  public String aAssetId;
  public String cBpartnerId;
  public String cActivityId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_lc_receiptline_amt_id") || fieldName.equals("mLcReceiptlineAmtId"))
      return mLcReceiptlineAmtId;
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
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("glitem_debit_acct") || fieldName.equals("glitemDebitAcct"))
      return glitemDebitAcct;
    else if (fieldName.equalsIgnoreCase("glitem_credit_acct") || fieldName.equals("glitemCreditAcct"))
      return glitemCreditAcct;
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineLandedCostData[] select(ConnectionProvider connectionProvider, String LC_Receiptline_Amt)    throws ServletException {
    return select(connectionProvider, LC_Receiptline_Amt, 0, 0);
  }

  public static DocLineLandedCostData[] select(ConnectionProvider connectionProvider, String LC_Receiptline_Amt, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LCR.M_LC_RECEIPTLINE_AMT_ID, LCR.AD_CLIENT_ID, LCR.AD_ORG_ID, " +
      "        LCR.M_LC_COST_ID, LCR.AMOUNT  * COALESCE(A.QUANTITY, IOL.MOVEMENTQTY)/IOL.MOVEMENTQTY AS AMOUNT, " +
      "        LCC.M_LC_TYPE_ID, L.M_WAREHOUSE_ID, IOL.M_PRODUCT_ID," +
      "        LCC.C_CURRENCY_ID, '' AS ACCOUNT_ID, '' AS NAME, '' AS GLITEM_DEBIT_ACCT, '' AS GLITEM_CREDIT_ACCT, " +
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
      "        AND LCR.ISMATCHADJUSTMENT = 'N'" +
      "        AND LCC.M_LANDEDCOST_ID = ?" +
      "        ORDER BY LCC.LINE, IO.DOCUMENTNO, IO.M_INOUT_ID, IOL.LINE";

    ResultSet result;
    Vector<DocLineLandedCostData> vector = new Vector<DocLineLandedCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, LC_Receiptline_Amt);

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
        DocLineLandedCostData objectDocLineLandedCostData = new DocLineLandedCostData();
        objectDocLineLandedCostData.mLcReceiptlineAmtId = UtilSql.getValue(result, "m_lc_receiptline_amt_id");
        objectDocLineLandedCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineLandedCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineLandedCostData.mLcCostId = UtilSql.getValue(result, "m_lc_cost_id");
        objectDocLineLandedCostData.amount = UtilSql.getValue(result, "amount");
        objectDocLineLandedCostData.mLcTypeId = UtilSql.getValue(result, "m_lc_type_id");
        objectDocLineLandedCostData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocLineLandedCostData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineLandedCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineLandedCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineLandedCostData.name = UtilSql.getValue(result, "name");
        objectDocLineLandedCostData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineLandedCostData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineLandedCostData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineLandedCostData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineLandedCostData.user1id = UtilSql.getValue(result, "user1id");
        objectDocLineLandedCostData.user2id = UtilSql.getValue(result, "user2id");
        objectDocLineLandedCostData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineLandedCostData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineLandedCostData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineLandedCostData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocLineLandedCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLandedCostData);
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
    DocLineLandedCostData objectDocLineLandedCostData[] = new DocLineLandedCostData[vector.size()];
    vector.copyInto(objectDocLineLandedCostData);
    return(objectDocLineLandedCostData);
  }

  public static DocLineLandedCostData[] selectLCAccount(ConnectionProvider connectionProvider, String Lc_Type_Id)    throws ServletException {
    return selectLCAccount(connectionProvider, Lc_Type_Id, 0, 0);
  }

  public static DocLineLandedCostData[] selectLCAccount(ConnectionProvider connectionProvider, String Lc_Type_Id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(LCT.ACCOUNT_ID, '') AS ACCOUNT_ID, COALESCE(LCT.M_PRODUCT_ID, '') AS M_PRODUCT_ID, NAME" +
      "        FROM M_LC_TYPE LCT " +
      "        WHERE LCT.M_LC_TYPE_ID = ?";

    ResultSet result;
    Vector<DocLineLandedCostData> vector = new Vector<DocLineLandedCostData>(0);
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
        DocLineLandedCostData objectDocLineLandedCostData = new DocLineLandedCostData();
        objectDocLineLandedCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineLandedCostData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineLandedCostData.name = UtilSql.getValue(result, "name");
        objectDocLineLandedCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLandedCostData);
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
    DocLineLandedCostData objectDocLineLandedCostData[] = new DocLineLandedCostData[vector.size()];
    vector.copyInto(objectDocLineLandedCostData);
    return(objectDocLineLandedCostData);
  }

  public static DocLineLandedCostData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectGlitem(connectionProvider, C_Glitem_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineLandedCostData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT GLITEM_DEBIT_ACCT, GLITEM_CREDIT_ACCT" +
      "        FROM C_GLITEM_ACCT " +
      "        WHERE C_GLITEM_id = ?" +
      "        AND C_ACCTSCHEMA_id = ?";

    ResultSet result;
    Vector<DocLineLandedCostData> vector = new Vector<DocLineLandedCostData>(0);
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
        DocLineLandedCostData objectDocLineLandedCostData = new DocLineLandedCostData();
        objectDocLineLandedCostData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineLandedCostData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineLandedCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLandedCostData);
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
    DocLineLandedCostData objectDocLineLandedCostData[] = new DocLineLandedCostData[vector.size()];
    vector.copyInto(objectDocLineLandedCostData);
    return(objectDocLineLandedCostData);
  }

  public static DocLineLandedCostData[] selectLCProduct(ConnectionProvider connectionProvider, String M_Product_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectLCProduct(connectionProvider, M_Product_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineLandedCostData[] selectLCProduct(ConnectionProvider connectionProvider, String M_Product_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P_EXPENSE_ACCT AS ACCOUNT_ID" +
      "        FROM M_PRODUCT_ACCT " +
      "        WHERE M_PRODUCT_ID = ?" +
      "        AND C_ACCTSCHEMA_id = ?";

    ResultSet result;
    Vector<DocLineLandedCostData> vector = new Vector<DocLineLandedCostData>(0);
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
        DocLineLandedCostData objectDocLineLandedCostData = new DocLineLandedCostData();
        objectDocLineLandedCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineLandedCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLandedCostData);
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
    DocLineLandedCostData objectDocLineLandedCostData[] = new DocLineLandedCostData[vector.size()];
    vector.copyInto(objectDocLineLandedCostData);
    return(objectDocLineLandedCostData);
  }
}
