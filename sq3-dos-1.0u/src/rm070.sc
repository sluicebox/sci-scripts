;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)
(use Actor)

(public
	rm070 0
)

(instance rm070 of Rm
	(properties
		picture 70
		horizon 70
		north 67
		east 71
		west 69
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 98)
		(super init:)
		(if (not global253)
			(gAddToPics add: ship)
			(gAddToPics doit:)
		)
		(switch gPrevRoomNum
			(67
				(gEgo
					posn:
						(if (> (gEgo x:) 115)
							115
						else
							(gEgo x:)
						)
						(+ (gCurRoom horizon:) 2)
					init:
				)
			)
			(69
				(gEgo
					init:
					posn:
						2
						(cond
							((< (gEgo y:) 85) 72)
							((== (gEgo y:) 86) 88)
							((> (gEgo y:) 166) 166)
							(else
								(gEgo y:)
							)
						)
				)
			)
			(71
				(gEgo
					init:
					posn:
						317
						(cond
							((== (gEgo y:) 84) 83)
							((and (< (gEgo y:) 127) (> (gEgo y:) 115)) 114)
							((> (gEgo y:) 142) 142)
							(else
								(gEgo y:)
							)
						)
				)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== (gCurRoom script:) 0)
			(cond
				((or (== (= temp0 (gEgo onControl:)) 3) (== temp0 7))
					(gEgo
						setPri: 8
						posn: (+ (gEgo x:) 2) (gEgo y:)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== temp0 17)
					(gEgo
						setPri: 13
						posn: (+ (gEgo x:) 2) (gEgo y:)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== temp0 9)
					(gEgo
						setPri: 11
						posn: (+ (gEgo x:) 2) (gEgo y:)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== temp0 5)
					(gEgo
						setPri: 14
						posn: (gEgo x:) (+ (gEgo y:) 2)
						illegalBits: 0
					)
					(= global180 1)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/rock,boulder')
				(Print 70 0) ; "Piles of large volcanic rocks have accumulated here at the base of this volcano."
			)
			((Said 'look/craft,skull,bow')
				(if global253
					(Print 70 1) ; "I don't know about you, but I don't see any ships here."
				else
					(Print 70 2) ; "It's a speedy little short-range skull fighter, fully armed with the latest in offensive weaponry. You probably wouldn't want to tangle with one of these babies."
				)
			)
		)
	)
)

(instance ship of PV
	(properties
		y 135
		x 66
		view 98
		priority 9
		signal 16384
	)
)

