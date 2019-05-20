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

class CreateAccountingReportData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateAccountingReportData.class);
  private String InitRecordNumber="0";
  public String parent;
  public String id;
  public String name;
  public String description;
  public String issummary;
  public String isshown;
  public String nodeId;
  public String total;
  public String filteredbyorganization;
  public String temporaryfiltertype;
  public String value;
  public String levelAccount;
  public String classAccount;
  public String classStyle;
  public String padre;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("parent"))
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
    else if (fieldName.equalsIgnoreCase("filteredbyorganization"))
      return filteredbyorganization;
    else if (fieldName.equalsIgnoreCase("temporaryfiltertype"))
      return temporaryfiltertype;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("level_account") || fieldName.equals("levelAccount"))
      return levelAccount;
    else if (fieldName.equalsIgnoreCase("class_account") || fieldName.equals("classAccount"))
      return classAccount;
    else if (fieldName.equalsIgnoreCase("class_style") || fieldName.equals("classStyle"))
      return classStyle;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateAccountingReportData[] select(ConnectionProvider connectionProvider, String parent, String level, String adClientId, String adOrgId, String accountId, String periodFrom, String periodTo, String acctschema, String adAccountingElementId)    throws ServletException {
    return select(connectionProvider, parent, level, adClientId, adOrgId, accountId, periodFrom, periodTo, acctschema, adAccountingElementId, 0, 0);
  }

  public static CreateAccountingReportData[] select(ConnectionProvider connectionProvider, String parent, String level, String adClientId, String adOrgId, String accountId, String periodFrom, String periodTo, String acctschema, String adAccountingElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT ? AS PARENT, B.ID, B.NAME, B.DESCRIPTION, B.ISSUMMARY, B.ISSHOWN," +
      "            B.NODE_ID," +
      "            CASE" +
      "                WHEN B.CONSIDER_ZERO = 'N' AND B.TOTAL < 0 THEN 0" +
      "                WHEN B.CONSIDER_ZERO = 'P' AND B.TOTAL > 0 THEN 0" +
      "                ELSE B.TOTAL" +
      "            END AS TOTAL," +
      "            B.FILTEREDBYORGANIZATION, B.TEMPORARYFILTERTYPE, '' AS VALUE, ? AS LEVEL_ACCOUNT," +
      "            '' AS CLASS_ACCOUNT, 'TEXT-INDENT: '||TO_CHAR(TO_NUMBER(?)*10)||'pt' AS CLASS_STYLE," +
      "            '' AS PADRE" +
      "          FROM (" +
      "            SELECT AR.AD_ACCOUNTINGRPT_ELEMENT_ID AS ID, AR.NAME, AR.DESCRIPTION, AR.ISSUMMARY, AR.ISSHOWN," +
      "            AD_TREENODE.NODE_ID, AR.FILTEREDBYORGANIZATION, AR.TEMPORARYFILTERTYPE, AR.CONSIDER_ZERO," +
      "            COALESCE((" +
      "              CASE AR.ISSUMMARY" +
      "                  WHEN 'N' THEN (" +
      "                      CASE REPORT_TYPE" +
      "                          WHEN 'cc' THEN SUM(A.AMTACCTCR)" +
      "                          WHEN 'dd' THEN SUM(A.AMTACCTDR)" +
      "                          WHEN 'dc' THEN SUM(A.AMTACCTDR - A.AMTACCTCR)" +
      "                          WHEN 'cd' THEN SUM(A.AMTACCTCR - A.AMTACCTDR)" +
      "                          WHEN '-c' THEN -SUM(A.AMTACCTCR)" +
      "                          WHEN '-d' THEN -SUM(A.AMTACCTDR)" +
      "                      END)" +
      "                  ELSE 0" +
      "              END), 0) AS TOTAL" +
      "          FROM AD_ACCOUNTINGRPT_ELEMENT AR" +
      "              LEFT JOIN (" +
      "                SELECT AMTACCTDR, AMTACCTCR, C_ACCTSCHEMA_ID" +
      "                FROM FACT_ACCT" +
      "                WHERE FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "                  AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "                  AND FACT_ACCT.ACCOUNT_ID IN (";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":accountId);
    strSql = strSql + 
      ")" +
      "                  AND 1=1";
    strSql = strSql + ((periodFrom==null || periodFrom.equals(""))?"":"  AND FACT_ACCT.DATEACCT >= TO_DATE(?) ");
    strSql = strSql + ((periodTo==null || periodTo.equals(""))?"":"  AND FACT_ACCT.DATEACCT < TO_DATE(?) ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND FACT_ACCT.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      ") A on AR.C_ACCTSCHEMA_ID = A.C_ACCTSCHEMA_ID," +
      "              AD_TREE, AD_TREENODE" +
      "          WHERE AD_TREE.AD_TREE_ID = AD_TREENODE.AD_TREE_ID" +
      "            AND AD_TREENODE.NODE_ID = AR.AD_ACCOUNTINGRPT_ELEMENT_ID" +
      "            AND AR.AD_ACCOUNTINGRPT_ELEMENT_ID = ?" +
      "            AND AD_TREE.TREETYPE = 'AR'" +
      "          GROUP BY REPORT_TYPE, AR.AD_ACCOUNTINGRPT_ELEMENT_ID, AR.NAME, AR.DESCRIPTION, AR.ISSUMMARY, AR.ISSHOWN," +
      "            AD_TREENODE.NODE_ID, AR.FILTEREDBYORGANIZATION, AR.TEMPORARYFILTERTYPE, AR.CONSIDER_ZERO) B";

    ResultSet result;
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (accountId != null && !(accountId.equals(""))) {
        }
      if (periodFrom != null && !(periodFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodFrom);
      }
      if (periodTo != null && !(periodTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodTo);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingElementId);

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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.parent = UtilSql.getValue(result, "parent");
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.description = UtilSql.getValue(result, "description");
        objectCreateAccountingReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateAccountingReportData.isshown = UtilSql.getValue(result, "isshown");
        objectCreateAccountingReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateAccountingReportData.total = UtilSql.getValue(result, "total");
        objectCreateAccountingReportData.filteredbyorganization = UtilSql.getValue(result, "filteredbyorganization");
        objectCreateAccountingReportData.temporaryfiltertype = UtilSql.getValue(result, "temporaryfiltertype");
        objectCreateAccountingReportData.value = UtilSql.getValue(result, "value");
        objectCreateAccountingReportData.levelAccount = UtilSql.getValue(result, "level_account");
        objectCreateAccountingReportData.classAccount = UtilSql.getValue(result, "class_account");
        objectCreateAccountingReportData.classStyle = UtilSql.getValue(result, "class_style");
        objectCreateAccountingReportData.padre = UtilSql.getValue(result, "padre");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
  }

  public static CreateAccountingReportData[] selectInitial(ConnectionProvider connectionProvider, String parent, String level, String adClientId, String adOrgId, String accountId, String periodFrom, String periodTo, String acctschema, String adAccountingElementId)    throws ServletException {
    return selectInitial(connectionProvider, parent, level, adClientId, adOrgId, accountId, periodFrom, periodTo, acctschema, adAccountingElementId, 0, 0);
  }

  public static CreateAccountingReportData[] selectInitial(ConnectionProvider connectionProvider, String parent, String level, String adClientId, String adOrgId, String accountId, String periodFrom, String periodTo, String acctschema, String adAccountingElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ? AS PARENT, B.ID, B.NAME, B.DESCRIPTION, B.ISSUMMARY, B.ISSHOWN," +
      "        B.NODE_ID," +
      "            CASE" +
      "                WHEN B.CONSIDER_ZERO = 'N' AND B.TOTAL < 0 THEN 0" +
      "                WHEN B.CONSIDER_ZERO = 'P' AND B.TOTAL > 0 THEN 0" +
      "                ELSE B.TOTAL" +
      "            END AS TOTAL, B.FILTEREDBYORGANIZATION," +
      "        B.TEMPORARYFILTERTYPE, '' AS VALUE, ? AS LEVEL_ACCOUNT, '' AS CLASS_ACCOUNT," +
      "        'TEXT-INDENT: '||TO_CHAR(TO_NUMBER(?)*10)||'pt' AS CLASS_STYLE," +
      "        '' AS PADRE" +
      "      FROM (" +
      "        SELECT AR.AD_ACCOUNTINGRPT_ELEMENT_ID AS ID, AR.NAME, AR.DESCRIPTION, AR.ISSUMMARY, AR.ISSHOWN," +
      "          AD_TREENODE.NODE_ID," +
      "          COALESCE((" +
      "            CASE AR.ISSUMMARY" +
      "                WHEN 'N' THEN (" +
      "                  CASE REPORT_TYPE" +
      "                      WHEN 'cc' THEN SUM(A.AMTACCTCR)" +
      "                      WHEN 'dd' THEN SUM(A.AMTACCTDR)" +
      "                      WHEN 'dc' THEN SUM(A.AMTACCTDR - A.AMTACCTCR)" +
      "                      WHEN 'cd' THEN SUM(A.AMTACCTCR - A.AMTACCTDR)" +
      "                      WHEN '-c' THEN -SUM(A.AMTACCTCR)" +
      "                      WHEN '-d' THEN -SUM(A.AMTACCTDR)" +
      "                  END)" +
      "                ELSE 0" +
      "            END), 0) AS TOTAL," +
      "          AR.FILTEREDBYORGANIZATION, AR.TEMPORARYFILTERTYPE, AR.CONSIDER_ZERO" +
      "        FROM AD_ACCOUNTINGRPT_ELEMENT AR" +
      "            LEFT JOIN (" +
      "              SELECT AMTACCTDR, AMTACCTCR, C_ACCTSCHEMA_ID" +
      "              FROM FACT_ACCT" +
      "              WHERE FACT_ACCT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "                AND FACT_ACCT.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "                AND FACT_ACCT.ACCOUNT_ID IN (";
    strSql = strSql + ((accountId==null || accountId.equals(""))?"":accountId);
    strSql = strSql + 
      ")" +
      "                AND 1=1";
    strSql = strSql + ((periodFrom==null || periodFrom.equals(""))?"":"  AND FACT_ACCT.DATEACCT >= TO_DATE(?) ");
    strSql = strSql + ((periodTo==null || periodTo.equals(""))?"":"  AND FACT_ACCT.DATEACCT < TO_DATE(?) ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND FACT_ACCT.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "              AND FACT_ACCT.FACTACCTTYPE = 'O') A on AR.C_ACCTSCHEMA_ID = A.C_ACCTSCHEMA_ID," +
      "            AD_TREE, AD_TREENODE" +
      "        WHERE AD_TREE.AD_TREE_ID = AD_TREENODE.AD_TREE_ID" +
      "          AND AD_TREENODE.NODE_ID = AR.AD_ACCOUNTINGRPT_ELEMENT_ID" +
      "          AND AR.AD_ACCOUNTINGRPT_ELEMENT_ID = ?" +
      "          AND AD_TREE.TREETYPE = 'AR'" +
      "        GROUP BY REPORT_TYPE, AR.AD_ACCOUNTINGRPT_ELEMENT_ID, AR.NAME, AR.DESCRIPTION, AR.ISSUMMARY, AR.ISSHOWN," +
      "          AD_TREENODE.NODE_ID, AR.FILTEREDBYORGANIZATION, AR.TEMPORARYFILTERTYPE, AR.CONSIDER_ZERO) B";

    ResultSet result;
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (accountId != null && !(accountId.equals(""))) {
        }
      if (periodFrom != null && !(periodFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodFrom);
      }
      if (periodTo != null && !(periodTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodTo);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingElementId);

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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.parent = UtilSql.getValue(result, "parent");
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.description = UtilSql.getValue(result, "description");
        objectCreateAccountingReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateAccountingReportData.isshown = UtilSql.getValue(result, "isshown");
        objectCreateAccountingReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateAccountingReportData.total = UtilSql.getValue(result, "total");
        objectCreateAccountingReportData.filteredbyorganization = UtilSql.getValue(result, "filteredbyorganization");
        objectCreateAccountingReportData.temporaryfiltertype = UtilSql.getValue(result, "temporaryfiltertype");
        objectCreateAccountingReportData.value = UtilSql.getValue(result, "value");
        objectCreateAccountingReportData.levelAccount = UtilSql.getValue(result, "level_account");
        objectCreateAccountingReportData.classAccount = UtilSql.getValue(result, "class_account");
        objectCreateAccountingReportData.classStyle = UtilSql.getValue(result, "class_style");
        objectCreateAccountingReportData.padre = UtilSql.getValue(result, "padre");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
  }

  public static CreateAccountingReportData[] set()    throws ServletException {
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[1];
    objectCreateAccountingReportData[0] = new CreateAccountingReportData();
    objectCreateAccountingReportData[0].parent = "";
    objectCreateAccountingReportData[0].id = "";
    objectCreateAccountingReportData[0].name = "";
    objectCreateAccountingReportData[0].description = "";
    objectCreateAccountingReportData[0].issummary = "";
    objectCreateAccountingReportData[0].isshown = "";
    objectCreateAccountingReportData[0].nodeId = "";
    objectCreateAccountingReportData[0].total = "";
    objectCreateAccountingReportData[0].filteredbyorganization = "";
    objectCreateAccountingReportData[0].temporaryfiltertype = "";
    objectCreateAccountingReportData[0].value = "";
    objectCreateAccountingReportData[0].levelAccount = "";
    objectCreateAccountingReportData[0].classAccount = "";
    objectCreateAccountingReportData[0].classStyle = "";
    objectCreateAccountingReportData[0].padre = "";
    return objectCreateAccountingReportData;
  }

  public static CreateAccountingReportData[] selectChild(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adAccountingElementId, String acctschema)    throws ServletException {
    return selectChild(connectionProvider, adClientId, adOrgId, adAccountingElementId, acctschema, 0, 0);
  }

  public static CreateAccountingReportData[] selectChild(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adAccountingElementId, String acctschema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AR.AD_ACCOUNTINGRPT_ELEMENT_ID AS ID, AR.NAME, AR.DESCRIPTION, AR.ISSUMMARY, AR.ISSHOWN, AD_TREENODE.NODE_ID," +
      "      AR.FILTEREDBYORGANIZATION, AR.TEMPORARYFILTERTYPE" +
      "      FROM AD_TREE, AD_TREENODE, AD_ACCOUNTINGRPT_ELEMENT AR" +
      "      WHERE AD_TREE.AD_TREE_ID = AD_TREENODE.AD_TREE_ID" +
      "      AND AD_TREENODE.NODE_ID = AR.AD_ACCOUNTINGRPT_ELEMENT_ID" +
      "      AND AR.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ")" +
      "      AND AR.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND AD_TREENODE.PARENT_ID = ?" +
      "      AND AD_TREE.TREETYPE = 'AR'" +
      "      AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND AR.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "      GROUP BY AR.AD_ACCOUNTINGRPT_ELEMENT_ID, AR.NAME, AR.DESCRIPTION, AR.ISSUMMARY, AR.ISSHOWN, AD_TREENODE.NODE_ID," +
      "      AR.FILTEREDBYORGANIZATION, AR.TEMPORARYFILTERTYPE, AD_TREENODE.SEQNO" +
      "      ORDER BY AD_TREENODE.SEQNO";

    ResultSet result;
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingElementId);
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.description = UtilSql.getValue(result, "description");
        objectCreateAccountingReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateAccountingReportData.isshown = UtilSql.getValue(result, "isshown");
        objectCreateAccountingReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateAccountingReportData.filteredbyorganization = UtilSql.getValue(result, "filteredbyorganization");
        objectCreateAccountingReportData.temporaryfiltertype = UtilSql.getValue(result, "temporaryfiltertype");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
  }

  public static CreateAccountingReportData[] selectOrg(ConnectionProvider connectionProvider, String adOrgId, String adClientId)    throws ServletException {
    return selectOrg(connectionProvider, adOrgId, adClientId, 0, 0);
  }

  public static CreateAccountingReportData[] selectOrg(ConnectionProvider connectionProvider, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.issummary = UtilSql.getValue(result, "issummary");
        objectCreateAccountingReportData.nodeId = UtilSql.getValue(result, "node_id");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
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

  public static String selectMin(ConnectionProvider connectionProvider, String quarter)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MIN(VALUE) AS VALUE" +
      "      FROM AD_MONTH" +
      "      WHERE QUARTER = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarter);

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

  public static String selectMax(ConnectionProvider connectionProvider, String quarter)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MAX(VALUE) AS VALUE" +
      "      FROM AD_MONTH" +
      "      WHERE QUARTER = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarter);

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

  public static String lastDay(ConnectionProvider connectionProvider, String quarter, String dateFormat)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select TO_CHAR(last_day(TO_DATE(?)), to_char(?)) from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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

  public static String selectFormat(ConnectionProvider connectionProvider, String quarter, String dateFormat)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select TO_CHAR(TO_DATE(?), TO_CHAR(?)) from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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

  public static String selectAccounting(ConnectionProvider connectionProvider, String adAccountingrptElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCOUNT_ID AS ID" +
      "        FROM AD_ACCOUNTINGRPT_ELEMENT" +
      "        WHERE AD_ACCOUNTINGRPT_ELEMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingrptElementId);

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

  public static CreateAccountingReportData[] selectAD_Accountingrpt_Element_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String acctschema, String adAccountingrptElementId)    throws ServletException {
    return selectAD_Accountingrpt_Element_ID(connectionProvider, adOrgClient, adUserClient, acctschema, adAccountingrptElementId, 0, 0);
  }

  public static CreateAccountingReportData[] selectAD_Accountingrpt_Element_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String acctschema, String adAccountingrptElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_ACCOUNTINGRPT_ELEMENT_ID AS ID, NAME, FILTEREDBYORGANIZATION, TEMPORARYFILTERTYPE" +
      "      FROM AD_ACCOUNTINGRPT_ELEMENT" +
      "      WHERE AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ISREPORT='Y'" +
      "      AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND AD_ACCOUNTINGRPT_ELEMENT.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "      AND (isActive = 'Y' OR AD_ACCOUNTINGRPT_ELEMENT_ID = ? )";

    ResultSet result;
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingrptElementId);

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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.filteredbyorganization = UtilSql.getValue(result, "filteredbyorganization");
        objectCreateAccountingReportData.temporaryfiltertype = UtilSql.getValue(result, "temporaryfiltertype");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
  }

  public static CreateAccountingReportData[] selectAD_Accountingrpt_Element_Double_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String adAccountingrptElementId)    throws ServletException {
    return selectAD_Accountingrpt_Element_Double_ID(connectionProvider, adOrgClient, adUserClient, adAccountingrptElementId, 0, 0);
  }

  public static CreateAccountingReportData[] selectAD_Accountingrpt_Element_Double_ID(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String adAccountingrptElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_ACCOUNTINGRPT_ELEMENT.C_ACCTSCHEMA_ID AS PADRE, AD_ACCOUNTINGRPT_ELEMENT_ID AS ID, NAME, FILTEREDBYORGANIZATION, TEMPORARYFILTERTYPE" +
      "      FROM AD_ACCOUNTINGRPT_ELEMENT" +
      "      WHERE AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ISREPORT='Y'" +
      "      AND 1=1" +
      "      AND (isActive = 'Y' OR AD_ACCOUNTINGRPT_ELEMENT_ID = ? )";

    ResultSet result;
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingrptElementId);

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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.padre = UtilSql.getValue(result, "padre");
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.filteredbyorganization = UtilSql.getValue(result, "filteredbyorganization");
        objectCreateAccountingReportData.temporaryfiltertype = UtilSql.getValue(result, "temporaryfiltertype");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
  }

  public static String selectType(ConnectionProvider connectionProvider, String adAccountingrptElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TEMPORARYFILTERTYPE" +
      "      FROM AD_ACCOUNTINGRPT_ELEMENT" +
      "      WHERE AD_ACCOUNTINGRPT_ELEMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingrptElementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "temporaryfiltertype");
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

  public static CreateAccountingReportData[] selectCombo(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String adLanguage)    throws ServletException {
    return selectCombo(connectionProvider, adOrgClient, adUserClient, adLanguage, 0, 0);
  }

  public static CreateAccountingReportData[] selectCombo(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT 'M' AS VALUE, TO_CHAR(VALUE) AS ID, TO_CHAR(NAME) AS NAME" +
      "      FROM AD_MONTH" +
      "      WHERE AD_CLIENT_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      UNION SELECT 'Q' AS VALUE, TO_CHAR(A.VALUE) AS ID, TO_CHAR(A.NAME) AS NAME" +
      "      FROM AD_MONTH, AD_REF_LIST_V A" +
      "      WHERE AD_CLIENT_ID  IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "      AND AD_ORG_ID  IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND AD_MONTH.QUARTER = A.VALUE" +
      "      AND AD_REFERENCE_ID = '800027'" +
      "      AND AD_LANGUAGE = ?" +
      "      UNION SELECT 'A' AS VALUE, TO_CHAR(YEAR) AS ID, TO_CHAR(YEAR) AS NAME" +
      "      FROM C_YEAR";

    ResultSet result;
    Vector<CreateAccountingReportData> vector = new Vector<CreateAccountingReportData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

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
        CreateAccountingReportData objectCreateAccountingReportData = new CreateAccountingReportData();
        objectCreateAccountingReportData.value = UtilSql.getValue(result, "value");
        objectCreateAccountingReportData.id = UtilSql.getValue(result, "id");
        objectCreateAccountingReportData.name = UtilSql.getValue(result, "name");
        objectCreateAccountingReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateAccountingReportData);
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
    CreateAccountingReportData objectCreateAccountingReportData[] = new CreateAccountingReportData[vector.size()];
    vector.copyInto(objectCreateAccountingReportData);
    return(objectCreateAccountingReportData);
  }

  public static String dateInitialYear(ConnectionProvider connectionProvider, String adAccountingrptElement, String Year)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MIN(startdate)" +
      "      FROM c_year y" +
      "        JOIN c_calendar cal ON y.c_calendar_id = cal.c_calendar_id" +
      "        JOIN ad_accountingrpt_element accrpt ON cal.ad_org_id = AD_ORG_GETCALENDAROWNER(accrpt.ad_org_id)" +
      "        JOIN c_period p ON p.c_year_id = y.c_year_id" +
      "      WHERE accrpt.ad_accountingrpt_element_id = ?" +
      "        AND y.year = ?";

    ResultSet result;
    String dateReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingrptElement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Year);

      result = st.executeQuery();
      if(result.next()) {
        dateReturn = UtilSql.getDateValue(result, "min", "dd-MM-yyyy");
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
    return(dateReturn);
  }

  public static String isInitialBalance(ConnectionProvider connectionProvider, String adAccountingrptElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ISINITIALBALANCE" +
      "        FROM AD_ACCOUNTINGRPT_ELEMENT" +
      "        WHERE AD_ACCOUNTINGRPT_ELEMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adAccountingrptElementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isinitialbalance");
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
