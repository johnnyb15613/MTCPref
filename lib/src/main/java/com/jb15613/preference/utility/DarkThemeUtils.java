package com.jb15613.preference.utility;

import com.jb15613.preference.utility.Color.Amber;
import com.jb15613.preference.utility.Color.Blue;
import com.jb15613.preference.utility.Color.BlueGrey;
import com.jb15613.preference.utility.Color.Brown;
import com.jb15613.preference.utility.Color.Cyan;
import com.jb15613.preference.utility.Color.DeepOrange;
import com.jb15613.preference.utility.Color.DeepPurple;
import com.jb15613.preference.utility.Color.Green;
import com.jb15613.preference.utility.Color.Grey;
import com.jb15613.preference.utility.Color.Indigo;
import com.jb15613.preference.utility.Color.LightBlue;
import com.jb15613.preference.utility.Color.LightGreen;
import com.jb15613.preference.utility.Color.Lime;
import com.jb15613.preference.utility.Color.Orange;
import com.jb15613.preference.utility.Color.Pink;
import com.jb15613.preference.utility.Color.Purple;
import com.jb15613.preference.utility.Color.Red;
import com.jb15613.preference.utility.Color.Teal;
import com.jb15613.preference.utility.Color.Yellow;

public class DarkThemeUtils {
	
	/**
	 * Retrieves Resource id of a theme
	 *
	 * @param  themeName a {@code String} that is the name of the theme
	 *
	 * @return  theme an {@code Integer} that is the Resource ID of the theme
	 */
	public static int getCustomColoredDarkTheme(String themeName) {

		int theme = 0;

		String[] items = themeName.split(Constants.THEME_SPLITTER);

		switch (items[0]) {

			case Constants.RED:
				theme = Red.getThemeDark(items[1]);
				break;

			case Constants.PINK:
				theme = Pink.getThemeDark(items[1]);
				break;

			case Constants.PURPLE:
				theme = Purple.getThemeDark(items[1]);
				break;

			case Constants.DEEPPURPLE:
				theme = DeepPurple.getThemeDark(items[1]);
				break;

			case Constants.INDIGO:
				theme = Indigo.getThemeDark(items[1]);
				break;

			case Constants.BLUE:
				theme = Blue.getThemeDark(items[1]);
				break;

			case Constants.LIGHTBLUE:
				theme = LightBlue.getThemeDark(items[1]);
				break;

			case Constants.CYAN:
				theme = Cyan.getThemeDark(items[1]);
				break;

			case Constants.TEAL:
				theme = Teal.getThemeDark(items[1]);
				break;

			case Constants.GREEN:
				theme = Green.getThemeDark(items[1]);
				break;

			case Constants.LIGHTGREEN:
				theme = LightGreen.getThemeDark(items[1]);
				break;

			case Constants.LIME:
				theme = Lime.getThemeDark(items[1]);
				break;

			case Constants.YELLOW:
				theme = Yellow.getThemeDark(items[1]);
				break;

			case Constants.AMBER:
				theme = Amber.getThemeDark(items[1]);
				break;

			case Constants.ORANGE:
				theme = Orange.getThemeDark(items[1]);
				break;

			case Constants.DEEPORANGE:
				theme = DeepOrange.getThemeDark(items[1]);
				break;

			case Constants.BROWN:
				theme = Brown.getThemeDark(items[1]);
				break;

			case Constants.GREY:
				theme = Grey.getThemeDark(items[1]);
				break;

			case Constants.BLUEGREY:
				theme = BlueGrey.getThemeDark(items[1]);
				break;

		} // switch

		return theme;

	} // getCustomColoredDarkTheme
	
}
