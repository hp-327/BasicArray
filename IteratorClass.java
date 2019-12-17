package p5_package;

public class IteratorClass extends BasicArrayClass
{
	/**
	 * Current index of iterator
	 */
	private int	currentIndex;
	/**
	 * Constant character for display
	 */
	private char LEFT_BRACKET = '[';
	/**
	 * Constant character for display
	 */
	private char RIGHT_BRACKET = ']';
	/**
	 * Constant character for display
	 */
	private char SPACE = ' ';
	/**
	 * Default constructor for IteratorClass
	 */
	public IteratorClass()
	{
		super();
		currentIndex = 0;
	}
	/**
	 * Initialization constructor for IteratorClass
	 * @param initCapacity - integer value at which to set initial array capacity
	 */
	public IteratorClass(int initCapacity)
	{
		super(initCapacity);
		currentIndex = 0;
	}
	/**
	 * Copy constructor for IteratorClass
	 * @param copied- IteratorClass object to be copied
	 */
	public IteratorClass(IteratorClass copied)
	{
		super(copied);
		currentIndex = 0;
	}
	/**
	 * Clears array
	 * Overrides: clear in class BasicArrayClass
	 */
	public void clear()
	{
		super.clear();
	}
	/**
	 * Gets value at iterator cursor location
	 * @return integer value returned; FAILED_ACCESS if not found
	 */
	int	getAtCurrent()
	{
		return (getAtIndex(currentIndex));
	}
	/**
	 * Reports if iterator cursor is at beginning
	 * Must consider whether list is empty
	 * @return Boolean result of action; true if at beginning, false otherwise
	 */
	public boolean isAtBeginning()
	{
		return (currentIndex == 0 && getCurrentSize()>0);
	}
	/**
	 * Reports if iterator cursor is at end
	 * Must consider whether list is empty
	 * @return Boolean result of action; true if at end, false otherwise
	 */
	public boolean isAtEnd()
	{
		return (currentIndex == getCurrentSize()-1 && !isEmpty() );
	}
	/**
	 * Reports if list is empty
	 * Overrides:isEmpty in class BasicArrayClass
	 * Returns: Boolean result of action; true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return (super.isEmpty());		
	}
	/**
	 * If possible, moves iterator cursor one position to the right, or next
	 * Must consider whether list is empty
	 * @return Boolean result of action; true if successful, false otherwise
	 */
	public boolean moveNext()
	{
		if (!isAtEnd())
		{
			currentIndex = currentIndex+1;
			return true;
		}
		return false;
	}
	/**
	 * If possible, moves iterator cursor one position to the left, or previous
	 * Must consider whether list is empty
	 * @return Boolean result of action; true if successful, false otherwise
	 */
	public boolean movePrev()
	{
		if (!isAtBeginning())
		{
			currentIndex = currentIndex-1;
			return true;
		}
		return false;
	}
	/**
	 * Removes and returns a data value from the iterator cursor position
	 *  Note: cursor must be located at succeeding element unless last item removed
	 * @return integer value removed from list, or FAILED_ACCESS if not found
	 */
	public int removeAtCurrent()
	{
		int removed = removeAtIndex(currentIndex);
		if (!isEmpty())
			{
			currentIndex++;
			return removed;
			}
		return FAILED_ACCESS;
		
		}	
	/**
	 * Replaces value at iterator cursor with new value
	 * @param newValue- integer value to be inserted in list
	 * @return Boolean result of action; true if successful, false otherwise
	 */
	public boolean	replaceAtCurrent(int newValue)
	{
		return setAtIndex(currentIndex, newValue, REPLACE);
		
	}
	/**
	 * Shows space-delimited list with cursor location indicated
	 */
	public void runDiagnosticDisplay()
	{
		int tempIndex;
		for (tempIndex = 0; tempIndex < getCurrentSize(); tempIndex++)
		{
			if (tempIndex > 0)
			{
				System.out.print(SPACE);
			}
			if (tempIndex ==(currentIndex))
			{
				System.out.print( LEFT_BRACKET );
				System.out.print(getAtIndex( tempIndex ));
				System.out.print(RIGHT_BRACKET);
			}
			else
			{
				System.out.print(getAtIndex( tempIndex ) );
			}	
		}
		System.out.println();
	}
	/**
	 * Inserts new value after value at iterator cursor
	 * @param newValue
	 * @return
	 */
	public boolean	setAfterCurrent(int newValue)
	{
		boolean result = setAtIndex(currentIndex, newValue, INSERT_AFTER);
		if(getCurrentSize()!=0)
		{
			currentIndex--;	
		}
		return result;		
	}
	/**
	 * Inserts new before value at iterator cursor
	 * Note: Current value must remain the same after data set
	 * @param newValue - integer value to be inserted in list
	 * @returnBoolean result of action; true if successful, false otherwise
	 */
	public boolean setBeforeCurrent(int newValue)
	{
		boolean result = setAtIndex(currentIndex, newValue, INSERT_BEFORE);
		if(getCurrentSize()!=0)
		{
			currentIndex++;
		}	
		return result;
	}
	
	/**
	 * Sets iterator cursor to beginning of list
	 * @return Boolean result of action; true if successful, false otherwise
	 */
	public boolean setToBeginning()
	{
		if (!isEmpty())
		{
		currentIndex = 0;
		return true;
		}
		return false;
		}
	/**
	 * Sets iterator cursor to the end of the list
	 * @return Boolean result of action; true if successful, false otherwise
	 */
	public boolean setToEnd()
	{
		if (!isEmpty())
		{
			currentIndex = getCurrentSize()-1;
			return true;
		}
			return false;
	}
}

