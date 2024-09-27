import './App.css';
import { Routes, Route, BrowserRouter as Router } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import Discounts from './components/Discounts';
import Cart from './components/Cart';

function App() {
  return (
   
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/discounts" element={<Discounts />} />
        <Route path="/cart" element={<Cart />} />
      </Routes>

  );
}

export default App;
