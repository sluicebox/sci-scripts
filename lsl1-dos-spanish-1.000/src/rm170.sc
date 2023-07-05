;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use Blk)
(use Feature)
(use LoadMany)
(use Wander)
(use Chase)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm170 0
)

(instance rm170 of LLRoom
	(properties
		picture 170
	)

	(method (init &tmp foo)
		(Load rsSCRIPT 972)
		(LoadMany rsVIEW 172 171 812)
		(LoadMany rsSOUND 170 192 171 172 173)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 174 0 0 319 0 319 171 253 138 221 146 188 133 67 134 0 175
					yourself:
				)
		)
		(gTheMusic number: 170 vol: 127 loop: -1 flags: 1)
		(switch gPrevRoomNum
			(100
				(if (> (gEgo x:) 160)
					(self west: gPrevRoomNum)
				else
					(self east: gPrevRoomNum)
				)
			)
			(500
				(self east: gPrevRoomNum)
			)
			(600
				(self west: gPrevRoomNum)
			)
			(300
				(self east: gPrevRoomNum)
			)
			(400
				(self west: gPrevRoomNum)
			)
			(else
				(self east: 100)
			)
		)
		(sfxFight init:)
		(sfxDizzy init:)
		(sfxBounce init:)
		(aThug
			init:
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
			setScript: sChased
		)
		(gEgo init: y: 180)
		(super init:)
		(dumpster init:)
		(fence init:)
	)

	(method (newRoom newRoomNumber)
		(gTheMusic fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 170 0) ; "A sense of foreboding washes over your heart when your eyes slowly examine this dark alley that seems to be just outside every public area in Lost Wages. Is that just another kindly citizen or a vicious mugger quickly approaching you?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sChased of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (!= (aThug moveSpeed:) (gGame egoMoveSpeed:))
			(aThug
				cycleSpeed: (gGame egoMoveSpeed:)
				moveSpeed: (gGame egoMoveSpeed:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic play:)
				(aThug setPri: 1 loop: 1 setMotion: MoveTo 223 131 self)
			)
			(1
				(aThug setPri: 3 setCycle: Walk setMotion: MoveTo 167 131 self)
			)
			(2
				(aThug
					setCycle: Walk
					setPri: -1
					setMotion: Chase gEgo 20 self
				)
			)
			(3
				(gCurRoom setScript: sMugged)
				(self dispose:)
			)
		)
	)
)

(instance sMugged of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo hide:)
				(= gSpeed (+ 4 gHowFast))
				(sfxFight play:)
				(aThug
					view: 171
					setLoop: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 175 160 self
				)
			)
			(1
				(aThug setLoop: 1 setMotion: 0)
				(= cycles 3)
			)
			(2
				(aThug
					observeBlocks: punkCircle
					setLoop: 0
					setCycle: Fwd
					setMotion: Wander
				)
				(= seconds 5)
			)
			(3
				(aThug setLoop: 1 setMotion: 0)
				(= cycles 3)
			)
			(4
				(aThug observeBlocks: punkCircle setLoop: 0 setMotion: Wander)
				(= seconds 5)
			)
			(5
				(aThug setLoop: 1 setMotion: 0)
				(= cycles 3)
			)
			(6
				(aThug
					observeBlocks: punkCircle
					setLoop: 0
					setMotion: MoveTo 116 165 self
				)
			)
			(7
				(aThug2 init: setCycle: Walk setMotion: MoveTo 184 249 self)
			)
			(8
				(gTheMusic stop:)
				(sfxFight stop:)
				(aThug hide: z: 1000)
				(sfxDizzy play:)
				(gEgo
					show:
					view: 171
					setLoop: 2
					x: 104
					y: 163
					cycleSpeed: 1
					setCycle: CT 9 1 self
				)
			)
			(9
				(sfxDizzy stop:)
				(sfxBounce play:)
				(gEgo setCycle: End self)
			)
			(10
				(sfxBounce stop:)
				(= seconds 4)
			)
			(11
				(Print 170 1) ; "Larry, when are you gonna learn to stay out of these dark alleys!!"
				(= seconds 4)
			)
			(12
				(Print 170 2) ; "Hey, guys!! He's screwed up again! Dump this one down the tubes, and get him another body!"
				(= seconds 2)
			)
			(13
				(gTheMusic2 number: 192 setLoop: -1 flags: 1 play:)
				(sfxGroundOpens play:)
				(gEgo view: 812 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 190)
			)
		)
	)
)

(instance sfxGroundOpens of Sound
	(properties
		flags 1
		number 191
	)
)

(instance sfxFight of Sound
	(properties
		flags 1
		number 171
		loop -1
	)
)

(instance sfxDizzy of Sound
	(properties
		flags 1
		number 172
	)
)

(instance sfxBounce of Sound
	(properties
		flags 1
		number 173
	)
)

(instance punkCircle of Cage
	(properties
		top 137
		left 65
		bottom 189
		right 265
	)
)

(instance aThug2 of Actor
	(properties
		x 124
		y 174
		view 172
	)
)

(instance aThug of Actor
	(properties
		x 223
		y 150
		description {the mugger}
		sightAngle 40
		lookStr {It appears he wants something -- YOU! Quick! Get out of here, Larry!}
		yStep 3
		view 172
		loop 1
		priority 2
		xStep 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 170 3) ; "Pardon me, buddy," you say, "do you have any spare change?"
				(Print 170 4 #at -1 140) ; "(He seems unamused!)"
			)
			(3 ; Do
				(Print 170 5) ; "Hey, you!" you challenge, "come over here and fight like a man!"
				(Print 170 6 #at -1 140) ; "(Dumb idea, Larry!)"
			)
			(10 ; Zipper
				(Print 170 7) ; "Your attempt to frighten the mugger fails."
			)
			(11 ; Taste/Smell
				(Print 170 8) ; "Phew!"
			)
			(4 ; Inventory
				(Print 170 9) ; "There's only one thing he wants, Larry: everything!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dumpster of Feature
	(properties
		x 222
		y 107
		nsTop 84
		nsLeft 191
		nsBottom 131
		nsRight 254
		description {the dumpster}
		sightAngle 40
		lookStr {You think you've seen this dumpster before!}
	)
)

(instance fence of Feature
	(properties
		x 144
		y 71
		nsTop 41
		nsLeft 84
		nsBottom 102
		nsRight 205
		description {the fence}
		sightAngle 40
		lookStr {You think you've seen this fence before!}
	)
)

