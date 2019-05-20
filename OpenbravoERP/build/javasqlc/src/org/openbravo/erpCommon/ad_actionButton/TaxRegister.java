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

class TaxRegister implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxRegister.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cTaxregisterId;
  public String cTaxpaymentId;
  public String lastregaccumamt;
  public String taxtotalamt;
  public String cTaxregisterTypeId;
  public String name;
  public String pageno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_taxregister_id") || fieldName.equals("cTaxregisterId"))
      return cTaxregisterId;
    else if (fieldName.equalsIgnoreCase("c_taxpayment_id") || fieldName.equals("cTaxpaymentId"))
      return cTaxpaymentId;
    else if (fieldName.equalsIgnoreCase("lastregaccumamt"))
      return lastregaccumamt;
    else if (fieldName.equalsIgnoreCase("taxtotalamt"))
      return taxtotalamt;
    else if (fieldName.equalsIgnoreCase("c_taxregister_type_id") || fieldName.equals("cTaxregisterTypeId"))
      return cTaxregisterTypeId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("pageno"))
      return pageno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Active Tax Register 
 */
  public static TaxRegister[] selectChild(ConnectionProvider connectionProvider, String taxpayment_id)    throws ServletException {
    return selectChild(connectionProvider, taxpayment_id, 0, 0);
  }

/**
Active Tax Register 
 */
  public static TaxRegister[] selectChild(ConnectionProvider connectionProvider, String taxpayment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Client_ID, AD_Org_ID, C_TaxRegister_ID,  C_TaxPayment_ID, LastRegAccumAmt , TaxTotalAmt , C_TaxRegister_Type_ID, Name ,PageNo  " +
      "			FROM C_TAXREGISTER" +
      "			WHERE ISACTIVE='Y'" +
      "			And C_TaxPayment_ID = ?";

    ResultSet result;
    Vector<TaxRegister> vector = new Vector<TaxRegister>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxpayment_id);

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
        TaxRegister objectTaxRegister = new TaxRegister();
        objectTaxRegister.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxRegister.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxRegister.cTaxregisterId = UtilSql.getValue(result, "c_taxregister_id");
        objectTaxRegister.cTaxpaymentId = UtilSql.getValue(result, "c_taxpayment_id");
        objectTaxRegister.lastregaccumamt = UtilSql.getValue(result, "lastregaccumamt");
        objectTaxRegister.taxtotalamt = UtilSql.getValue(result, "taxtotalamt");
        objectTaxRegister.cTaxregisterTypeId = UtilSql.getValue(result, "c_taxregister_type_id");
        objectTaxRegister.name = UtilSql.getValue(result, "name");
        objectTaxRegister.pageno = UtilSql.getValue(result, "pageno");
        objectTaxRegister.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxRegister);
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
    TaxRegister objectTaxRegister[] = new TaxRegister[vector.size()];
    vector.copyInto(objectTaxRegister);
    return(objectTaxRegister);
  }

/**
Active Tax Register 
 */
  public static int insert(ConnectionProvider connectionProvider, String client_id, String org_id, String taxregister_id, String taxpayment_id, String taxregister_type_id, String pageno, String name, String createdby, String updateby)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  		INSERT INTO C_TAXREGISTER " +
      "  		(AD_Client_ID, AD_Org_ID, C_TaxRegister_ID, C_TaxPayment_ID, " +
      "  		C_TaxRegister_Type_ID,PageNo,NAME,ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY)" +
      "  		VALUES " +
      "  		(?,?,?,?," +
      "  		?,TO_NUMBER(?), ? ,'Y', now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxpayment_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_type_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", pageno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateby);

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

/**
Insert Tax Register Lines
 */
  public static int insertLines(ConnectionProvider connectionProvider, String client_id, String org_id, String taxregisterline_id, String taxregister_id, String invoicetax_id, String documentno, String tax_id, String taxbaseamt, String taxamt, String taxundamt, String exemptamt, String novatamt, String totalamt, String invoicedate, String name, String createdby, String updateby)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  		INSERT INTO C_TAXREGISTERLINE " +
      "  		(AD_Client_ID, AD_Org_ID, C_TaxRegisterLine_ID, C_TaxRegister_ID, C_InvoiceTax_ID, DocumentNO,C_Tax_ID," +
      "  		TAXBASEAMT,TAXAMT,TAXUNDAMT,EXEMPTAMT,NOVATAMT,TOTALAMT,INVOICEDATE, " +
      "  		NAME,ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY)" +
      "  		VALUES " +
      "  		(?,?,?,?,?,?,?," +
      "  		TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?),TO_DATE(?) , " +
      "  		?,'Y', now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregisterline_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicetax_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tax_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", taxbaseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", taxundamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", exemptamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", novatamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, "0", totalamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateby);

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

/**
Update Tax Register Totals
 */
  public static int updateTaxTotalAmt(ConnectionProvider connectionProvider, String taxregister_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  		UPDATE C_TAXREGISTER " +
      "  		SET TAXTOTALAMT =" +
      "  		coalesce((SELECT SUM(TAXAMT) FROM C_TAXREGISTERLINE WHERE C_TAXREGISTER_id = ?),0)" +
      "  	    WHERE C_TAXREGISTER_id = ? 		";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);

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

/**
Update Tax Register Totals
 */
  public static int updateRegAccumAmt(ConnectionProvider connectionProvider, String taxregister_id, String taxregistertype_id, String datefrom, String adUserOrg)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  	   UPDATE C_TAXREGISTER " +
      "  	   SET LASTREGACCUMAMT =  " +
      "  	   COALESCE( " +
      "  	   (SELECT TAXTOTALAMT FROM C_TAXREGISTER WHERE C_TAXREGISTER_ID=" +
      "  	   (SELECT MAX(C_TAXREGISTER_ID) FROM C_TAXREGISTER, C_TAXPAYMENT" +
      "  	   WHERE C_TAXREGISTER_ID <> ?" +
      "  	   AND C_TAXREGISTER_TYPE_ID = ?" +
      "  	   AND C_TAXREGISTER.C_TAXPAYMENT_ID=C_TAXPAYMENT.C_TAXPAYMENT_ID" +
      "  	   AND C_TAXPAYMENT.DATETO = TO_DATE( ? )-1" +
      "  	   AND C_TAXPAYMENT.PROCESSED='Y'" +
      "  	   AND C_TAXPAYMENT.GENERATEPAYMENT='N'" +
      "  	   AND C_TAXREGISTER.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")))" +
      "  	   ,0)" +
      "  	   +" +
      "  	   COALESCE( " +
      "  	   (SELECT LASTREGACCUMAMT FROM C_TAXREGISTER WHERE C_TAXREGISTER_ID=" +
      "  	   (SELECT MAX(C_TAXREGISTER_ID) FROM C_TAXREGISTER, C_TAXPAYMENT" +
      "  	   WHERE C_TAXREGISTER_ID <> ?" +
      "  	   AND C_TAXREGISTER_TYPE_ID = ?" +
      "  	   AND C_TAXREGISTER.C_TAXPAYMENT_ID=C_TAXPAYMENT.C_TAXPAYMENT_ID" +
      "  	   AND C_TAXPAYMENT.DATETO = TO_DATE( ? )-1" +
      "  	   AND C_TAXPAYMENT.PROCESSED='Y'" +
      "  	   AND C_TAXPAYMENT.GENERATEPAYMENT='N'" +
      "  	   AND  C_TAXREGISTER.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")))" +
      "  	   ,0)" +
      "  	   WHERE C_TAXREGISTER_id = ?		";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregistertype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregistertype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);

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
}
