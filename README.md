# guppy-gae

A lightweight web platform in clojure for the Google App Engine (GAE).

## Installation

Clone into the `guppy-gae` repository from a directory of your choice:

    $ git clone https://github.com/gneissguise/guppy-gae

If you don't already have the GAE SDK installed, then you will need to download and install it:

    https://cloud.google.com/sdk/docs/
   
Once you've cloned into the repository, you will need to create a `.war` file:

    $ lein ring uberwar

Then create a `war/` directory and extract the contents of the `.war` file to it:

    $ mkdir -p target/war
    $ cd target/war
    $ jar -xvf ../uberjar/guppy-gae-0.1.0-SNAPSHOT-standalone.war

Copy the `appengine-web.xml` from the project's `resources/` directory:

    $ cp ../../resources/appengine-web.xml WEB-INF/

Edit `WEB-INF/appengine-web.xml` and add your Google application info:

    $ emacs WEB-INF/appengine-web.xml

    ``` xml
    <?xml version="1.0" encoding="utf-8"?>
    <appengine-web-app xmlns="http://appengine.google.com/ns/1.0">
        <application>_your_app_id_</application><!-- unused for Cloud SDK based tooling -->
  	<version>alpha-001</version><!-- unused for Cloud SDK based tooling -->
  	 <threadsafe>true</threadsafe>
  	 <runtime>java8</runtime><!-- required for ring-servlet library --> 
    </appengine-web-app>
    ```

Now you should be all set to test!

## Testing

From the project's `target/war` directory, run `dev_appserver.sh`:

    $ cd target/war
    $ dev_appserver.sh .

You should see something like this in your console:

    ```
    Executing [/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java, -D--enable_all_permissions=true, -Duse_jetty9_runtime=true, -Dfile.encoding=UTF-8, -classpath, /home/user/.appengine/appengine-java-sdk-1.9.60/lib/appengine-tools-api.jar, com.google.appengine.tools.development.DevAppServerMain, --property=kickstart.user.dir=/home/user/Documents/clojure/guppy-gae/target/war, --no_java_agent, /home/user/Documents/clojure/guppy-gae/target/war/.]
    2018-01-15 20:37:53.936:INFO::main: Logging initialized @971ms
    2018-01-15 20:37:54.095:INFO:oejs.Server:main: jetty-9.3.18.v20170406
    2018-01-15 20:37:54.593:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=405ms
    2018-01-15 20:37:56.009:INFO:oejsh.ContextHandler:main: Started c.g.a.t.d.j.DevAppEngineWebAppContext@35787726{/,file:///home/user/Documents/clojure/guppy-gae/target/war/,AVAILABLE}{/home/user/Documents/clojure/guppy-gae/target/war}
    2018-01-15 20:37:56.013:INFO:oejs.AbstractConnector:main: Started NetworkTrafficSelectChannelConnector@6f6cc7da{HTTP/1.1,[http/1.1]}{localhost:8080}
    2018-01-15 20:37:56.013:INFO:oejs.Server:main: Started @3049ms
    Jan 16, 2018 3:37:56 AM com.google.appengine.tools.development.AbstractModule startup
    INFO: Module instance default is running at http://localhost:8080/
    Jan 16, 2018 3:37:56 AM com.google.appengine.tools.development.AbstractModule startup
    INFO: The admin console is running at http://localhost:8080/_ah/admin
    Jan 15, 2018 8:37:56 PM com.google.appengine.tools.development.DevAppServerImpl doStart
    INFO: Dev App Server is now running
    ```

Success! Now fire up your browser and navigate to `http://localhost:8080/`

## Deployment

To deploy to your google cloud, go to your project's `target/war` directory and run the following command:

    $ appcfg.sh upload .

Now you're cooking with fire!

## License

Copyright © 2018 Justin Frost (gneissguise)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
