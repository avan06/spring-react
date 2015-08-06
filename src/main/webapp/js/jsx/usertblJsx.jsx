 var b = ReactBootstrap;
$w.width=900;
$w.height=800;
$w.tableHeight=340;
$w.tableColW={c1:140,c2:130,c3:130,c4:150,c5:150,c6:150,
                    c7:60,c8:60,c9:60,c10:60,c11:60}
$w.UsertblRows = React.createClass({

    render: function() {
        var rows = this.props.rcds.map(function(rcd, i){
        var bgcolor="";
        if (i==this.props.selRow)
          bgcolor="#d9edf7";
        else
          if (i%2 == 1)
            bgcolor="#F8F8F8";
          else
            bgcolor="#FFFFFF";
        return (
          <tr key={i} >
          <td id={"row#tableName#"+i} 
            style={{width:this.props.cw.c1,backgroundColor:bgcolor}}>{rcd.tableName}</td>
          <td id={"row#key1#"+i} 
            style={{width:this.props.cw.c2,backgroundColor:bgcolor}}>{rcd.key1}</td>
          <td id={"row#key2#"+i} 
            style={{width:this.props.cw.c3,backgroundColor:bgcolor}}>{rcd.key2}</td>
          <td id={"row#s1Data#"+i} 
          style={{width:this.props.cw.c4,backgroundColor:bgcolor}}>{rcd.s1Data}</td>
          <td id={"row#s2Data#"+i} 
          style={{width:this.props.cw.c5,backgroundColor:bgcolor}}>{rcd.s2Data}</td>
          <td id={"row#s3Data#"+i} 
          style={{width:this.props.cw.c6,backgroundColor:bgcolor}}>{rcd.s3Data}</td>
          <td id={"row#n1Data#"+i} 
          style={{width:this.props.cw.c7,backgroundColor:bgcolor,textAlign:"right"}}>
            {rcd.n1Data}</td>
          <td id={"row#n2Data#"+i} 
          style={{width:this.props.cw.c8,backgroundColor:bgcolor,textAlign:"right"}}>
            {rcd.n2Data}</td>
          <td id={"row#n3Data#"+i} 
          style={{width:this.props.cw.c9,backgroundColor:bgcolor,textAlign:"right"}}>
            {rcd.n3Data}</td>
          <td id={"row#vid#"+i} 
          style={{width:this.props.cw.c10,backgroundColor:bgcolor,textAlign:"right"}}>
            {rcd.id}</td>
          <td id={"row#versionNo#"+i} 
          style={{width:this.props.cw.c11,backgroundColor:bgcolor,textAlign:"right"}}>
            {rcd.versionNo}</td>
         </tr>
        )
        }, this);
          return ( 
            <tbody>
                {rows}
            </tbody>
          );
    }
  });
$w.Application = React.createClass({
  mixins: [$w.FluxMixin, $w.StoreWatchMixin("PAGE","COMMON","RCD")],
  getInitialState: function() {
  $w.application = this;
  blank={
          tableName:"",
          key1:"",
          key2:"",
          s1Data:"",
          s2Data:"",
          s3Data:"",
          n1Data:"",
          n2Data:"",
          n3Data:"",
          id:"",
          versionNo:""   
  };
      return {
                user:base.login.name,
                search:{
                  tableName:"starts with",
                  tableName_s:"",
                  tableName_e:"",
                  key1:"starts with",
                  key1_s:"",
                  key1_e:"",
                  maxRecord:"300"
                },
                usertbl:{
                  url:"/ajax/usertbl",
                  cw:$w.tableColW,
                  totalW:base.totalW($w.tableColW)+2,
                  rcds:[],
                  blank:_.cloneDeep(blank), 
                  selRow:-1
                },
                form:_.cloneDeep(blank)
              };
  },
  getStateFromFlux: function() {
    //this.props.flux=$w.flux;
    var pageStore = $w.flux.stores.PAGE;
    var commonStore = $w.flux.stores.COMMON;
    var rcdStore = $w.flux.stores.RCD;
    return {
      page: _.cloneDeep(pageStore.data),
      common:_.cloneDeep(commonStore.data),
      rcd:_.cloneDeep(rcdStore.data)
      };
  },
  render: function() {
    return (
      <div className="container-fixed" 
          style={{fontSize:12,border:1,borderStyle:"solid",
            width:$w.width,height:$w.height,backgroundColor: "#F0F0F0"}}>
      <b.Row className="darkBgLarge" 
          style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
        <b.Col xs={5} style={{textAlign: "center"}}>ユーザーテーブル管理
        </b.Col>
        <b.Col xs={5} className="darkBgMid" style={{textAlign: "center"}}>
        {this.state.user}
        </b.Col>
        <b.Col xs={1} className="darkBgMid" >
        </b.Col>
         <b.Col xs={1} >
        <base.Loader src="./img/ajax-loader.gif" isLoading={this.state.common.loading}/>
        </b.Col>
      </b.Row>
      <b.Row style={{margin:5}}>
      <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick} 
        name="btnSearch" style={{width:60,marginLeft:10}}>検索</b.Button>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
         <b.Col xs={1} style={{textAlign: "right"}}>tableName
          </b.Col>
          <b.Col xs={2} >
          <base.SelectOption options={base.stringOption} style={{height:24,  fontSize:12}}
               name={"search#tableName"}
              defaultValue={this.state.search.tableName} onChange={this.handleChange} />
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.tableName_s} 
            name="search#tableName_s" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.tableName_e} 
            name="search#tableName_e" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>MaxRecord
          </b.Col>
          <b.Col xs={1} >
            <b.Input type="text" value={this.state.search.maxRecord} 
            name="search#names" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
         <b.Col xs={1} style={{textAlign: "right"}}>key1
          </b.Col>
          <b.Col xs={2} >
          <base.SelectOption options={base.stringOption} 
              style={{height:24,  fontSize:12}} name={"search#key1"}
              defaultValue={this.state.search.key1} onChange={this.handleChange} />
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.key1_s} 
            name="search#key1_s" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.key1_e} 
            name="search#key1_e" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <div style={{width:$w.width-2,border:1,borderStyle:"solid",
          borderColor:"black",height:$w.tableHeight,backgroundColor: "#FFFFFF"}}>
      <div ref="tableHead"  
          style={{width:$w.width-20,height:20,overflowX:"hidden",overflowY:"hidden"}}>
      <b.Table bordered condensed className="wscrolltable" >
       <thead style={{width:this.state.usertbl.totalW,overflowX:"hidden",overflowY:"hidden"}}>
        <tr >
          <th　style={{width:this.state.usertbl.cw.c1}}>tableName</th>
          <th style={{width:this.state.usertbl.cw.c2}}>key1</th>
          <th　style={{width:this.state.usertbl.cw.c3}}>key2</th>
          <th style={{width:this.state.usertbl.cw.c4}}>s1Data</th>
          <th style={{width:this.state.usertbl.cw.c5}}>s2Data</th>
          <th style={{width:this.state.usertbl.cw.c6}}>s3Data</th>
          <th style={{width:this.state.usertbl.cw.c7}}>n1Data</th>
          <th style={{width:this.state.usertbl.cw.c8}}>n2Data</th>
          <th style={{width:this.state.usertbl.cw.c9}}>n3Data</th>
          <th　style={{width:this.state.usertbl.cw.c10}}>id</th>
          <th style={{width:this.state.usertbl.cw.c11}}>versionNo</th>
        </tr>
      </thead>
      </b.Table>
       </div>
      <div ref="tableBody" 
        style={{width:$w.width-4,height:$w.tableHeight-22,overflowX:"scroll",overflowY:"scroll"}}>
      <div style={{width:this.state.usertbl.totalW,overflowX:"hidden",overflowY:"hidden"}}>
      <b.Table bordered condensed className="wscrolltable" 
       onClick={this.handleClick}>   
      <$w.UsertblRows rcds={this.state.usertbl.rcds} cw={this.state.usertbl.cw}
          selRow={this.state.usertbl.selRow}/>
      </b.Table>
      </div>
      </div>
      </div>
      <b.Row style={{margin:5}}>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick}
            name="btnNew" style={{width:60,marginLeft:10}}>新規</b.Button>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick} 
            name="btnUpdate" style={{width:60,marginLeft:10}}>更新</b.Button>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick} 
            name="btnDelete" style={{width:60,marginLeft:10}}>削除</b.Button>

      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
         <b.Col xs={1} style={{textAlign: "right"}}>tableName
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.tableName} 
            name="form#tableName" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>key1
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.key1} 
            name="form#key1" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>key2
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.key2} 
            name="form#key2" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
         <b.Col xs={1} style={{textAlign: "right"}}>s1Data
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.s1Data} 
            name="form#s1Data" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>s2Data
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.s2Data} 
            name="form#s2Data" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>s3Data
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.s3Data} 
            name="form#s3Data" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
         <b.Col xs={1} style={{textAlign: "right"}}>n1Data
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.n1Data} 
            name="form#n1Data" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>n2Data
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.n2Data} 
            name="form#n2Data" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={1} style={{textAlign: "right"}}>n3Data
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.form.n3Data} 
            name="form#n3Data" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0,marginRight:5}}>
         <b.Col xs={1} style={{textAlign: "right"}}>id
          </b.Col>
          <b.Col xs={1}>
          <b.Input type="text" value={this.state.form.id} 
            name="form#id" onChange={this.handleChange} 
            disabled
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
         <b.Col xs={1} xsOffset={2} style={{textAlign: "right"}}>ver. No
          </b.Col>
          <b.Col xs={1}>
          <b.Input type="text" value={this.state.form.versionNo} 
            name="form#versionNo" onChange={this.handleChange} 
            disabled
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <base.Alert isShow={this.state.common.alert.isShow} 
          message={this.state.common.alert.message} onClick={this.handleClick} />
      <base.DeleteConfirm isShow={this.state.common.deleteCfm.isShow}
          onClick={this.handleClick}/>
      </div>
    );
  },
  componentDidMount: function() {
    $w.onscroll();
  },
  handleChange: function (e) {
    $w.handleChange(this,e);
  },
  handleClick: function (e) {
    $w.handleClick(this,e);
  }

});

React.render(<$w.Application flux={$w.flux}/>, document.getElementById('content'));