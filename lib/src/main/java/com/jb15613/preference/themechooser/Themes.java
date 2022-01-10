package com.jb15613.preference.themechooser;
import com.jb15613.preference.utility.Constants;
import java.util.Random;

public class Themes {
	
	public static boolean getRandomThemeHue() {
		return Math.random() < 0.5; 
	} 
	
	public static class ThemeColor {
		
		// Red
		public static final String Red = Constants.RED;
		// Pink
		public static final String Pink = Constants.PINK;
		// Purple
		public static final String Purple = Constants.PURPLE;
		// DeepPurple
		public static final String DeepPurple = Constants.DEEPPURPLE;
		// Indigo
		public static final String Indigo = Constants.INDIGO;
		// Blue
		public static final String Blue = Constants.BLUE;
		// LightBlue
		public static final String LightBlue = Constants.LIGHTBLUE;
		// Cyan
		public static final String Cyan = Constants.CYAN;
		// Teal
		public static final String Teal = Constants.TEAL;
		// Green
		public static final String Green = Constants.GREEN;
		// LightGreen
		public static final String LightGreen = Constants.LIGHTGREEN;
		// Lime
		public static final String Lime = Constants.LIME;
		// Yellow
		public static final String Yellow = Constants.YELLOW;
		// Amber
		public static final String Amber = Constants.AMBER;
		// Orange
		public static final String Orange = Constants.ORANGE;
		// DeepOrange
		public static final String DeepOrange = Constants.DEEPORANGE;
		// Brown
		public static final String Brown = Constants.BROWN;
		// Grey
		public static final String Grey = Constants.GREY;
		// BlueGrey
		public static final String BlueGrey = Constants.BLUEGREY;
		
		public static String getRandomThemeColor() {
			String[] array = {Red, Pink, Purple, DeepPurple, Indigo, Blue, LightBlue, Cyan, Teal,
								Green, LightGreen, Lime, Yellow, Amber, Orange, DeepOrange,
								Brown, Grey, BlueGrey};
			return array[new Random().nextInt(array.length)];
		} // getRandomThemeColor
		
	} // Class
	
	public static class AccentColor {
		
		// Red
		public static final String Red_A1 = Constants.RED_A1;
		public static final String Red_A2 = Constants.RED_A2;
		public static final String Red_A4 = Constants.RED_A4;
		public static final String Red_A7 = Constants.RED_A7;
		// Pink
		public static final String Pink_A1 = Constants.PINK_A1;
		public static final String Pink_A2 = Constants.PINK_A2;
		public static final String Pink_A4 = Constants.PINK_A4;
		public static final String Pink_A7 = Constants.PINK_A7;
		// Purple
		public static final String Purple_A1 = Constants.PURPLE_A1;
		public static final String Purple_A2 = Constants.PURPLE_A2;
		public static final String Purple_A4 = Constants.PURPLE_A4;
		public static final String Purple_A7 = Constants.PURPLE_A7;
		// DeepPurple
		public static final String DeepPurple_A1 = Constants.DEEPPURPLE_A1;
		public static final String DeepPurple_A2 = Constants.DEEPPURPLE_A2;
		public static final String DeepPurple_A4 = Constants.DEEPPURPLE_A4;
		public static final String DeepPurple_A7 = Constants.DEEPPURPLE_A7;
		// Indigo
		public static final String Indigo_A1 = Constants.INDIGO_A1;
		public static final String Indigo_A2 = Constants.INDIGO_A2;
		public static final String Indigo_A4 = Constants.INDIGO_A4;
		public static final String Indigo_A7 = Constants.INDIGO_A7;
		// Blue
		public static final String Blue_A1 = Constants.BLUE_A1;
		public static final String Blue_A2 = Constants.BLUE_A2;
		public static final String Blue_A4 = Constants.BLUE_A4;
		public static final String Blue_A7 = Constants.BLUE_A7;
		// LightBlue
		public static final String LightBlue_A1 = Constants.LIGHTBLUE_A1;
		public static final String LightBlue_A2 = Constants.LIGHTBLUE_A2;
		public static final String LightBlue_A4 = Constants.LIGHTBLUE_A4;
		public static final String LightBlue_A7 = Constants.LIGHTBLUE_A7;
		// Cyan
		public static final String Cyan_A1 = Constants.CYAN_A1;
		public static final String Cyan_A2 = Constants.CYAN_A2;
		public static final String Cyan_A4 = Constants.CYAN_A4;
		public static final String Cyan_A7 = Constants.CYAN_A7;
		// Teal
		public static final String Teal_A1 = Constants.TEAL_A1;
		public static final String Teal_A2 = Constants.TEAL_A2;
		public static final String Teal_A4 = Constants.TEAL_A4;
		public static final String Teal_A7 = Constants.TEAL_A7;
		// Green
		public static final String Green_A1 = Constants.GREEN_A1;
		public static final String Green_A2 = Constants.GREEN_A2;
		public static final String Green_A4 = Constants.GREEN_A4;
		public static final String Green_A7 = Constants.GREEN_A7;
		// LightGreen
		public static final String LightGreen_A1 = Constants.LIGHTGREEN_A1;
		public static final String LightGreen_A2 = Constants.LIGHTGREEN_A2;
		public static final String LightGreen_A4 = Constants.LIGHTGREEN_A4;
		public static final String LightGreen_A7 = Constants.LIGHTGREEN_A7;
		// Lime
		public static final String Lime_A1 = Constants.LIME_A1;
		public static final String Lime_A2 = Constants.LIME_A2;
		public static final String Lime_A4 = Constants.LIME_A4;
		public static final String Lime_A7 = Constants.LIME_A7;
		// Yellow
		public static final String Yellow_A1 = Constants.YELLOW_A1;
		public static final String Yellow_A2 = Constants.YELLOW_A2;
		public static final String Yellow_A4 = Constants.YELLOW_A4;
		public static final String Yellow_A7 = Constants.YELLOW_A7;
		// Amber
		public static final String Amber_A1 = Constants.AMBER_A1;
		public static final String Amber_A2 = Constants.AMBER_A2;
		public static final String Amber_A4 = Constants.AMBER_A4;
		public static final String Amber_A7 = Constants.AMBER_A7;
		// Orange
		public static final String Orange_A1 = Constants.ORANGE_A1;
		public static final String Orange_A2 = Constants.ORANGE_A2;
		public static final String Orange_A4 = Constants.ORANGE_A4;
		public static final String Orange_A7 = Constants.ORANGE_A7;
		// DeepOrange
		public static final String DeepOrange_A1 = Constants.DEEPORANGE_A1;
		public static final String DeepOrange_A2 = Constants.DEEPORANGE_A2;
		public static final String DeepOrange_A4 = Constants.DEEPORANGE_A4;
		public static final String DeepOrange_A7 = Constants.DEEPORANGE_A7;
		// Brown
		public static final String Brown_A3 = Constants.BROWN_3;
		// Grey
		public static final String Grey_A3 = Constants.GREY_3;
		// BlueGrey
		public static final String BlueGrey_A3 = Constants.BLUEGREY_3;
		
		public static String getRandomAccentColor() {
			String[] array = {Red_A1, Red_A2, Red_A4, Red_A7,
								Pink_A1, Pink_A2, Pink_A4, Pink_A7,
								Purple_A1, Purple_A2, Purple_A4, Purple_A7,
								DeepPurple_A1, DeepPurple_A2, DeepPurple_A4, DeepPurple_A7,
								Indigo_A1, Indigo_A2, Indigo_A4, Indigo_A7,
								Blue_A1, Blue_A2, Blue_A4, Blue_A7,
								LightBlue_A1, LightBlue_A2, LightBlue_A4, LightBlue_A7,
								Cyan_A1, Cyan_A2, Cyan_A4, Cyan_A7,
								Teal_A1, Teal_A2, Teal_A4, Teal_A7,
								Green_A1, Green_A2, Green_A4, Green_A7,
								LightGreen_A1, LightGreen_A2, LightGreen_A4, LightGreen_A7,
								Lime_A1, Lime_A2, Lime_A4, Lime_A7,
								Yellow_A1, Yellow_A2, Yellow_A4, Yellow_A7,
								Amber_A1, Amber_A2, Amber_A4, Amber_A7,
								Orange_A1, Orange_A2, Orange_A4, Orange_A7,
								DeepOrange_A1, DeepOrange_A2, DeepOrange_A4, DeepOrange_A7,
								Brown_A3, Grey_A3, BlueGrey_A3};
			return array[new Random().nextInt(array.length)];
		} // getRandomThemeColor
		
	} // Class
	
} // Class
