;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 326)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	winner2 0
)

(local
	local0
)

(instance winner2 of Obj
	(properties)

	(method (init)
		(= local0 0)
		(self doit:)
	)

	(method (doit)
		(cond
			((not local0)
				(gTheSound number: 9 play:)
				(++ local0)
				(theCardActor init:)
			)
			((>= local0 2)
				(if (== (++ local0) 20)
					(theCardActor cel: 1 setCycle: 0)
				)
				(if (== local0 35)
					(theCongratsActor setCycle: End)
				)
				(if (== local0 57)
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(gCurRoom script: 0)
		(theCardActor dispose:)
		(theJokerActor dispose:)
		(theCongratsActor dispose:)
	)
)

(instance theCardActor of Act
	(properties
		view 194
		priority 9
		cycleSpeed 2
	)

	(method (init)
		(self posn: 112 100 setPri: priority setCycle: End self)
		(super init:)
	)

	(method (cue)
		(self setLoop: 1 setCycle: Fwd cycleSpeed: 0)
		(theJokerActor init:)
	)
)

(instance theJokerActor of Act
	(properties
		view 194
		priority 10
		cycleSpeed 1
	)

	(method (init)
		(self posn: 112 100 setLoop: 2 setPri: priority setCycle: End self)
		(super init:)
	)

	(method (cue)
		(theCongratsActor init:)
		(theCardActor cycleSpeed: 2)
	)
)

(instance theCongratsActor of Act
	(properties
		view 194
		priority 11
	)

	(method (init)
		(self posn: 155 120 setLoop: 3 setPri: priority setCycle: Fwd)
		(super init:)
		(= local0 2)
	)
)

