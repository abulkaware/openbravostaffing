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

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Virtual entity class to hold computed columns for entity FIN_Reconciliation.
 *
 * NOTE: This class should not be instantiated directly.
 */
public class FIN_Reconciliation_ComputedColumns extends BaseOBObject implements ClientEnabled , OrganizationEnabled {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "FIN_Reconciliation_ComputedColumns";
    
    public static final String PROPERTY_APRMOUTSTANDINGDEPOSITITEMSAMOUNT = "aPRMOutstandingDepositItemsAmount";
    public static final String PROPERTY_APRMOUTSTANDINGDEPOSITSITEMNO = "aPRMOutstandingDepositsItemNo";
    public static final String PROPERTY_APRMOUTSTANDINGPAYMENTSITEMNO = "aPRMOutstandingPaymentsItemNo";
    public static final String PROPERTY_APRMOUTSTANDINGPAYMENTSITEMSAMOUNT = "aPRMOutstandingPaymentsItemsAmount";
    public static final String PROPERTY_APRMRECONCILEDITEMAMOUNT = "aPRMReconciledItemAmount";
    public static final String PROPERTY_APRMRECONCILEDITEMNO = "aPRMReconciledItemNo";
    public static final String PROPERTY_APRMUNRECONCILEDITEMAMOUNT = "aPRMUnReconciledItemAmount";
    public static final String PROPERTY_APRMUNRECONCILEDITEMNO = "aPRMUnReconciledItemNo";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public BigDecimal getAPRMOutstandingDepositItemsAmount() {
      return (BigDecimal) get(PROPERTY_APRMOUTSTANDINGDEPOSITITEMSAMOUNT);
    }

    public void setAPRMOutstandingDepositItemsAmount(BigDecimal aPRMOutstandingDepositItemsAmount) {
      set(PROPERTY_APRMOUTSTANDINGDEPOSITITEMSAMOUNT, aPRMOutstandingDepositItemsAmount);
    }
    public Long getAPRMOutstandingDepositsItemNo() {
      return (Long) get(PROPERTY_APRMOUTSTANDINGDEPOSITSITEMNO);
    }

    public void setAPRMOutstandingDepositsItemNo(Long aPRMOutstandingDepositsItemNo) {
      set(PROPERTY_APRMOUTSTANDINGDEPOSITSITEMNO, aPRMOutstandingDepositsItemNo);
    }
    public Long getAPRMOutstandingPaymentsItemNo() {
      return (Long) get(PROPERTY_APRMOUTSTANDINGPAYMENTSITEMNO);
    }

    public void setAPRMOutstandingPaymentsItemNo(Long aPRMOutstandingPaymentsItemNo) {
      set(PROPERTY_APRMOUTSTANDINGPAYMENTSITEMNO, aPRMOutstandingPaymentsItemNo);
    }
    public BigDecimal getAPRMOutstandingPaymentsItemsAmount() {
      return (BigDecimal) get(PROPERTY_APRMOUTSTANDINGPAYMENTSITEMSAMOUNT);
    }

    public void setAPRMOutstandingPaymentsItemsAmount(BigDecimal aPRMOutstandingPaymentsItemsAmount) {
      set(PROPERTY_APRMOUTSTANDINGPAYMENTSITEMSAMOUNT, aPRMOutstandingPaymentsItemsAmount);
    }
    public BigDecimal getAPRMReconciledItemAmount() {
      return (BigDecimal) get(PROPERTY_APRMRECONCILEDITEMAMOUNT);
    }

    public void setAPRMReconciledItemAmount(BigDecimal aPRMReconciledItemAmount) {
      set(PROPERTY_APRMRECONCILEDITEMAMOUNT, aPRMReconciledItemAmount);
    }
    public Long getAPRMReconciledItemNo() {
      return (Long) get(PROPERTY_APRMRECONCILEDITEMNO);
    }

    public void setAPRMReconciledItemNo(Long aPRMReconciledItemNo) {
      set(PROPERTY_APRMRECONCILEDITEMNO, aPRMReconciledItemNo);
    }
    public BigDecimal getAPRMUnReconciledItemAmount() {
      return (BigDecimal) get(PROPERTY_APRMUNRECONCILEDITEMAMOUNT);
    }

    public void setAPRMUnReconciledItemAmount(BigDecimal aPRMUnReconciledItemAmount) {
      set(PROPERTY_APRMUNRECONCILEDITEMAMOUNT, aPRMUnReconciledItemAmount);
    }
    public Long getAPRMUnReconciledItemNo() {
      return (Long) get(PROPERTY_APRMUNRECONCILEDITEMNO);
    }

    public void setAPRMUnReconciledItemNo(Long aPRMUnReconciledItemNo) {
      set(PROPERTY_APRMUNRECONCILEDITEMNO, aPRMUnReconciledItemNo);
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
