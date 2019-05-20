//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptCInvoiceHeaderData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCInvoiceHeaderData.class);
  private String InitRecordNumber="0";
  public String cInvoiceId;
  public String name;
  public String cif;
  public String contactName;
  public String address1;
  public String postal;
  public String city;
  public String place;
  public String country;
  public String phone;
  public String fax;
  public String dateinvoiced;
  public String documentno;
  public String codeBpartner;
  public String entity;
  public String location;
  public String currencyCode;
  public String symbol;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("cif"))
      return cif;
    else if (fieldName.equalsIgnoreCase("contact_name") || fieldName.equals("contactName"))
      return contactName;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("place"))
      return place;
    else if (fieldName.equalsIgnoreCase("country"))
      return country;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("code_bpartner") || fieldName.equals("codeBpartner"))
      return codeBpartner;
    else if (fieldName.equalsIgnoreCase("entity"))
      return entity;
    else if (fieldName.equalsIgnoreCase("location"))
      return location;
    else if (fieldName.equalsIgnoreCase("currency_code") || fieldName.equals("currencyCode"))
      return currencyCode;
    else if (fieldName.equalsIgnoreCase("symbol"))
      return symbol;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCInvoiceHeaderData[] select(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, cInvoiceId, 0, 0);
  }

  public static RptCInvoiceHeaderData[] select(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT C_INVOICE.C_INVOICE_ID, C_BPARTNER.NAME, C_BPARTNER.TAXID AS CIF, AD_USER.NAME AS CONTACT_NAME, C_LOCATION.ADDRESS1, " +
      "          C_LOCATION.POSTAL, C_LOCATION.CITY, C_REGION.NAME AS PLACE, C_COUNTRY.NAME AS COUNTRY,C_BPARTNER_LOCATION.PHONE AS PHONE, C_BPARTNER_LOCATION.FAX AS FAX," +
      "          C_INVOICE.DATEINVOICED, C_INVOICE.DOCUMENTNO, C_BPARTNER.VALUE AS CODE_BPARTNER, " +
      "          AD_CLIENT.DESCRIPTION AS ENTITY, C_Location_Description(AD_ORGINFO.C_LOCATION_ID) AS LOCATION, C_CURRENCY.ISO_CODE AS CURRENCY_CODE,C_CURRENCY.CURSYMBOL AS SYMBOL" +
      "          FROM   C_INVOICE left join C_BPARTNER on C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                           left join AD_USER on C_INVOICE.AD_USER_ID = AD_USER.AD_USER_ID" +
      "                           left join C_BPARTNER_LOCATION on C_INVOICE.C_BPARTNER_LOCATION_ID = C_BPARTNER_LOCATION.C_BPARTNER_LOCATION_ID" +
      "                           left join C_LOCATION on C_BPARTNER_LOCATION.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID" +
      "                           left join C_REGION on C_LOCATION.C_REGION_ID = C_REGION.C_REGION_ID" +
      "                 		   left join C_COUNTRY ON C_LOCATION.C_COUNTRY_ID=C_COUNTRY.C_COUNTRY_ID" +
      "                 		   left join C_CURRENCY ON C_INVOICE.C_CURRENCY_ID = C_CURRENCY.C_CURRENCY_ID," +
      "                  AD_ORGINFO, AD_CLIENT" +
      "          WHERE C_INVOICE.ad_org_id = AD_ORGINFO.ad_org_id" +
      "          AND C_INVOICE.ad_client_id = AD_CLIENT.ad_client_id";
    strSql = strSql + ((cInvoiceId==null || cInvoiceId.equals(""))?"":"           AND C_INVOICE.C_INVOICE_ID IN          " + cInvoiceId);

    ResultSet result;
    Vector<RptCInvoiceHeaderData> vector = new Vector<RptCInvoiceHeaderData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cInvoiceId != null && !(cInvoiceId.equals(""))) {
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
        RptCInvoiceHeaderData objectRptCInvoiceHeaderData = new RptCInvoiceHeaderData();
        objectRptCInvoiceHeaderData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRptCInvoiceHeaderData.name = UtilSql.getValue(result, "name");
        objectRptCInvoiceHeaderData.cif = UtilSql.getValue(result, "cif");
        objectRptCInvoiceHeaderData.contactName = UtilSql.getValue(result, "contact_name");
        objectRptCInvoiceHeaderData.address1 = UtilSql.getValue(result, "address1");
        objectRptCInvoiceHeaderData.postal = UtilSql.getValue(result, "postal");
        objectRptCInvoiceHeaderData.city = UtilSql.getValue(result, "city");
        objectRptCInvoiceHeaderData.place = UtilSql.getValue(result, "place");
        objectRptCInvoiceHeaderData.country = UtilSql.getValue(result, "country");
        objectRptCInvoiceHeaderData.phone = UtilSql.getValue(result, "phone");
        objectRptCInvoiceHeaderData.fax = UtilSql.getValue(result, "fax");
        objectRptCInvoiceHeaderData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectRptCInvoiceHeaderData.documentno = UtilSql.getValue(result, "documentno");
        objectRptCInvoiceHeaderData.codeBpartner = UtilSql.getValue(result, "code_bpartner");
        objectRptCInvoiceHeaderData.entity = UtilSql.getValue(result, "entity");
        objectRptCInvoiceHeaderData.location = UtilSql.getValue(result, "location");
        objectRptCInvoiceHeaderData.currencyCode = UtilSql.getValue(result, "currency_code");
        objectRptCInvoiceHeaderData.symbol = UtilSql.getValue(result, "symbol");
        objectRptCInvoiceHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCInvoiceHeaderData);
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
    RptCInvoiceHeaderData objectRptCInvoiceHeaderData[] = new RptCInvoiceHeaderData[vector.size()];
    vector.copyInto(objectRptCInvoiceHeaderData);
    return(objectRptCInvoiceHeaderData);
  }
}
