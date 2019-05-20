//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProjectSetTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectSetTypeData.class);
  private String InitRecordNumber="0";
  public String cPhaseId;
  public String name;
  public String seqno;
  public String description;
  public String help;
  public String mProductId;
  public String standardqty;
  public String stdduration;
  public String adClientId;
  public String adOrgId;
  public String cTaskId;
  public String cProjectId;
  public String startdate;
  public String datecontract;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_phase_id") || fieldName.equals("cPhaseId"))
      return cPhaseId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("standardqty"))
      return standardqty;
    else if (fieldName.equalsIgnoreCase("stdduration"))
      return stdduration;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_task_id") || fieldName.equals("cTaskId"))
      return cTaskId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjectSetTypeData[] select(ConnectionProvider connectionProvider, String c_projecttype_id)    throws ServletException {
    return select(connectionProvider, c_projecttype_id, 0, 0);
  }

  public static ProjectSetTypeData[] select(ConnectionProvider connectionProvider, String c_projecttype_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.C_PHASE_ID, P.NAME, P.SEQNO, P.DESCRIPTION, P.HELP," +
      "        P.M_PRODUCT_ID, P.STANDARDQTY, P.STDDURATION, P.AD_CLIENT_ID, P.AD_ORG_ID, '' as C_TASK_ID, '' AS C_PROJECT_ID, '' as STARTDATE, '' as DATECONTRACT" +
      "        FROM C_PHASE P WHERE C_PROJECTTYPE_ID = ?" +
      "        ORDER BY P.SEQNO";

    ResultSet result;
    Vector<ProjectSetTypeData> vector = new Vector<ProjectSetTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projecttype_id);

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
        ProjectSetTypeData objectProjectSetTypeData = new ProjectSetTypeData();
        objectProjectSetTypeData.cPhaseId = UtilSql.getValue(result, "c_phase_id");
        objectProjectSetTypeData.name = UtilSql.getValue(result, "name");
        objectProjectSetTypeData.seqno = UtilSql.getValue(result, "seqno");
        objectProjectSetTypeData.description = UtilSql.getValue(result, "description");
        objectProjectSetTypeData.help = UtilSql.getValue(result, "help");
        objectProjectSetTypeData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectSetTypeData.standardqty = UtilSql.getValue(result, "standardqty");
        objectProjectSetTypeData.stdduration = UtilSql.getValue(result, "stdduration");
        objectProjectSetTypeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProjectSetTypeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProjectSetTypeData.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectProjectSetTypeData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectSetTypeData.startdate = UtilSql.getValue(result, "startdate");
        objectProjectSetTypeData.datecontract = UtilSql.getValue(result, "datecontract");
        objectProjectSetTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectSetTypeData);
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
    ProjectSetTypeData objectProjectSetTypeData[] = new ProjectSetTypeData[vector.size()];
    vector.copyInto(objectProjectSetTypeData);
    return(objectProjectSetTypeData);
  }

  public static ProjectSetTypeData[] selectProject(ConnectionProvider connectionProvider, String c_project_id)    throws ServletException {
    return selectProject(connectionProvider, c_project_id, 0, 0);
  }

  public static ProjectSetTypeData[] selectProject(ConnectionProvider connectionProvider, String c_project_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT C_PROJECT_ID, AD_CLIENT_ID, AD_ORG_ID" +
      "	FROM C_PROJECT" +
      "	WHERE C_PROJECT_ID = ?";

    ResultSet result;
    Vector<ProjectSetTypeData> vector = new Vector<ProjectSetTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);

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
        ProjectSetTypeData objectProjectSetTypeData = new ProjectSetTypeData();
        objectProjectSetTypeData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectSetTypeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProjectSetTypeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProjectSetTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectSetTypeData);
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
    ProjectSetTypeData objectProjectSetTypeData[] = new ProjectSetTypeData[vector.size()];
    vector.copyInto(objectProjectSetTypeData);
    return(objectProjectSetTypeData);
  }

  public static boolean hasProjectType(ConnectionProvider connectionProvider, String c_projecttype_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL" +
      "        FROM C_Project WHERE C_PROJECT_ID = ?" +
      "        AND C_ProjectType_ID IS NOT NULL";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projecttype_id);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }

  public static ProjectSetTypeData[] selectDates(ConnectionProvider connectionProvider, String c_project_id)    throws ServletException {
    return selectDates(connectionProvider, c_project_id, 0, 0);
  }

  public static ProjectSetTypeData[] selectDates(ConnectionProvider connectionProvider, String c_project_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT STARTDATE, DATECONTRACT FROM C_PROJECT WHERE C_PROJECT_ID = ?";

    ResultSet result;
    Vector<ProjectSetTypeData> vector = new Vector<ProjectSetTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);

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
        ProjectSetTypeData objectProjectSetTypeData = new ProjectSetTypeData();
        objectProjectSetTypeData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProjectSetTypeData.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectProjectSetTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectSetTypeData);
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
    ProjectSetTypeData objectProjectSetTypeData[] = new ProjectSetTypeData[vector.size()];
    vector.copyInto(objectProjectSetTypeData);
    return(objectProjectSetTypeData);
  }

  public static ProjectSetTypeData[] selectTask(ConnectionProvider connectionProvider, String C_PHASE_ID)    throws ServletException {
    return selectTask(connectionProvider, C_PHASE_ID, 0, 0);
  }

  public static ProjectSetTypeData[] selectTask(ConnectionProvider connectionProvider, String C_PHASE_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT T.C_TASK_ID, T.SEQNO, T.NAME, T.DESCRIPTION, T.HELP," +
      "        T.M_PRODUCT_ID, T.STANDARDQTY, T.STDDURATION" +
      "        FROM C_TASK T" +
      "        WHERE T.C_PHASE_ID = ?" +
      "        ORDER BY T.SEQNO";

    ResultSet result;
    Vector<ProjectSetTypeData> vector = new Vector<ProjectSetTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_PHASE_ID);

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
        ProjectSetTypeData objectProjectSetTypeData = new ProjectSetTypeData();
        objectProjectSetTypeData.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectProjectSetTypeData.seqno = UtilSql.getValue(result, "seqno");
        objectProjectSetTypeData.name = UtilSql.getValue(result, "name");
        objectProjectSetTypeData.description = UtilSql.getValue(result, "description");
        objectProjectSetTypeData.help = UtilSql.getValue(result, "help");
        objectProjectSetTypeData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectSetTypeData.standardqty = UtilSql.getValue(result, "standardqty");
        objectProjectSetTypeData.stdduration = UtilSql.getValue(result, "stdduration");
        objectProjectSetTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectSetTypeData);
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
    ProjectSetTypeData objectProjectSetTypeData[] = new ProjectSetTypeData[vector.size()];
    vector.copyInto(objectProjectSetTypeData);
    return(objectProjectSetTypeData);
  }

  public static String selectProjectCategory(ConnectionProvider connectionProvider, String c_projecttype_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PROJECTCATEGORY FROM C_PROJECTTYPE WHERE C_PROJECTTYPE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projecttype_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "projectcategory");
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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String user, String c_projecttype_id, String projectcategory, String c_project_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PROJECT SET UPDATEDBY = ?, UPDATED = now(), C_PROJECTTYPE_ID = ? , PROJECTCATEGORY = ?" +
      "        WHERE C_PROJECT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projecttype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateDates(Connection conn, ConnectionProvider connectionProvider, String user, String projectStartDate, String projectContractDate, String c_project_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PROJECT SET UPDATEDBY = ?, UPDATED = now(), STARTDATE = TO_DATE(?) , DATECONTRACT = TO_DATE(?)" +
      "        WHERE C_PROJECT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectStartDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectContractDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertProjectPhase(Connection conn, ConnectionProvider connectionProvider, String c_project_id, String ad_client_id, String ad_org_id, String user, String description, String m_product_id, String c_phase_id, String c_projectphase_id, String help, String name, String qty, String startdate, String datecontract, String seqno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_PROJECTPHASE " +
      "        (C_PROJECT_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, DESCRIPTION, M_PRODUCT_ID, C_PHASE_ID, C_PROJECTPHASE_ID, " +
      "        HELP, NAME, QTY, STARTDATE, DATECONTRACT, SEQNO) " +
      "        VALUES " +
      "        (?,?,?,now(),?," +
      "        now(),?,?,?,?,?," +
      "        ?,?,TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_phase_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projectphase_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertProjectTask(Connection conn, ConnectionProvider connectionProvider, String c_projecttask_id, String c_task_id, String ad_client_id, String ad_org_id, String user, String seqno, String name, String description, String help, String m_product_id, String c_projectphase_id, String qty, String startdate, String datecontract)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_PROJECTTASK " +
      "        (C_PROJECTTASK_ID, C_TASK_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, SEQNO, NAME, DESCRIPTION, HELP, " +
      "        M_PRODUCT_ID, C_PROJECTPHASE_ID, QTY, STARTDATE, DATECONTRACT) " +
      "        VALUES " +
      "        (?,?,?,?,now(),?," +
      "        now(),?,TO_NUMBER(?),?,?,?," +
      "        ?,?,TO_NUMBER(?), TO_DATE(?), TO_DATE(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projecttask_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_task_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projectphase_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
