package com.jb15613.preference.utility;

import android.support.v4.content.res.ResourcesCompat;
import android.content.Context;
import com.jb15613.preference.themechooser.R;

public class ColorUtils {

	/**
	 * Creates a set of colors that represent Primary, Dark, and Accent colors for a theme
	 *
	 * @param  themeName a {@code String} that contains the theme name
	 * @param  mContext a {@code Context} that contains the theme name
	 * @return  an {@code int[]} that contains Primary, Dark, and Accent theme colors
	 */
	public static int[] getColorSet(String themeName, Context mContext) {

        int[] colors = new int[3];

		boolean isCustom = false;

		String tn = "";
		String ta = "";

        if (themeName.contains(Constants.THEME_SPLITTER)) {
			isCustom = true;
			String[] items = themeName.split(Constants.THEME_SPLITTER);
			tn = items[0];
			ta = items[1];
			// colors = getCustomColorSet(themeName, mContext);
		} else {
			tn = themeName;
		}

		switch (tn) {

			case Constants.RED:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_red, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_red, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.PINK:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_pink, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_pink, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.PURPLE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_purple, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_purple, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.DEEPPURPLE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepPurple, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_deepPurple, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.INDIGO:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_indigo, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_indigo, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.BLUE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blue, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_blue, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.LIGHTBLUE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightBlue, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lightBlue, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.CYAN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_cyan, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_cyan, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.TEAL:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_teal, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_teal, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.GREEN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_green, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_green, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.LIGHTGREEN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightGreen, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lightGreen, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.LIME:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lime, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lime, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.YELLOW:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_yellow, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_yellow, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.AMBER:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_amber, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_amber, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.ORANGE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_orange, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_orange, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.DEEPORANGE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepOrange, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_deepOrange, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.BROWN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_brown, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_brown, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_brown, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.GREY:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_grey, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_grey, null);
				if (!isCustom) {
					colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_grey, null);
				} else {
					colors[2] = getCustomAccentColor(ta, mContext);
				}
				break;

			case Constants.BLUEGREY:
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
	
	public static int[] getTrueAccentColorSet(String themeName, Context mContext) {

        int[] colors = new int[5];

		switch (themeName) {

			case Constants.RED:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_red, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red7, null);
				break;

			case Constants.PINK:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_pink, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink7, null);
				break;

			case Constants.PURPLE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_purple, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple7, null);
				break;

			case Constants.DEEPPURPLE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepPurple, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple7, null);
				break;

			case Constants.INDIGO:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_indigo, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo7, null);
				break;

			case Constants.BLUE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blue, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue7, null);
				break;

			case Constants.LIGHTBLUE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightBlue, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue7, null);
				break;

			case Constants.CYAN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_cyan, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan7, null);
				break;

			case Constants.TEAL:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_teal, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal7, null);
				break;

			case Constants.GREEN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_green, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green7, null);
				break;

			case Constants.LIGHTGREEN:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightGreen, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen7, null);
				break;

			case Constants.LIME:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lime, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime7, null);
				break;

			case Constants.YELLOW:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_yellow, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow7, null);
				break;

			case Constants.AMBER:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_amber, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber7, null);
				break;

			case Constants.ORANGE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_orange, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange7, null);
				break;

			case Constants.DEEPORANGE:
				colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepOrange, null);
				colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange, null);
				colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange2, null);
				colors[3] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange4, null);
				colors[4] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange7, null);
				break;

		}

        return colors;

    } // getTrueAccentColorSet

	/**
	 * Creates a set of colors that represent Primary, Dark, and Accent colors for a theme
	 *
	 * @param  themeName a {@code String} that contains the theme name
	 * @param  mContext a {@code Context} that contains the theme name
	 * @return  an {@code int} that contains the Accent theme color
	 */
	private static int getCustomAccentColor(String themeName, Context mContext) {

		int color = 0;

		switch (themeName) {

			case Constants.RED:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_red, null);
				break;

			case Constants.PINK:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_pink, null);
				break;

			case Constants.PURPLE:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_purple, null);
				break;

			case Constants.DEEPPURPLE:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepPurple, null);
				break;

			case Constants.INDIGO:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_indigo, null);
				break;

			case Constants.BLUE:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blue, null);
				break;

			case Constants.LIGHTBLUE:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightBlue, null);
				break;

			case Constants.CYAN:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_cyan, null);
				break;

			case Constants.TEAL:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_teal, null);
				break;

			case Constants.GREEN:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_green, null);
				break;

			case Constants.LIGHTGREEN:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightGreen, null);
				break;

			case Constants.LIME:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lime, null);
				break;

			case Constants.YELLOW:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_yellow, null);
				break;

			case Constants.AMBER:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_amber, null);
				break;

			case Constants.ORANGE:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_orange, null);
				break;

			case Constants.DEEPORANGE:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepOrange, null);
				break;

			case Constants.BROWN:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_brown, null);
				break;

			case Constants.GREY:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_grey, null);
				break;

			case Constants.BLUEGREY:
				color = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blueGrey, null);
				break;

		} // switch

		return color;

	} // getCustomAccentColor

} // Class
