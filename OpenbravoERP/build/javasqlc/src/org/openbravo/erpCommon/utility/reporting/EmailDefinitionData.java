//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class EmailDefinitionData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmailDefinitionData.class);
  private String InitRecordNumber="0";
  public String position;
  public String adLanguage;
  public String subject;
  public String body;
  public String isdefault;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("position"))
      return position;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("subject"))
      return subject;
    else if (fieldName.equalsIgnoreCase("body"))
      return body;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EmailDefinitionData[] getEmailDefinitions(ConnectionProvider connectionProvider, String adOrgId, String docTypeTemplateId)    throws ServletException {
    return getEmailDefinitions(connectionProvider, adOrgId, docTypeTemplateId, 0, 0);
  }

  public static EmailDefinitionData[] getEmailDefinitions(ConnectionProvider connectionProvider, String adOrgId, String docTypeTemplateId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "		    '1' as position,		" +
      "			emaildefinitions.ad_language as ad_language," +
      "			emaildefinitions.subject as subject," +
      "			emaildefinitions.body as body," +
      "			emaildefinitions.isdefault as isdefault," +
      "			emaildefinitions.c_poc_emaildefinition_id as id" +
      "		from" +
      "			c_poc_emaildefinition emaildefinitions" +
      "		where" +
      "			ad_isorgincluded(?,emaildefinitions.ad_org_id, emaildefinitions.ad_client_id)<>-1 and" +
      "			emaildefinitions.c_poc_doctype_template_id = ?" +
      "		order by ad_isorgincluded(?,emaildefinitions.ad_org_id, emaildefinitions.ad_client_id) desc";

    ResultSet result;
    Vector<EmailDefinitionData> vector = new Vector<EmailDefinitionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docTypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        EmailDefinitionData objectEmailDefinitionData = new EmailDefinitionData();
        objectEmailDefinitionData.position = UtilSql.getValue(result, "position");
        objectEmailDefinitionData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectEmailDefinitionData.subject = UtilSql.getValue(result, "subject");
        objectEmailDefinitionData.body = UtilSql.getValue(result, "body");
        objectEmailDefinitionData.isdefault = UtilSql.getValue(result, "isdefault");
        objectEmailDefinitionData.id = UtilSql.getValue(result, "id");
        objectEmailDefinitionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailDefinitionData);
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
    EmailDefinitionData objectEmailDefinitionData[] = new EmailDefinitionData[vector.size()];
    vector.copyInto(objectEmailDefinitionData);
    return(objectEmailDefinitionData);
  }
}
