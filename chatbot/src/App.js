import './App.css';
import { Routes, Route, HashRouter } from 'react-router-dom'
import Home from './components/Home'
import About from './components/About';
import Contact from './components/Contact';
import Discounts from './components/Discounts';
import Cart from './components/Cart';


function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />}>
          <Route index element={<Home />} />
          <Route path="/home" element={<Home />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path='/contact' element={<Contact />}></Route>
          <Route path='/discounts' element={<Discounts />}></Route>
          <Route path='/cart' element={<Cart />}></Route>

        </Route>
      </Routes>
    </>
  )
}

export default App;