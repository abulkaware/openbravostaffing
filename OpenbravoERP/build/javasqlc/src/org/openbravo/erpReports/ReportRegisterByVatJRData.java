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

class ReportRegisterByVatJRData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportRegisterByVatJRData.class);
  private String InitRecordNumber="0";
  public String name;
  public String aliquota;
  public String imponibile;
  public String nonimponibile;
  public String esente;
  public String ivaindeducibile;
  public String iva;
  public String totale;
  public String totaleprecedente;
  public String issale;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("aliquota"))
      return aliquota;
    else if (fieldName.equalsIgnoreCase("imponibile"))
      return imponibile;
    else if (fieldName.equalsIgnoreCase("nonimponibile"))
      return nonimponibile;
    else if (fieldName.equalsIgnoreCase("esente"))
      return esente;
    else if (fieldName.equalsIgnoreCase("ivaindeducibile"))
      return ivaindeducibile;
    else if (fieldName.equalsIgnoreCase("iva"))
      return iva;
    else if (fieldName.equalsIgnoreCase("totale"))
      return totale;
    else if (fieldName.equalsIgnoreCase("totaleprecedente"))
      return totaleprecedente;
    else if (fieldName.equalsIgnoreCase("issale"))
      return issale;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportRegisterByVatJRData[] select(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo)    throws ServletException {
    return select(connectionProvider, parDateFrom, parDateTo, 0, 0);
  }

  public static ReportRegisterByVatJRData[] select(ConnectionProvider connectionProvider, String parDateFrom, String parDateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      " select taxreg.name, " +
      "	(tax.name||'-'||tax.rate || '%' ) as Aliquota," +
      " 	coalesce(taxregline.taxbaseamt,0) as Imponibile, " +
      " 	coalesce(taxregline.novatamt,0) as NonImponibile, " +
      " 	coalesce(taxregline.exemptamt,0) as Esente , " +
      " 	coalesce(taxregline.taxundamt,0) as IvaIndeducibile, " +
      " 	coalesce(taxregline.taxamt,0) as Iva, " +
      " 	coalesce(taxregline.totalamt,0) as Totale," +
      " 	coalesce(taxreg.lastregaccumamt,0) as TotalePrecedente," +
      "	case " +
      " 	when taxregtyp.issotrx ='Y' then 'Sales'" +
      " 	else 'Purchase'" +
      " 	end " +
      " 	as IsSale" +
      " from c_taxregister taxreg, " +
      " c_taxregisterline taxregline , " +
      " c_taxregister_type taxregtyp, " +
      " c_tax tax" +
      " where" +
      "     taxreg.c_taxregister_id = taxregline.c_taxregister_id" +
      " and taxreg.c_taxregister_type_id = taxregtyp.c_taxregister_type_id " +
      " and taxregline.c_tax_id = tax.c_tax_id" +
      " and 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  and taxregline.invoicedate >= to_date(?,'DD/MM/YYYY')  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  and taxregline.invoicedate <= to_date(?,'DD/MM/YYYY') ");
    strSql = strSql + 
      " order by  taxreg.name,(tax.name||'-'||tax.rate || '%' )";

    ResultSet result;
    Vector<ReportRegisterByVatJRData> vector = new Vector<ReportRegisterByVatJRData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
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
        ReportRegisterByVatJRData objectReportRegisterByVatJRData = new ReportRegisterByVatJRData();
        objectReportRegisterByVatJRData.name = UtilSql.getValue(result, "name");
        objectReportRegisterByVatJRData.aliquota = UtilSql.getValue(result, "aliquota");
        objectReportRegisterByVatJRData.imponibile = UtilSql.getValue(result, "imponibile");
        objectReportRegisterByVatJRData.nonimponibile = UtilSql.getValue(result, "nonimponibile");
        objectReportRegisterByVatJRData.esente = UtilSql.getValue(result, "esente");
        objectReportRegisterByVatJRData.ivaindeducibile = UtilSql.getValue(result, "ivaindeducibile");
        objectReportRegisterByVatJRData.iva = UtilSql.getValue(result, "iva");
        objectReportRegisterByVatJRData.totale = UtilSql.getValue(result, "totale");
        objectReportRegisterByVatJRData.totaleprecedente = UtilSql.getValue(result, "totaleprecedente");
        objectReportRegisterByVatJRData.issale = UtilSql.getValue(result, "issale");
        objectReportRegisterByVatJRData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportRegisterByVatJRData);
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
    ReportRegisterByVatJRData objectReportRegisterByVatJRData[] = new ReportRegisterByVatJRData[vector.size()];
    vector.copyInto(objectReportRegisterByVatJRData);
    return(objectReportRegisterByVatJRData);
  }

  public static ReportRegisterByVatJRData[] set()    throws ServletException {
    ReportRegisterByVatJRData objectReportRegisterByVatJRData[] = new ReportRegisterByVatJRData[1];
    objectReportRegisterByVatJRData[0] = new ReportRegisterByVatJRData();
    objectReportRegisterByVatJRData[0].name = "";
    objectReportRegisterByVatJRData[0].aliquota = "";
    objectReportRegisterByVatJRData[0].imponibile = "";
    objectReportRegisterByVatJRData[0].nonimponibile = "";
    objectReportRegisterByVatJRData[0].esente = "";
    objectReportRegisterByVatJRData[0].ivaindeducibile = "";
    objectReportRegisterByVatJRData[0].iva = "";
    objectReportRegisterByVatJRData[0].totale = "";
    objectReportRegisterByVatJRData[0].totaleprecedente = "";
    objectReportRegisterByVatJRData[0].issale = "";
    return objectReportRegisterByVatJRData;
  }
}
