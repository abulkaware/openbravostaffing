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

class SETaxesActiveData implements FieldProvider {
static Logger log4j = Logger.getLogger(SETaxesActiveData.class);
  private String InitRecordNumber="0";
  public String child;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("child"))
      return child;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SETaxesActiveData[] getActiveChildrenTaxes(ConnectionProvider connectionProvider, String CTaxParentId)    throws ServletException {
    return getActiveChildrenTaxes(connectionProvider, CTaxParentId, 0, 0);
  }

  public static SETaxesActiveData[] getActiveChildrenTaxes(ConnectionProvider connectionProvider, String CTaxParentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TC.C_TAX_ID AS Child" +
      "		FROM C_TAX TP, C_TAX TC" +
      "		WHERE TC.PARENT_TAX_ID = TP.C_TAX_ID" +
      "  		AND TC.ISACTIVE = 'Y'" +
      "  		AND TP.C_TAX_ID = ?";

    ResultSet result;
    Vector<SETaxesActiveData> vector = new Vector<SETaxesActiveData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CTaxParentId);

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
        SETaxesActiveData objectSETaxesActiveData = new SETaxesActiveData();
        objectSETaxesActiveData.child = UtilSql.getValue(result, "child");
        objectSETaxesActiveData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSETaxesActiveData);
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
    SETaxesActiveData objectSETaxesActiveData[] = new SETaxesActiveData[vector.size()];
    vector.copyInto(objectSETaxesActiveData);
    return(objectSETaxesActiveData);
  }
}
