package so;

public class Execute {
	public static void main(String[] args) {
		while(!SystemOperation.scheduler.isEmpty()) {
			Process p1 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 50);
			SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, p1);
			
			System.out.println("\n******************************************************************");
			

			Process p2 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 25);
			SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, p1);
			
			System.out.println("\n******************************************************************");
			

			Process p3 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 28);
			SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, p1);
			
			System.out.println("\n******************************************************************");
		}
		
		
		
		

//		Process p1 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(50, "P1"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
//		Process p2 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(20, "P2"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2);
//		Process p3 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(30, "P3"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
//		Process p4 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(27, "P4"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p4);
//		Process p5 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(1, "P5"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p5);
//		SystemOperation.systemCall(SystemCallType.CLOSE_PROCESS, p2);
//		SystemOperation.systemCall(SystemCallType.CLOSE_PROCESS, p4);
//		Process p6 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(1, "P6"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p6);
//		Process p7 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(1, "P7"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p7);
//		Process p8 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(22, "P8"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p8);
//		Process p9 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(17, "P9"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p9);
//		Process p10 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(1, "P10"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p10);
//		Process p11 = SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, new Process(1, "P11"));
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p11);
//
//		
	}

}
