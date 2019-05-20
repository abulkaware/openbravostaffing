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

class DocLineOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineOrderData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String cBpartnerId;
  public String mProductId;
  public String line;
  public String description;
  public String cUomId;
  public String cTaxId;
  public String cChargeId;
  public String chargeamt;
  public String cOrderlineId;
  public String qtyordered;
  public String linenetamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineOrderData[] select(ConnectionProvider connectionProvider, String C_Order_ID)    throws ServletException {
    return select(connectionProvider, C_Order_ID, 0, 0);
  }

  public static DocLineOrderData[] select(ConnectionProvider connectionProvider, String C_Order_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT OL.AD_ORG_ID, OL.C_BPARTNER_ID, OL.M_PRODUCT_ID, OL.LINE, OL.DESCRIPTION," +
      "          OL.C_UOM_ID, OL.C_TAX_ID, OL.C_CHARGE_ID, OL.CHARGEAMT, OL.C_ORDERLINE_ID," +
      "          OL.QTYORDERED, OL.LINENETAMT" +
      "          FROM C_OrderLine OL WHERE C_Order_ID=? ORDER BY Line";

    ResultSet result;
    Vector<DocLineOrderData> vector = new Vector<DocLineOrderData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_ID);

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
        DocLineOrderData objectDocLineOrderData = new DocLineOrderData();
        objectDocLineOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineOrderData.line = UtilSql.getValue(result, "line");
        objectDocLineOrderData.description = UtilSql.getValue(result, "description");
        objectDocLineOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineOrderData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectDocLineOrderData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocLineOrderData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocLineOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectDocLineOrderData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectDocLineOrderData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectDocLineOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineOrderData);
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
    DocLineOrderData objectDocLineOrderData[] = new DocLineOrderData[vector.size()];
    vector.copyInto(objectDocLineOrderData);
    return(objectDocLineOrderData);
  }
}
