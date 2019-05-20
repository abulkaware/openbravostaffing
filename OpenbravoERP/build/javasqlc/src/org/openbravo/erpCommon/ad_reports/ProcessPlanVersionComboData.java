//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProcessPlanVersionComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessPlanVersionComboData.class);
  private String InitRecordNumber="0";
  public String padre;
  public String name;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProcessPlanVersionComboData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, 0, 0);
  }

  public static ProcessPlanVersionComboData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT pv.MA_ProcessPlan_ID AS PADRE, p.NAME || ' - ' || pv.DOCUMENTNO AS NAME,  pv.MA_ProcessPlan_Version_ID AS ID " +
      "       FROM MA_ProcessPlan p, MA_ProcessPlan_Version pv" +
      "       WHERE p.ISACTIVE = 'Y'" +
      "        AND PV.MA_PROCESSPLAN_ID=P.MA_PROCESSPLAN_ID" +
      "        AND p.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND p.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "       ORDER BY NAME";

    ResultSet result;
    Vector<ProcessPlanVersionComboData> vector = new Vector<ProcessPlanVersionComboData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }

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
        ProcessPlanVersionComboData objectProcessPlanVersionComboData = new ProcessPlanVersionComboData();
        objectProcessPlanVersionComboData.padre = UtilSql.getValue(result, "padre");
        objectProcessPlanVersionComboData.name = UtilSql.getValue(result, "name");
        objectProcessPlanVersionComboData.id = UtilSql.getValue(result, "id");
        objectProcessPlanVersionComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProcessPlanVersionComboData);
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
    ProcessPlanVersionComboData objectProcessPlanVersionComboData[] = new ProcessPlanVersionComboData[vector.size()];
    vector.copyInto(objectProcessPlanVersionComboData);
    return(objectProcessPlanVersionComboData);
  }
}
