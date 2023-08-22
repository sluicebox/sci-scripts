;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Blk)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	[local6 2] = [281 58]
	[local8 2] = [162 159]
	[local10 2] = [3 1]
	[local12 2] = [6 6]
)

(procedure (localproc_0)
	(localproc_1)
	(Print &rest #title {Troll} #font 4 #at 16 20 #width 152 #dispose)
)

(procedure (localproc_1)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(instance rm41 of Rm
	(properties
		picture 41
		horizon 54
		north 8
		east 42
		south 40
		west 48
	)

	(method (init)
		(LoadMany rsVIEW 241 120 124 123 126 168 44)
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
				(gEgo posn: (proc0_17 319 (gEgo x:) 201) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 319 (gEgo x:) 73) 188)
			)
			(west
				(gEgo y: (proc0_17 198 (gEgo y:) (+ horizon 2)))
				(gEgo x: 3)
			)
			(east
				(gEgo
					posn:
						315
						(if (< (gEgo y:) 134)
							(proc0_17 122 (gEgo y:) 65)
						else
							(proc0_17 188 (gEgo y:) 178)
						)
				)
			)
			(else
				(gEgo posn: 163 188)
			)
		)
		(gEgo init:)
		(proc0_1)
		(rRock init:)
		(rRock1 init:)
		(bridge init:)
		(bridge1 init:)
		(tree init:)
		(tree1 init:)
		(smallTree init:)
		(rocks init:)
		(trunk init:)
		(rock2 init:)
		(tree3 init:)
		(rock4 init:)
		(bush3 init:)
		(bush4 init:)
		(river init:)
		(for ((= local3 0)) (< local3 2) ((++ local3))
			((= [local4 local3] (Clone Ripple))
				view: 241
				x: [local6 local3]
				y: [local8 local3]
				setLoop: [local10 local3]
				setPri: [local12 local3]
				ignoreActors: 1
				description: {ripple}
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local4 local3] setCycle: Fwd)
			)
		)
		(self setRegions: 601) ; rgTroll
		(self setRegions: 608) ; riverReg
		(bridge41Block init:)
		(gMenace stopUpd:)
	)

	(method (doit &tmp temp0)
		(if (and (== (gEgo view:) 54) (IsFlag 13))
			((ScriptID 0 23) fade:) ; backSound
		)
		(if (and (IsFlag 13) (not (gMenace script:)))
			(cond
				(
					(and
						(<= (gEgo distanceTo: gMenace) 45)
						(<= (gEgo x:) 212)
						(>= (gEgo x:) 196)
						(== (leftArm cel:) 0)
						(== (rightArm cel:) 0)
					)
					(if (>= (gEgo y:) 132)
						(gMenace setScript: pushBack)
					)
				)
				(
					(or
						(>= (gEgo distanceTo: gMenace) 45)
						(and
							(<= (gEgo distanceTo: gMenace) 45)
							(>= (gEgo x:) 196)
							(<= (gEgo x:) 212)
						)
					)
					(if (!= (leftArm cel:) 0)
						(leftArm setScript: leftArmBeg)
					)
					(if (!= (rightArm cel:) 0)
						(rightArm setScript: rightArmBeg)
					)
				)
				(
					(and
						(>= (gEgo x:) 213)
						(<= (gEgo distanceTo: gMenace) 45)
					)
					(if (!= (rightArm cel:) (rightArm lastCel:))
						(rightArm setScript: rightArmEnd)
					)
					(if (== (leftArm cel:) (leftArm lastCel:))
						(leftArm setScript: leftArmBeg)
					)
				)
				(
					(and
						(<= (gEgo x:) 195)
						(<= (gEgo distanceTo: gMenace) 45)
					)
					(if (!= (leftArm cel:) (leftArm lastCel:))
						(leftArm setScript: leftArmEnd)
					)
					(if (== (rightArm cel:) (rightArm lastCel:))
						(rightArm setScript: rightArmBeg)
					)
				)
			)
		else
			0
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
			((and (& (gEgo onControl: 1) $003c) (IsFlag 13))
				(gEgo ignoreBlocks: bridge41Block)
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
				(Print 41 0) ; "A rough-hewn plank bridge spans the deep rushing river here."
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
					(Print 41 1) ; "There is no one to talk to here."
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
				((ScriptID 0 23) fade:) ; backSound
				(leftArm dispose:)
				(rightArm dispose:)
				(gMenace view: 120 setStep: 6 4 setLoop: -1 setCycle: Walk)
				(gMenace setMotion: MoveTo 204 187 self)
			)
			(1
				(gEgo stopUpd:)
				(gMenace setMotion: MoveTo 347 187 self)
			)
			(2
				(gEgo ignoreBlocks: bridge41Block)
				(self cue:)
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
				(HandsOff)
				(if (IsFlag 2)
					(gGoat stopUpd:)
					((ScriptID 0 23) number: 53 init: playBed:) ; backSound
				else
					((ScriptID 0 23) number: 61 init: playBed:) ; backSound
				)
				(SetFlag 13)
				(if (not (>= global101 1))
					(gEgo setMotion: 0 stopUpd:)
				)
				(gMenace show:)
				(gEgo observeBlocks: bridge41Block)
				(gMenace posn: 347 187 setMotion: MoveTo 204 187 self)
			)
			(1
				(gMenace setMotion: MoveTo 204 147 self)
			)
			(2
				(leftArm init: stopUpd:)
				(rightArm init: stopUpd:)
				(gMenace view: 123 setLoop: 0 setCel: 2 ignoreControl:)
				(self cue:)
			)
			(3
				(gMenace stopUpd:)
				(if (IsFlag 1)
					(Print 41 2) ; "As you start to cross the bridge, a huge, hulking troll stomps into view and blocks your way. Even though you are invisible, the troll can sense your presence and will not allow you to cross his bridge."
				else
					(Print 41 3) ; "As you start to cross the bridge, a huge, hulking troll stomps into view and blocks your way."
				)
				(self cue:)
			)
			(4
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
				(leftArm hide:)
				(rightArm hide:)
				(gMenace view: 126 setLoop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(if (IsFlag 1)
					(Print 41 4) ; "As the troll pushes you back your ring slips off and falls into the river, to be lost forever."
					(ClearFlag 1)
					(gEgo put: 5) ; Magic_Ring
				)
				(gEgo view: 44 setLoop: 2)
				(gMenace setCycle: End self)
			)
			(2
				(gEgo y: (- (gEgo y:) 3))
				(= cycles 1)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10))
				(= cycles 3)
			)
			(4
				(gMenace cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(HandsOn)
				(leftArm show: stopUpd:)
				(rightArm show: stopUpd:)
				(gMenace
					view: 123
					setLoop: 0
					setCel: 2
					cycleSpeed: 0
					ignoreControl:
					stopUpd:
				)
				(gEgo view: 0 loop: 2)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance leftArm of Prop
	(properties
		x 198
		y 109
		description {troll}
		view 123
		loop 5
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gMenace doVerb: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightArm of Prop
	(properties
		x 210
		y 109
		description {troll}
		view 123
		loop 4
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gMenace doVerb: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bridge41Block of Blk
	(properties
		top 143
		left 175
		bottom 147
		right 240
	)
)

(instance GoatButt of Script
	(properties)

	(method (doit)
		(if (and (== state 3) (>= (gGoat y:) 140) (not local1))
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
				(Print 41 5) ; "It is a well known fact that goats hate trolls intensely. You move aside and let the goat take care of this wretched, nasty troll."
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self)
			)
			(1
				(gEgo setMotion: MoveTo 240 117 self)
			)
			(2
				(gEgo setLoop: 2)
				(gGoat setMotion: MoveTo 204 120 self)
			)
			(3
				(gGoat setMotion: MoveTo 204 145 self)
			)
			(4
				((ScriptID 0 21) number: 38 init: play:) ; gameSound
				(self cue:)
			)
			(5
				(leftArm dispose:)
				(rightArm dispose:)
				(gEgo ignoreBlocks: bridge41Block)
				(gMenace
					view: 124
					setPri: 8
					illegalBits: 0
					setStep: 12 9
					setLoop: 0
					setMotion: MoveTo 193 132 self
				)
			)
			(6
				(gMenace setMotion: MoveTo 161 124 self)
			)
			(7
				(gMenace setMotion: MoveTo 128 141 self)
			)
			(8
				(gMenace setMotion: MoveTo 116 167 self)
			)
			(9
				((ScriptID 0 21) number: 14 play:) ; gameSound
				(splash
					view: 124
					setLoop: 2
					cycleSpeed: 2
					setPri: 8
					posn: 110 176
					init:
				)
				(gMenace setMotion: MoveTo 112 174 self)
			)
			(10
				(gMenace dispose:)
				(ClearFlag 13)
				(splash setCycle: End self)
			)
			(11
				(splash dispose:)
				(SetScore 106 4)
				(Print 41 6) ; "The goat lowers his head and runs straight for the troll, butting him right off the bridge and into the river below. That's the last you'll see of that troll."
				((ScriptID 0 23) fade:) ; backSound
				((gGoat looper:) viewNormal: 165)
				(gGoat setStep: 3 2 setMotion: MoveTo 204 110 self)
			)
			(12
				(gGoat setMotion: MoveTo 350 110 self)
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
	(properties)
)

(instance leftArmBeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftArm setCycle: Beg self)
			)
			(1
				(leftArm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance rightArmBeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightArm setCycle: Beg self)
			)
			(1
				(rightArm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance leftArmEnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftArm setCycle: End self)
			)
			(1
				(leftArm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance rightArmEnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightArm setCycle: End self)
			)
			(1
				(rightArm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance Ripple of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/boulder')
				(Print 41 7) ; "The river ripples as it rushes over the rocks."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 41 7) ; "The river ripples as it rushes over the rocks."
			)
		)
	)
)

(instance bridge of NewFeature
	(properties
		x 218
		y 143
		noun '/bridge'
		nsTop 128
		nsLeft 183
		nsBottom 159
		nsRight 253
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The small, rickety wooden bridge is very old, but quite solid enough to support many times your weight.}
	)
)

(instance bridge1 of NewFeature
	(properties
		x 170
		y 152
		noun '/bridge'
		nsTop 143
		nsLeft 159
		nsBottom 161
		nsRight 181
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The small, rickety wooden bridge is very old, but quite solid enough to support many times your weight.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 97
		y 31
		noun '/ceder'
		nsTop -1
		nsBottom 64
		nsRight 195
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Many mature, graceful trees line the river's banks.}
	)
)

(instance tree of NewFeature
	(properties
		x 282
		y 29
		noun '/ceder'
		nsTop -1
		nsLeft 265
		nsBottom 60
		nsRight 300
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Many mature, graceful trees line the river's banks.}
	)
)

(instance smallTree of NewFeature
	(properties
		x 64
		y 88
		noun '/ceder[<little]'
		nsTop 69
		nsLeft 43
		nsBottom 108
		nsRight 86
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Why, look! It's a tiny little baby tree!}
	)
)

(instance trunk of NewFeature
	(properties
		x 110
		y 89
		noun '/ceder'
		nsTop 64
		nsLeft 96
		nsBottom 114
		nsRight 125
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Many mature, graceful trees line the river's banks.}
	)
)

(instance rocks of NewFeature
	(properties
		x 145
		y 108
		noun '/boulder'
		nsTop 104
		nsLeft 127
		nsBottom 113
		nsRight 164
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A number of ordinary rocks sit in a pile here by the riverside.}
	)
)

(instance rock2 of NewFeature
	(properties
		x 75
		y 135
		noun '/boulder'
		nsTop 118
		nsBottom 153
		nsRight 150
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This cluster of rocks by the river's edge controls the flow of the river.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 36
		y 87
		noun '/ceder'
		nsTop 65
		nsLeft 29
		nsBottom 109
		nsRight 44
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Many mature, graceful trees line the river's banks.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 302
		y 154
		noun '/bush'
		nsTop 140
		nsLeft 286
		nsBottom 169
		nsRight 319
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A large, healthy bush sits by the river.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 310
		y 133
		noun '/bush'
		nsTop 126
		nsLeft 301
		nsBottom 140
		nsRight 319
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A large, healthy bush sits by the river.}
	)
)

(instance rock4 of NewFeature
	(properties
		x 270
		y 140
		noun '/boulder'
		nsTop 128
		nsLeft 257
		nsBottom 152
		nsRight 284
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This cluster of rocks by the river's edge controls the flow of the river.}
	)
)

(instance river of NewFeature
	(properties
		x 91
		y 158
		noun '/brook,brook'
		nsTop 151
		nsLeft 32
		nsBottom 166
		nsRight 151
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The river ripples past the rocks.}
	)
)

(instance rRock of NewFeature
	(properties
		x 50
		y 152
		noun '/boulder'
		nsTop 148
		nsLeft 42
		nsBottom 156
		nsRight 58
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A few rocks project above the surface of the wildly flowing river.}
	)
)

(instance rRock1 of NewFeature
	(properties
		x 274
		y 155
		noun '/boulder'
		nsTop 153
		nsLeft 266
		nsBottom 158
		nsRight 282
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A few rocks project above the surface of the wildly flowing river.}
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
				(switch local0
					(0
						(localproc_0 41 8) ; "TROLL: "Well, what've we got here? You think yer gonna cross my bridge, do you? Not for FREE, you ain't.""
					)
					(1
						(localproc_0 41 9) ; "TROLL: "Yer quite the little chatterbox, aintcha? Well, lemmee warn ya, these bridges have been in my family for years and years, and nobody, especially not a puny little knight like yerself, has ever passed across one of our bridges without payin' our Troll Toll.""
					)
					(else
						(localproc_0 41 10) ; "TROLL: "Quit gabbin'. Are you plannin' on paying my toll, or does I hafta get tough?""
					)
				)
				(++ local0)
				(= register 1)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

