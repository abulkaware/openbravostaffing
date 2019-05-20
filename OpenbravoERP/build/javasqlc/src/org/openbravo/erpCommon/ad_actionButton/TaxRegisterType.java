//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class TaxRegisterType implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxRegisterType.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cTaxregisterTypeId;
  public String registername;
  public String adSequenceId;
  public String cGlitemId;
  public String issotrx;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_taxregister_type_id") || fieldName.equals("cTaxregisterTypeId"))
      return cTaxregisterTypeId;
    else if (fieldName.equalsIgnoreCase("registername"))
      return registername;
    else if (fieldName.equalsIgnoreCase("ad_sequence_id") || fieldName.equals("adSequenceId"))
      return adSequenceId;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
All Active Tax Register Type  
 */
  public static TaxRegisterType[] select(ConnectionProvider connectionProvider, String adClientId, String adUserOrg)    throws ServletException {
    return select(connectionProvider, adClientId, adUserOrg, 0, 0);
  }

/**
All Active Tax Register Type  
 */
  public static TaxRegisterType[] select(ConnectionProvider connectionProvider, String adClientId, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Client_ID, AD_Org_ID, C_TaxRegister_Type_ID, RegisterName, Ad_Sequence_ID, C_GLitem_ID, IsSoTrx" +
      "			FROM C_TAXREGISTER_TYPE" +
      "			WHERE ISACTIVE='Y'" +
      "      AND AD_CLIENT_ID = ?" +
      "      AND C_TAXREGISTER_TYPE.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<TaxRegisterType> vector = new Vector<TaxRegisterType>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        TaxRegisterType objectTaxRegisterType = new TaxRegisterType();
        objectTaxRegisterType.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxRegisterType.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxRegisterType.cTaxregisterTypeId = UtilSql.getValue(result, "c_taxregister_type_id");
        objectTaxRegisterType.registername = UtilSql.getValue(result, "registername");
        objectTaxRegisterType.adSequenceId = UtilSql.getValue(result, "ad_sequence_id");
        objectTaxRegisterType.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectTaxRegisterType.issotrx = UtilSql.getValue(result, "issotrx");
        objectTaxRegisterType.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxRegisterType);
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
    TaxRegisterType objectTaxRegisterType[] = new TaxRegisterType[vector.size()];
    vector.copyInto(objectTaxRegisterType);
    return(objectTaxRegisterType);
  }
}
