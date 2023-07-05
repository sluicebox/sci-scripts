;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 359)
(include sci.sh)
(use Main)
(use AutoMapProp)
(use System)

(public
	avianMap 0
)

(instance avianMap of AutoMapInset
	(properties
		picture 359
		arrowSignal 5
		mapHeight 624
	)

	(method (init)
		(gGame handsOff:)
		(Load rsVIEW 359)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (initItems)
		(cistern init: insetCast)
		(security init: insetCast)
		(ledgeControl init: insetCast)
		(greatHall init: insetCast)
		(mirmhall init: insetCast)
		(sessile init: insetCast)
		(theatre init: insetCast)
		(theatreBackstage init: insetCast)
		(hatchery init: insetCast)
		(school init: insetCast)
		(feedingPools init: insetCast)
	)

	(method (positionAlterEgo param1 &tmp temp0 temp1)
		(switch gCurRoomNum
			(6001 ; avianLeftShaft1
				(param1 posn: 267 110)
			)
			(6002 ; avianRightShaft1
				(param1 posn: 278 110)
			)
			(6003 ; avianLeftShaft2
				(param1 posn: 267 192)
			)
			(6004 ; avianRightShaft2
				(param1 posn: 278 192)
			)
			(6005 ; avianLeftShaft3
				(param1 posn: 267 274)
			)
			(6006 ; avianRightShaft3
				(param1 posn: 278 274)
			)
			(6007 ; avianLeftShaft4
				(param1 posn: 267 356)
			)
			(6008 ; avianRightShaft4
				(param1 posn: 278 356)
			)
			(6009 ; avianBridgeControls
				(switch gPrevRoomNum
					(6001 ; avianLeftShaft1
						(param1 posn: 267 110)
					)
					(6002 ; avianRightShaft1
						(param1 posn: 278 110)
					)
					(6003 ; avianLeftShaft2
						(param1 posn: 267 192)
					)
					(6004 ; avianRightShaft2
						(param1 posn: 278 192)
					)
					(6005 ; avianLeftShaft3
						(param1 posn: 267 274)
					)
					(6006 ; avianRightShaft3
						(param1 posn: 278 274)
					)
					(6007 ; avianLeftShaft4
						(param1 posn: 267 356)
					)
					(6008 ; avianRightShaft4
						(param1 posn: 278 356)
					)
				)
			)
			(6101 ; avianSecurity1
				(param1 posn: 237 111)
			)
			(6102 ; avianSecurity2
				(param1 posn: 230 110)
			)
			(6103 ; avianSecurity3
				(param1 posn: 226 109)
			)
			(6104 ; avianSecurity4
				(param1 posn: 211 108)
			)
			(6105 ; avianSecurity5
				(param1 posn: 233 106)
			)
			(6106 ; avianSecurity6
				(param1 posn: 233 70)
			)
			(6107 ; avianSecurity7
				(param1 posn: 239 70)
			)
			(6108 ; securityDoorWindow
				(param1 posn: 211 108)
			)
			(6109 ; securityScreen
				(param1 posn: 211 108)
			)
			(6110 ; securityKeypad
				(param1 posn: 211 108)
			)
			(6111 ; avianCistern1
				(param1 posn: 230 113)
			)
			(6112 ; avianCistern2
				(param1 posn: 237 115)
			)
			(6400 ; avianTheatre1
				(param1 posn: 216 273)
			)
			(6401 ; avianTheatre2
				(param1 posn: 199 275)
			)
			(6402 ; avianTheatre3
				(param1 posn: 220 272)
			)
			(6403 ; avianTheatre4
				(param1 posn: 181 276)
			)
			(6404 ; avianBackStage1
				(param1 posn: 237 266)
			)
			(6405 ; avianBackStage2
				(param1 posn: 231 262)
			)
			(6200 ; avianGreatHall1
				(param1 posn: 155 192)
			)
			(6201 ; avianGreatHall2
				(param1 posn: 144 188)
			)
			(6202 ; avianGreatHall3
				(param1 posn: 137 184)
			)
			(6203 ; avianGreatHall4
				(param1 posn: 134 182)
			)
			(6204 ; avianGreatHall5
				(param1 posn: 133 118)
			)
			(6600 ; avianSchool1
				(param1 posn: 337 359)
			)
			(6601 ; avianSchool02
				(param1 posn: 342 361)
			)
			(6602 ; avianSchool03
				(param1 posn: 347 363)
			)
			(6603 ; avianSchool04
				(param1 posn: 346 358)
			)
			(6604 ; avianSchool05
				(param1 posn: 357 359)
			)
			(6605 ; avianSchool06
				(param1 posn: 364 364)
			)
			(6606 ; avianSchool07
				(param1 posn: 354 363)
			)
			(6607 ; avianSchool08
				(param1 posn: 340 369)
			)
			(6608 ; avianSchool09
				(param1 posn: 326 369)
			)
			(6609 ; avianSchool10
				(param1 posn: 326 362)
			)
			(6610 ; avianSchool11
				(param1 posn: 348 367)
			)
			(6611 ; avianMirmicatDesk
				(param1 posn: 352 363)
			)
			(6612 ; avianSchoolElevator
				(param1 posn: 354 363)
			)
			(6802 ; avianHatchery02
				(param1 posn: 335 193)
			)
			(6803 ; avianHatchery03
				(param1 posn: 328 195)
			)
			(6804 ; avianHatchery04
				(param1 posn: 338 196)
			)
			(6805 ; avianHatchery05
				(param1 posn: 344 194)
			)
			(6807 ; avianHatchery07
				(param1 posn: 323 198)
			)
			(6810 ; avianHatchery10
				(param1 posn: 360 190)
			)
			(6811 ; avianHatchery11
				(param1 posn: 355 187)
			)
			(6813 ; avianHatchery13
				(param1 posn: 324 199)
			)
			(6814 ; avianHatchery14
				(param1 posn: 347 175)
			)
			(6820 ; avNicheHatcheryDoor
				(param1 posn: 328 195)
			)
			(6500 ; SessileRoom
				(param1 posn: 380 517)
			)
			(6510 ; mirmicatHall1
				(param1 posn: 358 530)
			)
			(6511 ; mirmicatHall2
				(param1 posn: 355 526)
			)
			(6512 ; mirmicatHall3
				(param1 posn: 371 521)
			)
			(6513 ; mirmicatHall4
				(param1 posn: 336 526)
			)
			(6901 ; mirmicatPoolRm1
				(param1 posn: 258 528)
			)
			(6902 ; mirmicatPoolRm2
				(param1 posn: 320 525)
			)
			(6903 ; mirmicatPoolRm3
				(param1 posn: 308 508)
			)
			(6904 ; mirmicatPoolRm4
				(param1 posn: 278 492)
			)
			(6905 ; mirmicatPoolRm5
				(param1 posn: 241 504)
			)
			(6906 ; mirmicatPoolRm6
				(param1 posn: 205 522)
			)
			(6907 ; mirmicatPoolRm7
				(param1 posn: 266 511)
			)
			(6910 ; poolControlsCloseUp
				(param1 posn: 266 511)
			)
			(6911 ; mirmicatPoolCloseUp
				(switch gPrevRoomNum
					(6902 ; mirmicatPoolRm2
						(param1 posn: 293 520)
					)
					(6904 ; mirmicatPoolRm4
						(param1 posn: 275 500)
					)
					(6906 ; mirmicatPoolRm6
						(param1 posn: 229 517)
					)
				)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
		(= temp0
			(Max 0 (Min 292 (* (- (/ (param1 y:) 73) 1) 73)))
		)
		(plane
			setRect:
				(plane left:)
				(- (plane top:) temp0)
				(plane right:)
				(- (plane bottom:) temp0)
		)
		(UpdatePlane plane)
	)
)

(instance shaftBridge of AutoMapProp ; UNUSED
	(properties
		x 290
		y 140
		view 359
		loop 1
		cel 13
	)

	(method (init)
		(super init: &rest)
		(self deleteHotspot:)
	)
)

(instance cistern of AutoMapProp
	(properties
		x 229
		y 109
		view 359
		cel 9
		testFlag 283
	)
)

(instance security of AutoMapProp
	(properties
		x 231
		y 106
		view 359
		cel 10
		testFlag 284
	)
)

(instance ledgeControl of AutoMapProp
	(properties
		x 232
		y 107
		view 359
		cel 11
		testFlag 285
	)
)

(instance greatHall of AutoMapProp
	(properties
		x 158
		y 191
		view 359
		cel 8
		testFlag 286
	)
)

(instance theatre of AutoMapProp
	(properties
		x 222
		y 275
		view 359
		cel 12
		testFlag 288
	)
)

(instance theatreBackstage of AutoMapProp
	(properties
		x 213
		y 269
		view 359
		cel 6
		testFlag 289
	)
)

(instance hatchery of AutoMapProp
	(properties
		x 335
		y 182
		view 359
		cel 7
		testFlag 287
	)
)

(instance school of AutoMapProp
	(properties
		x 344
		y 339
		view 359
		cel 4
		testFlag 290
	)
)

(instance mirmhall of AutoMapProp
	(properties
		x 358
		y 441
		view 359
		cel 3
		testFlag 291
	)
)

(instance sessile of AutoMapProp
	(properties
		x 379
		y 503
		view 359
		cel 2
		testFlag 292
	)
)

(instance feedingPools of AutoMapProp
	(properties
		x 268
		y 511
		view 359
		cel 1
		testFlag 293
	)
)

