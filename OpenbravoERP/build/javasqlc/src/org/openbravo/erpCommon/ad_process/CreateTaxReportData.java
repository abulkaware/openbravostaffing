//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CreateTaxReportData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateTaxReportData.class);
  private String InitRecordNumber="0";
  public String numberRows;
  public String parent;
  public String id;
  public String name;
  public String description;
  public String issummary;
  public String isshown;
  public String nodeId;
  public String total;
  public String value;
  public String levelTax;
  public String classTax;
  public String classStyle;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("number_rows") || fieldName.equals("numberRows"))
      return numberRows;
    else if (fieldName.equalsIgnoreCase("parent"))
      return parent;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("isshown"))
      return isshown;
    else if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("level_tax") || fieldName.equals("levelTax"))
      return levelTax;
    else if (fieldName.equalsIgnoreCase("class_tax") || fieldName.equals("classTax"))
      return classTax;
    else if (fieldName.equalsIgnoreCase("class_style") || fieldName.equals("classStyle"))
      return classStyle;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateTaxReportData[] select(ConnectionProvider connectionProvider, String numberRows, String parent, String level, String adClientId, String adOrgId, String periodFrom, String periodTo, String cTaxReportId)    throws ServletException {
    return select(connectionProvider, numberRows, parent, level, adClientId, adOrgId, periodFrom, periodTo, cTaxReportId, 0, 0);
  }

  public static CreateTaxReportData[] select(ConnectionProvider connectionProvider, String numberRows, String parent, String level, String adClientId, String adOrgId, String periodFrom, String periodTo, String cTaxReportId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ? AS NUMBER_ROWS, ? AS PARENT, TR.C_TAX_REPORT_ID AS ID, TR.NAME, TR.DESCRIPTION, TR.ISSUMMARY, TR.ISSHOWN, " +
      "      AD_TREENODE.NODE_ID, COALESCE((CASE       " +
      "      TR.ISSUMMARY WHEN 'N' THEN      (CASE ISNEGATIVE WHEN 'Y' THEN SUM(A.TAXAMT)*(-1) WHEN 'N' THEN SUM(A.TAXAMT) END) ELSE 0 END),0) AS TOTAL, " +
      "      '' AS VALUE, ? AS LEVEL_TAX, (CASE TO_NUMBER(?) WHEN 0 THEN       " +
      "      '' ELSE '' END) AS CLASS_TAX, 'TEXT-INDENT: '||TO_CHAR(TO_NUMBER(?)*10)||'pt' AS CLASS_STYLE" +
      "      FROM C_TAX_REPORT TR LEFT JOIN (SELECT CASE WHEN DOCBASETYPE IN ('ARC','APC') THEN -1 * TAXAMT ELSE TAXAMT END AS TAXAMT, C_TAX_ID, C_INVOICE.ISSOTRX" +
      "      FROM C_INVOICETAX, C_INVOICE, C_DOCTYPE" +
      "      WHERE C_INVOICETAX.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "      AND C_INVOICE.C_DOCTYPE_ID = C_DOCTYPE.C_DOCTYPE_ID" +
      "      AND C_INVOICETAX.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICETAX.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND C_INVOICE.PROCESSED='Y'" +
      "      AND 1=1";
    strSql = strSql + ((periodFrom==null || periodFrom.equals(""))?"":"  AND C_INVOICE.DATEACCT >= TO_DATE(?) ");
    strSql = strSql + ((periodTo==null || periodTo.equals(""))?"":"  AND C_INVOICE.DATEACCT < TO_DATE(?) ");
    strSql = strSql + 
      ") A ON TR.C_TAX_ID = A.C_TAX_ID AND A.ISSOTRX = TR.ISSOTRX," +
      "      AD_TREE, AD_TREENODE" +
      "      WHERE AD_TREE.AD_TREE_ID = AD_TREENODE.AD_TREE_ID" +
      "      AND AD_TREENODE.NODE_ID = TR.C_TAX_REPORT_ID" +
      "      AND TR.C_TAX_REPORT_ID = ?" +
      "      AND AD_TREE.TREETYPE = 'TR'" +
      "      GROUP BY TR.C_TAX_REPORT_ID, TR.NAME, TR.DESCRIPTION, TR.ISSUMMARY, TR.ISSHOWN," +
      "      AD_TREENODE.NODE_ID, TR.ISNEGATIVE";

    ResultSet result;
    Vector<CreateTaxReportData> vector = new Vector<CreateTaxReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, numberRows);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (periodFrom != null && !(periodFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodFrom);
      }
      if (periodTo != null && !(periodTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxReportId);

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
        CreateTaxReportData objectCreateTaxReportData = new CreateTaxReportData();
        objectCreateTaxReportData.numberRows = UtilSql.getValue(result, "number_rows");
        objectCreateTaxReportData.parent = UtilSql.getValue(result, "parent");
        objectCreateTaxReportData.id = UtilSql.getValue(result, "id");
        objectCreateTaxReportData.name = UtilSql.getValue(result, "name");
        objectCreateTaxReportData.description = UtilSql.getValue(result, "description");
        objectCreateTaxReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateTaxReportData.isshown = UtilSql.getValue(result, "isshown");
        objectCreateTaxReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateTaxReportData.total = UtilSql.getValue(result, "total");
        objectCreateTaxReportData.value = UtilSql.getValue(result, "value");
        objectCreateTaxReportData.levelTax = UtilSql.getValue(result, "level_tax");
        objectCreateTaxReportData.classTax = UtilSql.getValue(result, "class_tax");
        objectCreateTaxReportData.classStyle = UtilSql.getValue(result, "class_style");
        objectCreateTaxReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateTaxReportData);
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
    CreateTaxReportData objectCreateTaxReportData[] = new CreateTaxReportData[vector.size()];
    vector.copyInto(objectCreateTaxReportData);
    return(objectCreateTaxReportData);
  }

  public static CreateTaxReportData[] set()    throws ServletException {
    CreateTaxReportData objectCreateTaxReportData[] = new CreateTaxReportData[1];
    objectCreateTaxReportData[0] = new CreateTaxReportData();
    objectCreateTaxReportData[0].numberRows = "";
    objectCreateTaxReportData[0].parent = "";
    objectCreateTaxReportData[0].id = "";
    objectCreateTaxReportData[0].name = "";
    objectCreateTaxReportData[0].description = "";
    objectCreateTaxReportData[0].issummary = "";
    objectCreateTaxReportData[0].isshown = "";
    objectCreateTaxReportData[0].nodeId = "";
    objectCreateTaxReportData[0].total = "";
    objectCreateTaxReportData[0].value = "";
    objectCreateTaxReportData[0].levelTax = "";
    objectCreateTaxReportData[0].classTax = "";
    objectCreateTaxReportData[0].classStyle = "";
    return objectCreateTaxReportData;
  }

  public static CreateTaxReportData[] selectChild(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cTaxReportId)    throws ServletException {
    return selectChild(connectionProvider, adClientId, adOrgId, cTaxReportId, 0, 0);
  }

  public static CreateTaxReportData[] selectChild(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cTaxReportId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TR.C_TAX_REPORT_ID AS ID, TR.NAME, TR.DESCRIPTION, TR.ISSUMMARY, TR.ISSHOWN, AD_TREENODE.NODE_ID" +
      "      FROM AD_TREE, AD_TREENODE, C_TAX_REPORT TR" +
      "      WHERE AD_TREE.AD_TREE_ID = AD_TREENODE.AD_TREE_ID" +
      "      AND AD_TREENODE.NODE_ID =  TR.C_TAX_REPORT_ID" +
      "      AND TR.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "      AND TR.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND AD_TREENODE.PARENT_ID = ?" +
      "      AND AD_TREE.TREETYPE = 'TR'" +
      "      GROUP BY TR.C_TAX_REPORT_ID, TR.NAME, TR.DESCRIPTION, TR.ISSUMMARY, TR.ISSHOWN, AD_TREENODE.NODE_ID, AD_TREENODE.SEQNO" +
      "      ORDER BY AD_TREENODE.SEQNO";

    ResultSet result;
    Vector<CreateTaxReportData> vector = new Vector<CreateTaxReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxReportId);

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
        CreateTaxReportData objectCreateTaxReportData = new CreateTaxReportData();
        objectCreateTaxReportData.id = UtilSql.getValue(result, "id");
        objectCreateTaxReportData.name = UtilSql.getValue(result, "name");
        objectCreateTaxReportData.description = UtilSql.getValue(result, "description");
        objectCreateTaxReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateTaxReportData.isshown = UtilSql.getValue(result, "isshown");
        objectCreateTaxReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateTaxReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateTaxReportData);
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
    CreateTaxReportData objectCreateTaxReportData[] = new CreateTaxReportData[vector.size()];
    vector.copyInto(objectCreateTaxReportData);
    return(objectCreateTaxReportData);
  }

  public static CreateTaxReportData[] selectOrg(ConnectionProvider connectionProvider, String adOrgId, String adClientId)    throws ServletException {
    return selectOrg(connectionProvider, adOrgId, adClientId, 0, 0);
  }

  public static CreateTaxReportData[] selectOrg(ConnectionProvider connectionProvider, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_ORG.AD_ORG_ID AS ID, AD_ORG.NAME, AD_ORG.ISSUMMARY, AD_TREENODE.NODE_ID" +
      "      FROM AD_CLIENTINFO, AD_TREENODE, AD_ORG" +
      "      WHERE AD_CLIENTINFO.AD_TREE_ORG_ID = AD_TREENODE.AD_TREE_ID" +
      "      AND AD_TREENODE.NODE_ID = AD_ORG.AD_ORG_ID" +
      "      AND AD_TREENODE.PARENT_ID = ?" +
      "      AND AD_CLIENTINFO.AD_CLIENT_ID = ?" +
      "      ORDER BY ISSUMMARY DESC";

    ResultSet result;
    Vector<CreateTaxReportData> vector = new Vector<CreateTaxReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        CreateTaxReportData objectCreateTaxReportData = new CreateTaxReportData();
        objectCreateTaxReportData.id = UtilSql.getValue(result, "id");
        objectCreateTaxReportData.name = UtilSql.getValue(result, "name");
        objectCreateTaxReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateTaxReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateTaxReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateTaxReportData);
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
    CreateTaxReportData objectCreateTaxReportData[] = new CreateTaxReportData[vector.size()];
    vector.copyInto(objectCreateTaxReportData);
    return(objectCreateTaxReportData);
  }

  public static String processId(ConnectionProvider connectionProvider, String processId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_PROCESS.AD_PROCESS_ID AS ID" +
      "      FROM AD_PROCESS" +
      "      WHERE VALUE = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String selectTax(ConnectionProvider connectionProvider, String cTaxReportId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_TAX_ID AS ID" +
      "      FROM C_TAX_REPORT" +
      "      WHERE C_TAX_REPORT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxReportId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static CreateTaxReportData[] selectC_TAX_REPORT(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cTaxReportId)    throws ServletException {
    return selectC_TAX_REPORT(connectionProvider, adOrgClient, adUserClient, cTaxReportId, 0, 0);
  }

  public static CreateTaxReportData[] selectC_TAX_REPORT(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String cTaxReportId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_TAX_REPORT_ID AS ID, NAME" +
      "      FROM C_TAX_REPORT" +
      "      WHERE AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ISREPORT='Y'" +
      "      AND (isActive = 'Y' OR C_TAX_REPORT_ID = ? )";

    ResultSet result;
    Vector<CreateTaxReportData> vector = new Vector<CreateTaxReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxReportId);

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
        CreateTaxReportData objectCreateTaxReportData = new CreateTaxReportData();
        objectCreateTaxReportData.id = UtilSql.getValue(result, "id");
        objectCreateTaxReportData.name = UtilSql.getValue(result, "name");
        objectCreateTaxReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateTaxReportData);
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
    CreateTaxReportData objectCreateTaxReportData[] = new CreateTaxReportData[vector.size()];
    vector.copyInto(objectCreateTaxReportData);
    return(objectCreateTaxReportData);
  }
}
