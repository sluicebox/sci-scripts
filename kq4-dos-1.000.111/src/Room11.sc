;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room11 0
)

(local
	[local0 12]
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
)

(instance walkingMusic of Sound
	(properties)
)

(instance Room11 of Rm
	(properties
		picture 11
	)

	(method (init)
		(= north 5)
		(= south 17)
		(= east 12)
		(= west 10)
		(= horizon 86)
		(= gIndoors 0)
		(if gNight
			(= picture 111)
		)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(self setRegions: 509) ; sForReg
		(for ((= local12 1)) (<= local12 11) ((++ local12))
			(= [local0 local12] (Prop new:))
		)
		([local0 1]
			view: 692
			loop: 0
			cel: 0
			posn: 145 77
			setPri: 4
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 2]
			view: 692
			loop: 1
			cel: 0
			posn: 152 84
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 3]
			view: 692
			loop: 2
			cel: 0
			posn: 167 84
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 4]
			view: 692
			loop: 3
			cel: 0
			posn: 196 71
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 5]
			view: 692
			loop: 4
			cel: 0
			posn: 213 67
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 6]
			view: 692
			loop: 5
			cel: 0
			posn: 258 77
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 7]
			view: 692
			loop: 6
			cel: 0
			posn: 305 71
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 8]
			view: 693
			loop: 0
			cel: 0
			posn: 81 106
			setPri: 11
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 9]
			view: 693
			loop: 1
			cel: 0
			posn: 242 87
			setPri: 11
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 10]
			view: 693
			loop: 2
			cel: 0
			posn: 256 86
			setPri: 11
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 11]
			view: 694
			loop: 0
			cel: 0
			posn: 281 66
			setPri: 11
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		(= local14 (Prop new:))
		(= local15 (Prop new:))
		(= local16 (Prop new:))
		(= local17 (Prop new:))
		(= local18 (Prop new:))
		(local14
			view: 689
			loop: 2
			cel: 2
			posn: 105 63
			setPri: 10
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local15
			view: 689
			loop: 3
			cel: 3
			posn: 160 84
			setPri: 7
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local16
			view: 689
			loop: 4
			cel: 2
			posn: 249 84
			setPri: 10
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local17
			view: 689
			loop: 5
			cel: 3
			posn: 280 53
			setPri: 10
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local18
			view: 689
			loop: 6
			cel: 0
			posn: 314 49
			setPri: 10
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(switch gPrevRoomNum
			(10
				(if (<= (gEgo y:) horizon)
					(gEgo posn: 1 (+ horizon 2))
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(12
				(gEgo posn: 318 (gEgo y:))
			)
			(17
				(cond
					((>= (gEgo x:) 277)
						(gEgo x: 277 y: 188)
					)
					((<= (gEgo x:) 103)
						(gEgo x: 103 y: 188)
					)
					(else
						(gEgo y: 188)
					)
				)
			)
			(5
				(gEgo posn: 148 (+ horizon 2))
			)
			(0
				(gEgo x: 318 y: 160)
			)
		)
		(walkingMusic number: 64 play:)
		(gEgo view: 2 init:)
		(= local19 (Blk new:))
		(local19 left: 212 top: 103 right: 224 bottom: 106)
		(gEgo observeBlocks: local19)
	)

	(method (doit)
		(super doit:)
		(if (and (not global112) (== (gCurRoom script:) 0))
			(cond
				((& (gEgo onControl: 0) $0002)
					(= local12 8)
					(= local13 3)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0004)
					(= local12 1)
					(= local13 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0008)
					(= local12 2)
					(gCurRoom setScript: grabbed)
					(= local13 2)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0010)
					(= local12 3)
					(= local13 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0020)
					(= local12 4)
					(= local13 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0040)
					(= local12 5)
					(= local13 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0200)
					(= local12 9)
					(= local13 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $2000)
					(= local12 6)
					(= local13 2)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0400)
					(= local12 10)
					(= local13 2)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $1000)
					(= local12 11)
					(= local13 3)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0800)
					(= local12 7)
					(= local13 2)
					(gCurRoom setScript: grabbed)
				)
			)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(or
					(Said 'look/around')
					(Said 'look/room')
					(Said 'look[<around][/!*]')
				)
			)
			(Print 11 0) ; "This place gives you the willies! The trees around here are very strange; almost human-like. A dense forest surrounds this odd grove of trees."
		)
	)
)

(instance grabbed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(walkingMusic dispose:)
				((Sound new:) number: 65 play:)
				(HandsOff)
				([local0 local12] setCycle: CT local13 1 self)
			)
			(1
				(gEgo dispose:)
				([local0 local12] setCycle: End self)
			)
			(2
				(switch (Random 1 6)
					(1
						(Print 11 1) ; "Wooden you know it. You've been caught!"
					)
					(2
						(Print 11 2) ; "You've really gotten yourself out on a limb this time, Rosella!"
					)
					(3
						(Print 11 3) ; "Talk about being torn limb from limb!"
					)
					(4
						(Print 11 4) ; "Time to "leaf" this mortal world!"
					)
					(5
						(Print 11 5) ; "You've been a real sap this time, Rosella!"
					)
					(6
						(Print 11 6) ; "It seems you'll discover your roots, Rosella!"
					)
				)
				(= seconds 5)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

