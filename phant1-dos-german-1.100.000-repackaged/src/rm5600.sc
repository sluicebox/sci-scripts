;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5600)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm5600 0
)

(instance rm5600 of ScaryRoom
	(properties
		picture 5600
		stepSound 4
	)

	(method (init)
		(proc1111_6)
		(gGame handsOff:)
		(gEgo setScaler: Scaler 84 50 127 96 init:)
		(if (and (IsFlag 52) (== gChapter 4))
			(harriet
				init:
				setHotspot: 4 15 3 ; Do, invTarot, Move
				cycleSpeed: 10
				setCycle: Fwd
				sightAngle: 26505
			)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(leftSouthExit init: 3)
				(rightSouthExit init: 3)
			)
			(5100
				(gEgo normalize: 3)
				(if (== global125 11)
					(gEgo posn: 82 101)
					(leftSouthExit init: 3)
				else
					(gEgo posn: 173 97)
					(rightSouthExit init: 3)
				)
				(= global125 0)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				(gGame handsOn:)
			)
			(else
				(gGame handsOff:)
				(gEgo normalize: 1 posn: 189 107)
				(if (not (IsFlag 60))
					(SetFlag 60)
					(self setScript: openLibScr)
					(rightSouthExit init: 3)
					(leftSouthExit init: 3)
				else
					(self setScript: enterScr)
					(rightSouthExit init: 3)
					(leftSouthExit init: 3)
				)
			)
		)
		(if (IsFlag 159)
			(fireplaceExit init: 4)
		else
			(fireplace init: setHotspot: 4 3) ; Do, Move
		)
		(magazine init: ignoreActors: 1 setPri: 200 setHotspot: 4 3) ; Do, Move
		(magazineFea init: setHotspot: 4 3) ; Do, Move
		(libDoors init: 2)
		(if (not (gCast contains: harriet))
			(books init: setHotspot: 4 3) ; Do, Move
		else
			(magazine setHotspot: 0)
		)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(not (OneOf newRoomNumber 5600 5200))
				(== gChapter 4)
				(IsFlag 52)
			)
			(SetFlag 310)
			(SetFlag 265)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance s3400 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (== (gEgo x:) 189) (== (gEgo y:) 107))
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(if (< (gEgo x:) 160)
						(if (gCast contains: harriet)
							(harriet
								view: 5105
								loop: 0
								cel: 0
								posn: 239 126
								setPri: 130
							)
						)
						(magazine view: 5103 loop: 0 posn: 162 93)
						(gEgo view: 1 posn: 95 104 setHeading: 270 self)
						(if (IsFlag 159)
							(gCurRoom drawPic: 5102)
						else
							(gCurRoom drawPic: 5101)
						)
					else
						(= cycles 1)
					)
				)
				(2
					(if (and (== gChapter 4) (IsFlag 52))
						(SetFlag 310)
						(SetFlag 265)
					)
					(gCurRoom newRoom: 3400)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (and (== gChapter 4) (IsFlag 52))
						(SetFlag 310)
						(SetFlag 265)
					)
					(= global115 0)
					(gCurRoom newRoom: 3400)
				)
			)
		)
	)
)

(instance openLibScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setScript: (ScriptID 0 5) self 10) ; takeLastStep
				)
				(1
					(= cycles 2)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTo5100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 180 self)
				)
				(1
					(gCurRoom newRoom: 5100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 5100)
				)
			)
		)
	)
)

(instance sLookAtBooks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 90) (== (gEgo y:) 95))
							(= cycles 2)
						)
						((and (== (gEgo x:) 189) (== (gEgo y:) 107))
							(gEgo setHeading: 180 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(magazine hide:)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(proc1111_7 2029 0 0)
					(gCurRoom drawPic: 5610)
				)
				(2
					(proc1111_7 2030 65 -13)
					(gCurRoom drawPic: 5350)
				)
				(3
					(magazine show:)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo posn: 90 95 normalize: 0 show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(magazine show:)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo posn: 90 95 normalize: 0 show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gCurRoom drawPic: (gCurRoom picture:))
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMags of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 180 self)
				)
				(1
					(gCurRoom newRoom: 5100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 5100)
				)
			)
		)
	)
)

(instance sDoFire of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 180 self)
				)
				(1
					(if (IsFlag 159)
						(proc1111_8)
						(gCurRoom drawPic: 5305)
						(proc1111_7 2110 76 13 gEgo -1 1)
					else
						(self cue:)
					)
				)
				(2
					(if (and (== register 4) (IsFlag 159))
						(= register 0)
						(gCurRoom newRoom: 6500)
					else
						(gCurRoom newRoom: 5500)
					)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(if (and (== register 4) (IsFlag 159))
						(= register 0)
						(gCurRoom newRoom: 6500)
					else
						(gCurRoom newRoom: 5500)
					)
				)
			)
		)
	)
)

(instance giveTarot of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 82) (== (gEgo y:) 101))
							(gEgo setHeading: 0 self)
						)
						((and (== (gEgo x:) 90) (== (gEgo y:) 95))
							(= cycles 2)
						)
						((and (== (gEgo x:) 82) (== (gEgo y:) 101))
							(= cycles 2)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(magazine hide:)
					(harriet hide:)
					(gEgo put: 9) ; invTarot
					(SetFlag 179)
					(proc1111_7 4251 -22 -32)
					(gCurRoom drawPic: 5610)
				)
				(2
					(magazine show:)
					(harriet show:)
					(gEgo
						normalize: 2
						posn: 82 101
						cel: 15
						setCycle: End self
					)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gCurRoom drawPic: (gCurRoom picture:))
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(magazine show:)
					(harriet show:)
					(gEgo normalize: 2 posn: 82 101)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gCurRoom drawPic: (gCurRoom picture:))
					(proc1111_6)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance askBuildingScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 82) (== (gEgo y:) 101))
							(gEgo setHeading: 0 self)
						)
						((and (== (gEgo x:) 90) (== (gEgo y:) 95))
							(= cycles 2)
						)
						((and (== (gEgo x:) 82) (== (gEgo y:) 101))
							(= cycles 2)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(magazine hide:)
					(harriet hide:)
					(proc1111_7 4300 -13 -48)
					(gCurRoom drawPic: 5610)
				)
				(2
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo
						normalize: 2
						posn: 82 101
						cel: 15
						setCycle: End self
					)
					(gCurRoom drawPic: (gCurRoom picture:))
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo normalize: 2 posn: 82 101)
					(gCurRoom drawPic: (gCurRoom picture:))
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance looksGoodScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 82) (== (gEgo y:) 101))
							(gEgo setHeading: 0 self)
						)
						((and (== (gEgo x:) 90) (== (gEgo y:) 95))
							(= cycles 2)
						)
						((and (== (gEgo x:) 82) (== (gEgo y:) 101))
							(= cycles 2)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(magazine hide:)
					(harriet hide:)
					(proc1111_7 4310 -9 -42)
					(gCurRoom drawPic: 5610)
				)
				(2
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo
						normalize: 2
						posn: 82 101
						cel: 15
						setCycle: End self
					)
					(gCurRoom drawPic: (gCurRoom picture:))
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo normalize: 2 posn: 82 101)
					(gCurRoom drawPic: (gCurRoom picture:))
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance rightSouthExit of ExitFeature
	(properties
		nsLeft 180
		nsTop 115
		nextRoom 5100
		interRoom 11
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(= global125 11)
			(gCurRoom setScript: sTo5100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leftSouthExit of ExitFeature
	(properties
		nsTop 115
		nsRight 100
		approachX 80
		approachY 130
		nextRoom 5100
		interRoom 12
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(= global125 12)
			(gCurRoom setScript: sTo5100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance libDoors of ExitFeature
	(properties
		sightAngle 40
		approachX 216
		approachY 109
		x 216
		y 109
	)

	(method (init)
		(self createPoly: 224 41 240 38 253 56 249 116 210 101 211 56)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: s3400)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance books of Feature
	(properties
		approachX 90
		approachY 95
		x 74
		y 92
	)

	(method (init)
		(self createPoly: 64 45 79 49 78 86 66 97)
		(super init: &rest)
		(= sightAngle 26505)
		(self sightAngle: 26505 approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sLookAtBooks)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance magazineFea of Feature
	(properties
		nsLeft 109
		nsTop 85
		nsRight 131
		nsBottom 99
		x 120
		y 92
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(magazine doVerb: 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireplace of Feature
	(properties
		heading 90
		approachX 55
		approachY 119
		x 37
		y 119
	)

	(method (init)
		(self createPoly: 28 59 39 67 51 69 51 77 41 89 41 100 54 109 31 129)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 10 11 35) ; Do, invPoker, invHammer, ???
			(if (and (or (== theVerb 21) (== theVerb 4)) (IsFlag 159)) ; Exit, Do
				(gCurRoom setScript: sDoFire 0 4)
			else
				(gCurRoom setScript: sDoFire)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fireplaceExit of ExitFeature
	(properties
		approachX 55
		approachY 119
		nextRoom 6500
	)

	(method (init)
		(self createPoly: 28 59 39 67 51 69 51 77 41 89 41 100 54 109 31 129)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 10 11 35 21) ; Do, invPoker, invHammer, ???, Exit
			(if (and (or (== theVerb 21) (== theVerb 4)) (IsFlag 159)) ; Exit, Do
				(gCurRoom setScript: sDoFire 0 4)
			else
				(gCurRoom setScript: sDoFire)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance harriet of Prop
	(properties
		x 66
		y 96
		view 5104
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (not (IsFlag 176)) (IsFlag 153))
					(gGame handsOff:)
					(gCurRoom setScript: looksGoodScr)
				else
					(SetFlag 153)
					(gGame handsOff:)
					(gCurRoom setScript: askBuildingScr)
				)
			)
			(15 ; invTarot
				(gCurRoom setScript: giveTarot)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magazine of View
	(properties
		x 117
		y 92
		view 5101
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(= global125 62)
				(gCurRoom setScript: sMags)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

