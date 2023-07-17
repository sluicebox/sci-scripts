;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 7
	local5
	local6
)

(instance rm700 of SQRoom
	(properties
		noun 1
	)

	(method (init)
		(if (!= gPrevRoomNum 680)
			(gGSound1 number: 640 setLoop: -1 play: setVol: 127)
		)
		(before init:)
		(afterMath init:)
		(if (IsFlag 197)
			(gCurRoom addObstacle: afterMath)
		else
			(gCurRoom addObstacle: before)
		)
		(gEgo init: normalize: setScaler: Scaler 90 47 350 1 setPri: 60)
		(super init:)
		(gGame handsOff:)
		(self drawPic: 700)
		(stone init:)
		(switch gPrevRoomNum
			(720
				(= local2 1)
				(= local3 0)
				(gEgo enterRoom: -10 60 9 60 self)
				((gCurRoom plane:) setRect: 0 0 319 458)
				(gGame handsOn:)
				(if (IsFlag 105)
					(stone setScript: sRunAway)
				)
			)
			(680
				((gCurRoom plane:) setRect: 0 -320 319 138)
				(gEgo setScript: sEnterRight)
			)
			(else
				(= local2 0)
				(= local3 1)
				(gEgo enterRoom: 9 459 70 436 self)
				((gCurRoom plane:) setRect: 0 -320 319 138)
			)
		)
		(UpdatePlane plane)
		(exit660 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(exit680 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(exit720 init: (gTheExitWCursor new:) approachVerbs: 8) ; ExitLeft
		(pipe init: approachVerbs: 8) ; ExitLeft
		(topLine init:)
		(bottomLine init:)
		(duodenum init:)
		(membrane init:)
		(pancreas init:)
		(if (or (IsFlag 105) (IsFlag 197))
			(gEgo setPri: 51)
			(wedge init: setCel: 5)
			(stones init: setCel: 16)
		)
		(self buildPic:)
		(self setScript: sWaitAndGiveCode)
	)

	(method (doit)
		(cond
			(script)
			((topLine onMe: gEgo)
				(gCurRoom setScript: sWalkToBottom)
			)
			((bottomLine onMe: gEgo)
				(gCurRoom setScript: sWalkToTop)
			)
		)
		(super doit:)
	)

	(method (buildPic)
		(AddPicAt plane 701 0 139)
		(AddPicAt plane 702 0 278)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (== gNewRoomNum 720)
			(gGSound1 fade: 0 3 1 1)
		)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(gEgo setScale: 0 normalize:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; Duct_Tape
				(gMessager say: noun theVerb) ; "That sounds like a good idea but it won't help here."
			)
			(1 ; Look
				(if local2
					(gMessager say: noun theVerb 2) ; "This is the cystic duct. You are quite near where the gall bladder becomes part of the bile parade."
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) top:))
		(= temp2 ((gCurRoom plane:) left:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(= temp0 0)
		(= local0 0)
		(= local1 0)
		(if (and (> (+ (gEgo y:) temp1) 100) (> temp4 138))
			(= local1 -2)
			(= temp0 1)
		)
		(if (and (< (+ (gEgo y:) temp1) 80) (< temp1 0))
			(= local1 2)
			(= temp0 1)
		)
		(if temp0
			((gCurRoom plane:)
				setRect:
					(+ temp2 local0)
					(+ temp1 local1)
					(+ temp3 local0)
					(+ temp1 458 local1)
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sWaitAndGiveCode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo code: scrollCode)
				(self dispose:)
			)
		)
	)
)

(instance sGetStones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< (gEgo x:) 234)
					(gEgo setMotion: MoveTo 208 411 self)
				else
					(gEgo setMotion: MoveTo 261 411 self)
				)
			)
			(1
				(if (> (gEgo x:) 234)
					(gEgo setHeading: 270 self)
				else
					(gEgo setHeading: 90 self)
				)
			)
			(2
				(gEgo view: 703)
				(if (> (gEgo x:) 234)
					(gEgo setLoop: 1 setCel: 0)
				else
					(gEgo setLoop: 0 setCel: 0)
				)
				(gEgo get: 51 cycleSpeed: 9) ; Gallstone
				(gEgo setCycle: End self)
			)
			(3
				(gGame points: 1)
				(gEgo normalize: (gEgo loop:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 1)
				(= local2 0)
				(= local3 1)
				(gEgo posn: 330 422 setMotion: MoveTo 295 416 self)
			)
			(1
				(= local5 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRunAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: local4 1 setMotion: MoveTo 110 85 self)
			)
			(1
				(gEgo setSpeed: local4 1 setMotion: MoveTo 152 104 self)
			)
			(2
				(gGSound2 loop: -1 number: 721 play:)
				(gEgo setMotion: MoveTo 168 119)
				(stone cycleSpeed: local4 1 setCycle: CT 8 1 self)
			)
			(3
				(gEgo setMotion: 0 setHeading: 270)
				(stone setCycle: CT 14 1 self)
			)
			(4
				(gEgo setMotion: MoveTo 168 119)
				(stone setCycle: End self)
			)
			(5
				(gGSound2 stop:)
				(gEgo hide:)
				(gCurRoom style: 0)
				(gCurRoom exitStyle: 0)
				(gCurRoom drawPic: -1)
				(pipe hide:)
				(stone hide:)
				(stones hide:)
				(wedge hide:)
				(= ticks 1)
			)
			(6
				(= local6 (gEgo code:))
				(gEgo code: 0)
				(if (IsFlag 202)
					(= gAutoRobot
						((WalkieTalkie new:)
							x: 75
							y: 25
							priority: 90
							init: 0 700 self
							start:
							yourself:
						)
					)
				else
					(= gAutoRobot
						((WalkieTalkie new:)
							x: 75
							y: 8
							priority: 90
							init: 0 700 self
							start:
							yourself:
						)
					)
				)
			)
			(7
				((gCurRoom plane:) setRect: 0 -320 319 138)
				(= cycles 3)
			)
			(8
				(gCurRoom drawPic: 700)
				(gCurRoom buildPic:)
				(gEgo
					show:
					view: 702
					setPri: -1
					posn: 120 424
					setLoop: 0
					setCel: 0
					setCycle: CT 16 1
				)
				(gGSound2 loop: 0 number: 722 play:)
				(stones
					posn: 220 412
					show:
					setCel: 0
					cycleSpeed: (+ local4 2)
					setCycle: End
				)
				(wedge
					posn: 247 292
					show:
					setCel: 0
					cycleSpeed: (+ local4 1)
					setCycle: End self
				)
			)
			(9
				(= ticks 180)
			)
			(10
				((gCurRoom obstacles:) delete: before)
				(gCurRoom addObstacle: afterMath)
				(gEgo code: local6)
				(gEgo setCycle: End self)
			)
			(11
				(gEgo normalize: 1)
				(gCurRoom style: 14)
				(gCurRoom exitStyle: 13)
				(gEgo setPri: 51)
				(gGame handsOn:)
				(SetFlag 197)
				(= ticks 1)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance sGoto680 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 417 self)
			)
			(1
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance sGoto720 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 1)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -16 52 self)
			)
			(1
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance sGoto660 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 10 460 self)
			)
			(1
				(gCurRoom newRoom: 660)
			)
		)
	)
)

(instance sWalkToBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 215 155 self)
			)
			(1
				(gEgo hide:)
				(gEgo setMotion: MoveTo 247 285 self)
			)
			(2
				(gEgo show:)
				(gEgo setMotion: MoveTo 246 328 self)
			)
			(3
				(gGame handsOn:)
				(= local2 0)
				(= local3 1)
				(self dispose:)
			)
		)
	)
)

(instance sWalkToTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 252 285 self)
			)
			(1
				(gEgo hide:)
				(gEgo setMotion: MoveTo 215 145 self)
			)
			(2
				(gEgo show:)
				(gEgo setMotion: MoveTo 168 119 self)
			)
			(3
				(gGame handsOn:)
				(= local2 1)
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance stone of Prop
	(properties
		noun 6
		view 710
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 posn: 64 7)
	)
)

(instance wedge of Prop
	(properties
		noun 7
		view 701
	)

	(method (init)
		(super init:)
		(self setPri: 50 setLoop: 0 setCel: 0 posn: 247 292)
	)
)

(instance stones of Prop
	(properties
		noun 5
		view 701
		signal 16417
	)

	(method (init)
		(self setLoop: 1 setCel: 0 setPri: 50 posn: 220 412)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gEgo has: 51)) ; Gallstone
					(gEgo setScript: sGetStones)
				else
					(gMessager say: noun theVerb 4) ; "You don't need any more stones -- at least not that kind!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pipe of View
	(properties
		approachX 10
		approachY 460
		y 384
		view 700
		signal 20513
	)

	(method (init)
		(self setPri: 500)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 3 4 2 17) ; Walk, Do, Talk, ???
				(gMessager say: noun 0 3)
			)
			((== theVerb 8) ; ExitLeft
				(gEgo setScript: sGoto660)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit660 of ExitFeature
	(properties
		approachX 10
		approachY 460
		x -10
		y 470
		nextRoom 660
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 387 28 390 21 399 20 410 25 420 40 431 58 438 77 441 77 445 47 458 0 458 0 399 10 393
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; ExitRight
			(gEgo setScript: sGoto660)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance exit720 of ExitFeature
	(properties
		approachX -16
		approachY 47
		x -16
		y 47
		nextRoom 720
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 8 0 8 79 0 87 yourself:)
		)
		(super init: &rest)
	)

	(method (initialize))

	(method (doVerb theVerb)
		(if (== theVerb 8) ; ExitLeft
			(gEgo setScript: sGoto720)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance exit680 of ExitFeature
	(properties
		approachX 309
		approachY 416
		x 325
		y 500
		nextRoom 680
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 313 355 313 427 320 429 320 356
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doit)
		(if (and (> (gEgo x:) 305) (not local5))
			(= local5 1)
			(gEgo setScript: sGoto680)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; ExitRight
			(gEgo setScript: sGoto680)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance topLine of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 124 198 110 201 114 162 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance duodenum of Feature
	(properties
		noun 2
		sightAngle 40
		x 159
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 197 28 177 90 148 97 143 109 141 138 132 173 127 192 119 208 115 225 112 245 112 259 115 261 99 279 65 319 65 319 202 319 203 0 203
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4 2 17) ; Walk, Do, Talk, ???
			(gMessager say: noun 0 3) ; "You can't actually do that. This is a cutaway view."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pancreas of Feature
	(properties
		noun 3
		sightAngle 40
		x 159
		y 389
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 320 0 320 0 458 319 458 319 431 298 424 255 421 222 421 163 426 112 435 76 446 49 456 7 455 6 394 34 382 87 367 130 357 170 337
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4 2 17) ; Walk, Do, Talk, ???
			(gMessager say: noun 0 3) ; "You can't actually do that. This is a cutaway view."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance membrane of Feature
	(properties
		noun 4
		sightAngle 40
		x 147
		y 287
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 289 202 275 187 270 174 270 127 284 108 292 92 302 104 304 111 294 122 289 134 289 144 293 147 296 154 293 162 286 172 283 180 282 189 283
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4 2 17) ; Walk, Do, Talk, ???
			(gMessager say: noun 0 3) ; "You can't actually do that. This is a cutaway view."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bottomLine of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 315 255 315 251 320 228 320
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance afterMath of Polygon
	(properties)

	(method (init)
		(self type: PContainedAccess)
		(super
			init: 319 415 235 406 232 381 247 347 247 333 240 333 240 346 209 397 170 410 59 435 61 437 73 439 209 410 319 421
		)
	)
)

(instance before of Polygon
	(properties)

	(method (init)
		(self type: PContainedAccess)
		(super
			init: 62 436 71 437 208 408 318 419 318 417 232 408 230 381 246 346 250 222 192 130 169 116 149 106 102 85 6 58 3 60 20 65 78 80 121 95 184 127 246 266 243 346 211 398 177 410
		)
	)
)

