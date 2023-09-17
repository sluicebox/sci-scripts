;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6094)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	baseScript 0
	pBaseball 1
)

(instance pBaseball of Prop
	(properties
		view 992
	)

	(method (init)
		(self setPri: 15 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance baseScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DisableCursor)
				(pBaseball init: setLoop: 0 setCel: 0 show:)
				(= cycles 1)
			)
			(1
				(pBaseball setCycle: End self)
			)
			(2
				(EnableCursor)
				(= seconds 5)
			)
			(3
				(pBaseball hide: dispose:)
				(baseScript dispose:)
			)
		)
	)
)

