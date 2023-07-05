;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 705)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	bunny 0
	theBunny 1
	ropeScript 2
	tempHead 3
	theRoom 4
)

(local
	local0
	local1
	local2
	[local3 8] = [4 7 5 6 2 1 0 3]
	[local11 180] = [69 126 89 163 88 210 0 40 0 329 101 286 101 286 210 2 40 30 1 213 -10 188 94 188 -10 188 4 25 0 320 188 236 188 320 188 2 35 0 1 160 29 210 29 88 -10 88 4 30 0 315 169 220 166 220 210 0 50 0 1 90 329 54 263 54 301 -2 2 25 45 172 210 219 145 280 210 3 55 0 0 110 -10 155 94 155 -10 155 4 40 0 320 160 236 158 320 160 2 50 0 1 160 -10 50 67 40 52 -2 0 35 0 118 210 98 160 50 210 0 65 0 0 110 306 -2 265 54 329 54 2 60 0 329 180 276 166 329 97 2 60 0 0 92 -10 155 94 155 -10 155 4 55 0 320 160 236 158 320 160 2 65 0 1 160 0 -2 29 71 -10 71 4 60 0 -10 130 36 176 -10 176 4 60 0 0 109]
	[local191 63] = [245 138 188 167 2 30 3 96 185 242 188 4 25 2 73 121 104 154 4 30 3 214 165 255 122 3 55 2 68 166 250 166 4 40 2 196 168 70 115 3 65 4 295 35 250 107 1 40 2 87 132 256 132 4 55 2 14 44 65 148 1 50 4]
	[local254 18] = [76 160 0 0 188 147 171 142 0 0 143 140 210 50 0 0 105 69]
	[local272 36] = [123 210 154 164 185 210 118 210 111 152 50 210 219 210 247 148 274 210 78 210 66 146 20 210 327 20 287 52 327 52 -7 27 29 73 -7 73]
)

(class bunny of Rgn
	(properties
		bunnyWait 300
		bunnyRoom 0
		followTimer 0
		followFlag 0
	)

	(method (init)
		(super init:)
		(Load rsVIEW 105)
		(drumBeat init:)
		(if (and followFlag (not (gEgo has: 3))) ; rabbit
			(theBunny init: setCycle: Walk setScript: buzzOff)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 25 30 35 40 45 50 55 60 65))
		(= initialized 0)
		(theBunny cel: 0)
		(if (and (== (self bunnyRoom:) newRoomNumber) followTimer)
			(self followFlag: 1)
		else
			(self followFlag: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(super doit:)
		(cond
			((gCurRoom script:) 0)
			((> followTimer 0)
				(-= followTimer 1)
			)
			((and (> bunnyWait 0) (not (theBunny script:)))
				(-= bunnyWait 1)
				(if (and (not (gEgo has: 3)) (== bunnyWait 60)) ; rabbit
					(theBunny init: setCycle: Fwd z: 1000)
				)
			)
			((and (not (theBunny script:)) (== ((gInventory at: 3) owner:) 0)) ; rabbit
				(self bunnyWait: 300)
				(theBunny init: z: 0 setCycle: Walk setScript: bunnyScript)
			)
		)
	)
)

(instance bunnyScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (< register 22)
			(++ register)
		)
		(if
			(or
				(and
					(not (& (gEgo onControl: 1) $0100))
					(not (& (gEgo onControl: 1) $1000))
					(== (gCurRoom script:) ropeScript)
					local1
				)
				(and (> register 20) (gEgo mover:) local1)
			)
			(theBunny setScript: runAway)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					([local11 (+ (= local0 (* (- (/ gCurRoomNum 5) 5) 20)) 18)]
						(if (< (gEgo x:) [local11 (+ local0 19)])
							(+= local0 9)
						)
					)
					((< (gEgo y:) [local11 (+ local0 19)])
						(+= local0 9)
					)
				)
				(bunny bunnyRoom: [local11 (+ local0 7)])
				(= cycles 1)
			)
			(1
				(= local1 [local11 (+ local0 6)])
				(theBunny
					x: [local11 local0]
					y: [local11 (+ local0 1)]
					setMotion:
						MoveTo
						[local11 (+ local0 2)]
						[local11 (+ local0 3)]
						self
				)
			)
			(2
				(theBunny
					setMotion:
						MoveTo
						[local11 (+ local0 4)]
						[local11 (+ local0 5)]
						self
				)
			)
			(3
				(bunny followTimer: 60)
				(theBunny z: 1000 setCycle: Fwd)
				(client setScript: 0)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local1
					(1
						(theBunny setMotion: MoveTo (theBunny x:) -2 self)
					)
					(2
						(theBunny setMotion: MoveTo 329 (theBunny y:) self)
					)
					(3
						(theBunny setMotion: MoveTo (theBunny x:) 210 self)
					)
					(4
						(theBunny setMotion: MoveTo -10 (theBunny y:) self)
					)
				)
			)
			(1
				(if [local11 (+ local0 8)]
					(bunny bunnyRoom: [local11 (+ local0 8)])
				else
					(bunny bunnyRoom: [local11 (+ local0 7)])
				)
				(bunny followTimer: 60)
				(theBunny z: 1000 setCycle: Fwd)
				(= local1 0)
				(client setScript: 0)
			)
		)
	)
)

(instance buzzOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (* (- (/ gCurRoomNum 5) 5) 7))
				(if (== [local191 (+ register 5)] gPrevRoomNum)
					(+= register 2)
				)
				(self cue:)
			)
			(1
				(theBunny
					init:
					x: [local191 register]
					y: [local191 (+ register 1)]
					z: 0
					setCycle: Walk
				)
				(switch [local191 (+ register 4)]
					(1
						(theBunny setMotion: MoveTo (theBunny x:) -2 self)
					)
					(2
						(theBunny setMotion: MoveTo 329 (theBunny y:) self)
					)
					(3
						(theBunny setMotion: MoveTo (theBunny x:) 210 self)
					)
					(4
						(theBunny setMotion: MoveTo -10 (theBunny y:) self)
					)
				)
			)
			(2
				(bunny bunnyWait: 300 followTimer: 60 bunnyRoom: 0)
				(theBunny z: 1000 setCycle: Fwd)
				(client setScript: 0)
			)
		)
	)
)

(instance ropeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsVIEW 23)
				(if
					(or
						(& (gEgo onControl: 1) $0100)
						(& (gEgo onControl: 1) $1000)
					)
					(= temp0 (* (- (/ gCurRoomNum 5) 5) 2))
					(gEgo
						setMotion:
							PolyPath
							[local254 temp0]
							[local254 (+ temp0 1)]
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if
					(or
						(== gCurRoomNum 25)
						(== gCurRoomNum 40)
						(== gCurRoomNum 55)
						(and
							(< (gEgo x:) 160)
							(or
								(== gCurRoomNum 30)
								(== gCurRoomNum 45)
								(== gCurRoomNum 60)
							)
						)
					)
					(self register: 1)
				else
					(self register: 0)
				)
				(if (& (gEgo onControl: 1) $0080)
					(if register
						(= register 0)
						(gEgo setHeading: 270)
					else
						(= register 1)
						(gEgo setHeading: 90)
					)
				)
				(= cycles 4)
			)
			(2
				(= cycles 1)
			)
			(3
				(gEgo
					setMotion: 0
					normal: 0
					view: 23
					setLoop: (+ register 2)
					cel: 0
				)
				(theRope
					init:
					setLoop: register
					cel: 0
					x:
						(if register
							(- (gEgo x:) 6)
						else
							(+ (gEgo x:) 6)
						)
					y: (- (gEgo y:) 23)
					z: 0
					cycleSpeed: 3
					setCycle: End
					setMotion:
						MoveTo
						(if register
							(+ (gEgo x:) 19)
						else
							(- (gEgo x:) 19)
						)
						(- (gEgo y:) 3)
						self
				)
			)
			(4
				(gEgo cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(5
				(gEgo setCycle: End)
				(= cycles 3)
			)
			(6
				(tempHead
					init:
					setLoop: (+ register 4)
					x:
						(if register
							(+ (gEgo x:) 9)
						else
							(- (gEgo x:) 9)
						)
					y: (gEgo y:)
					cycleSpeed: 8
					setCycle: Fwd
				)
				(if
					(or
						(& (gEgo onControl: 1) $1000)
						(& (gEgo onControl: 1) $0100)
					)
					(gCurRoom setScript: bunnySnare)
				else
					(= cycles 50)
				)
			)
			(7
				(if (!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
					(Print 705 0) ; "Don't you feel dumb standing out in plain sight while trying to trick something into your snare?"
					(= cycles 1)
				)
			)
			(8
				(ropeScript start: 0)
				(theRope cycleSpeed: 0 setCycle: Beg self)
			)
			(9
				(gEgo setCel: 0)
				(theRope
					setCel: 0
					x:
						(if register
							(+ (gEgo x:) 11)
						else
							(- (gEgo x:) 11)
						)
					y: (- (gEgo y:) 20)
					setMotion:
						MoveTo
						(if register
							(- (gEgo x:) 7)
						else
							(+ (gEgo x:) 7)
						)
						(- (gEgo y:) 23)
						self
				)
			)
			(10
				(ropeScript start: 0)
				(theRope z: 1000)
				(tempHead dispose:)
				(NormalEgo (if register 0 else 1) 0)
				(= cycles 3)
			)
			(11
				(theRope dispose:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance bunnySnare of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (> (bunny bunnyWait:) 0)
			(bunny bunnyWait: (- (bunny bunnyWait:) 1))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 1)
				(gNarrator enable: 2)
				(gNarrator curIcon: (gNarrator at: 2))
				(gGame setCursor: ((gNarrator curIcon:) cursor:))
				(= seconds 3)
			)
			(1
				(if (> (bunny bunnyWait:) 60)
					(bunny bunnyWait: 60)
				)
				(theBunny init: z: 1000 setCycle: Fwd)
				(= seconds 7)
			)
			(2
				(= register
					(switch gCurRoomNum
						(25 0)
						(35 6)
						(40 12)
						(50 18)
						(55 24)
						(65 30)
					)
				)
				(theBunny
					init:
					x: [local272 register]
					y: [local272 (+ register 1)]
					z: 0
					setCycle: Walk
					setMotion:
						MoveTo
						[local272 (+ register 2)]
						[local272 (+ register 3)]
						self
				)
				(= local2 (theBunny loop:))
			)
			(3
				(theBunny setCycle: Fwd setLoop: [local3 (theBunny loop:)])
				(if (!= (theBunny loop:) local2)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(theBunny
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						[local272 (+ register 4)]
						[local272 (+ register 5)]
						self
				)
			)
			(5
				(HandsOff)
				(Print 705 1) ; "Those sure are some finely honed reactions you've got there. Perhaps you're still suffering from time lag."
				(bunny bunnyWait: 300 followTimer: 60 bunnyRoom: 0)
				(theBunny z: 1000 setLoop: -1 setCycle: Fwd)
				(ropeScript start: 8)
				(gCurRoom setScript: ropeScript)
			)
		)
	)
)

(instance catchBunny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 835 loop: 1 vol: 127 play:)
				(theBunny setMotion: 0)
				(drumBeat number: 0 stop:)
				(theRope
					cel: 0
					setLoop: (+ (theRope loop:) 6)
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 2)
			)
			(1
				(theBunny dispose:)
				(theRope setCycle: End self)
			)
			(2
				(theRope dispose:)
				(SetScore 41 10)
				(Print 705 2) ; "That was without a doubt one of the finest examples of bunny snatching we've ever seen!"
				(gEgo get: 3) ; rabbit
				(gEgo put: 1 0) ; rope
				(Print 705 3) ; "The stress placed on the rope during the bunny snatching was too much. You cast the useless fibers aside."
				(ropeScript start: 10)
				(gCurRoom setScript: ropeScript)
			)
		)
	)
)

(instance theBunny of Actor
	(properties
		description {hare.}
		lookStr {A brightly colored mechanical hare wanders about.}
		view 105
		signal 24576
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(if
					(and
						(< 3 (- (theBunny y:) (theRope y:)) 12)
						(or
							(> 60 (- (theRope x:) (theBunny x:)) 54)
							(> 60 (- (theBunny x:) (theRope x:)) 54)
						)
					)
					(HandsOff)
					(gCurRoom setScript: catchBunny)
				else
					(Print 705 4) ; "The hare, anticipating your clumsy attempt to catch it in the open barehanded, won't come anywhere near you."
				)
			)
			(4 ; Talk
				(Print 705 5) ; "It's too cool to talk to you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
			(bunny bunnyWait: 300)
			(bunny followTimer: 0)
		)
		(if
			(and
				(!= (gCurRoom script:) catchBunny)
				(!= (gCurRoom script:) (ScriptID 705 3)) ; tempHead
				(== (self cel:) 2)
				(= temp0
					(cond
						((not (self z:)) 127)
						((bunny followTimer:)
							(* (bunny followTimer:) 2)
						)
						((< (bunny bunnyWait:) 61)
							(* (Abs (- (bunny bunnyWait:) 60)) 2)
						)
						(else 0)
					)
				)
			)
			(drumBeat vol: temp0 play:)
		)
	)
)

(instance theRope of Actor
	(properties
		description {snare}
		lookStr {The rope is configured to function as a snare.}
		yStep 12
		view 23
		signal 24576
		xStep 12
	)

	(method (doit)
		(super doit:)
		(if (== (gCurRoom curPic:) 31)
			(self hide:)
		else
			(self show:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(cond
					(
						(and
							(< 3 (- (theBunny y:) (theRope y:)) 12)
							(or
								(> 60 (- (theRope x:) (theBunny x:)) 54)
								(> 60 (- (theBunny x:) (theRope x:)) 54)
							)
						)
						(HandsOff)
						(gCurRoom setScript: catchBunny)
					)
					(
						(and
							(not ((ScriptID 701 5) z:)) ; cyborg
							(< (self distanceTo: (ScriptID 701 5)) 60) ; cyborg
						)
						(Print 705 6) ; "You start to give the rope a tug, but come to the realization that the puny little strand wouldn't have much any effect on him. Besides, why would you want to catch this grotesque dude anyway?"
					)
					(else
						(Print 705 7) ; "Timing.. timing is a critical factor here."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tempHead of Prop
	(properties
		z 33
		view 23
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 33)
		)
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Inventory
				(switch invItem
					(1 ; rope
						(cond
							((!= ((gInventory at: 3) owner:) 0) 0) ; rabbit
							((IsFlag 0)
								(Print 705 8) ; "You don't have time for that now!"
							)
							((& (gEgo onControl: 1) $0020)
								(Print 705 9) ; "There's not enough room for that here!"
							)
							((not (gCurRoom script:))
								(HandsOff)
								(gCurRoom setScript: ropeScript)
							)
							(else 0)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else 0)
		)
	)
)

(instance drumBeat of Sound
	(properties
		number 116
	)
)

