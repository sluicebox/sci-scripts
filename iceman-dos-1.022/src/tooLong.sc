;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 327)
(include sci.sh)
(use Main)
(use n821)
(use System)

(public
	tooLong 0
)

(instance tooLong of Script
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
				(EgoDead 926 1 0 327 0) ; "You can't just sit here. Get your messages."
			)
		)
	)
)

