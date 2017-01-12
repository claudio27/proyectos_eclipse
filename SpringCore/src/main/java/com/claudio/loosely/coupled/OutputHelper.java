package com.claudio.loosely.coupled;

public class OutputHelper {
	
	IOutputGenerator outputGenerator;
// Se borra el constructor para que se encargue Spring de
//	instanciar
	public OutputHelper(IOutputGenerator outputGenerator){
//		outputGenerator = new CsvOutputGenerator();
		this.outputGenerator = outputGenerator;
	}

	public void generateOutput(){
		outputGenerator.generateOutput();
	}
	
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}

}
