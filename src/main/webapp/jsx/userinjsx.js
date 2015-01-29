 var b = ReactBootstrap;
$w.LoginRows = React.createClass({
    render: function() {
        $w.loginRows = this;
        var rows = this.props.rcds.map(function(rcd, i){
        var bgcolor=""; 
        if (i==this.props.selRow) {
          bgcolor="#d9edf7";
          return (
            <tr key={i} draggable="true" onDragOver={this.props.onDragOver}
            onDragStart={this.props.onDragStart} onDrop={this.props.onDrop} 
            id={"row#"+i}>
           
            <td style={{width:this.props.cw.c1,backgroundColor:bgcolor,padding:0,margin:0}}>
             <b.Input type="text" value={rcd.loginId}  name={"loginrow#loginId#"+i}
                  ref={"loginrow#loginId#"+i} 
                  onChange={this.props.onChange} onKeyDown={this.props.onKeyDown}
                  style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
            </td>
            <td style={{width:this.props.cw.c2,backgroundColor:bgcolor,padding:0,margin:0}}>
              <b.Input type="text" value={rcd.name} name={"loginrow#name#"+i} 
                  ref={"loginrow#name#"+i} 
                  onChange={this.props.onChange} onKeyDown={this.props.onKeyDown}
                  style={{height:20,fontSize:12,width:"100%",padding:0,margin:0}}/>
            </td>
            <td id={"loginrow#lid#"+i} 
                style={{width:this.props.cw.c3,backgroundColor:bgcolor,
                textAlign:"right"}}>{rcd.id}</td>
            <td id={"loginrow#versionNo#"+i} 
                style={{width:this.props.cw.c4,backgroundColor:bgcolor,
                textAlign:"right"}}>{rcd.versionNo}</td>
           </tr>
        )
          }
        else
          if (i%2 == 1)
            bgcolor="#F8F8F8";
          else
            bgcolor="#FFFFFF";
        return (
          <tr key={i} draggable="true" onDragOver={this.props.onDragOver}
            onDragStart={this.props.onDragStart} onDrop={this.props.onDrop}
            id={"row#"+i}>
          <td id={"loginrow#loginId#"+i} style={{width:this.props.cw.c1,backgroundColor:bgcolor}}>{rcd.loginId}</td>
          <td id={"loginrow#name#"+i} style={{width:this.props.cw.c2,backgroundColor:bgcolor}}>{rcd.name}</td>
          <td id={"loginrow#lid#"+i} style={{width:this.props.cw.c3,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.id}</td>
          <td id={"loginrow#versionNo#"+i} style={{width:this.props.cw.c4,backgroundColor:bgcolor,textAlign:"right"}}>{rcd.versionNo}</td>
         </tr>
        )
        }, this);
          return ( 
            <tbody style={{overflowY:"auto",height:92}}>
                {rows}
            </tbody>
          );
    }
  });
$w.Application = React.createClass({
  mixins: [$w.FluxMixin, $w.StoreWatchMixin("PAGE","COMMON","RCD")],
  getInitialState: function() {
  $w.application = this
      return {
                user:$c.login.name,
                search:{
                  loginId:"starts with",
                  loginId_s:"",
                  loginId_e:"",
                  name:"starts with",
                  name_s:"",
                  name_e:""
                },
                login:{
                  url:"/ajax/login",
                  cw:{c1:100,c2:150,c3:60,c4:60},
                  rcds:[],
                  blank:{
                    loginId:"",
                    name:"",
                    id:"",
                    versionNo:"",
                    password:"",
                    passwordcfm:""
                    
                  },
                  selRow:-1
                },
                form:{
                    loginId:"",
                    name:"",
                    id:"",
                    versionNo:"",
                    password:"",
                    passwordcfm:""
                  }

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
          style={{fontSize:12,border:1,borderStyle:"solid",width:800,height:600,backgroundColor: "#F0F0F0"}}>

      <b.Row className="darkBgLarge" 
          style={{margin:0,height:40,lineHeight:"40px",verticalAlign: "middle"}}>
        <b.Col xs={5} style={{textAlign: "center"}}>USER管理
        </b.Col>
        <b.Col xs={5} className="darkBgMid" style={{textAlign: "center"}}>
        {this.state.user}
        </b.Col>
        <b.Col xs={1} className="darkBgMid" >
        </b.Col>
         <b.Col xs={1} >
        <$c.Loader src="../img/ajax-loader.gif" isLoading={this.state.common.loading}/>
        </b.Col>
      </b.Row>
      <b.Row style={{margin:5}}>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick} 
            name="btnSearch" style={{width:60,marginLeft:10}}>検索</b.Button>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
         <b.Col xs={1} style={{textAlign: "right"}}>Login ID
          </b.Col>
          <b.Col xs={2} >
          <$c.SelectOption options={$c.stringOption} style={{height:24,  fontSize:12}}
               name={"search#loginId"}
              defaultValue={this.state.search.loginId} onChange={this.handleChange} />
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.loginId_s} 
            name="search#loginId_s" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.loginId_e} 
            name="search#loginId_e" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <b.Row　style={{verticalAlign:"middle", lineHeight:"26px",marginLeft:0}}>
         <b.Col xs={1} style={{textAlign: "right"}}>氏名
          </b.Col>
          <b.Col xs={2} >
          <$c.SelectOption options={$c.stringOption} 
              style={{height:24,  fontSize:12}} name={"search#name"}
              defaultValue={this.state.search.name} onChange={this.handleChange} />
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.name_s} 
            name="search#name_s" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
          <b.Col xs={3}>
          <b.Input type="text" value={this.state.search.name_e} 
            name="search#name_e" onChange={this.handleChange} 
            style={{height:24,fontSize:12,width:"100%"}}/>
          </b.Col>
      </b.Row>
      <b.Row style={{margin:5}}>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick} 
            name="btnUpdate" style={{width:60,marginLeft:10}}>更新</b.Button>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick} 
            name="btnDelete" style={{width:60,marginLeft:10}}>削除</b.Button>
        <b.Button bsSize="xsmall" bsStyle="primary" onClick={this.handleClick}
            name="btnCancel" style={{width:60,marginLeft:10}}>取消</b.Button>
      </b.Row>
      <div style={{width:400,border:1,borderStyle:"solid",
          borderColor:"black",height:120,backgroundColor: "#FFFFFF"}}>
      <b.Table bordered condensed className="wscrolltable" 
          style={{width:"100%",height:"100%"}}
      onClick={this.handleClick}>
       <thead>
        <tr >
          <th　style={{width:this.state.login.cw.c1}}>Login Id</th>
          <th style={{width:this.state.login.cw.c2}}>氏名</th>
          <th　style={{width:this.state.login.cw.c3}}>id</th>
          <th style={{width:this.state.login.cw.c4}}>versionNo</th>
        </tr>
      </thead>
      <$w.LoginRows rcds={this.state.login.rcds} cw={this.state.login.cw}
          selRow={this.state.login.selRow} onChange={this.handleChange}
          onKeyDown={this.handleRowKeyDown} onDragStart={this.dragStart}
          onDrop={this.drop} onDragOver={this.dragOver}/>
      </b.Table>
      </div>

      <$c.Alert isShow={this.state.common.alert.isShow} 
          message={this.state.common.alert.message} onClick={this.handleClick} />
      <$c.DeleteConfirm isShow={this.state.common.deleteCfm.isShow}
          onClick={this.handleClick}/>
      </div>
    );
  },
  componentDidMount: function() {
  },
  handleChange: function (e) {
    $w.handleChange(this,e);
  },
  handleClick: function (e) {
    $w.handleClick(this,e);
  },
  handleRowKeyDown: function (e) {
    $w.handleRowKeyDown(this,e);
  },
  dragStart:function (e) {
    e.dataTransfer.setData("text", e.target.id);
  },
  drop:function (e) {
    e.preventDefault();
    var from = e.dataTransfer.getData("text");
    var to=e.target.id;
    $w.drop(this,from,to)
  },
  dragOver:function (e) {
    e.preventDefault()
  },
});

React.render(<$w.Application flux={$w.flux}/>, document.getElementById('content'));