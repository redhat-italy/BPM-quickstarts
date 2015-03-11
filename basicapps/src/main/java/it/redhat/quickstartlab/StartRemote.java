package it.redhat.quickstartlab;

import org.kie.api.runtime.KieSession;
import org.kie.services.client.api.RemoteRestRuntimeFactory;
import org.kie.services.client.api.command.RemoteRuntimeEngine;

import java.net.MalformedURLException;
import java.net.URL;

public class StartRemote {
    public final static String GROUPID = "it.redhat.quickstartlab";
    public final static String ARTIFACT = "provisioninglab";
    public final static String VERSION = "1.0-SNAPSHOT";
    public final static String DEFINITION_ID = "provisioninglab.provisioning";
    private static final String BC_URL = "http://bpm.dev:8080/business-central/";
    private static final String USER = "andrea";
    private static final String PASSWORD = "password.1";

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("\n\n\n");
        System.out.println("          ========> starting...");

        RemoteRuntimeEngine engine = getRuntimeEngine();

        System.out.println("          ========> creating session...");
        KieSession ksession = engine.getKieSession();

        System.out.println("          ========> Starting process...");
        ksession.startProcess(DEFINITION_ID);

        System.out.println("");
        System.out.println("          ========> Finish.");
        System.out.println("\n\n\n");
    }

    private static RemoteRuntimeEngine getRuntimeEngine() {
        try {
            URL jbpmURL = new URL(BC_URL);
            String deployment_id = GROUPID + ":" + ARTIFACT + ":" + VERSION;
            RemoteRestRuntimeFactory remoteRestSessionFactory = new RemoteRestRuntimeFactory(deployment_id, jbpmURL, USER, PASSWORD);
            RemoteRuntimeEngine engine = remoteRestSessionFactory.newRuntimeEngine();
            return engine;
        } catch( MalformedURLException e ) {
            throw new IllegalStateException( "This URL is always expected to be valid!", e );
        }
    }
}