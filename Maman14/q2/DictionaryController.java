import java.net.URL;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DictionaryController implements Initializable
{
	private static final int SUCCESS = 1 , EMPTY = -1, FAILURE = 0;
	private int status = 0;
	private DictionaryObject dictionary = new DictionaryObject();
	private SortedSet<String> sortedWords = new TreeSet<String>();
	private String listWord, listMeaning;
	private String[] chosenWord = new String[2];
	
	@FXML
    private Text info;
	
    @FXML
    private TextField meaning;

    @FXML
    private Text printMeaning;

    @FXML
    private Text printWord;

    @FXML
    private TextField word;

    @FXML
    private ChoiceBox<String> wordsList;

    @FXML
    void addButtonClicked(ActionEvent event) 
    {
    	printWord.setText("");
    	printMeaning.setText("");
    	
    	int status = dictionary.addWord(word.getText(), meaning.getText());
    	
    	if(status == SUCCESS)
    	{
    		info.setText("Word successfully added!");
    		sortedWords.add(word.getText().toLowerCase().trim() +": " + meaning.getText().trim());
    		wordsList.getItems().clear();
    		wordsList.getItems().addAll(sortedWords);
    	}
    	else if(status == EMPTY)
    		info.setText("The word you entered is empty!");
    	else if(status == FAILURE)
    		info.setText("The word you entered already exists!");
    }

    @FXML
    void deleteButtonClicked(ActionEvent event)
    {
    	printWord.setText("");
    	printMeaning.setText("");
    	
    	if(dictionary.getDictionary().get(word.getText().toLowerCase().trim()) != null)
    		listMeaning = dictionary.getDictionary().get(word.getText().toLowerCase().trim()).trim();
    	int status = dictionary.deleteWord(word.getText());
    	
    	if(status == SUCCESS)
    	{
    		info.setText("Word successfully deleted!");
    		sortedWords.remove(word.getText().toLowerCase().trim() +": " + listMeaning);
    		wordsList.getItems().clear();
    		wordsList.getItems().addAll(sortedWords);
    	}
    	else if(status == FAILURE)
    		info.setText("The word you want to delete does not exist!");
    }

    @FXML
    void searchButtonClicked(ActionEvent event) 
    {
    	printWord.setText("");
    	printMeaning.setText("");
    	
    	int status = dictionary.searchWord(word.getText());
    	
    	
    	if(status == SUCCESS)
    	{
    		info.setText("Your word is:");
    		printWord.setText("Word: " + word.getText().toLowerCase());
    		printMeaning.setText("Meaning: " + dictionary.getDictionary().get(word.getText().toLowerCase()));
    	}
    	else
    		info.setText("The word you want to search does not exist!");
    }

    @FXML
    void updateButtonClicked(ActionEvent event)
    {
    	printWord.setText("");
    	printMeaning.setText("");
    	
    	if(dictionary.getDictionary().containsKey(word.getText().toLowerCase().trim()))
    	{
    		listWord = word.getText().toLowerCase().trim();
    		listMeaning = dictionary.getDictionary().get(listWord).trim();
    	}
    	
    	int status = dictionary.updateWord(word.getText(), meaning.getText());
    	
    	if(status == SUCCESS)
    	{
    		info.setText("Word successfully updated!");
    		sortedWords.remove(listWord +": " + listMeaning);
    		sortedWords.add(word.getText().toLowerCase().trim() +": " + meaning.getText().trim());
    		wordsList.getItems().clear();
    		wordsList.getItems().addAll(sortedWords);
    	}
    	else if(status == EMPTY)
    		info.setText("The word or meaning you entered is empty!");
    	else if(status == FAILURE)
    		info.setText("The word you want to update does not exist!");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		info.setText("Welcome to your dictionary!");
	}
}
