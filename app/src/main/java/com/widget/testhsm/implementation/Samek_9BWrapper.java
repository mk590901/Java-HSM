package com.widget.testhsm.implementation;

import com.widget.testhsm.hsm.QEvent;
import com.widget.testhsm.interfaces.IHsm;
import com.widget.testhsm.interfaces.IMediator;

public class Samek_9BWrapper implements IHsm {
	private IMediator mediator_;
	private Samek_9BQHsmScheme entity_;

	public Samek_9BWrapper(Samek_9BQHsmScheme entity, IMediator mediator) {
		entity_ = entity;
		mediator_	= mediator;
		mediator_.setHsm(this);
	}
	@Override
	public IMediator mediator() { return mediator_; }

	@Override
	public void setMediator(IMediator mediator) { mediator_ = mediator; }

	@Override
	public void init() {
		entity_.init(new QEvent(Samek_9BQHsmScheme.INIT));
	}
	@Override
	public void dispatch(QEvent event) {
		entity_.dispatch(event);
	}
}

