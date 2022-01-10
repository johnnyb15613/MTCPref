package com.jb15613.preference.themechooser;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jb15613.preference.utility.ColorUtils;
import com.jb15613.preference.utility.Constants;
import com.jb15613.preference.utility.PrefUtils;
import com.jb15613.preference.utility.Color.AccentColor;

public class ThemeChooserPreference extends Preference implements Preference.OnPreferenceClickListener, ThemeChooserDialog.OnThemeChangedListener {
	
	// final static String mPrefKey = Constants.PREF_NAME_KEY;

    // the theme name
    private String mValue;

    // private SharedPreferences prefs;
    private final Context mContext;

    private  LinearLayout mSwatchContainer;

    public ThemeChooserPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mValue = PrefUtils.getThemeColor(context);
        init();
    }

    public ThemeChooserPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
		mValue = PrefUtils.getThemeColor(context);
        init();
    }

    private void init() {
        setLayoutResource(R.layout.themechooser_preference);
        setOnPreferenceClickListener(this);
        setOnPreferenceChangeListener(pcListener);
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {

        String mThemeDefaultValue = a.getString(index);

        if (mThemeDefaultValue != null) {
            return mThemeDefaultValue;
        } else {
            return Constants.LIGHTBLUE;
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
       super.onBindViewHolder(holder);

       mSwatchContainer = (LinearLayout) holder.findViewById(R.id.swatchView);
        TextView mSummaryText = (TextView) holder.findViewById(R.id.summary);

       if (PrefUtils.getDensityScale(mContext) == 0f) {
           PrefUtils.setDensityScale(mContext, getContext().getResources().getDisplayMetrics().density);
       }

       swapThemeSwatch(PrefUtils.getThemeColor(mContext));
       // setSummary(PrefUtils.getThemeColor(mContext) + getThemeHue());
        String summary = PrefUtils.getThemeColor(mContext) + getThemeHue();
        mSummaryText.setText(summary);

    }

    @Override
    public void onThemeChanged(String theme, boolean hue) {
        mValue = theme;
        // the hue
        Log.e("onThemeChange", "theme : " + mValue);
        Log.e("onThemeChange", "isLight : " + hue);
        try {
            getOnPreferenceChangeListener().onPreferenceChange(this, theme);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
		
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.e("MTCPref", "onSaveInstanceState() called");
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);

        Log.e("MTCPref", "onRestoreInstanceState() called");

        FragmentManager fm = getFragManager();

        if (fm != null) {
            ThemeChooserDialog mDialog = (ThemeChooserDialog) fm.findFragmentByTag("TCD");
            mDialog.setOnThemeChangedListener(this);
        }

        setOnPreferenceClickListener(this);
        setOnPreferenceChangeListener(pcListener);

    }

	private String getThemeHue() {
		
		String h;

		if (PrefUtils.getThemeHue(mContext)) {
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
		    Log.e("onPreferenceChange", "newValue : " + newValue.toString());
            swapThemeSwatch(PrefUtils.getThemeColor(mContext));
            // setSummary(PrefUtils.getThemeColor(mContext) + getThemeHue());
			preference.setSummary(newValue + getThemeHue());
			return true;
		}
	};

    private void showDialog() {

        FragmentManager fm = getFragManager();

        if (fm != null) {
            ThemeChooserDialog mDialog = new ThemeChooserDialog();
            mDialog.setOnThemeChangedListener(this);
            mDialog.show(fm, "TCD");
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

        int[] colors = ColorUtils.getColorSet(themeName, mContext, false);
		
		if (themeName.contains(Constants.THEME_SPLITTER)) {
			String[] tn = themeName.split(Constants.THEME_SPLITTER);
			colors[2] = AccentColor.getColor(tn[1], mContext);
		}

        LinearLayout ll = new LinearLayout(mContext);
        RelativeLayout rl = new RelativeLayout(mContext);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(pToDp(45), pToDp(45));
        rl.setLayoutParams(rlParams);

        ImageView bottomCircle = new ImageView(mContext);
        ImageView middleCircle = new ImageView(mContext);
        ImageView topCircle = new ImageView(mContext);

        RelativeLayout.LayoutParams bottomCircleParams = new RelativeLayout.LayoutParams(pToDp(22), pToDp(22));
        RelativeLayout.LayoutParams middleCircleParams = new RelativeLayout.LayoutParams(pToDp(22), pToDp(22));
        RelativeLayout.LayoutParams topCircleParams = new RelativeLayout.LayoutParams(pToDp(22), pToDp(22));

        bottomCircle.setLayoutParams(bottomCircleParams);
        middleCircle.setLayoutParams(middleCircleParams);
        topCircle.setLayoutParams(topCircleParams);

        bottomCircle.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.themechooser_shape_circle, null));
        middleCircle.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.themechooser_shape_circle, null));
        topCircle.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.themechooser_shape_circle, null));

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
	
	private int pToDp(int p) {
		return (int) (p * PrefUtils.getDensityScale(mContext) + 0.5f);
	}

} // Class
