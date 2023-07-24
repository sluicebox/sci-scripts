;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Array)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	swap 0
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
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if (== global439 1)
		(while (== (local4 at: (= temp0 (Random 0 11))) -1)
		)
	else
		(while (== (local4 at: (= temp0 (Random 0 19))) -1)
		)
	)
	(= temp1 (local4 at: temp0))
	(local4 at: temp0 -1)
	(return temp1)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (== global439 1)
		(= temp1 12)
	else
		(= temp1 20)
	)
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(if
			(or
				(!= ((local6 at: temp0) value:) ((local6 at: temp0) value3:))
				(and
					(!= ((local6 at: temp0) cel:) 0)
					(!= ((local6 at: temp0) cel:) 4)
				)
			)
			(return 0)
		)
	)
	(return 1)
)

(class SelectProp of Prop
	(properties
		signal 16385
	)

	(method (highlight))

	(method (select)
		(self doVerb:)
	)
)

(instance swap of PuzzleBar
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2])
		(ClearFlag 52)
		(= local4 (IntArray new: 20))
		(= local5 (IntArray new: 20))
		(= local6 (IntArray new: 20))
		(Load rsVIEW 389)
		(super init:)
		(= local0 (CelWide 383 0 0))
		(= local1 (CelHigh 383 0 0))
		(= local3
			(- (- (/ (- (plane right:) (plane left:)) 2) (/ (* local0 5) 2)) 4)
		)
		(self add: lock)
		(highLightCel init: puzzleCast hide:)
		(highLightCel2 init: puzzleCast hide:)
		(coverUp init: puzzleCast)
		(pointerCel init: puzzleCast hide:)
		(sideViewLeft init: puzzleCast)
		(sideViewRight init: puzzleCast)
		(if (== global439 1)
			(local5 at: 0 1)
			(local4 at: 0 1)
			(local5 at: 1 2)
			(local4 at: 1 2)
			(local5 at: 2 3)
			(local4 at: 2 3)
			(local5 at: 3 6)
			(local4 at: 3 6)
			(local5 at: 4 7)
			(local4 at: 4 7)
			(local5 at: 5 8)
			(local4 at: 5 8)
			(local5 at: 6 11)
			(local4 at: 6 11)
			(local5 at: 7 12)
			(local4 at: 7 12)
			(local5 at: 8 13)
			(local4 at: 8 13)
			(local5 at: 9 16)
			(local4 at: 9 16)
			(local5 at: 10 17)
			(local4 at: 10 17)
			(local5 at: 11 18)
			(local4 at: 11 18)
		else
			(for ((= temp0 0)) (< temp0 20) ((++ temp0))
				(local4 at: temp0 temp0)
			)
		)
		(= temp3 36)
		(if (== global439 1)
			(= temp5 12)
			(= temp6 3)
		else
			(= temp5 20)
			(= temp6 5)
		)
		(= temp0 0)
		(= temp1 -1)
		(while (< temp0 temp5)
			(if (mod temp0 temp6)
				(+= temp2 local0) ; UNINIT
			else
				(if (== global439 1)
					(= temp2 (+ local3 local0))
				else
					(= temp2 local3)
				)
				(= temp3 (+ 36 (* local1 (/ temp0 temp6))))
			)
			(if (not (mod temp0 2))
				(++ temp1)
			)
			(= temp4 (localproc_0))
			(local6
				at:
					temp0
					(= temp7
						((myButton new:)
							nsLeft: temp2
							x: temp2
							nsTop: temp3
							y: temp3
							cel:
								(switch global439
									(1
										(if (mod temp4 2) 4 else 0)
									)
									(2
										(if (mod temp4 2) 4 else 0)
									)
									(else
										(if (mod temp4 2)
											(Random 4 7)
										else
											(Random 0 3)
										)
									)
								)
							loop: (/ temp4 2)
							value: (+ temp4 1)
							value3:
								(if (== global439 1)
									(+ (local5 at: temp0) 1)
								else
									(+ temp0 1)
								)
							yourself:
						)
					)
			)
			(self add: temp7)
			(++ temp0)
		)
		(rotateIcon signal: 5)
		(self add: rotateIcon)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 62 20 230 165
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (resetPuzzle)
		(SetNowSeen rotateIcon)
	)

	(method (giveYou &tmp temp0)
		(if local8
			(if (gEgo has: 58) ; lab-key
				(ClearFlag 51)
				(gGlory
					setCursor:
						((gTheIconBar getCursor:)
							view: 905
							loop: 2
							cel: 15
							yourself:
						)
				)
				(SetFlag 51)
			else
				(gMessager say: 20 4 21) ; "You need to find the key that fits this door."
			)
		else
			(gMessager say: 20 4 23) ; "You can't seem to find a keyhole; you need to solve the puzzle first."
		)
	)

	(method (dispose)
		(local4 dispose:)
		(local5 dispose:)
		(local6 dispose:)
		(self changeCursor: 942)
		(super dispose:)
		(DisposeScript 80)
	)

	(method (helpYou)
		(if (not (IsFlag 52))
			(lock show:)
			(FrameOut)
			(while
				(not (OneOf (((gUser curEvent:) new:) type:) 2 8 64))
			)
			(lock hide:)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(= gGameTime (+ gTickOffset (GetTime)))
		(if script
			(script doit:)
		)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(puzzleCast eachElementDo: #motionCue)
			(lock motionCue:)
		)
		(if gCuees
			(gCuees eachElementDo: #doit)
		)
		(if (not (gTalkers isEmpty:))
			(repeat
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gTalkers allTrue: #isModeless 2))
				((User curEvent:) new:)
			)
			(event claimed: 1)
			(return 0)
		)
		(if (not (gPrints isEmpty:))
			(gPrints eachElementDo: #doit)
			(if (gPrints firstTrue: #isModeless 1)
				(if (and ((= event (Event new:)) type:) gPrints)
					(gPrints firstTrue: #handleEvent event)
				)
				(event dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(return (FrameOut))
			)
		)
		(gSounds eachElementDo: #check)
		(= eventX (event x:))
		(= eventY (event y:))
		(= temp1
			(if noHands
				0
			else
				(event type:)
			)
		)
		(= temp2 (event message:))
		(= temp4 (event claimed:))
		(if (not noHands)
			(= temp3 (self firstTrue: #onMe eventX eventY))
		else
			(= temp3 0)
		)
		(if (and (!= highlightedIcon temp3) (not local7))
			(self highlight: temp3)
		)
		(event dispose:)
		(switch temp1
			(0
				(= temp4 0)
			)
			(1
				(cond
					(
						(and
							(& (event modifiers:) emSHIFT)
							highlightedIcon
							(== global439 3)
						)
						(highlightedIcon doAction2:)
					)
					(
						(and
							temp3
							(self select: temp3 1)
							(= temp4 (& (temp3 signal:) $0040))
						)
						(&= state $ffdf)
					)
				)
			)
			(4
				(switch temp2
					(KEY_RETURN
						(if temp3
							(self select: temp3)
							(= temp4 (& (temp3 signal:) $0040))
						)
					)
					(KEY_SHIFTTAB
						(self retreat:)
					)
					(KEY_TAB
						(self advance:)
					)
				)
			)
			(else
				(if (& temp1 $0010)
					(switch temp2
						(JOY_RIGHT
							(self advance:)
						)
						(JOY_LEFT
							(self retreat:)
						)
					)
				)
			)
		)
		(return temp4)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= gGameTime (+ gTickOffset (GetTime)))
			(puzzleCast doit:)
			(if (not (& (lock signal:) $0008))
				(lock doit:)
			)
			(FrameOut)
			(temp0 localize: plane)
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(if (== temp1 32)
				(temp0 type: 4 message: 13)
			)
			(MapKeyToDir temp0)
			(if noHands
				(temp0 type: 0)
			)
			(breakif (self dispatchEvent: temp0))
		)
	)
)

(instance reward of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== global439 1)
					(= temp1 12)
				else
					(= temp1 20)
				)
				(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
					((local6 at: temp0) signal: 5)
				)
				(= local8 1)
				(swap noHands: 1)
				(= cycles 2)
			)
			(1
				(highLightCel setPri: 80 hide:)
				(highLightCel2 setPri: 80 hide:)
				(lock setLoop: 0 1 setCel: 0 cycleSpeed: 8 setPri: 110 show:)
				(= seconds 2)
			)
			(2
				(lock setCycle: End self)
			)
			(3
				(SetFlag 52)
				(swap noHands: 0)
				(self dispose:)
			)
		)
	)
)

(instance lock of SelectProp
	(properties
		x 37
		y 83
		z 40
		priority 207
		fixPriority 1
		view 389
		cel 6
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (doVerb)
		(SetFlag 375)
		(swap state: (& (swap state:) $ffdf))
	)
)

(instance highLightCel of View
	(properties
		priority 120
		fixPriority 1
		view 383
		loop 10
	)
)

(instance highLightCel2 of View
	(properties
		priority 120
		fixPriority 1
		view 383
		loop 10
	)
)

(instance coverUp of View
	(properties
		x 35
		y 104
		priority 120
		fixPriority 1
		view 383
		loop 12
	)
)

(instance pointerCel of View
	(properties
		view 383
	)
)

(instance sideViewLeft of View
	(properties
		x 7
		y 30
		view 383
		loop 13
	)
)

(instance sideViewRight of View
	(properties
		x 136
		y 30
		view 383
		loop 13
	)
)

(instance myButton of TextIcon
	(properties
		priority 100
		fixPriority 1
		view 383
		cel 0
	)

	(method (doAction2)
		(cond
			((< cel 4)
				(if (== (++ cel) 4)
					(= cel 0)
				)
			)
			((== (++ cel) 8)
				(= cel 4)
			)
		)
		(self x: x y: y cel: cel loop: loop)
		(highLightCel x: x y: y cel: 0 show:)
		(if value2
			(highLightCel2 x: x y: y cel: 1 setPri: 80 hide:)
		)
		(FrameOut)
		(if (localproc_1)
			(swap setScript: reward)
		)
	)

	(method (select &tmp temp0 temp1 temp2)
		(if
			(cond
				((& signal $0004) 0)
				((and argc (& signal $0001))
					downClick
					temp2 ; UNINIT
				)
				(else 1)
			)
			(swap noHands: 0)
			(cond
				((and local2 (!= self local2))
					(rotateIcon signal: (| (rotateIcon signal:) $0004))
					(coverUp setPri: 180 show:)
					(FrameOut)
					(= temp0 (local2 value:))
					(local2 value: value)
					(= value temp0)
					(= temp0 (local2 cel:))
					(local2 cel: cel)
					(= cel temp0)
					(= temp0 (local2 loop:))
					(local2 loop: loop)
					(= loop temp0)
					(= value2 0)
					(local2 value2: 0)
					(highLightCel2 setPri: 80 hide:)
					(pointerCel
						loop: (local2 loop:)
						cel: (local2 cel:)
						x: (local2 nsLeft:)
						y: (local2 nsTop:)
						show:
					)
					(self loop: loop cel: cel x: x y: y show:)
					(FrameOut)
					(= local2 0)
					(= local7 0)
					(if (localproc_1)
						(swap setScript: reward)
					)
				)
				(value2
					(= local2 0)
					(= value2 0)
					(rotateIcon signal: (| (rotateIcon signal:) $0004))
					(coverUp loop: 12 cel: 0 setPri: 180 show:)
					(= local7 1)
					(highLightCel2 x: x y: y cel: 2 setPri: 190 show:)
					(FrameOut)
				)
				(else
					(= local2 self)
					(= value2 1)
					(if (== global439 3)
						(rotateIcon signal: (& (rotateIcon signal:) $fffb))
						(coverUp setPri: 80)
						(rotateIcon x: 34 y: 104 cel: 2)
					)
					(= local7 1)
					(highLightCel2 x: x y: y cel: 2 setPri: 190 show:)
					(FrameOut)
				)
			)
		)
	)

	(method (highlight param1)
		(if param1
			(if value2
				(highLightCel2 x: x y: y cel: 1 show:)
			else
				(highLightCel x: x y: y setCel: 0 show:)
			)
		else
			(highLightCel x: x y: y cel: 0 show:)
			(if value2
				(highLightCel2 x: x y: y cel: 1 hide:)
			)
		)
	)
)

(instance rotateIcon of TextIcon
	(properties
		x 34
		y 104
		priority 100
		fixPriority 1
		view 383
		loop 11
		signal 5
		maskView 383
		maskLoop 12
	)

	(method (select param1 &tmp temp0 temp1)
		(if
			(and
				local2
				(not (& signal $0004))
				(if (and argc param1 (& signal $0001))
					(coverUp setPri: 80)
					(= cel (= temp1 1))
					(UpdateScreenItem self)
					(FrameOut)
					(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
						(temp0 localize: plane)
						(coverUp setPri: 80)
						(cond
							((self onMe: (temp0 x:) (temp0 y:))
								(if (not temp1)
									(= cel (= temp1 1))
									(UpdateScreenItem self)
									(FrameOut)
								)
							)
							(temp1
								(= cel (= temp1 0))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
					)
					(if (== temp1 1)
						(= cel 0)
						(UpdateScreenItem self)
						(FrameOut)
					)
					temp1
				else
					(coverUp setPri: 180)
					1
				)
			)
			(local2 doAction2:)
		)
	)
)

