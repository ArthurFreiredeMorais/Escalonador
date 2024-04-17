package so.cpu;



import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import so.SubProcess;

public class CpuManager {
    private Core[] cores;
    public static int CLOCK = 500;
    public static int NUMBER_OF_INSTRUCTIONS_BY_CLOCK = 7;
    public static int NUMBER_OF_CORES = 4;
    private Scheduler scheduler;

    public CpuManager(Scheduler scheduler) {
        this.cores = new Core[CpuManager.NUMBER_OF_CORES];

        for (int index = 0; index < this.cores.length; index++) {
            this.cores[index] = new Core(index, CpuManager.NUMBER_OF_INSTRUCTIONS_BY_CLOCK);
        }
        this.scheduler = scheduler;
        this.runClock();
    }

    private void runClock() {
        new Thread(() -> {
            while (true) {
                executeCores();
                try {
                    Thread.sleep(CpuManager.CLOCK);
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
        }).start();
    }

    private void executeCores() {
    	int count = 0;
        SubProcess data = null;
        for (Core core : cores) {
            data = this.scheduler.execute();
            if (data != null) {
                if (core.getSubProcess() == null) {
                    core.setSubProcess(data);
                    core.run();
                    count++;
                    if (this.scheduler != null && count == 4) {
                    	if (this.scheduler.getQuantumTable() != null) {
                    		
                    		if (this.scheduler.getQuantumTable().get(data.getProcess().getId()) != 0) {        			
                    			System.out.println(this.scheduler.getQuantumTable().get(data.getProcess().getId()));
                    		}
                    	}
                	}
                }
            }
        }

        if (data != null) {
        	System.out.println(" ");
            System.out.println("##############################################");
            System.out.println(" ");
        }
    }
}
	
	public void clock () {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run () {
				executeProcesses();
			}
			
		},0, CLOCK);
	}
	
	private void executeProcesses() {
		for(Core core: this.cores) {
			if(core.getActuallySubProcess() != null) {
				core.run();
			}
		}
	}
	
	public Core[] getCores(){
		return this.cores;
		
	}
		
}
