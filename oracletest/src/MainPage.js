import React, { useState } from "react";
import axios from "axios";

import "./MainPage.css";

const initialFormState = {
    elements: "",
    fibonacci: [],
    sortedfib: []
};
const MainPage = () => {
    const [response, setResponse] = useState(null);
    const [elements, setElements] = useState("");

    const sendRequest = async (event) => {
        event.preventDefault();

        if (elements < 1) {
            alert("Element value must be greater than or equal to 1");
            return;
        }

        try {
            const requestBody = {
                elements: elements,
            };

            const response = await axios.post("/fibonacci", requestBody);
            setResponse(response.data);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className="main-container">
            <form className="form-container" onSubmit={sendRequest}>
                <div className="form-group">
                    <label className="label">Enter an Element:</label>
                    <input
                        className="input"
                        type="number"
                        value={elements}
                        onChange={(event) => setElements(event.target.value)}
                    />
                </div>
                <button className="button" type="submit">
                    Get Fibonacci Sequence
                </button>
            </form>

            {response && (
                <div className="container">
                    <h2 className="heading">Response:</h2>
                    <p className="item">
                        <b>Fibonacci</b>: {response.fibonacci.join(", ")}
                    </p>
                    <p className="item">
                        <b>Sorted Fibonacci:</b> {response.sortedfib.join(", ")}
                    </p>
                </div>
            )}
        </div>
    );
};

export default MainPage;
