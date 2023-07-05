;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Osc)
(use Motion)
(use Actor)
(use System)

(public
	castOpenScript 0
)

(local
	local0
	[local1 8] = [0 0 0 1 0 0 2 3]
	[local9 4] = [2 3 6 7]
	[local13 8] = [2 3 0 3 0 1 2 3]
	local21
	local22
)

(instance castOpenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) global386 global387)
						self
				)
			)
			(1
				(= local21 (gEgo loop:))
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local22 (gEgo cel:))
					(gEgo view: 19 loop: [local1 local21] setCycle: End self)
				else
					(gEgo
						view: 15
						loop: [local13 local21]
						setCycle: End self
					)
				)
			)
			(2
				(openEffect
					x: global386
					y: global387
					setScale: -1 gEgo
					cycleSpeed: 0
					priority: 15
					init:
					setCycle: Osc 4 self
				)
				(if register
					(= local0 (register onMe: global386 global387))
				)
				(if
					(not
						(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
						)
					)
					(gEgo setCycle: Beg)
				)
				(gLongSong2 number: 900 setLoop: 1 play:)
			)
			(3
				(openEffect dispose:)
				(= cycles 2)
			)
			(4
				(cond
					(
						(not
							(OneOf
								gCurRoomNum
								230
								310
								380
								430
								450
								640
								650
								700
								810
								820
								853
							)
						)
						(gMessager say: 0 0 1 1 0 13) ; "You can't open that."
					)
					((and register local0)
						(register doVerb: -75)
					)
				)
				(HandsOn)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 20
						loop: [local9 (gEgo loop:)]
						cel: (if (< (gEgo loop:) 6) 4 else 5)
					)
				else
					(gEgo normalize:)
				)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= local0 (= register 0))
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance openEffect of Prop
	(properties
		view 21
		signal 24592
	)
)

