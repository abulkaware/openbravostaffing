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

class SEOrderProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEOrderProjectData.class);
  private String InitRecordNumber="0";
  public String paymentterm;
  public String paymentrule;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("paymentterm"))
      return paymentterm;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEOrderProjectData[] select(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    return select(connectionProvider, cProjectId, 0, 0);
  }

  public static SEOrderProjectData[] select(ConnectionProvider connectionProvider, String cProjectId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_PAYMENTTERM_ID) AS PAYMENTTERM, MAX(PAYMENTRULE) AS PAYMENTRULE" +
      "        FROM C_PROJECT" +
      "        WHERE C_PROJECT_ID = ?";

    ResultSet result;
    Vector<SEOrderProjectData> vector = new Vector<SEOrderProjectData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
        SEOrderProjectData objectSEOrderProjectData = new SEOrderProjectData();
        objectSEOrderProjectData.paymentterm = UtilSql.getValue(result, "paymentterm");
        objectSEOrderProjectData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectSEOrderProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEOrderProjectData);
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
    SEOrderProjectData objectSEOrderProjectData[] = new SEOrderProjectData[vector.size()];
    vector.copyInto(objectSEOrderProjectData);
    return(objectSEOrderProjectData);
  }
}
