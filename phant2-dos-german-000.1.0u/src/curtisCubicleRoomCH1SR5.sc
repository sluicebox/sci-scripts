;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4051)
(include sci.sh)
(use Main)
(use n63002)
(use P2Feature)
(use WynIniFile)
(use System)

(public
	curtisCubicleRoomCH1SR5 0
)

(local
	local0
	local1
	local2
	local3 = 1
)

(instance curtisCubicleRoomCH1SR5 of WynDocuStore
	(properties
		exitRoom 4021
		postalWareRm 4061
	)

	(method (init)
		(= local3 1)
		(= local0 (gWynNet findItem: 6301 3 0 33 2))
		(super init: &rest)
		(if (ClearFlag 114)
			(= curFolder (gWynNet findItem: 6301 21 0 70 1))
			(= curDoco local0)
			(self refresh:)
			(docoTextPlane scratch: 1)
		)
		(gGame handsOn: 1)
	)

	(method (handleEvent event param2 &tmp temp0 temp1)
		(cond
			((and (== event local0) (IsFlag 46) (not (IsFlag 55)))
				(SetFlag 54)
				(gCast add: (= temp0 (Send new: gCurRoom 280 4081)))
				((plane cast:) delete: temp0)
				(temp0 plane: 0)
				(gGame handsOff:)
			)
			((and (== event curDoco) (== curDoco local0))
				(cond
					((IsFlag 55)
						(if (proc63002_4 64 24 43)
							(SetFlag 70)
							(Send new: daysDone 9)
							(gGame handsOff:)
						else
							(= temp1 global241)
							(= global241 100)
							(proc63002_7 5365)
							(= global241 temp1)
						)
					)
					((IsFlag 98)
						(gRoboGary stop: 1)
						(SetFlag 46)
						(Send new: hectMomPart2StuffCode 9)
					)
					((IsFlag 97)
						(SetFlag 98)
						(= temp1 global241)
						(= global241 100)
						(proc63002_7 5365)
						(= global241 temp1)
					)
					(else
						(SetFlag 97)
						(= temp1 global241)
						(= global241 100)
						(proc63002_7 5365)
						(= global241 temp1)
					)
				)
			)
			(else
				(super handleEvent: event param2 &rest)
			)
		)
	)

	(method (isKindOf param1)
		(return
			(if local2
				0
			else
				(super isKindOf: param1 &rest)
			)
		)
	)

	(method (slideDoors)
		(cond
			((or local2 (and (IsFlag 54) (not (IsFlag 55))))
				(= local2 0)
			)
			(local3
				(super slideDoors: &rest)
			)
		)
	)

	(method (refresh)
		(super refresh:)
		(if (and (== curDoco local0) docoTextPlane)
			(docoTextPlane scratch: 1)
		)
	)
)

(instance hectMomPart2StuffCode of Code
	(properties)

	(method (doit)
		(gCurRoom hideAll:)
		(((gCurRoom plane:) cast:) delete: gCurRoom flush: add: gCurRoom)
		(gCurRoom drawPic: 233)
		(= global211 (= global212 1))
		(proc63002_7 5370)
		(daScreen init:)
		(= local2 1)
		(gTheCursor normalize:)
		((WynNetEmail
				new: 6301 15 0 8 3 6301 15 0 8 1 6301 15 0 8 2 6301 1 0 8 1
			)
			funnyR:
				(EmailResponse
					new:
						6301
						15
						0
						16
						3
						6301
						15
						0
						16
						1
						6301
						15
						0
						8
						2
						6301
						1
						51
						8
						1
				)
			sarcasticR:
				(EmailResponse
					new:
						6301
						15
						0
						16
						3
						6301
						15
						0
						16
						1
						6301
						15
						0
						8
						2
						6301
						1
						50
						8
						1
				)
			straightR:
				(EmailResponse
					new:
						6301
						15
						0
						16
						3
						6301
						15
						0
						16
						1
						6301
						15
						0
						8
						2
						6301
						1
						52
						8
						1
				)
		)
		(WynNetEmail
			new: 6301 15 0 10 3 6301 15 0 10 1 6301 15 0 10 2 6301 1 0 10 1
		)
		(WynNetEmail
			new: 6301 15 0 16 3 6301 15 0 16 1 6301 15 0 16 2 6301 1 0 16 1
		)
		(WynNetEmail
			new: 6301 15 0 11 3 6301 15 0 11 1 6301 15 0 11 2 6301 1 0 11 1
		)
		(WynNetEmail
			new: 6301 15 0 12 3 6301 15 0 12 1 6301 15 0 12 2 6301 1 0 12 1
		)
		((WynNetEmail
				new: 6301 15 0 9 3 6301 15 0 9 1 6301 15 0 9 2 6301 1 0 9 1
			)
			funnyR:
				(EmailResponse
					new:
						6301
						15
						0
						16
						3
						6301
						15
						0
						16
						1
						6301
						15
						0
						9
						2
						6301
						1
						51
						9
						1
				)
			sarcasticR:
				(EmailResponse
					new:
						6301
						15
						0
						16
						3
						6301
						15
						0
						16
						1
						6301
						15
						0
						9
						2
						6301
						1
						50
						9
						1
				)
			straightR:
				(EmailResponse
					new:
						6301
						15
						0
						16
						3
						6301
						15
						0
						16
						1
						6301
						15
						0
						9
						2
						6301
						1
						52
						9
						1
				)
		)
		(WynNetEmail
			new: 6301 15 0 17 3 6301 15 0 17 1 6301 15 0 17 2 6301 1 0 17 1
		)
		(WynNetEmail
			new: 6301 15 0 13 3 6301 15 0 13 1 6301 15 0 13 2 6301 1 0 13 1
		)
		(WynNetEmail
			new: 6301 15 0 14 3 6301 15 0 14 1 6301 15 0 14 2 6301 1 0 14 1
		)
		(WynNetEmail
			new: 6301 15 0 18 3 6301 15 0 18 1 6301 15 0 18 2 6301 1 0 18 1
		)
		(WynNetEmail
			new: 6301 15 0 15 3 6301 15 0 15 1 6301 15 0 15 2 6301 1 0 15 1
		)
	)
)

(instance daScreen of P2Feature
	(properties)

	(method (init)
		(super
			init:
				(proc63002_10
					304
					66
					406
					57
					461
					65
					464
					180
					528
					243
					340
					265
					325
					215
					304
					146
				)
		)
		(= whoDoit mommy)
	)
)

(instance mommy of Code
	(properties)

	(method (doit)
		(= global209 5371)
		(= global211 1)
		(= global212 0)
		(gCurRoom curDoco: 0 curFolder: 0)
		(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
	)
)

(instance daysDone of Code
	(properties)

	(method (doit &tmp temp0)
		(= global209 5360)
		(= local3 0)
		(= temp0 (gCurRoom curDoco:))
		(gCurRoom curDoco: 0)
		(temp0 dispose:)
		(gCurRoom currentState: 0 newRoom: 4011) ; curtisCubicleRoomCH1SR1
	)
)

