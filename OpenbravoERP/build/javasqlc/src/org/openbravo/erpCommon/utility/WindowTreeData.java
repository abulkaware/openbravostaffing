//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class WindowTreeData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowTreeData.class);
  private String InitRecordNumber="0";
  public String nodeId;
  public String parentId;
  public String seqno;
  public String id;
  public String name;
  public String description;
  public String issummary;
  public String action;
  public String adWindowId;
  public String adProcessId;
  public String adFormId;
  public String isindevelopment;
  public String isready;
  public String adOrgtypeId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("parent_id") || fieldName.equals("parentId"))
      return parentId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("isindevelopment"))
      return isindevelopment;
    else if (fieldName.equalsIgnoreCase("isready"))
      return isready;
    else if (fieldName.equalsIgnoreCase("ad_orgtype_id") || fieldName.equals("adOrgtypeId"))
      return adOrgtypeId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WindowTreeData[] select(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return select(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] select(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.AD_Menu_ID AS ID, m.Name,m.Description,m.IsSummary," +
      "        m.Action, m.AD_Window_ID, m.AD_Process_ID, m.AD_Form_ID," +
      "        (case when (select count(*) from ad_module where type='T' and isindevelopment='Y')=0 " +
      "               then Mo.ISINDEVELOPMENT " +
      "               else 'Y' end) as isInDevelopment, " +
      "        '' as IsReady, '' as AD_OrgType_ID" +
      "        FROM AD_TreeNode tn,          " +
      "             AD_Menu m," +
      "             AD_Module Mo" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.AD_Menu_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND Mo.AD_Module_ID = m.AD_Module_ID" +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.action = UtilSql.getValue(result, "action");
        objectWindowTreeData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWindowTreeData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWindowTreeData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWindowTreeData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectWindowTreeData.isready = UtilSql.getValue(result, "isready");
        objectWindowTreeData.adOrgtypeId = UtilSql.getValue(result, "ad_orgtype_id");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectTrl(connectionProvider, adLanguage, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectTrl(ConnectionProvider connectionProvider, String adLanguage, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.AD_Menu_ID AS ID, " +
      "               COALESCE (t.Name, m.Name) as name,t.Description,m.IsSummary," +
      "        m.Action, m.AD_Window_ID, m.AD_Process_ID, m.AD_Form_ID," +
      "        (case when (select count(*) from ad_module where type='T' and isindevelopment='Y')=0 " +
      "               then Mo.ISINDEVELOPMENT " +
      "               else 'Y' end) as isInDevelopment" +
      "        FROM AD_TreeNode tn, " +
      "             AD_Menu m left join AD_Menu_Trl t on m.AD_Menu_ID = t.AD_Menu_ID " +
      "                                               AND t.AD_Language = ?" +
      "                                               AND m.AD_Menu_ID = t.AD_Menu_ID," +
      "             AD_Module Mo" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      " tn.Node_ID = m.AD_Menu_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND Mo.AD_Module_ID = m.AD_Module_ID" +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.action = UtilSql.getValue(result, "action");
        objectWindowTreeData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWindowTreeData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectWindowTreeData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectWindowTreeData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectOrg(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectOrg(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectOrg(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.AD_Org_ID AS ID, m.Name,m.Description,m.IsSummary,m.IsReady, m.AD_OrgType_ID" +
      "        FROM AD_TreeNode tn," +
      "         AD_Org m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.AD_Org_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.isready = UtilSql.getValue(result, "isready");
        objectWindowTreeData.adOrgtypeId = UtilSql.getValue(result, "ad_orgtype_id");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectProductCategory(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectProductCategory(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectProductCategory(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.M_Product_Category_ID AS ID, m.Name,m.Description, m.IsSummary " +
      "        FROM AD_TreeNode tn, " +
      "          M_Product_Category m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.M_Product_Category_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectCostcenter(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectCostcenter(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectCostcenter(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, c.C_Costcenter_ID AS ID, c.Name, c.Description, c.IsSummary " +
      "        FROM AD_TreeNode tn, " +
      "          C_Costcenter c" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND c.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = c.C_Costcenter_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectUser1(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectUser1(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectUser1(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, u1.User1_ID AS ID, u1.Name, u1.Description, u1.IsSummary " +
      "        FROM AD_TreeNode tn, " +
      "          User1 u1" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND u1.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = u1.User1_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectUser2(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectUser2(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectUser2(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, u2.User2_ID AS ID, u2.Name, u2.Description, u2.IsSummary " +
      "        FROM AD_TreeNode tn, " +
      "          User2 u2" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND u2.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = u2.User2_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectBOM(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectBOM(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectBOM(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.M_Product_BOM_ID AS ID, p.Name,p.Description, p.IsBOM AS IsSummary " +
      "        FROM AD_TreeNode tn, " +
      "          M_Product_BOM m, M_Product p" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.M_Product_BOM_ID " +
      "        AND m.M_ProductBOM_ID = p.M_Product_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectElementValue(ConnectionProvider connectionProvider, String adLanguage, String editable, String parentId, String nodeId, String adTreeId, String cElementId)    throws ServletException {
    return selectElementValue(connectionProvider, adLanguage, editable, parentId, nodeId, adTreeId, cElementId, 0, 0);
  }

  public static WindowTreeData[] selectElementValue(ConnectionProvider connectionProvider, String adLanguage, String editable, String parentId, String nodeId, String adTreeId, String cElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_ElementValue_ID AS ID, " +
      "                m.value||' - '||coalesce(mt.name, m.name) as Name,m.Description,m.IsSummary " +
      "        FROM C_ElementValue m left join c_elementvalue_trl mt on mt.c_elementvalue_id = m.c_elementvalue_id" +
      "                                  and mt.ad_language = ?," +
      "             AD_TreeNode tn" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_ElementValue_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        AND m.C_Element_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectCampaign(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectCampaign(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectCampaign(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_Campaign_ID AS ID, m.Name,m.Description, m.IsSummary " +
      "        FROM AD_TreeNode tn, " +
      "              C_Campaign m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      " tn.Node_ID = m.C_Campaign_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectProject(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectProject(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectProject(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_Project_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNode tn, C_Project m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_Project_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectActivity(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectActivity(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectActivity(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_Activity_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNode tn, C_Activity m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      " tn.Node_ID = m.C_Activity_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectSalesRegion(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectSalesRegion(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectSalesRegion(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_SalesRegion_ID AS ID, m.Name,m.Description,m.IsSummary " +
      "        FROM AD_TreeNode tn, C_SalesRegion m" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = m.C_SalesRegion_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectAccountingReport(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectAccountingReport(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectAccountingReport(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, ar.AD_AccountingRpt_Element_ID AS ID, ar.Name,ar.Description,ar.IsSummary " +
      "        FROM AD_TreeNode tn, AD_AccountingRpt_Element ar" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND ar.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = ar.AD_AccountingRpt_Element_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTaxReport(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectTaxReport(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectTaxReport(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, tr.C_TAX_REPORT_ID AS ID, tr.NAME,tr.Description,tr.IsSummary " +
      "        FROM AD_TREENODE tn, C_TAX_REPORT tr" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND tr.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = tr.C_TAX_REPORT_ID" +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectAsset(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId)    throws ServletException {
    return selectAsset(connectionProvider, editable, parentId, nodeId, adTreeId, 0, 0);
  }

  public static WindowTreeData[] selectAsset(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, a.A_Asset_ID AS ID, a.Name,a.Description,a.IsSummary " +
      "        FROM AD_TreeNode tn, A_Asset a" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND a.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.Node_ID = a.A_Asset_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectOBRE_ResouceCategory(ConnectionProvider connectionProvider, String columnname, String tablename, String adTreeId, String editable, String parentId, String nodeId)    throws ServletException {
    return selectOBRE_ResouceCategory(connectionProvider, columnname, tablename, adTreeId, editable, parentId, nodeId, 0, 0);
  }

  public static WindowTreeData[] selectOBRE_ResouceCategory(ConnectionProvider connectionProvider, String columnname, String tablename, String adTreeId, String editable, String parentId, String nodeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, a.";
    strSql = strSql + ((columnname==null || columnname.equals(""))?"":columnname);
    strSql = strSql + 
      " AS ID, " +
      "        a.Name,a.Description,a.IsSummary " +
      "        FROM AD_TreeNode tn, ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      " a" +
      "        WHERE 1=1 " +
      "        AND tn.Node_ID = a.";
    strSql = strSql + ((columnname==null || columnname.equals(""))?"":columnname);
    strSql = strSql + 
      "        AND tn.AD_Tree_ID = ? " +
      "        AND 2=2 ";
    strSql = strSql + ((editable.equals("editable"))?" AND tn.IsActive='Y' AND a.isActive='Y'  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" AND tn.Parent_ID = ?  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" AND tn.Node_ID = ?  ");
    strSql = strSql + 
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (columnname != null && !(columnname.equals(""))) {
        }
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (columnname != null && !(columnname.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectChValue(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, String mCharacteristicId)    throws ServletException {
    return selectChValue(connectionProvider, editable, parentId, nodeId, adTreeId, mCharacteristicId, 0, 0);
  }

  public static WindowTreeData[] selectChValue(ConnectionProvider connectionProvider, String editable, String parentId, String nodeId, String adTreeId, String mCharacteristicId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID, tn.Parent_ID, tn.SeqNo, m.m_ch_value_id AS ID," +
      "            m.name AS Name, '' as description, m.IsSummary " +
      "        FROM m_ch_value m JOIN AD_TreeNode tn ON tn.Node_ID = m.m_ch_value_id" +
      "        WHERE ";
    strSql = strSql + ((editable.equals("editable"))?" tn.IsActive='Y' AND m.isActive='Y' AND  ":"");
    strSql = strSql + ((parentId==null || parentId.equals(""))?"":" tn.Parent_ID = ? AND  ");
    strSql = strSql + ((nodeId==null || nodeId.equals(""))?"":" tn.Node_ID = ? AND  ");
    strSql = strSql + 
      "tn.AD_Tree_ID = ? " +
      "          AND m.m_characteristic_id = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (editable != null && !(editable.equals(""))) {
        }
      if (parentId != null && !(parentId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      }
      if (nodeId != null && !(nodeId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mCharacteristicId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectWindowTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTreeID(ConnectionProvider connectionProvider, String adClientId, String treetype)    throws ServletException {
    return selectTreeID(connectionProvider, adClientId, treetype, 0, 0);
  }

  public static WindowTreeData[] selectTreeID(ConnectionProvider connectionProvider, String adClientId, String treetype, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NODE_ID, ID, NAME " +
      "        FROM (" +
      "         SELECT AD_Client_ID as Node_ID, AD_Tree_ID AS ID, NAME, 1 AS SEQNO" +
      "        FROM AD_Tree t1" +
      "        WHERE t1.AD_Client_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")  " +
      "        AND AD_Client_ID != '0'" +
      "        AND TreeType = ? " +
      "        AND IsActive = 'Y'" +
      "      UNION" +
      "       SELECT AD_Client_ID as Node_ID, AD_Tree_ID AS ID, NAME, 2 AS SEQNO" +
      "        FROM AD_Tree t2" +
      "        WHERE t2.AD_Client_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND AD_Client_id = '0'" +
      "        AND TreeType = ?" +
      "        AND IsActive = 'Y') f" +
      "        ORDER BY SEQNO";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treetype);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treetype);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectTreeIDWithTableId(ConnectionProvider connectionProvider, String adClientId, String ad_table_id)    throws ServletException {
    return selectTreeIDWithTableId(connectionProvider, adClientId, ad_table_id, 0, 0);
  }

  public static WindowTreeData[] selectTreeIDWithTableId(ConnectionProvider connectionProvider, String adClientId, String ad_table_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NODE_ID, ID, NAME " +
      "        FROM (" +
      "         SELECT AD_Client_ID as Node_ID, AD_Tree_ID AS ID, NAME, 1 AS SEQNO" +
      "        FROM AD_Tree t1" +
      "        WHERE t1.AD_Client_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")  " +
      "        AND AD_Client_ID != '0'" +
      "        AND ad_table_id = ? " +
      "        AND IsActive = 'Y'" +
      "      UNION" +
      "       SELECT AD_Client_ID as Node_ID, AD_Tree_ID AS ID, NAME, 2 AS SEQNO" +
      "        FROM AD_Tree t2" +
      "        WHERE t2.AD_Client_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND AD_Client_id = '0'" +
      "        AND ad_table_id = ?" +
      "        AND IsActive = 'Y') f" +
      "        ORDER BY SEQNO";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_table_id);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_table_id);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.id = UtilSql.getValue(result, "id");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] TreeName(ConnectionProvider connectionProvider, String adTreeId, String adClientId, String treetype)    throws ServletException {
    return TreeName(connectionProvider, adTreeId, adClientId, treetype, 0, 0);
  }

  public static WindowTreeData[] TreeName(ConnectionProvider connectionProvider, String adTreeId, String adClientId, String treetype, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME, DESCRIPTION " +
      "        FROM AD_Tree " +
      "        WHERE AD_Tree_ID = ? " +
      "        AND AD_Org_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND TreeType = ? " +
      "        AND IsActive = 'Y'";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, treetype);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static String selectKey(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C.COLUMNNAME" +
      "        FROM AD_TAB T, AD_COLUMN C " +
      "        WHERE T.AD_TABLE_ID = C.AD_TABLE_ID" +
      "        AND (C.ISKEY = 'Y'" +
      "        OR C.ISSECONDARYKEY='Y')" +
      "        AND T.AD_TAB_ID = ? " +
      "        AND C.ISACTIVE='Y'" +
      "        ORDER BY C.SEQNO";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "columnname");
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

  public static String selectTableName(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TB.TABLENAME" +
      "        FROM AD_TAB T, AD_TABLE TB " +
      "        WHERE T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "        AND T.AD_TAB_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tablename");
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

  public static String selectEditable(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ISREADONLY" +
      "        FROM AD_TAB " +
      "        WHERE AD_TAB_ID = ? ";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isreadonly");
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

  public static WindowTreeData[] selectTabName(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return selectTabName(connectionProvider, adTabId, 0, 0);
  }

  public static WindowTreeData[] selectTabName(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT w.Name as Description, t.Name as NAME" +
      "        FROM AD_Window w, AD_TAB t" +
      "        WHERE w.AD_Window_ID = t.AD_Window_ID " +
      "        AND t.AD_TAB_ID = ? " +
      "        AND t.isActive = 'Y'";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.description = UtilSql.getValue(result, "description");
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static WindowTreeData[] selectParents(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return selectParents(connectionProvider, adTabId, 0, 0);
  }

  public static WindowTreeData[] selectParents(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COLUMNNAME AS Name, ad_window_id AS node_Id" +
      "        FROM AD_COLUMN c, AD_FIELD f, AD_TAB t " +
      "        WHERE t.ad_tab_id = f.ad_tab_id " +
      "        AND f.ad_column_id = c.ad_column_id " +
      "        AND t.ad_tab_id = ?" +
      "        AND c.isparent='Y' " +
      "        ORDER BY f.SeqNo";

    ResultSet result;
    Vector<WindowTreeData> vector = new Vector<WindowTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        WindowTreeData objectWindowTreeData = new WindowTreeData();
        objectWindowTreeData.name = UtilSql.getValue(result, "name");
        objectWindowTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectWindowTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTreeData);
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
    WindowTreeData objectWindowTreeData[] = new WindowTreeData[vector.size()];
    vector.copyInto(objectWindowTreeData);
    return(objectWindowTreeData);
  }

  public static String selectIsReady(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ISREADY" +
      "        FROM AD_ORG" +
      "        WHERE AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isready");
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

  public static String selectIsStatic(ConnectionProvider connectionProvider, String tablename, String recordId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A.ISSTATIC" +
      "        FROM ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      " A" +
      "        WHERE A.";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      "_ID = ?";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (tablename != null && !(tablename.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isstatic");
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

  public static int update(ConnectionProvider connectionProvider, String updatedby, String parentId, String seqno, String adTreeId, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_TREENODE SET UPDATED=now(), UPDATEDBY = ?, PARENT_id = ?, SEQNO=TO_NUMBER(?) " +
      "        WHERE AD_TREE_ID = ? " +
      "        AND NODE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

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
