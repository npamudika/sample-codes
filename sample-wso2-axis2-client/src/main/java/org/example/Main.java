package org.example;

import org.apache.axiom.om.*;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.addressing.EndpointReference;

public class Main {
    public static void main(String[] args) {
        try {

            String serviceURL = "https://localhost:9443/services/Version";

            ServiceClient client = new ServiceClient();
            Options options = new Options();
            options.setTo(new EndpointReference(serviceURL));
            options.setAction("urn:getVersion");  // Usually 'getVersion' is the operation name

            client.setOptions(options);

            // Build request payload
            OMFactory factory = OMAbstractFactory.getOMFactory();
            OMNamespace namespace = factory.createOMNamespace("http://version.services.core.carbon.wso2.org", "ns");
            OMElement method = factory.createOMElement("getVersion", namespace);

            // Send and receive
            OMElement response = client.sendReceive(method);

            // Print raw XML response
            System.out.println("Raw XML Response:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}