package alainp.me.alainresume.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/10/2015.
 */
public class Projects {
    private ArrayList<Project> projects;

    public Projects() {
        // Generate projects
        projects = new ArrayList<>();
        HashMap<String, Integer> mHubPics = new HashMap<>();
        // Missionary Hub
        mHubPics.put("Admin Home", R.drawable.project_sh1);
        mHubPics.put("Admin Table", R.drawable.project_sh2);
        projects.add(new Project("Missionary Hub",
                "A hub for missionaries overseas where they can chat and share videos with their mentors",
                "PHP",
                "Linux, Apache, MySQL, PHP, jQuery",
                "Developed a chat feature, the admin site, and the integration of a video player for server content. Also used JavaScript and jQuery for frontend features.",
                "CIRC Internship",
                "",
                mHubPics));
        // Android Sharehim app
        HashMap<String, Integer> aHubPics = new HashMap<>();
        aHubPics.put("Login", R.drawable.project_rec1);
        aHubPics.put("Upload 1", R.drawable.project_rec2);
        aHubPics.put("Upload 2", R.drawable.project_rec3);
        aHubPics.put("Video Player", R.drawable.project_rec4);
        projects.add(new Project("Android ShareHim app",
                "Android app that allows users to record video at a low frame rate and quality to upload them over slow and inconsistent connections",
                "Android",
                "Android",
                "Used third party libraries to implement background resumable uploads from " +
                        "Android devices. Developed a video player imitation with images and" +
                        "sound. Used FFMPEG to encode uploaded files into videos in the server",
                "CIRC Internship",
                "",
                aHubPics));
        // Meta
        HashMap<String, Integer> metaPics = new HashMap<>();
        metaPics.put("Home Page", R.drawable.project_meta1);
        metaPics.put("Projects Page", R.drawable.project_meta2);
        metaPics.put("Project Page", R.drawable.project_meta3);
        metaPics.put("Admin Page", R.drawable.project_meta4);
        projects.add(new Project("Meta",
                "A hub for students to upload information about their classes projects and a place for people to suggest ideas to students.",
                "Python",
                "Python, Flask, SQL",
                "Developed the structure of the project, the database, and all of the user\'s functionality.",
                "School Project",
                "http://meta.alainp.me/",
                metaPics));
        // Devoted
        HashMap<String, Integer> devotedPics = new HashMap<>();
        devotedPics.put("Devoted 1", R.drawable.project_rss1);
        devotedPics.put("Devoted 2", R.drawable.project_rss2);
        devotedPics.put("Devoted 3", R.drawable.project_rss3);
        projects.add(new Project("Devoted",
                "An rss reader for Android that shows daily devotionals and allows users to share them.",
                "Android",
                "Android",
                "Designed, coded, and published. (Solo project during internship).",
                "CIRC Project",
                "https://play.google.com/store/apps/details?id=edu.southern.cs.circ.devoted",
                devotedPics));
        // CA Online
        HashMap<String, Integer> caPics = new HashMap<>();
        caPics.put("Picture 1", R.drawable.project_ca1);
        caPics.put("Picture 2", R.drawable.project_ca2);
        projects.add(new Project("CA Online",
                "A website that allows students to register and pay the registration fee online.",
                "PHP",
                "Linux, Apache, MySQL, PHP, jQuery, Bootstrap 3",
                "Developed the database and forms to allow users to apply online to a high school. Used PHP as the scripting language along with JQuery and Bootstrap for all the UI elements and actions. Also integrated online payments using Stripe.",
                "CIRC Project",
                "",
                caPics));
        // Bible Journeys
        HashMap<String, Integer> bjPics = new HashMap<>();
        bjPics.put("Game Board", R.drawable.project_bj1);
        bjPics.put("Game Question and Answer", R.drawable.project_bj2);
        bjPics.put("Question Cards", R.drawable.project_bj3);
        bjPics.put("Game Start", R.drawable.project_bj4);
        projects.add(new Project("Bible Journeys Game",
                "A board game for mobile devices.",
                "CPP",
                "C++, Cocos2d-x",
                "Research and developed a demo to showcase how we could do a board game into a mobile game. The demo included playing full games, an internal dabase to display questions and anwers, scores, player animations and movement.",
                "CIRC Project",
                "",
                bjPics));
        // FFMPEG Android App
        HashMap<String, Integer> ffPics = new HashMap<>();
        ffPics.put("Pic 1", R.drawable.project_ca1);
        projects.add(new Project("FFMPEG Android APp",
                "An Android app that uses an FFMPEG library to change a video's resolution and/or frames per second.",
                "Android",
                "Android",
                "Developed during my internship to test the performance of our phones when encoding videos on the device. Used a known library (FFMPEG) for the encoding.",
                "CIRC Project",
                "",
                ffPics));

    }

    public List<Project> getProjects() {
        return projects;
    }
}
