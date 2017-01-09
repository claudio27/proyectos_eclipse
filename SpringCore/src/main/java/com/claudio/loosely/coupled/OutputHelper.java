package com.claudio.loosely.coupled;

import com.claudio.loosely.coupled.impl.CsvOutputGenerator;

public class OutputHelper {
	
	IOutputGenerator outputGenerator;
// Se borra el constructor para que se encargue Spring de
//	instanciar
	public OutputHelper(){
		outputGenerator = new CsvOutputGenerator();
	}

	public void generateOutput(){
		outputGenerator.generateOutput();
	}
	
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}

}
