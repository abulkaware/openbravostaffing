//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class PriceListCreateAllData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceListCreateAllData.class);
  private String InitRecordNumber="0";
  public String mPricelistVersionId;
  public String mPricelistVersionBaseId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_base_id") || fieldName.equals("mPricelistVersionBaseId"))
      return mPricelistVersionBaseId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PriceListCreateAllData[] select(Connection conn, ConnectionProvider connectionProvider, String mPricelistVersionBaseId, String clientOrg, String clientUser)    throws ServletException {
    return select(conn, connectionProvider, mPricelistVersionBaseId, clientOrg, clientUser, 0, 0);
  }

  public static PriceListCreateAllData[] select(Connection conn, ConnectionProvider connectionProvider, String mPricelistVersionBaseId, String clientOrg, String clientUser, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRICELIST_VERSION_ID, M_PRICELIST_VERSION_BASE_ID " +
      "        FROM M_PRICELIST_VERSION " +
      "        WHERE M_PRICELIST_VERSION_BASE_ID = ?" +
      "        AND ISACTIVE = 'Y' " +
      "        AND AD_ORG_ID IN (";
    strSql = strSql + ((clientOrg==null || clientOrg.equals(""))?"":clientOrg);
    strSql = strSql + 
      ") " +
      "        AND AD_CLIENT_ID IN (";
    strSql = strSql + ((clientUser==null || clientUser.equals(""))?"":clientUser);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<PriceListCreateAllData> vector = new Vector<PriceListCreateAllData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionBaseId);
      if (clientOrg != null && !(clientOrg.equals(""))) {
        }
      if (clientUser != null && !(clientUser.equals(""))) {
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
        PriceListCreateAllData objectPriceListCreateAllData = new PriceListCreateAllData();
        objectPriceListCreateAllData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListCreateAllData.mPricelistVersionBaseId = UtilSql.getValue(result, "m_pricelist_version_base_id");
        objectPriceListCreateAllData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListCreateAllData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    PriceListCreateAllData objectPriceListCreateAllData[] = new PriceListCreateAllData[vector.size()];
    vector.copyInto(objectPriceListCreateAllData);
    return(objectPriceListCreateAllData);
  }

  public static PriceListCreateAllData[] selectParent(Connection conn, ConnectionProvider connectionProvider, String mPricelistVersionId, String clientOrg, String clientUser)    throws ServletException {
    return selectParent(conn, connectionProvider, mPricelistVersionId, clientOrg, clientUser, 0, 0);
  }

  public static PriceListCreateAllData[] selectParent(Connection conn, ConnectionProvider connectionProvider, String mPricelistVersionId, String clientOrg, String clientUser, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRICELIST_VERSION_ID, M_PRICELIST_VERSION_BASE_ID " +
      "        FROM M_PRICELIST_VERSION " +
      "        WHERE M_PRICELIST_VERSION_ID = ?" +
      "        AND ISACTIVE = 'Y' " +
      "        AND AD_ORG_ID IN (";
    strSql = strSql + ((clientOrg==null || clientOrg.equals(""))?"":clientOrg);
    strSql = strSql + 
      ") " +
      "        AND AD_CLIENT_ID IN (";
    strSql = strSql + ((clientUser==null || clientUser.equals(""))?"":clientUser);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<PriceListCreateAllData> vector = new Vector<PriceListCreateAllData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      if (clientOrg != null && !(clientOrg.equals(""))) {
        }
      if (clientUser != null && !(clientUser.equals(""))) {
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
        PriceListCreateAllData objectPriceListCreateAllData = new PriceListCreateAllData();
        objectPriceListCreateAllData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListCreateAllData.mPricelistVersionBaseId = UtilSql.getValue(result, "m_pricelist_version_base_id");
        objectPriceListCreateAllData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListCreateAllData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    PriceListCreateAllData objectPriceListCreateAllData[] = new PriceListCreateAllData[vector.size()];
    vector.copyInto(objectPriceListCreateAllData);
    return(objectPriceListCreateAllData);
  }

  public static PriceListCreateAllData process(ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_PriceList_Create(?)";

    PriceListCreateAllData objectPriceListCreateAllData = new PriceListCreateAllData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      st.execute();
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectPriceListCreateAllData);
  }
}
