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

class EndYearCloseUtilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(EndYearCloseUtilityData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String totalamtdr;
  public String totalamtcr;
  public String accountId;
  public String org;
  public String acctvalue;
  public String acctdescription;
  public String value;
  public String cBpartnerId;
  public String mProductId;
  public String aAssetId;
  public String regcount;
  public String cTaxId;
  public String cProjectId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String cCampaignId;
  public String cSalesregionId;
  public String regFactAcctGroupId;
  public String closeFactAcctGroupId;
  public String divideupFactAcctGroupId;
  public String openFactAcctGroupId;
  public String adOrgClosingId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("totalamtdr"))
      return totalamtdr;
    else if (fieldName.equalsIgnoreCase("totalamtcr"))
      return totalamtcr;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("acctvalue"))
      return acctvalue;
    else if (fieldName.equalsIgnoreCase("acctdescription"))
      return acctdescription;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("regcount"))
      return regcount;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("reg_fact_acct_group_id") || fieldName.equals("regFactAcctGroupId"))
      return regFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("close_fact_acct_group_id") || fieldName.equals("closeFactAcctGroupId"))
      return closeFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("divideup_fact_acct_group_id") || fieldName.equals("divideupFactAcctGroupId"))
      return divideupFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("open_fact_acct_group_id") || fieldName.equals("openFactAcctGroupId"))
      return openFactAcctGroupId;
    else if (fieldName.equalsIgnoreCase("ad_org_closing_id") || fieldName.equals("adOrgClosingId"))
      return adOrgClosingId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EndYearCloseUtilityData[] select(ConnectionProvider connectionProvider, String ad_client_id, String adOrgClient, String c_year_id)    throws ServletException {
    return select(connectionProvider, ad_client_id, adOrgClient, c_year_id, 0, 0);
  }

  public static EndYearCloseUtilityData[] select(ConnectionProvider connectionProvider, String ad_client_id, String adOrgClient, String c_year_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select ad_org.ad_org_id as id, ad_org.name as name," +
      "          '' AS TOTALAMTDR, '' AS TOTALAMTCR, '' AS ACCOUNT_ID, '' as org, '' as acctvalue, '' as acctdescription, '' as value," +
      "          '' as c_bpartner_id, '' as m_product_id, '' as a_asset_id, '' AS REGCOUNT," +
      "          '' AS C_TAX_ID, '' AS C_PROJECT_ID, '' AS  C_ACTIVITY_ID, '' AS USER1_ID, '' AS  USER2_ID, '' AS  C_CAMPAIGN_ID," +
      "          '' AS  C_SALESREGION_ID, '' AS REG_FACT_ACCT_GROUP_ID, '' AS CLOSE_FACT_ACCT_GROUP_ID, '' AS DIVIDEUP_FACT_ACCT_GROUP_ID," +
      "        '' AS OPEN_FACT_ACCT_GROUP_ID, '' AS AD_ORG_CLOSING_ID" +
      "		from ad_org" +
      "		where ad_org.isperiodcontrolallowed = 'Y'" +
      "		and ad_client_id = ?" +
      "		and ad_org_id in (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        and not exists (SELECT AD_ORG_CLOSING.AD_ORG_ID" +
      "                        FROM AD_ORG_CLOSING" +
      "                        WHERE C_YEAR_ID = ?" +
      "                          AND AD_ORG_CLOSING.AD_ORG_ID=AD_ORG.AD_ORG_ID)" +
      "        and ad_org.c_calendar_id=(select c_calendar_id from c_year where c_year_id=?)";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_year_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_year_id);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.id = UtilSql.getValue(result, "id");
        objectEndYearCloseUtilityData.name = UtilSql.getValue(result, "name");
        objectEndYearCloseUtilityData.totalamtdr = UtilSql.getValue(result, "totalamtdr");
        objectEndYearCloseUtilityData.totalamtcr = UtilSql.getValue(result, "totalamtcr");
        objectEndYearCloseUtilityData.accountId = UtilSql.getValue(result, "account_id");
        objectEndYearCloseUtilityData.org = UtilSql.getValue(result, "org");
        objectEndYearCloseUtilityData.acctvalue = UtilSql.getValue(result, "acctvalue");
        objectEndYearCloseUtilityData.acctdescription = UtilSql.getValue(result, "acctdescription");
        objectEndYearCloseUtilityData.value = UtilSql.getValue(result, "value");
        objectEndYearCloseUtilityData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectEndYearCloseUtilityData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectEndYearCloseUtilityData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectEndYearCloseUtilityData.regcount = UtilSql.getValue(result, "regcount");
        objectEndYearCloseUtilityData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectEndYearCloseUtilityData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectEndYearCloseUtilityData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectEndYearCloseUtilityData.user1Id = UtilSql.getValue(result, "user1_id");
        objectEndYearCloseUtilityData.user2Id = UtilSql.getValue(result, "user2_id");
        objectEndYearCloseUtilityData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectEndYearCloseUtilityData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectEndYearCloseUtilityData.regFactAcctGroupId = UtilSql.getValue(result, "reg_fact_acct_group_id");
        objectEndYearCloseUtilityData.closeFactAcctGroupId = UtilSql.getValue(result, "close_fact_acct_group_id");
        objectEndYearCloseUtilityData.divideupFactAcctGroupId = UtilSql.getValue(result, "divideup_fact_acct_group_id");
        objectEndYearCloseUtilityData.openFactAcctGroupId = UtilSql.getValue(result, "open_fact_acct_group_id");
        objectEndYearCloseUtilityData.adOrgClosingId = UtilSql.getValue(result, "ad_org_closing_id");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static EndYearCloseUtilityData[] getTotalAmounts(Connection conn, ConnectionProvider connectionProvider, String c_year_id, String accounttype, String org, String acctSchema)    throws ServletException {
    return getTotalAmounts(conn, connectionProvider, c_year_id, accounttype, org, acctSchema, 0, 0);
  }

  public static EndYearCloseUtilityData[] getTotalAmounts(Connection conn, ConnectionProvider connectionProvider, String c_year_id, String accounttype, String org, String acctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE((CASE SIGN(SUM(AMTACCTDR)-SUM(AMTACCTCR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTDR)-SUM(AMTACCTCR)) END),0) AS TOTALAMTCR," +
      "        COALESCE((CASE SIGN(SUM(AMTACCTCR)-SUM(AMTACCTDR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTCR)-SUM(AMTACCTDR)) END),0) AS TOTALAMTDR" +
      "        FROM FACT_ACCT" +
      "        WHERE EXISTS (SELECT 1 FROM C_PERIOD P" +
      "                  WHERE P.C_YEAR_ID = ?" +
      "                  AND P.C_PERIOD_ID = FACT_ACCT.C_PERIOD_ID)" +
      "        AND ACCOUNT_ID IN (SELECT C_ELEMENTVALUE_ID" +
      "            FROM C_ELEMENTVALUE" +
      "            WHERE C_ELEMENTVALUE.ACCOUNTTYPE = ?)" +
      "        AND AD_ORG_ID = ?" +
      "        AND C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_year_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.totalamtcr = UtilSql.getValue(result, "totalamtcr");
        objectEndYearCloseUtilityData.totalamtdr = UtilSql.getValue(result, "totalamtdr");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String fact_acct_id, String ad_client_id, String ad_org_id, String ad_user_id, String c_acctschema_id, String account_id, String date, String c_period_id, String ad_table_id, String postingtype, String c_currency_id, String amtsourcedr, String amtsourcecr, String amtacctdr, String amtacctcr, String fact_acct_group_id, String seqno, String acctdescription, String value, String bpartner, String product, String asset, String description, String c_tax_id, String c_project_id, String c_activity_id, String user1_id, String user2_id, String c_campaign_id, String c_salesregion_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO FACT_ACCT" +
      "          (FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "           ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           C_ACCTSCHEMA_ID,ACCOUNT_ID, DATETRX, DATEACCT," +
      "           C_PERIOD_ID, AD_TABLE_ID, RECORD_ID," +
      "           POSTINGTYPE,C_CURRENCY_ID, AMTSOURCEDR," +
      "           AMTSOURCECR,AMTACCTDR, AMTACCTCR," +
      "           FACT_ACCT_GROUP_ID,SEQNO, FACTACCTTYPE," +
      "           ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID," +
      "           M_PRODUCT_ID, A_ASSET_ID," +
      "           DESCRIPTION,C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID," +
      "           USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID)" +
      "        VALUES" +
      "          ( ?,?,?," +
      "           'Y',now(),?,now(),?," +
      "           ?,?,TO_DATE(?),TO_DATE(?)," +
      "           ?,?,?," +
      "           ?,?,TO_NUMBER(?)," +
      "           TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?)," +
      "           ?,TO_NUMBER(?), 'R'," +
      "           ?, ?, ?," +
      "           ?, ?," +
      "           ?,?,?,?," +
      "           ?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_acctschema_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, account_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_table_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postingtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcedr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcecr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_tax_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_activity_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_campaign_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_salesregion_id);

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

  public static int insertSelect(Connection conn, ConnectionProvider connectionProvider, String ad_client_id, String ad_org_id, String ad_user_id, String date, String c_period_id, String c_currency_id, String fact_acct_group_id, String seqno, String factAcctType, String description, String year, String accounttype, String acctSchema, String divideUpFactAcctGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO FACT_ACCT" +
      "        (FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "        ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_ACCTSCHEMA_ID,ACCOUNT_ID, DATETRX, DATEACCT," +
      "        C_PERIOD_ID, AD_TABLE_ID, RECORD_ID," +
      "        POSTINGTYPE,C_CURRENCY_ID, AMTSOURCEDR," +
      "        AMTSOURCECR,AMTACCTDR, AMTACCTCR," +
      "        FACT_ACCT_GROUP_ID,SEQNO, FACTACCTTYPE," +
      "        ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID," +
      "        M_PRODUCT_ID, A_ASSET_ID, DESCRIPTION," +
      "        C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID," +
      "        USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID)" +
      "        SELECT get_UUID(), ?, ?," +
      "        'Y', now(), ?, now(), ?," +
      "        C_ACCTSCHEMA_ID, ACCOUNT_ID, to_date(?), to_date(?)," +
      "        ?, '145', ?, " +
      "        'A', ?, (CASE SIGN(SUM(AMTACCTCR)-SUM(AMTACCTDR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTCR)-SUM(AMTACCTDR)) END)," +
      "        (CASE SIGN(SUM(AMTACCTDR)-SUM(AMTACCTCR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTDR)-SUM(AMTACCTCR)) END)," +
      "        (CASE SIGN(SUM(AMTACCTCR)-SUM(AMTACCTDR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTCR)-SUM(AMTACCTDR)) END), " +
      "        (CASE SIGN(SUM(AMTACCTDR)-SUM(AMTACCTCR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTDR)-SUM(AMTACCTCR)) END)," +
      "        ?, to_number(?), ?, " +
      "        ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID, " +
      "        M_PRODUCT_ID, A_ASSET_ID, ?," +
      "        C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID," +
      "        USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID" +
      "        FROM FACT_ACCT" +
      "        WHERE EXISTS (SELECT 1 FROM C_PERIOD P" +
      "                  WHERE P.C_YEAR_ID = ?" +
      "                  AND P.C_PERIOD_ID = FACT_ACCT.C_PERIOD_ID)" +
      "        AND EXISTS (SELECT 1" +
      "            FROM C_ELEMENTVALUE" +
      "            WHERE C_ELEMENTVALUE.ACCOUNTTYPE IN (";
    strSql = strSql + ((accounttype==null || accounttype.equals(""))?"":accounttype);
    strSql = strSql + 
      ")" +
      "            AND ACCOUNT_ID = C_ELEMENTVALUE_ID)" +
      "        AND AD_ORG_ID = ?" +
      "        AND C_ACCTSCHEMA_ID = ?" +
      "        AND (FACTACCTTYPE <>'C' or FACT_ACCT_GROUP_ID = ?) " +
      "        GROUP BY ACCOUNT_ID, ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID, M_PRODUCT_ID, A_ASSET_ID," +
      "             C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID,USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID, C_ACCTSCHEMA_ID" +
      "        HAVING SUM(AMTACCTDR)-SUM(AMTACCTCR)<>0" +
      "        order by ACCTVALUE";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);
      if (accounttype != null && !(accounttype.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideUpFactAcctGroupId);

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

  public static int insertSelectOpening(Connection conn, ConnectionProvider connectionProvider, String ad_client_id, String ad_org_id, String ad_user_id, String date, String c_period_id, String c_currency_id, String fact_acct_group_id, String seqno, String factAcctType, String description, String year, String accounttype, String acctSchema, String divideUpFactAcctGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO FACT_ACCT" +
      "        (FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "        ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_ACCTSCHEMA_ID,ACCOUNT_ID, DATETRX, DATEACCT," +
      "        C_PERIOD_ID, AD_TABLE_ID, RECORD_ID," +
      "        POSTINGTYPE,C_CURRENCY_ID,AMTSOURCECR, " +
      "        AMTSOURCEDR, AMTACCTCR, AMTACCTDR," +
      "        FACT_ACCT_GROUP_ID,SEQNO, FACTACCTTYPE," +
      "        ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID," +
      "        M_PRODUCT_ID, A_ASSET_ID, DESCRIPTION," +
      "        C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID," +
      "        USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID)" +
      "        SELECT get_UUID(), ?, ?," +
      "        'Y', now(), ?, now(), ?," +
      "        C_ACCTSCHEMA_ID, ACCOUNT_ID, to_date(?), to_date(?)," +
      "        ?, '145', ?, " +
      "        'A', ?, (CASE SIGN(SUM(AMTACCTCR)-SUM(AMTACCTDR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTCR)-SUM(AMTACCTDR)) END)," +
      "        (CASE SIGN(SUM(AMTACCTDR)-SUM(AMTACCTCR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTDR)-SUM(AMTACCTCR)) END)," +
      "        (CASE SIGN(SUM(AMTACCTCR)-SUM(AMTACCTDR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTCR)-SUM(AMTACCTDR)) END), " +
      "        (CASE SIGN(SUM(AMTACCTDR)-SUM(AMTACCTCR)) WHEN -1 THEN 0 ELSE (SUM(AMTACCTDR)-SUM(AMTACCTCR)) END)," +
      "        ?, to_number(?), ?, " +
      "        ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID, " +
      "        M_PRODUCT_ID, A_ASSET_ID, ?," +
      "        C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID," +
      "        USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID" +
      "        FROM FACT_ACCT" +
      "        WHERE EXISTS (SELECT 1 FROM C_PERIOD P" +
      "                  WHERE P.C_YEAR_ID = ?" +
      "                  AND P.C_PERIOD_ID = FACT_ACCT.C_PERIOD_ID)" +
      "        AND EXISTS (SELECT 1" +
      "            FROM C_ELEMENTVALUE" +
      "            WHERE C_ELEMENTVALUE.ACCOUNTTYPE IN (";
    strSql = strSql + ((accounttype==null || accounttype.equals(""))?"":accounttype);
    strSql = strSql + 
      ")" +
      "            AND ACCOUNT_ID = C_ELEMENTVALUE_ID)" +
      "        AND AD_ORG_ID = ?" +
      "        AND C_ACCTSCHEMA_ID = ?" +
      "        AND (FACTACCTTYPE <>'C' or FACT_ACCT_GROUP_ID = ?) " +
      "        GROUP BY ACCOUNT_ID, ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID, M_PRODUCT_ID, A_ASSET_ID," +
      "             C_TAX_ID,C_PROJECT_ID,C_ACTIVITY_ID,USER1_ID,USER2_ID,C_CAMPAIGN_ID,C_SALESREGION_ID, C_ACCTSCHEMA_ID" +
      "        HAVING SUM(AMTACCTDR)-SUM(AMTACCTCR)<>0" +
      "        order by ACCTVALUE";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);
      if (accounttype != null && !(accounttype.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideUpFactAcctGroupId);

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

  public static String getEndDate(ConnectionProvider connectionProvider, String cPeriodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ENDDATE FROM C_PERIOD WHERE C_PERIOD_ID = ?";

    ResultSet result;
    String dateReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);

      result = st.executeQuery();
      if(result.next()) {
        dateReturn = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
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
    return(dateReturn);
  }

  public static String adTableId(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TABLE_ID FROM AD_TABLE WHERE TABLENAME LIKE 'C_Period'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_table_id");
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

  public static String cCurrencyId(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CURRENCY_ID FROM C_ACCTSCHEMA WHERE C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static EndYearCloseUtilityData[] incomesummary(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    return incomesummary(connectionProvider, cAcctschemaId, 0, 0);
  }

  public static EndYearCloseUtilityData[] incomesummary(ConnectionProvider connectionProvider, String cAcctschemaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_VALIDCOMBINATION.ACCOUNT_ID , C_ELEMENTVALUE.VALUE, C_ELEMENTVALUE.NAME" +
      "      FROM C_ACCTSCHEMA_GL, C_VALIDCOMBINATION, C_ELEMENTVALUE" +
      "      WHERE C_ACCTSCHEMA_GL.INCOMESUMMARY_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID" +
      "      AND C_VALIDCOMBINATION.ACCOUNT_ID = C_ELEMENTVALUE.C_ELEMENTVALUE_ID" +
      "      AND C_ACCTSCHEMA_GL.C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.accountId = UtilSql.getValue(result, "account_id");
        objectEndYearCloseUtilityData.value = UtilSql.getValue(result, "value");
        objectEndYearCloseUtilityData.name = UtilSql.getValue(result, "name");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static EndYearCloseUtilityData[] retainedearning(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    return retainedearning(connectionProvider, cAcctschemaId, 0, 0);
  }

  public static EndYearCloseUtilityData[] retainedearning(ConnectionProvider connectionProvider, String cAcctschemaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_VALIDCOMBINATION.ACCOUNT_ID , C_ELEMENTVALUE.VALUE, C_ELEMENTVALUE.NAME" +
      "      FROM C_ACCTSCHEMA_GL, C_VALIDCOMBINATION, C_ELEMENTVALUE" +
      "      WHERE C_ACCTSCHEMA_GL.RETAINEDEARNING_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID" +
      "      AND C_VALIDCOMBINATION.ACCOUNT_ID = C_ELEMENTVALUE.C_ELEMENTVALUE_ID" +
      "      AND C_ACCTSCHEMA_GL.C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.accountId = UtilSql.getValue(result, "account_id");
        objectEndYearCloseUtilityData.value = UtilSql.getValue(result, "value");
        objectEndYearCloseUtilityData.name = UtilSql.getValue(result, "name");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static String orgAcctschema(ConnectionProvider connectionProvider, String adOrgId, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select ad_org_acctschema_id" +
      "		from ad_org_acctschema" +
      "		where ad_org_id = ?" +
      "		and c_acctschema_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_acctschema_id");
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

  public static int insertOrgClosing(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adUserId, String c_year_id, String adOrgAcctschemaId, String reg_fact_acct_group_id, String close_fact_acct_group_id, String divideup_fact_acct_group_id, String open_fact_acct_group_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		INSERT INTO AD_ORG_CLOSING (AD_ORG_CLOSING_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "					   C_YEAR_ID, AD_ORG_ACCTSCHEMA_ID, REG_FACT_ACCT_GROUP_ID, CLOSE_FACT_ACCT_GROUP_ID," +
      "					   DIVIDEUP_FACT_ACCT_GROUP_ID, OPEN_FACT_ACCT_GROUP_ID)" +
      "		VALUES (GET_UUID(), ?, ?, 'Y', NOW(), ?, NOW(), ?," +
      "		?, ?, ?, ?," +
      "		?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_year_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reg_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, close_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideup_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, open_fact_acct_group_id);

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

  public static String getNextPeriod(ConnectionProvider connectionProvider, String cPeriodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_PERIOD_ID" +
      "        FROM C_PERIOD, C_YEAR Y" +
      "        WHERE C_PERIOD.C_YEAR_ID =  Y.C_YEAR_ID" +
      "        AND STARTDATE = (SELECT P.ENDDATE + 1 " +
      "				FROM C_PERIOD P, C_YEAR" +
      "				WHERE P.C_YEAR_ID =  C_YEAR.C_YEAR_ID" +
      "				AND C_YEAR.C_CALENDAR_ID = Y.C_CALENDAR_ID" +
      "				AND C_PERIOD_ID = ?)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_period_id");
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

  public static String getLastPeriod(ConnectionProvider connectionProvider, String cYearId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_PERIOD_ID FROM C_PERIOD" +
      "        WHERE C_YEAR_ID = ?" +
      "        AND PERIODNO = (SELECT MAX(PERIODNO) FROM C_PERIOD" +
      "                        WHERE C_YEAR_ID = ?)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_period_id");
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

  public static int insertClose(Connection conn, ConnectionProvider connectionProvider, String fact_acct_id, String ad_client_id, String ad_org_id, String ad_user_id, String c_acctschema_id, String account_id, String date, String c_period_id, String ad_table_id, String postingtype, String c_currency_id, String amtsourcedr, String amtsourcecr, String amtacctdr, String amtacctcr, String fact_acct_group_id, String seqno, String factAcctType, String acctdescription, String value, String bpartner, String product, String asset, String description, String cTaxId, String cProjectId, String cActivityId, String User1Id, String User2Id, String CampaignId, String SalesRegionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO FACT_ACCT" +
      "          (FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "           ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           C_ACCTSCHEMA_ID,ACCOUNT_ID, DATETRX, DATEACCT," +
      "           C_PERIOD_ID, AD_TABLE_ID, RECORD_ID," +
      "        POSTINGTYPE,C_CURRENCY_ID, AMTSOURCEDR," +
      "        AMTSOURCECR,AMTACCTDR, AMTACCTCR," +
      "        FACT_ACCT_GROUP_ID,SEQNO, FACTACCTTYPE," +
      "        ACCTDESCRIPTION, ACCTVALUE, C_BPARTNER_ID," +
      "        M_PRODUCT_ID, A_ASSET_ID," +
      "        DESCRIPTION," +
      "        C_TAX_ID, C_PROJECT_ID, C_ACTIVITY_ID," +
      "        USER1_ID, USER2_ID, C_CAMPAIGN_ID," +
      "        C_SALESREGION_ID)" +
      "        VALUES" +
      "          (?,?,?," +
      "           'Y',now(),?,now(),?," +
      "           ?,?,TO_DATE(?),TO_DATE(?)," +
      "           ?,?,?," +
      "           ?,?,TO_NUMBER(?)," +
      "           TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?)," +
      "           ?,TO_NUMBER(?),?," +
      "           ?,?,?," +
      "           ?, ?," +
      "           ?," +
      "           ?,?,?," +
      "           ?, ?, ?," +
      "           ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_acctschema_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, account_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_table_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postingtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcedr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcecr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctType);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, User1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, User2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SalesRegionId);

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

  public static String getStartDate(ConnectionProvider connectionProvider, String cPeriodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT STARTDATE FROM C_PERIOD WHERE C_PERIOD_ID = ?";

    ResultSet result;
    String dateReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);

      result = st.executeQuery();
      if(result.next()) {
        dateReturn = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
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
    return(dateReturn);
  }

  public static int updateClose(Connection conn, ConnectionProvider connectionProvider, String user, String cYearId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PeriodControl" +
      "        SET PeriodStatus = 'P', UPDATED = now(), UPDATEDBY = ?" +
      "        WHERE PeriodStatus <> 'P'" +
      "        AND C_PERIOD_ID IN (SELECT C_PERIOD_ID" +
      "                FROM C_PERIOD" +
      "                WHERE C_YEAR_ID = ?)" +
      "        AND AD_ORG_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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

  public static EndYearCloseUtilityData[] treeOrgAcctSchemas(ConnectionProvider connectionProvider, String clientId, String orgId)    throws ServletException {
    return treeOrgAcctSchemas(connectionProvider, clientId, orgId, 0, 0);
  }

  public static EndYearCloseUtilityData[] treeOrgAcctSchemas(ConnectionProvider connectionProvider, String clientId, String orgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_id as org" +
      "        FROM AD_ORG" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND (AD_ISORGINCLUDED(AD_ORG_ID, ?, AD_CLIENT_ID) <> -1" +
      "          OR AD_ISORGINCLUDED(?, AD_ORG_ID, AD_CLIENT_ID) <> -1)";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.org = UtilSql.getValue(result, "org");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static EndYearCloseUtilityData[] treeOrg(ConnectionProvider connectionProvider, String clientId, String orgId)    throws ServletException {
    return treeOrg(connectionProvider, clientId, orgId, 0, 0);
  }

  public static EndYearCloseUtilityData[] treeOrg(ConnectionProvider connectionProvider, String clientId, String orgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_id as org" +
      "        FROM AD_ORG" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND AD_ISORGINCLUDED(AD_ORG_ID, ?, AD_CLIENT_ID) <> -1";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.org = UtilSql.getValue(result, "org");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static EndYearCloseUtilityData[] treeAcctSchema(ConnectionProvider connectionProvider, String clientId, String organizationId)    throws ServletException {
    return treeAcctSchema(connectionProvider, clientId, organizationId, 0, 0);
  }

  public static EndYearCloseUtilityData[] treeAcctSchema(ConnectionProvider connectionProvider, String clientId, String organizationId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ACCTSCHEMA_ID AS ID" +
      "        FROM C_ACCTSCHEMA" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND EXISTS (SELECT 1 FROM AD_ORG_ACCTSCHEMA" +
      "        WHERE AD_ORG_ACCTSCHEMA.C_ACCTSCHEMA_ID = C_ACCTSCHEMA.C_ACCTSCHEMA_ID" +
      "        AND EXISTS (SELECT 1" +
      "            FROM AD_ORG" +
      "            WHERE AD_CLIENT_ID = ?" +
      "            AND (AD_ISORGINCLUDED(AD_ORG_ID, ?, AD_CLIENT_ID) <> -1 or " +
      "                AD_ISORGINCLUDED(?, AD_ORG_ID, AD_CLIENT_ID) <> -1)" +
      "            AND AD_ORG.AD_ORG_ID = AD_ORG_ACCTSCHEMA.AD_ORG_ID))";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.id = UtilSql.getValue(result, "id");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static String getRegCount(ConnectionProvider connectionProvider, String clientId, String orgId, String c_acctschema_id, String c_period_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS REGCOUNT FROM FACT_ACCT " +
      "        WHERE AD_CLIENT_ID = ? " +
      "        AND AD_ORG_ID = ? " +
      "        AND C_ACCTSCHEMA_ID = ? " +
      "        AND C_PERIOD_ID = ?" +
      "        AND FACTACCTTYPE = 'R'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_acctschema_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "regcount");
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

/**
When balance is balanced this amount should be ZERO
 */
  public static String balanceAmount(ConnectionProvider connectionProvider, String yearId, String acctSchemaId, String organizationList)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select coalesce(sum(amtacctdr)-sum(amtacctcr),0)" +
      "        from fact_acct, c_elementvalue" +
      "        where fact_acct.account_id = c_elementvalue.c_elementvalue_id" +
      "        and dateacct >= (select min(startdate) from c_period where c_year_id = ?)" +
      "        and dateacct <= (select max(enddate) from c_period where c_year_id = ?)" +
      "        and accounttype in ('E','R','A','L','O')" +
      "        and fact_acct.c_acctschema_id = ?" +
      "        and fact_acct.ad_org_id in (";
    strSql = strSql + ((organizationList==null || organizationList.equals(""))?"":organizationList);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchemaId);
      if (organizationList != null && !(organizationList.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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

  public static boolean selectYearNotClosed(ConnectionProvider connectionProvider, String cYearId, String cOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 " +
      "        from c_year y1, c_year y2" +
      "        where y1.c_year_id = ?" +
      "        and y1.c_calendar_id = y2.c_calendar_id" +
      "        and y1.year>y2.year" +
      "        and not exists (select 1 from ad_org_closing where ad_org_closing.c_year_id = y2.c_year_id and ad_org_closing.ad_org_id = ?)";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "?column?").equals("0");
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
    return(boolReturn);
  }

  public static boolean selectUndoAllowed(ConnectionProvider connectionProvider, String cYearId, String cOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select 1 from dual" +
      "    where exists(select 1 " +
      "            from c_year_close_v, c_year" +
      "            where c_year_close_v.c_year_id = c_year.c_year_id" +
      "            and c_year_close_v.c_calendar_id = (select c_calendar_id from c_year where c_year_id = ?)" +
      "            and c_year.year > (select year from c_year where c_year_id = ?)" +
      "            and c_year_close_v.status <> 'O'" +
      "            and c_year_close_v.ad_org_id = ?)";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "?column?").equals("0");
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
    return(boolReturn);
  }

  public static int updatePeriodsOpen(Connection conn, ConnectionProvider connectionProvider, String user, String cYearId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PERIODCONTROL" +
      "        SET PERIODSTATUS = 'C', UPDATED = now(), UPDATEDBY = ?" +
      "        WHERE C_PERIOD_ID IN (SELECT C_PERIOD_ID" +
      "                FROM C_PERIOD" +
      "                WHERE C_YEAR_ID = ?)" +
      "        AND AD_ORG_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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

  public static EndYearCloseUtilityData[] selectFactAcctGroupId(ConnectionProvider connectionProvider, String adOrgId, String cYearId)    throws ServletException {
    return selectFactAcctGroupId(connectionProvider, adOrgId, cYearId, 0, 0);
  }

  public static EndYearCloseUtilityData[] selectFactAcctGroupId(ConnectionProvider connectionProvider, String adOrgId, String cYearId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT REG_FACT_ACCT_GROUP_ID, CLOSE_FACT_ACCT_GROUP_ID, DIVIDEUP_FACT_ACCT_GROUP_ID, OPEN_FACT_ACCT_GROUP_ID, AD_ORG_CLOSING_ID" +
      "        FROM AD_ORG_CLOSING" +
      "        WHERE AD_ORG_ID = ?" +
      "        AND C_YEAR_ID = ?";

    ResultSet result;
    Vector<EndYearCloseUtilityData> vector = new Vector<EndYearCloseUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);

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
        EndYearCloseUtilityData objectEndYearCloseUtilityData = new EndYearCloseUtilityData();
        objectEndYearCloseUtilityData.regFactAcctGroupId = UtilSql.getValue(result, "reg_fact_acct_group_id");
        objectEndYearCloseUtilityData.closeFactAcctGroupId = UtilSql.getValue(result, "close_fact_acct_group_id");
        objectEndYearCloseUtilityData.divideupFactAcctGroupId = UtilSql.getValue(result, "divideup_fact_acct_group_id");
        objectEndYearCloseUtilityData.openFactAcctGroupId = UtilSql.getValue(result, "open_fact_acct_group_id");
        objectEndYearCloseUtilityData.adOrgClosingId = UtilSql.getValue(result, "ad_org_closing_id");
        objectEndYearCloseUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEndYearCloseUtilityData);
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
    EndYearCloseUtilityData objectEndYearCloseUtilityData[] = new EndYearCloseUtilityData[vector.size()];
    vector.copyInto(objectEndYearCloseUtilityData);
    return(objectEndYearCloseUtilityData);
  }

  public static int deleteOrgClosing(Connection conn, ConnectionProvider connectionProvider, String adOrgClosingId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM AD_ORG_CLOSING WHERE AD_ORG_CLOSING_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgClosingId);

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

  public static int deleteFactAcctClose(Connection conn, ConnectionProvider connectionProvider, String fact_acct_group_id, String open_acct_group_id, String divideup_fact_acct_group_id, String reg_fact_acct_group_id, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM FACT_ACCT" +
      "      WHERE FACT_ACCT_GROUP_ID IN (?, ?, ?, ?)" +
      "      AND AD_ISORGINCLUDED(FACT_ACCT.AD_ORG_ID, ?, FACT_ACCT.AD_CLIENT_ID)<>-1";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, open_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divideup_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reg_fact_acct_group_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
