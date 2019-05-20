//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class InoutEditionData implements FieldProvider {
static Logger log4j = Logger.getLogger(InoutEditionData.class);
  private String InitRecordNumber="0";
  public String documentno;
  public String movementdate;
  public String clientName;
  public String productName;
  public String quantityorder;
  public String uomname;
  public String issotrx;
  public String locatorname;
  public String warehousename;
  public String aum;
  public String aumqty;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("client_name") || fieldName.equals("clientName"))
      return clientName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("locatorname"))
      return locatorname;
    else if (fieldName.equalsIgnoreCase("warehousename"))
      return warehousename;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InoutEditionData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String cBPartnerId, String mWarehouseId, String cProjectId)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserOrg, adUserClient, dateFrom, dateTo, cBPartnerId, mWarehouseId, cProjectId, 0, 0);
  }

  public static InoutEditionData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String cBPartnerId, String mWarehouseId, String cProjectId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_INOUT.DOCUMENTNO AS DOCUMENTNO, M_INOUT.MOVEMENTDATE AS MOVEMENTDATE, C_BPARTNER.NAME AS CLIENT_NAME, M_PRODUCT.NAME AS PRODUCT_NAME, SUM(M_INOUTLINE.MOVEMENTQTY) AS QUANTITYORDER, C_UOM.NAME AS UOMNAME," +
      "      (CASE M_INOUT.ISSOTRX " +
      "  		WHEN 'Y' THEN TO_CHAR(AD_MESSAGE_GET2('GOODSSHIPMENT',?))" +
      "  		WHEN 'N' THEN TO_CHAR(AD_MESSAGE_GET2('GOODSRECEIPT',?))" +
      "  		ELSE ''" +
      "  		END) AS ISSOTRX," +
      "  		M_LOCATOR.VALUE AS LOCATORNAME," +
      "  		M_WAREHOUSE.NAME AS WAREHOUSENAME," +
      "  	    M_INOUTLINE.C_AUM AS AUM," +
      "  	    M_INOUTLINE.AUMQTY" +
      "      FROM M_INOUT, M_INOUTLINE, C_BPARTNER, M_PRODUCT, C_UOM, M_LOCATOR, M_WAREHOUSE" +
      "      WHERE M_INOUT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND M_INOUT.M_INOUT_ID = M_INOUTLINE.M_INOUT_ID" +
      "      AND M_INOUTLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_INOUTLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_INOUTLINE.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID" +
      "      AND M_LOCATOR.M_WAREHOUSE_ID = M_WAREHOUSE.M_WAREHOUSE_ID" +
      "      AND M_INOUT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND M_INOUT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND M_INOUT.MOVEMENTDATE >= TO_DATE(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND M_INOUT.MOVEMENTDATE <= TO_DATE(?) ");
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":" AND M_INOUT.C_BPARTNER_ID = ? ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_INOUT.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND M_INOUT.C_PROJECT_ID = ? ");
    strSql = strSql + 
      "      GROUP BY C_BPARTNER.NAME, M_PRODUCT.NAME, C_UOM.NAME, M_INOUT.DOCUMENTNO, M_INOUT.MOVEMENTDATE, M_INOUT.ISSOTRX, M_LOCATOR.VALUE, M_WAREHOUSE.NAME," +
      "      M_INOUTLINE.C_AUM, M_INOUTLINE.AUMQTY" +
      "      ORDER BY C_BPARTNER.NAME, M_INOUT.MOVEMENTDATE";

    ResultSet result;
    Vector<InoutEditionData> vector = new Vector<InoutEditionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
        InoutEditionData objectInoutEditionData = new InoutEditionData();
        objectInoutEditionData.documentno = UtilSql.getValue(result, "documentno");
        objectInoutEditionData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectInoutEditionData.clientName = UtilSql.getValue(result, "client_name");
        objectInoutEditionData.productName = UtilSql.getValue(result, "product_name");
        objectInoutEditionData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectInoutEditionData.uomname = UtilSql.getValue(result, "uomname");
        objectInoutEditionData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInoutEditionData.locatorname = UtilSql.getValue(result, "locatorname");
        objectInoutEditionData.warehousename = UtilSql.getValue(result, "warehousename");
        objectInoutEditionData.aum = UtilSql.getValue(result, "aum");
        objectInoutEditionData.aumqty = UtilSql.getValue(result, "aumqty");
        objectInoutEditionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInoutEditionData);
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
    InoutEditionData objectInoutEditionData[] = new InoutEditionData[vector.size()];
    vector.copyInto(objectInoutEditionData);
    return(objectInoutEditionData);
  }

  public static InoutEditionData[] selectShipment(ConnectionProvider connectionProvider, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String cBPartnerId, String mWarehouseId, String cProjectId, String issotrx)    throws ServletException {
    return selectShipment(connectionProvider, adUserOrg, adUserClient, dateFrom, dateTo, cBPartnerId, mWarehouseId, cProjectId, issotrx, 0, 0);
  }

  public static InoutEditionData[] selectShipment(ConnectionProvider connectionProvider, String adUserOrg, String adUserClient, String dateFrom, String dateTo, String cBPartnerId, String mWarehouseId, String cProjectId, String issotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_INOUT.DOCUMENTNO AS DOCUMENTNO, M_INOUT.MOVEMENTDATE AS MOVEMENTDATE, C_BPARTNER.NAME AS CLIENT_NAME, M_PRODUCT.NAME AS PRODUCT_NAME, SUM(M_INOUTLINE.MOVEMENTQTY) AS QUANTITYORDER, C_UOM.NAME AS UOMNAME, " +
      "      M_INOUTLINE.AUMQTY, " +
      "      (CASE WHEN M_INOUTLINE.C_AUM IS NULL THEN NULL ELSE (SELECT NAME FROM C_UOM WHERE C_UOM_ID = M_INOUTLINE.C_AUM) END ) AS AUM" +
      "      FROM M_INOUT, M_INOUTLINE, C_BPARTNER, M_PRODUCT, C_UOM" +
      "      WHERE M_INOUT.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "      AND M_INOUT.M_INOUT_ID = M_INOUTLINE.M_INOUT_ID" +
      "      AND M_INOUTLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "      AND M_INOUTLINE.C_UOM_ID = C_UOM.C_UOM_ID" +
      "      AND M_INOUT.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND M_INOUT.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":" AND M_INOUT.MOVEMENTDATE >= TO_DATE(?) ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":" AND M_INOUT.MOVEMENTDATE <= TO_DATE(?) ");
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":" AND M_INOUT.C_BPARTNER_ID = ? ");
    strSql = strSql + ((mWarehouseId==null || mWarehouseId.equals(""))?"":" AND M_INOUT.M_WAREHOUSE_ID = ? ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND M_INOUT.C_PROJECT_ID = ? ");
    strSql = strSql + 
      "      AND M_INOUT.ISSOTRX = ?" +
      "      GROUP BY C_BPARTNER.NAME, M_PRODUCT.NAME, C_UOM.NAME, M_INOUT.DOCUMENTNO, M_INOUT.MOVEMENTDATE, M_INOUTLINE.AUMQTY, M_INOUTLINE.C_AUM" +
      "      ORDER BY C_BPARTNER.NAME, M_INOUT.MOVEMENTDATE, M_INOUT.DOCUMENTNO";

    ResultSet result;
    Vector<InoutEditionData> vector = new Vector<InoutEditionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (mWarehouseId != null && !(mWarehouseId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);

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
        InoutEditionData objectInoutEditionData = new InoutEditionData();
        objectInoutEditionData.documentno = UtilSql.getValue(result, "documentno");
        objectInoutEditionData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectInoutEditionData.clientName = UtilSql.getValue(result, "client_name");
        objectInoutEditionData.productName = UtilSql.getValue(result, "product_name");
        objectInoutEditionData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectInoutEditionData.uomname = UtilSql.getValue(result, "uomname");
        objectInoutEditionData.aumqty = UtilSql.getValue(result, "aumqty");
        objectInoutEditionData.aum = UtilSql.getValue(result, "aum");
        objectInoutEditionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInoutEditionData);
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
    InoutEditionData objectInoutEditionData[] = new InoutEditionData[vector.size()];
    vector.copyInto(objectInoutEditionData);
    return(objectInoutEditionData);
  }
}
