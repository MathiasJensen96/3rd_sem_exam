import "./App.css";
import "./style2.css";
import OurNavbar from "./components/Navbar";
import Home from "./components/Home";
import Trips from "./components/Trips";
import facade from "./facade";
import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

export default function BasicExample() {
  const [trips, setTrips] = useState([]);

  const [loggedIn, setLoggedIn] = useState(false);
  const [errorMessage, setErrorMessage] = useState("All is good ... so far");

  const logout = () => {
    facade.logout();
    setLoggedIn(false);
    setErrorMessage("Logged out.");
  };

  useEffect(() => {
    fetch(`https://jenseninc.dk/devops-starter/api/trip/all`)
      .then((res) => res.json())
      .then((data) => {
        data.all.forEach((element) => {
          const newTrip = {
            name: element.name,
            date: element.data,
            time: element.time,
            location: element.location,
            duration: element.duration,
            packingList: element.packingList,
          };
          console.log(newTrip);
        });
        //console.log(data.all);
        // setTrips(data.all[0]);
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
              <Home />
            </Route>
            <Route path="/Trips">
              <Trips trips={trips} />
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  );
}
