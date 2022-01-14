import "./App.css";
import "./style2.css";
import OurNavbar from "./components/Navbar";
import Home from "./components/Home";
import Trips from "./components/Trips";
import Guides from "./components/Guides";
import facade from "./facade";
import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import GuideBio from "./components/GuideBio";
import AdminPage from "./components/AdminPage";

const initialGuideState = {
  name: null,
  gender: null,
  birthYear: null,
  profile: null,
  imageURL: null,
};

export default function BasicExample() {
  const [loggedIn, setLoggedIn] = useState(false);
  const [loggedInUser, setLoggedInUser] = useState("");
  const [errorMessage, setErrorMessage] = useState("All is good ... so far");
  const [trips, setTrips] = useState([]);
  const [ourGuide, setOurGuide] = useState(initialGuideState);
  const [guides, setGuides] = useState([]);

  const logout = () => {
    facade.logout();
    setLoggedIn(false);
    setErrorMessage("Logged out.");
  };

  useEffect(() => {
    fetch(`https://jenseninc.dk/devops-starter/api/trip/all`)
      .then((res) => res.json())
      .then((data) => {
        //console.log(data.all);
        data.all.forEach((element) => {
          const newTrip = {
            id: element.id,
            name: element.name,
            date: element.date,
            time: element.time,
            location: element.location,
            duration: element.duration,
            packingList: element.packingList,
            guide: element.guide,
          };
          //console.log(newTrip);
          trips.push(newTrip);
        });
        //console.log(trips);
      });
  }, []);

  useEffect(() => {
    fetch(`https://jenseninc.dk/devops-starter/api/guide/all`)
      .then((res) => res.json())
      .then((data) => {
        //console.log(data.all);
        data.all.forEach((element) => {
          const newGuide = {
            name: element.name,
            gender: element.gender,
            birthYear: element.birthYear,
            profile: element.profile,
            imageURL: element.imageURL,
          };
          guides.push(newGuide);
        });
      });
  }, []);

  async function currentGuide(guide) {
    const newGuide = {
      name: guide.name,
      gender: guide.gender,
      birthYear: guide.birthYear,
      profile: guide.profile,
      imageURL: guide.imageURL,
    };
    return newGuide;
    // setTimeout(() => {
    //   setOurGuide(newGuide);
    // }, 1000);
    // if (ourGuide !== null) {
    //   console.log(ourGuide);
    // }
  }

  return (
    <Router>
      <div>
        <OurNavbar />
        <div className="content">
          {/* {JSON.stringify(restaurants, null, 2)} */}
          <Switch>
            <Route exact path="/">
              <Home
                logout={logout}
                loggedIn={loggedIn}
                setLoggedIn={setLoggedIn}
                facade={facade}
                setErrorMessage={setErrorMessage}
                loggedInUser={loggedInUser}
                setLoggedInUser={setLoggedInUser}
              />
            </Route>
            <Route path="/Trips">
              {/* {facade.hasUserAccess("user", loggedIn) && ( */}
              <Trips trips={trips} currentGuide={currentGuide} />
              {/* )} */}
            </Route>
            <Route path="/Guides">
              <Guides guides={guides} />
            </Route>
            <Route path="/GuideBio">
              <GuideBio currentGuide={currentGuide} />
            </Route>
            <Route path="/AdminPage">
              <AdminPage />
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  );
}
