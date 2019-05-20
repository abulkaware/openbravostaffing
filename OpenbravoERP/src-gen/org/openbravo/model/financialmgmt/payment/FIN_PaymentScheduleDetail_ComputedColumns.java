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
 * All portions are Copyright (C) 2013-2017 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.financialmgmt.payment;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Virtual entity class to hold computed columns for entity FIN_Payment_ScheduleDetail.
 *
 * NOTE: This class should not be instantiated directly.
 */
public class FIN_PaymentScheduleDetail_ComputedColumns extends BaseOBObject implements ClientEnabled , OrganizationEnabled {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "FIN_PaymentScheduleDetail_ComputedColumns";
    
    public static final String PROPERTY_DUEDATE = "dueDate";
    public static final String PROPERTY_APRMFINANCIALACCOUNT = "aPRMFinancialAccount";
    public static final String PROPERTY_APRMPAYMENTMETHOD = "aPRMPaymentMethod";
    public static final String PROPERTY_EXPECTED = "expected";
    public static final String PROPERTY_INVOICEAMOUNT = "invoiceAmount";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Date getDueDate() {
      return (Date) get(PROPERTY_DUEDATE);
    }

    public void setDueDate(Date dueDate) {
      set(PROPERTY_DUEDATE, dueDate);
    }
    public FIN_FinancialAccount getAPRMFinancialAccount() {
      return (FIN_FinancialAccount) get(PROPERTY_APRMFINANCIALACCOUNT);
    }

    public void setAPRMFinancialAccount(FIN_FinancialAccount aPRMFinancialAccount) {
      set(PROPERTY_APRMFINANCIALACCOUNT, aPRMFinancialAccount);
    }
    public FIN_PaymentMethod getAPRMPaymentMethod() {
      return (FIN_PaymentMethod) get(PROPERTY_APRMPAYMENTMETHOD);
    }

    public void setAPRMPaymentMethod(FIN_PaymentMethod aPRMPaymentMethod) {
      set(PROPERTY_APRMPAYMENTMETHOD, aPRMPaymentMethod);
    }
    public BigDecimal getExpected() {
      return (BigDecimal) get(PROPERTY_EXPECTED);
    }

    public void setExpected(BigDecimal expected) {
      set(PROPERTY_EXPECTED, expected);
    }
    public BigDecimal getInvoiceAmount() {
      return (BigDecimal) get(PROPERTY_INVOICEAMOUNT);
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
      set(PROPERTY_INVOICEAMOUNT, invoiceAmount);
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
}
