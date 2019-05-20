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

class CreateFromShipmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromShipmentData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String name;
  public String qty;
  public String cUomId;
  public String uomsymbol;
  public String mProductId;
  public String relationName;
  public String cOrderlineId;
  public String line;
  public String adOrgId;
  public String cInvoicelineId;
  public String mInoutlineId;
  public String breakdown;
  public String stdprecision;
  public String cUomIdConversion;
  public String quantityorder;
  public String mProductUomId;
  public String mAttributesetinstanceId;
  public String id;
  public String cInvoiceId;
  public String description;
  public String secqty;
  public String secProductUomId;
  public String aumqty;
  public String cAum;
  public String aumname;
  public String uompreference;
  public String haveuompreference;
  public String attributesetinstancename;
  public String secuomsymbol;
  public String havesec;
  public String havesecuom;
  public String locator;
  public String aAssetId;
  public String cProjectId;
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;
  public String cBpartnerId;
  public String explode;
  public String bomParentId;
  public String isparent;
  public String isorder;
  public String cDoctypeId;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("uomsymbol"))
      return uomsymbol;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("relation_name") || fieldName.equals("relationName"))
      return relationName;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("breakdown"))
      return breakdown;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("c_uom_id_conversion") || fieldName.equals("cUomIdConversion"))
      return cUomIdConversion;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("secqty"))
      return secqty;
    else if (fieldName.equalsIgnoreCase("sec_product_uom_id") || fieldName.equals("secProductUomId"))
      return secProductUomId;
    else if (fieldName.equalsIgnoreCase("aumqty"))
      return aumqty;
    else if (fieldName.equalsIgnoreCase("c_aum") || fieldName.equals("cAum"))
      return cAum;
    else if (fieldName.equalsIgnoreCase("aumname"))
      return aumname;
    else if (fieldName.equalsIgnoreCase("uompreference"))
      return uompreference;
    else if (fieldName.equalsIgnoreCase("haveuompreference"))
      return haveuompreference;
    else if (fieldName.equalsIgnoreCase("attributesetinstancename"))
      return attributesetinstancename;
    else if (fieldName.equalsIgnoreCase("secuomsymbol"))
      return secuomsymbol;
    else if (fieldName.equalsIgnoreCase("havesec"))
      return havesec;
    else if (fieldName.equalsIgnoreCase("havesecuom"))
      return havesecuom;
    else if (fieldName.equalsIgnoreCase("locator"))
      return locator;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("explode"))
      return explode;
    else if (fieldName.equalsIgnoreCase("bom_parent_id") || fieldName.equals("bomParentId"))
      return bomParentId;
    else if (fieldName.equalsIgnoreCase("isparent"))
      return isparent;
    else if (fieldName.equalsIgnoreCase("isorder"))
      return isorder;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromShipmentData[] selectFromPO(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPO(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPO(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID," +
      "	    Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, " +
      "        l.C_OrderLine_ID,l.Line, l.ad_org_id, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID, '' AS BREAKDOWN, '' AS STDPRECISION, " +
      "        '' AS C_UOM_ID_Conversion, '' AS QUANTITYORDER, '' AS M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID AS M_ATTRIBUTESETINSTANCE_ID, " +
      "        l.C_OrderLine_ID AS ID, '' AS C_Invoice_ID, l.DESCRIPTION AS DESCRIPTION," +
      "        (l.quantityorder - C_UOM_CONVERT(SUM(COALESCE(m.Qty,0)), l.C_UOM_ID, mpu.C_UOM_ID, 'Y'))" +
      "        as SECQTY, l.M_PRODUCT_UOM_ID as SEC_PRODUCT_UOM_ID," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, m.Qty, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE, '' AS HAVEUOMPREFERENCE," +
      "        (SELECT M_ATTRIBUTESETINSTANCE.DESCRIPTION FROM M_ATTRIBUTESETINSTANCE WHERE " +
      "        l.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID) as ATTRIBUTESETINSTANCENAME, " +
      "        (SELECT C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID) as SECUOMSYMBOL," +
      "        COALESCE(l.M_PRODUCT_UOM_ID,null,'0') as HAVESEC,'' as HAVESECUOM,'' AS LOCATOR," +
      "        coalesce(l.a_asset_id,o.a_asset_id) as a_asset_id, coalesce(l.c_project_id,o.c_project_id) as c_project_id, " +
      "        coalesce(l.c_costcenter_id, o.c_costcenter_id) as c_costcenter_id," +
      "        coalesce(l.user1_id,o.user1_id) as user1_id, coalesce(l.user2_id,o.user2_id) as user2_id, " +
      "        coalesce (l.c_bpartner_id,o.c_bpartner_id) as c_bpartner_id, l.explode, l.bom_parent_id, CASE WHEN l.Bom_parent_id is null then 'Y' else 'N' END as isparent, " +
      "        '' as isorder, o.C_DOCTYPE_ID AS C_DOCTYPE_ID" +
      "        FROM C_ORDERLINE l left join  M_MATCHPO m on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                 and m.M_InOutLine_ID IS NOT NULL" +
      "                           LEFT JOIN M_Product_UOM mpu on mpu.M_PRODUCT_UOM_ID =l.M_PRODUCT_UOM_ID,  " +
      "        C_ORDER o, C_UOM uom, M_PRODUCT p, C_DOCTYPE dt" +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID " +
      "        AND o.C_DOCTYPE_ID = dt.C_DOCTYPE_ID" +
      "        AND dt.isreturn = 'N'" +
      "        AND o.IsSOTrx='N' " +
      "        AND o.DocStatus IN ('CL','CO') " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID" +
      "        AND l.M_Product_ID=p.M_Product_ID" +
      "        AND l.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID, l.AUMQTY, l.C_AUM, uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.ad_org_id, l.DESCRIPTION, l.QUANTITYORDER, " +
      "        l.M_PRODUCT_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, coalesce(l.a_asset_id,o.a_asset_id), coalesce(l.c_project_id,o.c_project_id), coalesce(l.c_costcenter_id, o.c_costcenter_id)," +
      "        coalesce(l.user1_id,o.user1_id), coalesce(l.user2_id,o.user2_id), coalesce (l.c_bpartner_id,o.c_bpartner_id) ,mpu.C_UOM_ID, l.explode, l.bom_parent_id, o.C_DOCTYPE_ID, uom.C_UOM_ID" +
      "        HAVING ((l.explode='Y')  OR ((l.QtyOrdered-SUM(COALESCE(m.Qty,0)))<>0)) " +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.secqty = UtilSql.getValue(result, "secqty");
        objectCreateFromShipmentData.secProductUomId = UtilSql.getValue(result, "sec_product_uom_id");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.haveuompreference = UtilSql.getValue(result, "haveuompreference");
        objectCreateFromShipmentData.attributesetinstancename = UtilSql.getValue(result, "attributesetinstancename");
        objectCreateFromShipmentData.secuomsymbol = UtilSql.getValue(result, "secuomsymbol");
        objectCreateFromShipmentData.havesec = UtilSql.getValue(result, "havesec");
        objectCreateFromShipmentData.havesecuom = UtilSql.getValue(result, "havesecuom");
        objectCreateFromShipmentData.locator = UtilSql.getValue(result, "locator");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.bomParentId = UtilSql.getValue(result, "bom_parent_id");
        objectCreateFromShipmentData.isparent = UtilSql.getValue(result, "isparent");
        objectCreateFromShipmentData.isorder = UtilSql.getValue(result, "isorder");
        objectCreateFromShipmentData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromPOCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME" +
      "        FROM C_ORDER o JOIN C_DOCTYPE dt ON o.c_doctype_id = dt.c_doctype_id AND dt.isreturn='N'" +
      "        WHERE o.IsSOTrx='N' " +
      "        AND o.DocStatus IN ('CL','CO') " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND o.C_BPartner_ID = ? " +
      "        AND EXISTS (SELECT 1 " +
      "                      FROM C_ORDERLINE l left join M_MATCHPO m on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                              and  m.M_InOutLine_ID IS NOT NULL" +
      "                     WHERE l.C_ORDER_ID = o.C_ORDER_ID " +
      "                      GROUP BY l.C_OrderLine_ID, l.QtyOrdered " +
      "                      HAVING (l.QtyOrdered-SUM(COALESCE(m.Qty,0))) <> 0)" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOSOTrx(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-COALESCE(l.qtydelivered,0) AS QTY, l.C_UOM_ID,uom.UOMSymbol, l.M_Product_ID," +
      "        Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, " +
      "        l.C_OrderLine_ID,l.Line, l.C_OrderLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION," +
      "        coalesce(l.a_asset_id,o.a_asset_id) as a_asset_id, coalesce(l.c_project_id,o.c_project_id) as c_project_id, " +
      "        coalesce(l.c_costcenter_id,o.c_costcenter_id) as c_costcenter_id, " +
      "        coalesce(l.user1_id,o.user1_id) as user1_id ,coalesce( l.user2_id ,o.user2_id) as user2_id, " +
      "        coalesce (l.c_bpartner_id,o.c_bpartner_id) as c_bpartner_id, l.Bom_parent_id, CASE WHEN l.Bom_parent_id is null then 'Y' else 'N' END as isparent," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, l.qtydelivered, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "        FROM M_INOUT_CANDIDATE_V ic, C_ORDER o, C_UOM uom, C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID" +
      "        AND o.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID = uom.C_UOM_ID" +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND ic.C_Order_ID = ?" +
      "        AND ((l.explode <>'Y' AND l.QtyOrdered <> COALESCE(l.qtydelivered,0)) OR (l.explode ='Y')) " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.ad_org_id, l.DESCRIPTION," +
      "        coalesce(l.a_asset_id,o.a_asset_id) , coalesce( l.c_project_id,o.c_project_id),coalesce(l.c_costcenter_id,o.c_costcenter_id), " +
      "        coalesce(l.user1_id,o.user1_id), coalesce(l.user2_id,o.user2_id), coalesce (l.c_bpartner_id,o.c_bpartner_id)," +
      "        l.Bom_parent_id, l.AUMQTY, l.C_AUM" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.bomParentId = UtilSql.getValue(result, "bom_parent_id");
        objectCreateFromShipmentData.isparent = UtilSql.getValue(result, "isparent");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromPOSOTrxCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOSOTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID as ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME" +
      "        FROM C_ORDER o" +
      "        JOIN C_DOCTYPE dt" +
      "        ON o.c_doctype_id = dt.c_doctype_id" +
      "        WHERE o.docstatus = 'CO'" +
      "        AND o.isdelivered = 'N'" +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND o.C_BPartner_ID = ?" +
      "        AND dt.isreturn = 'N'" +
      "        AND dt.docbasetype = 'SOO'" +
      "        AND dt.docsubtypeso NOT IN ('ON', 'OB')" +
      "        AND EXISTS (" +
      "          SELECT 1" +
      "          FROM C_ORDERLINE ol" +
      "          WHERE ol.c_order_id = o.c_order_id" +
      "          AND ol.qtyordered <> ol.qtydelivered" +
      "          AND ol.directship = 'N'" +
      "          AND ol.m_product_id IS NOT NULL" +
      "        )" +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOTrl(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOTrl(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOTrl(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS QTY, l.C_UOM_ID,COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, l.M_Product_ID," +
      "        Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, l.C_OrderLine_ID, l.Line, l.C_OrderLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION," +
      "        ((l.QtyOrdered-SUM(COALESCE(m.Qty,0)))/COALESCE(" +
      "        (SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID =" +
      "        (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID)        " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = l.C_UOM_ID),(SELECT DIVIDERATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID = l.C_UOM_ID " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID))))" +
      "         as SECQTY, l.M_PRODUCT_UOM_ID as SEC_PRODUCT_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID AS M_ATTRIBUTESETINSTANCE_ID," +
      "        (SELECT M_ATTRIBUTESETINSTANCE.DESCRIPTION FROM M_ATTRIBUTESETINSTANCE WHERE " +
      "        l.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID) as ATTRIBUTESETINSTANCENAME," +
      "        (SELECT C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID " +
      "        AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID) as SECUOMSYMBOL," +
      "        COALESCE(l.M_PRODUCT_UOM_ID,null,'0') as HAVESEC,'' AS LOCATOR," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, m.Qty, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                                and uomt.AD_Language  = ?," +
      "              C_ORDERLINE l left join M_MATCHPO m  on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                and m.M_InOutLine_ID IS NOT NULL," +
      "        C_ORDER o,   M_PRODUCT p" +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID " +
      "        AND o.IsSOTrx='N' " +
      "        AND o.DocStatus IN ('CL','CO') " +
      "        AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND o.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID" +
      "        AND l.C_Order_ID = ? " +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol, l.AUMQTY, l.C_AUM, uomt.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.DESCRIPTION, l.QUANTITYORDER, l.M_PRODUCT_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID" +
      "        HAVING (l.QtyOrdered-SUM(COALESCE(m.Qty,0))) <> 0" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.secqty = UtilSql.getValue(result, "secqty");
        objectCreateFromShipmentData.secProductUomId = UtilSql.getValue(result, "sec_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.attributesetinstancename = UtilSql.getValue(result, "attributesetinstancename");
        objectCreateFromShipmentData.secuomsymbol = UtilSql.getValue(result, "secuomsymbol");
        objectCreateFromShipmentData.havesec = UtilSql.getValue(result, "havesec");
        objectCreateFromShipmentData.locator = UtilSql.getValue(result, "locator");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOTrlSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId)    throws ServletException {
    return selectFromPOTrlSOTrx(connectionProvider, language, adUserClient, adOrgClient, poId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOTrlSOTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String poId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT o.C_ORDER_ID, Ad_Column_Identifier(TO_CHAR('C_Order'), TO_CHAR(o.c_order_id), TO_CHAR(?)) AS NAME, " +
      "        l.QtyOrdered-COALESCE(l.qtydelivered,0) AS QTY, l.C_UOM_ID, COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol, " +
      "        l.M_Product_ID,Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, l.C_OrderLine_ID, l.Line, l.C_OrderLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, l.qtydelivered, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                                and uomt.AD_Language = ?," +
      "        M_INOUT_CANDIDATE_V ic, C_ORDER o,   C_ORDERLINE l, M_PRODUCT p " +
      "        WHERE o.C_ORDER_ID = l.C_ORDER_ID" +
      "        AND o.C_ORDER_ID = ic.C_ORDER_ID " +
      "        AND ic.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ic.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID = uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND ic.C_Order_ID = ?" +
      "        AND l.QtyOrdered <> COALESCE(l.qtydelivered,0)" +
      "        GROUP BY o.C_ORDER_ID, o.DocumentNo, o.DateOrdered, o.GrandTotal, l.QtyOrdered,l.qtydelivered, " +
      "        l.C_UOM_ID,uom.UOMSymbol,uomt.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, l.DESCRIPTION," +
      "        l.AUMQTY, l.C_AUM" +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOUpdate(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cOrderlineId)    throws ServletException {
    return selectFromPOUpdate(conn, connectionProvider, adLanguage, cOrderlineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOUpdate(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyOrdered-SUM(COALESCE(m.Qty,0)) AS ID, l.C_UOM_ID, l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, m.Qty, l.c_aum), 0)) AS AUMQTY, l.C_AUM, " +
      "      uom.UOMSymbol, l.M_Product_ID,Ad_Column_Identifier(to_char('M_Product'), to_char(l.m_product_id), to_char(?)) AS NAME, l.C_OrderLine_ID," +
      "      l.Line, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, " +
      "      l.QUANTITYORDER*C_DIVIDE((l.QtyOrdered-SUM(COALESCE(m.Qty,0))),(l.QtyOrdered)) AS quantityOrder, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION," +
      "      coalesce(l.a_asset_id,o.a_asset_id) as a_asset_id, coalesce(l.c_project_id, o.c_project_id) as c_project_id , " +
      "   	  coalesce(l.c_costcenter_id,o.c_costcenter_id) as c_costcenter_id," +
      "      coalesce(l.user1_id,o.user1_id) as user1_id,coalesce( l.user2_id,o.user2_id) as user2_id , " +
      "      coalesce (l.c_bpartner_id,o.c_bpartner_id) as c_bpartner_id, l.explode, 'Y' as isorder, o.C_DOCTYPE_ID AS C_DOCTYPE_ID" +
      "      FROM C_ORDERLINE l left join M_MATCHPO m on l.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                              and  m.M_InOutLine_ID IS NOT NULL " +
      "                         left join M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID" +
      "                         left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID," +
      "      C_UOM uom,  M_PRODUCT p , C_ORDER o" +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND l.M_Product_ID=p.M_Product_ID";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.C_OrderLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "      AND o.C_ORDER_ID = l.C_ORDER_ID " +
      "      GROUP BY l.QtyOrdered,l.qtydelivered,l.C_UOM_ID,l.AUMQTY,l.C_AUM,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, " +
      "      uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION," +
      "      coalesce(l.a_asset_id,o.a_asset_id), coalesce(l.c_project_id, o.c_project_id), coalesce(l.c_costcenter_id,o.c_costcenter_id) ," +
      "      coalesce(l.user1_id,o.user1_id) ,coalesce( l.user2_id,o.user2_id) , coalesce (l.c_bpartner_id,o.c_bpartner_id), l.explode, o.C_DOCTYPE_ID" +
      "      ORDER BY l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cOrderlineId != null && !(cOrderlineId.equals(""))) {
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.isorder = UtilSql.getValue(result, "isorder");
        objectCreateFromShipmentData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromPOUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cOrderlineId)    throws ServletException {
    return selectFromPOUpdateSOTrx(conn, connectionProvider, adLanguage, cOrderlineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromPOUpdateSOTrx(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cOrderlineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyOrdered - COALESCE(l.QTYDELIVERED,0) AS ID, l.C_UOM_ID, l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, l.qtydelivered, l.c_aum), 0)) AS AUMQTY, l.C_AUM, " +
      "      uom.UOMSymbol, l.M_Product_ID,Ad_Column_Identifier(to_char('M_Product'), to_char(l.m_product_id), to_char(?)) AS NAME, " +
      "      l.C_OrderLine_ID, l.Line, '' as C_InvoiceLine_ID, '' as M_InOutLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, " +
      "      l.QUANTITYORDER*C_DIVIDE((l.QtyOrdered - COALESCE(l.QTYDELIVERED,0)),(l.QtyOrdered)) as quantityOrder, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION," +
      "      coalesce(l.a_asset_id,o.a_asset_id) as a_asset_id, coalesce(l.c_project_id, o.c_project_id) as c_project_id , " +
      "   	  coalesce(l.c_costcenter_id,o.c_costcenter_id) as c_costcenter_id," +
      "      coalesce(l.user1_id,o.user1_id) as user1_id,coalesce( l.user2_id,o.user2_id) as user2_id , " +
      "      l.c_bpartner_id, l.explode, 'Y' as isorder, o.C_DOCTYPE_ID AS C_DOCTYPE_ID" +
      "      FROM C_ORDERLINE l left join M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID" +
      "                         left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID ," +
      "      C_UOM uom,  M_PRODUCT p, C_ORDER o" +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND o.C_ORDER_ID = l.C_ORDER_ID    " +
      "      AND l.M_Product_ID=p.M_Product_ID";
    strSql = strSql + ((cOrderlineId==null || cOrderlineId.equals(""))?"":"  AND l.C_OrderLine_ID IN " + cOrderlineId);
    strSql = strSql + 
      "      GROUP BY l.QtyOrdered,l.qtydelivered,l.C_UOM_ID,l.AUMQTY,l.C_AUM,uom.UOMSymbol,l.M_Product_ID,p.NAME,l.Line,l.C_OrderLine_ID, " +
      "      uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION," +
      "      coalesce(l.a_asset_id,o.a_asset_id), coalesce(l.c_project_id, o.c_project_id), coalesce(l.c_costcenter_id,o.c_costcenter_id)," +
      "   	  coalesce(l.user1_id,o.user1_id),coalesce( l.user2_id,o.user2_id), l.c_bpartner_id, l.explode, o.C_DOCTYPE_ID" +
      "      HAVING ((l.explode='Y')  OR (l.QtyOrdered - COALESCE(l.QTYDELIVERED,0)<>0)) " +
      "      ORDER BY l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cOrderlineId != null && !(cOrderlineId.equals(""))) {
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.isorder = UtilSql.getValue(result, "isorder");
        objectCreateFromShipmentData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoice(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId)    throws ServletException {
    return selectFromInvoice(connectionProvider, language, adUserClient, adOrgClient, cInvoiceId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoice(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME, " +
      "        l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)) AS QTY, l.C_UOM_ID,uom.UOMSymbol," +
      "        l.M_Product_ID,Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, " +
      "        coalesce(l.a_asset_id,i.a_asset_id) as a_asset_id, coalesce(l.c_project_id,i.c_project_id) as c_project_id, " +
      "        coalesce(l.c_costcenter_id,i.c_costcenter_id) as c_costcenter_id, " +
      "        coalesce(l.user1_id,i.user1_id) as user1_id , coalesce(l.user2_id, i.user2_id) as user2_id, l.c_bpartner_id," +
      "        l.C_InvoiceLine_ID,l.Line, l.C_OrderLine_ID, l.C_InvoiceLine_ID AS ID, l.DESCRIPTION AS DESCRIPTION," +
      "        ((l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)))/COALESCE(" +
      "        (SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID =" +
      "        (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID)        " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = l.C_UOM_ID),(SELECT DIVIDERATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID = l.C_UOM_ID " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID))))" +
      "        as SECQTY, l.M_PRODUCT_UOM_ID as SEC_PRODUCT_UOM_ID," +
      "        (SELECT C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID) as SECUOMSYMBOL," +
      "        COALESCE(l.M_PRODUCT_UOM_ID,null,'0') as HAVESEC,'' as HAVESECUOM,'' AS LOCATOR,l.M_ATTRIBUTESETINSTANCE_ID AS M_ATTRIBUTESETINSTANCE_ID," +
      "        (SELECT M_ATTRIBUTESETINSTANCE.DESCRIPTION FROM M_ATTRIBUTESETINSTANCE WHERE l.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID) as ATTRIBUTESETINSTANCENAME, l.explode, l.Bom_parent_id, " +
      "        CASE WHEN l.Bom_parent_id is null then 'Y' else 'N' END as isparent," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, mi.Qty, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE, i.C_DOCTYPE_ID AS C_DOCTYPE_ID" +
      "        FROM C_INVOICELINE l left join  M_MATCHINV mi  on l.C_InvoiceLine_ID=mi.C_InvoiceLine_ID," +
      "        C_INVOICE i, C_UOM uom,  M_PRODUCT p" +
      "        WHERE i.C_INVOICE_ID = l.C_INVOICE_ID " +
      "        AND i.IsSOTrx='N' " +
      "        AND i.DocStatus IN ('CL','CO') " +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.C_Invoice_ID = ? " +
      "        GROUP BY i.C_Invoice_ID, i.DocumentNo, DateInvoiced, GrandTotal, l.QtyInvoiced, " +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, l.DESCRIPTION,l.QUANTITYORDER," +
      "        l.M_PRODUCT_UOM_ID,l.M_ATTRIBUTESETINSTANCE_ID,  coalesce(l.a_asset_id,i.a_asset_id), coalesce(l.c_project_id,i.c_project_id), " +
      "        l.AUMQTY, l.C_AUM, " +
      "        coalesce(l.c_costcenter_id,i.c_costcenter_id) , " +
      "        coalesce(l.user1_id,i.user1_id) , coalesce(l.user2_id, i.user2_id), l.c_bpartner_id, l.explode, l.bom_parent_id, i.C_DOCTYPE_ID" +
      "        HAVING ((l.explode='Y')  OR (l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))<>0))   " +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.secqty = UtilSql.getValue(result, "secqty");
        objectCreateFromShipmentData.secProductUomId = UtilSql.getValue(result, "sec_product_uom_id");
        objectCreateFromShipmentData.secuomsymbol = UtilSql.getValue(result, "secuomsymbol");
        objectCreateFromShipmentData.havesec = UtilSql.getValue(result, "havesec");
        objectCreateFromShipmentData.havesecuom = UtilSql.getValue(result, "havesecuom");
        objectCreateFromShipmentData.locator = UtilSql.getValue(result, "locator");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.attributesetinstancename = UtilSql.getValue(result, "attributesetinstancename");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.bomParentId = UtilSql.getValue(result, "bom_parent_id");
        objectCreateFromShipmentData.isparent = UtilSql.getValue(result, "isparent");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId)    throws ServletException {
    return selectFromInvoiceTrx(connectionProvider, language, adUserClient, adOrgClient, cInvoiceId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrx(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME, " +
      "        l.QtyInvoiced-SUM(COALESCE(mi.MOVEMENTQTY,0)) AS QTY, l.C_UOM_ID,uom.UOMSymbol," +
      "        l.M_Product_ID,Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, " +
      "	    l.C_InvoiceLine_ID,l.Line, l.C_OrderLine_ID, l.C_InvoiceLine_ID AS ID, " +
      "        l.DESCRIPTION AS DESCRIPTION," +
      "        coalesce(l.a_asset_id,i.a_asset_id) as a_asset_id, coalesce(l.c_project_id,i.c_project_id) as c_project_id,coalesce(l.c_costcenter_id,i.c_costcenter_id)" +
      "        as c_costcenter_id, coalesce(l.user1_id,i.user1_id) as user1_id , coalesce(l.user2_id,i.user2_id) as user2_id , l.c_bpartner_id, l.explode, l.Bom_parent_id," +
      "        CASE  WHEN l.Bom_parent_id is null then 'Y' else 'N' END as isparent," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, mi.MOVEMENTQTY, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "        FROM C_INVOICELINE l left join M_INOUTLINE mi on l.M_INOUTLINE_ID = mi.M_INOUTLINE_ID," +
      "        C_INVOICE i, C_UOM uom,  M_PRODUCT p" +
      "        WHERE i.C_INVOICE_ID = l.C_INVOICE_ID " +
      "        AND i.DocStatus IN ('CL','CO')" +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.C_Invoice_ID = ?" +
      "        GROUP BY i.C_Invoice_ID, i.DocumentNo, DateInvoiced, GrandTotal, l.QtyInvoiced, " +
      "        l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, l.DESCRIPTION," +
      "        l.AUMQTY, l.C_AUM," +
      "        coalesce(l.a_asset_id,i.a_asset_id), coalesce(l.c_project_id,i.c_project_id),coalesce(l.c_costcenter_id,i.c_costcenter_id), " +
      "		coalesce(l.user1_id,i.user1_id), coalesce(l.user2_id,i.user2_id) , l.c_bpartner_id, l.explode, l.Bom_parent_id" +
      "        HAVING ((l.explode='Y')  OR ((l.QtyInvoiced-SUM(COALESCE(mi.MOVEMENTQTY,0))) <> 0))  " +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.bomParentId = UtilSql.getValue(result, "bom_parent_id");
        objectCreateFromShipmentData.isparent = UtilSql.getValue(result, "isparent");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromInvoiceCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID AS ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME" +
      "        FROM C_INVOICE i JOIN C_DOCTYPE dt ON i.c_doctype_id = dt.c_doctype_id AND dt.isreturn='N'" +
      "        WHERE i.IsSOTrx='N' " +
      "        AND i.DocStatus IN ('CL','CO') " +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND i.C_BPartner_ID = ?  " +
      "        AND EXISTS (SELECT 1 " +
      "                     FROM C_INVOICELINE l left join M_MATCHINV mi on l.C_InvoiceLine_ID=mi.C_InvoiceLine_ID" +
      "                      WHERE l.C_INVOICE_ID = i.C_INVOICE_ID " +
      "                      GROUP BY l.QtyInvoiced, l.C_InvoiceLine_ID " +
      "                      HAVING (l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))) <> 0 ) " +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId)    throws ServletException {
    return selectFromInvoiceTrxCombo(connectionProvider, language, adUserClient, adOrgClient, cBpartnerId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxCombo(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID AS ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME" +
      "        FROM C_INVOICE i" +
      "        JOIN C_DOCTYPE dt" +
      "        ON i.c_doctype_id = dt.c_doctype_id" +
      "        WHERE i.DocStatus IN ('CL','CO')" +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND i.IsSOTrx='Y'" +
      "        AND i.C_BPartner_ID = ?" +
      "        AND dt.isreturn = 'N'" +
      "        AND EXISTS (" +
      "          SELECT 1" +
      "          FROM C_INVOICELINE il" +
      "          WHERE il.C_INVOICE_ID = i.C_INVOICE_ID" +
      "          AND ((il.M_INOUTLINE_ID IS NULL AND il.QtyInvoiced <> 0)" +
      "          OR (il.M_INOUTLINE_ID IS NOT NULL AND EXISTS (" +
      "            SELECT 1" +
      "            FROM M_INOUTLINE iol" +
      "            WHERE iol.M_INOUTLINE_ID = il.M_INOUTLINE_ID" +
      "            AND (il.QtyInvoiced - iol.MOVEMENTQTY) <> 0" +
      "          )))" +
      "        )" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrl(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId)    throws ServletException {
    return selectFromInvoiceTrl(connectionProvider, language, adUserClient, adOrgClient, cInvoiceId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrl(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgClient, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_Invoice_ID, Ad_Column_Identifier(TO_CHAR('C_Invoice'), TO_CHAR(i.C_Invoice_ID), TO_CHAR(?)) AS NAME, " +
      "        l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)) AS QTY, l.C_UOM_ID,COALESCE(uomt.UOMSymbol, uom.UOMSymbol) AS UOMSymbol," +
      "        l.M_Product_ID,Ad_Column_Identifier(TO_CHAR('M_Product'), TO_CHAR(l.m_product_id), TO_CHAR(?)) AS RELATION_NAME, " +
      "        l.C_InvoiceLine_ID,l.Line, l.C_OrderLine_ID, l.C_InvoiceLine_ID AS ID, " +
      "        l.DESCRIPTION AS DESCRIPTION," +
      "        ((l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)))/COALESCE(" +
      "        (SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID =" +
      "        (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID)        " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = l.C_UOM_ID),(SELECT DIVIDERATE FROM C_UOM_CONVERSION WHERE C_UOM_CONVERSION.C_UOM_ID = l.C_UOM_ID " +
      "        AND C_UOM_CONVERSION.C_UOM_TO_ID = (SELECT C_UOM.C_UOM_ID FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID)))) " +
      "        as SECQTY, l.M_PRODUCT_UOM_ID as SEC_PRODUCT_UOM_ID," +
      "        (SELECT C_UOM.NAME FROM M_PRODUCT_UOM, C_UOM WHERE M_PRODUCT_UOM_ID = l.M_PRODUCT_UOM_ID AND M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID) as SECUOMSYMBOL," +
      "        COALESCE(l.M_PRODUCT_UOM_ID,null,'0') as HAVESEC,'' as HAVESECUOM,'' AS LOCATOR," +
      "        l.M_ATTRIBUTESETINSTANCE_ID AS M_ATTRIBUTESETINSTANCE_ID," +
      "        (SELECT M_ATTRIBUTESETINSTANCE.DESCRIPTION FROM M_ATTRIBUTESETINSTANCE " +
      "        WHERE l.M_ATTRIBUTESETINSTANCE_ID = M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID) as ATTRIBUTESETINSTANCENAME," +
      "        l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, mi.Qty, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "        (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "        FROM C_UOM uom left join C_UOM_TRL uomt on uom.C_UOM_ID = uomt.C_UOM_ID" +
      "                                               AND uomt.AD_Language  = ?," +
      "             C_INVOICELINE l left join M_MATCHINV mi on l.C_InvoiceLine_ID=mi.C_InvoiceLine_ID," +
      "        C_INVOICE i,    M_PRODUCT p " +
      "        WHERE i.C_INVOICE_ID = l.C_INVOICE_ID " +
      "        AND i.IsSOTrx='N' " +
      "        AND i.DocStatus IN ('CL','CO') " +
      "        AND i.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND l.C_UOM_ID=uom.C_UOM_ID " +
      "        AND l.M_Product_ID=p.M_Product_ID " +
      "        AND l.C_Invoice_ID = ? " +
      "        GROUP BY i.C_Invoice_ID, i.DocumentNo, DateInvoiced, GrandTotal, l.QtyInvoiced, " +
      "        l.C_UOM_ID,uom.UOMSymbol, uomt.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, " +
      "        l.AUMQTY, l.C_AUM," +
      "        l.DESCRIPTION, l.QUANTITYORDER, l.M_PRODUCT_UOM_ID,l.M_ATTRIBUTESETINSTANCE_ID" +
      "        HAVING (l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))) <> 0 " +
      "        ORDER BY NAME, l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.qty = UtilSql.getValue(result, "qty");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.relationName = UtilSql.getValue(result, "relation_name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.secqty = UtilSql.getValue(result, "secqty");
        objectCreateFromShipmentData.secProductUomId = UtilSql.getValue(result, "sec_product_uom_id");
        objectCreateFromShipmentData.secuomsymbol = UtilSql.getValue(result, "secuomsymbol");
        objectCreateFromShipmentData.havesec = UtilSql.getValue(result, "havesec");
        objectCreateFromShipmentData.havesecuom = UtilSql.getValue(result, "havesecuom");
        objectCreateFromShipmentData.locator = UtilSql.getValue(result, "locator");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.attributesetinstancename = UtilSql.getValue(result, "attributesetinstancename");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceUpdate(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cInvoicelineId)    throws ServletException {
    return selectFromInvoiceUpdate(conn, connectionProvider, adLanguage, cInvoicelineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceUpdate(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cInvoicelineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyInvoiced-SUM(COALESCE(mi.Qty,0)) AS ID, l.C_UOM_ID,uom.UOMSymbol," +
      "      l.M_Product_ID,Ad_Column_Identifier(to_char('M_Product'), to_char(l.m_product_id), to_char(?)) AS NAME, l.C_InvoiceLine_ID,l.Line," +
      "      l.C_OrderLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, l.QUANTITYORDER, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION, l.C_INVOICE_ID," +
      "      coalesce(l.a_asset_id,i.a_asset_id) as a_asset_id, coalesce(l.c_project_id, i.c_project_id) as c_project_id, " +
      "      coalesce(l.c_costcenter_id,i.c_costcenter_id) as c_costcenter_id , " +
      "      coalesce(l.user1_id,i.user1_id ) as user1_id , coalesce(l.user2_id , i.user2_id) as user2_id, l.c_bpartner_id, l.explode, " +
      "      'N' as isorder, i.C_DOCTYPE_ID AS C_DOCTYPE_ID," +
      "      l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, mi.Qty, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "      (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "      FROM C_INVOICELINE l left join  M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID " +
      "                           left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID " +
      "                           left join M_MATCHINV mi on l.C_InvoiceLine_ID=mi.C_InvoiceLine_ID," +
      "      C_UOM uom,  M_PRODUCT p, C_INVOICE i" +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND l.M_Product_ID=p.M_Product_ID ";
    strSql = strSql + ((cInvoicelineId==null || cInvoicelineId.equals(""))?"":"  AND l.C_InvoiceLine_ID IN " + cInvoicelineId);
    strSql = strSql + 
      "      AND i.C_INVOICE_ID = l.C_INVOICE_ID " +
      "      GROUP BY l.QtyInvoiced," +
      "      l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, " +
      "      l.AUMQTY, l.C_AUM,uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION, l.C_INVOICE_ID," +
      "      coalesce(l.a_asset_id,i.a_asset_id), coalesce(l.c_project_id, i.c_project_id), coalesce(l.c_costcenter_id,i.c_costcenter_id), " +
      "      coalesce(l.user1_id,i.user1_id ), coalesce(l.user2_id , i.user2_id),l.c_bpartner_id, l.explode, i.c_doctype_id" +
      "      HAVING ((l.explode='Y')  OR (l.QtyInvoiced-SUM(COALESCE(mi.Qty,0))<>0))   " +
      "      ORDER BY l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cInvoicelineId != null && !(cInvoicelineId.equals(""))) {
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.isorder = UtilSql.getValue(result, "isorder");
        objectCreateFromShipmentData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxUpdate(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cInvoicelineId)    throws ServletException {
    return selectFromInvoiceTrxUpdate(conn, connectionProvider, adLanguage, cInvoicelineId, 0, 0);
  }

  public static CreateFromShipmentData[] selectFromInvoiceTrxUpdate(Connection conn, ConnectionProvider connectionProvider, String adLanguage, String cInvoicelineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT l.QtyInvoiced-SUM(COALESCE(mi.MOVEMENTQTY,0)) AS ID, l.C_UOM_ID,uom.UOMSymbol," +
      "      l.M_Product_ID,Ad_Column_Identifier(to_char('M_Product'), to_char(l.m_product_id), to_char(?)) AS NAME, l.C_InvoiceLine_ID,l.Line, l.C_OrderLine_ID, COALESCE(uom1.BREAKDOWN, 'N') AS BREAKDOWN, " +
      "      MAX(mu.C_UOM_ID) AS C_UOM_ID_Conversion, MAX(uom1.STDPRECISION) AS STDPRECISION, l.QUANTITYORDER, l.M_Product_UOM_ID," +
      "      l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION AS DESCRIPTION," +
      "      coalesce(l.a_asset_id,i.a_asset_id) as a_asset_id , coalesce(l.c_project_id,i.c_project_id) as c_project_id, " +
      "      coalesce(l.c_costcenter_id,i.c_costcenter_id) as c_costcenter_id," +
      "      coalesce( l.user1_id,i.user1_id) as user1_id , coalesce(l.user2_id ,i.user2_id) as  user2_id ,  l.c_bpartner_id, l.explode," +
      "      'N' as isorder," +
      "      l.AUMQTY - SUM(COALESCE(M_GET_CONVERTED_AUMQTY(l.m_product_id, mi.MOVEMENTQTY, l.c_aum), 0)) AS AUMQTY, l.C_AUM AS C_AUM, " +
      "      (SELECT UOMSYMBOL FROM C_UOM WHERE C_UOM_ID = l.C_AUM) AS AUMNAME, '' AS UOMPREFERENCE" +
      "      FROM C_INVOICELINE l left join  M_Product_UOM mu on l.M_Product_UOM_ID = mu.M_Product_UOM_ID " +
      "                           left join C_UOM uom1 on mu.C_UOM_ID = uom1.C_UOM_ID " +
      "                           left join M_INOUTLINE mi on l.M_INOUTLINE_ID=mi.M_INOUTLINE_ID," +
      "      C_UOM uom,  M_PRODUCT p, C_INVOICE i" +
      "      WHERE l.C_UOM_ID=uom.C_UOM_ID" +
      "      AND i.c_invoice_id = l.c_invoice_id" +
      "      AND i.IsSOTrx='Y'" +
      "      AND l.M_Product_ID=p.M_Product_ID ";
    strSql = strSql + ((cInvoicelineId==null || cInvoicelineId.equals(""))?"":"  AND l.C_InvoiceLine_ID IN " + cInvoicelineId);
    strSql = strSql + 
      "      GROUP BY l.QtyInvoiced," +
      "      l.C_UOM_ID,uom.UOMSymbol,l.M_Product_ID,p.NAME, l.C_InvoiceLine_ID,l.Line,l.C_OrderLine_ID, " +
      "      l.AUMQTY, l.C_AUM," +
      "      uom1.BREAKDOWN, l.QUANTITYORDER, l.M_Product_UOM_ID, l.M_ATTRIBUTESETINSTANCE_ID, l.ad_org_id, l.DESCRIPTION," +
      "      coalesce(l.a_asset_id,i.a_asset_id), coalesce(l.c_project_id,i.c_project_id), coalesce(l.c_costcenter_id,i.c_costcenter_id)," +
      "      coalesce( l.user1_id,i.user1_id), coalesce(l.user2_id ,i.user2_id) ,  l.c_bpartner_id, l.explode" +
      "      HAVING ((l.explode='Y')  OR (l.QtyInvoiced-SUM(COALESCE(mi.MOVEMENTQTY,0))<>0))  " +
      "      ORDER BY l.Line";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cInvoicelineId != null && !(cInvoicelineId.equals(""))) {
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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.id = UtilSql.getValue(result, "id");
        objectCreateFromShipmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCreateFromShipmentData.uomsymbol = UtilSql.getValue(result, "uomsymbol");
        objectCreateFromShipmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCreateFromShipmentData.name = UtilSql.getValue(result, "name");
        objectCreateFromShipmentData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCreateFromShipmentData.line = UtilSql.getValue(result, "line");
        objectCreateFromShipmentData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectCreateFromShipmentData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectCreateFromShipmentData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectCreateFromShipmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromShipmentData.description = UtilSql.getValue(result, "description");
        objectCreateFromShipmentData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCreateFromShipmentData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCreateFromShipmentData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectCreateFromShipmentData.user1Id = UtilSql.getValue(result, "user1_id");
        objectCreateFromShipmentData.user2Id = UtilSql.getValue(result, "user2_id");
        objectCreateFromShipmentData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCreateFromShipmentData.explode = UtilSql.getValue(result, "explode");
        objectCreateFromShipmentData.isorder = UtilSql.getValue(result, "isorder");
        objectCreateFromShipmentData.aumqty = UtilSql.getValue(result, "aumqty");
        objectCreateFromShipmentData.cAum = UtilSql.getValue(result, "c_aum");
        objectCreateFromShipmentData.aumname = UtilSql.getValue(result, "aumname");
        objectCreateFromShipmentData.uompreference = UtilSql.getValue(result, "uompreference");
        objectCreateFromShipmentData.rownum = Long.toString(countRecord);
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static CreateFromShipmentData[] set()    throws ServletException {
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[1];
    objectCreateFromShipmentData[0] = new CreateFromShipmentData();
    objectCreateFromShipmentData[0].id = "";
    objectCreateFromShipmentData[0].cUomId = "";
    objectCreateFromShipmentData[0].uomsymbol = "";
    objectCreateFromShipmentData[0].mProductId = "";
    objectCreateFromShipmentData[0].name = "";
    objectCreateFromShipmentData[0].cInvoicelineId = "";
    objectCreateFromShipmentData[0].line = "";
    objectCreateFromShipmentData[0].cOrderlineId = "";
    objectCreateFromShipmentData[0].breakdown = "";
    objectCreateFromShipmentData[0].cUomIdConversion = "";
    objectCreateFromShipmentData[0].stdprecision = "";
    objectCreateFromShipmentData[0].quantityorder = "";
    objectCreateFromShipmentData[0].mProductUomId = "";
    objectCreateFromShipmentData[0].mAttributesetinstanceId = "";
    objectCreateFromShipmentData[0].adOrgId = "";
    objectCreateFromShipmentData[0].description = "";
    objectCreateFromShipmentData[0].aAssetId = "";
    objectCreateFromShipmentData[0].cProjectId = "";
    objectCreateFromShipmentData[0].cCostcenterId = "";
    objectCreateFromShipmentData[0].user1Id = "";
    objectCreateFromShipmentData[0].user2Id = "";
    objectCreateFromShipmentData[0].cBpartnerId = "";
    objectCreateFromShipmentData[0].explode = "";
    objectCreateFromShipmentData[0].isorder = "";
    objectCreateFromShipmentData[0].aumqty = "";
    objectCreateFromShipmentData[0].cAum = "";
    objectCreateFromShipmentData[0].aumname = "";
    objectCreateFromShipmentData[0].uompreference = "";
    return objectCreateFromShipmentData;
  }

  public static String selectLocator(ConnectionProvider connectionProvider, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT VALUE FROM M_LOCATOR WHERE M_LOCATOR_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

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

  public static String selectBPartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID=?";

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

  public static String isInvoiced(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PROCESSED FROM C_INVOICE WHERE C_INVOICE_ID=(SELECT C_INVOICE_ID FROM C_INVOICELINE WHERE C_INVOICELINE_ID = ?)";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "processed");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String mInoutId, String adClientId, String adOrgId, String adUserId, String description, String mProductId, String cUomId, String movementqty, String aumqty, String cAum, String cOrderlineId, String mLocatorId, String isinvoiced, String quantityorder, String mProductUomId, String mAttributesetinstanceId, String aAssetId, String cProjectId, String cCostcenterId, String user1Id, String user2Id, String cBpartnerId, String explode, String isOrder)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_INOUTLINE " +
      "        (M_InOutLine_ID,M_InOut_ID, AD_Client_ID,AD_Org_ID," +
      "         IsActive,Created,CreatedBy,Updated, UpdatedBy, " +
      "         Line,Description, M_Product_ID," +
      "         C_UOM_ID,MovementQty,AUMQTY,C_AUM,C_OrderLine_ID," +
      "         M_Locator_ID,IsInvoiced, QUANTITYORDER, " +
      "      M_PRODUCT_UOM_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "      A_ASSET_ID, C_PROJECT_ID, C_COSTCENTER_ID," +
      "      USER1_ID, USER2_ID, C_BPARTNER_ID, explode, BOM_Parent_id)" +
      "      VALUES " +
      "        (?, ?, ?, ?, " +
      "         'Y', now(), ?, now(), ?, " +
      "         (SELECT (COALESCE(Max(Line),0))+10 FROM M_InOutLine WHERE M_InOut_ID=?), ?, ?, " +
      "         ?, TO_NUMBER(?), TO_NUMBER(?), ?, ?, " +
      "         ?, ?, TO_NUMBER(?), " +
      "         ?, ?," +
      "         ?, ?, ?," +
      "         ?, ?,?, ?," +
      "         (CASE to_char(?) WHEN 'Y' THEN (SELECT m_inoutline_id " +
      "                                        FROM m_inoutline " +
      "                                        WHERE m_inout_id=? " +
      "                                         and c_orderline_id = (SELECT BOM_parent_id " +
      "                                                               FROM c_orderline " +
      "                                                               WHERE c_orderline_id = ?)) " +
      "          ELSE null END                        " +
      "         )" +
      "        )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isOrder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

/**
Copies the order line accounting dimensions to In/Out lines
 */
  public static int insertAcctDimension(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String adClientId, String adOrgId, String adUserId, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_INOUTLINE_ACCTDIMENSION" +
      "        (M_InOutLine_AcctDimension_ID,M_InOutLine_ID, AD_Client_ID,AD_Org_ID,IsActive," +
      "        Created,CreatedBy,Updated,UpdatedBy," +
      "        C_Project_ID, C_Campaign_ID, User1_ID," +
      "        User2_ID, C_Activity_ID, C_Costcenter_ID," +
      "        C_BPartner_ID, M_Product_ID, A_Asset_ID," +
      "        Quantity" +
      "        )" +
      "        (SELECT GET_UUID(), ?, ?, ?, 'Y'," +
      "         now(), ?, now(), ?, C_Project_ID, C_Campaign_ID," +
      "         User1_ID, User2_ID, C_Activity_ID, C_Costcenter_Id," +
      "         C_BPartner_ID, M_Product_ID, A_Asset_ID," +
      "         (Amt/(SELECT PriceActual FROM C_OrderLine WHERE C_OrderLine_ID = ?))" +
      "         FROM C_OrderLine_AcctDimension" +
      "         WHERE C_OrderLine_ID = ?" +
      "         )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

/**
Copies the Invoice line accounting dimensions to In/Out lines
 */
  public static int insertInvoiceAcctDimension(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String adClientId, String adOrgId, String adUserId, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_INOUTLINE_ACCTDIMENSION" +
      "        (M_InOutLine_AcctDimension_ID,M_InOutLine_ID, AD_Client_ID,AD_Org_ID,IsActive," +
      "        Created,CreatedBy,Updated,UpdatedBy," +
      "        C_Project_ID, C_Campaign_ID, User1_ID," +
      "        User2_ID, C_Activity_ID, C_Costcenter_ID," +
      "        C_BPartner_ID, M_Product_ID, A_Asset_ID, " +
      "        Quantity" +
      "        )" +
      "        (SELECT GET_UUID(), ?, ?, ?, 'Y'," +
      "         now(), ?, now(), ?, C_Project_ID, C_Campaign_ID," +
      "         User1_ID, User2_ID, C_Activity_ID, C_Costcenter_Id," +
      "         C_BPartner_ID, M_Product_ID, A_Asset_ID," +
      "         (Amt/(SELECT PriceActual FROM C_InvoiceLine WHERE C_InvoiceLine_ID = ?))" +
      "         FROM C_InvoiceLine_AcctDimension" +
      "         WHERE C_InvoiceLine_ID = ?" +
      "         )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertMatchInv(Connection conn, ConnectionProvider connectionProvider, String adUserId, String cInvoiceLineId, String mInoutlineId, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_MATCHINV" +
      "        (" +
      "        M_MATCHINV_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY," +
      "        UPDATED, UPDATEDBY, M_INOUTLINE_ID, C_INVOICELINE_ID, M_PRODUCT_ID," +
      "        DATETRX, QTY, PROCESSING, PROCESSED, POSTED" +
      "        )" +
      "      SELECT" +
      "        GET_UUID(), iol.AD_CLIENT_ID, iol.AD_ORG_ID, 'Y', NOW(), ?," +
      "        NOW(), ?, iol.M_INOUTLINE_ID, ?, iol.M_PRODUCT_ID," +
      "        i.DATEACCT, iol.MOVEMENTQTY, 'N', 'Y', 'N'" +
      "      FROM M_INOUTLINE iol, C_INVOICE i" +
      "      WHERE iol.M_INOUTLINE_ID=?" +
      "        AND i.C_INVOICE_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static String selectInvoiceInOut(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_InoutLine_id" +
      "      FROM C_InvoiceLine" +
      "      WHERE C_InvoiceLine_ID= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_inoutline_id");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static int updateInvoice(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String cInvoicelineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_InvoiceLine SET M_InoutLine_id = ?" +
      "      WHERE C_InvoiceLine_ID= ? " +
      "      AND M_InOutLine_ID IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateBOMStructure(Connection conn, ConnectionProvider connectionProvider, String mInoutId, String mInoutlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_Inoutline " +
      "      SET Bom_parent_id = (SELECT m_inoutline.m_inoutline_id " +
      "                           FROM m_inoutline inner join c_invoiceline on m_inoutline.m_inoutline_id = c_invoiceline.m_inoutline_id" +
      "                           WHERE m_inout_id=? " +
      "                             and c_invoiceline_id = (SELECT BOM_parent_id " +
      "                                                     FROM c_invoiceline " +
      "                                                     WHERE c_invoiceline_id = (select c_invoiceline_id " +
      "                                                    from c_invoiceline " +
      "                                                    where m_inoutline_id = ?)))" +
      "      WHERE m_inoutLine_ID= ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateInvoiceOrder(Connection conn, ConnectionProvider connectionProvider, String mInoutlineId, String cOrderlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_InvoiceLine SET M_InoutLine_id = ?" +
      "      WHERE C_OrderLine_ID= ? " +
      "      AND M_InOutLine_ID IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateC_Order_ID(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Order_id = ?, DATEORDERED = (SELECT DATEORDERED FROM C_ORDER WHERE C_ORDER_ID=?)" +
      "      WHERE M_InOut_ID=? AND NOT EXISTS (" +
      "        SELECT ol.c_order_id FROM M_InOutLine iol" +
      "         JOIN C_OrderLine ol on iol.C_OrderLine_Id = ol.C_OrderLine_Id" +
      "        WHERE iol.M_InOut_Id = ? " +
      "         AND ol.c_order_id != ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int updateC_Invoice_ID(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Invoice_id = ?" +
      "      WHERE M_InOut_ID= ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int deleteC_Order_ID(Connection conn, ConnectionProvider connectionProvider, String mInoutId, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Order_ID=NULL " +
      "      WHERE M_InOut_ID= ?" +
      "      AND C_Order_ID IS NOT NULL " +
      "      AND C_Order_ID <> ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int deleteC_Invoice_ID(Connection conn, ConnectionProvider connectionProvider, String mInoutId, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_InOut SET C_Invoice_ID=NULL " +
      "      WHERE M_InOut_ID= ?" +
      "      AND C_Invoice_ID IS NOT NULL " +
      "      AND C_Invoice_ID <> ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static String multiplyRate(ConnectionProvider connectionProvider, String mProductUOM, String mProduct)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT MULTIPLYRATE FROM C_UOM_CONVERSION WHERE C_UOM_ID = ? AND C_UOM_TO_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUOM);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProduct);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "multiplyrate");
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

  public static String divideRate(ConnectionProvider connectionProvider, String mProduct, String mProductUOM)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DIVIDERATE FROM C_UOM_CONVERSION WHERE C_UOM_ID = ? AND C_UOM_TO_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUOM);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "dividerate");
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

  public static CreateFromShipmentData[] selectcUomIdConversion(ConnectionProvider connectionProvider, String mProductUomId)    throws ServletException {
    return selectcUomIdConversion(connectionProvider, mProductUomId, 0, 0);
  }

  public static CreateFromShipmentData[] selectcUomIdConversion(ConnectionProvider connectionProvider, String mProductUomId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PRODUCT_UOM.C_UOM_ID AS C_UOM_ID_Conversion, COALESCE(BREAKDOWN, 'N') AS BREAKDOWN, STDPRECISION FROM M_PRODUCT_UOM,C_UOM" +
      "      WHERE  M_PRODUCT_UOM.C_UOM_ID = C_UOM.C_UOM_ID " +
      "      AND M_PRODUCT_UOM_ID = ?";

    ResultSet result;
    Vector<CreateFromShipmentData> vector = new Vector<CreateFromShipmentData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);

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
        CreateFromShipmentData objectCreateFromShipmentData = new CreateFromShipmentData();
        objectCreateFromShipmentData.cUomIdConversion = UtilSql.getValue(result, "c_uom_id_conversion");
        objectCreateFromShipmentData.breakdown = UtilSql.getValue(result, "breakdown");
        objectCreateFromShipmentData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectCreateFromShipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromShipmentData);
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
    CreateFromShipmentData objectCreateFromShipmentData[] = new CreateFromShipmentData[vector.size()];
    vector.copyInto(objectCreateFromShipmentData);
    return(objectCreateFromShipmentData);
  }

  public static String countOrders(Connection conn, ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(DISTINCT OL.C_ORDER_ID) AS COUNT" +
      "        FROM M_INOUTLINE MIOL" +
      "            LEFT JOIN C_ORDERLINE OL ON OL.C_ORDERLINE_ID = MIOL.C_ORDERLINE_ID" +
      "        WHERE MIOL.M_INOUT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static String hasSecondaryUOM(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN (SELECT 1 FROM DUAL WHERE EXISTS (SELECT 1 FROM M_PRODUCT_UOM WHERE M_PRODUCT_ID = ? AND ISACTIVE = 'Y')) IS NULL THEN 0 ELSE 1 END) FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case");
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
