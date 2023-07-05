;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use System)

(public
	ZCode 0
)

(instance ZCode of Code
	(properties)

	(method (doit param1 param2)
		(if (not (== gCurRoomNum 470))
			(cond
				(param2
					(if (& (param1 signal:) $0008)
						(if (< (param1 z:) 1000)
							(param1 z: (+ (param1 z:) 1000))
						)
					else
						(param1 signal: (| (param1 signal:) $0008))
						(DeleteScreenItem param1)
					)
				)
				((>= (param1 z:) 1000)
					(param1 z: (- (param1 z:) 1000))
				)
				(else
					(param1 signal: (& (param1 signal:) $fff7))
					(AddScreenItem param1)
				)
			)
		)
	)
)

