package com.jb15613.preference.themechooser;

import android.content.Context;
import android.content.SharedPreferences;
import com.jb15613.preference.utility.ThemeUtils;
import com.jb15613.preference.utility.Constants;

public class ThemeChooser {

	public static int getTheme(Context context) {

		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);

		String themeName = prefs.getString(Constants.PREF_THEME_KEY, Constants.LIGHTBLUE);
		boolean isLightTheme = prefs.getBoolean(Constants.PREF_THEME_HUE_KEY, false);

		if (!isLightTheme) {
			// Dark Theme
			if (themeName.contains(Constants.THEME_SPLITTER)) {
				// Custom Color Theme
				return ThemeUtils.getCustomColoredDarkTheme(themeName);
			} else {
				// Default Color Theme
				return ThemeUtils.getColoredThemeDark(themeName);
			} // if theme contains "-"

		} else {
			// Light Theme
			if (themeName.contains(Constants.THEME_SPLITTER)) {
				// Custom Color Theme
				return ThemeUtils.getCustomColoredLightTheme(themeName);
			} else {
				// Default Color Theme
				return ThemeUtils.getColoredThemeLight(themeName);
			} // if theme contains "-"

		} // if theme is dark or light

	} // getTheme
	
	public static int getTheme(String themeName) {
		
		String TN = themeName;
		
		boolean isLightTheme = true;

		if (themeName.contains(Constants.HUE_SPLITTER)) {
			// dark/light specified
			// figure out which one to use
			String[] tn = themeName.split(Constants.HUE_SPLITTER);
			TN = tn[0];
			
			switch (tn[1].trim()) {
				case "Dark":
					isLightTheme = false;
					break;
				case "Light":
					isLightTheme = true;
					break;
			}
			
		} else {
			isLightTheme = true;
		}
		
		if (!isLightTheme) {
			// Dark Theme
			if (TN.contains(Constants.THEME_SPLITTER)) {
				// Custom Color Theme
				return ThemeUtils.getCustomColoredDarkTheme(TN);
			} else {
				// Default Color Theme
				return ThemeUtils.getColoredThemeDark(TN);
			} // if theme contains "-"

		} else {
			// Light Theme
			if (TN.contains(Constants.THEME_SPLITTER)) {
				// Custom Color Theme
				return ThemeUtils.getCustomColoredLightTheme(TN);
			} else {
				// Default Color Theme
				return ThemeUtils.getColoredThemeLight(TN);
			} // if theme contains "-"

		} // if theme is dark or light

	} // getTheme
	
}
