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

class LanguageComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(LanguageComboData.class);
  private String InitRecordNumber="0";
  public String adLanguage;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static LanguageComboData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static LanguageComboData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_LANGUAGE, NAME " +
      "        FROM AD_LANGUAGE " +
      "        WHERE ISACTIVE='Y'" +
      "        AND (ISSYSTEMLANGUAGE = 'Y' " +
      "        OR ISBASELANGUAGE = 'Y')" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<LanguageComboData> vector = new Vector<LanguageComboData>(0);
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
        LanguageComboData objectLanguageComboData = new LanguageComboData();
        objectLanguageComboData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectLanguageComboData.name = UtilSql.getValue(result, "name");
        objectLanguageComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLanguageComboData);
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
    LanguageComboData objectLanguageComboData[] = new LanguageComboData[vector.size()];
    vector.copyInto(objectLanguageComboData);
    return(objectLanguageComboData);
  }
}
