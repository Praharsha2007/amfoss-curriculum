import Album_card from './album.jsx'

function Suggesting({ album }) {
  return (
    <div className="results_album">
      {album.map(a => (
        <Album_card key={a.id} album={a} />
      ))}
    </div>
  );
}

export default Suggesting