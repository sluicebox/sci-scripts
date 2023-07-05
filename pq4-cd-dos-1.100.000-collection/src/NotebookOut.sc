;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	NotebookOut 0
	NotebookIn 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance NotebookOut of Code
	(properties)

	(method (init param1 &tmp temp0 temp1)
		(if (and argc param1)
			(= temp1 param1)
		else
			(= temp1 0)
		)
		(= temp0
			(cond
				((< 68 (gEgo heading:) 113) 9012)
				((< 112 (gEgo heading:) 158) 9013)
				((< 157 (gEgo heading:) 203) 9014)
				((< 202 (gEgo heading:) 248) 9015)
				((< 247 (gEgo heading:) 293) 9016)
				((< 292 (gEgo heading:) 338) 9017)
				((or (> (gEgo heading:) 337) (< (gEgo heading:) 23)) 9018)
				((< 22 (gEgo heading:) 68) 9019)
			)
		)
		(if (OneOf (gEgo view:) 9120 9121 9122 9123 9125)
			(= local1 (gEgo scaleX:))
			(= local2 (gEgo scaleY:))
			(= local3 (gEgo scaler:))
			(= local4 (gEgo scaleSignal:))
			(gEgo
				scaleX: (/ (* (gEgo scaleX:) 130) 100)
				scaleY: (/ (* (gEgo scaleY:) 130) 100)
				scaler: 0
				scaleSignal: 1
			)
		)
		(gEgo view: temp0 setLoop: 0 cel: 0 setCycle: End temp1)
	)
)

(instance NotebookIn of Script
	(properties)

	(method (init param1 param2)
		(gTheDoits add: self)
		(= local0 0)
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
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
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
				(= local1 (= local2 (= local3 (= local4 0))))
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

