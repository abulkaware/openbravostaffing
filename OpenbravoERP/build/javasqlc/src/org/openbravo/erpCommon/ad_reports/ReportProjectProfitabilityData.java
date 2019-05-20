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

class ReportProjectProfitabilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProjectProfitabilityData.class);
  private String InitRecordNumber="0";
  public String projectname;
  public String initdate;
  public String responsible;
  public String org;
  public String partner;
  public String orgname;
  public String projecttype;
  public String convisosym;
  public String planrevenue;
  public String plancost;
  public String planservices;
  public String planoutsourced;
  public String planreinvoicing;
  public String planexpenses;
  public String realrevenue;
  public String realcost;
  public String realservices;
  public String realoutsourced;
  public String realreinvoiced;
  public String realexpenses;
  public String collected;
  public String nodeId;
  public String issummary;
  public String count;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("projectname"))
      return projectname;
    else if (fieldName.equalsIgnoreCase("initdate"))
      return initdate;
    else if (fieldName.equalsIgnoreCase("responsible"))
      return responsible;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("orgname"))
      return orgname;
    else if (fieldName.equalsIgnoreCase("projecttype"))
      return projecttype;
    else if (fieldName.equalsIgnoreCase("convisosym"))
      return convisosym;
    else if (fieldName.equalsIgnoreCase("planrevenue"))
      return planrevenue;
    else if (fieldName.equalsIgnoreCase("plancost"))
      return plancost;
    else if (fieldName.equalsIgnoreCase("planservices"))
      return planservices;
    else if (fieldName.equalsIgnoreCase("planoutsourced"))
      return planoutsourced;
    else if (fieldName.equalsIgnoreCase("planreinvoicing"))
      return planreinvoicing;
    else if (fieldName.equalsIgnoreCase("planexpenses"))
      return planexpenses;
    else if (fieldName.equalsIgnoreCase("realrevenue"))
      return realrevenue;
    else if (fieldName.equalsIgnoreCase("realcost"))
      return realcost;
    else if (fieldName.equalsIgnoreCase("realservices"))
      return realservices;
    else if (fieldName.equalsIgnoreCase("realoutsourced"))
      return realoutsourced;
    else if (fieldName.equalsIgnoreCase("realreinvoiced"))
      return realreinvoiced;
    else if (fieldName.equalsIgnoreCase("realexpenses"))
      return realexpenses;
    else if (fieldName.equalsIgnoreCase("collected"))
      return collected;
    else if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("count"))
      return count;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProjectProfitabilityData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String datefrom2, String dateto2, String org, String client, String dateFrom, String dateTo, String dateFrom3, String dateTo3, String projecttype, String project, String Responsible, String Partner)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, cCurrencyBase, datefrom2, dateto2, org, client, dateFrom, dateTo, dateFrom3, dateTo3, projecttype, project, Responsible, Partner, 0, 0);
  }

  public static ReportProjectProfitabilityData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String cCurrencyBase, String datefrom2, String dateto2, String org, String client, String dateFrom, String dateTo, String dateFrom3, String dateTo3, String projecttype, String project, String Responsible, String Partner, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P.NAME AS PROJECTNAME, P.DATECONTRACT AS INITDATE, BPRESP.NAME AS RESPONSIBLE," +
      "          P.AD_ORG_ID AS ORG, BPCLIENT.NAME AS PARTNER, ORG.NAME AS ORGNAME,PT.NAME AS PROJECTTYPE," +
      "          C_CURRENCY_ISOSYM(?) AS CONVISOSYM," +
      "          C_CURRENCY_CONVERT(COALESCE(P.SERVREVENUE,0), P.C_CURRENCY_ID, ?, TO_DATE(COALESCE(P.DATECONTRACT, P.DATEFINISH, NOW())), NULL, P.AD_CLIENT_ID, P.AD_ORG_ID) AS PLANREVENUE, " +
      "          C_CURRENCY_CONVERT(COALESCE(P.SERVCOST,0), P.C_CURRENCY_ID, ?, TO_DATE(COALESCE(P.DATECONTRACT, P.DATEFINISH, NOW())), NULL, P.AD_CLIENT_ID, P.AD_ORG_ID) AS PLANCOST," +
      "          C_CURRENCY_CONVERT(COALESCE(P.SERVSERCOST,0), P.C_CURRENCY_ID, ?, TO_DATE(COALESCE(P.DATECONTRACT, P.DATEFINISH, NOW())), NULL, P.AD_CLIENT_ID, P.AD_ORG_ID) AS PLANSERVICES," +
      "          C_CURRENCY_CONVERT(COALESCE(P.SERVOUTCOST,0), P.C_CURRENCY_ID, ?, TO_DATE(COALESCE(P.DATECONTRACT, P.DATEFINISH, NOW())), NULL, P.AD_CLIENT_ID, P.AD_ORG_ID) AS PLANOUTSOURCED," +
      "          C_CURRENCY_CONVERT(COALESCE(P.EXPREINVOICING,0), P.C_CURRENCY_ID, ?, TO_DATE(COALESCE(P.DATECONTRACT, P.DATEFINISH, NOW())), NULL, P.AD_CLIENT_ID, P.AD_ORG_ID) AS PLANREINVOICING, " +
      "          C_CURRENCY_CONVERT(COALESCE(P.EXPEXPENSES,0), P.C_CURRENCY_ID, ?, TO_DATE(COALESCE(P.DATECONTRACT, P.DATEFINISH, NOW())), NULL, P.AD_CLIENT_ID, P.AD_ORG_ID) AS PLANEXPENSES," +
      "          COALESCE(SERREV.AMOUNT,0) AS REALREVENUE, " +
      "          (COALESCE(COST.COST,0) + COALESCE(SEROUT.AMOUNT,0)) AS REALCOST," +
      "          COALESCE(COST.COST,0) AS REALSERVICES," +
      "          COALESCE(SEROUT.AMOUNT,0) AS REALOUTSOURCED," +
      "          COALESCE(EXPREI.AMOUNT,0) AS REALREINVOICED, " +
      "          COALESCE(EXPEXP.AMOUNT,0) AS REALEXPENSES," +
      "          COALESCE(COLLECTED.AMOUNT,0) AS COLLECTED, " +
      "          '' AS NODE_ID, '' AS ISSUMMARY, '' AS COUNT" +
      "        FROM C_BPartner bpclient, AD_Org org, " +
      "          C_Project p LEFT JOIN C_BPartner bpresp ON  p.Responsible_ID = bpresp.C_BPartner_ID" +
      "                      LEFT JOIN C_Projecttype pt ON pt.C_Projecttype_ID = p.C_Projecttype_ID " +
      "                      LEFT JOIN (SELECT S_TimeExpenseLine.C_Project_ID, " +
      "         SUM((CASE S_TimeExpenseLine.IsTimereport WHEN 'Y' THEN C_Uom_Convert(S_TimeExpenseLine.qty,C_UOM.C_UOM_ID, (SELECT C_UOM_ID FROM C_UOM WHERE UOMSYMBOL='h'),'Y') ELSE 0 END)*C_CURRENCY_CONVERT(C_CALCULATECOST_CATSALARY(C_CALCULATE_CATSALARY(C_BPartner.c_bpartner_id, TO_DATE(COALESCE(S_TimeExpenseLine.DATEEXPENSE, s_timeexpense.DATEREPORT))), TO_DATE(COALESCE(S_TimeExpenseLine.DATEEXPENSE, s_timeexpense.DATEREPORT)))," +
      "         ?, ?, TO_DATE(COALESCE(S_TimeExpenseLine.DATEEXPENSE, s_timeexpense.DATEREPORT)), NULL, S_TimeExpenseLine.AD_CLIENT_ID, S_TimeExpenseLine.AD_ORG_ID)) AS cost" +
      "           FROM S_TimeExpenseLine , S_TimeExpense, C_BPartner, C_Uom" +
      "           WHERE S_TimeExpense.S_TimeExpense_ID = S_TimeExpenseLine.S_TimeExpense_ID" +
      "           AND S_TimeExpense.C_BPartner_ID = C_BPartner.C_BPartner_ID" +
      "           AND S_TimeExpenseLine.C_UOM_ID = C_UOM.C_UOM_ID" +
      "           AND S_TimeExpense.Processed = 'Y'" +
      "           AND 1=1";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND s_timeexpense.DATEREPORT >= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND s_timeexpense.DATEREPORT  < to_date(?)  ");
    strSql = strSql + 
      "           GROUP BY S_TimeExpenseLine.C_Project_ID) cost ON p.C_Project_ID = cost.C_Project_ID" +
      "                      LEFT JOIN (SELECT c_Project, sum(amount) as amount" +
      "           FROM (" +
      "           SELECT CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL THEN COALESCE(il.c_project_id, ia.c_project_id) ELSE ila.c_project_id END AS C_Project," +
      "                  CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL " +
      "                  THEN COALESCE(C_CURRENCY_CONVERT(il.linenetamt, ia.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ia.DATEINVOICED, NOW())), NULL, il.AD_CLIENT_ID, il.AD_ORG_ID),0) * " +
      "                  (1 + (CASE WHEN ia.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ia.totallines, ia.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ia.DATEINVOICED, NOW())), NULL, ia.AD_CLIENT_ID, ia.AD_ORG_ID) - disc.dis_amt)) END)) " +
      "                  ELSE COALESCE(C_CURRENCY_CONVERT(ila.amt, ia.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ia.DATEINVOICED, NOW())), NULL, ila.AD_CLIENT_ID, ila.AD_ORG_ID),0) * " +
      "                  (1 + (CASE WHEN ia.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ia.totallines, ia.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ia.DATEINVOICED, NOW())), NULL, ia.AD_CLIENT_ID, ia.AD_ORG_ID) - disc.dis_amt)) END)) END AS amount" +
      "           FROM M_Product p, C_InvoiceLine il LEFT JOIN C_InvoiceLine_AcctDimension ila on il.C_InvoiceLine_ID = ila.C_InvoiceLine_ID," +
      "             C_Invoice ia left join (SELECT il1.c_invoice_id, sum(C_CURRENCY_CONVERT(il1.linenetamt, ia.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ia.DATEINVOICED, NOW())), NULL, il1.AD_CLIENT_ID, il1.AD_ORG_ID)) as dis_amt" +
      "                                         FROM c_invoiceline il1, c_invoice ia" +
      "                                        WHERE il1.c_invoice_discount_id IS NOT NULL" +
      "                                        AND il1.c_invoice_id= ia.c_invoice_id" +
      "                                        AND il1.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "                                        AND il1.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "                                        GROUP BY il1.c_invoice_id) disc ON ia.C_Invoice_ID = disc.C_Invoice_ID" +
      "           WHERE ia.C_Invoice_ID = il.C_Invoice_ID" +
      "             AND il.M_Product_ID = p.M_Product_ID" +
      "             AND ia.issotrx = 'Y'" +
      "             AND ia.processed = 'Y'" +
      "             AND 2=2";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND ia.dateinvoiced >= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND ia.dateinvoiced  < to_date(?)  ");
    strSql = strSql + 
      "             AND ia.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "             AND ia.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "             AND (ila.c_project_id IS NOT NULL OR ia.c_project_id IS NOT NULL OR il.c_project_id IS NOT NULL)" +
      "             AND il.c_invoice_discount_id IS NULL" +
      "             AND p.producttype = 'S') AAA" +
      "           GROUP BY c_Project) serrev ON p.C_Project_ID = serrev.C_Project" +
      "                      LEFT JOIN (SELECT c_Project, sum(amount) as amount" +
      "           FROM (" +
      "           SELECT CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL THEN COALESCE(il.c_project_id, ib.c_project_id) ELSE ila.c_project_id END AS C_Project," +
      "                  CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL " +
      "                  THEN COALESCE(C_CURRENCY_CONVERT(il.linenetamt, ib.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ib.DATEINVOICED, NOW())), NULL, il.AD_CLIENT_ID, il.AD_ORG_ID),0) * " +
      "                  (1 + (CASE WHEN ib.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ib.totallines, ib.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ib.DATEINVOICED, NOW())), NULL, ib.AD_CLIENT_ID, ib.AD_ORG_ID) - disc.dis_amt)) END)) " +
      "                  ELSE COALESCE(C_CURRENCY_CONVERT(ila.amt, ib.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ib.DATEINVOICED, NOW())), NULL, ila.AD_CLIENT_ID, ila.AD_ORG_ID),0) * " +
      "                  (1 + (CASE WHEN ib.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ib.totallines, ib.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ib.DATEINVOICED, NOW())), NULL, ib.AD_CLIENT_ID, ib.AD_ORG_ID) - disc.dis_amt)) END)) END AS amount" +
      "           FROM M_Product p, C_InvoiceLine il LEFT JOIN C_InvoiceLine_AcctDimension ila on il.C_InvoiceLine_ID = ila.C_InvoiceLine_ID," +
      "             C_Invoice ib left join (SELECT il2.c_invoice_id, sum(C_CURRENCY_CONVERT(il2.linenetamt, ib.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ib.DATEINVOICED, NOW())), NULL, il2.AD_CLIENT_ID, il2.AD_ORG_ID)) as dis_amt" +
      "                                         FROM c_invoiceline il2, c_invoice ib " +
      "                                        WHERE il2.c_invoice_discount_id IS NOT NULL" +
      "                                        AND il2.c_invoice_id= ib.c_invoice_id" +
      "                                        AND il2.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "                                        AND il2.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "                                        GROUP BY il2.c_invoice_id) disc ON ib.C_Invoice_ID = disc.C_Invoice_ID" +
      "           WHERE ib.C_Invoice_ID = il.C_Invoice_ID" +
      "             AND il.M_Product_ID = p.M_Product_ID" +
      "             AND ib.issotrx = 'Y'" +
      "             AND ib.processed = 'Y'" +
      "             AND 3=3";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND ib.dateinvoiced >= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND ib.dateinvoiced  < to_date(?)  ");
    strSql = strSql + 
      "             AND ib.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "             AND ib.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "             AND (ila.c_project_id IS NOT NULL OR ib.c_project_id IS NOT NULL OR il.c_project_id IS NOT NULL)" +
      "             AND il.c_invoice_discount_id IS NULL" +
      "             AND p.producttype <> 'S') BBB" +
      "           GROUP BY c_Project) exprei ON p.C_Project_ID = exprei.C_Project" +
      "                      LEFT JOIN (SELECT c_Project, sum(amount) as amount" +
      "           FROM (" +
      "           SELECT CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL THEN COALESCE(il.c_project_id, ic.c_project_id) ELSE ila.c_project_id END AS C_Project," +
      "                  CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL " +
      "                  THEN COALESCE(C_CURRENCY_CONVERT(il.linenetamt, ic.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ic.DATEINVOICED, NOW())), NULL, il.AD_CLIENT_ID, il.AD_ORG_ID),0) * " +
      "                  (1 + (CASE WHEN ic.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ic.totallines, ic.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ic.DATEINVOICED, NOW())), NULL, ic.AD_CLIENT_ID, ic.AD_ORG_ID) - disc.dis_amt)) END)) " +
      "                  ELSE COALESCE(C_CURRENCY_CONVERT(ila.amt, ic.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ic.DATEINVOICED, NOW())), NULL, ila.AD_CLIENT_ID, ila.AD_ORG_ID),0) * " +
      "                  (1 + (CASE WHEN ic.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ic.totallines, ic.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ic.DATEINVOICED, NOW())), NULL, ic.AD_CLIENT_ID, ic.AD_ORG_ID) - disc.dis_amt)) END)) END AS amount" +
      "           FROM C_InvoiceLine il LEFT JOIN C_InvoiceLine_AcctDimension ila on il.C_InvoiceLine_ID = ila.C_InvoiceLine_ID" +
      "                                 LEFT JOIN C_GLITEM GL ON il.account_id = gl.c_glitem_id" +
      "                                 LEFT JOIN M_Product p ON il.m_product_id = p.m_product_id," +
      "             C_Invoice ic left join (SELECT il3.c_invoice_id, sum(C_CURRENCY_CONVERT(il3.linenetamt, ic.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ic.DATEINVOICED, NOW())), NULL, il3.AD_CLIENT_ID, il3.AD_ORG_ID)) as dis_amt" +
      "                                      FROM c_invoiceline il3, c_invoice ic " +
      "                                      WHERE il3.c_invoice_discount_id IS NOT NULL" +
      "                                      AND il3.c_invoice_id= ic.c_invoice_id" +
      "                                      AND il3.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "                                      AND il3.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "                                      GROUP BY il3.c_invoice_id) disc ON ic.C_Invoice_ID = disc.C_Invoice_ID" +
      "           WHERE ic.C_Invoice_ID = il.C_Invoice_ID" +
      "             AND ic.processed = 'Y'" +
      "             AND 4=4";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND ic.dateinvoiced >= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND ic.dateinvoiced  < to_date(?)  ");
    strSql = strSql + 
      "             AND ic.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "             AND ic.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "             AND (ila.c_project_id IS NOT NULL OR ic.c_project_id IS NOT NULL OR il.c_project_id IS NOT NULL)" +
      "             AND ic.issotrx = 'N'" +
      "             AND Coalesce(p.producttype,'') <> 'S') CCC" +
      "           GROUP BY c_Project) expexp ON p.C_Project_ID = expexp.C_Project" +
      "                      LEFT JOIN (SELECT c_Project, sum(amount) as amount" +
      "           FROM (" +
      "           SELECT CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL THEN COALESCE(il.c_project_id, ie.c_project_id) ELSE ila.c_project_id END AS C_Project," +
      "                  CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL" +
      "                  THEN COALESCE(C_CURRENCY_CONVERT(il.linenetamt, ie.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ie.DATEINVOICED, NOW())), NULL, il.AD_CLIENT_ID, il.AD_ORG_ID),0) *" +
      "                  (1 + (CASE WHEN ie.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ie.totallines, ie.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ie.DATEINVOICED, NOW())), NULL, ie.AD_CLIENT_ID, ie.AD_ORG_ID) - disc.dis_amt)) END))" +
      "                  ELSE COALESCE(C_CURRENCY_CONVERT(ila.amt, ie.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ie.DATEINVOICED, NOW())), NULL, ila.AD_CLIENT_ID, ila.AD_ORG_ID),0) *" +
      "                  (1 + (CASE WHEN ie.totallines IS NULL OR disc.dis_amt IS NULL THEN 0 ELSE (COALESCE(disc.dis_amt,0)/(C_CURRENCY_CONVERT(ie.totallines, ie.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ie.DATEINVOICED, NOW())), NULL, ie.AD_CLIENT_ID, ie.AD_ORG_ID) - disc.dis_amt)) END)) END AS amount" +
      "           FROM M_Product p, C_InvoiceLine il LEFT JOIN C_InvoiceLine_AcctDimension ila on il.C_InvoiceLine_ID = ila.C_InvoiceLine_ID," +
      "             C_Invoice ie left join (SELECT il.c_invoice_id, sum(C_CURRENCY_CONVERT(il.linenetamt, ie.C_CURRENCY_ID, ?, TO_DATE(COALESCE(ie.DATEINVOICED, NOW())), NULL, il.AD_CLIENT_ID, il.AD_ORG_ID)) as dis_amt" +
      "                                      FROM c_invoiceline il, c_invoice ie" +
      "                                      WHERE il.c_invoice_discount_id IS NOT NULL" +
      "                                      AND il.c_invoice_id= ie.c_invoice_id" +
      "                                      GROUP BY il.c_invoice_id) disc ON ie.C_Invoice_ID = disc.C_Invoice_ID" +
      "           WHERE ie.C_Invoice_ID = il.C_Invoice_ID" +
      "             AND il.M_Product_ID = p.M_Product_ID" +
      "             AND ie.processed = 'Y'" +
      "             AND 7=7";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND ie.dateinvoiced >= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND ie.dateinvoiced  < to_date(?)  ");
    strSql = strSql + 
      "             AND ie.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "             AND ie.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "             AND (ila.c_project_id IS NOT NULL OR ie.c_project_id IS NOT NULL OR il.c_project_id IS NOT NULL)" +
      "             AND ie.issotrx = 'N'" +
      "             AND p.producttype = 'S') CCC" +
      "           GROUP BY c_Project) serout ON p.C_Project_ID = serout.C_Project" +
      "                      LEFT JOIN (SELECT c_Project, sum(amount) as amount" +
      "           FROM (" +
      "           SELECT CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL THEN COALESCE(il.c_project_id, id.c_project_id) ELSE ila.c_project_id END AS C_Project," +
      "                  CASE WHEN ila.C_InvoiceLine_AcctDimension_ID IS NULL " +
      "                  THEN C_CURRENCY_CONVERT(il.linenetamt, id.C_CURRENCY_ID, ?, TO_DATE(COALESCE(id.DATEINVOICED, NOW())), NULL, il.AD_CLIENT_ID, il.AD_ORG_ID) * (CASE WHEN id.grandtotal=0 THEN 0 ELSE (id.totalpaid/id.grandtotal) END) " +
      "                  ELSE C_CURRENCY_CONVERT(ila.amt, id.C_CURRENCY_ID, ?, TO_DATE(COALESCE(id.DATEINVOICED, NOW())), NULL, ila.AD_CLIENT_ID, ila.AD_ORG_ID) * (CASE WHEN id.grandtotal=0 THEN 0 ELSE (id.totalpaid/id.grandtotal) END) END AS amount" +
      "           FROM C_Invoice id, C_InvoiceLine il LEFT JOIN C_InvoiceLine_AcctDimension ila on il.C_InvoiceLine_ID = ila.C_InvoiceLine_ID," +
      "             M_Product p" +
      "           WHERE id.C_Invoice_ID = il.C_Invoice_ID" +
      "             AND il.M_Product_ID = p.M_Product_ID" +
      "             AND id.processed = 'Y'" +
      "             AND 5=5";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND id.dateinvoiced >= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND id.dateinvoiced  < to_date(?)  ");
    strSql = strSql + 
      "             AND id.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "             AND id.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "             AND (ila.c_project_id IS NOT NULL OR id.c_project_id IS NOT NULL OR il.c_project_id IS NOT NULL)" +
      "             AND id.issotrx = 'Y') DDD" +
      "           GROUP BY c_Project) collected ON p.C_Project_ID = collected.C_Project" +
      "        WHERE p.C_BPartner_ID = bpclient.C_BPartner_ID" +
      "          AND p.AD_Org_ID = org.AD_Org_ID" +
      "          AND 6=6";
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND p.Datecontract >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND p.Datecontract < to_date(?)  ");
    strSql = strSql + ((dateFrom3==null || dateFrom3.equals(""))?"":"  AND p.Startdate >= to_date(?)  ");
    strSql = strSql + ((dateTo3==null || dateTo3.equals(""))?"":"  AND p.Startdate < to_date(?)  ");
    strSql = strSql + ((projecttype==null || projecttype.equals(""))?"":"  AND p.C_Projecttype_ID = ?  ");
    strSql = strSql + ((project==null || project.equals(""))?"":"  AND p.C_Project_ID = ?  ");
    strSql = strSql + ((Responsible==null || Responsible.equals(""))?"":"  AND p.Responsible_ID = ?  ");
    strSql = strSql + ((Partner==null || Partner.equals(""))?"":"  AND p.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "          AND p.AD_Org_ID IN (";
    strSql = strSql + ((org==null || org.equals(""))?"":org);
    strSql = strSql + 
      ")" +
      "          AND p.AD_Client_ID IN (";
    strSql = strSql + ((client==null || client.equals(""))?"":client);
    strSql = strSql + 
      ")" +
      "        ORDER BY orgname, partner, initdate";

    ResultSet result;
    Vector<ReportProjectProfitabilityData> vector = new Vector<ReportProjectProfitabilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (dateFrom3 != null && !(dateFrom3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom3);
      }
      if (dateTo3 != null && !(dateTo3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo3);
      }
      if (projecttype != null && !(projecttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttype);
      }
      if (project != null && !(project.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, project);
      }
      if (Responsible != null && !(Responsible.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, Responsible);
      }
      if (Partner != null && !(Partner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, Partner);
      }
      if (org != null && !(org.equals(""))) {
        }
      if (client != null && !(client.equals(""))) {
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
        ReportProjectProfitabilityData objectReportProjectProfitabilityData = new ReportProjectProfitabilityData();
        objectReportProjectProfitabilityData.projectname = UtilSql.getValue(result, "projectname");
        objectReportProjectProfitabilityData.initdate = UtilSql.getDateValue(result, "initdate", "dd-MM-yyyy");
        objectReportProjectProfitabilityData.responsible = UtilSql.getValue(result, "responsible");
        objectReportProjectProfitabilityData.org = UtilSql.getValue(result, "org");
        objectReportProjectProfitabilityData.partner = UtilSql.getValue(result, "partner");
        objectReportProjectProfitabilityData.orgname = UtilSql.getValue(result, "orgname");
        objectReportProjectProfitabilityData.projecttype = UtilSql.getValue(result, "projecttype");
        objectReportProjectProfitabilityData.convisosym = UtilSql.getValue(result, "convisosym");
        objectReportProjectProfitabilityData.planrevenue = UtilSql.getValue(result, "planrevenue");
        objectReportProjectProfitabilityData.plancost = UtilSql.getValue(result, "plancost");
        objectReportProjectProfitabilityData.planservices = UtilSql.getValue(result, "planservices");
        objectReportProjectProfitabilityData.planoutsourced = UtilSql.getValue(result, "planoutsourced");
        objectReportProjectProfitabilityData.planreinvoicing = UtilSql.getValue(result, "planreinvoicing");
        objectReportProjectProfitabilityData.planexpenses = UtilSql.getValue(result, "planexpenses");
        objectReportProjectProfitabilityData.realrevenue = UtilSql.getValue(result, "realrevenue");
        objectReportProjectProfitabilityData.realcost = UtilSql.getValue(result, "realcost");
        objectReportProjectProfitabilityData.realservices = UtilSql.getValue(result, "realservices");
        objectReportProjectProfitabilityData.realoutsourced = UtilSql.getValue(result, "realoutsourced");
        objectReportProjectProfitabilityData.realreinvoiced = UtilSql.getValue(result, "realreinvoiced");
        objectReportProjectProfitabilityData.realexpenses = UtilSql.getValue(result, "realexpenses");
        objectReportProjectProfitabilityData.collected = UtilSql.getValue(result, "collected");
        objectReportProjectProfitabilityData.nodeId = UtilSql.getValue(result, "node_id");
        objectReportProjectProfitabilityData.issummary = UtilSql.getValue(result, "issummary");
        objectReportProjectProfitabilityData.count = UtilSql.getValue(result, "count");
        objectReportProjectProfitabilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProjectProfitabilityData);
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
    ReportProjectProfitabilityData objectReportProjectProfitabilityData[] = new ReportProjectProfitabilityData[vector.size()];
    vector.copyInto(objectReportProjectProfitabilityData);
    return(objectReportProjectProfitabilityData);
  }

  public static ReportProjectProfitabilityData[] set()    throws ServletException {
    ReportProjectProfitabilityData objectReportProjectProfitabilityData[] = new ReportProjectProfitabilityData[1];
    objectReportProjectProfitabilityData[0] = new ReportProjectProfitabilityData();
    objectReportProjectProfitabilityData[0].projectname = "";
    objectReportProjectProfitabilityData[0].initdate = "";
    objectReportProjectProfitabilityData[0].responsible = "";
    objectReportProjectProfitabilityData[0].org = "";
    objectReportProjectProfitabilityData[0].partner = "";
    objectReportProjectProfitabilityData[0].orgname = "";
    objectReportProjectProfitabilityData[0].projecttype = "";
    objectReportProjectProfitabilityData[0].convisosym = "";
    objectReportProjectProfitabilityData[0].planrevenue = "";
    objectReportProjectProfitabilityData[0].plancost = "";
    objectReportProjectProfitabilityData[0].planservices = "";
    objectReportProjectProfitabilityData[0].planoutsourced = "";
    objectReportProjectProfitabilityData[0].planreinvoicing = "";
    objectReportProjectProfitabilityData[0].planexpenses = "";
    objectReportProjectProfitabilityData[0].realrevenue = "";
    objectReportProjectProfitabilityData[0].realcost = "";
    objectReportProjectProfitabilityData[0].realservices = "";
    objectReportProjectProfitabilityData[0].realoutsourced = "";
    objectReportProjectProfitabilityData[0].realreinvoiced = "";
    objectReportProjectProfitabilityData[0].realexpenses = "";
    objectReportProjectProfitabilityData[0].collected = "";
    objectReportProjectProfitabilityData[0].nodeId = "";
    objectReportProjectProfitabilityData[0].issummary = "";
    objectReportProjectProfitabilityData[0].count = "";
    return objectReportProjectProfitabilityData;
  }

  public static ReportProjectProfitabilityData[] selectOrg(ConnectionProvider connectionProvider, String adOrgId, String adClientId)    throws ServletException {
    return selectOrg(connectionProvider, adOrgId, adClientId, 0, 0);
  }

  public static ReportProjectProfitabilityData[] selectOrg(ConnectionProvider connectionProvider, String adOrgId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_TREENODE.NODE_ID, AD_ORG.ISSUMMARY" +
      "      FROM AD_CLIENTINFO, AD_TREENODE, AD_ORG" +
      "      WHERE AD_CLIENTINFO.AD_TREE_ORG_ID = AD_TREENODE.AD_TREE_ID" +
      "      AND AD_TREENODE.NODE_ID = AD_ORG.AD_ORG_ID" +
      "      AND AD_TREENODE.PARENT_ID = ?" +
      "      AND AD_CLIENTINFO.AD_CLIENT_ID = ?" +
      "      ORDER BY seqno";

    ResultSet result;
    Vector<ReportProjectProfitabilityData> vector = new Vector<ReportProjectProfitabilityData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        ReportProjectProfitabilityData objectReportProjectProfitabilityData = new ReportProjectProfitabilityData();
        objectReportProjectProfitabilityData.nodeId = UtilSql.getValue(result, "node_id");
        objectReportProjectProfitabilityData.issummary = UtilSql.getValue(result, "issummary");
        objectReportProjectProfitabilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProjectProfitabilityData);
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
    ReportProjectProfitabilityData objectReportProjectProfitabilityData[] = new ReportProjectProfitabilityData[vector.size()];
    vector.copyInto(objectReportProjectProfitabilityData);
    return(objectReportProjectProfitabilityData);
  }
}
