;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room5 0
)

(local
	[local0 9]
	local9
	local10
	local11
	local12
	local13
	local14
)

(instance Room5 of Rm
	(properties
		picture 5
	)

	(method (init)
		(= north 29)
		(= south 11)
		(= east 6)
		(= west 4)
		(= horizon 86)
		(= gIndoors 0)
		(if gNight
			(= picture 105)
		)
		(gEgo edgeHit: 0)
		(self setRegions: 509) ; sForReg
		(super init:)
		(for ((= local9 1)) (<= local9 7) ((++ local9))
			(= [local0 local9] (Prop new:))
		)
		([local0 1]
			view: 690
			loop: 0
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 270 81
			setPri: 15
			init:
			stopUpd:
		)
		([local0 2]
			view: 690
			loop: 1
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 270 81
			setPri: 15
			init:
			stopUpd:
		)
		([local0 3]
			view: 690
			loop: 2
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 291 78
			setPri: 8
			init:
			stopUpd:
		)
		([local0 4]
			view: 690
			loop: 3
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 311 110
			setPri: 7
			init:
			stopUpd:
		)
		([local0 5]
			view: 690
			loop: 3
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 266 59
			setPri: 2
			init:
			stopUpd:
		)
		([local0 6]
			view: 691
			loop: 0
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 115 76
			setPri: 8
			init:
			stopUpd:
		)
		([local0 7]
			view: 691
			loop: 1
			cel: 0
			cycleSpeed: 1
			ignoreActors:
			posn: 235 162
			setPri: 15
			init:
			stopUpd:
		)
		(= local10 (Prop new:))
		(= local12 (Prop new:))
		(local10
			view: 689
			loop: 0
			cel: 3
			ignoreActors:
			posn: 208 57
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 4
			init:
		)
		(local12
			view: 689
			loop: 1
			cel: 0
			ignoreActors:
			posn: 233 44
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 3
			init:
		)
		(switch gPrevRoomNum
			(4
				(if (<= (gEgo y:) 135)
					(gEgo posn: 1 120)
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(6
				(if (< (gEgo y:) 133)
					(gEgo posn: 318 133)
				else
					(gEgo posn: 318 (gEgo y:))
				)
			)
			(11
				(if (> (gEgo x:) 207)
					(gEgo posn: 207 188)
				else
					(gEgo posn: (gEgo x:) 188)
				)
			)
			(29
				(if (> (gEgo x:) 272)
					(gEgo x: 258)
				)
				(gEgo posn: (gEgo x:) (+ horizon (gEgo yStep:)))
			)
			(0
				(gEgo x: 290 y: 160)
			)
		)
		(= local14 (Sound new:))
		(local14 number: 64 play:)
		(gEgo view: 2 init:)
	)

	(method (doit)
		(super doit:)
		(if (and (not global112) (== (gCurRoom script:) 0))
			(cond
				((& (gEgo onControl: 0) $0040)
					(= local11 3)
					(= local9 1)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0020)
					(= local11 3)
					(= local9 2)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0010)
					(= local11 3)
					(= local9 3)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0004)
					(= local11 1)
					(= local9 7)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0400)
					(= local11 1)
					(= local9 4)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0200)
					(= local11 1)
					(= local9 5)
					(gCurRoom setScript: grabbed)
				)
				((& (gEgo onControl: 0) $0002)
					(= local11 2)
					(= local9 6)
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
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'look/room')
						(Said 'look/around')
						(Said 'look[<around][/!*]')
					)
					(Print 5 0) ; "This is a creepy place! You have found a grove of very odd, (and scary-looking), trees. A thick forest surrounds the grove."
				)
				((Said 'look/cottage')
					(Print 5 1) ; "You see the back of a large, thatched-roof house."
				)
				((Said 'look/door')
					(Print 5 2) ; "The door is at the front of the house."
				)
				((Said 'look/window')
					(if (gEgo inRect: 0 130 32 138)
						(Print 5 3) ; "You look through the window, but can make out no details."
					else
						(Print 5 4) ; "You're not close enough."
					)
				)
				((Said 'break/window')
					(Print 5 5) ; "That's vandalism!"
				)
				((Said 'open/window')
					(Print 5 6) ; "The windows do not open."
				)
			)
		)
	)
)

(instance grabbed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gSounds contains: local14)
					(local14 dispose:)
				)
				(= local13 (Sound new:))
				(local13 number: 65 play:)
				(HandsOff)
				([local0 local9] setCycle: CT local11 1 self)
			)
			(1
				(gEgo dispose:)
				([local0 local9] setCycle: End self)
			)
			(2
				(switch (Random 1 6)
					(1
						(Print 5 7) ; "Wooden you know it. You've been caught!"
					)
					(2
						(Print 5 8) ; "You've really gotten yourself out on a limb this time, Rosella!"
					)
					(3
						(Print 5 9) ; "Talk about being torn limb from limb!"
					)
					(4
						(Print 5 10) ; "Time to "leaf" this mortal world!"
					)
					(5
						(Print 5 11) ; "You've been a real sap this time, Rosella!"
					)
					(6
						(Print 5 12) ; "It seems you'll discover your roots, Rosella!"
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

