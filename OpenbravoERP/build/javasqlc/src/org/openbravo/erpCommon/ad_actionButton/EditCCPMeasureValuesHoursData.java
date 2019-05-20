//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class EditCCPMeasureValuesHoursData implements FieldProvider {
static Logger log4j = Logger.getLogger(EditCCPMeasureValuesHoursData.class);
  private String InitRecordNumber="0";
  public String hour;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("hour"))
      return hour;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EditCCPMeasureValuesHoursData[] select(ConnectionProvider connectionProvider, String maMeasureGroupId)    throws ServletException {
    return select(connectionProvider, maMeasureGroupId, 0, 0);
  }

  public static EditCCPMeasureValuesHoursData[] select(ConnectionProvider connectionProvider, String maMeasureGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select hour" +
      "        from (" +
      "        select TO_CHAR(MEASUREHOUR, 'HH24:MI') as hour" +
      "                from MA_MEASURE_TIME" +
      "                where MA_Measure_Group_ID = ?" +
      "            union all" +
      "            select null as hour" +
      "            from ad_integer" +
      "            where value <= (select 10-count(*) from MA_Measure_time" +
      "                   where ma_measure_group_id=?)" +
      "            ORDER BY hour) A";

    ResultSet result;
    Vector<EditCCPMeasureValuesHoursData> vector = new Vector<EditCCPMeasureValuesHoursData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);

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
        EditCCPMeasureValuesHoursData objectEditCCPMeasureValuesHoursData = new EditCCPMeasureValuesHoursData();
        objectEditCCPMeasureValuesHoursData.hour = UtilSql.getValue(result, "hour");
        objectEditCCPMeasureValuesHoursData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEditCCPMeasureValuesHoursData);
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
    EditCCPMeasureValuesHoursData objectEditCCPMeasureValuesHoursData[] = new EditCCPMeasureValuesHoursData[vector.size()];
    vector.copyInto(objectEditCCPMeasureValuesHoursData);
    return(objectEditCCPMeasureValuesHoursData);
  }
}
