;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Feature)

(class RobotDoVerb of Feature
	(properties
		nsRight 1
	)

	(method (init)
		(= gRobotDoVerb self)
		(super init: &rest)
	)

	(method (dispose)
		(= gRobotDoVerb 0)
		(super dispose: &rest)
	)

	(method (onMe param1)
		(self doVerb: 179)
		(return (super onMe: param1))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(180
				(= nsLeft
					(= nsTop (= nsRight (= nsBottom (= y (= scratch 0)))))
				)
				(= nsRight 1)
			)
			(179
				(if gAutoRobot
					(self
						nsLeft: (gAutoRobot nsLeft:)
						nsTop: (gAutoRobot nsTop:)
						nsRight: (gAutoRobot nsRight:)
						nsBottom: (gAutoRobot nsBottom:)
						y: (gAutoRobot nsBottom:)
						scratch: (gAutoRobot robot:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

