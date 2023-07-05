;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use n112)
(use n1111)
(use System)

(public
	drippingAvianCisternScr 0
)

(instance drippingAvianCisternScr of Script
	(properties
		register 4
	)

	(method (dispose)
		(= register -1)
		(= scratch 0)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (== gNewRoomNum gCurRoomNum)
					(gCurRoom doVerb: 29)
				)
				(= seconds 4)
			)
			(2
				(= global230 (mod (+ global230 1) 16))
				(cond
					((OneOf gCurRoomNum 6101 6102) ; avianSecurity1, avianSecurity2
						(proc112_0 global230 60)
					)
					((OneOf gCurRoomNum 6111 6112) ; avianCistern1, avianCistern2
						(proc112_0 global230)
					)
					((and (IsFlag 123) (== gCurRoomNum 6103)) ; avianSecurity3
						(proc112_0 global230 50)
					)
					(else 1)
				)
				(= state 0)
				(if (== gNewRoomNum gCurRoomNum)
					(gCurRoom doVerb: 33)
				)
				(= cycles 1)
			)
		)
	)
)

