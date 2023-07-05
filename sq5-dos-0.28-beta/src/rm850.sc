;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Window)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm850 0
	dTalker 1
	quirkTalker 14
	rogerTalker 15
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = -1
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
	local23
	local24
	local25
	local26
	[local27 2]
	local29 = 2
	local30
	local31
	local32
	[local33 30] = [9 5 3 5 0 0 0 0 0 0 0 0 6 7 8 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	[local63 16] = [-6934 -10288 -20914 -16720 17632 -29056 -7104 11808 17472 3584 17472 3584 20032 20032 20032 20032]
	[local79 6] = [120 134 158 150 190 120]
	[local85 300]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (* (/ gMouseX 9) 9) 2))
	(= temp1 (- (* (/ gMouseY 8) 8) 3))
	(= temp2 0)
	(= temp3 0)
	(switch param1
		(1
			(= temp3 -1)
		)
		(5
			(= temp3 1)
		)
		(3
			(= temp2 1)
		)
		(7
			(= temp2 -1)
		)
		(2
			(= temp2 1)
			(= temp3 -1)
		)
		(8
			(= temp2 -1)
			(= temp3 -1)
		)
		(4
			(= temp2 1)
			(= temp3 1)
		)
		(6
			(= temp2 -1)
			(= temp3 1)
		)
	)
	(*= temp2 9)
	(*= temp3 8)
	(SetCursor (+ temp0 temp2) (+ temp1 temp3))
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= [local33 (+ temp0 param1)]
		(+ [local33 (+ (= temp0 (if (== param2 0) 4 else 8)) param1)] 1)
	)
	(return (== [local33 param1] [local33 (+ temp0 param1)]))
)

(procedure (localproc_2)
	(gGame handsOn:)
	(gTheIconBar disable: 0 3 4 5 6)
	((gTheIconBar at: 2) cursor: 999)
	(gTheIconBar curIcon: (gTheIconBar at: 2))
)

(procedure (localproc_3 param1)
	(return (<= [local33 param1] [local33 (+ param1 4)]))
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0 temp1)
	(for ((= temp0 (- param1 1))) (<= temp0 (+ param1 1)) ((++ temp0))
		(for ((= temp1 (- param2 1))) (<= temp1 (+ param2 1)) ((++ temp1))
			(if
				(and
					(or (== temp1 param2) (== temp0 param1))
					(InRect 0 0 9 9 temp0 temp1)
					(not (& $0008 (localproc_8 temp0 temp1 param3 0)))
				)
				(= local22 temp0)
				(= local23 temp1)
				(= local24 param3)
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp2 0)) (< temp2 3) ((++ temp2))
		(for ((= temp0 0)) (<= temp0 9) ((++ temp0))
			(for ((= temp1 0)) (<= temp1 9) ((++ temp1))
				(if
					(and
						(>
							(&
								$000f
								(= temp3 (localproc_8 temp0 temp1 temp2 0))
							)
							8
						)
						(not (localproc_3 (- (& $0007 temp3) 1)))
						(localproc_4 temp0 temp1 temp2)
					)
					(return 1)
				)
			)
		)
	)
	(return 0)
)

(procedure (localproc_6 &tmp [temp0 3] temp3 temp4)
	(if (localproc_5)
		(= local13 local22)
		(= local12 local23)
	else
		(repeat
			(= local13 (* (Random 0 4) 2))
			(if (& (= local12 (Random 0 9)) $0001)
				(++ local13)
			)
			(= local24 (Random 0 2))
			(if
				(not
					(& $0008 (= temp3 (localproc_8 local13 local12 local24 0)))
				)
				(break)
			)
		)
	)
	(return local24)
)

(procedure (localproc_7 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0 -32768)
	(*= param2 4)
	(>>= temp0 (+ param1 param2))
	(= temp1 [local63 (+ (* param3 4) param4)])
	(return (& [local63 (+ (* param3 4) param4)] temp0))
)

(procedure (localproc_8 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0 (+ (* param3 50) (* param2 5) (/ param1 2)))
	(= temp1 (if (& param1 $0001) 255 else -256))
	(= temp0 (& [local85 (+ param4 temp0)] temp1))
	(return
		(if (& param1 $0001)
			temp0
		else
			(>> temp0 $0008)
		)
	)
)

(procedure (localproc_9 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
	(= temp0 (+ (* param3 50) (* param2 5) (/ param1 2)))
	(= temp1 (if (& param1 $0001) -256 else 255))
	(= [local85 (+ param4 temp0)] (& [local85 (+ param4 temp0)] temp1))
	(&= param5 $00ff)
	(= temp1
		(if (& param1 $0001)
			param5
		else
			(<< param5 $0008)
		)
	)
	(= [local85 (+ param4 temp0)] (| [local85 (+ param4 temp0)] temp1))
)

(procedure (localproc_10 &tmp temp0)
	(for ((= temp0 0)) (< temp0 300) ((++ temp0))
		(= [local85 temp0] 0)
	)
)

(procedure (localproc_11 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(if (localproc_7 temp1 temp0 param1 param2)
				(cond
					(
						(not
							(InRect
								0
								0
								9
								9
								(- (+ temp1 param4) 1)
								(- (+ temp0 param5) 1)
							)
						)
						(return 0)
					)
					(
						(localproc_8
							(- (+ temp1 param4) 1)
							(- (+ temp0 param5) 1)
							param3
							param6
						)
						(return 0)
					)
				)
			)
		)
	)
	(return 1)
)

(procedure (localproc_12 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(if (localproc_7 temp1 temp0 param1 param2)
				(localproc_9
					(- (+ temp1 param4) 1)
					(- (+ temp0 param5) 1)
					param3
					param6
					param7
				)
			)
		)
	)
)

(procedure (localproc_13)
	(shipSelector loop: (+ local8 6))
	(= local11
		(switch local8
			(0 ship1)
			(1 ship2)
			(2 ship3)
			(3 ship4)
		)
	)
	(if (local11 inPlace:)
		(specialCursor view: 999 loop: 0 cel: 0)
		(= local11 0)
	else
		(specialCursor
			view: (local11 view:)
			loop: (local11 loop:)
			setCel: (local11 cel:)
		)
	)
)

(procedure (localproc_14 &tmp temp0 temp1)
	(= temp0 0)
	(for ((= temp1 1)) (< temp0 10) ((++ temp1))
		(DrawCel 537 temp1 0 (+ 114 (* temp0 9)) 89 14)
		(++ temp0)
	)
	(= temp0 0)
	(for ((= temp1 1)) (< temp0 10) ((++ temp1))
		(DrawCel 539 temp1 0 106 (+ 97 (* temp0 8)) 14)
		(++ temp0)
	)
	(Graph grUPDATE_BOX 88 115 95 205 1)
	(Graph grUPDATE_BOX 97 106 176 113 1)
)

(procedure (localproc_15 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(for ((= temp1 0)) (< temp1 10) ((++ temp1))
			(cond
				((& (= temp2 (localproc_8 temp1 temp0 param1 param2)) $0008)
					(if (& temp2 $0007)
						(= temp3 0)
					else
						(= temp3 1)
					)
					(DrawCel
						537
						12
						temp3
						(+ 115 (* temp1 9))
						(+ 97 (* temp0 8))
						14
					)
				)
				((& temp2 $0010)
					(DrawCel 537 12 2 (+ 115 (* temp1 9)) (+ 97 (* temp0 8)) 14)
				)
			)
		)
	)
)

(procedure (localproc_16 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(for ((= temp1 (- param2 2))) (< temp1 (+ param2 2)) ((++ temp1))
		(for ((= temp0 (- param1 2))) (< temp0 (+ param1 2)) ((++ temp0))
			(= temp2 (localproc_8 temp0 temp1 param3 param4))
			(if (and (InRect 0 0 9 9 temp0 temp1) (& temp2 $0007))
				(|= temp2 $0010)
				(localproc_9 temp0 temp1 param3 param4 temp2)
			)
		)
	)
)

(procedure (localproc_17 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp3 0)) (< temp3 3) ((++ temp3))
		(for ((= temp1 0)) (< temp1 10) ((++ temp1))
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(if (& (= temp2 (localproc_8 temp0 temp1 temp3 150)) $0007)
					(localproc_9 temp0 temp1 temp3 150 (| temp2 $0010))
				)
			)
		)
	)
)

(procedure (localproc_18 &tmp temp0 temp1 temp2 temp3 temp4)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(repeat
			(= temp3 (Random 0 9))
			(= temp4 (Random 0 9))
			(= temp2 (Random 0 2))
			(= temp1 (Random 0 3))
			(if (localproc_11 temp0 temp1 temp2 temp3 temp4 150)
				(localproc_12 temp0 temp1 temp2 temp3 temp4 150 (+ temp0 1))
				(= [local33 (+ 16 temp0)] temp1)
				(= [local33 (+ 20 temp0)] (+ (* (+ temp3 13) 9) 2))
				(= [local33 (+ 24 temp0)] (- (* (+ temp4 13) 8) 3))
				(break)
			)
		)
	)
)

(procedure (localproc_19 param1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
		(if
			(and
				((= temp1 (gCast at: temp0)) isKindOf: Ship)
				(temp1 inPlace:)
			)
			(if (== (temp1 lev:) param1)
				(temp1 show: startUpd:)
				(if (== argc 1)
					(temp1 setScale: ShipScaler)
				)
			else
				(temp1 hide:)
			)
		)
	)
)

(class ShipChunk of Actor
	(properties
		view 533
		priority 13
		signal 22544
		moveSpeed 1
	)

	(method (init param1 param2)
		(self x: param1 y: param2)
		(super init: &rest)
		(self setCycle: Fwd setMotion: MoveFwd 50 self)
	)

	(method (cue)
		(self dispose:)
	)
)

(class Ship of Prop
	(properties
		z 50
		view 538
		priority 13
		signal 20504
		scaleSignal 1
		shipNum -1
		col -1
		row -1
		lev -1
		inPlace 0
	)

	(method (onMe)
		(if
			(or
				(not (InRect 116 97 206 177 gMouseX gMouseY))
				(!= (gTheIconBar curIcon:) (gTheIconBar at: 2))
			)
			(super onMe: &rest)
		else
			(return
				(and
					(<= nsLeft (specialCursor x:) nsRight)
					(<= nsTop (specialCursor y:) nsBottom)
					(self isNotHidden:)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(if (== local31 0)
						(if (not local11)
							(= local8 shipNum)
							(= inPlace 0)
							(self hide:)
							(= local11 self)
							(localproc_12 shipNum cel lev col row 0 0)
							(localproc_13)
						else
							(grid doVerb: 4)
						)
					)
				)
				(else
					(gMessager say: noun 0 0 0)
				)
			)
		else
			(gMessager say: noun 0 0 0)
		)
	)

	(method (normalize)
		(self
			x: (+ (* (+ col 13) 9) 2)
			y: (+ (- (* (+ row 13) 8) 3) z)
			scaleX: 128
			scaleY: 128
		)
	)

	(method (place)
		(if (localproc_11 shipNum cel lev col row 0)
			(self inPlace: 1 show: normalize:)
			(localproc_12 shipNum cel lev col row 0 (+ shipNum 1))
			(= local11 0)
		)
	)

	(method (doit)
		(cond
			((and (== local31 3) (== local32 0))
				(self hide:)
			)
			((or (== local11 self) (not (gUser canControl:))) 0)
			((and inPlace (== local5 lev) (not (self isNotHidden:)))
				(self show:)
			)
			((and (!= local5 lev) (self isNotHidden:))
				(self hide:)
			)
		)
		(super doit: &rest)
	)
)

(instance rm850 of Rm
	(properties
		noun 13
		picture 75
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(return 1)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_14)
			(localproc_15 local5 (if (== local32 0) 150 else 0))
		)
		(super doit: &rest)
	)

	(method (init)
		(quirkHead init:)
		(gSq5Music1 number: 27 vol: 127 loop: -1 play:)
		(LoadMany rsVIEW 537 531 538 539 533)
		(LoadMany rsSOUND 202 203 27)
		(super init: &rest)
		(cheat1f init: setOnMeCheck: 26505)
		(cheat2f init: setOnMeCheck: 26505)
		(gDirectionHandler addToFront: controlBar)
		(self overlay: 175 setScript: playGame)
	)

	(method (dispose)
		((gTheIconBar at: 2) cursor: 982)
		(gDirectionHandler delete: controlBar)
		(controlBar dispose:)
		(DisposeScript 951)
		(super dispose: &rest)
	)
)

(class Bar of EventHandler
	(properties
		curButton 0
		selectCount 0
		initialized 0
	)

	(method (select param1)
		(curButton setCel: 0)
		(if (and argc param1)
			(param1 setCel: 1)
			(= curButton param1)
			(gSq5Music2 number: 124 loop: 1 play:)
			(= selectCount 1)
		else
			(= curButton 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp1 ((gTheIconBar curIcon:) message:))
		(cond
			((and selectCount (& (event type:) $4002)) ; evVERB | evMOUSERELEASE
				(self highLight: curButton)
				(= selectCount 0)
				(event claimed: 1)
			)
			(
				(or
					(event claimed:)
					(not (gUser canControl:))
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				0
			)
			((& (event type:) $0040) ; direction
				(localproc_0 (event message:))
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(& (event type:) $4001) ; evVERB | evMOUSEBUTTON
					(InRect 116 97 206 177 event)
					(!= local31 1)
				)
				(return 0)
			)
			((and (& (event type:) $4001) (not selectCount)) ; evVERB | evMOUSEBUTTON
				(if (= temp0 (self firstTrue: #onMe event))
					(self select: temp0)
					(temp0 doVerb: temp1)
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			((& (event type:) $4004) ; evVERB | evKEYBOARD
				(switch (event message:)
					(KEY_RETURN
						(if (= temp0 (self firstTrue: #onMe event))
							(self select: temp0)
							(temp0 doVerb: temp1)
							(self highLight: curButton)
							(= selectCount 0)
							(event claimed: 1)
						else
							(event claimed: 0)
						)
					)
					(KEY_SHIFTTAB
						(self retreat:)
						(event claimed: 1)
					)
					(KEY_TAB
						(self advance:)
						(event claimed: 1)
					)
				)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)

	(method (hide)
		(self eachElementDo: #hide)
	)

	(method (show)
		(self eachElementDo: #show)
	)

	(method (advance &tmp temp0 temp1)
		(= temp0 (self indexOf: curButton))
		(if (== (++ temp0) size)
			(= temp0 0)
		)
		(= temp1 (self at: temp0))
		(SetCursor (+ (temp1 x:) 3) (+ (temp1 y:) 3))
		(= gMouseX (+ (temp1 x:) 3))
		(= gMouseY (+ (temp1 y:) 3))
	)

	(method (retreat &tmp temp0 temp1)
		(= temp0 (self indexOf: curButton))
		(if (== (-- temp0) -1)
			(= temp0 (- size 1))
		)
		(= temp1 (self at: temp0))
		(SetCursor (+ (temp1 x:) 3) (+ (temp1 y:) 3))
		(= gMouseX (+ (temp1 x:) 3))
		(= gMouseY (+ (temp1 y:) 3))
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(not selectCount)
				(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				(gUser canControl:)
				(= temp0 (self firstTrue: #onMe gMouseX (- gMouseY 10)))
			)
			(self highLight: temp0)
		)
	)

	(method (highLight param1)
		(curButton highLight:)
		(if (and argc param1)
			(param1 highLight: 1)
			(= curButton param1)
		else
			(= curButton 0)
		)
	)

	(method (init)
		(if (not initialized)
			(super init: &rest)
			(gTheDoits addToFront: self)
			(gMouseDownHandler addToFront: self)
			(gKeyDownHandler addToFront: self)
			(= initialized 1)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance controlBar of Bar
	(properties)

	(method (init)
		(super init:)
		(self release:)
		(switch local31
			(0
				(playBut dispose:)
				(directionBut dispose:)
				(self
					add:
						nextBut
						rotateBut
						doneBut
						sector1But
						sector2But
						sector3But
						quitBut
					curButton: sector1But
				)
			)
			(1
				(self add: playBut directionBut curButton: playBut)
			)
			(else
				(switch local32
					(150
						(self add: doneBut)
						(weaponBut dispose:)
						(probeBut dispose:)
						(numProbes startUpd: dispose: delete:)
						(firePanel startUpd: dispose: delete:)
					)
					(0
						(doneBut dispose:)
						(self add: weaponBut)
						(weaponBut init: current: 1)
						(if local29
							(probeBut init: current: 0)
							(self add: probeBut)
							(numProbes init: stopUpd:)
						else
							(probeBut startUpd: dispose: delete:)
							(numProbes startUpd: dispose: delete:)
						)
						(firePanel init: stopUpd:)
					)
				)
				(nextBut dispose:)
				(rotateBut dispose:)
				(shipSelector dispose:)
				(self
					add: sector1But sector2But sector3But quitBut
					curButton: sector1But
				)
				(= local11 0)
			)
		)
		(self eachElementDo: #init)
	)
)

(class Button of View
	(properties
		view 538
		priority 14
		signal 16400
		current 0
	)

	(method (init)
		(self setCel: (if current 3 else 0))
		(super init: &rest)
	)

	(method (highLight &tmp temp0 temp1)
		(if argc
			(= temp0 argc)
		else
			(= temp0 0)
		)
		(= temp1 (+ (if temp0 2 else 0) (if current 3 else 0)))
		(self setCel: temp1)
	)

	(method (handleEvent event &tmp temp0)
		(if (== (event message:) JOY_DOWNRIGHT)
			(controlBar handleEvent: event)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doit)
		(cond
			((and current (< cel 3))
				(self setCel: (+ cel 3))
			)
			((and (not current) (> cel 2))
				(self setCel: (- cel 3))
			)
		)
		(super doit: &rest)
	)
)

(instance doneBut of Button
	(properties
		x 73
		y 174
		noun 3
		loop 3
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(cond
						((== local31 3)
							(if (== local32 150)
								(quirksTurn cue:)
							else
								(rogersTurn cue:)
							)
						)
						(
							(and
								(ship1 inPlace:)
								(ship2 inPlace:)
								(ship3 inPlace:)
								(ship4 inPlace:)
							)
							((gCurRoom script:) cue:)
						)
						(else
							(gMessager say: noun 4 1 0) ; "You must place all your ships on the game grid before you can continue."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sector1But of Button
	(properties
		x 206
		y 104
		noun 15
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(grid setScript: changeGrid 0 0)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (doit)
		(= current (== local5 0))
		(super doit: &rest)
	)
)

(instance sector2But of Button
	(properties
		x 206
		y 116
		noun 16
		loop 1
	)

	(method (doit)
		(= current (== local5 1))
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(grid setScript: changeGrid 0 1)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance sector3But of Button
	(properties
		x 206
		y 128
		noun 17
		loop 2
	)

	(method (doit)
		(= current (== local5 2))
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(grid setScript: changeGrid 0 2)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance nextBut of Button
	(properties
		x 73
		y 115
		noun 7
		loop 11
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(= local8 (mod (-- local8) 4))
					(localproc_13)
					(grid setScript: showShip)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance quitBut of Button
	(properties
		x 73
		y 104
		noun 11
		loop 12
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(grid setScript: iQuit)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance playBut of Button
	(properties
		x 140
		y 120
		view 539
		loop 11
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(= local31 0)
					((gCurRoom script:) cue:)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance directionBut of Button
	(properties
		x 140
		y 135
		view 539
		loop 12
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(= local31 2)
					((gCurRoom script:) cue:)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance rotateBut of Button
	(properties
		x 73
		y 126
		noun 14
		loop 10
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(if (and local11 (not (local11 inPlace:)))
						(local11 setCel: (mod (- (local11 cel:) 1) 4))
						(specialCursor
							view: (local11 view:)
							loop: (local11 loop:)
							cel: (local11 cel:)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance weaponBut of Button
	(properties
		x 212
		y 149
		noun 18
		loop 14
		current 1
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(= current 1)
					(probeBut current: 0)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance probeBut of Button
	(properties
		x 212
		y 162
		noun 9
		loop 15
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(= current 1)
					(weaponBut current: 0)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance numProbes of View
	(properties
		x 217
		y 173
		noun 8
		view 538
		loop 13
		priority 14
		signal 22544
	)

	(method (init)
		(self setCel: local29)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(return 1)
		)
	)
)

(instance firePanel of View
	(properties
		x 209
		y 142
		noun 4
		view 538
		loop 12
		cel 3
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(return 1)
		)
	)
)

(instance lines of View
	(properties
		x 115
		y 97
		noun 5
		view 538
		loop 4
		cel 3
		priority 13
		signal 18448
	)

	(method (doit)
		(if (!= loop (grid loop:))
			(self setLoop: (grid loop:))
		)
		(cond
			((>= (grid scaleX:) 127)
				(self x: (grid x:) y: (grid y:))
				(if (and (not (self isNotHidden:)) (grid isNotHidden:))
					(self show:)
				)
			)
			((self isNotHidden:)
				(self hide:)
			)
		)
	)

	(method (doVerb)
		(grid doVerb: &rest)
	)
)

(instance grid of Actor
	(properties
		x 115
		y 97
		noun 5
		yStep 6
		view 538
		loop 4
		priority 12
		signal 18448
		scaleSignal 5
		scaleX 127
		scaleY 127
		cycleSpeed 20
		xStep 8
		moveSpeed 0
	)

	(method (init)
		(if (== local31 0)
			(self setLoop: 4 posn: 120 134 scaleX: 10 scaleY: 10)
		else
			(if (== local32 0)
				(self setLoop: 5)
			else
				(self setLoop: 4)
			)
			(self
				x: [local79 (* local5 2)]
				y: [local79 (+ (* local5 2) 1)]
				scaleX: 10
				scaleY: 10
			)
		)
		(super init: &rest)
	)

	(method (hide)
		(lines hide:)
		(super hide: &rest)
	)

	(method (doVerb theVerb)
		(if (gUser canControl:)
			(switch theVerb
				(4 ; Do
					(cond
						((== local31 0)
							(if
								(and
									local11
									(InRect
										116
										97
										206
										177
										gMouseX
										(- gMouseY 10)
									)
								)
								(local11 place:)
							)
						)
						(
							(and
								(not script)
								(== local32 0)
								(InRect
									116
									97
									206
									177
									gMouseX
									(- gMouseY 10)
								)
							)
							(cond
								(
									(&
										$0008
										(localproc_8
											local13
											local12
											local5
											(if (== local32 0) 150 else 0)
										)
									)
									(gMessager say: noun 4 2 0) ; "You've already fired on that spot."
								)
								((weaponBut current:)
									(self setScript: fire)
								)
								(local29
									(self setScript: launchProbe)
								)
							)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance ship1 of Ship
	(properties
		noun 19
		loop 6
		shipNum 0
	)
)

(instance ship2 of Ship
	(properties
		noun 20
		loop 7
		shipNum 1
	)
)

(instance ship3 of Ship
	(properties
		noun 21
		loop 8
		shipNum 2
	)
)

(instance ship4 of Ship
	(properties
		noun 22
		loop 9
		shipNum 3
	)
)

(instance logo of View
	(properties
		x 118
		y 118
		view 537
		priority 14
		signal 16400
		scaleSignal 1
	)

	(method (doit)
		(self x: (- 160 (/ (- nsRight nsLeft) 2)))
		(super doit: &rest)
	)
)

(instance shipSelector of View
	(properties
		x 87
		y 149
		noun 1
		view 538
		loop 6
		priority 13
		signal 20496
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(return 1)
		)
	)

	(method (doit)
		(if (and local11 (!= cel (local11 cel:)))
			(self setCel: (local11 cel:))
		)
		(super doit: &rest)
	)
)

(instance extra1 of Actor
	(properties
		x 277
		y 162
		view 538
		loop 7
		cel 3
		priority 8
		signal 22544
	)
)

(instance extra2 of Actor
	(properties
		view 537
		loop 12
		cel 1
		priority 14
		signal 22544
	)
)

(instance chunk1 of ShipChunk
	(properties
		loop 1
	)
)

(instance chunk2 of ShipChunk
	(properties
		heading 60
		loop 2
	)
)

(instance chunk3 of ShipChunk
	(properties
		heading 120
		loop 3
	)
)

(instance chunk4 of ShipChunk
	(properties
		heading 180
		loop 4
	)
)

(instance chunk5 of ShipChunk
	(properties
		heading 240
		loop 5
	)
)

(instance chunk6 of ShipChunk
	(properties
		heading 320
		loop 6
	)
)

(instance hitMiss of Prop
	(properties
		y 93
		view 537
		loop 13
		priority 14
		signal 22544
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(return 1)
		)
	)

	(method (init param1)
		(if (and argc param1)
			(self setLoop: 14 cel: 1 posn: 83 93)
		else
			(self setLoop: 13 cel: 1 posn: 211 93)
		)
		(super init: &rest)
	)
)

(instance quirkHead of Prop
	(properties
		x 139
		y -2
		view 531
		priority 1
		signal 22544
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb &rest)
		else
			(return 1)
		)
	)

	(method (show param1)
		(switch local30
			(0
				(self setLoop: 0 x: 139 y: -2)
			)
			(2
				(self setLoop: 1 x: 143 y: -5)
			)
			(1
				(self setLoop: 2 x: 134 y: -5)
			)
		)
		(super show: &rest)
	)
)

(instance specialCursor of View
	(properties
		view 999
		priority 15
		signal 20496
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(cond
			((and (not (gUser canControl:)) (self isNotHidden:))
				(self hide:)
			)
			((== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				(= temp2 gMouseX)
				(= temp3 (- gMouseY 10))
				(if (InRect 116 97 206 177 temp2 temp3)
					(if (!= ((gTheIconBar at: 2) cursor:) 996)
						((gTheIconBar at: 2) cursor: 996)
						(gTheIconBar curIcon: (gTheIconBar at: 2))
						(gGame setCursor: 996)
					)
					(if (< (= temp0 (/ (+ temp2 1) 9)) 13)
						(= temp0 13)
					)
					(if (> temp0 22)
						(= temp0 22)
					)
					(if (< (= temp1 (/ (+ temp3 7) 8)) 13)
						(= temp1 13)
					)
					(if (> temp1 22)
						(= temp1 22)
					)
					(= local13 (- temp0 13))
					(= local12 (- temp1 13))
					(if local11
						(if
							(localproc_11
								local8
								cel
								local5
								(- temp0 13)
								(- temp1 13)
								0
							)
							(self
								show:
								x: (+ (* temp0 9) 2)
								y: (- (* temp1 8) 3)
							)
							(local11 col: local13 row: local12 lev: local5)
						)
					else
						(self
							view: 999
							show:
							x: (+ (* temp0 9) 2)
							y: (- (* temp1 8) 3)
						)
					)
				else
					(if (!= ((gTheIconBar at: 2) cursor:) 999)
						((gTheIconBar at: 2) cursor: 999)
						(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					)
					(self hide:)
				)
			)
			(else
				(if (!= ((gTheIconBar at: 2) cursor:) 999)
					((gTheIconBar at: 2) cursor: 999)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				)
				(self hide:)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb)
		(grid doVerb: 4)
	)
)

(instance changeGrid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client grid)
					(gGame handsOff:)
				)
				(if (== local5 register)
					(if (== client grid)
						(localproc_2)
					)
					(self dispose:)
				else
					(if (> register 3)
						(-= register 10)
					)
					(grid startUpd:)
					(lines startUpd:)
					(if (or (== local32 150) (== local31 0))
						(ship1 startUpd:)
						(ship2 startUpd:)
						(ship3 startUpd:)
						(ship4 startUpd:)
					)
					(= cycles 2)
				)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(if (or (== local32 150) (== local31 0))
					(localproc_19 local5)
				)
				(if (< (gGame _detailLevel:) 3)
					(grid setScale: 0 scaleX: 128 scaleY: 128 posn: 115 97)
					(= cycles 1)
				else
					(grid
						setMotion:
							MoveTo
							[local79 (* local5 2)]
							[local79 (+ (* local5 2) 1)]
							self
						setScale:
							gridScaler
							100
							10
							97
							[local79 (+ (* local5 2) 1)]
					)
				)
			)
			(3
				(grid hide:)
				(= cycles 2)
			)
			(4
				(= local9 (Graph grSAVE_BOX 97 115 178 206 1))
				(= cycles 2)
			)
			(5
				(= local5 register)
				(grid show: setCel: local5)
				(if (< (gGame _detailLevel:) 3)
					(grid posn: 115 97 setScale: 0)
					(= cycles 3)
				else
					(grid
						posn:
							[local79 (* local5 2)]
							[local79 (+ (* local5 2) 1)]
						setMotion: MoveTo 115 97 self
						setScale:
							gridScaler
							100
							10
							97
							[local79 (+ (* local5 2) 1)]
					)
				)
				(if (or (== local32 150) (== local31 0))
					(localproc_19 local5)
				)
			)
			(6
				(lines show:)
				(if (or (== local32 150) (== local31 0))
					(ship1 setScale: 0 normalize: stopUpd:)
					(ship2 setScale: 0 normalize: stopUpd:)
					(ship3 setScale: 0 normalize: stopUpd:)
					(ship4 setScale: 0 normalize: stopUpd:)
				)
				(if (== local31 3)
					(localproc_15 local5 (if (== local32 0) 150 else 0))
				)
				(grid x: 115 y: 97 scaleX: 127 scaleY: 127 stopUpd:)
				(lines stopUpd:)
				(if (== client grid)
					(localproc_2)
				)
				(self dispose:)
			)
		)
	)
)

(instance showShip of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (== client grid)
					(gGame handsOff:)
				)
				(= temp0
					(switch local8
						(0 ship1)
						(1 ship2)
						(2 ship3)
						(3 ship4)
					)
				)
				(if (temp0 inPlace:)
					(self setScript: changeGrid self (temp0 lev:))
				else
					(if (== client grid)
						(localproc_2)
					)
					(self dispose:)
				)
			)
			(1
				(if (== client grid)
					(localproc_2)
				)
				(self dispose:)
			)
		)
	)
)

(instance shakeShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client startUpd:)
				(= cycles 3)
			)
			(1
				(= local20 (client x:))
				(= local21 (client y:))
				(= cycles 1)
			)
			(2
				(client
					x: (+ local20 (* (- (Random 0 2) 1) 1))
					y: (+ local21 (* (- (Random 0 2) 1) 1))
				)
				(-- state)
				(= cycles 1)
			)
		)
	)

	(method (dispose)
		(client x: local20 y: local21)
		(super dispose: &rest)
	)
)

(instance blowUpShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 538 533)
				(LoadMany rsSOUND 203)
				(if local11
					(extra1
						view: (local11 view:)
						loop: (local11 loop:)
						cel: (local11 cel:)
						x: (local11 x:)
						y: (- (local11 y:) (local11 z:))
						signal: 16400
						init:
					)
				else
					(extra1
						view: 538
						cel: [local33 (+ 15 (& local19 $0007))]
						signal: 16400
						loop: (+ 5 (& local19 $0007))
						x: [local33 (+ 19 (& local19 $0007))]
						y: [local33 (+ 23 (& local19 $0007))]
						init:
					)
				)
				(extra1 setPri: 15 setScript: shakeShip)
				(= seconds 4)
			)
			(1
				(gSq5Music2 number: 203 loop: 1 play:)
				(extra1
					view: 533
					loop: 0
					cel: 0
					cycleSpeed: 5
					setScript: 0
					setCycle: End self
				)
				(chunk1 init: (extra1 x:) (extra1 y:))
				(chunk2 init: (extra1 x:) (extra1 y:))
				(chunk3 init: (extra1 x:) (extra1 y:))
				(chunk4 init: (extra1 x:) (extra1 y:))
				(chunk5 init: (extra1 x:) (extra1 y:))
				(chunk6 init: (extra1 x:) (extra1 y:))
				(= seconds 4)
			)
			(2
				(extra1 dispose:)
			)
			(3
				(chunk1 dispose:)
				(chunk2 dispose:)
				(chunk3 dispose:)
				(chunk4 dispose:)
				(chunk5 dispose:)
				(chunk6 dispose:)
				(gMessager say: local2 0 local1 0 self)
			)
			(4
				(= register (if (== local32 150) 28 else 29))
				(if (== local32 0)
					(++ local29)
				)
				(if (== (+= [local33 register] 1) 4)
					(= local6 (if (== local32 0) 150 else 0))
				)
				(self dispose:)
			)
		)
	)
)

(instance launchProbe of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (== local32 0)
					(-- local29)
					(numProbes setCel: local29)
				)
				(= local11 0)
				(if (== client grid)
					(gGame handsOff:)
				)
				(= local16 local12)
				(= local17 local13)
				(extra1
					init:
					view: 537
					setLoop: 12
					cel: 1
					x: (+ 115 (* local17 9))
					y: 97
					setPri: 15
				)
				(extra2
					view: 537
					setLoop: 12
					cel: 1
					x: 115
					y: (+ 97 (* local16 8))
					init:
				)
				(gSq5Music2 number: 224 loop: -1 play:)
				(DrawCel 537 (+ local17 1) 1 (+ 114 (* local17 9)) 89 14)
				(DrawCel 539 (+ local16 1) 1 106 (+ 97 (* local16 8)) 14)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= local14 0)
				(= local15 0)
				(= cycles 2)
			)
			(1
				(if (!= local15 local17)
					(extra2 x: (+ (extra2 x:) 9) y: (+ 97 (* local16 8)))
					(++ local15)
					(= state 0)
				)
				(if (!= local14 local16)
					(extra1 x: (+ 115 (* local17 9)) y: (+ (extra1 y:) 8))
					(++ local14)
					(= state 0)
				)
				(= ticks 10)
			)
			(2
				(extra2 dispose:)
				(extra1 view: 537 setLoop: 15 cel: 0 setCycle: End self)
			)
			(3
				(DrawCel 537 (+ local17 1) 0 (+ 114 (* local17 9)) 89 14)
				(DrawCel 539 (+ local16 1) 0 106 (+ 97 (* local16 8)) 14)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= cycles 2)
			)
			(4
				(gSq5Music2 stop:)
				(localproc_16
					local13
					local12
					local5
					(if (== local32 0) 150 else 0)
				)
				(localproc_15 local5 (if (== local32 0) 150 else 0))
				(extra1 dispose:)
				(= seconds 4)
			)
			(5
				(if (== local32 0)
					(rogersTurn cue:)
				else
					(localproc_2)
				)
				(self dispose:)
			)
		)
	)
)

(instance fire of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local11 0)
				(if (== client grid)
					(gGame handsOff:)
				)
				(= local16 local12)
				(= local17 local13)
				(gSq5Music2 number: 657 loop: 1 play:)
				(extra1
					init:
					view: 537
					setLoop: 12
					cel: 1
					x: (+ 115 (* local17 9))
					y: 97
					setPri: 15
				)
				(extra2
					view: 537
					setLoop: 12
					setCel: 1
					init:
					setCycle: 0
					x: 115
					y: (+ 97 (* local16 8))
					setPri: 15
				)
				(DrawCel 537 (+ local17 1) 1 (+ 114 (* local17 9)) 89 14)
				(DrawCel 539 (+ local16 1) 1 106 (+ 97 (* local16 8)) 14)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= local14 0)
				(= local15 0)
				(= cycles 4)
			)
			(1
				(if (!= local15 local17)
					(extra2 x: (+ (extra2 x:) 9) y: (+ 97 (* local16 8)))
					(++ local15)
					(= state 0)
				)
				(if (!= local14 local16)
					(extra1 x: (+ 115 (* local17 9)) y: (+ (extra1 y:) 8))
					(++ local14)
					(= state 0)
				)
				(= ticks 5)
			)
			(2
				(if
					(&
						(= local19
							(localproc_8
								local17
								local16
								local5
								(if (== local32 0) 150 else 0)
							)
						)
						$0007
					)
					(if (== local32 150)
						(= local11
							(switch (- (& local19 $0007) 1)
								(0 ship1)
								(1 ship2)
								(2 ship3)
								(3 ship4)
							)
						)
						(local11 setScript: shakeShip)
					)
					(gSq5Music2 number: 202 loop: 1 play:)
					(hitMiss init: 1)
				else
					(hitMiss init: 0)
				)
				(extra2 dispose:)
				(extra1 setLoop: 11 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(extra1 setCycle: Beg self)
			)
			(4
				(if (and local11 (== local32 150))
					(local11 setScript: 0)
				)
				(hitMiss dispose:)
				(extra1 dispose:)
				(if (== local32 150)
					(= local2 12)
				else
					(= local2 10)
				)
				(if (& local19 $0007)
					(if
						(localproc_1
							(- (& local19 $0007) 1)
							(if (== local32 0) 150 else 0)
						)
						(= local1 [local33 (+ 11 (& local19 $0007))])
					else
						(= local1 4)
					)
				else
					(= local1 5)
				)
				(= cycles 4)
			)
			(5
				(DrawCel 537 (+ local17 1) 0 (+ 114 (* local17 9)) 89 14)
				(DrawCel 539 (+ local16 1) 0 106 (+ 97 (* local16 8)) 14)
				(Graph grUPDATE_BOX 88 115 95 205 1)
				(Graph grUPDATE_BOX 97 106 176 113 1)
				(= cycles 2)
			)
			(6
				(localproc_9
					local17
					local16
					local5
					(if (== local32 0) 150 else 0)
					(| local19 $0008)
				)
				(localproc_15 local5 (if (== local32 0) 150 else 0))
				(= cycles 4)
			)
			(7
				(if (OneOf local1 4 5)
					(= cycles 1)
				else
					(self setScript: blowUpShip self)
				)
			)
			(8
				(= local11 0)
				(quirkHead show: 0)
				(if (== local6 -1)
					(if (== local32 0)
						(rogersTurn cue:)
					else
						(localproc_2)
					)
				else
					(gCurRoom setScript: endGame)
				)
				(self dispose:)
			)
		)
	)
)

(instance quirksTurn of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 30])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local32 150)
				(grid startUpd: hide:)
				(firePanel startUpd: hide:)
				(numProbes startUpd: hide:)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(controlBar init: show:)
				(DrawPic 175 100 0)
				(= cycles 2)
			)
			(3
				(= local9 (Graph grSAVE_BOX 97 115 178 206 1))
				(= cycles 2)
			)
			(4
				(grid init: show:)
				(= local5 local3)
				(= temp0 (localproc_6))
				(self setScript: changeGrid self (+ temp0 10))
			)
			(5
				(ship1 stopUpd:)
				(ship2 stopUpd:)
				(ship3 stopUpd:)
				(ship4 stopUpd:)
				(self setScript: fire self)
			)
			(6
				(localproc_2)
			)
			(7
				(= local4 local5)
				(self dispose:)
			)
		)
	)
)

(instance rogersTurn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ship1 hide:)
				(ship2 hide:)
				(ship3 hide:)
				(ship4 hide:)
				(grid startUpd: hide:)
				(firePanel startUpd: show:)
				(numProbes startUpd: show:)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(= local32 0)
				(controlBar init: show:)
				(grid init: show:)
				(= local5 local3)
				(DrawPic 176 100 0)
				(= cycles 2)
			)
			(3
				(= local9 (Graph grSAVE_BOX 97 115 178 206 1))
				(= cycles 2)
			)
			(4
				(self setScript: changeGrid self (+ local3 10))
			)
			(5
				(localproc_2)
			)
			(6
				(= local3 local5)
				(self dispose:)
			)
		)
	)
)

(instance endGame of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ship1 hide:)
				(ship2 hide:)
				(ship3 hide:)
				(ship4 hide:)
				(grid startUpd: hide:)
				(firePanel startUpd: show:)
				(numProbes startUpd: show:)
				(= cycles 2)
			)
			(1
				(if local9
					(Graph grRESTORE_BOX local9)
					(Graph grREDRAW_BOX 97 115 178 206)
					(Graph grFILL_BOX 97 115 178 206 2 -1 0 -1)
				)
				(= cycles 4)
			)
			(2
				(if local6
					(SetScore 215 (* (- 4 [local33 28]) 25))
					(gMessager say: 12 2 11 0 self) ; "I WON. I WON. BWAHAHAHAHAHA"
				else
					(gMessager say: 10 2 11 0 self) ; "That was too easy Wilco, you really blow chunks at this game."
				)
			)
			(3
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance iQuit of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 10 2 10 0 self) ; "I knew you'd chicken out. You never had any guts, Wilco. It's why you'll always be a loser."
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance doDirections of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(playBut dispose:)
				(directionBut dispose:)
				(gCurRoom drawPic: 75 9)
				(= cycles 3)
			)
			(1
				(gMessager say: 2 0 0 0 self) ; "Battle Cruiser Objective: To seek out and destroy all four of your enemy's cloaked ships before your's are destroyed."
			)
			(2
				(= local31 0)
				(= gSystemWindow gSq5Win)
				(gCurRoom overlay: 175)
				(self dispose:)
			)
		)
	)
)

(instance playGame of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(logo init: scaleX: 0 scaleY: 0)
				(= seconds 2)
			)
			(1
				(if (< (logo scaleX:) 128)
					(logo
						scaleX: (+ (logo scaleX:) 3)
						scaleY: (+ (logo scaleY:) 3)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(= seconds 2)
			)
			(3
				(extra1
					init:
					setCycle: 0
					setStep: 4 4
					moveSpeed: 0
					setMotion: MoveTo 47 162 self
				)
			)
			(4
				(extra1 dispose:)
				(= cycles 1)
			)
			(5
				(if (> (logo scaleX:) 0)
					(logo
						scaleX: (- (logo scaleX:) 3)
						scaleY: (- (logo scaleY:) 3)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(gSq5Music1 fade: 5 10 0 0)
				(localproc_2)
				(logo dispose:)
				(= local31 1)
				(localproc_2)
				(controlBar init:)
			)
			(7
				(gGame handsOff:)
				(if (== local31 0)
					(= cycles 1)
				else
					(self setScript: doDirections self)
				)
			)
			(8
				(localproc_2)
				(controlBar init:)
				(lines init:)
				(localproc_10)
				(= local5 0)
				(grid init:)
				(changeGrid start: 1)
				(self setScript: changeGrid self 0)
				(changeGrid start: 0)
				(ship1 init:)
				(ship2 init:)
				(ship3 init:)
				(ship4 init:)
				(= local8 0)
				(= local11 ship1)
				(ship1 hide:)
				(shipSelector init:)
				(specialCursor init:)
				(localproc_14)
				(nextBut doVerb: 4)
				(= local31 0)
			)
			(9)
			(10
				(gGame handsOff:)
				(localproc_18)
				(= local31 3)
				(shipSelector dispose:)
				(= cycles 2)
			)
			(11
				(controlBar init:)
				(self setScript: rogersTurn self)
			)
			(12
				(controlBar init:)
				(self setScript: quirksTurn self)
			)
			(13
				(= cycles 2)
				(-= state 3)
			)
		)
	)
)

(instance gridScaler of Scaler
	(properties)

	(method (doit &tmp temp0 temp1)
		(cond
			((>= (= temp0 (client y:)) backY)
				(= temp1 backSize)
			)
			((<= temp0 frontY)
				(= temp1 frontSize)
			)
			(else
				(= temp1 (+ (/ (* slopeNum temp0) slopeDen) const))
			)
		)
		(= temp1 (/ (* temp1 128) 100))
		(client scaleX: temp1 scaleY: temp1)
	)
)

(class ShipScaler of Scaler
	(properties)

	(method (init param1)
		(= client param1)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (/ (* (grid scaleX:) (+ (* (client col:) 9) 1)) 128))
		(= temp1 (/ (* (grid scaleX:) (+ (* (client row:) 8) 3)) 128))
		(client
			x: (+ (grid x:) temp0 2)
			y: (+ (grid y:) temp1 (client z:) 1)
			scaleX: (grid scaleX:)
			scaleY: (grid scaleX:)
		)
	)
)

(instance rogerTalker of Narrator
	(properties
		talkWidth 100
	)

	(method (init)
		(= gSystemWindow gSpeakWindow)
		(= font gUserFont)
		(gSystemWindow tailX: 240 xOffset: 0 tailY: 150 isBottom: 1)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance quirkTalker of Talker
	(properties
		x 139
		y -2
		view 531
		talkWidth 120
	)

	(method (init)
		(= font gUserFont)
		(quirkHead startUpd: hide:)
		(switch global122
			(25
				(self loop: 0 x: 137 y: -2)
				(quirkMouth loop: 3 cel: 0 nsLeft: 22 nsTop: 24)
				(= local30 0)
			)
			(3
				(self loop: 1 x: 143 y: -5)
				(quirkMouth loop: 4 cel: 0 nsLeft: 12 nsTop: 30)
				(= local30 0)
			)
			(1
				(self loop: 2 x: 134 y: -5)
				(quirkMouth loop: 5 cel: 0 nsLeft: 18 nsTop: 27)
				(= local30 0)
			)
		)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 120 xOffset: -25 tailY: 40 isBottom: 0)
		(super init: 0 0 quirkMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(quirkHead show:)
		(super dispose: &rest)
	)
)

(instance quirkMouth of Prop
	(properties
		view 531
		loop 3
	)
)

(instance dTalker of Narrator
	(properties
		y 90
		talkWidth 160
		color 15
		back 0
	)

	(method (init)
		(= gSystemWindow (SysWindow new:))
		(self font: gUserFont)
		(super init: &rest)
	)

	(method (dispose)
		(if gSystemWindow
			(gSystemWindow dispose:)
		)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance cheat1f of Feature
	(properties
		nsTop 105
		nsLeft 31
		nsBottom 110
		nsRight 53
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (== local31 3) (== local32 0)) ; Look
			(= local25 (mod (++ local25) 3))
			(if (== 4 (+ local25 local26))
				(localproc_17)
			)
		)
	)
)

(instance cheat2f of Feature
	(properties
		nsTop 105
		nsLeft 266
		nsBottom 110
		nsRight 289
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (== local31 3) (== local32 0)) ; Look
			(= local26 (mod (++ local26) 3))
			(if (== 4 (+ local25 local26))
				(localproc_17)
			)
		)
	)
)

