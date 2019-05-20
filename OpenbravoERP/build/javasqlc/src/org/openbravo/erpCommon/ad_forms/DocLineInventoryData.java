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

class DocLineInventoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineInventoryData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String mProductId;
  public String line;
  public String description;
  public String cUomId;
  public String mInventorylineId;
  public String qtybook;
  public String qtycount;
  public String mLocatorId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_id") || fieldName.equals("mInventorylineId"))
      return mInventorylineId;
    else if (fieldName.equalsIgnoreCase("qtybook"))
      return qtybook;
    else if (fieldName.equalsIgnoreCase("qtycount"))
      return qtycount;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineInventoryData[] select(ConnectionProvider connectionProvider, String M_Inventory_ID)    throws ServletException {
    return select(connectionProvider, M_Inventory_ID, 0, 0);
  }

  public static DocLineInventoryData[] select(ConnectionProvider connectionProvider, String M_Inventory_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  SELECT IL.AD_ORG_ID, IL.M_PRODUCT_ID, IL.LINE, IL.DESCRIPTION," +
      "	  IL.C_UOM_ID, IL.M_INVENTORYLINE_ID, IL.QTYBOOK, IL.QTYCOUNT," +
      "	  IL.M_LOCATOR_ID FROM M_InventoryLine IL " +
      "	  WHERE M_Inventory_ID=?" +
      "	  AND IL.QTYBOOK<>IL.QTYCOUNT" +
      "	  ORDER BY Line";

    ResultSet result;
    Vector<DocLineInventoryData> vector = new Vector<DocLineInventoryData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Inventory_ID);

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
        DocLineInventoryData objectDocLineInventoryData = new DocLineInventoryData();
        objectDocLineInventoryData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineInventoryData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineInventoryData.line = UtilSql.getValue(result, "line");
        objectDocLineInventoryData.description = UtilSql.getValue(result, "description");
        objectDocLineInventoryData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineInventoryData.mInventorylineId = UtilSql.getValue(result, "m_inventoryline_id");
        objectDocLineInventoryData.qtybook = UtilSql.getValue(result, "qtybook");
        objectDocLineInventoryData.qtycount = UtilSql.getValue(result, "qtycount");
        objectDocLineInventoryData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDocLineInventoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInventoryData);
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
    DocLineInventoryData objectDocLineInventoryData[] = new DocLineInventoryData[vector.size()];
    vector.copyInto(objectDocLineInventoryData);
    return(objectDocLineInventoryData);
  }
}
