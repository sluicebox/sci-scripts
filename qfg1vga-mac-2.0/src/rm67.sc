;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use n105)
(use TargActor)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm67 0
	foxTalker 1
)

(local
	[local0 8] = [219 313 90 246 53 60 52 148]
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(instance rm67 of Rm
	(properties
		picture 67
		style 8
		horizon 55
	)

	(method (dispose)
		(SetFlag 57)
		(= global104 (gEgo y:))
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
			(gCurRoom obstacles: 0)
		)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(if (not gNight)
			(LoadMany rsVIEW 67 510)
		)
		(super init:)
		(SL enable:)
		(if (and (== gNight 0) (or (== global287 6) (== global287 9)))
			(sinclair init:)
		)
		(if (and (== global287 2) (== gNight 0))
			(= local10 1)
			(LoadMany rsVIEW 1068 68 522 518)
			(fox init: setScript: foxCallForHelp)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 123 93 123 75 160 75 160 93
						yourself:
					)
			)
			(gMessager say: 2 0 0 1) ; "There seems to be a fox north of the road."
		)
		(if (not local10)
			(eyes1 setPri: 14 init: stopUpd: setScript: peekABooScript1)
			(eyes2 setPri: 14 init: stopUpd: setScript: peekABooScript2)
		)
	)

	(method (doit)
		(if
			(and
				(== gNight 0)
				local10
				(not local14)
				(not (fox script:))
				(not (gEgo script:))
				(< (gEgo distanceTo: fox) 75)
			)
			(= local14 1)
			(fox setScript: foxExplains)
		)
		(if (and local10 (== gNight 1) (gCast contains: fox))
			(gCurRoom setScript: unknown_67_12)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; openSpell
				(if local10
					(if (TrySkill 17 25) ; openSpell
						(= local11 1)
						(SolvePuzzle 686 10)
					else
						(= local12 1)
					)
					(gEgo setScript: foxFreed)
				else
					(gMessager say: 2 51 1) ; "There is no point to that."
				)
			)
			(50 ; detectMagicSpell
				(if local10
					(gMessager say: 2 50 0) ; "There is an aura of magic around the fox."
				else
					(gMessager say: 2 50 1) ; "There is no magic present."
				)
			)
			(78 ; dazzleSpell
				(if local10
					(gMessager say: 2 78 0) ; "The fox is in such pain that it's already dazzled."
				else
					(gMessager say: 2 51 1) ; "There is no point to that."
				)
			)
			(80 ; calmSpell
				(if local10
					(gMessager say: 2 80 0) ; "You realize, of course, I really find it hard to relax with this thing on my leg."
				else
					(gMessager say: 2 51 1) ; "There is no point to that."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fox of TargActor
	(properties
		x 137
		y 90
		noun 1
		view 67
		targDeltaY 10
	)

	(method (getHurt)
		(self setScript: distantFoxDies)
	)

	(method (init)
		(HandsOff)
		(if (== gPrevRoomNum 57)
			(gEgo setScript: foxNorth)
		else
			(gEgo setScript: foxWalk)
		)
		(super init:)
	)

	(method (dispose)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
			(gCurRoom obstacles: 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 74 185 79 152 69 144 23 130 23 115 68 78 82 0 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 120 89 161 177 161 319 117 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 120 94 120 80 147 80 147 94
					yourself:
				)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (not local14)
					(gMessager say: 1 57 0) ; "My foot is caught in this cruel trap and I am in great pain. Surely you could take a minute and set me free."
					(= local14 1)
				else
					(gMessager say: 1 57 1) ; "I am in such pain and agony I cannot think. Help me, good adventurer, please."
				)
			)
			(4 ; Do
				(if local10
					(if (and (< (gEgo y:) 112) (< 60 (gEgo x:) 112))
						(gMessager say: 1 4 0) ; "Walk around to the other side of the fox, where the trap is."
					else
						(SolvePuzzle 686 10)
						(gEgo setScript: foxFreed)
					)
				else
					(gMessager say: 1 4 1) ; "The fox is gone."
				)
			)
			(70 ; ???
				(if local10
					(if local15
						(dart init: setScript: flameDartFox)
					else
						(gMessager say: 1 70 0) ; "You don't have to put me out of my misery, you just have to get me out of this trap."
						(= local15 1)
					)
				else
					(gMessager say: 2 51 1) ; "There is no point to that."
				)
			)
			(20 ; rock
				(self setScript: foxDies)
			)
			(16 ; dagger
				(self setScript: foxDies)
			)
			(12 ; sword
				(self setScript: foxDies)
			)
			(17 ; lockPick
				(if local10
					(if (and (< (gEgo y:) 112) (< 60 (gEgo x:) 112))
						(gMessager say: 1 4 0) ; "Walk around to the other side of the fox, where the trap is."
					else
						(TrySkill 9 30) ; pick locks
						(SolvePuzzle 686 10)
						(gEgo setScript: foxFreed)
					)
				else
					(gMessager say: 1 4 1) ; "The fox is gone."
				)
			)
			(18 ; thiefKit
				(if local10
					(if (and (< (gEgo y:) 112) (< 60 (gEgo x:) 112))
						(gMessager say: 1 4 0) ; "Walk around to the other side of the fox, where the trap is."
					else
						(TrySkill 9 30) ; pick locks
						(SolvePuzzle 686 10)
						(gEgo setScript: foxFreed)
					)
				else
					(gMessager say: 1 4 1) ; "The fox is gone."
				)
			)
			(26 ; brassKey
				(if local10
					(if (and (< (gEgo y:) 112) (< 60 (gEgo x:) 112))
						(gMessager say: 1 4 0) ; "Walk around to the other side of the fox, where the trap is."
					else
						(TrySkill 9 30) ; pick locks
						(SolvePuzzle 686 10)
						(gEgo setScript: foxFreed)
					)
				else
					(gMessager say: 1 4 1) ; "The fox is gone."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dart of Actor
	(properties
		x 1000
		y 500
		z 12
		view 522
		illegalBits 0
	)
)

(instance sinclair of Actor
	(properties
		x 350
		y 109
		noun 3
		view 67
		loop 8
		signal 18432
		illegalBits 0
	)

	(method (doit)
		(cond
			((and (not local16) (== (sinclair cel:) 0))
				(= local16 1)
				(ShakeScreen 1)
			)
			((and local16 (== (sinclair cel:) 1))
				(= local16 0)
			)
		)
		(super doit:)
	)

	(method (init)
		(HandsOff)
		(gEgo setScript: dinoWalk)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== global287 6)
					(gMessager say: 3 1 0) ; "It looks like a dinosaur trudging grumpily to work."
				else
					(gMessager say: 3 1 1) ; "It looks like a dinosaur skipping merrily back home from work."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trap of View
	(properties
		x 137
		y 90
		noun 4
		view 67
		loop 1
		cel 14
		signal 16400
	)
)

(instance eyes1 of Prop
	(properties
		view 67
		loop 6
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance eyes2 of Prop
	(properties
		view 67
		loop 7
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance foxCallForHelp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fox setCycle: End)
			)
			(1
				(gMessager say: 2 0 5 1 self) ; "Help me, Brave and Kind Hero."
				(fox loop: 0 cel: 0 setCycle: Fwd)
			)
			(2
				(fox setCycle: End)
				(= ticks 480)
			)
			(3
				(fox loop: 0 cel: 0 setCycle: Fwd)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 2 0 6 1 self) ; "Please help me, Brave and Kind Hero."
			)
			(4
				(fox setCycle: End self)
			)
			(5
				(client setScript: thrashAndWait)
			)
		)
	)
)

(instance foxWillNotFight of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 2 0 7) ; "Please have mercy on a creature who is in great pain."
			)
			(1
				(fox loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 2 0 8) ; "The fox does not seem to want to fight."
			)
		)
	)
)

(instance foxExplains of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 2 0 3 0 self) ; "My foot is caught in this cruel trap and I am in great pain. Surely you could take a minute and set me free."
			)
			(1
				(fox loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(HandsOn)
				(fox setScript: thrashAndWait)
			)
		)
	)
)

(instance distantFoxDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(= local10 0)
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(SolvePuzzle 604 -10)
				(= global251 0)
				(HandsOn)
				(gMessager say: 2 0 2) ; "That was strange, no sooner did you kill the fox than it vanished."
				(client dispose:)
			)
		)
	)
)

(instance foxDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(= local10 0)
				(if (gEgo inRect: 41 109 111 138)
					(self cue:)
				else
					(gEgo
						ignoreActors:
						illegalBits: 0
						setMotion: MoveTo 120 130 self
					)
				)
			)
			(1
				(gEgo
					ignoreActors:
					setMotion: MoveTo (+ (fox x:) 20) (+ (fox y:) 2) self
				)
			)
			(2
				(gEgo view: 518 setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(6
				(SolvePuzzle 604 -10)
				(HandsOn)
				(= global251 0)
				(gMessager say: 2 0 2) ; "That was strange, no sooner did you kill the fox than it vanished."
				(client dispose:)
			)
		)
	)
)

(instance unknown_67_12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(= local10 0)
				(= cycles 1)
			)
			(1
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(HandsOn)
				(fox dispose:)
				(self dispose:)
			)
		)
	)
)

(instance foxFreed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or local11 local12)
					(CastOpen rm67 self)
				else
					(self cue:)
				)
			)
			(1
				(if (not (== (fox script:) thrashAndWait))
					(fox setScript: thrashAndWait)
				)
				(if (IsObject foxCallForHelp)
					(foxCallForHelp dispose:)
				)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 41 109 111 138)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 112 130 self)
				)
			)
			(2
				(Face gEgo fox)
				(= ticks 60)
			)
			(3
				(gEgo setMotion: PolyPath (- (fox x:) 20) (fox y:) self)
			)
			(4
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(cond
					(local12
						(gMessager say: 2 0 4 1 self) ; "Hmmm. Perhaps it needed a stronger spell."
					)
					(local11
						(gMessager say: 2 0 4 2 self) ; "Your powerful Open spell springs the trap."
					)
					(else
						(gMessager say: 2 0 4 3 self) ; "You spring the trap."
					)
				)
			)
			(6
				(gEgo x: (- (gEgo x:) 5) setCycle: Beg self)
			)
			(7
				(if local12
					(= local12 0)
					(NormalEgo)
					(HandsOn)
					(fox setScript: foxExplains)
					(client setScript: 0)
				else
					(= local13 1)
					(= local10 0)
					(= ticks 60)
				)
			)
			(8
				(fox setLoop: 3 setCel: 0 setCycle: CT 6 1 self)
			)
			(9
				(trap addToPic:)
				(fox setCycle: End self)
			)
			(10
				(fox
					setLoop: 4
					setCel: 0
					setMotion: MoveTo (+ (fox x:) 18) (+ (fox y:) 6)
					setCycle: CT 3 1 self
				)
			)
			(11
				(fox setLoop: 3 setCel: 8)
				(= local10 0)
				(gMessager say: 2 0 4 4 self) ; "In exchange for your kindness, I will give you some advice and a bit of information. First of all, it sometimes pays off to be polite, even to rude people."
			)
			(12
				(gMessager say: 2 0 4 5 self) ; "As for the amusing tidbit -- Baba Yaga put an enchantment on the Baron's Daughter some years back. To break the spell you need to talk to the Dryad. Au Revoir, Ta-ta for now, Be seeing you."
			)
			(13
				(gEgo view: 68 loop: 0 cel: 0 setCycle: End)
				(fox
					setLoop: 4
					cycleSpeed: 3
					setStep: 6 6
					moveSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo 335 120 self
				)
			)
			(14
				(NormalEgo)
				(HandsOn)
				(fox dispose:)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance flameDartFox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(= local10 0)
				(fox setScript: 0)
				(gEgo
					view: 522
					setLoop: (if (< (gEgo x:) (fox x:)) 0 else 1)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(dart
					setLoop: 2
					setStep: 18 12
					setPri: 12
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					show:
					setCycle: Fwd
					startUpd:
				)
				(dart setMotion: MoveTo (+ (fox x:) 3) (fox y:) self)
			)
			(2
				(dart setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(fox loop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(HandsOn)
				(NormalEgo)
				(gMessager say: 2 0 2) ; "That was strange, no sooner did you kill the fox than it vanished."
				(= ticks 120)
			)
		)
	)
)

(instance getTrap of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 41 109 111 138)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 112 130 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 58 113 self)
			)
			(2
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 2 0 9) ; "The trap seems to be caught on something. You can't pull it loose."
				(self cue:)
			)
			(4
				(= cycles 8)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance thrashAndWait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fox setLoop: 0 setCycle: End self)
			)
			(1
				(fox cel: 0)
				(= ticks (Random 180 480))
			)
			(2
				(if (and local10 (not (== (gEgo script:) foxFreed)))
					(self changeState: 0)
				else
					(self cue:)
				)
			)
		)
	)
)

(instance peekABooScript1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 (Random 1 4))
				(client cel: 0)
				(self cue:)
			)
			(1
				(client
					x: [local0 (- local8 1)]
					y: [local0 (+ local8 3)]
					show:
					setCycle: End self
				)
			)
			(2
				(= ticks (Random 300 600))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance peekABooScript2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 (Random 1 4))
				(client cel: 0)
				(self cue:)
			)
			(1
				(client
					x: [local0 (- local9 1)]
					y: [local0 (+ local9 3)]
					show:
					setCycle: End self
				)
			)
			(2
				(= ticks (Random 300 600))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance dinoWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 90)
			)
			(1
				(HandsOff)
				(ShakeScreen 1)
				(if (== global287 6)
					(gEgo setMotion: PolyPath 215 145 self)
				else
					(gEgo setMotion: PolyPath 100 155 self)
				)
			)
			(2
				(HandsOff)
				(gTheIconBar enable: 2)
				(proc814_32 2)
				(gUser canInput: 1)
				(gEgo loop: 3)
				(if (== global287 6)
					(sinclair setCycle: Walk setMotion: MoveTo -40 109 self)
				else
					(sinclair
						posn: -40 109
						setStep: 4 2
						setLoop: 9
						setCycle: Walk
						setMotion: MoveTo 350 109 self
					)
				)
			)
			(3
				(gEgo setMotion: MoveTo 160 140 self)
			)
			(4
				(gEgo loop: 2)
				(HandsOn)
				(NormalEgo)
				(sinclair dispose:)
				(self dispose:)
			)
		)
	)
)

(instance foxWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 150 130 self)
			)
			(1
				(HandsOn)
				(NormalEgo 3)
				(= ticks 30)
			)
			(2
				(foxCallForHelp cue:)
				(gEgo setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance foxNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 102 91 self)
			)
			(1
				(gEgo setMotion: MoveTo 102 121 self)
			)
			(2
				(client setScript: foxWalk)
				(self dispose:)
			)
		)
	)
)

(instance foxTalker of Talker
	(properties
		x 10
		y 10
		view 1068
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: foxBust foxEye foxMouth &rest)
	)
)

(instance foxBust of Prop
	(properties
		view 1068
	)
)

(instance foxMouth of Prop
	(properties
		nsTop 56
		nsLeft 30
		view 1068
		loop 1
	)
)

(instance foxEye of Prop
	(properties
		nsTop 32
		nsLeft 38
		view 1068
		loop 2
	)
)

