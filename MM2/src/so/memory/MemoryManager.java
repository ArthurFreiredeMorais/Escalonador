package so.memory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import so.Process;
import so.SubProcess;

public class MemoryManager {
	private SubProcess[][] physicMemory;
	private Hashtable<String, FrameMemory> logicalMemory;
	private int pageSize;
	
	public static int INSTRUCTIONS_PER_PROCESS = 7;


	public MemoryManager(int pageSize, int physicalMemorySize) {
		int pages = physicalMemorySize/pageSize;
		this.physicMemory = new SubProcess[pages][pageSize];
		this.logicalMemory = new Hashtable<String, FrameMemory>();
		this.pageSize = pageSize;
	}
	
	public MemoryManager() {
		this(4, 256);
	}

	public void write(Process p) {
//		if (this.strategy.equals(Strategy.FIRST_FIT)) {
//			this.writeWithFirstFit(p);
//
//		} else if (this.strategy.equals(Strategy.BEST_FIT)) {
//			this.writeWithBestFit(p);
//
//		} else if (this.strategy.equals(Strategy.WORST_FIT)) {
//			this.writeWithWorstFit(p);
//
//		} else if (this.strategy.equals(Strategy.PAGING)) {
			this.writeWithPaging(p);
		}

	private void writeWithPaging(Process p) {
		List<FrameMemory> frames = this.findFramePages(p);
		int spaces = (int) Math.ceil((p.getSubProcesses().size() / this.pageSize));
		List<String> subProcessesIds = p.getSubProcesses();
		if (spaces <= frames.size() ) {
			int spIndex = 0;
			for (int i = 0; i < spaces; i++ ) {
				FrameMemory fm = frames.get(i);
				for (int j = 0; j < this.pageSize; j++) {
					if(spIndex < p.getSubProcesses().size()) {
						SubProcess sp = new SubProcess(subProcessesIds.get(spIndex),
								INSTRUCTIONS_PER_PROCESS);
						this.physicMemory[fm.getPageNumber()][j] = sp;
						fm.setDisplacement(j);
						this.logicalMemory.put(sp.getId(), fm);
						spIndex++;
						
					} else {
						break;
					}
				}
				
				}
		} else {
			System.out.println("Page Fault");
		}
		
		
 	} 
	
	
	private List<FrameMemory> findFramePages (Process p) {
		List<FrameMemory> frames = new LinkedList<>();
		for (int i = 0; i < this.physicMemory.length; i++) {
			if (this.physicMemory[i][0] == null) {
				frames.add(new FrameMemory(i, 0));
				
			
			
			}
		}
	
	return frames;
		
	}


	public void delete(Process P) {
		
	}

	public void printMemoryStatus() {
		for(int i = 0; i < physicMemory.length; i++) {
			for (int j = 0; j < physicMemory[i].length; j++) {
				SubProcess sp = this.physicMemory[i][j];
				String spId = null;
				if(sp!= null) {
					spId = sp.getId();
					
				}
				if (j == this.physicMemory[i].length - 1) {
					System.out.println(spId);
				} else {
					System.out.println(spId + " | ");
				}
			}
		}
	}
	
	public List<SubProcess> read(Process p) {
		List<String> spsIds = p.getSubProcesses();
		List<SubProcess> sps = new LinkedList<>();
		for(String spId : spsIds ) {
			// pma = physical memory address
			//Endereço da memória física recuperado através da memória lógica
			FrameMemory pma = this.logicalMemory.get(spId);
			sps.add(this.physicMemory[pma.getPageNumber()][pma.getDisplacement()]);
		}
		return sps;
		
	}
	
	
	
	}

