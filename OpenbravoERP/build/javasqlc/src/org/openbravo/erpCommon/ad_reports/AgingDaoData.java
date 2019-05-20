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

class AgingDaoData implements FieldProvider, ScrollableFieldProvider {
static Logger log4j = Logger.getLogger(AgingDaoData.class);
  private String InitRecordNumber="0";
  public String bpid;
  public String bpname;
  public String amount;
  public String scope;
  public String credit;
  public String invoiceid;
  public String docno;
  public String dateinvoiced;
  public String doubtfuldebt;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("bpid"))
      return bpid;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("scope"))
      return scope;
    else if (fieldName.equalsIgnoreCase("credit"))
      return credit;
    else if (fieldName.equalsIgnoreCase("invoiceid"))
      return invoiceid;
    else if (fieldName.equalsIgnoreCase("docno"))
      return docno;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("doubtfuldebt"))
      return doubtfuldebt;
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
  public AgingDaoData get() throws ServletException {
    try {
      if ("select".equals(scrollableGetter)) {
        return getselect();
      } else if ("selectCredit".equals(scrollableGetter)) {
        return getselectCredit();
      } else if ("selectDetail".equals(scrollableGetter)) {
        return getselectDetail();
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


  public static AgingDaoData select(ConnectionProvider connectionProvider, String showDoubtfulDebt, String asOfDate, String currencyId, String firstRangeBucket, String secondRangeBucket, String thirdRangeBucket, String fourthRangeBucket, String org, String cbPartnerId, String recOrPay, String excludeVoids, String pgLimit, String oraLimit1)    throws ServletException {
    AgingDaoData instance = new AgingDaoData();
    instance.scrollableGetter = "select";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "         SELECT B.* FROM (" +
      "         SELECT A.bpId, bp.name as bpName, SUM(A.amount) as amount, A.scope, 0 as credit, '' as invoiceId, '' as docNo, '' as dateInvoiced, SUM(doubtfuldebtamt) as doubtfuldebt" +
      "         FROM ( " +
      "	             SELECT i.c_bpartner_id AS bpId, " +
      "	                    CASE " +
      "	                     WHEN to_char('Y') = ? AND psd.DOUBTFULDEBT_AMOUNT <> 0 AND FIN_AGING_ISDOUBTFULTDEBT(psd.fin_payment_schedule_invoice, TO_DATE(?)) = 'Y' THEN FIN_AGING_INVOICECURRENCY_RATE(i.c_invoice_id, ?, i.c_currency_id) * (psd.amount + psd.writeoffamt - psd.DOUBTFULDEBT_AMOUNT) " +
      "	                     ELSE FIN_AGING_INVOICECURRENCY_RATE(i.c_invoice_id, ?, i.c_currency_id) * (psd.amount + psd.writeoffamt) " +
      "	                    END                AS amount," +
      "	                    CASE " +
      "                         WHEN psd.DOUBTFULDEBT_AMOUNT <> 0 AND FIN_AGING_ISDOUBTFULTDEBT(psd.fin_payment_schedule_invoice, TO_DATE(?)) = 'Y' THEN FIN_AGING_INVOICECURRENCY_RATE(i.c_invoice_id, ?, i.c_currency_id) * (psd.DOUBTFULDEBT_AMOUNT) " +
      "                         ELSE 0" +
      "                        END                AS doubtfuldebtamt, " +
      "				        CASE " +
      "				         WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 0 " +
      "				         WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 1 " +
      "				         WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 2 " +
      "				         WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 3 " +
      "				         WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 4 " +
      "				         ELSE 5 " +
      "				        END                                                        AS scope" +
      "				 FROM  fin_payment_scheduledetail psd " +
      "				       INNER JOIN fin_payment_schedule ps ON psd.fin_payment_schedule_invoice = ps.fin_payment_schedule_id " +
      "				       INNER JOIN c_invoice            i  ON ps.c_invoice_id = i.c_invoice_id " +
      "				 WHERE psd.isactive = 'Y' " +
      "				   AND psd.iscanceled = 'N' " +
      "				   AND (psd.AD_Org_ID in (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")) " +
      "				   AND (i.AD_Org_ID in (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")) " +
      "				   AND 2=2";
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND i.C_BPARTNER_ID IN" + cbPartnerId);
    strSql = strSql + 
      "				   AND i.issotrx = ? " +
      "				   AND 1=1";
    strSql = strSql + ((excludeVoids.equals("excludeVoids"))?" AND i.DOCSTATUS NOT IN ('VO') ":"");
    strSql = strSql + 
      "				   AND Trunc(i.dateacct) <= TO_DATE(?)" +
      "				   AND (   psd.fin_payment_detail_id IS NULL " +
      "				        OR psd.isinvoicepaid = 'N' " +
      "				        OR (psd.isinvoicepaid = 'Y' " +
      "				            AND EXISTS (SELECT 1 " +
      "				                      FROM  fin_payment_detail pd " +
      "				                            INNER JOIN fin_payment p ON pd.fin_payment_id = p.fin_payment_id " +
      "				                      WHERE Trunc(p.paymentdate) > TO_DATE(?)" +
      "				                        AND pd.fin_payment_detail_id = psd.fin_payment_detail_id) ) ) " +
      "			  ) A " +
      "			   INNER JOIN c_bpartner bp on (A.bpId = bp.c_bpartner_id)" +
      "		GROUP BY A.bpId, bp.name, A.scope  " +
      "        ) B";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showDoubtfulDebt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstRangeBucket);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondRangeBucket);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, thirdRangeBucket);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fourthRangeBucket);
      if (org != null && !(org.equals(""))) {
        }
      if (org != null && !(org.equals(""))) {
        }
      if (cbPartnerId != null && !(cbPartnerId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recOrPay);
      if (excludeVoids != null && !(excludeVoids.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
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

  private AgingDaoData getselect() throws SQLException {
    AgingDaoData objectAgingDaoData = new AgingDaoData();

        objectAgingDaoData.bpid = UtilSql.getValue(result, "bpid");
        objectAgingDaoData.bpname = UtilSql.getValue(result, "bpname");
        objectAgingDaoData.amount = UtilSql.getValue(result, "amount");
        objectAgingDaoData.scope = UtilSql.getValue(result, "scope");
        objectAgingDaoData.credit = UtilSql.getValue(result, "credit");
        objectAgingDaoData.invoiceid = UtilSql.getValue(result, "invoiceid");
        objectAgingDaoData.docno = UtilSql.getValue(result, "docno");
        objectAgingDaoData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectAgingDaoData.doubtfuldebt = UtilSql.getValue(result, "doubtfuldebt");
        objectAgingDaoData.rownum = Long.toString(countRecord);
      return objectAgingDaoData;
  }

  public static AgingDaoData selectCredit(ConnectionProvider connectionProvider, String currencyId, String org, String paidStatus, String asOfDate, String recOrPay, String cbPartnerId, String pgLimit, String oraLimit1)    throws ServletException {
    AgingDaoData instance = new AgingDaoData();
    instance.scrollableGetter = "selectCredit";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "    SELECT B.* FROM (" +
      "    SELECT A.credit, bp.c_bpartner_id as bpId, bp.name as bpName, A.dateInvoiced as dateInvoiced, A.invoiceId as invoiceId, A.docNo" +
      "    FROM (" +
      "        SELECT FIN_AGING_PAYMENTCURRENCY_RATE(P.fin_payment_id, ?, P.c_currency_id) * SUM(P.GENERATED_CREDIT - coalesce(C.USED_CREDIT, 0)) AS credit, P.c_bpartner_id," +
      "               P.PAYMENTDATE as dateInvoiced, P.fin_payment_id as invoiceId, P.docNo" +
      "          FROM (" +
      "                SELECT fp.fin_payment_id                AS fin_payment_id," +
      "                       fp.GENERATED_CREDIT              AS GENERATED_CREDIT," +
      "                       fp.PAYMENTDATE                   AS PAYMENTDATE," +
      "                       fp.c_currency_id                 AS c_currency_id," +
      "                       fp.c_bpartner_id                 AS c_bpartner_id," +
      "                       CASE" +
      "                        WHEN fp.isreceipt = 'N' AND fp.referenceno IS NOT NULL THEN FIN_AGING_GETDOCNO(fp.referenceno, fp.documentNo, fp.ad_org_id)" +
      "                        ELSE fp.documentNo" +
      "                        END                             AS docNo" +
      "                FROM   fin_payment fp" +
      "                WHERE  (fp.AD_Org_ID in (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")) " +
      "                       AND (fp.status IN (";
    strSql = strSql + ((paidStatus==null || paidStatus.equals(""))?"":paidStatus);
    strSql = strSql + 
      "))" +
      "                       AND Trunc(fp.paymentdate) <= TO_DATE(?)" +
      "                       AND fp.isreceipt = ? " +
      "                       AND 1=1";
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND fp.C_BPARTNER_ID IN" + cbPartnerId);
    strSql = strSql + 
      "                       AND fp.generated_credit <> 0 " +
      "                       AND ( EXISTS (SELECT 1 " +
      "                                     FROM   fin_payment_scheduledetail fpsd " +
      "                                            INNER JOIN fin_payment_detail fpd ON fpsd.fin_payment_detail_id = fpd.fin_payment_detail_id " +
      "                                     WHERE  fpd.fin_payment_id = fp.fin_payment_id " +
      "                                            AND fpsd.isactive = 'Y' " +
      "                                            AND fpsd.iscanceled = 'N' " +
      "                                            AND fpsd.fin_payment_schedule_invoice IS NULL" +
      "                                     ) " +
      "                           )" +
      "                UNION" +
      "                SELECT fp2.fin_payment_id                AS fin_payment_id," +
      "                       fpsd.amount             AS GENERATED_CREDIT," +
      "                       fp2.PAYMENTDATE                   AS PAYMENTDATE," +
      "                       fp2.c_currency_id                 AS c_currency_id," +
      "                       fp2.c_bpartner_id                 AS c_bpartner_id," +
      "                       CASE" +
      "                        WHEN fp2.isreceipt = 'N' AND fp2.referenceno IS NOT NULL THEN FIN_AGING_GETDOCNO(fp2.referenceno, fp2.documentNo, fp2.ad_org_id)" +
      "                        ELSE fp2.documentNo" +
      "                        END                             AS docNo" +
      "                FROM   fin_payment_scheduledetail fpsd" +
      "                       INNER JOIN fin_payment_detail fpd ON fpsd.fin_payment_detail_id = fpd.fin_payment_detail_id" +
      "                       INNER JOIN fin_payment fp2 ON fpd.fin_payment_id = fp2.fin_payment_id" +
      "                WHERE  (fp2.AD_Org_ID in (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      "))" +
      "                       AND (fp2.status IN (";
    strSql = strSql + ((paidStatus==null || paidStatus.equals(""))?"":paidStatus);
    strSql = strSql + 
      "))" +
      "                       AND Trunc(fp2.paymentdate) <= TO_DATE(?)" +
      "                       AND fp2.isreceipt = ?" +
      "                       AND 2=2";
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND fp2.C_BPARTNER_ID IN" + cbPartnerId);
    strSql = strSql + 
      "                       AND fpsd.isactive = 'Y'" +
      "                       AND fpsd.iscanceled = 'N'" +
      "                       AND fpsd.fin_payment_schedule_invoice IS NULL" +
      "                       AND fpsd.fin_payment_schedule_order IS NOT NULL" +
      "                ) P " +
      "                LEFT JOIN " +
      "                (SELECT SUM(fpc.amount) AS USED_CREDIT," +
      "                         fpc.fin_payment_id_used  AS paymentUsedId" +
      "                  FROM   fin_payment_credit fpc " +
      "                  WHERE ( EXISTS (SELECT 1 " +
      "                                 FROM   fin_payment fp1 " +
      "                                        INNER JOIN fin_payment_detail fpd1 ON fp1.fin_payment_id = fpd1.fin_payment_id " +
      "                                        INNER JOIN fin_payment_scheduledetail fpsd1 ON fpd1.fin_payment_detail_id = fpsd1.fin_payment_detail_id " +
      "                                 WHERE  fpc.fin_payment_id = fp1.fin_payment_id " +
      "                                        AND Trunc(fp1.paymentdate) <= TO_DATE(?) " +
      "                                        AND ( (fpsd1.isinvoicepaid = 'Y' AND  fpsd1.fin_payment_schedule_invoice IS NOT NULL) " +
      "                                             OR ( fp1.status IN (";
    strSql = strSql + ((paidStatus==null || paidStatus.equals(""))?"":paidStatus);
    strSql = strSql + 
      ") " +
      "                                                 AND  fpsd1.fin_payment_schedule_invoice IS NULL)" +
      "                                            )" +
      "                                  ) " +
      "                        ) " +
      "                  GROUP BY fpc.fin_payment_id_used" +
      "                ) C ON P.fin_payment_id = C.paymentUsedId" +
      "          GROUP BY P.fin_payment_id, P.PAYMENTDATE, P.c_currency_id, P.c_bpartner_id, P.docNo" +
      "       ) A" +
      "      INNER JOIN c_bpartner bp ON A.c_bpartner_id = bp.c_bpartner_id" +
      "   WHERE A.credit <> 0" +
      "        ) B";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);
      if (org != null && !(org.equals(""))) {
        }
      if (paidStatus != null && !(paidStatus.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recOrPay);
      if (cbPartnerId != null && !(cbPartnerId.equals(""))) {
        }
      if (org != null && !(org.equals(""))) {
        }
      if (paidStatus != null && !(paidStatus.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recOrPay);
      if (cbPartnerId != null && !(cbPartnerId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      if (paidStatus != null && !(paidStatus.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
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

  private AgingDaoData getselectCredit() throws SQLException {
    AgingDaoData objectAgingDaoData = new AgingDaoData();

        objectAgingDaoData.credit = UtilSql.getValue(result, "credit");
        objectAgingDaoData.bpid = UtilSql.getValue(result, "bpid");
        objectAgingDaoData.bpname = UtilSql.getValue(result, "bpname");
        objectAgingDaoData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectAgingDaoData.invoiceid = UtilSql.getValue(result, "invoiceid");
        objectAgingDaoData.docno = UtilSql.getValue(result, "docno");
        objectAgingDaoData.rownum = Long.toString(countRecord);
      return objectAgingDaoData;
  }

  public static AgingDaoData selectDetail(ConnectionProvider connectionProvider, String currencyId, String showDoubtfulDebt, String asOfDate, String firstRangeBucket, String secondRangeBucket, String thirdRangeBucket, String fourthRangeBucket, String org, String cbPartnerId, String recOrPay, String excludeVoids, String pgLimit, String oraLimit1)    throws ServletException {
    AgingDaoData instance = new AgingDaoData();
    instance.scrollableGetter = "selectDetail";
    instance.internalConnProvider = connectionProvider;
    instance.errorOcurred = false;

    String strSql = "";
    strSql = strSql + 
      "           SELECT C.* FROM (" +
      "           SELECT B.bpId, bp.name as bpName, FIN_AGING_INVOICECURRENCY_RATE(B.c_invoice_id, ?, B.c_currency_id) * B.amount as amount, B.scope, B.c_invoice_id as invoiceId, B.documentNo as docNo, " +
      "           B.dateacct as dateInvoiced, FIN_AGING_INVOICECURRENCY_RATE(B.c_invoice_id, ?, B.c_currency_id) * (B.doubtfuldebtamt) as doubtfuldebt" +
      "           FROM (  " +
      "                 SELECT A.c_invoice_id, A.c_currency_id, A.bpId, A.documentNo, A.dateacct, SUM(A.amount) as amount, SUM(A.doubtfuldebtamt) as doubtfuldebtAmt, A.scope" +
      "                 FROM ( " +
      "                         SELECT i.c_bpartner_id AS bpId, i.c_invoice_id," +
      "                                CASE" +
      "                                 WHEN i.issotrx = 'N' AND i.poreference IS NOT NULL THEN FIN_AGING_GETDOCNO(i.poreference, i.documentNo, i.ad_org_id)" +
      "                                 ELSE i.documentNo" +
      "                                 END                AS documentNo," +
      "                                i.dateacct, i.c_currency_id," +
      "                                CASE " +
      "                                 WHEN to_char('Y') = ? AND psd.DOUBTFULDEBT_AMOUNT <> 0 AND FIN_AGING_ISDOUBTFULTDEBT(psd.fin_payment_schedule_invoice, TO_DATE(?)) = 'Y' THEN  psd.amount + psd.writeoffamt - psd.DOUBTFULDEBT_AMOUNT" +
      "                                 ELSE psd.amount + psd.writeoffamt" +
      "                                 END                AS amount, " +
      "                                CASE" +
      "                                 WHEN psd.DOUBTFULDEBT_AMOUNT <> 0 AND FIN_AGING_ISDOUBTFULTDEBT(psd.fin_payment_schedule_invoice, TO_DATE(?)) = 'Y' THEN psd.DOUBTFULDEBT_AMOUNT" +
      "                                 ELSE 0" +
      "                                 END                AS doubtfuldebtamt," +
      "                                CASE " +
      "                                 WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 0 " +
      "                                 WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 1 " +
      "                                 WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 2 " +
      "                                 WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 3 " +
      "                                 WHEN Trunc(ps.duedate) > TO_DATE(?) THEN 4 " +
      "                                 ELSE 5 " +
      "                                END                                                        AS scope" +
      "                         FROM  fin_payment_scheduledetail psd " +
      "                               INNER JOIN fin_payment_schedule ps ON psd.fin_payment_schedule_invoice = ps.fin_payment_schedule_id " +
      "                               INNER JOIN c_invoice            i  ON ps.c_invoice_id = i.c_invoice_id " +
      "                         WHERE psd.isactive = 'Y' " +
      "                           AND psd.iscanceled = 'N' " +
      "                           AND (psd.AD_Org_ID in (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")) " +
      "                           AND (i.AD_Org_ID in (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")) " +
      "                           AND 2=2";
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND i.C_BPARTNER_ID IN" + cbPartnerId);
    strSql = strSql + 
      "                           AND i.issotrx = ? " +
      "                           AND 1=1";
    strSql = strSql + ((excludeVoids.equals("excludeVoids"))?" AND i.DOCSTATUS NOT IN ('VO') ":"");
    strSql = strSql + 
      "                           AND Trunc(i.dateacct) <= TO_DATE(?)" +
      "                           AND (   psd.fin_payment_detail_id IS NULL " +
      "                                OR psd.isinvoicepaid = 'N' " +
      "                                OR (psd.isinvoicepaid = 'Y' " +
      "                                    AND EXISTS (SELECT 1 " +
      "                                              FROM  fin_payment_detail pd " +
      "                                                    INNER JOIN fin_payment p ON pd.fin_payment_id = p.fin_payment_id " +
      "                                              WHERE Trunc(p.paymentdate) > TO_DATE(?)" +
      "                                                AND pd.fin_payment_detail_id = psd.fin_payment_detail_id) ) ) " +
      "                      ) A       " +
      "                GROUP BY A.c_invoice_id, A.c_currency_id, A.bpId, A.documentNo, A.dateacct, A.scope" +
      "               ) B" +
      "          INNER JOIN c_bpartner bp on (B.bpId = bp.c_bpartner_id)     " +
      "          ) C";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":" WHERE ROWNUM <= " + oraLimit1);

    PreparedStatement st = null;

    int iParameter = 0;
    try {
    Connection conn = connectionProvider.getTransactionConnection();
    instance.internalConnection = conn;
    st = conn.prepareStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showDoubtfulDebt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstRangeBucket);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondRangeBucket);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, thirdRangeBucket);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fourthRangeBucket);
      if (org != null && !(org.equals(""))) {
        }
      if (org != null && !(org.equals(""))) {
        }
      if (cbPartnerId != null && !(cbPartnerId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recOrPay);
      if (excludeVoids != null && !(excludeVoids.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, asOfDate);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
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

  private AgingDaoData getselectDetail() throws SQLException {
    AgingDaoData objectAgingDaoData = new AgingDaoData();

        objectAgingDaoData.bpid = UtilSql.getValue(result, "bpid");
        objectAgingDaoData.bpname = UtilSql.getValue(result, "bpname");
        objectAgingDaoData.amount = UtilSql.getValue(result, "amount");
        objectAgingDaoData.scope = UtilSql.getValue(result, "scope");
        objectAgingDaoData.invoiceid = UtilSql.getValue(result, "invoiceid");
        objectAgingDaoData.docno = UtilSql.getValue(result, "docno");
        objectAgingDaoData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectAgingDaoData.doubtfuldebt = UtilSql.getValue(result, "doubtfuldebt");
        objectAgingDaoData.rownum = Long.toString(countRecord);
      return objectAgingDaoData;
  }
}
