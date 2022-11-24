package be.abis.exercise.model;

import java.io.Serializable;

public class EnrolmentId implements Serializable {

    private Session session;
    private int enrolmentInSession;

    public int getEnrolmentInSession() {
        return enrolmentInSession;
    }

    public void setEnrolmentInSession(int enrolmentInSession) {
        this.enrolmentInSession = enrolmentInSession;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
