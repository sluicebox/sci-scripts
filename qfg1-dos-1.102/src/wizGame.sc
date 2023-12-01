;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use StatusBar)
(use MazeBug)
(use n241)
(use n242)
(use Interface)
(use CursorCoords)
(use LoadMany)
(use Cat)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	wizGame 0
	objList 1
	proc32_2 2
	openSign 3
	fetchSign 4
	trigSign 5
	playerBug 6
	flame 7
	flameSign 8
	proc32_9 9
	proc32_10 10
	proc32_11 11
	proc32_12 12
	proc32_13 13
)

(local
	local0
	local1
	local2 = 4
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	[local11 8]
	[local19 17]
	[local36 7]
	[local43 24] = [36 58 0 282 60 0 203 88 0 133 124 0 100 156 0 254 141 0 153 182 0 252 168 0]
	[local67 51] = [74 43 2 140 42 3 234 42 3 19 73 1 53 89 5 114 78 2 158 83 4 232 64 3 301 74 1 266 91 1 120 127 2 182 137 1 240 172 3 278 174 4 138 10 0 157 10 0 176 10 0]
	[local118 21] = [84 75 1 43 117 1 181 120 1 285 116 1 199 163 1 118 10 0 196 10 0]
	[local139 78] = [0 35 105 47 30 59 105 35 235 47 193 50 235 35 319 47 278 59 0 47 56 110 54 131 186 74 235 98 230 101 56 47 227 110 154 111 227 47 319 110 293 134 0 110 80 132 172 182 80 110 166 132 55 158 166 110 245 124 182 130 245 110 319 150 199 150 0 155 85 189 199 150 168 125 220 189 320 200]
)

(procedure (proc32_10 param1 param2 &tmp temp0)
	(= temp0 [local11 param1])
	(if (< 1 argc)
		(= [local11 param1] param2)
	)
	(return temp0)
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6)
	(return
		(and
			(<= param3 param1)
			(< param1 param5)
			(<= param4 param2)
			(< param2 param6)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
	(= local7 (= local9 1000))
	(= local6 (= local8 param3))
	(= temp0 param3)
	(for ((= temp1 (+ param3 param3 param3))) (< temp0 param4) ((+= temp1 3))
		(cond
			((and param5 (< [local43 (+ temp1 1)] (- param2 5))))
			(
				(<
					(= temp2
						(GetDistance
							param1
							param2
							[local43 temp1]
							[local43 (+ temp1 1)]
						)
					)
					local7
				)
				(if (< local7 local9)
					(= local9 local7)
					(= local8 local6)
				)
				(= local7 temp2)
				(= local6 temp0)
			)
		)
		(++ temp0)
	)
	(return local6)
)

(procedure (proc32_2 param1)
	(if (CastSpell param1)
		(proc32_9 param1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc32_9 param1)
	(if local4
		(proc32_11)
	)
	(= local4 param1)
	(= local3 (GetTime 1)) ; SysTime12
	(= global279 (+ 2 (/ [gEgoStats param1] 10)))
	(timeBar value: global279 draw:)
)

(procedure (proc32_11 &tmp [temp0 2])
	(= global279 0)
	(timeBar value: 0 draw:)
	(switch local4
		(23
			(flame posn: 500 500 setCycle: 0 stopUpd:)
		)
		(24
			(if local5
				(local5 drop: (local5 x:) (local5 y:))
				(= local5 0)
			)
			(gGame setCursor: gNormalCursor 1)
		)
	)
	(= local4 0)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1)
	(-- param3)
	(repeat
		(if [local11 (= temp0 (Random param2 param3))]
			(break)
		)
	)
	(= [local11 param1] [local11 temp0])
	([local11 temp0] listIndex: param1)
	(= [local11 temp0] 0)
	(= temp1 (+ param1 param1 param1))
	([local11 param1]
		setCel: [local43 (+ temp1 2)]
		setPri: 1
		posn: [local43 temp1] [local43 (+ temp1 1)]
	)
)

(procedure (proc32_12 param1 param2 &tmp temp0 temp1)
	(objList empty:)
	(for ((= temp0 param1)) (< temp0 param2) ((++ temp0))
		(if (= temp1 [local11 temp0])
			(objList
				add:
					((CursorCoords new:)
						cursorX: (temp1 x:)
						cursorY: (temp1 y:)
					)
			)
		)
	)
)

(procedure (proc32_13 param1 param2 &tmp temp0)
	(objList empty:)
	(for ((= temp0 param1)) (< temp0 param2) ((++ temp0))
		(if (not [local11 temp0])
			(objList
				add:
					((CursorCoords new:)
						cursorX: [local11 (+ 32 temp0 temp0 temp0)]
						cursorY: [local11 (+ 33 temp0 temp0 temp0)]
					)
			)
		)
	)
)

(class Rock of View
	(properties
		listIndex 0
	)

	(method (init)
		(super init: &rest)
		(gKeyHandler addToFront: self)
	)

	(method (handleEvent event)
		(if
			(and
				(== local4 17)
				(or
					(MousedOn self event 0)
					(and
						(== (event message:) KEY_RETURN)
						(== (event type:) evKEYBOARD)
						(== x (event x:))
						(== y (event y:))
					)
				)
			)
			(event claimed: 1)
			(= global279 0)
			(proc241_0 listIndex)
			(proc32_11)
			(= global203 1)
			(wizGame setScript: 0)
		)
	)
)

(instance lasso of Cat
	(properties
		y 300
		x 400
		view 32
		loop 8
		illegalBits 0
		doCast 1
	)

	(method (dispose)
		(gKeyHandler delete: self)
		(super dispose:)
	)

	(method (posn)
		(super posn: &rest)
		(if local5
			(local5 posn: &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(gKeyHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (== local4 24) (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			(event type: evMOUSERELEASE)
		)
		(super handleEvent: event)
	)
)

(class Fetchable of View
	(properties
		listIndex 0
		fetchType 0
		inMotion 0
	)

	(method (init)
		(super init: &rest)
		(gKeyHandler addToFront: self)
	)

	(method (handleEvent event)
		(if
			(and
				(not inMotion)
				(== local4 24)
				(or
					(MousedOn self event 0)
					(and
						(== (event message:) KEY_RETURN)
						(== (event type:) evKEYBOARD)
						(== x (event x:))
						(== y (event y:))
					)
				)
			)
			(event claimed: 1)
			(self pickUp: event)
		)
	)

	(method (pickUp param1)
		(if (not inMotion)
			(= inMotion 1)
			(if (== fetchType 1)
				(= [local11 listIndex] 0)
				(= local1 1)
				(proc32_13 25 32)
			else
				(= [local11 listIndex] 0)
				(= local0 1)
				(proc32_13 8 25)
			)
			(= local5 self)
			(self setCel: 0 setPri: 10 startUpd:)
			(lasso
				setLoop: 8
				setPri: 11
				ignoreActors: 1
				init:
				posn: x y z
				setCycle: Fwd
				caller: self
				track: param1
			)
		)
	)

	(method (cue)
		(self drop: x y)
	)

	(method (drop param1 param2 &tmp temp0 temp1 temp2)
		(= temp0 (OnControl CONTROL param1 param2))
		(switch fetchType
			(1
				(= temp1 (localproc_1 param1 param2 25 32 0))
			)
			(2
				(= temp1 (localproc_1 param1 param2 8 25 0))
			)
		)
		(= inMotion (= local5 (= local4 0)))
		(lasso dispose:)
		(gGame setCursor: gNormalCursor 1)
		(if (== temp1 -1)
			(self dispose:)
		else
			(= [local11 temp1] self)
			(self listIndex: temp1)
			(= temp2 (+ temp1 temp1 temp1))
			(self
				setCel: [local43 (+ temp2 2)]
				setPri: 1
				posn: [local43 temp2] [local43 (+ temp2 1)]
				stopUpd:
			)
		)
		(= local0 0)
		(= local1 0)
		(objList empty:)
		(proc32_11)
		(= global203 1)
		(wizGame setScript: 0)
	)
)

(class SpecialBug of MazeBug
	(properties
		onALadder 0
	)

	(method (nearRock param1)
		(proc242_0 self 3 param1)
	)

	(method (nearBridge param1)
		(proc242_0 self 2 param1)
	)

	(method (nearLadder param1)
		(proc242_0 self 1 param1)
	)

	(method (doit)
		(super doit:)
		(if (or (>= x 320) (>= y 190))
			(mover completed: 1)
			(wizGame cue:)
		else
			(self chooseRoute: 0)
		)
	)

	(method (cue)
		(= onALadder 0)
		(self chooseRoute: 1)
	)

	(method (chooseRoute param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and global279 (== local4 23) (< (self distanceTo: flame) 120))
			(if
				(or
					(not mover)
					(!= (mover x:) (flame x:))
					(!= (mover y:) (flame y:))
				)
				(self setMotion: MazeMove (flame x:) (flame y:))
			)
			(return)
		)
		(if (== form 1)
			(if (and mover onALadder)
				(return)
			)
			(= temp2
				[local43
					(= temp5
						(+ (* 2 (= temp4 (localproc_1 x y 25 32 1))) temp4)
					)
				]
			)
			(if
				(and
					(> (= temp3 [local43 (+ temp5 1)]) (- y 6))
					(<= (GetDistance x y temp2 temp3) 40)
					(or
						(not mover)
						(!= (mover x:) temp2)
						(!= (mover y:) (+ temp3 10))
					)
				)
				(self
					path: 0
					onALadder: 1
					setMotion: MazeMove temp2 (+ temp3 10) self
				)
				(return)
			)
		)
		(if
			(and
				(not param1)
				mover
				(self
					inRect:
						[local139 path]
						[local139 (+ path 1)]
						[local139 (+ path 2)]
						[local139 (+ path 3)]
				)
			)
			(return)
		)
		(= temp1 (self path:))
		(for ((= temp0 0)) (< temp0 78) ((+= temp0 6))
			(if
				(localproc_0
					x
					y
					[local139 temp0]
					[local139 (+ temp0 1)]
					[local139 (+ temp0 2)]
					[local139 (+ temp0 3)]
				)
				(break)
			)
		)
		(if (== temp0 78)
			(if mover
				(return)
			else
				(= temp0 temp1)
			)
		)
		(self
			path: temp0
			setMotion:
				MazeMove
				[local139 (+ temp0 4)]
				[local139 (+ temp0 5)]
				self
		)
	)
)

(instance playerBug of SpecialBug
	(properties
		view 33
		startX 60
		startY 46
		smarts 3
	)
)

(instance wizBug of SpecialBug
	(properties
		view 33
		loop 3
		startX 303
		startY 40
		smarts 8
	)

	(method (changeForm)
		(if (or (!= form 1) (!= (self onControl: 1) 4))
			(super changeForm:)
		)
	)
)

(instance gameSound of Sound
	(properties
		number 79
		priority 2
		loop -1
	)
)

(instance flame of Prop
	(properties
		y 500
		x 500
		view 32
		loop 6
	)
)

(instance fetchSign of Prop
	(properties
		y 28
		x 48
		view 32
		priority 5
	)
)

(instance openSign of Prop
	(properties
		y 28
		x 122
		view 32
		loop 1
		priority 5
	)
)

(instance trigSign of Prop
	(properties
		y 28
		x 198
		view 32
		loop 2
		priority 5
	)
)

(instance flameSign of Prop
	(properties
		y 28
		x 274
		view 32
		loop 7
		priority 5
	)
)

(instance pointBar of StatusBar
	(properties
		x 26
		y 12
		titleCel 2
	)
)

(instance timeBar of StatusBar
	(properties
		max 10
		x 253
		y 12
		titleCel 5
	)
)

(instance wizGame of Rm
	(properties
		picture 32
		style 6
	)

	(method (dispose)
		(timeBar dispose:)
		(pointBar dispose:)
		(objList dispose:)
		(if (HaveMouse)
			(gGame setCursor: gNormalCursor 1)
		else
			(gGame setCursor: gNormalCursor 1 304 174)
		)
		(Joystick 12 0)
		(super dispose:)
		(LoadMany 0 238 205 810 239 240 241 242)
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(LoadMany rsSCRIPT 238 205 810 239 240 241 242)
		(LoadMany rsVIEW 32 33 global302)
		(super init: &rest)
		(gGame setCursor: gNormalCursor 1)
		(++ global593)
		(SolvePuzzle 616 5 1)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(repeat
				(if (not [local11 (= temp2 (Random 0 7))])
					(break)
				)
			)
			(= temp3 [local43 (= temp1 (+ temp2 temp2 temp2))])
			(= temp4 [local43 (+ temp1 1)])
			((= [local11 temp2] (Rock new:))
				listIndex: temp2
				view: 32
				setLoop: 3
				setCel: 0
				setPri: 4
				x: temp3
				y: temp4
				ignoreActors: 1
				init:
				stopUpd:
			)
		)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(repeat
				(if (not [local19 (= temp2 (Random 0 13))])
					(break)
				)
			)
			(= temp1 (+ temp2 temp2 temp2))
			((= [local19 temp2] (Fetchable new:))
				listIndex: (+ temp2 8)
				fetchType: 2
				view: 32
				setLoop: 4
				setCel: [local67 (+ temp1 2)]
				setPri: 1
				ignoreActors: 1
				posn: [local67 temp1] [local67 (+ temp1 1)]
				init:
				stopUpd:
			)
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			(repeat
				(if (not [local36 (= temp2 (Random 0 4))])
					(break)
				)
			)
			(= temp1 (+ temp2 temp2 temp2))
			((= [local36 temp2] (Fetchable new:))
				listIndex: (+ temp2 25)
				fetchType: 1
				view: 32
				setLoop: 5
				setCel: [local118 (+ temp1 2)]
				setPri: 1
				ignoreActors: 1
				posn: [local118 temp1] [local118 (+ temp1 1)]
				init:
				stopUpd:
			)
		)
		(ClearFlag 337)
		(fetchSign init: stopUpd:)
		(openSign init: stopUpd:)
		(trigSign init: stopUpd:)
		(flameSign init: stopUpd:)
		(pointBar max: (MaxMana) value: [gEgoStats 16] init:) ; mana
		(= global279 0)
		(timeBar init:)
		(playerBug
			setLoop: 0
			setCycle: Fwd
			posn: 60 46
			lowPri:
			smarts: (/ (+ [gEgoStats 1] 5) 10) ; intelligence
			otherBug: wizBug
			path: 0
			init:
			setMotion: MazeMove [local139 4] [local139 5] playerBug
		)
		(wizBug
			setLoop: 3
			setCycle: Fwd
			posn: 303 40
			lowPri:
			otherBug: playerBug
			path: 12
			init:
			setMotion: MazeMove [local139 16] [local139 17] wizBug
			setScript: wizScript
		)
		(flame setPri: 15 init: setCycle: Fwd stopUpd:)
		(gameSound init: play:)
		(gDirHandler addToFront: self)
		(gMouseHandler addToFront: self)
		(gKeyHandler addToFront: self)
		(objList init: add:)
		(= global203 1)
		(Joystick 12 30)
	)

	(method (cue &tmp temp0 temp1)
		(cond
			((IsFlag 337)
				(Print 32 0) ; "Too much for you? I guess you should work on your magic. Maybe next time you'll be more of a challenge."
			)
			(((wizBug mover:) completed:)
				(Print 32 1) ; "Guess I still have a knack for the old Maze game."
			)
			((not (gEgo knows: 20)) ; dazzleSpell
				(if (< (= temp0 (+ global593 global593)) 500)
					(= temp0 500)
				)
				(= temp1 (if (== global593 1) {} else {s}))
				(Printf 32 2 global593 temp1 temp0) ; "Well, you seem to have beginner's luck. It only took you %d game%s to win. Hmph. It usually takes at least %d tries for anyone less than a full Wizard to defeat me."
				(Print 32 3) ; "As I promised, I shall now teach you the spell known as `Erasmus' Razzle Dazzle'."
				(gEgo learn: 20 10) ; dazzleSpell
				(SolvePuzzle 617 12 1)
			)
			(else
				(Print 32 4) ; "Well! You don't have to rub it in, you know!"
			)
		)
		(gCurRoom newRoom: 31)
	)

	(method (doit &tmp temp0 temp1)
		(if (!= local10 [gEgoStats 16]) ; mana
			(= local10 [gEgoStats 16]) ; mana
			(pointBar value: local10 draw:)
		)
		(if (and global279 (!= (= temp0 (GetTime 1)) local3)) ; SysTime12
			(= local3 temp0)
			(if (-- global279)
				(timeBar value: global279 draw:)
			else
				(proc32_11)
				(= global203 1)
				(wizGame setScript: 0)
			)
		)
		(if global203
			(= temp1 global203)
			(= global203 0)
			(switch temp1
				(1
					(self setScript: (ScriptID 239 0)) ; chooseSpell
				)
				(2
					(self setScript: (ScriptID 240 0) 0 24) ; doASpell
				)
				(3
					(self setScript: (ScriptID 240 0) 0 17) ; doASpell
				)
				(4
					(self setScript: (ScriptID 240 0) 0 19) ; doASpell
				)
				(5
					(self setScript: (ScriptID 240 1)) ; doFlame
				)
			)
		)
		(super doit:)
	)
)

(instance wizScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(= seconds local2)
			)
			(1
				(= temp2 (client x:))
				(= temp3 (client y:))
				(= temp4 (client form:))
				(= temp1 (localproc_1 temp2 temp3 0 32 1))
				(= temp6 local7)
				(= temp7 1)
				(while (< temp7 3)
					(= temp5 (+ temp1 temp1 temp1))
					(++ temp7)
					(cond
						(
							(and
								(< (client distanceTo: playerBug) 25)
								(<= -1 (- temp4 (playerBug form:)) 0)
							)
							(client changeForm:)
						)
						((and (!= temp4 0) (== (client onControl: 1) 1024))
							(client changeForm:)
						)
						((> temp6 50))
						((and (< 0 temp1 8) [local11 temp1])
							(proc241_0 temp1)
							(if (== local4 17)
								(proc32_12 0 8)
							)
						)
						((and (< 8 temp1 25) (not [local11 temp1]))
							(localproc_2 temp1 8 25)
							(if (== local4 24)
								(if local0
									(proc32_13 8 25)
								else
									(proc32_12 8 25)
								)
							)
						)
						((< 25 temp1 32)
							(cond
								((not [local11 temp1])
									(localproc_2 temp1 25 32)
									(if (== local4 24)
										(if local1
											(proc32_13 25 32)
										else
											(proc32_12 25 32)
										)
									)
								)
								((!= temp4 1)
									(client changeForm:)
								)
								(else
									(-- temp7)
								)
							)
						)
						(else
							(-- temp7)
						)
					)
					(self changeState: 0)
					(++ temp7)
					(= temp6 local9)
					(= temp1 local8)
				)
			)
		)
	)
)

(instance objList of InputList
	(properties)
)

