# sample-wso2-axis2-client
This is a sample axis2-client to test https://github.com/wso2/wso2-axis2/tree/master/orbit/axis2-client

This client will call the default https://localhost:9443/services/Version SOAP endpoint in WSO2 Servers.

## Prerequisites
1. Java 1.8+
2. Maven 3.6+
3. Start the WSO2 API Manager server.
4. Add WSO2 certificate to your JDK's cacerts. To do that,
    - Export the WSO2 APIM certificate via the Browser as `wso2cert.pem` file.
    - Navigate to `<JAVA_HOME>/lib/security` folder. For example `/usr/local/Cellar/openjdk@11/11.0.27/libexec/openjdk.jdk/Contents/Home/lib/security`
    - Execute `keytool -import -alias wso2carbon -file wso2cert.pem -keystore cacerts` to import the WSO2 certificate.

## Run the Client
1. Build the project using `mvn clean install`
2. Run the client using the command `mvn compile exec:java -Dexec.mainClass="org.example.Main"`

You will see the response as below with the API Manager Version.

`
Raw XML Response:
<ns:getVersionResponse xmlns:ns="http://version.services.core.carbon.wso2.org"><return>WSO2 API Manager-3.2.1</return></ns:getVersionResponse>
`
