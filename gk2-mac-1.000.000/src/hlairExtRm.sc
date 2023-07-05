;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 641)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use System)

(public
	hlairExtRm 0
)

(instance hlairExtRm of ExitRoom
	(properties)

	(method (init)
		(super init: &rest)
		(if (gTimers contains: (ScriptID 499 2)) ; WolfTimer
			((ScriptID 499 2) dispose:) ; WolfTimer
		)
		(if (gTimers contains: (ScriptID 499 1)) ; ChaseTimer
			((ScriptID 499 1) dispose:) ; ChaseTimer
		)
		(self setScript: fadeScript)
	)
)

(instance fadeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGk2Music fade: 0 20 10 1 self)
			)
			(1
				(Lock rsAUDIO 606 0)
				(PlayScene 691 0 666) ; uDie
			)
		)
	)
)

