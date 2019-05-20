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

class SLProposalProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLProposalProductData.class);
  private String InitRecordNumber="0";
  public String value;
  public String name;
  public String description;

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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLProposalProductData[] select(ConnectionProvider connectionProvider, String product)    throws ServletException {
    return select(connectionProvider, product, 0, 0);
  }

  public static SLProposalProductData[] select(ConnectionProvider connectionProvider, String product, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select value, name, description from m_product where m_product_id = ?";

    ResultSet result;
    Vector<SLProposalProductData> vector = new Vector<SLProposalProductData>(0);
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
        SLProposalProductData objectSLProposalProductData = new SLProposalProductData();
        objectSLProposalProductData.value = UtilSql.getValue(result, "value");
        objectSLProposalProductData.name = UtilSql.getValue(result, "name");
        objectSLProposalProductData.description = UtilSql.getValue(result, "description");
        objectSLProposalProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLProposalProductData);
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
    SLProposalProductData objectSLProposalProductData[] = new SLProposalProductData[vector.size()];
    vector.copyInto(objectSLProposalProductData);
    return(objectSLProposalProductData);
  }

  public static SLProposalProductData[] set()    throws ServletException {
    SLProposalProductData objectSLProposalProductData[] = new SLProposalProductData[1];
    objectSLProposalProductData[0] = new SLProposalProductData();
    objectSLProposalProductData[0].value = "";
    objectSLProposalProductData[0].name = "";
    objectSLProposalProductData[0].description = "";
    return objectSLProposalProductData;
  }
}
