;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Interface)
(use Game)

(public
	swampReg 0
)

(synonyms
	(bayou water)
	(get capture)
)

(instance swampReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said '/fish,alligator,turtle,frog>')
						(Said '//fish,alligator,turtle,frog>')
					)
					(event claimed: 1)
					(Print 205 0) ; "You don't see any here, but the dark water may be concealing them."
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room,bayou,bayou]')
							(Print 205 1) ; "Misty bayou waters surround this old plantation, cutting it off from the rest of the world. Better watch your step around here!"
						)
						((Said '/oak')
							(Print 205 2) ; "Spanish moss drips eerily from the forest of swamp trees. Not far off, the trees vanish as a heavy mist engulfs them."
						)
						((Said '/foliage')
							(Print 205 3) ; "Reeds, marsh grass, water lilies; many plants abound in the swamp."
						)
						((Said '/blossom')
							(Print 205 4) ; "You see water flowers poking up from the bayou here and there."
						)
						((Said '/bush')
							(Print 205 5) ; "Bushes skirt the edge of the swamp."
						)
						((Said '/moss')
							(Print 205 6) ; "The Spanish moss seems thicker here in the swamp."
						)
						((Said '/fog')
							(Print 205 7) ; "Mist drifts eerily across the dark bayou."
						)
					)
				)
				(
					(or
						(Said 'bathe,dive,wade')
						(Said 'cross,enter,go,hop,dive,(get<in)/bayou,brook')
					)
					(Print 205 8) ; "Go ahead. Just enter the water."
				)
				((or (Said 'drink[/bayou[<bayou]]') (Said 'get/drink[/bayou]'))
					(Print 205 9) ; "The swamp water doesn't look very enticing to drink."
				)
				((Said 'get>')
					(cond
						((Said '/foliage')
							(Print 205 10) ; "You see no plants that interest you."
						)
						((Said '/blossom')
							(Print 205 11) ; "You have no interest in obtaining swamp flowers."
						)
						((Said '/moss[<oak]')
							(Print 205 12) ; "Even though the Spanish moss looks interesting, you can think of no use for it."
						)
						((Said '/weed')
							(Print 205 13) ; "You're not interested in weeds."
						)
						((Said '/bayou')
							(Print 205 14) ; "You have no need to carry water."
						)
					)
				)
				((Said 'climb/oak')
					(Print 205 15) ; "That's NOT a good idea!"
				)
			)
		)
	)
)

