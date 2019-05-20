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
package org.openbravo.model.common.plm;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity ProductWithCharacteristics (stored in table m_prodchview_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProductCharacteristics extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "m_prodchview_v";
    public static final String ENTITY_NAME = "ProductWithCharacteristics";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_CHARACTERISTICDESCRIPTION = "characteristicDescription";
    public static final String PROPERTY_GENERICPRODUCT = "genericProduct";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CHARACTERISTIC = "characteristic";
    public static final String PROPERTY_CHARNAME = "charName";
    public static final String PROPERTY_CHARACTERISTICVALUE = "characteristicValue";
    public static final String PROPERTY_PRODUCTCHVALUE = "productChValue";
    public static final String PROPERTY_ISGENERIC = "isGeneric";

    public ProductCharacteristics() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISGENERIC, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getCharacteristicDescription() {
        return (String) get(PROPERTY_CHARACTERISTICDESCRIPTION);
    }

    public void setCharacteristicDescription(String characteristicDescription) {
        set(PROPERTY_CHARACTERISTICDESCRIPTION, characteristicDescription);
    }

    public Product getGenericProduct() {
        return (Product) get(PROPERTY_GENERICPRODUCT);
    }

    public void setGenericProduct(Product genericProduct) {
        set(PROPERTY_GENERICPRODUCT, genericProduct);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Characteristic getCharacteristic() {
        return (Characteristic) get(PROPERTY_CHARACTERISTIC);
    }

    public void setCharacteristic(Characteristic characteristic) {
        set(PROPERTY_CHARACTERISTIC, characteristic);
    }

    public String getCharName() {
        return (String) get(PROPERTY_CHARNAME);
    }

    public void setCharName(String charName) {
        set(PROPERTY_CHARNAME, charName);
    }

    public CharacteristicValue getCharacteristicValue() {
        return (CharacteristicValue) get(PROPERTY_CHARACTERISTICVALUE);
    }

    public void setCharacteristicValue(CharacteristicValue characteristicValue) {
        set(PROPERTY_CHARACTERISTICVALUE, characteristicValue);
    }

    public ProductCharacteristicValue getProductChValue() {
        return (ProductCharacteristicValue) get(PROPERTY_PRODUCTCHVALUE);
    }

    public void setProductChValue(ProductCharacteristicValue productChValue) {
        set(PROPERTY_PRODUCTCHVALUE, productChValue);
    }

    public Boolean isGeneric() {
        return (Boolean) get(PROPERTY_ISGENERIC);
    }

    public void setGeneric(Boolean isGeneric) {
        set(PROPERTY_ISGENERIC, isGeneric);
    }

}
