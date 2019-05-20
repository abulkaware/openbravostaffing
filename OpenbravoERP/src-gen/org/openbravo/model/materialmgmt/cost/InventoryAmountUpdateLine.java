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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
/**
 * Entity class for entity InventoryAmountUpdateLine (stored in table M_CA_InventoryAmtLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InventoryAmountUpdateLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_CA_InventoryAmtLine";
    public static final String ENTITY_NAME = "InventoryAmountUpdateLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REFERENCEDATE = "referenceDate";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_INVENTORYAMOUNT = "inventoryAmount";
    public static final String PROPERTY_CURRENTINVENTORYAMOUNT = "currentInventoryAmount";
    public static final String PROPERTY_ONHANDQTY = "onHandQty";
    public static final String PROPERTY_UNITCOST = "unitCost";
    public static final String PROPERTY_CURRENTUNITCOST = "currentUnitCost";
    public static final String PROPERTY_CAINVENTORYAMT = "caInventoryamt";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST = "inventoryAmountUpdateLineInventoriesList";

    public InventoryAmountUpdateLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ONHANDQTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST, new ArrayList<Object>());
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

    public Date getReferenceDate() {
        return (Date) get(PROPERTY_REFERENCEDATE);
    }

    public void setReferenceDate(Date referenceDate) {
        set(PROPERTY_REFERENCEDATE, referenceDate);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public BigDecimal getInventoryAmount() {
        return (BigDecimal) get(PROPERTY_INVENTORYAMOUNT);
    }

    public void setInventoryAmount(BigDecimal inventoryAmount) {
        set(PROPERTY_INVENTORYAMOUNT, inventoryAmount);
    }

    public BigDecimal getCurrentInventoryAmount() {
        return (BigDecimal) get(PROPERTY_CURRENTINVENTORYAMOUNT);
    }

    public void setCurrentInventoryAmount(BigDecimal currentInventoryAmount) {
        set(PROPERTY_CURRENTINVENTORYAMOUNT, currentInventoryAmount);
    }

    public BigDecimal getOnHandQty() {
        return (BigDecimal) get(PROPERTY_ONHANDQTY);
    }

    public void setOnHandQty(BigDecimal onHandQty) {
        set(PROPERTY_ONHANDQTY, onHandQty);
    }

    public BigDecimal getUnitCost() {
        return (BigDecimal) get(PROPERTY_UNITCOST);
    }

    public void setUnitCost(BigDecimal unitCost) {
        set(PROPERTY_UNITCOST, unitCost);
    }

    public BigDecimal getCurrentUnitCost() {
        return (BigDecimal) get(PROPERTY_CURRENTUNITCOST);
    }

    public void setCurrentUnitCost(BigDecimal currentUnitCost) {
        set(PROPERTY_CURRENTUNITCOST, currentUnitCost);
    }

    public InventoryAmountUpdate getCaInventoryamt() {
        return (InventoryAmountUpdate) get(PROPERTY_CAINVENTORYAMT);
    }

    public void setCaInventoryamt(InventoryAmountUpdate caInventoryamt) {
        set(PROPERTY_CAINVENTORYAMT, caInventoryamt);
    }

    @SuppressWarnings("unchecked")
    public List<InvAmtUpdLnInventories> getInventoryAmountUpdateLineInventoriesList() {
      return (List<InvAmtUpdLnInventories>) get(PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST);
    }

    public void setInventoryAmountUpdateLineInventoriesList(List<InvAmtUpdLnInventories> inventoryAmountUpdateLineInventoriesList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST, inventoryAmountUpdateLineInventoriesList);
    }

}
