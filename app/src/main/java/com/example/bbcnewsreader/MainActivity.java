package com.example.bbcnewsreader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends BaseActivity {
    protected ListView lstTitles;
    private ArrayList<News> newsList;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setContentView(R.layout.activity_main);
        ViewGroup content = (ViewGroup) findViewById(R.id.baseContainer);
        getLayoutInflater().inflate(R.layout.activity_main, content, true);
        //setContentView(R.layout.activity_main);

        this.lstTitles = findViewById(R.id.lstTitles);

        this.newsList = new ArrayList<>();

        // instantiate the custom list adapter
        adapter = new NewsAdapter(this, newsList);

        // get the ListView
        lstTitles  = findViewById(R.id.lstTitles);
        lstTitles.setAdapter(adapter);

        lstTitles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("title", news.getTitle());
                intent.putExtra("description", news.getDescription());
                intent.putExtra("date", news.getDate());
                intent.putExtra("link", news.getUrl());
                startActivity(intent);
            }
        });

        // Load XML Data
        XMLAsyncTask task = new XMLAsyncTask();
        task.execute();
    }



    class XMLAsyncTask extends AsyncTask<String, Void, Boolean> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {

                URL url = new URL("https://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                newsList.clear();

                InputStream stream = connection.getInputStream();

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(stream);

                Element element=doc.getDocumentElement();
                element.normalize();

                NodeList itemList = doc.getElementsByTagName("item");

                for (int i = 0; i < itemList.getLength(); i++) {

                    Node node = itemList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element itemNode = (Element) node;
                        String title = getValue("title", itemNode);
                        String description = getValue("description", itemNode);
                        String link = getValue("link", itemNode);
                        String pubDate = getValue("pubDate", itemNode);
                        News news = new News(title, description, pubDate, link);

                        newsList.add(news);
                    }
                }
                return true;


            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            adapter.notifyDataSetChanged();
        }
    }

    private String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}