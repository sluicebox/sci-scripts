;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8200)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm8200 0
)

(instance rm8200 of ScaryRoom
	(properties
		picture 8710
		stepSound 4
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 75 32 114 83 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(3700
				(gEgo normalize: 2 posn: 97 94)
				(= global125 8)
				(gCurRoom setScript: sEnterFromDoor)
			)
			(36400
				(KillRobot)
				(gGame handsOff:)
				(self picture: 8610)
				(self setScript: sEnterFromPassage)
			)
			(else
				(switch global125
					(11
						(gEgo posn: 108 111 normalize: 1)
						(= global125 6)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(12
						(gEgo posn: 108 111 normalize: 1)
						(= global125 6)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(13
						(gEgo posn: 97 94 normalize: 3)
						(= global125 8)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(14
						(gEgo posn: 108 111 normalize: 1)
						(= global125 6)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(15
						(gEgo posn: 108 111 normalize: 1)
						(= global125 6)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(else
						(gEgo normalize: 7 posn: 206 87)
						(= global125 7)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
		)
		(TheaterDoor init: 1 approachVerbs: 0)
		(southExit init: 11 approachVerbs: 0)
		(southeastExit init: 11 approachVerbs: 0)
		(secretPanel init: setHotspot: 4 3) ; Do, Move
		(if (IsFlag 15)
			(if (== (gCurRoom script:) sEnterFromPassage)
				(tDoors init: hide:)
			else
				(tDoors init:)
			)
		)
		(super init: &rest)
	)
)

(instance sEnterFromPassage of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(secretPanelBlack init:)
					(DoRobot 5280 71 13 gEgo -1 1)
				)
				(1
					(if (IsFlag 327)
						(self changeState: 5)
					else
						(gEgo hide:)
						(secretPanelBlack hide:)
						(if (< gVideoSpeed 425)
							(PlayVMD 0 {52905.vmd} 0) ; Open
							(proc26_0 52905 self)
						else
							(PlayVMD 0 {5290.vmd} 0) ; Open
							(proc26_0 5290 self)
						)
					)
				)
				(2
					(secretPanelBlack show:)
					(DoRobot 5281 44 8)
				)
				(3
					(secretPanelBlack dispose:)
				)
				(4
					(SetFlag 327)
					(gEgo
						setScaler: Scaler 75 32 114 83
						normalize: 0
						posn: 206 87
						show:
						setScaler: Scaler 75 32 114 83
					)
					(= global125 7)
					(gCurRoom drawPic: 8710)
					(gGame handsOn:)
					(self dispose:)
				)
				(5
					(if (not (IsFlag 69))
						(KillRobot)
						(secretPanelBlack hide:)
						(flipAnim init:)
						(gCurRoom drawPic: 8225)
						(gGDacSound
							number: 8060
							init:
							setVol: 127
							setLoop: 1
							play: self
						)
					else
						(self cue:)
					)
				)
				(6
					(if (not (IsFlag 69))
						(gCurRoom drawPic: 8610)
						(flipAnim dispose:)
						(secretPanelBlack show:)
					)
					(DoRobot 5287 -21 -24)
				)
				(7
					(if (gCast contains: tDoors)
						(tDoors show:)
					)
					(secretPanelBlack dispose:)
					(gEgo
						setScaler: Scaler 75 32 114 83
						normalize: 1
						posn: 206 87
						show:
						setScaler: Scaler 75 32 114 83
					)
					(= global125 7)
					(gCurRoom drawPic: 8710)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(ClearFlag 121)
			(if (gCast contains: tDoors)
				(tDoors show:)
			)
			(if (gCast contains: flipAnim)
				(flipAnim dispose:)
			)
			(if (gCast contains: secretPanelBlack)
				(secretPanelBlack dispose:)
			)
			(SetFlag 327)
			(gEgo
				setScaler: Scaler 75 32 114 83
				normalize: 1
				posn: 206 87
				show:
				setScaler: Scaler 75 32 114 83
			)
			(= global125 7)
			(gCurRoom drawPic: 8710)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sEnterFromDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo cel: 0 setCycle: End self)
				)
				(1
					(if (not (IsFlag 69))
						(tDoors hide:)
						(gEgo hide:)
						(flipAnim init:)
						(gCurRoom drawPic: 8225)
						(gGDacSound
							number: 8060
							init:
							setVol: 127
							setLoop: 1
							play: self
						)
					else
						(self cue:)
					)
				)
				(2
					(if (not (IsFlag 69))
						(gEgo show:)
						(tDoors show:)
						(gCurRoom drawPic: 8710)
						(flipAnim dispose:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if (gCast contains: flipAnim)
				(gEgo show:)
				(tDoors show:)
				(flipAnim dispose:)
			)
			(gCurRoom drawPic: 8710)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDoSecretPanel of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setScaler: Scaler 75 32 114 83)
					(switch global125
						(7
							(gEgo setHeading: 90 self 15)
						)
						(8
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(if (gCast contains: tDoors)
						(tDoors hide:)
					)
					(DoRobot 5282 -21 -44)
					(gCurRoom drawPic: 8610)
				)
				(2
					(if (gCast contains: tDoors)
						(tDoors show:)
					)
					(gEgo
						posn: 206 87
						normalize: 0
						setScaler: Scaler 75 32 114 83
					)
					(= global125 7)
					(gCurRoom drawPic: 8710)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if (gCast contains: tDoors)
				(tDoors show:)
			)
			(gEgo posn: 206 87 normalize: 0 setScaler: Scaler 75 32 114 83)
			(= global125 7)
			(gCurRoom drawPic: 8710)
			(gGame handsOn:)
			(self dispose:)
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
						(7
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(if (IsFlag 15)
						(gEgo hide:)
						(DoRobot 5291 148 64 gEgo -1 1)
					else
						(DoRobot 5290 112 26)
					)
					(if (gCast contains: tDoors)
						(tDoors view: 8370 posn: 183 102)
					)
					(gCurRoom drawPic: 8370)
				)
				(2
					(SetFlag 15)
					(if (not (IsFlag 198))
						(tDoors dispose:)
						(self cue:)
					else
						(gCurRoom newRoom: 3700)
					)
				)
				(3
					(escapeMachine init:)
					(DoRobot 5381 -10 -13)
					(gCurRoom drawPic: 3520)
				)
				(4
					(escapeMachine dispose:)
					(DoRobot 5383 1 -38 gEgo -1 1)
					(gCurRoom drawPic: 3541)
				)
				(5
					(gEgo hide:)
					(SetFlag 198)
					(gGame fade: 100 0 2)
					(= cycles 50)
				)
				(6
					(gGame fadeSpeed: 4)
					(= global125 0)
					(gCurRoom newRoom: 44) ; chapEndRm
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 15)
					(if (not (IsFlag 198))
						(gEgo hide:)
						(SetFlag 198)
						(gGame fadeSpeed: 4)
						(= global125 0)
						(gCurRoom newRoom: 44) ; chapEndRm
					else
						(gCurRoom newRoom: 3700)
					)
					(self dispose:)
				)
			)
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
						(6
							(gEgo setHeading: 135 self)
						)
						(7
							(gEgo setHeading: 270 self)
						)
						(8
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(+= global125 10)
					(gCurRoom newRoom: 8100)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if (< global125 10)
				(+= global125 10)
			)
			(gCurRoom newRoom: 8100)
		)
	)
)

(instance sExitSouthEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(6
							(gEgo setHeading: 90 self)
						)
						(7
							(gEgo setHeading: 90 self 15)
						)
						(8
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 8100)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 8100)
		)
	)
)

(instance flipAnim of Prop
	(properties
		x 126
		y 58
		view 8225
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance escapeMachine of View
	(properties
		x 94
		y 79
		view 3521
	)
)

(instance tDoors of View
	(properties
		x 81
		y 43
		view 8710
	)
)

(instance secretPanelBlack of View
	(properties
		x 101
		y 116
		view 8610
	)
)

(instance secretPanel of Feature
	(properties
		nsLeft 213
		nsTop 64
		nsRight 220
		nsBottom 83
		x 216
		y 73
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoSecretPanel)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance TheaterDoor of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 108 45 85 59 86 89 108 86 108 46
					yourself:
				)
		)
		(super init: &rest)
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

(instance southExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 111 91 115 96 129 158 129
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
					init: 256 99 267 90 282 93 282 107
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

