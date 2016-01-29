<jsp:include page="userHeader.jsp"/>
<script src="//d3js.org/d3.v3.min.js" charset="utf-8"></script>
<style>
    path { 
    stroke: steelblue;
    stroke-width: 2;
    fill: none;
}

.axis path,
.axis line {
    fill: none;
    stroke: grey;
    stroke-width: 1;
    shape-rendering: crispEdges;
}
</style>
<div class="wrapper col3">
  <div id="container">
      <h1>Average annual spend per head of cattle by county</h1>
      <svg id="visualisation" width="1000" height="500"></svg>
      <script type="text/javascript">
          function initChart(){
              
              var data = [{
                        "cost": "202",
                        "county": "2000"
                    }, {
                        "cost": "215",
                        "county": "2002"
                    }, {
                        "sale": "179",
                        "year": "2004"
                    }, {
                        "sale": "199",
                        "year": "2006"
                    }, {
                        "sale": "134",
                        "year": "2008"
                    }, {
                        "sale": "176",
                        "year": "2010"
                    }];
                    var data2 = [{
                        "sale": "152",
                        "year": "2000"
                    }, {
                        "sale": "189",
                        "year": "2002"
                    }, {
                        "sale": "179",
                        "year": "2004"
                    }, {
                        "sale": "199",
                        "year": "2006"
                    }, {
                        "sale": "134",
                        "year": "2008"
                    }, {
                        "sale": "176",
                        "year": "2010"
                    }];
              
              var vis = d3.select("#visualisation"),
                        WIDTH = 1000,
                        HEIGHT = 500,
                        MARGINS = {
                            top: 20,
                            right: 20,
                            bottom: 20,
                            left: 50
                        },
                        yScale = d3.scale.linear().range([HEIGHT - MARGINS.top, MARGINS.bottom]).domain([134, 215]),
                        xAxis = d3.svg.axis()
                        .tickValues(["Clare","Limerick","Galway","Tipperary"]),
                        yAxis = d3.svg.axis()
                        .scale(yScale)
                        .orient("left");
                
                vis.append("svg:g")
                        .attr("class", "x axis")
                        .attr("transform", "translate(0," + (HEIGHT - MARGINS.bottom) + ")")
                        .call(xAxis);
                    vis.append("svg:g")
                        .attr("class", "y axis")
                        .attr("transform", "translate(" + (MARGINS.left) + ",0)")
                        .call(yAxis);
                    var lineGen = d3.svg.line()
                        .x(function(d) {
                            return xScale(d.year);
                        })
                        .y(function(d) {
                            return yScale(d.sale);
                        })
                        .interpolate("basis");
                    vis.append('svg:path')
                        .attr('d', lineGen(data))
                        .attr('stroke', 'green')
                        .attr('stroke-width', 2)
                        .attr('fill', 'none');
                    vis.append('svg:path')
                        .attr('d', lineGen(data2))
                        .attr('stroke', 'blue')
                        .attr('stroke-width', 2)
                        .attr('fill', 'none');
        }
               initChart() ;
       </script>
    <div id="content">
  </div>
</div>
</div>
<jsp:include page="userFooter.jsp"/>