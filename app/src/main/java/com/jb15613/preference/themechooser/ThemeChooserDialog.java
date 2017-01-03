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

    TableLayout mTableLayout;
    Switch mSwitch;

    final String mIsLightThemeKey = "isLightTheme";
    final String mThemeKey = "themeColor";

    OnThemeChangedListener mListener;

    SharedPreferences prefs;

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

    public void onThemeChanged(String theme, boolean hue) {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("themeColor", theme);
        editor.putBoolean("isLightTheme", hue);
        editor.apply();

    }

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
                        TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                tr.setPadding(10, 5, 10, 5);
            }

            LinearLayout lay = array.get(i);
            lay.setOnClickListener(swatchClickListener);
            tr.addView(lay);


            if ((counter == 3) || (i == array.size() - 1)) {
                counter = 0;
                rows.add(tr);
            }

        } // for loop

        for (TableRow row : rows) {
            mTableLayout.addView(row);
        } // for each loop

    }

    public ArrayList<LinearLayout> getCellsArray() {

        ArrayList<LinearLayout> cells = new ArrayList<>();

        String[] themesArray = mContext.getResources().getStringArray(R.array.theme_color_names);

        for (int i = 0; i < themesArray.length; i++) {

            cells.add(getCellItem(themesArray[i]));

        } // for loop themesArray

        return cells;
    }

    public LinearLayout getCellItem(String themeName) {

        int[] colors = getColorSet(themeName);

        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);

        TableRow.LayoutParams llParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(200, 200);
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(mContext);

        ImageView bottomCircle = new ImageView(mContext);
        ImageView middleCircle = new ImageView(mContext);
        ImageView topCircle = new ImageView(mContext);
        ImageView checked = new ImageView(mContext);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams bottomCircleParams = new RelativeLayout.LayoutParams(90, 90);
        RelativeLayout.LayoutParams middleCircleParams = new RelativeLayout.LayoutParams(90, 90);
        RelativeLayout.LayoutParams topCircleParams = new RelativeLayout.LayoutParams(90, 90);
        RelativeLayout.LayoutParams checkedParams = new RelativeLayout.LayoutParams(194, 194);

        tv.setLayoutParams(tvParams);
        tv.setGravity(Gravity.CENTER);

        bottomCircle.setLayoutParams(bottomCircleParams);
        middleCircle.setLayoutParams(middleCircleParams);
        topCircle.setLayoutParams(topCircleParams);
        checked.setLayoutParams(checkedParams);

        loadDrawable("bottomCircle" + themeName, bottomCircle, R.drawable.themechooser_shape_circle, colors[2]);
        loadDrawable("middleCircle" + themeName, middleCircle, R.drawable.themechooser_shape_circle, colors[0]);
        loadDrawable("topCircle" + themeName, topCircle, R.drawable.themechooser_shape_circle, colors[1]);
        loadDrawable("checked" + themeName, checked, R.drawable.swatch_check, 0xffffffff);

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

        if (getThemeName().equals(themeName)) {
            checked.setVisibility(View.VISIBLE);
        } else {
            checked.setVisibility(View.INVISIBLE);
        }

        checked.setTag("checked");

        return ll;
    } // getCellItem

    public int[] getColorSet(String themeName) {

        int[] colors = new int[3];

        switch (themeName.replaceAll(" ", "")) {

            case "Red":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_red, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_red, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_red, null);
                break;

            case "Pink":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_pink, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_pink, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_pink, null);
                break;

            case "Purple":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_purple, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_purple, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_purple, null);
                break;

            case "DeepPurple":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepPurple, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_deepPurple, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepPurple, null);
                break;

            case "Indigo":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_indigo, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_indigo, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_indigo, null);
                break;

            case "Blue":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blue, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_blue, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blue, null);
                break;

            case "LightBlue":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightBlue, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lightBlue, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightBlue, null);
                break;

            case "Cyan":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_cyan, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_cyan, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_cyan, null);
                break;

            case "Teal":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_teal, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_teal, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_teal, null);
                break;

            case "Green":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_green, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_green, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_green, null);
                break;

            case "LightGreen":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lightGreen, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lightGreen, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lightGreen, null);
                break;

            case "Lime":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_lime, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_lime, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_lime, null);
                break;

            case "Yellow":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_yellow, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_yellow, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_yellow, null);
                break;

            case "Amber":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_amber, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_amber, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_amber, null);
                break;

            case "Orange":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_orange, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_orange, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_orange, null);
                break;

            case "DeepOrange":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_deepOrange, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_deepOrange, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_deepOrange, null);
                break;

            case "Brown":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_brown, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_brown, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_brown, null);
                break;

            case "Grey":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_grey, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_grey, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_grey, null);
                break;

            case "BlueGrey":
                colors[0] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primary_blueGrey, null);
                colors[1] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_primaryDark_blueGrey, null);
                colors[2] = ResourcesCompat.getColor(mContext.getResources(), R.color.material_accent_blueGrey, null);
                break;

        }

        return colors;
    }

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
            setThemeName(themeName);

            removeOldCheck(master);

            ImageView checked = (ImageView) v.findViewWithTag("checked");
            checked.setVisibility(View.VISIBLE);

            if (mListener != null) {
                mListener.onThemeChanged(themeName, getIsLightTheme());
            }

        }
    };


    public void removeOldCheck(ViewGroup vg) {

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

    public void loadDrawable(String title, ImageView imageView, int id, int color) {
        if (ImageLoader.cancelPotentialWork(title, imageView)) {

            final ImageLoader task = new ImageLoader(imageView, mContext, id, color);
            final ImageLoader.AsyncDrawable asyncDrawable = new ImageLoader.AsyncDrawable(mContext.getResources(), task);

            imageView.setImageDrawable(asyncDrawable);

            task.execute(title);
        } // if work is not already ongoing
    } // loadBitmap

} // Class
