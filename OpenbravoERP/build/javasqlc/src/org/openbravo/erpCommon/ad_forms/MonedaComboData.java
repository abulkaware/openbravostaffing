//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class MonedaComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(MonedaComboData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static MonedaComboData[] selectISO(ConnectionProvider connectionProvider)    throws ServletException {
    return selectISO(connectionProvider, 0, 0);
  }

  public static MonedaComboData[] selectISO(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency_ID as id, iso_code as name" +
      "      FROM C_Currency ORDER BY 2";

    ResultSet result;
    Vector<MonedaComboData> vector = new Vector<MonedaComboData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        MonedaComboData objectMonedaComboData = new MonedaComboData();
        objectMonedaComboData.id = UtilSql.getValue(result, "id");
        objectMonedaComboData.name = UtilSql.getValue(result, "name");
        objectMonedaComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMonedaComboData);
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
    MonedaComboData objectMonedaComboData[] = new MonedaComboData[vector.size()];
    vector.copyInto(objectMonedaComboData);
    return(objectMonedaComboData);
  }
}
