package scheduler;


import java.util.Map;

import process.SOProcess;
import process.SubProcess;
import cpu.CpuManager;

public abstract class Scheduler {
    private CpuManager cpuManager;

    public Scheduler() {
        this.cpuManager = new CpuManager(this);
    }

    public abstract void addProcess(SOProcess process);
    public abstract SubProcess execute();
    public abstract void close(SOProcess process);

    public CpuManager getCpuManage() {
        return this.cpuManager;
    }
    
    public abstract Map<String, Integer> getQuantumTable();
}