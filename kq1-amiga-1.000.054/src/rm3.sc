;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Blk)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm3 0
)

(local
	local0 = 1
)

(instance rockBlock of Blk
	(properties
		top 110
		left 143
		bottom 121
		right 181
	)
)

(instance rm3 of Rm
	(properties
		picture 3
		horizon 100
		north 14
		east 2
		south 46
		west 4
	)

	(method (init)
		(LoadMany rsVIEW 203 1 18)
		(Load rsSOUND 13)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 142 (+ horizon 2))
			)
			(south
				(if (< (gEgo y:) 220)
					(gEgo y: (proc0_17 289 (gEgo y:) 309))
				else
					(gEgo y: (proc0_17 66 (gEgo y:) 150))
				)
				(gEgo y: 188)
			)
			(east
				(gEgo posn: 317 158)
			)
			(west
				(gEgo posn: 3 137)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(gEgo observeBlocks: rockBlock)
		(if (gCast contains: gGoat)
			(gGoat observeBlocks: rockBlock)
		)
		(if (not (IsFlag 90))
			(Load rsVIEW 1)
		)
		(if (IsFlag 89)
			(rock cel: 3 setPri: 9 posn: 172 122)
			(rockBlock left: 151 top: 118 right: 189 bottom: 127)
		else
			(Load rsVIEW 18)
		)
		(rock init: ignoreActors: stopUpd:)
		(rock1 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
	)

	(method (doit &tmp temp0)
		(if (!= local0 (gEgo onControl: 1))
			(if (== (= local0 (gEgo onControl: 1)) 512)
				(gEgo z: -8 setPri: 7)
			else
				(gEgo z: 0 setPri: -1)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((proc0_14 event 141 110 185 117)
				(if (IsFlag 89)
					(Print 3 0) ; "There is a hole where the rock once was."
					(event claimed: 1)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,ceder,clearing]')
						(if (IsFlag 89)
							(Print 3 1) ; "You're in a shady forest clearing. A large rock rests in the middle of the clearing next to a shallow hole where the rock used to sit."
						else
							(Print 3 2) ; "You're in a shady forest clearing. A large rock rests in the middle of the clearing."
						)
					)
					((or (Said '<down') (Said '/grass'))
						(cond
							(
								(and
									(IsFlag 89)
									(or
										(gEgo inRect: 129 105 192 116)
										(gEgo inRect: 146 115 183 125)
									)
								)
								(if (IsFlag 90)
									(Print 3 3) ; "There is a shallow hole where the rock once rested in."
								else
									(Print 3 4) ; "There is an intricately carved dagger in the hole."
								)
							)
							((not (IsFlag 89))
								(Print 3 5) ; "You see a large rock resting in the middle of the clearing."
							)
							(else
								(Print 3 6) ; "There's not a lot to see except for the grass beneath your feet and a couple of large rocks."
							)
						)
					)
					((Said '/hole[<dark,shallow]')
						(cond
							(
								(and
									(IsFlag 89)
									(or
										(gEgo inRect: 129 105 192 116)
										(gEgo inRect: 146 115 183 125)
									)
								)
								(if (IsFlag 90)
									(Print 3 7) ; "There is nothing in this hole but dirt."
								else
									(Print 3 4) ; "There is an intricately carved dagger in the hole."
								)
							)
							((IsFlag 89)
								(Print 3 8) ; "You are too far away from the hole to see into it."
							)
							(else
								(Print 3 9) ; "There is no hole here."
							)
						)
					)
					((Said '/dirt')
						(if
							(and
								(IsFlag 89)
								(IsFlag 90)
								(or
									(gEgo inRect: 129 105 192 116)
									(gEgo inRect: 146 115 183 125)
								)
							)
							(Print 3 10) ; "There's nothing interesting about the dirt."
						)
					)
					((Said '/dagger')
						(cond
							((and (not (IsFlag 90)) (IsFlag 89))
								(Print 3 11) ; "You could see it better if you picked it up."
							)
							((not (IsFlag 89))
								(Print 3 12) ; "You do not have a dagger to look at."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said '/carving')
						(if (gEgo has: 0) ; Dagger
							(Print 3 13) ; "You can't read the runes, but it appears to be an elvish dagger of great antiquity."
						else
							(Print 3 14) ; "You don't have any carvings to look at."
						)
					)
				)
			)
			((Said 'climb,climb[<in]/hole[<shallow]')
				(cond
					((!= 0 (gEgo z:))
						(Print 3 15) ; "You are already standing in the hole."
					)
					((IsFlag 89)
						(Print 3 16) ; "You can just walk right over into the hole. It's very shallow."
					)
					(else
						(Print 3 17) ; "You don't see a hole."
					)
				)
			)
			((Said 'get,get,pick/dagger')
				(cond
					((== global119 gCurRoomNum)
						(event claimed: 0)
					)
					((and (IsFlag 90) (not (gEgo has: 0))) ; Dagger
						(Print 3 18) ; "You have thrown the dagger and it is lost forever."
					)
					((IsFlag 90)
						(Print 3 19) ; "You've already accomplished that task."
					)
					((IsFlag 1)
						(Print 3 20) ; "You can't pick up the dagger while you're invisible."
					)
					((== (gEgo view:) (if (IsFlag 0) 23 else 16))
						(Print 3 21) ; "You might be able to do that if you weren't ducking!"
					)
					((IsFlag 89)
						(if (gEgo inRect: 130 105 191 124)
							(gCurRoom setScript: getDagger)
						else
							(Print 3 22) ; "You are too far away to get the dagger."
						)
					)
					(else
						(Print 3 23) ; "There is no dagger here."
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance rock of Actor
	(properties
		x 169
		y 120
		yStep 1
		view 203
		xStep 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'kick/boulder[<!*]')
				(Print 3 24) ; "The rock is much, much harder than your foot. You'd injure yourself."
			)
			((Said 'look,look/(boulder,pebble)[<!*]')
				(event claimed: 0)
			)
			(
				(or
					(Said 'look,look/(boulder,pebble)[<!*]')
					(MousedOn self event 3)
				)
				(if (IsFlag 89)
					(Print 3 25) ; "It is a large rock. There is a shallow hole in the ground where the rock used to sit."
					(event claimed: 1)
				else
					(event claimed: 1)
					(Print 3 26) ; "You see a large, grey rock."
				)
			)
			((Said 'get,get/(boulder,pebble)[<!*]')
				(Print 3 27) ; "There's nothing useful or interesting about this rock."
			)
			((Said 'get,get/(boulder,pebble)[<!*]')
				(if (< (gEgo distanceTo: rock) 30)
					(Print 3 28) ; "This rock is far too heavy for you to carry."
				else
					(Print 3 29) ; "You are much too far away to even attempt getting the rock."
				)
			)
			((Said 'lift/boulder[<!*]')
				(if (gEgo inRect: 129 105 192 116)
					(Print 3 30) ; "The rock is far too heavy to be picked up."
				else
					(Print 3 31) ; "It will be very difficult to move the rock from here."
				)
			)
			((Said 'move,pull,pull/(boulder,pebble)[<!*]')
				(cond
					((IsFlag 89)
						(Print 3 32) ; "After moving that rock once, just the thought of moving it again exhausts you."
					)
					((IsFlag 1)
						(Print 3 33) ; "It's pretty hard to move the rock while you're invisible."
					)
					((== (gEgo view:) (if (IsFlag 0) 23 else 16))
						(Print 3 21) ; "You might be able to do that if you weren't ducking!"
					)
					((gEgo inRect: 129 105 192 116)
						(gCurRoom setScript: moveRock)
					)
					((gEgo inRect: 146 115 183 125)
						(gCurRoom setScript: crushedByRock)
					)
					(else
						(Print 3 31) ; "It will be very difficult to move the rock from here."
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance moveRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					loop:
						(cond
							((< (gEgo y:) 112) 2)
							((> (gEgo y:) 120) 3)
							((< (gEgo x:) 144) 0)
							(else 1)
						)
				)
				(= cycles 4)
			)
			(1
				(gEgo view: 1 ignoreActors: setCycle: End self)
			)
			(2
				(SetScore 89 2)
				((ScriptID 0 21) number: 13 loop: 1 init: play:) ; gameSound
				(gEgo stopUpd:)
				(rock
					xStep: (if (>= global101 1) 1 else 4)
					yStep: (if (>= global101 1) 1 else 4)
					cycleSpeed: 1
					setCycle: End
					setPri: 9
					setMotion: MoveTo 172 122 self
				)
			)
			(3
				(rock stopUpd:)
				((ScriptID 0 21) number: 106 play:) ; gameSound
				(gEgo setCycle: Beg self)
			)
			(4
				(proc0_1)
				(rockBlock left: 151 top: 118 right: 189 bottom: 127)
				(proc0_7)
				(Print 3 34) ; "With a small shove, you manage to push the rock a few feet... revealing a shallow hole underneath."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance crushedByRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo 169 120)
				(= cycles 4)
			)
			(1
				(gEgo view: 1 ignoreActors: setCycle: End self)
				(rock ignoreActors:)
			)
			(2
				((ScriptID 0 21) number: 18 loop: 1 init: play:) ; gameSound
				(gEgo view: 18 setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End)
				(rock
					illegalBits: 0
					cycleSpeed: 2
					setCycle: End
					setMotion: MoveTo 177 131 self
				)
			)
			(3
				(EgoDead
					{The moving rock rolls downhill...and right into you.___A crushing defeat.}
				)
			)
		)
	)
)

(instance getDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 150 114 self)
			)
			(1
				(gEgo view: 1 setCycle: End self)
			)
			(2
				(SetScore 90 5)
				(gEgo get: 0) ; Dagger
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(= cycles 6)
			)
			(3
				(gEgo illegalBits: -32768 setCycle: Beg self)
			)
			(4
				(proc0_1)
				(proc0_7)
				(Print 3 35) ; "You reach into the hole and grasp the dagger, being careful not to cut yourself."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rock1 of NewFeature
	(properties
		x 131
		y 117
		noun '/boulder<little'
		nsTop 110
		nsLeft 121
		nsBottom 124
		nsRight 142
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This rock is less distinctive than the one next to it.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 160
		y 40
		noun '/ceder'
		nsTop -1
		nsBottom 82
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a dense grove of trees here.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 28
		y 135
		noun '/ceder'
		nsTop 82
		nsBottom 189
		nsRight 56
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a dense grove of trees here.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 72
		y 121
		noun '/ceder'
		nsTop 82
		nsLeft 55
		nsBottom 160
		nsRight 90
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a dense grove of trees here.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 235
		y 135
		noun '/ceder'
		nsTop 82
		nsLeft 200
		nsBottom 189
		nsRight 270
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a dense grove of trees here.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 104
		y 95
		noun '/ceder'
		nsTop 82
		nsLeft 89
		nsBottom 109
		nsRight 119
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a dense grove of trees here.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 294
		y 94
		noun '/ceder'
		nsTop 82
		nsLeft 269
		nsBottom 106
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There is a dense grove of trees here.}
	)
)

