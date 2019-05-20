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
package org.openbravo.model.common.order;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Virtual entity class to hold computed columns for entity Order.
 *
 * NOTE: This class should not be instantiated directly.
 */
public class Order_ComputedColumns extends BaseOBObject implements ClientEnabled , OrganizationEnabled {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Order_ComputedColumns";
    
    public static final String PROPERTY_DELIVERYSTATUS = "deliveryStatus";
    public static final String PROPERTY_INVOICESTATUS = "invoiceStatus";
    public static final String PROPERTY_PAYMENTSTATUS = "paymentStatus";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Long getDeliveryStatus() {
      return (Long) get(PROPERTY_DELIVERYSTATUS);
    }

    public void setDeliveryStatus(Long deliveryStatus) {
      set(PROPERTY_DELIVERYSTATUS, deliveryStatus);
    }
    public Long getInvoiceStatus() {
      return (Long) get(PROPERTY_INVOICESTATUS);
    }

    public void setInvoiceStatus(Long invoiceStatus) {
      set(PROPERTY_INVOICESTATUS, invoiceStatus);
    }
    public Long getPaymentStatus() {
      return (Long) get(PROPERTY_PAYMENTSTATUS);
    }

    public void setPaymentStatus(Long paymentStatus) {
      set(PROPERTY_PAYMENTSTATUS, paymentStatus);
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
