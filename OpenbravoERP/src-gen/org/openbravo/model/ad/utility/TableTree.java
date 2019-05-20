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
package org.openbravo.model.ad.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Column;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.ReferencedTree;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.service.datasource.DataSource;
/**
 * Entity class for entity ADTableTree (stored in table ad_table_tree).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class TableTree extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ad_table_tree";
    public static final String ENTITY_NAME = "ADTableTree";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_LINKTOPARENTCOLUMN = "linkToParentColumn";
    public static final String PROPERTY_NODEIDCOLUMN = "nodeIdColumn";
    public static final String PROPERTY_HASMULTIPARENTNODES = "hasMultiparentNodes";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_APPLYWHERECLAUSETOCHILDNODES = "applyWhereClauseToChildNodes";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ISPARENTSELECTIONALLOWED = "isParentSelectionAllowed";
    public static final String PROPERTY_ISORDERED = "isOrdered";
    public static final String PROPERTY_TREESTRUCTURE = "treeStructure";
    public static final String PROPERTY_DATASOURCE = "datasource";
    public static final String PROPERTY_HANDLENODESMANUALLY = "handleNodesManually";
    public static final String PROPERTY_ISMAINTREE = "isMainTree";
    public static final String PROPERTY_NODEDELETIONPOLICY = "nodeDeletionPolicy";
    public static final String PROPERTY_ADREFERENCEDTREELIST = "aDReferencedTreeList";
    public static final String PROPERTY_ADTABLIST = "aDTabList";

    public TableTree() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_HASMULTIPARENTNODES, false);
        setDefaultValue(PROPERTY_APPLYWHERECLAUSETOCHILDNODES, true);
        setDefaultValue(PROPERTY_ISPARENTSELECTIONALLOWED, true);
        setDefaultValue(PROPERTY_ISORDERED, false);
        setDefaultValue(PROPERTY_HANDLENODESMANUALLY, false);
        setDefaultValue(PROPERTY_ISMAINTREE, true);
        setDefaultValue(PROPERTY_ADREFERENCEDTREELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADTABLIST, new ArrayList<Object>());
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

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Column getLinkToParentColumn() {
        return (Column) get(PROPERTY_LINKTOPARENTCOLUMN);
    }

    public void setLinkToParentColumn(Column linkToParentColumn) {
        set(PROPERTY_LINKTOPARENTCOLUMN, linkToParentColumn);
    }

    public Column getNodeIdColumn() {
        return (Column) get(PROPERTY_NODEIDCOLUMN);
    }

    public void setNodeIdColumn(Column nodeIdColumn) {
        set(PROPERTY_NODEIDCOLUMN, nodeIdColumn);
    }

    public Boolean isHasMultiparentNodes() {
        return (Boolean) get(PROPERTY_HASMULTIPARENTNODES);
    }

    public void setHasMultiparentNodes(Boolean hasMultiparentNodes) {
        set(PROPERTY_HASMULTIPARENTNODES, hasMultiparentNodes);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Boolean isApplyWhereClauseToChildNodes() {
        return (Boolean) get(PROPERTY_APPLYWHERECLAUSETOCHILDNODES);
    }

    public void setApplyWhereClauseToChildNodes(Boolean applyWhereClauseToChildNodes) {
        set(PROPERTY_APPLYWHERECLAUSETOCHILDNODES, applyWhereClauseToChildNodes);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isParentSelectionAllowed() {
        return (Boolean) get(PROPERTY_ISPARENTSELECTIONALLOWED);
    }

    public void setParentSelectionAllowed(Boolean isParentSelectionAllowed) {
        set(PROPERTY_ISPARENTSELECTIONALLOWED, isParentSelectionAllowed);
    }

    public Boolean isOrdered() {
        return (Boolean) get(PROPERTY_ISORDERED);
    }

    public void setOrdered(Boolean isOrdered) {
        set(PROPERTY_ISORDERED, isOrdered);
    }

    public String getTreeStructure() {
        return (String) get(PROPERTY_TREESTRUCTURE);
    }

    public void setTreeStructure(String treeStructure) {
        set(PROPERTY_TREESTRUCTURE, treeStructure);
    }

    public DataSource getDatasource() {
        return (DataSource) get(PROPERTY_DATASOURCE);
    }

    public void setDatasource(DataSource datasource) {
        set(PROPERTY_DATASOURCE, datasource);
    }

    public Boolean isHandleNodesManually() {
        return (Boolean) get(PROPERTY_HANDLENODESMANUALLY);
    }

    public void setHandleNodesManually(Boolean handleNodesManually) {
        set(PROPERTY_HANDLENODESMANUALLY, handleNodesManually);
    }

    public Boolean isMainTree() {
        return (Boolean) get(PROPERTY_ISMAINTREE);
    }

    public void setMainTree(Boolean isMainTree) {
        set(PROPERTY_ISMAINTREE, isMainTree);
    }

    public String getNodeDeletionPolicy() {
        return (String) get(PROPERTY_NODEDELETIONPOLICY);
    }

    public void setNodeDeletionPolicy(String nodeDeletionPolicy) {
        set(PROPERTY_NODEDELETIONPOLICY, nodeDeletionPolicy);
    }

    @SuppressWarnings("unchecked")
    public List<ReferencedTree> getADReferencedTreeList() {
      return (List<ReferencedTree>) get(PROPERTY_ADREFERENCEDTREELIST);
    }

    public void setADReferencedTreeList(List<ReferencedTree> aDReferencedTreeList) {
        set(PROPERTY_ADREFERENCEDTREELIST, aDReferencedTreeList);
    }

    @SuppressWarnings("unchecked")
    public List<Tab> getADTabList() {
      return (List<Tab>) get(PROPERTY_ADTABLIST);
    }

    public void setADTabList(List<Tab> aDTabList) {
        set(PROPERTY_ADTABLIST, aDTabList);
    }

}
