;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use SQRoom)
(use n666)
(use Styler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	[local0 2]
	local2
	local3
)

(instance rm390 of SQRoom
	(properties
		noun 1
		picture 390
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 89 0 139 84 138 127 125 164 126 198 134 201 138 256 137 291 118 274 112 256 117 241 111 226 114 216 109 214 101 180 89 241 70 219 64 207 67 182 56 151 62 127 53 160 46 137 38 88 45 118 68 103 79 84 74 67 77 75 93 39 98 28 82 23 80 0 85
					yourself:
				)
		)
		(super init:)
		(Load 140 922) ; WAVE
		(Load rsVIEW 900)
		(switch gPrevRoomNum
			(460
				(gCurRoom setScript: sEgoGoes)
			)
			(else
				(gCurRoom setScript: sEgoComes)
			)
		)
		(gGSound1 number: 390 loop: -1 play:)
		(if
			(or
				(and (IsFlag 41) (not (IsFlag 118)))
				(and (IsFlag 424) (not (IsFlag 116)))
				(and (IsFlag 116) (IsFlag 117) (== gAct 1))
			)
			(LED init: approachVerbs: 4 setCycle: RandCycle) ; Do
		)
		(if (and (IsFlag 424) (not (IsFlag 116)))
			(SetFlag 189)
		)
		(floorF init:)
		(closet init:)
		(armyKnife init:)
		(autoBuckCard init:)
		(bed init:)
		(blinds init:)
		(chair1 init:)
		(chair2 init:)
		(book init:)
		(boots init:)
		(buckazoid init:)
		(cigarButt init:)
		(clothes init:)
		(dresser init:)
		(gadget init:)
		(headBoard init:)
		(heater init:)
		(hintBook init:)
		(greenLamp init:)
		(kitchen init:)
		(matches init:)
		(mop init:)
		(pants init:)
		(wallPicture init:)
		(pillows init:)
		(plant init:)
		(pocketPal init:)
		(poster init:)
		(remote init:)
		(sierraLetter init:)
		(rocket init:)
		(socks init:)
		(table init:)
		(trashCan init:)
		(whistle init:)
		(outletL init:)
		(closetControl init:)
		(plant2 init:)
		(comPostPad init:)
		(comPost init: approachVerbs: 4) ; Do
		(outletR init: approachVerbs: 4) ; Do
		(replicatorFeature init: approachVerbs: 4) ; Do
		(mirror init: approachVerbs: 1) ; Look
		(PalCycle 0 216 221 1 15) ; Start
		(PalCycle 0 222 228 1 25) ; Start
	)

	(method (doit)
		(super doit:)
		(cond
			((< (= local2 (gEgo distanceTo: greenLamp)) 50)
				(PalVary 0 390 0 (- 100 (* local2 2))) ; PalVaryStart
			)
			((and (< 55 (gEgo y:) 65) (< (gEgo x:) 160))
				(= local3 1)
				(Palette 2 72 79 (- 100 (* (- (gEgo y:) 65) 5))) ; PalIntensity
			)
			((and (>= (gEgo y:) 65) local3)
				(= local3 0)
				(Palette 2 72 79 100) ; PalIntensity
			)
		)
	)

	(method (cue)
		(PalCycle 0 216 221 1 15) ; Start
		(PalCycle 0 222 228 1 25) ; Start
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 460)
			(gGSound1 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(PalCycle 4) ; Off
		(super dispose:)
	)
)

(instance sEgoComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gGSound2 number: 941 loop: 1 play:)
				(gEgo
					view: 364
					setCel: 0
					setLoop: 0
					init:
					posn: 82 82
					setSpeed: 9
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: setLoop: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoGoes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: setLoop: 3 init:)
				(= cycles 1)
			)
			(1
				(if (or (== gComPostNextRoomNum gCurRoomNum) (== gComPostNextRoomNum 0))
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setHeading: 180)
					(= seconds 2)
				)
			)
			(2
				(gGSound2 number: 926 loop: 1 play:)
				(gEgo
					view: 3630
					setCel: 0
					setLoop: 0
					setSpeed: 9
					posn: 82 82
					setCycle: End self
				)
			)
			(3
				(gGame handsOff:)
				(gCurRoom newRoom: gComPostNextRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance sEgoBends of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 396
					setCel: 0
					setLoop: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(client setScript: sEgoGetsFried)
			)
		)
	)
)

(instance sEgoGetsFried of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= scratch 10)
				(sound1 number: 922 loop: -1 play:)
				(gEgo view: 396 setCel: 0 setLoop: 1 setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(Palette 2 70 255 (Random 0 100)) ; PalIntensity
				(ShakePlane gThePlane 2 1)
				(-- scratch)
				(if scratch
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(sound1 stop:)
				(= cycles 1)
			)
			(3
				(Palette 2 70 255 100) ; PalIntensity
				(gEgo setCel: 0 setLoop: 2 cycleSpeed: 12 setCycle: End self)
			)
			(4
				(= ticks 180)
			)
			(5
				(EgoDead 26 self) ; "You pick strange methods of getting a charge out of life."
			)
			(6
				(gEgo normalize: cycleSpeed: 6 setLoop: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance LED of Prop
	(properties
		noun 30
		sightAngle 40
		approachX 82
		approachY 82
		x 64
		y 40
		z 8
		view 392
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(1 ; Look
				(gMessager say: 30 1 8) ; "Looks like you have a message waiting for you. Hmm ..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closet of Feature
	(properties
		noun 29
		sightAngle 20
		x 1
		y 53
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 4 25 24 26 79 0 84 yourself:)
		)
		(super init:)
	)
)

(instance floorF of Feature
	(properties
		noun 47
		sightAngle 360
		x 1
		y 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 87 1 137 69 137 74 125 88 120 85 104 104 98 110 112 123 110 162 110 176 114 181 100 186 100 201 103 201 110 199 111 198 120 211 125 217 137 319 136 319 90 261 112 189 89 198 68 225 60 222 59 210 62 182 53 156 58 146 55 142 53 143 42 147 38 139 35 109 40 110 66 104 68 103 71 93 74 87 72 64 76 62 86 48 90 40 83 40 80 32 82 26 79
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom doVerb: theVerb &rest)
			)
			(4 ; Do
				(gMessager say: noun theVerb) ; "Ah, there's nothing like the feel of a solid third-class crew deck under your feet!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance armyKnife of Feature
	(properties
		noun 3
		sightAngle 20
		x 230
		y 40
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 39 227 39 226 41 229 42
					yourself:
				)
		)
		(super init:)
	)
)

(instance autoBuckCard of Feature
	(properties
		noun 9
		sightAngle 20
		x 118
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 119 117 120 123 118 120 117
					yourself:
				)
		)
		(super init:)
	)
)

(instance bed of Feature
	(properties
		noun 17
		sightAngle 20
		x 264
		y 65
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 42 256 47 253 50 242 55 238 55 232 59 224 60 211 66 209 65 198 70 191 87 200 93 209 92 215 97 225 98 240 102 247 107 253 108 260 112 276 103 319 84 319 51 296 50 270 43
					yourself:
				)
		)
		(super init:)
	)
)

(instance blinds of Feature
	(properties
		noun 19
		sightAngle 20
		x 259
		y 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 234 19 240 4 244 0 272 0 282 18 283 26 269 23 261 27 234 20
					yourself:
				)
		)
		(super init:)
	)
)

(instance chair1 of Feature
	(properties
		noun 14
		sightAngle 20
		x 99
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 119 86 103 103 99 106 102 107 105 110 114 93 119
					yourself:
				)
		)
		(super init:)
	)
)

(instance chair2 of Feature
	(properties
		noun 14
		sightAngle 20
		x 177
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 114 180 107 178 105 182 100 186 100 202 105 199 110 197 111 197 121
					yourself:
				)
		)
		(super init:)
	)
)

(instance book of Feature
	(properties
		noun 16
		sightAngle 20
		x 291
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 289 106 285 108 291 112 299 110
					yourself:
				)
		)
		(super init:)
	)
)

(instance boots of Feature
	(properties
		noun 25
		sightAngle 20
		x 231
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 96 227 103 225 106 232 111 242 108 239 104 233 102 233 95 226 94
					yourself:
				)
		)
		(super init:)
	)
)

(instance buckazoid of Feature
	(properties
		noun 2
		sightAngle 20
		x 194
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 125 193 125 195 128 197 125
					yourself:
				)
		)
		(super init:)
	)
)

(instance cigarButt of Feature
	(properties
		noun 7
		sightAngle 20
		x 183
		y 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 122 178 124 179 125 187 124
					yourself:
				)
		)
		(super init:)
	)
)

(instance clothes of Feature
	(properties
		noun 26
		sightAngle 20
		x 300
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 263 138 271 135 262 132 274 128 279 131 293 122 302 117 319 119 319 139
					yourself:
				)
		)
		(super init:)
	)
)

(instance comPost of Feature
	(properties
		noun 30
		sightAngle 20
		approachX 82
		approachY 82
		x 72
		y 38
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 66 35 65 42 77 40 77 33 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dresser of Feature
	(properties
		noun 34
		sightAngle 20
		x 203
		y 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb 0) ; "This poor dresser hasn't worked right since they hauled it onboard."
		else
			(gDoVerbCode doit: theVerb)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 188 30 184 52 209 62 223 58 223 40 234 37 233 32 205 25
					yourself:
				)
		)
		(super init:)
	)
)

(instance gadget of Feature
	(properties
		noun 11
		sightAngle 20
		x 133
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 114 129 117 139 118 138 113
					yourself:
				)
		)
		(super init:)
	)
)

(instance headBoard of Feature
	(properties
		noun 23
		sightAngle 20
		x 294
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 23 261 28 264 33 264 42 296 50 319 52 319 36
					yourself:
				)
		)
		(super init:)
	)
)

(instance heater of Feature
	(properties
		noun 28
		sightAngle 20
		x 98
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 91 41 89 73 96 76 107 74 102 70 103 42 97 40
					yourself:
				)
		)
		(super init:)
	)
)

(instance hintBook of Feature
	(properties
		noun 8
		sightAngle 20
		x 112
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 122 112 127 119 125 113 119
					yourself:
				)
		)
		(super init:)
	)
)

(instance kitchen of Feature
	(properties
		noun 36
		sightAngle 20
		x 126
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 108 15 137 12 155 16 149 24 150 56 108 62
					yourself:
				)
		)
		(super init:)
	)
)

(instance greenLamp of Feature
	(properties
		noun 13
		sightAngle 20
		x 242
		y 65
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 19 252 20 254 25 250 29 247 31 241 28 241 22 244 19
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (< (= local2 (gEgo distanceTo: self)) 70)
					(gMessager say: noun theVerb 3 0) ; "Kryptonite lamp ... sapping power ... must ... replace ... bulb ... someday!"
				else
					(gMessager say: noun theVerb 1 0) ; "This lovely kryptonite mood lamp casts a cool glow over the room."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance matches of Feature
	(properties
		noun 10
		sightAngle 20
		x 189
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 125 187 127 191 126 189 124
					yourself:
				)
		)
		(super init:)
	)
)

(instance mirror of Feature
	(properties
		noun 24
		sightAngle 20
		approachX 180
		approachY 60
		x 215
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 0 208 15 211 20 217 22 223 19 223 0
					yourself:
				)
		)
		(super init:)
	)
)

(instance mop of Feature
	(properties
		noun 20
		sightAngle 20
		x 174
		y 28
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 0 172 27 175 38 178 33 177 24
					yourself:
				)
		)
		(super init:)
	)
)

(instance pants of Feature
	(properties
		noun 37
		sightAngle 20
		x 245
		y 77
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 71 224 77 222 81 228 84 229 79 246 75 235 81 234 89 240 90 242 82 262 77
					yourself:
				)
		)
		(super init:)
	)
)

(instance wallPicture of Feature
	(properties
		noun 22
		sightAngle 20
		x 315
		y 22
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 304 0 306 21 319 24 319 0
					yourself:
				)
		)
		(super init:)
	)
)

(instance pillows of Feature
	(properties
		noun 18
		sightAngle 20
		x 287
		y 52
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 41 252 50 282 59 315 65 319 62 319 51 292 50
					yourself:
				)
		)
		(super init:)
	)
)

(instance plant of Feature
	(properties
		noun 27
		sightAngle 20
		x 51
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 72 48 70 62 72 64 80 68 85 57 89 58 90 41 94 44 87 40 85 34 83 41 81
					yourself:
				)
		)
		(super init:)
	)
)

(instance pocketPal of Feature
	(properties
		noun 6
		sightAngle 20
		x 166
		y 117
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 164 112 158 115 155 115 152 117 153 121 170 126 183 118
					yourself:
				)
		)
		(super init:)
	)
)

(instance poster of Feature
	(properties
		noun 21
		sightAngle 20
		x 68
		y 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 53 0 55 20 81 16 83 0 yourself:)
		)
		(super init:)
	)
)

(instance remote of Feature
	(properties
		noun 12
		sightAngle 20
		x 148
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 121 144 128 144 130 147 130 154 125
					yourself:
				)
		)
		(super init:)
	)
)

(instance sierraLetter of Feature
	(properties
		noun 5
		sightAngle 20
		x 191
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 129 187 132 184 132 185 136 200 136 198 131 200 131 194 127
					yourself:
				)
		)
		(super init:)
	)
)

(instance replicatorFeature of Feature
	(properties
		noun 31
		sightAngle 20
		approachX 145
		approachY 41
		x 156
		y 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 0 144 7 139 12 156 17 166 4 165 0
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(PalCycle 4) ; Off
				(gCurRoom setInset: (ScriptID 800 0) gCurRoom 0 1) ; foodReplicatorInset
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rocket of Feature
	(properties
		noun 32
		sightAngle 20
		x 195
		y 23
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 10 194 16 195 30 198 29 199 15
					yourself:
				)
		)
		(super init:)
	)
)

(instance socks of Feature
	(properties
		noun 38
		sightAngle 20
		x 221
		y 103
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 224 97 213 98 221 102 211 105 214 107 225 104
					yourself:
				)
		)
		(super init:)
	)
)

(instance table of Feature
	(properties
		noun 15
		sightAngle 20
		x 143
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 139 76 125 122 111 161 112 209 125 215 138
					yourself:
				)
		)
		(super init:)
	)
)

(instance trashCan of Feature
	(properties
		noun 35
		sightAngle 20
		x 146
		y 49
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 43 143 53 148 55 148 42 143 42
					yourself:
				)
		)
		(super init:)
	)
)

(instance whistle of Feature
	(properties
		noun 4
		sightAngle 20
		x 117
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 133 113 135 112 135 119 135
					yourself:
				)
		)
		(super init:)
	)
)

(instance outletR of Feature
	(properties
		noun 42
		sightAngle 40
		approachX 153
		approachY 64
		x 175
		y 40
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 40 173 50 177 50 178 39
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sEgoBends)
				(return 1)
			)
			(1 ; Look
				(gMessager say: noun theVerb 5 0) ; "It's a four-socket recursive-current subspace-grounded socket, devoid of any cords, plugs, or pins!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance outletL of Feature
	(properties
		noun 43
		sightAngle 40
		x 83
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 82 55 83 68 86 67 86 54 yourself:)
		)
		(super init:)
	)
)

(instance closetControl of Feature
	(properties
		noun 41
		sightAngle 40
		x 38
		y 40
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 35 42 35 50 42 49 42 40 yourself:)
		)
		(super init:)
	)
)

(instance plant2 of Feature
	(properties
		noun 44
		sightAngle 40
		x 6
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 97 7 105 5 112 14 116 16 121 21 123 23 135 16 124 13 133 14 139 0 139
					yourself:
				)
		)
		(super init:)
	)
)

(instance comPostPad of Feature
	(properties
		noun 40
		sightAngle 40
		x 80
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 76 84 75 92 80 88 85 78 86 70 84 68 80
					yourself:
				)
		)
		(super init:)
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

