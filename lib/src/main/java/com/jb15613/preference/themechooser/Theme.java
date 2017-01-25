package com.jb15613.preference.themechooser;

import com.jb15613.preference.utility.MtcPrefException;
import com.jb15613.preference.utility.PrefUtils;
import android.content.Context;
import com.jb15613.preference.utility.Constants;

public class Theme {

	private final String themeColor;
	private final String accentColor;
	private final boolean isLightTheme;

	public Theme(ThemeBuilder builder) {
		this.themeColor = builder.themeColor;
		this.accentColor = builder.accentColor;
		this.isLightTheme = builder.isLightTheme;
	}

	public String getThemeColor() {
		return themeColor;
	}

	public String getAccentColor() {
		return accentColor;
	}

	public boolean getIsLightTheme() {
		return isLightTheme;
	}

	public String getThemeName() throws MtcPrefException {
		
		if (!themeColor.contains(" A")) {
			
			if (!themeColor.equals("")) {

				String theme = themeColor;

				if (!accentColor.equals("")) {
					theme += " & " + accentColor;
				}

				if (isLightTheme) {
					theme += " - Light";
				} else {
					theme += " - Dark";
				}

				return theme;
			} else {
				throw new MtcPrefException("ThemeColor cannot be blank");
			}
			
		} else {
			throw new MtcPrefException("AccentColors cannot be used as ThemeColor");
		}

	}
	
	public int getTheme() {
		return ThemeChooser.getTheme(getThemeName());
	}

	public static class ThemeBuilder {

		private String themeColor = "";
		private String accentColor = "";
		private boolean isLightTheme = false;

		public ThemeBuilder() {
		}
		
		public ThemeBuilder themeColor(String themeColor) {
			this.themeColor = themeColor;
			return this;
		}

		public ThemeBuilder accentColor(String accentColor) {
			this.accentColor = accentColor;
			return this;
		}

		public ThemeBuilder isLightTheme(boolean isLightTheme) {
			this.isLightTheme = isLightTheme;
			return this;
		}

		public Theme build(Context c) {
			
			if (accentColor.equals("")) {
				PrefUtils.setThemeColor(c, themeColor);
			} else {
				PrefUtils.setThemeColor(c, themeColor + Constants.THEME_SPLITTER + accentColor);
			}
			
			PrefUtils.setAccentColor(c, accentColor);
			PrefUtils.setThemeHue(c, isLightTheme);
			
			return new Theme(this);
		}

	}
}
