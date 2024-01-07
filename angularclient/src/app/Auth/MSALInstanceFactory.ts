import {IPublicClientApplication, PublicClientApplication} from "@azure/msal-browser";

export function MSALInstanceFactory() : IPublicClientApplication {
  return new PublicClientApplication(
    {
      auth: {
        clientId: '3e7d00b7-7411-4396-b233-eecd737d7d60',
        redirectUri: 'http://localhost:4200'
      }
    }
  )
}
