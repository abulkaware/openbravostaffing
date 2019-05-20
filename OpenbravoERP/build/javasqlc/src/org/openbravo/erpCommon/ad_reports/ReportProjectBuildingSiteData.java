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

class ReportProjectBuildingSiteData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProjectBuildingSiteData.class);
  private String InitRecordNumber="0";
  public String projectname;
  public String bpartnername;
  public String productname;
  public String plannedqty;
  public String plannedprice;
  public String plannedpricesym;
  public String convplannedprice;
  public String plannedpoprice;
  public String plannedpopricesym;
  public String convplannedpoprice;
  public String convsym;
  public String convisosym;
  public String transdate;
  public String transcurrencyid;
  public String transclientid;
  public String transorgid;
  public String blankSpace;
  public String numberProject;
  public String name;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("projectname"))
      return projectname;
    else if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("plannedprice"))
      return plannedprice;
    else if (fieldName.equalsIgnoreCase("plannedpricesym"))
      return plannedpricesym;
    else if (fieldName.equalsIgnoreCase("convplannedprice"))
      return convplannedprice;
    else if (fieldName.equalsIgnoreCase("plannedpoprice"))
      return plannedpoprice;
    else if (fieldName.equalsIgnoreCase("plannedpopricesym"))
      return plannedpopricesym;
    else if (fieldName.equalsIgnoreCase("convplannedpoprice"))
      return convplannedpoprice;
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
    else if (fieldName.equalsIgnoreCase("blank_space") || fieldName.equals("blankSpace"))
      return blankSpace;
    else if (fieldName.equalsIgnoreCase("number_project") || fieldName.equals("numberProject"))
      return numberProject;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProjectBuildingSiteData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String dateFrom, String dateTo, String cbPartnerId, String cProjectId, String cProductCategoryId, String cProjectKind, String cProjectPhase, String cProjectStatus, String cProjectPublic, String cRegionId, String salesRep, String productId)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserClient, adUserOrg, dateFrom, dateTo, cbPartnerId, cProjectId, cProductCategoryId, cProjectKind, cProjectPhase, cProjectStatus, cProjectPublic, cRegionId, salesRep, productId, 0, 0);
  }

  public static ReportProjectBuildingSiteData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String dateFrom, String dateTo, String cbPartnerId, String cProjectId, String cProductCategoryId, String cProjectKind, String cProjectPhase, String cProjectStatus, String cProjectPublic, String cRegionId, String salesRep, String productId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_PROJECT.VALUE||' - '||C_PROJECT.NAME AS PROJECTNAME, (CASE WHEN C_BPARTNER.NAME IS NULL THEN '' ELSE REPLACE(TO_CHAR(C_BPARTNER.NAME), '&', '') END) AS BPARTNERNAME, M_PRODUCT.NAME AS PRODUCTNAME, " +
      "      SUM(C_PROJECTLINE.PLANNEDQTY) AS PLANNEDQTY, C_PROJECTLINE.PLANNEDPRICE AS PLANNEDPRICE," +
      "      C_CURRENCY_SYMBOL(C_PROJECT.C_CURRENCY_ID, C_PROJECTLINE.PLANNEDPRICE, 'Y') AS PLANNEDPRICESYM," +
      "	  C_CURRENCY_CONVERT(C_PROJECTLINE.PLANNEDPRICE, C_PROJECT.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, NOW())), NULL, C_PROJECTLINE.AD_CLIENT_ID, C_PROJECTLINE.AD_ORG_ID) AS CONVPLANNEDPRICE, " +
      "      (SUM(C_PROJECTLINE.PLANNEDQTY)*C_PROJECTLINE.PLANNEDPRICE)  AS PLANNEDPOPRICE," +
      "      C_CURRENCY_SYMBOL(C_PROJECT.C_CURRENCY_ID, C_PROJECTLINE.PLANNEDPRICE, 'Y') AS PLANNEDPOPRICESYM, " +
      "	  C_CURRENCY_CONVERT(SUM(C_PROJECTLINE.PLANNEDQTY)*C_PROJECTLINE.PLANNEDPRICE, C_PROJECT.C_CURRENCY_ID, ?, TO_DATE(COALESCE(C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, NOW())), NULL, C_PROJECTLINE.AD_CLIENT_ID, C_PROJECTLINE.AD_ORG_ID) AS CONVPLANNEDPOPRICE," +
      "      C_CURRENCY_SYMBOL(?, '0', 'Y') AS CONVSYM," +
      "	  C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "	  TO_DATE(COALESCE(C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, NOW())) AS TRANSDATE," +
      "	  C_PROJECT.C_CURRENCY_ID AS TRANSCURRENCYID," +
      "	  C_PROJECTLINE.AD_CLIENT_ID AS TRANSCLIENTID, " +
      "	  C_PROJECTLINE.AD_ORG_ID AS TRANSORGID, " +
      "      (CASE WHEN C_BPARTNER.NAME IS NULL THEN '&#x00A0;' ELSE '' END) AS BLANK_SPACE, '1' AS NUMBER_PROJECT, '' AS NAME, '' AS ID" +
      "      FROM C_PROJECT left join C_BPARTNER on C_PROJECT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "                     left join C_PROJECTLINE on C_PROJECT.C_PROJECT_ID = C_PROJECTLINE.C_PROJECT_ID " +
      "                     left join C_LOCATION on C_PROJECT.C_LOCATION_ID = C_LOCATION.C_LOCATION_ID" +
      "                     left join M_PRODUCT on C_PROJECTLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      WHERE C_PROJECT.ISACTIVE = 'Y'" +
      "      AND C_PROJECTLINE.ISACTIVE = 'Y'" +
      "      AND C_PROJECT.PROJECTCATEGORY <> 'S'" +
      "      AND C_PROJECT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND C_PROJECT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND C_PROJECT.STARTDATE >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND C_PROJECT.STARTDATE < to_date(?) ");
    strSql = strSql + ((cbPartnerId==null || cbPartnerId.equals(""))?"":"  AND C_PROJECT.C_BPARTNER_ID IN" + cbPartnerId);
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
      "      GROUP BY C_BPARTNER.NAME, C_PROJECT.NAME, M_PRODUCT.NAME, C_PROJECTLINE.PLANNEDQTY, C_PROJECTLINE.PLANNEDPRICE, C_PROJECT.VALUE," +
      "      C_PROJECT.C_CURRENCY_ID, C_PROJECT.DATECONTRACT, C_PROJECT.DATEFINISH, C_PROJECTLINE.AD_CLIENT_ID, C_PROJECTLINE.AD_ORG_ID       " +
      "      ORDER BY C_BPARTNER.NAME, C_PROJECT.VALUE";

    ResultSet result;
    Vector<ReportProjectBuildingSiteData> vector = new Vector<ReportProjectBuildingSiteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        ReportProjectBuildingSiteData objectReportProjectBuildingSiteData = new ReportProjectBuildingSiteData();
        objectReportProjectBuildingSiteData.projectname = UtilSql.getValue(result, "projectname");
        objectReportProjectBuildingSiteData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectReportProjectBuildingSiteData.productname = UtilSql.getValue(result, "productname");
        objectReportProjectBuildingSiteData.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectReportProjectBuildingSiteData.plannedprice = UtilSql.getValue(result, "plannedprice");
        objectReportProjectBuildingSiteData.plannedpricesym = UtilSql.getValue(result, "plannedpricesym");
        objectReportProjectBuildingSiteData.convplannedprice = UtilSql.getValue(result, "convplannedprice");
        objectReportProjectBuildingSiteData.plannedpoprice = UtilSql.getValue(result, "plannedpoprice");
        objectReportProjectBuildingSiteData.plannedpopricesym = UtilSql.getValue(result, "plannedpopricesym");
        objectReportProjectBuildingSiteData.convplannedpoprice = UtilSql.getValue(result, "convplannedpoprice");
        objectReportProjectBuildingSiteData.convsym = UtilSql.getValue(result, "convsym");
        objectReportProjectBuildingSiteData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportProjectBuildingSiteData.transdate = UtilSql.getDateValue(result, "transdate", "dd-MM-yyyy");
        objectReportProjectBuildingSiteData.transcurrencyid = UtilSql.getValue(result, "transcurrencyid");
        objectReportProjectBuildingSiteData.transclientid = UtilSql.getValue(result, "transclientid");
        objectReportProjectBuildingSiteData.transorgid = UtilSql.getValue(result, "transorgid");
        objectReportProjectBuildingSiteData.blankSpace = UtilSql.getValue(result, "blank_space");
        objectReportProjectBuildingSiteData.numberProject = UtilSql.getValue(result, "number_project");
        objectReportProjectBuildingSiteData.name = UtilSql.getValue(result, "name");
        objectReportProjectBuildingSiteData.id = UtilSql.getValue(result, "id");
        objectReportProjectBuildingSiteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProjectBuildingSiteData);
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
    ReportProjectBuildingSiteData objectReportProjectBuildingSiteData[] = new ReportProjectBuildingSiteData[vector.size()];
    vector.copyInto(objectReportProjectBuildingSiteData);
    return(objectReportProjectBuildingSiteData);
  }

  public static ReportProjectBuildingSiteData[] set()    throws ServletException {
    ReportProjectBuildingSiteData objectReportProjectBuildingSiteData[] = new ReportProjectBuildingSiteData[1];
    objectReportProjectBuildingSiteData[0] = new ReportProjectBuildingSiteData();
    objectReportProjectBuildingSiteData[0].projectname = "";
    objectReportProjectBuildingSiteData[0].bpartnername = "";
    objectReportProjectBuildingSiteData[0].productname = "";
    objectReportProjectBuildingSiteData[0].plannedqty = "";
    objectReportProjectBuildingSiteData[0].plannedprice = "";
    objectReportProjectBuildingSiteData[0].plannedpricesym = "";
    objectReportProjectBuildingSiteData[0].convplannedprice = "";
    objectReportProjectBuildingSiteData[0].plannedpoprice = "";
    objectReportProjectBuildingSiteData[0].plannedpopricesym = "";
    objectReportProjectBuildingSiteData[0].convplannedpoprice = "";
    objectReportProjectBuildingSiteData[0].convsym = "";
    objectReportProjectBuildingSiteData[0].convisosym = "";
    objectReportProjectBuildingSiteData[0].transdate = "";
    objectReportProjectBuildingSiteData[0].transcurrencyid = "";
    objectReportProjectBuildingSiteData[0].transclientid = "";
    objectReportProjectBuildingSiteData[0].transorgid = "";
    objectReportProjectBuildingSiteData[0].blankSpace = "";
    objectReportProjectBuildingSiteData[0].numberProject = "";
    objectReportProjectBuildingSiteData[0].name = "";
    objectReportProjectBuildingSiteData[0].id = "";
    return objectReportProjectBuildingSiteData;
  }

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

  public static String selectProjectpublic(ConnectionProvider connectionProvider, String adLanguage, String projectpublic)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT (CASE WHEN arl_t.NAME IS NULL THEN arl.NAME ELSE arl_t.NAME END) AS NAME " +
      "    FROM AD_REF_LIST arl left join AD_REF_LIST_TRL arl_t on arl.ad_ref_list_id = arl_t.ad_ref_list_id " +
      "                                                        AND arl_t.AD_LANGUAGE = ?" +
      "    WHERE arl.ad_reference_id = '800005' " +
      "    AND arl.isActive = 'Y' " +
      "    AND 1=1";
    strSql = strSql + ((projectpublic==null || projectpublic.equals(""))?"":"  AND arl.VALUE IN" + projectpublic);

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (projectpublic != null && !(projectpublic.equals(""))) {
        }

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

  public static String selectSalesRep(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (AD_User.Firstname||' '||AD_USER.LASTNAME) as name " +
      "      FROM AD_User" +
      "      WHERE AD_User.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "      AND AD_User.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")  " +
      "      AND EXISTS (SELECT * FROM C_BPartner bp WHERE AD_User.C_BPartner_ID=bp.C_BPartner_ID AND bp.IsSalesRep='Y')" +
      "      AND AD_USER.AD_USER_ID = ?" +
      "      AND AD_User.isActive = 'Y' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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
