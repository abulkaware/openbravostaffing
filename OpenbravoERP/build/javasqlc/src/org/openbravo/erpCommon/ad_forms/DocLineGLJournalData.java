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

class DocLineGLJournalData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineGLJournalData.class);
  private String InitRecordNumber="0";
  public String glJournallineId;
  public String adClientId;
  public String adOrgId;
  public String line;
  public String description;
  public String cCurrencyId;
  public String amtsourcedr;
  public String amtsourcecr;
  public String currencyratetype;
  public String currencyrate;
  public String dateacct;
  public String amtacctdr;
  public String amtacctcr;
  public String cUomId;
  public String qty;
  public String cAcctschemaId;
  public String cValidcombinationId;
  public String mCGlitemId;
  public String adOrgtrxId;
  public String cLocfromId;
  public String cLoctoId;
  public String mProductId;
  public String cBpartnerId;
  public String cSalesregionId;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String cCostcenterId;
  public String aAssetId;
  public String cDebtPaymentId;
  public String cWithholdingId;
  public String cTaxId;
  public String glitemDebitAcct;
  public String glitemCreditAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("gl_journalline_id") || fieldName.equals("glJournallineId"))
      return glJournallineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("amtsourcedr"))
      return amtsourcedr;
    else if (fieldName.equalsIgnoreCase("amtsourcecr"))
      return amtsourcecr;
    else if (fieldName.equalsIgnoreCase("currencyratetype"))
      return currencyratetype;
    else if (fieldName.equalsIgnoreCase("currencyrate"))
      return currencyrate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_validcombination_id") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("m_c_glitem_id") || fieldName.equals("mCGlitemId"))
      return mCGlitemId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_locfrom_id") || fieldName.equals("cLocfromId"))
      return cLocfromId;
    else if (fieldName.equalsIgnoreCase("c_locto_id") || fieldName.equals("cLoctoId"))
      return cLoctoId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("c_withholding_id") || fieldName.equals("cWithholdingId"))
      return cWithholdingId;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("glitem_debit_acct") || fieldName.equals("glitemDebitAcct"))
      return glitemDebitAcct;
    else if (fieldName.equalsIgnoreCase("glitem_credit_acct") || fieldName.equals("glitemCreditAcct"))
      return glitemCreditAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineGLJournalData[] select(ConnectionProvider connectionProvider, String GL_Journal_ID)    throws ServletException {
    return select(connectionProvider, GL_Journal_ID, 0, 0);
  }

  public static DocLineGLJournalData[] select(ConnectionProvider connectionProvider, String GL_Journal_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT " +
      "            JL.GL_JOURNALLINE_ID," +
      "            JL.AD_CLIENT_ID," +
      "            JL.AD_ORG_ID," +
      "            JL.LINE," +
      "            JL.DESCRIPTION," +
      "            JL.C_CURRENCY_ID," +
      "            JL.AMTSOURCEDR," +
      "            JL.AMTSOURCECR," +
      "            JL.CURRENCYRATETYPE," +
      "            JL.CURRENCYRATE," +
      "            J.DATEACCT,JL.AMTACCTDR," +
      "            JL.AMTACCTCR," +
      "            JL.C_UOM_ID," +
      "            JL.Qty," +
      "            VC.C_ACCTSCHEMA_ID," +
      "            VC.C_VALIDCOMBINATION_ID," +
      "            JL.ACCOUNT_ID  AS M_C_GLITEM_ID," +
      "            VC.AD_ORGTRX_ID," +
      "            VC.C_LOCFROM_ID," +
      "            VC.C_LOCTO_ID," +
      "            COALESCE(JL.M_PRODUCT_ID, VC.M_PRODUCT_ID) AS M_PRODUCT_ID," +
      "            COALESCE(JL.C_BPARTNER_ID, VC.C_BPARTNER_ID) AS C_BPARTNER_ID," +
      "            COALESCE(JL.C_SALESREGION_ID,VC.C_SALESREGION_ID) AS C_SALESREGION_ID," +
      "            COALESCE(JL.C_PROJECT_ID,VC.C_PROJECT_ID) AS C_PROJECT_ID," +
      "            COALESCE(JL.C_CAMPAIGN_ID,VC.C_CAMPAIGN_ID) AS C_CAMPAIGN_ID," +
      "            COALESCE(JL.C_ACTIVITY_ID,VC.C_ACTIVITY_ID) AS C_ACTIVITY_ID," +
      "            COALESCE(JL.USER1_ID,VC.USER1_ID) AS USER1_ID," +
      "            COALESCE(JL.USER2_ID,VC.USER2_ID) AS USER2_ID," +
      "            JL.C_COSTCENTER_ID,JL.A_ASSET_ID," +
      "            JL.C_DEBT_PAYMENT_ID,JL.C_WITHHOLDING_ID," +
      "            JL.C_TAX_ID," +
      "            '' AS GLITEM_DEBIT_ACCT," +
      "            '' as GLITEM_CREDIT_ACCT " +
      "        FROM  " +
      "            GL_JOURNALLINE JL INNER JOIN GL_JOURNAL J ON J.GL_JOURNAL_ID = JL.GL_JOURNAL_ID " +
      "            LEFT JOIN C_VALIDCOMBINATION VC ON VC.C_VALIDCOMBINATION_ID=JL.C_VALIDCOMBINATION_ID" +
      "        WHERE  JL.GL_JOURNAL_ID = ? AND JL.ISACTIVE='Y' AND ((VC.ISFULLYQUALIFIED='Y' AND " +
      "        JL.C_VALIDCOMBINATION_ID IS NOT NULL) OR (JL.C_VALIDCOMBINATION_ID IS NULL) ) ORDER BY JL.LINE";

    ResultSet result;
    Vector<DocLineGLJournalData> vector = new Vector<DocLineGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, GL_Journal_ID);

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
        DocLineGLJournalData objectDocLineGLJournalData = new DocLineGLJournalData();
        objectDocLineGLJournalData.glJournallineId = UtilSql.getValue(result, "gl_journalline_id");
        objectDocLineGLJournalData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineGLJournalData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineGLJournalData.line = UtilSql.getValue(result, "line");
        objectDocLineGLJournalData.description = UtilSql.getValue(result, "description");
        objectDocLineGLJournalData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineGLJournalData.amtsourcedr = UtilSql.getValue(result, "amtsourcedr");
        objectDocLineGLJournalData.amtsourcecr = UtilSql.getValue(result, "amtsourcecr");
        objectDocLineGLJournalData.currencyratetype = UtilSql.getValue(result, "currencyratetype");
        objectDocLineGLJournalData.currencyrate = UtilSql.getValue(result, "currencyrate");
        objectDocLineGLJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocLineGLJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectDocLineGLJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectDocLineGLJournalData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineGLJournalData.qty = UtilSql.getValue(result, "qty");
        objectDocLineGLJournalData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectDocLineGLJournalData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectDocLineGLJournalData.mCGlitemId = UtilSql.getValue(result, "m_c_glitem_id");
        objectDocLineGLJournalData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocLineGLJournalData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectDocLineGLJournalData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectDocLineGLJournalData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineGLJournalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineGLJournalData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectDocLineGLJournalData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineGLJournalData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineGLJournalData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocLineGLJournalData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineGLJournalData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineGLJournalData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineGLJournalData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineGLJournalData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectDocLineGLJournalData.cWithholdingId = UtilSql.getValue(result, "c_withholding_id");
        objectDocLineGLJournalData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocLineGLJournalData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineGLJournalData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineGLJournalData);
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
    DocLineGLJournalData objectDocLineGLJournalData[] = new DocLineGLJournalData[vector.size()];
    vector.copyInto(objectDocLineGLJournalData);
    return(objectDocLineGLJournalData);
  }

  public static DocLineGLJournalData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID)    throws ServletException {
    return selectGlitem(connectionProvider, C_Glitem_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocLineGLJournalData[] selectGlitem(ConnectionProvider connectionProvider, String C_Glitem_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT GLITEM_DEBIT_ACCT, GLITEM_CREDIT_ACCT" +
      "    FROM C_GLITEM_ACCT " +
      "    WHERE C_GLITEM_id = ?" +
      "    AND C_ACCTSCHEMA_id = ?";

    ResultSet result;
    Vector<DocLineGLJournalData> vector = new Vector<DocLineGLJournalData>(0);
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
        DocLineGLJournalData objectDocLineGLJournalData = new DocLineGLJournalData();
        objectDocLineGLJournalData.glitemDebitAcct = UtilSql.getValue(result, "glitem_debit_acct");
        objectDocLineGLJournalData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineGLJournalData);
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
    DocLineGLJournalData objectDocLineGLJournalData[] = new DocLineGLJournalData[vector.size()];
    vector.copyInto(objectDocLineGLJournalData);
    return(objectDocLineGLJournalData);
  }
}
