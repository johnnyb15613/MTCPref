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
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.os.Bundle;
import android.os.Parcelable;

public class ThemeChooserPreference extends Preference implements Preference.OnPreferenceClickListener, ThemeChooserDialog.OnThemeChangedListener {
	
	final static String mPrefKey = "mtc_pref_preferences";

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
        prefs = context.getSharedPreferences(mPrefKey, Context.MODE_PRIVATE);
        init(context, null);
    }

    public ThemeChooserPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        prefs = context.getSharedPreferences(mPrefKey, Context.MODE_PRIVATE);
        init(context, attrs);
    }

    public ThemeChooserPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        prefs = context.getSharedPreferences(mPrefKey, Context.MODE_PRIVATE);
        init(context, attrs);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View v = li.inflate( R.layout.themechooser_preference, parent, false);
        mSwatchContainer = (LinearLayout) v.findViewById(R.id.swatchView);
        swapThemeSwatch(prefs.getString("themeColor", "Light Blue"));
		setSummary(prefs.getString("themeColor", "Light Blue") + getThemeHue());
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

    private void init(Context con, AttributeSet attr) {
        setOnPreferenceClickListener(this);
		setOnPreferenceChangeListener(pcListener);
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

	private String getThemeHue() {
		
		String h = "";

		if (prefs.getBoolean("isLightTheme", false)) {
			h = " - Light";
		} else {
			h = " - Dark";
		}
		
		return h;
	}

    public boolean onPreferenceClick(Preference preference) {
        showDialog();
        return false;
    }
	
	public OnPreferenceChangeListener pcListener = new OnPreferenceChangeListener() {

		@Override
		public boolean onPreferenceChange(Preference preference, Object newValue) {
			preference.setSummary(String.valueOf(newValue) + getThemeHue());
			return true;
		}
	};

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

        int[] colors = ColorUtils.getColorSet(themeName, mContext);

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

} // Class
