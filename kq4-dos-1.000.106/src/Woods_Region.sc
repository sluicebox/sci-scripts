;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 507)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Woods_Region 0
)

(local
	local0
)

(instance Woods_Region of Rgn
	(properties
		name {Woods Region}
	)

	(method (init)
		(if (== (Random 1 5) 4)
			(= gRavenActor (Act new:))
			(gRavenActor
				view: 356
				ignoreHorizon:
				illegalBits: 0
				ignoreActors:
				setPri: 14
				setScript: ravenActions
			)
			(if (== (Random 1 2) 1)
				(gRavenActor
					posn: 5 30
					xStep: 5
					yStep: 4
					setCycle: Fwd
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
							(Print 507 0) ; "Small rocks lie among the trees."
						)
						((Said '/flora')
							(Print 507 1) ; "Green grass carpets the woods."
						)
						((Said '/dirt,down')
							(Print 507 2) ; "You see nothing of importance on the ground."
						)
						((Said '/bush')
							(Print 507 3) ; "There are not many bushes in these woods."
						)
						((Said '/grass')
							(Print 507 4) ; "Soft grass cushions your walk through these woods."
						)
						((Said '/blossom')
							(Print 507 5) ; "You don't notice many flowers here."
						)
						((Said '/forest')
							(Print 507 6) ; "The trees are numerous in these woods."
						)
						((Said '/crow,bird,crow')
							(if (gCast contains: gRavenActor)
								(Print 507 7) ; "The raven doesn't look to be a friendly bird at all!"
							else
								(Print 507 8) ; "You see small birds here and there."
							)
						)
					)
				)
				((Said 'climb/boulder')
					(Print 507 9) ; "You don't like to climb rocks."
				)
				((Said 'get/blossom')
					(Print 507 10) ; "There aren't many flowers to pick!"
				)
				((Said 'climb/forest')
					(Print 507 11) ; "It is difficult to climb trees while wearing that dress!."
				)
				((Said 'talk/crow,bird,crow')
					(if (gCast contains: gRavenActor)
						(Print 507 12) ; "Caw! Caw!"
					else
						(Print 507 13) ; "Cheep, cheep!"
					)
				)
				((Said 'get,capture/crow,bird,crow')
					(if (gCast contains: gRavenActor)
						(Print 507 14) ; "You wouldn't want it even if you COULD get it!"
					else
						(Print 507 15) ; "That wouldn't accomplish anything."
					)
				)
				((Said 'kiss/crow,bird,crow')
					(if (gCast contains: gRavenActor)
						(Print 507 16) ; "Not this bird!"
					else
						(Print 507 15) ; "That wouldn't accomplish anything."
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

