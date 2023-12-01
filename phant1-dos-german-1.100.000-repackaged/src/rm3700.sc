;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3700)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm3700 0
)

(local
	local0
	local1 = 1
)

(instance rm3700 of ScaryRoom
	(properties
		picture 3700
		stepSound 7
	)

	(method (notify)
		((ScriptID 0 14) dispose:) ; exitButt
		(gGame handsOff:)
		(proc1111_9)
		(= local0 0)
		(gCurRoom setScript: sLeaveBottle)
	)

	(method (init)
		(KillRobot)
		(gEgo init: setScaler: Scaler 66 30 129 88 normalize:)
		((ScriptID 30) init:) ; FidgetCode
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(3800
				(if (== global125 11)
					(gEgo posn: 87 103 normalize: 4)
					(= global125 14)
				else
					(gEgo posn: 37 98 normalize: 5)
					(= global125 13)
				)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(4200
				(gEgo posn: 232 108 normalize: 7)
				(= global125 18)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(3200
				(switch global125
					(5
						(gEgo posn: 161 117 normalize: 7)
						(= global125 16)
					)
					(6
						(gEgo posn: 161 117 normalize: 6)
						(= global125 16)
					)
					(7
						(gEgo posn: 161 117 normalize: 6)
						(= global125 16)
					)
					(8
						(gEgo posn: 161 117 normalize: 6)
						(= global125 16)
					)
					(9
						(gEgo posn: 87 103 normalize: 6)
						(= global125 14)
					)
					(10
						(gEgo posn: 37 98 normalize: 6)
						(= global125 13)
					)
				)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo posn: 185 96 normalize: 2)
				(= global125 17)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(if (IsFlag 15)
			(theatre init: 1 approachVerbs: 0)
			(theatreDoors init:)
		else
			(theatreDoors setHotspot: 4 3 8 7 init:) ; Do, Move, invLibKey, invNail
		)
		(harpsichord init: 1 approachVerbs: 0)
		(eastExit init: 2 approachVerbs: 0)
		(southeastExit init: 11 approachVerbs: 0)
		(southExit init: 3 approachVerbs: 0)
		(southwestExit init: 12 approachVerbs: 0)
		(if
			(or
				(and (== gChapter 1) (not (IsFlag 397)))
				(and (== gChapter 2) (not (IsFlag 398)))
				(and (== gChapter 3) (not (IsFlag 399)))
				(and (== gChapter 4) (not (IsFlag 400)))
				(and (== gChapter 5) (not (IsFlag 401)))
				(and
					(== gChapter 6)
					(not (IsFlag 402))
					(or
						(IsFlag 397)
						(IsFlag 398)
						(IsFlag 399)
						(IsFlag 400)
						(IsFlag 401)
					)
				)
			)
			(bar setHotspot: 4 3 init:) ; Do, Move
		)
		(super init:)
		(if (not (IsFlag 376))
			(gGDacSound number: 2010 init: setVol: 37 setLoop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 3760 3800 3200 3700 4200 900))
			(gGDacSound stop:)
			(if (not global184)
				(global114 endPause:)
			)
			(ClearFlag 376)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(if (and (not (global114 script:)) (gCast contains: keys))
			(keys dispose:)
		)
		(super doit: &rest)
	)
)

(instance sWrongKey of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(17
							(self changeState: 1)
						)
						(18
							(gEgo setHeading: 315 self)
						)
						(15
							(gEgo setHeading: 135 self)
						)
						(16
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(theatreDoors hide:)
					(DoRobot 1960 98 33)
					(gCurRoom drawPic: 3870)
				)
				(2
					(theatreDoors show:)
					(gEgo posn: 185 96 normalize: 6)
					(= global125 17)
					(gCurRoom drawPic: 3700)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(theatreDoors show:)
					(gEgo posn: 185 96 normalize: 6)
					(= global125 17)
					(gCurRoom drawPic: 3700)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTryNail of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(17
							(self changeState: 1)
						)
						(18
							(gEgo setHeading: 315 self)
						)
						(15
							(gEgo setHeading: 135 self)
						)
						(16
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(theatreDoors hide:)
					(DoRobot 3520 120 29)
					(gCurRoom drawPic: 3870)
				)
				(2
					(gEgo posn: 185 96 normalize: 6)
					(= global125 17)
					(gCurRoom drawPic: 3700)
					(theatreDoors show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(theatreDoors show:)
					(gEgo posn: 185 96 normalize: 6)
					(= global125 17)
					(gCurRoom drawPic: 3700)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTryDoors of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(17
							(self changeState: 1)
						)
						(18
							(gEgo setHeading: 315 self)
						)
						(16
							(gEgo setHeading: 45 self)
						)
						(15
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(SetFlag 93)
					(theatreDoors hide:)
					(DoRobot 420 118 33)
					(gCurRoom drawPic: 3870)
				)
				(2
					(gEgo posn: 185 96 normalize: 6)
					(= global125 17)
					(theatreDoors show:)
					(gCurRoom drawPic: 3700)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 93)
					(gEgo posn: 185 96 normalize: 6)
					(= global125 17)
					(theatreDoors show:)
					(gCurRoom drawPic: 3700)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookAtBottle of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(15
							(gEgo setHeading: 0 self 10)
						)
						(13
							(gEgo setHeading: 45 self)
						)
						(14
							(gEgo setHeading: 45 self)
						)
						(16
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if
						(and
							(global114 script:)
							(not (IsFlag 376))
							(not global184)
						)
						(keys init: setCycle: RandCycle)
					)
					(crank init:)
					(theatreDoors hide:)
					(tdoors init:)
					(DoRobot 460 105 9)
					(gCurRoom drawPic: 3880)
				)
				(2
					(tdoors dispose:)
					(= local0 1)
					(if (gCast contains: keys)
						(keys dispose:)
					)
					(proc1111_8)
					(crank hide:)
					(cond
						((not (IsFlag 392))
							(bottle
								view: 461
								posn: 67 125
								init:
								setHotspot: 4 3 ; Do, Move
							)
							(Load 140 3018) ; WAVE
						)
						((not (IsFlag 393))
							(bottle
								view: 461
								posn: 67 125
								init:
								setHotspot: 4 3 ; Do, Move
							)
							(Load 140 3022) ; WAVE
						)
						((not (IsFlag 394))
							(bottle
								view: 3140
								posn: 58 126
								init:
								setHotspot: 4 3 ; Do, Move
							)
							(if (== gChapter 5)
								(Load 140 3043) ; WAVE
							else
								(Load 140 3034) ; WAVE
							)
						)
						((not (IsFlag 395))
							(bottle
								view: 4160
								posn: 64 124
								init:
								setHotspot: 4 3 ; Do, Move
							)
							(Load 140 3043) ; WAVE
						)
						((not (IsFlag 396))
							(bottle
								view: 3140
								posn: 58 126
								init:
								setHotspot: 4 3 ; Do, Move
							)
							(Load 140 3053) ; WAVE
						)
					)
					(gCurRoom drawPic: 3740)
					(gGame handsOn: 0)
					((ScriptID 0 14) init:) ; exitButt
					(SetFlag 248)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(theatreDoors hide:)
			(if (gCast contains: keys)
				(keys dispose:)
			)
			(crank init: hide:)
			(if (not local0)
				(= local0 1)
				(proc1111_8)
			)
			(cond
				((not (IsFlag 392))
					(bottle view: 461 posn: 67 125 init: setHotspot: 4 3) ; Do, Move
					(Load 140 3018) ; WAVE
				)
				((not (IsFlag 393))
					(bottle view: 461 posn: 67 125 init: setHotspot: 4 3) ; Do, Move
					(Load 140 3022) ; WAVE
				)
				((not (IsFlag 394))
					(bottle view: 3140 posn: 58 126 init: setHotspot: 4 3) ; Do, Move
					(if (== gChapter 5)
						(Load 140 3043) ; WAVE
					else
						(Load 140 3034) ; WAVE
					)
				)
				((not (IsFlag 395))
					(bottle view: 4160 posn: 64 124 init: setHotspot: 4 3) ; Do, Move
					(Load 140 3043) ; WAVE
				)
				((not (IsFlag 396))
					(bottle view: 3140 posn: 58 126 init: setHotspot: 4 3) ; Do, Move
					(Load 140 3053) ; WAVE
				)
			)
			(gCurRoom drawPic: 3740)
			(gGame handsOn: 0)
			((ScriptID 0 14) init:) ; exitButt
			(SetFlag 248)
			(self dispose:)
		)
	)
)

(instance sPickUpBottle of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(ClearFlag 248)
					(gGame handsOff:)
					(proc1111_9)
					(= local0 0)
					(cond
						((not (IsFlag 392))
							(bottle view: 461 posn: 67 125 init:)
							(DoRobot 461 -11 -40)
						)
						((not (IsFlag 393))
							(bottle view: 461 posn: 67 125 init:)
							(DoRobot 461 -11 -40)
						)
						((not (IsFlag 394))
							(bottle view: 3140 posn: 58 126 init:)
							(DoRobot 3140 24 0)
						)
						((not (IsFlag 395))
							(bottle view: 4160 posn: 64 124 init:)
							(DoRobot 4160 11 -41)
						)
						((not (IsFlag 396))
							(bottle view: 3140 posn: 58 126 init:)
							(DoRobot 3140 24 0)
						)
					)
				)
				(1
					(bottle hide:)
				)
				(2
					(gEgo hide:)
					(switch gChapter
						(1
							(bottle show: view: 3759 posn: 164 130)
							(gCurRoom drawPic: 3750)
						)
						(2
							(bottle view: 3754 posn: 0 130 init:)
							(gCurRoom drawPic: 3750)
						)
						(3
							(bottle view: 3755 posn: 0 130 init:)
							(gCurRoom drawPic: 3750)
						)
						(4
							(bottle view: 3756 posn: 0 130 init:)
							(gCurRoom drawPic: 3750)
						)
						(5
							(bottle view: 3757 posn: 0 133 init:)
							(gCurRoom drawPic: 3750)
						)
					)
					(cond
						((not (IsFlag 392))
							(voiceOver number: 3018 setLoop: 1 play: self)
						)
						((not (IsFlag 393))
							(voiceOver number: 3022 setLoop: 1 play: self)
						)
						((not (IsFlag 394))
							(if (== gChapter 5)
								(voiceOver number: 3043 setLoop: 1 play: self)
							else
								(voiceOver number: 3034 setLoop: 1 play: self)
							)
						)
						((not (IsFlag 395))
							(voiceOver number: 3043 setLoop: 1 play: self)
						)
						((not (IsFlag 396))
							(voiceOver number: 3053 setLoop: 1 play: self)
						)
					)
				)
				(3
					(voiceOver dispose:)
					(cond
						((not (IsFlag 392))
							(bottle hide: view: 462 posn: 65 125)
							(DoRobot 462 2 -44 gEgo -1 1)
						)
						((not (IsFlag 393))
							(bottle hide: view: 462 posn: 65 125)
							(DoRobot 462 2 -44 gEgo -1 1)
						)
						((not (IsFlag 394))
							(bottle hide: view: 3141 posn: 67 124)
							(DoRobot 3141 31 0 gEgo -1 1)
						)
						((not (IsFlag 395))
							(bottle hide: view: 4161 posn: 65 126)
							(global114 pause:)
							(DoRobot 4161 37 -38 gEgo -1 1)
						)
						((not (IsFlag 396))
							(bottle hide: view: 3141 posn: 67 124)
							(DoRobot 3141 31 0 gEgo -1 1)
						)
					)
					(gCurRoom drawPic: 3740)
				)
				(4
					(bottle show:)
				)
				(5
					(cond
						((not (IsFlag 392))
							(SetFlag 392)
						)
						((not (IsFlag 393))
							(SetFlag 393)
						)
						((not (IsFlag 394))
							(SetFlag 394)
						)
						((not (IsFlag 395))
							(global114 endPause:)
							(SetFlag 395)
						)
						((not (IsFlag 396))
							(SetFlag 396)
						)
					)
					(switch gChapter
						(1
							(SetFlag 397)
						)
						(2
							(SetFlag 398)
						)
						(3
							(SetFlag 399)
						)
						(4
							(SetFlag 400)
						)
						(5
							(SetFlag 401)
						)
						(6
							(SetFlag 402)
						)
					)
					(gCurRoom setScript: sLeaveBottle)
				)
			)
		else
			(cond
				((not (IsFlag 392))
					(SetFlag 392)
				)
				((not (IsFlag 393))
					(SetFlag 393)
				)
				((not (IsFlag 394))
					(SetFlag 394)
				)
				((not (IsFlag 395))
					(global114 endPause: 1)
					(SetFlag 395)
				)
				((not (IsFlag 396))
					(SetFlag 396)
				)
			)
			(switch gChapter
				(1
					(SetFlag 397)
				)
				(2
					(SetFlag 398)
				)
				(3
					(SetFlag 399)
				)
				(4
					(SetFlag 400)
				)
				(5
					(SetFlag 401)
				)
				(6
					(SetFlag 402)
				)
			)
			(if local0
				(= local0 0)
				(proc1111_9)
			)
			(gCurRoom setScript: sLeaveBottle)
		)
	)
)

(instance sLeaveBottle of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(KillRobot)
					(ClearFlag 248)
					(if
						(and
							(global114 script:)
							(not (IsFlag 376))
							(not global184)
						)
						(keys init: setCycle: RandCycle)
					)
					(crank show:)
					(bottle dispose:)
					(tdoors init:)
					(gEgo
						show:
						posn: 132 60
						view: 7002
						cel: 0
						loop: 0
						setCycle: End self
						setScaler: Scaler 120 55 119 57
					)
					(gCurRoom drawPic: 3880)
				)
				(1
					(tdoors dispose:)
					(if (gCast contains: keys)
						(keys dispose:)
					)
					(crank dispose:)
					(gEgo
						normalize: 2
						posn: 112 93
						setScaler: Scaler 66 30 129 88
						cel: 0
						setCycle: End self
					)
					(= global125 15)
					(theatreDoors show:)
					(gCurRoom drawPic: 3700)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gEgo setCycle: 0)
			(ClearFlag 248)
			(if (gCast contains: tdoors)
				(tdoors dispose:)
			)
			(if (gCast contains: crank)
				(crank dispose:)
			)
			(if (gCast contains: keys)
				(keys dispose:)
			)
			(if (Sounds contains: voiceOver)
				(voiceOver dispose:)
			)
			(bottle dispose:)
			(gEgo
				show:
				normalize: 2
				posn: 112 93
				setScaler: Scaler 66 30 129 88
			)
			(= global125 15)
			(theatreDoors show:)
			(gCurRoom drawPic: 3700)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sBottleGone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(15
							(gEgo setHeading: 0 self)
						)
						(13
							(gEgo setHeading: 45 self)
						)
						(14
							(gEgo setHeading: 45 self)
						)
						(16
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(if
						(and
							(global114 script:)
							(not (IsFlag 376))
							(not global184)
						)
						(keys init: setCycle: RandCycle)
					)
					(crank init:)
					(theatreDoors hide:)
					(tdoors init:)
					(DoRobot 460 105 9)
					(gCurRoom drawPic: 3880)
				)
				(2
					(tdoors hide:)
					(crank hide:)
					(if (gCast contains: keys)
						(keys dispose:)
					)
					(DoRobot 5410 27 -39)
					(gCurRoom drawPic: 3740)
				)
				(3
					(if
						(and
							(global114 script:)
							(not (IsFlag 376))
							(not global184)
						)
						(keys init: setCycle: RandCycle)
					)
					(crank show:)
					(gEgo
						show:
						posn: 132 60
						view: 7002
						cel: 0
						loop: 0
						setCycle: End self
						setScaler: Scaler 120 55 119 57
					)
					(tdoors show:)
					(gCurRoom drawPic: 3880)
				)
				(4
					(tdoors dispose:)
					(if (gCast contains: keys)
						(keys dispose:)
					)
					(crank dispose:)
					(gEgo
						normalize: 2
						posn: 112 93
						setScaler: Scaler 66 30 129 88
						cel: 0
						setCycle: End self
					)
					(= global125 15)
					(theatreDoors show:)
					(gCurRoom drawPic: 3700)
				)
				(5
					(SetFlag 402)
					(bar dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(SetFlag 402)
			(bar dispose:)
			(if (gCast contains: tdoors)
				(tdoors dispose:)
			)
			(if (gCast contains: crank)
				(crank dispose:)
			)
			(if (gCast contains: keys)
				(keys dispose:)
			)
			(bottle dispose:)
			(gEgo
				show:
				normalize: 2
				posn: 112 93
				setScaler: Scaler 66 30 129 88
			)
			(= global125 15)
			(theatreDoors show:)
			(gCurRoom drawPic: 3700)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sExitHarpy of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(13
							(gEgo setHeading: 45 self)
						)
						(14
							(gEgo setHeading: 0 self)
						)
						(16
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 3800)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3800)
		)
	)
)

(instance sExitTheater of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(17
							(gEgo setHeading: 0 self)
						)
						(18
							(gEgo setHeading: 315 self)
						)
						(16
							(gEgo setHeading: 45 self)
						)
						(15
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(= global125 0)
					(gCurRoom newRoom: 8200)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 8200)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(17
							(gEgo setHeading: 135 self)
						)
						(15
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(+= global125 200)
					(gCurRoom newRoom: 4200)
				)
			)
		else
			(= global115 0)
			(if (< global125 200)
				(+= global125 200)
			)
			(gCurRoom newRoom: 4200)
		)
	)
)

(instance sExitSouthEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 135 self)
				)
				(1
					(+= global125 240)
					(gCurRoom newRoom: 4200)
				)
			)
		else
			(= global115 0)
			(if (< global125 240)
				(+= global125 240)
			)
			(gCurRoom newRoom: 4200)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(16
							(gEgo setHeading: 225 self)
						)
						(17
							(gEgo setHeading: 225 self)
						)
						(18
							(gEgo setHeading: 225 self)
						)
						(13
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(+= global125 280)
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(= global115 0)
			(if (< global125 280)
				(+= global125 280)
			)
			(gCurRoom newRoom: 3200)
		)
	)
)

(instance sExitSouthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(17
							(gEgo setHeading: 270 self)
						)
						(18
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(+= global125 320)
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(= global115 0)
			(if (< global125 320)
				(+= global125 320)
			)
			(gCurRoom newRoom: 3200)
		)
	)
)

(instance voiceOver of Sound
	(properties)
)

(instance keys of Prop
	(properties
		x 40
		y 87
		priority 200
		fixPriority 1
		view 3880
	)
)

(instance tdoors of View
	(properties
		x 171
		priority 1
		fixPriority 1
		view 3882
	)

	(method (init)
		(if (> gChapter 5)
			(super init: &rest)
		)
	)
)

(instance crank of View
	(properties
		x 151
		y 80
		priority 200
		fixPriority 1
		view 520
	)
)

(instance bottle of View
	(properties
		x 67
		y 127
		view 3740
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			((ScriptID 0 14) dispose:) ; exitButt
			(bottle setHotspot: 0)
			(bar dispose:)
			(gCurRoom setScript: sPickUpBottle)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theatreDoors of View
	(properties
		x 191
		y 92
		view 3700
	)

	(method (init)
		(if (IsFlag 15)
			(self cel: 1)
		else
			(self cel: 0)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sTryDoors)
			)
			(8 ; invLibKey
				(gGame handsOff:)
				(gCurRoom setScript: sWrongKey)
			)
			(7 ; invNail
				(SetFlag 186)
				(gGame handsOff:)
				(gCurRoom setScript: sTryNail)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bar of Feature
	(properties
		nsLeft 105
		nsTop 77
		nsRight 147
		nsBottom 94
		approachX 110
		approachY 90
		x 144
		y 110
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(switch gChapter
				(6
					(gGame handsOff:)
					(gCurRoom setScript: sBottleGone)
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: sLookAtBottle)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance harpsichord of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 85 105 86 105 96 86 100 62 100 35 93
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitHarpy)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theatre of ExitFeature
	(properties
		nsLeft 175
		nsTop 60
		nsRight 200
		nsBottom 91
		x 228
		y 93
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitTheater)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southwestExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 23 94 0 98 0 129 34 129 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 120 31 120 35 129 142 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouth)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 120 142 120 142 129 252 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthEast)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance eastExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 94 292 95 292 129 253 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitEast)
		else
			(super doVerb: theVerb)
		)
	)
)

