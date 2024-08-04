import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Maman 11, Berk Beri Bahar, 345445126
//colors 10 percent of a matrix randomly every time when pressed on the button
public class MatrixFx extends Application
{
	public void start(Stage stage) throws Exception
	{
		Parent root = (Parent)FXMLLoader.load(getClass().getResource("MatrixFx.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("MatrixFx");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String [] args)
	{
		launch(args);
		System.out.println();
	}
}