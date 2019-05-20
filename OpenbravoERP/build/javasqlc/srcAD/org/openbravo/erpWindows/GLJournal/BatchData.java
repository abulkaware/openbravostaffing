//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GLJournal;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
WAD Generated class
 */
class BatchData implements FieldProvider {
static Logger log4j = Logger.getLogger(BatchData.class);
  private String InitRecordNumber="0";
  public String dummy;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dummy"))
      return dummy;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static BatchData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static BatchData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<BatchData> vector = new Vector<BatchData>(0);
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
        BatchData objectBatchData = new BatchData();
        objectBatchData.dummy = UtilSql.getValue(result, "dummy");
        objectBatchData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBatchData);
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
    BatchData objectBatchData[] = new BatchData[vector.size()];
    vector.copyInto(objectBatchData);
    return(objectBatchData);
  }

/**
Select for action search
 */
  public static String selectActDefGL_JournalBatch_ID(ConnectionProvider connectionProvider, String GL_JournalBatch_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DocumentNo FROM GL_JournalBatch WHERE isActive='Y' AND GL_JournalBatch_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, GL_JournalBatch_ID);

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
}
