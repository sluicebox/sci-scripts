;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use ForwardCounter)
(use LoadMany)
(use Follow)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm19 0
)

(local
	[local0 20]
)

(instance rm19 of Rm
	(properties
		picture 19
		north 30
		east 18
		south 14
		west 20
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(LoadMany rsVIEW 219 1 45)
		(LoadMany rsSOUND 56 29)
		(super init:)
		(door init: stopUpd:)
		(ClearFlag 39)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 90 (gEgo x:) 30) 57 init:)
				(proc0_1)
			)
			(south
				(gEgo y: 188 init:)
				(proc0_1)
			)
			(west
				(gEgo x: 3 init:)
				(proc0_1)
			)
			(east
				(gEgo posn: 317 (proc0_17 189 (gEgo y:) 120) init:)
				(proc0_1)
			)
			(else
				(gEgo posn: 215 120 init:)
				(door cel: 8 setScript: doorCloses)
				(self setScript: outOfMount)
			)
		)
		(smallTree init:)
		(bush1 init:)
		(bush2 init:)
		(hill1 init:)
		(hill2 init:)
		(hill3 init:)
		(hill4 init:)
		(hill5 init:)
		(rock init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(> (gEgo y:) 119)
					(> (gEgo x:) 63)
					(< (gGoat y:) 120)
					(not (gGoat script:))
					(gCast contains: gGoat)
				)
				(gGoat setScript: catchUp)
			)
			(
				(and
					(& (gGoat onControl: 1) $0002)
					(IsFlag 2)
					(!= (gGoat priority:) 2)
				)
				(gGoat setPri: 2)
			)
			(
				(and
					(not (& (gGoat onControl: 1) $0002))
					(IsFlag 2)
					(== (gGoat priority:) 2)
				)
				(gGoat setPri: -1)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
			(
				(and
					(& (gEgo onControl: 1) $0002)
					(!= (gEgo priority:) 2)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setPri: 2)
			)
			(
				(and
					(not (& (gEgo onControl: 1) $0002))
					(== (gEgo priority:) 2)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setPri: -1)
			)
			(
				(and
					(& (gEgo onControl: 1) $0200)
					(!= (gEgo script:) climbHill)
				)
				(gEgo setScript: climbHill)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look>')
				(cond
					((Said '[<around,at][/room,hill]')
						(Print 19 0) ; "Curiously, a large door has been built into the steep mountainside."
					)
					((Said '/keyhole')
						(if (gEgo has: 3) ; Key
							(Print 19 1) ; "It's a gold lock. Coincidentally, you have a gold key."
						else
							(Print 19 2) ; "It's a gold lock. Somewhere, there is a key that fits this lock."
						)
					)
					((Said 'ceder')
						(Print 19 3) ; "There are many scattered pines around here."
					)
				)
			)
			((Said 'climb,climb/hill')
				(Print 19 4) ; "The mountain is much too steep and rocky for you to climb."
			)
			((Said 'pick/lock')
				(cond
					((and (gEgo has: 3) (Print 19 5)) ; Key, "has:"
						(Print 19 6) ; "Just use your gold key to unlock the door."
					)
					((gEgo inRect: 188 105 236 128)
						(Print 19 7) ; "Perhaps if you'd attended the Famous Adventurer's Correspondence School, you'd know how to pick locks. Sadly, you don't."
					)
					(else
						(Print 19 8) ; "Move closer to the door."
						(event claimed: 1)
					)
				)
			)
			((Said 'bend/door,hinge,lock')
				(if (gEgo inRect: 188 105 236 128)
					(gEgo loop: 3)
					(proc0_7)
					(Print 19 9) ; "You strike the door with all your might!  Unfortunately, the door doesn't give an inch."
				else
					(Print 19 10) ; "It will be difficult to do that from here."
				)
			)
			((Said 'knock[/door]')
				(if (gEgo inRect: 188 105 236 128)
					(gEgo loop: 3)
					(proc0_7)
					(gCurRoom setScript: knockDoor)
				else
					(Print 19 10) ; "It will be difficult to do that from here."
				)
			)
			((Said 'open,open/door')
				(cond
					((not (gEgo inRect: 188 105 236 128))
						(Print 19 11) ; "Move a little closer to the door."
					)
					((IsFlag 39)
						(Print 19 12) ; "The door appears to be already open."
					)
					((gEgo has: 3) ; Key
						(gEgo loop: 3)
						(proc0_7)
						(Print 19 13) ; "Using the gold key, you unlock the huge door..."
						(SetScore 68 2)
						(gEgo setScript: doorOpens)
					)
					(else
						(Print 19 14) ; "The huge door is locked. You can't open it."
					)
				)
			)
			(
				(and
					(not (gEgo inRect: 188 105 236 128))
					(or
						(Said 'unlock/door')
						(Said 'turn/knob')
						(Said 'use/key')
						(Said 'drop/key')
					)
				)
				(Print 19 10) ; "It will be difficult to do that from here."
			)
			((Said 'use/key')
				(if (gEgo has: 3) ; Key
					(Print 19 15) ; "How do you want to use the key?"
				else
					(Print 19 16) ; "Wishing you had a key doesn't make it so, Sir Graham."
				)
			)
			((or (Said 'unlock/door,lock') (Said 'drop/key'))
				(cond
					((IsFlag 39)
						(Print 19 12) ; "The door appears to be already open."
					)
					((gEgo has: 3) ; Key
						(gEgo loop: 3)
						(proc0_7)
						(Print 19 13) ; "Using the gold key, you unlock the huge door..."
						(SetScore 68 2)
						(gEgo setScript: doorOpens)
					)
					(else
						(Print 19 17) ; "You can't unlock the door without a key."
					)
				)
			)
			((or (Said 'turn/knob') (Said 'close,close,lock,open,open/door'))
				(if (gCurRoom script:)
					(PrintTooBusy)
				else
					(Print 19 18) ; "This massive door is securely locked."
				)
			)
			((Said 'look,look/keyhole')
				(if (gEgo inRect: 210 115 236 128)
					(gEgo loop: 3 view: 1 cel: 3)
					(proc0_7)
					(Print 19 19) ; "Through the keyhole you can dimly see a staircase. It looks like it might go up into the mountain."
					(proc0_1)
				else
					(Print 19 20) ; "You need to get closer to the door's keyhole"
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 211
		y 113
		view 219
		cycleSpeed 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/door,gate')
				(event claimed: 1)
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (gEgo inRect: 164 110 262 143)
					(Print 19 21) ; "A huge wooden door has been built into the base of a steep mountain. You notice a large keyhole in the door."
					(proc0_15 gEgo 213 100)
				else
					(Print 19 22) ; "Don't be afraid. Get close enough for a good look."
				)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		view 219
		loop 1
	)
)

(instance doorOpens of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 56 loop: -1 init: play:) ; gameSound
				(for ((= temp0 0)) (< temp0 (* (+ global101 1) 5)) ((++ temp0))
					((= [local0 temp0] (Clone sparkle))
						posn: (Random 193 233) (Random 72 111)
						ignoreActors:
						setCycle: ForwardCounter (Random 1 3)
						cycleSpeed: (Random 0 2)
						setPri: 15
						init:
					)
				)
				(= cycles 9)
			)
			(1
				(door setCycle: End self)
				(SetFlag 39)
			)
			(2
				((ScriptID 0 21) loop: 1 fade:) ; gameSound
				(door dispose:)
				(for ((= temp0 0)) (< temp0 (* (+ global101 1) 5)) ((++ temp0))
					([local0 temp0] dispose:)
				)
				(if (or (>= (gEgo x:) 220) (<= (gEgo x:) 213))
					(gEgo setMotion: MoveTo 213 119 self)
				else
					(gEgo
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
					)
				)
			)
			(3
				(gEgo setLoop: 3 setMotion: MoveTo 252 102 self)
				((ScriptID 0 23) loop: 1 fade:) ; backSound
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 66)
			)
		)
	)
)

(instance doorCloses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 21) number: 56 loop: 1 init: play:) ; gameSound
				(door cel: 8 setCycle: Beg self)
			)
			(1
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance outOfMount of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 215 130 self)
			)
			(1
				(proc0_1)
				(gEgo loop: 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 45
					loop: 0
					cycleSpeed: (if (>= global101 1) 1 else 0)
					cel: 0
					setMotion: 0
				)
				(= cycles 2)
			)
			(1
				((ScriptID 0 21) number: 29 loop: 2 play: self) ; gameSound
				(gEgo loop: 1 setCycle: Fwd)
			)
			(2
				(gEgo loop: 0 cel: 0 setCycle: 0)
				(= cycles 2)
			)
			(3
				(gEgo view: 2 loop: 3 cel: 0)
				(proc0_1)
				(Print 19 23) ; "The only response you get is the echo of your pounding."
				(self cue:)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					illegalBits: 0
					setCycle: Walk
					setLoop: 3
					setPri: 1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(1
				(gEgo stopUpd:)
				(proc0_1)
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom north:))
				(self dispose:)
			)
		)
	)
)

(instance catchUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 19 24) ; "Wait for the goat while it tries to catch up."
				(proc0_15 gEgo gGoat)
				(gGoat setMotion: MoveTo 32 121 self)
			)
			(1
				(HandsOn)
				(gGoat setMotion: Follow gEgo 60)
				(self dispose:)
			)
		)
	)
)

(instance smallTree of NewFeature
	(properties
		x 258
		y 133
		noun '/ceder[<little]'
		nsTop 119
		nsLeft 224
		nsBottom 147
		nsRight 292
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This is a miniature shade tree, which gives shade to the squirrels and other woodland creatures.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 43
		y 153
		noun '/bush'
		nsTop 144
		nsLeft 21
		nsBottom 163
		nsRight 66
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Long, low bushes grow unbounded throughout Daventry.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 90
		y 152
		noun '/bush'
		nsTop 144
		nsLeft 66
		nsBottom 160
		nsRight 114
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Long, low bushes grow unbounded throughout Daventry.}
	)
)

(instance hill1 of NewFeature
	(properties
		x 224
		y 94
		noun '/hill,hill'
		nsTop 73
		nsLeft 129
		nsBottom 116
		nsRight 320
		description {hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain which overlooks the Daventry countryside.}
	)
)

(instance hill2 of NewFeature
	(properties
		x 246
		y 59
		noun '/hill,hill'
		nsTop 45
		nsLeft 172
		nsBottom 73
		nsRight 320
		description {hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain which overlooks the Daventry countryside.}
	)
)

(instance hill3 of NewFeature
	(properties
		x 265
		y 35
		noun '/hill,hill'
		nsTop 26
		nsLeft 211
		nsBottom 45
		nsRight 320
		description {hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain which overlooks the Daventry countryside.}
	)
)

(instance hill4 of NewFeature
	(properties
		x 278
		y 19
		noun '/hill,hill'
		nsTop 13
		nsLeft 237
		nsBottom 26
		nsRight 319
		description {hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain which overlooks the Daventry countryside.}
	)
)

(instance hill5 of NewFeature
	(properties
		x 294
		y 6
		noun '/hill,hill'
		nsTop -1
		nsLeft 269
		nsBottom 13
		nsRight 320
		description {hill}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain which overlooks the Daventry countryside.}
	)
)

(instance rock of NewFeature
	(properties
		x 95
		y 81
		noun '/boulder'
		nsTop 72
		nsLeft 81
		nsBottom 90
		nsRight 110
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Over the years, many ordinary rocks like this one have tumbled down from the heights of Daventry's mountain.}
	)
)

