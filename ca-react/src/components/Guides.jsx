export default function Guides(props) {
  return (
    <div>
      <h1>Here you find a list of all our guides</h1>

      <div key={props.trips}>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Name</th>
              <th scope="col">Gender</th>
              <th scope="col">Birth Year</th>
              <th scope="col">Profile</th>
              <th scope="col">Image</th>
            </tr>
          </thead>
          <tbody>
            {props.guides.map((guide) => (
              <tr key={guide.name}>
                <td>{guide.name}</td>
                <td>{guide.gender}</td>
                <td>{guide.birthYear}</td>
                <td>{guide.profile}</td>
                <td>{guide.imageURL}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
