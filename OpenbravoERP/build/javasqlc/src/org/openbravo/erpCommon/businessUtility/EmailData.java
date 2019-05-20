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

public class EmailData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmailData.class);
  private String InitRecordNumber="0";
  public String email;
  public String emailuser;
  public String emailuserpw;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("emailuser"))
      return emailuser;
    else if (fieldName.equalsIgnoreCase("emailuserpw"))
      return emailuserpw;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EmailData[] selectEmail(Connection conn, ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    return selectEmail(conn, connectionProvider, adUserId, 0, 0);
  }

  public static EmailData[] selectEmail(Connection conn, ConnectionProvider connectionProvider, String adUserId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT EMail, EMailUser, EMailUserPw, Name FROM AD_User WHERE AD_User_ID=?";

    ResultSet result;
    Vector<EmailData> vector = new Vector<EmailData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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
        EmailData objectEmailData = new EmailData();
        objectEmailData.email = UtilSql.getValue(result, "email");
        objectEmailData.emailuser = UtilSql.getValue(result, "emailuser");
        objectEmailData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectEmailData.name = UtilSql.getValue(result, "name");
        objectEmailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailData);
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
    EmailData objectEmailData[] = new EmailData[vector.size()];
    vector.copyInto(objectEmailData);
    return(objectEmailData);
  }

  public static EmailData[] selectEmailRequest(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return selectEmailRequest(conn, connectionProvider, adClientId, 0, 0);
  }

  public static EmailData[] selectEmailRequest(Connection conn, ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT RequestEMail AS EMail, RequestUser AS EMailUser, RequestUserPw AS EMailUserPw FROM AD_Client WHERE AD_Client_ID=?";

    ResultSet result;
    Vector<EmailData> vector = new Vector<EmailData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        EmailData objectEmailData = new EmailData();
        objectEmailData.email = UtilSql.getValue(result, "email");
        objectEmailData.emailuser = UtilSql.getValue(result, "emailuser");
        objectEmailData.emailuserpw = UtilSql.getValue(result, "emailuserpw");
        objectEmailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailData);
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
    EmailData objectEmailData[] = new EmailData[vector.size()];
    vector.copyInto(objectEmailData);
    return(objectEmailData);
  }

  public static String selectSMTPHost(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SMTPHost AS NAME FROM AD_Client WHERE AD_Client_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
    return(strReturn);
  }
}
