package core;

public class Config {
    public enum ENV {QA, PROD}  // STAGE, DEV, etc.

    public String baseURI; //"http://localhost";
    public int port; // "8080";
    public String basePath; //  "/sqlrest";
    
    public void setupProdEnvironment() {     // PROD
    	baseURI		= "http://thomas-bayer.com";
    	port		= 80;
    	basePath	="sqlrest";
	}
    
    public void setupIntEnvironment() {     //QA
    	baseURI		= "http://localhost";
    	port		= 8080;
    	basePath	="sqlrest";
	}
    
	public Config(ENV environment){
		System.setProperty("env", environment.toString());
		pickEnvironment();
	}

	public Config(){
		pickEnvironment();
	}

	 void pickEnvironment(){
		ENV env = ENV.valueOf(System.getProperty("env", "qa").toUpperCase());
		//System.out.println(env);
		 switch(env){
			case QA: setupIntEnvironment();
				break;

			case PROD: setupProdEnvironment();
				break;

			default:
				break;
		}
	}
	
	
    
}
