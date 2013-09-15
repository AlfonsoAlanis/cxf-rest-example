cxf-rest-example
================

Simple CXF rest example. Uses APache CXF implementation for JAX-RS webservice. Builds a WAR file for deployment.


Building and running
====================

Requires maven >= 3.0.4, JDK >= 1.7


Build with and get a **WAR** in *target/*
~~~
    $ mvn clean install
~~~

Run embedded jetty:
~~~
    $ mvn clean jetty:run
~~~


Working on REST client
======================

The main entry point should be **src/main/webapp/index.html**.
Put your **JavaScript, CSS and images ** under *src/main/webapp/assets*.

 Enjoy!
