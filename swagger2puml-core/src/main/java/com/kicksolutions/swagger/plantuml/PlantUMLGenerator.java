package com.kicksolutions.swagger.plantuml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

/**
 * MSANTOSH
 *
 */
public class PlantUMLGenerator 
{
	private static final Logger LOGGER = Logger.getLogger(PlantUMLGenerator.class.getName());
	
	public PlantUMLGenerator() {
		super();
	}
	    
    /**
     * 
     * @param specFile
     * @param output
     */
    public void transformSwagger2Puml(String specFile,String output,boolean generateDefinitionModelOnly,boolean includeCardinality,boolean generateSvg){
    	LOGGER.entering(LOGGER.getName(), "transformSwagger2Puml");
    	
    	File swaggerSpecFile = new File(specFile);
    	File targetLocation = new File(output);
    	
    	if(swaggerSpecFile.exists() && !swaggerSpecFile.isDirectory() 
    			&& targetLocation.exists() && targetLocation.isDirectory()) { 
    		
    		Swagger swaggerObject = new SwaggerParser().read(swaggerSpecFile.getAbsolutePath());
    		PlantUMLCodegen codegen = new PlantUMLCodegen(swaggerObject, targetLocation, generateDefinitionModelOnly, includeCardinality);
    		String pumlPath = null;
    		
    		try{
    			LOGGER.info("Processing File --> "+ specFile);
    			pumlPath = codegen.generatePuml();    		
    			LOGGER.info("Sucessfully Create PUML !!!");
    			
    			if(generateSvg)
    			{
    				generateUMLDiagram(pumlPath, targetLocation);
    			}
    		}
    		catch(Exception e){
    			LOGGER.log(Level.SEVERE, e.getMessage(),e);
    			throw new RuntimeException(e);
    		}
    	}else{
    		throw new RuntimeException("Spec File or Ouput Locations are not valid");
    	}
    	
    	LOGGER.exiting(LOGGER.getName(), "transformSwagger2Puml");
    }
    
    /**
     * 
     * @param pumlLocation
     * @param targetLocation
     * @throws IOException
     * @throws InterruptedException
     */
    private void generateUMLDiagram(String pumlLocation,File targetLocation) throws IOException, InterruptedException{
    	net.sourceforge.plantuml.Run.main(new String[]{"-tsvg","-o",targetLocation.getAbsolutePath(),"-I",pumlLocation});
    }
}