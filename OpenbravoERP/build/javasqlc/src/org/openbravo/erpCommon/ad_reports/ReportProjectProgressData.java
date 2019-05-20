//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportProjectProgressData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProjectProgressData.class);
  private String InitRecordNumber="0";
  public String projectid;
  public String projectname;
  public String projectdescription;
  public String projectcomments;
  public String projectstatus;
  public String customername;
  public String personincharge;
  public String startingdate;
  public String contractdate;
  public String endingdate;
  public String dayselapsed;
  public String projectcontractduration;
  public String daysdelayed;
  public String timeburned;
  public String completionperc;
  public String cumdaysdelayed;
  public String phaseid;
  public String phasename;
  public String phasestartingdate;
  public String phasecontractdate;
  public String phasecontractduration;
  public String phasecomplete;
  public String phasecomp;
  public String phaseendingdate;
  public String phasedaysdelayed;
  public String taskid;
  public String taskname;
  public String taskstartingdate;
  public String taskcontractdate;
  public String taskcontractduration;
  public String taskcomplete;
  public String taskcomp;
  public String taskendingdate;
  public String taskdaysdelayed;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("projectid"))
      return projectid;
    else if (fieldName.equalsIgnoreCase("projectname"))
      return projectname;
    else if (fieldName.equalsIgnoreCase("projectdescription"))
      return projectdescription;
    else if (fieldName.equalsIgnoreCase("projectcomments"))
      return projectcomments;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("customername"))
      return customername;
    else if (fieldName.equalsIgnoreCase("personincharge"))
      return personincharge;
    else if (fieldName.equalsIgnoreCase("startingdate"))
      return startingdate;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("endingdate"))
      return endingdate;
    else if (fieldName.equalsIgnoreCase("dayselapsed"))
      return dayselapsed;
    else if (fieldName.equalsIgnoreCase("projectcontractduration"))
      return projectcontractduration;
    else if (fieldName.equalsIgnoreCase("daysdelayed"))
      return daysdelayed;
    else if (fieldName.equalsIgnoreCase("timeburned"))
      return timeburned;
    else if (fieldName.equalsIgnoreCase("completionperc"))
      return completionperc;
    else if (fieldName.equalsIgnoreCase("cumdaysdelayed"))
      return cumdaysdelayed;
    else if (fieldName.equalsIgnoreCase("phaseid"))
      return phaseid;
    else if (fieldName.equalsIgnoreCase("phasename"))
      return phasename;
    else if (fieldName.equalsIgnoreCase("phasestartingdate"))
      return phasestartingdate;
    else if (fieldName.equalsIgnoreCase("phasecontractdate"))
      return phasecontractdate;
    else if (fieldName.equalsIgnoreCase("phasecontractduration"))
      return phasecontractduration;
    else if (fieldName.equalsIgnoreCase("phasecomplete"))
      return phasecomplete;
    else if (fieldName.equalsIgnoreCase("phasecomp"))
      return phasecomp;
    else if (fieldName.equalsIgnoreCase("phaseendingdate"))
      return phaseendingdate;
    else if (fieldName.equalsIgnoreCase("phasedaysdelayed"))
      return phasedaysdelayed;
    else if (fieldName.equalsIgnoreCase("taskid"))
      return taskid;
    else if (fieldName.equalsIgnoreCase("taskname"))
      return taskname;
    else if (fieldName.equalsIgnoreCase("taskstartingdate"))
      return taskstartingdate;
    else if (fieldName.equalsIgnoreCase("taskcontractdate"))
      return taskcontractdate;
    else if (fieldName.equalsIgnoreCase("taskcontractduration"))
      return taskcontractduration;
    else if (fieldName.equalsIgnoreCase("taskcomplete"))
      return taskcomplete;
    else if (fieldName.equalsIgnoreCase("taskcomp"))
      return taskcomp;
    else if (fieldName.equalsIgnoreCase("taskendingdate"))
      return taskendingdate;
    else if (fieldName.equalsIgnoreCase("taskdaysdelayed"))
      return taskdaysdelayed;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProjectProgressData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String dateStartFrom, String dateStartTo, String dateContractFrom, String dateContractTo, String dateEndingFrom, String dateEndingTo, String cProjectId, String cProjectStatus, String cBPartnerId, String projectResponsible, String olderFirst)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserClient, adUserOrg, dateStartFrom, dateStartTo, dateContractFrom, dateContractTo, dateEndingFrom, dateEndingTo, cProjectId, cProjectStatus, cBPartnerId, projectResponsible, olderFirst, 0, 0);
  }

  public static ReportProjectProgressData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String dateStartFrom, String dateStartTo, String dateContractFrom, String dateContractTo, String dateEndingFrom, String dateEndingTo, String cProjectId, String cProjectStatus, String cBPartnerId, String projectResponsible, String olderFirst, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT" +
      "		PR.C_PROJECT_ID AS PROJECTID, PR.NAME AS PROJECTNAME, PR.DESCRIPTION AS PROJECTDESCRIPTION, PR.NOTE AS PROJECTCOMMENTS," +
      "		REFLISTV.NAME AS PROJECTSTATUS, BPCUSTOMER.NAME AS CUSTOMERNAME, BPRESPONSIBLE.NAME AS PERSONINCHARGE," +
      "		PR.STARTDATE AS STARTINGDATE, PR.DATECONTRACT AS CONTRACTDATE, PR.DATEFINISH AS ENDINGDATE," +
      "		'' AS  DAYSELAPSED, '' AS PROJECTCONTRACTDURATION, '' AS DAYSDELAYED," +
      "		'' AS TIMEBURNED, ''AS COMPLETIONPERC, '' AS CUMDAYSDELAYED," +
      "		PRP.C_PROJECTPHASE_ID AS PHASEID, PRP.NAME AS PHASENAME, PRP.STARTDATE AS PHASESTARTINGDATE, PRP.DATECONTRACT AS PHASECONTRACTDATE, '' AS PHASECONTRACTDURATION, " +
      "		AD_MESSAGE_GET2(PRP.ISCOMPLETE,?) AS PHASECOMPLETE, PRP.ISCOMPLETE AS PHASECOMP, PRP.ENDDATE AS PHASEENDINGDATE, '' AS PHASEDAYSDELAYED," +
      "		PRT.C_PROJECTTASK_ID AS TASKID, PRT.NAME AS TASKNAME, PRT.STARTDATE AS TASKSTARTINGDATE, PRT.DATECONTRACT AS TASKCONTRACTDATE, '' AS TASKCONTRACTDURATION," +
      "		AD_MESSAGE_GET2(PRT.ISCOMPLETE,?) AS TASKCOMPLETE, PRT.ISCOMPLETE AS TASKCOMP, PRT.ENDDATE AS TASKENDINGDATE, '' AS TASKDAYSDELAYED" +
      "	  FROM AD_REF_LIST_V REFLISTV, C_BPARTNER BPCUSTOMER, C_PROJECT PR" +
      "		LEFT JOIN C_BPARTNER BPRESPONSIBLE ON PR.RESPONSIBLE_ID = BPRESPONSIBLE.C_BPARTNER_ID" +
      "	  	LEFT JOIN C_PROJECTPHASE PRP ON PR.C_PROJECT_ID = PRP.C_PROJECT_ID" +
      "	  	LEFT JOIN C_PROJECTTASK PRT ON PRP.C_PROJECTPHASE_ID = PRT.C_PROJECTPHASE_ID" +
      "	  WHERE PR.C_BPARTNER_ID = BPCUSTOMER.C_BPARTNER_ID" +
      "	  	AND REFLISTV.AD_REFERENCE_ID = '800002'" +
      "	    AND REFLISTV.AD_LANGUAGE = ?" +
      "	    AND REFLISTV.VALUE = PR.PROJECTSTATUS" +
      "	    AND PR.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "	    AND PR.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "	    AND 1=1";
    strSql = strSql + ((dateStartFrom==null || dateStartFrom.equals(""))?"":"  AND PR.STARTDATE >= TO_DATE(?) ");
    strSql = strSql + ((dateStartTo==null || dateStartTo.equals(""))?"":"  AND PR.STARTDATE < TO_DATE(?) ");
    strSql = strSql + ((dateContractFrom==null || dateContractFrom.equals(""))?"":"  AND PR.DATECONTRACT >= TO_DATE(?) ");
    strSql = strSql + ((dateContractTo==null || dateContractTo.equals(""))?"":"  AND PR.DATECONTRACT < TO_DATE(?) ");
    strSql = strSql + ((dateEndingFrom==null || dateEndingFrom.equals(""))?"":"  AND PR.DATEFINISH >= TO_DATE(?) ");
    strSql = strSql + ((dateEndingTo==null || dateEndingTo.equals(""))?"":"  AND PR.DATEFINISH < TO_DATE(?) ");
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND PR.C_PROJECT_ID = ? ");
    strSql = strSql + ((cProjectStatus==null || cProjectStatus.equals(""))?"":"  AND PR.PROJECTSTATUS IN" + cProjectStatus);
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND PR.C_BPARTNER_ID = ? ");
    strSql = strSql + ((projectResponsible==null || projectResponsible.equals(""))?"":"  AND PR.RESPONSIBLE_ID = ? ");
    strSql = strSql + 
      "      ORDER BY PR.NAME";
    strSql = strSql + ((olderFirst==null || olderFirst.equals(""))?"":olderFirst);

    ResultSet result;
    Vector<ReportProjectProgressData> vector = new Vector<ReportProjectProgressData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (dateStartFrom != null && !(dateStartFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateStartFrom);
      }
      if (dateStartTo != null && !(dateStartTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateStartTo);
      }
      if (dateContractFrom != null && !(dateContractFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateContractFrom);
      }
      if (dateContractTo != null && !(dateContractTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateContractTo);
      }
      if (dateEndingFrom != null && !(dateEndingFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateEndingFrom);
      }
      if (dateEndingTo != null && !(dateEndingTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateEndingTo);
      }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (cProjectStatus != null && !(cProjectStatus.equals(""))) {
        }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (projectResponsible != null && !(projectResponsible.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectResponsible);
      }
      if (olderFirst != null && !(olderFirst.equals(""))) {
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
        ReportProjectProgressData objectReportProjectProgressData = new ReportProjectProgressData();
        objectReportProjectProgressData.projectid = UtilSql.getValue(result, "projectid");
        objectReportProjectProgressData.projectname = UtilSql.getValue(result, "projectname");
        objectReportProjectProgressData.projectdescription = UtilSql.getValue(result, "projectdescription");
        objectReportProjectProgressData.projectcomments = UtilSql.getValue(result, "projectcomments");
        objectReportProjectProgressData.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectReportProjectProgressData.customername = UtilSql.getValue(result, "customername");
        objectReportProjectProgressData.personincharge = UtilSql.getValue(result, "personincharge");
        objectReportProjectProgressData.startingdate = UtilSql.getDateValue(result, "startingdate", "dd-MM-yyyy");
        objectReportProjectProgressData.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectReportProjectProgressData.endingdate = UtilSql.getDateValue(result, "endingdate", "dd-MM-yyyy");
        objectReportProjectProgressData.dayselapsed = UtilSql.getValue(result, "dayselapsed");
        objectReportProjectProgressData.projectcontractduration = UtilSql.getValue(result, "projectcontractduration");
        objectReportProjectProgressData.daysdelayed = UtilSql.getValue(result, "daysdelayed");
        objectReportProjectProgressData.timeburned = UtilSql.getValue(result, "timeburned");
        objectReportProjectProgressData.completionperc = UtilSql.getValue(result, "completionperc");
        objectReportProjectProgressData.cumdaysdelayed = UtilSql.getValue(result, "cumdaysdelayed");
        objectReportProjectProgressData.phaseid = UtilSql.getValue(result, "phaseid");
        objectReportProjectProgressData.phasename = UtilSql.getValue(result, "phasename");
        objectReportProjectProgressData.phasestartingdate = UtilSql.getDateValue(result, "phasestartingdate", "dd-MM-yyyy");
        objectReportProjectProgressData.phasecontractdate = UtilSql.getDateValue(result, "phasecontractdate", "dd-MM-yyyy");
        objectReportProjectProgressData.phasecontractduration = UtilSql.getValue(result, "phasecontractduration");
        objectReportProjectProgressData.phasecomplete = UtilSql.getValue(result, "phasecomplete");
        objectReportProjectProgressData.phasecomp = UtilSql.getValue(result, "phasecomp");
        objectReportProjectProgressData.phaseendingdate = UtilSql.getDateValue(result, "phaseendingdate", "dd-MM-yyyy");
        objectReportProjectProgressData.phasedaysdelayed = UtilSql.getValue(result, "phasedaysdelayed");
        objectReportProjectProgressData.taskid = UtilSql.getValue(result, "taskid");
        objectReportProjectProgressData.taskname = UtilSql.getValue(result, "taskname");
        objectReportProjectProgressData.taskstartingdate = UtilSql.getDateValue(result, "taskstartingdate", "dd-MM-yyyy");
        objectReportProjectProgressData.taskcontractdate = UtilSql.getDateValue(result, "taskcontractdate", "dd-MM-yyyy");
        objectReportProjectProgressData.taskcontractduration = UtilSql.getValue(result, "taskcontractduration");
        objectReportProjectProgressData.taskcomplete = UtilSql.getValue(result, "taskcomplete");
        objectReportProjectProgressData.taskcomp = UtilSql.getValue(result, "taskcomp");
        objectReportProjectProgressData.taskendingdate = UtilSql.getDateValue(result, "taskendingdate", "dd-MM-yyyy");
        objectReportProjectProgressData.taskdaysdelayed = UtilSql.getValue(result, "taskdaysdelayed");
        objectReportProjectProgressData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProjectProgressData);
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
    ReportProjectProgressData objectReportProjectProgressData[] = new ReportProjectProgressData[vector.size()];
    vector.copyInto(objectReportProjectProgressData);
    return(objectReportProjectProgressData);
  }

  public static ReportProjectProgressData[] set()    throws ServletException {
    ReportProjectProgressData objectReportProjectProgressData[] = new ReportProjectProgressData[1];
    objectReportProjectProgressData[0] = new ReportProjectProgressData();
    objectReportProjectProgressData[0].projectid = "";
    objectReportProjectProgressData[0].projectname = "";
    objectReportProjectProgressData[0].projectdescription = "";
    objectReportProjectProgressData[0].projectcomments = "";
    objectReportProjectProgressData[0].projectstatus = "";
    objectReportProjectProgressData[0].customername = "";
    objectReportProjectProgressData[0].personincharge = "";
    objectReportProjectProgressData[0].startingdate = "";
    objectReportProjectProgressData[0].contractdate = "";
    objectReportProjectProgressData[0].endingdate = "";
    objectReportProjectProgressData[0].dayselapsed = "";
    objectReportProjectProgressData[0].projectcontractduration = "";
    objectReportProjectProgressData[0].daysdelayed = "";
    objectReportProjectProgressData[0].timeburned = "";
    objectReportProjectProgressData[0].completionperc = "";
    objectReportProjectProgressData[0].cumdaysdelayed = "";
    objectReportProjectProgressData[0].phaseid = "";
    objectReportProjectProgressData[0].phasename = "";
    objectReportProjectProgressData[0].phasestartingdate = "";
    objectReportProjectProgressData[0].phasecontractdate = "";
    objectReportProjectProgressData[0].phasecontractduration = "";
    objectReportProjectProgressData[0].phasecomplete = "";
    objectReportProjectProgressData[0].phasecomp = "";
    objectReportProjectProgressData[0].phaseendingdate = "";
    objectReportProjectProgressData[0].phasedaysdelayed = "";
    objectReportProjectProgressData[0].taskid = "";
    objectReportProjectProgressData[0].taskname = "";
    objectReportProjectProgressData[0].taskstartingdate = "";
    objectReportProjectProgressData[0].taskcontractdate = "";
    objectReportProjectProgressData[0].taskcontractduration = "";
    objectReportProjectProgressData[0].taskcomplete = "";
    objectReportProjectProgressData[0].taskcomp = "";
    objectReportProjectProgressData[0].taskendingdate = "";
    objectReportProjectProgressData[0].taskdaysdelayed = "";
    return objectReportProjectProgressData;
  }
}
