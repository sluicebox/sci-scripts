;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)

(public
	netToPierRm 0
)

(instance netToPierRm of Rm
	(properties
		picture 54
		north 71
		east 47
		south 47
		west 45
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(45 ; netBeachRm
				(gEgo
					illegalBits: $8000
					loop: 0
					posn: 10 (gEgo y:)
					setMotion: MoveTo 325 (gEgo y:)
				)
			)
			(else
				(gEgo
					illegalBits: $8000
					loop: 1
					posn: 285 100
					setMotion: MoveTo 150 100
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'bind,hide,adjust,drop,park/vehicle,diver')
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(Print 46 0) ; "You can't hide it here. It would be seen from the surface."
				else
					(Print 46 1) ; "You don't have it."
				)
			)
			((Said 'look')
				(Print 46 2) ; "Looking around, you see nothing but rocks, plants, fish, and the surface."
				(Print 46 3) ; "You realize that anyone along the shore would probably see you and that time is of the essence."
			)
		)
	)
)

