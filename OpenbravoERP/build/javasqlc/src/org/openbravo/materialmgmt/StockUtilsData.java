//Sqlc generated V1.O00-1
package org.openbravo.materialmgmt;

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

class StockUtilsData implements FieldProvider {
static Logger log4j = Logger.getLogger(StockUtilsData.class);
  private String InitRecordNumber="0";
  public String a;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("a"))
      return a;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static StockUtilsData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static StockUtilsData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select 1 as a from dual";

    ResultSet result;
    Vector<StockUtilsData> vector = new Vector<StockUtilsData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        StockUtilsData objectStockUtilsData = new StockUtilsData();
        objectStockUtilsData.a = UtilSql.getValue(result, "a");
        objectStockUtilsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectStockUtilsData);
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
    StockUtilsData objectStockUtilsData[] = new StockUtilsData[vector.size()];
    vector.copyInto(objectStockUtilsData);
    return(objectStockUtilsData);
  }

  public static CSResponseGetStockParam getStock(Connection conn, ConnectionProvider connectionProvider, String p_uuid, String p_recordid, String p_quantity, String p_productid, String p_locatorid, String p_warehouseid, String p_prioritywarehouseid, String p_orgid, String p_attributesetinstanceid, String p_ad_user_id, String p_clientid, String p_warehouse_rule_id, String p_uomid, String p_productuomid, String p_table, String p_auxid, String p_lineno, String p_processid, String p_reservation_id, String p_calledfromapp, String p_avail, String p_nett, String p_overissue)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL M_GET_STOCK_PARAM(?, ?, to_number(?), " +
      "        ?, ?, ?, " +
      "        ?, ?, ?, " +
      "        ?, ?, ?, " +
      "        ?, ?, ?, ?," +
      "        to_number(?), ?, ?, " +
      "        ?, ?, ?," +
      "        ?, ?, ?)";

    CSResponseGetStockParam objectCSResponseGetStockParam = new CSResponseGetStockParam();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_uuid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_recordid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_locatorid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_warehouseid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_prioritywarehouseid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_orgid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_attributesetinstanceid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_ad_user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_clientid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_warehouse_rule_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_uomid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_productuomid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_table);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_auxid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_lineno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_processid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_reservation_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_calledfromapp);
      int iParameterp_result = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      int iParameterp_message = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_avail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_nett);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, p_overissue);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
      objectCSResponseGetStockParam.p_result= UtilSql.getStringCallableStatement(st, iParameterp_result);
      objectCSResponseGetStockParam.p_message= UtilSql.getStringCallableStatement(st, iParameterp_message);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(p_uuid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_recordid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_quantity);
      parametersTypes.addElement("in");
      parametersData.addElement(p_productid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_locatorid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_warehouseid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_prioritywarehouseid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_orgid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_attributesetinstanceid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_ad_user_id);
      parametersTypes.addElement("in");
      parametersData.addElement(p_clientid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_warehouse_rule_id);
      parametersTypes.addElement("in");
      parametersData.addElement(p_uomid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_productuomid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_table);
      parametersTypes.addElement("in");
      parametersData.addElement(p_auxid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_lineno);
      parametersTypes.addElement("in");
      parametersData.addElement(p_processid);
      parametersTypes.addElement("in");
      parametersData.addElement(p_reservation_id);
      parametersTypes.addElement("in");
      parametersData.addElement(p_calledfromapp);
      parametersTypes.addElement("in");
      parametersData.addElement("p_result");
      parametersTypes.addElement("out");
      parametersData.addElement("p_message");
      parametersTypes.addElement("out");
      parametersData.addElement(p_avail);
      parametersTypes.addElement("in");
      parametersData.addElement(p_nett);
      parametersTypes.addElement("in");
      parametersData.addElement(p_overissue);
      parametersTypes.addElement("in");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 2);
      objectCSResponseGetStockParam.p_result = vecTotal.elementAt(0);
      objectCSResponseGetStockParam.p_message = vecTotal.elementAt(1);
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
    return(objectCSResponseGetStockParam);
  }
}
