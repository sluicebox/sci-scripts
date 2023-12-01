;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17100)
(include sci.sh)
(use Main)
(use movieScr)
(use scaryInvInit)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Osc)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm17100 0
)

(local
	local0
	local1
)

(instance rm17100 of ScaryRoom
	(properties
		picture 17100
		stepSound 4
	)

	(method (notify)
		(ClearFlag 248)
		(gGame handsOff:)
		((ScriptID 0 14) dispose:) ; exitButt
		(proc1111_9)
		(switch gChapter
			(3
				(sDoComp3 cue:)
			)
			(5
				(sDoComp5 cue:)
			)
			(else
				(gCurRoom drawPic: 17100)
				(gEgo show:)
				(farCompute show:)
				(typing dispose:)
				(fire init: cycleSpeed: 10 setCycle: Fwd)
				(southExit init: 3)
				(gUser canControl: 1)
				(gGame handsOn:)
			)
		)
	)

	(method (init)
		(= local0 0)
		(photo init:)
		(gUser canControl: 1)
		(gEgo init: setScaler: Scaler 150 33 160 79 normalize:)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 4)
			(Load rsVIEW 17410)
		)
		(switch gPrevRoomNum
			(44 ; chapEndRm
				(gGame fadeSpeed: 4)
				(gGame handsOff:)
				(proc28_2)
				(ClearFlag 226)
				(gEgo normalize: 3 posn: 125 105 hide:)
				(if (== gChapter 2)
					(gGame handsOff:)
					(= picture -1)
					(farCompute hide:)
					(gEgo hide:)
					(fire hide:)
					(photo hide:)
					(if (< gVideoSpeed 425)
						(PlayVMD 0 {22905.vmd}) ; Open
					else
						(PlayVMD 0 {2290.vmd}) ; Open
					)
					(gCurRoom setScript: sBeginChapter2)
				else
					(gGame handsOff:)
					(= picture -1)
					(photo hide:)
					(farCompute hide:)
					(fire y: 1000 hide:)
					(gEgo hide:)
					(ClearFlag 264)
					(PlayVMD 0 {4840.vmd}) ; Open
					(gCurRoom setScript: sBeginChapter5)
				)
			)
			(900
				(if (IsFlag 226)
					(ClearFlag 226)
					(proc28_2)
					(gEgo normalize: 3 posn: 125 105 hide:)
					(if (and (== gChapter 1) (IsFlag 53) (not (IsFlag 78)))
						(donProp
							view: 17103
							approachVerbs: 4 3 ; Do, Move
							setHotspot: 4 3 ; Do, Move
							init:
						)
						(= local0 1)
					)
					(if (== gChapter 2)
						(= picture -1)
						(gGame handsOff:)
						(farCompute hide:)
						(gEgo hide:)
						(fire hide:)
						(photo hide:)
						(if (< gVideoSpeed 425)
							(PlayVMD 0 {22905.vmd}) ; Open
						else
							(PlayVMD 0 {2290.vmd}) ; Open
						)
						(gCurRoom setScript: sBeginChapter2)
					else
						(gGame handsOff:)
						(PlayVMD 0 {4840.vmd}) ; Open
						(= picture -1)
						(photo hide:)
						(farCompute hide:)
						(fire y: 1000 hide:)
						(gEgo hide:)
						(ClearFlag 264)
						(gCurRoom setScript: sBeginChapter5)
					)
				else
					(cond
						(
							(and
								(== gChapter 1)
								(not (IsFlag 77))
								(IsFlag 53)
								(not (IsFlag 78))
							)
							(gEgo posn: 148 125)
							(donProp
								view: 17103
								approachVerbs: 4 3 ; Do, Move
								setHotspot: 4 3 ; Do, Move
								init:
							)
							(= local0 1)
						)
						(
							(and
								(== gChapter 1)
								(IsFlag 53)
								(not (IsFlag 78))
								(IsFlag 77)
							)
							(gEgo posn: 148 125)
							(donProp view: 17103 init:)
							(= local0 1)
						)
						((and (== gChapter 3) (not (IsFlag 164)))
							(gEgo posn: 148 125)
							(if
								(or
									(not (IsFlag 246))
									(and
										(IsFlag 246)
										(IsFlag 328)
										(not (IsFlag 329))
									)
								)
								(SetFlag 405)
								(donProp
									view: 17105
									init:
									approachVerbs: 4 ; Do
									setHotspot: 4 3 ; Do, Move
								)
								(if (IsFlag 328)
									(donProp view: 17114)
								)
								(= local0 1)
							else
								(donProp view: 17105 init:)
								(= local0 1)
								(if (IsFlag 328)
									(donProp view: 17114)
								)
							)
						)
						((and (== gChapter 3) (not (IsFlag 403)))
							(SetFlag 403)
						)
					)
					(gEgo normalize:)
					(if
						(and
							(!= (gEgo x:) 125)
							(!= (gEgo x:) 249)
							(!= (gEgo x:) 148)
							(!= (gEgo x:) 147)
							(!= (gEgo x:) 103)
							(!= (gEgo x:) 153)
							(!= (gEgo x:) 136)
							(!= (gEgo x:) 190)
							(!= (gEgo x:) 266)
							(!= (gEgo x:) 262)
						)
						(gEgo
							normalize: 2
							posn: 125 105
							setScaler: Scaler 150 33 160 79
						)
					)
					(proc28_2)
					(if (not (gCurRoom script:))
						(gGame handsOn:)
					)
				)
			)
			(4200
				(gGame handsOff:)
				(gEgo view: 3 posn: 125 105)
				(gGDacSound stop:)
				(photo hide:)
				(farCompute hide:)
				(fire y: 1000 hide:)
				(gEgo hide:)
				(gCurRoom picture: -1)
				(gCurRoom setScript: sBeginChapter5)
			)
			(18200
				(gEgo view: 0 posn: 249 121 hide:)
				(fire
					view: 17412
					posn: -4 99
					init:
					cycleSpeed: 10
					setCycle: Fwd
				)
				(farCompute view: 17410 posn: 134 79 init:)
				(photo view: 17413 posn: 253 124)
				(= picture 17410)
				(WalkieTalkie showFrame: 3990 0 -5 -35)
				(gCurRoom setScript: sAdrienneSits)
			)
			(17000
				(gEgo normalize: 3 posn: 103 125)
				(cond
					(
						(and
							(== gChapter 1)
							(not (IsFlag 77))
							(IsFlag 53)
							(not (IsFlag 78))
						)
						(gEgo posn: 148 125)
						(donProp
							view: 17103
							approachVerbs: 4 3 ; Do, Move
							setHotspot: 4 3 ; Do, Move
							init:
						)
						(= local0 1)
					)
					(
						(and
							(== gChapter 1)
							(IsFlag 53)
							(not (IsFlag 78))
							(IsFlag 77)
						)
						(gEgo posn: 148 125)
						(donProp view: 17103 init:)
						(= local0 1)
					)
					((and (== gChapter 3) (not (IsFlag 164)))
						(gEgo posn: 148 125)
						(if
							(or
								(not (IsFlag 246))
								(and
									(IsFlag 246)
									(IsFlag 328)
									(not (IsFlag 329))
								)
							)
							(SetFlag 405)
							(donProp
								view: 17105
								init:
								approachVerbs: 4 ; Do
								setHotspot: 4 3 ; Do, Move
							)
							(if (IsFlag 328)
								(donProp view: 17114)
							)
							(= local0 1)
						else
							(donProp view: 17105 init:)
							(= local0 1)
							(if (IsFlag 328)
								(donProp view: 17114)
							)
						)
					)
					((and (== gChapter 3) (not (IsFlag 403)))
						(SetFlag 403)
					)
				)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(15300
				(gEgo normalize: 3 posn: 103 125)
				(cond
					(
						(and
							(== gChapter 1)
							(not (IsFlag 77))
							(IsFlag 53)
							(not (IsFlag 78))
						)
						(gEgo posn: 148 125)
						(donProp
							view: 17103
							approachVerbs: 4 3 ; Do, Move
							setHotspot: 4 3 ; Do, Move
							init:
						)
						(= local0 1)
					)
					(
						(and
							(== gChapter 1)
							(IsFlag 53)
							(not (IsFlag 78))
							(IsFlag 77)
						)
						(gEgo posn: 148 125)
						(donProp view: 17103 init:)
						(= local0 1)
					)
					((and (== gChapter 3) (not (IsFlag 164)))
						(gEgo posn: 148 125)
						(if
							(or
								(not (IsFlag 246))
								(and
									(IsFlag 246)
									(IsFlag 328)
									(not (IsFlag 329))
								)
							)
							(SetFlag 405)
							(donProp
								view: 17105
								init:
								approachVerbs: 4 ; Do
								setHotspot: 4 3 ; Do, Move
							)
							(if (IsFlag 328)
								(donProp view: 17114)
							)
							(= local0 1)
						else
							(donProp view: 17105 init:)
							(= local0 1)
							(if (IsFlag 328)
								(donProp view: 17114)
							)
						)
					)
					((and (== gChapter 3) (not (IsFlag 403)))
						(SetFlag 403)
					)
				)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(gEgo normalize: 2 posn: 125 105)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
		)
		(cond
			(
				(or
					(and
						(== gChapter 1)
						(not (IsFlag 75))
						(not (IsFlag 326))
						(not (gCast contains: donProp))
						(not local0)
					)
					(and
						(== gChapter 3)
						(not (IsFlag 243))
						(not (gCast contains: donProp))
						(not local0)
					)
					(and
						(== gChapter 5)
						(not (IsFlag 326))
						(not (== (gCurRoom script:) sBeginChapter5))
						(not (IsFlag 244))
					)
					(and
						(or (== gChapter 6) (== gChapter 7))
						(not (IsFlag 245))
					)
				)
				(desk init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
				(if
					(and
						(not (OneOf gChapter 6 7))
						(not (OneOf gPrevRoomNum 10100 18200))
						(not (OneOf script sDonReads sBeginChapter5))
					)
					(farCompute init:)
				)
			)
			(
				(and
					(not (OneOf gChapter 6 7))
					(not
						(OneOf
							script
							sDonReads
							sBeginChapter2
							sBeginChapter5
						)
					)
					(not (OneOf gPrevRoomNum 10100 18200))
				)
				(farCompute init:)
				(if (== gChapter 5)
					(farCompute view: 17109)
				else
					(farCompute view: 17113)
				)
			)
		)
		(if (OneOf gChapter 6 7)
			(farCompute view: 17110 posn: 156 87 init:)
		)
		(cond
			((and (== global125 38) (not (gCast contains: donProp)))
				(gEgo view: 3 posn: 153 101)
				(cond
					((== gChapter 1)
						(gCurRoom setScript: sDoComp1)
					)
					((== gChapter 3)
						(gCurRoom setScript: sDoComp3)
					)
					((== gChapter 5)
						(gCurRoom setScript: sDoComp5)
					)
					((== gChapter 7) 0)
					(else
						(gCurRoom setScript: sDoComp6)
					)
				)
			)
			(script)
			(else
				(gGame handsOn:)
			)
		)
		(SetFlag 240)
		(if
			(and
				(== gChapter 5)
				(!= gPrevRoomNum 10100)
				(!= (gCurRoom script:) sBeginChapter5)
			)
			(= picture 17101)
			(fire view: 17106)
			(photo view: 17115)
		)
		(if (not (OneOf script sBeginChapter2 sBeginChapter5))
			(fire cycleSpeed: 10 init: setCycle: Fwd)
		)
		(if (and (IsFlag 247) (== gChapter 4))
			(SetFlag 3)
			(harriet
				init:
				posn: 160 127
				ignoreActors: 1
				approachVerbs: 0
				setScaler: Scaler 96 65 126 15
				setHotspot: 4 3 15 ; Do, Move, invTarot
			)
		)
		(if (== gChapter 7)
			(suitcase init:)
		)
		(super init: &rest)
		(if
			(and
				(not (OneOf script sBeginChapter2 sBeginChapter5))
				(not (gCast contains: harriet))
			)
			(gGDacSound number: 17013 setLoop: -1 play:)
		)
		(gGame fadeSpeed: 100)
		(southExit init: 3)
	)
)

(instance suitcase of View
	(properties
		x 213
		y 92
		view 17116
	)
)

(instance sTo17000 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 180 self)
				)
				(1
					(gCurRoom newRoom: 17000)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 17000)
				)
			)
		)
	)
)

(instance sDoComp1 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global125 0)
					(= seconds 3)
				)
				(1
					(if (gCast contains: donProp)
						(donProp hide:)
					)
					(farCompute dispose:)
					(fire dispose:)
					(computer setPri: 159 posn: 138 129 init:)
					(gEgo hide: view: 2)
					(photo view: 17332 posn: 283 77)
					(DoRobot 1380 49 -21 gEgo 200)
					(gCurRoom drawPic: 17330)
				)
				(2)
				(3
					(computer setLoop: 0 posn: 139 128 setCel: 0 show:)
				)
				(4
					(desk dispose:)
					(computer dispose:)
					(farCompute view: 17113 init:)
					(photo view: 17100 posn: 280 101)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(gEgo show:)
					(if (gCast contains: donProp)
						(donProp show:)
					)
					(gCurRoom drawPic: 17100)
					(gEgo
						normalize: 2
						posn: 125 105
						setScaler: Scaler 150 33 160 79
						show:
					)
					(SetFlag 75)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
				)
				(5
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(farCompute view: 17113 init:)
					(if (gCast contains: donProp)
						(donProp show:)
					)
					(desk dispose:)
					(computer dispose:)
					(SetFlag 75)
					(gEgo
						normalize: 2
						posn: 125 105
						setScaler: Scaler 150 33 160 79
						show:
					)
					(photo view: 17100 posn: 280 101)
					(gCurRoom drawPic: 17100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDonReads of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 77)
					(= cycles 1)
				)
				(1
					(fire dispose:)
					(donProp dispose:)
					(farCompute dispose:)
					(gEgo hide:)
					(DoRobot 1400 -2 19)
					(photo view: 17305 posn: 145 84)
					(gCurRoom drawPic: 17305)
				)
				(2
					(photo view: 17100 posn: 280 101)
					(gCurRoom drawPic: 17100)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(gEgo normalize: 1 show:)
					(farCompute view: 17113 init: show:)
					(donProp
						view: 17103
						init:
						setHotspot: 0
						approachVerbs: 0
						setScript: sDonDoIt
					)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
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
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(gEgo normalize: 1 show:)
					(farCompute view: 17113 init: view: 17113 show:)
					(donProp
						view: 17103
						init:
						setHotspot: 0
						approachVerbs: 0
						setScript: sDonDoIt
					)
					(SetFlag 77)
					(photo view: 17100 posn: 280 101)
					(gCurRoom drawPic: 17100)
					(= global115 0)
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
				(= seconds (Random 10 15))
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

(instance sBeginChapter2 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 121)
					(SetFlag 326)
					(= cycles 1)
				)
				(1
					(SetFlag 418)
					(if (< gVideoSpeed 425)
						(proc26_0 22905 self)
					else
						(proc26_0 2290 self)
					)
				)
				(2
					(= cycles 1)
				)
				(3
					(ClearFlag 418)
					(PlayVMD 0 {2291.vmd}) ; Open
					(proc26_0 2291 self)
				)
				(4
					(ClearFlag 121)
					(farCompute dispose:)
					(photo view: 17332 posn: 283 77)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(WalkieTalkie showFrame: 3112 0 107 -10 160)
					(gCurRoom drawPic: 17330)
					(global114 play: 911)
					(gGame fade: 0 100 2)
					(= ticks 25)
				)
				(5
					(DoRobot 3112 107 -10 gEgo 160 1)
				)
				(6
					(KillRobot)
					(computer dispose:)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(farCompute view: 17113 init: show:)
					(if (gCast contains: donProp)
						(donProp show:)
					)
					(photo view: 17100 posn: 280 101 show:)
					(gCurRoom drawPic: 17100)
					(desk dispose:)
					(SetFlag 242)
					(gEgo
						posn: 136 100
						setScaler: Scaler 150 33 160 79
						show:
						normalize: 2
						cel: 0
						setCycle: End self
					)
				)
				(7
					(gEgo setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(ClearFlag 121)
					(global114 play: 911)
					(= global115 0)
					(SetFlag 326)
					(desk dispose:)
					(computer dispose:)
					(farCompute view: 17113 init:)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(if (gCast contains: donProp)
						(donProp show:)
					)
					(photo view: 17100 posn: 280 101 show:)
					(gCurRoom drawPic: 17100)
					(gEgo setScaler: Scaler 150 33 160 79 show: normalize: 2)
					(SetFlag 242)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoComp3 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global125 0)
					(= seconds 3)
				)
				(1
					(if (== (gEgo x:) 150)
						(gEgo setHeading: 180 self)
					else
						(gEgo setHeading: 90 self)
					)
				)
				(2
					(gEgo hide:)
					(farCompute dispose:)
					(fire dispose:)
					(computer x: 155 y: 115 setPri: 200 init:)
					(photo view: 17332 posn: 283 77)
					(DoRobot 3110 90 -10 gEgo 160)
					(gCurRoom drawPic: 17330)
				)
				(3
					(proc1111_8)
					(computer view: 17353 setLoop: 0 setCel: 0 posn: 22 130)
					(gCurRoom drawPic: 17350)
					(gGame handsOn:)
					(gUser canControl: 0)
					((ScriptID 0 14) init:) ; exitButt
					(SetFlag 248)
				)
				(4
					((ScriptID 0 14) dispose:) ; exitButt
					(computer hide:)
					(global114 pause:)
					(DoRobot 3111 137 15 gEgo 160)
					(gCurRoom drawPic: 17330)
				)
				(5)
				(6
					(gEgo
						posn: 136 100
						setScaler: Scaler 150 33 160 79
						show:
						normalize: 2
					)
					(farCompute view: 17113 init:)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(global114 endPause:)
					(computer dispose:)
					(photo view: 17100 posn: 280 101)
					(gCurRoom drawPic: 17100)
					(desk dispose:)
					(SetFlag 243)
					(gCurRoom setScript: (ScriptID 0 5)) ; takeLastStep
				)
			)
		else
			(switch (= state newState)
				(0
					(global114 endPause: 1)
					(ClearFlag 248)
					(proc1111_9)
					((ScriptID 0 14) dispose:) ; exitButt
					(SetFlag 243)
					(KillRobot)
					(computer dispose:)
					(desk dispose:)
					(farCompute view: 17113 init:)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(gEgo
						posn: 136 100
						setScaler: Scaler 150 33 160 79
						show:
						normalize: 2
					)
					(photo view: 17100 posn: 280 101)
					(gCurRoom drawPic: 17100)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDonOnBed of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(donProp hide:)
					(farCompute hide:)
					(fire dispose:)
					(if (not (IsFlag 246))
						(DoRobot 3120 9 -42)
					else
						(DoRobot 3130 11 -40)
					)
					(photo view: 17305 posn: 145 84)
					(Load rsVIEW 17100)
					(gCurRoom drawPic: 17305)
				)
				(1
					(photo view: 17100 posn: 280 101)
					(gEgo
						normalize: 5
						posn: (donProp approachX:) (donProp approachY:)
						setScaler: Scaler 150 33 160 79
						cel: 0
						setCycle: End self
					)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(gCurRoom drawPic: 17100)
					(SetFlag 246)
					(donProp show:)
					(donProp setHotspot: 0 setScript: sDonDoIt)
					(farCompute view: 17113 show: view: 17113)
					(if (IsFlag 328)
						(SetFlag 329)
					)
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
					(photo view: 17100 posn: 280 101)
					(gEgo
						view: 7
						posn: 266 127
						setScaler: Scaler 150 33 160 79
					)
					(fire init: cycleSpeed: 10 setCycle: Fwd)
					(donProp setHotspot: 0 setScript: sDonDoIt)
					(donProp show:)
					(gCurRoom drawPic: 17100)
					(= global115 0)
					(farCompute view: 17113 show: view: 17113)
					(if (IsFlag 246)
						(donProp setHotspot: 0)
					)
					(if (IsFlag 328)
						(SetFlag 329)
					)
					(SetFlag 246)
					(gGame handsOn:)
				)
			)
		)
	)
)

(instance sAdrienneSits of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gGame fade: 1 0 1)
					(= cycles 1)
				)
				(1
					(gGame fade: 0 100 2)
					(= cycles 25)
				)
				(2
					(KillRobot)
					(DoRobot 3990 -5 -35)
					(gCurRoom drawPic: 17410)
				)
				(3
					(farCompute view: 17113 posn: 156 83)
					(gEgo
						view: 4
						x: 262
						y: 127
						show:
						ignoreActors: 1
						setScaler: Scaler 150 33 160 79
						normalize: 4
					)
					(fire view: 17107 posn: 56 110 cycleSpeed: 10 setCycle: Fwd)
					(photo view: 17100 posn: 280 101)
					(UpdateScreenItem photo)
					(gCurRoom drawPic: 17100)
					(global114 play: 9120)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(fire view: 17107 posn: 56 110 cycleSpeed: 10 setCycle: Fwd)
					(farCompute view: 17113 posn: 156 83)
					(gEgo
						posn: 262 127
						show:
						normalize: 4
						setScaler: Scaler 150 33 160 79
					)
					(photo view: 17100 posn: 280 101)
					(gCurRoom drawPic: 17100)
					(global114 play: 9120)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBeginChapter5 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 121)
					(gGame fade: 0 (gGame intensity:) 2)
					(= cycles 3)
				)
				(1
					(proc26_0 4840 self)
				)
				(2
					(gEgo show: normalize: 2)
					(fire
						view: 17106
						cycleSpeed: 10
						posn: 56 110
						init:
						setCycle: Fwd
					)
					(if (not (gCast contains: farCompute))
						(farCompute init:)
					)
					(farCompute view: 17108 show:)
					(photo view: 17115 posn: 280 101 show:)
					(desk init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(ClearFlag 121)
					(gCurRoom drawPic: 17101)
					(global114 play: 913)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 121)
					(fire view: 17106 cycleSpeed: 10 show: setCycle: Fwd)
					(gEgo show: normalize: 2)
					(photo view: 17115 posn: 280 101 show:)
					(= global115 0)
					(desk init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(if (not (gCast contains: farCompute))
						(farCompute init:)
					)
					(farCompute view: 17108 show:)
					(gCurRoom drawPic: 17101)
					(if (not (gCast contains: harriet))
						(gGDacSound number: 17013 setLoop: -1 play:)
					)
					(global114 play: 913)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoComp5 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global125 0)
					(if (not (desk approachVerbs:))
						(gEgo setHeading: 45 self)
					else
						(= seconds 3)
					)
				)
				(1
					(gEgo hide:)
					(farCompute hide:)
					(fire dispose:)
					(computer
						view: 17331
						loop: 1
						x: 176
						y: 115
						setPri: 200
						init:
					)
					(photo dispose:)
					(DoRobot 3110 90 -10 gEgo 160)
					(gCurRoom drawPic: 17331)
				)
				(2
					(SetFlag 248)
					(SetFlag 121)
					((ScriptID 0 14) init:) ; exitButt
					(proc1111_8)
					(computer
						view: 17356
						setLoop: 0
						setCel: 0
						posn: 21 129
						setPri: 200
						init:
					)
					(gGame handsOn: 0)
					(gCurRoom drawPic: 17351)
				)
				(3
					((ScriptID 0 14) dispose:) ; exitButt
					(ClearFlag 121)
					(computer hide:)
					(global114 pause:)
					(DoRobot 3111 137 15 gEgo 160)
					(gCurRoom drawPic: 17331)
				)
				(4
					(computer
						view: 17331
						x: 176
						y: 115
						setPri: 159
						setLoop: 0
						show:
					)
				)
				(5
					(proc1111_9)
					(computer dispose:)
					(farCompute view: 17109 posn: 156 83 show:)
					(fire view: 17106 init: cycleSpeed: 10 setCycle: Fwd)
					(global114 endPause:)
					(photo view: 17115 posn: 280 101 init:)
					(gCurRoom drawPic: 17101)
					(gEgo
						posn: 136 100
						setScaler: Scaler 150 33 160 79
						show:
						normalize: 2
						cel: 0
						setCycle: End self
					)
					(desk dispose:)
					(SetFlag 244)
				)
				(6
					(gEgo setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_9)
					(= global115 0)
					(global114 endPause: 1)
					(ClearFlag 248)
					(ClearFlag 121)
					(desk dispose:)
					((ScriptID 0 14) dispose:) ; exitButt
					(KillRobot)
					(SetFlag 244)
					(if (gCast contains: computer)
						(computer dispose:)
					)
					(fire
						view: 17106
						posn: 56 110
						init:
						cycleSpeed: 10
						setCycle: Fwd
					)
					(farCompute view: 17109 posn: 156 83 show:)
					(gEgo
						posn: 136 100
						setScaler: Scaler 150 33 160 79
						show:
						normalize: 2
					)
					(photo view: 17115 posn: 280 101 init:)
					(gCurRoom drawPic: 17101)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoComp6 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global125 0)
					(Load rsVIEW 5481)
					(= seconds 3)
				)
				(1
					(gEgo hide:)
					(fire dispose:)
					(farCompute dispose:)
					(computer
						view: 5480
						setLoop: 0
						setCel: 0
						posn: 150 117
						setPri: 159
						init:
					)
					(photo view: 17332 posn: 283 77)
					(suitcase view: 17333 x: 253 y: 81)
					(DoRobot 5480 142 27 gEgo 160)
					(gCurRoom drawPic: 17330)
				)
				(2
					(computer hide:)
				)
				(3
					(computer view: 5481 posn: 149 118 show:)
				)
				(4
					(gEgo hide:)
					(KillRobot)
					(= cycles 3)
				)
				(5
					(gGame fade: (gGame intensity:) 0 1)
					(= seconds 2)
				)
				(6
					(SetFlag 245)
					(= global125 52)
					(gCurRoom newRoom: 17000)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gGame setIntensity: 0)
					(= global125 52)
					(SetFlag 245)
					(= global115 0)
					(gCurRoom newRoom: 17000)
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
					(gGame handsOff:)
					(if (== (gEgo x:) 103)
						(gEgo setHeading: 90 self 10)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet hide:)
					(farCompute hide:)
					(fire hide:)
					(compute init:)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
					(DoRobot 4330 -38 -13 gEgo -1 1)
				)
				(2
					(SetFlag 249)
					(gCurRoom newRoom: 17000)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 249)
					(= global115 0)
					(gCurRoom newRoom: 17000)
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
					(gGame handsOff:)
					(if (== (gEgo x:) 103)
						(gEgo setHeading: 90 self 10)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet hide:)
					(farCompute hide:)
					(fire hide:)
					(DoRobot 4340 -38 -13 gEgo -1 1)
					(compute init:)
					(photo view: 17413 posn: 258 124 init:)
					(gCurRoom drawPic: 17410)
				)
				(2
					(gCurRoom newRoom: 17000)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 17000)
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
					(gGame handsOff:)
					(if (== (gEgo x:) 103)
						(gEgo setHeading: 90 self 10)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(gEgo hide:)
					(harriet hide:)
					(fire hide:)
					(farCompute hide:)
					(compute init:)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
					(DoRobot 4262 -38 -7 gEgo 200 1)
				)
				(2
					(gEgo put: 9) ; invTarot
					(SetFlag 179)
					(gCurRoom newRoom: 17000)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 179)
					(= global115 0)
					(gEgo put: 9) ; invTarot
					(gCurRoom newRoom: 17000)
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
					(if (== (gEgo x:) 103)
						(gEgo setHeading: 90 self 10)
					else
						(gEgo setHeading: 180 self)
					)
				)
				(1
					(harriet hide:)
					(farCompute hide:)
					(compute init:)
					(fire hide:)
					(gEgo hide:)
					(DoRobot 4320 -38 -17 gEgo -1 1)
					(photo view: 17413 posn: 260 125 init:)
					(gCurRoom drawPic: 17410)
				)
				(2
					(gCurRoom newRoom: 17000)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gCurRoom newRoom: 17000)
				)
			)
		)
	)
)

(instance donProp of Prop
	(properties
		sightAngle 40
		approachX 190
		approachY 128
		x 206
		y 105
	)

	(method (init)
		(cond
			((== gChapter 1)
				(self view: 17103)
			)
			((and (IsFlag 328) (not (== gPrevRoomNum 10100)))
				(self view: 17114)
			)
			((not (== gPrevRoomNum 10100))
				(self view: 17105)
			)
		)
		(super init:)
		(self cycleSpeed: 10)
		(self setScript: sDonDoIt)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gChapter 1)
				(gCurRoom setScript: sDonReads)
			else
				(gCurRoom setScript: sDonOnBed)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance harriet of Prop
	(properties
		x 160
		y 131
		view 4262
		loop 1
	)

	(method (init)
		(super init: &rest)
		(gGDacSound number: 17045 setLoop: -1 play:)
		(self approachVerbs: 0 cycleSpeed: 8 setCycle: Osc)
	)

	(method (doVerb theVerb)
		(= global125 10)
		(switch theVerb
			(15 ; invTarot
				(gGame handsOff:)
				(gCurRoom setScript: sGiveTarot)
			)
			(4 ; Do
				(gGame handsOff:)
				(cond
					((and (IsFlag 176) (not (IsFlag 153)))
						(SetFlag 153)
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

(instance fire of Prop
	(properties
		x 56
		y 110
		view 17107
	)
)

(instance computer of View
	(properties
		x 139
		y 115
		view 17330
		loop 1
	)
)

(instance typing of View
	(properties
		x 116
		y 112
		view 2290
		loop 1
	)
)

(instance farCompute of View
	(properties
		x 156
		y 83
		view 17101
	)

	(method (init)
		(if (== gChapter 5)
			(= view 17108)
		)
		(super init:)
	)
)

(instance photo of View
	(properties
		x 280
		y 101
		view 17100
	)
)

(instance compute of Prop
	(properties
		x 134
		y 79
		view 17410
	)
)

(instance desk of Feature
	(properties
		nsLeft 138
		nsTop 70
		nsRight 181
		nsBottom 90
		sightAngle 40
		approachX 142
		approachY 99
		x 152
		y 80
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((== gChapter 1)
					(gCurRoom setScript: sDoComp1)
				)
				((== gChapter 3)
					(gCurRoom setScript: sDoComp3)
				)
				((== gChapter 5)
					(gCurRoom setScript: sDoComp5)
				)
				(else
					(gCurRoom setScript: sDoComp6)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aWindow of Feature ; UNUSED
	(properties
		nsLeft 135
		nsTop 33
		nsRight 177
		nsBottom 70
		sightAngle 40
		approachX 152
		approachY 93
		x 156
		y 93
		z 42
	)
)

(instance nightStand of Feature ; UNUSED
	(properties
		nsLeft 269
		nsTop 90
		nsRight 290
		nsBottom 122
		sightAngle 40
		approachX 114
		approachY 116
		x 279
		y 106
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 5
		nsTop 120
		nsRight 290
		sightAngle 40
		approachX 140
		approachY 123
		x 140
		y 123
		nextRoom 17000
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sTo17000)
		else
			(super doVerb: theVerb)
		)
	)
)

