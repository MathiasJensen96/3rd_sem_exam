import "./App.css";
import "./style2.css";
import OurNavbar from "./components/Navbar";
import Home from "./components/Home";
import Trips from "./components/Trips";
import Guides from "./components/Guides";
import facade from "./facade";
import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

const initialGuideState = {
  name: null,
  // gender: null,
  // birthYear: null,
  // profile: null,
  // imageURL: null,
};

export default function BasicExample() {
  const [loggedIn, setLoggedIn] = useState(false);
  const [loggedInUser, setLoggedInUser] = useState("");
  const [errorMessage, setErrorMessage] = useState("All is good ... so far");
  const [trips, setTrips] = useState([]);
  const [guide, setGuide] = useState(initialGuideState);

  const logout = () => {
    facade.logout();
    setLoggedIn(false);
    setErrorMessage("Logged out.");
  };

  useEffect(() => {
    fetch(`https://jenseninc.dk/devops-starter/api/trip/all`)
      .then((res) => res.json())
      .then((data) => {
        console.log(data.all);
        data.all.forEach((element) => {
          const newTrip = {
            id: element.id,
            name: element.name,
            date: element.date,
            time: element.time,
            location: element.location,
            duration: element.duration,
            packingList: element.packingList,
            guideName: element.guideName,
          };
          //console.log(newTrip);
          trips.push(newTrip);
        });
        //console.log(trips);
      });
  }, []);

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
              {facade.hasUserAccess("user", loggedIn) && (
                <Trips trips={trips} guide={guide} setGuide={setGuide} />
              )}
            </Route>
            <Route path="/Guides">
              <Guides />
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  );
}
