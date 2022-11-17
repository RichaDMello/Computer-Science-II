import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure struct;
	
	public CourseDBManager()
	{
		struct = new CourseDBStructure(100);
	}
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		struct.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		if (input == null)
		{
			throw new FileNotFoundException();
		}
		else
		{
			Scanner reader = new Scanner(input);
			while (reader.hasNext())
			{
				String [] line = reader.nextLine().split(" ");
				add(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3], line[4]);
			}
		}
	}

	@Override
	public ArrayList<String> showAll() {
//		ArrayList<String> result = new ArrayList();
//		for (int i = 0; i < struct.showAll().size(); i++)
//		{
//			result.add("\n"+struct.showAll().get(i));
//		}
//		return result;
		return struct.showAll();
	}

	@Override
	public CourseDBElement get(int crn) {
		try
		{
			return struct.get(crn);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

}
