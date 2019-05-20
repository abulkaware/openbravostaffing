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

class AcctSchemaData implements FieldProvider {
static Logger log4j = Logger.getLogger(AcctSchemaData.class);
  private String InitRecordNumber="0";
  public String name;
  public String gaap;
  public String isaccrual;
  public String costingmethod;
  public String cCurrencyId;
  public String hasalias;
  public String istradediscountposted;
  public String isdiscountcorrectstax;
  public String adClientId;
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
  public String cAcctschemaId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("gaap"))
      return gaap;
    else if (fieldName.equalsIgnoreCase("isaccrual"))
      return isaccrual;
    else if (fieldName.equalsIgnoreCase("costingmethod"))
      return costingmethod;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("hasalias"))
      return hasalias;
    else if (fieldName.equalsIgnoreCase("istradediscountposted"))
      return istradediscountposted;
    else if (fieldName.equalsIgnoreCase("isdiscountcorrectstax"))
      return isdiscountcorrectstax;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AcctSchemaData[] select(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return select(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctSchemaData[] select(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT Name,GAAP,IsAccrual,CostingMethod,C_Currency_ID,HasAlias, IsTradeDiscountPosted," +
      "      IsDiscountCorrectsTax, AD_Client_ID, '' as UseSuspenseBalancing, '' as SuspenseBalancing_Acct," +
      "      '' as UseSuspenseError, '' as SuspenseError_Acct, '' as UseCurrencyBalancing, '' as CurrencyBalancing_Acct," +
      "      '' as RetainedEarning_Acct, '' as IncomeSummary_Acct, '' as InterCompanyDueTo_Acct, '' as InterCompanyDueFrom_Acct," +
      "      '' as C_AcctSchema_ID" +
      "      FROM C_AcctSchema" +
      "      WHERE C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctSchemaData> vector = new Vector<AcctSchemaData>(0);
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
        AcctSchemaData objectAcctSchemaData = new AcctSchemaData();
        objectAcctSchemaData.name = UtilSql.getValue(result, "name");
        objectAcctSchemaData.gaap = UtilSql.getValue(result, "gaap");
        objectAcctSchemaData.isaccrual = UtilSql.getValue(result, "isaccrual");
        objectAcctSchemaData.costingmethod = UtilSql.getValue(result, "costingmethod");
        objectAcctSchemaData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAcctSchemaData.hasalias = UtilSql.getValue(result, "hasalias");
        objectAcctSchemaData.istradediscountposted = UtilSql.getValue(result, "istradediscountposted");
        objectAcctSchemaData.isdiscountcorrectstax = UtilSql.getValue(result, "isdiscountcorrectstax");
        objectAcctSchemaData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAcctSchemaData.usesuspensebalancing = UtilSql.getValue(result, "usesuspensebalancing");
        objectAcctSchemaData.suspensebalancingAcct = UtilSql.getValue(result, "suspensebalancing_acct");
        objectAcctSchemaData.usesuspenseerror = UtilSql.getValue(result, "usesuspenseerror");
        objectAcctSchemaData.suspenseerrorAcct = UtilSql.getValue(result, "suspenseerror_acct");
        objectAcctSchemaData.usecurrencybalancing = UtilSql.getValue(result, "usecurrencybalancing");
        objectAcctSchemaData.currencybalancingAcct = UtilSql.getValue(result, "currencybalancing_acct");
        objectAcctSchemaData.retainedearningAcct = UtilSql.getValue(result, "retainedearning_acct");
        objectAcctSchemaData.incomesummaryAcct = UtilSql.getValue(result, "incomesummary_acct");
        objectAcctSchemaData.intercompanyduetoAcct = UtilSql.getValue(result, "intercompanydueto_acct");
        objectAcctSchemaData.intercompanyduefromAcct = UtilSql.getValue(result, "intercompanyduefrom_acct");
        objectAcctSchemaData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAcctSchemaData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctSchemaData);
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
    AcctSchemaData objectAcctSchemaData[] = new AcctSchemaData[vector.size()];
    vector.copyInto(objectAcctSchemaData);
    return(objectAcctSchemaData);
  }

  public static AcctSchemaData[] selectAcctSchemaGL(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return selectAcctSchemaGL(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctSchemaData[] selectAcctSchemaGL(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT UseSuspenseBalancing,SuspenseBalancing_Acct, UseSuspenseError,SuspenseError_Acct, UseCurrencyBalancing," +
      "      CurrencyBalancing_Acct, RetainedEarning_Acct,IncomeSummary_Acct, InterCompanyDueTo_Acct,InterCompanyDueFrom_Acct" +
      "      FROM C_AcctSchema_GL" +
      "      WHERE C_AcctSchema_ID=?";

    ResultSet result;
    Vector<AcctSchemaData> vector = new Vector<AcctSchemaData>(0);
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
        AcctSchemaData objectAcctSchemaData = new AcctSchemaData();
        objectAcctSchemaData.usesuspensebalancing = UtilSql.getValue(result, "usesuspensebalancing");
        objectAcctSchemaData.suspensebalancingAcct = UtilSql.getValue(result, "suspensebalancing_acct");
        objectAcctSchemaData.usesuspenseerror = UtilSql.getValue(result, "usesuspenseerror");
        objectAcctSchemaData.suspenseerrorAcct = UtilSql.getValue(result, "suspenseerror_acct");
        objectAcctSchemaData.usecurrencybalancing = UtilSql.getValue(result, "usecurrencybalancing");
        objectAcctSchemaData.currencybalancingAcct = UtilSql.getValue(result, "currencybalancing_acct");
        objectAcctSchemaData.retainedearningAcct = UtilSql.getValue(result, "retainedearning_acct");
        objectAcctSchemaData.incomesummaryAcct = UtilSql.getValue(result, "incomesummary_acct");
        objectAcctSchemaData.intercompanyduetoAcct = UtilSql.getValue(result, "intercompanydueto_acct");
        objectAcctSchemaData.intercompanyduefromAcct = UtilSql.getValue(result, "intercompanyduefrom_acct");
        objectAcctSchemaData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctSchemaData);
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
    AcctSchemaData objectAcctSchemaData[] = new AcctSchemaData[vector.size()];
    vector.copyInto(objectAcctSchemaData);
    return(objectAcctSchemaData);
  }

  public static AcctSchemaData[] selectAcctSchemas(ConnectionProvider connectionProvider, String AD_Client_ID, String AD_Org_ID)    throws ServletException {
    return selectAcctSchemas(connectionProvider, AD_Client_ID, AD_Org_ID, 0, 0);
  }

  public static AcctSchemaData[] selectAcctSchemas(ConnectionProvider connectionProvider, String AD_Client_ID, String AD_Org_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT distinct ad_org_acctschema.C_AcctSchema_ID" +
      "		FROM ad_org_acctschema, c_acctschema" +
      "		WHERE ad_org_acctschema.c_acctschema_id = c_acctschema.c_acctschema_id" +
      "		 and ad_org_acctschema.AD_Client_ID=?" +
      "		 and (ad_isorgincluded(?, ad_org_acctschema.AD_org_ID, ad_org_acctschema.AD_Client_ID) <> -1 OR ? = '0')" +
      "		 and c_acctschema.isactive = 'Y'" +
      "		 and ad_org_acctschema.isactive = 'Y'";

    ResultSet result;
    Vector<AcctSchemaData> vector = new Vector<AcctSchemaData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);

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
        AcctSchemaData objectAcctSchemaData = new AcctSchemaData();
        objectAcctSchemaData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectAcctSchemaData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctSchemaData);
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
    AcctSchemaData objectAcctSchemaData[] = new AcctSchemaData[vector.size()];
    vector.copyInto(objectAcctSchemaData);
    return(objectAcctSchemaData);
  }

  public static boolean selectAcctSchemaTable(ConnectionProvider connectionProvider, String c_acctschema_id, String ad_table_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(C_ACCTSCHEMA_TABLE_ID) AS TOTAL FROM C_ACCTSCHEMA_TABLE" +
      "        WHERE C_ACCTSCHEMA_ID = ?" +
      "        AND AD_TABLE_ID = ?" +
      "        AND ISACTIVE = 'Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_acctschema_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_table_id);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
}
