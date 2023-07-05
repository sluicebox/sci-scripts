;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm640 0
	rideTram 1
)

(instance rm640 of LarryRoom
	(properties
		noun 1
		picture 660
		style 1024
		horizon 0
	)

	(method (init &tmp temp0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 320 101 296 101 293 96 262 97 260 101 223 101 223 107 189 107 180 101 180 95 148 97 148 102 75 101 75 95 49 96 49 101 0 101 0 138 320 138
					yourself:
				)
		)
		(if (== global100 640)
			(SetFlag 208)
			(ClearFlag 254)
		)
		(if (not (IsFlag 35))
			(gEgo normalize: 900 8 ignoreActors: 0 init:)
			(gGame handsOn:)
		)
		(switch gPrevRoomNum
			(680
				(gEgo x: 12 y: (gEgo y:) edgeHit: 0)
			)
			(305)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(680
				(gEgo x: 10 cel: 0)
			)
			(305
				(gEgo x: 308 cel: 1)
			)
			(else
				(self setScript: fromTBirdsScr)
			)
		)
		(if (IsFlag 35)
			(if (IsFlag 36)
				((ScriptID 825 1) z: 0 view: 90 posn: 0 126 init:) ; tram
			else
				((ScriptID 825 1) z: 0 view: 90 posn: 319 126 init:) ; tram
			)
			((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
			(self setScript: rideTram)
		)
		(if (or (OneOf gPrevRoomNum 650 810) (not (gGlobalSound2 handle:)))
			(gGlobalSound2 number: 200 play: setLoop: -1)
		)
		(rightDoor init:)
		(leftDoor init:)
		(middleDoor init: approachVerbs: 4 ignoreActors: 1) ; Do
		(backDrop init:)
		(frontSculpture init:)
		(hiddenSculpture init:)
		(rearSculpture init:)
		(carpet init:)
		(windowFrame init:)
	)

	(method (doit)
		(cond
			(script)
			((== (gEgo edgeHit:) 2)
				(self setScript: exitEastScr)
			)
			((== (gEgo edgeHit:) 4)
				(self setScript: exitWestScr)
			)
		)
		(super doit: &rest)
	)
)

(instance fromTBirdsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 153 92 loop: 8 cel: 2)
				(middleDoor cel: (middleDoor lastCel:) setPri: 91)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 160 100 self)
			)
			(2
				(gEgo setHeading: 180)
				(middleDoor setCycle: Beg self)
			)
			(3
				(middleDoor setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toTBirdsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: (ScriptID 96 0) self 1) ; knockOnDoorScr
				(SetFlag 92)
			)
			(1
				(= ticks 90)
			)
			(2
				(gMessager say: 7 4 1 1 self) ; "Woolard's World of Leather? I'll be right there!"
			)
			(3
				(= ticks 90)
			)
			(4
				(gGame changeScore: 10 253)
				(thunder init:)
				(middleDoor setPri: 91 setCycle: End self)
			)
			(5
				(= ticks 90)
			)
			(6
				(gMessager say: 7 4 1 2 self) ; "Oh, it's you! I was, uh, expecting someone else first. But, don't worry. Come on in."
			)
			(7
				(gEgo setPri: 90 setMotion: MoveTo 153 92 self)
			)
			(8
				(gCurRoom newRoom: 650)
			)
		)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar
					disableIcon:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 9) ; icon6
						(ScriptID 0 6) ; icon3
					enableIcon: (ScriptID 0 4) (ScriptID 0 7) ; icon1, icon4
					show:
				)
				(if (OneOf global166 (ScriptID 0 4) (ScriptID 0 7)) ; icon1, icon4
					(gTheIconBar curIcon: global166)
				else
					(gTheIconBar curIcon: (ScriptID 0 7)) ; icon4
				)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(User canControl: 1 canInput: 1)
				(cond
					((and (IsFlag 36) (> ((ScriptID 825 1) x:) 319)) ; tram
						(self cue:)
					)
					((IsFlag 36)
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 319 126 self
						)
					)
					((< ((ScriptID 825 1) x:) 0) ; tram
						(self cue:)
					)
					(else
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 0 126 self
						)
					)
				)
			)
			(1
				(DisposeScript 826)
				(if (IsFlag 36)
					(gCurRoom newRoom: 305)
				else
					(gCurRoom newRoom: 680)
				)
			)
		)
	)
)

(instance exitEastScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 340 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 305)
			)
		)
	)
)

(instance exitWestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance frontSculpture of Feature
	(properties
		noun 8
		sightAngle 40
		x 8
		y 97
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 29 18 27 73 1 73 1 18 yourself:)
		)
	)
)

(instance hiddenSculpture of Feature
	(properties
		noun 3
		sightAngle 40
		x 111
		y 97
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 74 93 74 89 19 129 19
					yourself:
				)
		)
	)
)

(instance rearSculpture of Feature
	(properties
		noun 9
		sightAngle 40
		x 218
		y 98
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 241 16 238 72 198 71 196 15
					yourself:
				)
		)
	)
)

(instance leftDoor of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 62
		approachY 98
		x 62
		y 94
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 84 41 82 99 42 97 37 42 yourself:)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
		else
			(super doVerb: theVerb)
		)
	)
)

(instance knockOnDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: (ScriptID 96 0) self 1) ; knockOnDoorScr
			)
			(1
				(gMessager say: 7 4 0 0 self) ; "There's no response from this room."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance middleDoor of Prop
	(properties
		noun 7
		modNum 205
		sightAngle 40
		approachX 163
		approachY 98
		x 157
		y 94
		view 640
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((and (= temp0 (== theVerb 4)) (IsFlag 208) (not (IsFlag 254))) ; Do
				(gCurRoom setScript: toTBirdsScr)
			)
			(temp0
				(if (IsFlag 254)
					(gMessager say: noun theVerb 2)
				else
					(self setScript: knockOnDoorScr)
				)
			)
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb (and (IsFlag 254) 2))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 277
		approachY 97
		x 277
		y 93
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 43 303 99 251 99 255 44
					yourself:
				)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
		else
			(super doVerb: theVerb)
		)
	)
)

(instance carpet of PolyFeature
	(properties
		noun 1
		modNum 205
		sightAngle 40
		variableX 1
		variableY 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 125 277 130 257 130 170 120 133 121 129 98 143 99 147 95 183 93 187 96 192 107 222 107 225 100 249 100 257 96 297 95 304 99 320 99
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 111 99 115 121 75 125 0 135 0 100 40 100 44 95 76 94 82 99
					yourself:
				)
		)
	)
)

(instance windowFrame of PolyFeature
	(properties
		noun 5
		modNum 205
		sightAngle 40
		y 200
		variableX 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 55 133 120 165 121 233 128 252 131 272 131 320 126 320 139 1 138 1 135 72 125 116 121 112 99 96 0 116 0
					yourself:
				)
		)
	)
)

(instance backDrop of Prop
	(properties
		x 160
		y 94
		fixPriority 1
		view 640
		loop 1
		signal 16384
	)
)

(instance thunder of View
	(properties
		x 150
		y 90
		scaleX 96
		scaleY 96
		priority 1
		fixPriority 1
		view 651
		loop 1
		scaleSignal 1
	)
)

