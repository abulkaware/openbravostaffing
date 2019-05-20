//Sqlc generated V1.O00-1
package org.openbravo.wad;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import java.util.*;

class TabsData implements FieldProvider {
static Logger log4j = Logger.getLogger(TabsData.class);
  private String InitRecordNumber="0";
  public String tabid;
  public String tabname;
  public String windowname;
  public String seqno;
  public String tablevel;
  public String tabnamecompact;
  public String key;
  public String tdClass;
  public String href;
  public String tdHeight;
  public String parentKey;
  public String realwindowname;
  public String whereclause;
  public String windowtype;
  public String issorttab;
  public String adColumnsortorderId;
  public String adColumnsortyesnoId;
  public String accesslevel;
  public String adProcessId;
  public String uipattern;
  public String realtabname;
  public String orderbyclause;
  public String tabnametrl;
  public String tableId;
  public String isinfotab;
  public String istranslationtab;
  public String nametab;
  public String filterclause;
  public String editreference;
  public String javapackage;
  public String tabmodule;
  public String isdeleteable;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tabid"))
      return tabid;
    else if (fieldName.equalsIgnoreCase("tabname"))
      return tabname;
    else if (fieldName.equalsIgnoreCase("windowname"))
      return windowname;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("tablevel"))
      return tablevel;
    else if (fieldName.equalsIgnoreCase("tabnamecompact"))
      return tabnamecompact;
    else if (fieldName.equalsIgnoreCase("key"))
      return key;
    else if (fieldName.equalsIgnoreCase("td_class") || fieldName.equals("tdClass"))
      return tdClass;
    else if (fieldName.equalsIgnoreCase("href"))
      return href;
    else if (fieldName.equalsIgnoreCase("td_height") || fieldName.equals("tdHeight"))
      return tdHeight;
    else if (fieldName.equalsIgnoreCase("parent_key") || fieldName.equals("parentKey"))
      return parentKey;
    else if (fieldName.equalsIgnoreCase("realwindowname"))
      return realwindowname;
    else if (fieldName.equalsIgnoreCase("whereclause"))
      return whereclause;
    else if (fieldName.equalsIgnoreCase("windowtype"))
      return windowtype;
    else if (fieldName.equalsIgnoreCase("issorttab"))
      return issorttab;
    else if (fieldName.equalsIgnoreCase("ad_columnsortorder_id") || fieldName.equals("adColumnsortorderId"))
      return adColumnsortorderId;
    else if (fieldName.equalsIgnoreCase("ad_columnsortyesno_id") || fieldName.equals("adColumnsortyesnoId"))
      return adColumnsortyesnoId;
    else if (fieldName.equalsIgnoreCase("accesslevel"))
      return accesslevel;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("uipattern"))
      return uipattern;
    else if (fieldName.equalsIgnoreCase("realtabname"))
      return realtabname;
    else if (fieldName.equalsIgnoreCase("orderbyclause"))
      return orderbyclause;
    else if (fieldName.equalsIgnoreCase("tabnametrl"))
      return tabnametrl;
    else if (fieldName.equalsIgnoreCase("table_id") || fieldName.equals("tableId"))
      return tableId;
    else if (fieldName.equalsIgnoreCase("isinfotab"))
      return isinfotab;
    else if (fieldName.equalsIgnoreCase("istranslationtab"))
      return istranslationtab;
    else if (fieldName.equalsIgnoreCase("nametab"))
      return nametab;
    else if (fieldName.equalsIgnoreCase("filterclause"))
      return filterclause;
    else if (fieldName.equalsIgnoreCase("editreference"))
      return editreference;
    else if (fieldName.equalsIgnoreCase("javapackage"))
      return javapackage;
    else if (fieldName.equalsIgnoreCase("tabmodule"))
      return tabmodule;
    else if (fieldName.equalsIgnoreCase("isdeleteable"))
      return isdeleteable;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Tabs of windows with name like parameter
 */
  public static TabsData[] selectTabs(ConnectionProvider connectionProvider, String name)    throws ServletException {
    return selectTabs(connectionProvider, name, 0, 0);
  }

/**
Tabs of windows with name like parameter
 */
  public static TabsData[] selectTabs(ConnectionProvider connectionProvider, String name, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TAB.ad_tab_id AS tabId, AD_TAB.NAME AS tabName, AD_WINDOW.NAME AS windowName, " +
      "        AD_TAB.seqno AS seqNo, AD_TAB.tablevel AS tabLevel, AD_TAB.NAME AS tabNameCompact, " +
      "        AD_TAB.AD_WINDOW_ID AS KEY, '' AS TD_Class, '' AS href, '' AS Td_Height, '' AS Parent_Key, " +
      "        AD_WINDOW.NAME AS realWindowName, AD_TAB.whereclause, AD_WINDOW.windowtype, ad_tab.issorttab, ad_tab.AD_COLUMNSORTORDER_ID, " +
      "        ad_tab.AD_COLUMNSORTYESNO_ID," +
      "        AD_TABLE.ACCESSLEVEL, AD_TAB.ad_process_id, AD_TAB.UIPATTERN, AD_TAB.NAME AS realTabName, AD_TAB.ORDERBYCLAUSE, " +
      "        '' as tabNameTrl, AD_TABLE.ad_table_id AS table_Id, ad_tab.isInfoTab, ad_tab.isTranslationTab, '' AS NameTab, " +
      "        replace(replace(AD_TAB.FILTERCLAUSE, CHR(10), ' '), CHR(13), ' ') AS FILTERCLAUSE, AD_TAB.EDITREFERENCE," +
      "        (CASE WHEN M1.AD_MODULE_ID='0' THEN NULL ELSE M1.JavaPackage END) AS JAVAPACKAGE, AD_TAB.AD_MODULE_ID as tabmodule," +
      "        AD_TABLE.ISDELETEABLE" +
      "        FROM AD_TAB, AD_WINDOW, AD_TABLE, AD_MODULE M1" +
      "        WHERE AD_TAB.AD_WINDOW_ID = AD_WINDOW.AD_WINDOW_ID" +
      "        AND AD_TAB.AD_TABLE_ID = AD_TABLE.AD_TABLE_ID" +
      "        AND AD_TABLE.DataOriginType = 'Table'" +
      "        AND AD_WINDOW.IsActive = 'Y'" +
      "        AND AD_WINDOW.WindowType IN ('M', 'Q', 'T')" +
      "        AND UPPER(AD_WINDOW.NAME) LIKE '%' || UPPER(?) || '%'" +
      "        AND AD_TAB.ad_table_id IN" +
      "        (SELECT AD_TABLE.ad_table_id FROM AD_COLUMN, AD_TABLE " +
      "         WHERE AD_COLUMN.ad_table_id = AD_TABLE.ad_table_id" +
      "         AND (AD_COLUMN.iskey='Y' OR AD_COLUMN.issecondarykey='Y')" +
      "        AND AD_TAB.ISACTIVE = 'Y'" +
      "        AND EXISTS (SELECT 1 FROM AD_TAB, AD_COLUMN " +
      "        WHERE AD_TAB.AD_TABLE_ID = AD_COLUMN.ad_table_id" +
      "        AND AD_TAB.TABLEVEL = 0 " +
      "        AND (AD_COLUMN.iskey='Y' OR AD_COLUMN.issecondarykey='Y')" +
      "        )" +
      "        AND AD_TAB.ad_window_id = AD_WINDOW.ad_window_id)" +
      "        AND M1.AD_MODULE_ID = AD_WINDOW.AD_Module_ID" +
      "        AND 1=1" +
      "        ORDER BY AD_WINDOW.name, AD_TAB.tablevel, AD_TAB.seqno";

    ResultSet result;
    Vector<TabsData> vector = new Vector<TabsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

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
        TabsData objectTabsData = new TabsData();
        objectTabsData.tabid = UtilSql.getValue(result, "tabid");
        objectTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectTabsData.windowname = UtilSql.getValue(result, "windowname");
        objectTabsData.seqno = UtilSql.getValue(result, "seqno");
        objectTabsData.tablevel = UtilSql.getValue(result, "tablevel");
        objectTabsData.tabnamecompact = UtilSql.getValue(result, "tabnamecompact");
        objectTabsData.key = UtilSql.getValue(result, "key");
        objectTabsData.tdClass = UtilSql.getValue(result, "td_class");
        objectTabsData.href = UtilSql.getValue(result, "href");
        objectTabsData.tdHeight = UtilSql.getValue(result, "td_height");
        objectTabsData.parentKey = UtilSql.getValue(result, "parent_key");
        objectTabsData.realwindowname = UtilSql.getValue(result, "realwindowname");
        objectTabsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectTabsData.windowtype = UtilSql.getValue(result, "windowtype");
        objectTabsData.issorttab = UtilSql.getValue(result, "issorttab");
        objectTabsData.adColumnsortorderId = UtilSql.getValue(result, "ad_columnsortorder_id");
        objectTabsData.adColumnsortyesnoId = UtilSql.getValue(result, "ad_columnsortyesno_id");
        objectTabsData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectTabsData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectTabsData.uipattern = UtilSql.getValue(result, "uipattern");
        objectTabsData.realtabname = UtilSql.getValue(result, "realtabname");
        objectTabsData.orderbyclause = UtilSql.getValue(result, "orderbyclause");
        objectTabsData.tabnametrl = UtilSql.getValue(result, "tabnametrl");
        objectTabsData.tableId = UtilSql.getValue(result, "table_id");
        objectTabsData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectTabsData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectTabsData.nametab = UtilSql.getValue(result, "nametab");
        objectTabsData.filterclause = UtilSql.getValue(result, "filterclause");
        objectTabsData.editreference = UtilSql.getValue(result, "editreference");
        objectTabsData.javapackage = UtilSql.getValue(result, "javapackage");
        objectTabsData.tabmodule = UtilSql.getValue(result, "tabmodule");
        objectTabsData.isdeleteable = UtilSql.getValue(result, "isdeleteable");
        objectTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabsData);
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
    TabsData objectTabsData[] = new TabsData[vector.size()];
    vector.copyInto(objectTabsData);
    return(objectTabsData);
  }

  public static boolean selectShowWindowIn250ClassicMode(ConnectionProvider connectionProvider, String windowid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) as res " +
      "      FROM ad_tab t, ad_table tb" +
      "      WHERE t.ad_window_id = ? and" +
      "            t.isactive = 'Y' and" +
      "            tb.ad_table_id = t.ad_table_id and" +
      "            tb.dataorigintype = 'Table' and" +
      "      (" +
      "         (whereclause is not null and hqlwhereclause is null) OR " +
      "         (orderbyclause is not null and hqlorderbyclause is null) OR" +
      "         (filterclause is not null and hqlfilterclause is null) OR" +
      "         (editreference is not null)" +
      "      )";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowid);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "res").equals("0");
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
    return(boolReturn);
  }

  public static boolean selectShowWindowIn250ClassicModePreference(ConnectionProvider connectionProvider, String windowid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) as res FROM ad_preference p" +
      "      WHERE ad_window_id = ? and" +
      "            isactive = 'Y' and" +
      "            property = 'OBUIAPP_UseClassicMode'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowid);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "res").equals("0");
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
    return(boolReturn);
  }

/**
Tabs of windows with name like parameter
 */
  public static TabsData[] selectTabsinModules(ConnectionProvider connectionProvider, String name, String ModuleName)    throws ServletException {
    return selectTabsinModules(connectionProvider, name, ModuleName, 0, 0);
  }

/**
Tabs of windows with name like parameter
 */
  public static TabsData[] selectTabsinModules(ConnectionProvider connectionProvider, String name, String ModuleName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT distinct AD_TAB.ad_tab_id AS tabId, AD_TAB.NAME AS tabName, AD_WINDOW.NAME AS windowName, " +
      "        AD_TAB.seqno AS seqNo, AD_TAB.tablevel AS tabLevel, AD_TAB.NAME AS tabNameCompact, " +
      "        AD_TAB.AD_WINDOW_ID AS KEY, '' AS TD_Class, '' AS href, '' AS Td_Height, '' AS Parent_Key, " +
      "        AD_WINDOW.NAME AS realWindowName, AD_TAB.whereclause, AD_WINDOW.windowtype, ad_tab.issorttab, ad_tab.AD_COLUMNSORTORDER_ID, " +
      "        ad_tab.AD_COLUMNSORTYESNO_ID," +
      "        AD_TABLE.ACCESSLEVEL, AD_TAB.ad_process_id, AD_TAB.UIPATTERN, AD_TAB.NAME AS realTabName, AD_TAB.ORDERBYCLAUSE, " +
      "        '' as tabNameTrl, AD_TABLE.ad_table_id AS table_Id, ad_tab.isInfoTab, ad_tab.isTranslationTab, '' AS NameTab, " +
      "        replace(replace(AD_TAB.FILTERCLAUSE, CHR(10), ' '), CHR(13), ' ') AS FILTERCLAUSE, AD_TAB.EDITREFERENCE, " +
      "        (CASE WHEN M1.AD_MODULE_ID='0' THEN NULL ELSE M1.JavaPackage END) AS JAVAPACKAGE, AD_TAB.AD_MODULE_ID as tabmodule," +
      "        AD_TABLE.ISDELETEABLE" +
      "        FROM AD_TAB, AD_WINDOW, AD_TABLE, AD_MODULE M1, AD_MODULE M" +
      "        WHERE AD_TAB.AD_WINDOW_ID = AD_WINDOW.AD_WINDOW_ID" +
      "        AND AD_TAB.AD_TABLE_ID = AD_TABLE.AD_TABLE_ID " +
      "        AND AD_WINDOW.IsActive = 'Y'" +
      "        AND AD_WINDOW.WindowType IN ('M', 'Q', 'T')" +
      "        AND UPPER(AD_WINDOW.NAME) LIKE '%' || UPPER(?) || '%' " +
      "        AND AD_TAB.ad_table_id IN" +
      "        (SELECT AD_TABLE.ad_table_id FROM AD_COLUMN, AD_TABLE " +
      "         WHERE AD_COLUMN.ad_table_id = AD_TABLE.ad_table_id" +
      "         AND (AD_COLUMN.iskey='Y' OR AD_COLUMN.issecondarykey='Y')" +
      "        AND AD_TAB.ISACTIVE = 'Y'" +
      "        AND EXISTS (SELECT 1 FROM AD_TAB, AD_COLUMN " +
      "        WHERE AD_TAB.AD_TABLE_ID = AD_COLUMN.ad_table_id" +
      "        AND AD_TAB.TABLEVEL = 0 " +
      "        AND (AD_COLUMN.iskey='Y' OR AD_COLUMN.issecondarykey='Y')" +
      "        )" +
      "        AND AD_TAB.ad_window_id = AD_WINDOW.ad_window_id)" +
      "        AND M1.AD_MODULE_ID = AD_WINDOW.AD_Module_ID" +
      "        AND M.JAVAPACKAGE IN (";
    strSql = strSql + ((ModuleName==null || ModuleName.equals(""))?"":ModuleName);
    strSql = strSql + 
      ")" +
      "        AND EXISTS (SELECT 1" +
      "                      FROM AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND M.AD_MODULE_ID = W.AD_MODULE_ID" +
      "                    UNION" +
      "                    SELECT 1" +
      "                      FROM AD_TAB T," +
      "                           AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND M.AD_MODULE_ID = T.AD_MODULE_ID" +
      "                       AND W.AD_WINDOW_ID = T.AD_WINDOW_ID" +
      "                    UNION" +
      "                    SELECT 1                     " +
      "                      FROM AD_FIELD F," +
      "                           AD_TAB TB, AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND M.AD_MODULE_ID = F.AD_MODULE_ID" +
      "                       AND F.AD_TAB_ID = TB.AD_TAB_ID" +
      "                       AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                    UNION" +
      "                    SELECT 1" +
      "                      FROM AD_TABLE T," +
      "                           AD_TAB TB, AD_WINDOW W, AD_PACKAGE P" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND M.AD_MODULE_ID = P.AD_MODULE_ID" +
      "                       AND P.AD_PACKAGE_ID = T.AD_PACKAGE_ID" +
      "                       AND T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                       AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                    UNION" +
      "                     SELECT 1" +
      "                       FROM AD_COLUMN C," +
      "                            AD_TAB TB, AD_WINDOW W" +
      "                      WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                        AND M.AD_MODULE_ID = C.AD_MODULE_ID" +
      "                        AND C.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                        AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                       )" +
      "        ORDER BY AD_WINDOW.name, AD_TAB.tablevel, AD_TAB.seqno";

    ResultSet result;
    Vector<TabsData> vector = new Vector<TabsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      if (ModuleName != null && !(ModuleName.equals(""))) {
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
        TabsData objectTabsData = new TabsData();
        objectTabsData.tabid = UtilSql.getValue(result, "tabid");
        objectTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectTabsData.windowname = UtilSql.getValue(result, "windowname");
        objectTabsData.seqno = UtilSql.getValue(result, "seqno");
        objectTabsData.tablevel = UtilSql.getValue(result, "tablevel");
        objectTabsData.tabnamecompact = UtilSql.getValue(result, "tabnamecompact");
        objectTabsData.key = UtilSql.getValue(result, "key");
        objectTabsData.tdClass = UtilSql.getValue(result, "td_class");
        objectTabsData.href = UtilSql.getValue(result, "href");
        objectTabsData.tdHeight = UtilSql.getValue(result, "td_height");
        objectTabsData.parentKey = UtilSql.getValue(result, "parent_key");
        objectTabsData.realwindowname = UtilSql.getValue(result, "realwindowname");
        objectTabsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectTabsData.windowtype = UtilSql.getValue(result, "windowtype");
        objectTabsData.issorttab = UtilSql.getValue(result, "issorttab");
        objectTabsData.adColumnsortorderId = UtilSql.getValue(result, "ad_columnsortorder_id");
        objectTabsData.adColumnsortyesnoId = UtilSql.getValue(result, "ad_columnsortyesno_id");
        objectTabsData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectTabsData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectTabsData.uipattern = UtilSql.getValue(result, "uipattern");
        objectTabsData.realtabname = UtilSql.getValue(result, "realtabname");
        objectTabsData.orderbyclause = UtilSql.getValue(result, "orderbyclause");
        objectTabsData.tabnametrl = UtilSql.getValue(result, "tabnametrl");
        objectTabsData.tableId = UtilSql.getValue(result, "table_id");
        objectTabsData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectTabsData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectTabsData.nametab = UtilSql.getValue(result, "nametab");
        objectTabsData.filterclause = UtilSql.getValue(result, "filterclause");
        objectTabsData.editreference = UtilSql.getValue(result, "editreference");
        objectTabsData.javapackage = UtilSql.getValue(result, "javapackage");
        objectTabsData.tabmodule = UtilSql.getValue(result, "tabmodule");
        objectTabsData.isdeleteable = UtilSql.getValue(result, "isdeleteable");
        objectTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabsData);
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
    TabsData objectTabsData[] = new TabsData[vector.size()];
    vector.copyInto(objectTabsData);
    return(objectTabsData);
  }

  public static TabsData[] selectQuick(ConnectionProvider connectionProvider)    throws ServletException {
    return selectQuick(connectionProvider, 0, 0);
  }

  public static TabsData[] selectQuick(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT distinct AD_TAB.ad_tab_id AS tabId, AD_TAB.NAME AS tabName, AD_WINDOW.NAME AS windowName, " +
      "        AD_TAB.seqno AS seqNo, AD_TAB.tablevel AS tabLevel, AD_TAB.NAME AS tabNameCompact, " +
      "        AD_TAB.AD_WINDOW_ID AS KEY, '' AS TD_Class, '' AS href, '' AS Td_Height, '' AS Parent_Key, " +
      "        AD_WINDOW.NAME AS realWindowName, AD_TAB.whereclause, AD_WINDOW.windowtype, ad_tab.issorttab, ad_tab.AD_COLUMNSORTORDER_ID, " +
      "        ad_tab.AD_COLUMNSORTYESNO_ID," +
      "        AD_TABLE.ACCESSLEVEL, AD_TAB.ad_process_id, AD_TAB.UIPATTERN, AD_TAB.NAME AS realTabName, AD_TAB.ORDERBYCLAUSE, " +
      "        '' as tabNameTrl, AD_TABLE.ad_table_id AS table_Id, ad_tab.isInfoTab, ad_tab.isTranslationTab, '' AS NameTab, " +
      "        replace(replace(AD_TAB.FILTERCLAUSE, CHR(10), ' '), CHR(13), ' ') AS FILTERCLAUSE, AD_TAB.EDITREFERENCE, " +
      "        (CASE WHEN M1.AD_MODULE_ID='0' THEN NULL ELSE M1.JavaPackage END) AS JAVAPACKAGE, AD_TAB.AD_MODULE_ID as tabmodule," +
      "        AD_TABLE.ISDELETEABLE" +
      "        FROM AD_TAB, AD_WINDOW, AD_TABLE, AD_SYSTEM_INFO SI, AD_MODULE M1" +
      "        WHERE AD_TAB.AD_WINDOW_ID = AD_WINDOW.AD_WINDOW_ID" +
      "        AND AD_TAB.AD_TABLE_ID = AD_TABLE.AD_TABLE_ID " +
      "        AND AD_WINDOW.IsActive = 'Y'" +
      "        AND AD_WINDOW.WindowType IN ('M', 'Q', 'T')" +
      "        AND M1.AD_MODULE_ID = AD_WINDOW.AD_Module_ID" +
      "        AND AD_TAB.ad_table_id IN" +
      "        (SELECT AD_TABLE.ad_table_id FROM AD_COLUMN, AD_TABLE " +
      "         WHERE AD_COLUMN.ad_table_id = AD_TABLE.ad_table_id" +
      "         AND (AD_COLUMN.iskey='Y' OR AD_COLUMN.issecondarykey='Y')" +
      "        AND AD_TAB.ISACTIVE = 'Y'" +
      "        AND EXISTS (SELECT 1 FROM AD_TAB, AD_COLUMN " +
      "        WHERE AD_TAB.AD_TABLE_ID = AD_COLUMN.ad_table_id" +
      "        AND AD_TAB.TABLEVEL = 0 " +
      "        AND (AD_COLUMN.iskey='Y' OR AD_COLUMN.issecondarykey='Y')" +
      "        )" +
      "        AND AD_TAB.ad_window_id = AD_WINDOW.ad_window_id)" +
      "        AND EXISTS (SELECT 1" +
      "                      FROM AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND W.UPDATED > SI.LAST_BUILD" +
      "                    UNION" +
      "                    SELECT 1" +
      "                      FROM AD_TAB T," +
      "                           AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND T.UPDATED > SI.LAST_BUILD" +
      "                       AND W.AD_WINDOW_ID = T.AD_WINDOW_ID" +
      "                    UNION" +
      "                    SELECT 1                     " +
      "                      FROM AD_FIELD F," +
      "                           AD_TAB TB, AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND F.UPDATED > SI.LAST_BUILD" +
      "                       AND F.AD_TAB_ID = TB.AD_TAB_ID" +
      "                       AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                    UNION" +
      "                    SELECT 1" +
      "                      FROM AD_TABLE T," +
      "                           AD_TAB TB, AD_WINDOW W" +
      "                     WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND T.UPDATED > SI.LAST_BUILD" +
      "                       AND T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                       AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                    UNION" +
      "                     SELECT 1" +
      "                       FROM AD_COLUMN C," +
      "                            AD_TAB TB, AD_WINDOW W" +
      "                      WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                       AND C.UPDATED > SI.LAST_BUILD" +
      "                        AND C.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                        AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                    UNION" +
      "                      SELECT 1" +
      "                        FROM AD_COLUMN C, AD_TAB TB, AD_WINDOW W, AD_COLUMN C2, AD_REF_SEARCH R" +
      "                       WHERE AD_WINDOW.AD_WINDOW_ID = W.AD_WINDOW_ID" +
      "                         AND R.AD_TABLE_ID = C.AD_TABLE_ID" +
      "                         AND C.UPDATED > SI.LAST_BUILD" +
      "                         AND C2.AD_REFERENCE_ID = '30'" +
      "                         AND C2.AD_REFERENCE_VALUE_ID = R.AD_REFERENCE_ID" +
      "                         AND C2.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "                         AND W.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                    UNION" +
      "                      SELECT 1" +
      "                        FROM AD_AUXILIARINPUT A, AD_TAB TB" +
      "                       WHERE AD_WINDOW.AD_WINDOW_ID = TB.AD_WINDOW_ID" +
      "                         AND A.AD_TAB_ID = TB.AD_TAB_ID" +
      "                         AND A.UPDATED > SI.LAST_BUILD" +
      "                     UNION" +
      "                       SELECT 1" +
      "                         FROM AD_PREFERENCE P" +
      "                         WHERE P.AD_WINDOW_ID = AD_WINDOW.AD_WINDOW_ID" +
      "                         AND ISACTIVE='Y'" +
      "                         AND PROPERTY = 'OBUIAPP_UseClassicMode'" +
      "                         AND P.UPDATED > SI.LAST_BUILD" +
      "                       )" +
      "        ORDER BY AD_WINDOW.name, AD_TAB.tablevel, AD_TAB.seqno";

    ResultSet result;
    Vector<TabsData> vector = new Vector<TabsData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        TabsData objectTabsData = new TabsData();
        objectTabsData.tabid = UtilSql.getValue(result, "tabid");
        objectTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectTabsData.windowname = UtilSql.getValue(result, "windowname");
        objectTabsData.seqno = UtilSql.getValue(result, "seqno");
        objectTabsData.tablevel = UtilSql.getValue(result, "tablevel");
        objectTabsData.tabnamecompact = UtilSql.getValue(result, "tabnamecompact");
        objectTabsData.key = UtilSql.getValue(result, "key");
        objectTabsData.tdClass = UtilSql.getValue(result, "td_class");
        objectTabsData.href = UtilSql.getValue(result, "href");
        objectTabsData.tdHeight = UtilSql.getValue(result, "td_height");
        objectTabsData.parentKey = UtilSql.getValue(result, "parent_key");
        objectTabsData.realwindowname = UtilSql.getValue(result, "realwindowname");
        objectTabsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectTabsData.windowtype = UtilSql.getValue(result, "windowtype");
        objectTabsData.issorttab = UtilSql.getValue(result, "issorttab");
        objectTabsData.adColumnsortorderId = UtilSql.getValue(result, "ad_columnsortorder_id");
        objectTabsData.adColumnsortyesnoId = UtilSql.getValue(result, "ad_columnsortyesno_id");
        objectTabsData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectTabsData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectTabsData.uipattern = UtilSql.getValue(result, "uipattern");
        objectTabsData.realtabname = UtilSql.getValue(result, "realtabname");
        objectTabsData.orderbyclause = UtilSql.getValue(result, "orderbyclause");
        objectTabsData.tabnametrl = UtilSql.getValue(result, "tabnametrl");
        objectTabsData.tableId = UtilSql.getValue(result, "table_id");
        objectTabsData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectTabsData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectTabsData.nametab = UtilSql.getValue(result, "nametab");
        objectTabsData.filterclause = UtilSql.getValue(result, "filterclause");
        objectTabsData.editreference = UtilSql.getValue(result, "editreference");
        objectTabsData.javapackage = UtilSql.getValue(result, "javapackage");
        objectTabsData.tabmodule = UtilSql.getValue(result, "tabmodule");
        objectTabsData.isdeleteable = UtilSql.getValue(result, "isdeleteable");
        objectTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabsData);
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
    TabsData objectTabsData[] = new TabsData[vector.size()];
    vector.copyInto(objectTabsData);
    return(objectTabsData);
  }

/**
Parent Tab for the window
 */
  public static TabsData[] selectTabParent(ConnectionProvider connectionProvider, String windowId)    throws ServletException {
    return selectTabParent(connectionProvider, windowId, 0, 0);
  }

/**
Parent Tab for the window
 */
  public static TabsData[] selectTabParent(ConnectionProvider connectionProvider, String windowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_tab_id as tabId " +
      "        FROM ad_tab" +
      "        WHERE ad_tab.tablevel = 0 " +
      "          AND ad_tab.isactive = 'Y'" +
      "          AND ad_tab.AD_WINDOW_ID = ?";

    ResultSet result;
    Vector<TabsData> vector = new Vector<TabsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        TabsData objectTabsData = new TabsData();
        objectTabsData.tabid = UtilSql.getValue(result, "tabid");
        objectTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabsData);
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
    TabsData objectTabsData[] = new TabsData[vector.size()];
    vector.copyInto(objectTabsData);
    return(objectTabsData);
  }

  public static boolean isTabActive(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) as ad_tab_id" +
      "          FROM AD_TAB" +
      "         WHERE AD_TAB_ID = ?" +
      "           AND ISACTIVE = 'Y' ";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "ad_tab_id").equals("0");
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
    return(boolReturn);
  }

  public static String selectParentTab(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select t.ad_tab_id" +
      "         from ad_tab t, ad_tab t1" +
      "        where t1.ad_window_id = t.ad_window_id" +
      "          and t1.ad_tab_id = ?" +
      "          and t.seqno < t1.seqno" +
      "          and t.tablevel < t1.tablevel" +
      "          and t.seqno = (select max(t2.seqno)" +
      "                           from ad_tab t2, ad_tab t3" +
      "                          where t3.ad_window_id = t2.ad_window_id" +
      "                            and t3.ad_tab_id = t1.ad_tab_id" +
      "                            and t2.seqno < t3.seqno" +
      "                            and t2.tablevel < t3.tablevel) ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tab_id");
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
