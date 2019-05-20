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

class SLOrderTaxData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLOrderTaxData.class);
  private String InitRecordNumber="0";
  public String billtoId;
  public String dateordered;
  public String cProjectId;
  public String iscashvat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("iscashvat"))
      return iscashvat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLOrderTaxData[] select(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return select(connectionProvider, cOrderId, 0, 0);
  }

  public static SLOrderTaxData[] select(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Order.BillTo_ID, C_Order.DateOrdered, C_Order.C_Project_ID, C_Order.IsCashVat" +
      "      FROM C_Order" +
      "      WHERE C_Order_ID = ?";

    ResultSet result;
    Vector<SLOrderTaxData> vector = new Vector<SLOrderTaxData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
        SLOrderTaxData objectSLOrderTaxData = new SLOrderTaxData();
        objectSLOrderTaxData.billtoId = UtilSql.getValue(result, "billto_id");
        objectSLOrderTaxData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSLOrderTaxData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSLOrderTaxData.iscashvat = UtilSql.getValue(result, "iscashvat");
        objectSLOrderTaxData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderTaxData);
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
    SLOrderTaxData objectSLOrderTaxData[] = new SLOrderTaxData[vector.size()];
    vector.copyInto(objectSLOrderTaxData);
    return(objectSLOrderTaxData);
  }
}
