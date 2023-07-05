;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 387)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm387 0
)

(local
	local0
	local1
	local2 = 3
	local3
	local4
	local5
	[local6 7] = [41 42 43 44 45 46 47]
	local13 = 3
	local14 = 1
)

(procedure (localproc_0 param1)
	(return
		(if
			(or
				(== (lettuce followWho:) 1)
				(== (pickle followWho:) 1)
				(== (bun followWho:) 1)
				(== (mayo followWho:) 1)
				(== (must followWho:) 1)
				(== (cats followWho:) 1)
				(param1 followWho:)
			)
			0
		else
			(param1 follow: 1)
		)
	)
)

(instance rm387 of SQRoom
	(properties
		picture 387
	)

	(method (init)
		(self setRegions: 700) ; mall
		(LoadMany rsSOUND 41 42 43 44 45 46 47 101 122)
		(HandsOn)
		(gIconBar disable: 0)
		(super init:)
		(gEgo setCycle: 0)
		(burger init:)
		(lettuce init: rePosn: condoList: cList)
		(pickle init: rePosn: condoList: cList)
		(bun init: rePosn: condoList: cList)
		(mayo init: rePosn: mySound: squirtSound condoList: cList)
		(cats init: rePosn: mySound: squirtSound condoList: cList)
		(must init: rePosn: mySound: squirtSound condoList: cList)
		(keyHandler
			add: lettuceBay pickleBay mayoBay mustBay catsBay bunBay
			target: burger
			init:
		)
		(door init:)
		(rejectSign init: stopUpd:)
		(if (> (gGame detailLevel:) 1)
			(conveyor init: setCycle: Fwd)
		)
		(grabber init: stopUpd:)
		(restoreCode doit:)
		(self setScript: instructScript)
	)

	(method (doit)
		(if (GameIsRestarting)
			(restoreCode doit:)
		)
		(super doit:)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(cList delete: dispose:)
		(keyHandler delete: dispose:)
		(super dispose:)
	)
)

(instance restoreCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(= temp2 170)
		(= temp3 7)
		(= temp5 184)
		(= temp4 81)
		(= temp6 5)
		(= temp12 14)
		(= temp8 7)
		(= temp11 6)
		(= temp10 3)
		(= temp9 4)
		(= temp1 3)
		(= temp13 2)
		(= temp7 3)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) temp7 temp6 temp12)
		(-= temp2 temp1)
		(-= temp3 temp1)
		(+= temp4 temp1)
		(+= temp5 temp1)
		(Graph grFILL_BOX temp2 temp3 (+ temp2 temp1) temp4 temp7 temp8 temp12)
		(Graph grFILL_BOX (- temp5 temp1) temp3 temp5 temp4 temp7 temp9 temp12)
		(for ((= temp14 0)) (< temp14 temp1) ((++ temp14))
			(Graph
				grDRAW_LINE
				(+ temp2 temp14)
				(+ temp3 temp14)
				(- temp5 (+ temp14 1))
				(+ temp3 temp14)
				temp11
				temp12
			)
			(Graph
				grDRAW_LINE
				(+ temp2 temp14)
				(- temp4 (+ temp14 1))
				(- temp5 (+ temp14 1))
				(- temp4 (+ temp14 1))
				temp10
				temp12
			)
		)
		(Graph
			grFILL_BOX
			(+ temp2 temp13)
			temp4
			(+ temp5 temp13)
			(+ temp4 temp13)
			temp7
			0
			temp12
		)
		(Graph grFILL_BOX temp5 (+ temp3 temp13) (+ temp5 temp13) temp4 temp7 0 temp12)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 2) (+ temp4 2) 1)
		(SetPort temp0)
		(proc0_12 {Pay:} 67 9 173 28 global132 29 global129 30 0)
		(= local4 (proc0_12 {$0.00} 67 43 173 28 global137 29 global129 30 0))
	)
)

(class Condiment of View
	(properties
		myX 0
		myY 0
		myPri 0
		mySound 0
		staticLoop 0
		staticCel 0
		cursorLoop 0
		cursorCel 0
		targetLoop 0
		targetCel 0
		followWho 0
		condoList 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(localproc_0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (rePosn)
		(self
			x: myX
			y: myY
			loop: staticLoop
			cel: staticCel
			setPri: myPri
			followWho: 0
		)
	)

	(method (follow param1)
		(= followWho param1)
		(if (IsObject followWho)
			(condoList addToFront: self)
			(if mySound
				(mySound play:)
			)
			(self
				setPri: (+ (condoList size:) 1)
				followWho: param1
				loop: targetLoop
				cel: targetCel
			)
			(if (HaveMouse)
				(keyHandler setTarget: 0)
			else
				(keyHandler advance:)
			)
		else
			(self loop: cursorLoop cel: cursorCel setPri: 15)
			(= local1 (gGame setCursor: 69 1))
		)
	)

	(method (doit &tmp temp0)
		(cond
			((not followWho) 0)
			((IsObject followWho)
				(self x: (followWho x:) y: (- (followWho y:) 14))
			)
			((!= gTheCursor 69)
				(self rePosn:)
			)
			(else
				(= temp0 (User curEvent:))
				(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
					(GlobalToLocal temp0)
					(self x: (temp0 x:) y: (+ (temp0 y:) 10))
				)
			)
		)
		(super doit:)
	)
)

(class BurgerKeys of Set
	(properties
		curFeat 0
		curLevel 0
		target 0
	)

	(method (init)
		(gFtrInitializer addToFront: self)
		(self restart:)
	)

	(method (dispose)
		(gFtrInitializer delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (event message:))
		(event claimed: 1)
		(cond
			((or (!= (event type:) $0040) (not (User canInput:))) ; direction
				(event claimed: 0)
			)
			((OneOf temp0 JOY_UP JOY_DOWN KEY_UP KEY_DOWN)
				(self changeLevel:)
			)
			((OneOf temp0 JOY_RIGHT KEY_RIGHT)
				(self advance:)
			)
			((OneOf temp0 JOY_LEFT KEY_LEFT)
				(self retreat:)
			)
		)
	)

	(method (advance &tmp temp0)
		(= temp0 (self at: (+ 1 (self indexOf: curFeat))))
		(if (not (IsObject temp0))
			(= temp0 (NodeValue (self first:)))
		)
		(= curFeat temp0)
		(self changeLevel: 0)
	)

	(method (retreat &tmp temp0)
		(= temp0 (self at: (- (self indexOf: curFeat) 1)))
		(if (not (IsObject temp0))
			(= temp0 (NodeValue (self last:)))
		)
		(= curFeat temp0)
		(self changeLevel: 0)
	)

	(method (changeLevel param1)
		(if
			(= curLevel
				(if argc
					param1
				else
					(not curLevel)
				)
			)
			(= curLevel 1)
			(self setTarget: followTarget)
		else
			(= curLevel 0)
			(self setTarget: 0)
			(gGame setCursor: gTheCursor 1 (curFeat x:) (curFeat y:))
		)
	)

	(method (setTarget param1)
		(if (not argc)
			(= param1 0)
		)
		(target code: param1)
	)

	(method (restart)
		(= curFeat (NodeValue (self first:)))
		(self changeLevel: 0)
	)
)

(instance followTarget of Code
	(properties)

	(method (doit &tmp temp0)
		(if (User canInput:)
			(= temp0 ((keyHandler target:) x:))
			(if (> ((keyHandler target:) xStep:) 5)
				(+= temp0 5)
			)
			(gGame
				setCursor: gTheCursor 1 temp0 (- ((keyHandler target:) y:) 14)
			)
		else
			(keyHandler restart:)
		)
	)
)

(instance instructScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 387 0) ; "*** Instructions for this thing."
				(= cycles 1)
			)
			(1
				(burgerMusic number: [local6 local5] changeState: play:)
				(client setScript: burgerScript)
				(gIconBar curIcon: (gIconBar at: 4))
				(gGame setCursor: ((gIconBar curIcon:) cursor:))
			)
		)
	)
)

(instance burgerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (not (HaveMouse))
					(gGame
						setCursor:
							gTheCursor
							1
							((keyHandler curFeat:) x:)
							((keyHandler curFeat:) y:)
					)
				)
				(= cycles 1)
			)
			(2
				(door setCycle: End self)
			)
			(3
				(door cel: 0)
				(burger
					show:
					setLoop: 0
					cel: 0
					posn: 14 109
					setMotion: MoveTo 266 109 self
				)
			)
			(4
				(HandsOff)
				(keyHandler restart:)
				(burger hide:)
				(= register
					(if
						(and
							(== (cList indexOf: bun) 0)
							(!= (cList indexOf: lettuce) -1)
							(!= (cList indexOf: pickle) -1)
							(!= (cList indexOf: mayo) -1)
						)
						(and
							(!= (cList indexOf: must) -1)
							(!= (cList indexOf: cats) -1)
						)
					)
				)
				(lettuce rePosn:)
				(pickle rePosn:)
				(bun rePosn:)
				(mayo rePosn:)
				(must rePosn:)
				(cats rePosn:)
				(cList release:)
				(gGame setCursor: local1 1)
				(grabber setLoop: 2 cel: 0 setCycle: End self)
				(grabSound number: 136 play:)
			)
			(5
				(grabSound number: 136 play:)
				(burger setLoop: 5 cel: 0 posn: 266 27 show:)
				(grabber setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(grabber stopUpd:)
				(if register
					(self setScript: goodBurgerScript self)
				else
					(self setScript: rejectScript self)
				)
			)
			(7
				(cond
					((== local0 10)
						(client setScript: yurHistoryScript)
					)
					((not (-- local2))
						(= local2 (++ local13))
						(++ local14)
						(if (burger moveSpeed:)
							(burger moveSpeed: (- (burger moveSpeed:) 1))
						else
							(burger xStep: (+ (burger xStep:) 1))
						)
						(if (< (++ local5) 7)
							(burgerMusic
								number: [local6 local5]
								changeState:
								play:
							)
						)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				(HandsOn)
				(gIconBar disable: 0)
				(self start: 2 init:)
			)
		)
	)
)

(instance goodBurgerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 5])
		(switch (= state newState)
			(0
				(proc0_12 local4)
				(= local4
					(proc0_12
						(Format @temp0 387 1 (+= local3 local14)) ; "$%d.00"
						67
						43
						173
						28
						global137
						29
						global129
						30
						0
					)
				)
				(+= gBuckazoidCount local14)
				(= register (burger moveSpeed:))
				(burger moveSpeed: 0 setMotion: MoveTo (burger x:) -10 self)
			)
			(1
				(burger moveSpeed: register)
				(self dispose:)
			)
		)
	)
)

(instance rejectScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(rejectSign startUpd: setScript: signScript 0 0)
				(= seconds 4)
			)
			(2
				(signScript register: 1)
				(burger setCycle: End)
				(grabSound number: 139 play:)
				(= seconds 5)
			)
			(3
				(rejectSign setScript: 0 setCycle: 0 cel: 0 stopUpd:)
				(++ local0)
				(self dispose:)
			)
		)
	)
)

(instance signScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 2)
				(if (not register)
					(rejectSound play:)
				)
				(= cycles 5)
			)
			(1
				(client cel: 0)
				(= cycles 5)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance yurHistoryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom newRoom: 385)
			)
		)
	)
)

(instance burgerMusic of Sound
	(properties
		priority 1
		loop -1
	)
)

(instance rejectSound of Sound
	(properties
		number 101
		priority 2
	)
)

(instance squirtSound of Sound
	(properties
		number 122
		priority 3
	)
)

(instance grabSound of Sound
	(properties
		number 136
		priority 3
	)
)

(instance cList of List
	(properties)
)

(instance keyHandler of BurgerKeys
	(properties)
)

(instance lettuceBay of Feature
	(properties
		x 70
		y 131
	)
)

(instance pickleBay of Feature
	(properties
		x 111
		y 131
	)
)

(instance mayoBay of Feature
	(properties
		x 153
		y 129
	)
)

(instance mustBay of Feature
	(properties
		x 185
		y 129
	)
)

(instance catsBay of Feature
	(properties
		x 218
		y 129
	)
)

(instance bunBay of Feature
	(properties
		x 258
		y 128
	)
)

(instance mayo of Condiment
	(properties
		description {mayonnaise}
		lookStr {*** Squeeze me for a plop of mayonnaise.}
		view 387
		signal 24592
		myX 153
		myY 129
		myPri 10
		staticLoop 8
		cursorLoop 9
		targetCel 3
	)
)

(instance must of Condiment
	(properties
		description {mustard}
		lookStr {*** Squeeze me for a plop of mustard.}
		view 387
		signal 24592
		myX 185
		myY 129
		myPri 10
		staticLoop 8
		staticCel 1
		cursorLoop 9
		cursorCel 1
		targetCel 4
	)
)

(instance cats of Condiment
	(properties
		description {catsup}
		lookStr {*** Squeeze me for a plop of catsup.}
		view 387
		signal 24592
		myX 218
		myY 129
		myPri 10
		staticLoop 8
		staticCel 2
		cursorLoop 9
		cursorCel 2
		targetCel 5
	)
)

(instance lettuce of Condiment
	(properties
		description {lettuce}
		lookStr {*** A green leafy vegetable.}
		view 387
		signal 24592
		myX 71
		myY 131
		myPri 10
		staticCel 1
		cursorCel 1
		targetCel 1
	)
)

(instance pickle of Condiment
	(properties
		description {pickle}
		lookStr {*** A pickled cucumber.}
		view 387
		signal 24592
		myX 111
		myY 131
		myPri 10
		staticCel 2
		cursorCel 2
		targetCel 2
	)
)

(instance bun of Condiment
	(properties
		description {bun}
		lookStr {*** The top half of a hamburger bun.}
		view 387
		signal 24592
		myX 259
		myY 127
		myPri 10
		staticCel 6
		cursorCel 6
		targetCel 6
	)
)

(instance burger of Actor
	(properties
		x 14
		y 109
		description {burger}
		lookStr {*** Beef at it's finest.}
		view 387
		priority 1
		signal 26640
		moveSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (lettuce followWho:) 1)
						(lettuce follow: self)
						(gGame setCursor: local1 1)
					)
					((== (pickle followWho:) 1)
						(pickle follow: self)
						(gGame setCursor: local1 1)
					)
					((== (bun followWho:) 1)
						(bun follow: self)
						(gGame setCursor: local1 1)
					)
					((== (mayo followWho:) 1)
						(mayo follow: self)
						(gGame setCursor: local1 1)
					)
					((== (must followWho:) 1)
						(must follow: self)
						(gGame setCursor: local1 1)
					)
					((== (cats followWho:) 1)
						(cats follow: self)
						(gGame setCursor: local1 1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 60
		y 115
		view 387
		loop 7
		priority 1
		signal 16
	)
)

(instance grabber of Prop
	(properties
		x 255
		y 46
		description {grabber}
		lookStr {*** BurgerMation Grabitron unit.}
		view 387
		loop 3
		cel 6
		priority 8
		signal 16400
	)
)

(instance conveyor of Prop
	(properties
		x 287
		y 108
		view 387
		loop 6
		priority 1
		signal 16
	)
)

(instance rejectSign of Prop
	(properties
		x 186
		y 33
		description {reject sign}
		sightAngle 180
		lookStr {*** If this is flashing, you've just blown it.}
		view 387
		loop 4
		priority 1
		signal 16
	)
)

