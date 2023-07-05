;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 328)
(include sci.sh)
(use Main)
(use n396)
(use n821)
(use System)

(public
	deadByDepthCharge 0
)

(procedure (localproc_0)
	(gIceGlobalSound number: (proc0_5 20) loop: 1 owner: gGame priority: 1 play:)
	(ShakeScreen 30)
)

(instance deadByDepthCharge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 372) dispose:) ; subInv
				(= global101 0)
				(DisposeScript 370)
				(= seconds 1)
			)
			(1
				(proc396_0 3 328 0) ; "SIR, DESTROYER DIRECTLY ABOVE US!!!"
				(= seconds 4)
			)
			(2
				(proc396_0 3 328 1) ; "DEPTH CHARGES!!!"
				(localproc_0)
				(= seconds 4)
			)
			(3
				(proc396_0 3 328 2) ; "MORE DEPTH CHARGES COMING, SIR!!!"
				(localproc_0)
				(= seconds 4)
			)
			(4
				(EgoDead 926 1 0 328 3) ; "The battle ship finds you and drops depth charges. Good bye, dolphins!"
			)
		)
	)
)

