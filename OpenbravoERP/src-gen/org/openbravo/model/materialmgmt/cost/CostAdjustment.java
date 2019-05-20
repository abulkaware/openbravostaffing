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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity CostAdjustment (stored in table M_CostAdjustment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CostAdjustment extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_CostAdjustment";
    public static final String ENTITY_NAME = "CostAdjustment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_REFERENCEDATE = "referenceDate";
    public static final String PROPERTY_SOURCEPROCESS = "sourceProcess";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_CANCELPROCESS = "cancelProcess";
    public static final String PROPERTY_COSTADJUSTMENTCANCEL = "costAdjustmentCancel";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_COSTADJUSTMENTCOSTADJUSTMENTCANCELLIST = "costAdjustmentCostAdjustmentCancelList";
    public static final String PROPERTY_COSTADJUSTMENTLINELIST = "costAdjustmentLineList";
    public static final String PROPERTY_LANDEDCOSTLIST = "landedCostList";
    public static final String PROPERTY_LANDEDCOSTCOSTMATCHINGCOSTADJUSTMENTLIST = "landedCostCostMatchingCostAdjustmentList";

    public CostAdjustment() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_CANCELPROCESS, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_COSTADJUSTMENTCOSTADJUSTMENTCANCELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTADJUSTMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTCOSTMATCHINGCOSTADJUSTMENTLIST, new ArrayList<Object>());
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getReferenceDate() {
        return (Date) get(PROPERTY_REFERENCEDATE);
    }

    public void setReferenceDate(Date referenceDate) {
        set(PROPERTY_REFERENCEDATE, referenceDate);
    }

    public String getSourceProcess() {
        return (String) get(PROPERTY_SOURCEPROCESS);
    }

    public void setSourceProcess(String sourceProcess) {
        set(PROPERTY_SOURCEPROCESS, sourceProcess);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Boolean isCancelProcess() {
        return (Boolean) get(PROPERTY_CANCELPROCESS);
    }

    public void setCancelProcess(Boolean cancelProcess) {
        set(PROPERTY_CANCELPROCESS, cancelProcess);
    }

    public CostAdjustment getCostAdjustmentCancel() {
        return (CostAdjustment) get(PROPERTY_COSTADJUSTMENTCANCEL);
    }

    public void setCostAdjustmentCancel(CostAdjustment costAdjustmentCancel) {
        set(PROPERTY_COSTADJUSTMENTCANCEL, costAdjustmentCancel);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustment> getCostAdjustmentCostAdjustmentCancelList() {
      return (List<CostAdjustment>) get(PROPERTY_COSTADJUSTMENTCOSTADJUSTMENTCANCELLIST);
    }

    public void setCostAdjustmentCostAdjustmentCancelList(List<CostAdjustment> costAdjustmentCostAdjustmentCancelList) {
        set(PROPERTY_COSTADJUSTMENTCOSTADJUSTMENTCANCELLIST, costAdjustmentCostAdjustmentCancelList);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustmentLine> getCostAdjustmentLineList() {
      return (List<CostAdjustmentLine>) get(PROPERTY_COSTADJUSTMENTLINELIST);
    }

    public void setCostAdjustmentLineList(List<CostAdjustmentLine> costAdjustmentLineList) {
        set(PROPERTY_COSTADJUSTMENTLINELIST, costAdjustmentLineList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCost> getLandedCostList() {
      return (List<LandedCost>) get(PROPERTY_LANDEDCOSTLIST);
    }

    public void setLandedCostList(List<LandedCost> landedCostList) {
        set(PROPERTY_LANDEDCOSTLIST, landedCostList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostCost> getLandedCostCostMatchingCostAdjustmentList() {
      return (List<LandedCostCost>) get(PROPERTY_LANDEDCOSTCOSTMATCHINGCOSTADJUSTMENTLIST);
    }

    public void setLandedCostCostMatchingCostAdjustmentList(List<LandedCostCost> landedCostCostMatchingCostAdjustmentList) {
        set(PROPERTY_LANDEDCOSTCOSTMATCHINGCOSTADJUSTMENTLIST, landedCostCostMatchingCostAdjustmentList);
    }

}
