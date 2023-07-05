;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4031)
(include sci.sh)
(use Main)
(use n63002)
(use WyntechPhoneRoom)
(use PolyEdit)

(public
	curtisCubicleRoomCH1SR3 0
)

(instance curtisCubicleRoomCH1SR3 of WyntechPhoneRoom
	(properties
		exitRoom 4021
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (call param1)
		(switch param1
			(6125
				(cond
					(
						(or
							(and (not (IsFlag 26)) (IsFlag 88))
							(and
								(IsFlag 26)
								(or
									(and
										(IsFlag 46)
										(or
											(IsFlag 45)
											(proc63002_4 84 85)
										)
									)
									(and
										(not (IsFlag 46))
										(proc63002_3 87 49)
									)
								)
							)
						)
						(viewOfTelop init: 2)
						(self ring:)
						(proc63002_11 4000 6 45 47 1)
						(self hook:)
						(viewOfTelop dispose:)
					)
					((IsFlag 26)
						(if (IsFlag 46)
							(if (SetFlag 84)
								(SetFlag 85)
								(= global209 5490)
								(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
							else
								(= global209 5480)
								(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
							)
						else
							(SetFlag 87)
							(= global209 5130)
							(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
						)
					)
					(else
						(SetFlag 88)
						(= global209 5120)
						(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
					)
				)
			)
			(6100
				(cond
					((IsFlag 26)
						(if (not (SetFlag 78))
							(= global209 5310)
							(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
						else
							(self busy:)
						)
					)
					((not (SetFlag 79))
						(= global209 5300)
						(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
					)
					(else
						(self busy:)
					)
				)
			)
			(6992
				(cond
					(
						(or
							(and (IsFlag 26) (IsFlag 81))
							(and (not (IsFlag 26)) (IsFlag 83))
						)
						(viewOfTelop init: 1)
						(self ring:)
						(proc63002_11 4000 5 45 11 1)
						(self hook:)
						(viewOfTelop dispose:)
					)
					((IsFlag 26)
						(SetFlag 81)
						(= global209 5420)
						(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
					)
					((SetFlag 82)
						(SetFlag 83)
						(= global209 5080)
						(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
					)
					(else
						(= global209 5070)
						(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
					)
				)
			)
			(6120
				(if (not (SetFlag 75))
					(= global209 5220)
					(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
				else
					(self busy:)
				)
			)
			(3038
				(if (SetFlag 80)
					(viewOfTelop init: 3)
					(self ring:)
					(proc63002_11 4000 8 45 51 1)
					(self hook:)
					(viewOfTelop dispose:)
				else
					(= global209 5270)
					(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
				)
			)
			(6114
				(if (not (SetFlag 76))
					(viewOfTelop init: 0)
					(proc63002_11 4000 9 45 49 1)
					(viewOfTelop dispose:)
					(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
				else
					(self busy:)
				)
			)
			(6996
				(if (not (SetFlag 77))
					(= global209 5290)
					(gCurRoom newRoom: 4021) ; curtisCubicleRoomCH1SR2
				else
					(self busy:)
				)
			)
			(else
				(super call: param1 &rest)
			)
		)
	)
)

(instance viewOfTelop of View
	(properties
		x 320
		y 303
		view 44031
	)

	(method (init param1)
		(= loop param1)
		(super init: &rest)
		(self setPri: 1)
	)
)

