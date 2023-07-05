;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 351)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	bangkokMap 0
)

(instance bangkokMap of AutoMapInset
	(properties
		picture 351
	)

	(method (initItems)
		(humanMuseum init: insetCast)
		(avianElev init: insetCast)
		(avianMuseum init: insetCast)
		(octoElev init: insetCast)
		(octoMuseum init: insetCast)
		(endRoom init: insetCast)
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(4004 ; bk1CountRm
				(param1 posn: 241 262)
			)
			(4005 ; bk1CountMusDoor
				(param1 posn: 251 262)
			)
			(4006 ; bkRepetition
				(switch global269
					(1
						(param1 posn: 241 262)
					)
					(2
						(param1 posn:)
					)
					(3
						(param1 posn:)
					)
				)
			)
			(4007 ; bkRecognition
				(switch global269
					(1
						(param1 posn: 241 262)
					)
					(2
						(param1 posn:)
					)
					(3
						(param1 posn:)
					)
				)
			)
			(4008 ; bkManipulation
				(switch global269
					(1
						(param1 posn: 241 262)
					)
					(2
						(param1 posn:)
					)
					(3
						(param1 posn:)
					)
				)
			)
			(4010 ; bkScreen2
				(switch global269
					(1
						(param1 posn: 241 262)
					)
					(2
						(param1 posn:)
					)
					(3
						(param1 posn:)
					)
				)
			)
			(4009 ; bk1Screen1
				(param1 posn: 241 262)
			)
			(4011 ; bk1Screen3
				(param1 posn: 241 262)
			)
			(4012 ; bk1Museum
				(param1 posn: 299 262)
			)
			(4013 ; bk1MusElevDoor
				(param1 posn: 333 262)
			)
			(4015 ; bk1MusNECU1
				(param1 posn: 313 262)
			)
			(4016 ; bk1MusNECU2
				(param1 posn: 313 262)
			)
			(4017 ; bk1MusNECU3
				(param1 posn: 313 262)
			)
			(4019 ; bk1MusSECU1
				(param1 posn: 293 269)
			)
			(4020 ; bk1MusSECU2
				(param1 posn: 293 269)
			)
			(4021 ; bk1MusSECU3
				(param1 posn: 293 269)
			)
			(4024 ; bk1MusSWCU1
				(param1 posn: 290 257)
			)
			(4025 ; bk1MusSWCU2
				(param1 posn: 290 257)
			)
			(4026 ; bk1MusSWCU3
				(param1 posn: 290 257)
			)
			(4028 ; bk1MusNWCU1
				(param1 posn: 308 256)
			)
			(4029 ; bk1MusNWCU2
				(param1 posn: 308 256)
			)
			(4022 ; bk1MusPuzDoor
				(param1 posn: 272 263)
			)
			(4031 ; bkElev1
				(switch global269
					(1
						(param1 posn: 349 262)
					)
					(2
						(param1 posn: 349 166)
					)
				)
			)
			(4104 ; bk2Anteroom
				(param1 posn: 329 167)
			)
			(4105 ; bk2AntMusDoor
				(param1 posn: 317 167)
			)
			(4109 ; bk2Screen1
				(param1 posn: 329 167)
			)
			(4111 ; bk2Screen3
				(param1 posn: 329 167)
			)
			(4112 ; bk2Museum
				(param1 posn: 269 167)
			)
			(4113 ; bk2MusElevDoor
				(param1 posn: 239 167)
			)
			(4115 ; bk2MusNECU1
				(param1 posn: 278 170)
			)
			(4116 ; bk2MusNECU2
				(param1 posn: 278 170)
			)
			(4117 ; bk2MusNECU3
				(param1 posn: 278 170)
			)
			(4119 ; bk2MusSECU1
				(param1 posn: 259 170)
			)
			(4120 ; bk2MusSECU2
				(param1 posn: 259 170)
			)
			(4121 ; bk2MusSECU3
				(param1 posn: 259 170)
			)
			(4124 ; bk2MusSWCU1
				(param1 posn: 256 165)
			)
			(4125 ; bk2MusSWCU2
				(param1 posn: 256 165)
			)
			(4126 ; bk2MusSWCU3
				(param1 posn: 256 165)
			)
			(4128 ; bk2MusNWCU1
				(param1 posn: 278 165)
			)
			(4129 ; bk2MusNWCU2
				(param1 posn: 278 165)
			)
			(4130 ; bk2MusNWCU3
				(param1 posn: 278 165)
			)
			(4136 ; bk2MusSECU4
				(param1 posn: 278 165)
			)
			(4122 ; bk2MusAntDoor
				(param1 posn: 294 167)
			)
			(4131 ; bkElev2
				(switch global269
					(2
						(param1 posn: 219 167)
					)
					(3
						(param1 posn: 219 67)
					)
				)
			)
			(4204 ; bk3Anteroom
				(param1 posn: 239 68)
			)
			(4209 ; bk3Screen1
				(param1 posn: 239 68)
			)
			(4211 ; bk3Screen3
				(param1 posn: 239 68)
			)
			(4205 ; bk3AntMusDoor
				(param1 posn: 250 68)
			)
			(4222 ; bk3MusAntDoor
				(param1 posn: 291 72)
			)
			(4212 ; bk3Museum
				(param1 posn: 300 70)
			)
			(4213 ; bk3MusDeadEnd
				(param1 posn: 332 69)
			)
			(4215 ; bk3MusNECU1
				(param1 posn: 312 67)
			)
			(4216 ; bk3MusNECU2
				(param1 posn: 312 67)
			)
			(4217 ; bk3MusNECU3
				(param1 posn: 312 67)
			)
			(4219 ; bk3MusSECU1
				(param1 posn: 291 67)
			)
			(4220 ; bk3MusSECU2
				(param1 posn: 291 67)
			)
			(4221 ; bk3MusSECU3
				(param1 posn: 291 67)
			)
			(4224 ; bk3MusSWCU1
				(param1 posn: 291 72)
			)
			(4225 ; bk3MusSWCU2
				(param1 posn: 291 72)
			)
			(4226 ; bk3MusSWCU3
				(param1 posn: 291 72)
			)
			(4228 ; bk3MusNWCU1
				(param1 posn: 308 72)
			)
			(4229 ; bk3MusNWCU2
				(param1 posn: 308 72)
			)
			(4230 ; bk3MusNWCU3
				(param1 posn: 308 72)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

(instance humanMuseum of AutoMapProp
	(properties
		x 300
		y 253
		view 351
		testFlag 258
	)
)

(instance avianElev of AutoMapProp
	(properties
		x 328
		y 160
		view 351
		cel 1
		testFlag 259
	)
)

(instance avianMuseum of AutoMapProp
	(properties
		x 267
		y 148
		view 351
		cel 2
		testFlag 260
	)
)

(instance octoElev of AutoMapProp
	(properties
		x 241
		y 62
		view 351
		cel 3
		testFlag 261
	)
)

(instance octoMuseum of AutoMapProp
	(properties
		x 302
		y 51
		view 351
		cel 4
		testFlag 262
	)
)

(instance endRoom of AutoMapProp
	(properties
		x 242
		y 258
		view 351
		cel 5
	)
)

