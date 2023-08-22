;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm21 0
)

(local
	local0
	local1
)

(instance rm21 of Rm
	(properties
		picture 21
		horizon 57
		north 28
		east 20
		south 12
		west 22
	)

	(method (init)
		(Load rsVIEW 117)
		(if (not (gEgo has: 16)) ; Magic_Shield
			(Load rsSOUND 36)
		)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(if
			(and
				(not (IsFlag 74))
				(not global124)
				(not (gEgo has: 16)) ; Magic_Shield
				(= local0 (Random 0 4))
			)
			(Load rsVIEW (if (IsFlag 0) 23 else 16))
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo
					posn:
						(proc0_17 202 (proc0_18 73 (gEgo x:) 43) 13)
						(+ horizon 2)
				)
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 120) 188)
			)
			(west
				(gEgo
					posn:
						3
						(proc0_17
							175
							(proc0_18 123 (gEgo y:) 111)
							(+ 2 horizon)
						)
				)
			)
			(east
				(gEgo
					posn: 317 (proc0_18 95 (proc0_18 114 (gEgo y:) 105) 77)
				)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(tree init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(tree8 init:)
		(tree9 init:)
		(tree10 init:)
		(tree11 init:)
		(rock init:)
		(rock1 init:)
		(rock2 init:)
		(bush init:)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(and
					(gCast contains: witch)
					(!= global123 2)
					(!= (gEgo view:) (if (IsFlag 0) 23 else 16))
					(not (IsFlag 1))
					(< 30 (- (gEgo y:) (witch y:)) 54)
					(< (Abs (- (witch x:) (gEgo x:))) 4)
				)
				(gCurRoom setScript: witchRide)
			)
			((and (== script witchRide) (< (gEgo x:) -32))
				(gEgo dispose:)
				(gCurRoom newRoom: 80)
			)
			(script
				(script doit:)
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
				(FadeBackSound)
				(self newRoom: temp0)
			)
			((and (not local0) (gEgo has: 16)) 0) ; Magic_Shield
			(
				(and
					(not (gCast contains: witch))
					(== (gEgo onControl: 1) 4096)
					local0
					(not (IsFlag 1))
				)
				(if (not local1)
					(= local1 1)
					((ScriptID 0 23) number: 36 loop: -1 play:) ; backSound
				)
				(witch
					init:
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					setStep: 10 6
					setCycle: Fwd
					setScript: longSwoop
				)
			)
			(
				(and
					(not (gCast contains: witch))
					(== (gEgo onControl: 1) 8192)
					local0
					(not (IsFlag 1))
				)
				(if (not local1)
					(= local1 1)
					((ScriptID 0 23) number: 36 loop: -1 play:) ; backSound
				)
				(witch
					init:
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					setStep: 10 6
					setCycle: Fwd
					setScript: shortSwoop
				)
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
			((Said '/witch')
				(Print 21 0) ; "There's no witch here at the moment."
			)
			((and (Said 'look,look>') (Said '[<at,around][/room,ceder]'))
				(Print 21 1) ; "This part of the forest is dark and creepy. Shadows seem to jump out at you, and the trees are gnarled and misshapen."
			)
		)
	)
)

(instance witch of Actor
	(properties
		view 117
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event))
			((or (Said 'look,look/witch') (MousedOn self event 3))
				(Print 21 2) ; "This is not your friendly-type witch."
			)
			((Said 'kill/witch')
				(if (gCast contains: witch)
					(Print 21 3) ; "Killing the witch would be very difficult right now, she is moving too fast!"
				else
					(Print 21 4) ; "There is no witch here at the moment."
				)
			)
			((or (Said 'talk,talk') (Said '<hello') (Said 'say/hello'))
				(Print 21 5) ; "The wicked witch is not interested in chitchat."
			)
			((Said 'get,get,capture,eat,eat,bite/witch')
				(cond
					((IsFlag 12)
						(Print 21 6) ; "It looks as though she's already caught YOU!"
					)
					((gCast contains: witch)
						(Print 21 7) ; "Are you kidding?"
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'jump')
				(cond
					((IsFlag 12)
						(Print 21 8) ; "There's no way you can do that. The witch is holding you with supernatural strength."
					)
					((gCast contains: witch)
						(Print 21 9) ; "You're too high for that. You'd break your neck."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'hit,kick/witch')
				(Print 21 10) ; "The witch is mad enough already without you worsening her mood."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 21 2) ; "This is not your friendly-type witch."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance longSwoop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(Print 21 11) ; "With a screech and cackle, a witch swoops down from the skies above. Look out! She dips and turns and tries to catch you!"
				(witch
					setPri: 5
					setLoop: 0
					posn: 28 1
					setMotion: MoveTo 114 66 self
				)
			)
			(1
				(if (IsFlag 1)
					(Print 21 12) ; "It's a good thing you're invisible!"
				)
				(witch setMotion: MoveTo 183 58 self)
			)
			(2
				(witch setMotion: MoveTo 256 39 self)
			)
			(3
				(witch setMotion: MoveTo 349 68 self)
			)
			(4
				(witch setLoop: 1 setPri: 14 setMotion: MoveTo 282 106 self)
			)
			(5
				(witch setMotion: MoveTo (gEgo x:) (- (gEgo y:) 40) self)
			)
			(6
				(if (and (> (gEgo x:) 160) (> (gEgo y:) 140))
					(witch setMotion: MoveTo 121 126 self)
				else
					(self cue:)
				)
			)
			(7
				(witch setMotion: MoveTo -40 64 self)
			)
			(8
				(-- local0)
				(witch dispose:)
				(if (not local0)
					((ScriptID 0 23) fade:) ; backSound
					(= local1 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance shortSwoop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(Print 21 11) ; "With a screech and cackle, a witch swoops down from the skies above. Look out! She dips and turns and tries to catch you!"
				(witch
					setPri: 9
					setLoop: 1
					posn: 320 12
					setMotion: MoveTo 207 86 self
				)
			)
			(1
				(if (IsFlag 1)
					(Print 21 12) ; "It's a good thing you're invisible!"
				)
				(witch setMotion: MoveTo (gEgo x:) (- (gEgo y:) 34) self)
			)
			(2
				(witch setMotion: MoveTo -40 49 self)
			)
			(3
				(-- local0)
				(witch dispose:)
				(if (not local0)
					((ScriptID 0 23) fade:) ; backSound
					(= local1 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance witchRide of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(gEgo posn: (- (witch x:) 15) (+ (witch y:) 22))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global123 2)
				((ScriptID 0 23) loop: 1 fade:) ; backSound
				(Print 21 13) ; "She's got you! She grabs you by the neck with an iron grip, and carries you off to her cottage deep in the forest."
				(HandsOff)
				(gEgo
					view: 117
					loop: 3
					setCycle: Fwd
					setMotion: 0
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					setPri: (witch priority:)
				)
			)
		)
	)
)

(instance rock2 of NewFeature
	(properties
		x 40
		y 175
		noun '/boulder'
		nsTop 161
		nsBottom 189
		nsRight 81
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This is one of many uninteresting rocks that pepper the forest floor.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 17
		y 154
		noun '/boulder'
		nsTop 147
		nsBottom 161
		nsRight 34
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This is one of many uninteresting rocks that pepper the forest floor.}
	)
)

(instance rock of NewFeature
	(properties
		x 95
		y 183
		noun '/boulder'
		nsTop 177
		nsLeft 81
		nsBottom 189
		nsRight 110
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {This is one of many uninteresting rocks that pepper the forest floor.}
	)
)

(instance tree11 of NewFeature
	(properties
		x 227
		y 144
		noun '/ceder'
		nsTop 135
		nsLeft 157
		nsBottom 153
		nsRight 297
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree10 of NewFeature
	(properties
		x 235
		y 156
		noun '/ceder'
		nsTop 153
		nsLeft 185
		nsBottom 159
		nsRight 286
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree9 of NewFeature
	(properties
		x 222
		y 66
		noun '/ceder'
		nsTop -1
		nsLeft 198
		nsBottom 134
		nsRight 246
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree8 of NewFeature
	(properties
		x 153
		y 41
		noun '/ceder'
		nsTop -1
		nsLeft 109
		nsBottom 84
		nsRight 197
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 269
		y 19
		noun '/ceder'
		nsTop -1
		nsLeft 245
		nsBottom 40
		nsRight 293
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 257
		y 59
		noun '/ceder'
		nsTop 45
		nsLeft 246
		nsBottom 74
		nsRight 269
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 252
		y 85
		noun '/ceder'
		nsTop 74
		nsLeft 247
		nsBottom 96
		nsRight 258
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 10
		y 59
		noun '/ceder'
		nsTop -1
		nsBottom 119
		nsRight 20
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 27
		y 112
		noun '/ceder'
		nsTop 105
		nsLeft 20
		nsBottom 119
		nsRight 34
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 64
		y 18
		noun '/ceder'
		nsTop -1
		nsLeft 20
		nsBottom 37
		nsRight 108
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 65
		y 56
		noun '/ceder'
		nsTop 37
		nsLeft 40
		nsBottom 76
		nsRight 91
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance tree of NewFeature
	(properties
		x 63
		y 72
		noun '/ceder'
		nsTop 66
		nsLeft 26
		nsBottom 78
		nsRight 100
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These trees are grotesquely bent and twisted, and the branches seem like they're reaching out to grab you.}
	)
)

(instance bush of NewFeature
	(properties
		x 298
		y 79
		noun '/bush'
		nsTop 40
		nsLeft 278
		nsBottom 119
		nsRight 319
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Bushes and vines grow in a jumble throughout this part of the forest.}
	)
)

