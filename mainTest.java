//import Pattern;
public class mainTest {
	
	public static void main(String[] args)
	{
		String password = "Yellow8*";
//		String [] temp = password.split("");
//		for (String a : temp)
//		{
//			if (a.matches("[^\\w]"))
//			{
//				System.out.println("true");
//				System.out.println(a);
//				break;
//			}
//			else
//			{
//				System.out.println("false");
//				System.out.println(a);
//			}
//		}
//		try {
//			System.out.println(PasswordCheckerUtility.isValidPassword(password));
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		//System.out.println(password.matches(".*\\d.*"));
		try
		{
			System.out.println(PasswordCheckerUtility.isValidPassword(password));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		//pattern=re.compile(r'[0-9]+');
	//k=re.findall(pattern,string);
	//		    if len(k)!=0:
	//		        return(sorted(k))
	//		    else:
	//		        return('None')
			        		
			       		
	}
	

}
