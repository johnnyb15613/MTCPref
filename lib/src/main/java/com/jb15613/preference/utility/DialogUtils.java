package com.jb15613.preference.utility;

import androidx.cardview.widget.CardView;

import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.view.View;
import android.view.Gravity;
import android.widget.TextView;
import com.jb15613.preference.themechooser.R;
import com.jb15613.preference.utility.Color.AccentColor;

import android.view.LayoutInflater;

public class DialogUtils {
	
	/**
	 * Scrolls the Vertical Theme Table to desired position
	 *
	 * @param  themeName a {@code String} that represents which item to scroll to
	 * @param  portraitParent a {@code ScrollView} that will get its scroll position set
	 * @param  portraitContainer a {@code TableLayout} that hold all the items inside scroll view
	 */
	public static void scrollVerticalThemePanelTo(String themeName, ScrollView portraitParent, TableLayout portraitContainer) {

		int desiredItem = 0;

		for (int i = 0; i < portraitContainer.getChildCount(); i++) {

			TableRow tr = (TableRow) portraitContainer.getChildAt(i);

			if (tr.getChildCount() > 1) {
				
				CardView cv1 = (CardView) tr.getChildAt(0);
				CardView cv2 = (CardView) tr.getChildAt(1);
				CardView cv3 = (CardView) tr.getChildAt(2);

				if (cv1.getTag().toString().equals(themeName) || cv2.getTag().toString().equals(themeName) || cv3.getTag().toString().equals(themeName)) {
					desiredItem = tr.getTop();
				}
			} else {
				CardView cv1 = (CardView) tr.getChildAt(0);

				if (cv1.getTag().toString().equals(themeName)) {
					desiredItem = tr.getTop();
				}
			}

		} // for every table row

		portraitParent.setScrollY(desiredItem);
		
	} // scrollVerticalThemePanelTo
	
	/**
	 * Scrolls the Horizontal Theme Table or AccentTable to desired position
	 *
	 * @param  themeName a {@code String} that represents which item to scroll to
	 * @param  landscapeParent a {@code HorizontalScrollView} that will get its scroll position set
	 * @param  landscapeContainer a {@code LinearLayout} that hold all the items inside scroll view
	 */
	public static void scrollHorizontalThemePanelTo(String themeName, HorizontalScrollView landscapeParent, LinearLayout landscapeContainer) {

		int desiredItem = 0;

		for (int i = 0; i < landscapeContainer.getChildCount(); i++) {

			CardView cv = (CardView) landscapeContainer.getChildAt(i);

			if (cv.getTag().toString().equals(themeName)) {
				desiredItem = cv.getLeft();
			}

		} // for every theme item

		landscapeParent.setScrollX(desiredItem);

	} // scrollHorizontalThemePanelTo
	
	/**
	 * Sets a Checkmark on appropriate Theme Item
	 *
	 * @param  context a {@code Context} that is needed to access preferences
	 * @param  isPortrait a {@code Boolean} that is true if Portrait, false if Landscape
	 * @param  portraitContainer a {@code TableLayout} that holds all the tablerows
	 * @param  landscapeContainer a {@code LinearLayout} that holds all the theme items
	 */
	public static void recheckThemeColor(Context context, Boolean isPortrait, TableLayout portraitContainer, LinearLayout landscapeContainer) {
		
		String themeName = PrefUtils.getThemeColor(context);
		
		int[] colors = ColorUtils.getColorSet(themeName, context, true);
		
		if (themeName.contains(Constants.THEME_SPLITTER)) {
			String[] items = themeName.split(Constants.THEME_SPLITTER);
			themeName = items[0];
		}
		
		if (isPortrait) {
			// portrait
			for (int pc = 0; pc < portraitContainer.getChildCount(); pc++) {
				
				TableRow tr = (TableRow) portraitContainer.getChildAt(pc);

				for (int trc = 0; trc < tr.getChildCount(); trc++) {

					CardView cv = (CardView) tr.getChildAt(trc);
					LinearLayout ll = (LinearLayout) cv.getChildAt(0);
					RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

					ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

					if (checked.getVisibility() == View.VISIBLE) {
						checked.setVisibility(View.INVISIBLE);
					} // if view is visible
					
					if (themeName.equals(cv.getTag().toString())) {
						checked.setVisibility(View.VISIBLE);
						cv.setCardBackgroundColor(colors[2]);
					} else {
						cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
					} // if this is selected theme

				} // for each item in tablerow
				
			} // for each tablerow
			
		} else {
			// Landscape
			for (int lc = 0; lc < landscapeContainer.getChildCount(); lc++) {
				
				CardView cv = (CardView) landscapeContainer.getChildAt(lc);
				LinearLayout ll = (LinearLayout) cv.getChildAt(0);
				RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

				ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

				if (checked.getVisibility() == View.VISIBLE) {
					checked.setVisibility(View.INVISIBLE);
				} // if view is visible
				
				if (themeName.equals(cv.getTag().toString())) {
					checked.setVisibility(View.VISIBLE);
					cv.setCardBackgroundColor(colors[2]);
				} else {
					cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
				}// if this is selected theme
				
			} // for each item in linearlayout
			
		} // if orientation is Portrait or Landscape

    } // recheckThemeColor
	
	/**
	 * Sets a Checkmark on appropriate Accent Item
	 *
	 * @param  context a {@code Context} that is needed to access preferences
	 * @param  accentContainer a {@code LinearLayout} that holds all the accent items
	 */
	public static void recheckAccentColor(Context context, LinearLayout accentContainer) {

		String themeName = PrefUtils.getThemeColor(context);
		String accentName = PrefUtils.getAccentColor(context);
		
		int[] colors = ColorUtils.getColorSet(themeName, context, true);

		for (int i = 0; i < accentContainer.getChildCount(); i++) {

			CardView cv = (CardView) accentContainer.getChildAt(i);
			LinearLayout ll = (LinearLayout) cv.getChildAt(0);
			RelativeLayout rl = (RelativeLayout) ll.getChildAt(0);

			ImageView checked = (ImageView) rl.findViewWithTag(Constants.VIEW_CHECKED);

			if (checked.getVisibility() == View.VISIBLE) {
				checked.setVisibility(View.INVISIBLE);
			} // if view is visible

			if (cv.getTag().toString().equals(accentName)) {
				checked.setVisibility(View.VISIBLE);
				cv.setCardBackgroundColor(colors[0]);
			} else {
				cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
			}

		}

	} // recheckAccentColor
	
	/**
	 * Creates a {@code CardView} containing a Swatch Item
	 *
	 * @param  themeName a {@code String} 
	 * @return a {@code CardView};
	 */
    public static CardView getSwatchItem(Context context, String themeName, boolean isPortrait) {

        int[] colors = ColorUtils.getColorSet(themeName, context, false);

		CardView cv; 
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		cv = (CardView) inflater.inflate(R.layout.card_view, null);
		
        LinearLayout ll = new LinearLayout(context);
        RelativeLayout rl = new RelativeLayout(context);

		if (isPortrait) {
			TableRow.LayoutParams cvParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT);
			cvParams.setMargins(4, 2, 4, 2);
			cvParams.weight = 1.0f;
			cv.setLayoutParams(cvParams);
			cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
			cv.setCardElevation(5f);
		} else {
			LinearLayout.LayoutParams cvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			cvParams.setMargins(4, 2, 4, 2);
			cv.setLayoutParams(cvParams);
			cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
			cv.setCardElevation(5f);
		}

        CardView.LayoutParams llParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
		ll.setPadding(3, 3, 3, 3);

		int cellSize = PrefUtils.getCellSize(context);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(cellSize, cellSize);
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(context);

        ImageView bottomCircle = new ImageView(context);
        ImageView middleCircle = new ImageView(context);
        ImageView topCircle = new ImageView(context);
        ImageView checked = new ImageView(context);

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

        loadDrawable(context, "bottomCircle" + themeName, bottomCircle, R.drawable.themechooser_shape_circle, colors[2]);
        loadDrawable(context, "middleCircle" + themeName, middleCircle, R.drawable.themechooser_shape_circle, colors[0]);
        loadDrawable(context, "topCircle" + themeName, topCircle, R.drawable.themechooser_shape_circle, colors[1]);

		if (PrefUtils.getThemeHue(context)) {
			loadDrawable(context, Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xff000000);
		} else {
			loadDrawable(context, Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xffffffff);
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

		String tn = PrefUtils.getThemeColor(context);

		if (tn.contains(Constants.THEME_SPLITTER)) {
			String[] t = tn.split(Constants.THEME_SPLITTER);
			if (t[0].equals(themeName)) {
				checked.setVisibility(View.VISIBLE);
				cv.setCardBackgroundColor(colors[2]);
			} else {
				checked.setVisibility(View.INVISIBLE);
			}
		} else {
			if (tn.equals(themeName)) {
				checked.setVisibility(View.VISIBLE);
				cv.setCardBackgroundColor(colors[2]);
			} else {
				checked.setVisibility(View.INVISIBLE);
			}
		}

        checked.setTag(Constants.VIEW_CHECKED);

		cv.setTag(themeName);
		cv.addView(ll);
		
        return cv;
    } // getSwatchItem
	
	/**
	 * Creates a {@code CardView} containing an Accent Item
	 *
	 * @param  themeName a {@code String} 
	 * @return a {@code CardView};
	 */
	public static CardView getAccentItem(Context context, String themeName) {

		// comes from accent_names_array
		// no splitting needed
		String thna = PrefUtils.getThemeColor(context);

		int[] colors = ColorUtils.getColorSet(thna, context, true);
		
        int color = AccentColor.getColor(themeName, context);
		
		CardView cv; 
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		cv = (CardView) inflater.inflate(R.layout.card_view, null);

        LinearLayout ll = new LinearLayout(context);
        RelativeLayout rl = new RelativeLayout(context);

		LinearLayout.LayoutParams cvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		cvParams.setMargins(4, 2, 4, 2);
		cvParams.weight = 1.0f;
		cv.setLayoutParams(cvParams);
		cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
		cv.setCardElevation(5f);
		
        CardView.LayoutParams llParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(llParams);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
		ll.setPadding(3, 3, 3, 3);

		int cellSize = PrefUtils.getCellSize(context);

        RelativeLayout.LayoutParams rlParams = new RelativeLayout.LayoutParams(cellSize, cellSize);
        rl.setLayoutParams(rlParams);
        rl.setPadding(3, 3, 3, 3);

        TextView tv = new TextView(context);

        ImageView circle = new ImageView(context);
        ImageView checked = new ImageView(context);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams circleParams = new RelativeLayout.LayoutParams((cellSize / 2) + 30, (cellSize / 2) + 30);
        RelativeLayout.LayoutParams checkedParams = new RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2);

        tv.setLayoutParams(tvParams);
        tv.setGravity(Gravity.CENTER);

        circle.setLayoutParams(circleParams);
        checked.setLayoutParams(checkedParams);

        loadDrawable(context, "circle" + themeName, circle, R.drawable.themechooser_shape_circle, color);

		if (PrefUtils.getThemeHue(context)) {
			loadDrawable(context, Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xff000000);
		} else {
			loadDrawable(context, Constants.VIEW_CHECKED + themeName, checked, R.drawable.checkmark, 0xffffffff);
		}

        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT);

        tv.setText(themeName);
        tv.setTextColor(color);

        rl.addView(circle);
		rl.addView(checked);

        ll.addView(rl);
        ll.addView(tv);

        String tn = PrefUtils.getThemeColor(context);

		String tName;
		String aName;

		if (tn.contains(Constants.THEME_SPLITTER)) {

			String[] items = tn.split(Constants.THEME_SPLITTER);
			tName = items[0];
			aName = items[1];

		} else {

			tName = tn;

			String anl;

			if (tn.equals(Constants.BROWN) || tn.equals(Constants.GREY) || tn.equals(Constants.BLUEGREY)) {
				anl = " 3";
			} else {
				anl = " A1";
			}

			aName = tName + anl;

		}

		if (themeName.equals(aName)) {
			checked.setVisibility(View.VISIBLE);
			cv.setCardBackgroundColor(colors[0]);
		} else {
			checked.setVisibility(View.INVISIBLE);
			cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(context));
		}

        checked.setTag(Constants.VIEW_CHECKED);

		cv.setTag(themeName);
		cv.addView(ll);

        return cv;
    } // getAccentItem
	
	/**
	 * Loads drawables asynchronously
	 *
	 * @param  title a {@code String} that is used to identify a drawable
	 * @param  imageView an {@code ImageView} that the drawable will be bound to
	 * @param  id an {@code int} that is the ResourceId of the Drawable
	 * @param  color an {@code int} that represents the color we want to make the drawable
	 */
    public static void loadDrawable(Context context, String title, ImageView imageView, int id, int color) {
        if (ImageLoader.cancelPotentialWork(title, imageView)) {

            final ImageLoader task = new ImageLoader(imageView, context, id, color);
            final ImageLoader.AsyncDrawable asyncDrawable = new ImageLoader.AsyncDrawable(context.getResources(), task);

            imageView.setImageDrawable(asyncDrawable);

            task.execute(title);
        } // if work is not already ongoing

    } // loadDrawable
	
} // Class
