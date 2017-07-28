# scala-play-example
This example shows how to read configuration from configuration files

####  Defining configuration  
      Play uses default configration file application.conf. You can also define different configuration files
      as configuration for your database. and include this in your application.conf
      For defining configuration play uses the Typesafe config library. 
      You can access the defined configuration values by injecting Configuration object.
      It has all the methods to support default types like int, string, boolean etc.
       
     But by using ConfigLoader you can define your custom types. In the example DbConfig is the example of custom object  
      
