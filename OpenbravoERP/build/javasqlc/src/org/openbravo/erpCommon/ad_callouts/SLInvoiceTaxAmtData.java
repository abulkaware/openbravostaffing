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

class SLInvoiceTaxAmtData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLInvoiceTaxAmtData.class);
  private String InitRecordNumber="0";
  public String rate;
  public String priceprecision;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rate"))
      return rate;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLInvoiceTaxAmtData[] select(ConnectionProvider connectionProvider, String cTaxId, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, cTaxId, cInvoiceId, 0, 0);
  }

  public static SLInvoiceTaxAmtData[] select(ConnectionProvider connectionProvider, String cTaxId, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select rate, c.priceprecision" +
      "        from c_tax        t," +
      "             c_currency   c," +
      "             c_invoice    i" +
      "        where t.c_tax_id = ?" +
      "        and c.c_currency_id = i.c_currency_id" +
      "        and i.c_invoice_id = ?";

    ResultSet result;
    Vector<SLInvoiceTaxAmtData> vector = new Vector<SLInvoiceTaxAmtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
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
        SLInvoiceTaxAmtData objectSLInvoiceTaxAmtData = new SLInvoiceTaxAmtData();
        objectSLInvoiceTaxAmtData.rate = UtilSql.getValue(result, "rate");
        objectSLInvoiceTaxAmtData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectSLInvoiceTaxAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLInvoiceTaxAmtData);
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
    SLInvoiceTaxAmtData objectSLInvoiceTaxAmtData[] = new SLInvoiceTaxAmtData[vector.size()];
    vector.copyInto(objectSLInvoiceTaxAmtData);
    return(objectSLInvoiceTaxAmtData);
  }
}
