import java.util.Map;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

def createOfbizDemoServiceByGroovy() {
  result = [:];
  try{
    ofbizDemo = delegator.makeValue("OfbizDemo");
    ofbizDemo.setNextSeqId();
    ofbizDemo.setNonPKFields(context);
    ofbizDemo = delegator.create(ofbizDemo);
    result.put("ofbizDemoId", ofbizDemo.ofbizDemoId);
    logInfo("////////////////////////////Created " + ofbizDemo.ofbizDemoId + " ////////////////////////////////////");
  } catch (GenericEntityException e) {
    logError(e.getMessage());
  }
  return result;
}
