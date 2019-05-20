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

class ProductCompleteData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductCompleteData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String mProductId;
  public String discontinued;
  public String value;
  public String name;
  public String nameHidden;
  public String qty;
  public String qtyorder;
  public String attribute;
  public String whName;
  public String locValue;
  public String x;
  public String y;
  public String z;
  public String mAttributesetinstanceId;
  public String mLocatorId;
  public String cUom1Id;
  public String cUom2Id;
  public String preqtyonhand;
  public String preqtyorderonhand;
  public String locator;
  public String cUom1;
  public String cUom2;
  public String qtyRef;
  public String quantityorderRef;
  public String servidoBinary;
  public String position;
  public String rowkey;

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
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("qtyorder"))
      return qtyorder;
    else if (fieldName.equalsIgnoreCase("attribute"))
      return attribute;
    else if (fieldName.equalsIgnoreCase("wh_name") || fieldName.equals("whName"))
      return whName;
    else if (fieldName.equalsIgnoreCase("loc_value") || fieldName.equals("locValue"))
      return locValue;
    else if (fieldName.equalsIgnoreCase("x"))
      return x;
    else if (fieldName.equalsIgnoreCase("y"))
      return y;
    else if (fieldName.equalsIgnoreCase("z"))
      return z;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("c_uom1_id") || fieldName.equals("cUom1Id"))
      return cUom1Id;
    else if (fieldName.equalsIgnoreCase("c_uom2_id") || fieldName.equals("cUom2Id"))
      return cUom2Id;
    else if (fieldName.equalsIgnoreCase("preqtyonhand"))
      return preqtyonhand;
    else if (fieldName.equalsIgnoreCase("preqtyorderonhand"))
      return preqtyorderonhand;
    else if (fieldName.equalsIgnoreCase("locator"))
      return locator;
    else if (fieldName.equalsIgnoreCase("c_uom1") || fieldName.equals("cUom1"))
      return cUom1;
    else if (fieldName.equalsIgnoreCase("c_uom2") || fieldName.equals("cUom2"))
      return cUom2;
    else if (fieldName.equalsIgnoreCase("qty_ref") || fieldName.equals("qtyRef"))
      return qtyRef;
    else if (fieldName.equalsIgnoreCase("quantityorder_ref") || fieldName.equals("quantityorderRef"))
      return quantityorderRef;
    else if (fieldName.equalsIgnoreCase("servido_binary") || fieldName.equals("servidoBinary"))
      return servidoBinary;
    else if (fieldName.equals("position"))
      return position;
    else if (fieldName.equals("rowkey"))
      return rowkey;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductCompleteData[] select(ConnectionProvider connectionProvider, String rownum, String key, String name, String warehouse, String production, String adRoleId, String cBpartnerId, String adUserClient, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return select(connectionProvider, rownum, key, name, warehouse, production, adRoleId, cBpartnerId, adUserClient, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ProductCompleteData[] select(ConnectionProvider connectionProvider, String rownum, String key, String name, String warehouse, String production, String adRoleId, String cBpartnerId, String adUserClient, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.*," +
      "        (wh_name || ' - ' || loc_value || '-' || X || '-' || Y || '-' || Z) AS LOCATOR," +
      "        (SELECT U1.NAME FROM C_UOM U1 WHERE U1.C_UOM_ID = C_UOM1_ID) AS C_UOM1," +
      "        (SELECT U2.NAME FROM C_UOM U2, M_PRODUCT_UOM PU WHERE U2.C_UOM_ID = PU.C_UOM_ID AND PU.M_PRODUCT_UOM_ID = C_UOM2_ID) AS C_UOM2," +
      "        COALESCE(PREQTYONHAND, 0) AS QTY_REF, " +
      "        COALESCE(PREQTYORDERONHAND, 0) AS QUANTITYORDER_REF," +
      "        null as servido_binary " +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (      				   " +
      "        SELECT T.M_PRODUCT_ID, P.DISCONTINUED, P.VALUE, P.NAME, P.NAME AS NAME_HIDDEN, " +
      "        T.QtyOnHand AS QTY, COALESCE(T.QtyOrderOnHand, 0) AS QTYORDER, " +
      "        A.DESCRIPTION AS ATTRIBUTE," +
      "		w.name as wh_name, L.value as loc_value, L.X, L.Y, L.z," +
      "        T.M_ATTRIBUTESETINSTANCE_ID, T.M_LOCATOR_ID, " +
      "        T.C_UOM_ID AS C_UOM1_ID, T.M_PRODUCT_UOM_ID AS C_UOM2_ID," +
      "        T.PREQTYONHAND, T.PREQTYORDERONHAND" +
      "        FROM M_STORAGE_DETAIL T" +
      "          left join  M_ATTRIBUTESETINSTANCE A on T.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID," +
      "          M_PRODUCT P," +
      "          M_LOCATOR L, M_Warehouse W, AD_ORG O, AD_ROLE_ORGACCESS RO" +
      "        WHERE T.M_PRODUCT_ID = P.M_PRODUCT_ID ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND W.M_Warehouse_ID = ?  ");
    strSql = strSql + 
      "        AND W.M_WAREHOUSE_ID = L.M_WAREHOUSE_ID " +
      "        AND T.M_LOCATOR_ID = L.M_LOCATOR_ID " +
      "        AND W.AD_ORG_ID = O.AD_ORG_ID " +
      "        AND O.AD_ORG_ID = RO.AD_ORG_ID " +
      "        AND W.ISACTIVE = 'Y' " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((production.equals("production"))?"  AND P.production = 'Y'  ":"");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        AND RO.AD_ROLE_ID = ? " +
      "        AND (P.C_BPARTNER_ID IS NULL OR C_BPARTNER_ID = COALESCE(?, C_BPARTNER_ID)) " +
      "        AND W.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND (T.QtyOnHand <> 0 OR COALESCE(T.QtyOrderOnHand, 0) <> 0) " +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "        ) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    Vector<ProductCompleteData> vector = new Vector<ProductCompleteData>(0);
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
      if (warehouse != null && !(warehouse.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (production != null && !(production.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        ProductCompleteData objectProductCompleteData = new ProductCompleteData();
        objectProductCompleteData.rn1 = UtilSql.getValue(result, "rn1");
        objectProductCompleteData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductCompleteData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductCompleteData.value = UtilSql.getValue(result, "value");
        objectProductCompleteData.name = UtilSql.getValue(result, "name");
        objectProductCompleteData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectProductCompleteData.qty = UtilSql.getValue(result, "qty");
        objectProductCompleteData.qtyorder = UtilSql.getValue(result, "qtyorder");
        objectProductCompleteData.attribute = UtilSql.getValue(result, "attribute");
        objectProductCompleteData.whName = UtilSql.getValue(result, "wh_name");
        objectProductCompleteData.locValue = UtilSql.getValue(result, "loc_value");
        objectProductCompleteData.x = UtilSql.getValue(result, "x");
        objectProductCompleteData.y = UtilSql.getValue(result, "y");
        objectProductCompleteData.z = UtilSql.getValue(result, "z");
        objectProductCompleteData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductCompleteData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductCompleteData.cUom1Id = UtilSql.getValue(result, "c_uom1_id");
        objectProductCompleteData.cUom2Id = UtilSql.getValue(result, "c_uom2_id");
        objectProductCompleteData.preqtyonhand = UtilSql.getValue(result, "preqtyonhand");
        objectProductCompleteData.preqtyorderonhand = UtilSql.getValue(result, "preqtyorderonhand");
        objectProductCompleteData.locator = UtilSql.getValue(result, "locator");
        objectProductCompleteData.cUom1 = UtilSql.getValue(result, "c_uom1");
        objectProductCompleteData.cUom2 = UtilSql.getValue(result, "c_uom2");
        objectProductCompleteData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectProductCompleteData.quantityorderRef = UtilSql.getValue(result, "quantityorder_ref");
        objectProductCompleteData.servidoBinary = UtilSql.getValue(result, "servido_binary");
        objectProductCompleteData.position = Long.toString(countRecord);
        objectProductCompleteData.rowkey = "";
        objectProductCompleteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCompleteData);
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
    ProductCompleteData objectProductCompleteData[] = new ProductCompleteData[vector.size()];
    vector.copyInto(objectProductCompleteData);
    return(objectProductCompleteData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String key, String name, String warehouse, String production, String adRoleId, String cBpartnerId, String adUserClient, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) as VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM ( SELECT 1" +
      "        FROM M_STORAGE_DETAIL T" +
      "          left join  M_ATTRIBUTESETINSTANCE A on T.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID," +
      "          M_PRODUCT P," +
      "          M_LOCATOR L, M_Warehouse W, AD_ORG O, AD_ROLE_ORGACCESS RO" +
      "        WHERE T.M_PRODUCT_ID = P.M_PRODUCT_ID ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND W.M_Warehouse_ID = ?  ");
    strSql = strSql + 
      "        AND W.M_WAREHOUSE_ID = L.M_WAREHOUSE_ID " +
      "        AND T.M_LOCATOR_ID = L.M_LOCATOR_ID " +
      "        AND W.AD_ORG_ID = O.AD_ORG_ID " +
      "        AND O.AD_ORG_ID = RO.AD_ORG_ID " +
      "        AND W.ISACTIVE = 'Y' " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((production.equals("production"))?"  AND P.production = 'Y'  ":"");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        AND RO.AD_ROLE_ID = ? " +
      "        AND (P.C_BPARTNER_ID IS NULL OR C_BPARTNER_ID = COALESCE(?, C_BPARTNER_ID)) " +
      "        AND W.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND (T.QtyOnHand <> 0 OR COALESCE(T.QtyOrderOnHand, 0) <> 0) " +
      "		AND 1=1";
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
      if (warehouse != null && !(warehouse.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (production != null && !(production.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
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

  public static ProductCompleteData[] selecttrl(ConnectionProvider connectionProvider, String adLanguage, String rownum, String key, String name, String warehouse, String production, String adRoleId, String cBpartnerId, String adUserClient, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return selecttrl(connectionProvider, adLanguage, rownum, key, name, warehouse, production, adRoleId, cBpartnerId, adUserClient, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ProductCompleteData[] selecttrl(ConnectionProvider connectionProvider, String adLanguage, String rownum, String key, String name, String warehouse, String production, String adRoleId, String cBpartnerId, String adUserClient, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.*," +
      "        M_PRODUCT_ID || '@_##_@' || name || '@_##_@' || COALESCE(TO_CHAR(M_LOCATOR_ID),'') || '@_##_@' || COALESCE(TO_CHAR(M_ATTRIBUTESETINSTANCE_ID),'') || '@_##_@' || " +
      "        QTYORDER || '@_##_@' || COALESCE(TO_CHAR(C_UOM2_ID),'') || '@_##_@' || COALESCE(QTY,0) || '@_##_@' || COALESCE(TO_CHAR(C_UOM1_ID),'') as rowkey," +
      "        (wh_name || ' - ' || loc_value || '-' || X || '-' || Y || '-' || Z) AS LOCATOR," +
      "        (SELECT U1TRL.NAME" +
      "          FROM C_UOM U1 LEFT JOIN C_UOM_TRL U1TRL ON U1.C_UOM_ID = U1TRL.C_UOM_ID AND U1TRL.AD_LANGUAGE = ? WHERE U1.C_UOM_ID = C_UOM1_ID" +
      "        ) AS C_UOM1," +
      "        (SELECT U2.NAME FROM M_PRODUCT_UOM PU left join C_UOM U2 ON PU.C_UOM_ID = U2.C_UOM_ID WHERE PU.M_PRODUCT_UOM_ID = C_UOM2_ID" +
      "        ) AS C_UOM2," +
      "        null as servido_binary" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM ( " +
      "        SELECT T.M_PRODUCT_ID, P.DISCONTINUED, P.VALUE, P.NAME, P.NAME AS NAME_HIDDEN, " +
      "        T.QtyOnHand AS QTY, COALESCE(T.QtyOrderOnHand, 0) AS QTYORDER, " +
      "        A.DESCRIPTION AS ATTRIBUTE," +
      "		w.name as wh_name, L.value as loc_value, L.X, L.Y, L.z," +
      "        T.M_ATTRIBUTESETINSTANCE_ID, T.M_LOCATOR_ID, " +
      "        T.C_UOM_ID AS C_UOM1_ID, T.M_PRODUCT_UOM_ID AS C_UOM2_ID, COALESCE(T.PREQTYONHAND, 0) AS QTY_REF, " +
      "        COALESCE(T.PREQTYORDERONHAND, 0) AS QUANTITYORDER_REF " +
      "        FROM" +
      "             M_STORAGE_DETAIL T" +
      "                              left join M_ATTRIBUTESETINSTANCE A on T.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID," +
      "             M_PRODUCT P," +
      "             M_LOCATOR L, M_Warehouse W, AD_ORG O, AD_ROLE_ORGACCESS RO" +
      "        WHERE T.M_PRODUCT_ID = P.M_PRODUCT_ID ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(P.Value) LIKE UPPER(?)  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  AND UPPER(P.Name) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals(""))?"":"  AND W.M_Warehouse_ID = ?  ");
    strSql = strSql + 
      "        AND W.M_WAREHOUSE_ID = L.M_WAREHOUSE_ID " +
      "        AND T.M_LOCATOR_ID = L.M_LOCATOR_ID " +
      "        AND W.AD_ORG_ID = O.AD_ORG_ID " +
      "        AND O.AD_ORG_ID = RO.AD_ORG_ID " +
      "        AND W.ISACTIVE = 'Y' " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((production.equals("production"))?"  AND P.production = 'Y'  ":"");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        AND RO.AD_ROLE_ID = ? " +
      "        AND (P.C_BPARTNER_ID IS NULL OR C_BPARTNER_ID = COALESCE(?, C_BPARTNER_ID)) " +
      "        AND W.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND (T.QtyOnHand <> 0 OR COALESCE(T.QtyOrderOnHand, 0) <> 0) " +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "        ) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") B" +
      "      WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    Vector<ProductCompleteData> vector = new Vector<ProductCompleteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (warehouse != null && !(warehouse.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (production != null && !(production.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
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
        ProductCompleteData objectProductCompleteData = new ProductCompleteData();
        objectProductCompleteData.rn1 = UtilSql.getValue(result, "rn1");
        objectProductCompleteData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductCompleteData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductCompleteData.value = UtilSql.getValue(result, "value");
        objectProductCompleteData.name = UtilSql.getValue(result, "name");
        objectProductCompleteData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectProductCompleteData.qty = UtilSql.getValue(result, "qty");
        objectProductCompleteData.qtyorder = UtilSql.getValue(result, "qtyorder");
        objectProductCompleteData.attribute = UtilSql.getValue(result, "attribute");
        objectProductCompleteData.whName = UtilSql.getValue(result, "wh_name");
        objectProductCompleteData.locValue = UtilSql.getValue(result, "loc_value");
        objectProductCompleteData.x = UtilSql.getValue(result, "x");
        objectProductCompleteData.y = UtilSql.getValue(result, "y");
        objectProductCompleteData.z = UtilSql.getValue(result, "z");
        objectProductCompleteData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductCompleteData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductCompleteData.cUom1Id = UtilSql.getValue(result, "c_uom1_id");
        objectProductCompleteData.cUom2Id = UtilSql.getValue(result, "c_uom2_id");
        objectProductCompleteData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectProductCompleteData.quantityorderRef = UtilSql.getValue(result, "quantityorder_ref");
        objectProductCompleteData.rowkey = UtilSql.getValue(result, "rowkey");
        objectProductCompleteData.locator = UtilSql.getValue(result, "locator");
        objectProductCompleteData.cUom1 = UtilSql.getValue(result, "c_uom1");
        objectProductCompleteData.cUom2 = UtilSql.getValue(result, "c_uom2");
        objectProductCompleteData.servidoBinary = UtilSql.getValue(result, "servido_binary");
        objectProductCompleteData.position = Long.toString(countRecord);
        objectProductCompleteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCompleteData);
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
    ProductCompleteData objectProductCompleteData[] = new ProductCompleteData[vector.size()];
    vector.copyInto(objectProductCompleteData);
    return(objectProductCompleteData);
  }

  public static String countRowsNotStored(ConnectionProvider connectionProvider, String rownum, String key, String name, String cBpartnerId, String adUserClient, String adUserOrg, String production, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) as VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM ( " +
      "        SELECT 1 " +
      "        FROM M_PRODUCT P left join M_ATTRIBUTESETINSTANCE A  on P.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID, " +
      "             C_UOM U1" +
      "        WHERE ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(P.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(P.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + 
      "P.C_UOM_ID = U1.C_UOM_ID " +
      "        AND (P.C_BPARTNER_ID IS NULL OR C_BPARTNER_ID = COALESCE(?, C_BPARTNER_ID)) " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((production.equals("production"))?"  AND P.production = 'Y'  ":"");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (production != null && !(production.equals(""))) {
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

  public static ProductCompleteData[] selectNotStored(ConnectionProvider connectionProvider, String rownum, String key, String name, String cBpartnerId, String adUserClient, String adUserOrg, String production, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return selectNotStored(connectionProvider, rownum, key, name, cBpartnerId, adUserClient, adUserOrg, production, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ProductCompleteData[] selectNotStored(ConnectionProvider connectionProvider, String rownum, String key, String name, String cBpartnerId, String adUserClient, String adUserOrg, String production, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.*," +
      "        M_PRODUCT_ID || '@_##_@' || name || '@_##_@' || '' || '@_##_@' || COALESCE(TO_CHAR(M_ATTRIBUTESETINSTANCE_ID),'') || '@_##_@' || " +
      "          0 || '@_##_@' || '' || '@_##_@' || 0 || '@_##_@' || COALESCE(TO_CHAR(C_UOM1_ID),'') as rowkey" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM ( " +
      "        SELECT P.M_PRODUCT_ID, P.DISCONTINUED, P.VALUE, P.NAME, P.NAME AS NAME_HIDDEN, 0 AS QTY, U1.NAME AS C_UOM1, " +
      "        0 AS QTYORDER, NULL AS C_UOM2, " +
      "        (CASE WHEN (P.ATTRSETVALUETYPE IS NULL OR P.ATTRSETVALUETYPE<>'F') THEN (CASE WHEN P.ATTRSETVALUETYPE='D' THEN A.DESCRIPTION ELSE NULL END) ELSE NULL END) AS ATTRIBUTE, " +
      "        NULL AS LOCATOR, " +
      "        (CASE WHEN (P.ATTRSETVALUETYPE IS NULL OR P.ATTRSETVALUETYPE<>'F') THEN (CASE WHEN P.ATTRSETVALUETYPE='D' THEN P.M_ATTRIBUTESETINSTANCE_ID ELSE NULL END) ELSE NULL END) AS M_ATTRIBUTESETINSTANCE_ID," +
      "        NULL AS M_LOCATOR_ID, " +
      "        P.C_UOM_ID AS C_UOM1_ID, NULL AS C_UOM2_ID, 0 AS QTY_REF, 0 AS QUANTITYORDER_REF, 0 AS SERVIDO_BINARY" +
      "        FROM M_PRODUCT P left join M_ATTRIBUTESETINSTANCE A  on P.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID, " +
      "             C_UOM U1" +
      "        WHERE ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(P.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(P.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + 
      "P.C_UOM_ID = U1.C_UOM_ID " +
      "        AND (P.C_BPARTNER_ID IS NULL OR C_BPARTNER_ID = COALESCE(?, C_BPARTNER_ID)) " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((production.equals("production"))?"  AND P.production = 'Y'  ":"");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "        ) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") B" +
      "      WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    Vector<ProductCompleteData> vector = new Vector<ProductCompleteData>(0);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (production != null && !(production.equals(""))) {
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
        ProductCompleteData objectProductCompleteData = new ProductCompleteData();
        objectProductCompleteData.rn1 = UtilSql.getValue(result, "rn1");
        objectProductCompleteData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductCompleteData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductCompleteData.value = UtilSql.getValue(result, "value");
        objectProductCompleteData.name = UtilSql.getValue(result, "name");
        objectProductCompleteData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectProductCompleteData.qty = UtilSql.getValue(result, "qty");
        objectProductCompleteData.cUom1 = UtilSql.getValue(result, "c_uom1");
        objectProductCompleteData.qtyorder = UtilSql.getValue(result, "qtyorder");
        objectProductCompleteData.cUom2 = UtilSql.getValue(result, "c_uom2");
        objectProductCompleteData.attribute = UtilSql.getValue(result, "attribute");
        objectProductCompleteData.locator = UtilSql.getValue(result, "locator");
        objectProductCompleteData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductCompleteData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductCompleteData.cUom1Id = UtilSql.getValue(result, "c_uom1_id");
        objectProductCompleteData.cUom2Id = UtilSql.getValue(result, "c_uom2_id");
        objectProductCompleteData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectProductCompleteData.quantityorderRef = UtilSql.getValue(result, "quantityorder_ref");
        objectProductCompleteData.servidoBinary = UtilSql.getValue(result, "servido_binary");
        objectProductCompleteData.rowkey = UtilSql.getValue(result, "rowkey");
        objectProductCompleteData.position = Long.toString(countRecord);
        objectProductCompleteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCompleteData);
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
    ProductCompleteData objectProductCompleteData[] = new ProductCompleteData[vector.size()];
    vector.copyInto(objectProductCompleteData);
    return(objectProductCompleteData);
  }

  public static ProductCompleteData[] selectNotStoredtrl(ConnectionProvider connectionProvider, String rownum, String adLanguage, String key, String name, String cBpartnerId, String adUserClient, String adUserOrg, String production, String orderBy, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    return selectNotStoredtrl(connectionProvider, rownum, adLanguage, key, name, cBpartnerId, adUserClient, adUserOrg, production, orderBy, pgLimit, oraLimit1, oraLimit2, 0, 0);
  }

  public static ProductCompleteData[] selectNotStoredtrl(ConnectionProvider connectionProvider, String rownum, String adLanguage, String key, String name, String cBpartnerId, String adUserClient, String adUserOrg, String production, String orderBy, String pgLimit, String oraLimit1, String oraLimit2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT B.*," +
      "          M_PRODUCT_ID || '@_##_@' || name || '@_##_@' || '' || '@_##_@' || COALESCE(TO_CHAR(M_ATTRIBUTESETINSTANCE_ID),'') || '@_##_@' || " +
      "          0 || '@_##_@' || '' || '@_##_@' || 0 || '@_##_@' || COALESCE(TO_CHAR(C_UOM1_ID),'') as rowkey" +
      "      FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM ( " +
      "        SELECT P.M_PRODUCT_ID, P.DISCONTINUED, P.VALUE, P.NAME, P.NAME AS NAME_HIDDEN, 0 AS QTY, U1TRL.NAME AS C_UOM1, " +
      "        0 AS QTYORDER, NULL AS C_UOM2," +
      "        (CASE WHEN (P.ATTRSETVALUETYPE IS NULL OR P.ATTRSETVALUETYPE<>'F') THEN (CASE WHEN P.ATTRSETVALUETYPE='D' THEN A.DESCRIPTION ELSE NULL END) ELSE NULL END) AS ATTRIBUTE, " +
      "        NULL AS LOCATOR, " +
      "        (CASE WHEN (P.ATTRSETVALUETYPE IS NULL OR P.ATTRSETVALUETYPE<>'F') THEN (CASE WHEN P.ATTRSETVALUETYPE='D' THEN P.M_ATTRIBUTESETINSTANCE_ID ELSE NULL END) ELSE NULL END) AS M_ATTRIBUTESETINSTANCE_ID," +
      "        NULL AS M_LOCATOR_ID, " +
      "        P.C_UOM_ID AS C_UOM1_ID, NULL AS C_UOM2_ID, 0 AS QTY_REF, 0 AS QUANTITYORDER_REF, 0 AS SERVIDO_BINARY" +
      "        FROM M_PRODUCT P left join M_ATTRIBUTESETINSTANCE A on P.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID," +
      "             C_UOM U1    left join C_UOM_TRL U1TRL on U1TRL.C_UOM_ID= U1.C_UOM_ID " +
      "                                                  AND U1TRL.AD_LANGUAGE= ?" +
      "        WHERE ";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  UPPER(P.Value) LIKE UPPER(?) AND  ");
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":"  UPPER(P.Name) LIKE UPPER(?) AND  ");
    strSql = strSql + 
      "P.C_UOM_ID = U1.C_UOM_ID " +
      "        AND (P.C_BPARTNER_ID IS NULL OR C_BPARTNER_ID = COALESCE(?, C_BPARTNER_ID)) " +
      "        AND P.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND P.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND P.ISACTIVE = 'Y'";
    strSql = strSql + ((production.equals("production"))?"  AND P.production = 'Y'  ":"");
    strSql = strSql + 
      "        AND p.IsGeneric='N'" +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "        ) A ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") B" +
      "      WHERE 1=1";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" AND RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    Vector<ProductCompleteData> vector = new Vector<ProductCompleteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (production != null && !(production.equals(""))) {
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
        ProductCompleteData objectProductCompleteData = new ProductCompleteData();
        objectProductCompleteData.rn1 = UtilSql.getValue(result, "rn1");
        objectProductCompleteData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductCompleteData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductCompleteData.value = UtilSql.getValue(result, "value");
        objectProductCompleteData.name = UtilSql.getValue(result, "name");
        objectProductCompleteData.nameHidden = UtilSql.getValue(result, "name_hidden");
        objectProductCompleteData.qty = UtilSql.getValue(result, "qty");
        objectProductCompleteData.cUom1 = UtilSql.getValue(result, "c_uom1");
        objectProductCompleteData.qtyorder = UtilSql.getValue(result, "qtyorder");
        objectProductCompleteData.cUom2 = UtilSql.getValue(result, "c_uom2");
        objectProductCompleteData.attribute = UtilSql.getValue(result, "attribute");
        objectProductCompleteData.locator = UtilSql.getValue(result, "locator");
        objectProductCompleteData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductCompleteData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductCompleteData.cUom1Id = UtilSql.getValue(result, "c_uom1_id");
        objectProductCompleteData.cUom2Id = UtilSql.getValue(result, "c_uom2_id");
        objectProductCompleteData.qtyRef = UtilSql.getValue(result, "qty_ref");
        objectProductCompleteData.quantityorderRef = UtilSql.getValue(result, "quantityorder_ref");
        objectProductCompleteData.servidoBinary = UtilSql.getValue(result, "servido_binary");
        objectProductCompleteData.rowkey = UtilSql.getValue(result, "rowkey");
        objectProductCompleteData.position = Long.toString(countRecord);
        objectProductCompleteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCompleteData);
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
    ProductCompleteData objectProductCompleteData[] = new ProductCompleteData[vector.size()];
    vector.copyInto(objectProductCompleteData);
    return(objectProductCompleteData);
  }
}
