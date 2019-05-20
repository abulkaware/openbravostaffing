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

class ProjectCopyFromData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectCopyFromData.class);
  private String InitRecordNumber="0";
  public String cPhaseId;
  public String cProjectphaseId;
  public String name;
  public String seqno;
  public String description;
  public String help;
  public String mProductId;
  public String qty;
  public String cTaskId;
  public String id;
  public String cProjectlineId;
  public String line;
  public String plannedqty;
  public String mProductCategoryId;
  public String productDescription;
  public String productName;
  public String productValue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_phase_id") || fieldName.equals("cPhaseId"))
      return cPhaseId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
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
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_task_id") || fieldName.equals("cTaskId"))
      return cTaskId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("c_projectline_id") || fieldName.equals("cProjectlineId"))
      return cProjectlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("product_description") || fieldName.equals("productDescription"))
      return productDescription;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("product_value") || fieldName.equals("productValue"))
      return productValue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjectCopyFromData[] select(ConnectionProvider connectionProvider, String c_projecttype_id)    throws ServletException {
    return select(connectionProvider, c_projecttype_id, 0, 0);
  }

  public static ProjectCopyFromData[] select(ConnectionProvider connectionProvider, String c_projecttype_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.C_PHASE_ID, P.C_PROJECTPHASE_ID, P.NAME, P.SEQNO, P.DESCRIPTION, P.HELP," +
      "	        P.M_PRODUCT_ID, P.QTY, '' as C_TASK_ID, '' as id," +
      "	        '' as C_PROJECTLINE_ID, '' as LINE, '' as PLANNEDQTY, '' as M_PRODUCT_CATEGORY_ID," +
      "	        '' as PRODUCT_DESCRIPTION, '' as PRODUCT_NAME, '' as PRODUCT_VALUE " +
      "        FROM C_PROJECTPHASE P " +
      "		WHERE P.C_PROJECT_ID = ?" +
      "        ORDER BY P.SEQNO";

    ResultSet result;
    Vector<ProjectCopyFromData> vector = new Vector<ProjectCopyFromData>(0);
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
        ProjectCopyFromData objectProjectCopyFromData = new ProjectCopyFromData();
        objectProjectCopyFromData.cPhaseId = UtilSql.getValue(result, "c_phase_id");
        objectProjectCopyFromData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectProjectCopyFromData.name = UtilSql.getValue(result, "name");
        objectProjectCopyFromData.seqno = UtilSql.getValue(result, "seqno");
        objectProjectCopyFromData.description = UtilSql.getValue(result, "description");
        objectProjectCopyFromData.help = UtilSql.getValue(result, "help");
        objectProjectCopyFromData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectCopyFromData.qty = UtilSql.getValue(result, "qty");
        objectProjectCopyFromData.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectProjectCopyFromData.id = UtilSql.getValue(result, "id");
        objectProjectCopyFromData.cProjectlineId = UtilSql.getValue(result, "c_projectline_id");
        objectProjectCopyFromData.line = UtilSql.getValue(result, "line");
        objectProjectCopyFromData.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectProjectCopyFromData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProjectCopyFromData.productDescription = UtilSql.getValue(result, "product_description");
        objectProjectCopyFromData.productName = UtilSql.getValue(result, "product_name");
        objectProjectCopyFromData.productValue = UtilSql.getValue(result, "product_value");
        objectProjectCopyFromData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectCopyFromData);
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
    ProjectCopyFromData objectProjectCopyFromData[] = new ProjectCopyFromData[vector.size()];
    vector.copyInto(objectProjectCopyFromData);
    return(objectProjectCopyFromData);
  }

  public static ProjectCopyFromData[] selectServ(ConnectionProvider connectionProvider, String c_project_id)    throws ServletException {
    return selectServ(connectionProvider, c_project_id, 0, 0);
  }

  public static ProjectCopyFromData[] selectServ(ConnectionProvider connectionProvider, String c_project_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PL.C_PROJECTLINE_ID, PL.LINE, PL.DESCRIPTION," +
      "        	PL.PLANNEDQTY, PL.M_PRODUCT_ID, PL.M_PRODUCT_CATEGORY_ID," +
      "        	PL.PRODUCT_DESCRIPTION, PL.PRODUCT_NAME, PL.PRODUCT_VALUE " +
      "        FROM C_PROJECTLINE PL" +
      "        WHERE PL.C_PROJECT_ID = ?" +
      "        ORDER BY PL.LINE";

    ResultSet result;
    Vector<ProjectCopyFromData> vector = new Vector<ProjectCopyFromData>(0);
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
        ProjectCopyFromData objectProjectCopyFromData = new ProjectCopyFromData();
        objectProjectCopyFromData.cProjectlineId = UtilSql.getValue(result, "c_projectline_id");
        objectProjectCopyFromData.line = UtilSql.getValue(result, "line");
        objectProjectCopyFromData.description = UtilSql.getValue(result, "description");
        objectProjectCopyFromData.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectProjectCopyFromData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectCopyFromData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProjectCopyFromData.productDescription = UtilSql.getValue(result, "product_description");
        objectProjectCopyFromData.productName = UtilSql.getValue(result, "product_name");
        objectProjectCopyFromData.productValue = UtilSql.getValue(result, "product_value");
        objectProjectCopyFromData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectCopyFromData);
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
    ProjectCopyFromData objectProjectCopyFromData[] = new ProjectCopyFromData[vector.size()];
    vector.copyInto(objectProjectCopyFromData);
    return(objectProjectCopyFromData);
  }

  public static String selectProjectType(ConnectionProvider connectionProvider, String c_project_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT C_PROJECTTYPE_ID" +
      "	FROM C_PROJECT" +
      "	WHERE C_PROJECT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_projecttype_id");
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

  public static String selectProjCategory(ConnectionProvider connectionProvider, String c_project_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT PROJECTCATEGORY" +
      "	FROM C_PROJECT" +
      "	WHERE C_PROJECT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);

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

  public static boolean hasPhase(ConnectionProvider connectionProvider, String c_project_id, String c_phase_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(C_PROJECTPHASE_ID) AS TOTAL " +
      "        FROM C_PROJECTPHASE" +
      "        WHERE C_PROJECT_ID = ?" +
      "        AND C_PHASE_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_phase_id);

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

  public static ProjectCopyFromData[] selectTask(ConnectionProvider connectionProvider, String c_projectphase_id)    throws ServletException {
    return selectTask(connectionProvider, c_projectphase_id, 0, 0);
  }

  public static ProjectCopyFromData[] selectTask(ConnectionProvider connectionProvider, String c_projectphase_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT T.C_TASK_ID, T.SEQNO, T.NAME, T.DESCRIPTION, T.HELP," +
      "        T.M_PRODUCT_ID, T.QTY" +
      "        FROM C_PROJECTTASK T" +
      "        WHERE T.C_PROJECTPHASE_ID = ?" +
      "        ORDER BY T.SEQNO";

    ResultSet result;
    Vector<ProjectCopyFromData> vector = new Vector<ProjectCopyFromData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projectphase_id);

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
        ProjectCopyFromData objectProjectCopyFromData = new ProjectCopyFromData();
        objectProjectCopyFromData.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectProjectCopyFromData.seqno = UtilSql.getValue(result, "seqno");
        objectProjectCopyFromData.name = UtilSql.getValue(result, "name");
        objectProjectCopyFromData.description = UtilSql.getValue(result, "description");
        objectProjectCopyFromData.help = UtilSql.getValue(result, "help");
        objectProjectCopyFromData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectCopyFromData.qty = UtilSql.getValue(result, "qty");
        objectProjectCopyFromData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectCopyFromData);
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
    ProjectCopyFromData objectProjectCopyFromData[] = new ProjectCopyFromData[vector.size()];
    vector.copyInto(objectProjectCopyFromData);
    return(objectProjectCopyFromData);
  }

  public static int insertProjectPhase(Connection conn, ConnectionProvider connectionProvider, String c_project_id, String ad_client_id, String ad_org_id, String user, String description, String m_product_id, String c_phase_id, String c_projectphase_id, String help, String name, String qty, String seqno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_PROJECTPHASE " +
      "          (C_PROJECT_ID, AD_CLIENT_ID, AD_ORG_ID, " +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY, " +
      "           DESCRIPTION, M_PRODUCT_ID, C_PHASE_ID, " +
      "           C_PROJECTPHASE_ID, HELP, NAME, " +
      "           QTY, SEQNO) " +
      "        VALUES " +
      "          (?,?,?," +
      "           now(),?,now(),?," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           TO_NUMBER(?),TO_NUMBER(?))";

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

  public static int insertProjectTask(Connection conn, ConnectionProvider connectionProvider, String c_projecttask_id, String c_task_id, String ad_client_id, String ad_org_id, String user, String seqno, String name, String description, String help, String m_product_id, String c_projectphase_id, String qty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_PROJECTTASK " +
      "          (C_PROJECTTASK_ID, C_TASK_ID, AD_CLIENT_ID, AD_ORG_ID, " +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY, " +
      "           SEQNO, NAME, DESCRIPTION, " +
      "           HELP, M_PRODUCT_ID, C_PROJECTPHASE_ID, QTY) " +
      "        VALUES " +
      "          (?,?,?,?," +
      "           now(),?,now(),?," +
      "           TO_NUMBER(?),?,?," +
      "           ?,?,?,TO_NUMBER(?))";

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

  public static int insertProjectLine(Connection conn, ConnectionProvider connectionProvider, String c_projectline_id, String c_project_id, String ad_client_id, String ad_org_id, String user, String line, String description, String planned_qty, String m_product_id, String m_product_category_id, String product_description, String product_name, String product_value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_PROJECTLINE (C_PROJECTLINE_ID, C_PROJECT_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "	        UPDATED, UPDATEDBY, LINE, DESCRIPTION, PLANNEDQTY, M_PRODUCT_ID, M_PRODUCT_CATEGORY_ID, " +
      "	        PRODUCT_DESCRIPTION, PRODUCT_NAME, PRODUCT_VALUE) " +
      "        VALUES (?,?,?,?,now(),?," +
      "        	now(),?,TO_NUMBER(?),?,TO_NUMBER(?),?,?," +
      "        	?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projectline_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planned_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_category_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product_description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product_name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product_value);

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

  public static String selectProjectCategory(ConnectionProvider connectionProvider, String cprojectid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PROJECTCATEGORY FROM C_PROJECT" +
      "        WHERE C_PROJECT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cprojectid);

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

  public static ProjectCopyFromData[] selectC_Project_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String c_project_id, String cprojectid)    throws ServletException {
    return selectC_Project_ID(connectionProvider, adOrgClient, adUserClient, c_project_id, cprojectid, 0, 0);
  }

  public static ProjectCopyFromData[] selectC_Project_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String c_project_id, String cprojectid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Project.C_Project_ID as id, (C_Project.Value || ' - ' || C_Project.Name) as name FROM C_Project" +
      "      WHERE C_Project.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") AND C_Project.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") AND C_Project.isActive = 'Y' " +
      "      AND C_Project.C_Project_ID NOT IN (SELECT C_Project_ID FROM c_project WHERE c_project_ID = ?)" +
      "      AND C_Project.projectcategory IN (SELECT projectcategory FROM c_project WHERE c_project_ID = ?)" +
      "      ORDER BY name";

    ResultSet result;
    Vector<ProjectCopyFromData> vector = new Vector<ProjectCopyFromData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_project_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cprojectid);

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
        ProjectCopyFromData objectProjectCopyFromData = new ProjectCopyFromData();
        objectProjectCopyFromData.id = UtilSql.getValue(result, "id");
        objectProjectCopyFromData.name = UtilSql.getValue(result, "name");
        objectProjectCopyFromData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectCopyFromData);
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
    ProjectCopyFromData objectProjectCopyFromData[] = new ProjectCopyFromData[vector.size()];
    vector.copyInto(objectProjectCopyFromData);
    return(objectProjectCopyFromData);
  }
}
