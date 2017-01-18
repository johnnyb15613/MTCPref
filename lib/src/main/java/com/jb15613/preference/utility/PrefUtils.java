package com.jb15613.preference.utility;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils {
	
	/**
	 * Saves name of theme color to prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 * @param  themeName a {@code String} that will be saved as the theme name
	 */
	public static void setThemeColor(Context context, String themeName) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.PREF_THEME_KEY, themeName);
        editor.apply();
	} // setThemeColor
	
	/**
	 * Retrieves name of theme color from prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 *
	 * @return  themeName a {@code String} that was saved as the theme name
	 */
	public static String getThemeColor(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		return prefs.getString(Constants.PREF_THEME_KEY, Constants.LIGHTBLUE);
	} // getThemeColor
	
	/**
	 * Saves name of accent color to prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 * @param  acventName a {@code String} that will be saved as the accent name
	 */
	public static void setAccentColor(Context context, String accentName) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.PREF_THEME_ACCENT_KEY, accentName);
        editor.apply();
	} // setAccentColor

	/**
	 * Retrieves name of accent color from prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 *
	 * @return  acventName a {@code String} that was saved as the accent name
	 */
	public static String getAccentColor(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		return prefs.getString(Constants.PREF_THEME_ACCENT_KEY, Constants.LIGHTBLUE);
	} // getAccentColor
	
	/**
	 * Saves hue of theme color to prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 * @param  themeHue a {@code Boolean} that will be saved as the theme hue
	 */
	public static void setThemeHue(Context context, boolean themeHue) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(Constants.PREF_THEME_HUE_KEY, themeHue);
        editor.apply();
	} // setThemeHue

	/**
	 * Retrieves name of theme hue from prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 *
	 * @return  themeHue a {@code Boolean} that was saved as the theme hue
	 */
	public static boolean getThemeHue(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		return prefs.getBoolean(Constants.PREF_THEME_HUE_KEY, false);
	} // getThemeHue
	
	/**
	 * Saves the device dendity scale to prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 * @param  scale a {@code float} that will be saved as the density scale
	 */
	public static void setDensityScale(Context context, float scale) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(Constants.PREF_DENSITY_SCALE_KEY, scale);
        editor.apply();
	} // setDensityScale

	/**
	 * Retrieves value of density scsle from prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 *
	 * @return  scale a {@code float} that was saved as the density scale
	 */
	public static float getDensityScale(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		return prefs.getFloat(Constants.PREF_DENSITY_SCALE_KEY, 0);
	} // getDensityScale
	
	/**
	 * Saves size of cells to prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 * @param  cellSize an {@code int} that will be saved as the cell size
	 */
	public static void setCellSize(Context context, int cellSize) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(Constants.PREF_CELL_SIZE_KEY, cellSize);
        editor.apply();
	} // setCellSize

	/**
	 * Retrieves size of cells from prefs
	 *
	 * @param  context a {@code Context} that is used to retrieve a preference object
	 *
	 * @return  cellSize an {@code int} that was saved as the cell size
	 */
	public static int getCellSize(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		return prefs.getInt(Constants.PREF_CELL_SIZE_KEY, 0);
	} // getCellSize
	
} // Class
