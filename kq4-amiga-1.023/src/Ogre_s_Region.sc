;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 517)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Ogre_s_Region 0
)

(synonyms
	(kiss kiss embrace)
	(giant giant giant giant man giant)
)

(instance Ogre_s_Region of Rgn
	(properties
		name {Ogre's Region}
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (gCast contains: global121))
			(cond
				((Said 'look/giant')
					(Print 517 0) ; "The ogre looks MEAN!! Better get out of there...FAST!!"
				)
				((Said 'talk')
					(Print 517 1) ; "This is no time for conversation!"
				)
				((Said 'kill/giant')
					(Print 517 2) ; "You have no way of killing a giant ogre!"
				)
				((Said 'get,capture/giant')
					(Print 517 3) ; "That's ridiculous!"
				)
				((Said 'kiss')
					(Print 517 4) ; "He wouldn't like it, and neither would you!"
				)
				((Said 'give>')
					(if
						(and
							(= temp0 (gInventory saidMe:))
							(gEgo has: (gInventory indexOf: temp0))
						)
						(Print 517 5) ; "You don't want to get that close to the ogre!"
					else
						(Print 517 6) ; "You don't have it."
					)
				)
			)
		)
	)
)

