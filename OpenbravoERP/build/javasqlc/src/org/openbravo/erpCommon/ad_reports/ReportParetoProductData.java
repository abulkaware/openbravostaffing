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
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class ReportParetoProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportParetoProductData.class);
  private String InitRecordNumber="0";
  public String orgid;
  public String searchkey;
  public String name;
  public String unit;
  public String qty;
  public String cost;
  public String value;
  public String percentage;
  public String percentageaccum;
  public String isabc;
  public String padre;
  public String id;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("orgid"))
      return orgid;
    else if (fieldName.equalsIgnoreCase("searchkey"))
      return searchkey;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("unit"))
      return unit;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
    else if (fieldName.equalsIgnoreCase("percentageaccum"))
      return percentageaccum;
    else if (fieldName.equalsIgnoreCase("isabc"))
      return isabc;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Five CTEs have been declared:
 *  * org_prod_nonagg: this calculates the Value per warehouse's organization and product (it transforms each transaction cost to the given currency), 
 *                     and it calculates the sum of movement quantities per warehouse's organization and product using the M_Transaction and M_Transaction_Cost tables directly.
 *                     It takes into account transactions just after the last costing rule available for the legal entity was started, and transactions and transaction costs non-aggregated yet 
 *                     (if aggregation is not ready, it takes all the information from the M_Transaction and M_Transaction_Cost tables).
 *  * org_prod_agg: It takes all the information from the M_Valued_Stock_Agg table (if available). Note this table aggregates information per legal entity, so if the Pareto is launched for 
 *                  a non-legal entity organization, this CTE will return no records. If the report's currency is different from the aggregated currency a conversion is performed.
 *  * org_prod: Creates the union all between org_prod_nonagg and org_prod_agg, grouping both datasets. Note that at this point the valuation of both datasets is in the same currency
 *  * org_prod_perc: based on org_prod, calculates the cost as (the Value per org and product calculated on org_prod) / (sum of movement quantities calculated on org_prod). This could have been calculated in org_prod cte directly, but it's done here for clarity.       
 *     It also calculates the percentage per warehouse's organization and product as 100 * (the Value per record calculated on org_prod) / (total Value per warehouse's org).
 *  * org_prod_perc_accum: based on org_prod_perc, calculates the percentage accumulated so far per warehouse's organization order by percentage desc. The accumulated percentages will be used to set ABC later on.
 *  
 *  The query outside the CTEs just gets the information from org_prod_perc_accum and calculates the ABC value based on the accumulated percentage, and joins with other tables to get the data to be printed.
 *   
 */
  public static ReportParetoProductData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adClientId, String legalEntityId, String processTime, String dateTimeFormat, String maxaggDate, String mWarehouseId, String adOrgId, String language)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adClientId, legalEntityId, processTime, dateTimeFormat, maxaggDate, mWarehouseId, adOrgId, language, 0, 0);
  }

/**
Five CTEs have been declared:
 *  * org_prod_nonagg: this calculates the Value per warehouse's organization and product (it transforms each transaction cost to the given currency), 
 *                     and it calculates the sum of movement quantities per warehouse's organization and product using the M_Transaction and M_Transaction_Cost tables directly.
 *                     It takes into account transactions just after the last costing rule available for the legal entity was started, and transactions and transaction costs non-aggregated yet 
 *                     (if aggregation is not ready, it takes all the information from the M_Transaction and M_Transaction_Cost tables).
 *  * org_prod_agg: It takes all the information from the M_Valued_Stock_Agg table (if available). Note this table aggregates information per legal entity, so if the Pareto is launched for 
 *                  a non-legal entity organization, this CTE will return no records. If the report's currency is different from the aggregated currency a conversion is performed.
 *  * org_prod: Creates the union all between org_prod_nonagg and org_prod_agg, grouping both datasets. Note that at this point the valuation of both datasets is in the same currency
 *  * org_prod_perc: based on org_prod, calculates the cost as (the Value per org and product calculated on org_prod) / (sum of movement quantities calculated on org_prod). This could have been calculated in org_prod cte directly, but it's done here for clarity.       
 *     It also calculates the percentage per warehouse's organization and product as 100 * (the Value per record calculated on org_prod) / (total Value per warehouse's org).
 *  * org_prod_perc_accum: based on org_prod_perc, calculates the percentage accumulated so far per warehouse's organization order by percentage desc. The accumulated percentages will be used to set ABC later on.
 *  
 *  The query outside the CTEs just gets the information from org_prod_perc_accum and calculates the ABC value based on the accumulated percentage, and joins with other tables to get the data to be printed.
 *   
 */
  public static ReportParetoProductData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adClientId, String legalEntityId, String processTime, String dateTimeFormat, String maxaggDate, String mWarehouseId, String adOrgId, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "with " +
      " org_prod_nonagg (ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct) as" +
      "  (select w.ad_org_id," +
      "          t.m_product_id," +
      "          sum(t.movementqty) as movementqty," +
      "          case when tc.c_currency_id = ?" +
      "             then sum(case when t.movementqty>=0 then tc.cost else -tc.cost end)" +
      "             else c_currency_convert_precision(sum(case when t.movementqty>=0 then tc.cost else -tc.cost end), tc.c_currency_id, ?, tc.dateacct, null, ?, ?)" +
      "          end as value_per_orgwarehouseproduct" +
      "   from m_transaction_cost tc" +
      "   join m_transaction t on (tc.m_transaction_id = t.m_transaction_id)" +
      "   join m_locator l on (t.m_locator_id = l.m_locator_id)" +
      "   join m_warehouse w on (l.m_warehouse_id = w.m_warehouse_id)" +
      "   where t.iscostcalculated = 'Y'" +
      "     and t.transactioncost is not null" +
      "     and t.trxprocessdate >= to_timestamp(?, ?)" +
      "     and t.movementdate < to_date(trunc(now())) + 1" +
      "     and t.movementdate > to_date(?)" +
      "     and tc.dateacct < to_date(trunc(now())) + 1" +
      "     and tc.dateacct > to_date(?)" +
      "     and t.ad_client_id = ?" +
      "     and 1=1";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND l.M_WAREHOUSE_ID = ?  ");
    strSql = strSql + 
      "     and ad_isorgincluded(w.AD_ORG_ID, ?, w.ad_client_id) <> -1 " +
      "   group by w.ad_org_id, t.m_product_id, tc.c_currency_id, tc.dateacct)," +
      " org_prod_agg (ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct) as" +
      " (select wh.ad_org_id," +
      "         agg.m_product_id," +
      "         agg.stock as movementqty," +
      "         case when agg.c_currency_id = ?" +
      "             then agg.valuation" +
      "             else c_currency_convert_precision(agg.valuation, agg.c_currency_id, ?, agg.dateto, null, agg.ad_client_id, agg.ad_org_id)" +
      "         end as value_per_orgwarehouseproduct" +
      "  from m_valued_stock_agg agg" +
      "  join m_locator l on (agg.m_locator_id = l.m_locator_id)" +
      "  join m_warehouse wh on (l.m_warehouse_id = wh.m_warehouse_id)" +
      "  where agg.dateto = to_date(?)" +
      "  and agg.ad_org_id = ?" +
      "  and 2=2";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND l.M_WAREHOUSE_ID = ?  ");
    strSql = strSql + 
      " )," +
      " org_prod (ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct) as" +
      "  (select A.ad_org_id, A.m_product_id, sum(A.movementqty), sum(A.value_per_orgwarehouseproduct)" +
      "   from (" +
      "         select ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct" +
      "         from org_prod_nonagg opna" +
      "         union all" +
      "         select ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct" +
      "         from org_prod_agg opa" +
      "        ) A" +
      "   group by A.ad_org_id, A.m_product_id" +
      "   having sum(A.movementqty) <> 0 " +
      "  ), " +
      " org_prod_perc (ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct, cost, total_value_per_orgwarehouse, percentage) as" +
      "  (select owp.ad_org_id," +
      "          owp.m_product_id," +
      "          owp.movementqty," +
      "          owp.value_per_orgwarehouseproduct," +
      "          owp.value_per_orgwarehouseproduct / owp.movementqty as cost," +
      "          sum(value_per_orgwarehouseproduct) over (partition by owp.ad_org_id) as total_value_per_orgwarehouse," +
      "          100 * value_per_orgwarehouseproduct/(sum(value_per_orgwarehouseproduct) over (partition by owp.ad_org_id)) as percentage" +
      "   from org_prod owp ), " +
      " org_prod_perc_accum (ad_org_id, m_product_id, movementqty, value_per_orgwarehouseproduct, cost, total_value_per_orgwarehouse, percentage, percentageaccum) as" +
      "  (select owpp.ad_org_id," +
      "          owpp.m_product_id," +
      "          owpp.movementqty," +
      "          owpp.value_per_orgwarehouseproduct," +
      "          owpp.cost," +
      "          owpp.total_value_per_orgwarehouse," +
      "          owpp.percentage," +
      "          sum(owpp.percentage) over (partition by owpp.ad_org_id" +
      "                                     order by owpp.ad_org_id, owpp.percentage desc " +
      "                                     rows between unbounded preceding and current row) as percentageaccum" +
      "   from org_prod_perc owpp ) " +
      "select o.name as orgid," +
      "       p.value as searchkey," +
      "       coalesce(pt.name, p.name) as name," +
      "       coalesce(uomt.name, uom.name) as unit," +
      "       owppa.movementqty as qty," +
      "       owppa.cost," +
      "       owppa.value_per_orgwarehouseproduct as value," +
      "       owppa.percentage," +
      "       owppa.percentageaccum," +
      "       case" +
      "           when owppa.percentageaccum <= 80 then 'A'" +
      "           when owppa.percentageaccum > 80" +
      "                and owppa.percentageaccum <= 95 then 'B'" +
      "           else 'C'" +
      "       end as isabc," +
      "       '' as padre, '' as id " +
      "from org_prod_perc_accum owppa " +
      "join m_product p on (owppa.m_product_id = p.m_product_id)" +
      "left join m_product_trl pt on (p.m_product_id = pt.m_product_id and pt.ad_language = ? and pt.isactive = 'Y')" +
      "join ad_org o on (o.ad_org_id = owppa.ad_org_id)" +
      "join c_uom uom on (uom.c_uom_id = p.c_uom_id)" +
      "left join c_uom_trl uomt on (uom.c_uom_id = uomt.c_uom_id and uomt.ad_language = ? and uomt.isactive = 'Y')" +
      "order by o.name," +
      "         owppa.percentage desc";

    ResultSet result;
    Vector<ReportParetoProductData> vector = new Vector<ReportParetoProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxaggDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntityId);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
        ReportParetoProductData objectReportParetoProductData = new ReportParetoProductData();
        objectReportParetoProductData.orgid = UtilSql.getValue(result, "orgid");
        objectReportParetoProductData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportParetoProductData.name = UtilSql.getValue(result, "name");
        objectReportParetoProductData.unit = UtilSql.getValue(result, "unit");
        objectReportParetoProductData.qty = UtilSql.getValue(result, "qty");
        objectReportParetoProductData.cost = UtilSql.getValue(result, "cost");
        objectReportParetoProductData.value = UtilSql.getValue(result, "value");
        objectReportParetoProductData.percentage = UtilSql.getValue(result, "percentage");
        objectReportParetoProductData.percentageaccum = UtilSql.getValue(result, "percentageaccum");
        objectReportParetoProductData.isabc = UtilSql.getValue(result, "isabc");
        objectReportParetoProductData.padre = UtilSql.getValue(result, "padre");
        objectReportParetoProductData.id = UtilSql.getValue(result, "id");
        objectReportParetoProductData.rownum = Long.toString(countRecord);
        objectReportParetoProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportParetoProductData);
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
    ReportParetoProductData objectReportParetoProductData[] = new ReportParetoProductData[vector.size()];
    vector.copyInto(objectReportParetoProductData);
    return(objectReportParetoProductData);
  }

  public static ReportParetoProductData[] set()    throws ServletException {
    ReportParetoProductData objectReportParetoProductData[] = new ReportParetoProductData[1];
    objectReportParetoProductData[0] = new ReportParetoProductData();
    objectReportParetoProductData[0].orgid = "";
    objectReportParetoProductData[0].searchkey = "";
    objectReportParetoProductData[0].name = "";
    objectReportParetoProductData[0].unit = "";
    objectReportParetoProductData[0].qty = "";
    objectReportParetoProductData[0].cost = "";
    objectReportParetoProductData[0].value = "";
    objectReportParetoProductData[0].percentage = "";
    objectReportParetoProductData[0].percentageaccum = "";
    objectReportParetoProductData[0].isabc = "";
    objectReportParetoProductData[0].padre = "";
    objectReportParetoProductData[0].id = "";
    return objectReportParetoProductData;
  }

  public static ReportParetoProductData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String adUserClient)    throws ServletException {
    return selectWarehouseDouble(connectionProvider, adUserClient, 0, 0);
  }

  public static ReportParetoProductData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_WAREHOUSE.AD_ORG_ID AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, TO_CHAR(M_WAREHOUSE.NAME) AS NAME" +
      "        FROM M_WAREHOUSE" +
      "        WHERE 1=1" +
      "         AND M_WAREHOUSE.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "         UNION " +
      "        SELECT null AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, TO_CHAR(M_WAREHOUSE.NAME) AS NAME" +
      "        FROM M_WAREHOUSE" +
      "        WHERE 2=2 AND M_WAREHOUSE.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")    " +
      "        ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<ReportParetoProductData> vector = new Vector<ReportParetoProductData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        ReportParetoProductData objectReportParetoProductData = new ReportParetoProductData();
        objectReportParetoProductData.padre = UtilSql.getValue(result, "padre");
        objectReportParetoProductData.id = UtilSql.getValue(result, "id");
        objectReportParetoProductData.name = UtilSql.getValue(result, "name");
        objectReportParetoProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportParetoProductData);
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
    ReportParetoProductData objectReportParetoProductData[] = new ReportParetoProductData[vector.size()];
    vector.copyInto(objectReportParetoProductData);
    return(objectReportParetoProductData);
  }

  public static ReportParetoProductData mUpdateParetoProduct0(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_UPDATE_PARETO_PRODUCT0(?)";

    ReportParetoProductData objectReportParetoProductData = new ReportParetoProductData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectReportParetoProductData);
  }

  public static String selectMaxAggregatedDate(ConnectionProvider connectionProvider, String legalEntityId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT MAX(dateto)" +
      "       FROM m_valued_stock_agg " +
      "       WHERE ad_org_id = ?";

    ResultSet result;
    String dateReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, legalEntityId);

      result = st.executeQuery();
      if(result.next()) {
        dateReturn = UtilSql.getDateValue(result, "max", "dd-MM-yyyy");
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
    return(dateReturn);
  }
}
