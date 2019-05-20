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

class RptCProposalJrData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCProposalJrData.class);
  private String InitRecordNumber="0";
  public String headernote;
  public String cProjectproposalId;
  public String cBpartnerId;
  public String address1;
  public String address2;
  public String proposal;
  public String reference;
  public String address;
  public String city;
  public String fecha;
  public String fax;
  public String phone;
  public String name;
  public String bpname;
  public String namecontacto;
  public String contacto;
  public String cursymbol;
  public String lineDesc;
  public String mProductIdD;
  public String description;
  public String price;
  public String quantity;
  public String uomname;
  public String footnote;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("headernote"))
      return headernote;
    else if (fieldName.equalsIgnoreCase("c_projectproposal_id") || fieldName.equals("cProjectproposalId"))
      return cProjectproposalId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("proposal"))
      return proposal;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("fecha"))
      return fecha;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("namecontacto"))
      return namecontacto;
    else if (fieldName.equalsIgnoreCase("contacto"))
      return contacto;
    else if (fieldName.equalsIgnoreCase("cursymbol"))
      return cursymbol;
    else if (fieldName.equalsIgnoreCase("line_desc") || fieldName.equals("lineDesc"))
      return lineDesc;
    else if (fieldName.equalsIgnoreCase("m_product_id_d") || fieldName.equals("mProductIdD"))
      return mProductIdD;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("footnote"))
      return footnote;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCProposalJrData[] select(ConnectionProvider connectionProvider, String cProjectProposalId, String adUserClient, String adOrgClient)    throws ServletException {
    return select(connectionProvider, cProjectProposalId, adUserClient, adOrgClient, 0, 0);
  }

  public static RptCProposalJrData[] select(ConnectionProvider connectionProvider, String cProjectProposalId, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT DISTINCT REPLACE(table3.HEADERNOTE, CHR(10), '') AS headernote, table3.C_PROJECTPROPOSAL_ID," +
      "		table7.C_BPARTNER_ID, TO_CHAR(table8.address1) AS address1, to_char(table8.address2) as address2," +
      "        TO_CHAR(table5.DESCRIPTION )  AS proposal, table5.VALUE AS reference," +
      "        TO_CHAR(table8.ADDRESS1)|| ', '||TO_CHAR(table8.POSTAL)||' '|| TO_CHAR(table8.CITY)||' ('||TO_CHAR(table9.description)||')' AS ADDRESS, " +
      "        table8.CITY as CITY," +
      "        to_date (table3.DATESEND) AS fecha, table7.FAX as FAX, table7.PHONE as PHONE,table5.NAME as NAME," +
      "        TO_CHAR(table10.NAME) AS BPname, table11.FIRSTNAME AS namecontacto, table11.LASTNAME AS contacto, " +
      "        table15.CURSYMBOL as CURSYMBOL, " +
      "        '' as line_desc,'' as M_Product_ID_D, '' as description, '' as price,'' as quantity, '' as UOMNAME, table3.FOOTNOTE as FOOTNOTE" +
      "        FROM  C_PROJECTPROPOSAL table3 left join AD_USER table11 on table3.AD_USER_ID = table11.AD_USER_ID" +
      "                                       left join C_GREETING on table11.C_GREETING_ID = C_GREETING.C_GREETING_ID,       " +
      "        C_BPARTNER_LOCATION table7, C_LOCATION table8, C_REGION table9, C_BPARTNER table10," +
      "        C_BPARTNER table4, C_PROJECT table5, AD_ORGINFO table13," +
      "        C_CURRENCY table15 " +
      "        WHERE  table3.C_Projectproposal_ID = ";
    strSql = strSql + ((cProjectProposalId==null || cProjectProposalId.equals(""))?"":cProjectProposalId);
    strSql = strSql + 
      "        AND table3.C_BPARTNER_LOCATION_ID = table7.C_BPARTNER_LOCATION_ID" +
      "        AND table7.C_LOCATION_ID = table8.C_LOCATION_ID" +
      "        AND table8.C_REGION_ID = table9.C_REGION_ID" +
      "        AND table10.C_BPARTNER_ID = table7.C_BPARTNER_ID" +
      "        AND table3.C_BPartner_ID = table4.C_BPartner_ID " +
      "        AND table3.C_Project_ID = table5.C_Project_ID " +
      "        AND table5.C_CURRENCY_ID = table15.C_CURRENCY_ID" +
      "	AND table3.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND table3.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "	AND 1=1";

    ResultSet result;
    Vector<RptCProposalJrData> vector = new Vector<RptCProposalJrData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cProjectProposalId != null && !(cProjectProposalId.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        RptCProposalJrData objectRptCProposalJrData = new RptCProposalJrData();
        objectRptCProposalJrData.headernote = UtilSql.getValue(result, "headernote");
        objectRptCProposalJrData.cProjectproposalId = UtilSql.getValue(result, "c_projectproposal_id");
        objectRptCProposalJrData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRptCProposalJrData.address1 = UtilSql.getValue(result, "address1");
        objectRptCProposalJrData.address2 = UtilSql.getValue(result, "address2");
        objectRptCProposalJrData.proposal = UtilSql.getValue(result, "proposal");
        objectRptCProposalJrData.reference = UtilSql.getValue(result, "reference");
        objectRptCProposalJrData.address = UtilSql.getValue(result, "address");
        objectRptCProposalJrData.city = UtilSql.getValue(result, "city");
        objectRptCProposalJrData.fecha = UtilSql.getDateValue(result, "fecha", "dd-MM-yyyy");
        objectRptCProposalJrData.fax = UtilSql.getValue(result, "fax");
        objectRptCProposalJrData.phone = UtilSql.getValue(result, "phone");
        objectRptCProposalJrData.name = UtilSql.getValue(result, "name");
        objectRptCProposalJrData.bpname = UtilSql.getValue(result, "bpname");
        objectRptCProposalJrData.namecontacto = UtilSql.getValue(result, "namecontacto");
        objectRptCProposalJrData.contacto = UtilSql.getValue(result, "contacto");
        objectRptCProposalJrData.cursymbol = UtilSql.getValue(result, "cursymbol");
        objectRptCProposalJrData.lineDesc = UtilSql.getValue(result, "line_desc");
        objectRptCProposalJrData.mProductIdD = UtilSql.getValue(result, "m_product_id_d");
        objectRptCProposalJrData.description = UtilSql.getValue(result, "description");
        objectRptCProposalJrData.price = UtilSql.getValue(result, "price");
        objectRptCProposalJrData.quantity = UtilSql.getValue(result, "quantity");
        objectRptCProposalJrData.uomname = UtilSql.getValue(result, "uomname");
        objectRptCProposalJrData.footnote = UtilSql.getValue(result, "footnote");
        objectRptCProposalJrData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCProposalJrData);
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
    RptCProposalJrData objectRptCProposalJrData[] = new RptCProposalJrData[vector.size()];
    vector.copyInto(objectRptCProposalJrData);
    return(objectRptCProposalJrData);
  }
}
