package com.mwmurawski.ufccounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // BLUE CORNER
    @BindView(R.id.fighter_name_blue)    TextView fighterNameBlue;
    @BindView(R.id.knockdowns_score_blue) TextView knockdownsScoreBlue;
    @BindView(R.id.total_strikes_score_blue) TextView totalStrikeScoreBlue;
    @BindView(R.id.significant_strikes_score_blue) TextView significantStrikesScoreBlue;
    @BindView(R.id.takedowns_score_blue) TextView takedownsScoreBlue;
    @BindView(R.id.submissions_attempts_score_blue) TextView submissionsAttemptsScoreBlue;

    // RED CORNER    
    @BindView(R.id.fighter_name_red)    TextView fighterNameRed;
    @BindView(R.id.knockdowns_score_red) TextView knockdownsScoreRed;
    @BindView(R.id.total_strikes_score_red) TextView totalStrikeScoreRed;
    @BindView(R.id.significant_strikes_score_red) TextView significantStrikesScoreRed;
    @BindView(R.id.takedowns_score_red) TextView takedownsScoreRed;
    @BindView(R.id.submissions_attempts_score_red) TextView submissionsAttemptsScoreRed;

    //SCORES VARIABLES
    Integer strikesRed = 0;
    Integer significantStrikesRed = 0;
    Integer takedownsRed = 0;
    Integer subAttemptsRed = 0;
    Integer knockDownsRed = 0;

    Integer strikesBlue = 0;
    Integer significantStrikesBlue = 0;
    Integer takedownsBlue = 0;
    Integer subAttemptsBlue = 0;
    Integer knockDownsBlue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    ButterKnife.bind(this);

        //HARD CODED DATA
        fighterNameBlue.setText("Michael Bisping");
        fighterNameRed.setText("Luke Rockhold");
        //END

	    if (savedInstanceState != null){
		    strikesBlue = savedInstanceState.getInt(SCORE.STRIKES_BLUE.getScore());
		    significantStrikesBlue = savedInstanceState.getInt(SCORE.SIG_STRIKES_BLUE.getScore());
		    knockDownsBlue = savedInstanceState.getInt(SCORE.KNOCKDOWNS_BLUE.getScore());
		    subAttemptsBlue = savedInstanceState.getInt(SCORE.SUB_ATTEMPTS_BLUE.getScore());
		    takedownsBlue = savedInstanceState.getInt(SCORE.TAKEDOWNS_BLUE.getScore());

		    strikesRed = savedInstanceState.getInt(SCORE.STRIKES_RED.getScore());
		    significantStrikesRed = savedInstanceState.getInt(SCORE.SIG_STRIKES_RED.getScore());
		    knockDownsRed = savedInstanceState.getInt(SCORE.KNOCKDOWNS_RED.getScore());
		    subAttemptsRed = savedInstanceState.getInt(SCORE.SUB_ATTEMPTS_RED.getScore());
		    takedownsRed = savedInstanceState.getInt(SCORE.TAKEDOWNS_RED.getScore());

		    refreshBlueScores();
		    refreshRedScores();
	    }
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {

		outState.putInt(SCORE.STRIKES_BLUE.getScore(), strikesBlue);
		outState.putInt(SCORE.SIG_STRIKES_BLUE.getScore(), significantStrikesBlue);
		outState.putInt(SCORE.KNOCKDOWNS_BLUE.getScore(), knockDownsBlue);
		outState.putInt(SCORE.SUB_ATTEMPTS_BLUE.getScore(), subAttemptsBlue);
		outState.putInt(SCORE.TAKEDOWNS_BLUE.getScore(), takedownsBlue);

		outState.putInt(SCORE.STRIKES_RED.getScore(), strikesRed);
		outState.putInt(SCORE.SIG_STRIKES_RED.getScore(), significantStrikesRed);
		outState.putInt(SCORE.KNOCKDOWNS_RED.getScore(), knockDownsRed);
		outState.putInt(SCORE.SUB_ATTEMPTS_RED.getScore(), subAttemptsRed);
		outState.putInt(SCORE.TAKEDOWNS_RED.getScore(), takedownsRed);

		super.onSaveInstanceState(outState);
	}

	//BLUE CORNER BUTTONS
    public void onClickKnockdownsBlue(View view) {
        knockDownsBlue++;
        significantStrikesBlue++;
        strikesBlue++;
	    refreshBlueScores();
    }

    public void onClickSignificantStrikesBlue(View view) {
        significantStrikesBlue++;
        strikesBlue++;
        refreshBlueScores();
    }

    public void onClickTotalStrikesBlue(View view) {
        strikesBlue++;
        refreshBlueScores();
    }

    public void onClickTakedownsBlue(View view) {
        takedownsBlue++;
        refreshBlueScores();
    }

    public void onClickSubmissionsAttemptsBlue(View view) {
        subAttemptsBlue++;
        refreshBlueScores();
    }

    //RED CORNER BUTTONS
    public void onClickKnockdownsRed(View view) {
        knockDownsRed++;
        significantStrikesRed++;
        strikesRed++;
        refreshRedScores();
    }

    public void onClickSignificantStrikesRed(View view) {
        significantStrikesRed++;
        strikesRed++;
        refreshRedScores();
    }

    public void onClickTotalStrikesRed(View view) {
        strikesRed++;
        refreshRedScores();
    }


    public void onClickTakedownsRed(View view) {
        takedownsRed++;
        refreshRedScores();
    }

    public void onClickSubmissionsAttemptsRed(View view) {
        subAttemptsRed++;
        refreshRedScores();
    }

    public void onClickReset(View view) {
        strikesRed = 0;
        significantStrikesRed = 0;
        takedownsRed = 0;
        subAttemptsRed = 0;

        strikesBlue = 0;
        significantStrikesBlue = 0;
        takedownsBlue = 0;
        subAttemptsBlue = 0;

        knockdownsScoreBlue.setText("0");
        submissionsAttemptsScoreBlue.setText("0");
        takedownsScoreBlue.setText("0");
        totalStrikeScoreBlue.setText("0");
        significantStrikesScoreBlue.setText("0");


        knockdownsScoreRed.setText("0");
        submissionsAttemptsScoreRed.setText("0");
        takedownsScoreRed.setText("0");
        totalStrikeScoreRed.setText("0");
        significantStrikesScoreRed.setText("0");
    }

    private void refreshRedScores(){
        knockdownsScoreRed.setText(String.valueOf(knockDownsRed));
        totalStrikeScoreRed.setText(String.valueOf(strikesRed));
        significantStrikesScoreRed.setText(String.valueOf(significantStrikesRed));
        submissionsAttemptsScoreRed.setText(String.valueOf(subAttemptsRed));
        takedownsScoreRed.setText(String.valueOf(takedownsRed));
    }


    private void refreshBlueScores(){
        knockdownsScoreBlue.setText(String.valueOf(knockDownsBlue));
        totalStrikeScoreBlue.setText(String.valueOf(strikesBlue));
        significantStrikesScoreBlue.setText(String.valueOf(significantStrikesBlue));
        submissionsAttemptsScoreBlue.setText(String.valueOf(subAttemptsBlue));
        takedownsScoreBlue.setText(String.valueOf(takedownsBlue));
    }
}
