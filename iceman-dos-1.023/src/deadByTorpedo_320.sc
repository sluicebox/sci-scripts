;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n396)
(use n821)
(use System)

(public
	deadByTorpedo 0
)

(instance deadByTorpedo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(proc396_0 3 320 0) ; "SIR, TORPEDO ON US!!!"
				(gIceGlobalSound
					number: (proc0_5 20)
					loop: 1
					owner: gGame
					priority: 1
					play:
				)
				(ShakeScreen 30)
				(= seconds 4)
			)
			(2
				(gIceGlobalSound
					number: (proc0_5 20)
					loop: 1
					owner: gGame
					priority: 1
					play:
				)
				(ShakeScreen 30)
				(proc396_0 4 320 1) ; "HERE WE COME, DAVY JONES"
				(if global101
					((ScriptID 372) dispose:) ; subInv
				)
				(= global101 0)
				(DisposeScript 370)
				(DisposeScript 396)
				(= seconds 5)
			)
			(3
				(switch register
					(4
						(EgoDead 926 1 0 320 2) ; "You failed to watch for an inversion layer."
					)
					(6
						(EgoDead 926 1 0 320 3) ; "You're in enemy waters! Refer to the strategy section of your manual."
					)
					(else
						(EgoDead 926 1 0 320 4) ; "You're a seasoned submariner, John, why did you make such an amateur mistake?"
					)
				)
			)
		)
	)
)

