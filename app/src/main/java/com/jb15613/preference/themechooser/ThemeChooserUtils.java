package com.jb15613.preference.themechooser;

import android.content.Context;
import android.util.TypedValue;
import android.graphics.Color;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ThemeChooserUtils {
	
	public static int getTheme(Context context) {
		
		int theme = 0;
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		
		String themeName = prefs.getString("themeColor", "Light Blue");
		boolean isLightTheme = prefs.getBoolean("isLightTheme", false);
		
		if (!isLightTheme) {

			switch (themeName) {

				case "Red":
					theme = R.style.AppThemeDark_Red;
					break;

				case "Pink":
					theme = R.style.AppThemeDark_Pink;
					break;

				case "Purple":
					theme = R.style.AppThemeDark_Purple;
					break;

				case "Deep Purple":
					theme = R.style.AppThemeDark_DeepPurple;
					break;

				case "Indigo":
					theme = R.style.AppThemeDark_Indigo;
					break;

				case "Blue":
					theme = R.style.AppThemeDark_Blue;
					break;

				case "Light Blue":
					theme = R.style.AppThemeDark_LightBlue;
					break;

				case "Cyan":
					theme = R.style.AppThemeDark_Cyan;
					break;

				case "Teal":
					theme = R.style.AppThemeDark_Teal;
					break;

				case "Green":
					theme = R.style.AppThemeDark_Green;
					break;

				case "Light Green":
					theme = R.style.AppThemeDark_LightGreen;
					break;

				case "Lime":
					theme = R.style.AppThemeDark_Lime;
					break;

				case "Yellow":
					theme = R.style.AppThemeDark_Yellow;
					break;

				case "Amber":
					theme = R.style.AppThemeDark_Amber;
					break;

				case "Orange":
					theme = R.style.AppThemeDark_Orange;
					break;

				case "Deep Orange":
					theme = R.style.AppThemeDark_DeepOrange;
					break;

				case "Brown":
					theme = R.style.AppThemeDark_Brown;
					break;

				case "Grey":
					theme = R.style.AppThemeDark_Grey;
					break;

				case "Blue Grey":
					theme = R.style.AppThemeDark_BlueGrey;
					break;

			} // switch

		} else {

			switch (themeName) {

				case "Red":
					theme = R.style.AppThemeLight_Red;
					break;

				case "Pink":
					theme = R.style.AppThemeLight_Pink;
					break;

				case "Purple":
					theme = R.style.AppThemeLight_Purple;
					break;

				case "Deep Purple":
					theme = R.style.AppThemeLight_DeepPurple;
					break;

				case "Indigo":
					theme = R.style.AppThemeLight_Indigo;
					break;

				case "Blue":
					theme = R.style.AppThemeLight_Blue;
					break;

				case "Light Blue":
					theme = R.style.AppThemeLight_LightBlue;
					break;

				case "Cyan":
					theme = R.style.AppThemeLight_Cyan;
					break;

				case "Teal":
					theme = R.style.AppThemeLight_Teal;
					break;

				case "Green":
					theme = R.style.AppThemeLight_Green;
					break;

				case "Light Green":
					theme = R.style.AppThemeLight_LightGreen;
					break;

				case "Lime":
					theme = R.style.AppThemeLight_Lime;
					break;

				case "Yellow":
					theme = R.style.AppThemeLight_Yellow;
					break;

				case "Amber":
					theme = R.style.AppThemeLight_Amber;
					break;

				case "Orange":
					theme = R.style.AppThemeLight_Orange;
					break;

				case "Deep Orange":
					theme = R.style.AppThemeLight_DeepOrange;
					break;

				case "Brown":
					theme = R.style.AppThemeLight_Brown;
					break;

				case "Grey":
					theme = R.style.AppThemeLight_Grey;
					break;

				case "Blue Grey":
					theme = R.style.AppThemeLight_BlueGrey;
					break;

			} // switch		

		}
		
		return theme;
		
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
