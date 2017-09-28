import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Main {
	static int N=61;
	static Student[] students=new Student[N];
	public static void main(String[] args) {
		String[] studentNames;
		try{
			studentNames=readNames("co225-classlist.txt", N);
		}
		catch(IOException e){
			System.out.println("Error while reading the names");
			System.out.println(e.toString());
			return;
		}
		
		Random randomGenerator=new Random();
		for(int i=0;i<N;i++){
			students[i]=new Student(studentNames[i], randomGenerator.nextInt(Student.totalLectures+1));
		}
		
		displayLowAttendanceStudents(80f,students);

	}
	
	private static void displayLowAttendanceStudents(float requiredAttendance,Student[] ar){
		for(int i=0;i<ar.length;i++){
			if(ar[i].attendancePercentage()<requiredAttendance){
				System.out.println(ar[i].getSurname());
			}		
		}
	}	
		
	
	private static String[] readNames(String fileName,int noOfNames) throws IOException{
		BufferedReader descriptor = null; 
		String line = null; 
		String [] names = new String[noOfNames];
		try { 
		    descriptor = new BufferedReader(
				    new FileReader(fileName));

		    for(int i=0; i < names.length; i++) 
			names[i] = descriptor.readLine(); 

		    descriptor.close(); 

		} catch(IOException e) { 
		    throw e; 
		}
		return names;
	}
	
}
