;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 854)
(include sci.sh)
(use Main)
(use n026)
(use GloryControls)
(use JumpX)
(use IconBar)
(use Polygon)
(use Feature)
(use LoadMany)
(use Window)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm854 0
	thiefEndScript 1
	grapDeWiz 2
)

(local
	local0
	local1
	[local2 2]
)

(procedure (localproc_0)
	(ropeControls state: (& (ropeControls state:) $ffdf))
)

(procedure (localproc_1)
	(ropeControls disable: 0 1 2 3 4 5 6 eachElementDo: #show)
)

(procedure (localproc_2)
	(ropeControls enable: 0 1 2 eachElementDo: #show)
)

(procedure (localproc_3 &tmp temp0))

(instance rm854 of Rm
	(properties
		modNum 850
		noun 18
		picture 850
	)

	(method (init)
		(= gHeroType 2) ; Thief
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 21 76 43 76 43 70 21 72 21 75
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 118 35 118 39 146 37 137 35 118 36
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 288 64 317 68 317 59 289 62 290 64
					yourself:
				)
		)
		(self setRegions: 850) ; endGame
		(pillarA init: setPri: 1 stopUpd:)
		(pillarB init:)
		(pillarC init:)
		((ScriptID 850 4) x: 219 y: 81 z: 0) ; orb
		((ScriptID 850 6) init: stopUpd:) ; deMaster
		(self setScript: thiefEndScript)
		(gGame save: 1)
	)

	(method (doit)
		(cond
			((and (GameIsRestarting) (> local0 2) (< local0 4))
				(Graph grDRAW_LINE 71 38 35 125 190 -1 -1)
				(Graph grUPDATE_BOX 35 38 71 125 1)
			)
			((and (GameIsRestarting) (> local0 3))
				(Graph grDRAW_LINE 75 42 31 128 190 -1 -1)
				(Graph grUPDATE_BOX 31 42 75 128 1)
				(Graph grDRAW_LINE 37 131 64 298 190 -1 -1)
				(Graph grUPDATE_BOX 37 131 64 298 1)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(LoadMany 0 57)
		(super dispose:)
	)
)

(instance thiefEndScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 6)
				(gEgo changeGait: 2) ; sneaking
				(= seconds 1)
			)
			(1
				(gEgo code: egoGaitCheck setMotion: MoveTo 20 183 self)
			)
			(2
				(gMessager say: 1 6 4 0 self 850) ; "Our plan worked, Lord! Even now, our enemy Rakeesh is in disgrace and the Liontaur Warriors march out from Tarna. The Simbani idiots and the Leopardmen fools will all avenge their murdered leaders. And they will all blame Rakeesh and each other, not dreaming it is our doing!"
			)
			(3
				(= seconds 5)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance climbPillarA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== ((ScriptID 850 2) script:) (ScriptID 850 8)) ; deWiz, castSpells
					((ScriptID 850 8) dispose:) ; castSpells
				)
				(if (gCast contains: (ScriptID 850 9)) ; zap
					((ScriptID 850 9) dispose:) ; zap
				)
				(gEgo setMotion: MoveTo 32 115 self)
			)
			(1
				(gEgo
					view: 7
					loop: 3
					setPri: 12
					setCycle: Fwd
					setMotion: MoveTo 33 106 self
				)
			)
			(2
				(gEgo
					x: 28
					y: 72
					loop: 5
					cel: 0
					setPri: 12
					setCycle: End self
				)
			)
			(3
				(= local0 1)
				(gEgo normalize: 0)
				(HandsOn)
				(gTheIconBar disable: 6 5)
				(self dispose:)
			)
		)
	)
)

(instance grapPillarB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 34 y: 71 view: 8 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				((ScriptID 850 17) number: 721 play:) ; sFx
				(grapThingy
					x: 58
					y: 32
					init:
					setCycle: Fwd
					setMotion: JumpTo 128 31 self
				)
			)
			(2
				((ScriptID 850 17) number: 361 play: 127) ; sFx
				(grapThingy dispose:)
				(gEgo normalize:)
				(Graph grDRAW_LINE 71 38 35 125 190 -1 -1)
				(Graph grUPDATE_BOX 35 38 71 125 1)
				(= local0 2)
				(gWalkHandler addToFront: pillarB)
				(HandsOn)
				(gTheIconBar disable: 5 6)
				(self dispose:)
			)
		)
	)
)

(instance grapPillarC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Walk setMotion: MoveTo 132 35 self)
			)
			(1
				(gEgo view: 8 loop: 4 cel: 0 setCycle: End self)
			)
			(2
				((ScriptID 850 17) number: 721 play:) ; sFx
				(grapThingy
					x: 157
					y: 9
					setPri: 14
					setCycle: Fwd
					init:
					setMotion: JumpTo 310 57 self
				)
			)
			(3
				((ScriptID 850 17) number: 361 play: 127) ; sFx
				(= local0 4)
				(grapThingy dispose:)
				(Graph grDRAW_LINE 37 131 64 298 148 -1 -1)
				(Graph grUPDATE_BOX 37 131 64 298 1)
				(gEgo normalize:)
				(= cycles 2)
			)
			(4
				(gMessager say: 3 6 61 0 self 850) ; "Ha! You think you are above my wrath? Let us see how high you can walk without that rope!"
			)
			(5
				((ScriptID 850 2) setCycle: End self) ; deWiz
			)
			(6
				(ropeFire init: setCycle: Fwd setScript: ropeIsBurning)
				(gWalkHandler addToFront: pillarC)
				(HandsOn)
				(gTheIconBar disable: 5 6)
				(self dispose:)
			)
		)
	)
)

(instance ropeIsBurning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(gEgo setScript: egoDeathFall)
			)
		)
	)
)

(instance toPillarB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo normalize: 0 setLoop: 0 setMotion: MoveTo 38 71 self)
			)
			(1
				(gEgo
					view: 11
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 128 36 self
				)
			)
			(2
				(if (IsFlag 124)
					(self cue:)
				else
					(gMessager say: 1 6 35 0 self 850) ; "Look above you, fool! That meddling human is going right over your head."
				)
			)
			(3
				(if (IsFlag 124)
					(self cue:)
				else
					((ScriptID 850 6) dispose:) ; deMaster
					(DrawPic 850 8)
					(= seconds 2)
				)
			)
			(4
				(if (IsFlag 124)
					(self cue:)
				else
					(gMessager say: 3 6 6 0 self 850) ; "So, you have escaped from my trap. Perhaps destroying you will be more interesting than I thought."
				)
			)
			(5
				(SetFlag 124)
				(gWalkHandler delete: pillarB)
				(HandsOn)
				(gTheIconBar disable: 6 5)
				(= local0 3)
				(gEgo normalize: 0)
				((ScriptID 850 2) setScript: timeToBurn) ; deWiz
				(self dispose:)
			)
		)
	)
)

(instance timeToBurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 850 2) view: 861 loop: 1 setCycle: End self) ; deWiz
			)
			(1
				((ScriptID 850 2) view: 863 loop: 2 cel: 0 setCycle: End self) ; deWiz
			)
			(2
				((ScriptID 850 17) number: 101 play:) ; sFx
				(pillarFire init: setCycle: End self)
			)
			(3
				(pillarFire loop: 1 setCycle: Fwd)
				(= seconds 10)
			)
			(4
				(gEgo
					takeDamage:
						(switch global209
							(1 2)
							(2 4)
							(3 6)
						)
				)
				(-- state)
				(= seconds 1)
			)
		)
	)
)

(instance toPillarC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 131 37 self ignoreHorizon: 1)
			)
			(1
				(gEgo
					view: 11
					setLoop: 2
					setPri: 14
					setCycle: Walk
					setMotion: MoveTo 193 47 self
				)
			)
			(2
				(gEgo
					view: 30
					setLoop: 2
					cel: 0
					setMotion: JumpX 236 55 15 self
					setCycle: JumpCycler 3 8
				)
			)
			(3
				(gEgo view: 11 setCycle: Walk setMotion: MoveTo 300 64 self)
			)
			(4
				(gMessager say: 3 6 48 0 self 850) ; "Now I have you! Prepare to die, worm!"
			)
			(5
				((ScriptID 850 2) view: 863 setCycle: End self) ; deWiz
			)
			(6
				(gLongSong2 number: 101 play: 127)
				(pillarFire
					x: 315
					y: 138
					loop: 0
					cel: 0
					setPri: 14
					init:
					setCycle: End self
				)
				(gEgo normalize:)
				(HandsOn)
				(ropeIsBurning dispose:)
				(= local0 5)
				(gWalkHandler delete: pillarC)
				(pillarC dispose:)
				(gTheIconBar disable: 5 6)
			)
			(7
				(pillarFire loop: 1 setCycle: Fwd)
				(= seconds 15)
			)
			(8
				(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
			)
		)
	)
)

(instance arcadeCrossing of Script
	(properties)

	(method (dispose)
		(gEgo normalize:)
		(HandsOn)
		(gTheIconBar disable: 6 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 11 setLoop: 2 setCycle: Walk)
				(ropeControls init: show: dispose:)
			)
		)
	)
)

(instance rightStep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 5) (+ (gEgo y:) 1) self
				)
			)
			(1
				(if (> (gEgo x:) 297)
					(gEgo setMotion: MoveTo 299 (- (gEgo y:) 4))
					(ropeControls hide:)
					(arcadeCrossing dispose:)
					(gWalkHandler delete: pillarC)
					(pillarC dispose:)
					(gEgo normalize:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(2
				(localproc_2)
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance leftStep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 5) (- (gEgo y:) 1) self
				)
			)
			(1
				(if (< (gEgo x:) 131)
					(ropeControls hide:)
					(arcadeCrossing dispose:)
					(gEgo normalize:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(2
				(localproc_2)
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance jumpRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 193 47 self)
			)
			(1
				(gEgo
					view: 30
					setLoop: 2
					cel: 0
					setMotion: JumpX 236 55 15 self
					setCycle: JumpCycler 3 8
				)
			)
			(2
				(if (<= (gEgo trySkill: 2 175) 0) ; agility
					(gCurRoom setScript: egoDeathFall)
				else
					(self cue:)
				)
			)
			(3
				(ropeControls hide:)
				(gWalkHandler delete: pillarC)
				(gEgo view: 11 setCycle: Walk setMotion: MoveTo 300 64 self)
			)
			(4
				(gMessager say: 3 6 48 0 self 850) ; "Now I have you! Prepare to die, worm!"
			)
			(5
				((ScriptID 850 2) view: 863 setCycle: End self) ; deWiz
			)
			(6
				(gLongSong2 number: 101 play: 127)
				(pillarFire
					x: 315
					y: 138
					loop: 0
					cel: 0
					setPri: 14
					init:
					setCycle: End self
				)
				(gEgo normalize:)
				(HandsOn)
				(ropeIsBurning dispose:)
				(= local0 5)
				(arcadeCrossing dispose:)
				(gTheIconBar disable: 5 6)
			)
			(7
				(pillarFire loop: 1 setCycle: Fwd)
				(= seconds 15)
			)
			(8
				(EgoDead 18 850 857 End) ; "The searing heat causes the flesh to peel away from your bones and your blood to boil. Soon you are nothing more than a nondescript puddle of goo. Next time, don't just stand there, do something."
			)
		)
	)
)

(instance egoDeathFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo script:)
					((gEgo script:) dispose:)
				)
				(ropeControls hide:)
				(gLongSong2 number: 912 play: 127)
				((ScriptID 850 2) ignoreActors: 1) ; deWiz
				((ScriptID 850 18) ignoreActors: 1) ; pedestal
				((ScriptID 850 4) ignoreActors: 1) ; orb
				(gEgo
					view: 6
					setLoop: 3
					setStep: 5 5
					setCycle: End
					ignoreActors: 1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 50) self
				)
			)
			(1
				(EgoDead 39 850) ; "As you fall to a particularly nasty demise, you figure out that you should have moved a little faster when walking a burning rope."
			)
		)
	)
)

(instance grapDeWiz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(toPillarC dispose:)
				(gEgo setMotion: MoveTo 299 65 self)
			)
			(1
				(gEgo view: 8 setLoop: 1 setCycle: End self)
			)
			(2
				(gLongSong2 number: 721 play: 127)
				(grapThingy
					x: 283
					y: 29
					setCycle: Fwd
					setPri: 14
					init:
					xStep: 8
					yStep: 7
					setMotion: JumpTo 185 76 self
				)
			)
			(3
				(gMessager say: 2 6 41 0 self 850) ; "Your last remaining grapnel finds its mark. The Demon Wizard emits an unearthly wail as the magic grapnel imbeds itself deeply into the creature's inhuman flesh."
			)
			(4
				(ropeFire dispose:)
				(pillarFire dispose:)
				(grapThingy dispose:)
				(gLongSong2 number: 931 play: 127)
				((ScriptID 850 2) ; deWiz
					view: 868
					setPri: 14
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(5
				((ScriptID 850 2) loop: 1 cel: 0 setCycle: End) ; deWiz
				((ScriptID 850 18) setCycle: End) ; pedestal
				((ScriptID 850 4) setLoop: 1 setMotion: MoveTo 260 61 self) ; orb
			)
			(6
				((ScriptID 850 18) setCycle: Beg) ; pedestal
				(gEgo solvePuzzle: 340 10 solvePuzzle: 341 20 normalize:)
				((ScriptID 850 2) dispose:) ; deWiz
				((ScriptID 850 4) dispose:) ; orb
				((ScriptID 850 5) setCycle: End self) ; portal
			)
			(7
				(gLongSong2 number: 831 play: 127)
				((ScriptID 850 5) setLoop: 1 setCycle: Fwd) ; portal
				(= seconds 3)
			)
			(8
				((ScriptID 850 5) dispose:) ; portal
				(gMessager say: 2 6 3 0 self 850) ; "You run for the stairs to return to your friends."
			)
			(9
				(gCurRoom newRoom: 830)
			)
		)
	)
)

(instance wizBlast of Actor ; UNUSED
	(properties
		yStep 7
		view 21
		loop 3
		signal 16384
		xStep 8
	)
)

(instance ropeFire of Prop
	(properties
		x 214
		y 54
		view 870
		loop 2
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (== (gEgo script:) jumpRope))
				(== global209 3)
				(self onMe: gEgo)
			)
			(ropeControls hide:)
			(gCurRoom setScript: egoDeathFall)
		)
	)
)

(instance pillarA of View
	(properties
		x 28
		y 115
		noun 6
		view 854
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (gCurRoom script:)) (not local0))
					(gCurRoom setScript: climbPillarA)
				)
			)
			(16 ; theGrapnel
				(if ((gInventory at: 6) state:) ; theGrapnel
					(gMessager say: 6 16 0 0 0 850) ; "You don't need to do that."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillarB of Feature
	(properties
		x 133
		y 64
		noun 8
		nsTop 31
		nsLeft 114
		nsBottom 91
		nsRight 152
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; theGrapnel
				(if
					(and
						((gInventory at: 6) state:) ; theGrapnel
						(== local0 1)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: grapPillarB)
				else
					(gMessager say: 7 16 0 0 0 850) ; "You throw your grapnel at the pillar, but it's too far to reach."
				)
			)
			(3 ; Walk
				(pillarB doVerb: 4)
				((User curEvent:) claimed: 1)
			)
			(4 ; Do
				(if (and (== local0 2) (not (gCurRoom script:)))
					(gCurRoom setScript: toPillarB)
				)
			)
		)
	)
)

(instance pillarC of Feature
	(properties
		x 304
		y 80
		noun 7
		nsTop 58
		nsLeft 283
		nsBottom 96
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; theGrapnel
				(if
					(and
						((gInventory at: 6) state:) ; theGrapnel
						(== local0 3)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: grapPillarC)
				)
			)
			(3 ; Walk
				(if (and (== local0 4) (not (gCurRoom script:)))
					(if (gCast contains: pillarFire)
						(timeToBurn dispose:)
						(pillarFire dispose:)
					)
					(if (== global209 3)
						(gCurRoom setScript: arcadeCrossing)
					else
						(gCurRoom setScript: toPillarC)
					)
					((User curEvent:) claimed: 1)
				)
			)
			(4 ; Do
				(cond
					((and (== local0 4) (not (gCurRoom script:)))
						(if (== global209 3)
							(gCurRoom setScript: arcadeCrossing)
						else
							(gCurRoom setScript: toPillarC)
						)
					)
					((== local0 5)
						(gMessager say: 2 6 38 0 0 850) ; "That is not a good idea. You'd die down there."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grapThingy of Actor
	(properties
		view 21
		loop 6
		signal 16384
	)
)

(instance pillarFire of Prop
	(properties
		x 133
		y 88
		view 870
		signal 16384
	)
)

(instance ropeControls of GloryControls
	(properties)

	(method (init)
		(super init: &rest)
		(gGame setCursor: 999)
		(= icon1 iconJump)
		(= icon2 iconRight)
		(= icon3 iconLeft)
		(= icon4 iconPush)
		(= icon5 iconPull)
		(= icon6 iconDrop)
		(= icon7 iconQuit)
		(self
			add:
				iconJump
				iconRight
				iconLeft
				iconPush
				iconPull
				iconDrop
				iconQuit
				iconMiddle
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #cursor 999
			eachElementDo: #signal 129
		)
		(self disable: iconPush iconPull iconQuit iconDrop)
		(iconQuit signal: (| (iconQuit signal:) $0040))
		(self add: iconDummy)
		(SetCursor 140 105 200 187)
	)

	(method (hide)
		(SetCursor -2)
		(super hide:)
	)

	(method (dispatchEvent event)
		(localproc_3)
		(= gGameTime (GetTime))
		(gTimers eachElementDo: #doit)
		(gCast eachElementDo: #doit)
		((gCurRoom script:) doit:)
		(Animate (gCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
		)
		(super dispatchEvent: event)
	)

	(method (show)
		(= window bridgeWin)
		(User input: 1)
		(= local1 (Graph grSAVE_BOX 129 104 189 200 1))
		(super show: &rest)
		(Graph grRESTORE_BOX local1)
		(Graph grUPDATE_BOX 130 105 189 200 1)
	)
)

(instance iconJump of IconI
	(properties
		view 470
		loop 1
		cel 0
		nsLeft 2
		nsTop 2
		maskView 470
		maskLoop 10
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1)
			(gEgo setScript: jumpRope)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconMiddle of IconI
	(properties
		view 470
		loop 7
		cel 0
		nsLeft 24
		nsTop 2
	)
)

(instance iconRight of IconI
	(properties
		view 470
		loop 9
		cel 0
		nsLeft 60
		nsTop 12
		maskView 470
		maskLoop 10
		maskCel 5
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1)
			(gEgo setScript: rightStep)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconLeft of IconI
	(properties
		view 470
		loop 8
		cel 0
		nsLeft 3
		nsTop 12
		maskView 470
		maskLoop 10
		maskCel 4
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1)
			(gEgo setScript: leftStep)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconPush of IconI
	(properties
		view 470
		loop 2
		cel 0
		nsLeft 50
		nsTop 2
		maskView 470
		maskLoop 10
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconPull of IconI
	(properties
		view 470
		loop 3
		cel 0
		nsLeft 2
		nsTop 34
		maskView 470
		maskLoop 10
		maskCel 2
	)

	(method (select)
		(if (super select: &rest)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconDrop of IconI
	(properties
		view 470
		loop 4
		cel 0
		nsLeft 53
		nsTop 34
		maskView 470
		maskLoop 10
		maskCel 3
	)

	(method (select)
		(if (super select: &rest)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconQuit of IconI
	(properties
		view 470
		loop 5
		cel 0
		nsLeft 24
		nsTop 24
		maskView 470
		maskLoop 10
		maskCel 6
	)

	(method (select)
		(if (super select: &rest)
			(localproc_0)
			(return 1)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0020))
			(return)
		)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop)
		else
			(DrawCel view loop 0 nsLeft nsTop)
		)
	)
)

(instance iconDummy of IconI
	(properties
		nsLeft 20
		nsTop 20
		nsRight 21
		nsBottom 21
		cursor 997
		signal 128
	)

	(method (show))

	(method (select)
		(return 1)
	)

	(method (highlight))
)

(instance bridgeWin of Window
	(properties
		top 130
		left 105
		bottom 189
		right 200
		type 131
	)

	(method (open)
		(super open: &rest)
		(DrawCel 470 8 0 0 0 -1)
		(DrawCel 470 0 0 0 0 -1)
	)
)

(instance egoGaitCheck of Code
	(properties)

	(method (doit)
		(if (and (not (IsFlag 124)) (not (== gEgoGait 2))) ; sneaking
			(gCurRoom setScript: (ScriptID 850 19)) ; noticeEgo
		)
		(super doit: &rest)
	)
)

