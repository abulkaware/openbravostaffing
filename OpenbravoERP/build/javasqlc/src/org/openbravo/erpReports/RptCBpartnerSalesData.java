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

class RptCBpartnerSalesData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnerSalesData.class);
  private String InitRecordNumber="0";
  public String value;
  public String actualyear;
  public String amount;
  public String refyear;
  public String amountref;
  public String period;
  public String year;
  public String classdesign;
  public String classTree;
  public String totalactual;
  public String totalref;
  public String valueref;
  public String nameUom;
  public String orderno;
  public String invoiceno;
  public String duedate;
  public String paymentmethod;
  public String expected;
  public String paid;
  public String outstanding;
  public String expectedhead;
  public String paidhead;
  public String outstandinghead;
  public String invPaymplanId;
  public String issotrx;
  public String finPaymentSchedInvVId;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("actualyear"))
      return actualyear;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("refyear"))
      return refyear;
    else if (fieldName.equalsIgnoreCase("amountref"))
      return amountref;
    else if (fieldName.equalsIgnoreCase("period"))
      return period;
    else if (fieldName.equalsIgnoreCase("year"))
      return year;
    else if (fieldName.equalsIgnoreCase("classdesign"))
      return classdesign;
    else if (fieldName.equalsIgnoreCase("class_tree") || fieldName.equals("classTree"))
      return classTree;
    else if (fieldName.equalsIgnoreCase("totalactual"))
      return totalactual;
    else if (fieldName.equalsIgnoreCase("totalref"))
      return totalref;
    else if (fieldName.equalsIgnoreCase("valueref"))
      return valueref;
    else if (fieldName.equalsIgnoreCase("name_uom") || fieldName.equals("nameUom"))
      return nameUom;
    else if (fieldName.equalsIgnoreCase("orderno"))
      return orderno;
    else if (fieldName.equalsIgnoreCase("invoiceno"))
      return invoiceno;
    else if (fieldName.equalsIgnoreCase("duedate"))
      return duedate;
    else if (fieldName.equalsIgnoreCase("paymentmethod"))
      return paymentmethod;
    else if (fieldName.equalsIgnoreCase("expected"))
      return expected;
    else if (fieldName.equalsIgnoreCase("paid"))
      return paid;
    else if (fieldName.equalsIgnoreCase("outstanding"))
      return outstanding;
    else if (fieldName.equalsIgnoreCase("expectedhead"))
      return expectedhead;
    else if (fieldName.equalsIgnoreCase("paidhead"))
      return paidhead;
    else if (fieldName.equalsIgnoreCase("outstandinghead"))
      return outstandinghead;
    else if (fieldName.equalsIgnoreCase("inv_paymplan_id") || fieldName.equals("invPaymplanId"))
      return invPaymplanId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("fin_payment_sched_inv_v_id") || fieldName.equals("finPaymentSchedInvVId"))
      return finPaymentSchedInvVId;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnerSalesData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE, SUM(ACTUALYEAR) AS ACTUALYEAR, SUM(AMOUNT) AS AMOUNT, SUM(REFYEAR) AS REFYEAR, SUM(AMOUNTREF) AS AMOUNTREF, '' AS PERIOD, '' AS YEAR, '' AS CLASSDESIGN, 'datawarehouseclose' AS CLASS_TREE, '' AS TOTALACTUAL, '' AS TOTALREF, '' AS VALUEREF, '' AS NAME_UOM," +
      "        '' AS ORDERNO, '' AS INVOICENO, '' AS DUEDATE, '' AS PAYMENTMETHOD, '' AS EXPECTED, '' AS PAID, '' AS OUTSTANDING, '' AS EXPECTEDHEAD, '' AS PAIDHEAD, '' AS OUTSTANDINGHEAD, '' AS INV_PAYMPLAN_ID," +
      "        '' AS ISSOTRX, '' AS FIN_PAYMENT_SCHED_INV_V_ID FROM (" +
      "        SELECT 'INVOICE' AS VALUE, TO_NUMBER(TO_CHAR(now(),'YYYY'))AS ACTUALYEAR, 0 AS REFYEAR, SUM(IL.LINENETAMT) AS AMOUNT, 0 AS AMOUNTREF" +
      "        FROM C_INVOICE I, C_INVOICELINE IL" +
      "        WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID" +
      "        AND I.DATEINVOICED< TRUNC(now())+1" +
      "        AND I.DATEINVOICED >= TRUNC(now(), TO_CHAR('YEAR')) " +
      "        AND I.ISSOTRX='Y'" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      "        UNION ALL" +
      "        SELECT 'INVOICE' AS VALUE, 0 AS ACTUALYEAR, TO_NUMBER(TO_CHAR(now() -365,'YYYY')) AS REFYEAR, 0 AS AMOUNT,  SUM(IL.LINENETAMT) AS AMOUNTREF" +
      "        FROM C_INVOICE I, C_INVOICELINE IL" +
      "        WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID" +
      "        AND I.DATEINVOICED<TRUNC(now())-364" +
      "        AND I.DATEINVOICED >= TRUNC(now()-365, TO_CHAR('YEAR')) " +
      "        AND I.ISSOTRX='Y'" +
      "        AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      ") AA" +
      "        GROUP BY VALUE";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.actualyear = UtilSql.getValue(result, "actualyear");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.refyear = UtilSql.getValue(result, "refyear");
        objectRptCBpartnerSalesData.amountref = UtilSql.getValue(result, "amountref");
        objectRptCBpartnerSalesData.period = UtilSql.getValue(result, "period");
        objectRptCBpartnerSalesData.year = UtilSql.getValue(result, "year");
        objectRptCBpartnerSalesData.classdesign = UtilSql.getValue(result, "classdesign");
        objectRptCBpartnerSalesData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerSalesData.totalactual = UtilSql.getValue(result, "totalactual");
        objectRptCBpartnerSalesData.totalref = UtilSql.getValue(result, "totalref");
        objectRptCBpartnerSalesData.valueref = UtilSql.getValue(result, "valueref");
        objectRptCBpartnerSalesData.nameUom = UtilSql.getValue(result, "name_uom");
        objectRptCBpartnerSalesData.orderno = UtilSql.getValue(result, "orderno");
        objectRptCBpartnerSalesData.invoiceno = UtilSql.getValue(result, "invoiceno");
        objectRptCBpartnerSalesData.duedate = UtilSql.getValue(result, "duedate");
        objectRptCBpartnerSalesData.paymentmethod = UtilSql.getValue(result, "paymentmethod");
        objectRptCBpartnerSalesData.expected = UtilSql.getValue(result, "expected");
        objectRptCBpartnerSalesData.paid = UtilSql.getValue(result, "paid");
        objectRptCBpartnerSalesData.outstanding = UtilSql.getValue(result, "outstanding");
        objectRptCBpartnerSalesData.expectedhead = UtilSql.getValue(result, "expectedhead");
        objectRptCBpartnerSalesData.paidhead = UtilSql.getValue(result, "paidhead");
        objectRptCBpartnerSalesData.outstandinghead = UtilSql.getValue(result, "outstandinghead");
        objectRptCBpartnerSalesData.invPaymplanId = UtilSql.getValue(result, "inv_paymplan_id");
        objectRptCBpartnerSalesData.issotrx = UtilSql.getValue(result, "issotrx");
        objectRptCBpartnerSalesData.finPaymentSchedInvVId = UtilSql.getValue(result, "fin_payment_sched_inv_v_id");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] set()    throws ServletException {
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[1];
    objectRptCBpartnerSalesData[0] = new RptCBpartnerSalesData();
    objectRptCBpartnerSalesData[0].value = "";
    objectRptCBpartnerSalesData[0].actualyear = "";
    objectRptCBpartnerSalesData[0].amount = "";
    objectRptCBpartnerSalesData[0].refyear = "";
    objectRptCBpartnerSalesData[0].amountref = "";
    objectRptCBpartnerSalesData[0].period = "";
    objectRptCBpartnerSalesData[0].year = "";
    objectRptCBpartnerSalesData[0].classdesign = "";
    objectRptCBpartnerSalesData[0].classTree = "";
    objectRptCBpartnerSalesData[0].totalactual = "";
    objectRptCBpartnerSalesData[0].totalref = "";
    objectRptCBpartnerSalesData[0].valueref = "";
    objectRptCBpartnerSalesData[0].nameUom = "";
    objectRptCBpartnerSalesData[0].orderno = "";
    objectRptCBpartnerSalesData[0].invoiceno = "";
    objectRptCBpartnerSalesData[0].duedate = "";
    objectRptCBpartnerSalesData[0].paymentmethod = "";
    objectRptCBpartnerSalesData[0].expected = "";
    objectRptCBpartnerSalesData[0].paid = "";
    objectRptCBpartnerSalesData[0].outstanding = "";
    objectRptCBpartnerSalesData[0].expectedhead = "";
    objectRptCBpartnerSalesData[0].paidhead = "";
    objectRptCBpartnerSalesData[0].outstandinghead = "";
    objectRptCBpartnerSalesData[0].invPaymplanId = "";
    objectRptCBpartnerSalesData[0].issotrx = "";
    objectRptCBpartnerSalesData[0].finPaymentSchedInvVId = "";
    return objectRptCBpartnerSalesData;
  }

  public static RptCBpartnerSalesData[] selectOrder(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectOrder(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectOrder(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE, SUM(ACTUALYEAR) AS ACTUALYEAR, SUM(AMOUNT) AS AMOUNT, SUM(REFYEAR) AS REFYEAR, SUM(AMOUNTREF) AS AMOUNTREF, 'datawarehouseclose' AS CLASS_TREE FROM (" +
      "        SELECT 'ORDER' AS VALUE, TO_NUMBER(TO_CHAR(now(),'YYYY'))AS ACTUALYEAR, 0 AS REFYEAR, SUM(IL.LINENETAMT) AS AMOUNT, 0 AS AMOUNTREF" +
      "        FROM C_ORDER I, C_ORDERLINE IL" +
      "        WHERE I.C_ORDER_ID = IL.C_ORDER_ID" +
      "        AND I.DATEORDERED< TRUNC(now())+1" +
      "        AND I.DATEORDERED >= TRUNC(now(), TO_CHAR('YEAR')) " +
      "        AND I.ISSOTRX='Y'" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      "        UNION ALL" +
      "        SELECT 'ORDER' AS VALUE, 0 AS ACTUALYEAR, TO_NUMBER(TO_CHAR(now() -365,'YYYY')) AS REFYEAR, 0 AS AMOUNT,  SUM(IL.LINENETAMT) AS AMOUNTREF" +
      "        FROM C_ORDER I, C_ORDERLINE IL" +
      "        WHERE I.C_ORDER_ID = IL.C_ORDER_ID" +
      "        AND I.DATEORDERED<TRUNC(now())-364" +
      "        AND I.DATEORDERED >= TRUNC(now()-365, TO_CHAR('YEAR')) " +
      "        AND I.ISSOTRX='Y'" +
      "        AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      ") AA" +
      "        GROUP BY VALUE";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.actualyear = UtilSql.getValue(result, "actualyear");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.refyear = UtilSql.getValue(result, "refyear");
        objectRptCBpartnerSalesData.amountref = UtilSql.getValue(result, "amountref");
        objectRptCBpartnerSalesData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectinout(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectinout(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectinout(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE, SUM(ACTUALYEAR) AS ACTUALYEAR, SUM(AMOUNT) AS AMOUNT, SUM(REFYEAR) AS REFYEAR, SUM(AMOUNTREF) AS AMOUNTREF, 'datawarehouseclose' AS CLASS_TREE FROM (" +
      "        SELECT 'INOUT' AS VALUE, TO_NUMBER(TO_CHAR(now(),'YYYY'))AS ACTUALYEAR, 0 AS REFYEAR, SUM(COALESCE(IOL.MOVEMENTQTY*IL.PRICEACTUAL,NULL)) AS AMOUNT, 0 AS AMOUNTREF" +
      "        FROM M_INOUT I, M_INOUTLINE IOL left join C_ORDERLINE IL on IOL.C_ORDERLINE_ID = IL.C_ORDERLINE_ID" +
      "        WHERE I.M_INOUT_ID = IOL.M_INOUT_ID" +
      "		AND I.MOVEMENTDATE< TRUNC(now())+1" +
      "        AND I.MOVEMENTDATE >= TRUNC(now(), TO_CHAR('YEAR')) " +
      "        AND I.ISSOTRX='Y'" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      "        UNION ALL" +
      "        SELECT 'INOUT' AS VALUE, 0 AS ACTUALYEAR, TO_NUMBER(TO_CHAR(now() -365,'YYYY')) AS REFYEAR, 0 AS AMOUNT,  SUM(COALESCE(IOL.MOVEMENTQTY*IL.PRICEACTUAL,NULL)) AS AMOUNTREF" +
      "        FROM M_INOUT I, M_INOUTLINE IOL left join C_ORDERLINE IL on IOL.C_ORDERLINE_ID = IL.C_ORDERLINE_ID" +
      "        WHERE I.M_INOUT_ID = IOL.M_INOUT_ID" +
      "		AND I.MOVEMENTDATE<TRUNC(now())-364" +
      "        AND I.MOVEMENTDATE >= TRUNC(now()-365, TO_CHAR('YEAR')) " +
      "        AND I.ISSOTRX='Y'" +
      "        AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN          " + cBpartnerId);
    strSql = strSql + 
      ") AA" +
      "        GROUP BY VALUE";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.actualyear = UtilSql.getValue(result, "actualyear");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.refyear = UtilSql.getValue(result, "refyear");
        objectRptCBpartnerSalesData.amountref = UtilSql.getValue(result, "amountref");
        objectRptCBpartnerSalesData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectperiod(ConnectionProvider connectionProvider)    throws ServletException {
    return selectperiod(connectionProvider, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectperiod(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE AS PERIOD FROM AD_MONTH";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.period = UtilSql.getValue(result, "period");
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectOrderperiod(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectOrderperiod(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectOrderperiod(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT YEAR, AMOUNT, (CASE YEAR WHEN TO_CHAR(now(),'YYYY') THEN 'BordesVerdeClaro' ELSE 'BordesRojoClaro' END) AS CLASSDESIGN, PERIOD FROM (" +
      "        SELECT YEAR, SUM(AMOUNT) AS AMOUNT, PERIOD" +
      "        FROM (" +
      "            SELECT TO_CHAR(now(),'YYYY') AS YEAR,  SUM(IL.LINENETAMT) AS AMOUNT, TO_CHAR(I.DATEORDERED,'MM') AS PERIOD" +
      "            FROM C_ORDER I, C_ORDERLINE IL" +
      "            WHERE I.C_ORDER_ID = IL.C_ORDER_ID" +
      "            AND TO_CHAR(I.DATEORDERED,'YYYY') = TO_CHAR(now(),'YYYY')" +
      "            AND I.ISSOTRX='Y'" +
      "            AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID = ?           ");
    strSql = strSql + 
      "            GROUP BY TO_CHAR(I.DATEORDERED,'MM')" +
      "            UNION" +
      "            SELECT TO_CHAR(now(), 'YYYY') AS YEAR, 0 AS AMOUNT, (CASE LENGTH(TO_CHAR(VALUE)) WHEN 2 THEN TO_CHAR(VALUE) ELSE '0' || TO_CHAR(VALUE) END) AS PERIOD " +
      "            FROM AD_INTEGER" +
      "            WHERE VALUE<=12" +
      "        ) AAA" +
      "        GROUP BY YEAR, PERIOD" +
      "        UNION ALL" +
      "        SELECT YEAR, SUM(AMOUNT) AS AMOUNT, PERIOD" +
      "        FROM (" +
      "            SELECT TO_CHAR(now()-365,'YYYY') AS YEAR,  SUM(IL.LINENETAMT)AS AMOUNT, TO_CHAR(I.DATEORDERED,'MM') AS PERIOD" +
      "            FROM C_ORDER I, C_ORDERLINE IL" +
      "            WHERE I.C_ORDER_ID = IL.C_ORDER_ID" +
      "            AND TO_CHAR(I.DATEORDERED,'YYYY') = TO_CHAR(now()-365,'YYYY')" +
      "            AND I.ISSOTRX='Y'" +
      "            AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID = ?           ");
    strSql = strSql + 
      "            GROUP BY TO_CHAR(I.DATEORDERED,'MM')" +
      "            UNION" +
      "            SELECT TO_CHAR(now()-365, 'YYYY') AS YEAR, 0 AS AMOUNT, (CASE LENGTH(TO_CHAR(VALUE)) WHEN 2 THEN TO_CHAR(VALUE) ELSE '0' || TO_CHAR(VALUE) END) AS PERIOD " +
      "            FROM AD_INTEGER" +
      "            WHERE VALUE<=12" +
      "        ) AAAA" +
      "        GROUP BY YEAR, PERIOD" +
      "        ) AA" +
      "        ORDER BY YEAR DESC, PERIOD";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.year = UtilSql.getValue(result, "year");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.classdesign = UtilSql.getValue(result, "classdesign");
        objectRptCBpartnerSalesData.period = UtilSql.getValue(result, "period");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectInvoiceperiod(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectInvoiceperiod(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectInvoiceperiod(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT YEAR, AMOUNT, (CASE YEAR WHEN TO_CHAR(now(),'YYYY') THEN 'BordesVerdeClaro' ELSE 'BordesRojoClaro' END) AS CLASSDESIGN, PERIOD FROM (" +
      "        SELECT YEAR, SUM(AMOUNT) AS AMOUNT, PERIOD" +
      "        FROM (" +
      "            SELECT TO_CHAR(now(),'YYYY') AS YEAR,  SUM(IL.LINENETAMT) AS AMOUNT, TO_CHAR(I.DATEINVOICED,'MM') AS PERIOD" +
      "            FROM C_INVOICE I, C_INVOICELINE IL" +
      "            WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID" +
      "            AND TO_CHAR(I.DATEINVOICED,'YYYY') = TO_CHAR(now(),'YYYY')" +
      "            AND I.ISSOTRX='Y'" +
      "            AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID = ?           ");
    strSql = strSql + 
      "            GROUP BY TO_CHAR(I.DATEINVOICED,'MM')" +
      "            UNION" +
      "            SELECT TO_CHAR(now(), 'YYYY') AS YEAR, 0 AS AMOUNT, (CASE LENGTH(TO_CHAR(VALUE)) WHEN 2 THEN TO_CHAR(VALUE) ELSE '0' || TO_CHAR(VALUE) END) AS PERIOD " +
      "            FROM AD_INTEGER" +
      "            WHERE VALUE<=12" +
      "        ) AAA" +
      "        GROUP BY YEAR, PERIOD" +
      "        UNION ALL" +
      "        SELECT YEAR, SUM(AMOUNT) AS AMOUNT, PERIOD" +
      "        FROM (" +
      "            SELECT TO_CHAR(now()-365,'YYYY') AS YEAR,  SUM(IL.LINENETAMT)AS AMOUNT, TO_CHAR(I.DATEINVOICED,'MM') AS PERIOD" +
      "            FROM C_INVOICE I, C_INVOICELINE IL" +
      "            WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID" +
      "            AND TO_CHAR(I.DATEINVOICED,'YYYY') = TO_CHAR(now()-365,'YYYY')" +
      "            AND I.ISSOTRX='Y'" +
      "            AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID = ?           ");
    strSql = strSql + 
      "            GROUP BY TO_CHAR(I.DATEINVOICED,'MM')" +
      "            UNION" +
      "            SELECT TO_CHAR(now()-365, 'YYYY') AS YEAR, 0 AS AMOUNT, (CASE LENGTH(TO_CHAR(VALUE)) WHEN 2 THEN TO_CHAR(VALUE) ELSE '0' || TO_CHAR(VALUE) END) AS PERIOD " +
      "            FROM AD_INTEGER" +
      "            WHERE VALUE<=12" +
      "        ) BB" +
      "        GROUP BY YEAR, PERIOD" +
      "        ) AA" +
      "        ORDER BY YEAR DESC, PERIOD";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.year = UtilSql.getValue(result, "year");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.classdesign = UtilSql.getValue(result, "classdesign");
        objectRptCBpartnerSalesData.period = UtilSql.getValue(result, "period");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectInoutperiod(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectInoutperiod(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectInoutperiod(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT YEAR, AMOUNT, (CASE YEAR WHEN TO_CHAR(now(),'YYYY') THEN 'BordesVerdeClaro' ELSE 'BordesRojoClaro' END) AS CLASSDESIGN, PERIOD FROM (" +
      "        SELECT YEAR, SUM(AMOUNT) AS AMOUNT, PERIOD" +
      "        FROM (" +
      "            SELECT TO_CHAR(now(),'YYYY') AS YEAR,  SUM(IL.MOVEMENTQTY*C_ORDERLINE.PRICEACTUAL) AS AMOUNT, TO_CHAR(I.MOVEMENTDATE,'MM') AS PERIOD" +
      "            FROM M_INOUT I, M_INOUTLINE IL left join C_ORDERLINE on IL.C_ORDERLINE_ID = C_ORDERLINE.C_ORDERLINE_ID" +
      "            WHERE I.M_INOUT_ID = IL.M_INOUT_ID" +
      "            AND TO_CHAR(I.MOVEMENTDATE,'YYYY') = TO_CHAR(now(),'YYYY')" +
      "            AND I.ISSOTRX='Y'" +
      "            AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID = ?           ");
    strSql = strSql + 
      "            GROUP BY TO_CHAR(I.MOVEMENTDATE,'MM')" +
      "            UNION" +
      "            SELECT TO_CHAR(now(), 'YYYY') AS YEAR, 0 AS AMOUNT, (CASE LENGTH(TO_CHAR(VALUE)) WHEN 2 THEN TO_CHAR(VALUE) ELSE '0' || TO_CHAR(VALUE) END) AS PERIOD " +
      "            FROM AD_INTEGER" +
      "            WHERE VALUE<=12" +
      "        ) AAA" +
      "        GROUP BY YEAR, PERIOD" +
      "        UNION ALL" +
      "        SELECT YEAR, SUM(AMOUNT) AS AMOUNT, PERIOD" +
      "        FROM (" +
      "            SELECT TO_CHAR(now()-365,'YYYY') AS YEAR,  SUM(IL.MOVEMENTQTY*C_ORDERLINE.PRICEACTUAL)AS AMOUNT, TO_CHAR(I.MOVEMENTDATE,'MM') AS PERIOD" +
      "            FROM M_INOUT I, M_INOUTLINE IL left join C_ORDERLINE on  IL.C_ORDERLINE_ID = C_ORDERLINE.C_ORDERLINE_ID " +
      "            WHERE I.M_INOUT_ID = IL.M_INOUT_ID" +
      "            AND TO_CHAR(I.MOVEMENTDATE,'YYYY') = TO_CHAR(now()-365,'YYYY')" +
      "            AND I.ISSOTRX='Y'" +
      "            AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID = ?           ");
    strSql = strSql + 
      "            GROUP BY TO_CHAR(I.MOVEMENTDATE,'MM')" +
      "            UNION" +
      "            SELECT TO_CHAR(now()-365, 'YYYY') AS YEAR, 0 AS AMOUNT, (CASE LENGTH(TO_CHAR(VALUE)) WHEN 2 THEN TO_CHAR(VALUE) ELSE '0' || TO_CHAR(VALUE) END) AS PERIOD " +
      "            FROM AD_INTEGER" +
      "            WHERE VALUE<=12" +
      "        ) BBB" +
      "        GROUP BY YEAR, PERIOD" +
      "        ) AA" +
      "        ORDER BY YEAR DESC, PERIOD";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.year = UtilSql.getValue(result, "year");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.classdesign = UtilSql.getValue(result, "classdesign");
        objectRptCBpartnerSalesData.period = UtilSql.getValue(result, "period");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectABC(ConnectionProvider connectionProvider, String actualYear, String refYear, String cBpartnerId)    throws ServletException {
    return selectABC(connectionProvider, actualYear, refYear, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectABC(ConnectionProvider connectionProvider, String actualYear, String refYear, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT 'ABC' AS VALUE, 'ABCREF' AS VALUEREF, COALESCE(SUM(AMOUNT),0) AS AMOUNT, ? AS ACTUALYEAR, COALESCE(SUM(TOTALACTUAL),0) AS TOTALACTUAL, COALESCE(SUM(AMOUNTREF),0) AS AMOUNTREF," +
      "        ? AS REFYEAR, COALESCE(SUM(TOTALREF),0) AS TOTALREF, 'datawarehouseclose' AS CLASS_TREE" +
      "        FROM (" +
      "        SELECT P.NAME, SUM(IO.LINENETAMT) AS AMOUNT, 1 AS TOTALACTUAL, TO_NUMBER(TO_CHAR(now(),'YYYY'))AS ACTUALYEAR, 0 AS REFYEAR, " +
      "        0 AS AMOUNTREF, 0 AS TOTALREF" +
      "        FROM M_PRODUCT P, C_INVOICELINE IO, C_INVOICE I" +
      "        WHERE I.C_INVOICE_ID = IO.C_INVOICE_ID" +
      "        AND P.M_PRODUCT_ID=IO.M_PRODUCT_ID" +
      "        AND TO_CHAR(I.DATEINVOICED,'YYYY') = ?" +
      "        AND I.ISSOTRX='Y'" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + 
      "        GROUP BY P.NAME" +
      "        UNION ALL" +
      "        SELECT P.NAME, 0 AS AMOUNT, 0 AS TOTALACTUAL, 0 AS ACTUALYEAR, TO_NUMBER(TO_CHAR(now() -365,'YYYY')) AS REFYEAR, " +
      "        SUM(IO.LINENETAMT) AS AMOUNTREF, 1 AS TOTALREF" +
      "        FROM M_PRODUCT P, C_INVOICELINE IO, C_INVOICE I" +
      "        WHERE I.C_INVOICE_ID=IO.C_INVOICE_ID" +
      "        AND IO.M_PRODUCT_ID = P.M_PRODUCT_ID" +
      "        AND TO_CHAR(I.DATEINVOICED,'YYYY') = ?" +
      "        AND I.ISSOTRX='Y'" +
      "        AND 2=2";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND I.C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + 
      "        GROUP BY P.NAME) AA";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualYear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refYear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualYear);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refYear);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.valueref = UtilSql.getValue(result, "valueref");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.actualyear = UtilSql.getValue(result, "actualyear");
        objectRptCBpartnerSalesData.totalactual = UtilSql.getValue(result, "totalactual");
        objectRptCBpartnerSalesData.amountref = UtilSql.getValue(result, "amountref");
        objectRptCBpartnerSalesData.refyear = UtilSql.getValue(result, "refyear");
        objectRptCBpartnerSalesData.totalref = UtilSql.getValue(result, "totalref");
        objectRptCBpartnerSalesData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectABCactualdetail(ConnectionProvider connectionProvider, String actualYear, String cBpartnerId)    throws ServletException {
    return selectABCactualdetail(connectionProvider, actualYear, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectABCactualdetail(ConnectionProvider connectionProvider, String actualYear, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE, COALESCE(SUM(QTYINVOICED),0) AS TOTALACTUAL, COALESCE(SUM(AMOUNT),0) AS AMOUNT, NAME_UOM FROM (" +
      "        SELECT P.NAME AS VALUE, IO.QTYINVOICED AS QTYINVOICED , IO.LINENETAMT AS AMOUNT, U.UOMSYMBOL AS NAME_UOM" +
      "        FROM M_PRODUCT P, C_INVOICELINE IO, C_INVOICE I, C_UOM U" +
      "        WHERE I.C_INVOICE_ID=IO.C_INVOICE_ID" +
      "        AND P.M_PRODUCT_ID=IO.M_PRODUCT_ID" +
      "        AND P.C_UOM_ID = U.C_UOM_ID" +
      "        AND TO_CHAR(I.DATEINVOICED,'YYYY') = ?" +
      "        AND I.ISSOTRX='Y'" +
      "        AND I.C_BPARTNER_ID = ?) AA" +
      "        GROUP BY VALUE, NAME_UOM" +
      "        ORDER BY AMOUNT DESC";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualYear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.totalactual = UtilSql.getValue(result, "totalactual");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.nameUom = UtilSql.getValue(result, "name_uom");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectABCrefdetail(ConnectionProvider connectionProvider, String refYear, String cBpartnerId)    throws ServletException {
    return selectABCrefdetail(connectionProvider, refYear, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectABCrefdetail(ConnectionProvider connectionProvider, String refYear, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VALUE, COALESCE(SUM(QTYINVOICED),0) AS TOTALACTUAL, COALESCE(SUM(AMOUNT),0) AS AMOUNT, NAME_UOM FROM (" +
      "        SELECT P.NAME AS VALUE, IO.QTYINVOICED AS QTYINVOICED , IO.LINENETAMT AS AMOUNT, U.UOMSYMBOL AS NAME_UOM" +
      "        FROM M_PRODUCT P, C_INVOICELINE IO, C_INVOICE I, C_UOM U" +
      "        WHERE I.C_INVOICE_ID=IO.C_INVOICE_ID" +
      "        AND P.M_PRODUCT_ID=IO.M_PRODUCT_ID" +
      "        AND P.C_UOM_ID = U.C_UOM_ID" +
      "        AND TO_CHAR(I.DATEINVOICED,'YYYY') = ?" +
      "        AND I.ISSOTRX='Y'" +
      "        AND I.C_BPARTNER_ID = ?) AA" +
      "        GROUP BY VALUE, NAME_UOM" +
      "        ORDER BY AMOUNT DESC";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refYear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.totalactual = UtilSql.getValue(result, "totalactual");
        objectRptCBpartnerSalesData.amount = UtilSql.getValue(result, "amount");
        objectRptCBpartnerSalesData.nameUom = UtilSql.getValue(result, "name_uom");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectPaymentsdetail(ConnectionProvider connectionProvider, String lang, String curTo, String issotrx, String bPartner)    throws ServletException {
    return selectPaymentsdetail(connectionProvider, lang, curTo, issotrx, bPartner, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectPaymentsdetail(ConnectionProvider connectionProvider, String lang, String curTo, String issotrx, String bPartner, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I.DOCUMENTNO AS INVOICENO, AD_COLUMN_IDENTIFIER('FIN_PAYMENTMETHOD',PS.FIN_PAYMENTMETHOD_ID, ?) AS PAYMENTMETHOD, " +
      "        C_CURRENCY_CONVERT(PS.EXPECTED, I.C_CURRENCY_ID, ?, I.DATEINVOICED, NULL) AS EXPECTED," +
      "        C_CURRENCY_CONVERT(PS.RECEIVED, I.C_CURRENCY_ID, ?, I.DATEINVOICED, NULL) AS PAID," +
      "        C_CURRENCY_CONVERT(PS.OUTSTANDING, I.C_CURRENCY_ID, ?, I.DATEINVOICED, NULL) AS OUTSTANDING," +
      "        PS.FIN_PAYMENT_SCHED_INV_V_ID AS INV_PAYMPLAN_ID, ? AS ISSOTRX," +
      "        PS.DUEDATE AS DUEDATE" +
      "        FROM FIN_PAYMENT_SCHED_INV_V PS, C_INVOICE I" +
      "        WHERE PS.C_INVOICE_ID = I.C_INVOICE_ID" +
      "        AND I.ISSOTRX = ?" +
      "        AND I.C_BPARTNER_ID = ?" +
      "        AND PS.OUTSTANDING <> 0   ";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, curTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, curTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, curTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bPartner);

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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.invoiceno = UtilSql.getValue(result, "invoiceno");
        objectRptCBpartnerSalesData.paymentmethod = UtilSql.getValue(result, "paymentmethod");
        objectRptCBpartnerSalesData.expected = UtilSql.getValue(result, "expected");
        objectRptCBpartnerSalesData.paid = UtilSql.getValue(result, "paid");
        objectRptCBpartnerSalesData.outstanding = UtilSql.getValue(result, "outstanding");
        objectRptCBpartnerSalesData.invPaymplanId = UtilSql.getValue(result, "inv_paymplan_id");
        objectRptCBpartnerSalesData.issotrx = UtilSql.getValue(result, "issotrx");
        objectRptCBpartnerSalesData.duedate = UtilSql.getDateValue(result, "duedate", "dd-MM-yyyy");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }

  public static RptCBpartnerSalesData[] selectPayments(ConnectionProvider connectionProvider, String typeDoc, String curTo, String clientId, String orgId, String issotrx, String bPartner)    throws ServletException {
    return selectPayments(connectionProvider, typeDoc, curTo, clientId, orgId, issotrx, bPartner, 0, 0);
  }

  public static RptCBpartnerSalesData[] selectPayments(ConnectionProvider connectionProvider, String typeDoc, String curTo, String clientId, String orgId, String issotrx, String bPartner, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TO_CHAR(?) AS VALUE, " +
      "        SUM(C_CURRENCY_CONVERT(PS.EXPECTED, I.C_CURRENCY_ID, ?, I.DATEINVOICED, NULL, ?, ?)) AS EXPECTEDHEAD," +
      "        SUM(C_CURRENCY_CONVERT(PS.RECEIVED, I.C_CURRENCY_ID, ?, I.DATEINVOICED, NULL, ?, ?)) AS PAIDHEAD," +
      "        SUM(C_CURRENCY_CONVERT(PS.OUTSTANDING, I.C_CURRENCY_ID, ?, I.DATEINVOICED, NULL, ?, ?)) AS OUTSTANDINGHEAD," +
      "        TO_CHAR('datawarehouseclose') AS CLASS_TREE" +
      "        FROM FIN_PAYMENT_SCHED_INV_V PS, C_INVOICE I" +
      "        WHERE PS.C_INVOICE_ID = I.C_INVOICE_ID" +
      "        AND I.ISSOTRX = ?" +
      "        AND I.C_BPARTNER_ID IN ";
    strSql = strSql + ((bPartner==null || bPartner.equals(""))?"":bPartner);
    strSql = strSql + 
      "        AND PS.OUTSTANDING <> 0" +
      "        GROUP BY TO_CHAR(?), TO_CHAR('datawarehouseclose')";

    ResultSet result;
    Vector<RptCBpartnerSalesData> vector = new Vector<RptCBpartnerSalesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeDoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, curTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, curTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, curTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      if (bPartner != null && !(bPartner.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeDoc);

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
        RptCBpartnerSalesData objectRptCBpartnerSalesData = new RptCBpartnerSalesData();
        objectRptCBpartnerSalesData.value = UtilSql.getValue(result, "value");
        objectRptCBpartnerSalesData.expectedhead = UtilSql.getValue(result, "expectedhead");
        objectRptCBpartnerSalesData.paidhead = UtilSql.getValue(result, "paidhead");
        objectRptCBpartnerSalesData.outstandinghead = UtilSql.getValue(result, "outstandinghead");
        objectRptCBpartnerSalesData.classTree = UtilSql.getValue(result, "class_tree");
        objectRptCBpartnerSalesData.position = Long.toString(countRecord);
        objectRptCBpartnerSalesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerSalesData);
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
    RptCBpartnerSalesData objectRptCBpartnerSalesData[] = new RptCBpartnerSalesData[vector.size()];
    vector.copyInto(objectRptCBpartnerSalesData);
    return(objectRptCBpartnerSalesData);
  }
}
