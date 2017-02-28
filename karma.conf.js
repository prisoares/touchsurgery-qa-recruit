module.exports = function (config) {
  config.set({
    basePath: '',
    frameworks: ['mocha', 'chai', 'sinon', 'sinon-chai'],
    files: [
      'src/main/resources/static/js/angular.min.js',
      'node_modules/angular-mocks/angular-mocks.js',
      'src/test/javascript/**/*.js',
      'src/main/resources/static/js/shop_app.js',
      'src/main/resources/static/js/**/*.js'
    ],
    exclude: [],
    preprocessors: {
      'src/main/resources/static/js/shop_app.js': 'coverage',
      'src/main/resources/static/js/*_controller.js': 'coverage',
      'src/main/resources/static/js/*_service.js': 'coverage'
    },
    reporters: ['dots', 'progress', 'coverage'],
    coverageReporter: {
      type: 'html',
      dir: 'target/karma-coverage/'
    },
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    browsers: ['Chrome'],
    singleRun: false,
    concurrency: Infinity
  })
};