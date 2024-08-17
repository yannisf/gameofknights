const resolve = require('@rollup/plugin-node-resolve');
const commonjs = require('@rollup/plugin-commonjs');
const terser = require('@rollup/plugin-terser');
const path = require('path');

module.exports = {
    input: path.resolve(__dirname, './out/index.js'), // Path to your entry file
    output: {
        file: path.resolve(__dirname, './dist/index.js'), // Path to the output file
        format: 'cjs', // CommonJS format for Node.js
    },
    plugins: [
        resolve(), // Helps Rollup find and include dependencies
        commonjs(), // Converts CommonJS modules to ES6
        terser()
    ],
};
