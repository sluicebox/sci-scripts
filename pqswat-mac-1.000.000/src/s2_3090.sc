;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3090)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use System)

(public
	s2_3090 0
)

(instance s2_3090 of PQRoom
	(properties
		picture 3090
	)

	(method (init)
		(super init: &rest)
		(self setScript: sYourDead)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sYourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(proc4_6 30900 399 -15 0 0 1 1)
			)
			(2
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

