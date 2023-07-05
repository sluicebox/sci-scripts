;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room_36 0
)

(synonyms
	(lake pool lake)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance Room_36 of Rm
	(properties
		name {Room 36}
		picture 36
	)

	(method (init)
		(= north 33)
		(= south 39)
		(= east 37)
		(= horizon 75)
		(= gIndoors 0)
		(super init:)
		(self setRegions: 505) ; gfReg
		(Load rsVIEW 345)
		(Load rsVIEW 21)
		(Load rsVIEW 2)
		(= local2 (Prop new:))
		(= local3 (Prop new:))
		(= local4 (Prop new:))
		(= local5 (Prop new:))
		(= local6 (Prop new:))
		(= local7 (Prop new:))
		(local2
			isExtra:
			view: 650
			loop: 5
			cel: 0
			posn: 156 119
			setPri: 8
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local3
			isExtra:
			view: 650
			loop: 6
			cel: 3
			posn: 218 131
			setPri: 9
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local4
			isExtra:
			view: 663
			loop: 0
			cel: 1
			posn: 114 69
			setPri: 3
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local5
			isExtra:
			view: 663
			loop: 1
			cel: 1
			posn: 23 82
			setPri: 4
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local6
			isExtra:
			view: 663
			loop: 2
			cel: 3
			posn: 12 94
			setPri: 5
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local7
			view: 341
			loop: 4
			cel: 2
			posn: 84 31
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(gEgo view: 2 xStep: 2 yStep: 1 init:)
		(self setScript: Ego_drinking_water)
		(if gNight
			(= picture 136)
		)
		(cond
			((== gPrevRoomNum 33)
				(gEgo posn: 105 77)
			)
			((== gPrevRoomNum 39)
				(gEgo x: 165 y: 187)
			)
		)
		(= local0 (Act new:))
		(local0
			posn: 188 120
			view: 345
			setCycle: Walk
			moveSpeed: 2
			setMotion: Wander
			illegalBits: -32767
			xStep: 1
			yStep: 1
			init:
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (== (event type:) evSAID)
			(cond
				((Said 'give>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 36 0) ; "That wouldn't accomplish anything."
						else
							(DontHave) ; "You don't have it."
						)
					)
				)
				(
					(or
						(Said 'enter,capture/fish')
						(Said 'fish[/!*]')
						(Said 'cast/pole')
					)
					(Print 36 1) ; "You don't see any fish here."
				)
				((Said 'look>')
					(cond
						((Said '<in/lake,water')
							(Print 36 2) ; "You peer down into the pond, but do not see anything of interest."
						)
						((Said '<under/bridge')
							(Print 36 3) ; "There is nothing of interest under the bridge."
						)
						((Said '/beach')
							(Print 36 4) ; "You can see the beach in the distance."
						)
						((Said '/bush')
							(Print 36 5) ; "A lovely hedge surrounds this island garden."
						)
						((Said '/dirt')
							(Print 36 6) ; "You see nothing but grass on the ground."
						)
						((Said '/grass')
							(Print 36 7) ; "The grass looks well-tended and manicured."
						)
						((Said '/flora')
							(Print 36 8) ; "The foliage grows luxuriantly here."
						)
						((Said '/blossom')
							(Print 36 9) ; "You see lovely beds of well-tended flowers."
						)
						((Said '/forest')
							(Print 36 10) ; "You see many unusual and lovely trees on this island."
						)
						((Said '/garden')
							(Print 36 11) ; "The beautiful garden gives you a sense of peaceful serenity."
						)
						((Said '/lake,water')
							(Print 36 12) ; "A lovely bridge is reflected in the mirror-like, little pond. A majestic white swan floats upon it."
						)
						((Said '/bridge')
							(Print 36 13) ; "The swan-carved bridge arches elegantly over the little pond."
						)
						((Said '/path')
							(Print 36 14) ; "A nice flagstone path circles the pond."
						)
						((Said '/bench')
							(Print 36 15) ; "A garden bench rests near the small pond."
						)
						((Said '/castle')
							(Print 36 16) ; "The lovely ivory palace rises majestically beside you."
						)
						((Said '/ocean')
							(Print 36 17) ; "You can see the ocean in the distance."
						)
						((Said '/swan')
							(Print 36 18) ; "A beautiful white swan floats gracefully upon the little pond."
						)
						((Said '/parrot,bird,cockatoo')
							(Print 36 19) ; "There are many exotic birds on this island."
						)
						((Said '[<around][/room,island]')
							(Print 36 20) ; "You are standing in the lovely garden of this enchanted island. Beside you, rises a grand ivory palace. Within this garden, a bridge, emblazoned with the figures of swans, arches over a little pond. A beautiful white swan floats serenely upon it."
						)
					)
				)
				((Said 'get,capture/bird,parrot,cockatoo')
					(Print 36 0) ; "That wouldn't accomplish anything."
				)
				((Said 'talk/bird,parrot,cockatoo')
					(Print 36 21) ; "Polly want a cracker?"
				)
				((Said 'get/blossom')
					(Print 36 22) ; "It would waste your precious time to stop and pick flowers."
				)
				((Said 'wade,bathe,dive')
					(Print 36 23) ; "You don't want to disturb the serenity of the pond."
				)
				((Said 'get/water')
					(Print 36 24) ; "There's no reason to carry water."
				)
				((or (Said 'drink') (Said 'get/drink'))
					(if (& (= local1 (NearControl gEgo 15)) $0002)
						(Ego_drinking_water changeState: 1)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'sit')
					(Print 36 25) ; "Not now! You have too many things to do."
				)
				((Said 'talk/swan')
					(Print 36 26) ; "You can't talk to a swan!"
				)
				((Said 'talk/parrot,bird,cockatoo')
					(Print 36 27) ; "Polly want a cracker!"
				)
				((Said 'get,capture/swan')
					(Print 36 28) ; "You don't need the swan."
				)
				((Said 'kiss')
					(Print 36 29) ; "There's no need for that."
				)
			)
		)
	)
)

(instance Ego_drinking_water of Script
	(properties
		name {Ego drinking water}
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo setMotion: 0 view: 21 cel: 0 setCycle: End self)
			)
			(2
				(= global120 (Print 36 30 #at -1 20 #dispose)) ; "You bend over and take a drink of the pond water. Yuck! It may look pretty, but it doesn't taste very good!"
				(Timer setReal: self 5)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 2 setCycle: Walk)
				(cls)
				(HandsOn)
			)
		)
	)
)

