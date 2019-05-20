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

class RptCBpartnercontactData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnercontactData.class);
  private String InitRecordNumber="0";
  public String contactname;
  public String contactphone;
  public String contactphone2;
  public String contactfax;
  public String contactadress;
  public String contactemail;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("contactname"))
      return contactname;
    else if (fieldName.equalsIgnoreCase("contactphone"))
      return contactphone;
    else if (fieldName.equalsIgnoreCase("contactphone2"))
      return contactphone2;
    else if (fieldName.equalsIgnoreCase("contactfax"))
      return contactfax;
    else if (fieldName.equalsIgnoreCase("contactadress"))
      return contactadress;
    else if (fieldName.equalsIgnoreCase("contactemail"))
      return contactemail;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnercontactData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnercontactData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT U.FIRSTNAME||' '||U.LASTNAME AS CONTACTNAME, U.PHONE AS CONTACTPHONE, U.PHONE2 AS CONTACTPHONE2, U.FAX AS CONTACTFAX, C_Location_Identifier(L.C_LOCATION_ID) AS CONTACTADRESS, U.EMAIL AS CONTACTEMAIL" +
      "        FROM AD_USER U left join C_BPARTNER_LOCATION BL on U.C_BPARTNER_LOCATION_ID = BL.C_BPARTNER_LOCATION_ID" +
      "                       left join C_LOCATION L on BL.C_LOCATION_ID = L.C_LOCATION_ID" +
      "        WHERE " +
      "          1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND U.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<RptCBpartnercontactData> vector = new Vector<RptCBpartnercontactData>(0);
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
        RptCBpartnercontactData objectRptCBpartnercontactData = new RptCBpartnercontactData();
        objectRptCBpartnercontactData.contactname = UtilSql.getValue(result, "contactname");
        objectRptCBpartnercontactData.contactphone = UtilSql.getValue(result, "contactphone");
        objectRptCBpartnercontactData.contactphone2 = UtilSql.getValue(result, "contactphone2");
        objectRptCBpartnercontactData.contactfax = UtilSql.getValue(result, "contactfax");
        objectRptCBpartnercontactData.contactadress = UtilSql.getValue(result, "contactadress");
        objectRptCBpartnercontactData.contactemail = UtilSql.getValue(result, "contactemail");
        objectRptCBpartnercontactData.position = Long.toString(countRecord);
        objectRptCBpartnercontactData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnercontactData);
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
    RptCBpartnercontactData objectRptCBpartnercontactData[] = new RptCBpartnercontactData[vector.size()];
    vector.copyInto(objectRptCBpartnercontactData);
    return(objectRptCBpartnercontactData);
  }

  public static RptCBpartnercontactData[] set()    throws ServletException {
    RptCBpartnercontactData objectRptCBpartnercontactData[] = new RptCBpartnercontactData[1];
    objectRptCBpartnercontactData[0] = new RptCBpartnercontactData();
    objectRptCBpartnercontactData[0].contactname = "";
    objectRptCBpartnercontactData[0].contactphone = "";
    objectRptCBpartnercontactData[0].contactphone2 = "";
    objectRptCBpartnercontactData[0].contactfax = "";
    objectRptCBpartnercontactData[0].contactadress = "";
    objectRptCBpartnercontactData[0].contactemail = "";
    return objectRptCBpartnercontactData;
  }
}
