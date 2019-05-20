//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DynamicJSData implements FieldProvider {
static Logger log4j = Logger.getLogger(DynamicJSData.class);
  private String InitRecordNumber="0";
  public String value;
  public String msgtext;
  public String msgtype;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("msgtext"))
      return msgtext;
    else if (fieldName.equalsIgnoreCase("msgtype"))
      return msgtype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DynamicJSData[] select(ConnectionProvider connectionProvider, String adLanguage)    throws ServletException {
    return select(connectionProvider, adLanguage, 0, 0);
  }

  public static DynamicJSData[] select(ConnectionProvider connectionProvider, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE, COALESCE(mt.MSGTEXT, m.MSGTEXT) AS MSGTEXT, m.MSGTYPE " +
      "      FROM AD_Message m left join ad_message_trl mt on m.ad_message_id = mt.ad_message_id " +
      "                              and mt.ad_language = ? " +
      "      WHERE (m.msgtype = 'C' OR UPPER(m.value) in ('JSINVALID', 'JSMISSING', 'JSRANGE', 'GRIDPREVIOUSPAGE', 'GRIDNEXTPAGE'))" +
      "      ORDER BY VALUE";

    ResultSet result;
    Vector<DynamicJSData> vector = new Vector<DynamicJSData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);

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
        DynamicJSData objectDynamicJSData = new DynamicJSData();
        objectDynamicJSData.value = UtilSql.getValue(result, "value");
        objectDynamicJSData.msgtext = UtilSql.getValue(result, "msgtext");
        objectDynamicJSData.msgtype = UtilSql.getValue(result, "msgtype");
        objectDynamicJSData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDynamicJSData);
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
    DynamicJSData objectDynamicJSData[] = new DynamicJSData[vector.size()];
    vector.copyInto(objectDynamicJSData);
    return(objectDynamicJSData);
  }
}
