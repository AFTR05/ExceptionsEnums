package Model;

public class Professor extends Person{
    private String subject;
    private Monitor monitor;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Professor(String name,String subject, Monitor monitor) {
        setName(name);
        this.subject = subject;
        this.monitor = monitor;
    }
}
