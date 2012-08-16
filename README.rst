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
  		<groupId>com.devbliss.gwtlib</groupId>
  		<artifactId>gwtlib</artifactId>
  		<version>0.1</version>
	</dependency>

The jar file corresponding to the given version is hosted on `our intern nexus <http://nexus.vz.net/index.html#nexus-search;quick~gwtlib>`_.

Installation
============

First of all, you have to check out the project::

	git clone git@github.com:devbliss/gwtlib.git
	cd gwtlib.git
	mvn install
	
Then, import it as maven project in your IDE.

To build a new release, you have to first update manually the CHANGES.rst file with the new version number, and then use the maven release plugin to create and upload the jar::

	mvn release:prepare && release:perform