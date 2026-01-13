import search_button from "/assets/search.svg";
import "./SearchInput.css";

function Search({ query, setQuery, onSearch }) {
  return (
    <div className="SearchBar">
      <div className="logo">
        <img src={search_button} alt="Search button" />
      </div>
      <input
        type="text"
        className="searchInput"
        placeholder="Search..."
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        onKeyDown={(e) => {
          if (e.key === "Enter") {
            onSearch();
          }
        }}
      />
    </div>
  );
}

export default Search;
