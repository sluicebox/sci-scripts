;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 519)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Inventory)

(public
	Ocean_Region 0
)

(synonyms
	(flora flora flora blossom flora flora)
	(ocean seawater ocean)
)

(instance Ocean_Region of Rgn
	(properties
		name {Ocean Region}
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'look<in/ocean,water')
						(Said 'look<under/ocean,water')
						(Said 'look<in/water')
						(Said 'look<under/water')
					)
					(Print 519 0) ; "You look under the water, and see nothing but...more water!"
				)
				((Said 'look/fish')
					(cond
						((gEgo has: 24) ; Dead_Fish
							((Inv at: 24) showSelf:) ; Dead_Fish
						)
						((not gNight)
							(Print 519 1) ; "Pretty fish leap playfully around you."
						)
						(else
							(Print 519 2) ; "You don't see any now."
						)
					)
				)
				((Said 'talk/fish')
					(if (not gNight)
						(Print 519 3) ; "Fish usually don't talk."
					else
						(Print 519 4) ; "You don't see any here."
					)
				)
				((Said 'eat,kill,kiss/fish')
					(if (not gNight)
						(Print 519 5) ; "You would have to catch them first."
					else
						(Print 519 4) ; "You don't see any here."
					)
				)
				((or (Said 'get,capture/fish') (Said 'fish[/!*]'))
					(Print 519 6) ; "It's hard to catch fish while swimming."
				)
				((Said 'look/ocean,water')
					(Print 519 7) ; "From your vantage point, you can see only water."
				)
				((Said 'look/sky')
					(if (not gNight)
						(Print 519 8) ; "The bright, blue sky seems to merge as one with the vast ocean before you."
					else
						(Print 519 9) ; "It's easy to see by the light of a full moon."
					)
				)
				((Said 'bathe[/!*]')
					(Print 519 10) ; "You are swimming."
				)
				(
					(or
						(Said 'dive/ocean,water')
						(Said 'dive[/!*]')
						(Said 'bathe<under/ocean,water')
					)
					(Print 519 11) ; "The water is much too deep here."
				)
				((or (Said 'get/drink') (Said 'drink'))
					(Print 519 12) ; "You taste the ocean water. YUCK!! This water's too salty!"
				)
			)
		)
	)
)

