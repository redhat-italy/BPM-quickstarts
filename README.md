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


##weblab


#Building the projects

To build you need maven

~~~
mvn clean package
~~~