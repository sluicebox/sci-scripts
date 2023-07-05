;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use Germany)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm520 0
)

(local
	local0 = 10
	local1 = 25
)

(instance rm520 of Room
	(properties
		noun 1
		picture 520
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 520)
		(Load rsVIEW 901)
		(Load rsVIEW 520)
		(Load rsVIEW 522)
		(Load rsVIEW 521)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 254 117 271 113 269 111 237 114 234 110 200 111 199 101 79 101 73 110 39 110 0 123 6 144 313 145
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 59 126 72 116 155 112 164 125 138 131 84 130
					yourself:
				)
		)
		(gGkMusic1
			number: 520
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(gEgo
			view: 901
			setCel: 0
			setLoop: 0
			setCycle: StopWalk -1
			signal: (| (gEgo signal:) $1000)
			init:
			state: 2
			ignoreActors: 1
			posn: 244 118
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			setScaler: Scaler 100 54 125 100
		)
		(gWalkHandler add: archWay)
		(leftBench init:)
		(rightBench init:)
		(candleabra init:)
		(archWay init:)
		(shield init:)
		(leftWindow init:)
		(rightWindow init:)
		(table init:)
		(tapestry init:)
		(puzzleBook5 init:)
		(puzzleBook4 init:)
		(puzzleBook3 init:)
		(puzzleBook2 init:)
		(puzzleBook1 init:)
		(books2 init:)
		(books3 init:)
		(books8 init:)
		(leftForegroundBooks init:)
		(rightForegroundBooks init:)
		(gEgo setScript: enterTheRoom)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(gWalkHandler delete: archWay)
		(DisposeScript 64935)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance enterTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 194 118 self)
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
				(gEgo setMotion: PolyPath 275 111 self)
			)
			(1
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance getPuzzleBook4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 97 104 self)
			)
			(1
				(gEgo view: 520 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gMessager say: 12 12 14 0 self) ; "Gabriel takes down "Sun Worshippers" and scans it."
				(gEgo view: 522 setCel: 0 setLoop: 0 setCycle: Osc 2 self)
			)
			(3
				(gGkSound1 number: 522 setLoop: 1 play:)
			)
			(4
				(gEgo
					view: 520
					setCel: 7
					setLoop: 1
					getPoints: 440 1
					setCycle: Beg self
				)
			)
			(5
				(Germany readPuzzleBook4: 1)
				(gEgo normalize: 3 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBook3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 145 104 self)
			)
			(1
				(gEgo view: 520 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gMessager say: 9 12 local0 0 self)
				(cond
					((== local0 10)
						(= local0 11)
					)
					((== local0 11)
						(= local0 28)
					)
					((== local0 28)
						(= local0 10)
					)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 3 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBook8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 38 116 self)
			)
			(1
				(gEgo view: 521 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(2
				(gMessager say: 17 12 local1 0 self)
				(cond
					((== local1 25)
						(= local1 26)
					)
					((== local1 26)
						(= local1 27)
					)
					((== local1 27)
						(= local1 25)
					)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 1 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPuzzleBook1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 145 104 self)
			)
			(1
				(gEgo view: 520 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(2
				(gMessager say: 13 12 20 0 self) ; "Gabriel pulls out the book entitled "People's Republic of Benin" and scans through it."
				(gEgo view: 522 setCel: 0 setLoop: 0 setCycle: Osc 2 self)
			)
			(3
				(gGkSound1 number: 522 setLoop: 1 play:)
			)
			(4
				(gEgo
					view: 520
					setCel: 7
					setLoop: 3
					getPoints: 437 1
					setCycle: Beg self
				)
			)
			(5
				(Germany readPuzzleBook1: 1)
				(gEgo normalize: 3 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPuzzleBook2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 187 104 self)
			)
			(1
				(gEgo view: 520 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gMessager say: 14 12 21 0 self) ; "Gabriel takes down "The Primal Ones" and opens it."
				(gEgo view: 522 setCel: 0 setLoop: 0 setCycle: Osc 2 self)
			)
			(3
				(gGkSound1 number: 522 setLoop: 1 play:)
			)
			(4
				(gEgo
					view: 520
					setCel: 7
					setLoop: 1
					getPoints: 438 1
					setCycle: Beg self
				)
			)
			(5
				(Germany readPuzzleBook2: 1)
				(gEgo normalize: 3 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPuzzleBook3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 38 116 self)
			)
			(1
				(gEgo view: 521 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(gMessager say: 16 12 22 0 self) ; "Gabriel removes "Ancient Roots of Africa" and browses through it."
			)
			(3
				(gEgo getPoints: 439 1 setCycle: Beg self)
			)
			(4
				(Germany readPuzzleBook3: 1)
				(gEgo normalize: 1 901)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPuzzleBook5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 187 104 self)
			)
			(1
				(Load rsVIEW 60)
				(gEgo view: 520 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(2
				(gMessager sayRange: 15 12 23 1 8 self) ; "(RRCC. RERECORD. WATCH WORDING)Gabriel takes "Ancient Digs of Africa" and opens it."
				(gEgo view: 522 setCel: 0 setLoop: 0 setCycle: Osc 2 self)
			)
			(3
				(gGkSound1 number: 522 setLoop: 1 play:)
			)
			(4
				(bookView init:)
				(gMessager say: 15 12 23 9 self) ; "(SEES THE DOUBLE RING FROM HIS DREAM IN A PICTURE--HORROR, DISBELIEF)Oh, my God! It's a wheel-within-a-wheel!"
				(gEgo getPoints: 441 1)
			)
			(5
				(gGkSound1 number: 522 setLoop: 1 play:)
				(bookView dispose:)
				(gMessager say: 15 12 23 10 self) ; "Gabriel decides to hang on to the snake mound book."
			)
			(6
				(Germany readPuzzleBook5: 1)
				(gEgo get: 67 normalize: 3 901) ; bookSnkMnd
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bookView of View
	(properties
		x 50
		y 199
		z 176
		view 60
	)
)

(instance leftBench of Feature
	(properties
		noun 5
		nsLeft 58
		nsTop 110
		nsRight 78
		nsBottom 124
		sightAngle 20
		x 70
		y 114
	)
)

(instance rightBench of Feature
	(properties
		noun 5
		nsLeft 132
		nsTop 110
		nsRight 153
		nsBottom 123
		sightAngle 20
		x 142
		y 113
	)
)

(instance candleabra of Feature
	(properties
		noun 8
		sightAngle 20
		x 118
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 102 118 95 115 93 115 83 122 78 129 82 129 94 124 96 125 102
					yourself:
				)
		)
		(super init:)
	)
)

(instance archWay of Feature
	(properties
		noun 2
		sightAngle 20
		x 249
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 29 278 33 291 95 280 128 244 111
					yourself:
				)
		)
		(super init:)
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

(instance shield of Feature
	(properties
		noun 6
		nsLeft 8
		nsTop 23
		nsRight 29
		nsBottom 54
		sightAngle 20
		x 19
		y 39
	)
)

(instance leftWindow of Feature
	(properties
		noun 7
		nsLeft 97
		nsTop 39
		nsRight 122
		nsBottom 61
		sightAngle 20
		x 109
		y 51
	)
)

(instance rightWindow of Feature
	(properties
		noun 7
		nsLeft 166
		nsTop 39
		nsRight 192
		nsBottom 63
		sightAngle 20
		x 179
		y 52
	)
)

(instance table of Feature
	(properties
		noun 4
		sightAngle 20
		x 108
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 98 129 98 135 105 132 127 128 127 124 106 93 108 88 127 83 127 80 106
					yourself:
				)
		)
		(super init:)
	)
)

(instance tapestry of Feature
	(properties
		noun 3
		sightAngle 20
		x 292
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 21 304 21 305 75 287 76 287 87 275 87
					yourself:
				)
		)
		(super init:)
	)
)

(instance books2 of Feature
	(properties
		noun 11
		nsLeft 86
		nsTop 87
		nsRight 123
		nsBottom 99
		sightAngle 30
		approachX 101
		approachY 107
		x 104
		y 93
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)
)

(instance books3 of Feature
	(properties
		noun 9
		nsLeft 126
		nsTop 69
		nsRight 162
		nsBottom 82
		sightAngle 30
		approachX 145
		approachY 104
		x 143
		y 76
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 9 0) ; "This part of the library contains books on the occult."
			)
			(12 ; Pickup
				(gEgo setScript: getBook3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance books8 of Feature
	(properties
		noun 17
		nsTop 85
		nsRight 36
		nsBottom 110
		sightAngle 30
		approachX 38
		approachY 116
		x 18
		y 97
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 29 0) ; "These shelves contain books and documents about the Ritter family."
			)
			(12 ; Pickup
				(gEgo setScript: getBook8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puzzleBook1 of Feature
	(properties
		noun 13
		nsLeft 126
		nsTop 81
		nsRight 162
		nsBottom 98
		sightAngle 30
		approachX 145
		approachY 104
		x 143
		y 88
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(Germany lookPuzzleBook1: 1)
				(gMessager say: noun theVerb 13 0) ; "These shelves display books on Geography."
			)
			(12 ; Pickup
				(if (Germany lookPuzzleBook1:)
					(gEgo setScript: getPuzzleBook1)
				else
					(gMessager say: noun theVerb 16 0) ; "Gabriel's not sure where to start with these books."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puzzleBook2 of Feature
	(properties
		noun 14
		nsLeft 164
		nsTop 70
		nsRight 212
		nsBottom 87
		sightAngle 30
		approachX 187
		approachY 104
		x 182
		y 79
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (Germany readPuzzleBook1:)
					(gMessager say: noun theVerb 8 0) ; "There are books on Sociology in this part of the library."
					(Germany lookPuzzleBook2: 1)
				else
					(gMessager say: noun theVerb 7 0) ; "There are books on Sociology in this part of the library."
				)
			)
			(12 ; Pickup
				(if (Germany lookPuzzleBook2:)
					(gEgo setScript: getPuzzleBook2)
				else
					(gMessager say: noun theVerb 17 0) ; "Gabriel wouldn't know where to begin with the Sociology books."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puzzleBook3 of Feature
	(properties
		noun 16
		nsTop 62
		nsRight 36
		nsBottom 81
		sightAngle 30
		approachX 38
		approachY 116
		x 19
		y 71
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (Germany readPuzzleBook2:)
					(gMessager say: noun theVerb 3 0) ; "These shelves contain History books."
					(Germany lookPuzzleBook3: 1)
				else
					(gMessager say: noun theVerb 4 0) ; "These shelves contain History books."
				)
			)
			(12 ; Pickup
				(if (Germany lookPuzzleBook3:)
					(gEgo setScript: getPuzzleBook3)
				else
					(gMessager say: noun theVerb 18 0) ; "Gabriel wouldn't know which History book to read."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puzzleBook4 of Feature
	(properties
		noun 12
		nsLeft 86
		nsTop 69
		nsRight 123
		nsBottom 87
		sightAngle 30
		approachX 101
		approachY 107
		x 104
		y 81
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (Germany readPuzzleBook3:)
					(gMessager say: noun theVerb 2 0) ; "These shelves contain books on religions of all kinds."
					(Germany lookPuzzleBook4: 1)
				else
					(gMessager say: noun theVerb 1 0) ; "These shelves contain books on religions of all kinds."
				)
			)
			(12 ; Pickup
				(if (Germany lookPuzzleBook4:)
					(gEgo setScript: getPuzzleBook4)
				else
					(gMessager say: noun theVerb 15 0) ; "Gabriel wouldn't know where to begin with the religion books."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puzzleBook5 of Feature
	(properties
		noun 15
		nsLeft 165
		nsTop 86
		nsRight 212
		nsBottom 98
		sightAngle 30
		approachX 187
		approachY 104
		x 185
		y 91
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((gEgo has: 67) ; bookSnkMnd
						(gMessager say: noun theVerb 24 0) ; "Gabriel doesn't see any other books of interest in the Archaeology section."
					)
					((Germany readPuzzleBook4:)
						(gMessager say: noun theVerb 5 0) ; "These shelves contain books on Archaeology."
						(Germany lookPuzzleBook5: 1)
					)
					(else
						(gMessager say: noun theVerb 6 0) ; "These shelves contain books on Archaeology."
					)
				)
			)
			(12 ; Pickup
				(cond
					((Germany readPuzzleBook5:)
						(gMessager say: noun theVerb 24 0) ; "Gabriel doesn't see any other books of interest in the Archaeology section."
					)
					((and (not (gEgo has: 67)) (Germany lookPuzzleBook5:)) ; bookSnkMnd
						(gEgo setScript: getPuzzleBook5)
					)
					(else
						(gMessager say: noun theVerb 19 0) ; "Gabriel wouldn't know where to start reading the Archaeology books."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftForegroundBooks of Feature
	(properties
		noun 10
		sightAngle 30
		x 17
		y 134
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 145 0 112 25 114 27 125 51 128 51 145
					yourself:
				)
		)
	)
)

(instance rightForegroundBooks of Feature
	(properties
		noun 10
		sightAngle 30
		x 296
		y 137
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 146 147 136 247 127 249 121 284 118 285 109 308 108 319 111 319 146
					yourself:
				)
		)
	)
)

