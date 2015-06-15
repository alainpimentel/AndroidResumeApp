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
        projects = new ArrayList<>();
        projects.add(new Project("Missionary Hub",
                "A hub for missionaries overseas where they can chat and share videos with their mentors",
                "PHP",
                "Linux, Apache, MySQL, PHP, jQuery",
                "Developed a chat feature, the admin site, and the integration of a video player for server content. Also used JavaScript and jQuery for frontend features.",
                "CIRC Internship",
                ""));
        projects.add(new Project("Android recorder app",
                "Android app that allows users to record video at a low frame rate and quality to upload them over slow and inconsistent connections",
                "Android",
                "Android",
                "Used third party libraries to implement background resumable uploads from " +
                        "Android devices. Developed a video player imitation with images and" +
                        "sound. Used FFMPEG to encode uploaded files into videos in the server",
                "CIRC Internship",
                ""));
        projects.add(new Project("Meta",
                "A hub for students to upload information about their classes projects and a place for people to suggest ideas to students.",
                "Python",
                "Python, Flask, SQL",
                "Developed the structure of the project, the database, and all of the user\'s functionality.",
                "School Project",
                "http://meta.alainp.me/"));
    }

    public List<Project> getProjects() {
        return projects;
    }
}
