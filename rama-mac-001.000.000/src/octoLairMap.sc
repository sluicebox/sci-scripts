;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 361)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	octoLairMap 0
)

(instance octoLairMap of AutoMapInset
	(properties
		picture 361
	)

	(method (initItems)
		(museum init: insetCast)
		(meenie init: insetCast)
		(eniee init: insetCast)
		(teach init: insetCast)
		(ramp init: insetCast)
		(mo init: insetCast)
		(miniee init: insetCast)
		(pit init: insetCast)
		(subwaySpikes init: insetCast)
		(subwayDome init: insetCast)
		(subwayCar init: insetCast)
		(subwayStation init: insetCast)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(7000 ; octoAtriumRamp
				(param1 posn: 242 132)
			)
			(7001 ; octoAtriumPad
				(param1 posn: 246 143)
			)
			(7002 ; octoAtriumEenie
				(param1 posn: 260 137)
			)
			(7003 ; octoAtriumEenieCU
				(param1 posn: 260 137)
			)
			(7004 ; octoAtriumMeenie
				(param1 posn: 265 147)
			)
			(7005 ; octoAtriumMeenieCU
				(param1 posn: 265 147)
			)
			(7006 ; octoAtriumMynie
				(param1 posn: 232 151)
			)
			(7007 ; octoAtriumMynieCU
				(param1 posn: 232 151)
			)
			(7008 ; octoAtriumMo
				(param1 posn: 231 139)
			)
			(7009 ; octoAtriumMoCU
				(param1 posn: 231 139)
			)
			(7010 ; octoRampBottom
				(param1 posn: 235 99)
			)
			(7011 ; octoPlatformBottom
				(param1 posn: 238 79)
			)
			(7012 ; octoRampMiddle
				(param1 posn: 248 75)
			)
			(7013 ; octoPlatformTop
				(param1 posn: 262 70)
			)
			(7014 ; octoRampTop
				(param1 posn: 263 50)
			)
			(7015 ; octoRampGate
				(param1 posn: 257 31)
			)
			(7016 ; octoAbacusCU
				(switch gPrevRoomNum
					((param1 posn:))
					((param1 posn:))
				)
			)
			(7100 ; octoEenieAtrium
				(param1 posn: 268 132)
			)
			(7102 ; octoEenie3
				(param1 posn: 278 125)
			)
			(7103 ; octoEenie4
				(param1 posn: 293 121)
			)
			(7105 ; octoEenie6
				(param1 posn: 314 119)
			)
			(7106 ; octoEenie7
				(param1 posn: 337 120)
			)
			(7108 ; octoEenie9
				(param1 posn: 350 123)
			)
			(7110 ; octoEenieGateInCU
				(param1 posn: 359 125)
			)
			(7111 ; octoEenieGateOutCU
				(param1 posn: 371 127)
			)
			(7112 ; octoEeniePit
				(param1 posn: 359 125)
			)
			(7113 ; octoEenieAtriumCU
				(param1 posn: 293 121)
			)
			(7200 ; octoMeenieAtrium
				(param1 posn: 275 151)
			)
			(7202 ; octoMeenie3
				(param1 posn: 292 155)
			)
			(7203 ; octoMeenie4
				(param1 posn: 314 157)
			)
			(7205 ; octoMeenie6
				(param1 posn: 338 154)
			)
			(7206 ; octoMeenie7
				(param1 posn: 355 147)
			)
			(7208 ; octoMeenie9
				(param1 posn: 361 141)
			)
			(7209 ; octoMeenieGateInCU
				(param1 posn: 370 135)
			)
			(7210 ; octoMeenieGateOutCU
				(param1 posn: 374 129)
			)
			(7211 ; octoMeeniePit
				(param1 posn: 370 135)
			)
			(7212 ; octoMeenieAtriumCU
				(param1 posn: 275 151)
			)
			(7400 ; octoMoAtrium
				(param1 posn: 204 131)
			)
			(7401 ; octoMoCistern
				(param1 posn: 183 122)
			)
			(7402 ; octoMoAtrCU
				(param1 posn: 220 135)
			)
			(7500 ; octoCistern
				(param1 posn: 193 113)
			)
			(7501 ; octoCisMO
				(param1 posn: 187 115)
			)
			(7502 ; octoCisternGate
				(param1 posn: 199 109)
			)
			(7503
				(param1 posn: 199 109)
			)
			(7506 ; octoCisHDCU
				(param1 posn: 187 111)
			)
			(7507 ; octoCisLockCU
				(param1 posn: 187 111)
			)
			(7508 ; octoCisBarsCU
				(param1 posn: 201 114)
			)
			(7509 ; octoCisUniformCU
				(param1 posn: 187 111)
			)
			(7600 ; octoMuseum
				(param1 posn: 341 138)
			)
			(7601 ; octoMusTeaDoor
				(param1 posn: 333 136)
			)
			(7602 ; octoMusDoorCU
				(param1 posn: 333 136)
			)
			(7603 ; octoMuseumManCU
				(param1 posn: 341 138)
			)
			(7604 ; octoMuseumStandCU
				(param1 posn: 341 138)
			)
			(7605 ; octoMuseumWheelCU
				(param1 posn: 341 138)
			)
			(7606 ; octoMuseumCircle1CU
				(param1 posn: 341 138)
			)
			(7607 ; octoMuseumCircle2CU
				(param1 posn: 341 138)
			)
			(7608 ; octoMuseumCircle3CU
				(param1 posn: 341 138)
			)
			(7609 ; octoMuseumCircle4CU
				(param1 posn: 341 138)
			)
			(7610 ; octoMuseumCircle5CU
				(param1 posn: 341 138)
			)
			(7611 ; octoMuseumCircle6CU
				(param1 posn: 341 138)
			)
			(7612 ; octoCircle1CU
				(param1 posn: 341 138)
			)
			(7613 ; octoCircle2CU
				(param1 posn: 341 138)
			)
			(7614 ; octoCircle3CU
				(param1 posn: 341 138)
			)
			(7615 ; octoCircle4CU
				(param1 posn: 341 138)
			)
			(7616 ; octoCircle5CU
				(param1 posn: 341 138)
			)
			(7617 ; octoCircle6CU
				(param1 posn: 341 138)
			)
			(7700 ; octoPitRoom
				(param1 posn: 385 127)
			)
			(7701 ; octoPitPad
				(param1 posn: 398 126)
			)
			(7702
				(param1 posn: 398 126)
			)
			(7800 ; octoTeacher
				(param1 posn: 317 132)
			)
			(7802 ; octoTeaMusDoorCU
				(param1 posn: 325 133)
			)
			(7803 ; octoTeaGate
				(param1 posn: 307 130)
			)
			(7804 ; octoTeaGateCU
				(param1 posn: 307 130)
			)
			(7900 ; octoSubPad
				(param1 posn: 397 216)
			)
			(7901 ; octoSubAbacus
				(param1 posn: 421 216)
			)
			(7903 ; octoSubDoor
				(param1 posn: 373 216)
			)
			(7904 ; octoSubDome
				(param1 posn: 335 216)
			)
			(7905 ; octoSubMapCU
				(param1 posn: 335 209)
			)
			(7906 ; octoSubStation
				(param1 posn: 294 217)
			)
			(7907 ; octoSubwayCarLarge
				(param1 posn: 287 211)
			)
			(7908 ; octoSubwaySmall
				(param1 posn: 289 226)
			)
			(7909 ; octoSubwayInsideCar
				(param1 posn: 289 226)
			)
			(7910 ; octoSubwayInsideLgCar
				(param1 posn: 287 211)
			)
			(7920 ; octoMorph
				(param1 posn: 152 237)
			)
			(7921 ; ocMorphBBNorth
				(param1 posn: 146 241)
			)
			(7922 ; ocMorphBBSouth
				(param1 posn: 156 233)
			)
			(7923 ; ocMorphGateNW
				(param1 posn: 153 242)
			)
			(7924 ; ocMorphGateSW
				(param1 posn: 162 235)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

(instance museum of AutoMapProp
	(properties
		x 340
		y 124
		view 361
		testFlag 299
	)
)

(instance meenie of AutoMapProp
	(properties
		x 328
		y 155
		view 361
		cel 1
		testFlag 296
	)
)

(instance eniee of AutoMapProp
	(properties
		x 324
		y 117
		view 361
		cel 2
		testFlag 295
	)
)

(instance teach of AutoMapProp
	(properties
		x 314
		y 117
		view 361
		cel 3
		testFlag 300
	)
)

(instance ramp of AutoMapProp
	(properties
		x 245
		y 112
		view 361
		cel 4
		testFlag 294
	)
)

(instance mo of AutoMapProp
	(properties
		x 193
		y 108
		view 361
		cel 5
		testFlag 298
	)
)

(instance miniee of AutoMapProp
	(properties
		x 216
		y 160
		view 361
		cel 6
		testFlag 297
	)
)

(instance pit of AutoMapProp
	(properties
		x 378
		y 118
		view 361
		cel 7
		testFlag 301
	)
)

(instance subwaySpikes of AutoMapProp
	(properties
		x 403
		y 196
		view 361
		cel 8
		testFlag 302
	)
)

(instance subwayDome of AutoMapProp
	(properties
		x 338
		y 201
		view 361
		cel 9
		testFlag 303
	)
)

(instance subwayCar of AutoMapProp
	(properties
		x 191
		y 251
		view 361
		cel 10
		testFlag 305
	)
)

(instance subwayStation of AutoMapProp
	(properties
		x 283
		y 196
		view 361
		cel 11
		testFlag 304
	)
)

