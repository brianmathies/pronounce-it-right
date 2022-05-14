import React, { useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import AudioReactRecorder, { RecordState } from 'audio-react-recorder'

import './App.css';

function App() {
  const [recordState, setRecordState] = useState(null);

  const start = () => {
    setRecordState(RecordState.START);
  }
 
  const stop = () => {
    setRecordState(RecordState.STOP);
  }
 
  //audioData contains blob and blobUrl
  const onStop = (audioData) => {
    console.log('audioData', audioData)
  }

  return (
    <div className="App">
      <InputText />
      <Button label="Hello" />
      <div>
        <AudioReactRecorder state={recordState} onStop={onStop} />
 
        <button onClick={start}>Start</button>
        <button onClick={stop}>Stop</button>
      </div>
    </div>
  );
}

export default App;
