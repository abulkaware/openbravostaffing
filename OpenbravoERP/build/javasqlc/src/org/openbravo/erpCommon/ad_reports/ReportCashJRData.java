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

class ReportCashJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportCashJRData.class);
  private String InitRecordNumber="0";
  public String cCashbookId;
  public String namecashbook;
  public String statementdate;
  public String cCashId;
  public String namecash;
  public String beginningbalance;
  public String endingbalance;
  public String currency;
  public String line;
  public String name;
  public String amount;
  public String description;
  public String initialbalance;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_cashbook_id") || fieldName.equals("cCashbookId"))
      return cCashbookId;
    else if (fieldName.equalsIgnoreCase("namecashbook"))
      return namecashbook;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("c_cash_id") || fieldName.equals("cCashId"))
      return cCashId;
    else if (fieldName.equalsIgnoreCase("namecash"))
      return namecash;
    else if (fieldName.equalsIgnoreCase("beginningbalance"))
      return beginningbalance;
    else if (fieldName.equalsIgnoreCase("endingbalance"))
      return endingbalance;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("initialbalance"))
      return initialbalance;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportCashJRData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String parDateFrom, String cashBook, String parDateTo)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserClient, adUserOrg, parDateFrom, cashBook, parDateTo, 0, 0);
  }

  public static ReportCashJRData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String parDateFrom, String cashBook, String parDateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_CASHBOOK.C_CASHBOOK_ID, C_CASHBOOK.NAME AS NAMECASHBOOK, C_CASH.STATEMENTDATE, C_CASH.C_CASH_ID, C_CASH.NAME AS NAMECASH, " +
      "             C_CASH.BEGINNINGBALANCE, C_CASH.ENDINGBALANCE,  C_CURRENCY.ISO_CODE AS CURRENCY," +
      "             C_CASHLINE.LINE, COALESCE(AD_REF_LIST_TRL.NAME,AD_REF_LIST.NAME) AS NAME, C_CASHLINE.AMOUNT, C_CASHLINE.DESCRIPTION," +
      "             COALESCE (INITIALBALANCE.TOTAL_AMT,0) AS INITIALBALANCE" +
      "      FROM C_CASHBOOK" +
      "      		 LEFT JOIN " +
      "             (" +
      "		      SELECT SUM(CL.AMOUNT) AS TOTAL_AMT, C.C_CASHBOOK_ID" +
      "		      FROM C_CASHBOOK C, C_CASH CH, C_CASHLINE CL, C_CURRENCY CUR, AD_REF_LIST LIST " +
      "					     LEFT JOIN AD_REF_LIST_TRL LIST_T ON LIST.AD_REF_LIST_ID=LIST_T.AD_REF_LIST_ID" +
      "		      		 					 								 AND LIST_T.AD_LANGUAGE = ?" +
      "		      WHERE C.C_CASHBOOK_ID=CH.C_CASHBOOK_ID" +
      "		      AND CH.C_CASH_ID=CL.C_CASH_ID" +
      "		      AND C.C_CURRENCY_ID=CUR.C_CURRENCY_ID" +
      "		      AND CL.CASHTYPE=LIST.VALUE" +
      "		      AND AD_REFERENCE_ID='217'" +
      "		      AND CH.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "		      AND CH.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "		      AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND CH.STATEMENTDATE < TO_DATE(?) ");
    strSql = strSql + ((cashBook==null || cashBook.equals(""))?"":" AND C.C_CASHBOOK_ID = ? ");
    strSql = strSql + 
      "		      AND CH.PROCESSED='Y'" +
      "		      GROUP BY C.C_CASHBOOK_ID" +
      "             ) INITIALBALANCE ON INITIALBALANCE.C_CASHBOOK_ID = C_CASHBOOK.C_CASHBOOK_ID," +
      "             C_CASH, C_CASHLINE, C_CURRENCY, AD_REF_LIST " +
      "			     LEFT JOIN AD_REF_LIST_TRL ON AD_REF_LIST.AD_REF_LIST_ID=AD_REF_LIST_TRL.AD_REF_LIST_ID" +
      "      		 					 								 AND AD_REF_LIST_TRL.AD_LANGUAGE = ?" +
      "      WHERE C_CASHBOOK.C_CASHBOOK_ID=C_CASH.C_CASHBOOK_ID" +
      "      AND C_CASH.C_CASH_ID=C_CASHLINE.C_CASH_ID" +
      "      AND C_CASHBOOK.C_CURRENCY_ID=C_CURRENCY.C_CURRENCY_ID" +
      "      AND C_CASHLINE.CASHTYPE=AD_REF_LIST.VALUE" +
      "      AND AD_REFERENCE_ID='217'" +
      "      AND C_CASH.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND C_CASH.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND 2=2";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND C_CASH.STATEMENTDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND C_CASH.STATEMENTDATE < TO_DATE(?) ");
    strSql = strSql + ((cashBook==null || cashBook.equals(""))?"":" AND C_CASHBOOK.C_CASHBOOK_ID = ? ");
    strSql = strSql + 
      "      AND C_CASH.PROCESSED='Y'" +
      "      ORDER BY NAMECASHBOOK, STATEMENTDATE, C_CASH_ID, C_CASHLINE.LINE";

    ResultSet result;
    Vector<ReportCashJRData> vector = new Vector<ReportCashJRData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (cashBook != null && !(cashBook.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
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
      if (cashBook != null && !(cashBook.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cashBook);
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
        ReportCashJRData objectReportCashJRData = new ReportCashJRData();
        objectReportCashJRData.cCashbookId = UtilSql.getValue(result, "c_cashbook_id");
        objectReportCashJRData.namecashbook = UtilSql.getValue(result, "namecashbook");
        objectReportCashJRData.statementdate = UtilSql.getDateValue(result, "statementdate", "dd-MM-yyyy");
        objectReportCashJRData.cCashId = UtilSql.getValue(result, "c_cash_id");
        objectReportCashJRData.namecash = UtilSql.getValue(result, "namecash");
        objectReportCashJRData.beginningbalance = UtilSql.getValue(result, "beginningbalance");
        objectReportCashJRData.endingbalance = UtilSql.getValue(result, "endingbalance");
        objectReportCashJRData.currency = UtilSql.getValue(result, "currency");
        objectReportCashJRData.line = UtilSql.getValue(result, "line");
        objectReportCashJRData.name = UtilSql.getValue(result, "name");
        objectReportCashJRData.amount = UtilSql.getValue(result, "amount");
        objectReportCashJRData.description = UtilSql.getValue(result, "description");
        objectReportCashJRData.initialbalance = UtilSql.getValue(result, "initialbalance");
        objectReportCashJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportCashJRData);
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
    ReportCashJRData objectReportCashJRData[] = new ReportCashJRData[vector.size()];
    vector.copyInto(objectReportCashJRData);
    return(objectReportCashJRData);
  }
}
