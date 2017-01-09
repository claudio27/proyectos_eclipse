package com.claudio.hilos;

import java.util.Date;

public class Tareal extends Thread{
	
	public Tareal(String msg) {
		super(msg);
	}
	
	@Override
	public void run() {
		System.out.println("Tareal.run()" + this.getName() +", id "+ this.getId());
		try {
			System.out.println("durmiendo " + new Date());
			sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("desperto " + new Date());
		
	}

}
