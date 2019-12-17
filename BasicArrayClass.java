package p5_package;

public class BasicArrayClass
{
	/**
	 * Member data
	 */
	private int arrayCapacity;
	/**
	 * Member data
	 */
	private int	arraySize;
	/**
	 * Default constant capacity
	 */
	private static int	DEFAULT_CAPACITY = 10;
	/**
	 * Default failed access constant
	 */
	public static final int	FAILED_ACCESS = -999999;
	/**
	 * Constant used for allowing setAtIndex to insert value at index
	 */
	public static final int	INSERT_AFTER = 1003;
	/**
	 * Constant used for allowing setAtIndex to insert value at index
	 */
	public static final int	INSERT_BEFORE = 1002;
	private int[] localArray;
	/**
	 * Constant used for allowing accessAtIndex to remove an item
	 */
	public static final int	REMOVE = 1004 ;
	/**
	 * Constant used for allowing setAtIndex to replace value at index
	 */
	public static final int REPLACE = 1001;
	/**
	 * Constant used for allowing accessAtIndex to retrieve an item
	 */
	public static final int RETRIEVE = 1005;
/**
 * Default constructor, initializes array to default capacity
 */
	protected	BasicArrayClass()
	{
		arraySize = 0;
		arrayCapacity = DEFAULT_CAPACITY;
		localArray = new int[DEFAULT_CAPACITY];
	}
	/**
	 * Copy constructor, initializes array to size and 
	 * capacity of copied array, then copies only the elements up to the given size
	 * @param copied
	 */
	protected	BasicArrayClass(BasicArrayClass copied)
	{
		
		arraySize = copied.arraySize;
		arrayCapacity = copied.arrayCapacity;
		localArray = new int[arrayCapacity]; 
		int index;
		for (index = 0; index < arraySize; index++)
		{
			this.localArray[index] = copied.localArray[index];
		}
	}
	/**
	 * Initializing constructor, initializes array to specified capacity
	 * @param capacity - integer maximum capacity specification for the array
	 */
	protected	BasicArrayClass(int capacity)
	{
		arraySize = 0;
		arrayCapacity = capacity;
		localArray = new int[arrayCapacity];
	}
	/**
	 * Utility method used by getAtIndex and removeAtIndex 
	 * to access and possibly remove element depending on control code
	 * @param controlCode-  integer value with either RETRIEVE or REMOVE to control operations
	 * @param index integer index of element to be retrieved or removed
	 * @return integer value at element or FAILED_ACCESS if attempt to access data out of bounds
	 */
	private int	accessAtIndex(int controlCode, int index)
	{
		if (controlCode == RETRIEVE)
		{
			if (index < arraySize && index >= 0)
			{
			int atIndex = localArray[index];
			return(atIndex);
			}	
		}
		else if (controlCode == REMOVE)
		{
			if (index < arraySize && index >= 0)
			{
			int atIndex = localArray[index];
			while (index < arraySize-1)
			{
				localArray[index] = localArray[index+1];
				index++;
			}
			arraySize--;
			return (atIndex);
			}
		}
		return FAILED_ACCESS;
	}
	/**
	 * Description: Checks for need to resize; if this is necessary, creates new array with double the original 
	 * capacity, loads data from original array to new one, then sets localArray to new array
	 */
	protected void	checkForResize()
	{
		int index;
		if(arraySize == arrayCapacity)
		{
			arrayCapacity = arrayCapacity*2;
			int[] tempArray = new int[arrayCapacity];
			for(index=0; index <= arraySize-1; index++)
			{tempArray[index] = localArray[index];
				
			}
			localArray = tempArray;
		}
		
	}
	/**
	 * Clears array of all valid values by setting array size to zero, values remain in array but are not accessible
	 */
	protected void	clear()
	{
		arraySize = 0;
	}
	/**
	 * Accesses item in array at specified index if index within array size bounds
	 * @param accessIndex- integer index of requested element value
	 * @returninteger accessed value if successful, FAILED_ACCESS if not
	 */
	protected int getAtIndex(int accessIndex)
	{
		return accessAtIndex(RETRIEVE, accessIndex);
		
	}
	/**
	 * Description: Gets current capacity of array
	 * Note: capacity of array indicates number of values the array can hold
	 * @return integer capacity of array
	 */
	protected int getCurrentCapacity()
	{
		return arrayCapacity;
	}
	/**
	 * Description: Gets current size of array
	 * Note: size of array indicates number of valid or viable values in the array
	 * @return integer size of array
	 */
	protected int getCurrentSize()
	{
		return arraySize;

	}
	/**
	 * Tests for size of array equal to zero, no valid values stored in array
	 * @return Boolean result of test for empty
	 */
	protected boolean isEmpty()
	{
		return arraySize == 0;
	}
	/**
	 * Description: Removes item from array at specified index if index within array size bounds
	 * Note: Each data item from the element immediately above the remove index to the end of the array is moved down by one element
	 * Note: Calls accessAtIndex with REMOVE to conduct action
	 * @param removeIndex
	 * @return removed integer value if successful, FAILED_ACCESS if not
	 */
	protected int removeAtIndex(int removeIndex)
	{
			return accessAtIndex(REMOVE, removeIndex);
	}
	/**
	 * Description: sets item in array at specified index
	 * @param setIndex- integer index of element at which value is to be inserted
	 * @param newValue- integer value to be placed in array
	 * @param replaceFlag- integer flag to indicate insertion or replacement in the array
	 * @return Boolean success if inserted, or failure if incorrect index was used
	 */
	protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
	{
		int workingIndex;
		boolean finalFlag = false;
		if (replaceFlag == INSERT_BEFORE || replaceFlag == INSERT_AFTER)
		{
			if(arraySize == 0 && setIndex == 0)
				{
				localArray[0] = newValue;
				arraySize++;
				}
			
			if(setIndex>= 0 && setIndex< arraySize)
			{
				if (replaceFlag == INSERT_AFTER)
				{	
					workingIndex = setIndex+1;
				}
				else
				{
					workingIndex = setIndex;
				}
				int itIndex;
				checkForResize();
				for(itIndex = arraySize;itIndex > workingIndex; itIndex--)
				{
					 localArray[itIndex] = localArray[itIndex-1];
				}
					localArray[workingIndex] = newValue;
						arraySize++;
						checkForResize();
						finalFlag= true;
			}	
		}
			else
			{
				if (replaceFlag == REPLACE)
				{
					localArray[setIndex] = newValue;
					finalFlag = true;
				}
			}
		return finalFlag;
	}
}
