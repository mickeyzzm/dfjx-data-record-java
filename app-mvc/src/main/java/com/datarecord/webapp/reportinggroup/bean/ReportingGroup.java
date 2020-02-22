package com.datarecord.webapp.reportinggroup.bean;

public class ReportingGroup {

   private int  job_unit_id;
   private String  job_unit_name;
   private int  job_unit_active;
   private int job_unit_type;
   private int job_id;

    public int getJob_unit_id() {
        return job_unit_id;
    }

    public void setJob_unit_id(int job_unit_id) {
        this.job_unit_id = job_unit_id;
    }

    public String getJob_unit_name() {
        return job_unit_name;
    }

    public void setJob_unit_name(String job_unit_name) {
        this.job_unit_name = job_unit_name;
    }

    public int getJob_unit_active() {
        return job_unit_active;
    }

    public void setJob_unit_active(int job_unit_active) {
        this.job_unit_active = job_unit_active;
    }

    public int getJob_unit_type() {
        return job_unit_type;
    }

    public void setJob_unit_type(int job_unit_type) {
        this.job_unit_type = job_unit_type;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    @Override
    public String toString() {
        return "ReportingGroup{" +
                "job_unit_id=" + job_unit_id +
                ", job_unit_name='" + job_unit_name + '\'' +
                ", job_unit_active=" + job_unit_active +
                ", job_unit_type=" + job_unit_type +
                ", job_id=" + job_id +
                '}';
    }
}
