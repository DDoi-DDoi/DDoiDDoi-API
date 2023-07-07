import React, {useEffect, useState} from 'react';
import axios from 'axios';
import HomePage from "./HomePage";
import Login from "./Login";

function App() {
    const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            <Login></Login>
        </div>
    );
}

export default App;