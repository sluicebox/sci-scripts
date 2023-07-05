;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8060)
(include sci.sh)
(use Main)
(use Location)
(use VMDMovie)
(use System)

(public
	HumanDeath1 0
)

(instance HumanDeath1 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 270 picture: 8059)
		(super init: 8059 &rest)
		(gCurRoom setScript: sSpiderKills)
	)
)

(instance spiderKillsYou of VMDMovie
	(properties
		movieName 8008
		begPic 8059
		endPic 8060
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

