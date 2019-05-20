//Sqlc generated V1.O00-1
package org.openbravo.common.actionhandler;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CashflowForecastData implements FieldProvider {
static Logger log4j = Logger.getLogger(CashflowForecastData.class);
  private String InitRecordNumber="0";
  public String finFinancialAccountId;
  public String name;
  public String currentbalance;
  public String accountno;
  public String isreceipt;
  public String incomeorpaymentmessage;
  public String duedate;
  public String dateinvoiced;
  public String invoiceno;
  public String cInvoiceId;
  public String finPaymentId;
  public String paymentDesc;
  public String paymentno;
  public String bpname;
  public String finFinaccTransactionId;
  public String originalamount;
  public String convertedamount;
  public String trxcur;
  public String facur;
  public String initialbalance;
  public String finPaymentScheduleId;
  public String finalsummary;
  public String income;
  public String payment;
  public String financialaccount;
  public String amount;
  public String stylepay;
  public String styleinv;
  public String styletrx;
  public String tabtoopen;
  public String recordid;
  public String transDescrip;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fin_financial_account_id") || fieldName.equals("finFinancialAccountId"))
      return finFinancialAccountId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("currentbalance"))
      return currentbalance;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("incomeorpaymentmessage"))
      return incomeorpaymentmessage;
    else if (fieldName.equalsIgnoreCase("duedate"))
      return duedate;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("invoiceno"))
      return invoiceno;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("payment_desc") || fieldName.equals("paymentDesc"))
      return paymentDesc;
    else if (fieldName.equalsIgnoreCase("paymentno"))
      return paymentno;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("fin_finacc_transaction_id") || fieldName.equals("finFinaccTransactionId"))
      return finFinaccTransactionId;
    else if (fieldName.equalsIgnoreCase("originalamount"))
      return originalamount;
    else if (fieldName.equalsIgnoreCase("convertedamount"))
      return convertedamount;
    else if (fieldName.equalsIgnoreCase("trxcur"))
      return trxcur;
    else if (fieldName.equalsIgnoreCase("facur"))
      return facur;
    else if (fieldName.equalsIgnoreCase("initialbalance"))
      return initialbalance;
    else if (fieldName.equalsIgnoreCase("fin_payment_schedule_id") || fieldName.equals("finPaymentScheduleId"))
      return finPaymentScheduleId;
    else if (fieldName.equalsIgnoreCase("finalsummary"))
      return finalsummary;
    else if (fieldName.equalsIgnoreCase("income"))
      return income;
    else if (fieldName.equalsIgnoreCase("payment"))
      return payment;
    else if (fieldName.equalsIgnoreCase("financialaccount"))
      return financialaccount;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("stylepay"))
      return stylepay;
    else if (fieldName.equalsIgnoreCase("styleinv"))
      return styleinv;
    else if (fieldName.equalsIgnoreCase("styletrx"))
      return styletrx;
    else if (fieldName.equalsIgnoreCase("tabtoopen"))
      return tabtoopen;
    else if (fieldName.equalsIgnoreCase("recordid"))
      return recordid;
    else if (fieldName.equalsIgnoreCase("trans_descrip") || fieldName.equals("transDescrip"))
      return transDescrip;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CashflowForecastData[] selectLines(ConnectionProvider connectionProvider, String language, String financialAccountId, String datePlanned, String orderByClause)    throws ServletException {
    return selectLines(connectionProvider, language, financialAccountId, datePlanned, orderByClause, 0, 0);
  }

  public static CashflowForecastData[] selectLines(ConnectionProvider connectionProvider, String language, String financialAccountId, String datePlanned, String orderByClause, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT fa.fin_financial_account_id, fa.name, null as currentbalance, fa.accountno," +
      "       COALESCE(coalesce(case when fat.fin_finacc_transaction_id is null then null " +
      "                         else case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end end, p.isreceipt), i.issotrx) as isreceipt," +
      "       COALESCE(mt.msgtext, m.msgtext) as incomeorpaymentmessage," +
      "       COALESCE(coalesce(fat.statementdate, p.paymentdate), psinv.duedate) as duedate," +
      "       i.dateinvoiced as dateinvoiced, i.documentno as invoiceno, i.c_invoice_id," +
      "       p.fin_payment_id, p.documentno || '  ' || p.description as payment_desc, p.documentno as paymentno," +
      "       bp.name as bpname, fat.fin_finacc_transaction_id," +
      "       case trxcur.c_currency_id when facur.c_currency_id then null else" +
      "         case COALESCE(coalesce(case when fat.fin_finacc_transaction_id is null then null else case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end end, p.isreceipt), i.issotrx)" +
      "                                when 'Y' then psd.amount else -1 * psd.amount end end as originalAmount," +
      "       C_convert_doc_currency(case COALESCE(coalesce(case when fat.fin_finacc_transaction_id is null then null else case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end end, p.isreceipt), i.issotrx)" +
      "                          when 'Y' then" +
      "                            psd.amount" +
      "                          else" +
      "                            -1 * psd.amount" +
      "                          end," +
      "           coalesce(coalesce(fat.foreign_currency_id, p.c_currency_id), i.c_currency_id), fa.c_currency_id," +
      "           COALESCE(coalesce(fat.statementdate, p.paymentdate), psinv.duedate)," +
      "           i.c_invoice_id, p.fin_payment_id, fat.fin_finacc_transaction_id, psd.ad_client_id, psd.ad_org_id) as convertedAmount," +
      "       case trxcur.c_currency_id when facur.c_currency_id then null else" +
      "       trxcur.iso_code end as trxcur, facur.iso_code as facur, null as initialbalance," +
      "       psinv.fin_payment_schedule_id as fin_payment_schedule_id," +
      "       null as finalsummary, null as income, null as payment," +
      "       ad_column_identifier('FIN_Financial_Account', fa.fin_financial_account_id, ?)  as financialaccount," +
      "       null as amount," +
      "       case when p.fin_payment_id is null then 'display:none' else '' end as stylePay," +
      "       case when i.c_invoice_id is null then 'display:none' else '' end as styleInv," +
      "       case when fat.fin_finacc_transaction_id is null then 'display:none' else '' end as styleTrx," +
      "       case when fat.fin_finacc_transaction_id is null then" +
      "         case when p.fin_payment_id is null then 'InvoicePlan' else 'PaymentLine' end" +
      "       else 'TransactionLine' end as tabToOpen," +
      "       coalesce(fat.fin_finacc_transaction_id,coalesce(psd.FIN_PAYMENT_SCHEDULE_INVOICE, psinv.fin_payment_schedule_id)) as recordId," +
      "       fat.description as trans_descrip" +
      "      FROM fin_payment_scheduledetail psd" +
      "       left join fin_payment_detail pd on psd.fin_payment_detail_id = pd.fin_payment_detail_id" +
      "       left join fin_payment p on pd.fin_payment_id = p.fin_payment_id" +
      "       left join fin_payment_schedule psinv on psd.fin_payment_schedule_invoice = psinv.fin_payment_schedule_id" +
      "       left join c_invoice i on psinv.c_invoice_id = i.c_invoice_id" +
      "       left join c_bpartner bp on coalesce(p.c_bpartner_id, i.c_bpartner_id) = bp.c_bpartner_id" +
      "       left join fin_financial_account fa on fa.fin_financial_account_id = coalesce(p.fin_financial_account_id, case i.issotrx when 'Y' then bp.fin_financial_account_id when 'N' then bp.po_financial_account_id else null end)" +
      "       left join fin_finacc_transaction fat on fat.fin_payment_id=p.fin_payment_id" +
      "       left join c_currency trxcur on trxcur.c_currency_id = coalesce(coalesce(fat.foreign_currency_id, p.c_currency_id), i.c_currency_id)" +
      "       left join C_CURRENCY FACUR on FACUR.C_CURRENCY_ID = FA.C_CURRENCY_ID," +
      "       AD_MESSAGE M left join AD_MESSAGE_TRL MT on (M.AD_MESSAGE_ID = MT.AD_MESSAGE_ID and MT.AD_LANGUAGE = ?)" +
      "     where COALESCE(psd.fin_payment_detail_id, psd.fin_payment_schedule_invoice) is not null" +
      "       and psd.iscanceled='N'" +
      "       and (i.isactive is null or i.isactive = 'Y')" +
      "       and (fat.isactive is null or fat.isactive = 'Y')" +
      "       and (trxcur.isactive is null or trxcur.isactive = 'Y')" +
      "       and (facur.isactive is null or facur.isactive = 'Y')" +
      "       AND fa.fin_financial_account_id = ?" +
      "       AND 1=1";
    strSql = strSql + ((datePlanned==null || datePlanned.equals(""))?"":"  AND COALESCE(coalesce(fat.statementdate, p.paymentdate), psinv.duedate) <= to_date(?)  ");
    strSql = strSql + 
      "       and m.value = (case COALESCE(coalesce(case when fat.fin_finacc_transaction_id is null then null else case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end end, p.isreceipt), i.issotrx)" +
      "                      when 'Y' then 'Income' else 'Payment' end)" +
      "       and (fat.fin_finacc_transaction_id is null" +
      "            or fat.statementdate>now())" +
      "     group by psd.ad_client_id, psd.ad_org_id, fa.fin_financial_account_id, fa.name, fa.accountno, fa.c_currency_id," +
      "       COALESCE(coalesce(case when fat.fin_finacc_transaction_id is null then null " +
      "                         else case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end end, p.isreceipt), i.issotrx)," +
      "       COALESCE(mt.msgtext, m.msgtext), COALESCE(coalesce(fat.statementdate, p.paymentdate), psinv.duedate)," +
      "       i.dateinvoiced, i.documentno, i.c_invoice_id, i.c_currency_id, p.fin_payment_id, p.description, p.documentno, p.c_currency_id, coalesce(coalesce(fat.foreign_currency_id, p.c_currency_id), i.c_currency_id)," +
      "       bp.name, fat.fin_finacc_transaction_id, fat.depositamt," +
      "       case COALESCE(coalesce(case when fat.fin_finacc_transaction_id is null then null else case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end end, p.isreceipt), i.issotrx) when 'Y' then psd.amount else -1 * psd.amount end," +
      "       psinv.fin_payment_schedule_id, psd.FIN_PAYMENT_SCHEDULE_INVOICE, trxcur.c_currency_id, facur.c_currency_id, pd.fin_payment_detail_id, trxcur.iso_code," +
      "       facur.iso_code, fat.description" +
      "    union all" +
      "      select fat.fin_financial_account_id, fa.name as name, null as currentbalance, null as accountno," +
      "        case when fat.depositamt-fat.paymentamt < 0 then 'N' else 'Y' end as isreceipt," +
      "        COALESCE(mt.msgtext, m.msgtext) as incomeorpaymentmessage," +
      "        fat.statementdate as duedate," +
      "        null as dateinvoiced, null as invoiceno, null as c_invoice_id," +
      "        null as fin_payment_id, null as payment_desc, null as paymentno," +
      "        bp.name as bpname, fat.fin_finacc_transaction_id," +
      "        null as originalAmount," +
      "        fat.depositamt-fat.paymentamt as convertedAmount," +
      "         null as trxcur, facur.iso_code as facur," +
      "        null as initialbalance," +
      "        null as fin_payment_schedule_id," +
      "        null as finalsummary, null as income, null as payment," +
      "        ad_column_identifier('FIN_Financial_Account', fa.fin_financial_account_id, ?)  as financialaccount," +
      "        null as amount," +
      "        'display:none' as stylePay, 'display:none' as styleInv, '' as styleTrx," +
      "        'TransactionLine' as tabToOpen, fat.fin_finacc_transaction_id as recordId," +
      "       fat.description as trans_descrip" +
      "      from fin_finacc_transaction fat" +
      "        left join fin_financial_account fa on fat.fin_financial_account_id = fa.fin_financial_account_id" +
      "        left join c_bpartner bp on fat.c_bpartner_id = bp.c_bpartner_id" +
      "        left join c_currency fatcur on fatcur.c_currency_id = fat.foreign_currency_id" +
      "        left join C_CURRENCY facur on FACUR.C_CURRENCY_ID = FA.C_CURRENCY_ID," +
      "        AD_MESSAGE M left join AD_MESSAGE_TRL MT on (M.AD_MESSAGE_ID = MT.AD_MESSAGE_ID and MT.AD_LANGUAGE = ?)" +
      "      where fat.fin_financial_account_id = ?" +
      "        and (fat.isactive is null or fat.isactive='Y')" +
      "        and (fa.isactive is null or fa.isactive='Y')" +
      "        and (facur.isactive is null or facur.isactive='Y')" +
      "        and (fatcur.isactive is null or fatcur.isactive='Y')" +
      "        and m.value = (case when fat.depositamt-fat.paymentamt < 0 then 'Payment' else 'Income' end)" +
      "        and fat.fin_payment_id is null" +
      "        and 2=2";
    strSql = strSql + ((datePlanned==null || datePlanned.equals(""))?"":"  and (fat.statementdate > now() and fat.statementdate <= to_date(?))  ");
    strSql = strSql + 
      "      order by name, fin_financial_account_id";
    strSql = strSql + ((orderByClause==null || orderByClause.equals(""))?"":orderByClause);

    ResultSet result;
    Vector<CashflowForecastData> vector = new Vector<CashflowForecastData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, financialAccountId);
      if (datePlanned != null && !(datePlanned.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlanned);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, financialAccountId);
      if (datePlanned != null && !(datePlanned.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlanned);
      }
      if (orderByClause != null && !(orderByClause.equals(""))) {
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
        CashflowForecastData objectCashflowForecastData = new CashflowForecastData();
        objectCashflowForecastData.finFinancialAccountId = UtilSql.getValue(result, "fin_financial_account_id");
        objectCashflowForecastData.name = UtilSql.getValue(result, "name");
        objectCashflowForecastData.currentbalance = UtilSql.getValue(result, "currentbalance");
        objectCashflowForecastData.accountno = UtilSql.getValue(result, "accountno");
        objectCashflowForecastData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectCashflowForecastData.incomeorpaymentmessage = UtilSql.getValue(result, "incomeorpaymentmessage");
        objectCashflowForecastData.duedate = UtilSql.getDateValue(result, "duedate", "dd-MM-yyyy");
        objectCashflowForecastData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectCashflowForecastData.invoiceno = UtilSql.getValue(result, "invoiceno");
        objectCashflowForecastData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCashflowForecastData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectCashflowForecastData.paymentDesc = UtilSql.getValue(result, "payment_desc");
        objectCashflowForecastData.paymentno = UtilSql.getValue(result, "paymentno");
        objectCashflowForecastData.bpname = UtilSql.getValue(result, "bpname");
        objectCashflowForecastData.finFinaccTransactionId = UtilSql.getValue(result, "fin_finacc_transaction_id");
        objectCashflowForecastData.originalamount = UtilSql.getValue(result, "originalamount");
        objectCashflowForecastData.convertedamount = UtilSql.getValue(result, "convertedamount");
        objectCashflowForecastData.trxcur = UtilSql.getValue(result, "trxcur");
        objectCashflowForecastData.facur = UtilSql.getValue(result, "facur");
        objectCashflowForecastData.initialbalance = UtilSql.getValue(result, "initialbalance");
        objectCashflowForecastData.finPaymentScheduleId = UtilSql.getValue(result, "fin_payment_schedule_id");
        objectCashflowForecastData.finalsummary = UtilSql.getValue(result, "finalsummary");
        objectCashflowForecastData.income = UtilSql.getValue(result, "income");
        objectCashflowForecastData.payment = UtilSql.getValue(result, "payment");
        objectCashflowForecastData.financialaccount = UtilSql.getValue(result, "financialaccount");
        objectCashflowForecastData.amount = UtilSql.getValue(result, "amount");
        objectCashflowForecastData.stylepay = UtilSql.getValue(result, "stylepay");
        objectCashflowForecastData.styleinv = UtilSql.getValue(result, "styleinv");
        objectCashflowForecastData.styletrx = UtilSql.getValue(result, "styletrx");
        objectCashflowForecastData.tabtoopen = UtilSql.getValue(result, "tabtoopen");
        objectCashflowForecastData.recordid = UtilSql.getValue(result, "recordid");
        objectCashflowForecastData.transDescrip = UtilSql.getValue(result, "trans_descrip");
        objectCashflowForecastData.rownum = Long.toString(countRecord);
        objectCashflowForecastData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCashflowForecastData);
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
    CashflowForecastData objectCashflowForecastData[] = new CashflowForecastData[vector.size()];
    vector.copyInto(objectCashflowForecastData);
    return(objectCashflowForecastData);
  }

  public static CashflowForecastData[] selectSummary(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String financialAccountId, String datePlanned)    throws ServletException {
    return selectSummary(connectionProvider, language, adUserClient, adUserOrg, financialAccountId, datePlanned, 0, 0);
  }

  public static CashflowForecastData[] selectSummary(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String financialAccountId, String datePlanned, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select fa.fin_financial_account_id, ad_column_identifier('FIN_Financial_Account', fa.fin_financial_account_id, ?)  as financialaccount," +
      "               fa.currentbalance-sum(fat.depositamt-fat.paymentamt) as initialbalance" +
      "        from fin_finacc_transaction fat left join fin_financial_account fa on fa.fin_financial_account_id=fat.fin_financial_account_id" +
      "        where fat.statementdate > now()" +
      "          and fa.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          and fa.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          and fa.isactive='Y'" +
      "          AND 2=2";
    strSql = strSql + ((financialAccountId==null || financialAccountId.equals(""))?"":"  AND fa.fin_financial_account_id = ?  ");
    strSql = strSql + ((datePlanned==null || datePlanned.equals(""))?"":"  AND fat.statementdate <= TO_DATE(?)  ");
    strSql = strSql + 
      "        group by fa.fin_financial_account_id, fa.name, fa.accountno, fa.currentbalance" +
      "        union all" +
      "        select fa.fin_financial_account_id, ad_column_identifier('FIN_Financial_Account', fa.fin_financial_account_id, ?)  as financialaccount," +
      "               fa.currentbalance as initialbalance" +
      "        from fin_financial_account fa" +
      "        where fa.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          and  fa.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          and fa.isactive='Y'" +
      "          AND 3=3";
    strSql = strSql + ((financialAccountId==null || financialAccountId.equals(""))?"":"  AND fa.fin_financial_account_id = ?  ");
    strSql = strSql + 
      "          and not exists" +
      "        ( select 1" +
      "          from fin_finacc_transaction fat" +
      "          where fat.statementdate > now()" +
      "            and 4=4";
    strSql = strSql + ((datePlanned==null || datePlanned.equals(""))?"":"  AND fat.statementdate <= TO_DATE(?)  ");
    strSql = strSql + 
      "            and fat.fin_financial_account_id = fa.fin_financial_account_id" +
      "        )";

    ResultSet result;
    Vector<CashflowForecastData> vector = new Vector<CashflowForecastData>(0);
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
      if (financialAccountId != null && !(financialAccountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, financialAccountId);
      }
      if (datePlanned != null && !(datePlanned.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlanned);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (financialAccountId != null && !(financialAccountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, financialAccountId);
      }
      if (datePlanned != null && !(datePlanned.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlanned);
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
        CashflowForecastData objectCashflowForecastData = new CashflowForecastData();
        objectCashflowForecastData.finFinancialAccountId = UtilSql.getValue(result, "fin_financial_account_id");
        objectCashflowForecastData.financialaccount = UtilSql.getValue(result, "financialaccount");
        objectCashflowForecastData.initialbalance = UtilSql.getValue(result, "initialbalance");
        objectCashflowForecastData.rownum = Long.toString(countRecord);
        objectCashflowForecastData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCashflowForecastData);
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
    CashflowForecastData objectCashflowForecastData[] = new CashflowForecastData[vector.size()];
    vector.copyInto(objectCashflowForecastData);
    return(objectCashflowForecastData);
  }

  public static CashflowForecastData[] set()    throws ServletException {
    CashflowForecastData objectCashflowForecastData[] = new CashflowForecastData[1];
    objectCashflowForecastData[0] = new CashflowForecastData();
    objectCashflowForecastData[0].finFinancialAccountId = "";
    objectCashflowForecastData[0].financialaccount = "";
    objectCashflowForecastData[0].initialbalance = "";
    return objectCashflowForecastData;
  }
}
