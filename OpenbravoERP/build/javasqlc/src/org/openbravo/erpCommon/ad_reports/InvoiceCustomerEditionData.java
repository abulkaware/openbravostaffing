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

/**
InvoiceCustomerEditionData Class
 */
class InvoiceCustomerEditionData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceCustomerEditionData.class);
  private String InitRecordNumber="0";
  public String documentno;
  public String dateinvoiced;
  public String clientName;
  public String productName;
  public String quantityorder;
  public String uomname;
  public String priceactual;
  public String priceactualsym;
  public String convpriceactual;
  public String pricelist;
  public String pricelistsym;
  public String convpricelist;
  public String convsym;
  public String convisosym;
  public String transdate;
  public String transcurrencyid;
  public String transclientid;
  public String transorgid;
  public String aumqty;
  public String aum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("client_name") || fieldName.equals("clientName"))
      return clientName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("priceactualsym"))
      return priceactualsym;
    else if (fieldName.equalsIgnoreCase("convpriceactual"))
      return convpriceactual;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelistsym"))
      return pricelistsym;
    else if (fieldName.equalsIgnoreCase("convpricelist"))
      return convpricelist;
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
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for invoice customer data
 */
  public static InvoiceCustomerEditionData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String cbPartnerId, String cProjectId, String cProductCategoryId, String cProjectKind, String cProjectPhase, String cProjectStatus, String cProjectPublic, String cRegionId, String salesRep, String productId)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserOrg, adUserClient, dateFrom, dateTo, cbPartnerId, cProjectId, cProductCategoryId, cProjectKind, cProjectPhase, cProjectStatus, cProjectPublic, cRegionId, salesRep, productId, 0, 0);
  }

/**
Select for invoice customer data
 */
  public static InvoiceCustomerEditionData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String cbPartnerId, String cProjectId, String cProductCategoryId, String cProjectKind, String cProjectPhase, String cProjectStatus, String cProjectPublic, String cRegionId, String salesRep, String productId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(C_INVOICE.POREFERENCE, C_INVOICE.DOCUMENTNO) AS DOCUMENTNO, C_INVOICE.DATEINVOICED AS DATEINVOICED, " +
      "      C_BPARTNER.NAME AS CLIENT_NAME, M_PRODUCT.NAME AS PRODUCT_NAME,  CASE WHEN C_DOCTYPE.DOCBASETYPE = 'ARC' THEN SUM(C_INVOICELINE.QTYINVOICED)*-1 ELSE  SUM(C_INVOICELINE.QTYINVOICED) END AS QUANTITYORDER, C_UOM.NAME AS UOMNAME, " +
      "      C_INVOICELINE.PRICEACTUAL AS PRICEACTUAL, " +
      "      C_CURRENCY_SYMBOL(C_INVOICE.C_CURRENCY_ID, C_INVOICELINE.PRICEACTUAL, 'Y') AS PRICEACTUALSYM," +
      "	  C_CURRENCY_CONVERT(C_INVOICELINE.PRICEACTUAL, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID) AS CONVPRICEACTUAL," +
      "      CASE WHEN C_DOCTYPE.DOCBASETYPE = 'ARC' THEN SUM(C_INVOICELINE.LINENETAMT)*-1 ELSE SUM(C_INVOICELINE.LINENETAMT) END AS PRICELIST," +
      "      C_CURRENCY_SYMBOL (C_INVOICE.C_CURRENCY_ID, SUM(C_INVOICELINE.LINENETAMT), 'Y') AS PRICELISTSYM," +
      "	  SUM(C_CURRENCY_CONVERT(CASE WHEN C_DOCTYPE.DOCBASETYPE = 'ARC' THEN C_INVOICELINE.LINENETAMT*-1 ELSE C_INVOICELINE.LINENETAMT END, C_INVOICE.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID)) AS CONVPRICELIST," +
      "	  C_CURRENCY_SYMBOL(?, '0', 'Y') AS CONVSYM," +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRANSDATE," +
      "	  C_INVOICE.C_CURRENCY_ID AS TRANSCURRENCYID," +
      "      C_INVOICELINE.AD_CLIENT_ID AS TRANSCLIENTID, " +
      "	  C_INVOICELINE.AD_ORG_ID AS TRANSORGID," +
      "	  C_INVOICELINE.AUMQTY," +
      "	  (CASE WHEN COALESCE(C_INVOICELINE.C_AUM,'0') = '0' THEN NULL ELSE (SELECT NAME FROM C_UOM WHERE C_UOM_ID = C_INVOICELINE.C_AUM) END ) AS AUM" +
      "      FROM C_INVOICE LEFT JOIN C_PROJECT ON C_INVOICE.C_PROJECT_ID = C_PROJECT.C_PROJECT_ID " +
      "                     LEFT JOIN C_LOCATION ON C_PROJECT.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID" +
      "                     LEFT JOIN C_DOCTYPE ON C_INVOICE.C_DOCTYPE_ID = C_DOCTYPE.C_DOCTYPE_ID," +
      "                     C_INVOICELINE, M_PRODUCT, C_UOM, C_BPARTNER" +
      "      WHERE C_INVOICE.C_INVOICE_ID = C_INVOICELINE.C_INVOICE_ID" +
      "      AND C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND C_INVOICELINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID      " +
      "      AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.ISSOTRX = 'Y'" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND C_INVOICE.DATEINVOICED >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND C_INVOICE.DATEINVOICED <= to_date(?) ");
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + cbPartnerId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_PROJECT.C_PROJECT_ID = ? ");
    strSql = strSql + ((cProductCategoryId==null || cProductCategoryId.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_CATEGORY_ID IN" + cProductCategoryId);
    strSql = strSql + ((cProjectKind==null || cProjectKind.equals(""))?"":"  AND C_PROJECT.PROJECTKIND IN" + cProjectKind);
    strSql = strSql + ((cProjectPhase==null || cProjectPhase.equals(""))?"":"  AND C_PROJECT.PROJECTPHASE IN" + cProjectPhase);
    strSql = strSql + ((cProjectStatus==null || cProjectStatus.equals(""))?"":"  AND C_PROJECT.PROJECTSTATUS IN" + cProjectStatus);
    strSql = strSql + ((cProjectPublic==null || cProjectPublic.equals(""))?"":"  AND C_PROJECT.PUBLICPRIVATE = ? ");
    strSql = strSql + ((cRegionId==null || cRegionId.equals(""))?"":"  AND C_LOCATION.C_REGION_ID IN" + cRegionId);
    strSql = strSql + ((salesRep==null || salesRep.equals(""))?"":"  AND C_PROJECT.SALESREP_ID = ? ");
    strSql = strSql + ((productId==null || productId.equals(""))?"":"  AND M_PRODUCT.M_PRODUCT_ID IN" + productId);
    strSql = strSql + 
      "      GROUP BY C_BPARTNER.NAME, M_PRODUCT.NAME, C_UOM.NAME, C_INVOICELINE.PRICEACTUAL, " +
      "      COALESCE(C_INVOICE.POREFERENCE, C_INVOICE.DOCUMENTNO), C_INVOICE.DATEINVOICED," +
      "      C_INVOICE.C_CURRENCY_ID, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID, C_DOCTYPE.DOCBASETYPE," +
      "      C_INVOICELINE.AUMQTY, C_INVOICELINE.C_AUM" +
      "      ORDER BY C_BPARTNER.NAME, COALESCE(C_INVOICE.POREFERENCE, C_INVOICE.DOCUMENTNO), C_INVOICE.DATEINVOICED";

    ResultSet result;
    Vector<InvoiceCustomerEditionData> vector = new Vector<InvoiceCustomerEditionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cbPartnerId != null && !(cbPartnerId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (cProductCategoryId != null && !(cProductCategoryId.equals(""))) {
        }
      if (cProjectKind != null && !(cProjectKind.equals(""))) {
        }
      if (cProjectPhase != null && !(cProjectPhase.equals(""))) {
        }
      if (cProjectStatus != null && !(cProjectStatus.equals(""))) {
        }
      if (cProjectPublic != null && !(cProjectPublic.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectPublic);
      }
      if (cRegionId != null && !(cRegionId.equals(""))) {
        }
      if (salesRep != null && !(salesRep.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesRep);
      }
      if (productId != null && !(productId.equals(""))) {
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
        InvoiceCustomerEditionData objectInvoiceCustomerEditionData = new InvoiceCustomerEditionData();
        objectInvoiceCustomerEditionData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceCustomerEditionData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceCustomerEditionData.clientName = UtilSql.getValue(result, "client_name");
        objectInvoiceCustomerEditionData.productName = UtilSql.getValue(result, "product_name");
        objectInvoiceCustomerEditionData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectInvoiceCustomerEditionData.uomname = UtilSql.getValue(result, "uomname");
        objectInvoiceCustomerEditionData.priceactual = UtilSql.getValue(result, "priceactual");
        objectInvoiceCustomerEditionData.priceactualsym = UtilSql.getValue(result, "priceactualsym");
        objectInvoiceCustomerEditionData.convpriceactual = UtilSql.getValue(result, "convpriceactual");
        objectInvoiceCustomerEditionData.pricelist = UtilSql.getValue(result, "pricelist");
        objectInvoiceCustomerEditionData.pricelistsym = UtilSql.getValue(result, "pricelistsym");
        objectInvoiceCustomerEditionData.convpricelist = UtilSql.getValue(result, "convpricelist");
        objectInvoiceCustomerEditionData.convsym = UtilSql.getValue(result, "convsym");
        objectInvoiceCustomerEditionData.convisosym = UtilSql.getValue(result, "convisosym");
        objectInvoiceCustomerEditionData.transdate = UtilSql.getDateValue(result, "transdate", "dd-MM-yyyy");
        objectInvoiceCustomerEditionData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectInvoiceCustomerEditionData.transclientid = UtilSql.getValue(result, "transclientid");
        objectInvoiceCustomerEditionData.transorgid = UtilSql.getValue(result, "transorgid");
        objectInvoiceCustomerEditionData.aumqty = UtilSql.getValue(result, "aumqty");
        objectInvoiceCustomerEditionData.aum = UtilSql.getValue(result, "aum");
        objectInvoiceCustomerEditionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceCustomerEditionData);
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
    InvoiceCustomerEditionData objectInvoiceCustomerEditionData[] = new InvoiceCustomerEditionData[vector.size()];
    vector.copyInto(objectInvoiceCustomerEditionData);
    return(objectInvoiceCustomerEditionData);
  }

/**
Standard Precision
 */
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
}
