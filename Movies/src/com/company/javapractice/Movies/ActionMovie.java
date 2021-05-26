package com.company.javapractice.Movies;

public class ActionMovie extends Movies {
    private String actorAction;
    private int bodyCount;

    public ActionMovie(String title, String producerName, int releaseYear, String actorAction, int bodyCount) {
        super(title, producerName, releaseYear);
        this.actorAction = actorAction;
        this.bodyCount = bodyCount;
    }

    @Override
    public String toString() { return "The main actor in the action movie is " + actorAction + ", and " + bodyCount + " people dies in the story. " + super.toString(); }
}
