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

class DocGLJournalData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocGLJournalData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String dateacct;
  public String datedoc;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String postingtype;
  public String isopening;
  public String cCampaignId;
  public String cProjectId;
  public String user1Id;
  public String user2Id;
  public String cCostcenterId;
  public String aAssetId;
  public String cBpartnerId;
  public String mProductId;
  public String period;
  public String fininvcount;
  public String finacctcount;
  public String multiGl;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("postingtype"))
      return postingtype;
    else if (fieldName.equalsIgnoreCase("isopening"))
      return isopening;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("period"))
      return period;
    else if (fieldName.equalsIgnoreCase("fininvcount"))
      return fininvcount;
    else if (fieldName.equalsIgnoreCase("finacctcount"))
      return finacctcount;
    else if (fieldName.equalsIgnoreCase("multi_gl") || fieldName.equals("multiGl"))
      return multiGl;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocGLJournalData[] select(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return select(connectionProvider, client, id, 0, 0);
  }

  public static DocGLJournalData[] select(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT G.AD_CLIENT_ID, G.AD_ORG_ID, G.DOCUMENTNO, G.DATEACCT, G.DATEDOC," +
      "        G.C_CURRENCY_ID, G.C_DOCTYPE_ID, G.POSTED, G.POSTINGTYPE, G.ISOPENING," +
      "        G.C_CAMPAIGN_ID, G.C_PROJECT_ID, G.USER1_ID, G.USER2_ID, G.C_COSTCENTER_ID," +
      "        G.A_ASSET_ID, G.C_BPARTNER_ID, G.M_PRODUCT_ID, G.C_PERIOD_ID AS PERIOD," +
      "        '' AS FININVCOUNT,'' AS FINACCTCOUNT, G.MULTI_GL" +
      "        FROM GL_JOURNAL G" +
      "        WHERE AD_CLIENT_ID=?" +
      "        AND GL_JOURNAL_ID=?";

    ResultSet result;
    Vector<DocGLJournalData> vector = new Vector<DocGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocGLJournalData objectDocGLJournalData = new DocGLJournalData();
        objectDocGLJournalData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocGLJournalData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocGLJournalData.documentno = UtilSql.getValue(result, "documentno");
        objectDocGLJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocGLJournalData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocGLJournalData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocGLJournalData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocGLJournalData.posted = UtilSql.getValue(result, "posted");
        objectDocGLJournalData.postingtype = UtilSql.getValue(result, "postingtype");
        objectDocGLJournalData.isopening = UtilSql.getValue(result, "isopening");
        objectDocGLJournalData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocGLJournalData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocGLJournalData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocGLJournalData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocGLJournalData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocGLJournalData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocGLJournalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocGLJournalData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocGLJournalData.period = UtilSql.getValue(result, "period");
        objectDocGLJournalData.fininvcount = UtilSql.getValue(result, "fininvcount");
        objectDocGLJournalData.finacctcount = UtilSql.getValue(result, "finacctcount");
        objectDocGLJournalData.multiGl = UtilSql.getValue(result, "multi_gl");
        objectDocGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocGLJournalData);
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
    DocGLJournalData objectDocGLJournalData[] = new DocGLJournalData[vector.size()];
    vector.copyInto(objectDocGLJournalData);
    return(objectDocGLJournalData);
  }

  public static String selectAcctSchema(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ACCTSCHEMA_ID" +
      "        FROM GL_JOURNAL G" +
      "        WHERE AD_CLIENT_ID=?" +
      "        AND GL_JOURNAL_ID=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_acctschema_id");
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

  public static DocGLJournalData[] periodOpen(ConnectionProvider connectionProvider, String period)    throws ServletException {
    return periodOpen(connectionProvider, period, 0, 0);
  }

  public static DocGLJournalData[] periodOpen(ConnectionProvider connectionProvider, String period, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select max(c_period.c_period_id) as period" +
      "      from c_period, c_periodcontrol" +
      "      where c_period.c_period_id = c_periodcontrol.c_period_id" +
      "      and c_periodcontrol.docbasetype = 'GLJ'" +
      "      and c_periodcontrol.periodstatus = 'O'" +
      "      and c_periodcontrol.c_period_id = ?";

    ResultSet result;
    Vector<DocGLJournalData> vector = new Vector<DocGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, period);

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
        DocGLJournalData objectDocGLJournalData = new DocGLJournalData();
        objectDocGLJournalData.period = UtilSql.getValue(result, "period");
        objectDocGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocGLJournalData);
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
    DocGLJournalData objectDocGLJournalData[] = new DocGLJournalData[vector.size()];
    vector.copyInto(objectDocGLJournalData);
    return(objectDocGLJournalData);
  }

  public static DocGLJournalData[] selectFinInvCount(ConnectionProvider connectionProvider, String gl_journal, String acctschema_id)    throws ServletException {
    return selectFinInvCount(connectionProvider, gl_journal, acctschema_id, 0, 0);
  }

  public static DocGLJournalData[] selectFinInvCount(ConnectionProvider connectionProvider, String gl_journal, String acctschema_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (SELECT COUNT(DISTINCT GL_JOURNALLINE.ACCOUNT_ID)" +
      "               FROM GL_JOURNALLINE" +
      "                 INNER JOIN GL_JOURNAL ON GL_JOURNALLINE.GL_JOURNAL_ID = GL_JOURNAL.GL_JOURNAL_ID" +
      "               WHERE GL_JOURNAL.MULTI_GL = 'Y'" +
      "               AND   GL_JOURNAL.GL_JOURNAL_ID = ?) AS FININVCOUNT," +
      "               (SELECT COUNT(DISTINCT GLACT.C_GLITEM_ID)" +
      "                FROM GL_JOURNALLINE" +
      "                  INNER JOIN GL_JOURNAL ON GL_JOURNALLINE.GL_JOURNAL_ID = GL_JOURNAL.GL_JOURNAL_ID" +
      "                  JOIN C_GLITEM_ACCT GLACT ON (GL_JOURNALLINE.ACCOUNT_ID = GLACT.C_GLITEM_ID)" +
      "                WHERE GL_JOURNAL.MULTI_GL = 'Y'" +
      "                AND   GL_JOURNAL.GL_JOURNAL_ID = ?" +
      "                AND   GLACT.C_ACCTSCHEMA_ID = ?) AS FINACCTCOUNT" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocGLJournalData> vector = new Vector<DocGLJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctschema_id);

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
        DocGLJournalData objectDocGLJournalData = new DocGLJournalData();
        objectDocGLJournalData.fininvcount = UtilSql.getValue(result, "fininvcount");
        objectDocGLJournalData.finacctcount = UtilSql.getValue(result, "finacctcount");
        objectDocGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocGLJournalData);
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
    DocGLJournalData objectDocGLJournalData[] = new DocGLJournalData[vector.size()];
    vector.copyInto(objectDocGLJournalData);
    return(objectDocGLJournalData);
  }
}
