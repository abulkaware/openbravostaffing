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
package org.openbravo.model.common.invoice;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.tax.TaxRate;
/**
 * Entity class for entity C_InvoiceTax_CashVAT_V (stored in table C_InvoiceTax_CashVAT_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceTaxCashVAT_V extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_InvoiceTax_CashVAT_V";
    public static final String ENTITY_NAME = "C_InvoiceTax_CashVAT_V";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_PERCENTAGE = "percentage";
    public static final String PROPERTY_TAXAMOUNT = "taxAmount";
    public static final String PROPERTY_TAXABLEAMOUNT = "taxableAmount";
    public static final String PROPERTY_CANCELED = "canceled";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_PAYMENTDETAILS = "paymentDetails";
    public static final String PROPERTY_RECEIPT = "receipt";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_INVOICETAX = "invoiceTax";
    public static final String PROPERTY_ISMANUALSETTLEMENT = "isManualSettlement";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_ISPREPAYMENT = "isPrepayment";

    public InvoiceTaxCashVAT_V() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CANCELED, false);
        setDefaultValue(PROPERTY_RECEIPT, false);
        setDefaultValue(PROPERTY_ISMANUALSETTLEMENT, false);
        setDefaultValue(PROPERTY_ISPREPAYMENT, false);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public BigDecimal getPercentage() {
        return (BigDecimal) get(PROPERTY_PERCENTAGE);
    }

    public void setPercentage(BigDecimal percentage) {
        set(PROPERTY_PERCENTAGE, percentage);
    }

    public BigDecimal getTaxAmount() {
        return (BigDecimal) get(PROPERTY_TAXAMOUNT);
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        set(PROPERTY_TAXAMOUNT, taxAmount);
    }

    public BigDecimal getTaxableAmount() {
        return (BigDecimal) get(PROPERTY_TAXABLEAMOUNT);
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        set(PROPERTY_TAXABLEAMOUNT, taxableAmount);
    }

    public Boolean isCanceled() {
        return (Boolean) get(PROPERTY_CANCELED);
    }

    public void setCanceled(Boolean canceled) {
        set(PROPERTY_CANCELED, canceled);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public FIN_PaymentDetail getPaymentDetails() {
        return (FIN_PaymentDetail) get(PROPERTY_PAYMENTDETAILS);
    }

    public void setPaymentDetails(FIN_PaymentDetail paymentDetails) {
        set(PROPERTY_PAYMENTDETAILS, paymentDetails);
    }

    public Boolean isReceipt() {
        return (Boolean) get(PROPERTY_RECEIPT);
    }

    public void setReceipt(Boolean receipt) {
        set(PROPERTY_RECEIPT, receipt);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public InvoiceTax getInvoiceTax() {
        return (InvoiceTax) get(PROPERTY_INVOICETAX);
    }

    public void setInvoiceTax(InvoiceTax invoiceTax) {
        set(PROPERTY_INVOICETAX, invoiceTax);
    }

    public Boolean isManualSettlement() {
        return (Boolean) get(PROPERTY_ISMANUALSETTLEMENT);
    }

    public void setManualSettlement(Boolean isManualSettlement) {
        set(PROPERTY_ISMANUALSETTLEMENT, isManualSettlement);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Boolean isPrepayment() {
        return (Boolean) get(PROPERTY_ISPREPAYMENT);
    }

    public void setPrepayment(Boolean isPrepayment) {
        set(PROPERTY_ISPREPAYMENT, isPrepayment);
    }

}
