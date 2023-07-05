;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 895)
(include sci.sh)
(use Main)
(use Grooper)
(use User)
(use Actor)

(public
	Body 0
)

(local
	[local0 24] = [6 0 4 5 1 7 4 2 5 7 3 6 0 4 2 2 5 1 3 6 0 1 7 3]
	local24 = 3
	[local25 75] = [0 -1 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 1 0 0 0 0 0 0 0 1]
	[local100 75] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 1 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 4 0 0 1 1 0 0 0 0 0 0 0 0 -1 0 0 0 0 -1 0 0 0 0 0 0]
)

(class Body of Ego
	(properties
		head 0
		normal 1
		moveHead 1
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(cond
			((self isStopped:)
				(if
					(and
						(!=
							(= temp0 (self loop:))
							(= temp1 (- (NumLoops self) 1))
						)
						(gCast contains: self)
						(IsObject (self cycler:))
						(not ((self cycler:) isKindOf: Grycler))
						(self normal:)
					)
					(self loop: temp1 cel: temp0)
				)
			)
			(
				(and
					(== (self loop:) (- (NumLoops self) 1))
					(not (& signal $0800))
				)
				(self loop: (self cel:))
			)
		)
	)

	(method (hide)
		(if head
			(head hide:)
		)
		(super hide:)
	)

	(method (dispose)
		(if head
			(head dispose:)
		)
		(super dispose:)
	)

	(method (stopUpd)
		(if head
			(head stopUpd:)
		)
		(super stopUpd:)
	)
)

(class Head of Prop
	(properties
		client 0
		cnt 0
		offSet 0
		xOffset 0
		yOffset 0
		rand 0
	)

	(method (init param1)
		(self view: (param1 view:) client: param1 ignoreActors: 1)
		(= loop (- (NumLoops self) 2))
		(param1 head: self)
		(super init:)
		(self hide: signal: (| (self signal:) $0010))
	)

	(method (doit)
		(cond
			(
				(and
					(client normal:)
					(not (& (client signal:) $0008))
					(client isStopped:)
					(== (client loop:) (- (NumLoops client) 1))
				)
				(if (and (& signal $0004) (not (& signal $0002)))
					(if (& (client signal:) $0004)
						(return)
					else
						(self startUpd:)
					)
				)
				(self showSelf:)
			)
			((not (& signal $0008))
				(self hide:)
			)
		)
		(super doit:)
	)

	(method (showSelf &tmp temp0 temp1)
		(= temp1 0)
		(if (& signal $0008)
			(= cel (client cel:))
			(= rand 0)
			(= offSet (+ (* (client cel:) 3) 1))
			(= cnt cycleSpeed)
		)
		(if (and (< (-- cnt) 1) (client moveHead:) (!= (NumLoops self) 6))
			(= cnt cycleSpeed)
			(= cel [local0 (+ offSet (= rand (- (Random 0 2) 1)))])
		)
		(for ((= temp0 0)) (< temp0 (* 25 local24)) ((+= temp0 25))
			(if (== (client view:) [local25 temp0])
				(= temp1 1)
				(break)
			)
		)
		(if temp1
			(= xOffset [local25 (+ 1 temp0 offSet rand)])
			(= yOffset [local100 (+ 1 temp0 offSet rand)])
		else
			(= xOffset (= yOffset 0))
		)
		(self view: (client view:) priority: (client priority:))
		(self
			loop: (- (NumLoops self) 2)
			x: (+ (client x:) xOffset)
			y: (client y:)
			z: (+ (CelHigh view (client loop:) (client cel:)) yOffset)
			show:
		)
	)
)

