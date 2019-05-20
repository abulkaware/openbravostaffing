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
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class AccountData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String updated;
  public String updatedby;
  public String alias;
  public String combination;
  public String description;
  public String isfullyqualified;
  public String cAcctschemaId;
  public String accountId;
  public String mProductId;
  public String cBpartnerId;
  public String adOrgtrxId;
  public String cLocfromId;
  public String cLoctoId;
  public String cSalesregionId;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String usesuspensebalancing;
  public String suspensebalancingAcct;
  public String usesuspenseerror;
  public String suspenseerrorAcct;
  public String usecurrencybalancing;
  public String currencybalancingAcct;
  public String retainedearningAcct;
  public String incomesummaryAcct;
  public String intercompanyduetoAcct;
  public String intercompanyduefromAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("alias"))
      return alias;
    else if (fieldName.equalsIgnoreCase("combination"))
      return combination;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isfullyqualified"))
      return isfullyqualified;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_locfrom_id") || fieldName.equals("cLocfromId"))
      return cLocfromId;
    else if (fieldName.equalsIgnoreCase("c_locto_id") || fieldName.equals("cLoctoId"))
      return cLoctoId;
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
    else if (fieldName.equalsIgnoreCase("usesuspensebalancing"))
      return usesuspensebalancing;
    else if (fieldName.equalsIgnoreCase("suspensebalancing_acct") || fieldName.equals("suspensebalancingAcct"))
      return suspensebalancingAcct;
    else if (fieldName.equalsIgnoreCase("usesuspenseerror"))
      return usesuspenseerror;
    else if (fieldName.equalsIgnoreCase("suspenseerror_acct") || fieldName.equals("suspenseerrorAcct"))
      return suspenseerrorAcct;
    else if (fieldName.equalsIgnoreCase("usecurrencybalancing"))
      return usecurrencybalancing;
    else if (fieldName.equalsIgnoreCase("currencybalancing_acct") || fieldName.equals("currencybalancingAcct"))
      return currencybalancingAcct;
    else if (fieldName.equalsIgnoreCase("retainedearning_acct") || fieldName.equals("retainedearningAcct"))
      return retainedearningAcct;
    else if (fieldName.equalsIgnoreCase("incomesummary_acct") || fieldName.equals("incomesummaryAcct"))
      return incomesummaryAcct;
    else if (fieldName.equalsIgnoreCase("intercompanydueto_acct") || fieldName.equals("intercompanyduetoAcct"))
      return intercompanyduetoAcct;
    else if (fieldName.equalsIgnoreCase("intercompanyduefrom_acct") || fieldName.equals("intercompanyduefromAcct"))
      return intercompanyduefromAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountData[] select(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return select(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AccountData[] select(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID,AD_ORG_ID, ISACTIVE, UPDATED,UPDATEDBY,ALIAS, COMBINATION, DESCRIPTION, ISFULLYQUALIFIED," +
      "      C_ACCTSCHEMA_ID, ACCOUNT_ID, M_PRODUCT_ID, C_BPARTNER_ID,AD_ORGTRX_ID, C_LOCFROM_ID, C_LOCTO_ID, C_SALESREGION_ID," +
      "      C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID,USER2_ID, '' as UseSuspenseBalancing, '' as SuspenseBalancing_Acct," +
      "      '' as UseSuspenseError, '' as SuspenseError_Acct, '' as UseCurrencyBalancing, '' as CurrencyBalancing_Acct, " +
      "      '' as RetainedEarning_Acct, '' as IncomeSummary_Acct, '' as InterCompanyDueTo_Acct, '' as InterCompanyDueFrom_Acct" +
      "      FROM C_ValidCombination " +
      "      WHERE C_ValidCombination_ID=?";

    ResultSet result;
    Vector<AccountData> vector = new Vector<AccountData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        AccountData objectAccountData = new AccountData();
        objectAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectAccountData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccountData.alias = UtilSql.getValue(result, "alias");
        objectAccountData.combination = UtilSql.getValue(result, "combination");
        objectAccountData.description = UtilSql.getValue(result, "description");
        objectAccountData.isfullyqualified = UtilSql.getValue(result, "isfullyqualified");
        objectAccountData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectAccountData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAccountData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAccountData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectAccountData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectAccountData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectAccountData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectAccountData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAccountData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAccountData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectAccountData.user1Id = UtilSql.getValue(result, "user1_id");
        objectAccountData.user2Id = UtilSql.getValue(result, "user2_id");
        objectAccountData.usesuspensebalancing = UtilSql.getValue(result, "usesuspensebalancing");
        objectAccountData.suspensebalancingAcct = UtilSql.getValue(result, "suspensebalancing_acct");
        objectAccountData.usesuspenseerror = UtilSql.getValue(result, "usesuspenseerror");
        objectAccountData.suspenseerrorAcct = UtilSql.getValue(result, "suspenseerror_acct");
        objectAccountData.usecurrencybalancing = UtilSql.getValue(result, "usecurrencybalancing");
        objectAccountData.currencybalancingAcct = UtilSql.getValue(result, "currencybalancing_acct");
        objectAccountData.retainedearningAcct = UtilSql.getValue(result, "retainedearning_acct");
        objectAccountData.incomesummaryAcct = UtilSql.getValue(result, "incomesummary_acct");
        objectAccountData.intercompanyduetoAcct = UtilSql.getValue(result, "intercompanydueto_acct");
        objectAccountData.intercompanyduefromAcct = UtilSql.getValue(result, "intercompanyduefrom_acct");
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

  public static AccountData[] selectConnection(Connection conn, ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectConnection(conn, connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AccountData[] selectConnection(Connection conn, ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID,AD_ORG_ID, ISACTIVE, UPDATED,UPDATEDBY,ALIAS, COMBINATION, DESCRIPTION, ISFULLYQUALIFIED," +
      "      C_ACCTSCHEMA_ID, ACCOUNT_ID, M_PRODUCT_ID, C_BPARTNER_ID,AD_ORGTRX_ID, C_LOCFROM_ID, C_LOCTO_ID, C_SALESREGION_ID," +
      "      C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID,USER2_ID, '' as UseSuspenseBalancing, '' as SuspenseBalancing_Acct," +
      "      '' as UseSuspenseError, '' as SuspenseError_Acct, '' as UseCurrencyBalancing, '' as CurrencyBalancing_Acct, " +
      "      '' as RetainedEarning_Acct, '' as IncomeSummary_Acct, '' as InterCompanyDueTo_Acct, '' as InterCompanyDueFrom_Acct" +
      "      FROM C_ValidCombination " +
      "      WHERE C_ValidCombination_ID=?";

    ResultSet result;
    Vector<AccountData> vector = new Vector<AccountData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        AccountData objectAccountData = new AccountData();
        objectAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountData.isactive = UtilSql.getValue(result, "isactive");
        objectAccountData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectAccountData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAccountData.alias = UtilSql.getValue(result, "alias");
        objectAccountData.combination = UtilSql.getValue(result, "combination");
        objectAccountData.description = UtilSql.getValue(result, "description");
        objectAccountData.isfullyqualified = UtilSql.getValue(result, "isfullyqualified");
        objectAccountData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectAccountData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAccountData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAccountData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectAccountData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectAccountData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectAccountData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectAccountData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAccountData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAccountData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectAccountData.user1Id = UtilSql.getValue(result, "user1_id");
        objectAccountData.user2Id = UtilSql.getValue(result, "user2_id");
        objectAccountData.usesuspensebalancing = UtilSql.getValue(result, "usesuspensebalancing");
        objectAccountData.suspensebalancingAcct = UtilSql.getValue(result, "suspensebalancing_acct");
        objectAccountData.usesuspenseerror = UtilSql.getValue(result, "usesuspenseerror");
        objectAccountData.suspenseerrorAcct = UtilSql.getValue(result, "suspenseerror_acct");
        objectAccountData.usecurrencybalancing = UtilSql.getValue(result, "usecurrencybalancing");
        objectAccountData.currencybalancingAcct = UtilSql.getValue(result, "currencybalancing_acct");
        objectAccountData.retainedearningAcct = UtilSql.getValue(result, "retainedearning_acct");
        objectAccountData.incomesummaryAcct = UtilSql.getValue(result, "incomesummary_acct");
        objectAccountData.intercompanyduetoAcct = UtilSql.getValue(result, "intercompanydueto_acct");
        objectAccountData.intercompanyduefromAcct = UtilSql.getValue(result, "intercompanyduefrom_acct");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    AccountData objectAccountData[] = new AccountData[vector.size()];
    vector.copyInto(objectAccountData);
    return(objectAccountData);
  }

  public static RespuestaCS GetValidAccountCombination(Connection conn, ConnectionProvider connectionProvider, String AdClientId, String AdOrgId, String CAcctSchemaId, String AccountId, String CInValidCombinationId, String mustBeFullyQualified, String alias, String createdBy, String MProductId, String CBPartnerId, String AdOrgTrxId, String CLocFromId, String CLocToId, String CSalesRegionId, String CProjectId, String CCampaignId, String CActivityId, String user1Id, String user2Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_ValidCombination_Get(?,?,?,?," +
      "                                    ?,?,?,?," +
      "                                    ?,?,?,?,?,?,?, ?,?,?,?,?)";

    RespuestaCS objectRespuestaCS = new RespuestaCS();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      int iParameterCValidCombinationId = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CAcctSchemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CInValidCombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mustBeFullyQualified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CBPartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdOrgTrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CLocFromId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CLocToId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CSalesRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
      objectRespuestaCS.CValidCombinationId= UtilSql.getStringCallableStatement(st, iParameterCValidCombinationId);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement("CValidCombinationId");
      parametersTypes.addElement("out");
      parametersData.addElement(AdClientId);
      parametersTypes.addElement("in");
      parametersData.addElement(AdOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(CAcctSchemaId);
      parametersTypes.addElement("in");
      parametersData.addElement(AccountId);
      parametersTypes.addElement("in");
      parametersData.addElement(CInValidCombinationId);
      parametersTypes.addElement("in");
      parametersData.addElement(mustBeFullyQualified);
      parametersTypes.addElement("in");
      parametersData.addElement(alias);
      parametersTypes.addElement("in");
      parametersData.addElement(createdBy);
      parametersTypes.addElement("in");
      parametersData.addElement(MProductId);
      parametersTypes.addElement("in");
      parametersData.addElement(CBPartnerId);
      parametersTypes.addElement("in");
      parametersData.addElement(AdOrgTrxId);
      parametersTypes.addElement("in");
      parametersData.addElement(CLocFromId);
      parametersTypes.addElement("in");
      parametersData.addElement(CLocToId);
      parametersTypes.addElement("in");
      parametersData.addElement(CSalesRegionId);
      parametersTypes.addElement("in");
      parametersData.addElement(CProjectId);
      parametersTypes.addElement("in");
      parametersData.addElement(CCampaignId);
      parametersTypes.addElement("in");
      parametersData.addElement(CActivityId);
      parametersTypes.addElement("in");
      parametersData.addElement(user1Id);
      parametersTypes.addElement("in");
      parametersData.addElement(user2Id);
      parametersTypes.addElement("in");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectRespuestaCS.CValidCombinationId = vecTotal.elementAt(0);
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
    return(objectRespuestaCS);
  }
}
