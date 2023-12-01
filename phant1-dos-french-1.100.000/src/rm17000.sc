;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17000)
(include sci.sh)
(use Main)
(use movieScr)
(use scaryInvInit)
(use ExitFeature)
(use n1111)
(use Print)
(use Scaler)
(use Osc)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm17000 0
)

(local
	local0
	local1
)

(instance rm17000 of ScaryRoom
	(properties
		picture 17430
		stepSound 4
	)

	(method (init)
		(KillRobot)
		(gUser canControl: 1)
		(gEgo init: setScaler: Scaler 139 65 140 103 normalize: hide:)
		((ScriptID 30) init:) ; FidgetCode
		(cond
			((and (== gChapter 1) (IsFlag 53) (not (IsFlag 78)))
				(= local1 1)
			)
			((and (not (IsFlag 324)) (== gChapter 3))
				(= local1 1)
			)
		)
		(if (and (IsFlag 247) (== gChapter 4))
			(SetFlag 3)
			(harriet init: setHotspot: 4 3 15 ignoreActors: 1) ; Do, Move, invTarot
		)
		(doorView init:)
		(switch gPrevRoomNum
			(900
				(gEgo show:)
				(if (IsFlag 226)
					(gEgo view: 2 posn: 240 127 hide:)
					(= picture -1)
					(gGame fadeSpeed: 4)
					(SetFlag 370)
					(gCurRoom setScript: sChapter7)
				else
					(if (and (not (gEgo x:)) (not (gEgo y:)))
						(gEgo view: 2 posn: 240 127 show:)
					)
					(gGame handsOn:)
				)
				(proc28_2)
			)
			(44 ; chapEndRm
				(proc28_2)
				(gEgo view: 2 posn: 240 127 hide:)
				(= picture -1)
				(gGame fadeSpeed: 4)
				(gCurRoom setScript: sChapter7)
			)
			(17100
				(switch global125
					(10
						(gEgo
							posn: 89 145
							show:
							setScaler: Scaler 139 65 140 103
							normalize: 3
						)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(52
						(gEgo view: 3 posn: 240 127 show:)
						(gCurRoom setScript: fromFadeScr)
					)
					(else
						(gEgo view: 3 posn: 240 127 show:)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
				(= global125 0)
			)
			(28700
				(gEgo view: 2 posn: 181 122 show:)
				(self setScript: endChap6Scr)
			)
			(17205
				(photo init:)
				(= picture 17000)
				(if (IsFlag 71)
					(gEgo view: 1341)
				else
					(gEgo view: 1342)
				)
				(gEgo
					posn: 120 84
					setCel: 0
					setScale: 0
					setLoop: 0
					setCycle: 0
					show:
				)
				(gCurRoom setScript: sPutInPocket)
			)
			(else
				(gGame handsOn:)
				(gEgo view: 2 posn: 173 106 show:)
				(gCurRoom setScript: sComeIn)
			)
		)
		(southExit init: 3)
		(door init: 1)
		(if (not (IsFlag 71))
			(dresser init: setHotspot: 4 3) ; Do, Move
		)
		(theTVDesk init: setHotspot: 4 3) ; Do, Move
		(super init:)
		(if
			(and
				(!= gPrevRoomNum 15300)
				(!= script sChapter7)
				(not (gCast contains: harriet))
			)
			(gGDacSound number: 17013 setLoop: -1 play:)
		)
		(gGame fadeSpeed: 100)
	)

	(method (dispose)
		(turnSnd dispose:)
		(Lock 140 17013 0) ; WAVE
		(staticSnd dispose:)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 17100) (!= newRoomNumber 17205))
			(ClearFlag 326)
		)
		(if (!= newRoomNumber 900)
			(gGDacSound stop:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance suitcase of View
	(properties
		x 73
		y 80
		view 17004
	)
)

(instance fromFadeScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(self setScript: (ScriptID 0 5) self 5) ; takeLastStep
				)
				(1
					(gGame fade: 0 (gGame intensity:) 1)
					(= seconds 2)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gGame fade: 0 (gGame intensity:) 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTo17100 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (== (gEgo x:) 89) (== (gEgo y:) 145))
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(gCurRoom newRoom: 17100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 17100)
				)
			)
		)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 320)
					(self setScript: (ScriptID 0 5) self 10) ; takeLastStep
					(= cycles 1)
				)
				(1
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
				)
				(2
					(gGame handsOff:)
					(cond
						(
							(and
								(not (IsFlag 77))
								(> global172 2)
								(IsFlag 53)
								(== gChapter 1)
							)
							(gCurRoom newRoom: 17100)
						)
						((and (not (IsFlag 324)) (== gChapter 3))
							(gCurRoom newRoom: 17100)
						)
						(else
							(gGame handsOn:)
							(self dispose:)
						)
					)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 320)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(= global115 0)
					(cond
						(
							(and
								(not (IsFlag 77))
								(> global172 2)
								(IsFlag 53)
								(== gChapter 1)
							)
							(gCurRoom newRoom: 17100)
						)
						((and (not (IsFlag 324)) (== gChapter 3))
							(gCurRoom newRoom: 17100)
						)
						(else
							(gGame handsOn:)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance sGoToHallway of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((and (== (gEgo x:) 214) (== (gEgo y:) 105))
							(gEgo setHeading: 270 self)
						)
						((and (== (gEgo x:) 89) (== (gEgo y:) 145))
							(gEgo setHeading: 45 self)
						)
						(
							(or
								(== gPrevRoomNum 17100)
								(and
									(== (gEgo x:) 240)
									(== (gEgo y:) 127)
								)
							)
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(if (and (== gChapter 3) (IsFlag 246))
						(SetFlag 328)
					)
					(gCurRoom newRoom: 15300)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (and (== gChapter 3) (IsFlag 246))
						(SetFlag 328)
					)
					(= global115 0)
					(gCurRoom newRoom: 15300)
				)
			)
		)
	)
)

(instance sDoTV of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 17011) ; WAVE
					(Load 140 17012) ; WAVE
					(cond
						((and (== (gEgo x:) 214) (== (gEgo y:) 105))
							(= cycles 1)
						)
						((and (== (gEgo x:) 240) (== (gEgo y:) 127))
							(gEgo setHeading: 0 self)
						)
						((== (gEgo x:) 89)
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(doorView view: 17003 posn: 198 85)
					(if (== gChapter 7)
						(suitcase init: setPri: 200)
					)
					(if local1
						(donProp init:)
					)
					(if (gCast contains: harriet)
						(harriet view: 17002 posn: 137 95)
					)
					(photo init:)
					(gCurRoom drawPic: 17000)
					(gEgo
						view: 1370
						setLoop: 0
						setCel: 0
						setScale: 0
						posn: 255 93
						setPri: 100
						cycleSpeed: 8
						setCycle: CT 14 1 self
					)
				)
				(2
					(gGDacSound stop:)
					(staticSnd loop: -1 play:)
					(turnSnd loop: 1 play:)
					(static init: setCycle: Fwd)
					(gEgo
						view: 1370
						setCel: 14
						setPri: 100
						setCycle: CT 85 1 self
					)
				)
				(3
					(staticSnd stop:)
					(static dispose:)
					(turnSnd loop: 1 play:)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(gEgo setCel: 85 setCycle: End self)
				)
				(4
					(if local1
						(donProp dispose:)
					)
					(if (gCast contains: harriet)
						(harriet view: 17431 posn: 180 131 show:)
					)
					(if (== gChapter 7)
						(suitcase dispose:)
					)
					(doorView view: 17006 posn: 145 104)
					(photo dispose:)
					(gCurRoom drawPic: 17430)
					(gEgo
						posn: 214 105
						setScaler: Scaler 139 65 140 103
						cycleSpeed:
						normalize: 3
					)
					(SetFlag 74)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(photo dispose:)
					(if (== gChapter 7)
						(suitcase dispose:)
					)
					(= global115 0)
					(SetFlag 74)
					(staticSnd stop:)
					(static dispose:)
					(if (not (gCast contains: harriet))
						(Lock 140 17013 1) ; WAVE
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(if (gCast contains: donProp)
						(donProp dispose:)
					)
					(doorView view: 17006 posn: 145 104)
					(gEgo
						posn: 214 105
						setScaler: Scaler 139 65 140 103
						cycleSpeed: 4
						normalize: 3
					)
					(if (gCast contains: harriet)
						(harriet view: 17431 posn: 180 131 show:)
					)
					(gCurRoom drawPic: 17430)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDonDoIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(donProp setCycle: 0)
				(= seconds (Random 5 10))
			)
			(1
				(donProp setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sOpenDrawer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 10014) ; WAVE
					(cond
						((and (== (gEgo x:) 89) (== (gEgo y:) 145))
							(self cue:)
						)
						((and (== (gEgo x:) 240) (== (gEgo y:) 127))
							(= register 1)
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(if local1
						(donProp init:)
					)
					(doorView view: 17003 posn: 198 85)
					(photo init:)
					(gCurRoom drawPic: 17000)
					(gEgo
						setScale: 0
						view: 1340
						setCel: 0
						posn: 127 87
						setPri: 1
						setCycle: CT 23 1 self
					)
				)
				(2
					(gEgo view: 1340 setCel: 23 setCycle: End self)
					(drawerSnd play:)
				)
				(3
					(drawerSnd stop:)
					(gCurRoom newRoom: 17205)
				)
			)
		else
			(switch (= state newState)
				(0
					(drawerSnd stop:)
					(= global115 0)
					(gCurRoom newRoom: 17205)
				)
			)
		)
	)
)

(instance sPutInPocket of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 10014) ; WAVE
					(if local1
						(donProp init:)
					)
					(doorView view: 17003 posn: 198 85)
					(if (not (IsFlag 71))
						(drawerCSnd play:)
					)
					(= cycles 2)
				)
				(1
					(if (== (gEgo view:) 1341)
						(gEgo setCycle: CT 48 1 self)
					else
						(gEgo setCycle: CT 4 1 self)
					)
				)
				(2
					(if (== (gEgo view:) 1341)
						(gEgo setCel: 48)
					else
						(gEgo setCel: 4)
					)
					(if (IsFlag 71)
						(drawerCSnd play:)
					)
					(gEgo setCycle: End self)
				)
				(3
					(drawerCSnd stop:)
					(if local1
						(donProp dispose:)
					)
					(doorView view: 17006 posn: 145 104)
					(photo dispose:)
					(gCurRoom drawPic: 17430)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 1
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(drawerCSnd stop:)
					(photo dispose:)
					(gCurRoom drawPic: 17430)
					(if local1
						(donProp dispose:)
					)
					(doorView view: 17006 posn: 145 104)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 1
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkComputerScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (== (gEgo x:) 89)
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet hide:)
					(doorView hide:)
					(compute init:)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
					(DoRobot 4330 -38 -13)
				)
				(2
					(harriet show:)
					(doorView show:)
					(compute dispose:)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
					)
					(photo view: 17000 posn: 80 76 dispose:)
					(SetFlag 249)
					(gCurRoom drawPic: 17430)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(compute dispose:)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
					)
					(SetFlag 249)
					(doorView show:)
					(harriet show:)
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkHarrietScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (== (gEgo x:) 89)
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet hide:)
					(doorView hide:)
					(DoRobot 4340 -38 -13)
					(compute init:)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
				)
				(2
					(doorView show:)
					(harriet show:)
					(compute dispose:)
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(compute dispose:)
					(doorView show:)
					(harriet show:)
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGiveTarot of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (== (gEgo x:) 89)
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(gEgo hide:)
					(harriet hide:)
					(doorView hide:)
					(compute init:)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
					(DoRobot 4262 -38 -7 gEgo 200)
				)
				(2
					(compute dispose:)
					(harriet show:)
					(doorView show:)
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
						show:
					)
					(= cycles 2)
				)
				(3
					(gEgo put: 9) ; invTarot
					(SetFlag 179)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 179)
					(compute dispose:)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
						show:
					)
					(KillRobot)
					(doorView show:)
					(harriet show:)
					(gEgo put: 9) ; invTarot
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(= global115 0)
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
					(if (== (gEgo x:) 89)
						(gEgo setHeading: 90 self)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet hide:)
					(doorView hide:)
					(compute init:)
					(DoRobot 4320 -38 -17)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
				)
				(2
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
					)
					(harriet show:)
					(doorView show:)
					(compute dispose:)
					(SetFlag 153)
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(compute dispose:)
					(gEgo
						posn: 89 145
						setScaler: Scaler 139 65 140 103
						normalize: 0
					)
					(SetFlag 153)
					(harriet show:)
					(doorView show:)
					(photo view: 17000 posn: 80 76 dispose:)
					(gCurRoom drawPic: 17430)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance endChap6Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 121)
					(= cycles 2)
				)
				(1
					(gGDacSound stop:)
					(= cycles 2)
				)
				(2
					(ClearFlag 121)
					(doorView hide:)
					(gEgo hide:)
					(gCurRoom drawPic: -1)
					(= seconds 2)
				)
				(3
					(gEgo show:)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(doorView show:)
					(gCurRoom drawPic: 17430)
					(= seconds 2)
				)
				(4
					(gGame fadeSpeed: 4)
					(gCurRoom newRoom: 44) ; chapEndRm
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 121)
					(= global115 0)
					(gGame fadeSpeed: 4)
					(gCurRoom newRoom: 44) ; chapEndRm
				)
			)
		)
	)
)

(instance sChapter7 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 121)
					(gEgo hide:)
					(doorView hide: y: 1000)
					(PlayVMD 0 {5855.vmd}) ; Open
					(proc26_0 5855 self)
				)
				(1
					(= cycles 2)
				)
				(2
					(ClearFlag 121)
					(gCurRoom drawPic: 17430)
					(gEgo show: normalize: 3 setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(southExit approachVerbs: 0)
					(doorView y: 104 show:)
					(door approachVerbs: 0)
					(theTVDesk approachVerbs: 0)
					(global114 play: 9140)
					(if (IsFlag 226)
						(ClearFlag 226)
						(gGame save:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					0
					((ScriptID 26 1) caller: 0) ; movieScr
					(ClearFlag 121)
					(gCurRoom drawPic: 17430)
					(southExit approachVerbs: 0)
					(doorView y: 104 show:)
					(door approachVerbs: 0)
					(theTVDesk approachVerbs: 0)
					(global114 play: 9140)
					(= global115 0)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(if (IsFlag 226)
						(ClearFlag 226)
						(gGame save:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance harriet of Actor
	(properties
		sightAngle 360
		approachX 180
		approachY 126
		x 180
		y 131
		view 17431
	)

	(method (init)
		(super init: &rest)
		(gGDacSound number: 17045 setLoop: -1 play:)
		(self approachVerbs: 0 cycleSpeed: 8 setCycle: Osc)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; invTarot
				(gGame handsOff:)
				(gCurRoom setScript: sGiveTarot)
			)
			(4 ; Do
				(gGame handsOff:)
				(cond
					((and (IsFlag 176) (not (IsFlag 153)))
						(gCurRoom setScript: askBuildingScr)
					)
					((not (IsFlag 249))
						(gCurRoom setScript: talkComputerScr)
					)
					(else
						(gCurRoom setScript: talkHarrietScr)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance donProp of Prop
	(properties
		sightAngle 40
		x 45
		y 90
		view 17008
	)

	(method (init)
		(super init:)
		(self setPri: 125 setCycle: Fwd)
		(if (== gChapter 3)
			(if (IsFlag 328)
				(= view 17009)
			else
				(= view 17007)
			)
		else
			(self setScript: sDonDoIt)
		)
	)
)

(instance static of Prop
	(properties
		x 265
		y 78
		view 17001
	)

	(method (init)
		(super init:)
		(self setPri: 88 setCycle: Fwd)
	)
)

(instance compute of Prop
	(properties
		x 134
		y 79
		view 17410
	)
)

(instance doorView of View
	(properties
		x 145
		y 104
		view 17006
	)
)

(instance photo of View
	(properties
		x 80
		y 76
		view 17000
	)
)

(instance dresser of Feature
	(properties
		nsLeft 20
		nsTop 65
		nsRight 67
		nsBottom 129
		sightAngle 40
		approachX 21
		approachY 126
		x 43
		y 97
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 71)
				(Prints {You have taken all of your money})
			else
				(gCurRoom setScript: sOpenDrawer)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theTVDesk of Feature
	(properties
		nsLeft 209
		nsTop 73
		nsRight 228
		nsBottom 101
		sightAngle 40
		approachX 219
		approachY 97
		x 218
		y 87
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sDoTV)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 76
		nsTop 120
		nsRight 300
		sightAngle 360
		approachX 160
		approachY 120
		nextRoom 17100
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sTo17100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 148
		nsTop 44
		nsRight 189
		nsBottom 105
		sightAngle 40
		approachX 168
		approachY 71
		x 168
		y 71
		exitDir 1
		nextRoom 15300
	)

	(method (init)
		(super init:)
		(self approachVerbs: 0)
		(self exitDir: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sGoToHallway)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance turnSnd of Sound
	(properties
		number 17011
	)
)

(instance staticSnd of Sound
	(properties
		number 17012
	)
)

(instance drawerSnd of Sound
	(properties
		number 10014
	)
)

(instance drawerCSnd of Sound
	(properties
		number 10014
	)
)

