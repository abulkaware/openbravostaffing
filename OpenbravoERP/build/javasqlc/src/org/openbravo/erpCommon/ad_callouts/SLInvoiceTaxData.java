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

class SLInvoiceTaxData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLInvoiceTaxData.class);
  private String InitRecordNumber="0";
  public String cBpartnerLocationId;
  public String dateinvoiced;
  public String cProjectId;
  public String iscashvat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("iscashvat"))
      return iscashvat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLInvoiceTaxData[] select(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, cInvoiceId, 0, 0);
  }

  public static SLInvoiceTaxData[] select(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Invoice.C_BPartner_Location_ID, C_Invoice.DateInvoiced, C_Invoice.C_Project_ID," +
      "      C_Invoice.IsCashVat" +
      "      FROM C_Invoice" +
      "      WHERE C_Invoice_ID = ?";

    ResultSet result;
    Vector<SLInvoiceTaxData> vector = new Vector<SLInvoiceTaxData>(0);
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
        SLInvoiceTaxData objectSLInvoiceTaxData = new SLInvoiceTaxData();
        objectSLInvoiceTaxData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectSLInvoiceTaxData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectSLInvoiceTaxData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSLInvoiceTaxData.iscashvat = UtilSql.getValue(result, "iscashvat");
        objectSLInvoiceTaxData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLInvoiceTaxData);
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
    SLInvoiceTaxData objectSLInvoiceTaxData[] = new SLInvoiceTaxData[vector.size()];
    vector.copyInto(objectSLInvoiceTaxData);
    return(objectSLInvoiceTaxData);
  }
}
