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
Organization Data
 */
class OrganizationData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrganizationData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cLocationId;
  public String cLocationIdr;
  public String duns;
  public String taxid;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String logo;
  public String referenceOrder;
  public String trBgcolor;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String language;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_location_idr") || fieldName.equals("cLocationIdr"))
      return cLocationIdr;
    else if (fieldName.equalsIgnoreCase("duns"))
      return duns;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("logo"))
      return logo;
    else if (fieldName.equalsIgnoreCase("reference_order") || fieldName.equals("referenceOrder"))
      return referenceOrder;
    else if (fieldName.equalsIgnoreCase("tr_bgcolor") || fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select Organization
 */
  public static OrganizationData[] select(ConnectionProvider connectionProvider, String paramLanguage, String adUserClient, String adOrgClient)    throws ServletException {
    return select(connectionProvider, paramLanguage, adUserClient, adOrgClient, 0, 0);
  }

/**
Select Organization
 */
  public static OrganizationData[] select(ConnectionProvider connectionProvider, String paramLanguage, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      " SELECT " +
      "  AD_OrgInfo.AD_Client_ID, " +
      "  (CASE WHEN AD_OrgInfo.AD_Client_ID IS NULL THEN '' ELSE  (TO_CHAR(client.Name) ) END) AS AD_Client_IDR, " +
      "  AD_OrgInfo.AD_Org_ID, " +
      "  (CASE WHEN AD_OrgInfo.AD_Org_ID IS NULL THEN '' ELSE  (TO_CHAR(org.Name) ) END) AS AD_Org_IDR, " +
      "  COALESCE(AD_OrgInfo.IsActive, 'N') AS IsActive, " +
      "  AD_OrgInfo.C_Location_ID, " +
      "  (CASE WHEN AD_OrgInfo.C_Location_ID IS NULL THEN '' ELSE  (TO_CHAR(loc.Address1)  || ' - ' || TO_CHAR(loc.Address2)  || ' - ' || TO_CHAR(loc.Postal)  || ' - ' || TO_CHAR(loc.City)  || ' - ' || TO_CHAR(reg.Name)  || ' - ' || TO_CHAR((CASE WHEN countryTrl.Name IS NULL THEN TO_CHAR(country.Name) ELSE TO_CHAR(countryTrl.Name) END)) ) END) AS C_Location_IDR, " +
      "  AD_OrgInfo.DUNS, " +
      "  AD_OrgInfo.TaxID, " +
      "  AD_OrgInfo.C_BPartner_ID, " +
      "  (CASE WHEN AD_OrgInfo.C_BPartner_ID IS NULL THEN '' ELSE  (TO_CHAR(bpart.Name) ) END) AS C_BPartner_IDR, " +
      "  AD_OrgInfo.Logo, " +
      "  COALESCE(AD_OrgInfo.Reference_Order, 'N') AS Reference_Order, " +
      "  '' AS TR_BGCOLOR , " +
      "  AD_OrgInfo.Created, " +
      "  AD_OrgInfo.CreatedBy, " +
      "  AD_OrgInfo.Updated, " +
      "  AD_OrgInfo.UpdatedBy, ? AS LANGUAGE  " +
      " FROM " +
      "  AD_OrgInfo " +
      "  left join (select AD_Client_ID, Name from AD_Client) client on (AD_OrgInfo.AD_Client_ID = client.AD_Client_ID) " +
      "  left join (select AD_Org_ID, Name from AD_Org) org on (AD_OrgInfo.AD_Org_ID = org.AD_Org_ID) " +
      "  left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) loc on (AD_OrgInfo.C_Location_ID = loc.C_Location_ID) " +
      "  left join (select C_Region_ID, Name from C_Region) reg on (loc.C_Region_ID = reg.C_Region_ID) " +
      "  left join (select C_Country_ID, Name from C_Country) country on (loc.C_Country_ID = country.C_Country_ID) " +
      "  left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) countryTrl on (country.C_Country_ID = countryTrl.C_Country_ID and countryTrl.AD_Language = ?)  " +
      "  left join (select C_BPartner_ID, Name from C_BPartner) bpart on (AD_OrgInfo.C_BPartner_ID = bpart.C_BPartner_ID)" +
      " WHERE " +
      "  AD_OrgInfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "  AND AD_OrgInfo.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<OrganizationData> vector = new Vector<OrganizationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        OrganizationData objectOrganizationData = new OrganizationData();
        objectOrganizationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOrganizationData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectOrganizationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrganizationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOrganizationData.isactive = UtilSql.getValue(result, "isactive");
        objectOrganizationData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectOrganizationData.cLocationIdr = UtilSql.getValue(result, "c_location_idr");
        objectOrganizationData.duns = UtilSql.getValue(result, "duns");
        objectOrganizationData.taxid = UtilSql.getValue(result, "taxid");
        objectOrganizationData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectOrganizationData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectOrganizationData.logo = UtilSql.getValue(result, "logo");
        objectOrganizationData.referenceOrder = UtilSql.getValue(result, "reference_order");
        objectOrganizationData.trBgcolor = UtilSql.getValue(result, "tr_bgcolor");
        objectOrganizationData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectOrganizationData.createdby = UtilSql.getValue(result, "createdby");
        objectOrganizationData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectOrganizationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOrganizationData.language = UtilSql.getValue(result, "language");
        objectOrganizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrganizationData);
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
    OrganizationData objectOrganizationData[] = new OrganizationData[vector.size()];
    vector.copyInto(objectOrganizationData);
    return(objectOrganizationData);
  }

  public static String selectOrgName(ConnectionProvider connectionProvider, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(SOCIAL_NAME, NAME) AS NAME FROM AD_ORG" +
      "        WHERE AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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
