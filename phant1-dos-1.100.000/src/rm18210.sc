;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18210)
(include sci.sh)
(use Main)
(use n1111)
(use Actor)
(use System)

(public
	rm18210 0
)

(instance rm18210 of ScaryRoom
	(properties)

	(method (init &tmp temp0)
		(if (== gChapter 5)
			(= picture 18211)
		else
			(= picture 18210)
		)
		(KillRobot)
		(gEgo init: normalize: z: 1000)
		(= temp0 0)
		(cond
			((== global125 70)
				(= temp0 sUseMirror)
			)
			((== global125 79)
				(= temp0 sUseLotion)
			)
			((== global125 78)
				(= temp0 sWashHands)
			)
			((== global125 77)
				(= temp0 sBrushHair)
			)
			((== global125 76)
				(= temp0 sPowderNose)
			)
			((== global125 75)
				(= temp0 sPutOnLipstick)
			)
		)
		(if (< gChapter 4)
			(brush init:)
			(compact init:)
			(cream init:)
			(lipstick init:)
		)
		(towel init:)
		(sinkEdgeR init:)
		(super init:)
		(if temp0
			(self setScript: temp0 0 0)
		)
		(= global125 0)
	)
)

(instance sUseMirror of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1430 69 -9 gEgo 40 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 18250)
		(super dispose: &rest)
	)
)

(instance sBrushHair of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1460 59 -1 gEgo 40 1)
				)
				(1
					(brush z: 1000)
					(UpdateScreenItem brush)
				)
				(2
					(brush z: 0)
					(UpdateScreenItem brush)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(brush show:)
			(= global115 0)
		)
		(= gNewRoomNum 18250)
		(super dispose: &rest)
	)
)

(instance brush of View
	(properties
		x 182
		y 103
		priority 30
		fixPriority 1
		view 18210
		cel 2
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
		)
		(super init: &rest)
	)
)

(instance compact of View
	(properties
		x 147
		y 126
		priority 70
		fixPriority 1
		view 18210
		cel 4
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
		)
		(super init: &rest)
	)
)

(instance towel of View
	(properties
		x 178
		y 133
		priority 30
		fixPriority 1
		view 18210
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
		)
		(super init: &rest)
	)
)

(instance cream of View
	(properties
		x 215
		y 104
		priority 30
		fixPriority 1
		view 18210
		cel 3
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
		)
		(super init: &rest)
	)
)

(instance sinkEdgeR of View
	(properties
		x 172
		y 122
		priority 30
		fixPriority 1
		view 18210
		loop 1
		cel 2
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
			(= x 186)
			(= y 130)
		)
		(super init: &rest)
	)
)

(instance lipstick of View
	(properties
		x 156
		y 128
		priority 30
		fixPriority 1
		view 18210
		cel 1
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
		)
		(super init: &rest)
	)
)

(instance sinkEdgeL of View ; UNUSED
	(properties
		x 167
		y 130
		priority 20
		fixPriority 1
		view 18210
		loop 1
	)

	(method (init)
		(if (== gChapter 5)
			(= view 18211)
			(= x 118)
			(= y 130)
		)
		(super init: &rest)
	)
)

(instance sPutOnLipstick of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1450 6 -45 gEgo -1 1)
				)
				(1
					(lipstick z: 1000)
					(UpdateScreenItem lipstick)
				)
				(2
					(lipstick z: 0)
					(UpdateScreenItem lipstick)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 18250)
		(super dispose: &rest)
	)
)

(instance sUseLotion of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1470 56 -24 gEgo 40 1)
				)
				(1
					(cream z: 1000)
					(UpdateScreenItem cream)
				)
				(2
					(cream z: 0)
					(UpdateScreenItem cream)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 18250)
		(super dispose: &rest)
	)
)

(instance sPowderNose of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1480 78 0 gEgo -1 1)
				)
				(1
					(compact z: 1000)
					(UpdateScreenItem compact)
				)
				(2
					(compact z: 0)
					(UpdateScreenItem compact)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 18250)
		(super dispose: &rest)
	)
)

(instance sWashHands of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1420 63 -22 gEgo -1 1)
				)
				(1
					(sinkEdgeR priority: 200)
					(towel priority: 201)
					(UpdateScreenItem sinkEdgeR)
					(UpdateScreenItem towel)
				)
				(2
					(sinkEdgeR priority: 30)
					(towel priority: 30)
					(UpdateScreenItem sinkEdgeR)
					(UpdateScreenItem towel)
				)
				(3
					(towel z: 1000)
					(UpdateScreenItem towel)
				)
				(4
					(= cycles 2)
				)
				(5
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 18250)
		(super dispose: &rest)
	)
)

