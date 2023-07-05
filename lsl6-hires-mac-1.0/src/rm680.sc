;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use System)

(public
	rm680 0
	rideTram 1
)

(instance rm680 of LarryRoom
	(properties
		modNum 690
		noun 1
		picture 690
		style 1024
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 320 101 283 101 283 95 268 95 265 100 184 100 184 95 161 95 159 101 56 100 43 106 0 106 0 116 16 116 8 138 320 138
					yourself:
				)
		)
		(if (not (IsFlag 35))
			(gEgo normalize: init:)
		)
		(switch gPrevRoomNum
			(810
				(self style: 1024)
				(if (not (IsFlag 35))
					(self setScript: enterFromWestScr)
				)
			)
		)
		(if (IsFlag 35)
			(if (not (IsFlag 36))
				((ScriptID 825 1) view: 90 z: 0 posn: 319 127 init:) ; tram
			)
			((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
			((ScriptID 825 1) setScript: rideTram) ; tram
		else
			(gGame handsOn:)
		)
		(if (not (gGlobalSound2 handle:))
			(gGlobalSound2 number: 200 play: setLoop: -1)
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(810
				(gEgo posn: -10 113)
			)
			(640
				(gEgo loop: 8 x: 310 cel: 1)
			)
			(else
				(gEgo posn: 310 118)
			)
		)
		(leftDoorFtr init:)
		(rightDoorFtr init:)
		(panes init:)
		(carpet init:)
		(windowFrame init:)
		(sculpture1 init:)
		(sculpture2 init:)
		(doorway init:)
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

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 640)
			(gGlobalSound2 fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gTheIconBar
					disableIcon:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 6) ; icon3
						(ScriptID 0 9) ; icon6
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
				(DisposeScript 826)
				(cond
					((and (IsFlag 36) (> ((ScriptID 825 1) x:) 319)) ; tram
						(self cue:)
					)
					((IsFlag 36)
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 319 127 self
						)
					)
					(else
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 90 127 self
						)
					)
				)
			)
			(1
				(if (IsFlag 36)
					(gCurRoom newRoom: 640)
				else
					(SetFlag 70)
					(self setScript: (ScriptID 826 1) self) ; getOffTram
				)
			)
			(2
				(SetFlag 36)
				(self setScript: (ScriptID 826 2) self) ; turnTramLeft
			)
			(3
				(= cycles 2)
			)
			(4
				(DisposeScript 826)
				(self dispose:)
			)
		)
	)
)

(instance enterFromWestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 33 113 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromEastScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 310 118 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
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
				(gCurRoom newRoom: 640)
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
				(gEgo setMotion: MoveTo -6 113 self)
				(gGlobalSound2 fade:)
			)
			(1
				(gCurRoom newRoom: 810)
			)
		)
	)
)

(instance leftDoorFtr of Feature
	(properties
		noun 2
		modNum 205
		sightAngle 40
		approachX 169
		approachY 98
		x 169
		y 96
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) init: 190 46 154 46 150 94 195 94 yourself:)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
			)
			(1 ; Look
				(gMessager say: 6 theVerb) ; "This is the Presidential Suite."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDoorFtr of Feature
	(properties
		noun 2
		modNum 205
		sightAngle 40
		approachX 272
		approachY 96
		x 272
		y 93
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) init: 294 47 258 46 256 94 290 94 yourself:)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
			)
			(1 ; Look
				(gMessager say: 11 theVerb) ; "Maybe if you put your eye really close to the peephole, you can watch the itty-bitty people inside?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance panes of PolyFeature
	(properties
		noun 10
		sightAngle 40
		y 92
		variableX 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:) init: 101 0 99 67 118 67 120 0 yourself:)
				((Polygon new:) init: 79 0 47 0 49 77 66 70 67 29 yourself:)
				((Polygon new:) init: 1 0 1 49 41 40 40 1 yourself:)
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
					type: PContainedAccess
					init: 320 98 295 99 291 94 257 94 252 97 200 97 195 94 151 95 143 99 97 99 90 126 320 135
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 51 99 43 105 28 105 4 120 4 128 29 125 66 125 63 99
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
					init: 320 140 1 139 1 128 24 125 66 125 63 96 65 71 70 25 80 0 100 0 100 58 97 95 89 126 320 135
					yourself:
				)
		)
	)
)

(instance sculpture1 of Feature
	(properties
		noun 4
		modNum 205
		sightAngle 40
		x 224
		y 96
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) init: 241 66 209 68 200 17 242 17 yourself:)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4) ; Look, Do
			(gMessager say: 8 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sculpture2 of Feature
	(properties
		noun 4
		modNum 205
		sightAngle 40
		x 318
		y 97
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) init: 320 73 308 73 305 18 320 18 yourself:)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4) ; Look, Do
			(gMessager say: 9 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance doorway of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon: ((Polygon new:) init: 42 105 4 135 6 65 36 52 yourself:)
		)
		(super init: &rest)
	)
)

