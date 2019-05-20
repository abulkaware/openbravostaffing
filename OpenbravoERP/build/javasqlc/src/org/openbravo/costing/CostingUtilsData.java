//Sqlc generated V1.O00-1
package org.openbravo.costing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CostingUtilsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CostingUtilsData.class);
  private String InitRecordNumber="0";
  public String mindatemovement;
  public String period;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("mindatemovement"))
      return mindatemovement;
    else if (fieldName.equalsIgnoreCase("period"))
      return period;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CostingUtilsData[] selectTransactionsInClosedPeriod(ConnectionProvider connectionProvider, String Porgs, String StartingDate, String ChildOrgs, String Client, String Org)    throws ServletException {
    return selectTransactionsInClosedPeriod(connectionProvider, Porgs, StartingDate, ChildOrgs, Client, Org, 0, 0);
  }

  public static CostingUtilsData[] selectTransactionsInClosedPeriod(ConnectionProvider connectionProvider, String Porgs, String StartingDate, String ChildOrgs, String Client, String Org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT min(T.DATEMOVEMENT) AS minDateMovement, '' as period" +
      "        FROM (" +
      "            SELECT trunc(TRX.MOVEMENTDATE) AS DATEMOVEMENT" +
      "            FROM M_TRANSACTION TRX" +
      "            INNER JOIN M_PRODUCT P" +
      "            ON TRX.M_PRODUCT_ID = P.M_PRODUCT_ID            " +
      "            WHERE TRX.ISCOSTCALCULATED = 'N'" +
      "            AND P.PRODUCTTYPE = 'I'" +
      "            AND P.ISSTOCKED = 'Y'" +
      "            AND P.AD_ORG_ID IN (";
    strSql = strSql + ((Porgs==null || Porgs.equals(""))?"":Porgs);
    strSql = strSql + 
      ")" +
      "            AND TRX.MOVEMENTDATE >= ?" +
      "            AND TRX.AD_ORG_ID IN (";
    strSql = strSql + ((ChildOrgs==null || ChildOrgs.equals(""))?"":ChildOrgs);
    strSql = strSql + 
      ")" +
      "            GROUP BY trunc(TRX.MOVEMENTDATE)" +
      "        ) T" +
      "        WHERE EXISTS (" +
      "            SELECT 1" +
      "            FROM C_PERIODCONTROL PC" +
      "            INNER JOIN C_PERIOD PE" +
      "            ON PC.C_PERIOD_ID = PE.C_PERIOD_ID" +
      "            WHERE PC.PERIODSTATUS <> 'O'" +
      "            AND PE.AD_CLIENT_ID = ?" +
      "            AND PC.AD_ORG_ID = ?" +
      "            AND T.DATEMOVEMENT >= PE.STARTDATE" +
      "            AND T.DATEMOVEMENT < PE.ENDDATE + 1" +
      "        )";

    ResultSet result;
    Vector<CostingUtilsData> vector = new Vector<CostingUtilsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (Porgs != null && !(Porgs.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, StartingDate);
      if (ChildOrgs != null && !(ChildOrgs.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);

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
        CostingUtilsData objectCostingUtilsData = new CostingUtilsData();
        objectCostingUtilsData.mindatemovement = UtilSql.getDateValue(result, "mindatemovement", "dd-MM-yyyy");
        objectCostingUtilsData.period = UtilSql.getValue(result, "period");
        objectCostingUtilsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCostingUtilsData);
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
    CostingUtilsData objectCostingUtilsData[] = new CostingUtilsData[vector.size()];
    vector.copyInto(objectCostingUtilsData);
    return(objectCostingUtilsData);
  }

  public static CostingUtilsData[] periodClosed(ConnectionProvider connectionProvider, String Org, String StartDateAcct, String EndDateAcct, String AD_Client_ID, String DocumentType)    throws ServletException {
    return periodClosed(connectionProvider, Org, StartDateAcct, EndDateAcct, AD_Client_ID, DocumentType, 0, 0);
  }

  public static CostingUtilsData[] periodClosed(ConnectionProvider connectionProvider, String Org, String StartDateAcct, String EndDateAcct, String AD_Client_ID, String DocumentType, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT p.c_period_id as period " +
      "        FROM C_PERIOD P, C_YEAR Y, " +
      "            (SELECT Y.YEAR, P.PERIODNO, P.AD_ORG_ID" +
      "                          FROM C_PERIOD P, C_YEAR Y" +
      "                          WHERE P.AD_ORG_ID = ?" +
      "                          AND P.STARTDATE <= to_date(?)" +
      "                          AND P.ENDDATE >= to_date(?)" +
      "                          AND P.C_YEAR_ID = Y.C_YEAR_ID) P1, " +
      "            (SELECT Y.YEAR, P.PERIODNO, P.AD_ORG_ID" +
      "                          FROM C_PERIOD P, C_YEAR Y" +
      "                          WHERE P.AD_ORG_ID = ?" +
      "                          AND P.STARTDATE <= to_date(?)" +
      "                          AND P.ENDDATE >= to_date(?)" +
      "                          AND P.C_YEAR_ID = Y.C_YEAR_ID) P2" +
      "        WHERE P.AD_CLIENT_ID = ?" +
      "        AND P.AD_ORG_ID = P1.AD_ORG_ID             " +
      "        AND P.C_YEAR_ID = Y.C_YEAR_ID" +
      "        AND (Y.YEAR = P1.YEAR AND P.PERIODNO >= P1.PERIODNO" +
      "             OR Y.YEAR > P1.YEAR)" +
      "        AND P.AD_ORG_ID = P2.AD_ORG_ID" +
      "        AND (Y.YEAR = P2.YEAR AND P.PERIODNO <= P2.PERIODNO" +
      "             OR Y.YEAR < P2.YEAR)" +
      "        AND NOT EXISTS (SELECT 1 FROM C_PERIODCONTROL PC" +
      "                        WHERE PC.C_PERIOD_ID = P.C_PERIOD_ID" +
      "                        AND PC.DOCBASETYPE =?" +
      "                        AND PC.AD_ORG_ID = P.AD_ORG_ID" +
      "                        AND PC.PERIODSTATUS = 'O')" +
      "        AND P.PERIODTYPE <> 'A'";

    ResultSet result;
    Vector<CostingUtilsData> vector = new Vector<CostingUtilsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, StartDateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, StartDateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, EndDateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, EndDateAcct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DocumentType);

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
        CostingUtilsData objectCostingUtilsData = new CostingUtilsData();
        objectCostingUtilsData.period = UtilSql.getValue(result, "period");
        objectCostingUtilsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCostingUtilsData);
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
    CostingUtilsData objectCostingUtilsData[] = new CostingUtilsData[vector.size()];
    vector.copyInto(objectCostingUtilsData);
    return(objectCostingUtilsData);
  }
}
