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
 * Virtual entity class to hold computed columns for entity FIN_Financial_Account.
 *
 * NOTE: This class should not be instantiated directly.
 */
public class FIN_FinancialAccount_ComputedColumns extends BaseOBObject implements ClientEnabled , OrganizationEnabled {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "FIN_FinancialAccount_ComputedColumns";
    
    public static final String PROPERTY_LASTRECONBALANCE = "lastreconbalance";
    public static final String PROPERTY_LASTRECONCILIATION = "lastreconciliation";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public BigDecimal getLastreconbalance() {
      return (BigDecimal) get(PROPERTY_LASTRECONBALANCE);
    }

    public void setLastreconbalance(BigDecimal lastreconbalance) {
      set(PROPERTY_LASTRECONBALANCE, lastreconbalance);
    }
    public Date getLastreconciliation() {
      return (Date) get(PROPERTY_LASTRECONCILIATION);
    }

    public void setLastreconciliation(Date lastreconciliation) {
      set(PROPERTY_LASTRECONCILIATION, lastreconciliation);
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
