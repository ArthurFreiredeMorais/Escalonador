package so.scheduler;

import java.util.List;
import java.util.PriorityQueue;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;
import so.Process;

public class FCFS extends SchedulerQueue {
	
	public FCFS() {
		super();
	}
	
	@Override
	public void  execute(Process p);{
		List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
		for(SubProcess sp : sps) {
			this.queue.add(sp);
		}
		Core[] cores = this.getCm().getCores();
		for (int i = 0; i< cores.length; i++) {
			if(cores[i].getActuallySubProcess()== null) {
				this.getCm().registerProcess(i, this.queue.poll());
			}
		}
	}
	@Override
	public void  finish(Process p);{
		
	}

}
