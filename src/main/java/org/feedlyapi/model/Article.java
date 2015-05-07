package org.feedlyapi.model;

import java.util.Calendar;

@SuppressWarnings("unused")
public class Article {

    private String id;
    private String title;
    private Content content;
    private Content summary;
    private boolean unread;
    private String originId;
    private Calendar published;

    public Calendar getPublished() {
        return published;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content.getContent();

    }

    public String getSummary() {
        return summary.getContent();
    }

    public boolean isUnread() {
        return unread;
    }

    public String getOriginId() {
        return originId;
    }

    class Content {

        private String content;

        public String getContent() {
            return content;
        }
    }
}