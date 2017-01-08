package com.jb15613.preference.themechooser;
import android.support.v4.content.res.ResourcesCompat;
import android.content.Context;

public class ColorUtils {
	
	public static int[] getColorSet(String themeName, Context mContext) {

        int[] colors = new int[3];
		
		boolean isCustom = false;
		
		String tn = "";
		String ta = "";

        if (themeName.contains(" \u0026 ")) {
			isCustom = true;
			String[] items = themeName.split(" \u0026 ");
			tn = items[0];
			ta = items[1];
			// colors = getCustomColorSet(themeName, mContext);
		} else {
			tn = themeName;
		}
		
		switch (tn) {

			case "Red":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_red, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_red, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Pink":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_pink, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_pink, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Purple":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_purple, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_purple, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Deep Purple":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepPurple, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_deepPurple, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Indigo":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_indigo, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_indigo, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Blue":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blue, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_blue, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Light Blue":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightBlue, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lightBlue, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Cyan":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_cyan, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_cyan, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Teal":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_teal, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_teal, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Green":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_green, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_green, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Light Green":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightGreen, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lightGreen, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Lime":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lime, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lime, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Yellow":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_yellow, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_yellow, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Amber":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_amber, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_amber, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Orange":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_orange, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_orange, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Deep Orange":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepOrange, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_deepOrange, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Brown":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_brown, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_brown, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_brown, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Grey":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_grey, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_grey, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_grey, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case "Blue Grey":
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blueGrey, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_blueGrey, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blueGrey, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

		}

        return colors;
		
    } // getColorSet
	
	private static int getCustomAccentColor(String themeName, Context mContext) {
		
		int color = 0;
		
		switch (themeName) {

			case "Red":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_red, null);
				break;

			case "Pink":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_pink, null);
				break;

			case "Purple":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_purple, null);
				break;

			case "Deep Purple":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepPurple, null);
				break;

			case "Indigo":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_indigo, null);
				break;

			case "Blue":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blue, null);
				break;

			case "Light Blue":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightBlue, null);
				break;

			case "Cyan":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_cyan, null);
				break;

			case "Teal":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_teal, null);
				break;

			case "Green":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_green, null);
				break;

			case "Light Green":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightGreen, null);
				break;

			case "Lime":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lime, null);
				break;

			case "Yellow":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_yellow, null);
				break;

			case "Amber":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_amber, null);
				break;

			case "Orange":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_orange, null);
				break;

			case "Deep Orange":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepOrange, null);
				break;

			case "Brown":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_brown, null);
				break;

			case "Grey":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_grey, null);
				break;

			case "Blue Grey":
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blueGrey, null);
				break;
				
		} // switch
		
		return color;
		
	} // getCustomAccentColor
	
} // Class
