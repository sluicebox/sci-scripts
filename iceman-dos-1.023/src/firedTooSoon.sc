;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 326)
(include sci.sh)
(use Main)
(use n821)
(use System)

(public
	firedTooSoon 0
)

(instance firedTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 372) dispose:) ; subInv
				(= global101 0)
				(DisposeScript 370)
				(= seconds 4)
			)
			(1
				(EgoDead 926 1 0 326 0) ; "The United States rules of engagement prohibit our use of weapons unless fired upon. You're a shame to the service, Johnny."
			)
		)
	)
)

