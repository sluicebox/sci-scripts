;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use StopWalk)
(use User)
(use Actor)

(local
	[headCel 8] = [0 4 2 5 1 7 3 6]
)

(class LLEgo of Ego
	(properties
		_head 0
		normal 1
		moveHead 1
	)

	(method (headView theView)
		(_head view: theView)
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

	(method (egoSpeed num)
		(if argc
			(self cycleSpeed: num moveSpeed: num)
		else
			(self cycleSpeed: gLarrySpeed moveSpeed: gLarrySpeed)
		)
	)

	(method (userSpeed)
		(self
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
		)
	)
)

(class Head of Prop
	(properties
		client 0
		_cnt 0
		_offSet 0
	)

	(method (init owner)
		(self client: owner ignoreActors: 1)
		(= loop (- (NumLoops self) 1))
		(owner _head: self)
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

	(method (showSelf &tmp i)
		(if (& signal $0008)
			(self cel: (client loop:))
			(= _cnt cycleSpeed)
			(for ((= i 0)) (<= i 7) ((++ i))
				(if (== cel [headCel i])
					(= _offSet i)
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

	(method (lookAround &tmp i)
		(if (and (client moveHead:) (< (-- _cnt) 1))
			(= _cnt cycleSpeed)
			(if (> (= i (+ _offSet (- (Random 0 2) 1))) 7)
				(= i 0)
			)
			(if (< i 0)
				(= i 7)
			)
			(= cel [headCel i])
		)
	)
)

