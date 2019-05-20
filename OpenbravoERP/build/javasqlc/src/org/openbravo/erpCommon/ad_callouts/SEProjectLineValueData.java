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

class SEProjectLineValueData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEProjectLineValueData.class);
  private String InitRecordNumber="0";
  public String value;
  public String name;
  public String description;
  public String project;
  public String pricelistVersion;
  public String pricelist;
  public String warehouse;
  public String bplocation;
  public String projcat;
  public String plannedprice;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("project"))
      return project;
    else if (fieldName.equalsIgnoreCase("pricelist_version") || fieldName.equals("pricelistVersion"))
      return pricelistVersion;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("warehouse"))
      return warehouse;
    else if (fieldName.equalsIgnoreCase("bplocation"))
      return bplocation;
    else if (fieldName.equalsIgnoreCase("projcat"))
      return projcat;
    else if (fieldName.equalsIgnoreCase("plannedprice"))
      return plannedprice;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEProjectLineValueData[] select(ConnectionProvider connectionProvider, String product)    throws ServletException {
    return select(connectionProvider, product, 0, 0);
  }

  public static SEProjectLineValueData[] select(ConnectionProvider connectionProvider, String product, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select value, name, description, '' as project, '' as pricelist_version, '' as pricelist, '' as warehouse, '' as bplocation, '' as projcat, '' as plannedprice" +
      "        from m_product " +
      "        where m_product_ID = ?";

    ResultSet result;
    Vector<SEProjectLineValueData> vector = new Vector<SEProjectLineValueData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);

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
        SEProjectLineValueData objectSEProjectLineValueData = new SEProjectLineValueData();
        objectSEProjectLineValueData.value = UtilSql.getValue(result, "value");
        objectSEProjectLineValueData.name = UtilSql.getValue(result, "name");
        objectSEProjectLineValueData.description = UtilSql.getValue(result, "description");
        objectSEProjectLineValueData.project = UtilSql.getValue(result, "project");
        objectSEProjectLineValueData.pricelistVersion = UtilSql.getValue(result, "pricelist_version");
        objectSEProjectLineValueData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSEProjectLineValueData.warehouse = UtilSql.getValue(result, "warehouse");
        objectSEProjectLineValueData.bplocation = UtilSql.getValue(result, "bplocation");
        objectSEProjectLineValueData.projcat = UtilSql.getValue(result, "projcat");
        objectSEProjectLineValueData.plannedprice = UtilSql.getValue(result, "plannedprice");
        objectSEProjectLineValueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEProjectLineValueData);
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
    SEProjectLineValueData objectSEProjectLineValueData[] = new SEProjectLineValueData[vector.size()];
    vector.copyInto(objectSEProjectLineValueData);
    return(objectSEProjectLineValueData);
  }

  public static SEProjectLineValueData[] selectProject(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    return selectProject(connectionProvider, cProjectId, 0, 0);
  }

  public static SEProjectLineValueData[] selectProject(ConnectionProvider connectionProvider, String cProjectId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Project.Projectcategory as projcat, C_Project.M_Pricelist_ID as pricelist, C_Project.M_Warehouse_Id as warehouse, C_Project.C_BPartner_Location_Id as bplocation" +
      "      FROM C_Project" +
      "      WHERE C_Project.C_Project_ID = ?";

    ResultSet result;
    Vector<SEProjectLineValueData> vector = new Vector<SEProjectLineValueData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
        SEProjectLineValueData objectSEProjectLineValueData = new SEProjectLineValueData();
        objectSEProjectLineValueData.projcat = UtilSql.getValue(result, "projcat");
        objectSEProjectLineValueData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSEProjectLineValueData.warehouse = UtilSql.getValue(result, "warehouse");
        objectSEProjectLineValueData.bplocation = UtilSql.getValue(result, "bplocation");
        objectSEProjectLineValueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEProjectLineValueData);
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
    SEProjectLineValueData objectSEProjectLineValueData[] = new SEProjectLineValueData[vector.size()];
    vector.copyInto(objectSEProjectLineValueData);
    return(objectSEProjectLineValueData);
  }

  public static String selectPhaseProject(ConnectionProvider connectionProvider, String cPhaseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_projectphase.c_project_id" +
      "      FROM c_projectphase" +
      "      WHERE c_projectphase.c_projectphase_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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

  public static String selectPlannedPrice(ConnectionProvider connectionProvider, String mPriceListVersionId, String mProductId, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ROUND((SELECT COALESCE(SUM(PriceStd), 0)" +
      "				    FROM M_ProductPrice" +
      "				    WHERE M_PriceList_Version_id = ?" +
      "				      AND M_Product_id = ?)," +
      "                   (SELECT PRICEPRECISION " +
      "                       FROM C_CURRENCY C," +
      "                            C_PROJECT P " +
      "                      WHERE C.C_CURRENCY_ID = P.C_CURRENCY_ID" +
      "                        AND P.C_PROJECT_ID = ?)) AS plannedprice FROM DUAL";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPriceListVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "plannedprice");
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

  public static SEProjectLineValueData[] set()    throws ServletException {
    SEProjectLineValueData objectSEProjectLineValueData[] = new SEProjectLineValueData[1];
    objectSEProjectLineValueData[0] = new SEProjectLineValueData();
    objectSEProjectLineValueData[0].plannedprice = "";
    return objectSEProjectLineValueData;
  }
}
