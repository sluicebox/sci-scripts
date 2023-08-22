;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room12 0
)

(local
	[local0 13]
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
)

(instance walkingMusic of Sound
	(properties
		number 64
		priority 15
	)
)

(instance caughtMusic of Sound
	(properties
		number 65
		priority 15
	)
)

(instance Room12 of Rm
	(properties
		picture 12
	)

	(method (init)
		(= north 6)
		(= south 18)
		(= west 11)
		(= horizon 80)
		(= gIndoors 0)
		(Load rsSOUND 65)
		(gEgo edgeHit: EDGE_NONE)
		(if (== (gGSound state:) 3)
			(gGSound play: -15536)
		)
		(super init:)
		(if gNight
			(gCurRoom overlay: 112)
		)
		(= local15 (Prop new:))
		(= local16 (Prop new:))
		(= local17 (Prop new:))
		(= local18 (Prop new:))
		(= local19 (Prop new:))
		(local15
			isExtra: 1
			view: 688
			loop: 0
			cel: 3
			posn: 265 97
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local16
			isExtra: 1
			view: 688
			loop: 1
			cel: 4
			posn: 12 59
			setPri: 8
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local17
			isExtra: 1
			view: 688
			loop: 2
			cel: 1
			posn: 210 64
			setPri: 10
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local18
			isExtra: 1
			view: 688
			loop: 3
			cel: 4
			posn: 154 86
			setPri: 7
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(local19
			isExtra: 1
			view: 688
			loop: 4
			cel: 4
			posn: 98 107
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		(self setRegions: 509 511) ; sForReg, mountReg
		(for ((= local14 1)) (< local14 13) ((++ local14))
			(= [local0 local14] (Prop new:))
		)
		([local0 1]
			view: 695
			loop: 0
			cel: 0
			posn: 29 53
			setPri: 2
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 2]
			view: 695
			loop: 1
			cel: 0
			posn: 57 61
			setPri: 2
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 3]
			view: 695
			loop: 2
			cel: 0
			posn: 77 60
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 4]
			view: 695
			loop: 3
			cel: 0
			posn: 147 85
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 5]
			view: 695
			loop: 4
			cel: 0
			posn: 161 87
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 6]
			view: 692
			loop: 4
			cel: 0
			posn: 121 69
			setPri: 6
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 7]
			view: 696
			loop: 0
			cel: 0
			posn: 206 75
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 8]
			view: 696
			loop: 1
			cel: 0
			posn: 21 63
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 9]
			view: 696
			loop: 2
			cel: 0
			posn: 98 124
			setPri: 7
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 10]
			view: 694
			loop: 1
			cel: 0
			posn: 231 82
			setPri: 12
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 11]
			view: 693
			loop: 2
			cel: 0
			posn: 6 85
			setPri: 12
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		([local0 12]
			view: 690
			loop: 0
			cel: 0
			posn: 222 93
			setPri: 8
			cycleSpeed: 1
			ignoreActors:
			init:
			stopUpd:
		)
		(switch gPrevRoomNum
			(west
				(if (<= (gEgo y:) horizon)
					(gEgo posn: 1 (+ horizon (gEgo yStep:) 1))
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(north
				(if (> (gEgo x:) 211)
					(gEgo posn: 210 (+ horizon 2))
				else
					(gEgo posn: (gEgo x:) (+ horizon 2))
				)
			)
			(south
				(if (> (gEgo x:) 77)
					(gEgo posn: 189 188)
				else
					(gEgo posn: 32 188)
				)
			)
			(0
				(gEgo x: 290 y: 160)
			)
		)
		(walkingMusic init: play:)
		(gEgo init: view: 2)
		(= local20 (Blk new:))
		(= local21 (Blk new:))
		(local20 left: 194 top: 115 right: 230 bottom: 118)
		(local21 left: 170 top: 106 right: 183 bottom: 110)
		(gEgo observeBlocks: local20 local21)
	)

	(method (doit)
		(super doit:)
		(if (and (not global112) (== (gCurRoom script:) 0))
			(cond
				((& (gEgo onControl: 0) $0080)
					(= local13 1)
					(= local14 2)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $2000)
					(= local13 1)
					(= local14 3)
				)
				((& (gEgo onControl: 0) $0040)
					(= local13 1)
					(= local14 6)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0020)
					(= local13 1)
					(= local14 5)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0100)
					(= local13 2)
					(= local14 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $1000)
					(= local13 2)
					(= local14 4)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0010)
					(= local13 2)
					(= local14 7)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0200)
					(= local13 2)
					(= local14 8)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0800)
					(= local13 2)
					(= local14 9)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0004)
					(= local13 2)
					(= local14 10)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0400)
					(= local13 2)
					(= local14 11)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0008)
					(= local13 3)
					(= local14 12)
					(gCurRoom setScript: grabbed)
				)
			)
		)
	)

	(method (dispose)
		(if (IsObject local20)
			(local20 dispose:)
			(local21 dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(Said 'look[<around,at][/forest,forest,room]')
			)
			(Print 12 0) ; "You have come upon a bizarre group of scary, human-like trees. A thick forest of pine trees surrounds this strange group. Steep mountains block your way to the east."
		)
	)
)

(instance grabbed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(walkingMusic dispose:)
				(caughtMusic init: play:)
				(HandsOff)
				([local0 local14] startUpd: setCycle: CT local13 1 self)
			)
			(1
				(gEgo dispose:)
				([local0 local14] setCycle: End self)
			)
			(2
				(switch (Random 1 6)
					(1
						(Print 12 1) ; "Wooden you know it. You've been caught!"
					)
					(2
						(Print 12 2) ; "You've really gotten yourself out on a limb this time, Rosella!"
					)
					(3
						(Print 12 3) ; "Talk about being torn limb from limb!"
					)
					(4
						(Print 12 4) ; "Time to "leaf" this mortal world!"
					)
					(5
						(Print 12 5) ; "You've been a real sap this time, Rosella!"
					)
					(6
						(Print 12 6) ; "It seems you'll discover your roots, Rosella!"
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

