;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use PolyFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm300 0
	rideTram 1
)

(local
	local0
	local1
	local2
)

(instance rm300 of LarryRoom
	(properties
		noun 1
		picture 300
		horizon 0
	)

	(method (init &tmp temp0 temp1)
		(if (= temp1 (or (OneOf global171 3 2) (== global100 300)))
			(= global171 2)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 259 138 268 120 320 120 320 110 137 110 129 115 97 115 45 118 13 118 13 111 21 111 17 102 0 95 0 138
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 263 138 269 120 320 120 320 110 123 110 123 108 105 108 105 114 45 118 13 118 13 111 21 111 17 102 0 95 0 138
						yourself:
					)
			)
		)
		(if (not (IsFlag 35))
			(gEgo normalize: 900 8 edgeHit: 0 ignoreActors: 0 init:)
		)
		(if (not (gGlobalSound2 handle:))
			(gGlobalSound2 number: 200 play: setLoop: -1)
		)
		(switch gPrevRoomNum
			(305
				(if (< (gEgo y:) 106)
					(gEgo x: 10 y: 109 cel: 0)
				else
					(gEgo x: 10 y: (gEgo y:) edgeHit: 0 cel: 0)
				)
				(gGame handsOn:)
			)
			(310
				(self setScript: fromHealthSpaScr)
			)
			(else
				(gEgo posn: 300 116 cel: 1)
				(if (not (IsFlag 35))
					(self setScript: enterFromEastScr)
				)
			)
		)
		(if temp1
			(gammie init:)
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
		(visibleSculpture init:)
		(hiddenSculpture init:)
		(flowers init:)
		(windowFrame init:)
		(carpet init:)
		(door init: approachVerbs: 4 ignoreActors: 1) ; Do
		(super init: &rest)
	)

	(method (edgeToRoom param1)
		(switch param1
			(4
				(self setScript: exitWestScr)
			)
			(2
				(self setScript: exitEastScr)
			)
		)
		(return 0)
	)

	(method (dispose)
		(if (and (!= gNewRoomNum 310) (OneOf global171 3 4))
			(= global171 7)
		)
		(DisposeScript 64964)
		(super dispose:)
	)
)

(instance fromHealthSpaScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 105 103
					loop: 8
					setScaler: Scaler 100 80 107 99
					cel: 2
				)
				(door cel: (door lastCel:))
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 115 112 self)
			)
			(2
				(gEgo setHeading: 180)
				(door setCycle: Beg self)
			)
			(3
				(gGlobalSound1 number: 33 loop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toHealthSpaScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: gammie)
					(= local0 1)
					(gEgo
						setMotion:
							MoveTo
							(door approachX:)
							(door approachY:)
							self
					)
				else
					(= ticks 20)
				)
			)
			(1
				(gEgo
					view: 901
					loop: 6
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(doorSfx number: 32 play:)
				(gEgo setCycle: Beg self)
				(door setCycle: End self)
			)
			(4 0)
			(5
				(gGlobalSound2 fade:)
				(gEgo
					normalize: 900 8 1
					cel: 7
					setScaler: Scaler 100 80 107 99
					setMotion: MoveTo 105 103 self
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(gCurRoom newRoom: 310)
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
					(gCurRoom newRoom: 200)
				else
					(gCurRoom newRoom: 305)
				)
			)
		)
	)
)

(instance enterFromEastScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 265 116 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
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
				(gCurRoom newRoom: 305)
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
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance egoOpenDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(= cycles 2)
			)
			(1
				(gMessager say: 6 4 1 1 self) ; "Here, Gammie. Allow me to get that door for you!"
			)
			(2
				(if
					(or
						(!= (gEgo x:) (door approachX:))
						(!= (gEgo y:) (door approachY:))
					)
					(gEgo
						ignoreActors: 1
						setMotion:
							MoveTo
							(door approachX:)
							(door approachY:)
							self
					)
				else
					(= cycles 2)
				)
			)
			(3
				(gEgo
					view: 901
					loop: 6
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(doorSfx number: 32 play:)
				(gEgo setCycle: Beg self)
				(door setCycle: End self)
			)
			(6)
			(7
				(gEgo
					normalize: 900 8
					setCycle: StopWalk -1
					setMotion: MoveTo 104 121 self
				)
			)
			(8
				(gEgo ignoreActors: 1 setHeading: 0 self)
			)
			(9
				(= cycles 2)
			)
			(10
				(gMessager say: 6 4 1 2 self) ; "Oh, Larry. You're such a gentleman."
			)
			(11
				(gEgo normalize: 900)
				(self dispose:)
			)
		)
	)
)

(instance followGammieInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(!= (gEgo x:) (door approachX:))
						(!= (gEgo y:) (door approachY:))
					)
					(gEgo
						setMotion:
							MoveTo
							(door approachX:)
							(door approachY:)
							self
					)
				else
					(= cycles 2)
				)
			)
			(1
				(if (and (door cel:) (not local1) (not local2))
					(= local2 1)
					(gMessager say: 6 4 2 1 self) ; "A fat ass is presently filling THAT doorway!"
				else
					(self cue:)
				)
			)
			(2
				(gEgo
					setScaler: Scaler 100 80 107 99
					setMotion: MoveTo 105 103 self
				)
			)
			(3
				(= global171 5)
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance gammie of Actor
	(properties
		heading 270
		x 231
		y 116
		view 203
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: StopWalk -1 setScript: gammieScr)
	)

	(method (doVerb theVerb)
		(cond
			((and (not local2) (== theVerb 1) (door cel:)) ; Look
				(= local2 1)
				(gMessager say: 6 4 2 1) ; "A fat ass is presently filling THAT doorway!"
			)
			((== theVerb 2) ; Talk
				(gMessager say: 3 2 2 1 0 200) ; "(LARRY MUSES) (Whoa! Baby! Welcome to Cellulite City!)"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		noun 2
		modNum 205
		sightAngle 40
		approachX 112
		approachY 108
		x 112
		y 102
		view 300
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					((not local0)
						(gCurRoom setScript: toHealthSpaScr)
					)
					((not local1)
						(= local1 1)
						(gGame handsOff:)
						(gMessager say: 6 4 1 0) ; "Here, Gammie. Allow me to get that door for you!"
						(gammieScr register: 1)
					)
					(else
						(gGame handsOff:)
						(gammieScr register: 1)
					)
				)
			)
			((and cel (not local2) (== theVerb 1)) ; Look
				(= local2 1)
				(gMessager say: 6 4 2 1) ; "A fat ass is presently filling THAT doorway!"
			)
			((OneOf theVerb 1 2) ; Look, Talk
				(gMessager say: 6 theVerb)
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
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 108 272 123 300 131 320 130 320 139 1 139 1 93 20 101 39 115 56 116 60 112 96 112 96 106 133 107 133 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance windowFrame of PolyFeature
	(properties
		noun 5
		modNum 205
		sightAngle 40
		y 205
		variableX 1
	)

	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 41 209 82 215 121 264 127 315 139 242 139 215 133 216 139 201 139 201 131 122 124 69 124 1 130 1 120 65 114 145 115 200 118 198 94 187 54 180 34 159 0 178 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flowers of PolyFeature
	(properties
		noun 3
		modNum 205
		sightAngle 40
		variableX 1
		variableY 1
	)

	(method (init)
		(super init: &rest)
		(self addPolygon: flowerPoly1 flowerPoly2)
	)
)

(instance visibleSculpture of Feature
	(properties
		noun 4
		modNum 205
		sightAngle 40
		x 275
		y 106
	)

	(method (init)
		(super init: &rest)
		(self setPolygon: (picturePoly2 init: yourself:))
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 2 theVerb) ; "I'm sure I saw some guy carve this same sculpture on PBS last week!"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hiddenSculpture of Feature
	(properties
		noun 4
		modNum 205
		sightAngle 40
		x 191
		y 106
	)

	(method (init)
		(super init: &rest)
		(self setPolygon: (picturePoly1 init: yourself:))
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 3 theVerb) ; "This sculpture is so obscene, La Costa Lotta installed a window frame just to hide it from you!"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance flowerPoly1 of Polygon
	(properties)

	(method (init)
		(super init: 58 112 41 114 23 105 20 64 35 56 65 53 78 66 77 91 59 112)
	)
)

(instance flowerPoly2 of Polygon
	(properties)

	(method (init)
		(super init: 320 130 299 129 307 94 320 84)
	)
)

(instance picturePoly1 of Polygon
	(properties)

	(method (init)
		(super init: 178 89 168 37 208 37 208 84)
	)
)

(instance picturePoly2 of Polygon
	(properties)

	(method (init)
		(super init: 292 85 264 88 255 37 296 36)
	)
)

(instance doorSfx of Sound
	(properties
		flags 1
		number 32
	)
)

(instance gammieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not global205)
					(proc79_8 2)
				)
				(= cycles 2)
			)
			(1
				(if (!= global171 3)
					(gammie posn: 227 116)
					(self cue:)
				else
					(gammie ignoreActors: 0 setMotion: MoveTo 227 116 self)
				)
			)
			(2
				(= global171 4)
				(gammie setMotion: MoveTo 150 113 self)
			)
			(3
				(cond
					(local0
						(self dispose:)
					)
					((gEgo inRect: 85 99 139 119)
						(gGame handsOff:)
						(self setScript: egoOpenDoorScr self)
						(= register 1)
					)
					(else
						(= local0 1)
						(self cue:)
					)
				)
			)
			(4
				(gammie setMotion: MoveTo 113 112 self)
			)
			(5
				(gammie setHeading: 0 self)
			)
			(6
				(= ticks 40)
			)
			(7
				(if (or (not (door cel:)) (not register))
					(doorSfx number: 32 play:)
					(door setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(8
				(gammie
					ignoreActors: 1
					setScaler: Scaler 100 80 107 99
					setMotion: MoveTo 107 100 self
				)
			)
			(9
				(if (not register)
					(door setCycle: Beg self)
				else
					(client setScript: followGammieInScr)
				)
			)
			(10
				(if global205
					(proc79_7)
				)
				(doorSfx number: 33 play:)
				(gammie hide: ignoreActors: 1)
				(= cycles 2)
			)
			(11
				(if register
					(gEgo setScript: toHealthSpaScr)
				)
				(= global171 5)
				(= local0 0)
				(= seconds 5)
			)
			(12
				(= global171 7)
				(gammie dispose:)
			)
		)
	)
)

