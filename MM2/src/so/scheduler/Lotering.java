package so.scheduler;

import java.util.List;

import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;

public class Lotering extends Scheduler {

	@Override
	public void execute(Process p) {
		List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
		
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub
		
	}

}
