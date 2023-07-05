;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34030)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm34v030 0
)

(instance rm34v030 of ShiversRoom
	(properties
		picture 34030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 10100) ; rm10v100
			(= global348 1)
			(SetFlag 43)
		)
		(if (== gPrevRoomNum 27212) ; rm27v212
			(= global348 2)
			(SetFlag 43)
		)
		(if (== gPrevRoomNum 33140) ; rm33v140
			(= global348 3)
			(SetFlag 43)
		)
		(super init: &rest)
		(if (and (!= gPrevRoomNum 34020) (!= gPrevRoomNum 34040)) ; rm34v020, rm34v040
			(self setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 34020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 34040
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 27212) ; rm27v212
					(gSounds fade: 22701 0 1 30 1 self)
				else
					(= seconds 2)
				)
			)
			(1
				(proc951_7 23401)
				(proc951_9 23401)
				(gSounds play: 23401 -1 34 0)
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

