;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	stairReg 0
)

(instance stairReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/stair')
					(cond
						((== gCurRoomNum 37)
							(Print 211 0) ; "The grand stairway leads up to the second level of the mansion."
						)
						((== gCurRoomNum 76)
							(Print 211 1) ; "From here, the stairs lead downward."
						)
						(else
							(Print 211 2) ; "A grand stairway leads down to the first level of the mansion, while another smaller staircase goes upwards."
						)
					)
				)
				((Said '/balcony')
					(Print 211 3) ; "This railing looks mighty old and rickety!"
				)
			)
		)
	)
)

