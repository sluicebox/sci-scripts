;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	regOgreHouse 0
)

(synonyms
	(giantess fuck giantess woman)
)

(instance regOgreHouse of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(= keep 1)
		(super init:)
		(if (not global166)
			(self setScript: ogreHere)
		)
		(= global189 1)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(if (== keep 0)
			(= global189 0)
			(super dispose:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 49) (== gCurRoomNum 48) (== (ogreHere state:) 0))
			(ogreHere seconds: 90)
		)
		(if (and (== newRoomNumber 51) (gEgo has: 33)) ; Magic_Hen
			(ogreHere changeState: 3)
		)
	)
)

(instance ogreHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 50)
			)
			(1
				(if (and (!= gCurRoomNum 51) (!= gCurRoomNum 48))
					(Print 602 0 #time 5) ; "The ogre is coming!"
				)
				(if (== gCurRoomNum 48)
					(= seconds 60)
				else
					(= seconds 10)
				)
			)
			(2
				(= global165 1)
				(if (== gCurRoomNum 51)
					(Print 602 1) ; "You hear the ogre in the house."
					(= seconds 60)
				)
			)
			(3
				(if (not global166)
					(= global165 2)
					(if (== gCurRoomNum 51)
						(Print 602 2) ; "You hear noises on the other side of the door."
					)
				)
				(= seconds 60)
			)
			(4
				(if (and (== gCurRoomNum 51) (not global166))
					(= global165 5)
					(Print 602 3) ; "You hear the ogre leaving."
				)
			)
		)
	)
)

