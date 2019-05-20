//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.poc;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PocConfigurationData implements FieldProvider {
static Logger log4j = Logger.getLogger(PocConfigurationData.class);
  private String InitRecordNumber="0";
  public String smtpserver;
  public String smtpserveraccount;
  public String smtpserverpassword;
  public String issmtpauthorization;
  public String smtpserversenderaddress;
  public String smtpconnectionsecurity;
  public String smtpport;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("smtpserver"))
      return smtpserver;
    else if (fieldName.equalsIgnoreCase("smtpserveraccount"))
      return smtpserveraccount;
    else if (fieldName.equalsIgnoreCase("smtpserverpassword"))
      return smtpserverpassword;
    else if (fieldName.equalsIgnoreCase("issmtpauthorization"))
      return issmtpauthorization;
    else if (fieldName.equalsIgnoreCase("smtpserversenderaddress"))
      return smtpserversenderaddress;
    else if (fieldName.equalsIgnoreCase("smtpconnectionsecurity"))
      return smtpconnectionsecurity;
    else if (fieldName.equalsIgnoreCase("smtpport"))
      return smtpport;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PocConfigurationData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static PocConfigurationData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			'' as smtpServer," +
      "			'' as smtpServerAccount," +
      "			'' as smtpServerPassword," +
      "			'' as isSmtpAuthorization," +
      "			'' as smtpServerSenderAddress," +
      "			'' as smtpConnectionSecurity," +
      "			'' as smtpPort" +
      "		from" +
      "			dual";

    ResultSet result;
    Vector<PocConfigurationData> vector = new Vector<PocConfigurationData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        PocConfigurationData objectPocConfigurationData = new PocConfigurationData();
        objectPocConfigurationData.smtpserver = UtilSql.getValue(result, "smtpserver");
        objectPocConfigurationData.smtpserveraccount = UtilSql.getValue(result, "smtpserveraccount");
        objectPocConfigurationData.smtpserverpassword = UtilSql.getValue(result, "smtpserverpassword");
        objectPocConfigurationData.issmtpauthorization = UtilSql.getValue(result, "issmtpauthorization");
        objectPocConfigurationData.smtpserversenderaddress = UtilSql.getValue(result, "smtpserversenderaddress");
        objectPocConfigurationData.smtpconnectionsecurity = UtilSql.getValue(result, "smtpconnectionsecurity");
        objectPocConfigurationData.smtpport = UtilSql.getValue(result, "smtpport");
        objectPocConfigurationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocConfigurationData);
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
    PocConfigurationData objectPocConfigurationData[] = new PocConfigurationData[vector.size()];
    vector.copyInto(objectPocConfigurationData);
    return(objectPocConfigurationData);
  }

  public static PocConfigurationData[] getSmtpDetails(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    return getSmtpDetails(connectionProvider, adClientId, adOrgId, 0, 0);
  }

  public static PocConfigurationData[] getSmtpDetails(ConnectionProvider connectionProvider, String adClientId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			C_poc_configuration.smtpServer," +
      "			C_poc_configuration.smtpServerAccount," +
      "			C_poc_configuration.smtpServerPassword," +
      "            C_poc_configuration.isSmtpAuthorization," +
      "            C_poc_configuration.smtpServerSenderAddress," +
      "            C_poc_configuration.smtpConnectionSecurity," +
      "            C_poc_configuration.smtpPort" +
      "		from" +
      "			C_poc_configuration" +
      "		where" +
      "			C_poc_configuration.ad_client_id = ? AND " +
      "			(C_poc_configuration.ad_org_id = ? OR C_poc_configuration.ad_org_id = '0') AND" +
      "			C_poc_configuration.isActive = 'Y'";

    ResultSet result;
    Vector<PocConfigurationData> vector = new Vector<PocConfigurationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        PocConfigurationData objectPocConfigurationData = new PocConfigurationData();
        objectPocConfigurationData.smtpserver = UtilSql.getValue(result, "smtpserver");
        objectPocConfigurationData.smtpserveraccount = UtilSql.getValue(result, "smtpserveraccount");
        objectPocConfigurationData.smtpserverpassword = UtilSql.getValue(result, "smtpserverpassword");
        objectPocConfigurationData.issmtpauthorization = UtilSql.getValue(result, "issmtpauthorization");
        objectPocConfigurationData.smtpserversenderaddress = UtilSql.getValue(result, "smtpserversenderaddress");
        objectPocConfigurationData.smtpconnectionsecurity = UtilSql.getValue(result, "smtpconnectionsecurity");
        objectPocConfigurationData.smtpport = UtilSql.getValue(result, "smtpport");
        objectPocConfigurationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocConfigurationData);
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
    PocConfigurationData objectPocConfigurationData[] = new PocConfigurationData[vector.size()];
    vector.copyInto(objectPocConfigurationData);
    return(objectPocConfigurationData);
  }
}
