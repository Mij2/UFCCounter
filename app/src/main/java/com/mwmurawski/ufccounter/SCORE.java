package com.mwmurawski.ufccounter;

/**
 * Created by Mij on 2017-02-27.
 */

public enum SCORE {
	STRIKES_BLUE("strikes_blue"),
	SIG_STRIKES_BLUE("sig_strikes_blue"),
	KNOCKDOWNS_BLUE("knockdowns_blue"),
	SUB_ATTEMPTS_BLUE("sub_attempts_blue"),
	TAKEDOWNS_BLUE("takedowns_blue"),
	STRIKES_RED("strikes_red"),
	SIG_STRIKES_RED("sig_strikes_red"),
	KNOCKDOWNS_RED("knockdowns_red"),
	SUB_ATTEMPTS_RED("sub_attempts_red"),
	TAKEDOWNS_RED("takedowns_red");

	private final String score;

	SCORE(String score) {
		this.score = score;
	}

	public String getScore() {
		return score;
	}
}
