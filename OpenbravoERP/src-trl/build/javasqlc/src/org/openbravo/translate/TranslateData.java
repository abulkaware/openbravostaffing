//Sqlc generated V1.O00-1
package org.openbravo.translate;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.database.SessionInfo;
import java.util.*;

class TranslateData implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslateData.class);
  private String InitRecordNumber="0";
  public String id;
  public String tr;
  public String text;
  public String module;
  public String filename;
  public String lang;
  public String name;
  public String javapackage;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("tr"))
      return tr;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
    else if (fieldName.equalsIgnoreCase("module"))
      return module;
    else if (fieldName.equalsIgnoreCase("filename"))
      return filename;
    else if (fieldName.equalsIgnoreCase("lang"))
      return lang;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TranslateData[] getTextInterfaces(ConnectionProvider connectionProvider)    throws ServletException {
    return getTextInterfaces(connectionProvider, 0, 0);
  }

  public static TranslateData[] getTextInterfaces(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select ad_textinterfaces_id as id, isUsed as tr, text, t.ad_module_id as module, filename, m.ad_language as lang, '' as name,'' as javapackage" +
      "        from ad_textinterfaces t, ad_module m" +
      "       where t.ad_module_id = m.ad_module_id" +
      "       order by text, case when filename is not null then 0 else 1 end";

    ResultSet result;
    Vector<TranslateData> vector = new Vector<TranslateData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        TranslateData objectTranslateData = new TranslateData();
        objectTranslateData.id = UtilSql.getValue(result, "id");
        objectTranslateData.tr = UtilSql.getValue(result, "tr");
        objectTranslateData.text = UtilSql.getValue(result, "text");
        objectTranslateData.module = UtilSql.getValue(result, "module");
        objectTranslateData.filename = UtilSql.getValue(result, "filename");
        objectTranslateData.lang = UtilSql.getValue(result, "lang");
        objectTranslateData.name = UtilSql.getValue(result, "name");
        objectTranslateData.javapackage = UtilSql.getValue(result, "javapackage");
        objectTranslateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslateData);
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
    TranslateData objectTranslateData[] = new TranslateData[vector.size()];
    vector.copyInto(objectTranslateData);
    return(objectTranslateData);
  }

  public static TranslateData[] getModulesInDevelopment(ConnectionProvider connectionProvider)    throws ServletException {
    return getModulesInDevelopment(connectionProvider, 0, 0);
  }

  public static TranslateData[] getModulesInDevelopment(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select AD_Module_id as id, name, javapackage, AD_LANGUAGE as lang" +
      "        from AD_Module" +
      "       where isInDevelopment = 'Y'" +
      "       order by 1";

    ResultSet result;
    Vector<TranslateData> vector = new Vector<TranslateData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        TranslateData objectTranslateData = new TranslateData();
        objectTranslateData.id = UtilSql.getValue(result, "id");
        objectTranslateData.name = UtilSql.getValue(result, "name");
        objectTranslateData.javapackage = UtilSql.getValue(result, "javapackage");
        objectTranslateData.lang = UtilSql.getValue(result, "lang");
        objectTranslateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslateData);
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
    TranslateData objectTranslateData[] = new TranslateData[vector.size()];
    vector.copyInto(objectTranslateData);
    return(objectTranslateData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String text, String filename, String module)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      insert into ad_textinterfaces" +
      "        (AD_TEXTINTERFACES_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, TEXT, FILENAME, ISUSED, AD_MODULE_ID)" +
      "      values" +
      "        (get_uuid(),'0' ,'0', 'Y', now(), '0', now(), '0', ?, ?, 'Y', ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, module);

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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String adTextinterfacesId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      update ad_textinterfaces t" +
      "         set isUsed='Y'" +
      "       where ad_textinterfaces_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTextinterfacesId);

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

  public static int clean(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      update ad_textinterfaces t" +
      "         set isUsed='N'" +
      "       where exists (select 1 " +
      "                       from ad_module m" +
      "                      where m.ad_module_id = t.ad_module_id" +
      "                        and m.isInDevelopment = 'Y')  ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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

  public static int remove(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      delete from ad_textinterfaces t" +
      "       where isUsed='N'" +
      "         and exists (select 1 " +
      "                       from ad_module m" +
      "                      where m.ad_module_id = t.ad_module_id" +
      "                        and m.isInDevelopment = 'Y')  ";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
