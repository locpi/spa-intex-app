// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  env:'dev',
  hmr: false,
  topics: {
    get_error: 'pool/error',
    get_actual_temperature: 'pool/water/tempAct',
    get_expected_temperature: 'pool/water/tempSet',
    get_power_state: 'pool/power',
    get_bubble_state: 'pool/bubble',
    get_heater_state: 'pool/heater',
    get_filter_state: 'pool/filter',
    command_enable_bubble: 'pool/command/bubble',
    command_enable_heater: 'pool/command/heater',
    command_enable_filter: 'pool/command/filter',
    command_enable_power: 'pool/command/power',
    command_set_expected_temp: 'pool/command/water/tempSet',
    get_wifi_temp:'wifi/temp',
    get_wifi_version:'wifi/version',
    get_wifi_state:'wifi/state',
    get_wifi_update:'wifi/update',
    get_wifi_ip: "wifi/ip",
    get_wifi_rssi: "wifi/rssi",
    get_pool_error:"pool/error"
  },
  mqtt: {
    server: 'localhost',
    protocol: "ws",
    port: 9001,
    path: '',
    username: 'spa',
    password: 'spa',
    clientId:'admin-'+getRandomInt(78),
    mock: false
  },
  api: {
    baseurl: 'http://localhost:6500'
  }
};

function getRandomInt(max:number) {
  return Math.floor(Math.random() * max);
}
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
