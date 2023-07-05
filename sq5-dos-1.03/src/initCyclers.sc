;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 244)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	initCyclers 0
)

(instance initCyclers of Code
	(properties)

	(method (doit)
		(Pong setCycle: multiCycler init:)
		(RedStreak init:)
		(GreenWobble init:)
		(ColorMove init:)
		(BlueWobble init:)
		(GoldRush init:)
		(RedSpot init:)
		(GreenSpot init:)
		(YellowSpot init:)
		(BlueSpot init:)
		(MedChart init:)
	)
)

(instance multiCycler of Cycle
	(properties)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				0
			else
				(= cycleCnt gGameTime)
				1
			)
		)
	)

	(method (doit &tmp temp0)
		(if (self nextCel:)
			(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
				(if ((gCast at: temp0) isKindOf: MultiProp)
					((gCast at: temp0) nextCel:)
				)
			)
		)
	)
)

(class MultiProp of Prop
	(properties)

	(method (checkDetail param1)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						param1
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(else
				(self startUpd:)
			)
		)
	)

	(method (nextCel)
		(if (> (++ cel) (self lastCel:))
			(= cel 0)
		)
	)
)

(instance Pong of MultiProp
	(properties
		x 96
		y 131
		z 100
		noun 16
		view 249
		loop 10
		cel 10
		priority 14
		signal 16400
		detailLevel 2
	)
)

(instance RedStreak of MultiProp
	(properties
		x 240
		y 52
		noun 17
		view 249
		cel 5
		signal 16384
		detailLevel 2
	)
)

(instance ColorMove of MultiProp
	(properties
		x 94
		y 90
		noun 21
		view 249
		loop 8
		cel 2
		signal 16384
		detailLevel 2
	)
)

(instance GoldRush of MultiProp
	(properties
		x 99
		y 79
		noun 21
		view 249
		loop 9
		cel 2
		signal 16384
		detailLevel 2
	)
)

(instance GreenWobble of MultiProp
	(properties
		x 126
		y 99
		noun 21
		view 249
		loop 2
		signal 16384
		detailLevel 2
	)
)

(instance BlueWobble of MultiProp
	(properties
		x 113
		y 102
		noun 21
		view 249
		loop 3
		cel 2
		signal 16384
		detailLevel 2
	)
)

(instance RedSpot of MultiProp
	(properties
		x 142
		y 100
		noun 21
		view 249
		loop 4
		cel 13
		signal 16384
		detailLevel 2
	)
)

(instance GreenSpot of MultiProp
	(properties
		x 145
		y 100
		noun 21
		view 249
		loop 6
		cel 4
		signal 16384
		detailLevel 2
	)
)

(instance YellowSpot of MultiProp
	(properties
		x 143
		y 102
		noun 21
		view 249
		loop 7
		cel 6
		signal 16384
		detailLevel 2
	)
)

(instance BlueSpot of MultiProp
	(properties
		x 146
		y 102
		noun 21
		view 249
		loop 5
		cel 9
		signal 16384
		detailLevel 2
	)
)

(instance MedChart of MultiProp
	(properties
		x 148
		y 82
		noun 21
		view 249
		loop 1
		cel 8
		signal 16384
		detailLevel 2
	)
)

