package com.jb15613.preference.themechooser;

import android.content.Context;
import android.util.TypedValue;
import android.graphics.Color;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ThemeChooserUtils {
	
	final static String mPrefKey = "mtc_pref_preferences";
	
	public static int getTheme(Context context) {
		
		SharedPreferences prefs = context.getSharedPreferences(mPrefKey, Context.MODE_PRIVATE);
		
		String themeName = prefs.getString("themeColor", "Light Blue");
		boolean isLightTheme = prefs.getBoolean("isLightTheme", false);
		
		if (!isLightTheme) {
			// Dark Theme
			if (themeName.contains(" \u0026 ")) {
				// Custom Color Theme
				return ThemeUtils.getCustomColoredDarkTheme(themeName);
			} else {
				// Default Color Theme
				return ThemeUtils.getColoredThemeDark(themeName);
			} // if theme contains "-"

		} else {
			// Light Theme
			if (themeName.contains(" \u0026 ")) {
				// Custom Color Theme
				return ThemeUtils.getCustomColoredLightTheme(themeName);
			} else {
				// Default Color Theme
				return ThemeUtils.getColoredThemeLight(themeName);
			} // if theme contains "-"

		} // if theme is dark or light
		
	} // getTheme
	
	public static int getThemeColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeColor
	
	public static int getThemeColor(Context context, float opacity) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
			
			int color = Color.TRANSPARENT;
			
			if (opacity == 1.0) {
				color = typedValue.data;
			} else if (opacity == 0.9) {
				color = (typedValue.data & 0x00FFFFFF) | 0xe0000000;
			} else if (opacity == 0.8) {
				color = (typedValue.data & 0x00FFFFFF) | 0xd0000000;
			} else if (opacity == 0.7) {
				color = (typedValue.data & 0x00FFFFFF) | 0xc0000000;
			} else if (opacity == 0.6) {
				color = (typedValue.data & 0x00FFFFFF) | 0xb0000000;
			} else if (opacity == 0.5) {
				color = (typedValue.data & 0x00FFFFFF) | 0xa0000000;
			} else if (opacity == 0.4) {
				color = (typedValue.data & 0x00FFFFFF) | 0x90000000;
			} else if (opacity == 0.3) {
				color = (typedValue.data & 0x00FFFFFF) | 0x80000000;
			} else if (opacity == 0.2) {
				color = (typedValue.data & 0x00FFFFFF) | 0x70000000;
			} else if (opacity == 0.1) {
				color = (typedValue.data & 0x00FFFFFF) | 0x60000000;
			}
			
			return color;
			
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeColor
	
	public static int getThemeDarkColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeDarkColor
	
	public static int getThemeDarkColor(Context context, float opacity) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)) {
			
			int color = Color.TRANSPARENT;

			if (opacity == 1.0) {
				color = typedValue.data;
			} else if (opacity == 0.9) {
				color = (typedValue.data & 0x00FFFFFF) | 0xe0000000;
			} else if (opacity == 0.8) {
				color = (typedValue.data & 0x00FFFFFF) | 0xd0000000;
			} else if (opacity == 0.7) {
				color = (typedValue.data & 0x00FFFFFF) | 0xc0000000;
			} else if (opacity == 0.6) {
				color = (typedValue.data & 0x00FFFFFF) | 0xb0000000;
			} else if (opacity == 0.5) {
				color = (typedValue.data & 0x00FFFFFF) | 0xa0000000;
			} else if (opacity == 0.4) {
				color = (typedValue.data & 0x00FFFFFF) | 0x90000000;
			} else if (opacity == 0.3) {
				color = (typedValue.data & 0x00FFFFFF) | 0x80000000;
			} else if (opacity == 0.2) {
				color = (typedValue.data & 0x00FFFFFF) | 0x70000000;
			} else if (opacity == 0.1) {
				color = (typedValue.data & 0x00FFFFFF) | 0x60000000;
			}

			return color;
			
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeDarkColor
	
	public static int getThemeAccentColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeAccentColor
	
	public static int getThemeAccentColor(Context context, float opacity) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
			
			int color = Color.TRANSPARENT;

			if (opacity == 1.0) {
				color = typedValue.data;
			} else if (opacity == 0.9) {
				color = (typedValue.data & 0x00FFFFFF) | 0xe0000000;
			} else if (opacity == 0.8) {
				color = (typedValue.data & 0x00FFFFFF) | 0xd0000000;
			} else if (opacity == 0.7) {
				color = (typedValue.data & 0x00FFFFFF) | 0xc0000000;
			} else if (opacity == 0.6) {
				color = (typedValue.data & 0x00FFFFFF) | 0xb0000000;
			} else if (opacity == 0.5) {
				color = (typedValue.data & 0x00FFFFFF) | 0xa0000000;
			} else if (opacity == 0.4) {
				color = (typedValue.data & 0x00FFFFFF) | 0x90000000;
			} else if (opacity == 0.3) {
				color = (typedValue.data & 0x00FFFFFF) | 0x80000000;
			} else if (opacity == 0.2) {
				color = (typedValue.data & 0x00FFFFFF) | 0x70000000;
			} else if (opacity == 0.1) {
				color = (typedValue.data & 0x00FFFFFF) | 0x60000000;
			}

			return color;
			
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeAccentColor
	
	public static int getPrimaryBgColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.primaryBgColor, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getPrimaryBgColor

	public static int getSecondaryBgColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.secondaryBgColor, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getSecondaryBgColor
	
	public static int getPrimaryTextColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.textColorPrimary, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getPrimaryTextColor

	public static int getSecondaryTextColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getSecondaryTextColor
	
} // Class
