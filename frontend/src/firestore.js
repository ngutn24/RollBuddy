import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";
import {
  getAuth,
  // signInWithPopup,
  GoogleAuthProvider,
  // signInAnonymously,
} from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyDiMNykw_U-2ypKcxptEmzLOBHd94wLy-Y",
  authDomain: "rollbuddy-21bea.firebaseapp.com",
  projectId: "rollbuddy-21bea",
  storageBucket: "rollbuddy-21bea.appspot.com",
  messagingSenderId: "428593318705",
  appId: "1:428593318705:web:29ce7a302b4431d9aa7e10",
};

const app = initializeApp(firebaseConfig);
export const db = getFirestore(app);
export const auth = getAuth();
// auth for google accounts
export const provider = new GoogleAuthProvider();
provider.setCustomParameters({ prompt: "select_account" });
