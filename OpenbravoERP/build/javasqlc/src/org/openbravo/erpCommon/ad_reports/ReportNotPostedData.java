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

/**
Class ReportNotPostedData
 */
class ReportNotPostedData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportNotPostedData.class);
  private String InitRecordNumber="0";
  public String documentno;
  public String dateacct;
  public String description;
  public String amount;
  public String doctype;
  public String id;
  public String tabId;
  public String docbasetype;
  public String recordId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("doctype"))
      return doctype;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("tab_id") || fieldName.equals("tabId"))
      return tabId;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for relation
 */
  public static ReportNotPostedData[] select(ConnectionProvider connectionProvider, String adLanguage, String client, String parDateFrom, String parDateTo)    throws ServletException {
    return select(connectionProvider, adLanguage, client, parDateFrom, parDateTo, 0, 0);
  }

/**
Select for relation
 */
  public static ReportNotPostedData[] select(ConnectionProvider connectionProvider, String adLanguage, String client, String parDateFrom, String parDateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select documentno, dateacct, substr(ad_column_identifier(tablename, id, ?) ||(CASE WHEN description IS NULL THEN '' ELSE ' (' || DESCRIPTION || ')' END),0,90) as description, " +
      "        GRANDTOTAL as amount, document as doctype, id as id, tab_id, docbasetype, record_id" +
      "        from" +
      "        (select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'C_Bpartner' as tablename, C_bpartner_id as id, GRANDTOTAL," +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=c_invoice.c_doctype_id " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Sales Invoices') as document, '263' as tab_id, (select docbasetype from c_doctype where c_doctype_id=c_invoice.c_doctype_id) as docbasetype," +
      "        c_invoice_id as record_id " +
      "        from c_invoice" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and issotrx = 'Y'" +
      "        and docstatus <> 'VO'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='318' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'M_InOut' as tablename, m_inout_id as id, 0 as GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=m_inout.c_doctype_id " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Goods Shipments') as document, '257' as tab_id, (select docbasetype from c_doctype where c_doctype_id=m_inout.c_doctype_id) as docbasetype," +
      "        m_inout_id as record_id" +
      "        from m_inout" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and issotrx = 'Y'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='319' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'M_InOut' as tablename, m_inout_id as id, 0 as GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=m_inout.c_doctype_id " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Goods Receipts') as document, '296' as tab_id, (select docbasetype from c_doctype where c_doctype_id=m_inout.c_doctype_id) as docbasetype," +
      "        m_inout_id as record_id" +
      "        from m_inout" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and issotrx = 'N'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='319' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'C_Bpartner' as tablename, C_bpartner_id as id, GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=c_invoice.c_doctype_id " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'Purchase Invoices') as document, '290' as tab_id, (select docbasetype from c_doctype where c_doctype_id=c_invoice.c_doctype_id) as docbasetype," +
      "        c_invoice_id as record_id" +
      "        from c_invoice" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and issotrx = 'N'" +
      "        and docstatus <> 'VO'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='318' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(name) AS DOCUMENTNO, dateacct, 'C_Cash' as tablename, C_Cash_id as id, c_cash.STATEMENTDIFFERENCE, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=? " +
      "            and docbasetype='CMC') " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Cash Journal') as document, '338' as tab_id, 'CMC' as docbasetype," +
      "        c_cash_id as record_id" +
      "        from C_Cash" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='407' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(name) AS DOCUMENTNO, statementdate, 'C_Bankstatement' as tablename, C_bankstatement_id as id, STATEMENTDIFFERENCE, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='CMB') " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'Bank Statements') as document, '328' as tab_id, 'CMB' as docbasetype," +
      "        c_bankstatement_id as record_id" +
      "        from c_bankstatement" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='392' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'C_Settlement' as tablename, C_Settlement_id as id, generatedamt, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=s.c_doctype_id " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'Manual Settlements') as document, '800029' as tab_id, 'STM' as docbasetype," +
      "        c_Settlement_id as record_id" +
      "        from c_Settlement s" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and settlementtype = 'I'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='800019' and ad_client_id=?)" +
      "        and exists (select 1" +
      "                    from c_debt_payment p" +
      "                    where p.c_settlement_generate_id = s.c_settlement_id" +
      "                    and p.isdirectposting='Y')" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'C_Settlement' as tablename, C_Settlement_id as id, generatedamt, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=c_Settlement.c_doctype_id " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'Settlements') as document, '800025' as tab_id, 'STT' as docbasetype," +
      "        c_Settlement_id as record_id" +
      "        from c_Settlement" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and settlementtype <> 'I'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='800019' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct, 'GL_Journal' as tablename, GL_Journal_id as id, totaldr, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=GL_Journal.c_doctype_id " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'GL Journal') as document, '160' as tab_id, (select docbasetype from c_doctype where c_doctype_id=GL_Journal.c_doctype_id) as docbasetype," +
      "        GL_Journal_id as record_id" +
      "        from GL_Journal" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='224' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(name) AS DOCUMENTNO, movementdate , 'M_INVENTORY' as tablename, m_inventory_id as id, 0 as GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='MMI') " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Physical Inventory') as document, '255' as tab_id, 'MMI' as docbasetype," +
      "        m_inventory_id as record_id" +
      "        from m_inventory" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='321' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, paymentdate , 'C_Bpartner' as tablename, c_bpartner_id as id, amount as GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=? " +
      "            and docbasetype='ARR') " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Payment In') as document, 'C4B6506838E14A349D6717D6856F1B56' as tab_id, 'ARR' as docbasetype," +
      "        fin_payment_id as record_id" +
      "        from fin_payment" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and isreceipt='Y'" +
      "        and status <> 'RPVOID'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='D1A97202E832470285C9B1EB026D54E2' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, paymentdate , 'C_Bpartner', c_bpartner_id as id, amount as GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='APP') and ad_language=? " +
      "        and ad_client_id=?)), 'Payment Out') as document, 'F7A52FDAAA0346EFA07D53C125B40404' as tab_id, 'APP' as docbasetype," +
      "        fin_payment_id as record_id" +
      "        from fin_payment" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and isreceipt='N'" +
      "        and status <> 'RPVOID'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='D1A97202E832470285C9B1EB026D54E2' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, 'Line: ' || to_char(line) AS DOCUMENTNO, " +
      "        dateacct, 'FIN_FINANCIAL_ACCOUNT' as tablename, fin_financial_account_id as id, depositamt-paymentamt as GRANDTOTAL, " +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='FAT') " +
      "        and ad_language=? " +
      "        and ad_client_id=?)), 'Financial Account Transaction') as document, '23691259D1BD4496BCC5F32645BCA4B9' as tab_id, 'FAT' as docbasetype," +
      "        fin_finacc_transaction_id as record_id" +
      "        from fin_finacc_transaction" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='4D8C3B3C31D1410DA046140C9F024D17' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, statementdate, 'FIN_FINANCIAL_ACCOUNT' as talename, fin_financial_account_id as id, endingbalance - startingbalance as GRANDTOTAL, " +
      "        ''  as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='REC') " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'RECONCILIATION') as document, 'C095D2CC39704DBE8B906B7CD7710968' as tab_id, 'REC' as docbasetype," +
      "        fin_reconciliation_id as record_id" +
      "        from fin_reconciliation" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='B1B7075C46934F0A9FD4C4D0F1457B42' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(name) AS DOCUMENTNO, movementdate , 'M_MOVEMENT' as tablename, m_movement_id as id, 0 as GRANDTOTAL," +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='MMM') " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'Goods Movement')  as document, '259' as tab_id, 'MMM' as docbasetype," +
      "        m_movement_id as record_id" +
      "        from m_movement" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='323' and ad_client_id=?)" +
      "        union all" +
      "        select ad_client_id, TO_CHAR(documentno) AS DOCUMENTNO, dateacct , 'C_DP_MANAGEMENT' as tablename, c_dp_management_id as id, 0 as GRANDTOTAL," +
      "        to_char(description) as description,  " +
      "        coalesce(to_char((select printname " +
      "        from c_doctype_trl " +
      "        where c_doctype_id=(select min(c_doctype_id) " +
      "            from c_doctype " +
      "            where ad_client_id=?" +
      "            and docbasetype='DPM') " +
      "        and ad_language=?" +
      "        and ad_client_id=?)), 'Debt Payment Management')  as document, '800209' as tab_id, 'DPM' as docbasetype," +
      "        c_dp_management_id as record_id" +
      "        from c_dp_management" +
      "        where processed = 'Y'" +
      "        and posted not in ('Y', 'D', 'T')" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='800176' and ad_client_id=?)" +
      "        ) AAA" +
      "        where ad_client_id = ?" +
      "        and 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT <= TO_DATE(?)  ");
    strSql = strSql + 
      "        order by  document, dateacct, description";

    ResultSet result;
    Vector<ReportNotPostedData> vector = new Vector<ReportNotPostedData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
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
        ReportNotPostedData objectReportNotPostedData = new ReportNotPostedData();
        objectReportNotPostedData.documentno = UtilSql.getValue(result, "documentno");
        objectReportNotPostedData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportNotPostedData.description = UtilSql.getValue(result, "description");
        objectReportNotPostedData.amount = UtilSql.getValue(result, "amount");
        objectReportNotPostedData.doctype = UtilSql.getValue(result, "doctype");
        objectReportNotPostedData.id = UtilSql.getValue(result, "id");
        objectReportNotPostedData.tabId = UtilSql.getValue(result, "tab_id");
        objectReportNotPostedData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectReportNotPostedData.recordId = UtilSql.getValue(result, "record_id");
        objectReportNotPostedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportNotPostedData);
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
    ReportNotPostedData objectReportNotPostedData[] = new ReportNotPostedData[vector.size()];
    vector.copyInto(objectReportNotPostedData);
    return(objectReportNotPostedData);
  }
}
