General
=======

The **gwtlib** contains general gwt-items which can be used in all devbliss gwt projects. An item can be:

*  a feature
*  a widget
*  an interface
*  everything that can be reused in other projects...

Each item is implemented, documented and tested so that it can be used directly in your project.

Utilisation
===========
You just need to add the **gwtlib** project as dependency in your maven project.
Copy the following lines with the correct version number::

    <dependency>
        <groupId>com.devbliss.gwt</groupId>
        <artifactId>commons</artifactId>
        <version>0.1</version>
    </dependency>

The jar file corresponding to the given version is hosted on `our intern nexus <http://nexus.vz.net/index.html#nexus-search;quick~gwtlib>`_.

Do not forget to introduce the lib to your GWT application's module MY_APP_MODULE.gwt.xml::

    <module>
        <inherits name="com.devbliss.gwt.commons.Commons" />
    </module>


Importing the lib java- and *.ui.xml code should work know.

Building with the lib as dependency on 3rd party machines
=========================================================
Since this library is not public accessible via the devbliss nexus, 3rd parties can not pull this dependency.
If customers build devbliss products on their own, you have to provide/add a copy of the jar to your source code.
This maybe done like that:

* create a lib folder in your maven projects root folder
* create the folder tree of the namespace, artifact id and version of the jar. Exmpl.: <PROJECTROOT>/lib/com/devbliss/gwt/commons/0.1-SNAPSHOT
* copy the jar to the created folder

Than you need to add the folders as new repository to your projects pom::

    <repositories>
        <repository>
            <id>lib</id>
            <name>lib</name>
            <releases>
                <enabled>true</enabled>
                <checksumPolicy>ignore</checksumPolicy>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <url>file://${project.basedir}/lib</url>
        </repository>
    </repositories>


As last step you have to define the lib as a dependeny in the dependencies section::

    <dependencies>
        <!-- devliss gwtlib -->
        <dependency>
            <groupId>com.devbliss.gwt</groupId>
            <artifactId>commons</artifactId>
             <version>0.1</version>
        </dependency>
    </dependencies>

Installation
============

First of all, you have to check out the project::

	git clone git@github.com:devbliss/gwtlib.git
	cd gwtlib.git
	mvn install
	
Then, import it as maven project in your IDE.

To build a new release, you have to first update manually the CHANGES.rst file with the new version number, and then use the maven release plugin to create and upload the jar::

	mvn release:prepare && release:perform