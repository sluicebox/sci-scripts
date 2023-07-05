;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use RandCycle)
(use Path)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	yacht 0
	proc500_2 2
)

(local
	[local0 19] = [40 -2 38 -2 31 -2 28 -2 23 -2 18 -2 22 -2 10 -2 14 -2 -32768]
	[local19 15] = [8 -2 3 -2 4 -2 7 -2 8 -2 4 -2 5 0 -32768]
	[local34 4] = [54 13 60 42]
	[local38 4] = [9 12 13 4]
	[local42 4] = [30 26 25 29]
	[local46 5] = [121 150 180 210 240]
	local51
	[local52 2]
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
)

(procedure (proc500_2 &tmp [temp0 300] [temp300 100])
	(if (or (!= (gSong number:) 804) (== (gSong prevSignal:) -1))
		(gSong play: 804 setLoop: -1)
	)
	(= local60 (gSystemWindow color:))
	(= local61 (gSystemWindow back:))
	(gSystemWindow color: 16 back: 21)
	(StrCpy @temp0 (Format @temp300 599 5)) ; "Yacht Scorecard"
	(StrCat @temp0 (Format @temp300 599 6)) ; "Current Total Score"
	(StrCat @temp0 (Format @temp300 599 7 local64)) ; "Players  Score After %d Game"
	(if (!= local64 1)
		(StrCat @temp0 (Format @temp300 599 8)) ; "s"
	)
	(StrCat @temp0 (Format @temp300 599 9)) ; "-------------------------------"
	(if (yachtPlayer1 type:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				10
				(yachtPlayer1 playerName:)
				(yachtPlayer1 calcTotal:)
				(yachtPlayer1 cumulativeScore:)
			)
		)
	)
	(if (yachtPlayer2 type:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				11
				(yachtPlayer2 playerName:)
				(yachtPlayer2 calcTotal:)
				(yachtPlayer2 cumulativeScore:)
			)
		)
	)
	(if (yachtPlayer3 type:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				12
				(yachtPlayer3 playerName:)
				(yachtPlayer3 calcTotal:)
				(yachtPlayer3 cumulativeScore:)
			)
		)
	)
	(if (yachtPlayer4 type:)
		(StrCat
			@temp0
			(Format ; "%-10s%4d    %4d"
				@temp300
				599
				13
				(yachtPlayer4 playerName:)
				(yachtPlayer4 calcTotal:)
				(yachtPlayer4 cumulativeScore:)
			)
		)
	)
	(StrCat @temp0 (Format @temp300 599 14)) ; "-------------------------------"
	(if local63
		(StrCat @temp0 (Format @temp300 599 15 local62 (local63 playerName:))) ; "High Game: %3d by %-10s"
	)
	(Print @temp0 33 500 70 188 30 0 179 gDoAbsCode 67 50 -1)
	(gSystemWindow color: local60 back: local61)
	(gSong fade:)
)

(class Score of TrackingView
	(properties
		x 37
		view 503
		tempScore 0
		finalScore -1
		retValue 0
		wtfactor 0
		pipNumber 0
		keepers 0
		parent 0
	)

	(method (afterScore)
		(totals finalScore: (global178 calcTotal:))
		(if (!= (global186 type:) 2)
			(proc0_3)
		)
		(totals finalScore: (global178 calcTotal:))
		(global178 turnsLeft: (- (global178 turnsLeft:) 1))
		(scoreNow posn: 500 500 deleteKeyMouse:)
		(totals showScore:)
		(global178 rollsLeft: 0)
		(rollButton setLoop: (if (== (playersList size:) 1) 7 else 6))
		(if
			(and
				(not (global178 turnsLeft:))
				(== global178 (playersList at: (- (playersList size:) 1)))
			)
			(rollButton setLoop: 8)
			(yachtScript state: 7 cue:)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(gSound play: 100 setLoop: 1)
			(if (< (rollButton loop:) 6)
				(if (== global178 global500)
					(cond
						((or local65 (== (global178 rollsLeft:) 3))
							(gSound2 play: 907 setLoop: 1)
							(Characters say: 599 0 -32768 443 -32768)
						)
						((!= ((global178 at: (- loop 1)) finalScore:) -1)
							(gSound2 play: 907 setLoop: 1)
							(Characters say: (Random 9 11) -32768 441 -32768)
						)
						(else
							(= temp0 (global178 rollsLeft:))
							(if (and global519 (!= (global178 rollsLeft:) 2))
								(if (and global533 (!= global533 self))
									(gSound2 play: 907 setLoop: 1)
									(Characters
										say: (Random 6 8) -32768 443 -32768
									)
									(return)
								else
									(= global533 self)
								)
							)
							(if
								(or
									(!= (choiceRect x:) x)
									(!= (choiceRect y:) y)
								)
								(= global533 self)
								(choiceRect posn: x y)
								(return)
							else
								(= global533 0)
								(choiceRect posn: 500 500)
							)
							(self stopUpd:)
							(proc0_1)
							((global178 at: (- loop 1))
								showScore:
									((global178 at: (- loop 1)) tempScore:)
							)
							(DiceList eachElementDo: #deleteKeyMouse)
							(self afterScore:)
							(if
								(and
									(== (global178 type:) 1)
									(== temp0 2)
									(or (== loop 7) (== loop 8) (== loop 10))
									((global178 at: (- loop 1)) tempScore:)
								)
								(gSound2 play: 901 setLoop: 1)
								(Characters say: (Random 33 35) 0 441 -32768)
							)
							(if (not ((global178 at: (- loop 1)) tempScore:))
								(gSound2 play: 905 setLoop: 1)
								(Characters say: (Random 27 29) 0 442 -32768)
							)
						)
					)
				else
					(gSound2 play: 907 setLoop: 1)
					(Characters say: (Random 12 14) -32768 443 -32768)
				)
			else
				(gSound2 play: 907 setLoop: 1)
				(Characters say: (Random 15 17) -32768 443 -32768)
			)
		)
	)

	(method (showScore param1)
		(if argc
			((global500 at: (- loop 1)) finalScore: param1)
			(= global533 0)
		)
		(if (>= ((global500 at: (- loop 1)) finalScore:) 0)
			(Format @global550 599 1 ((global500 at: (- loop 1)) finalScore:)) ; "%3d"
			(self doDisplay:)
		)
	)

	(method (doDisplay)
		(Display
			@global550
			dsFONT
			500
			dsCOORD
			81
			(- y 8)
			dsBACKGROUND
			(global500 color:)
			dsCOLOR
			global375
		)
		(Display @global550 dsFONT 500 dsCOORD 82 (- y 8) dsBACKGROUND global376 dsCOLOR global377)
	)

	(method (init)
		(self setLoop: loop cel: 0 setPri: 7 posn: x y ignoreActors:)
		(super init: &rest)
	)

	(method (calc))

	(method (eval))

	(method (determineKeepers &tmp temp0)
		(cond
			((== (global178 rollsLeft:) 0)
				((DiceList at: 0) keep: 1)
				((DiceList at: 1) keep: 1)
				((DiceList at: 2) keep: 1)
				((DiceList at: 3) keep: 1)
				((DiceList at: 4) keep: 1)
			)
			(pipNumber
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(if (== ((DiceList at: temp0) pipValue:) pipNumber)
						((DiceList at: temp0) keep: 1)
					else
						((DiceList at: temp0) keep: 0)
					)
				)
			)
			(else
				((DiceList at: 0) keep: (& keepers $0001))
				((DiceList at: 1) keep: (& keepers $0002))
				((DiceList at: 2) keep: (& keepers $0004))
				((DiceList at: 3) keep: (& keepers $0008))
				((DiceList at: 4) keep: (& keepers $0010))
			)
		)
	)

	(method (setKeepers param1 &tmp temp0)
		(for ((= temp0 (= keepers 0))) (< temp0 argc) ((++ temp0))
			(switch [param1 temp0]
				(-1 0)
				(0
					(|= keepers $0001)
				)
				(1
					(|= keepers $0002)
				)
				(2
					(|= keepers $0004)
				)
				(3
					(|= keepers $0008)
				)
				(4
					(|= keepers $0010)
				)
			)
		)
	)
)

(class Roll1a of RelPath
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(class Roll1b of RelPath
	(properties)

	(method (at param1)
		(return [local19 param1])
	)
)

(class YachtDice of DragableActor
	(properties
		view 500
		pipValue 0
		keep 0
		startTop 0
		startLeft 0
		startBottom 0
		startRight 0
		rolling 0
		firstPath 0
		secondPath 0
		nextView 0
		nextLoop 0
		origX 0
		origY 0
	)

	(method (throw)
		(if (not keep)
			(= pipValue (Random 1 6))
			(self choosePath: rolling: 1)
			(if (!= gHowFast 0)
				(self
					posn:
						(- 0 (Random startLeft startRight))
						(Random startTop startBottom)
					ignoreActors:
					ignoreControl:
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 50 50
					setCycle: End
					setMotion: firstPath self
					setPri: 10
					init:
				)
			else
				(self
					view: nextView
					setLoop: nextLoop
					posn:
						(= origX (+ (- 0 (Random startLeft startRight)) 270))
						(= origY (- (Random startTop startBottom) 30))
					show:
					init:
					cel: 6
				)
				(if (== global507 global509)
					(diceThrowScript cue:)
				)
			)
		)
	)

	(method (pickup)
		(if (not keep)
			(self view: 500 posn: 400 400)
		)
	)

	(method (reset)
		(= keep 0)
	)

	(method (cue)
		(switch (++ rolling)
			(2
				(self
					cel: 0
					setLoop: nextLoop
					view: nextView
					setCycle: End
					setMotion: secondPath self
				)
			)
			(3
				(self setCycle: 0 origX: x origY: y)
				(if (== global508 self)
					(diceThrowScript cue:)
				)
			)
		)
	)

	(method (choosePath)
		(switch (Random 0 3)
			(0
				(= firstPath Roll1a)
				(= secondPath Roll1b)
				(= nextView 501)
				(= nextLoop (- (* pipValue 2) 2))
				(self setLoop: 0 cel: 0)
				(= hiView 501)
				(= hiLoop 12)
				(= hiCel (- pipValue 1))
			)
			(1
				(= firstPath Roll1a)
				(= secondPath Roll1b)
				(= nextView 501)
				(= nextLoop (- (* pipValue 2) 1))
				(self setLoop: 1 cel: 0)
				(= hiView 501)
				(= hiLoop 13)
				(= hiCel (- pipValue 1))
			)
			(2
				(= firstPath Roll1a)
				(= secondPath Roll1b)
				(= nextView 501)
				(= nextLoop (- (* pipValue 2) 2))
				(self setLoop: 0 cel: 0)
				(= hiView 501)
				(= hiLoop 12)
				(= hiCel (- pipValue 1))
			)
			(3
				(= firstPath Roll1a)
				(= secondPath Roll1b)
				(= nextView 501)
				(= nextLoop (- (* pipValue 2) 1))
				(self setLoop: 1 cel: 0)
				(= hiView 501)
				(= hiLoop 13)
				(= hiCel (- pipValue 1))
			)
		)
	)
)

(class DiceList of List
	(properties
		total 0
	)

	(method (reSort)
		(self release: add: die1 die2 die3 die4 die5)
	)

	(method (getPipValues)
		(= global501 ((self at: 0) pipValue:))
		(= global502 ((self at: 1) pipValue:))
		(= global503 ((self at: 2) pipValue:))
		(= global504 ((self at: 3) pipValue:))
		(= global505 ((self at: 4) pipValue:))
	)

	(method (sort &tmp temp0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(cond
				(
					(>
						((self at: temp0) pipValue:)
						((self at: (+ temp0 1)) pipValue:)
					)
					(self addAfter: (self at: (+ temp0 1)) (self at: temp0))
					(self delete: (self at: temp0))
					(= temp0 -1)
				)
				(
					(and
						(==
							((self at: temp0) pipValue:)
							((self at: (+ temp0 1)) pipValue:)
						)
						(Keepers size:)
						(not (Keepers contains: (self at: temp0)))
					)
					(self addAfter: (self at: (+ temp0 1)) (self at: temp0))
					(self delete: (self at: temp0))
				)
			)
		)
		(= global511 (self whichHas: 1))
		(= global512 (self whichHas: 2))
		(= global513 (self whichHas: 3))
		(= global514 (self whichHas: 4))
		(= global515 (self whichHas: 5))
		(= global516 (self whichHas: 6))
	)

	(method (scoreTheUpperNum param1 param2 &tmp temp0)
		(= param1 0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (== ((self at: temp0) pipValue:) param2)
				(+= param1 param2)
			)
		)
		(return param1)
	)

	(method (diceTotal)
		(return (+ global501 global502 global503 global504 global505))
	)

	(method (whichHas param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (== ((self at: temp0) pipValue:) param1)
				(return temp0)
			)
		)
		(return -1)
	)
)

(class Keepers of Set
	(properties
		nsTop 170
		nsLeft 50
		nsBottom 199
		nsRight 300
		keepersY 190
	)

	(method (remove param1 param2 &tmp temp0)
		(= temp0 (if (>= argc 2) param2 else handsOnObj))
		(if (and size (self contains: param1))
			(self delete: param1)
		)
		(proc0_4)
		(= global518 param1)
		(param1
			setMotion: MoveTo (param1 origX:) (param1 origY:) temp0
			setStep: 35 35
			setPri: 14
		)
	)

	(method (add param1 param2 &tmp [temp0 2] temp2 temp3)
		(if argc
			(= temp3 (if (>= argc 2) param2 else handsOnObj))
			(= temp2 (self nextSpace:))
			(proc0_4)
			(= global518 param1)
			(param1
				setMotion: MoveTo temp2 keepersY temp3
				setStep: 35 35
				setPri: 14
			)
			(super add: param1)
		else
			(super add:)
		)
	)

	(method (nextSpace param1 &tmp temp0 temp1)
		(= temp1 (if (not size) [local46 0] else 0))
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if
				(and
					(or (not argc) (!= param1 [local46 temp0]))
					(self spaceOpen: [local46 temp0])
				)
				(= temp1 [local46 temp0])
				(break)
			)
		)
		(return temp1)
	)

	(method (spaceOpen param1 &tmp temp0)
		(if size
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if (== ((self at: temp0) x:) param1)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)
)

(class YachtPlayer of List
	(properties
		type 1
		turnsLeft 12
		rollsLeft 3
		color 0
		skill 0
		playerName 0
		usingCharacter 0
		cumulativeScore 0
	)

	(method (say)
		(if usingCharacter
			(usingCharacter say: &rest)
		)
	)

	(method (reset)
		(= turnsLeft 12)
		(= rollsLeft 3)
		(self eachElementDo: #finalScore -1)
	)

	(method (calcTotal &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(if (> ((self at: temp1) finalScore:) 0)
				(+= temp0 ((self at: temp1) finalScore:))
			)
		)
		(return temp0)
	)

	(method (decRoll)
		(-- rollsLeft)
		(rollsLeftView cel: rollsLeft forceUpd:)
	)

	(method (init)
		(self
			add:
				((gOnesScore new:) parent: gOnesScore yourself:)
				((gTwosScore new:) parent: gTwosScore yourself:)
				((gThreesScore new:) parent: gThreesScore yourself:)
				((gFoursScore new:) parent: gFoursScore yourself:)
				((gFivesScore new:) parent: gFivesScore yourself:)
				((gSixesScore new:) parent: gSixesScore yourself:)
				((gFourOfAKindScore new:) parent: gFourOfAKindScore yourself:)
				((gFullHouseScore new:) parent: gFullHouseScore yourself:)
				((gSmStraightScore new:) parent: gSmStraightScore yourself:)
				((gLgStraightScore new:) parent: gLgStraightScore yourself:)
				((gYahtzeeScore new:) parent: gYahtzeeScore yourself:)
				((gChanceScore new:) parent: gChanceScore yourself:)
		)
	)

	(method (think)
		(switch (global178 type:)
			(1
				(if global180
					(self decide:)
					(self showHint:)
				)
			)
			(2
				(self decide:)
				(self moveDice:)
			)
		)
	)

	(method (decide &tmp temp0 temp1)
		(global178 eachElementDo: #calc)
		(global178 eachElementDo: #eval)
		(if (or (not global519) (and global519 (== (global178 rollsLeft:) 2)))
			(= global534 0)
			(= temp1 -1)
			(for ((= temp0 0)) (<= temp0 11) ((++ temp0))
				(if
					(and
						(> ((global178 at: temp0) wtfactor:) temp1)
						(== ((global178 at: temp0) finalScore:) -1)
					)
					(= temp1 ((global178 at: temp0) wtfactor:))
					(= global534 (global178 at: temp0))
					(= global520 ((global178 at: temp0) parent:))
				)
			)
		)
		(global534 determineKeepers:)
		(return global534)
	)

	(method (showHint))

	(method (moveDice))

	(method (lateInGame &tmp temp0)
		(= temp0 turnsLeft)
		(if (> ((self at: 11) finalScore:) -1)
			(-- temp0)
		)
		(if (> ((self at: 10) finalScore:) -1)
			(-- temp0)
		)
		(return (< temp0 5))
	)

	(method (handleEvent event &tmp temp0 [temp1 2] temp3)
		(if
			(and
				(< (rollButton loop:) 6)
				(= temp0 (DiceList firstTrue: #handleEvent event))
			)
			(switch (temp0 processEvent: event)
				(1
					(if global181
						(= temp3 (Event new:))
						(if (Keepers contains: global181)
							(proc0_4)
							(Keepers delete: global181)
							(global181 dim:)
							(= global518 global181)
							(global181
								setMotion:
									MoveTo
									(global181 origX:)
									(global181 origY:)
									handsOnObj
							)
							(gSound play: 302)
						else
							(Keepers delete: global181 add: global181)
							(global181 dim:)
							(gSound play: 302)
						)
						(temp3 dispose:)
						(= global181 0)
					)
				)
				(2
					(if global181
						(= temp3 (Event new:))
						(if (Keepers contains: global181)
							(proc0_4)
							(Keepers delete: global181)
							(global181 dim:)
							(= global518 global181)
							(global181
								setMotion:
									MoveTo
									(global181 origX:)
									(global181 origY:)
									handsOnObj
							)
							(gSound play: 302)
						else
							(Keepers delete: global181 add: global181)
							(global181 dim: startUpd:)
							(gSound play: 302)
						)
						(temp3 dispose:)
						(= global181 0)
					)
				)
			)
		)
	)
)

(instance yacht of Rm
	(properties
		picture 500
		style 10
	)

	(method (init &tmp temp0 temp1 temp2)
		(= global510 0)
		(if (gChar1 active:)
			(gChar1 posn: 286 33 show: init:)
			(Load rsTEXT (+ (* (+ (gChar1 view:) 1) 1000) global187))
		)
		(if (gChar2 active:)
			(gChar2 posn: 286 99 show: init:)
			(Load rsTEXT (+ (* (+ (gChar2 view:) 1) 1000) global187))
		)
		(if (gChar3 active:)
			(gChar3 posn: 286 165 show: init:)
			(Load rsTEXT (+ (* (+ (gChar3 view:) 1) 1000) global187))
		)
		(Load rsTEXT 19500)
		(Characters init:)
		(super init:)
		(gSong fade:)
		(Load rsVIEW 500)
		(Load rsVIEW 501)
		(Load rsVIEW 503)
		(Load rsVIEW 504)
		(Load rsVIEW 510)
		(Load rsFONT 500)
		(Load rsSOUND 500)
		(Load rsSOUND 501)
		(Load rsSOUND 502)
		(Load rsSOUND 503)
		(Load rsSOUND 504)
		(Load rsSOUND 505)
		(Load rsSOUND 907)
		(Load rsSOUND 100)
		(Load rsSOUND 901)
		(ScriptID 501) ; onesScore
		(ScriptID 510) ; theyaCode
		Path
		RandCycle
		(Load rsTEXT 599)
		(Load rsFONT 999)
		(User canControl: 1)
		((= gYacht_opt yacht_opt) doit:)
		(= gOnesScore (ScriptID 501 0)) ; onesScore
		(= gTwosScore (ScriptID 501 1)) ; twosScore
		(= gThreesScore (ScriptID 501 2)) ; threesScore
		(= gFoursScore (ScriptID 501 3)) ; foursScore
		(= gFivesScore (ScriptID 501 4)) ; fivesScore
		(= gSixesScore (ScriptID 501 5)) ; sixesScore
		(= gFourOfAKindScore (ScriptID 501 6)) ; fourOfAKindScore
		(= gFullHouseScore (ScriptID 501 7)) ; fullHouseScore
		(= gSmStraightScore (ScriptID 501 8)) ; smStraightScore
		(= gLgStraightScore (ScriptID 501 9)) ; lgStraightScore
		(= gYahtzeeScore (ScriptID 501 10)) ; yahtzeeScore
		(= gChanceScore (ScriptID 501 11)) ; chanceScore
		(yachtPlayer1
			add:
			skill: global190
			type: global194
			playerName: @global150
		)
		(yachtPlayer2
			add:
			skill: global191
			type: global195
			playerName: @global157
		)
		(yachtPlayer3
			add:
			skill: global192
			type: global196
			playerName: @global164
		)
		(yachtPlayer4
			add:
			skill: global193
			type: global197
			playerName: @global171
		)
		(Keepers add:)
		(DiceList add:)
		(playersList add:)
		(= temp0 -1)
		(if (yachtPlayer1 type:)
			(++ temp0)
			(yachtPlayer1
				color:
					(cond
						(global294 [local38 temp0])
						(global547 [local42 temp0])
						(else [local34 temp0])
					)
				init:
			)
		)
		(if (yachtPlayer2 type:)
			(++ temp0)
			(yachtPlayer2
				color:
					(cond
						(global294 [local38 temp0])
						(global547 [local42 temp0])
						(else [local34 temp0])
					)
				init:
			)
		)
		(if (yachtPlayer3 type:)
			(++ temp0)
			(yachtPlayer3
				color:
					(cond
						(global294 [local38 temp0])
						(global547 [local42 temp0])
						(else [local34 temp0])
					)
				init:
			)
		)
		(if (yachtPlayer4 type:)
			(++ temp0)
			(yachtPlayer4
				color:
					(cond
						(global294 [local38 temp0])
						(global547 [local42 temp0])
						(else [local34 temp0])
					)
				init:
			)
		)
		(scoreNow x: 500)
		(bigArrow addKeyMouse: init: stopUpd:)
		(gOnesScore addKeyMouse: init: stopUpd:)
		(gTwosScore addKeyMouse: init: stopUpd:)
		(gThreesScore addKeyMouse: init: stopUpd:)
		(gFoursScore addKeyMouse: init: stopUpd:)
		(gFivesScore addKeyMouse: init: stopUpd:)
		(gSixesScore addKeyMouse: init: stopUpd:)
		(gFourOfAKindScore addKeyMouse: init: stopUpd:)
		(gFullHouseScore addKeyMouse: init: stopUpd:)
		(gSmStraightScore addKeyMouse: init: stopUpd:)
		(gLgStraightScore addKeyMouse: init: stopUpd:)
		(gYahtzeeScore addKeyMouse: init: stopUpd:)
		(gChanceScore addKeyMouse: init: stopUpd:)
		(playerNumber init:)
		(rollsLeftView cel: 3 setLoop: 5 init: stopUpd:)
		(totals init: stopUpd:)
		(rollButton init: addKeyMouse:)
		(playersList init:)
		(= local62 (= local64 0))
		(= local63 0)
		(for ((= temp2 0)) (< temp2 (playersList size:)) ((++ temp2))
			(if (== ((= temp1 (playersList at: temp2)) type:) 2)
				(switch temp2
					(0
						(frame1
							setPri: 14
							posn:
								((temp1 usingCharacter:) x:)
								((temp1 usingCharacter:) y:)
							addToPic:
						)
					)
					(1
						(frame2
							setPri: 14
							posn:
								((temp1 usingCharacter:) x:)
								((temp1 usingCharacter:) y:)
							addToPic:
						)
					)
					(2
						(frame3
							setPri: 14
							posn:
								((temp1 usingCharacter:) x:)
								((temp1 usingCharacter:) y:)
							addToPic:
						)
					)
					(3
						(frame4
							setPri: 14
							posn:
								((temp1 usingCharacter:) x:)
								((temp1 usingCharacter:) y:)
							addToPic:
						)
					)
				)
			)
		)
		(playerNumber cue: 0)
		(self setScript: yachtScript)
		(choiceRect
			posn: (choiceRect x:) (choiceRect y:)
			setPri: (choiceRect priority:)
			ignoreActors:
			init:
		)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (event claimed:))
			(bigArrow handleEvent: event)
			(if (!= (scoreNow x:) 500)
				(scoreNow handleEvent: event)
			else
				(rollButton handleEvent: event)
			)
			(gOnesScore handleEvent: event)
			(gTwosScore handleEvent: event)
			(gThreesScore handleEvent: event)
			(gFoursScore handleEvent: event)
			(gFivesScore handleEvent: event)
			(gSixesScore handleEvent: event)
			(gFourOfAKindScore handleEvent: event)
			(gFullHouseScore handleEvent: event)
			(gSmStraightScore handleEvent: event)
			(gLgStraightScore handleEvent: event)
			(gYahtzeeScore handleEvent: event)
			(gChanceScore handleEvent: event)
			(if (and (event claimed:) global181)
				(global181 dim:)
				(= global181 0)
			)
			(global178 handleEvent: event)
			(event claimed: 1)
		)
	)

	(method (doit)
		(super doit: &rest)
		(Random 1 6)
		(if global536
			(if (== (++ local54) 150)
				(= local54 0)
				(Palette palANIMATE 64 66 1)
			)
			(if (== (++ local55) 350)
				(= local55 0)
				(Palette palANIMATE 66 69 1)
			)
			(if (== (++ local56) 650)
				(= local56 0)
				(Palette palANIMATE 69 72 1)
			)
			(if (== (++ local57) 350)
				(= local57 0)
				(Palette palANIMATE 72 74 1)
			)
			(if (== (++ local58) 250)
				(= local58 0)
				(Palette palANIMATE 77 80 1)
			)
			(if (== (++ local59) 250)
				(= local59 0)
				(Palette palANIMATE 75 77 1)
			)
		)
	)

	(method (dispose &tmp temp0 temp1)
		(KeyMouse release:)
		(Keepers release:)
		(DiceList release:)
		(playersList release:)
		(for ((= temp0 11)) (>= temp0 0) ((-- temp0))
			(if (yachtPlayer1 size:)
				(= temp1 (yachtPlayer1 at: temp0))
				(yachtPlayer1 delete: temp1)
				(temp1 dispose: delete:)
			)
			(if (yachtPlayer2 size:)
				(= temp1 (yachtPlayer2 at: temp0))
				(yachtPlayer2 delete: temp1)
				(temp1 dispose: delete:)
			)
			(if (yachtPlayer3 size:)
				(= temp1 (yachtPlayer3 at: temp0))
				(yachtPlayer3 delete: temp1)
				(temp1 dispose: delete:)
			)
			(if (yachtPlayer4 size:)
				(= temp1 (yachtPlayer4 at: temp0))
				(yachtPlayer4 delete: temp1)
				(temp1 dispose: delete:)
			)
		)
		(yachtPlayer1 dispose:)
		(yachtPlayer2 dispose:)
		(yachtPlayer3 dispose:)
		(yachtPlayer4 dispose:)
		(frame1 dispose:)
		(frame2 dispose:)
		(frame3 dispose:)
		(frame4 dispose:)
		(Keepers dispose:)
		(DiceList dispose:)
		(playersList dispose:)
		(DisposeScript 501)
		(DisposeScript 983)
		(DisposeScript 510)
		(DisposeScript 9)
		(DisposeScript 941)
		(super dispose: &rest)
	)
)

(instance yachtPlayer1 of YachtPlayer
	(properties)
)

(instance yachtPlayer2 of YachtPlayer
	(properties)
)

(instance yachtPlayer3 of YachtPlayer
	(properties)
)

(instance yachtPlayer4 of YachtPlayer
	(properties)
)

(instance die1 of YachtDice
	(properties
		startTop 150
		startLeft 30
		startBottom 170
		startRight 50
	)
)

(instance die2 of YachtDice
	(properties
		startTop 65
		startLeft 40
		startBottom 80
		startRight 60
	)
)

(instance die3 of YachtDice
	(properties
		startTop 110
		startLeft 70
		startBottom 130
		startRight 90
	)
)

(instance die4 of YachtDice
	(properties
		startTop 70
		startLeft 90
		startBottom 90
		startRight 110
	)
)

(instance die5 of YachtDice
	(properties
		startTop 140
		startLeft 120
		startBottom 160
		startRight 140
	)
)

(instance yachtScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 [temp2 100] temp102 temp103 temp104 temp105)
		(switch (= state newState)
			(0
				(= global145 global178)
				(playersList doit: 1)
				(= global186 global178)
				(= global178 global145)
				(DiceList add: die1 die2 die3 die4 die5)
				(if (== (global178 type:) 2)
					(= cycles 1)
				)
				(rollsLeftView cel: 3 forceUpd:)
			)
			(1
				(rollsLeftView cel: 3 forceUpd:)
				(if (== (global178 type:) 2)
					(proc0_4)
				)
				(DiceList eachElementDo: #reset)
				(global178 rollsLeft: 3)
				(Keepers release:)
				(DiceList eachElementDo: #deleteKeyMouse)
				(= global509 5)
				(if (== (global178 type:) 2)
					(= cycles 30)
				else
					(= cycles 1)
				)
			)
			(2
				(if (== (global178 type:) 2)
					(rollButton flash:)
				)
				(DiceList eachElementDo: #pickup)
				(= cycles 1)
			)
			(3
				(cond
					((== global509 5)
						(gSound play: 500)
					)
					((== global509 4)
						(gSound play: 500)
					)
					((== global509 3)
						(gSound play: 501)
					)
					((== global509 2)
						(gSound play: 501)
					)
					((== global509 1)
						(gSound play: 502)
					)
				)
				(= ticks 60)
			)
			(4
				(global178 decRoll:)
				(gSound flags: 0)
				(cond
					((== global509 5)
						(gSound play: 503)
					)
					((== global509 4)
						(gSound play: 503)
					)
					((== global509 3)
						(gSound play: 504)
					)
					((== global509 2)
						(gSound play: 504)
					)
					((== global509 1)
						(gSound play: 505)
					)
				)
				(self setScript: diceThrowScript)
			)
			(5
				(gSound stop:)
				(DiceList getPipValues:)
				(DiceList sort: getPipValues:)
				(global178 decide:)
				(if (== (global178 type:) 2)
					(if (and global519 (== (global178 rollsLeft:) 2))
						(if (== (global178 type:) 2)
							(= temp104 (* (- (global534 loop:) 1) 3))
							(gSound2 play: 100 setLoop: 1)
							(if (or global519 (!= temp104 10))
								(global178
									say: (Random (+ 36 temp104) (+ 38 temp104))
								)
							)
						)
						(choiceRect posn: (global520 x:) (global520 y:))
						(= global533 global520)
					)
					(if (and (not global519) (== (global178 rollsLeft:) 0))
						(choiceRect posn: (global520 x:) (global520 y:))
					)
					(self setScript: playScript)
				)
			)
			(6
				(= global509 5)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(if (>= ((DiceList at: temp0) y:) 170)
						((DiceList at: temp0) keep: 1)
						(-- global509)
					else
						((DiceList at: temp0) keep: 0)
					)
				)
				(if (and (global178 rollsLeft:) global509)
					(= state 1)
				)
				(= cycles 1)
			)
			(7
				(= cycles 1)
				(if (== (global178 type:) 2)
					(Wait 1)
					(Wait 15)
					(proc0_6)
					(Wait 15)
					(proc0_6)
					(Wait 15)
					(proc0_6)
					(Wait 15)
					(proc0_6)
				)
				(playersList doit:)
				(= global145 global178)
				(playersList doit: 1)
				(= global186 global178)
				(= global178 global145)
				(global178 eachElementDo: #wtfactor 0)
				(if (global178 turnsLeft:)
					(= state 0)
				)
			)
			(8
				(for ((= temp0 0)) (< temp0 (playersList size:)) ((++ temp0))
					((playersList at: temp0)
						cumulativeScore:
							(+
								((playersList at: temp0) cumulativeScore:)
								(= temp105 ((playersList at: temp0) calcTotal:))
							)
					)
					(if (> temp105 local62)
						(= local62 temp105)
						(= local63 (playersList at: temp0))
					)
				)
				(++ local64)
				(= cycles 20)
			)
			(9
				(= temp102 0)
				(= temp1 (playersList at: 0))
				(= temp103 ((playersList at: 0) calcTotal:))
				(if (> (playersList size:) 1)
					(for
						((= temp0 1))
						(< temp0 (playersList size:))
						((++ temp0))
						
						(cond
							(
								(>
									((playersList at: temp0) calcTotal:)
									(temp1 calcTotal:)
								)
								(= temp102 0)
								(= temp1 (playersList at: temp0))
								(= temp103 (temp1 calcTotal:))
							)
							(
								(==
									((playersList at: temp0) calcTotal:)
									(temp1 calcTotal:)
								)
								(= temp102 temp103)
							)
						)
					)
					(gSong play: 906 setLoop: 1)
					(cond
						(temp102
							(gSong play: 804 setLoop: -1)
							(Characters say: (Random 30 32))
						)
						((== (temp1 type:) 2)
							(gSong play: 804 setLoop: -1)
							(temp1 say: (Random 81 83) 0 441 -32768)
						)
						(else
							(gSong play: 906 setLoop: -1)
							(Characters
								say:
									(Format @global550 599 2 (temp1 playerName:)) ; "Congratulations %s, You Won!"
							)
						)
					)
					(proc0_1)
					(proc500_2)
					(gSong fade:)
				)
			)
			(10
				(choiceRect posn: 500 500)
				(playersList doit:)
				(= global145 global178)
				(playersList doit: 1)
				(= global186 global178)
				(= global178 global145)
				(global178 eachElementDo: #wtfactor 0)
				(playersList eachElementDo: #reset)
				(Format @global550 599 3)
				(global178 eachElementDo: #doDisplay)
				(totals finalScore: 0 showScore:)
				(rollsLeftView cel: 3 forceUpd:)
				(global178 rollsLeft: 0)
				(= local65 1)
				(if (== (global178 type:) 2)
					(rollButton setLoop: 4)
					(= state 0)
					(= cycles 1)
				)
			)
			(11
				(= state 0)
				(= cycles 1)
			)
		)
	)
)

(instance playScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global517 0)
				(= cycles 1)
			)
			(1
				(if global517
					((DiceList at: (- global517 1)) setPri: 10)
				)
				(cond
					(((DiceList at: global517) keep:)
						(if (not (Keepers contains: (DiceList at: global517)))
							(= local51 1)
							(Keepers add: (DiceList at: global517) self)
							(gSound play: 302)
						else
							(= local51 0)
							(= cycles 1)
						)
					)
					((Keepers contains: (DiceList at: global517))
						(= local51 1)
						(Keepers remove: (DiceList at: global517) self)
						(gSound play: 302)
					)
					(else
						(= local51 0)
						(= cycles 1)
					)
				)
			)
			(2
				(Keepers eachElementDo: #stopUpd)
				(if (!= (++ global517) 5)
					(-= state 2)
				)
				(= cycles (+ (* local51 10) 1))
			)
			(3
				((DiceList at: (- global517 1)) setPri: 10)
				(= cycles 1)
			)
			(4
				(if (or (== (global178 rollsLeft:) 0) (== (Keepers size:) 5))
					(cond
						((== (global534 tempScore:) 0)
							(gSound2 play: 907 setLoop: 1)
							(global178 say: (Random 24 26) 0 443 -32768)
						)
						((and (not global519) (== (global178 type:) 2))
							(= temp0 (* (- (global534 loop:) 1) 3))
							(gSound2 play: 100 setLoop: 1)
							(global178 say: (Random (+ 36 temp0) (+ 38 temp0)))
						)
					)
					(global534 showScore: (global534 tempScore:) afterScore:)
					(DiceList eachElementDo: #deleteKeyMouse)
					(if (and (== (global178 type:) 2) (== (global186 type:) 2))
						(proc0_4)
						(= cycles 30)
						(return)
					)
				else
					(client cue:)
				)
				(client setScript: 0)
			)
			(5
				(if (or (== (rollButton loop:) 6) (== (rollButton loop:) 7))
					(rollButton setLoop: 4)
					(choiceRect posn: 500 500)
				)
				(= global510 1)
				(proc0_4)
				(client cue: setScript: 0)
			)
		)
	)
)

(instance diceThrowScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local65 0)
				(if (not (Keepers contains: die1))
					(die1 startUpd:)
				)
				(if (not (Keepers contains: die2))
					(die2 startUpd:)
				)
				(if (not (Keepers contains: die3))
					(die3 startUpd:)
				)
				(if (not (Keepers contains: die4))
					(die4 startUpd:)
				)
				(if (not (Keepers contains: die5))
					(die5 startUpd:)
				)
				(DiceList reSort:)
				(= global507 0)
				(= global508 0)
				(= cycles 1)
			)
			(1
				(for
					((= temp0 0))
					(or
						((DiceList at: temp0) rolling:)
						((DiceList at: temp0) keep:)
					)
					((++ temp0))
				)
				(++ global507)
				((DiceList at: temp0) throw:)
				(if (== global507 global509)
					(= global508 (DiceList at: temp0))
				)
				(= cycles (Random 1 3))
			)
			(2
				(if (!= global507 global509)
					(-= state 2)
					(= cycles 1)
				)
			)
			(3
				(client setScript: 0 cycles: 1)
				(DiceList eachElementDo: #rolling 0)
				(= global510 0)
				(die1 addKeyMouse: stopUpd:)
				(die2 addKeyMouse: stopUpd:)
				(die3 addKeyMouse: stopUpd:)
				(die4 addKeyMouse: stopUpd:)
				(die5 addKeyMouse: stopUpd:)
				(if (== (global178 rollsLeft:) 0)
					(scoreNow init:)
				)
				(if (!= (global178 type:) 2)
					(proc0_3)
				)
				(if
					(==
						(die1 pipValue:)
						(die2 pipValue:)
						(die3 pipValue:)
						(die4 pipValue:)
						(die5 pipValue:)
					)
					(DiceList eachElementDo: #stopUpd)
					(proc0_1)
					(if
						(and
							(or
								(not global519)
								(and
									(IsObject global533)
									(== (global533 parent:) gYahtzeeScore)
								)
							)
							(== ((global178 at: 10) finalScore:) -1)
						)
						(gSound play: 906 setLoop: 1)
						(if (== (global178 type:) 2)
							(global178 say: (Random 75 77) 0 442 -32768)
						else
							(Characters say: (Random 72 74) 0 443 -32768)
						)
					)
				)
				(gSound flags: 1)
			)
		)
	)
)

(instance handsOnObj of Prop
	(properties)

	(method (cue)
		(if (!= (global178 type:) 2)
			(proc0_3)
		)
		(global518 setPri: 10 stopUpd:)
	)
)

(instance rollButton of TrackingView
	(properties)

	(method (init)
		(self
			view: 504
			ignoreActors:
			setLoop: 4
			cel: 0
			posn: 31 199
			setPri: 13
			show:
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (not global510) (super handleEvent: event))
			(gSound2 play: 100 setLoop: 1)
			(if (== (yachtScript state:) 8)
				(return)
			)
			(event claimed: 1)
			(if
				(and
					(== loop 4)
					(not (global178 rollsLeft:))
					(< (yachtScript state:) 9)
				)
				(gSound2 play: 907 setLoop: 1)
				(Characters say: (Random 18 20) -32768)
				(return)
			)
			(if
				(and
					(== loop 4)
					(== (Keepers size:) 5)
					(< (yachtScript state:) 9)
				)
				(gSound2 play: 907 setLoop: 1)
				(Characters say: (Random 21 23) -32768)
				(return)
			)
			(if (== loop 8)
				(self setLoop: 4)
				(choiceRect posn: 500 500)
				(yachtScript cue:)
				(return)
			)
			(if (and global519 (== (global178 rollsLeft:) 2) (not global533))
				(gSound2 play: 907 setLoop: 1)
				(Characters say: (Random 3 5) -32768 443 -32768)
				(return)
			)
			(if (or (== loop 6) (== loop 7))
				(rollsLeftView cel: 3 forceUpd:)
				(self setLoop: 4)
				(choiceRect posn: 500 500)
			)
			(yachtScript cue:)
			(= global510 1)
			(proc0_4)
		)
		(event claimed:)
	)
)

(instance rollsLeftView of View
	(properties)

	(method (init)
		(self ignoreActors: view: 504 setLoop: 9 cel: 0 posn: 83 199 setPri: 7)
		(super init: &rest)
	)
)

(instance playerNumber of Prop
	(properties)

	(method (init)
		(DrawCel 503 0 cel 75 0 7)
	)

	(method (cue &tmp temp0)
		(if (> (playersList size:) 1)
			(if (not argc)
				(= temp0 (playersList indexOf: global500))
				(if (> (playersList size:) (+ temp0 1))
					(= global500 (playersList at: (+ temp0 1)))
				else
					(= global500 (playersList at: 0))
				)
				(if (== global178 global500)
					(if global533
						(choiceRect posn: (global533 x:) (global533 y:))
					else
						(choiceRect posn: 500 500)
					)
				else
					(choiceRect posn: 500 500)
				)
			)
			(self cel: (playersList indexOf: global500) init:)
			(proc0_1)
			(global500 eachElementDo: #showScore)
		)
		(totals
			showScore:
				(if (global500 size:)
					(global500 calcTotal:)
				else
					0
				)
		)
	)
)

(instance totals of Score
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 503
			setLoop: 13
			cel: 0
			posn: 37 170
			setPri: 7
			finalScore: 0
		)
		(super init: &rest)
	)

	(method (showScore param1)
		(if argc
			(= finalScore param1)
		)
		(Format @global550 599 4 finalScore) ; "%3d"
		(Display
			@global550
			dsFONT
			500
			dsCOORD
			81
			(- y 10)
			dsBACKGROUND
			(global500 color:)
			dsCOLOR
			global375
		)
		(Display @global550 dsFONT 500 dsCOORD 82 (- y 10) dsBACKGROUND global376 dsCOLOR global377)
	)
)

(instance bigArrow of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 504 setLoop: 0 cel: 0 posn: 37 24 setPri: 7)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gSound2 play: 100 setLoop: 1)
			(event claimed: 1)
			(playerNumber cue:)
		)
		(event claimed:)
	)
)

(instance playersList of List
	(properties)

	(method (init &tmp temp0)
		(= temp0 1)
		(if (yachtPlayer1 type:)
			(self add: yachtPlayer1)
		)
		(if (yachtPlayer2 type:)
			(self add: yachtPlayer2)
		)
		(if (yachtPlayer3 type:)
			(self add: yachtPlayer3)
		)
		(if (yachtPlayer4 type:)
			(self add: yachtPlayer4)
		)
		(if (== (yachtPlayer1 type:) 2)
			(yachtPlayer1 usingCharacter: gChar1)
			(++ temp0)
		)
		(if (== (yachtPlayer2 type:) 2)
			(yachtPlayer2
				usingCharacter: (if (== temp0 2) gChar2 else gChar1)
			)
			(++ temp0)
		)
		(if (== (yachtPlayer3 type:) 2)
			(switch temp0
				(1
					(yachtPlayer3 usingCharacter: gChar1)
				)
				(2
					(yachtPlayer3 usingCharacter: gChar2)
				)
				(3
					(yachtPlayer3 usingCharacter: gChar3)
				)
			)
			(++ temp0)
		)
		(if (== (yachtPlayer4 type:) 2)
			(switch temp0
				(1
					(yachtPlayer4 usingCharacter: gChar1)
				)
				(2
					(yachtPlayer4 usingCharacter: gChar2)
				)
				(3
					(yachtPlayer4 usingCharacter: gChar3)
				)
			)
		)
		(= global500 (= global178 (self at: 0)))
	)

	(method (doit param1 &tmp temp0)
		(if (> size 1)
			(= temp0 (self indexOf: global178))
			(if (> size (+ temp0 1))
				(= global178 (self at: (+ temp0 1)))
			else
				(= global178 (self at: 0))
			)
			(if (or (not argc) (not param1))
				(= global500 global178)
				(bigArrow setLoop: (playersList indexOf: global178))
				(playerNumber cue: 1)
			)
		)
	)
)

(instance choiceRect of View
	(properties
		x 500
		y 500
		view 503
		loop 14
		priority 9
	)
)

(instance scoreNow of TrackingView
	(properties)

	(method (init)
		(self ignoreActors: view: 504 setLoop: 5 cel: 0 posn: 31 199 setPri: 14)
		(super init: &rest)
		(self addKeyMouse:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(gSound2 play: 907 setLoop: 1)
			(Characters say: (Random 18 20) -32768)
		)
		(event claimed:)
	)
)

(instance yacht_opt of File
	(properties
		name {yacht.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString: (Format @temp0 599 16 global519 global536) ; "%d%d"
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global519 (ReadNumber (self readString: @temp20 2)))
				(= global536 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global519 0)
				(= global536 1)
				(return 0)
			)
		)
	)
)

(instance frame1 of View
	(properties
		view 503
		loop 15
	)
)

(instance frame2 of View
	(properties
		view 503
		loop 15
		cel 1
	)
)

(instance frame3 of View
	(properties
		view 503
		loop 15
		cel 2
	)
)

(instance frame4 of View
	(properties
		view 503
		loop 15
		cel 3
	)
)

