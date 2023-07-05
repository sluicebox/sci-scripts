;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 387)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
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
	local8
	[local9 7] = [41 42 43 44 45 46 47]
	local16 = 3
	local17 = 1
	local18
)

(procedure (localproc_0 param1)
	(return
		(if
			(or
				(== (lettuce sel_608:) 1)
				(== (pickle sel_608:) 1)
				(== (bun sel_608:) 1)
				(== (mayo sel_608:) 1)
				(== (must sel_608:) 1)
				(== (cats sel_608:) 1)
				(param1 sel_608:)
			)
			0
		else
			(param1 sel_609: 1)
		)
	)
)

(instance rm387 of Rm
	(properties
		sel_20 {rm387}
		sel_399 387
		sel_28 10
	)

	(method (sel_110)
		(LoadMany rsSOUND 41 42 43 44 45 46 47 101 122)
		(User sel_229: 1 sel_339: 1)
		(gTheIconBar sel_178: 0 2 6 7)
		(gTheIconBar sel_225: 4 5 1)
		(gTheIconBar sel_225: 0 6 7 3)
		(super sel_110:)
		(burger sel_110:)
		(lettuce sel_110: sel_610: sel_611: cList)
		(pickle sel_110: sel_610: sel_611: cList)
		(bun sel_110: sel_610: sel_611: cList)
		(mayo sel_110: sel_610: sel_612: squirtSound sel_611: cList)
		(cats sel_110: sel_610: sel_612: squirtSound sel_611: cList)
		(must sel_110: sel_610: sel_612: squirtSound sel_611: cList)
		(keyHandler
			sel_118: lettuceBay pickleBay mayoBay mustBay catsBay bunBay
			sel_613: burger
			sel_110:
		)
		(door sel_110:)
		(rejectSign sel_110: sel_304:)
		(if (> (gGame sel_312:) 1)
			(conveyor sel_110: sel_162: Fwd)
		)
		(grabber sel_110: sel_304:)
		(lettuceBay sel_110:)
		(pickleBay sel_110:)
		(bunBay sel_110:)
		(belt sel_110:)
		(topCounter sel_110:)
		(bottomCounter sel_110:)
		(upperPipes sel_110:)
		(redTube sel_110:)
		(lowerPipes sel_110:)
		(hood sel_110:)
		(readSignFeat sel_110:)
		(quitting sel_110:)
		(self sel_146: instructScript)
	)

	(method (sel_292)
		(return 0)
	)

	(method (sel_57)
		(if (GameIsRestarting)
			(restoreCode sel_57:)
		)
		(Wait 7)
		(super sel_57:)
	)

	(method (sel_111)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(cList sel_81: sel_111:)
		(keyHandler sel_81: sel_111:)
		(super sel_111:)
	)
)

(instance restoreCode of Code
	(properties
		sel_20 {restoreCode}
	)

	(method (sel_57 &tmp [temp0 15] [temp15 5])
		(proc0_22 170 7 184 87)
		(= local5 (proc0_12 {Pay:} 64 9 173 25 global132 26 global129 27 0))
		(= local4
			(proc0_12
				(Format @temp15 387 0 local3) ; "$%d.00"
				64
				43
				173
				25
				global137
				26
				global129
				27
				0
			)
		)
		(proc0_22 170 222 184 312)
		(= local6
			(proc0_12 {Instructions} 64 233 173 25 global135 26 global129 27 0)
		)
		(proc0_22 170 145 184 174)
		(= local7 (proc0_12 {Quit} 64 148 173 25 global135 26 global129 27 0))
	)
)

(class Condiment of View
	(properties
		sel_20 {Condiment}
		sel_614 0
		sel_615 0
		sel_616 0
		sel_612 0
		sel_617 0
		sel_618 0
		sel_619 0
		sel_620 0
		sel_621 0
		sel_622 0
		sel_608 0
		sel_611 0
	)

	(method (sel_292 param1 param2)
		(switch param1
			(2
				(localproc_0 self)
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)

	(method (sel_610)
		(self
			sel_1: sel_614
			sel_0: sel_615
			sel_3: sel_617
			sel_4: sel_618
			sel_63: sel_616
			sel_608: 0
		)
	)

	(method (sel_609 param1)
		(= sel_608 param1)
		(if (IsObject sel_608)
			(sel_611 sel_129: self)
			(if sel_612
				(sel_612 sel_39:)
			)
			(self
				sel_63: (+ (sel_611 sel_86:) 1)
				sel_608: param1
				sel_3: sel_621
				sel_4: sel_622
			)
			(keyHandler sel_243: 0)
		else
			(self sel_3: sel_619 sel_4: sel_620 sel_63: 15)
			(= local1 gTheCursor)
			(gGame sel_198: gHiddenCursor)
		)
	)

	(method (sel_57 &tmp temp0)
		(cond
			((not sel_608) 0)
			((IsObject sel_608)
				(self sel_1: (sel_608 sel_1:) sel_0: (- (sel_608 sel_0:) 14))
			)
			((!= gTheCursor gHiddenCursor)
				(self sel_610:)
			)
			(else
				(= temp0 (User sel_338:))
				(if (not (& (temp0 sel_31:) $000f))
					(GlobalToLocal temp0)
					(self sel_1: (temp0 sel_1:) sel_0: (+ (temp0 sel_0:) 10))
				)
			)
		)
		(super sel_57:)
	)
)

(class BurgerKeys of Set
	(properties
		sel_20 {BurgerKeys}
		sel_623 0
		sel_624 0
		sel_613 0
	)

	(method (sel_110)
		(gDirectionHandler sel_129: self)
		(self sel_101:)
	)

	(method (sel_111)
		(gDirectionHandler sel_81: self)
		(super sel_111: &rest)
	)

	(method (sel_133 param1 &tmp temp0)
		(= temp0 (param1 sel_37:))
		(param1 sel_73: 1)
		(cond
			((or (not (& (param1 sel_31:) $0040)) (not (User sel_339:)))
				(param1 sel_73: 0)
			)
			((OneOf temp0 1 5 18432 20480)
				(self sel_625:)
			)
			((OneOf temp0 3 19712)
				(self sel_188:)
			)
			((OneOf temp0 7 19200)
				(self sel_189:)
			)
		)
	)

	(method (sel_188 &tmp temp0)
		(= temp0 (self sel_64: (+ 1 (self sel_132: sel_623))))
		(if (not (IsObject temp0))
			(= temp0 (NodeValue (self sel_124:)))
		)
		(= sel_623 temp0)
		(self sel_625: 0)
	)

	(method (sel_189 &tmp temp0)
		(= temp0 (self sel_64: (- (self sel_132: sel_623) 1)))
		(if (not (IsObject temp0))
			(= temp0 (NodeValue (self sel_127:)))
		)
		(= sel_623 temp0)
		(self sel_625: 0)
	)

	(method (sel_625 param1)
		(if
			(= sel_624
				(if argc
					param1
				else
					(not sel_624)
				)
			)
			(= sel_624 1)
			(self sel_243: followTarget)
		else
			(= sel_624 0)
			(self sel_243: 0)
			(gGame sel_198: gTheCursor)
			(Cursor sel_157: 1)
			(SetCursor (sel_623 sel_1:) (sel_623 sel_0:))
		)
	)

	(method (sel_243 param1)
		(if (not argc)
			(= param1 0)
		)
		(sel_613 sel_320: param1)
		(if param1
			(param1 sel_57:)
		)
	)

	(method (sel_101)
		(= sel_623 (NodeValue (self sel_124:)))
		(self sel_625: 0)
	)
)

(instance followTarget of Code
	(properties
		sel_20 {followTarget}
	)

	(method (sel_57 &tmp temp0)
		(if (User sel_339:)
			(= temp0 ((keyHandler sel_613:) sel_1:))
			(if (> ((keyHandler sel_613:) sel_51:) 5)
				(+= temp0 5)
			)
			(gGame sel_198: gTheCursor)
			(Cursor sel_157: 1)
			(SetCursor temp0 (- ((keyHandler sel_613:) sel_0:) 14))
		else
			(keyHandler sel_101:)
		)
	)
)

(instance instructScript of Script
	(properties
		sel_20 {instructScript}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(restoreCode sel_57:)
				(= sel_136 1)
			)
			(2
				(= sel_136 1)
			)
			(3
				(burgerMusic sel_40: [local9 local8] sel_144: sel_39:)
				(sel_42 sel_146: burgerScript)
				(gTheIconBar sel_214: (gTheIconBar sel_64: 2))
				(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
			)
		)
	)
)

(instance readSignCode of Code
	(properties
		sel_20 {readSignCode}
	)

	(method (sel_57)
		(Print 387 1) ; "Instructions for the MasterBurger 2000 This notice must be posted wherever the MasterBurger 2000 is in use."
		(Print 387 2) ; "Keyboard: Up & down arrows switch between condiments and burger. When on condiment level, left & right arrows move cursor between the condiments. When on burger level, cursor follows burger. Press the "ENTER" (or "RETURN") key to pick up or drop the condiments. Use the "F9" key to quit. Press "R" to activate instructions button."
		(Print 387 3) ; "Mouse: Click on condiment to pick it up. Click it again on top of burger to install it."
	)
)

(instance burgerScript of Script
	(properties
		sel_20 {burgerScript}
	)

	(method (sel_144 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(if (not (HaveMouse))
					(gGame sel_198: gTheCursor)
					(Cursor sel_157: 1)
					(SetCursor
						((keyHandler sel_623:) sel_1:)
						((keyHandler sel_623:) sel_0:)
					)
				)
				(= sel_136 1)
			)
			(2
				(grabSound sel_40: 160 sel_39:)
				(door sel_162: End self)
			)
			(3
				(door sel_4: 0)
				(burger
					sel_207:
					sel_155: 0
					sel_4: 0
					sel_153: 14 109
					sel_303: MoveTo 266 109 self
				)
			)
			(4
				(User sel_229: 0 sel_339: 0)
				(= temp0 (gTheIconBar sel_214:))
				(gTheIconBar sel_225: 1 2 3 4 5 6 0 7)
				(gTheIconBar sel_214: temp0)
				(gGame sel_198: gWaitCursor)
				(Cursor sel_157: 1)
				(keyHandler sel_101:)
				(burger sel_102:)
				(= sel_141
					(if
						(and
							(== (cList sel_132: bun) 0)
							(!= (cList sel_132: lettuce) -1)
							(!= (cList sel_132: pickle) -1)
							(!= (cList sel_132: mayo) -1)
						)
						(and
							(!= (cList sel_132: must) -1)
							(!= (cList sel_132: cats) -1)
						)
					)
				)
				(lettuce sel_610:)
				(pickle sel_610:)
				(bun sel_610:)
				(mayo sel_610:)
				(must sel_610:)
				(cats sel_610:)
				(cList sel_125:)
				(if (not local1)
					(= local1 gWaitCursor)
				)
				(gGame sel_198: gWaitCursor)
				(Cursor sel_157: 1)
				(grabber sel_155: 2 sel_4: 0 sel_162: End self)
				(grabSound sel_40: 136 sel_39:)
				(grabSound2 sel_39:)
			)
			(5
				(grabSound sel_40: 138 sel_39:)
				(grabSound2 sel_168:)
				(burger sel_155: 5 sel_4: 0 sel_153: 266 27 sel_207:)
				(grabber sel_155: 3 sel_4: 0 sel_162: End self)
			)
			(6
				(grabber sel_304:)
				(if sel_141
					(self sel_146: goodBurgerScript self)
				else
					(self sel_146: rejectScript self)
				)
			)
			(7
				(cond
					((or (== local0 10) (== local18 5))
						(sel_42 sel_146: yurHistoryScript)
					)
					((not (-- local2))
						(= local2 (++ local16))
						(if (burger sel_53:)
							(burger sel_53: (- (burger sel_53:) 1))
						else
							(burger sel_51: (+ (burger sel_51:) 1))
						)
						(if (< (++ local8) 7)
							(burgerMusic
								sel_40: [local9 local8]
								sel_144:
								sel_39:
							)
							(UnLoad 132 [local9 (- local8 1)])
						)
						(= sel_136 1)
					)
					(else
						(= sel_136 1)
					)
				)
			)
			(8
				(User sel_229: 1 sel_339: 1)
				(gTheIconBar sel_178: 0 2 6 7)
				(gTheIconBar sel_225: 4 5 1)
				(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
				(gTheIconBar sel_225: 0 6 7 3)
				(self sel_134: 2 sel_110:)
			)
		)
	)
)

(instance goodBurgerScript of Script
	(properties
		sel_20 {goodBurgerScript}
	)

	(method (sel_144 param1 &tmp [temp0 5])
		(switch (= sel_29 param1)
			(0
				(proc0_12 local4)
				(proc0_12 local5)
				(proc0_12 local6)
				(proc0_12 local7)
				(+= local3 local17)
				(restoreCode sel_57:)
				(+= global159 local17)
				(+= global172 local17)
				(= sel_141 (burger sel_53:))
				(= local18 0)
				(burger sel_53: 0 sel_303: MoveTo (burger sel_1:) -10 self)
			)
			(1
				(burger sel_53: sel_141)
				(self sel_111:)
			)
		)
	)
)

(instance rejectScript of Script
	(properties
		sel_20 {rejectScript}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_137 2)
			)
			(1
				(rejectSign sel_306: sel_146: signScript)
				(= sel_137 4)
			)
			(2
				(burger sel_162: End)
				(grabSound sel_40: 139 sel_39:)
				(= sel_137 5)
			)
			(3
				(rejectSign sel_146: 0 sel_162: 0 sel_4: 0 sel_304:)
				(= sel_137 2)
			)
			(4
				(++ local0)
				(++ local18)
				(self sel_111:)
			)
		)
	)
)

(instance signScript of Script
	(properties
		sel_20 {signScript}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(sel_42 sel_4: 2)
				(rejectSound sel_39:)
				(= sel_136 5)
			)
			(1
				(sel_42 sel_4: 0)
				(= sel_136 5)
			)
			(2
				(self sel_110:)
			)
		)
	)
)

(instance yurHistoryScript of Script
	(properties
		sel_20 {yurHistoryScript}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 1)
			)
			(1
				(Print 387 4) ; "Yur history, pal! Come back when you can shovel some REAL hamburgers!!"
				(= sel_136 1)
			)
			(2
				(Print 387 5) ; "Game Over."
				(= sel_136 1)
			)
			(3
				(proc0_21)
			)
		)
	)
)

(instance burgerMusic of Sound
	(properties
		sel_20 {burgerMusic}
		sel_60 1
		sel_3 -1
	)
)

(instance rejectSound of Sound
	(properties
		sel_20 {rejectSound}
		sel_40 101
		sel_60 2
	)
)

(instance squirtSound of Sound
	(properties
		sel_20 {squirtSound}
		sel_40 122
		sel_60 3
	)
)

(instance grabSound of Sound
	(properties
		sel_20 {grabSound}
		sel_40 136
		sel_60 3
	)
)

(instance grabSound2 of Sound
	(properties
		sel_20 {grabSound2}
		sel_40 137
		sel_60 3
	)
)

(instance quitting of Feature
	(properties
		sel_20 {quitting}
		sel_6 165
		sel_7 141
		sel_8 187
		sel_9 177
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(Print 387 6) ; "Click here to quit the game."
			)
			(else
				(proc0_21 1)
			)
		)
	)
)

(instance readSignFeat of Feature
	(properties
		sel_20 {readSignFeat}
		sel_6 168
		sel_7 230
		sel_8 187
		sel_9 315
	)

	(method (sel_110)
		(gKeyDownHandler sel_118: self)
		(super sel_110:)
	)

	(method (sel_111)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(super sel_133: param1)
		(if
			(and
				(not (param1 sel_73:))
				(& (param1 sel_31:) $0004)
				(OneOf (param1 sel_37:) 114 82)
			)
			(readSignCode sel_57:)
		)
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(Print 387 7) ; "Button to read instructions."
			)
			(else
				(readSignCode sel_57:)
			)
		)
	)
)

(instance cList of List
	(properties
		sel_20 {cList}
	)
)

(instance keyHandler of BurgerKeys
	(properties
		sel_20 {keyHandler}
	)
)

(instance lettuceBay of Feature
	(properties
		sel_20 {lettuceBay}
		sel_1 70
		sel_0 131
		sel_6 118
		sel_7 55
		sel_8 146
		sel_9 85
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 8) ; "Lettuce."
			)
			(6
				(Print 387 9) ; "Uhmm! Lettuce. Real old lettuce."
			)
			(7
				(Print 387 10) ; "Smells like lettuce."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance pickleBay of Feature
	(properties
		sel_20 {pickleBay}
		sel_1 111
		sel_0 131
		sel_6 116
		sel_7 94
		sel_8 148
		sel_9 127
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 11) ; "Pickles."
			)
			(6
				(Print 387 12) ; "Tastes like pickelene slices"
			)
			(7
				(Print 387 13) ; "Smells like pickles."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance mayoBay of Feature
	(properties
		sel_20 {mayoBay}
		sel_1 153
		sel_0 129
	)
)

(instance mustBay of Feature
	(properties
		sel_20 {mustBay}
		sel_1 185
		sel_0 129
	)
)

(instance catsBay of Feature
	(properties
		sel_20 {catsBay}
		sel_1 218
		sel_0 129
	)
)

(instance bunBay of Feature
	(properties
		sel_20 {bunBay}
		sel_1 258
		sel_0 126
		sel_6 118
		sel_7 245
		sel_8 146
		sel_9 275
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 14) ; "Buns."
			)
			(6
				(Print 387 15) ; "They almost taste fresh."
			)
			(7
				(Print 387 16) ; "Must be PermaBuns. They have no smell."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance mayo of Condiment
	(properties
		sel_20 {mayo}
		sel_2 387
		sel_14 24592
		sel_614 153
		sel_615 129
		sel_616 10
		sel_617 8
		sel_619 9
		sel_622 3
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 17) ; "Squeeze me for a plop of mayonnaise."
			)
			(6
				(Print 387 18) ; "It tastes white."
			)
			(7
				(Print 387 19) ; "It has an oily smell."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance must of Condiment
	(properties
		sel_20 {must}
		sel_2 387
		sel_14 24592
		sel_614 185
		sel_615 129
		sel_616 10
		sel_617 8
		sel_618 1
		sel_619 9
		sel_620 1
		sel_622 4
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 20) ; "Squeeze me for a plop of mustard."
			)
			(6
				(Print 387 21) ; "Tastes a little spicey."
			)
			(7
				(Print 387 22) ; "Smells a little spicey."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance cats of Condiment
	(properties
		sel_20 {cats}
		sel_2 387
		sel_14 24592
		sel_614 218
		sel_615 129
		sel_616 10
		sel_617 8
		sel_618 2
		sel_619 9
		sel_620 2
		sel_622 5
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 23) ; "Squeeze me for a plop of catsup."
			)
			(6
				(Print 387 24) ; "It tastes wet. Otherwise, it's tasteless."
			)
			(7
				(Print 387 25) ; "It has no smell."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance lettuce of Condiment
	(properties
		sel_20 {lettuce}
		sel_2 387
		sel_14 24592
		sel_614 71
		sel_615 131
		sel_616 10
		sel_618 1
		sel_620 1
		sel_622 1
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 26) ; "A green leafy vegetable."
			)
			(6
				(Print 387 9) ; "Uhmm! Lettuce. Real old lettuce."
			)
			(7
				(Print 387 10) ; "Smells like lettuce."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance pickle of Condiment
	(properties
		sel_20 {pickle}
		sel_2 387
		sel_14 24592
		sel_614 111
		sel_615 131
		sel_616 10
		sel_618 2
		sel_620 2
		sel_622 2
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 27) ; "Pickled cucumber slices."
			)
			(6
				(Print 387 12) ; "Tastes like pickelene slices"
			)
			(7
				(Print 387 13) ; "Smells like pickles."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance bun of Condiment
	(properties
		sel_20 {bun}
		sel_2 387
		sel_14 24592
		sel_614 259
		sel_615 127
		sel_616 10
		sel_618 6
		sel_620 6
		sel_622 6
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 28) ; "The top half of a hamburger bun."
			)
			(6
				(Print 387 15) ; "They almost taste fresh."
			)
			(7
				(Print 387 16) ; "Must be PermaBuns. They have no smell."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance burger of Actor
	(properties
		sel_20 {burger}
		sel_1 14
		sel_0 109
		sel_2 387
		sel_60 1
		sel_14 26640
		sel_53 3
	)

	(method (sel_292 param1)
		(switch param1
			(1
				(Print 387 29) ; "Beef at its finest(?)."
			)
			(2
				(cond
					((== (lettuce sel_608:) 1)
						(lettuce sel_609: self)
						(gGame sel_198: local1)
						(Cursor sel_157: 1)
					)
					((== (pickle sel_608:) 1)
						(pickle sel_609: self)
						(gGame sel_198: local1)
						(Cursor sel_157: 1)
					)
					((== (bun sel_608:) 1)
						(bun sel_609: self)
						(gGame sel_198: local1)
						(Cursor sel_157: 1)
					)
					((== (mayo sel_608:) 1)
						(mayo sel_609: self)
						(gGame sel_198: local1)
						(Cursor sel_157: 1)
					)
					((== (must sel_608:) 1)
						(must sel_609: self)
						(gGame sel_198: local1)
						(Cursor sel_157: 1)
					)
					((== (cats sel_608:) 1)
						(cats sel_609: self)
						(gGame sel_198: local1)
						(Cursor sel_157: 1)
					)
				)
			)
			(6
				(Print 387 30) ; "Hey! This belongs to someone else!"
			)
			(7
				(Print 387 31) ; "There's that Monolith Burgers Secret Smell(tm)."
			)
			(else
				(super sel_292: param1 &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		sel_20 {door}
		sel_1 60
		sel_0 115
		sel_2 387
		sel_3 7
		sel_60 1
		sel_14 16
	)
)

(instance grabber of Prop
	(properties
		sel_20 {grabber}
		sel_1 255
		sel_0 46
		sel_2 387
		sel_3 3
		sel_4 6
		sel_60 8
		sel_14 16400
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 32) ; "BurgerMation Grabitron unit."
			)
			(6
				(Print 387 33) ; "That's a good way to put your tongue out, buddy."
			)
			(7
				(Print 387 34) ; "Smells greasy."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance conveyor of Prop
	(properties
		sel_20 {conveyor}
		sel_1 287
		sel_0 108
		sel_2 387
		sel_3 6
		sel_60 1
		sel_14 16
	)
)

(instance rejectSign of Prop
	(properties
		sel_20 {rejectSign}
		sel_1 186
		sel_0 33
		sel_293 180
		sel_2 387
		sel_3 4
		sel_60 1
		sel_14 16
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 35) ; "If this is flashing, you've just blown it."
			)
			(6
				(Print 387 36) ; "It tastes greasy."
			)
			(7
				(Print 387 37) ; "It smells greasy."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance belt of Feature
	(properties
		sel_20 {belt}
		sel_1 165
		sel_0 91
		sel_6 69
		sel_7 32
		sel_8 113
		sel_9 298
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 38) ; "This conveys the burgers from the nucleo-carbonic cooking chamber to you for construction and then on to the box grabber for transport out to the customer, or rejection if you've blown it."
			)
			(6
				(Print 387 39) ; "Essence of Monolith Burger now coats your tongue - forever!"
			)
			(7
				(Print 387 40) ; "It smells like the essence of Monolith Burger."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance topCounter of Feature
	(properties
		sel_20 {topCounter}
		sel_1 213
		sel_0 22
		sel_7 107
		sel_8 44
		sel_9 319
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 41) ; "It's more unimportant counter space."
			)
			(6
				(Print 387 42) ; "You must be bored. Maybe we should turn up the speed."
			)
			(7
				(Print 387 42) ; "You must be bored. Maybe we should turn up the speed."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance bottomCounter of Feature
	(properties
		sel_20 {bottomCounter}
		sel_1 163
		sel_0 10
		sel_6 114
		sel_7 42
		sel_8 159
		sel_9 285
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 41) ; "It's more unimportant counter space."
			)
			(6
				(Print 387 42) ; "You must be bored. Maybe we should turn up the speed."
			)
			(7
				(Print 387 42) ; "You must be bored. Maybe we should turn up the speed."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance upperPipes of Feature
	(properties
		sel_20 {upperPipes}
		sel_1 18
		sel_0 53
		sel_6 38
		sel_8 69
		sel_9 37
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 43) ; "More pipes"
			)
			(6
				(Print 387 44) ; "Don't mess with it."
			)
			(7
				(Print 387 45) ; "Smells like a pipe!"
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance redTube of Feature
	(properties
		sel_20 {redTube}
		sel_1 5
		sel_0 91
		sel_6 69
		sel_8 114
		sel_9 11
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 46) ; "It's red tubing. You have no idea what it does."
			)
			(6
				(Print 387 44) ; "Don't mess with it."
			)
			(7
				(Print 387 45) ; "Smells like a pipe!"
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance lowerPipes of Feature
	(properties
		sel_20 {lowerPipes}
		sel_1 18
		sel_0 132
		sel_6 115
		sel_8 149
		sel_9 36
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 47) ; "More pipes."
			)
			(6
				(Print 387 44) ; "Don't mess with it."
			)
			(7
				(Print 387 45) ; "Smells like a pipe!"
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance hood of Feature
	(properties
		sel_20 {hood}
		sel_1 21
		sel_0 92
		sel_6 70
		sel_7 11
		sel_8 114
		sel_9 31
	)

	(method (sel_292 param1 param2)
		(switch param1
			(1
				(Print 387 48) ; "This sucks most of the noxious gases from the room."
			)
			(6
				(Print 387 49) ; "It definitely hasn't been cleaned in awhile. Maybe later when you get time you could give it a buff."
			)
			(7
				(Print 387 50) ; "It smells like escaping air."
			)
			(else
				(super sel_292: param1 param2)
			)
		)
	)
)

(instance welcomeWindow of SysWindow ; UNUSED
	(properties
		sel_20 {welcomeWindow}
		sel_26 5
	)
)

