;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)
(use SyncStop)
(use StopWalk)
(use User)
(use Actor)
(use System)

(local
	[local0 8] = [0 4 6 2 7 5 1 3]
)

(class rhEgo of Ego
	(properties
		_head 0
		normal 1
		moveHead 1
		beard 0
		abnormal 1
	)

	(method (setCel param1)
		(= cel
			(if (>= param1 (self lastCel:))
				(self lastCel:)
			else
				param1
			)
		)
	)

	(method (setLoop param1 &tmp temp0)
		(if
			(= temp0
				(cond
					((== argc 0)
						(|= signal $0800)
						0
					)
					((== param1 -1)
						(&= signal $f7ff)
						0
					)
					((not (IsObject param1))
						(= loop param1)
						(|= signal $0800)
						0
					)
					((& (param1 -info-:) $8000)
						(param1 new:)
					)
					(else param1)
				)
			)
			(if looper
				(looper dispose:)
			)
			((= looper temp0) init: self &rest)
		)
	)

	(method (setPri param1)
		(cond
			((== argc 0)
				(|= signal $0010)
				(_head setPri:)
			)
			((== param1 -1)
				(&= signal $ffef)
				(_head setPri: -1)
			)
			(else
				(= priority param1)
				(|= signal $0010)
				(_head setPri: param1)
			)
		)
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
		(if beard
			(beard hide:)
		)
		(super hide:)
	)

	(method (dispose)
		(if _head
			(_head dispose:)
		)
		(if beard
			(beard dispose:)
		)
		(super dispose:)
	)

	(method (egoSpeed param1)
		(if argc
			(self cycleSpeed: param1 moveSpeed: param1)
		else
			(self cycleSpeed: global141 moveSpeed: global141)
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
		cycleSpeed 180
		client 0
		_cnt 0
	)

	(method (init param1)
		(self client: param1 ignoreActors: 1)
		(param1 _head: self)
		(super init:)
		(self hide:)
	)

	(method (doVerb theVerb invItem)
		(if
			(not
				(and
					client
					(IsObject (client actions:))
					((client actions:) doVerb: theVerb invItem &rest)
				)
			)
			(client doVerb: theVerb invItem &rest)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(client normal:)
					(not (& (client signal:) $0008))
					(client isStopped:)
					(IsObject (client cycler:))
					(or
						((client cycler:) isKindOf: StopWalk)
						((client cycler:) isKindOf: SyncStop)
					)
					(== (client view:) ((client cycler:) vStopped:))
				)
				(if (and (& signal $0004) (not (& signal $0002)))
					(if (& (client signal:) $0004)
						(super doit:)
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
			(= cel [local0 (client loop:)])
			(= _cnt cycleSpeed)
			(self show:)
		)
		(self x: (client x:) y: (client y:))
	)

	(method (normalize)
		(self
			view:
				(if (OneOf (gEgo view:) 1 13 30 34 24 17 703)
					(gEgo view:)
				else
					(+ (gEgo view:) 1)
				)
			loop:
				(cond
					((== gDisguiseNum 2) 9) ; jewler (no rouge)
					((== (gEgo view:) 702) 4)
					(else 8)
				)
			cel: [local0 (client loop:)]
			z:
				(switch gDisguiseNum
					(5 38) ; abbey monk
					(2 39) ; jewler (no rouge)
					(3 39) ; jewler (rouge)
					(else 40)
				)
		)
		(if (gCast contains: gEgo)
			(self doit:)
		)
	)

	(method (lookAround &tmp temp0)
		(if (and (client moveHead:) (< (-- _cnt) 1))
			(= _cnt cycleSpeed)
			(= cel (+ [local0 (client loop:)] (- (Random 0 2) 1)))
			(if (> cel 7)
				(= cel 0)
			)
			(if (< cel 0)
				(= cel 7)
			)
		)
	)
)

(class SpecialDoVerb of Code
	(properties)

	(method (doVerb theVerb invItem param3)
		(param3 doVerb: theVerb &rest)
	)
)

(class Beard of Prop
	(properties
		client 0
	)

	(method (init param1)
		(self client: param1 ignoreActors: 1)
		(param1 beard: self)
		(super init:)
		(self hide:)
	)

	(method (doit)
		(cond
			(
				(and
					(client abnormal:)
					(not (& (client signal:) $0008))
					(not (client isStopped:))
					(IsObject (client cycler:))
					(or
						((client cycler:) isKindOf: StopWalk)
						((client cycler:) isKindOf: SyncStop)
					)
					(not (== (client view:) ((client cycler:) vStopped:)))
				)
				(self showSelf:)
			)
			((not (& signal $0008))
				(self hide:)
			)
		)
		(super doit: &rest)
	)

	(method (showSelf)
		(self show:)
		(self
			loop: (client loop:)
			cel: (client cel:)
			x: (client x:)
			y: (client y:)
		)
	)
)

