package so.scheduler;

import java.util.List;
import java.util.PriorityQueue;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;

public class SJS extends Scheduler {
	private PriorityQueue<SubProcess> queue;
	private int order;
	
	//se for 0 o de menor tempo terá maior prioridade
	// se for 1 o de maior tempo terá maior prioridade
	public SJS(int order) {
		super();
		this.order = order;
		
		Comparator<SubProcess>() c = new Comparator<SubProcess>() {
			@Override
			public int compare(SubProcess sp1, SubProcess sp2) {
				return sp1.getTimeToExecute()>= sp2.getTimetoExecute()
						?1: -1;
			}
		};
		this.queue = new PriorityQueue<>(c);
	}
	@Override
	public void execute(Process p) {
		List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
		for(SubProcess sp : sps) {
			this.queue.add(sp);
		}
		while(!this.queue.isEmpty()) {
			Core[] cores = this.getCm().getCores();
			for (int i = 0; i< cores.length; i++) {
				if(cores[i].getActuallySubProcess()== null) {
					this.getCm().registerProcess(i, this.queue.poll());
				}
			}
		}
	}
	
	@Override
	public void finish(Process p) {
		
	}
 
}
