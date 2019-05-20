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

class RptMAProcessPlanData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptMAProcessPlanData.class);
  private String InitRecordNumber="0";
  public String processplan;
  public String ratio;
  public String secud;
  public String desde;
  public String hasta;
  public String secuencia;
  public String sec;
  public String description;
  public String proceso;
  public String seqno;
  public String groupuse;
  public String vacio;
  public String producto;
  public String tipo;
  public String bold;
  public String quantity;
  public String ud;
  public String componentcost;
  public String decrease;
  public String rejected;
  public String maProcessplanId;
  public String maSequenceId;
  public String explodephases;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("processplan"))
      return processplan;
    else if (fieldName.equalsIgnoreCase("ratio"))
      return ratio;
    else if (fieldName.equalsIgnoreCase("secud"))
      return secud;
    else if (fieldName.equalsIgnoreCase("desde"))
      return desde;
    else if (fieldName.equalsIgnoreCase("hasta"))
      return hasta;
    else if (fieldName.equalsIgnoreCase("secuencia"))
      return secuencia;
    else if (fieldName.equalsIgnoreCase("sec"))
      return sec;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("proceso"))
      return proceso;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("groupuse"))
      return groupuse;
    else if (fieldName.equalsIgnoreCase("vacio"))
      return vacio;
    else if (fieldName.equalsIgnoreCase("producto"))
      return producto;
    else if (fieldName.equalsIgnoreCase("tipo"))
      return tipo;
    else if (fieldName.equalsIgnoreCase("bold"))
      return bold;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("ud"))
      return ud;
    else if (fieldName.equalsIgnoreCase("componentcost"))
      return componentcost;
    else if (fieldName.equalsIgnoreCase("decrease"))
      return decrease;
    else if (fieldName.equalsIgnoreCase("rejected"))
      return rejected;
    else if (fieldName.equalsIgnoreCase("ma_processplan_id") || fieldName.equals("maProcessplanId"))
      return maProcessplanId;
    else if (fieldName.equalsIgnoreCase("ma_sequence_id") || fieldName.equals("maSequenceId"))
      return maSequenceId;
    else if (fieldName.equalsIgnoreCase("explodephases"))
      return explodephases;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptMAProcessPlanData[] select(ConnectionProvider connectionProvider, String language, String maProcessPlanId)    throws ServletException {
    return select(connectionProvider, language, maProcessPlanId, 0, 0);
  }

  public static RptMAProcessPlanData[] select(ConnectionProvider connectionProvider, String language, String maProcessPlanId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT pp.NAME as processplan, pp.CONVERSIONRATE as ratio, pp.SECONDARYUNIT as secud, v.DATEFROM as desde, " +
      "              v.DATETO as hasta, s.NAME as secuencia, s.VALUE as sec, s.DESCRIPTION, pr.NAME as proceso," +
      "              s.SEQNO, AD_MESSAGE_GET2(s.GROUPUSE, to_char(?)) as groupuse, AD_MESSAGE_GET2(s.NOQTY, to_char(?)) as vacio," +
      "              p.name as producto, sp.PRODUCTIONTYPE as tipo, AD_MESSAGE_GET2(sp.PRODUCTIONTYPE, to_char(?)) as bold," +
      "              sp.QUANTITY, c.UOMSYMBOL as ud, sp.COMPONENTCOST, sp.DECREASE, sp.REJECTED," +
      "              pp.MA_ProcessPlan_ID, s.MA_Sequence_ID, AD_MESSAGE_GET2(pp.EXPLODEPHASES, to_char(?)) as explodephases" +
      "          FROM MA_Processplan pp, MA_processplan_version v, ma_sequence s, ma_sequenceproduct sp, " +
      "              m_product p, ma_process pr, C_UOM c" +
      "          where pp.MA_PROCESSPLAN_ID = v.MA_PROCESSPLAN_ID" +
      "            and v.MA_PROCESSPLAN_VERSION_ID = s.MA_PROCESSPLAN_VERSION_ID" +
      "            and s.MA_SEQUENCE_ID = sp.MA_SEQUENCE_ID" +
      "            and sp.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "            and sp.C_UOM_ID = c.C_UOM_ID" +
      "            and s.MA_PROCESS_ID = pr.MA_PROCESS_ID" +
      "            and v.DATEFROM <= now()" +
      "            and v.DATETO > now()" +
      "            and 1=1";
    strSql = strSql + ((maProcessPlanId==null || maProcessPlanId.equals(""))?"":"           and pp.ma_processplan_id IN        " + maProcessPlanId);
    strSql = strSql + 
      "          order by pp.ma_processplan_id, pp.NAME, s.seqno, sp.productiontype, p.name";

    ResultSet result;
    Vector<RptMAProcessPlanData> vector = new Vector<RptMAProcessPlanData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (maProcessPlanId != null && !(maProcessPlanId.equals(""))) {
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
        RptMAProcessPlanData objectRptMAProcessPlanData = new RptMAProcessPlanData();
        objectRptMAProcessPlanData.processplan = UtilSql.getValue(result, "processplan");
        objectRptMAProcessPlanData.ratio = UtilSql.getValue(result, "ratio");
        objectRptMAProcessPlanData.secud = UtilSql.getValue(result, "secud");
        objectRptMAProcessPlanData.desde = UtilSql.getDateValue(result, "desde", "dd-MM-yyyy");
        objectRptMAProcessPlanData.hasta = UtilSql.getDateValue(result, "hasta", "dd-MM-yyyy");
        objectRptMAProcessPlanData.secuencia = UtilSql.getValue(result, "secuencia");
        objectRptMAProcessPlanData.sec = UtilSql.getValue(result, "sec");
        objectRptMAProcessPlanData.description = UtilSql.getValue(result, "description");
        objectRptMAProcessPlanData.proceso = UtilSql.getValue(result, "proceso");
        objectRptMAProcessPlanData.seqno = UtilSql.getValue(result, "seqno");
        objectRptMAProcessPlanData.groupuse = UtilSql.getValue(result, "groupuse");
        objectRptMAProcessPlanData.vacio = UtilSql.getValue(result, "vacio");
        objectRptMAProcessPlanData.producto = UtilSql.getValue(result, "producto");
        objectRptMAProcessPlanData.tipo = UtilSql.getValue(result, "tipo");
        objectRptMAProcessPlanData.bold = UtilSql.getValue(result, "bold");
        objectRptMAProcessPlanData.quantity = UtilSql.getValue(result, "quantity");
        objectRptMAProcessPlanData.ud = UtilSql.getValue(result, "ud");
        objectRptMAProcessPlanData.componentcost = UtilSql.getValue(result, "componentcost");
        objectRptMAProcessPlanData.decrease = UtilSql.getValue(result, "decrease");
        objectRptMAProcessPlanData.rejected = UtilSql.getValue(result, "rejected");
        objectRptMAProcessPlanData.maProcessplanId = UtilSql.getValue(result, "ma_processplan_id");
        objectRptMAProcessPlanData.maSequenceId = UtilSql.getValue(result, "ma_sequence_id");
        objectRptMAProcessPlanData.explodephases = UtilSql.getValue(result, "explodephases");
        objectRptMAProcessPlanData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptMAProcessPlanData);
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
    RptMAProcessPlanData objectRptMAProcessPlanData[] = new RptMAProcessPlanData[vector.size()];
    vector.copyInto(objectRptMAProcessPlanData);
    return(objectRptMAProcessPlanData);
  }

  public static RptMAProcessPlanData[] set()    throws ServletException {
    RptMAProcessPlanData objectRptMAProcessPlanData[] = new RptMAProcessPlanData[1];
    objectRptMAProcessPlanData[0] = new RptMAProcessPlanData();
    objectRptMAProcessPlanData[0].processplan = "";
    objectRptMAProcessPlanData[0].ratio = "";
    objectRptMAProcessPlanData[0].secud = "";
    objectRptMAProcessPlanData[0].desde = "";
    objectRptMAProcessPlanData[0].hasta = "";
    objectRptMAProcessPlanData[0].secuencia = "";
    objectRptMAProcessPlanData[0].sec = "";
    objectRptMAProcessPlanData[0].description = "";
    objectRptMAProcessPlanData[0].proceso = "";
    objectRptMAProcessPlanData[0].seqno = "";
    objectRptMAProcessPlanData[0].groupuse = "";
    objectRptMAProcessPlanData[0].vacio = "";
    objectRptMAProcessPlanData[0].producto = "";
    objectRptMAProcessPlanData[0].tipo = "";
    objectRptMAProcessPlanData[0].bold = "";
    objectRptMAProcessPlanData[0].quantity = "";
    objectRptMAProcessPlanData[0].ud = "";
    objectRptMAProcessPlanData[0].componentcost = "";
    objectRptMAProcessPlanData[0].decrease = "";
    objectRptMAProcessPlanData[0].rejected = "";
    objectRptMAProcessPlanData[0].maProcessplanId = "";
    objectRptMAProcessPlanData[0].maSequenceId = "";
    objectRptMAProcessPlanData[0].explodephases = "";
    return objectRptMAProcessPlanData;
  }
}
