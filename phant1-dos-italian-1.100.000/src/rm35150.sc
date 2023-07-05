;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35150)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use System)

(public
	rm35150 0
)

(instance rm35150 of ScaryRoom
	(properties
		picture 35150
	)

	(method (init)
		(if (== gChapter 5)
			(Palette 2 55 135 70) ; PalIntensity
		)
		(global114 play: 4050)
		(gEgo init: setScaler: Scaler 125 87 129 109 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(35140
				(gEgo normalize: 3 posn: 143 135 setPri: 70)
				(gGame setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(proc1111_6)
				(gEgo normalize: 2 posn: 176 110 setPri: 70)
				(gGame setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(door init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(southExit init: 3 approachX: (gEgo x:))
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 6400) (== gChapter 5))
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sOpenPassage of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(gGame handsOff:)
					(gCurRoom drawPic: 35155 picture: 35155)
					(proc1111_7 905 -6 -22 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 6400)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom newRoom: 6400)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 102
		nsRight 176
		approachX 165
		approachY 179
		nextRoom 35140
	)
)

(instance door of Feature
	(properties
		nsLeft 159
		nsTop 64
		nsRight 171
		nsBottom 75
		approachX 176
		approachY 109
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sOpenPassage)
		else
			(super doVerb: theVerb)
		)
	)
)

