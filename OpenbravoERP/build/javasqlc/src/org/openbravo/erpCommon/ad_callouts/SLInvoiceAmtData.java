//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SLInvoiceAmtData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLInvoiceAmtData.class);
  private String InitRecordNumber="0";
  public String stdprecision;
  public String priceprecision;
  public String enforcepricelimit;
  public String mPricelistId;
  public String dateinvoiced;
  public String cBpartnerId;
  public String id;
  public String deliverqty;
  public String invoicerule;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("enforcepricelimit"))
      return enforcepricelimit;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("deliverqty"))
      return deliverqty;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLInvoiceAmtData[] select(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, cInvoiceId, 0, 0);
  }

  public static SLInvoiceAmtData[] select(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.StdPrecision, C_Currency.PricePrecision, M_PriceList.EnforcePriceLimit, M_PriceList.M_PriceList_ID, C_Invoice.dateInvoiced, C_Invoice.C_BPartner_ID, C_Invoice.C_Invoice_ID as id," +
      "      '' deliverqty , '' invoicerule" +
      "      FROM C_Invoice, M_PriceList, C_Currency " +
      "      WHERE C_Invoice.M_PriceList_ID = M_PriceList.M_PriceList_ID" +
      "      AND M_PriceList.C_Currency_ID = C_Currency.C_Currency_ID" +
      "      AND C_Invoice.C_Invoice_ID = ?";

    ResultSet result;
    Vector<SLInvoiceAmtData> vector = new Vector<SLInvoiceAmtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        SLInvoiceAmtData objectSLInvoiceAmtData = new SLInvoiceAmtData();
        objectSLInvoiceAmtData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectSLInvoiceAmtData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectSLInvoiceAmtData.enforcepricelimit = UtilSql.getValue(result, "enforcepricelimit");
        objectSLInvoiceAmtData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSLInvoiceAmtData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectSLInvoiceAmtData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSLInvoiceAmtData.id = UtilSql.getValue(result, "id");
        objectSLInvoiceAmtData.deliverqty = UtilSql.getValue(result, "deliverqty");
        objectSLInvoiceAmtData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSLInvoiceAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLInvoiceAmtData);
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
    SLInvoiceAmtData objectSLInvoiceAmtData[] = new SLInvoiceAmtData[vector.size()];
    vector.copyInto(objectSLInvoiceAmtData);
    return(objectSLInvoiceAmtData);
  }

  public static SLInvoiceAmtData[] selectDeliverQty(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return selectDeliverQty(connectionProvider, cInvoiceId, 0, 0);
  }

  public static SLInvoiceAmtData[] selectDeliverQty(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE WHEN il.M_INOUTLINE_ID IS NULL THEN (l.QtyOrdered-COALESCE(l.QTYINVOICED ,0)) ELSE il.MOVEMENTQTY END) AS deliverqty , o.invoicerule" +
      "      FROM C_ORDERLINE l left join (SELECT M_InOutLine.* FROM M_InOutLine, M_InOut                                      " +
      "      WHERE M_InOut.M_InOut_ID = M_InOutLine.M_InOut_ID                                      " +
      "      AND M_InOutLine.IsInvoiced = 'N'                                      " +
      "      AND M_InOut.Processed='Y') il  on l.C_OrderLine_ID = il.C_OrderLine_ID, C_Order o, c_invoiceline cil" +
      "      WHERE l.C_Order_ID=o.C_Order_ID        " +
      "      AND cil.C_ORDERLINE_id=l.C_ORDERLINE_id" +
      "      AND cil.c_invoiceline_id = ?    ";

    ResultSet result;
    Vector<SLInvoiceAmtData> vector = new Vector<SLInvoiceAmtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        SLInvoiceAmtData objectSLInvoiceAmtData = new SLInvoiceAmtData();
        objectSLInvoiceAmtData.deliverqty = UtilSql.getValue(result, "deliverqty");
        objectSLInvoiceAmtData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSLInvoiceAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLInvoiceAmtData);
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
    SLInvoiceAmtData objectSLInvoiceAmtData[] = new SLInvoiceAmtData[vector.size()];
    vector.copyInto(objectSLInvoiceAmtData);
    return(objectSLInvoiceAmtData);
  }
}
