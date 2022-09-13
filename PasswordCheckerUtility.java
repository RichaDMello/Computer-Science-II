import java.util.ArrayList;

/**
 * Password Checker Utility defines the methods running the Password Checker GUI
 * @author Richa D'Mello
 *
 */
public class PasswordCheckerUtility {
	
	/**
	 * Compares two passwords. If they match, it returns true. Otherwise, it throws an UnmatchedException if the two passwords do not match.
	 * @param password The password in the form of a String
	 * @param passwordConfirm The second password with which the first one is compared.
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if (!(password.equals(passwordConfirm)))
		{
			throw new UnmatchedException();
		}
		else
		{
			System.out.println("The passwords match");
		}
	}
	
	/**
	 * Compares the equality of two passwords.
	 * @param password The password in the form of a String
	 * @param passwordConfirm The second password with which the first one is compared.
	 * @return true if they match, false if they do not.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if (password.equals(passwordConfirm)) 
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if the password contains 6 to 9 characters
	 * @param password The password in the form of a String
	 * @return true if they are between 6 and 9 characters long, false otherwise.
	 */
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if (password.length() < 6 || password.length() > 9)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the password contains a numeric character
	 * @param password The password in the form of a String
	 * @return true if the password has a digit
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		if (password.matches(".*\\d.*") == false)
		{
			throw new NoDigitException();
		}
		return true;
	}
	
	/**
	 * Checks if the password contains at least one lowercase alpha character
	 * @param password The password in the form of a String
	 * @return true if password has lower case alphabet, else
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		String[] temp = password.split("");
		for (String a : temp)
		{
			if (a.matches("[a-z]"))
			{
				return true;
			}
		}
		throw new NoLowerAlphaException();
		
	}
	
	/**
	 * Checks if the password contains a Special Character
	 * @param password The password in the form of a String
	 * @return true if the password has a special character
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		String[] temp = password.split("");
		for (String a : temp)
		{
			if (a.matches("[^\\w]"))
			{
				return true;
			}
		}
		throw new NoSpecialCharacterException();
		
	}
	
	/**
	 * Checks if the password contains an upper case alpha character
	 * @param password The password in the form of a String
	 * @return true if the password has an upper case letter
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		String[] temp = password.split("");
		for (String a : temp)
		{
			if (a.matches("[A-Z]"))
			{
				return true;
			}
		}
		throw new NoUpperAlphaException();
		
	}
	
	/**
	 * Checks if the password is at least 6 characters long
	 * @param password The password in the form of a String
	 * @return true if the password has at least 6 characters.
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException
	{
		if (password.length() < 6)
		{
			throw new LengthException();
		}
		return true;
	}
	
	/**
	 * Checks the password against all the requirements at once.
	 * @param p The password in the form of a String
	 * @return true if the password passes all the requirements
	 * @throws NoDigitException
	 * @throws NoLowerAlphaException
	 * @throws NoSpecialCharacterException
	 * @throws NoUpperAlphaException
	 * @throws LengthException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String p) throws NoDigitException, NoLowerAlphaException, NoSpecialCharacterException, NoUpperAlphaException, LengthException, InvalidSequenceException
	{
//		if (hasBetweenSixAndNineChars(p) && hasDigit(p) && hasLowerAlpha(p) && hasSpecialChar(p) && hasUpperAlpha(p) && isValidLength(p))
//		{
//			return true;
//		}
//		return false;
		
//		if (!(hasBetweenSixAndNineChars(p)))
//		{
//			return false;
//		}
//		if (!(hasDigit(p)))
//		{
//			throw new NoDigitException();
//		}
//		if (!(hasLowerAlpha(p)))
//		{
//			throw new NoLowerAlphaException();
//		}
//		if (!(hasSpecialChar(p)))
//		{
//			throw new NoSpecialCharacterException();
//		}
//		if (!(hasUpperAlpha(p)))
//		{
//			throw new NoUpperAlphaException();
//		}
//		if (!(isValidLength(p)))
//		{
//			throw new LengthException();
//		}
//		return true;
		
		if (isValidLength(p))
		{
			return hasDigit(p) && hasUpperAlpha(p) && hasLowerAlpha(p) && hasSpecialChar(p) && NoSameCharInSequence(p);
		}
		return false;
		
	}
	
//	public static boolean isWeakPassword(String password) throws WeakPasswordException
//	{
//		if (isValidPassword(password) && !(hasBetweenSixAndNineChars(password))) throw new NoDigitException(), NoLowerAlphaException(), NoSpecialCharException(), NoUpperAlphaException(), LengthException
//		{
//			return false;
//		}
//		return true;
//	}
	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password The password in the form of a String
	 * @return false if the password has more than nine  characters and is a valid password
	 * @throws WeakPasswordException
	 */
	static boolean isWeakPassword(String password) throws WeakPasswordException
    {
        try
        {
            if (!(hasBetweenSixAndNineChars(password)) && isValidPassword(password))
                return false;
        }
        catch (Exception e)
        {
            throw new WeakPasswordException();
        }
        throw new WeakPasswordException();
    }
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of any invalid passwords (weak passwords are not considered invalid).
	 * @param passwords An ArrayList of multiple string passwords.
	 * @return an ArrayList of the invalid passwords and their exceptions
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) 
	{
		ArrayList<String> invalid = new ArrayList<String>();
		
		for (int i = 0; i < passwords.size(); i++)
		{
			try {
				isValidPassword(passwords.get(i));
			}
			catch(Exception e)
			{
				invalid.add(passwords.get(i) + " -> " + e.getMessage());
			}
		}
		return invalid;
	}
	
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password The password in the form of a String
	 * @return true if the password does not have more than 2 of the same characters in a sequence.
	 * @throws InvalidSequenceException
	 */
	static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
    {
        for (int i = 1; i < password.length() - 1; i++)
        {
            if ((password.charAt(i) == password.charAt(i-1)) && (password.charAt(i+1)==password.charAt(i)))
                throw new InvalidSequenceException();
        }
        return true;
    }

}
