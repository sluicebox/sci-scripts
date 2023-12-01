;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm5100 0
)

(instance rm5100 of ScaryRoom
	(properties
		stepSound 4
	)

	(method (init &tmp temp0)
		(gGame handsOff:)
		(KillRobot)
		(= picture (if (IsFlag 159) 5102 else 5101))
		(gEgo init: setScaler: Scaler 120 40 140 79 normalize:)
		(magazine
			init:
			ignoreActors: 1
			setPri: 200
			approachVerbs: 0
			setHotspot: 4 3 ; Do, Move
		)
		(if (and (IsFlag 52) (== gChapter 4))
			(harriet
				init:
				setHotspot: 4 15 3 ; Do, invTarot, Move
				setCycle: Fwd
				cycleSpeed: 10
				sightAngle: 26505
			)
			(if (== gPrevRoomNum 6500)
				(harriet
					view: 5104
					posn: 68 102
					setScaler: Scaler 130 113 104 95
				)
			)
			(magazine setHotspot: 0)
		else
			(magazineFea init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(if (== global125 62)
			(magazine hide:)
		)
		(libDoors init: 4)
		(desk init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(if (not (gCast contains: harriet))
			(books init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(if (IsFlag 159)
			(fireplaceExit init: 2)
		else
			(fireplace init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(switch gPrevRoomNum
			(900
				(rightSouthExit init: 3)
				(leftSouthExit init: 3)
			)
			(5200
				(gEgo
					normalize: 2
					posn: 163 83
					setScript: (ScriptID 0 5) 0 10 ; takeLastStep
				)
				(rightSouthExit init: 3)
			)
			(5500
				(gEgo normalize: 0 posn: 198 104)
				(rightSouthExit init: 3)
			)
			(5600
				(switch global125
					(62
						(= global125 0)
						(harriet hide:)
						(gEgo normalize: 1 posn: 197 104)
						(= picture
							(cond
								((IsFlag 159) 5322)
								((IsFlag 158) 5321)
								(else 5320)
							)
						)
						(self setScript: sLookAtMag 0 1)
						(rightSouthExit init: 3)
					)
					(11
						(gEgo
							normalize: 3
							posn: 95 99
							setScript: (ScriptID 0 5) 0 10 ; takeLastStep
						)
						(leftSouthExit init: 3)
					)
					(12
						(gEgo
							normalize: 3
							posn: 197 104
							setScript: (ScriptID 0 5) 0 10 ; takeLastStep
						)
						(rightSouthExit init: 3)
					)
					(else
						(gEgo normalize: 0 posn: 95 104)
						(leftSouthExit init: 3)
					)
				)
				(= global125 0)
			)
			(6500
				(KillRobot)
				(gEgo normalize: 1 posn: 198 104 hide:)
				(magazine view: 5101 loop: 0 cel: 0 x: 115 y: 87)
				(= picture 5600)
				(rightSouthExit init: 3)
				(self setScript: fromChapelScr)
				(global114 stop: 1)
				(if global184
					(global114 pause: 3020 0 -1)
					(global114 setVol: (= global184 63) 1)
				else
					(switch gChapter
						(1
							(= temp0 911)
						)
						(2
							(= temp0 911)
						)
						(3
							(= temp0 912)
						)
						(4
							(= temp0 9120)
						)
						(5
							(= temp0 913)
						)
						(6
							(= temp0 914)
						)
						(else
							(= temp0 9140)
						)
					)
					(if temp0
						(Load rsSOUND temp0)
					)
					(global114 play: temp0)
				)
			)
			(else
				(gEgo normalize: 0 posn: 95 104)
				(leftSouthExit init: 3)
			)
		)
		(super init:)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
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

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 270 self)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 270 self)
						)
						((and (== (gEgo x:) 225) (== (gEgo y:) 120))
							(gEgo setHeading: 315 self)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 99))
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(if (> (gEgo x:) 122)
						(gCurRoom drawPic: 5600)
						(if (gCast contains: harriet)
							(harriet
								view: 5104
								posn: 66 96
								setLoop: 0
								setHotspot: 4 15 3 ; Do, invTarot, Move
								setCycle: Fwd
							)
						)
						(magazine view: 5101 loop: 0 posn: 117 92)
						(gEgo view: 0 posn: 189 110 setHeading: 90 self)
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
					(= global115 0)
					(if (and (== gChapter 4) (IsFlag 52))
						(SetFlag 310)
						(SetFlag 265)
					)
					(gCurRoom newRoom: 3400)
				)
			)
		)
	)
)

(instance toDeskScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 0 self 19)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 99))
							(gEgo setHeading: 15 self)
						)
						(
							(or
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
								(and (== (gEgo x:) 95) (== (gEgo y:) 104))
							)
							(gEgo setHeading: 0 self)
						)
						(else
							(gEgo setHeading: 315 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 5200)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 5200)
				)
			)
		)
	)
)

(instance toRightSouthScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (== (gEgo x:) 95) (== (gEgo y:) 104))
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(= global125 11)
					(gCurRoom newRoom: 5600)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(= global125 11)
					(gCurRoom newRoom: 5600)
				)
			)
		)
	)
)

(instance toLeftSouthScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 99))
							(gEgo setHeading: 180 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(= global125 12)
					(gCurRoom newRoom: 5600)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(= global125 12)
					(gCurRoom newRoom: 5600)
				)
			)
		)
	)
)

(instance toFireplaceScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 45 self)
						)
						((and (== (gEgo x:) 197) (== (gEgo y:) 104))
							(gEgo setHeading: 0 self)
						)
						(
							(or
								(and
									(== (gEgo x:) 215)
									(== (gEgo y:) 104)
								)
								(and
									(== (gEgo x:) 198)
									(== (gEgo y:) 104)
								)
							)
							(if (and (IsFlag 159) (not (IsFlag 208)))
								(= cycles 1)
							else
								(gEgo setHeading: 90 self 20)
							)
						)
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 135 self)
						)
						((and (== (gEgo x:) 225) (== (gEgo y:) 120))
							(gEgo setHeading: 315 self)
						)
						((and (== (gEgo x:) 225) (== (gEgo y:) 120))
							(gEgo setHeading: 0 self)
						)
						(else
							(gEgo setHeading: 45 self)
						)
					)
				)
				(1
					(if (IsFlag 159)
						(proc1111_8)
						(gCurRoom drawPic: 5305)
						(DoRobot 2110 76 13 gEgo -1 1)
					else
						(self cue:)
					)
				)
				(2
					(if (IsFlag 159)
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
					(if (IsFlag 159)
						(gCurRoom newRoom: 6500)
					else
						(gCurRoom newRoom: 5500)
					)
				)
			)
		)
	)
)

(instance fromChapelScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 2241 -8 57)
				)
				(1
					(self dispose:)
				)
			)
		else
			(if (and (IsFlag 52) (== gChapter 4))
				(harriet
					posn: 234 126
					view: 5105
					setHotspot: 4 15 3 ; Do, invTarot, Move
					approachVerbs: 0
					setScale: 0
					setCycle: Fwd
					cycleSpeed: 10
					sightAngle: 26505
				)
			)
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(= global115 0)
		(magazine view: 5103 loop: 0 cel: 0 x: 162 y: 93)
		(if (and (IsFlag 52) (== gChapter 4))
			(harriet
				posn: 234 126
				view: 5105
				setHotspot: 4 15 3 ; Do, invTarot, Move
				approachVerbs: 0
				setScale: 0
				setCycle: Fwd
				cycleSpeed: 10
				sightAngle: 26505
			)
		)
		(gEgo show:)
		(gCurRoom drawPic: 5102)
		(gGame handsOn:)
		(super dispose:)
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
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 198)
									(== (gEgo y:) 104)
								)
								(and
									(== (gEgo x:) 215)
									(== (gEgo y:) 104)
								)
							)
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
							)
							(gEgo setHeading: 90 self 19)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(if (gCast contains: magazine)
						(magazine hide:)
					)
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(DoRobot 2029 0 0)
					(gCurRoom drawPic: 5610)
				)
				(2
					(DoRobot 2030 65 -13)
					(gCurRoom drawPic: 5350)
				)
				(3
					(gCurRoom drawPic: (if (IsFlag 159) 5102 else 5101))
					(gEgo normalize: 1 posn: 225 120)
					(if (gCast contains: magazine)
						(magazine show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(rightSouthExit init: 3)
					(leftSouthExit dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gCurRoom drawPic: (if (IsFlag 159) 5102 else 5101))
					(if (gCast contains: magazine)
						(magazine show:)
					)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(= global115 0)
					(rightSouthExit init: 3)
					(leftSouthExit dispose:)
					(gEgo show: normalize: 1 posn: 225 120)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookAtMag of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 215) (== (gEgo y:) 104))
							(if (== (gEgo heading:) 270)
								(self cue:)
							else
								(gEgo setHeading: 180 self)
							)
						)
						(register
							(gEgo hide:)
							(self cue:)
						)
						((and (== (gEgo x:) 198) (== (gEgo y:) 104))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 0 self)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 99))
							(gEgo setHeading: 0 self)
						)
						((and (== (gEgo x:) 197) (== (gEgo y:) 104))
							(gEgo setHeading: 180 self)
						)
						((and (<= (gEgo y:) 87) (>= (gEgo x:) 140))
							(gEgo setHeading: 180 self)
						)
						(else
							(gEgo setHeading: 335 self)
						)
					)
				)
				(1
					(if (gCast contains: harriet)
						(harriet hide:)
					)
					(if (not register)
						(gCurRoom
							drawPic:
								(cond
									((IsFlag 159) 5322)
									((IsFlag 158) 5321)
									(else 5320)
								)
						)
					)
					(magazine hide:)
					(DoRobot 2040 151 19 gEgo 120)
				)
				(2
					(KillRobot)
					(gEgo hide:)
					(bigMag init:)
					(gCurRoom drawPic: 5330)
					(global114 pause:)
					(voiceOver number: 5011 setLoop: 1 play: self)
				)
				(3
					(global114 endPause:)
					(voiceOver dispose:)
					(= seconds 2)
				)
				(4
					(bigMag dispose:)
					(gCurRoom
						drawPic:
							(cond
								((IsFlag 159) 5322)
								((IsFlag 158) 5321)
								(else 5320)
							)
					)
					(DoRobot 2041 160 28 gEgo 200)
				)
				(5
					(magazine show:)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(gEgo show: normalize: 1 posn: 215 104)
					(rightSouthExit init: 3)
					(leftSouthExit dispose:)
					(gCurRoom picture: (if (IsFlag 159) 5102 else 5101))
					(gCurRoom drawPic: (gCurRoom picture:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(global114 endPause: 1)
					(ClearFlag 248)
					(= global115 0)
					(if (Sounds contains: voiceOver)
						(voiceOver dispose:)
					)
					(magazine show:)
					(if (gCast contains: bigMag)
						(bigMag dispose:)
					)
					(gEgo show: normalize: 1 posn: 215 104)
					(if (gCast contains: harriet)
						(harriet show:)
					)
					(rightSouthExit init: 3)
					(leftSouthExit dispose:)
					(if (IsFlag 159)
						(gCurRoom drawPic: 5102)
					else
						(gCurRoom drawPic: 5101)
					)
					(gGame handsOn:)
					(self dispose:)
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
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 198)
									(== (gEgo y:) 104)
								)
								(and
									(== (gEgo x:) 215)
									(== (gEgo y:) 104)
								)
							)
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
							)
							(gEgo setHeading: 90 self 19)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(magazine hide:)
					(harriet hide:)
					(gEgo put: 9) ; invTarot
					(SetFlag 179)
					(DoRobot 4251 -22 -32)
					(gCurRoom drawPic: 5610)
				)
				(2
					(magazine show:)
					(harriet show:)
					(gEgo
						normalize: 1
						posn: 225 120
						cel: 0
						setCycle: End self
					)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gCurRoom picture: (if (IsFlag 159) 5102 else 5101))
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
					(KillRobot)
					(= global115 0)
					(magazine show:)
					(harriet show:)
					(gEgo normalize: 1 posn: 225 120)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gCurRoom picture: (if (IsFlag 159) 5102 else 5101))
					(gCurRoom drawPic: (gCurRoom picture:))
					(KillRobot)
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
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 198)
									(== (gEgo y:) 104)
								)
								(and
									(== (gEgo x:) 215)
									(== (gEgo y:) 104)
								)
							)
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
							)
							(gEgo setHeading: 90 self 19)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(magazine hide:)
					(harriet hide:)
					(DoRobot 4300 -13 -48)
					(gCurRoom drawPic: 5610)
				)
				(2
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo
						normalize: 1
						posn: 225 120
						cel: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 5102)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo normalize: 1 posn: 225 120)
					(gCurRoom picture: (if (IsFlag 159) 5102 else 5101))
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
						((and (== (gEgo x:) 163) (== (gEgo y:) 83))
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 198)
									(== (gEgo y:) 104)
								)
								(and
									(== (gEgo x:) 215)
									(== (gEgo y:) 104)
								)
							)
							(gEgo setHeading: 180 self 19)
						)
						(
							(or
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
								(and
									(== (gEgo x:) 225)
									(== (gEgo y:) 120)
								)
							)
							(gEgo setHeading: 90 self 19)
						)
						((and (== (gEgo x:) 95) (== (gEgo y:) 104))
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(magazine hide:)
					(harriet hide:)
					(DoRobot 4310 -9 -42)
					(gCurRoom drawPic: 5610)
				)
				(2
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo
						normalize: 1
						posn: 225 120
						cel: 15
						setCycle: End self
					)
					(gCurRoom picture: (if (IsFlag 159) 5102 else 5101))
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
					(KillRobot)
					(magazine show:)
					(harriet show:)
					(leftSouthExit init: 3)
					(rightSouthExit dispose:)
					(gEgo normalize: 1 posn: 225 120)
					(gCurRoom picture: (if (IsFlag 159) 5102 else 5101))
					(gCurRoom drawPic: (gCurRoom picture:))
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance voiceOver of Sound
	(properties)
)

(instance harriet of Prop
	(properties
		approachX 234
		approachY 126
		x 239
		y 126
		view 5105
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0 setPri: 130)
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

(instance bigMag of View
	(properties
		x -1
		y 130
		view 5335
	)
)

(instance magazine of View
	(properties
		x 162
		y 93
		view 5103
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sLookAtMag 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magazineFea of Feature
	(properties
		nsLeft 152
		nsTop 89
		nsRight 183
		nsBottom 101
		approachX 166
		approachY 95
		x 167
		y 95
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

(instance desk of Feature
	(properties
		nsLeft 146
		nsTop 65
		nsRight 180
		nsBottom 80
		approachX 163
		approachY 77
		x 158
		y 70
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: toDeskScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance books of Feature
	(properties
		nsLeft 264
		nsTop 32
		nsRight 298
		nsBottom 88
		approachX 246
		approachY 127
		x 283
		y 88
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

(instance fireplace of Feature
	(properties
		noun 1
		nsLeft 211
		nsTop 59
		nsRight 241
		nsBottom 105
		approachX 219
		approachY 101
		x 226
		y 105
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 10 11 35) ; Do, invPoker, invHammer, ???
			(gGame handsOff:)
			(gCurRoom setScript: toFireplaceScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance libDoors of ExitFeature
	(properties
		nsLeft 39
		nsTop 31
		nsRight 60
		nsBottom 97
		approachX 60
		approachY 102
		nextRoom 3400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fireplaceExit of ExitFeature
	(properties
		nsLeft 211
		nsTop 59
		nsRight 241
		nsBottom 105
		approachX 219
		approachY 101
		nextRoom 6500
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: toFireplaceScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rightSouthExit of ExitFeature
	(properties
		nsLeft 200
		nsTop 115
		approachX 212
		approachY 128
		nextRoom 5600
		interRoom 11
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: toRightSouthScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leftSouthExit of ExitFeature
	(properties
		nsTop 115
		nsRight 100
		nextRoom 5600
		interRoom 12
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: toLeftSouthScr)
		else
			(super doVerb: theVerb)
		)
	)
)

