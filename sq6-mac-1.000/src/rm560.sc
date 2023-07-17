;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm560 0
)

(instance rm560 of SQRoom
	(properties
		noun 1
		picture 560
	)

	(method (init)
		(super init: &rest)
		(gEgo
			init:
			normalize:
			setScaler: Scaler 100 63 126 95
			ignoreActors: 1
		)
		(switch gPrevRoomNum
			(570
				(gEgo setScript: enterFromTrailer)
			)
			(else
				(gEgo setScript: enterFromFog)
			)
		)
		(Load 140 563) ; WAVE
		(dustDevil init: hide: ignoreActors: 1 setScript: stormin)
		(sawhorseLeft init: setCycle: Fwd)
		(sawhorseRight init: setCycle: Fwd)
		(door init: approachVerbs: 4) ; Do
		(pottieDoor init: approachVerbs: 4) ; Do
		(rag init:)
		(if (not (gEgo has: 95)) ; Screwdriver
			(screwdriver init: approachVerbs: 4) ; Do
		)
		(if (and (not (gEgo has: 10)) (not (IsFlag 150))) ; Board
			(plank init: approachVerbs: 4) ; Do
		)
		(highSign init:)
		(sky init:)
		(trailerSign init:)
		(trailer init:)
		(infohigh init:)
		(weeds1 init:)
		(weeds2 init:)
		(weeds3 init:)
		(weeds4 init:)
		(weeds5 init:)
		(trailerWnd init:)
		(bucket init:)
		(portaPot init:)
		(girders init:)
		(sawhorse1 init:)
		(sawhorse2 init:)
		(skyscraper init:)
		(truck init:)
		(tractor init:)
		(if (gCast contains: plank)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: -10 138 319 138 315 129 306 129 302 133 277 135 257 128 263 120 260 119 245 119 231 121 217 117 218 110 211 106 205 105 200 99 176 102 166 99 157 91 115 91 107 84 101 84 103 104 -10 102
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: -10 138 319 138 315 129 306 129 302 133 277 135 257 128 263 120 260 119 245 119 231 121 217 117 218 110 211 106 205 105 200 99 170 97 157 91 115 91 107 84 101 84 103 104 -10 102
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 79 130 87 120 108 118 135 123 138 136 80 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 236 135 225 131 227 125 233 121 246 123 251 127 250 132
					yourself:
				)
		)
		(exit550 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(exit570 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(gGSound1 number: 560 loop: -1 play: setVol: 127)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(super dispose: &rest)
	)
)

(instance stormin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (RandomNumber 12 28))
			)
			(1
				(if (gTalkers isEmpty:)
					(gGSound2 number: 563 loop: 0 play: setVol: 127)
				)
				(client cel: 0 show: setCycle: End self)
			)
			(2
				(gGSound2 fade: 0 5 5 1)
				(client hide:)
				(= cycles 2)
			)
			(3
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance leaveByTrailer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 564) ; WAVE
				(gEgo
					view: 564
					loop: 0
					cel: 0
					posn: 234 94
					setScaler: Scaler 94 94 126 95
					setPri: 118
					setCycle: End self
				)
			)
			(1
				(gGSound2 number: 564 loop: 0 play: setVol: 127)
				(door setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 570)
				(self dispose:)
			)
		)
	)
)

(instance enterFromTrailer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 565) ; WAVE
				(gEgo
					view: 564
					loop: 1
					cel: 0
					posn: 222 114
					setScaler: Scaler 94 94 126 95
					setPri: 118
					setCycle: End self
				)
				(door cel: (door lastCel:))
			)
			(1
				(door setCycle: CT 1 -1 self)
			)
			(2
				(gGSound2 number: 565 loop: 0 play: setVol: 127)
				(door setCycle: Beg)
				(gEgo
					normalize: 5
					setScaler: Scaler 100 63 126 95
					ignoreActors: 1
					setPri: 118
					setMotion: MoveTo 218 118 self
				)
			)
			(3
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromFog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: -10 117 setMotion: MoveTo 35 117 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveForFog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -10 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsRag of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 6 self)
			)
			(1
				(gEgo view: 562 loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(rag hide: dispose:)
				(gEgo get: 90 setCycle: End self) ; Rag
			)
			(3
				(gEgo normalize: 6 ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsScrewdriver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 562 loop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(screwdriver hide: dispose:)
				(gEgo get: 95 setCycle: End self) ; Screwdriver
			)
			(3
				(gEgo normalize: 0 ignoreActors: 1)
				(gGame points: 1 494)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsPlank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 21 4 0 1 self) ; "Bet you can't fit that thing in your pants."
			)
			(1
				(gEgo
					view: 565
					loop: 0
					cel: 0
					setScale:
					scaleX: 157
					scaleY: 157
					setCycle: End self
				)
				(plank hide: dispose:)
			)
			(2
				(gMessager say: 21 4 0 2 self) ; "Guess I was wrong. It does fit. There must be plenty of spare room in there."
			)
			(3
				(gEgo
					get: 10 ; Board
					setScaler: Scaler 100 63 126 95
					normalize: 0
					ignoreActors: 1
				)
				(gGame points: 1 495)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openSesame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 562 561) ; WAVE
				(gGSound2 number: 561 loop: 0 play: setVol: 127)
				(client setCycle: End self)
			)
			(1
				(gMessager say: 10 4 1 0 self) ; "Oh, Momma! I'm guessing one too many burritos for the last guy in here!"
			)
			(2
				(client setCycle: CT 1 -1 self)
			)
			(3
				(gGSound2 number: 562 loop: 0 play: setVol: 127)
				(client setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dustDevil of Prop
	(properties
		noun 20
		x 92
		y 109
		view 560
		loop 2
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance sawhorseLeft of Prop
	(properties
		noun 3
		sightAngle 40
		x 106
		y 109
		priority 135
		fixPriority 1
		view 560
		cycleSpeed 22
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance sawhorseRight of Prop
	(properties
		noun 3
		sightAngle 40
		x 275
		y 81
		priority 130
		fixPriority 1
		view 560
		loop 1
		cycleSpeed 18
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		noun 7
		sightAngle 40
		approachX 218
		approachY 118
		x 242
		y 94
		priority 108
		fixPriority 1
		view 561
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: leaveByTrailer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pottieDoor of Prop
	(properties
		noun 10
		sightAngle 40
		approachX 200
		approachY 113
		x 214
		y 102
		view 563
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: openSesame)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rag of View
	(properties
		noun 16
		sightAngle 40
		approachX 96
		approachY 137
		x 117
		y 158
		z 50
		priority 135
		fixPriority 1
		view 562
	)
)

(instance screwdriver of View
	(properties
		noun 18
		sightAngle 40
		approachX 16
		approachY 107
		x 43
		y 158
		z 50
		priority 108
		fixPriority 1
		view 562
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: egoGetsScrewdriver)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plank of View
	(properties
		noun 21
		sightAngle 40
		approachX 165
		approachY 99
		x 182
		y 99
		view 560
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: egoGetsPlank)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance highSign of Feature
	(properties
		noun 12
		sightAngle 40
		x 52
		y 62
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 8 39 97 39 96 85 7 85 yourself:)
		)
		(super init: &rest)
	)
)

(instance sky of Feature
	(properties
		noun 2
		sightAngle 40
		x 232
		y 32
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 0 170 57 173 57 178 57 180 57 193 57 195 65 213 65 213 42 231 41 231 36 234 36 234 18 240 17 239 12 260 5 260 10 294 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trailerSign of Feature
	(properties
		noun 13
		sightAngle 40
		x 250
		y 75
		z 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 13 260 6 260 20 240 25
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance infohigh of Feature
	(properties
		noun 4
		sightAngle 40
		x 40
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 103 80 104 80 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance weeds1 of Feature
	(properties
		noun 5
		sightAngle 40
		x 37
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 90 74 91 74 103 0 102 yourself:)
		)
		(super init: &rest)
	)
)

(instance weeds2 of Feature
	(properties
		noun 5
		sightAngle 40
		x 66
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 53 128 79 128 79 138 53 137
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance weeds3 of Feature
	(properties
		noun 5
		sightAngle 40
		x 277
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 235 119 245 113 263 112 304 121 320 122 320 138 277 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance weeds4 of Feature
	(properties
		noun 5
		sightAngle 40
		x 191
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 95 179 89 185 91 189 95 191 90 194 89 203 89 207 93 207 100 195 101 192 108 185 105 187 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance weeds5 of Feature
	(properties
		noun 5
		sightAngle 40
		x 172
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 138 149 133 165 130 172 135 179 128 179 122 164 119 176 114 187 116 185 122 180 123 180 132 190 127 196 127 200 133 190 134 183 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trailerWnd of Feature
	(properties
		noun 8
		sightAngle 40
		x 276
		y 39
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 28 289 22 289 57 263 57
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bucket of Feature
	(properties
		noun 6
		sightAngle 40
		x 230
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 133 220 129 227 129 232 121 247 123 247 130 240 132 242 134 231 138 219 135 214 133
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance portaPot of Feature
	(properties
		noun 10
		sightAngle 40
		x 224
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 104 213 44 217 41 222 42 235 42 235 95 234 96 233 101 228 102 225 107 224 108
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance girders of Feature
	(properties
		noun 11
		sightAngle 40
		x 186
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 65 212 65 212 80 207 80 206 92 171 92 163 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sawhorse1 of Feature
	(properties
		noun 3
		sightAngle 40
		x 110
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 129 101 99 100 98 100 95 102 94 101 90 102 85 106 84 110 88 108 94 109 99 120 101 130 132 124 131 124 125 116 124 117 129 111 129 108 135 105 135 102 135 104 128 95 125 92 131
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sawhorse2 of Feature
	(properties
		noun 3
		sightAngle 40
		x 286
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 128 275 97 277 97 277 95 280 94 277 90 280 85 300 83 300 92 300 97 309 100 300 128 276 133
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trailer of Feature
	(properties
		noun 7
		sightAngle 40
		x 270
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 235 19 297 0 320 0 320 116 258 110 258 117 231 118 221 115 221 109 236 96
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance skyscraper of Feature
	(properties
		noun 9
		sightAngle 40
		x 84
		y 28
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 169 0 169 57 0 57 yourself:)
		)
		(super init: &rest)
	)
)

(instance truck of Feature
	(properties
		noun 14
		sightAngle 40
		x 81
		y 43
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 13 22 0 67 0 38 25 48 25 52 28 52 23 53 21 53 14 60 14 60 20 66 20 70 23 70 20 77 11 102 5 141 9 145 22 162 22 148 33 143 33 116 50 111 52 111 55 139 55 139 50 144 50 145 35 154 30 154 50 160 50 160 57 160 81 108 80 105 75 97 74 0 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tractor of Feature
	(properties
		noun 15
		sightAngle 40
		x 161
		y 62
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 85 115 81 117 77 119 72 121 67 122 63 129 62 133 64 134 70 140 75 140 63 144 59 148 57 173 57 173 39 177 40 177 57 179 57 188 44 200 41 201 37 207 36 208 42 212 42 212 47 199 47 195 54 198 56 200 61 204 63 205 64 210 64 161 64 161 89 116 89
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit550 of ExitFeature
	(properties
		noun 4
		nsTop 83
		nsRight 10
		nsBottom 138
		y 138
		z 138
		nextRoom 550
		message 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(message
				(gEgo setScript: leaveForFog)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit570 of ExitFeature
	(properties
		approachX 218
		approachY 118
		x 239
		y 69
		nextRoom 570
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 241 26 258 21 257 116 231 118 221 115 221 108 228 108 228 103 234 102 234 96 241 95
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(gEgo setScript: leaveByTrailer)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

