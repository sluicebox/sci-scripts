;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	playTheFlute 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance playTheFlute of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame killSound: 1)
				(if (< (* (/ (gEgo scaleY:) 128) 100) 80)
					(= local5 1)
				)
				(if (gGame isHandsOn:)
					(gGame handsOff:)
					(= local4 1)
				)
				(= cycles 2)
			)
			(1
				(= local0 (gEgo cel:))
				(= ticks 6)
			)
			(2
				(gEgo normal: 0 view: 920 cel: 0 cycleSpeed: 6)
				(cond
					((< (gEgo heading:) 136)
						(= local3 0)
						(= local2 -2)
						(= local1 0)
						(gEgo
							setLoop: 0
							posn: (gEgo x:) (+ (gEgo y:) 2)
						)
					)
					((< (gEgo heading:) 260)
						(= local3 2)
						(if local5
							(= local2 0)
							(= local1 -3)
							(gEgo
								setLoop: 2
								posn: (+ (gEgo x:) 3) (gEgo y:)
							)
						else
							(= local1 0)
							(= local2 -1)
							(gEgo
								setLoop: 2
								posn: (gEgo x:) (+ (gEgo y:) 1)
							)
						)
					)
					(else
						(= local3 1)
						(= local1 -2)
						(= local2 -1)
						(gEgo
							setLoop: 1
							posn: (+ (gEgo x:) 2) (+ (gEgo y:) 1)
						)
					)
				)
				(= cycles 4)
			)
			(3
				(localMusic number: 942 setLoop: 1 play: self)
				(gEgo setCycle: Fwd)
			)
			(4
				(gEgo
					reset: local0
					posn: (+ (gEgo x:) local1) (+ (gEgo y:) local2)
				)
				(= cycles 4)
			)
			(5
				(if local4
					(gMessager say: 1 31 0 1 self 0) ; "Alexander plays a lovely little tune on the flute."
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(localMusic stop: dispose:)
				(gGame killSound: 0)
				(self dispose:)
				(DisposeScript 85)
			)
		)
	)
)

(instance localMusic of Sound
	(properties)
)

