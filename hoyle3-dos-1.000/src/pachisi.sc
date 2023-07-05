;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use PiecesAtHome)
(use IconBar)
(use RandCycle)
(use Sound)
(use Game)
(use System)

(public
	pachisi 0
	proc400_1 1
	proc400_2 2
	player1 3
	player2 4
	player3 5
	player4 6
	pachisiPlayerList 7
	pachisiKMList 8
	rollSound 10
)

(local
	[local0 8] = [125 50 240 50 240 148 125 148]
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= [global407 1] 0)
	(= [global407 2] 0)
	(= [global407 3] 0)
	(= [global407 4] 0)
	(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
		(= temp1
			(switch temp0
				(1 player1)
				(2 player2)
				(3 player3)
				(4 player4)
			)
		)
		(if (!= (temp1 type:) 0)
			(temp1 add:)
			(localproc_1 temp1)
		)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(player1
			(player1
				initPawns:
					1
					blueStart
					pRect1
					pRect52
					blueRect1
					(ScriptID 402 6) ; bluePawn1
					(ScriptID 402 7) ; bluePawn2
					(ScriptID 402 8) ; bluePawn3
					(ScriptID 402 9) ; bluePawn4
					0
					0
					0
					0
			)
			(blueStart whoIsOn: player1)
			(= [global407 1] 1)
		)
		(player2
			(player2
				initPawns:
					2
					redStart
					pRect40
					pRect39
					redRect1
					(ScriptID 402 10) ; redPawn1
					(ScriptID 402 11) ; redPawn2
					(ScriptID 402 12) ; redPawn3
					(ScriptID 402 13) ; redPawn4
					8
					4
					12
					3
			)
			(redStart whoIsOn: player2)
			(= [global407 2] 1)
		)
		(player3
			(player3
				initPawns:
					3
					greenStart
					pRect27
					pRect26
					greenRect1
					(ScriptID 402 14) ; greenPawn1
					(ScriptID 402 15) ; greenPawn2
					(ScriptID 402 16) ; greenPawn3
					(ScriptID 402 17) ; greenPawn4
					16
					8
					24
					6
			)
			(greenStart whoIsOn: player3)
			(= [global407 3] 1)
		)
		(player4
			(player4
				initPawns:
					4
					yellowStart
					pRect14
					pRect13
					yellowRect1
					(ScriptID 402 18) ; yellowPawn1
					(ScriptID 402 19) ; yellowPawn2
					(ScriptID 402 20) ; yellowPawn3
					(ScriptID 402 21) ; yellowPawn4
					24
					12
					36
					9
			)
			(yellowStart whoIsOn: player4)
			(= [global407 4] 1)
		)
	)
)

(procedure (proc400_2 &tmp [temp0 40] temp40 temp41)
	(= temp40 (gSystemWindow color:))
	(= temp41 (gSystemWindow back:))
	(gSystemWindow color: 16 back: 21)
	(Format @global550 400 0) ; "SCORECARD   Percent Home --------------------------------"
	(if (player1 type:)
		(StrCat
			@global550
			(Format @temp0 400 1 (player1 playerName:) (player1 percentHome:)) ; "%-10s     %=3d"
		)
	)
	(if (player2 type:)
		(StrCat
			@global550
			(Format @temp0 400 1 (player2 playerName:) (player2 percentHome:)) ; "%-10s     %=3d"
		)
	)
	(if (player3 type:)
		(StrCat
			@global550
			(Format @temp0 400 1 (player3 playerName:) (player3 percentHome:)) ; "%-10s     %=3d"
		)
	)
	(if (player4 type:)
		(StrCat
			@global550
			(Format @temp0 400 1 (player4 playerName:) (player4 percentHome:)) ; "%-10s     %=3d"
		)
	)
	(gSong play: 806)
	(Print @global550 33 500 179 gDoAbsCode)
	(gSong fade:)
	(gSystemWindow color: temp40 back: temp41)
)

(procedure (proc400_1 param1)
	(proc0_4)
	(if param1
		(global414 eachElementDo: #pickup dispose:)
	)
	(if (not global404)
		(die1 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(die2 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(TheDice add:)
		(TheDice add: die1 die2)
		(rollSound number: 304)
		(= global509 2)
		(= global414 TheDice)
	else
		(shell1 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(shell2 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(shell3 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(shell4 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(shell5 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(shell6 init: rollScript: (ScriptID 402 3)) ; diceThrowScript
		(TheShells add:)
		(TheShells add: shell1 shell2 shell3 shell4 shell5 shell6)
		(rollSound number: 404)
		(= global509 6)
		(= global414 TheShells)
	)
	(global414
		eachElementDo: #taken 0
		eachElementDo: #saveData
		eachElementDo: #goToStart
	)
	(proc0_3)
	(return global404)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp1 0)
	(pachisiPlayerList add: player1 player2 player3 player4)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= temp3 (pachisiPlayerList at: temp0))
		(if (== (temp3 type:) 2)
			(= temp2 0)
			(while (not temp2)
				(= temp4 (Characters at: temp1))
				(if (temp4 active:)
					(temp4
						posn: [local0 (* 2 temp0)] [local0 (+ (* 2 temp0) 1)]
					)
					(temp3 character: temp4)
					(= temp2 1)
					(if (== (temp4 view:) 6)
						(temp4 y: (- (temp4 y:) 7))
					)
				)
				(++ temp1)
			)
		)
	)
	(pachisiPlayerList release:)
)

(instance pachisi of Rm
	(properties
		picture 400
		style 10
	)

	(method (init)
		(= gDebugOn 1)
		((= gPachisi_opt (ScriptID 410 1)) doit:) ; pachisi_opt
		(= picture global406)
		(Load rsSOUND 905)
		(Load rsSOUND 400)
		(Load rsSOUND 907)
		(Load rsSOUND 902)
		(Load rsSOUND 904)
		(Load rsSOUND 202)
		(Load rsSOUND 806)
		(Load rsSOUND 100)
		(Load rsSOUND 906)
		(Load rsSOUND 304)
		(Load rsSOUND 404)
		(super init:)
		(if (not (HaveMouse))
			(gGame setCursor: gTheCursor 1 310 180)
		)
		(gSong fade:)
		RandCycle
		(player1 skill: global190 type: global194 playerName: @global150)
		(player2 skill: global191 type: global195 playerName: @global157)
		(player3 skill: global192 type: global196 playerName: @global164)
		(player4 skill: global193 type: global197 playerName: @global171)
		(TheDice add:)
		(TheShells add:)
		(pachisiPlayerList add:)
		(pachisiKMList add:)
		(theGameSquares add:)
		(theGamePieces add:)
		(PiecesAtHome add:)
		(Updates add:)
		(Garbage add:)
		(= gTheGameSquares theGameSquares)
		(= gTheGamePieces theGamePieces)
		(= global181 0)
		(= global413 0)
		(= global401 0)
		(= global415 0)
		(= global417 0)
		(KeyMouse setList: pachisiKMList keyMouseCode: activeCode)
		(localproc_0)
		(localproc_2)
		(if (gChar1 active:)
			(gChar1 show: init:)
			(Load rsTEXT (+ (* (+ (gChar1 view:) 1) 1000) global187))
		)
		(if (gChar2 active:)
			(gChar2 show: init:)
			(Load rsTEXT (+ (* (+ (gChar2 view:) 1) 1000) global187))
		)
		(if (gChar3 active:)
			(gChar3 show: init:)
			(Load rsTEXT (+ (* (+ (gChar3 view:) 1) 1000) global187))
		)
		(Load rsTEXT 19400)
		(Characters init:)
		(Indicator init:)
		(Reminder init:)
		(theGameSquares
			add:
				pRect1
				pRect2
				pRect3
				pRect4
				pRect5
				pRect6
				pRect7
				pRect8
				pRect9
				pRect10
				pRect11
				pRect12
				pRect13
				pRect14
				pRect15
				pRect16
				pRect17
				pRect18
				pRect19
				pRect20
				pRect21
				pRect22
				pRect23
				pRect24
				pRect25
				pRect26
				pRect27
				pRect28
				pRect29
				pRect30
				pRect31
				pRect32
				pRect33
				pRect34
				pRect35
				pRect36
				pRect37
				pRect38
				pRect39
				pRect40
				pRect41
				pRect42
				pRect43
				pRect44
				pRect45
				pRect46
				pRect47
				pRect48
				pRect49
				pRect50
				pRect51
				pRect52
				blueRect1
				blueRect2
				blueRect3
				blueRect4
				blueRect5
				redRect1
				redRect2
				redRect3
				redRect4
				redRect5
				greenRect1
				greenRect2
				greenRect3
				greenRect4
				greenRect5
				yellowRect1
				yellowRect2
				yellowRect3
				yellowRect4
				yellowRect5
				blueStart
				redStart
				greenStart
				yellowStart
				homeSquare
		)
		(pRect1
			neighborN: 0
			neighborE: pRect52
			neighborS: pRect2
			neighborW: blueStart
		)
		(pRect2
			neighborN: pRect1
			neighborE: blueRect1
			neighborS: pRect3
			neighborW: blueStart
		)
		(pRect3
			neighborN: pRect2
			neighborE: blueRect2
			neighborS: pRect4
			neighborW: blueStart
		)
		(pRect4
			neighborN: pRect3
			neighborE: blueRect3
			neighborS: pRect5
			neighborW: blueStart
		)
		(pRect5
			neighborN: pRect4
			neighborE: blueRect4
			neighborS: pRect6
			neighborW: blueStart
		)
		(pRect6
			neighborN: pRect5
			neighborE: blueRect5
			neighborS: pRect20
			neighborW: pRect7
		)
		(pRect7
			neighborN: blueStart
			neighborE: pRect45
			neighborS: yellowRect5
			neighborW: pRect8
		)
		(pRect8
			neighborN: blueStart
			neighborE: pRect7
			neighborS: yellowRect4
			neighborW: pRect9
		)
		(pRect9
			neighborN: blueStart
			neighborE: pRect8
			neighborS: yellowRect3
			neighborW: pRect10
		)
		(pRect10
			neighborN: blueStart
			neighborE: pRect9
			neighborS: yellowRect2
			neighborW: pRect11
		)
		(pRect11
			neighborN: blueStart
			neighborE: pRect10
			neighborS: yellowRect1
			neighborW: pRect12
		)
		(pRect12
			neighborN: blueStart
			neighborE: pRect11
			neighborS: pRect13
			neighborW: 0
		)
		(pRect13
			neighborN: pRect12
			neighborE: yellowRect1
			neighborS: pRect14
			neighborW: 0
		)
		(pRect14
			neighborN: pRect13
			neighborE: pRect15
			neighborS: yellowStart
			neighborW: 0
		)
		(pRect15
			neighborN: yellowRect1
			neighborE: pRect16
			neighborS: yellowStart
			neighborW: pRect14
		)
		(pRect16
			neighborN: yellowRect2
			neighborE: pRect17
			neighborS: yellowStart
			neighborW: pRect15
		)
		(pRect17
			neighborN: yellowRect3
			neighborE: pRect18
			neighborS: yellowStart
			neighborW: pRect16
		)
		(pRect18
			neighborN: yellowRect4
			neighborE: pRect19
			neighborS: yellowStart
			neighborW: pRect17
		)
		(pRect19
			neighborN: yellowRect5
			neighborE: pRect33
			neighborS: pRect20
			neighborW: pRect18
		)
		(pRect20
			neighborN: pRect6
			neighborE: greenRect5
			neighborS: pRect21
			neighborW: yellowStart
		)
		(pRect21
			neighborN: pRect20
			neighborE: greenRect4
			neighborS: pRect22
			neighborW: yellowStart
		)
		(pRect22
			neighborN: pRect21
			neighborE: greenRect3
			neighborS: pRect23
			neighborW: yellowStart
		)
		(pRect23
			neighborN: pRect22
			neighborE: greenRect2
			neighborS: pRect24
			neighborW: yellowStart
		)
		(pRect24
			neighborN: pRect23
			neighborE: greenRect1
			neighborS: pRect25
			neighborW: yellowStart
		)
		(pRect25
			neighborN: pRect24
			neighborE: pRect26
			neighborS: 0
			neighborW: yellowStart
		)
		(pRect26
			neighborN: greenRect1
			neighborE: pRect27
			neighborS: 0
			neighborW: pRect25
		)
		(pRect27
			neighborN: pRect28
			neighborE: greenStart
			neighborS: 0
			neighborW: pRect26
		)
		(pRect28
			neighborN: pRect29
			neighborE: greenStart
			neighborS: pRect27
			neighborW: greenRect1
		)
		(pRect29
			neighborN: pRect30
			neighborE: greenStart
			neighborS: pRect28
			neighborW: greenRect2
		)
		(pRect30
			neighborN: pRect31
			neighborE: greenStart
			neighborS: pRect29
			neighborW: greenRect3
		)
		(pRect31
			neighborN: pRect32
			neighborE: greenStart
			neighborS: pRect30
			neighborW: greenRect4
		)
		(pRect32
			neighborN: pRect46
			neighborE: pRect33
			neighborS: pRect31
			neighborW: greenRect5
		)
		(pRect33
			neighborN: redRect5
			neighborE: pRect34
			neighborS: greenStart
			neighborW: pRect19
		)
		(pRect34
			neighborN: redRect4
			neighborE: pRect35
			neighborS: greenStart
			neighborW: pRect33
		)
		(pRect35
			neighborN: redRect3
			neighborE: pRect36
			neighborS: greenStart
			neighborW: pRect34
		)
		(pRect36
			neighborN: redRect2
			neighborE: pRect37
			neighborS: greenStart
			neighborW: pRect35
		)
		(pRect37
			neighborN: redRect1
			neighborE: pRect38
			neighborS: greenStart
			neighborW: pRect36
		)
		(pRect38
			neighborN: pRect39
			neighborE: 0
			neighborS: greenStart
			neighborW: pRect37
		)
		(pRect39
			neighborN: pRect40
			neighborE: 0
			neighborS: pRect38
			neighborW: redRect1
		)
		(pRect40
			neighborN: redStart
			neighborE: 0
			neighborS: pRect39
			neighborW: pRect41
		)
		(pRect41
			neighborN: redStart
			neighborE: pRect40
			neighborS: redRect1
			neighborW: pRect42
		)
		(pRect42
			neighborN: redStart
			neighborE: pRect41
			neighborS: redRect2
			neighborW: pRect43
		)
		(pRect43
			neighborN: redStart
			neighborE: pRect42
			neighborS: redRect3
			neighborW: pRect44
		)
		(pRect44
			neighborN: redStart
			neighborE: pRect43
			neighborS: redRect4
			neighborW: pRect45
		)
		(pRect45
			neighborN: pRect46
			neighborE: pRect44
			neighborS: redRect5
			neighborW: pRect7
		)
		(pRect46
			neighborN: pRect47
			neighborE: redStart
			neighborS: pRect32
			neighborW: blueRect5
		)
		(pRect47
			neighborN: pRect48
			neighborE: redStart
			neighborS: pRect46
			neighborW: blueRect4
		)
		(pRect48
			neighborN: pRect49
			neighborE: redStart
			neighborS: pRect47
			neighborW: blueRect3
		)
		(pRect49
			neighborN: pRect50
			neighborE: redStart
			neighborS: pRect48
			neighborW: blueRect2
		)
		(pRect50
			neighborN: pRect51
			neighborE: redStart
			neighborS: pRect49
			neighborW: blueRect1
		)
		(pRect51
			neighborN: 0
			neighborE: redStart
			neighborS: pRect50
			neighborW: pRect52
		)
		(pRect52
			neighborN: 0
			neighborE: pRect51
			neighborS: blueRect1
			neighborW: pRect1
		)
		(blueRect1
			neighborN: pRect52
			neighborE: pRect50
			neighborS: blueRect2
			neighborW: pRect2
		)
		(blueRect2
			neighborN: blueRect1
			neighborE: pRect49
			neighborS: blueRect3
			neighborW: pRect3
		)
		(blueRect3
			neighborN: blueRect2
			neighborE: pRect48
			neighborS: blueRect4
			neighborW: pRect4
		)
		(blueRect4
			neighborN: blueRect3
			neighborE: pRect47
			neighborS: blueRect5
			neighborW: pRect5
		)
		(blueRect5
			neighborN: blueRect4
			neighborE: pRect46
			neighborS: homeSquare
			neighborW: pRect6
		)
		(redRect1
			neighborN: pRect41
			neighborE: pRect39
			neighborS: pRect37
			neighborW: redRect2
		)
		(redRect2
			neighborN: pRect42
			neighborE: redRect1
			neighborS: pRect36
			neighborW: redRect3
		)
		(redRect3
			neighborN: pRect43
			neighborE: redRect2
			neighborS: pRect35
			neighborW: redRect4
		)
		(redRect4
			neighborN: pRect44
			neighborE: redRect3
			neighborS: pRect34
			neighborW: redRect5
		)
		(redRect5
			neighborN: pRect45
			neighborE: redRect4
			neighborS: pRect33
			neighborW: homeSquare
		)
		(greenRect1
			neighborN: greenRect2
			neighborE: pRect28
			neighborS: pRect26
			neighborW: pRect24
		)
		(greenRect2
			neighborN: greenRect3
			neighborE: pRect29
			neighborS: greenRect1
			neighborW: pRect23
		)
		(greenRect3
			neighborN: greenRect4
			neighborE: pRect30
			neighborS: greenRect2
			neighborW: pRect22
		)
		(greenRect4
			neighborN: greenRect5
			neighborE: pRect31
			neighborS: greenRect3
			neighborW: pRect21
		)
		(greenRect5
			neighborN: homeSquare
			neighborE: pRect32
			neighborS: greenRect4
			neighborW: pRect20
		)
		(yellowRect1
			neighborN: pRect11
			neighborE: yellowRect2
			neighborS: pRect15
			neighborW: pRect13
		)
		(yellowRect2
			neighborN: pRect10
			neighborE: yellowRect3
			neighborS: pRect16
			neighborW: yellowRect1
		)
		(yellowRect3
			neighborN: pRect9
			neighborE: yellowRect4
			neighborS: pRect17
			neighborW: yellowRect2
		)
		(yellowRect4
			neighborN: pRect8
			neighborE: yellowRect5
			neighborS: pRect18
			neighborW: yellowRect3
		)
		(yellowRect5
			neighborN: pRect7
			neighborE: homeSquare
			neighborS: pRect19
			neighborW: yellowRect4
		)
		(blueStart
			neighborN: 0
			neighborE: pRect1
			neighborS: pRect10
			neighborW: 0
		)
		(redStart
			neighborN: 0
			neighborE: 0
			neighborS: pRect40
			neighborW: pRect49
		)
		(greenStart
			neighborN: pRect36
			neighborE: 0
			neighborS: 0
			neighborW: pRect27
		)
		(yellowStart
			neighborN: pRect14
			neighborE: pRect23
			neighborS: 0
			neighborW: 0
		)
		(homeSquare
			neighborN: blueRect5
			neighborE: redRect5
			neighborS: greenRect5
			neighborW: yellowRect5
		)
		(proc0_1)
		((ScriptID 402 2) next: (ScriptID 402 4)) ; startScript, pachisiScript
		(self setScript: (ScriptID 402 2)) ; startScript
	)

	(method (doit &tmp temp0)
		(if (!= global406 picture)
			(IconBar disable:)
			(= picture global406)
			(gGame setCursor: 20 1)
			(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
				(UnLoad 133 ((gCast at: temp0) underBits:))
			)
			(DrawPic picture 10)
			(gGame setCursor: 999 1)
			(proc0_1)
			(IconBar enable:)
		)
		(if (and global416 (!= global404 global412))
			(= global412 (proc400_1 1))
		)
		(super doit: &rest)
		(if
			(and
				global178
				(== (global178 type:) 1)
				(global414 allTrue: 663)
				(not (global178 firstTrue: #script))
			)
			((ScriptID 402 5) cue:) ; playScript
			(global414 eachElementDo: #taken 0)
		)
	)

	(method (handleEvent event)
		(cond
			((theGamePieces handleEvent: event) 0)
			((PiecesAtHome handleEvent: event) 0)
			((and global413 (global414 handleEvent: event))
				(((self script:) script:) cue:)
			)
			((and (not global413) (theGameSquares handleEvent: event)) 0)
		)
		(event claimed:)
	)

	(method (dispose &tmp temp0 temp1 temp2 temp3)
		(= temp3 (theGamePieces size:))
		(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
			(= temp2 (theGamePieces at: temp0))
			(if (temp2 script:)
				((temp2 script:) dispose:)
			)
		)
		(= temp3 (Garbage size:))
		(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
			(= temp2 (Garbage at: temp0))
			(if (IsObject temp2)
				(Garbage delete: temp2)
				(temp2 dispose:)
			)
		)
		(TheDice release: dispose:)
		(TheShells release: dispose:)
		(pachisiPlayerList release: dispose:)
		(theGameSquares release: dispose:)
		(theGamePieces release: dispose:)
		(pachisiKMList release: dispose:)
		(PiecesAtHome release: dispose:)
		(Updates release: dispose:)
		(Garbage release: dispose:)
		(KeyMouse setList: 0 keyMouseCode: 0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= temp1
				(switch temp0
					(1 player1)
					(2 player2)
					(3 player3)
					(4 player4)
				)
			)
			(temp1 release: dispose:)
		)
		(DisposeScript 401)
		(DisposeScript 410)
		(DisposeScript 402)
		(DisposeScript 983)
		(DisposeScript 9)
		(DisposeScript 941)
		(super dispose: &rest)
	)
)

(instance activeCode of Code
	(properties)

	(method (doit param1)
		(if (param1 isKindOf: PachisiRect)
			(param1 becomeActive:)
			(if global413
				(pachisiKMList add: (global414 at: 0) (global414 at: 1))
			)
		)
	)
)

(instance player1 of PachisiPlayer
	(properties)
)

(instance player2 of PachisiPlayer
	(properties)
)

(instance player3 of PachisiPlayer
	(properties)
)

(instance player4 of PachisiPlayer
	(properties)
)

(instance pachisiPlayerList of List
	(properties)
)

(instance pachisiKMList of Set
	(properties)
)

(instance theGameSquares of EventHandler
	(properties)
)

(instance theGamePieces of EventHandler
	(properties)
)

(instance die1 of Die
	(properties
		x 400
		y 400
		yStep 50
		view 302
		loop 10
		cel 6
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		hiView 302
		hiLoop 12
		hiCel 5
		startTop 135
		startLeft 319
		startBottom 155
		startRight 339
	)
)

(instance die2 of Die
	(properties
		x 400
		y 400
		yStep 50
		view 302
		loop 10
		cel 6
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		hiView 302
		hiLoop 12
		hiCel 5
		startTop 100
		startLeft 319
		startBottom 120
		startRight 339
		last 1
		offset 2
	)
)

(instance shell1 of Shell
	(properties
		x 400
		y 400
		yStep 50
		cel 15
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		startTop 40
		startLeft 319
		startBottom 60
		startRight 339
	)
)

(instance shell2 of Shell
	(properties
		x 400
		y 400
		yStep 50
		cel 15
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		startTop 65
		startLeft 319
		startBottom 85
		startRight 339
		offset 2
	)
)

(instance shell3 of Shell
	(properties
		x 400
		y 400
		yStep 50
		cel 15
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		startTop 90
		startLeft 319
		startBottom 110
		startRight 339
		offset 4
	)
)

(instance shell4 of Shell
	(properties
		x 400
		y 400
		yStep 50
		cel 15
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		startTop 115
		startLeft 319
		startBottom 135
		startRight 339
		offset 6
	)
)

(instance shell5 of Shell
	(properties
		x 400
		y 400
		yStep 50
		cel 15
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		startTop 140
		startLeft 319
		startBottom 160
		startRight 339
		offset 8
	)
)

(instance shell6 of Shell
	(properties
		x 400
		y 400
		yStep 50
		cel 15
		priority 9
		signal 16400
		cycleSpeed 0
		xStep 50
		moveSpeed 0
		startTop 165
		startLeft 319
		startBottom 185
		startRight 339
		last 1
		offset 10
	)
)

(instance pRect1 of PachisiRect
	(properties
		nsTop 17
		nsLeft 161
		nsBottom 29
		nsRight 175
		type 7
		order 1
	)
)

(instance pRect2 of PachisiRect
	(properties
		nsTop 29
		nsLeft 161
		nsBottom 39
		nsRight 175
		type 7
		order 2
	)
)

(instance pRect3 of PachisiRect
	(properties
		nsTop 39
		nsLeft 161
		nsBottom 49
		nsRight 175
		type 7
		order 3
	)
)

(instance pRect4 of PachisiRect
	(properties
		nsTop 49
		nsLeft 161
		nsBottom 59
		nsRight 175
		type 7
		order 4
	)
)

(instance pRect5 of PachisiRect
	(properties
		nsTop 59
		nsLeft 161
		nsBottom 69
		nsRight 175
		type 7
		order 5
	)
)

(instance pRect6 of PachisiRect
	(properties
		nsTop 69
		nsLeft 161
		nsBottom 80
		nsRight 175
		type 7
		order 6
	)
)

(instance pRect7 of PachisiRect
	(properties
		nsTop 80
		nsLeft 150
		nsBottom 92
		nsRight 161
		type 7
		order 7
	)
)

(instance pRect8 of PachisiRect
	(properties
		nsTop 80
		nsLeft 138
		nsBottom 92
		nsRight 150
		type 7
		order 8
	)
)

(instance pRect9 of PachisiRect
	(properties
		nsTop 80
		nsLeft 126
		nsBottom 92
		nsRight 138
		type 7
		order 9
	)
)

(instance pRect10 of PachisiRect
	(properties
		nsTop 80
		nsLeft 114
		nsBottom 92
		nsRight 126
		type 7
		order 10
	)
)

(instance pRect11 of PachisiRect
	(properties
		nsTop 80
		nsLeft 102
		nsBottom 92
		nsRight 114
		type 7
		order 11
	)
)

(instance pRect12 of PachisiRect
	(properties
		nsTop 80
		nsLeft 90
		nsBottom 92
		nsRight 102
		type 7
		order 12
	)
)

(instance pRect13 of PachisiRect
	(properties
		nsTop 92
		nsLeft 90
		nsBottom 104
		nsRight 102
		type 7
		order 13
	)
)

(instance pRect14 of PachisiRect
	(properties
		nsTop 104
		nsLeft 90
		nsBottom 116
		nsRight 102
		type 7
		order 14
	)
)

(instance pRect15 of PachisiRect
	(properties
		nsTop 104
		nsLeft 102
		nsBottom 116
		nsRight 114
		type 7
		order 15
	)
)

(instance pRect16 of PachisiRect
	(properties
		nsTop 104
		nsLeft 114
		nsBottom 116
		nsRight 126
		type 7
		order 16
	)
)

(instance pRect17 of PachisiRect
	(properties
		nsTop 104
		nsLeft 126
		nsBottom 116
		nsRight 138
		type 7
		order 17
	)
)

(instance pRect18 of PachisiRect
	(properties
		nsTop 104
		nsLeft 138
		nsBottom 116
		nsRight 150
		type 7
		order 18
	)
)

(instance pRect19 of PachisiRect
	(properties
		nsTop 104
		nsLeft 150
		nsBottom 116
		nsRight 161
		type 7
		order 19
	)
)

(instance pRect20 of PachisiRect
	(properties
		nsTop 116
		nsLeft 161
		nsBottom 125
		nsRight 175
		type 7
		order 20
	)
)

(instance pRect21 of PachisiRect
	(properties
		nsTop 125
		nsLeft 161
		nsBottom 135
		nsRight 175
		type 7
		order 21
	)
)

(instance pRect22 of PachisiRect
	(properties
		nsTop 135
		nsLeft 161
		nsBottom 145
		nsRight 175
		type 7
		order 22
	)
)

(instance pRect23 of PachisiRect
	(properties
		nsTop 145
		nsLeft 161
		nsBottom 155
		nsRight 175
		type 7
		order 23
	)
)

(instance pRect24 of PachisiRect
	(properties
		nsTop 155
		nsLeft 161
		nsBottom 165
		nsRight 175
		type 7
		order 24
	)
)

(instance pRect25 of PachisiRect
	(properties
		nsTop 165
		nsLeft 161
		nsBottom 178
		nsRight 175
		type 7
		order 25
	)
)

(instance pRect26 of PachisiRect
	(properties
		nsTop 165
		nsLeft 175
		nsBottom 178
		nsRight 190
		type 7
		order 26
	)
)

(instance pRect27 of PachisiRect
	(properties
		nsTop 165
		nsLeft 190
		nsBottom 178
		nsRight 204
		type 7
		order 27
	)
)

(instance pRect28 of PachisiRect
	(properties
		nsTop 155
		nsLeft 190
		nsBottom 165
		nsRight 204
		type 7
		order 28
	)
)

(instance pRect29 of PachisiRect
	(properties
		nsTop 145
		nsLeft 190
		nsBottom 155
		nsRight 204
		type 7
		order 29
	)
)

(instance pRect30 of PachisiRect
	(properties
		nsTop 135
		nsLeft 190
		nsBottom 145
		nsRight 204
		type 7
		order 30
	)
)

(instance pRect31 of PachisiRect
	(properties
		nsTop 125
		nsLeft 190
		nsBottom 135
		nsRight 204
		type 7
		order 31
	)
)

(instance pRect32 of PachisiRect
	(properties
		nsTop 116
		nsLeft 190
		nsBottom 125
		nsRight 204
		type 7
		order 32
	)
)

(instance pRect33 of PachisiRect
	(properties
		nsTop 104
		nsLeft 204
		nsBottom 116
		nsRight 216
		type 7
		order 33
	)
)

(instance pRect34 of PachisiRect
	(properties
		nsTop 104
		nsLeft 216
		nsBottom 116
		nsRight 228
		type 7
		order 34
	)
)

(instance pRect35 of PachisiRect
	(properties
		nsTop 104
		nsLeft 228
		nsBottom 116
		nsRight 240
		type 7
		order 35
	)
)

(instance pRect36 of PachisiRect
	(properties
		nsTop 104
		nsLeft 240
		nsBottom 116
		nsRight 252
		type 7
		order 36
	)
)

(instance pRect37 of PachisiRect
	(properties
		nsTop 104
		nsLeft 252
		nsBottom 116
		nsRight 264
		type 7
		order 37
	)
)

(instance pRect38 of PachisiRect
	(properties
		nsTop 104
		nsLeft 264
		nsBottom 116
		nsRight 276
		type 7
		order 38
	)
)

(instance pRect39 of PachisiRect
	(properties
		nsTop 92
		nsLeft 264
		nsBottom 104
		nsRight 276
		type 7
		order 39
	)
)

(instance pRect40 of PachisiRect
	(properties
		nsTop 80
		nsLeft 264
		nsBottom 92
		nsRight 276
		type 7
		order 40
	)
)

(instance pRect41 of PachisiRect
	(properties
		nsTop 80
		nsLeft 252
		nsBottom 92
		nsRight 264
		type 7
		order 41
	)
)

(instance pRect42 of PachisiRect
	(properties
		nsTop 80
		nsLeft 240
		nsBottom 92
		nsRight 252
		type 7
		order 42
	)
)

(instance pRect43 of PachisiRect
	(properties
		nsTop 80
		nsLeft 228
		nsBottom 92
		nsRight 240
		type 7
		order 43
	)
)

(instance pRect44 of PachisiRect
	(properties
		nsTop 80
		nsLeft 216
		nsBottom 92
		nsRight 228
		type 7
		order 44
	)
)

(instance pRect45 of PachisiRect
	(properties
		nsTop 80
		nsLeft 204
		nsBottom 92
		nsRight 216
		type 7
		order 45
	)
)

(instance pRect46 of PachisiRect
	(properties
		nsTop 69
		nsLeft 190
		nsBottom 80
		nsRight 204
		type 7
		order 46
	)
)

(instance pRect47 of PachisiRect
	(properties
		nsTop 59
		nsLeft 190
		nsBottom 69
		nsRight 204
		type 7
		order 47
	)
)

(instance pRect48 of PachisiRect
	(properties
		nsTop 49
		nsLeft 190
		nsBottom 59
		nsRight 204
		type 7
		order 48
	)
)

(instance pRect49 of PachisiRect
	(properties
		nsTop 39
		nsLeft 190
		nsBottom 49
		nsRight 204
		type 7
		order 49
	)
)

(instance pRect50 of PachisiRect
	(properties
		nsTop 29
		nsLeft 190
		nsBottom 39
		nsRight 204
		type 7
		order 50
	)
)

(instance pRect51 of PachisiRect
	(properties
		nsTop 17
		nsLeft 190
		nsBottom 29
		nsRight 204
		type 7
		order 51
	)
)

(instance pRect52 of PachisiRect
	(properties
		nsTop 17
		nsLeft 175
		nsBottom 29
		nsRight 190
		type 7
		order 52
	)
)

(instance blueRect1 of PachisiRect
	(properties
		nsTop 29
		nsLeft 175
		nsBottom 39
		nsRight 190
		type 1
		order 53
	)
)

(instance blueRect2 of PachisiRect
	(properties
		nsTop 39
		nsLeft 175
		nsBottom 49
		nsRight 190
		type 1
		order 54
	)
)

(instance blueRect3 of PachisiRect
	(properties
		nsTop 49
		nsLeft 175
		nsBottom 59
		nsRight 190
		type 1
		order 55
	)
)

(instance blueRect4 of PachisiRect
	(properties
		nsTop 59
		nsLeft 175
		nsBottom 69
		nsRight 190
		type 1
		order 56
	)
)

(instance blueRect5 of PachisiRect
	(properties
		nsTop 69
		nsLeft 175
		nsBottom 80
		nsRight 190
		type 1
		order 57
	)
)

(instance redRect1 of PachisiRect
	(properties
		nsTop 92
		nsLeft 252
		nsBottom 104
		nsRight 264
		type 2
		order 40
	)
)

(instance redRect2 of PachisiRect
	(properties
		nsTop 92
		nsLeft 240
		nsBottom 104
		nsRight 252
		type 2
		order 41
	)
)

(instance redRect3 of PachisiRect
	(properties
		nsTop 92
		nsLeft 228
		nsBottom 104
		nsRight 240
		type 2
		order 42
	)
)

(instance redRect4 of PachisiRect
	(properties
		nsTop 92
		nsLeft 216
		nsBottom 104
		nsRight 228
		type 2
		order 43
	)
)

(instance redRect5 of PachisiRect
	(properties
		nsTop 92
		nsLeft 204
		nsBottom 104
		nsRight 216
		type 2
		order 44
	)
)

(instance greenRect1 of PachisiRect
	(properties
		nsTop 155
		nsLeft 175
		nsBottom 165
		nsRight 190
		type 3
		order 27
	)
)

(instance greenRect2 of PachisiRect
	(properties
		nsTop 145
		nsLeft 175
		nsBottom 155
		nsRight 190
		type 3
		order 28
	)
)

(instance greenRect3 of PachisiRect
	(properties
		nsTop 135
		nsLeft 175
		nsBottom 145
		nsRight 190
		type 3
		order 29
	)
)

(instance greenRect4 of PachisiRect
	(properties
		nsTop 125
		nsLeft 175
		nsBottom 135
		nsRight 190
		type 3
		order 30
	)
)

(instance greenRect5 of PachisiRect
	(properties
		nsTop 116
		nsLeft 175
		nsBottom 125
		nsRight 190
		type 3
		order 31
	)
)

(instance yellowRect1 of PachisiRect
	(properties
		nsTop 92
		nsLeft 102
		nsBottom 104
		nsRight 114
		type 4
		order 14
	)
)

(instance yellowRect2 of PachisiRect
	(properties
		nsTop 92
		nsLeft 114
		nsBottom 104
		nsRight 126
		type 4
		order 15
	)
)

(instance yellowRect3 of PachisiRect
	(properties
		nsTop 92
		nsLeft 126
		nsBottom 104
		nsRight 138
		type 4
		order 16
	)
)

(instance yellowRect4 of PachisiRect
	(properties
		nsTop 92
		nsLeft 138
		nsBottom 104
		nsRight 150
		type 4
		order 17
	)
)

(instance yellowRect5 of PachisiRect
	(properties
		nsTop 92
		nsLeft 150
		nsBottom 104
		nsRight 161
		type 4
		order 18
	)
)

(instance blueStart of PachisiRect
	(properties
		nsTop 17
		nsLeft 90
		nsBottom 80
		nsRight 161
		whoIsOn 1
		howManyOn 4
		type 6
	)
)

(instance redStart of PachisiRect
	(properties
		nsTop 17
		nsLeft 204
		nsBottom 80
		nsRight 276
		whoIsOn 2
		howManyOn 4
		type 6
		order 39
	)
)

(instance greenStart of PachisiRect
	(properties
		nsTop 116
		nsLeft 204
		nsBottom 178
		nsRight 276
		whoIsOn 3
		howManyOn 4
		type 6
		order 26
	)
)

(instance yellowStart of PachisiRect
	(properties
		nsTop 116
		nsLeft 90
		nsBottom 178
		nsRight 161
		whoIsOn 4
		howManyOn 4
		type 6
		order 13
	)
)

(instance homeSquare of PachisiRect
	(properties
		nsTop 80
		nsLeft 161
		nsBottom 116
		nsRight 204
		type 5
	)
)

(instance rollSound of Sound
	(properties)
)

