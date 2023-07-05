;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30061)
(include sci.sh)
(use Main)
(use n63002)
(use P2Timer)
(use System)

(public
	zombiesTimer 0
)

(instance zombiesTimer of P2Timer
	(properties
		kind 3
		length 20
	)

	(method (start)
		(= whoDoit zombiesKillCurtis)
		(super start: &rest)
	)
)

(instance zombiesKillCurtis of Code
	(properties)

	(method (doit)
		(= global211 (not (= global212 0)))
		(if (IsFlag 1500)
			(= global209 (if (== global207 0) 4986 else 4987))
		else
			(= global209 4981)
		)
		(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
	)
)

