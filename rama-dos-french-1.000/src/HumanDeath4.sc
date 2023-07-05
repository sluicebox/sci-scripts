;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8090)
(include sci.sh)
(use Main)
(use Location)
(use VMDMovie)
(use System)

(public
	HumanDeath4 0
)

(instance HumanDeath4 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 270 picture: 8055)
		(super init: 8055 &rest)
		(gCurRoom setScript: sSpiderKills)
	)
)

(instance spiderKillsYou of VMDMovie
	(properties
		movieName 8006
		begPic 8055
		endPic 8056
	)
)

(instance sSpiderKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(spiderKillsYou play: self)
			)
			(2
				((gCurRoom picObj:) showBlack: 0)
				(gCurRoom setScript: (ScriptID 97 0)) ; shiftToRed
			)
		)
	)
)

