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

class ReportSalesOrderInvoicedData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportSalesOrderInvoicedData.class);
  private String InitRecordNumber="0";
  public String bpartnername;
  public String projectname;
  public String productname;
  public String qtyinvoiced;
  public String linenetamt;
  public String linenetamtsym;
  public String convlinenetamt;
  public String uomname;
  public String aum;
  public String aumqty;
  public String priceactual;
  public String priceactualsym;
  public String convpriceactual;
  public String convsym;
  public String convisosym;
  public String transdate;
  public String transcurrencyid;
  public String transclientid;
  public String transorgid;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("projectname"))
      return projectname;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("linenetamtsym"))
      return linenetamtsym;
    else if (fieldName.equalsIgnoreCase("convlinenetamt"))
      return convlinenetamt;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("priceactualsym"))
      return priceactualsym;
    else if (fieldName.equalsIgnoreCase("convpriceactual"))
      return convpriceactual;
    else if (fieldName.equalsIgnoreCase("convsym"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
    else if (fieldName.equalsIgnoreCase("transdate"))
      return transdate;
    else if (fieldName.equalsIgnoreCase("transcurrencyid"))
      return transcurrencyid;
    else if (fieldName.equalsIgnoreCase("transclientid"))
      return transclientid;
    else if (fieldName.equalsIgnoreCase("transorgid"))
      return transorgid;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportSalesOrderInvoicedData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String dateFrom, String dateTo, String cBPartnerId, String mWarehouseId, String cProjectId, String cProductCategoryId, String cProjectKind, String cRegionId, String cProjectPublic, String productId)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserClient, adUserOrg, dateFrom, dateTo, cBPartnerId, mWarehouseId, cProjectId, cProductCategoryId, cProjectKind, cRegionId, cProjectPublic, productId, 0, 0);
  }

  public static ReportSalesOrderInvoicedData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String dateFrom, String dateTo, String cBPartnerId, String mWarehouseId, String cProjectId, String cProductCategoryId, String cProjectKind, String cRegionId, String cProjectPublic, String productId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(CB.NAME, C_BPARTNER.NAME) AS BPARTNERNAME, C_PROJECT.VALUE||' '||C_PROJECT.NAME AS PROJECTNAME," +
      "      M_PRODUCT.NAME AS PRODUCTNAME, CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN SUM(C_ORDERLINE.QTYINVOICED)*-1 ELSE SUM(C_ORDERLINE.QTYINVOICED) END AS QTYINVOICED," +
      "      SUM((CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_ORDERLINE.QTYINVOICED*-1 ELSE C_ORDERLINE.QTYINVOICED END)*C_ORDERLINE.PRICEACTUAL) AS LINENETAMT, " +
      "      C_CURRENCY_SYMBOL(COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), C_ORDERLINE.PRICEACTUAL, 'Y') AS LINENETAMTSYM,	  " +
      "	  SUM(C_CURRENCY_CONVERT((CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN C_ORDERLINE.QTYINVOICED*-1 ELSE C_ORDERLINE.QTYINVOICED END)*C_ORDERLINE.PRICEACTUAL, COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), ?, TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())), NULL, C_ORDERLINE.AD_CLIENT_ID, C_ORDERLINE.AD_ORG_ID)) AS CONVLINENETAMT," +
      "      C_UOM.NAME AS UOMNAME," +
      "      CASE WHEN C_ORDERLINE.C_AUM IS NULL THEN NULL ELSE (SELECT u.NAME FROM C_UOM u WHERE u.C_UOM_ID = C_ORDERLINE.C_AUM) END AS AUM," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN SUM(C_ORDERLINE.AUMQTY)*-1 ELSE SUM(C_ORDERLINE.AUMQTY) END AS AUMQTY, " +
      "      C_ORDERLINE.PRICEACTUAL, " +
      "      C_CURRENCY_SYMBOL(COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), C_ORDERLINE.PRICEACTUAL, 'Y') AS PRICEACTUALSYM,	  	  " +
      "	  C_CURRENCY_CONVERT(C_ORDERLINE.PRICEACTUAL, COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), ?, TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())), NULL, C_ORDERLINE.AD_CLIENT_ID, C_ORDERLINE.AD_ORG_ID) AS CONVPRICEACTUAL," +
      "	  C_CURRENCY_SYMBOL(?, '0', 'Y') AS CONVSYM,	  	  " +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM,	  	  " +
      "	  TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())) AS TRANSDATE,	  	  " +
      "	  COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID) AS TRANSCURRENCYID,      	  " +
      "	  C_ORDERLINE.AD_CLIENT_ID AS TRANSCLIENTID, 	  	  " +
      "	  C_ORDERLINE.AD_ORG_ID AS TRANSORGID, '' AS NAME" +
      "      FROM C_ORDER left join C_PROJECT on C_ORDER.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID" +
      "       left join C_BPARTNER CB on C_PROJECT.C_BPARTNER_ID = CB.C_BPARTNER_ID" +
      "                     left join C_BPARTNER on C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                     left join C_BPARTNER_LOCATION on C_ORDER.C_BPARTNER_LOCATION_ID = C_BPARTNER_LOCATION.C_BPARTNER_LOCATION_ID" +
      "                     left join C_LOCATION on  C_BPARTNER_LOCATION.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID" +
      "                     left join C_INVOICE on C_INVOICE.C_ORDER_ID = C_ORDER.C_ORDER_ID" +
      "                     left join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
      "                     C_ORDERLINE, M_PRODUCT, C_UOM" +
      "      WHERE C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "      AND C_ORDERLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND C_ORDERLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_ORDER.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_ORDER.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND C_ORDER.DATEORDERED >= TO_DATE(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND C_ORDER.DATEORDERED < TO_DATE(?) ");
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID = ? ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":"  AND C_ORDER.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((cProductCategoryId==null || cProductCategoryId.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((cProjectKind==null || cProjectKind.equals(""))?"":"  AND C_PROJECT.PROJECTKIND = ? ");
    strSql = strSql + ((cRegionId==null || cRegionId.equals(""))?"":"  AND C_LOCATION.C_REGION_ID = ? ");
    strSql = strSql + ((cProjectPublic==null || cProjectPublic.equals(""))?"":"  AND C_PROJECT.PUBLICPRIVATE = ? ");
    strSql = strSql + ((productId==null || productId.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID = ? ");
    strSql = strSql + 
      "      GROUP BY COALESCE(CB.NAME, C_BPARTNER.NAME), C_PROJECT.VALUE, C_PROJECT.NAME, M_PRODUCT.NAME, C_UOM.NAME, C_ORDERLINE.C_AUM, C_ORDERLINE.AUMQTY, C_ORDERLINE.PRICEACTUAL," +
      "      COALESCE(C_ORDERLINE.C_CURRENCY_ID, C_ORDER.C_CURRENCY_ID), TO_DATE(COALESCE(C_ORDER.DATEORDERED, NOW())),	  " +
      "	  C_ORDERLINE.AD_CLIENT_ID, C_ORDERLINE.AD_ORG_ID, C_DOCTYPE.DOCBASETYPE	" +
      "      HAVING SUM(C_ORDERLINE.QTYINVOICED) > 0" +
      "      ORDER BY COALESCE(CB.NAME, C_BPARTNER.NAME), C_PROJECT.NAME, M_PRODUCT.NAME";

    ResultSet result;
    Vector<ReportSalesOrderInvoicedData> vector = new Vector<ReportSalesOrderInvoicedData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (cProductCategoryId != null && !(cProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProductCategoryId);
      }
      if (cProjectKind != null && !(cProjectKind.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectKind);
      }
      if (cRegionId != null && !(cRegionId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      }
      if (cProjectPublic != null && !(cProjectPublic.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectPublic);
      }
      if (productId != null && !(productId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
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
        ReportSalesOrderInvoicedData objectReportSalesOrderInvoicedData = new ReportSalesOrderInvoicedData();
        objectReportSalesOrderInvoicedData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectReportSalesOrderInvoicedData.projectname = UtilSql.getValue(result, "projectname");
        objectReportSalesOrderInvoicedData.productname = UtilSql.getValue(result, "productname");
        objectReportSalesOrderInvoicedData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectReportSalesOrderInvoicedData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportSalesOrderInvoicedData.linenetamtsym = UtilSql.getValue(result, "linenetamtsym");
        objectReportSalesOrderInvoicedData.convlinenetamt = UtilSql.getValue(result, "convlinenetamt");
        objectReportSalesOrderInvoicedData.uomname = UtilSql.getValue(result, "uomname");
        objectReportSalesOrderInvoicedData.aum = UtilSql.getValue(result, "aum");
        objectReportSalesOrderInvoicedData.aumqty = UtilSql.getValue(result, "aumqty");
        objectReportSalesOrderInvoicedData.priceactual = UtilSql.getValue(result, "priceactual");
        objectReportSalesOrderInvoicedData.priceactualsym = UtilSql.getValue(result, "priceactualsym");
        objectReportSalesOrderInvoicedData.convpriceactual = UtilSql.getValue(result, "convpriceactual");
        objectReportSalesOrderInvoicedData.convsym = UtilSql.getValue(result, "convsym");
        objectReportSalesOrderInvoicedData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportSalesOrderInvoicedData.transdate = UtilSql.getDateValue(result, "transdate", "dd-MM-yyyy");
        objectReportSalesOrderInvoicedData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportSalesOrderInvoicedData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportSalesOrderInvoicedData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportSalesOrderInvoicedData.name = UtilSql.getValue(result, "name");
        objectReportSalesOrderInvoicedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportSalesOrderInvoicedData);
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
    ReportSalesOrderInvoicedData objectReportSalesOrderInvoicedData[] = new ReportSalesOrderInvoicedData[vector.size()];
    vector.copyInto(objectReportSalesOrderInvoicedData);
    return(objectReportSalesOrderInvoicedData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

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

  public static String selectWarehouse(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM M_WAREHOUSE " +
      "    WHERE M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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

  public static String selectRegionId(ConnectionProvider connectionProvider, String cRegionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT INITCAP(NAME) AS NAME FROM C_REGION " +
      "    WHERE C_REGION_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);

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

  public static String selectProjectkind(ConnectionProvider connectionProvider, String adLanguage, String projectkind)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT (CASE WHEN arl_t.NAME IS NULL THEN arl.NAME ELSE arl_t.NAME END) AS NAME " +
      "    FROM AD_REF_LIST arl left join AD_REF_LIST_TRL arl_t  on arl.ad_ref_list_id = arl_t.ad_ref_list_id" +
      "                  AND arl_t.AD_LANGUAGE = ?" +
      "    WHERE arl.ad_reference_id = '800004' " +
      "    AND arl.isActive = 'Y' " +
      "    AND arl.VALUE = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);

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

  public static String selectCategoryId(ConnectionProvider connectionProvider, String cCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM M_PRODUCT_CATEGORY " +
      "    WHERE M_PRODUCT_CATEGORY_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCategoryId);

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

  public static String selectProjectpublic(ConnectionProvider connectionProvider, String adLanguage, String projectpublic)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT (CASE WHEN arl_t.NAME IS NULL THEN arl.NAME ELSE arl_t.NAME END) AS NAME " +
      "    FROM AD_REF_LIST arl left join  AD_REF_LIST_TRL arl_t on arl.ad_ref_list_id = arl_t.ad_ref_list_id " +
      "                      AND arl_t.AD_LANGUAGE = ?" +
      "    WHERE arl.ad_reference_id = '800005' " +
      "    AND arl.isActive = 'Y' " +
      "    AND arl.VALUE = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectpublic);

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

  public static ReportSalesOrderInvoicedData[] set()    throws ServletException {
    ReportSalesOrderInvoicedData objectReportSalesOrderInvoicedData[] = new ReportSalesOrderInvoicedData[1];
    objectReportSalesOrderInvoicedData[0] = new ReportSalesOrderInvoicedData();
    objectReportSalesOrderInvoicedData[0].name = "";
    return objectReportSalesOrderInvoicedData;
  }

  public static String selectProject(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT VALUE || ' - ' ||NAME FROM C_PROJECT " +
      "    WHERE C_PROJECT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static String selectProduct(ConnectionProvider connectionProvider, String productId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT M_PRODUCT.NAME AS NAME " +
      "            FROM M_PRODUCT" +
      "            WHERE M_PRODUCT.M_PRODUCT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);

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
}
