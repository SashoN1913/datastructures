package datastructures;

public class LinkedList<T> implements List 
{
	int index;
	Node<T> list;
	
	
	public LinkedList() 
	{
		this.index = 0;
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(list == null)
			return true;
		return false;
	}

	@Override
	public boolean contains(Object item) 
	{
		Node<T> currentValue = this.list;
		
		while(currentValue != null)
		{
			if (currentValue.data.equals(item))
			{
				return true;
			}
			currentValue = currentValue.next;
		}
		
		return false;
	}

	@Override
	public void add(Object item) 
	{
		Node<T> newNode = new Node<T>((T) item);
		
		if (this.isEmpty()) 
		{
			this.list = newNode;
		}
		
		else 
		{
			Node<T> temp = list;
			
			while (temp.next != null) 
			{
				temp = temp.next;
			}
			temp = (newNode);
		}
		
		this.index++;
		
	}

	@Override
	public void insertAt(Object item, int index) 
	{
		if (index == 0) 
		{
			Node<T> newList = new Node<>(list, (T) item);
			list = newList;
		}
		
		else 
		{
			int count = 0;
			Node<T> tempList = list;
			
			while (count < index) 
			{
				tempList = tempList.next;
				count++;
			}
			Node<T> nextTempList = tempList.next;
			Node<T> newItem = new Node<>(nextTempList, (T)item);
			tempList = (newItem);
		}
		
		this.index++;
	}

	@Override
	public void removeFrom(int index) 
	{
		if(list == null)
		{
			return;
		}
		
		Node<T> temp = list;
		
		if(index == 0)
		{
			list = temp.next;
			return;
		}
		
		for(int i = 0; i < index - 1; i++)
		{
			temp = temp.next;
		}
		
		Node<T> next = temp.next.next;
		temp.next = next;
	}

	@Override
	public void remove(Object item) 
	{
		Node<T> tempList = list;
		int tempIndex = index;
		
		if(contains(item))
		{
			while(tempList.data != item && tempList != null)
			{
				tempList = tempList.next;
				tempIndex --;
			}
			removeFrom(index);
		}
	}

	@Override
	public Object getIndex(int index) 
	{
		if (index < 0) 
		{
			throw new IllegalArgumentException("Index cannot be smaller than 0");
		}
		if (index > this.index) 
		{
			System.out.println("Index out of list bounds");
			index = this.index;
		}
		
		int tmp = 1;
		Node<T> tempList = list;
		
		while (tmp < index) 
		{
			if (tempList.next != null) 
			{
				tempList = tempList.next;
			}
			tmp++;
		}

		return tempList.data;
	}

	@Override
	public void clear() 
	{
		this.list = null;
	}
	
	public void print() 
	{
		int tempIndex = 0;
		
		Node<T> tempList = list;
		
		while (index < index) 
		{
			System.out.println(tempList.data);
			tempList = tempList.next;
			index++;
		}

	}
}
