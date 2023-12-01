;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use MazeBug)
(use Interface)
(use CursorCoords)
(use n814)
(use Print)
(use ForwardCounter)
(use LoadMany)
(use Cat)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	wizGame 0
	playerBug 1
	wizBug 2
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
	local11
	[local12 2]
	local14
	[local15 8]
	[local23 17]
	[local40 7]
	[local47 24] = [40 20 0 274 23 0 201 50 0 130 86 0 96 117 0 230 108 0 150 143 0 250 130 0]
	[local71 51] = [79 6 3 137 6 3 223 6 3 28 38 1 56 58 5 117 43 2 156 47 4 225 28 3 290 39 1 266 54 1 114 93 6 182 101 1 235 136 2 273 138 4 500 500 0 500 500 0 500 500 0]
	[local122 21] = [82 41 1 49 81 1 185 85 1 279 81 1 196 129 1 500 500 0 500 500 0]
	[local143 78] = [0 0 110 14 33 25 105 0 229 14 191 15 230 0 319 14 272 25 0 14 60 75 57 95 184 40 233 65 226 66 63 14 225 75 152 76 223 14 319 75 284 96 0 74 82 97 173 144 80 74 168 97 61 120 166 74 219 95 183 96 244 74 319 107 195 113 0 117 79 154 195 113 172 92 200 154 320 146]
	[local221 4] = [48 122 198 274]
	[local225 9] = [0 0 10 10 10 0 -10 -10 -10]
	[local234 9] = [6 -6 -6 0 6 6 6 0 -6]
)

(procedure (localproc_0)
	(button1 init:)
	(objectList add: button1)
	(button2 init:)
	(objectList add: button2)
	(button3 init:)
	(objectList add: button3)
	(button4 init:)
	(objectList add: button4)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 param6)
	(return
		(and
			(<= param3 param1)
			(< param1 param5)
			(<= param4 param2)
			(< param2 param6)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
	(= local7 (= local9 1000))
	(= local6 (= local8 param3))
	(= temp0 param3)
	(for ((= temp1 (+ param3 param3 param3))) (< temp0 param4) ((+= temp1 3))
		(cond
			((and param5 (< [local47 (+ temp1 1)] (- param2 5))))
			(
				(<
					(= temp2
						(GetDistance
							param1
							param2
							[local47 temp1]
							[local47 (+ temp1 1)]
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

(procedure (localproc_3 param1)
	(if (gEgo knows: param1)
		(if (CastSpell param1)
			(localproc_4 param1)
			(return 1)
		else
			(return 0)
		)
	else
		(gMessager say: 4 0 1) ; "Sorry, but you don't know that spell. (Now don't you feel guilty that you lied to Erasmus about knowing it?)"
		(return 0)
	)
)

(procedure (localproc_4 param1)
	(if local4
		(localproc_5)
	)
	(= local4 param1)
	(= local3 (GetTime 1)) ; SysTime12
	(if (!= local4 19)
		(= global257 (+ 2 (/ [gEgoStats param1] 10)))
		(timeBar value: global257 draw:)
	)
)

(procedure (localproc_5 &tmp [temp0 2])
	(= global257 0)
	(if (!= local4 19)
		(timeBar value: global257 draw:)
	)
	(switch local4
		(23
			(flame posn: 500 500 setCycle: 0 setPri: 15 stopUpd:)
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

(procedure (localproc_6 param1 param2 param3 &tmp temp0 temp1)
	(-- param3)
	(repeat
		(if [local15 (= temp0 (Random param2 param3))]
			(break)
		)
	)
	(= [local15 param1] [local15 temp0])
	([local15 temp0] listIndex: param1)
	(= [local15 temp0] 0)
	(= temp1 (+ param1 param1 param1))
	([local15 param1]
		setCel: [local47 (+ temp1 2)]
		setPri: 1
		posn: [local47 temp1] [local47 (+ temp1 1)]
	)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1)
	(objectList empty:)
	(for ((= temp0 param1)) (< temp0 param2) ((++ temp0))
		(if (= temp1 [local15 temp0])
			(objectList
				add:
					((CursorCoords new:)
						cursorX: (temp1 x:)
						cursorY: (temp1 y:)
					)
			)
		)
	)
)

(procedure (localproc_8 param1 param2 &tmp temp0)
	(objectList empty:)
	(for ((= temp0 param1)) (< temp0 param2) ((++ temp0))
		(if (not [local15 temp0])
			(objectList
				add:
					((CursorCoords new:)
						cursorX: [local15 (+ 32 temp0 temp0 temp0)]
						cursorY: [local15 (+ 33 temp0 temp0 temp0)]
					)
			)
		)
	)
)

(procedure (localproc_9 param1 &tmp temp0 temp1 temp2)
	(if (= temp1 [local15 param1])
		(repeat
			(if (not [local15 (= temp2 (Random 0 7))])
				(break)
			)
		)
		(= [local15 temp2] temp1)
		(temp1 listIndex: temp2)
		(= [local15 param1] 0)
		(= temp0 (+ temp2 temp2 temp2))
		(temp1 posn: [local15 (+ 32 temp0)] [local15 (+ 33 temp0)])
	)
)

(procedure (localproc_10 param1 &tmp temp0 temp1 temp2) ; UNUSED
	(if (= temp1 [local15 param1])
		(repeat
			(if (not [local15 (= temp2 (Random 8 25))])
				(break)
			)
		)
		(= [local15 temp2] temp1)
		(temp1 listIndex: temp2)
		(= [local15 param1] 0)
		(= temp0 (+ temp2 temp2 temp2))
		(temp1 posn: [local15 (+ 32 temp0)] [local15 (+ 33 temp0)])
		(if local0
			(localproc_8 8 25)
		else
			(localproc_7 8 25)
		)
	)
)

(procedure (localproc_11 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
	(switch param2
		(3
			(= temp0 (= temp2 0))
			(= temp1 8)
		)
		(2
			(= temp0 (= temp2 8))
			(= temp1 25)
		)
		(1
			(= temp0 (= temp2 25))
			(= temp1 32)
		)
	)
	(= temp4 0)
	(while (< temp0 temp1)
		(if
			(and
				(= temp3 [local15 temp0])
				(<= (param1 distanceTo: temp3) param3)
			)
			(= temp4 1)
			(break)
		)
		(++ temp0)
	)
	(return temp4)
)

(class Rock of View
	(properties
		listIndex 0
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((and (== (event message:) KEY_ESCAPE) (not (IsFlag 337)))
				(SetFlag 337)
				(= local14 0)
				(wizGame cue:)
				(event claimed: 1)
			)
			(
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
				(= global257 0)
				(localproc_9 listIndex)
				(localproc_5)
				(= global188 1)
				(wizGame setScript: 0)
			)
		)
	)
)

(instance lasso of Cat
	(properties
		x 400
		y 300
		view 32
		loop 8
		illegalBits 0
		doCast 1
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
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
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(cond
			((and (== (event message:) KEY_ESCAPE) (not (IsFlag 337)))
				(SetFlag 337)
				(= local14 0)
				(wizGame cue:)
				(event claimed: 1)
			)
			(
				(and
					(== local4 24)
					(== (event message:) KEY_RETURN)
					(== (event type:) evKEYBOARD)
				)
				(event type: evMOUSERELEASE)
			)
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
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(if (self inMotion:)
			(self drop:)
		)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((and (== (event message:) KEY_ESCAPE) (not (IsFlag 337)))
				(SetFlag 337)
				(= local14 0)
				(wizGame cue:)
				(event claimed: 1)
			)
			(
				(and
					(not inMotion)
					(== local4 24)
					(or
						(and (MousedOn self event 0) (!= (event type:) evMOUSERELEASE))
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
	)

	(method (pickUp param1)
		(if (not inMotion)
			(= inMotion 1)
			(if (== fetchType 1)
				(= [local15 listIndex] 0)
				(= local1 1)
				(localproc_8 25 32)
			else
				(= [local15 listIndex] 0)
				(= local0 1)
				(localproc_8 8 25)
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
				(= temp1 (localproc_2 param1 param2 25 32 0))
			)
			(2
				(= temp1 (localproc_2 param1 param2 8 25 0))
			)
		)
		(= inMotion (= local5 (= local4 0)))
		(lasso dispose:)
		(gGame setCursor: gNormalCursor 1)
		(if (== temp1 -1)
			(self dispose:)
		else
			(= [local15 temp1] self)
			(self listIndex: temp1)
			(= temp2 (+ temp1 temp1 temp1))
			(self
				setCel: [local47 (+ temp2 2)]
				setPri: 1
				posn: [local47 temp2] [local47 (+ temp2 1)]
				stopUpd:
			)
		)
		(= local0 0)
		(= local1 0)
		(objectList empty:)
		(localproc_5)
		(= global188 1)
		(wizGame setScript: 0)
	)
)

(class SpecialBug of MazeBug
	(properties
		onALadder 0
	)

	(method (nearRock param1)
		(localproc_11 self 3 param1)
	)

	(method (nearBridge param1)
		(localproc_11 self 2 param1)
	)

	(method (nearLadder param1)
		(localproc_11 self 1 param1)
	)

	(method (doit)
		(super doit:)
		(if (or (>= x 315) (>= y 190))
			(mover completed: 1)
			(= local14 0)
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
		(if (and global257 (== local4 23) (< (self distanceTo: flame) 120))
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
				[local47
					(= temp5
						(+ (* 2 (= temp4 (localproc_2 x y 25 32 1))) temp4)
					)
				]
			)
			(= temp3 [local47 (+ temp5 1)])
			(if
				(and
					(== (self onControl: 1) 8)
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
						[local143 path]
						[local143 (+ path 1)]
						[local143 (+ path 2)]
						[local143 (+ path 3)]
				)
			)
			(return)
		)
		(= temp1 (self path:))
		(for ((= temp0 0)) (< temp0 78) ((+= temp0 6))
			(if
				(localproc_1
					x
					y
					[local143 temp0]
					[local143 (+ temp0 1)]
					[local143 (+ temp0 2)]
					[local143 (+ temp0 3)]
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
				[local143 (+ temp0 4)]
				[local143 (+ temp0 5)]
				self
		)
	)
)

(instance playerBug of SpecialBug
	(properties
		view 33
		startX 69
		startY 9
		smarts 3
	)
)

(instance wizBug of SpecialBug
	(properties
		view 33
		loop 3
		startX 293
		startY 5
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
		flags -1
		number 79
		priority 2
		loop -1
	)
)

(instance flame of Prop
	(properties
		x 500
		y 500
		view 32
		loop 6
	)
)

(instance fetchSign of Prop
	(properties
		x 75
		y 165
		view 32
		priority 5
		cycleSpeed 4
	)
)

(instance openSign of Prop
	(properties
		x 122
		y 169
		view 32
		loop 1
		cel 2
		priority 5
		cycleSpeed 4
	)
)

(instance trigSign of Prop
	(properties
		x 182
		y 183
		view 32
		loop 2
		cel 2
		priority 5
		cycleSpeed 4
	)
)

(instance flameSign of Prop
	(properties
		x 225
		y 173
		view 32
		loop 7
		cel 2
		priority 5
		cycleSpeed 4
	)
)

(class pointBar of View
	(properties
		x 23
		y 165
		view 32
		loop 9
		value 0
		valCel 0
		max 1000
	)

	(method (init)
		(self ignoreActors: draw:)
		(super init: &rest)
	)

	(method (draw &tmp temp0)
		(if (< max 1)
			(= max 1)
		)
		(if (> (= temp0 value) max)
			(= temp0 max)
		)
		(= valCel (/ (+ (= temp0 (/ (+ (* temp0 100) max -1) max)) 9) 10))
		(self cel: valCel setPri: 15 stopUpd:)
	)
)

(instance timeBar of pointBar
	(properties
		x 293
		loop 10
		max 10
	)

	(method (draw)
		(super draw:)
		(if (== valCel 10)
			(candleFlame setCycle: Fwd)
		)
		(if (> valCel 2)
			(candleFlame posn: (+ x 2) (+ y (- 17 valCel)))
		else
			(candleFlame posn: 500 500 setCycle: 0 stopUpd:)
		)
	)
)

(instance candleFlame of Prop
	(properties
		x 500
		y 500
		view 32
		loop 11
		cycleSpeed 16
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
		(objectList release: dispose:)
		(if script
			(script dispose:)
		)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: gCast gFeatures)
		(gTheIconBar enable:)
		(gTheIconBar enable: 1 2 3 4 5 6 7 8)
		(ClearFlag 359)
		(if (HaveMouse)
			(gGame setCursor: gNormalCursor 1)
		else
			(gGame setCursor: gNormalCursor 1 304 174)
		)
		(Joystick 12 0)
		(LoadMany 0 238 205 810 976)
		(DisposeScript 956)
		(super dispose:)
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(LoadMany rsSCRIPT 238 205 810)
		(LoadMany rsVIEW 32 33 803)
		Cat
		ForwardCounter
		(super init:)
		(gTheIconBar disable: 1 2 3 4 5 6 7 8)
		(gGame setCursor: 942 1)
		(SetFlag 359)
		(++ global417)
		(SolvePuzzle 616 5 1)
		(= local14 1)
		(gMouseDownHandler add: gCast gFeatures)
		(candleFlame init: stopUpd:)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(repeat
				(if (not [local15 (= temp2 (Random 0 7))])
					(break)
				)
			)
			(= temp3 [local47 (= temp1 (+ temp2 temp2 temp2))])
			(= temp4 [local47 (+ temp1 1)])
			((= [local15 temp2] (Rock new:))
				listIndex: temp2
				view: 32
				setLoop: 3
				setCel: 0
				setPri: 6
				x: temp3
				y: temp4
				ignoreActors: 1
				init:
				stopUpd:
			)
		)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(repeat
				(if (not [local23 (= temp2 (Random 0 13))])
					(break)
				)
			)
			(= temp1 (+ temp2 temp2 temp2))
			((= [local23 temp2] (Fetchable new:))
				listIndex: (+ temp2 8)
				fetchType: 2
				view: 32
				setLoop: 4
				setCel: [local71 (+ temp1 2)]
				setPri: 1
				ignoreActors: 1
				posn: [local71 temp1] [local71 (+ temp1 1)]
				init:
				stopUpd:
			)
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			(repeat
				(if (not [local40 (= temp2 (Random 0 4))])
					(break)
				)
			)
			(= temp1 (+ temp2 temp2 temp2))
			((= [local40 temp2] (Fetchable new:))
				listIndex: (+ temp2 25)
				fetchType: 1
				view: 32
				setLoop: 5
				setCel: [local122 (+ temp1 2)]
				setPri: 1
				ignoreActors: 1
				posn: [local122 temp1] [local122 (+ temp1 1)]
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
		(= global257 0)
		(timeBar init:)
		(playerBug
			setLoop: 0
			setCycle: Fwd
			posn: 69 9
			lowPri:
			smarts: (/ (+ [gEgoStats 1] 5) 10) ; intelligence
			otherBug: wizBug
			path: 0
			init:
			baseSetter: baseCode
			setMotion: MazeMove [local143 4] [local143 5] playerBug
			setScript: timeScript
		)
		(wizBug
			setLoop: 3
			setCycle: Fwd
			posn: 289 6
			lowPri:
			otherBug: playerBug
			path: 12
			init:
			baseSetter: baseCode
			setMotion: MazeMove [local143 16] [local143 17] wizBug
			setScript: wizScript
		)
		(flame setPri: 15 init: setCycle: Fwd stopUpd:)
		(gameSound init: play:)
		(gUser canInput: 0)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(objectList add:)
		(= global188 1)
		(Joystick 12 30)
	)

	(method (cue &tmp temp0 temp1 [temp2 150])
		(cond
			(local11
				(gCurRoom newRoom: 31)
			)
			(local14
				(= local14 0)
				(gMessager say: 4 0 6 1) ; "The magic just isn't there."
			)
			((IsFlag 337)
				(= local11 1)
				(gMessager say: 4 0 4 1 self) ; "Too much for you? I guess you should work on your magic. Maybe next time you'll be more of a challenge."
			)
			(((wizBug mover:) completed:)
				(= local11 1)
				(gMessager say: 4 0 5 0 self) ; "Guess I still have the knack for the old Maze game."
			)
			((not (gEgo knows: 20)) ; dazzleSpell
				(= local11 1)
				(if (< (= temp0 (+ global417 global417)) 500)
					(= temp0 500)
				)
				(= temp1 (if (== global417 1) {} else {s}))
				(proc921_1
					@temp2
					{"Well, you seem to have beginner's luck.  It only took you %d game%s to win.  Hmph.  It usually takes at least %d tries for anyone less than a full Wizard to defeat me."}
					global417
					temp1
					temp0
				)
				(gEgo learn: 20 10) ; dazzleSpell
				(SolvePuzzle 617 12 1)
				(gMessager say: 4 0 2 0 self) ; "As I promised, I shall now teach you the spell known as 'Erasmus's Razzle Dazzle'."
			)
			(else
				(= local11 1)
				(gMessager say: 4 0 3 0 self) ; "Well! You don't have to rub it in, you know!"
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (!= local10 [gEgoStats 16]) ; mana
			(= local10 [gEgoStats 16]) ; mana
			(pointBar value: local10 draw:)
		)
		(if (and global257 (!= (= temp0 (GetTime 1)) local3)) ; SysTime12
			(= local3 temp0)
			(if (-- global257)
				(timeBar value: global257 draw:)
			else
				(localproc_5)
				(= global188 1)
				(wizGame setScript: 0)
			)
		)
		(if global188
			(= temp1 global188)
			(= global188 0)
			(switch temp1
				(1
					(self setScript: chooseSpell)
				)
				(2
					(self setScript: doASpell 0 24)
				)
				(3
					(self setScript: doASpell 0 17)
				)
				(4
					(self setScript: doASpell 0 19)
				)
				(5
					(self setScript: doFlame)
				)
			)
		)
		(super doit:)
	)
)

(instance timeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(if (gEgo has: 13) ; manaPotion
					(gMessager say: 1) ; "Click on the Magic Flask to drink a Magic Power Potion while playing the game."
				)
			)
		)
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
				(= temp1 (localproc_2 temp2 temp3 0 32 1))
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
						((> temp6 25))
						((and (< 0 temp1 8) [local15 temp1])
							(localproc_9 temp1)
							(if (== local4 17)
								(localproc_7 0 8)
							)
						)
						((and (< 8 temp1 25) (not [local15 temp1]))
							(localproc_6 temp1 8 25)
							(if (== local4 24)
								(if local0
									(localproc_8 8 25)
								else
									(localproc_7 8 25)
								)
							)
						)
						((< 25 temp1 32)
							(cond
								((not [local15 temp1])
									(localproc_6 temp1 25 32)
									(if (== local4 24)
										(if local1
											(localproc_8 25 32)
										else
											(localproc_7 25 32)
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

(instance objectList of InputList
	(properties)
)

(instance chooseSpell of Script
	(properties)

	(method (handleEvent event &tmp [temp0 3] temp3 temp4)
		(if (and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			(event type: evMOUSEBUTTON)
		)
		(cond
			((and (== (event message:) KEY_ESCAPE) (not (IsFlag 337)))
				(SetFlag 337)
				(= local14 0)
				(wizGame cue:)
				(self dispose:)
			)
			((<= JOY_UP (event message:) JOY_UPLEFT)
				(objectList handleEvent: event)
			)
			((== (event type:) evMOUSEBUTTON)
				(= temp3 (event x:))
				(= temp4 (event y:))
				(event claimed: 1)
				(cond
					((localproc_1 temp3 temp4 65 150 85 185)
						(if (<= [gEgoStats 16] 0) ; mana
							(if (not local14)
								(SetFlag 337)
								(self dispose:)
							)
							(wizGame cue:)
						else
							(= global187 0)
							(= global188 2)
							(self dispose:)
						)
						(return 1)
					)
					((localproc_1 temp3 temp4 112 154 132 184)
						(if (<= [gEgoStats 16] 0) ; mana
							(if (not local14)
								(SetFlag 337)
								(self dispose:)
							)
							(wizGame cue:)
						else
							(= global187 1)
							(= global188 3)
							(self dispose:)
						)
					)
					((localproc_1 temp3 temp4 172 168 192 198)
						(if (<= [gEgoStats 16] 0) ; mana
							(if (not local14)
								(SetFlag 337)
								(self dispose:)
							)
							(wizGame cue:)
						else
							(= global187 2)
							(= global188 4)
							(self dispose:)
						)
					)
					((localproc_1 temp3 temp4 215 155 235 190)
						(if (<= [gEgoStats 16] 0) ; mana
							(if (not local14)
								(SetFlag 337)
								(self dispose:)
							)
							(wizGame cue:)
						else
							(= global187 3)
							(= global188 5)
							(self dispose:)
						)
					)
					((localproc_1 temp3 temp4 7 158 43 188)
						(if (gEgo has: 13) ; manaPotion
							(= local14 1)
							(UseMana (- (/ (MaxMana) 2)))
							(gEgo use: 13) ; manaPotion
							(gEgo get: 11) ; flask
							(gTheIconBar disable: 6)
							(gMessager say: 2) ; "The drink burns as it goes down."
						else
							(gMessager say: 3) ; "You don't have a Magic Power Potion."
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (HaveMouse))
					(gGame setCursor: gTheCursor 1 [local221 global187] 175)
				)
				(objectList empty:)
				(localproc_0)
			)
		)
	)
)

(instance button1 of CursorCoords
	(properties
		cursorX 75
		cursorY 175
	)
)

(instance button2 of CursorCoords
	(properties
		cursorX 122
		cursorY 175
	)
)

(instance button3 of CursorCoords
	(properties
		cursorX 182
		cursorY 175
	)
)

(instance button4 of CursorCoords
	(properties
		cursorX 225
		cursorY 175
	)
)

(instance doASpell of Script
	(properties)

	(method (dispose)
		(objectList empty:)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((and (== (event message:) KEY_ESCAPE) (not (IsFlag 337)))
				(= local14 0)
				(SetFlag 337)
				(wizGame cue:)
				(event claimed: 1)
				(self dispose:)
			)
			((<= JOY_UP (event message:) JOY_UPLEFT)
				(objectList handleEvent: event)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (localproc_3 register)
					(switch register
						(17
							(localproc_7 0 8)
							(= register openSign)
							(register setCycle: End self)
						)
						(24
							(localproc_7 8 32)
							(= register fetchSign)
							(register setCycle: ForwardCounter 3 self)
						)
						(19
							(= register trigSign)
							(register setCycle: End self)
						)
					)
				else
					(= global188 1)
					(self dispose:)
				)
			)
			(1
				(register stopUpd:)
				(if (== register trigSign)
					(playerBug changeForm:)
					(localproc_5)
					(= global188 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance doFlame of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((and (== (event message:) KEY_ESCAPE) (not (IsFlag 337)))
				(= local14 0)
				(SetFlag 337)
				(wizGame cue:)
				(event claimed: 1)
				(self dispose:)
			)
			((<= JOY_UP (event message:) JOY_UPLEFT)
				(= temp1 [local225 (= temp3 (event message:))])
				(= temp2 [local234 temp3])
				(cond
					((and (<= (flame x:) 0) (< temp1 0))
						(= temp1 0)
					)
					((and (<= 319 (flame x:)) (< 0 temp1))
						(= temp1 0)
					)
					((and (<= (flame y:) 0) (< temp2 0))
						(= temp2 0)
					)
					((and (<= 189 (flame y:)) (< 0 temp2))
						(= temp2 0)
					)
				)
				(flame posn: (+ (flame x:) temp1) (+ (flame y:) temp2))
				(event claimed: 1)
			)
			((== (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(= global257 (+ 4 (/ [gEgoStats 23] 5))) ; flameDartSpell
				(flame posn: (event x:) (event y:) setCycle: Fwd)
				(= global188 1)
				(self dispose:)
			)
			((and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
				(flame setPri: -1)
				(event claimed: 1)
				(= global257 (+ 4 (/ [gEgoStats 23] 5))) ; flameDartSpell
				(= global188 1)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (localproc_3 23)
					(HandsOff)
					(= global257 0)
					(gGame setCursor: gNormalCursor 1)
					(flameSign setCycle: End self)
				else
					(= global188 1)
					(self dispose:)
				)
			)
			(1
				(flameSign stopUpd:)
				(HandsOn)
				(User canInput: 0)
				(gGame setCursor: gNormalCursor 1)
				(flame posn: 225 170 setCycle: Fwd)
			)
		)
	)
)

(instance baseCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(param1
			brTop: (- temp1 2)
			brBottom: (+ temp1 2)
			brLeft: (- temp0 2)
			brRight: (+ temp0 2)
		)
	)
)

