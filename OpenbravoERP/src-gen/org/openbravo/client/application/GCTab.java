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
package org.openbravo.client.application;

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
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity OBUIAPP_GC_Tab (stored in table OBUIAPP_GC_Tab).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GCTab extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "OBUIAPP_GC_Tab";
    public static final String ENTITY_NAME = "OBUIAPP_GC_Tab";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TAB = "tab";
    public static final String PROPERTY_FILTERABLE = "filterable";
    public static final String PROPERTY_SORTABLE = "sortable";
    public static final String PROPERTY_TEXTFILTERBEHAVIOR = "textFilterBehavior";
    public static final String PROPERTY_THRESHOLDTOFILTER = "thresholdToFilter";
    public static final String PROPERTY_ISLAZYFILTERING = "isLazyFiltering";
    public static final String PROPERTY_FILTERONCHANGE = "filterOnChange";
    public static final String PROPERTY_ALLOWFILTERBYIDENTIFIER = "allowFilterByIdentifier";
    public static final String PROPERTY_ISFKDROPDOWNUNFILTERED = "isFkDropDownUnfiltered";
    public static final String PROPERTY_DISABLEFKCOMBO = "disableFkCombo";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_ALLOWSUMMARYFUNCTIONS = "allowSummaryFunctions";
    public static final String PROPERTY_OBUIAPPGCFIELDLIST = "oBUIAPPGCFieldList";

    public GCTab() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FILTERABLE, "D");
        setDefaultValue(PROPERTY_SORTABLE, "D");
        setDefaultValue(PROPERTY_TEXTFILTERBEHAVIOR, "D");
        setDefaultValue(PROPERTY_ISLAZYFILTERING, "D");
        setDefaultValue(PROPERTY_FILTERONCHANGE, "D");
        setDefaultValue(PROPERTY_ALLOWFILTERBYIDENTIFIER, "D");
        setDefaultValue(PROPERTY_ISFKDROPDOWNUNFILTERED, "D");
        setDefaultValue(PROPERTY_DISABLEFKCOMBO, "D");
        setDefaultValue(PROPERTY_SEQNO, (long) 10);
        setDefaultValue(PROPERTY_ALLOWSUMMARYFUNCTIONS, "D");
        setDefaultValue(PROPERTY_OBUIAPPGCFIELDLIST, new ArrayList<Object>());
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

    public Tab getTab() {
        return (Tab) get(PROPERTY_TAB);
    }

    public void setTab(Tab tab) {
        set(PROPERTY_TAB, tab);
    }

    public String getFilterable() {
        return (String) get(PROPERTY_FILTERABLE);
    }

    public void setFilterable(String filterable) {
        set(PROPERTY_FILTERABLE, filterable);
    }

    public String getSortable() {
        return (String) get(PROPERTY_SORTABLE);
    }

    public void setSortable(String sortable) {
        set(PROPERTY_SORTABLE, sortable);
    }

    public String getTextFilterBehavior() {
        return (String) get(PROPERTY_TEXTFILTERBEHAVIOR);
    }

    public void setTextFilterBehavior(String textFilterBehavior) {
        set(PROPERTY_TEXTFILTERBEHAVIOR, textFilterBehavior);
    }

    public Long getThresholdToFilter() {
        return (Long) get(PROPERTY_THRESHOLDTOFILTER);
    }

    public void setThresholdToFilter(Long thresholdToFilter) {
        set(PROPERTY_THRESHOLDTOFILTER, thresholdToFilter);
    }

    public String getIsLazyFiltering() {
        return (String) get(PROPERTY_ISLAZYFILTERING);
    }

    public void setIsLazyFiltering(String isLazyFiltering) {
        set(PROPERTY_ISLAZYFILTERING, isLazyFiltering);
    }

    public String getFilterOnChange() {
        return (String) get(PROPERTY_FILTERONCHANGE);
    }

    public void setFilterOnChange(String filterOnChange) {
        set(PROPERTY_FILTERONCHANGE, filterOnChange);
    }

    public String getAllowFilterByIdentifier() {
        return (String) get(PROPERTY_ALLOWFILTERBYIDENTIFIER);
    }

    public void setAllowFilterByIdentifier(String allowFilterByIdentifier) {
        set(PROPERTY_ALLOWFILTERBYIDENTIFIER, allowFilterByIdentifier);
    }

    public String getIsFkDropDownUnfiltered() {
        return (String) get(PROPERTY_ISFKDROPDOWNUNFILTERED);
    }

    public void setIsFkDropDownUnfiltered(String isFkDropDownUnfiltered) {
        set(PROPERTY_ISFKDROPDOWNUNFILTERED, isFkDropDownUnfiltered);
    }

    public String getDisableFkCombo() {
        return (String) get(PROPERTY_DISABLEFKCOMBO);
    }

    public void setDisableFkCombo(String disableFkCombo) {
        set(PROPERTY_DISABLEFKCOMBO, disableFkCombo);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getAllowSummaryFunctions() {
        return (String) get(PROPERTY_ALLOWSUMMARYFUNCTIONS);
    }

    public void setAllowSummaryFunctions(String allowSummaryFunctions) {
        set(PROPERTY_ALLOWSUMMARYFUNCTIONS, allowSummaryFunctions);
    }

    @SuppressWarnings("unchecked")
    public List<GCField> getOBUIAPPGCFieldList() {
      return (List<GCField>) get(PROPERTY_OBUIAPPGCFIELDLIST);
    }

    public void setOBUIAPPGCFieldList(List<GCField> oBUIAPPGCFieldList) {
        set(PROPERTY_OBUIAPPGCFIELDLIST, oBUIAPPGCFieldList);
    }

}
