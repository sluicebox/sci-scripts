;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use DeathIcon)
(use Interface)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm650 of GloryRm
	(properties
		picture 650
		east 620
		rightY 118
	)

	(method (init)
		(if gDebugging
			(= local0 (GetNumber {Event #?}))
		else
			(= local0
				(cond
					((IsFlag 115) 4)
					((not gNight) 1)
					((and gNight (not (IsFlag 143))) 2)
					((and gNight (IsFlag 143)) 3)
					(else 0)
				)
			)
		)
		(gEgo
			x: 293
			y: 117
			setLoop: 1 1
			init:
			setScaler: Scaler 100 98 189 0
			ignoreActors: 1
			normalize:
		)
		(if
			(or
				(and (IsFlag 144) (== gHeroType 1) (> [gEgoStats 35] 0)) ; Magic User, ritualOfReleaseSpell
				(and (!= gHeroType 1) (IsFlag 144)) ; Magic User
			)
			(= local1 1)
		)
		(if (IsFlag 143)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 320 102 267 128 225 130 189 130 177 136 129 137 114 130 77 131 63 122 38 128 16 124 0 139 0 0 320 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 110 319 189 0 189 0 155 288 152 291 125
						yourself:
					)
			)
		else
			(pDoor init:)
			(fFloor init:)
			(if (not (IsFlag 145))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 301 101 286 107 281 114 288 124 319 115 319 189 0 189 0 0 319 0 319 93
							yourself:
						)
				)
			)
		)
		(if (!= local0 4)
			(aToby init: ignoreActors: 1)
		)
		(vEntrance init:)
		(if (not gNight)
			(vCoffin init: ignoreActors: 1)
		else
			(pRtCandle setCycle: Fwd init:)
			(pLtCandle setCycle: Fwd init:)
			(fireSound play:)
		)
		(switch local0
			(1
				(SetFlag 140)
				(gCurRoom setScript: sStayOut)
			)
			(2
				(pTanya init:)
				(tanyaTeller init: pTanya 650 3 151 2)
				(heroTeller init: gEgo 650 3 128 2)
				(tobyTeller init: aToby 650 3 126 2)
				(gCurRoom setScript: sComeIn)
			)
			(3
				(pTanya setLoop: 0 1 init:)
				(tanyaTeller init: pTanya 650 3 151 9)
				(heroTeller init: gEgo 650 3 128 9)
				(tobyTeller init: aToby 650 3 126 9)
				(gCurRoom setScript: sComeIn)
			)
			(4
				(gCurRoom setScript: sComeOnIn)
			)
		)
		(pDoor init: setCel: 0 setCycle: End)
		(super init: &rest)
		(FrameOut)
		(gLongSong number: 650 setLoop: -1 play:)
		(fWindow init:)
		(fSnowGlobe init:)
		(fDancer init:)
		(fClock init:)
		(fSteps init:)
		(fPeasantDoll init:)
		(fDresser init:)
		(fClown init:)
		(fElephant init:)
		(fCastle1 init:)
		(fCastle2 init:)
		(fTheatre init:)
		(fPolkaHorse init:)
		(fDoor init:)
		(fCandelabra1 init:)
		(fCandelabra2 init:)
		(fCoffin init:)
		(fDrapery init:)
		(fRug init:)
		(gGlory save: 1)
	)

	(method (doVerb theVerb)
		(cond
			((IsFlag 115)
				(if (== theVerb 4) ; Do
					(gMessager say: 27 4 47 0 self) ; "The toys look forlorn with the little girl gone."
				else
					(super doVerb: theVerb)
				)
			)
			((== theVerb 4) ; Do
				(if (not (IsFlag 143))
					(gMessager say: 27 4 42 0 self) ; "You can't reach anything from here."
				else
					(gMessager say: 27 4 43 0 self) ; "That belongs to the little girl."
				)
			)
			((== theVerb 37) ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 28 6 46) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(SetFlag 145)
					(if (IsFlag 143)
						(gCurRoom setScript: sNotNice)
					else
						(gCurRoom setScript: sStayOut)
					)
				)
			)
			((OneOf theVerb 21 83 86 88 79 93 82) ; theRocks, dazzleSpell, flameDartSpell, forceBoltSpell, frostSpell, lightningBallSpell, triggerSpell
				(SetFlag 145)
				(if (IsFlag 143)
					(gCurRoom setScript: sNotNice)
				else
					(gCurRoom setScript: sStayOut)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (> (gEgo x:) 310)
			(gCurRoom newRoom: (gCurRoom east:))
		)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 28 6 45 0 self) ; "You sense that something is very wrong here, but not immediately dangerous. The creature does not seem to be openly hostile, just very protective of the child."
				else
					(= seconds 2)
				)
			)
			(2
				(if (not (IsFlag 143))
					(aToby setLoop: 1 1 setCel: 0 setCycle: CT 8 1 self)
				else
					(self cue:)
				)
			)
			(3
				(if (not (IsFlag 143))
					(aToby setPri: 141 setCel: 9 setCycle: End)
					(pDoor setCycle: CT 2 -1 self)
				else
					(self cue:)
				)
			)
			(4
				(if (not (IsFlag 143))
					(closeDoorSound play:)
					(pDoor cycleSpeed: 1 setCycle: CT 0 -1 self)
				else
					(self cue:)
				)
			)
			(5
				(pDoor cycleSpeed: 6)
				(= seconds 3)
			)
			(6
				(if (not (IsFlag 143))
					(aToby setPri: 110)
					(pDoor setCel: 2 setCycle: End self)
				else
					(self cue:)
				)
			)
			(7
				(cond
					((IsFlag 145)
						(gCurRoom setScript: sNotNice)
					)
					((IsFlag 142)
						(gMessager say: 1 6 8 0 self) ; "Hello, friend. Vana says she thinks you're nice."
					)
					((IsFlag 143)
						(SetFlag 142)
						(gMessager say: 1 6 7 0 self) ; "Hello! Vana is so happy to be back with us now."
					)
					((IsFlag 141)
						(gMessager say: 1 6 4 0 self) ; "Who is it this time, Toby?"
					)
					(else
						(SetFlag 141)
						(gCurRoom setScript: sWhoseThere)
					)
				)
			)
			(8
				(if (IsFlag 143)
					(gEgo setMotion: MoveTo 288 135 self)
				else
					(self cue:)
				)
			)
			(9
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sComeOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: MoveTo 288 135 self)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTobyClosesDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setLoop: 1 1
					setCycle: Rev
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
			)
			(1
				(gEgo normalize:)
				(aToby setLoop: 1 1 setCel: 0 setCycle: CT 7 1 self)
			)
			(2
				(aToby setCel: 7 setCycle: CT 13 1 self)
				(pDoor setCycle: CT 2 -1 self)
			)
			(3
				(aToby setPri: 141)
				(closeDoorSound play:)
				(pDoor cycleSpeed: 1 setCycle: CT 0 -1 self)
			)
			(4
				(pDoor cycleSpeed: 6 setCycle: End self)
			)
			(5
				(gMessager say: 1 6 4 0 self) ; "Who is it this time, Toby?"
			)
			(6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNotNice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 145)
				(gMessager say: 1 6 3 0 self) ; "You're not a very nice person. You tried to hurt us. I don't like you. You should hug me and make me feel better."
			)
			(1
				(pDoor setPri: 152)
				(gEgo setPri: 163 setMotion: PolyPath 170 139 self)
			)
			(2
				(pDoor ignoreActors: 1)
				(vEntrance ignoreActors: 1)
				(aToby ignoreActors: 1)
				(pDoor setCel: 2 cycleSpeed: 1 setCycle: Beg self)
				(aToby setPri: 119)
			)
			(3
				(pDoor cycleSpeed: 6)
				(pTanya
					view: 652
					setLoop: 0 1
					setCel: 0
					posn: 152 118
					setCycle: End self
				)
			)
			(4
				(pTanya setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					ignoreHorizon: 1
					setPri: 163
					setMotion: MoveTo 168 137 self
				)
			)
			(6
				(gMessager say: 1 6 44 0 self) ; "You realize that attacking this sweet little girl really wasn't very nice, and that you really have to go up and hug her."
			)
			(7
				(EgoDead 3 650) ; "That'll teeth you a lesson! Don't go around trying to hurt sweet, innocent little girls, especially when they have sharper canines than yours."
			)
		)
	)
)

(instance sWhoseThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 152)
				(if (IsFlag 140)
					(gMessager say: 1 6 2 0 self) ; "Who is it, Toby?"
				else
					(gMessager say: 1 6 1 0 self) ; "Who is it, Toby?"
				)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStayOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(= seconds 2)
			)
			(2
				(aToby setPri: 141 setLoop: 1 1 setCel: 0 setCycle: CT 8 1 self)
			)
			(3
				(closeDoorSound play:)
				(aToby setCel: 8 setCycle: End self)
				(pDoor cycleSpeed: 1 setCycle: Beg self)
			)
			(4
				(if (not (IsFlag 145))
					(pDoor setCel: 0 cycleSpeed: 6 setCycle: CT 4 1 self)
				else
					(self cue:)
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(if (not (IsFlag 145))
					(aToby setCel: 0 setCycle: CT 8 1 self)
				else
					(self cue:)
				)
			)
			(7
				(closeDoorSound play:)
				(if (not (IsFlag 145))
					(aToby setCel: 8 setCycle: End self)
				)
				(pDoor setCel: 4 cycleSpeed: 1 setCycle: CT 0 -1 self)
			)
			(8
				(pDoor cycleSpeed: 6)
				(= seconds 3)
			)
			(9
				(if (== local0 1)
					(gMessager say: 28 6 2 0 self) ; "The monster doesn't seem to like you letting light into the room. Maybe you would have better luck at night."
				else
					(self cue:)
				)
			)
			(10
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sGiveDoll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(fFloor dispose:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gMessager say: 1 6 5 0 self) ; "What's that you got?"
			)
			(1
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 102 267 128 225 130 189 130 177 136 129 137 114 130 77 131 63 122 38 128 16 124 0 139 0 0 319 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 161 319 189 0 189 0 161
							yourself:
						)
				)
				(SetFlag 143)
				(gEgo solvePuzzle: 449 15)
				(aToby setPri: 106 setLoop: 0 1 setCycle: CT 10 1 self)
			)
			(2
				(aToby setCycle: 0)
				(= local2 (gEgo cycleSpeed:))
				(= local3 (pDoor priority:))
				(pDoor setPri: 110)
				(gEgo use: 33 setMotion: PolyPath 176 138 self) ; theDoll
			)
			(3
				(gEgo
					view: 31
					setCel: 0
					setLoop: 1 1
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(4
				(sMagicSound play:)
				(gEgo setCel: 2 setCycle: Beg self)
			)
			(5
				(pDoor setPri: 108)
				(pTanya setLoop: 1 1 setCel: 9 setCycle: Beg self)
			)
			(6
				(heroTeller dispose:)
				(tanyaTeller dispose:)
				(tobyTeller dispose:)
				(gEgo cycleSpeed: local2 normalize:)
				(self cue:)
			)
			(7
				(tanyaTeller init: pTanya 650 3 151 9)
				(heroTeller init: gEgo 650 3 128 9)
				(tobyTeller init: aToby 650 3 126 9)
				(gMessager say: 1 6 6 0 self) ; "Oh, Vana, I thought I lost you!"
			)
			(8
				(self dispose:)
				(gGlory handsOn:)
			)
		)
	)
)

(instance sdoRoom270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 128 41 1 self) ; "You tell about Erana's Staff and how it can make Tanya back into a real little girl again."
			)
			(1
				(gMessager say: 3 128 41 2 self) ; "I like the Staff. It always made such pretty flowers in town. You say it will make me all better and I won't be a Bad Thing anymore?"
			)
			(2
				(gMessager say: 3 128 41 3 self) ; "You nod your head."
			)
			(3
				(gMessager say: 3 128 41 4 self) ; "Oh, Toby! I can see Mommy and Daddy again!"
			)
			(4
				(gMessager say: 3 128 41 5 self) ; "Grorarro ooraroogr?"
			)
			(5
				(gMessager say: 3 128 41 6 self) ; "Toby asks what else will the staff do?"
			)
			(6
				(gMessager say: 3 128 41 7 self) ; "You try to explain about sacrifice."
			)
			(7
				(gMessager say: 3 128 41 8 self) ; "Rrorra grourraoo."
			)
			(8
				(gMessager say: 3 128 41 9 self) ; "Toby says he understands. He says you should take us to the Staff now, so I can be with Mommy and Daddy again!"
			)
			(9
				(gLongSong doSongs: fade:)
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance aToby of Actor
	(properties
		noun 29
		x 187
		y 125
		priority 106
		fixPriority 1
		view 650
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pLtCandle of Prop
	(properties
		x 86
		y 70
		view 650
		loop 5
		detailLevel 2
	)
)

(instance pRtCandle of Prop
	(properties
		x 226
		y 68
		view 650
		loop 6
		detailLevel 2
	)
)

(instance pTanya of Prop
	(properties
		noun 1
		x 156
		y 116
		view 651
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; theDoll
				(gCurRoom setScript: sGiveDoll)
			)
			(4 ; Do
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pDoor of Prop
	(properties
		noun 21
		x 284
		y 24
		priority 141
		fixPriority 1
		view 650
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom newRoom: 620)
		else
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (and cycler (cycler isKindOf: End) (not cel))
			(openDoor stop: play:)
		)
		(super doit:)
	)
)

(instance vEntrance of View
	(properties
		noun 21
		x 285
		y 26
		priority 97
		fixPriority 1
		view 650
		loop 3
	)
)

(instance vCoffin of View
	(properties
		noun 24
		x 160
		y 97
		priority 40
		fixPriority 1
		view 650
		loop 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fWindow of Feature
	(properties
		noun 10
		nsTop 10
		nsRight 39
		nsBottom 64
		sightAngle 180
		x 19
		y 37
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fSnowGlobe of Feature
	(properties
		noun 11
		nsLeft 20
		nsTop 67
		nsRight 31
		nsBottom 80
		sightAngle 180
		x 25
		y 73
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fDancer of Feature
	(properties
		noun 12
		nsLeft 31
		nsTop 64
		nsRight 39
		nsBottom 78
		sightAngle 180
		x 35
		y 71
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fClock of Feature
	(properties
		noun 13
		nsLeft 59
		nsTop 25
		nsRight 72
		nsBottom 74
		sightAngle 180
		x 65
		y 49
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fSteps of Feature
	(properties
		noun 14
		nsLeft 126
		nsTop 111
		nsRight 183
		nsBottom 130
		sightAngle 180
		x 154
		y 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fPeasantDoll of Feature
	(properties
		noun 15
		nsTop 92
		nsRight 30
		nsBottom 125
		sightAngle 180
		x 15
		y 108
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fDresser of Feature
	(properties
		noun 16
		nsLeft 7
		nsTop 74
		nsRight 68
		nsBottom 114
		sightAngle 180
		x 37
		y 94
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fClown of Feature
	(properties
		noun 17
		nsLeft 33
		nsTop 135
		nsRight 79
		nsBottom 189
		sightAngle 180
		x 56
		y 162
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fElephant of Feature
	(properties
		noun 18
		nsTop 123
		nsRight 71
		nsBottom 177
		sightAngle 180
		x 35
		y 150
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCastle1 of Feature
	(properties
		noun 4
		nsLeft 71
		nsTop 117
		nsRight 100
		nsBottom 189
		sightAngle 180
		x 85
		y 153
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCastle2 of Feature
	(properties
		noun 4
		nsLeft 100
		nsTop 134
		nsRight 144
		nsBottom 189
		sightAngle 180
		x 122
		y 161
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTheatre of Feature
	(properties
		noun 19
		nsLeft 227
		nsTop 141
		nsRight 292
		nsBottom 188
		sightAngle 180
		x 259
		y 164
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fPolkaHorse of Feature
	(properties
		noun 20
		nsLeft 283
		nsTop 119
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 301
		y 154
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fDoor of Feature
	(properties
		noun 21
		nsLeft 272
		nsTop 23
		nsRight 304
		nsBottom 119
		sightAngle 180
		x 288
		y 71
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom newRoom: 620)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFloor of Feature
	(properties
		nsLeft 257
		nsTop 103
		nsRight 292
		nsBottom 121
		sightAngle 180
		x 257
		y 103
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 275 103 292 103 286 121 268 121
						yourself:
					)
					1
					5
					4
					sTobyClosesDoor
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCandelabra1 of Feature
	(properties
		noun 22
		nsLeft 75
		nsTop 54
		nsRight 97
		nsBottom 90
		sightAngle 180
		x 86
		y 72
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCandelabra2 of Feature
	(properties
		noun 23
		nsLeft 215
		nsTop 53
		nsRight 238
		nsBottom 91
		sightAngle 180
		x 226
		y 72
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCoffin of Feature
	(properties
		noun 24
		nsLeft 109
		nsTop 86
		nsRight 203
		nsBottom 104
		sightAngle 180
		x 156
		y 95
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fDrapery of Feature
	(properties
		noun 25
		nsLeft 73
		nsRight 255
		nsBottom 107
		sightAngle 180
		x 164
		y 53
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fRug of Feature
	(properties
		noun 26
		nsLeft 100
		nsTop 131
		nsRight 259
		nsBottom 174
		sightAngle 180
		x 179
		y 152
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tanyaTeller of Teller
	(properties
		title 1
		actionVerb 2
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 99 0)) ; tanyaVampTalker
	)
)

(instance heroTeller of Teller
	(properties
		actionVerb 2
	)

	(method (showCases)
		(super showCases: 41 local1) ; Tell About Erana's Staff
	)

	(method (sayMessage)
		(switch iconValue
			(41 ; Tell About Erana's Staff
				(self clean:)
				(gCurRoom setScript: sdoRoom270)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance tobyTeller of Teller
	(properties
		title 1
		actionVerb 2
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 70 0)) ; tobyTalker
	)
)

(instance fireSound of Sound
	(properties
		number 965
		loop -1
	)
)

(instance openDoor of Sound
	(properties
		number 972
	)
)

(instance closeDoorSound of Sound
	(properties
		number 973
	)
)

(instance sMagicSound of Sound
	(properties
		number 934
	)
)

