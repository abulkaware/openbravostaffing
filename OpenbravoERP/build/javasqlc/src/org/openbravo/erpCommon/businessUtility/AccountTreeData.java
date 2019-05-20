//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.businessUtility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class AccountTreeData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountTreeData.class);
  private String InitRecordNumber="0";
  public String nodeId;
  public String parentId;
  public String seqno;
  public String id;
  public String name;
  public String description;
  public String issummary;
  public String accountsign;
  public String showelement;
  public String elementLevel;
  public String qty;
  public String qtyRef;
  public String qtyOperation;
  public String qtyOperationRef;
  public String qtycredit;
  public String qtycreditRef;
  public String showvaluecond;
  public String elementlevel;
  public String value;
  public String calculated;
  public String svcreset;
  public String svcresetref;
  public String isalwaysshown;
  public String sign;

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
    else if (fieldName.equalsIgnoreCase("accountsign"))
      return accountsign;
    else if (fieldName.equalsIgnoreCase("showelement"))
      return showelement;
    else if (fieldName.equalsIgnoreCase("element_level") || fieldName.equals("elementLevel"))
      return elementLevel;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("qty_ref") || fieldName.equals("qtyRef"))
      return qtyRef;
    else if (fieldName.equalsIgnoreCase("qty_operation") || fieldName.equals("qtyOperation"))
      return qtyOperation;
    else if (fieldName.equalsIgnoreCase("qty_operation_ref") || fieldName.equals("qtyOperationRef"))
      return qtyOperationRef;
    else if (fieldName.equalsIgnoreCase("qtycredit"))
      return qtycredit;
    else if (fieldName.equalsIgnoreCase("qtycredit_ref") || fieldName.equals("qtycreditRef"))
      return qtycreditRef;
    else if (fieldName.equalsIgnoreCase("showvaluecond"))
      return showvaluecond;
    else if (fieldName.equalsIgnoreCase("elementlevel"))
      return elementlevel;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("calculated"))
      return calculated;
    else if (fieldName.equalsIgnoreCase("svcreset"))
      return svcreset;
    else if (fieldName.equalsIgnoreCase("svcresetref"))
      return svcresetref;
    else if (fieldName.equalsIgnoreCase("isalwaysshown"))
      return isalwaysshown;
    else if (fieldName.equalsIgnoreCase("sign"))
      return sign;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountTreeData[] select(ConnectionProvider connectionProvider, String conCodigo, String adTreeId)    throws ServletException {
    return select(connectionProvider, conCodigo, adTreeId, 0, 0);
  }

  public static AccountTreeData[] select(ConnectionProvider connectionProvider, String conCodigo, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_ElementValue_ID AS ID, " +
      "        ((CASE ? WHEN 'Y' THEN TO_CHAR(m.Value) || ' - ' ELSE '' END) || m.Name) AS NAME,m.Description, m.IsSummary, " +
      "        m.ACCOUNTSIGN, m.ShowElement, 0 as element_level, 0 as qty, 0 as qty_ref, 0 as qty_operation, 0 as qty_operation_ref, " +
      "        0 as QTYCREDIT, 0 as QTYCREDIT_REF, m.ShowValueCond, m.ElementLevel, m.Value, " +
      "        'N' AS CALCULATED, 'N' AS SVCRESET, 'N' AS SVCRESETREF, m.isalwaysshown, '' as sign" +
      "        FROM AD_TreeNode tn, C_ElementValue m" +
      "        WHERE tn.IsActive='Y' " +
      "        AND tn.Node_ID = m.C_ElementValue_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo";

    ResultSet result;
    Vector<AccountTreeData> vector = new Vector<AccountTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conCodigo);
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
        AccountTreeData objectAccountTreeData = new AccountTreeData();
        objectAccountTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectAccountTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectAccountTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectAccountTreeData.id = UtilSql.getValue(result, "id");
        objectAccountTreeData.name = UtilSql.getValue(result, "name");
        objectAccountTreeData.description = UtilSql.getValue(result, "description");
        objectAccountTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectAccountTreeData.accountsign = UtilSql.getValue(result, "accountsign");
        objectAccountTreeData.showelement = UtilSql.getValue(result, "showelement");
        objectAccountTreeData.elementLevel = UtilSql.getValue(result, "element_level");
        objectAccountTreeData.qty = UtilSql.getValue(result, "qty");
        objectAccountTreeData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectAccountTreeData.qtyOperation = UtilSql.getValue(result, "qty_operation");
        objectAccountTreeData.qtyOperationRef = UtilSql.getValue(result, "qty_operation_ref");
        objectAccountTreeData.qtycredit = UtilSql.getValue(result, "qtycredit");
        objectAccountTreeData.qtycreditRef = UtilSql.getValue(result, "qtycredit_ref");
        objectAccountTreeData.showvaluecond = UtilSql.getValue(result, "showvaluecond");
        objectAccountTreeData.elementlevel = UtilSql.getValue(result, "elementlevel");
        objectAccountTreeData.value = UtilSql.getValue(result, "value");
        objectAccountTreeData.calculated = UtilSql.getValue(result, "calculated");
        objectAccountTreeData.svcreset = UtilSql.getValue(result, "svcreset");
        objectAccountTreeData.svcresetref = UtilSql.getValue(result, "svcresetref");
        objectAccountTreeData.isalwaysshown = UtilSql.getValue(result, "isalwaysshown");
        objectAccountTreeData.sign = UtilSql.getValue(result, "sign");
        objectAccountTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountTreeData);
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
    AccountTreeData objectAccountTreeData[] = new AccountTreeData[vector.size()];
    vector.copyInto(objectAccountTreeData);
    return(objectAccountTreeData);
  }

  public static AccountTreeData[] selectTrl(ConnectionProvider connectionProvider, String conCodigo, String adLanguage, String adTreeId)    throws ServletException {
    return selectTrl(connectionProvider, conCodigo, adLanguage, adTreeId, 0, 0);
  }

  public static AccountTreeData[] selectTrl(ConnectionProvider connectionProvider, String conCodigo, String adLanguage, String adTreeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT tn.Node_ID,tn.Parent_ID,tn.SeqNo, m.C_ElementValue_ID AS ID, ((CASE ? WHEN 'Y' THEN TO_CHAR(m.Value) || ' - ' ELSE '' END) || COALESCE(mt.Name, m.Name)) as Name, " +
      "        COALESCE(mt.Description, m.Description) as description ,m.IsSummary, m.ACCOUNTSIGN, " +
      "        m.ShowElement, 0 as element_level, 0 as qty, 0 as qty_ref, 0 as qty_operation, 0 as qty_operation_ref, " +
      "        m.ShowValueCond, m.ElementLevel, m.Value, 'N' AS CALCULATED, 'N' AS SVCRESET, 'N' AS SVCRESETREF, m.isalwaysshown" +
      "        FROM C_ElementValue m left join C_ElementValue_Trl mt on m.C_ElementValue_ID = mt.C_ElementValue_ID " +
      "                                                              and mt.AD_Language = ? ," +
      "              AD_TreeNode tn" +
      "        WHERE tn.IsActive='Y' " +
      "        AND tn.Node_ID = m.C_ElementValue_ID " +
      "        AND tn.AD_Tree_ID = ? " +
      "        ORDER BY COALESCE(tn.Parent_ID, '-1'), tn.SeqNo ";

    ResultSet result;
    Vector<AccountTreeData> vector = new Vector<AccountTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conCodigo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
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
        AccountTreeData objectAccountTreeData = new AccountTreeData();
        objectAccountTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectAccountTreeData.parentId = UtilSql.getValue(result, "parent_id");
        objectAccountTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectAccountTreeData.id = UtilSql.getValue(result, "id");
        objectAccountTreeData.name = UtilSql.getValue(result, "name");
        objectAccountTreeData.description = UtilSql.getValue(result, "description");
        objectAccountTreeData.issummary = UtilSql.getValue(result, "issummary");
        objectAccountTreeData.accountsign = UtilSql.getValue(result, "accountsign");
        objectAccountTreeData.showelement = UtilSql.getValue(result, "showelement");
        objectAccountTreeData.elementLevel = UtilSql.getValue(result, "element_level");
        objectAccountTreeData.qty = UtilSql.getValue(result, "qty");
        objectAccountTreeData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectAccountTreeData.qtyOperation = UtilSql.getValue(result, "qty_operation");
        objectAccountTreeData.qtyOperationRef = UtilSql.getValue(result, "qty_operation_ref");
        objectAccountTreeData.showvaluecond = UtilSql.getValue(result, "showvaluecond");
        objectAccountTreeData.elementlevel = UtilSql.getValue(result, "elementlevel");
        objectAccountTreeData.value = UtilSql.getValue(result, "value");
        objectAccountTreeData.calculated = UtilSql.getValue(result, "calculated");
        objectAccountTreeData.svcreset = UtilSql.getValue(result, "svcreset");
        objectAccountTreeData.svcresetref = UtilSql.getValue(result, "svcresetref");
        objectAccountTreeData.isalwaysshown = UtilSql.getValue(result, "isalwaysshown");
        objectAccountTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountTreeData);
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
    AccountTreeData objectAccountTreeData[] = new AccountTreeData[vector.size()];
    vector.copyInto(objectAccountTreeData);
    return(objectAccountTreeData);
  }

  public static AccountTreeData[] selectAcct(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String dateFrom, String dateTo, String acctschema, String org, String agno, String dateFromRef, String dateToRef, String agnoRef)    throws ServletException {
    return selectAcct(connectionProvider, adOrgClient, adUserClient, dateFrom, dateTo, acctschema, org, agno, dateFromRef, dateToRef, agnoRef, 0, 0);
  }

  public static AccountTreeData[] selectAcct(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String dateFrom, String dateTo, String acctschema, String org, String agno, String dateFromRef, String dateToRef, String agnoRef, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ID, SUM(QTY) AS QTY, SUM(QTYCREDIT) AS QTYCREDIT, SUM(QTY_REF) AS QTY_REF, SUM(QTYCREDIT_REF) AS QTYCREDIT_REF " +
      "        FROM (" +
      "        SELECT m.C_ElementValue_ID as id, (COALESCE(f.AMTACCTDR,0) - COALESCE(f.AMTACCTCR, 0)) AS qty, " +
      "        (COALESCE(f.AMTACCTCR,0) - COALESCE(f.AMTACCTDR, 0)) AS qtyCredit, 0 as qty_ref, 0 as qtyCredit_ref" +
      "                FROM C_ElementValue m, Fact_Acct f, C_Period p, C_Year y " +
      "                WHERE m.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "                AND m.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                AND 1=1 ";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND f.DATEACCT >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND f.DATEACCT < to_date(?) ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                AND f.FACTACCTTYPE <> 'R'" +
      "                AND f.FACTACCTTYPE <> 'C'" +
      "                AND m.C_ElementValue_ID = f.Account_ID" +
      "            AND 0=0 AND f.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "            AND f.C_PERIOD_ID = p.C_PERIOD_ID " +
      "            AND p.C_YEAR_ID = y.C_YEAR_ID" +
      "            AND Y.YEAR IN (";
    strSql = strSql + ((agno==null || agno.equals(""))?"":agno);
    strSql = strSql + 
      ") " +
      "        UNION ALL" +
      "        SELECT m.C_ElementValue_ID as id, 0 AS QTY, 0 as qtyCredit, (COALESCE(f.AMTACCTDR,0) - COALESCE(f.AMTACCTCR, 0)) AS qty_ref, " +
      "                (COALESCE(f.AMTACCTCR,0) - COALESCE(f.AMTACCTDR, 0)) AS qtyCredit_ref " +
      "                FROM C_ElementValue m, Fact_Acct f, C_Period p, C_Year y " +
      "                WHERE m.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "                AND m.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "                AND 2=2 ";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":"  AND f.DATEACCT >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":"  AND f.DATEACCT < to_date(?) ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                AND f.FACTACCTTYPE <> 'R'" +
      "                AND f.FACTACCTTYPE <> 'C'" +
      "                AND m.C_ElementValue_ID = f.Account_ID" +
      "            AND 1=1 AND f.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "            AND f.C_PERIOD_ID = p.C_PERIOD_ID " +
      "            AND p.C_YEAR_ID = y.C_YEAR_ID" +
      "            AND y.YEAR IN (";
    strSql = strSql + ((agnoRef==null || agnoRef.equals(""))?"":agnoRef);
    strSql = strSql + 
      ") " +
      "        ) AA" +
      "        GROUP BY ID";

    ResultSet result;
    Vector<AccountTreeData> vector = new Vector<AccountTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (agno != null && !(agno.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFromRef != null && !(dateFromRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      }
      if (dateToRef != null && !(dateToRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (agnoRef != null && !(agnoRef.equals(""))) {
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
        AccountTreeData objectAccountTreeData = new AccountTreeData();
        objectAccountTreeData.id = UtilSql.getValue(result, "id");
        objectAccountTreeData.qty = UtilSql.getValue(result, "qty");
        objectAccountTreeData.qtycredit = UtilSql.getValue(result, "qtycredit");
        objectAccountTreeData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectAccountTreeData.qtycreditRef = UtilSql.getValue(result, "qtycredit_ref");
        objectAccountTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountTreeData);
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
    AccountTreeData objectAccountTreeData[] = new AccountTreeData[vector.size()];
    vector.copyInto(objectAccountTreeData);
    return(objectAccountTreeData);
  }

  public static AccountTreeData[] selectFactAcct(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String dateFrom, String dateTo, String acctschema, String org, String agno, String openingEntryOwner, String compareTo, String dateFromRef, String dateToRef, String agnoRef, String openingEntryOwnerRef)    throws ServletException {
    return selectFactAcct(connectionProvider, adOrgClient, adUserClient, dateFrom, dateTo, acctschema, org, agno, openingEntryOwner, compareTo, dateFromRef, dateToRef, agnoRef, openingEntryOwnerRef, 0, 0);
  }

  public static AccountTreeData[] selectFactAcct(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String dateFrom, String dateTo, String acctschema, String org, String agno, String openingEntryOwner, String compareTo, String dateFromRef, String dateToRef, String agnoRef, String openingEntryOwnerRef, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ID, SUM(QTY) AS QTY, SUM(QTYCREDIT) AS QTYCREDIT, SUM(QTY_REF) AS QTY_REF, SUM(QTYCREDIT_REF) AS QTYCREDIT_REF " +
      "        FROM (" +
      "        SELECT m.C_ElementValue_ID as id, (COALESCE(f.AMTACCTDR,0) - COALESCE(f.AMTACCTCR, 0)) AS qty, " +
      "        (COALESCE(f.AMTACCTCR,0) - COALESCE(f.AMTACCTDR, 0)) AS qtyCredit, 0 as qty_ref, 0 as qtyCredit_ref" +
      "                FROM C_ElementValue m, Fact_Acct f, C_Period p, C_Year y " +
      "                WHERE m.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "                AND m.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                AND 1=1 ";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND f.DATEACCT >= to_date(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND f.DATEACCT < to_date(?) ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                AND f.FACTACCTTYPE <> 'R'" +
      "                AND f.FACTACCTTYPE <> 'C'" +
      "                AND m.C_ElementValue_ID = f.Account_ID" +
      "            AND 0=0 AND f.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "            AND f.C_PERIOD_ID = p.C_PERIOD_ID " +
      "            AND p.C_YEAR_ID = y.C_YEAR_ID" +
      "            AND Y.YEAR IN (";
    strSql = strSql + ((agno==null || agno.equals(""))?"":agno);
    strSql = strSql + 
      ") " +
      "            and not exists (select 1 from ad_org_closing, c_year year " +
      "                           where open_fact_acct_group_id = f.fact_acct_group_id" +
      "                           and ad_org_closing.c_year_id = year.c_year_id" +
      "                           and year.year <> ?)" +
      "        UNION ALL" +
      "        SELECT m.C_ElementValue_ID as id, 0 AS QTY, 0 as qtyCredit, (COALESCE(f.AMTACCTDR,0) - COALESCE(f.AMTACCTCR, 0)) AS qty_ref, " +
      "                (COALESCE(f.AMTACCTCR,0) - COALESCE(f.AMTACCTDR, 0)) AS qtyCredit_ref " +
      "                FROM C_ElementValue m, Fact_Acct f, C_Period p, C_Year y " +
      "                WHERE m.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "                AND m.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                AND (1=2 ";
    strSql = strSql + ((compareTo==null || compareTo.equals(""))?"":"  OR to_char('Y')=to_char(?) ");
    strSql = strSql + 
      ")  " +
      "                AND 2=2 ";
    strSql = strSql + ((dateFromRef==null || dateFromRef.equals(""))?"":"  AND f.DATEACCT >= to_date(?) ");
    strSql = strSql + ((dateToRef==null || dateToRef.equals(""))?"":"  AND f.DATEACCT < to_date(?) ");
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND f.C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      "                AND f.FACTACCTTYPE <> 'R'" +
      "                AND f.FACTACCTTYPE <> 'C'" +
      "                AND m.C_ElementValue_ID = f.Account_ID" +
      "            AND 1=1 AND f.AD_ORG_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "            AND f.C_PERIOD_ID = p.C_PERIOD_ID " +
      "            AND p.C_YEAR_ID = y.C_YEAR_ID" +
      "            AND y.YEAR IN (";
    strSql = strSql + ((agnoRef==null || agnoRef.equals(""))?"":agnoRef);
    strSql = strSql + 
      ") " +
      "            and not exists (select 1 from ad_org_closing, c_year year " +
      "                           where open_fact_acct_group_id = f.fact_acct_group_id" +
      "                           and ad_org_closing.c_year_id = year.c_year_id" +
      "                           and year.year <> ?)" +
      "        ) AA" +
      "        GROUP BY ID";

    ResultSet result;
    Vector<AccountTreeData> vector = new Vector<AccountTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (agno != null && !(agno.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, openingEntryOwner);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (compareTo != null && !(compareTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, compareTo);
      }
      if (dateFromRef != null && !(dateFromRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      }
      if (dateToRef != null && !(dateToRef.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (agnoRef != null && !(agnoRef.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, openingEntryOwnerRef);

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
        AccountTreeData objectAccountTreeData = new AccountTreeData();
        objectAccountTreeData.id = UtilSql.getValue(result, "id");
        objectAccountTreeData.qty = UtilSql.getValue(result, "qty");
        objectAccountTreeData.qtycredit = UtilSql.getValue(result, "qtycredit");
        objectAccountTreeData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectAccountTreeData.qtycreditRef = UtilSql.getValue(result, "qtycredit_ref");
        objectAccountTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountTreeData);
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
    AccountTreeData objectAccountTreeData[] = new AccountTreeData[vector.size()];
    vector.copyInto(objectAccountTreeData);
    return(objectAccountTreeData);
  }

  public static AccountTreeData[] selectForms(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient)    throws ServletException {
    return selectForms(connectionProvider, adOrgClient, adUserClient, 0, 0);
  }

  public static AccountTreeData[] selectForms(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m.C_ElementValue_ID as id, o.account_id as node_id, o.sign as ACCOUNTSIGN" +
      "        FROM C_ElementValue m, C_ELEMENTVALUE_OPERAND o  " +
      "        WHERE m.isActive='Y' " +
      "        AND m.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND m.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m.C_ElementValue_ID = o.C_ElementValue_ID" +
      "        AND o.isactive = 'Y' " +
      "        order by m.C_elementvalue_id, o.seqno";

    ResultSet result;
    Vector<AccountTreeData> vector = new Vector<AccountTreeData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        AccountTreeData objectAccountTreeData = new AccountTreeData();
        objectAccountTreeData.id = UtilSql.getValue(result, "id");
        objectAccountTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectAccountTreeData.accountsign = UtilSql.getValue(result, "accountsign");
        objectAccountTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountTreeData);
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
    AccountTreeData objectAccountTreeData[] = new AccountTreeData[vector.size()];
    vector.copyInto(objectAccountTreeData);
    return(objectAccountTreeData);
  }

  public static AccountTreeData[] selectOperands(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String element)    throws ServletException {
    return selectOperands(connectionProvider, adOrgClient, adUserClient, element, 0, 0);
  }

  public static AccountTreeData[] selectOperands(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String element, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m.C_ElementValue_ID as id, o.account_id as node_id, o.sign" +
      "        FROM C_ElementValue m, C_ELEMENTVALUE_OPERAND o, C_ElementValue n" +
      "        WHERE m.isActive='Y' " +
      "        AND m.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND m.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m.C_Element_ID = ?" +
      "        AND m.C_ElementValue_ID = o.C_ElementValue_ID" +
      "        AND n.C_ElementValue_ID = o.C_ElementValue_ID" +
      "        AND o.isactive = 'Y' " +
      "        order by m.C_elementvalue_id, o.seqno";

    ResultSet result;
    Vector<AccountTreeData> vector = new Vector<AccountTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element);

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
        AccountTreeData objectAccountTreeData = new AccountTreeData();
        objectAccountTreeData.id = UtilSql.getValue(result, "id");
        objectAccountTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectAccountTreeData.sign = UtilSql.getValue(result, "sign");
        objectAccountTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountTreeData);
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
    AccountTreeData objectAccountTreeData[] = new AccountTreeData[vector.size()];
    vector.copyInto(objectAccountTreeData);
    return(objectAccountTreeData);
  }
}
