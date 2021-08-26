import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private httpService: HttpClient) { }

  public registerUser(userData:any) : Observable<User> {
    return this.httpService.post<User>("http://localhost:2245/api/user/AddUser", userData);
  }
}
