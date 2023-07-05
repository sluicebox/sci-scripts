;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use GloryRm)
(use DeathIcon)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm720 0
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
)

(instance rm720 of GloryRm
	(properties
		noun 10
		picture 720
	)

	(method (init)
		(ClearFlag 6)
		(= local4
			(cond
				((not (IsFlag 101)) 1)
				((not (IsFlag 453)) 2)
				((not (IsFlag 455)) 3)
				((not (IsFlag 457)) 4)
				((not (IsFlag 459)) 5)
				((not (IsFlag 464)) 6)
				(else 0)
			)
		)
		(gEgo init: normalize: setScaler: Scaler 88 37 166 53)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 25 138 55 174 115 179 115 489 -300 489 -300 -300 619 -300 619 489 150 489 283 171 313 109 296 109 284 123 257 120 234 102 257 90 259 82 245 73 228 73 215 80 224 97 197 103 140 89 144 79 113 61 122 54 108 54 100 60 105 82 78 82 68 79 56 79 77 92 68 98 52 100 56 110 36 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 113 109 186 109 231 119 231 125 257 125 257 140 231 140 231 144 110 144 94 128 109 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 249 151 249 168 216 168 216 151
					yourself:
				)
		)
		(if (and (== gPrevRoomNum 810) (IsFlag 368)) ; combat
			(gLongSong number: 200 play:)
			(badder2 init: approachX: 182 approachY: 159 approachVerbs: 4) ; Do
			(badder1 init: approachX: 165 approachY: 176 approachVerbs: 4) ; Do
			(if global462
				(badder2
					cel: 3
					posn: 227 109
					setPri: 230
					setStep: 6 4
					setCycle: Fwd
					setLoop: 2 1
					setScript: sFollow2
				)
			else
				(badder2 view: 827 loop: 0 cel: 5 posn: 182 159)
			)
			(if global156
				(badder1
					posn: 279 135
					setPri: 230
					setStep: 6 4
					setCycle: Fwd
					setLoop: 2 1
					setScript: sFollow1
				)
			else
				(badder1 view: 827 loop: 0 cel: 5 posn: 165 176)
			)
		)
		(if (== gHeroType 2) ; Thief
			(tSign init:)
		)
		(if (== local4 1)
			(cond
				((OneOf gHeroType 0 3) ; Fighter, Paladin
					(gTheDoits add: CaveExit)
					(if (not (gEgo has: 19)) ; theSword
						(swordNShield init:)
					)
				)
				((and (== gHeroType 1) (not (gEgo has: 35))) ; Magic User, theCloth
					(cloth init:)
				)
			)
		)
		(torchEff init: setScaler: gEgo setCycle: RandCycle)
		(exit2 init: approachVerbs: 4) ; Do
		(exit3 init: approachVerbs: 4) ; Do
		(exit4 init: approachVerbs: 4) ; Do
		(exit5 init: approachVerbs: 4) ; Do
		(heart init: approachVerbs: 4) ; Do
		(senseExitF init: approachVerbs: 4) ; Do
		(boneExitF init: approachVerbs: 4) ; Do
		(breathExitF init: approachVerbs: 4) ; Do
		(bloodExitF init: approachVerbs: 4) ; Do
		(altar init:)
		(altarStem init:)
		(essenceExit init:)
		(CaveExit init:)
		(switch gPrevRoomNum
			(740
				(gEgo x: 41 y: 61)
				(= local3 exit2)
				(= local2 bloodExitF)
			)
			(750
				(gEgo x: 116 y: 55 loop: 2)
				(= local3 exit3)
				(= local2 breathExitF)
			)
			(760
				(gEgo x: 277 y: 52)
				(= local3 exit4)
				(= local2 senseExitF)
			)
			(810 ; combat
				(gEgo x: 105 y: 160 loop: 0)
			)
			(else
				(gEgo x: 340 y: 100)
				(= local3 exit5)
				(= local2 boneExitF)
			)
		)
		(super init: &rest)
		(if
			(or
				(and (OneOf gHeroType 0 3) (IsFlag 368)) ; Fighter, Paladin
				(OneOf gHeroType 1 2) ; Magic User, Thief
			)
			(= south 710)
		)
		(if (and (== local4 1) (not (IsFlag 368)) (OneOf gHeroType 1 2)) ; Magic User, Thief
			(gEgo setScript: sCounter)
		)
		(RemapColors 1 253 112 175 62) ; ByRange
		(switch gPrevRoomNum
			(710
				(gCurRoom setScript: fromSouth)
			)
			(810 ; combat
				(cond
					((and (not global156) (not global462))
						(gCurRoom setScript: sBackFromCombat)
					)
					((== gCombatResult 1)
						(gCurRoom setScript: sBadderWins)
					)
					(else
						(gGlory handsOn:)
					)
				)
			)
			(else
				(gCurRoom setScript: sEnter)
			)
		)
		(if (and (== local4 1) (not (IsFlag 371)))
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; levitateSpell
				((ScriptID 31 0) init: 164 155 100) ; leviCode
			)
			(81 ; detectMagicSpell
				(gMessager say: 0 81 0) ; "The entire cave is suffused with dark, eldritch magic. The focus seems to be the altar near the center of the chamber."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: CaveExit)
		(super dispose: &rest)
	)
)

(instance levitateExit of Code
	(properties)

	(method (doit)
		(if (> (gEgo z:) 95)
			(gCurRoom setScript: toEndGame)
		)
	)
)

(instance boneCode of Code
	(properties)

	(method (doit)
		(if
			(gEgo
				inRect:
					(boneExitF nsLeft:)
					(boneExitF nsTop:)
					(boneExitF nsRight:)
					(boneExitF nsBottom:)
			)
			(= local0 310)
			(= local1 115)
			(gEgo setMotion: 0)
			(gCurRoom setScript: sExit 0 770)
		)
	)
)

(instance bloodCode of Code
	(properties)

	(method (doit)
		(if
			(gEgo
				inRect:
					(bloodExitF nsLeft:)
					(bloodExitF nsTop:)
					(bloodExitF nsRight:)
					(bloodExitF nsBottom:)
			)
			(= local0 35)
			(= local1 56)
			(gEgo setMotion: 0)
			(gCurRoom setScript: sExit 0 740)
		)
	)
)

(instance breathCode of Code
	(properties)

	(method (doit)
		(if
			(gEgo
				inRect:
					(breathExitF nsLeft:)
					(breathExitF nsTop:)
					(breathExitF nsRight:)
					(breathExitF nsBottom:)
			)
			(= local0 116)
			(= local1 55)
			(gEgo setMotion: 0)
			(gCurRoom setScript: sExit 0 750)
		)
	)
)

(instance senseCode of Code
	(properties)

	(method (doit)
		(if
			(gEgo
				inRect:
					(senseExitF nsLeft:)
					(senseExitF nsTop:)
					(senseExitF nsRight:)
					(senseExitF nsBottom:)
			)
			(= local0 277)
			(= local1 52)
			(gEgo setMotion: 0)
			(gCurRoom setScript: sExit 0 760)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo code: 0)
				(switch register
					(740
						(exit2
							setLoop: (+ (exit2 loop:) 1)
							setCycle: hideEndLoop self
						)
					)
					(750
						(exit3
							setLoop: (+ (exit3 loop:) 1)
							setCycle: hideEndLoop self
						)
					)
					(760
						(exit4
							setLoop: (+ (exit4 loop:) 1)
							setCycle: hideEndLoop self
						)
					)
					(else
						(exit5
							setLoop: (+ (exit5 loop:) 1)
							setCycle: hideEndLoop self
						)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(2
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(local3 setLoop: (+ (local3 loop:) 1) setCycle: End self)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(local2 approachX:)
						(local2 approachY:)
						self
				)
			)
			(2
				(local3 setCycle: Beg self)
			)
			(3
				(if (not (IsFlag 371))
					(SetFlag 371)
					(gMessager say: 16 6 10 0 self) ; "You've made it into a large chamber. Stone valves like the one you just passed through apparently block three other passageways. There is a huge stone altar in the center of the room and an exit to the south."
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo
					code:
						(switch local4
							(3 bloodCode)
							(4 breathCode)
							(5 senseCode)
							(6 levitateExit)
							(else 0)
						)
				)
				(local3 setLoop: (- (local3 loop:) 1))
				(switch local4
					(1 0)
					(3
						(exit2 setCycle: Fwd)
					)
					(4
						(exit3 setCycle: Fwd)
					)
					(5
						(exit4 setCycle: Fwd)
					)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local4 2)
					(gEgo code: boneCode)
					(exit5 setCycle: Fwd)
				)
				(gEgo x: 145 y: 240 setMotion: PolyPath 145 172 self)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 4 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(1
				(gEgo get: 0 3) ; thePurse
				(+= global395 17)
				(switch register
					(swordNShield
						((gInventory at: 18) state: 0) ; theShield
						((gInventory at: 19) state: 0) ; theSword
						(gEgo get: 19 get: 18) ; theSword, theShield
						(swordNShield hide:)
					)
					(else
						(gEgo get: 35) ; theCloth
						(cloth hide:)
					)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(if (== register swordNShield)
					(if local6
						(gMessager say: 16 6 7 0 self) ; "Frantically searching for something better with which to defend yourself, you snatch a battered old sword and shield from the remains of a not-so-lucky combatant. Just in time, you prepare yourself for battle."
					else
						(gMessager say: 11 4 0 0 self) ; "You gratefully retrieve the shield and battered sword from the dead warrior. You hope they will serve you better than they did their last owner."
					)
				else
					(gMessager say: 12 4 0 0 self) ; "You pick up the canvas sheet and take 3 Crowns and 17 Kopeks from the pouch -- he won't be needing them any time soon!"
				)
			)
			(3
				(register dispose:)
				(gEgo normalize: 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 7 setLoop: 3 1 setPri: 185 setCycle: Walk)
				(if (gEgo trySkill: 11 100) ; climbing
					(= register 1)
					(gEgo
						setScale: 0
						scaleSignal: 1
						scaleX: 99
						scaleY: 99
						cycleSpeed: 6
						moveSpeed: 6
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 50) self
					)
				else
					(= register 0)
					(gEgo
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
					)
				)
			)
			(1
				(if register
					(gCurRoom setScript: toEndGame)
				else
					(gMessager say: 16 6 4 0 self) ; "Your rope has grown slick with cavern moisture. This may not be the best time or place for it, but you'll need more practice (or a different approach)."
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 113 148 self)
			)
			(1
				(gEgo
					view: 8
					setLoop: 0 1
					cel: 0
					x: (+ (gEgo x:) 4)
					y: (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(2
				(aRope init: setCycle: End)
				(gEgo setLoop: 7 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo drop: 16) ; theGrapnel
				(gEgo normalize: 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBadderAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gCurRoom south: 710)
				(= local5 gEgoGait)
				(if (and (not (gEgo has: 19)) (OneOf gHeroType 0 3)) ; theSword, Fighter, Paladin
					(gEgo changeGait: 1 setMotion: PolyPath 209 176 self) ; running
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo changeGait: local5)
				(badder1
					x: 109
					y: 187
					init:
					setPri: 230
					setStep: 6 4
					setCycle: Fwd
					setLoop: 2 1
					setScript: sFollow1
				)
				(badder2
					x: 116
					y: 194
					cel: 3
					init:
					setPri: 230
					setStep: 6 4
					setCycle: Fwd
					setLoop: 2 1
					setScript: sFollow2
				)
				(= seconds 4)
			)
			(2
				(gMessager say: 16 6 6 0 self) ; "As you approach the exit, you are confronted by two flying creatures. They have bat wings and spider-like bodies."
			)
			(3
				(= next sCombat)
				(self dispose:)
			)
		)
	)
)

(instance sCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (not (IsFlag 368))
					(SetFlag 368)
					(= gCombatMonsterNum 825) ; badder
					(= global156 50)
					(= global462 50)
				)
				(gCurRoom south: 710)
				(= local5 gEgoGait)
				(if (and (not (gEgo has: 19)) (OneOf gHeroType 0 3)) ; theSword, Fighter, Paladin
					(= local6 1)
					(gEgo changeGait: 1 setMotion: PolyPath 242 170 self) ; running
				else
					(= cycles 1)
				)
			)
			(1
				(if local6
					(self setScript: pickUp self swordNShield)
				else
					(= cycles 1)
				)
			)
			(2
				(Face gEgo (badder2 x:) (badder2 y:) self)
			)
			(3
				(gEgo changeGait: local5)
				(gCurRoom newRoom: 810) ; combat
			)
		)
	)
)

(instance toEndGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #hide)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(= cycles 2)
			)
			(1
				(gEgo solvePuzzle: 463 6)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance showSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 50)
				(= local7
					(gGlory
						setCursor:
							((gTheIconBar getCursor:)
								view: 999
								loop: 0
								cel: 0
								yourself:
							)
					)
				)
				(markCloseUp
					init:
					moveSpeed: 0
					setStep: 16 16
					setLoop: 0 1
					setScaler: Scaler 7 100 155 5
					setMotion: MoveTo 55 5 self
				)
			)
			(1
				(gNarrator y: 130)
				(gMessager say: 15 1 0 0 self) ; "Those scratches on the cave floor look deliberate -- they must be a Thief Mark!"
			)
			(2
				(gNarrator y: -1)
				(gMouseDownHandler addToFront: markCloseUp)
				(gKeyDownHandler addToFront: markCloseUp)
				(gGlory handsOn:)
			)
			(3
				(gGlory handsOff:)
				(gMouseDownHandler delete: markCloseUp)
				(gKeyDownHandler delete: markCloseUp)
				(markCloseUp setMotion: MoveTo 226 155 self)
			)
			(4
				(markCloseUp dispose:)
				(gGlory setCursor: local7)
				(ClearFlag 50)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setSpeed: global433
					setScale: 0
					scaleSignal: 1
					scaleX: 99
					scaleY: 99
					view: 7
					setLoop: 0 1
					cel: 0
					setPri: 230
					setCycle: End self
				)
			)
			(1
				(gEgo x: 156 y: 145 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo x: 155 y: 131 cel: 0 setCycle: End self)
			)
			(3
				(gEgo x: 158 y: 85 setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo get: 16) ; theGrapnel
				(gCurRoom setScript: toEndGame)
			)
		)
	)
)

(instance sFollow1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(badder1 setMotion: PolyPath (gEgo x:) (- (gEgo y:) 15))
				(= cycles 4)
			)
			(2
				(if
					(and
						(<
							(GetDistance
								(badder1 x:)
								(badder1 y:)
								(gEgo x:)
								(- (gEgo y:) 15)
							)
							35
						)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: sCombat)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance sFollow2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(badder2 setMotion: PolyPath (gEgo x:) (- (gEgo y:) 20))
				(= cycles 5)
			)
			(2
				(if
					(and
						(<
							(GetDistance
								(badder2 x:)
								(badder2 y:)
								(gEgo x:)
								(- (gEgo y:) 20)
							)
							35
						)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: sCombat)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance sRitOnHeart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo use: 56 solvePuzzle: 462 6) ; theHeartRit
				(heart setCycle: Fwd)
				(= seconds 2)
			)
			(1
				(gMessager say: 2 74 0 0 self) ; "You unroll the scroll containing the Heart Ritual. The words are visible at last and you begin to perform the Ritual."
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackFromCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (and (== gHeroType 0) (not (IsFlag 480))) ; Fighter
					(gEgo solvePuzzle: 480 2 1)
				)
				(= cycles 2)
			)
			(1
				(gMessager say: 16 6 9 0 self) ; "In a bitter battle, you were better than the Badders."
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBadderWins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(EgoDead 12 0 937 1 912)
			)
		)
	)
)

(instance sCounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 70)
			)
			(1
				(gMessager say: 16 6 11 0 self) ; "A flock of winged creatures emerges from the cave entrance... and they don't look friendly."
			)
			(2
				(badder1
					x: 109
					y: 187
					init:
					setPri: 230
					setStep: 6 4
					setCycle: Fwd
					setLoop: 2 1
					setScript: sFollow1
				)
				(badder2
					x: 116
					y: 194
					cel: 4
					init:
					setPri: 230
					setStep: 6 4
					setCycle: Fwd
					setLoop: 2 1
					setScript: sFollow2
				)
				(self dispose:)
			)
		)
	)
)

(instance markCloseUp of Actor
	(properties
		x 226
		y 155
		priority 196
		fixPriority 1
		view 723
		signal 16385
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON $0020 evKEYBOARD) ; joyUp
			((gCurRoom script:) cue:)
			(event claimed: 1)
			(return)
		)
		(return 0)
	)
)

(instance badder1 of Actor
	(properties
		noun 14
		scaleX 64
		scaleY 64
		priority 152
		fixPriority 1
		view 825
		signal 24577
		scaleSignal 1
		cycleSpeed 1
		moveSpeed 1
	)

	(method (doVerb theVerb)
		(if (IsFlag 368)
			(switch theVerb
				(1 ; Look
					(gMessager say: 14 1 8) ; "The dead bodies of the Badders are flea-bitten and very smelly."
				)
				(4 ; Do
					(gMessager say: 14 4 8) ; "The Badder wasn't carrying any valuables (besides, its body is really gross)."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance badder2 of Actor
	(properties
		noun 14
		scaleX 64
		scaleY 64
		priority 152
		fixPriority 1
		view 825
		signal 24577
		scaleSignal 1
		cycleSpeed 1
		moveSpeed 1
	)

	(method (doVerb theVerb)
		(badder1 doVerb: theVerb &rest)
	)
)

(instance torchEff of Prop
	(properties
		view 775
		signal 16385
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(super doit: &rest)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= z (+ (gEgo z:) 1))
	)
)

(instance exit2 of Prop
	(properties
		noun 7
		x 62
		y 58
		priority 75
		fixPriority 1
		view 721
		loop 2
		cel 1
		signal 16385
		cycleSpeed 30
	)

	(method (init)
		(super init:)
		(if (== local4 3)
			(self setCycle: Fwd)
		)
	)

	(method (handleEvent event)
		(if (== local4 3)
			(= approachX 64)
			(= approachY 79)
		else
			(= approachX 70)
			(= approachY 83)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 3)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exit3 of Prop
	(properties
		noun 8
		x 114
		y 42
		priority 50
		fixPriority 1
		view 721
		loop 4
		signal 16385
		cycleSpeed 30
	)

	(method (init)
		(super init:)
		(if (== local4 4)
			(self setCycle: Fwd)
		)
	)

	(method (handleEvent event)
		(if (== local4 4)
			(= approachX 114)
			(= approachY 54)
		else
			(= approachX 113)
			(= approachY 67)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 4)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exit4 of Prop
	(properties
		noun 6
		x 245
		y 58
		priority 60
		fixPriority 1
		view 721
		loop 6
		cel 1
		signal 16385
		cycleSpeed 30
	)

	(method (init)
		(super init:)
		(if (== local4 5)
			(self setCycle: Fwd)
		)
	)

	(method (handleEvent event)
		(if (== local4 5)
			(= approachX 241)
			(= approachY 73)
		else
			(= approachX 240)
			(= approachY 82)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 5)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exit5 of Prop
	(properties
		noun 5
		x 303
		y 94
		view 721
		loop 8
		signal 16385
	)

	(method (init)
		(super init:)
		(if (== local4 2)
			(self setCycle: Fwd)
		)
	)

	(method (handleEvent event)
		(if (== local4 2)
			(= approachX 306)
			(= approachY 111)
		else
			(= approachX 295)
			(= approachY 126)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 2)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance heart of Prop
	(properties
		noun 2
		approachX 153
		approachY 144
		x 173
		y 61
		priority 152
		fixPriority 1
		view 720
		cel 2
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1 33 74 4) ; Do, Look, theGrapnel, theHeartRit, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(if (and (== local4 6) (IsFlag 462))
					(gCurRoom setScript: toHook)
				else
					(super doVerb: theVerb)
				)
			)
			(74 ; theHeartRit
				(if (== local4 6)
					(gCurRoom setScript: sRitOnHeart)
				else
					(gMessager say: 2 74 5) ; "You sense that it is not yet time to perform the Heart Ritual -- first you must prepare the Dark One with the other Rituals."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aRope of Prop
	(properties
		approachX 157
		approachY 145
		x 145
		y 106
		priority 174
		fixPriority 1
		view 8
		loop 6
		cel 10
		signal 16385
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: climbRope)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance swordNShield of View
	(properties
		noun 11
		approachX 242
		approachY 170
		x 281
		y 153
		view 724
		signal 16384
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: pickUp 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cloth of View
	(properties
		noun 12
		approachX 242
		approachY 170
		x 260
		y 164
		view 724
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: pickUp 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tSign of View
	(properties
		noun 15
		approachX 250
		approachY 174
		x 232
		y 162
		view 723
		loop 1
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(-= nsLeft 5)
		(-= nsTop 3)
		(+= nsRight 5)
		(+= nsBottom 3)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: showSign)
			)
			(4 ; Do
				(gCurRoom setScript: showSign)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bloodExitF of Feature
	(properties
		noun 7
		nsLeft 40
		nsTop 34
		nsRight 84
		nsBottom 80
		approachX 70
		approachY 83
		x 62
		y 57
	)

	(method (handleEvent event)
		(if (== local4 3)
			(= approachX 64)
			(= approachY 79)
		else
			(= approachX 70)
			(= approachY 83)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 3)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance breathExitF of Feature
	(properties
		noun 8
		nsLeft 88
		nsTop 22
		nsRight 136
		nsBottom 64
		approachX 113
		approachY 67
		x 112
		y 43
	)

	(method (handleEvent event)
		(if (== local4 4)
			(= approachX 114)
			(= approachY 54)
		else
			(= approachX 113)
			(= approachY 67)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 4)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance senseExitF of Feature
	(properties
		noun 6
		nsLeft 215
		nsTop 29
		nsRight 266
		nsBottom 79
		approachX 240
		approachY 82
		x 240
		y 54
	)

	(method (handleEvent event)
		(if (== local4 5)
			(= approachX 241)
			(= approachY 73)
		else
			(= approachX 240)
			(= approachY 82)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 5)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boneExitF of Feature
	(properties
		noun 5
		nsLeft 284
		nsTop 71
		nsRight 319
		nsBottom 123
		approachX 295
		approachY 126
		x 301
		y 97
	)

	(method (handleEvent event)
		(if (== local4 2)
			(= approachX 306)
			(= approachY 111)
		else
			(= approachX 295)
			(= approachY 126)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local4 2)
					0
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance altar of Feature
	(properties
		noun 2
		nsLeft 145
		nsTop 46
		nsRight 193
		nsBottom 85
		approachX 153
		approachY 144
		x 169
		y 65
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1 33 74 4) ; Do, Look, theGrapnel, theHeartRit, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (gCast contains: aRope) (== local4 6))
						(aRope doVerb: theVerb)
					)
					((and (== local4 6) (IsFlag 462))
						(gCurRoom setScript: toClimb)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(33 ; theGrapnel
				(if (and (== local4 6) (IsFlag 462))
					(gCurRoom setScript: toHook)
				else
					(super doVerb: theVerb)
				)
			)
			(74 ; theHeartRit
				(if (== local4 6)
					(gCurRoom setScript: sRitOnHeart)
				else
					(gMessager say: 2 74 5) ; "You sense that it is not yet time to perform the Heart Ritual -- first you must prepare the Dark One with the other Rituals."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance altarStem of Feature
	(properties
		noun 3
		nsLeft 134
		nsTop 85
		nsRight 187
		nsBottom 135
		approachX 153
		approachY 144
		x 160
		y 110
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (gCast contains: aRope) (== local4 6))
						(aRope doVerb: theVerb)
					)
					((== local4 720)
						(gCurRoom setScript: toClimb)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance essenceExit of Feature
	(properties
		noun 4
		nsLeft 137
		nsTop 3
		nsRight 196
		nsBottom 35
		approachX 92
		approachY 148
		x 166
		y 19
	)

	(method (init)
		(super init:)
		(self approachVerbs: 33) ; theGrapnel
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 462)
					(gMessager say: 4 1 3) ; "A new exit has appeared in the ceiling above the altar. You sense rather than see a dark "glow" throbbing and pulsating to the rhythm of the stone heart."
				else
					(gMessager say: 4 1 2) ; "There appears to be a sealed passageway in the roof of the cave above the altar."
				)
			)
			(33 ; theGrapnel
				(if (IsFlag 462)
					(gCurRoom setScript: toHook)
				else
					(gMessager say: 4 33 2) ; "You try to catch the stone above the altar with your grapnel, but there's nowhere it can catch... yet."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class CaveExit of Feature
	(properties
		noun 9
		nsLeft 90
		nsTop 173
		nsRight 190
		nsBottom 189
		x 140
		y 182
		alreadyGone 0
	)

	(method (cue)
		(gCurRoom newRoom: 710)
	)

	(method (doit)
		(cond
			(
				(and
					(not (gCurRoom script:))
					(not (IsFlag 368))
					(self onMe: gEgo)
					(not (gCast contains: badder1))
				)
				(gCurRoom setScript: sBadderAttack)
			)
			(
				(and
					(self onMe: gEgo)
					(not (gCurRoom script:))
					(not alreadyGone)
				)
				(= alreadyGone 1)
				(gGlory handsOff:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 50) self
				)
			)
		)
	)
)

(instance hideEndLoop of End
	(properties)

	(method (cycleDone)
		(client hide:)
		(FrameOut)
		(super cycleDone:)
	)
)

