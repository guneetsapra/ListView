package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    com.example.listview.ListViewAdapter listViewAdapter;
    ArrayList<Repo> repoList;

    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        repoList = new ArrayList<>();

        String restApiURL = "https://api.github.com/repositories";

        try
        {
            String data = new com.example.listview.Asycdata().execute(restApiURL).get();

            System.out.println("Data From Rest API : " + data);

            JSONObject mainObject = new JSONObject(data);

            JSONArray pJSONArray = mainObject.getJSONArray("Root");



            ArrayList<Repo> repoList = new ArrayList<>();


            for (int i = 0; i < pJSONArray.length(); i++) {

                JSONObject childObject = pJSONArray.getJSONObject(i);


                int id = childObject.getInt("id");

                String node_id = childObject.getString("node_id");

                String name = childObject.getString("name");

                String full_name = childObject.getString("full_name");

                boolean Private = childObject.getBoolean("Private");

                String html_url = childObject.getString("html_url");

                String description = childObject.getString("description");

                boolean fork = childObject.getBoolean("fork");

                String url = childObject.getString("url");

                String forks_url = childObject.getString("forks_url");

                String keys_url = childObject.getString("keys_url");

                String collaborators_url = childObject.getString("collaborators_url");

                String teams_url = childObject.getString("teams_url");

                String hooks_url = childObject.getString("hooks_url");

                String issue_events_url = childObject.getString("issue_events_url");

                String events_url = childObject.getString("events_url");

                String assignees_url = childObject.getString("assignees_url");

                String branches_url = childObject.getString("branches_url");

                String tags_url = childObject.getString("tags_url");

                String blobs_url = childObject.getString("blobs_url");

                String git_tags_url = childObject.getString("git_tags_url");

                String git_refs_url = childObject.getString("git_refs_url");

                String trees_url = childObject.getString("trees_url");

                String statuses_url = childObject.getString("statuses_url");

                String languages_url = childObject.getString("languages_url");

                String stargazers_url = childObject.getString("stargazers_url");

                String contributors_url = childObject.getString("contributors_url");

                String subscribers_url = childObject.getString("subscribers_url");

                String subscription_url = childObject.getString("subscription_url");

                String commits_url = childObject.getString("commits_url");

                String git_commits_url = childObject.getString("git_commits_url");

                String comments_url = childObject.getString("comments_url");

                String issue_comment_url = childObject.getString("issue_comment_url");

                String contents_url = childObject.getString("contents_url");

                String compare_url = childObject.getString("compare_url");

                String merges_url = childObject.getString("merges_url");

                String archive_url = childObject.getString("archive_url");

                String downloads_url = childObject.getString("downloads_url");

                String issues_url = childObject.getString("issues_url");

                String pulls_url = childObject.getString("pulls_url");

                String milestones_url = childObject.getString("milestones_url");

                String notifications_url = childObject.getString("notifications_url");

                String labels_url = childObject.getString("labels_url");

                String releases_url = childObject.getString("releases_url");

                String deployments_url = childObject.getString("deployments_url");

                String abc = childObject.getString("login");

                Owner owner = new Owner();

                owner.setLogin(abc);


                repoList.add(new Repo(id, node_id, name, full_name, Private, html_url, description, fork, url, forks_url, keys_url, collaborators_url, teams_url, hooks_url,
                        issue_events_url, events_url, assignees_url,
                        branches_url, tags_url, blobs_url, git_tags_url, git_refs_url, trees_url, statuses_url, languages_url, stargazers_url, contributors_url, subscribers_url, subscription_url,
                        commits_url, git_commits_url, comments_url, issue_comment_url, contents_url, compare_url, merges_url, archive_url, downloads_url, issues_url, pulls_url, milestones_url,
                        notifications_url, labels_url, releases_url, deployments_url, owner
                ));

            }

            listViewAdapter = new com.example.listview.ListViewAdapter(repoList, getApplication());

            listView.setAdapter(listViewAdapter);

        } catch (ExecutionException | InterruptedException | JSONException ex) {

            Log.e("MainActivity", ex.getMessage());
        }
    }
}