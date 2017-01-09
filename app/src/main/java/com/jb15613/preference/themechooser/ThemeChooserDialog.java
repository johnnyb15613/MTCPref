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

public class ThemeChooserDialog extends DialogFragment {

    Context mContext;

    AlertDialog mAlertDialog;

	LinearLayout mAccentLayout;
    TableLayout mTableLayout;
    Switch mSwitch;

    final String mIsLightThemeKey = "isLightTheme";
    final String mThemeKey = "themeColor";
	final String mAccentKey = "accentColor";
	final String mCellDimenKey = "cellSize";

    OnThemeChangedListener mListener;

    SharedPreferences prefs;
	
	boolean accentClicked = false;

    public interface OnThemeChangedListener {
        void onThemeChanged(String theme, boolean hue);
    }

    public ThemeChooserDialog(){}

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Dialog);
        mContext = getActivity();
        prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public Dialog onCreateDialog(Bundle bundle) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.themechooser_dialog, null);
		
		int width = this.getResources().getDisplayMetrics().widthPixels;
		int cellDimen = width / 4;
		setCellSize(cellDimen);

		mAccentLayout = (LinearLayout) view.findViewById(R.id.tcd_accentContainer);
        mTableLayout = (TableLayout) view.findViewById(R.id.tcd_tableLayout);
        mSwitch = (Switch) view.findViewById(R.id.tcd_switch);

        mSwitch.setChecked(getIsLightTheme());
        mSwitch.setOnCheckedChangeListener(mSwitchListener);

        initializeTable();

        ContextThemeWrapper context;

        if (Build.VERSION.SDK_INT >= 21) {
            // Call some material design APIs here
            if (getIsLightTheme()) {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Material_Light_Dialog);
            } else {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Material_Dialog);
            }

        } else {
            // Implement this feature without material design
            if (getIsLightTheme()) {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Light_Dialog);
            } else {
                context = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo_Dialog);
            }

        }

        if (getIsLightTheme()) {
            mSwitch.setTextColor(0xff000000);
        } else {
            mSwitch.setTextColor(0xffffffff);
        }

        mAlertDialog = new AlertDialog.Builder(context).setTitle("Pick Theme Swatch").setView(view).create();

        return this.mAlertDialog;

    }

    /*
    public void onThemeChanged(String theme, boolean hue) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("themeColor", theme);
        editor.putBoolean("isLightTheme", hue);
        editor.apply();

    } */

    public void setOnThemeChangedListener(OnThemeChangedListener listener) {
        mListener = listener;
    }

    public void initializeTable() {

        ArrayList<LinearLayout> array = getCellsArray();

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

            LinearLayout lay = array.get(i);
            lay.setOnClickListener(swatchClickListener);
			lay.setBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(mContext));
            tr.addView(lay);

            if ((counter == 3) || (i == array.size() - 1)) {
                counter = 0;
                rows.add(tr);
            }

        } // for loop

        for (TableRow row : rows) {
            mTableLayout.addView(row);
        } // for each loop
		
		ArrayList<LinearLayout> accentArray = getAccentsArray();

		for (int ii = 0; ii < accentArray.size(); ii++) {

            LinearLayout lay = accentArray.get(ii);
            lay.setOnClickListener(accentClickListener);
			lay.setBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(mContext));
			mAccentLayout.addView(lay);

        } // for loop

    }
	
	public ArrayList<LinearLayout> getAccentsArray() {

        ArrayList<LinearLayout> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (String th : themesArray) {
            cells.add(getAccentItem(th));
        }

        return cells;
    }
	
	public LinearLayout getAccentItem(String themeName) {

        int[] colors = ColorUtils.getColorSet(themeName, mContext);

        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		llParams.setMargins(2, 2, 2, 2);
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
			loadDrawable("checked" + themeName, checked, R.drawable.swatch_check, 0xff000000);
		} else {
			loadDrawable("checked" + themeName, checked, R.drawable.swatch_check, 0xffffffff);
		}

        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        tv.setText(themeName);
        tv.setTextColor(colors[0]);

        rl.addView(circle);
		rl.addView(checked);
       
        ll.addView(rl);
        ll.addView(tv);

        ll.setTag(themeName);

        if (getThemeName().equals(themeName)) {
            checked.setVisibility(View.VISIBLE);
        } else {
            checked.setVisibility(View.INVISIBLE);
        }

        checked.setTag("checked");

        return ll;
    } // getAccentItem

    public ArrayList<LinearLayout> getCellsArray() {

        ArrayList<LinearLayout> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (String th : themesArray) {
            cells.add(getCellItem(th));
        }

        return cells;
    }

    public LinearLayout getCellItem(String themeName) {

        int[] colors = ColorUtils.getColorSet(themeName, mContext);

        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);

        TableRow.LayoutParams llParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
		llParams.setMargins(2, 2, 2, 2);
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
			loadDrawable("checked" + themeName, checked, R.drawable.swatch_check, 0xff000000);
		} else {
			loadDrawable("checked" + themeName, checked, R.drawable.swatch_check, 0xffffffff);
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

        ll.setTag(themeName);
		
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

        return ll;
    } // getCellItem

    CompoundButton.OnCheckedChangeListener mSwitchListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // true if the switch is in the On position
            if (isChecked) {
                setIsLightTheme(true);
            } else {
                setIsLightTheme(false);
            }

            if (mListener != null) {
                mListener.onThemeChanged(getThemeName(), getIsLightTheme());
            }

        }
    };

    View.OnClickListener swatchClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ViewGroup vg = (ViewGroup) v.getParent();
            ViewGroup master = (ViewGroup) vg.getParent();

            String themeName = v.getTag().toString();
			String accentName = getAccentName();
			
			if (accentClicked) {
				if (themeName.equals(accentName)) {
					setThemeName(themeName);
				} else {
					setThemeName(themeName + " \u0026 " + accentName);
				}
			} else {
				setThemeName(themeName);
			}
			
            removeOldCheckFromTable(master);

            ImageView checked = (ImageView) v.findViewWithTag("checked");
            checked.setVisibility(View.VISIBLE);

            if (mListener != null) {
                mListener.onThemeChanged(themeName, getIsLightTheme());
            }

        }
    };
	
	View.OnClickListener accentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
			
			accentClicked = true;
			
			ViewGroup vg = (ViewGroup) v.getParent();
			ViewGroup master = (ViewGroup) vg.getParent();
			
			removeOldCheckFromAccent(master);

            String accentName = v.getTag().toString();
			
			String themeName = getThemeName();
			if (themeName.contains(" \u0026 ")) {
				String[] items = themeName.split(" \u0026 ");
				themeName = items[0];
			}
			
			if (themeName.equals(accentName)) {
				setThemeName(themeName);
			} else {
				themeName = themeName + " \u0026 " + accentName;
				setThemeName(themeName);
			}
			
			ImageView checked = (ImageView) v.findViewWithTag("checked");
            checked.setVisibility(View.VISIBLE);
			
            if (mListener != null) {
                mListener.onThemeChanged(themeName, getIsLightTheme());
            }

        }
    };


    public void removeOldCheckFromTable(ViewGroup vg) {

        for (int i = 0; i < vg.getChildCount(); i++) {

            TableRow tr = (TableRow) vg.getChildAt(i);

            for (int ii = 0; ii < tr.getChildCount(); ii++) {

                LinearLayout ll = (LinearLayout) tr.getChildAt(ii);
                RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

                ImageView checked = (ImageView) rl.findViewWithTag("checked");

                if (checked.getVisibility() == View.VISIBLE) {
                    checked.setVisibility(View.INVISIBLE);
                }

            } // for each item in tablerow

        } // for each TableRow

    }
	
	public void removeOldCheckFromAccent(ViewGroup vg) {

        for (int i = 0; i < vg.getChildCount(); i++) {

            LinearLayout tr = (LinearLayout) vg.getChildAt(i);

            for (int ii = 0; ii < tr.getChildCount(); ii++) {

                LinearLayout ll = (LinearLayout) tr.getChildAt(ii);
                RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

                ImageView checked = (ImageView) rl.findViewWithTag("checked");

                if (checked.getVisibility() == View.VISIBLE) {
                    checked.setVisibility(View.INVISIBLE);
                }

            } // for each item in linearlayout

        } // for each TableRow

    }

    public void setIsLightTheme(boolean v) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(mIsLightThemeKey, v);
        editor.apply();
    }

    public boolean getIsLightTheme() {
        return prefs.getBoolean(mIsLightThemeKey, false);
    }

    public void setThemeName(String v) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(mThemeKey, v);
        editor.apply();
    }

    public String getThemeName() {
        return prefs.getString(mThemeKey, "Light Blue");
    }
	
	public void setAccentName(String v) {
		SharedPreferences.Editor editor = prefs.edit();
        editor.putString(mAccentKey, v);
        editor.apply();
	}
	
	public String getAccentName() {
		return prefs.getString(mAccentKey, "Light Blue");
	}
	
	public void setCellSize(int v) {
		SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(mCellDimenKey, v);
        editor.apply();
	}

	public int getCellSize() {
		return prefs.getInt(mCellDimenKey, 0);
	}

    public void loadDrawable(String title, ImageView imageView, int id, int color) {
        if (ImageLoader.cancelPotentialWork(title, imageView)) {

            final ImageLoader task = new ImageLoader(imageView, mContext, id, color);
            final ImageLoader.AsyncDrawable asyncDrawable = new ImageLoader.AsyncDrawable(mContext.getResources(), task);

            imageView.setImageDrawable(asyncDrawable);

            task.execute(title);
        } // if work is not already ongoing
    } // loadBitmap

} // Class
