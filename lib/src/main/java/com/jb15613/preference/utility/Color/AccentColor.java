package com.jb15613.preference.utility.Color;

import com.jb15613.preference.utility.Constants;
import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import com.jb15613.preference.themechooser.R;

public class AccentColor {
	
	public static int getColor(String themeName, Context context) {

		int color = 0;

		switch (themeName) {

			case Constants.RED:
				color = ResourcesCompat.getColor(context.getResources(), R.color.red500, null);
				break;
			case Constants.RED_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.redA100, null);
				break;
			case Constants.RED_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.redA200, null);
				break;
			case Constants.RED_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.redA400, null);
				break;
			case Constants.RED_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.redA700, null);
				break;

			case Constants.PINK:
				color = ResourcesCompat.getColor(context.getResources(), R.color.pink500, null);
				break;
			case Constants.PINK_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.pinkA100, null);
				break;
			case Constants.PINK_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.pinkA200, null);
				break;
			case Constants.PINK_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.pinkA400, null);
				break;
			case Constants.PINK_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.pinkA700, null);
				break;

			case Constants.PURPLE:
				color = ResourcesCompat.getColor(context.getResources(), R.color.purple500, null);
				break;
			case Constants.PURPLE_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.purpleA100, null);
				break;
			case Constants.PURPLE_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.purpleA200, null);
				break;
			case Constants.PURPLE_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.purpleA400, null);
				break;
			case Constants.PURPLE_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.purpleA700, null);
				break;

			case Constants.DEEPPURPLE:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeppurple500, null);
				break;
			case Constants.DEEPPURPLE_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeppurpleA100, null);
				break;
			case Constants.DEEPPURPLE_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeppurpleA200, null);
				break;
			case Constants.DEEPPURPLE_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeppurpleA400, null);
				break;
			case Constants.DEEPPURPLE_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeppurpleA700, null);
				break;

			case Constants.INDIGO:
				color = ResourcesCompat.getColor(context.getResources(), R.color.indigo500, null);
				break;
			case Constants.INDIGO_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.indigoA100, null);
				break;
			case Constants.INDIGO_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.indigoA200, null);
				break;
			case Constants.INDIGO_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.indigoA400, null);
				break;
			case Constants.INDIGO_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.indigoA700, null);
				break;

			case Constants.BLUE:
				color = ResourcesCompat.getColor(context.getResources(), R.color.blue500, null);
				break;
			case Constants.BLUE_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.blueA100, null);
				break;
			case Constants.BLUE_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.blueA200, null);
				break;
			case Constants.BLUE_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.blueA400, null);
				break;
			case Constants.BLUE_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.blueA700, null);
				break;

			case Constants.LIGHTBLUE:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightblue500, null);
				break;
			case Constants.LIGHTBLUE_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightblueA100, null);
				break;
			case Constants.LIGHTBLUE_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightblueA200, null);
				break;
			case Constants.LIGHTBLUE_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightblueA400, null);
				break;
			case Constants.LIGHTBLUE_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightblueA700, null);
				break;

			case Constants.CYAN:
				color = ResourcesCompat.getColor(context.getResources(), R.color.cyan500, null);
				break;
			case Constants.CYAN_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.cyanA100, null);
				break;
			case Constants.CYAN_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.cyanA200, null);
				break;
			case Constants.CYAN_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.cyanA400, null);
				break;
			case Constants.CYAN_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.cyanA700, null);
				break;

			case Constants.TEAL:
				color = ResourcesCompat.getColor(context.getResources(), R.color.teal500, null);
				break;
			case Constants.TEAL_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.tealA100, null);
				break;
			case Constants.TEAL_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.tealA200, null);
				break;
			case Constants.TEAL_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.tealA400, null);
				break;
			case Constants.TEAL_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.tealA700, null);
				break;

			case Constants.GREEN:
				color = ResourcesCompat.getColor(context.getResources(), R.color.green500, null);
				break;
			case Constants.GREEN_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.greenA100, null);
				break;
			case Constants.GREEN_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.greenA200, null);
				break;
			case Constants.GREEN_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.greenA400, null);
				break;
			case Constants.GREEN_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.greenA700, null);
				break;

			case Constants.LIGHTGREEN:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightgreen500, null);
				break;
			case Constants.LIGHTGREEN_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightgreenA100, null);
				break;
			case Constants.LIGHTGREEN_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightgreenA200, null);
				break;
			case Constants.LIGHTGREEN_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightgreenA400, null);
				break;
			case Constants.LIGHTGREEN_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lightgreenA700, null);
				break;

			case Constants.LIME:
				color = ResourcesCompat.getColor(context.getResources(), R.color.lime500, null);
				break;
			case Constants.LIME_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.limeA100, null);
				break;
			case Constants.LIME_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.limeA200, null);
				break;
			case Constants.LIME_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.limeA400, null);
				break;
			case Constants.LIME_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.limeA700, null);
				break;

			case Constants.YELLOW:
				color = ResourcesCompat.getColor(context.getResources(), R.color.yellow500, null);
				break;
			case Constants.YELLOW_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.yellowA100, null);
				break;
			case Constants.YELLOW_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.yellowA200, null);
				break;
			case Constants.YELLOW_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.yellowA400, null);
				break;
			case Constants.YELLOW_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.yellowA700, null);
				break;

			case Constants.AMBER:
				color = ResourcesCompat.getColor(context.getResources(), R.color.amber500, null);
				break;
			case Constants.AMBER_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.amberA100, null);
				break;
			case Constants.AMBER_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.amberA200, null);
				break;
			case Constants.AMBER_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.amberA400, null);
				break;
			case Constants.AMBER_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.amberA700, null);
				break;

			case Constants.ORANGE:
				color = ResourcesCompat.getColor(context.getResources(), R.color.orange500, null);
				break;
			case Constants.ORANGE_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.orangeA100, null);
				break;
			case Constants.ORANGE_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.orangeA200, null);
				break;
			case Constants.ORANGE_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.orangeA400, null);
				break;
			case Constants.ORANGE_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.orangeA700, null);
				break;

			case Constants.DEEPORANGE:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeporange500, null);
				break;
			case Constants.DEEPORANGE_A1:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeporangeA100, null);
				break;
			case Constants.DEEPORANGE_A2:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeporangeA200, null);
				break;
			case Constants.DEEPORANGE_A4:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeporangeA400, null);
				break;
			case Constants.DEEPORANGE_A7:
				color = ResourcesCompat.getColor(context.getResources(), R.color.deeporangeA700, null);
				break;

			case Constants.BROWN:
				color = ResourcesCompat.getColor(context.getResources(), R.color.brown500, null);
				break;
			case Constants.BROWN_3:
				color = ResourcesCompat.getColor(context.getResources(), R.color.brown300, null);
				break;

			case Constants.GREY:
				color = ResourcesCompat.getColor(context.getResources(), R.color.grey500, null);
				break;
			case Constants.GREY_3:
				color = ResourcesCompat.getColor(context.getResources(), R.color.grey300, null);
				break;

			case Constants.BLUEGREY:
				color = ResourcesCompat.getColor(context.getResources(), R.color.bluegrey500, null);
				break;
			case Constants.BLUEGREY_3:
				color = ResourcesCompat.getColor(context.getResources(), R.color.bluegrey300, null);
				break;

		} // switch

		return color;

	}
	
}
