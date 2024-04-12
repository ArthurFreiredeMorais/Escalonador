package so;

public class SubProcess {
	private int instructions;
	private String id;
	private int timeToExecute;
	public int getTimeToExecute() {
		return timeToExecute;
	}
	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	private static int count;
	private String processId;
	
	public SubProcess (String processId, int instructions) {
		count++;
		this.id = processId + count;
		this.processId = processId;
		this.instructions = instructions;
		
		
	}
	public int getInstructions() {
		return instructions;
	}
	public void setInstructions(int isntructions) {
		this.instructions = isntructions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
}
