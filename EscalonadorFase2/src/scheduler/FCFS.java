package scheduler;

import java.util.Comparator;
import java.util.List;

import process.SystemOperation;
import process.SOProcess;
import process.SubProcess;
import process.SystemCallType;

public class FCFS extends SchedulerQueue {
    public FCFS() {
		super(new Comparator<SOProcess>() {
			@Override
			public int compare(SOProcess process1, SOProcess process2) {
				return -1;
			}
			
		});
	}

	public void addProcess(SOProcess process) {
        this.queueProcess.add(process);

        List<SubProcess> subProcesses = SystemOperation.systemCall(SystemCallType.READ, process);

        for (SubProcess sp : subProcesses) {
            this.queueSubProcesses.add(sp);
        }
    }

    public SubProcess execute() {
    	if (this.queueProcess != null && this.queueSubProcesses != null) {
    		
    		this.queueProcess.poll();
    		SubProcess element = this.queueSubProcesses.poll();
    		
    		if (element != null) {
    			return element;
    		} 
    	}
    	return null;
    }
}