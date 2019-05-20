//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ExpenseSOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExpenseSOrderData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cBpartnerId;
  public String bpname;
  public String mWarehouseId;
  public String datereport;
  public String dateexpense;
  public String line;
  public String mProductId;
  public String sResourceassignmentId;
  public String cUomId;
  public String qty;
  public String description;
  public String note;
  public String invoiceprice;
  public String mPricelistId;
  public String documentno;
  public String sTimeexpenselineId;
  public String cCurrencyId;
  public String cProjectId;
  public String user1Id;
  public String user2Id;
  public String cCostcenterId;
  public String aAssetId;
  public String lineOrg;
  public String lineCCampaignId;
  public String lineCProjectId;
  public String lineUser1Id;
  public String lineUser2Id;
  public String lineCCostcenterId;
  public String lineAAssetId;
  public String dateordered;
  public String datepromised;
  public String cBpartnerLocationId;
  public String processing;
  public String stdprecision;
  public String priceprecision;
  public String validfrom;
  public String pricestd;
  public String pricelist;
  public String pricelimit;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("datereport"))
      return datereport;
    else if (fieldName.equalsIgnoreCase("dateexpense"))
      return dateexpense;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("invoiceprice"))
      return invoiceprice;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("s_timeexpenseline_id") || fieldName.equals("sTimeexpenselineId"))
      return sTimeexpenselineId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("line_org") || fieldName.equals("lineOrg"))
      return lineOrg;
    else if (fieldName.equalsIgnoreCase("line_c_campaign_id") || fieldName.equals("lineCCampaignId"))
      return lineCCampaignId;
    else if (fieldName.equalsIgnoreCase("line_c_project_id") || fieldName.equals("lineCProjectId"))
      return lineCProjectId;
    else if (fieldName.equalsIgnoreCase("line_user1_id") || fieldName.equals("lineUser1Id"))
      return lineUser1Id;
    else if (fieldName.equalsIgnoreCase("line_user2_id") || fieldName.equals("lineUser2Id"))
      return lineUser2Id;
    else if (fieldName.equalsIgnoreCase("line_c_costcenter_id") || fieldName.equals("lineCCostcenterId"))
      return lineCCostcenterId;
    else if (fieldName.equalsIgnoreCase("line_a_asset_id") || fieldName.equals("lineAAssetId"))
      return lineAAssetId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExpenseSOrderData[] select(ConnectionProvider connectionProvider, String bpartner, String dateFrom, String dateTo, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, bpartner, dateFrom, dateTo, adUserClient, adUserOrg, 0, 0);
  }

  public static ExpenseSOrderData[] select(ConnectionProvider connectionProvider, String bpartner, String dateFrom, String dateTo, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT E.AD_CLIENT_ID, E.AD_ORG_ID, EL.C_BPARTNER_ID, BP.NAME AS BPNAME, E.M_WAREHOUSE_ID, TO_CHAR(E.DATEREPORT) AS DATEREPORT," +
      "        TO_CHAR(EL.DATEEXPENSE) AS DATEEXPENSE, EL.LINE," +
      "        EL.M_PRODUCT_ID, EL.S_RESOURCEASSIGNMENT_ID, EL.C_UOM_ID, EL.QTY, EL.DESCRIPTION, EL.NOTE, EL.INVOICEPRICE," +
      "        COALESCE(BP.M_PRICELIST_ID, E.M_PRICELIST_ID) AS M_PRICELIST_ID, E.DOCUMENTNO, EL.S_TIMEEXPENSELINE_ID, EL.C_CURRENCY_ID," +
      "        E.C_PROJECT_ID, E.USER1_ID, E.USER2_ID, E.C_COSTCENTER_ID, E.A_ASSET_ID," +
      "        EL.AD_ORG_ID AS LINE_ORG," +
      "        EL.C_CAMPAIGN_ID AS LINE_C_CAMPAIGN_ID," +
      "        COALESCE(EL.C_PROJECT_ID, E.C_PROJECT_ID) AS LINE_C_PROJECT_ID," +
      "        COALESCE(EL.USER1_ID, E.USER1_ID) AS LINE_USER1_ID," +
      "        COALESCE(EL.USER2_ID, E.USER2_ID) AS LINE_USER2_ID," +
      "        COALESCE(EL.C_COSTCENTER_ID, E.C_COSTCENTER_ID) AS LINE_C_COSTCENTER_ID," +
      "        COALESCE(EL.A_ASSET_ID, E.A_ASSET_ID) AS LINE_A_ASSET_ID," +
      "        '' AS DATEORDERED, '' AS DATEPROMISED, '' AS C_BPARTNER_LOCATION_ID, '' AS PROCESSING," +
      "        '' AS STDPRECISION, '' AS PRICEPRECISION, '' AS VALIDFROM, '' AS PRICESTD, '' AS PRICELIST, '' AS PRICELIMIT" +
      "        FROM S_TIMEEXPENSELINE EL left join  S_RESOURCEASSIGNMENT RA on EL.S_RESOURCEASSIGNMENT_ID=RA.S_RESOURCEASSIGNMENT_ID," +
      "        S_TIMEEXPENSE E,  C_BPARTNER BP" +
      "        WHERE ";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  el.C_BPartner_ID=? AND  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  COALESCE(el.DateExpense, e.DateReport) >= TO_DATE(?) AND  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  COALESCE(el.DateExpense, e.DateReport)  < TO_DATE(?) AND  ");
    strSql = strSql + 
      "E.S_TIMEEXPENSE_ID=EL.S_TIMEEXPENSE_ID" +
      "        AND EL.C_BPARTNER_ID=BP.C_BPARTNER_ID" +
      "        AND EL.C_ORDERLINE_ID IS NULL" +
      "        AND EL.ISINVOICED='Y'" +
      "        AND E.PROCESSED='Y'" +
      "        AND E.ISACTIVE='Y'" +
      "        AND E.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND E.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        ORDER BY E.AD_ORG_ID, el.C_BPartner_ID, el.C_Project_ID, e.S_TimeExpense_ID, el.Line";

    ResultSet result;
    Vector<ExpenseSOrderData> vector = new Vector<ExpenseSOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
        objectExpenseSOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExpenseSOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExpenseSOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExpenseSOrderData.bpname = UtilSql.getValue(result, "bpname");
        objectExpenseSOrderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectExpenseSOrderData.datereport = UtilSql.getValue(result, "datereport");
        objectExpenseSOrderData.dateexpense = UtilSql.getValue(result, "dateexpense");
        objectExpenseSOrderData.line = UtilSql.getValue(result, "line");
        objectExpenseSOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectExpenseSOrderData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectExpenseSOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectExpenseSOrderData.qty = UtilSql.getValue(result, "qty");
        objectExpenseSOrderData.description = UtilSql.getValue(result, "description");
        objectExpenseSOrderData.note = UtilSql.getValue(result, "note");
        objectExpenseSOrderData.invoiceprice = UtilSql.getValue(result, "invoiceprice");
        objectExpenseSOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectExpenseSOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectExpenseSOrderData.sTimeexpenselineId = UtilSql.getValue(result, "s_timeexpenseline_id");
        objectExpenseSOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectExpenseSOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectExpenseSOrderData.user1Id = UtilSql.getValue(result, "user1_id");
        objectExpenseSOrderData.user2Id = UtilSql.getValue(result, "user2_id");
        objectExpenseSOrderData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectExpenseSOrderData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectExpenseSOrderData.lineOrg = UtilSql.getValue(result, "line_org");
        objectExpenseSOrderData.lineCCampaignId = UtilSql.getValue(result, "line_c_campaign_id");
        objectExpenseSOrderData.lineCProjectId = UtilSql.getValue(result, "line_c_project_id");
        objectExpenseSOrderData.lineUser1Id = UtilSql.getValue(result, "line_user1_id");
        objectExpenseSOrderData.lineUser2Id = UtilSql.getValue(result, "line_user2_id");
        objectExpenseSOrderData.lineCCostcenterId = UtilSql.getValue(result, "line_c_costcenter_id");
        objectExpenseSOrderData.lineAAssetId = UtilSql.getValue(result, "line_a_asset_id");
        objectExpenseSOrderData.dateordered = UtilSql.getValue(result, "dateordered");
        objectExpenseSOrderData.datepromised = UtilSql.getValue(result, "datepromised");
        objectExpenseSOrderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectExpenseSOrderData.processing = UtilSql.getValue(result, "processing");
        objectExpenseSOrderData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectExpenseSOrderData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectExpenseSOrderData.validfrom = UtilSql.getValue(result, "validfrom");
        objectExpenseSOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectExpenseSOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectExpenseSOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectExpenseSOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseSOrderData);
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
    ExpenseSOrderData objectExpenseSOrderData[] = new ExpenseSOrderData[vector.size()];
    vector.copyInto(objectExpenseSOrderData);
    return(objectExpenseSOrderData);
  }

  public static ExpenseSOrderData[] selectPrice(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, String CCurrencyID)    throws ServletException {
    return selectPrice(connectionProvider, MProductID, MPriceListID, CCurrencyID, 0, 0);
  }

  public static ExpenseSOrderData[] selectPrice(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, String CCurrencyID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceStd," +
      "        M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceList," +
      "        M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceLimit," +
      "        p.C_UOM_ID,pv.ValidFrom" +
      "        FROM M_Product p, M_ProductPrice pp, M_Pricelist pl, M_PriceList_Version pv" +
      "        WHERE p.M_Product_ID=pp.M_Product_ID" +
      "        AND pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID" +
      "        AND pv.M_PriceList_ID=pl.M_PriceList_ID" +
      "        AND pv.IsActive='Y'" +
      "        AND p.M_Product_ID = ?" +
      "        AND pl.M_PriceList_ID = ?" +
      "        AND pl.C_Currency_ID = ?" +
      "        ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<ExpenseSOrderData> vector = new Vector<ExpenseSOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPriceListID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CCurrencyID);

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
        ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
        objectExpenseSOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectExpenseSOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectExpenseSOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectExpenseSOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectExpenseSOrderData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectExpenseSOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseSOrderData);
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
    ExpenseSOrderData objectExpenseSOrderData[] = new ExpenseSOrderData[vector.size()];
    vector.copyInto(objectExpenseSOrderData);
    return(objectExpenseSOrderData);
  }

  public static int updateTimeExpenseLine(Connection conn, ConnectionProvider connectionProvider, String COrderlineId, String STimeExpenseLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE S_TimeExpenseLine SET C_OrderLine_id = ?" +
      "        WHERE S_TimeExpenseLine_ID= ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, COrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, STimeExpenseLineId);

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

  public static int insertCOrder(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String adClientId, String adOrgId, String user, String documentNo, String docStatus, String docAction, String processing, String cDoctypeId, String cDoctypetargetId, String dateordered, String datepromised, String dateacct, String cBpartnerId, String cBpartnerLocationId, String billtoId, String cCurrencyId, String paymentrule, String paymentMethod, String cPaymenttermId, String invoicerule, String deliveryrule, String freightcostrule, String deliveryviarule, String mWarehouseId, String mPricelistId, String cProjectId, String cActivityId, String cCampaignId, String user1Id, String user2Id, String cCostcenterId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDER" +
      "          (C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           DOCUMENTNO, DOCSTATUS, DOCACTION," +
      "           PROCESSING, C_DOCTYPE_ID, C_DOCTYPETARGET_ID," +
      "           DATEORDERED, DATEPROMISED, DATEACCT," +
      "           C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, BILLTO_ID," +
      "           C_CURRENCY_ID, PAYMENTRULE, FIN_PAYMENTMETHOD_ID, C_PAYMENTTERM_ID," +
      "           INVOICERULE, DELIVERYRULE, FREIGHTCOSTRULE," +
      "           DELIVERYVIARULE, M_WAREHOUSE_ID, M_PRICELIST_ID," +
      "           C_PROJECT_ID, C_ACTIVITY_ID, C_CAMPAIGN_ID, PRIORITYRULE," +
      "           USER1_ID, USER2_ID, C_COSTCENTER_ID, A_ASSET_ID)" +
      "        VALUES" +
      "          (?,?,?," +
      "           now(),?,now(),?," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           TO_DATE(?),TO_DATE(?),TO_DATE(?)," +
      "           ?,?,?," +
      "           ?,?,?,?," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           ?,?,?,'5'," +
      "           ?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentMethod);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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

  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String line, String cBpartnerId, String cBpartnerLocationId, String dateordered, String datepromised, String description, String mProductId, String mWarehouseId, String cUomId, String qtyordered, String cCurrencyId, String pricelist, String priceactual, String pricelistId, String pricelimit, String cTaxId, String sResourceassignmentId, String discount, String grossprice, String grosspricelist, String cProjectId, String user1Id, String user2Id, String cCostcenterId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDERLINE" +
      "          (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID," +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           C_ORDER_ID, LINE, C_BPARTNER_ID," +
      "           C_BPARTNER_LOCATION_ID, DATEORDERED, DATEPROMISED," +
      "           DESCRIPTION, M_PRODUCT_ID, M_WAREHOUSE_ID," +
      "           C_UOM_ID, QTYORDERED, C_CURRENCY_ID," +
      "           PRICELIST, PRICEACTUAL, PRICELIMIT," +
      "           C_TAX_ID, S_RESOURCEASSIGNMENT_ID, DISCOUNT," +
      "           PRICESTD, LINENETAMT," +
      "           GROSS_UNIT_PRICE, LINE_GROSS_AMOUNT, GROSSPRICELIST, GROSSPRICESTD," +
      "           C_PROJECT_ID, USER1_ID, USER2_ID, C_COSTCENTER_ID, A_ASSET_ID)" +
      "        VALUES" +
      "          (?,?,?," +
      "           now(),?,now(),?," +
      "           ?,TO_NUMBER(?),?," +
      "           ?,TO_DATE(?),TO_DATE(?)," +
      "           ?,?,?," +
      "           ?,TO_NUMBER(?),?," +
      "           TO_NUMBER(?), M_GET_OFFERS_PRICE(to_date(?),?,?,TO_NUMBER(?),TO_NUMBER(?),?),TO_NUMBER(?)," +
      "           ?, ?,TO_NUMBER(?)," +
      "           TO_NUMBER(?), (to_number(?) * to_number(?))," +
      "           TO_NUMBER(?), (to_number(?) * to_number(?)), TO_NUMBER(?), TO_NUMBER(?)," +
      "           ?, ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grosspricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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

  public static String cDoctypeTarget(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT AD_GET_DOCTYPE(?, ?, 'SOO', 'WP') FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_doctype");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String billto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE  C_BPartner_Location.IsBillTo='Y'" +
      "        AND C_BPartner_Location.IsActive='Y'" +
      "        AND C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String selectBpartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT Name" +
      "      FROM C_BPartner" +
      "      WHERE C_BPartner_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static ExpenseSOrderData[] selectPrecisions(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    return selectPrecisions(connectionProvider, cCurrencyId, 0, 0);
  }

  public static ExpenseSOrderData[] selectPrecisions(ConnectionProvider connectionProvider, String cCurrencyId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT STDPRECISION, PRICEPRECISION" +
      "          FROM C_CURRENCY" +
      "          WHERE C_CURRENCY_ID = ?";

    ResultSet result;
    Vector<ExpenseSOrderData> vector = new Vector<ExpenseSOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

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
        ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
        objectExpenseSOrderData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectExpenseSOrderData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectExpenseSOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseSOrderData);
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
    ExpenseSOrderData objectExpenseSOrderData[] = new ExpenseSOrderData[vector.size()];
    vector.copyInto(objectExpenseSOrderData);
    return(objectExpenseSOrderData);
  }

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency_ID" +
      "      FROM M_PriceList" +
      "      WHERE M_PriceList_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static String selectisPriceIncludingTaxes(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT istaxincluded" +
      "      FROM M_PriceList" +
      "      WHERE M_PriceList_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "istaxincluded");
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

  public static String selectConvertedAmt(ConnectionProvider connectionProvider, String expenseAmount, String currencyFrom, String currencyTo, String dateExpense, String client, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_currency_convert(TO_NUMBER(?),?,?,TO_DATE(?),null, ?,?) from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseAmount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateExpense);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_convert");
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

  public static String selectPaymentTerm(ConnectionProvider connectionProvider, String clientlist)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_paymentterm_id" +
      "        from c_paymentterm" +
      "        where isactive='Y'" +
      "        AND isdefault='Y'" +
      "        AND AD_Client_ID IN (";
    strSql = strSql + ((clientlist==null || clientlist.equals(""))?"":clientlist);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (clientlist != null && !(clientlist.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_paymentterm_id");
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
