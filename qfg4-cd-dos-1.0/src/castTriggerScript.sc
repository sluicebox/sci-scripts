;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Array)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	castTriggerScript 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance castTriggerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 (IntArray with: 0 0 0 1 0 0 2 3))
				(= local5 (IntArray with: 2 3 6 7))
				(= local6 (IntArray with: 2 3 0 3 0 1 2 3))
				(gGlory handsOff:)
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) global441 global442)
						self
				)
			)
			(1
				(= local1 (gEgo loop:))
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local2 (gEgo cel:))
					(gEgo
						view: 19
						loop: (local4 at: local1)
						setCel: 0
						setCycle: End self
					)
				else
					(gEgo
						view: 14
						loop: (local6 at: local1)
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(triggerEffect
					x: global441
					y: global442
					setScaler: gEgo
					cycleSpeed: 0
					setPri: 180
					init:
					setCycle: Fwd
				)
				(if register
					(if (register onMe: global441 global442)
						(= local0 register)
					)
					(= register 0)
				)
				(if (not (and (> (gEgo view:) 17) (< (gEgo view:) 21)))
					(gEgo setCycle: Beg self)
				)
				(soundFX number: 934 play:)
			)
			(3
				(triggerEffect dispose:)
				(= cycles 2)
			)
			(4
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 20
						loop: (local5 at: (gEgo loop:))
						cel: (if (< (gEgo loop:) 6) 4 else 5)
					)
				else
					(gEgo normalize:)
				)
				(cond
					(
						(not
							(OneOf
								gCurRoomNum
								270
								290
								340
								440
								460
								520
								580
								593
								600
								641
								643
								650
								750
								800
							)
						)
						(gMessager say: 0 0 1 0 self 11) ; "Nothing seems to have been triggered."
					)
					(local0
						(local0 doVerb: -82)
					)
					(else
						(gMessager say: 0 0 1 0 self 11) ; "Nothing seems to have been triggered."
					)
				)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance triggerEffect of Prop
	(properties
		view 21
		signal 24577
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(if cycler
			(cycler doit:)
		)
		(if local3
			(self dispose:)
		else
			(if scaler
				(scaler doit:)
			)
			(super doit:)
		)
	)

	(method (dispose)
		(if local3
			(super dispose:)
		else
			(= local3 1)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

