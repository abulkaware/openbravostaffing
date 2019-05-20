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
package org.openbravo.model.materialmgmt.onhandquantity;

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
import org.openbravo.model.common.plm.AttributeSetInstance;
/**
 * Entity class for entity MaterialMgmtReferencedInventory (stored in table M_RefInventory).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ReferencedInventory extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_RefInventory";
    public static final String ENTITY_NAME = "MaterialMgmtReferencedInventory";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REFERENCEDINVENTORYTYPE = "referencedInventoryType";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_BOX = "box";
    public static final String PROPERTY_UNBOX = "unbox";
    public static final String PROPERTY_ATTRIBUTESETINSTANCELIST = "attributeSetInstanceList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEDETAILLIST = "materialMgmtStorageDetailList";
    public static final String PROPERTY_PRODUCTSTOCKVIEWLIST = "productStockViewList";

    public ReferencedInventory() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BOX, false);
        setDefaultValue(PROPERTY_UNBOX, false);
        setDefaultValue(PROPERTY_ATTRIBUTESETINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSTOCKVIEWLIST, new ArrayList<Object>());
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

    public ReferencedInventoryType getReferencedInventoryType() {
        return (ReferencedInventoryType) get(PROPERTY_REFERENCEDINVENTORYTYPE);
    }

    public void setReferencedInventoryType(ReferencedInventoryType referencedInventoryType) {
        set(PROPERTY_REFERENCEDINVENTORYTYPE, referencedInventoryType);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Boolean isBox() {
        return (Boolean) get(PROPERTY_BOX);
    }

    public void setBox(Boolean box) {
        set(PROPERTY_BOX, box);
    }

    public Boolean isUnbox() {
        return (Boolean) get(PROPERTY_UNBOX);
    }

    public void setUnbox(Boolean unbox) {
        set(PROPERTY_UNBOX, unbox);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeSetInstance> getAttributeSetInstanceList() {
      return (List<AttributeSetInstance>) get(PROPERTY_ATTRIBUTESETINSTANCELIST);
    }

    public void setAttributeSetInstanceList(List<AttributeSetInstance> attributeSetInstanceList) {
        set(PROPERTY_ATTRIBUTESETINSTANCELIST, attributeSetInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<StorageDetail> getMaterialMgmtStorageDetailList() {
      return (List<StorageDetail>) get(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST);
    }

    public void setMaterialMgmtStorageDetailList(List<StorageDetail> materialMgmtStorageDetailList) {
        set(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, materialMgmtStorageDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductStockView> getProductStockViewList() {
      return (List<ProductStockView>) get(PROPERTY_PRODUCTSTOCKVIEWLIST);
    }

    public void setProductStockViewList(List<ProductStockView> productStockViewList) {
        set(PROPERTY_PRODUCTSTOCKVIEWLIST, productStockViewList);
    }

}
