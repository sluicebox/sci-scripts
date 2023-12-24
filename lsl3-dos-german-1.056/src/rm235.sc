;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	rm235 0
)

(instance rm235 of Rm
	(properties
		picture 235
		west 230
	)

	(method (init)
		(if (InRoom 11)
			(Load rsVIEW 236)
		)
		(super init:)
		(self setRegions: 41 setScript: RoomScript) ; rm41
		(gEgo posn: 43 124 loop: 0 init:)
		(NormalEgo)
		(if gEgoState
			(gEgo observeControl: 2)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(if (and (& (gEgo onControl:) $0002) (== gEgoState 0))
			(Notify 41 2 300)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look<up')
				(Print 235 0) ; "From in here, you can barely see the sky."
			)
			((Said 'look,look<down')
				(Print 235 1) ; "Just step closer to the edge of the cliff."
				(Print 235 2 #at -1 144) ; "(Heh, heh, heh.)"
			)
			((Said 'look,look>')
				(cond
					((Said '[/area]')
						(Print 235 3) ; "You are in a small opening in the side of the volcano, far above the trail you left. In the distance, Nontoonyt Lagoon glistens greasily in the sunlight."
					)
					((Said '/carpet,carpet')
						(Print 235 4) ; "A few hardy weeds attempt to grow in solid rock."
					)
					((Said '/ceiling,air')
						(Print 235 0) ; "From in here, you can barely see the sky."
					)
					((Said '/camp,beach,bay,water')
						(Print 235 5) ; "From here you have a spectacular view of the beach, but you are too far from the edge to see the city."
						(Print 235 2 #at -1 144) ; "(Heh, heh, heh.)"
					)
					((Said '/plant,bush')
						(Print 235 6) ; "There are a few weeds growing in the floor, but a beautiful display of orchids climbing the righthand wall."
					)
					((Said '/flower,boulder,wall')
						(Print 235 7) ; "Garlands of wild orchids festoon the otherwise bare rock walls. You bet your F.T.D. man wishes he were here!"
					)
				)
			)
			((Said 'get,get/plant,bush')
				(Print 235 8) ; "The only plants here that catch your eye are the orchids growing on the walls."
			)
			((Said 'get,get,pick/flower')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(gEgoIsPatti
						(Print 235 9) ; "You have no use for any other orchids, Patti; you'll always cherish those Larry gave you."
					)
					(
						(and
							(not (& (gEgo onControl:) $0004))
							(not (& (gEgo onControl:) $0008))
						)
						(Print 235 10) ; "Move closer to the flowers near the cave opening. They are more beautiful since they catch more light."
					)
					((and (== gCurTimer 1) (== gRgTimer 0))
						(self changeState: 1)
					)
					((not (InRoom 11))
						(Print 235 11) ; "You need no more orchids."
					)
					(else
						(self changeState: 1)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion:
						MoveTo
						(if (& (gEgo onControl:) $0008) 99 else 235)
						96
						self
				)
			)
			(2
				(gEgo
					get: 11 ; some_Orchids
					view: 236
					loop: (if (< (gEgo x:) 160) 1 else 0)
					cel: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= cycles 44)
			)
			(3
				(cond
					((and (== gCurTimer 1) (== gRgTimer 0))
						(Print 235 12) ; "Yeah, good idea. Those ones you picked before were getting pretty droopy."
					)
					((TestFlag 54)
						(Print 235 13) ; "Fortunately for you, there are plenty of orchids available."
					)
					(else
						(SetFlag 54) ; scoredOrchids
						(gGame changeScore: 25)
						(Print 235 14) ; "You pluck a few fresh orchids from the walls of the crevice."
					)
				)
				(NormalEgo)
				(SetRgTimer 1 10 0)
				((Inv at: 11) view: 11) ; some_Orchids
			)
		)
	)
)

