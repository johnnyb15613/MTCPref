package com.jb15613.preference.themechooser;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ThemeChooserPreference extends Preference implements Preference.OnPreferenceClickListener, ThemeChooserDialog.OnThemeChangedListener {

    // the theme name
    private String mValue;
    // the hue
    private Boolean mBool;


    //private ThemeChooserDialog mDialog;
    private SharedPreferences prefs;
    private Context mContext;

    private  LinearLayout mSwatchContainer;

    public ThemeChooserPreference(Context context) {
        super(context);
        mContext = context;
        prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        init();
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View v = li.inflate( R.layout.themechooser_preference, parent, false);
        mSwatchContainer = (LinearLayout) v.findViewById(R.id.swatchView);
        swapThemeSwatch(prefs.getString("themeColor", "Light Blue"));
        return v;
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {

        String mThemeDefaultValue = a.getString(index);

        if (mThemeDefaultValue != null) {
            return mThemeDefaultValue;
        } else {
            return "Light Blue";
        }
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        onThemeChanged(restoreValue ? getPersistedString(mValue) : (String) defaultValue, mBool);
    }

    private void init() {
        setOnPreferenceClickListener(this);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
    }

    @Override
    public void onThemeChanged(String theme, boolean hue) {
        mValue = theme;
        mBool = hue;
        try {
            getOnPreferenceChangeListener().onPreferenceChange(this, theme);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public boolean onPreferenceClick(Preference preference) {
        showDialog();
        return false;
    }

    private void showDialog() {

        FragmentManager fm = getFragManager();

        if (fm != null) {
            ThemeChooserDialog mDialog = new ThemeChooserDialog();
            mDialog.setOnThemeChangedListener(this);
            mDialog.show(fm, "");
        }

    }

    private FragmentManager getFragManager() {

        try {
            final Activity a = (Activity) mContext;
            return a.getFragmentManager();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }

    }

    private void swapThemeSwatch(String theme) {

        if (mSwatchContainer.getChildCount() > 0) {
            mSwatchContainer.removeAllViews();
        }
        mSwatchContainer.addView(getCellItem(theme));
    }

    private LinearLayout getCellItem(String themeName) {

        int[] colors = getColorSet(themeName);

        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(130, 130);
        rl.setLayoutParams(rlParams);

        ImageView bottomCircle = new ImageView(mContext);
        ImageView middleCircle = new ImageView(mContext);
        ImageView topCircle = new ImageView(mContext);

        RelativeLayout.LayoutParams bottomCircleParams = new RelativeLayout.LayoutParams(60, 60);
        RelativeLayout.LayoutParams middleCircleParams = new RelativeLayout.LayoutParams(60, 60);
        RelativeLayout.LayoutParams topCircleParams = new RelativeLayout.LayoutParams(60, 60);

        bottomCircle.setLayoutParams(bottomCircleParams);
        middleCircle.setLayoutParams(middleCircleParams);
        topCircle.setLayoutParams(topCircleParams);

        // return ResourcesCompat.getDrawable(mContext.getResources(), mId, null);

        if (Build.VERSION.SDK_INT >= 21) {
            bottomCircle.setImageDrawable(mContext.getResources().getDrawable(R.drawable.themechooser_shape_circle, null));
            middleCircle.setImageDrawable(mContext.getResources().getDrawable(R.drawable.themechooser_shape_circle, null));
            topCircle.setImageDrawable(mContext.getResources().getDrawable(R.drawable.themechooser_shape_circle, null));
        } else {
            bottomCircle.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.themechooser_shape_circle, null));
            middleCircle.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.themechooser_shape_circle, null));
            topCircle.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.themechooser_shape_circle, null));
        }

        bottomCircle.setColorFilter(colors[2], PorterDuff.Mode.MULTIPLY);
        middleCircle.setColorFilter(colors[0], PorterDuff.Mode.MULTIPLY);
        topCircle.setColorFilter(colors[1], PorterDuff.Mode.MULTIPLY);

        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        middleCircleParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        rl.addView(bottomCircle);
        rl.addView(middleCircle);
        rl.addView(topCircle);

        ll.addView(rl);

        return ll;
    } // getCellItem

    private int[] getColorSet(String themeName) {

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
    } // getColorSet

} // Class
