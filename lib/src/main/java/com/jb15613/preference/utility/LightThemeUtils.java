package com.jb15613.preference.utility;
import com.jb15613.preference.utility.Color.Pink;
import com.jb15613.preference.utility.Color.Red;
import com.jb15613.preference.utility.Color.BlueGrey;
import com.jb15613.preference.utility.Color.Grey;
import com.jb15613.preference.utility.Color.Brown;
import com.jb15613.preference.utility.Color.DeepOrange;
import com.jb15613.preference.utility.Color.Orange;
import com.jb15613.preference.utility.Color.Amber;
import com.jb15613.preference.utility.Color.Yellow;
import com.jb15613.preference.utility.Color.Lime;
import com.jb15613.preference.utility.Color.LightGreen;
import com.jb15613.preference.utility.Color.Green;
import com.jb15613.preference.utility.Color.Teal;
import com.jb15613.preference.utility.Color.Cyan;
import com.jb15613.preference.utility.Color.LightBlue;
import com.jb15613.preference.utility.Color.Blue;
import com.jb15613.preference.utility.Color.Indigo;
import com.jb15613.preference.utility.Color.DeepPurple;
import com.jb15613.preference.utility.Color.Purple;

public class LightThemeUtils {
	
	/**
	 * Retrieves Resource id of a theme
	 *
	 * @param  themeName a {@code String} that is the name of the theme
	 *
	 * @return  theme an {@code Integer} that is the Resource ID of the theme
	 */
	public static int getCustomColoredLightTheme(String themeName) {

		int theme = 0;

		String[] items = themeName.split(Constants.THEME_SPLITTER);

		switch (items[0]) {
			
			case Constants.RED:
				theme = Red.getThemeLight(items[1]);
				break;
				
			case Constants.PINK:
				theme = Pink.getThemeLight(items[1]);
				break;
				
			case Constants.PURPLE:
				theme = Purple.getThemeLight(items[1]);
				break;
				
			case Constants.DEEPPURPLE:
				theme = DeepPurple.getThemeLight(items[1]);
				break;
				
			case Constants.INDIGO:
				theme = Indigo.getThemeLight(items[1]);
				break;
				
			case Constants.BLUE:
				theme = Blue.getThemeLight(items[1]);
				break;
				
			case Constants.LIGHTBLUE:
				theme = LightBlue.getThemeLight(items[1]);
				break;
				
			case Constants.CYAN:
				theme = Cyan.getThemeLight(items[1]);
				break;
				
			case Constants.TEAL:
				theme = Teal.getThemeLight(items[1]);
				break;
				
			case Constants.GREEN:
				theme = Green.getThemeLight(items[1]);
				break;
				
			case Constants.LIGHTGREEN:
				theme = LightGreen.getThemeLight(items[1]);
				break;
				
			case Constants.LIME:
				theme = Lime.getThemeLight(items[1]);
				break;
				
			case Constants.YELLOW:
				theme = Yellow.getThemeLight(items[1]);
				break;
				
			case Constants.AMBER:
				theme = Amber.getThemeLight(items[1]);
				break;
				
			case Constants.ORANGE:
				theme = Orange.getThemeLight(items[1]);
				break;
				
			case Constants.DEEPORANGE:
				theme = DeepOrange.getThemeLight(items[1]);
				break;
				
			case Constants.BROWN:
				theme = Brown.getThemeLight(items[1]);
				break;
				
			case Constants.GREY:
				theme = Grey.getThemeLight(items[1]);
				break;
				
			case Constants.BLUEGREY:
				theme = BlueGrey.getThemeLight(items[1]);
				break;
				
		} // switch

		return theme;

	} // getCustomColoredDarkTheme
	
}

