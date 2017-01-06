<img src="icon.png" align="right" />
# MTCPref
Material Theme Chooser Preference

## Intro
While learning to theme using the AppCompat and Design Libraries, I started to have the need to support multiple themes. Different Material Color Schemes, as well as alternating between light backgrounds with dark text and dark backgrounds with light text. Setting this up can be a nightmare if you are unfamiliar with the process, not to mention it is a good bit of code to have 10 dark themes and 10 light themes. After the second app I needed to theme, I realised that we needed a library to take the place of all the imported code that comes along with preparing the themes, as well as selecting a theme to use.
###This Library will take care of the following
- Having an easy to use Preference Item to select a Theme 
- Having an easy to use API to access all colors of the selected Theme
- Having to make only 1 call in your Activity to set the Theme

## Usage
* Add Maven Repo for Jit in your build.gradle(Module)
```android
allprojects {
    repositories {
		maven { url "https://jitpack.io" }
}
```

* Add MTCPref dependency in your build.gradle(app)
```android
dependencies {
	compile 'com.github.johnnyb15613:MTCPref:v0.1.7'
}
```

* Add MTCPreferenceItem to your settings xml
```android
<PreferenceScreen
	xmlns:android="http://schemas.android.com/apk/res/android"
	android:id="@+id/pref_screen">

	<PreferenceCategory
		android:title="Theme Settings">

		<com.jb15613.preference.themechooser.ThemeChooserPreference
			android:key="themeColorPref"
            android:title="Theme Color"
			default="Light Blue"
			android:dialogTitle="Theme Chooser"/>

    </PreferenceCategory>
	
</PreferenceScreen>
```

* Make sure you update values and register a PreferenceChangeListener
```android
public class SettingsFragment extends PreferenceFragment {

  ThemeChooserPreference mThemePreference;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// Load the preferences from an XML resource
	addPreferencesFromResource(R.xml.preferences);
  }
  
  @Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = super.onCreateView(inflater, container, savedInstanceState);

		// The Pref Manager
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
   
        mThemePreference = (ThemeChooserPreference) getPreferenceManager().findPreference("themeColorPref");
		
		String hue = "";

		if (prefs.getBoolean("isLightTheme", false)) {
			hue = " - Light";
		} else {
			hue = " - Dark";
		}
		
		mThemePreference.setSummary(prefs.getString("themeColor", "Light Blue") + hue);
		
		mThemePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
				@Override
				public boolean onPreferenceChange(Preference preference, Object newValue) {
					
					String hue = "";
					
					if (prefs.getBoolean("isLightTheme", false)) {
						hue = " - Light";
					} else {
						hue = " - Dark";
					}
					
					mThemePreference.setSummary(String.valueOf(newValue) + hue);
					return true;
				}
			});	

		return view; 
		
	} // onCreateView
  
} // Class
```

* Set the Theme in your Activity
```android
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
		
	setTheme(ThemeChooserUtils.getTheme(this));
	
	// Make sure you call setTheme() BEFORE you call setContentView()
	
    setContentView(R.layout.main);
    
  } // onCreate
  
} // Class
```

## Utilities
* To theme views in layout resources use the following syntax
```android
// Theme Color
android:background="?attr/colorPrimary"

// Theme Color Dark
android:background="?attr/colorPrimaryDark"

// Theme Color Accent
android:background="?attr/colorPrimaryAccent"

// Primary Bg Color
android:background="?attr/primaryBgColor"

// Secondary Bg Color
android:background="?attr/secondaryBgColor"

// Primary Text Color
android:textColor="?attr/primaryTextColor"

// Secondary Text Color
android:textColor="?attr/secondaryTextColor"
```

* To theme views in Java use the following syntax
```android
// provide a float between 0.0 and 1.0 to get the theme color with opacity
// 0.0 is transparent, 1.0 is fully opaque
  
// Theme Color
ThemeChooserUtils.getThemeColor(context);
ThemeChooserUtils.getThemeColor(context, float);
  
// Theme Color Dark
ThemeChooserUtils.getThemeDarkColor(context);
ThemeChooserUtils.getThemeDarkColor(context, float);
  
// Theme Color Accent
ThemeChooserUtils.getThemeAccentColor(context);
ThemeChooserUtils.getThemeAccentColor(context, float);
  
// Background Color
ThemeChooserUtils.getPrimaryBgColor(context);
ThemeChooserUtils.getSecondaryBgColor(context);
  
// Text Color
ThemeChooserUtils.getPrimaryTextColor(context);
ThemeChooserUtils.getSecondaryTextColor(context);
```

## Screenshots
![Screen 1](https://github.com/johnnyb15613/MTCPref/blob/master/screenshots/screen_1.png)

![Screen 2](https://github.com/johnnyb15613/MTCPref/blob/master/screenshots/screen_2.png)

![Screen 3](https://github.com/johnnyb15613/MTCPref/blob/master/screenshots/screen_3.png)

