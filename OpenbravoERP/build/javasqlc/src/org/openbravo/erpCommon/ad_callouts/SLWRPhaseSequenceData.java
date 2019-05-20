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

class SLWRPhaseSequenceData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLWRPhaseSequenceData.class);
  private String InitRecordNumber="0";
  public String process;
  public String ccuse;
  public String preptime;
  public String quantity;
  public String outsourced;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("process"))
      return process;
    else if (fieldName.equalsIgnoreCase("ccuse"))
      return ccuse;
    else if (fieldName.equalsIgnoreCase("preptime"))
      return preptime;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("outsourced"))
      return outsourced;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLWRPhaseSequenceData[] select(ConnectionProvider connectionProvider, String maSequenceId)    throws ServletException {
    return select(connectionProvider, maSequenceId, 0, 0);
  }

  public static SLWRPhaseSequenceData[] select(ConnectionProvider connectionProvider, String maSequenceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MA_Process_Id as process, costcenteruse as ccuse, preptime, '' as quantity, COALESCE(Outsourced, 'N') as outsourced" +
      "      FROM MA_Sequence" +
      "      WHERE MA_Sequence_Id = ?";

    ResultSet result;
    Vector<SLWRPhaseSequenceData> vector = new Vector<SLWRPhaseSequenceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);

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
        SLWRPhaseSequenceData objectSLWRPhaseSequenceData = new SLWRPhaseSequenceData();
        objectSLWRPhaseSequenceData.process = UtilSql.getValue(result, "process");
        objectSLWRPhaseSequenceData.ccuse = UtilSql.getValue(result, "ccuse");
        objectSLWRPhaseSequenceData.preptime = UtilSql.getValue(result, "preptime");
        objectSLWRPhaseSequenceData.quantity = UtilSql.getValue(result, "quantity");
        objectSLWRPhaseSequenceData.outsourced = UtilSql.getValue(result, "outsourced");
        objectSLWRPhaseSequenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLWRPhaseSequenceData);
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
    SLWRPhaseSequenceData objectSLWRPhaseSequenceData[] = new SLWRPhaseSequenceData[vector.size()];
    vector.copyInto(objectSLWRPhaseSequenceData);
    return(objectSLWRPhaseSequenceData);
  }

  public static String selectQuantity(ConnectionProvider connectionProvider, String maSequenceId, String maWRequirementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT wr.quantity*s.multiplier AS quantity" +
      "      FROM MA_WorkRequirement wr, MA_Sequence s" +
      "      WHERE s.MA_Sequence_Id = ?" +
      "      AND wr.MA_WorkRequirement_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWRequirementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "quantity");
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
    return(strReturn);
  }
}
