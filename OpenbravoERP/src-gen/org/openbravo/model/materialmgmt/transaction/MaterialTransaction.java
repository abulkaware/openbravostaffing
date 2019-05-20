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
package org.openbravo.model.materialmgmt.transaction;

import java.math.BigDecimal;
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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.cost.CostAdjustmentLine;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.materialmgmt.cost.CostingAlgorithm;
import org.openbravo.model.materialmgmt.cost.TransactionCost;
import org.openbravo.model.project.ProjectIssue;
/**
 * Entity class for entity MaterialMgmtMaterialTransaction (stored in table M_Transaction).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MaterialTransaction extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Transaction";
    public static final String ENTITY_NAME = "MaterialMgmtMaterialTransaction";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MOVEMENTTYPE = "movementType";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_MOVEMENTQUANTITY = "movementQuantity";
    public static final String PROPERTY_PHYSICALINVENTORYLINE = "physicalInventoryLine";
    public static final String PROPERTY_MOVEMENTLINE = "movementLine";
    public static final String PROPERTY_GOODSSHIPMENTLINE = "goodsShipmentLine";
    public static final String PROPERTY_PRODUCTIONLINE = "productionLine";
    public static final String PROPERTY_PROJECTISSUE = "projectIssue";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_ORDERUOM = "orderUOM";
    public static final String PROPERTY_ORDERQUANTITY = "orderQuantity";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_INTERNALCONSUMPTIONLINE = "internalConsumptionLine";
    public static final String PROPERTY_TRANSACTIONCOST = "transactionCost";
    public static final String PROPERTY_TRANSACTIONPROCESSDATE = "transactionProcessDate";
    public static final String PROPERTY_COSTINGALGORITHM = "costingAlgorithm";
    public static final String PROPERTY_ISCOSTCALCULATED = "isCostCalculated";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_COSTINGSTATUS = "costingStatus";
    public static final String PROPERTY_CHECKRESERVEDQUANTITY = "checkReservedQuantity";
    public static final String PROPERTY_ISPROCESSED = "isProcessed";
    public static final String PROPERTY_CHECKPRICEDIFFERENCE = "checkpricedifference";
    public static final String PROPERTY_MANUALCOSTADJUSTMENT = "manualcostadjustment";
    public static final String PROPERTY_ISCOSTPERMANENT = "isCostPermanent";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_COSTADJUSTMENTLINELIST = "costAdjustmentLineList";
    public static final String PROPERTY_MATERIALMGMTCOSTINGLIST = "materialMgmtCostingList";
    public static final String PROPERTY_TRANSACTIONCOSTLIST = "transactionCostList";
    public static final String PROPERTY_TRANSACTIONLASTLIST = "transactionLastList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_TOTALCOST = "totalCost";
    public static final String COMPUTED_COLUMN_UNITCOST = "unitCost";

    public MaterialTransaction() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TRANSACTIONPROCESSDATE, new Date());
        setDefaultValue(PROPERTY_ISCOSTCALCULATED, false);
        setDefaultValue(PROPERTY_COSTINGSTATUS, "NC");
        setDefaultValue(PROPERTY_CHECKRESERVEDQUANTITY, true);
        setDefaultValue(PROPERTY_ISPROCESSED, false);
        setDefaultValue(PROPERTY_CHECKPRICEDIFFERENCE, false);
        setDefaultValue(PROPERTY_MANUALCOSTADJUSTMENT, false);
        setDefaultValue(PROPERTY_ISCOSTPERMANENT, false);
        setDefaultValue(PROPERTY_COSTADJUSTMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTCOSTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONLASTLIST, new ArrayList<Object>());
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

    public String getMovementType() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementType(String movementType) {
        set(PROPERTY_MOVEMENTTYPE, movementType);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public BigDecimal getMovementQuantity() {
        return (BigDecimal) get(PROPERTY_MOVEMENTQUANTITY);
    }

    public void setMovementQuantity(BigDecimal movementQuantity) {
        set(PROPERTY_MOVEMENTQUANTITY, movementQuantity);
    }

    public InventoryCountLine getPhysicalInventoryLine() {
        return (InventoryCountLine) get(PROPERTY_PHYSICALINVENTORYLINE);
    }

    public void setPhysicalInventoryLine(InventoryCountLine physicalInventoryLine) {
        set(PROPERTY_PHYSICALINVENTORYLINE, physicalInventoryLine);
    }

    public InternalMovementLine getMovementLine() {
        return (InternalMovementLine) get(PROPERTY_MOVEMENTLINE);
    }

    public void setMovementLine(InternalMovementLine movementLine) {
        set(PROPERTY_MOVEMENTLINE, movementLine);
    }

    public ShipmentInOutLine getGoodsShipmentLine() {
        return (ShipmentInOutLine) get(PROPERTY_GOODSSHIPMENTLINE);
    }

    public void setGoodsShipmentLine(ShipmentInOutLine goodsShipmentLine) {
        set(PROPERTY_GOODSSHIPMENTLINE, goodsShipmentLine);
    }

    public ProductionLine getProductionLine() {
        return (ProductionLine) get(PROPERTY_PRODUCTIONLINE);
    }

    public void setProductionLine(ProductionLine productionLine) {
        set(PROPERTY_PRODUCTIONLINE, productionLine);
    }

    public ProjectIssue getProjectIssue() {
        return (ProjectIssue) get(PROPERTY_PROJECTISSUE);
    }

    public void setProjectIssue(ProjectIssue projectIssue) {
        set(PROPERTY_PROJECTISSUE, projectIssue);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public ProductUOM getOrderUOM() {
        return (ProductUOM) get(PROPERTY_ORDERUOM);
    }

    public void setOrderUOM(ProductUOM orderUOM) {
        set(PROPERTY_ORDERUOM, orderUOM);
    }

    public BigDecimal getOrderQuantity() {
        return (BigDecimal) get(PROPERTY_ORDERQUANTITY);
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        set(PROPERTY_ORDERQUANTITY, orderQuantity);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public InternalConsumptionLine getInternalConsumptionLine() {
        return (InternalConsumptionLine) get(PROPERTY_INTERNALCONSUMPTIONLINE);
    }

    public void setInternalConsumptionLine(InternalConsumptionLine internalConsumptionLine) {
        set(PROPERTY_INTERNALCONSUMPTIONLINE, internalConsumptionLine);
    }

    public BigDecimal getTransactionCost() {
        return (BigDecimal) get(PROPERTY_TRANSACTIONCOST);
    }

    public void setTransactionCost(BigDecimal transactionCost) {
        set(PROPERTY_TRANSACTIONCOST, transactionCost);
    }

    public Date getTransactionProcessDate() {
        return (Date) get(PROPERTY_TRANSACTIONPROCESSDATE);
    }

    public void setTransactionProcessDate(Date transactionProcessDate) {
        set(PROPERTY_TRANSACTIONPROCESSDATE, transactionProcessDate);
    }

    public CostingAlgorithm getCostingAlgorithm() {
        return (CostingAlgorithm) get(PROPERTY_COSTINGALGORITHM);
    }

    public void setCostingAlgorithm(CostingAlgorithm costingAlgorithm) {
        set(PROPERTY_COSTINGALGORITHM, costingAlgorithm);
    }

    public Boolean isCostCalculated() {
        return (Boolean) get(PROPERTY_ISCOSTCALCULATED);
    }

    public void setCostCalculated(Boolean isCostCalculated) {
        set(PROPERTY_ISCOSTCALCULATED, isCostCalculated);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getCostingStatus() {
        return (String) get(PROPERTY_COSTINGSTATUS);
    }

    public void setCostingStatus(String costingStatus) {
        set(PROPERTY_COSTINGSTATUS, costingStatus);
    }

    public Boolean isCheckReservedQuantity() {
        return (Boolean) get(PROPERTY_CHECKRESERVEDQUANTITY);
    }

    public void setCheckReservedQuantity(Boolean checkReservedQuantity) {
        set(PROPERTY_CHECKRESERVEDQUANTITY, checkReservedQuantity);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_ISPROCESSED);
    }

    public void setProcessed(Boolean isProcessed) {
        set(PROPERTY_ISPROCESSED, isProcessed);
    }

    public Boolean isCheckpricedifference() {
        return (Boolean) get(PROPERTY_CHECKPRICEDIFFERENCE);
    }

    public void setCheckpricedifference(Boolean checkpricedifference) {
        set(PROPERTY_CHECKPRICEDIFFERENCE, checkpricedifference);
    }

    public Boolean isManualcostadjustment() {
        return (Boolean) get(PROPERTY_MANUALCOSTADJUSTMENT);
    }

    public void setManualcostadjustment(Boolean manualcostadjustment) {
        set(PROPERTY_MANUALCOSTADJUSTMENT, manualcostadjustment);
    }

    public Boolean isCostPermanent() {
        return (Boolean) get(PROPERTY_ISCOSTPERMANENT);
    }

    public void setCostPermanent(Boolean isCostPermanent) {
        set(PROPERTY_ISCOSTPERMANENT, isCostPermanent);
    }

    public BigDecimal getTotalCost() {
        return (BigDecimal) get(COMPUTED_COLUMN_TOTALCOST);
    }

    public void setTotalCost(BigDecimal totalCost) {
        set(COMPUTED_COLUMN_TOTALCOST, totalCost);
    }

    public BigDecimal getUnitCost() {
        return (BigDecimal) get(COMPUTED_COLUMN_UNITCOST);
    }

    public void setUnitCost(BigDecimal unitCost) {
        set(COMPUTED_COLUMN_UNITCOST, unitCost);
    }

    public MaterialTransaction_ComputedColumns get_computedColumns() {
        return (MaterialTransaction_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(MaterialTransaction_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustmentLine> getCostAdjustmentLineList() {
      return (List<CostAdjustmentLine>) get(PROPERTY_COSTADJUSTMENTLINELIST);
    }

    public void setCostAdjustmentLineList(List<CostAdjustmentLine> costAdjustmentLineList) {
        set(PROPERTY_COSTADJUSTMENTLINELIST, costAdjustmentLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Costing> getMaterialMgmtCostingList() {
      return (List<Costing>) get(PROPERTY_MATERIALMGMTCOSTINGLIST);
    }

    public void setMaterialMgmtCostingList(List<Costing> materialMgmtCostingList) {
        set(PROPERTY_MATERIALMGMTCOSTINGLIST, materialMgmtCostingList);
    }

    @SuppressWarnings("unchecked")
    public List<TransactionCost> getTransactionCostList() {
      return (List<TransactionCost>) get(PROPERTY_TRANSACTIONCOSTLIST);
    }

    public void setTransactionCostList(List<TransactionCost> transactionCostList) {
        set(PROPERTY_TRANSACTIONCOSTLIST, transactionCostList);
    }

    @SuppressWarnings("unchecked")
    public List<TransactionLast> getTransactionLastList() {
      return (List<TransactionLast>) get(PROPERTY_TRANSACTIONLASTLIST);
    }

    public void setTransactionLastList(List<TransactionLast> transactionLastList) {
        set(PROPERTY_TRANSACTIONLASTLIST, transactionLastList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_TOTALCOST.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getTotalCost();
      }
      if (COMPUTED_COLUMN_UNITCOST.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getUnitCost();
      }
    
      return super.get(propName);
    }
}
