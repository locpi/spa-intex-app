export const environment = {
  production: true,
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
    server: '217.160.65.22',
    protocol: "ws",
    port: 9001,
    path: '',
    username: 'spa',
    password: 'spa',
    clientId:'admin-'+getRandomInt(78),
    mock: false
  },
  api: {
    baseurl: 'http://217.160.65.22:6500'
  }
};

function getRandomInt(max:number) {
  return Math.floor(Math.random() * max);
}
