package com.jb15613.preference.utility;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

import com.jb15613.preference.themechooser.R;

public class ThemeChooserUtils {

	/**
	 * Retrieves color value of Primary Theme Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  themeColor an {@code Integer} that is the color value for Primary Theme Color
	 */
	public static int getThemeColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeColor

	/**
	 * Retrieves color value of Primary Theme Color with Opacity
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 * @param  opacity a {@code float} that is used to derive an opaque version of a solid color
	 *
	 * @return  themeColor an {@code Integer} that is the color value for Primary Theme Color with desired opacity
	 */
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

	/**
	 * Retrieves color value of Primary Theme Color Dark
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  themeColor an {@code Integer} that is the color value for Primary Theme Color Dark
	 */
	public static int getThemeDarkColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeDarkColor

	/**
	 * Retrieves color value of Primary Theme Color Dark with Opacity
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 * @param  opacity a {@code float} that is used to derive an opaque version of a solid color
	 *
	 * @return  themeColor an {@code Integer} that is the color value for Primary Theme Color Dark with desired opacity
	 */
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

	/**
	 * Retrieves color value of Accent Theme Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  themeColor an {@code Integer} that is the color value for Accent Theme Color
	 */
	public static int getThemeAccentColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getThemeAccentColor

	/**
	 * Retrieves color value of Accent Theme Color with Opacity
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 * @param  opacity a {@code float} that is used to derive an opaque version of a solid color
	 *
	 * @return  themeColor an {@code Integer} that is the color value for Accent Theme Color with desired opacity
	 */
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

	/**
	 * Retrieves color value of Primary BG Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  color an {@code Integer} that is the color value for Primary BG Color
	 */
	public static int getPrimaryBgColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.primaryBgColor, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getPrimaryBgColor

	/**
	 * Retrieves color value of Secondary BG Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  color an {@code Integer} that is the color value for Secondary BG Color
	 */
	public static int getSecondaryBgColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.secondaryBgColor, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getSecondaryBgColor

	/**
	 * Retrieves color value of Primary Text Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  color an {@code Integer} that is the color value for Primary Text Color
	 */
	public static int getPrimaryTextColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.textColorPrimary, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getPrimaryTextColor

	/**
	 * Retrieves color value of Secondary Text Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  color an {@code Integer} that is the color value for Secondary Text Color
	 */
	public static int getSecondaryTextColor(Context context) {

		TypedValue typedValue = new TypedValue();

		if (context.getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
			return typedValue.data;
		} else {
			return Color.TRANSPARENT;
		}

	} // getSecondaryTextColor

	/**
	 * Retrieves color value of Secondary Text Color
	 *
	 * @param  context a {@code Context} that is used to retrieve a theme object
	 *
	 * @return  isLightTheme an {@code Boolean} that is true for light, and false or dark
	 */
	public static Boolean isLightTheme(Context context) {
		return PrefUtils.getThemeHue(context);
	}

} // Class
