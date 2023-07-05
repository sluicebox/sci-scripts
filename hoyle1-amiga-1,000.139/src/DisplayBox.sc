;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Main)
(use room5)
(use Interface)
(use Actor)
(use System)

(public
	proc899_0 0
	dsplay 1
)

(procedure (proc899_0)
	(return dsplay)
)

(procedure (localproc_0 param1 param2 param3)
	(if (== param3 1)
		(param1 clearExps:)
	)
	(if (param1 delay:)
		(param1 addExp: 1 0 (Random 1 10) delay: 0)
	)
	(param1 addExp: 1 param2 300)
)

(procedure (localproc_1 &tmp temp0)
	(if (not (= temp0 (StrAt @global520 global268)))
		(= global267 1)
		(return 0)
	)
	(++ global268)
	(if (<= 97 temp0 122)
		(-= temp0 97)
		(return (++ temp0))
	)
	(if (<= 65 temp0 90)
		(-= temp0 65)
		(return (++ temp0))
	else
		(return 0)
	)
)

(class DisplayBox of Obj
	(properties
		atX 0
		atY 0
		numLines 0
		windowUp 0
		cycles 0
		seconds 0
		lastSeconds 0
		owner 0
		curly 0
	)

	(method (init param1 param2 &tmp [temp0 4])
		(gSysWindow setBack: 14 setColor: 4)
		(= global504 (param1 altrEgo:))
		(= owner param1)
		(= global267 (= global268 0))
		(= atX
			(+ (param1 altrEgoX:) (if (== (param1 speakFrom:) 1) -171 else 24))
		)
		(= atY
			(-
				(param1 altrEgoY:)
				(if (and (< gCurRoomNum 10) (== (param1 playerNum:) 2)) 20 else 88)
			)
		)
		(TextSize @[temp0 0] global199 3 142)
		(= numLines (/ [temp0 2] 8))
		(= seconds (+ (/ (* global407 3) 4) numLines))
		(if (< seconds 4)
			(= seconds 4)
		)
		(if (and (== argc 2) param2)
			(+= seconds 5)
		)
		(cond
			((and (< gCurRoomNum 10) (== (param1 playerNum:) 2))
				(if (< numLines 3)
					(+= atY (* numLines 8))
				)
			)
			((< numLines 11)
				(-= atY (* (- 11 numLines) -8))
			)
		)
		(if (< atY 10)
			(= atY 10)
		)
		(if (> (+ atY (* numLines 8) 32) 195)
			(= atY (- 195 (+ (* numLines 8) 32)))
		)
		(= windowUp 1)
		(self displayText:)
		(self showWhosTalking: (param1 speakFrom:))
	)

	(method (dispose)
		(curly dispose:)
		(proc0_5)
		(gModelessDialog dispose:)
		(if (and (< gCurRoomNum 10) seconds)
			(gIntroSong stop:)
		)
		(= seconds (= windowUp (= global504 0)))
		((owner altrEgo:) clearExps: noExp:)
	)

	(method (doit &tmp temp0)
		(if seconds
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= lastSeconds temp0)
				(= lastSeconds temp0)
				(if (not (-- seconds))
					(self dispose:)
				)
			)
		)
	)

	(method (displayText &tmp temp0 [temp1 200])
		(= temp0 (Format @temp1 {#|@|>}))
		(StrCat temp0 {\n})
		(StrCat temp0 global199)
		(StrCat temp0 {\n})
		(StrCat temp0 {&~`~^})
		(= global199 temp0)
		(= global305 (Print global199 #at atX atY #font 3 #width 142 #mode 1 #dispose))
	)

	(method (showWhosTalking param1 &tmp temp0 temp1)
		(= curly (View new:))
		(= temp1 (+ (owner altrEgoY:) ((owner altrEgo:) mouthDistance:) 5))
		(= temp0 (- (owner altrEgoX:) (if (== param1 1) 19 else -15)))
		(curly
			view: 161
			setLoop: (if (== param1 1) 4 else 3)
			setPri: 15
			posn: temp0 temp1
			init:
			stopUpd:
		)
	)
)

(class ScoreCard of Obj
	(properties
		x -1
		y 85
		sFont 4
		title {                        }
	)

	(method (display))
)

(instance dsplay of DisplayBox
	(properties)
)

(class E of Obj
	(properties
		loop 0
		cel 0
		cycles 0
		seconds 0
		plotted 0
		type 0
		talking 0
	)
)

(class Person of Obj
	(properties
		view 0
		expressions 0
		x 0
		y 0
		mouthy 0
		owner 0
		ownerNum 0
		blinkInterval 100
		facialInterval 1000
		lookAtInterval 500
		mouthDistance 10
		numLines 0
		seconds 0
		lastSeconds 0
		currentExp 0
		expCel -1
		expLoop -1
		talkSpeed 1
		delay 0
		song 0
		skill 0
		crazy8sSkill 0
		heartsSkill 0
		ginSkill 0
		cribbageSkill 0
	)

	(method (preInit param1)
		(= owner param1)
		(= ownerNum (owner playerNum:))
		((= expressions (List new:)) add: name: {expr})
	)

	(method (init param1)
		(if (and (<= gCurRoomNum 10) (== argc 1))
			(gIntroSong number: song priority: 0 loop: 1 play:)
		)
		(if (and argc (not expressions))
			(self preInit: param1)
		)
		(= x (owner altrEgoX:))
		(= y (owner altrEgoY:))
		(= mouthy (+ y mouthDistance))
		(self portrait: 1)
		(if (<= argc 1)
			(proc0_5)
		)
		(= facialInterval (Random 1500 3000))
		(= blinkInterval (Random 1000 1500))
		(= lookAtInterval (Random 50 500))
		(if (<= gCurRoomNum 10)
			(if (== gCurRoomNum 2)
				(self say: 4 1)
			else
				(self say: 4)
			)
		)
	)

	(method (doit)
		(if expressions
			(if (expressions size:)
				(Wait talkSpeed)
				(self showExp:)
			)
			(self lookAround:)
		)
	)

	(method (setExp param1 param2 param3 param4 &tmp temp0)
		(= temp0 (E new:))
		(temp0 loop: param1 cel: param2)
		(if (>= argc 3)
			(if (>= param3 100)
				(temp0 type: 1 seconds: (/ param3 100))
			else
				(temp0 cycles: param3)
			)
		else
			(temp0 cycles: 1)
		)
		(if (== argc 4)
			(temp0 talking: param4)
		)
		(return temp0)
	)

	(method (addExp)
		(expressions add: (self setExp: &rest))
	)

	(method (insertExp)
		(if (expressions size:)
			((expressions at: 0) plotted: 0)
		)
		(expressions addToFront: (self setExp: &rest))
	)

	(method (showExp &tmp temp0 temp1 temp2)
		(= currentExp (expressions at: 0))
		(if (currentExp talking:)
			(if global267
				(expressions delete: (expressions at: 0))
				(currentExp dispose:)
			else
				(= temp1 (localproc_1))
				(self insertExp: 3 [global111 temp1] [global827 temp1])
			)
		)
		(= currentExp (expressions at: 0))
		(if (not (currentExp plotted:))
			((= gView (View new:))
				view: view
				setLoop: (currentExp loop:)
				setCel: (currentExp cel:)
				posn: x (if (== (currentExp loop:) 3) mouthy else y)
				setPri:
					(if (not (currentExp loop:))
						(owner portraitPri:)
					else
						14
					)
				addToPic:
			)
			(currentExp plotted: 1)
		)
		(if (currentExp type:)
			(if (currentExp seconds:)
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(= lastSeconds temp0)
					(currentExp seconds: (- (currentExp seconds:) 1))
					(if (not (currentExp seconds:))
						(self disposeExp:)
					)
				)
			)
		else
			(if (currentExp cycles:)
				(currentExp cycles: (- (currentExp cycles:) 1))
			)
			(if (not (currentExp cycles:))
				(self disposeExp:)
			)
		)
	)

	(method (disposeExp)
		(expressions delete: (expressions at: 0))
		(if
			(and
				(not (expressions size:))
				(or (!= (currentExp loop:) 1) (currentExp cel:))
			)
			(self noExp:)
		)
		(currentExp dispose:)
	)

	(method (clearExps &tmp temp0)
		(if (expressions size:)
			(for ((= temp0 (- (expressions size:) 1))) (>= temp0 0) ((-- temp0))
				(= currentExp (expressions at: temp0))
				(expressions delete: currentExp)
				(currentExp dispose:)
			)
		)
	)

	(method (portrait)
		(if argc
			(proc0_2 view 0 0 x y 14)
		else
			(self addExp: 0 0)
		)
	)

	(method (erasePortrait)
		(proc0_2 view 0 1 x y 14)
	)

	(method (noExp)
		(self addExp: 1 0)
	)

	(method (smile param1)
		(localproc_0 self 8 param1)
	)

	(method (bigSmile param1)
		(localproc_0 self 7 param1)
	)

	(method (smirk param1)
		(localproc_0 self 1 param1)
	)

	(method (sly param1)
		(localproc_0 self 3 param1)
	)

	(method (shock param1)
		(localproc_0 self 4 param1)
	)

	(method (surprise param1)
		(localproc_0 self 2 param1)
	)

	(method (upset param1)
		(localproc_0 self 5 param1)
	)

	(method (anger param1)
		(localproc_0 self 6 param1)
	)

	(method (blink)
		(self insertExp: 2 0 insertExp: 2 3 2)
		(= blinkInterval (Random 1000 1500))
	)

	(method (wink)
		(self insertExp: 2 0 insertExp: 2 7 3)
		(= blinkInterval (Random 1000 1500))
	)

	(method (rollEyes)
		(self
			clearExps:
			addExp: 2 2 6
			addExp: 2 6 6
			addExp: 2 4 6
			addExp: 2 5 6
			addExp: 2 1 6
			addExp: 2 0
		)
	)

	(method (lookAt param1 &tmp temp0)
		(= temp0
			(switch ownerNum
				(1
					(switch param1
						(0 2)
						(2 6)
						(3 2)
					)
				)
				(2
					(switch param1
						(0 0)
						(1 1)
						(3 2)
					)
				)
				(3
					(switch param1
						(0 1)
						(1 1)
						(2 5)
					)
				)
			)
		)
		(self addExp: 2 temp0 300 addExp: 2 0)
	)

	(method (say param1 param2 param3 &tmp temp0)
		(if (>= param1 1000)
			(proc5_9
				param1
				(if (>= argc 2) param2 else 0)
				(if (== argc 3) param3 else 0)
			)
		else
			(= temp0 [global500 (- ownerNum 1)])
			(if param1
				(= global199
					(cond
						((and (== param1 1) param3)
							(Format ; "%s %s"
								@global520
								899
								0
								708
								(+ (* (- ownerNum 1) 3) (-- param1))
								708
								(+ (param3 skill:) (* global503 3) 54)
							)
						)
						((< param1 4)
							(Format
								@global520
								708
								(+ (* (- ownerNum 1) 3) (-- param1))
							)
						)
						(else
							(Format
								@global520
								(= global778
									(+
										709
										(- (- temp0 1) (> temp0 7))
										(* 18 (- gCurRoomNum 1))
									)
								)
								(= global779
									(Random
										(= param1 (* (- param1 4) 3))
										(+ param1 2)
									)
								)
							)
						)
					)
				)
			)
		)
		(dsplay
			init:
				owner
				(if (or (== gCurRoomNum 2) (and param2 (>= argc 2))) 1 else 0)
		)
		(self talk:)
	)

	(method (lookAround &tmp temp0)
		(if (not (-- blinkInterval))
			(self blink:)
		)
		(if (not (-- facialInterval))
			(= facialInterval (Random 1500 3000))
			(if (not (expressions size:))
				(switch (Random 0 2)
					(0
						(self smirk: 0)
					)
					(1
						(self sly: 0)
					)
					(2
						(self smile: 0)
					)
				)
			)
		)
		(if (not (-- lookAtInterval))
			(= lookAtInterval (Random 1 500))
			(= temp0 (Random 5 99))
			(switch (Random 0 5)
				(0
					(if (not (Random 0 2))
						(self wink:)
					)
				)
				(1
					(self lookAt: (Random 0 3) temp0)
				)
				(2
					(self addExp: 2 1 temp0)
				)
				(3
					(self addExp: 2 2 temp0)
				)
				(4
					(if (not (Random 0 7))
						(self addExp: 2 4 30)
					)
				)
				(5
					(self addExp: 2 1 30 addExp: 2 2 30)
				)
			)
			(self addExp: 2 0)
		)
	)

	(method (talk &tmp [temp0 4])
		(self clearExps:)
		(self addExp: 0 0 0 (Random 15 25))
		(self addExp: 1 0)
	)
)

