//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptMACCPMeasuresValuesData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptMACCPMeasuresValuesData.class);
  private String InitRecordNumber="0";
  public String measurehour;
  public String name;
  public String value;
  public String identific;
  public String seqno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("measurehour"))
      return measurehour;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("identific"))
      return identific;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptMACCPMeasuresValuesData[] select(ConnectionProvider connectionProvider, String maMeasureGroupId)    throws ServletException {
    return select(connectionProvider, maMeasureGroupId, 0, 0);
  }

  public static RptMACCPMeasuresValuesData[] select(ConnectionProvider connectionProvider, String maMeasureGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select measurehour, name, max(value) as value, identific, seqno" +
      "        from (" +
      "            select t.MEASUREHOUR, v.seqno, c.name || (CASE c.CRITICAL WHEN 'Y' THEN ' (PC)' ELSE '' END) AS name, COALESCE((CASE v.VALUETYPE WHEN 'N' THEN TO_CHAR(v_number) ELSE " +
      "                (CASE v.VALUETYPE WHEN 'C' THEN TO_CHAR(v_char) ELSE TO_CHAR(v_string) END) END),' ') AS value, 0 as identific" +
      "            from MA_MEASURE_TIME t, MA_MEASURE_VALUES v, MA_CCP c" +
      "            where t.MA_MEASURE_TIME_ID = v.MA_MEASURE_TIME_ID" +
      "              and v.MA_CCP_ID = c.MA_CCP_ID " +
      "              and t.MA_MEASURE_GROUP_ID = ?" +
      "            union all" +
      "              select to_date('31/12/9999', 'DD/MM/YYYY'), v.seqno, c.name || (CASE c.CRITICAL WHEN 'Y' THEN ' (PC)' ELSE '' END) AS name, ' ' as value, identific" +
      "              from ma_measure_time t, ma_measure_values v, ma_ccp c, " +
      "                (select VALUE-1 as identific from ad_INTEGER " +
      "                 where VALUE<=(" +
      "                   select 10-count(*) from MA_Measure_time" +
      "                   where ma_measure_group_id=?)) AAA" +
      "              where t.ma_measure_group_id = ?" +
      "                and t.MA_MEASURE_TIME_ID = v.MA_MEASURE_TIME_ID" +
      "                and v.MA_CCP_ID = c.MA_CCP_ID" +
      "        ) AA" +
      "        group by  seqno,measurehour,  name, identific" +
      "        order by seqno, name, measurehour";

    ResultSet result;
    Vector<RptMACCPMeasuresValuesData> vector = new Vector<RptMACCPMeasuresValuesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
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
        RptMACCPMeasuresValuesData objectRptMACCPMeasuresValuesData = new RptMACCPMeasuresValuesData();
        objectRptMACCPMeasuresValuesData.measurehour = UtilSql.getDateValue(result, "measurehour", "dd-MM-yyyy");
        objectRptMACCPMeasuresValuesData.name = UtilSql.getValue(result, "name");
        objectRptMACCPMeasuresValuesData.value = UtilSql.getValue(result, "value");
        objectRptMACCPMeasuresValuesData.identific = UtilSql.getValue(result, "identific");
        objectRptMACCPMeasuresValuesData.seqno = UtilSql.getValue(result, "seqno");
        objectRptMACCPMeasuresValuesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptMACCPMeasuresValuesData);
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
    RptMACCPMeasuresValuesData objectRptMACCPMeasuresValuesData[] = new RptMACCPMeasuresValuesData[vector.size()];
    vector.copyInto(objectRptMACCPMeasuresValuesData);
    return(objectRptMACCPMeasuresValuesData);
  }
}
