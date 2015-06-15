package alainp.me.alainresume.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alain on 6/10/2015.
 */
public class Project {
    private String title;
    private String description;
    private String language;
    private String technologies;
    private String responsibilities;
    private String owner;
    private String link;

    public Project(String title, String description, String language, String technologies,
                   String responsibilities, String owner, String link) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.technologies = technologies;
        this.responsibilities = responsibilities;
        this.owner= owner;
        this.link = link;
    }


    public ArrayList<String> getProjectArray() {
        ArrayList projectList = new ArrayList();
        projectList.add(title);
        projectList.add(description);
        projectList.add(language);
        projectList.add(technologies);
        projectList.add(responsibilities);
        projectList.add(owner);
        projectList.add(link);
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

