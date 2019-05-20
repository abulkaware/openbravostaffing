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
import org.openbravo.data.ScrollableFieldProvider;

class ReportGeneralLedgerData implements FieldProvider, ScrollableFieldProvider {
static Logger log4j = Logger.getLogger(ReportGeneralLedgerData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String value;
  public String name;
  public String dateacct;
  public String amtacctdr;
  public String amtacctcr;
  public String total;
  public String factAcctGroupId;
  public String id;
  public String groupbyid;
  public String groupbyname;
  public String description;
  public String isdebit;
  public String totalacctdr;
  public String totalacctcr;
  public String totalacctsub;
  public String previousdebit;
  public String previouscredit;
  public String previoustotal;
  public String finaldebit;
  public String finalcredit;
  public String finaltotal;
  public String dateacctnumber;
  public String groupby;
  public String bpid;
  public String bpname;
  public String pdid;
  public String pdname;
  public String pjid;
  public String pjname;
  public String factaccttype;
  public String factAcctId;
  public String amtacctdrprevsum;
  public String amtacctcrprevsum;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("fact_acct_group_id") || fieldName.equals("factAcctGroupId"))
      return factAcctGroupId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("groupbyid"))
      return groupbyid;
    else if (fieldName.equalsIgnoreCase("groupbyname"))
      return groupbyname;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isdebit"))
      return isdebit;
    else if (fieldName.equalsIgnoreCase("totalacctdr"))
      return totalacctdr;
    else if (fieldName.equalsIgnoreCase("totalacctcr"))
      return totalacctcr;
    else if (fieldName.equalsIgnoreCase("totalacctsub"))
      return totalacctsub;
    else if (fieldName.equalsIgnoreCase("previousdebit"))
      return previousdebit;
    else if (fieldName.equalsIgnoreCase("previouscredit"))
      return previouscredit;
    else if (fieldName.equalsIgnoreCase("previoustotal"))
      return previoustotal;
    else if (fieldName.equalsIgnoreCase("finaldebit"))
      return finaldebit;
    else if (fieldName.equalsIgnoreCase("finalcredit"))
      return finalcredit;
    else if (fieldName.equalsIgnoreCase("finaltotal"))
      return finaltotal;
    else if (fieldName.equalsIgnoreCase("dateacctnumber"))
      return dateacctnumber;
    else if (fieldName.equalsIgnoreCase("groupby"))
      return groupby;
    else if (fieldName.equalsIgnoreCase("bpid"))
      return bpid;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("pdid"))
      return pdid;
    else if (fieldName.equalsIgnoreCase("pdname"))
      return pdname;
    else if (fieldName.equalsIgnoreCase("pjid"))
      return pjid;
    else if (fieldName.equalsIgnoreCase("pjname"))
      return pjname;
    else if (fieldName.equalsIgnoreCase("factaccttype"))
      return factaccttype;
    else if (fieldName.equalsIgnoreCase("fact_acct_id") || fieldName.equals("factAcctId"))
      return factAcctId;
    else if (fieldName.equalsIgnoreCase("amtacctdrprevsum"))
      return amtacctdrprevsum;
    else if (fieldName.equalsIgnoreCase("amtacctcrprevsum"))
      return amtacctcrprevsum;
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
  public ReportGeneralLedgerData get() throws ServletException {
    try {
      if ("select2".equals(scrollableGetter)) {
        return getselect2();
      } else if ("selectXLS2".equals(scrollableGetter)) {
        return getselectXLS2();
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


  public static ReportGeneralLedgerData[] select(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String adLanguage, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String factAcctId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return select(connectionProvider, rownum, groupbytext, groupby, adLanguage, parDateFrom, parDateTo, allaccounts, accountFrom, accountTo, adUserOrg, adUserClient, hideMatched, acctschema, parDateFrom2, parDateTo2, org, cBpartnerId, mProductId, cProjectId, paramAmtFrom, paramAmtTo, accountId, factAcctId, cBPartner, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ReportGeneralLedgerData[] select(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String adLanguage, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String factAcctId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM (" +
      "        SELECT *" +
      "        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C.* FROM (" +
      "          SELECT VALUE, NAME, DATEACCT," +
      "              SUM(AMTACCTDR) AS AMTACCTDR, SUM(AMTACCTCR) AS AMTACCTCR, (SUM(AMTACCTDR)-SUM(AMTACCTCR)) AS TOTAL," +
      "              FACT_ACCT_GROUP_ID, ID, groupbyid, groupbyname," +
      "              DESCRIPTION, ISDEBIT," +
      "              0 AS TOTALACCTDR, 0 AS TOTALACCTCR, 0 AS TOTALACCTSUB," +
      "              0 AS PREVIOUSDEBIT, 0 AS PREVIOUSCREDIT, 0 AS PREVIOUSTOTAL," +
      "              0 AS FINALDEBIT, 0 AS FINALCREDIT, 0 AS FINALTOTAL," +
      "              TO_CHAR(DATEACCT,'J') AS DATEACCTNUMBER," +
      "              ? AS groupby, '' as bpid, '' as bpname, '' as pdid, '' as pdname, '' as pjid, '' as pjname, " +
      "              factaccttype, '' as fact_acct_id, 0 AS AMTACCTDRPREVSUM, 0 AS AMTACCTCRPREVSUM" +
      "          FROM" +
      "            (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "                DATEACCT, AMTACCTDR, AMTACCTCR," +
      "                FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN c_bpartner.c_bpartner_id" +
      "                  WHEN 'Product' THEN m_product.m_product_id" +
      "                  WHEN 'Project' THEN c_project.c_project_id" +
      "                  ELSE '' END AS groupbyid," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN (case AD_COLUMN_IDENTIFIER('C_Bpartner',c_bpartner.c_bpartner_id, ?) when '**' then '' else AD_COLUMN_IDENTIFIER('C_Bpartner',c_bpartner.c_bpartner_id, ?) end)" +
      "                  WHEN 'Product' THEN (case  AD_COLUMN_IDENTIFIER('M_Product',m_product.m_product_id, ?) when '**' then '' else AD_COLUMN_IDENTIFIER('M_Product',m_product.m_product_id, ?) end)" +
      "                  WHEN 'Project' THEN (case  AD_COLUMN_IDENTIFIER('C_Project',c_project.c_project_id, ?) when '**' then '' else AD_COLUMN_IDENTIFIER('C_Project',c_project.c_project_id, ?) end)" +
      "                  ELSE '' END AS groupbyname," +
      "                CASE WHEN (AMTACCTDR > 0 AND AMTACCTCR = 0) OR (AMTACCTCR < 0 AND AMTACCTDR = 0) THEN 'Y' ELSE 'N' END AS ISDEBIT," +
      "		CASE WHEN FACT_ACCT.FACTACCTTYPE = 'O' THEN 1 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'N' THEN 2 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'R' THEN 3 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'C' THEN 4 END) END) END) END AS FACTACCTTYPE" +
      "            FROM FACT_ACCT" +
      "              LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "              LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "              LEFT JOIN(" +
      "                  select account_id, record_id2, sum(amtacctdr-amtacctcr) as sum" +
      "                  from fact_acct f1" +
      "                  where 5=5";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "                  group by account_id, record_id2" +
      "                ) f2 ON fact_acct.account_id = f2.account_id and fact_acct.record_id2 = f2.record_id2" +
      "            WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                      SELECT c_elementvalue_id as name" +
      "                      FROM C_ELEMENTVALUE" +
      "                      WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                    ))" +
      "              AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "              AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "              AND (? = 'N' OR (fact_acct.RECORD_ID2 IS NULL) OR (SUM != 0))" +
      "              AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "              AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "              AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "              AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "            WHERE 6=6";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":" AND ID = ?  ");
    strSql = strSql + ((factAcctId==null || factAcctId.equals(""))?"":" and to_char(DATEACCT,'J')||FACT_ACCT_GROUP_ID||DESCRIPTION||ISDEBIT < ?  ");
    strSql = strSql + ((cBPartner==null || cBPartner.equals(""))?"":" AND groupbyid = ?  ");
    strSql = strSql + 
      "            GROUP BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "            DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, DESCRIPTION, ISDEBIT" +
      "            HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "            ORDER  BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "            DATEACCT, FACTACCTTYPE,  FACT_ACCT_GROUP_ID, DESCRIPTION, ISDEBIT";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "          ) C";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "        ) B WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + 
      "      ) A ORDER BY  groupbyname, groupbyid, VALUE, DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, DESCRIPTION, ISDEBIT";

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupbytext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hideMatched);
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
      }
      if (accountId != null && !(accountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      }
      if (factAcctId != null && !(factAcctId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
      }
      if (cBPartner != null && !(cBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartner);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportGeneralLedgerData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerData.factAcctGroupId = UtilSql.getValue(result, "fact_acct_group_id");
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.groupbyid = UtilSql.getValue(result, "groupbyid");
        objectReportGeneralLedgerData.groupbyname = UtilSql.getValue(result, "groupbyname");
        objectReportGeneralLedgerData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerData.isdebit = UtilSql.getValue(result, "isdebit");
        objectReportGeneralLedgerData.totalacctdr = UtilSql.getValue(result, "totalacctdr");
        objectReportGeneralLedgerData.totalacctcr = UtilSql.getValue(result, "totalacctcr");
        objectReportGeneralLedgerData.totalacctsub = UtilSql.getValue(result, "totalacctsub");
        objectReportGeneralLedgerData.previousdebit = UtilSql.getValue(result, "previousdebit");
        objectReportGeneralLedgerData.previouscredit = UtilSql.getValue(result, "previouscredit");
        objectReportGeneralLedgerData.previoustotal = UtilSql.getValue(result, "previoustotal");
        objectReportGeneralLedgerData.finaldebit = UtilSql.getValue(result, "finaldebit");
        objectReportGeneralLedgerData.finalcredit = UtilSql.getValue(result, "finalcredit");
        objectReportGeneralLedgerData.finaltotal = UtilSql.getValue(result, "finaltotal");
        objectReportGeneralLedgerData.dateacctnumber = UtilSql.getValue(result, "dateacctnumber");
        objectReportGeneralLedgerData.groupby = UtilSql.getValue(result, "groupby");
        objectReportGeneralLedgerData.bpid = UtilSql.getValue(result, "bpid");
        objectReportGeneralLedgerData.bpname = UtilSql.getValue(result, "bpname");
        objectReportGeneralLedgerData.pdid = UtilSql.getValue(result, "pdid");
        objectReportGeneralLedgerData.pdname = UtilSql.getValue(result, "pdname");
        objectReportGeneralLedgerData.pjid = UtilSql.getValue(result, "pjid");
        objectReportGeneralLedgerData.pjname = UtilSql.getValue(result, "pjname");
        objectReportGeneralLedgerData.factaccttype = UtilSql.getValue(result, "factaccttype");
        objectReportGeneralLedgerData.factAcctId = UtilSql.getValue(result, "fact_acct_id");
        objectReportGeneralLedgerData.amtacctdrprevsum = UtilSql.getValue(result, "amtacctdrprevsum");
        objectReportGeneralLedgerData.amtacctcrprevsum = UtilSql.getValue(result, "amtacctcrprevsum");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData select2(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String dateBalanced, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, String factAcctId)    throws ServletException {
    ReportGeneralLedgerData instance = new ReportGeneralLedgerData();
    instance.scrollableGetter = "select2";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "        SELECT *" +
      "        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C.* FROM (" +
      "          SELECT VALUE, NAME, DATEACCT," +
      "              COALESCE(SUM(AMTACCTDR),0) AS AMTACCTDR, COALESCE(SUM(AMTACCTCR),0) AS AMTACCTCR, COALESCE(SUM(AMTACCTDR-AMTACCTCR),0) AS TOTAL," +
      "              MAX(FACT_ACCT_ID) AS FACT_ACCT_ID," +
      "              FACT_ACCT_GROUP_ID, ID, groupbyid, groupbyname," +
      "              DESCRIPTION, ISDEBIT," +
      "              0 AS TOTALACCTDR, 0 AS TOTALACCTCR, 0 AS TOTALACCTSUB," +
      "              0 AS PREVIOUSDEBIT, 0 AS PREVIOUSCREDIT, 0 AS PREVIOUSTOTAL," +
      "              0 AS FINALDEBIT, 0 AS FINALCREDIT, 0 AS FINALTOTAL," +
      "              TO_CHAR(DATEACCT,'J') AS DATEACCTNUMBER," +
      "              ? AS groupby, '' as bpid, '' as bpname, '' as pdid, '' as pdname, '' as pjid, '' as pjname, factaccttype" +
      "              , 0 AS AMTACCTDRPREVSUM, 0 AS AMTACCTCRPREVSUM" +
      "          FROM" +
      "            (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "                DATEACCT, AMTACCTDR, AMTACCTCR, FACT_ACCT_ID," +
      "                FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN c_bpartner.c_bpartner_id" +
      "                  WHEN 'Product' THEN m_product.m_product_id" +
      "                  WHEN 'Project' THEN c_project.c_project_id" +
      "                  ELSE '' END AS groupbyid," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN (select to_char(name) from c_bpartner b where b.c_bpartner_id = c_bpartner.c_bpartner_id)" +
      "                  WHEN 'Product' THEN (select to_char(value || ' - ' || name) from m_product p where p.m_product_id = m_product.m_product_id)" +
      "                  WHEN 'Project' THEN (select to_char(value || ' - ' || name) from c_project pj where pj.c_project_id = c_project.c_project_id)" +
      "                  ELSE '' END AS groupbyname," +
      "                CASE WHEN (AMTACCTDR > 0 AND AMTACCTCR = 0) OR (AMTACCTCR < 0 AND AMTACCTDR = 0) THEN 'Y' ELSE 'N' END AS ISDEBIT," +
      "        CASE WHEN FACT_ACCT.FACTACCTTYPE = 'O' THEN 1 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'N' THEN 2 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'R' THEN 3 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'C' THEN 4 END) END) END) END AS FACTACCTTYPE" +
      "            FROM FACT_ACCT" +
      "              LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "              LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "            WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                      SELECT c_elementvalue_id as name" +
      "                      FROM C_ELEMENTVALUE" +
      "                      WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                    ))" +
      "              AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "              AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "              AND 1=1";
    strSql = strSql + ((dateBalanced==null || dateBalanced.equals(""))?"":" AND (FACT_ACCT.DATEBALANCED IS NULL OR FACT_ACCT.DATEBALANCED > TO_DATE(?))  ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "              AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "              AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "              AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "            WHERE 6=6";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":" AND ID = ?  ");
    strSql = strSql + ((cBPartner==null || cBPartner.equals(""))?"":" AND groupbyid = ?  ");
    strSql = strSql + 
      "            GROUP BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "            DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, DESCRIPTION, ISDEBIT" +
      "            HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "            ORDER  BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "            DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID,  FACT_ACCT_ID, DESCRIPTION, ISDEBIT";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "          ) C";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "        ) B WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + ((factAcctId==null || factAcctId.equals(""))?"":"  and to_char(DATEACCT,'J')||FACTACCTTYPE||FACT_ACCT_GROUP_ID||FACT_ACCT_ID < ?  ");

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupbytext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateBalanced != null && !(dateBalanced.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateBalanced);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
      }
      if (accountId != null && !(accountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      }
      if (cBPartner != null && !(cBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartner);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }
      if (factAcctId != null && !(factAcctId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
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

  private ReportGeneralLedgerData getselect2() throws SQLException {
    ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();

        objectReportGeneralLedgerData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportGeneralLedgerData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerData.factAcctId = UtilSql.getValue(result, "fact_acct_id");
        objectReportGeneralLedgerData.factAcctGroupId = UtilSql.getValue(result, "fact_acct_group_id");
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.groupbyid = UtilSql.getValue(result, "groupbyid");
        objectReportGeneralLedgerData.groupbyname = UtilSql.getValue(result, "groupbyname");
        objectReportGeneralLedgerData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerData.isdebit = UtilSql.getValue(result, "isdebit");
        objectReportGeneralLedgerData.totalacctdr = UtilSql.getValue(result, "totalacctdr");
        objectReportGeneralLedgerData.totalacctcr = UtilSql.getValue(result, "totalacctcr");
        objectReportGeneralLedgerData.totalacctsub = UtilSql.getValue(result, "totalacctsub");
        objectReportGeneralLedgerData.previousdebit = UtilSql.getValue(result, "previousdebit");
        objectReportGeneralLedgerData.previouscredit = UtilSql.getValue(result, "previouscredit");
        objectReportGeneralLedgerData.previoustotal = UtilSql.getValue(result, "previoustotal");
        objectReportGeneralLedgerData.finaldebit = UtilSql.getValue(result, "finaldebit");
        objectReportGeneralLedgerData.finalcredit = UtilSql.getValue(result, "finalcredit");
        objectReportGeneralLedgerData.finaltotal = UtilSql.getValue(result, "finaltotal");
        objectReportGeneralLedgerData.dateacctnumber = UtilSql.getValue(result, "dateacctnumber");
        objectReportGeneralLedgerData.groupby = UtilSql.getValue(result, "groupby");
        objectReportGeneralLedgerData.bpid = UtilSql.getValue(result, "bpid");
        objectReportGeneralLedgerData.bpname = UtilSql.getValue(result, "bpname");
        objectReportGeneralLedgerData.pdid = UtilSql.getValue(result, "pdid");
        objectReportGeneralLedgerData.pdname = UtilSql.getValue(result, "pdname");
        objectReportGeneralLedgerData.pjid = UtilSql.getValue(result, "pjid");
        objectReportGeneralLedgerData.pjname = UtilSql.getValue(result, "pjname");
        objectReportGeneralLedgerData.factaccttype = UtilSql.getValue(result, "factaccttype");
        objectReportGeneralLedgerData.amtacctdrprevsum = UtilSql.getValue(result, "amtacctdrprevsum");
        objectReportGeneralLedgerData.amtacctcrprevsum = UtilSql.getValue(result, "amtacctcrprevsum");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
      return objectReportGeneralLedgerData;
  }

  public static ReportGeneralLedgerData[] select2sum(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, String factAcctId, String accountId2)    throws ServletException {
    return select2sum(connectionProvider, rownum, groupbytext, groupby, allaccounts, accountFrom, accountTo, adUserOrg, adUserClient, acctschema, parDateFrom2, parDateTo2, org, cBpartnerId, mProductId, cProjectId, paramAmtFrom, paramAmtTo, accountId, cBPartner, pgLimit, oraLimit1, oraLimit2, factAcctId, accountId2, 0, 0);
  }

  public static ReportGeneralLedgerData[] select2sum(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, String factAcctId, String accountId2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Coalesce(SUM(S.amtacctdr), 0) AS AMTACCTDR," +
      "               Coalesce(SUM(S.amtacctcr), 0) AS AMTACCTCR" +
      "        FROM (" +
      "          SELECT *" +
      "          FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C.* FROM (" +
      "            SELECT VALUE, NAME, DATEACCT," +
      "                COALESCE(SUM(AMTACCTDR),0) AS AMTACCTDR, COALESCE(SUM(AMTACCTCR),0) AS AMTACCTCR, COALESCE(SUM(AMTACCTDR-AMTACCTCR),0) AS TOTAL," +
      "                MAX(FACT_ACCT_ID) AS FACT_ACCT_ID," +
      "                FACT_ACCT_GROUP_ID, ID, groupbyid, groupbyname," +
      "                DESCRIPTION, ISDEBIT," +
      "                0 AS TOTALACCTDR, 0 AS TOTALACCTCR, 0 AS TOTALACCTSUB," +
      "                0 AS PREVIOUSDEBIT, 0 AS PREVIOUSCREDIT, 0 AS PREVIOUSTOTAL," +
      "                0 AS FINALDEBIT, 0 AS FINALCREDIT, 0 AS FINALTOTAL," +
      "                TO_CHAR(DATEACCT,'J') AS DATEACCTNUMBER," +
      "                ? AS groupby, '' as bpid, '' as bpname, '' as pdid, '' as pdname, '' as pjid, '' as pjname, factaccttype" +
      "                , 0 AS AMTACCTDRPREVSUM, 0 AS AMTACCTCRPREVSUM" +
      "            FROM" +
      "              (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "                  DATEACCT, AMTACCTDR, AMTACCTCR, FACT_ACCT_ID," +
      "                  FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "                  CASE ?" +
      "                    WHEN 'BPartner' THEN c_bpartner.c_bpartner_id" +
      "                    WHEN 'Product' THEN m_product.m_product_id" +
      "                    WHEN 'Project' THEN c_project.c_project_id" +
      "                    ELSE '' END AS groupbyid," +
      "                  CASE ?" +
      "                    WHEN 'BPartner' THEN (select to_char(name) from c_bpartner b where b.c_bpartner_id = c_bpartner.c_bpartner_id)" +
      "                    WHEN 'Product' THEN (select to_char(value || ' - ' || name) from m_product p where p.m_product_id = m_product.m_product_id)" +
      "                    WHEN 'Project' THEN (select to_char(name) from c_project pj where pj.c_project_id = c_project.c_project_id)" +
      "                    ELSE '' END AS groupbyname," +
      "                  CASE WHEN (AMTACCTDR > 0 AND AMTACCTCR = 0) OR (AMTACCTCR < 0 AND AMTACCTDR = 0) THEN 'Y' ELSE 'N' END AS ISDEBIT," +
      "          CASE WHEN FACT_ACCT.FACTACCTTYPE = 'O' THEN 1 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'N' THEN 2 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'R' THEN 3 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'C' THEN 4 END) END) END) END AS FACTACCTTYPE" +
      "              FROM FACT_ACCT" +
      "                LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "              WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                        SELECT c_elementvalue_id as name" +
      "                        FROM C_ELEMENTVALUE" +
      "                        WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                          and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                          and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                      ))" +
      "                AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "                AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "                AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "                AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "              WHERE 6=6";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":" AND ID = ?  ");
    strSql = strSql + ((cBPartner==null || cBPartner.equals(""))?"":" AND groupbyid = ?  ");
    strSql = strSql + 
      "              GROUP BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "              DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, DESCRIPTION, ISDEBIT" +
      "              HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "              ORDER  BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "              DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID,  FACT_ACCT_ID, DESCRIPTION, ISDEBIT";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "            ) C";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "          ) B WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + ((factAcctId==null || factAcctId.equals(""))?"":"  and to_char(DATEACCT,'J')||FACTACCTTYPE||FACT_ACCT_GROUP_ID||FACT_ACCT_ID < ?  ");
    strSql = strSql + 
      ") S" +
      "        WHERE S.id = ?";

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupbytext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
      }
      if (accountId != null && !(accountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      }
      if (cBPartner != null && !(cBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartner);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }
      if (factAcctId != null && !(factAcctId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId2);

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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData[] select2Total(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, String factAcctId)    throws ServletException {
    return select2Total(connectionProvider, rownum, groupbytext, groupby, allaccounts, accountFrom, accountTo, adUserOrg, adUserClient, acctschema, parDateFrom2, parDateTo2, org, cBpartnerId, mProductId, cProjectId, paramAmtFrom, paramAmtTo, accountId, cBPartner, pgLimit, oraLimit1, oraLimit2, factAcctId, 0, 0);
  }

  public static ReportGeneralLedgerData[] select2Total(ConnectionProvider connectionProvider, String rownum, String groupbytext, String groupby, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, String accountId, String cBPartner, String pgLimit, String oraLimit1, String oraLimit2, String factAcctId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(SUM(AMTACCTDR),0) AS AMTACCTDR, COALESCE(SUM(AMTACCTCR),0) AS AMTACCTCR" +
      "        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C.* FROM (" +
      "          SELECT VALUE, NAME, DATEACCT," +
      "          COALESCE(SUM(AMTACCTDR),0) AS AMTACCTDR, COALESCE(SUM(AMTACCTCR),0) AS AMTACCTCR," +
      "              COALESCE(SUM(AMTACCTDR-AMTACCTCR),0) AS TOTAL," +
      "              MAX(FACT_ACCT_ID) AS FACT_ACCT_ID," +
      "              FACT_ACCT_GROUP_ID, ID, groupbyid, groupbyname," +
      "              DESCRIPTION, ISDEBIT," +
      "              0 AS TOTALACCTDR, 0 AS TOTALACCTCR, 0 AS TOTALACCTSUB," +
      "              0 AS PREVIOUSDEBIT, 0 AS PREVIOUSCREDIT, 0 AS PREVIOUSTOTAL," +
      "              0 AS FINALDEBIT, 0 AS FINALCREDIT, 0 AS FINALTOTAL," +
      "              TO_CHAR(DATEACCT,'J') AS DATEACCTNUMBER," +
      "              ? AS groupby, '' as bpid, '' as bpname, '' as pdid, '' as pdname, '' as pjid, '' as pjname, factaccttype" +
      "          FROM" +
      "            (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "                DATEACCT, AMTACCTDR, AMTACCTCR, FACT_ACCT_ID," +
      "                FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN c_bpartner.c_bpartner_id" +
      "                  WHEN 'Product' THEN m_product.m_product_id" +
      "                  WHEN 'Project' THEN c_project.c_project_id" +
      "                  ELSE '' END AS groupbyid," +
      "                CASE ?" +
      "                  WHEN 'BPartner' THEN (select to_char(name) from c_bpartner b where b.c_bpartner_id = c_bpartner.c_bpartner_id)" +
      "                  WHEN 'Product' THEN (select to_char(value || ' - ' || name) from m_product p where p.m_product_id = m_product.m_product_id)" +
      "                  WHEN 'Project' THEN (select to_char(value || ' - ' || name) from c_project pj where pj.c_project_id = c_project.c_project_id)" +
      "                  ELSE '' END AS groupbyname," +
      "                CASE WHEN (AMTACCTDR > 0 AND AMTACCTCR = 0) OR (AMTACCTCR < 0 AND AMTACCTDR = 0) THEN 'Y' ELSE 'N' END AS ISDEBIT," +
      "        CASE WHEN FACT_ACCT.FACTACCTTYPE = 'O' THEN 1 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'N' THEN 2 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'R' THEN 3 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'C' THEN 4 END) END) END) END AS FACTACCTTYPE" +
      "            FROM FACT_ACCT" +
      "              LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "              LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "            WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                      SELECT c_elementvalue_id as name" +
      "                      FROM C_ELEMENTVALUE" +
      "                      WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                        and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                    ))" +
      "              AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "              AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "              AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "              AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "              AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "              AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "            WHERE 6=6";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":" AND ID = ?  ");
    strSql = strSql + ((cBPartner==null || cBPartner.equals(""))?"":" AND groupbyid = ?  ");
    strSql = strSql + 
      "            GROUP BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "            DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, DESCRIPTION, ISDEBIT" +
      "            HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "            ORDER  BY groupbyname, groupbyid, VALUE, NAME, ID," +
      "            DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID,  FACT_ACCT_ID, DESCRIPTION, ISDEBIT";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "          ) C";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "        ) B WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + ((factAcctId==null || factAcctId.equals(""))?"":"  and to_char(DATEACCT,'J')||FACTACCTTYPE||FACT_ACCT_GROUP_ID||FACT_ACCT_ID < ?  ");

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupbytext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
      }
      if (accountId != null && !(accountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      }
      if (cBPartner != null && !(cBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartner);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }
      if (factAcctId != null && !(factAcctId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctId);
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData[] selectXLS(ConnectionProvider connectionProvider, String adLanguage, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo)    throws ServletException {
    return selectXLS(connectionProvider, adLanguage, parDateFrom, parDateTo, allaccounts, accountFrom, accountTo, adUserOrg, adUserClient, hideMatched, acctschema, parDateFrom2, parDateTo2, org, cBpartnerId, mProductId, cProjectId, paramAmtFrom, paramAmtTo, 0, 0);
  }

  public static ReportGeneralLedgerData[] selectXLS(ConnectionProvider connectionProvider, String adLanguage, String parDateFrom, String parDateTo, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String hideMatched, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE, NAME, DATEACCT," +
      "          SUM(AMTACCTDR) AS AMTACCTDR, SUM(AMTACCTCR) AS AMTACCTCR," +
      "          FACT_ACCT_GROUP_ID, ID, bpid, bpname, pdid, pdname, pjid, pjname," +
      "          DESCRIPTION, FACTACCTTYPE" +
      "      FROM" +
      "        (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "            DATEACCT, AMTACCTDR, AMTACCTCR," +
      "            FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "            c_bpartner.c_bpartner_id as bpid, m_product.m_product_id as pdid, c_project.c_project_id as pjid," +
      "            (case AD_COLUMN_IDENTIFIER('C_Bpartner',c_bpartner.c_bpartner_id, ?) when '**' then '' else AD_COLUMN_IDENTIFIER('C_Bpartner',c_bpartner.c_bpartner_id, ?) end) as bpname, (case AD_COLUMN_IDENTIFIER('M_Product',m_product.m_product_id, ?) when '**' then '' else AD_COLUMN_IDENTIFIER('M_Product',m_product.m_product_id, ?) end) as pdname, (case AD_COLUMN_IDENTIFIER('C_Project',c_project.c_project_id, ?) when '**' then '' else AD_COLUMN_IDENTIFIER('C_Project',c_project.c_project_id, ?) end)  as pjname," +
      "            CASE WHEN (AMTACCTDR > 0 AND AMTACCTCR = 0) OR (AMTACCTCR < 0 AND AMTACCTDR = 0) THEN 'Y' ELSE 'N' END AS ISDEBIT," +
      "            CASE WHEN FACT_ACCT.FACTACCTTYPE = 'O' THEN 1 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'N' THEN 2 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'R' THEN 3 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'C' THEN 4 END) END) END) END AS FACTACCTTYPE" +
      "        FROM FACT_ACCT" +
      "          LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "          LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "          LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "          LEFT JOIN(" +
      "              select account_id, record_id2, sum(amtacctdr-amtacctcr) as sum" +
      "              from fact_acct f1" +
      "              where 5=5";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "              group by account_id, record_id2" +
      "            ) f2 ON fact_acct.account_id = f2.account_id and fact_acct.record_id2 = f2.record_id2" +
      "        WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                ))" +
      "          AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND (? = 'N' OR (fact_acct.RECORD_ID2 IS NULL) OR (SUM != 0))" +
      "          AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "          AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "          AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "          AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "        WHERE 6=6" +
      "        GROUP BY VALUE, NAME, ID, FACTACCTTYPE, DATEACCT, FACT_ACCT_GROUP_ID, description, bpname, bpid, pdname, pdid, pjname, pjid, ISDEBIT" +
      "        HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "        ORDER BY VALUE, NAME, ID, DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, description,  bpname, bpid, pdname, pdid, pjname, pjid, ISDEBIT";

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hideMatched);
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.factAcctGroupId = UtilSql.getValue(result, "fact_acct_group_id");
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.bpid = UtilSql.getValue(result, "bpid");
        objectReportGeneralLedgerData.bpname = UtilSql.getValue(result, "bpname");
        objectReportGeneralLedgerData.pdid = UtilSql.getValue(result, "pdid");
        objectReportGeneralLedgerData.pdname = UtilSql.getValue(result, "pdname");
        objectReportGeneralLedgerData.pjid = UtilSql.getValue(result, "pjid");
        objectReportGeneralLedgerData.pjname = UtilSql.getValue(result, "pjname");
        objectReportGeneralLedgerData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerData.factaccttype = UtilSql.getValue(result, "factaccttype");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData selectXLS2(ConnectionProvider connectionProvider, String allaccounts, String accountFrom, String accountTo, String adUserOrg, String adUserClient, String dateBalanced, String acctschema, String parDateFrom2, String parDateTo2, String org, String cBpartnerId, String mProductId, String cProjectId, String paramAmtFrom, String paramAmtTo)    throws ServletException {
    ReportGeneralLedgerData instance = new ReportGeneralLedgerData();
    instance.scrollableGetter = "selectXLS2";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE, NAME, DATEACCT," +
      "          COALESCE(SUM(AMTACCTDR),0) AS AMTACCTDR, COALESCE(SUM(AMTACCTCR),0) AS AMTACCTCR," +
      "          FACT_ACCT_GROUP_ID, ID, bpid, bpname, pdid, pdname, pjid, pjname," +
      "          DESCRIPTION, FACTACCTTYPE" +
      "      FROM" +
      "        (SELECT FACT_ACCT.ACCTVALUE AS VALUE, FACT_ACCT.ACCTDESCRIPTION AS NAME," +
      "            DATEACCT, AMTACCTDR, AMTACCTCR," +
      "            FACT_ACCT_GROUP_ID, FACT_ACCT.ACCOUNT_ID AS ID, FACT_ACCT.DESCRIPTION," +
      "            c_bpartner.c_bpartner_id as bpid, m_product.m_product_id as pdid, c_project.c_project_id as pjid," +
      "            (select name from c_bpartner b where b.c_bpartner_id = c_bpartner.c_bpartner_id) as bpname, " +
      "            (select value || ' - ' || name from m_product p where p.m_product_id = m_product.m_product_id) as pdname, " +
      "            (select value || ' - ' || name from c_project pj where pj.c_project_id = c_project.c_project_id)  as pjname," +
      "            CASE WHEN (AMTACCTDR > 0 AND AMTACCTCR = 0) OR (AMTACCTCR < 0 AND AMTACCTDR = 0) THEN 'Y' ELSE 'N' END AS ISDEBIT," +
      "            CASE WHEN FACT_ACCT.FACTACCTTYPE = 'O' THEN 1 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'N' THEN 2 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'R' THEN 3 ELSE (CASE WHEN FACT_ACCT.FACTACCTTYPE = 'C' THEN 4 END) END) END) END AS FACTACCTTYPE" +
      "        FROM FACT_ACCT" +
      "          LEFT JOIN C_BPARTNER ON FACT_ACCT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "          LEFT JOIN M_PRODUCT ON FACT_ACCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "          LEFT JOIN C_PROJECT ON FACT_ACCT.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "        WHERE (?='Y' OR FACT_ACCT.ACCOUNT_ID IN (" +
      "                  SELECT c_elementvalue_id as name" +
      "                  FROM C_ELEMENTVALUE" +
      "                  WHERE value >= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and value <= (  select value from c_elementvalue where c_elementvalue_id = ?)" +
      "                    and c_elementvalue.ELEMENTLEVEL = 'S'" +
      "                ))" +
      "          AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          AND FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND 1=1";
    strSql = strSql + ((dateBalanced==null || dateBalanced.equals(""))?"":" AND (FACT_ACCT.DATEBALANCED IS NULL OR FACT_ACCT.DATEBALANCED > TO_DATE(?))  ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":" AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + ((parDateFrom2==null || parDateFrom2.equals(""))?"":" AND FACT_ACCT.DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo2==null || parDateTo2.equals(""))?"":" AND FACT_ACCT.DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "          AND  FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "          AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + cProjectId);
    strSql = strSql + 
      "          AND 3=3";
    strSql = strSql + ((paramAmtFrom==null || paramAmtFrom.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)>=TO_NUMBER(?)  ");
    strSql = strSql + ((paramAmtTo==null || paramAmtTo.equals(""))?"":"  AND (FACT_ACCT.AMTACCTDR + FACT_ACCT.AMTACCTCR)<=TO_NUMBER(?)  ");
    strSql = strSql + 
      ") D" +
      "        WHERE 6=6" +
      "        GROUP BY VALUE, NAME, ID, FACTACCTTYPE, DATEACCT, FACT_ACCT_GROUP_ID, description, bpname, bpid, pdname, pdid, pjname, pjid, ISDEBIT" +
      "        HAVING SUM(AMTACCTDR) - SUM(AMTACCTCR) <> 0" +
      "        ORDER BY VALUE, NAME, ID, DATEACCT, FACTACCTTYPE, FACT_ACCT_GROUP_ID, description,  bpname, bpid, pdname, pdid, pjname, pjid, ISDEBIT";

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allaccounts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountTo);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateBalanced != null && !(dateBalanced.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateBalanced);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (parDateFrom2 != null && !(parDateFrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom2);
      }
      if (parDateTo2 != null && !(parDateTo2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        }
      if (paramAmtFrom != null && !(paramAmtFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtFrom);
      }
      if (paramAmtTo != null && !(paramAmtTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramAmtTo);
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

  private ReportGeneralLedgerData getselectXLS2() throws SQLException {
    ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();

        objectReportGeneralLedgerData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerData.factAcctGroupId = UtilSql.getValue(result, "fact_acct_group_id");
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.bpid = UtilSql.getValue(result, "bpid");
        objectReportGeneralLedgerData.bpname = UtilSql.getValue(result, "bpname");
        objectReportGeneralLedgerData.pdid = UtilSql.getValue(result, "pdid");
        objectReportGeneralLedgerData.pdname = UtilSql.getValue(result, "pdname");
        objectReportGeneralLedgerData.pjid = UtilSql.getValue(result, "pjid");
        objectReportGeneralLedgerData.pjname = UtilSql.getValue(result, "pjname");
        objectReportGeneralLedgerData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerData.factaccttype = UtilSql.getValue(result, "factaccttype");
        objectReportGeneralLedgerData.rownum = Long.toString(countRecord);
      return objectReportGeneralLedgerData;
  }

  public static ReportGeneralLedgerData[] set()    throws ServletException {
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[1];
    objectReportGeneralLedgerData[0] = new ReportGeneralLedgerData();
    objectReportGeneralLedgerData[0].value = "";
    objectReportGeneralLedgerData[0].name = "";
    objectReportGeneralLedgerData[0].dateacct = "";
    objectReportGeneralLedgerData[0].amtacctdr = "";
    objectReportGeneralLedgerData[0].amtacctcr = "";
    objectReportGeneralLedgerData[0].factAcctGroupId = "";
    objectReportGeneralLedgerData[0].id = "";
    objectReportGeneralLedgerData[0].bpid = "";
    objectReportGeneralLedgerData[0].bpname = "";
    objectReportGeneralLedgerData[0].pdid = "";
    objectReportGeneralLedgerData[0].pdname = "";
    objectReportGeneralLedgerData[0].pjid = "";
    objectReportGeneralLedgerData[0].pjname = "";
    objectReportGeneralLedgerData[0].description = "";
    objectReportGeneralLedgerData[0].factaccttype = "";
    return objectReportGeneralLedgerData;
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

  public static String selectOrganization(ConnectionProvider connectionProvider, String org)    throws ServletException {
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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

  public static ReportGeneralLedgerData[] selectTotal(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String bpartner, String bpartnerNULL, String product, String productNULL, String project, String projectNULL, String acctschema, String account, String initialYearBalance, String dateTo2, String orgs, String hideMatched)    throws ServletException {
    return selectTotal(connectionProvider, dateFrom, dateTo, bpartner, bpartnerNULL, product, productNULL, project, projectNULL, acctschema, account, initialYearBalance, dateTo2, orgs, hideMatched, 0, 0);
  }

  public static ReportGeneralLedgerData[] selectTotal(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String bpartner, String bpartnerNULL, String product, String productNULL, String project, String projectNULL, String acctschema, String account, String initialYearBalance, String dateTo2, String orgs, String hideMatched, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM(AMTACCTDR),0) AS TOTALACCTDR, COALESCE(SUM(AMTACCTCR),0) AS TOTALACCTCR," +
      "      COALESCE(SUM(AMTACCTDR-AMTACCTCR),0) AS TOTAL" +
      "      FROM FACT_ACCT" +
      "      LEFT JOIN(" +
      "        select account_id, record_id2, sum(amtacctdr-amtacctcr) as sum" +
      "        from fact_acct f1" +
      "        where 5=5";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND DATEACCT < TO_DATE(?)  ");
    strSql = strSql + 
      "        group by account_id, record_id2" +
      "      ) f2 ON fact_acct.account_id = f2.account_id and fact_acct.record_id2 = f2.record_id2" +
      "      WHERE 1=1";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + bpartner);
    strSql = strSql + ((bpartnerNULL==null || bpartnerNULL.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IS NULL" + bpartnerNULL);
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + product);
    strSql = strSql + ((productNULL==null || productNULL.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IS NULL" + productNULL);
    strSql = strSql + ((project==null || project.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + project);
    strSql = strSql + ((projectNULL==null || projectNULL.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IS NULL" + projectNULL);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + 
      "      AND FACT_ACCT.ACCOUNT_ID = ?" +
      "      AND DATEACCT >= TO_DATE(?)" +
      "      AND DATEACCT < TO_DATE(?)" +
      "      AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((orgs==null || orgs.equals(""))?"":orgs);
    strSql = strSql + 
      ")" +
      "      AND (? = 'N' OR ((fact_acct.RECORD_ID2 IS NULL) OR (DATEACCT < TO_DATE(?)) OR (SUM != 0)))";

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (bpartner != null && !(bpartner.equals(""))) {
        }
      if (bpartnerNULL != null && !(bpartnerNULL.equals(""))) {
        }
      if (product != null && !(product.equals(""))) {
        }
      if (productNULL != null && !(productNULL.equals(""))) {
        }
      if (project != null && !(project.equals(""))) {
        }
      if (projectNULL != null && !(projectNULL.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, account);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, initialYearBalance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo2);
      if (orgs != null && !(orgs.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hideMatched);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);

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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.totalacctdr = UtilSql.getValue(result, "totalacctdr");
        objectReportGeneralLedgerData.totalacctcr = UtilSql.getValue(result, "totalacctcr");
        objectReportGeneralLedgerData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static ReportGeneralLedgerData[] selectTotal2(ConnectionProvider connectionProvider, String bpartner, String bpartnerNULL, String product, String productNULL, String project, String projectNULL, String acctschema, String account, String dateFrom, String dateTo2, String orgs)    throws ServletException {
    return selectTotal2(connectionProvider, bpartner, bpartnerNULL, product, productNULL, project, projectNULL, acctschema, account, dateFrom, dateTo2, orgs, 0, 0);
  }

  public static ReportGeneralLedgerData[] selectTotal2(ConnectionProvider connectionProvider, String bpartner, String bpartnerNULL, String product, String productNULL, String project, String projectNULL, String acctschema, String account, String dateFrom, String dateTo2, String orgs, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(SUM(AMTACCTDR),0) AS TOTALACCTDR, COALESCE(SUM(AMTACCTCR),0) AS TOTALACCTCR," +
      "      COALESCE(SUM(AMTACCTDR-AMTACCTCR),0) AS TOTAL" +
      "      FROM FACT_ACCT" +
      "      WHERE 1=1";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IN" + bpartner);
    strSql = strSql + ((bpartnerNULL==null || bpartnerNULL.equals(""))?"":"  AND FACT_ACCT.C_BPARTNER_ID IS NULL" + bpartnerNULL);
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IN" + product);
    strSql = strSql + ((productNULL==null || productNULL.equals(""))?"":"  AND FACT_ACCT.M_PRODUCT_ID IS NULL" + productNULL);
    strSql = strSql + ((project==null || project.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IN" + project);
    strSql = strSql + ((projectNULL==null || projectNULL.equals(""))?"":"  AND FACT_ACCT.C_PROJECT_ID IS NULL" + projectNULL);
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND FACT_ACCT.C_ACCTSCHEMA_ID = ?  ");
    strSql = strSql + 
      "      AND FACT_ACCT.ACCOUNT_ID = ?";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + 
      "      AND DATEACCT < TO_DATE(?)" +
      "      AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((orgs==null || orgs.equals(""))?"":orgs);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (bpartner != null && !(bpartner.equals(""))) {
        }
      if (bpartnerNULL != null && !(bpartnerNULL.equals(""))) {
        }
      if (product != null && !(product.equals(""))) {
        }
      if (productNULL != null && !(productNULL.equals(""))) {
        }
      if (project != null && !(project.equals(""))) {
        }
      if (projectNULL != null && !(projectNULL.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, account);
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo2);
      if (orgs != null && !(orgs.equals(""))) {
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.totalacctdr = UtilSql.getValue(result, "totalacctdr");
        objectReportGeneralLedgerData.totalacctcr = UtilSql.getValue(result, "totalacctcr");
        objectReportGeneralLedgerData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }

  public static String yearInitialDate(ConnectionProvider connectionProvider, String dateTemplate, String date, String client, String orgs)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TO_CHAR(MAX(INI),?) AS STARTDATE" +
      "      FROM" +
      "        (" +
      "        SELECT MIN(P.STARTDATE) AS INI" +
      "        FROM C_YEAR Y, C_PERIOD P, C_PERIODCONTROL PC" +
      "        WHERE Y.C_YEAR_ID = P.C_YEAR_ID" +
      "          AND P.C_PERIOD_ID = PC.C_PERIOD_ID" +
      "          AND P.STARTDATE <= TO_DATE(?)" +
      "          AND PC.AD_CLIENT_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "          AND PC.AD_ORG_ID IN (";
    strSql = strSql + ((orgs==null || orgs.equals(""))?"":orgs);
    strSql = strSql + 
      ")" +
      "        GROUP BY Y.YEAR" +
      "        ) PERIOD";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      if (client != null && !(client.equals(""))) {
        }
      if (orgs != null && !(orgs.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "startdate");
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

  public static String selectSubaccountDescription(ConnectionProvider connectionProvider, String elementValueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(TO_CHAR(NAME),TO_CHAR(''))" +
      "      FROM C_ELEMENTVALUE" +
      "      WHERE C_ELEMENTVALUE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementValueId);

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

  public static ReportGeneralLedgerData[] getFinancialOrgs(ConnectionProvider connectionProvider, String adTreeId, String adOrgId, String adClientId)    throws ServletException {
    return getFinancialOrgs(connectionProvider, adTreeId, adOrgId, adClientId, 0, 0);
  }

  public static ReportGeneralLedgerData[] getFinancialOrgs(ConnectionProvider connectionProvider, String adTreeId, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     	SELECT NODE_ID AS ID" +
      "	FROM AD_TREENODE" +
      "	WHERE AD_TREE_ID = ?" +
      "	AND (AD_ISORGINCLUDED(?, NODE_ID, ?) <> -1" +
      "	  OR AD_ISORGINCLUDED(NODE_ID, ?, ?) <> -1)";

    ResultSet result;
    Vector<ReportGeneralLedgerData> vector = new Vector<ReportGeneralLedgerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        ReportGeneralLedgerData objectReportGeneralLedgerData = new ReportGeneralLedgerData();
        objectReportGeneralLedgerData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerData);
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
    ReportGeneralLedgerData objectReportGeneralLedgerData[] = new ReportGeneralLedgerData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerData);
    return(objectReportGeneralLedgerData);
  }
}
