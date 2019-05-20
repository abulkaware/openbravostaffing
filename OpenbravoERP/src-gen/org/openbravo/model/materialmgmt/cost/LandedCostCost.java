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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
/**
 * Entity class for entity LandedCostCost (stored in table M_LC_Cost).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class LandedCostCost extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_LC_Cost";
    public static final String ENTITY_NAME = "LandedCostCost";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LANDEDCOST = "landedCost";
    public static final String PROPERTY_GOODSSHIPMENT = "goodsShipment";
    public static final String PROPERTY_LANDEDCOSTTYPE = "landedCostType";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_LANDEDCOSTDISTRIBUTIONALGORITHM = "landedCostDistributionAlgorithm";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_MATCHED = "matched";
    public static final String PROPERTY_ISMATCHINGADJUSTED = "isMatchingAdjusted";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_CANCELMATCHING = "cancelMatching";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_MATCHINGCOSTADJUSTMENT = "matchingCostAdjustment";
    public static final String PROPERTY_PROCESSMATCHING = "processMatching";
    public static final String PROPERTY_MATCHINGAMOUNT = "matchingAmount";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_LANDEDCOSTMATCHEDLIST = "landedCostMatchedList";
    public static final String PROPERTY_LANDEDCOSTRECEIPTLINEAMTLIST = "landedCostReceiptLineAmtList";

    public LandedCostCost() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_MATCHED, false);
        setDefaultValue(PROPERTY_ISMATCHINGADJUSTED, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_CANCELMATCHING, false);
        setDefaultValue(PROPERTY_PROCESSMATCHING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_LANDEDCOSTMATCHEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTRECEIPTLINEAMTLIST, new ArrayList<Object>());
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

    public LandedCost getLandedCost() {
        return (LandedCost) get(PROPERTY_LANDEDCOST);
    }

    public void setLandedCost(LandedCost landedCost) {
        set(PROPERTY_LANDEDCOST, landedCost);
    }

    public ShipmentInOut getGoodsShipment() {
        return (ShipmentInOut) get(PROPERTY_GOODSSHIPMENT);
    }

    public void setGoodsShipment(ShipmentInOut goodsShipment) {
        set(PROPERTY_GOODSSHIPMENT, goodsShipment);
    }

    public LandedCostType getLandedCostType() {
        return (LandedCostType) get(PROPERTY_LANDEDCOSTTYPE);
    }

    public void setLandedCostType(LandedCostType landedCostType) {
        set(PROPERTY_LANDEDCOSTTYPE, landedCostType);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public LCDistributionAlgorithm getLandedCostDistributionAlgorithm() {
        return (LCDistributionAlgorithm) get(PROPERTY_LANDEDCOSTDISTRIBUTIONALGORITHM);
    }

    public void setLandedCostDistributionAlgorithm(LCDistributionAlgorithm landedCostDistributionAlgorithm) {
        set(PROPERTY_LANDEDCOSTDISTRIBUTIONALGORITHM, landedCostDistributionAlgorithm);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Boolean isMatched() {
        return (Boolean) get(PROPERTY_MATCHED);
    }

    public void setMatched(Boolean matched) {
        set(PROPERTY_MATCHED, matched);
    }

    public Boolean isMatchingAdjusted() {
        return (Boolean) get(PROPERTY_ISMATCHINGADJUSTED);
    }

    public void setMatchingAdjusted(Boolean isMatchingAdjusted) {
        set(PROPERTY_ISMATCHINGADJUSTED, isMatchingAdjusted);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public Boolean isCancelMatching() {
        return (Boolean) get(PROPERTY_CANCELMATCHING);
    }

    public void setCancelMatching(Boolean cancelMatching) {
        set(PROPERTY_CANCELMATCHING, cancelMatching);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public CostAdjustment getMatchingCostAdjustment() {
        return (CostAdjustment) get(PROPERTY_MATCHINGCOSTADJUSTMENT);
    }

    public void setMatchingCostAdjustment(CostAdjustment matchingCostAdjustment) {
        set(PROPERTY_MATCHINGCOSTADJUSTMENT, matchingCostAdjustment);
    }

    public Boolean isProcessMatching() {
        return (Boolean) get(PROPERTY_PROCESSMATCHING);
    }

    public void setProcessMatching(Boolean processMatching) {
        set(PROPERTY_PROCESSMATCHING, processMatching);
    }

    public BigDecimal getMatchingAmount() {
        return (BigDecimal) get(PROPERTY_MATCHINGAMOUNT);
    }

    public void setMatchingAmount(BigDecimal matchingAmount) {
        set(PROPERTY_MATCHINGAMOUNT, matchingAmount);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    @SuppressWarnings("unchecked")
    public List<LCMatched> getLandedCostMatchedList() {
      return (List<LCMatched>) get(PROPERTY_LANDEDCOSTMATCHEDLIST);
    }

    public void setLandedCostMatchedList(List<LCMatched> landedCostMatchedList) {
        set(PROPERTY_LANDEDCOSTMATCHEDLIST, landedCostMatchedList);
    }

    @SuppressWarnings("unchecked")
    public List<LCReceiptLineAmt> getLandedCostReceiptLineAmtList() {
      return (List<LCReceiptLineAmt>) get(PROPERTY_LANDEDCOSTRECEIPTLINEAMTLIST);
    }

    public void setLandedCostReceiptLineAmtList(List<LCReceiptLineAmt> landedCostReceiptLineAmtList) {
        set(PROPERTY_LANDEDCOSTRECEIPTLINEAMTLIST, landedCostReceiptLineAmtList);
    }

}
