package com.jb15613.preference.utility;
import com.jb15613.preference.themechooser.R;

public class ThemeUtils {
	
	/**
	 * Retrieves Resource id of a theme
	 *
	 * @param  themeName a {@code String} that is the name of the theme
	 *
	 * @return  theme an {@code Integer} that is the Resource ID of the theme
	 */
	public static int getColoredThemeDark(String themeName) {
		
		int theme = 0;
		
		switch (themeName) {
			case Constants.RED:
				theme = R.style.AppThemeDark_Red;
				break;
			case Constants.PINK:
				theme = R.style.AppThemeDark_Pink;
				break;
			case Constants.PURPLE:
				theme = R.style.AppThemeDark_Purple;
				break;
			case Constants.DEEPPURPLE:
				theme = R.style.AppThemeDark_DeepPurple;
				break;
			case Constants.INDIGO:
				theme = R.style.AppThemeDark_Indigo;
				break;
			case Constants.BLUE:
				theme = R.style.AppThemeDark_Blue;
				break;
			case Constants.LIGHTBLUE:
				theme = R.style.AppThemeDark_LightBlue;
				break;
			case Constants.CYAN:
				theme = R.style.AppThemeDark_Cyan;
				break;
			case Constants.TEAL:
				theme = R.style.AppThemeDark_Teal;
				break;
			case Constants.GREEN:
				theme = R.style.AppThemeDark_Green;
				break;
			case Constants.LIGHTGREEN:
				theme = R.style.AppThemeDark_LightGreen;
				break;
			case Constants.LIME:
				theme = R.style.AppThemeDark_Lime;
				break;
			case Constants.YELLOW:
				theme = R.style.AppThemeDark_Yellow;
				break;
			case Constants.AMBER:
				theme = R.style.AppThemeDark_Amber;
				break;
			case Constants.ORANGE:
				theme = R.style.AppThemeDark_Orange;
				break;
			case Constants.DEEPORANGE:
				theme = R.style.AppThemeDark_DeepOrange;
				break;
			case Constants.BROWN:
				theme = R.style.AppThemeDark_Brown;
				break;
			case Constants.GREY:
				theme = R.style.AppThemeDark_Grey;
				break;
			case Constants.BLUEGREY:
				theme = R.style.AppThemeDark_BlueGrey;
				break;
		} // switch
		
		return theme;
		
	} // getColoredThemeDark
	
	/**
	 * Retrieves Resource id of a theme
	 *
	 * @param  themeName a {@code String} that is the name of the theme
	 *
	 * @return  theme an {@code Integer} that is the Resource ID of the theme
	 */
	public static int getColoredThemeLight(String themeName) {
		
		int theme = 0;
		
		switch (themeName) {

			case Constants.RED:
				theme = R.style.AppThemeLight_Red;
				break;

			case Constants.PINK:
				theme = R.style.AppThemeLight_Pink;
				break;

			case Constants.PURPLE:
				theme = R.style.AppThemeLight_Purple;
				break;

			case Constants.DEEPPURPLE:
				theme = R.style.AppThemeLight_DeepPurple;
				break;

			case Constants.INDIGO:
				theme = R.style.AppThemeLight_Indigo;
				break;

			case Constants.BLUE:
				theme = R.style.AppThemeLight_Blue;
				break;

			case Constants.LIGHTBLUE:
				theme = R.style.AppThemeLight_LightBlue;
				break;

			case Constants.CYAN:
				theme = R.style.AppThemeLight_Cyan;
				break;

			case Constants.TEAL:
				theme = R.style.AppThemeLight_Teal;
				break;

			case Constants.GREEN:
				theme = R.style.AppThemeLight_Green;
				break;

			case Constants.LIGHTGREEN:
				theme = R.style.AppThemeLight_LightGreen;
				break;

			case Constants.LIME:
				theme = R.style.AppThemeLight_Lime;
				break;

			case Constants.YELLOW:
				theme = R.style.AppThemeLight_Yellow;
				break;

			case Constants.AMBER:
				theme = R.style.AppThemeLight_Amber;
				break;

			case Constants.ORANGE:
				theme = R.style.AppThemeLight_Orange;
				break;

			case Constants.DEEPORANGE:
				theme = R.style.AppThemeLight_DeepOrange;
				break;

			case Constants.BROWN:
				theme = R.style.AppThemeLight_Brown;
				break;

			case Constants.GREY:
				theme = R.style.AppThemeLight_Grey;
				break;

			case Constants.BLUEGREY:
				theme = R.style.AppThemeLight_BlueGrey;
				break;

		} // switch
		
		return theme;
		
	} // getColoredThemeLight
	
}
