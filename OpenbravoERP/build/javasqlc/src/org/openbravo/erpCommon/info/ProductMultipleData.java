//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProductMultipleData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductMultipleData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String mProductId;
  public String discontinued;
  public String value;
  public String name;
  public String nameHidden;
  public String cUomId;
  public String productCategory;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name_hidden") || fieldName.equals("nameHidden"))
      return nameHidden;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("product_category") || fieldName.equals("productCategory"))
      return productCategory;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductMultipleData[] select(ConnectionProvider connectionProvider, String rownum, String key, String name, String productCategory, String isSoTrx, String adUserClient, String adUserOrg, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return select(connectionProvider, rownum, key, name, productCategory, isSoTrx, adUserClient, adUserOrg, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ProductMultipleData[] select(ConnectionProvider connectionProvider, String rownum, String key, String name, String productCategory, String isSoTrx, String adUserClient, String adUserOrg, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (" +
      "        SELECT p.M_Product_ID, p.Discontinued, p.Value, p.Name, REPLACE(p.Name, '''', CHR(92) || '''') AS NAME_HIDDEN, " +
      "        p.C_UOM_ID, pc.name as PRODUCT_CATEGORY, p.M_Product_ID || '@_##_@' || p.Name as RowKey" +
      "        FROM M_Product p, m_product_category pc" +
      "        WHERE ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(p.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(p.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + ((productCategory==null || productCategory.equals(""))?"":"  p.M_Product_Category_ID = ? AND  ");
    strSql = strSql + 
      "p.M_Product_Category_ID = pc.M_Product_Category_ID" +
      "        AND p.IsSummary='N'";
    strSql = strSql + ((isSoTrx==null || isSoTrx.equals(""))?"":"  AND p.issold = ?  ");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "		    ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "		) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") B" +
      "      WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    Vector<ProductMultipleData> vector = new Vector<ProductMultipleData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (productCategory != null && !(productCategory.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, productCategory);
      }
      if (isSoTrx != null && !(isSoTrx.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSoTrx);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
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
        ProductMultipleData objectProductMultipleData = new ProductMultipleData();
        objectProductMultipleData.rn1 = UtilSql.getValue(result, "rn1");
        objectProductMultipleData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductMultipleData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductMultipleData.value = UtilSql.getValue(result, "value");
        objectProductMultipleData.name = UtilSql.getValue(result, "name");
        objectProductMultipleData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectProductMultipleData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductMultipleData.productCategory = UtilSql.getValue(result, "product_category");
        objectProductMultipleData.rowkey = UtilSql.getValue(result, "rowkey");
        objectProductMultipleData.position = Long.toString(countRecord);
        objectProductMultipleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductMultipleData);
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
    ProductMultipleData objectProductMultipleData[] = new ProductMultipleData[vector.size()];
    vector.copyInto(objectProductMultipleData);
    return(objectProductMultipleData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String key, String name, String productCategory, String isSoTrx, String adUserClient, String adUserOrg, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) as value FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM ( " +
      "        SELECT 1 FROM M_Product p, m_product_category pc" +
      "        WHERE ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(p.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(p.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + ((productCategory==null || productCategory.equals(""))?"":"  p.M_Product_Category_ID = ? AND  ");
    strSql = strSql + 
      "p.M_Product_Category_ID = pc.M_Product_Category_ID" +
      "        AND p.IsSummary='N'";
    strSql = strSql + ((isSoTrx==null || isSoTrx.equals(""))?"":"  AND p.issold = ?  ");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        AND p.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND p.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "        ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "        ) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (productCategory != null && !(productCategory.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, productCategory);
      }
      if (isSoTrx != null && !(isSoTrx.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isSoTrx);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
    return(strReturn);
  }
}
