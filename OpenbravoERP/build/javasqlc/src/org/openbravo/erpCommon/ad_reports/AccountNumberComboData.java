//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class AccountNumberComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountNumberComboData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountNumberComboData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adUserOrg, 0, 0);
  }

  public static AccountNumberComboData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_BANKACCOUNT_ID AS ID, AD_COLUMN_IDENTIFIER(TO_CHAR('C_BankAccount'), TO_CHAR(C_BANKACCOUNT.C_BANKACCOUNT_ID), TO_CHAR(?)) AS name" +
      "      FROM C_BANK, C_BANKACCOUNT" +
      "      WHERE C_BANK.C_BANK_ID = C_BANKACCOUNT.C_BANK_ID " +
      "      AND C_BANK.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_BANK.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<AccountNumberComboData> vector = new Vector<AccountNumberComboData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
        AccountNumberComboData objectAccountNumberComboData = new AccountNumberComboData();
        objectAccountNumberComboData.id = UtilSql.getValue(result, "id");
        objectAccountNumberComboData.name = UtilSql.getValue(result, "name");
        objectAccountNumberComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountNumberComboData);
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
    AccountNumberComboData objectAccountNumberComboData[] = new AccountNumberComboData[vector.size()];
    vector.copyInto(objectAccountNumberComboData);
    return(objectAccountNumberComboData);
  }
}
