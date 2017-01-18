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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.jb15613.preference.utility.ColorUtils;
import com.jb15613.preference.utility.ImageLoader;
import com.jb15613.preference.utility.ThemeChooserUtils;
import java.util.ArrayList;
import com.jb15613.preference.utility.Constants;
import com.jb15613.preference.utility.PrefUtils;

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
	ScrollView mScrollView;
	// Layout to add Portrait Swatch Items to
    TableLayout mPortraitContainer;
	
	// ScrollView to add Landscape 
	HorizontalScrollView mHorizontalScrollView;
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
		mScrollView = (ScrollView) view.findViewById(R.id.tcd_portraitSwatchParent);
		mHorizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.tcd_landSwatchParent);
        mPortraitContainer = (TableLayout) view.findViewById(R.id.tcd_portraitSwatchContainer);
		mLandscapeContainer = (LinearLayout) view.findViewById(R.id.tcd_landSwatchContainer);
        mSwitch = (Switch) view.findViewById(R.id.tcd_switch);
		
		if (isPortrait) {
			mScrollView.setVisibility(View.VISIBLE);
			mHorizontalScrollView.setVisibility(View.GONE);
		} else {
			mScrollView.setVisibility(View.GONE);
			mHorizontalScrollView.setVisibility(View.VISIBLE);
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

    public void setOnThemeChangedListener(OnThemeChangedListener listener) {
        mListener = listener;
    } // setOnThemeChangedListener
	
	// Processes and builds the dialog
    public void initializeTable() {
		
		ArrayList<CardView> portraitSwatchArray = getCellsArray(true);
		ArrayList<CardView> landscapeSwatchArray = getCellsArray(false);
		
		ArrayList<TableRow> rows = new ArrayList<>();

		// need to count how many items we add to tablerow
		int counter = 0;

		TableRow tr = null;

		for (int i = 0; i < portraitSwatchArray.size(); i++) {

			counter++;
			
			CardView cv = null;
			
			if (getIsPortrait()) {
				
				cv = portraitSwatchArray.get(i);
				cv.setOnClickListener(swatchClickListener);
				
				if (counter == 1) {
					tr = new TableRow(mContext);
					tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
					tr.setPadding(10, 5, 10, 5);
				}

				tr.addView(cv);

				if ((counter == 3) || (i == portraitSwatchArray.size() - 1)) {
					counter = 0;
					rows.add(tr);
				} // if its the 3rd item in group or if its the last item
				
			} else {
				
				cv = landscapeSwatchArray.get(i);
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
		
		LinearLayout.LayoutParams cvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
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
		
		int cellSize = PrefUtils.getCellSize(mContext);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(cellSize, cellSize);
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(mContext);

        ImageView circle = new ImageView(mContext);
        ImageView checked = new ImageView(mContext);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams circleParams = new RelativeLayout.LayoutParams((cellSize / 2) + 30, (cellSize / 2) + 30);
        RelativeLayout.LayoutParams checkedParams = new RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2);
		
        tv.setLayoutParams(tvParams);
        tv.setGravity(Gravity.CENTER);

        circle.setLayoutParams(circleParams);
        checked.setLayoutParams(checkedParams);

        loadDrawable("circle" + themeName, circle, R.drawable.themechooser_shape_circle, colors[0]);
        
		if (PrefUtils.getThemeHue(mContext)) {
			loadDrawable(Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xff000000);
		} else {
			loadDrawable(Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xffffffff);
		}

        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        tv.setText(themeName);
        tv.setTextColor(colors[0]);

        rl.addView(circle);
		rl.addView(checked);
       
        ll.addView(rl);
        ll.addView(tv);

        String tn = PrefUtils.getThemeColor(mContext);

		if (tn.contains(Constants.THEME_SPLITTER)) {
			String[] t = tn.split(Constants.THEME_SPLITTER);
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

        checked.setTag(Constants.VIEW_CHECKED);
		
		cv.setTag(themeName);
		cv.addView(ll);
		
        return cv;
    } // getAccentItem

	// Processes Swatch Items
    public ArrayList<CardView> getCellsArray(boolean portrait) {

        ArrayList<CardView> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (String th : themesArray) {
            cells.add(getCellItem(th, portrait));
        }

        return cells;
    } // getCellsArray

	/**
	 * Creates a {@code CardView} containing a Swatch Item
	 *
	 * @param  themeName a {@code String} 
	 * @return a {@code CardView};
	 */
    public CardView getCellItem(String themeName, boolean portrait) {

        int[] colors = ColorUtils.getColorSet(themeName, mContext);

		CardView cv = new CardView(mContext);
        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);
		
		if (getIsPortrait()) {
			TableRow.LayoutParams cvParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT);
			cvParams.setMargins(4, 2, 4, 2);
			if (isPortrait) {
				cvParams.weight = 1.0f;
			}
			cv.setLayoutParams(cvParams);
			cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(mContext));
			cv.setCardElevation(5f);
		} else {
			LinearLayout.LayoutParams cvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			cvParams.setMargins(4, 2, 4, 2);
			if (isPortrait) {
				cvParams.weight = 1.0f;
			}
			cv.setLayoutParams(cvParams);
			cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(mContext));
			cv.setCardElevation(5f);
		}
		
        CardView.LayoutParams llParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
		ll.setPadding(3, 3, 3, 3);
		
		int cellSize = PrefUtils.getCellSize(mContext);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(cellSize, cellSize);
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(mContext);

        ImageView bottomCircle = new ImageView(mContext);
        ImageView middleCircle = new ImageView(mContext);
        ImageView topCircle = new ImageView(mContext);
        ImageView checked = new ImageView(mContext);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams bottomCircleParams = new RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2);
        RelativeLayout.LayoutParams middleCircleParams = new RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2);
        RelativeLayout.LayoutParams topCircleParams = new RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2);
        RelativeLayout.LayoutParams checkedParams = new RelativeLayout.LayoutParams(cellSize - 8, cellSize - 8);

        tv.setLayoutParams(tvParams);
        tv.setGravity(Gravity.CENTER);

        bottomCircle.setLayoutParams(bottomCircleParams);
        middleCircle.setLayoutParams(middleCircleParams);
        topCircle.setLayoutParams(topCircleParams);
        checked.setLayoutParams(checkedParams);

        loadDrawable("bottomCircle" + themeName, bottomCircle, R.drawable.themechooser_shape_circle, colors[2]);
        loadDrawable("middleCircle" + themeName, middleCircle, R.drawable.themechooser_shape_circle, colors[0]);
        loadDrawable("topCircle" + themeName, topCircle, R.drawable.themechooser_shape_circle, colors[1]);
		
		if (PrefUtils.getThemeHue(mContext)) {
			loadDrawable(Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xff000000);
		} else {
			loadDrawable(Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xffffffff);
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
		
		String tn = PrefUtils.getThemeColor(mContext);
		
		if (tn.contains(Constants.THEME_SPLITTER)) {
			String[] t = tn.split(Constants.THEME_SPLITTER);
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

        checked.setTag(Constants.VIEW_CHECKED);
		
		cv.setTag(themeName);
		cv.addView(ll);

        return cv;
    } // getCellItem

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

            ViewGroup vg = (ViewGroup) v.getParent();
            ViewGroup master = (ViewGroup) vg.getParent();

            String themeName = v.getTag().toString();
			PrefUtils.setThemeColor(mContext, themeName);
			PrefUtils.setAccentColor(mContext, themeName);
			
			int l = v.getLeft();
			int t = v.getTop();
			int r = v.getRight();
			int b = v.getBottom();
			
			int w = l + r ;
			int h = t + b;
			
			int[] values = new int[2]; 
			v.getLocationInWindow(values);
			
            removeOldCheckFromTable(master);
			recheckAccentColor();
			
			if (isPortrait) {
				rescrollAccentItems(themeName);
			} else {
				// Landscape
				rescrollAccentItems(l - (values[0] - (4 * 19)));
			}
			
            ImageView checked = (ImageView) v.findViewWithTag(Constants.VIEW_CHECKED);
            checked.setVisibility(View.VISIBLE);

            if (mListener != null) {
                mListener.onThemeChanged(themeName, PrefUtils.getThemeHue(mContext));
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
			PrefUtils.setAccentColor(mContext, accentName);
			
			String themeName = PrefUtils.getThemeColor(mContext);
			if (themeName.contains(Constants.THEME_SPLITTER)) {
				String[] items = themeName.split(Constants.THEME_SPLITTER);
				themeName = items[0];
			} // if theme has custom accent color
			
			if (themeName.equals(accentName)) {
				PrefUtils.setThemeColor(mContext, themeName);
			} else {
				themeName = themeName + Constants.THEME_SPLITTER + accentName;
				PrefUtils.setThemeColor(mContext, themeName);
			} // if accent color matches theme color or not
			
			ImageView checked = (ImageView) v.findViewWithTag(Constants.VIEW_CHECKED);
            checked.setVisibility(View.VISIBLE);
			
            if (mListener != null) {
                mListener.onThemeChanged(themeName, PrefUtils.getThemeHue(mContext));
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
			
			if (isPortrait) {
				
				TableRow tr = (TableRow) vg.getChildAt(i);

				for (int ii = 0; ii < tr.getChildCount(); ii++) {

					CardView cv = (CardView) tr.getChildAt(ii);
					LinearLayout ll = (LinearLayout) cv.getChildAt(0);
					RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

					ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

					if (checked.getVisibility() == View.VISIBLE) {
						checked.setVisibility(View.INVISIBLE);
					} // if view is visible

				} // for each item in tablerow
				
			} else {
				
				LinearLayout tr = (LinearLayout) vg.getChildAt(0);
				
				for (int ii = 0; ii < tr.getChildCount(); ii++) {

					CardView cv = (CardView) tr.getChildAt(ii);
					LinearLayout ll = (LinearLayout) cv.getChildAt(0);
					RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

					ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

					if (checked.getVisibility() == View.VISIBLE) {
						checked.setVisibility(View.INVISIBLE);
					} // if view is visible

				} // for each item in linearlayout
				
			}


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

                ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

                if (checked.getVisibility() == View.VISIBLE) {
                    checked.setVisibility(View.INVISIBLE);
                } // if view is visible

            } // for each item in linearlayout

        } // for each TableRow

    } // removeOldCheckFromAccent
	
	public void recheckAccentColor() {
		
		for (int i = 0; i < mAccentContainer.getChildCount(); i++) {
			
			CardView cv = (CardView) mAccentContainer.getChildAt(i);
			LinearLayout ll = (LinearLayout) cv.getChildAt(0);
			RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

			ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

			if (checked.getVisibility() == View.VISIBLE) {
				checked.setVisibility(View.INVISIBLE);
			} // if view is visible
			
			String tn = PrefUtils.getThemeColor(mContext);
			if (tn.contains(Constants.THEME_SPLITTER)) {
				String[] items = tn.split(Constants.THEME_SPLITTER);
				tn = items[0];
			} // if theme has custom accent color
			
			if (cv.getTag().toString().equals(tn)) {
				checked.setVisibility(View.VISIBLE);
				PrefUtils.setAccentColor(mContext, cv.getTag().toString());
			}
			
		}
		
	}
	
	public void rescrollAccentItems(int l) {
			mAccentParent.setScrollX(l);
	}
	
	public void rescrollAccentItems(String tn) {
		
		ArrayList<String> leftsTags = new ArrayList<>();
		ArrayList<Integer> lefts = new ArrayList<>();
		
		for (int i = 0; i < mAccentContainer.getChildCount(); i++) {
			CardView cv = (CardView) mAccentContainer.getChildAt(i);
			leftsTags.add(cv.getTag().toString());
			lefts.add(cv.getLeft());
		}
		
		int dl = 0;
		
		switch (tn) {
			case Constants.RED:
				dl = lefts.get(0);
				break;
			case Constants.PINK:
				dl = lefts.get(1);
				break;
			case Constants.PURPLE:
				dl = lefts.get(2);
				break;
			case Constants.DEEPPURPLE:
				dl = lefts.get(3);
				break;
			case Constants.INDIGO:
				dl = lefts.get(4);
				break;
			case Constants.BLUE:
				dl = lefts.get(5);
				break;
			case Constants.LIGHTBLUE:
				dl = lefts.get(6);
				break;
			case Constants.CYAN:
				dl = lefts.get(7);
				break;
			case Constants.TEAL:
				dl = lefts.get(8);
				break;
			case Constants.GREEN:
				dl = lefts.get(9);
				break;
			case Constants.LIGHTGREEN:
				dl = lefts.get(10);
				break;
			case Constants.LIME:
				dl = lefts.get(11);
				break;
			case Constants.YELLOW:
				dl = lefts.get(12);
				break;
			case Constants.AMBER:
				dl = lefts.get(13);
				break;
			case Constants.ORANGE:
				dl = lefts.get(14);
				break;
			case Constants.DEEPORANGE:
				dl = lefts.get(15);
				break;
			case Constants.BROWN:
				dl = lefts.get(16);
				break;
			case Constants.GREY:
				dl = lefts.get(17);
				break;
			case Constants.BLUEGREY:
				dl = lefts.get(18);
				break;
		}
		
		mAccentParent.setScrollX(dl);
		
	}

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
	
	public int getOrientationValue() {
		return getResources().getConfiguration().orientation;
	}
	
	public boolean getIsPortrait() {
		
		boolean v;
		
		if (getResources().getConfiguration().orientation == 1) {
			v = true;
		} else {
			v = false;
		}
		
		return v;
		
	}

} // Class
