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

class BusinessPartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(BusinessPartnerData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cBpartnerId;
  public String value;
  public String name;
  public String nameHidden;
  public String soCreditavailable;
  public String soCreditused;
  public String contact;
  public String cBpartnerContactId;
  public String phone;
  public String pc;
  public String cBpartnerLocationId;
  public String city;
  public String income;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name_hidden") || fieldName.equals("nameHidden"))
      return nameHidden;
    else if (fieldName.equalsIgnoreCase("so_creditavailable") || fieldName.equals("soCreditavailable"))
      return soCreditavailable;
    else if (fieldName.equalsIgnoreCase("so_creditused") || fieldName.equals("soCreditused"))
      return soCreditused;
    else if (fieldName.equalsIgnoreCase("contact"))
      return contact;
    else if (fieldName.equalsIgnoreCase("c_bpartner_contact_id") || fieldName.equals("cBpartnerContactId"))
      return cBpartnerContactId;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("pc"))
      return pc;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("income"))
      return income;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static BusinessPartnerData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String name, String contact, String codigoPostal, String provincia, String clients, String vendors, String ciudad, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return select(connectionProvider, rownum, adUserClient, adUserOrg, key, name, contact, codigoPostal, provincia, clients, vendors, ciudad, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static BusinessPartnerData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String name, String contact, String codigoPostal, String provincia, String clients, String vendors, String ciudad, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      		SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (      				   " +
      "					SELECT bp.C_BPartner_ID, bp.value, bp.name as name," +
      "					        bp.name as name_hidden, " +
      "					        (bp.SO_CreditLimit-bp.SO_CreditUsed) AS SO_CreditAvailable, bp.SO_CreditUsed, " +
      "					        u.name AS Contact, u.ad_user_id as C_BPartner_Contact_ID, bpl.Phone, l.Postal AS PC, " +
      "					        bpl.c_bpartner_location_id as C_BPartner_Location_ID," +
      "					        l.City, bp.ActualLifetimeValue AS Income, " +
      "					        bp.C_BPartner_ID || '@_##_@' || COALESCE(TO_CHAR(u.ad_user_id),'') || '@_##_@' || COALESCE(TO_CHAR(bpl.c_bpartner_location_id),'') || '@_##_@' || bp.name AS rowKey  " +
      "					        FROM C_BPARTNER bp left join C_BPARTNER_LOCATION bpl on bp.c_bpartner_id = bpl.c_bpartner_id" +
      "					                                                             and bpl.IsActive = 'Y'" +
      "					                           left join C_LOCATION l on bpl.c_location_id=l.C_Location_ID " +
      "					                           left join  C_REGION r on l.c_region_id = r.c_region_id " +
      "                                               left join ad_user u on bp.c_bpartner_id = u.c_bpartner_id" +
      "					        WHERE bp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "					        AND bp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "					        AND (u.isactive is null OR u.isactive='Y') and (u.c_bpartner_location_id is null or u.c_bpartner_location_id = bpl.C_BPartner_Location_ID)" +
      "					        AND bp.IsSummary='N' " +
      "					        AND bp.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":" AND UPPER(bp.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":" AND UPPER(bp.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((contact==null || contact.equals("") || contact.equals("%") )?"":" AND UPPER(u.name) LIKE UPPER(?)  ");
    strSql = strSql + ((codigoPostal==null || codigoPostal.equals("") || codigoPostal.equals("%") )?"":" AND UPPER(l.Postal) LIKE UPPER(?)  ");
    strSql = strSql + ((provincia==null || provincia.equals("") || provincia.equals("%") )?"":" AND UPPER(r.NAME) LIKE UPPER(?) ");
    strSql = strSql + ((clients.equals("clients"))?" AND ISCUSTOMER = 'Y'  ":"");
    strSql = strSql + ((vendors.equals("vendors"))?" AND ISVENDOR ='Y' ":"");
    strSql = strSql + ((ciudad==null || ciudad.equals("") || ciudad.equals("%") )?"":" AND UPPER(l.City) LIKE UPPER(?)  ");
    strSql = strSql + 
      "					        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "					) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") B" +
      "			WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    Vector<BusinessPartnerData> vector = new Vector<BusinessPartnerData>(0);
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
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (contact != null && !(contact.equals("")) && !(contact.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, contact);
      }
      if (codigoPostal != null && !(codigoPostal.equals("")) && !(codigoPostal.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, codigoPostal);
      }
      if (provincia != null && !(provincia.equals("")) && !(provincia.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, provincia);
      }
      if (clients != null && !(clients.equals(""))) {
        }
      if (vendors != null && !(vendors.equals(""))) {
        }
      if (ciudad != null && !(ciudad.equals("")) && !(ciudad.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ciudad);
      }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
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
        BusinessPartnerData objectBusinessPartnerData = new BusinessPartnerData();
        objectBusinessPartnerData.rn1 = UtilSql.getValue(result, "rn1");
        objectBusinessPartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBusinessPartnerData.value = UtilSql.getValue(result, "value");
        objectBusinessPartnerData.name = UtilSql.getValue(result, "name");
        objectBusinessPartnerData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectBusinessPartnerData.soCreditavailable = UtilSql.getValue(result, "so_creditavailable");
        objectBusinessPartnerData.soCreditused = UtilSql.getValue(result, "so_creditused");
        objectBusinessPartnerData.contact = UtilSql.getValue(result, "contact");
        objectBusinessPartnerData.cBpartnerContactId = UtilSql.getValue(result, "c_bpartner_contact_id");
        objectBusinessPartnerData.phone = UtilSql.getValue(result, "phone");
        objectBusinessPartnerData.pc = UtilSql.getValue(result, "pc");
        objectBusinessPartnerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectBusinessPartnerData.city = UtilSql.getValue(result, "city");
        objectBusinessPartnerData.income = UtilSql.getValue(result, "income");
        objectBusinessPartnerData.rowkey = UtilSql.getValue(result, "rowkey");
        objectBusinessPartnerData.position = Long.toString(countRecord);
        objectBusinessPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBusinessPartnerData);
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
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[vector.size()];
    vector.copyInto(objectBusinessPartnerData);
    return(objectBusinessPartnerData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String name, String contact, String codigoPostal, String provincia, String clients, String vendors, String ciudad, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	      SELECT COUNT(*) AS VALUE  " +
      "	        FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS rn1, B.* FROM " +
      "	      (SELECT 1 FROM C_BPARTNER bp left join C_BPARTNER_LOCATION bpl on bp.c_bpartner_id = bpl.c_bpartner_id" +
      "	                                                             and bpl.IsActive = 'Y'" +
      "	                           left join C_LOCATION l on bpl.c_location_id=l.C_Location_ID " +
      "	                           left join  C_REGION r on l.c_region_id = r.c_region_id " +
      "	                           left join ad_user  u on bp.c_bpartner_id = u.c_bpartner_id" +
      "	        WHERE bp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "	        AND bp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "	        AND (u.isactive is null OR u.isactive='Y') and (u.c_bpartner_location_id is null or u.c_bpartner_location_id = bpl.C_BPartner_Location_ID)" +
      "	        AND bp.IsSummary='N' " +
      "	        AND bp.IsActive='Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":" AND UPPER(bp.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":" AND UPPER(bp.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((contact==null || contact.equals("") || contact.equals("%") )?"":" AND UPPER(u.name) LIKE UPPER(?)  ");
    strSql = strSql + ((codigoPostal==null || codigoPostal.equals("") || codigoPostal.equals("%") )?"":" AND UPPER(l.Postal) LIKE UPPER(?)  ");
    strSql = strSql + ((provincia==null || provincia.equals("") || provincia.equals("%") )?"":" AND UPPER(r.NAME) LIKE UPPER(?) ");
    strSql = strSql + ((clients.equals("clients"))?" AND ISCUSTOMER = 'Y'  ":"");
    strSql = strSql + ((vendors.equals("vendors"))?" AND ISVENDOR ='Y' ":"");
    strSql = strSql + ((ciudad==null || ciudad.equals("") || ciudad.equals("%") )?"":" AND UPPER(l.City) LIKE UPPER(?)  ");
    strSql = strSql + 
      "	        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "	        ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "	        ) A ";
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
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (contact != null && !(contact.equals("")) && !(contact.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, contact);
      }
      if (codigoPostal != null && !(codigoPostal.equals("")) && !(codigoPostal.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, codigoPostal);
      }
      if (provincia != null && !(provincia.equals("")) && !(provincia.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, provincia);
      }
      if (clients != null && !(clients.equals(""))) {
        }
      if (vendors != null && !(vendors.equals(""))) {
        }
      if (ciudad != null && !(ciudad.equals("")) && !(ciudad.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ciudad);
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

  public static BusinessPartnerData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String clients, String vendors, String key, String pgLimit, String oraLimit1)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, clients, vendors, key, pgLimit, oraLimit1, 0, 0);
  }

  public static BusinessPartnerData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String clients, String vendors, String key, String pgLimit, String oraLimit1, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT A.* FROM (                      " +
      "        SELECT bp.C_BPartner_ID, bp.value, bp.name as name, u.ad_user_id as C_BPartner_Contact_ID," +
      "        bpl.c_bpartner_location_id as C_BPartner_Location_ID" +
      "        FROM C_BPARTNER bp left join C_BPARTNER_LOCATION bpl on bp.c_bpartner_id = bpl.c_bpartner_id" +
      "                                                             and bpl.IsActive = 'Y'" +
      "                           left join C_LOCATION l on bpl.c_location_id=l.C_Location_ID" +
      "                           left join  C_REGION r on  l.c_region_id = r.c_region_id" +
      "                           left join ad_user  u on bp.c_bpartner_id = u.c_bpartner_id" +
      "        WHERE  bp.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND bp.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND (u.isactive is null OR u.isactive='Y') and (u.c_bpartner_location_id is null or u.c_bpartner_location_id = bpl.C_BPartner_Location_ID)" +
      "        AND bp.IsSummary='N' " +
      "        AND bp.IsActive='Y'";
    strSql = strSql + ((clients.equals("clients"))?" AND ISCUSTOMER = 'Y'  ":"");
    strSql = strSql + ((vendors.equals("vendors"))?" AND ISVENDOR ='Y' ":"");
    strSql = strSql + 
      "        AND UPPER(bp.VALUE) LIKE UPPER(?)" +
      "        ORDER BY bp.name";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "      ) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);

    ResultSet result;
    Vector<BusinessPartnerData> vector = new Vector<BusinessPartnerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (clients != null && !(clients.equals(""))) {
        }
      if (vendors != null && !(vendors.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
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
        BusinessPartnerData objectBusinessPartnerData = new BusinessPartnerData();
        objectBusinessPartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBusinessPartnerData.value = UtilSql.getValue(result, "value");
        objectBusinessPartnerData.name = UtilSql.getValue(result, "name");
        objectBusinessPartnerData.cBpartnerContactId = UtilSql.getValue(result, "c_bpartner_contact_id");
        objectBusinessPartnerData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectBusinessPartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBusinessPartnerData);
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
    BusinessPartnerData objectBusinessPartnerData[] = new BusinessPartnerData[vector.size()];
    vector.copyInto(objectBusinessPartnerData);
    return(objectBusinessPartnerData);
  }

  public static String existsActual(ConnectionProvider connectionProvider, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT bp.name as name" +
      "        FROM C_BPARTNER bp " +
      "        WHERE UPPER(bp.name) = UPPER(?)" +
      "        AND bp.C_BPartner_ID = ? " +
      "        ORDER BY bp.name";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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

  public static String existsActualValue(ConnectionProvider connectionProvider, String description, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT bp.value as value" +
      "        FROM C_BPARTNER bp " +
      "        WHERE UPPER(bp.name) = UPPER(?)" +
      "        AND bp.C_BPartner_ID = ? " +
      "        ORDER BY bp.value";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
}
