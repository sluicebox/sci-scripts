;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use AutoDoor)
(use Interface)
(use Game)
(use System)

(public
	rm240 0
)

(local
	seenMsg
)

(instance rm240 of Rm
	(properties
		picture 240
		horizon 66
		north 245
		east 245
		west 230
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(aDoor locked: (or (!= gEgoState 0) gEgoIsPatti) init:)
		(cond
			((== gPrevRoomNum 230)
				(gEgo x: 1)
			)
			((== gPrevRoomNum 340)
				(gEgo posn: 53 77 loop: 2)
			)
			(else
				(gEgo posn: 292 73)
			)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl:) $0002) (or gEgoIsPatti (!= gEgoState 0)))
			(if (not seenMsg)
				(= seenMsg 1)
				(gEgo
					posn: (gEgo xLast:) (gEgo yLast:)
					setMotion: 0
					observeControl: 2
				)
				(if gEgoIsPatti
					(Print 240 0) ; "The world-famous "Comedy Hut" is presently closed."
				else
					(Print 240 1) ; "The world-famous "Comedy Hut's" strict dress code policy prohibits you from enjoying them at this time."
				)
				(Animate (gCast elements:) 0)
			)
		else
			(= seenMsg 0)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,look>')
			(cond
				((Said '/club,comedy,building')
					(Print 240 2) ; "You might try walking inside."
				)
				((Said '/door')
					(if gEgoIsPatti
						(Print 240 3) ; "The door is locked."
					else
						(Print 240 4) ; "It's unlocked; why not walk inside."
					)
				)
				((Said '[/area]')
					(Print 240 5) ; "You are outside the world-famous "Comedy Hut," the fast-food of comedy clubs!"
					(if gEgoIsPatti
						(Print 240 6) ; "They are presently closed."
					else
						(Print 240 7) ; "They appear to be open."
					)
				)
			)
		)
	)
)

(instance aDoor of AutoDoor
	(properties
		y 66
		x 53
		view 240
		entranceTo 340
	)
)

