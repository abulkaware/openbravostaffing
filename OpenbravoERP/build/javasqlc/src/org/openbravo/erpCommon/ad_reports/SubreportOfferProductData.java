//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SubreportOfferProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(SubreportOfferProductData.class);
  private String InitRecordNumber="0";
  public String mOfferId;
  public String mProductId;
  public String mProductName;
  public String adClientId;
  public String adOrgId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_name") || fieldName.equals("mProductName"))
      return mProductName;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SubreportOfferProductData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String offer)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, offer, 0, 0);
  }

  public static SubreportOfferProductData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String offer, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_OFFER_ID, M_PRODUCT_ID, M_PRODUCT_NAME," +
      "        AD_CLIENT_ID, AD_ORG_ID" +
      "        FROM (SELECT M_OFFER.M_OFFER_ID, M_PRODUCT.M_PRODUCT_ID," +
      "              M_PRODUCT.NAME AS M_PRODUCT_NAME," +
      "              M_PRODUCT.AD_CLIENT_ID, M_PRODUCT.AD_ORG_ID" +
      "              FROM M_OFFER, M_OFFER_PRODUCT, M_PRODUCT" +
      "              WHERE M_OFFER_PRODUCT.M_OFFER_ID = M_OFFER.M_OFFER_ID" +
      "              AND M_OFFER.PRODUCT_SELECTION = 'N'" +
      "              AND M_OFFER_PRODUCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "              UNION" +
      "              SELECT M_OFFER.M_OFFER_ID, M_PRODUCT.M_PRODUCT_ID," +
      "              M_PRODUCT.NAME AS M_PRODUCT_NAME," +
      "              M_PRODUCT.AD_CLIENT_ID, M_PRODUCT.AD_ORG_ID" +
      "              FROM M_OFFER, M_PRODUCT" +
      "              WHERE M_OFFER.PRODUCT_SELECTION = 'Y'" +
      "              AND M_PRODUCT.M_PRODUCT_ID NOT IN (SELECT M_PRODUCT_ID FROM M_OFFER_PRODUCT WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID)) A" +
      "        WHERE A.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND A.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND M_OFFER_ID = ?" +
      "        ORDER BY M_PRODUCT_NAME";

    ResultSet result;
    Vector<SubreportOfferProductData> vector = new Vector<SubreportOfferProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, offer);

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
        SubreportOfferProductData objectSubreportOfferProductData = new SubreportOfferProductData();
        objectSubreportOfferProductData.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectSubreportOfferProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSubreportOfferProductData.mProductName = UtilSql.getValue(result, "m_product_name");
        objectSubreportOfferProductData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSubreportOfferProductData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSubreportOfferProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSubreportOfferProductData);
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
    SubreportOfferProductData objectSubreportOfferProductData[] = new SubreportOfferProductData[vector.size()];
    vector.copyInto(objectSubreportOfferProductData);
    return(objectSubreportOfferProductData);
  }
}
