import java.util.HashMap;
import java.util.TreeMap;

public class DictionaryObject 
{
	private HashMap<String, String> dictionary;
	private TreeMap<String, String> sortedDictionary;
	
	public DictionaryObject()
	{
		dictionary = new HashMap<String, String>();
		sortedDictionary = new TreeMap<String, String>();
	}
	
	public TreeMap<String, String> getDictionary()
	{
		return sortedDictionary;
	}
	
	public int addWord(String word, String meaning)
	{
		if(sortedDictionary.containsKey(word.toLowerCase().trim())) 
			return 0;
		else if(word.trim().isEmpty() || meaning.trim().isEmpty())
			return -1;
		
		dictionary.put(word.toLowerCase().trim(), meaning.trim());
		sortedDictionary.clear();
		sortedDictionary.putAll(dictionary);
		
		return 1;
	}
	
	public int deleteWord(String word)
	{
		if(!sortedDictionary.containsKey(word.toLowerCase().trim()))
			return 0;
		
		dictionary.remove(word.toLowerCase().trim());
		sortedDictionary.remove(word.toLowerCase().trim());
		
		return 1;
	}
	
	public int updateWord(String word, String meaning)
	{
		if(!sortedDictionary.containsKey(word.toLowerCase().trim()))
			return 0;
		
		this.deleteWord(word.toLowerCase().trim());
		return this.addWord(word.toLowerCase().trim(), meaning.trim());
	}
	
	public int searchWord(String word)
	{
		if(!sortedDictionary.containsKey(word.toLowerCase().trim()))
			return 0;
		
		return 1;
	}
	
}
