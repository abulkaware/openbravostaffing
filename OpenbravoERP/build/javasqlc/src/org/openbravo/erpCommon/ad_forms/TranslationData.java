//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class TranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslationData.class);
  private String InitRecordNumber="0";
  public String c;
  public String adModuleId;
  public String value;
  public String tablename;
  public String isindevelopment;
  public String adTableId;
  public String adLanguage;
  public String grandparent;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c"))
      return c;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("isindevelopment"))
      return isindevelopment;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("grandparent"))
      return grandparent;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TranslationData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static TranslationData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select '1' AS C, '' AS AD_MODULE_ID, '' AS VALUE, '' AS TABLENAME," +
      "             '' AS ISINDEVELOPMENT, '' AS AD_Table_ID, '' as AD_Language, '' AS grandParent" +
      "      from dual ";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.c = UtilSql.getValue(result, "c");
        objectTranslationData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectTranslationData.value = UtilSql.getValue(result, "value");
        objectTranslationData.tablename = UtilSql.getValue(result, "tablename");
        objectTranslationData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectTranslationData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationData.grandparent = UtilSql.getValue(result, "grandparent");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static String selectContributors(ConnectionProvider connectionProvider, String paramLanguage)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select TranslatedBy" +
      "          from ad_language" +
      "         where ad_language = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "translatedby");
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

  public static String version(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT AD_SYSTEM_INFO.OB_VERSION FROM AD_SYSTEM_INFO";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ob_version");
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

  public static String selectModuleLang(ConnectionProvider connectionProvider, String moduleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT AD_LANGUAGE AS C" +
      "            FROM AD_MODULE" +
      "           WHERE AD_MODULE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, moduleId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c");
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

  public static String centrallyMaintained(ConnectionProvider connectionProvider, String tableName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select count(*) AS c" +
      "           from AD_Table t," +
      "                AD_Column c" +
      "          where c.AD_Table_ID=t.AD_Table_ID " +
      "            and upper(c.ColumnName)='ISCENTRALLYMAINTAINED'" +
      "            and c.IsActive = 'Y'" +
      "            and upper(t.tableName) = upper(?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableName);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c");
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

  public static TranslationData[] trlColumns(ConnectionProvider connectionProvider, String tableName)    throws ServletException {
    return trlColumns(connectionProvider, tableName, 0, 0);
  }

  public static TranslationData[] trlColumns(ConnectionProvider connectionProvider, String tableName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select ColumnName AS c" +
      "           from AD_Table t," +
      "                AD_Column c" +
      "          where c.AD_Table_ID=t.AD_Table_ID " +
      "            and upper(t.TableName)=?" +
      "            and c.AD_Reference_ID in ('10','14')" +
      "          order by IsMandatory desc, ColumnName";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableName);

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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.c = UtilSql.getValue(result, "c");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static TranslationData[] trlTables(ConnectionProvider connectionProvider)    throws ServletException {
    return trlTables(connectionProvider, 0, 0);
  }

  public static TranslationData[] trlTables(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select upper(tablename) AS c" +
      "           from ad_table " +
      "          where upper(tablename) like '%TRL'" +
      "          order by tablename";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.c = UtilSql.getValue(result, "c");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static TranslationData[] modules(ConnectionProvider connectionProvider)    throws ServletException {
    return modules(connectionProvider, 0, 0);
  }

  public static TranslationData[] modules(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select ad_module_id AS AD_MODULE_ID, JAVAPACKAGE AS VALUE" +
      "           from ad_module ";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectTranslationData.value = UtilSql.getValue(result, "value");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static TranslationData[] trlModulesTables(ConnectionProvider connectionProvider)    throws ServletException {
    return trlModulesTables(connectionProvider, 0, 0);
  }

  public static TranslationData[] trlModulesTables(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select upper(t.tablename) AS c" +
      "        from aD_table t" +
      "        where lower(t.tablename) like '%trl'" +
      "         and exists" +
      "          (select 1" +
      "           from ad_column c," +
      "             ad_table t2" +
      "           where t2.ad_table_id = c.ad_table_id" +
      "           and lower(columnname) = 'ad_module_id'" +
      "           and lower(t2.tablename) || '_trl' = lower(t.tablename)" +
      "           union" +
      "           select 1" +
      "             from ad_table t1, ad_column c, ad_table t2, ad_column c2" +
      "            where t1.ad_table_id = c.ad_table_id" +
      "              and c.isparent='Y'" +
      "              and lower(t2.tablename)||'_id' = lower(c.columnname)" +
      "              and lower(t1.tablename) || '_trl' = lower(t.tablename)" +
      "              and exists (select 1 from ad_column where ad_table_id = t2.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "           union" +
      "           select 1" +
      "              from ad_table t1, ad_column c, ad_table t2, ad_column c2, ad_table t3, ad_column c3" +
      "            where t2.ad_table_id = c2.ad_table_id" +
      "              and t1.ad_table_id = c.ad_table_id" +
      "              and c.isparent='Y'" +
      "              and c2.isparent='Y'" +
      "              and lower(t3.tablename)||'_id' = lower(c2.columnname)" +
      "              and lower(t2.tablename)||'_id' = lower(c.columnname)" +
      "              and lower(t1.tablename) || '_trl' = lower(t.tablename)" +
      "              and exists (select 1 from ad_column where ad_table_id = t3.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "              and not exists (select 1 from ad_column where ad_table_id = t2.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "           )";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.c = UtilSql.getValue(result, "c");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static TranslationData[] parentTable(ConnectionProvider connectionProvider, String tablename)    throws ServletException {
    return parentTable(connectionProvider, tablename, 0, 0);
  }

  public static TranslationData[] parentTable(ConnectionProvider connectionProvider, String tablename, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select t2.tablename as tablename, null as grandParent" +
      "       from ad_table t, ad_table t1, ad_column c, ad_table t2" +
      "      where t1.ad_table_id = c.ad_table_id" +
      "        and c.isparent='Y'" +
      "        and lower(t2.tablename)||'_id' = lower(c.columnname)" +
      "        and lower(t1.tablename) || '_trl' = lower(t.tablename)" +
      "        and exists (select 1 from ad_column where ad_table_id = t2.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "        and not exists (select 1 from ad_column where ad_table_id = t1.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "        and lower(t.tablename) = lower(?)" +
      "      union" +
      "      select t2.tablename, t3.tablename" +
      "        from ad_table t, ad_table t1, ad_column c, ad_table t2, ad_column c2, ad_table t3" +
      "       where t2.ad_table_id = c2.ad_table_id" +
      "         and t1.ad_table_id = c.ad_table_id" +
      "         and c.isparent='Y'" +
      "         and c2.isparent='Y'" +
      "         and lower(t3.tablename)||'_id' = lower(c2.columnname)" +
      "         and lower(t2.tablename)||'_id' = lower(c.columnname)" +
      "         and lower(t1.tablename) || '_trl' = lower(t.tablename)" +
      "         and exists (select 1 from ad_column where ad_table_id = t3.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "         and not exists (select 1 from ad_column where ad_table_id = t2.ad_table_id and lower(columnname) = 'ad_module_id')" +
      "         and lower(t.tablename) = lower(?)";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablename);

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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.tablename = UtilSql.getValue(result, "tablename");
        objectTranslationData.grandparent = UtilSql.getValue(result, "grandparent");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static TranslationData[] referenceDataTrl(ConnectionProvider connectionProvider)    throws ServletException {
    return referenceDataTrl(connectionProvider, 0, 0);
  }

  public static TranslationData[] referenceDataTrl(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT D.AD_MODULE_ID, M.ISINDEVELOPMENT, t.tablename, " +
      "             t.AD_Table_ID,  M.AD_Language, M.JavaPackage as Value" +
      "        FROM AD_DATASET D," +
      "             AD_DATASET_TABLE DT," +
      "             AD_TABLE T," +
      "             AD_MODULE M" +
      "       WHERE EXPORTALLOWED='Y'" +
      "         AND DT.AD_DATASET_ID = D.AD_DATASET_ID" +
      "         AND T.AD_TABLE_ID = DT.AD_TABLE_ID" +
      "         AND M.AD_MODULE_ID = D.AD_MODULE_ID" +
      "         AND EXISTS (SELECT 1 " +
      "                       FROM AD_TABLE T1" +
      "                      WHERE UPPER(T1.TABLENAME) = UPPER(T.TABLENAME)||'_TRL')";

    ResultSet result;
    Vector<TranslationData> vector = new Vector<TranslationData>(0);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectTranslationData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectTranslationData.tablename = UtilSql.getValue(result, "tablename");
        objectTranslationData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationData.value = UtilSql.getValue(result, "value");
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

  public static int insertContrib(ConnectionProvider connectionProvider, String contrib, String lang)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         update ad_language" +
      "            set translatedBy = ?," +
      "                updatedby = 0," +
      "                updated = now()" +
      "          where ad_language = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contrib);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

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
