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

class AccountElementValueData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountElementValueData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String id;
  public String cElementvalueId;
  public String value;
  public String name;
  public String description;
  public String adOrgId;
  public String adOrgIdD;
  public String rowkey;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_id_d") || fieldName.equals("adOrgIdD"))
      return adOrgIdD;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountElementValueData[] select(ConnectionProvider connectionProvider, String rownum, String acctschema, String value, String name, String organization, String elementValue, String adUserClient, String adUserOrg, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, acctschema, value, name, organization, elementValue, adUserClient, adUserOrg, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static AccountElementValueData[] select(ConnectionProvider connectionProvider, String rownum, String acctschema, String value, String name, String organization, String elementValue, String adUserClient, String adUserOrg, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      		SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, '' AS ID, A.* FROM (" +
      "	            SELECT C.C_ELEMENTVALUE_ID, C.VALUE as value, C.NAME as name, C.DESCRIPTION," +
      "	            C.AD_ORG_ID, (O.VALUE || ' - ' || O.NAME) AS AD_ORG_ID_D," +
      "                C.C_ELEMENTVALUE_ID || '@_##_@' || C.NAME AS rowkey" +
      "	            FROM C_ELEMENTVALUE C," +
      "	            AD_ORG O" +
      "	            WHERE EXISTS (SELECT 1 FROM C_ACCTSCHEMA_ELEMENT" +
      "	            			  WHERE C_ACCTSCHEMA_ELEMENT.C_ELEMENT_ID = C.C_ELEMENT_ID" +
      "	            			  AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      ")" +
      "	            AND 2=2";
    strSql = strSql + ((value==null || value.equals(""))?"":"  AND (C.VALUE IS NULL  OR UPPER(C.VALUE) LIKE UPPER(?))  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(C.NAME) LIKE UPPER(?)  ");
    strSql = strSql + ((organization==null || organization.equals(""))?"":"  AND C.AD_ORG_ID = ?  ");
    strSql = strSql + ((elementValue==null || elementValue.equals(""))?"":"  AND C.C_ELEMENTVALUE_ID = ?  ");
    strSql = strSql + 
      "                AND C.ELEMENTLEVEL = 'S'" +
      "	            AND C.AD_ORG_ID = O.AD_ORG_ID" +
      "	            AND C.ISACTIVE = 'Y'" +
      "	            AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "	            AND C.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "	            ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "	        	) A ) B" +
      "			WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<AccountElementValueData> vector = new Vector<AccountElementValueData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (value != null && !(value.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (organization != null && !(organization.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);
      }
      if (elementValue != null && !(elementValue.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementValue);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        AccountElementValueData objectAccountElementValueData = new AccountElementValueData();
        objectAccountElementValueData.rn1 = UtilSql.getValue(result, "rn1");
        objectAccountElementValueData.id = UtilSql.getValue(result, "id");
        objectAccountElementValueData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectAccountElementValueData.value = UtilSql.getValue(result, "value");
        objectAccountElementValueData.name = UtilSql.getValue(result, "name");
        objectAccountElementValueData.description = UtilSql.getValue(result, "description");
        objectAccountElementValueData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountElementValueData.adOrgIdD = UtilSql.getValue(result, "ad_org_id_d");
        objectAccountElementValueData.rowkey = UtilSql.getValue(result, "rowkey");
        objectAccountElementValueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountElementValueData);
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
    AccountElementValueData objectAccountElementValueData[] = new AccountElementValueData[vector.size()];
    vector.copyInto(objectAccountElementValueData);
    return(objectAccountElementValueData);
  }

  public static AccountElementValueData[] set(String value, String name)    throws ServletException {
    AccountElementValueData objectAccountElementValueData[] = new AccountElementValueData[1];
    objectAccountElementValueData[0] = new AccountElementValueData();
    objectAccountElementValueData[0].rn1 = "";
    objectAccountElementValueData[0].id = "";
    objectAccountElementValueData[0].cElementvalueId = "";
    objectAccountElementValueData[0].value = value;
    objectAccountElementValueData[0].name = name;
    objectAccountElementValueData[0].description = "";
    objectAccountElementValueData[0].adOrgId = "";
    objectAccountElementValueData[0].adOrgIdD = "";
    objectAccountElementValueData[0].rowkey = "";
    return objectAccountElementValueData;
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String acctschema, String value, String name, String organization, String elementValue, String adUserClient, String adUserOrg, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      		SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM ( SELECT 1" +
      "	            FROM C_ELEMENTVALUE C," +
      "	            AD_ORG O" +
      "	            WHERE EXISTS (SELECT 1 FROM C_ACCTSCHEMA_ELEMENT" +
      "	            			  WHERE C_ACCTSCHEMA_ELEMENT.C_ELEMENT_ID = C.C_ELEMENT_ID" +
      "	            			  AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      ")" +
      "	            AND 2=2";
    strSql = strSql + ((value==null || value.equals(""))?"":"  AND (C.VALUE IS NULL  OR UPPER(C.VALUE) LIKE UPPER(?))  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(C.NAME) LIKE UPPER(?)  ");
    strSql = strSql + ((organization==null || organization.equals(""))?"":"  AND C.AD_ORG_ID = ?  ");
    strSql = strSql + ((elementValue==null || elementValue.equals(""))?"":"  AND C.C_ELEMENTVALUE_ID = ?  ");
    strSql = strSql + 
      "                AND C.ELEMENTLEVEL = 'S'" +
      "	            AND C.AD_ORG_ID = O.AD_ORG_ID" +
      "	            AND C.ISACTIVE = 'Y'" +
      "	            AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "	            AND C.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "	            AND 3=3";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "	            ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "	            ) A ";
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
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (value != null && !(value.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (organization != null && !(organization.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);
      }
      if (elementValue != null && !(elementValue.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementValue);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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

  public static AccountElementValueData[] selectKey(ConnectionProvider connectionProvider, String acctschema, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKey(connectionProvider, acctschema, adUserClient, adUserOrg, key, 0, 0);
  }

  public static AccountElementValueData[] selectKey(ConnectionProvider connectionProvider, String acctschema, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C.C_ELEMENTVALUE_ID, C.VALUE, C.NAME, C.DESCRIPTION," +
      "            C.AD_ORG_ID, (O.VALUE || ' - ' || O.NAME) AS AD_ORG_ID_D" +
      "            FROM C_ELEMENTVALUE C," +
      "            AD_ORG O" +
      "            WHERE EXISTS (SELECT 1 FROM C_ACCTSCHEMA_ELEMENT" +
      "            			  WHERE C_ACCTSCHEMA_ELEMENT.C_ELEMENT_ID = C.C_ELEMENT_ID" +
      "            			  AND 1=1";
    strSql = strSql + ((acctschema==null || acctschema.equals(""))?"":"  AND C_ACCTSCHEMA_ID = ? ");
    strSql = strSql + 
      ")" +
      "            AND C.ELEMENTLEVEL = 'S'" +
      "            AND C.AD_ORG_ID = O.AD_ORG_ID" +
      "            AND C.ISACTIVE = 'Y'" +
      "            AND C.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "            AND C.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "            AND (C.VALUE IS NULL" +
      "            OR UPPER(C.VALUE) LIKE UPPER(?))";

    ResultSet result;
    Vector<AccountElementValueData> vector = new Vector<AccountElementValueData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (acctschema != null && !(acctschema.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        AccountElementValueData objectAccountElementValueData = new AccountElementValueData();
        objectAccountElementValueData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectAccountElementValueData.value = UtilSql.getValue(result, "value");
        objectAccountElementValueData.name = UtilSql.getValue(result, "name");
        objectAccountElementValueData.description = UtilSql.getValue(result, "description");
        objectAccountElementValueData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountElementValueData.adOrgIdD = UtilSql.getValue(result, "ad_org_id_d");
        objectAccountElementValueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountElementValueData);
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
    AccountElementValueData objectAccountElementValueData[] = new AccountElementValueData[vector.size()];
    vector.copyInto(objectAccountElementValueData);
    return(objectAccountElementValueData);
  }

  public static String selectschemaname(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select name from c_acctschema where c_acctschema_id=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
