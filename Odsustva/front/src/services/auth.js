import Axios from "../apis/Axios"
import jwt_decode from "jwt-decode"

export const login = async function(username, password){
    const cred={
        username:username,
        password: password
    }

    try{
        const ret = await Axios.post('korisnici/auth', cred);
        const decoded = jwt_decode(ret.data);
        console.log(decoded.role.authority)
        window.localStorage.setItem('role', decoded.role.authority);
        window.localStorage.setItem('jwt', ret.data);
        window.localStorage.setItem('exp_date', decoded.exp_date)

    }catch(error){
        console.log(error);
    }
    window.location.reload();
}

export const logout = function(){
    window.localStorage.removeItem('jwt');
    window.location.reload();
}