
import './App.css';
import SignIn from './SignIn';
import SignUp from './SignUp';

function App() {
    return (
        <div className="testWrap">
            <div className="testBlock">
                <SignIn></SignIn>
            </div>
            <div className="testBlock">
                <SignUp></SignUp>
            </div>
        </div>
    );
}

export default App;
