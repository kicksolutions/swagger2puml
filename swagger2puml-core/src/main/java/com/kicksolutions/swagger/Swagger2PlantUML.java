package com.kicksolutions.swagger;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.kicksolutions.CliArgs;
import com.kicksolutions.swagger.plantuml.PlantUMLGenerator;

/**
 * MSANTOSH
 *
 */
public class Swagger2PlantUML 
{
	private static final Logger LOGGER = Logger.getLogger(Swagger2PlantUML.class.getName());
	private static final String USAGE = new StringBuilder().append(" Usage: com.kicksolutions.swagger.plantuml.Swagger2PlantUML <options> \n")
			.append(" -i <spec file> ")
			.append(" -o <output directory> ")
			.append(" -generateDefinitionModelOnly true/false; Default=false ")
			.append(" -includeCardinality true/false; Default=true ")
			.append(" -generateSvg true/false; Default=true ").toString();
	
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
    	boolean generateDefinitionModelOnly = Boolean.parseBoolean(cliArgs.getArgumentValue("-generateDefinitionModelOnly","false"));
    	boolean includeCardinality = Boolean.parseBoolean(cliArgs.getArgumentValue("-includeCardinality","true"));
    	boolean generateSvg = Boolean.parseBoolean(cliArgs.getArgumentValue("-generateSvg", "true"));
    	
    	if(StringUtils.isNotEmpty(specFile) && StringUtils.isNotEmpty(output)){
    		process(specFile, output,generateDefinitionModelOnly,includeCardinality,generateSvg);
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
    private void process(String specFile,String output,boolean generateDefinitionModelOnly,boolean includeCardinality,boolean generateSvg){
    	PlantUMLGenerator generator = new PlantUMLGenerator();
    	generator.transformSwagger2Puml(specFile, output, generateDefinitionModelOnly, includeCardinality, generateSvg);
    }    
}