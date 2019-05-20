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
/**
 * Entity class for entity ProductCharacteristic (stored in table M_Product_Ch).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProductCharacteristic extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Product_Ch";
    public static final String ENTITY_NAME = "ProductCharacteristic";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CHARACTERISTIC = "characteristic";
    public static final String PROPERTY_SEQUENCENUMBER = "sequenceNumber";
    public static final String PROPERTY_VARIANT = "variant";
    public static final String PROPERTY_CHARACTERISTICSUBSET = "characteristicSubset";
    public static final String PROPERTY_DEFINESPRICE = "definesPrice";
    public static final String PROPERTY_DEFINESIMAGE = "definesImage";
    public static final String PROPERTY_PRICELISTTYPE = "priceListType";
    public static final String PROPERTY_EXPLODECONFIGURATIONTAB = "explodeConfigurationTab";
    public static final String PROPERTY_PRODUCTCHARACTERISTICCONFLIST = "productCharacteristicConfList";

    public ProductCharacteristic() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_VARIANT, false);
        setDefaultValue(PROPERTY_DEFINESPRICE, false);
        setDefaultValue(PROPERTY_DEFINESIMAGE, false);
        setDefaultValue(PROPERTY_PRICELISTTYPE, "SALES");
        setDefaultValue(PROPERTY_EXPLODECONFIGURATIONTAB, true);
        setDefaultValue(PROPERTY_PRODUCTCHARACTERISTICCONFLIST, new ArrayList<Object>());
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Characteristic getCharacteristic() {
        return (Characteristic) get(PROPERTY_CHARACTERISTIC);
    }

    public void setCharacteristic(Characteristic characteristic) {
        set(PROPERTY_CHARACTERISTIC, characteristic);
    }

    public Long getSequenceNumber() {
        return (Long) get(PROPERTY_SEQUENCENUMBER);
    }

    public void setSequenceNumber(Long sequenceNumber) {
        set(PROPERTY_SEQUENCENUMBER, sequenceNumber);
    }

    public Boolean isVariant() {
        return (Boolean) get(PROPERTY_VARIANT);
    }

    public void setVariant(Boolean variant) {
        set(PROPERTY_VARIANT, variant);
    }

    public CharacteristicSubset getCharacteristicSubset() {
        return (CharacteristicSubset) get(PROPERTY_CHARACTERISTICSUBSET);
    }

    public void setCharacteristicSubset(CharacteristicSubset characteristicSubset) {
        set(PROPERTY_CHARACTERISTICSUBSET, characteristicSubset);
    }

    public Boolean isDefinesPrice() {
        return (Boolean) get(PROPERTY_DEFINESPRICE);
    }

    public void setDefinesPrice(Boolean definesPrice) {
        set(PROPERTY_DEFINESPRICE, definesPrice);
    }

    public Boolean isDefinesImage() {
        return (Boolean) get(PROPERTY_DEFINESIMAGE);
    }

    public void setDefinesImage(Boolean definesImage) {
        set(PROPERTY_DEFINESIMAGE, definesImage);
    }

    public String getPriceListType() {
        return (String) get(PROPERTY_PRICELISTTYPE);
    }

    public void setPriceListType(String priceListType) {
        set(PROPERTY_PRICELISTTYPE, priceListType);
    }

    public Boolean isExplodeConfigurationTab() {
        return (Boolean) get(PROPERTY_EXPLODECONFIGURATIONTAB);
    }

    public void setExplodeConfigurationTab(Boolean explodeConfigurationTab) {
        set(PROPERTY_EXPLODECONFIGURATIONTAB, explodeConfigurationTab);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristicConf> getProductCharacteristicConfList() {
      return (List<ProductCharacteristicConf>) get(PROPERTY_PRODUCTCHARACTERISTICCONFLIST);
    }

    public void setProductCharacteristicConfList(List<ProductCharacteristicConf> productCharacteristicConfList) {
        set(PROPERTY_PRODUCTCHARACTERISTICCONFLIST, productCharacteristicConfList);
    }

}
