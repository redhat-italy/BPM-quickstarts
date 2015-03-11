package it.redhat.quickstartlab;

import it.redhat.quickstartlab.model.Sample;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class First {

    public final static String GROUPID = "it.redhat.quickstartlab";
    public final static String ARTIFACT = "rules";
    public final static String VERSION = "1.0-SNAPSHOT";

    public static void main(String[] args) {
        System.out.println("\n\n\n");
        System.out.println("          ========> starting...");
		KieServices kieServices = KieServices.Factory.get();
        System.out.println("          ========> loading artifact from maven...");
		ReleaseId id = kieServices.newReleaseId(GROUPID, ARTIFACT, VERSION);
		KieContainer kieContainer = kieServices.newKieContainer(id);

        System.out.println("          ========> inserting facts...");
        System.out.println("");
        KieSession ksession = kieContainer.newKieSession("labksession");
        for (int i=0; i<50; i++){
            System.out.print(".");
            ksession.insert(new Sample());
            ksession.fireAllRules();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // reset the interrupt.
                Thread.currentThread().interrupt();
            }

        }
        ksession.dispose();
        System.out.println("");
        System.out.println("          ========> Finish.");
        System.out.println("\n\n\n");
	}
}
