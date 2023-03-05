import React, {useEffect, useState} from 'react'

export default function SignUp() {
    const [id, setId] = useState('');
    const [pw, setPw] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [email, setEmail] = useState('');
    const [univ, setUniv] = useState('');
    const [notAllow, setNotAllow] = useState(true);

    const handleId = (e) => {
        setId(e.target.value);
    }

    const handlePw = (e) => {
        setPw(e.target.value);
    }

    const onClickSignUp = () => {
        if(id && pw) {
            alert("회원가입 성공");
        } else {
            //불가능 상태
            alert("회원가입 실패");
        }
    }

    useEffect(() => {
        if(id && pw && name && email && phone && univ) {
            setNotAllow(false);
            return;
        }
        setNotAllow(true);
    }, [id,pw,name,email,phone,univ])

    return(
        <div className="signUp_main">
            <div className="titleWrap">
                회원가입
            </div>

            <div className="contentWrap">
                <div className="inputFieldWrap">
                    <div className="inputTitle">
                        아이디
                        <button className="idCheckButton" onClick="#">
                            id중복확인
                        </button>
                    </div>
                    <div className="inputWrap">
                        <input
                            type="text"
                            className="input"
                            placeholder="아이디 입력"
                            value={id}
                            onChange={handleId}
                        />
                    </div>
                </div>

                <div className="inputFieldWrap">
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

                <div className="inputFieldWrap">
                    <div className="inputTitle">사용자 이름</div>
                    <div className="inputWrap">
                        <input
                            type="text"
                            className="input"
                            placeholder="이름 입력"
                            value={name}
                            onChange={(e) => {
                                setName(e.target.value);
                            }}
                        />
                    </div>
                </div>

                <div className="inputFieldWrap">
                    <div className="inputTitle">이메일</div>
                    <div className="inputWrap">
                        <input
                            type="text"
                            className="input"
                            placeholder="abcd123@naver.com"
                            value={email}
                            onChange={(e) => {
                                setEmail(e.target.value);
                            }}
                        />
                    </div>
                </div>

                <div className="inputFieldWrap">
                    <div className="inputTitle">전화번호</div>
                    <div className="inputWrap">
                        <input
                            type="text"
                            className="input"
                            placeholder="010-0000-0000"
                            value={phone}
                            onChange={(e) => {
                                setPhone(e.target.value);
                            }}
                        />
                    </div>
                </div>

                <div className="inputFieldWrap">
                    <div className="inputTitle">대학교</div>
                    <div className="inputWrap">
                        <input
                            type="text"
                            className="input"
                            placeholder="00대학교"
                            value={univ}
                            onChange={(e) => {
                                setUniv(e.target.value);
                            }}
                        />
                    </div>
                </div>
            </div>

            <div>
                <button disabled={notAllow} className="formButton" onClick={onClickSignUp}>
                    확인
                </button>
            </div>
        </div>
    );
}