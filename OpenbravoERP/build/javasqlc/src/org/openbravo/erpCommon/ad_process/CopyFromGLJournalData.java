//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CopyFromGLJournalData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromGLJournalData.class);
  private String InitRecordNumber="0";
  public String glJournalId;
  public String cAcctschemaId;
  public String cDoctypeId;
  public String docstatus;
  public String docaction;
  public String isapproved;
  public String isprinted;
  public String description;
  public String postingtype;
  public String glCategoryId;
  public String cPeriodId;
  public String cCurrencyId;
  public String currencyratetype;
  public String currencyrate;
  public String controlamt;
  public String line;
  public String isgenerated;
  public String amtsourcedr;
  public String amtsourcecr;
  public String amtacctdr;
  public String amtacctcr;
  public String cUomId;
  public String qty;
  public String cValidcombinationId;
  public String glJournalbatchId;
  public String documentno;
  public String isactive;
  public String datedoc;
  public String dateacct;
  public String totaldr;
  public String totalcr;
  public String processing;
  public String processed;
  public String posted;
  public String adOrgId;
  public String user1Id;
  public String user2Id;
  public String cCampaignId;
  public String cProjectId;
  public String cActivityId;
  public String cSalesregionId;
  public String mProductId;
  public String cBpartnerId;
  public String aAssetId;
  public String cCostcenterId;
  public String openItems;
  public String finFinancialAccountId;
  public String finPaymentmethodId;
  public String cGlitemId;
  public String paymentdate;
  public String finPaymentId;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("gl_journal_id") || fieldName.equals("glJournalId"))
      return glJournalId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("isapproved"))
      return isapproved;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("postingtype"))
      return postingtype;
    else if (fieldName.equalsIgnoreCase("gl_category_id") || fieldName.equals("glCategoryId"))
      return glCategoryId;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("currencyratetype"))
      return currencyratetype;
    else if (fieldName.equalsIgnoreCase("currencyrate"))
      return currencyrate;
    else if (fieldName.equalsIgnoreCase("controlamt"))
      return controlamt;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isgenerated"))
      return isgenerated;
    else if (fieldName.equalsIgnoreCase("amtsourcedr"))
      return amtsourcedr;
    else if (fieldName.equalsIgnoreCase("amtsourcecr"))
      return amtsourcecr;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_validcombination_id") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("gl_journalbatch_id") || fieldName.equals("glJournalbatchId"))
      return glJournalbatchId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("totaldr"))
      return totaldr;
    else if (fieldName.equalsIgnoreCase("totalcr"))
      return totalcr;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("open_items") || fieldName.equals("openItems"))
      return openItems;
    else if (fieldName.equalsIgnoreCase("fin_financial_account_id") || fieldName.equals("finFinancialAccountId"))
      return finFinancialAccountId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("paymentdate"))
      return paymentdate;
    else if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromGLJournalData[] select(ConnectionProvider connectionProvider, String glJournalbatchParentId, String gl_journalbatch_id)    throws ServletException {
    return select(connectionProvider, glJournalbatchParentId, gl_journalbatch_id, 0, 0);
  }

  public static CopyFromGLJournalData[] select(ConnectionProvider connectionProvider, String glJournalbatchParentId, String gl_journalbatch_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT GL.GL_JOURNAL_ID, GL.C_ACCTSCHEMA_ID, GL.C_DOCTYPE_ID, GL.DOCSTATUS, GL.DOCACTION, GL.ISAPPROVED, GL.ISPRINTED, " +
      "        GL.DESCRIPTION," +
      "        GL.POSTINGTYPE, GL.GL_CATEGORY_ID, " +
      "        (SELECT GL2.C_PERIOD_ID FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS C_PERIOD_ID, " +
      "        GL.C_CURRENCY_ID, GL.CURRENCYRATETYPE, GL.CURRENCYRATE," +
      "        GL.CONTROLAMT, '' AS LINE, '' AS ISGENERATED, '' AS AMTSOURCEDR, '' AS AMTSOURCECR, '' AS AMTACCTDR, '' AS AMTACCTCR," +
      "        '' AS C_UOM_ID, '' AS QTY, '' AS C_VALIDCOMBINATION_ID, '' AS GL_JOURNALBATCH_ID, '' AS DOCUMENTNO, '' AS ISACTIVE," +
      "        (SELECT GL2.DATEDOC FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS DATEDOC," +
      "        (SELECT GL2.DATEACCT FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS DATEACCT," +
      "        '' AS TOTALDR, '' AS TOTALCR, '' AS PROCESSING, '' AS PROCESSED, '' AS POSTED," +
      "        (SELECT GL2.AD_ORG_ID FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS AD_ORG_ID, USER1_ID, USER2_ID, " +
      "        C_CAMPAIGN_ID,  C_PROJECT_ID, '' AS C_ACTIVITY_ID, '' AS C_SALESREGION_ID,   M_PRODUCT_ID,  C_BPARTNER_ID," +
      "        A_ASSET_ID, C_COSTCENTER_ID, " +
      "        '' as OPEN_ITEMS, '' as FIN_FINANCIAL_ACCOUNT_ID, '' as FIN_PAYMENTMETHOD_ID,  '' as C_GLITEM_ID, '' as PAYMENTDATE, '' as FIN_PAYMENT_ID" +
      "        FROM GL_JOURNAL GL" +
      "        WHERE GL.GL_JOURNALBATCH_ID = ?";

    ResultSet result;
    Vector<CopyFromGLJournalData> vector = new Vector<CopyFromGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journalbatch_id);

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
        CopyFromGLJournalData objectCopyFromGLJournalData = new CopyFromGLJournalData();
        objectCopyFromGLJournalData.glJournalId = UtilSql.getValue(result, "gl_journal_id");
        objectCopyFromGLJournalData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectCopyFromGLJournalData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCopyFromGLJournalData.docstatus = UtilSql.getValue(result, "docstatus");
        objectCopyFromGLJournalData.docaction = UtilSql.getValue(result, "docaction");
        objectCopyFromGLJournalData.isapproved = UtilSql.getValue(result, "isapproved");
        objectCopyFromGLJournalData.isprinted = UtilSql.getValue(result, "isprinted");
        objectCopyFromGLJournalData.description = UtilSql.getValue(result, "description");
        objectCopyFromGLJournalData.postingtype = UtilSql.getValue(result, "postingtype");
        objectCopyFromGLJournalData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectCopyFromGLJournalData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectCopyFromGLJournalData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromGLJournalData.currencyratetype = UtilSql.getValue(result, "currencyratetype");
        objectCopyFromGLJournalData.currencyrate = UtilSql.getValue(result, "currencyrate");
        objectCopyFromGLJournalData.controlamt = UtilSql.getValue(result, "controlamt");
        objectCopyFromGLJournalData.line = UtilSql.getValue(result, "line");
        objectCopyFromGLJournalData.isgenerated = UtilSql.getValue(result, "isgenerated");
        objectCopyFromGLJournalData.amtsourcedr = UtilSql.getValue(result, "amtsourcedr");
        objectCopyFromGLJournalData.amtsourcecr = UtilSql.getValue(result, "amtsourcecr");
        objectCopyFromGLJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectCopyFromGLJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectCopyFromGLJournalData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromGLJournalData.qty = UtilSql.getValue(result, "qty");
        objectCopyFromGLJournalData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectCopyFromGLJournalData.glJournalbatchId = UtilSql.getValue(result, "gl_journalbatch_id");
        objectCopyFromGLJournalData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromGLJournalData.isactive = UtilSql.getValue(result, "isactive");
        objectCopyFromGLJournalData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectCopyFromGLJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCopyFromGLJournalData.totaldr = UtilSql.getValue(result, "totaldr");
        objectCopyFromGLJournalData.totalcr = UtilSql.getValue(result, "totalcr");
        objectCopyFromGLJournalData.processing = UtilSql.getValue(result, "processing");
        objectCopyFromGLJournalData.processed = UtilSql.getValue(result, "processed");
        objectCopyFromGLJournalData.posted = UtilSql.getValue(result, "posted");
        objectCopyFromGLJournalData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCopyFromGLJournalData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCopyFromGLJournalData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCopyFromGLJournalData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectCopyFromGLJournalData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCopyFromGLJournalData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectCopyFromGLJournalData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectCopyFromGLJournalData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCopyFromGLJournalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromGLJournalData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCopyFromGLJournalData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCopyFromGLJournalData.openItems = UtilSql.getValue(result, "open_items");
        objectCopyFromGLJournalData.finFinancialAccountId = UtilSql.getValue(result, "fin_financial_account_id");
        objectCopyFromGLJournalData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectCopyFromGLJournalData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectCopyFromGLJournalData.paymentdate = UtilSql.getValue(result, "paymentdate");
        objectCopyFromGLJournalData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectCopyFromGLJournalData.position = Long.toString(countRecord);
        objectCopyFromGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromGLJournalData);
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
    CopyFromGLJournalData objectCopyFromGLJournalData[] = new CopyFromGLJournalData[vector.size()];
    vector.copyInto(objectCopyFromGLJournalData);
    return(objectCopyFromGLJournalData);
  }

  public static CopyFromGLJournalData[] selectLines(ConnectionProvider connectionProvider, String gl_journal_id)    throws ServletException {
    return selectLines(connectionProvider, gl_journal_id, 0, 0);
  }

  public static CopyFromGLJournalData[] selectLines(ConnectionProvider connectionProvider, String gl_journal_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LINE, ISGENERATED, gll.DESCRIPTION, AMTSOURCEDR, AMTSOURCECR, gll.C_CURRENCY_ID, gll.CURRENCYRATETYPE, gll.CURRENCYRATE," +
      "		AMTACCTDR, AMTACCTCR, C_UOM_ID, QTY, C_VALIDCOMBINATION_ID,coalesce(gll.USER1_ID,gl.USER1_ID) as USER1_ID, coalesce(gll.USER2_ID,gl.USER2_ID) as USER2_ID, " +
      "		coalesce(gll.C_CAMPAIGN_ID, gl.C_CAMPAIGN_ID) as C_CAMPAIGN_ID , coalesce(gll.C_PROJECT_ID,gl.C_PROJECT_ID) as C_PROJECT_ID,  " +
      "		gll.C_ACTIVITY_ID , gll.C_SALESREGION_ID , " +
      "		coalesce(gll.M_PRODUCT_ID,gl.M_PRODUCT_ID) as M_PRODUCT_ID, coalesce(gll.C_BPARTNER_ID,gl.C_BPARTNER_ID) as C_BPARTNER_ID, " +
      "		gll.AD_ORG_ID, coalesce(gll.A_ASSET_ID,gl.A_ASSET_ID) as A_ASSET_ID, coalesce(gll.C_COSTCENTER_ID,gl.C_COSTCENTER_ID) as C_COSTCENTER_ID," +
      "		gll.OPEN_ITEMS, gll.FIN_FINANCIAL_ACCOUNT_ID, gll.FIN_PAYMENTMETHOD_ID,  gll.C_GLITEM_ID, gll.PAYMENTDATE, gll.FIN_PAYMENT_ID   " +
      "		FROM GL_JOURNALLINE gll, GL_JOURNAL gl" +
      "		WHERE gl.gl_journal_id=gll.gl_journal_id" +
      "        AND gll.GL_JOURNAL_ID = ?";

    ResultSet result;
    Vector<CopyFromGLJournalData> vector = new Vector<CopyFromGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);

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
        CopyFromGLJournalData objectCopyFromGLJournalData = new CopyFromGLJournalData();
        objectCopyFromGLJournalData.line = UtilSql.getValue(result, "line");
        objectCopyFromGLJournalData.isgenerated = UtilSql.getValue(result, "isgenerated");
        objectCopyFromGLJournalData.description = UtilSql.getValue(result, "description");
        objectCopyFromGLJournalData.amtsourcedr = UtilSql.getValue(result, "amtsourcedr");
        objectCopyFromGLJournalData.amtsourcecr = UtilSql.getValue(result, "amtsourcecr");
        objectCopyFromGLJournalData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromGLJournalData.currencyratetype = UtilSql.getValue(result, "currencyratetype");
        objectCopyFromGLJournalData.currencyrate = UtilSql.getValue(result, "currencyrate");
        objectCopyFromGLJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectCopyFromGLJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectCopyFromGLJournalData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromGLJournalData.qty = UtilSql.getValue(result, "qty");
        objectCopyFromGLJournalData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectCopyFromGLJournalData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCopyFromGLJournalData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCopyFromGLJournalData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectCopyFromGLJournalData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCopyFromGLJournalData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectCopyFromGLJournalData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectCopyFromGLJournalData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCopyFromGLJournalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromGLJournalData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCopyFromGLJournalData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCopyFromGLJournalData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCopyFromGLJournalData.openItems = UtilSql.getValue(result, "open_items");
        objectCopyFromGLJournalData.finFinancialAccountId = UtilSql.getValue(result, "fin_financial_account_id");
        objectCopyFromGLJournalData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectCopyFromGLJournalData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectCopyFromGLJournalData.paymentdate = UtilSql.getDateValue(result, "paymentdate", "dd-MM-yyyy");
        objectCopyFromGLJournalData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectCopyFromGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromGLJournalData);
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
    CopyFromGLJournalData objectCopyFromGLJournalData[] = new CopyFromGLJournalData[vector.size()];
    vector.copyInto(objectCopyFromGLJournalData);
    return(objectCopyFromGLJournalData);
  }

  public static CopyFromGLJournalData[] selectFrom(ConnectionProvider connectionProvider, String description, String documentNo, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectFrom(connectionProvider, description, documentNo, adUserClient, adUserOrg, key, 0, 0);
  }

  public static CopyFromGLJournalData[] selectFrom(ConnectionProvider connectionProvider, String description, String documentNo, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT G.GL_JOURNALBATCH_ID, G.DOCUMENTNO, G.DESCRIPTION, G.ISACTIVE,(SELECT L.NAME " +
      "                                                                        FROM AD_REF_LIST L " +
      "                                                                        WHERE L.AD_REFERENCE_ID='125' " +
      "                                                                        AND L.VALUE=G.POSTINGTYPE) AS POSTINGTYPE, " +
      "        G.DATEDOC, G.DATEACCT, G.CONTROLAMT, G.TOTALDR, G.TOTALCR " +
      "        FROM GL_JOURNALBATCH G" +
      "        WHERE G.ISACTIVE='Y' " +
      "        AND ISTEMPLATE='Y' " +
      "        AND 1=1";
    strSql = strSql + ((description==null || description.equals(""))?"":"  AND UPPER(COALESCE(TO_CHAR(G.DESCRIPTION),' ')) LIKE UPPER(?)  ");
    strSql = strSql + ((documentNo==null || documentNo.equals("") || documentNo.equals("%") )?"":"  AND UPPER(G.DOCUMENTNO) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        AND G.AD_CLIENT_ID IN('";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      "') " +
      "        AND G.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and ad_isorgincluded(g.ad_org_id,(select ad_org_id from GL_JOURNALBATCH where GL_JOURNALBATCH_id = ?) , g.ad_client_id) <> -1" +
      "        AND EXISTS (SELECT 1 FROM GL_JOURNAL WHERE GL_JOURNALBATCH_ID = G.GL_JOURNALBATCH_ID)" +
      "        ORDER BY 2";

    ResultSet result;
    Vector<CopyFromGLJournalData> vector = new Vector<CopyFromGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (description != null && !(description.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (documentNo != null && !(documentNo.equals("")) && !(documentNo.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        CopyFromGLJournalData objectCopyFromGLJournalData = new CopyFromGLJournalData();
        objectCopyFromGLJournalData.glJournalbatchId = UtilSql.getValue(result, "gl_journalbatch_id");
        objectCopyFromGLJournalData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromGLJournalData.description = UtilSql.getValue(result, "description");
        objectCopyFromGLJournalData.isactive = UtilSql.getValue(result, "isactive");
        objectCopyFromGLJournalData.postingtype = UtilSql.getValue(result, "postingtype");
        objectCopyFromGLJournalData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectCopyFromGLJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCopyFromGLJournalData.controlamt = UtilSql.getValue(result, "controlamt");
        objectCopyFromGLJournalData.totaldr = UtilSql.getValue(result, "totaldr");
        objectCopyFromGLJournalData.totalcr = UtilSql.getValue(result, "totalcr");
        objectCopyFromGLJournalData.position = Long.toString(countRecord);
        objectCopyFromGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromGLJournalData);
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
    CopyFromGLJournalData objectCopyFromGLJournalData[] = new CopyFromGLJournalData[vector.size()];
    vector.copyInto(objectCopyFromGLJournalData);
    return(objectCopyFromGLJournalData);
  }

  public static int insertGLJournal(Connection conn, ConnectionProvider connectionProvider, String gl_journal_id, String ad_client_id, String ad_org_id, String user, String c_acctschema_id, String c_doctype_id, String docstatus, String docaction, String isapproved, String isprinted, String description, String postingtype, String gl_category_id, String datedoc, String dateacct, String c_period_id, String c_currency_id, String currencyratetype, String currencyrate, String gl_journalbatch_id, String controlamt, String documentNo, String processing, String processed, String posted, String user1_id, String user2_id, String c_campaign_id, String c_project_id, String a_asset_id, String c_costcenter_id, String c_bpartner_id, String m_product_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO GL_JOURNAL (GL_JOURNAL_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, C_ACCTSCHEMA_ID,C_DOCTYPE_ID, DOCSTATUS,DOCACTION, ISAPPROVED, ISPRINTED, " +
      "        DESCRIPTION, POSTINGTYPE, GL_CATEGORY_ID, DATEDOC, DATEACCT,C_PERIOD_ID, C_CURRENCY_ID, " +
      "        CURRENCYRATETYPE,CURRENCYRATE, GL_JOURNALBATCH_ID, CONTROLAMT, DOCUMENTNO, PROCESSING, PROCESSED, POSTED," +
      "        USER1_ID, USER2_ID, C_CAMPAIGN_ID, C_PROJECT_ID,   A_ASSET_ID,  C_COSTCENTER_ID, C_BPARTNER_ID, M_PRODUCT_ID) " +
      "        VALUES (?,?,?,now(),?," +
      "        	now(),?,?,?,?,?,?,?," +
      "        	?,?,?,TO_DATE(?),TO_DATE(?),?,?," +
      "        	?,TO_NUMBER(?),?,TO_NUMBER(?),?,?,?,?,?,?,?,?,?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_acctschema_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_doctype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapproved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postingtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_category_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journalbatch_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, controlamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_campaign_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, a_asset_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_costcenter_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartner_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertGLJournalLine(Connection conn, ConnectionProvider connectionProvider, String gl_journalline_id, String ad_client_id, String ad_org_id, String user, String gl_journal_id, String line, String isgenerated, String description, String amtsourcedr, String amtsourcecr, String c_currency_id, String currencyratetype, String currencyrate, String amtacctdr, String amtacctcr, String c_uom_id, String qty, String c_validcombination_id, String user1_id, String user2_id, String c_campaign_id, String c_project_id, String c_activity_id, String c_salesregion_id, String m_product_id, String c_bpartner_id, String a_asset_id, String c_costcenter_id, String Open_Items, String FIN_Financial_Account_ID, String fin_Paymentmethod_ID, String C_Glitem_ID, String Paymentdate, String FIN_Payment_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO GL_JOURNALLINE (GL_JOURNALLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, GL_JOURNAL_ID,LINE, ISGENERATED, DESCRIPTION,AMTSOURCEDR, AMTSOURCECR, C_CURRENCY_ID, " +
      "        CURRENCYRATETYPE, CURRENCYRATE, DATEACCT,AMTACCTDR, AMTACCTCR, C_UOM_ID,QTY, C_VALIDCOMBINATION_ID," +
      "        USER1_ID, USER2_ID, C_CAMPAIGN_ID, C_PROJECT_ID, C_ACTIVITY_ID, C_SALESREGION_ID, M_PRODUCT_ID, C_BPARTNER_ID,  A_ASSET_ID,  C_COSTCENTER_ID," +
      "        OPEN_ITEMS, FIN_FINANCIAL_ACCOUNT_ID, FIN_PAYMENTMETHOD_ID,  C_GLITEM_ID, PAYMENTDATE, FIN_PAYMENT_ID) " +
      "        VALUES (?,?,?,now(),?,now(),?,?,TO_NUMBER(?),?,?,TO_NUMBER(?),TO_NUMBER(?),?,?,TO_NUMBER(?),now(),TO_NUMBER(?)," +
      "        TO_NUMBER(?),?,TO_NUMBER(?), ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?," +
      "        ?,?,?,?,TO_DATE(?), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journalline_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgenerated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcedr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcecr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_uom_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_validcombination_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_campaign_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_activity_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_salesregion_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartner_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, a_asset_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_costcenter_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Open_Items);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, FIN_Financial_Account_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fin_Paymentmethod_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Glitem_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Paymentdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, FIN_Payment_ID);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
