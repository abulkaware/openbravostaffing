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
import org.openbravo.model.ad.utility.Tree;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity Characteristic (stored in table M_Characteristic).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Characteristic extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Characteristic";
    public static final String ENTITY_NAME = "Characteristic";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TREE = "tree";
    public static final String PROPERTY_VARIANT = "variant";
    public static final String PROPERTY_EXPLODECONFIGURATIONTAB = "explodeConfigurationTab";
    public static final String PROPERTY_CHARACTERISTICSUBSETLIST = "characteristicSubsetList";
    public static final String PROPERTY_CHARACTERISTICVALUELIST = "characteristicValueList";
    public static final String PROPERTY_PRICINGADJUSTMENTCHARACTERISTICLIST = "pricingAdjustmentCharacteristicList";
    public static final String PROPERTY_PRODUCTCHARACTERISTICLIST = "productCharacteristicList";
    public static final String PROPERTY_PRODUCTCHARACTERISTICVALUELIST = "productCharacteristicValueList";
    public static final String PROPERTY_PRODUCTWITHCHARACTERISTICSLIST = "productWithCharacteristicsList";

    public Characteristic() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_VARIANT, false);
        setDefaultValue(PROPERTY_EXPLODECONFIGURATIONTAB, true);
        setDefaultValue(PROPERTY_CHARACTERISTICSUBSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CHARACTERISTICVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTCHARACTERISTICLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCHARACTERISTICLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCHARACTERISTICVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTWITHCHARACTERISTICSLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Tree getTree() {
        return (Tree) get(PROPERTY_TREE);
    }

    public void setTree(Tree tree) {
        set(PROPERTY_TREE, tree);
    }

    public Boolean isVariant() {
        return (Boolean) get(PROPERTY_VARIANT);
    }

    public void setVariant(Boolean variant) {
        set(PROPERTY_VARIANT, variant);
    }

    public Boolean isExplodeConfigurationTab() {
        return (Boolean) get(PROPERTY_EXPLODECONFIGURATIONTAB);
    }

    public void setExplodeConfigurationTab(Boolean explodeConfigurationTab) {
        set(PROPERTY_EXPLODECONFIGURATIONTAB, explodeConfigurationTab);
    }

    @SuppressWarnings("unchecked")
    public List<CharacteristicSubset> getCharacteristicSubsetList() {
      return (List<CharacteristicSubset>) get(PROPERTY_CHARACTERISTICSUBSETLIST);
    }

    public void setCharacteristicSubsetList(List<CharacteristicSubset> characteristicSubsetList) {
        set(PROPERTY_CHARACTERISTICSUBSETLIST, characteristicSubsetList);
    }

    @SuppressWarnings("unchecked")
    public List<CharacteristicValue> getCharacteristicValueList() {
      return (List<CharacteristicValue>) get(PROPERTY_CHARACTERISTICVALUELIST);
    }

    public void setCharacteristicValueList(List<CharacteristicValue> characteristicValueList) {
        set(PROPERTY_CHARACTERISTICVALUELIST, characteristicValueList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.priceadjustment.Characteristic> getPricingAdjustmentCharacteristicList() {
      return (List<org.openbravo.model.pricing.priceadjustment.Characteristic>) get(PROPERTY_PRICINGADJUSTMENTCHARACTERISTICLIST);
    }

    public void setPricingAdjustmentCharacteristicList(List<org.openbravo.model.pricing.priceadjustment.Characteristic> pricingAdjustmentCharacteristicList) {
        set(PROPERTY_PRICINGADJUSTMENTCHARACTERISTICLIST, pricingAdjustmentCharacteristicList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristic> getProductCharacteristicList() {
      return (List<ProductCharacteristic>) get(PROPERTY_PRODUCTCHARACTERISTICLIST);
    }

    public void setProductCharacteristicList(List<ProductCharacteristic> productCharacteristicList) {
        set(PROPERTY_PRODUCTCHARACTERISTICLIST, productCharacteristicList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristicValue> getProductCharacteristicValueList() {
      return (List<ProductCharacteristicValue>) get(PROPERTY_PRODUCTCHARACTERISTICVALUELIST);
    }

    public void setProductCharacteristicValueList(List<ProductCharacteristicValue> productCharacteristicValueList) {
        set(PROPERTY_PRODUCTCHARACTERISTICVALUELIST, productCharacteristicValueList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristics> getProductWithCharacteristicsList() {
      return (List<ProductCharacteristics>) get(PROPERTY_PRODUCTWITHCHARACTERISTICSLIST);
    }

    public void setProductWithCharacteristicsList(List<ProductCharacteristics> productWithCharacteristicsList) {
        set(PROPERTY_PRODUCTWITHCHARACTERISTICSLIST, productWithCharacteristicsList);
    }

}
