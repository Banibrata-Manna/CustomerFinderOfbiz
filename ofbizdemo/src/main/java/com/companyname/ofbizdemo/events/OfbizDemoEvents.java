package com.companyname.ofbizdemo.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

public class OfbizDemoEvents{
  public static final String MODULE = OfbizDemoEvents.class.getName();

  public static String createOfbizDemoEvent(HttpServletRequest request, HttpServletResponse response){
    Delegator delegator = (Delegator) request.getAttribute("delegator");
    LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
    GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

    String ofbizDemoTypeId = request.getParameter("ofbizDemoTypeId");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    if (UtilValidate.isEmpty(firstName) || UtilValidate.isEmpty(lastName)) {
      request.setAttribute("_ERROR_MESSAGE_", "Name fields can't be empty");
      return "error";
    }
    String comments = request.getParameter("comments");

    try {
      Debug.logInfo("=======Creating OfbizDemo record in event using service createOfbizDemoByGroovyService=========", MODULE);
      dispatcher.runSync("createOfbizDemoByGroovy", UtilMisc.toMap("ofbizDemoTypeId", ofbizDemoTypeId,
          "firstName", firstName, "lastName", lastName, "comments", comments, "userLogin", userLogin));
    } catch (GenericServiceException e) {
      Debug.logError(e, MODULE);
      request.setAttribute("_ERROR_MESSAGE_", "failed to create record");
      return "error";
    }
    request.setAttribute("_EVENT_MESSAGE_", "Record created succesfully.");
    return "success";
  }
}