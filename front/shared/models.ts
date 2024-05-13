export type Paging<T> = {
  content: T[];
  pageable: Pageable;
  last: boolean;
  totalPages: number;
  totalElements: number;
  first: boolean;
  size: number;
  number: number;
  sort: Sort;
  numberOfElements: number;
  empty: boolean;
};

export type Contact = {
  id: string;
  name: string;
  email: string;
  title: string;
  phone: string;
  address: string;
  status: Status;
};

export enum Status {
  Active = 'ACTIVE',
}

export type Pageable = {
  pageNumber: number;
  pageSize: number;
  sort: Sort;
  offset: number;
  paged: boolean;
  unpaged: boolean;
};

export type Sort = {
  empty: boolean;
  sorted: boolean;
  unsorted: boolean;
};
