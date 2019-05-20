//Sqlc generated V1.O00-1
package org.openbravo.reports.ordersawaitingdelivery.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportOrderNotShippedData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportOrderNotShippedData.class);
  private String InitRecordNumber="0";
  public String orgname;
  public String bpname;
  public String documentno;
  public String poreference;
  public String dateordered;
  public String datepromised;
  public String deliveryrule;
  public String deliverylocation;
  public String prodname;
  public String mAttributesetinstanceId;
  public String orderedqty;
  public String pendingqty;
  public String qtyinstock;
  public String aumqty;
  public String aumsymbol;
  public String aum;
  public String mProductId;
  public String orderedvalue;
  public String pendingvalue;
  public String stockvalue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("orgname"))
      return orgname;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliverylocation"))
      return deliverylocation;
    else if (fieldName.equalsIgnoreCase("prodname"))
      return prodname;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("orderedqty"))
      return orderedqty;
    else if (fieldName.equalsIgnoreCase("pendingqty"))
      return pendingqty;
    else if (fieldName.equalsIgnoreCase("qtyinstock"))
      return qtyinstock;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("aumsymbol"))
      return aumsymbol;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("orderedvalue"))
      return orderedvalue;
    else if (fieldName.equalsIgnoreCase("pendingvalue"))
      return pendingvalue;
    else if (fieldName.equalsIgnoreCase("stockvalue"))
      return stockvalue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportOrderNotShippedData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String dateFrom, String dateTo, String cBpartnerId, String deliveryTerms, String orderDocNo, String orderRef, String cOrgId)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserClient, adUserOrg, dateFrom, dateTo, cBpartnerId, deliveryTerms, orderDocNo, orderRef, cOrgId, 0, 0);
  }

  public static ReportOrderNotShippedData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String dateFrom, String dateTo, String cBpartnerId, String deliveryTerms, String orderDocNo, String orderRef, String cOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT ORGNAME, BPNAME, DOCUMENTNO, POREFERENCE," +
      "       DATEORDERED, DATEPROMISED, DELIVERYRULE, DELIVERYLOCATION," +
      "       PRODNAME, M_ATTRIBUTESETINSTANCE_ID, ORDEREDQTY, PENDINGQTY," +
      "       STOCKVALUE || ' ' || UOMSYMBOL AS QTYINSTOCK, AUMQTY," +
      "       (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = AUM) AS AUMSYMBOL, AUM," +
      "       M_PRODUCT_ID, ORDEREDVALUE, PENDINGVALUE, STOCKVALUE" +
      "    FROM" +
      "    (" +
      "    SELECT ORG.NAME AS ORGNAME, BP.NAME AS BPNAME," +
      "    O.DOCUMENTNO, O.POREFERENCE, TO_DATE(O.DATEORDERED) AS DATEORDERED, TO_DATE(O.DATEPROMISED) AS DATEPROMISED, " +
      "    REFLISTV.NAME AS DELIVERYRULE, COALESCE(DLOC.NAME, BPADD.NAME) AS DELIVERYLOCATION," +
      "    PR.NAME || ' ' || COALESCE(TO_CHAR(ASI.DESCRIPTION), '') AS PRODNAME, OL.M_ATTRIBUTESETINSTANCE_ID," +
      "    OL.QTYORDERED || ' ' || COALESCE(TO_CHAR(UO.UOMSYMBOL), '') AS ORDEREDQTY, " +
      "    (OL.QTYORDERED-OL.QTYDELIVERED) || ' ' || COALESCE(TO_CHAR(UO.UOMSYMBOL), '') AS PENDINGQTY, " +
      "    COALESCE(TO_CHAR(UO.UOMSYMBOL), '') AS UOMSYMBOL," +
      "    OL.AUMQTY, (COALESCE (OL.C_AUM, M_GET_DEFAULT_AUM_FOR_DOCUMENT(OL.M_PRODUCT_ID, O.C_DOCTYPE_ID))) AS AUM," +
      "    OL.M_PRODUCT_ID, OL.QTYORDERED AS ORDEREDVALUE, (OL.QTYORDERED-OL.QTYDELIVERED) AS PENDINGVALUE," +
      "    (" +
      "      SELECT SUM(SD.QTYONHAND)" +
      "      FROM M_STORAGE_DETAIL SD" +
      "      WHERE SD.M_PRODUCT_ID = OL.M_PRODUCT_ID" +
      "      AND SD.C_UOM_ID = OL.C_UOM_ID" +
      "      AND COALESCE(SD.M_ATTRIBUTESETINSTANCE_ID, '0') = COALESCE(OL.M_ATTRIBUTESETINSTANCE_ID, SD.M_ATTRIBUTESETINSTANCE_ID, '0')" +
      "      AND COALESCE(SD.M_PRODUCT_UOM_ID,'-1') = COALESCE(OL.M_PRODUCT_UOM_ID, '-1')" +
      "      AND EXISTS (" +
      "        SELECT 1" +
      "        FROM M_LOCATOR LOC" +
      "        WHERE LOC.M_LOCATOR_ID = SD.M_LOCATOR_ID" +
      "        AND LOC.M_WAREHOUSE_ID = OL.M_WAREHOUSE_ID" +
      "      )" +
      "    ) AS STOCKVALUE     " +
      "    FROM C_ORDER O" +
      "    JOIN AD_ORG ORG ON O.AD_ORG_ID = ORG.AD_ORG_ID" +
      "    JOIN C_BPARTNER BP ON O.C_BPARTNER_ID = BP.C_BPARTNER_ID" +
      "    JOIN C_BPARTNER_LOCATION BPADD ON O.C_BPARTNER_LOCATION_ID = BPADD.C_BPARTNER_LOCATION_ID" +
      "    JOIN AD_REF_LIST_V REFLISTV ON O.DELIVERYRULE = REFLISTV.VALUE" +
      "    LEFT JOIN C_BPARTNER_LOCATION DLOC ON O.DELIVERY_LOCATION_ID = DLOC.C_BPARTNER_LOCATION_ID" +
      "    JOIN C_ORDERLINE OL ON O.C_ORDER_ID = OL.C_ORDER_ID" +
      "    JOIN M_PRODUCT PR ON OL.M_PRODUCT_ID = PR.M_PRODUCT_ID" +
      "    JOIN C_UOM UO ON OL.C_UOM_ID = UO.C_UOM_ID" +
      "    LEFT JOIN M_ATTRIBUTESETINSTANCE ASI ON OL.M_ATTRIBUTESETINSTANCE_ID = ASI.M_ATTRIBUTESETINSTANCE_ID" +
      "    WHERE O.DOCSTATUS = 'CO'" +
      "    AND O.ISSOTRX = 'Y'" +
      "    AND REFLISTV.AD_REFERENCE_ID = '151'" +
      "    AND REFLISTV.AD_LANGUAGE = ?" +
      "    AND O.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "    AND O.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "    AND O.ISDELIVERED = 'N'" +
      "    AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND O.DATEORDERED >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND O.DATEORDERED < TO_DATE(?)  ");
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND O.C_BPARTNER_ID = ? ");
    strSql = strSql + ((deliveryTerms==null || deliveryTerms.equals(""))?"":" AND O.DELIVERYRULE = ? ");
    strSql = strSql + ((orderDocNo==null || orderDocNo.equals(""))?"":" AND UPPER(O.DOCUMENTNO) LIKE '%'||UPPER(?)||'%' ");
    strSql = strSql + ((orderRef==null || orderRef.equals(""))?"":" AND UPPER(O.POREFERENCE) LIKE '%'||UPPER(?)||'%' ");
    strSql = strSql + ((cOrgId==null || cOrgId.equals(""))?"":" AND O.AD_ORG_ID = ? ");
    strSql = strSql + 
      "    ) A ORDER BY ORGNAME, BPNAME, DOCUMENTNO";

    ResultSet result;
    Vector<ReportOrderNotShippedData> vector = new Vector<ReportOrderNotShippedData>(0);
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
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      if (deliveryTerms != null && !(deliveryTerms.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryTerms);
      }
      if (orderDocNo != null && !(orderDocNo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderDocNo);
      }
      if (orderRef != null && !(orderRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderRef);
      }
      if (cOrgId != null && !(cOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgId);
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
        ReportOrderNotShippedData objectReportOrderNotShippedData = new ReportOrderNotShippedData();
        objectReportOrderNotShippedData.orgname = UtilSql.getValue(result, "orgname");
        objectReportOrderNotShippedData.bpname = UtilSql.getValue(result, "bpname");
        objectReportOrderNotShippedData.documentno = UtilSql.getValue(result, "documentno");
        objectReportOrderNotShippedData.poreference = UtilSql.getValue(result, "poreference");
        objectReportOrderNotShippedData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectReportOrderNotShippedData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectReportOrderNotShippedData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectReportOrderNotShippedData.deliverylocation = UtilSql.getValue(result, "deliverylocation");
        objectReportOrderNotShippedData.prodname = UtilSql.getValue(result, "prodname");
        objectReportOrderNotShippedData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectReportOrderNotShippedData.orderedqty = UtilSql.getValue(result, "orderedqty");
        objectReportOrderNotShippedData.pendingqty = UtilSql.getValue(result, "pendingqty");
        objectReportOrderNotShippedData.qtyinstock = UtilSql.getValue(result, "qtyinstock");
        objectReportOrderNotShippedData.aumqty = UtilSql.getValue(result, "aumqty");
        objectReportOrderNotShippedData.aumsymbol = UtilSql.getValue(result, "aumsymbol");
        objectReportOrderNotShippedData.aum = UtilSql.getValue(result, "aum");
        objectReportOrderNotShippedData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectReportOrderNotShippedData.orderedvalue = UtilSql.getValue(result, "orderedvalue");
        objectReportOrderNotShippedData.pendingvalue = UtilSql.getValue(result, "pendingvalue");
        objectReportOrderNotShippedData.stockvalue = UtilSql.getValue(result, "stockvalue");
        objectReportOrderNotShippedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportOrderNotShippedData);
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
    ReportOrderNotShippedData objectReportOrderNotShippedData[] = new ReportOrderNotShippedData[vector.size()];
    vector.copyInto(objectReportOrderNotShippedData);
    return(objectReportOrderNotShippedData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT MAX(NAME) AS NAME FROM C_BPARTNER " +
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
}
