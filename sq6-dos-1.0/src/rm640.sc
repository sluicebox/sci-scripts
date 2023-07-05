;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Styler)
(use PolyPath)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	local0
)

(instance rm640 of SQRoom
	(properties
		noun 1
		picture 640
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 194 77 180 77 181 78 171 451 167 501 129 573 171 515 181 372 184 174
					yourself:
				)
		)
		(super init:)
		((gCurRoom plane:) setRect: 0 -416 319 155)
		(UpdatePlane plane)
		(Load 140 642) ; WAVE
		(Load rsVIEW 647 642)
		(self setScript: sEgoEnter)
		(if (not (IsFlag 92))
			(twinkie approachVerbs: 4 init:) ; Do
		)
		(if (IsFlag 93)
			(if (not (IsFlag 92))
				(tablet posn: 174 447 cel: 1 init:)
			)
		else
			(tablet approachVerbs: 4 init:) ; Do
		)
		(gGSound2 number: 640 loop: -1 play:)
		(esophagus init:)
		(lastEndOfEso init:)
		(lungsL init:)
		(lungsR init:)
		(upperEso init:)
		(lowerEso init:)
		(artL init:)
		(artR init:)
		(trachea init:)
		(secTrachea init:)
		(exitToStomach init: gTheExitSCursor approachVerbs: 10) ; ExitDown
		(self buildPic:)
	)

	(method (doit)
		(cond
			((and (gEgo mover:) (< ((gEgo mover:) yLast:) (gEgo y:)))
				(gEgo setLoop: 2 1)
			)
			((and (gEgo mover:) (> ((gEgo mover:) yLast:) (gEgo y:)))
				(gEgo setLoop: 3 1)
			)
		)
		(super doit:)
	)

	(method (buildPic)
		(AddPicAt plane 641 0 139)
		(AddPicAt plane 642 0 278)
		(AddPicAt plane 643 0 417)
	)

	(method (updateRect &tmp temp0 temp1 temp2 temp3 temp4)
		(cond
			(
				(and
					(> (+ (gEgo y:) (gThePlane top:)) 118)
					(> (gThePlane bottom:) 154)
					(gEgo mover:)
					(> (gEgo y:) ((gEgo mover:) yLast:))
				)
				(= temp1 (- 126 (/ (- (gEgo nsBottom:) (gEgo nsTop:)) 2)))
				(if (< (= temp4 (- (gThePlane bottom:) 126)) 154)
					(= temp1 (- (gThePlane bottom:) 155))
				)
				(gThePlane
					setRect:
						(gThePlane left:)
						(- (gThePlane top:) temp1)
						(gThePlane right:)
						(- (gThePlane bottom:) temp1)
				)
				(UpdatePlane gThePlane)
			)
			(
				(and
					(< (+ (gEgo y:) (gThePlane top:)) 25)
					(< (gThePlane top:) -3)
					(gEgo mover:)
					(< (gEgo y:) ((gEgo mover:) yLast:))
				)
				(= temp1 (- 126 (/ (- (gEgo nsBottom:) (gEgo nsTop:)) 2)))
				(if (> (= temp3 (+ (gThePlane top:) 126)) 0)
					(= temp1 (- 126 temp3))
				)
				(gThePlane
					setRect:
						(gThePlane left:)
						(+ (gThePlane top:) temp1)
						(gThePlane right:)
						(+ (gThePlane bottom:) temp1)
				)
				(UpdatePlane gThePlane)
			)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(if (and (IsFlag 99) (not (IsFlag 98)))
			(WalkieTalkie killRobot:)
		)
		(super dispose:)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 2)
		(if
			(and
				(> (+ (gEgo y:) temp2) 81)
				(> temp4 155)
				(gEgo mover:)
				(> (gEgo y:) ((gEgo mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (- temp2 temp0) temp3 (- (+ temp2 556) temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (gEgo y:) temp2) 79)
				(< temp2 0)
				(gEgo mover:)
				(< (gEgo y:) ((gEgo mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (+ temp2 temp0) temp3 (+ temp2 556 temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sEgoEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gPrevRoomNum
					(620
						(cond
							((IsFlag 99)
								(gEgo setScript: sLookingDown)
								(self dispose:)
							)
							((IsFlag 98)
								(gEgo
									view: 6411
									setLoop: 0 1
									setCycle: Walk
									posn: 168 495
									init:
								)
								(gGame handsOn:)
							)
							(else
								(gEgo
									view: 6411
									setLoop: 0 1
									setCycle: Walk
									posn: 168 495
									init:
									setMotion: PolyPath 178 427
								)
								(gGame handsOn:)
							)
						)
					)
					(else
						(gEgo
							view: 6411
							setLoop: 0 1
							setCycle: Walk
							posn: 168 495
							init:
							setMotion: PolyPath 178 427
						)
						(gGame handsOn:)
					)
				)
				(= cycles 3)
			)
			(1
				(gEgo code: scrollCode)
				(self dispose:)
			)
		)
	)
)

(instance sLookingDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: 0
					posn: 168 495
					view: 6400
					setCel: 1 1
					setLoop: 1 1
					init:
				)
				(= cycles 3)
			)
			(1
				(= ticks 300)
			)
			(2
				(SetFlag 98)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sTabletFallingOnTwinkie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 3 469)
				(gEgo
					posn: 184 97
					setSpeed: 12
					view: 645
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(tablet hide:)
				(gEgo view: 646 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(sound1 number: 642 loop: 0 play:)
				(gEgo loop: 1 cel: 6 setCycle: End self)
			)
			(4
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(gEgo
					posn: 184 97
					view: 6411
					setLoop: 0 1
					setSpeed: 6
					setCycle: Walk
				)
				(tablet posn: 174 447 cel: 1 show:)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTabletFalling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 184 97
					setSpeed: 12
					view: 645
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(tablet hide:)
				(gEgo view: 646 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					posn: 184 97
					view: 6411
					setLoop: 0 1
					setSpeed: 6
					setCycle: Walk
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoFalls of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= scratch 10)
				(gEgo
					view: 642
					loop: 0
					cel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(1
				(ShakePlane gThePlane 2 3)
				(gEgo view: 641 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if (< (gEgo y:) 484)
					(if (IsFlag 202)
						(gEgo y: (+ (gEgo y:) 5))
						(= temp1 ((gCurRoom plane:) left:))
						(= temp2 ((gCurRoom plane:) top:))
						(= temp3 ((gCurRoom plane:) right:))
						(= temp4 ((gCurRoom plane:) bottom:))
						(= temp0 5)
						((gCurRoom plane:)
							setRect:
								temp1
								(- temp2 5)
								temp3
								(- (+ temp2 556) temp0)
						)
						(UpdatePlane (gCurRoom plane:))
						(-- state)
					else
						(gEgo posn: 185 419)
						((gCurRoom plane:) setRect: 0 -416 319 155)
					)
				)
				(= cycles 1)
			)
			(3
				(ShakePlane gThePlane 2 1)
				(-- scratch)
				(if scratch
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(gEgo view: 6411 setLoop: 0 1 setSpeed: 6 setCycle: Walk)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTwinkieDislodged of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 3 468)
				(SetFlag 92)
				(SetFlag 99)
				(if (> (gEgo y:) 420)
					(gEgo setMotion: PolyPath (gEgo x:) 420 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= scratch 20)
				(gEgo
					view: 642
					loop: 0
					cel: 0
					setSpeed: 12
					setPri: 650
					setCycle: End self
				)
			)
			(2
				(ShakePlane gThePlane 2 (Random 3 6))
				(if (< (gEgo y:) 425)
					(gEgo view: 641 loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo view: 647 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(if (not (IsFlag 202))
					(gEgo view: 647 loop: 1 cel: 0 setCycle: Fwd)
					((gCurRoom plane:) setRect: 0 -360 319 196)
					(UpdatePlane (gCurRoom plane:))
					(self changeState: 7)
				else
					(= cycles 1)
				)
			)
			(5
				(= temp0 10)
				(if (< (gEgo y:) 420)
					(gEgo
						view: 647
						loop: 1
						cel: 0
						setCycle: Fwd
						y: (+ (gEgo y:) temp0)
					)
					(= temp1 ((gCurRoom plane:) left:))
					(= temp2 ((gCurRoom plane:) top:))
					(= temp3 ((gCurRoom plane:) right:))
					(= temp4 ((gCurRoom plane:) bottom:))
					((gCurRoom plane:)
						setRect:
							temp1
							(- temp2 temp0)
							temp3
							(- (+ temp2 556) temp0)
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(= temp0 10)
				(if (> ((gCurRoom plane:) top:) -350)
					(= temp1 ((gCurRoom plane:) left:))
					(= temp2 ((gCurRoom plane:) top:))
					(= temp3 ((gCurRoom plane:) right:))
					(= temp4 ((gCurRoom plane:) bottom:))
					((gCurRoom plane:)
						setRect:
							temp1
							(- temp2 temp0)
							temp3
							(- (+ temp2 556) temp0)
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
					(gEgo y: (+ (gEgo y:) temp0))
				)
				(= cycles 1)
			)
			(7
				(gEgo
					posn: 185 419
					view: 647
					loop: 2
					cel: 0
					setCycle: End self
				)
				(= cycles 1)
			)
			(8
				(= temp0 1)
				(if (> ((gCurRoom plane:) top:) -360)
					(= temp1 ((gCurRoom plane:) left:))
					(= temp2 ((gCurRoom plane:) top:))
					(= temp3 ((gCurRoom plane:) right:))
					(= temp4 ((gCurRoom plane:) bottom:))
					((gCurRoom plane:)
						setRect:
							temp1
							(- temp2 temp0)
							temp3
							(- (+ temp2 556) temp0)
					)
					(UpdatePlane (gCurRoom plane:))
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(ShakePlane gThePlane 2 (Random 1 3))
				(gEgo view: 647 loop: 3 cel: 0 setCycle: End self)
			)
			(10
				(if (and (IsFlag 93) (< (tablet y:) 465))
					(ShakePlane gThePlane 2 1)
					(tablet y: (+ (tablet y:) 3))
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(if (IsFlag 93)
					(tablet dispose:)
				)
				(lastEndOfEso hide:)
				(esophagus hide:)
				(gEgo put: 79 hide:) ; Pinfeather
				(twinkie hide:)
				(= gAutoRobot
					((WalkieTalkie new:)
						x: 93
						y: 360
						priority: 600
						holdOnLastCel: 1
						init: 0 643 self
						start:
						yourself:
					)
				)
			)
			(12
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sJumpOnTwinkie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 3 setPri: 610)
				(= cycles 1)
			)
			(1
				(gEgo cycleSpeed: 12 setHeading: 180 self)
			)
			(2
				(gEgo setMotion: MoveTo 180 463 self)
			)
			(3
				(gEgo view: 6410 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo cel: 0 setCycle: End self)
			)
			(6
				(gEgo normalize: 2 setPri: 610)
				(= cycles 1)
			)
			(7
				(gEgo setMotion: MoveTo 173 453 self)
			)
			(8
				(gEgo
					setPri: -1
					view: 6411
					setLoop: 0 1
					setSpeed: 6
					setCycle: Walk
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoExitSouth of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 202)
					(gEgo
						ignoreActors: 1
						setCycle: Walk
						setMotion: MoveTo 138 581 self
					)
				else
					(gEgo
						ignoreActors: 1
						setCycle: Walk
						setMotion: MoveTo 138 550 self
					)
				)
			)
			(1
				(gGame handsOff:)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance twinkie of View
	(properties
		noun 4
		approachX 173
		approachY 453
		x 124
		y 452
		view 640
		signal 20513
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: sJumpOnTwinkie)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance esophagus of View
	(properties
		noun 1
		x 177
		y 451
		view 6400
		signal 20513
	)

	(method (init)
		(self setPri: 100)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(146 ; Pinfeather
				(if (IsFlag 92)
					(gCurRoom setScript: sEgoFalls)
				else
					(gCurRoom setScript: sTwinkieDislodged)
				)
			)
			(1 ; Look
				(gMessager say: 1 1 1) ; "This is the lower part of the esophagus. Just below this is the stomach."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tablet of View
	(properties
		noun 9
		approachX 186
		approachY 64
		x 113
		y 49
		view 640
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (SetFlag 93))
					(SetFlag 93)
					(if (IsFlag 92)
						(gCurRoom setScript: sTabletFalling)
					else
						(gCurRoom setScript: sTabletFallingOnTwinkie)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lastEndOfEso of View
	(properties
		noun 1
		x 151
		y 555
		view 6400
		loop 2
	)

	(method (init)
		(self setPri: 580)
		(super init:)
	)
)

(instance lungsR of Feature
	(properties
		noun 2
		sightAngle 40
		x 280
		y 228
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 169 294 163 260 168 249 183 241 203 241 214 248 242 245 269 263 295 266 325 259 361 270 400 262 444 268 460 319 472 319 294
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lungsL of Feature
	(properties
		noun 2
		sightAngle 40
		x 24
		y 228
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 163 14 164 26 170 40 183 45 197 48 218 45 221 48 228 42 279 39 322 47 350 60 361 59 409 77 436 73 464 0 480
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance upperEso of Feature
	(properties
		noun 1
		sightAngle 40
		x 189
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 135 0 227 0 244 55 231 146 223 286 122 286 128 255 140 225 151 181 150 138 165 85 161 60
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(146 ; Pinfeather
				(if (IsFlag 92)
					(gCurRoom setScript: sEgoFalls)
				else
					(gCurRoom setScript: sTwinkieDislodged)
				)
			)
			(1 ; Look
				(gMessager say: 1 1 2) ; "This is the upper part of the esophagus. The larynx branches off from here, winding its way down to the bronchi and the lungs. Looking above, you see some sort of medical equipment blocking the way to the mouth. Looks like that's not an option for an escape route."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerEso of Feature
	(properties
		noun 1
		sightAngle 40
		x 178
		y 445
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 497 203 508 222 489 235 425 224 386 214 366 223 289 121 289 142 434
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(146 ; Pinfeather
				(if (IsFlag 92)
					(gCurRoom setScript: sEgoFalls)
				else
					(gCurRoom setScript: sTwinkieDislodged)
				)
			)
			(1 ; Look
				(gMessager say: 1 1 1) ; "This is the lower part of the esophagus. Just below this is the stomach."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance artR of Feature
	(properties
		noun 8
		sightAngle 40
		x 250
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 0 264 102 260 118 263 143 272 159 319 148 319 169 313 165 269 165 250 178 239 207 247 230 245 237 231 235 240 131 249 78 249 52 235 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance artL of Feature
	(properties
		noun 8
		sightAngle 40
		x 67
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 55 0 54 25 57 46 50 86 50 119 42 145 32 152 1 151 0 162 25 166 44 188 46 203 65 213 87 237 88 184 79 177 81 138 75 127 78 118 72 108 76 95 70 84 73 76 68 67 71 59 71 50 75 43 78 30 83 26 84 17 90 11 90 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trachea of Feature
	(properties
		noun 5
		sightAngle 40
		x 113
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 72 113 73 84 68 71 59 72 80 71 86 79 94 75 105 78 113 81 118 79 125 83 139 81 148 88 181 89 197 90 231 81 258 40 286 44 334 49 348 62 361 117 326 114 291 115 278 120 255 143 196 143 156 145 118 156 92 156 67
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance secTrachea of Feature
	(properties
		noun 5
		sightAngle 40
		x 243
		y 311
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 264 232 284 227 301 222 323 220 336 260 359 266 321 258 286 246 269
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitToStomach of ExitFeature
	(properties
		sightAngle 40
		approachX 138
		approachY 581
		x 148
		y 576
		nextRoom 620
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 504 149 501 180 502 199 512 200 540 93 539 104 511
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

