//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CreateFileData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFileData.class);
  private String InitRecordNumber="0";
  public String bank;
  public String codebank;
  public String codebranch;
  public String digitcontrol1;
  public String digitcontrol2;
  public String codeaccount;
  public String nCuenta;
  public String entidad;
  public String entidad19;
  public String nif;
  public String dateplanned;
  public String hoy;
  public String entofi;
  public String ine;
  public String tercero;
  public String fechaFactura;
  public String fechaVencimiento;
  public String payamt;
  public String creditcardnumber;
  public String nFactura;
  public String nFactura19;
  public String ciudad;
  public String direccion;
  public String concepto;
  public String plaza;
  public String localidad;
  public String postal;
  public String codigoProvincia;
  public String lineas;
  public String ordenantes;
  public String hueco;
  public String content;
  public String bpname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("bank"))
      return bank;
    else if (fieldName.equalsIgnoreCase("codebank"))
      return codebank;
    else if (fieldName.equalsIgnoreCase("codebranch"))
      return codebranch;
    else if (fieldName.equalsIgnoreCase("digitcontrol1"))
      return digitcontrol1;
    else if (fieldName.equalsIgnoreCase("digitcontrol2"))
      return digitcontrol2;
    else if (fieldName.equalsIgnoreCase("codeaccount"))
      return codeaccount;
    else if (fieldName.equalsIgnoreCase("n_cuenta") || fieldName.equals("nCuenta"))
      return nCuenta;
    else if (fieldName.equalsIgnoreCase("entidad"))
      return entidad;
    else if (fieldName.equalsIgnoreCase("entidad19"))
      return entidad19;
    else if (fieldName.equalsIgnoreCase("nif"))
      return nif;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("hoy"))
      return hoy;
    else if (fieldName.equalsIgnoreCase("entofi"))
      return entofi;
    else if (fieldName.equalsIgnoreCase("ine"))
      return ine;
    else if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("fecha_factura") || fieldName.equals("fechaFactura"))
      return fechaFactura;
    else if (fieldName.equalsIgnoreCase("fecha_vencimiento") || fieldName.equals("fechaVencimiento"))
      return fechaVencimiento;
    else if (fieldName.equalsIgnoreCase("payamt"))
      return payamt;
    else if (fieldName.equalsIgnoreCase("creditcardnumber"))
      return creditcardnumber;
    else if (fieldName.equalsIgnoreCase("n_factura") || fieldName.equals("nFactura"))
      return nFactura;
    else if (fieldName.equalsIgnoreCase("n_factura19") || fieldName.equals("nFactura19"))
      return nFactura19;
    else if (fieldName.equalsIgnoreCase("ciudad"))
      return ciudad;
    else if (fieldName.equalsIgnoreCase("direccion"))
      return direccion;
    else if (fieldName.equalsIgnoreCase("concepto"))
      return concepto;
    else if (fieldName.equalsIgnoreCase("plaza"))
      return plaza;
    else if (fieldName.equalsIgnoreCase("localidad"))
      return localidad;
    else if (fieldName.equalsIgnoreCase("postal"))
      return postal;
    else if (fieldName.equalsIgnoreCase("codigo_provincia") || fieldName.equals("codigoProvincia"))
      return codigoProvincia;
    else if (fieldName.equalsIgnoreCase("lineas"))
      return lineas;
    else if (fieldName.equalsIgnoreCase("ordenantes"))
      return ordenantes;
    else if (fieldName.equalsIgnoreCase("hueco"))
      return hueco;
    else if (fieldName.equalsIgnoreCase("content"))
      return content;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFileData[] select(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    return select(connectionProvider, cRemittanceId, 0, 0);
  }

  public static CreateFileData[] select(ConnectionProvider connectionProvider, String cRemittanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				select B.NAME AS BANK,b.codebank, b.codebranch, b.DIGITCONTROL as digitcontrol1, ba.DIGITCONTROL as digitcontrol2," +
      "      ba.CODEACCOUNT," +
      "			LPAD(B.CODEBANK,4,'0')||LPAD(B.CODEBRANCH,4,'0')||B.DIGITCONTROL||ba.DIGITCONTROL||LPAD(ba.CODEACCOUNT,10,'0') AS N_CUENTA," +
      "      lpad(rpad(o.NAME,40,' '),46,' ') AS ENTIDAD, rpad(o.NAME,40,' ') AS ENTIDAD19, oi.TAXID AS NIF, TO_CHAR(r.Duedate  ,'DD')||TO_CHAR(r.Duedate,'MM')||TO_CHAR(r.Duedate,'YY')AS DATEPLANNED, TO_CHAR(now(), 'DD')||TO_CHAR(now(), 'MM')||TO_CHAR(now(), 'YY') AS HOY," +
      "			LPAD(RPAD(LPAD(B.CODEBANK,4,'0')||LPAD(B.CODEBRANCH,4,'0'),74,' '),94,' ') AS ENTOFI, LPAD(B.INE_NUMBER,61,' ') AS INE," +
      "			'' AS TERCERO," +
      "      '' AS FECHA_FACTURA, '' AS FECHA_VENCIMIENTO, '' AS PAYAMT, '' AS CREDITCARDNUMBER, '' AS N_FACTURA, '' AS N_FACTURA19, '' AS CIUDAD, '' AS DIRECCION," +
      "      '' AS CONCEPTO, '' AS PLAZA, '' AS LOCALIDAD, '' AS POSTAL, '' AS CODIGO_PROVINCIA, '' AS LINEAS, '' AS ORDENANTES, '' AS HUECO, '' AS CONTENT, '' AS bpname" +
      "      from c_remittance r, ad_client c," +
      "					 c_bankAccount		ba," +
      "					 c_Bank						b," +
      "					 ad_orgInfo				oi," +
      "                     ad_org                 o" +
      "		 where r.ad_client_id = c.ad_client_id" +
      "		 	 and   r.AD_ORG_ID = oi.ad_org_id" +
      "             and oi.ad_org_id  = o.ad_org_id" +
      "			 and r.C_BANKACCOUNT_ID = ba.c_bankAccount_id" +
      "			 and b.c_bank_id = ba.c_bank_Id" +
      "       and r.C_Remittance_ID = ?";

    ResultSet result;
    Vector<CreateFileData> vector = new Vector<CreateFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

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
        CreateFileData objectCreateFileData = new CreateFileData();
        objectCreateFileData.bank = UtilSql.getValue(result, "bank");
        objectCreateFileData.codebank = UtilSql.getValue(result, "codebank");
        objectCreateFileData.codebranch = UtilSql.getValue(result, "codebranch");
        objectCreateFileData.digitcontrol1 = UtilSql.getValue(result, "digitcontrol1");
        objectCreateFileData.digitcontrol2 = UtilSql.getValue(result, "digitcontrol2");
        objectCreateFileData.codeaccount = UtilSql.getValue(result, "codeaccount");
        objectCreateFileData.nCuenta = UtilSql.getValue(result, "n_cuenta");
        objectCreateFileData.entidad = UtilSql.getValue(result, "entidad");
        objectCreateFileData.entidad19 = UtilSql.getValue(result, "entidad19");
        objectCreateFileData.nif = UtilSql.getValue(result, "nif");
        objectCreateFileData.dateplanned = UtilSql.getValue(result, "dateplanned");
        objectCreateFileData.hoy = UtilSql.getValue(result, "hoy");
        objectCreateFileData.entofi = UtilSql.getValue(result, "entofi");
        objectCreateFileData.ine = UtilSql.getValue(result, "ine");
        objectCreateFileData.tercero = UtilSql.getValue(result, "tercero");
        objectCreateFileData.fechaFactura = UtilSql.getValue(result, "fecha_factura");
        objectCreateFileData.fechaVencimiento = UtilSql.getValue(result, "fecha_vencimiento");
        objectCreateFileData.payamt = UtilSql.getValue(result, "payamt");
        objectCreateFileData.creditcardnumber = UtilSql.getValue(result, "creditcardnumber");
        objectCreateFileData.nFactura = UtilSql.getValue(result, "n_factura");
        objectCreateFileData.nFactura19 = UtilSql.getValue(result, "n_factura19");
        objectCreateFileData.ciudad = UtilSql.getValue(result, "ciudad");
        objectCreateFileData.direccion = UtilSql.getValue(result, "direccion");
        objectCreateFileData.concepto = UtilSql.getValue(result, "concepto");
        objectCreateFileData.plaza = UtilSql.getValue(result, "plaza");
        objectCreateFileData.localidad = UtilSql.getValue(result, "localidad");
        objectCreateFileData.postal = UtilSql.getValue(result, "postal");
        objectCreateFileData.codigoProvincia = UtilSql.getValue(result, "codigo_provincia");
        objectCreateFileData.lineas = UtilSql.getValue(result, "lineas");
        objectCreateFileData.ordenantes = UtilSql.getValue(result, "ordenantes");
        objectCreateFileData.hueco = UtilSql.getValue(result, "hueco");
        objectCreateFileData.content = UtilSql.getValue(result, "content");
        objectCreateFileData.bpname = UtilSql.getValue(result, "bpname");
        objectCreateFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFileData);
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
    CreateFileData objectCreateFileData[] = new CreateFileData[vector.size()];
    vector.copyInto(objectCreateFileData);
    return(objectCreateFileData);
  }

  public static CreateFileData[] selectLineas(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    return selectLineas(connectionProvider, cRemittanceId, 0, 0);
  }

  public static CreateFileData[] selectLineas(ConnectionProvider connectionProvider, String cRemittanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT RPAD(COALESCE(BA.A_Name,COALESCE(BP.NAME2,BP.NAME)),40,' ') AS TERCERO,RPAD(TO_CHAR(COALESCE(C_INVOICE.DATEINVOICED,DP.DATEPLANNED), 'DDMMYY'),14) AS FECHA_FACTURA," +
      "      TO_CHAR(TO_CHAR(DP.DATEPLANNED, 'DDMMYY')) AS FECHA_VENCIMIENTO,LPAD(TO_CHAR(ROUND(DP.AMOUNT*100,0)),10,'0') AS PAYAMT," +
      "      (SELECT MAX(BP_A.ACCOUNTNO) FROM C_BP_BANKACCOUNT BP_A WHERE BP.C_BPARTNER_ID = BP_A.C_BPARTNER_ID AND BP_A.ISACTIVE='Y')  AS CREDITCARDNUMBER," +
      "      LPAD(BP.VALUE,12,'0') AS N_FACTURA, RPAD(LPAD(BP.VALUE,8,'0'),12,' ') AS N_FACTURA19,L.CITY AS CIUDAD, RPAD(L.ADDRESS1,40,' ') AS DIRECCION," +
      "      TO_CHAR(now(),'DD')||TO_CHAR(now(),'MM')||TO_CHAR(now(),'YY') AS HOY, RPAD(COALESCE(TO_CHAR(DP.DESCRIPTION),' '),40,' ') AS CONCEPTO," +
      "      RPAD(L.CITY,35,' ') AS PLAZA, RPAD(L.CITY,38,' ') AS LOCALIDAD, L.POSTAL AS POSTAL, SUBSTR(L.POSTAL,1,2) AS CODIGO_PROVINCIA, BP.TAXID AS NIF" +
      "      FROM c_remittanceline S, C_BPARTNER_LOCATION BP_L," +
      "      C_LOCATION L, C_BPARTNER BP, C_BP_BankAccount BA," +
      "      C_DEBT_PAYMENT DP left join C_INVOICE on DP.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "      WHERE S.C_debt_payment_id = DP.C_debt_payment_id" +
      "      AND BA.C_BPartner_ID = BP.C_BPartner_ID" +
      "      AND DP.C_BPARTNER_ID = BP.C_BPARTNER_ID" +
      "      AND BP_L.C_BPARTNER_LOCATION_ID = C_GETBPLOCATIONID(BP.C_BPARTNER_ID, 'B')" +
      "      AND BP_L.C_LOCATION_ID = L.C_LOCATION_ID" +
      "      AND BA.IsActive = 'Y'" +
      "      and s.C_Remittance_ID = ?";

    ResultSet result;
    Vector<CreateFileData> vector = new Vector<CreateFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

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
        CreateFileData objectCreateFileData = new CreateFileData();
        objectCreateFileData.tercero = UtilSql.getValue(result, "tercero");
        objectCreateFileData.fechaFactura = UtilSql.getValue(result, "fecha_factura");
        objectCreateFileData.fechaVencimiento = UtilSql.getValue(result, "fecha_vencimiento");
        objectCreateFileData.payamt = UtilSql.getValue(result, "payamt");
        objectCreateFileData.creditcardnumber = UtilSql.getValue(result, "creditcardnumber");
        objectCreateFileData.nFactura = UtilSql.getValue(result, "n_factura");
        objectCreateFileData.nFactura19 = UtilSql.getValue(result, "n_factura19");
        objectCreateFileData.ciudad = UtilSql.getValue(result, "ciudad");
        objectCreateFileData.direccion = UtilSql.getValue(result, "direccion");
        objectCreateFileData.hoy = UtilSql.getValue(result, "hoy");
        objectCreateFileData.concepto = UtilSql.getValue(result, "concepto");
        objectCreateFileData.plaza = UtilSql.getValue(result, "plaza");
        objectCreateFileData.localidad = UtilSql.getValue(result, "localidad");
        objectCreateFileData.postal = UtilSql.getValue(result, "postal");
        objectCreateFileData.codigoProvincia = UtilSql.getValue(result, "codigo_provincia");
        objectCreateFileData.nif = UtilSql.getValue(result, "nif");
        objectCreateFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFileData);
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
    CreateFileData objectCreateFileData[] = new CreateFileData[vector.size()];
    vector.copyInto(objectCreateFileData);
    return(objectCreateFileData);
  }

  public static CreateFileData[] selectTotal(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    return selectTotal(connectionProvider, cRemittanceId, 0, 0);
  }

  public static CreateFileData[] selectTotal(ConnectionProvider connectionProvider, String cRemittanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT RPAD(LPAD(TO_CHAR(ROUND(sum(DP.AMOUNT)*100,0)),10,'0'),16,' ') AS PAYAMT," +
      "      LPAD(TO_CHAR(COUNT(*)),10,'0') AS N_FACTURA" +
      "      FROM C_DEBT_PAYMENT DP," +
      "			     c_remittanceLine rl" +
      "		 where dp.c_debt_payment_id = rl.c_debt_payment_id" +
      "       and rl.C_Remittance_ID = ?";

    ResultSet result;
    Vector<CreateFileData> vector = new Vector<CreateFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

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
        CreateFileData objectCreateFileData = new CreateFileData();
        objectCreateFileData.payamt = UtilSql.getValue(result, "payamt");
        objectCreateFileData.nFactura = UtilSql.getValue(result, "n_factura");
        objectCreateFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFileData);
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
    CreateFileData objectCreateFileData[] = new CreateFileData[vector.size()];
    vector.copyInto(objectCreateFileData);
    return(objectCreateFileData);
  }

  public static CreateFileData[] selectNLineas(ConnectionProvider connectionProvider, String nLineas)    throws ServletException {
    return selectNLineas(connectionProvider, nLineas, 0, 0);
  }

  public static CreateFileData[] selectNLineas(ConnectionProvider connectionProvider, String nLineas, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT RPAD(LPAD(?,10,'0'),48,' ') AS LINEAS, LPAD(RPAD(LPAD('1',4,'0'),20,' '),72,' ') AS ORDENANTES, LPAD(' ',72,' ') AS HUECO FROM DUAL";

    ResultSet result;
    Vector<CreateFileData> vector = new Vector<CreateFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nLineas);

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
        CreateFileData objectCreateFileData = new CreateFileData();
        objectCreateFileData.lineas = UtilSql.getValue(result, "lineas");
        objectCreateFileData.ordenantes = UtilSql.getValue(result, "ordenantes");
        objectCreateFileData.hueco = UtilSql.getValue(result, "hueco");
        objectCreateFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFileData);
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
    CreateFileData objectCreateFileData[] = new CreateFileData[vector.size()];
    vector.copyInto(objectCreateFileData);
    return(objectCreateFileData);
  }

  public static String selectParam(ConnectionProvider connectionProvider, String cRemittanceId, String param)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select upper(Content)" +
      "        from c_Remittance           r," +
      "             c_Remittance_Type      rt," +
      "             c_Remittance_Parameter rp" +
      "			 where r.C_Remittance_Type_id = rt.C_Remittance_Type_id" +
      "			   and rp.C_Remittance_Type_Id =  rt.C_Remittance_Type_id" +
      "				 and r.C_Remittance_id = ?" +
      "				 and upper(rp.name)=upper(to_char(?))";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "upper");
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

  public static String selectComprobacion1(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT count(*)" +
      "		FROM C_DEBT_PAYMENT DP," +
      "		     c_remittanceLine rl" +
      "    WHERE rl.c_debt_payment_id = dp.c_debt_payment_id" +
      "    AND DP.ISPAID = 'N'" +
      "    AND DP.C_BPARTNER_ID = NULL" +
      "		and rl.c_remittance_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String selectComprobacion2(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    	SELECT COUNT(*)" +
      "		  FROM c_remittanceLine rl" +
      "    WHERE rl.c_remittance_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String selectComprobacion3(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    	select count(*)" +
      "		  from c_remittance" +
      "		where processed='Y'" +
      "		 and c_remittance_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String selectComprobacion4(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    		 SELECT count(*)" +
      "		 FROM C_DEBT_PAYMENT DP," +
      "		      c_remittanceLine rl" +
      "    WHERE DP.C_DEBT_PAYMENT_ID = rl.C_DEBT_PAYMENT_id" +
      "    AND DP.ISPAID = 'N'" +
      "    AND DP.C_BPARTNER_ID IS NOT NULL" +
      "		and rl.c_remittance_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static CreateFileData[] selectComprobacion5(ConnectionProvider connectionProvider, String cRemittanceId)    throws ServletException {
    return selectComprobacion5(connectionProvider, cRemittanceId, 0, 0);
  }

  public static CreateFileData[] selectComprobacion5(ConnectionProvider connectionProvider, String cRemittanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_bpartner.name as bpname" +
      "        FROM c_remittanceline" +
      "        INNER JOIN c_debt_payment ON (c_debt_payment.c_debt_payment_id= c_remittanceline.c_debt_payment_id)" +
      "        INNER JOIN c_bp_bankaccount ON (c_bp_bankaccount.c_bpartner_id= c_debt_payment.c_bpartner_id and c_bp_bankaccount.isactive='Y')" +
      "        INNER JOIN c_bpartner ON (c_bp_bankaccount.c_bpartner_id= c_bpartner.c_bpartner_id)" +
      "        WHERE c_remittanceline.C_Remittance_ID = ?" +
      "        GROUP BY c_debt_payment.c_bpartner_id,c_bpartner.name, c_remittanceline.c_debt_payment_id" +
      "        HAVING count(*)>1";

    ResultSet result;
    Vector<CreateFileData> vector = new Vector<CreateFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRemittanceId);

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
        CreateFileData objectCreateFileData = new CreateFileData();
        objectCreateFileData.bpname = UtilSql.getValue(result, "bpname");
        objectCreateFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFileData);
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
    CreateFileData objectCreateFileData[] = new CreateFileData[vector.size()];
    vector.copyInto(objectCreateFileData);
    return(objectCreateFileData);
  }
}
