;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	BadgeOut 0
	BadgeIn 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance BadgeOut of Code
	(properties)

	(method (init param1 &tmp temp0 temp1)
		(if (and argc param1)
			(= temp1 param1)
		else
			(= temp1 0)
		)
		(= temp0
			(cond
				((< 68 (gEgo heading:) 113) 9000)
				((< 112 (gEgo heading:) 158) 9001)
				((< 157 (gEgo heading:) 203) 9002)
				((< 202 (gEgo heading:) 248) 9003)
				((< 247 (gEgo heading:) 293) 9004)
				((< 292 (gEgo heading:) 338) 9005)
				((or (> (gEgo heading:) 337) (< (gEgo heading:) 23)) 9006)
				((< 22 (gEgo heading:) 68) 9007)
			)
		)
		(cond
			((OneOf (gEgo view:) 9120 9121 9122 9123 9125)
				(= local1 (gEgo scaleX:))
				(= local2 (gEgo scaleY:))
				(= local3 (gEgo scaler:))
				(= local4 (gEgo scaleSignal:))
				(gEgo
					scaleX: (/ (* (gEgo scaleX:) 134) 100)
					scaleY: (/ (* (gEgo scaleY:) 134) 100)
					scaler: 0
					scaleSignal: 1
				)
			)
			((OneOf (gEgo view:) 9797 9798)
				(= local1 (gEgo scaleX:))
				(= local2 (gEgo scaleY:))
				(= local3 (gEgo scaler:))
				(= local4 (gEgo scaleSignal:))
				(gEgo
					scaleX: (/ (* (gEgo scaleX:) 123) 100)
					scaleY: (/ (* (gEgo scaleY:) 123) 100)
					scaler: 0
					scaleSignal: 1
				)
			)
		)
		(gEgo view: temp0 setLoop: 0 cel: 0 setCycle: End temp1)
		(= gProp
			((Prop new:)
				view: temp0
				setLoop: 2
				x: (gEgo x:)
				y: (gEgo y:)
				scaleX: (gEgo scaleX:)
				scaleY: (gEgo scaleY:)
				scaleSignal: (gEgo scaleSignal:)
				signal: 16384
				init:
				yourself:
			)
		)
	)
)

(instance BadgeIn of Script
	(properties)

	(method (init param1 param2)
		(gTheDoits add: self)
		(= local0 0)
		(= client 1)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			(= caller param1)
			(if (>= argc 2)
				(= local0 param2)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (dispose)
		(= client 0)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(= cycles 1)
			)
			(2
				(gEgo normalize: local0)
				(if local1
					(gEgo
						scaleX: local1
						scaleY: local2
						scaler: local3
						scaleSignal: local4
					)
				)
				(gProp dispose:)
				(= gProp (= local1 (= local2 (= local3 (= local4 0)))))
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

