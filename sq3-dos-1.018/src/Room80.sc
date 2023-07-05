;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	Room80 0
)

(instance Room80 of Rm
	(properties
		picture 80
	)

	(method (init)
		(= north (= west (= south (= east 81))))
		(= horizon 55)
		(super init:)
		(NormalEgo)
		(gEgo view: 63)
		(switch gPrevRoomNum
			(14
				(gEgo posn: 180 135 init:)
				(gCurRoom setScript: Actions)
			)
			(81
				(gEgo posn: global112 global113 loop: global107)
			)
			(85
				(if (== global105 1)
					(gEgo view: 123)
				)
				(gEgo posn: 1 144)
				(= global114 5)
				((ScriptID 503) notify:) ; PestRegion
			)
			(else
				(gEgo view: 0 posn: 160 188)
			)
		)
		(gEgo init:)
		(if (== global105 1)
			(Print 80 0) ; "Seeing no immediate need to remain invisible, you turn off the belt."
			(= global105 0)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			((> (gEgo x:) 317)
				(= global112 317)
				(= global113 (gEgo y:))
				(= global107 1)
			)
			((> (gEgo y:) 187)
				(= global113 186)
				(= global112 (gEgo x:))
				(= global107 3)
			)
			((< (gEgo x:) 2)
				(= global112 3)
				(= global113 (gEgo y:))
				(= global107 0)
			)
			(else
				(= global112 (gEgo x:))
				(= global113 (+ horizon 3))
				(= global107 2)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (and (& (gEgo onControl: 0) $0040) (== (gCurRoom script:) 0))
			(gCurRoom newRoom: 14)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 80 1) ; ""What a peaceful planet for a software company" you think to yourself. What a shame it had to be ScumSoft. You are surrounded by what can only be described as tree-like growths towering high above you. The turf has a mossy texture."
						)
						((Said '/tree')
							(Print 80 2) ; "The trees are strangely twisted."
						)
						((Said '/rock,banner,boulder')
							(Print 80 3) ; "What looks to be large blue boulders are actually mushroom- like parasitic growths at the base of some of the trees. Never caring much for mushrooms you leave them alone."
						)
						((Said '/craft')
							(Print 80 4) ; "You proudly look upon your newly acquired spacecraft, the Aluminum Mallard. Truly a fine piece of jun...uh.. machinery."
						)
						((or (Said '<up') (Said '/air'))
							(Print 80 5) ; "The vibrant colors of the pestulonian sky remind you of your home planet of Xenon. Suddenly, you feel quite home sick."
						)
						((or (Said '<down') (Said '/dirt,pass'))
							(Print 80 6) ; "The mossy surface squishes with each step you take."
						)
					)
				)
				((Said 'get,get/rock,banner')
					(Print 80 7) ; "They're just here for looks so leave them alone, ok?"
				)
				((Said 'climb/tree')
					(Print 80 8) ; "There is no need to do that."
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 202 160 self)
			)
			(1
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

