import React, {useEffect, useState} from 'react'
import KakaoLogo from './img/kakao_login_icon.png'
import SignUp from './SignUp'

const testUser={
    id:"aaa",
    pw:"1234"
}

export default function SignIn() {
    const [id, setId] = useState('');
    const [pw, setPw] = useState('');
    const [notAllow, setNotAllow] = useState(true);

    const handleId = (e) => {
        setId(e.target.value);
    }

    const handlePw = (e) => {
        setPw(e.target.value);
    }

    const onClickSignIn = () => {
        if(id == testUser.id && pw == testUser.pw) {
            alert("로그인 성공");
        } else {
            alert("로그인 실패");
        }
    }

    useEffect(() => {
        if(id && pw) {
            setNotAllow(false);
            return;
        }
        setNotAllow(true);
    }, [id,pw])

    return(
        <div className="signIn_main">
            <div className="titleWrap">
                로그인
            </div>

            <div className="contentWrap">
                <div className="inputTitle">아이디</div>
                <div className="inputWrap">
                    <input
                        type="text"
                        className="input"
                        placeholder="아이디 입력"
                        value={id}
                        onChange={handleId}
                    />
                </div>

                <div className="inputTitle">비밀번호</div>
                <div className="inputWrap">
                    <input
                        type="password"
                        className="input"
                        placeholder="비밀번호 입력"
                        value={pw}
                        onChange={handlePw}
                    />
                </div>
            </div>

            <div>
                <button disabled={notAllow} className="formButton" onClick={onClickSignIn}>
                    확인
                </button>
            </div>

            <div className="otherLogin">
                <img src={KakaoLogo} alt="kakao_login_icon.png" />
            </div>
        </div>
    );
}