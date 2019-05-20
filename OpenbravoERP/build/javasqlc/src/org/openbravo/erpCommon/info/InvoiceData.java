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

class InvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cInvoiceId;
  public String bpartnername;
  public String dateinvoiced;
  public String documentno;
  public String currency;
  public String grandtotal;
  public String openamt;
  public String issotrx;
  public String description;
  public String poreference;
  public String dateacct;
  public String adClientId;
  public String cCurrencyId;
  public String rowkey;
  public String convertedamount;
  public String name;
  public String nameHidden;
  public String value;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("openamt"))
      return openamt;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equalsIgnoreCase("convertedamount"))
      return convertedamount;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name_hidden") || fieldName.equals("nameHidden"))
      return nameHidden;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InvoiceData[] select(ConnectionProvider connectionProvider, String rownum, String dateFormat, String adUserClient, String adUserOrg, String key, String description, String businesPartner, String order, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String sotrx, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, dateFormat, adUserClient, adUserOrg, key, description, businesPartner, order, dateFrom, dateTo, grandTotalFrom, grandTotalTo, sotrx, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static InvoiceData[] select(ConnectionProvider connectionProvider, String rownum, String dateFormat, String adUserClient, String adUserOrg, String key, String description, String businesPartner, String order, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String sotrx, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B.*," +
      "        	C_Invoice_ID || '@_##_@' || DocumentNo || ' - ' || TO_CHAR(DateInvoiced, TO_CHAR(?)) as RowKey," +
      "        	C_Base_Convert(GrandTotal, C_Currency_ID, AD_Client_ID, DateAcct, '0') AS ConvertedAmount," +
      "            DocumentNo||' - '||TO_CHAR(DateInvoiced,to_char(?))||' - '||GrandTotal AS Name," +
      "          	REPLACE(DocumentNo||' - '||TO_CHAR(DateInvoiced,to_char(?))||' - '||GrandTotal, '''', CHR(92) || '''') AS Name_HIDDEN, '' AS value" +
      "        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM ( " +
      "          SELECT" +
      "          i.C_Invoice_ID," +
      "          bp.name AS BPartnerName," +
      "          i.DateInvoiced," +
      "          i.DocumentNo," +
      "          (SELECT ISO_Code FROM C_Currency c WHERE c.C_Currency_ID=i.C_Currency_ID) AS Currency," +
      "          i.GrandTotal," +
      "          0 AS OpenAmt," +
      "          i.IsSOTrx," +
      "          i.Description," +
      "          i.POReference," +
      "          i.DateAcct, i.AD_Client_ID, i.C_Currency_ID" +
      "          FROM C_Invoice_v i LEFT JOIN C_BPartner bp ON bp.C_BPartner_ID=i.C_BPartner_ID" +
      "          WHERE i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND i.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND i.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(i.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(i.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND i.C_BPartner_ID = ?  ");
    strSql = strSql + ((order==null || order.equals(""))?"":"  AND i.POReference = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND i.DateInvoiced >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND i.DateInvoiced < TO_DATE(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND i.GrandTotal >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND i.GrandTotal <= TO_NUMBER(?)  ");
    strSql = strSql + ((sotrx==null || sotrx.equals(""))?"":"  AND i.IsSOTrx = ?  ");
    strSql = strSql + 
      "          ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "        ) A ) B" +
      "        WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<InvoiceData> vector = new Vector<InvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (order != null && !(order.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, order);
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
      if (sotrx != null && !(sotrx.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, sotrx);
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
        InvoiceData objectInvoiceData = new InvoiceData();
        objectInvoiceData.rn1 = UtilSql.getValue(result, "rn1");
        objectInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoiceData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceData.currency = UtilSql.getValue(result, "currency");
        objectInvoiceData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoiceData.openamt = UtilSql.getValue(result, "openamt");
        objectInvoiceData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceData.description = UtilSql.getValue(result, "description");
        objectInvoiceData.poreference = UtilSql.getValue(result, "poreference");
        objectInvoiceData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectInvoiceData.rowkey = UtilSql.getValue(result, "rowkey");
        objectInvoiceData.convertedamount = UtilSql.getValue(result, "convertedamount");
        objectInvoiceData.name = UtilSql.getValue(result, "name");
        objectInvoiceData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectInvoiceData.value = UtilSql.getValue(result, "value");
        objectInvoiceData.position = Long.toString(countRecord);
        objectInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceData);
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
    InvoiceData objectInvoiceData[] = new InvoiceData[vector.size()];
    vector.copyInto(objectInvoiceData);
    return(objectInvoiceData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String description, String businesPartner, String order, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String sotrx, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COUNT(*) AS value FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.* FROM (" +
      "            SELECT 1 FROM C_Invoice_v i" +
      "            WHERE i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "            AND i.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "            AND i.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(i.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(i.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND i.C_BPartner_ID = ?  ");
    strSql = strSql + ((order==null || order.equals(""))?"":"  AND i.POReference = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND i.DateInvoiced >= TO_DATE(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND i.DateInvoiced < TO_DATE(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND i.GrandTotal >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND i.GrandTotal <= TO_NUMBER(?)  ");
    strSql = strSql + ((sotrx==null || sotrx.equals(""))?"":"  AND i.IsSOTrx = ?  ");
    strSql = strSql + 
      "            AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "          ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "          ) A ";
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
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (order != null && !(order.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, order);
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
      if (sotrx != null && !(sotrx.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, sotrx);
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

  public static InvoiceData[] selectKey(ConnectionProvider connectionProvider, String dateFormat, String adUserClient, String adUserOrg, String sotrx, String key)    throws ServletException {
    return selectKey(connectionProvider, dateFormat, adUserClient, adUserOrg, sotrx, key, 0, 0);
  }

  public static InvoiceData[] selectKey(ConnectionProvider connectionProvider, String dateFormat, String adUserClient, String adUserOrg, String sotrx, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT" +
      "          i.C_Invoice_ID, i.DocumentNo||' - '||TO_CHAR(i.DateInvoiced,to_char(?))||' - '||i.GrandTotal AS Name," +
      "          (SELECT Name FROM C_BPartner bp WHERE bp.C_BPartner_ID=i.C_BPartner_ID) AS BPartnerName," +
      "          i.DateInvoiced," +
      "          i.DocumentNo," +
      "          (SELECT ISO_Code FROM C_Currency c WHERE c.C_Currency_ID=i.C_Currency_ID) AS Currency," +
      "          i.GrandTotal," +
      "          C_Base_Convert(i.GrandTotal, i.C_Currency_ID, i.AD_Client_ID, i.DateAcct, '0') AS ConvertedAmount," +
      "          0 AS OpenAmt," +
      "          i.IsSOTrx," +
      "          i.Description," +
      "          i.POReference" +
      "          FROM C_Invoice_v i" +
      "          WHERE i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND i.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND i.IsActive='Y'";
    strSql = strSql + ((sotrx==null || sotrx.equals(""))?"":"  AND i.IsSOTrx = ?  ");
    strSql = strSql + 
      "          AND UPPER(i.DocumentNo) LIKE UPPER(?)";

    ResultSet result;
    Vector<InvoiceData> vector = new Vector<InvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (sotrx != null && !(sotrx.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, sotrx);
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
        InvoiceData objectInvoiceData = new InvoiceData();
        objectInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoiceData.name = UtilSql.getValue(result, "name");
        objectInvoiceData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceData.currency = UtilSql.getValue(result, "currency");
        objectInvoiceData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoiceData.convertedamount = UtilSql.getValue(result, "convertedamount");
        objectInvoiceData.openamt = UtilSql.getValue(result, "openamt");
        objectInvoiceData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceData.description = UtilSql.getValue(result, "description");
        objectInvoiceData.poreference = UtilSql.getValue(result, "poreference");
        objectInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceData);
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
    InvoiceData objectInvoiceData[] = new InvoiceData[vector.size()];
    vector.copyInto(objectInvoiceData);
    return(objectInvoiceData);
  }
}
