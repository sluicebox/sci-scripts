;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm025 0
)

(local
	[local0 30] = [32 189 54 172 72 168 91 154 99 141 101 101 106 97 147 100 170 83 189 75 201 67 212 49 211 0 0 0 0 189]
	[local30 14] = [319 87 289 88 244 74 199 69 212 51 212 0 319 0]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global143 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(instance rm025 of SQRoom
	(properties
		picture 25
		style 30
		east 30
		south 40
		vanishingX 319
		vanishingY -35
	)

	(method (init)
		(switch gPrevRoomNum
			(south
				(gEgo x: 103)
			)
			(45
				(HandsOff)
				(gEgo init: x: 272 y: 245)
				(self setScript: enterScript)
			)
			(else
				(HandsOn)
				(gEgo view: 0 posn: 160 160)
			)
		)
		(if (IsFlag 0)
			(Load rsVIEW 7)
			(cop1 init:)
			(cop2 init:)
		)
		(gEgo init:)
		(theRubble init:)
		(theGreenBuilding init:)
		(theArea init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 89 299 92 266 85 246 79 211 77 195 73 153 104 111 101 62 146 69 169 45 189
					yourself:
				)
		)
		(buildingPoly points: @local0 size: 15)
		(rubblePoly points: @local30 size: 7)
	)

	(method (newRoom newRoomNumber)
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (> (gEgo x:) 199))
			(= newRoomNumber 45)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 7 setMotion: MoveTo 242 188 self)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance cop1 of Actor
	(properties
		x 241
		y 110
		view 7
		loop 2
	)

	(method (doit)
		(super doit: &rest)
		(if (not (self script:))
			(self setScript: shootEgo)
		)
	)
)

(instance cop2 of Actor
	(properties
		x 88
		y 126
		view 7
	)
)

(instance shootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop1 setCycle: Walk setMotion: MoveTo 200 140 self)
				(cop2 setCycle: Walk setMotion: DPath 120 126 120 136)
			)
			(1
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 4 1 self)
			)
			(2
				(HandsOff)
				(cop1 setCycle: End self)
				(if (< (cop1 x:) (gEgo x:))
					(localproc_0
						(- (cop1 y:) 27)
						(cop1 x:)
						(- (gEgo y:) 32)
						(gEgo x:)
					)
				else
					(localproc_0
						(- (gEgo y:) 32)
						(gEgo x:)
						(- (cop1 y:) 27)
						(cop1 x:)
					)
				)
			)
			(3
				(gEgo
					view: 26
					loop:
						(switch (gEgo loop:)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else
								(gEgo loop:)
							)
						)
					cel: 0
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo setCycle: CT 1 -1 self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(= seconds 4)
			)
			(7
				(EgoDead)
				(Print 25 0) ; "ego's dead"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theRubble of Feature
	(properties
		x 270
		y 33
		description {rubble}
		sightAngle 45
		lookStr {A hazardous accumulation of un-structured structures blocks safe passage north.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 25 1) ; "The rubble is rough and jagged. No sense in risking injury this early in the adventure. We'll get to that later."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rubblePoly of Polygon
	(properties)
)

(instance theGreenBuilding of Feature
	(properties
		x 49
		y 13
		description {green building}
		sightAngle 45
		lookStr {The old Bank of Xenon building held up fairly well. Too bad. (They turned Roger down for a loan once.)}
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 25 2) ; "Forget it! The doors and windows have been sealed with welded steel plating. The building is shut tight and void of tactile enticement."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are in the northwest corner of a small clearing on the otherwise rubble-choked streets of Xenon.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4) ; Do
			(6 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

