package alainp.me.alainresume.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alain on 6/10/2015.
 */
public class Project {
    private String title;
    private String language;
    private String technologies;
    private String responsibilities;
    private String owner;

    public Project(String title, String language, String technologies, String responsibilities, String owner) {
        this.title = title;
        this.language = language;
        this.technologies = technologies;
        this.responsibilities = responsibilities;
        this.owner= owner;
    }


    public ArrayList<String> getProjectArray() {
        ArrayList projectList = new ArrayList();
        projectList.add(title);
        projectList.add(language);
        projectList.add(technologies);
        projectList.add(responsibilities);
        projectList.add(owner);
        return projectList;
    }
    public String getLanguage() {
        return language;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getTechnologies() {
        return technologies;
    }

    public String getResponsibilities() {
        return responsibilities;
    }




}

