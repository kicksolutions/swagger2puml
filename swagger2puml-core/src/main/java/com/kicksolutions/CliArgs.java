package com.kicksolutions;

import java.util.HashMap;

/**
 */
public class CliArgs {

    private String[] args = null;

    private HashMap<String, String> parsedCliArguments = new HashMap<String, String>();
    
    public CliArgs(String[] args){
        parse(args);
    }

    public void parse(String[] arguments){
        this.args = arguments;
        parsedCliArguments.clear();
            
        for(int i=0; i < args.length; i++) {
            if(args[i].startsWith("-") ){
            	parsedCliArguments.put(args[i], args[i+1]);
            }
        }
    }

    public String[] args() {
        return args;
    }

    public String arg(int index){
        return args[index];
    }

    public boolean isArgumentPresent(String argument) {
        return parsedCliArguments.containsKey(argument);
    }

    public String getArgumentValue(String argument, String defaultValue) {
    	if(!isArgumentPresent(argument)){
    		return defaultValue;
    	}
    	else{
    		return parsedCliArguments.get(argument);
    	}
    }
}