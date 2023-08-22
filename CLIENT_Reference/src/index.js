import React from 'react';
import ReactDOM from 'react-dom/client';
import PageController from './Routes/Router';
<link
  rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
  integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
  crossorigin="anonymous"
/>
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(<PageController/>);

