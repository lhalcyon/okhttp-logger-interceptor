package com.example.interceptor;

/**
 * ©2016-2017 kmhealthcloud.All Rights Reserved <p/>
 * Created by: L  <br/>
 * Description:
 */
public class UserInfoResponse {


    /**
     * login : lhalcyon
     * id : 21357951
     * avatar_url : https://avatars.githubusercontent.com/u/21357951?v=3
     * gravatar_id :
     * url : https://api.github.com/users/lhalcyon
     * html_url : https://github.com/lhalcyon
     * followers_url : https://api.github.com/users/lhalcyon/followers
     * following_url : https://api.github.com/users/lhalcyon/following{/other_user}
     * gists_url : https://api.github.com/users/lhalcyon/gists{/gist_id}
     * starred_url : https://api.github.com/users/lhalcyon/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/lhalcyon/subscriptions
     * organizations_url : https://api.github.com/users/lhalcyon/orgs
     * repos_url : https://api.github.com/users/lhalcyon/repos
     * events_url : https://api.github.com/users/lhalcyon/events{/privacy}
     * received_events_url : https://api.github.com/users/lhalcyon/received_events
     * type : User
     * site_admin : false
     * name : Ceyx
     * company : null
     * blog : null
     * location : null
     * email : lh_halcyondays@163.com
     * hireable : null
     * bio : null
     * public_repos : 7
     * public_gists : 0
     * followers : 0
     * following : 0
     * created_at : 2016-08-31T08:50:58Z
     * updated_at : 2016-12-05T06:26:44Z
     */

    public String login;
    public int id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
    public String name;
    public Object company;
    public Object blog;
    public Object location;
    public String email;
    public Object hireable;
    public Object bio;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public String created_at;
    public String updated_at;

    @Override
    public String toString() {
        return "UserInfoResponse{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", blog=" + blog +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", hireable=" + hireable +
                ", bio=" + bio +
                ", public_repos=" + public_repos +
                ", public_gists=" + public_gists +
                ", followers=" + followers +
                ", following=" + following +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
