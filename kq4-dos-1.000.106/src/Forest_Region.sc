;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 508)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Forest_Region 0
)

(instance Forest_Region of Rgn
	(properties
		name {Forest Region}
	)

	(method (init)
		(if (== (Random 1 5) 4)
			(= gRavenActor (Act new:))
			(gRavenActor
				view: 356
				illegalBits: 0
				ignoreActors:
				setPri: 14
				ignoreHorizon:
				setScript: ravenActions
			)
			(if (== (Random 1 2) 1)
				(gRavenActor
					posn: 5 30
					setCycle: Fwd
					xStep: 5
					yStep: 4
					setMotion: MoveTo 339 20 gRavenActor
					init:
				)
			else
				(gRavenActor
					posn: 314 20
					xStep: 5
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo -20 40 gRavenActor
					init:
				)
			)
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/boulder')
							(Print 508 0) ; "There are rocks here and there."
						)
						((or (Said '/dirt') (Said '/down'))
							(Print 508 1) ; "You see nothing of importance on the ground."
						)
						((Said '/grass')
							(Print 508 2) ; "Pine needles, among the grass, crunch beneath your feet as you walk through the forest."
						)
						((Said '/bush')
							(Print 508 3) ; "You don't see many shrubs here."
						)
						((Said '/flora')
							(Print 508 4) ; "Mostly, you see pine trees."
						)
						((Said '/blossom')
							(Print 508 5) ; "You don't notice many flowers here."
						)
						((Said '/forest')
							(Print 508 6) ; "A forest of pine trees encircles you."
						)
						((Said '/crow,bird,crow')
							(if (gCast contains: gRavenActor)
								(Print 508 7) ; "The raven doesn't look to be a friendly bird at all!"
							else
								(Print 508 8) ; "You see small birds here and there."
							)
						)
					)
				)
				((Said 'climb/boulder')
					(Print 508 9) ; "You don't like to climb rocks."
				)
				((Said 'get/blossom')
					(Print 508 10) ; "There aren't many flowers to pick!"
				)
				((Said 'climb/forest')
					(Print 508 11) ; "It is difficult to climb trees while wearing that dress!"
				)
				((Said 'talk/crow,bird,crow')
					(if (gCast contains: gRavenActor)
						(Print 508 12) ; "Caw, caw!"
					else
						(Print 508 13) ; "Cheep, cheep!"
					)
				)
				((Said 'get,capture/crow,bird,crow')
					(if (gCast contains: gRavenActor)
						(Print 508 14) ; "You wouldn't want it even if you COULD get it!"
					else
						(Print 508 15) ; "That wouldn't accomplish anything."
					)
				)
				((Said 'kiss/crow,bird,crow')
					(if (gCast contains: gRavenActor)
						(Print 508 16) ; "Not this bird!"
					else
						(Print 508 15) ; "That wouldn't accomplish anything."
					)
				)
			)
		)
	)
)

(instance ravenActions of Script
	(properties)

	(method (cue)
		(gRavenActor dispose:)
	)
)

