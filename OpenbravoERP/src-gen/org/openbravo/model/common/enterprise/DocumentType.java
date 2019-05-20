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
package org.openbravo.model.common.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Reconciliation_v;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceV2;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.payment.DPManagement;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatement;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentProposal;
import org.openbravo.model.financialmgmt.payment.FIN_Reconciliation;
import org.openbravo.model.financialmgmt.payment.Settlement;
import org.openbravo.model.financialmgmt.tax.TaxRegisterTypeLines;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.materialmgmt.cost.CostAdjustment;
import org.openbravo.model.materialmgmt.cost.InventoryAmountUpdate;
import org.openbravo.model.materialmgmt.cost.LandedCost;
import org.openbravo.model.materialmgmt.cost.LandedCostCost;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pos.ExternalPOS;
/**
 * Entity class for entity DocumentType (stored in table C_DocType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DocumentType extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_DocType";
    public static final String ENTITY_NAME = "DocumentType";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRINTTEXT = "printText";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTCATEGORY = "documentCategory";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_SOSUBTYPE = "sOSubType";
    public static final String PROPERTY_DOCUMENTTYPEFORSHIPMENT = "documentTypeForShipment";
    public static final String PROPERTY_DOCUMENTTYPEFORINVOICE = "documentTypeForInvoice";
    public static final String PROPERTY_SEQUENCEDDOCUMENT = "sequencedDocument";
    public static final String PROPERTY_DOCUMENTSEQUENCE = "documentSequence";
    public static final String PROPERTY_GLCATEGORY = "gLCategory";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_DEFAULT = "default";
    public static final String PROPERTY_NUMBEROFCOPIES = "numberOfCopies";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_FILTERBYORGANIZATION = "filterByOrganization";
    public static final String PROPERTY_DOCUMENTCANCELLED = "documentCancelled";
    public static final String PROPERTY_EXPENSE = "expense";
    public static final String PROPERTY_REVERSAL = "reversal";
    public static final String PROPERTY_RETURN = "return";
    public static final String PROPERTY_DOCUMENTTYPEFORORDER = "documentTypeForOrder";
    public static final String PROPERTY_APRMRECONCILIATIONLIST = "aPRMReconciliationList";
    public static final String PROPERTY_COSTADJUSTMENTLIST = "costAdjustmentList";
    public static final String PROPERTY_DOCUMENTTEMPLATELIST = "documentTemplateList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST = "documentTypeDocumentTypeForShipmentList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST = "documentTypeDocumentTypeForInvoiceList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST = "documentTypeDocumentCancelledList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST = "documentTypeDocumentTypeForOrderList";
    public static final String PROPERTY_DOCUMENTTYPETRLLIST = "documentTypeTrlList";
    public static final String PROPERTY_EXTERNALPOSLIST = "externalPOSList";
    public static final String PROPERTY_FINBANKSTATEMENTLIST = "fINBankStatementList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTPROPOSALLIST = "fINPaymentProposalList";
    public static final String PROPERTY_FINRECONCILIATIONLIST = "fINReconciliationList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST = "financialMgmtDPManagementList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTSETTLEMENTLIST = "financialMgmtSettlementList";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST = "financialMgmtTaxRegisterTypeLinesList";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELIST = "inventoryAmountUpdateList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICETRANSACTIONDOCUMENTLIST = "invoiceTransactionDocumentList";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST = "invoiceV2TransactionDocumentList";
    public static final String PROPERTY_LANDEDCOSTLIST = "landedCostList";
    public static final String PROPERTY_LANDEDCOSTCOSTLIST = "landedCostCostList";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST = "manufacturingWorkRequirementList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERTRANSACTIONDOCUMENTLIST = "orderTransactionDocumentList";

    public DocumentType() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SALESTRANSACTION, false);
        setDefaultValue(PROPERTY_SEQUENCEDDOCUMENT, true);
        setDefaultValue(PROPERTY_DEFAULT, false);
        setDefaultValue(PROPERTY_NUMBEROFCOPIES, (long) 1);
        setDefaultValue(PROPERTY_FILTERBYORGANIZATION, false);
        setDefaultValue(PROPERTY_EXPENSE, false);
        setDefaultValue(PROPERTY_REVERSAL, false);
        setDefaultValue(PROPERTY_RETURN, false);
        setDefaultValue(PROPERTY_APRMRECONCILIATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTADJUSTMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTEMPLATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
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

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getPrintText() {
        return (String) get(PROPERTY_PRINTTEXT);
    }

    public void setPrintText(String printText) {
        set(PROPERTY_PRINTTEXT, printText);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentCategory() {
        return (String) get(PROPERTY_DOCUMENTCATEGORY);
    }

    public void setDocumentCategory(String documentCategory) {
        set(PROPERTY_DOCUMENTCATEGORY, documentCategory);
    }

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getSOSubType() {
        return (String) get(PROPERTY_SOSUBTYPE);
    }

    public void setSOSubType(String sOSubType) {
        set(PROPERTY_SOSUBTYPE, sOSubType);
    }

    public DocumentType getDocumentTypeForShipment() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORSHIPMENT);
    }

    public void setDocumentTypeForShipment(DocumentType documentTypeForShipment) {
        set(PROPERTY_DOCUMENTTYPEFORSHIPMENT, documentTypeForShipment);
    }

    public DocumentType getDocumentTypeForInvoice() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORINVOICE);
    }

    public void setDocumentTypeForInvoice(DocumentType documentTypeForInvoice) {
        set(PROPERTY_DOCUMENTTYPEFORINVOICE, documentTypeForInvoice);
    }

    public Boolean isSequencedDocument() {
        return (Boolean) get(PROPERTY_SEQUENCEDDOCUMENT);
    }

    public void setSequencedDocument(Boolean sequencedDocument) {
        set(PROPERTY_SEQUENCEDDOCUMENT, sequencedDocument);
    }

    public Sequence getDocumentSequence() {
        return (Sequence) get(PROPERTY_DOCUMENTSEQUENCE);
    }

    public void setDocumentSequence(Sequence documentSequence) {
        set(PROPERTY_DOCUMENTSEQUENCE, documentSequence);
    }

    public GLCategory getGLCategory() {
        return (GLCategory) get(PROPERTY_GLCATEGORY);
    }

    public void setGLCategory(GLCategory gLCategory) {
        set(PROPERTY_GLCATEGORY, gLCategory);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_DEFAULT);
    }

    public void setDefault(Boolean deflt) {
        set(PROPERTY_DEFAULT, deflt);
    }

    public Long getNumberOfCopies() {
        return (Long) get(PROPERTY_NUMBEROFCOPIES);
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        set(PROPERTY_NUMBEROFCOPIES, numberOfCopies);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Boolean isFilterByOrganization() {
        return (Boolean) get(PROPERTY_FILTERBYORGANIZATION);
    }

    public void setFilterByOrganization(Boolean filterByOrganization) {
        set(PROPERTY_FILTERBYORGANIZATION, filterByOrganization);
    }

    public DocumentType getDocumentCancelled() {
        return (DocumentType) get(PROPERTY_DOCUMENTCANCELLED);
    }

    public void setDocumentCancelled(DocumentType documentCancelled) {
        set(PROPERTY_DOCUMENTCANCELLED, documentCancelled);
    }

    public Boolean isExpense() {
        return (Boolean) get(PROPERTY_EXPENSE);
    }

    public void setExpense(Boolean expense) {
        set(PROPERTY_EXPENSE, expense);
    }

    public Boolean isReversal() {
        return (Boolean) get(PROPERTY_REVERSAL);
    }

    public void setReversal(Boolean reversal) {
        set(PROPERTY_REVERSAL, reversal);
    }

    public Boolean isReturn() {
        return (Boolean) get(PROPERTY_RETURN);
    }

    public void setReturn(Boolean rturn) {
        set(PROPERTY_RETURN, rturn);
    }

    public DocumentType getDocumentTypeForOrder() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORORDER);
    }

    public void setDocumentTypeForOrder(DocumentType documentTypeForOrder) {
        set(PROPERTY_DOCUMENTTYPEFORORDER, documentTypeForOrder);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Reconciliation_v> getAPRMReconciliationList() {
      return (List<APRM_Reconciliation_v>) get(PROPERTY_APRMRECONCILIATIONLIST);
    }

    public void setAPRMReconciliationList(List<APRM_Reconciliation_v> aPRMReconciliationList) {
        set(PROPERTY_APRMRECONCILIATIONLIST, aPRMReconciliationList);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustment> getCostAdjustmentList() {
      return (List<CostAdjustment>) get(PROPERTY_COSTADJUSTMENTLIST);
    }

    public void setCostAdjustmentList(List<CostAdjustment> costAdjustmentList) {
        set(PROPERTY_COSTADJUSTMENTLIST, costAdjustmentList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTemplate> getDocumentTemplateList() {
      return (List<DocumentTemplate>) get(PROPERTY_DOCUMENTTEMPLATELIST);
    }

    public void setDocumentTemplateList(List<DocumentTemplate> documentTemplateList) {
        set(PROPERTY_DOCUMENTTEMPLATELIST, documentTemplateList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForShipmentList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST);
    }

    public void setDocumentTypeDocumentTypeForShipmentList(List<DocumentType> documentTypeDocumentTypeForShipmentList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST, documentTypeDocumentTypeForShipmentList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForInvoiceList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST);
    }

    public void setDocumentTypeDocumentTypeForInvoiceList(List<DocumentType> documentTypeDocumentTypeForInvoiceList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST, documentTypeDocumentTypeForInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentCancelledList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST);
    }

    public void setDocumentTypeDocumentCancelledList(List<DocumentType> documentTypeDocumentCancelledList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST, documentTypeDocumentCancelledList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForOrderList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST);
    }

    public void setDocumentTypeDocumentTypeForOrderList(List<DocumentType> documentTypeDocumentTypeForOrderList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST, documentTypeDocumentTypeForOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTypeTrl> getDocumentTypeTrlList() {
      return (List<DocumentTypeTrl>) get(PROPERTY_DOCUMENTTYPETRLLIST);
    }

    public void setDocumentTypeTrlList(List<DocumentTypeTrl> documentTypeTrlList) {
        set(PROPERTY_DOCUMENTTYPETRLLIST, documentTypeTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOS> getExternalPOSList() {
      return (List<ExternalPOS>) get(PROPERTY_EXTERNALPOSLIST);
    }

    public void setExternalPOSList(List<ExternalPOS> externalPOSList) {
        set(PROPERTY_EXTERNALPOSLIST, externalPOSList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatement> getFINBankStatementList() {
      return (List<FIN_BankStatement>) get(PROPERTY_FINBANKSTATEMENTLIST);
    }

    public void setFINBankStatementList(List<FIN_BankStatement> fINBankStatementList) {
        set(PROPERTY_FINBANKSTATEMENTLIST, fINBankStatementList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALLIST);
    }

    public void setFINPaymentProposalList(List<FIN_PaymentProposal> fINPaymentProposalList) {
        set(PROPERTY_FINPAYMENTPROPOSALLIST, fINPaymentProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Reconciliation> getFINReconciliationList() {
      return (List<FIN_Reconciliation>) get(PROPERTY_FINRECONCILIATIONLIST);
    }

    public void setFINReconciliationList(List<FIN_Reconciliation> fINReconciliationList) {
        set(PROPERTY_FINRECONCILIATIONLIST, fINReconciliationList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<DPManagement> getFinancialMgmtDPManagementList() {
      return (List<DPManagement>) get(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST);
    }

    public void setFinancialMgmtDPManagementList(List<DPManagement> financialMgmtDPManagementList) {
        set(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, financialMgmtDPManagementList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<Settlement> getFinancialMgmtSettlementList() {
      return (List<Settlement>) get(PROPERTY_FINANCIALMGMTSETTLEMENTLIST);
    }

    public void setFinancialMgmtSettlementList(List<Settlement> financialMgmtSettlementList) {
        set(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, financialMgmtSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegisterTypeLines> getFinancialMgmtTaxRegisterTypeLinesList() {
      return (List<TaxRegisterTypeLines>) get(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST);
    }

    public void setFinancialMgmtTaxRegisterTypeLinesList(List<TaxRegisterTypeLines> financialMgmtTaxRegisterTypeLinesList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST, financialMgmtTaxRegisterTypeLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryAmountUpdate> getInventoryAmountUpdateList() {
      return (List<InventoryAmountUpdate>) get(PROPERTY_INVENTORYAMOUNTUPDATELIST);
    }

    public void setInventoryAmountUpdateList(List<InventoryAmountUpdate> inventoryAmountUpdateList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELIST, inventoryAmountUpdateList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceTransactionDocumentList() {
      return (List<Invoice>) get(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST);
    }

    public void setInvoiceTransactionDocumentList(List<Invoice> invoiceTransactionDocumentList) {
        set(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST, invoiceTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2TransactionDocumentList() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST);
    }

    public void setInvoiceV2TransactionDocumentList(List<InvoiceV2> invoiceV2TransactionDocumentList) {
        set(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST, invoiceV2TransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCost> getLandedCostList() {
      return (List<LandedCost>) get(PROPERTY_LANDEDCOSTLIST);
    }

    public void setLandedCostList(List<LandedCost> landedCostList) {
        set(PROPERTY_LANDEDCOSTLIST, landedCostList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostCost> getLandedCostCostList() {
      return (List<LandedCostCost>) get(PROPERTY_LANDEDCOSTCOSTLIST);
    }

    public void setLandedCostCostList(List<LandedCostCost> landedCostCostList) {
        set(PROPERTY_LANDEDCOSTCOSTLIST, landedCostCostList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirement> getManufacturingWorkRequirementList() {
      return (List<WorkRequirement>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST);
    }

    public void setManufacturingWorkRequirementList(List<WorkRequirement> manufacturingWorkRequirementList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST, manufacturingWorkRequirementList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderTransactionDocumentList() {
      return (List<Order>) get(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST);
    }

    public void setOrderTransactionDocumentList(List<Order> orderTransactionDocumentList) {
        set(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST, orderTransactionDocumentList);
    }

}
