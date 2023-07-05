;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1400)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	rm1400 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm1400 of KQRoom
	(properties
		picture 1401
	)

	(method (init)
		(if (IsFlag 37)
			(self picture: 1405)
		)
		(super init:)
		(SetFlag 21)
		(= global109 1)
		(if (!= gPrevRoomNum 1410)
			(gKqMusic1
				number: 1400
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(if (IsFlag 37)
			(statueHead init:)
		else
			(waterTop init:)
		)
		(if (and (not (gEgo has: 22)) (not (IsFlag 342))) ; Turquoise_Shape
			(theShape init:)
		)
		(if
			(and
				(== gChapter 1)
				(not (gEgo has: 12)) ; Turquoise_Piece_b
				(not (gEgo has: 13)) ; Puzzle
				(not (IsFlag 13))
				(not (IsFlag 40))
			)
			(theKey init:)
		)
		(if (IsFlag 37)
			(if (IsFlag 320)
				(theBead init:)
			)
			(bowl init:)
			(myNorthExit init:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 201 93 200 81 186 83 141 80 79 92 20 100 0 111 0 143 320 142 320 102 239 90
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 37 115 62 102 139 104 153 103 159 109 167 116 156 131 37 123
					yourself:
				)
		)
		(if global116
			(gCurRoom setScript: scrollIt)
		else
			(switch gPrevRoomNum
				(1250
					(if (not (IsFlag 37))
						(self setScript: scrollIt)
					else
						(self setScript: fromStairs)
					)
				)
				(1410
					(gEgo init: posn: 163 126)
					(cond
						((IsFlag 333)
							(ClearFlag 333)
							(if
								(and
									(gCast contains: theBead)
									(gCast contains: theKey)
								)
								(theShape init:)
								(= local4 0)
								(= local2 theShape)
								(self setScript: getObject 0 22)
							else
								(= local4 22)
								(= local2 theShape)
								(self setScript: gusher)
							)
						)
						((IsFlag 342)
							(ClearFlag 342)
							(if
								(and
									(gCast contains: theBead)
									(gCast contains: theKey)
								)
								(= local4 1)
								(= local3 theShape)
								(self setScript: getObject 0 22)
							else
								(= local4 1)
								(= local3 theShape)
								(self setScript: getObject 0 22)
								(getObject next: sayOk)
							)
						)
						((IsFlag 334)
							(ClearFlag 334)
							(if
								(and
									(gCast contains: theBead)
									(gCast contains: theShape)
								)
								(= local4 0)
								(= local2 theKey)
								(self setScript: getObject 0 12)
							else
								(= local4 12)
								(= local2 theKey)
								(self setScript: gusher)
							)
						)
						((IsFlag 343)
							(ClearFlag 343)
							(if
								(and
									(gCast contains: theBead)
									(gCast contains: theShape)
								)
								(= local4 1)
								(= local3 theKey)
								(self setScript: getObject 0 12)
							else
								(= local4 1)
								(= local3 theKey)
								(self setScript: getObject 0 12)
								(getObject next: sayOk)
							)
						)
						((IsFlag 335)
							(ClearFlag 335)
							(if
								(and
									(gCast contains: theKey)
									(gCast contains: theShape)
								)
								(= local4 0)
								(= local2 theBead)
								(self setScript: getObject 0 11)
							else
								(= local4 11)
								(= local2 theBead)
								(self setScript: gusher)
							)
						)
						((IsFlag 306)
							(self setScript: gusher)
						)
						((IsFlag 12)
							(ClearFlag 12)
							(self setScript: sayOk)
						)
						(else
							(gGame handsOn:)
						)
					)
				)
				(else
					(gEgo init: posn: 60 125)
					(gGame handsOn:)
				)
			)
		)
		(if (not (IsFlag 37))
			(AddPicAt gThePlane 1402 0 136)
			(AddPicAt gThePlane 1403 0 272)
		)
	)

	(method (dispose)
		(if (!= gNewRoomNum 1410)
			(gKqMusic1 fade:)
		)
		(super dispose:)
	)
)

(instance gusher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 1414) ; WAVE
				(gGame handsOff:)
				(gEgo view: 8071 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(cond
					((== local4 11)
						(theBead dispose:)
					)
					((== local4 22)
						(theShape dispose:)
					)
					(else
						(= local4 12)
						(theKey dispose:)
					)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gKqSound1 number: 1413 play: self)
				(gEgo view: 8131 setLoop: 1 setCel: 0 setCycle: End)
			)
			(3
				(Load rsVIEW 1417)
				(leftWater init: setCel: 0 setCycle: End self)
				(rightWater init: setCel: 0 setCycle: End)
				(gKqSound1 number: 1414 setLoop: -1 play:)
			)
			(4
				(= register (gEgo cycleSpeed:))
				(rightWater dispose:)
				(leftWater dispose:)
				(waterGush init: setCel: 0 setCycle: End self)
			)
			(5
				(gEgo
					view: 8283
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End
				)
				(waterGush setCycle: CT 4 -1 self)
			)
			(6
				(waterGush setCycle: End self)
			)
			(7
				(gKqSound1 setLoop: 1 stop:)
				(EgoDead 2 self)
			)
			(8
				(waterGush dispose:)
				(cond
					((== local4 11)
						(theBead init:)
					)
					((== local4 22)
						(theShape init:)
					)
					(else
						(= local4 12)
						(theKey init:)
					)
				)
				(gEgo normalize: 1 put: local4)
				(ClearFlag 5)
				(ClearFlag 306)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayOk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8071 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(gEgo put: 11 setCycle: Beg self) ; Turquoise_Bead
				(theBead init:)
				(statueHead cycleSpeed: 12 setCycle: Osc 1 self)
				(gKqSound1 number: 1412 play:)
				(SetFlag 320)
				(SetFlag 330)
			)
			(2 0)
			(3
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scrollIt of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(waterTop setCycle: Fwd)
				(gThePlane setRect: 0 -270 319 406 priority: 1)
				(UpdatePlane gThePlane)
				(= seconds 3)
			)
			(1
				(= local0 -270)
				(= local1 136)
				(while (!= local1 406)
					(gThePlane setRect: 0 local0 319 local1 priority: 1)
					(+= local0 3)
					(+= local1 3)
					(= temp0 (Random 0 11))
					(waterTop cel: temp0)
					(UpdateScreenItem waterTop)
					(UpdatePlane gThePlane)
					(FrameOut)
				)
				(waterTop setCycle: ForwardCounter 4 self)
			)
			(2
				(gCurRoom newRoom: 1250)
			)
		)
	)
)

(instance fromStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 1411
					setLoop: 0
					setCel: 0
					posn: 202 82
					init:
					setCycle: End self
				)
			)
			(1
				(gEgo
					normalize: 1
					posn: 202 84
					setMotion: PolyPath 177 85 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1411)
				(self cue:)
			)
			(1
				(proc11_3 gEgo myNorthExit self)
			)
			(2
				(gEgo
					view: 1411
					setLoop: 1
					setCel: 0
					posn: 204 82
					setCycle: End self
				)
			)
			(3
				(gEgo posn: 224 72 setCel: 19 setCycle: End self)
			)
			(4
				(gEgo posn: 240 66 setCel: 19 setCycle: End self)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 1250)
			)
		)
	)
)

(instance getObject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8071 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(if local4
					(gEgo put: register)
					(local3 init:)
				else
					(gEgo get: register)
					(local2 dispose:)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo normalize: setCel: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance statueHead of Prop
	(properties
		x 87
		y 49
		view 1413
	)

	(method (init)
		(super init:)
		(self setPri: 119)
	)
)

(instance waterTop of Prop
	(properties
		x 87
		y 5
		view 1416
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 119)
	)
)

(instance waterGush of Prop
	(properties
		x 64
		y 61
		view 1417
	)
)

(instance leftWater of Prop
	(properties
		x 36
		y 40
		view 1414
	)
)

(instance rightWater of Prop
	(properties
		x 192
		y 71
		view 1415
	)
)

(instance theShape of View
	(properties
		approachX 163
		approachY 126
		x 122
		y 374
		view 1400
		loop 1
	)

	(method (init)
		(if (IsFlag 37)
			(self view: 1401 posn: 122 92)
		)
		(super init:)
		(self setPri: 112)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (gCast contains: theBead) (gCast contains: theKey))
					(= local4 0)
					(= local2 self)
					(gCurRoom setScript: getObject 0 22)
				else
					(gCurRoom setScript: gusher)
				)
			)
		)
	)
)

(instance theKey of View
	(properties
		approachX 163
		approachY 126
		x 113
		y 376
		view 1400
		loop 2
	)

	(method (init)
		(if (IsFlag 37)
			(self view: 1401 posn: 122 93)
		)
		(super init:)
		(self setPri: 112)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(Load 140 1413) ; WAVE
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(and
						(gCast contains: theBead)
						(gCast contains: theShape)
					)
					(= local4 0)
					(= local2 self)
					(gCurRoom setScript: getObject 0 12)
				else
					(gCurRoom setScript: gusher)
				)
			)
		)
	)
)

(instance theBead of View
	(properties
		approachX 163
		approachY 126
		x 123
		y 92
		view 1401
		signal 4129
	)

	(method (init)
		(super init:)
		(self setPri: 112)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(Load 140 1413) ; WAVE
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(and
						(gCast contains: theKey)
						(gCast contains: theShape)
					)
					(= local4 0)
					(= local2 self)
					(gCurRoom setScript: getObject 0 11)
					(ClearFlag 320)
					(ClearFlag 330)
				else
					(gCurRoom setScript: gusher)
				)
			)
		)
	)
)

(instance bowl of Feature
	(properties
		noun 1
		nsLeft 110
		nsTop 87
		nsRight 142
		nsBottom 98
		approachX 163
		approachY 126
		y 200
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom newRoom: 1410)
			)
			(16 ; Turquoise_Bead
				(gCurRoom setScript: sayOk)
			)
			(53 ; Turquoise_Shape
				(= local4 1)
				(gCurRoom setScript: getObject 0 22)
				(= local3 theShape)
			)
			(22 ; Turquoise_Piece_b
				(= local4 1)
				(gCurRoom setScript: getObject 0 12)
				(= local3 theKey)
			)
		)
	)
)

(instance myNorthExit of ExitFeature
	(properties
		approachX 200
		approachY 84
		x 288
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 10 ; Exit
			setHotspot: 10 10 ; Exit, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 85 205 80 276 36 276 0 320 0 320 48 287 63 247 83 217 88
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: toStairs)
	)
)

