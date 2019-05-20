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

class SalesOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(SalesOrderData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cOrderId;
  public String bpartnername;
  public String dateordered;
  public String documentno;
  public String currency;
  public String grandtotal;
  public String dateacct;
  public String adClientId;
  public String cCurrencyId;
  public String issotrx;
  public String description;
  public String poreference;
  public String rowkey;
  public String converted;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equalsIgnoreCase("converted"))
      return converted;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SalesOrderData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adUserClient, adUserOrg, key, description, orderReference, businesPartner, dateFrom, dateTo, grandTotalFrom, grandTotalTo, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static SalesOrderData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    SELECT B.*," +
      "			C_Order_ID || '@_##_@' || DocumentNo as rowkey," +
      "	        C_Base_Convert(GrandTotal,C_Currency_ID,AD_Client_ID,DateAcct, '0') as Converted" +
      "	    FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "        SELECT o.C_Order_ID," +
      "        bp.Name AS BPartnerName," +
      "        o.DateOrdered, o.DocumentNo," +
      "        C.ISO_Code AS Currency," +
      "        o.GrandTotal, o.dateacct, o.ad_client_id, o.c_currency_id," +
      "        o.IsSOTrx, o.Description, o.POReference" +
      "        FROM C_Order o" +
      "        	LEFT JOIN C_BPartner bp on bp.C_BPartner_ID=o.C_BPartner_ID" +
      "        	LEFT JOIN C_Currency c ON c.C_Currency_ID=o.C_Currency_ID" +
      "        WHERE o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND o.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(o.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(o.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(o.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND o.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND o.DateOrdered >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND o.DateOrdered < to_date(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND o.GrandTotal >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND o.GrandTotal <= ?  ");
    strSql = strSql + 
      "        AND o.CANCELLEDORDER_ID IS NULL" +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "	    ) A ) B" +
      "	    WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<SalesOrderData> vector = new Vector<SalesOrderData>(0);
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
        SalesOrderData objectSalesOrderData = new SalesOrderData();
        objectSalesOrderData.rn1 = UtilSql.getValue(result, "rn1");
        objectSalesOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectSalesOrderData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectSalesOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSalesOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderData.currency = UtilSql.getValue(result, "currency");
        objectSalesOrderData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectSalesOrderData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectSalesOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSalesOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSalesOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderData.description = UtilSql.getValue(result, "description");
        objectSalesOrderData.poreference = UtilSql.getValue(result, "poreference");
        objectSalesOrderData.rowkey = UtilSql.getValue(result, "rowkey");
        objectSalesOrderData.converted = UtilSql.getValue(result, "converted");
        objectSalesOrderData.position = Long.toString(countRecord);
        objectSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderData);
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
    SalesOrderData objectSalesOrderData[] = new SalesOrderData[vector.size()];
    vector.copyInto(objectSalesOrderData);
    return(objectSalesOrderData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String grandTotalFrom, String grandTotalTo, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) AS value FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.*  FROM ( " +
      "        SELECT 1" +
      "        FROM C_Order o" +
      "        WHERE o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND o.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(o.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(o.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(o.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND o.C_BPartner_ID = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND o.DateOrdered >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND o.DateOrdered < to_date(?)  ");
    strSql = strSql + ((grandTotalFrom==null || grandTotalFrom.equals(""))?"":"  AND o.GrandTotal >= TO_NUMBER(?)  ");
    strSql = strSql + ((grandTotalTo==null || grandTotalTo.equals(""))?"":"  AND o.GrandTotal <= ?  ");
    strSql = strSql + 
      "        AND o.CANCELLEDORDER_ID IS NULL" +
      "        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "      ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "      ) A ";
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

  public static SalesOrderData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, key, 0, 0);
  }

  public static SalesOrderData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_Order_ID," +
      "        (SELECT Name FROM C_BPartner bp WHERE bp.C_BPartner_ID=o.C_BPartner_ID) AS BPartnerName," +
      "        o.DateOrdered, o.DocumentNo," +
      "        (SELECT ISO_Code FROM C_Currency c WHERE c.C_Currency_ID=o.C_Currency_ID) AS Currency," +
      "        o.GrandTotal," +
      "        C_Base_Convert(o.GrandTotal,o.C_Currency_ID,o.AD_Client_ID,o.DateAcct, '0') as Converted, o.IsSOTrx, o.Description, o.POReference" +
      "        FROM C_Order o" +
      "        WHERE o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND o.IsActive='Y'" +
      "        AND UPPER(o.DocumentNo) LIKE UPPER(?)";

    ResultSet result;
    Vector<SalesOrderData> vector = new Vector<SalesOrderData>(0);
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
        SalesOrderData objectSalesOrderData = new SalesOrderData();
        objectSalesOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectSalesOrderData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectSalesOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSalesOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderData.currency = UtilSql.getValue(result, "currency");
        objectSalesOrderData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectSalesOrderData.converted = UtilSql.getValue(result, "converted");
        objectSalesOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderData.description = UtilSql.getValue(result, "description");
        objectSalesOrderData.poreference = UtilSql.getValue(result, "poreference");
        objectSalesOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderData);
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
    SalesOrderData objectSalesOrderData[] = new SalesOrderData[vector.size()];
    vector.copyInto(objectSalesOrderData);
    return(objectSalesOrderData);
  }
}
