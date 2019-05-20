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

class VersionUtilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(VersionUtilityData.class);
  private String InitRecordNumber="0";
  public String adModuleId;
  public String name;
  public String version;
  public String type;
  public String adModuleDependencyId;
  public String adDependentModuleId;
  public String dependantModuleName;
  public String startversion;
  public String endversion;
  public String dependencyEnforcement;
  public String userEditableEnforcement;
  public String instanceEnforcement;
  public String installed;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("version"))
      return version;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("ad_module_dependency_id") || fieldName.equals("adModuleDependencyId"))
      return adModuleDependencyId;
    else if (fieldName.equalsIgnoreCase("ad_dependent_module_id") || fieldName.equals("adDependentModuleId"))
      return adDependentModuleId;
    else if (fieldName.equalsIgnoreCase("dependant_module_name") || fieldName.equals("dependantModuleName"))
      return dependantModuleName;
    else if (fieldName.equalsIgnoreCase("startversion"))
      return startversion;
    else if (fieldName.equalsIgnoreCase("endversion"))
      return endversion;
    else if (fieldName.equalsIgnoreCase("dependency_enforcement") || fieldName.equals("dependencyEnforcement"))
      return dependencyEnforcement;
    else if (fieldName.equalsIgnoreCase("user_editable_enforcement") || fieldName.equals("userEditableEnforcement"))
      return userEditableEnforcement;
    else if (fieldName.equalsIgnoreCase("instance_enforcement") || fieldName.equals("instanceEnforcement"))
      return instanceEnforcement;
    else if (fieldName.equalsIgnoreCase("installed"))
      return installed;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static VersionUtilityData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static VersionUtilityData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select '' as ad_module_id, '' as name, '' as version, '' as type," +
      "          '' as ad_module_dependency_id, '' as ad_dependent_module_id, '' as dependant_module_name, '' as startVersion, '' as endVersion," +
      "          '' as dependency_enforcement, '' as user_editable_enforcement, '' as instance_enforcement, '' as installed" +
      "        from dual";

    ResultSet result;
    Vector<VersionUtilityData> vector = new Vector<VersionUtilityData>(0);
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
        VersionUtilityData objectVersionUtilityData = new VersionUtilityData();
        objectVersionUtilityData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectVersionUtilityData.name = UtilSql.getValue(result, "name");
        objectVersionUtilityData.version = UtilSql.getValue(result, "version");
        objectVersionUtilityData.type = UtilSql.getValue(result, "type");
        objectVersionUtilityData.adModuleDependencyId = UtilSql.getValue(result, "ad_module_dependency_id");
        objectVersionUtilityData.adDependentModuleId = UtilSql.getValue(result, "ad_dependent_module_id");
        objectVersionUtilityData.dependantModuleName = UtilSql.getValue(result, "dependant_module_name");
        objectVersionUtilityData.startversion = UtilSql.getValue(result, "startversion");
        objectVersionUtilityData.endversion = UtilSql.getValue(result, "endversion");
        objectVersionUtilityData.dependencyEnforcement = UtilSql.getValue(result, "dependency_enforcement");
        objectVersionUtilityData.userEditableEnforcement = UtilSql.getValue(result, "user_editable_enforcement");
        objectVersionUtilityData.instanceEnforcement = UtilSql.getValue(result, "instance_enforcement");
        objectVersionUtilityData.installed = UtilSql.getValue(result, "installed");
        objectVersionUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectVersionUtilityData);
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
    VersionUtilityData objectVersionUtilityData[] = new VersionUtilityData[vector.size()];
    vector.copyInto(objectVersionUtilityData);
    return(objectVersionUtilityData);
  }

  public static VersionUtilityData[] readModules(ConnectionProvider connectionProvider)    throws ServletException {
    return readModules(connectionProvider, 0, 0);
  }

  public static VersionUtilityData[] readModules(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select m.ad_module_id, m.name, m.version, m.type, 'Y' as installed" +
      "        from ad_module m" +
      "        union" +
      "        select m.ad_module_id, m.name, m.version, m.type, 'N'" +
      "        from ad_module_install m" +
      "        order by installed desc, ad_module_id";

    ResultSet result;
    Vector<VersionUtilityData> vector = new Vector<VersionUtilityData>(0);
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
        VersionUtilityData objectVersionUtilityData = new VersionUtilityData();
        objectVersionUtilityData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectVersionUtilityData.name = UtilSql.getValue(result, "name");
        objectVersionUtilityData.version = UtilSql.getValue(result, "version");
        objectVersionUtilityData.type = UtilSql.getValue(result, "type");
        objectVersionUtilityData.installed = UtilSql.getValue(result, "installed");
        objectVersionUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectVersionUtilityData);
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
    VersionUtilityData objectVersionUtilityData[] = new VersionUtilityData[vector.size()];
    vector.copyInto(objectVersionUtilityData);
    return(objectVersionUtilityData);
  }

  public static VersionUtilityData[] readDependencies(ConnectionProvider connectionProvider, String ad_module_id, String included)    throws ServletException {
    return readDependencies(connectionProvider, ad_module_id, included, 0, 0);
  }

  public static VersionUtilityData[] readDependencies(ConnectionProvider connectionProvider, String ad_module_id, String included, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_module_dependency_id," +
      "          ad_dependent_module_id," +
      "          dependant_module_name," +
      "          startVersion, endVersion, " +
      "          dependency_enforcement, user_editable_enforcement, instance_enforcement" +
      "        from ad_module_dependency" +
      "        where ad_module_id = ?" +
      "        and isIncluded = ?";

    ResultSet result;
    Vector<VersionUtilityData> vector = new Vector<VersionUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_module_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, included);

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
        VersionUtilityData objectVersionUtilityData = new VersionUtilityData();
        objectVersionUtilityData.adModuleDependencyId = UtilSql.getValue(result, "ad_module_dependency_id");
        objectVersionUtilityData.adDependentModuleId = UtilSql.getValue(result, "ad_dependent_module_id");
        objectVersionUtilityData.dependantModuleName = UtilSql.getValue(result, "dependant_module_name");
        objectVersionUtilityData.startversion = UtilSql.getValue(result, "startversion");
        objectVersionUtilityData.endversion = UtilSql.getValue(result, "endversion");
        objectVersionUtilityData.dependencyEnforcement = UtilSql.getValue(result, "dependency_enforcement");
        objectVersionUtilityData.userEditableEnforcement = UtilSql.getValue(result, "user_editable_enforcement");
        objectVersionUtilityData.instanceEnforcement = UtilSql.getValue(result, "instance_enforcement");
        objectVersionUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectVersionUtilityData);
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
    VersionUtilityData objectVersionUtilityData[] = new VersionUtilityData[vector.size()];
    vector.copyInto(objectVersionUtilityData);
    return(objectVersionUtilityData);
  }

  public static VersionUtilityData[] readDependenciesToInstall(ConnectionProvider connectionProvider, String ad_module_id, String included)    throws ServletException {
    return readDependenciesToInstall(connectionProvider, ad_module_id, included, 0, 0);
  }

  public static VersionUtilityData[] readDependenciesToInstall(ConnectionProvider connectionProvider, String ad_module_id, String included, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_module_dependency_id," +
      "          ad_dependent_module_id," +
      "          dependant_module_name," +
      "          startVersion, endVersion, " +
      "          dependency_enforcement, user_editable_enforcement, " +
      "          (select max(instance_enforcement) " +
      "             from ad_module_dependency d " +
      "            where d.ad_dependent_module_id = i.ad_dependent_module_id " +
      "              and d.ad_module_id=i.ad_module_id) as instance_enforcement" +
      "        from ad_module_dependency_inst i " +
      "       where ad_module_id = ?" +
      "         and isIncluded = ?";

    ResultSet result;
    Vector<VersionUtilityData> vector = new Vector<VersionUtilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_module_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, included);

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
        VersionUtilityData objectVersionUtilityData = new VersionUtilityData();
        objectVersionUtilityData.adModuleDependencyId = UtilSql.getValue(result, "ad_module_dependency_id");
        objectVersionUtilityData.adDependentModuleId = UtilSql.getValue(result, "ad_dependent_module_id");
        objectVersionUtilityData.dependantModuleName = UtilSql.getValue(result, "dependant_module_name");
        objectVersionUtilityData.startversion = UtilSql.getValue(result, "startversion");
        objectVersionUtilityData.endversion = UtilSql.getValue(result, "endversion");
        objectVersionUtilityData.dependencyEnforcement = UtilSql.getValue(result, "dependency_enforcement");
        objectVersionUtilityData.userEditableEnforcement = UtilSql.getValue(result, "user_editable_enforcement");
        objectVersionUtilityData.instanceEnforcement = UtilSql.getValue(result, "instance_enforcement");
        objectVersionUtilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectVersionUtilityData);
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
    VersionUtilityData objectVersionUtilityData[] = new VersionUtilityData[vector.size()];
    vector.copyInto(objectVersionUtilityData);
    return(objectVersionUtilityData);
  }
}
