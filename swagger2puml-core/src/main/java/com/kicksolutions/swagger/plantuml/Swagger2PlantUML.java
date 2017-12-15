package com.kicksolutions.swagger.plantuml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.kicksolutions.swagger.plantuml.cliargs.CliArgs;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

/**
 * MSANTOSH
 * com.amdocs.catalogone.Swagger2PlantUML
 */
public class Swagger2PlantUML 
{
	private static final Logger LOGGER = Logger.getLogger(Swagger2PlantUML.class.getName());
	private static final String USAGE = new StringBuilder().append(" Usage: com.amdocs.catalogone.Swagger2PlantUML <options> \n")
			.append(" -i <spec file> ")
			.append(" -o <output directory> ").toString();
	
	public Swagger2PlantUML() {
		super();
	}
	
	/**
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
    	Swagger2PlantUML swagger2PlantUML = new Swagger2PlantUML();
    	swagger2PlantUML.init(args);   	
    }
    
    /**
     * 
     * @param args
     */
    private void init(String args[]){
    	LOGGER.entering(LOGGER.getName(), "init");
    	
    	CliArgs cliArgs = new CliArgs(args);
    	String specFile = cliArgs.getArgumentValue("-i", "");
    	String output = cliArgs.getArgumentValue("-o","");
    	boolean generateDefinitionModelOnly = Boolean.parseBoolean(cliArgs.getArgumentValue("generateDefinitionModelOnly","false"));
    	boolean includeCardinality = Boolean.parseBoolean(cliArgs.getArgumentValue("includeCardinality","true"));
    	
    	if(StringUtils.isNotEmpty(specFile) && StringUtils.isNotEmpty(output)){
    		transformSwagger2Puml(specFile, output,generateDefinitionModelOnly,includeCardinality);
    	}
    	else{
    		LOGGER.severe(USAGE);
    	}
    	
    	LOGGER.exiting(LOGGER.getName(), "init");
    }
    
    /**
     * 
     * @param specFile
     * @param output
     */
    private void transformSwagger2Puml(String specFile,String output,boolean generateDefinitionModelOnly,boolean includeCardinality){
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
    			generateUMLDiagram(pumlPath, targetLocation);
    			LOGGER.info("Sucessfully Create PUML !!!");
    		}
    		catch(Exception e){
    			LOGGER.log(Level.SEVERE, e.getMessage(),e);
    			System.exit(1);
    		}
    	}
    	else{
    		LOGGER.severe(USAGE);
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
    	LOGGER.entering(LOGGER.getName(), "generateUMLDiagram");
    	
    	net.sourceforge.plantuml.Run.main(new String[]{"-tsvg","-o",targetLocation.getAbsolutePath(),"-I",pumlLocation});
      	
    	LOGGER.log(Level.INFO, "Swagger2UML (Class Diagrams) were generated @" +targetLocation.getAbsolutePath());
    	
    	LOGGER.exiting(LOGGER.getName(), "generateUMLDiagram");
    }
}