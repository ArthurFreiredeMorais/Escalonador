package so.cpu;

import so.SubProcess;

public class Core implements Runnable {
	private int id;
	private int numberOfInstructionPerClock;
	private SubProcess actuallySubProcess;
	private int numberOfInstructionsExecuted;
	
	public Core (int numberOfInstructionPerClock, int id) {
		this.numberOfInstructionPerClock = numberOfInstructionPerClock;
		
	}
	
	public Core (int id) {
		this(id, 7);
	}

	@Override
	public void run() {
		this.numberOfInstructionsExecuted += numberOfInstructionPerClock;
		if (this.numberOfInstructionsExecuted >= actuallySubProcess.getInstructions()) {
			this.finishSubProcess();		}
		
	}

	private void finishSubProcess() {
		this.actuallySubProcess = null;
		this.numberOfInstructionsExecuted = 0;
		
	}

	public SubProcess getActuallySubProcess() {
		return actuallySubProcess;
	}

	public void setActuallySubProcess(SubProcess actuallySubProcess) {
		this.actuallySubProcess = actuallySubProcess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
