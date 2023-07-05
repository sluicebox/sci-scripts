;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use GameControls)

(public
	GloryControls 0
)

(class GloryControls of GameControls
	(properties
		icon1 0
		icon2 0
		icon3 0
		icon4 0
		icon5 0
		icon6 0
		icon7 0
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (& (= temp1 (event type:)) $0040) ; direction
			(&= temp1 $ffbf) ; evPEEK | evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE | evNULL | $0c00
			(switch (event message:)
				(JOY_UPLEFT
					(icon1 select:)
				)
				(JOY_UPRIGHT
					(icon2 select:)
				)
				(JOY_DOWNLEFT
					(icon3 select:)
				)
				(JOY_DOWNRIGHT
					(icon4 select:)
				)
				(JOY_LEFT
					(icon5 select:)
				)
				(JOY_RIGHT
					(icon6 select:)
				)
				(JOY_UP
					(return 1)
				)
				(JOY_DOWN
					(return 1)
				)
				(JOY_NULL
					(if (== temp1 evKEYBOARD)
						(icon7 select:)
					else
						(return 1)
					)
				)
			)
		)
		(= temp0 (event message:))
		(if (== temp1 evKEYBOARD)
			(cond
				((== temp0 KEY_ESCAPE)
					(event message: JOY_NULL)
					(icon7 select:)
				)
				((== temp0 KEY_7)
					(icon1 select:)
				)
				((== temp0 KEY_9)
					(icon2 select:)
				)
				((== temp0 KEY_1)
					(icon3 select:)
				)
				((== temp0 KEY_3)
					(icon4 select:)
				)
				((== temp0 KEY_4)
					(icon5 select:)
				)
				((== temp0 KEY_6)
					(icon6 select:)
				)
				((or (== temp0 KEY_5) (== temp0 KEY_INSERT) (== temp0 KEY_0))
					(icon7 select:)
				)
			)
		)
		(if (== temp1 evKEYUP)
			(self eachElementDo: #highlight 0)
		)
		(return (super dispatchEvent: event))
	)

	(method (disable param1 &tmp temp0 temp1)
		(if argc
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= temp1
					(if (IsObject [param1 temp0])
						[param1 temp0]
					else
						(self at: [param1 temp0])
					)
				)
				(temp1 signal: (| (temp1 signal:) $0004))
			)
		else
			(|= state $0004)
		)
	)
)

