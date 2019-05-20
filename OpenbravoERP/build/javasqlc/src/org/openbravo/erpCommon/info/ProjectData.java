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

class ProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String cProjectId;
  public String value;
  public String name;
  public String cBpartnerId;
  public String bpartner;
  public String projectstatus;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjectData[] select(ConnectionProvider connectionProvider, String rownum, String language, String adUserClient, String adUserOrg, String key, String name, String bpartner, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, language, adUserClient, adUserOrg, key, name, bpartner, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static ProjectData[] select(ConnectionProvider connectionProvider, String rownum, String language, String adUserClient, String adUserOrg, String key, String name, String bpartner, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (  " +
      "        SELECT P.C_PROJECT_ID, P.VALUE, P.NAME, P.C_BPARTNER_ID, " +
      "        B.NAME AS BPARTNER, L.NAME AS PROJECTSTATUS," +
      "        p.c_Project_Id || '@_##_@' || p.value || ' - ' || p.name as rowkey" +
      "        FROM C_PROJECT P, C_BPARTNER B, AD_REF_LIST_V L " +
      "        WHERE P.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "        AND P.PROJECTSTATUS = L.VALUE " +
      "        AND L.AD_REFERENCE_ID = '800002' " +
      "        AND L.AD_LANGUAGE = ? " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND P.C_BPARTNER_ID = ?  ");
    strSql = strSql + 
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "		) A ) B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<ProjectData> vector = new Vector<ProjectData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
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
        ProjectData objectProjectData = new ProjectData();
        objectProjectData.rn1 = UtilSql.getValue(result, "rn1");
        objectProjectData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectData.value = UtilSql.getValue(result, "value");
        objectProjectData.name = UtilSql.getValue(result, "name");
        objectProjectData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProjectData.bpartner = UtilSql.getValue(result, "bpartner");
        objectProjectData.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectProjectData.rowkey = UtilSql.getValue(result, "rowkey");
        objectProjectData.position = Long.toString(countRecord);
        objectProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectData);
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
    ProjectData objectProjectData[] = new ProjectData[vector.size()];
    vector.copyInto(objectProjectData);
    return(objectProjectData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String language, String adUserClient, String adUserOrg, String key, String name, String bpartner, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM (  " +
      "        SELECT 1" +
      "        FROM C_PROJECT P, C_BPARTNER B, AD_REF_LIST_V L " +
      "        WHERE P.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "        AND P.PROJECTSTATUS = L.VALUE " +
      "        AND L.AD_REFERENCE_ID = '800002' " +
      "        AND L.AD_LANGUAGE = ? " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND P.C_BPARTNER_ID = ?  ");
    strSql = strSql + 
      "        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "		) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "		) A ";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
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
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
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

  public static ProjectData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String bpartner, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, bpartner, key, 0, 0);
  }

  public static ProjectData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String bpartner, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.C_PROJECT_ID, P.VALUE, P.NAME, P.C_BPARTNER_ID, B.NAME AS BPARTNER" +
      "        FROM C_PROJECT P, C_BPARTNER B " +
      "        WHERE P.C_BPARTNER_ID = B.C_BPARTNER_ID " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  AND P.C_BPARTNER_ID = ?  ");
    strSql = strSql + 
      "        AND UPPER(P.VALUE) LIKE UPPER(?)" +
      "        ORDER BY P.NAME";

    ResultSet result;
    Vector<ProjectData> vector = new Vector<ProjectData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
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
        ProjectData objectProjectData = new ProjectData();
        objectProjectData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectData.value = UtilSql.getValue(result, "value");
        objectProjectData.name = UtilSql.getValue(result, "name");
        objectProjectData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProjectData.bpartner = UtilSql.getValue(result, "bpartner");
        objectProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectData);
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
    ProjectData objectProjectData[] = new ProjectData[vector.size()];
    vector.copyInto(objectProjectData);
    return(objectProjectData);
  }

  public static String selectTercero(ConnectionProvider connectionProvider, String cBparnterId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBparnterId);

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
