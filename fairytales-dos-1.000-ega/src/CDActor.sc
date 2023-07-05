;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 931)
(include sci.sh)
(use Main)
(use Tactor)
(use Motion)
(use Actor)
(use System)

(class Head of Prop
	(properties
		cycleSpeed 42
		client 0
		cycleCnt 0
		moveHead 1
		headCel {15372406}
	)

	(method (init param1 &tmp temp0)
		(= view (param1 view:))
		(= loop 4)
		(self
			client: param1
			ignoreActors: 1
			posn:
				(param1 x:)
				(param1 y:)
				(CelHigh view (param1 loop:) (param1 cel:))
		)
		(= temp0 (== (client loop:) 5))
		(if (& (param1 signal:) $0010)
			(self setPri: (param1 priority:))
		)
		(param1 head: self)
		(super init:)
		(if (or (not temp0) (not (param1 normal:)))
			(self hide:)
		)
		(if moveHead
			(self cue: look:)
		)
	)

	(method (dispose)
		(if script
			(script caller: 0)
		)
		(super dispose:)
	)

	(method (cue &tmp temp0)
		(if (and (not (gCurRoom script:)) moveHead)
			(client look: (- (Random 0 2) 1))
		)
		(self setScript: (HeadScript new:) self)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (client normal:))
		(= temp0 (== (client loop:) 5))
		(cond
			((or (not temp1) (not temp0))
				(self hide:)
			)
			((and (& signal $0080) temp0)
				(self show:)
			)
			((and (not (& signal $0080)) (not (client isStopped:)))
				(self hide:)
			)
		)
		(if moveHead
			(self setPri: (client priority:) look:)
			(if (!= (self view:) (client view:))
				(self view: (client view:) loop: 4)
			)
			(= x (client x:))
			(= y (client y:))
			(= z (CelHigh (client view:) (client loop:) (client cel:)))
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

	(method (doVerb theVerb)
		(client doVerb: theVerb)
	)
)

(instance HeadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 60 150))
			)
			(1
				(self dispose:)
			)
		)
	)
)

(class Tail of Prop
	(properties
		cycleSpeed 42
		client 0
		cycleCnt 0
		moveTail 1
	)

	(method (init param1)
		(= view (param1 view:))
		(self client: param1 ignoreActors: 1 setCycle: Fwd)
		(if (& (param1 signal:) $0010)
			(self setPri: (param1 priority:))
		)
		(param1 head: self posnTail: self)
		(super init:)
	)

	(method (doit &tmp temp0)
		(if (!= view (client view:))
			(= view (client view:))
		)
		(cond
			((and (not (client normal:)) (not (& signal $0080)))
				(self hide:)
			)
			((and (not (& signal $0080)) (!= loop (+ (client cel:) 4)))
				(self hide:)
				(client posnTail: self)
			)
			((and (not (& signal $0080)) (not (client isStopped:)))
				(self hide:)
			)
			((and (& signal $0080) (client isStopped:) (client normal:))
				(client posnTail: self)
				(self show:)
			)
		)
		(if (and moveTail (not (& signal $0080)))
			(if (!= priority (= temp0 (client priority:)))
				(self setPri: (client priority:))
			)
			(switch (Random 0 18)
				(0
					(self setCel: (Random 0 (NumCels self)))
				)
			)
		)
		(super doit:)
	)
)

(class CDActor of Tactor
	(properties
		head 0
		lookingDir 1
		normal 1
		isAnimal 0
	)

	(method (init)
		(super init:)
		(if (not head)
			((= head ((if isAnimal Tail else Head) new:)) init: self)
		)
		(if (not normal)
			(head hide:)
		)
	)

	(method (look param1)
		(= lookingDir param1)
	)

	(method (cue)
		(if head
			(head setCel: 0 setCycle: 0)
		)
	)

	(method (dispose)
		(if head
			(head setCel: 0 setCycle: 0 dispose:)
			(= head 0)
		)
		(super dispose:)
	)
)

(class CDAnimal of CDActor
	(properties
		isAnimal 1
		animRightX 0
		animRightY 0
		animLeftX 0
		animLeftY 0
		animFrontX 0
		animFrontY 0
		animBackX 0
		animBackY 0
	)

	(method (posnTail param1)
		(param1 setLoop: (+ cel 4))
		(switch cel
			(0
				(param1 posn: (+ x animRightX) y (- animRightY))
			)
			(1
				(param1 posn: (+ x animLeftX) y (- animLeftY))
			)
			(2
				(param1 posn: (+ x animFrontX) (+ y animFrontY) 0)
			)
			(3
				(param1 posn: (+ x animBackX) y (- animBackY))
			)
		)
	)
)

(class Body of Tego
	(properties
		head 0
		caller 0
		lookingDir 1
		normal 1
	)

	(method (init)
		(super init:)
		(if (not head)
			((= head (Head new:)) init: self)
		)
	)

	(method (look param1)
		(= lookingDir param1)
	)

	(method (cue)
		(if head
			(head setCel: 0 setCycle: 0)
		)
	)

	(method (dispose)
		(= head 0)
		(super dispose:)
	)
)

