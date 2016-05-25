angular.module('zmon2App').filter('entityName', function() {
    /*
     * Shortens entity names. Does nothing for entity names without square brackets.
     * i.e: "i-09ec2da3[aws:786011980701:eu-west-1]" => "i-09ec2da3[a:701:eu-west-1]"
    */
    return function(value, length) {
        var r = /([^\[]+)\[([a-z]+):([a-z0-9]+)(:[^\]]+)?]/;
        if (r.test(value)) {
            var m = value.match(r);
            var id = m[3];
            var region = m[4] || '';
            value = m[1] + '[' + m[2].slice(0, 1) + ':' + id.slice(-3) + (region ? ':' + region.slice(1) : '') + ']';
        }
        return value;
    };
});