package it.redhat.quickstartlab;

import it.redhat.quickstartlab.model.Sample;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class FirstWithScanner {

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

        System.out.println("          ========> adding scanner to container...");
        KieScanner scanner = kieServices.newKieScanner(kieContainer);
        scanner.start(5000);

        System.out.println("          ========> inserting facts...");
        System.out.println("");
        for (int i=0; i<80; i++){
            System.out.print(".");
            KieSession ksession = kieContainer.newKieSession("labksession");
            ksession.insert(new Sample());
            ksession.fireAllRules();
            ksession.dispose();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                // reset the interrupt.
                Thread.currentThread().interrupt();
            }

        }
        System.out.println("");
        System.out.println("          ========> Finish.");
        System.out.println("\n\n\n");
	}
}
