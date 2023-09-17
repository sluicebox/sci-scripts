;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6093)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	kingScript 0
	pKing 1
)

(instance pKing of Prop
	(properties
		view 991
	)

	(method (init)
		(self setPri: 20 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance kingScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DisableCursor)
				(pKing init: setLoop: 0 setCel: 0 show:)
				(= seconds 2)
			)
			(1
				(pKing setCycle: End self)
			)
			(2
				(EnableCursor)
				(= seconds 3)
			)
			(3
				(pKing hide: dispose:)
				(kingScript dispose:)
			)
		)
	)
)

