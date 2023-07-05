;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7 = 1
	local8 = -1
	local9 = -1
	local10 = -1
	local11 = -1
	local12 = -1
	local13 = -1
)

(instance rm400 of Eco2Room
	(properties
		noun 7
		picture 400
		style 10
	)

	(method (doit)
		(if (and (not inset) local4)
			(= local4 0)
			(gGame handsOff:)
			(self setInset: doorInset)
		)
		(super doit:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(DisposeScript 16)
		(UnLoad 128 401)
		(UnLoad 128 12)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(= local7 1)
		(exitsouth init:)
		(Load rsVIEW 12)
		(Load rsVIEW 401)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 189 291 171 233 171 230 158 278 143 263 123 245 128 246 145 189 156 142 142 194 109 201 99 158 106 158 126 123 130 102 128 112 115 96 107 95 91 168 85 168 80 94 79 83 86 33 86 41 112 160 161 166 168 97 178 114 189
					yourself:
				)
		)
		(path init: setOnMeCheck: 1 16)
		(folage init: setOnMeCheck: 1 32)
		(door1 init: setOnMeCheck: 1 8)
		(door2 init: setOnMeCheck: 1 4)
		(door3 init: setOnMeCheck: 1 2)
		(buttress init:)
		(gGameSound1 number: 400 setLoop: -1 play:)
		(if (== gPrevRoomNum 420)
			(= local2 1)
			(self setInset: doorInset)
		else
			(= local2 0)
			(gEgo
				init:
				normalize:
				y: 195
				x: 230
				setScript: sEnter
				setScale: Scaler 100 75 189 93
			)
		)
		(self script: 1)
		(super init:)
		(self script: 0)
	)

	(method (cue)
		(if (== (gEgo y:) 189)
			(self setScript: sExit)
		)
	)

	(method (handleEvent event)
		(if (gCurRoom inset:)
			((gCurRoom inset:) handleEvent: event)
		else
			(super handleEvent: event)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 210 self)
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 180 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance outOfHeart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((gCurrentRegionFlags test: 20)
						(gEgo posn: 275 127)
						(gCurrentRegionFlags clear: 20)
						(= register 1)
					)
					((gCurrentRegionFlags test: 21)
						(gEgo posn: (door2 approachX:) (door2 approachY:))
						(gCurrentRegionFlags clear: 21)
					)
					((gCurrentRegionFlags test: 22)
						(gEgo posn: (door3 approachX:) (door3 approachY:))
						(gCurrentRegionFlags clear: 22)
					)
					(else
						(gEgo posn: 170 160)
					)
				)
				(gEgo
					init:
					startUpd:
					show:
					normalize:
					setScale: Scaler 100 75 189 93
				)
				(= ticks 60)
			)
			(1
				(switch register
					(1
						(gEgo
							setMotion:
								MoveTo
								(door1 approachX:)
								(door1 approachY:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 35)
								(+ (gEgo y:) 2)
								self
						)
					)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo loop: 8 cel: 2)
				(if (not (vines cycler:))
					(self cue:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 200 93 self)
			)
			(3
				(gEgo setPri: 13 setMotion: MoveTo 206 111 self)
			)
			(4
				(= cycles 5)
			)
			(5
				(gEgo
					priority: 15
					posn: 206 151 0
					setScale: Scaler 100 75 147 100
				)
				(gTheIconBar enable: 2 1 0 disable: 8)
				(gUser canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance goToHeart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo 200 (- (gEgo y:) 1) self
				)
				(= local7 0)
			)
			(1
				(gEgo setMotion: MoveTo 200 133 self)
			)
			(2
				(gEgo setPri: 13 setMotion: MoveTo 200 110 self)
			)
			(3
				((gCurRoom inset:) dispose:)
				(= cycles 5)
			)
			(4
				(gGameSound1 fade: 0 25 10 1)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance exitsouth of ExitFeature
	(properties
		nsTop 181
		nsLeft 76
		nsBottom 189
		nsRight 319
		cursor 10
		exitDir 3
		toY 189
	)

	(method (doit)
		(if (not (gCurRoom inset:))
			(super doit:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			((OneOf (gTheCursor cel:) 10 11 12 13)
				(= temp0 (= temp1 0))
				(= temp0
					(if toX
						toX
					else
						(switch exitDir
							(1 gMouseX)
							(3 gMouseX)
							(2 320)
							(4 0)
							(else 999)
						)
					)
				)
				(= temp1
					(if toY
						toY
					else
						(switch exitDir
							(1 0)
							(3 190)
							(2
								(- gMouseY 10)
							)
							(4
								(- gMouseY 10)
							)
							(else 999)
						)
					)
				)
				(gEgo setMotion: PolyPath temp0 temp1 gCurRoom)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance path of Feature
	(properties
		x 76
		y 20
		noun 5
		sightAngle 40
		onMeCheck 16
		approachX 76
		approachY 20
	)
)

(instance door1 of Feature
	(properties
		x 44
		y 60
		noun 5
		onMeCheck 8
		approachX 259
		approachY 133
		approachDist 12
	)

	(method (onMe param1 &tmp temp0)
		(if (gCurRoom inset:)
			(return 0)
		)
		(if (and (= temp0 (super onMe: param1 &rest)) (IsObject param1))
			(cond
				((OneOf (param1 message:) 4 3)
					(if (== sightAngle 90)
						(= sightAngle 26505)
						(= x (+ approachX 3))
						(= y (- approachY 3))
					)
				)
				((== sightAngle 26505)
					(= sightAngle 90)
					(= x 44)
					(= y 60)
				)
			)
		)
		(return temp0)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3) ; Do, Walk
		(gWalkHandler addToFront: self)
		(gTheDoits add: self)
	)

	(method (doit)
		(cond
			(
				(and
					(self onMe: gMouseX (- gMouseY 10))
					(OneOf (gTheIconBar indexOf: (gTheIconBar curIcon:)) 0 2)
				)
				(if (== local8 -1)
					(= local8 (gTheCursor cel:))
				)
				(if (== local9 -1)
					(= local9 1)
					(gGame setCursor: 11)
				)
			)
			((!= local9 -1)
				(if (OneOf (gTheCursor cel:) 10 11 12 13)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					(= local8 -1)
				)
				(= local9 -1)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(gCurRoom setScript: enter1stDoorScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance door2 of Feature
	(properties
		x 109
		y 97
		noun 5
		sightAngle 40
		onMeCheck 4
		approachX 204
		approachY 115
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3) ; Do, Walk
		(gWalkHandler addToFront: self)
		(gTheDoits add: self)
	)

	(method (doit)
		(cond
			(
				(and
					(self onMe: gMouseX (- gMouseY 10))
					(OneOf (gTheIconBar indexOf: (gTheIconBar curIcon:)) 0 2)
				)
				(if (== local10 -1)
					(= local10 (gTheCursor cel:))
				)
				(if (== local11 -1)
					(= local11 1)
					(gGame setCursor: 11)
				)
			)
			((!= local11 -1)
				(if (OneOf (gTheCursor cel:) 10 11 12 13)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					(= local10 -1)
				)
				(= local11 -1)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(gCurrentRegionFlags set: 21)
			(gCurrentRegionFlags clear: 20)
			(gCurrentRegionFlags clear: 22)
			(= local5 (gEgo x:))
			(= local6 (gEgo y:))
			(gEgo heading: 0 dispose:)
			(Animate (gCast elements:) 0)
			(gCurRoom setInset: doorInset)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (onMe)
		(return (and (not (gCurRoom inset:)) (super onMe: &rest)))
	)
)

(instance door3 of Feature
	(properties
		x 32
		y 103
		noun 5
		sightAngle 40
		onMeCheck 2
		approachX 175
		approachY 81
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 3) ; Do, Walk
		(gWalkHandler addToFront: self)
		(gTheDoits add: self)
	)

	(method (doit)
		(cond
			(
				(and
					(self onMe: gMouseX (- gMouseY 10))
					(OneOf (gTheIconBar indexOf: (gTheIconBar curIcon:)) 0 2)
				)
				(if (== local12 -1)
					(= local12 (gTheCursor cel:))
				)
				(if (== local13 -1)
					(= local13 1)
					(gGame setCursor: 11)
				)
			)
			((!= local13 -1)
				(if (OneOf (gTheCursor cel:) 10 11 12 13)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					(= local12 -1)
				)
				(= local13 -1)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Walk
			(gCurrentRegionFlags set: 22)
			(gCurrentRegionFlags clear: 20)
			(gCurrentRegionFlags clear: 21)
			(= local5 (gEgo x:))
			(= local6 (gEgo y:))
			(gEgo heading: 0 dispose:)
			(Animate (gCast elements:) 0)
			(gCurRoom setInset: doorInset)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (gCurRoom inset:)
			(return 0)
		)
		(if (and (= temp0 (super onMe: param1 &rest)) (IsObject param1))
			(cond
				((OneOf (param1 message:) 4 3)
					(if (== sightAngle 40)
						(= sightAngle 26505)
						(= x (+ approachX 3))
						(= y approachY)
					)
				)
				((== sightAngle 26505)
					(= sightAngle 40)
					(= x 32)
					(= y 103)
				)
			)
		)
		(return temp0)
	)
)

(instance folage of Feature
	(properties
		x 278
		y 108
		noun 1
		sightAngle 40
		onMeCheck 32
		approachX 278
		approachY 108
	)
)

(instance doorInset of Inset
	(properties
		view 401
		x 134
		y 67
		priority 13
		disposeNotOnMe 1
		noun 3
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(gTheDoits delete: buttress)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOVE)
					(self onMe: event)
					(gCurrentRegionFlags test: 23)
				)
				(gCurRoom setScript: goToHeart)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(== (gTheIconBar indexOf: (gTheIconBar curIcon:)) 0)
					(& (event type:) $0040) ; direction
				)
				(cond
					(
						(and
							(OneOf (event message:) JOY_UPLEFT JOY_UPRIGHT JOY_UP)
							(gCurrentRegionFlags test: 23)
						)
						(gCurRoom setScript: goToHeart)
						(event claimed: 1)
						(return)
					)
					(
						(and
							(OneOf (event message:) JOY_DOWNLEFT JOY_DOWNRIGHT JOY_LEFT JOY_RIGHT JOY_DOWN)
							(not (gCurRoom script:))
						)
						(self dispose:)
					)
				)
			)
			(else
				(super handleEvent: event &rest)
				(return)
			)
		)
	)

	(method (drawInset &tmp temp0)
		(super drawInset: &rest)
		(insetView stopUpd:)
		(gGame handsOff:)
		(vines cel: 0 init: stopUpd:)
		(if (gCurrentRegionFlags test: 23)
			(vines setCycle: End vines)
			(self setScript: vineSoundScr)
		else
			(gTheIconBar enable: 2 1 6 disable: 8)
			(if (gTheIconBar curInvIcon:)
				(gTheIconBar enable: 5)
			)
			(gUser canControl: 1 canInput: 1)
		)
		(cond
			((gCurrentRegionFlags test: 20)
				(drumStand init: addToPic:)
				(if (gCurrentRegionFlags test: 33)
					(maleDrum init:)
				)
				(if (not (gCurrentRegionFlags test: 61))
					(gCurrentRegionFlags set: 61)
					(gGame points: 1)
				)
			)
			((gCurrentRegionFlags test: 21)
				((= temp0 (View new:))
					view: 401
					loop: 3
					cel: 1
					x: 289
					y: 155
					priority: 15
					signal: 17
				)
				(temp0 init: addToPic:)
				((= temp0 (View new:))
					view: 401
					loop: 3
					cel: 0
					x: 131
					y: 93
					priority: 15
					signal: 17
				)
				(temp0 init: addToPic:)
				((= temp0 (View new:))
					view: 401
					loop: 3
					cel: 2
					x: 217
					y: 149
					priority: 15
					signal: 17
				)
				(temp0 init: addToPic:)
				(if (not (gCurrentRegionFlags test: 62))
					(gCurrentRegionFlags set: 62)
					(gGame points: 1)
				)
			)
			((gCurrentRegionFlags test: 22)
				((= temp0 (View new:))
					view: 401
					loop: 4
					cel: 0
					x: 146
					y: 61
					priority: 15
					signal: 16400
				)
				(temp0 init: addToPic:)
				((= temp0 (View new:))
					view: 401
					loop: 4
					cel: 1
					x: 288
					y: 96
					priority: 15
					signal: 17
				)
				(temp0 init: addToPic:)
				((= temp0 (View new:))
					view: 401
					loop: 4
					cel: 2
					x: 289
					y: 155
					priority: 15
					signal: 17
				)
				(temp0 init: addToPic:)
				(if (not (gCurrentRegionFlags test: 63))
					(gCurrentRegionFlags set: 63)
					(gGame points: 1)
				)
			)
		)
		(gEgo
			x:
				(cond
					(local2 200)
					((and (gCurrentRegionFlags test: 20) (gCurrentRegionFlags test: 33)) 160)
					(else 200)
				)
			y: (if local2 70 else 151)
			z: (if local2 -40 else 0)
			scaleSignal: 1
			priority: (if local2 13 else 15)
			signal: 16400
			init:
			view: 0
			loop: 8
			cel: (if local2 2 else 3)
			setCycle: StopWalk -1
			illegalBits: 0
			ignoreActors:
		)
		(if local2
			(gEgo setScale: Scaler 100 75 107 60)
		else
			(gEgo setScale: Scaler 100 75 147 100)
		)
		(Animate)
		(if local2
			(self setScript: walkOut)
		)
	)

	(method (doVerb theVerb)
		(vines doVerb: theVerb)
	)

	(method (dispose)
		(gAddToPics eachElementDo: #dispose eachElementDo: #delete)
		(super dispose:)
		(gTheDoits add: buttress)
		(cond
			(local7
				(gCurRoom setScript: outOfHeart)
				(= local2 0)
			)
			((not local4)
				(gGame handsOn:)
			)
			(else
				(gTheIconBar disable: 6 5)
			)
		)
	)
)

(instance vineSoundScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGameSound2 number: 403 setLoop: 1 play:)
				(self dispose:)
			)
		)
	)
)

(instance drumStand of View
	(properties
		x 158
		y 150
		noun 8
		approachX 160
		approachY 151
		view 401
		loop 1
		priority 14
		signal 16400
	)

	(method (init)
		(= signal 16)
		(super init: &rest)
		(= local7 1)
		(self approachVerbs: 17 4 1) ; drum, Do, Look
		(gTheDoits add: self)
	)

	(method (doit)
		(if (not (IsEcorderFlag 64))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 64))
			(cond
				((and (gCurrentRegionFlags test: 23) (OneOf theVerb 1 4)) ; Look, Do
					(gMessager say: noun 4 3) ; "The drums have served their purpose."
				)
				((== theVerb 17) ; drum
					(maleDrum init:)
					(gEgo put: 9)
					(gCurrentRegionFlags set: 33)
					(if (not (gCurrentRegionFlags test: 64))
						(gCurrentRegionFlags set: 64)
						(gGame points: 5)
					)
					(Animate (gCast elements:) 0)
					(self doVerb: 1)
				)
				((== theVerb 4) ; Do
					(gMessager say: noun theVerb 2) ; "The drum stand can't be moved."
				)
				((and (== theVerb 1) (gCurrentRegionFlags test: 33)) ; Look
					(= local3 (ScriptID 16 0)) ; inDrums
					(= local7 0)
					(local3 disposeNotOnMe: 1)
					(= local4 1)
					(gCurRoom setInset: local3)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance maleDrum of View
	(properties
		x 158
		y 150
		approachX 160
		approachY 151
		view 401
		loop 1
		cel 1
		priority 14
		signal 16401
	)

	(method (init)
		(= signal 16400)
		(self approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gCurrentRegionFlags clear: 33)
				(gEgo get: 9)
				(self dispose:)
				(if (not (gCurrentRegionFlags test: 65))
					(gCurrentRegionFlags set: 65)
					(gGame points: 1)
				)
			)
			((== theVerb 1) ; Look
				(drumStand doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vines of Prop
	(properties
		x 205
		y 93
		z 33
		noun 3
		view 401
		loop 2
		priority 13
		signal 17
		cycleSpeed 15
	)

	(method (cue)
		(self stopUpd:)
		(if (not local2)
			(gTheIconBar enable: 2 1 0 disable: 8)
			(gUser canControl: 1 canInput: 1)
		)
		(if (== (doorInset script:) walkOut)
			(walkOut cue:)
		)
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 1 4) (gCurrentRegionFlags test: 23)) ; Look, Do
			(gMessager say: noun theVerb 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance enter1stDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 275 127 self)
			)
			(1
				(gCurrentRegionFlags set: 20)
				(gCurrentRegionFlags clear: 21)
				(gCurrentRegionFlags clear: 22)
				(= local5 (gEgo x:))
				(= local6 (gEgo y:))
				(gEgo heading: 0 dispose:)
				(Animate (gCast elements:) 0)
				(gCurRoom setInset: doorInset)
			)
		)
	)
)

(instance buttress of Feature
	(properties
		y 5
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 181 99 206 39 247 40 245 142 192 153 148 141
					yourself:
				)
		)
		(gTheDoits add: self)
	)

	(method (doit)
		(if (not (IsEcorderFlag 5))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit: &rest)
	)

	(method (onMe param1)
		(if
			(and
				(super onMe: param1 &rest)
				(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
				(== ((gTheIconBar curInvIcon:) message:) 55)
			)
			(return 1)
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(self perform: gWriteEcorderData theVerb 5)
	)

	(method (dispose)
		(super dispose:)
		(gTheDoits delete: self)
	)
)

