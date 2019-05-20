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

class ReportDebtPaymentTrackData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportDebtPaymentTrackData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String tipo;
  public String doctype;
  public String documentno;
  public String name;
  public String datetrx;
  public String description;
  public String amount;
  public String dateplanned;
  public String obs;
  public String bpAmt;
  public String ppaAmt;
  public String amtDocBp;
  public String amtDocPpa;
  public String url;
  public String id;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("tipo"))
      return tipo;
    else if (fieldName.equalsIgnoreCase("doctype"))
      return doctype;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("datetrx"))
      return datetrx;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("obs"))
      return obs;
    else if (fieldName.equalsIgnoreCase("bp_amt") || fieldName.equals("bpAmt"))
      return bpAmt;
    else if (fieldName.equalsIgnoreCase("ppa_amt") || fieldName.equals("ppaAmt"))
      return ppaAmt;
    else if (fieldName.equalsIgnoreCase("amt_doc_bp") || fieldName.equals("amtDocBp"))
      return amtDocBp;
    else if (fieldName.equalsIgnoreCase("amt_doc_ppa") || fieldName.equals("amtDocPpa"))
      return amtDocPpa;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportDebtPaymentTrackData[] select(ConnectionProvider connectionProvider, String rownum, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String moreThan, String lessThan, String docTypes, String oraLimit1, String oraLimit2, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adLanguage, adUserClient, adUserOrg, cBpartnerId, dateFrom, dateTo, moreThan, lessThan, docTypes, oraLimit1, oraLimit2, pgLimit, 0, 0);
  }

  public static ReportDebtPaymentTrackData[] select(ConnectionProvider connectionProvider, String rownum, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String moreThan, String lessThan, String docTypes, String oraLimit1, String oraLimit2, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT * FROM (" +
      "      SELECT *" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, C1.* FROM (" +
      "      select A.tipo, A.DocType, A.documentno, A.name, A.datetrx, replace(replace(A.description,chr(10),'|'),chr(13),'|') as description," +
      "      A.amount, A.dateplanned,replace(replace(A.obs,chr(10),'|'),chr(13),'|') as obs," +
      "      COALESCE(B.initialamount,0) as bp_amt, COALESCE(C.initialamount,0) as ppa_amt , A.amt_doc_bp, A.amt_doc_ppa, A.URL, A.ID" +
      "      from" +
      "        (select AD_MESSAGE_GET2('PTR_INVOICE', ?) as tipo, 'I' as DocType, i.documentno, bp.c_bpartner_id, bp.name, i.dateinvoiced as dateTrx, max(dp.description) as description, " +
      "        sum((CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END)) as amount, max(dp.dateplanned) as dateplanned, " +
      "        to_char(i.description) as obs, sum((CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END)) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        (CASE i.issotrx WHEN 'N' THEN '../PurchaseInvoice/Header_Relation.html?Command=DIRECT' ELSE '../SalesInvoice/Header_Relation.html?Command=DIRECT' END) as URL, 'inpcInvoiceId=' || i.c_invoice_id as id" +
      "        from c_debt_payment dp, c_invoice i, c_bpartner bp" +
      "        where dp.c_invoice_id = i.c_invoice_id" +
      "        AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "        group by i.documentno, bp.c_bpartner_id, bp.name, i.dateinvoiced, to_char(i.description), i.issotrx, i.c_invoice_id" +
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_MANUAL', ?), 'M' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        '../ManualSettlement/CreatePayment_Relation.html?Command=DIRECT' AS URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        AND DP.AD_Client_iD IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_Org_iD IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.ismanual='Y'" +
      "        and dp.isValid='Y'" +
      "        and 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_CP_UNPAID', ?), 'C' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        '../Settlement/CancelledPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        AND dP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND dP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='N'" +
      "        and 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_CP_PAID', ?), 'A' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_ppa," +
      "        '../Settlement/CancelledPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        AND Dp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Dp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='Y'" +
      "        and 4=4";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_GP_UNPAID',?), 'G' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        '../Settlement/CreatedPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        AND DP.aD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.aD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.generate_processed='Y'" +
      "        and ismanual='N'" +
      "        and (dp.isPaid='N' or dp.c_settlement_cancel_id is not null)" +
      "        and 5=5";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_GP_PAID', ?), 'J' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, 0 as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_ppa," +
      "        '../Settlement/CreatedPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        AND DP.Ad_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.Ad_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.generate_processed='Y'" +
      "        and dp.isPaid='Y' and dp.c_settlement_cancel_id is null" +
      "        and 6=6";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_RP_CASH', ?), 'K' as DocType, c.name as documentno, bp.c_bpartner_id, bp.name, c.dateacct as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        to_char(c.description) as obs, 0 as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_ppa," +
      "        '../CashJournal/Lines_Relation.html?Command=DIRECT' as URL, 'inpcCashlineId=' || cl.C_CASHLINE_ID as id" +
      "        from c_debt_payment dp, c_cash c, c_cashline cl, c_bpartner bp" +
      "        where dp.c_cashline_id = cl.c_cashline_id" +
      "        AND DP.AD_client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and cl.c_cash_id = c.c_cash_id" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and c.processed='Y'" +
      "        and 7=7";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_RP_BANK', ?), 'B' as DocType, b.name as documentno, bp.c_bpartner_id, bp.name, bl.dateacct as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        to_char(b.description) as obs, 0 as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_ppa," +
      "        '../BankStatement/Lines_Relation.html?Command=DIRECT' as URL, 'inpcBankstatementlineId=' || bl.C_BANKSTATEMENTLINE_ID as id" +
      "        from c_debt_payment dp, c_bankstatement b, c_bankstatementline bl, c_bpartner bp" +
      "        where dp.c_bankstatementline_id = bl.c_bankstatementline_id" +
      "        AND DP.AD_CLient_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORg_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and bl.c_bankstatement_id = b.c_bankstatement_id" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and b.processed='Y'" +
      "        and 8=8";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      ") A left join" +
      "(select c_bpartner_id, sum(amount) as initialamount from" +
      "        (select i.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_invoice i" +
      "        where dp.c_invoice_id = i.c_invoice_id" +
      "        and i.dateacct < TO_DATE(?)" +
      "        AND DP.AD_ClIent_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_OrG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        and dp.ismanual='Y'" +
      "        and dp.isValid='Y'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        and dp.generate_processed='Y'" +
      "        and ismanual='N'" +
      "        and (dp.isPaid='N' or dp.c_settlement_cancel_id is not null)" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND dP.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND dP.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all	" +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='N'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND Dp.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Dp.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='Y'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.aD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.aD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")) AAA" +
      "      group by c_bpartner_id) B on A.c_bpartner_id =B.c_bpartner_id" +
      "      left join" +
      "        (select c_bpartner_id, sum(amount) as initialamount from" +
      "        (select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='Y'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.Ad_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.Ad_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        and dp.generate_processed='Y'" +
      "        and dp.isPaid='Y' and dp.c_settlement_cancel_id is null" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.AD_cLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_oRG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all	" +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_cash c, c_cashline cl" +
      "        where dp.c_cashline_id = cl.c_cashline_id" +
      "        and cl.c_cash_id = c.c_cash_id" +
      "        and c.processed='Y'" +
      "        and c.dateacct < TO_DATE(?)" +
      "        AND DP.AD_ClIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_Org_id IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_bankstatement b, c_bankstatementline bl" +
      "        where dp.c_bankstatementline_id = bl.c_bankstatementline_id" +
      "        and bl.c_bankstatement_id = b.c_bankstatement_id" +
      "        and b.processed='Y'" +
      "        and bl.dateacct < TO_DATE(?)" +
      "        AND DP.AD_CLiENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORg_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        ) BBB" +
      "        group by c_bpartner_id) C on A.c_bpartner_id = C.c_bpartner_id" +
      "      WHERE A.datetrx >= TO_DATE(?)" +
      "      AND 9=9";
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  and A.datetrx < TO_DATE(?) ");
    strSql = strSql + ((moreThan==null || moreThan.equals(""))?"":"  and A.amount > TO_NUMBER(?) ");
    strSql = strSql + ((lessThan==null || lessThan.equals(""))?"":"  and A.amount < TO_NUMBER(?) ");
    strSql = strSql + 
      "      AND A.DocType in (";
    strSql = strSql + ((docTypes==null || docTypes.equals(""))?"":docTypes);
    strSql = strSql + 
      ")" +
      "      order by A.name, A.datetrx, A.documentno" +
      "     ) C1";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "    ) B WHERE 10=10";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":"  AND RN1 BETWEEN " + oraLimit2);
    strSql = strSql + 
      " AND 11=11";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":"  LIMIT " + pgLimit);
    strSql = strSql + 
      "   ) A";

    ResultSet result;
    Vector<ReportDebtPaymentTrackData> vector = new Vector<ReportDebtPaymentTrackData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (moreThan != null && !(moreThan.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, moreThan);
      }
      if (lessThan != null && !(lessThan.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, lessThan);
      }
      if (docTypes != null && !(docTypes.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        ReportDebtPaymentTrackData objectReportDebtPaymentTrackData = new ReportDebtPaymentTrackData();
        objectReportDebtPaymentTrackData.rn1 = UtilSql.getValue(result, "rn1");
        objectReportDebtPaymentTrackData.tipo = UtilSql.getValue(result, "tipo");
        objectReportDebtPaymentTrackData.doctype = UtilSql.getValue(result, "doctype");
        objectReportDebtPaymentTrackData.documentno = UtilSql.getValue(result, "documentno");
        objectReportDebtPaymentTrackData.name = UtilSql.getValue(result, "name");
        objectReportDebtPaymentTrackData.datetrx = UtilSql.getDateValue(result, "datetrx", "dd-MM-yyyy");
        objectReportDebtPaymentTrackData.description = UtilSql.getValue(result, "description");
        objectReportDebtPaymentTrackData.amount = UtilSql.getValue(result, "amount");
        objectReportDebtPaymentTrackData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportDebtPaymentTrackData.obs = UtilSql.getValue(result, "obs");
        objectReportDebtPaymentTrackData.bpAmt = UtilSql.getValue(result, "bp_amt");
        objectReportDebtPaymentTrackData.ppaAmt = UtilSql.getValue(result, "ppa_amt");
        objectReportDebtPaymentTrackData.amtDocBp = UtilSql.getValue(result, "amt_doc_bp");
        objectReportDebtPaymentTrackData.amtDocPpa = UtilSql.getValue(result, "amt_doc_ppa");
        objectReportDebtPaymentTrackData.url = UtilSql.getValue(result, "url");
        objectReportDebtPaymentTrackData.id = UtilSql.getValue(result, "id");
        objectReportDebtPaymentTrackData.rownum = Long.toString(countRecord);
        objectReportDebtPaymentTrackData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportDebtPaymentTrackData);
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
    ReportDebtPaymentTrackData objectReportDebtPaymentTrackData[] = new ReportDebtPaymentTrackData[vector.size()];
    vector.copyInto(objectReportDebtPaymentTrackData);
    return(objectReportDebtPaymentTrackData);
  }

  public static ReportDebtPaymentTrackData[] set()    throws ServletException {
    ReportDebtPaymentTrackData objectReportDebtPaymentTrackData[] = new ReportDebtPaymentTrackData[1];
    objectReportDebtPaymentTrackData[0] = new ReportDebtPaymentTrackData();
    objectReportDebtPaymentTrackData[0].rn1 = "";
    objectReportDebtPaymentTrackData[0].tipo = "";
    objectReportDebtPaymentTrackData[0].doctype = "";
    objectReportDebtPaymentTrackData[0].documentno = "";
    objectReportDebtPaymentTrackData[0].name = "";
    objectReportDebtPaymentTrackData[0].datetrx = "";
    objectReportDebtPaymentTrackData[0].description = "";
    objectReportDebtPaymentTrackData[0].amount = "";
    objectReportDebtPaymentTrackData[0].dateplanned = "";
    objectReportDebtPaymentTrackData[0].obs = "";
    objectReportDebtPaymentTrackData[0].bpAmt = "";
    objectReportDebtPaymentTrackData[0].ppaAmt = "";
    objectReportDebtPaymentTrackData[0].amtDocBp = "";
    objectReportDebtPaymentTrackData[0].amtDocPpa = "";
    objectReportDebtPaymentTrackData[0].url = "";
    objectReportDebtPaymentTrackData[0].id = "";
    return objectReportDebtPaymentTrackData;
  }

  public static String selectCount(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String moreThan, String lessThan, String docTypes)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select COUNT ( A.tipo || A.DocType || A.documentno || A.name || A.datetrx || A.amount || A.dateplanned " +
      "    || COALESCE(B.initialamount,0) || COALESCE(C.initialamount,0) || A.amt_doc_bp || A.amt_doc_ppa || A.URL || A.ID ) AS COUNT" +
      "      from" +
      "        (select AD_MESSAGE_GET2('PTR_INVOICE', ?) as tipo, 'I' as DocType, i.documentno, bp.c_bpartner_id, bp.name, i.dateinvoiced as dateTrx, max(dp.description) as description, " +
      "        sum((CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END)) as amount, max(dp.dateplanned) as dateplanned, " +
      "        to_char(i.description) as obs, sum((CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END)) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        (CASE i.issotrx WHEN 'N' THEN '../PurchaseInvoice/Header_Relation.html?Command=DIRECT' ELSE '../SalesInvoice/Header_Relation.html?Command=DIRECT' END) as URL, 'inpcInvoiceId=' || i.c_invoice_id as id" +
      "        from c_debt_payment dp, c_invoice i, c_bpartner bp" +
      "        where dp.c_invoice_id = i.c_invoice_id" +
      "        AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "        group by i.documentno, bp.c_bpartner_id, bp.name, i.dateinvoiced, to_char(i.description), i.issotrx, i.c_invoice_id" +
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_MANUAL', ?), 'M' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        '../ManualSettlement/CreatePayment_Relation.html?Command=DIRECT' AS URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        AND DP.AD_Client_iD IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_Org_iD IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.ismanual='Y'" +
      "        and dp.isValid='Y'" +
      "        and 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_CP_UNPAID', ?), 'C' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        '../Settlement/CancelledPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        AND dP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND dP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='N'" +
      "        and 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_CP_PAID', ?), 'A' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_ppa," +
      "        '../Settlement/CancelledPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        AND Dp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Dp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='Y'" +
      "        and 4=4";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_GP_UNPAID',?), 'G' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_bp, 0 as amt_doc_ppa," +
      "        '../Settlement/CreatedPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        AND DP.aD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.aD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.generate_processed='Y'" +
      "        and ismanual='N'" +
      "        and (dp.isPaid='N' or dp.c_settlement_cancel_id is not null)" +
      "        and 5=5";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_GP_PAID', ?), 'J' as DocType, s.documentno, bp.c_bpartner_id, bp.name, s.dateTrx as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        s.description as obs, 0 as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amt_doc_ppa," +
      "        '../Settlement/CreatedPayments_Relation.html?Command=DIRECT' as URL, 'inpcDebtPaymentId=' || dp.C_DEBT_PAYMENT_ID as id" +
      "        from c_debt_payment dp, c_settlement s, c_bpartner bp" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        AND DP.Ad_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.Ad_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and dp.generate_processed='Y'" +
      "        and dp.isPaid='Y' and dp.c_settlement_cancel_id is null" +
      "        and 6=6";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_RP_CASH', ?), 'K' as DocType, c.name as documentno, bp.c_bpartner_id, bp.name, c.dateacct as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        to_char(c.description) as obs, 0 as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_ppa," +
      "        '../CashJournal/Lines_Relation.html?Command=DIRECT' as URL, 'inpcCashlineId=' || cl.C_CASHLINE_ID as id" +
      "        from c_debt_payment dp, c_cash c, c_cashline cl, c_bpartner bp" +
      "        where dp.c_cashline_id = cl.c_cashline_id" +
      "        AND DP.AD_client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and cl.c_cash_id = c.c_cash_id" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and c.processed='Y'" +
      "        and 7=7";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      "      union all" +
      "        select AD_MESSAGE_GET2('PTR_RP_BANK', ?), 'B' as DocType, b.name as documentno, bp.c_bpartner_id, bp.name, bl.dateacct as dateTrx, dp.description, " +
      "        (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount, dp.dateplanned," +
      "        to_char(b.description) as obs, 0 as amt_doc_bp, (CASE dp.isreceipt WHEN 'Y' THEN -dp.amount ELSE dp.amount END) as amt_doc_ppa," +
      "        '../BankStatement/Lines_Relation.html?Command=DIRECT' as URL, 'inpcBankstatementlineId=' || bl.C_BANKSTATEMENTLINE_ID as id" +
      "        from c_debt_payment dp, c_bankstatement b, c_bankstatementline bl, c_bpartner bp" +
      "        where dp.c_bankstatementline_id = bl.c_bankstatementline_id" +
      "        AND DP.AD_CLient_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORg_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        and bl.c_bankstatement_id = b.c_bankstatement_id" +
      "        and dp.c_bpartner_id = bp.c_bpartner_id" +
      "        and b.processed='Y'" +
      "        and 8=8";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  and bp.c_bpartner_id in" + cBpartnerId);
    strSql = strSql + 
      ") A left join" +
      "(select c_bpartner_id, sum(amount) as initialamount from" +
      "        (select i.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_invoice i" +
      "        where dp.c_invoice_id = i.c_invoice_id" +
      "        and i.dateacct < TO_DATE(?)" +
      "        AND DP.AD_ClIent_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_OrG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        and dp.ismanual='Y'" +
      "        and dp.isValid='Y'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        and dp.generate_processed='Y'" +
      "        and ismanual='N'" +
      "        and (dp.isPaid='N' or dp.c_settlement_cancel_id is not null)" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND dP.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND dP.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all " +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='N'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND Dp.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND Dp.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='Y'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.aD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.aD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")) AAA" +
      "      group by c_bpartner_id) B on A.c_bpartner_id =B.c_bpartner_id" +
      "      left join" +
      "        (select c_bpartner_id, sum(amount) as initialamount from" +
      "        (select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_cancel_id = s.c_settlement_id" +
      "        and dp.cancel_processed='Y'" +
      "        and dp.isPaid='Y'" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.Ad_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.Ad_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, (CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_settlement s" +
      "        where dp.c_settlement_generate_id = s.c_settlement_id" +
      "        and dp.generate_processed='Y'" +
      "        and dp.isPaid='Y' and dp.c_settlement_cancel_id is null" +
      "        and s.dateacct < TO_DATE(?)" +
      "        AND DP.AD_cLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_oRG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all " +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_cash c, c_cashline cl" +
      "        where dp.c_cashline_id = cl.c_cashline_id" +
      "        and cl.c_cash_id = c.c_cash_id" +
      "        and c.processed='Y'" +
      "        and c.dateacct < TO_DATE(?)" +
      "        AND DP.AD_ClIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_Org_id IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      union all" +
      "        select dp.c_bpartner_id, -(CASE dp.isreceipt WHEN 'Y' THEN dp.amount ELSE -dp.amount END) as amount" +
      "        from c_debt_payment dp, c_bankstatement b, c_bankstatementline bl" +
      "        where dp.c_bankstatementline_id = bl.c_bankstatementline_id" +
      "        and bl.c_bankstatement_id = b.c_bankstatement_id" +
      "        and b.processed='Y'" +
      "        and bl.dateacct < TO_DATE(?)" +
      "        AND DP.AD_CLiENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DP.AD_ORg_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        ) BBB" +
      "        group by c_bpartner_id) C on A.c_bpartner_id = C.c_bpartner_id" +
      "      WHERE A.datetrx >= TO_DATE(?)" +
      "      AND 9=9";
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  and A.datetrx < TO_DATE(?) ");
    strSql = strSql + ((moreThan==null || moreThan.equals(""))?"":"  and A.amount > TO_NUMBER(?) ");
    strSql = strSql + ((lessThan==null || lessThan.equals(""))?"":"  and A.amount < TO_NUMBER(?) ");
    strSql = strSql + 
      "      AND A.DocType in (";
    strSql = strSql + ((docTypes==null || docTypes.equals(""))?"":docTypes);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = "0";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (moreThan != null && !(moreThan.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, moreThan);
      }
      if (lessThan != null && !(lessThan.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, lessThan);
      }
      if (docTypes != null && !(docTypes.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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
