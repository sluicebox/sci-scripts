;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use TargActor)
(use n814)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm14 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	[local17 11] = [253 295 149 226 284 319 93 152 223 29 65]
	[local28 11] = [101 64 19 164 152 103 91 61 58 130 54]
	[local39 9] = [28 63 83 102 235 295 195 39 251]
	[local48 13] = [93 85 79 79 86 99 98 103 90 146 124 319 189]
)

(procedure (localproc_0)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 0 319 0 319 88 293 94 244 94 94 121 41 107 43 119 81 124 55 133 19 130 0 135
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 110 189 184 157 177 178 221 181 250 166 231 162 209 174 198 161 319 109 319 189
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 231 103 249 115 214 134 190 138 167 127 167 113
				yourself:
			)
	)
)

(procedure (localproc_1)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 0 319 0 319 88 293 94 244 94 94 121 41 107 43 119 81 124 55 133 19 130 0 135
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 110 189 184 157 177 178 221 181 250 166 231 162 209 174 198 161 319 109 319 189
				yourself:
			)
	)
)

(procedure (localproc_2)
	(EgoDead 13 14 0 0 800) ; "Too late, you remember... bear claws weren't on your diet."
)

(procedure (localproc_3)
	(= local2 (if (< (gEgo x:) (bear x:)) 110 else 20))
	(= local3 (if (< (gEgo x:) (bear x:)) 75 else 12))
)

(procedure (localproc_4)
	(= local11 (- (bear x:) (gEgo x:)))
	(= local12 (- (bear y:) (gEgo y:)))
	(= local13 (+ (gEgo x:) (* local11 30)))
	(= local14 (+ (gEgo y:) (* local12 30)))
)

(instance rm14 of Rm
	(properties
		noun 3
		picture 14
		style 8
		horizon 92
	)

	(method (newRoom newRoomNumber)
		(dazCalmTimer dispose: delete:)
		(bearTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(SetFlag 4)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1 0) ; "Once your eyes get adjusted to the dark, there's still nothing to see in here."
			)
			(80 ; calmSpell
				(CastArea 80)
				(= local9 1)
				(dazCalmTimer setReal: dazCalmTimer 30)
			)
			(78 ; dazzleSpell
				(CastArea 78)
				(= local8 1)
				(dazCalmTimer setReal: dazCalmTimer 5)
			)
			(50 ; detectMagicSpell
				(if (IsFlag 161)
					(gMessager say: 3 50 9) ; "There is no magic in the cave."
				else
					(gMessager say: 3 50 10) ; "There is an aura of magic throughout the cavern. It seems to center on the bear"
				)
			)
			(81 ; flameDartSpell
				(dart setScript: flameDart)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(if (not (IsFlag 161))
			(localproc_0)
			(LoadMany rsVIEW 420 516 14 510)
			(= global280 133)
			(= global279 420)
		else
			(localproc_1)
		)
		(Load rsSOUND 20)
		(super init:)
		(if (== gEgoGait 1) ; running
			(EgoGait 0 0) ; walking
		)
		(if (or (!= gPrevRoomNum 15) (== (gLongSong prevSignal:) -1))
			(gLongSong priority: 1 number: 20 loop: -1 play:)
		)
		(if (not (IsFlag 161))
			(bear init:)
			(if (gEgo knows: 23)
				(egoShoots number: 2033 init:)
				(magicHit number: 2045 init:)
				(dart init:)
				(puff init:)
			)
		)
		(drip init: setScript: dripScript)
		(stalactites init: setOnMeCheck: 1 2)
		(stalagmites init: setOnMeCheck: 1 4)
		(caveGlow init: setOnMeCheck: 1 8)
		(NormalEgo)
		(gEgo init: hide: posn: -15 225 setScript: cmonIn)
	)

	(method (doit)
		(if (and (gEgo edgeHit:) (not (gEgo script:)))
			(gEgo setScript: movinOn)
		)
		(super doit:)
	)
)

(instance stalactites of Feature
	(properties
		y 1
		noun 5
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 0) ; "The stalactites grow slowly... or are they stalagmites?"
			)
			(4 ; Do
				(gMessager say: 5 4 0) ; "What could you possibly do with a stalactite... or is it a stalagmite?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stalagmites of Feature
	(properties
		y 1
		noun 4
		nsBottom 189
		nsRight 319
	)
)

(instance caveGlow of Feature
	(properties
		y 1
		noun 2
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not (IsFlag 161))
				(gMessager say: 2 1 9) ; "Beyond the bear, the cave seems to continue. The bear blocks the way."
			else
				(gMessager say: 2 1 10) ; "An eerie luminescence emanates from a chamber deeper within the cave."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance puff of Prop
	(properties
		z 25
		view 522
		loop 3
	)
)

(instance drip of Prop
	(properties
		view 14
	)
)

(instance dart of Actor
	(properties
		z 25
		view 522
	)
)

(instance bear of TargActor
	(properties
		x 243
		y 116
		noun 1
		view 420
		signal 16384
		targDeltaX -28
		targDeltaY 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((or local9 (IsFlag 160))
						(gMessager say: 1 1 4) ; "The bear appears docile for the time being."
					)
					(local8
						(gMessager say: 1 1 2) ; "Stunned, the bear is temporarily frozen."
					)
					(local6
						(gMessager say: 1 1 1) ; "Although looking somewhat scorched, the bear is still very dangerous."
					)
					((OneOf local1 0 2)
						(gMessager say: 1 1 3) ; "On one side of this cavern is a creature which looks like a large bear. There is something attached to his leg."
					)
					(else
						(gMessager say: 1 1 5) ; "The bear looks menacing and angry. There is a locked chain attached to its leg."
					)
				)
			)
			(2 ; Talk
				(if (IsFlag 312)
					(gMessager say: 1 57 8) ; "Hi there! I represent Ditto Realty. We have some LOVELY properties that are PROVEN bargains. We know that's true, because we've sold them so many times."
				else
					(SetFlag 312)
					(gMessager say: 1 57 7) ; "You know that bears can't talk!"
				)
			)
			(4 ; Do
				(gMessager say: 1 4 0) ; "You'd better not. The bear isn't wearing a flea collar (just a locked chain)."
			)
			(11 ; rations
				(= local9 1)
				(SetFlag 160)
				(gMessager say: 1 11 6) ; "You have made this bear very happy; it would be wise to take advantage of his current mood."
				(SolvePuzzle 646 5)
				(dazCalmTimer setReal: dazCalmTimer 30)
				(= local0 1)
				(gEgo setScript: cueItScript)
			)
			(36 ; flowers
				(gMessager say: 1 36) ; "The bear seems to find your flowers tasty, but not very filling."
				(= local0 2)
				(gEgo setScript: cueItScript)
			)
			(32 ; fruit
				(= local9 1)
				(SetFlag 160)
				(gMessager say: 1 11 6) ; "You have made this bear very happy; it would be wise to take advantage of his current mood."
				(SolvePuzzle 646 5)
				(dazCalmTimer setReal: dazCalmTimer 30)
				(= local0 3)
				(gEgo setScript: cueItScript)
			)
			(33 ; vegetables
				(= local9 1)
				(SetFlag 160)
				(gMessager say: 1 11 6) ; "You have made this bear very happy; it would be wise to take advantage of his current mood."
				(SolvePuzzle 646 5)
				(dazCalmTimer setReal: dazCalmTimer 30)
				(= local0 4)
				(gEgo setScript: cueItScript)
			)
			(18 ; thiefKit
				(gMessager say: 1 17) ; "Try as you might, you can't pick the lock. It must be magical."
			)
			(17 ; lockPick
				(gMessager say: 1 17) ; "Try as you might, you can't pick the lock. It must be magical."
			)
			(26 ; brassKey
				(if (or local8 local9 (IsFlag 160))
					(SolvePuzzle 647 25)
					(self setScript: useKey)
				else
					(gMessager say: 1 26) ; "The Bear won't let you near the lock."
				)
			)
			(12 ; sword
				(gCurRoom newRoom: 420) ; bearArena
			)
			(81 ; flameDartSpell
				(CastDart self)
			)
			(16 ; dagger
				(ThrowKnife self)
			)
			(20 ; rock
				(ThrowRock self)
			)
		)
	)

	(method (getHurt param1)
		(cond
			((<= (-= global280 param1) 0)
				(SetFlag 169)
				(gCurRoom newRoom: 171) ; rmBear
			)
			((OneOf local1 0 2)
				(self setScript: bearUp)
			)
			(else
				(self setLoop: 1 cel: 0 setCycle: End)
			)
		)
	)

	(method (doit)
		(= local5 (gEgo distanceTo: self))
		(localproc_3)
		(cond
			((or local4 (OneOf local1 4 5)) 0)
			(local8
				(if (not (OneOf local1 1 3))
					(self setScript: bearUp)
					(bearTimer setReal: bearTimer 30)
				)
			)
			((or (IsFlag 160) local9)
				(if (OneOf local1 3 1)
					(self setScript: bearDrop)
				)
			)
			((> local5 local2)
				(if (and (not local7) (OneOf local1 1 3))
					(self setScript: bearDrop)
				)
			)
			((>= local2 local5 local3)
				(if (and (not local7) (== local1 0))
					(self setScript: bearUp)
				)
			)
			((< local5 local3)
				(cond
					((< (gEgo x:) (- (bear x:) 15))
						(if (not local4)
							(++ local4)
							(self setScript: bearKills)
						)
					)
					((not local4)
						(++ local4)
						(self setScript: bearKillsRm15)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance movinOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch (gEgo edgeHit:)
					(EDGE_LEFT
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 35)
								(+ (gEgo y:) 20)
								self
						)
					)
					(EDGE_BOTTOM
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 75)
								(+ (gEgo y:) 50)
								self
						)
					)
					(else
						(gEgo setMotion: MoveTo 340 95 self)
					)
				)
			)
			(1
				(gCurRoom
					newRoom: (if (OneOf (gEgo edgeHit:) 4 3) 13 else 15)
				)
			)
		)
	)
)

(instance cmonIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Platform 0 4 3 -1)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(= cycles 1)
			)
			(2
				(= register
					(if (not (IsFlag 161))
						(not (IsFlag 149))
					)
				)
				(= cycles 1)
			)
			(3
				(if (== gPrevRoomNum 15)
					(= local2 20)
					(= local3 12)
					(gEgo
						heading: 225
						loop: 5
						posn: 300 100
						show:
						setMotion: MoveTo 280 110 self
					)
				else
					(= local2 110)
					(= local3 40)
					(gEgo posn: -15 225 show: setMotion: MoveTo 30 180 self)
				)
			)
			(4
				(bear cel: 1)
				(= ticks (if register 90 else 12))
			)
			(5
				(if (and (not (IsFlag 161)) (not (IsFlag 149)))
					(gMessager say: 3 0 11 1 self) ; "As your eyes adjust to the cave's deeper darkness, you examine the interior of this eerie cavern. You sense something moving off to your right."
					(SetFlag 149)
				else
					(= cycles 1)
				)
			)
			(6
				(Platform 0 4 2 -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bearUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(= local1 1)
				(bear setCycle: CT 4 1)
				(= seconds 4)
			)
			(1
				(bear setCycle: End self)
			)
			(2
				(if (and (not local7) (not (IsFlag 167)) (not local8))
					(gMessager say: 3 0 5) ; "A very large bear rears up as you approach. It looks hungry and dangerous."
					(SetFlag 167)
				)
				(= local1 3)
			)
		)
	)
)

(instance bearDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local1 1)
					(= local1 2)
					(bear setCycle: Beg self)
				else
					(= local1 2)
					(bear setLoop: 0 cel: 5 setCycle: Beg self)
				)
			)
			(1
				(= local1 0)
			)
		)
	)
)

(instance flameDart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ local7)
				(TrySkill 16 0 5) ; mana
				(TrySkill 23 0 5) ; flameDartSpell
				(gEgo
					view: 522
					setLoop: (if (< (gEgo x:) (bear x:)) 0 else 1)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(egoShoots play:)
				(gEgo setCycle: End)
				(= local10 (Random 0 300))
				(= local5 (gEgo distanceTo: bear))
				(if (or (< local10 local5) (OneOf local1 1 2))
					(dart setScript: bouncer)
					(++ state)
					(self cue:)
				else
					(dart
						setLoop: 2
						setStep: 18 12
						setPri: 12
						ignoreActors: 1
						posn: (gEgo x:) (gEgo y:)
						show:
						setCycle: Fwd
					)
					(++ local6)
					(dart
						setMotion:
							MoveTo
							(+ (bear x:) (- (Random 0 10) 10))
							(+ (bear y:) (- (Random 0 17) 19))
							self
					)
					(bear getHurt: (+ 5 (/ [gEgoStats 0] 10))) ; strength
				)
			)
			(2
				(magicHit play:)
				(dart setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(NormalEgo)
				(Face gEgo bear self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bouncer of Script
	(properties)

	(method (doit)
		(if (and local15 (not (dart inRect: 10 35 310 205)))
			(= local15 0)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local16 (Random 3 5))
				(= local15 1)
				(localproc_4)
				(dart
					posn: (gEgo x:) (gEgo y:)
					show:
					setLoop: 2
					setStep: 18 12
					setPri: 12
					ignoreActors:
					setCycle: Fwd
					startUpd:
					setMotion: MoveTo local13 local14
				)
			)
			(1
				(puff
					ignoreActors:
					cel: 0
					setPri: 12
					posn: (dart x:) (dart y:)
					setCycle: End
				)
				(+= local16 (Random 1 3))
				(dart
					setMotion: MoveTo [local17 local16] [local28 local16] self
				)
			)
			(2
				(if (< local16 10)
					(-= state 2)
				)
				(self cue:)
			)
			(3
				(dart setLoop: 3 cel: 0 setMotion: 0 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance bearKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 18)
			)
			(1
				(bear loop: 2 cel: 0 setCycle: End)
				(= ticks 6)
			)
			(2
				(bear loop: 3 cel: 0 setCycle: End)
				(gEgo
					view: 516
					loop: 2
					cel: 0
					setMotion: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(= ticks 72)
			)
			(4
				(localproc_2)
			)
		)
	)
)

(instance bearKillsRm15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setMotion: MoveTo 235 (gEgo y:) self
				)
			)
			(1
				(bear loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(bear loop: 3 cel: 0 setCycle: End)
				(gEgo
					view: 516
					loop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(= ticks 90)
			)
			(4
				(localproc_2)
			)
		)
	)
)

(instance useKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo use: 16) ; brassKey
				(HandsOff)
				(= local1 5)
				(bear setCycle: End self)
			)
			(1
				(gEgo ignoreActors: setMotion: MoveTo 209 149 self)
			)
			(2
				(bear stopUpd:)
				(gEgo
					setMotion: MoveTo (- (bear x:) 22) (+ (bear y:) 10) self
				)
			)
			(3
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(gMessager say: 3 0 12 1 self) ; "The Kobold's key disappears as you turn it in the lock."
				(gLongSong stop:)
				(NormalEgo)
				(SetFlag 170)
			)
			(5
				(gCurRoom newRoom: 171) ; rmBear
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 1 200))
			)
			(1
				(= temp0 (Random 0 8))
				(client
					cel: 0
					posn: [local39 temp0] [local48 temp0]
					init:
					setCycle: End self
				)
			)
			(2
				(dripDrip play:)
				(self changeState: 0)
			)
		)
	)
)

(instance cueItScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(switch local0
					(1
						(gEgo use: 1) ; rations
					)
					(2
						(gEgo use: 26) ; flowers
					)
					(3
						(gEgo use: 22) ; fruit
					)
					(4
						(gEgo use: 23) ; vegetables
					)
				)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dazCalmTimer of Timer
	(properties)

	(method (cue)
		(= local9 (= local8 0))
	)
)

(instance bearTimer of Timer
	(properties)

	(method (cue)
		(if (== local1 3)
			(bear setScript: 0)
		)
	)
)

(instance dripDrip of Sound
	(properties
		number 116
	)
)

(instance magicHit of Sound
	(properties
		number 2045
		priority 1
	)
)

(instance egoShoots of Sound
	(properties
		number 2033
		priority 2
	)
)

