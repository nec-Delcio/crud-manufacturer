import NavLogo from "../../../assets/logo.png";
import { Link, NavLink } from "react-router-dom";
import GitHubIcon from "../../../assets/github.svg";
import "./styles.scss";

const Navbar = () => {
  return (
    <nav className="row bg-primary main-nav">
      <div className="col-2">
        <Link to="/">
          <img src={NavLogo} className="nav-logo" />
        </Link>
      </div>
      <div className="col-6 offset-2">
        <ul className="main-menu">
          <li>
            <NavLink
              to="/"
              className={({ isActive }) => [isActive ? "active" : ""].join(" ")}
            >
              HOME
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/register"
              className={({ isActive }) => [isActive ? "active" : ""].join(" ")}
            >
              CADASTRO
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/list"
              className={({ isActive }) => [isActive ? "active" : ""].join(" ")}
            >
              LISTAGEM
            </NavLink>
          </li>
          <li>
            <div className="contact-container">
              <a
                href="https://github.com/eliasneri"
                target="_blank"
                rel="noreferrer">
                <img src={GitHubIcon} />
                <span className="contact-link">/eliasneri</span>
              </a>
            </div>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
