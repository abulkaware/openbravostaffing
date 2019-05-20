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

class SEExpenseProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEExpenseProductData.class);
  private String InitRecordNumber="0";
  public String pricestd;
  public String pricelist;
  public String pricelimit;
  public String cUomId;
  public String validfrom;
  public String cCurrencyId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEExpenseProductData[] select(ConnectionProvider connectionProvider, String MProductID, String MPriceListID)    throws ServletException {
    return select(connectionProvider, MProductID, MPriceListID, 0, 0);
  }

  public static SEExpenseProductData[] select(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID)  AS PriceStd," +
      "        M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID)  AS PriceList," +
      "        M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID)  AS PriceLimit," +
      "        p.C_UOM_ID,pv.ValidFrom,pl.C_Currency_ID " +
      "        FROM M_Product p, M_ProductPrice pp, M_Pricelist pl, M_PriceList_Version pv " +
      "        WHERE p.M_Product_ID=pp.M_Product_ID" +
      "        AND pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID" +
      "        AND pv.M_PriceList_ID=pl.M_PriceList_ID" +
      "        AND pv.IsActive='Y'" +
      "        AND p.M_Product_ID = ?" +
      "        AND pl.M_PriceList_ID = ?" +
      "        ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<SEExpenseProductData> vector = new Vector<SEExpenseProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPriceListID);

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
        SEExpenseProductData objectSEExpenseProductData = new SEExpenseProductData();
        objectSEExpenseProductData.pricestd = UtilSql.getValue(result, "pricestd");
        objectSEExpenseProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSEExpenseProductData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectSEExpenseProductData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectSEExpenseProductData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectSEExpenseProductData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSEExpenseProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEExpenseProductData);
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
    SEExpenseProductData objectSEExpenseProductData[] = new SEExpenseProductData[vector.size()];
    vector.copyInto(objectSEExpenseProductData);
    return(objectSEExpenseProductData);
  }

  public static SEExpenseProductData[] selectBasePriceList(ConnectionProvider connectionProvider, String MProductID, String MPriceListID)    throws ServletException {
    return selectBasePriceList(connectionProvider, MProductID, MPriceListID, 0, 0);
  }

  public static SEExpenseProductData[] selectBasePriceList(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceStd," +
      "        M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID)  AS PriceList," +
      "        M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID)  AS PriceLimit," +
      "        p.C_UOM_ID,pv.ValidFrom,pl.C_Currency_ID " +
      "        FROM M_Product p, M_ProductPrice pp, M_Pricelist pl, M_Pricelist bpl, M_PriceList_Version pv" +
      "        WHERE p.M_Product_ID=pp.M_Product_ID" +
      "        AND pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID" +
      "        AND pv.M_PriceList_ID=bpl.M_PriceList_ID" +
      "        AND pv.IsActive='Y'" +
      "        AND bpl.M_PriceList_ID=pl.BasePriceList_ID" +
      "        AND p.M_Product_ID=?" +
      "        AND pl.M_PriceList_ID=?" +
      "        ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<SEExpenseProductData> vector = new Vector<SEExpenseProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPriceListID);

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
        SEExpenseProductData objectSEExpenseProductData = new SEExpenseProductData();
        objectSEExpenseProductData.pricestd = UtilSql.getValue(result, "pricestd");
        objectSEExpenseProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSEExpenseProductData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectSEExpenseProductData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectSEExpenseProductData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectSEExpenseProductData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSEExpenseProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEExpenseProductData);
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
    SEExpenseProductData objectSEExpenseProductData[] = new SEExpenseProductData[vector.size()];
    vector.copyInto(objectSEExpenseProductData);
    return(objectSEExpenseProductData);
  }

  public static String priceList(ConnectionProvider connectionProvider, String sTimeexpenseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PO_PRICELIST_ID" +
      "        FROM S_TIMEEXPENSE, C_BPARTNER" +
      "        WHERE S_TIMEEXPENSE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "        AND S_TIMEEXPENSE.S_TIMEEXPENSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeexpenseId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "po_pricelist_id");
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

  public static String selectUOM(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_UOM_ID" +
      "        FROM M_PRODUCT" +
      "        WHERE M_PRODUCT_ID = ?";

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
        strReturn = UtilSql.getValue(result, "c_uom_id");
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

  public static String selectConvertedAmt(ConnectionProvider connectionProvider, String expenseAmount, String currencyFrom, String currencyTo, String dateExpense, String client, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_currency_convert(TO_NUMBER(?),?,?,TO_DATE(?),null, ?,?) from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseAmount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateExpense);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_convert");
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

  public static String selectPrecision(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PRICEPRECISION " +
      "        FROM C_CURRENCY C" +
      "        WHERE C.C_CURRENCY_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "priceprecision");
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

  public static String selectReportDate(ConnectionProvider connectionProvider, String sTimeExpenseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TO_CHAR(S.DATEREPORT) " +
      "		FROM S_TIMEEXPENSE S" +
      "		WHERE S.S_TIMEEXPENSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sTimeExpenseId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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
