;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room6 0
)

(local
	local0
	local1
)

(instance Room6 of Rm
	(properties
		picture 6
	)

	(method (init)
		(= south 12)
		(= west 5)
		(= horizon 80)
		(= gIndoors 0)
		(if gNight
			(= picture 106)
		)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(self setRegions: 508 511) ; Forest_Region, mountReg
		(switch gPrevRoomNum
			(west
				(cond
					((>= (gEgo y:) 160)
						(gEgo x: 1 y: 160)
					)
					((<= (gEgo y:) 84)
						(gEgo x: 2 y: 84)
					)
					(else
						(gEgo x: 1)
					)
				)
			)
			(south
				(cond
					((>= (gEgo x:) 265)
						(gEgo posn: 265 188)
					)
					((<= (gEgo x:) 100)
						(gEgo posn: 100 188)
					)
					(else
						(gEgo posn: (gEgo x:) 188)
					)
				)
			)
			(57
				(gEgo loop: 1 x: 200 y: 153)
			)
			(0
				(gEgo x: 180 y: 160)
			)
		)
		(= local1 (Prop new:))
		(local1
			view: 628
			loop: 1
			cel: 0
			x: 247
			y: 35
			setCycle: Fwd
			setPri: 15
			cycleSpeed: 2
			init:
		)
		(gEgo xStep: 2 yStep: 1 view: 2 init:)
	)

	(method (doit)
		(super doit:)
		(if (& (= local0 (gEgo onControl: 0)) $0040)
			(= gNewRoomNum 57)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look<in,in,in/cave,skull')
					(Print 6 0) ; "You try to peer into the dark cave, but can make out no details."
				)
				(
					(or
						(Said 'look/room')
						(Said 'look/around')
						(Said 'look[<around][/!*]')
					)
					(Print 6 1) ; "A cave, bearing a slight resemblance to a skull, juts out from the craggy mountainside. Huge rocks block your exit to the north, and you're completely surrounded by those grabby trees! Nice situation, huh?"
				)
				((Said 'look>')
					(cond
						((Said '/cave,skull')
							(Print 6 2) ; "The rocky skull cave juts out from the base of the steep mountainside. Smoke rises lazily from a large crack in the cave's (forehead?)."
						)
						((Said '/grass')
							(Print 6 3) ; "Even grass doesn't grow here."
						)
						((Said '/bush')
							(Print 6 4) ; "There are not many bushes or shrubs here."
						)
						((Said '/flora')
							(Print 6 5) ; "Not many plants grow here; only those awful trees!"
						)
						((Said 'blossom')
							(Print 6 6) ; "There are no flowers here."
						)
						((Said '/forest')
							(Print 6 7) ; "Those are vicious-looking trees, aren't they?"
						)
						((Said '/boulder')
							(Print 6 8) ; "There are large rocks all around you."
						)
						((or (Said '/sky') (Said '<up'))
							(if (not gNight)
								(Print 6 9) ; "In spite of these dreary surroundings, the sky is quite nice and blue."
							else
								(Print 6 10) ; "It's easy to see by the light of a full moon."
							)
						)
					)
				)
				((Said 'get/blossom')
					(Print 6 6) ; "There are no flowers here."
				)
				((Said 'climb/boulder')
					(Print 6 11) ; "The rocks are too large to climb."
				)
				((Said 'look/boulder')
					(Print 6 12) ; "Large boulders block your way to the north."
				)
				((Said 'look/dirt')
					(Print 6 13) ; "You see nothing interesting on the ground."
				)
				((Said 'climb/forest')
					(Print 6 14) ; "You've GOT to be KIDDING!"
				)
				((Said 'kill/forest')
					(Print 6 15) ; "That would be impossible."
				)
			)
		)
	)
)

