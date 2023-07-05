;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8080)
(include sci.sh)
(use Main)
(use Location)
(use VMDMovie)
(use System)

(public
	HumanDeath3 0
)

(instance HumanDeath3 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 270 picture: 8057)
		(super init: 8057 &rest)
		(gCurRoom setScript: sSpiderKills)
	)
)

(instance spiderKillsYou of VMDMovie
	(properties
		movieName 8007
		begPic 8057
		endPic 8058
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

