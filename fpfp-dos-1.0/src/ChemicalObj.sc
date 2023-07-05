;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 625)
(include sci.sh)
(use Main)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	proc625_0 0
	proc625_1 1
)

(local
	local0 = 100
	local1 = 220
	local2 = 120
	local3 = 176
	local4
	local5
	local6
	local7
	local8
)

(procedure (proc625_0 param1 &tmp [temp0 80] [temp80 4])
	(StrCpy @temp0 (param1 name:))
	(if
		(and
			(or
				(and (!= (param1 amount:) 0) (!= (param1 objName:) 34))
				(== (param1 form:) 29)
			)
			(OneOf (param1 objType:) 2 3 4 5)
		)
		(cond
			((and (== (param1 objName:) 41) (== (param1 form:) 29))
				(Format @temp0 {%s (3 %s)} (param1 name:) {pills})
			)
			((== (param1 form:) 29)
				(Format
					@temp0
					{%s (%d %s)}
					(param1 name:)
					(param1 amount:)
					{pills}
				)
			)
			((== (param1 form:) 31)
				(if (> (param1 amount:) 1)
					(Format
						@temp0
						{%s (%d %s)}
						(param1 name:)
						(param1 amount:)
						{powders}
					)
				else
					(Format
						@temp0
						{%s (%d %s)}
						(param1 name:)
						(param1 amount:)
						{powder}
					)
				)
			)
			((== (param1 contents:) 25)
				(if (== (param1 contentState:) 51)
					(Format @temp0 {%s (%s)} (param1 name:) {molten silver})
				else
					(Format @temp0 {%s (%s)} (param1 name:) {w/ medallion})
				)
			)
			((or (== (param1 form:) 27) (== (param1 form:) 28))
				(Format @temp0 {%s (%d %s)} (param1 name:) (param1 amount:) {ml})
			)
			(else
				(Format @temp0 {%s (%d %s)} (param1 name:) (param1 amount:) {gm})
			)
		)
	)
	(TextSize @temp80 @temp0 2107 0)
	(Display {} dsRESTOREPIXELS global145)
	(= global145
		(Display
			@temp0
			dsCOLOR
			global134
			dsFONT
			2107
			dsCOORD
			(+ local0 (/ (- local2 (- [temp80 3] [temp80 1])) 2))
			local3
			dsSAVEPIXELS
		)
	)
)

(procedure (proc625_1)
	((= gTheCursor ((gTheIconBar at: 2) cursor:)) view: 2 loop: 0 cel: 0 init:)
)

(class ChemicalObj of Obj
	(properties
		chemicalName 0
		chemicalAmount 0
	)
)

(class LabItem of Actor
	(properties
		yStep 3
		signal 20481
		moveSpeed 1
		objType 1
		objName 0
		contents 0
		amount 0
		form 27
		contentState 49
		moveable 0
		startX 0
		startY 0
	)

	(method (init)
		(= name (Memory memALLOC_CRIT (Message msgSIZE 620 noun 0 0 1)))
		(Message msgGET 620 noun 0 0 1 name)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(Memory memFREE name)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(
						(and
							(not mover)
							(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
							global142
							(< gMouseY 130)
						)
						(self exchangeItem:)
					)
					(
						(and
							(not mover)
							(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
							global142
						)
						(self useItem:)
					)
					((and (not mover) (== (gTheIconBar curIcon:) (gTheIconBar at: 2)))
						(self touchItem:)
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

	(method (exchangeItem)
		((= gTheCursor ((gTheIconBar curIcon:) cursor:))
			view: view
			setLoop: loop
			setCel: cel
			init:
		)
		(self hide:)
		(global142
			posn: gMouseX gMouseY
			show:
			setPri: 15
			setLoop: (global142 loop:)
			setMotion: MoveTo (global142 startX:) (global142 startY:) global142
		)
		(= global142 self)
	)

	(method (useItem)
		(cond
			((== (global142 objType:) 1)
				(switch objType
					(2
						(switch objName
							(32
								(cond
									((== (global142 objName:) 14)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 73 13) ; "This bottle of Tyloxpolynide is empty! You never seem to have enough."
									)
									((== (global142 form:) 26)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 73 1) ; "The graduated cylinder should only be used for measuring liquids."
									)
									((== amount -1)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 72 2) ; "The graduated cylinder is full."
									)
									(
										(and
											(!= amount 0)
											(!= contents (global142 objName:))
										)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 72 3) ; "You must empty the graduated cylinder before using it to measure something else."
									)
									(else
										(if (== amount 0)
											(= amount 5)
											(= contents (global142 objName:))
											(= form (global142 form:))
										else
											(+= amount 5)
										)
										(proc625_0 self)
									)
								)
							)
							(35
								(cond
									((== (global142 form:) 27)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 53 73 1) ; "The spatula isn't suitable for measuring liquids."
									)
									((== amount 5)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 53 72 2) ; "The spatula is already full of something. Empty it into an appropriate container before you do anything else with it."
									)
									(else
										(= amount 5)
										((= contents (List new:))
											addToEnd:
												((ChemicalObj new:)
													chemicalName:
														(global142 objName:)
													chemicalAmount: 5
												)
										)
										(= form (global142 form:))
										(= contentState 49)
										(proc625_0 self)
									)
								)
							)
						)
					)
					(3
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 49 72) ; "It is advisable to measure your ingredients instead of just dumping them together."
					)
					(4
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 50 72) ; "This container is for your finished product, not for mixing. Do your mixing in the proper device."
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					)
				)
			)
			((== (global142 objType:) 2)
				(switch objType
					(1
						(switch (global142 objName:)
							(32
								(cond
									((== objName 14)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 73 13) ; "This bottle of Tyloxpolynide is empty! You never seem to have enough."
									)
									((== form 26)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 73 1) ; "The graduated cylinder should only be used for measuring liquids."
									)
									((== (global142 amount:) -1)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 72 2) ; "The graduated cylinder is full."
									)
									(
										(and
											(!= (global142 amount:) 0)
											(!= (global142 contents:) objName)
										)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 35 72 3) ; "You must empty the graduated cylinder before using it to measure something else."
									)
									((== (global142 amount:) 0)
										(global142 amount: 5)
										(global142 contents: objName)
										(global142 form: form)
									)
									(else
										(global142
											amount: (+ (global142 amount:) 5)
										)
									)
								)
							)
							(35
								(cond
									((== form 27)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 53 73 1) ; "The spatula isn't suitable for measuring liquids."
									)
									((== (global142 amount:) 5)
										(gGameMusic2
											number: 2926
											loop: 1
											flags: 1
											play:
										)
										(gMessager say: 53 72 2) ; "The spatula is already full of something. Empty it into an appropriate container before you do anything else with it."
									)
									(else
										(global142
											amount: 5
											contents: (List new:)
											form: form
											contentState: 49
										)
										((global142 contents:)
											addToEnd:
												((ChemicalObj new:)
													chemicalName: objName
													chemicalAmount: 5
												)
										)
									)
								)
							)
						)
					)
					(3
						(cond
							(
								(and
									(== objName 37)
									(!= (global142 amount:) 0)
									(== (global142 form:) 27)
								)
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: 49 73 10) ; "The mortar & pestle is for grinding solids only."
							)
							(
								(and
									(== (global142 objName:) 35)
									(== (global142 amount:) 0)
									(== form 27)
								)
								(gMessager say: 53 73 1) ; "The spatula isn't suitable for measuring liquids."
							)
							(
								(and
									(== (global142 objName:) 35)
									(== (global142 amount:) 0)
									amount
								)
								(global142
									contents: (List new:)
									amount: 5
									form: form
									contentState: contentState
								)
								(for
									((= local4 0))
									(< local4 (contents size:))
									((++ local4))
									
									((global142 contents:)
										addToEnd:
											((ChemicalObj new:)
												chemicalName:
													((contents at: local4)
														chemicalName:
													)
												chemicalAmount:
													((contents at: local4)
														chemicalAmount:
													)
											)
									)
								)
								(-= amount 5)
								(if (== amount 0)
									(contents dispose:)
									(= form (= contents 0))
									(= contentState 49)
								)
								(proc625_0 self)
							)
							(
								(and
									(== (global142 objName:) 35)
									(> (global142 amount:) 0)
									(> ((global142 contents:) size:) 1)
								)
								(gMessager say: 49 81 25) ; "Only place one chemical at a time into the mixing device. Thank you!"
							)
							(
								(and
									(== (global142 objName:) 35)
									(> (global142 amount:) 0)
									(== ((global142 contents:) size:) 1)
								)
								(if amount
									(for
										((= local4 0))
										(and
											(< local4 (contents size:))
											(!=
												((contents at: local4)
													chemicalName:
												)
												(((global142 contents:) at: 0)
													chemicalName:
												)
											)
										)
										((++ local4))
									)
									(if (< local4 (contents size:))
										((contents at: local4)
											chemicalAmount:
												(+
													((contents at: local4)
														chemicalAmount:
													)
													(global142 amount:)
												)
										)
									else
										(contents
											addToEnd:
												((ChemicalObj new:)
													chemicalName:
														(((global142 contents:)
																at: 0
															)
															chemicalName:
														)
													chemicalAmount:
														(global142 amount:)
												)
										)
									)
									(+= amount (global142 amount:))
									(if (> contentState 50)
										(= contentState 51)
									else
										(= contentState 49)
									)
									(switch (global142 form:)
										(26
											(if (== form 27)
												(= form 28)
											)
										)
										(27
											(if (== form 26)
												(= form 28)
											)
										)
									)
								else
									((= contents (List new:))
										addToEnd:
											((ChemicalObj new:)
												chemicalName:
													(((global142 contents:)
															at: 0
														)
														chemicalName:
													)
												chemicalAmount:
													(global142 amount:)
											)
									)
									(= amount (global142 amount:))
									(if (== (global142 form:) 27)
										(= form 27)
									else
										(= form 26)
									)
								)
								((global142 contents:) dispose:)
								(global142
									amount: 0
									contents: 0
									form: 0
									contentState: 49
								)
								(proc625_0 self)
							)
							((== (global142 amount:) 0)
								(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
								(gMessager say: 51)
							)
							(else
								(if amount
									(for
										((= local4 0))
										(and
											(< local4 (contents size:))
											(!=
												((contents at: local4)
													chemicalName:
												)
												(global142 contents:)
											)
										)
										((++ local4))
									)
									(if (< local4 (contents size:))
										((contents at: local4)
											chemicalAmount:
												(+
													((contents at: local4)
														chemicalAmount:
													)
													(global142 amount:)
												)
										)
									else
										(contents
											addToEnd:
												((ChemicalObj new:)
													chemicalName:
														(global142 contents:)
													chemicalAmount:
														(global142 amount:)
												)
										)
									)
									(+= amount (global142 amount:))
									(if (> contentState 50)
										(= contentState 51)
									else
										(= contentState 49)
									)
									(switch (global142 form:)
										(26
											(if (== form 27)
												(= form 28)
											)
										)
										(27
											(if (== form 26)
												(= form 28)
											)
										)
									)
								else
									((= contents (List new:))
										addToEnd:
											((ChemicalObj new:)
												chemicalName:
													(global142 contents:)
												chemicalAmount:
													(global142 amount:)
											)
									)
									(= amount (global142 amount:))
									(if (== (global142 form:) 27)
										(= form 27)
									else
										(= form 26)
									)
								)
								(global142 amount: 0)
								(global142 contents: 0)
								(global142 form: 0)
								(if (== (global142 objName:) 34)
									(global142 setCel: 0 form: 34)
									((= gTheCursor ((gTheIconBar curIcon:) cursor:))
										view: 620
										setLoop: 15
										setCel: 0
										init:
									)
								)
								(proc625_0 self)
							)
						)
					)
					(4
						(cond
							((== (global142 amount:) 0)
								(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
								(gMessager say: 51)
							)
							(amount
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: 50 73 11) ; "The medicine containers are for finished medications only. Once you've placed something in a container, you should discard it if you want to start over. Mix chemicals in a mixing device only."
							)
							(else
								((= contents (List new:))
									addToEnd:
										((ChemicalObj new:)
											chemicalName: (global142 contents:)
											chemicalAmount: (global142 amount:)
										)
								)
								(= amount (global142 amount:))
								(= form (global142 form:))
								(global142 amount: 0)
								(global142 contents: 0)
								(global142 form: 0)
								(if (== (global142 objName:) 34)
									(global142 setCel: 0 form: 34)
									((= gTheCursor ((gTheIconBar curIcon:) cursor:))
										view: 620
										setLoop: 15
										setCel: 0
										init:
									)
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
			((== (global142 objType:) 3)
				(switch objType
					(1
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 56 76) ; "Click the chemical on the mixing device, not vice versa."
					)
					(2
						(if (== (global142 amount:) 0)
							(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
							(gMessager say: 51)
						else
							(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							(gMessager say: 57 76) ; "There's no need to measure it now, it's already mixed."
						)
					)
					(4
						(cond
							((== (global142 amount:) 0)
								(gGameMusic2 number: 2731 flags: 1 loop: 1 play:)
								(gMessager say: 51)
							)
							(amount
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: 50 73 11) ; "The medicine containers are for finished medications only. Once you've placed something in a container, you should discard it if you want to start over. Mix chemicals in a mixing device only."
							)
							(else
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
								(proc625_0 self)
							)
						)
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					)
				)
			)
			((== (global142 objType:) 4)
				(switch objType
					(1
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 56 77) ; "Place the chemical into the container, not vice versa."
					)
					(2
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 57 77) ; "Click the measuring device on the container, not vice versa."
					)
					(3
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
						(gMessager say: 49 77) ; "Click the mixture on the container, not vice versa."
					)
					(else
						(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
					)
				)
			)
			((== (global142 objType:) 5)
				(switch (global142 objName:)
					(42
						(cond
							((and (== objType 4) (== amount 0) (!= objName 40))
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
								(gMessager say: 50 75 12) ; "There's no reason to cork an empty bottle!"
							)
							((and (== objType 4) (!= objName 40))
								(proc625_1)
								(self view: view setLoop: loop setCel: (++ cel))
								(Animate (gCast elements:) 1)
								(= global144 1)
								(gEgo put: 25 put: 26) ; Incorrect_Med, Incorrect_Med2
								(switch gCurPuzzle
									(2
										(cond
											(
												(and
													(== (contents size:) 1)
													(==
														((contents at: 0)
															chemicalName:
														)
														10
													)
													(==
														((contents at: 0)
															chemicalAmount:
														)
														40
													)
												)
												(gEgo get: -1 34) ; Med_1
												(ClearFlag 104)
											)
											(
												(and
													(== (contents size:) 1)
													(==
														((contents at: 0)
															chemicalName:
														)
														10
													)
												)
												(SetFlag 104)
												(gEgo get: -1 25) ; Incorrect_Med
												(if (gEgo has: 34) ; Med_1
													(gEgo put: 34) ; Med_1
												)
											)
											(else
												(ClearFlag 104)
												(gEgo get: -1 25) ; Incorrect_Med
												(if (gEgo has: 34) ; Med_1
													(gEgo put: 34) ; Med_1
												)
											)
										)
										(= global143 1)
										(gMessager say: 34 0 5 0 self) ; "You carefully label the container 'Miss Penelope Primm -- for internal use only.' And what internals they are! You dream about them day and night!"
									)
									(3
										(if
											(and
												(== form 29)
												(== contentState 50)
												(== (contents size:) 2)
												(or
													(and
														(==
															((contents at: 0)
																chemicalName:
															)
															6
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
															17
														)
														(==
															((contents at: 1)
																chemicalAmount:
															)
															30
														)
													)
													(and
														(==
															((contents at: 1)
																chemicalName:
															)
															6
														)
														(==
															((contents at: 1)
																chemicalAmount:
															)
															15
														)
														(==
															((contents at: 0)
																chemicalName:
															)
															17
														)
														(==
															((contents at: 0)
																chemicalAmount:
															)
															30
														)
													)
												)
											)
											(if (== amount 21)
												(ClearFlag 104)
												(gEgo get: -1 35) ; Med_2
											else
												(SetFlag 104)
												(gEgo get: -1 25) ; Incorrect_Med
												(if (gEgo has: 35) ; Med_2
													(gEgo put: 35) ; Med_2
												)
											)
										else
											(ClearFlag 104)
											(gEgo get: -1 25) ; Incorrect_Med
											(if (gEgo has: 35) ; Med_2
												(gEgo put: 35) ; Med_2
											)
										)
										(= global143 1)
										(gMessager say: 34 0 6 0 self) ; "You carefully label the container 'Mrs. Helen Back -- take three times daily, just before meals.'"
									)
									(4
										(if (gEgo has: 58) ; Under_Glass
											(if
												(and
													(== amount 75)
													(== contentState 52)
													(== (contents size:) 4)
												)
												(= local5 0)
												(for
													((= local4 0))
													(< local4 4)
													((++ local4))
													
													(if
														(and
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalName:
																)
																8
															)
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalAmount:
																)
																10
															)
														)
														(= local5 1)
														(break)
													)
												)
												(= local6 0)
												(for
													((= local4 0))
													(< local4 4)
													((++ local4))
													
													(if
														(and
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalName:
																)
																19
															)
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalAmount:
																)
																30
															)
														)
														(= local6 1)
														(break)
													)
												)
												(= local7 0)
												(for
													((= local4 0))
													(< local4 4)
													((++ local4))
													
													(if
														(and
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalName:
																)
																21
															)
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalAmount:
																)
																5
															)
														)
														(= local7 1)
														(break)
													)
												)
												(= local8 0)
												(for
													((= local4 0))
													(< local4 4)
													((++ local4))
													
													(if
														(and
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalName:
																)
																15
															)
															(==
																((contents
																		at:
																			local4
																	)
																	chemicalAmount:
																)
																30
															)
														)
														(= local8 1)
														(break)
													)
												)
												(if
													(and
														local5
														local6
														local7
														local8
													)
													(SetFlag 95)
												else
													(ClearFlag 95)
												)
											else
												(ClearFlag 95)
											)
											(= global143 1)
											(gEgo get: -1 25) ; Incorrect_Med
											(gMessager say: 34 0 9 0 self)
										else
											(gEgo get: -1 25) ; Incorrect_Med
											(= global143 1)
											(gMessager say: 34 0 32 0 self) ; "Your fruitless experimentation completed, you exit your laboratory. Perhaps a chemical solution is uncalled for right now."
										)
									)
									(9
										(if
											(and
												(== amount 105)
												(== contentState 50)
												(== (contents size:) 4)
											)
											(= local5 0)
											(for
												((= local4 0))
												(< local4 4)
												((++ local4))
												
												(if
													(and
														(==
															((contents
																	at: local4
																)
																chemicalName:
															)
															20
														)
														(==
															((contents
																	at: local4
																)
																chemicalAmount:
															)
															40
														)
													)
													(= local5 1)
													(break)
												)
											)
											(= local6 0)
											(for
												((= local4 0))
												(< local4 4)
												((++ local4))
												
												(if
													(and
														(==
															((contents
																	at: local4
																)
																chemicalName:
															)
															9
														)
														(==
															((contents
																	at: local4
																)
																chemicalAmount:
															)
															15
														)
													)
													(= local6 1)
													(break)
												)
											)
											(= local7 0)
											(for
												((= local4 0))
												(< local4 4)
												((++ local4))
												
												(if
													(and
														(==
															((contents
																	at: local4
																)
																chemicalName:
															)
															16
														)
														(==
															((contents
																	at: local4
																)
																chemicalAmount:
															)
															45
														)
													)
													(= local7 1)
													(break)
												)
											)
											(= local8 0)
											(for
												((= local4 0))
												(< local4 4)
												((++ local4))
												
												(if
													(and
														(==
															((contents
																	at: local4
																)
																chemicalName:
															)
															24
														)
														(==
															((contents
																	at: local4
																)
																chemicalAmount:
															)
															5
														)
													)
													(= local8 1)
													(break)
												)
											)
											(if
												(and
													local5
													local6
													local7
													local8
												)
												(gEgo get: -1 13) ; Deflatulizer
												(gGame points: 5 154)
												(= global143 1)
												(gMessager say: 34 0 26 0 self) ; "You carefully label the jar, 'Aminophyllic Citrate.' Congratulations. You've just created your first batch of "Pharkas' Deflatulizer\08.""
											else
												(if (gEgo has: 13) ; Deflatulizer
													(gEgo put: 13) ; Deflatulizer
												)
												(= global143 1)
												(gMessager say: 34 0 21 0 self) ; "Well, that was a fun experiment, but it's not going to help you out of your present mess! You throw it all away as you exit your lab."
											)
										else
											(if (gEgo has: 13) ; Deflatulizer
												(gEgo put: 13) ; Deflatulizer
											)
											(= global143 1)
											(gMessager say: 34 0 21 0 self) ; "Well, that was a fun experiment, but it's not going to help you out of your present mess! You throw it all away as you exit your lab."
										)
									)
									(13
										(if
											(and
												(== amount 30)
												(== contentState 51)
												(== (contents size:) 2)
												(or
													(and
														(==
															((contents at: 0)
																chemicalName:
															)
															11
														)
														(==
															((contents at: 0)
																chemicalAmount:
															)
															25
														)
														(==
															((contents at: 1)
																chemicalName:
															)
															13
														)
														(==
															((contents at: 1)
																chemicalAmount:
															)
															5
														)
													)
													(and
														(==
															((contents at: 0)
																chemicalName:
															)
															13
														)
														(==
															((contents at: 0)
																chemicalAmount:
															)
															5
														)
														(==
															((contents at: 1)
																chemicalName:
															)
															11
														)
														(==
															((contents at: 1)
																chemicalAmount:
															)
															25
														)
													)
												)
											)
											(gEgo get: -1 47) ; Pure_Solution
											(= global143 1)
											(gMessager say: 34 0 27 0 self) ; "You carefully label the bottle, "Bisalicylate Antitoxidene." Congratulations. Be careful; this stuff is mighty concentrated."
										else
											(if (gEgo has: 47) ; Pure_Solution
												(gEgo put: 47) ; Pure_Solution
											)
											(= global143 1)
											(gMessager say: 34 0 21 0 self) ; "Well, that was a fun experiment, but it's not going to help you out of your present mess! You throw it all away as you exit your lab."
										)
									)
									(else
										(ClearFlag 104)
										(gEgo get: -1 25) ; Incorrect_Med
										(= global143 1)
										(gMessager say: 34 0 32 0 self) ; "Your fruitless experimentation completed, you exit your laboratory. Perhaps a chemical solution is uncalled for right now."
									)
								)
							)
							(else
								(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
							)
						)
					)
					(43
						(if (and (== objName 36) amount)
							(gGame handsOff:)
							(self setLoop: 3 setCycle: ForwardCounter 4 self)
							(gGameMusic2 number: 2624 loop: -1 flags: 1 play:)
							(switch contentState
								(49
									(= contentState 50)
								)
								(51
									(= contentState 52)
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
			(else
				(gGameMusic2 number: 2926 loop: 1 flags: 1 play:)
			)
		)
	)

	(method (touchItem)
		((= gTheCursor ((gTheIconBar curIcon:) cursor:))
			view: view
			setLoop: loop
			setCel: cel
			init:
		)
		(self hide:)
		(= global142 self)
	)

	(method (cue)
		(if global143
			(gCurRoom doVerb: 8)
		else
			(self setPri: -1 ignoreActors: 1 stopUpd:)
		)
	)
)

