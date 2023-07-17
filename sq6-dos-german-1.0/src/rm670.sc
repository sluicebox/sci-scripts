;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use n666)
(use Scaler)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm670 0
)

(local
	local0
	local1
	local2
)

(instance rm670 of SQRoom
	(properties
		noun 1
		picture 670
	)

	(method (updateRect))

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 192 33 109 102 115 104 197 33
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 7 337 7 353 35 353 35 337
					yourself:
				)
		)
		(gEgo
			init:
			normalize:
			setScaler: Scaler 100 30 86 36
			code: scrollCode
		)
		(wallF init:)
		(gWalkHandler add: self)
		(super init:)
		(switch gPrevRoomNum
			(730
				(= local1 2)
				(gEgo loop: 3 posn: 19 350)
				((gCurRoom plane:) setRect: 0 -222 319 138)
				(gGame handsOn:)
				(gGSound1 number: 640 setLoop: -1 play:)
			)
			(else
				(= local1 0)
				(gGame handsOff:)
				(gEgo
					loop: 2
					posn: 165 30
					setPri: 20
					setMotion: MoveTo 198 34 self
				)
				((gCurRoom plane:) setRect: 0 0 319 360)
				(if (!= (gGSound1 number:) 640)
					(gGSound1 number: 640 setLoop: -1 play:)
				)
			)
		)
		(UpdatePlane plane)
		(wormMouth init: setCycle: Fwd ignoreActors:)
		(if (IsFlag 484)
			(wormMouth cycleSpeed: 2)
		)
		(tapeWorm init:)
		(bottomD init:)
		(exit660 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(super doit:)
		(cond
			((gCurRoom script:) 0)
			((gEgo script:) 0)
			((and (>= (gEgo y:) 85) (< (gEgo y:) 90) (== local1 0))
				(gCurRoom setScript: sWalkUpOver)
			)
			((and (>= (gEgo y:) 85) (< (gEgo y:) 88) (== local1 1))
				(gCurRoom setScript: sWalkDownUnder)
			)
		)
		(if
			(and
				(not (IsFlag 202))
				(!= (gCurRoom script:) sWalkDownUnder)
				(!= (gCurRoom script:) sWalkUpOver)
				(!= (gCurRoom script:) sOffTop)
				(!= (gCurRoom script:) sGetDownOnWall)
			)
			(= temp1 ((gCurRoom plane:) left:))
			(= temp2 ((gCurRoom plane:) top:))
			(= temp3 ((gCurRoom plane:) right:))
			(= temp4 ((gCurRoom plane:) bottom:))
			(= temp0 8)
			(if
				(and
					(> (+ (gEgo y:) temp2) 81)
					(> temp4 139)
					(gEgo mover:)
					(> (gEgo y:) ((gEgo mover:) yLast:))
				)
				(= temp5 (- temp2 temp0))
				(= temp5 (Max -222 temp5))
				(= temp6 (- (+ temp2 360) temp0))
				(= temp6 (Max 138 temp6))
				((gCurRoom plane:) setRect: temp1 temp5 temp3 temp6)
				(UpdatePlane (gCurRoom plane:))
			)
			(if
				(and
					(< (+ (gEgo y:) temp2) 79)
					(< temp2 0)
					(gEgo mover:)
					(< (gEgo y:) ((gEgo mover:) yLast:))
				)
				(= temp5 (+ temp2 temp0))
				(= temp5 (Min 0 temp5))
				(= temp6 (+ temp2 360 temp0))
				(= temp6 (Min 360 temp6))
				((gCurRoom plane:) setRect: temp1 temp5 temp3 temp6)
				(UpdatePlane (gCurRoom plane:))
			)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(gEgo setScale: 0 normalize:)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(gEgo setPri: 60)
		(gGame handsOn:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (& (event type:) evMOVE)
			(= temp0 (event x:))
			(= temp1 (event y:))
			(cond
				((wallF onMe: temp0 temp1)
					(cond
						((and (not local2) (== local1 1))
							(= local2 1)
							(event claimed: 1)
							(gCurRoom setScript: sGetDownOnWall)
						)
						((and (not local2) (== local1 2))
							(= local2 1)
							(= local1 1)
							(event claimed: 1)
							(gCurRoom setScript: sGetUpOnWall)
						)
						(local2
							(cond
								((< temp1 (+ (wallF nsTop:) 10))
									(= local2 0)
									(event claimed: 1)
									(gCurRoom setScript: sOffTop)
								)
								((> temp1 304)
									(if (IsFlag 121)
										(= local2 0)
										(event claimed: 1)
										(gCurRoom setScript: sOffBottom)
									else
										(event claimed: 1)
										(gCurRoom setScript: sEgoDead)
									)
								)
								(else
									(event claimed: 1)
									(gEgo setMotion: MoveTo 15 temp1)
								)
							)
						)
						(local2
							(cond
								((< temp1 (+ (wallF nsTop:) 30))
									(= local2 0)
									(event claimed: 1)
									(gCurRoom setScript: sOffTop)
								)
								((> temp1 304)
									(if (IsFlag 121)
										(= local2 0)
										(event claimed: 1)
										(gCurRoom setScript: sOffBottom)
									else
										(event claimed: 1)
										(gCurRoom setScript: sEgoDead)
									)
								)
								(else
									(event claimed: 1)
									(gEgo setMotion: MoveTo 15 temp1)
								)
							)
						)
						(
							(and
								(< temp1 (wallF nsBottom:))
								(not local2)
								(== local1 2)
							)
							(= local2 1)
							(= local1 1)
							(event claimed: 1)
							(gCurRoom setScript: sGetUpOnWall)
						)
						(else
							(super handleEvent: event)
						)
					)
				)
				(local2
					(cond
						((< temp1 (+ (wallF nsTop:) 30))
							(= local2 0)
							(event claimed: 1)
							(gCurRoom setScript: sOffTop)
						)
						((> temp1 304)
							(if (IsFlag 121)
								(= local2 0)
								(event claimed: 1)
								(gCurRoom setScript: sOffBottom)
							else
								(event claimed: 1)
								(gCurRoom setScript: sEgoDead)
							)
						)
						(else
							(event claimed: 1)
							(gEgo setMotion: MoveTo 15 temp1)
						)
					)
				)
				(else
					(super handleEvent: event)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance scrollCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 ((gCurRoom plane:) left:))
		(= temp2 ((gCurRoom plane:) top:))
		(= temp3 ((gCurRoom plane:) right:))
		(= temp4 ((gCurRoom plane:) bottom:))
		(if (IsFlag 202)
			(= temp0 2)
		else
			(= temp0 8)
		)
		(if
			(and
				(> (+ (gEgo y:) temp2) 81)
				(> temp4 139)
				(gEgo mover:)
				(> (gEgo y:) ((gEgo mover:) yLast:))
			)
			((gCurRoom plane:)
				setRect: temp1 (- temp2 temp0) temp3 (- (+ temp2 360) temp0)
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
				setRect: temp1 (+ temp2 temp0) temp3 (+ temp2 360 temp0)
			)
			(UpdatePlane (gCurRoom plane:))
		)
	)
)

(instance sOffBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 2)
				(gEgo setMotion: MoveTo (gEgo x:) 337 self)
			)
			(1
				(gEgo normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOffTop of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (and (IsFlag 202) (== state 1))
			(= temp4 2)
			(= temp0 ((gCurRoom plane:) left:))
			(= temp1 ((gCurRoom plane:) top:))
			(= temp2 ((gCurRoom plane:) right:))
			(= temp3 ((gCurRoom plane:) bottom:))
			(= temp5 (+ temp1 temp4))
			(= temp5 (Min 0 temp5))
			(= temp6 (+ temp1 360 temp4))
			(= temp6 (Min 360 temp6))
			((gCurRoom plane:) setRect: temp0 temp5 temp2 temp6)
			(UpdatePlane (gCurRoom plane:))
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 29 143 self)
			)
			(1
				1
				(gEgo
					view: 671
					setLoop: 0 1
					setCel: 10
					x: 30
					y: 93
					setSpeed: 6
					setPri: 105
					setCycle: Beg self
				)
				(if (not (IsFlag 202))
					(= temp0 ((gCurRoom plane:) left:))
					(= temp1 ((gCurRoom plane:) top:))
					(= temp2 ((gCurRoom plane:) right:))
					(= temp3 ((gCurRoom plane:) bottom:))
					(= temp4 (+ temp1 60))
					(= temp4 (Min 0 temp4))
					(= temp5 (+ temp1 420))
					(= temp5 (Min 360 temp5))
					((gCurRoom plane:) setRect: temp0 temp4 temp2 temp5)
					(UpdatePlane (gCurRoom plane:))
				)
			)
			(2
				2
				(gEgo normalize: 0 setPri: 105 setMotion: MoveTo 66 98 self)
			)
			(3
				3
				(gEgo setMotion: MoveTo 89 94 self)
			)
			(4
				4
				(gEgo setMotion: MoveTo 131 89 self)
			)
			(5
				5
				(gEgo normalize: 2 setPri: 105)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetUpOnWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(gGame handsOff:)
				(gEgo
					view: 6411
					setLoop: -1
					setCycle: StopWalk 6412
					setMotion: MoveTo 15 274 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDownOnWall of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(if (and (IsFlag 202) (== state 3))
			(= temp4 2)
			(= temp0 ((gCurRoom plane:) left:))
			(= temp1 ((gCurRoom plane:) top:))
			(= temp2 ((gCurRoom plane:) right:))
			(= temp3 ((gCurRoom plane:) bottom:))
			((gCurRoom plane:)
				setRect: temp0 (- temp1 temp4) temp2 (- (+ temp1 360) temp4)
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(= local2 1)
				(gEgo setMotion: MoveTo 89 94 self)
			)
			(1
				1
				(gEgo setMotion: MoveTo 66 91 self)
			)
			(2
				2
				(gEgo setMotion: MoveTo 29 91 self)
			)
			(3
				3
				(gEgo
					view: 671
					setLoop: 0 1
					setCel: 0
					x: 15
					y: 93
					setCycle: End self
					setSpeed: 6
				)
			)
			(4
				4
				(if (not (IsFlag 202))
					(= temp0 ((gCurRoom plane:) left:))
					(= temp1 ((gCurRoom plane:) top:))
					(= temp2 ((gCurRoom plane:) right:))
					(= temp3 ((gCurRoom plane:) bottom:))
					((gCurRoom plane:)
						setRect: temp0 (- temp1 60) temp2 (- (+ temp1 360) 60)
					)
					(UpdatePlane (gCurRoom plane:))
				)
				(gEgo
					view: 6411
					y: 143
					setLoop: -1
					setCycle: StopWalk 6412
					setSpeed: gEgoSpeed
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkDownUnder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 136 86 self)
			)
			(1
				(gEgo setPri: 60 setMotion: MoveTo 43 102 self)
			)
			(2
				(gEgo setMotion: MoveTo 136 82 self)
			)
			(3
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkUpOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScale: setMotion: MoveTo 43 102 self)
			)
			(1
				(gEgo scaleX: 128 scaleY: 128 setMotion: MoveTo 136 86 self)
			)
			(2
				(gEgo
					setScaler: Scaler 100 30 86 36
					setPri: 105
					setMotion: MoveTo 131 89 self
				)
			)
			(3
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFeedTheWorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 121)
				(gEgo setMotion: MoveTo 15 275 self)
			)
			(1
				(gEgo
					view: 672
					setLoop: 0 1
					setCel: 0
					x: 7
					y: 275
					setPri: (+ (wormMouth priority:) 2)
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo put: 105) ; Time_Pills
				(wormMouth cycleSpeed: 2)
				(gGame points: 3 484)
				(gMessager say: 2 144 4 0 self) ; "Hmmm. Impressive. The tapeworm suddenly becomes much more animated!"
			)
			(3
				(gEgo
					view: 6411
					x: 15
					setLoop: -1
					setCycle: StopWalk 6412
					setPri: -1
					setSpeed: gEgoSpeed
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRideWorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local2
					(gEgo setMotion: MoveTo 7 265 self)
				else
					(gEgo
						view: 6411
						setLoop: -1
						setCycle: StopWalk 6412
						setMotion: MoveTo 15 265 self
					)
				)
			)
			(1
				(gEgo
					view: 673
					setLoop: 0 1
					setCel: 0
					x: 7
					y: 275
					setSpeed: 6
					setPri: 100
					setCycle: End self
				)
			)
			(2
				(gEgo
					setLoop: 1 1
					setCel: 0
					x: 134
					y: 311
					setCycle: End self
				)
			)
			(3
				(gGame points: 3 485)
				(gMessager say: 2 0 3 3 self) ; "Please remember to keep your arms and legs on the worm at all times."
			)
			(4
				(Fade 1 1 self)
			)
			(5
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(= cycles 1)
			)
			(6
				(Fade 0 1 self)
				(gGSound1 stop:)
			)
			(7
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 670 self
						x: 92
						y: 202
						priority: 200
						start:
						yourself:
					)
				)
			)
			(8
				(gEgo setSpeed: gEgoSpeed)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance sEgoDead of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 15 323 self)
				(wormMouth setCycle: End)
			)
			(1
				(wormTounge
					init:
					setLoop: 0 1
					setCel: 0
					setPri: (+ (wormMouth priority:) 1)
					cycleSpeed: 6
					ignoreActors:
					setCycle: CT 7 1 self
				)
				(wormMouth setCel: 0)
			)
			(2
				(gEgo hide: doit:)
				(wormTounge setCel: 8 doit: setCycle: End self)
			)
			(3
				(if register
					(gMessager say: 2 4 5 0 self) ; "Well, now that DID have an effect. Not probably what you had hoped for, however."
				else
					(= cycles 1)
				)
			)
			(4
				(EgoDead 25 self) ; "Since you've entered the tapeworm not partially digested, you'll probably give him heartburn. I hope you're proud of yourself."
			)
			(5
				(= register 0)
				(= temp0 ((gCurRoom plane:) left:))
				(= temp1 ((gCurRoom plane:) top:))
				(= temp2 ((gCurRoom plane:) right:))
				(= temp3 ((gCurRoom plane:) bottom:))
				((gCurRoom plane:)
					setRect: temp0 (+ temp1 20) temp2 (+ temp1 360 20)
				)
				(UpdatePlane (gCurRoom plane:))
				(gEgo
					view: 6411
					show:
					x: 15
					y: 274
					setLoop: -1
					setCycle: StopWalk 6412
					setPri: -1
					setSpeed: gEgoSpeed
				)
				(wormMouth setCycle: Fwd)
				(wormTounge dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wormMouth of Prop
	(properties
		noun 2
		approachX 11
		approachY 363
		x 68
		y 333
		view 670
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 121)
						(gMessager say: 2 1 6) ; "The tapeworm is a little wired, thanks to you. He looks like he has plenty of energy."
					)
					((IsFlag 122)
						(gMessager say: 2 1) ; "It's a tapeworm. He seems to be lazily grazing in the valley of the villi."
					)
					(else
						(SetFlag 122)
						(gMessager say: 2 1 1) ; "Great scott!!! That certainly is one buff parasite."
					)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 121)
						(gCurRoom setScript: sRideWorm)
						(return 1)
					)
					((>= (++ local0) 3)
						(= local0 0)
						(gCurRoom setScript: sEgoDead 0 1)
					)
					(else
						(gMessager say: 2 4) ; "That has no effect. At least it appears that way."
					)
				)
			)
			(144 ; Time_Pills
				(gCurRoom setScript: sFeedTheWorm)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottomD of Feature
	(properties
		noun 1
		sightAngle 40
		x 171
		y 199
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 156 80 167 47 194 28 228 24 266 32 294 50 331 318 333 315 218 294 190 259 165 220 150 175 148
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 2) ; "This is the very bottom of our old friend, the duodenum. You can see the beginning of the jejunum. The villi start here. They increase the surface area of the small intestine a great deal, giving more area to absorb nutrients."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tapeWorm of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 11
		approachY 306
		x 175
		y 291
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 76 360 72 353 64 346 48 338 48 325 56 312 66 302 87 296 107 295 126 299 137 307 146 320 150 334 157 339 167 345 177 347 189 349 211 316 217 296 186 299 158 299 139 278 130 256 134 244 142 231 152 222 162 222 152 231 153 243 161 255 188 273 196 274 277 256 295 262 303 274 302 292 297 305 284 330 260 354 248 360
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(wormMouth doVerb: theVerb &rest)
	)
)

(instance exit660 of ExitFeature
	(properties
		sightAngle 40
		approachX 192
		approachY 34
		x 192
		y 35
		nextRoom 660
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 0 216 0 214 22 199 35 190 35 171 25 164 9
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(gGame handsOff:)
				(gEgo setPri: 20 setMotion: MoveTo 165 30 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 660)
	)
)

(instance wallF of Feature
	(properties
		nsTop 89
		nsRight 51
		nsBottom 330
		x 26
		y 164
	)
)

(instance wormTounge of Prop
	(properties
		x 71
		y 342
		view 674
	)
)

