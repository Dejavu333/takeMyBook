package com.elte.fsz.takemybook.application.webdomain;

public class AllBookworm {

    private final long id;
    private final String nickname;
    private final String loginName;
    private final int score;

    public AllBookworm(long id, String nickname, String loginName,int score) {
        this.id = id;
        this.nickname = nickname;
        this.loginName = loginName;
        this.score = score;
    }

	public long getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

	public String getNickname() {
		return nickname;
	}
	public int getScore() {
		return score;
	}

}
