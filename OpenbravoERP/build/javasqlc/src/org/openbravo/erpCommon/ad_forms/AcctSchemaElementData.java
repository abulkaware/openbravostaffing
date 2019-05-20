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

class AcctSchemaElementData implements FieldProvider {
static Logger log4j = Logger.getLogger(AcctSchemaElementData.class);
  private String InitRecordNumber="0";
  public String cAcctschemaElementId;
  public String seqno;
  public String name;
  public String elementtype;
  public String cElementId;
  public String ismandatory;
  public String isbalanced;
  public String orgId;
  public String cElementvalueId;
  public String cBpartnerId;
  public String mProductId;
  public String cActivityId;
  public String cLocationId;
  public String cCampaignId;
  public String cProjectId;
  public String cSalesregionId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_acctschema_element_id") || fieldName.equals("cAcctschemaElementId"))
      return cAcctschemaElementId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("elementtype"))
      return elementtype;
    else if (fieldName.equalsIgnoreCase("c_element_id") || fieldName.equals("cElementId"))
      return cElementId;
    else if (fieldName.equalsIgnoreCase("ismandatory"))
      return ismandatory;
    else if (fieldName.equalsIgnoreCase("isbalanced"))
      return isbalanced;
    else if (fieldName.equalsIgnoreCase("org_id") || fieldName.equals("orgId"))
      return orgId;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AcctSchemaElementData[] select(ConnectionProvider connectionProvider, String C_AcctSchema_ID)    throws ServletException {
    return select(connectionProvider, C_AcctSchema_ID, 0, 0);
  }

  public static AcctSchemaElementData[] select(ConnectionProvider connectionProvider, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_AcctSchema_Element_ID,SeqNo,Name,ElementType,C_Element_ID,IsMandatory,IsBalanced, " +
      "      Org_ID,C_ElementValue_ID,C_BPartner_ID,M_Product_ID,C_Activity_ID,C_Location_ID," +
      "      C_Campaign_ID,C_Project_ID,C_SalesRegion_ID " +
      "      FROM C_AcctSchema_Element " +
      "      WHERE C_AcctSchema_ID=? " +
      "      AND IsActive='Y' " +
      "      ORDER BY SeqNo";

    ResultSet result;
    Vector<AcctSchemaElementData> vector = new Vector<AcctSchemaElementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        AcctSchemaElementData objectAcctSchemaElementData = new AcctSchemaElementData();
        objectAcctSchemaElementData.cAcctschemaElementId = UtilSql.getValue(result, "c_acctschema_element_id");
        objectAcctSchemaElementData.seqno = UtilSql.getValue(result, "seqno");
        objectAcctSchemaElementData.name = UtilSql.getValue(result, "name");
        objectAcctSchemaElementData.elementtype = UtilSql.getValue(result, "elementtype");
        objectAcctSchemaElementData.cElementId = UtilSql.getValue(result, "c_element_id");
        objectAcctSchemaElementData.ismandatory = UtilSql.getValue(result, "ismandatory");
        objectAcctSchemaElementData.isbalanced = UtilSql.getValue(result, "isbalanced");
        objectAcctSchemaElementData.orgId = UtilSql.getValue(result, "org_id");
        objectAcctSchemaElementData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectAcctSchemaElementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectAcctSchemaElementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAcctSchemaElementData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectAcctSchemaElementData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectAcctSchemaElementData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectAcctSchemaElementData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAcctSchemaElementData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectAcctSchemaElementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAcctSchemaElementData);
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
    AcctSchemaElementData objectAcctSchemaElementData[] = new AcctSchemaElementData[vector.size()];
    vector.copyInto(objectAcctSchemaElementData);
    return(objectAcctSchemaElementData);
  }
}
