package com.companyname.ofbizdemo.services;
import java.util.Map;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

public class OfbizDemoServices {

    public static final String MODULE = OfbizDemoServices.class.getName();

    public static Map<String, Object> createOfbizDemo(DispatchContext dispatchContext, Map<String, ? extends Object> context){
        Map<String, Object> result = ServiceUtil.returnSuccess();
        Delegator delegator = dispatchContext.getDelegator();
        try {
            GenericValue ofbizDemo = delegator.makeValue("OfbizDemo");
            ofbizDemo.setNextSeqId();
            ofbizDemo.setNonPKFields(context);
            ofbizDemo = delegator.create(ofbizDemo);
            result.put("ofbizDemoId", ofbizDemo.getString("ofbizDemoId"));
            Debug.log("/////////////////////////////////////////////////////////Record "
                    + ofbizDemo.getString("ofbizDemoId") + " Created");

        } catch (GenericEntityException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError("Failed to create record" + MODULE);
        }
        return result;
    }
}