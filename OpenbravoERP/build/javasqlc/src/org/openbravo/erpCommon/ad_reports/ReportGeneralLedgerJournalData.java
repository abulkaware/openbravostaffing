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
import org.openbravo.data.ScrollableFieldProvider;

class ReportGeneralLedgerJournalData implements FieldProvider, ScrollableFieldProvider {
static Logger log4j = Logger.getLogger(ReportGeneralLedgerJournalData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String schemaId;
  public String schemaName;
  public String identifier;
  public String dateacct;
  public String value;
  public String name;
  public String id;
  public String adTableId;
  public String docbasetype;
  public String docname;
  public String seqno;
  public String total;
  public String description;
  public String factaccttype2;
  public String amtacctdr;
  public String amtacctcr;
  public String groupedlines;
  public String taxid;
  public String tabId;
  public String newstyle;
  public String journalbatchId;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("schema_id") || fieldName.equals("schemaId"))
      return schemaId;
    else if (fieldName.equalsIgnoreCase("schema_name") || fieldName.equals("schemaName"))
      return schemaName;
    else if (fieldName.equalsIgnoreCase("identifier"))
      return identifier;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("docname"))
      return docname;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("factaccttype2"))
      return factaccttype2;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("groupedlines"))
      return groupedlines;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("tab_id") || fieldName.equals("tabId"))
      return tabId;
    else if (fieldName.equalsIgnoreCase("newstyle"))
      return newstyle;
    else if (fieldName.equalsIgnoreCase("journalbatch_id") || fieldName.equals("journalbatchId"))
      return journalbatchId;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  private String scrollableGetter;
  private long countRecord;
  private ResultSet result;
  private boolean hasData;
  private ConnectionProvider internalConnProvider;
  private Connection internalConnection;
  private boolean errorOcurred;
 
  @Override
  public boolean hasData() {
    return hasData;
  }

  @Override
  public boolean next() throws ServletException {
    try {
      if (result.next()) {
        countRecord++;
        return true;
      }
      return false;
    } catch(SQLException e){
      errorOcurred = true;
      log4j.error("Error calling jdbc next()", e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    }
  }

  @Override
  public ReportGeneralLedgerJournalData get() throws ServletException {
    try {
      if ("select".equals(scrollableGetter)) {
        return getselect();
      } else if ("selectCountGroupedLines".equals(scrollableGetter)) {
        return getselectCountGroupedLines();
      } else if ("selectDirect".equals(scrollableGetter)) {
        return getselectDirect();
      } else if ("selectDirect2".equals(scrollableGetter)) {
        return getselectDirect2();
      } else {
        throw new ServletException("getNext() called without calling any scrollable select first");
      }
    } catch(SQLException e){
      errorOcurred = true;
      log4j.error("Error calling jdbc getter()", e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    }
  }

  @Override
  public void close() {
    try {
      if (result != null) {
        result.getStatement().close();
      }
       // handle internalConnection != null explicitely here? then more obvious?
      if (errorOcurred) {
        internalConnProvider.releaseRollbackConnection(internalConnection);
      } else {
        internalConnProvider.releaseCommitConnection(internalConnection);
      }
    } catch (SQLException sqe) {
      log4j.error("Exception on closing statement/resultset", sqe);
    }
  }


  public static ReportGeneralLedgerJournalData select(ConnectionProvider connectionProvider, String rownum, String descriptionGrouping, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String docbasetype, String documentNo, String acctschema, String orgFamily, String checks, String allaccounts, String accountFrom, String accountTo, String paramLanguage, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    ReportGeneralLedgerJournalData instance = new ReportGeneralLedgerJournalData();
    instance.scrollableGetter = "select";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "      SELECT *" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM (" +
      "      SELECT SCHEMA_ID, SCHEMA_NAME, IDENTIFIER, DATEACCT, AA.VALUE, AA.NAME, ID, AD_TABLE_ID, DOCBASETYPE,AR.NAME as DOCNAME, SEQNO, '' AS TOTAL, DESCRIPTION," +
      "      (CASE FACTACCTTYPE WHEN 'O' THEN 1 WHEN 'N' THEN 2 WHEN 'R' THEN 3 WHEN 'D' THEN 4 ELSE 5 END) AS FACTACCTTYPE2," +
      "      (CASE AMTACCTDR WHEN 0 THEN NULL ELSE AMTACCTDR END) AS AMTACCTDR, (CASE AMTACCTCR WHEN 0 THEN NULL ELSE AMTACCTCR END) AS AMTACCTCR, " +
      "      '' AS GROUPEDLINES, '' AS TAXID, AD_GETTAB_FROM_TABLE(AA.AD_TABLE_ID, AA.DOCBASETYPE, AA.AD_CLIENT_ID) AS TAB_ID  , '' as newStyle, AA.journalbatch_id AS journalbatch_id" +
      "      FROM " +
      "      (SELECT F.C_ACCTSCHEMA_ID AS SCHEMA_ID, SC.NAME AS SCHEMA_NAME, F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT," +
      "      F.ACCTVALUE AS VALUE, F.ACCTDESCRIPTION AS NAME, CASE WHEN ";
    strSql = strSql + ((descriptionGrouping==null || descriptionGrouping.equals(""))?"":descriptionGrouping);
    strSql = strSql + 
      " = 'Y' THEN TO_CHAR(F.DESCRIPTION) ELSE TO_CHAR('') END AS DESCRIPTION, F.RECORD_ID AS ID, F.AD_TABLE_ID, F.DOCBASETYPE," +
      "      sum(F.AMTACCTDR) AS AMTACCTDR, sum(F.AMTACCTCR) AS AMTACCTCR, MIN(SEQNO) AS SEQNO, F.FACTACCTTYPE AS FACTACCTTYPE, F.AD_CLIENT_ID, MAX(glj.gl_journalbatch_id) as journalbatch_id" +
      "      FROM FACT_ACCT F" +
      "      JOIN C_ACCTSCHEMA SC ON (F.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID)" +
      "      LEFT JOIN GL_JOURNAL GLJ ON (GLJ.GL_JOURNAL_ID = F.RECORD_ID AND F.AD_TABLE_ID = '224') " +
      "      WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND f.dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND f.dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND f.DOCBASETYPE = ? ");
    strSql = strSql + ((documentNo==null || documentNo.equals(""))?"":"  AND EXISTS " + documentNo);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "      AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "      AND F.FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "      AND f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID" +
      "      AND (?='Y' OR F.FACT_ACCT_GROUP_ID IN (" +
      "                SELECT FACT_ACCT_GROUP_ID FROM FACT_ACCT WHERE ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S')" +
      "                  AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                  AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                  AND 3=3";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND DOCBASETYPE = ? ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                  AND AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "                  AND FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "                ))" +
      "      GROUP BY f.C_ACCTSCHEMA_ID, SC.NAME, F.AD_TABLE_ID, F.DATEACCT, F.ACCTDESCRIPTION, CASE WHEN ";
    strSql = strSql + ((descriptionGrouping==null || descriptionGrouping.equals(""))?"":descriptionGrouping);
    strSql = strSql + 
      " = 'Y' THEN TO_CHAR(F.DESCRIPTION) ELSE TO_CHAR('') END, F.ACCTVALUE, F.DOCBASETYPE, F.RECORD_ID, " +
      "      F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID,F.FACTACCTTYPE," +
      "      (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR) WHEN -1 THEN 3 ELSE 4 END) END), F.AD_CLIENT_ID" +
      "      HAVING (sum(F.AMTACCTDR) <> 0 OR sum(F.AMTACCTCR) <> 0)) AA" +
      "      LEFT JOIN (select * from AD_REF_LIST_V WHERE AD_REFERENCE_ID = '183'  AND AD_LANGUAGE=?) AR  ON AR.VALUE=AA.DOCBASETYPE " +
      "      ORDER BY SCHEMA_NAME, DATEACCT, FACTACCTTYPE2, IDENTIFIER, AA.AMTACCTDR DESC, AA.AMTACCTCR DESC, SEQNO" +
      "      ) B";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "      ) C WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (descriptionGrouping != null && !(descriptionGrouping.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (documentNo != null && !(documentNo.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      if (descriptionGrouping != null && !(descriptionGrouping.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      // on postgres use non zero fetchsize to read data via cursor and not all at once
      if (connectionProvider.getRDBMS().equalsIgnoreCase("POSTGRE")) {
        st.setFetchSize(1000);
      }
      instance.result = st.executeQuery();
      instance.hasData = instance.result.isBeforeFirst();
      instance.countRecord = 0;
    } catch (SQLException e) {
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=@" + ex.getMessage());
    }

    return instance;
  }

  private ReportGeneralLedgerJournalData getselect() throws SQLException {
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData = new ReportGeneralLedgerJournalData();

        objectReportGeneralLedgerJournalData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportGeneralLedgerJournalData.schemaId = UtilSql.getValue(result, "schema_id");
        objectReportGeneralLedgerJournalData.schemaName = UtilSql.getValue(result, "schema_name");
        objectReportGeneralLedgerJournalData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerJournalData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerJournalData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerJournalData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerJournalData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectReportGeneralLedgerJournalData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectReportGeneralLedgerJournalData.docname = UtilSql.getValue(result, "docname");
        objectReportGeneralLedgerJournalData.seqno = UtilSql.getValue(result, "seqno");
        objectReportGeneralLedgerJournalData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerJournalData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerJournalData.factaccttype2 = UtilSql.getValue(result, "factaccttype2");
        objectReportGeneralLedgerJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerJournalData.groupedlines = UtilSql.getValue(result, "groupedlines");
        objectReportGeneralLedgerJournalData.taxid = UtilSql.getValue(result, "taxid");
        objectReportGeneralLedgerJournalData.tabId = UtilSql.getValue(result, "tab_id");
        objectReportGeneralLedgerJournalData.newstyle = UtilSql.getValue(result, "newstyle");
        objectReportGeneralLedgerJournalData.journalbatchId = UtilSql.getValue(result, "journalbatch_id");
        objectReportGeneralLedgerJournalData.rownum = Long.toString(countRecord);
      return objectReportGeneralLedgerJournalData;
  }

  public static String selectCountNoOfRecords(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String docbasetype, String documentNo, String acctschema, String orgFamily, String checks, String allaccounts, String accountFrom, String accountTo, String descriptionGrouping)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(1) AS TOTAL" +
      "      FROM (SELECT 1" +
      "      FROM FACT_ACCT F" +
      "      WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND f.dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND f.dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND f.DOCBASETYPE = ? ");
    strSql = strSql + ((documentNo==null || documentNo.equals(""))?"":"  AND EXISTS " + documentNo);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "      AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "      AND F.FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "      AND (?='Y' OR F.FACT_ACCT_GROUP_ID IN (" +
      "                SELECT FACT_ACCT_GROUP_ID FROM FACT_ACCT WHERE ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S')" +
      "                  AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                  AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                  AND 3=3";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND DOCBASETYPE = ? ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                  AND AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "                  AND FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "                ))" +
      "      GROUP BY f.C_ACCTSCHEMA_ID, F.AD_TABLE_ID, F.DATEACCT, CASE WHEN ";
    strSql = strSql + ((descriptionGrouping==null || descriptionGrouping.equals(""))?"":descriptionGrouping);
    strSql = strSql + 
      " = 'Y' THEN TO_CHAR(F.DESCRIPTION) ELSE TO_CHAR('') END," +
      "      F.DOCBASETYPE, F.RECORD_ID," +
      "      F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID,F.FACTACCTTYPE," +
      "      (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR) WHEN -1 THEN 3 ELSE 4 END) END), F.AD_CLIENT_ID" +
      "      HAVING sum(F.AMTACCTDR) <> 0 OR sum(F.AMTACCTCR) <> 0) AA";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (documentNo != null && !(documentNo.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      if (descriptionGrouping != null && !(descriptionGrouping.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static ReportGeneralLedgerJournalData selectCountGroupedLines(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String docbasetype, String documentNo, String acctschema, String orgFamily, String checks, String allaccounts, String accountFrom, String accountTo, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    ReportGeneralLedgerJournalData instance = new ReportGeneralLedgerJournalData();
    instance.scrollableGetter = "selectCountGroupedLines";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "      SELECT *" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, G.* FROM (" +
      "      SELECT COUNT(*) AS GROUPEDLINES, IDENTIFIER, SCHEMA_NAME, DATEACCT" +
      "      FROM" +
      "      (" +
      "        SELECT SCHEMA_ID, SCHEMA_NAME, IDENTIFIER, DATEACCT, VALUE, NAME, ID, AD_TABLE_ID, DOCBASETYPE, SEQNO, '' AS TOTAL, '' AS DESCRIPTION," +
      "        (CASE AMTACCTDR WHEN 0 THEN NULL ELSE AMTACCTDR END) AS AMTACCTDR, (CASE AMTACCTCR WHEN 0 THEN NULL ELSE AMTACCTCR END) AS AMTACCTCR" +
      "        FROM " +
      "        (SELECT F.C_ACCTSCHEMA_ID AS SCHEMA_ID, SC.NAME AS SCHEMA_NAME, F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT," +
      "        F.ACCTVALUE AS VALUE, F.ACCTDESCRIPTION AS NAME,F.RECORD_ID AS ID, F.AD_TABLE_ID, F.DOCBASETYPE," +
      "        sum(F.AMTACCTDR) AS AMTACCTDR, sum(F.AMTACCTCR) AS AMTACCTCR, MIN(SEQNO) AS SEQNO" +
      "        FROM FACT_ACCT F, C_ACCTSCHEMA SC  " +
      "        WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND f.dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND f.dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND f.DOCBASETYPE = ? ");
    strSql = strSql + ((documentNo==null || documentNo.equals(""))?"":"  AND EXISTS " + documentNo);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "        AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "        AND F.FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "        AND f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID" +
      "        AND (?='Y' OR F.FACT_ACCT_GROUP_ID IN (" +
      "                SELECT FACT_ACCT_GROUP_ID FROM FACT_ACCT WHERE ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S')" +
      "                  AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                  AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                  AND 3=3";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND DOCBASETYPE = ? ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                  AND AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "                  AND FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "                ))" +
      "        GROUP BY f.C_ACCTSCHEMA_ID, SC.NAME, F.AD_TABLE_ID, F.DATEACCT, F.ACCTDESCRIPTION, F.ACCTVALUE, F.DOCBASETYPE, F.RECORD_ID, " +
      "        F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID," +
      "        (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR) WHEN -1 THEN 3 ELSE 4 END) END)) AA" +
      "        ORDER BY SCHEMA_NAME, DATEACCT, IDENTIFIER, SEQNO" +
      "      ) BB" +
      "      GROUP BY IDENTIFIER, SCHEMA_NAME, DATEACCT" +
      "      ORDER BY SCHEMA_NAME, DATEACCT, IDENTIFIER" +
      "      ) G";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "      ) H WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (documentNo != null && !(documentNo.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      // on postgres use non zero fetchsize to read data via cursor and not all at once
      if (connectionProvider.getRDBMS().equalsIgnoreCase("POSTGRE")) {
        st.setFetchSize(1000);
      }
      instance.result = st.executeQuery();
      instance.hasData = instance.result.isBeforeFirst();
      instance.countRecord = 0;
    } catch (SQLException e) {
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=@" + ex.getMessage());
    }

    return instance;
  }

  private ReportGeneralLedgerJournalData getselectCountGroupedLines() throws SQLException {
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData = new ReportGeneralLedgerJournalData();

        objectReportGeneralLedgerJournalData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportGeneralLedgerJournalData.groupedlines = UtilSql.getValue(result, "groupedlines");
        objectReportGeneralLedgerJournalData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalData.schemaName = UtilSql.getValue(result, "schema_name");
        objectReportGeneralLedgerJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerJournalData.rownum = Long.toString(countRecord);
      return objectReportGeneralLedgerJournalData;
  }

  public static String selectCount(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String parDateFrom, String parDateTo, String docbasetype, String documentNo, String acctschema, String orgFamily, String checks, String allaccounts, String accountFrom, String accountTo, String dateAcct, String factAcctGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(FACT_ACCT_GROUP_ID) AS TOTAL" +
      "        FROM (" +
      "        SELECT F.DATEACCT, F.FACT_ACCT_GROUP_ID  " +
      "        FROM FACT_ACCT F left join AD_TABLE T on F.AD_TABLE_ID = T.AD_TABLE_ID" +
      "                         left join AD_TAB TB  on T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                         left join AD_COLUMN C on T.AD_TABLE_ID = C.AD_TABLE_ID " +
      "                                              AND C.ISKEY = 'Y'  " +
      "                         left join AD_WINDOW W on TB.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "        WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND f.dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND f.dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND f.DOCBASETYPE = ? ");
    strSql = strSql + ((documentNo==null || documentNo.equals(""))?"":"  AND EXISTS " + documentNo);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "        AND f.AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")     " +
      "	      AND F.FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "        AND (CASE (SELECT MAX(ISSOTRX) FROM C_DOCTYPE D " +
      "                    WHERE D.DOCBASETYPE = F.DOCBASETYPE) WHEN 'N' THEN COALESCE(T.PO_WINDOW_ID, T.AD_WINDOW_ID) ELSE T.AD_WINDOW_ID END) = (CASE TO_CHAR(F.DOCBASETYPE) " +
      "                    WHEN 'FAT' THEN '94EAA455D2644E04AB25D93BE5157B6D' ELSE W.AD_WINDOW_ID END)" +
      "        AND (?='Y' OR F.FACT_ACCT_GROUP_ID IN (" +
      "                SELECT FACT_ACCT_GROUP_ID FROM FACT_ACCT WHERE ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S')" +
      "                  AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                  AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                  AND 3=3";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND dateacct >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND dateacct < TO_DATE(?) ");
    strSql = strSql + ((docbasetype==null || docbasetype.equals(""))?"":"  AND DOCBASETYPE = ? ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                  AND AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "                  AND FactAcctType IN (";
    strSql = strSql + ((checks==null || checks.equals(""))?"":checks);
    strSql = strSql + 
      ")" +
      "                ))" +
      "        GROUP BY F.DATEACCT, F.FACT_ACCT_GROUP_ID) AA" +
      "        WHERE (DATEACCT< TO_DATE(?) OR (DATEACCT=TO_DATE(?) AND FACT_ACCT_GROUP_ID < ?))";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (documentNo != null && !(documentNo.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (docbasetype != null && !(docbasetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbasetype);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (orgFamily != null && !(orgFamily.equals(""))) {
        }
      if (checks != null && !(checks.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctGroupId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static ReportGeneralLedgerJournalData[] set(String rownum)    throws ServletException {
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData[] = new ReportGeneralLedgerJournalData[1];
    objectReportGeneralLedgerJournalData[0] = new ReportGeneralLedgerJournalData();
    objectReportGeneralLedgerJournalData[0].total = "";
    return objectReportGeneralLedgerJournalData;
  }

  public static ReportGeneralLedgerJournalData selectDirect(ConnectionProvider connectionProvider, String rownum, String descriptionGrouping, String adUserClient, String adUserOrg, String table, String record, String cAcctshemaId, String paramLanguage, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    ReportGeneralLedgerJournalData instance = new ReportGeneralLedgerJournalData();
    instance.scrollableGetter = "selectDirect";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "      SELECT *" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM (" +
      "      SELECT SCHEMA_ID, SCHEMA_NAME, IDENTIFIER, DATEACCT, AA.VALUE, AA.NAME, ID, AD_TABLE_ID, DOCBASETYPE,AR.NAME as DOCNAME, SEQNO, '' AS TOTAL, DESCRIPTION," +
      "      (CASE FACTACCTTYPE WHEN 'O' THEN 1 WHEN 'N' THEN 2 WHEN 'R' THEN 3 WHEN 'D' THEN 4 ELSE 5 END) AS FACTACCTTYPE2," +
      "      (CASE AMTACCTDR WHEN 0 THEN NULL ELSE AMTACCTDR END) AS AMTACCTDR, (CASE AMTACCTCR WHEN 0 THEN NULL ELSE AMTACCTCR END) AS AMTACCTCR," +
      "      AD_GETTAB_FROM_TABLE(AA.AD_TABLE_ID, AA.DOCBASETYPE, AA.AD_CLIENT_ID) AS TAB_ID  , '' as newStyle, AA.journalbatch_id AS journalbatch_id" +
      "      FROM " +
      "      (SELECT F.C_ACCTSCHEMA_ID AS SCHEMA_ID, SC.NAME AS SCHEMA_NAME, F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT," +
      "      F.ACCTVALUE AS VALUE, F.ACCTDESCRIPTION AS NAME, CASE WHEN ";
    strSql = strSql + ((descriptionGrouping==null || descriptionGrouping.equals(""))?"":descriptionGrouping);
    strSql = strSql + 
      " = 'Y' THEN TO_CHAR(F.DESCRIPTION) ELSE TO_CHAR('') END AS DESCRIPTION, F.RECORD_ID AS ID, F.AD_TABLE_ID, F.DOCBASETYPE," +
      "      sum(F.AMTACCTDR) AS AMTACCTDR, sum(F.AMTACCTCR) AS AMTACCTCR, MIN(SEQNO) AS SEQNO, F.FACTACCTTYPE AS FACTACCTTYPE, F.AD_CLIENT_ID, MAX(glj.gl_journalbatch_id) as journalbatch_id" +
      "      FROM FACT_ACCT F" +
      "      JOIN C_ACCTSCHEMA SC ON (f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID)" +
      "      LEFT JOIN GL_JOURNAL GLJ ON (GLJ.GL_JOURNAL_ID = f.RECORD_ID AND f.AD_TABLE_ID = '224')" +
      "      WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((table==null || table.equals(""))?"":"  AND f.ad_table_Id = ? ");
    strSql = strSql + ((record==null || record.equals(""))?"":"  AND f.record_Id = ? ");
    strSql = strSql + ((table==null || table.equals(""))?"":"  AND f.ad_table_ID = ? ");
    strSql = strSql + ((record==null || record.equals(""))?"":"  AND f.record_ID = ? ");
    strSql = strSql + 
      "      AND f.C_ACCTSCHEMA_ID = ?" +
      "      GROUP BY f.C_ACCTSCHEMA_ID, SC.NAME, F.AD_TABLE_ID, F.DATEACCT, F.ACCTDESCRIPTION, CASE WHEN ";
    strSql = strSql + ((descriptionGrouping==null || descriptionGrouping.equals(""))?"":descriptionGrouping);
    strSql = strSql + 
      " = 'Y' THEN TO_CHAR(F.DESCRIPTION) ELSE TO_CHAR('') END,  F.ACCTVALUE, F.DOCBASETYPE, F.RECORD_ID, " +
      "      F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID,F.FACTACCTTYPE," +
      "      (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR) WHEN -1 THEN 3 ELSE 4 END) END), F.AD_CLIENT_ID" +
      "      HAVING (sum(F.AMTACCTDR) <> 0 OR sum(F.AMTACCTCR) <> 0)) AA" +
      "      LEFT JOIN (select * from AD_REF_LIST_V WHERE AD_REFERENCE_ID = '183'  AND AD_LANGUAGE=?) AR  ON AR.VALUE=AA.DOCBASETYPE " +
      "      ORDER BY SCHEMA_NAME, DATEACCT, FACTACCTTYPE2, IDENTIFIER, AA.AMTACCTDR DESC, AA.AMTACCTCR DESC, SEQNO" +
      "      ) B";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "      ) C WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (descriptionGrouping != null && !(descriptionGrouping.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (table != null && !(table.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      }
      if (record != null && !(record.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, record);
      }
      if (table != null && !(table.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      }
      if (record != null && !(record.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, record);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctshemaId);
      if (descriptionGrouping != null && !(descriptionGrouping.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      // on postgres use non zero fetchsize to read data via cursor and not all at once
      if (connectionProvider.getRDBMS().equalsIgnoreCase("POSTGRE")) {
        st.setFetchSize(1000);
      }
      instance.result = st.executeQuery();
      instance.hasData = instance.result.isBeforeFirst();
      instance.countRecord = 0;
    } catch (SQLException e) {
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=@" + ex.getMessage());
    }

    return instance;
  }

  private ReportGeneralLedgerJournalData getselectDirect() throws SQLException {
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData = new ReportGeneralLedgerJournalData();

        objectReportGeneralLedgerJournalData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportGeneralLedgerJournalData.schemaId = UtilSql.getValue(result, "schema_id");
        objectReportGeneralLedgerJournalData.schemaName = UtilSql.getValue(result, "schema_name");
        objectReportGeneralLedgerJournalData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerJournalData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerJournalData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerJournalData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerJournalData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectReportGeneralLedgerJournalData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectReportGeneralLedgerJournalData.docname = UtilSql.getValue(result, "docname");
        objectReportGeneralLedgerJournalData.seqno = UtilSql.getValue(result, "seqno");
        objectReportGeneralLedgerJournalData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerJournalData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerJournalData.factaccttype2 = UtilSql.getValue(result, "factaccttype2");
        objectReportGeneralLedgerJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerJournalData.tabId = UtilSql.getValue(result, "tab_id");
        objectReportGeneralLedgerJournalData.newstyle = UtilSql.getValue(result, "newstyle");
        objectReportGeneralLedgerJournalData.journalbatchId = UtilSql.getValue(result, "journalbatch_id");
        objectReportGeneralLedgerJournalData.rownum = Long.toString(countRecord);
      return objectReportGeneralLedgerJournalData;
  }

  public static String selectCountDirect(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String table, String record, String factAcctGroup, String dateAcct, String factAcctGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(FACT_ACCT_GROUP_ID) AS TOTAL" +
      "        FROM (" +
      "        SELECT F.DATEACCT, F.FACT_ACCT_GROUP_ID  " +
      "        FROM  AD_TABLE T left join AD_TAB TB on T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                         left join AD_COLUMN C  on T.AD_TABLE_ID = C.AD_TABLE_ID " +
      "                                               AND C.ISKEY = 'Y'" +
      "                         left join FACT_ACCT F on F.AD_TABLE_ID = T.AD_TABLE_ID" +
      "                         left join AD_WINDOW W on TB.AD_WINDOW_ID = W.AD_WINDOW_ID " +
      "        WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((table==null || table.equals(""))?"":"  AND f.ad_table_Id = ? ");
    strSql = strSql + ((record==null || record.equals(""))?"":"  AND f.record_Id = ? ");
    strSql = strSql + 
      "        AND F.fact_acct_group_id = ?" +
      "        AND (CASE (SELECT MAX(ISSOTRX) FROM C_DOCTYPE D " +
      "        WHERE D.DOCBASETYPE = F.DOCBASETYPE) WHEN 'N' THEN COALESCE(T.PO_WINDOW_ID, T.AD_WINDOW_ID) ELSE T.AD_WINDOW_ID END) = W.AD_WINDOW_ID " +
      "        GROUP BY F.DATEACCT, F.FACT_ACCT_GROUP_ID) AA" +
      "        WHERE (DATEACCT< TO_DATE(?) OR (DATEACCT=to_date(?) AND FACT_ACCT_GROUP_ID < ?))";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (table != null && !(table.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      }
      if (record != null && !(record.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, record);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctGroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctGroupId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static ReportGeneralLedgerJournalData selectDirect2(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String factAcctGroupId, String paramLanguage)    throws ServletException {
    ReportGeneralLedgerJournalData instance = new ReportGeneralLedgerJournalData();
    instance.scrollableGetter = "selectDirect2";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "      SELECT SCHEMA_ID, SCHEMA_NAME, IDENTIFIER, DATEACCT, AA.VALUE, AA.NAME, ID, AD_TABLE_ID, DOCBASETYPE,AR.NAME as DOCNAME, SEQNO, '' AS TOTAL,  (CASE FACTACCTTYPE WHEN 'O' THEN 1 WHEN 'N' THEN 2 WHEN 'R' THEN 3 WHEN 'D' THEN 4 ELSE 5 END) AS FACTACCTTYPE2," +
      "      (CASE AMTACCTDR WHEN 0 THEN NULL ELSE AMTACCTDR END) AS AMTACCTDR, (CASE AMTACCTCR WHEN 0 THEN NULL ELSE AMTACCTCR END) AS AMTACCTCR," +
      "      AD_GETTAB_FROM_TABLE(AA.AD_TABLE_ID, AA.DOCBASETYPE, AA.AD_CLIENT_ID) AS TAB_ID  , '' as newStyle, AA.journalbatch_id AS journalbatch_id" +
      "      FROM " +
      "      (SELECT F.C_ACCTSCHEMA_ID AS SCHEMA_ID, SC.NAME AS SCHEMA_NAME, F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT," +
      "      F.ACCTVALUE AS VALUE, F.ACCTDESCRIPTION AS NAME, F.RECORD_ID AS ID, F.AD_TABLE_ID, F.DOCBASETYPE," +
      "      sum(F.AMTACCTDR) AS AMTACCTDR, sum(F.AMTACCTCR) AS AMTACCTCR, MIN(SEQNO) AS SEQNO, F.FACTACCTTYPE AS FACTACCTTYPE, F.AD_CLIENT_ID, MAX(glj.gl_journalbatch_id) as journalbatch_id" +
      "      FROM FACT_ACCT F" +
      "      JOIN C_ACCTSCHEMA SC ON (f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID)" +
      "      LEFT JOIN GL_JOURNAL GLJ ON (GLJ.GL_JOURNAL_ID = f.RECORD_ID AND f.AD_TABLE_ID = '224') " +
      "      WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID" +
      "      AND F.Fact_Acct_Group_ID = ?" +
      "      GROUP BY f.C_ACCTSCHEMA_ID, SC.NAME, F.AD_TABLE_ID, F.DATEACCT, F.ACCTDESCRIPTION, F.ACCTVALUE, F.DOCBASETYPE, F.RECORD_ID, " +
      "      F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID,F.FACTACCTTYPE," +
      "      (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR) WHEN -1 THEN 3 ELSE 4 END) END), F.AD_CLIENT_ID" +
      "      HAVING (sum(F.AMTACCTDR) <> 0 OR sum(F.AMTACCTCR) <> 0)) AA" +
      "      LEFT JOIN (select * from AD_REF_LIST_V WHERE AD_REFERENCE_ID = '183'  AND AD_LANGUAGE=?) AR  ON AR.VALUE=AA.DOCBASETYPE " +
      "      ORDER BY SCHEMA_NAME, DATEACCT, FACTACCTTYPE2, IDENTIFIER, AA.AMTACCTDR DESC, AA.AMTACCTCR DESC, SEQNO";

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);

      // on postgres use non zero fetchsize to read data via cursor and not all at once
      if (connectionProvider.getRDBMS().equalsIgnoreCase("POSTGRE")) {
        st.setFetchSize(1000);
      }
      instance.result = st.executeQuery();
      instance.hasData = instance.result.isBeforeFirst();
      instance.countRecord = 0;
    } catch (SQLException e) {
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      instance.errorOcurred = true;
      throw new ServletException("@CODE=@" + ex.getMessage());
    }

    return instance;
  }

  private ReportGeneralLedgerJournalData getselectDirect2() throws SQLException {
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData = new ReportGeneralLedgerJournalData();

        objectReportGeneralLedgerJournalData.schemaId = UtilSql.getValue(result, "schema_id");
        objectReportGeneralLedgerJournalData.schemaName = UtilSql.getValue(result, "schema_name");
        objectReportGeneralLedgerJournalData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerJournalData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerJournalData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerJournalData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerJournalData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectReportGeneralLedgerJournalData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectReportGeneralLedgerJournalData.docname = UtilSql.getValue(result, "docname");
        objectReportGeneralLedgerJournalData.seqno = UtilSql.getValue(result, "seqno");
        objectReportGeneralLedgerJournalData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerJournalData.factaccttype2 = UtilSql.getValue(result, "factaccttype2");
        objectReportGeneralLedgerJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerJournalData.tabId = UtilSql.getValue(result, "tab_id");
        objectReportGeneralLedgerJournalData.newstyle = UtilSql.getValue(result, "newstyle");
        objectReportGeneralLedgerJournalData.journalbatchId = UtilSql.getValue(result, "journalbatch_id");
        objectReportGeneralLedgerJournalData.rownum = Long.toString(countRecord);
      return objectReportGeneralLedgerJournalData;
  }

  public static String selectCountDirect2(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String factAcctGroupId, String dateAcct, String identifier)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(FACT_ACCT_GROUP_ID) AS TOTAL" +
      "        FROM (" +
      "        SELECT F.DATEACCT, F.FACT_ACCT_GROUP_ID  " +
      "        FROM AD_TABLE T left join AD_TAB TB    on T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                        left join AD_COLUMN C  on T.AD_TABLE_ID = C.AD_TABLE_ID" +
      "                                              AND C.ISKEY = 'Y'" +
      "                        left join FACT_ACCT F  on F.AD_TABLE_ID = T.AD_TABLE_ID " +
      "                        left join AD_WINDOW W  on TB.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "        WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1" +
      "        and f.fact_acct_group_id = ?" +
      "        AND (CASE (SELECT MAX(ISSOTRX) FROM C_DOCTYPE D " +
      "        WHERE D.DOCBASETYPE = F.DOCBASETYPE) WHEN 'N' THEN COALESCE(T.PO_WINDOW_ID, T.AD_WINDOW_ID) ELSE T.AD_WINDOW_ID END) = W.AD_WINDOW_ID " +
      "        GROUP BY F.DATEACCT, F.FACT_ACCT_GROUP_ID) AA" +
      "        WHERE (DATEACCT< to_date(?) OR (DATEACCT=to_date(?) AND FACT_ACCT_GROUP_ID < ?))";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identifier);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String selectCompany(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM AD_CLIENT" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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

  public static String selectOrg(ConnectionProvider connectionProvider, String orgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME" +
      "        FROM AD_ORG" +
      "        WHERE AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);

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

  public static String selectOrgTaxID(ConnectionProvider connectionProvider, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MIN(I.TAXID)" +
      "        FROM AD_ORGINFO I" +
      "        WHERE I.AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "min");
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
