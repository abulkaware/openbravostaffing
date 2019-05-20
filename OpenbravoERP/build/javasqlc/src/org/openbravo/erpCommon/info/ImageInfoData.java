//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ImageInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImageInfoData.class);
  private String InitRecordNumber="0";
  public String adImageId;
  public String name;
  public String imageurl;
  public String imageurlSrc;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_image_id") || fieldName.equals("adImageId"))
      return adImageId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("imageurl"))
      return imageurl;
    else if (fieldName.equalsIgnoreCase("imageurl_src") || fieldName.equals("imageurlSrc"))
      return imageurlSrc;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ImageInfoData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String name, String imageurl)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, name, imageurl, 0, 0);
  }

  public static ImageInfoData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String name, String imageurl, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT AD_IMAGE_ID, NAME, IMAGEURL, (CASE WHEN IMAGEURL IS NULL THEN 'Question.jpg' ELSE TO_CHAR(IMAGEURL) END) AS IMAGEURL_SRC " +
      "            FROM AD_IMAGE " +
      "            WHERE AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "            AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "            AND ISACTIVE = 'Y' ";
    strSql = strSql + ((name==null || name.equals("") || name.equals("%") )?"":" AND UPPER(Name) LIKE UPPER(?)  ");
    strSql = strSql + ((imageurl==null || imageurl.equals("") || imageurl.equals("%") )?"":" AND UPPER(IMAGEURL) LIKE UPPER(?)  ");
    strSql = strSql + 
      "            ORDER BY NAME";

    ResultSet result;
    Vector<ImageInfoData> vector = new Vector<ImageInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (name != null && !(name.equals("")) && !(name.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      }
      if (imageurl != null && !(imageurl.equals("")) && !(imageurl.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
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
        ImageInfoData objectImageInfoData = new ImageInfoData();
        objectImageInfoData.adImageId = UtilSql.getValue(result, "ad_image_id");
        objectImageInfoData.name = UtilSql.getValue(result, "name");
        objectImageInfoData.imageurl = UtilSql.getValue(result, "imageurl");
        objectImageInfoData.imageurlSrc = UtilSql.getValue(result, "imageurl_src");
        objectImageInfoData.position = Long.toString(countRecord);
        objectImageInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImageInfoData);
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
    ImageInfoData objectImageInfoData[] = new ImageInfoData[vector.size()];
    vector.copyInto(objectImageInfoData);
    return(objectImageInfoData);
  }

  public static ImageInfoData[] set()    throws ServletException {
    ImageInfoData objectImageInfoData[] = new ImageInfoData[1];
    objectImageInfoData[0] = new ImageInfoData();
    objectImageInfoData[0].adImageId = "";
    objectImageInfoData[0].name = "";
    objectImageInfoData[0].imageurl = "";
    objectImageInfoData[0].imageurlSrc = "";
    return objectImageInfoData;
  }

  public static String selectName(ConnectionProvider connectionProvider, String adImageId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT NAME FROM AD_IMAGE " +
      "            WHERE AD_IMAGE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
