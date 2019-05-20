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

class RptCBpartnerlocationData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnerlocationData.class);
  private String InitRecordNumber="0";
  public String name;
  public String postal;
  public String city;
  public String locationregionname;
  public String locationcountryname;
  public String phone;
  public String fax;
  public String billto;
  public String shipto;
  public String taxlocation;
  public String phone2;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("locationregionname"))
      return locationregionname;
    else if (fieldName.equalsIgnoreCase("locationcountryname"))
      return locationcountryname;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("billto"))
      return billto;
    else if (fieldName.equalsIgnoreCase("shipto"))
      return shipto;
    else if (fieldName.equalsIgnoreCase("taxlocation"))
      return taxlocation;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnerlocationData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerlocationData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE SUBSTR(TO_CHAR(BL.NAME),1,1) WHEN '.' THEN '' ELSE TO_CHAR(BL.NAME)||'  -  ' END)||TO_CHAR(L.ADDRESS1) || (CASE WHEN L.ADDRESS2 IS NULL THEN '' ELSE ', ' || TO_CHAR(L.ADDRESS2) END) AS NAME," +
      "        L.POSTAL, L.CITY, R.NAME AS LOCATIONREGIONNAME, C.NAME AS LOCATIONCOUNTRYNAME, BL.PHONE, BL.FAX, (CASE BL.ISBILLTO WHEN 'Y' THEN 'Si' ELSE 'No' END) AS BILLTO, " +
      "        (CASE BL.ISSHIPTO WHEN 'Y' THEN 'Si' ELSE 'No' END) AS SHIPTO, (CASE BL.ISTAXLOCATION WHEN 'Y' THEN 'Si' ELSE 'No' END) AS TAXLOCATION, PHONE2" +
      "        FROM C_LOCATION L left join C_REGION R on L.C_REGION_ID = R.C_REGION_ID" +
      "                          left join C_COUNTRY C on R.C_COUNTRY_ID = C.C_COUNTRY_ID," +
      "        C_BPARTNER_LOCATION BL" +
      "        WHERE BL.C_LOCATION_ID = L.C_LOCATION_ID";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND BL.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<RptCBpartnerlocationData> vector = new Vector<RptCBpartnerlocationData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerlocationData objectRptCBpartnerlocationData = new RptCBpartnerlocationData();
        objectRptCBpartnerlocationData.name = UtilSql.getValue(result, "name");
        objectRptCBpartnerlocationData.postal = UtilSql.getValue(result, "postal");
        objectRptCBpartnerlocationData.city = UtilSql.getValue(result, "city");
        objectRptCBpartnerlocationData.locationregionname = UtilSql.getValue(result, "locationregionname");
        objectRptCBpartnerlocationData.locationcountryname = UtilSql.getValue(result, "locationcountryname");
        objectRptCBpartnerlocationData.phone = UtilSql.getValue(result, "phone");
        objectRptCBpartnerlocationData.fax = UtilSql.getValue(result, "fax");
        objectRptCBpartnerlocationData.billto = UtilSql.getValue(result, "billto");
        objectRptCBpartnerlocationData.shipto = UtilSql.getValue(result, "shipto");
        objectRptCBpartnerlocationData.taxlocation = UtilSql.getValue(result, "taxlocation");
        objectRptCBpartnerlocationData.phone2 = UtilSql.getValue(result, "phone2");
        objectRptCBpartnerlocationData.position = Long.toString(countRecord);
        objectRptCBpartnerlocationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerlocationData);
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
    RptCBpartnerlocationData objectRptCBpartnerlocationData[] = new RptCBpartnerlocationData[vector.size()];
    vector.copyInto(objectRptCBpartnerlocationData);
    return(objectRptCBpartnerlocationData);
  }

  public static RptCBpartnerlocationData[] set()    throws ServletException {
    RptCBpartnerlocationData objectRptCBpartnerlocationData[] = new RptCBpartnerlocationData[1];
    objectRptCBpartnerlocationData[0] = new RptCBpartnerlocationData();
    objectRptCBpartnerlocationData[0].name = "";
    objectRptCBpartnerlocationData[0].postal = "";
    objectRptCBpartnerlocationData[0].city = "";
    objectRptCBpartnerlocationData[0].locationregionname = "";
    objectRptCBpartnerlocationData[0].locationcountryname = "";
    objectRptCBpartnerlocationData[0].phone = "";
    objectRptCBpartnerlocationData[0].fax = "";
    objectRptCBpartnerlocationData[0].billto = "";
    objectRptCBpartnerlocationData[0].shipto = "";
    objectRptCBpartnerlocationData[0].taxlocation = "";
    objectRptCBpartnerlocationData[0].phone2 = "";
    return objectRptCBpartnerlocationData;
  }
}
