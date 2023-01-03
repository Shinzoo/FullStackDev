import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';
import { Shop } from './shop';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http : HttpClient) { }

  public getShop(): Observable<Shop[]>{
    return this.http.get<Shop[]>(`${this.apiServerUrl}/shop/all`);
  }

  public addShop(shop: Shop): Observable<Shop> {
    return this.http.post<Shop>(`${this.apiServerUrl}/shop/add`, shop);
  }

  public updateShop(shop: Shop): Observable<Shop> {
    return this.http.put<Shop>(`${this.apiServerUrl}/shop/update`, shop);
  }

  public deleteShop(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/shop/delete/${id}`);
  }
}
