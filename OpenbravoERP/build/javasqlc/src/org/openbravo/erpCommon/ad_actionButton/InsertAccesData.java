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

class InsertAccesData implements FieldProvider {
static Logger log4j = Logger.getLogger(InsertAccesData.class);
  private String InitRecordNumber="0";
  public String nodeId;
  public String parentId;
  public String issummary;
  public String action;
  public String adwindowid;
  public String adprocessid;
  public String adformid;
  public String printreport;
  public String editreference;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("parent_id") || fieldName.equals("parentId"))
      return parentId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("adwindowid"))
      return adwindowid;
    else if (fieldName.equalsIgnoreCase("adprocessid"))
      return adprocessid;
    else if (fieldName.equalsIgnoreCase("adformid"))
      return adformid;
    else if (fieldName.equalsIgnoreCase("printreport"))
      return printreport;
    else if (fieldName.equalsIgnoreCase("editreference"))
      return editreference;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InsertAccesData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static InsertAccesData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT tn.Node_ID,tn.Parent_ID, m.ISSUMMARY, m.action, m.AD_WINDOW_ID as adwindowid," +
      "        m.AD_PROCESS_ID as adprocessid, m.AD_FORM_ID as adformid," +
      "        tb.ad_process_id as printreport, tb.editreference as editreference" +
      "        FROM AD_TREENODE tn, AD_MENU m left join ad_tab tb " +
      "                                       on m.ad_window_id = tb.ad_window_id" +
      "                                          and (tb.ad_process_id is not null or tb.editreference is not null)" +
      "        WHERE tn.NODE_ID = m.AD_MENU_ID " +
      "        AND tn.ad_tree_id = '10' " +
      "        AND tn.IsActive='Y' ";

    ResultSet result;
    Vector<InsertAccesData> vector = new Vector<InsertAccesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        InsertAccesData objectInsertAccesData = new InsertAccesData();
        objectInsertAccesData.nodeId = UtilSql.getValue(result, "node_id");
        objectInsertAccesData.parentId = UtilSql.getValue(result, "parent_id");
        objectInsertAccesData.issummary = UtilSql.getValue(result, "issummary");
        objectInsertAccesData.action = UtilSql.getValue(result, "action");
        objectInsertAccesData.adwindowid = UtilSql.getValue(result, "adwindowid");
        objectInsertAccesData.adprocessid = UtilSql.getValue(result, "adprocessid");
        objectInsertAccesData.adformid = UtilSql.getValue(result, "adformid");
        objectInsertAccesData.printreport = UtilSql.getValue(result, "printreport");
        objectInsertAccesData.editreference = UtilSql.getValue(result, "editreference");
        objectInsertAccesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInsertAccesData);
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
    InsertAccesData objectInsertAccesData[] = new InsertAccesData[vector.size()];
    vector.copyInto(objectInsertAccesData);
    return(objectInsertAccesData);
  }

  public static String selectWindow(ConnectionProvider connectionProvider, String roleId, String windowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_window_Access" +
      "        where ad_role_id=?" +
      "        and ad_window_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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

  public static InsertAccesData[] selectWindowButtons(ConnectionProvider connectionProvider, String windowId, String roleId)    throws ServletException {
    return selectWindowButtons(connectionProvider, windowId, roleId, 0, 0);
  }

  public static InsertAccesData[] selectWindowButtons(ConnectionProvider connectionProvider, String windowId, String roleId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select distinct ad_column.ad_process_id as adprocessid" +
      "        from ad_tab, ad_field, ad_column" +
      "        where ad_tab.ad_window_id = ?" +
      "          and ad_tab.ad_tab_id = ad_field.ad_tab_id" +
      "          and ad_field.ad_column_id = ad_column.ad_column_id" +
      "          and ad_column.ad_process_id is not null" +
      "          and not exists (select 1 from ad_process_access pa" +
      "                          where pa.ad_process_id = ad_column.ad_process_id" +
      "                            and pa.ad_role_id = ?)";

    ResultSet result;
    Vector<InsertAccesData> vector = new Vector<InsertAccesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);

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
        InsertAccesData objectInsertAccesData = new InsertAccesData();
        objectInsertAccesData.adprocessid = UtilSql.getValue(result, "adprocessid");
        objectInsertAccesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInsertAccesData);
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
    InsertAccesData objectInsertAccesData[] = new InsertAccesData[vector.size()];
    vector.copyInto(objectInsertAccesData);
    return(objectInsertAccesData);
  }

  public static int insertWindow(ConnectionProvider connectionProvider, String windowId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_WINDOW_ACCESS (ad_WINDOW_ACCESS_ID, AD_WINDOW_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static String selectProcess(ConnectionProvider connectionProvider, String roleId, String processId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_process_Access" +
      "        where ad_role_id=?" +
      "        and ad_process_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

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

  public static int insertProcess(ConnectionProvider connectionProvider, String processId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_process_ACCESS (ad_process_ACCESS_ID, AD_process_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static String selectForm(ConnectionProvider connectionProvider, String roleId, String formId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_form_Access" +
      "        where ad_role_id=?" +
      "        and ad_form_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formId);

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

  public static int insertForm(ConnectionProvider connectionProvider, String formId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_form_ACCESS (ad_form_ACCESS_ID, AD_form_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
