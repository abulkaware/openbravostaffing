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
package org.openbravo.client.widgets;

import java.math.BigDecimal;
import java.util.Date;

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
import org.openbravo.model.common.plm.ProductCategory;
/**
 * Entity class for entity OBWCL_StockByWarehouseView (stored in table OBWCL_Stock_By_Warehouse_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OBWCL_StockByWarehouseView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "OBWCL_Stock_By_Warehouse_V";
    public static final String ENTITY_NAME = "OBWCL_StockByWarehouseView";
    public static final String PROPERTY_ORGNAME = "orgname";
    public static final String PROPERTY_WAREHOUSENAME = "warehouseName";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_PRODUCTNAME = "productName";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTCATEGORYNAME = "productCategoryName";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_UOMNAME = "uOMName";
    public static final String PROPERTY_QUANTITYONHAND = "quantityOnHand";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";

    public OBWCL_StockByWarehouseView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getOrgname() {
        return (String) get(PROPERTY_ORGNAME);
    }

    public void setOrgname(String orgname) {
        set(PROPERTY_ORGNAME, orgname);
    }

    public String getWarehouseName() {
        return (String) get(PROPERTY_WAREHOUSENAME);
    }

    public void setWarehouseName(String warehouseName) {
        set(PROPERTY_WAREHOUSENAME, warehouseName);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getProductName() {
        return (String) get(PROPERTY_PRODUCTNAME);
    }

    public void setProductName(String productName) {
        set(PROPERTY_PRODUCTNAME, productName);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProductCategoryName() {
        return (String) get(PROPERTY_PRODUCTCATEGORYNAME);
    }

    public void setProductCategoryName(String productCategoryName) {
        set(PROPERTY_PRODUCTCATEGORYNAME, productCategoryName);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public String getUOMName() {
        return (String) get(PROPERTY_UOMNAME);
    }

    public void setUOMName(String uOMName) {
        set(PROPERTY_UOMNAME, uOMName);
    }

    public BigDecimal getQuantityOnHand() {
        return (BigDecimal) get(PROPERTY_QUANTITYONHAND);
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        set(PROPERTY_QUANTITYONHAND, quantityOnHand);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

}
