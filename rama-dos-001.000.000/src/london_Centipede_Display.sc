;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3069)
(include sci.sh)
(use Main)
(use Location)
(use Button)
(use VMDMovie)
(use Sound)
(use Actor)
(use System)

(public
	london_Centipede_Display 0
)

(instance london_Centipede_Display of CloseupLocation
	(properties
		noun 27
		heading 270
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(super init: 3305)
		(= plane global116)
		(displayButton init:)
	)
)

(instance trashBiotEye of View
	(properties
		x 236
		y 72
		view 3305
	)
)

(instance displayButton of Button
	(properties
		x 196
		y 247
		loop 1
		view 3305
	)

	(method (init)
		(&= signal $efff)
		(super init: global117 &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom setScript: centipedeAnim)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance centipedeAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(trashBiotEye init: global117)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(trashBiotEye cel: 1)
				(FrameOut)
				(eye_Off play:)
				(= cycles (Random 1 3))
			)
			(2
				(trashBiotEye cel: 0)
				(FrameOut)
				(= cycles (Random 60 100))
			)
			(3
				(trashBiotEye cel: 1)
				(FrameOut)
				(= cycles (Random 3 5))
			)
			(4
				(trashBiotEye cel: 0)
				(FrameOut)
				(= cycles (Random 30 90))
			)
			(5
				(trashBiotEye cel: 1)
				(FrameOut)
				(= cycles (Random 3 5))
			)
			(6
				(trashBiotEye dispose:)
				(centipede play:)
				(eye_On play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance centipede of VMDMovie
	(properties
		movieName 3305
		frameRate 15
		cacheSize 1000
	)
)

(instance eye_Off of Sound
	(properties
		number 3302
		flags 5
	)
)

(instance eye_On of Sound
	(properties
		number 3312
		flags 5
	)
)

