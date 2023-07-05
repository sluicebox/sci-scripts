;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	rm29 0
)

(local
	[local0 18] = [149 101 127 75 158 107 146 146 112 147 134 133 122 157 113 159 109 155]
)

(instance rm29 of Rm
	(properties
		picture 29
		style -32761
	)

	(method (init)
		(super init: &rest)
		(self setScript: falling)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: hide:)
				(gGame setCursor: gWaitCursor 0)
				(= register 0)
				(ego2 posn: [local0 register] [local0 (+ register 1)] init:)
				(= ticks 18)
			)
			(1
				(if (< (+= register 2) 18)
					(ego2
						posn: [local0 register] [local0 (+ register 1)]
						setCel: (/ register 2)
					)
					(-- state)
					(= ticks 18)
				else
					(ego2 dispose:)
					(= ticks 18)
				)
			)
			(2
				(HandsOn)
				(gTheIconBar enable:)
				(gGame setCursor: gNormalCursor 1 160 100)
				(gCurRoom newRoom: 30)
				(self dispose:)
			)
		)
	)
)

(instance ego2 of Prop
	(properties
		view 129
		priority 15
		signal 16
	)
)

