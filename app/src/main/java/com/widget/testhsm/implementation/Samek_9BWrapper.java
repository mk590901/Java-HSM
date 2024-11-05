package com.widget.testhsm.implementation;

import com.widget.testhsm.hsm.QEvent;
import com.widget.testhsm.interfaces.IHsm;
import com.widget.testhsm.interfaces.IMediator;

public class Samek_9BWrapper extends IHsm {
	private IMediator mediator_;
	private Samek_9BQHsmScheme entity_;

	public Samek_9BWrapper(Samek_9BQHsmScheme entity, IMediator mediator) {
		entity_ = entity;
		mediator_	= mediator;
		mediator_.SetHsm(this);
	}
	@Override
	public IMediator Mediator() { return mediator_; }

	@Override
	public void SetMediator(IMediator mediator) { mediator_ = mediator; }

	@Override
	public void Init() {
		entity_.init(new QEvent(Samek_9BQHsmScheme.INIT));
	}
	@Override
	public void Dispatch(QEvent event) {
		entity_.dispatch(event);
	}
}

