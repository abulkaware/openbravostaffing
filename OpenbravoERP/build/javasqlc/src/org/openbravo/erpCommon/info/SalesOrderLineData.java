//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SalesOrderLineData implements FieldProvider {
static Logger log4j = Logger.getLogger(SalesOrderLineData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cOrderlineId;
  public String bpartnerName;
  public String productName;
  public String dateordered;
  public String documentno;
  public String issotrx;
  public String qty;
  public String priceactual;
  public String linenetamt;
  public String line;
  public String grandtotal;
  public String lineText;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("bpartner_name") || fieldName.equals("bpartnerName"))
      return bpartnerName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("line_text") || fieldName.equals("lineText"))
      return lineText;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SalesOrderLineData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String isdelivered, String isinvoiced, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adUserClient, adUserOrg, documentno, description, orderReference, businesPartner, dateFrom, dateTo, grandTotalFrom, grandTotalTo, product, isdelivered, isinvoiced, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static SalesOrderLineData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String isdelivered, String isinvoiced, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.*," +
      "      	(DOCUMENTNO || ' - ' || DATEORDERED || ' - ' || GRANDTOTAL || ' - ' || LINE || ' - ' || LINENETAMT) AS LINE_TEXT," +
      "		C_ORDERLINE_ID || '@_##_@' || DOCUMENTNO || ' - ' || DATEORDERED || ' - ' || GRANDTOTAL || ' - ' || LINE || ' - ' || LINENETAMT as rowkey" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (  " +
      "          SELECT ol.C_ORDERLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, ol.DATEORDERED, o.DOCUMENTNO, " +
      "          o.ISSOTRX, ol.QTYORDERED AS QTY, ol.PRICEACTUAL, ol.LINENETAMT, ol.LINE, o.GRANDTOTAL" +
      "          FROM C_ORDER o, C_ORDERLINE ol, M_PRODUCT p, C_BPARTNER b" +
      "          WHERE o.C_ORDER_ID = ol.C_ORDER_ID " +
      "          AND o.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ol.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "          AND o.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND o.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND o.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(o.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ol.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(o.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND o.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND ol.DateOrdered >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND ol.DateOrdered < to_date(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND ol.PRICEACTUAL*ol.QTYORDERED >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND ol.PRICEACTUAL*ol.QTYORDERED <= ?  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ol.M_Product_ID=?  ");
    strSql = strSql + ((isdelivered.equals("isdelivered"))?"  AND (ol.QTYORDERED - COALESCE(ol.QTYDELIVERED, 0)) <> 0  ":"");
    strSql = strSql + ((isinvoiced.equals("isinvoiced"))?"  AND (ol.QTYORDERED - COALESCE(ol.QTYINVOICED, 0)) <> 0  ":"");
    strSql = strSql + 
      "          AND o.ISSOTRX = 'Y'" +
      "          ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "		) A ) B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<SalesOrderLineData> vector = new Vector<SalesOrderLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (grandTotalFrom != null && !(grandTotalFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotalFrom);
      }
      if (grandTotalTo != null && !(grandTotalTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotalTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (isdelivered != null && !(isdelivered.equals(""))) {
        }
      if (isinvoiced != null && !(isinvoiced.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
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
        SalesOrderLineData objectSalesOrderLineData = new SalesOrderLineData();
        objectSalesOrderLineData.rn1 = UtilSql.getValue(result, "rn1");
        objectSalesOrderLineData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectSalesOrderLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectSalesOrderLineData.productName = UtilSql.getValue(result, "product_name");
        objectSalesOrderLineData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSalesOrderLineData.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderLineData.qty = UtilSql.getValue(result, "qty");
        objectSalesOrderLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectSalesOrderLineData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectSalesOrderLineData.line = UtilSql.getValue(result, "line");
        objectSalesOrderLineData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectSalesOrderLineData.lineText = UtilSql.getValue(result, "line_text");
        objectSalesOrderLineData.rowkey = UtilSql.getValue(result, "rowkey");
        objectSalesOrderLineData.position = Long.toString(countRecord);
        objectSalesOrderLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderLineData);
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
    SalesOrderLineData objectSalesOrderLineData[] = new SalesOrderLineData[vector.size()];
    vector.copyInto(objectSalesOrderLineData);
    return(objectSalesOrderLineData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String isdelivered, String isinvoiced, String isSoTr, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT count(*) AS value FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.*  FROM (" +
      "	          SELECT 1" +
      "	          FROM C_ORDER o, C_ORDERLINE ol, M_PRODUCT p, C_BPARTNER b" +
      "	          WHERE o.C_ORDER_ID = ol.C_ORDER_ID " +
      "	          AND o.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "	          AND ol.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "	          AND o.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	          AND o.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "	          AND o.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(o.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ol.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(o.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND o.C_BPartner_ID = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND ol.DateOrdered >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND ol.DateOrdered < to_date(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND ol.PRICEACTUAL*ol.QTYORDERED >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND ol.PRICEACTUAL*ol.QTYORDERED <= ?  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ol.M_Product_ID = ?  ");
    strSql = strSql + ((isdelivered.equals("isdelivered"))?"  AND (ol.QTYORDERED - COALESCE(ol.QTYDELIVERED, 0)) <> 0  ":"");
    strSql = strSql + ((isinvoiced.equals("isinvoiced"))?"  AND (ol.QTYORDERED - COALESCE(ol.QTYINVOICED, 0)) <> 0  ":"");
    strSql = strSql + 
      "	          AND o.ISSOTRX = '";
    strSql = strSql + ((isSoTr==null || isSoTr.equals(""))?"":isSoTr);
    strSql = strSql + 
      "'" +
      "	          AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "	       ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "	       ) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (grandTotalFrom != null && !(grandTotalFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotalFrom);
      }
      if (grandTotalTo != null && !(grandTotalTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotalTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (isdelivered != null && !(isdelivered.equals(""))) {
        }
      if (isinvoiced != null && !(isinvoiced.equals(""))) {
        }
      if (isSoTr != null && !(isSoTr.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static SalesOrderLineData[] selectSOTrx(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String isdelivered, String isinvoiced, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return selectSOTrx(connectionProvider, rownum, adUserClient, adUserOrg, documentno, description, orderReference, businesPartner, dateFrom, dateTo, grandTotalFrom, grandTotalTo, product, isdelivered, isinvoiced, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static SalesOrderLineData[] selectSOTrx(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String isdelivered, String isinvoiced, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (  " +
      "          SELECT ol.C_ORDERLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, ol.DATEORDERED, o.DOCUMENTNO, " +
      "          o.ISSOTRX, ol.QTYORDERED AS QTY, ol.PRICEACTUAL, ol.LINENETAMT, " +
      "          (o.DOCUMENTNO || ' - ' || ol.DATEORDERED || ' - ' || o.GRANDTOTAL || ' - ' || ol.LINE || ' - ' || ol.LINENETAMT) AS LINE_TEXT," +
      "			  ol.C_ORDERLINE_ID || '@_##_@' || o.DOCUMENTNO || ' - ' || ol.DATEORDERED || ' - ' || o.GRANDTOTAL || ' - ' || ol.LINE || ' - ' || ol.LINENETAMT as rowkey" +
      "          FROM C_ORDERLINE ol left join M_MATCHPO mp on ol.C_ORDERLINE_ID = mp.C_ORDERLINE_ID " +
      "                                                    AND mp.C_INVOICELINE_ID IS NOT NULL" +
      "                              left join M_MATCHPO mp2 on ol.C_ORDERLINE_ID = mp2.C_ORDERLINE_ID" +
      "                                                    AND mp2.M_INOUTLINE_ID IS NOT NULL," +
      "                C_ORDER o,  M_PRODUCT p, C_BPARTNER b" +
      "          WHERE o.C_ORDER_ID = ol.C_ORDER_ID " +
      "          AND o.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ol.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND o.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND o.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND o.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(o.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ol.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(o.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND o.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND ol.DateOrdered >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND ol.DateOrdered < to_date(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND ol.PRICEACTUAL*ol.QTYORDERED >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND ol.PRICEACTUAL*ol.QTYORDERED <= ?  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ol.M_Product_ID=?  ");
    strSql = strSql + 
      "          AND o.ISSOTRX = 'N'" +
      "          GROUP BY ol.C_ORDERLINE_ID, b.NAME, p.NAME, ol.DATEORDERED, o.DOCUMENTNO, " +
      "          o.ISSOTRX, ol.QTYORDERED, ol.PRICEACTUAL, ol.LINENETAMT, o.GRANDTOTAL, ol.LINE, ol.LINENETAMT" +
      "          HAVING 1=1 ";
    strSql = strSql + ((isdelivered.equals("isdelivered"))?"  AND (ol.QTYORDERED - COALESCE(SUM(mp2.QTY), 0)) <> 0  ":"");
    strSql = strSql + ((isinvoiced.equals("isinvoiced"))?"  AND (ol.QTYORDERED - COALESCE(SUM(mp.QTY),0)) <> 0  ":"");
    strSql = strSql + 
      "          ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "		) A ) B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<SalesOrderLineData> vector = new Vector<SalesOrderLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (grandTotalFrom != null && !(grandTotalFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotalFrom);
      }
      if (grandTotalTo != null && !(grandTotalTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotalTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (isdelivered != null && !(isdelivered.equals(""))) {
        }
      if (isinvoiced != null && !(isinvoiced.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
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
        SalesOrderLineData objectSalesOrderLineData = new SalesOrderLineData();
        objectSalesOrderLineData.rn1 = UtilSql.getValue(result, "rn1");
        objectSalesOrderLineData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectSalesOrderLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectSalesOrderLineData.productName = UtilSql.getValue(result, "product_name");
        objectSalesOrderLineData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSalesOrderLineData.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderLineData.qty = UtilSql.getValue(result, "qty");
        objectSalesOrderLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectSalesOrderLineData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectSalesOrderLineData.lineText = UtilSql.getValue(result, "line_text");
        objectSalesOrderLineData.rowkey = UtilSql.getValue(result, "rowkey");
        objectSalesOrderLineData.position = Long.toString(countRecord);
        objectSalesOrderLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderLineData);
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
    SalesOrderLineData objectSalesOrderLineData[] = new SalesOrderLineData[vector.size()];
    vector.copyInto(objectSalesOrderLineData);
    return(objectSalesOrderLineData);
  }

  public static SalesOrderLineData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, key, 0, 0);
  }

  public static SalesOrderLineData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ol.C_ORDERLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, o.DATEORDERED, o.DOCUMENTNO, " +
      "        o.ISSOTRX, ol.QTYORDERED AS QTY, ol.PRICEACTUAL, ol.LINENETAMT, " +
      "        (o.DOCUMENTNO || ' - ' || o.DATEORDERED || ' - ' || o.GRANDTOTAL || ' - ' || ol.LINE || ' - ' || ol.LINENETAMT) AS LINE_TEXT" +
      "        FROM C_ORDER o, C_ORDERLINE ol, M_PRODUCT p, C_BPARTNER b" +
      "        WHERE o.C_ORDER_ID = ol.C_ORDER_ID " +
      "        AND o.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "        AND ol.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "        AND o.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND o.IsActive='Y' " +
      "        AND UPPER(o.DOCUMENTNO) LIKE UPPER(?) " +
      "        AND (ol.QTYORDERED - COALESCE(ol.QTYINVOICED, 0)) > 0 " +
      "        AND (ol.QTYORDERED - COALESCE(ol.QTYDELIVERED, 0)) > 0 " +
      "        AND o.ISSOTRX = 'Y'" +
      "        ORDER BY b.NAME, o.DATEORDERED, o.DOCUMENTNO, ol.LINE";

    ResultSet result;
    Vector<SalesOrderLineData> vector = new Vector<SalesOrderLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        SalesOrderLineData objectSalesOrderLineData = new SalesOrderLineData();
        objectSalesOrderLineData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectSalesOrderLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectSalesOrderLineData.productName = UtilSql.getValue(result, "product_name");
        objectSalesOrderLineData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSalesOrderLineData.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderLineData.qty = UtilSql.getValue(result, "qty");
        objectSalesOrderLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectSalesOrderLineData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectSalesOrderLineData.lineText = UtilSql.getValue(result, "line_text");
        objectSalesOrderLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderLineData);
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
    SalesOrderLineData objectSalesOrderLineData[] = new SalesOrderLineData[vector.size()];
    vector.copyInto(objectSalesOrderLineData);
    return(objectSalesOrderLineData);
  }

  public static SalesOrderLineData[] selectKeySOTrx(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKeySOTrx(connectionProvider, adUserClient, adUserOrg, key, 0, 0);
  }

  public static SalesOrderLineData[] selectKeySOTrx(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ol.C_ORDERLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, o.DATEORDERED, o.DOCUMENTNO, " +
      "        o.ISSOTRX, ol.QTYORDERED AS QTY, ol.PRICEACTUAL, ol.LINENETAMT, " +
      "        (o.DOCUMENTNO || ' - ' || o.DATEORDERED || ' - ' || o.GRANDTOTAL || ' - ' || ol.LINE || ' - ' || ol.LINENETAMT) AS LINE_TEXT" +
      "        FROM  C_ORDERLINE ol left join M_MATCHPO mp on ol.C_ORDERLINE_ID = mp.C_ORDERLINE_ID " +
      "                                                    AND mp.C_INVOICELINE_ID  IS NOT NULL" +
      "                             left join M_MATCHPO mp2 on  ol.C_ORDERLINE_ID = mp2.C_ORDERLINE_ID " +
      "                                                     and mp2.M_INOUTLINE_ID IS NOT NULL," +
      "              C_ORDER o, M_PRODUCT p, C_BPARTNER b " +
      "        WHERE o.C_ORDER_ID = ol.C_ORDER_ID " +
      "        AND o.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "        AND ol.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "        AND o.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND o.IsActive='Y' " +
      "        AND UPPER(o.DOCUMENTNO) LIKE UPPER(?) " +
      "        AND o.ISSOTRX = 'N'" +
      "        GROUP BY ol.C_ORDERLINE_ID, b.NAME, p.NAME, o.DATEORDERED, o.DOCUMENTNO, " +
      "        o.ISSOTRX, ol.QTYORDERED, ol.PRICEACTUAL, ol.LINENETAMT, o.GRANDTOTAL, ol.LINE, ol.LINENETAMT" +
      "        HAVING (ol.QTYORDERED - COALESCE(SUM(mp.QTY),0)) > 0 " +
      "        AND (ol.QTYORDERED - COALESCE(SUM(mp2.QTY), 0)) > 0" +
      "        ORDER BY b.NAME, o.DATEORDERED, o.DOCUMENTNO, ol.LINE";

    ResultSet result;
    Vector<SalesOrderLineData> vector = new Vector<SalesOrderLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        SalesOrderLineData objectSalesOrderLineData = new SalesOrderLineData();
        objectSalesOrderLineData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectSalesOrderLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectSalesOrderLineData.productName = UtilSql.getValue(result, "product_name");
        objectSalesOrderLineData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSalesOrderLineData.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderLineData.qty = UtilSql.getValue(result, "qty");
        objectSalesOrderLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectSalesOrderLineData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectSalesOrderLineData.lineText = UtilSql.getValue(result, "line_text");
        objectSalesOrderLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderLineData);
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
    SalesOrderLineData objectSalesOrderLineData[] = new SalesOrderLineData[vector.size()];
    vector.copyInto(objectSalesOrderLineData);
    return(objectSalesOrderLineData);
  }

  public static String selectBPartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID=?";

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

  public static String selectProduct(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM M_PRODUCT WHERE M_PRODUCT_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
