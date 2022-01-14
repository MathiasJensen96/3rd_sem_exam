export default function Trips(props) {
  async function test() {}

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
              <tr key={trip.guide.name}>
                <td>{trip.name}</td>
                <td>{trip.date}</td>
                <td>{trip.time}</td>
                <td>{trip.location}</td>
                <td>{trip.duration}</td>
                <td>{trip.packingList}</td>
                <td onClick={() => props.currentGuide(trip.guide)}>
                  {trip.guide.name}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
