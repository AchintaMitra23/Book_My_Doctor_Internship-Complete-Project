import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpService: HttpClient) { }

  public loginUser(email : any, password : any) : Observable<User> {
    return this.httpService.get<User>(`${"http://localhost:2245/api/login/loginUser"}/${email}/${password}`);
  }

  public getUserByEmailAndPassword(email : any, password : any) : Observable<User> {
    return this.httpService.get<User>(`${"http://localhost:2245/api/user/GetUserIdByEmail"}/${email}/${password}`);
  }

  public logoutUser(userId : any) : Observable<boolean> {
    return this.httpService.get<boolean>(`${"http://localhost:2245/api/login/logoutUser"}/${userId}`);
  }

  public forgotPassword(email : any, newPass : any, confirmPass : any) : Observable<any> {
    return this.httpService.put<any>(`${"http://localhost:2245/api/login/forgotPassword"}/${email}/${newPass}/${confirmPass}`, null);
  }



}
