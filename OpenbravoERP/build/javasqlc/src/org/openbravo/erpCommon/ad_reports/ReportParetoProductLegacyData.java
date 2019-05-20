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

class ReportParetoProductLegacyData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportParetoProductLegacyData.class);
  private String InitRecordNumber="0";
  public String orgid;
  public String searchkey;
  public String name;
  public String unit;
  public String qty;
  public String cost;
  public String value;
  public String percentage;
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

  public static ReportParetoProductLegacyData[] select(ConnectionProvider connectionProvider, String mWarehouseId, String adClientId, String language, String cCurrencyBase, String cCurrencyConv, String adOrgId)    throws ServletException {
    return select(connectionProvider, mWarehouseId, adClientId, language, cCurrencyBase, cCurrencyConv, adOrgId, 0, 0);
  }

  public static ReportParetoProductLegacyData[] select(ConnectionProvider connectionProvider, String mWarehouseId, String adClientId, String language, String cCurrencyBase, String cCurrencyConv, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select orgid, searchkey, name, unit, qty, cost, value, percentage," +
      "      m_get_pareto_abc_legacy(?, ad_org_id, ?, percentage) as isabc, '' as padre, '' as id" +
      "      from (" +
      "        select ad_column_identifier('AD_Org',w.ad_org_id, ?) as orgid," +
      "          p.value as searchkey, p.name as name," +
      "          ad_column_identifier('C_Uom', p.c_uom_id, ?) as unit," +
      "          w.ad_org_id, sd.m_product_id, sum(sd.qtyonhand) as qty," +
      "          c_currency_convert(c.cost, ?, ?, to_date(now()),'S', w.ad_client_id, w.ad_org_id) as cost, " +
      "          c_currency_convert(sum(sd.qtyonhand*c.cost), ?, ?, to_date(now()), 'S', w.ad_client_id, w.ad_org_id) as value, " +
      "          100*sum(sd.qtyonhand*c.cost)/(" +
      "            select sum(c_aux.cost * sd_aux.qtyonhand)" +
      "            from m_locator l_aux, m_warehouse w_aux, m_storage_detail sd_aux, m_costing c_aux" +
      "            where sd_aux.m_locator_id = l_aux.m_locator_id" +
      "              and l_aux.m_warehouse_id = w_aux.m_warehouse_id" +
      "              and w_aux.ad_org_id = w.ad_org_id" +
      "              and sd_aux.m_product_id = c_aux.m_product_id" +
      "              and sd_aux.qtyonhand > 0" +
      "              and c_aux.datefrom = (select max(c_aux1.datefrom)" +
      "                                    from m_costing c_aux1" +
      "                                    where c_aux1.m_product_id = c_aux.m_product_id" +
      "                                      and c_aux1.ad_client_id = ?" +
      "                                      and datefrom <= now())" +
      "              and c_aux.dateto > now()" +
      "              and c_aux.ad_client_id = ?" +
      "              and w_aux.ad_client_id = c_aux.ad_client_id" +
      "              and 1=1";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND w_aux.M_WAREHOUSE_ID = ?  ");
    strSql = strSql + 
      "              and 2=2";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND w_aux.AD_ORG_ID = ?  ");
    strSql = strSql + 
      "              ) as percentage" +
      "          from m_locator l, m_warehouse w, m_storage_detail sd, m_costing c, m_product p" +
      "          where sd.m_locator_id = l.m_locator_id" +
      "            and l.m_warehouse_id = w.m_warehouse_id" +
      "            and sd.m_product_id = c.m_product_id" +
      "            and sd.m_product_id = p.m_product_id" +
      "            and sd.qtyonhand > 0" +
      "            and c.datefrom = (select max(c1.datefrom)" +
      "                              from m_costing c1" +
      "                              where c.m_product_id = c1.m_product_id" +
      "                                and c1.ad_client_id = ?" +
      "                                and c1.datefrom <= now())" +
      "            and c.dateto > now()" +
      "            and c.ad_client_id=?" +
      "            and w.ad_client_id=c.ad_client_id" +
      "            and 3=3";
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND W.M_WAREHOUSE_ID = ?  ");
    strSql = strSql + 
      "            and 4=4";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND W.AD_ORG_ID = ?  ");
    strSql = strSql + 
      "          group by w.ad_org_id, sd.m_product_id, c.cost, w.ad_client_id, w.ad_org_id, p.name, p.value, p.c_uom_id) a" +
      "        order by orgid, percentage desc";

    ResultSet result;
    Vector<ReportParetoProductLegacyData> vector = new Vector<ReportParetoProductLegacyData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        ReportParetoProductLegacyData objectReportParetoProductLegacyData = new ReportParetoProductLegacyData();
        objectReportParetoProductLegacyData.orgid = UtilSql.getValue(result, "orgid");
        objectReportParetoProductLegacyData.searchkey = UtilSql.getValue(result, "searchkey");
        objectReportParetoProductLegacyData.name = UtilSql.getValue(result, "name");
        objectReportParetoProductLegacyData.unit = UtilSql.getValue(result, "unit");
        objectReportParetoProductLegacyData.qty = UtilSql.getValue(result, "qty");
        objectReportParetoProductLegacyData.cost = UtilSql.getValue(result, "cost");
        objectReportParetoProductLegacyData.value = UtilSql.getValue(result, "value");
        objectReportParetoProductLegacyData.percentage = UtilSql.getValue(result, "percentage");
        objectReportParetoProductLegacyData.isabc = UtilSql.getValue(result, "isabc");
        objectReportParetoProductLegacyData.padre = UtilSql.getValue(result, "padre");
        objectReportParetoProductLegacyData.id = UtilSql.getValue(result, "id");
        objectReportParetoProductLegacyData.rownum = Long.toString(countRecord);
        objectReportParetoProductLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportParetoProductLegacyData);
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
    ReportParetoProductLegacyData objectReportParetoProductLegacyData[] = new ReportParetoProductLegacyData[vector.size()];
    vector.copyInto(objectReportParetoProductLegacyData);
    return(objectReportParetoProductLegacyData);
  }

  public static ReportParetoProductLegacyData[] set()    throws ServletException {
    ReportParetoProductLegacyData objectReportParetoProductLegacyData[] = new ReportParetoProductLegacyData[1];
    objectReportParetoProductLegacyData[0] = new ReportParetoProductLegacyData();
    objectReportParetoProductLegacyData[0].orgid = "";
    objectReportParetoProductLegacyData[0].searchkey = "";
    objectReportParetoProductLegacyData[0].name = "";
    objectReportParetoProductLegacyData[0].unit = "";
    objectReportParetoProductLegacyData[0].qty = "";
    objectReportParetoProductLegacyData[0].cost = "";
    objectReportParetoProductLegacyData[0].value = "";
    objectReportParetoProductLegacyData[0].percentage = "";
    objectReportParetoProductLegacyData[0].isabc = "";
    objectReportParetoProductLegacyData[0].padre = "";
    objectReportParetoProductLegacyData[0].id = "";
    return objectReportParetoProductLegacyData;
  }

  public static ReportParetoProductLegacyData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String adUserClient)    throws ServletException {
    return selectWarehouseDouble(connectionProvider, adUserClient, 0, 0);
  }

  public static ReportParetoProductLegacyData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ReportParetoProductLegacyData> vector = new Vector<ReportParetoProductLegacyData>(0);
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
        ReportParetoProductLegacyData objectReportParetoProductLegacyData = new ReportParetoProductLegacyData();
        objectReportParetoProductLegacyData.padre = UtilSql.getValue(result, "padre");
        objectReportParetoProductLegacyData.id = UtilSql.getValue(result, "id");
        objectReportParetoProductLegacyData.name = UtilSql.getValue(result, "name");
        objectReportParetoProductLegacyData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportParetoProductLegacyData);
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
    ReportParetoProductLegacyData objectReportParetoProductLegacyData[] = new ReportParetoProductLegacyData[vector.size()];
    vector.copyInto(objectReportParetoProductLegacyData);
    return(objectReportParetoProductLegacyData);
  }

  public static ReportParetoProductLegacyData mUpdateParetoProduct0Legacy(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_UPDATE_PARETO_PRODUCT0_LEGACY(?)";

    ReportParetoProductLegacyData objectReportParetoProductLegacyData = new ReportParetoProductLegacyData();
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
    return(objectReportParetoProductLegacyData);
  }
}
