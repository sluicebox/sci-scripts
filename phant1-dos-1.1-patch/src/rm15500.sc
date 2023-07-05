;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15500)
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
	rm15500 0
)

(instance rm15500 of ScaryRoom
	(properties
		picture 15505
		stepSound 4
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
		(cond
			((not (gCast contains: towerDoor)) 0)
			((!= param1 15500)
				(towerDoor hide:)
			)
			((IsFlag 267)
				(towerDoor view: 15503 posn: 51 94 show:)
			)
			(else
				(towerDoor view: 15502 posn: 39 95 show:)
			)
		)
		(if (IsFlag 204)
			(switch param1
				(15500
					(if (OneOf (gCurRoom script:) toAtticScr fromAtticScr)
						(atticDoor hide:)
					else
						(atticDoor show:)
					)
					(debris show:)
					(blackHole show:)
					(openWall hide:)
				)
				(else
					(atticDoor hide:)
					(debris hide:)
					(blackHole hide:)
					(openWall show:)
				)
			)
		)
	)

	(method (init)
		(gEgo init: setScaler: Scaler 131 87 131 92 normalize:)
		(if (IsFlag 204)
			(atticDoor init: hide:)
			(debris init: setPri: 20 hide:)
			(blackHole init: posn: 238 110 hide:)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(19000
				(if (== global125 52)
					(= global125 0)
					(= picture 15500)
					(gEgo hide:)
					(gCurRoom setScript: fromAtticMirrorScr)
				else
					(= picture 15500)
					(gCurRoom setScript: fromAtticScr)
				)
			)
			(26100
				(gEgo posn: 212 122 normalize: 1)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(proc1111_6)
				(gEgo
					view: 3670
					loop: 0
					cel: 0
					posn: 44 118
					setScale: 0
					setPri: 170
				)
				(= picture 15500)
				(if (IsFlag 204)
					(atticDoor approachVerbs: 4 setHotspot: 4 3 show:) ; Do, Do, Move
					(debris show:)
					(blackHole show:)
				)
				(gCurRoom setScript: climbStairs)
			)
		)
		(towerDoor init:)
		(if (IsFlag 267)
			(towerDoorExit init: 2)
		else
			(towerDoorFeat init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		)
		(if (and (IsFlag 189) (not (IsFlag 204)))
			(fakeWall init: setHotspot: 4 3 11 approachVerbs: 4) ; Do, Move, invHammer, Do
		)
		(if (IsFlag 204)
			(openWall init:)
			(if (and script (!= gPrevRoomNum 26100))
				(openWall hide:)
			)
			(openWallExit init: 4 approachVerbs: 0)
		)
		(stairExit init: 11)
		(super init: &rest)
	)
)

(instance debris of View
	(properties
		x 169
		y 110
		view 15501
	)
)

(instance atticDoor of View
	(properties
		x 231
		y 124
		view 15501
		loop 1
	)
)

(instance openWall of View
	(properties
		y 107
		view 15505
	)

	(method (doVerb theVerb)
		(openWallExit doVerb: theVerb)
	)
)

(instance openWallExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(= nsLeft (openWall nsLeft:))
		(= nsTop (openWall nsTop:))
		(= nsRight (openWall nsRight:))
		(= nsBottom (openWall nsBottom:))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(gGame handsOff:)
				(gCurRoom setScript: toAtticScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance towerDoor of View
	(properties
		view 15502
	)
)

(instance towerDoorFeat of Feature
	(properties
		nsLeft 263
		nsTop 1
		nsRight 284
		nsBottom 129
		x 273
		y 129
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: scene368Scr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance towerDoorExit of ExitFeature
	(properties
		nsLeft 263
		nsTop 1
		nsRight 284
		nsBottom 129
		nextRoom 26100
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: toTowerScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fakeWall of Feature
	(properties
		x 10
		y 110
	)

	(method (init)
		(self createPoly: 0 0 5 0 27 15 27 95 0 106)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(if (IsFlag 204)
					(gCurRoom newRoom: 19000)
				else
					(gCurRoom setScript: pushWallScr)
				)
			)
			(11 ; invHammer
				(gGame handsOff:)
				(gCurRoom setScript: hammerScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairExit of ExitFeature
	(properties
		nsLeft 134
		nsTop 95
		nsRight 198
		nsBottom 109
		nextRoom 15100
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: downStairsScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance climbStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setCycle: End self)
				)
				(1
					(gEgo
						setScaler: Scaler 131 87 131 92
						posn: 128 105
						normalize: 1
					)
					(gCurRoom drawPic: 15505 picture: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo
						setScaler: Scaler 131 87 131 92
						posn: 128 105
						normalize: 1
					)
					(gCurRoom drawPic: 15505 picture: 15505)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance downStairsScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 128) (== (gEgo y:) 105))
							(self cue:)
						)
						((and (== (gEgo x:) 212) (== (gEgo y:) 122))
							(gEgo setHeading: 270 self)
						)
						((and (== (gEgo x:) 26) (== (gEgo y:) 117))
							(gEgo setHeading: 45 self)
						)
					)
				)
				(1
					(gEgo
						view: 3671
						loop: 0
						cel:
							(if
								(and
									(== (gEgo x:) 128)
									(== (gEgo y:) 105)
								)
								0
							else
								18
							)
						setScale: 0
						posn: 80 115
						setPri: 170
						setCycle: End self
					)
					(gCurRoom drawPic: 15500)
				)
				(2
					(gCurRoom newRoom: 15100)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 15100)
				)
			)
		)
	)
)

(instance scene368Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 128) (== (gEgo y:) 105))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 212) (== (gEgo y:) 122))
							(gEgo setHeading: 45 self 8)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(gEgo hide:)
					(towerDoor dispose:)
					(proc1111_7 3680 24 14 gEgo -1 1)
					(gCurRoom drawPic: 15500)
				)
				(2
					(gCurRoom newRoom: 26100)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 26100)
				)
			)
		)
	)
)

(instance toTowerScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 128) (== (gEgo y:) 105))
							(gEgo setHeading: 180 self)
						)
						((and (== (gEgo x:) 212) (== (gEgo y:) 122))
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 26100)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 26100)
				)
			)
		)
	)
)

(instance pushWallScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (IsFlag 205)
						(proc1111_7 4690 135 -10)
					else
						(SetFlag 205)
						(proc1111_7 4681 160 -5)
					)
					(gCurRoom drawPic: 15500)
				)
				(1
					(gEgo posn: 26 117 normalize: 1)
					(gCurRoom drawPic: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo posn: 26 117 normalize: 1)
					(gCurRoom drawPic: 15505)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance blackHole of View
	(properties
		view 15506
	)
)

(instance hammerScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsVIEW 15501)
					(fakeWall setHotspot: 4 3) ; Do, Move
					(proc1111_7 4700 75 4)
					(gCurRoom drawPic: 15500)
				)
				(1
					(SetFlag 204)
					(blackHole init: posn: 238 110)
					(proc1111_7 4701 153 5)
				)
				(2
					(atticDoor init: setPri: 20 hide:)
					(debris init: setPri: 20)
				)
				(3
					(gEgo posn: 26 117 normalize: 1)
					(openWall init:)
					(openWallExit init: 4 approachVerbs: 0)
					(gCurRoom drawPic: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(SetFlag 204)
					(fakeWall setHotspot: 4 3) ; Do, Move
					(blackHole init: posn: 238 110)
					(gEgo posn: 26 117 normalize: 1)
					(atticDoor init:)
					(debris init: setPri: 20)
					(openWall init:)
					(openWallExit init: 4 approachVerbs: 0)
					(gCurRoom drawPic: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance toAtticScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (and (== (gEgo x:) 26) (== (gEgo y:) 117))
						(self cue:)
					else
						(gEgo setHeading: 270 self)
					)
				)
				(1
					(openWallExit dispose:)
					(gEgo hide:)
					(proc1111_7 4702 68 5 gEgo -1 1)
					(gCurRoom drawPic: 15500)
				)
				(2
					(gCurRoom newRoom: 19000)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 19000)
				)
			)
		)
	)
)

(instance fromAtticScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 4703 68 5)
				)
				(1
					(gEgo posn: 26 117 normalize: 1)
					(gCurRoom drawPic: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo posn: 26 117 normalize: 1)
					(gCurRoom drawPic: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance fromAtticMirrorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= cycles 1)
				)
				(1
					(proc1111_7 4703 68 5)
					(gGame fade: 0 (gGame intensity:) 1)
				)
				(2
					(gEgo posn: 26 117 normalize: 1 show:)
					(global114 endPause:)
					(gCurRoom drawPic: 15505)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo posn: 26 117 normalize: 1 show:)
					(global114 endPause:)
					(gGame fade: 0 (gGame intensity:) 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

