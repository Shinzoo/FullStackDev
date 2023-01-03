import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { Shop } from './shop';
import { ShopService } from './shop.service';

@Component({
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {
  title = 'shop';

  public shops: Shop[];
  public editShop: Shop;
  public deleteShop: Shop;


  constructor(private shopService: ShopService, private router : Router){}

  ngOnInit() {
    this.getShop();
  }

  onContinue(): void {
    this.router.navigate(['product']);
  }

  public getShop(): void {
    this.shopService.getShop().subscribe(
      (response: Shop[]) => {
        this.shops = response;
        console.log(this.shops);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddShop(addForm: NgForm): void {
    document.getElementById('add-shop-form').click();
    this.shopService.addShop(addForm.value).subscribe(
      (response: Shop) => {
        console.log(response);
        this.getShop();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateShop(shop: Shop): void {
    this.shopService.updateShop(shop).subscribe(
      (response: Shop) => {
        console.log(response);
        this.getShop();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteShop(id: number): void {
    this.shopService.deleteShop(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getShop();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchShop(key: string): void {
    console.log(key);
    const results: Shop[] = [];
    for (const shop of this.shops) {
      if (shop.name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(shop);
      }
    }
    this.shops = results;
    if (results.length === 0 || !key) {
      this.getShop();
    }
  }

  public onOpenModal(shop: Shop, mode: string): void {
    const container = document.getElementById('main-container') ;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addShopModal');
    }
    if (mode === 'edit') {
      this.editShop = shop;
      button.setAttribute('data-target', '#updateShopModal');
    }
    if (mode === 'delete') {
      this.deleteShop = shop;
      button.setAttribute('data-target', '#deleteShopModal');
    }
    container.appendChild(button);
    button.click();
  }
}
