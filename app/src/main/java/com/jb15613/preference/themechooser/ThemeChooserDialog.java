package com.jb15613.preference.themechooser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import android.support.v7.widget.CardView;

public class ThemeChooserDialog extends DialogFragment {

	// Context
    Context mContext;

	// Dialog
    AlertDialog mAlertDialog;

	// Layout to add Accent Items to
	LinearLayout mAccentLayout;
	// Layout to add Swatch Items to
    TableLayout mTableLayout;
	// Switch for Light/Dark
    Switch mSwitch;

	// Keys for preferences
	final String mPrefKey = "mtc_pref_preferences";
    final String mIsLightThemeKey = "isLightTheme";
    final String mThemeKey = "themeColor";
	final String mAccentKey = "accentColor";
	final String mCellDimenKey = "cellSize";
	
	// isLandscape
	boolean isPortrait;

	// Theme Cange Listener
    OnThemeChangedListener mListener;

	// Preferences
    SharedPreferences mPrefs;
	
	// 
	boolean mAccentClicked = false;

	// Interface linked to ThemeChooserPreference
    public interface OnThemeChangedListener {
        void onThemeChanged(String theme, boolean hue);
    } // OnThemeChangedListener

    public ThemeChooserDialog(){
	} // Constructor

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Dialog);
        mContext = getActivity();
        mPrefs = mContext.getSharedPreferences(mPrefKey, Context.MODE_PRIVATE);
    } // onCreate

    public Dialog onCreateDialog(Bundle bundle) {

		// Inflate layoyt
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.themechooser_dialog, null);
		
		int w = this.getResources().getDisplayMetrics().widthPixels;
		int h = this.getResources().getDisplayMetrics().heightPixels;
		
		if (w > h) {
			isPortrait = false;
		} else if (w < h) {
			isPortrait = true;
		} else if (w == h) {
			isPortrait = true;
		}
		
		// set cell size if it hasn't already been done
		if (getCellSize() == 0) {
			int width = this.getResources().getDisplayMetrics().widthPixels;
			int cellDimen = width / 6;
			setCellSize(cellDimen);
		}

		// get views
		mAccentLayout = (LinearLayout) view.findViewById(R.id.tcd_accentContainer);
        mTableLayout = (TableLayout) view.findViewById(R.id.tcd_tableLayout);
        mSwitch = (Switch) view.findViewById(R.id.tcd_switch);

		// set switch position
        mSwitch.setChecked(getIsLightTheme());
		// set switch listener
        mSwitch.setOnCheckedChangeListener(mSwitchListener);

		// start building the table
        initializeTable();

		// ThemeWrapper for the Dialog
        ContextThemeWrapper context;

        if (Build.VERSION.SDK_INT >= 21) {
            if (getIsLightTheme()) {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Material_Light_Dialog);
            } else {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Material_Dialog);
            } // if theme is light or dark

        } else {
            if (getIsLightTheme()) {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Light_Dialog);
            } else {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Dialog);
            } // if theme is light or dark

        } // if we are running on Jellybean or lower

		// set switch text color
        if (getIsLightTheme()) {
            mSwitch.setTextColor(0xff000000);
        } else {
            mSwitch.setTextColor(0xffffffff);
        }

		// create dialog
        mAlertDialog = new AlertDialog.Builder(context).setTitle("MTCPref").setView(view).create();

		// return dialog
        return this.mAlertDialog;

    } // onCreateDialog

    public void setOnThemeChangedListener(OnThemeChangedListener listener) {
        mListener = listener;
    } // setOnThemeChangedListener
	
	// Processes and builds the dialog
    public void initializeTable() {

        ArrayList<CardView> array = getCellsArray();

        ArrayList<TableRow> rows = new ArrayList<>();

        int counter = 0;

        TableRow tr = null;

        for (int i = 0; i < array.size(); i++) {

            counter++;

            if (counter == 1) {
                tr = new TableRow(mContext);
                tr.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                tr.setPadding(10, 5, 10, 5);
            }

            CardView lay = array.get(i);
            lay.setOnClickListener(swatchClickListener);
			
            tr.addView(lay);
			
			if (isPortrait) {
				
				if ((counter == 3) || (i == array.size() - 1)) {
					counter = 0;
					rows.add(tr);
				}
				
			} else {
				
				if (i == array.size() - 1) {
					rows.add(tr);
				}
				
			} // if device is portrait or landscape

        } // for loop

        for (TableRow row : rows) {
            mTableLayout.addView(row);
        } // for each loop
		
		ArrayList<CardView> accentArray = getAccentsArray();

		for (int ii = 0; ii < accentArray.size(); ii++) {

            CardView lay = accentArray.get(ii);
            lay.setOnClickListener(accentClickListener);
			mAccentLayout.addView(lay);

        } // for loop

    } // initializeTable
	
	// Processes Accent Items
	public ArrayList<CardView> getAccentsArray() {

        ArrayList<CardView> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (String th : themesArray) {
            cells.add(getAccentItem(th));
        }

        return cells;
    } // getAccentsArray
	
	/**
	 * Creates a {@code CardView} containing an Accent Item
	 *
	 * @param  themeName a {@code String} 
	 * @return a {@code CardView};
	 */
	public CardView getAccentItem(String themeName) {

        int[] colors = ColorUtils.getColorSet(themeName, mContext);

		CardView cv = new CardView(mContext);
        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);
		
		LinearLayout.LayoutParams cvParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
		cvParams.setMargins(4, 2, 4, 2);
		cvParams.weight = 1.0f;
		cv.setLayoutParams(cvParams);
		cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(mContext));
		cv.setCardElevation(5f);

        CardView.LayoutParams llParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
		ll.setPadding(3, 3, 3, 3);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(getCellSize(), getCellSize());
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(mContext);

        ImageView circle = new ImageView(mContext);
        ImageView checked = new ImageView(mContext);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams circleParams = new RelativeLayout.LayoutParams((getCellSize() / 2) + 30, (getCellSize() / 2) + 30);
        RelativeLayout.LayoutParams checkedParams = new RelativeLayout.LayoutParams(getCellSize() / 2, getCellSize() / 2);
		
        tv.setLayoutParams(tvParams);
        tv.setGravity(Gravity.CENTER);

        circle.setLayoutParams(circleParams);
        checked.setLayoutParams(checkedParams);

        loadDrawable("circle" + themeName, circle, R.drawable.themechooser_shape_circle, colors[0]);
        
		if (getIsLightTheme()) {
			loadDrawable("checked" + themeName, checked, R.drawable.checkmark, 0xff000000);
		} else {
			loadDrawable("checked" + themeName, checked, R.drawable.checkmark, 0xffffffff);
		}

        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        tv.setText(themeName);
        tv.setTextColor(colors[0]);

        rl.addView(circle);
		rl.addView(checked);
       
        ll.addView(rl);
        ll.addView(tv);

        String tn = getThemeName();

		if (tn.contains(" \u0026 ")) {
			String[] t = tn.split(" \u0026 ");
			if (t[1].equals(themeName)) {
				checked.setVisibility(View.VISIBLE);
			} else {
				checked.setVisibility(View.INVISIBLE);
			}
		} else {
			if (tn.equals(themeName)) {
				checked.setVisibility(View.VISIBLE);
			} else {
				checked.setVisibility(View.INVISIBLE);
			}
		}

        checked.setTag("checked");

		cv.setTag(themeName);
		cv.addView(ll);
		
        return cv;
    } // getAccentItem

	// Processes Swatch Items
    public ArrayList<CardView> getCellsArray() {

        ArrayList<CardView> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (String th : themesArray) {
            cells.add(getCellItem(th));
        }

        return cells;
    } // getCellsArray

	/**
	 * Creates a {@code CardView} containing a Swatch Item
	 *
	 * @param  themeName a {@code String} 
	 * @return a {@code CardView};
	 */
    public CardView getCellItem(String themeName) {

        int[] colors = ColorUtils.getColorSet(themeName, mContext);

		CardView cv = new CardView(mContext);
        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);
		
		TableRow.LayoutParams cvParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT);
		cvParams.setMargins(4, 2, 4, 2);
		if (isPortrait) {
			cvParams.weight = 1.0f;
		}
		cv.setLayoutParams(cvParams);
		cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(mContext));
		cv.setCardElevation(5f);
		
        CardView.LayoutParams llParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
		ll.setPadding(3, 3, 3, 3);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(getCellSize(), getCellSize());
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(mContext);

        ImageView bottomCircle = new ImageView(mContext);
        ImageView middleCircle = new ImageView(mContext);
        ImageView topCircle = new ImageView(mContext);
        ImageView checked = new ImageView(mContext);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams bottomCircleParams = new RelativeLayout.LayoutParams(getCellSize() / 2, getCellSize() / 2);
        RelativeLayout.LayoutParams middleCircleParams = new RelativeLayout.LayoutParams(getCellSize() / 2, getCellSize() / 2);
        RelativeLayout.LayoutParams topCircleParams = new RelativeLayout.LayoutParams(getCellSize() / 2, getCellSize() / 2);
        RelativeLayout.LayoutParams checkedParams = new RelativeLayout.LayoutParams(getCellSize() - 8, getCellSize() - 8);

        tv.setLayoutParams(tvParams);
        tv.setGravity(Gravity.CENTER);

        bottomCircle.setLayoutParams(bottomCircleParams);
        middleCircle.setLayoutParams(middleCircleParams);
        topCircle.setLayoutParams(topCircleParams);
        checked.setLayoutParams(checkedParams);

        loadDrawable("bottomCircle" + themeName, bottomCircle, R.drawable.themechooser_shape_circle, colors[2]);
        loadDrawable("middleCircle" + themeName, middleCircle, R.drawable.themechooser_shape_circle, colors[0]);
        loadDrawable("topCircle" + themeName, topCircle, R.drawable.themechooser_shape_circle, colors[1]);
		
		if (getIsLightTheme()) {
			loadDrawable("checked" + themeName, checked, R.drawable.checkmark, 0xff000000);
		} else {
			loadDrawable("checked" + themeName, checked, R.drawable.checkmark, 0xffffffff);
		}

        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        middleCircleParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        tv.setText(themeName);
        tv.setTextColor(colors[0]);

        rl.addView(bottomCircle);
        rl.addView(middleCircle);
        rl.addView(topCircle);
        rl.addView(checked);

        ll.addView(rl);
        ll.addView(tv);
		
		String tn = getThemeName();
		
		if (tn.contains(" \u0026 ")) {
			String[] t = tn.split(" \u0026 ");
			if (t[0].equals(themeName)) {
				checked.setVisibility(View.VISIBLE);
			} else {
				checked.setVisibility(View.INVISIBLE);
			}
		} else {
			if (tn.equals(themeName)) {
				checked.setVisibility(View.VISIBLE);
			} else {
				checked.setVisibility(View.INVISIBLE);
			}
		}

        checked.setTag("checked");
		
		cv.setTag(themeName);
		cv.addView(ll);

        return cv;
    } // getCellItem

	// Switch Listener
    CompoundButton.OnCheckedChangeListener mSwitchListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            
            if (isChecked) {
                setIsLightTheme(true);
            } else {
                setIsLightTheme(false);
            } // if theme is light or dark

            if (mListener != null) {
                mListener.onThemeChanged(getThemeName(), getIsLightTheme());
            } // if listener is not null

        } // onCheckChanged
		
    }; // mSwitchListener

	// SwatchListener
    View.OnClickListener swatchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ViewGroup vg = (ViewGroup) v.getParent();
            ViewGroup master = (ViewGroup) vg.getParent();

            String themeName = v.getTag().toString();
			String accentName = getAccentName();
			
			if (mAccentClicked) {
				
				if (themeName.equals(accentName)) {
					setThemeName(themeName);
				} else {
					setThemeName(themeName + " \u0026 " + accentName);
				} // if theme and accent colors identical or not
				
			} else {
				setThemeName(themeName);
			} // if an accent item was clicked or not
			
            removeOldCheckFromTable(master);

            ImageView checked = (ImageView) v.findViewWithTag("checked");
            checked.setVisibility(View.VISIBLE);

            if (mListener != null) {
                mListener.onThemeChanged(themeName, getIsLightTheme());
            } // if listener is not null

        } // onClick
		
    }; // swatchClickListener
	
	// AccentListener
	View.OnClickListener accentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
			
			mAccentClicked = true;
			
			ViewGroup vg = (ViewGroup) v.getParent();
			ViewGroup master = (ViewGroup) vg.getParent();
			
			removeOldCheckFromAccent(master);

            String accentName = v.getTag().toString();
			
			String themeName = getThemeName();
			if (themeName.contains(" \u0026 ")) {
				String[] items = themeName.split(" \u0026 ");
				themeName = items[0];
			} // if theme has custom accent color
			
			if (themeName.equals(accentName)) {
				setThemeName(themeName);
			} else {
				themeName = themeName + " \u0026 " + accentName;
				setThemeName(themeName);
			} // if accent color matches theme color or not
			
			ImageView checked = (ImageView) v.findViewWithTag("checked");
            checked.setVisibility(View.VISIBLE);
			
            if (mListener != null) {
                mListener.onThemeChanged(themeName, getIsLightTheme());
            } // if listener is not null

        } // onClick
		
    }; // accentClickListener


	/**
	 * Removes Checkmark Icon from Swatch Table
	 *
	 * @param  vg a {@code ViewGroup} that is the parent container for swatch items (TableLayout)
	 */
    public void removeOldCheckFromTable(ViewGroup vg) {

        for (int i = 0; i < vg.getChildCount(); i++) {

            TableRow tr = (TableRow) vg.getChildAt(i);

            for (int ii = 0; ii < tr.getChildCount(); ii++) {

				CardView cv = (CardView) tr.getChildAt(ii);
                LinearLayout ll = (LinearLayout) cv.getChildAt(0);
                RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

                ImageView checked = (ImageView) rl.findViewWithTag("checked");

                if (checked.getVisibility() == View.VISIBLE) {
                    checked.setVisibility(View.INVISIBLE);
                } // if view is visible

            } // for each item in tablerow

        } // for each TableRow

    } // removeOldCheckFromTable
	
	/**
	 * Removes Checkmark Icon from Accent Table
	 *
	 * @param  vg a {@code ViewGroup} that is the parent container for swatch items (LinearLayout)
	 */
	public void removeOldCheckFromAccent(ViewGroup vg) {

        for (int i = 0; i < vg.getChildCount(); i++) {

            LinearLayout tr = (LinearLayout) vg.getChildAt(i);

            for (int ii = 0; ii < tr.getChildCount(); ii++) {

                CardView cv = (CardView) tr.getChildAt(ii);
                LinearLayout ll = (LinearLayout) cv.getChildAt(0);
                RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

                ImageView checked = (ImageView) rl.findViewWithTag("checked");

                if (checked.getVisibility() == View.VISIBLE) {
                    checked.setVisibility(View.INVISIBLE);
                } // if view is visible

            } // for each item in linearlayout

        } // for each TableRow

    } // removeOldCheckFromAccent

	/**
	 * Sets Theme Hue to SharedPreferences
	 *
	 * @param  v a {@code boolean} that is {@code true} for light theme, {@code false} for dark theme
	 */
    public void setIsLightTheme(boolean v) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(mIsLightThemeKey, v);
        editor.apply();
    } // setIsLightTheme

	/**
	 * Gets Theme Hie from SharedPreferences
	 *
	 * return  isLightTheme a {@code boolean} that is {@code true} for light theme, {@code false} for dark theme
	 */
    public boolean getIsLightTheme() {
        return mPrefs.getBoolean(mIsLightThemeKey, false);
    } // getIsLightTheme

	/**
	 * Sets Theme Name to SharedPreferences
	 *
	 * @param  v a {@code String} that contains the theme name
	 */
    public void setThemeName(String v) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(mThemeKey, v);
        editor.apply();
    } // setThemeName

	/**
	 * Gets Theme Name from SharedPreferences
	 *
	 * return  themeName a {@code String} that contains the theme name
	 */
    public String getThemeName() {
        return mPrefs.getString(mThemeKey, "Light Blue");
    } // getathemeName
	
	/**
	 * Sets Accent Name to SharedPreferences
	 *
	 * @param  v a {@code String} that contains the theme name
	 */
	public void setAccentName(String v) {
		SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(mAccentKey, v);
        editor.apply();
	} // setAccentName
	
	/**
	 * Gets Accent Name from SharedPreferences
	 *
	 * return  accentName a {@code String} that contains the accent name
	 */
	public String getAccentName() {
		return mPrefs.getString(mAccentKey, "Light Blue");
	} // getAccentName
	
	/**
	 * Sets Cell Size to SharedPreferences
	 *
	 * @param  v an {@code int} that is the height and width of Cell Items
	 */
	public void setCellSize(int v) {
		SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt(mCellDimenKey, v);
        editor.apply();
	} // setCellSize

	/**
	 * Gets Cell Size from SharedPreferences
	 *
	 * @return  v an {@code int} that is the height and width of Cell Items
	 */
	public int getCellSize() {
		return mPrefs.getInt(mCellDimenKey, 0);
	} // getCellSize

	/**
	 * Loads drawables asynchronously
	 *
	 * @param  title a {@code String} that is used to identify a drawable
	 * @param  imageView an {@code ImageView} that the drawable will be bound to
	 * @param  id an {@code int} that is the ResourceId of the Drawable
	 * @param  color an {@code int} that represents the color we want to make the drawable
	 */
    public void loadDrawable(String title, ImageView imageView, int id, int color) {
        if (ImageLoader.cancelPotentialWork(title, imageView)) {

            final ImageLoader task = new ImageLoader(imageView, mContext, id, color);
            final ImageLoader.AsyncDrawable asyncDrawable = new ImageLoader.AsyncDrawable(mContext.getResources(), task);

            imageView.setImageDrawable(asyncDrawable);

            task.execute(title);
        } // if work is not already ongoing
		
    } // loadDrawable

} // Class
