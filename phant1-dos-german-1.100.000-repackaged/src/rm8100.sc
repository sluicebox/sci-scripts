;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8100)
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
	rm8100 0
)

(local
	local0
)

(instance rm8100 of ScaryRoom
	(properties
		picture 8501
		stepSound 4
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 71 28 133 82 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(27100
				(gEgo normalize: 4 posn: 73 87)
				(= global125 2)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(switch global125
					(6
						(gEgo normalize: 1 posn: 17 102)
						(= global125 1)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(7
						(gEgo normalize: 6 posn: 17 102)
						(= global125 1)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(8
						(gEgo normalize: 6 posn: 17 102)
						(= global125 1)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(16
						(gEgo normalize: 6 posn: 107 116)
						(= global125 3)
						(gGame handsOn:)
					)
					(else
						(gEgo normalize: 6 posn: 107 116)
						(= global125 3)
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
		)
		(escapeMachine init:)
		(if (not (IsFlag 35))
			(escapeMachine setHotspot: 4 3) ; Do, Move
		)
		(if (not (IsFlag 69))
			(if (== gChapter 5)
				(flipcardMachine init:)
			else
				(flipcardMachineF init: setHotspot: 4 3) ; Do, Move
			)
		)
		(MakeupRoomDoor init: 13 approachVerbs: 0)
		(southExit init: 12 approachVerbs: 0)
		(southwestExit init: 12 approachVerbs: 0)
		(super init: &rest)
	)
)

(instance sEnterMakeupRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 121)
					(switch global125
						(1
							(gEgo setHeading: 45 self)
						)
						(2
							(gEgo setHeading: 315 self 15)
						)
						(3
							(gEgo setHeading: 270 self 23)
						)
						(4
							(gEgo setHeading: 270 self)
						)
						(5
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(switch global125
						(1
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5285 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(3
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5285 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(ClearFlag 121)
					(= global125 0)
					(gCurRoom newRoom: 27100)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(ClearFlag 121)
			(= global125 0)
			(gCurRoom newRoom: 27100)
		)
	)
)

(instance sDoEscapeMachine of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= local0 (= state newState))
				(0
					(switch global125
						(1
							(gEgo setHeading: 45 self)
						)
						(2
							(gEgo setHeading: 90 self)
						)
						(3
							(gEgo setHeading: 270 self 23)
						)
						(4
							(self changeState: 1)
						)
						(5
							(gEgo setHeading: 315 self)
						)
					)
				)
				(1
					(gEgo hide:)
					(switch global125
						(1
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(DoRobot 5283 -7 28)
							(gCurRoom drawPic: 8400)
						)
						(3
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(DoRobot 5283 -7 28)
							(gCurRoom drawPic: 8400)
						)
						(else
							(self cue:)
						)
					)
				)
				(2
					(gEgo
						posn: 130 87
						normalize: 0
						setScaler: Scaler 71 28 133 82
						show:
					)
					(= global125 4)
					(gCurRoom drawPic: 8501)
					(UpdateScreenItem gEgo)
					(PlayVMD 0 {5300.vmd} 0) ; Open
					(proc26_0 5300 self)
				)
				(3
					(SetFlag 35)
					(escapeMachine posn: 136 87 view: 8500 setHotspot: 0)
					(flipcardMachine posn: 176 69 view: 8500)
					(gEgo
						posn: 130 87
						normalize: 0
						setScaler: Scaler 71 28 133 82
						show:
					)
					(= global125 4)
					(gCurRoom drawPic: 8501)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if (< local0 3)
				(self changeState: 2)
			else
				(self changeState: 3)
			)
		)
	)
)

(instance sDoFlipCardMachine of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= local0 (= state newState))
				(0
					(switch global125
						(1
							(gEgo setHeading: 45 self)
						)
						(2
							(gEgo setHeading: 90 self)
						)
						(3
							(gEgo setHeading: 270 self 23)
						)
						(4
							(gEgo setHeading: 45 self)
						)
						(5
							(self changeState: 1)
						)
					)
				)
				(1
					(gEgo hide:)
					(switch global125
						(1
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(DoRobot 5283 -7 28)
							(gCurRoom drawPic: 8400)
						)
						(3
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(DoRobot 5283 -7 28)
							(gCurRoom drawPic: 8400)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(gEgo
						posn: 172 87
						normalize: 7
						setScaler: Scaler 71 28 133 82
						cel: 10
						show:
					)
					(= global125 5)
					(gCurRoom drawPic: 8501)
					(UpdateScreenItem gEgo)
					(PlayVMD 0 {5460.vmd} 0) ; Open
					(proc26_0 5460 self)
				)
				(3
					(SetFlag 69)
					(escapeMachine posn: 136 87 view: 8500)
					(flipcardMachine posn: 176 69 view: 8500 setHotspot: 0)
					(flipcardMachineF setHotspot: 0)
					(gEgo
						posn: 172 87
						normalize: 7
						setScaler: Scaler 71 28 133 82
						cel: 10
						show:
						setCycle: End self
					)
					(= global125 5)
					(gCurRoom drawPic: 8501)
				)
				(4
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(if (< local0 2)
				(self changeState: 2)
			else
				(self changeState: 3)
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
					(SetFlag 121)
					(switch global125
						(1
							(gEgo setHeading: 135 self)
						)
						(2
							(gEgo setHeading: 225 self 15)
						)
						(3
							(gEgo setHeading: 225 self)
						)
						(4
							(gEgo setHeading: 270 self)
						)
						(5
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(switch global125
						(2
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5284 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(4
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5284 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(5
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5284 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(ClearFlag 121)
					(+= global125 10)
					(gCurRoom newRoom: 8200)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(ClearFlag 121)
			(if (< global125 10)
				(+= global125 10)
			)
			(gCurRoom newRoom: 8200)
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
						(1
							(gEgo setHeading: 225 self)
						)
						(2
							(gEgo setHeading: 225 self 15)
						)
						(3
							(gEgo setHeading: 315 self)
						)
						(4
							(gEgo setHeading: 270 self)
						)
						(5
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(switch global125
						(2
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5284 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(4
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5284 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(5
							(escapeMachine posn: 183 89 view: 8400)
							(if (gCast contains: flipcardMachine)
								(flipcardMachine posn: 215 57 view: 8400)
							)
							(gEgo hide:)
							(DoRobot 5284 -7 28 gEgo -1 1)
							(gCurRoom drawPic: 8400)
						)
						(else
							(self changeState: 2)
						)
					)
				)
				(2
					(gCurRoom newRoom: 8200)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 8200)
		)
	)
)

(instance escapeMachine of View
	(properties
		x 136
		y 87
		view 8500
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoEscapeMachine)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance flipcardMachine of View
	(properties
		x 176
		y 69
		view 8500
		cel 1
	)
)

(instance flipcardMachineF of Feature
	(properties
		nsLeft 178
		nsTop 63
		nsRight 190
		nsBottom 91
		x 184
		y 77
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sDoFlipCardMachine)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance MakeupRoomDoor of ExitFeature
	(properties
		nsLeft 66
		nsTop 63
		nsRight 78
		nsBottom 85
		x 72
		y 74
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sEnterMakeupRoom)
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
				((Polygon new:) type: PTotalAccess init: 1 89 1 97 27 94 27 86 yourself:)
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
	(properties
		nsLeft 57
		nsTop 122
		nsRight 101
		nsBottom 129
		approachX 81
		approachY 128
		x 79
		y 125
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

