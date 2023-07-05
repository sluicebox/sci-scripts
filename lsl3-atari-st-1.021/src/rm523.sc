;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 523)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm523 0
)

(instance rm523 of Rm
	(properties
		picture 523
		west 520
	)

	(method (init)
		(super init:)
		(self setRegions: 41 setScript: RoomScript) ; rm41
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(if (and (& (gEgo onControl:) $0002) (== gEgoState 0))
			(Notify 41 2 188)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'use,attach/bra')
				(cond
					((not (gEgo has: 16)) ; Bra
						(DontHave) ; "You don't have it."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Print 523 0) ; "You briefly consider using your bra to lower yourself over the cliff, but decide it's just too small to do any good. Perhaps it will be more useful later."
					)
				)
			)
			((Said 'use,attach/hose')
				(if (not (gEgo has: 15)) ; Pantyhose
					(Print 523 1) ; "A good idea, but you forgot to wear your pantyhose when you got dressed back at the casino."
				else
					(Print 523 2) ; "A good idea, but there are no rocks here with a shape suitable for an anchor."
				)
			)
			((Said 'look>')
				(cond
					((Said '/boulder')
						(Print 523 3) ; "What unusual rock formations the lava flows have left around here."
					)
					((Said '[/area]')
						(Print 523 4) ; "A dangerous cliff may be directly north of you."
					)
				)
			)
			((Said '(up<climb),climb/boulder,arch')
				(Print 523 5) ; "There is no way you could climb up that arch! It will never help you, Patti."
			)
			((or (Said '(climb,go)<(down,above)') (Said 'decrease/me'))
				(Print 523 6) ; "Yes, but how?"
			)
			((Said 'climb')
				(Print 523 7) ; "You MIGHT be able to climb down this cliff. Try moving closer to the edge."
				(Print 523 8 #at -1 144) ; "(Will you really "fall" for this old joke?)"
			)
			((Said 'pull,grasp,get/bush,hemp')
				(Print 523 9) ; "The flowering vines are not sturdy enough to support you."
			)
			((Said 'get,use/palm')
				(Print 523 10) ; "The trees here are not close enough to the edge of the cliff to aid your descent."
			)
			((Said '/bush')
				(Print 523 11) ; "The plants here are of no use to you."
			)
			((Said '/arch')
				(Print 523 12) ; "The arch is impossible to climb."
			)
			((Said '/flower')
				(Print 523 13) ; "The flowers are pretty, but unnecessary."
			)
			((Said 'jump')
				(Print 523 14) ; "It is unnecessary to jump off this cliff. Just walk a little closer to the edge."
			)
		)
	)
)

