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

class CreateFromMultipleReceiptData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromMultipleReceiptData.class);
  private String InitRecordNumber="0";
  public String mLocatorId;
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Principal select
 */
  public static CreateFromMultipleReceiptData[] select(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String mWarehouseId, String mLocatorId)    throws ServletException {
    return select(conn, connectionProvider, adLanguage, adUserClient, adOrgClient, mWarehouseId, mLocatorId, 0, 0);
  }

/**
Principal select
 */
  public static CreateFromMultipleReceiptData[] select(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adOrgClient, String mWarehouseId, String mLocatorId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT L.M_LOCATOR_ID, '' as ID, ad_column_identifier('M_LOCATOR',to_char(L.M_LOCATOR_ID),?) AS NAME  " +
      "        FROM M_LOCATOR L " +
      "        WHERE L.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND L.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND L.M_WAREHOUSE_ID = ? " +
      "        AND L.ISACTIVE = 'Y' ";
    strSql = strSql + ((mLocatorId==null || mLocatorId.equals(""))?"":"  AND L.X = ?  ");
    strSql = strSql + 
      "        AND NOT EXISTS(SELECT 1 FROM M_STORAGE_DETAIL S" +
      "        WHERE S.M_LOCATOR_ID = L.M_LOCATOR_ID " +
      "        AND S.QTYONHAND > 0)" +
      "        AND NOT EXISTS(SELECT 1 FROM M_INOUTLINE IL, M_INOUT M" +
      "        WHERE IL.M_LOCATOR_ID = L.M_LOCATOR_ID" +
      "        AND IL.M_INOUT_ID = M.M_INOUT_ID" +
      "        AND M.PROCESSED ='N')" +
      "        AND NOT EXISTS(SELECT 1 FROM M_MOVEMENTLINE ML, M_MOVEMENT MV" +
      "        WHERE ML.M_LOCATORTO_ID = L.M_LOCATOR_ID" +
      "        AND ML.M_MOVEMENT_ID = MV.M_MOVEMENT_ID" +
      "        AND MV.PROCESSED ='N')" +
      "        AND 1=1" +
      "        ORDER BY L.PRIORITYNO, L.X, L.Y, L.Z";

    ResultSet result;
    Vector<CreateFromMultipleReceiptData> vector = new Vector<CreateFromMultipleReceiptData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      if (mLocatorId != null && !(mLocatorId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
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
        CreateFromMultipleReceiptData objectCreateFromMultipleReceiptData = new CreateFromMultipleReceiptData();
        objectCreateFromMultipleReceiptData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectCreateFromMultipleReceiptData.id = UtilSql.getValue(result, "id");
        objectCreateFromMultipleReceiptData.name = UtilSql.getValue(result, "name");
        objectCreateFromMultipleReceiptData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromMultipleReceiptData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CreateFromMultipleReceiptData objectCreateFromMultipleReceiptData[] = new CreateFromMultipleReceiptData[vector.size()];
    vector.copyInto(objectCreateFromMultipleReceiptData);
    return(objectCreateFromMultipleReceiptData);
  }

/**
Ids and Names of table dir M_Locator
 */
  public static CreateFromMultipleReceiptData[] selectM_Locator_X(ConnectionProvider connectionProvider, String warehouse)    throws ServletException {
    return selectM_Locator_X(connectionProvider, warehouse, 0, 0);
  }

/**
Ids and Names of table dir M_Locator
 */
  public static CreateFromMultipleReceiptData[] selectM_Locator_X(ConnectionProvider connectionProvider, String warehouse, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT M_Locator.X as id, M_Locator.X as name " +
      "      FROM M_Locator, M_Warehouse" +
      "      WHERE M_Warehouse.M_Warehouse_Id = M_Locator.M_Warehouse_Id" +
      "      AND M_Locator.isActive = 'Y'" +
      "      AND  M_Warehouse.M_WAREHOUSE_ID = ? " +
      "      ORDER BY M_Locator.X";

    ResultSet result;
    Vector<CreateFromMultipleReceiptData> vector = new Vector<CreateFromMultipleReceiptData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);

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
        CreateFromMultipleReceiptData objectCreateFromMultipleReceiptData = new CreateFromMultipleReceiptData();
        objectCreateFromMultipleReceiptData.id = UtilSql.getValue(result, "id");
        objectCreateFromMultipleReceiptData.name = UtilSql.getValue(result, "name");
        objectCreateFromMultipleReceiptData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromMultipleReceiptData);
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
    CreateFromMultipleReceiptData objectCreateFromMultipleReceiptData[] = new CreateFromMultipleReceiptData[vector.size()];
    vector.copyInto(objectCreateFromMultipleReceiptData);
    return(objectCreateFromMultipleReceiptData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String adClientId, String adOrgId, String adUserId, String mInoutId, String mLocatorId, String mProductId, String cUomId, String movementqty, String mAttributesetinstanceId, String quantityorder, String mProductUomId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_INOUTLINE (M_INOUTLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, LINE, " +
      "        DESCRIPTION, M_INOUT_ID, C_ORDERLINE_ID, M_LOCATOR_ID, M_PRODUCT_ID, C_UOM_ID, MOVEMENTQTY, ISINVOICED, " +
      "        M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID) " +
      "        VALUES (?,?,?,'Y',NOW(),?,NOW(),?, (SELECT COALESCE(MAX(LINE),0) + 10 FROM M_INOUTLINE WHERE M_INOUT_ID=?)," +
      "        NULL,?,NULL,?,?,?,TO_NUMBER(?),'N'," +
      "        ?,'N',TO_NUMBER(?),?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);

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

  public static CreateFromMultipleReceiptData[] selectAccessibleWarehouses(ConnectionProvider connectionProvider, String rol, String client)    throws ServletException {
    return selectAccessibleWarehouses(connectionProvider, rol, client, 0, 0);
  }

  public static CreateFromMultipleReceiptData[] selectAccessibleWarehouses(ConnectionProvider connectionProvider, String rol, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Warehouse.M_Warehouse_ID as id, M_Warehouse.Name AS Name " +
      "        FROM M_Warehouse, AD_ORG , AD_ROLE_ORGACCESS" +
      "        WHERE M_Warehouse.AD_ORG_ID = AD_ORG.AD_ORG_ID" +
      "        AND AD_ORG.AD_ORG_ID = AD_ROLE_ORGACCESS.AD_ORG_ID" +
      "        AND M_Warehouse.IsActive='Y' " +
      "        AND AD_ROLE_ORGACCESS.AD_ROLE_ID = ? " +
      "        AND M_Warehouse.AD_Client_ID = ? " +
      "        ORDER BY M_Warehouse.Value";

    ResultSet result;
    Vector<CreateFromMultipleReceiptData> vector = new Vector<CreateFromMultipleReceiptData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        CreateFromMultipleReceiptData objectCreateFromMultipleReceiptData = new CreateFromMultipleReceiptData();
        objectCreateFromMultipleReceiptData.id = UtilSql.getValue(result, "id");
        objectCreateFromMultipleReceiptData.name = UtilSql.getValue(result, "name");
        objectCreateFromMultipleReceiptData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromMultipleReceiptData);
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
    CreateFromMultipleReceiptData objectCreateFromMultipleReceiptData[] = new CreateFromMultipleReceiptData[vector.size()];
    vector.copyInto(objectCreateFromMultipleReceiptData);
    return(objectCreateFromMultipleReceiptData);
  }
}
