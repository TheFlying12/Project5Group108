package prj5;

import java.awt.Color;
import java.io.FileNotFoundException;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.text.DecimalFormat;

public class VisualizerWindow {
    // used to get data
    private DataReader numbers;
    // buttons to represent each state
    private Button DC;
    private Button GA;
    private Button VA;
    private Button NC;
    private Button TN;
    private Button MD;
    // quit operations
    private Button quitButton;
    // different types of sorting for each state
    private Button sortByAlpha;
    private Button sortByCFR;
    // window
    public Window window;
    // shapes to visualize percents
    private LinkedList<Shape> ratioViz;
    // textShapes for the race labels
    private LinkedList<TextShape> raceLabels;
    // textShapes for the CFR percentage labels
    private LinkedList<TextShape> CFRLabels;
    // positioning fields for each shape and bar
    private int x0 = 150;
    private int y0 = 230;
    // placeholder string to remember what state was called
    private String stateRemember;
    // assist with CFR and Alpha sorting
    private StateCalculator calc;

    private static final Color COLOR = Color.ORANGE;
    private static final int WIDTH = 25;

    public VisualizerWindow(String args) throws FileNotFoundException {
        window = new Window();
        // initialize quit function with button

        sortByAlpha = new Button("Sort By Alpha");
        sortByAlpha.onClick(this, "alphaSort");
        this.window.addButton(sortByAlpha, WindowSide.NORTH);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.NORTH);

        sortByCFR = new Button("Sort By CFR");
        sortByCFR.onClick(this, "cfrSort");
        this.window.addButton(sortByCFR, WindowSide.NORTH);

        // initialize buttons for state data representation
        DC = new Button("Represent DC");
        DC.onClick(this, "DCRep");
        this.window.addButton(DC, WindowSide.SOUTH);

        GA = new Button("Represent GA");
        GA.onClick(this, "GARep");
        this.window.addButton(GA, WindowSide.SOUTH);

        VA = new Button("Represent VA");
        VA.onClick(this, "VARep");
        this.window.addButton(VA, WindowSide.SOUTH);

        NC = new Button("Represent NC");
        NC.onClick(this, "NCRep");
        this.window.addButton(NC, WindowSide.SOUTH);

        TN = new Button("Represent TN");
        TN.onClick(this, "TNRep");
        this.window.addButton(TN, WindowSide.SOUTH);

        MD = new Button("Represent MD");
        MD.onClick(this, "MDRep");
        this.window.addButton(MD, WindowSide.SOUTH);

        numbers = new DataReader(args);
        ratioViz = new LinkedList<Shape>();
        raceLabels = new LinkedList<TextShape>();
        CFRLabels = new LinkedList<TextShape>();

    }


    /**
     * 
     * @param stateName
     *            uses name of state to build shapes to represent the state
     */
    public void buildShapes(String stateName) {
        DecimalFormat deci = new DecimalFormat();
        clearWindow();
        ratioViz.clear();
        raceLabels.clear();
        CFRLabels.clear();

        int stateIndex = 0;
        for (int i = 0; i < numbers.getStates().size(); i++) {
            if (numbers.getStates().get(i).getName().equals(stateName)) {
                stateIndex = i;
                break;
            }
        }
        for (int j = 0; j < numbers.getStates().get(stateIndex).getRaces()
            .size(); j++) {

            // checks for NA values in the ratio so both tower and percentage
            // displayed can be changed
            if (deci.format(numbers.getStates().get(stateIndex).getRaces().get(
                j).getRatio() * 100).equals("-1")) {

                ratioViz.add(new Shape(x0 + (j * 100), y0, WIDTH, 0, COLOR));

                CFRLabels.add(new TextShape(x0 + (j * 100), y0 + 15, "NA"));

            }
            else {
                String thing = deci.format(numbers.getStates().get(stateIndex)
                    .getRaces().get(j).getRatio() * 100);

                CFRLabels.add(new TextShape(x0 + (j * 100), y0 + 15, thing
                    + "%"));

                ratioViz.add(new Shape(x0 + (j * 100) + 10, y0 - (Math.round(
                    numbers.getStates().get(stateIndex).getRaces().get(j)
                        .getRatio() * 1000) * 2), WIDTH, Math.round(numbers
                            .getStates().get(stateIndex).getRaces().get(j)
                            .getRatio() * 1000) * 2, COLOR));
            }

            raceLabels.add(new TextShape(x0 + (j * 100), y0 + 30, numbers
                .getStates().get(stateIndex).getRaces().get(j).getName()));

        }

        // adds all the shapes to the window by looping through each linked list
        for (int k = 0; k < ratioViz.size(); k++) {
            this.window.addShape(ratioViz.get(k));
            this.window.addShape(raceLabels.get(k));
            this.window.addShape(CFRLabels.get(k));
        }
    }


    /**
     * clear the window every time new state is represented
     */
    public void clearWindow() {
        this.window.removeAllShapes();
        this.window.repaint();
    }


    /**
     * Method when the quit button clicked
     * 
     * @param button
     * 
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * changes display to sort states alphabetically
     * 
     * @param button
     */
    public void alphaSort(Button button) {

        for (int i = 0; i < numbers.getStates().size(); i++) {
            // finds state that needs to be sorted
            if (numbers.getStates().get(i).getName().equals(stateRemember)) {
                // makes new state calculator which has methods to do actual
                // sorting
                calc = new StateCalculator(numbers.getStates().get(i));
                // calls methods for sorting (false indicated CFR sort)
                State alphaState = calc.sort(true);
                // changes name so window can be constructed using buildSHapes
                // method
                alphaState.setName(stateRemember + "AlphaSort");
                numbers.getStates().add(alphaState);
                buildShapes(alphaState.getName());
                // break needed to exit loop
                break;
            }
        }
    }


    /**
     * Method to display sorted states by cfr
     * 
     * @param button
     */
    public void cfrSort(Button button) {
        for (int i = 0; i < numbers.getStates().size(); i++) {
            // finds state that needs to be sorted
            if (numbers.getStates().get(i).getName().equals(stateRemember)) {
                // makes new state calculator which has methods to do actual
                // sorting
                calc = new StateCalculator(numbers.getStates().get(i));
                // calls methods for sorting (false indicated CFR sort)
                State alphaState = calc.sort(false);
                // changes name so window can be constructed using buildSHapes
                // method
                alphaState.setName(stateRemember + "CFRSort");
                numbers.getStates().add(alphaState);
                buildShapes(alphaState.getName());
                // break needed to exit loop
                break;
            }
        }
    }


    public void DCRep(Button button) {
        buildShapes("DC");
        stateRemember = "DC";

    }


    public void GARep(Button button) {
        buildShapes("GA");
        stateRemember = "GA";
    }


    public void VARep(Button button) {
        buildShapes("VA");
        stateRemember = "VA";
    }


    public void NCRep(Button button) {
        buildShapes("NC");
        stateRemember = "NC";
    }


    public void TNRep(Button button) {
        buildShapes("TN");
        stateRemember = "TN";
    }


    public void MDRep(Button button) {
        buildShapes("MD");
        stateRemember = "MD";
    }

}
