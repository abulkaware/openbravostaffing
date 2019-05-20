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

class ReportTrialBalanceDetailData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportTrialBalanceDetailData.class);
  private String InitRecordNumber="0";
  public String year;
  public String periodname;
  public String amtacctdr;
  public String amtacctcr;
  public String accountname;
  public String accountcode;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("year"))
      return year;
    else if (fieldName.equalsIgnoreCase("periodname"))
      return periodname;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("accountname"))
      return accountname;
    else if (fieldName.equalsIgnoreCase("accountcode"))
      return accountcode;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportTrialBalanceDetailData[] select(ConnectionProvider connectionProvider, String accountName, String accountCode, String selectedOrg, String orgFamily, String adUserClient, String adUserOrg, String accountSet, String parDateFrom, String parDateTo, String acctSchema, String cBpartnerId, String mProductId, String cProjectId)    throws ServletException {
    return select(connectionProvider, accountName, accountCode, selectedOrg, orgFamily, adUserClient, adUserOrg, accountSet, parDateFrom, parDateTo, acctSchema, cBpartnerId, mProductId, cProjectId, 0, 0);
  }

  public static ReportTrialBalanceDetailData[] select(ConnectionProvider connectionProvider, String accountName, String accountCode, String selectedOrg, String orgFamily, String adUserClient, String adUserOrg, String accountSet, String parDateFrom, String parDateTo, String acctSchema, String cBpartnerId, String mProductId, String cProjectId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT Y.YEAR AS YEAR, P.NAME AS PERIODNAME," +
      "           SUM(F.AMTACCTDR) AS AMTACCTDR, SUM(F.AMTACCTCR) AS AMTACCTCR," +
      "           ? AS ACCOUNTNAME, ? AS ACCOUNTCODE" +
      "    FROM C_PERIOD P JOIN C_YEAR Y ON (P.C_YEAR_ID=Y.C_YEAR_ID)" +
      "         JOIN C_CALENDAR CAL ON (Y.C_CALENDAR_ID=CAL.C_CALENDAR_ID)," +
      "         C_ELEMENTVALUE EV JOIN FACT_ACCT F ON (EV.C_ELEMENTVALUE_ID=F.ACCOUNT_ID)" +
      "         LEFT JOIN C_BPARTNER ON f.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "         LEFT JOIN M_PRODUCT ON f.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "         LEFT JOIN C_PROJECT ON f.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "    WHERE F.ACCOUNT_ID = EV.C_ELEMENTVALUE_ID" +
      "         AND CAL.C_CALENDAR_ID = " +
      "            (SELECT AD_INHERITEDCALENDAR_ID" +
      "             FROM AD_ORG" +
      "             WHERE AD_ORG_ID = ?)" +
      "         AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "         AND F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "         AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "         AND F.ACCOUNT_ID IN (";
    strSql = strSql + ((accountSet==null || accountSet.equals(""))?"":accountSet);
    strSql = strSql + 
      ")" +
      "         AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + ((acctSchema==null || acctSchema.equals(""))?"":"  AND F.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND F.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND F.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND F.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "         AND F.FACTACCTTYPE <> 'R'" +
      "         AND F.FACTACCTTYPE <> 'C'" +
      "         AND F.FACTACCTTYPE <> 'O'" +
      "         AND F.ISACTIVE = 'Y'" +
      "         AND F.DATEACCT >= P.STARTDATE AND F.DATEACCT <= P.ENDDATE" +
      "    GROUP BY Y.YEAR, P.NAME, P.PERIODNO" +
      "    HAVING SUM(F.AMTACCTDR) <> 0 OR SUM(F.AMTACCTCR) <> 0" +
      "    ORDER BY Y.YEAR, P.PERIODNO";

    ResultSet result;
    Vector<ReportTrialBalanceDetailData> vector = new Vector<ReportTrialBalanceDetailData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountCode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, selectedOrg);
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (accountSet != null && !(accountSet.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (acctSchema != null && !(acctSchema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
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
        ReportTrialBalanceDetailData objectReportTrialBalanceDetailData = new ReportTrialBalanceDetailData();
        objectReportTrialBalanceDetailData.year = UtilSql.getValue(result, "year");
        objectReportTrialBalanceDetailData.periodname = UtilSql.getValue(result, "periodname");
        objectReportTrialBalanceDetailData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportTrialBalanceDetailData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportTrialBalanceDetailData.accountname = UtilSql.getValue(result, "accountname");
        objectReportTrialBalanceDetailData.accountcode = UtilSql.getValue(result, "accountcode");
        objectReportTrialBalanceDetailData.rownum = Long.toString(countRecord);
        objectReportTrialBalanceDetailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceDetailData);
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
    ReportTrialBalanceDetailData objectReportTrialBalanceDetailData[] = new ReportTrialBalanceDetailData[vector.size()];
    vector.copyInto(objectReportTrialBalanceDetailData);
    return(objectReportTrialBalanceDetailData);
  }

  public static ReportTrialBalanceDetailData[] selectOrgWithNotCal(ConnectionProvider connectionProvider, String accountName, String accountCode, String orgFamily, String adUserClient, String adUserOrg, String accountSet, String parDateFrom, String parDateTo, String acctSchema, String cBpartnerId, String mProductId, String cProjectId, String language)    throws ServletException {
    return selectOrgWithNotCal(connectionProvider, accountName, accountCode, orgFamily, adUserClient, adUserOrg, accountSet, parDateFrom, parDateTo, acctSchema, cBpartnerId, mProductId, cProjectId, language, 0, 0);
  }

  public static ReportTrialBalanceDetailData[] selectOrgWithNotCal(ConnectionProvider connectionProvider, String accountName, String accountCode, String orgFamily, String adUserClient, String adUserOrg, String accountSet, String parDateFrom, String parDateTo, String acctSchema, String cBpartnerId, String mProductId, String cProjectId, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT TO_CHAR(F.DATEACCT, 'YYYY') AS YEAR, MT.NAME AS PERIODNAME," +
      "           SUM(F.AMTACCTDR) AS AMTACCTDR, SUM(F.AMTACCTCR) AS AMTACCTCR," +
      "           ? AS ACCOUNTNAME, ? AS ACCOUNTCODE" +
      "    FROM C_ELEMENTVALUE EV JOIN FACT_ACCT F ON (EV.C_ELEMENTVALUE_ID=F.ACCOUNT_ID)" +
      "         LEFT JOIN C_BPARTNER ON f.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "         LEFT JOIN M_PRODUCT ON f.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "         LEFT JOIN C_PROJECT ON f.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "         LEFT JOIN AD_MONTH M ON TO_NUMBER(M.VALUE) = TO_NUMBER(TO_CHAR(F.DATEACCT, 'MM'))" +
      "         LEFT JOIN AD_MONTH_TRL MT ON M.AD_MONTH_ID = MT.AD_MONTH_ID" +
      "    WHERE F.ACCOUNT_ID = EV.C_ELEMENTVALUE_ID" +
      "         AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "         AND F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "         AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "         AND F.ACCOUNT_ID IN (";
    strSql = strSql + ((accountSet==null || accountSet.equals(""))?"":accountSet);
    strSql = strSql + 
      ")" +
      "         AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + ((acctSchema==null || acctSchema.equals(""))?"":"  AND F.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND F.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND F.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND F.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "         AND F.FACTACCTTYPE <> 'R'" +
      "         AND F.FACTACCTTYPE <> 'C'" +
      "         AND F.FACTACCTTYPE <> 'O'" +
      "         AND F.ISACTIVE = 'Y'" +
      "         AND MT.AD_LANGUAGE = ?" +
      "    GROUP BY TO_CHAR(F.DATEACCT, 'YYYY'), M.VALUE, MT.NAME" +
      "    HAVING SUM(F.AMTACCTDR) <> 0 OR SUM(F.AMTACCTCR) <> 0" +
      "    ORDER BY TO_CHAR(F.DATEACCT, 'YYYY'), TO_NUMBER(M.VALUE), MT.NAME";

    ResultSet result;
    Vector<ReportTrialBalanceDetailData> vector = new Vector<ReportTrialBalanceDetailData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountCode);
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (accountSet != null && !(accountSet.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (acctSchema != null && !(acctSchema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

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
        ReportTrialBalanceDetailData objectReportTrialBalanceDetailData = new ReportTrialBalanceDetailData();
        objectReportTrialBalanceDetailData.year = UtilSql.getValue(result, "year");
        objectReportTrialBalanceDetailData.periodname = UtilSql.getValue(result, "periodname");
        objectReportTrialBalanceDetailData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportTrialBalanceDetailData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportTrialBalanceDetailData.accountname = UtilSql.getValue(result, "accountname");
        objectReportTrialBalanceDetailData.accountcode = UtilSql.getValue(result, "accountcode");
        objectReportTrialBalanceDetailData.rownum = Long.toString(countRecord);
        objectReportTrialBalanceDetailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportTrialBalanceDetailData);
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
    ReportTrialBalanceDetailData objectReportTrialBalanceDetailData[] = new ReportTrialBalanceDetailData[vector.size()];
    vector.copyInto(objectReportTrialBalanceDetailData);
    return(objectReportTrialBalanceDetailData);
  }

  public static ReportTrialBalanceDetailData[] set()    throws ServletException {
    ReportTrialBalanceDetailData objectReportTrialBalanceDetailData[] = new ReportTrialBalanceDetailData[1];
    objectReportTrialBalanceDetailData[0] = new ReportTrialBalanceDetailData();
    objectReportTrialBalanceDetailData[0].year = "";
    objectReportTrialBalanceDetailData[0].periodname = "";
    objectReportTrialBalanceDetailData[0].amtacctdr = "";
    objectReportTrialBalanceDetailData[0].amtacctcr = "";
    objectReportTrialBalanceDetailData[0].accountname = "";
    objectReportTrialBalanceDetailData[0].accountcode = "";
    return objectReportTrialBalanceDetailData;
  }

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static String treeAccount(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ID FROM AD_TREE" +
      "        WHERE AD_CLIENT_ID = ?" +
      "        AND TREETYPE = 'EV'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_id");
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

  public static String selectAccountName(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM C_ELEMENTVALUE" +
      "        WHERE C_ELEMENTVALUE_ID = ?" +
      "        AND ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static String selectAccountCode(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE" +
      "        FROM C_ELEMENTVALUE" +
      "        WHERE C_ELEMENTVALUE_ID = ?" +
      "        AND ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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

  public static String getOrganizationCalendarOwner(ConnectionProvider connectionProvider, String ad_org_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_GETCALENDAROWNER(?)" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_getcalendarowner");
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
}
