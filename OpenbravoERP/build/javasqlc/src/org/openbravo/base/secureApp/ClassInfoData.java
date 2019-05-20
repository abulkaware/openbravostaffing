//Sqlc generated V1.O00-1
package org.openbravo.base.secureApp;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ClassInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ClassInfoData.class);
  private String InitRecordNumber="0";
  public String type;
  public String id;
  public String name;
  public String adModuleId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ClassInfoData[] select(ConnectionProvider connectionProvider, String className)    throws ServletException {
    return select(connectionProvider, className, 0, 0);
  }

  public static ClassInfoData[] select(ConnectionProvider connectionProvider, String className, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mo.action AS TYPE, (CASE mo.action WHEN 'X' THEN mo.ad_form_id" +
      "                                                  WHEN 'P' THEN mo.ad_process_id" +
      "                                                  WHEN 'R' THEN mo.ad_process_id" +
      "                                                  WHEN 'S' THEN mo.ad_reference_id" +
      "                                                  WHEN 'C' THEN mo.ad_callout_id" +
      "                                                  ELSE null END) AS ID," +
      "          m.name AS NAME, /*Name is only maintained for backwards compatibility, now REPORT_TITLE is automatically filled*/" +
      "          COALESCE((CASE mo.action WHEN 'X' THEN f.ad_module_id" +
      "                                   WHEN 'P' THEN p.ad_module_id" +
      "                                   WHEN 'R' THEN p.ad_module_id" +
      "                                   WHEN 'S' THEN r.ad_module_id" +
      "                                   WHEN 'C' THEN c.ad_module_id" +
      "                                   ELSE null END), mo.ad_module_id) AS ad_module_id" +
      "        FROM ad_model_object mo" +
      "             LEFT JOIN ad_menu m ON mo.ad_process_id = m.ad_process_id" +
      "                                    AND mo.action IN ('P', 'R')" +
      "                                    AND m.action IN ('P', 'R')" +
      "             LEFT JOIN ad_form f ON mo.ad_form_id = f.ad_form_id" +
      "             LEFT JOIN ad_process p ON mo.ad_process_id = p.ad_process_id" +
      "             LEFT JOIN ad_reference r ON mo.ad_reference_id = r.ad_reference_id" +
      "             LEFT JOIN ad_callout c ON mo.ad_callout_id = c.ad_callout_id" +
      "        WHERE mo.classname = ?" +
      "          AND mo.isdefault = 'Y'" +
      "          AND mo.isactive = 'Y'";

    ResultSet result;
    Vector<ClassInfoData> vector = new Vector<ClassInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, className);

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
        ClassInfoData objectClassInfoData = new ClassInfoData();
        objectClassInfoData.type = UtilSql.getValue(result, "type");
        objectClassInfoData.id = UtilSql.getValue(result, "id");
        objectClassInfoData.name = UtilSql.getValue(result, "name");
        objectClassInfoData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectClassInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClassInfoData);
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
    ClassInfoData objectClassInfoData[] = new ClassInfoData[vector.size()];
    vector.copyInto(objectClassInfoData);
    return(objectClassInfoData);
  }

  public static ClassInfoData[] set()    throws ServletException {
    ClassInfoData objectClassInfoData[] = new ClassInfoData[1];
    objectClassInfoData[0] = new ClassInfoData();
    objectClassInfoData[0].type = "";
    objectClassInfoData[0].id = "";
    objectClassInfoData[0].name = "";
    objectClassInfoData[0].adModuleId = "";
    return objectClassInfoData;
  }
}
