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
package org.openbravo.model.materialmgmt.cost;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.materialmgmt.transaction.MaterialTransaction;
/**
 * Entity class for entity CostAdjustmentLine (stored in table M_CostAdjustmentLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CostAdjustmentLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_CostAdjustmentLine";
    public static final String ENTITY_NAME = "CostAdjustmentLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COSTADJUSTMENT = "costAdjustment";
    public static final String PROPERTY_INVENTORYTRANSACTION = "inventoryTransaction";
    public static final String PROPERTY_ADJUSTMENTAMOUNT = "adjustmentAmount";
    public static final String PROPERTY_ISSOURCE = "isSource";
    public static final String PROPERTY_NEEDSPOSTING = "needsPosting";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_ISRELATEDTRANSACTIONADJUSTED = "isRelatedTransactionAdjusted";
    public static final String PROPERTY_PARENTCOSTADJUSTMENTLINE = "parentCostAdjustmentLine";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_UNITCOST = "unitCost";
    public static final String PROPERTY_ISBACKDATEDTRX = "isBackdatedTrx";
    public static final String PROPERTY_ISNEGATIVESTOCKCORRECTION = "isNegativeStockCorrection";
    public static final String PROPERTY_COSTADJUSTMENTLINEPARENTCOSTADJUSTMENTLINELIST = "costAdjustmentLineParentCostAdjustmentLineList";
    public static final String PROPERTY_TRANSACTIONCOSTLIST = "transactionCostList";

    public CostAdjustmentLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_ISSOURCE, false);
        setDefaultValue(PROPERTY_NEEDSPOSTING, true);
        setDefaultValue(PROPERTY_ISRELATEDTRANSACTIONADJUSTED, false);
        setDefaultValue(PROPERTY_UNITCOST, true);
        setDefaultValue(PROPERTY_ISBACKDATEDTRX, false);
        setDefaultValue(PROPERTY_ISNEGATIVESTOCKCORRECTION, false);
        setDefaultValue(PROPERTY_COSTADJUSTMENTLINEPARENTCOSTADJUSTMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONCOSTLIST, new ArrayList<Object>());
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

    public CostAdjustment getCostAdjustment() {
        return (CostAdjustment) get(PROPERTY_COSTADJUSTMENT);
    }

    public void setCostAdjustment(CostAdjustment costAdjustment) {
        set(PROPERTY_COSTADJUSTMENT, costAdjustment);
    }

    public MaterialTransaction getInventoryTransaction() {
        return (MaterialTransaction) get(PROPERTY_INVENTORYTRANSACTION);
    }

    public void setInventoryTransaction(MaterialTransaction inventoryTransaction) {
        set(PROPERTY_INVENTORYTRANSACTION, inventoryTransaction);
    }

    public BigDecimal getAdjustmentAmount() {
        return (BigDecimal) get(PROPERTY_ADJUSTMENTAMOUNT);
    }

    public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
        set(PROPERTY_ADJUSTMENTAMOUNT, adjustmentAmount);
    }

    public Boolean isSource() {
        return (Boolean) get(PROPERTY_ISSOURCE);
    }

    public void setSource(Boolean isSource) {
        set(PROPERTY_ISSOURCE, isSource);
    }

    public Boolean isNeedsPosting() {
        return (Boolean) get(PROPERTY_NEEDSPOSTING);
    }

    public void setNeedsPosting(Boolean needsPosting) {
        set(PROPERTY_NEEDSPOSTING, needsPosting);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public Boolean isRelatedTransactionAdjusted() {
        return (Boolean) get(PROPERTY_ISRELATEDTRANSACTIONADJUSTED);
    }

    public void setRelatedTransactionAdjusted(Boolean isRelatedTransactionAdjusted) {
        set(PROPERTY_ISRELATEDTRANSACTIONADJUSTED, isRelatedTransactionAdjusted);
    }

    public CostAdjustmentLine getParentCostAdjustmentLine() {
        return (CostAdjustmentLine) get(PROPERTY_PARENTCOSTADJUSTMENTLINE);
    }

    public void setParentCostAdjustmentLine(CostAdjustmentLine parentCostAdjustmentLine) {
        set(PROPERTY_PARENTCOSTADJUSTMENTLINE, parentCostAdjustmentLine);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Boolean isUnitCost() {
        return (Boolean) get(PROPERTY_UNITCOST);
    }

    public void setUnitCost(Boolean unitCost) {
        set(PROPERTY_UNITCOST, unitCost);
    }

    public Boolean isBackdatedTrx() {
        return (Boolean) get(PROPERTY_ISBACKDATEDTRX);
    }

    public void setBackdatedTrx(Boolean isBackdatedTrx) {
        set(PROPERTY_ISBACKDATEDTRX, isBackdatedTrx);
    }

    public Boolean isNegativeStockCorrection() {
        return (Boolean) get(PROPERTY_ISNEGATIVESTOCKCORRECTION);
    }

    public void setNegativeStockCorrection(Boolean isNegativeStockCorrection) {
        set(PROPERTY_ISNEGATIVESTOCKCORRECTION, isNegativeStockCorrection);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustmentLine> getCostAdjustmentLineParentCostAdjustmentLineList() {
      return (List<CostAdjustmentLine>) get(PROPERTY_COSTADJUSTMENTLINEPARENTCOSTADJUSTMENTLINELIST);
    }

    public void setCostAdjustmentLineParentCostAdjustmentLineList(List<CostAdjustmentLine> costAdjustmentLineParentCostAdjustmentLineList) {
        set(PROPERTY_COSTADJUSTMENTLINEPARENTCOSTADJUSTMENTLINELIST, costAdjustmentLineParentCostAdjustmentLineList);
    }

    @SuppressWarnings("unchecked")
    public List<TransactionCost> getTransactionCostList() {
      return (List<TransactionCost>) get(PROPERTY_TRANSACTIONCOSTLIST);
    }

    public void setTransactionCostList(List<TransactionCost> transactionCostList) {
        set(PROPERTY_TRANSACTIONCOSTLIST, transactionCostList);
    }

}
