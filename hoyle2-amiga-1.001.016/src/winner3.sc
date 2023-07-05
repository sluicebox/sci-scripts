;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 327)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	winner3 0
)

(local
	local0
)

(instance winner3 of Obj
	(properties)

	(method (init)
		(= local0 0)
		(self doit:)
	)

	(method (doit)
		(cond
			((not local0)
				(Wait 1)
				(++ local0)
				(gTheSound number: 17 play:)
				(theCardActor init:)
			)
			((and (>= local0 2) (== (++ local0) 102))
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gCurRoom script: 0)
		(theCardActor dispose:)
		(theCongratsActor dispose:)
	)
)

(instance theCardActor of Act
	(properties
		view 195
		priority 9
		cycleSpeed 2
	)

	(method (init)
		(self posn: 145 40 setPri: priority setCycle: End self)
		(super init:)
	)

	(method (cue)
		(Wait 90)
		(if (< loop 4)
			(++ loop)
			(self setLoop: loop cel: 0 setCycle: End self)
		else
			(theCongratsActor init:)
		)
	)
)

(instance theCongratsActor of Act
	(properties
		view 195
		priority 11
		cycleSpeed 2
	)

	(method (init)
		(self posn: 160 100 setLoop: 5 setPri: priority setCycle: End self)
		(super init:)
	)

	(method (cue)
		(= local0 2)
	)
)

