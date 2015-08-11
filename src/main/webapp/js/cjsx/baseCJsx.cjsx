base.MulitLine = React.createClass
	render: ->
		sarray = @props.value.split "\n";
		lines = sarray.map((line,i) ->
				if (i == 0)
					return <span key={i}>{line}</span>;
				else
					return <span  key={i}><br/>{line}</span>;
			,this);

		<div>
		{lines}
		</div>

base.Alert = React.createClass
	mixins: [ReactBootstrap.OverlayMixin]

	render: ->
			<span/>

	renderOverlay: ->
		if (!@props.isShow)
			return <span/>;

		<ReactBootstrap.Modal onRequestHide={ -> } className="alert">
			<div className="modal-body"><base.MulitLine value={@props.message} />

			</div>
			<div className="modal-footer">
			<ReactBootstrap.Button bsStyle="primary" onClick={@props.onClick} name="alert#CloseBtn">了解</ReactBootstrap.Button>
			</div>
		</ReactBootstrap.Modal>

base.DeleteConfirm = React.createClass
	mixins: [ReactBootstrap.OverlayMixin]
	render: -> <span/>

	renderOverlay: ->
		if (!@props.isShow)
			return <span/>;

		<ReactBootstrap.Modal onRequestHide={ -> } className="deleteCfm">
			<div className="modal-body">削除してよいですね
			 </div>
			<div className="modal-footer">
			<ReactBootstrap.Button bsStyle="primary" onClick={@props.onClick} name="deleteCfm#YesBtn">YES</ReactBootstrap.Button>
			<ReactBootstrap.Button bsStyle="primary" onClick={@props.onClick} name="deleteCfm#CloseBtn">NO</ReactBootstrap.Button>
			</div>
		</ReactBootstrap.Modal>

base.Loader = React.createClass
	render: ->
		if (@props.isLoading==false)
			<span/>;
		else
			 <img src={@props.src} style={{margin:10}}/>;

base.SelectOption = React.createClass
	handleChange: (e) ->
		@props.onChange(e);

	render: ->
		options = @props.options.map((opt, i) ->
			<option key={i} value={opt.value} label={opt.label}>{opt.label}</option>;
		, this);

		<ReactBootstrap.Input type="select" label='' 
				defaultValue={@props.defaultValue} 
				multiple={@props.multiple}
				name={@props.name} style={@props.style}
				onChange={@handleChange}
				>
				{options}
		</ReactBootstrap.Input>

