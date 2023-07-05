;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm36 0
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
	local16 = 1
	local17
	local18
)

(procedure (localproc_0)
	(return (if (< local5 160) rock1 else rock2))
)

(procedure (localproc_1)
	(gTheIconBar sel_225: 1 2 3 4 5 6 7)
)

(procedure (localproc_2)
	(if (!= (flyingEgo sel_1:) 160)
		(= local14 (/ (- 160 (flyingEgo sel_1:)) 3))
	else
		(= local14 0)
	)
)

(instance gameIsOver of Code
	(properties
		sel_20 {gameIsOver}
	)

	(method (sel_57)
		(Print 36 0) ; "Game Over"
		(proc0_21)
	)
)

(class Rock of Actor
	(properties
		sel_20 {Rock}
		sel_14 8192
		sel_53 4
		sel_581 0
		sel_582 0
		sel_583 0
		sel_584 0
		sel_585 0
	)

	(method (sel_57)
		(super sel_57:)
		(if (and local3 (not (& sel_14 $4000)))
			(self sel_307: 1)
		)
	)
)

(class SMover of Motion
	(properties
		sel_20 {SMover}
		sel_586 1
		sel_587 10
	)

	(method (sel_110)
		(super sel_110: &rest)
		(motorSound sel_169:)
		(skimmerBanks sel_3: 1 sel_39:)
		(if (sel_42 sel_237:)
			((sel_42 sel_237:) sel_588: (self sel_1:))
		)
	)

	(method (sel_57)
		(super sel_57:)
		(if (== (skimmerBanks sel_166:) -1)
			(skimmerBanks sel_166: 0)
			(motorSound sel_169: 0)
		)
		(if (not (sel_42 sel_58:))
			(if (and sel_49 sel_586 (< (Abs sel_43) sel_587))
				(if (> sel_1 (sel_42 sel_1:))
					(+= sel_43 sel_586)
				else
					(-= sel_43 sel_586)
				)
			)
		else
			(self sel_97:)
			(return)
		)
	)

	(method (sel_97)
		(if (not (OneOf (gEgo sel_3:) 3 4))
			(motorSound sel_39:)
		)
		(skimmerBanks sel_168:)
		(sel_42 sel_56: 0)
		(self sel_111:)
	)
)

(class SCycler of Fwd
	(properties
		sel_20 {SCycler}
		sel_589 1
		sel_588 0
		sel_590 0
	)

	(method (sel_57 &tmp temp0 temp1)
		(cond
			((and (sel_42 sel_56:) ((sel_42 sel_56:) sel_49:))
				(cond
					((or (not (sel_42 sel_3:)) (!= sel_588 sel_590))
						(= sel_590 sel_588)
						(sel_42
							sel_155:
								(if
									(<
										((sel_42 sel_56:) sel_1:)
										(sel_42 sel_1:)
									)
									1
								else
									2
								)
							sel_4: 0
						)
					)
					((!= (sel_42 sel_4:) sel_589)
						(sel_42 sel_4: (self sel_233:))
					)
				)
			)
			(
				(and
					(sel_42 sel_3:)
					(== (sel_42 sel_4:) (= temp1 (sel_42 sel_238:)))
				)
				(sel_42 sel_155: 0 sel_4: 0)
			)
			(else
				(super sel_57:)
			)
		)
	)
)

(class RockCycler of Cycle
	(properties
		sel_20 {RockCycler}
		sel_591 2
		sel_592 6
		sel_240 0
		sel_593 2
		sel_594 55
	)

	(method (sel_110)
		(super sel_110: &rest)
		(sel_42 sel_307: 1)
		(= sel_240 (sel_42 sel_238:))
	)

	(method (sel_57)
		(if (>= (sel_42 sel_0:) sel_594)
			(if (!= (sel_42 sel_4:) sel_240)
				(sel_42 sel_4: (+ (sel_42 sel_4:) 1))
			)
			(if (== sel_593 16)
				(sel_42 sel_307: 0)
			)
			(+= sel_594 sel_593)
			(*= sel_593 2)
		)
	)
)

(instance rm36 of SQRoom
	(properties
		sel_20 {rm36}
		sel_399 36
		sel_28 10
	)

	(method (sel_110)
		(Load rsVIEW 136)
		(LoadMany rsSOUND 437 438 439 440 441 442 443 444 445 446)
		(= local15 gWaitCursor)
		(= local17 ((gTheIconBar sel_64: 0) sel_33:))
		(gMouseDownHandler sel_129: self)
		(super sel_110: &rest)
		(= local13 (gEgo sel_53:))
		(gEgo sel_53: 0)
		((gTheIconBar sel_64: 0) sel_33: skimmerCur)
		(proc0_2)
		(gAddToPics sel_118: mtn1 mtn2 mtn3 sel_119: 110 sel_57:)
		(gEgo
			sel_2: 26
			sel_110:
			sel_155: 0
			sel_4: 0
			sel_1: 160
			sel_0: 225
			sel_51: 3
			sel_52: 3
			sel_15: 16384
			sel_307: 0
			sel_63: 10
			sel_426: 0
			sel_162: SCycler
			sel_317: skimmerBase
			sel_146: egoHandleEvent
		)
		(city sel_110: sel_304:)
		(shadow sel_110: sel_162: Rev)
		(self sel_146: comeOnScreen)
		(= local4 (GetTime 1)) ; SysTime12
		(quitting sel_110:)
	)

	(method (sel_57 &tmp temp0 temp1)
		(super sel_57:)
		(if (and local6 (== (-- local10) 0) (not local3))
			(if (== (city sel_4:) 3)
				(= local9 1)
			else
				(= local10 local11)
				(city sel_4: (+ (city sel_4:) 1) sel_305:)
			)
		)
		(if (and local9 (not (rock1 sel_142:)) (not (rock2 sel_142:)))
			(cond
				(local7
					(Print 36 1) ; "Maybe you could try playing the arcade sequence next time."
				)
				((not local0)
					(Print 36 2) ; "Congratulations, you made it through without a scratch."
					(gameIsOver sel_57:)
				)
				(else
					(if (== local0 1)
						(Print 36 3) ; "That was pretty intense! You managed to hit only 1 rock along the way..."
					else
						(Printf 36 4 local0) ; "That was pretty intense! You managed to hit %d rocks along the way..."
					)
					(gameIsOver sel_57:)
				)
			)
			(gLongSong sel_171:)
		)
		(= temp0 (GetTime 1)) ; SysTime12
		(if
			(and
				(not local3)
				(not (gCurRoom sel_142:))
				(not (gEgo sel_56:))
				(>= (- temp0 local4) 3)
			)
			(= local4 temp0)
			(if (!= (gEgo sel_1:) 160)
				(= temp1 (/ -9000 (- (gEgo sel_1:) 160)))
				(= local5 (+ (/ -13400 temp1) 160))
			else
				(= local5
					(if (> (gEgo sel_1:) 160)
						(rock2 sel_582:)
					else
						(rock1 sel_583:)
					)
				)
			)
		)
	)

	(method (sel_390)
		(= gWaitCursor local15)
		((gTheIconBar sel_64: 0) sel_33: local17)
		(gSounds sel_119: 168)
		(gLongSong2 sel_168:)
		(super sel_390: &rest)
	)

	(method (sel_292)
		(return 0)
	)

	(method (sel_133 param1)
		(if (== (param1 sel_31:) 1)
			(cond
				((quitting sel_209: param1)
					(proc0_21 1)
				)
				((and (User sel_335:) (not sel_142) (== (param1 sel_31:) 1))
					(gEgo
						sel_303: theSMover (param1 sel_1:) (gEgo sel_0:)
					)
				)
			)
			(param1 sel_73: 1)
		else
			(super sel_133: param1)
		)
		(if (== (param1 sel_31:) 4)
			(switch (param1 sel_37:)
				(9
					(proc0_21 1)
					(param1 sel_73: 1)
				)
			)
			(super sel_133: param1)
		)
	)

	(method (sel_111)
		(gTheIconBar sel_214: (gTheIconBar sel_64: 0))
		(if (== (gEgo sel_53:) 0)
			(gEgo sel_53: local13)
		)
		(gMouseDownHandler sel_81: self)
		(gLongSong2 sel_168:)
		(gSounds sel_119: 168)
		(super sel_111:)
	)
)

(instance egoHandleEvent of Script
	(properties
		sel_20 {egoHandleEvent}
	)

	(method (sel_110)
		(super sel_110: &rest)
		(gKeyDownHandler sel_129: self)
	)

	(method (sel_111)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(cond
			((& (param1 sel_31:) $0040)
				(switch (param1 sel_37:)
					(3
						(if
							(or
								(!= (param1 sel_37:) local2)
								(not (gEgo sel_56:))
							)
							(gEgo sel_303: theSMover 400 (gEgo sel_0:))
						else
							(gEgo sel_303: 0)
						)
					)
					(7
						(if
							(or
								(!= (param1 sel_37:) local2)
								(not (gEgo sel_56:))
							)
							(gEgo sel_303: theSMover -400 (gEgo sel_0:))
						else
							(gEgo sel_303: 0)
						)
					)
					(0
						(gEgo sel_303: 0)
					)
				)
				(= local2 (param1 sel_37:))
				(param1 sel_73: 1)
			)
			(
				(and
					(User sel_335:)
					(== (param1 sel_31:) 4)
					(== (param1 sel_37:) 13)
				)
				(gEgo sel_303: theSMover (param1 sel_1:) (gEgo sel_0:))
				(param1 sel_73: 1)
			)
			(else
				(super sel_133: param1)
			)
		)
	)
)

(instance comeOnScreen of Script
	(properties
		sel_20 {comeOnScreen}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(motorSound sel_39: sel_170: 1)
				(gEgo sel_303: MoveTo 160 145 self)
			)
			(1
				(damageGauge sel_110: sel_304:)
				(proc0_3)
				(= gWaitCursor crashedSkimmer)
				(= local6 1)
				(doArcade sel_57:)
				(= sel_136 3)
			)
			(2
				(rock1
					sel_110:
					sel_63: 2
					sel_317: RockBase
					sel_146: (Clone rockAttack)
				)
				(rock2
					sel_110:
					sel_63: 2
					sel_317: RockBase
					sel_146: (Clone rockAttack)
				)
				(= sel_136 2)
			)
			(3
				(proc0_12 local18)
				(restoreCode sel_57:)
				(gLongSong sel_40: 437 sel_3: -1 sel_39:)
				(self sel_111:)
			)
		)
	)
)

(instance rockAttack of Script
	(properties
		sel_20 {rockAttack}
	)

	(method (sel_57)
		(super sel_57:)
		(if
			(and
				(not local3)
				(not local9)
				(sel_42 sel_58:)
				(not (gCurRoom sel_142:))
			)
			(gCurRoom sel_146: hitRock 0 sel_42)
		)
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(switch local16
					(1
						(= temp0 2)
						(= temp1 4)
					)
					(2
						(= temp0 1)
						(= temp1 4)
					)
					(3
						(= temp0 1)
						(= temp1 1)
					)
				)
				(sel_42 sel_102: sel_63: 2 sel_155: (Random temp0 temp1))
				(= sel_136 (Random 3 30))
			)
			(1
				(if (and (not local9) (not local3))
					(sel_42
						sel_207:
						sel_4: 0
						sel_153: (sel_42 sel_581:) 55
						sel_584: (if (== (sel_42 sel_3:) 1) 1 else 0)
						sel_307: 0
						sel_162: RockCycler
						sel_303:
							MoveTo
							(if
								(and
									(not local7)
									local5
									(== sel_42 (localproc_0))
									(not local8)
									(= local8 1)
									(sel_42 sel_585: 1)
								)
								local5
							else
								(Random (sel_42 sel_582:) (sel_42 sel_583:))
							)
							189
							self
					)
				else
					(self sel_111:)
				)
			)
			(2
				(if (sel_42 sel_585:)
					(sel_42 sel_585: 0)
					(= local8 0)
					(= local5 0)
				)
				(self sel_144: 0)
			)
		)
	)
)

(instance tossEgo of Script
	(properties
		sel_20 {tossEgo}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(localproc_2)
				(flyingEgo
					sel_155: 5
					sel_236: 5
					sel_162: Fwd
					sel_330: 5 13
					sel_303: MoveTo (+ (flyingEgo sel_1:) local14) -25 self
				)
			)
			(1
				(= sel_139 50)
			)
			(2
				(flyingEgo
					sel_155: 7
					sel_236: 3
					sel_330: 2 5
					sel_63: -1
					sel_153: (+ (flyingEgo sel_1:) (/ local14 2)) -10
					sel_303: MoveTo (+ (flyingEgo sel_1:) local14) 62 self
				)
			)
			(3
				(flyingEgo sel_155: 8 sel_4: 0 sel_236: 7 sel_162: End self)
			)
			(4
				(= sel_137 3)
			)
			(5
				(gSounds sel_119: 168)
				(if ((sel_42 sel_141:) sel_584:)
					(Print 36 5) ; "Late Warning: The big rock cuts you no slack."
				else
					(Print 36 6) ; "Had you eaten a few less doughnuts during the mission, you might have cleared that rock."
				)
				(= sel_136 1)
			)
			(6
				(gameIsOver sel_57:)
			)
		)
	)
)

(instance hitRock of Script
	(properties
		sel_20 {hitRock}
	)

	(method (sel_57)
		(super sel_57:)
		(if
			(and
				local3
				(OneOf (gEgo sel_4:) 4 6 8 11 14)
				(!= local12 (gEgo sel_4:))
			)
			(if (== (gEgo sel_4:) 4)
				(gLongSong sel_40: 441 sel_3: 1 sel_39:)
			else
				(skimmerCrash
					sel_40:
						(if (== (gEgo sel_4:) 6)
							442
						else
							(+ (skimmerCrash sel_40:) 1)
						)
					sel_3: 1
					sel_39:
				)
			)
		)
		(= local12 (gEgo sel_4:))
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_2)
				(gWaitCursor sel_4: (not (gWaitCursor sel_4:)))
				(sel_141 sel_307: 1)
				(if (sel_141 sel_584:)
					(= local0 4)
				)
				(gLongSong2 sel_40: 438 sel_3: 1 sel_39:)
				(if (<= (++ local0) 4)
					(gEgo
						sel_307: 1
						sel_303: 0
						sel_162: 0
						sel_155: 3
						sel_4: 0
						sel_236: 5
						sel_162: End self
					)
				else
					(= local3 1)
					(gLongSong sel_168:)
					(gLongSong2 sel_168:)
					(motorSound sel_168:)
					(shadow sel_111:)
					(flyingEgo
						sel_110:
						sel_63: (+ (mtn1 sel_60:) 1)
						sel_153: (gEgo sel_1:) (- (gEgo sel_0:) 24)
					)
					(gEgo
						sel_303: 0
						sel_162: 0
						sel_155: 4
						sel_4: 0
						sel_236: 8
						sel_162: End self
						sel_303: MoveTo (gEgo sel_1:) (+ (gEgo sel_0:) 20)
					)
					(self sel_146: tossEgo)
				)
				(damageGauge sel_4: local0 sel_305:)
			)
			(1
				(if (<= local0 4)
					(if (== local0 4)
						(gLongSong2 sel_40: 446 sel_3: 4 sel_39:)
					)
					(gEgo
						sel_307: 0
						sel_155: 0
						sel_4: 0
						sel_236: 5
						sel_162: SCycler
					)
					(proc0_3)
					(localproc_1)
					(self sel_111:)
				else
					(= local0 0)
					(gEgo sel_303: 0)
					(rock1 sel_303: 0 sel_146: 0 sel_162: 0)
					(rock2 sel_303: 0 sel_146: 0 sel_162: 0)
				)
			)
		)
	)
)

(instance theSMover of SMover
	(properties
		sel_20 {theSMover}
	)
)

(instance mtn1 of PicView
	(properties
		sel_20 {mtn1}
		sel_1 38
		sel_0 55
		sel_2 238
		sel_3 1
		sel_4 2
		sel_60 0
		sel_14 16
	)
)

(instance mtn2 of PicView
	(properties
		sel_20 {mtn2}
		sel_1 247
		sel_0 56
		sel_2 238
		sel_60 0
		sel_14 16
	)
)

(instance mtn3 of PicView
	(properties
		sel_20 {mtn3}
		sel_1 282
		sel_0 56
		sel_2 238
		sel_3 3
		sel_4 2
		sel_60 0
		sel_14 16
	)
)

(instance city of View
	(properties
		sel_20 {city}
		sel_1 160
		sel_0 55
		sel_2 136
		sel_3 5
		sel_14 26624
	)
)

(instance damageGauge of View
	(properties
		sel_20 {damageGauge}
		sel_1 293
		sel_0 183
		sel_2 136
		sel_60 15
		sel_14 16400
	)
)

(instance shadow of Prop
	(properties
		sel_20 {shadow}
		sel_2 26
		sel_3 6
		sel_60 1
		sel_14 24592
		sel_236 2
	)

	(method (sel_110)
		(self sel_153: (+ (gEgo sel_1:) 3) (+ (gEgo sel_0:) 3))
		(super sel_110: &rest)
	)

	(method (sel_57)
		(super sel_57:)
		(self sel_1: (+ (gEgo sel_1:) 3) sel_0: (+ (gEgo sel_0:) 3))
	)
)

(instance flyingEgo of Actor
	(properties
		sel_20 {flyingEgo}
		sel_2 26
		sel_3 5
		sel_14 26624
		sel_236 8
		sel_15 0
		sel_53 2
	)
)

(instance rock1 of Rock
	(properties
		sel_20 {rock1}
		sel_52 6
		sel_2 136
		sel_15 0
		sel_51 5
		sel_581 155
		sel_582 4
		sel_583 114
	)
)

(instance rock2 of Rock
	(properties
		sel_20 {rock2}
		sel_52 6
		sel_2 136
		sel_15 0
		sel_51 5
		sel_581 165
		sel_582 211
		sel_583 316
	)
)

(instance skimmerBase of Code
	(properties
		sel_20 {skimmerBase}
	)

	(method (sel_57 param1)
		(param1
			sel_16: (- (param1 sel_0:) 13)
			sel_17: (- (param1 sel_1:) 25)
			sel_19: (+ (param1 sel_1:) 25)
			sel_18: (param1 sel_0:)
		)
	)
)

(instance RockBase of Code
	(properties
		sel_20 {RockBase}
	)

	(method (sel_57 param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 (= temp2 (= temp3 0))))
		(switch (param1 sel_3:)
			(1
				(= temp0 7)
				(= temp1 10)
				(= temp2 10)
			)
			(2
				(= temp0 3)
				(= temp2 8)
			)
			(3
				(= temp0 3)
				(= temp1 7)
				(= temp2 9)
			)
			(4
				(= temp0 3)
				(= temp1 8)
				(= temp2 16)
				(= temp3 1)
			)
		)
		(param1
			sel_16: (- (param1 sel_0:) temp0)
			sel_17: (- (param1 sel_1:) temp1)
			sel_19: (+ (param1 sel_1:) temp2)
			sel_18: (- (param1 sel_0:) temp3)
		)
	)
)

(instance motorSound of Sound
	(properties
		sel_20 {motorSound}
		sel_40 439
		sel_3 -1
	)
)

(instance skimmerCrash of Sound
	(properties
		sel_20 {skimmerCrash}
		sel_40 442
	)
)

(instance skimmerBanks of Sound
	(properties
		sel_20 {skimmerBanks}
		sel_40 440
	)
)

(instance doArcade of Code
	(properties
		sel_20 {doArcade}
	)

	(method (sel_57)
		(= local7 0)
		(= local10 (= local11 750))
		(localproc_1)
		(repeat
			(if
				(!=
					(= local16
						(Print ; "Which level do you wish to play?"
							36
							7
							78
							{Novice}
							1
							78
							{Intermediate}
							2
							78
							{Expert}
							3
						)
					)
					0
				)
				(break)
			)
		)
	)
)

(instance skimmerCur of Cursor
	(properties
		sel_20 {skimmerCur}
		sel_2 942
		sel_3 2
	)
)

(instance crashedSkimmer of Cursor
	(properties
		sel_20 {crashedSkimmer}
		sel_2 942
		sel_3 3
	)
)

(instance restoreCode of Code
	(properties
		sel_20 {restoreCode}
	)

	(method (sel_57 &tmp [temp0 20])
		(proc0_22 175 3 184 34)
		(= local18 (proc0_12 {Quit} 64 7 175 25 global152 26 global129 27 0))
	)
)

(instance quitting of Feature
	(properties
		sel_20 {quitting}
		sel_6 171
		sel_8 189
		sel_9 36
	)
)

