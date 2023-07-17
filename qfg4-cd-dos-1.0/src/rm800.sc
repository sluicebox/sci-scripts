;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm800 0
	pSquid 1
	aBush 2
	pSquidStone 5
)

(local
	[local0 3]
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
	local17
	local18
	local19
	local20
	local21
	local22
)

(instance rm800 of GloryRm
	(properties
		noun 1
		picture 800
		east 790
		west 535
		leftY 172
		rightY 60
	)

	(method (init)
		(gLongSong number: 550 setLoop: -1 play:)
		(switch gPrevRoomNum
			(790
				(gEgo posn: 319 59)
			)
			(else
				(gEgo posn: 0 172)
			)
		)
		(gEgo init: normalize: setScaler: Scaler 98 68 189 63)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 0 619 0 619 53 247 57 232 53 125 53 74 63 56 75 84 84 104 95 54 114 85 158 44 165 -300 140
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -300 189 26 175 88 166 94 181 143 173 224 157 228 145 221 137 202 139 212 152 193 159 158 165 139 157 126 155 66 117 116 97 116 88 70 74 80 66 119 59 169 57 210 57 253 64 619 59 619 189
					yourself:
				)
		)
		(if (not (IsFlag 335))
			(cond
				((IsFlag 347)
					(aBush
						view: 804
						setLoop: 9 1
						setCel: 0
						ignoreActors: 1
						posn: 249 149
						approachX: 148
						approachY: 165
						init:
					)
				)
				((IsFlag 353)
					(aBush
						view: 804
						setLoop: 9 1
						setCel: 0
						posn: 365 218 100
						approachX: 148
						approachY: 165
						init:
					)
					(vGoo setPri: 119 init:)
				)
				(else
					(aBush approachVerbs: 4 init:) ; Do
				)
			)
		else
			(vGoo setPri: 119 init:)
		)
		(pSquidStone init:)
		(((ScriptID 809 1) new:) ; pDrips
			setLoop: 0 1
			setCel: 0
			posn: 276 152
			cycleSpeed: 30
			init:
			ignoreActors: 1
			setCycle: Fwd
		)
		(((ScriptID 809 1) new:) ; pDrips
			setLoop: 1 1
			setCel: 0
			posn: 214 167
			cycleSpeed: 36
			init:
			ignoreActors: 1
			setCycle: Fwd
		)
		(((ScriptID 809 1) new:) ; pDrips
			setLoop: 2 1
			setCel: 0
			posn: 279 92
			cycleSpeed: 30
			setPri: 79
			init:
			ignoreActors: 1
			setCycle: Fwd
		)
		(((ScriptID 809 1) new:) ; pDrips
			setLoop: 3 1
			setCel: 0
			posn: 91 117
			cycleSpeed: 24
			init:
			ignoreActors: 1
			setCycle: Fwd
		)
		(((ScriptID 809 1) new:) ; pDrips
			setLoop: 4 1
			setCel: 0
			posn: 43 162
			cycleSpeed: 26
			init:
			ignoreActors: 1
			setCycle: Fwd
		)
		(((ScriptID 809 1) new:) ; pDrips
			setLoop: 5 1
			setCel: 0
			posn: 178 178
			cycleSpeed: 30
			init:
			ignoreActors: 1
			setCycle: Fwd
		)
		(fPath init:)
		(fLedge init:)
		(fAboveLedge init:)
		(fSideLedge init:)
		(fIsland init: approachVerbs: 4) ; Do
		(fIslandTree init: approachVerbs: 4) ; Do
		(fTreeBranch init: approachVerbs: 4) ; Do
		(fFrontTree init:)
		(fStream init: approachVerbs: 4) ; Do
		(if (and (not (IsFlag 353)) (not (IsFlag 335)))
			(tBush init:)
			(fRocks init: approachVerbs: 4) ; Do
		)
		(super init: &rest)
		(gCurRoom setScript: (ScriptID 804 0)) ; sEnter
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 790)
			(gLongSong fade: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doVerb theVerb)
		(= global441 ((User curEvent:) x:))
		(= global442 ((User curEvent:) y:))
		(switch theVerb
			(82 ; triggerSpell
				(gCurRoom setScript: (ScriptID 11)) ; castTriggerScript
				(return 1)
			)
			(4 ; Do
				(if local21
					(gMessager say: 15 6 44) ; "You pick up your daggers."
					(gEgo get: 5 local21) ; theThrowdagger
					(= local21 0)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(-82 ; triggerSpell (part 2)
				(gGlory handsOn:)
				(gCurRoom setScript: 0)
				(gMessager say: 15 6 34) ; "Nothing is happening at the moment. Maybe you'll have better luck the next time you return here."
			)
			(91 ; jugglingLightsSpell
				(gCurRoom setScript: (ScriptID 807 0)) ; sCastAJuggle
			)
			(81 ; detectMagicSpell
				(if (== (pSquidStone cel:) 0)
					(gCurRoom setScript: sDoSparkle)
				else
					(super doVerb: theVerb)
				)
			)
			(87 ; fetchSpell
				(if (and (> (gEgo y:) 100) (not local15))
					(self setScript: (ScriptID 37) 0 aBush) ; castFetchScript
				else
					(gMessager say: 16 88 21) ; "This is a bad angle from which to attempt the spell. Maybe you'd do better on the lower pathway."
				)
			)
			(-87 ; fetchSpell (part 2)
				(if (IsFlag 353)
					(self setScript: (ScriptID 804 4)) ; sFetchBonsai
				else
					(gMessager say: 15 6 35 0 self) ; "The bush seems to be stuck; it looks as though it is caught in the rocks."
				)
			)
			(10 ; Jump
				(if local15
					(gMessager say: 1 10 26) ; "That's too far to jump from here."
				else
					(gMessager say: 1 10 0 0) ; "There is no need to show off right now. Save it for later."
				)
				(return 1)
			)
			(89 ; levitateSpell
				(if (> (gEgo y:) 100)
					((ScriptID 31 0) init: (gEgo x:) (gEgo y:) 100 0 2) ; leviCode
				else
					(gMessager say: 15 6 36) ; "You can't levitate to any useful place here."
				)
			)
			(86 ; flameDartSpell
				(= local20 1)
				(self setScript: (ScriptID 32) 0 86) ; project
			)
			(93 ; lightningBallSpell
				(= local20 1)
				(self setScript: (ScriptID 32) 0 93) ; project
			)
			(79 ; frostSpell
				(= local20 1)
				(self setScript: (ScriptID 32) 0 79) ; project
			)
			(else
				(ClearFlag 9)
				(cond
					(
						(and
							(not (IsFlag 353))
							(< 236 global441 319)
							(< 113 global442 180)
						)
						(fRocks doVerb: theVerb)
					)
					((== theVerb 21) ; theRocks
						(if (IsFlag 347)
							(gMessager say: 0 33 0) ; "You missed."
							(return 1)
						else
							(gCurRoom setScript: (ScriptID 32) 0 21) ; project
						)
					)
					((== theVerb 37) ; theThrowdagger
						(if (== (gEgo has: 5) 1) ; theThrowdagger
							(gMessager say: 15 6 42) ; "You are down to your last dagger. You'd better hold on to it."
						else
							(++ local21)
							(gCurRoom setScript: (ScriptID 32) 0 37) ; project
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)

	(method (doit)
		(if (and (== (gCurRoom script:) (ScriptID 31 1)) (>= (gEgo z:) 90)) ; sLevitate
			(= local17 (gEgo z:))
			(gCurRoom setScript: sLevitating)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(ClearFlag 9)
		(if (> (pSquidStone cel:) 0)
			(gWalkHandler delete: pSquidStone)
		)
		(if script
			(script dispose:)
		)
		(DisposeScript 802)
		(DisposeScript 803)
		(DisposeScript 804)
		(DisposeScript 805)
		(DisposeScript 806)
		(DisposeScript 807)
		(DisposeScript 809)
		(super dispose:)
	)
)

(instance sDoSparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (IsFlag 335)
					(gMessager say: 1 81 9 0 self) ; "You sense moderately powerful latent magic waiting near the top of the standing stone."
				else
					(gMessager say: 1 81 8 0 self) ; "You sense moderately powerful but latent magic waiting near the top of the Squid Stone. The bonsai bush also possesses magic, but it is of a gentler, more subtle nature."
				)
			)
			(1
				(sparkle1 setCel: 0 setCycle: End self init:)
				(if (not (IsFlag 335))
					(sparkle2 setCel: 0 setCycle: End init:)
				)
			)
			(2
				(sparkle1 dispose:)
				(if (not (IsFlag 335))
					(sparkle2 dispose:)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoForce of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (> (gEgo x:) 176)
					(gEgo setMotion: PolyPath 176 (gEgo y:) self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGlory handsOn:)
				(SetFlag 9)
				(pSquidStone setPri: 0)
				(gCurRoom setScript: (ScriptID 32) 0 88) ; project
			)
		)
	)
)

(instance sThrowDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (> (gEgo x:) 176)
					(gEgo setMotion: PolyPath 176 (gEgo y:) self)
				else
					(= ticks 1)
				)
			)
			(1
				(= local11 1)
				(= local7 0)
				(SetFlag 9)
				(cond
					((== local10 3)
						(gCurRoom setScript: (ScriptID 32) 0 37 fRocks) ; project
					)
					((== (gEgo trySkill: 0 275) 1) ; strength
						(= local12 0)
						(gCurRoom setScript: (ScriptID 32) 0 37 fRocks) ; project
					)
					(else
						(= local12 1)
						(= global441 (Random 260 270))
						(= global442 (Random 103 170))
						(gCurRoom setScript: (ScriptID 32) 0 37 fRocks) ; project
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sThrowRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (> (gEgo x:) 176)
					(gEgo setMotion: PolyPath 176 (gEgo y:) self)
				else
					(= ticks 1)
				)
			)
			(1
				(= local11 0)
				(SetFlag 9)
				(if (== local10 3)
					(gCurRoom setScript: (ScriptID 32) 0 21 fRocks) ; project
				else
					(= local7 0)
					(if (== (gEgo trySkill: 0 275) 1) ; strength
						(= local12 0)
						(gCurRoom setScript: (ScriptID 32) 0 21 fRocks) ; project
					else
						(= local12 1)
						(= global441 (Random 260 270))
						(= global442 (Random 103 170))
						(gCurRoom setScript: (ScriptID 32) 0 21 fRocks) ; project
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sLevitating of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (== state 2)
			(if (== (gEgo z:) 0)
				(self cue:)
			else
				(gEgo z: (- (gEgo z:) 1))
				(local18 z: (gEgo z:))
				(if local22
					(local22
						scaleX: (- 128 (gEgo z:))
						scaleY: (- 128 (gEgo z:))
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo posn: (gEgo x:) (gEgo y:) local17)
				(= local18 (Prop new:))
				(local18
					view: 17
					loop: 4
					x: (gEgo x:)
					y: (+ (gEgo y:) 1)
					z: local17
					setCycle: Fwd
					setScaler:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					priority: (gEgo priority:)
					signal: (| (local18 signal:) $4000)
					init:
				)
				((= local22 (Prop new:))
					signal: 24577
					view: 17
					loop:
						(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
							(- (gEgo loop:) 8)
						else
							(+ (gEgo loop:) 6)
						)
					x: (gEgo x:)
					y: (+ (gEgo y:) 1)
					setCycle: Fwd
					setScale: gEgo
					priority: (gEgo priority:)
					fixPriority: 1
					init:
				)
				(= ticks 6)
			)
			(1
				(gMessager say: 15 6 28 0 self) ; "You levitated up to the ledge, but it's set too far back. You'll need to find a different approach to get up there. Remember, the followers of the Dark One used to come up here frequently; they must have had a way to get up."
			)
			(2 0)
			(3
				(gEgo trySkill: 29) ; levitateSpell
				(local18 hide: dispose:)
				(= local18 0)
				(local22 dispose:)
				(= local22 0)
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetGoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 107 177 self)
			)
			(1
				(gEgo setMotion: MoveTo 106 184 self)
			)
			(2
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					posn: 106 184
					setCycle: End self
				)
			)
			(3
				(switch local3
					(1
						(gMessager say: 11 76 0 0 self) ; "Greasy-looking though it may be, the goo seems to be totally inert and non-flammable."
					)
					(else
						(gMessager say: 11 24 0 0 self) ; "You slowly fill your flask with the greasy, grimy goo."
					)
				)
			)
			(4
				(gEgo view: 4 setCycle: Beg self)
			)
			(5
				(if (== local3 0)
					(gEgo
						solvePuzzle: 430 6
						posn: 109 184
						normalize:
						get: 11 ; theGruegoo
						drop: 9 1 ; theFlask
					)
				else
					(gEgo posn: 109 184 normalize:)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local12 0)
					(if (!= (gEgo trySkill: 0 275) 1) ; strength
						(gMessager say: 15 6 14 0 self) ; "You hit the rock pile, but the throw wasn't powerful enough to dislodge any of the rocks. You need to build up your strength or try a different approach."
					else
						(switch local10
							(0
								(= local10 1)
								(gMessager say: 15 6 15 0 self) ; "You managed to knock a few of the rocks loose from the pile, although the remaining stones still dam up the pool."
							)
							(1
								(= local10 2)
								(gMessager say: 15 6 16 0 self) ; "You knocked some more rocks loose; the pile is definitely loosening."
							)
							(2
								(= local10 3)
								(gMessager say: 15 6 17 0 self) ; "That last throw did it! The rock pile has collapsed and goo is oozing down from the pool."
							)
						)
					)
				else
					(gMessager say: 15 6 13 0 self) ; "You missed the rock pile; you'll need to keep practicing your throwing."
				)
			)
			(1
				(if (!= local10 3)
					(gGlory handsOn:)
					(self dispose:)
				else
					(aBush
						view: 800
						posn: 249 149
						setLoop: 2 1
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(aBush setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(3
				(SetFlag 347)
				(vGoo setCel: 0 init:)
				(aBush
					setLoop: 0 1
					setCel: 0
					approachX: 148
					approachY: 165
					setCycle: End self
				)
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowAtStones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local9 1)
				(= local4 (gEgo cycleSpeed:))
				(gEgo setMotion: MoveTo 150 165 self)
			)
			(1
				(gEgo
					view: 8
					setLoop: 0 1
					setCel: 0
					posn: 160 165
					setPri: 196
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 806
					setLoop: 1 1
					setCel: 0
					posn: 160 165
					setPri: 196
					cycleSpeed: 13
					setCycle: CT 2 1 self
				)
			)
			(3
				(cond
					((!= (gEgo trySkill: 10 275) 1) ; throwing
						(= local13 1)
						(gMessager say: 15 6 18 0 self) ; "Using a grapnel to dislodge stones is tricky business; you'll need to keep practicing."
					)
					((!= (gEgo trySkill: 0 250) 1) ; strength
						(= local13 1)
						(gMessager say: 15 6 19 0 self) ; "You need more strength to pull this off. You haven't been keeping up your training, have you?"
					)
					(else
						(= local13 0)
						(self cue:)
					)
				)
			)
			(4
				(gEgo setCel: 2 setCycle: CT 14 1 self)
			)
			(5
				(gEgo posn: 155 165 normalize: loop: 0 cycleSpeed: local4)
				(if local13
					(gGlory handsOn:)
					(self dispose:)
				else
					(gCurRoom setScript: sStonesDislodge)
				)
			)
		)
	)
)

(instance sDislodgeRocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBush
					view: 800
					posn: 249 149
					setLoop: 2 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(aBush setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2
				(SetFlag 347)
				(vGoo setCel: 0 init:)
				(aBush
					setLoop: 0 1
					setCel: 0
					approachX: 148
					approachY: 165
					setCycle: End self
				)
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStonesDislodge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 353)
				(aBush
					view: 800
					posn: 248 148
					setLoop: 2 1
					setPri: 199
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(aBush setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: loop: 0)
				(tBush dispose:)
				(fRocks dispose:)
				(aBush
					view: 804
					setLoop: 9 1
					setCel: 0
					posn: 365 218 100
					approachX: 148
					approachY: 165
					setPri: 120
				)
				(vGoo setPri: 100 init:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doForceBolt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local7 0)
				(pSquidStone setPri: 141)
				(gEgo normalize:)
				(if (or (== local14 1) (== (gEgo trySkill: 28 300) 1)) ; forceSpell
					(= local16 1)
					(if (== [gEgoStats 27] 0) ; fetchSpell
						(self setScript: sDislodgeRocks)
					else
						(self setScript: sStonesDislodge self)
					)
				else
					(= local14 1)
					(= local16 0)
					(gMessager say: 15 6 22 0 self) ; "That loosened up the rock pile somewhat, but you didn't hit it with enough force to completely clear the pile."
				)
			)
			(1
				(if local16
					(gMessager say: 16 88 0 0 self) ; "You blast the rock pile with a Force Bolt."
					(= local16 0)
				else
					(gEgo normalize:)
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(2
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLiftBonsai of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 263 80 self)
			)
			(1
				(gEgo
					view: 8
					setLoop: 9 1
					setCel: 0
					posn: 271 82
					setCycle: 0
				)
				((ScriptID 809 3) ; pRope
					posn: 275 62
					setPri: 174
					setCycle: End self
					init:
				)
			)
			(2
				(gMessager say: 15 6 25 0 self) ; "You feel a tug on the line. Yes! You've hooked a big one. You carefully haul in the bonsai bush, wipe some of the grimy goo off its roots, and tie it to your backpack."
			)
			(3
				(aBush
					view: 804
					setLoop: 9 1
					setCycle: 0
					setPri: 196
					posn: 350 124 0
				)
				(= ticks 6)
			)
			(4
				(aBush posn: 347 108)
				((ScriptID 809 3) setCel: 3) ; pRope
				(= ticks 6)
			)
			(5
				(aBush posn: 348 75)
				((ScriptID 809 3) setCel: 2) ; pRope
				(= ticks 6)
			)
			(6
				(aBush posn: 349 69)
				((ScriptID 809 3) setCel: 1) ; pRope
				(= ticks 6)
			)
			(7
				(aBush posn: 349 58)
				((ScriptID 809 3) setCel: 0) ; pRope
				(= ticks 6)
			)
			(8
				((ScriptID 809 3) hide: dispose:) ; pRope
				(aBush hide: dispose:)
				(gEgo
					normalize:
					loop: 2
					setPri: 152
					solvePuzzle: 415 15
					get: 48 ; theBonsai
				)
				(SetFlag 335)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseTheGrapnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local4 (gEgo cycleSpeed:))
				(= local5 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 150 165 self)
			)
			(1
				(gEgo
					view: 8
					setLoop: 0 1
					setCel: 0
					posn: 160 165
					setPri: 152
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 7 1 setCel: 0 posn: 160 166 setCycle: CT 1 1)
				((ScriptID 809 2) posn: 230 122 init: setCycle: End self) ; pGrapnel
			)
			(3
				(gEgo setLoop: 7 1 setCel: 1 setCycle: End self)
			)
			(4
				(gEgo
					normalize:
					setPri: 152
					cycleSpeed: local4
					moveSpeed: local5
					setMotion: MoveTo 242 145 self
				)
			)
			(5
				(gEgo
					view: 7
					setLoop: 0 1
					setCel: 0
					setScale:
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6
				(if (== (gEgo trySkill: 11 250) 1) ; climbing
					(gEgo
						view: 7
						posn: 242 141
						setLoop: 1 1
						setCel: 0
						setCycle: End
						setMotion: MoveTo 242 135 self
					)
				else
					(gCurRoom setScript: (ScriptID 805 0) 0 local4) ; sBadClimb
				)
			)
			(7
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo setLoop: 4 1 setCel: 0 posn: 242 81 setCycle: End self)
			)
			(8
				(gEgo
					normalize:
					setPri: 152
					cycleSpeed: local4
					moveSpeed: local5
					setMotion: MoveTo 255 75 self
				)
			)
			(9
				(Face gEgo 178 162 self)
			)
			(10
				(gEgo
					view: 4
					setLoop: 1 1
					setCel: 0
					posn: 259 78
					setCycle: End self
				)
			)
			(11
				((ScriptID 809 2) hide: dispose:) ; pGrapnel
				(= seconds 1)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(gEgo normalize: setPri: 152 setMotion: MoveTo 290 80 self)
			)
			(14
				(gCurRoom addObstacle: (ledgePoly init: yourself:))
				(= local15 1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local15 0)
				(= local4 (gEgo cycleSpeed:))
				(gEgo setPri: 152 setMotion: MoveTo 255 75 self)
			)
			(1
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo
					view: 4
					setLoop: 1 1
					setCel: 0
					posn: 259 78
					setCycle: End self
				)
			)
			(2
				((ScriptID 809 2) ; pGrapnel
					posn: 230 122
					setCel: 0
					init:
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: setPri: 152 setMotion: MoveTo 242 81 self)
			)
			(5
				(gEgo view: 7 setLoop: 4 1)
				(gEgo
					setCel: (gEgo lastCel:)
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(6
				(gEgo posn: 242 130 setLoop: 1 1)
				(gEgo
					setCel: (gEgo lastCel:)
					setCycle: Beg
					setMotion: MoveTo 242 145 self
				)
			)
			(7
				(gEgo setLoop: 0 1)
				(gEgo setCel: (gEgo lastCel:) setCycle: Beg self)
			)
			(8
				((ScriptID 809 2) hide: dispose:) ; pGrapnel
				(gEgo
					normalize:
					setPri: 152
					cycleSpeed: local4
					setMotion: MoveTo 142 172 self
				)
			)
			(9
				(gEgo normalize:)
				(gCurRoom addObstacle: (roomPoly init: yourself:))
				(gCurRoom addObstacle: (roomPoly2 init: yourself:))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJumpThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 15) ; acrobatics
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= local4 (gEgo cycleSpeed:))
				(= local5 (gEgo moveSpeed:))
				(if local15
					(gEgo setMotion: MoveTo 310 74 self)
				else
					(gEgo setMotion: MoveTo 281 59 self)
				)
			)
			(1
				(gEgo view: 30 setCel: 0 setSpeed: 6)
				(if local15
					(gEgo
						setLoop: 3 1
						setCel: 0
						setCycle: CT 8 1
						setMotion: JumpTo 281 59 self
					)
				else
					(gEgo
						setLoop: 4 1
						setCycle: CT 8 1
						setMotion: JumpTo 310 74 self
					)
				)
			)
			(2
				(gEgo normalize:)
				(if local15
					(= local15 0)
					(gCurRoom addObstacle: (roomPoly init: yourself:))
					(gCurRoom addObstacle: (roomPoly2 init: yourself:))
				else
					(= local15 1)
					(gCurRoom addObstacle: (ledgePoly init: yourself:))
				)
				(= ticks 6)
			)
			(3
				(gEgo normalize: moveSpeed: local5 cycleSpeed: local4)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoTheDarkSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 13 43 0 0 self) ; "When you touch the Dark One Sign to its image on the Squid Stone, the Sign locks into place in the small hole. The points of the Sign seem to point to six of the glowing runes."
			)
			(1
				(gUser canInput: 1)
				(SetFlag 147)
				(self setScript: (ScriptID 801 0) self) ; runesPuz
			)
			(2
				(ClearFlag 147)
				(gEgo posn: 151 173 setLoop: 6 1 setPri: 185)
				((ScriptID 809 0) setPri: 160 init:) ; pDoor
				(= seconds 1)
			)
			(3
				(if (IsFlag 355)
					((ScriptID 809 0) setCycle: End self) ; pDoor
				else
					(gMessager say: 13 1 0 0 self) ; "An image of the Sign of the Dark One has appeared on the Squid Stone."
				)
			)
			(4
				(gEgo normalize:)
				(if (IsFlag 355)
					(gMessager say: 15 6 2 0 self) ; "As you complete the name of the Dark One, you feel a distant rumble under the earth as of the earth shifting or some unimaginably huge creature stirring in its sleep."
				else
					((ScriptID 809 0) hide: dispose:) ; pDoor
					(DisposeScript 801)
					(gUser canControl: 1)
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(5
				((ScriptID 809 0) setCycle: Beg self) ; pDoor
			)
			(6
				(gEgo get: 55) ; theSenseRit
				((ScriptID 809 0) hide: dispose:) ; pDoor
				(gEgo normalize:)
				(gUser canControl: 1)
				(DisposeScript 801)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gCurRoom setScript: sThrowIt)
			)
		)
	)
)

(instance tBush of TargActor
	(properties
		x 276
		y 164
		fixPriority 1
		view 804
		loop 11
		signal 16384
	)

	(method (cue)
		(ClearFlag 9)
		(if local7
			(gCurRoom setScript: doForceBolt)
		else
			(gCurRoom setScript: sWait)
		)
	)
)

(instance aBush of Actor
	(properties
		noun 2
		approachX 154
		approachY 163
		x 248
		y 149
		priority 250
		fixPriority 1
		view 804
		loop 8
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(cond
					((and (< 73 (gEgo y:) 81) (< 263 (gEgo x:) 312))
						(if (IsFlag 353)
							(gCurRoom setScript: sLiftBonsai)
						else
							(gMessager say: 2 33 23) ; "That wouldn't work very well. With the rock pile covering the roots of the bonsai bush, you'd probably end up destroying the bush in the course of dragging it free."
						)
					)
					((IsFlag 353)
						(gMessager say: 2 33 24) ; "The stones are clear of the bush now, but you still don't have a good angle on it. Dragging the bush sideways would surely harm it."
					)
					(else
						(fRocks doVerb: 33)
					)
				)
			)
			(-87 ; fetchSpell (part 2)
				(if (IsFlag 353)
					(self setScript: (ScriptID 804 4)) ; sFetchBonsai
				else
					(gMessager say: 15 6 35 0 self) ; "The bush seems to be stuck; it looks as though it is caught in the rocks."
				)
			)
			(87 ; fetchSpell
				(if (and (> (gEgo y:) 100) (not local15))
					(= global441 ((User curEvent:) x:))
					(= global442 ((User curEvent:) y:))
					(gCurRoom setScript: (ScriptID 37) 0 aBush) ; castFetchScript
				else
					(gMessager say: 16 88 21) ; "This is a bad angle from which to attempt the spell. Maybe you'd do better on the lower pathway."
				)
			)
			(4 ; Do
				(if (IsFlag 347)
					(gCurRoom setScript: (ScriptID 804 3)) ; sGetTheBush
				else
					(gMessager say: 2 4 0 0) ; "You can't reach the bonsai from here and the ledge is too slippery for you to climb on it. Perhaps you can try something else."
				)
			)
			(88 ; forceBoltSpell
				(if (and (> (gEgo y:) 100) (not local15))
					(= local7 1)
					(gCurRoom setScript: (ScriptID 32) 0 88) ; project
				else
					(gMessager say: 16 88 21) ; "This is a bad angle from which to attempt the spell. Maybe you'd do better on the lower pathway."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sparkle1 of Prop
	(properties
		x 160
		y 50
		priority 255
		fixPriority 1
		view 801
		loop 3
		signal 20481
	)
)

(instance sparkle2 of Prop
	(properties
		x 285
		y 110
		priority 255
		fixPriority 1
		view 801
		loop 4
		signal 20481
	)
)

(instance pSquidStone of Prop
	(properties
		noun 4
		x 178
		y 162
		priority 141
		fixPriority 1
		view 801
		signal 20481
	)

	(method (handleEvent event)
		(if
			(and
				(== ((gTheIconBar getCursor:) view:) 940)
				(> (pSquidStone cel:) 0)
				(self onMe: event)
			)
			(event claimed: 1)
			(if (< (gEgo y:) 100)
				(gCurRoom setScript: (ScriptID 802 1)) ; sClimbDown
			else
				(gCurRoom setScript: (ScriptID 802 0)) ; sClimbAboard
			)
		else
			(event claimed: 0)
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(= global441 ((User curEvent:) x:))
		(= global442 ((User curEvent:) y:))
		(switch theVerb
			(1 ; Look
				(cond
					((> (pSquidStone cel:) 0)
						(gMessager say: 4 1 41 0) ; "The standing stone has fallen to form a sort of stone bridge up to the ledge."
					)
					((or (== gHeroType 3) (== gHeroType 0)) ; Paladin, Fighter
						(gMessager say: 4 1 6) ; "This tall standing stone has been carved so that the top looks like a squid is perched upon it. It doesn't look particularly stable."
					)
					(else
						(gMessager say: 4 1 0 0) ; "This tall standing stone has been carved so that the top looks like a squid is perched upon it."
					)
				)
			)
			(4 ; Do
				(if (or (== gHeroType 3) (== gHeroType 0)) ; Paladin, Fighter
					(cond
						((> (pSquidStone cel:) 0)
							(if (< (gEgo y:) 100)
								(gCurRoom setScript: (ScriptID 802 1)) ; sClimbDown
							else
								(gCurRoom setScript: (ScriptID 802 0)) ; sClimbAboard
							)
						)
						((> (gEgo y:) 100)
							(gCurRoom setScript: (ScriptID 806 1)) ; sPushOver
						)
						(else
							(gMessager say: 4 4 0 0) ; "The standing stone feels rock-solid."
						)
					)
				else
					(gMessager say: 4 4 0 0) ; "The standing stone feels rock-solid."
				)
			)
			(82 ; triggerSpell
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
				(return 1)
			)
			(-82 ; triggerSpell (part 2)
				(if (== (pSquidStone cel:) 0)
					(pSquidStone setPri: 110)
					(gCurRoom setScript: (ScriptID 806 0)) ; sToppleSquid
				else
					(gCurRoom setScript: 0)
					(gMessager say: 4 1 41 0) ; "The standing stone has fallen to form a sort of stone bridge up to the ledge."
					(gGlory handsOn:)
				)
			)
			(60 ; theWillowisp
				(cond
					((> (pSquidStone cel:) 0)
						(gMessager say: 4 1 41 0) ; "The standing stone has fallen to form a sort of stone bridge up to the ledge."
					)
					((> (gEgo y:) 100)
						(if (== (pSquidStone cel:) 0)
							(if (== (pSquid cel:) 0)
								(gCurRoom setScript: (ScriptID 804 2)) ; sShowRunes
							else
								(gMessager say: 4 60 31) ; "Nothing else happens; the runes are already visible."
							)
						else
							(gMessager say: 15 6 34) ; "Nothing is happening at the moment. Maybe you'll have better luck the next time you return here."
						)
					)
					(else
						(gMessager say: 15 6 34) ; "Nothing is happening at the moment. Maybe you'll have better luck the next time you return here."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pSquid of Prop
	(properties
		noun 13
		approachX 146
		approachY 158
		x 173
		y 189
		z 100
		priority 152
		fixPriority 1
		view 803
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; theDarksign
				(if (> (gEgo y:) 100)
					(if (or (IsFlag 355) (gEgo has: 55)) ; theSenseRit
						(gMessager say: 15 6 11) ; "You've already solved the mystery of the runes on the standing stone. There is no need to risk waking Avoozl further."
					else
						(gCurRoom setScript: sDoTheDarkSign)
					)
				else
					(gMessager say: 15 6 34) ; "Nothing is happening at the moment. Maybe you'll have better luck the next time you return here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vGoo of View
	(properties
		noun 11
		x 249
		y 148
		view 804
		loop 7
		signal 16385
	)

	(method (doVerb theVerb)
		(if (not (IsFlag 335))
			(aBush doVerb: theVerb)
		else
			(fLedge doVerb: theVerb)
		)
	)
)

(instance fAboveLedge of Feature
	(properties
		noun 6
		nsLeft 220
		nsTop 67
		nsRight 319
		nsBottom 87
		sightAngle 180
		x 269
		y 77
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 70 145 129 145 129 150 70 150
						yourself:
					)
					4
					5
					2
					(ScriptID 803 3) ; sWalksDown
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(cond
					(local15
						(gCurRoom setScript: sGetDown)
					)
					((> (gEgo y:) 100)
						(gCurRoom setScript: sUseTheGrapnel)
					)
					(else
						(gMessager say: 16 33 21) ; "You can't get a good throwing angle from here. If you're trying to dislodge the stones, try it from the lower path."
					)
				)
			)
			(4 ; Do
				(if local15
					(gMessager say: 5 4 27) ; "Yes, it's slippery, all right."
				else
					(gMessager say: 5 4 0) ; "You can't quite reach the ledge; you'll need equipment to climb it."
				)
			)
			(10 ; Jump
				(cond
					((< (gEgo y:) 65)
						(gCurRoom setScript: sJumpThere)
					)
					(local15
						(gMessager say: 6 159 27) ; "What for? You're already up there."
					)
					(else
						(gMessager say: 5 159 0) ; "The lower ledge is too slippery with goo to safely jump there. You'll need to climb it."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fPath of Feature
	(properties
		noun 6
		nsLeft 202
		nsTop 49
		nsRight 319
		nsBottom 63
		sightAngle 180
		x 202
		y 49
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Jump
				(cond
					((< (gEgo y:) 65)
						(gMessager say: 6 159 27) ; "What for? You're already up there."
					)
					(local15
						(gCurRoom setScript: sJumpThere)
					)
					(else
						(gMessager say: 6 159 26) ; "That's too far for you to jump even using acrobatics. You'll have to climb up to the lower ledge before you can attempt jumping to the upper one."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fStream of Feature
	(properties
		noun 11
		nsLeft 129
		nsTop 149
		nsRight 283
		nsBottom 189
		sightAngle 180
		x 206
		y 169
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 113 186 129 180 149 176 149 175 198 166 241 155 243 149 266 146 281 152 262 162 271 174 212 183 208 189 113 189
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; theFlask
				(if (> (gEgo y:) 100)
					(= local3 0)
					(gCurRoom setScript: sGetGoo)
				else
					(gMessager say: 11 24 29) ; "You can't reach the goo stream from up here."
				)
			)
			(76 ; theTorch
				(if (> (gEgo y:) 100)
					(= local3 1)
					(gCurRoom setScript: sGetGoo)
				else
					(gMessager say: 11 76 29) ; "You'd probably just lose the torch."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fLedge of Feature
	(properties
		noun 5
		nsLeft 238
		nsTop 116
		nsRight 275
		nsBottom 134
		sightAngle 180
		x 256
		y 116
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 203 50 220 50 220 65 203 65
						yourself:
					)
					1
					7
					5
					(ScriptID 804 1) ; sGiveMsg
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(gMessager say: 15 6 20) ; "There's too much goo on the lower ledge for the grapnel to catch anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fSideLedge of Feature
	(properties
		noun 5
		nsLeft 238
		nsTop 116
		nsRight 275
		nsBottom 134
		sightAngle 180
		x 256
		y 125
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 296 138 305 137 310 134 307 132 306 127 319 127 319 174 275 176 261 162 280 155 281 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(gMessager say: 15 6 20) ; "There's too much goo on the lower ledge for the grapnel to catch anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fIsland of Feature
	(properties
		noun 7
		nsLeft 128
		nsTop 94
		nsRight 182
		nsBottom 120
		sightAngle 180
		x 155
		y 107
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 108 51 125 51 125 65 108 65
						yourself:
					)
					1
					7
					5
					(ScriptID 803 0) ; sFallsBackSide
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fIslandTree of Feature
	(properties
		noun 8
		nsLeft 106
		nsRight 171
		nsBottom 94
		sightAngle 180
		x 138
		y 47
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 107 3 163 0 171 0 165 7 164 22 147 28 148 35 141 37 135 50 141 60 150 60 157 62 172 73 170 95 157 103 129 102 130 77 129 68 120 58 112 56 112 50 117 51 117 44 128 39 129 29 117 17 100 7
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fTreeBranch of Feature
	(properties
		noun 9
		nsLeft 41
		nsTop -1
		nsRight 107
		nsBottom 35
		sightAngle 180
		x 74
		y 17
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 43 114 84 114 84 120 43 120
						yourself:
					)
					3
					7
					1
					(ScriptID 803 1) ; sFallsStomach
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fFrontTree of Feature
	(properties
		noun 10
		nsTop -1
		nsRight 41
		nsBottom 189
		sightAngle 180
		x 20
		y 94
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 54 137 123 137 123 143 54 143
						yourself:
					)
					3
					6
					7
					(ScriptID 803 2) ; sSlippery
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)
)

(instance fRocks of TargFeature
	(properties
		noun 16
		nsLeft 236
		nsTop 86
		nsRight 319
		nsBottom 180
		sightAngle 180
		approachX 154
		approachY 163
		x 274
		y 144
	)

	(method (getHurt)
		(ClearFlag 9)
		(gGlory handsOn:)
		(cond
			((== local20 1)
				(= local20 0)
				(gMessager say: 16 4 34) ; "This spell seems to have no effect on the rock dam."
			)
			((== local7 0)
				(gCurRoom setScript: sThrowIt)
			)
			(else
				(gCurRoom setScript: doForceBolt)
				(= local7 0)
			)
		)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 268 146 262 146 254 131 267 131 279 130 282 137 283 148 281 152
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= global441 ((User curEvent:) x:))
		(= global442 ((User curEvent:) y:))
		(switch theVerb
			(33 ; theGrapnel
				(cond
					((< (gEgo y:) 100)
						(gMessager say: 16 33 21) ; "You can't get a good throwing angle from here. If you're trying to dislodge the stones, try it from the lower path."
					)
					((IsFlag 347)
						(gMessager say: 0 33 0) ; "You missed."
						(return 1)
					)
					(else
						(gCurRoom setScript: sThrowAtStones)
					)
				)
			)
			(4 ; Do
				(gMessager say: 2 4 0) ; "You can't reach the bonsai from here and the ledge is too slippery for you to climb on it. Perhaps you can try something else."
			)
			(21 ; theRocks
				(cond
					((IsFlag 347)
						(gMessager say: 0 33 0) ; "You missed."
						(return 1)
					)
					((< (gEgo y:) 100)
						(gMessager say: 16 33 21) ; "You can't get a good throwing angle from here. If you're trying to dislodge the stones, try it from the lower path."
					)
					(else
						(gCurRoom setScript: sThrowRock)
					)
				)
			)
			(86 ; flameDartSpell
				(gCurRoom setScript: (ScriptID 32) 0 86) ; project
			)
			(93 ; lightningBallSpell
				(gCurRoom setScript: (ScriptID 32) 0 93) ; project
			)
			(79 ; frostSpell
				(gCurRoom setScript: (ScriptID 32) 0 79) ; project
			)
			(88 ; forceBoltSpell
				(= local7 1)
				(if (and (> (gEgo y:) 100) (not local15))
					(gCurRoom setScript: (ScriptID 32) 0 88) ; project
				else
					(gMessager say: 16 88 21) ; "This is a bad angle from which to attempt the spell. Maybe you'd do better on the lower pathway."
				)
			)
			(37 ; theThrowdagger
				(cond
					((== (gEgo has: 5) 1) ; theThrowdagger
						(gMessager say: 15 6 42) ; "You are down to your last dagger. You'd better hold on to it."
					)
					((or (< (gEgo y:) 100) local15)
						(gMessager say: 16 33 21) ; "You can't get a good throwing angle from here. If you're trying to dislodge the stones, try it from the lower path."
					)
					(else
						(++ local21)
						(gCurRoom setScript: sThrowDagger)
					)
				)
			)
			(82 ; triggerSpell
				(gCurRoom setScript: (ScriptID 11) 0 self) ; castTriggerScript
				(return 1)
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: 0)
				(gMessager say: 15 6 34) ; "Nothing is happening at the moment. Maybe you'll have better luck the next time you return here."
				(gGlory handsOn:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance roomPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super
			init: -300 0 619 0 619 53 247 57 232 53 125 53 74 63 56 75 84 84 104 95 54 114 85 158 44 165 -300 140
		)
	)
)

(instance roomPoly2 of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super
			init: -300 189 26 175 88 166 94 181 143 173 224 157 228 145 221 137 202 139 212 152 193 159 158 165 139 157 126 155 66 117 116 97 116 88 70 74 80 66 119 59 169 57 210 57 253 64 619 59 619 189
		)
	)
)

(instance ledgePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 312 73 263 73 263 81 312 81)
	)
)

