//Sqlc generated V1.O00-1
package org.openbravo.userinterface.selector.wad;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;

class WADSelectorData implements FieldProvider {
static Logger log4j = Logger.getLogger(WADSelectorData.class);
  private String InitRecordNumber="0";
  public String obuiselSelectorId;
  public String adColumnId;
  public String tablename;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("obuisel_selector_id") || fieldName.equals("obuiselSelectorId"))
      return obuiselSelectorId;
    else if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equals("tablename"))
      return tablename;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Returns the OBUISEL_SELECTOR for a specific ad_reference_id
 */
  public static WADSelectorData getSelectorID(ConnectionProvider connectionProvider, String reference, String referenceValue)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT S.OBUISEL_SELECTOR_ID, '' AS AD_COLUMN_ID" +
      "      FROM  OBUISEL_SELECTOR S" +
      "      WHERE S.AD_REFERENCE_ID = ? " +
      "         OR S.AD_REFERENCE_ID = ?";

    ResultSet result;
    WADSelectorData objectWADSelectorData = new WADSelectorData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceValue);

      result = st.executeQuery();
      if(result.next()) {
        objectWADSelectorData.obuiselSelectorId = UtilSql.getValue(result, "obuisel_selector_id");
        objectWADSelectorData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectWADSelectorData.tablename = "";
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
    return(objectWADSelectorData);
  }
}
