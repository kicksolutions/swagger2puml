package com.kicksolutions.swagger.plantuml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlantUMLGeneratorTest {

  private PlantUMLGenerator generator = new PlantUMLGenerator();

  private static final String DEFAULT_PLANT_UML_FILENAME = "swagger.puml";

  // TODO - setup - remove the generated files if they exist


  @Test
  @DisplayName("Basic Petstore test")
  void test_generatePetStorePlantUml() {
    String specFile = "src/test/resources/petstore/swagger.yaml";
    String outputPath = "src/test/resources/petstore";
    boolean generateDefinitionModelOnly = false;
    boolean includeCardinality = true;
    boolean generateSvg = false; // TODO - this is to generate the svg image file but it doesn't work correctly as a
    // test

    generator.transformSwagger2Puml(specFile, outputPath, generateDefinitionModelOnly, includeCardinality, generateSvg);

    assertTrue(new File(outputPath + "/" + DEFAULT_PLANT_UML_FILENAME).exists(), "Expect PlantUML file to be generated");
  }


  @Test
  @DisplayName("Petstore test with inheritance")
  void test_generatePetStorePlantUml_withInheritance() {
    String specFile = "src/test/resources/petstore_with_inheritance/swagger.yaml";
    String outputPath = "src/test/resources/petstore_with_inheritance";
    boolean generateDefinitionModelOnly = false;
    boolean includeCardinality = true;
    boolean generateSvg = false; // TODO - this is to generate the svg image file but it doesn't work correctly as a
    // test

    generator.transformSwagger2Puml(specFile, outputPath, generateDefinitionModelOnly, includeCardinality, generateSvg);

    assertTrue(new File(outputPath + "/" + DEFAULT_PLANT_UML_FILENAME).exists(), "Expect PlantUML file to be generated");
  }

}