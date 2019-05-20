//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLineInOutData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineInOutData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String mProductId;
  public String line;
  public String description;
  public String cUomId;
  public String mInoutlineId;
  public String mLocatorId;
  public String breakdownqty;
  public String movementqty;
  public String cCampaignId;
  public String cProjectId;
  public String user1id;
  public String user2id;
  public String cCostcenterId;
  public String aAssetId;
  public String cBpartnerId;
  public String cActivityId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("breakdownqty"))
      return breakdownqty;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1id"))
      return user1id;
    else if (fieldName.equalsIgnoreCase("user2id"))
      return user2id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineInOutData[] select(ConnectionProvider connectionProvider, String M_InOut_ID)    throws ServletException {
    return select(connectionProvider, M_InOut_ID, 0, 0);
  }

  public static DocLineInOutData[] select(ConnectionProvider connectionProvider, String M_InOut_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COALESCE(A.AD_ORG_ID,IO.AD_ORG_ID) AS AD_ORG_ID, IO.M_PRODUCT_ID, IO.LINE, IO.DESCRIPTION," +
      "          IO.C_UOM_ID, IO.M_INOUTLINE_ID, IO.M_LOCATOR_ID," +
      "          COALESCE(A.Quantity, IO.MOVEMENTQTY) as BREAKDOWNQTY, " +
      "          IO.MOVEMENTQTY as MOVEMENTQTY, " +
      "          A.C_Campaign_ID, COALESCE(A.C_Project_Id, IO.C_Project_Id) AS C_Project_Id, COALESCE(A.User1_ID, IO.User1_ID) AS user1Id," +
      "          COALESCE(A.User2_ID, IO.User2_ID) AS user2Id, COALESCE(A.C_Costcenter_ID, IO.C_Costcenter_ID) AS C_Costcenter_ID," +
      "          COALESCE(A.A_Asset_ID,IO.A_Asset_ID) AS A_Asset_ID, COALESCE(A.C_BPartner_ID, IO.C_BPartner_ID) AS C_BPartner_ID, A.C_Activity_ID" +
      "          FROM M_InOutLine IO left join M_InOutLine_AcctDimension A ON IO.M_InOutLine_ID = A.M_InOutLine_ID" +
      "          WHERE M_InOut_ID=?" +
      "          AND COALESCE(A.Quantity, IO.MOVEMENTQTY) <> 0" +
      "          ORDER BY Line";

    ResultSet result;
    Vector<DocLineInOutData> vector = new Vector<DocLineInOutData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOut_ID);

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
        DocLineInOutData objectDocLineInOutData = new DocLineInOutData();
        objectDocLineInOutData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineInOutData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineInOutData.line = UtilSql.getValue(result, "line");
        objectDocLineInOutData.description = UtilSql.getValue(result, "description");
        objectDocLineInOutData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocLineInOutData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectDocLineInOutData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDocLineInOutData.breakdownqty = UtilSql.getValue(result, "breakdownqty");
        objectDocLineInOutData.movementqty = UtilSql.getValue(result, "movementqty");
        objectDocLineInOutData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocLineInOutData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocLineInOutData.user1id = UtilSql.getValue(result, "user1id");
        objectDocLineInOutData.user2id = UtilSql.getValue(result, "user2id");
        objectDocLineInOutData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineInOutData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineInOutData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineInOutData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocLineInOutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInOutData);
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
    DocLineInOutData objectDocLineInOutData[] = new DocLineInOutData[vector.size()];
    vector.copyInto(objectDocLineInOutData);
    return(objectDocLineInOutData);
  }
}
