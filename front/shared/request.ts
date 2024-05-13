import axios, { AxiosRequestConfig, RawAxiosRequestHeaders } from "axios"
import { GetServerSidePropsContext, NextApiRequest, NextApiResponse } from "next"

export type ApiContext =
  | GetServerSidePropsContext
  | {
      req: NextApiRequest
      res: NextApiResponse
    }

export enum StatusCode {
  OK = 200,
  Empty = 204,
  MethodNotAllowed = 405,
  InternalServerError = 500
}

type RequestConfig<BODY> = Pick<AxiosRequestConfig<BODY>, 'url' | 'method'> & {
    params?: BODY
  }

export async function makeRequest<T = void, BODY = unknown>(
    { url, method = 'GET', params }: RequestConfig<BODY>,
    context: ApiContext | null
  ) {
    const headers: RawAxiosRequestHeaders = {
      'content-type': 'application/json;charset=UTF-8'
    }
  
    const options: AxiosRequestConfig<BODY> = {
      method: method,
      url: url,
      headers,
      responseType: 'json'
    }
  
    if (params) {
      if (method === 'GET' || method === 'get') {
        options.params = params
      } else {
        options.data = params
      }
    }
    const resp = await axios.request<T>(options)
  
    return resp.data
  }