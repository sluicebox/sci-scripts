;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3130)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use System)

(public
	s2_3130 0
)

(instance s2_3130 of PQRoom
	(properties
		picture 3130
	)

	(method (init)
		(super init: &rest)
		(self setScript: sEgoDies)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sEgoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 31300 156 118 0 0 -1 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(2
				(proc4_5)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

