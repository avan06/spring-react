// http://coffeescript.org/
// coffee --compile --output <output> <source>
ex. cd spring-react/src/main/webapp/js/
	coffee -o ./ -c ./coffee/
	coffee -o ./ -bc ./coffee/

// https://github.com/jsdf/coffee-react
// cjsx -o <output> -bc <source>
ex. cd spring-react/src/main/webapp/js/
	cjsx -o ./ -bc ./cjsx/
	cjsx-transform ./cjsx/systblCJsx.cjsx | coffee -cbs > ./test.js

// https://www.npmjs.com/package/react-tools
// jsx -x jsx <source> <output>
ex. cd spring-react/src/main/webapp/js/
	jsx -x jsx ./jsx/ ./