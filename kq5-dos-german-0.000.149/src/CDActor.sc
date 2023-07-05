;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 931)
(include sci.sh)
(use Main)
(use Timer)
(use User)
(use Actor)
(use System)

(class MyLooper of Code
	(properties)

	(method (doit param1 param2)
		(proc0_24 param1 param2)
	)
)

(class Head of Prop
	(properties
		cycleSpeed 6
		syncMouth 0
		client 0
		cycleCnt 0
		moveHead 1
		headCel {15372406}
	)

	(method (show)
		(self look:)
		(super show: &rest)
	)

	(method (init param1)
		(= view (param1 view:))
		(= loop (- (NumLoops param1) 4))
		(self
			client: param1
			ignoreActors: 1
			posn:
				(param1 x:)
				(param1 y:)
				(CelHigh view (param1 loop:) (param1 cel:))
		)
		(param1 head: self)
		(super init:)
		(if moveHead
			(self cue: look:)
		)
	)

	(method (cue)
		(if (and (not (gCurRoom script:)) moveHead (not (client mover:)))
			(client look: (- (Random 0 2) 1))
			(self look:)
		)
		(Timer set60ths: self (Random 60 150))
	)

	(method (doit)
		(= x (client x:))
		(= y (client y:))
		(= z (CelHigh (client view:) (client loop:) (client cel:)))
		(if (and moveHead (!= view (client view:)))
			(= view (client view:))
			(= loop (- (NumLoops client) 4))
		)
		(super doit:)
	)

	(method (look &tmp temp0 temp1)
		(if (== (= temp0 (client loop:)) (- (NumLoops client) 1))
			(= temp0 (client cel:))
			(= temp1 (client lookingDir:))
		else
			(= temp1 0)
		)
		(= cel (+ (& (StrAt headCel temp0) $000f) temp1))
	)
)

(class CDActor of Actor
	(properties
		head 0
		gesture 0
		oldScript 0
		caller 0
		lookingDir 0
	)

	(method (init param1)
		(super init:)
		(self head: 0 gesture: (if argc param1 else 0))
	)

	(method (cue)
		(if head
			(head setCel: 0 syncMouth: 0 setCycle: 0)
		)
		(if gesture
			(self setScript: oldScript)
		)
		(if caller
			(caller cue:)
		)
	)
)

(class Body of Ego
	(properties
		head 0
		caller 0
		lookingDir 1
		normal 1
	)

	(method (init)
		(super init:)
		(if (not (IsObject head))
			((= head (Head new:)) init: self)
		)
		(= looper MyLooper)
	)

	(method (look param1)
		(= lookingDir param1)
	)

	(method (cue)
		(if (IsObject head)
			(head setCel: 0 syncMouth: 0 setCycle: 0)
		)
		(if caller
			(caller cue:)
		)
	)

	(method (dispose)
		(= head 0)
		(super dispose:)
	)

	(method (posn param1 param2)
		(super posn: param1 param2 &rest)
		(if (IsObject head)
			(head doit:)
		)
	)

	(method (setPri)
		(super setPri: &rest)
		(if (IsObject head)
			(head setPri: &rest)
		)
	)

	(method (setHeading)
		(super setHeading: &rest)
		(if (IsObject head)
			(head cel: (& (StrAt (head headCel:) loop) $000f))
		)
	)
)

