# MapStruct demo with Spring and Lombok

It becomes so easy to map Java Beans when using MapStruct, especially in combination with Lombok.

This demo project shows:

* Project setup (Maven libraries and compiler config)
* Specifying default parameters in pom.xml (e.g. constructor injection)

* How to define a mapper interface
* How to map classes where the field names match
* How to map classes where the field names are different
* Using another mapper inside a mapper (to map another class)
* Mapping collections and handling null collections
* Automatically creating a reverse mapping

Simply look through the data classes and the corresponding mappers. There are some notes explaining the usage.
Each mapper has a corresponding test to show the expected behaviour.

## Generated mappers
After a successful build, you can simply read the code that was generated for your mappers. There is an "Impl" class for each of your mapper interfaces!

## Troubleshooting
Occasionally, when changing the Maven pom.xml file, you may have to run `mvn clean install` to force the mappers to be generated again.

## References
The most helpful resource is of course the official MapStruct documentation: https://mapstruct.org/documentation/stable/reference/html/
