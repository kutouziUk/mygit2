package cn.ws.domain;


import java.util.Date;

public class Log {
    private int id;
    private Date avisit_time;
    private String ip;
    private String url;

    public Log() {
    }

    public Log(int id, Date avisit_time, String ip, String url) {
        this.id = id;
        this.avisit_time = avisit_time;
        this.ip = ip;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAvisit_time() {
        return avisit_time;
    }

    public void setAvisit_time(Date avisit_time) {
        this.avisit_time = avisit_time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", avisit_time='" + avisit_time + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
