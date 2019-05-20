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

class DocLineProductionData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineProductionData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String mProductionlineId;
  public String mProductId;
  public String movementqty;
  public String productiontype;
  public String mLocatorId;
  public String mWarehouseId;
  public String cUomId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_productionline_id") || fieldName.equals("mProductionlineId"))
      return mProductionlineId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("productiontype"))
      return productiontype;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineProductionData[] select(ConnectionProvider connectionProvider, String mProductionId)    throws ServletException {
    return select(connectionProvider, mProductionId, 0, 0);
  }

  public static DocLineProductionData[] select(ConnectionProvider connectionProvider, String mProductionId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT PL.AD_ORG_ID, PL.M_PRODUCTIONLINE_ID, PL.M_PRODUCT_ID, PL.MOVEMENTQTY, PL.PRODUCTIONTYPE, PL.M_LOCATOR_ID, W.M_WAREHOUSE_ID, PL.C_UOM_ID" +
      "         FROM M_PRODUCTIONLINE PL, M_PRODUCTIONPLAN PP, M_LOCATOR L, M_WAREHOUSE W" +
      "         WHERE PL.M_PRODUCTIONPLAN_ID = PP.M_PRODUCTIONPLAN_ID" +
      "         AND PL.M_LOCATOR_ID = L.M_LOCATOR_ID" +
      "         AND PL.MOVEMENTQTY <> 0" +
      "         AND L.M_WAREHOUSE_ID= W.M_WAREHOUSE_ID" +
      "         AND PP.M_PRODUCTION_ID = ?" +
      "         ORDER BY PL.LINE, PL.M_PRODUCTIONLINE_ID";

    ResultSet result;
    Vector<DocLineProductionData> vector = new Vector<DocLineProductionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionId);

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
        DocLineProductionData objectDocLineProductionData = new DocLineProductionData();
        objectDocLineProductionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineProductionData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectDocLineProductionData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineProductionData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocLineProductionData.productiontype = UtilSql.getValue(result, "productiontype");
        objectDocLineProductionData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDocLineProductionData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocLineProductionData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineProductionData);
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
    DocLineProductionData objectDocLineProductionData[] = new DocLineProductionData[vector.size()];
    vector.copyInto(objectDocLineProductionData);
    return(objectDocLineProductionData);
  }
}
