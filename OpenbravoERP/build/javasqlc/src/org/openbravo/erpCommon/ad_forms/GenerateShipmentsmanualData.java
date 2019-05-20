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

class GenerateShipmentsmanualData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateShipmentsmanualData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String adorgname;
  public String cdoctypename;
  public String documentno;
  public String cbpartnername;
  public String dateordered;
  public String amountlines;
  public String totallines;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("adorgname"))
      return adorgname;
    else if (fieldName.equalsIgnoreCase("cdoctypename"))
      return cdoctypename;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("cbpartnername"))
      return cbpartnername;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("amountlines"))
      return amountlines;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GenerateShipmentsmanualData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adUserOrg, parBPartner, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static GenerateShipmentsmanualData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT o.C_Order_ID, org.Name as adorgname, COALESCE(dttrl.Name, dt.Name) as cdoctypename, o.DocumentNo, bp.Name as cbpartnername, o.DateOrdered, o.totallines as amountlines," +
      "      (" +
      "        SELECT sum((ol.qtyordered - ol.qtydelivered) * ol.priceactual)" +
      "        FROM c_orderline ol" +
      "        WHERE ol.c_order_id = o.c_order_id" +
      "        AND ol.qtyordered <> ol.qtydelivered" +
      "        AND ol.directship = 'N'" +
      "        AND ol.m_product_id IS NOT NULL" +
      "      ) as TotalLines" +
      "      FROM C_Order o" +
      "      JOIN AD_Org org" +
      "      ON o.AD_Org_ID = org.AD_Org_ID" +
      "      JOIN C_BPartner bp" +
      "      ON o.C_BPartner_ID = bp.C_BPartner_ID" +
      "      JOIN C_DocType dt" +
      "      ON o.C_DocType_ID = dt.C_DocType_ID" +
      "      LEFT JOIN C_DocType_trl dttrl" +
      "      ON dt.C_DocType_ID = dttrl.C_DocType_ID" +
      "      AND dttrl.ad_language = ?" +
      "      WHERE o.docstatus = 'CO'" +
      "      AND o.isdelivered = 'N'" +
      "      AND dt.isreturn = 'N'" +
      "      AND dt.docbasetype = 'SOO'" +
      "      AND dt.docsubtypeso NOT IN ('ON', 'OB')" +
      "      AND EXISTS (" +
      "        SELECT 1" +
      "        FROM C_ORDERLINE ol" +
      "        WHERE ol.c_order_id = o.c_order_id" +
      "        AND ol.qtyordered <> ol.qtydelivered" +
      "        AND ol.directship = 'N'" +
      "        AND ol.m_product_id IS NOT NULL" +
      "      )" +
      "      AND o.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND o.ad_org_id IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":" AND o.C_BPartner_ID = ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND o.DateOrdered >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND o.DateOrdered < TO_DATE(?) ");
    strSql = strSql + 
      "      AND 2=2 AND o.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      ORDER BY org.Name, bp.Name, DateOrdered";

    ResultSet result;
    Vector<GenerateShipmentsmanualData> vector = new Vector<GenerateShipmentsmanualData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        GenerateShipmentsmanualData objectGenerateShipmentsmanualData = new GenerateShipmentsmanualData();
        objectGenerateShipmentsmanualData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGenerateShipmentsmanualData.adorgname = UtilSql.getValue(result, "adorgname");
        objectGenerateShipmentsmanualData.cdoctypename = UtilSql.getValue(result, "cdoctypename");
        objectGenerateShipmentsmanualData.documentno = UtilSql.getValue(result, "documentno");
        objectGenerateShipmentsmanualData.cbpartnername = UtilSql.getValue(result, "cbpartnername");
        objectGenerateShipmentsmanualData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGenerateShipmentsmanualData.amountlines = UtilSql.getValue(result, "amountlines");
        objectGenerateShipmentsmanualData.totallines = UtilSql.getValue(result, "totallines");
        objectGenerateShipmentsmanualData.rownum = Long.toString(countRecord);
        objectGenerateShipmentsmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateShipmentsmanualData);
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
    GenerateShipmentsmanualData objectGenerateShipmentsmanualData[] = new GenerateShipmentsmanualData[vector.size()];
    vector.copyInto(objectGenerateShipmentsmanualData);
    return(objectGenerateShipmentsmanualData);
  }

  public static GenerateShipmentsmanualData[] set()    throws ServletException {
    GenerateShipmentsmanualData objectGenerateShipmentsmanualData[] = new GenerateShipmentsmanualData[1];
    objectGenerateShipmentsmanualData[0] = new GenerateShipmentsmanualData();
    objectGenerateShipmentsmanualData[0].cOrderId = "";
    objectGenerateShipmentsmanualData[0].adorgname = "";
    objectGenerateShipmentsmanualData[0].cdoctypename = "";
    objectGenerateShipmentsmanualData[0].documentno = "";
    objectGenerateShipmentsmanualData[0].cbpartnername = "";
    objectGenerateShipmentsmanualData[0].dateordered = "";
    objectGenerateShipmentsmanualData[0].amountlines = "";
    objectGenerateShipmentsmanualData[0].totallines = "";
    return objectGenerateShipmentsmanualData;
  }

  public static int update(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected = 'N'" +
      "      WHERE IsSelected='Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int updateSelection(ConnectionProvider connectionProvider, String parSalesOrders)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='Y' " +
      "      WHERE 1=1";
    strSql = strSql + ((parSalesOrders==null || parSalesOrders.equals(""))?"":" AND C_Order_ID IN" + parSalesOrders);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parSalesOrders != null && !(parSalesOrders.equals(""))) {
        }

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int updateReset(ConnectionProvider connectionProvider, String parSalesOrders)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='N' " +
      "      WHERE 1=1";
    strSql = strSql + ((parSalesOrders==null || parSalesOrders.equals(""))?"":" AND C_Order_ID IN" + parSalesOrders);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parSalesOrders != null && !(parSalesOrders.equals(""))) {
        }

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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
