;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use KeyMouse)
(use MoveToEndLoop)
(use Interface)
(use LeapTo)
(use IconBar)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	checkers 0
	pieces 1
	proc200_2 2
	R29 3
	R25 4
	R22 5
	player1 6
	player2 7
	squares 8
)

(local
	local0
	local1
	[local2 24] = [249 193 137 82 277 222 166 109 249 193 137 81 277 221 165 109 249 193 137 81 277 221 165 109]
	[local26 24] = [179 179 179 179 156 156 156 156 133 133 133 133 64 64 64 64 41 41 41 41 18 18 18 18]
	local50
	local51
	local52
	local53
	local54
)

(procedure (localproc_0 &tmp [temp0 500]) ; UNUSED
	(Format @temp0 &rest)
	(Print @temp0 #at 10 180)
)

(procedure (proc200_2 &tmp [temp0 80] [temp80 80] temp160 temp161)
	(if (or (!= (gSong number:) 803) (== (gSong prevSignal:) -1))
		(gSong play: 803 setLoop: -1)
	)
	(= temp160 (gSystemWindow color:))
	(= temp161 (gSystemWindow back:))
	(gSystemWindow color: 16 back: 21)
	(Format @global550 200 1 (player2 playerName:) (player1 playerName:)) ; "SCORECARD  %=10s %=9s --------------------------------"
	(StrCat @global550 (Format @temp80 200 2 (player2 wins:) (player1 wins:))) ; "Wins      %=3d    %=3d"
	(StrCat @global550 (Format @temp80 200 3 (player2 losses:) (player1 losses:))) ; "Losses     %=3d    %=3d"
	(StrCat @global550 (Format @temp80 200 4 (player2 draws:) (player1 draws:))) ; "Draws      %=3d    %=3d"
	(Print @global550 33 500 179 gDoAbsCode)
	(gSystemWindow color: temp160 back: temp161)
	(gSong fade:)
)

(procedure (localproc_1)
	(= global181 0)
	(pieces eachElementDo: #update)
)

(procedure (localproc_2 param1 param2)
	(return
		(or
			(and (== param1 1) (== param2 2))
			(and (== param1 0) (== param2 3))
			(and (== param1 3) (== param2 0))
			(and (== param1 2) (== param2 1))
		)
	)
)

(instance checkers of Rm
	(properties
		style 10
	)

	(method (init)
		(Load rsVIEW 200)
		(Load rsVIEW 210)
		(Load rsVIEW 250)
		(Load rsVIEW 251)
		(Load rsVIEW 252)
		(Load rsVIEW 253)
		(Load rsVIEW 210)
		(Load rsVIEW 275)
		(Load rsCURSOR 30)
		(Load rsCURSOR 100)
		(Load rsCURSOR 101)
		(Load rsCURSOR 102)
		(Load rsCURSOR 103)
		(Load rsCURSOR 104)
		(Load rsCURSOR 105)
		(Load rsCURSOR 106)
		(Load rsCURSOR 107)
		(Load rsCURSOR 29)
		(Load rsSOUND 200)
		(Load rsSOUND 201)
		(Load rsSOUND 202)
		(Load rsSOUND 203)
		(Load rsSOUND 204)
		(Load rsSOUND 205)
		(Load rsSOUND 206)
		(Load rsSOUND 207)
		(Load rsSOUND 208)
		(Load rsSOUND 904)
		(Load rsSOUND 903)
		(Load rsSOUND 906)
		(Load rsSOUND 907)
		(ScriptID 210) ; thechCode
		(ScriptID 202) ; root
		(ScriptID 201) ; book
		(ScriptID 203) ; endGame1
		(ScriptID 204) ; sqr0
		MoveToEndLoop
		LeapTo
		RandCycle
		((= gCheckers_opt (ScriptID 201 2)) doit:) ; checkers_opt
		(= picture global266)
		(player1 skill: global190 type: global194 playerName: @global150)
		(player2 skill: global191 type: global195 playerName: @global157)
		(if (== global188 0)
			(player2 type: 1)
			(= global188 1)
		)
		(= gTheArrow theArrow)
		(= global235 0)
		(if (gChar1 active:)
			(gChar1 posn: 33 40 show: init:)
			(Load rsTEXT (+ (* (+ (gChar1 view:) 1) 1000) global187))
		else
			(Load rsTEXT 19200)
		)
		(Characters init:)
		(super init:)
		(gSong fade:)
		(cond
			((not global198)
				(gGame setCursor: 999 1)
				(if (and (== (player1 type:) 1) (== global188 1))
					(= global271 player2)
				else
					(= global271 player1)
				)
				(= global178 player1)
				(= global259 1)
				(gTheArrow setLoop: 3)
				(cond
					((and (== global188 1) (== (player1 type:) 1))
						(= local52 1)
					)
					((== global188 2)
						(= local52 3)
					)
				)
			)
			((== global271 player2)
				(= global178 player2)
				(gTheArrow setLoop: 2)
				(if (== global188 1)
					(= local52 1)
				else
					(= local52 2)
				)
			)
			(else
				(= global178 player1)
				(gTheArrow setLoop: 3)
				(if (== global188 2)
					(= local52 3)
				)
			)
		)
		(if (== global188 1)
			(= global244 1)
			(if (== (player1 type:) 1)
				(= global271 player2)
				(= global178 player2)
				(gTheArrow setLoop: 2)
				(= global259 -1)
				(player1 skill: global191 type: 2 playerName: @global157)
				(player2 skill: global190 type: 1 playerName: @global150)
			)
		)
		((ScriptID 202 0) add:) ; root
		((ScriptID 202 1) add:) ; lev1Lst
		((ScriptID 202 2) add:) ; lev2Lst
		((ScriptID 202 3) add:) ; lev3Lst
		((ScriptID 202 4) add:) ; lev4Lst
		((ScriptID 202 6) add:) ; lev44Lst
		((ScriptID 202 7) add:) ; lev5Lst
		(pieces add:)
		(squares add:)
		(dumSqrs add:)
		(player1 add:)
		(player2 add:)
		(gTheArrow init: stopUpd:)
		(= gGameScript (ScriptID 201 1)) ; gameScript
		(B1 init:)
		(B2 init:)
		(B3 init:)
		(B4 init:)
		(B5 init:)
		(B6 init:)
		(B7 init:)
		(B8 init:)
		(B9 init:)
		(B10 init:)
		(B11 init:)
		(B12 init:)
		(R21 init:)
		(R22 init:)
		(R23 init:)
		(R24 init:)
		(R25 init:)
		(R26 init:)
		(R27 init:)
		(R28 init:)
		(R29 init:)
		(R30 init:)
		(R31 init:)
		(R32 init:)
		((ScriptID 204 0) init:) ; sqr0
		((ScriptID 204 1) init:) ; sqr1
		((ScriptID 204 2) init:) ; sqr2
		((ScriptID 204 3) init:) ; sqr3
		((ScriptID 204 4) init:) ; sqr4
		((ScriptID 204 5) init:) ; sqr5
		((ScriptID 204 6) init:) ; sqr6
		((ScriptID 204 7) init:) ; sqr7
		((ScriptID 204 8) init:) ; sqr8
		((ScriptID 204 9) init:) ; sqr9
		((ScriptID 204 10) init:) ; sqr10
		((ScriptID 204 11) init:) ; sqr11
		((ScriptID 204 12) init:) ; sqr12
		((ScriptID 204 13) init:) ; sqr13
		((ScriptID 204 14) init:) ; sqr14
		((ScriptID 204 15) init:) ; sqr15
		((ScriptID 204 16) init:) ; sqr16
		((ScriptID 204 17) init:) ; sqr17
		((ScriptID 204 18) init:) ; sqr18
		((ScriptID 204 19) init:) ; sqr19
		((ScriptID 204 20) init:) ; sqr20
		((ScriptID 204 21) init:) ; sqr21
		((ScriptID 204 22) init:) ; sqr22
		((ScriptID 204 23) init:) ; sqr23
		((ScriptID 204 24) init:) ; sqr24
		((ScriptID 204 25) init:) ; sqr25
		((ScriptID 204 26) init:) ; sqr26
		((ScriptID 204 27) init:) ; sqr27
		((ScriptID 204 28) init:) ; sqr28
		((ScriptID 204 29) init:) ; sqr29
		((ScriptID 204 30) init:) ; sqr30
		((ScriptID 204 31) init:) ; sqr31
		((ScriptID 204 32) init:) ; sqr32
		((ScriptID 204 33) init:) ; dumSqr1
		((ScriptID 204 34) init:) ; dumSqr2
		((ScriptID 204 35) init:) ; dumSqr3
		((ScriptID 204 36) init:) ; dumSqr4
		((ScriptID 204 37) init:) ; dumSqr5
		((ScriptID 204 38) init:) ; dumSqr6
		((ScriptID 204 39) init:) ; dumSqr7
		((ScriptID 204 40) init:) ; dumSqr8
		((ScriptID 204 41) init:) ; dumSqr9
		((ScriptID 204 42) init:) ; dumSqr10
		((ScriptID 204 43) init:) ; dumSqr11
		((ScriptID 204 44) init:) ; dumSqr12
		((ScriptID 204 45) init:) ; dumSqr13
		((ScriptID 204 46) init:) ; dumSqr14
		((ScriptID 204 47) init:) ; dumSqr15
		((ScriptID 204 48) init:) ; dumSqr16
		((ScriptID 204 49) init:) ; dumSqr17
		((ScriptID 204 50) init:) ; dumSqr18
		((ScriptID 204 51) init:) ; dumSqr19
		((ScriptID 204 52) init:) ; dumSqr20
		((ScriptID 204 53) init:) ; dumSqr21
		((ScriptID 204 54) init:) ; dumSqr22
		((ScriptID 204 55) init:) ; dumSqr23
		((ScriptID 204 56) init:) ; dumSqr24
		((ScriptID 204 57) init:) ; dumSqr25
		((ScriptID 204 58) init:) ; dumSqr26
		((ScriptID 204 59) init:) ; dumSqr27
		((ScriptID 204 60) init:) ; dumSqr28
		((ScriptID 204 61) init:) ; dumSqr29
		((ScriptID 204 62) init:) ; dumSqr30
		((ScriptID 204 63) init:) ; dumSqr31
		((ScriptID 204 64) init:) ; dumSqr32
		(proc0_1)
		(if (== picture 250)
			(gSound2 play: 207 setLoop: 1)
		)
		(switch local52
			(1
				(gChar1 say: (Random 18 20))
			)
			(2
				(Printf 200 0 (player2 playerName:)) ; "%s moves first"
			)
			(3
				(Printf 200 0 (player1 playerName:)) ; "%s moves first"
			)
		)
		(self setScript: gGameScript)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (!= global266 picture)
			(IconBar disable:)
			(= picture global266)
			(gGame setCursor: 20 1)
			(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
				(UnLoad 133 ((gCast at: temp0) underBits:))
			)
			(DrawPic picture 10)
			(localproc_1)
			(gGame setCursor: 999 1)
			(proc0_1)
			(if (== picture 250)
				(gSound2 play: 207 setLoop: 1)
			)
			(IconBar enable:)
		)
		(if global262
			(if (and (== global188 2) (== global178 player1))
				(player2 wins: (+ (player2 wins:) 1))
				(player1 losses: (+ (player1 losses:) 1))
			else
				(player1 wins: (+ (player1 wins:) 1))
				(player2 losses: (+ (player2 losses:) 1))
			)
			(proc200_2)
			(squares eachElementDo: #reset)
			(pieces eachElementDo: #reset)
			(gCurRoom setScript: gGameScript)
		)
		(if (and global260 (== global188 1))
			(if (checkDraw doit:)
				(gChar1 say: (Random 0 2))
				(player1 draws: (+ (player1 draws:) 1))
				(player2 draws: (+ (player2 draws:) 1))
				(proc200_2)
				(squares eachElementDo: #reset)
				(pieces eachElementDo: #reset)
				(gCurRoom setScript: gGameScript)
			else
				(gChar1 say: (Random 3 5))
			)
		)
		(= global260 0)
	)

	(method (dispose &tmp temp0)
		((ScriptID 202 1) dispose:) ; lev1Lst
		((ScriptID 202 2) dispose:) ; lev2Lst
		((ScriptID 202 3) dispose:) ; lev3Lst
		((ScriptID 202 4) dispose:) ; lev4Lst
		((ScriptID 202 6) dispose:) ; lev44Lst
		((ScriptID 202 7) dispose:) ; lev5Lst
		((ScriptID 202 0) dispose:) ; root
		(pieces release: dispose:)
		(squares release: dispose:)
		(dumSqrs release: dispose:)
		(KeyMouse release: dispose:)
		(player1 release: dispose:)
		(player2 release: dispose:)
		(super dispose:)
		(DisposeScript 202)
		(DisposeScript 201)
		(DisposeScript 203)
		(DisposeScript 204)
		(DisposeScript 210)
		(DisposeScript 11)
		(DisposeScript 302)
		(DisposeScript 9)
		(DisposeScript 941)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(return 0)
		else
			(global178 handleEvent: event)
		)
	)
)

(class Piece of DragableActor
	(properties
		yStep 3
		cel 1
		priority 10
		xStep 6
		hiView 200
		hiCel 0
		type -1
		sqrNum 0
	)

	(method (update)
		(if (== global266 250)
			((ScriptID 201 3) setCycle: 0 hide: cel: 0 forceUpd:) ; splash
			(cond
				((or (== (self type:) -1) (== (self type:) 1))
					(if (== (self loop:) 2)
						(self view: 250 hiView: 250)
					else
						(self view: 252 hiView: 252)
					)
				)
				((or (== (self type:) -2) (== (self type:) 2))
					(if (== (self loop:) 2)
						(self view: 251 hiView: 251)
					else
						(self view: 253 hiView: 253)
					)
				)
			)
			(if (< (pieces indexOf: self) 12)
				(self loop: 3 hiLoop: 3 forceUpd:)
			else
				(self loop: 2 hiLoop: 2 forceUpd:)
			)
			(self looper: gLooperDir8 cel: 0 hiCel: 7 draggingCode: dragSpider)
		else
			(cond
				((or (== (self type:) -1) (== (self type:) 1))
					(if (== (self view:) 250)
						(self setLoop: 2 hiLoop: 2 cel: 1 hiCel: 0)
					else
						(self setLoop: 0 hiLoop: 0 cel: 1 hiCel: 0)
					)
				)
				((or (== (self type:) -2) (== (self type:) 2))
					(if (== (self view:) 251)
						(self setLoop: 2 hiLoop: 2 cel: 3 hiCel: 2)
					else
						(self setLoop: 0 hiLoop: 0 cel: 3 hiCel: 2)
					)
				)
			)
			(self
				view: 200
				hiView: 200
				moveSpeed: 3
				looper: 0
				draggingCode: 0
				setCycle: 0
				forceUpd:
			)
		)
	)

	(method (findPiece param1)
		(if (== sqrNum param1)
			(return 1)
		)
		(return 0)
	)

	(method (cue)
		(if (and (== view prevView) (== global266 (gCurRoom picture:)))
			(self dim:)
		)
		(self setPri: 10 setCycle: 0)
		(if (== global266 250)
			(gSound2 stop:)
			(gSound play: 208 setLoop: 1)
			(if (== (global178 myColor:) -1)
				(self loop: 3)
			else
				(self loop: 2)
			)
			(self cel: 0)
		else
			(gSound2 stop:)
			(gSound play: 200 setLoop: 1)
			(self setStep: 2 3)
		)
		(self stopUpd:)
		(proc0_3)
	)

	(method (jmpAvail &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 1)) (< temp0 33) ((++ temp0))
			(cond
				((== (global178 myColor:) -1)
					(if (< ([global200 temp0] checker:) 0)
						(for
							((= temp1 3))
							(>=
								temp1
								(if (== ([global200 temp0] checker:) -1)
									2
								else
									0
								)
							)
							((-- temp1))
							
							(= temp2 ([global200 temp0] sqrOn: temp1))
							(= temp3 ([global200 temp2] sqrOn: temp1))
							(if
								(and
									(> ([global200 temp2] checker:) 0)
									(== ([global200 temp3] checker:) 0)
								)
								(return 1)
							)
						)
					)
				)
				((> ([global200 temp0] checker:) 0)
					(for
						((= temp1 0))
						(<=
							temp1
							(if (== ([global200 temp0] checker:) 1) 1 else 3)
						)
						((++ temp1))
						
						(= temp2 ([global200 temp0] sqrOn: temp1))
						(= temp3 ([global200 temp2] sqrOn: temp1))
						(if
							(and
								(< ([global200 temp2] checker:) 0)
								(== ([global200 temp3] checker:) 0)
							)
							(return 1)
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (validMove param1 &tmp temp0 temp1)
		(= global246 0)
		(= temp1 0)
		(if (== global244 1)
			(= temp1 (self jmpAvail:))
		)
		(if (> param1 0)
			(cond
				(([global200 param1] checker:)
					(if (!= (self sqrNum:) param1)
						(gSound play: 907 setLoop: 1)
						(gChar1 say: (Random 12 14) -32768 443)
					)
					(return 0)
				)
				(
					(and
						(> param1 sqrNum)
						(or (== (global178 myColor:) -1) (== (self type:) 2))
					)
					(switch param1
						(([global200 sqrNum] sqrOn: 3)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(gSound play: 907 setLoop: 1)
								(gChar1 say: (Random 21 23) -32768 441)
								(return 0)
							)
						)
						(([global200 sqrNum] sqrOn: 2)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(gSound play: 907 setLoop: 1)
								(gChar1 say: (Random 21 23) -32768 441)
								(return 0)
							)
						)
						(([global200 ([global200 sqrNum] sqrOn: 3)] sqrOn: 3)
							(return (self jumpPiece: param1 3))
						)
						(([global200 ([global200 sqrNum] sqrOn: 2)] sqrOn: 2)
							(return (self jumpPiece: param1 2))
						)
					)
				)
				(
					(and
						(< param1 sqrNum)
						(or (== (global178 myColor:) 1) (== (self type:) -2))
					)
					(switch param1
						(([global200 sqrNum] sqrOn: 1)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(gSound play: 907 setLoop: 1)
								(gChar1 say: (Random 21 23) -32768 441)
								(return 0)
							)
						)
						(([global200 sqrNum] sqrOn: 0)
							(if global245
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(gSound play: 907 setLoop: 1)
								(gChar1 say: (Random 21 23) -32768 441)
								(return 0)
							)
						)
						(([global200 ([global200 sqrNum] sqrOn: 0)] sqrOn: 0)
							(return (self jumpPiece: param1 0))
						)
						(([global200 ([global200 sqrNum] sqrOn: 1)] sqrOn: 1)
							(return (self jumpPiece: param1 1))
						)
					)
				)
				((< ([global200 param1] row:) ([global200 sqrNum] row:))
					(gSound play: 907 setLoop: 1)
					(gChar1 say: (Random 6 8) -32768 443)
					(return 0)
				)
			)
		)
		(if (== param1 0)
			(return 0)
		)
		(if (== param1 -1)
			(gSound play: 907 setLoop: 1)
			(gChar1 say: (Random 9 11) -32768 443)
			(return 0)
		)
		(if (self multiChk: param1 10)
			(gChar1 say: {You must jump one piece at a time.} -32768)
		else
			(gSound play: 907 setLoop: 1)
			(gChar1 say: (Random 12 14) -32768 443)
		)
		(return 0)
	)

	(method (multiChk param1 param2 &tmp temp0 temp1 temp2 [temp3 2])
		(if (== (global178 myColor:) -1)
			(for
				((= temp0 0))
				(<= temp0 (if (== (self type:) -1) 1 else 3))
				((++ temp0))
				
				(if (not (localproc_2 temp0 param2))
					(= temp1 ([global200 param1] sqrOn: temp0))
					(= temp2 ([global200 temp1] sqrOn: temp0))
					(if
						(and
							(> ([global200 temp1] checker:) 0)
							(or
								(== ([global200 temp2] checker:) 0)
								(== temp2 sqrNum)
							)
						)
						(cond
							((== temp2 sqrNum)
								(return 1)
							)
							((self multiChk: temp2 temp0)
								(return 1)
							)
						)
					)
				)
			)
		else
			(for
				((= temp0 3))
				(>= temp0 (if (== (self type:) 1) 2 else 0))
				((-- temp0))
				
				(if (not (localproc_2 temp0 param2))
					(= temp1 ([global200 param1] sqrOn: temp0))
					(= temp2 ([global200 temp1] sqrOn: temp0))
					(if
						(and
							(< ([global200 temp1] checker:) 0)
							(or
								(== ([global200 temp2] checker:) 0)
								(== temp2 sqrNum)
							)
						)
						(cond
							((== temp2 sqrNum)
								(return 1)
							)
							((self multiChk: temp2 temp0)
								(return 1)
							)
						)
					)
				)
			)
		)
		(if (== param2 10)
			(return 0)
		)
	)

	(method (movePiece param1)
		([global200 sqrNum] checker: 0)
		(self sqrNum: param1)
		(cond
			((and (== (global178 myColor:) -1) (> param1 28))
				(if (!= (self type:) -2)
					(= global273 1)
				)
				(if (== global270 1)
					(= global270 2)
				)
				([global200 param1] checker: -2)
				(self type: -2)
				(if (== global266 200)
					(self cel: 3 hiCel: 2)
				)
			)
			((and (== (global178 myColor:) 1) (< param1 5))
				(if (!= (self type:) 2)
					(= global273 1)
				)
				([global200 param1] checker: 2)
				(self type: 2)
				(if (== global266 200)
					(self cel: 3 hiCel: 2)
				)
			)
			(else
				([global200 param1] checker: type)
			)
		)
	)

	(method (jumpPiece param1 param2)
		(cond
			((== (global178 myColor:) -1)
				(if
					(>
						([global200 ([global200 sqrNum] sqrOn: param2)]
							checker:
						)
						0
					)
					(= global250
						(pieces
							firstTrue:
								#findPiece
								([global200 sqrNum] sqrOn: param2)
						)
					)
					(= global246 1)
					([global200 ([global200 sqrNum] sqrOn: param2)] checker: 0)
					([global200 sqrNum] checker: 0)
					(self sqrNum: param1)
					(if (and (> param1 28) (!= (self type:) -2))
						([global200 param1] checker: -2)
						(self type: -2)
						(if (== global266 200)
							(self cel: 3 hiCel: 2)
						)
						(= global245 0)
					else
						([global200 param1] checker: type)
						(= global245 (self moreJumps:))
					)
					(if (== global266 200)
						((gCurRoom script:) cue:)
					)
					(return 1)
				else
					(gChar1 say: (Random 12 14) -32768 443)
					(return 0)
				)
			)
			((< ([global200 ([global200 sqrNum] sqrOn: param2)] checker:) 0)
				(= global250
					(pieces
						firstTrue: #findPiece ([global200 sqrNum] sqrOn: param2)
					)
				)
				(= global246 1)
				([global200 ([global200 sqrNum] sqrOn: param2)] checker: 0)
				([global200 sqrNum] checker: 0)
				(self sqrNum: param1)
				(if (and (< param1 5) (!= (self type:) 2))
					([global200 param1] checker: 2)
					(self type: 2)
					(if (== global266 200)
						(self cel: 3 hiCel: 2)
					)
					(= global245 0)
				else
					([global200 param1] checker: type)
					(= global245 (self moreJumps:))
				)
				(if (== global266 200)
					((gCurRoom script:) cue:)
				)
				(return 1)
			)
			(else
				(gChar1 say: (Random 12 14) -32768 443)
				(return 0)
			)
		)
	)

	(method (moreJumps &tmp temp0 temp1 temp2)
		(if (== (global178 myColor:) -1)
			(for
				((= temp0 3))
				(>= temp0 (if (== type -1) 2 else 0))
				((-- temp0))
				
				(= temp1 ([global200 sqrNum] sqrOn: temp0))
				(= temp2 ([global200 temp1] sqrOn: temp0))
				(if
					(and
						(> ([global200 temp1] checker:) 0)
						(== ([global200 temp2] checker:) 0)
					)
					(return 1)
				)
			)
		else
			(for ((= temp0 0)) (<= temp0 (if (== type 1) 1 else 3)) ((++ temp0))
				(= temp1 ([global200 sqrNum] sqrOn: temp0))
				(= temp2 ([global200 temp1] sqrOn: temp0))
				(if
					(and
						(< ([global200 temp1] checker:) 0)
						(== ([global200 temp2] checker:) 0)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (init)
		(if (== global266 250)
			(cond
				((== global259 -1)
					(if (< (pieces size:) 12)
						(self view: 250 hiView: 250 loop: 3 hiLoop: 3)
					else
						(self view: 252 hiView: 252 loop: 2 hiLoop: 2)
					)
				)
				((< (pieces size:) 12)
					(self view: 252 hiView: 252 loop: 3 hiLoop: 3)
				)
				(else
					(self view: 250 hiView: 250 loop: 2 hiLoop: 2)
				)
			)
			(self
				looper: gLooperDir8
				hiCel: 7
				cel: 0
				draggingCode: dragSpider
				setPri: 10
			)
		else
			(self view: 200 setPri: 10)
			(cond
				((== global259 -1)
					(if (< (pieces size:) 12)
						(self setLoop: 2 hiLoop: 2)
					else
						(self setLoop: 0 hiLoop: 0)
					)
				)
				((< (pieces size:) 12)
					(self setLoop: 0 hiLoop: 0)
				)
				(else
					(self setLoop: 2 hiLoop: 2)
				)
			)
		)
		(self x: [local2 (pieces size:)])
		(self y: [local26 (pieces size:)])
		(super init: &rest)
		(pieces add: self)
		(self ignoreActors:)
		(self stopUpd:)
	)

	(method (reset &tmp temp0)
		(if (!= ((ScriptID 202 0) size:) 0) ; root
			((ScriptID 202 0) freeNodes: (ScriptID 202 0)) ; root, root
			((ScriptID 202 0) release:) ; root
		)
		((ScriptID 201 3) setCycle: 0 hide: cel: 0 forceUpd:) ; splash
		(if (== (= temp0 (pieces indexOf: self)) 0)
			(if (== global259 -1)
				(= global259 1)
				(= global178 player1)
				(if (== (player1 type:) 2)
					(proc0_4)
				)
				(gTheArrow setLoop: 3)
			else
				(proc0_3)
				(= global259 -1)
				(= global178 player2)
				(gTheArrow setLoop: 2)
			)
		)
		(self setMotion: 0)
		(self x: [local2 temp0] y: [local26 temp0] priority: 10)
		(if (< temp0 12)
			(self type: -1 sqrNum: (+ temp0 1))
		else
			(self type: 1 sqrNum: (+ temp0 9))
		)
		(cond
			((== global266 200)
				(if (== (self loop:) 2)
					(self setLoop: 0 hiLoop: 0)
				else
					(self setLoop: 2 hiLoop: 2)
				)
				(self hiCel: 0 cel: 1 setStep: 2 3 moveSpeed: 3)
			)
			((or (== (self view:) 250) (== (self view:) 251))
				(self view: 252 hiView: 252 cel: 0)
			)
			((or (== (self view:) 252) (== (self view:) 253))
				(self view: 250 hiView: 250 cel: 0)
			)
		)
		(if (== global266 250)
			(if (< temp0 12)
				(self loop: 3 hiLoop: 3)
			else
				(self loop: 2 hiLoop: 2)
			)
			(self cel: 0 hiCel: 7 setCycle: 0 forceUpd:)
		)
		(self stopUpd:)
		(if (== temp0 23)
			(proc0_1)
			(cond
				((and (== global188 1) (== global259 -1))
					(gChar1 say: (Random 18 20))
				)
				((== global188 2)
					(if (== global259 -1)
						(Printf 200 0 (player2 playerName:)) ; "%s moves first"
					else
						(Printf 200 0 (player1 playerName:)) ; "%s moves first"
					)
				)
			)
		)
	)
)

(class Sqr of KMRect
	(properties
		fwdLeft 0
		fwdRight 0
		bacLeft 0
		bacRight 0
		checker 0
		number 0
		row 0
		col 0
	)

	(method (init)
		(= [global200 global235] self)
		(++ global235)
		(squares add: self)
		(self addKeyMouse:)
	)

	(method (sqrOn param1)
		(return
			(switch param1
				(0 fwdLeft)
				(1 fwdRight)
				(2 bacLeft)
				(3 bacRight)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(event claimed: 1)
			(return number)
		)
		(return 0)
	)

	(method (reset &tmp temp0)
		(cond
			((== (= temp0 (squares indexOf: self)) 0)
				([global200 temp0] checker: 99)
			)
			((< temp0 13)
				([global200 temp0] checker: -1)
			)
			((< temp0 21)
				([global200 temp0] checker: 0)
			)
			(else
				([global200 temp0] checker: 1)
			)
		)
	)
)

(class CheckPlayer of List
	(properties
		type 0
		myColor 0
		playerName 0
		skill 0
		wins 0
		losses 0
		draws 0
	)

	(method (cue)
		(cond
			((== global266 200)
				(cond
					((== (global272 type:) 2)
						(global272 cel: 3)
					)
					((== (global272 type:) -2)
						(global272 cel: 3)
					)
					(
						(and
							(== (global272 prevView:) (global272 view:))
							(== global266 (gCurRoom picture:))
						)
						(global272 dim:)
					)
				)
				(if
					(and
						(== (global272 prevView:) (global272 view:))
						(== global266 (gCurRoom picture:))
					)
					(if (== global178 player1)
						(gSound play: 200 setLoop: 1)
					else
						(gSound play: 201 setLoop: 1)
					)
					(if (global272 validMove: global236)
						(global272 setPri: 10 stopUpd:)
						(if (not global246)
							((gCurRoom script:) cue:)
						)
					else
						(proc0_4)
						(gSound2 play: 904 setLoop: 1)
						(global272
							setPri: 15
							setStep: 20 20
							setMotion:
								MoveTo
								(global272 prevX:)
								(global272 prevY:)
								global272
						)
					)
				else
					((gCurRoom script:) cue:)
				)
			)
			(
				(and
					(== (global272 prevView:) (global272 view:))
					(== global266 (gCurRoom picture:))
				)
				(gSound play: 208 setLoop: 1)
				(if (or (== (global272 type:) -2) (== (global272 type:) 2))
					(cond
						((== (global272 view:) 250)
							(global272 view: 251 hiView: 251)
						)
						((== (global272 view:) 252)
							(global272 view: 253 hiView: 253)
						)
					)
				)
				(global272 setCycle: 0)
				(global272 cel: 0)
				(if (== (global178 myColor:) -1)
					(global272 loop: 3)
				else
					(global272 loop: 2)
				)
				(proc0_1)
				(global272 setPri: 10 stopUpd:)
				(proc0_3)
				((gCurRoom script:) cue:)
			)
			((global272 validMove: global236)
				(global272 setPri: 10 stopUpd:)
				(cond
					((== (global272 type:) 2)
						(global272 cel: 3)
					)
					((== (global272 type:) -2)
						(global272 cel: 3)
					)
				)
				(proc0_3)
				((gCurRoom script:) cue:)
			)
			(else
				(proc0_4)
				(global272
					setPri: 15
					setStep: 20 20
					setMotion:
						MoveToEndLoop
						(global272 prevX:)
						(global272 prevY:)
						global272
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (== (global178 type:) 2)
			(return 0)
		)
		(cond
			((= temp1 (pieces firstTrue: #handleEvent event))
				(if (and global245 (!= temp1 global272))
					(return 0)
				)
				(if (== (temp1 sqrNum:) 99)
					(return 0)
				)
				(if (not (self myPiece: temp1))
					(return 0)
				)
				(if (and (== (temp1 processEvent: event) 1) global181)
					(= global272 global181)
					(= global235 (global181 sqrNum:))
					(= temp3 (Event new:))
					(cond
						((= temp0 (squares firstTrue: #handleEvent temp3))
							(= temp0 (temp0 number:))
						)
						((dumSqrs firstTrue: #handleEvent temp3)
							(= temp0 -1)
						)
					)
					(temp3 dispose:)
					(if (global181 validMove: temp0)
						(proc0_4)
						(proc0_1)
						(= global236 temp0)
						(if (== global266 200)
							(global181 setPri: 10 stopUpd:)
							(global181
								posn:
									(+ ([global200 global236] nsLeft:) 14)
									(+ ([global200 global236] nsTop:) 12)
							)
							(if (== global178 player1)
								(gSound play: 200 setLoop: 1)
							else
								(gSound play: 201 setLoop: 1)
							)
							(if (not global246)
								((gCurRoom script:) cue:)
							)
						else
							(proc0_4)
							(if
								(global272
									inRect:
										([global200 global236] nsLeft:)
										([global200 global236] nsTop:)
										([global200 global236] nsRight:)
										([global200 global236] nsBottom:)
								)
								(global272
									setCycle: 0
									cel: 0
									setMotion: 0
									forceUpd:
								)
								(global272
									posn:
										(+ ([global200 global236] nsLeft:) 14)
										(+ ([global200 global236] nsTop:) 12)
								)
								(self cue:)
							else
								(global272
									setPri: 15
									setMotion:
										MoveToEndLoop
										(+ ([global200 global236] nsLeft:) 14)
										(+ ([global200 global236] nsTop:) 12)
										self
								)
							)
						)
					else
						(proc0_4)
						(if
							(and
								(!= (global181 prevX:) (global181 x:))
								(!= (global181 prevY:) (global181 y:))
							)
							(gSound2 play: 904 setLoop: 1)
						)
						(if (== global266 250)
							((ScriptID 203 6) doit:) ; findLoop
							(global181
								setPri: 15
								setMotion:
									MoveToEndLoop
									(global181 prevX:)
									(global181 prevY:)
									global181
							)
						else
							(global181
								setPri: 15
								setStep: 20 20
								setMotion:
									MoveTo
									(global181 prevX:)
									(global181 prevY:)
									global181
							)
						)
					)
					(= global181 0)
				)
			)
			(global181
				(= global272 global181)
				(= global235 (global181 sqrNum:))
				(= temp3 (Event new:))
				(cond
					((= temp0 (squares firstTrue: #handleEvent temp3))
						(= temp0 (temp0 number:))
					)
					((dumSqrs firstTrue: #handleEvent temp3)
						(= temp0 -1)
					)
				)
				(temp3 dispose:)
				(= global236 temp0)
				(proc0_4)
				(if (< 0 global236 33)
					(cond
						((== global266 200)
							(global181
								setPri: 15
								setMotion:
									MoveTo
									(+ ([global200 temp0] nsLeft:) 14)
									(+ ([global200 temp0] nsTop:) 12)
									self
							)
						)
						((global181 validMove: global236)
							(global181
								setPri: 15
								setMotion:
									MoveToEndLoop
									(+ ([global200 temp0] nsLeft:) 14)
									(+ ([global200 temp0] nsTop:) 12)
									self
							)
						)
						(else
							(proc0_3)
							(global181 dim:)
						)
					)
				else
					(proc0_3)
					(global181 dim:)
				)
				(= global181 0)
			)
		)
	)

	(method (myPiece param1)
		(if (and (== myColor -1) (> (param1 type:) 0))
			(gSound2 play: 907 setLoop: 1)
			(gChar1 say: (Random 15 17) -32768 443)
			(return 0)
		)
		(if (and (== myColor 1) (< (param1 type:) 0))
			(gSound2 play: 907 setLoop: 1)
			(gChar1 say: (Random 15 17) -32768 443)
			(return 0)
		)
		(return 1)
	)
)

(class DumSqr of KMRect
	(properties)

	(method (init)
		(super init:)
		(dumSqrs add: self)
		(self addKeyMouse:)
	)

	(method (handleEvent event)
		(if
			(and
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(event claimed: 1)
			(event claimed:)
			(return)
		)
		(return 0)
	)
)

(instance player1 of CheckPlayer
	(properties
		type 2
		myColor 1
	)
)

(instance player2 of CheckPlayer
	(properties
		type 1
		myColor -1
	)
)

(instance B1 of Piece
	(properties
		sqrNum 1
	)
)

(instance B2 of Piece
	(properties
		sqrNum 2
	)
)

(instance B3 of Piece
	(properties
		sqrNum 3
	)
)

(instance B4 of Piece
	(properties
		sqrNum 4
	)
)

(instance B5 of Piece
	(properties
		sqrNum 5
	)
)

(instance B6 of Piece
	(properties
		sqrNum 6
	)
)

(instance B7 of Piece
	(properties
		sqrNum 7
	)
)

(instance B8 of Piece
	(properties
		sqrNum 8
	)
)

(instance B9 of Piece
	(properties
		sqrNum 9
	)
)

(instance B10 of Piece
	(properties
		sqrNum 10
	)
)

(instance B11 of Piece
	(properties
		sqrNum 11
	)
)

(instance B12 of Piece
	(properties
		sqrNum 12
	)
)

(instance R21 of Piece
	(properties
		type 1
		sqrNum 21
	)
)

(instance R22 of Piece
	(properties
		type 1
		sqrNum 22
	)
)

(instance R23 of Piece
	(properties
		type 1
		sqrNum 23
	)
)

(instance R24 of Piece
	(properties
		type 1
		sqrNum 24
	)
)

(instance R25 of Piece
	(properties
		type 1
		sqrNum 25
	)
)

(instance R26 of Piece
	(properties
		type 1
		sqrNum 26
	)
)

(instance R27 of Piece
	(properties
		type 1
		sqrNum 27
	)
)

(instance R28 of Piece
	(properties
		type 1
		sqrNum 28
	)
)

(instance R29 of Piece
	(properties
		type 1
		sqrNum 29
	)
)

(instance R30 of Piece
	(properties
		type 1
		sqrNum 30
	)
)

(instance R31 of Piece
	(properties
		type 1
		sqrNum 31
	)
)

(instance R32 of Piece
	(properties
		type 1
		sqrNum 32
	)
)

(instance pieces of List
	(properties)
)

(instance squares of List
	(properties)
)

(instance dumSqrs of List
	(properties)
)

(instance dragSpider of Code
	(properties)

	(method (init param1)
		(= local0 (param1 x:))
		(= local1 (param1 y:))
		(= local50 0)
		(param1 moveSpeed: 6 cycleSpeed: 6 cel: (param1 lastCel:) forceUpd:)
	)

	(method (doit param1)
		(param1 x: local0)
		(param1 y: local1)
		(if (param1 cycler:)
			((param1 cycler:) doit:)
		)
		(if (param1 mover:)
			((param1 mover:) doit:)
		)
		(if
			(and
				(== local50 0)
				(not (param1 mover:))
				(not (param1 cycler:))
				(== (param1 cel:) (param1 lastCel:))
				(or
					(< gMouseX (- local0 10))
					(> gMouseX (+ local0 10))
					(< gMouseY (- local1 10))
					(> gMouseY (+ local1 10))
				)
				(u< (= local50 (GetTime)) 15)
			)
			(= local50 15)
		)
		(if (and local50 (u> (GetTime) (+ local50 15)))
			(gLooperDir8 doit: param1 (param1 heading:))
			(gSound2 play: 206 setLoop: 1)
			(param1 cel: 0 setMotion: MoveToEndLoop gMouseX gMouseY)
			(= local50 0)
		)
		(= local0 (param1 x:))
		(= local1 (param1 y:))
	)
)

(instance theArrow of Actor
	(properties
		x 32
		y 166
		view 850
		cel 1
	)
)

(instance checkDraw of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 0)
		(for ((= temp0 1)) (< temp0 33) ((++ temp0))
			(switch ([global200 temp0] checker:)
				(1
					(++ temp2)
					(+= temp1 2)
				)
				(2
					(++ temp2)
					(+= temp1 3)
				)
				(-1
					(++ temp2)
					(-= temp1 2)
				)
				(-2
					(++ temp2)
					(-= temp1 3)
				)
			)
		)
		(if global274
			(if (>= global249 (+ local54 20))
				(if (== temp2 local53)
					(return 1)
				else
					(= global274 0)
				)
			)
		else
			(= global274 1)
			(= local53 temp2)
			(= local54 global249)
		)
		(cond
			((< temp1 0)
				(return 1)
			)
			((> temp1 0)
				(return 0)
			)
			((== temp1 0)
				(return 1)
			)
		)
	)
)

