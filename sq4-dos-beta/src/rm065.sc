;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm065 0
)

(local
	[local0 42] = [0 186 188 186 192 159 227 149 153 100 139 109 101 109 82 99 77 85 91 71 105 69 86 51 77 55 40 54 22 46 18 30 30 26 6 0 319 0 319 189 0 189]
	[local42 46] = [26 0 27 36 42 48 66 50 86 42 86 89 96 99 133 100 152 87 169 97 192 97 194 116 204 124 201 162 230 160 231 148 241 143 243 148 246 160 271 162 273 155 319 149 319 0]
)

(instance rm065 of SQRoom
	(properties
		picture 65
		style 30
		horizon 48
		north 50
		west 60
		vanishingX 0
		vanishingY -65
	)

	(method (init)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(west 0)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(gEgo init:)
		(if (== ((gInventory at: 1) owner:) 65) ; rope
			(aRope init:)
		)
		(poly1 points: @local0 size: 21)
		(self addObstacle: poly1)
		(buildingPoly points: @local42 size: 23)
		(theRubble init:)
		(theRedBldg init:)
		(theLiquid init:)
		(theGrate init:)
		(theArea init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== (gEgo edgeHit:) EDGE_TOP) (!= script exitScript))
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) EDGE_TOP) (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 4 -1 setMotion: MoveTo 17 49 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 5 -10 self)
			)
			(1
				(= register 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance getRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 183 self)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 2) self
				)
			)
			(2
				(HandsOn)
				(aRope dispose:)
				(self cue:)
			)
			(3
				(gEgo get: 1) ; rope
				(client setScript: 0)
			)
		)
	)
)

(instance aRope of View
	(properties
		x 160
		y 189
		z 10
		description {rope}
		sightAngle 45
		lookStr {It's a lightweight, worn piece rope.}
		view 33
		priority 15
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 10)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: getRope)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance theRubble of Feature
	(properties
		x 160
		y 188
		nsBottom 200
		nsRight 320
		description {rubble}
		onMeCheck 64
		lookStr {The clearing ends here. Progress south is not possible over the jagged terrain.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= ((gInventory at: 1) owner:) 65) ; rope
					(Print 65 0) ; "The rubble is too dangerous for you to mess around on."
				else
					(Print 65 1) ; "The rubble is too dangerous for you to mess with - except maybe for that knotted-looking thing."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRedBldg of Feature
	(properties
		x 280
		y 5
		description {red building}
		lookStr {A battered and boarded storefront shows the wear and tear a little war can have on it.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 65 2) ; "The building is closed-up with welded metal panels enhancing the non-access accent."
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

(instance theLiquid of Feature
	(properties
		x 39
		y 115
		nsBottom 200
		nsRight 320
		description {solidified run-off}
		sightAngle 45
		onMeCheck 128
		lookStr {What looks like fluid is actually a sedimentary mixture of toxic atmospheric solids.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theGrate of Feature
	(properties
		x 85
		y 163
		nsBottom 200
		nsRight 320
		description {grate}
		sightAngle 45
		onMeCheck 512
		lookStr {The grate is anchored securely by bolts with corroded heads.}
	)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the southeastern corner of the clearing. Rubble restricts southern passage.}
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

