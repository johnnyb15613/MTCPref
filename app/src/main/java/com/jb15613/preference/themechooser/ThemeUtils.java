package com.jb15613.preference.themechooser;

public class ThemeUtils {
	
	public static int getColoredThemeDark(String themeName) {
		
		int theme = 0;
		
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
		
		return theme;
		
	} // getColoredThemeDark
	
	public static int getColoredThemeLight(String themeName) {
		
		int theme = 0;
		
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
		
		return theme;
		
	} // getColoredThemeLight
	
	public static int getCustomColoredDarkTheme(String themeName) {

		int theme = 0;

		String[] items = themeName.split(" & ");

		switch (items[0]) {
			case "Red":
				switch (items[1]) {
					case "Pink":
						theme = R.style.AppThemeDark_Red_Pink;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Red_Purple;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Red_DeepPurple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Red_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Red_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Red_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Red_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Red_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Red_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Red_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Red_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Red_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Red_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Red_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Red_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Red_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Red_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Red_BlueGrey;
						break;
				} // switch
				break;
			case "Pink":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Pink_Red;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Pink_Purple;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Pink_DeepPurple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Pink_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Pink_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Pink_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Pink_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Pink_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Pink_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Pink_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Pink_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Pink_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Pink_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Pink_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Pink_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Pink_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Pink_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Pink_BlueGrey;
						break;
				} // switch
				break;
			case "Purple":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Purple_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Purple_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Purple_DeepPurple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Purple_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Purple_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Purple_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Purple_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Purple_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Purple_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Purple_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Purple_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Purple_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Purple_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Purple_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Purple_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Purple_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Purple_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Purple_BlueGrey;
						break;
				} // switch
				break;
			case "Deep Purple":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_DeepPurple_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_DeepPurple_Pink;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_DeepPurple_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_DeepPurple_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_DeepPurple_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_DeepPurple_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_DeepPurple_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_DeepPurple_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_DeepPurple_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_DeepPurple_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_DeepPurple_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_DeepPurple_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_DeepPurple_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_DeepPurple_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_DeepPurple_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_DeepPurple_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_DeepPurple_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_DeepPurple_BlueGrey;
						break;
				} // switch
				break;
			case "Indigo":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Indigo_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Indigo_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Indigo_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Indigo_Purple;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Indigo_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Indigo_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Indigo_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Indigo_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Indigo_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Indigo_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Indigo_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Indigo_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Indigo_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Indigo_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Indigo_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Indigo_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Indigo_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Indigo_BlueGrey;
						break;
				} // switch
				break;
			case "Blue":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Blue_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Blue_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Blue_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Blue_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Blue_Indigo;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Blue_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Blue_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Blue_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Blue_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Blue_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Blue_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Blue_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Blue_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Blue_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Blue_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Blue_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Blue_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Blue_BlueGrey;
						break;
				} // switch
				break;
			case "Light Blue":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_LightBlue_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_LightBlue_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_LightBlue_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_LightBlue_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_LightBlue_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_LightBlue_Blue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_LightBlue_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_LightBlue_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_LightBlue_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_LightBlue_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_LightBlue_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_LightBlue_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_LightBlue_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_LightBlue_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_LightBlue_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_LightBlue_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_LightBlue_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_LightBlue_BlueGrey;
						break;
				} // switch
				break;
			case "Cyan":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Cyan_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Cyan_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Cyan_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Cyan_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Cyan_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Cyan_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Cyan_LightBlue;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Cyan_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Cyan_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Cyan_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Cyan_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Cyan_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Cyan_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Cyan_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Cyan_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Cyan_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Cyan_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Cyan_BlueGrey;
						break;
				} // switch
				break;
			case "Teal":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Teal_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Teal_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Teal_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Teal_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Teal_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Teal_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Teal_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Teal_Cyan;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Teal_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Teal_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Teal_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Teal_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Teal_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Teal_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Teal_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Teal_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Teal_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Teal_BlueGrey;
						break;
				} // switch
				break;
			case "Green":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Green_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Green_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Green_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Green_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Green_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Green_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Green_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Green_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Green_Teal;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Green_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Green_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Green_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Green_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Green_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Green_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Green_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Green_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Green_BlueGrey;
						break;
				} // switch
				break;
			case "Light Green":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_LightGreen_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_LightGreen_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_LightGreen_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_LightGreen_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_LightGreen_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_LightGreen_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_LightGreen_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_LightGreen_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_LightGreen_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_LightGreen_Green;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_LightGreen_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_LightGreen_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_LightGreen_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_LightGreen_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_LightGreen_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_LightGreen_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_LightGreen_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_LightGreen_BlueGrey;
						break;
				} // switch
				break;
			case "Lime":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Lime_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Lime_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Lime_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Lime_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Lime_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Lime_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Lime_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Lime_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Lime_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Lime_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Lime_LightGreen;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Lime_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Lime_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Lime_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Lime_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Lime_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Lime_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Lime_BlueGrey;
						break;
				} // switch
				break;
			case "Yellow":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Yellow_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Yellow_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Yellow_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Yellow_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Yellow_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Yellow_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Yellow_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Yellow_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Yellow_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Yellow_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Yellow_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Yellow_Lime;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Yellow_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Yellow_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Yellow_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Yellow_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Yellow_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Yellow_BlueGrey;
						break;
				} // switch
				break;
			case "Amber":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Amber_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Amber_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Amber_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Amber_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Amber_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Amber_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Amber_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Amber_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Amber_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Amber_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Amber_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Amber_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Amber_Yellow;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Amber_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Amber_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Amber_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Amber_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Amber_BlueGrey;
						break;
				} // switch
				break;
			case "Orange":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Orange_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Orange_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Orange_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Orange_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Orange_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Orange_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Orange_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Orange_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Orange_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Orange_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Orange_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Orange_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Orange_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Orange_Amber;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Orange_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Orange_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Orange_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Orange_BlueGrey;
						break;
				} // switch
				break;
			case "Deep Orange":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_DeepOrange_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_DeepOrange_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_DeepOrange_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_DeepOrange_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_DeepOrange_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_DeepOrange_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_DeepOrange_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_DeepOrange_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_DeepOrange_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_DeepOrange_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_DeepOrange_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_DeepOrange_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_DeepOrange_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_DeepOrange_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_DeepOrange_Orange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_DeepOrange_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_DeepOrange_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_DeepOrange_BlueGrey;
						break;
				} // switch
				break;
			case "Brown":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Brown_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Brown_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Brown_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Brown_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Brown_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Brown_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Brown_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Brown_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Brown_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Brown_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Brown_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Brown_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Brown_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Brown_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Brown_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Brown_DeepOrange;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_Brown_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Brown_BlueGrey;
						break;
				} // switch
				break;
			case "Grey":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_Grey_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_Grey_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_Grey_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_Grey_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_Grey_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_Grey_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_Grey_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_Grey_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_Grey_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_Grey_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_Grey_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_Grey_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_Grey_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_Grey_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_Grey_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_Grey_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_Grey_Brown;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeDark_Grey_BlueGrey;
						break;
				} // switch
				break;
			case "Blue Grey":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeDark_BlueGrey_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeDark_BlueGrey_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeDark_BlueGrey_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeDark_BlueGrey_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeDark_BlueGrey_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeDark_BlueGrey_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeDark_BlueGrey_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeDark_BlueGrey_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeDark_BlueGrey_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeDark_BlueGrey_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeDark_BlueGrey_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeDark_BlueGrey_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeDark_BlueGrey_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeDark_BlueGrey_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeDark_BlueGrey_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeDark_BlueGrey_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeDark_BlueGrey_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeDark_BlueGrey_Grey;
						break;
				} // switch
				break;
		} // switch

		return theme;

	} // getCustomColoredDarkTheme
	
	public static int getCustomColoredLightTheme(String themeName) {

		int theme = 0;

		String[] items = themeName.split(" & ");

		switch (items[0]) {
			case "Red":
				switch (items[1]) {
					case "Pink":
						theme = R.style.AppThemeLight_Red_Pink;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Red_Purple;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Red_DeepPurple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Red_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Red_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Red_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Red_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Red_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Red_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Red_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Red_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Red_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Red_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Red_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Red_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Red_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Red_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Red_BlueGrey;
						break;
				} // switch
				break;
			case "Pink":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Pink_Red;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Pink_Purple;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Pink_DeepPurple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Pink_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Pink_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Pink_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Pink_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Pink_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Pink_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Pink_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Pink_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Pink_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Pink_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Pink_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Pink_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Pink_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Pink_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Pink_BlueGrey;
						break;
				} // switch
				break;
			case "Purple":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Purple_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Purple_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Purple_DeepPurple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Purple_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Purple_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Purple_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Purple_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Purple_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Purple_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Purple_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Purple_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Purple_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Purple_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Purple_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Purple_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Purple_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Purple_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Purple_BlueGrey;
						break;
				} // switch
				break;
			case "Deep Purple":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_DeepPurple_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_DeepPurple_Pink;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_DeepPurple_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_DeepPurple_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_DeepPurple_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_DeepPurple_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_DeepPurple_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_DeepPurple_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_DeepPurple_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_DeepPurple_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_DeepPurple_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_DeepPurple_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_DeepPurple_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_DeepPurple_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_DeepPurple_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_DeepPurple_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_DeepPurple_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_DeepPurple_BlueGrey;
						break;
				} // switch
				break;
			case "Indigo":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Indigo_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Indigo_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Indigo_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Indigo_Purple;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Indigo_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Indigo_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Indigo_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Indigo_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Indigo_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Indigo_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Indigo_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Indigo_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Indigo_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Indigo_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Indigo_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Indigo_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Indigo_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Indigo_BlueGrey;
						break;
				} // switch
				break;
			case "Blue":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Blue_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Blue_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Blue_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Blue_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Blue_Indigo;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Blue_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Blue_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Blue_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Blue_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Blue_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Blue_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Blue_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Blue_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Blue_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Blue_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Blue_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Blue_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Blue_BlueGrey;
						break;
				} // switch
				break;
			case "Light Blue":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_LightBlue_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_LightBlue_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_LightBlue_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_LightBlue_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_LightBlue_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_LightBlue_Blue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_LightBlue_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_LightBlue_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_LightBlue_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_LightBlue_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_LightBlue_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_LightBlue_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_LightBlue_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_LightBlue_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_LightBlue_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_LightBlue_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_LightBlue_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_LightBlue_BlueGrey;
						break;
				} // switch
				break;
			case "Cyan":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Cyan_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Cyan_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Cyan_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Cyan_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Cyan_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Cyan_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Cyan_LightBlue;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Cyan_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Cyan_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Cyan_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Cyan_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Cyan_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Cyan_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Cyan_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Cyan_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Cyan_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Cyan_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Cyan_BlueGrey;
						break;
				} // switch
				break;
			case "Teal":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Teal_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Teal_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Teal_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Teal_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Teal_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Teal_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Teal_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Teal_Cyan;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Teal_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Teal_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Teal_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Teal_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Teal_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Teal_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Teal_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Teal_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Teal_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Teal_BlueGrey;
						break;
				} // switch
				break;
			case "Green":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Green_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Green_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Green_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Green_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Green_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Green_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Green_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Green_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Green_Teal;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Green_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Green_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Green_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Green_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Green_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Green_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Green_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Green_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Green_BlueGrey;
						break;
				} // switch
				break;
			case "Light Green":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_LightGreen_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_LightGreen_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_LightGreen_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_LightGreen_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_LightGreen_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_LightGreen_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_LightGreen_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_LightGreen_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_LightGreen_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_LightGreen_Green;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_LightGreen_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_LightGreen_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_LightGreen_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_LightGreen_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_LightGreen_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_LightGreen_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_LightGreen_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_LightGreen_BlueGrey;
						break;
				} // switch
				break;
			case "Lime":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Lime_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Lime_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Lime_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Lime_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Lime_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Lime_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Lime_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Lime_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Lime_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Lime_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Lime_LightGreen;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Lime_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Lime_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Lime_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Lime_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Lime_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Lime_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Lime_BlueGrey;
						break;
				} // switch
				break;
			case "Yellow":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Yellow_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Yellow_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Yellow_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Yellow_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Yellow_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Yellow_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Yellow_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Yellow_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Yellow_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Yellow_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Yellow_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Yellow_Lime;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Yellow_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Yellow_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Yellow_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Yellow_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Yellow_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Yellow_BlueGrey;
						break;
				} // switch
				break;
			case "Amber":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Amber_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Amber_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Amber_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Amber_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Amber_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Amber_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Amber_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Amber_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Amber_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Amber_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Amber_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Amber_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Amber_Yellow;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Amber_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Amber_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Amber_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Amber_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Amber_BlueGrey;
						break;
				} // switch
				break;
			case "Orange":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Orange_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Orange_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Orange_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Orange_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Orange_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Orange_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Orange_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Orange_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Orange_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Orange_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Orange_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Orange_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Orange_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Orange_Amber;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Orange_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Orange_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Orange_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Orange_BlueGrey;
						break;
				} // switch
				break;
			case "Deep Orange":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_DeepOrange_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_DeepOrange_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_DeepOrange_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_DeepOrange_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_DeepOrange_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_DeepOrange_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_DeepOrange_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_DeepOrange_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_DeepOrange_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_DeepOrange_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_DeepOrange_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_DeepOrange_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_DeepOrange_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_DeepOrange_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_DeepOrange_Orange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_DeepOrange_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_DeepOrange_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_DeepOrange_BlueGrey;
						break;
				} // switch
				break;
			case "Brown":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Brown_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Brown_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Brown_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Brown_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Brown_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Brown_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Brown_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Brown_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Brown_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Brown_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Brown_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Brown_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Brown_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Brown_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Brown_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Brown_DeepOrange;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_Brown_Grey;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Brown_BlueGrey;
						break;
				} // switch
				break;
			case "Grey":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_Grey_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_Grey_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_Grey_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_Grey_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_Grey_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_Grey_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_Grey_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_Grey_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_Grey_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_Grey_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_Grey_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_Grey_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_Grey_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_Grey_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_Grey_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_Grey_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_Grey_Brown;
						break;
					case "Blue Grey":
						theme = R.style.AppThemeLight_Grey_BlueGrey;
						break;
				} // switch
				break;
			case "Blue Grey":
				switch (items[1]) {
					case "Red":
						theme = R.style.AppThemeLight_BlueGrey_Red;
						break;
					case "Pink":
						theme = R.style.AppThemeLight_BlueGrey_Pink;
						break;
					case "Deep Purple":
						theme = R.style.AppThemeLight_BlueGrey_DeepPurple;
						break;
					case "Purple":
						theme = R.style.AppThemeLight_BlueGrey_Purple;
						break;
					case "Indigo":
						theme = R.style.AppThemeLight_BlueGrey_Indigo;
						break;
					case "Blue":
						theme = R.style.AppThemeLight_BlueGrey_Blue;
						break;
					case "Light Blue":
						theme = R.style.AppThemeLight_BlueGrey_LightBlue;
						break;
					case "Cyan":
						theme = R.style.AppThemeLight_BlueGrey_Cyan;
						break;
					case "Teal":
						theme = R.style.AppThemeLight_BlueGrey_Teal;
						break;
					case "Green":
						theme = R.style.AppThemeLight_BlueGrey_Green;
						break;
					case "Light Green":
						theme = R.style.AppThemeLight_BlueGrey_LightGreen;
						break;
					case "Lime":
						theme = R.style.AppThemeLight_BlueGrey_Lime;
						break;
					case "Yellow":
						theme = R.style.AppThemeLight_BlueGrey_Yellow;
						break;
					case "Amber":
						theme = R.style.AppThemeLight_BlueGrey_Amber;
						break;
					case "Orange":
						theme = R.style.AppThemeLight_BlueGrey_Orange;
						break;
					case "Deep Orange":
						theme = R.style.AppThemeLight_BlueGrey_DeepOrange;
						break;
					case "Brown":
						theme = R.style.AppThemeLight_BlueGrey_Brown;
						break;
					case "Grey":
						theme = R.style.AppThemeLight_BlueGrey_Grey;
						break;
				} // switch
				break;
		} // switch

		return theme;

	} // getCustomColoredDarkTheme
	
}
