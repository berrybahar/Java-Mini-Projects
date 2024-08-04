import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MatrixFxController 
{

    @FXML
    private Canvas canv;
    private GraphicsContext gc; 

    public void initialize()
    {
    	gc = canv.getGraphicsContext2D();
    }
    
    @FXML
    void btnClicked(ActionEvent event) 
    {
    	gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
    	double canvHeight = canv.getHeight() - 1;
    	double canvWidth = canv.getWidth() - 1;
    	Random random = new Random();
    	
    	int lineCount = 0;
    	
    	//drawing lines and counting how many lines are there
    	for(int i = 0; i <= canvWidth; i += 10)
    	{
    		gc.strokeLine(i, 0, i, canvHeight);
    		gc.strokeLine(0, i, canvWidth, i);
    		lineCount++;
    	}
    	
    	int rectCount = (lineCount - 1) * (lineCount - 1); // the number of elements in the matrix
    	int rectsToColor = rectCount / 10;//the number of boxes needed to to be colored
    	
    	int [][] blackRects = new int[rectsToColor][2];//matrix for knowing which boxes in the matrix color
    	boolean isSame = false;
    	blackRects[0][0] = random.nextInt(0, lineCount - 1);
    	blackRects[0][1] = random.nextInt(0, lineCount - 1);
    	
    	for(int i = 0; i < blackRects.length; i++)
    	{
    		for(int j = 0; j < 2; j++)
    		{
    			blackRects[i][j] = random.nextInt(0, lineCount - 1);//putting randomly indexes for the box to be colored
    		}
    		
    		//checking if the box added last is at the same place with any added box in the array
    		for(int k = 0; k < i; k++)
    		{
    			if((blackRects[k][0] == blackRects[i][0]) && (blackRects[k][1] == blackRects[i][1]))//if the two boxes are the same
    			{
    				isSame = true;
    				while(isSame)
    				{
    					for(int j = 0; j < 2; j++)
    		    		{
    		    			blackRects[i][j] = random.nextInt(0, lineCount - 1);//putting randomly indexes for the box to be colored
    		    		}
    					if(!((blackRects[k][0] == blackRects[i][0]) && (blackRects[k][1] == blackRects[i][1])))//if the two boxes are not the same
    						isSame = false;
    				}
    			}
    		}
    	}
    	
    	//coloring the boxes
    	for(int j = 0; j < blackRects.length; j++)
    	{
    		gc.setFill(Color.BLACK);
        	gc.fillRect((blackRects[j][0] * 10), (blackRects[j][1] * 10), 10, 10);
    	}
    	
    }

}