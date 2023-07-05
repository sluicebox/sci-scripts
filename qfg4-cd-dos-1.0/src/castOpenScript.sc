;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Array)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	castOpenScript 0
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

(instance castOpenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 (IntArray with: 0 0 0 1 0 0 2 3))
				(= local4 (IntArray with: 2 3 6 7))
				(= local5 (IntArray with: 2 3 0 3 0 1 2 3))
				(gGlory handsOff:)
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(- (gEgo y:) (/ (gEgo scaleY:) 3))
							global441
							global442
						)
						self
				)
			)
			(1
				(= local1 (gEgo loop:))
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local2 (gEgo cel:))
					(gEgo
						view: 19
						loop: (local3 at: local1)
						setCel: 0
						setCycle: End self
					)
				else
					(gEgo
						view: 14
						loop: (local5 at: local1)
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(openEffect
					view: 21
					x: global441
					y: global442
					setLoop: 0
					setCel: 0
					signal: 24577
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
					(gEgo setCycle: Beg)
				)
				(soundFX number: 934 play:)
				(= seconds 3)
			)
			(3
				(openEffect dispose:)
				(= cycles 2)
			)
			(4
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 20
						loop: (local4 at: (gEgo loop:))
						cel: (if (< (gEgo loop:) 6) 4 else 5)
					)
				else
					(gEgo normalize: local1)
				)
				(cond
					(
						(not
							(OneOf
								gCurRoomNum
								250
								260
								270
								340
								440
								500
								510
								593
								641
								643
								660
								610
								662
								670
								600
								661
								662
								780
								460
								470
								790
								620
								621
								622
								623
								624
								625
								626
								627
								629
								630
								631
								632
								640
								642
								644
								633
								634
								645
								663
								680
								300
							)
						)
						(gMessager say: 0 0 1 0 self 13) ; "You can't open that."
					)
					(local0
						(local0 doVerb: -80)
						(local3 dispose:)
						(local4 dispose:)
						(local5 dispose:)
					)
					(else
						(gMessager say: 0 0 1 0 self 13) ; "You can't open that."
					)
				)
			)
			(5
				(local3 dispose:)
				(local4 dispose:)
				(local5 dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openEffect of Prop
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
		(if local6
			(self dispose:)
		else
			(if scaler
				(scaler doit:)
			)
			(super doit:)
		)
	)

	(method (dispose)
		(if local6
			(super dispose:)
		else
			(= local6 1)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

