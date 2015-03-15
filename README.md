# BPM-quickstarts

A set of BPM Suite 6 Labs used at the RH SKO FY16 Quickstart technical session

The quickstarts are indipendent projects that you can build separately. Suggestion is to build them in the suggested order because some of them are dependencies of others. And because they follow a path accordingly with the slides of the SKO session.

The Quickstarts consist of the following projects:

##datamodel 
Imagine a company where you are working for, making a demo, implementing a Proof Of Concept or collaborating with your consultant collegues in a GPS delivery project.
Imagine the company wants to have different development teams for different topics, so for example a team that works on datamodel design and implementation, a team that works on basic common assets (rules & processes) and other teams working on end user applications.

The **datamodel** quickstart project has the purpose of demonstrating this kind of approach.
Just build it with command:

`mvn clean install`

that's all for this project, it just simulate that some group in the company is working to a Data Model project and has released the 1.0-SNAPSHOT version of the the project, it contains some simple Java Object to be used in the following applications.

##rules     
Like the previous project this one simply contains a set of rules, and uses *datamodel* as dependency. It simulates that another group in the company designs and implements this kind of assets.
Again, just build with command

`mvn clean install`

##assets
As well as the previous two this project simulates the development of the last asset we need, processes, it contains a couple of simple processes to be started in the following labs. Build and install like you did for the previous.

##basicapps 
So finally we can use assets. This project contains some standalone java application that starts the engine and works with knowledge base. Build using the command:

`mvn clean package`

then to execute the labs use the command:

`mvn exec:java -Dexec.mainClass="it.redhat.quickstartlab.SomeJavaClass"`

where, of course, substitute *SomeJavaClass* with the correct main you want to run like for example *First*.

I suggest the following order:

###First
Creates a KnowledgeBase pulling the set of rules defined in the *rules* project, then put 50 facts in the session using objects defined in the *datamodel* project and fires the rules. Running the lab you should see that the app loads the required artifacts from the repository (in this case your local .m2 directory) a sort of progress bar (text points) and occasionally a printout that the fact passed the filter, something like

`Found a sample passing the filter with id: 1426418938355 and size: 4`

###FirstWithScanner
Same of *First* but adds the Scanner to the container, so the application is able to apply new rules in case of update. To use this lab follow these instructions:

1. run the FirstWithScanner java app with the above command;
2. while FirstWithScanner is running open your preferred IDE, open the rules project and modify the value of the sample size that filters samples (for example change it from 5 to 40);
3. build and install the modified ruleset;
4. look at the FirstWithScanner logs, you should see that the artifact is reloaded from the repository and more samples now pass the filter.

###StartSimple
Similar to *First*, in this case you start a simple process loaded from the *assets* artifact.

###StartCallRest
Same of *StartSimple* with the only difference that the loaded process has a Service Task which calls an external system using a REST connection.

In this lab pay attention to the code statement where a Work Item Handler is added to the session (using the work item manager):

`ksession.getWorkItemManager().registerWorkItemHandler("Rest", new RESTWorkItemHandler());`

If you comment that line and run again you will see that the engine will raise an exception

##mocks
A web application with a REST service to be used with *basicapps.StartCallRest* lab.

1. build the app with `mvn clean package`
2. start a fresh JBoss EAP instance (hopefully different from BPMS running instance);
3. deploy the created web app copying the **mocks.war** package from target directory to the deployments directory of your JBoss EAP instance.

##weblab
A web application with no services that you can use to connect with a business-central installation.

1. build the app with `mvn clean package`
2. deploy the created web app copying the **weblab.war** package from target directory to the deployments directory of your JBoss EAP instance.

#Building the projects

To build the projects you need Maven, probably everyone of us has maven already installed on his laptop, so to run the labs you just a matter of executing a couple of commands in terminal.

Don't forget to download the EAP 6.1.1 and BPMS 6.0.3 maven repositories from our Customer Portal software download and configure your settings.xml in your .m2 directory.

In case you experience some problems try to use the provided **settings.xml** that you can find in the root directory of these labs.

Here it is an example of command that you can use if the simple mvn clean install doesn't work properly.
 
`mvn clean install -Deap.repo.path=file:///Users/andrea/worklab/java/jboss-eap-6.1.1.GA-maven-repository -Dbpm.repo.path=file:///Users/andrea/worklab/java/jboss-brms-6.0.3-redhat-6-maven-repository -s ../settings.xml`

that's all
happy coding with BPM Suite!