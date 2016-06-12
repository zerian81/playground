package net.dagar.hellodropwizard.net.dagar.hellodropwizard.api;

import org.hibernate.validator.constraints.Length;

/**
 * Created by dan on 6/10/16.
 */
public class Saying {

    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {}

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
