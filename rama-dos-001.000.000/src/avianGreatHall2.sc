;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6201)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	avianGreatHall2 0
)

(procedure (localproc_0 param1)
	(= global243 param1)
)

(instance avianGreatHall2 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6203 ; avianGreatHall4
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(6202 ; avianGreatHall3
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(switch global243
					(2
						(localproc_0 3)
					)
				)
			)
			(66
				(switch global243
					(3
						(if (== heading 0)
							(waitingAvian init:)
						)
						(localproc_0 4)
					)
					(4
						(localproc_0 0)
						(if (== heading 0)
							(waitingAvian dispose:)
						)
					)
				)
			)
			(25
				(switch heading
					(0
						(leftNorthMural init: global117)
						(rightNorthMural init: global117)
					)
					(90
						(eastMural init: global117)
					)
					(270
						(westMural init: global117)
					)
				)
			)
			(26
				(switch heading
					(0
						(leftNorthMural dispose:)
						(rightNorthMural dispose:)
						(if (== global243 0)
							((gGame script:) next: avianGettingMelonScript)
						)
					)
					(90
						(eastMural dispose:)
					)
					(270
						(westMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6207
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 128)
			(= picture 6207)
			(doorGHOut_180 init:)
		else
			(= picture 6223)
			(avianGuard_180 init:)
		)
		(defaultExit nextRoom: 6200 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(murals_180 init:)
		(perches_180 init:)
		(gourds_180 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6206
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(murals_90 init:)
		(gourds_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6205
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(murals_270 init:)
		(gourds_270 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6204
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 127)
			(= picture 6204)
			(super init:)
			(if (not (IsFlag 128))
				(gCurRoom setScript: avianWaitingAtElevatorScript)
				(avianAtElevator init: global117)
			)
			(dispensorLever init:)
			(elevExit init:)
			(gCurRoom exitN: elevExit)
		else
			(switch global243
				(0
					(gCurRoom drawPic: 6221)
					(= picture 6221)
					(gCurRoom setScript: avianGettingMelonScript)
				)
				(1
					(= picture 6220)
					(mannaMelon init:)
					(gCurRoom setScript: avianOfferingMelonScript)
				)
				(2
					(= picture 6228)
				)
				(3
					(= picture 6228)
				)
				(4
					(= picture 6228)
					(waitingAvian init:)
				)
				(else
					(elevExit init:)
					(gCurRoom exitN: elevExit)
				)
			)
			(super init:)
			(avian_0 init:)
		)
		(murals_0 init:)
		(gourds_0 init:)
		(dispensor_0 init:)
	)

	(method (dispose)
		(proc1111_6)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(switch global243
			(1
				(mannaMelon dispose:)
			)
			(4
				(waitingAvian dispose:)
			)
		)
		(super dispose: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance elevExit of ExitFeature
	(properties
		nsBottom 203
		nsLeft 280
		nsRight 352
		nsTop 75
		nextRoom 6202
	)
)

(instance avianOfferingMelon of VMDMovie
	(properties
		movieName 6202
		endPic 6220
		cacheSize 300
	)
)

(instance avianStanding of VMDMovie
	(properties
		movieName 6205
		endPic 6228
	)
)

(instance avianEatingMelon of VMDMovie
	(properties
		movieName 6208
		endPic 6229
		cacheSize 500
	)
)

(instance mannaMelon of Feature
	(properties
		nsBottom 203
		nsLeft 321
		nsRight 357
		nsTop 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc1111_6)
				(gTheCursor hide:)
				(proc70_1 124 0 16)
				(avianStanding play:)
				(gCurRoom drawPic: 6228)
				(avianOfferingMelonScript dispose:)
				(localproc_0 2)
				(gTheCursor show:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waitingAvian of Feature
	(properties
		nsBottom 202
		nsLeft 289
		nsRight 389
		nsTop 89
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 17)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(17
				(localproc_0 5)
				(SetFlag 127)
				(proc70_3)
				(avianEatingMelon play:)
				(gCurRoom setScript: avianWaitingAtElevatorScript)
				(elevExit init:)
				(dispensorLever init:)
				(avianAtElevator init: global117)
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dispensorLever of Feature
	(properties
		nsBottom 154
		nsLeft 255
		nsRight 289
		nsTop 99
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 129)
			(mannaMelon2 init: global117)
		else
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom setScript: dispenseMelonScript)
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianGettingMelonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(= global161 0)
				(avianOfferingMelon play:)
				(gCurRoom setScript: avianOfferingMelonScript)
				(localproc_0 1)
				(mannaMelon init:)
				(self dispose:)
			)
		)
	)
)

(instance avianOfferingMelonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (Random 0 1)
					(proc1111_7 6200 258 48 0 0 -1 0 self)
				else
					(proc1111_7 6201 262 50 0 0 -1 0 self)
				)
				(= state -1)
			)
		)
	)
)

(instance avianWaitingAtElevatorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(avianAtElevator cel: global161)
				(avianAtElevator setCycle: End self)
				(chortle play:)
			)
			(1
				(= global161 0)
				(= seconds (Random 2 8))
				(= state -1)
			)
		)
	)
)

(instance dispenseMelonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 6209 257 98 0 0 10 0 self)
				(SetFlag 129)
				(gGame handsOff:)
			)
			(1
				(mannaMelon2 init: global117)
				(if (not (IsFlag 128))
					(gCurRoom setScript: avianWaitingAtElevatorScript)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leftNorthMural of View
	(properties
		x 46
		y 152
		loop 1
		view 6201
	)
)

(instance rightNorthMural of View
	(properties
		x 430
		y 150
		loop 1
		cel 1
		view 6201
	)
)

(instance eastMural of View
	(properties
		x 286
		y 219
		loop 2
		view 6201
	)
)

(instance westMural of View
	(properties
		x 44
		y 216
		loop 3
		view 6201
	)
)

(instance mannaMelon2 of View
	(properties
		x 340
		y 213
		view 6200
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (<= global231 30)
					(self hide:)
					(ClearFlag 129)
					(proc70_1 124)
					(dispensorLever setHotspot: 2)
					(self dispose:)
				else
					(proc1111_31 1 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianAtElevator of Prop
	(properties
		priority 9
		x 283
		y 149
		cycleSpeed 4
		view 6202
	)

	(method (dispose)
		(= global161 cel)
		(super dispose:)
	)
)

(instance chortle of Sound
	(properties
		number 6218
		flags 5
	)
)

(instance murals_0 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 33 6 159 59 184 146 9 194
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 435 59 558 8 582 195 411 145
					yourself:
				)
		)
	)
)

(instance dispensor_0 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 254 128 273 103 280 192 332 209 366 210 370 233 332 232 280 217 280 227 298 242 278 253 223 256 217 242 240 225 239 175
					yourself:
				)
		)
	)
)

(instance murals_270 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -3 151 32 84 312 83 375 229 -3 232
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 2 56 64 212 -1 225 yourself:)
				((Polygon new:) type: PTotalAccess init: 534 209 591 58 590 227 yourself:)
		)
	)
)

(instance doorGHOut_180 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 115 309 116 327 165 307 180 278 181 263 165
					yourself:
				)
		)
	)
)

(instance murals_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 88 550 85 586 155 586 236 211 228
					yourself:
				)
		)
	)
)

(instance avianGuard_180 of Feature
	(properties
		noun 17
		x 301
		y 143
		nsBottom 214
		nsLeft 262
		nsRight 340
		nsTop 72
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gourds_180 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 239 27 238 29 263 4 270
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 202 220 229 219 229 243 205 244
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 392 217 415 219 416 247 391 245
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 441 220 459 221 460 248 434 246
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 516 228 540 230 538 263 509 257
					yourself:
				)
		)
	)
)

(instance avian_0 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 289 116 317 149 352 344 yourself:)
		)
	)
)

(instance gourds_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 126 75 123 94 188 81 190
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 121 164 93 106 132 67 122 163 132 167 136 175 130 176
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 138 59 171 66 161 137 174 154 174 164 169 159
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 501 188 503 121 546 91 513 188
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 479 180 478 91 499 68 522 82 494 162 483 182
					yourself:
				)
		)
	)
)

(instance gourds_90 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 6 235 211 229 238 244 240 247 216 332 46 336 0 324 72 401 209 409 238 417 239 412 201 422 178 445 211 454 237 464 237 461 229 458 209 514 85 523 -2
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 60 238 67 210 5 87 3 1 100 3 88 196 69 223 69 236
					yourself:
				)
		)
	)
)

(instance perches_180 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 121 7 189 4 414 -1 474 9 410 38 329 47 257 45 198 37 125 10
					yourself:
				)
		)
	)
)

(instance gourds_270 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 490 60 489 141 543 205 567 184 591 119 591 1 489 1
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 552 225 565 226 564 237 554 238
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 380 202 355 176 332 208 270 78 274 0 435 1 433 126 382 196 358 177
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 379 227 387 227 389 236 377 237
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 334 229 341 226 346 237 332 237
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 149 228 163 228 163 237 152 238
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 169 196 86 69 16 206 -2 166 2 14 250 0 244 80 167 194
					yourself:
				)
		)
	)
)

