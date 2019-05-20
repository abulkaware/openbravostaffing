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
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity ProductStatus (stored in table M_Product_Status).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProductStatus extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Product_Status";
    public static final String ENTITY_NAME = "ProductStatus";
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
    public static final String PROPERTY_RESTRICTSALEFROMBACKEND = "restrictsalefrombackend";
    public static final String PROPERTY_RESTRICTSALEOUTOFSTOCK = "restrictsaleoutofstock";
    public static final String PROPERTY_RESTRICTDISTRIBORDERISSUE = "restrictdistriborderissue";
    public static final String PROPERTY_RESTRICTPURCHASE = "restrictpurchase";
    public static final String PROPERTY_RESTRICTMANUFACTURE = "restrictmanufacture";
    public static final String PROPERTY_RESTRICTDISTRIBORDERRECEIPT = "restrictdistriborderreceipt";
    public static final String PROPERTY_RESTRICTSALEFROMPOS = "restrictsalefrompos";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_PRODUCTLIST = "productList";
    public static final String PROPERTY_PRODUCTSTATUSTRLLIST = "productStatusTrlList";

    public ProductStatus() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_RESTRICTSALEFROMBACKEND, false);
        setDefaultValue(PROPERTY_RESTRICTSALEOUTOFSTOCK, false);
        setDefaultValue(PROPERTY_RESTRICTDISTRIBORDERISSUE, false);
        setDefaultValue(PROPERTY_RESTRICTPURCHASE, false);
        setDefaultValue(PROPERTY_RESTRICTMANUFACTURE, false);
        setDefaultValue(PROPERTY_RESTRICTDISTRIBORDERRECEIPT, false);
        setDefaultValue(PROPERTY_RESTRICTSALEFROMPOS, false);
        setDefaultValue(PROPERTY_PRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSTATUSTRLLIST, new ArrayList<Object>());
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

    public Boolean isRestrictsalefrombackend() {
        return (Boolean) get(PROPERTY_RESTRICTSALEFROMBACKEND);
    }

    public void setRestrictsalefrombackend(Boolean restrictsalefrombackend) {
        set(PROPERTY_RESTRICTSALEFROMBACKEND, restrictsalefrombackend);
    }

    public Boolean isRestrictsaleoutofstock() {
        return (Boolean) get(PROPERTY_RESTRICTSALEOUTOFSTOCK);
    }

    public void setRestrictsaleoutofstock(Boolean restrictsaleoutofstock) {
        set(PROPERTY_RESTRICTSALEOUTOFSTOCK, restrictsaleoutofstock);
    }

    public Boolean isRestrictdistriborderissue() {
        return (Boolean) get(PROPERTY_RESTRICTDISTRIBORDERISSUE);
    }

    public void setRestrictdistriborderissue(Boolean restrictdistriborderissue) {
        set(PROPERTY_RESTRICTDISTRIBORDERISSUE, restrictdistriborderissue);
    }

    public Boolean isRestrictpurchase() {
        return (Boolean) get(PROPERTY_RESTRICTPURCHASE);
    }

    public void setRestrictpurchase(Boolean restrictpurchase) {
        set(PROPERTY_RESTRICTPURCHASE, restrictpurchase);
    }

    public Boolean isRestrictmanufacture() {
        return (Boolean) get(PROPERTY_RESTRICTMANUFACTURE);
    }

    public void setRestrictmanufacture(Boolean restrictmanufacture) {
        set(PROPERTY_RESTRICTMANUFACTURE, restrictmanufacture);
    }

    public Boolean isRestrictdistriborderreceipt() {
        return (Boolean) get(PROPERTY_RESTRICTDISTRIBORDERRECEIPT);
    }

    public void setRestrictdistriborderreceipt(Boolean restrictdistriborderreceipt) {
        set(PROPERTY_RESTRICTDISTRIBORDERRECEIPT, restrictdistriborderreceipt);
    }

    public Boolean isRestrictsalefrompos() {
        return (Boolean) get(PROPERTY_RESTRICTSALEFROMPOS);
    }

    public void setRestrictsalefrompos(Boolean restrictsalefrompos) {
        set(PROPERTY_RESTRICTSALEFROMPOS, restrictsalefrompos);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
      return (List<Product>) get(PROPERTY_PRODUCTLIST);
    }

    public void setProductList(List<Product> productList) {
        set(PROPERTY_PRODUCTLIST, productList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductStatusTrl> getProductStatusTrlList() {
      return (List<ProductStatusTrl>) get(PROPERTY_PRODUCTSTATUSTRLLIST);
    }

    public void setProductStatusTrlList(List<ProductStatusTrl> productStatusTrlList) {
        set(PROPERTY_PRODUCTSTATUSTRLLIST, productStatusTrlList);
    }

}
