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

public class TabAttachmentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(TabAttachmentsData.class);
  private String InitRecordNumber="0";
  public String cFileId;
  public String text;
  public String name;
  public String datatype;
  public String cDatatypeId;
  public String adTableId;
  public String isreadonly;
  public String datatypeContent;
  public String adRecordId;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_file_id") || fieldName.equals("cFileId"))
      return cFileId;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("datatype"))
      return datatype;
    else if (fieldName.equalsIgnoreCase("c_datatype_id") || fieldName.equals("cDatatypeId"))
      return cDatatypeId;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("isreadonly"))
      return isreadonly;
    else if (fieldName.equalsIgnoreCase("datatype_content") || fieldName.equals("datatypeContent"))
      return datatypeContent;
    else if (fieldName.equalsIgnoreCase("ad_record_id") || fieldName.equals("adRecordId"))
      return adRecordId;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TabAttachmentsData[] select(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adTableId, String recordId)    throws ServletException {
    return select(connectionProvider, adClientId, adOrgId, adTableId, recordId, 0, 0);
  }

  public static TabAttachmentsData[] select(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String adTableId, String recordId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT F.C_FILE_ID, F.TEXT, F.NAME, D.NAME AS DATATYPE, F.C_DATATYPE_ID, F.AD_TABLE_ID, " +
      "        '' AS ISREADONLY, D.FORMAT AS DATATYPE_CONTENT, F.AD_RECORD_ID " +
      "        FROM C_FILE F left join AD_DATATYPE D on F.c_DATATYPE_ID = D.ad_DATATYPE_ID" +
      "        WHERE F.AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND F.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "        AND F.ISACTIVE = 'Y' " +
      "        AND F.AD_TABLE_ID = ? " +
      "        AND F.AD_RECORD_ID = ? " +
      "        ORDER BY F.SEQNO";

    ResultSet result;
    Vector<TabAttachmentsData> vector = new Vector<TabAttachmentsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);

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
        TabAttachmentsData objectTabAttachmentsData = new TabAttachmentsData();
        objectTabAttachmentsData.cFileId = UtilSql.getValue(result, "c_file_id");
        objectTabAttachmentsData.text = UtilSql.getValue(result, "text");
        objectTabAttachmentsData.name = UtilSql.getValue(result, "name");
        objectTabAttachmentsData.datatype = UtilSql.getValue(result, "datatype");
        objectTabAttachmentsData.cDatatypeId = UtilSql.getValue(result, "c_datatype_id");
        objectTabAttachmentsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTabAttachmentsData.isreadonly = UtilSql.getValue(result, "isreadonly");
        objectTabAttachmentsData.datatypeContent = UtilSql.getValue(result, "datatype_content");
        objectTabAttachmentsData.adRecordId = UtilSql.getValue(result, "ad_record_id");
        objectTabAttachmentsData.position = Long.toString(countRecord);
        objectTabAttachmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabAttachmentsData);
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
    TabAttachmentsData objectTabAttachmentsData[] = new TabAttachmentsData[vector.size()];
    vector.copyInto(objectTabAttachmentsData);
    return(objectTabAttachmentsData);
  }

  public static TabAttachmentsData[] set()    throws ServletException {
    TabAttachmentsData objectTabAttachmentsData[] = new TabAttachmentsData[1];
    objectTabAttachmentsData[0] = new TabAttachmentsData();
    objectTabAttachmentsData[0].cFileId = "";
    objectTabAttachmentsData[0].text = "";
    objectTabAttachmentsData[0].name = "";
    objectTabAttachmentsData[0].datatype = "";
    objectTabAttachmentsData[0].cDatatypeId = "";
    objectTabAttachmentsData[0].adTableId = "";
    objectTabAttachmentsData[0].isreadonly = "";
    objectTabAttachmentsData[0].datatypeContent = "";
    objectTabAttachmentsData[0].adRecordId = "";
    return objectTabAttachmentsData;
  }

  public static TabAttachmentsData[] selectEdit(ConnectionProvider connectionProvider, String cFileId)    throws ServletException {
    return selectEdit(connectionProvider, cFileId, 0, 0);
  }

  public static TabAttachmentsData[] selectEdit(ConnectionProvider connectionProvider, String cFileId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT F.C_FILE_ID, F.TEXT, F.NAME, D.NAME AS DATATYPE, F.C_DATATYPE_ID, F.AD_TABLE_ID, " +
      "        '' AS ISREADONLY, D.FORMAT AS DATATYPE_CONTENT, F.AD_RECORD_ID " +
      "        FROM C_FILE F left join AD_DATATYPE D on F.c_DATATYPE_ID = D.ad_DATATYPE_ID" +
      "        WHERE F.ISACTIVE = 'Y' " +
      "        AND F.C_FILE_ID = ? ";

    ResultSet result;
    Vector<TabAttachmentsData> vector = new Vector<TabAttachmentsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);

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
        TabAttachmentsData objectTabAttachmentsData = new TabAttachmentsData();
        objectTabAttachmentsData.cFileId = UtilSql.getValue(result, "c_file_id");
        objectTabAttachmentsData.text = UtilSql.getValue(result, "text");
        objectTabAttachmentsData.name = UtilSql.getValue(result, "name");
        objectTabAttachmentsData.datatype = UtilSql.getValue(result, "datatype");
        objectTabAttachmentsData.cDatatypeId = UtilSql.getValue(result, "c_datatype_id");
        objectTabAttachmentsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTabAttachmentsData.isreadonly = UtilSql.getValue(result, "isreadonly");
        objectTabAttachmentsData.datatypeContent = UtilSql.getValue(result, "datatype_content");
        objectTabAttachmentsData.adRecordId = UtilSql.getValue(result, "ad_record_id");
        objectTabAttachmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabAttachmentsData);
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
    TabAttachmentsData objectTabAttachmentsData[] = new TabAttachmentsData[vector.size()];
    vector.copyInto(objectTabAttachmentsData);
    return(objectTabAttachmentsData);
  }

  public static String selectNext(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cFileId, String adTableId, String recordId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_FILE_ID AS ID " +
      "        FROM C_FILE " +
      "        WHERE ISACTIVE = 'Y'" +
      "        AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adClientId==null || adClientId.equals(""))?"":adClientId);
    strSql = strSql + 
      ") " +
      "        AND AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ") " +
      "        AND SEQNO > (SELECT SEQNO FROM C_FILE WHERE C_FILE_ID = ?)" +
      "        AND AD_TABLE_ID = ?" +
      "        AND AD_RECORD_ID = ?" +
      "        ORDER BY SEQNO";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adClientId != null && !(adClientId.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);

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

  public static TabAttachmentsData[] selectReference(ConnectionProvider connectionProvider, String cFileId)    throws ServletException {
    return selectReference(connectionProvider, cFileId, 0, 0);
  }

  public static TabAttachmentsData[] selectReference(ConnectionProvider connectionProvider, String cFileId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT F.C_FILE_ID, F.NAME, D.FORMAT AS DATATYPE, F.AD_TABLE_ID, F.AD_RECORD_ID " +
      "        FROM C_FILE F left join AD_DATATYPE D on F.c_DATATYPE_ID = D.ad_DATATYPE_ID" +
      "        WHERE  F.C_FILE_ID = ? ";

    ResultSet result;
    Vector<TabAttachmentsData> vector = new Vector<TabAttachmentsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);

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
        TabAttachmentsData objectTabAttachmentsData = new TabAttachmentsData();
        objectTabAttachmentsData.cFileId = UtilSql.getValue(result, "c_file_id");
        objectTabAttachmentsData.name = UtilSql.getValue(result, "name");
        objectTabAttachmentsData.datatype = UtilSql.getValue(result, "datatype");
        objectTabAttachmentsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTabAttachmentsData.adRecordId = UtilSql.getValue(result, "ad_record_id");
        objectTabAttachmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabAttachmentsData);
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
    TabAttachmentsData objectTabAttachmentsData[] = new TabAttachmentsData[vector.size()];
    vector.copyInto(objectTabAttachmentsData);
    return(objectTabAttachmentsData);
  }

  public static TabAttachmentsData[] selectTabInfo(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    return selectTabInfo(connectionProvider, adTabId, 0, 0);
  }

  public static TabAttachmentsData[] selectTabInfo(ConnectionProvider connectionProvider, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TABLE_ID, (CASE UIPATTERN WHEN 'RO' THEN 'Y' ELSE (CASE ISINFOTAB WHEN 'Y' THEN 'Y' ELSE 'N' END) END) AS ISREADONLY " +
      "        FROM AD_TAB WHERE AD_TAB_ID = ?";

    ResultSet result;
    Vector<TabAttachmentsData> vector = new Vector<TabAttachmentsData>(0);
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
        TabAttachmentsData objectTabAttachmentsData = new TabAttachmentsData();
        objectTabAttachmentsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTabAttachmentsData.isreadonly = UtilSql.getValue(result, "isreadonly");
        objectTabAttachmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabAttachmentsData);
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
    TabAttachmentsData objectTabAttachmentsData[] = new TabAttachmentsData[vector.size()];
    vector.copyInto(objectTabAttachmentsData);
    return(objectTabAttachmentsData);
  }

/**
This method is depreciated. Use the insert method with path argument
 */
  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cFileId, String adClientId, String adOrgId, String adUserId, String adTableId, String adRecordId, String cDatatypeId, String text, String name)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_FILE (C_FILE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY," +
      "        UPDATED, UPDATEDBY, AD_TABLE_ID, AD_RECORD_ID, C_DATATYPE_ID, TEXT, NAME, SEQNO)" +
      "        VALUES(?, ?, ?, 'Y', now(), ?," +
      "        now(), ?, ?, ?, ?, ?, ?, (SELECT COALESCE(MAX(SEQNO), 0) + 10 FROM C_FILE WHERE AD_TABLE_ID = ? AND AD_RECORD_ID=?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRecordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDatatypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRecordId);

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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cFileId, String adClientId, String adOrgId, String adUserId, String adTableId, String adRecordId, String cDatatypeId, String text, String name, String path)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_FILE (C_FILE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, AD_TABLE_ID, AD_RECORD_ID, C_DATATYPE_ID, TEXT, NAME, SEQNO, PATH)" +
      "        VALUES(?, ?, ?, 'Y', now(), ?, " +
      "        now(), ?, ?, ?, ?, ?, ?, (SELECT COALESCE(MAX(SEQNO), 0) + 10 FROM C_FILE WHERE AD_TABLE_ID = ? AND AD_RECORD_ID=?),?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRecordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDatatypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRecordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, path);

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

  public static int update(ConnectionProvider connectionProvider, String adUserId, String cDatatypeId, String text, String cFileId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_FILE SET UPDATED=now(), UPDATEDBY = ?, C_DATATYPE_id = ?, TEXT=?" +
      "        WHERE C_FILE_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDatatypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);

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

  public static int delete(Connection conn, ConnectionProvider connectionProvider, String cFileId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_FILE WHERE C_FILE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFileId);

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

  public static String selectRecordIdentifier(ConnectionProvider connectionProvider, String recordID, String lang, String tabID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select ad_column_identifier(tablename, to_char(?), ?) as ID" +
      "            from ad_tab a," +
      "                 ad_table t" +
      "            where ad_tab_id = ?" +
      "            and a.ad_table_id = t.ad_table_id";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabID);

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
}
