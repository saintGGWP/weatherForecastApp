import { IAuthor } from 'app/shared/model/author.model';

export interface IBook {
  id?: number;
  name?: string;
  pages?: number;
  author?: IAuthor;
}

export class Book implements IBook {
  constructor(public id?: number, public name?: string, public pages?: number, public author?: IAuthor) {}
}
