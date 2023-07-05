;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room22 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance door of Prop
	(properties)

	(method (cue)
		(HandsOn)
		(gCurRoom newRoom: 54)
	)
)

(instance Room22 of Rm
	(properties
		picture 22
	)

	(method (init)
		(= north 16)
		(= south 28)
		(= east 23)
		(= west 21)
		(= horizon 75)
		(= gIndoors 0)
		(if gNight
			(= picture 122)
		)
		(gEgo edgeHit: 0)
		(super init:)
		(self setRegions: 501 512 508) ; waterReg, riverReg, Forest_Region
		(Load rsVIEW 612)
		(= local5 (Prop new:))
		(local5
			view: 627
			loop: 0
			cel: 3
			posn: 158 26
			setPri: 0
			cycleSpeed: 2
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(= local1 (Prop new:))
		(= local2 (Prop new:))
		(= local3 (Prop new:))
		(= local4 (Prop new:))
		(local1
			isExtra: 1
			view: 656
			loop: 0
			cel: 2
			posn: 23 111
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local2
			isExtra: 1
			view: 656
			loop: 1
			cel: 1
			posn: 309 157
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local3
			isExtra: 1
			view: 656
			loop: 2
			cel: 2
			posn: 226 169
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(local4
			isExtra: 1
			view: 656
			loop: 3
			cel: 1
			posn: 41 126
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			init:
		)
		(door view: 612 loop: 0 cel: 0 posn: 189 113 setPri: 6 stopUpd: init:)
		(if gNight
			(door loop: 1)
		)
		(switch gPrevRoomNum
			(21
				(if (<= (gEgo y:) horizon)
					(gEgo posn: 1 (+ horizon 2))
				)
				(if (and (>= (gEgo y:) 126) (< (gEgo y:) 130))
					(gEgo posn: 1 128)
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(16
				(gEgo x: 27 y: (+ horizon (gEgo yStep:) 1))
			)
			(28
				(gEgo x: 171 y: 188)
			)
			(23
				(gEgo posn: 317 (gEgo y:))
			)
			(53
				(gEgo view: 2 loop: 2 x: 188 y: 115)
				(if (== global102 2)
					(gCurRoom setScript: doorActions)
				)
			)
			(54
				(if (== global102 2)
					(gCurRoom setScript: doorActions)
				)
				(gEgo view: 2 x: 188 y: 115)
			)
			(0
				(gEgo x: 318 y: 123)
			)
		)
		(gEgo xStep: 2 yStep: 1 init:)
	)

	(method (doit)
		(super doit:)
		(if (and (gEgo inRect: 167 140 201 149) (!= (gEgo view:) 2))
			(gEgo setPri: 11)
		else
			(gEgo setPri: -1)
		)
	)

	(method (newRoom newRoomNumber)
		(User canControl: 1 canInput: 1)
		(gSounds eachElementDo: #dispose)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/cottage')
					(Print 22 0) ; "The roots of this great tree envelop a little, snug house. Smoke lazily curls from its chimney, and an old rustic water wheel rests beside the river."
				)
				((Said 'look/window')
					(if
						(or
							(gEgo inRect: 140 112 170 124)
							(gEgo inRect: 170 112 202 120)
						)
						(Print 22 1) ; "You peek through the window, but can make out no details."
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'look/blossom')
					(Print 22 2) ; "There are flowers here and there."
				)
				((Said 'get/blossom')
					(Print 22 3) ; "It would waste your precious time to stop and pick flowers."
				)
				((Said 'look/door')
					(Print 22 4) ; "It's a small wooden door."
				)
				((Said 'break/window')
					(Print 22 5) ; "That's vandalism!"
				)
				((Said 'break/door')
					(Print 22 6) ; "You could never do that."
				)
				((Said 'open/window')
					(Print 22 7) ; "The windows do not open."
				)
				((Said 'open/door')
					(if (gEgo inRect: 170 112 202 120)
						(cond
							((== local0 1)
								(Print 22 8) ; "That would not be a good idea right now."
							)
							((not gNight)
								(HandsOff)
								(gEgo loop: 3)
								((Sound new:) number: 300 loop: 1 play: door)
								(door setCycle: End)
							)
							(else
								(Print 22 9) ; "You can't. It's locked and you don't have the key."
							)
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'unlatch/door')
					(if (gEgo inRect: 170 112 202 120)
						(if (not gNight)
							(Print 22 10) ; "The door is already unlocked."
						else
							(Print 22 11) ; "You can't. You don't have the key."
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'bang/door')
					(if (gEgo inRect: 170 112 202 120)
						(cond
							((== local0 1)
								(Print 22 12) ; "Go away!"
							)
							(gNight
								(Print 22 13) ; "You knock loudly on the small door and hear a shuffling from inside. A sleepy voice calls out, "We're all asleep here! Come back tomorrow!""
							)
							(else
								(Print 22 14) ; "You knock loudly on the small door. No answer."
							)
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'look/wheel')
					(Print 22 15) ; "The water wheel appears run-down, and is currently not in use."
				)
				((Said 'look[<around][/room]')
					(Print 22 16) ; "You have come upon a cute little house, built right into a huge tree! An old water wheel, attached to the house, goes unused beside the little river that flows gently before the house."
				)
			)
		)
	)
)

(instance doorActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global102 0)
				(= local0 1)
				(door ignoreActors: 0 setCycle: Beg self)
			)
			(1
				(Print 22 17) ; "...and STAY OUT!"
			)
		)
	)
)

