;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use eRS)
(use ChemicalObj)
(use Inset)
(use Osc)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	rm620 0
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

(instance rm620 of FPRoom
	(properties
		noun 36
		picture 620
	)

	(method (init)
		(proc0_8 1)
		(if (!= gPrevRoomNum 610)
			(gGame handsOn:)
			(gTheIconBar disable: 1 3 7)
		)
		(= global142 0)
		(= global143 0)
		(= global144 0)
		(= global145 0)
		(super init: self)
		(UnLoad 128 800)
		(UnLoad 128 842)
		(Load rsMESSAGE 620)
		(gGameMusic1 number: 620 flags: 1 loop: -1 play:)
		(workArea init:)
		(bottle1 init:)
		(bottle2 init:)
		(bottle3 init:)
		(bottle4 init:)
		(bottle5 init:)
		(bottle6 init:)
		(bottle7 init:)
		(bottle8 init:)
		(bottle9 init:)
		(bottle10 init:)
		(bottle11 init:)
		(bottle13 init:)
		(solid1 init:)
		(solid2 init:)
		(solid3 init:)
		(solid4 init:)
		(solid5 init:)
		(solid6 init:)
		(solid7 init:)
		(beaker1 init:)
		(solidBox1 init:)
		(solidBoxes init:)
		(corks init:)
		(paper1 init:)
		(stirringRods init:)
		(matches1 init:)
		(mortar init:)
		(spatula1 init:)
		(gradCylinder init:)
		(testTube1 init:)
		(crucible1 init:)
		(pillMachine init:)
		(alcoholLamp init:)
		(spectro init:)
		(puff init: hide:)
		(balance1 init: setPri: 6)
		(dumper init: setPri: 5)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 2)
	)

	(method (cue)
		(if global143
			(proc0_8 0)
			(gCurRoom newRoom: 610)
		else
			(gTheIconBar disable: 1 3 7)
			(switch gCurPuzzle
				(2
					(if (not (IsFlag 75))
						(SetFlag 75)
						(gMessager say: 13 0 5) ; "You study Penelope's prescription and prepare to carefully fill it. You wouldn't want to make a mistake with her medicine."
					)
				)
				(3
					(if (not (IsFlag 76))
						(SetFlag 76)
						(gMessager say: 13 0 6) ; "You study Helen Back's prescription and prepare to carefully fill it."
					)
				)
				(4
					(cond
						((and (gEgo has: 32) (not (IsFlag 77))) ; Madame_s_Rx
							(SetFlag 77)
							(gMessager say: 13 0 7) ; "As you study Madame Ovaree's prescription, you realize you cannot read it. The writing looks so blurry."
						)
						((and (gEgo has: 58) (not (IsFlag 78))) ; Under_Glass
							(SetFlag 78)
							(gMessager say: 13 0 8) ; "You were so clever to use Doc's whisky glass to read Madame Ovaree's prescription. Now you prepare to carefully fill it."
						)
					)
				)
				(5
					(if (not (IsFlag 79))
						(SetFlag 79)
						(gMessager say: 13 0 9) ; "You study Doc's corrections to Madame Ovaree's prescription and prepare to carefully fill it."
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< gMouseY 130)
					(if global142
						(global142
							posn: gMouseX gMouseY
							show:
							setPri: 15
							setLoop: (global142 loop:)
							setMotion:
								MoveTo
								(global142 startX:)
								(global142 startY:)
								global142
						)
						(proc625_1)
						(= global142 0)
					else
						(super doVerb: theVerb &rest)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(8 ; icon10
				(cond
					(
						(and
							(== (crucible1 contents:) 25)
							(== (crucible1 contentState:) 51)
						)
						(gMessager say: 65 0 31) ; "You've got a crucible of molten silver! You shouldn't leave the lab until you figure out something to do with it."
					)
					((== (crucible1 contents:) 25)
						(gEgo get: -1 33) ; Medallion
						(= global143 1)
						(gMessager say: 64 0 30 0 self) ; "Before leaving your lab, you remove the medallion from the crucible."
					)
					(
						(and
							(not global144)
							(or
								(bottle11 amount:)
								(solidBoxes amount:)
								(and
									(gCast contains: medicineBottle)
									(medicineBottle amount:)
								)
								(and
									(gCast contains: solidBox)
									(solidBox amount:)
								)
							)
						)
						(= global143 1)
						(gMessager say: 61 0 19 0 self) ; "Disgusted at your inability to prepare the proper concoction, you discard your attempt in the waste receptacle and leave your laboratory."
					)
					(else
						(proc0_8 0)
						(gCurRoom newRoom: 610)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if script
		else
			(= temp0 (gCast firstTrue: #onMe gMouseX (- gMouseY 10)))
			(if (and (IsObject temp0) (or (!= temp0 local0) local1))
				(= local1 0)
				(proc625_0 temp0)
				(= local0 temp0)
			)
			(if (not (IsObject temp0))
				(= local1 1)
				(if global145
					(Display {} dsRESTOREPIXELS global145)
					(= global145 0)
				)
			)
		)
	)

	(method (dispose)
		(proc625_1)
		(DisposeScript 625)
		(if (!= gCurPuzzle 14)
			(gGameMusic1 fade:)
		)
		(super dispose:)
	)
)

(instance sDoPuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(puff show: posn: 100 146)
				(= ticks 30)
			)
			(1
				(puff hide:)
				(= cycles 2)
			)
			(2
				(gMessager say: 37 64 22 0 self) ; "Allowing only a slight portion of your sample to escape near the alcohol lamp, you notice it turns the flame an unusual color."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDoSpectroLines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(puff show: posn: (spectro x:) (- (spectro y:) 17))
				(= ticks 30)
			)
			(1
				(puff hide:)
				(= cycles 2)
			)
			(2
				(gMessager say: 62 64 22 0 self) ; "Good idea, Freddy. The spectrum lines on that etched glass viewer reveal volumes to those who know how to read."
			)
			(3
				(gCurRoom setInset: spectroInset self)
			)
			(4
				(gGame points: 10 155)
				(self dispose:)
			)
		)
	)
)

(instance bottle1 of LabItem
	(properties
		x 56
		y 37
		noun 1
		view 620
		objName 6
		amount -1
		moveable 1
		startX 56
		startY 37
	)
)

(instance bottle2 of LabItem
	(properties
		x 71
		y 39
		noun 2
		view 620
		cel 1
		objName 7
		amount -1
		moveable 1
		startX 71
		startY 39
	)
)

(instance bottle3 of LabItem
	(properties
		x 86
		y 37
		noun 3
		view 620
		cel 2
		objName 8
		amount -1
		moveable 1
		startX 86
		startY 37
	)
)

(instance bottle4 of LabItem
	(properties
		x 101
		y 40
		noun 4
		view 620
		loop 1
		objName 9
		amount -1
		moveable 1
		startX 101
		startY 40
	)
)

(instance bottle5 of LabItem
	(properties
		x 121
		y 39
		noun 17
		view 620
		loop 1
		cel 1
		objName 10
		amount -1
		moveable 1
		startX 121
		startY 39
	)
)

(instance bottle6 of LabItem
	(properties
		x 138
		y 40
		noun 18
		view 620
		loop 1
		cel 3
		objName 11
		amount -1
		moveable 1
		startX 138
		startY 40
	)
)

(instance bottle7 of LabItem
	(properties
		x 154
		y 38
		noun 19
		view 620
		loop 2
		objName 12
		amount -1
		moveable 1
		startX 154
		startY 38
	)
)

(instance bottle8 of LabItem
	(properties
		x 167
		y 39
		noun 20
		view 620
		loop 1
		cel 2
		objName 13
		amount -1
		moveable 1
		startX 167
		startY 39
	)
)

(instance bottle9 of LabItem
	(properties
		x 179
		y 41
		noun 21
		view 620
		loop 2
		cel 1
		objName 14
		moveable 1
		startX 179
		startY 41
	)
)

(instance bottle10 of LabItem
	(properties
		x 192
		y 39
		noun 22
		view 620
		loop 1
		cel 4
		objName 15
		amount -1
		moveable 1
		startX 192
		startY 39
	)
)

(instance bottle11 of LabItem
	(properties
		x 133
		y 72
		noun 23
		view 620
		cel 4
		objType 4
		objName 39
		moveable 1
		startX 133
		startY 72
	)

	(method (exchangeItem)
		(cond
			((== (global142 objName:) 39)
				(medicineBottle cue:)
				(= global142 0)
				(proc625_1)
				(proc625_0 self)
			)
			((gCast contains: medicineBottle)
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				(gMessager say: 59 0 15) ; "You only need to work with one medicine bottle at a time. Dump the contents if you need to start over."
			)
			(else
				((= gTheCursor ((gTheIconBar curIcon:) cursor:))
					view: view
					setLoop: loop
					setCel: (+ cel 1)
					init:
				)
				(global142
					posn: gMouseX gMouseY
					show:
					setPri: 15
					setLoop: (global142 loop:)
					setMotion:
						MoveTo
						(global142 startX:)
						(global142 startY:)
						global142
				)
				(medicineBottle
					init:
					hide:
					contents: (self contents:)
					amount: (self amount:)
					form: (self form:)
				)
				(self contents: 0 amount: 0)
				(= global142 medicineBottle)
			)
		)
	)

	(method (touchItem)
		(if (gCast contains: medicineBottle)
			(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			(gMessager say: 59 0 15) ; "You only need to work with one medicine bottle at a time. Dump the contents if you need to start over."
		else
			((= gTheCursor ((gTheIconBar curIcon:) cursor:))
				view: view
				setLoop: loop
				setCel: (+ cel 1)
				init:
			)
			(medicineBottle
				init:
				hide:
				contents: (self contents:)
				amount: (self amount:)
				form: (self form:)
			)
			(self contents: 0 amount: 0)
			(= global142 medicineBottle)
			(proc625_0 self)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance medicineBottle of LabItem
	(properties
		noun 59
		view 620
		cel 5
		objType 4
		objName 39
		moveable 1
		startX 133
		startY 79
	)

	(method (cue)
		(if global143
			(gCurRoom doVerb: 8)
		else
			(bottle11
				contents: (self contents:)
				amount: (self amount:)
				form: (self form:)
			)
			(self contents: 0 amount: 0 dispose:)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance bottle13 of LabItem
	(properties
		x 158
		y 78
		noun 40
		view 620
		cel 3
		objName 16
		amount -1
		moveable 1
		startX 158
		startY 78
	)
)

(instance crucible1 of LabItem
	(properties
		x 136
		y 117
		noun 63
		view 621
		loop 4
		objType 5
		objName 48
		form 26
		moveable 1
		startX 136
		startY 117
	)

	(method (doVerb theVerb)
		(cond
			(
				(or
					(< gMouseY 130)
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
						(not global142)
					)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 53) ; Medallion
				(gEgo put: 33) ; Medallion
				(gGame setCursor: ((gTheIconBar at: 2) cursor:))
				(gTheIconBar select: (gTheIconBar at: 2))
				(self contents: 25 amount: 1 contentState: 49)
				(proc625_0 self)
			)
			((and (== theVerb 69) (== contents 25) (== contentState 51)) ; Empty_Mold
				(gMessager say: 66 69) ; "You quickly pour the molten silver into the empty mold."
				(gEgo put: 19 get: -1 53) ; Empty_Mold, Silver_Filled_Mold
				(= contents (= amount 0))
				(= contentState 49)
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: ((gInventory at: 53) cursor: 87 yourself:) ; Silver_Filled_Mold
					enable: (gTheIconBar at: 5)
				)
				((gTheIconBar curIcon:) cursor: 87)
				(gGame setCursor: ((gTheIconBar at: 5) cursor:))
				(gTheIconBar select: (gTheIconBar at: 5))
				(proc625_0 self)
			)
			(else
				(gMessager say: noun 0 25) ; "The crucible is only for melting pure (or almost pure) metals."
			)
		)
	)
)

(instance solid1 of LabItem
	(properties
		x 178
		y 77
		noun 26
		view 620
		loop 10
		objName 17
		amount -1
		form 26
		moveable 1
		startX 178
		startY 77
	)
)

(instance solid2 of LabItem
	(properties
		x 200
		y 77
		noun 27
		view 621
		loop 5
		objName 18
		amount -1
		form 26
		moveable 1
		startX 200
		startY 77
	)
)

(instance solid3 of LabItem
	(properties
		x 224
		y 78
		noun 28
		view 621
		loop 6
		objName 19
		amount -1
		form 26
		moveable 1
		startX 224
		startY 78
	)
)

(instance solid4 of LabItem
	(properties
		x 249
		y 78
		noun 29
		view 621
		loop 7
		objName 20
		amount -1
		form 26
		moveable 1
		startX 249
		startY 78
	)
)

(instance solid5 of LabItem
	(properties
		x 209
		y 40
		noun 44
		view 621
		loop 5
		objName 21
		amount -1
		form 26
		moveable 1
		startX 209
		startY 40
	)
)

(instance solid6 of LabItem
	(properties
		x 232
		y 41
		noun 45
		view 621
		loop 6
		objName 22
		amount -1
		form 26
		moveable 1
		startX 232
		startY 41
	)
)

(instance solid7 of LabItem
	(properties
		x 258
		y 40
		noun 46
		view 620
		loop 10
		objName 23
		amount -1
		form 26
		moveable 1
		startX 258
		startY 40
	)
)

(instance solidBox1 of LabItem
	(properties
		x 56
		y 78
		noun 24
		view 620
		loop 8
		objName 24
		amount -1
		form 26
		moveable 1
		startX 56
		startY 78
	)
)

(instance solidBoxes of LabItem
	(properties
		x 82
		y 79
		noun 58
		view 620
		loop 8
		cel 1
		objType 4
		objName 40
		form 26
		moveable 1
		startX 82
		startY 79
	)

	(method (exchangeItem)
		(cond
			((== (global142 objName:) 40)
				(solidBox cue:)
				(= global142 0)
				(proc625_1)
				(proc625_0 self)
			)
			((gCast contains: solidBox)
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				(gMessager say: 25 0 15) ; "You only need one prescription box at a time."
			)
			(else
				((= gTheCursor ((gTheIconBar curIcon:) cursor:))
					view: view
					setLoop: loop
					setCel: (+ cel 1)
					init:
				)
				(global142
					posn: gMouseX gMouseY
					show:
					setPri: 15
					setLoop: (global142 loop:)
					setMotion:
						MoveTo
						(global142 startX:)
						(global142 startY:)
						global142
				)
				(solidBox
					init:
					hide:
					contents: (self contents:)
					amount: (self amount:)
					form: (self form:)
				)
				(self contents: 0 amount: 0)
				(= global142 solidBox)
			)
		)
	)

	(method (touchItem)
		(if (gCast contains: solidBox)
			(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			(gMessager say: 25 0 15) ; "You only need one prescription box at a time."
		else
			((= gTheCursor ((gTheIconBar curIcon:) cursor:))
				view: view
				setLoop: loop
				setCel: (+ cel 1)
				init:
			)
			(solidBox
				init:
				hide:
				contents: (self contents:)
				amount: (self amount:)
				form: (self form:)
			)
			(self contents: 0 amount: 0)
			(= global142 solidBox)
			(proc625_0 self)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance solidBox of LabItem
	(properties
		noun 25
		view 620
		loop 8
		cel 2
		objType 4
		objName 40
		form 26
		moveable 1
		startX 90
		startY 79
	)

	(method (useItem)
		(cond
			((and (== (global142 objName:) 45) (global142 amount:))
				(if amount
					(= local4 0)
					(if
						(and
							(== form 31)
							(== ((global142 contents:) size:) (contents size:))
						)
						(for
							((= local2 0))
							(< local2 (contents size:))
							((++ local2))
							
							(= local4 0)
							(for
								((= local3 0))
								(< local3 (contents size:))
								((++ local3))
								
								(if
									(and
										(==
											((contents at: local2)
												chemicalName:
											)
											(((global142 contents:) at: local2)
												chemicalName:
											)
										)
										(==
											((contents at: local2)
												chemicalAmount:
											)
											(((global142 contents:) at: local2)
												chemicalAmount:
											)
										)
									)
									(= local4 1)
									(break)
								)
							)
							(if (== local4 0)
								(break)
							)
						)
					)
					(cond
						((!= form 31)
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: noun 77 28) ; "You can't mix powders in with what is already in the prescription box."
						)
						(local4
							(self
								amount: (+ amount 1)
								contentState: (global142 contentState:)
							)
							(global142 dispose:)
							(= global142 0)
							(proc625_1)
							(proc625_0 self)
							(if (== amount 6)
								(Animate (gCast elements:) 0)
								(gEgo put: 25 put: 26) ; Incorrect_Med, Incorrect_Med2
								(= global144 1)
								(if (or (== gCurPuzzle 4) (== gCurPuzzle 5))
									(if
										(and
											(== contentState 50)
											(== (contents size:) 2)
											(or
												(and
													(==
														((contents at: 0)
															chemicalName:
														)
														18
													)
													(==
														((contents at: 0)
															chemicalAmount:
														)
														15
													)
													(==
														((contents at: 1)
															chemicalName:
														)
														23
													)
													(==
														((contents at: 1)
															chemicalAmount:
														)
														15
													)
												)
												(and
													(==
														((contents at: 0)
															chemicalName:
														)
														23
													)
													(==
														((contents at: 0)
															chemicalAmount:
														)
														15
													)
													(==
														((contents at: 1)
															chemicalName:
														)
														18
													)
													(==
														((contents at: 1)
															chemicalAmount:
														)
														15
													)
												)
											)
										)
										(gEgo get: -1 36) ; Med_3
									else
										(gEgo get: -1 26) ; Incorrect_Med2
										(if (gEgo has: 36) ; Med_3
											(gEgo put: 36) ; Med_3
										)
									)
									(= global143 1)
									(gMessager say: 34 0 9 0 self) ; "You carefully label the container 'Madame Ovaree.'""
								else
									(gEgo get: -1 26) ; Incorrect_Med2
									(= global143 1)
									(gMessager say: 34 0 32 0 self) ; "Your fruitless experimentation completed, you exit your laboratory. Perhaps a chemical solution is uncalled for right now."
								)
							)
						)
						(else
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: noun 77 1) ; "The prescription box is for finished prescriptions ONLY, not for mixing ingredients."
						)
					)
				else
					(self
						contents: (List new:)
						form: 31
						amount: 1
						contentState: (global142 contentState:)
					)
					(for
						((= local2 0))
						(< local2 ((global142 contents:) size:))
						((++ local2))
						
						(contents
							addToEnd:
								((ChemicalObj new:)
									chemicalName:
										(((global142 contents:) at: local2)
											chemicalName:
										)
									chemicalAmount:
										(((global142 contents:) at: local2)
											chemicalAmount:
										)
								)
						)
					)
					(global142 dispose:)
					(= global142 0)
					(proc625_1)
					(proc625_0 self)
				)
			)
			((== form 31)
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				(gMessager say: noun 77 17) ; "You can't mix items in the prescription box. It's for finished powders only."
			)
			(else
				(super useItem:)
			)
		)
	)

	(method (cue)
		(if global143
			(gCurRoom doVerb: 8)
		else
			(solidBoxes
				contents: (self contents:)
				amount: (self amount:)
				form: (self form:)
			)
			(self contents: 0 amount: 0 dispose:)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance beaker1 of LabItem
	(properties
		x 183
		y 118
		noun 48
		view 621
		loop 1
		objType 3
		objName 36
		form 0
		moveable 1
		startX 183
		startY 118
	)

	(method (cue)
		(if (and global142 (== (global142 objName:) 43))
			(self setLoop: 1 stopUpd:)
			(gGameMusic2 stop:)
			(gGame handsOn:)
			(gTheIconBar disable: 1 3 7)
		else
			(super cue:)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance corks of LabItem
	(properties
		x 234
		y 118
		noun 30
		view 620
		loop 12
		moveable 1
		startX 234
		startY 118
	)

	(method (exchangeItem)
		(if (not (StrCmp (global142 name:) (Cork name:)))
			(= global142 0)
			(proc625_1)
		else
			((= gTheCursor ((gTheIconBar curIcon:) cursor:))
				view: view
				setLoop: loop
				setCel: (+ cel 1)
				init:
			)
			(global142
				posn: gMouseX gMouseY
				show:
				setPri: 15
				setLoop: (global142 loop:)
				setMotion:
					MoveTo
					(global142 startX:)
					(global142 startY:)
					global142
			)
			((= global142 (Cork new:)) init: hide:)
		)
	)

	(method (touchItem)
		((= gTheCursor ((gTheIconBar curIcon:) cursor:))
			view: view
			setLoop: loop
			setCel: (+ cel 1)
			init:
		)
		((= global142 (Cork new:)) init: hide:)
	)
)

(instance Cork of LabItem
	(properties
		noun 42
		view 620
		loop 12
		cel 1
		objType 5
		objName 42
		form 26
		moveable 1
		startX 234
		startY 115
	)

	(method (cue)
		(self dispose:)
	)
)

(instance paper1 of LabItem
	(properties
		x 207
		y 118
		noun 31
		view 620
		loop 11
		moveable 1
		startX 207
		startY 118
	)

	(method (exchangeItem)
		(if (== (global142 objName:) 45)
			(= global142 0)
			(proc625_1)
		else
			((= gTheCursor ((gTheIconBar curIcon:) cursor:))
				view: view
				setLoop: loop
				setCel: (+ cel 1)
				init:
			)
			(global142
				posn: gMouseX gMouseY
				show:
				setPri: 15
				setLoop: (global142 loop:)
				setMotion:
					MoveTo
					(global142 startX:)
					(global142 startY:)
					global142
			)
			((= global142 (paperSheet new:)) init: hide:)
		)
	)

	(method (touchItem)
		((= gTheCursor ((gTheIconBar curIcon:) cursor:))
			view: view
			setLoop: loop
			setCel: (+ cel 1)
			init:
		)
		((= global142 (paperSheet new:)) init: hide:)
	)
)

(instance paperSheet of LabItem
	(properties
		noun 41
		view 620
		loop 11
		cel 1
		objType 5
		objName 45
		form 26
		moveable 1
		startX 208
		startY 112
	)

	(method (touchItem)
		(if amount
			((= gTheCursor ((gTheIconBar curIcon:) cursor:))
				view: view
				setLoop: 13
				setCel: 0
				init:
			)
			(self startX: x startY: y hide:)
			(= global142 self)
		else
			(self startX: 208 startY: 112)
			(super touchItem:)
		)
	)

	(method (useItem)
		(cond
			(
				(and
					(== (global142 objName:) 35)
					(== (global142 amount:) 0)
					(== amount 0)
				)
				(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
				(gMessager say: 51) ; "You knock them together, but otherwise accomplish nothing."
			)
			(
				(and
					(== (global142 objName:) 35)
					(== (global142 amount:) 0)
					amount
				)
				(global142
					contents: (List new:)
					amount: amount
					form: form
					contentState: contentState
				)
				(for ((= local2 0)) (< local2 (contents size:)) ((++ local2))
					((global142 contents:)
						addToEnd:
							((ChemicalObj new:)
								chemicalName:
									((contents at: local2) chemicalName:)
								chemicalAmount:
									((contents at: local2) chemicalAmount:)
							)
					)
				)
				(contents dispose:)
				(= form (= amount (= contents 0)))
				(= contentState 49)
				(self setCel: (-- cel))
				(proc625_0 self)
			)
			(
				(and
					(== (global142 objName:) 35)
					(global142 amount:)
					(== amount 0)
				)
				(= contents (List new:))
				(= amount (global142 amount:))
				(= form (global142 form:))
				(= contentState (global142 contentState:))
				(for
					((= local2 0))
					(< local2 ((global142 contents:) size:))
					((++ local2))
					
					(contents
						addToEnd:
							((ChemicalObj new:)
								chemicalName:
									(((global142 contents:) at: local2)
										chemicalName:
									)
								chemicalAmount:
									(((global142 contents:) at: local2)
										chemicalAmount:
									)
							)
					)
				)
				((global142 contents:) dispose:)
				(global142 contents: 0 amount: 0 form: 0 contentState: 49)
				(self setCel: (++ cel))
				(proc625_0 self)
			)
			((and (== (global142 objName:) 35) (global142 amount:) amount)
				(gMessager say: noun 81 11) ; "The medicinal papers can only hold 5 grams."
			)
			(else
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			)
		)
	)

	(method (cue)
		(if amount
			(self
				view: view
				setLoop: 11
				setCel: 2
				setPri: -1
				ignoreActors: 1
				stopUpd:
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance stirringRods of LabItem
	(properties
		x 260
		y 101
		noun 47
		view 621
		loop 2
		moveable 1
		startX 260
		startY 101
	)

	(method (exchangeItem)
		(if (== (global142 objName:) 43)
			(global142 dispose:)
			(= global142 0)
			(proc625_1)
		else
			((= gTheCursor ((gTheIconBar curIcon:) cursor:))
				view: view
				setLoop: loop
				setCel: (+ cel 1)
				init:
			)
			(global142
				posn: gMouseX gMouseY
				show:
				setPri: 15
				setLoop: (global142 loop:)
				setMotion:
					MoveTo
					(global142 startX:)
					(global142 startY:)
					global142
			)
			((= global142 (rod new:)) init: hide:)
		)
	)

	(method (touchItem)
		((= gTheCursor ((gTheIconBar curIcon:) cursor:))
			view: view
			setLoop: loop
			setCel: (+ cel 1)
			init:
		)
		((= global142 (rod new:)) init: hide:)
	)
)

(instance rod of LabItem
	(properties
		noun 54
		view 621
		loop 2
		cel 1
		objType 5
		objName 43
		form 26
		moveable 1
		startX 254
		startY 115
	)

	(method (cue)
		(self dispose:)
	)
)

(instance matches1 of LabItem
	(properties
		x 154
		y 118
		noun 32
		view 620
		loop 9
		objType 5
		objName 44
		form 26
		moveable 1
		startX 154
		startY 118
	)
)

(instance mortar of LabItem
	(properties
		x 90
		y 116
		noun 33
		view 620
		loop 7
		objType 3
		objName 37
		form 26
		moveable 1
		startX 90
		startY 116
	)

	(method (touchItem)
		(if (and amount (== contentState 49))
			(gGame handsOff:)
			(= local7 1)
			(self setCycle: ForwardCounter 4 self)
			(gGameMusic2 number: 2623 loop: -1 flags: 1 play:)
			(= contentState 50)
		else
			(super touchItem:)
		)
	)

	(method (cue)
		(if local7
			(self setCel: 0 stopUpd:)
			(gGameMusic2 stop:)
			(= local7 0)
			(gGame handsOn:)
			(gTheIconBar disable: 1 3 7)
		else
			(super cue:)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance spatula1 of LabItem
	(properties
		x 113
		y 116
		noun 53
		view 620
		loop 6
		objType 2
		objName 35
		form 26
		moveable 1
		startX 113
		startY 116
	)

	(method (useItem)
		(if (== (global142 objType:) 3)
			(gMessager say: noun 76) ; "Click the spatula on the mixing device, not vice versa."
		else
			(super useItem:)
		)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance gradCylinder of LabItem
	(properties
		x 56
		y 118
		noun 35
		view 620
		loop 4
		objType 2
		objName 32
		moveable 1
		startX 56
		startY 118
	)
)

(instance testTube1 of LabItem
	(properties
		x 72
		y 117
		noun 39
		view 620
		loop 5
		objType 3
		objName 38
		form 0
		moveable 1
		startX 72
		startY 117
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance alcoholLamp of LabItem
	(properties
		x 84
		y 159
		noun 37
		view 622
		priority 4
		signal 16401
		objType 5
		objName 46
	)

	(method (touchItem)
		(if (== form 30)
			(gMessager say: noun 4 22) ; "You quickly lick your fingers and pinch out the alcohol lamp's flame."
			(self form: 49 setLoop: 0 setCel: 0 setCycle: 0 stopUpd:)
		else
			(gMessager say: noun 4) ; "The alcohol lamp feels cool to the touch."
		)
	)

	(method (useItem)
		(cond
			((== (global142 objName:) 47)
				(if (== form 30)
					(global142 ignoreActors: 1 posn: 100 163 show: stopUpd:)
					(proc625_1)
					(= global142 0)
				else
					(gMessager say: noun 80 23) ; "The alcohol lamp must be burning before you can use the gaseous spectroscope on it."
				)
			)
			((== (global142 objName:) 44)
				(cond
					((== form 30)
						(gMessager say: noun 79 22) ; "The lamp is already lit."
					)
					((IsFlag 93)
						(self setLoop: 1 setCycle: Fwd)
						(= form 30)
						(spectro ignoreActors: 1)
						(global142
							posn: gMouseX gMouseY
							show:
							setPri: 15
							setLoop: (global142 loop:)
							setMotion:
								MoveTo
								(global142 startX:)
								(global142 startY:)
								global142
						)
						(proc625_1)
						(= global142 0)
					)
					(else
						(gMessager say: noun 79 24) ; "The alcohol lamp is empty. You must first fill it with fuel before you can light it."
					)
				)
			)
			(
				(and
					(== (global142 objName:) 48)
					(== (global142 contents:) 25)
					(== (global142 contentState:) 51)
				)
				(gMessager say: noun 82 29) ; "Enough already with the melting silver! It's melted, it's melted!"
			)
			((and (== (global142 objName:) 48) (== (global142 contents:) 25))
				(if (== form 30)
					(if
						(or
							(gEgo has: 19) ; Empty_Mold
							(gEgo has: 60) ; Wax_Filled_Mold
							(and (gEgo has: 59) (gEgo has: 8)) ; Wax_Ear, Clay
							(and
								(gEgo has: 4) ; Candle_Wax
								(gEgo has: 27) ; Knife
								(gEgo has: 8) ; Clay
							)
						)
						(gGame handsOff:)
						(= global133 48)
						(gMessager say: noun 53 22 0 self) ; "The silver medallion slowly begins to melt."
					else
						(gMessager say: noun 53 25) ; "Excellent idea, but wait until you have somewhere to put the molten silver!"
					)
				else
					(gMessager say: noun 82 23) ; "You might want to light the alcohol lamp first, otherwise you'll be standing here a long time waiting for that silver to melt!"
				)
			)
			((== (global142 objName:) 48)
				(gMessager say: noun 82 12) ; "There is nothing inside the crucible to melt."
			)
			((== (global142 objType:) 1)
				(if (== form 30)
					(gMessager say: noun 72) ; "Measure your chemical and place it into a mixing device first, then heat it here."
				else
					(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				)
			)
			((== (global142 objType:) 3)
				(if (== (global142 objName:) 37)
					(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					(gMessager say: noun 76 1) ; "The mortar and pestle is not to be used for heating chemicals."
				)
				(if (== form 30)
					(cond
						((== (global142 amount:) 0)
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: noun 76 12) ; "There's no need to heat up the mixing device if there's nothing inside it."
						)
						((== (global142 objName:) 37)
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: noun 76 1) ; "The mortar and pestle is not to be used for heating chemicals."
						)
						(else
							(= global133 3)
							(gGame handsOff:)
							(gMessager say: noun 76 0 0 self) ; "The chemical warms slowly over the alcohol lamp."
							(cond
								((== (global142 contentState:) 49)
									(global142 contentState: 51)
								)
								((== (global142 contentState:) 50)
									(global142 contentState: 52)
								)
							)
						)
					)
				else
					(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				)
			)
			(else
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			)
		)
	)

	(method (doVerb theVerb)
		(= global133 theVerb)
		(switch theVerb
			(5 ; Elixir
				(SetFlag 93)
				(gEgo put: 17) ; Elixir
				(gGame points: 5)
				(gGame setCursor: ((gTheIconBar at: 2) cursor:))
				(gTheIconBar select: (gTheIconBar at: 2))
				(gMessager say: noun 5) ; "You fill the alcohol lamp with Dad Gumm's alcoholic elixir."
			)
			(64 ; Filled_Sack
				(cond
					(
						(and
							(< 91 (spectro x:) 110)
							(< 159 (spectro y:) 169)
							(== form 30)
						)
						(gCurRoom setScript: sDoSpectroLines)
					)
					((== form 30)
						(gCurRoom setScript: sDoPuff)
					)
					(else
						(gMessager say: noun theVerb 23) ; "Whew! What an aroma! You'd better do something about it before everyone leaves town."
					)
				)
			)
			(53 ; Medallion
				(if (== form 30)
					(gMessager say: noun theVerb) ; "You can't heat the medallion directly. You'd burn your hands."
				else
					(gMessager say: noun 53 23) ; "The medallion looks nice beside the cold alcohol lamp."
				)
			)
			(68 ; Wax_Filled_Mold
				(if (== form 30)
					(gGame handsOff:)
					(gMessager say: noun theVerb 22 0 self) ; "The wax in the mold slowly starts to melt."
				else
					(gMessager say: noun theVerb 23) ; "Nothing much happens."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(switch global133
			(48
				(gGame handsOn:)
				(gTheIconBar disable: 1 3 7)
				(global142 contentState: 51)
				(= global133 0)
			)
			(68
				(gGame handsOn:)
				(gTheIconBar disable: 1 3 7)
				(gEgo put: 60 get: -1 19) ; Wax_Filled_Mold, Empty_Mold
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: ((gInventory at: 19) cursor: 53 yourself:) ; Empty_Mold
					enable: (gTheIconBar at: 5)
				)
				((gTheIconBar curIcon:) cursor: 53)
				(gGame setCursor: ((gTheIconBar at: 5) cursor:))
				(gTheIconBar select: (gTheIconBar at: 5))
				(= global133 0)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 1 3 7)
				(= global133 0)
			)
			(else
				(super cue:)
			)
		)
	)
)

(instance spectro of LabItem
	(properties
		x 118
		y 158
		noun 62
		view 623
		objType 5
		objName 47
		moveable 1
		startX 118
		startY 158
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; Filled_Sack
				(if
					(and
						(< 91 (spectro x:) 110)
						(< 159 (spectro y:) 169)
						(== (alcoholLamp form:) 30)
					)
					(gCurRoom setScript: sDoSpectroLines)
				else
					(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					(gMessager say: noun theVerb 23) ; "The gaseous spectroscope doesn't work unless the alcohol lamp is lit and the spectroscope has been placed in front of the lamp."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillMachine of LabItem
	(properties
		x 54
		y 170
		noun 38
		view 621
		objType 4
		objName 41
	)

	(method (touchItem)
		(cond
			((== amount 0)
				(gMessager say: noun 4) ; "The pill machine is empty. You must first place a mixture into the machine before attempting to make pills."
			)
			((== form 29)
				(gMessager say: noun 4 16) ; "You can place the pills into a medicine bottle by clicking the bottle on the pills."
			)
			(else
				(gGame handsOff:)
				(gGameMusic2 number: 621 loop: 1 flags: 1 play: self)
				(self setCycle: End)
				(= local8 form)
				(= form 29)
				(-= amount local5)
				(if (<= amount 0)
					(= amount 0)
				)
				(proc625_0 self)
			)
		)
	)

	(method (useItem)
		(cond
			((== (global142 objType:) 4)
				(cond
					((and (== amount 0) (!= form 29))
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: noun 77 12) ; "The pill machine's empty, so there aren't any pills to collect. You must first put a mixture into the pill machine."
					)
					((== (global142 amount:) 0)
						(global142
							contents: (List new:)
							form: 29
							amount: 3
							contentState: contentState
						)
						(for
							((= local2 0))
							(< local2 (contents size:))
							((++ local2))
							
							((global142 contents:)
								addToEnd:
									((ChemicalObj new:)
										chemicalName:
											((contents at: local2)
												chemicalName:
											)
										chemicalAmount:
											((contents at: local2)
												chemicalAmount:
											)
									)
							)
						)
						(if (== form 29)
							(self setCycle: Beg self)
							(= form local8)
						else
							(gGame handsOff:)
							(gGameMusic2 number: 621 loop: 1 flags: 1 play: self)
							(self setCycle: Osc 1)
							(-= amount local5)
							(if (<= amount 0)
								(= amount 0)
								(= contentState 49)
								(contents dispose:)
								(= contents 0)
							)
						)
						(proc625_0 self)
					)
					(else
						(= local4 0)
						(if
							(and
								(== (global142 form:) 29)
								(==
									((global142 contents:) size:)
									(contents size:)
								)
							)
							(for
								((= local2 0))
								(< local2 (contents size:))
								((++ local2))
								
								(= local4 0)
								(for
									((= local3 0))
									(< local3 (contents size:))
									((++ local3))
									
									(if
										(and
											(==
												((contents at: local2)
													chemicalName:
												)
												(((global142 contents:)
														at: local2
													)
													chemicalName:
												)
											)
											(==
												((contents at: local2)
													chemicalAmount:
												)
												(((global142 contents:)
														at: local2
													)
													chemicalAmount:
												)
											)
										)
										(= local4 1)
										(break)
									)
								)
								(if (== local4 0)
									(break)
								)
							)
						)
						(cond
							((!= (global142 form:) 29)
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: noun 77 17) ; "You can't mix pills in with what's already in this container."
							)
							(local4
								(global142 amount: (+ (global142 amount:) 3))
								(if (== form 29)
									(self setCycle: Beg self)
									(= form local8)
								else
									(gGame handsOff:)
									(gGameMusic2
										number: 621
										loop: 1
										flags: 1
										play: self
									)
									(self setCycle: Osc 1)
									(-= amount local5)
								)
								(if (<= amount 0)
									(= amount 0)
									(= contentState 49)
									(= form 0)
									(contents dispose:)
									(= contents 0)
								)
								(proc625_0 self)
							)
							(else
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: noun 77 1) ; "Different types of pills shouldn't be mixed in the same container!"
							)
						)
					)
				)
			)
			((== (global142 objType:) 3)
				(cond
					((== (global142 amount:) 0)
						(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
						(gMessager say: 51) ; "You knock them together, but otherwise accomplish nothing."
					)
					(amount
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: noun 76 15) ; "You should use up the current batch of mixture in the pill machine before adding some more."
					)
					(
						(and
							(global142 amount:)
							(< ((global142 contents:) size:) 2)
						)
						(gMessager say: noun 73) ; "To make pills, you need a |c0|mixture|c| which contains at least one solid."
					)
					((or (== (global142 form:) 26) (== (global142 form:) 28))
						(if (== (global142 amount:) 0)
							(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
							(gMessager say: 51) ; "You knock them together, but otherwise accomplish nothing."
						else
							(= contents (global142 contents:))
							(= amount (global142 amount:))
							(= form (global142 form:))
							(= contentState (global142 contentState:))
							(global142
								contents: 0
								amount: 0
								form: 0
								contentState: 49
							)
							(if (== (mod amount 10) 0)
								(= local5 (/ amount 10))
							else
								(= local5 (/ amount 6))
							)
							(proc625_0 self)
						)
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: noun 76 1) ; "You must have at least one solid ingredient in a mixture to make pills."
					)
				)
			)
			((== (global142 objType:) 2)
				(gMessager say: noun 73) ; "To make pills, you need a |c0|mixture|c| which contains at least one solid."
			)
			(else
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
		(gGame handsOn:)
		(gTheIconBar disable: 1 3 7)
	)

	(method (dispose)
		(if amount
			(contents dispose:)
		)
		(super dispose:)
	)
)

(instance balance1 of LabItem
	(properties
		x 226
		y 162
		noun 52
		view 620
		loop 3
		objType 2
		objName 33
		form 34
	)

	(method (touchItem)
		(cond
			(amount
				(self setCel: 1)
				(= form 0)
				((= gTheCursor ((gTheIconBar curIcon:) cursor:))
					view: 620
					setLoop: 15
					setCel: 1
					init:
				)
				(balPan
					init:
					hide:
					setCel: 1
					contents: contents
					amount: amount
					form: 26
					startY: 132
				)
				(= global142 balPan)
				(= amount (= contents 0))
				(proc625_0 self)
			)
			((== form 34)
				(self setCel: 1)
				(= form 0)
				((= gTheCursor ((gTheIconBar curIcon:) cursor:))
					view: 620
					setLoop: 15
					setCel: 0
					init:
				)
				(balPan init: hide: setCel: 0 contents: 0 amount: 0 startY: 131)
				(= global142 balPan)
			)
			(else
				(gMessager say: noun 4) ; "Your finger weighs as much as it did yesterday."
			)
		)
	)

	(method (useItem)
		(cond
			(amount
				(cond
					((and (== (global142 objType:) 1) (== (global142 form:) 26))
						(if (== contents (global142 objName:))
							(+= amount 5)
							(proc625_0 self)
						else
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: noun 76 20) ; "You can't mix chemicals in the balance. Weigh one item at a time."
						)
					)
					((== (global142 objName:) 35)
						(cond
							(
								(and
									(global142 amount:)
									(== ((global142 contents:) size:) 1)
								)
								(if
									(==
										contents
										(((global142 contents:) at: 0)
											chemicalName:
										)
									)
									(+= amount 5)
									((global142 contents:) dispose:)
									(global142
										contents: 0
										amount: 0
										form: 0
										contentState: 49
									)
									(proc625_0 self)
								else
									(gGameMusic2
										number: 2926
										loop: 1
										flags: 1
										play:
									)
									(gMessager say: noun 76 20) ; "You can't mix chemicals in the balance. Weigh one item at a time."
								)
							)
							(
								(and
									(global142 amount:)
									(> ((global142 contents:) size:) 1)
								)
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: noun 76 1) ; "You don't need to weigh that mixture."
							)
							(else
								(global142
									amount: 5
									contents: (List new:)
									form: 26
									contentState: 49
								)
								((global142 contents:)
									addToEnd:
										((ChemicalObj new:)
											chemicalName: contents
											chemicalAmount: 5
										)
								)
								(-= amount 5)
								(if (== amount 0)
									(self setCel: 0 contents: 0 form: 34)
								)
								(proc625_0 self)
							)
						)
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					)
				)
			)
			((== form 34)
				(cond
					((and (== (global142 objType:) 1) (== (global142 form:) 26))
						(self
							setCel: 2
							contents: (global142 objName:)
							amount: 5
						)
						(proc625_0 self)
					)
					((== (global142 objName:) 35)
						(cond
							(
								(and
									(global142 amount:)
									(== ((global142 contents:) size:) 1)
								)
								(self
									setCel: 2
									contents:
										(((global142 contents:) at: 0)
											chemicalName:
										)
									amount: 5
								)
								((global142 contents:) dispose:)
								(global142
									contents: 0
									amount: 0
									form: 0
									contentState: 49
								)
								(proc625_0 self)
							)
							(
								(and
									(global142 amount:)
									(> ((global142 contents:) size:) 1)
								)
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: noun 76 1) ; "You don't need to weigh that mixture."
							)
							(else
								(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
								(gMessager say: 51) ; "You knock them together, but otherwise accomplish nothing."
							)
						)
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					)
				)
			)
			((and (== (global142 objType:) 1) (== (global142 form:) 26))
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				(gMessager say: noun 72 18) ; "You must first place the balance pan on the balance."
			)
			((== (global142 objName:) 35)
				(if (global142 amount:)
					(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					(gMessager say: noun 72 18) ; "You must first place the balance pan on the balance."
				else
					(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
					(gMessager say: 51) ; "You knock them together, but otherwise accomplish nothing."
				)
			)
			((== (global142 objName:) 34)
				(if (global142 amount:)
					(self
						setCel: 2
						contents: (global142 contents:)
						amount: (global142 amount:)
					)
					(proc625_0 self)
				else
					(self setCel: 0)
				)
				(= form 34)
				(global142 dispose:)
				(= global142 0)
				(proc625_1)
			)
			(else
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			)
		)
	)
)

(instance balPan of LabItem
	(properties
		noun 60
		view 620
		loop 15
		objType 2
		objName 34
		form 0
		startX 227
		startY 131
	)

	(method (useItem)
		(cond
			(amount
				(cond
					((and (== (global142 objType:) 1) (== (global142 form:) 26))
						(if (== contents (global142 objName:))
							(+= amount 5)
						else
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: noun 76 20) ; "You can't mix chemicals in the balance pan."
						)
					)
					((== (global142 objName:) 35)
						(cond
							(
								(and
									(global142 amount:)
									(== ((global142 contents:) size:) 1)
								)
								(if
									(==
										contents
										(((global142 contents:) at: 0)
											chemicalName:
										)
									)
									(+= amount 5)
									((global142 contents:) dispose:)
									(global142
										contents: 0
										amount: 0
										form: 0
										contentState: 49
									)
								else
									(gGameMusic2
										number: 2926
										loop: 1
										flags: 1
										play:
									)
									(gMessager say: noun 76 20) ; "You can't mix chemicals in the balance pan."
								)
							)
							(
								(and
									(global142 amount:)
									(> ((global142 contents:) size:) 1)
								)
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: noun 76 1) ; "The balance pan is only for measuring unmixed chemicals."
							)
							(else
								(global142
									amount: 5
									contents: (List new:)
									form: 26
									contentState: 49
								)
								((global142 contents:)
									addToEnd:
										((ChemicalObj new:)
											chemicalName: contents
											chemicalAmount: 5
										)
								)
								(-= amount 5)
								(if (== amount 0)
									(self setCel: 0 contents: 0 form: 34)
								)
							)
						)
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					)
				)
			)
			((and (== (global142 objType:) 1) (== (global142 form:) 26))
				(self setCel: 1 contents: (global142 objName:) amount: 5)
			)
			((== (global142 objName:) 35)
				(cond
					(
						(and
							(global142 amount:)
							(== ((global142 contents:) size:) 1)
						)
						(self
							setCel: 1
							contents:
								(((global142 contents:) at: 0) chemicalName:)
							amount: 5
						)
						((global142 contents:) dispose:)
						(global142
							contents: 0
							amount: 0
							form: 0
							contentState: 49
						)
					)
					(
						(and
							(global142 amount:)
							(> ((global142 contents:) size:) 1)
						)
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: noun 76 1) ; "The balance pan is only for measuring unmixed chemicals."
					)
					(else
						(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
						(gMessager say: 51) ; "You knock them together, but otherwise accomplish nothing."
					)
				)
			)
			(else
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			)
		)
	)

	(method (cue)
		(if amount
			(balance1 setCel: 2 contents: contents amount: amount)
		else
			(balance1 setCel: 0)
		)
		(balance1 form: 34)
		(self dispose:)
	)
)

(instance dumper of LabItem
	(properties
		x 260
		y 173
		noun 16
		view 620
		loop 14
	)

	(method (useItem)
		(cond
			((OneOf (global142 objName:) 43 42 45)
				(global142 dispose:)
				(= global142 0)
				(proc625_1)
				(gMessager say: 16 74 21) ; "You toss it into the waste receptacle."
			)
			(
				(or
					(== (global142 objType:) 1)
					(== (global142 amount:) 0)
					(and
						(== (global142 objName:) 48)
						(== (global142 contents:) 25)
					)
				)
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
				(gMessager say: 16 74 4) ; "Don't throw that away!"
			)
			(else
				(switch (global142 objName:)
					(35
						((spatula1 contents:) dispose:)
					)
					(36
						((beaker1 contents:) dispose:)
					)
					(37
						((mortar contents:) dispose:)
					)
					(38
						((testTube1 contents:) dispose:)
					)
					(39
						((medicineBottle contents:) dispose:)
					)
					(40
						((solidBox contents:) dispose:)
					)
					(34
						(global142 setCel: 0)
						((= gTheCursor ((gTheIconBar curIcon:) cursor:))
							view: 620
							setLoop: 15
							setCel: 0
							init:
						)
					)
				)
				(global142 amount: 0 contents: 0 form: 0 contentState: 49)
				(gMessager say: 16 74) ; "You drop the contents down the waste receptacle."
			)
		)
	)

	(method (touchItem)
		(gMessager say: noun 4) ; "Yucch! There's all sorts of discarded chemicals down there."
	)
)

(instance puff of View
	(properties
		x 100
		y 146
		view 623
		loop 1
		priority 15
		signal 16400
	)
)

(instance workArea of Feature
	(properties
		x 164
		y 113
		z -50
		nsTop 157
		nsLeft 94
		nsBottom 171
		nsRight 204
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and global142 (== (global142 objName:) 43))
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 47 0 14) ; "Putting the stirring rod on the table will contaminate it. Just use it to stir chemicals in the beaker, then discard it."
					)
					(global142
						(global142
							ignoreActors: 0
							posn: gMouseX (- gMouseY 10)
							show:
							stopUpd:
						)
						(proc625_1)
						(= global142 0)
					)
					(else
						(gMessager say: 55 4) ; "Your work area is a little dusty, but it's more than clean enough to continue your work."
					)
				)
			)
			(8 ; icon10
				(gCurRoom doVerb: 8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spectroInset of Inset
	(properties
		view 623
		loop 2
		x 105
		y 143
		disposeNotOnMe 1
	)

	(method (doVerb)
		(self dispose:)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheIconBar disable: 7)
	)
)

