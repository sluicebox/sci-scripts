;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)

(public
	rm071 0
)

(instance rm071 of Rm
	(properties
		picture 71
		north 72
		west 70
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(super init:)
		(switch gPrevRoomNum
			(70
				(gEgo
					init:
					posn:
						2
						(cond
							((== (gEgo y:) 74) 75)
							((and (> (gEgo y:) 87) (< (gEgo y:) 99)) 99)
							((and (> (gEgo y:) 118) (< (gEgo y:) 137)) 137)
							(else
								(gEgo y:)
							)
						)
				)
			)
			(72
				(gEgo
					posn:
						(cond
							((< (gEgo x:) 87) 88)
							((> (gEgo x:) 156) 155)
							(else
								(gEgo x:)
							)
						)
						(+ (gCurRoom horizon:) 10)
					init:
				)
				(gLongSong number: 71 loop: -1 priority: 0 play:)
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
				((== (= temp0 (gEgo onControl:)) 3)
					(gEgo
						setPri: 14
						posn: (gEgo x:) (+ (gEgo y:) 2)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== temp0 5)
					(gEgo
						setPri: 9
						posn: (gEgo x:) (gEgo y:)
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
		(if (Said 'look[/area,around]')
			(Print 71 0) ; "The climb becomes steeper as you near the rim of the old volcano."
		)
	)
)

