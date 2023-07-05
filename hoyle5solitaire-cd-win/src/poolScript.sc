;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6095)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	poolScript 0
	pDiver 1
)

(instance pDiver of Prop
	(properties
		view 993
	)

	(method (init)
		(self setPri: 20 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance poolScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DisableCursor)
				(pDiver init: setLoop: 0 setCel: 0 show:)
				(= seconds 4)
			)
			(1
				(pDiver setCycle: End self)
			)
			(2
				(pDiver setLoop: 1 setCel: 0)
				(pDiver setCycle: End self)
			)
			(3
				(pDiver setLoop: 2 setCel: 0)
				(pDiver setCycle: End self)
			)
			(4
				(pDiver setLoop: 3 setCel: 0)
				(pDiver setCycle: End self)
			)
			(5
				(EnableCursor)
				(= seconds 3)
			)
			(6
				(pDiver hide: dispose:)
				(poolScript dispose:)
			)
		)
	)
)

