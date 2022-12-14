/**
 * 
 * @author Richa D'Mello
 *
 */
public class Road implements Comparable<Road>{

	private String roadName;
	private Town destination;
	private Town source;
	private int weight;
	
	public Road(Town source, Town destination, int degrees, String name)
	{
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.roadName = name;
	}
	
	public Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.roadName = name;
		this.weight = 1;
	}
	
	@Override
	public int compareTo(Road o) 
	{
		return this.getWeight() - o.getWeight();
	}
	
	public int getWeight() {
		return this.weight;
	}

	public boolean contains(Town town)
	{
		if (this.source.equals(town) || this.destination.equals(town))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return source + " to " + destination + " via " + getName();
	}

	public
	String getName() 
	{
		return this.roadName;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Road road = (Road) o;
		if (this.source.equals(road.source) || this.source.equals(road.destination) 
				&& (this.destination.equals(road.destination) || (this.destination.equals(road.source)) && (this == road)))
		{
			return true;
		}
		return false;
	}
	
	
	public Town getSource() {
		return source;
	}

	public void setSource(Town source) {
		
		this.source = source;
	}

	public Town getDestination() {
		return destination;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}
	
	
}
