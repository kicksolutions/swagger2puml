# Swagger2Puml

Swagger to Puml convertion tool helps to generate Class Diagrams from Swagger Definition.
To know more about Plant UML Click [plantuml]

## Swagger2puml-core: 

This utility takes Swagger Yaml as input and as response it generates swagger.puml and swagger.svg files as output.

Below is the Sample Class Diagram which gets generated.
To see the generated PUML file, please click [here](examples/swagger.puml)

![Swagger-Class-Diagram-Sample](examples/swagger.svg)

### Usage:

```
com.kicksolutions.swagger.plantuml.Swagger2PlantUML [options]

-i {Path of Swagger Definition (Can be either Yaml or json)}
-o {Target location where Puml File and Image should generated}
- generateDefinitionModelOnly {true/flase Defult False (Optional)}
- includeCardinality {true/flase Defult true (Optional)}
```

## Swagger2puml-maven

This Maven plugin is Mojo, which internally calls swagger2puml-core to generate swagger.puml and swagger.svg for given Swagger Definition.
Swagger Definition can be either yaml or json extensions.

License
----

Apacahe 2.0

[plantuml]: <https://github.com/plantuml/plantuml>
[swagger]: <https://swagger.io/>
[swagger-parser]: <https://github.com/swagger-api/swagger-parser>
