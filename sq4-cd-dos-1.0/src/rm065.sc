;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Motion)
(use System)

(public
	rm065 0
)

(local
	[local0 46] = [26 0 27 36 42 48 66 50 86 42 86 89 96 99 133 100 152 87 169 97 192 97 194 116 204 124 201 162 230 160 231 148 241 143 243 148 246 160 271 162 273 155 319 149 319 0]
	[local46 16] = [0 70 106 173 81 184 75 172 65 168 41 175 40 182 0 183]
	[local62 48] = [0 0 26 0 27 35 43 49 67 51 86 43 86 89 94 100 118 103 138 100 151 86 166 97 191 98 192 115 203 122 199 164 190 167 186 163 151 174 143 167 128 173 111 170 105 172 0 70]
	[local110 32] = [0 70 79 148 78 151 78 152 76 153 74 152 73 150 62 139 57 140 43 126 23 113 15 107 3 93 1 90 1 88 0 87]
)

(instance rm065 of SQRoom
	(properties
		picture 65
		style 10
		horizon 48
		north 50
		west 60
		vanishingX 0
		vanishingY -65
	)

	(method (init)
		(Load rsVIEW 8)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(west
				(if (> (gEgo y:) 179)
					(gEgo y: 179)
				)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(gEgo init:)
		(if (== ((gInventory at: 1) owner:) 65) ; rope
			(aRope init:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 179 185 179 192 159 227 149 152 103 139 109 101 109 82 99 77 85 91 71 105 69 86 51 77 55 40 54 22 46 18 30 30 26 6 0 319 0 319 189 0 189
					yourself:
				)
		)
		(buildingPoly points: @local0 size: 23)
		(streetPoly points: @local46 size: 8)
		(sidewalkPoly points: @local62 size: 24)
		(liquidPoly points: @local110 size: 16)
		(theRubble init:)
		(theRedBldg init:)
		(theLiquid init:)
		(theGrate init:)
		(theStreet init:)
		(theSidewalk init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(self setRegions: 705) ; bunny
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			(
				(and
					(== (gEgo edgeHit:) 1)
					(!= script exitScript)
					(!= script (ScriptID 701 3)) ; cyborgScreams
					(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
				)
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) 1) (not (script register:)))
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
				(gEgo setMotion: PolyPath 169 177 self)
			)
			(1
				(gEgo
					view: 8
					loop: 0
					cel: 0
					x: 168
					y: 177
					cycleSpeed: 16
					heading: 225
				)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: CT 2 1 self)
			)
			(3
				(gNarrator say: 1 self) ; "You take the small, frayed, useless-looking length of rope."
			)
			(4
				(aRope dispose:)
				(SetScore 39 5)
				(= cycles 1)
			)
			(5
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(6
				(NormalEgo 2 0)
				(gEgo posn: 169 177 get: 1) ; rope
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance aRope of Sq4View
	(properties
		x 162
		y 195
		z 10
		sightAngle 45
		view 33
		priority 14
		signal 16400
		lookStr 2 ; "It's a lightweight, worn piece of rope."
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
			(6 ; Smell
				(gNarrator say: 3) ; "Smells like a frayed old length of rope."
			)
			(7 ; Taste
				(gNarrator say: 4) ; "You run the risk of tying your tongue in a frayed knot."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 160
		y 188
		nsBottom 200
		nsRight 320
		onMeCheck 64
		lookStr 5 ; "The clearing ends here. Progress south is impossible over the jagged terrain."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= ((gInventory at: 1) owner:) 65) ; rope
					(gNarrator say: 6) ; "The rubble is too dangerous for you to mess around on."
				else
					(gNarrator say: 7) ; "The rubble is too dangerous for you to mess with - except maybe for that knotted-looking thing."
				)
			)
			(6 ; Smell
				(gNarrator say: 8) ; "The faint aroma of burnt hemp teases playfully around your nostrils."
			)
			(7 ; Taste
				(gNarrator say: 9) ; "You swish the rubble around in your mouth a bit, but the flavor is too subtle to identify."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRedBldg of Sq4Feature
	(properties
		x 280
		y 180
		sightAngle 40
		lookStr 10 ; "A battered and boarded storefront shows the wear and tear a little war can have on it."
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator modNum: 50 say: 9) ; "The building is closed up with welded metal panels."
			)
			(6 ; Smell
				(gNarrator say: 11) ; "There's a sweet, fruity odor coming from the building."
			)
			(7 ; Taste
				(tRog say: 1) ; "Mmmmmm! Wild Berry!"
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

(instance theLiquid of Sq4Feature
	(properties
		x 39
		y 115
		nsBottom 200
		nsRight 320
		sightAngle 45
		lookStr 12 ; "What looks like fluid is actually a mixture of toxic atmospheric solids."
	)

	(method (init)
		(super init:)
		(self onMeCheck: liquidPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator say: 13) ; "It smells just as good as it looks."
			)
			(7 ; Taste
				(gNarrator say: 14) ; "It tastes just as good as it smells."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance liquidPoly of Polygon
	(properties)
)

(instance theGrate of Sq4Feature
	(properties
		x 85
		y 163
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 512
		lookStr 15 ; "The grate is anchored securely by bolts with corroded heads."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator say: 15) ; "The grate is anchored securely by bolts with corroded heads."
			)
			(6 ; Smell
				(gNarrator say: 16) ; "It smells grate!"
			)
			(7 ; Taste
				(gNarrator say: 17) ; "It tastes grate!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theStreet of Sq4Feature
	(properties)

	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 18) ; "It seems to have everything you'd look for in a street with the exception of mobile creatures or vehicles."
			)
			(6 ; Smell
				(gNarrator say: 19) ; "The street stinks. Somebody must have been driving on it."
			)
			(7 ; Taste
				(gNarrator modNum: 40 say: 12) ; "It tastes about like you'd expect it to taste, given how it smells."
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance theSidewalk of Sq4Feature
	(properties)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalkPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 20) ; "It's very pleasant looking."
			)
			(7 ; Taste
				(gNarrator say: 21) ; "It tastes like all the other sidewalks you've ever tasted."
			)
			(6 ; Smell
				(gNarrator say: 22) ; "The sidewalk stinks. Somebody must have been walking on it."
			)
			(9 ; rope
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalkPoly of Polygon
	(properties)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 65
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

