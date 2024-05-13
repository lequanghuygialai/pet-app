import { Paging, Contact } from 'front/shared/models';
import { makeRequest } from 'front/shared/request';
import { NextResponse } from 'next/server';

const apiHpst = 'http://localhost:8080';

export async function GET(request: Request) {
  const resp = await makeRequest<Paging<Contact>>(
    {
      url: `${apiHpst}/api/contacts`,
      method: 'GET',
      params: {},
    },
    null
  );

  return NextResponse.json(resp);
}
