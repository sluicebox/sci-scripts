;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28810)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	rm28810 0
)

(instance rm28810 of ScaryRoom
	(properties
		picture 28810
		stepSound 1
	)

	(method (drawPic param1)
		(if (and (== gChapter 5) (ResCheck rsPIC (+ param1 1)))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: newRoomNumber)
	)

	(method (init &tmp temp0 temp1)
		(= temp1 0)
		(cond
			((== gChapter 1)
				(= temp0 904)
			)
			((== gChapter 2)
				(= temp1 915)
				(= temp0 905)
			)
			((== gChapter 3)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 4)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 5)
				(= temp1 917)
				(= temp0 907)
			)
			((== gChapter 6)
				(= temp1 918)
				(= temp0 908)
			)
		)
		(if (== (gGDacSound number:) temp0)
			(if (not (gGDacSound handle:))
				(gGDacSound number: temp0 setLoop: -1 play:)
			)
		else
			(gGDacSound number: temp0 setLoop: -1 play:)
		)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(Palette 2 55 135 70) ; PalIntensity
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 137 36 176 85
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo view: 2 posn: 95 100)
				(self setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(pond init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(northExit init: 1)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((< (gEgo y:) 85)
				(gGame handsOff:)
				(gCurRoom newRoom: 28815)
			)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 82
		nsTop 51
		nsRight 162
		nsBottom 91
		approachX 90
		approachY 60
		nextRoom 28815
	)
)

(instance lookInPond of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1670 71 33 gEgo 117)
					(gCurRoom drawPic: 28805)
				)
				(1
					(gCurRoom drawPic: 28810)
					(gGame handsOn:)
					(gEgo normalize: 2 posn: 153 93)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(gCurRoom drawPic: 28810)
					(gGame handsOn:)
					(gEgo normalize: 2 posn: 153 93)
					(self dispose:)
				)
			)
		)
	)
)

(instance findCat of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 317)
					(gCurRoom drawPic: -1)
					(gEgo hide:)
					(PlayVMD 0 {4970.vmd} 0) ; Open
					(proc26_0 4970 self)
				)
				(1
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 2200)
				)
			)
		)
	)
)

(instance missingCat of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 5000 89 37)
					(gCurRoom drawPic: 28805)
				)
				(1
					(gEgo normalize: 2 posn: 153 93)
					(gCurRoom drawPic: 28810)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo normalize: 2 posn: 153 93)
					(gCurRoom drawPic: 28810)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance pond of Feature
	(properties
		approachX 200
		approachY 90
		x 50
		y 150
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 195 36 200 32 203 69 199 70 203 86 189 96 158 93 170 90 163 87 184 82 190 81
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (== gChapter 5) (IsFlag 195))
					(if (IsFlag 317)
						(gCurRoom setScript: missingCat)
					else
						(gCurRoom setScript: findCat)
					)
				else
					(gCurRoom setScript: lookInPond)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

