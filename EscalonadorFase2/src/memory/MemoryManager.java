package memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import process.SubProcess;
import process.SOProcess;


public class MemoryManager {
    public List<SubProcess[]> physicMemory;
    private Map<String, MemoryAddress> logicMemory;

    public static final int PAGE_SIZE = 4;
    public static final int MEMORY_SIZE = 256;

    public MemoryManager() {
        int quantityPages = MEMORY_SIZE / PAGE_SIZE;

        physicMemory = new ArrayList<>(quantityPages);
        for (int frame = 0; frame < quantityPages; frame++) {
            physicMemory.add(new SubProcess[PAGE_SIZE]);
        }

        logicMemory = new HashMap<>();
    }

    public List<SubProcess> read(SOProcess process) {
        List<SubProcess> subProcesses = new ArrayList<>();

        for (String subProcessIdSelected : process.getSubProcess()) {
        	MemoryAddress addressSubProcess = logicMemory.get(subProcessIdSelected);

            if (addressSubProcess != null && physicMemory.get(addressSubProcess.getFrame())[addressSubProcess.getIndexPage()] != null) {
                subProcesses.add(physicMemory.get(addressSubProcess.getFrame())[addressSubProcess.getIndexPage()]);
            }
        }

        return subProcesses;
    }

    public void write(SOProcess process) {
    	writeProcessWithPaging(process);
    }

    public boolean checkWrite(SOProcess process) {
        List<Integer> emptyFrames = findEmptyPages();
        return emptyFrames.size() >= (double)process.getSize() / PAGE_SIZE;
    }

    private List<Integer> findEmptyPages() {
        List<Integer> framesIndex = new ArrayList<>();

        for (int frame = 0; frame < physicMemory.size(); frame++) {
            SubProcess[] element = physicMemory.get(frame);

            if (element[0] == null) {
                framesIndex.add(frame);
            }
        }

        return framesIndex;
    }

    private void writeProcessWithPaging(SOProcess process) {
        List<Integer> emptyFrames = findEmptyPages();

        int countSize = 0;
        for (Integer indexFrame : emptyFrames) {
            SubProcess[] page = physicMemory.get(indexFrame);

            int indexPage = 0;
            while (indexPage < page.length && countSize < process.getSize()) {
                String subProcessId = process.getSubProcess().get(countSize);

                physicMemory.get(indexFrame)[indexPage] = new SubProcess(subProcessId, process);

                logicMemory.put(subProcessId, new MemoryAddress(indexFrame, indexPage));

                countSize++;
                indexPage++;
            }
        }

        printMemory();
    }

    public SOProcess delete(SOProcess process) {
        List<String> subProcess = process.getSubProcess();

        for (SubProcess[] page : physicMemory) {
            if (page[0] != null && page[0].getProcess().getId().equals(process.getId())) {
                for (int i = 0; i < page.length; i++) {
                    page[i] = null;
                }
            }
        }

        for (String sb : subProcess) {
            logicMemory.remove(sb);
        }

        printMemory();

        return process;
    }

    private void printMemory() {
        System.out.println("#################################################################");
        System.out.println(" ");
        System.out.println("************************* C H E C K   M E M O R Y **************************");
        System.out.println(" ");
        for (SubProcess[] page : physicMemory) {
            for (SubProcess subProcess : page) {
                System.out.print("| ID : " + (subProcess != null ? subProcess.getId() : null) + " | ");
            }
            System.out.println();
        }
    }
}