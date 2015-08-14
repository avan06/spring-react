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
	render: ->
		<ReactBootstrap.Modal bsSize="small" aria-labelledby='alertModal' show={@props.isShow} onHide={ -> } dialogClassName="alert">
			<ReactBootstrap.Modal.Body id='alertModal'><base.MulitLine value={@props.message} />
			</ReactBootstrap.Modal.Body>
			<ReactBootstrap.Modal.Footer>
				<ReactBootstrap.Button bsStyle="primary" onClick={@props.onClick} name="alert#CloseBtn">了解</ReactBootstrap.Button>
			</ReactBootstrap.Modal.Footer>
		</ReactBootstrap.Modal>

base.DeleteConfirm = React.createClass
	render: ->
		<ReactBootstrap.Modal bsSize="small" aria-labelledby='deleteCfmModal' show={@props.isShow} onHide={ -> } dialogClassName="deleteCfm">
			<ReactBootstrap.Modal.Body id='deleteCfmModal'>削除してよいですね
			</ReactBootstrap.Modal.Body>
			<ReactBootstrap.Modal.Footer>
				<ReactBootstrap.Button bsStyle="primary" onClick={@props.onClick} name="deleteCfm#YesBtn">YES</ReactBootstrap.Button>
				<ReactBootstrap.Button bsStyle="primary" onClick={@props.onClick} name="deleteCfm#CloseBtn">NO</ReactBootstrap.Button>
			</ReactBootstrap.Modal.Footer>
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

