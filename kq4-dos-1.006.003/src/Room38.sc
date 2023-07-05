;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use Actor)

(public
	Room38 0
)

(local
	local0
	local1
	local2
	local3
)

(instance Room38 of Rm
	(properties
		picture 38
	)

	(method (init)
		(= north 35)
		(= south 41)
		(= west 37)
		(= horizon 74)
		(= gIndoors 0)
		(if gNight
			(= picture 138)
		)
		(super init:)
		(self setRegions: 505) ; gfReg
		(gEgo view: 2 xStep: 3 yStep: 2 init:)
		(= local0 (Prop new:))
		(= local1 (Prop new:))
		(= local2 (Extra new:))
		(= local3 (Extra new:))
		(local0
			view: 662
			loop: 3
			cel: 0
			posn: 199 74
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local1
			view: 662
			loop: 4
			cel: 3
			posn: 303 98
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local2
			view: 341
			loop: 2
			posn: 243 37
			minPause: 4
			maxPause: 60
			pauseCel: 1
			minCycles: 10
			maxCycles: 40
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local3
			view: 341
			loop: 3
			pauseCel: 1
			minPause: 4
			maxPause: 60
			minCycles: 10
			maxCycles: 50
			posn: 214 26
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(cond
			((== gPrevRoomNum 35)
				(gEgo x: 196 y: 78)
			)
			((== gPrevRoomNum 41)
				(gEgo x: 159 y: 187)
			)
		)
	)

	(method (dispose)
		(DisposeScript 988)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/bush')
							(Print 38 0) ; "A lovely hedge surrounds this island garden."
						)
						((Said '/beach')
							(Print 38 1) ; "You can see the beach in the distance."
						)
						((Said '/dirt')
							(Print 38 2) ; "You see nothing but grass on the ground."
						)
						((Said '/grass')
							(Print 38 3) ; "The grass looks well-tended and manicured."
						)
						((Said '/flora')
							(Print 38 4) ; "The foliage grows luxuriantly here."
						)
						((Said '/blossom')
							(Print 38 5) ; "You see lovely beds of well-tended flowers."
						)
						((Said '/forest')
							(Print 38 6) ; "You see many unusual and lovely trees on this island."
						)
						((Said '/garden')
							(Print 38 7) ; "The beautiful garden gives you a sense of peaceful serenity."
						)
						((Said '/path')
							(Print 38 8) ; "A nice flagstone path circles the statue."
						)
						((Said '/castle')
							(Print 38 9) ; "The lovely ivory palace rises majestically beside you."
						)
						((Said '/ocean')
							(Print 38 10) ; "You can see the ocean in the distance."
						)
						((Said '/bird')
							(Print 38 11) ; "There are many exotic birds on this island."
						)
						((Said '/monument,dolphin')
							(Print 38 12) ; "Depicted in the statue: a pair of dolphins leap gracefully from a wave."
						)
						((Said '[<around][/island,room]')
							(Print 38 13) ; "You are roaming through the wonderful island garden. Towering beside you is an enchanting ivory palace. You see an interesting statue within this part of the garden."
						)
					)
				)
				((Said 'talk/bird')
					(Print 38 14) ; "Cheep, cheep!"
				)
				((Said 'capture,get/bird')
					(Print 38 15) ; "You can't catch the birds."
				)
				((Said 'kiss/bird')
					(Print 38 16) ; "You'd have to catch the bird first."
				)
				((Said 'get/blossom')
					(Print 38 17) ; "It would waste your precious time to stop and pick flowers."
				)
			)
		)
	)
)

