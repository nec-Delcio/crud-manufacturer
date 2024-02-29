import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Navbar from "./core/components/Navbar";
import Register from "./pages/Register";
import Listing from "./pages/Listing";

const RoutesPage = () => (
    <BrowserRouter>
    <Navbar />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/register" element={<Register />} />
            <Route path="/list" element={<Listing />} />
        </Routes>
    
    </BrowserRouter>

);

export default RoutesPage;