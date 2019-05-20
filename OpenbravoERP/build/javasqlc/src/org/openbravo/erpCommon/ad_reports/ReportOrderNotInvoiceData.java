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

class ReportOrderNotInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportOrderNotInvoiceData.class);
  private String InitRecordNumber="0";
  public String orgname;
  public String cBpartnerId;
  public String bpartnername;
  public String cOrderId;
  public String documentno;
  public String dateordered;
  public String grandtotal;
  public String convgrandtotal;
  public String invoicerule;
  public String line;
  public String product;
  public String price;
  public String convprice;
  public String qtyordered;
  public String uomsymbol;
  public String tax;
  public String taxbase;
  public String convtaxbase;
  public String linenetamt;
  public String convlinenetamt;
  public String ordercurrencysym;
  public String transcurrencyidorder;
  public String transdateorder;
  public String transclientidorder;
  public String transorgidorder;
  public String linecurrencysym;
  public String transcurrencyidline;
  public String transdateline;
  public String transclientidline;
  public String transorgidline;
  public String convsym;
  public String convisosym;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("orgname"))
      return orgname;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("convgrandtotal"))
      return convgrandtotal;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("convprice"))
      return convprice;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("uomsymbol"))
      return uomsymbol;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("taxbase"))
      return taxbase;
    else if (fieldName.equalsIgnoreCase("convtaxbase"))
      return convtaxbase;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("convlinenetamt"))
      return convlinenetamt;
    else if (fieldName.equalsIgnoreCase("ordercurrencysym"))
      return ordercurrencysym;
    else if (fieldName.equalsIgnoreCase("transcurrencyidorder"))
      return transcurrencyidorder;
    else if (fieldName.equalsIgnoreCase("transdateorder"))
      return transdateorder;
    else if (fieldName.equalsIgnoreCase("transclientidorder"))
      return transclientidorder;
    else if (fieldName.equalsIgnoreCase("transorgidorder"))
      return transorgidorder;
    else if (fieldName.equalsIgnoreCase("linecurrencysym"))
      return linecurrencysym;
    else if (fieldName.equalsIgnoreCase("transcurrencyidline"))
      return transcurrencyidline;
    else if (fieldName.equalsIgnoreCase("transdateline"))
      return transdateline;
    else if (fieldName.equalsIgnoreCase("transclientidline"))
      return transclientidline;
    else if (fieldName.equalsIgnoreCase("transorgidline"))
      return transorgidline;
    else if (fieldName.equalsIgnoreCase("convsym"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportOrderNotInvoiceData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String cBpartnerId, String cOrgId, String invoiceRule, String dateFrom, String dateTo, String adLanguage)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserClient, adUserOrg, cBpartnerId, cOrgId, invoiceRule, dateFrom, dateTo, adLanguage, 0, 0);
  }

  public static ReportOrderNotInvoiceData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String cBpartnerId, String cOrgId, String invoiceRule, String dateFrom, String dateTo, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT ORGNAME, C_BPARTNER_ID, BPARTNERNAME, C_ORDER_ID, DOCUMENTNO," +
      "       DATEORDERED, GRANDTOTAL, CONVGRANDTOTAL, INVOICERULE, LINE, PRODUCT, PRICE, CONVPRICE," +
      "       QTYORDERED, UOMSYMBOL, TAX, TAXBASE, CONVTAXBASE, LINENETAMT, CONVLINENETAMT," +
      "       ORDERCURRENCYSYM, TRANSCURRENCYIDORDER, TRANSDATEORDER, TRANSCLIENTIDORDER, TRANSORGIDORDER," +
      "       LINECURRENCYSYM, TRANSCURRENCYIDLINE, TRANSDATELINE, TRANSCLIENTIDLINE," +
      "       TRANSORGIDLINE, C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM, C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "     FROM" +
      "       (" +
      "         WITH pendingOrders AS" +
      "         (" +
      "           SELECT C.C_ORDER_ID, C.DOCUMENTNO, C.DATEORDERED, C.GRANDTOTAL," +
      "             C.C_CURRENCY_ID, C.AD_CLIENT_ID, C.AD_ORG_ID, C.C_BPARTNER_ID, C.INVOICERULE," +
      "             CL.LINE, CL.AD_CLIENT_ID AS CL_AD_CLIENT_ID, CL.AD_ORG_ID AS CL_AD_ORG_ID," +
      "             CL.C_CURRENCY_ID AS CL_C_CURRENCY_ID, CL.LINENETAMT, CL.QTYORDERED," +
      "             CL.QTYINVOICED, CL.PRICEACTUAL, CL.M_PRODUCT_ID, CL.C_UOM_ID," +
      "             AD_REF_LIST.AD_REF_LIST_ID," +
      "             AD_REF_LIST.NAME AS INVOICERULENAME" +
      "           FROM c_order C JOIN C_Orderline CL on CL.C_Order_ID = C.C_Order_ID" +
      "             JOIN AD_REF_LIST ON C.INVOICERULE = AD_REF_LIST.VALUE" +
      "             AND AD_REF_LIST.AD_REFERENCE_ID = '150'" +
      "           WHERE  C.invoicerule <> 'N'" +
      "             AND C.processed = 'Y'" +
      "             AND C.docstatus NOT IN ( 'CJ', 'UE', 'CA', 'DR', 'CL')" +
      "             AND C.issotrx = 'Y'" +
      "             AND OBEQUALS(cl.qtyordered, cl.qtyinvoiced) = 'N'" +
      "             AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "             AND C.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "             AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":" AND C.C_BPARTNER_ID = ? ");
    strSql = strSql + ((cOrgId==null || cOrgId.equals(""))?"":" AND C.AD_ORG_ID = ? ");
    strSql = strSql + ((invoiceRule==null || invoiceRule.equals(""))?"":" AND C.INVOICERULE = ? ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND C.DATEORDERED >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND C.DATEORDERED < to_date(?)  ");
    strSql = strSql + 
      "        )" +
      "        SELECT AD_ORG.NAME AS ORGNAME, C_BPARTNER.C_BPARTNER_ID, C_BPARTNER.NAME AS BPARTNERNAME," +
      "          pendingOrders.C_ORDER_ID, pendingOrders.DOCUMENTNO, pendingOrders.DATEORDERED," +
      "          pendingOrders.GRANDTOTAL," +
      "          CASE WHEN pendingorders.C_CURRENCY_ID = ? THEN pendingorders.GRANDTOTAL ELSE C_CURRENCY_CONVERT(pendingorders.GRANDTOTAL, pendingorders.C_CURRENCY_ID, ?, TO_DATE(COALESCE(pendingorders.DATEORDERED, NOW())), NULL, pendingorders.AD_CLIENT_ID, pendingorders.AD_ORG_ID) END AS CONVGRANDTOTAL," +
      "          CASE WHEN pendingOrders.INVOICERULE = 'S' THEN COALESCE(AD_REF_LIST_TRL.NAME, pendingOrders.INVOICERULENAME)||' ('||C_INVOICESCHEDULE.NAME||')'" +
      "               ELSE COALESCE(AD_REF_LIST_TRL.NAME, pendingOrders.INVOICERULENAME) END AS INVOICERULE," +
      "          pendingOrders.LINE AS LINE," +
      "          COALESCE(P.NAME, P.DESCRIPTION) AS PRODUCT, pendingOrders.PRICEACTUAL AS PRICE," +
      "          CASE WHEN COALESCE(pendingOrders.CL_C_CURRENCY_ID, pendingorders.C_CURRENCY_ID) = ? THEN pendingOrders.PRICEACTUAL ELSE C_CURRENCY_CONVERT(pendingOrders.PRICEACTUAL, COALESCE(pendingOrders.CL_C_CURRENCY_ID, pendingorders.C_CURRENCY_ID), ?, TO_DATE(COALESCE(pendingorders.DATEORDERED, NOW())), NULL, pendingOrders.CL_AD_CLIENT_ID, pendingOrders.CL_AD_ORG_ID) END AS CONVPRICE," +
      "          pendingOrders.QTYORDERED - pendingOrders.QTYINVOICED AS QTYORDERED," +
      "          U.UOMSYMBOL, NULL AS TAX, NULL AS TAXBASE, NULL AS CONVTAXBASE, pendingOrders.LINENETAMT," +
      "          CASE WHEN COALESCE(pendingOrders.CL_C_CURRENCY_ID, pendingorders.C_CURRENCY_ID) = ? THEN pendingOrders.LINENETAMT ELSE C_CURRENCY_CONVERT(pendingOrders.LINENETAMT, COALESCE(pendingOrders.CL_C_CURRENCY_ID, pendingorders.C_CURRENCY_ID), ?, TO_DATE(COALESCE(pendingorders.DATEORDERED, NOW())), NULL, pendingOrders.CL_AD_CLIENT_ID, pendingOrders.CL_AD_ORG_ID) END AS CONVLINENETAMT," +
      "          C_CURRENCY_SYMBOL(pendingorders.C_CURRENCY_ID, 0, 'Y') AS ORDERCURRENCYSYM," +
      "          pendingorders.C_CURRENCY_ID AS TRANSCURRENCYIDORDER, pendingorders.DATEORDERED AS TRANSDATEORDER," +
      "          pendingorders.AD_CLIENT_ID AS TRANSCLIENTIDORDER, pendingorders.AD_ORG_ID AS TRANSORGIDORDER," +
      "          C_CURRENCY_SYMBOL(COALESCE(pendingOrders.CL_C_CURRENCY_ID, pendingorders.C_CURRENCY_ID), 0, 'Y') AS LINECURRENCYSYM," +
      "          COALESCE(pendingOrders.CL_C_CURRENCY_ID, pendingorders.C_CURRENCY_ID) AS TRANSCURRENCYIDLINE," +
      "          TO_DATE(COALESCE(pendingorders.DATEORDERED, NOW())) AS TRANSDATELINE," +
      "          pendingOrders.CL_AD_CLIENT_ID AS TRANSCLIENTIDLINE, pendingOrders.CL_AD_ORG_ID AS TRANSORGIDLINE" +
      "        FROM pendingOrders join m_product p on p.m_product_id = pendingOrders.m_product_id" +
      "          join c_uom u on u.c_uom_id = pendingOrders.c_uom_id" +
      "          LEFT JOIN AD_REF_LIST_TRL ON pendingOrders.AD_REF_LIST_ID = AD_REF_LIST_TRL.AD_REF_LIST_ID" +
      "            AND AD_REF_LIST_TRL.AD_LANGUAGE = ?," +
      "          C_BPARTNER LEFT JOIN C_INVOICESCHEDULE ON C_BPARTNER.C_INVOICESCHEDULE_ID = C_INVOICESCHEDULE.C_INVOICESCHEDULE_ID," +
      "          AD_ORG" +
      "        WHERE pendingorders.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "          AND pendingorders.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "       UNION ALL" +
      "         SELECT MAX(AD_ORG.NAME) AS ORGNAME, MAX(C_BPARTNER.C_BPARTNER_ID) AS C_BPARTNER_ID, MAX(C_BPARTNER.NAME) AS BPARTNERNAME," +
      "           pendingOrders.C_ORDER_ID AS C_ORDER_ID, MAX(pendingOrders.DOCUMENTNO) AS DOCUMENTNO," +
      "           MAX(pendingOrders.DATEORDERED) AS DATEORDERED, MAX(pendingOrders.GRANDTOTAL) AS GRANDTOTAL," +
      "           CASE WHEN MAX(pendingOrders.C_CURRENCY_ID) = ? THEN MAX(pendingOrders.GRANDTOTAL)" +
      "             ELSE C_CURRENCY_CONVERT(MAX(pendingOrders.GRANDTOTAL), MAX(pendingOrders.C_CURRENCY_ID), ?, TO_DATE(COALESCE(MAX(pendingOrders.DATEORDERED), NOW())), NULL, MAX(pendingOrders.AD_CLIENT_ID), MAX(pendingOrders.AD_ORG_ID)) END AS CONVGRANDTOTAL," +
      "           CASE WHEN MAX(pendingOrders.INVOICERULE) = 'S'" +
      "             THEN COALESCE(MAX(AD_REF_LIST_TRL.NAME), MAX(pendingOrders.INVOICERULENAME))||' ('||MAX(C_INVOICESCHEDULE.NAME)||')'" +
      "		     ELSE COALESCE(MAX(AD_REF_LIST_TRL.NAME), MAX(pendingOrders.INVOICERULENAME)) END AS INVOICERULE," +
      "           NULL AS LINE, MAX(C_TAX.NAME) AS PRODUCT, NULL AS PRICE, NULL AS CONVPRICE, NULL AS QTYORDERED, NULL AS UOMSYMBOL," +
      "           MAX(C_TAX.RATE) AS TAX, MAX(C_ORDERTAX.TAXBASEAMT) AS TAXBASE," +
      "           CASE WHEN MAX(pendingOrders.C_CURRENCY_ID) = ? THEN MAX(C_ORDERTAX.TAXBASEAMT) ELSE C_CURRENCY_CONVERT(MAX(C_ORDERTAX.TAXBASEAMT), MAX(pendingOrders.C_CURRENCY_ID), ?, TO_DATE(COALESCE(MAX(pendingOrders.DATEORDERED), NOW())), NULL, MAX(C_ORDERTAX.AD_CLIENT_ID), MAX(C_ORDERTAX.AD_ORG_ID)) END AS CONVTAXBASE," +
      "           MAX(C_ORDERTAX.TAXAMT) AS LINENETAMT," +
      "           CASE WHEN MAX(pendingOrders.C_CURRENCY_ID) = ? THEN MAX(C_ORDERTAX.TAXAMT) ELSE C_CURRENCY_CONVERT(MAX(C_ORDERTAX.TAXAMT), MAX(pendingOrders.C_CURRENCY_ID), ?, TO_DATE(COALESCE(MAX(pendingOrders.DATEORDERED), NOW())), NULL, MAX(C_ORDERTAX.AD_CLIENT_ID), MAX(C_ORDERTAX.AD_ORG_ID)) END AS CONVLINENETAMT," +
      "           C_CURRENCY_SYMBOL(MAX(pendingOrders.C_CURRENCY_ID), 0, 'Y') AS ORDERCURRENCYSYM, MAX(pendingOrders.C_CURRENCY_ID) AS TRANSCURRENCYIDORDER," +
      "           MAX(pendingOrders.DATEORDERED) AS TRANSDATEORDER, MAX(pendingOrders.AD_CLIENT_ID) AS TRANSCLIENTIDORDER," +
      "           MAX(pendingOrders.AD_ORG_ID) AS TRANSORGIDORDER, C_CURRENCY_SYMBOL(MAX(pendingOrders.C_CURRENCY_ID), 0, 'Y') AS LINECURRENCYSYM," +
      "           MAX(pendingOrders.C_CURRENCY_ID) AS TRANSCURRENCYIDLINE, TO_DATE(COALESCE(MAX(pendingOrders.DATEORDERED), NOW())) AS TRANSDATELINE," +
      "           MAX(C_ORDERTAX.AD_CLIENT_ID) AS TRANSCLIENTIDLINE, MAX(C_ORDERTAX.AD_ORG_ID) AS TRANSORGIDLINE" +
      "         FROM C_BPARTNER LEFT JOIN C_INVOICESCHEDULE ON C_BPARTNER.C_INVOICESCHEDULE_ID = C_INVOICESCHEDULE.C_INVOICESCHEDULE_ID," +
      "           C_ORDERTAX, AD_ORG, C_TAX," +
      "           pendingOrders left join AD_REF_LIST_TRL ON pendingOrders.AD_REF_LIST_ID = AD_REF_LIST_TRL.AD_REF_LIST_ID" +
      "           AND AD_REF_LIST_TRL.AD_LANGUAGE = ?" +
      "         WHERE pendingOrders.C_ORDER_ID = C_ORDERTAX.C_ORDER_ID" +
      "           AND pendingOrders.C_BPARTNER_ID=C_BPARTNER.C_BPARTNER_ID" +
      "           AND C_ORDERTAX.C_TAX_ID = C_TAX.C_TAX_ID" +
      "           AND pendingOrders.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "         GROUP BY pendingOrders.C_ORDER_ID, C_ORDERTAX.C_TAX_ID" +
      "     ) AAA ORDER BY ORGNAME, BPARTNERNAME, DATEORDERED DESC, DOCUMENTNO, LINE";

    ResultSet result;
    Vector<ReportOrderNotInvoiceData> vector = new Vector<ReportOrderNotInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      if (cOrgId != null && !(cOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrgId);
      }
      if (invoiceRule != null && !(invoiceRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceRule);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

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
        ReportOrderNotInvoiceData objectReportOrderNotInvoiceData = new ReportOrderNotInvoiceData();
        objectReportOrderNotInvoiceData.orgname = UtilSql.getValue(result, "orgname");
        objectReportOrderNotInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectReportOrderNotInvoiceData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectReportOrderNotInvoiceData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectReportOrderNotInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectReportOrderNotInvoiceData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectReportOrderNotInvoiceData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectReportOrderNotInvoiceData.convgrandtotal = UtilSql.getValue(result, "convgrandtotal");
        objectReportOrderNotInvoiceData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectReportOrderNotInvoiceData.line = UtilSql.getValue(result, "line");
        objectReportOrderNotInvoiceData.product = UtilSql.getValue(result, "product");
        objectReportOrderNotInvoiceData.price = UtilSql.getValue(result, "price");
        objectReportOrderNotInvoiceData.convprice = UtilSql.getValue(result, "convprice");
        objectReportOrderNotInvoiceData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectReportOrderNotInvoiceData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectReportOrderNotInvoiceData.tax = UtilSql.getValue(result, "tax");
        objectReportOrderNotInvoiceData.taxbase = UtilSql.getValue(result, "taxbase");
        objectReportOrderNotInvoiceData.convtaxbase = UtilSql.getValue(result, "convtaxbase");
        objectReportOrderNotInvoiceData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportOrderNotInvoiceData.convlinenetamt = UtilSql.getValue(result, "convlinenetamt");
        objectReportOrderNotInvoiceData.ordercurrencysym = UtilSql.getValue(result, "ordercurrencysym");
        objectReportOrderNotInvoiceData.transcurrencyidorder = UtilSql.getValue(result, "transcurrencyidorder");
        objectReportOrderNotInvoiceData.transdateorder = UtilSql.getDateValue(result, "transdateorder", "dd-MM-yyyy");
        objectReportOrderNotInvoiceData.transclientidorder = UtilSql.getValue(result, "transclientidorder");
        objectReportOrderNotInvoiceData.transorgidorder = UtilSql.getValue(result, "transorgidorder");
        objectReportOrderNotInvoiceData.linecurrencysym = UtilSql.getValue(result, "linecurrencysym");
        objectReportOrderNotInvoiceData.transcurrencyidline = UtilSql.getValue(result, "transcurrencyidline");
        objectReportOrderNotInvoiceData.transdateline = UtilSql.getDateValue(result, "transdateline", "dd-MM-yyyy");
        objectReportOrderNotInvoiceData.transclientidline = UtilSql.getValue(result, "transclientidline");
        objectReportOrderNotInvoiceData.transorgidline = UtilSql.getValue(result, "transorgidline");
        objectReportOrderNotInvoiceData.convsym = UtilSql.getValue(result, "convsym");
        objectReportOrderNotInvoiceData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportOrderNotInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportOrderNotInvoiceData);
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
    ReportOrderNotInvoiceData objectReportOrderNotInvoiceData[] = new ReportOrderNotInvoiceData[vector.size()];
    vector.copyInto(objectReportOrderNotInvoiceData);
    return(objectReportOrderNotInvoiceData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT max(NAME) as name FROM C_BPARTNER " +
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
