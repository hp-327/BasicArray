package p5_package;

public class StackClass
{
	private BasicArrayClass	stackData;
	/**
	 * Stack default constructor
	 */
	public StackClass()
	{
		stackData= new BasicArrayClass();
	}
	/**
	 * Stack initialization constructor
	 * @param capacitySetting  integer value for setting initial capacity of array
	 */
	public StackClass(int capacitySetting)
	{
		stackData= new BasicArrayClass(capacitySetting);
	}
	/**
	 * Copy constructor
	 * @param copied StackClass object to be copied
	 */
	public StackClass(StackClass copied)
	{
		stackData= new BasicArrayClass(copied.stackData);
	}
	/**
	 * Clears stack
	 */
	void clear()
	{
		stackData.clear();
	}
	/**
	 * Displays stack
	 */
	void displayStack()
	{
		int index;
		System.out.print("Stack Bottom ->");
		for(index = 0; index < stackData.getCurrentSize(); index++)
		{
			System.out.print(stackData.getAtIndex(index));
			if (index != stackData.getCurrentSize()-1)
			{
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	/**
	 * Reports stack empty status
	 * @return Boolean evidence of empty list
	 */
	boolean	isEmpty()
	{
		return stackData.isEmpty();
	}
	/**
	 * provides peek at top of stack
	 * @return value if successful, FAILED_ACCESS if not
	 */
	int	peekTop()
	{
		if (!isEmpty())
		{	
			int size= stackData.getCurrentSize()-1;
			return (stackData.getAtIndex(size));
		}
		else
		{
			return BasicArrayClass.FAILED_ACCESS;
		}
	}
	/**
	 * Removes and returns data from top of stack
	 * @return value if successful, FAILED_ACCESS if not
	 */
	int	pop()
	{
		if (!isEmpty())
		{	
			int size= stackData.getCurrentSize()-1;
			return (stackData.removeAtIndex(size));
		}
		else
		{
			return BasicArrayClass.FAILED_ACCESS;
		}
	}
	/**
	 * Places data item on top of the stack
	 * @param newVal- integer value to pushed onto stack
	 */
	void push(int newVal)
	{
		
		int size = stackData.getCurrentSize();
		if(size == 0)
		{
		stackData.setAtIndex(size, newVal, BasicArrayClass.INSERT_AFTER);
		}
		else
		{
			stackData.setAtIndex(size-1, newVal, BasicArrayClass.INSERT_AFTER);
		}
	}
}

