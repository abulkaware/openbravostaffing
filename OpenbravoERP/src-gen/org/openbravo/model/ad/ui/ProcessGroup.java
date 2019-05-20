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
package org.openbravo.model.ad.ui;

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
 * Entity class for entity ProcessGroup (stored in table AD_Process_Group).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProcessGroup extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Process_Group";
    public static final String ENTITY_NAME = "ProcessGroup";
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
    public static final String PROPERTY_PREVENTCONCURRENTEXECUTIONS = "preventConcurrentExecutions";
    public static final String PROPERTY_STOPTHEGROUPEXECUTIONWHENAPROCESSFAILS = "stopTheGroupExecutionWhenAProcessFails";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_PROCESSEXECUTIONLIST = "processExecutionList";
    public static final String PROPERTY_PROCESSGROUPLISTLIST = "processGroupListList";
    public static final String PROPERTY_PROCESSREQUESTLIST = "processRequestList";

    public ProcessGroup() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PREVENTCONCURRENTEXECUTIONS, false);
        setDefaultValue(PROPERTY_STOPTHEGROUPEXECUTIONWHENAPROCESSFAILS, false);
        setDefaultValue(PROPERTY_PROCESSEXECUTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCESSGROUPLISTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCESSREQUESTLIST, new ArrayList<Object>());
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

    public Boolean isPreventConcurrentExecutions() {
        return (Boolean) get(PROPERTY_PREVENTCONCURRENTEXECUTIONS);
    }

    public void setPreventConcurrentExecutions(Boolean preventConcurrentExecutions) {
        set(PROPERTY_PREVENTCONCURRENTEXECUTIONS, preventConcurrentExecutions);
    }

    public Boolean isStopTheGroupExecutionWhenAProcessFails() {
        return (Boolean) get(PROPERTY_STOPTHEGROUPEXECUTIONWHENAPROCESSFAILS);
    }

    public void setStopTheGroupExecutionWhenAProcessFails(Boolean stopTheGroupExecutionWhenAProcessFails) {
        set(PROPERTY_STOPTHEGROUPEXECUTIONWHENAPROCESSFAILS, stopTheGroupExecutionWhenAProcessFails);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessExecution> getProcessExecutionList() {
      return (List<ProcessExecution>) get(PROPERTY_PROCESSEXECUTIONLIST);
    }

    public void setProcessExecutionList(List<ProcessExecution> processExecutionList) {
        set(PROPERTY_PROCESSEXECUTIONLIST, processExecutionList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessGroupList> getProcessGroupListList() {
      return (List<ProcessGroupList>) get(PROPERTY_PROCESSGROUPLISTLIST);
    }

    public void setProcessGroupListList(List<ProcessGroupList> processGroupListList) {
        set(PROPERTY_PROCESSGROUPLISTLIST, processGroupListList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessRequest> getProcessRequestList() {
      return (List<ProcessRequest>) get(PROPERTY_PROCESSREQUESTLIST);
    }

    public void setProcessRequestList(List<ProcessRequest> processRequestList) {
        set(PROPERTY_PROCESSREQUESTLIST, processRequestList);
    }

}
