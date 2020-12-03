package com.usertackingmodule.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FireBaseInitializer {

	@PostConstruct
	private void initDB() throws IOException, URISyntaxException {

		URL resource = this.getClass().getClassLoader()
				.getResource("simpleapi-db4a4-firebase-adminsdk-47qx0-5ce36d449f.json");
		File file = new File(resource.toURI());
		FileInputStream serviceAccount = new FileInputStream(file);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}

		// URL resource =
		// this.getClass().getClassLoader().getResource("simplecrudapi-c8bcf-firebase-adminsdk-jqyyp-d28d9c2a2e.json");
		// File file = new File(resource.toURI());
		// FileInputStream serviceAccount = new FileInputStream(file);
		//
		// FileInputStream serviceAccount =
		// new FileInputStream("path/to/serviceAccountKey.json");
		//
		// FirebaseOptions options = new FirebaseOptions.Builder()
		// .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		// .build();
		//
		// FirebaseApp.initializeApp(options);
		//
		//
		// URL resource =
		// this.getClass().getClassLoader().getResource("simplecrudapi-c8bcf-firebase-adminsdk-jqyyp-d28d9c2a2e.json");
		// File file = new File(resource.toURI());
		// FileInputStream serviceAccount = new FileInputStream(file);
		//// FileInputStream serviceAccount = new FileInputStream(
		//// this.getClass().getResourceAsStream("./"));
		//
		// FirebaseOptions options = new FirebaseOptions.Builder()
		// .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		// .setDatabaseUrl("https://simplecrudapi-c8bcf.firebaseio.com").build();
		//
		// if (FirebaseApp.getApps().isEmpty()) {
		// FirebaseApp.initializeApp(options);
		// }
	}

	public Firestore getFireBase() {
		return FirestoreClient.getFirestore();
	}
}
