;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm610 0
)

(local
	[unused 4]
	cueNum
	sharkTimer
	fish1Timer
	fish2Timer
	fish3Timer
	clickX
	clickY
)

(procedure (ReviveActors)
	(aTuna init: cycleSpeed: gHowFast moveSpeed: gHowFast)
	(aShark init: cycleSpeed: gHowFast moveSpeed: gHowFast)
	(aFish1 init: cycleSpeed: gHowFast moveSpeed: gHowFast)
	(aFish2 init: cycleSpeed: gHowFast moveSpeed: gHowFast)
	(aFish3 init: cycleSpeed: gHowFast moveSpeed: gHowFast)
	(alEyes init: cycleSpeed: (+ 40 gHowFast) setCycle: RandCycle)
	(rightGuyEyes init: cycleSpeed: (+ 40 gHowFast) setCycle: RandCycle)
	(rogerHead init: cycleSpeed: (+ 90 gHowFast) setCycle: RandCycle)
	(aShark init: cycleSpeed: gHowFast moveSpeed: gHowFast)
	(= sharkTimer 300)
	(= fish1Timer 500)
	(= fish2Timer 200)
	(= fish3Timer 100)
)

(procedure (DumpActors)
	(sSharkChase dispose:)
	(sFish1 dispose:)
	(sFish2 dispose:)
	(sFish3 dispose:)
	(aFish1 dispose: delete:)
	(aFish2 dispose: delete:)
	(aFish3 dispose: delete:)
	(aShark dispose: delete:)
	(aTuna dispose: delete:)
	(alEyes dispose: delete:)
	(rightGuyEyes dispose: delete:)
	(rogerHead dispose: delete:)
)

(instance rm610 of LLRoom
	(properties
		lookStr {The disco is filled with remarkably similar guys, all looking for remarkably similar girls.}
		picture 610
		south 600
	)

	(method (init &tmp foo)
		(= foo Osc)
		(= foo ForwardCounter)
		(LoadMany rsVIEW 610 612 614 611 613)
		(LoadMany rsSOUND 610 611 321 711)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 283 189 290 180 219 176 121 179 115 172 118 159 216 136 276 136 278 116 300 110 249 107 239 100 249 84 271 75 198 75 177 80 148 77 107 78 89 84 71 84 37 95 40 109 12 125 29 139 102 139 113 157 103 164 41 167 28 186 95 186 96 189
					yourself:
				)
		)
		(= sharkTimer (Random 400 700))
		(= fish1Timer (Random 100 300))
		(= fish2Timer (Random 150 350))
		(= fish3Timer (Random 200 400))
		(switch gPrevRoomNum
			(600
				(gTheMusic fade:)
				(gTheMusic3 number: 610 vol: 127 loop: -1 flags: 1 play:)
				(self south: gPrevRoomNum)
				(gEgo init:)
			)
			(615
				(SetFlag 45) ; fLookedAtFawn
				(gEgo
					normal: 0
					init:
					view: 610
					setLoop: 11
					setCel: 3
					x: 220
					y: 73
				)
				(cond
					((IsFlag 31) ; fReadyToDance
						(gTheMusic2 prevSignal: 0)
						(Load rsPALETTE 610)
						(HandsOff)
						(if (not (IsFlag 44)) ; isVga
							(floorLight1 init:)
							(floorLight2 init:)
						)
						(gCurRoom setScript: sDance)
					)
					((IsFlag 14) ; fFawnLeaves
						(gCurRoom setScript: sFawnIsHistory)
					)
					(else
						(HandsOn)
					)
				)
			)
			(else
				(gTheMusic3 number: 610 vol: 127 loop: -1 flags: 1 play:)
				(gEgo init: x: 165 y: 100)
			)
		)
		(if (not (IsFlag 31)) ; fReadyToDance
			(ReviveActors)
		)
		(louZerr init:)
		(man2 init:)
		(man3 init:)
		(man4 init:)
		(rogerMan init:)
		(coral1 init:)
		(coral2 init:)
		(coral3 init:)
		(coral5 init:)
		(boat init:)
		(lowe init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(skirvin init:)
		(aquarium init:)
		(chair init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(if (not (IsFlag 13)) ; fFawnIsGone
			(aFawn
				cycleSpeed: gHowFast
				moveSpeed: gHowFast
				init:
				stopUpd:
				approachVerbs: 3 4 10 11 ; Do, Inventory, Zipper, Taste/Smell
			)
		)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(gEgo mover:)
				(== (gEgo view:) 610)
				(== (gEgo loop:) 11)
			)
			(= clickX ((User curEvent:) x:))
			(= clickY ((User curEvent:) y:))
			(HandsOff)
			(gCurRoom setScript: sStandUp)
		)
		(cond
			(
				(and
					(!= (gCurRoom script:) sDance)
					(== sharkTimer 0)
					(!= (aShark script:) sSharkChase)
				)
				(aShark setScript: sSharkChase)
			)
			(
				(and
					(!= (gCurRoom script:) sDance)
					(!= sharkTimer 0)
					(!= (aShark script:) sSharkChase)
				)
				(-- sharkTimer)
			)
			((== sharkTimer 0)
				(= sharkTimer (Random 200 500))
			)
		)
		(if
			(and
				(!= (gCurRoom script:) sDance)
				(== fish1Timer 0)
				(!= (aFish1 script:) sFish1)
			)
			(= fish1Timer (Random 300 500))
			(aFish1 setScript: sFish1)
		else
			(-- fish1Timer)
		)
		(if
			(and
				(!= (gCurRoom script:) sDance)
				(== fish2Timer 0)
				(!= (aFish2 script:) sFish2)
			)
			(= fish2Timer (Random 300 500))
			(aFish2 setScript: sFish2)
		else
			(-- fish2Timer)
		)
		(if
			(and
				(!= (gCurRoom script:) sDance)
				(== fish3Timer 0)
				(!= (aFish3 script:) sFish3)
			)
			(= fish3Timer (Random 300 500))
			(aFish3 setScript: sFish3)
		else
			(-- fish3Timer)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 220 75 self)
			)
			(1
				(gEgo view: 610 setLoop: 11 setCel: 0)
				(= cycles 12)
			)
			(2
				(if
					(and
						(== (aFawn view:) 612)
						(== (aFawn loop:) 4)
						(not (IsFlag 49)) ; pAskedToSit
					)
					(Points 49 1)
					(Print 610 0) ; "You smile at the girl and say, "May I join you?""
					(Print 610 1) ; "And, of course she replies, "Why, am I coming apart?""
					(drumFillSFX play:)
					(Print 610 2 #at -1 140) ; "(Drum fill)"
				)
				(= cycles 11)
			)
			(3
				(gEgo view: 610 setLoop: 11 setCycle: End self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo 2)
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self)
			)
			(2
				(HandsOn)
				(if
					(and
						(IsObject (CueObj client:))
						(!= (CueObj client:) chair)
						((CueObj client:) approachX:)
					)
					(gEgo
						setMotion:
							PolyPath
							((CueObj client:) approachX:)
							((CueObj client:) approachY:)
							CueObj
					)
				else
					(gEgo setMotion: PolyPath clickX clickY)
				)
				(self dispose:)
			)
		)
	)
)

(instance sFawnIsHistory of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(aFawn startUpd:)
				(= cycles 1)
			)
			(1
				(aFawn setCycle: Beg self)
			)
			(2
				(aFawn
					view: 612
					loop: 2
					cel: 1
					x: 174
					y: 79
					setCycle: Walk
					setMotion: PolyPath 166 249 self
				)
			)
			(3
				(SetFlag 13) ; fFawnIsGone
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDance of Script
	(properties)

	(method (doit)
		(super doit:)
		(= cueNum (gTheMusic2 prevSignal:))
		(cond
			((and (>= state 26) (>= (gTheMusic2 prevSignal:) 80))
				(self cue:)
			)
			((and (== state 21) (>= (gTheMusic2 prevSignal:) 70))
				(self cue:)
			)
			((and (== state 20) (>= (gTheMusic2 prevSignal:) 60))
				(self cue:)
			)
			((and (== state 16) (>= (gTheMusic2 prevSignal:) 50))
				(self cue:)
			)
			((and (== state 9) (>= (gTheMusic2 prevSignal:) 40))
				(self cue:)
			)
			((and (== state 6) (>= (gTheMusic2 prevSignal:) 30))
				(self cue:)
			)
			((and (== state 3) (>= (gTheMusic2 prevSignal:) 20))
				(self cue:)
			)
			((and (== state 1) (>= (gTheMusic2 prevSignal:) 10))
				(self cue:)
			)
		)
		(cond
			((and (IsFlag 44) (>= state 1) (<= state 27)) ; isVga
				(Palette palANIMATE 64 79 1)
			)
			((and (not (IsFlag 44)) (>= state 1) (<= state 27)) ; isVga
				(floorLight1 x: (Random 110 223) y: (Random 90 135))
				(floorLight2 x: (Random 110 223) y: (Random 90 135))
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 44)) ; isVga
					(floorLight1 setCycle: Fwd)
					(floorLight2 setCycle: Fwd)
				)
				(gTheMusic3 fade: 0 12 20 1 self)
			)
			(1
				(DumpActors)
				(gTheMusic2 number: 611 vol: 127 loop: 1 flags: 0 play: hold: 10)
				(if (and (== (gEgo view:) 610) (== (gEgo loop:) 11))
					(gEgo startUpd: setCycle: Beg)
				)
				(aFawn startUpd: setCycle: Beg)
			)
			(2
				(NormalEgo 2)
				(gEgo egoSpeed: gLarrySpeed setMotion: MoveTo 151 108 self)
			)
			(3
				(gTheMusic2 release:)
				(gEgo setHeading: 180)
			)
			(4
				(gTheMusic2 hold: 20)
				(aFawn
					cycleSpeed: gHowFast
					moveSpeed: gHowFast
					view: 612
					loop: 2
					cel: 1
					x: 164
					y: 79
					setCycle: Walk
					setMotion: PolyPath 183 108 self
				)
			)
			(5
				(aFawn x: (+ (aFawn x:) 1000))
				(gEgo
					normal: 0
					x: 141
					y: 108
					view: 613
					setLoop: 0
					setCycle: End self
				)
			)
			(6
				(gTheMusic2 release:)
			)
			(7
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(gEgo setLoop: 4 setCel: 0 setCycle: CT 1 1 self)
			)
			(9
				(gEgo setCycle: End self)
				(aFawn
					view: 613
					setLoop: 5
					setCel: 0
					x: 137
					y: 65
					yStep: 20
					setPri: 4
					setCycle: Fwd
					setMotion: MoveTo 139 -40
				)
				(gEgo view: 611 setLoop: 0 setCel: 0 setCycle: Fwd)
			)
			(10
				(gEgo
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 180 108 self
				)
			)
			(11
				(if (== (aFawn y:) -40)
					(aFawn stopUpd:)
				)
				(gEgo setLoop: 5 setCel: 0)
				(= cycles 15)
			)
			(12
				(gEgo
					setLoop: 2
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 120 108 self
				)
			)
			(13
				(gEgo setLoop: 6 setCel: 0)
				(= cycles 15)
			)
			(14
				(gEgo
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 154 108 self
				)
			)
			(15
				(gEgo setLoop: 7)
				(= cycles 5)
			)
			(16
				(gEgo setLoop: 9 setCycle: Fwd)
			)
			(17
				(aFawn
					startUpd:
					x: 135
					setCycle: Fwd
					setMotion: MoveTo 135 61 self
				)
			)
			(18
				(aFawn x: (+ (aFawn x:) 1000))
				(gEgo
					view: 613
					setLoop: 4
					x: 139
					y: 108
					setCel: 2
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(19
				(gEgo view: 613 setLoop: 2 setCel: 2 setCycle: Beg self)
			)
			(20
				(gEgo
					egoSpeed: gLarrySpeed
					view: 611
					setLoop: 10
					x: 153
					y: 108
					setCycle: Fwd
				)
				(aFawn view: 613 setLoop: 6 x: 122 y: 108 setCycle: Fwd)
			)
			(21
				(gEgo egoSpeed: (* 2 gLarrySpeed) setLoop: 4 setCycle: Fwd)
				(aFawn view: 612 setLoop: 0 setCel: 2 stopUpd:)
			)
			(22
				(gEgo view: 611 setLoop: 3 cycleSpeed: 4 setCycle: Fwd)
				(= seconds 1)
			)
			(23
				(aFawn
					startUpd:
					view: 612
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 174 79
				)
				(gEgo cycleSpeed: 3)
				(= seconds 1)
			)
			(24
				(gEgo cycleSpeed: 2)
				(= seconds 1)
			)
			(25
				(gEgo cycleSpeed: 1)
				(= seconds 1)
			)
			(26
				(gEgo cycleSpeed: 0)
			)
			(27
				(gEgo setLoop: 0 setCel: 4)
				(gTheMusic2 prevSignal: 0)
				(= cycles 2)
			)
			(28
				(if (IsFlag 44) ; isVga
					(Palette palSET_FROM_RESOURCE 610 2)
				else
					(floorLight1 dispose:)
					(floorLight2 dispose:)
				)
				(sfxCheer play:)
				(= seconds 10)
			)
			(29
				(aFawn
					startUpd:
					view: 612
					setLoop: 4
					setCel: 0
					setPri: 3
					setCycle: End
				)
				(NormalEgo 2)
				(gTheMusic3 play:)
				(ReviveActors)
				(SetFlag 3) ; fDancedWithFawn
				(ClearFlag 31) ; fReadyToDance
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance sSharkChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aTuna
					init:
					x: 334
					y: 43
					setLoop: 1
					cycleSpeed: gHowFast
					moveSpeed: gHowFast
					setCycle: Fwd
					setMotion: MoveTo 138 43 self
				)
				(= cycles 30)
			)
			(1
				(aShark
					init:
					x: 40
					y: 25
					setPri: 0
					cycleSpeed: gHowFast
					moveSpeed: gHowFast
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 54 25
				)
			)
			(2
				(aShark xStep: 25 setMotion: MoveTo 350 43 self)
				(aTuna setLoop: 0 xStep: 25 setMotion: MoveTo 360 43)
			)
			(3
				(= cycles 60)
			)
			(4
				(aTuna
					setLoop: 0
					x: -11
					y: 43
					setPri: 1
					setMotion: MoveTo 85 32 self
				)
			)
			(5
				(aTuna setLoop: 1 setPri: 0 setMotion: MoveTo 40 32 self)
			)
			(6
				(= cycles 5)
			)
			(7
				(aShark
					setLoop: 2
					x: -17
					y: 43
					xStep: 5
					setPri: 1
					setMotion: MoveTo 139 24 self
				)
			)
			(8
				(aShark setCycle: Fwd)
				(= cycles 15)
			)
			(9
				(aShark setLoop: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(10
				(aShark setLoop: 2 setCycle: Fwd setMotion: MoveTo 350 43 self)
			)
			(11
				(aTuna
					setLoop: 0
					setPri: 0
					xStep: 3
					setMotion: MoveTo 85 32 self
				)
			)
			(12
				(aTuna setLoop: 10 setCycle: Fwd)
				(= cycles 20)
			)
			(13
				(aTuna setLoop: 1 setPri: 1 setMotion: MoveTo -11 43 self)
			)
			(14
				(aShark dispose:)
				(aTuna dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFish1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (aFish1 x:) 100)
					(aFish1
						init:
						setLoop: 5
						setCycle: Fwd
						setMotion: MoveTo -30 (aFish1 y:) self
					)
				else
					(aFish1
						setLoop: 4
						setCycle: Fwd
						setMotion: MoveTo 340 (aFish1 y:) self
					)
				)
			)
			(1
				(= cycles (Random 200 700))
			)
			(2
				(aFish1 dispose:)
				(self init:)
			)
		)
	)
)

(instance sFish2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (aFish2 x:) 100)
					(aFish2
						init:
						setLoop: 7
						setCycle: Fwd
						setMotion: MoveTo -30 (aFish2 y:) self
					)
				else
					(aFish2
						setLoop: 6
						setCycle: Fwd
						setMotion: MoveTo 340 (aFish2 y:) self
					)
				)
			)
			(1
				(= cycles (Random 200 700))
			)
			(2
				(aFish2 dispose:)
				(self init:)
			)
		)
	)
)

(instance sFish3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (aFish3 x:) 100)
					(aFish3
						init:
						setLoop: 9
						setCycle: Fwd
						setMotion: MoveTo -30 (aFish3 y:) self
					)
				else
					(aFish3
						setLoop: 8
						setCycle: Fwd
						setMotion: MoveTo 340 (aFish3 y:) self
					)
				)
			)
			(1
				(= cycles (Random 200 700))
			)
			(2
				(aFish3 dispose:)
				(self init:)
			)
		)
	)
)

(instance sfxCheer of Sound
	(properties
		flags 1
		number 711
	)
)

(instance aTuna of Actor
	(properties
		x 334
		y 43
		description {the fish}
		lookStr {What a great idea! Live fish in an aquarium.}
		view 610
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aShark of Actor
	(properties
		x 40
		y 25
		description {Jaws}
		lookStr {It's just a small shark!}
		view 610
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aFawn of Person
	(properties
		x 168
		y 77
		description {the girl}
		approachX 199
		approachY 75
		view 612
		loop 4
		cel 4
		priority 3
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(Print 610 3) ; "She might listen to you, if you can establish eye contact."
			)
			(5 ; Talk
				(if (and (== (gEgo view:) 610) (== (gEgo loop:) 11))
					(Print 610 3) ; "She might listen to you, if you can establish eye contact."
				else
					(Print 610 4) ; "Perhaps you should sit with her first."
				)
			)
			(3 ; Do
				(cond
					((IsFlag 3) ; fDancedWithFawn
						(Print 610 5) ; "Not again. That trip through the ceiling gave me a headache!"
					)
					((IsFlag 45) ; fLookedAtFawn
						(Print 610 6) ; "You screw up your courage and ask, "What would you say to a spin around the dance floor with the nearest thing to John Travolta, baby?""
						(Print 610 7) ; "Well, okay, I guess," she replies, thinking to herself, "near as I'm gonna get!"
						(Points 54 5)
						(HandsOff)
						(if (not (IsFlag 44)) ; isVga
							(floorLight1 init:)
							(floorLight2 init:)
						)
						(gCurRoom setScript: sDance)
					)
					(else
						(Print 610 8) ; "Hey, Baby, what's a beautiful doll like you doing sitting all alone?" you say to the beautiful doll sitting all alone. "Wanna dance?"
						(Print 610 9) ; "Dance? With you?" she replies, "Why I don't even know you."
					)
				)
			)
			(10 ; Zipper
				(Print 610 10) ; "Once again, you're a little premature, Larry!"
			)
			(11 ; Taste/Smell
				(Print 610 11) ; "The girl smells of expensive perfume and has even more expensive tastes."
			)
			(2 ; Look
				(cond
					(
						(and
							(not (IsFlag 13)) ; fFawnIsGone
							(== (gEgo view:) 610)
							(== (gEgo loop:) 11)
						)
						(HandsOff)
						(gCurRoom newRoom: 615)
					)
					((and (not (IsFlag 32)) (IsFlag 13)) ; fReadyToMarry, fFawnIsGone
						(Print 610 12) ; "Gosh, Larry. Maybe you should have loaned her some money!"
					)
					((not (IsFlag 13)) ; fFawnIsGone
						(Print 610 13) ; "There's a gorgeous blond sitting at the table, and she's all alone!"
						(Print 610 14) ; "Perhaps you should sit with her."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance aFish1 of Actor
	(properties
		x -30
		y 41
		description {the fish}
		lookStr {Look at those fish go!}
		view 610
		loop 4
		priority 1
		signal 16400
		detailLevel 1
		xStep 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 15) ; "Stop tapping on the glass!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aFish2 of Actor
	(properties
		x 340
		y 30
		description {the fish}
		lookStr {Look at those fish go!}
		view 610
		loop 7
		priority 1
		signal 16400
		detailLevel 1
		xStep 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 15) ; "Stop tapping on the glass!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aFish3 of Actor
	(properties
		x -25
		y 41
		description {the fish}
		lookStr {Look at those fish go!}
		view 610
		loop 8
		priority 1
		signal 16400
		detailLevel 1
		xStep 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 15) ; "Stop tapping on the glass!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance floorLight1 of Actor
	(properties
		x 155
		y 112
		view 610
		loop 12
		priority 2
		signal 16400
	)
)

(instance floorLight2 of Actor
	(properties
		x 155
		y 112
		view 610
		loop 12
		priority 2
		signal 16400
	)
)

(instance alEyes of Prop
	(properties
		x 13
		y 64
		view 614
		cycleSpeed 30
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(lowe doVerb: theVerb invItem)
	)
)

(instance rightGuyEyes of Prop
	(properties
		x 289
		y 61
		view 614
		loop 1
		priority 5
		signal 16
		cycleSpeed 30
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rogerHead of Prop
	(properties
		x 9
		y 136
		view 614
		loop 2
		cycleSpeed 50
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 235
		y 64
		nsTop 54
		nsLeft 211
		nsBottom 75
		nsRight 259
		description {the chair}
		sightAngle 40
		approachX 220
		approachY 73
		lookStr {It looks like the best seat in the house.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sSitDown)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance boat of Feature
	(properties
		x 194
		y 36
		nsTop 29
		nsLeft 167
		nsBottom 43
		nsRight 221
		description {the sunken boat}
		sightAngle 40
		lookStr {"...on a three-hour tour!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lowe of Feature
	(properties
		x 18
		y 73
		nsTop 55
		nsBottom 92
		nsRight 36
		description {Al Lowe}
		sightAngle 40
		approachX 46
		approachY 97
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 610 16) ; "My, that Al Lowe is a stunningly handsome fellow!"
				(Print 610 17 #at -1 140) ; "(The preceding was a paid editorial message.)"
			)
			(3 ; Do
				(Print 610 18) ; "Trust me; don't touch me!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance skirvin of Feature
	(properties
		x 77
		y 60
		nsTop 41
		nsLeft 65
		nsBottom 79
		nsRight 90
		description {Bill Skirvin}
		sightAngle 40
		lookStr {You wonder if Patti knows Bill is hanging around with Al Lowe again!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 19) ; ""Hey! Keep your hands off me!" shouts Skirvin."
			)
			(5 ; Talk
				(Print 610 20) ; ""Wanna go somewhere after this, Bill?" you ask William Skirvin, creator of all the wonderful graphics in this game."
				(Print 610 21) ; ""Zzzzzzzzzz," replies Bill from behind his shades."
				(Print 610 22 #at -1 140) ; "(Bill is the master of the sitting nap!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aquarium of Feature
	(properties
		x 159
		y 21
		nsBottom 43
		nsRight 319
		description {the aquarium}
		sightAngle 40
		lookStr {A few fish swim around in the gigantic aquarium.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 23) ; "Don't tap on the glass!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance louZerr of Feature
	(properties
		x 237
		y 167
		z 36
		nsTop 114
		nsLeft 225
		nsBottom 148
		nsRight 250
		description {Kevin Ray}
		sightAngle 40
		lookStr {Kevin is that handsome gent near the divider.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 24) ; "HEY! Stop doing that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance man2 of Feature
	(properties
		x 300
		y 167
		z 28
		nsTop 122
		nsLeft 288
		nsBottom 157
		nsRight 313
		description {Barry Smith}
		sightAngle 40
		lookStr {Barry Smith thought he could hide out here, instead of drawing for a living!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 25) ; "Barry's clothes are covered with paint."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance man3 of Feature
	(properties
		x 11
		y 137
		nsTop 116
		nsBottom 159
		nsRight 23
		description {Mike}
		sightAngle 40
		lookStr {Mike feels good like a programmer should.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 26) ; "Mike feels good, like a programmer should."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance man4 of Feature
	(properties
		x 84
		y 140
		nsTop 123
		nsLeft 73
		nsBottom 157
		nsRight 95
		description {Oliver Brelsford}
		sightAngle 40
		lookStr {Oliver Brelsford's neck must be getting stiff by now, staring across the room.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 27) ; "Oliver enjoys being touched like that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rogerMan of Feature
	(properties
		x 282
		y 76
		nsTop 53
		nsLeft 267
		nsBottom 99
		nsRight 298
		description {Roger Hardy}
		sightAngle 40
		lookStr {Have you ever seen Roger in a chair high enough so his legs weren't scrambled?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 28) ; "Roger FEELS life-like!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coral1 of Feature
	(properties
		x 225
		y 160
		nsTop 142
		nsLeft 131
		nsBottom 178
		nsRight 319
		description {the coral room divider}
		sightAngle 40
		lookStr {It's not often you see coral used for a room divider.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 29) ; "Ouch! That coral is sharp!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coral2 of Feature
	(properties
		x 11
		y 99
		nsTop 86
		nsBottom 112
		nsRight 22
		description {the coral}
		sightAngle 40
		lookStr {It's not often you see coral used for a room divider.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 29) ; "Ouch! That coral is sharp!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coral3 of Feature
	(properties
		x 113
		y 56
		nsTop 42
		nsLeft 94
		nsBottom 71
		nsRight 132
		description {the coral}
		sightAngle 40
		lookStr {It's not often you see coral used for a room divider.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 29) ; "Ouch! That coral is sharp!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coral5 of Feature
	(properties
		x 306
		y 118
		nsTop 102
		nsLeft 294
		nsBottom 135
		nsRight 319
		description {the coral}
		sightAngle 40
		lookStr {It's not often you see coral used for a room divider.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 610 29) ; "Ouch! That coral is sharp!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance drumFillSFX of Sound
	(properties
		flags 1
		number 321
	)
)

