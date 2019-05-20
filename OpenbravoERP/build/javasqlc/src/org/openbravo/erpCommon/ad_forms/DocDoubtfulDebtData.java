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

class DocDoubtfulDebtData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocDoubtfulDebtData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String mCGlitemId;
  public String percentage;
  public String cCampaignId;
  public String cProjectId;
  public String user1id;
  public String user2id;
  public String cCostcenterId;
  public String aAssetId;
  public String cBpartnerId;
  public String adOrgId;
  public String cActivityId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_c_glitem_id") || fieldName.equals("mCGlitemId"))
      return mCGlitemId;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocDoubtfulDebtData[] select(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return select(connectionProvider, invoice, 0, 0);
  }

  public static DocDoubtfulDebtData[] select(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_INVOICELINE.M_PRODUCT_ID," +
      "        C_INVOICELINE.ACCOUNT_ID AS M_C_GLITEM_ID, " +
      "        SUM(COALESCE(C_INVOICELINE_ACCTDIMENSION.AMT, C_INVOICELINE.LINENETAMT)/C_INVOICE.TOTALLINES)" +
      "        AS percentage," +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, COALESCE(C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID, C_INVOICELINE.C_PROJECT_ID, C_INVOICE.C_PROJECT_ID) AS C_PROJECT_ID," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.USER1_ID,C_INVOICELINE.USER1_ID, C_INVOICELINE.USER1_ID) AS user1Id," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.USER2_ID,C_INVOICELINE.USER2_ID, C_INVOICE.USER2_ID) AS user2Id," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.C_COSTCENTER_ID,C_INVOICELINE.C_COSTCENTER_ID, C_INVOICE.C_COSTCENTER_ID) AS C_COSTCENTER_ID," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.A_ASSET_ID,C_INVOICELINE.A_ASSET_ID, C_INVOICE.A_ASSET_ID) AS A_ASSET_ID," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.C_BPARTNER_ID,C_INVOICELINE.C_BPARTNER_ID, C_INVOICE.C_BPARTNER_ID) AS C_BPARTNER_ID, " +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.AD_ORG_ID,C_INVOICELINE.AD_ORG_ID, C_INVOICE.AD_ORG_ID) AS AD_ORG_ID, C_INVOICELINE_ACCTDIMENSION.C_ACTIVITY_ID" +
      "        FROM C_INVOICE" +
      "        left join C_INVOICELINE on C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "        left join C_INVOICELINE_ACCTDIMENSION on C_INVOICELINE.C_INVOICELINE_ID = C_INVOICELINE_ACCTDIMENSION.C_INVOICELINE_ID" +
      "        WHERE  C_INVOICELINE.C_INVOICE_ID = ?" +
      "        GROUP BY C_INVOICELINE.M_PRODUCT_ID, C_INVOICELINE.ACCOUNT_ID, " +
      "        C_INVOICELINE_ACCTDIMENSION.C_CAMPAIGN_ID, COALESCE(C_INVOICELINE_ACCTDIMENSION.C_PROJECT_ID, C_INVOICELINE.C_PROJECT_ID, C_INVOICE.C_PROJECT_ID)," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.USER1_ID,C_INVOICELINE.USER1_ID, C_INVOICELINE.USER1_ID)," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.USER2_ID, C_INVOICELINE.USER2_ID, C_INVOICE.USER2_ID)," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.C_COSTCENTER_ID, C_INVOICELINE.C_COSTCENTER_ID, C_INVOICE.C_COSTCENTER_ID)," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.A_ASSET_ID,C_INVOICELINE.A_ASSET_ID, C_INVOICE.A_ASSET_ID)," +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.C_BPARTNER_ID,C_INVOICELINE.C_BPARTNER_ID, C_INVOICE.C_BPARTNER_ID), " +
      "        COALESCE(C_INVOICELINE_ACCTDIMENSION.AD_ORG_ID,C_INVOICELINE.AD_ORG_ID, C_INVOICE.AD_ORG_ID), C_INVOICELINE_ACCTDIMENSION.C_ACTIVITY_ID" +
      "        order by 3 desc";

    ResultSet result;
    Vector<DocDoubtfulDebtData> vector = new Vector<DocDoubtfulDebtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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
        DocDoubtfulDebtData objectDocDoubtfulDebtData = new DocDoubtfulDebtData();
        objectDocDoubtfulDebtData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocDoubtfulDebtData.mCGlitemId = UtilSql.getValue(result, "m_c_glitem_id");
        objectDocDoubtfulDebtData.percentage = UtilSql.getValue(result, "percentage");
        objectDocDoubtfulDebtData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocDoubtfulDebtData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocDoubtfulDebtData.user1id = UtilSql.getValue(result, "user1id");
        objectDocDoubtfulDebtData.user2id = UtilSql.getValue(result, "user2id");
        objectDocDoubtfulDebtData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocDoubtfulDebtData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocDoubtfulDebtData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocDoubtfulDebtData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocDoubtfulDebtData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocDoubtfulDebtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocDoubtfulDebtData);
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
    DocDoubtfulDebtData objectDocDoubtfulDebtData[] = new DocDoubtfulDebtData[vector.size()];
    vector.copyInto(objectDocDoubtfulDebtData);
    return(objectDocDoubtfulDebtData);
  }
}
