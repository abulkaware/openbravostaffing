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

/**
Clase LocatorComboData
 */
class LocatorComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(LocatorComboData.class);
  private String InitRecordNumber="0";
  public String mLocatorId;
  public String name;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Relación de pasillos de un almacen de la aplicacion
 */
  public static LocatorComboData[] select(ConnectionProvider connectionProvider, String language, String warehouse, String client)    throws ServletException {
    return select(connectionProvider, language, warehouse, client, 0, 0);
  }

/**
Relación de pasillos de un almacen de la aplicacion
 */
  public static LocatorComboData[] select(ConnectionProvider connectionProvider, String language, String warehouse, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT L.M_LOCATOR_ID, AD_COLUMN_IDENTIFIER(TO_CHAR('M_Locator'),TO_CHAR(M_LOCATOR_ID),TO_CHAR(?)) AS NAME, '' AS ID " +
      "            FROM M_LOCATOR L, M_WAREHOUSE W" +
      "			WHERE W.M_WAREHOUSE_ID = L.M_WAREHOUSE_ID" +
      "            AND L.IsActive='Y' " +
      "            AND W.M_WAREHOUSE_ID = ? " +
      "            AND L.AD_Client_ID = ? " +
      "            ORDER BY NAME";

    ResultSet result;
    Vector<LocatorComboData> vector = new Vector<LocatorComboData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        LocatorComboData objectLocatorComboData = new LocatorComboData();
        objectLocatorComboData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectLocatorComboData.name = UtilSql.getValue(result, "name");
        objectLocatorComboData.id = UtilSql.getValue(result, "id");
        objectLocatorComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocatorComboData);
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
    LocatorComboData objectLocatorComboData[] = new LocatorComboData[vector.size()];
    vector.copyInto(objectLocatorComboData);
    return(objectLocatorComboData);
  }
}
