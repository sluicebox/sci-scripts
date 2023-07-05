;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use dartScript)
(use n104)
(use n106)
(use TargActor)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm84 0
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
	local8 = 85
	local9 = 79
	local10
	local11
)

(procedure (localproc_0)
	(if (== (antwerp status:) 1)
		(antwerp status: 0 setScript: sFlyOut)
	)
)

(instance rm84 of Rm
	(properties
		picture 84
		style 8
	)

	(method (init)
		(if (or (== gPrevRoomNum 97) (== gPrevRoomNum 89))
			(SetFlag 253)
		)
		(if (not (IsFlag 253))
			(self
				addObstacle:
					(rockPoly
						type: PBarredAccess
						init: 71 85 102 89 102 107 191 155 256 168 319 168 319 189 0 189 0 0 184 0 184 13
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 270 59 233 46 194 46 194 25 210 12 210 0 319 0 319 63
						yourself:
					)
			)
			(theRock init: stopUpd:)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 123 64 0 64 0 0 185 -1 185 12 123 47
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 67 73 67 73 82 83 87 102 87 102 106 92 106 92 114 125 114 125 132 166 132 166 138 198 155 319 155 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 270 59 233 46 194 46 194 25 210 12 210 0 319 0 319 63
						yourself:
					)
			)
			(theRock init: setCel: 255 setPri: 1 stopUpd:)
			(entrance init:)
		)
		(super init:)
		(gLongSong fade:)
		(NormalEgo)
		(gEgo init: ignoreActors: 1)
		(rocksUR init:)
		(ground init:)
		(mountainRocks init:)
		(bushesLL init:)
		(tree init:)
		(bushesUR init:)
		(bushesU init:)
		(switch gPrevRoomNum
			(85
				(gCurRoom setScript: sEnterFromEast)
			)
			(97
				(antwerp posn: 186 87)
				(gCurRoom setScript: sEnterFromCave)
			)
			(89
				(antwerp posn: 186 87)
				(gCurRoom setScript: sEnterFromCave)
			)
			(else
				(gEgo posn: 204 -2)
				(gCurRoom setScript: sEnterFromNorth)
			)
		)
		(Load rsSCRIPT 991)
		(if (not (or (IsFlag 206) (IsFlag 204)))
			(= local1 1)
			(antwerp init: setLoop: 0 loop: 3 status: 1 setScript: sRandBounce)
			(gLongSong stop:)
			(antSound init:)
			(antHits init:)
		else
			(antwerp status: 0)
		)
	)

	(method (newRoom newRoomNumber)
		(= global451 0)
		(DisposeScript 991)
		(antwerp setCycle: 0 setMotion: 0 setScript: 0)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(SetFlag 74)
		(cond
			((!= gNewRoomNum 89)
				(ClearFlag 247)
				(if (not (or (IsFlag 250) (IsFlag 251)))
					(ClearFlag 253)
					(ClearFlag 252)
				)
			)
			((not (IsFlag 84))
				(SetFlag 348)
			)
		)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (IsFlag 253) (< (gEgo x:) 71))
				(self setScript: sExitThruDoor)
			)
			((< (gEgo y:) 28)
				(self setScript: sExitNorth)
			)
			((== (gEgo edgeHit:) 2)
				(gCurRoom setScript: sExitEast)
			)
			((< (gEgo y:) 43)
				(gEgo setPri: 4)
			)
			(else
				(gEgo setPri: -1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 206)
						(gMessager say: 9 1 16) ; "Now that the big Antwerp has split, this corner of the forest seems strangely quiet."
					)
					((IsFlag 204)
						(gMessager say: 9 1 7) ; "You look around and see rocks and grass, but no Antwerp."
					)
					(else
						(gMessager say: 9 1 8) ; "You see rocks, grass and an Antwerp."
					)
				)
			)
			(50 ; detectMagicSpell
				(gMessager say: 9 50) ; "You detect no magic here."
			)
			(78 ; dazzleSpell
				(self setScript: sDazzleAnAntwerp)
			)
			(80 ; calmSpell
				(self setScript: sCalmAnAntwerp)
			)
			(51 ; openSpell
				(if (IsFlag 252)
					(gMessager say: 9 51) ; "It's already unlocked."
				else
					(self setScript: sMagicRock)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance entrance of Feature
	(properties
		x 57
		y 139
		z 100
		nsTop 14
		nsLeft 45
		nsBottom 65
		nsRight 70
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 253)
						(gMessager say: 5 1 6) ; "There is a narrow cave entrance among the rocks. Inside, you see a dark passage through the hillside."
					)
					((gEgo inRect: 30 52 115 94)
						(gMessager say: 5 1 5) ; "You find a keyhole concealed in a crack in the rock."
					)
					(else
						(gMessager say: 5 1) ; "The rocks were left here by a receding glacier."
					)
				)
			)
			(4 ; Do
				(theRock doVerb: 4)
			)
			(16 ; dagger
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mountainRocks of Feature
	(properties
		x 159
		y 94
		noun 7
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1) ; "The way is impassable. Sheer rock cliffs rise to serious heights."
			)
			(16 ; dagger
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bushesLL of Feature
	(properties
		x 73
		y 153
		noun 2
		nsTop 118
		nsBottom 189
		nsRight 146
		sightAngle 40
		onMeCheck 4
	)
)

(instance tree of Feature
	(properties
		x 263
		y 133
		noun 11
		nsTop 78
		nsLeft 207
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; dagger
			(localproc_0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bushesUR of Feature
	(properties
		x 268
		y 29
		noun 3
		nsTop 1
		nsLeft 218
		nsBottom 58
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; dagger
			(localproc_0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bushesU of Feature
	(properties
		x 164
		y 6
		noun 4
		nsLeft 155
		nsBottom 13
		nsRight 174
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; dagger
			(localproc_0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rocksUR of Feature
	(properties
		x 257
		y 36
		noun 8
		nsTop 12
		nsLeft 195
		nsBottom 60
		nsRight 319
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; dagger
			(localproc_0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ground of Feature
	(properties
		x 159
		y 1
		z -94
		nsBottom 189
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 204)
					(gMessager say: 6 1 7) ; "The Antwerp seems to have flown the coop."
				else
					(gMessager say: 6 1 8) ; "The grass is luscious, just the thing for hungry herbivores."
				)
			)
			(16 ; dagger
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRock of Actor
	(properties
		x 62
		y 103
		z 100
		noun 10
		view 84
		priority 3
		signal 18448
		cycleSpeed 8
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(cond
					((or (!= (gEgo x:) local8) (!= (gEgo y:) local9))
						(gEgo setMotion: PolyPath local8 local9)
					)
					((!= (gEgo loop:) 7)
						(gEgo setHeading: 315)
					)
					(
						(and
							(not (IsFlag 204))
							(not (IsFlag 206))
							(== (antwerp x:) 110)
							(== local1 1)
						)
						(antwerp
							setMotion: MoveTo (+ (antwerp x:) 20) (antwerp y:)
						)
					)
					((not (IsFlag 252))
						(gMessager say: 10 4 17) ; "Despite your mightiest efforts, the rock does not move."
					)
					((not (TrySkill 0 40 0)) ; strength
						(gMessager say: 10 4 19) ; "You are not strong enough yet to open the rock door."
					)
					((not cel)
						(gEgo setScript: openRock)
					)
					(else
						(gMessager say: 10 4 18) ; "The rock door has already been opened."
					)
				)
				(HandsOn)
			)
			(1 ; Look
				(cond
					((not (gEgo inRect: 30 52 115 94))
						(gMessager say: 10 1 25) ; "The rocks were left here by some receding glacier."
					)
					((IsFlag 253)
						(gMessager say: 10 1 6) ; "There is a narrow cave entrance among the rocks."
					)
					(else
						(gMessager say: 10 1 26) ; "You find a keyhole concealed in a crack in the rock."
					)
				)
			)
			(17 ; lockPick
				(cond
					((not (gEgo inRect: 30 52 115 94))
						(gMessager say: 10 17 25) ; "You don't see any locks nearby."
					)
					((IsFlag 252)
						(gMessager say: 10 17 15) ; "It's already unlocked."
					)
					((not (CanPickLocks))
						(gMessager say: 10 17 22) ; "You'd have a much easier time of this if you had the key."
					)
					((TrySkill 9 85 global175) ; pick locks
						(gMessager say: 10 17 23) ; "Ah, got it! The lock in the rock clicks open."
						(SetFlag 252)
					)
					((gEgo has: 8) ; thiefKit
						(gMessager say: 10 17 21) ; "The lock is beyond your present skill. It might help if you had the key."
					)
					(else
						(gMessager say: 10 17 24) ; "The lock is beyond your present skill. It might help if you had the key."
					)
				)
			)
			(18 ; thiefKit
				(cond
					((not (gEgo inRect: 30 52 115 94))
						(gMessager say: 10 17 25) ; "You don't see any locks nearby."
					)
					((IsFlag 252)
						(gMessager say: 10 17 15) ; "It's already unlocked."
					)
					((not (CanPickLocks))
						(gMessager say: 10 17 22) ; "You'd have a much easier time of this if you had the key."
					)
					((TrySkill 9 85 global175) ; pick locks
						(gMessager say: 10 17 23) ; "Ah, got it! The lock in the rock clicks open."
						(SetFlag 252)
					)
					(else
						(gMessager say: 10 17 21) ; "The lock is beyond your present skill. It might help if you had the key."
					)
				)
			)
			(26 ; brassKey
				(cond
					((not (gEgo inRect: 30 52 115 94))
						(gMessager say: 10 17 25) ; "You don't see any locks nearby."
					)
					((IsFlag 252)
						(gMessager say: 10 17 15) ; "It's already unlocked."
					)
					((IsFlag 245)
						(gMessager say: 10 26 17) ; "The lock in the rock clicks open."
						(SetFlag 252)
					)
					(else
						(gMessager say: 10 26 20) ; "The key glows for an instant as you insert it into the lock, but nothing else happens."
					)
				)
			)
			(2 ; Talk
				(if (and (IsFlag 235) (not (IsFlag 247)) (not (IsFlag 250)))
					(SetFlag 247)
					(SolvePuzzle 702 5)
					(gMessager say: 10 57) ; "Ok, you say "Hiden Goseke". Or was that "Hide 'n' go seek"?"
				else
					(gMessager say: 10 57 27) ; "These rocks seem rather stiff. Maybe they're just not in a talkative mood."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance antwerp of TargActor
	(properties
		x 110
		y 81
		yStep 4
		view 590
		loop 2
		signal 24576
		cycleSpeed 4
		illegalBits 0
		xStep 4
		moveSpeed 4
	)

	(method (init)
		(= global451 1590)
		(PalVary pvCHANGE_TARGET 1590)
		(AssertPalette 590)
		(super init:)
	)

	(method (getHurt)
		(self status: 0 setScript: sFlyOut)
	)

	(method (doit)
		(super doit:)
		(= local6 (- y 10))
		(= local7 (+ y 10))
		(if
			(or
				(and
					(== (self cel:) 0)
					(== (self loop:) 0)
					(not (== (antwerp status:) 0))
				)
				(and
					(== (self cel:) 0)
					(== (self loop:) 1)
					(not (== (antwerp status:) 0))
				)
			)
			(antSound loop: 1 play:)
		)
		(if (and (== (antwerp status:) 1) (< (gEgo distanceTo: self) 50))
			(cond
				(
					(and
						(< (gEgo x:) (- x 15))
						(> (gEgo y:) local6)
						(< (gEgo y:) local7)
					)
					(self status: 3 setScript: sPushEgoLeft)
				)
				(
					(and
						(> (gEgo x:) (+ x 15))
						(> (gEgo y:) local6)
						(< (gEgo y:) local7)
					)
					(self status: 3 setScript: sPushEgoRight)
				)
				(else
					(= local11 (gEgo cycleSpeed:))
					(self
						status: 2
						cycleSpeed: 6
						setCycle: Fwd
						setPri: -1
						setScript: sAvoidEgo
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 206)
						(gMessager say: 1 1 2) ; "The only Antwerp known in these parts has split... into parts."
					)
					((IsFlag 204)
						(gMessager say: 1 1 3) ; "The Antwerp seems to have flown the coop."
					)
					(else
						(gMessager say: 1 1 4) ; "By golly, it's an Antwerp! Antwerps are on the endangered species list. They are rarely seen."
					)
				)
			)
			(4 ; Do
				(gMessager say: 1 4 2) ; "You bravely attack the bouncing beast with your bare hands."
				(gEgo setMotion: MoveTo (antwerp x:) (antwerp y:))
			)
			(12 ; sword
				(HandsOff)
				(antwerp status: 4)
				(gCurRoom setScript: sFightSword)
			)
			(16 ; dagger
				(HandsOff)
				(antwerp status: 4)
				(gCurRoom setScript: sFightDagger)
			)
			(81 ; flameDartSpell
				(HandsOff)
				(Face gEgo antwerp)
				(RedrawCast)
				(if (== (antwerp status:) 1)
					(CastDart antwerp)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sRandBounce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (antwerp status:) 4)
					(= ticks (Random 60 190))
				else
					(antSound play:)
					(if (< (antwerp x:) (gEgo x:))
						(antwerp loop: 0 setCel: 0 setCycle: End self)
					else
						(antwerp loop: 1 setCel: 255 setCycle: End self)
					)
				)
			)
			(1
				(if (== (antwerp status:) 4)
					(antwerp cycleSpeed: (Random 1 6))
				)
				(self init:)
			)
		)
	)
)

(instance sMagicRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local11 (gEgo cycleSpeed:))
				(gGame setCursor: gWaitCursor 1)
				(gEgo setMotion: PolyPath 140 86 self)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(cond
					((and (IsObject antwerp) (== (antwerp script:) sAvoidEgo)))
					((and (== (gEgo x:) 140) (== (gEgo y:) 86))
						(= ticks 1)
					)
					(else
						(gEgo setMotion: PolyPath 140 86 self)
					)
				)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(gEgo setMotion: PolyPath 109 86 self)
			)
			(3
				(gGame setCursor: gWaitCursor 1)
				(gEgo setHeading: 270)
				(= ticks 180)
			)
			(4
				(gGame setCursor: gWaitCursor 1)
				(gEgo view: 521 loop: 0 cycleSpeed: 6 setCycle: End self)
			)
			(5
				(SetFlag 252)
				(gEgo cycleSpeed: local11 moveSpeed: local11)
				(if (< [gEgoStats 17] 50) ; openSpell
					(gMessager say: 9 0 15 0 sMagicRock) ; "Your spell has unlocked the lock on the rock, but it is not yet powerful enough to open the rock door."
				else
					(theRock setCycle: 0 startUpd: setPri: 1 setCycle: End self)
					((gCurRoom obstacles:) delete: rockPoly)
					(rockPoly dispose:)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 123 64 0 64 0 0 185 -1 185 12 123 47
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 0 67 73 67 73 82 83 87 102 87 102 106 92 106 92 114 125 114 125 132 166 132 166 138 198 155 319 155 319 189 0 189
								yourself:
							)
					)
					(SolvePuzzle 701 10)
					(SetFlag 253)
				)
			)
			(6
				(theRock stopUpd:)
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(theRock setPri: 1 setCycle: End self)
				((gCurRoom obstacles:) delete: rockPoly)
				(rockPoly dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 123 64 0 64 0 0 185 -1 185 12 123 47
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 67 73 67 73 82 83 87 102 87 102 106 92 106 92 114 125 114 125 132 166 132 166 138 198 155 319 155 319 189 0 189
							yourself:
						)
				)
				(SolvePuzzle 701 10)
				(SetFlag 253)
			)
			(1
				(theRock stopUpd:)
				(NormalEgo 1)
				(HandsOn)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 204 -2 self)
			)
			(1
				(gCurRoom newRoom: 78)
			)
		)
	)
)

(instance sEnterFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo setPri: 4 setMotion: MoveTo 169 52 self)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 1 posn: 30 65 setMotion: MoveTo 96 65 self)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 1 setMotion: MoveTo 30 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 89)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 345 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 85)
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
				(gEgo
					posn: 345 (gEgo y:)
					setMotion: MoveTo 295 (gEgo y:) self
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sPushEgoRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(antwerp setLoop: 0 setCycle: Beg self)
				(gEgo setMotion: 0 setHeading: 270 self)
				(= local2 (gEgo looper:))
				(= local5 (antwerp x:))
				(= local4 (antwerp y:))
				(= local11 (gEgo cycleSpeed:))
				(= local10 (gEgo moveSpeed:))
			)
			(1)
			(2
				(antwerp
					setPri: (+ (gEgo priority:) 1)
					setCel: 1
					posn: (+ local5 8) (- local4 13)
				)
				(= ticks 10)
			)
			(3
				(gEgo view: 513 setLoop: 3 setCel: 4 looper: 0)
				(antwerp setCel: 2 posn: (+ local5 22) (- local4 19))
				(= ticks 10)
			)
			(4
				(antwerp setCel: 3 posn: (+ local5 31) (- local4 12))
				(gEgo
					view: 513
					setLoop: 3
					moveSpeed: 1
					cycleSpeed: 12
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:)
					setCycle: End
				)
				(= ticks 10)
			)
			(5
				(antwerp setCel: 4 posn: (+ local5 40) (+ local4 3))
				(= ticks 10)
			)
			(6
				(antwerp
					setCel: 255
					setCycle: Beg
					setMotion: JumpTo local5 local4 self
					setPri: -1
				)
			)
			(7
				(if (not (TakeDamage 10))
					(gEgo
						view: 529
						setLoop: 0
						cel: 0
						cycleSpeed: 3
						setCycle: End self
					)
				else
					(HandsOn)
					(NormalEgo)
					(gEgo
						loop: 1
						cycleSpeed: local11
						moveSpeed: local10
						looper: local2
					)
					(client status: 1 setScript: sRandBounce)
				)
			)
			(8
				(EgoDead 136 137) ; "The old ticker just couldn't keep going. Maybe you shouldn't have missed the annual visit to your local Healer."
			)
		)
	)
)

(instance sPushEgoLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(antwerp setLoop: 1 setCycle: Beg self)
				(gEgo setMotion: 0 setHeading: 90 self)
				(= local2 (gEgo looper:))
				(= local5 (antwerp x:))
				(= local4 (antwerp y:))
				(= local11 (gEgo cycleSpeed:))
				(= local10 (gEgo moveSpeed:))
			)
			(1)
			(2
				(antwerp
					setPri: (+ (gEgo priority:) 1)
					setCel: 1
					posn: (- local5 8) (- local4 13)
				)
				(= ticks 10)
			)
			(3
				(gEgo view: 513 setLoop: 2 setCel: 4 looper: 0)
				(antwerp setCel: 2 posn: (- local5 22) (- local4 19))
				(= ticks 10)
			)
			(4
				(antwerp setCel: 3 posn: (- local5 31) (- local4 12))
				(gEgo
					view: 513
					setLoop: 2
					moveSpeed: 1
					cycleSpeed: 12
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:)
					setCycle: End
				)
				(= ticks 10)
			)
			(5
				(antwerp setCel: 4 posn: (- local5 40) (+ local4 3))
				(= ticks 10)
			)
			(6
				(antwerp
					setCel: 255
					setCycle: Beg
					setMotion: JumpTo local5 local4 self
					setPri: -1
				)
			)
			(7
				(if (not (TakeDamage 10))
					(gEgo
						view: 529
						setLoop: 0
						cel: 0
						cycleSpeed: 3
						setCycle: End self
					)
				else
					(HandsOn)
					(gEgo
						loop: 0
						cycleSpeed: local11
						moveSpeed: local10
						looper: local2
					)
					(NormalEgo)
					(client status: 1 setScript: sRandBounce)
				)
			)
			(8
				(EgoDead 136 137) ; "The old ticker just couldn't keep going. Maybe you shouldn't have missed the annual visit to your local Healer."
			)
		)
	)
)

(instance sAvoidEgo of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (not (-- register))
			(Face gEgo antwerp)
			(= register 5)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor 1)
				(gEgo setMotion: 0)
				(= register 1)
				(switch local1
					(1
						(if (< (gEgo y:) local6)
							(antwerp setMotion: PolyPath 169 128 self)
							(= local1 4)
						else
							(antwerp setMotion: PolyPath 170 56 self)
							(= local1 2)
						)
					)
					(2
						(if (< (gEgo x:) (antwerp x:))
							(antwerp setMotion: PolyPath 272 82 self)
							(= local1 3)
						else
							(antwerp setMotion: PolyPath 110 81 self)
							(= local1 1)
						)
					)
					(3
						(if (< (gEgo y:) local6)
							(antwerp setMotion: PolyPath 169 128 self)
							(= local1 4)
						else
							(antwerp setMotion: PolyPath 170 56 self)
							(= local1 2)
						)
					)
					(4
						(if (< (gEgo x:) (antwerp x:))
							(antwerp setMotion: PolyPath 272 82 self)
							(= local1 3)
						else
							(antwerp setMotion: PolyPath 110 81 self)
							(= local1 1)
						)
					)
				)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(client status: 1 cycleSpeed: local11 setScript: sRandBounce)
				(if
					(and
						(== (gCurRoom script:) sMagicRock)
						(< (sMagicRock state:) 3)
					)
					(sMagicRock cue:)
				else
					(HandsOn)
				)
			)
		)
	)
)

(instance sFlyOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 0 1 1 self) ; "That's funny. It bounced right off."
			)
			(1
				(SetFlag 204)
				(= local5 (antwerp x:))
				(= local4 (antwerp y:))
				(Face gEgo antwerp)
				(= ticks 40)
			)
			(2
				(antwerp
					setLoop: (if (< local5 (gEgo x:)) 0 else 1)
					cycleSpeed: 16
					setCel: 255
					setCycle: Beg self
				)
			)
			(3
				(= ticks 10)
			)
			(4
				(antwerp
					cycleSpeed: 2
					setCycle: CT 2 1
					setPri: 2
					setStep: 8 8
					setMotion: MoveTo (+ local5 25) -10 self
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(gMessager say: 9 0 11) ; "You seem to have scared the Antwerp with your behavior."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFightSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local11 (gEgo cycleSpeed:))
				(= local10 (gEgo moveSpeed:))
				(Load rsVIEW 501)
				(Load rsVIEW 502)
				(if (< (gEgo y:) (antwerp y:))
					(antwerp setCycle: Fwd setMotion: PolyPath 169 128)
					(gEgo setMotion: PolyPath 230 75 self)
					(= local1 4)
				else
					(antwerp setCycle: Fwd setMotion: PolyPath 170 56)
					(gEgo setMotion: PolyPath 166 120 self)
					(= local1 2)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gMessager say: 9 0 12) ; "Cockily, you loosen up to fight."
				(gEgo
					view: 502
					setLoop: 1
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(self cue:)
			)
			(4
				(switch (++ register)
					(0
						(= local0 1)
					)
					(1
						(= local0 5)
					)
					(2
						(= local0 3)
					)
					(3
						(= local0 9)
					)
					(4
						(= local0 5)
					)
					(5
						(= local0 3)
					)
					(6
						(= local0 9)
					)
					(7
						(= local0 5)
					)
				)
				(gEgo view: 501 setLoop: local0 setCel: 0 setCycle: End self)
			)
			(5
				(if (!= register 7)
					(-= state 2)
				)
				(gEgo setCycle: Beg self)
			)
			(6
				(gMessager say: 9 0 13) ; "Confident and loose, you approach the Antwerp."
				(if (== (gEgo x:) 230)
					(NormalEgo 1)
				else
					(NormalEgo 5)
				)
				(Face gEgo antwerp)
				(gEgo
					cycleSpeed: local11
					moveSpeed: local10
					setCycle: Walk
					setMotion: PolyPath 181 88 self
				)
				(antwerp setMotion: PolyPath 110 81 self)
				(= local1 1)
			)
			(7)
			(8
				(= local5 (antwerp x:))
				(= local4 (antwerp y:))
				(= register 3)
				(= cycles 2)
			)
			(9
				(antwerp cycleSpeed: 3 setCycle: Beg self)
				(gEgo view: 501 setLoop: 3 setCel: 0 cycleSpeed: 8)
			)
			(10
				(= ticks 20)
			)
			(11
				(antwerp setCel: 1)
				(gEgo setCel: 1)
				(= ticks 5)
			)
			(12
				(antwerp
					setCel: 2
					setStep: 10 10
					setMotion: MoveTo (antwerp x:) -30
				)
				(gEgo setCel: 2)
				(= ticks 5)
			)
			(13
				(gEgo setCycle: End self)
			)
			(14
				(gEgo setCycle: Beg self)
			)
			(15
				(if (-- register)
					(antwerp setMotion: MoveTo local5 local4 self)
				else
					(gMessager say: 9 0 14 1 self) ; "Holy Mackerel!"
					(SetFlag 204)
					(antwerp status: 0)
					(= state 17)
				)
			)
			(16
				(antwerp setCycle: Fwd cycleSpeed: (Random 3 5))
				(= state 8)
				(= seconds 2)
			)
			(17
				(gEgo view: 502 loop: 1 cel: 5 setCycle: Beg self)
			)
			(18
				(HandsOn)
				(NormalEgo)
				(gEgo cycleSpeed: local11 moveSpeed: local10)
				(self dispose:)
			)
		)
	)
)

(instance sFightDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar advanceCurIcon:)
				(HandsOff)
				(= local11 (gEgo cycleSpeed:))
				(= local10 (gEgo moveSpeed:))
				(Load rsVIEW 502)
				(Load rsVIEW 512)
				(if (< (gEgo y:) (antwerp y:))
					(antwerp setCycle: Fwd setMotion: PolyPath 169 128)
					(gEgo setMotion: PolyPath 230 75 self)
					(= local1 4)
				else
					(antwerp setCycle: Fwd setMotion: PolyPath 170 56)
					(gEgo setMotion: PolyPath 171 118 self)
					(= local1 2)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gMessager say: 9 0 12) ; "Cockily, you loosen up to fight."
				(gEgo
					view: 502
					setLoop: 2
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(self cue:)
			)
			(4
				(switch (++ register)
					(0
						(= local0 5)
					)
					(1
						(= local0 9)
					)
					(2
						(= local0 6)
					)
					(3
						(= local0 9)
					)
					(4
						(= local0 7)
					)
					(5
						(= local0 9)
					)
					(6
						(= local0 8)
					)
					(7
						(= local0 9)
					)
				)
				(gEgo view: 512 setLoop: local0 setCel: 0 setCycle: End self)
			)
			(5
				(if (!= register 7)
					(-= state 2)
				)
				(gEgo setCycle: Beg self)
			)
			(6
				(gMessager say: 9 0 13) ; "Confident and loose, you approach the Antwerp."
				(if (== (gEgo x:) 230)
					(NormalEgo 1)
				else
					(NormalEgo 5)
				)
				(Face gEgo antwerp)
				(gEgo
					cycleSpeed: local11
					moveSpeed: local10
					setCycle: Walk
					setMotion: PolyPath 181 88 self
				)
				(antwerp setMotion: PolyPath 110 81 self)
				(= local1 1)
			)
			(7)
			(8
				(= local5 (antwerp x:))
				(= local4 (antwerp y:))
				(= register 3)
				(= cycles 2)
			)
			(9
				(antwerp cycleSpeed: 3 setCycle: Beg self)
				(gEgo view: 512 setLoop: 5 setCel: 0 cycleSpeed: 8)
			)
			(10
				(= ticks 20)
			)
			(11
				(antwerp setCel: 1)
				(gEgo setCel: 1)
				(= ticks 5)
			)
			(12
				(antwerp
					setCel: 2
					setStep: 10 10
					setMotion: MoveTo (antwerp x:) -30
				)
				(gEgo setCel: 2)
				(= ticks 5)
			)
			(13
				(gEgo setCycle: CT 4 1 self)
			)
			(14
				(gEgo setCycle: Beg self)
			)
			(15
				(cond
					((-- register)
						(antwerp setMotion: MoveTo local5 local4 self)
					)
					((not (TakeDamage 10))
						(EgoDead 136 137) ; "The old ticker just couldn't keep going. Maybe you shouldn't have missed the annual visit to your local Healer."
					)
					(else
						(NormalEgo)
						(gEgo loop: 1 cycleSpeed: local11 moveSpeed: local10)
						(gMessager say: 9 0 14 1 self) ; "Holy Mackerel!"
						(SetFlag 204)
						(HandsOn)
						(antwerp status: 0)
						(self dispose:)
					)
				)
			)
			(16
				(antwerp setCycle: Fwd cycleSpeed: (Random 3 5))
				(= state 8)
				(= seconds 3)
			)
		)
	)
)

(instance sDazzleAnAntwerp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(CastDazzle gEgo self)
			)
			(1
				(if (== (antwerp status:) 0)
					(HandsOn)
					(self dispose:)
				else
					(gMessager say: 9 0 10 0 self) ; "Antwerps aren't dazzled easily."
				)
			)
			(2
				(HandsOn)
				(antwerp setScript: sRandBounce)
				(self dispose:)
			)
		)
	)
)

(instance sCalmAnAntwerp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(CastCalm gEgo self)
			)
			(1
				(if (== (antwerp status:) 0)
					(HandsOn)
					(self dispose:)
				else
					(gMessager say: 9 0 9 0 self) ; "Antwerps have too bouncy a nature to ever be truly calm."
				)
			)
			(2
				(HandsOn)
				(antwerp setScript: sRandBounce)
				(self dispose:)
			)
		)
	)
)

(instance antSound of Sound
	(properties
		number 4
		priority 5
	)
)

(instance antHits of Sound
	(properties
		number 54
		priority 6
	)
)

(instance rockPoly of Polygon
	(properties
		type PBarredAccess
	)
)

