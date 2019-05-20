/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.common.uom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Finacc_Trx_Full_Acct_V;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.ClientInformation;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.ApprovedVendor;
import org.openbravo.model.common.plm.CreatePOLinesPE;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductAUM;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.BudgetLine;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.manufacturing.processplan.OperationProduct;
import org.openbravo.model.manufacturing.transaction.GlobalUse;
import org.openbravo.model.manufacturing.transaction.WorkRequirementProduct;
import org.openbravo.model.materialmgmt.onhandquantity.ProductStockView;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.onhandquantity.StorageDetail;
import org.openbravo.model.materialmgmt.onhandquantity.StoragePending;
import org.openbravo.model.materialmgmt.onhandquantity.ValuedStockAggregated;
import org.openbravo.model.materialmgmt.transaction.InternalConsumptionLine;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;
import org.openbravo.model.materialmgmt.transaction.MaterialTransaction;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialReceiptPickEdit;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialShipmentPickEdit;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.timeandexpense.ExpenseType;
import org.openbravo.model.timeandexpense.ResourceType;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
/**
 * Entity class for entity UOM (stored in table C_UOM).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class UOM extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_UOM";
    public static final String ENTITY_NAME = "UOM";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_EDICODE = "eDICode";
    public static final String PROPERTY_SYMBOL = "symbol";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STANDARDPRECISION = "standardPrecision";
    public static final String PROPERTY_COSTINGPRECISION = "costingPrecision";
    public static final String PROPERTY_DEFAULT = "default";
    public static final String PROPERTY_BREAKDOWN = "breakdown";
    public static final String PROPERTY_UOMTYPE = "uOMType";
    public static final String PROPERTY_USEINPRODUCTION = "useinproduction";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_APPROVEDVENDORLIST = "approvedVendorList";
    public static final String PROPERTY_CLIENTINFORMATIONUOMFORVOLUMELIST = "clientInformationUOMForVolumeList";
    public static final String PROPERTY_CLIENTINFORMATIONUOMFORWEIGHTLIST = "clientInformationUOMForWeightList";
    public static final String PROPERTY_CLIENTINFORMATIONUOMFORLENGTHLIST = "clientInformationUOMForLengthList";
    public static final String PROPERTY_CLIENTINFORMATIONUOMFORTIMELIST = "clientInformationUOMForTimeList";
    public static final String PROPERTY_CREATEPOLINESPEAUMLIST = "createPOLinesPEAumList";
    public static final String PROPERTY_EXPENSETYPELIST = "expenseTypeList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEOPERATIVEUOMLIST = "invoiceLineOperativeUOMList";
    public static final String PROPERTY_MANUFACTURINGGLOBALUSELIST = "manufacturingGlobalUseList";
    public static final String PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST = "manufacturingOperationProductList";
    public static final String PROPERTY_MANUFACTURINGPRODUCTIONLINELIST = "manufacturingProductionLineList";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST = "manufacturingWorkRequirementProductList";
    public static final String PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST = "materialMgmtInternalConsumptionLineList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST = "materialMgmtInternalMovementLineList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEALTERNATIVEUOMLIST = "materialMgmtInternalMovementLineAlternativeUOMList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST = "materialMgmtInventoryCountLineList";
    public static final String PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST = "materialMgmtMaterialTransactionList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEOPERATIVEUOMLIST = "materialMgmtShipmentInOutLineOperativeUOMList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEDETAILLIST = "materialMgmtStorageDetailList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST = "materialMgmtStoragePendingList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEOPERATIVEUOMLIST = "orderLineOperativeUOMList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINELIST = "procurementRequisitionLineList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINEOPERATIVEUOMLIST = "procurementRequisitionLineOperativeUOMList";
    public static final String PROPERTY_PRODUCTLIST = "productList";
    public static final String PROPERTY_PRODUCTUOMFORWEIGHTLIST = "productUOMForWeightList";
    public static final String PROPERTY_PRODUCTAUMLIST = "productAUMList";
    public static final String PROPERTY_PRODUCTSTOCKVIEWLIST = "productStockViewList";
    public static final String PROPERTY_PRODUCTUOMLIST = "productUOMList";
    public static final String PROPERTY_RESOURCETYPELIST = "resourceTypeList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST = "returnMaterialReceiptPickEditList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITALTERNATIVEUOMLIST = "returnMaterialReceiptPickEditAlternativeUOMList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITRETURNEDUOMLIST = "returnMaterialReceiptPickEditReturnedUOMList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST = "returnMaterialShipmentPickEditList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITALTERNATIVEUOMLIST = "returnMaterialShipmentPickEditAlternativeUOMList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITRETURNEDUOMLIST = "returnMaterialShipmentPickEditReturnedUOMList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_UOMCONVERSIONLIST = "uOMConversionList";
    public static final String PROPERTY_UOMCONVERSIONTOUOMLIST = "uOMConversionToUOMList";
    public static final String PROPERTY_UOMTRLLIST = "uOMTrlList";
    public static final String PROPERTY_VALUEDSTOCKAGGREGATEDLIST = "valuedStockAggregatedList";

    public UOM() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DEFAULT, false);
        setDefaultValue(PROPERTY_BREAKDOWN, false);
        setDefaultValue(PROPERTY_USEINPRODUCTION, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APPROVEDVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONUOMFORVOLUMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONUOMFORWEIGHTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONUOMFORLENGTHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONUOMFORTIMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CREATEPOLINESPEAUMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXPENSETYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEOPERATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGGLOBALUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEALTERNATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEOPERATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEOPERATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINEOPERATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTUOMFORWEIGHTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTAUMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSTOCKVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RESOURCETYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITALTERNATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITRETURNEDUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITALTERNATIVEUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITRETURNEDUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_UOMCONVERSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_UOMCONVERSIONTOUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_UOMTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VALUEDSTOCKAGGREGATEDLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getEDICode() {
        return (String) get(PROPERTY_EDICODE);
    }

    public void setEDICode(String eDICode) {
        set(PROPERTY_EDICODE, eDICode);
    }

    public String getSymbol() {
        return (String) get(PROPERTY_SYMBOL);
    }

    public void setSymbol(String symbol) {
        set(PROPERTY_SYMBOL, symbol);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getStandardPrecision() {
        return (Long) get(PROPERTY_STANDARDPRECISION);
    }

    public void setStandardPrecision(Long standardPrecision) {
        set(PROPERTY_STANDARDPRECISION, standardPrecision);
    }

    public Long getCostingPrecision() {
        return (Long) get(PROPERTY_COSTINGPRECISION);
    }

    public void setCostingPrecision(Long costingPrecision) {
        set(PROPERTY_COSTINGPRECISION, costingPrecision);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_DEFAULT);
    }

    public void setDefault(Boolean deflt) {
        set(PROPERTY_DEFAULT, deflt);
    }

    public Boolean isBreakdown() {
        return (Boolean) get(PROPERTY_BREAKDOWN);
    }

    public void setBreakdown(Boolean breakdown) {
        set(PROPERTY_BREAKDOWN, breakdown);
    }

    public String getUOMType() {
        return (String) get(PROPERTY_UOMTYPE);
    }

    public void setUOMType(String uOMType) {
        set(PROPERTY_UOMTYPE, uOMType);
    }

    public Boolean isUseinproduction() {
        return (Boolean) get(PROPERTY_USEINPRODUCTION);
    }

    public void setUseinproduction(Boolean useinproduction) {
        set(PROPERTY_USEINPRODUCTION, useinproduction);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccTransactionAccounting> getAPRMFinAccTransactionAcctVList() {
      return (List<FinAccTransactionAccounting>) get(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST);
    }

    public void setAPRMFinAccTransactionAcctVList(List<FinAccTransactionAccounting> aPRMFinAccTransactionAcctVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, aPRMFinAccTransactionAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Finacc_Trx_Full_Acct_V> getAPRMFinaccTrxFullAcctVList() {
      return (List<APRM_Finacc_Trx_Full_Acct_V>) get(PROPERTY_APRMFINACCTRXFULLACCTVLIST);
    }

    public void setAPRMFinaccTrxFullAcctVList(List<APRM_Finacc_Trx_Full_Acct_V> aPRMFinaccTrxFullAcctVList) {
        set(PROPERTY_APRMFINACCTRXFULLACCTVLIST, aPRMFinaccTrxFullAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<ApprovedVendor> getApprovedVendorList() {
      return (List<ApprovedVendor>) get(PROPERTY_APPROVEDVENDORLIST);
    }

    public void setApprovedVendorList(List<ApprovedVendor> approvedVendorList) {
        set(PROPERTY_APPROVEDVENDORLIST, approvedVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationUOMForVolumeList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONUOMFORVOLUMELIST);
    }

    public void setClientInformationUOMForVolumeList(List<ClientInformation> clientInformationUOMForVolumeList) {
        set(PROPERTY_CLIENTINFORMATIONUOMFORVOLUMELIST, clientInformationUOMForVolumeList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationUOMForWeightList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONUOMFORWEIGHTLIST);
    }

    public void setClientInformationUOMForWeightList(List<ClientInformation> clientInformationUOMForWeightList) {
        set(PROPERTY_CLIENTINFORMATIONUOMFORWEIGHTLIST, clientInformationUOMForWeightList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationUOMForLengthList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONUOMFORLENGTHLIST);
    }

    public void setClientInformationUOMForLengthList(List<ClientInformation> clientInformationUOMForLengthList) {
        set(PROPERTY_CLIENTINFORMATIONUOMFORLENGTHLIST, clientInformationUOMForLengthList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationUOMForTimeList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONUOMFORTIMELIST);
    }

    public void setClientInformationUOMForTimeList(List<ClientInformation> clientInformationUOMForTimeList) {
        set(PROPERTY_CLIENTINFORMATIONUOMFORTIMELIST, clientInformationUOMForTimeList);
    }

    @SuppressWarnings("unchecked")
    public List<CreatePOLinesPE> getCreatePOLinesPEAumList() {
      return (List<CreatePOLinesPE>) get(PROPERTY_CREATEPOLINESPEAUMLIST);
    }

    public void setCreatePOLinesPEAumList(List<CreatePOLinesPE> createPOLinesPEAumList) {
        set(PROPERTY_CREATEPOLINESPEAUMLIST, createPOLinesPEAumList);
    }

    @SuppressWarnings("unchecked")
    public List<ExpenseType> getExpenseTypeList() {
      return (List<ExpenseType>) get(PROPERTY_EXPENSETYPELIST);
    }

    public void setExpenseTypeList(List<ExpenseType> expenseTypeList) {
        set(PROPERTY_EXPENSETYPELIST, expenseTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineOperativeUOMList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEOPERATIVEUOMLIST);
    }

    public void setInvoiceLineOperativeUOMList(List<InvoiceLine> invoiceLineOperativeUOMList) {
        set(PROPERTY_INVOICELINEOPERATIVEUOMLIST, invoiceLineOperativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<GlobalUse> getManufacturingGlobalUseList() {
      return (List<GlobalUse>) get(PROPERTY_MANUFACTURINGGLOBALUSELIST);
    }

    public void setManufacturingGlobalUseList(List<GlobalUse> manufacturingGlobalUseList) {
        set(PROPERTY_MANUFACTURINGGLOBALUSELIST, manufacturingGlobalUseList);
    }

    @SuppressWarnings("unchecked")
    public List<OperationProduct> getManufacturingOperationProductList() {
      return (List<OperationProduct>) get(PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST);
    }

    public void setManufacturingOperationProductList(List<OperationProduct> manufacturingOperationProductList) {
        set(PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST, manufacturingOperationProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionLine> getManufacturingProductionLineList() {
      return (List<ProductionLine>) get(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST);
    }

    public void setManufacturingProductionLineList(List<ProductionLine> manufacturingProductionLineList) {
        set(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST, manufacturingProductionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirementProduct> getManufacturingWorkRequirementProductList() {
      return (List<WorkRequirementProduct>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST);
    }

    public void setManufacturingWorkRequirementProductList(List<WorkRequirementProduct> manufacturingWorkRequirementProductList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST, manufacturingWorkRequirementProductList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalConsumptionLine> getMaterialMgmtInternalConsumptionLineList() {
      return (List<InternalConsumptionLine>) get(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST);
    }

    public void setMaterialMgmtInternalConsumptionLineList(List<InternalConsumptionLine> materialMgmtInternalConsumptionLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST, materialMgmtInternalConsumptionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST);
    }

    public void setMaterialMgmtInternalMovementLineList(List<InternalMovementLine> materialMgmtInternalMovementLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, materialMgmtInternalMovementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineAlternativeUOMList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEALTERNATIVEUOMLIST);
    }

    public void setMaterialMgmtInternalMovementLineAlternativeUOMList(List<InternalMovementLine> materialMgmtInternalMovementLineAlternativeUOMList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEALTERNATIVEUOMLIST, materialMgmtInternalMovementLineAlternativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCountLine> getMaterialMgmtInventoryCountLineList() {
      return (List<InventoryCountLine>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST);
    }

    public void setMaterialMgmtInventoryCountLineList(List<InventoryCountLine> materialMgmtInventoryCountLineList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST, materialMgmtInventoryCountLineList);
    }

    @SuppressWarnings("unchecked")
    public List<MaterialTransaction> getMaterialMgmtMaterialTransactionList() {
      return (List<MaterialTransaction>) get(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST);
    }

    public void setMaterialMgmtMaterialTransactionList(List<MaterialTransaction> materialMgmtMaterialTransactionList) {
        set(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST, materialMgmtMaterialTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getMaterialMgmtReservationList() {
      return (List<Reservation>) get(PROPERTY_MATERIALMGMTRESERVATIONLIST);
    }

    public void setMaterialMgmtReservationList(List<Reservation> materialMgmtReservationList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONLIST, materialMgmtReservationList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineOperativeUOMList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEOPERATIVEUOMLIST);
    }

    public void setMaterialMgmtShipmentInOutLineOperativeUOMList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineOperativeUOMList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEOPERATIVEUOMLIST, materialMgmtShipmentInOutLineOperativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<StorageDetail> getMaterialMgmtStorageDetailList() {
      return (List<StorageDetail>) get(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST);
    }

    public void setMaterialMgmtStorageDetailList(List<StorageDetail> materialMgmtStorageDetailList) {
        set(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, materialMgmtStorageDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<StoragePending> getMaterialMgmtStoragePendingList() {
      return (List<StoragePending>) get(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST);
    }

    public void setMaterialMgmtStoragePendingList(List<StoragePending> materialMgmtStoragePendingList) {
        set(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, materialMgmtStoragePendingList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineOperativeUOMList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINEOPERATIVEUOMLIST);
    }

    public void setOrderLineOperativeUOMList(List<OrderLine> orderLineOperativeUOMList) {
        set(PROPERTY_ORDERLINEOPERATIVEUOMLIST, orderLineOperativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINELIST);
    }

    public void setProcurementRequisitionLineList(List<RequisitionLine> procurementRequisitionLineList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINELIST, procurementRequisitionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineOperativeUOMList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINEOPERATIVEUOMLIST);
    }

    public void setProcurementRequisitionLineOperativeUOMList(List<RequisitionLine> procurementRequisitionLineOperativeUOMList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINEOPERATIVEUOMLIST, procurementRequisitionLineOperativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
      return (List<Product>) get(PROPERTY_PRODUCTLIST);
    }

    public void setProductList(List<Product> productList) {
        set(PROPERTY_PRODUCTLIST, productList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductUOMForWeightList() {
      return (List<Product>) get(PROPERTY_PRODUCTUOMFORWEIGHTLIST);
    }

    public void setProductUOMForWeightList(List<Product> productUOMForWeightList) {
        set(PROPERTY_PRODUCTUOMFORWEIGHTLIST, productUOMForWeightList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductAUM> getProductAUMList() {
      return (List<ProductAUM>) get(PROPERTY_PRODUCTAUMLIST);
    }

    public void setProductAUMList(List<ProductAUM> productAUMList) {
        set(PROPERTY_PRODUCTAUMLIST, productAUMList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductStockView> getProductStockViewList() {
      return (List<ProductStockView>) get(PROPERTY_PRODUCTSTOCKVIEWLIST);
    }

    public void setProductStockViewList(List<ProductStockView> productStockViewList) {
        set(PROPERTY_PRODUCTSTOCKVIEWLIST, productStockViewList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductUOM> getProductUOMList() {
      return (List<ProductUOM>) get(PROPERTY_PRODUCTUOMLIST);
    }

    public void setProductUOMList(List<ProductUOM> productUOMList) {
        set(PROPERTY_PRODUCTUOMLIST, productUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<ResourceType> getResourceTypeList() {
      return (List<ResourceType>) get(PROPERTY_RESOURCETYPELIST);
    }

    public void setResourceTypeList(List<ResourceType> resourceTypeList) {
        set(PROPERTY_RESOURCETYPELIST, resourceTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialReceiptPickEdit> getReturnMaterialReceiptPickEditList() {
      return (List<ReturnMaterialReceiptPickEdit>) get(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST);
    }

    public void setReturnMaterialReceiptPickEditList(List<ReturnMaterialReceiptPickEdit> returnMaterialReceiptPickEditList) {
        set(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, returnMaterialReceiptPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialReceiptPickEdit> getReturnMaterialReceiptPickEditAlternativeUOMList() {
      return (List<ReturnMaterialReceiptPickEdit>) get(PROPERTY_RETURNMATERIALRECEIPTPICKEDITALTERNATIVEUOMLIST);
    }

    public void setReturnMaterialReceiptPickEditAlternativeUOMList(List<ReturnMaterialReceiptPickEdit> returnMaterialReceiptPickEditAlternativeUOMList) {
        set(PROPERTY_RETURNMATERIALRECEIPTPICKEDITALTERNATIVEUOMLIST, returnMaterialReceiptPickEditAlternativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialReceiptPickEdit> getReturnMaterialReceiptPickEditReturnedUOMList() {
      return (List<ReturnMaterialReceiptPickEdit>) get(PROPERTY_RETURNMATERIALRECEIPTPICKEDITRETURNEDUOMLIST);
    }

    public void setReturnMaterialReceiptPickEditReturnedUOMList(List<ReturnMaterialReceiptPickEdit> returnMaterialReceiptPickEditReturnedUOMList) {
        set(PROPERTY_RETURNMATERIALRECEIPTPICKEDITRETURNEDUOMLIST, returnMaterialReceiptPickEditReturnedUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialShipmentPickEdit> getReturnMaterialShipmentPickEditList() {
      return (List<ReturnMaterialShipmentPickEdit>) get(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST);
    }

    public void setReturnMaterialShipmentPickEditList(List<ReturnMaterialShipmentPickEdit> returnMaterialShipmentPickEditList) {
        set(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, returnMaterialShipmentPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialShipmentPickEdit> getReturnMaterialShipmentPickEditAlternativeUOMList() {
      return (List<ReturnMaterialShipmentPickEdit>) get(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITALTERNATIVEUOMLIST);
    }

    public void setReturnMaterialShipmentPickEditAlternativeUOMList(List<ReturnMaterialShipmentPickEdit> returnMaterialShipmentPickEditAlternativeUOMList) {
        set(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITALTERNATIVEUOMLIST, returnMaterialShipmentPickEditAlternativeUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialShipmentPickEdit> getReturnMaterialShipmentPickEditReturnedUOMList() {
      return (List<ReturnMaterialShipmentPickEdit>) get(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITRETURNEDUOMLIST);
    }

    public void setReturnMaterialShipmentPickEditReturnedUOMList(List<ReturnMaterialShipmentPickEdit> returnMaterialShipmentPickEditReturnedUOMList) {
        set(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITRETURNEDUOMLIST, returnMaterialShipmentPickEditReturnedUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
      return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLineV> getTimeAndExpenseSheetLineVList() {
      return (List<SheetLineV>) get(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST);
    }

    public void setTimeAndExpenseSheetLineVList(List<SheetLineV> timeAndExpenseSheetLineVList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, timeAndExpenseSheetLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<UOMConversion> getUOMConversionList() {
      return (List<UOMConversion>) get(PROPERTY_UOMCONVERSIONLIST);
    }

    public void setUOMConversionList(List<UOMConversion> uOMConversionList) {
        set(PROPERTY_UOMCONVERSIONLIST, uOMConversionList);
    }

    @SuppressWarnings("unchecked")
    public List<UOMConversion> getUOMConversionToUOMList() {
      return (List<UOMConversion>) get(PROPERTY_UOMCONVERSIONTOUOMLIST);
    }

    public void setUOMConversionToUOMList(List<UOMConversion> uOMConversionToUOMList) {
        set(PROPERTY_UOMCONVERSIONTOUOMLIST, uOMConversionToUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<UOMTrl> getUOMTrlList() {
      return (List<UOMTrl>) get(PROPERTY_UOMTRLLIST);
    }

    public void setUOMTrlList(List<UOMTrl> uOMTrlList) {
        set(PROPERTY_UOMTRLLIST, uOMTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ValuedStockAggregated> getValuedStockAggregatedList() {
      return (List<ValuedStockAggregated>) get(PROPERTY_VALUEDSTOCKAGGREGATEDLIST);
    }

    public void setValuedStockAggregatedList(List<ValuedStockAggregated> valuedStockAggregatedList) {
        set(PROPERTY_VALUEDSTOCKAGGREGATEDLIST, valuedStockAggregatedList);
    }

}
