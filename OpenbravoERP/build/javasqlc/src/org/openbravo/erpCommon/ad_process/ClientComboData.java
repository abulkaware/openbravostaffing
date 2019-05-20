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

class ClientComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(ClientComboData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String name;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ClientComboData[] select(ConnectionProvider connectionProvider, String rol)    throws ServletException {
    return select(connectionProvider, rol, 0, 0);
  }

  public static ClientComboData[] select(ConnectionProvider connectionProvider, String rol, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_C.AD_CLIENT_ID, A_C.NAME, '' AS ID" +
      "        FROM AD_CLIENT A_C" +
      "        WHERE A_C.ISACTIVE = 'Y'" +
      "        AND EXISTS (SELECT 1 FROM AD_ROLE_ORGACCESS WHERE AD_ROLE_ORGACCESS.AD_CLIENT_ID = A_C.AD_CLIENT_ID AND AD_ROLE_ORGACCESS.AD_ROLE_ID = ? AND AD_ROLE_ORGACCESS.ISACTIVE = 'Y')" +
      "        ORDER BY A_C.NAME";

    ResultSet result;
    Vector<ClientComboData> vector = new Vector<ClientComboData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);

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
        ClientComboData objectClientComboData = new ClientComboData();
        objectClientComboData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectClientComboData.name = UtilSql.getValue(result, "name");
        objectClientComboData.id = UtilSql.getValue(result, "id");
        objectClientComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClientComboData);
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
    ClientComboData objectClientComboData[] = new ClientComboData[vector.size()];
    vector.copyInto(objectClientComboData);
    return(objectClientComboData);
  }

  public static ClientComboData[] selectAllClients(ConnectionProvider connectionProvider)    throws ServletException {
    return selectAllClients(connectionProvider, 0, 0);
  }

  public static ClientComboData[] selectAllClients(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_C.AD_CLIENT_ID, A_C.NAME " +
      "        FROM AD_CLIENT A_C" +
      "        ORDER BY A_C.NAME";

    ResultSet result;
    Vector<ClientComboData> vector = new Vector<ClientComboData>(0);
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
        ClientComboData objectClientComboData = new ClientComboData();
        objectClientComboData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectClientComboData.name = UtilSql.getValue(result, "name");
        objectClientComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClientComboData);
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
    ClientComboData objectClientComboData[] = new ClientComboData[vector.size()];
    vector.copyInto(objectClientComboData);
    return(objectClientComboData);
  }

  public static ClientComboData[] selectAllClients1(ConnectionProvider connectionProvider)    throws ServletException {
    return selectAllClients1(connectionProvider, 0, 0);
  }

  public static ClientComboData[] selectAllClients1(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_C.AD_CLIENT_ID AS ID, A_C.NAME " +
      "        FROM AD_CLIENT A_C" +
      "        ORDER BY A_C.NAME";

    ResultSet result;
    Vector<ClientComboData> vector = new Vector<ClientComboData>(0);
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
        ClientComboData objectClientComboData = new ClientComboData();
        objectClientComboData.id = UtilSql.getValue(result, "id");
        objectClientComboData.name = UtilSql.getValue(result, "name");
        objectClientComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClientComboData);
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
    ClientComboData objectClientComboData[] = new ClientComboData[vector.size()];
    vector.copyInto(objectClientComboData);
    return(objectClientComboData);
  }

  public static ClientComboData[] selectAllClientsNoSystem1(ConnectionProvider connectionProvider)    throws ServletException {
    return selectAllClientsNoSystem1(connectionProvider, 0, 0);
  }

  public static ClientComboData[] selectAllClientsNoSystem1(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_C.AD_CLIENT_ID AS ID, A_C.NAME " +
      "        FROM AD_CLIENT A_C" +
      "        WHERE A_C.AD_CLIENT_ID <> '0'" +
      "        ORDER BY A_C.NAME";

    ResultSet result;
    Vector<ClientComboData> vector = new Vector<ClientComboData>(0);
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
        ClientComboData objectClientComboData = new ClientComboData();
        objectClientComboData.id = UtilSql.getValue(result, "id");
        objectClientComboData.name = UtilSql.getValue(result, "name");
        objectClientComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClientComboData);
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
    ClientComboData objectClientComboData[] = new ClientComboData[vector.size()];
    vector.copyInto(objectClientComboData);
    return(objectClientComboData);
  }
}
