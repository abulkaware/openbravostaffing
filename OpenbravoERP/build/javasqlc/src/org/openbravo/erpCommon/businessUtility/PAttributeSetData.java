//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.businessUtility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class PAttributeSetData implements FieldProvider {
static Logger log4j = Logger.getLogger(PAttributeSetData.class);
  private String InitRecordNumber="0";
  public String mAttributesetId;
  public String name;
  public String description;
  public String guaranteedays;
  public String isguaranteedate;
  public String islot;
  public String isserno;
  public String mLotctlId;
  public String mSernoctlId;
  public String islist;
  public String elementname;
  public String mAttributeId;
  public String isinstanceattribute;
  public String mAttributesetinstanceId;
  public String guaranteedate;
  public String lot;
  public String serno;
  public String mAttributevalueId;
  public String value;
  public String attrsetvaluetype;
  public String ismandatory;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_attributeset_id") || fieldName.equals("mAttributesetId"))
      return mAttributesetId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("isguaranteedate"))
      return isguaranteedate;
    else if (fieldName.equalsIgnoreCase("islot"))
      return islot;
    else if (fieldName.equalsIgnoreCase("isserno"))
      return isserno;
    else if (fieldName.equalsIgnoreCase("m_lotctl_id") || fieldName.equals("mLotctlId"))
      return mLotctlId;
    else if (fieldName.equalsIgnoreCase("m_sernoctl_id") || fieldName.equals("mSernoctlId"))
      return mSernoctlId;
    else if (fieldName.equalsIgnoreCase("islist"))
      return islist;
    else if (fieldName.equalsIgnoreCase("elementname"))
      return elementname;
    else if (fieldName.equalsIgnoreCase("m_attribute_id") || fieldName.equals("mAttributeId"))
      return mAttributeId;
    else if (fieldName.equalsIgnoreCase("isinstanceattribute"))
      return isinstanceattribute;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
    else if (fieldName.equalsIgnoreCase("serno"))
      return serno;
    else if (fieldName.equalsIgnoreCase("m_attributevalue_id") || fieldName.equals("mAttributevalueId"))
      return mAttributevalueId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("attrsetvaluetype"))
      return attrsetvaluetype;
    else if (fieldName.equalsIgnoreCase("ismandatory"))
      return ismandatory;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PAttributeSetData[] select(ConnectionProvider connectionProvider, String mAttributesetId)    throws ServletException {
    return select(connectionProvider, mAttributesetId, 0, 0);
  }

  public static PAttributeSetData[] select(ConnectionProvider connectionProvider, String mAttributesetId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_S.M_ATTRIBUTESET_ID, A_S.NAME, A_S.DESCRIPTION, A_S.GUARANTEEDAYS, A_S.ISGUARANTEEDATE, A_S.ISLOT, A_S.ISSERNO, " +
      "        A_S.M_LOTCTL_ID, A_S.M_SERNOCTL_ID, A.ISLIST, A.NAME AS ELEMENTNAME, A.M_ATTRIBUTE_ID, " +
      "        A.ISINSTANCEATTRIBUTE, '' AS M_ATTRIBUTESETINSTANCE_ID, '' as GUARANTEEDATE, '' as LOT, '' as SERNO, " +
      "        '' as M_ATTRIBUTEVALUE_ID, '' as VALUE, '' AS ATTRSETVALUETYPE, A.ISMANDATORY " +
      "        FROM M_ATTRIBUTESET A_S left join M_ATTRIBUTEUSE A_U on a_s.M_ATTRIBUTESET_ID = a_u.M_ATTRIBUTESET_ID" +
      "                                left join M_ATTRIBUTE A on A_U.M_ATTRIBUTE_ID = A.M_ATTRIBUTE_ID" +
      "                                                        and A_U.ISACTIVE = 'Y'" +
      "        WHERE  A_S.ISACTIVE = 'Y'" +
      "        AND A_S.M_ATTRIBUTESET_ID = ? " +
      "        ORDER BY A_U.SEQNO";

    ResultSet result;
    Vector<PAttributeSetData> vector = new Vector<PAttributeSetData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);

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
        PAttributeSetData objectPAttributeSetData = new PAttributeSetData();
        objectPAttributeSetData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectPAttributeSetData.name = UtilSql.getValue(result, "name");
        objectPAttributeSetData.description = UtilSql.getValue(result, "description");
        objectPAttributeSetData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectPAttributeSetData.isguaranteedate = UtilSql.getValue(result, "isguaranteedate");
        objectPAttributeSetData.islot = UtilSql.getValue(result, "islot");
        objectPAttributeSetData.isserno = UtilSql.getValue(result, "isserno");
        objectPAttributeSetData.mLotctlId = UtilSql.getValue(result, "m_lotctl_id");
        objectPAttributeSetData.mSernoctlId = UtilSql.getValue(result, "m_sernoctl_id");
        objectPAttributeSetData.islist = UtilSql.getValue(result, "islist");
        objectPAttributeSetData.elementname = UtilSql.getValue(result, "elementname");
        objectPAttributeSetData.mAttributeId = UtilSql.getValue(result, "m_attribute_id");
        objectPAttributeSetData.isinstanceattribute = UtilSql.getValue(result, "isinstanceattribute");
        objectPAttributeSetData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectPAttributeSetData.guaranteedate = UtilSql.getValue(result, "guaranteedate");
        objectPAttributeSetData.lot = UtilSql.getValue(result, "lot");
        objectPAttributeSetData.serno = UtilSql.getValue(result, "serno");
        objectPAttributeSetData.mAttributevalueId = UtilSql.getValue(result, "m_attributevalue_id");
        objectPAttributeSetData.value = UtilSql.getValue(result, "value");
        objectPAttributeSetData.attrsetvaluetype = UtilSql.getValue(result, "attrsetvaluetype");
        objectPAttributeSetData.ismandatory = UtilSql.getValue(result, "ismandatory");
        objectPAttributeSetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPAttributeSetData);
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
    PAttributeSetData objectPAttributeSetData[] = new PAttributeSetData[vector.size()];
    vector.copyInto(objectPAttributeSetData);
    return(objectPAttributeSetData);
  }

  public static PAttributeSetData[] set()    throws ServletException {
    PAttributeSetData objectPAttributeSetData[] = new PAttributeSetData[1];
    objectPAttributeSetData[0] = new PAttributeSetData();
    objectPAttributeSetData[0].mAttributesetId = "";
    objectPAttributeSetData[0].name = "";
    objectPAttributeSetData[0].description = "";
    objectPAttributeSetData[0].guaranteedays = "";
    objectPAttributeSetData[0].isguaranteedate = "";
    objectPAttributeSetData[0].islot = "";
    objectPAttributeSetData[0].isserno = "";
    objectPAttributeSetData[0].mLotctlId = "";
    objectPAttributeSetData[0].mSernoctlId = "";
    objectPAttributeSetData[0].islist = "";
    objectPAttributeSetData[0].elementname = "";
    objectPAttributeSetData[0].mAttributeId = "";
    objectPAttributeSetData[0].isinstanceattribute = "";
    objectPAttributeSetData[0].mAttributesetinstanceId = "";
    objectPAttributeSetData[0].guaranteedate = "";
    objectPAttributeSetData[0].lot = "";
    objectPAttributeSetData[0].serno = "";
    objectPAttributeSetData[0].mAttributevalueId = "";
    objectPAttributeSetData[0].value = "";
    objectPAttributeSetData[0].attrsetvaluetype = "";
    objectPAttributeSetData[0].ismandatory = "";
    return objectPAttributeSetData;
  }

  public static PAttributeSetData[] selectProductAttr(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    return selectProductAttr(connectionProvider, mProductId, 0, 0);
  }

  public static PAttributeSetData[] selectProductAttr(ConnectionProvider connectionProvider, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT P.m_attributeset_id, P.m_attributesetinstance_id, P.attrsetvaluetype, M.DESCRIPTION " +
      "         FROM M_PRODUCT P left join M_ATTRIBUTESETINSTANCE M on P.M_ATTRIBUTESETINSTANCE_ID = M.M_ATTRIBUTESETINSTANCE_ID" +
      "         WHERE P.m_product_id=?";

    ResultSet result;
    Vector<PAttributeSetData> vector = new Vector<PAttributeSetData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
        PAttributeSetData objectPAttributeSetData = new PAttributeSetData();
        objectPAttributeSetData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectPAttributeSetData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectPAttributeSetData.attrsetvaluetype = UtilSql.getValue(result, "attrsetvaluetype");
        objectPAttributeSetData.description = UtilSql.getValue(result, "description");
        objectPAttributeSetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPAttributeSetData);
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
    PAttributeSetData objectPAttributeSetData[] = new PAttributeSetData[vector.size()];
    vector.copyInto(objectPAttributeSetData);
    return(objectPAttributeSetData);
  }
}
