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

class CreateFromMultipleShipmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromMultipleShipmentData.class);
  private String InitRecordNumber="0";
  public String mStorageDetailId;
  public String name;
  public String mLocatorId;
  public String description;
  public String uom1;
  public String uom2;
  public String qtyonhand;
  public String qtyorderonhand;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_storage_detail_id") || fieldName.equals("mStorageDetailId"))
      return mStorageDetailId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("uom1"))
      return uom1;
    else if (fieldName.equalsIgnoreCase("uom2"))
      return uom2;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyorderonhand"))
      return qtyorderonhand;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromMultipleShipmentData[] select(ConnectionProvider connectionProvider, String adLanguage, String bpartner, String product, String warehouse, String x, String y, String z, String adUserClient)    throws ServletException {
    return select(connectionProvider, adLanguage, bpartner, product, warehouse, x, y, z, adUserClient, 0, 0);
  }

  public static CreateFromMultipleShipmentData[] select(ConnectionProvider connectionProvider, String adLanguage, String bpartner, String product, String warehouse, String x, String y, String z, String adUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT S.M_STORAGE_DETAIL_ID, P.NAME, ad_column_identifier(TO_CHAR('M_LOCATOR'),TO_CHAR(S.M_LOCATOR_ID),TO_CHAR(?)) as M_LOCATOR_ID, A.DESCRIPTION, U1.NAME AS UOM1, U2.NAME AS UOM2, " +
      "        S.QTYONHAND, S.QTYORDERONHAND as QTYORDERONHAND" +
      "        FROM M_STORAGE_DETAIL S left join M_ATTRIBUTESETINSTANCE A on S.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_Id" +
      "                                left join M_PRODUCT_UOM PU         on S.M_PRODUCT_UOM_ID = PU.M_PRODUCT_UOM_ID" +
      "                                left join C_UOM U2                 ON  PU.C_UOM_ID  = U2.C_UOM_ID ," +
      "        M_PRODUCT P,  C_UOM U1,  " +
      "        M_LOCATOR L " +
      "        WHERE ";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  P.C_BPARTNER_ID = ? AND  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  S.M_PRODUCT_ID = ? AND  ");
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  L.M_WAREHOUSE_ID = ? AND  ");
    strSql = strSql + ((x==null || x.equals(""))?"":"  L.X = ? AND  ");
    strSql = strSql + ((y==null || y.equals(""))?"":"  L.Y = ? AND  ");
    strSql = strSql + ((z==null || z.equals(""))?"":"  L.Z = ? AND  ");
    strSql = strSql + 
      "S.M_PRODUCT_ID = P.M_PRODUCT_ID " +
      "        AND S.C_UOM_ID = U1.C_UOM_ID " +
      "        AND S.M_LOCATOR_ID = L.M_LOCATOR_ID " +
      "        AND S.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND S.QTYONHAND <> 0" +
      "        ORDER BY P.NAME, L.PRIORITYNO, L.X, L.Y, L.Z ";

    ResultSet result;
    Vector<CreateFromMultipleShipmentData> vector = new Vector<CreateFromMultipleShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (warehouse != null && !(warehouse.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (x != null && !(x.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, x);
      }
      if (y != null && !(y.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, y);
      }
      if (z != null && !(z.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, z);
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
        CreateFromMultipleShipmentData objectCreateFromMultipleShipmentData = new CreateFromMultipleShipmentData();
        objectCreateFromMultipleShipmentData.mStorageDetailId = UtilSql.getValue(result, "m_storage_detail_id");
        objectCreateFromMultipleShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromMultipleShipmentData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectCreateFromMultipleShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromMultipleShipmentData.uom1 = UtilSql.getValue(result, "uom1");
        objectCreateFromMultipleShipmentData.uom2 = UtilSql.getValue(result, "uom2");
        objectCreateFromMultipleShipmentData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectCreateFromMultipleShipmentData.qtyorderonhand = UtilSql.getValue(result, "qtyorderonhand");
        objectCreateFromMultipleShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromMultipleShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromMultipleShipmentData);
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
    CreateFromMultipleShipmentData objectCreateFromMultipleShipmentData[] = new CreateFromMultipleShipmentData[vector.size()];
    vector.copyInto(objectCreateFromMultipleShipmentData);
    return(objectCreateFromMultipleShipmentData);
  }

  public static String bpartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static String productDescription(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME FROM M_PRODUCT WHERE M_PRODUCT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String adClientId, String adOrgId, String adUserId, String mInoutId, String movementqty, String quantityorder, String mStorageDetailId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_INOUTLINE (M_INOUTLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, LINE, " +
      "        DESCRIPTION, M_INOUT_ID, C_ORDERLINE_ID, M_LOCATOR_ID, M_PRODUCT_ID, C_UOM_ID, MOVEMENTQTY, ISINVOICED," +
      "        M_ATTRIBUTESETINSTANCE_ID, ISDESCRIPTION, QUANTITYORDER, M_PRODUCT_UOM_ID) " +
      "        SELECT ?,?,?,'Y',now(),?,now(),?,(SELECT COALESCE(MAX(LINE),0) + 10 FROM M_INOUTLINE WHERE M_INOUT_ID=?)," +
      "        NULL,?,NULL,M_LOCATOR_ID,M_PRODUCT_ID,C_UOM_ID,TO_NUMBER(?),'N'," +
      "        M_ATTRIBUTESETINSTANCE_ID,'N',TO_NUMBER(?),M_PRODUCT_UOM_ID" +
      "        FROM M_STORAGE_DETAIL " +
      "        WHERE M_STORAGE_DETAIL_ID = ? ";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mStorageDetailId);

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
}
