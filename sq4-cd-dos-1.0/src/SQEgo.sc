;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use StopWalk)
(use Ego)
(use Actor)

(local
	[local0 8] = [0 4 2 5 1 7 3 6]
)

(class SQEgo of Ego
	(properties
		view 0
		_head 0
		normal 1
		moveHead 1
	)

	(method (init)
		(super init:)
	)

	(method (headView param1)
		(_head view: param1)
		(if (not (& (_head signal:) $0008))
			(_head showSelf:)
		)
	)

	(method (hide)
		(if _head
			(_head hide:)
		)
		(super hide:)
	)

	(method (dispose)
		(if _head
			(_head dispose:)
		)
		(super dispose:)
	)

	(method (stopUpd)
		(if _head
			(_head stopUpd:)
		)
		(super stopUpd:)
	)
)

(class Head of Prop
	(properties
		client 0
		_cnt 0
		_offSet 0
	)

	(method (init param1)
		(self client: param1 ignoreActors: 1)
		(= loop (- (NumLoops self) 1))
		(param1 _head: self)
		(super init:)
		(self hide:)
	)

	(method (doit)
		(cond
			(
				(and
					(client normal:)
					(not (& (client signal:) $0008))
					(client isStopped:)
					(IsObject (client cycler:))
					((client cycler:) isKindOf: StopWalk)
					(== (client view:) ((client cycler:) vStopped:))
				)
				(if (and (& signal $0004) (not (& signal $0002)))
					(if (& (client signal:) $0004)
						(return)
					else
						(self startUpd:)
					)
				)
				(self showSelf:)
				(self lookAround:)
			)
			((not (& signal $0008))
				(self hide:)
			)
		)
		(super doit:)
	)

	(method (showSelf &tmp temp0)
		(if (& signal $0008)
			(self cel: (client loop:))
			(= _cnt cycleSpeed)
			(for ((= temp0 0)) (<= temp0 7) ((++ temp0))
				(if (== cel [local0 temp0])
					(= _offSet temp0)
				)
			)
		)
		(self
			setPri: (client priority:)
			loop: (- (NumLoops self) 1)
			x: (client x:)
			y: (client y:)
			z: (CelHigh view (client loop:) (client cel:))
			show:
		)
	)

	(method (lookAround &tmp temp0)
		(if (and (client moveHead:) (< (-- _cnt) 1))
			(= _cnt cycleSpeed)
			(if (> (= temp0 (+ _offSet (- (Random 0 2) 1))) 7)
				(= temp0 0)
			)
			(if (< temp0 0)
				(= temp0 7)
			)
			(= cel [local0 temp0])
		)
	)
)

