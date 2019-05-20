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

class ReportProductionCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProductionCostData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String realunitcost;
  public String standarunitcost;
  public String identifier;
  public String levelid;
  public String buttonClass;
  public String consumedperunit;
  public String costperunit;
  public String consumedperunitstd;
  public String costperunitstd;
  public String levelBlanck;
  public String levelName;
  public String className;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("realunitcost"))
      return realunitcost;
    else if (fieldName.equalsIgnoreCase("standarunitcost"))
      return standarunitcost;
    else if (fieldName.equalsIgnoreCase("identifier"))
      return identifier;
    else if (fieldName.equalsIgnoreCase("levelid"))
      return levelid;
    else if (fieldName.equalsIgnoreCase("button_class") || fieldName.equals("buttonClass"))
      return buttonClass;
    else if (fieldName.equalsIgnoreCase("consumedperunit"))
      return consumedperunit;
    else if (fieldName.equalsIgnoreCase("costperunit"))
      return costperunit;
    else if (fieldName.equalsIgnoreCase("consumedperunitstd"))
      return consumedperunitstd;
    else if (fieldName.equalsIgnoreCase("costperunitstd"))
      return costperunitstd;
    else if (fieldName.equalsIgnoreCase("level_blanck") || fieldName.equals("levelBlanck"))
      return levelBlanck;
    else if (fieldName.equalsIgnoreCase("level_name") || fieldName.equals("levelName"))
      return levelName;
    else if (fieldName.equalsIgnoreCase("class_name") || fieldName.equals("className"))
      return className;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProductionCostData[] select(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId, String adClientId)    throws ServletException {
    return select(connectionProvider, cCurrencyBase, cCurrencyConv, level, dateFrom, dateTo, mProductId, adClientId, 0, 0);
  }

  public static ReportProductionCostData[] select(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT rp.M_Product_ID AS ID, M_Product.Name, SUM(rp.RealTotalCost)/SUM(rp.ProducedQty) AS RealUnitCost, " +
      "      SUM(rp.ProducedQty*C_CURRENCY_CONVERT(sp.Cost, ?, ?, TO_DATE(sp.Updated), null, sp.ad_client_id, sp.ad_org_id))/SUM(rp.ProducedQty) AS StandarUnitCost, " +
      "      rp.M_Product_ID as identifier, ? as levelid, 'datawarehouseclose' as button_class, '' AS ConsumedPerUnit, '' AS CostPerUnit, '' AS ConsumedPerUnitStd, '' AS CostPerUnitStd, to_number(?)*5 as level_blanck, 40-(to_number(?)*5) as level_name, '' as class_name" +
      "      FROM" +
      "          (SELECT pl.M_Product_ID, wrp.MA_Sequence_ID, " +
      "          SUM(pl.MovementQty*C_CURRENCY_CONVERT(pl.CalcCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id)) AS RealTotalCost, " +
      "          SUM(pl.MovementQty) AS " +
      "          ProducedQty" +
      "          FROM M_Production p INNER JOIN M_ProductionPlan pp ON (p.M_Production_ID = pp.M_Production_ID)" +
      "                              INNER JOIN M_ProductionLine pl ON (pp.M_ProductionPlan_ID = pl.M_ProductionPlan_ID)" +
      "                              INNER JOIN MA_WRPhase wrp ON (pp.MA_WRPhase_ID = wrp.MA_WRPhase_ID)" +
      "          WHERE p.IsSOTrx = 'N'" +
      "          AND p.Processed = 'Y'" +
      "          AND pl.ProductionType = '+'" +
      "          AND p.MovementDate >= TO_DATE(?)" +
      "          AND p.MovementDate < TO_DATE(?)" +
      "          AND 1=1";
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND pl.M_PRODUCT_ID = ? ");
    strSql = strSql + 
      "          GROUP BY pl.M_Product_ID, wrp.MA_Sequence_ID) rp" +
      "          LEFT OUTER JOIN MA_SequenceProduct sp ON (rp.M_Product_ID = sp.M_Product_ID AND rp.MA_Sequence_ID = sp.MA_Sequence_ID), M_Product" +
      "        WHERE rp.M_Product_ID = M_Product.M_Product_ID" +
      "        AND M_Product.IsSold = 'Y'" +
      "        AND M_PRODUCT.ad_client_id = ?" +
      "        GROUP BY rp.M_Product_ID, M_Product.Name";

    ResultSet result;
    Vector<ReportProductionCostData> vector = new Vector<ReportProductionCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (mProductId != null && !(mProductId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        ReportProductionCostData objectReportProductionCostData = new ReportProductionCostData();
        objectReportProductionCostData.id = UtilSql.getValue(result, "id");
        objectReportProductionCostData.name = UtilSql.getValue(result, "name");
        objectReportProductionCostData.realunitcost = UtilSql.getValue(result, "realunitcost");
        objectReportProductionCostData.standarunitcost = UtilSql.getValue(result, "standarunitcost");
        objectReportProductionCostData.identifier = UtilSql.getValue(result, "identifier");
        objectReportProductionCostData.levelid = UtilSql.getValue(result, "levelid");
        objectReportProductionCostData.buttonClass = UtilSql.getValue(result, "button_class");
        objectReportProductionCostData.consumedperunit = UtilSql.getValue(result, "consumedperunit");
        objectReportProductionCostData.costperunit = UtilSql.getValue(result, "costperunit");
        objectReportProductionCostData.consumedperunitstd = UtilSql.getValue(result, "consumedperunitstd");
        objectReportProductionCostData.costperunitstd = UtilSql.getValue(result, "costperunitstd");
        objectReportProductionCostData.levelBlanck = UtilSql.getValue(result, "level_blanck");
        objectReportProductionCostData.levelName = UtilSql.getValue(result, "level_name");
        objectReportProductionCostData.className = UtilSql.getValue(result, "class_name");
        objectReportProductionCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionCostData);
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
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[vector.size()];
    vector.copyInto(objectReportProductionCostData);
    return(objectReportProductionCostData);
  }

  public static ReportProductionCostData[] set()    throws ServletException {
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[1];
    objectReportProductionCostData[0] = new ReportProductionCostData();
    objectReportProductionCostData[0].id = "";
    objectReportProductionCostData[0].name = "";
    objectReportProductionCostData[0].realunitcost = "";
    objectReportProductionCostData[0].standarunitcost = "";
    objectReportProductionCostData[0].identifier = "";
    objectReportProductionCostData[0].levelid = "";
    objectReportProductionCostData[0].buttonClass = "";
    objectReportProductionCostData[0].consumedperunit = "";
    objectReportProductionCostData[0].costperunit = "";
    objectReportProductionCostData[0].consumedperunitstd = "";
    objectReportProductionCostData[0].costperunitstd = "";
    objectReportProductionCostData[0].levelBlanck = "";
    objectReportProductionCostData[0].levelName = "";
    objectReportProductionCostData[0].className = "";
    return objectReportProductionCostData;
  }

  public static ReportProductionCostData[] selectMaterial(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String id, String level, String dateFrom, String dateTo, String mProductId)    throws ServletException {
    return selectMaterial(connectionProvider, cCurrencyBase, cCurrencyConv, id, level, dateFrom, dateTo, mProductId, 0, 0);
  }

  public static ReportProductionCostData[] selectMaterial(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String id, String level, String dateFrom, String dateTo, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT pr.ID, pr.Name, pr.ConsumedPerUnit, pr.CostPerUnit, pr.ConsumedPerUnitStd, pr.CostPerUnitStd, pr.ConsumedPerUnit*pr.CostPerUnit as RealUnitCost, pr.ConsumedPerUnitStd*pr.CostPerUnitStd as StandarUnitCost, pr.identifier, pr.level_blanck, pr.level_name, pr.button_class, pr.levelid, AD_Ref_List.name as class_name" +
      "       FROM (" +
      "       SELECT auxSeq.M_Product_ID AS ID, M_Product.Name, " +
      "        SUM(auxSeq.ComponentCost*auxSeq.ConsumedQty)/SUM(auxSeq.ProducedQty) AS ConsumedPerUnit, " +
      "        SUM(auxSeq.TotalRealCost)/SUM(auxSeq.ConsumedQty) AS CostPerUnit," +
      "        SUM(auxSeq.ComponentCost*sp.Quantity)/SUM(auxSeq.ProducedStdQuantity) * SUM(Coalesce(sp.decrease,1)) * SUM(coalesce(sp.rejected,1)) AS ConsumedPerUnitStd, " +
      "        MAX(C_CURRENCY_CONVERT(sp.Cost, ?, ?, TO_DATE(sp.Updated), null, sp.ad_client_id, sp.ad_org_id)) AS CostPerUnitStd, " +
      "            to_char(?)||to_char(auxSeq.M_Product_ID) as identifier, to_char((to_number(?)+1)*5) as level_blanck, to_char(40-((to_number(?)+1)*5)) as level_name, case when M_Product.MA_ProcessPlan_ID is null then '' else 'datawarehouseclose' end as button_class, to_char(to_number(?)+1) as levelid" +
      "        FROM " +
      "          (SELECT rpn.M_Product_ID, rpp.ComponentCost, SUM(rpn.ConsumedQty) AS ConsumedQty, " +
      "           SUM(rpp.ProducedQty) AS ProducedQty, SUM(rpn.ConsumedQty*rpn.CalcCost) AS TotalRealCost, rpp.MA_Sequence_ID, rpp.ProducedStdQuantity" +
      "           FROM" +
      "              (SELECT SUM(pl.MovementQty) AS ProducedQty, " +
      "              MAX(C_CURRENCY_CONVERT(pl.ComponentCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id)) AS ComponentCost, " +
      "              pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID,sum(sp.quantity) as ProducedStdQuantity" +
      "              FROM M_Production p" +
      "                INNER JOIN M_ProductionPlan pp ON (p.M_Production_ID = pp.M_Production_ID)" +
      "                INNER JOIN M_ProductionLine pl ON (pp.M_ProductionPlan_ID = pl.M_ProductionPlan_ID)" +
      "                INNER JOIN MA_WRPhase wrp ON (pp.MA_WRPhase_ID = wrp.MA_WRPhase_ID)" +
      "                LEFT OUTER JOIN MA_SequenceProduct sp " +
      "                ON (pl.M_Product_ID = sp.M_Product_ID AND wrp.MA_Sequence_ID = sp.MA_Sequence_ID)" +
      "              WHERE p.IsSOTrx = 'N'" +
      "              AND pl.ProductionType = '+'" +
      "              AND p.Processed = 'Y'" +
      "              AND p.MovementDate >= TO_DATE(?)" +
      "              AND p.MovementDate < TO_DATE(?)" +
      "              AND pl.M_Product_ID = ?" +
      "              GROUP BY pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              HAVING SUM(pl.MovementQty) <> 0) rpp " +
      "           LEFT OUTER JOIN" +
      "              (SELECT pl.M_Product_ID, SUM(pl.MovementQty) AS ConsumedQty, " +
      "              SUM(C_CURRENCY_CONVERT(pl.CalcCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id))/SUM(pl.MovementQty) AS CalcCost, " +
      "              pl.M_ProductionPlan_ID" +
      "              FROM M_ProductionLine pl, M_ProductionPlan pp, M_Production p" +
      "              WHERE pl.ProductionType = '-'" +
      "              AND pl.M_ProductionPlan_ID = pp.M_ProductionPlan_ID  " +
      "			  AND p.M_Production_ID = pp.M_Production_ID" +
      "              GROUP BY pl.M_Product_ID, pl.M_ProductionPlan_ID" +
      "              HAVING SUM(pl.MovementQty) <> 0) rpn " +
      "           ON (rpp.M_ProductionPlan_ID = rpn.M_ProductionPlan_ID) " +
      "           GROUP BY rpn.M_Product_ID, rpp.ComponentCost, rpp.MA_Sequence_ID, rpp.ProducedStdQuantity) auxSeq" +
      "        LEFT OUTER JOIN MA_SequenceProduct sp " +
      "        ON (auxSeq.M_Product_ID = sp.M_Product_ID AND auxSeq.MA_Sequence_ID = sp.MA_Sequence_ID), M_Product" +
      "        WHERE auxSeq.M_Product_ID = M_Product.M_Product_ID" +
      "        GROUP BY auxSeq.M_Product_ID, M_Product.Name, M_Product.MA_ProcessPlan_ID) pr, AD_Ref_List" +
      "        WHERE pr.levelid = AD_Ref_List.value" +
      "        AND Ad_Ref_List.AD_Reference_ID = '800097'";

    ResultSet result;
    Vector<ReportProductionCostData> vector = new Vector<ReportProductionCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);

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
        ReportProductionCostData objectReportProductionCostData = new ReportProductionCostData();
        objectReportProductionCostData.id = UtilSql.getValue(result, "id");
        objectReportProductionCostData.name = UtilSql.getValue(result, "name");
        objectReportProductionCostData.consumedperunit = UtilSql.getValue(result, "consumedperunit");
        objectReportProductionCostData.costperunit = UtilSql.getValue(result, "costperunit");
        objectReportProductionCostData.consumedperunitstd = UtilSql.getValue(result, "consumedperunitstd");
        objectReportProductionCostData.costperunitstd = UtilSql.getValue(result, "costperunitstd");
        objectReportProductionCostData.realunitcost = UtilSql.getValue(result, "realunitcost");
        objectReportProductionCostData.standarunitcost = UtilSql.getValue(result, "standarunitcost");
        objectReportProductionCostData.identifier = UtilSql.getValue(result, "identifier");
        objectReportProductionCostData.levelBlanck = UtilSql.getValue(result, "level_blanck");
        objectReportProductionCostData.levelName = UtilSql.getValue(result, "level_name");
        objectReportProductionCostData.buttonClass = UtilSql.getValue(result, "button_class");
        objectReportProductionCostData.levelid = UtilSql.getValue(result, "levelid");
        objectReportProductionCostData.className = UtilSql.getValue(result, "class_name");
        objectReportProductionCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionCostData);
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
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[vector.size()];
    vector.copyInto(objectReportProductionCostData);
    return(objectReportProductionCostData);
  }

  public static ReportProductionCostData[] selectMachine(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId)    throws ServletException {
    return selectMachine(connectionProvider, cCurrencyBase, cCurrencyConv, level, dateFrom, dateTo, mProductId, 0, 0);
  }

  public static ReportProductionCostData[] selectMachine(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT pr.ID, pr.name, pr.CostPerUnit, pr.CostPerUnitStd, pr.level_blanck, pr.level_name, AD_Ref_List.Name as class_name, pr.levelid" +
      "       FROM (" +
      "       SELECT auxSeq.MA_Machine_ID AS ID, MA_Machine.name,  " +
      "        SUM(auxSeq.TotalRealCost*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnit," +
      "        SUM(C_CURRENCY_CONVERT(sm.CalcCost, ?, ?, TO_DATE(sm.Updated), null, sm.ad_client_id, sm.ad_org_id)*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnitStd, " +
      "            to_char((to_number(?)+1)*5) as level_blanck, to_char(40-((to_number(?)+1)*5)) as level_name, to_char(to_number(?)+1) as levelid" +
      "        FROM " +
      "          (SELECT rmc.MA_Machine_ID, rpp.ComponentCost, SUM(rpp.ProducedQty) AS ProducedQty," +
      "           SUM(rmc.CalcCost) AS TotalRealCost, rpp.MA_Sequence_ID" +
      "           FROM" +
      "              (SELECT SUM(pl.MovementQty) AS ProducedQty, " +
      "              MAX(C_CURRENCY_CONVERT(pl.ComponentCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id)) AS ComponentCost, " +
      "              pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              FROM M_Production p" +
      "                INNER JOIN M_ProductionPlan pp ON (p.M_Production_ID = pp.M_Production_ID)" +
      "                INNER JOIN M_ProductionLine pl ON (pp.M_ProductionPlan_ID = pl.M_ProductionPlan_ID)" +
      "                INNER JOIN MA_WRPhase wrp ON (pp.MA_WRPhase_ID = wrp.MA_WRPhase_ID)" +
      "              WHERE p.IsSOTrx = 'N'" +
      "              AND pl.ProductionType = '+'" +
      "              AND p.Processed = 'Y'" +
      "              AND p.MovementDate >= TO_DATE(?)" +
      "              AND p.MovementDate < TO_DATE(?)" +
      "              AND pl.M_Product_ID = ?" +
      "              GROUP BY pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              HAVING SUM(pl.MovementQty) <> 0) rpp " +
      "           LEFT OUTER JOIN" +
      "              (SELECT plm.MA_Machine_ID, " +
      "              C_CURRENCY_CONVERT(plm.CalcCost, ?, ?, TO_DATE(p.movementdate), null, plm.ad_client_id, plm.ad_org_id) AS CalcCost," +
      "              plm.M_ProductionPlan_ID" +
      "              FROM MA_Pl_Machine plm, M_ProductionPlan pp, M_Production p" +
      "              WHERE plm.M_ProductionPlan_ID = pp.M_ProductionPlan_ID  " +
      "			  AND p.M_Production_ID = pp.M_Production_ID) rmc" +
      "           ON (rpp.M_ProductionPlan_ID = rmc.M_ProductionPlan_ID) " +
      "           GROUP BY rmc.MA_Machine_ID, rpp.ComponentCost, rpp.MA_Sequence_ID" +
      "           HAVING rmc.MA_Machine_ID IS NOT NULL) auxSeq" +
      "        LEFT OUTER JOIN MA_Sequence_Machine sm " +
      "        ON (auxSeq.MA_Machine_ID = sm.MA_Machine_ID AND auxSeq.MA_Sequence_ID = sm.MA_Sequence_ID), MA_Machine" +
      "        WHERE auxSeq.MA_Machine_ID = MA_Machine.MA_Machine_ID" +
      "        GROUP BY auxSeq.MA_Machine_ID, MA_Machine.name) pr, AD_Ref_List" +
      "        WHERE pr.levelid = AD_Ref_List.value" +
      "        AND AD_Ref_List.AD_Reference_ID = '800097'";

    ResultSet result;
    Vector<ReportProductionCostData> vector = new Vector<ReportProductionCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);

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
        ReportProductionCostData objectReportProductionCostData = new ReportProductionCostData();
        objectReportProductionCostData.id = UtilSql.getValue(result, "id");
        objectReportProductionCostData.name = UtilSql.getValue(result, "name");
        objectReportProductionCostData.costperunit = UtilSql.getValue(result, "costperunit");
        objectReportProductionCostData.costperunitstd = UtilSql.getValue(result, "costperunitstd");
        objectReportProductionCostData.levelBlanck = UtilSql.getValue(result, "level_blanck");
        objectReportProductionCostData.levelName = UtilSql.getValue(result, "level_name");
        objectReportProductionCostData.className = UtilSql.getValue(result, "class_name");
        objectReportProductionCostData.levelid = UtilSql.getValue(result, "levelid");
        objectReportProductionCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionCostData);
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
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[vector.size()];
    vector.copyInto(objectReportProductionCostData);
    return(objectReportProductionCostData);
  }

  public static ReportProductionCostData[] selectIndirect(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId)    throws ServletException {
    return selectIndirect(connectionProvider, cCurrencyBase, cCurrencyConv, level, dateFrom, dateTo, mProductId, 0, 0);
  }

  public static ReportProductionCostData[] selectIndirect(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT pr.ID, pr.name, pr.CostPerUnit, pr.CostPerUnitStd, pr.level_blanck, pr.level_name, AD_Ref_List.Name as class_name, pr.levelid" +
      "       FROM (" +
      "       SELECT auxSeq.MA_Indirect_Cost_ID AS ID, MA_Indirect_Cost.name,  " +
      "        SUM(auxSeq.TotalRealCost*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnit," +
      "        SUM(C_CURRENCY_CONVERT(si.CalcCost, ?, ?, TO_DATE(si.Updated), null, si.ad_client_id, si.ad_org_id)*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnitStd, " +
      "            to_char((to_number(?)+1)*5) as level_blanck, to_char(40-((to_number(?)+1)*5)) as level_name, to_char(to_number(?)+1) as levelid" +
      "        FROM " +
      "          (SELECT rmi.MA_Indirect_Cost_ID, rpp.ComponentCost, SUM(rpp.ProducedQty) AS ProducedQty," +
      "           SUM(rmi.CalcCost) AS TotalRealCost, rpp.MA_Sequence_ID" +
      "           FROM" +
      "              (SELECT SUM(pl.MovementQty) AS ProducedQty, " +
      "              MAX(C_CURRENCY_CONVERT(pl.ComponentCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id)) AS ComponentCost, " +
      "              pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              FROM M_Production p" +
      "                INNER JOIN M_ProductionPlan pp ON (p.M_Production_ID = pp.M_Production_ID)" +
      "                INNER JOIN M_ProductionLine pl ON (pp.M_ProductionPlan_ID = pl.M_ProductionPlan_ID)" +
      "                INNER JOIN MA_WRPhase wrp ON (pp.MA_WRPhase_ID = wrp.MA_WRPhase_ID)" +
      "              WHERE p.IsSOTrx = 'N'" +
      "              AND pl.ProductionType = '+'" +
      "              AND p.Processed = 'Y'" +
      "              AND p.MovementDate >= TO_DATE(?)" +
      "              AND p.MovementDate < TO_DATE(?)" +
      "              AND pl.M_Product_ID = ?" +
      "              GROUP BY pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              HAVING SUM(pl.MovementQty) <> 0) rpp " +
      "           LEFT OUTER JOIN" +
      "              (SELECT pli.MA_Indirect_Cost_ID, " +
      "                C_CURRENCY_CONVERT(pli.CalcCost, ?, ?, TO_DATE(p.movementdate), null, pli.ad_client_id, pli.ad_org_id) AS CalcCost, " +
      "                pli.M_ProductionPlan_ID" +
      "              FROM MA_Pl_Ic pli, M_ProductionPlan pp, M_Production p" +
      "              WHERE pli.M_ProductionPlan_ID = pp.M_ProductionPlan_ID  " +
      "			  AND p.M_Production_ID = pp.M_Production_ID) rmi" +
      "           ON (rpp.M_ProductionPlan_ID = rmi.M_ProductionPlan_ID) " +
      "           GROUP BY rmi.MA_Indirect_Cost_ID, rpp.ComponentCost, rpp.MA_Sequence_ID" +
      "           HAVING rmi.MA_Indirect_Cost_ID IS NOT NULL) auxSeq" +
      "        LEFT OUTER JOIN MA_Sequence_IC si" +
      "        ON (auxSeq.MA_Indirect_Cost_ID = si.MA_Indirect_Cost_ID AND auxSeq.MA_Sequence_ID = si.MA_Sequence_ID), MA_Indirect_Cost" +
      "        WHERE auxSeq.MA_Indirect_Cost_ID = MA_Indirect_Cost.MA_Indirect_Cost_ID" +
      "        GROUP BY auxSeq.MA_Indirect_Cost_ID, MA_Indirect_Cost.name) pr, AD_Ref_List" +
      "        WHERE pr.levelid = AD_Ref_List.value" +
      "        AND AD_Ref_List.AD_Reference_ID = '800097'";

    ResultSet result;
    Vector<ReportProductionCostData> vector = new Vector<ReportProductionCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);

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
        ReportProductionCostData objectReportProductionCostData = new ReportProductionCostData();
        objectReportProductionCostData.id = UtilSql.getValue(result, "id");
        objectReportProductionCostData.name = UtilSql.getValue(result, "name");
        objectReportProductionCostData.costperunit = UtilSql.getValue(result, "costperunit");
        objectReportProductionCostData.costperunitstd = UtilSql.getValue(result, "costperunitstd");
        objectReportProductionCostData.levelBlanck = UtilSql.getValue(result, "level_blanck");
        objectReportProductionCostData.levelName = UtilSql.getValue(result, "level_name");
        objectReportProductionCostData.className = UtilSql.getValue(result, "class_name");
        objectReportProductionCostData.levelid = UtilSql.getValue(result, "levelid");
        objectReportProductionCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionCostData);
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
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[vector.size()];
    vector.copyInto(objectReportProductionCostData);
    return(objectReportProductionCostData);
  }

  public static ReportProductionCostData[] selectEmployee(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId)    throws ServletException {
    return selectEmployee(connectionProvider, cCurrencyBase, cCurrencyConv, level, dateFrom, dateTo, mProductId, 0, 0);
  }

  public static ReportProductionCostData[] selectEmployee(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT pr.ID, pr.name, pr.CostPerUnit, pr.CostPerUnitStd, pr.level_blanck, pr.level_name, AD_Ref_List.Name as class_name, pr.levelid" +
      "       FROM (" +
      "       SELECT auxSeq.C_Salary_Category_ID AS ID, C_Salary_Category.name," +
      "        SUM(auxSeq.TotalRealCost*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnit," +
      "        SUM(C_CURRENCY_CONVERT(se.CalcCost, ?, ?, TO_DATE(se.Updated), null, se.ad_client_id, se.ad_org_id)*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnitStd, to_char((to_number(?)+1)*5) as level_blanck, to_char(40-((to_number(?)+1)*5)) as level_name, to_char(to_number(?)+1) as levelid" +
      "        FROM " +
      "          (SELECT rme.C_Salary_Category_ID, rpp.ComponentCost, SUM(rpp.ProducedQty) AS ProducedQty," +
      "           SUM(rme.CalcCost) AS TotalRealCost, rpp.MA_Sequence_ID" +
      "           FROM" +
      "              (SELECT SUM(pl.MovementQty) AS ProducedQty, " +
      "              MAX(C_CURRENCY_CONVERT(pl.ComponentCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id)) AS ComponentCost, " +
      "              pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              FROM M_Production p" +
      "                INNER JOIN M_ProductionPlan pp ON (p.M_Production_ID = pp.M_Production_ID)" +
      "                INNER JOIN M_ProductionLine pl ON (pp.M_ProductionPlan_ID = pl.M_ProductionPlan_ID)" +
      "                INNER JOIN MA_WRPhase wrp ON (pp.MA_WRPhase_ID = wrp.MA_WRPhase_ID)" +
      "              WHERE p.IsSOTrx = 'N'" +
      "              AND pl.ProductionType = '+'" +
      "              AND p.Processed = 'Y'" +
      "              AND p.MovementDate >= TO_DATE(?)" +
      "              AND p.MovementDate < TO_DATE(?)" +
      "              AND pl.M_Product_ID = ?" +
      "              GROUP BY pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID" +
      "              HAVING SUM(pl.MovementQty) <> 0) rpp " +
      "           LEFT OUTER JOIN" +
      "              (SELECT ple.C_Salary_Category_ID, " +
      "              C_CURRENCY_CONVERT(ple.CalcCost, ?, ?, TO_DATE(p.movementdate), null, ple.ad_client_id, ple.ad_org_id) AS CalcCost, " +
      "              ple.M_ProductionPlan_ID" +
      "              FROM MA_Pl_Employee ple, M_ProductionPlan pp, M_Production p" +
      "              WHERE ple.M_ProductionPlan_ID = pp.M_ProductionPlan_ID  " +
      "			  AND p.M_Production_ID = pp.M_Production_ID) rme" +
      "           ON (rpp.M_ProductionPlan_ID = rme.M_ProductionPlan_ID) " +
      "           GROUP BY rme.C_Salary_Category_ID, rpp.ComponentCost, rpp.MA_Sequence_ID" +
      "           HAVING rme.C_Salary_Category_ID IS NOT NULL) auxSeq" +
      "        LEFT OUTER JOIN MA_Sequence_Employee se" +
      "        ON (auxSeq.C_Salary_Category_ID = se.C_Salary_Category_ID AND auxSeq.MA_Sequence_ID = se.MA_Sequence_ID), C_Salary_Category" +
      "        WHERE auxSeq.C_Salary_Category_ID = C_Salary_Category.C_Salary_Category_ID" +
      "        GROUP BY auxSeq.C_Salary_Category_ID, C_Salary_Category.name) pr, AD_Ref_List" +
      "        WHERE pr.levelid =AD_Ref_List.value" +
      "        AND AD_Ref_List.AD_Reference_ID = '800097'";

    ResultSet result;
    Vector<ReportProductionCostData> vector = new Vector<ReportProductionCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);

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
        ReportProductionCostData objectReportProductionCostData = new ReportProductionCostData();
        objectReportProductionCostData.id = UtilSql.getValue(result, "id");
        objectReportProductionCostData.name = UtilSql.getValue(result, "name");
        objectReportProductionCostData.costperunit = UtilSql.getValue(result, "costperunit");
        objectReportProductionCostData.costperunitstd = UtilSql.getValue(result, "costperunitstd");
        objectReportProductionCostData.levelBlanck = UtilSql.getValue(result, "level_blanck");
        objectReportProductionCostData.levelName = UtilSql.getValue(result, "level_name");
        objectReportProductionCostData.className = UtilSql.getValue(result, "class_name");
        objectReportProductionCostData.levelid = UtilSql.getValue(result, "levelid");
        objectReportProductionCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionCostData);
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
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[vector.size()];
    vector.copyInto(objectReportProductionCostData);
    return(objectReportProductionCostData);
  }

  public static ReportProductionCostData[] selectCostCenter(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId)    throws ServletException {
    return selectCostCenter(connectionProvider, cCurrencyBase, cCurrencyConv, level, dateFrom, dateTo, mProductId, 0, 0);
  }

  public static ReportProductionCostData[] selectCostCenter(ConnectionProvider connectionProvider, String cCurrencyBase, String cCurrencyConv, String level, String dateFrom, String dateTo, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT pr.ID, pr.name, pr.CostPerUnit, pr.CostPerUnitStd, pr.level_blanck, pr.level_name, AD_Ref_List.Name as class_name, pr.levelid" +
      "       FROM (" +
      "       SELECT auxSeq.MA_CostCenter_Version_ID AS ID, MA_CostCenter.name," +
      "        SUM(auxSeq.TotalRealCost*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnit," +
      "        SUM(C_CURRENCY_CONVERT(se.CostCenterCost, ?, ?, TO_DATE(se.Updated), null, se.ad_client_id, se.ad_org_id)*auxSeq.ComponentCost)/SUM(auxSeq.ProducedQty) AS CostPerUnitStd, " +
      "            to_char((to_number(?)+1)*5) as level_blanck, to_char(40-((to_number(?)+1)*5)) as level_name, to_char(to_number(?)+1) as levelid" +
      "        FROM " +
      "          (SELECT rpp.MA_CostCenter_Version_ID, rpp.ComponentCost, SUM(rpp.ProducedQty) AS ProducedQty," +
      "           SUM(rpp.CalcCost) AS TotalRealCost, rpp.MA_Sequence_ID" +
      "           FROM" +
      "              (SELECT SUM(pl.MovementQty) AS ProducedQty, " +
      "              MAX(C_CURRENCY_CONVERT(pl.ComponentCost, ?, ?, TO_DATE(p.movementdate), null, pl.ad_client_id, pl.ad_org_id)) AS ComponentCost, " +
      "              pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID, pp.MA_CostCenter_Version_ID, " +
      "              C_CURRENCY_CONVERT(pp.CalcCost, ?, ?, TO_DATE(p.movementdate), null, pp.ad_client_id, pp.ad_org_id) AS CalcCost" +
      "              FROM M_Production p" +
      "                INNER JOIN M_ProductionPlan pp ON (p.M_Production_ID = pp.M_Production_ID)" +
      "                INNER JOIN M_ProductionLine pl ON (pp.M_ProductionPlan_ID = pl.M_ProductionPlan_ID)" +
      "                INNER JOIN MA_WRPhase wrp ON (pp.MA_WRPhase_ID = wrp.MA_WRPhase_ID)" +
      "              WHERE p.IsSOTrx = 'N'" +
      "              AND pl.ProductionType = '+'" +
      "              AND p.Processed = 'Y'" +
      "              AND p.MovementDate >= TO_DATE(?)" +
      "              AND p.MovementDate < TO_DATE(?)" +
      "              AND pl.M_Product_ID = ?" +
      "              GROUP BY pp.M_ProductionPlan_ID, wrp.MA_Sequence_ID, pp.MA_CostCenter_Version_ID, pp.CalcCost, " +
      "              p.movementdate, pp.ad_client_id, pp.ad_org_id" +
      "              HAVING SUM(pl.MovementQty) <> 0) rpp " +
      "           GROUP BY rpp.MA_CostCenter_Version_ID, rpp.ComponentCost, rpp.MA_Sequence_ID" +
      "           HAVING rpp.MA_CostCenter_Version_ID IS NOT NULL) auxSeq" +
      "        LEFT OUTER JOIN MA_Sequence se" +
      "        ON (auxSeq.MA_Sequence_ID = se.MA_Sequence_ID), MA_CostCenter_Version, MA_CostCenter" +
      "        WHERE auxSeq.MA_CostCenter_version_ID = MA_CostCenter_version.MA_CostCenter_Version_ID" +
      "          AND MA_CostCenter_Version.MA_CostCenter_ID = MA_CostCenter.MA_CostCenter_ID" +
      "        GROUP BY auxSeq.MA_CostCenter_Version_ID, MA_CostCenter.name) pr, AD_Ref_List" +
      "        WHERE pr.levelid =AD_Ref_List.value" +
      "        AND AD_Ref_List.AD_Reference_ID = '800097'";

    ResultSet result;
    Vector<ReportProductionCostData> vector = new Vector<ReportProductionCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
        ReportProductionCostData objectReportProductionCostData = new ReportProductionCostData();
        objectReportProductionCostData.id = UtilSql.getValue(result, "id");
        objectReportProductionCostData.name = UtilSql.getValue(result, "name");
        objectReportProductionCostData.costperunit = UtilSql.getValue(result, "costperunit");
        objectReportProductionCostData.costperunitstd = UtilSql.getValue(result, "costperunitstd");
        objectReportProductionCostData.levelBlanck = UtilSql.getValue(result, "level_blanck");
        objectReportProductionCostData.levelName = UtilSql.getValue(result, "level_name");
        objectReportProductionCostData.className = UtilSql.getValue(result, "class_name");
        objectReportProductionCostData.levelid = UtilSql.getValue(result, "levelid");
        objectReportProductionCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionCostData);
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
    ReportProductionCostData objectReportProductionCostData[] = new ReportProductionCostData[vector.size()];
    vector.copyInto(objectReportProductionCostData);
    return(objectReportProductionCostData);
  }

  public static String mProductDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT MAX(NAME) AS NAME FROM M_PRODUCT WHERE M_PRODUCT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
