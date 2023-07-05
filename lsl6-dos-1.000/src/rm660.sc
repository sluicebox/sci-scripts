;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm660 0
	rideTram 1
)

(instance rm660 of LarryRoom
	(properties
		noun 1
		picture 660
		horizon 0
		east 690
		west 505
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 138 319 138 319 101 271 101 271 96 245 95 245 101 172 102 172 97 140 95 140 101 131 107 97 107 97 101 60 101 58 97 27 96 24 101 0 101
					yourself:
				)
		)
		(switch gPrevRoomNum
			(690
				(= style 11)
			)
			(505
				(= style 12)
			)
		)
		(super init: &rest)
		(if (not (IsFlag 35))
			(gEgo normalize: ignoreActors: 0 init:)
		)
		(if (not (OneOf gPrevRoomNum 690 505))
			(gGlobalSound2 number: 200 loop: -1 play:)
		)
		(cond
			((IsFlag 35)
				(if (IsFlag 36)
					((ScriptID 825 1) z: 0 view: 90 posn: 0 126 init:) ; tram
				else
					((ScriptID 825 1) z: 0 view: 90 posn: 319 126 init:) ; tram
				)
				((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
				(self setScript: rideTram)
			)
			((== gPrevRoomNum 690)
				(gEgo x: 310 loop: 8 cel: 1)
				(gGame handsOn:)
			)
			(else
				(gEgo x: 10 loop: 8 cel: 0)
				(gGame handsOn:)
			)
		)
		(leftDoor init: approachVerbs: 4) ; Do
		(rightDoor init: approachVerbs: 4) ; Do
		(middleDoor init: approachVerbs: 4 addToPic:) ; Do
		(carpet init:)
		(frontSculpture init:)
		(hiddenSculpture init:)
		(rearSculpture init:)
		(windowFrame init:)
		(if (and (IsFlag 186) (== ((gInventory at: 26) owner:) 660)) ; minwater
			(tray init: stopUpd: approachVerbs: 5 4) ; Take, Do
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 505 690))
			(gGlobalSound2 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (edgeToRoom param1)
		(switch param1
			(2
				(self setScript: toExitScr)
			)
			(4
				(self setScript: to3DoorHallScr)
			)
		)
		(return 0)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar
					disable:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 6) ; icon3
						(ScriptID 0 9) ; icon6
					enable: (ScriptID 0 4) (ScriptID 0 7) ; icon1, icon4
				)
				(if (OneOf global166 (ScriptID 0 4) (ScriptID 0 7)) ; icon1, icon4
					(gTheIconBar curIcon: global166)
				else
					(gTheIconBar curIcon: (ScriptID 0 7)) ; icon4
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
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
					(gCurRoom newRoom: 690)
				else
					(gCurRoom newRoom: 505)
				)
			)
		)
	)
)

(instance frontSculpture of Feature
	(properties
		x 101
		y 97
		noun 4
		sightAngle 40
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 124 15 122 71 82 72 79 16 yourself:)
		)
	)
)

(instance hiddenSculpture of Feature
	(properties
		x 209
		y 97
		noun 7
		sightAngle 40
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 191 19 231 19 227 74 191 74 yourself:)
		)
	)
)

(instance rearSculpture of Feature
	(properties
		x 311
		y 98
		noun 3
		sightAngle 40
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 319 18 319 73 293 73 291 18 yourself:)
		)
	)
)

(instance toExitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance to3DoorHallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -15 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 505)
			)
		)
	)
)

(instance takeWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 901 loop: 4 setSpeed: 7 setCycle: CT 3 1 self)
			)
			(1
				(tray cel: 1 forceUpd:)
				(= cycles 2)
			)
			(2
				(gNarrator x: 170 y: 7 talkWidth: 110)
				(gMessager say: 5 5 0 0 self) ; "You grab the bottle of mineral water from the tray, never knowing when you'll have a use for something without substance, that's tasteless and over-priced."
			)
			(3
				(gNarrator x: -1 y: -1 talkWidth: 0)
				(gEgo get: 26) ; minwater
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 900 8 1 cel: 0)
				(gGame changeScore: 6 255)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tray of View
	(properties
		x 98
		y 96
		noun 5
		sightAngle 40
		approachX 90
		approachY 101
		view 660
		loop 1
		signal 16384
	)

	(method (init)
		(if (!= ((gInventory at: 26) owner:) gCurRoomNum) ; minwater
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (== ((gInventory at: 26) owner:) 660)) ; minwater
		(cond
			((and (== theVerb 5) temp0) ; Take
				(gCurRoom setScript: takeWaterScr)
			)
			((== theVerb 5) ; Take
				(gMessager say: noun theVerb 1) ; "You already took the mineral water. What are you looking for now? Snapple?"
			)
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb (and (not temp0) 1))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftDoor of Feature
	(properties
		x 42
		y 94
		noun 2
		modNum 205
		sightAngle 40
		approachX 42
		approachY 98
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 65 44 69 99 17 99 21 43 yourself:)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
			)
			((OneOf theVerb 1 5 2) ; Look, Take, Talk
				(gMessager say: 2 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance middleDoor of View
	(properties
		x 155
		y 94
		noun 2
		modNum 205
		sightAngle 40
		approachX 156
		approachY 98
		view 660
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
			)
			(1 ; Look
				(gMessager say: 8 theVerb) ; "This door knob shows much wear and tear from the millions of "Do Not Disturb" signs hung on it over the years."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		x 257
		y 94
		noun 2
		modNum 205
		sightAngle 40
		approachX 257
		approachY 98
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 283 42 278 97 238 99 236 41 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
			)
			(1 ; Look
				(gMessager say: 6 theVerb) ; "Look! It's rectangular."
			)
			(else
				(super doVerb: theVerb)
			)
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
					init: 0 99 16 99 23 95 63 96 71 100 95 100 98 107 128 107 133 96 137 93 173 95 177 99 191 98 187 121 150 120 63 130 43 130 0 125
					yourself:
				)
				((Polygon new:)
					init: 269 99 277 105 292 105 316 120 316 128 291 125 254 125 257 99
					yourself:
				)
		)
	)
)

(instance windowFrame of PolyFeature
	(properties
		y 200
		noun 5
		modNum 205
		sightAngle 40
		variableX 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 204 0 224 0 208 99 204 121 248 125 319 135 319 138 0 139 0 126 48 131 68 131 87 128 155 121 187 120 200 55
					yourself:
				)
		)
	)
)

