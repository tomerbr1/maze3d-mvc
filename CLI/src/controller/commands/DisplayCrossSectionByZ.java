package controller.commands;

import maze.generators.Maze3d;
import model.Model;
import view.View;

/**
 * Defines the DisplayCrossSectionByZ command.
 * @author Tomer
 *
 */
public class DisplayCrossSectionByZ implements Command {

	private View view;
	private Model model;

	public DisplayCrossSectionByZ(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void doCommand(String[] args) {

		if (args == null || (args[0].contains("[a-zA-Z]+") == false && args[0].length() > 2 || args[1] == null))
			view.displayMessage("(Controller\\DisplayCrossSectionByZ Cmd) Missing Parameters.\n");
		else
		{
			int index = Integer.parseInt(args[0]);
			String name = args[1];
			Maze3d maze = model.getMaze(name);

			if (maze != null)
				view.displayCrossSectionByZ(index, maze);
			else
				view.displayMessage("(Controller\\DisplayCrossSectionByZ Cmd) " + name + " Maze not found.\n");
		}
	}
}
