//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class TaxRegisterData implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxRegisterData.class);
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
  public static TaxRegisterData[] select(ConnectionProvider connectionProvider, String taxregister_id)    throws ServletException {
    return select(connectionProvider, taxregister_id, 0, 0);
  }

/**
Active Tax Register 
 */
  public static TaxRegisterData[] select(ConnectionProvider connectionProvider, String taxregister_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Client_ID, AD_Org_ID, C_TaxRegister_ID,  C_TaxPayment_ID, LastRegAccumAmt , TaxTotalAmt , C_TaxRegister_Type_ID, Name ,PageNo  " +
      "			FROM C_TAXREGISTER" +
      "			WHERE ISACTIVE='Y'" +
      "			And C_TaxRegister_ID = ?";

    ResultSet result;
    Vector<TaxRegisterData> vector = new Vector<TaxRegisterData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_id);

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
        TaxRegisterData objectTaxRegisterData = new TaxRegisterData();
        objectTaxRegisterData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxRegisterData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxRegisterData.cTaxregisterId = UtilSql.getValue(result, "c_taxregister_id");
        objectTaxRegisterData.cTaxpaymentId = UtilSql.getValue(result, "c_taxpayment_id");
        objectTaxRegisterData.lastregaccumamt = UtilSql.getValue(result, "lastregaccumamt");
        objectTaxRegisterData.taxtotalamt = UtilSql.getValue(result, "taxtotalamt");
        objectTaxRegisterData.cTaxregisterTypeId = UtilSql.getValue(result, "c_taxregister_type_id");
        objectTaxRegisterData.name = UtilSql.getValue(result, "name");
        objectTaxRegisterData.pageno = UtilSql.getValue(result, "pageno");
        objectTaxRegisterData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxRegisterData);
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
    TaxRegisterData objectTaxRegisterData[] = new TaxRegisterData[vector.size()];
    vector.copyInto(objectTaxRegisterData);
    return(objectTaxRegisterData);
  }

/**
select PageNo Prior Period
 */
  public static String selectPageNoPrior(ConnectionProvider connectionProvider, String parTaxRegId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  select coalesce(max(taxreg.pageno),0) " +
      "  from c_taxregister taxreg,c_taxpayment taxpay " +
      "  where " +
      "  	  taxpay.c_taxpayment_id = taxreg.c_taxpayment_id" +
      "  and to_char(taxpay.datefrom,'YYYY') = to_char(now(),'YYYY')" +
      "  and ( taxpay.processed = 'Y' or taxpay.c_taxpayment_id=" +
      "  (select c_taxpayment_id from c_taxregister where c_taxregister_id = ? ) )" +
      "  and 1=1";
    strSql = strSql + ((parTaxRegId==null || parTaxRegId.equals(""))?"":"  and taxreg.c_taxregister_id <> ?   ");

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaxRegId);
      if (parTaxRegId != null && !(parTaxRegId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaxRegId);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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

/**
Update Page No
 */
  public static int updatePageNo(ConnectionProvider connectionProvider, String pageno, String taxregister_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  		update c_taxregister" +
      "  		set pageno = TO_NUMBER(?) " +
      "  		where c_taxregister_id = ?  ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pageno);
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
