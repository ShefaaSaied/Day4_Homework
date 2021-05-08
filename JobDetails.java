public class JobDetails {
    String title,company,location,type,level,exp,country,skills;

    public JobDetails (String title, String company, String location,String type,
                       String level,String exp,String country,String skills){
        this.title=title;
        this.company=company;
        this.location=location;
        this.type=type;
        this.level=level;
        this.exp=exp;
        this.country=country;
        this.skills=skills;
    }

    @Override
    public String toString() {
        return "Job{" + "Title=" + title + ", Company=" + company + ", Location=" + location + ", Type=" + type +
                ", Level=" + level + ", Exp=" + exp+ ", Country=" + country+ ", Skills=" + skills + '}';
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title=title; }

    public String getCompany (){ return company; }
    public void setCompany (String company){ this.company=company; }

    public String getLocation (){ return location; }
    public void setLocation (String location){ this.location=location;}

    public String getType (){ return type; }
    public void setType (String type){ this.type=type;}

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level=level; }

    public String getExp (){ return exp; }
    public void setExp (String exp){ this.exp =exp; }

    public String getCountry (){ return country; }
    public void setCountry (String country){ this.country=country;}

    public String getSkills (){ return skills; }
    public void setSkills (String skills){ this.skills=skills;}
}