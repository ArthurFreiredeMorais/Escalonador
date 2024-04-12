package so.scheduler;

import java.util.PriorityQueue;
import so.Process;

public class SchedulerQueue extends Scheduler{
	private PriorityQueue<Process> queue;
	
	public SchedulerQueue(){
		this.queue = new PriorityQueue<>();
	}

	@Override
	public void execute(java.lang.Process p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(java.lang.Process p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
