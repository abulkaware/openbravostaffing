//Sqlc generated V1.O00-1
package org.openbravo.base.secureApp;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DefaultSessionValuesData implements FieldProvider {
static Logger log4j = Logger.getLogger(DefaultSessionValuesData.class);
  private String InitRecordNumber="0";
  public String tablename;
  public String columnname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DefaultSessionValuesData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DefaultSessionValuesData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT t.TableName, c.ColumnName " +
      "        FROM AD_Column c " +
      "        INNER JOIN AD_Table t ON (c.AD_Table_ID=t.AD_Table_ID) " +
      "        WHERE c.IsKey='Y' AND t.IsActive='Y'" +
      "        AND t.name <> 'ADModule'" +
      "        AND EXISTS (SELECT * FROM AD_Column cc " +
      "        WHERE ColumnName = 'IsDefault' AND t.AD_Table_ID=cc.AD_Table_ID AND cc.IsActive='Y')";

    ResultSet result;
    Vector<DefaultSessionValuesData> vector = new Vector<DefaultSessionValuesData>(0);
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
        DefaultSessionValuesData objectDefaultSessionValuesData = new DefaultSessionValuesData();
        objectDefaultSessionValuesData.tablename = UtilSql.getValue(result, "tablename");
        objectDefaultSessionValuesData.columnname = UtilSql.getValue(result, "columnname");
        objectDefaultSessionValuesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultSessionValuesData);
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
    DefaultSessionValuesData objectDefaultSessionValuesData[] = new DefaultSessionValuesData[vector.size()];
    vector.copyInto(objectDefaultSessionValuesData);
    return(objectDefaultSessionValuesData);
  }
}
