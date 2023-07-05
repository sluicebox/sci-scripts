;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)

(public
	pathToRoadRm 0
)

(instance pathToRoadRm of Rm
	(properties
		picture 74
		north 77
		east 73
		west 75
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 10 (gEgo y:) loop: 0)
			)
			(east
				(gEgo posn: 310 (gEgo y:) loop: 1)
			)
			(else
				(gEgo posn: 123 61 loop: 2)
			)
		)
		(gEgo init:)
		(gAddToPics add: rockPic doit:)
		(self setRegions: 310 311) ; tunisia, guardfReg
	)

	(method (doit)
		(super doit: &rest)
		(if (== (gEgo onControl: 1) 2)
			(self newRoom: north)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(cond
					((Said '[<at,around][/room,scene]')
						(Print 74 0) ; "Looking you see old abandoned dwellings."
					)
					((Said '<down')
						(Print 74 1) ; "The dry parched earth reveals nothing."
					)
					((Said '<up')
						(proc0_36) ; "You see nothing special."
					)
					((Said '/building')
						(Print 74 2) ; "These dilapidated dwellings have long since been abandoned."
					)
					((Said '/pathway')
						(proc0_36) ; "You see nothing special."
					)
				)
			)
		)
	)
)

(instance rockPic of PV
	(properties
		y 154
		x 168
		view 576
		loop 2
		cel 1
	)
)

