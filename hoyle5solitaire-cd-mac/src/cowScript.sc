;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6092)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	cowScript 0
	pCowboy 1
)

(instance pCowboy of Prop
	(properties
		view 987
	)

	(method (init)
		(self setPri: 15 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance cowScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DisableCursor)
				(pCowboy init: setLoop: 0 setCel: 0 show:)
				(= cycles 1)
			)
			(1
				(pCowboy setCycle: End self)
			)
			(2
				(pCowboy loop: 1 cel: 0)
				(gSound play: 90)
				(pCowboy setCycle: End self)
			)
			(3
				(EnableCursor)
				(= seconds 5)
			)
			(4
				(pCowboy hide: dispose:)
				(cowScript dispose:)
			)
		)
	)
)

