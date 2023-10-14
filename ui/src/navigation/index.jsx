import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Header } from "../components/Header";
import Login from "../pages/Login";
import Register from "../pages/Register";
import LoginSuccess from "../pages/LoginSuccess";
import { useSelector } from "react-redux";
import { cartProducts } from "../stores/cart/cartSlice";
import { Footer } from "../components/Footer";

const Navigation = () => {
    const productsInCart = useSelector(cartProducts);

    return (
        <BrowserRouter>
            <Header cartCount={productsInCart ? productsInCart.length : 0}/>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/login-success" element={<LoginSuccess />} />
            </Routes>
            <Footer />
        </BrowserRouter>
    )
}

export default Navigation;