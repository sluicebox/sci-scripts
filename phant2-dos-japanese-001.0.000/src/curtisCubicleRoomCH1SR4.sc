;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4041)
(include sci.sh)
(use Main)
(use n63002)
(use WynIniFile)
(use PolyEdit)
(use User)

(public
	curtisCubicleRoomCH1SR4 0
)

(local
	local0 = 1
)

(instance curtisCubicleRoomCH1SR4 of WynLogin
	(properties
		exitRoom 4021
		docuStoreRm 4051
		postalWareRm 4061
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= local0 1)
		(if (not (IsFlag 72))
			(self currentState: 1)
			(= local0 0)
		)
		(super init: &rest)
		(= temp5 (/ (* (gP2SongPlyr volPercent:) global241) 100))
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: temp5)
		else
			(gP2SongPlyr fadeTo: temp5)
		)
		(if (not (SetFlag 72))
			(= temp2 (gThePlane cast:))
			(for
				((= temp1 (temp2 first:)))
				temp1
				((= temp1 (temp2 next: temp1)))
				
				(= temp3 (temp2 value: temp1))
				(if
					(and
						(temp3 isKindOf: View)
						(== (temp3 view:) 3010)
						(== (temp3 loop:) 1)
					)
					(= temp4 (Clone Event))
					(temp4 type: 1)
					(temp3 handleEvent: temp4)
					(temp4 dispose:)
					(break)
				)
			)
		)
		(gGame handsOn: 1)
	)

	(method (newRoom newRoomNumber)
		(= local0 1)
		(if (and (== newRoomNumber docuStoreRm) (not (SetFlag 26)))
			(self
				currentState:
					(|
						(&
							(self currentState:)
							(~ (& (self currentState:) $000f))
						)
						$0002
					)
			)
			(SetFlag 73)
			(= global211 1)
			(= global212 0)
			(= global209 5040)
			(= local0 0)
			(super newRoom: 4021) ; curtisCubicleRoomCH1SR2
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (slideDoors param1)
		(if local0
			(super slideDoors: param1 &rest)
		)
	)
)

