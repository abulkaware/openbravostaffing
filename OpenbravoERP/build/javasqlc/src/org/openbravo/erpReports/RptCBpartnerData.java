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

class RptCBpartnerData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnerData.class);
  private String InitRecordNumber="0";
  public String cBpartnerId;
  public String value;
  public String isactive;
  public String created;
  public String updated;
  public String name;
  public String name2;
  public String groupname;
  public String taxid;
  public String accountno;
  public String isemployee;
  public String issalesrep;
  public String iscustomer;
  public String isvendor;
  public String seqno;
  public String cascade;
  public String discount;
  public String qty;
  public String classTree;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("groupname"))
      return groupname;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("isemployee"))
      return isemployee;
    else if (fieldName.equalsIgnoreCase("issalesrep"))
      return issalesrep;
    else if (fieldName.equalsIgnoreCase("iscustomer"))
      return iscustomer;
    else if (fieldName.equalsIgnoreCase("isvendor"))
      return isvendor;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("cascade"))
      return cascade;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("class_tree") || fieldName.equals("classTree"))
      return classTree;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnerData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, adLanguage, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT BP.C_BPARTNER_ID, BP.VALUE, AD_MESSAGE_GET2(BP.ISACTIVE, ?) AS ISACTIVE, TO_DATE(BP.CREATED) AS CREATED, TO_DATE(BP.UPDATED) AS UPDATED, " +
      "        BP.NAME, BP.NAME2, G.NAME AS GROUPNAME, BP.TAXID, '' AS ACCOUNTNO, AD_MESSAGE_GET2(BP.ISEMPLOYEE, ?) AS ISEMPLOYEE, AD_MESSAGE_GET2(BP.ISSALESREP, ?) AS ISSALESREP, " +
      "        ISCUSTOMER, ISVENDOR, '' AS SEQNO, '' AS CASCADE, '' AS DISCOUNT, '' AS QTY, '' AS CLASS_TREE" +
      "        FROM C_BPARTNER BP, C_BP_GROUP G" +
      "        WHERE BP.C_BP_GROUP_ID = G.C_BP_GROUP_ID";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND BP.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<RptCBpartnerData> vector = new Vector<RptCBpartnerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerData objectRptCBpartnerData = new RptCBpartnerData();
        objectRptCBpartnerData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRptCBpartnerData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerData.isactive = UtilSql.getValue(result, "isactive");
        objectRptCBpartnerData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectRptCBpartnerData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectRptCBpartnerData.name = UtilSql.getValue(result, "name");
        objectRptCBpartnerData.name2 = UtilSql.getValue(result, "name2");
        objectRptCBpartnerData.groupname = UtilSql.getValue(result, "groupname");
        objectRptCBpartnerData.taxid = UtilSql.getValue(result, "taxid");
        objectRptCBpartnerData.accountno = UtilSql.getValue(result, "accountno");
        objectRptCBpartnerData.isemployee = UtilSql.getValue(result, "isemployee");
        objectRptCBpartnerData.issalesrep = UtilSql.getValue(result, "issalesrep");
        objectRptCBpartnerData.iscustomer = UtilSql.getValue(result, "iscustomer");
        objectRptCBpartnerData.isvendor = UtilSql.getValue(result, "isvendor");
        objectRptCBpartnerData.seqno = UtilSql.getValue(result, "seqno");
        objectRptCBpartnerData.cascade = UtilSql.getValue(result, "cascade");
        objectRptCBpartnerData.discount = UtilSql.getValue(result, "discount");
        objectRptCBpartnerData.qty = UtilSql.getValue(result, "qty");
        objectRptCBpartnerData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerData.position = Long.toString(countRecord);
        objectRptCBpartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerData);
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
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[vector.size()];
    vector.copyInto(objectRptCBpartnerData);
    return(objectRptCBpartnerData);
  }

  public static RptCBpartnerData[] set()    throws ServletException {
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[1];
    objectRptCBpartnerData[0] = new RptCBpartnerData();
    objectRptCBpartnerData[0].cBpartnerId = "";
    objectRptCBpartnerData[0].value = "";
    objectRptCBpartnerData[0].isactive = "";
    objectRptCBpartnerData[0].created = "";
    objectRptCBpartnerData[0].updated = "";
    objectRptCBpartnerData[0].name = "";
    objectRptCBpartnerData[0].name2 = "";
    objectRptCBpartnerData[0].groupname = "";
    objectRptCBpartnerData[0].taxid = "";
    objectRptCBpartnerData[0].accountno = "";
    objectRptCBpartnerData[0].isemployee = "";
    objectRptCBpartnerData[0].issalesrep = "";
    objectRptCBpartnerData[0].iscustomer = "";
    objectRptCBpartnerData[0].isvendor = "";
    objectRptCBpartnerData[0].seqno = "";
    objectRptCBpartnerData[0].cascade = "";
    objectRptCBpartnerData[0].discount = "";
    objectRptCBpartnerData[0].qty = "";
    objectRptCBpartnerData[0].classTree = "";
    return objectRptCBpartnerData;
  }

  public static RptCBpartnerData[] selectAccount(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectAccount(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerData[] selectAccount(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A.ACCOUNTNO, A.BANK_NAME AS NAME" +
      "        FROM C_BP_BANKACCOUNT A";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           WHERE C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<RptCBpartnerData> vector = new Vector<RptCBpartnerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerData objectRptCBpartnerData = new RptCBpartnerData();
        objectRptCBpartnerData.accountno = UtilSql.getValue(result, "accountno");
        objectRptCBpartnerData.name = UtilSql.getValue(result, "name");
        objectRptCBpartnerData.position = Long.toString(countRecord);
        objectRptCBpartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerData);
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
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[vector.size()];
    vector.copyInto(objectRptCBpartnerData);
    return(objectRptCBpartnerData);
  }

  public static RptCBpartnerData[] selectShipper(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectShipper(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerData[] selectShipper(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT W.NAME, WS.SEQNO" +
      "        FROM M_WAREHOUSE_SHIPPER WS, M_WAREHOUSE W" +
      "        WHERE WS.M_WAREHOUSE_ID = W.M_WAREHOUSE_ID";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND WS.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<RptCBpartnerData> vector = new Vector<RptCBpartnerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerData objectRptCBpartnerData = new RptCBpartnerData();
        objectRptCBpartnerData.name = UtilSql.getValue(result, "name");
        objectRptCBpartnerData.seqno = UtilSql.getValue(result, "seqno");
        objectRptCBpartnerData.position = Long.toString(countRecord);
        objectRptCBpartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerData);
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
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[vector.size()];
    vector.copyInto(objectRptCBpartnerData);
    return(objectRptCBpartnerData);
  }

  public static RptCBpartnerData[] selectDiscount(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectDiscount(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerData[] selectDiscount(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE BD.CASCADE WHEN 'Y' THEN 'Si' ELSE 'No' END) AS CASCADE, BD.LINE AS SEQNO, D.NAME, D.DISCOUNT" +
      "        FROM C_BPARTNER_DISCOUNT BD, C_DISCOUNT D" +
      "        WHERE BD.C_DISCOUNT_ID = D.C_DISCOUNT_ID";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND BD.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      "        ORDER BY SEQNO";

    ResultSet result;
    Vector<RptCBpartnerData> vector = new Vector<RptCBpartnerData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerData objectRptCBpartnerData = new RptCBpartnerData();
        objectRptCBpartnerData.cascade = UtilSql.getValue(result, "cascade");
        objectRptCBpartnerData.seqno = UtilSql.getValue(result, "seqno");
        objectRptCBpartnerData.name = UtilSql.getValue(result, "name");
        objectRptCBpartnerData.discount = UtilSql.getValue(result, "discount");
        objectRptCBpartnerData.position = Long.toString(countRecord);
        objectRptCBpartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerData);
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
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[vector.size()];
    vector.copyInto(objectRptCBpartnerData);
    return(objectRptCBpartnerData);
  }

  public static RptCBpartnerData[] selectTemplate(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId)    throws ServletException {
    return selectTemplate(connectionProvider, adLanguage, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerData[] selectTemplate(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_REF_LIST_V.VALUE AS VALUE, AD_REF_LIST_V.NAME AS NAME2, 'datawarehouseclose' AS CLASS_TREE" +
      "        FROM M_PRODUCT_TEMPLATE PT, AD_REF_LIST_V " +
      "        WHERE PT.TYPE_TEMPLATE = AD_REF_LIST_V.VALUE" +
      "        AND AD_REF_LIST_V.AD_LANGUAGE = ?" +
      "        AND AD_REF_LIST_V.AD_REFERENCE_ID = '800009'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND PT.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      "        ORDER BY name2";

    ResultSet result;
    Vector<RptCBpartnerData> vector = new Vector<RptCBpartnerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerData objectRptCBpartnerData = new RptCBpartnerData();
        objectRptCBpartnerData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerData.name2 = UtilSql.getValue(result, "name2");
        objectRptCBpartnerData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerData.position = Long.toString(countRecord);
        objectRptCBpartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerData);
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
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[vector.size()];
    vector.copyInto(objectRptCBpartnerData);
    return(objectRptCBpartnerData);
  }

  public static RptCBpartnerData[] selectTemplateDetail(ConnectionProvider connectionProvider, String cBpartnerId, String typeTemplate)    throws ServletException {
    return selectTemplateDetail(connectionProvider, cBpartnerId, typeTemplate, 0, 0);
  }

  public static RptCBpartnerData[] selectTemplateDetail(ConnectionProvider connectionProvider, String cBpartnerId, String typeTemplate, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.NAME, PT.QTY" +
      "        FROM M_PRODUCT_TEMPLATE PT, M_PRODUCT P" +
      "        WHERE PT.M_PRODUCT_ID = P.M_PRODUCT_ID" +
      "        AND PT.C_BPARTNER_ID = ?" +
      "        AND PT.TYPE_TEMPLATE = ?" +
      "        ORDER BY P.NAME";

    ResultSet result;
    Vector<RptCBpartnerData> vector = new Vector<RptCBpartnerData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeTemplate);

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
        RptCBpartnerData objectRptCBpartnerData = new RptCBpartnerData();
        objectRptCBpartnerData.name = UtilSql.getValue(result, "name");
        objectRptCBpartnerData.qty = UtilSql.getValue(result, "qty");
        objectRptCBpartnerData.position = Long.toString(countRecord);
        objectRptCBpartnerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerData);
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
    RptCBpartnerData objectRptCBpartnerData[] = new RptCBpartnerData[vector.size()];
    vector.copyInto(objectRptCBpartnerData);
    return(objectRptCBpartnerData);
  }
}
