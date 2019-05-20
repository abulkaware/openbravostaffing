//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SLInventoryLocatorData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLInventoryLocatorData.class);
  private String InitRecordNumber="0";
  public String qtyorder;
  public String qty;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("qtyorder"))
      return qtyorder;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLInventoryLocatorData[] select(ConnectionProvider connectionProvider, String product, String locator, String uom, String mProductUomId, String productuom, String attribute)    throws ServletException {
    return select(connectionProvider, product, locator, uom, mProductUomId, productuom, attribute, 0, 0);
  }

  public static SLInventoryLocatorData[] select(ConnectionProvider connectionProvider, String product, String locator, String uom, String mProductUomId, String productuom, String attribute, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COALESCE(qtyorderonhand,0) AS qtyorder, COALESCE(qtyonhand,0) AS qty" +
      "      FROM M_storage_detail " +
      "      WHERE m_product_id=? AND m_locator_id=? AND c_uom_id=? AND 1=1";
    strSql = strSql + ((mProductUomId==null || mProductUomId.equals(""))?"":"  AND M_PRODUCT_UOM_ID = ? ");
    strSql = strSql + ((productuom.equals("productuom"))?"  AND M_PRODUCT_UOM_ID IS NULL ":"");
    strSql = strSql + 
      " AND m_attributesetinstance_id=?";

    ResultSet result;
    Vector<SLInventoryLocatorData> vector = new Vector<SLInventoryLocatorData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uom);
      if (mProductUomId != null && !(mProductUomId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      }
      if (productuom != null && !(productuom.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, attribute);

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
        SLInventoryLocatorData objectSLInventoryLocatorData = new SLInventoryLocatorData();
        objectSLInventoryLocatorData.qtyorder = UtilSql.getValue(result, "qtyorder");
        objectSLInventoryLocatorData.qty = UtilSql.getValue(result, "qty");
        objectSLInventoryLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLInventoryLocatorData);
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
    SLInventoryLocatorData objectSLInventoryLocatorData[] = new SLInventoryLocatorData[vector.size()];
    vector.copyInto(objectSLInventoryLocatorData);
    return(objectSLInventoryLocatorData);
  }

  public static SLInventoryLocatorData[] set()    throws ServletException {
    SLInventoryLocatorData objectSLInventoryLocatorData[] = new SLInventoryLocatorData[1];
    objectSLInventoryLocatorData[0] = new SLInventoryLocatorData();
    objectSLInventoryLocatorData[0].qtyorder = "";
    objectSLInventoryLocatorData[0].qty = "";
    return objectSLInventoryLocatorData;
  }
}
