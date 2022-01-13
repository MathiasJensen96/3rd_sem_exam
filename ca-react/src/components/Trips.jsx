import { useEffect } from "react";

export default function Trips(props) {
  const handleSubmit = (id) => {
    var name = id.target.id;
    const newGuide = {
      name: name,
      // gender: null,
      // birthYear: null,
      // profile: null,
      // imageURL: null,
    };
    //console.log(id.target.id);
    props.setGuide = newGuide;
    console.log(props.guide);
    //props.currentGuide(name);
  };

  return (
    <div>
      <h1>Here you find a list of all our trips</h1>

      <div key={props.trips}>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Tour Name</th>
              <th scope="col">Date</th>
              <th scope="col">Meeting Time</th>
              <th scope="col">Meeting Location</th>
              <th scope="col">Duration</th>
              <th scope="col">Packing List</th>
              <th scope="col">Guide</th>
            </tr>
          </thead>
          <tbody>
            {props.trips.map((trip) => (
              <tr key={trip.name}>
                <td>{trip.name}</td>
                <td>{trip.date}</td>
                <td>{trip.time}</td>
                <td>{trip.location}</td>
                <td>{trip.duration}</td>
                <td>{trip.packingList}</td>
                <td>
                  <div>
                    <button
                      id={trip.guideName}
                      onClick={handleSubmit}
                      type="button"
                    >
                      {trip.guideName}
                    </button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
