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

class SLCCPMeasureGroupData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLCCPMeasureGroupData.class);
  private String InitRecordNumber="0";
  public String seqno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLCCPMeasureGroupData[] select(ConnectionProvider connectionProvider, String maCCPGroupId)    throws ServletException {
    return select(connectionProvider, maCCPGroupId, 0, 0);
  }

  public static SLCCPMeasureGroupData[] select(ConnectionProvider connectionProvider, String maCCPGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT seqno" +
      "      FROM MA_CCP_Group" +
      "      WHERE MA_CCP_Group_ID = ?";

    ResultSet result;
    Vector<SLCCPMeasureGroupData> vector = new Vector<SLCCPMeasureGroupData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCCPGroupId);

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
        SLCCPMeasureGroupData objectSLCCPMeasureGroupData = new SLCCPMeasureGroupData();
        objectSLCCPMeasureGroupData.seqno = UtilSql.getValue(result, "seqno");
        objectSLCCPMeasureGroupData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLCCPMeasureGroupData);
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
    SLCCPMeasureGroupData objectSLCCPMeasureGroupData[] = new SLCCPMeasureGroupData[vector.size()];
    vector.copyInto(objectSLCCPMeasureGroupData);
    return(objectSLCCPMeasureGroupData);
  }
}
