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

class RptMACCPGroupData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptMACCPGroupData.class);
  private String InitRecordNumber="0";
  public String punto;
  public String frecuency;
  public String grupo;
  public String valuenumber;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("punto"))
      return punto;
    else if (fieldName.equalsIgnoreCase("frecuency"))
      return frecuency;
    else if (fieldName.equalsIgnoreCase("grupo"))
      return grupo;
    else if (fieldName.equalsIgnoreCase("valuenumber"))
      return valuenumber;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptMACCPGroupData[] select(ConnectionProvider connectionProvider, String maCcpGroupId)    throws ServletException {
    return select(connectionProvider, maCcpGroupId, 0, 0);
  }

  public static RptMACCPGroupData[] select(ConnectionProvider connectionProvider, String maCcpGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c.name || (CASE c.CRITICAL WHEN 'Y' THEN ' (PC)' ELSE '' END) AS punto, TO_CHAR(g.frecuency, 'HH:MI') as frecuency, g.name AS grupo, c.valuenumber" +
      "        FROM MA_CCP_Group g, MA_CCP c" +
      "        WHERE g.MA_CCP_Group_ID = c.MA_CCP_Group_ID" +
      "        AND 1=1";
    strSql = strSql + ((maCcpGroupId==null || maCcpGroupId.equals(""))?"":"         AND g.MA_CCP_Group_ID IN        " + maCcpGroupId);
    strSql = strSql + 
      "        ORDER BY g.seqno ASC, c.seqno ASC";

    ResultSet result;
    Vector<RptMACCPGroupData> vector = new Vector<RptMACCPGroupData>(0);
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
        RptMACCPGroupData objectRptMACCPGroupData = new RptMACCPGroupData();
        objectRptMACCPGroupData.punto = UtilSql.getValue(result, "punto");
        objectRptMACCPGroupData.frecuency = UtilSql.getValue(result, "frecuency");
        objectRptMACCPGroupData.grupo = UtilSql.getValue(result, "grupo");
        objectRptMACCPGroupData.valuenumber = UtilSql.getValue(result, "valuenumber");
        objectRptMACCPGroupData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptMACCPGroupData);
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
    RptMACCPGroupData objectRptMACCPGroupData[] = new RptMACCPGroupData[vector.size()];
    vector.copyInto(objectRptMACCPGroupData);
    return(objectRptMACCPGroupData);
  }

  public static RptMACCPGroupData[] set()    throws ServletException {
    RptMACCPGroupData objectRptMACCPGroupData[] = new RptMACCPGroupData[1];
    objectRptMACCPGroupData[0] = new RptMACCPGroupData();
    objectRptMACCPGroupData[0].punto = "";
    objectRptMACCPGroupData[0].frecuency = "";
    objectRptMACCPGroupData[0].grupo = "";
    objectRptMACCPGroupData[0].valuenumber = "";
    return objectRptMACCPGroupData;
  }
}
