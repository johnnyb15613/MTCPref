package com.jb15613.preference.themechooser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.jb15613.preference.utility.Constants;
import com.jb15613.preference.utility.DialogUtils;
import com.jb15613.preference.utility.PrefUtils;
import java.util.ArrayList;

public class ThemeChooserDialog extends DialogFragment {

	// Context
    Context mContext;

	// Dialog
    AlertDialog mAlertDialog;

	// Accent Scroll View
	HorizontalScrollView mAccentParent;
	// Layout to add Accent Items to
	LinearLayout mAccentContainer;
	
	// ScrollView to add Portrait 
	ScrollView mPortraitParent;
	// Layout to add Portrait Swatch Items to
    TableLayout mPortraitContainer;
	
	// ScrollView to add Landscape 
	HorizontalScrollView mLandscapeParent;
	// Layout to add Landscape Swatch Items to
    LinearLayout mLandscapeContainer;
	
	// Switch for Light/Dark
    Switch mSwitch;

	// isLandscape
	boolean isPortrait;

	// Theme Cange Listener
    OnThemeChangedListener mListener;

	// Preferences
    SharedPreferences mPrefs;

	// Interface linked to ThemeChooserPreference
    public interface OnThemeChangedListener {
        void onThemeChanged(String theme, boolean hue);
    } // OnThemeChangedListener
	
	public void setOnThemeChangedListener(OnThemeChangedListener listener) {
        mListener = listener;
    } // setOnThemeChangedListener

    public ThemeChooserDialog(){
	} // Constructor
	
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Dialog);
        mContext = getActivity();
        mPrefs = mContext.getSharedPreferences(Constants.PREF_NAME_KEY, Context.MODE_PRIVATE);
		
		switch (getResources().getConfiguration().orientation) {
			case 1:
				isPortrait = true;
				break;
			case 2:
				isPortrait = false;
				break;

		} // switch getOrientation
		
    } // onCreate
	
    public Dialog onCreateDialog(Bundle bundle) {

		// Inflate layoyt
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.themechooser_dialog, null);
		
		// set cell size if it hasn't already been done
		if (PrefUtils.getCellSize(mContext) == 0) {
			int width = this.getResources().getDisplayMetrics().widthPixels;
			int cellDimen = width / 6;
			PrefUtils.setCellSize(mContext, cellDimen);
		}

		// get views
		mAccentParent = (HorizontalScrollView) view.findViewById(R.id.tcd_accentParent);
		mAccentContainer = (LinearLayout) view.findViewById(R.id.tcd_accentContainer);
		mPortraitParent = (ScrollView) view.findViewById(R.id.tcd_portraitSwatchParent);
		mLandscapeParent = (HorizontalScrollView) view.findViewById(R.id.tcd_landSwatchParent);
        mPortraitContainer = (TableLayout) view.findViewById(R.id.tcd_portraitSwatchContainer);
		mLandscapeContainer = (LinearLayout) view.findViewById(R.id.tcd_landSwatchContainer);
        mSwitch = (Switch) view.findViewById(R.id.tcd_switch);
		
		if (isPortrait) {
			mPortraitParent.setVisibility(View.VISIBLE);
			mLandscapeParent.setVisibility(View.GONE);
		} else {
			mPortraitParent.setVisibility(View.GONE);
			mLandscapeParent.setVisibility(View.VISIBLE);
		}
		
		// start building the table
        initializeTable();
		
		// set switch position
        mSwitch.setChecked(PrefUtils.getThemeHue(mContext));
		// set switch listener
        mSwitch.setOnCheckedChangeListener(mSwitchListener);

		// ThemeWrapper for the Dialog
        ContextThemeWrapper context;

        if (Build.VERSION.SDK_INT >= 21) {
            if (PrefUtils.getThemeHue(mContext)) {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Material_Light_Dialog);
            } else {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Material_Dialog);
            } // if theme is light or dark

        } else {
            if (PrefUtils.getThemeHue(mContext)) {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Light_Dialog);
            } else {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Dialog);
            } // if theme is light or dark

        } // if we are running on Jellybean or lower

		// set switch text color
        if (PrefUtils.getThemeHue(mContext)) {
            mSwitch.setTextColor(0xff000000);
        } else {
            mSwitch.setTextColor(0xffffffff);
        }
		
		// create dialog
        mAlertDialog = new AlertDialog.Builder(context).setTitle(Constants.DIALOG_TITLE).setView(view).create();

		// return dialog
        return this.mAlertDialog;

    } // onCreateDialog
	
	// Processes and builds the dialog
    public void initializeTable() {
		
		ArrayList<CardView> swatchArray = getSwatchArray();
		
		ArrayList<TableRow> rows = new ArrayList<>();

		// need to count how many items we add to tablerow
		int counter = 0;

		TableRow tr = null;

		for (int i = 0; i < swatchArray.size(); i++) {

			counter++;
			
			CardView cv = null;
			
			if (getIsPortrait()) {
				
				cv = swatchArray.get(i);
				cv.setOnClickListener(swatchClickListener);
				
				if (counter == 1) {
					tr = new TableRow(mContext);
					tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
					tr.setPadding(10, 5, 10, 5);
				}

				tr.addView(cv);

				if ((counter == 3) || (i == swatchArray.size() - 1)) {
					counter = 0;
					rows.add(tr);
				} // if its the 3rd item in group or if its the last item
				
			} else {
				
				cv = swatchArray.get(i);
				cv.setOnClickListener(swatchClickListener);
				
				mLandscapeContainer.addView(cv);
			}

		} // for every item in array loop

		for (TableRow row : rows) {
			mPortraitContainer.addView(row);
		} // for each loop
		
		ArrayList<CardView> accentArray = getAccentsArray();

		for (int ii = 0; ii < accentArray.size(); ii++) {

            CardView lay = accentArray.get(ii);
            lay.setOnClickListener(accentClickListener);
			
			mAccentContainer.addView(lay);

        } // for loop
		
		mAccentParent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				@Override
				public void onGlobalLayout() {
					
					// Ensure you call it only once :
					if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
						mAccentParent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
					} else {
						mAccentParent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
					}
					
					String tn = PrefUtils.getThemeColor(mContext);

					String tName = "";
					String aName = "";

					if (tn.contains(Constants.THEME_SPLITTER)) {
						String[] i = tn.split(Constants.THEME_SPLITTER);
						tName = i[0];
						aName = i[1];
					} else {
						tName = tn;
						String al = "";
						if (tName.equals(Constants.BROWN) || tName.equals(Constants.GREY) || tName.equals(Constants.BLUEGREY)) {
							al = " 3";
						} else {
							al = " A1";
						}
						aName = tName + al;
					}

					// Theme horizontal
					DialogUtils.scrollHorizontalThemePanelTo(tName, mLandscapeParent, mLandscapeContainer);
					// Theme vertical
					DialogUtils.scrollVerticalThemePanelTo(tName, mPortraitParent, mPortraitContainer);
					// Accent
					DialogUtils.scrollHorizontalThemePanelTo(aName, mAccentParent, mAccentContainer);
				
				}
			});
			
		swatchArray.clear();
		accentArray.clear();
			
    } // initializeTable
	
	// Processes Swatch Items
    public ArrayList<CardView> getSwatchArray() {

        ArrayList<CardView> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (String th : themesArray) {
            cells.add(DialogUtils.getSwatchItem(mContext, th, getIsPortrait()));
        }

        return cells;
    } // getSwatchArray
	
	// Processes Accent Items
	public ArrayList<CardView> getAccentsArray() {

        ArrayList<CardView> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.accent_color_names);

        for (String th : themesArray) {
            cells.add(DialogUtils.getAccentItem(mContext, th));
        }

        return cells;
    } // getAccentsArray

	// Switch Listener
    CompoundButton.OnCheckedChangeListener mSwitchListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            
            if (isChecked) {
                PrefUtils.setThemeHue(mContext, true);
            } else {
                PrefUtils.setThemeHue(mContext, false);
            } // if theme is light or dark

            if (mListener != null) {
                mListener.onThemeChanged(PrefUtils.getThemeColor(mContext), PrefUtils.getThemeHue(mContext));
            } // if listener is not null

        } // onCheckChanged
		
    }; // mSwitchListener

	// SwatchListener
    View.OnClickListener swatchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String themeName = v.getTag().toString();
			
			PrefUtils.setThemeColor(mContext, themeName);
			
			String accentLabel = "";

			if (themeName.equals(Constants.BROWN) || themeName.equals(Constants.GREY) || themeName.equals(Constants.BLUEGREY)) {
				accentLabel = " 3";
			} else {
				accentLabel = " A1";
			}
			
			PrefUtils.setAccentColor(mContext, themeName + accentLabel);
			
			DialogUtils.recheckThemeColor(mContext, getIsPortrait(), mPortraitContainer, mLandscapeContainer);
			DialogUtils.recheckAccentColor(mContext, mAccentContainer);
			
			DialogUtils.scrollHorizontalThemePanelTo(themeName, mAccentParent, mAccentContainer);

            if (mListener != null) {
                mListener.onThemeChanged(themeName, PrefUtils.getThemeHue(mContext));
            } // if listener is not null

        } // onClick
		
    }; // swatchClickListener

	// AccentListener
	View.OnClickListener accentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String accentName = v.getTag().toString();
			
			PrefUtils.setAccentColor(mContext, accentName);
			
			String themeName = PrefUtils.getThemeColor(mContext);
			
			if (themeName.contains(Constants.THEME_SPLITTER)) {
				String[] items = themeName.split(Constants.THEME_SPLITTER);
				themeName = items[0];
			} // if theme has custom accent color
			
			themeName = themeName + Constants.THEME_SPLITTER + accentName;
			
			PrefUtils.setThemeColor(mContext, themeName);
			PrefUtils.setAccentColor(mContext, accentName);
			
			DialogUtils.recheckAccentColor(mContext, mAccentContainer);
			
            if (mListener != null) {
                mListener.onThemeChanged(themeName, PrefUtils.getThemeHue(mContext));
            } // if listener is not null

        } // onClick
		
    }; // accentClickListener
	
	/**
	 * Gets device orientation
	 *
	 * @return  a {@code Boolean} that is true if Portrait, false if Landscape
	 */
	public boolean getIsPortrait() {
		
		boolean v;
		
		if (getResources().getConfiguration().orientation == 1) {
			v = true;
		} else {
			v = false;
		}
		
		return v;
		
	} // getIsPortrait

} // Class
