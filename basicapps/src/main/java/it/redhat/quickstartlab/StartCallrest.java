package it.redhat.quickstartlab;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class StartCallrest {

    public final static String GROUPID = "it.redhat.quickstartlab";
    public final static String ARTIFACT = "assets";
    public final static String VERSION = "1.0-SNAPSHOT";

    public static void main(String[] args) {
        System.out.println("\n\n\n");
        System.out.println("          ========> starting...");
		KieServices kieServices = KieServices.Factory.get();
        System.out.println("          ========> loading artifact from maven...");
		ReleaseId id = kieServices.newReleaseId(GROUPID, ARTIFACT, VERSION);
		KieContainer kieContainer = kieServices.newKieContainer(id);

        System.out.println("          ========> creating session...");
        KieSession ksession = kieContainer.newKieSession("labksession");
        ksession.getWorkItemManager().registerWorkItemHandler("Rest", new RESTWorkItemHandler());

        System.out.println("          ========> Starting process...");
        ksession.startProcess("assets.callrest");

        System.out.println("");
        System.out.println("          ========> Finish.");
        System.out.println("\n\n\n");
	}
}
