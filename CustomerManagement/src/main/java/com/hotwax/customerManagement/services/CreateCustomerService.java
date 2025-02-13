package com.hotwax.customerManagement.services;

import java.util.Map;
import org.apache.ofbiz.base.util.*;
import java.sql.Timestamp;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.service.LocalDispatcher;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;


public class CreateCustomerService{

  public static final String MODULE = CreateCustomerService.class.getName();

  public static Map<String, Object> createCustomer(DispatchContext dispatchContext, Map<String, ? extends Object> context) {
//    Delegator delegator = dispatchContext.getDelegator();
//    LocalDispatcher dispatcher = dispatchContext.getDispatcher();
//    Timestamp now = UtilDateTime.nowTimestamp();
//    try {
//      Map<String, Object> createdPersonMap = dispatcher.runSync(
//          "createPerson", context
//      );
//      Map<String, Object> createdPartyRole = dispatcher.runSync(
//        "createPartyRole", UtilMisc.toMap(
//              "partyId", createdPersonMap.get("partyId"),
//              "roleTypeId", "CUSTOMER",
//              "fromDate", now
//          )
//      );
//      Map<String, Object> createdContactMech = dispatcher.runSync(
//          "createContactMech", context.get("emailAddress")
//      );
//      Map<String, Object> createdPartyContactMech = dispatcher.runSync(
//          "createPartyContactMech", UtilMisc.toMap(
//              "partyId", createdPersonMap.get("partyId"),
//              "contactmechId", createdContactMech.get("contactmechId"),
//              "contactMechPurposeTypeId", "PRIMARY_EMAIL",
//              "fromDate", now
//          )
//      );
//
//
////      GenericValue party = delegator.makeValue("Party");
////      party.setNextSeqId();
////      party.setNonPKFields(context);
////      party = delegator.create(ofbizDemo);
////      context.put("partyId", party.getString("partyId"));
////      GenericValue person = delegator.makeValue('Person');
////      person.setNextSeqId();
////      person.setAllFields(context);
////      context.put("roleTypeId", "CUSTOMER");
////      GenericValue partyRole = delegator.makeValue("PartyRole");
////      Map<String, Object> partyRoleMap = UtilMisc.toMap("partyId", context.get("partyId"),
////          "roleTypeId", context.get("roleTypeId"), )
////      result.put("ofbizDemoId", ofbizDemo.getString("ofbizDemoId"));
////      Debug.log("/////////////////////////////////////////////////////////Record "
////          + party.getString("partyId") + " Created");
//
//    } catch (GenericEntityException e) {
//      Debug.logError(e, MODULE);
//      return ServiceUtil.returnError("Failed to create records" + MODULE);
//    }
    return null;
  }
}