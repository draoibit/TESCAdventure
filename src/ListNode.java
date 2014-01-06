package TESCAdventure;

public class ListNode<T>
{
	ListNode<T> mNext;
	T mVal;
	
	public ListNode(T val)
	{
		this.mVal = val;
		this.mNext = null;
	}
}
