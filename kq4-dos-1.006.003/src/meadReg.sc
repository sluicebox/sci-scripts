;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 506)
(include sci.sh)
(use Interface)
(use Game)

(public
	meadReg 0
)

(synonyms
	(flora flora flora blossom flora flora)
)

(local
	[local0 7]
)

(instance meadReg of Rgn
	(properties)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/bush')
							(Print 506 0) ; "Small, low bushes dot the pretty meadow. Wildflowers grow among them."
						)
						((Said '/boulder')
							(Print 506 1) ; "Scattered rocks lie among the wildflowers of the meadow."
						)
						((or (Said '<down') (Said '/dirt,down'))
							(Print 506 2) ; "You look at the ground and see nothing but green grass and wildflowers."
						)
						((Said '/grass')
							(Print 506 3) ; "Green grass carpets this lovely meadowland."
						)
						((Said '/flora')
							(Print 506 4) ; "Colorful wildflowers grow among the small rocks and bushes of the meadowland."
						)
						((Said '/forest')
							(Print 506 5) ; "You see very few trees."
						)
					)
				)
				((Said 'climb>')
					(cond
						((Said '/forest')
							(Print 506 6) ; "It is difficult to climb trees while wearing that dress!"
						)
						((Said '/boulder')
							(Print 506 7) ; "You don't like to climb rocks."
						)
					)
				)
				((Said 'get/flora,flora')
					(Print 506 8) ; "It would waste your precious time to stop and pick flowers."
				)
			)
		)
	)
)

