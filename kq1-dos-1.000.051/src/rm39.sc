;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm39 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(localproc_1)
	(Print &rest #title {Troll} #font 4 #at 16 120 #width 280 #dispose)
)

(procedure (localproc_1)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(instance rm39 of Rm
	(properties
		picture 39
		horizon 60
		north 42
		east 38
		south 26
		west 40
	)

	(method (init)
		(LoadMany rsVIEW 239 120 124 123 126 168 44)
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
		(pinetree init:)
		(pinetree2 init:)
		(treesOnBank init:)
		(treesOnBank2 init:)
		(bridge init:)
		(water init:)
		(water2 init:)
		(pinetree3 init:)
		(tree init:)
		(tree2 init:)
		(switch gPrevRoomNum
			(north
				(gEgo
					posn: (proc0_17 319 (proc0_18 217 (gEgo x:) 160) 157) 62
				)
			)
			(south
				(if (< (gEgo x:) 122)
					(gEgo posn: 9 188)
				else
					(gEgo posn: (proc0_17 319 (gEgo x:) 215) 188)
				)
			)
			(west
				(gEgo x: 3)
			)
			(east
				(gEgo
					posn:
						317
						(proc0_17
							188
							(proc0_18 141 (gEgo y:) 129)
							(+ horizon 2)
						)
				)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(self setRegions: 601) ; rgTroll
		(self setRegions: 608) ; riverReg
		(waterRock setPri: 7 ignoreActors: init: stopUpd:)
		(if (>= global101 1)
			(waterRock setCycle: Fwd)
		)
		(gMenace illegalBits: 0 stopUpd:)
	)

	(method (doit &tmp temp0)
		(if (and (== (gEgo view:) 54) (IsFlag 13))
			((ScriptID 0 23) fade:) ; backSound
		)
		(if
			(and
				(IsFlag 13)
				(not (gMenace script:))
				(not (& (gEgo onControl: 1) $003c))
				(<= (gEgo distanceTo: gMenace) 40)
			)
			(gMenace setScript: pushBack)
		)
		(if (IsFlag 4)
			(ClearFlag 4)
			(= local2 1)
			(self setScript: TrollLeaves)
		)
		(if
			(and
				(!= gPrevRoomNum 40)
				(== (gEgo onControl: 1) 2048)
				(not (IsFlag 13))
				(not (IsFlag 4))
				(not (IsFlag 5))
				(not local2)
			)
			(gMenace setScript: TrollFirst)
		)
		(cond
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
				(self newRoom: temp0)
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
			((Said 'look,look[<at,around][/room]')
				(Print 39 0) ; "A natural rock bridge crosses the steep, slippery banks of the river here."
			)
			(
				(or
					(Said 'talk,talk//troll')
					(Said 'talk,talk')
					(Said 'hello')
					(Said 'say/hello')
				)
				(if (IsFlag 13)
					(gCurRoom setScript: trollTalk)
				else
					(Print 39 1) ; "There is no one to talk to here."
				)
			)
		)
	)
)

(instance TrollLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(trollFace dispose:)
				((ScriptID 0 23) fade:) ; backSound
				(gEgo stopUpd:)
				(gMenace view: 120 setStep: 6 4 setLoop: -1 setCycle: Walk)
				(gMenace setMotion: MoveTo 20 106 self)
			)
			(1
				(gEgo stopUpd:)
				(gMenace setMotion: MoveTo 20 145 self)
			)
			(2
				(gMenace setMotion: MoveTo -25 145 self)
			)
			(3
				(gMenace dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance TrollFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 23) dispose:) ; backSound
				(self cue:)
			)
			(1
				(HandsOff)
				(if (IsFlag 2)
					(gGoat stopUpd:)
					((ScriptID 0 23) number: 53 play:) ; backSound
				else
					((ScriptID 0 23) number: 61 play:) ; backSound
				)
				(SetFlag 13)
				(if (not (>= global101 1))
					(gEgo setMotion: 0 stopUpd:)
				)
				(gMenace show:)
				(gMenace posn: -25 145 setMotion: MoveTo 20 145 self)
			)
			(2
				(gMenace setMotion: MoveTo 20 106 self)
			)
			(3
				(gMenace setMotion: MoveTo 80 106 self)
			)
			(4
				(gMenace view: 123 setLoop: 0 setCel: 0 ignoreControl:)
				(trollFace init: stopUpd:)
				(self cue:)
			)
			(5
				(gMenace stopUpd:)
				(if (IsFlag 1)
					(Print 39 2) ; "As you start to cross the bridge, a huge, hulking troll stomps into view and blocks your way. Even though you are invisible, the troll can sense your presence and will not allow you to cross his bridge."
				else
					(Print 39 3) ; "As you start to cross the bridge, a huge, hulking troll stomps into view and blocks your way."
				)
				(self cue:)
			)
			(6
				(HandsOn)
				(if
					(and
						(or (gCast contains: gGoat) (IsFlag 2))
						(!= global119 gCurRoomNum)
					)
					(gCurRoom setScript: GoatButt)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance pushBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(trollFace hide:)
				(gMenace view: 126 setLoop: 0 setCycle: CT 2 1 self)
			)
			(1
				(if (IsFlag 1)
					(Print 39 4) ; "As the troll pushes you back your ring slips off your finger and into the raging river below. It's lost forever!"
					(ClearFlag 1)
					(gEgo put: 5) ; Magic_Ring
				)
				(gEgo view: 44 setLoop: 0)
				(gMenace setCycle: End self)
			)
			(2
				(gEgo x: (+ (gEgo x:) 4))
				(= cycles 1)
			)
			(3
				(gMenace setCycle: Beg)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(4
				(HandsOn)
				(gMenace
					view: 123
					setLoop: 0
					setCel: 0
					ignoreControl:
					stopUpd:
				)
				(trollFace show: stopUpd:)
				(proc0_1)
				(gEgo view: 0 loop: 1)
				(self dispose:)
			)
		)
	)
)

(instance trollFace of Prop
	(properties
		description {troll}
		view 123
		loop 1
		priority 8
		signal 16
	)

	(method (init)
		(= x (+ (gMenace x:) 17))
		(= y (- (gMenace y:) 29))
		(super init:)
	)

	(method (show)
		(= x (+ (gMenace x:) 17))
		(= y (- (gMenace y:) 29))
		(super show:)
	)
)

(instance waterRock of Prop
	(properties
		x 92
		y 152
		description {rock}
		view 239
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 39 5) ; "The water is particularly perilous as it passes downstream through this gully."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance GoatButt of Script
	(properties)

	(method (doit)
		(if (and (== state 2) (<= (gGoat x:) 105) (not local1))
			(= local1 1)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gGoat looper:) viewNormal: 168)
				(gGoat
					view: 168
					setStep: 6 4
					setAvoider: 0
					setMotion: 0
					ignoreActors:
					illegalBits: 0
				)
				(Print 39 6) ; "It is a well known fact that goats hate trolls intensely. You move aside and let the goat take care of this wretched, nasty troll."
				(if (> (gGoat x:) 175)
					(gEgo illegalBits: 0 setMotion: MoveTo 155 95 self)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 175 125 self)
				)
			)
			(1
				(gEgo setLoop: 1 stopUpd:)
				(cond
					((< (gGoat y:) 64)
						(= local0 1)
						(gGoat setMotion: MoveTo 242 65 self)
					)
					((< (gGoat y:) 121)
						(= local0 2)
						(gGoat setMotion: MoveTo 175 106 self)
					)
					(else
						(= local0 3)
						(gGoat setMotion: MoveTo 191 147 self)
					)
				)
			)
			(2
				(switch local0
					(1
						(gGoat setMotion: MoveTo 242 79 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(gGoat setMotion: MoveTo 150 106 self)
			)
			(4
				(gGoat setMotion: MoveTo 100 106 self)
			)
			(5
				((ScriptID 0 21) number: 38 init: play:) ; gameSound
				(self cue:)
			)
			(6
				(trollFace dispose:)
				(gGoat stopUpd:)
				(gMenace
					view: 124
					setPri: 8
					illegalBits: 0
					ignoreActors:
					setStep: 12 9
					setLoop: 1
					setMotion: MoveTo 82 95 self
				)
			)
			(7
				(gMenace setMotion: MoveTo 84 100 self)
			)
			(8
				(gMenace setMotion: MoveTo 90 130 self)
			)
			(9
				(gMenace setMotion: MoveTo 99 176 self)
			)
			(10
				((ScriptID 0 21) number: 14 play:) ; gameSound
				(splash init:)
				(gMenace setMotion: MoveTo 102 183 self)
			)
			(11
				(gMenace dispose:)
				(ClearFlag 13)
				(splash setCycle: End self)
			)
			(12
				(splash dispose:)
				(SetScore 106 4)
				(Print 39 7) ; "The goat lowers his head and runs straight for the troll, butting him right off the bridge and into the river below. That's the last you'll see of that troll."
				((ScriptID 0 23) fade:) ; backSound
				((gGoat looper:) viewNormal: 165)
				(gGoat setStep: 3 2 setMotion: MoveTo 340 110 self)
			)
			(13
				(gEgo illegalBits: -32768 setLoop: -1)
				(HandsOn)
				(ClearFlag 2)
				(SetFlag 5)
				(LoadMany 0 971 985)
				(gGoat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance splash of Prop
	(properties
		x 102
		y 185
		view 124
		loop 2
		priority 9
		signal 18448
		cycleSpeed 2
	)

	(method (doVerb))
)

(instance pinetree of NewFeature
	(properties
		x 271
		y 86
		noun '/ceder<pine'
		nsTop 39
		nsLeft 246
		nsBottom 133
		nsRight 296
		description {pinetree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

(instance pinetree2 of NewFeature
	(properties
		x 231
		y 108
		noun '/ceder<pine'
		nsTop 81
		nsLeft 217
		nsBottom 136
		nsRight 245
		description {pinetree2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

(instance treesOnBank of NewFeature
	(properties
		x 165
		y 36
		noun '/ceder,oak'
		nsLeft 114
		nsBottom 73
		nsRight 166
		description {treesOnBank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

(instance treesOnBank2 of NewFeature
	(properties
		x 45
		y 42
		noun '/ceder,oak'
		nsLeft 25
		nsBottom 85
		nsRight 66
		description {treesOnBank2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

(instance bridge of NewFeature
	(properties
		x 98
		y 111
		noun '/bridge,boulder'
		nsTop 95
		nsLeft 44
		nsBottom 128
		nsRight 152
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This natural rock bridge connects the Daventry mainland to a small island.}
	)
)

(instance water of NewFeature
	(properties
		x 102
		y 174
		noun '/water,brook'
		nsTop 160
		nsLeft 57
		nsBottom 189
		nsRight 148
		description {water}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The water is particularly perilous as it passes downstream through this gully.}
	)
)

(instance water2 of NewFeature
	(properties
		x 87
		y 69
		noun '/water,brook'
		nsTop 46
		nsLeft 66
		nsBottom 93
		nsRight 109
		description {water2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {The swift river gushes through this deep gully.}
	)
)

(instance trollTalk of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(if gModelessDialog
					(proc0_7)
					(gModelessDialog dispose:)
					(if seconds
						(= seconds 0)
						(= cycles 1)
					)
					(if register
						(= register 0)
						(= cycles 1)
					)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(trollFace setCycle: Fwd)
				(self cue:)
			)
			(1
				(switch local3
					(0
						(localproc_0 39 8) ; "TROLL: "Well, what've we got here? You think yer gonna cross my bridge, do you? Not for FREE, you ain't.""
					)
					(1
						(localproc_0 39 9) ; "TROLL: "Yer quite the little chatterbox, aintcha? Well, lemmee warn ya, these bridges have been in my family for years and years, and nobody, especially not a puny little knight like yerself, has ever passed across one of our bridges without payin' our Troll Toll.""
					)
					(else
						(localproc_0 39 10) ; "TROLL: "Quit gabbin'. Are you plannin' on paying my toll, or does I hafta get tough?""
					)
				)
				(++ local3)
				(= register 1)
			)
			(2
				(trollFace setCycle: Beg self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pinetree3 of NewFeature
	(properties
		x 190
		y 42
		noun '/ceder<pine'
		nsTop 17
		nsLeft 163
		nsBottom 68
		nsRight 217
		description {pinetree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

(instance tree of NewFeature
	(properties
		x 305
		y 28
		noun '/ceder'
		nsTop -1
		nsLeft 291
		nsBottom 57
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 269
		y 18
		noun '/ceder'
		nsTop -1
		nsLeft 249
		nsBottom 38
		nsRight 289
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are many beautiful trees around Daventry.}
	)
)

