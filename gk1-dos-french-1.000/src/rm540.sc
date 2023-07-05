;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use n013)
(use Germany)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Cursor)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	local0
	local1
)

(instance rm540 of Room
	(properties
		noun 1
		picture 540
		style 14
		exitStyle 13
	)

	(method (init)
		(gGkMusic1
			number: 540
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(super init:)
		(Load rsMESSAGE 540)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 281 145 212 119 199 119 201 128 119 128 120 117 97 117 99 121 18 145
					yourself:
				)
		)
		(gEgo
			view: 901
			setCel: 0
			setLoop: 0
			signal: (| (gEgo signal:) $1000)
			init:
			setCycle: StopWalk -1
			state: 2
			ignoreActors: 1
			posn: 159 165
			actions: ritualActions
			setScaler: Scaler 100 71 142 107
		)
		(altarCandles init:)
		(altar init:)
		(leftCandleabra init:)
		(rightCandleabra init:)
		(washHandsPanel init:)
		(cutHairPanel init:)
		(getPotPanel init:)
		(bloodPanel init:)
		(kneelPanel init:)
		(scrollPanel init:)
		(leftPews init:)
		(rightPews init:)
		(stainedGlass init:)
		(myExitFeature init:)
		(if (Germany potOnAltar:)
			(pot init:)
		)
		(leftCandle init:)
		(rightCandle init:)
		(gWalkHandler add: self)
		(gWalkHandler add: myExitFeature)
		(gCurRoom setScript: enterTheRoom)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gWalkHandler delete: myExitFeature)
		(gGkMusic1 fade:)
		(DisposeScript 64935)
		(DisposeScript 64939)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gEgo setScript: standUp)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((myExitFeature onMe: gMouseX (- gMouseY 10))
				(if (== gTheCursor ((gTheIconBar at: 0) cursorView:))
					(gGame setCursor: myExitCursor 1)
					(= local1 1)
				)
			)
			(local1
				(gGame setCursor: ((gTheIconBar at: 0) cursorView:) 1)
				(= local1 0)
			)
		)
	)
)

(instance placePotOnAltar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 61) ; chamPot
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 142 127 self)
			)
			(2
				(gEgo
					setScale: 0
					view: 540
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(gGkSound1 number: 541 setLoop: 1 play:)
			)
			(3
				(gMessager say: 5 104 2 0) ; "Thinking of the third panel, Gabriel puts the chamber pot on the altar."
				(Germany potOnAltar: 1)
				(pot init:)
				(gEgo normalize: 3 901 setScaler: Scaler 100 71 142 107)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance readTheScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(gEgo setMotion: PolyPath 142 127 self)
				)
			)
			(1
				(if local0
					(gEgo view: 543 setCel: 0 setLoop: 1 setCycle: End self)
				else
					(gEgo view: 542 setCel: 0 setLoop: 0 setCycle: End self)
				)
				(gGkSound1 number: 544 setLoop: 1 play:)
			)
			(2
				(if (IsFlag 261)
					(gMessager say: 11 105 0 0 self) ; "Thinking of the sixth panel, Gabriel reads the scroll."
				else
					(gMessager say: 11 105 3 0 self) ; "(DRAMATIC. READING SCROLL)St. George, patron of the light, who hunts the shadows of the night...."
				)
				(if local0
					(= cycles 1)
				else
					(gEgo setCel: 0 setLoop: 1 setCycle: Osc 2 self)
				)
			)
			(3)
			(4
				(if local0
					(= cycles 1)
				else
					(gEgo setCel: 0 setLoop: 2 setCycle: End self)
				)
			)
			(5
				(cond
					((or (not local0) (not (IsFlag 261)))
						(if local0
							(gEgo
								view: 543
								setCel: 5
								setLoop: 0
								setCycle: Beg self
							)
							(= local0 0)
							(gMessager say: 10 0 8 0) ; "Hmmm. Nothing. Gabriel has the sneaking suspicion that he left out something. Perhaps that's why he doesn't feel any different."
						else
							(gMessager say: 10 0 8 0 self) ; "Hmmm. Nothing. Gabriel has the sneaking suspicion that he left out something. Perhaps that's why he doesn't feel any different."
						)
					)
					(
						(and
							local0
							(Germany potOnAltar:)
							(Germany egoCutHimself:)
							(Germany saltInPot:)
							(Germany handsAreWashed:)
							(Germany cutHair:)
						)
						(self cue:)
					)
					(local0
						(gEgo
							view: 543
							setCel: 5
							setLoop: 0
							setCycle: Beg self
						)
						(= local0 0)
						(gMessager say: 10 0 8 0) ; "Hmmm. Nothing. Gabriel has the sneaking suspicion that he left out something. Perhaps that's why he doesn't feel any different."
					)
					(else
						(gMessager say: 10 0 8 0 self) ; "Hmmm. Nothing. Gabriel has the sneaking suspicion that he left out something. Perhaps that's why he doesn't feel any different."
					)
				)
			)
			(6
				(if
					(and
						local0
						(Germany potOnAltar:)
						(Germany egoCutHimself:)
						(Germany saltInPot:)
						(Germany handsAreWashed:)
						(Germany cutHair:)
					)
					(gCurRoom setScript: doTheRitual)
					(self dispose:)
				else
					(gEgo normalize: 3 901)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance putSaltInPot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 65) ; salt
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 142 127 self)
			)
			(2
				(gEgo setScale: 0)
				(if (Germany egoCutHimself:)
					(gMessager say: 9 106 6 0) ; "Thinking of the third panel, Gabriel pours the contents of the salt shaker into the chamber pot."
				else
					(gMessager say: 9 106 12 0) ; "Thinking of the third panel, Gabriel pours the contents of the salt shaker into the chamber pot."
				)
				(gGkSound1 number: 542 setLoop: 1 play:)
				(gEgo
					view: 540
					setCel: 0
					setLoop: 1
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(3
				(Germany saltInPot: 1)
				(gEgo normalize: 3 901 setScaler: Scaler 100 71 142 107)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cutEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 142 127 self)
			)
			(2
				(gEgo view: 541 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(gGkSound1 number: 543 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(if (Germany saltInPot:)
					(gMessager say: 11 101 12 0) ; "Thinking of the fourth panel, Gabriel holds his arm over the chamber pot and nicks it with the dagger."
				else
					(gMessager say: 11 101 24 0) ; "Thinking of the fourth panel, Gabriel holds his arm over the chamber pot and nicks it with the dagger."
				)
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(Germany egoCutHimself: 1)
				(gEgo normalize: 3 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kneelAtAltar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 142 127 self)
			)
			(1
				(gEgo view: 543 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(2
				(gMessager say: 5 8 11 0 self) ; "Thinking of the fifth panel, Gabriel kneels at the altar."
			)
			(3
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 543 setCel: 5 setLoop: 0 setCycle: Beg self)
			)
			(1
				(= local0 0)
				(gEgo normalize: 3 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 159 140 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 145 self)
			)
			(2
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance doTheRitual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ShakeScreen 4 ssUPDOWN)
				(gGkSound1 number: 545 setLoop: 1 play: self)
			)
			(1
				(gMessager say: 10 0 7 1 self) ; "It worked! Something's happening!"
				(gEgo view: 543 setCel: 0 setLoop: 2 setCycle: End self)
				(gGkSound2 number: 546 setLoop: -1 play:)
			)
			(2)
			(3
				(gGkSound2 stop:)
				(gGkSound1 number: 547 setLoop: 1 play:)
				(gEgo normalize: 2 901)
				(gerde
					setLoop: -1
					setLooper: Grooper
					init:
					setPri: 140
					setCycle: StopWalk -1
					setMotion: MoveTo 159 140 self
				)
			)
			(4
				(gMessager sayRange: 10 0 7 2 8 self) ; "Oh, excuse me! I was just vacuuming! I did not know you were in here!"
			)
			(5
				(gEgo getPoints: -999 5)
				(gEgo ignoreActors: 1 setMotion: MoveTo 135 145 self)
			)
			(6
				(Germany didTheRitual: 1)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance gerde of Actor
	(properties
		x 159
		y 180
		view 509
	)
)

(instance leftCandle of Prop
	(properties
		x 85
		y 61
		view 545
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
	)
)

(instance rightCandle of Prop
	(properties
		x 231
		y 62
		view 545
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
	)
)

(instance pot of View
	(properties
		noun 9
		sightAngle 30
		x 157
		y 104
		view 540
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(101 ; knife
				(if (IsFlag 261)
					(if (Germany egoCutHimself:)
						(gMessager say: noun theVerb 6 0) ; "(ADAMANT)I'm not going to cut myself again!"
					else
						(gEgo setScript: cutEgo)
					)
				else
					(gMessager say: noun theVerb 3 0) ; MISSING MESSAGE
				)
			)
			(106 ; salt
				(gEgo setScript: putSaltInPot)
			)
			(7 ; Look
				(cond
					((and (Germany egoCutHimself:) (Germany saltInPot:))
						(gMessager say: noun theVerb 13 0) ; "There's a chamber pot on the altar."
					)
					((Germany egoCutHimself:)
						(gMessager say: noun theVerb 15 0) ; "There's a chamber pot on the altar."
					)
					((Germany saltInPot:)
						(gMessager say: noun theVerb 14 0) ; "There's a chamber pot on the altar."
					)
					(else
						(gMessager say: noun theVerb 16 0) ; "There's a chamber pot on the altar."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance altarCandles of Feature
	(properties
		noun 8
		sightAngle 30
		x 160
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 83 145 94 139 97 143 105 130 105 134 96 129 95 128 83 136 78
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 190 83 191 93 185 96 189 105 177 105 180 95 175 93 174 83 183 77
					yourself:
				)
		)
		(super init:)
	)
)

(instance altar of Feature
	(properties
		noun 5
		nsLeft 127
		nsTop 104
		nsRight 191
		nsBottom 124
		sightAngle 30
		x 150
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104 ; chamPot
				(if (IsFlag 261)
					(gEgo setScript: placePotOnAltar)
				else
					(gMessager say: noun theVerb 3 0) ; "Gabriel doesn't have a reason to put the chamber pot on the altar at the moment."
				)
			)
			(106 ; salt
				(if (IsFlag 261)
					(gMessager say: noun theVerb 2 0) ; "Gabriel knows the salt is important, but it doesn't seem right to put it on the altar in the shaker."
				else
					(gMessager say: noun theVerb 3 0) ; "!!!This case is not possible"
				)
			)
			(8 ; Operate
				(if (== gDay 7)
					(cond
						(local0
							(gMessager say: noun theVerb 23 0) ; "Gabriel is already kneeling at the altar."
						)
						((IsFlag 261)
							(gEgo setScript: kneelAtAltar)
						)
						(else
							(gMessager say: noun theVerb 3 0) ; "Gabriel doesn't have a reason to kneel at the altar right now."
						)
					)
				else
					(gMessager say: noun theVerb 10 0) ; "(TO PLAYER. I.E. 'NO WAY!')I did that yesterday and look what happened!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftCandleabra of Feature
	(properties
		noun 6
		sightAngle 30
		x 93
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 66 100 66 101 80 96 81 96 109 94 114 90 112 92 108 92 82 87 81
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightCandleabra of Feature
	(properties
		noun 6
		sightAngle 30
		x 223
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 81 214 67 231 68 231 82 225 84 224 109 228 112 217 110 220 108 221 84
					yourself:
				)
		)
		(super init:)
	)
)

(instance washHandsPanel of Feature
	(properties
		noun 2
		nsTop 13
		nsRight 23
		nsBottom 97
		sightAngle 20
		x 9
		y 66
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
					)
					((IsFlag 261)
						(if (IsFlag 442)
							(gMessager say: noun theVerb 17 2) ; "The first panel shows hands and water."
						else
							(SetFlag 442)
							(gMessager say: noun theVerb 17 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
						)
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "Three panels hang from each side of the chapel. Gabriel can't determine what their purpose might be."
						(SetFlag 304)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cutHairPanel of Feature
	(properties
		noun 2
		nsLeft 27
		nsTop 13
		nsRight 51
		nsBottom 98
		sightAngle 20
		x 42
		y 68
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
					)
					((IsFlag 261)
						(if (IsFlag 442)
							(gMessager say: noun theVerb 18 2) ; "The second panel shows hair and a knife?"
						else
							(SetFlag 442)
							(gMessager say: noun theVerb 18 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
						)
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "Three panels hang from each side of the chapel. Gabriel can't determine what their purpose might be."
						(SetFlag 304)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getPotPanel of Feature
	(properties
		noun 2
		nsLeft 56
		nsTop 18
		nsRight 76
		nsBottom 100
		sightAngle 20
		x 67
		y 68
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
					)
					((IsFlag 261)
						(if (IsFlag 442)
							(gMessager say: noun theVerb 19 2) ; "The third panel shows a chalice on a table with ocean waves in the background."
						else
							(SetFlag 442)
							(gMessager say: noun theVerb 19 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
						)
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "Three panels hang from each side of the chapel. Gabriel can't determine what their purpose might be."
						(SetFlag 304)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bloodPanel of Feature
	(properties
		noun 2
		nsLeft 241
		nsTop 21
		nsRight 262
		nsBottom 102
		sightAngle 20
		x 250
		y 75
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
					)
					((IsFlag 261)
						(if (IsFlag 442)
							(gMessager say: noun theVerb 20 2) ; "The fourth panel shows a knife and a few drops of blood."
						else
							(SetFlag 442)
							(gMessager say: noun theVerb 20 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
						)
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "Three panels hang from each side of the chapel. Gabriel can't determine what their purpose might be."
						(SetFlag 304)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kneelPanel of Feature
	(properties
		noun 2
		nsLeft 265
		nsTop 27
		nsRight 289
		nsBottom 100
		sightAngle 20
		x 280
		y 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
					)
					((IsFlag 261)
						(if (IsFlag 442)
							(gMessager say: noun theVerb 21 2) ; "The fifth panel shows someone kneeling."
						else
							(SetFlag 442)
							(gMessager say: noun theVerb 21 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
						)
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "Three panels hang from each side of the chapel. Gabriel can't determine what their purpose might be."
						(SetFlag 304)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scrollPanel of Feature
	(properties
		noun 2
		nsLeft 294
		nsTop 21
		nsRight 319
		nsBottom 102
		sightAngle 20
		x 310
		y 72
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
					)
					((IsFlag 261)
						(if (IsFlag 442)
							(gMessager say: noun theVerb 22 2) ; "The sixth panel shows a scroll."
						else
							(SetFlag 442)
							(gMessager say: noun theVerb 22 0) ; "According to Gerde, the panels outline the Schattenj\84ger initiation ceremony."
						)
					)
					(else
						(gMessager say: noun theVerb 3 0) ; "Three panels hang from each side of the chapel. Gabriel can't determine what their purpose might be."
						(SetFlag 304)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftPews of Feature
	(properties
		noun 4
		sightAngle 30
		x 10
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 103 90 101 91 122 10 145 0 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightPews of Feature
	(properties
		noun 4
		sightAngle 30
		x 319
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 303 145 228 122 229 102 319 104 319 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance stainedGlass of Feature
	(properties
		noun 3
		sightAngle 30
		x 158
		y 28
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 40 130 30 139 22 181 22 187 29 192 38 192 107 125 107
					yourself:
				)
		)
		(super init:)
	)
)

(instance myExitFeature of Feature
	(properties
		nsLeft -1
		nsTop 140
		nsRight 321
		nsBottom 150
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: leaveTheRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ritualActions of Feature
	(properties
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(101 ; knife
				(if (IsFlag 261)
					(if (Germany egoCutHimself:)
						(gMessager say: noun theVerb 6 0) ; "(ADAMANT)I'm not going to cut myself again!"
						(return 1)
					else
						(if (Germany potOnAltar:)
							(gEgo setScript: cutEgo)
						else
							(gMessager say: noun theVerb 25 0) ; "That's not a bad idea, but Gabriel senses that he's missing a few necessary steps first."
						)
						(return 1)
					)
				else
					(gMessager say: noun theVerb 3 0) ; "Gabriel doesn't have a reason to use that dagger on himself at the moment."
					(return 1)
				)
			)
			(105 ; scroll
				(if (IsFlag 261)
					(if (== gDay 8)
						(gMessager say: noun theVerb 10 0) ; "(TO PLAYER. I.E. 'NO WAY!')I did that yesterday and look what happened!"
						(return 1)
					else
						(gEgo setScript: readTheScroll)
						(return 1)
					)
				else
					(gMessager say: noun theVerb 3 0) ; "(DRAMATIC. READING SCROLL)St. George, patron of the light, who hunts the shadows of the night...."
				)
			)
			(else
				(gEgo doVerb: theVerb)
			)
		)
	)
)

(instance myExitCursor of Cursor
	(properties
		view 964
	)
)

