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

class RptCOrderHeaderData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCOrderHeaderData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String name;
  public String address1;
  public String phone;
  public String fax;
  public String url;
  public String description;
  public String dateordered;
  public String albaran;
  public String completeName;
  public String entity;
  public String location;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("albaran"))
      return albaran;
    else if (fieldName.equalsIgnoreCase("complete_name") || fieldName.equals("completeName"))
      return completeName;
    else if (fieldName.equalsIgnoreCase("entity"))
      return entity;
    else if (fieldName.equalsIgnoreCase("location"))
      return location;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCOrderHeaderData[] select(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return select(connectionProvider, cOrderId, 0, 0);
  }

  public static RptCOrderHeaderData[] select(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ORDER.C_ORDER_ID, C_BPARTNER.NAME, L.ADDRESS1 || " +
      "        (CASE WHEN (L.POSTAL||L.CITY||R.NAME) IS NOT NULL THEN (CHR(10)||L.POSTAL || (CASE WHEN L.POSTAL IS NOT NULL THEN (' - '||TO_CHAR(L.CITY)) END) || " +
      "        (CASE WHEN R.NAME IS NOT NULL THEN (' ('||TO_CHAR(R.NAME)|| ')') END)) END) AS ADDRESS1," +
      "        C_BPARTNER_LOCATION.PHONE, C_BPARTNER_LOCATION.FAX,C_BPARTNER.URL," +
      "        C_ORDER.DESCRIPTION, C_ORDER.DATEORDERED, C_ORDER.DOCUMENTNO AS ALBARAN, " +
      "        C_BPARTNER.NAME2 || ' (' || C_BPARTNER.NAME || ')' AS COMPLETE_NAME, AD_CLIENT.DESCRIPTION AS ENTITY, " +
      "        C_LOCATION_DESCRIPTION(AD_ORGINFO.C_LOCATION_ID) AS LOCATION" +
      "        FROM C_BPARTNER_LOCATION left join C_LOCATION L on C_BPARTNER_LOCATION.C_LOCATION_ID = L.C_LOCATION_ID" +
      "                                 left join  C_REGION R on L.C_REGION_ID = R.C_REGION_ID," +
      "             AD_USER right join C_ORDER on AD_USER.AD_USER_ID = C_ORDER.AD_USER_ID," +
      "        C_BPARTNER, AD_ORGINFO, AD_CLIENT" +
      "        WHERE C_ORDER.C_BPARTNER_LOCATION_ID = C_BPARTNER_LOCATION.C_BPARTNER_LOCATION_ID" +
      "        AND C_ORDER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID " +
      "        AND C_ORDER.ad_org_id = AD_ORGINFO.ad_org_id" +
      "        AND C_ORDER.AD_CLIENT_ID = AD_CLIENT.AD_CLIENT_ID";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"           AND C_ORDER.C_ORDER_ID IN          " + cOrderId);

    ResultSet result;
    Vector<RptCOrderHeaderData> vector = new Vector<RptCOrderHeaderData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cOrderId != null && !(cOrderId.equals(""))) {
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
        RptCOrderHeaderData objectRptCOrderHeaderData = new RptCOrderHeaderData();
        objectRptCOrderHeaderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectRptCOrderHeaderData.name = UtilSql.getValue(result, "name");
        objectRptCOrderHeaderData.address1 = UtilSql.getValue(result, "address1");
        objectRptCOrderHeaderData.phone = UtilSql.getValue(result, "phone");
        objectRptCOrderHeaderData.fax = UtilSql.getValue(result, "fax");
        objectRptCOrderHeaderData.url = UtilSql.getValue(result, "url");
        objectRptCOrderHeaderData.description = UtilSql.getValue(result, "description");
        objectRptCOrderHeaderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectRptCOrderHeaderData.albaran = UtilSql.getValue(result, "albaran");
        objectRptCOrderHeaderData.completeName = UtilSql.getValue(result, "complete_name");
        objectRptCOrderHeaderData.entity = UtilSql.getValue(result, "entity");
        objectRptCOrderHeaderData.location = UtilSql.getValue(result, "location");
        objectRptCOrderHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCOrderHeaderData);
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
    RptCOrderHeaderData objectRptCOrderHeaderData[] = new RptCOrderHeaderData[vector.size()];
    vector.copyInto(objectRptCOrderHeaderData);
    return(objectRptCOrderHeaderData);
  }

  public static RptCOrderHeaderData[] set()    throws ServletException {
    RptCOrderHeaderData objectRptCOrderHeaderData[] = new RptCOrderHeaderData[1];
    objectRptCOrderHeaderData[0] = new RptCOrderHeaderData();
    objectRptCOrderHeaderData[0].cOrderId = "";
    objectRptCOrderHeaderData[0].name = "";
    objectRptCOrderHeaderData[0].address1 = "";
    objectRptCOrderHeaderData[0].phone = "";
    objectRptCOrderHeaderData[0].fax = "";
    objectRptCOrderHeaderData[0].url = "";
    objectRptCOrderHeaderData[0].description = "";
    objectRptCOrderHeaderData[0].dateordered = "";
    objectRptCOrderHeaderData[0].albaran = "";
    objectRptCOrderHeaderData[0].completeName = "";
    objectRptCOrderHeaderData[0].entity = "";
    objectRptCOrderHeaderData[0].location = "";
    return objectRptCOrderHeaderData;
  }
}
