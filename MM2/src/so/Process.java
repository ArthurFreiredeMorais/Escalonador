package so;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AddressMemory;

public class Process {
	private int sizeInMemory;
	private String id;
	private AddressMemory am;
	
	private int numberOfInstructions;
	private List<String> subProcesses;
	private static int count;

	public Process(int sizeInMemory) {
		count++;
		this.id = "P" + count;
		this.sizeInMemory = sizeInMemory;
		this.subProcesses = this.getSubProcesses();

	}

	
	public int getSizeInMemory() {
		return sizeInMemory;
	}

	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AddressMemory getAm() {
		return am;
	}

	public void setAm(AddressMemory am) {
		this.am = am;
	}
	
	public List<String> getSubProcesses() {
		if(this.subProcesses == null || this.subProcesses.isEmpty()) {
			List<String> p = new LinkedList<>();
			for(int i = 0; i < this.getSizeInMemory(); i++) {
				p.add(this.getId());
			}
			this.subProcesses = p;
		}
		return this.subProcesses;
	}


}
