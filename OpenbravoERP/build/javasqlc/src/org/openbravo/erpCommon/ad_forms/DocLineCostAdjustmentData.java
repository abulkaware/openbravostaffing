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

class DocLineCostAdjustmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineCostAdjustmentData.class);
  private String InitRecordNumber="0";
  public String mCostadjustmentlineId;
  public String adClientId;
  public String adOrgId;
  public String mCostadjustmentId;
  public String mTransactionId;
  public String adjustmentAmount;
  public String issource;
  public String needsposting;
  public String dateacct;
  public String isrelatedtrxadjusted;
  public String parentCostadjustmentlineId;
  public String mProductId;
  public String mWarehouseId;
  public String cCurrencyId;
  public String sourceProcess;
  public String cBpartnerId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_costadjustmentline_id") || fieldName.equals("mCostadjustmentlineId"))
      return mCostadjustmentlineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_costadjustment_id") || fieldName.equals("mCostadjustmentId"))
      return mCostadjustmentId;
    else if (fieldName.equalsIgnoreCase("m_transaction_id") || fieldName.equals("mTransactionId"))
      return mTransactionId;
    else if (fieldName.equalsIgnoreCase("adjustment_amount") || fieldName.equals("adjustmentAmount"))
      return adjustmentAmount;
    else if (fieldName.equalsIgnoreCase("issource"))
      return issource;
    else if (fieldName.equalsIgnoreCase("needsposting"))
      return needsposting;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("isrelatedtrxadjusted"))
      return isrelatedtrxadjusted;
    else if (fieldName.equalsIgnoreCase("parent_costadjustmentline_id") || fieldName.equals("parentCostadjustmentlineId"))
      return parentCostadjustmentlineId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("source_process") || fieldName.equals("sourceProcess"))
      return sourceProcess;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineCostAdjustmentData[] select(ConnectionProvider connectionProvider, String Cost_Adjustment_ID)    throws ServletException {
    return select(connectionProvider, Cost_Adjustment_ID, 0, 0);
  }

  public static DocLineCostAdjustmentData[] select(ConnectionProvider connectionProvider, String Cost_Adjustment_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CAL.M_COSTADJUSTMENTLINE_ID, CAL.AD_Client_ID, T.AD_Org_ID," +
      "        CAL.M_COSTADJUSTMENT_ID, CAL.M_TRANSACTION_ID, CAL.ADJUSTMENT_AMOUNT, " +
      "        CAL.ISSOURCE, CAL.NEEDSPOSTING, CAL.DATEACCT, CAL.ISRELATEDTRXADJUSTED, CAL.PARENT_COSTADJUSTMENTLINE_ID," +
      "        T.M_PRODUCT_ID, L.M_WAREHOUSE_ID, CAL.C_CURRENCY_ID, CA.SOURCE_PROCESS AS SOURCE_PROCESS, " +
      "        IO.C_BPARTNER_ID AS C_BPARTNER_ID" +
      "        FROM M_COSTADJUSTMENTLINE CAL, M_COSTADJUSTMENT CA, M_LOCATOR L, " +
      "        M_TRANSACTION T LEFT JOIN M_INOUTLINE IOL ON T.M_INOUTLINE_ID = IOL.M_INOUTLINE_ID" +
      "                        LEFT JOIN M_INOUT IO ON IOL.M_INOUT_ID = IO.M_INOUT_ID" +
      "        WHERE CAL.M_COSTADJUSTMENT_ID = CA.M_COSTADJUSTMENT_ID" +
      "        AND CAL.M_TRANSACTION_ID = T.M_TRANSACTION_ID" +
      "        AND T.M_LOCATOR_ID = L.M_LOCATOR_ID" +
      "        AND CAL.M_COSTADJUSTMENT_ID = ?" +
      "        AND CAL.NEEDSPOSTING = 'Y'" +
      "        AND CAL.IsActive='Y'" +
      "        ORDER BY CAL.LINE ASC";

    ResultSet result;
    Vector<DocLineCostAdjustmentData> vector = new Vector<DocLineCostAdjustmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Cost_Adjustment_ID);

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
        DocLineCostAdjustmentData objectDocLineCostAdjustmentData = new DocLineCostAdjustmentData();
        objectDocLineCostAdjustmentData.mCostadjustmentlineId = UtilSql.getValue(result, "m_costadjustmentline_id");
        objectDocLineCostAdjustmentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLineCostAdjustmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineCostAdjustmentData.mCostadjustmentId = UtilSql.getValue(result, "m_costadjustment_id");
        objectDocLineCostAdjustmentData.mTransactionId = UtilSql.getValue(result, "m_transaction_id");
        objectDocLineCostAdjustmentData.adjustmentAmount = UtilSql.getValue(result, "adjustment_amount");
        objectDocLineCostAdjustmentData.issource = UtilSql.getValue(result, "issource");
        objectDocLineCostAdjustmentData.needsposting = UtilSql.getValue(result, "needsposting");
        objectDocLineCostAdjustmentData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocLineCostAdjustmentData.isrelatedtrxadjusted = UtilSql.getValue(result, "isrelatedtrxadjusted");
        objectDocLineCostAdjustmentData.parentCostadjustmentlineId = UtilSql.getValue(result, "parent_costadjustmentline_id");
        objectDocLineCostAdjustmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineCostAdjustmentData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocLineCostAdjustmentData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineCostAdjustmentData.sourceProcess = UtilSql.getValue(result, "source_process");
        objectDocLineCostAdjustmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineCostAdjustmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineCostAdjustmentData);
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
    DocLineCostAdjustmentData objectDocLineCostAdjustmentData[] = new DocLineCostAdjustmentData[vector.size()];
    vector.copyInto(objectDocLineCostAdjustmentData);
    return(objectDocLineCostAdjustmentData);
  }
}
