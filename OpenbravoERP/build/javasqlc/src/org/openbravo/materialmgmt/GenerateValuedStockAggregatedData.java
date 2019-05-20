//Sqlc generated V1.O00-1
package org.openbravo.materialmgmt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

class GenerateValuedStockAggregatedData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateValuedStockAggregatedData.class);
  private String InitRecordNumber="0";
  public String cInvoiceId;
  public String documentno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String select(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select c_invoice_id, documentno from c_invoice";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_invoice_id");
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

  public static int insertData(Connection conn, ConnectionProvider connectionProvider, String legalEntity, String cPeriodID, String dateFrom, String dateTo, String cCurrencyID, String mCostingRuleID, String startingDate, String crStartDate, String crEndDate, String adClientId, String organization, String legalOrg)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO m_valued_stock_agg" +
      "      (" +
      "        m_valued_stock_agg_id," +
      "        ad_client_id," +
      "        ad_org_id," +
      "        isactive," +
      "        created," +
      "        createdby," +
      "        updated," +
      "        updatedby," +
      "        m_product_id," +
      "        m_locator_id," +
      "        c_uom_id," +
      "        c_period_id," +
      "        datefrom," +
      "        dateto," +
      "        stock," +
      "        valuation," +
      "        c_currency_id," +
      "        m_costing_rule_id" +
      "      )" +
      "      SELECT GET_UUID(), ad_client_id, ?, 'Y' as active, NOW(), MAX(createdby), NOW(), MAX(updatedby)," +
      "        m_product_id, m_locator_id, c_uom_id, ?, TO_DATE(?), TO_DATE(?), " +
      "        sum(stock) as stock, sum(valuation) AS valuation, ?, ?" +
      "        FROM (" +
      "            SELECT ad_client_id, MAX(createdby) AS createdby, MAX(updatedby) AS updatedby, m_product_id, m_locator_id, c_uom_id, SUM(movementqty) as stock," +
      "            sum(a.trxcost) AS valuation" +
      "            FROM(" +
      "                SELECT trx.ad_client_id, trx.ad_org_id, trx.createdby, trx.updatedby, trx.m_product_id, trx.m_locator_id, trx.c_uom_id, trx.movementqty," +
      "                  0 AS trxcost" +
      "                FROM m_transaction trx" +
      "                WHERE trx.movementdate <= TO_DATE(?)" +
      "                AND 2=2";
    strSql = strSql + ((startingDate==null || startingDate.equals(""))?"":"  AND trx.movementdate > TO_DATE(?)  ");
    strSql = strSql + 
      "                AND 4=4";
    strSql = strSql + ((crStartDate==null || crStartDate.equals(""))?"":"  AND trx.trxprocessdate >= to_timestamp(?, 'DD-MM-YYYY HH24:MI:SS')  ");
    strSql = strSql + 
      "                AND 5=5";
    strSql = strSql + ((crEndDate==null || crEndDate.equals(""))?"":"  AND trx.trxprocessdate <= to_timestamp(?, 'DD-MM-YYYY HH24:MI:SS')  ");
    strSql = strSql + 
      "                AND trx.ad_client_id IN (?)" +
      "                AND trx.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                UNION ALL" +
      "                SELECT t.ad_client_id, t.ad_org_id, t.createdby, t.updatedby, t.m_product_id, t.m_locator_id, t.c_uom_id, 0 AS movementqty," +
      "                  CASE t.iscostcalculated" +
      "                    WHEN 'Y' THEN C_CURRENCY_CONVERT_PRECISION (tc.trxcost, tc.c_currency_id, ?, tc.movementdate, NULL, t.ad_client_id, ?,'C')" +
      "                    ELSE NULL" +
      "                  END AS trxcost" +
      "                FROM(SELECT SUM(CASE WHEN t2.movementqty < 0 THEN -cost ELSE cost END) AS trxcost, t2.m_transaction_id, tc2.c_currency_id, COALESCE(dateacct, costdate) AS movementdate" +
      "                     FROM m_transaction_cost tc2" +
      "                     JOIN m_transaction t2 ON (tc2.m_transaction_id = t2.m_transaction_id)" +
      "                     WHERE dateacct <= TO_DATE(?)" +
      "                     AND 3=3";
    strSql = strSql + ((startingDate==null || startingDate.equals(""))?"":"  AND dateacct > TO_DATE(?)  ");
    strSql = strSql + 
      "                     AND 6=6";
    strSql = strSql + ((crStartDate==null || crStartDate.equals(""))?"":"  AND t2.trxprocessdate >= to_timestamp(?, 'DD-MM-YYYY HH24:MI:SS')  ");
    strSql = strSql + 
      "                     AND 7=7";
    strSql = strSql + ((crEndDate==null || crEndDate.equals(""))?"":"  AND t2.trxprocessdate <= to_timestamp(?, 'DD-MM-YYYY HH24:MI:SS')  ");
    strSql = strSql + 
      "                     AND t2.ad_client_id IN (?)" +
      "                     AND t2.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                     GROUP BY t2.m_transaction_id, tc2.c_currency_id, COALESCE(dateacct, costdate)" +
      "                ) tc LEFT JOIN m_transaction t ON (t.m_transaction_id = tc.m_transaction_id)" +
      "            ) a" +
      "            GROUP BY a.ad_client_id, a.m_product_id, a.c_uom_id, a.m_locator_id" +
      "            UNION ALL" +
      "            SELECT ad_client_id, MAX(createdby) AS createdby, MAX(updatedby) AS updatedby, m_product_id, m_locator_id, c_uom_id, " +
      "              SUM(stock) as stock, SUM(valuation) as valuation" +
      "            FROM m_valued_stock_agg agg" +
      "            WHERE ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "              AND dateto = (SELECT MAX(agg2.dateto)" +
      "                            FROM m_valued_stock_agg agg2" +
      "                            WHERE agg2.dateto <= TO_DATE(?)" +
      "                            AND agg2.ad_org_id IN (";
    strSql = strSql + ((organization==null || organization.equals(""))?"":organization);
    strSql = strSql + 
      ")" +
      "                            AND m_costing_rule_id = ?)" +
      "            GROUP BY ad_client_id, ad_org_id, m_product_id, m_locator_id, c_uom_id) B" +
      "        GROUP BY ad_client_id, m_product_id, m_locator_id, c_uom_id";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mCostingRuleID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (startingDate != null && !(startingDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, startingDate);
      }
      if (crStartDate != null && !(crStartDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, crStartDate);
      }
      if (crEndDate != null && !(crEndDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, crEndDate);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (organization != null && !(organization.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalOrg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (startingDate != null && !(startingDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, startingDate);
      }
      if (crStartDate != null && !(crStartDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, crStartDate);
      }
      if (crEndDate != null && !(crEndDate.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, crEndDate);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (organization != null && !(organization.equals(""))) {
        }
      if (organization != null && !(organization.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startingDate);
      if (organization != null && !(organization.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mCostingRuleID);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
