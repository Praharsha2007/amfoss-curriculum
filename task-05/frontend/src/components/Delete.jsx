import delete_button from "/assets/delete.svg";

function Delete({ songId }) {
  const remove = async () => {
    await fetch("http://127.0.0.1:5000/playlist/removesong", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ song_id: songId })
    });

    window.location.reload();
  };

  return (
    <button onClick={remove}>
      <img src={delete_button} />
    </button>
  );
}

export default Delete;
