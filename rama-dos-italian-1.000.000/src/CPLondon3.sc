;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2062)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use cplainRegion)
(use n1111)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	CPLondon3 0
)

(procedure (localproc_0 &tmp temp0)
	(= temp0
		(+
			(= temp0 (if (IsFlag 117) 4 else 0))
			(cond
				((not (== (proc70_9 48) gCurRoomNum)) 0)
				((not (IsFlag 101)) 1)
				((== (proc70_9 61) gCurRoomNum) 2)
				(else 3)
			)
		)
	)
	(switchState cel: temp0)
	(if (not argc)
		(UpdateScreenItem switchState)
	)
)

(instance CPLondon3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(3001 ; london_1
				(self addPicObj: faceW faceN faceNE faceS faceW)
			)
			(2061 ; CPLondon2
				(SetFlag 118)
				(self addPicObj: faceN faceNE faceS faceW faceN)
			)
			(2063
				(self addPicObj: faceW faceN faceNE faceS faceW)
			)
			(2064 ; CPLondon5
				(self addPicObj: faceS faceW faceN faceNE faceS)
			)
			(else
				(self addPicObj: faceN faceNE faceS faceW faceN)
			)
		)
		((ScriptID 200 0) addMigrant: 12 78 88) ; cplainRegion
	)

	(method (doVerb theVerb)
		(switch theVerb
			(137
				(if (global117 contains: rayBeam)
					(rayBeam show:)
				)
				(global122 doVerb: theVerb)
			)
			(138
				(if (global117 contains: rayBeam)
					(rayBeam hide:)
				)
				(global122 doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(SetFlag 101)
				(localproc_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lectroSound of Sound
	(properties
		number 2061
		flags 1
	)
)

(instance steppedIntoTheBarrier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom doVerb: 137)
				(UpdateScreenItem rayBeam)
				(FrameOut)
				(Load rsPIC 2304)
				(Load rsPIC 61)
				(= ticks 1)
			)
			(1
				(gCurRoom drawPic: 2304)
				(rayBeam dispose:)
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 30)
			)
			(2
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(= ticks 15)
			)
			(3
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 15)
			)
			(4
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(= ticks 15)
			)
			(5
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 30)
			)
			(6
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(= ticks 15)
			)
			(7
				(lectroSound play:)
				(PalVary 0 -1 0 100 0 192) ; PalVaryStart
				(= ticks 30)
			)
			(8
				(lectroSound stop:)
				(PalVary 1 0 0) ; PalVaryReverse
				(gCurRoom drawPic: 61)
				(= cycles 1)
			)
			(9
				(gCurRoom newRoom: 95) ; morgue
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2305
		edgeS 0
		edgeN 0
	)

	(method (init)
		(fiveExit_0 init:)
		(super init: &rest)
		(london_0 init:)
		(spikes_0 init:)
		(sea_0 init:)
		(lights_0 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 2306
		edgeS 0
		edgeN 0
	)

	(method (init)
		(london1Exit_45 init:)
		(super init: &rest)
		(london_45 init:)
		(door_45 init:)
		(sea_45 init:)
		(spikes_45 init:)
		(lights_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2307
		edgeS 0
		edgeN 0
	)

	(method (init)
		(twoExit_180 init:)
		(super init: &rest)
		(rayBeam init: global117)
		(hubSite_180 init:)
		(barrier_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2308
		edgeS 0
		edgeN 0
	)

	(method (init)
		(= showBlack 1)
		(super init: &rest)
		(matrixBoxFeat init:)
		(switchState init: global117)
		(CPMapPiece_3 init: global117)
		(NYMapPiece_6 init: global117)
		(matrixL32z init: global117)
		(switch_270 init:)
	)
)

(instance rayBeam of Prop
	(properties
		x 207
		y 191
		view 2307
	)

	(method (init)
		(if (IsFlag 117)
			(return)
		)
		(super init: &rest)
		(self setCycle: Osc -1)
		(beam_180 init:)
	)
)

(instance matrixBoxFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 276 106 315 106 315 142 276 142
					yourself:
				)
		)
		(if (== (proc70_9 48) gCurRoomNum)
			(self setHotspot: 2)
		else
			(self setHotspot: 132)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(132
				(proc70_3 48)
				(proc70_10 48 gCurRoomNum)
				(proc70_10 61 gCurRoomNum)
				(localproc_0)
				(self setHotspot: 2)
				(gCurRoom setScript: openBox)
			)
			(2
				(cond
					((not (SetFlag 101)) 0)
					((== (proc70_9 61) gCurRoomNum)
						(proc70_1 61 0)
					)
					(else
						(ClearFlag 101)
					)
				)
				(localproc_0)
				(UpdateScreenItem switchState)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance switchState of View
	(properties
		x 337
		y 115
		view 2062
	)

	(method (init)
		(localproc_0 0)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 279 188 314 188 314 254 279 254
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (SetFlag 117)
					(ClearFlag 117)
				)
				(switchClick play:)
				(localproc_0)
				(if (IsFlag 117)
					(gCurRoom doVerb: 138)
				else
					(gCurRoom doVerb: 137)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance CPMapPiece_3 of MigratingView
	(properties
		x 353
		y 224
		loop 1
		cel 1
		view 2062
		invItemID 12
	)
)

(instance matrixL32z of MigratingView
	(properties
		x 56
		y 259
		loop 1
		view 2062
		invItemID 78
	)
)

(instance NYMapPiece_6 of MigratingView
	(properties
		x 148
		y 254
		loop 1
		cel 2
		view 2062
		invItemID 88
	)
)

(instance london_0 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 180 179 170 210 142 213 110 202 109 198 84 249 35 239 24 254 6 256 -1 402 -2 402 11 454 24 455 -1 486 0 466 8 464 21 475 23 527 42 529 0 540 -1 541 19 564 15 565 25 569 28 575 36 585 30 584 0 591 1 592 185 324 190 281 188 239 187
					yourself:
				)
		)
	)
)

(instance spikes_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 185 33 48 42 134 47 107 52 134 58 90 67 174 57 187 38 192 23 187
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 140 181 144 108 149 179 yourself:)
				((Polygon new:) type: PTotalAccess init: 162 182 171 67 180 180 yourself:)
		)
	)
)

(instance sea_0 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 53 -1 199 -1 190 24 190 55 200 83 204 110 212 111 215 115 167 112 129 89 94 57 69 29
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 402 -1 540 -2 513 39 402 12
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 6 234 50 224 59 198 25
					yourself:
				)
		)
	)
)

(instance switch_270 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 263 246 245 248 199 240 199 238 185 238 167 247 161 252 116 276 115 275 106 315 106 315 114 339 116 345 162 353 165 353 176 352 188 353 199 345 200 345 259 352 260 352 271 338 275 283 278 259 272
					yourself:
				)
		)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 5
		x 295
		y 28
		nsBottom 51
		nsLeft 268
		nsRight 323
		nsTop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance barrier_180 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 418 127 507 117 508 73 520 54 532 43 541 39 556 0 573 0 578 23 589 18 591 209 562 221 544 239 510 258 491 251 454 251 426 245 415 237
					yourself:
				)
		)
	)
)

(instance beam_180 of Feature
	(properties
		noun 2
		x 212
		y 186
		nsBottom 244
		nsLeft -1
		nsRight 426
		nsTop 128
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 21 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance london_45 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 -1 103 -2 86 7 74 11 96 19 94 35 136 49 141 49 143 -1 148 -1 149 31 155 28 164 30 162 37 148 38 146 48 155 54 171 63 202 73 207 -1 214 -1 215 58 220 56 227 59 225 63 214 64 212 73 251 68 252 21 256 21 258 69 264 67 265 62 265 28 268 28 270 58 277 59 276 35 280 35 281 64 287 64 287 68 281 68 276 84 291 95 292 107 316 105 315 65 319 65 321 102 331 102 331 73 346 80 350 87 352 115 360 118 351 124 365 132 363 143 358 143 359 159 379 177 42 187 -2 185
					yourself:
				)
		)
	)
)

(instance door_45 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 150 273 128 294 131 296 154 318 179 297 179 275 151
					yourself:
				)
		)
	)
)

(instance sea_45 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 139 48 142 23 138 -2 257 -2 252 29 242 52 227 73 211 73 202 72
					yourself:
				)
		)
	)
)

(instance spikes_45 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 436 171 443 105 446 162 yourself:)
				((Polygon new:) type: PTotalAccess init: 454 160 462 62 473 134 yourself:)
				((Polygon new:) type: PTotalAccess init: 532 85 535 52 542 78 yourself:)
				((Polygon new:) type: PTotalAccess init: 562 63 565 47 568 60 yourself:)
		)
	)
)

(instance lights_45 of Feature
	(properties
		noun 6
		x 457
		y 115
		nsBottom 122
		nsLeft 431
		nsRight 483
		nsTop 108
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance twoExit_180 of ExitFeature
	(properties
		x 259
		y 180
		nsBottom 271
		nsLeft 47
		nsRight 472
		nsTop 89
		nextRoom 2061
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(if (not (IsFlag 117))
					(if (not (global122 beamStatus:))
						(super doVerb: theVerb)
					else
						(gGame autoSave: 1)
						(gCurRoom setScript: steppedIntoTheBarrier)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance london1Exit_45 of ExitFeature
	(properties
		x 312
		y 159
		nsBottom 236
		nsLeft 145
		nsRight 480
		nsTop 83
		nextRoom 3001
	)
)

(instance fiveExit_0 of ExitFeature
	(properties
		x 173
		y 153
		nsBottom 226
		nsLeft 44
		nsRight 302
		nsTop 81
		nextRoom 2064
	)
)

(instance switchClick of Sound
	(properties
		number 6112
	)
)

