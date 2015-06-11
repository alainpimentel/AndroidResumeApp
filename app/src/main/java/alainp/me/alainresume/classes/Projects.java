package alainp.me.alainresume.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alain on 6/10/2015.
 */
public class Projects {
    private ArrayList<Project> projects;

    public Projects() {
        // Generate projects
        projects = new ArrayList<Project>();
        projects.add(new Project("Missionary Hub",
                "PHP",
                "Linux, Apache, MySQL, PHP, jQuery",
                "Using a LAMP stack, developed a " +
                "chat feature, the admin site, and the integration of a video player for server " +
                "content. Also used JavaScript and jQuery for frontend features.",
                "CIRC Internship"));
        projects.add(new Project("Android recorder app",
                "Android",
                "Android",
                "Used third party libraries to implement background resumable uploads from " +
                        "Android devices. Developed a video player imitation with images and" +
                        "sound. Used FFMPEG to encode uploaded files into videos in the server.",
                "CIRC Internship"));
        projects.add(new Project("Meta",
                "Python",
                "Python, Flask, SQL",
                "A web hub to store projects and allow communication between team members" +
                        "using Flask.",
                "School Project"));
    }

    public List<Project> getProjects() {
        return projects;
    }
}
