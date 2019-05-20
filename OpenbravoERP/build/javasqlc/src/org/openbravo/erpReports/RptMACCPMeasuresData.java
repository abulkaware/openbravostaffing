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

class RptMACCPMeasuresData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptMACCPMeasuresData.class);
  private String InitRecordNumber="0";
  public String measuredate;
  public String frecuency;
  public String shiftid;
  public String groupid;
  public String maCcpGroupId;
  public String grupo;
  public String shift;
  public String seqno;
  public String observation;
  public String uname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("measuredate"))
      return measuredate;
    else if (fieldName.equalsIgnoreCase("frecuency"))
      return frecuency;
    else if (fieldName.equalsIgnoreCase("shiftid"))
      return shiftid;
    else if (fieldName.equalsIgnoreCase("groupid"))
      return groupid;
    else if (fieldName.equalsIgnoreCase("ma_ccp_group_id") || fieldName.equals("maCcpGroupId"))
      return maCcpGroupId;
    else if (fieldName.equalsIgnoreCase("grupo"))
      return grupo;
    else if (fieldName.equalsIgnoreCase("shift"))
      return shift;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("observation"))
      return observation;
    else if (fieldName.equalsIgnoreCase("uname"))
      return uname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptMACCPMeasuresData[] select(ConnectionProvider connectionProvider, String maCcpGroupId)    throws ServletException {
    return select(connectionProvider, maCcpGroupId, 0, 0);
  }

  public static RptMACCPMeasuresData[] select(ConnectionProvider connectionProvider, String maCcpGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select s.Measuredate as measuredate, TO_CHAR(cg.frecuency, 'HH:MI') as frecuency, s.MA_MEASURE_SHIFT_ID as shiftid, g.MA_MEASURE_GROUP_ID as groupid, g.MA_CCP_GROUP_ID, cg.NAME as grupo, (CASE s.shift WHEN 'M' THEN 'Mañana' ELSE 'Tarde' END) as shift, cg.seqno, REPLACE(s.observation, CHR(10), '') AS observation, (CASE WHEN s.AD_User_ID IS NULL THEN ' ' ELSE TO_CHAR(u.Name) END) as uname" +
      "        from AD_User u right join MA_Measure_Shift s on u.AD_User_ID  = s.AD_User_ID, MA_Measure_Group g, MA_CCP_Group cg" +
      "        where s.MA_MEASURE_SHIFT_ID = g.MA_MEASURE_SHIFT_ID" +
      "          and g.MA_CCP_GROUP_ID = cg.MA_CCP_GROUP_ID" +
      "          AND 1=1";
    strSql = strSql + ((maCcpGroupId==null || maCcpGroupId.equals(""))?"":"         AND s.MA_Measure_Shift_ID IN        " + maCcpGroupId);
    strSql = strSql + 
      "        order by s.MA_Measure_Shift_ID, cg.seqno";

    ResultSet result;
    Vector<RptMACCPMeasuresData> vector = new Vector<RptMACCPMeasuresData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (maCcpGroupId != null && !(maCcpGroupId.equals(""))) {
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
        RptMACCPMeasuresData objectRptMACCPMeasuresData = new RptMACCPMeasuresData();
        objectRptMACCPMeasuresData.measuredate = UtilSql.getDateValue(result, "measuredate", "dd-MM-yyyy");
        objectRptMACCPMeasuresData.frecuency = UtilSql.getValue(result, "frecuency");
        objectRptMACCPMeasuresData.shiftid = UtilSql.getValue(result, "shiftid");
        objectRptMACCPMeasuresData.groupid = UtilSql.getValue(result, "groupid");
        objectRptMACCPMeasuresData.maCcpGroupId = UtilSql.getValue(result, "ma_ccp_group_id");
        objectRptMACCPMeasuresData.grupo = UtilSql.getValue(result, "grupo");
        objectRptMACCPMeasuresData.shift = UtilSql.getValue(result, "shift");
        objectRptMACCPMeasuresData.seqno = UtilSql.getValue(result, "seqno");
        objectRptMACCPMeasuresData.observation = UtilSql.getValue(result, "observation");
        objectRptMACCPMeasuresData.uname = UtilSql.getValue(result, "uname");
        objectRptMACCPMeasuresData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptMACCPMeasuresData);
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
    RptMACCPMeasuresData objectRptMACCPMeasuresData[] = new RptMACCPMeasuresData[vector.size()];
    vector.copyInto(objectRptMACCPMeasuresData);
    return(objectRptMACCPMeasuresData);
  }

  public static RptMACCPMeasuresData[] set()    throws ServletException {
    RptMACCPMeasuresData objectRptMACCPMeasuresData[] = new RptMACCPMeasuresData[1];
    objectRptMACCPMeasuresData[0] = new RptMACCPMeasuresData();
    objectRptMACCPMeasuresData[0].measuredate = "";
    objectRptMACCPMeasuresData[0].frecuency = "";
    objectRptMACCPMeasuresData[0].shiftid = "";
    objectRptMACCPMeasuresData[0].groupid = "";
    objectRptMACCPMeasuresData[0].maCcpGroupId = "";
    objectRptMACCPMeasuresData[0].grupo = "";
    objectRptMACCPMeasuresData[0].shift = "";
    objectRptMACCPMeasuresData[0].seqno = "";
    objectRptMACCPMeasuresData[0].observation = "";
    objectRptMACCPMeasuresData[0].uname = "";
    return objectRptMACCPMeasuresData;
  }
}
