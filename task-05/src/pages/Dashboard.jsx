import './Dashboard.css'
import Top from '/src/components/TopMenu.jsx'
import Bottom from '/src/components/bottommenu.jsx'
import Song from '/src/components/Song.jsx'

function Dashboard(){
    return(
        <>
        <Top />
        <div className='Bottom'>
        <Bottom />
        </div>
        <div className='DContainer'>
            <h1 className='Recent'> RECENTLY PLAYED </h1>
            
            <div className='Recently_Played'>
                <Song></Song>
                <Song></Song>
                <Song></Song>
                <Song></Song>
                <Song></Song>
                <Song></Song>
            </div>
            <h1 className='Recommended'> RECOMMENDED SONGS </h1>
            <div className='Recommended_Songs'>
                <Song></Song>
                <Song></Song>
                <Song></Song>
                <Song></Song>
                <Song></Song>
                <Song></Song>
            </div>
            
        </div>

        
        </>
    )
    
}

export default Dashboard