;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use n106)
(use TargActor)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm73 0
	brutusTalker 1
	brunoTalker 2
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
	local10 = 55
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)

(procedure (localproc_0)
	(cond
		(
			(= local2
				(if (and (IsFlag 161) (not (IsFlag 235)) (== gTimeOfDay 2))
					(or (== gPrevRoomNum 72) (== gPrevRoomNum 74))
				)
			)
			(= global280 (= global414 100))
			(= global279 465)
			(Load rsVIEW 65)
			(Load rsVIEW 73)
		)
		(
			(= local4
				(if (not (IsFlag 245))
					(IsFlag 261)
				)
			)
			(Load rsVIEW 73)
		)
		(
			(= local6
				(if (and (IsFlag 235) (or (== gPrevRoomNum 72) (== gPrevRoomNum 74)))
					(not (IsFlag 261))
				)
			)
			(Load rsVIEW 73)
			(= global280 global414)
			(= global279 465)
		)
		(
			(= local3
				(if (and (IsFlag 235) (== gPrevRoomNum 80))
					(not (IsFlag 261))
				)
			)
			(Load rsVIEW 73)
			(= global280 global414)
			(= global279 465)
			(= global243 6)
			(brutus posn: 128 135)
		)
		((= local5 (== gPrevRoomNum 465)) ; brigandArena
			(SetFlag 261)
			(Load rsVIEW 466)
		)
	)
	(cond
		(local2
			(bruno init:)
			(brutus init:)
		)
		(local6
			(brutus init: setLoop: 2)
		)
		(local3
			(brutus init: setLoop: 2)
		)
		(local4
			(brutus view: 73 setLoop: 7 setCel: 8 init: stopUpd:)
			(= local1 1)
			(dags add:)
		)
		(local5
			(if (not (IsFlag 245))
				(= global279 0)
				(brutus init:)
			)
		)
		(else
			(dags add:)
			(if (and (!= gPrevRoomNum 72) (!= gPrevRoomNum 74))
				(= local1 1)
			else
				(HandsOn)
			)
		)
	)
)

(instance dags of Set
	(properties)
)

(instance rm73 of Rm
	(properties
		noun 4
		picture 73
		style 7
	)

	(method (dispose &tmp temp0)
		(= global451 0)
		(dags eachElementDo: #dispose 81 release:)
		(for ((= temp0 0)) (< temp0 global427) ((++ temp0))
			(if
				(and
					(gCast contains: [local7 temp0])
					(IsObject [local7 temp0])
				)
				([local7 temp0] dispose: delete:)
			)
		)
		(dags dispose:)
		(if (!= gNewRoomNum 465) ; brigandArena
			(= global279 0)
			(= global243 0)
		)
		(super dispose:)
	)

	(method (init)
		(Load rsSOUND 31 29)
		(Load rsSCRIPT 101)
		(super init: &rest)
		(if global427
			(phonyDagger init: stopUpd:)
		)
		(gFeatures add: target wall buildings trees appleTree)
		(= local9 0)
		(cond
			((gEgo has: 3) ; chainMail
				(= local9 5)
			)
			((gEgo has: 4) ; leather
				(= local9 3)
			)
		)
		(brutus
			targDeltaX:
				(switch local8
					(1 12)
					(-1 -12)
				)
		)
		(localproc_0)
		(switch gPrevRoomNum
			(72
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 189 25 189 6 135 26 126 0 126
							yourself:
						)
				)
				(self setScript: sEnterFromWest)
			)
			(74
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 284 113 284 189 0 189 0 0 319 0 319 113
							yourself:
						)
				)
				(self setScript: sEnterFromEast)
			)
			(465 ; brigandArena
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 108 124 122 138 106 153 106 189 0 189 0 0 319 0 319 189 170 189 175 171 202 139 212 115 144 122 152 139 130 139 115 124
							yourself:
						)
				)
				(brutus init: setLoop: 2 setScript: brutusDies)
			)
			(else
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 108 124 122 138 106 153 106 189 0 189 0 0 319 0 319 189 170 189 175 171 202 139 212 115 144 122 152 139 130 139 115 124
							yourself:
						)
				)
				(self setScript: sEnterFromSouth)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(if global427
					(gMessager say: 4 4 0) ; "You search around this area for a bit, but you don't find anything very useful."
				)
			)
			(20 ; rock
				(= temp0 0)
				(if (and (gCast contains: brutus) (not (IsFlag 261)))
					(Face gEgo brutus)
					(Face brutus gEgo)
					(= temp0 brutus)
				)
				(ThrowRock temp0)
			)
			(16 ; dagger
				(ThrowKnife 0)
			)
			(50 ; detectMagicSpell
				(gMessager say: 4 50 0) ; "You detect no magic here."
			)
			(78 ; dazzleSpell
				(if (or (IsFlag 261) (== local8 0))
					(CastDazzle)
					(gMessager say: 2 78 0) ; "You waste a spell."
				else
					(gMessager say: 4 78 0) ; "The branches of the brush block the spell from the brigand."
				)
			)
			(81 ; flameDartSpell
				(if (or (IsFlag 261) (not (gCast contains: brutus)))
					(CastDart 0)
				else
					(Face brutus gEgo)
					(CastDart brutus)
				)
			)
			(80 ; calmSpell
				(if (or (IsFlag 261) (not (gCast contains: brutus)))
					(gMessager say: 4 80 0) ; "You've wasted a spell."
				else
					(gMessager say: 4 80 10) ; "The brigand is too angry to calm down."
				)
			)
			(51 ; openSpell
				(gMessager say: 4 51 0) ; "You've wasted a spell."
			)
			(77 ; triggerSpell or Pickup Inventory
				(cond
					((or (IsFlag 261) (not (gCast contains: brutus)))
						(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
					)
					((or (gEgo has: 6) (gEgo has: 2)) ; dagger, sword
						(gMessager say: 4 77) ; "Your weapon is now magically charged."
					)
					(else
						(gMessager say: 4 77 3) ; "You don't seem to have a weapon to charge."
					)
				)
			)
			(82 ; fetchSpell
				(if (or (IsFlag 261) (not (gCast contains: brutus)))
					(gMessager say: 4 82 0) ; "You waste a spell. Fetch is only good for fetching small, visible objects."
				else
					(gMessager say: 4 82 2) ; "Just wait. The nice brigand will throw you his knife."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(HandsOff)
				(gCurRoom setScript: sExitEast)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(HandsOff)
				(gCurRoom setScript: sExitWest)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: sExitSouth)
			)
		)
		(super doit:)
	)
)

(instance target of Feature
	(properties
		x 158
		y 88
		noun 5
		nsTop 59
		nsLeft 130
		nsBottom 108
		nsRight 180
		sightAngle 40
		approachX 140
		approachY 122
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if global427
					(gMessager say: 5 1 13) ; "You are using the old archery target for dagger throwing practice."
				else
					(gMessager say: 5 1 12) ; "The old archery target looks as though it has not been used in quite some time."
				)
			)
			(4 ; Do
				(cond
					((!= local8 0)
						(gMessager say: 5 16 0) ; "There are too many bushes between you and the target."
					)
					(global427
						(gCurRoom setScript: getYourDags 0 0)
					)
					(else
						(gCurRoom setScript: getYourDags 0 1)
					)
				)
			)
			(16 ; dagger
				(if (or (== gPrevRoomNum 72) (== gPrevRoomNum 74))
					(gMessager say: 5 16 0) ; "There are too many bushes between you and the target."
				else
					(gCurRoom setScript: sThrowDagger)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 159
		y 57
		noun 7
		nsTop 13
		nsBottom 101
		nsRight 318
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if gNight
					(if (TrySkill 11 35 0) ; climbing
						(gCurRoom setScript: sClimbWall)
					else
						(gMessager say: 7 4 15) ; "Climbing this wall is too difficult for your level of skill. Keep practicing."
					)
				else
					(gMessager say: 7 4 17) ; "You would have trouble convincing people you are a Hero if you climbed the wall into town during the day."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buildings of Feature
	(properties
		x 153
		y 6
		noun 3
		nsLeft 73
		nsBottom 12
		nsRight 233
		sightAngle 40
	)
)

(instance trees of Feature
	(properties
		x 153
		y 180
		noun 6
		sightAngle 40
		onMeCheck 2
	)
)

(instance knife1 of Actor
	(properties
		noun 5
		view 65
	)

	(method (doVerb theVerb)
		(target doVerb: theVerb &rest)
	)
)

(instance knife2 of Actor
	(properties
		noun 5
		view 65
	)

	(method (doVerb theVerb)
		(target doVerb: theVerb &rest)
	)
)

(class Dagger of View
	(properties
		noun 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if global427
					(gMessager say: 5 1 13) ; "You are using the old archery target for dagger throwing practice."
				else
					(gMessager say: 5 1 12) ; "The old archery target looks as though it has not been used in quite some time."
				)
			)
			(4 ; Do
				(gCurRoom setScript: getYourDags 0 0)
			)
			(16 ; dagger
				(if (or (== gPrevRoomNum 72) (== gPrevRoomNum 74))
					(gMessager say: 5 16 0) ; "There are too many bushes between you and the target."
				else
					(gCurRoom setScript: sThrowDagger)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bruno of Actor
	(properties
		x 119
		y 123
		noun 1
		view 65
		loop 4
	)
)

(instance killTheBum of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(brutus
					view: 73
					setCycle: Walk
					setCel: 0
					setScript: 0
					setMotion: PolyPath (brutus x:) (- (brutus y:) 2)
				)
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors: 1
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
					posn: (gEgo x:) (gEgo y:)
					setMotion: MoveTo (brutus x:) (- (brutus y:) 22) self
				)
			)
			(1
				(knife1 hide: dispose:)
				(brutus
					setLoop: 8
					setCel: 0
					posn: (brutus x:) (+ (brutus y:) 2)
					setCycle: End self
				)
			)
			(2
				(brutus stopUpd:)
				(dags add:)
				(= local13 0)
				(SetFlag 261)
				(= seconds 2)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance climbOverWall of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 7 4 16 0 self) ; "After making sure nobody is watching, you climb over the town's wall."
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance brunoTalker of Talker
	(properties
		x 10
		y 10
		view 1074
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(= global451 2074)
		(PalVary pvCHANGE_TARGET 2074)
		(AssertPalette 1074)
		(super init: brunoBust brunoEyes brunoTalkerMouth &rest)
	)
)

(instance brunoBust of Prop
	(properties
		view 1074
	)
)

(instance brunoTalkerMouth of Prop
	(properties
		nsTop 47
		nsLeft 43
		view 1074
		loop 1
	)
)

(instance brunoEyes of Prop
	(properties
		nsTop 26
		nsLeft 43
		view 1074
		loop 3
	)
)

(instance throwSound of Sound
	(properties
		number 31
	)
)

(instance hitSound of Sound
	(properties
		number 29
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 350 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 74)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(NormalEgo)
				(gCurRoom newRoom: 80)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo -25 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 72)
			)
		)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: -25 144 setMotion: MoveTo 18 144 self)
				(= local8 -1)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(cond
					(local2
						(gCurRoom setScript: brigsMeet)
					)
					((and (< gTimeOfDay 4) (or local6 (IsFlag 324)))
						(gCurRoom setScript: brutusThrows)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 347 148 setMotion: MoveTo 296 148 self)
				(= local8 1)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(cond
					(local2
						(gCurRoom setScript: brigsMeet)
					)
					((and (< gTimeOfDay 4) (or local6 (IsFlag 324)))
						(gCurRoom setScript: brutusThrows)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: posn: 137 246 setMotion: MoveTo 137 184 self)
				(= local8 0)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(if local3
					(gCurRoom setScript: brutusLives)
				)
				(self dispose:)
			)
		)
	)
)

(instance sClimbWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 517)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(NormalEgo)
				(if (== local8 0)
					(gEgo setMotion: PolyPath 120 124 self)
				else
					(= ticks 20)
				)
			)
			(1
				(gMessager say: 7 4 16 0 self) ; "After making sure nobody is watching, you climb over the town's wall."
			)
			(2
				(switch local8
					(0
						(gEgo setMotion: MoveTo 98 122 self)
					)
					(-1
						(gEgo setMotion: MoveTo 26 123 self)
					)
					(1
						(gEgo setMotion: MoveTo 293 107 self)
					)
				)
			)
			(3
				(switch local8
					(0
						(gEgo setPri: 3)
					)
					(-1
						(gEgo setPri: 1)
					)
					(1
						(gEgo setPri: 1)
					)
				)
				(gEgo setHeading: 360)
				(= ticks 30)
			)
			(4
				(gEgo view: 517 setLoop: 0 setCel: 0)
				(switch local8
					(0
						(gEgo posn: 99 94)
						(= ticks 10)
					)
					(-1
						(= state 16)
						(gEgo
							posn: 26 94
							setCycle: Fwd
							setMotion: MoveTo 26 44 self
						)
					)
					(1
						(= state 16)
						(gEgo
							posn: 293 78
							setCycle: Fwd
							setMotion: MoveTo 293 34 self
						)
					)
				)
			)
			(5
				(gEgo setCel: 1 posn: 99 85)
				(= ticks 10)
			)
			(6
				(gEgo setCel: 2 posn: 98 76)
				(= ticks 10)
			)
			(7
				(gEgo setCel: 3 posn: 99 67)
				(= ticks 10)
			)
			(8
				(gEgo setCel: 4 posn: 99 56)
				(= ticks 10)
			)
			(9
				(gEgo setCel: 5)
				(= ticks 10)
			)
			(10
				(gEgo setCel: 6 posn: 97 50)
				(= ticks 10)
			)
			(11
				(gEgo setLoop: 1 setCel: 0 posn: 99 37)
				(= ticks 10)
			)
			(12
				(gEgo setCycle: End self)
			)
			(13
				(gEgo setLoop: 8 setCel: 6 setPri: 1 posn: 93 39)
				(= ticks 10)
			)
			(14
				(gEgo setCycle: Beg self)
			)
			(15
				(= ticks 20)
			)
			(16
				(gEgo posn: 1000 1000)
				(= ticks 10)
			)
			(17
				(SetFlag 88)
				(gEgo setCycle: 0)
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance brutusWaits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 324)
				(= ticks 300)
			)
			(1
				(ClearFlag 324)
				(= seconds global281)
			)
			(2
				(if (not (IsFlag 261))
					(gCurRoom setScript: brutusThrows)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance brutusLives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(brutus
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 20) self
				)
			)
			(1
				(gMessager say: 4 0 7 0 self) ; "Hey, watchu doin' here? Spyin', I'll wager!"
			)
			(2
				(gCurRoom newRoom: 465) ; brigandArena
			)
		)
	)
)

(instance egoLoses of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if register
					(= register 0)
					(= seconds (Random 3 6))
				else
					(HandsOff)
					(= cycles 2)
				)
			)
			(2
				(HandsOff)
				(gEgo setMotion: 0)
				(Face gEgo brutus)
				(bruno setCycle: 0 setMotion: 0)
				(if (not (IsFlag 261))
					(brutus
						setScript: 0
						setLoop: (if (> (gEgo x:) 160) 5 else 4)
						cel: 0
						setCycle: CT 4 1 self
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
					posn: (+ (bruno x:) (* local8 41)) (- (bruno y:) 24)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22)
				)
				(brutus setCycle: CT 5 1 self)
			)
			(4
				(if (and (gCast contains: bruno) (< (gEgo x:) 160))
					(bruno setLoop: 5 setCycle: End self)
					(knife2
						illegalBits: 0
						setLoop: 7
						ignoreActors: 1
						ignoreHorizon:
						xStep: 6
						yStep: 7
						setPri: (- (gEgo priority:) 1)
						init:
						setCycle: Fwd
						posn: (+ (bruno x:) (* 41 local8)) (- (bruno y:) 27)
						moveSpeed: 1
						setStep: 5 5
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
					)
				else
					(brutus setCycle: End)
					(knife2
						illegalBits: 0
						setLoop: 7
						ignoreActors:
						ignoreHorizon:
						xStep: 6
						yStep: 7
						setPri: (- (gEgo priority:) 1)
						init:
						setCycle: Fwd
						posn: (+ (brutus x:) (* 41 local8)) (- (brutus y:) 27)
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
					)
				)
				(gEgo setLoop: 1)
			)
			(5
				(knife1 dispose:)
				(knife2 dispose:)
				(if (== local16 bruno)
					(bruno setLoop: 5 setCel: 0 setCycle: End)
				)
				(if (and (not (IsFlag 261)) (== local16 brutus))
					(brutus setLoop: 6 setCel: 0 setCycle: End)
				)
				(gEgo view: 516 setLoop: 3 setMotion: 0 setCycle: End self)
			)
			(6
				(= seconds 4)
			)
			(7
				(EgoDead 45 46 2 5 516) ; "Done in by daggers and a desperate desperado! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

(instance brigsMeet of Script
	(properties)

	(method (changeState newState)
		(if client
			(switch (= state newState)
				(0
					(SetFlag 235)
					(HandsOff)
					(brutus setLoop: 4 setCycle: Fwd)
					(= ticks 60)
				)
				(1
					(gCast eachElementDo: #stopUpd)
					(= ticks 30)
				)
				(2
					(gMessager say: 4 0 4 0 self) ; "So what's this about, anyway?"
				)
				(3
					(gMessager say: 4 0 9 0 self) ; "Maybe we should just make our move now."
				)
				(4
					(gMessager say: 4 0 8 0 self) ; "And remember the 'word'."
				)
				(5
					(SolvePuzzle 691 12)
					(gCast eachElementDo: #startUpd)
					(brutus setLoop: 3 setCel: 0 setCycle: 0)
					(bruno
						illegalBits: 0
						ignoreActors: 1
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo 170 (bruno y:) self
					)
				)
				(6
					(brutus setLoop: 0)
					(= ticks 30)
					(bruno setMotion: MoveTo (- (bruno x:) 10) 230 self)
				)
				(7
					(brutus setLoop: 2)
				)
				(8
					(bruno dispose:)
					(HandsOn)
					(NormalEgo)
					(= global281 300)
					(brutus setScript: brutusWaits)
					(self dispose:)
				)
			)
		)
	)
)

(instance brutus of TargActor
	(properties
		x 131
		y 135
		noun 2
		view 73
		loop 4
		signal 24576
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 261)
					(gMessager say: 2 1 0) ; "The dead brigand lies very still."
				else
					(gMessager say: 2 1 2) ; "You see a hard-looking character who appears to be a thief. He must be one of the Brigands!"
				)
			)
			(2 ; Talk
				(brutus setMotion: 0)
				(if (not (IsFlag 261))
					(brutus setScript: brutusThrows)
				else
					(gMessager say: 1 2) ; "Dead men tell no tales."
				)
			)
			(4 ; Do
				(if (IsFlag 261)
					(if (gEgo inRect: 90 92 230 188)
						(gCurRoom setScript: egoSearch)
					else
						(gMessager say: 2 4 1) ; "Get closer to him."
					)
				else
					(gMessager say: 2 4 2) ; "You're kidding, right?"
				)
			)
			(20 ; rock
				(= temp0 0)
				(if (and (gCast contains: brutus) (not (IsFlag 261)))
					(Face gEgo brutus)
					(Face brutus gEgo)
					(= temp0 brutus)
				)
				(Face brutus gEgo)
				(ThrowRock temp0)
			)
			(16 ; dagger
				(if (not (IsFlag 261))
					(SetFlag 362)
					(ThrowKnife brutus)
				else
					(gMessager say: 1 16) ; "He's dead already; don't dull your daggers!"
				)
			)
			(50 ; detectMagicSpell
				(gMessager say: 2 50 0) ; "You detect no magic here."
			)
			(81 ; flameDartSpell
				(if (or (not (gCast contains: brutus)) (IsFlag 261))
					(CastDart 0)
				else
					(= local16 brutus)
					(Face brutus gEgo)
					(CastDart brutus)
					(gMessager say: 2 81) ; "Your Flame Dart streaks towards the startled brigand."
				)
			)
			(80 ; calmSpell
				(if (and (gCast contains: brutus) (not (IsFlag 261)))
					(gMessager say: 2 80 0 2) ; "The brigand is too angry to calm."
				else
					(gMessager say: 2 80 0 1) ; "You've wasted a spell."
				)
			)
			(51 ; openSpell
				(gMessager say: 1 51 0) ; "You've wasted a spell."
			)
			(77 ; triggerSpell or Pickup Inventory
				(cond
					((or (not (gCast contains: brutus)) (IsFlag 261))
						(= global229 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
					)
					((or (gEgo has: 6) (gEgo has: 2)) ; dagger, sword
						(gMessager say: 2 77 0) ; "Your weapon is now magically charged."
					)
					(else
						(gMessager say: 2 77 3) ; "You don't seem to have a weapon to charge."
					)
				)
			)
			(82 ; fetchSpell
				(if (or (not (gCast contains: brutus)) (IsFlag 261))
					(gMessager say: 2 82 1) ; "You waste a spell. Fetch is only good for fetching small, visible objects."
				else
					(gMessager say: 2 82 2) ; "Just wait. The nice brigand will throw you his knife."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (getHurt)
		(if (not (IsFlag 261))
			(= global229 0)
			(= global279 0)
			(SetFlag 261)
			(brutus setScript: brutusDies)
		else
			(gMessager say: 2 78) ; "You waste a spell."
		)
		(= global414 global280)
	)
)

(instance brutusDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local15
					(knife1 dispose:)
					(knife2 dispose:)
				)
				(if (== gPrevRoomNum 465) ; brigandArena
					(gEgo init: posn: 146 161 setHeading: 360)
					(brutus view: 73 setCel: 0 loop: 7 setCycle: End self)
				else
					(brutus view: 73 setCel: 0 setLoop: 7 setCycle: End self)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(= local13 0)
				(brutus stopUpd:)
				(dags add:)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance phonyDagger of View
	(properties
		x 161
		y 83
		view 65
		loop 6
		signal 26624
	)
)

(instance appleTree of Feature
	(properties
		x 58
		y 259
		z 100
		nsTop 130
		nsLeft 10
		nsBottom 189
		nsRight 107
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 14) ; "This tree is covered with old, dried fruit from last year."
			)
			(4 ; Do
				(gMessager say: 6 4 14) ; "The fruit on this tree is withered, and swarming with hornets. You think better about picking it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo inRect: 100 121 148 146)
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						setMotion: MoveTo 170 140 self
					)
				else
					(= ticks 10)
				)
			)
			(1
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 145 120 self
				)
			)
			(2
				(Face gEgo brutus self)
			)
			(3
				(gEgo
					loop: (mod (+ (gEgo loop:) 4) 2)
					view: 510
					setCycle: End self
				)
			)
			(4
				(cond
					((IsFlag 362)
						(= register 1)
						(ClearFlag 362)
						(gMessager say: 4 0 6) ; "You retrieve your dagger."
					)
					((IsFlag 245)
						(gMessager say: 4 86 7) ; "You find nothing else on the brigand's body."
					)
					(else
						(= register 2)
						(gMessager say: 4 86 11) ; "You find a single key on the brigand's body, and put it away."
						(SetFlag 245)
					)
				)
				(= seconds 2)
			)
			(5
				(cond
					((== register 1)
						(gEgo get: 6 1) ; dagger
					)
					((== register 2)
						(gEgo get: 16) ; brassKey
					)
				)
				(= register 0)
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 160 127 self
				)
			)
			(6
				(gEgo setHeading: 270 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance brutusTalker of Talker
	(properties
		x 10
		y 10
		view 1073
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2073)
		(= font gUserFont)
		(PalVary pvCHANGE_TARGET 2073)
		(AssertPalette 1073)
		(super init: brutusBust brutusEyes brutusTalkerMouth &rest)
	)
)

(instance brutusBust of Prop
	(properties
		view 1073
	)
)

(instance brutusTalkerMouth of Prop
	(properties
		nsTop 51
		nsLeft 31
		view 1073
		loop 1
	)
)

(instance brutusEyes of Prop
	(properties
		nsTop 24
		nsLeft 28
		view 1073
		loop 2
	)
)

(instance sThrowDagger of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local18 (gEgo cycleSpeed:))
				(gEgo illegalBits: 0 ignoreActors: 1)
				(if (!= (gEgo x:) 212)
					(gEgo
						setMotion:
							PolyPath
							212
							(if (> local11 125) local11 else 151)
							self
					)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo view: 510 cycleSpeed: 6 setLoop: 2 cel: 0)
				(= ticks 30)
			)
			(2
				(gEgo use: 6 1) ; dagger
				(++ global427)
				(switch (Random 0 5)
					(1
						(SkillUsed 10 1) ; throwing
					)
					(2
						(SkillUsed 5 1) ; weapon-use
					)
				)
				(= temp3 (/ (- 120 [gEgoStats 10]) 10)) ; throwing
				(= temp1 (- (Random 0 temp3) (/ temp3 2)))
				(= temp2 (+ (= temp2 (- (Random 0 temp3) (/ temp3 2))) 20))
				(gEgo setCycle: End self)
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
					posn: (+ (gEgo x:) 30) (- (gEgo y:) 24)
					setMotion:
						MoveTo
						(+ (target x:) temp1)
						(+ (- (target y:) 22) temp2)
						self
				)
			)
			(3
				(throwSound play: 80)
			)
			(4
				(if (< global427 local10)
					(hitSound play: 80)
					(= temp0 (Random 0 3))
					((= local7 (Dagger new:))
						view: 65
						loop: 7
						cel: temp0
						posn: (knife1 x:) (knife1 y:)
						init:
						stopUpd:
					)
					(dags add: local7)
				)
				(knife1 dispose:)
				(NormalEgo)
				(gEgo loop: 3)
				(gEgo cycleSpeed: local18)
				(HandsOn)
				(TrySkill 10 0 20) ; throwing
				(self dispose:)
			)
		)
	)
)

(instance brutusThrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Face gEgo brutus)
				(brutus
					setLoop: (if (> (gEgo x:) 160) 5 else 4)
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(brutus setCel: 5)
				(self cue:)
			)
			(2
				(if local14
					(self cue:)
				else
					(brutus setCel: 5 setCycle: End self)
					(= local13 1)
				)
			)
			(3
				(if (not local14)
					(= local15 1)
					(User canControl: 0)
					(HandsOff)
					(gEgo setMotion: 0)
				)
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
					setStep: 5 5
					posn: (+ (brutus x:) (* local8 32)) (- (brutus y:) 20)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22) self
				)
			)
			(4
				(if local15
					(= local15 0)
					(knife1 dispose:)
					(if (not (TakeDamage (- 10 local9)))
						(self changeState: 7)
					)
				)
				(knife1 setCycle: 0)
				(gEgo
					view: 513
					setLoop: (if (== local8 1) 3 else 2)
					setMotion: 0
					setCycle: End self
				)
			)
			(5
				(NormalEgo)
				(Face gEgo brutus)
				(= local13 0)
				(self changeState: 7)
			)
			(6
				(self changeState: 0)
			)
			(7
				(HandsOff)
				(gEgo
					view: 516
					setLoop: (if (== local8 1) 1 else 0)
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(8
				(= seconds 3)
			)
			(9
				(EgoDead 45 46 2 5 516) ; "Done in by daggers and a desperate desperado! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

(instance getYourDags of Script
	(properties)

	(method (changeState newState &tmp [temp0 3] temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (or (< (gEgo y:) 138) (gEgo inRect: 100 121 148 146))
					(gEgo setMotion: MoveTo 170 140 self)
				else
					(= ticks 10)
				)
			)
			(1
				(gEgo setMotion: MoveTo 160 122 self)
			)
			(2
				(gEgo setHeading: 300 self)
			)
			(3
				(= ticks 10)
			)
			(4
				(if register
					(gMessager say: 5 4) ; "You can feel the holes where daggers and arrows once hit the target."
					(HandsOn)
					(self dispose:)
				else
					(gEgo get: 6 global427) ; dagger
					(= cycles 2)
				)
			)
			(5
				(if (gCast contains: phonyDagger)
					(phonyDagger dispose:)
				)
				(if (< local0 2)
					(gMessager say: 4 0 6 0 self) ; "You retrieve your dagger."
				else
					(gMessager say: 4 0 5 0 self) ; "You retrieve your daggers."
				)
				(= global427 0)
			)
			(6
				(for ((= temp3 0)) (< temp3 global427) ((++ temp3))
					(if
						(and
							(gCast contains: [local7 temp3])
							(IsObject [local7 temp3])
						)
						([local7 temp3] dispose: delete:)
					)
				)
				(dags eachElementDo: #dispose 81 release:)
				(= seconds 2)
			)
			(7
				(dags add:)
				(gEgo
					setMotion:
						PolyPath
						212
						(if (> local11 125) local11 else 151)
						self
				)
			)
			(8
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

