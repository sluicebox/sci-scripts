;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
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
	rm25 0
)

(local
	local0
	local1
	local2
	local3
	[local4 3]
	[local7 3] = [195 23 251]
	[local10 3] = [104 90 118]
	[local13 3] = [1 3 3]
	[local16 3] = [-1 1 3]
)

(procedure (localproc_0)
	(localproc_1)
	(Print &rest #title {Troll} #font 4 #at 144 20 #width 150 #dispose)
)

(procedure (localproc_1)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(instance rm25 of Rm
	(properties
		picture 25
		horizon 45
		north 40
		east 26
		south 24
		west 32
	)

	(method (init)
		(Load rsVIEW 241)
		(LoadMany rsVIEW 120 124 123 126 168 44)
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
				(gEgo y: (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(if (< (gEgo y:) 100)
					(gEgo posn: 3 (proc0_17 56 (gEgo y:) (+ 2 horizon)))
				else
					(gEgo posn: 3 (proc0_17 188 (gEgo y:) 134))
				)
			)
			(east
				(if (< (gEgo y:) 100)
					(gEgo posn: 317 (proc0_17 57 (gEgo y:) (+ 2 horizon)))
				else
					(gEgo posn: 317 (proc0_17 188 (gEgo y:) 130))
				)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(for ((= local3 0)) (< local3 3) ((++ local3))
			((= [local4 local3] (Clone Ripple))
				view: 241
				x: [local7 local3]
				y: [local10 local3]
				setLoop: [local13 local3]
				setPri: [local16 local3]
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
		(bushAndRock init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
		(bridge1 init:)
		(bridge2 init:)
		(bridge3 init:)
		(bridge4 init:)
		(river init:)
		(bank init:)
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
						(<= (gEgo x:) 122)
						(>= (gEgo x:) 104)
						(== (leftArm cel:) 0)
						(== (rightArm cel:) 0)
						(not (gMenace script:))
					)
					(if (<= (gEgo y:) 107)
						(gMenace setScript: pushBack)
					)
				)
				(
					(or
						(>= (gEgo distanceTo: gMenace) 45)
						(and
							(<= (gEgo distanceTo: gMenace) 45)
							(<= (gEgo x:) 122)
							(>= (gEgo x:) 104)
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
						(>= (gEgo x:) 123)
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
						(<= (gEgo x:) 103)
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
				(gEgo ignoreBlocks: bridge25Block)
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
				(Print 25 0) ; "A rough-hewn plank bridge spans the deep rushing river here."
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
					(Print 25 1) ; "There is no one to talk to here."
				)
			)
			((Said 'look,look/ceder')
				(Print 25 2) ; "The trees flourish in the moist, healthy soil around the river."
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
				(gEgo stopUpd:)
				(leftArm dispose:)
				(rightArm dispose:)
				(trollFace dispose:)
				(gMenace
					view: 120
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 112 49 self
				)
			)
			(1
				(gMenace setMotion: MoveTo -25 49 self)
			)
			(2
				(gEgo ignoreBlocks: bridge25Block)
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
				(gEgo observeBlocks: bridge25Block)
				(gMenace posn: -25 49 show: setMotion: MoveTo 112 49 self)
			)
			(1
				(gMenace setMotion: MoveTo 112 95 self)
			)
			(2
				(leftArm init: stopUpd:)
				(rightArm init: stopUpd:)
				(trollFace init: stopUpd:)
				(gMenace view: 123 setLoop: 0 setCel: 1 ignoreControl:)
				(= cycles 1)
			)
			(3
				(gMenace stopUpd:)
				(if (IsFlag 1)
					(Print 25 3) ; "As you start to cross the bridge, a huge, hulking troll stomps into view and blocks your way. Even though you are invisible, the troll can sense your presence and will not allow you to cross his bridge."
				else
					(Print 25 4) ; "As you start to cross the bridge, a huge, hulking troll stomps into view and blocks your way."
				)
				(= cycles 1)
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
				(leftArm hide: stopUpd:)
				(rightArm hide: stopUpd:)
				(trollFace hide: stopUpd:)
				(gMenace view: 126 setLoop: 1 setCycle: CT 2 1 self)
			)
			(1
				(if (IsFlag 1)
					(Print 25 5) ; "As the troll pushes you back your ring slips off and falls into the river. It's gone forever!"
					(ClearFlag 1)
					(gEgo put: 5) ; Magic_Ring
				)
				(gEgo view: 44 setLoop: 1)
				(gMenace cel: 2 setCycle: End self)
			)
			(2
				(gEgo y: (+ (gEgo y:) 4))
				(= cycles 1)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10))
				(= cycles 3)
			)
			(4
				(gMenace cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(HandsOn)
				(leftArm show: stopUpd:)
				(rightArm show: stopUpd:)
				(trollFace show: stopUpd:)
				(gMenace
					view: 123
					setLoop: 0
					setCel: 1
					cycleSpeed: 0
					ignoreControl:
					stopUpd:
				)
				(gEgo view: 0 loop: 3)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance trollFace of Prop
	(properties
		x 112
		y 66
		description {troll}
		view 123
		loop 6
		priority 6
		signal 16
	)
)

(instance splash of Prop
	(properties)
)

(instance leftArm of Prop
	(properties
		x 106
		y 58
		description {troll}
		view 123
		loop 2
		priority 5
		signal 16
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
		x 118
		y 58
		description {troll}
		view 123
		loop 3
		priority 5
		signal 16
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

(instance bridge25Block of Blk
	(properties
		top 92
		left 82
		bottom 96
		right 144
	)
)

(instance GoatButt of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 2) (<= (gGoat y:) 105) (not local1))
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
				(Print 25 6) ; "It is a well known fact that goats hate trolls intensely. You move aside and let the goat take care of this wretched, nasty troll."
				(if (< (gGoat x:) 121)
					(gEgo setMotion: MoveTo 166 144 self)
				else
					(gEgo setMotion: MoveTo 80 143 self)
				)
			)
			(1
				(gEgo setLoop: 3 stopUpd:)
				(gGoat setMotion: MoveTo 112 145 self)
			)
			(2
				(gGoat setMotion: MoveTo 112 100 self)
			)
			(3
				((ScriptID 0 21) number: 38 init: play:) ; gameSound
				(self cue:)
			)
			(4
				(leftArm dispose:)
				(rightArm dispose:)
				(trollFace dispose:)
				(gGoat stopUpd:)
				(gMenace view: 124 setPri: 8 illegalBits: 0 setStep: 12 9)
				(gMenace setLoop: 0 setMotion: MoveTo 100 79 self)
			)
			(5
				(gMenace setMotion: MoveTo 77 70 self)
			)
			(6
				(gMenace setMotion: MoveTo 53 82 self)
			)
			(7
				(gMenace setMotion: MoveTo 46 100 self)
			)
			(8
				((ScriptID 0 21) number: 14 play:) ; gameSound
				(splash
					view: 124
					setLoop: 2
					cycleSpeed: 2
					setPri: 2
					posn: 39 110
					init:
				)
				(gMenace setMotion: MoveTo 42 107 self)
			)
			(9
				(ClearFlag 13)
				(gMenace dispose:)
				(splash setCycle: End self)
			)
			(10
				(splash dispose:)
				(SetScore 106 4)
				(Print 25 7) ; "The goat lowers his head and runs straight for the troll, butting him right off the bridge and into the river below. That's the last you'll see of that troll."
				((ScriptID 0 23) fade:) ; backSound
				((gGoat looper:) viewNormal: 165)
				(gGoat setStep: 3 2 setMotion: MoveTo 112 220 self)
			)
			(11
				(gEgo illegalBits: -32768 setLoop: -1)
				(HandsOn)
				(ClearFlag 2)
				(SetFlag 5)
				(gEgo ignoreBlocks: bridge25Block)
				(LoadMany 0 971 985)
				(gGoat dispose:)
				(self dispose:)
			)
		)
	)
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
			((Said 'look,look/brook,boulder,water')
				(Print 25 8) ; "These rocks are worn smooth from countless years of swiftly flowing water."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 25 8) ; "These rocks are worn smooth from countless years of swiftly flowing water."
			)
		)
	)
)

(instance bushAndRock of NewFeature
	(properties
		x 50
		y 139
		noun '/bush'
		nsTop 125
		nsLeft 25
		nsBottom 154
		nsRight 76
		description {bush and rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A commonplace little bush has grown in the protective shade of the rock.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 256
		y 155
		noun '/bush'
		nsTop 149
		nsLeft 224
		nsBottom 162
		nsRight 288
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are more bushes in Daventry than you care to notice.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 255
		y 143
		noun '/bush'
		nsTop 138
		nsLeft 241
		nsBottom 149
		nsRight 269
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are more bushes in Daventry than you care to notice.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 19
		y 43
		noun '/bush'
		nsTop 27
		nsBottom 60
		nsRight 39
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are more bushes in Daventry than you care to notice.}
	)
)

(instance bush4 of NewFeature
	(properties
		x 44
		y 49
		noun '/bush'
		nsTop 40
		nsLeft 38
		nsBottom 59
		nsRight 51
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There are more bushes in Daventry than you care to notice.}
	)
)

(instance river of NewFeature
	(properties
		x 160
		y 105
		noun '/brook,water,brook'
		nsTop 85
		nsBottom 129
		nsRight 320
		description {river}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The current of this wildly raging river is even more treacherous than it looks.}
	)
)

(instance bank of NewFeature
	(properties
		x 160
		y 73
		noun '/bank[<brook]'
		nsTop 62
		nsBottom 84
		nsRight 320
		description {bank}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The river bank drops off sharply here.__Best to watch your step.}
	)
)

(instance bridge1 of NewFeature
	(properties
		x 112
		y 95
		noun '/bridge,crossing'
		nsTop 62
		nsLeft 90
		nsBottom 129
		nsRight 135
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A rough-hewn plank bridge spans the deep rushing river below.}
	)
)

(instance bridge2 of NewFeature
	(properties
		x 140
		y 110
		noun '/bridge,crossing'
		nsTop 93
		nsLeft 135
		nsBottom 128
		nsRight 145
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A rough-hewn plank bridge spans the deep rushing river below.}
	)
)

(instance bridge3 of NewFeature
	(properties
		x 149
		y 121
		noun '/bridge,crossing'
		nsTop 114
		nsLeft 145
		nsBottom 129
		nsRight 154
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A rough-hewn plank bridge spans the deep rushing river below.}
	)
)

(instance bridge4 of NewFeature
	(properties
		x 85
		y 110
		noun '/bridge,crossing'
		nsTop 92
		nsLeft 82
		nsBottom 129
		nsRight 89
		description {bridge}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A rough-hewn plank bridge spans the deep rushing river below.}
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
				(switch local0
					(0
						(localproc_0 25 9) ; "TROLL: "Well, what've we got here? You think yer gonna cross my bridge, do you? Not for FREE, you ain't.""
					)
					(1
						(localproc_0 25 10) ; "TROLL: "Yer quite the little chatterbox, aintcha? Well, lemmee warn ya, these bridges have been in my family for years and years, and nobody, especially not a puny little knight like yerself, has ever passed across one of our bridges without payin' our Troll Toll.""
					)
					(else
						(localproc_0 25 11) ; "TROLL: "Quit gabbin'. Are you plannin' on paying my toll, or does I hafta get tough?""
					)
				)
				(++ local0)
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

