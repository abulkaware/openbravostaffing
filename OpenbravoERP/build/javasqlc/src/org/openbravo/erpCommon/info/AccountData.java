//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class AccountData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String id;
  public String name;
  public String cValidcombinationId;
  public String alias;
  public String combination;
  public String description;
  public String adOrgId;
  public String adOrgIdD;
  public String accountId;
  public String accountIdD;
  public String mProductId;
  public String mProductIdD;
  public String cBpartnerId;
  public String cBpartnerIdD;
  public String cProjectId;
  public String cProjectIdD;
  public String cCampaignId;
  public String cCampaignIdD;
  public String rowkey;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_validcombination_id") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("alias"))
      return alias;
    else if (fieldName.equalsIgnoreCase("combination"))
      return combination;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_id_d") || fieldName.equals("adOrgIdD"))
      return adOrgIdD;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("account_id_d") || fieldName.equals("accountIdD"))
      return accountIdD;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_id_d") || fieldName.equals("mProductIdD"))
      return mProductIdD;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id_d") || fieldName.equals("cBpartnerIdD"))
      return cBpartnerIdD;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_id_d") || fieldName.equals("cProjectIdD"))
      return cProjectIdD;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id_d") || fieldName.equals("cCampaignIdD"))
      return cCampaignIdD;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountData[] select(ConnectionProvider connectionProvider, String rownum, String acctschema, String alias, String combination, String organization, String account, String product, String bpartner, String project, String campaign, String validcombination, String adUserClient, String adUserOrg, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, acctschema, alias, combination, organization, account, product, bpartner, project, campaign, validcombination, adUserClient, adUserOrg, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static AccountData[] select(ConnectionProvider connectionProvider, String rownum, String acctschema, String alias, String combination, String organization, String account, String product, String bpartner, String project, String campaign, String validcombination, String adUserClient, String adUserOrg, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      		SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, '' AS ID, '' AS NAME, A.* FROM (" +
      "	            SELECT C.C_VALIDCOMBINATION_ID, C.ALIAS, C.COMBINATION, C.DESCRIPTION, " +
      "	            C.AD_ORG_ID, (O.VALUE || ' - ' || O.NAME) AS AD_ORG_ID_D, " +
      "	            C.ACCOUNT_ID, (E.VALUE || ' - ' || E.NAME) AS ACCOUNT_ID_D, " +
      "	            C.M_PRODUCT_ID, (P.NAME) AS M_PRODUCT_ID_D, " +
      "	            C.C_BPARTNER_ID, (B.NAME) AS C_BPARTNER_ID_D, " +
      "	            C.C_PROJECT_ID, (J.NAME || ' - ' || J.VALUE) AS C_PROJECT_ID_D, " +
      "	            C.C_CAMPAIGN_ID, (M.NAME) AS C_CAMPAIGN_ID_D, C.C_VALIDCOMBINATION_ID || '@_##_@' || C.COMBINATION AS ROWKEY" +
      "	            FROM C_VALIDCOMBINATION C left join M_PRODUCT P on C.M_PRODUCT_ID = P.M_PRODUCT_ID " +
      "	                                      left join C_BPARTNER B on C.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "	                                      left join C_PROJECT J on C.C_PROJECT_ID = J.C_PROJECT_ID" +
      "	                                      left join C_CAMPAIGN M on C.C_CAMPAIGN_ID = M.C_CAMPAIGN_ID," +
      "	            AD_ORG O, C_ELEMENTVALUE E" +
      "	            WHERE ";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  C.C_ACCTSCHEMA_ID = ? AND  ");
    strSql = strSql + ((alias==null || alias.equals(""))?"":"  (C.ALIAS IS NULL  OR UPPER(C.ALIAS) LIKE UPPER(?)) AND  ");
    strSql = strSql + ((combination==null || combination.equals("") || combination.equals("%") )?"":"  UPPER(C.COMBINATION) LIKE UPPER(?) AND  ");
    strSql = strSql + ((organization==null || organization.equals(""))?"":"  C.AD_ORG_ID = ? AND  ");
    strSql = strSql + ((account==null || account.equals(""))?"":"  C.ACCOUNT_ID = ? AND  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  C.M_PRODUCT_ID = ? AND  ");
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  C.C_BPARTNER_ID = ? AND  ");
    strSql = strSql + ((project==null || project.equals(""))?"":"  C.C_PROJECT_ID = ? AND  ");
    strSql = strSql + ((campaign==null || campaign.equals(""))?"":"  C.C_CAMPAIGN_ID = ? AND  ");
    strSql = strSql + ((validcombination==null || validcombination.equals(""))?"":"  C.C_VALIDCOMBINATION_ID = ? AND  ");
    strSql = strSql + 
      "C.AD_ORG_ID = O.AD_ORG_ID " +
      "	            AND C.ACCOUNT_ID = E.C_ELEMENTVALUE_ID " +
      "	            AND C.ISACTIVE = 'Y' " +
      "	            AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	            AND C.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "	            ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "	        	) A ) B" +
      "			WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<AccountData> vector = new Vector<AccountData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (alias != null && !(alias.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      }
      if (combination != null && !(combination.equals("")) && !(combination.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, combination);
      }
      if (organization != null && !(organization.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);
      }
      if (account != null && !(account.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, account);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (project != null && !(project.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, project);
      }
      if (campaign != null && !(campaign.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, campaign);
      }
      if (validcombination != null && !(validcombination.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, validcombination);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        AccountData objectAccountData = new AccountData();
        objectAccountData.rn1 = UtilSql.getValue(result, "rn1");
        objectAccountData.id = UtilSql.getValue(result, "id");
        objectAccountData.name = UtilSql.getValue(result, "name");
        objectAccountData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectAccountData.alias = UtilSql.getValue(result, "alias");
        objectAccountData.combination = UtilSql.getValue(result, "combination");
        objectAccountData.description = UtilSql.getValue(result, "description");
        objectAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountData.adOrgIdD = UtilSql.getValue(result, "ad_org_id_d");
        objectAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectAccountData.accountIdD = UtilSql.getValue(result, "account_id_d");
        objectAccountData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAccountData.mProductIdD = UtilSql.getValue(result, "m_product_id_d");
        objectAccountData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAccountData.cBpartnerIdD = UtilSql.getValue(result, "c_bpartner_id_d");
        objectAccountData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAccountData.cProjectIdD = UtilSql.getValue(result, "c_project_id_d");
        objectAccountData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAccountData.cCampaignIdD = UtilSql.getValue(result, "c_campaign_id_d");
        objectAccountData.rowkey = UtilSql.getValue(result, "rowkey");
        objectAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountData);
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
    AccountData objectAccountData[] = new AccountData[vector.size()];
    vector.copyInto(objectAccountData);
    return(objectAccountData);
  }

  public static AccountData[] set(String alias, String combination)    throws ServletException {
    AccountData objectAccountData[] = new AccountData[1];
    objectAccountData[0] = new AccountData();
    objectAccountData[0].rn1 = "";
    objectAccountData[0].id = "";
    objectAccountData[0].name = "";
    objectAccountData[0].cValidcombinationId = "";
    objectAccountData[0].alias = alias;
    objectAccountData[0].combination = combination;
    objectAccountData[0].description = "";
    objectAccountData[0].adOrgId = "";
    objectAccountData[0].adOrgIdD = "";
    objectAccountData[0].accountId = "";
    objectAccountData[0].accountIdD = "";
    objectAccountData[0].mProductId = "";
    objectAccountData[0].mProductIdD = "";
    objectAccountData[0].cBpartnerId = "";
    objectAccountData[0].cBpartnerIdD = "";
    objectAccountData[0].cProjectId = "";
    objectAccountData[0].cProjectIdD = "";
    objectAccountData[0].cCampaignId = "";
    objectAccountData[0].cCampaignIdD = "";
    objectAccountData[0].rowkey = "";
    return objectAccountData;
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String acctschema, String alias, String combination, String organization, String account, String product, String bpartner, String project, String campaign, String validcombination, String adUserClient, String adUserOrg, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      		SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.* FROM " +
      "                ( SELECT 1 FROM C_VALIDCOMBINATION C left join M_PRODUCT P on C.M_PRODUCT_ID = P.M_PRODUCT_ID " +
      "	                                      left join C_BPARTNER B on C.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "	                                      left join C_PROJECT J on C.C_PROJECT_ID = J.C_PROJECT_ID" +
      "	                                      left join C_CAMPAIGN M on C.C_CAMPAIGN_ID = M.C_CAMPAIGN_ID," +
      "                     AD_ORG O, C_ELEMENTVALUE E" +
      "	            WHERE ";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  C.C_ACCTSCHEMA_ID = ? AND  ");
    strSql = strSql + ((alias==null || alias.equals(""))?"":"  (C.ALIAS IS NULL  OR UPPER(C.ALIAS) LIKE UPPER(?)) AND  ");
    strSql = strSql + ((combination==null || combination.equals("") || combination.equals("%") )?"":"  UPPER(C.COMBINATION) LIKE UPPER(?) AND  ");
    strSql = strSql + ((organization==null || organization.equals(""))?"":"  C.AD_ORG_ID = ? AND  ");
    strSql = strSql + ((account==null || account.equals(""))?"":"  C.ACCOUNT_ID = ? AND  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  C.M_PRODUCT_ID = ? AND  ");
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  C.C_BPARTNER_ID = ? AND  ");
    strSql = strSql + ((project==null || project.equals(""))?"":"  C.C_PROJECT_ID = ? AND  ");
    strSql = strSql + ((campaign==null || campaign.equals(""))?"":"  C.C_CAMPAIGN_ID = ? AND  ");
    strSql = strSql + ((validcombination==null || validcombination.equals(""))?"":"  C.C_VALIDCOMBINATION_ID = ? AND  ");
    strSql = strSql + 
      "C.AD_ORG_ID = O.AD_ORG_ID " +
      "	            AND C.ACCOUNT_ID = E.C_ELEMENTVALUE_ID " +
      "	            AND C.ISACTIVE = 'Y' " +
      "	            AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	            AND C.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "	            AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "	        ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "	        ) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (alias != null && !(alias.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      }
      if (combination != null && !(combination.equals("")) && !(combination.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, combination);
      }
      if (organization != null && !(organization.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);
      }
      if (account != null && !(account.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, account);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (project != null && !(project.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, project);
      }
      if (campaign != null && !(campaign.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, campaign);
      }
      if (validcombination != null && !(validcombination.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, validcombination);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static AccountData[] selectKey(ConnectionProvider connectionProvider, String acctschema, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKey(connectionProvider, acctschema, adUserClient, adUserOrg, key, 0, 0);
  }

  public static AccountData[] selectKey(ConnectionProvider connectionProvider, String acctschema, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C.C_VALIDCOMBINATION_ID, C.ALIAS, C.COMBINATION, C.DESCRIPTION, " +
      "            C.AD_ORG_ID, (O.VALUE || ' - ' || O.NAME) AS AD_ORG_ID_D, " +
      "            C.ACCOUNT_ID, (E.VALUE || ' - ' || E.NAME) AS ACCOUNT_ID_D, " +
      "            C.M_PRODUCT_ID, (P.NAME) AS M_PRODUCT_ID_D, " +
      "            C.C_BPARTNER_ID, (B.NAME) AS C_BPARTNER_ID_D, " +
      "            C.C_PROJECT_ID, (J.NAME || ' - ' || J.VALUE) AS C_PROJECT_ID_D, " +
      "            C.C_CAMPAIGN_ID, (M.NAME) AS C_CAMPAIGN_ID_D " +
      "            FROM C_VALIDCOMBINATION C left join M_PRODUCT P on C.M_PRODUCT_ID = P.M_PRODUCT_ID" +
      "                                      left join C_BPARTNER B on C.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "                                      left join C_PROJECT J on C.C_PROJECT_ID = J.C_PROJECT_ID " +
      "                                      left join C_CAMPAIGN M on C.C_CAMPAIGN_ID = M.C_CAMPAIGN_ID," +
      "            AD_ORG O, C_ELEMENTVALUE E" +
      "            WHERE ";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  C.C_ACCTSCHEMA_ID = ? AND  ");
    strSql = strSql + 
      "C.AD_ORG_ID = O.AD_ORG_ID " +
      "            AND C.ACCOUNT_ID = E.C_ELEMENTVALUE_ID " +
      "            AND C.ISACTIVE = 'Y' " +
      "            AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "            AND C.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "            AND (C.ALIAS IS NULL " +
      "            OR UPPER(C.ALIAS) LIKE UPPER(?)) ";

    ResultSet result;
    Vector<AccountData> vector = new Vector<AccountData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
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
        AccountData objectAccountData = new AccountData();
        objectAccountData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectAccountData.alias = UtilSql.getValue(result, "alias");
        objectAccountData.combination = UtilSql.getValue(result, "combination");
        objectAccountData.description = UtilSql.getValue(result, "description");
        objectAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountData.adOrgIdD = UtilSql.getValue(result, "ad_org_id_d");
        objectAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectAccountData.accountIdD = UtilSql.getValue(result, "account_id_d");
        objectAccountData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAccountData.mProductIdD = UtilSql.getValue(result, "m_product_id_d");
        objectAccountData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAccountData.cBpartnerIdD = UtilSql.getValue(result, "c_bpartner_id_d");
        objectAccountData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAccountData.cProjectIdD = UtilSql.getValue(result, "c_project_id_d");
        objectAccountData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAccountData.cCampaignIdD = UtilSql.getValue(result, "c_campaign_id_d");
        objectAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountData);
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
    AccountData objectAccountData[] = new AccountData[vector.size()];
    vector.copyInto(objectAccountData);
    return(objectAccountData);
  }

  public static String combination(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COMBINATION FROM C_VALIDCOMBINATION WHERE C_VALIDCOMBINATION_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "combination");
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

  public static AccountData insert(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cAcctschemaId, String accountId, String cInValidcombinationId, String alias, String createdby, String mProductId, String cBpartnerId, String cProjectId, String cCampaignId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_ValidCombination_Insert(?, ?, ?, ?, ?, ?, NULL, ?, ?, ?, ?, NULL, NULL, NULL, NULL, ?, ?, NULL, NULL, NULL)";

    AccountData objectAccountData = new AccountData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      int iParametercValidcombinationId = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
      objectAccountData.cValidcombinationId= UtilSql.getStringCallableStatement(st, iParametercValidcombinationId);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement("cValidcombinationId");
      parametersTypes.addElement("out");
      parametersData.addElement(adClientId);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(cAcctschemaId);
      parametersTypes.addElement("in");
      parametersData.addElement(accountId);
      parametersTypes.addElement("in");
      parametersData.addElement(cInValidcombinationId);
      parametersTypes.addElement("in");
      parametersData.addElement(alias);
      parametersTypes.addElement("in");
      parametersData.addElement(createdby);
      parametersTypes.addElement("in");
      parametersData.addElement(mProductId);
      parametersTypes.addElement("in");
      parametersData.addElement(cBpartnerId);
      parametersTypes.addElement("in");
      parametersData.addElement(cProjectId);
      parametersTypes.addElement("in");
      parametersData.addElement(cCampaignId);
      parametersTypes.addElement("in");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectAccountData.cValidcombinationId = vecTotal.elementAt(0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectAccountData);
  }

  public static AccountData[] selectElementValues(ConnectionProvider connectionProvider, String ADLenguage, String acctschema, String adUserClient, String adUserOrg)    throws ServletException {
    return selectElementValues(connectionProvider, ADLenguage, acctschema, adUserClient, adUserOrg, 0, 0);
  }

  public static AccountData[] selectElementValues(ConnectionProvider connectionProvider, String ADLenguage, String acctschema, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT EV.C_ElementValue_ID AS ID, (EV.VALUE || ' - ' || (CASE WHEN td_trl1.Name IS NULL THEN TO_CHAR(EV.Name) ELSE TO_CHAR(td_trl1.Name) END)) AS NAME, '' AS DESCRIPTION" +
      "    FROM C_ELEMENTVALUE EV" +
      "      LEFT JOIN C_ElementValue_Trl td_trl1 on EV.C_ElementValue_ID = td_trl1.C_ElementValue_ID AND td_trl1.AD_Language = ?," +
      "      C_ELEMENT E, C_ACCTSCHEMA S, C_ACCTSCHEMA_ELEMENT SE" +
      "    WHERE ";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  S.C_ACCTSCHEMA_ID = ? AND  ");
    strSql = strSql + 
      "EV.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND EV.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND EV.IsSummary='N'" +
      "      AND EV.ISACTIVE = 'Y'" +
      "      AND SE.C_ACCTSCHEMA_ID = S.C_ACCTSCHEMA_ID" +
      "      AND SE.C_ELEMENT_ID = E.C_ELEMENT_ID" +
      "      AND SE.ELEMENTTYPE = 'AC'" +
      "      AND EV.C_ELEMENT_ID = E.C_ELEMENT_ID" +
      "    ORDER BY EV.Value";

    ResultSet result;
    Vector<AccountData> vector = new Vector<AccountData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ADLenguage);
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        AccountData objectAccountData = new AccountData();
        objectAccountData.id = UtilSql.getValue(result, "id");
        objectAccountData.name = UtilSql.getValue(result, "name");
        objectAccountData.description = UtilSql.getValue(result, "description");
        objectAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountData);
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
    AccountData objectAccountData[] = new AccountData[vector.size()];
    vector.copyInto(objectAccountData);
    return(objectAccountData);
  }
}
