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

class InvoiceLineData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceLineData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cInvoicelineId;
  public String bpartnerName;
  public String productName;
  public String dateinvoiced;
  public String documentno;
  public String issotrx;
  public String qty;
  public String priceactual;
  public String linenetamt;
  public String line;
  public String grandtotal;
  public String rowkey;
  public String lineText;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("bpartner_name") || fieldName.equals("bpartnerName"))
      return bpartnerName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
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
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equalsIgnoreCase("line_text") || fieldName.equals("lineText"))
      return lineText;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InvoiceLineData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String issotrx, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adUserClient, adUserOrg, documentno, description, orderReference, businesPartner, dateFrom, dateTo, grandTotalFrom, grandTotalTo, product, issotrx, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static InvoiceLineData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String issotrx, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT B.*," +
      "      		C_INVOICELINE_ID || '@_##_@' || (DOCUMENTNO || ' - ' || DATEINVOICED || ' - ' || GRANDTOTAL || ' - ' || LINE || ' - ' || LINENETAMT) AS ROWKEY," +
      "        	(DOCUMENTNO || ' - ' || DATEINVOICED || ' - ' || GRANDTOTAL || ' - ' || LINE || ' - ' || LINENETAMT) AS LINE_TEXT" +
      "      	FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "	          SELECT IL.C_INVOICELINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, I.DATEINVOICED, I.DOCUMENTNO, " +
      "	          I.ISSOTRX, IL.QTYINVOICED AS QTY, IL.PRICEACTUAL, IL.LINENETAMT, " +
      "	          IL.LINE, I.GRANDTOTAL" +
      "	          FROM C_INVOICE I, C_INVOICELINE IL, M_PRODUCT p, C_BPARTNER b" +
      "	          WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID " +
      "	          AND I.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "	          AND IL.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "	          AND I.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	          AND I.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "	          AND I.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(I.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(IL.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(I.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND I.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND I.DATEINVOICED >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND I.DATEINVOICED < TO_DATE(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"   AND IL.PRICEACTUAL*IL.QTYINVOICED >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"   AND IL.PRICEACTUAL*IL.QTYINVOICED <= TO_NUMBER(?)  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND IL.M_Product_ID=?  ");
    strSql = strSql + 
      "	          AND I.ISSOTRX = ?" +
      "	          ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "          	) A ) B" +
      "        WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<InvoiceLineData> vector = new Vector<InvoiceLineData>(0);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
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
        InvoiceLineData objectInvoiceLineData = new InvoiceLineData();
        objectInvoiceLineData.rn1 = UtilSql.getValue(result, "rn1");
        objectInvoiceLineData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectInvoiceLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectInvoiceLineData.productName = UtilSql.getValue(result, "product_name");
        objectInvoiceLineData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceLineData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceLineData.qty = UtilSql.getValue(result, "qty");
        objectInvoiceLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectInvoiceLineData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectInvoiceLineData.line = UtilSql.getValue(result, "line");
        objectInvoiceLineData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoiceLineData.rowkey = UtilSql.getValue(result, "rowkey");
        objectInvoiceLineData.lineText = UtilSql.getValue(result, "line_text");
        objectInvoiceLineData.position = Long.toString(countRecord);
        objectInvoiceLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceLineData);
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
    InvoiceLineData objectInvoiceLineData[] = new InvoiceLineData[vector.size()];
    vector.copyInto(objectInvoiceLineData);
    return(objectInvoiceLineData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String product, String issotrx, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	          SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.* FROM (" +
      "	          SELECT 1 FROM C_INVOICE I, C_INVOICELINE IL, M_PRODUCT p, C_BPARTNER b" +
      "	          WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID " +
      "	          AND I.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "	          AND IL.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "	          AND I.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	          AND I.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "	          AND I.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(I.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(IL.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(I.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND I.C_BPartner_ID = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND I.DATEINVOICED >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND I.DATEINVOICED < TO_DATE(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"   AND IL.PRICEACTUAL*IL.QTYINVOICED >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"   AND IL.PRICEACTUAL*IL.QTYINVOICED <= TO_NUMBER(?)  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND IL.M_Product_ID = ?  ");
    strSql = strSql + 
      "	          AND I.ISSOTRX = ?" +
      "	          AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "	          ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "	          ) A ";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
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

  public static InvoiceLineData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, String issotrx)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, key, issotrx, 0, 0);
  }

  public static InvoiceLineData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, String issotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      "        SELECT IL.C_INVOICELINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, I.DATEINVOICED, I.DOCUMENTNO, " +
      "        I.ISSOTRX, IL.QTYINVOICED AS QTY, IL.PRICEACTUAL, IL.LINENETAMT, " +
      "        (I.DOCUMENTNO || ' - ' || I.DATEINVOICED || ' - ' || I.GRANDTOTAL || ' - ' || IL.LINE || ' - ' || IL.LINENETAMT) AS LINE_TEXT" +
      "        FROM C_INVOICE I, C_INVOICELINE Il, M_PRODUCT p, C_BPARTNER b" +
      "        WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID " +
      "        AND I.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "        AND IL.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "        AND I.AD_CLIENT_ID IN ('1') " +
      "        AND I.AD_ORG_ID IN ('1') " +
      "        AND I.IsActive=?" +
      "        AND UPPER(I.DOCUMENTNO) LIKE UPPER(?) " +
      "       /* AND (IL.QTYORDERED - COALESCE(IL.QTYINVOICED, 0)) > 0 " +
      "        AND (IL.QTYORDERED - COALESCE(IL.QTYDELIVERED, 0)) > 0 */" +
      "        AND I.ISSOTRX = 'Y'" +
      "        ORDER BY b.NAME, I.DATEINVOICED, I.DOCUMENTNO, IL.LINE";

    ResultSet result;
    Vector<InvoiceLineData> vector = new Vector<InvoiceLineData>(0);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);

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
        InvoiceLineData objectInvoiceLineData = new InvoiceLineData();
        objectInvoiceLineData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectInvoiceLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectInvoiceLineData.productName = UtilSql.getValue(result, "product_name");
        objectInvoiceLineData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceLineData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceLineData.qty = UtilSql.getValue(result, "qty");
        objectInvoiceLineData.priceactual = UtilSql.getValue(result, "priceactual");
        objectInvoiceLineData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectInvoiceLineData.lineText = UtilSql.getValue(result, "line_text");
        objectInvoiceLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceLineData);
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
    InvoiceLineData objectInvoiceLineData[] = new InvoiceLineData[vector.size()];
    vector.copyInto(objectInvoiceLineData);
    return(objectInvoiceLineData);
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
