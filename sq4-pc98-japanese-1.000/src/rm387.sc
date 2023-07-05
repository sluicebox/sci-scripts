;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 387)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Language)
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
	local6
	local7
	[local8 7] = [41 42 43 44 45 46 47]
	local15 = 3
	local16 = 1
	local17
	local18
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

(procedure (localproc_1 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 [temp11 5])
	(= temp2 (proc0_18 global158 global155))
	(= temp8 14)
	(= temp4 (proc0_18 global130 global130))
	(= temp7 (proc0_18 global161 global130))
	(= temp6 (proc0_18 global157 global156))
	(= temp5 (proc0_18 global156 global156))
	(= temp1 3)
	(= temp9 2)
	(= temp3 3)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX param1 param2 (+ param3 1) (+ param4 1) temp3 temp2 temp8)
	(-= param1 temp1)
	(-= param2 temp1)
	(+= param4 temp1)
	(+= param3 temp1)
	(Graph grFILL_BOX param1 param2 (+ param1 temp1) param4 temp3 temp4 temp8)
	(Graph grFILL_BOX (- param3 temp1) param2 param3 param4 temp3 temp5 temp8)
	(for ((= temp10 0)) (< temp10 temp1) ((++ temp10))
		(Graph
			grDRAW_LINE
			(+ param1 temp10)
			(+ param2 temp10)
			(- param3 (+ temp10 1))
			(+ param2 temp10)
			temp7
			temp8
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp10)
			(- param4 (+ temp10 1))
			(- param3 (+ temp10 1))
			(- param4 (+ temp10 1))
			temp6
			temp8
		)
	)
	(Graph
		grFILL_BOX
		(+ param1 temp9)
		param4
		(+ param3 temp9)
		(+ param4 temp9)
		temp3
		0
		temp8
	)
	(Graph grFILL_BOX param3 (+ param2 temp9) (+ param3 temp9) param4 temp3 0 temp8)
	(Graph grUPDATE_BOX param1 param2 (+ param3 2) (+ param4 2) 1)
	(SetPort temp0)
)

(instance rm387 of SQRoom
	(properties
		picture 387
	)

	(method (init)
		(self setRegions: 700) ; mall
		(= local18 gPMouse)
		(= gPMouse 0)
		(LoadMany rsSOUND 41 101 122)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 4 5 6 7)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(gTheIconBar disable: 0)
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
		(lettuceBay init:)
		(pickleBay init:)
		(bunBay init:)
		(belt init:)
		(topCounter init:)
		(bottomCounter init:)
		(upperPipes init:)
		(redTube init:)
		(lowerPipes init:)
		(hood init:)
		(readSignFeat init:)
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
		(= gPMouse local18)
		(super dispose:)
	)
)

(instance restoreCode of Code
	(properties)

	(method (doit &tmp [temp0 15] [temp15 5])
		(localproc_1 170 7 184 (LangSwitch 87 100))
		(= local5 (proc0_12 387 0 67 9 173 28 global132 29 global129 30 0))
		(= local4
			(proc0_12
				(Format @temp15 387 1 local3) ; "$%d.00"
				67
				(LangSwitch 43 63)
				173
				28
				global137
				29
				global129
				30
				0
			)
		)
		(localproc_1 170 (proc0_19 168 188 188 222 222) 184 312)
		(= local6
			(proc0_12
				387
				2
				67
				(proc0_19 170 190 190 225 225)
				173
				28
				global136
				29
				global129
				30
				0
			)
		)
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
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
			(keyHandler setTarget: 0)
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
		(gDirectionHandler addToFront: self)
		(self restart:)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (event message:))
		(event claimed: 1)
		(cond
			((or (not (& (event type:) $0040)) (not (User canInput:))) ; direction
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
		(if param1
			(param1 doit:)
		)
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
				(= cycles 1)
			)
			(1
				(restoreCode doit:)
				(Print 387 3) ; "This is so easy, a human could probably do it. Burger comes out of the oven. Drop on yer lettuce, yer pickle, squeeze on yer mayo, squirt on yer mustard, on goes yer ketchup, top it off with yer sesame-seed bun. You make 'em MY way, and if you mess up enough times, you're outta here. Got it?"
				(Print 387 4) ; "If ya need to know how to run the assembly line, read the sign. Just click it with the mouse or press R."
				(= cycles 1)
			)
			(2
				(burgerMusic number: [local8 local7] changeState: play:)
				(client setScript: burgerScript)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		)
	)
)

(instance readSignCode of Code
	(properties)

	(method (doit)
		(Print 387 5) ; "Instructions for the MasterBurger 2000 This notice must be posted wherever the MasterBurger 2000 is in use. The hand cursor must be active in order to pick up and install condiments."
		(Print 387 6) ; "Keyboard: Up & down arrows switch between condiments and burger. When on condiment level, left & right arrows move cursor between the condiments. When on burger level, cursor follows burger. Mouse: Click on condiment to pick it up. Click it again on top of burger to install it. If you're carrying a condiment and you cycle to another cursor, the condiment drops back into its bay."
		(Print 387 7) ; "Joystick: Moving up & down switches between condiments and burger. When on condiment level, moving left & right moves cursor between the condiments. When on burger level, cursor follows burger."
	)
)

(instance burgerScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
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
				(grabSound number: 160 play:)
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
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: 0)
				(= temp0 (gTheIconBar curIcon:))
				(gTheIconBar disable: 0 1 2 3 4 5 6 7)
				(gTheIconBar curIcon: temp0)
				(gGame setCursor: gWaitCursor 1)
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
				(grabSound2 play:)
			)
			(5
				(grabSound number: 138 play:)
				(grabSound2 stop:)
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
					((or (== local0 10) (== local17 5))
						(client setScript: yurHistoryScript)
					)
					((not (-- local2))
						(= local2 (++ local15))
						(if (burger moveSpeed:)
							(burger moveSpeed: (- (burger moveSpeed:) 1))
						else
							(burger xStep: (+ (burger xStep:) 1))
						)
						(if (< (++ local7) 7)
							(burgerMusic
								number: [local8 local7]
								changeState:
								play:
							)
							(UnLoad 132 [local8 (- local7 1)])
						)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 0 1 2 3 4 5 6 7)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gTheIconBar disable: 0)
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
				(proc0_12 local5)
				(proc0_12 local6)
				(+= local3 local16)
				(restoreCode doit:)
				(gEgo get: 0) ; buckazoid
				(+= gBuckazoidCount local16)
				(+= global172 local16)
				(= register (burger moveSpeed:))
				(= local17 0)
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
				(rejectSign startUpd: setScript: signScript)
				(= seconds 4)
			)
			(2
				(burger setCycle: End)
				(grabSound number: 139 play:)
				(= seconds 5)
			)
			(3
				(rejectSign setScript: 0 setCycle: 0 cel: 0 stopUpd:)
				(= seconds 2)
			)
			(4
				(++ local0)
				(++ local17)
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
				(rejectSound play:)
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

(instance grabSound2 of Sound
	(properties
		number 137
		priority 3
	)
)

(instance readSignFeat of Feature
	(properties
		nsTop 168
		nsLeft 230
		nsBottom 187
		nsRight 315
		description {Button to read instructions.}
	)

	(method (init)
		(= nsLeft (proc0_19 168 188 188 222 222))
		(gKeyDownHandler add: self)
		(super init:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evKEYBOARD)
				(OneOf (event message:) KEY_r KEY_R)
			)
			(readSignCode doit:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print description)
			)
			(else
				(readSignCode doit:)
			)
		)
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
		nsTop 118
		nsLeft 55
		nsBottom 146
		nsRight 85
		description {lettuce bay}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 8) ; "Lettuce."
			)
			(10 ; Taste
				(Print 387 9) ; "Uhmm! Lettuce. Real old lettuce."
			)
			(11 ; Smell
				(Print 387 10) ; "Smells like lettuce."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance pickleBay of Feature
	(properties
		x 111
		y 131
		nsTop 118
		nsLeft 95
		nsBottom 146
		nsRight 126
		description {pickle bay}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 11) ; "Pickles"
			)
			(10 ; Taste
				(Print 387 12) ; "Tastes like pickelene slices"
			)
			(11 ; Smell
				(Print 387 13) ; "Smells like pickles."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
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
		y 126
		nsTop 118
		nsLeft 245
		nsBottom 146
		nsRight 275
		description {bun bay\83o\83\93\82\cc\93\fc\82\c1\82\c4\82\a2\82\e9\82\c6\82\b1\82\eb}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 14) ; "Buns."
			)
			(10 ; Taste
				(Print 387 15) ; "They almost taste fresh."
			)
			(11 ; Smell
				(Print 387 16) ; "Must be PermaBuns. They have no smell."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance mayo of Condiment
	(properties
		description {mayonnaise}
		view 387
		signal 24592
		myX 153
		myY 129
		myPri 10
		staticLoop 8
		cursorLoop 9
		targetCel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 17) ; "Squeeze me for a plop of mayonnaise."
			)
			(10 ; Taste
				(Print 387 18) ; "It tastes white."
			)
			(11 ; Smell
				(Print 387 19) ; "It has an oily smell."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance must of Condiment
	(properties
		description {mustard}
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 20) ; "Squeeze me for a plop of mustard."
			)
			(10 ; Taste
				(Print 387 21) ; "Tastes a little spicey."
			)
			(11 ; Smell
				(Print 387 22) ; "Smells a little spicey."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance cats of Condiment
	(properties
		description {catsup}
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 23) ; "Squeeze me for a plop of catsup."
			)
			(10 ; Taste
				(Print 387 24) ; "It tastes wet. Otherwise, it's tasteless."
			)
			(11 ; Smell
				(Print 387 25) ; "It has no smell."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lettuce of Condiment
	(properties
		description {lettuce}
		view 387
		signal 24592
		myX 71
		myY 131
		myPri 10
		staticCel 1
		cursorCel 1
		targetCel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 26) ; "A green leafy vegetable."
			)
			(10 ; Taste
				(Print 387 27) ; "Uhmm! Lettuce. Real old lettuce."
			)
			(11 ; Smell
				(Print 387 10) ; "Smells like lettuce."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pickle of Condiment
	(properties
		description {pickle}
		view 387
		signal 24592
		myX 111
		myY 131
		myPri 10
		staticCel 2
		cursorCel 2
		targetCel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 28) ; "Pickled cucumber slices."
			)
			(10 ; Taste
				(Print 387 29) ; "Tastes like pickle slices"
			)
			(11 ; Smell
				(Print 387 13) ; "Smells like pickles."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bun of Condiment
	(properties
		description {bun}
		view 387
		signal 24592
		myX 259
		myY 127
		myPri 10
		staticCel 6
		cursorCel 6
		targetCel 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 30) ; "The top half of a hamburger bun."
			)
			(10 ; Taste
				(Print 387 15) ; "They almost taste fresh."
			)
			(11 ; Smell
				(Print 387 16) ; "Must be PermaBuns. They have no smell."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance burger of Actor
	(properties
		x 14
		y 109
		description {burger}
		view 387
		priority 1
		signal 26640
		moveSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 387 31) ; "Beef at its finest(?)."
			)
			(3 ; Do
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
			(10 ; Taste
				(Print 387 32) ; "Hey! This belongs to someone else!"
			)
			(11 ; Smell
				(Print 387 33) ; "There's that Monolith Burgers Secret Smell(tm)."
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
		view 387
		loop 3
		cel 6
		priority 8
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 34) ; "BurgerMation Grabitron unit."
			)
			(10 ; Taste
				(Print 387 35) ; "That's a good way to put your tongue out, buddy."
			)
			(11 ; Smell
				(Print 387 36) ; "Smells greasy."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
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
		view 387
		loop 4
		priority 1
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 37) ; "If this is flashing, you've just blown it."
			)
			(10 ; Taste
				(Print 387 38) ; "It tastes greasy."
			)
			(11 ; Smell
				(Print 387 39) ; "It smells greasy."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance belt of Feature
	(properties
		x 165
		y 91
		nsTop 69
		nsLeft 32
		nsBottom 113
		nsRight 298
		description {conveyor belt}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 40) ; "This conveys the burgers from the nucleo-carbonic cooking chamber to you for construction and then on to the box grabber for transport out to the customer, or rejection if you've blown it."
			)
			(10 ; Taste
				(Print 387 41) ; "Essence of Monolith Burger now coats your tongue - forever!"
			)
			(11 ; Smell
				(Print 387 42) ; "It smells like the essence of Monolith Burger."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance topCounter of Feature
	(properties
		x 213
		y 22
		nsLeft 107
		nsBottom 44
		nsRight 319
		description {top counter}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 43) ; "It's more unimportant counter space."
			)
			(10 ; Taste
				(Print 387 44) ; "You must be bored. Maybe we should turn up the speed."
			)
			(11 ; Smell
				(Print 387 44) ; "You must be bored. Maybe we should turn up the speed."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bottomCounter of Feature
	(properties
		x 163
		y 10
		nsTop 114
		nsLeft 42
		nsBottom 159
		nsRight 285
		description {bottom counter}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 43) ; "It's more unimportant counter space."
			)
			(10 ; Taste
				(Print 387 44) ; "You must be bored. Maybe we should turn up the speed."
			)
			(11 ; Smell
				(Print 387 44) ; "You must be bored. Maybe we should turn up the speed."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance upperPipes of Feature
	(properties
		x 18
		y 53
		nsTop 38
		nsBottom 69
		nsRight 37
		description {upper pipes}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 45) ; "More pipes"
			)
			(10 ; Taste
				(Print 387 46) ; "Don't mess with it."
			)
			(11 ; Smell
				(Print 387 47) ; "Smells like a pipe!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance redTube of Feature
	(properties
		x 5
		y 91
		nsTop 69
		nsBottom 114
		nsRight 11
		description {red tube}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 48) ; "It's red tubing. You have no idea what it does."
			)
			(10 ; Taste
				(Print 387 46) ; "Don't mess with it."
			)
			(11 ; Smell
				(Print 387 47) ; "Smells like a pipe!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lowerPipes of Feature
	(properties
		x 18
		y 132
		nsTop 115
		nsBottom 149
		nsRight 36
		description {lower pipes}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 49) ; "More pipes."
			)
			(10 ; Taste
				(Print 387 46) ; "Don't mess with it."
			)
			(11 ; Smell
				(Print 387 47) ; "Smells like a pipe!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance hood of Feature
	(properties
		x 21
		y 92
		nsTop 70
		nsLeft 11
		nsBottom 114
		nsRight 31
		description {hood}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 387 50) ; "This sucks most of the noxious gases from the room."
			)
			(10 ; Taste
				(Print 387 51) ; "It definitely hasn't been cleaned in awhile. Maybe later when you get time you could give it a buff."
			)
			(11 ; Smell
				(Print 387 52) ; "It smells likes escaping air."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

