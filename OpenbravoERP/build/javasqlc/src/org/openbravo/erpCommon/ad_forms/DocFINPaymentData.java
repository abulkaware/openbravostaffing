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

class DocFINPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocFINPaymentData.class);
  private String InitRecordNumber="0";
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocFINPaymentData[] select(ConnectionProvider connectionProvider, String paymentId)    throws ServletException {
    return select(connectionProvider, paymentId, 0, 0);
  }

  public static DocFINPaymentData[] select(ConnectionProvider connectionProvider, String paymentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_costcenter_id,user1_id, user2_id" +
      "        FROM fin_payment" +
      "        WHERE fin_payment_id = ?";

    ResultSet result;
    Vector<DocFINPaymentData> vector = new Vector<DocFINPaymentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentId);

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
        DocFINPaymentData objectDocFINPaymentData = new DocFINPaymentData();
        objectDocFINPaymentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocFINPaymentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocFINPaymentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocFINPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocFINPaymentData);
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
    DocFINPaymentData objectDocFINPaymentData[] = new DocFINPaymentData[vector.size()];
    vector.copyInto(objectDocFINPaymentData);
    return(objectDocFINPaymentData);
  }
}
