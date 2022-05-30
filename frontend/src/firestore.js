import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";
import {
  getAuth,
  // signInWithPopup,
  GoogleAuthProvider,
  // signInAnonymously,
} from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyAbncFVJg1v1hV8yDxdgj1paYLqXbDZkrs",
  authDomain: "rollbuddy-test.firebaseapp.com",
  projectId: "rollbuddy-test",
  storageBucket: "rollbuddy-test.appspot.com",
  messagingSenderId: "97427959120",
  appId: "1:97427959120:web:aaeaeb2dd54786babcd055",
};

const app = initializeApp(firebaseConfig);
export const db = getFirestore(app);
export const auth = getAuth();
// auth for google accounts
export const provider = new GoogleAuthProvider();
provider.setCustomParameters({ prompt: "select_account" });
