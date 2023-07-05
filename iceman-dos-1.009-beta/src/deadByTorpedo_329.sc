;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 329)
(include sci.sh)
(use Main)
(use n396)
(use n821)
(use System)

(public
	deadByTorpedo 0
)

(procedure (localproc_0)
	(gIceGlobalSound number: (proc0_5 20) loop: 1 owner: gGame priority: 1 play:)
	(ShakeScreen 30)
)

(instance deadByTorpedo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(proc396_0 3 329 0) ; "SIR TORPEDO 300 YARDS!!!"
				(localproc_0)
				(= seconds 4)
			)
			(2
				(localproc_0)
				(proc396_0 4 329 1) ; "WE'RE GETTING THE #@%# KNOCKED OUT OF US"
				((ScriptID 372) dispose:) ; subInv
				(= global101 0)
				(DisposeScript 370)
				(= seconds 5)
			)
			(3
				(localproc_0)
				(EgoDead 926 1 0 329 2) ; "You look down and discover water up to your ankles. This won't look good on your resume."
			)
		)
	)
)

