import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopComponent } from './shop/shop.component';
import { ProductComponent } from './product/product.component';

export const appRouteList: Routes = [
    { path: 'shop',component: ShopComponent},
    { path: 'product',component: ProductComponent}
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRouteList)
    ], 
    exports: [
        RouterModule
    ],
    declarations :[]
})
export class AppRoutingModule {}