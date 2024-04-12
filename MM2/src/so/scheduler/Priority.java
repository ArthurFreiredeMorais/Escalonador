package so.scheduler;

import java.util.List;
import java.util.PriorityQueue;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;

public class Priority extends Scheduler {
	private PrioritytQueue<SubProcess> queue;
	private int order;
	
	public Priority(int order) {
		super();
		this.order = order;
		
		Comparator<SubProcess>() c = new Comparator<SubProcess>() {
			@Override
			public int compare(SubProcess sp1, SubProcess sp2) {
				return 0;
			}
		};
		this.queue = new PriorityQueue<>(c);
	}
	
	@Override
	public void execute(Process p) {
		List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
		
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub
		
	}

}
