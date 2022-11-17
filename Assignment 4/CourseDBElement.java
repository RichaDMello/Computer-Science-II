/**
 * 
 * @author Richa D'Mello
 *
 */
public class CourseDBElement implements Comparable{
	
	String id;
	int crn;
	int credits;
	String roomNum;
	String instructor;

	@Override
	public int compareTo(Object o) {
		CourseDBElement temp = (CourseDBElement) o;
		if (this.crn == temp.crn)
		{
			return 0;
		}
		else if (this.crn > temp.crn)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * Contructor for the CourseDBElement class that sets the id, crn, credits, roomNum and instructor
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		super();
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	/**
	 * @return the id of the courseDBElement
	 */
	public String getID() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setID(String id) {
		this.id = id;
	}

	/**
	 * @return the crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * @param crn the crn to set
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * @return the roomNum
	 */
	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString()
	{
		return "Course:" + this.id + " CRN:" + this.crn + " Credits:" + this.credits + " Instructor:" + this.instructor + " Room:" + this.roomNum;
	}

}
