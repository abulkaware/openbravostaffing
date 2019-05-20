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

class ReportInvoicesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportInvoicesData.class);
  private String InitRecordNumber="0";
  public String namebpartner;
  public String invoiceid;
  public String invoicedocumentno;
  public String docnoorder;
  public String descriptioninvoice;
  public String dateinvoiced;
  public String line;
  public String nameproduct;
  public String qtyinvoiced;
  public String uomsymbol;
  public String aumqty;
  public String aum;
  public String priceactual;
  public String convpriceactual;
  public String tax;
  public String base;
  public String convbase;
  public String linenetamt;
  public String convlinenetamt;
  public String convsym;
  public String convisosym;
  public String invoicecurrencysym;
  public String transcurrencyid;
  public String transdate;
  public String transclientid;
  public String transorgid;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("namebpartner"))
      return namebpartner;
    else if (fieldName.equalsIgnoreCase("invoiceid"))
      return invoiceid;
    else if (fieldName.equalsIgnoreCase("invoicedocumentno"))
      return invoicedocumentno;
    else if (fieldName.equalsIgnoreCase("docnoorder"))
      return docnoorder;
    else if (fieldName.equalsIgnoreCase("descriptioninvoice"))
      return descriptioninvoice;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("nameproduct"))
      return nameproduct;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("uomsymbol"))
      return uomsymbol;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("convpriceactual"))
      return convpriceactual;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("base"))
      return base;
    else if (fieldName.equalsIgnoreCase("convbase"))
      return convbase;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("convlinenetamt"))
      return convlinenetamt;
    else if (fieldName.equalsIgnoreCase("convsym"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
    else if (fieldName.equalsIgnoreCase("invoicecurrencysym"))
      return invoicecurrencysym;
    else if (fieldName.equalsIgnoreCase("transcurrencyid"))
      return transcurrencyid;
    else if (fieldName.equalsIgnoreCase("transdate"))
      return transdate;
    else if (fieldName.equalsIgnoreCase("transclientid"))
      return transclientid;
    else if (fieldName.equalsIgnoreCase("transorgid"))
      return transorgid;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportInvoicesData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String parBGroupId, String parPCategoryId, String parBPartnerId, String parMProductId, String parDateFrom, String parDateTo, String parDocNo, String sales, String purchase)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserClient, adUserOrg, parBGroupId, parPCategoryId, parBPartnerId, parMProductId, parDateFrom, parDateTo, parDocNo, sales, purchase, 0, 0);
  }

  public static ReportInvoicesData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String parBGroupId, String parPCategoryId, String parBPartnerId, String parMProductId, String parDateFrom, String parDateTo, String parDocNo, String sales, String purchase, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAMEBPARTNER,INVOICEID, INVOICEDOCUMENTNO, DOCNOORDER, DESCRIPTIONINVOICE, DATEINVOICED, LINE, NAMEPRODUCT, " +
      "	  QTYINVOICED, UOMSYMBOL, AUMQTY, AUM, PRICEACTUAL, CONVPRICEACTUAL, TAX, BASE, CONVBASE, LINENETAMT, CONVLINENETAMT," +
      "	  C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM, C_CURRENCY_ISOSYM(?) AS CONVISOSYM, INVOICECURRENCYSYM," +
      "	  TRANSCURRENCYID, TRANSDATE, TRANSCLIENTID, TRANSORGID" +
      "	  FROM (      " +
      "	  SELECT B.NAME AS NAMEBPARTNER, I.C_INVOICE_ID AS INVOICEID, I.DOCUMENTNO AS INVOICEDOCUMENTNO, O.DOCUMENTNO AS DOCNOORDER," +
      "	  I.DESCRIPTION AS DESCRIPTIONINVOICE, I.DATEINVOICED AS DATEINVOICED, C_INVOICELINE.LINE, COALESCE(P.NAME, C_GLITEM.NAME) AS NAMEPRODUCT," +
      "	  IL.QTYINVOICED AS QTYINVOICED, TO_CHAR(C_UOM.UOMSYMBOL) AS UOMSYMBOL," +
      "	  C_INVOICELINE.AUMQTY AS AUMQTY," +
      "	  CASE WHEN C_INVOICELINE.C_AUM IS NULL THEN NULL ELSE (SELECT u.UOMSYMBOL FROM C_UOM u WHERE u.C_UOM_ID = C_INVOICELINE.C_AUM) END AS AUM," +
      "	  IL.PRICEACTUAL AS PRICEACTUAL," +
      "	  C_CURRENCY_CONVERT(IL.PRICEACTUAL, I.C_CURRENCY_ID, ?, TO_DATE(COALESCE(I.DATEINVOICED, NOW())), NULL, IL.AD_CLIENT_ID, IL.AD_ORG_ID) AS CONVPRICEACTUAL, " +
      "	  C_TAX.RATE AS TAX, IL.LINENETAMT AS LINENETAMT," +
      "	  C_CURRENCY_CONVERT(IL.LINENETAMT, I.C_CURRENCY_ID, ?, TO_DATE(COALESCE(I.DATEINVOICED, NOW())), NULL, IL.AD_CLIENT_ID, IL.AD_ORG_ID) AS CONVLINENETAMT,      " +
      "	  NULL AS BASE, NULL AS CONVBASE," +
      "	  C_CURRENCY_SYMBOL(I.C_CURRENCY_ID, 0, 'Y') AS INVOICECURRENCYSYM," +
      "	  I.C_CURRENCY_ID AS TRANSCURRENCYID," +
      "	  TO_DATE(COALESCE(I.DATEINVOICED, NOW())) AS TRANSDATE," +
      "	  IL.AD_CLIENT_ID AS TRANSCLIENTID," +
      "	  IL.AD_ORG_ID AS TRANSORGID " +
      "      FROM C_INVOICE I left join C_ORDER O on I.C_ORDER_ID = O.C_ORDER_ID" +
      "                       right join C_INVOICELINE_V2 IL on IL.C_INVOICE_ID = I.C_INVOICE_ID" +
      "                       left join M_PRODUCT P ON IL.M_PRODUCT_ID = P.M_PRODUCT_ID" +
      "                       left join C_GLITEM on IL.ACCOUNT_ID = C_GLITEM.C_GLITEM_ID," +
      "           C_BPARTNER B,  C_UOM, C_INVOICELINE, C_TAX" +
      "      WHERE IL.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "      AND IL.C_INVOICELINE_ID = C_INVOICELINE.C_INVOICELINE_ID" +
      "      AND (C_INVOICELINE.M_PRODUCT_ID IS NOT NULL OR C_INVOICELINE.ACCOUNT_ID IS NOT NULL)" +
      "      AND C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_INVOICELINE.C_TAX_ID = C_TAX.C_TAX_ID" +
      "      AND I.DOCSTATUS <> 'TEMP'" +
      "      AND I.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND I.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parBGroupId==null || parBGroupId.equals(""))?"":" AND B.C_BP_GROUP_ID= ? ");
    strSql = strSql + ((parPCategoryId==null || parPCategoryId.equals(""))?"":" AND P.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((parBPartnerId==null || parBPartnerId.equals(""))?"":" AND B.C_BPARTNER_ID = ? ");
    strSql = strSql + ((parMProductId==null || parMProductId.equals(""))?"":" AND P.M_PRODUCT_ID = ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND I.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND I.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((parDocNo==null || parDocNo.equals(""))?"":" AND I.DOCUMENTNO = ? ");
    strSql = strSql + ((sales.equals("sales"))?" AND I.ISSOTRX = 'Y' ":"");
    strSql = strSql + ((purchase.equals("purchase"))?" AND I.ISSOTRX = 'N' ":"");
    strSql = strSql + 
      "      UNION " +
      "      SELECT B.NAME AS NAMEBPARTNER, I2.C_INVOICE_ID AS INVOICEID, I2.DOCUMENTNO AS INVOICEDOCUMENTNO, O.DOCUMENTNO AS DOCNOORDER, " +
      "	  I2.DESCRIPTION AS DESCRIPTIONINVOICE, I2.DATEINVOICED AS DATEINVOICED, NULL AS LINE, " +
      "	  C_TAX.NAME AS NAMEPRODUCT, NULL AS QTYINVOICED, NULL AS UOMSYMBOL, NULL AS AUMQTY, NULL AS AUM, NULL AS PRICEACTUAL, NULL AS CONVPRICEATUAL," +
      "	  NULL AS TAX, C_INVOICETAX.TAXAMT AS LINENETAMT, " +
      "	  C_CURRENCY_CONVERT(C_INVOICETAX.TAXAMT, I2.C_CURRENCY_ID, ?, TO_DATE(COALESCE(I2.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID) AS CONVLINENETAMT, " +
      "	  C_INVOICETAX.TAXBASEAMT AS BASE,      " +
      "	  C_CURRENCY_CONVERT(C_INVOICETAX.TAXBASEAMT, I2.C_CURRENCY_ID, ?, TO_DATE(COALESCE(I2.DATEINVOICED, NOW())), NULL, C_INVOICETAX.AD_CLIENT_ID, C_INVOICETAX.AD_ORG_ID) AS CONVBASE," +
      "	  C_CURRENCY_SYMBOL(I2.C_CURRENCY_ID, 0, 'Y') AS INVOICECURRENCYSYM," +
      "	  I2.C_CURRENCY_ID AS TRANSCURRENCYID," +
      "	  TO_DATE(COALESCE(I2.DATEINVOICED, NOW())) AS TRANSDATE," +
      "	  C_INVOICETAX.AD_CLIENT_ID AS TRANSCLIENTID," +
      "	  C_INVOICETAX.AD_ORG_ID AS TRANSORGID" +
      "      FROM C_INVOICE I2 left join C_INVOICELINE_V2 IL on IL.C_INVOICE_ID = I2.C_INVOICE_ID" +
      "                        left join M_PRODUCT p         on IL.M_PRODUCT_ID = P.M_PRODUCT_ID" +
      "                        left join C_ORDER O           on I2.C_ORDER_ID = O.C_ORDER_ID," +
      "           C_BPARTNER B, C_TAX, C_INVOICETAX" +
      "      WHERE IL.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "      AND C_INVOICETAX.C_INVOICE_ID= I2.C_INVOICE_ID" +
      "      AND (IL.M_PRODUCT_ID IS NOT NULL OR IL.ACCOUNT_ID IS NOT NULL)" +
      "      AND C_INVOICETAX.C_TAX_ID = C_TAX.C_TAX_ID" +
      "      AND I2.DOCSTATUS <> 'TEMP'" +
      "      AND I2.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND I2.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 2=2";
    strSql = strSql + ((parBGroupId==null || parBGroupId.equals(""))?"":" AND B.C_BP_GROUP_ID= ? ");
    strSql = strSql + ((parPCategoryId==null || parPCategoryId.equals(""))?"":" AND P.M_PRODUCT_CATEGORY_ID = ? ");
    strSql = strSql + ((parBPartnerId==null || parBPartnerId.equals(""))?"":" AND B.C_BPARTNER_ID = ? ");
    strSql = strSql + ((parMProductId==null || parMProductId.equals(""))?"":" AND P.M_PRODUCT_ID = ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND I2.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND I2.DATEINVOICED < to_date(?) ");
    strSql = strSql + ((parDocNo==null || parDocNo.equals(""))?"":" AND I2.DOCUMENTNO = ? ");
    strSql = strSql + ((sales.equals("sales"))?" AND I2.ISSOTRX = 'Y' ":"");
    strSql = strSql + ((purchase.equals("purchase"))?" AND I2.ISSOTRX = 'N' ":"");
    strSql = strSql + 
      ") A" +
      "      ORDER BY NAMEBPARTNER, INVOICEDOCUMENTNO, LINE";

    ResultSet result;
    Vector<ReportInvoicesData> vector = new Vector<ReportInvoicesData>(0);
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
      if (parBGroupId != null && !(parBGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBGroupId);
      }
      if (parPCategoryId != null && !(parPCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPCategoryId);
      }
      if (parBPartnerId != null && !(parBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartnerId);
      }
      if (parMProductId != null && !(parMProductId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parMProductId);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parDocNo != null && !(parDocNo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDocNo);
      }
      if (sales != null && !(sales.equals(""))) {
        }
      if (purchase != null && !(purchase.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBGroupId != null && !(parBGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBGroupId);
      }
      if (parPCategoryId != null && !(parPCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPCategoryId);
      }
      if (parBPartnerId != null && !(parBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartnerId);
      }
      if (parMProductId != null && !(parMProductId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parMProductId);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parDocNo != null && !(parDocNo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDocNo);
      }
      if (sales != null && !(sales.equals(""))) {
        }
      if (purchase != null && !(purchase.equals(""))) {
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
        ReportInvoicesData objectReportInvoicesData = new ReportInvoicesData();
        objectReportInvoicesData.namebpartner = UtilSql.getValue(result, "namebpartner");
        objectReportInvoicesData.invoiceid = UtilSql.getValue(result, "invoiceid");
        objectReportInvoicesData.invoicedocumentno = UtilSql.getValue(result, "invoicedocumentno");
        objectReportInvoicesData.docnoorder = UtilSql.getValue(result, "docnoorder");
        objectReportInvoicesData.descriptioninvoice = UtilSql.getValue(result, "descriptioninvoice");
        objectReportInvoicesData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectReportInvoicesData.line = UtilSql.getValue(result, "line");
        objectReportInvoicesData.nameproduct = UtilSql.getValue(result, "nameproduct");
        objectReportInvoicesData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectReportInvoicesData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectReportInvoicesData.aumqty = UtilSql.getValue(result, "aumqty");
        objectReportInvoicesData.aum = UtilSql.getValue(result, "aum");
        objectReportInvoicesData.priceactual = UtilSql.getValue(result, "priceactual");
        objectReportInvoicesData.convpriceactual = UtilSql.getValue(result, "convpriceactual");
        objectReportInvoicesData.tax = UtilSql.getValue(result, "tax");
        objectReportInvoicesData.base = UtilSql.getValue(result, "base");
        objectReportInvoicesData.convbase = UtilSql.getValue(result, "convbase");
        objectReportInvoicesData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectReportInvoicesData.convlinenetamt = UtilSql.getValue(result, "convlinenetamt");
        objectReportInvoicesData.convsym = UtilSql.getValue(result, "convsym");
        objectReportInvoicesData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportInvoicesData.invoicecurrencysym = UtilSql.getValue(result, "invoicecurrencysym");
        objectReportInvoicesData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportInvoicesData.transdate = UtilSql.getDateValue(result, "transdate", "dd-MM-yyyy");
        objectReportInvoicesData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportInvoicesData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportInvoicesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoicesData);
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
    ReportInvoicesData objectReportInvoicesData[] = new ReportInvoicesData[vector.size()];
    vector.copyInto(objectReportInvoicesData);
    return(objectReportInvoicesData);
  }

  public static ReportInvoicesData[] set()    throws ServletException {
    ReportInvoicesData objectReportInvoicesData[] = new ReportInvoicesData[1];
    objectReportInvoicesData[0] = new ReportInvoicesData();
    objectReportInvoicesData[0].namebpartner = "";
    objectReportInvoicesData[0].invoiceid = "";
    objectReportInvoicesData[0].invoicedocumentno = "";
    objectReportInvoicesData[0].docnoorder = "";
    objectReportInvoicesData[0].descriptioninvoice = "";
    objectReportInvoicesData[0].dateinvoiced = "";
    objectReportInvoicesData[0].line = "";
    objectReportInvoicesData[0].nameproduct = "";
    objectReportInvoicesData[0].qtyinvoiced = "";
    objectReportInvoicesData[0].uomsymbol = "";
    objectReportInvoicesData[0].aumqty = "";
    objectReportInvoicesData[0].aum = "";
    objectReportInvoicesData[0].priceactual = "";
    objectReportInvoicesData[0].convpriceactual = "";
    objectReportInvoicesData[0].tax = "";
    objectReportInvoicesData[0].base = "";
    objectReportInvoicesData[0].convbase = "";
    objectReportInvoicesData[0].linenetamt = "";
    objectReportInvoicesData[0].convlinenetamt = "";
    objectReportInvoicesData[0].convsym = "";
    objectReportInvoicesData[0].convisosym = "";
    objectReportInvoicesData[0].invoicecurrencysym = "";
    objectReportInvoicesData[0].transcurrencyid = "";
    objectReportInvoicesData[0].transdate = "";
    objectReportInvoicesData[0].transclientid = "";
    objectReportInvoicesData[0].transorgid = "";
    return objectReportInvoicesData;
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

  public static String mProductDescription(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM M_PRODUCT" +
      "    WHERE M_PRODUCT_ID = ?";

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
