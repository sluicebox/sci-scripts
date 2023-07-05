;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1500)
(include sci.sh)
(use Main)
(use PQRoom)
(use System)

(public
	rm1500 0
)

(instance rm1500 of PQRoom
	(properties
		picture 1500
	)

	(method (init)
		(Load rsAUDIO 10301)
		(Load rsPIC 1500)
		(gBackMusic number: 10301 loop: 1 play:)
		(Lock rsAUDIO 10301 1)
		(super init: &rest)
		(self setScript: openScenario)
	)

	(method (dispose)
		(Lock rsAUDIO 10301 0)
		(super dispose: &rest)
	)
)

(instance openScenario of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((gSwatInterface curSwatButn:) doVerb:)
				(gMessager say: 0 0 1 0 self) ; "Terrorists / Hostage involved. Shots fired. 18635 San Pedro. Corner of San Pedro and Imperial. Southeast area. Code 3."
			)
			(2
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 4053)
			)
		)
	)
)

