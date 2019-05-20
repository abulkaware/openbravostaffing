//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.modules;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ModuleTreeData implements FieldProvider {
static Logger log4j = Logger.getLogger(ModuleTreeData.class);
  private String InitRecordNumber="0";
  public String type;
  public String nodeId;
  public String name;
  public String display;
  public String linkclick;
  public String linkname;
  public String linkclick1;
  public String linkname1;
  public String description;
  public String version;
  public String statusName;
  public String status;
  public String updateAvailable;
  public String help;
  public String author;
  public String url;
  public String levelno;
  public String leveltree;
  public String icon;
  public String icon2;
  public String endline;
  public String updateversion;
  public String updatedescription;
  public String position;
  public String updateVerId;
  public String style;
  public String seqno;
  public String modulename;
  public String versionLabel;
  public String enabled;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("display"))
      return display;
    else if (fieldName.equalsIgnoreCase("linkclick"))
      return linkclick;
    else if (fieldName.equalsIgnoreCase("linkname"))
      return linkname;
    else if (fieldName.equalsIgnoreCase("linkclick1"))
      return linkclick1;
    else if (fieldName.equalsIgnoreCase("linkname1"))
      return linkname1;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("version"))
      return version;
    else if (fieldName.equalsIgnoreCase("status_name") || fieldName.equals("statusName"))
      return statusName;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("update_available") || fieldName.equals("updateAvailable"))
      return updateAvailable;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("author"))
      return author;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("levelno"))
      return levelno;
    else if (fieldName.equalsIgnoreCase("leveltree"))
      return leveltree;
    else if (fieldName.equalsIgnoreCase("icon"))
      return icon;
    else if (fieldName.equalsIgnoreCase("icon2"))
      return icon2;
    else if (fieldName.equalsIgnoreCase("endline"))
      return endline;
    else if (fieldName.equalsIgnoreCase("updateversion"))
      return updateversion;
    else if (fieldName.equalsIgnoreCase("updatedescription"))
      return updatedescription;
    else if (fieldName.equalsIgnoreCase("position"))
      return position;
    else if (fieldName.equalsIgnoreCase("update_ver_id") || fieldName.equals("updateVerId"))
      return updateVerId;
    else if (fieldName.equalsIgnoreCase("style"))
      return style;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("modulename"))
      return modulename;
    else if (fieldName.equalsIgnoreCase("version_label") || fieldName.equals("versionLabel"))
      return versionLabel;
    else if (fieldName.equalsIgnoreCase("enabled"))
      return enabled;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ModuleTreeData[] select(ConnectionProvider connectionProvider, String lang)    throws ServletException {
    return select(connectionProvider, lang, 0, 0);
  }

  public static ModuleTreeData[] select(ConnectionProvider connectionProvider, String lang, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT COALESCE(MI.Type, M.Type) as Type, COALESCE(MI.AD_Module_ID, M.AD_Module_ID) as Node_ID, " +
      "                (CASE WHEN MI.AD_Module_ID IS NOT NULL " +
      "                         THEN AD_Column_Identifier('AD_Module_Install',MI.AD_Module_Install_ID, ?)" +
      "                         ELSE AD_Column_Identifier('AD_Module',M.AD_Module_ID, ?) END) as Name, " +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module M2" +
      "                    WHERE M2.AD_Module_ID = M.AD_Module_ID" +
      "                    AND EXISTS" +
      "                    (SELECT 1" +
      "                            FROM AD_Module_Dependency" +
      "                           WHERE AD_Module_ID = M2.AD_Module_ID" +
      "                             AND IsIncluded = 'Y'" +
      "                           UNION" +
      "                           SELECT 1" +
      "                            FROM AD_Module_Dependency_Inst" +
      "                           WHERE AD_Module_ID = M2.AD_Module_ID" +
      "                             AND IsIncluded = 'Y'))                as display," +
      "                     '' as linkClick," +
      "                     '' as linkName," +
      "                     '' as linkClick1," +
      "                     '' as linkName1," +
      "                     '' as Description," +
      "                     COALESCE(MI.version, M.version) as Version," +
      "                     '' as Status_Name," +
      "                     M.Status," +
      "                     M.Update_Available," +
      "                     COALESCE(MI.help, M.help) as help," +
      "                     COALESCE(MI.author, M.author) as author," +
      "                     COALESCE(MI.url, M.url) as url," +
      "                     '' as levelno," +
      "                     '' as leveltree," +
      "                     '' as icon," +
      "                     '' as icon2," +
      "                     '' as endline," +
      "                     '' as updateversion," +
      "                     '' as updatedescription," +
      "                     '' as position," +
      "                     '' as UPDATE_VER_ID," +
      "                     '' as style," +
      "                     coalesce (MI.Seqno, M.SeqNo) as Seqno," +
      "                     coalesce (mi.name, m.name) as ModuleName," +
      "                     coalesce (mi.version_label, m.version_label) as version_label," +
      "                     m.enabled" +
      "           FROM AD_Module M left join AD_Module_Install MI" +
      "                                   on M.AD_Module_ID = MI.AD_Module_ID" +
      "          WHERE NOT EXISTS (SELECT 1 " +
      "                              FROM AD_Module_Dependency" +
      "                             WHERE AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                               AND IsIncluded = 'Y') " +
      "            AND m.ISACTIVE = 'Y'" +
      "          UNION" +
      "          SELECT Type, AD_Module_ID as Node_ID, " +
      "                 AD_Column_Identifier('AD_Module_Install',AD_Module_Install_ID, ?) as Name, " +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module_Dependency_Inst" +
      "                   WHERE AD_Module_ID = M.AD_Module_ID" +
      "                     AND IsIncluded = 'Y')                as display," +
      "                     '' as linkClick," +
      "                     '' as linkName," +
      "                     '' as linkClick1," +
      "                     '' as linkName1," +
      "                     '' as Description," +
      "                     m.Version," +
      "                     '' as Status_Name," +
      "                     M.Status," +
      "                     M.Update_Available," +
      "                     M.help," +
      "                     M.author," +
      "                     M.url," +
      "                     '' as levelno," +
      "                     '' as leveltree," +
      "                     '' as icon," +
      "                     '' as icon2," +
      "                     '' as endline," +
      "                     '' as updateversion," +
      "                     '' as updatedescription," +
      "                     '' as position," +
      "                     '' as UPDATE_VER_ID," +
      "                     '' as style," +
      "                     Seqno," +
      "                     m.name as ModuleName," +
      "                     m.version_label," +
      "                     'Y' as enabled" +
      "           FROM AD_Module_Install M " +
      "          WHERE NOT EXISTS (SELECT 1 " +
      "                              FROM AD_Module_Dependency_Inst" +
      "                             WHERE AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                               AND IsIncluded = 'Y') " +
      "            AND NOT EXISTS (SELECT 1 " +
      "                               FROM AD_MODULE" +
      "                              WHERE AD_Module_ID = M.AD_Module_ID)" +
      "            AND ISACTIVE = 'Y'" +
      "            order by Seqno, name";

    ResultSet result;
    Vector<ModuleTreeData> vector = new Vector<ModuleTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

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
        ModuleTreeData objectModuleTreeData = new ModuleTreeData();
        objectModuleTreeData.type = UtilSql.getValue(result, "type");
        objectModuleTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectModuleTreeData.name = UtilSql.getValue(result, "name");
        objectModuleTreeData.display = UtilSql.getValue(result, "display");
        objectModuleTreeData.linkclick = UtilSql.getValue(result, "linkclick");
        objectModuleTreeData.linkname = UtilSql.getValue(result, "linkname");
        objectModuleTreeData.linkclick1 = UtilSql.getValue(result, "linkclick1");
        objectModuleTreeData.linkname1 = UtilSql.getValue(result, "linkname1");
        objectModuleTreeData.description = UtilSql.getValue(result, "description");
        objectModuleTreeData.version = UtilSql.getValue(result, "version");
        objectModuleTreeData.statusName = UtilSql.getValue(result, "status_name");
        objectModuleTreeData.status = UtilSql.getValue(result, "status");
        objectModuleTreeData.updateAvailable = UtilSql.getValue(result, "update_available");
        objectModuleTreeData.help = UtilSql.getValue(result, "help");
        objectModuleTreeData.author = UtilSql.getValue(result, "author");
        objectModuleTreeData.url = UtilSql.getValue(result, "url");
        objectModuleTreeData.levelno = UtilSql.getValue(result, "levelno");
        objectModuleTreeData.leveltree = UtilSql.getValue(result, "leveltree");
        objectModuleTreeData.icon = UtilSql.getValue(result, "icon");
        objectModuleTreeData.icon2 = UtilSql.getValue(result, "icon2");
        objectModuleTreeData.endline = UtilSql.getValue(result, "endline");
        objectModuleTreeData.updateversion = UtilSql.getValue(result, "updateversion");
        objectModuleTreeData.updatedescription = UtilSql.getValue(result, "updatedescription");
        objectModuleTreeData.position = UtilSql.getValue(result, "position");
        objectModuleTreeData.updateVerId = UtilSql.getValue(result, "update_ver_id");
        objectModuleTreeData.style = UtilSql.getValue(result, "style");
        objectModuleTreeData.seqno = UtilSql.getValue(result, "seqno");
        objectModuleTreeData.modulename = UtilSql.getValue(result, "modulename");
        objectModuleTreeData.versionLabel = UtilSql.getValue(result, "version_label");
        objectModuleTreeData.enabled = UtilSql.getValue(result, "enabled");
        objectModuleTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleTreeData);
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
    ModuleTreeData objectModuleTreeData[] = new ModuleTreeData[vector.size()];
    vector.copyInto(objectModuleTreeData);
    return(objectModuleTreeData);
  }

  public static ModuleTreeData[] selectSubTree(ConnectionProvider connectionProvider, String lang, String rootNode)    throws ServletException {
    return selectSubTree(connectionProvider, lang, rootNode, 0, 0);
  }

  public static ModuleTreeData[] selectSubTree(ConnectionProvider connectionProvider, String lang, String rootNode, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT M.Type, M.AD_Module_ID as Node_ID, " +
      "                 (CASE WHEN MI.AD_MODULE_ID IS NULL " +
      "                                      THEN AD_Column_Identifier('AD_Module',m.AD_Module_ID, ?)" +
      "                                      ELSE AD_Column_Identifier('AD_Module_Install',MI.AD_Module_Install_ID, ?) END )as Name, " +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module M2" +
      "                    WHERE M2.AD_Module_ID = M.AD_Module_ID" +
      "                    AND EXISTS" +
      "                    (SELECT 1" +
      "                            FROM AD_Module_Dependency" +
      "                           WHERE AD_Module_ID = M2.AD_Module_ID" +
      "                             AND IsIncluded = 'Y'" +
      "                           UNION" +
      "                           SELECT 1" +
      "                            FROM AD_Module_Dependency_Inst" +
      "                           WHERE AD_Module_ID = M2.AD_Module_ID" +
      "                             AND IsIncluded = 'Y'))                as display," +
      "                     m.Status," +
      "                     m.Update_Available," +
      "                     coalesce(MI.version, M.version) as Version," +
      "                     coalesce(mi.name, m.name) as moduleName," +
      "                     coalesce(mi.version_label, m.version_label) as version_label," +
      "                     m.enabled," +
      "                     COALESCE(MI.author, M.author) as author" +
      "            FROM AD_MODULE M LEFT JOIN AD_MODULE_INSTALL MI" +
      "                                    ON MI.AD_MODULE_ID = M.AD_MODULE_ID" +
      "           WHERE EXISTS (SELECT 1 " +
      "                           FROM AD_Module_Dependency " +
      "                          WHERE AD_Module_ID = ?" +
      "                            AND AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                            AND IsIncluded = 'Y'" +
      "                          UNION" +
      "                          SELECT 1 " +
      "                           FROM AD_Module_Dependency_Inst" +
      "                          WHERE AD_Module_ID = ?" +
      "                            AND AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                            AND IsIncluded = 'Y')" +
      "             AND M.ISACTIVE = 'Y'" +
      "            UNION" +
      "             SELECT Type, AD_Module_ID as Node_ID, AD_Column_Identifier('AD_Module_Install',AD_Module_Install_ID, ?) as Name, " +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module_Dependency" +
      "                   WHERE AD_Module_ID = M.AD_Module_ID" +
      "                     AND IsIncluded = 'Y')                as display," +
      "                     Status," +
      "                     Update_Available," +
      "                     m.version," +
      "                     m.name as moduleName," +
      "                     m.version_label," +
      "                     'Y' as enabled," +
      "                     m.author" +
      "            FROM AD_MODULE_Install M" +
      "           WHERE EXISTS (SELECT 1 " +
      "                           FROM AD_Module_Dependency_Inst " +
      "                          WHERE AD_Module_ID = ?" +
      "                            AND AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                            AND IsIncluded = 'Y')" +
      "             AND NOT EXISTS (SELECT 1" +
      "                               FROM AD_MODULE" +
      "                              WHERE AD_Module_ID = M.AD_Module_ID)" +
      "             AND ISACTIVE = 'Y'";

    ResultSet result;
    Vector<ModuleTreeData> vector = new Vector<ModuleTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rootNode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rootNode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rootNode);

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
        ModuleTreeData objectModuleTreeData = new ModuleTreeData();
        objectModuleTreeData.type = UtilSql.getValue(result, "type");
        objectModuleTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectModuleTreeData.name = UtilSql.getValue(result, "name");
        objectModuleTreeData.display = UtilSql.getValue(result, "display");
        objectModuleTreeData.status = UtilSql.getValue(result, "status");
        objectModuleTreeData.updateAvailable = UtilSql.getValue(result, "update_available");
        objectModuleTreeData.version = UtilSql.getValue(result, "version");
        objectModuleTreeData.modulename = UtilSql.getValue(result, "modulename");
        objectModuleTreeData.versionLabel = UtilSql.getValue(result, "version_label");
        objectModuleTreeData.enabled = UtilSql.getValue(result, "enabled");
        objectModuleTreeData.author = UtilSql.getValue(result, "author");
        objectModuleTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleTreeData);
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
    ModuleTreeData objectModuleTreeData[] = new ModuleTreeData[vector.size()];
    vector.copyInto(objectModuleTreeData);
    return(objectModuleTreeData);
  }

  public static ModuleTreeData[] selectDescription(ConnectionProvider connectionProvider, String lang, String node)    throws ServletException {
    return selectDescription(connectionProvider, lang, node, 0, 0);
  }

  public static ModuleTreeData[] selectDescription(ConnectionProvider connectionProvider, String lang, String node, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COALESCE(MI.Name, M.Name) as Name," +
      "                 M.Version || (CASE WHEN MI.Version IS NULL " +
      "                                            THEN ''" +
      "                                            ELSE ' -> '||MI.Version END) as Version," +
      "                 COALESCE(MI.Description, T.Description, M.Description) as Description," +
      "                 COALESCE(MI.help, T.help, M.Help) as Help," +
      "                 COALESCE(MI.Author, M.author) as author," +
      "                 COALESCE(MI.url, M.url) as url," +
      "                 COALESCE(MI.status, M.status) as status," +
      "                 M.Update_Available," +
      "                 M.AD_Module_ID as Node_ID," +
      "                 COALESCE(RT.Name, R.Name) as Status_Name," +
      "                 COALESCE(T.UpdateInfo, M.UpdateInfo) as UpdateDescription," +
      "                 M.UPDATE_AVAILABLE as UpdateVersion," +
      "                 M.UPDATE_VER_ID" +
      "            FROM AD_MODULE M LEFT JOIN AD_MODULE_TRL T " +
      "                                     ON T.AD_Module_ID = M.AD_Module_ID" +
      "                                    AND T.AD_Language = ?" +
      "                              LEFT JOIN AD_MODULE_INSTALL MI" +
      "                                     ON MI.AD_MODULE_ID = M.AD_MODULE_ID," +
      "                 AD_REF_LIST R LEFT JOIN AD_REF_LIST_TRL RT" +
      "                                     ON RT.AD_Ref_List_ID = R.AD_Ref_list_ID" +
      "                                     AND RT.AD_Language = ? " +
      "           WHERE M.AD_Module_ID = ?" +
      "             AND R.AD_REFERENCE_ID = '725CD8C6882C40AFB4D1C27B1AEF8BB4'" +
      "             AND R.Value = M.Status" +
      "           UNION" +
      "           SELECT M.Name as Name," +
      "                 M.Version ," +
      "                 M.Description," +
      "                 M.Help," +
      "                 M.author," +
      "                 M.url," +
      "                 M.status," +
      "                 M.Update_Available," +
      "                 M.AD_Module_ID as Node_ID," +
      "                 COALESCE(RT.Name, R.Name) as Status_Name," +
      "                 m.UpdateInfo," +
      "                 M.UPDATE_AVAILABLE as UpdateVersion," +
      "                 M.UPDATE_VER_ID" +
      "            FROM AD_MODULE_INSTALL M," +
      "                 AD_REF_LIST R LEFT JOIN AD_REF_LIST_TRL RT" +
      "                                     ON RT.AD_Ref_List_ID = R.AD_Ref_list_ID" +
      "                                     AND RT.AD_Language = ? " +
      "           WHERE M.AD_Module_ID = ?" +
      "             AND R.AD_REFERENCE_ID = '725CD8C6882C40AFB4D1C27B1AEF8BB4'" +
      "             AND R.Value = M.Status";

    ResultSet result;
    Vector<ModuleTreeData> vector = new Vector<ModuleTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);

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
        ModuleTreeData objectModuleTreeData = new ModuleTreeData();
        objectModuleTreeData.name = UtilSql.getValue(result, "name");
        objectModuleTreeData.version = UtilSql.getValue(result, "version");
        objectModuleTreeData.description = UtilSql.getValue(result, "description");
        objectModuleTreeData.help = UtilSql.getValue(result, "help");
        objectModuleTreeData.author = UtilSql.getValue(result, "author");
        objectModuleTreeData.url = UtilSql.getValue(result, "url");
        objectModuleTreeData.status = UtilSql.getValue(result, "status");
        objectModuleTreeData.updateAvailable = UtilSql.getValue(result, "update_available");
        objectModuleTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectModuleTreeData.statusName = UtilSql.getValue(result, "status_name");
        objectModuleTreeData.updatedescription = UtilSql.getValue(result, "updatedescription");
        objectModuleTreeData.updateversion = UtilSql.getValue(result, "updateversion");
        objectModuleTreeData.updateVerId = UtilSql.getValue(result, "update_ver_id");
        objectModuleTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleTreeData);
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
    ModuleTreeData objectModuleTreeData[] = new ModuleTreeData[vector.size()];
    vector.copyInto(objectModuleTreeData);
    return(objectModuleTreeData);
  }

  public static ModuleTreeData[] selectUpdateDescription(ConnectionProvider connectionProvider, String lang, String node)    throws ServletException {
    return selectUpdateDescription(connectionProvider, lang, node, 0, 0);
  }

  public static ModuleTreeData[] selectUpdateDescription(ConnectionProvider connectionProvider, String lang, String node, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT COALESCE(T.UpdateInfo, M.UpdateInfo) as description," +
      "                 UPDATE_AVAILABLE as Version," +
      "                 M.AD_Module_ID as Node_ID" +
      "            FROM AD_MODULE M LEFT JOIN AD_MODULE_TRL T" +
      "                                    ON T.AD_Module_ID = M.AD_Module_ID" +
      "                                   AND T.AD_Language = ?" +
      "           WHERE M.AD_Module_ID = ?";

    ResultSet result;
    Vector<ModuleTreeData> vector = new Vector<ModuleTreeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);

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
        ModuleTreeData objectModuleTreeData = new ModuleTreeData();
        objectModuleTreeData.description = UtilSql.getValue(result, "description");
        objectModuleTreeData.version = UtilSql.getValue(result, "version");
        objectModuleTreeData.nodeId = UtilSql.getValue(result, "node_id");
        objectModuleTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleTreeData);
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
    ModuleTreeData objectModuleTreeData[] = new ModuleTreeData[vector.size()];
    vector.copyInto(objectModuleTreeData);
    return(objectModuleTreeData);
  }

  public static String selectParent(ConnectionProvider connectionProvider, String node)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT MAX(AD_Module_ID) as Node_ID" +
      "            FROM AD_MODULE_DEPENDENCY" +
      "           WHERE AD_Dependent_Module_ID = ?" +
      "             AND IsIncluded = 'Y'" +
      "           UNION" +
      "          SELECT MAX(AD_Module_ID) as Node_ID" +
      "            FROM AD_MODULE_DEPENDENCY_INST" +
      "           WHERE AD_Dependent_Module_ID = ?" +
      "             AND IsIncluded = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "node_id");
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
