package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.scheduler.FCFS;
import so.scheduler.Scheduler;

public class SystemOperation {
	public static MemoryManager mm;
	public static Scheduler scheduler;

	public static Process systemCall(SystemCallType type, int processSize) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (mm == null) {
				mm = new MemoryManager();
			}
			if (scheduler == null) {
				scheduler = new FCFS();
			}
		}
		return new Process(processSize);
			
	}
	
	public static List<SubProcess> systemCall(SystemCallType type, Process p) {

		if (type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
			scheduler.execute(p);

		} else if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			scheduler.finish(p);
			mm.delete(p);
		} else if (type.equals(SystemCallType.READ_PROCESS)) {
			mm.read(p);
		}		
		return null;

	}

}
