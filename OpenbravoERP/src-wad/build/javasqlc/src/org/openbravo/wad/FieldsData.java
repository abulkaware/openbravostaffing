//Sqlc generated V1.O00-1
package org.openbravo.wad;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import java.util.*;

public class FieldsData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldsData.class);
  private String InitRecordNumber="0";
  public String adcolumnid;
  public String realname;
  public String name;
  public String nameref;
  public String xmltext;
  public String reference;
  public String referencevalue;
  public String required;
  public String isdisplayed;
  public String isupdateable;
  public String defaultvalue;
  public String fieldlength;
  public String textAlign;
  public String xmlFormat;
  public String displaylength;
  public String columnname;
  public String whereclause;
  public String tablename;
  public String type;
  public String issessionattr;
  public String iskey;
  public String isparent;
  public String accesslevel;
  public String isreadonly;
  public String issecondarykey;
  public String showinrelation;
  public String isencrypted;
  public String sortno;
  public String istranslated;
  public String id;
  public String htmltext;
  public String htmltexttrl;
  public String xmltexttrl;
  public String tablenametrl;
  public String nowrap;
  public String iscolumnencrypted;
  public String isdesencryptable;
  public String adReferenceValueId;
  public String adValRuleId;
  public String isjasper;
  public String isactive;
  public String adTabId;
  public String parentTabName;
  public String orgcode;
  public String tablemodule;
  public String columnmodule;
  public String clientcode;
  public String isautosave;
  public String adFieldId;
  public String trytext;
  public String catchtext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("adcolumnid"))
      return adcolumnid;
    else if (fieldName.equalsIgnoreCase("realname"))
      return realname;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("nameref"))
      return nameref;
    else if (fieldName.equalsIgnoreCase("xmltext"))
      return xmltext;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
    else if (fieldName.equalsIgnoreCase("referencevalue"))
      return referencevalue;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("isupdateable"))
      return isupdateable;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("fieldlength"))
      return fieldlength;
    else if (fieldName.equalsIgnoreCase("text_align") || fieldName.equals("textAlign"))
      return textAlign;
    else if (fieldName.equalsIgnoreCase("xml_format") || fieldName.equals("xmlFormat"))
      return xmlFormat;
    else if (fieldName.equalsIgnoreCase("displaylength"))
      return displaylength;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("whereclause"))
      return whereclause;
    else if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("issessionattr"))
      return issessionattr;
    else if (fieldName.equalsIgnoreCase("iskey"))
      return iskey;
    else if (fieldName.equalsIgnoreCase("isparent"))
      return isparent;
    else if (fieldName.equalsIgnoreCase("accesslevel"))
      return accesslevel;
    else if (fieldName.equalsIgnoreCase("isreadonly"))
      return isreadonly;
    else if (fieldName.equalsIgnoreCase("issecondarykey"))
      return issecondarykey;
    else if (fieldName.equalsIgnoreCase("showinrelation"))
      return showinrelation;
    else if (fieldName.equalsIgnoreCase("isencrypted"))
      return isencrypted;
    else if (fieldName.equalsIgnoreCase("sortno"))
      return sortno;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("htmltext"))
      return htmltext;
    else if (fieldName.equalsIgnoreCase("htmltexttrl"))
      return htmltexttrl;
    else if (fieldName.equalsIgnoreCase("xmltexttrl"))
      return xmltexttrl;
    else if (fieldName.equalsIgnoreCase("tablenametrl"))
      return tablenametrl;
    else if (fieldName.equalsIgnoreCase("nowrap"))
      return nowrap;
    else if (fieldName.equalsIgnoreCase("iscolumnencrypted"))
      return iscolumnencrypted;
    else if (fieldName.equalsIgnoreCase("isdesencryptable"))
      return isdesencryptable;
    else if (fieldName.equalsIgnoreCase("ad_reference_value_id") || fieldName.equals("adReferenceValueId"))
      return adReferenceValueId;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("isjasper"))
      return isjasper;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("parent_tab_name") || fieldName.equals("parentTabName"))
      return parentTabName;
    else if (fieldName.equalsIgnoreCase("orgcode"))
      return orgcode;
    else if (fieldName.equalsIgnoreCase("tablemodule"))
      return tablemodule;
    else if (fieldName.equalsIgnoreCase("columnmodule"))
      return columnmodule;
    else if (fieldName.equalsIgnoreCase("clientcode"))
      return clientcode;
    else if (fieldName.equalsIgnoreCase("isautosave"))
      return isautosave;
    else if (fieldName.equalsIgnoreCase("ad_field_id") || fieldName.equals("adFieldId"))
      return adFieldId;
    else if (fieldName.equals("trytext"))
      return trytext;
    else if (fieldName.equals("catchtext"))
      return catchtext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static FieldsData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static FieldsData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' as adColumnId, '' as realName, '' As Name, '' as NameRef, " +
      "        'x' as xmltext, '' as reference, '' as referencevalue," +
      "        '' as required, '' as isdisplayed, '' as isupdateable," +
      "        '' As defaultValue, " +
      "        '' As fieldLength, " +
      "        '' as Text_Align, '' AS Xml_Format, " +
      "        '' as displaylength, '' as columnname, " +
      "        '' as WHERECLAUSE, '' as tablename, '' as Type, '' as ISSESSIONATTR, '' as iskey, " +
      "        '' as isParent, '' as ACCESSLEVEL, '' as isreadonly, '' as issecondarykey, '' as showInRelation, '' as isEncrypted," +
      "        '' as SORTNO, '' as istranslated, '' as id, '' as htmltext, '' as htmltexttrl, '' as xmltexttrl, '' as tablenametrl, " +
      "        0 AS NOWRAP, '' as isColumnEncrypted, '' as isDesencryptable, '' as ad_reference_value_id, '' as ad_val_rule_id, '' AS isjasper, '' as isactive, '' as AD_Tab_ID, '' as parent_tab_name, '' as orgcode," +
      "        '' as tableModule, '' as columnModule, '' as clientcode, '' as isautosave, '' as ad_field_id" +
      "      FROM dual";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.adcolumnid = UtilSql.getValue(result, "adcolumnid");
        objectFieldsData.realname = UtilSql.getValue(result, "realname");
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.nameref = UtilSql.getValue(result, "nameref");
        objectFieldsData.xmltext = UtilSql.getValue(result, "xmltext");
        objectFieldsData.reference = UtilSql.getValue(result, "reference");
        objectFieldsData.referencevalue = UtilSql.getValue(result, "referencevalue");
        objectFieldsData.required = UtilSql.getValue(result, "required");
        objectFieldsData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectFieldsData.isupdateable = UtilSql.getValue(result, "isupdateable");
        objectFieldsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldsData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectFieldsData.textAlign = UtilSql.getValue(result, "text_align");
        objectFieldsData.xmlFormat = UtilSql.getValue(result, "xml_format");
        objectFieldsData.displaylength = UtilSql.getValue(result, "displaylength");
        objectFieldsData.columnname = UtilSql.getValue(result, "columnname");
        objectFieldsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectFieldsData.tablename = UtilSql.getValue(result, "tablename");
        objectFieldsData.type = UtilSql.getValue(result, "type");
        objectFieldsData.issessionattr = UtilSql.getValue(result, "issessionattr");
        objectFieldsData.iskey = UtilSql.getValue(result, "iskey");
        objectFieldsData.isparent = UtilSql.getValue(result, "isparent");
        objectFieldsData.accesslevel = UtilSql.getValue(result, "accesslevel");
        objectFieldsData.isreadonly = UtilSql.getValue(result, "isreadonly");
        objectFieldsData.issecondarykey = UtilSql.getValue(result, "issecondarykey");
        objectFieldsData.showinrelation = UtilSql.getValue(result, "showinrelation");
        objectFieldsData.isencrypted = UtilSql.getValue(result, "isencrypted");
        objectFieldsData.sortno = UtilSql.getValue(result, "sortno");
        objectFieldsData.istranslated = UtilSql.getValue(result, "istranslated");
        objectFieldsData.id = UtilSql.getValue(result, "id");
        objectFieldsData.htmltext = UtilSql.getValue(result, "htmltext");
        objectFieldsData.htmltexttrl = UtilSql.getValue(result, "htmltexttrl");
        objectFieldsData.xmltexttrl = UtilSql.getValue(result, "xmltexttrl");
        objectFieldsData.tablenametrl = UtilSql.getValue(result, "tablenametrl");
        objectFieldsData.nowrap = UtilSql.getValue(result, "nowrap");
        objectFieldsData.iscolumnencrypted = UtilSql.getValue(result, "iscolumnencrypted");
        objectFieldsData.isdesencryptable = UtilSql.getValue(result, "isdesencryptable");
        objectFieldsData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectFieldsData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFieldsData.isjasper = UtilSql.getValue(result, "isjasper");
        objectFieldsData.isactive = UtilSql.getValue(result, "isactive");
        objectFieldsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectFieldsData.parentTabName = UtilSql.getValue(result, "parent_tab_name");
        objectFieldsData.orgcode = UtilSql.getValue(result, "orgcode");
        objectFieldsData.tablemodule = UtilSql.getValue(result, "tablemodule");
        objectFieldsData.columnmodule = UtilSql.getValue(result, "columnmodule");
        objectFieldsData.clientcode = UtilSql.getValue(result, "clientcode");
        objectFieldsData.isautosave = UtilSql.getValue(result, "isautosave");
        objectFieldsData.adFieldId = UtilSql.getValue(result, "ad_field_id");
        objectFieldsData.trytext = "";
        objectFieldsData.catchtext = "";
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

/**
Name of the column key of the tab
 */
  public static FieldsData[] keyColumnName(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    return keyColumnName(connectionProvider, tab, 0, 0);
  }

/**
Name of the column key of the tab
 */
  public static FieldsData[] keyColumnName(ConnectionProvider connectionProvider, String tab, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ColumnName As Name, issecondarykey FROM ad_table, ad_column, ad_tab " +
      "        WHERE ad_table.ad_table_id = ad_column.ad_table_id" +
      "          AND ad_tab.ad_table_id = ad_table.ad_table_id" +
      "          AND ad_tab_id = ? " +
      "          and iskey='Y'";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.issecondarykey = UtilSql.getValue(result, "issecondarykey");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

/**
Name of the table of the tab
 */
  public static String tableName(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_table.TABLEName FROM ad_tab, ad_table" +
      "        WHERE ad_table.ad_table_id = ad_tab.ad_table_id and ad_tab_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "tablename");
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

/**
Name of the table of the tab
 */
  public static String columnIdentifier(ConnectionProvider connectionProvider, String tableName)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(columnname) AS NAME FROM AD_COLUMN, AD_TABLE " +
      "        WHERE AD_TABLE.TABLENAME = ?" +
      "          AND AD_COLUMN.ad_table_id = AD_TABLE.ad_table_id" +
      "          AND isidentifier = 'Y' " +
      "          AND SeqNo = (CASE TO_CHAR(AD_TABLE.TABLENAME) " +
      "                          WHEN 'C_PaySelectionCheck' THEN 2 " +
      "                          ELSE (SELECT MIN(SeqNo) " +
      "                                  FROM AD_Column " +
      "                                 WHERE AD_Table_ID=AD_TABLE.AD_Table_ID " +
      "                                   AND IsIdentifier='Y')" +
      "                           END)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableName);

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

/**
isSOTrx of the window
 */
  public static String isSOTrx(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT isSOTrx FROM AD_WINDOW, AD_TAB " +
      "      WHERE AD_TAB.AD_WINDOW_ID = AD_WINDOW.AD_WINDOW_ID " +
      "      AND AD_TAB.AD_TAB_ID = ?";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issotrx");
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

/**
Names of the columns of the fields of a tab
 */
  public static FieldsData[] selectActionButton(ConnectionProvider connectionProvider)    throws ServletException {
    return selectActionButton(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static FieldsData[] selectActionButton(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT distinct ad_column.columnname, " +
      "      ad_column.ad_process_id as reference, ad_process.procedurename as name, " +
      "      ad_column.ad_reference_id as type, ad_column.ad_reference_value_id as referencevalue," +
      "      ad_val_rule_id as defaultvalue, ad_column.fieldlength, ad_field.name as realname, " +
      "      ad_process.description as tablename, ad_process.help as xmltext, ad_column.ad_reference_value_id, ad_process.isjasper, ad_column.isautosave" +
      "      FROM ad_column, ad_process, ad_field" +
      "      where ad_column.ad_process_id = ad_process.ad_process_id " +
      "      and ad_column.ad_column_id = ad_field.ad_column_id  " +
      "      AND ad_field.ignoreinwad='N'" +
      "      AND (ad_process.procedurename is not null " +
      "           or ad_process.isjasper = 'Y'" +
      "           or (UIPattern='S' AND EXISTS (SELECT 1 FROM AD_MODEL_OBJECT WHERE AD_PROCESS_ID = AD_PROCESS.AD_PROCESS_ID))) " +
      "      and ad_column.columnname not in('DocAction', 'PaymentRule') " +
      "      and (ad_column.columnname <> 'CreateFrom'" +
      "      or ad_column.ad_process_id is not null)" +
      "      and (ad_column.columnname <> 'Posted'" +
      "      or ad_column.ad_process_id is not null)" +
      "      and ad_column.ad_column_id in (select ad_column_id from ad_field where isdisplayed='Y' and isactive='Y')" +
      "      and ad_column.isactive='Y'" +
      "      order by ad_column.ad_process_id";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.columnname = UtilSql.getValue(result, "columnname");
        objectFieldsData.reference = UtilSql.getValue(result, "reference");
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.type = UtilSql.getValue(result, "type");
        objectFieldsData.referencevalue = UtilSql.getValue(result, "referencevalue");
        objectFieldsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldsData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectFieldsData.realname = UtilSql.getValue(result, "realname");
        objectFieldsData.tablename = UtilSql.getValue(result, "tablename");
        objectFieldsData.xmltext = UtilSql.getValue(result, "xmltext");
        objectFieldsData.adReferenceValueId = UtilSql.getValue(result, "ad_reference_value_id");
        objectFieldsData.isjasper = UtilSql.getValue(result, "isjasper");
        objectFieldsData.isautosave = UtilSql.getValue(result, "isautosave");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static boolean buildActionButton(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT count(*) as total" +
      "      FROM ad_column, ad_process, ad_field, ad_system_info si" +
      "      where ad_column.ad_process_id = ad_process.ad_process_id " +
      "      and ad_column.ad_column_id = ad_field.ad_column_id " +
      "      AND (ad_process.procedurename is not null " +
      "           or ad_process.isjasper = 'Y'" +
      "           or (UIPattern='S' AND EXISTS (SELECT 1 FROM AD_MODEL_OBJECT WHERE AD_PROCESS_ID = AD_PROCESS.AD_PROCESS_ID)))" +
      "      and ad_column.columnname not in('DocAction', 'PaymentRule') " +
      "      and (ad_column.columnname <> 'CreateFrom'" +
      "      or ad_column.ad_process_id is not null)" +
      "      and ad_field.ignoreinwad='N'" +
      "      and (ad_column.columnname <> 'Posted'" +
      "      or ad_column.ad_process_id is not null)" +
      "      and ad_column.ad_column_id in (select ad_column_id from ad_field where isdisplayed='Y' and isactive='Y')" +
      "      and ad_column.isactive='Y'" +
      "      and (ad_process.updated > si.last_build" +
      "           or exists (select 1 " +
      "                        from ad_process_para pp " +
      "                       where pp.ad_process_id = ad_process.ad_process_id" +
      "                         and pp.updated > si.last_build))";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
Names of the columns of the fields of a tab
 */
  public static FieldsData[] selectActionButtonGenerics(ConnectionProvider connectionProvider)    throws ServletException {
    return selectActionButtonGenerics(connectionProvider, 0, 0);
  }

/**
Names of the columns of the fields of a tab
 */
  public static FieldsData[] selectActionButtonGenerics(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT 'ActionButton'  AS columnname, " +
      "        ad_process_id AS reference, procedurename AS NAME, " +
      "        '' AS TYPE, '' AS referencevalue," +
      "        '' AS defaultvalue, '' AS fieldlength, '' AS realname, " +
      "        description AS tablename, help AS xmltext, isjasper, '' AS isautosave" +
      "        FROM AD_PROCESS" +
      "        WHERE isactive='Y'" +
      "        AND UIPattern='S'" +
      "        and ad_process_id in (select ad_process_id from ad_menu)" +
      "        ORDER BY ad_process_id";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.columnname = UtilSql.getValue(result, "columnname");
        objectFieldsData.reference = UtilSql.getValue(result, "reference");
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.type = UtilSql.getValue(result, "type");
        objectFieldsData.referencevalue = UtilSql.getValue(result, "referencevalue");
        objectFieldsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldsData.fieldlength = UtilSql.getValue(result, "fieldlength");
        objectFieldsData.realname = UtilSql.getValue(result, "realname");
        objectFieldsData.tablename = UtilSql.getValue(result, "tablename");
        objectFieldsData.xmltext = UtilSql.getValue(result, "xmltext");
        objectFieldsData.isjasper = UtilSql.getValue(result, "isjasper");
        objectFieldsData.isautosave = UtilSql.getValue(result, "isautosave");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

/**
Names of the columns of the fields of a tab
 */
  public static String hasCreateFromButton(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(ad_column.ad_process_id, '-1') AS total " +
      "        FROM AD_FIELD, AD_COLUMN, AD_TABLE" +
      "        WHERE AD_FIELD.ad_column_id = AD_COLUMN.ad_column_id" +
      "        AND AD_COLUMN.AD_TABLE_ID = AD_TABLE.AD_TABLE_ID " +
      "        AND ad_tab_id = ? " +
      "        AND ad_field.ignoreinwad='N'" +
      "        AND AD_COLUMN.ad_reference_id = '28'" +
      "        AND AD_COLUMN.COLUMNNAME = 'CreateFrom'" +
      "        AND AD_COLUMN.AD_PROCESS_ID IS NULL" +
      "        AND AD_FIELD.ISDISPLAYED = 'Y'";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

/**
Names of the columns of the fields of a tab
 */
  public static String hasPostedButton(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(ad_column.ad_process_id, '-1') AS total " +
      "        FROM AD_FIELD, AD_COLUMN, AD_TABLE" +
      "        WHERE AD_FIELD.ad_column_id = AD_COLUMN.ad_column_id" +
      "        AND AD_COLUMN.AD_TABLE_ID = AD_TABLE.AD_TABLE_ID " +
      "        AND ad_tab_id = ? " +
      "        AND ad_field.ignoreinwad='N'" +
      "        AND AD_COLUMN.ad_reference_id = '28'" +
      "        AND AD_COLUMN.COLUMNNAME = 'Posted'" +
      "        AND AD_COLUMN.AD_PROCESS_ID IS NULL" +
      "        AND AD_FIELD.ISDISPLAYED = 'Y'";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

/**
Obtains all processes that might require combo reload
 */
  public static FieldsData[] selectProcessesWithReloads(ConnectionProvider connectionProvider)    throws ServletException {
    return selectProcessesWithReloads(connectionProvider, 0, 0);
  }

/**
Obtains all processes that might require combo reload
 */
  public static FieldsData[] selectProcessesWithReloads(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT distinct c.AD_PROCESS_id as id" +
      "        FROM AD_PROCESS_PARA c left join  AD_VAL_RULE v on c.AD_VAL_RULE_ID = v.AD_VAL_RULE_ID" +
      "                         left join AD_REF_TABLE t on (CASE c.ad_reference_id WHEN '18' THEN c.AD_REFERENCE_VALUE_ID ELSE '0' END) = t.AD_REFERENCE_ID     " +
      "        WHERE (t.whereclause IS NOT NULL" +
      "            OR v.code IS NOT NULL" +
      "            OR c.ad_reference_id in ('19','18','17'))";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.id = UtilSql.getValue(result, "id");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

/**
Obtains all param for processes that might require combo reload
 */
  public static FieldsData[] selectValidationProcess(ConnectionProvider connectionProvider, String processId)    throws ServletException {
    return selectValidationProcess(connectionProvider, processId, 0, 0);
  }

/**
Obtains all param for processes that might require combo reload
 */
  public static FieldsData[] selectValidationProcess(ConnectionProvider connectionProvider, String processId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT c.AD_PROCESS_PARA_id as id, c.columnname, t.WHERECLAUSE as whereClause, v.code as referencevalue, c.ad_reference_id as reference," +
      "        c.ad_reference_value_id as NameRef, c.ad_val_rule_id as defaultvalue,  c.columnname as name," +
      "        (case when t.whereclause is not null or v.code is not null then 'C' else 'R' end) as type /*Combo reaload or Reference*/ " +
      "        FROM AD_PROCESS_PARA c left join  AD_VAL_RULE v on c.AD_VAL_RULE_ID = v.AD_VAL_RULE_ID" +
      "                         left join AD_REF_TABLE t on (CASE c.ad_reference_id WHEN '18' THEN c.AD_REFERENCE_VALUE_ID ELSE '0' END) = t.AD_REFERENCE_ID     " +
      "        WHERE (t.whereclause IS NOT NULL" +
      "            OR v.code IS NOT NULL" +
      "            OR c.ad_reference_id in ('19','18','17'))" +
      "         AND c.AD_Process_ID = ?";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.id = UtilSql.getValue(result, "id");
        objectFieldsData.columnname = UtilSql.getValue(result, "columnname");
        objectFieldsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectFieldsData.referencevalue = UtilSql.getValue(result, "referencevalue");
        objectFieldsData.reference = UtilSql.getValue(result, "reference");
        objectFieldsData.nameref = UtilSql.getValue(result, "nameref");
        objectFieldsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.type = UtilSql.getValue(result, "type");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

  public static boolean processHasOrgParam(ConnectionProvider connectionProvider, String processId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select count(*)" +
      "           from ad_process_para " +
      "          where lower(columnname) = 'ad_org_id'" +
      "            and ad_process_id = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "count").equals("0");
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

  public static FieldsData[] selectColumnTableProcess(ConnectionProvider connectionProvider, String processParaId)    throws ServletException {
    return selectColumnTableProcess(connectionProvider, processParaId, 0, 0);
  }

  public static FieldsData[] selectColumnTableProcess(ConnectionProvider connectionProvider, String processParaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ColumnName As Name, 'x' as xmltext, ad_reference_value_id as referencevalue, " +
      "      ad_val_rule.CODE as defaultValue, ad_val_rule.AD_VAL_RULE_ID as columnname," +
      "      ad_ref_table.WHERECLAUSE, ad_table.tablename, 'TableList' as tablenametrl, ad_table.name as nameref, " +
      "      '18' as reference, 'Y' as required, 'N'as istranslated " +
      "      FROM ad_process_para p left join ad_val_rule on p.AD_VAL_RULE_ID = ad_val_rule.AD_VAL_RULE_ID, " +
      "           ad_ref_table, " +
      "           ad_table " +
      "      WHERE ad_ref_table.ad_table_id = ad_table.ad_table_id " +
      "      AND p.AD_REFERENCE_VALUE_ID = ad_ref_table.AD_REFERENCE_ID  " +
      "      AND p.ad_process_para_id = ?" +
      "      AND p.ad_reference_id = '18'";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processParaId);

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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.xmltext = UtilSql.getValue(result, "xmltext");
        objectFieldsData.referencevalue = UtilSql.getValue(result, "referencevalue");
        objectFieldsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldsData.columnname = UtilSql.getValue(result, "columnname");
        objectFieldsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectFieldsData.tablename = UtilSql.getValue(result, "tablename");
        objectFieldsData.tablenametrl = UtilSql.getValue(result, "tablenametrl");
        objectFieldsData.nameref = UtilSql.getValue(result, "nameref");
        objectFieldsData.reference = UtilSql.getValue(result, "reference");
        objectFieldsData.required = UtilSql.getValue(result, "required");
        objectFieldsData.istranslated = UtilSql.getValue(result, "istranslated");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

  public static FieldsData[] selectColumnTableDirProcess(ConnectionProvider connectionProvider, String processParaId)    throws ServletException {
    return selectColumnTableDirProcess(connectionProvider, processParaId, 0, 0);
  }

  public static FieldsData[] selectColumnTableDirProcess(ConnectionProvider connectionProvider, String processParaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ColumnName As Name, 'x' as xmltext, ColumnName as referencevalue, " +
      "      ad_val_rule.CODE as defaultValue, ad_val_rule.AD_VAL_RULE_ID as columnname,  " +
      "      'TableDir' as tablenametrl, '' as WHERECLAUSE, '19' as reference, 'N' as istranslated " +
      "      FROM ad_process_para p left join ad_val_rule on p.AD_VAL_RULE_ID = ad_val_rule.AD_VAL_RULE_ID" +
      "      WHERE p.ad_process_para_id = ?" +
      "      AND ad_reference_id = '19'";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processParaId);

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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.name = UtilSql.getValue(result, "name");
        objectFieldsData.xmltext = UtilSql.getValue(result, "xmltext");
        objectFieldsData.referencevalue = UtilSql.getValue(result, "referencevalue");
        objectFieldsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldsData.columnname = UtilSql.getValue(result, "columnname");
        objectFieldsData.tablenametrl = UtilSql.getValue(result, "tablenametrl");
        objectFieldsData.whereclause = UtilSql.getValue(result, "whereclause");
        objectFieldsData.reference = UtilSql.getValue(result, "reference");
        objectFieldsData.istranslated = UtilSql.getValue(result, "istranslated");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }

/**
Checks if the tab has action buttons
 */
  public static String hasActionButton(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select count(*) as actionButtons" +
      "      from ad_field f, ad_column c" +
      "      where f.ad_column_id = c.ad_column_id " +
      "      and f.ad_tab_id = ?" +
      "      and f.isactive = 'Y'" +
      "      and f.isdisplayed = 'Y'" +
      "      and f.ignoreinwad='N'" +
      "      and c.isactive = 'Y'" +
      "      and ad_reference_value_id is not null" +
      "      and c.ad_reference_id = '28' ";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "actionbuttons");
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

  public static FieldsData[] explicitAccessProcess(ConnectionProvider connectionProvider, String tab)    throws ServletException {
    return explicitAccessProcess(connectionProvider, tab, 0, 0);
  }

  public static FieldsData[] explicitAccessProcess(ConnectionProvider connectionProvider, String tab, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.ad_process_id as id" +
      "        from ad_process p, ad_column c, ad_field f" +
      "       where f.ad_tab_id = ?" +
      "         and f.ad_column_id = c.ad_column_id" +
      "         and c.ad_process_id = p.ad_process_id" +
      "         and p.is_explicit_access = 'Y'";

    ResultSet result;
    Vector<FieldsData> vector = new Vector<FieldsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tab);

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
        FieldsData objectFieldsData = new FieldsData();
        objectFieldsData.id = UtilSql.getValue(result, "id");
        objectFieldsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldsData);
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
    FieldsData objectFieldsData[] = new FieldsData[vector.size()];
    vector.copyInto(objectFieldsData);
    return(objectFieldsData);
  }
}
