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

class SLOrderDocTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLOrderDocTypeData.class);
  private String InitRecordNumber="0";
  public String docsubtypeso;
  public String isdocnocontrolled;
  public String currentnext;
  public String currentnextsys;
  public String adSequenceId;
  public String issotrx;
  public String paymentrule;
  public String cPaymenttermId;
  public String invoicerule;
  public String deliveryrule;
  public String deliveryviarule;
  public String paymentrulepo;
  public String poPaymenttermId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("docsubtypeso"))
      return docsubtypeso;
    else if (fieldName.equalsIgnoreCase("isdocnocontrolled"))
      return isdocnocontrolled;
    else if (fieldName.equalsIgnoreCase("currentnext"))
      return currentnext;
    else if (fieldName.equalsIgnoreCase("currentnextsys"))
      return currentnextsys;
    else if (fieldName.equalsIgnoreCase("ad_sequence_id") || fieldName.equals("adSequenceId"))
      return adSequenceId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_id") || fieldName.equals("poPaymenttermId"))
      return poPaymenttermId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLOrderDocTypeData[] select(ConnectionProvider connectionProvider, String cDoctypeId)    throws ServletException {
    return select(connectionProvider, cDoctypeId, 0, 0);
  }

  public static SLOrderDocTypeData[] select(ConnectionProvider connectionProvider, String cDoctypeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(d.DocSubTypeSO, '--') as DocSubTypeSO," +
      "        d.IsDocNoControlled, s.CurrentNext, s.CurrentNextSys, " +
      "        s.AD_Sequence_ID, d.IsSOTrx, " +
      "        '' as PaymentRule, '' as C_PaymentTerm_ID," +
      "        '' as InvoiceRule, '' as DeliveryRule," +
      "        '' as DeliveryViaRule," +
      "        '' as PaymentRulePO, '' as PO_PaymentTerm_ID" +
      "        FROM C_DocType d left join AD_Sequence s on d.DocNoSequence_ID=s.AD_Sequence_ID" +
      "        WHERE C_DocType_ID = ? ";

    ResultSet result;
    Vector<SLOrderDocTypeData> vector = new Vector<SLOrderDocTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);

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
        SLOrderDocTypeData objectSLOrderDocTypeData = new SLOrderDocTypeData();
        objectSLOrderDocTypeData.docsubtypeso = UtilSql.getValue(result, "docsubtypeso");
        objectSLOrderDocTypeData.isdocnocontrolled = UtilSql.getValue(result, "isdocnocontrolled");
        objectSLOrderDocTypeData.currentnext = UtilSql.getValue(result, "currentnext");
        objectSLOrderDocTypeData.currentnextsys = UtilSql.getValue(result, "currentnextsys");
        objectSLOrderDocTypeData.adSequenceId = UtilSql.getValue(result, "ad_sequence_id");
        objectSLOrderDocTypeData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSLOrderDocTypeData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectSLOrderDocTypeData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectSLOrderDocTypeData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSLOrderDocTypeData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectSLOrderDocTypeData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectSLOrderDocTypeData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectSLOrderDocTypeData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectSLOrderDocTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderDocTypeData);
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
    SLOrderDocTypeData objectSLOrderDocTypeData[] = new SLOrderDocTypeData[vector.size()];
    vector.copyInto(objectSLOrderDocTypeData);
    return(objectSLOrderDocTypeData);
  }

  public static SLOrderDocTypeData[] BPartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return BPartner(connectionProvider, cBpartnerId, 0, 0);
  }

  public static SLOrderDocTypeData[] BPartner(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PaymentRule,C_PaymentTerm_ID," +
      "        InvoiceRule,DeliveryRule," +
      "        DeliveryViaRule," +
      "        PaymentRulePO,PO_PaymentTerm_ID" +
      "        FROM C_BPartner" +
      "        WHERE C_BPartner_ID=?";

    ResultSet result;
    Vector<SLOrderDocTypeData> vector = new Vector<SLOrderDocTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        SLOrderDocTypeData objectSLOrderDocTypeData = new SLOrderDocTypeData();
        objectSLOrderDocTypeData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectSLOrderDocTypeData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectSLOrderDocTypeData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSLOrderDocTypeData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectSLOrderDocTypeData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectSLOrderDocTypeData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectSLOrderDocTypeData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectSLOrderDocTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLOrderDocTypeData);
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
    SLOrderDocTypeData objectSLOrderDocTypeData[] = new SLOrderDocTypeData[vector.size()];
    vector.copyInto(objectSLOrderDocTypeData);
    return(objectSLOrderDocTypeData);
  }

  public static String selectOldDocSubType(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DOCSUBTYPESO FROM C_DOCTYPE" +
      "      WHERE C_DOCTYPE_ID IN (SELECT C_DOCTYPETARGET_ID FROM C_ORDER WHERE C_ORDER_ID = ?)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "docsubtypeso");
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

  public static String selectOldDocNo(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DocumentNo FROM C_ORDER WHERE C_ORDER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "documentno");
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

  public static String selectOldDocTypeTargetId(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_doctypetarget_id FROM C_ORDER WHERE C_ORDER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctypetarget_id");
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
