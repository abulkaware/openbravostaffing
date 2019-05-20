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

public class AccountingSchemaMiscData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountingSchemaMiscData.class);
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

  public static AccountingSchemaMiscData[] selectC_ACCTSCHEMA_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cAcctschemaId)    throws ServletException {
    return selectC_ACCTSCHEMA_ID(connectionProvider, adOrgClient, adUserClient, cAcctschemaId, 0, 0);
  }

  public static AccountingSchemaMiscData[] selectC_ACCTSCHEMA_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cAcctschemaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_ACCTSCHEMA_ID as id, ((CASE C_ACCTSCHEMA.isActive WHEN 'N' THEN '**' ELSE '' END) || C_ACCTSCHEMA.Name) as name FROM C_ACCTSCHEMA" +
      "      WHERE C_ACCTSCHEMA.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") AND C_ACCTSCHEMA.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")  AND (C_ACCTSCHEMA.isActive = 'Y' OR C_ACCTSCHEMA.C_ACCTSCHEMA_ID = ? )" +
      "      ORDER BY name";

    ResultSet result;
    Vector<AccountingSchemaMiscData> vector = new Vector<AccountingSchemaMiscData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
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
        AccountingSchemaMiscData objectAccountingSchemaMiscData = new AccountingSchemaMiscData();
        objectAccountingSchemaMiscData.id = UtilSql.getValue(result, "id");
        objectAccountingSchemaMiscData.name = UtilSql.getValue(result, "name");
        objectAccountingSchemaMiscData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountingSchemaMiscData);
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
    AccountingSchemaMiscData objectAccountingSchemaMiscData[] = new AccountingSchemaMiscData[vector.size()];
    vector.copyInto(objectAccountingSchemaMiscData);
    return(objectAccountingSchemaMiscData);
  }
}
