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

class SLWorkRequirementProcessPlanData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLWorkRequirementProcessPlanData.class);
  private String InitRecordNumber="0";
  public String explodephases;
  public String secondaryunit;
  public String conversionrate;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("explodephases"))
      return explodephases;
    else if (fieldName.equalsIgnoreCase("secondaryunit"))
      return secondaryunit;
    else if (fieldName.equalsIgnoreCase("conversionrate"))
      return conversionrate;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLWorkRequirementProcessPlanData[] select(ConnectionProvider connectionProvider, String maProcessPlanId)    throws ServletException {
    return select(connectionProvider, maProcessPlanId, 0, 0);
  }

  public static SLWorkRequirementProcessPlanData[] select(ConnectionProvider connectionProvider, String maProcessPlanId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT explodephases, secondaryunit, conversionrate" +
      "      FROM MA_ProcessPlan p" +
      "      WHERE p.MA_ProcessPlan_ID = ?";

    ResultSet result;
    Vector<SLWorkRequirementProcessPlanData> vector = new Vector<SLWorkRequirementProcessPlanData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessPlanId);

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
        SLWorkRequirementProcessPlanData objectSLWorkRequirementProcessPlanData = new SLWorkRequirementProcessPlanData();
        objectSLWorkRequirementProcessPlanData.explodephases = UtilSql.getValue(result, "explodephases");
        objectSLWorkRequirementProcessPlanData.secondaryunit = UtilSql.getValue(result, "secondaryunit");
        objectSLWorkRequirementProcessPlanData.conversionrate = UtilSql.getValue(result, "conversionrate");
        objectSLWorkRequirementProcessPlanData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLWorkRequirementProcessPlanData);
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
    SLWorkRequirementProcessPlanData objectSLWorkRequirementProcessPlanData[] = new SLWorkRequirementProcessPlanData[vector.size()];
    vector.copyInto(objectSLWorkRequirementProcessPlanData);
    return(objectSLWorkRequirementProcessPlanData);
  }
}
