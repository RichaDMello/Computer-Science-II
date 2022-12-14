/**
 * 
 * @author Richa D'Mello
 *
 */
public class Town implements Comparable<Town>{

	String name;
	
	public Town(String townName)
	{
		this.name = townName;
	}
	
	public Town(Town templateTown)
	{
		this.name = templateTown.getName();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public boolean equals(Object o)
	{
		Town town = (Town) o;
		return ((this.name.toLowerCase().equals(town.getName().toLowerCase())) || this == town);
	}
	
	@Override
	public int hashCode()
	{
		int hash = this.name.hashCode();
		return hash;
	}
	
	@Override
	public String toString()
	{
		return this.getName();
	}
	
}
