import { constants } from './constants'

// this function would create a final url for an API
export function createUrl(path) {
  return constants.serverUrl + path
}

// use the logging on console by default
export function log(message) {
  console.log(message)
}