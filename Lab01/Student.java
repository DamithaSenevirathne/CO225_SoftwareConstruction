
public class Student {
	private final String surname;
	private int attendance;
	static int totalLectures=45;
	Student(String surname,int attendance){
		this.surname=surname;
		this.attendance=attendance;
	}
	
	public float attendancePercentage(){
		return (100.0f*attendance)/totalLectures;
	}
	
	public static float attendancePercentage(Student[] ar){
		float totalAttendance=0;
		for(int i=0;i<ar.length;i++)totalAttendance+=ar[i].attendancePercentage();
		return totalAttendance/ar.length;
	}
	
	public String getSurname(){
		return surname;
	}
	
}
