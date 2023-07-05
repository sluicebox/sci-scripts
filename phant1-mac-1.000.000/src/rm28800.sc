;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28800)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm28800 0
)

(instance rm28800 of ScaryRoom
	(properties
		picture 28800
		stepSound 1
	)

	(method (newRoom newRoomNumber)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: newRoomNumber)
	)

	(method (drawPic param1)
		(switch param1
			(28800
				(water1 show: posn: 0 131 view: 28800 setCycle: Fwd)
				(water2 hide:)
			)
			(28803
				(water1 show: posn: 0 131 view: 28803 setCycle: Fwd)
				(water2 hide:)
			)
			(28804
				(water1 show: posn: 0 131 view: 28804 setCycle: Fwd)
				(water2 hide:)
			)
			(28910
				(water1 show: posn: 222 129 view: 28910 setCycle: Fwd)
				(water2 show: posn: 0 129 view: 28910 loop: 1 setCycle: Fwd)
			)
			(28911
				(water1 show: posn: 222 129 view: 28911 setCycle: Fwd)
				(water2 show: posn: 0 129 view: 28911 loop: 1 setCycle: Fwd)
			)
			(28900
				(water1 show: posn: 222 129 view: 28900 setCycle: Fwd)
				(water2 show: posn: 0 129 view: 28900 loop: 1 setCycle: Fwd)
			)
			(28915
				(water1 show: posn: 203 125 view: 28915 setCycle: Fwd)
				(water2 hide:)
			)
			(else
				(water1 hide:)
				(water2 hide:)
			)
		)
		(if (water2 isNotHidden:)
			(UpdateScreenItem water2)
		)
		(if (water1 isNotHidden:)
			(UpdateScreenItem water1)
		)
		(super drawPic: param1)
	)

	(method (init &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 0)
		(cond
			((== gChapter 1)
				(= temp0 9040)
			)
			((== gChapter 2)
				(= temp1 915)
				(= temp0 9050)
			)
			((== gChapter 3)
				(= temp1 916)
				(= temp0 9060)
			)
			((== gChapter 4)
				(= temp1 916)
				(= temp0 9060)
			)
			((== gChapter 6)
				(= temp1 918)
				(= temp0 9080)
			)
		)
		((ScriptID 30) init:) ; FidgetCode
		(if (!= gChapter 5)
			(if (== (gGDacSound number:) temp0)
				(if (not (gGDacSound handle:))
					(gGDacSound number: temp0 setLoop: -1 play:)
				)
			else
				(gGDacSound number: temp0 setLoop: -1 play:)
			)
		)
		(water1 init:)
		(water2 init:)
		(cond
			((== gChapter 5)
				(Palette 2 55 135 70) ; PalIntensity
				(= picture 28804)
				(gEgo fadePalette: 28100)
			)
			((IsFlag 184)
				(= picture 28803)
			)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 52 44 82 37
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(if (< (gEgo x:) 160)
					(westExit init: 4)
				else
					(eastExit init: 2)
				)
				(gGame handsOn:)
			)
			(28900
				(eastExit init: 2)
				(gGame handsOn:)
				(gEgo view: 1 posn: 281 65)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(westExit init: 4)
				(gEgo view: 0 posn: 5 44)
				(cond
					((and (IsFlag 185) (not (IsFlag 184)))
						(SetFlag 91)
						(self setScript: pushTreeScr)
					)
					((not (IsFlag 91))
						(SetFlag 91)
						(self setScript: firstScr)
					)
					(else
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
		)
		(super init: &rest)
		(if (IsFlag 184)
			(log init:)
		)
	)
)

(instance log of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 88 33 93 29 101 35 112 35 120 39 134 38 139 34 135 25 139 22 157 24 144 26 149 33 145 37 176 35 178 46 130 50 131 54 134 57 131 60 125 56 123 53 108 53 98 57 81 49 81 38
					yourself:
				)
			setHotspot: 4 3 ; Do, Move
		)
	)

	(method (handleEvent event)
		(= approachY (gEgo y:))
		(if (< (gEgo x:) 160)
			(= approachX (+ (gEgo x:) 20))
		else
			(= approachX (- (gEgo x:) 20))
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb)
		(if (< (gEgo x:) 160)
			(gCurRoom setScript: crossTreeScr 0 0)
		else
			(gCurRoom setScript: crossTreeScr 0 1)
		)
	)
)

(instance water1 of Prop
	(properties
		fixPriority 1
		view 28800
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 14)
	)
)

(instance water2 of Prop
	(properties
		fixPriority 1
		view 28800
		loop 1
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 14)
		(self setCycle: Fwd)
	)
)

(instance westExit of ExitFeature
	(properties
		approachX -10
		approachY 46
		nextRoom 28840
	)
)

(instance eastExit of ExitFeature
	(properties
		approachX 330
		approachY 46
		nextRoom 28900
	)
)

(instance firstScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 90 self)
				)
				(1
					(gCurRoom drawPic: 28900)
					(DoAudio 12 0) ; AudMixCheck
					(proc1111_7 1690 124 42)
				)
				(2
					(DoAudio 12 1) ; AudMixCheck
					(gEgo normalize: 1 posn: 71 46)
					(gCurRoom drawPic: 28800)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(gEgo normalize: 1 posn: 71 46)
			(DoAudio 12 1) ; AudMixCheck
			(gCurRoom drawPic: 28800)
			(gGame handsOn:)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance pushTreeScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 184)
					(ClearFlag 185)
					(proc1111_7 4420 -5 -2)
					(gCurRoom picture: 28800)
				)
				(1
					(proc1111_7 4421 64 27)
					(gCurRoom drawPic: 28900)
				)
				(2
					(Load rsVIEW 28802)
					(proc1111_7 4422 9 -24 gEgo -1 1)
					(gCurRoom drawPic: 28800)
				)
				(3
					((= register (View new:))
						view: 28802
						posn: 77 44
						setPri: 0
						init:
					)
				)
				(4
					(register dispose:)
					(= register 0)
					(proc1111_7 4426 125 -6)
					(gCurRoom drawPic: 28915)
				)
				(5
					(proc1111_7 4427 -20 -17)
					(gCurRoom drawPic: 28803)
				)
				(6
					(gCurRoom drawPic: 28910)
					(proc1111_7 4425 85 48)
				)
				(7
					(gEgo normalize: 0 posn: 60 50)
					(= global163 log)
					(log init:)
					(gCurRoom drawPic: 28803)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(if register
				(register dispose:)
				(= register 0)
			)
			(gEgo normalize: 6 posn: 60 50)
			(gCurRoom drawPic: 28803)
			(log init:)
			(= global115 0)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance crossTreeScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global163 0)
					(if (< (gEgo x:) 160)
						(gEgo setHeading: 90 self 20)
					else
						(gEgo setHeading: 270 self 20)
					)
				)
				(1
					(gCurRoom drawPic: (+ 28910 (== gChapter 5)))
					(DoAudio 12 0) ; AudMixCheck
					(proc1111_7 (+ 4423 register) 84 30 gEgo 200)
				)
				(2
					(gCurRoom drawPic: (+ 28803 (== gChapter 5)))
					(DoAudio 12 1) ; AudMixCheck
					(if register
						(gEgo normalize: 1 posn: 74 47)
						(eastExit dispose:)
						(westExit init: 4)
					else
						(gEgo normalize: 0 posn: 185 47)
						(westExit dispose:)
						(eastExit init: 2)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gCurRoom drawPic: (+ 28803 (== gChapter 5)))
			(DoAudio 12 1) ; AudMixCheck
			(if register
				(gEgo normalize: 1 posn: 74 50)
				(eastExit dispose:)
				(westExit init: 4)
			else
				(gEgo normalize: 0 posn: 185 47)
				(westExit dispose:)
				(eastExit init: 2)
			)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

