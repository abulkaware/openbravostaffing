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

class ShipmentReceiptLineData implements FieldProvider {
static Logger log4j = Logger.getLogger(ShipmentReceiptLineData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String mInoutlineId;
  public String bpartnerName;
  public String productName;
  public String movementdate;
  public String documentno;
  public String issotrx;
  public String qty;
  public String locatorName;
  public String attributeName;
  public String lineText;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("bpartner_name") || fieldName.equals("bpartnerName"))
      return bpartnerName;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("locator_name") || fieldName.equals("locatorName"))
      return locatorName;
    else if (fieldName.equalsIgnoreCase("attribute_name") || fieldName.equals("attributeName"))
      return attributeName;
    else if (fieldName.equalsIgnoreCase("line_text") || fieldName.equals("lineText"))
      return lineText;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ShipmentReceiptLineData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String product, String isinvoiced, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adUserClient, adUserOrg, documentno, description, orderReference, businesPartner, dateFrom, dateTo, product, isinvoiced, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static ShipmentReceiptLineData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String product, String isinvoiced, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (  " +
      "          SELECT ml.M_INOUTLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY AS QTY, l.VALUE AS LOCATOR_NAME, a.DESCRIPTION AS ATTRIBUTE_NAME, " +
      "          (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) AS LINE_TEXT," +
      "					ml.M_INOUTLINE_ID || '@_##_@' || (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) as rowkey" +
      "          FROM M_INOUTLINE ml left join M_ATTRIBUTESETINSTANCE a on ml.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID" +
      "                              left join M_LOCATOR l on ml.M_LOCATOR_ID = l.M_LOCATOR_ID," +
      "               M_INOUT m,  M_PRODUCT p, C_BPARTNER b" +
      "          WHERE m.M_INOUT_ID = ml.M_INOUT_ID " +
      "          AND m.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ml.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND m.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND m.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND m.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(m.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ml.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(m.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND m.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND m.MovementDate >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND m.MovementDate < to_date(?)  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ml.M_Product_ID=?  ");
    strSql = strSql + 
      "          AND m.ISSOTRX = 'Y' " +
      "          AND ml.ISINVOICED = ?" +
      "          ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "				) A ) B" +
      "				WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<ShipmentReceiptLineData> vector = new Vector<ShipmentReceiptLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        ShipmentReceiptLineData objectShipmentReceiptLineData = new ShipmentReceiptLineData();
        objectShipmentReceiptLineData.rn1 = UtilSql.getValue(result, "rn1");
        objectShipmentReceiptLineData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectShipmentReceiptLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectShipmentReceiptLineData.productName = UtilSql.getValue(result, "product_name");
        objectShipmentReceiptLineData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectShipmentReceiptLineData.documentno = UtilSql.getValue(result, "documentno");
        objectShipmentReceiptLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectShipmentReceiptLineData.qty = UtilSql.getValue(result, "qty");
        objectShipmentReceiptLineData.locatorName = UtilSql.getValue(result, "locator_name");
        objectShipmentReceiptLineData.attributeName = UtilSql.getValue(result, "attribute_name");
        objectShipmentReceiptLineData.lineText = UtilSql.getValue(result, "line_text");
        objectShipmentReceiptLineData.rowkey = UtilSql.getValue(result, "rowkey");
        objectShipmentReceiptLineData.position = Long.toString(countRecord);
        objectShipmentReceiptLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShipmentReceiptLineData);
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
    ShipmentReceiptLineData objectShipmentReceiptLineData[] = new ShipmentReceiptLineData[vector.size()];
    vector.copyInto(objectShipmentReceiptLineData);
    return(objectShipmentReceiptLineData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String product, String isinvoiced, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM (  " +
      "          SELECT ml.M_INOUTLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY AS QTY, l.VALUE AS LOCATOR_NAME, a.DESCRIPTION AS ATTRIBUTE_NAME, " +
      "          (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) AS LINE_TEXT," +
      "                    ml.M_INOUTLINE_ID || '@_##_@' || (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) as rowkey" +
      "          FROM M_INOUTLINE ml left join M_ATTRIBUTESETINSTANCE a on ml.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID" +
      "                              left join M_LOCATOR l on ml.M_LOCATOR_ID = l.M_LOCATOR_ID," +
      "               M_INOUT m,  M_PRODUCT p, C_BPARTNER b" +
      "          WHERE m.M_INOUT_ID = ml.M_INOUT_ID " +
      "          AND m.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ml.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND m.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND m.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND m.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(m.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ml.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(m.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND m.C_BPartner_ID = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND m.MovementDate >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND m.MovementDate < to_date(?)  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ml.M_Product_ID = ?  ");
    strSql = strSql + 
      "          AND m.ISSOTRX = 'Y' " +
      "          AND ml.ISINVOICED = ?" +
      "          AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "                ) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") A ";
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
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
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

  public static String countRowsSO(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String product, String isinvoiced, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COUNT(*) AS VALUESO FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM (  " +
      "          SELECT 1 FROM  M_INOUTLINE ml left join  M_ATTRIBUTESETINSTANCE a on ml.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID" +
      "                               left join M_LOCATOR l on ml.M_LOCATOR_ID = l.M_LOCATOR_ID" +
      "                               left join M_MATCHINV mi on  ml.M_INOUTLINE_ID = mi.M_INOUTLINE_ID," +
      "                               M_INOUT m, M_PRODUCT p, C_BPARTNER b " +
      "          WHERE m.M_INOUT_ID = ml.M_INOUT_ID " +
      "          AND m.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ml.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND m.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND m.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND m.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(m.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ml.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(m.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND m.C_BPartner_ID = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND m.MovementDate >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND m.MovementDate < to_date(?)  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ml.M_Product_ID = ?  ");
    strSql = strSql + 
      "          GROUP BY ml.M_INOUTLINE_ID, b.NAME, p.NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY, l.VALUE, a.DESCRIPTION, ml.LINE" +
      "          HAVING (ml.MOVEMENTQTY - COALESCE(SUM(mi.QTY),0)) ";
    strSql = strSql + ((isinvoiced==null || isinvoiced.equals(""))?"":isinvoiced);
    strSql = strSql + 
      " 0 ";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "               ) B ";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      ") A ";
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
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (isinvoiced != null && !(isinvoiced.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "valueso");
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

  public static ShipmentReceiptLineData[] selectSOTrx(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String product, String isinvoiced, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return selectSOTrx(connectionProvider, rownum, adUserClient, adUserOrg, documentno, description, orderReference, businesPartner, dateFrom, dateTo, product, isinvoiced, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static ShipmentReceiptLineData[] selectSOTrx(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String documentno, String description, String orderReference, String businesPartner, String dateFrom, String dateTo, String product, String isinvoiced, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (  " +
      "          SELECT ml.M_INOUTLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY AS QTY, l.VALUE AS LOCATOR_NAME, a.DESCRIPTION AS ATTRIBUTE_NAME, " +
      "          (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) AS LINE_TEXT," +
      "					ml.M_INOUTLINE_ID || '@_##_@' || (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) as rowkey" +
      "          FROM  M_INOUTLINE ml left join  M_ATTRIBUTESETINSTANCE a on ml.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID" +
      "                               left join M_LOCATOR l on ml.M_LOCATOR_ID = l.M_LOCATOR_ID" +
      "                               left join M_MATCHINV mi on  ml.M_INOUTLINE_ID = mi.M_INOUTLINE_ID," +
      "                M_INOUT m, M_PRODUCT p, C_BPARTNER b " +
      "          WHERE m.M_INOUT_ID = ml.M_INOUT_ID " +
      "          AND m.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ml.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND m.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND m.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND m.IsActive='Y'";
    strSql = strSql + ((documentno==null || documentno.equals("") || documentno.equals("%") )?"":"  AND UPPER(m.DocumentNo) LIKE UPPER(?)  ");
    strSql = strSql + ((description==null || description.equals("") || description.equals("%") )?"":"  AND UPPER(ml.Description) LIKE UPPER(?)  ");
    strSql = strSql + ((orderReference==null || orderReference.equals("") || orderReference.equals("%") )?"":"  AND UPPER(m.POReference) LIKE UPPER(?)  ");
    strSql = strSql + ((businesPartner==null || businesPartner.equals(""))?"":"  AND m.C_BPartner_ID=?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND m.MovementDate >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND m.MovementDate < to_date(?)  ");
    strSql = strSql + ((product==null || product.equals(""))?"":"  AND ml.M_Product_ID=?  ");
    strSql = strSql + 
      "          GROUP BY ml.M_INOUTLINE_ID, b.NAME, p.NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY, l.VALUE, a.DESCRIPTION, ml.LINE" +
      "          HAVING (ml.MOVEMENTQTY - COALESCE(SUM(mi.QTY),0)) ";
    strSql = strSql + ((isinvoiced==null || isinvoiced.equals(""))?"":isinvoiced);
    strSql = strSql + 
      " 0" +
      "          ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "				) A ) B" +
      "				WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<ShipmentReceiptLineData> vector = new Vector<ShipmentReceiptLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (documentno != null && !(documentno.equals("")) && !(documentno.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      }
      if (description != null && !(description.equals("")) && !(description.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (orderReference != null && !(orderReference.equals("")) && !(orderReference.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReference);
      }
      if (businesPartner != null && !(businesPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, businesPartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (product != null && !(product.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      }
      if (isinvoiced != null && !(isinvoiced.equals(""))) {
        }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        ShipmentReceiptLineData objectShipmentReceiptLineData = new ShipmentReceiptLineData();
        objectShipmentReceiptLineData.rn1 = UtilSql.getValue(result, "rn1");
        objectShipmentReceiptLineData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectShipmentReceiptLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectShipmentReceiptLineData.productName = UtilSql.getValue(result, "product_name");
        objectShipmentReceiptLineData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectShipmentReceiptLineData.documentno = UtilSql.getValue(result, "documentno");
        objectShipmentReceiptLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectShipmentReceiptLineData.qty = UtilSql.getValue(result, "qty");
        objectShipmentReceiptLineData.locatorName = UtilSql.getValue(result, "locator_name");
        objectShipmentReceiptLineData.attributeName = UtilSql.getValue(result, "attribute_name");
        objectShipmentReceiptLineData.lineText = UtilSql.getValue(result, "line_text");
        objectShipmentReceiptLineData.rowkey = UtilSql.getValue(result, "rowkey");
        objectShipmentReceiptLineData.position = Long.toString(countRecord);
        objectShipmentReceiptLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShipmentReceiptLineData);
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
    ShipmentReceiptLineData objectShipmentReceiptLineData[] = new ShipmentReceiptLineData[vector.size()];
    vector.copyInto(objectShipmentReceiptLineData);
    return(objectShipmentReceiptLineData);
  }

  public static ShipmentReceiptLineData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, key, 0, 0);
  }

  public static ShipmentReceiptLineData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ml.M_INOUTLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY AS QTY, l.VALUE AS LOCATOR_NAME, a.DESCRIPTION AS ATTRIBUTE_NAME, " +
      "          (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) AS LINE_TEXT" +
      "          FROM M_INOUTLINE ml left join  M_ATTRIBUTESETINSTANCE a on ml.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID," +
      "          M_INOUT m,  M_PRODUCT p, C_BPARTNER b, M_LOCATOR l" +
      "          WHERE m.M_INOUT_ID = ml.M_INOUT_ID " +
      "          AND m.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ml.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND ml.M_LOCATOR_ID = l.M_LOCATOR_ID " +
      "          AND m.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND m.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND m.IsActive='Y' " +
      "          AND UPPER(m.DOCUMENTNO) LIKE UPPER(?) " +
      "          AND m.ISSOTRX = 'Y' " +
      "          AND ml.ISINVOICED = 'N'" +
      "          ORDER BY b.NAME, m.MOVEMENTDATE, m.DOCUMENTNO, ml.LINE";

    ResultSet result;
    Vector<ShipmentReceiptLineData> vector = new Vector<ShipmentReceiptLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        ShipmentReceiptLineData objectShipmentReceiptLineData = new ShipmentReceiptLineData();
        objectShipmentReceiptLineData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectShipmentReceiptLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectShipmentReceiptLineData.productName = UtilSql.getValue(result, "product_name");
        objectShipmentReceiptLineData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectShipmentReceiptLineData.documentno = UtilSql.getValue(result, "documentno");
        objectShipmentReceiptLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectShipmentReceiptLineData.qty = UtilSql.getValue(result, "qty");
        objectShipmentReceiptLineData.locatorName = UtilSql.getValue(result, "locator_name");
        objectShipmentReceiptLineData.attributeName = UtilSql.getValue(result, "attribute_name");
        objectShipmentReceiptLineData.lineText = UtilSql.getValue(result, "line_text");
        objectShipmentReceiptLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShipmentReceiptLineData);
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
    ShipmentReceiptLineData objectShipmentReceiptLineData[] = new ShipmentReceiptLineData[vector.size()];
    vector.copyInto(objectShipmentReceiptLineData);
    return(objectShipmentReceiptLineData);
  }

  public static ShipmentReceiptLineData[] selectKeySOTrx(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key)    throws ServletException {
    return selectKeySOTrx(connectionProvider, adUserClient, adUserOrg, key, 0, 0);
  }

  public static ShipmentReceiptLineData[] selectKeySOTrx(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ml.M_INOUTLINE_ID, b.NAME AS BPARTNER_NAME, p.NAME AS PRODUCT_NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY AS QTY, l.VALUE AS LOCATOR_NAME, a.DESCRIPTION AS ATTRIBUTE_NAME, " +
      "          (ml.LINE || ' - ' || ml.MOVEMENTQTY || ' - ' || m.DOCUMENTNO || ' - ' || m.MOVEMENTDATE || " +
      "          ' - ' || p.NAME) AS LINE_TEXT" +
      "          FROM  M_INOUTLINE ml left join M_ATTRIBUTESETINSTANCE a on ml.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID" +
      "                               left join  M_MATCHINV mi on ml.M_INOUTLINE_ID = mi.M_INOUTLINE_ID," +
      "          M_INOUT m,  M_PRODUCT p, C_BPARTNER b,  M_LOCATOR l" +
      "          WHERE m.M_INOUT_ID = ml.M_INOUT_ID " +
      "          AND m.C_BPARTNER_ID = b.C_BPARTNER_ID " +
      "          AND ml.M_PRODUCT_ID = p.M_PRODUCT_ID " +
      "          AND ml.M_LOCATOR_ID = l.M_LOCATOR_ID " +
      "          AND m.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "          AND m.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "          AND m.IsActive='Y' " +
      "          AND UPPER(m.DOCUMENTNO) LIKE UPPER(?) " +
      "          AND m.ISSOTRX = 'N' " +
      "          GROUP BY ml.M_INOUTLINE_ID, b.NAME, p.NAME, m.MOVEMENTDATE, m.DOCUMENTNO, " +
      "          m.ISSOTRX, ml.MOVEMENTQTY, l.VALUE, a.DESCRIPTION, ml.LINE" +
      "          HAVING (ml.MOVEMENTQTY - COALESCE(SUM(mi.QTY),0)) > 0" +
      "          ORDER BY b.NAME, m.MOVEMENTDATE, m.DOCUMENTNO, ml.LINE";

    ResultSet result;
    Vector<ShipmentReceiptLineData> vector = new Vector<ShipmentReceiptLineData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        ShipmentReceiptLineData objectShipmentReceiptLineData = new ShipmentReceiptLineData();
        objectShipmentReceiptLineData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectShipmentReceiptLineData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectShipmentReceiptLineData.productName = UtilSql.getValue(result, "product_name");
        objectShipmentReceiptLineData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectShipmentReceiptLineData.documentno = UtilSql.getValue(result, "documentno");
        objectShipmentReceiptLineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectShipmentReceiptLineData.qty = UtilSql.getValue(result, "qty");
        objectShipmentReceiptLineData.locatorName = UtilSql.getValue(result, "locator_name");
        objectShipmentReceiptLineData.attributeName = UtilSql.getValue(result, "attribute_name");
        objectShipmentReceiptLineData.lineText = UtilSql.getValue(result, "line_text");
        objectShipmentReceiptLineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectShipmentReceiptLineData);
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
    ShipmentReceiptLineData objectShipmentReceiptLineData[] = new ShipmentReceiptLineData[vector.size()];
    vector.copyInto(objectShipmentReceiptLineData);
    return(objectShipmentReceiptLineData);
  }

  public static String selectBPartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static String selectProduct(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM M_PRODUCT WHERE M_PRODUCT_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static String getProductID(ConnectionProvider connectionProvider, String name)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT_ID FROM M_PRODUCT WHERE UPPER(NAME)=UPPER(?)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
