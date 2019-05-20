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
package org.openbravo.model.materialmgmt.transaction;

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
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
/**
 * Entity class for entity ReturnMaterialShipmentPickEdit (stored in table M_RM_Shipment_Pick_Edit).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ReturnMaterialShipmentPickEdit extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_RM_Shipment_Pick_Edit";
    public static final String ENTITY_NAME = "ReturnMaterialShipmentPickEdit";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_RMORDERNO = "rMOrderNo";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_RETURNED = "returned";
    public static final String PROPERTY_MOVEMENTQUANTITY = "movementQuantity";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_AVAILABLEQTY = "availableQty";
    public static final String PROPERTY_PENDING = "pending";
    public static final String PROPERTY_GOODSSHIPMENT = "goodsShipment";
    public static final String PROPERTY_OBSELECTED = "obSelected";
    public static final String PROPERTY_ORDERLINE = "orderLine";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_GOODSSHIPMENTLINE = "goodsShipmentLine";
    public static final String PROPERTY_STOCKED = "stocked";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_ALTERNATIVEUOM = "alternativeUOM";
    public static final String PROPERTY_LOCATORORG = "locatorOrg";
    public static final String PROPERTY_QUANTITYINALTERNATIVEUOM = "quantityInAlternativeUOM";
    public static final String PROPERTY_RETURNEDUOM = "returnedUOM";
    public static final String PROPERTY_PENDINGQTYINAUM = "pendingQtyInAUM";
    public static final String PROPERTY_AVAILABLEQTYINAUM = "availableQtyInAUM";
    public static final String PROPERTY_RATE = "rate";

    public ReturnMaterialShipmentPickEdit() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_OBSELECTED, false);
        setDefaultValue(PROPERTY_STOCKED, false);
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

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public String getRMOrderNo() {
        return (String) get(PROPERTY_RMORDERNO);
    }

    public void setRMOrderNo(String rMOrderNo) {
        set(PROPERTY_RMORDERNO, rMOrderNo);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getReturned() {
        return (BigDecimal) get(PROPERTY_RETURNED);
    }

    public void setReturned(BigDecimal returned) {
        set(PROPERTY_RETURNED, returned);
    }

    public BigDecimal getMovementQuantity() {
        return (BigDecimal) get(PROPERTY_MOVEMENTQUANTITY);
    }

    public void setMovementQuantity(BigDecimal movementQuantity) {
        set(PROPERTY_MOVEMENTQUANTITY, movementQuantity);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public BigDecimal getAvailableQty() {
        return (BigDecimal) get(PROPERTY_AVAILABLEQTY);
    }

    public void setAvailableQty(BigDecimal availableQty) {
        set(PROPERTY_AVAILABLEQTY, availableQty);
    }

    public BigDecimal getPending() {
        return (BigDecimal) get(PROPERTY_PENDING);
    }

    public void setPending(BigDecimal pending) {
        set(PROPERTY_PENDING, pending);
    }

    public ShipmentInOut getGoodsShipment() {
        return (ShipmentInOut) get(PROPERTY_GOODSSHIPMENT);
    }

    public void setGoodsShipment(ShipmentInOut goodsShipment) {
        set(PROPERTY_GOODSSHIPMENT, goodsShipment);
    }

    public Boolean isObSelected() {
        return (Boolean) get(PROPERTY_OBSELECTED);
    }

    public void setObSelected(Boolean obSelected) {
        set(PROPERTY_OBSELECTED, obSelected);
    }

    public OrderLine getOrderLine() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(OrderLine orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public ShipmentInOutLine getGoodsShipmentLine() {
        return (ShipmentInOutLine) get(PROPERTY_GOODSSHIPMENTLINE);
    }

    public void setGoodsShipmentLine(ShipmentInOutLine goodsShipmentLine) {
        set(PROPERTY_GOODSSHIPMENTLINE, goodsShipmentLine);
    }

    public Boolean isStocked() {
        return (Boolean) get(PROPERTY_STOCKED);
    }

    public void setStocked(Boolean stocked) {
        set(PROPERTY_STOCKED, stocked);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public UOM getAlternativeUOM() {
        return (UOM) get(PROPERTY_ALTERNATIVEUOM);
    }

    public void setAlternativeUOM(UOM alternativeUOM) {
        set(PROPERTY_ALTERNATIVEUOM, alternativeUOM);
    }

    public Organization getLocatorOrg() {
        return (Organization) get(PROPERTY_LOCATORORG);
    }

    public void setLocatorOrg(Organization locatorOrg) {
        set(PROPERTY_LOCATORORG, locatorOrg);
    }

    public BigDecimal getQuantityInAlternativeUOM() {
        return (BigDecimal) get(PROPERTY_QUANTITYINALTERNATIVEUOM);
    }

    public void setQuantityInAlternativeUOM(BigDecimal quantityInAlternativeUOM) {
        set(PROPERTY_QUANTITYINALTERNATIVEUOM, quantityInAlternativeUOM);
    }

    public UOM getReturnedUOM() {
        return (UOM) get(PROPERTY_RETURNEDUOM);
    }

    public void setReturnedUOM(UOM returnedUOM) {
        set(PROPERTY_RETURNEDUOM, returnedUOM);
    }

    public BigDecimal getPendingQtyInAUM() {
        return (BigDecimal) get(PROPERTY_PENDINGQTYINAUM);
    }

    public void setPendingQtyInAUM(BigDecimal pendingQtyInAUM) {
        set(PROPERTY_PENDINGQTYINAUM, pendingQtyInAUM);
    }

    public BigDecimal getAvailableQtyInAUM() {
        return (BigDecimal) get(PROPERTY_AVAILABLEQTYINAUM);
    }

    public void setAvailableQtyInAUM(BigDecimal availableQtyInAUM) {
        set(PROPERTY_AVAILABLEQTYINAUM, availableQtyInAUM);
    }

    public BigDecimal getRate() {
        return (BigDecimal) get(PROPERTY_RATE);
    }

    public void setRate(BigDecimal rate) {
        set(PROPERTY_RATE, rate);
    }

}
