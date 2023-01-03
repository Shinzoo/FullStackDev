import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Category } from './category';
import { CategoryService } from './category.service';

@Component({
  selector: 'app-root',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  title = 'Category';

  public categorys: Category[];
  public editCategory: Category;
  public deleteCategory: Category;


  constructor(private categoryService: CategoryService){}

  ngOnInit() {
    this.getCategory();
  }

  public getCategory(): void {
    this.categoryService.getCategory().subscribe(
      (response: Category[]) => {
        this.categorys = response;
        console.log(this.categorys);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddCategory(addForm: NgForm): void {
    document.getElementById('add-category-form').click();
    this.categoryService.addCategory(addForm.value).subscribe(
      (response: Category) => {
        console.log(response);
        this.getCategory();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateCategory(category: Category): void {
    this.categoryService.updateCategory(category).subscribe(
      (response: Category) => {
        console.log(response);
        this.getCategory();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCategory(id: number): void {
    this.categoryService.deleteCategory(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getCategory();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  /*public searchShop(key: string): void {
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
  }*/

  public onOpenModal(category: Category, mode: string): void {
    const container = document.getElementById('main-container') ;
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addCategoryModal');
    }
    if (mode === 'edit') {
      this.editCategory = category;
      button.setAttribute('data-target', '#updateCategoryModal');
    }
    if (mode === 'delete') {
      this.deleteCategory = category;
      button.setAttribute('data-target', '#deleteCategoryModal');
    }
    container.appendChild(button);
    button.click();
  }
}
