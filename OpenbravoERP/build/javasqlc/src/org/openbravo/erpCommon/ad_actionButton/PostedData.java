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

class PostedData implements FieldProvider {
static Logger log4j = Logger.getLogger(PostedData.class);
  private String InitRecordNumber="0";
  public String id;
  public String org;
  public String client;
  public String schemaId;
  public String schemaName;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("client"))
      return client;
    else if (fieldName.equalsIgnoreCase("schema_id") || fieldName.equals("schemaId"))
      return schemaId;
    else if (fieldName.equalsIgnoreCase("schema_name") || fieldName.equals("schemaName"))
      return schemaName;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PostedData[] select(ConnectionProvider connectionProvider, String record_id, String ad_table_id)    throws ServletException {
    return select(connectionProvider, record_id, ad_table_id, 0, 0);
  }

  public static PostedData[] select(ConnectionProvider connectionProvider, String record_id, String ad_table_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(FACT_ACCT_GROUP_ID) AS ID, MAX(AD_ORG_ID) AS ORG, MAX(AD_CLIENT_ID) AS CLIENT, '' AS SCHEMA_ID , '' AS SCHEMA_NAME  FROM FACT_ACCT" +
      "        WHERE RECORD_ID = ?" +
      "        AND AD_TABLE_ID = ?";

    ResultSet result;
    Vector<PostedData> vector = new Vector<PostedData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, record_id);
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
        PostedData objectPostedData = new PostedData();
        objectPostedData.id = UtilSql.getValue(result, "id");
        objectPostedData.org = UtilSql.getValue(result, "org");
        objectPostedData.client = UtilSql.getValue(result, "client");
        objectPostedData.schemaId = UtilSql.getValue(result, "schema_id");
        objectPostedData.schemaName = UtilSql.getValue(result, "schema_name");
        objectPostedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPostedData);
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
    PostedData objectPostedData[] = new PostedData[vector.size()];
    vector.copyInto(objectPostedData);
    return(objectPostedData);
  }

  public static String selectTableName(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TABLENAME FROM AD_TABLE" +
      "        WHERE AD_TABLE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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

  public static String selectDocOrg(ConnectionProvider connectionProvider, String tablename, String keyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Org_ID FROM ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      "_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (tablename != null && !(tablename.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keyId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static PostedData[] selectAccSchemas(ConnectionProvider connectionProvider, String descriptionType, String adUserClient, String adUserOrg, String table, String record, String paramLanguage)    throws ServletException {
    return selectAccSchemas(connectionProvider, descriptionType, adUserClient, adUserOrg, table, record, paramLanguage, 0, 0);
  }

  public static PostedData[] selectAccSchemas(ConnectionProvider connectionProvider, String descriptionType, String adUserClient, String adUserOrg, String table, String record, String paramLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT distinct (SCHEMA_ID) as SCHEMA_ID , SCHEMA_NAME" +
      "      FROM " +
      "      (SELECT F.C_ACCTSCHEMA_ID AS SCHEMA_ID, SC.NAME AS SCHEMA_NAME, F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT," +
      "      F.ACCTVALUE AS VALUE, F.";
    strSql = strSql + ((descriptionType==null || descriptionType.equals(""))?"":descriptionType);
    strSql = strSql + 
      " AS NAME,F.RECORD_ID AS ID, F.AD_TABLE_ID, F.DOCBASETYPE," +
      "      sum(F.AMTACCTDR) AS AMTACCTDR, sum(F.AMTACCTCR) AS AMTACCTCR, MIN(SEQNO) AS SEQNO, F.FACTACCTTYPE AS FACTACCTTYPE, F.AD_CLIENT_ID" +
      "      FROM FACT_ACCT F, C_ACCTSCHEMA SC " +
      "      WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND F.AD_ORG_ID IN(";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((table==null || table.equals(""))?"":"  AND f.ad_table_ID = ? ");
    strSql = strSql + ((record==null || record.equals(""))?"":"  AND f.record_ID = ? ");
    strSql = strSql + 
      "      AND f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID" +
      "      GROUP BY f.C_ACCTSCHEMA_ID, SC.NAME, F.AD_TABLE_ID, F.DATEACCT, F.";
    strSql = strSql + ((descriptionType==null || descriptionType.equals(""))?"":descriptionType);
    strSql = strSql + 
      ", F.ACCTVALUE, F.DOCBASETYPE, F.RECORD_ID, " +
      "      F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID,F.FACTACCTTYPE," +
      "      (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR) WHEN -1 THEN 3 ELSE 4 END) END), F.AD_CLIENT_ID" +
      "      HAVING (sum(F.AMTACCTDR) <> 0 OR sum(F.AMTACCTCR) <> 0)) AA," +
      "      AD_REF_LIST_V AR" +
      "      WHERE AR.VALUE=AA.DOCBASETYPE" +
      "      AND AD_LANGUAGE=?" +
      "      AND AR.AD_REFERENCE_ID = '183'" +
      "      ORDER BY SCHEMA_NAME";

    ResultSet result;
    Vector<PostedData> vector = new Vector<PostedData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (descriptionType != null && !(descriptionType.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (table != null && !(table.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, table);
      }
      if (record != null && !(record.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, record);
      }
      if (descriptionType != null && !(descriptionType.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);

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
        PostedData objectPostedData = new PostedData();
        objectPostedData.schemaId = UtilSql.getValue(result, "schema_id");
        objectPostedData.schemaName = UtilSql.getValue(result, "schema_name");
        objectPostedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPostedData);
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
    PostedData objectPostedData[] = new PostedData[vector.size()];
    vector.copyInto(objectPostedData);
    return(objectPostedData);
  }
}
