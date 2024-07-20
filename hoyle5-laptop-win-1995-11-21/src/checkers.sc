;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1200)
(include sci.sh)
(use Main)
(use KeyMouse)
(use MoveToEndLoop)
(use TrackingView)
(use h5Messager)
(use Print)
(use IconBar)
(use Motion)
(use Actor)
(use System)

(public
	checkers 0
	pieces 1
	proc1200_2 2
	R29 3
	R25 4
	R22 5
	player1 6
	player2 7
	squares 8
	proc1200_10 10
)

(local
	local0
	local1
	local2
	[local3 24] = [447 353 259 165 494 400 306 212 447 353 259 165 494 400 306 212 447 353 259 165 494 400 306 212]
	[local27 24] = [376 376 376 376 329 329 329 329 282 282 282 282 141 141 141 141 94 94 94 94 47 47 47 47]
	local51
	local52
	local53
	local54
	local55
	local56
	[local57 16] = [3 3 3 3 3 2 2 2 2 2 1 1 1 1 1 1]
)

(procedure (localproc_0 &tmp temp0 [temp1 499]) ; UNUSED
	(temp0 format: &rest) ; UNINIT
)

(procedure (localproc_1)
	(= global189 0)
	(pieces eachElementDo: #update)
)

(procedure (proc1200_2)
	(IconBarF darken:)
	((ScriptID 1280 0) init:) ; scoreCheckers
	(DisposeScript 1280)
	(IconBarF lighten:)
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

(procedure (proc1200_10 param1)
	(if argc
		(= local56 param1)
	else
		(return local56)
	)
)

(instance checkers of HoyleRoom
	(properties
		style 0
	)

	(method (init)
		(Load rsVIEW 1200)
		(if (not global921)
			(Load 140 1802) ; WAVE
			(Load 140 1803) ; WAVE
			(Load 140 1804) ; WAVE
			(Load 140 1805) ; WAVE
			(Load 140 1806) ; WAVE
		)
		(= global189 0)
		(= global816 0)
		(= global818 0)
		(= global819 0)
		(= global833 0)
		(= global834 0)
		(= gLooperDir8 looperDir8)
		(ScriptID 1202) ; root
		(ScriptID 1201) ; book
		(ScriptID 1203) ; endGame1
		(ScriptID 1204) ; sqr0
		(= global832 200)
		(= gCardGameScriptNumber 1200)
		(= local56 0)
		((= gCheckers_opt (ScriptID 1201 2)) doit:) ; checkers_opt
		(if global878
			(PlaySong play: (+ 50 global878))
		else
			(PlaySong play: 51)
		)
		(if (not local56)
			(gSong setLoop: 1)
		)
		(= local0 global832)
		(= picture (+ global877 global385))
		(= global463 1)
		(= global466 2)
		(super init:)
		(checkerBoard init:)
		(= global195 0)
		(= gSkill 0)
		(player1 skill: global195 type: 1 playerName: {COMPUTER})
		(player2 skill: gSkill type: 0 playerName: {HUMAN})
		(if (== global799 0)
			(player2 type: 0)
			(= global799 1)
		)
		(= gTheArrow theArrow)
		(= global801 0)
		(cond
			((not global199)
				(gGame setCursor: 999 1)
				(if (and (== (player1 type:) 0) (== global799 1))
					(= global837 2)
				else
					(= global837 1)
				)
				(= global800 player1)
				(= global825 1)
				(cond
					((and (== global799 1) (== (player1 type:) 0))
						(= local53 1)
					)
					((== global799 2)
						(= local53 3)
					)
				)
			)
			((== global837 2)
				(= global800 player2)
				(if (== (player1 type:) 1)
					(DisableCursor)
				)
				(if (== global799 1)
					(= local53 1)
				else
					(= local53 2)
				)
			)
			(else
				(= global800 player1)
				(if (== global799 2)
					(= local53 3)
				)
			)
		)
		(if (== global799 1)
			(= global810 1)
			(if (== (player1 type:) 0)
				(= global837 player2)
				(= global800 player2)
				(= global825 -1)
				(player1 skill: gSkill type: 1 playerName: {Computer})
				(player2 skill: global195 type: 0 playerName: {You})
			)
		)
		((ScriptID 1202 5) add:) ; movLst
		((ScriptID 1202 0) add:) ; root
		((ScriptID 1202 1) add:) ; lev1Lst
		((ScriptID 1202 2) add:) ; lev2Lst
		((ScriptID 1202 3) add:) ; lev3Lst
		((ScriptID 1202 4) add:) ; lev4Lst
		((ScriptID 1202 6) add:) ; lev44Lst
		((ScriptID 1202 7) add:) ; lev5Lst
		(pieces add:)
		(squares add:)
		(dumSqrs add:)
		(player1 add:)
		(player2 add:)
		(gTheArrow init:)
		(= gGameScript (ScriptID 1201 1)) ; gameScript
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
		((ScriptID 1204 0) init:) ; sqr0
		((ScriptID 1204 1) init:) ; sqr1
		((ScriptID 1204 2) init:) ; sqr2
		((ScriptID 1204 3) init:) ; sqr3
		((ScriptID 1204 4) init:) ; sqr4
		((ScriptID 1204 5) init:) ; sqr5
		((ScriptID 1204 6) init:) ; sqr6
		((ScriptID 1204 7) init:) ; sqr7
		((ScriptID 1204 8) init:) ; sqr8
		((ScriptID 1204 9) init:) ; sqr9
		((ScriptID 1204 10) init:) ; sqr10
		((ScriptID 1204 11) init:) ; sqr11
		((ScriptID 1204 12) init:) ; sqr12
		((ScriptID 1204 13) init:) ; sqr13
		((ScriptID 1204 14) init:) ; sqr14
		((ScriptID 1204 15) init:) ; sqr15
		((ScriptID 1204 16) init:) ; sqr16
		((ScriptID 1204 17) init:) ; sqr17
		((ScriptID 1204 18) init:) ; sqr18
		((ScriptID 1204 19) init:) ; sqr19
		((ScriptID 1204 20) init:) ; sqr20
		((ScriptID 1204 21) init:) ; sqr21
		((ScriptID 1204 22) init:) ; sqr22
		((ScriptID 1204 23) init:) ; sqr23
		((ScriptID 1204 24) init:) ; sqr24
		((ScriptID 1204 25) init:) ; sqr25
		((ScriptID 1204 26) init:) ; sqr26
		((ScriptID 1204 27) init:) ; sqr27
		((ScriptID 1204 28) init:) ; sqr28
		((ScriptID 1204 29) init:) ; sqr29
		((ScriptID 1204 30) init:) ; sqr30
		((ScriptID 1204 31) init:) ; sqr31
		((ScriptID 1204 32) init:) ; sqr32
		((ScriptID 1204 33) init:) ; dumSqr1
		((ScriptID 1204 34) init:) ; dumSqr2
		((ScriptID 1204 35) init:) ; dumSqr3
		((ScriptID 1204 36) init:) ; dumSqr4
		((ScriptID 1204 37) init:) ; dumSqr5
		((ScriptID 1204 38) init:) ; dumSqr6
		((ScriptID 1204 39) init:) ; dumSqr7
		((ScriptID 1204 40) init:) ; dumSqr8
		((ScriptID 1204 41) init:) ; dumSqr9
		((ScriptID 1204 42) init:) ; dumSqr10
		((ScriptID 1204 43) init:) ; dumSqr11
		((ScriptID 1204 44) init:) ; dumSqr12
		((ScriptID 1204 45) init:) ; dumSqr13
		((ScriptID 1204 46) init:) ; dumSqr14
		((ScriptID 1204 47) init:) ; dumSqr15
		((ScriptID 1204 48) init:) ; dumSqr16
		((ScriptID 1204 49) init:) ; dumSqr17
		((ScriptID 1204 50) init:) ; dumSqr18
		((ScriptID 1204 51) init:) ; dumSqr19
		((ScriptID 1204 52) init:) ; dumSqr20
		((ScriptID 1204 53) init:) ; dumSqr21
		((ScriptID 1204 54) init:) ; dumSqr22
		((ScriptID 1204 55) init:) ; dumSqr23
		((ScriptID 1204 56) init:) ; dumSqr24
		((ScriptID 1204 57) init:) ; dumSqr25
		((ScriptID 1204 58) init:) ; dumSqr26
		((ScriptID 1204 59) init:) ; dumSqr27
		((ScriptID 1204 60) init:) ; dumSqr28
		((ScriptID 1204 61) init:) ; dumSqr29
		((ScriptID 1204 62) init:) ; dumSqr30
		((ScriptID 1204 63) init:) ; dumSqr31
		((ScriptID 1204 64) init:) ; dumSqr32
		(gChar1 posn: 60 60 show: init:)
		(Characters init:)
		(IconBarF init:)
		(IconBar show:)
		(self setScript: gGameScript)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (!= global832 local0)
			(IconBar disable:)
			(= local0 global832)
			(localproc_1)
			(if (== local0 250)
				(gSound2 play: 805 setLoop: 1)
			)
			(IconBar enable:)
		)
		(if global828
			(if (and (== global799 2) (== global800 player1))
				(player2 wins: (+ (player2 wins:) 1))
				(player1 losses: (+ (player1 losses:) 1))
			else
				(player1 wins: (+ (player1 wins:) 1))
				(player2 losses: (+ (player2 losses:) 1))
			)
			(proc1200_2)
			(= global748 0)
			((ScriptID 930 0) init: 1270) ; yesNo
			(DisposeScript 930)
			(cond
				(global748
					(if (== global837 1)
						(= global837 2)
					else
						(= global837 1)
					)
					(squares eachElementDo: #reset)
					(pieces eachElementDo: #reset)
					(gCurRoom setScript: gGameScript)
				)
				(global924
					(gGame quitGame:)
					(proc0_8 0)
				)
				(else
					(= gNewRoomNum 975) ; chooseGame
				)
			)
		)
		(if (and global826 (== global799 1))
			(cond
				((checkDraw doit:)
					(if (== gAttitudeSetting 0)
						(if global916
							(gChar1
								say:
									1200
									(- (+ (gChar1 view:) 1) 1400)
									166
									0
									2
							)
						else
							(gChar1
								say: 1200 (+ (gChar1 view:) 1) 166 0 2
							)
						)
					else
						(gChar1
							sayReg:
								1200
								(+ (gChar1 view:) 1)
								166
								0
								(Random 1 2)
						)
					)
					(player1 draws: (+ (player1 draws:) 1))
					(player2 draws: (+ (player2 draws:) 1))
					(proc1200_2)
					(= global748 0)
					((ScriptID 930 0) init: 1270) ; yesNo
					(DisposeScript 930)
					(cond
						(global748
							(if (== global837 1)
								(= global837 2)
							else
								(= global837 1)
							)
							(squares eachElementDo: #reset)
							(pieces eachElementDo: #reset)
							(gCurRoom setScript: gGameScript)
						)
						(global924
							(gGame quitGame:)
							(proc0_8 0)
						)
						(else
							(= gNewRoomNum 975) ; chooseGame
						)
					)
				)
				((== gAttitudeSetting 0)
					(if global916
						(gChar1
							say: 1200 (- (+ (gChar1 view:) 1) 1400) 167 0 2
						)
					else
						(gChar1 say: 1200 (+ (gChar1 view:) 1) 167 0 2)
					)
				)
				(else
					(gChar1
						sayReg: 1200 (+ (gChar1 view:) 1) 167 0 (Random 1 2)
					)
				)
			)
		)
		(= global826 0)
	)

	(method (dispose &tmp temp0)
		((ScriptID 1202 5) dispose:) ; movLst
		((ScriptID 1202 1) dispose:) ; lev1Lst
		((ScriptID 1202 2) dispose:) ; lev2Lst
		((ScriptID 1202 3) dispose:) ; lev3Lst
		((ScriptID 1202 4) dispose:) ; lev4Lst
		((ScriptID 1202 6) dispose:) ; lev44Lst
		((ScriptID 1202 7) dispose:) ; lev5Lst
		((ScriptID 1202 0) dispose:) ; root
		(pieces release: dispose:)
		(squares release: dispose:)
		(dumSqrs release: dispose:)
		(KeyMouse release: dispose:)
		(player1 release: dispose:)
		(player2 release: dispose:)
		(IconBarF dispose:)
		(self setScript: 0)
		(DisposeScript 1202)
		(DisposeScript 1201)
		(DisposeScript 1203)
		(DisposeScript 1204)
		(DisposeScript 1210)
		(DisposeScript 11)
		(DisposeScript 1302)
		(DisposeScript 9)
		(DisposeScript 64941)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(return 0)
		else
			(global800 handleEvent: event)
		)
	)
)

(class Piece of DragableActor
	(properties
		priority 10
		cel 1
		yStep 7
		xStep 12
		hiView 1200
		hiCel 0
		type -1
		sqrNum 0
	)

	(method (update)
		(if (== global832 250)
			((ScriptID 1201 3) setCycle: 0 hide: cel: 0) ; splash
			(cond
				((or (== (self type:) -1) (== (self type:) 1))
					(if (== (self loop:) 2)
						(self view: 1250 hiView: 1250)
					else
						(self view: 1252 hiView: 1252)
					)
				)
				((or (== (self type:) -2) (== (self type:) 2))
					(if (== (self loop:) 2)
						(self view: 1251 hiView: 1251)
					else
						(self view: 1253 hiView: 1253)
					)
				)
			)
			(if (< (pieces indexOf: self) 12)
				(self loop: 3 hiLoop: 3)
			else
				(self loop: 2 hiLoop: 2)
			)
			(self looper: gLooperDir8 cel: 0 hiCel: 7 draggingCode: dragSpider)
		else
			(cond
				((or (== (self type:) -1) (== (self type:) 1))
					(if (== (self view:) 1250)
						(self setLoop: 2 1 hiLoop: 2 cel: 1 hiCel: 0)
					else
						(self setLoop: 0 1 hiLoop: 0 cel: 1 hiCel: 0)
					)
				)
				((or (== (self type:) -2) (== (self type:) 2))
					(if (== (self view:) 1251)
						(self setLoop: 2 1 hiLoop: 2 cel: 3 hiCel: 2)
					else
						(self setLoop: 0 1 hiLoop: 0 cel: 3 hiCel: 2)
					)
				)
			)
			(self
				view: 1200
				hiView: 1200
				moveSpeed: global898
				looper: 0
				draggingCode: 0
				setCycle: 0
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
		(if (and (== view prevView) (== global832 (gCurRoom picture:)))
			(self dim:)
		)
		(self setPri: 10 setCycle: 0)
		(if (== global832 250)
			(gSound2 stop:)
			(gSound play: 806 setLoop: 1)
			(if (== (global800 myColor:) -1)
				(self loop: 3)
			else
				(self loop: 2)
			)
			(self cel: 0)
		else
			(gSound2 stop:)
			(gSound play: 801)
			(self setStep: (* 12 [local57 global898]) (* 9 [local57 global898]))
		)
		(EnableCursor)
	)

	(method (jmpAvail &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 1)) (< temp0 33) ((++ temp0))
			(cond
				((== (global800 myColor:) -1)
					(if (< ([global841 temp0] checker:) 0)
						(for
							((= temp1 3))
							(>=
								temp1
								(if (== ([global841 temp0] checker:) -1)
									2
								else
									0
								)
							)
							((-- temp1))
							
							(= temp2 ([global841 temp0] sqrOn: temp1))
							(= temp3 ([global841 temp2] sqrOn: temp1))
							(if
								(and
									(> ([global841 temp2] checker:) 0)
									(== ([global841 temp3] checker:) 0)
								)
								(return 1)
							)
						)
					)
				)
				((> ([global841 temp0] checker:) 0)
					(for
						((= temp1 0))
						(<=
							temp1
							(if (== ([global841 temp0] checker:) 1) 1 else 3)
						)
						((++ temp1))
						
						(= temp2 ([global841 temp0] sqrOn: temp1))
						(= temp3 ([global841 temp2] sqrOn: temp1))
						(if
							(and
								(< ([global841 temp2] checker:) 0)
								(== ([global841 temp3] checker:) 0)
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
		(= global812 0)
		(= temp1 0)
		(if (== global810 1)
			(= temp1 (self jmpAvail:))
		)
		(if (> param1 0)
			(cond
				(([global841 param1] checker:)
					(if (!= (self sqrNum:) param1)
						(gSound play: 905)
						(= global920 1)
						(gChar1 say: 1200 15 154 0 2)
					)
					(self dim:)
					(return 0)
				)
				(
					(and
						(> param1 sqrNum)
						(or (== (global800 myColor:) -1) (== (self type:) 2))
					)
					(switch param1
						(([global841 sqrNum] sqrOn: 3)
							(if global811
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(if (== gAttitudeSetting 0)
									(= global920 1)
									(gChar1 say: 1200 15 155 0 2)
								else
									(= global920 1)
									(gChar1
										sayReg: 1200 15 155 0 (Random 1 2)
									)
								)
								(self dim:)
								(return 0)
							)
						)
						(([global841 sqrNum] sqrOn: 2)
							(if global811
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(if (== gAttitudeSetting 0)
									(= global920 1)
									(gChar1 say: 1200 15 155 0 2)
								else
									(= global920 1)
									(gChar1
										sayReg: 1200 15 155 0 (Random 1 2)
									)
								)
								(self dim:)
								(return 0)
							)
						)
						(([global841 ([global841 sqrNum] sqrOn: 3)] sqrOn: 3)
							(self dim:)
							(return (self jumpPiece: param1 3))
						)
						(([global841 ([global841 sqrNum] sqrOn: 2)] sqrOn: 2)
							(self dim:)
							(return (self jumpPiece: param1 2))
						)
					)
				)
				(
					(and
						(< param1 sqrNum)
						(or (== (global800 myColor:) 1) (== (self type:) -2))
					)
					(switch param1
						(([global841 sqrNum] sqrOn: 1)
							(if global811
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(if (== gAttitudeSetting 0)
									(= global920 1)
									(gChar1 say: 1200 15 155 0 2)
								else
									(= global920 1)
									(gChar1
										sayReg: 1200 15 155 0 (Random 1 2)
									)
								)
								(self dim:)
								(return 0)
							)
						)
						(([global841 sqrNum] sqrOn: 0)
							(if global811
								(return 0)
							)
							(if (not temp1)
								(self movePiece: param1)
								(return 1)
							else
								(if (== gAttitudeSetting 0)
									(= global920 1)
									(gChar1 say: 1200 15 155 0 2)
								else
									(= global920 1)
									(gChar1
										sayReg: 1200 15 155 0 (Random 1 2)
									)
								)
								(self dim:)
								(return 0)
							)
						)
						(([global841 ([global841 sqrNum] sqrOn: 0)] sqrOn: 0)
							(self dim:)
							(return (self jumpPiece: param1 0))
						)
						(([global841 ([global841 sqrNum] sqrOn: 1)] sqrOn: 1)
							(self dim:)
							(return (self jumpPiece: param1 1))
						)
					)
				)
				((< ([global841 param1] row:) ([global841 sqrNum] row:))
					(if (== gAttitudeSetting 0)
						(= global920 1)
						(gChar1 say: 1200 15 153 0 2)
					else
						(= global920 1)
						(gChar1 sayReg: 1200 15 153 0 (Random 1 2))
					)
					(self dim:)
					(return 0)
				)
			)
		)
		(if (== param1 0)
			(self dim:)
			(return 0)
		)
		(if (== param1 -1)
			(if (== gAttitudeSetting 0)
				(= global920 1)
				(gChar1 say: 1200 15 154 0 2)
			else
				(= global920 1)
				(gChar1 sayReg: 1200 15 154 0 (Random 1 2))
			)
			(self dim:)
			(return 0)
		)
		(= global920 1)
		(gChar1 say: 1200 15 154 0 2)
		(self dim:)
		(return 0)
	)

	(method (multiChk param1 param2 &tmp temp0 temp1 temp2 [temp3 2])
		(if (== (global800 myColor:) -1)
			(for
				((= temp0 0))
				(<= temp0 (if (== (self type:) -1) 1 else 3))
				((++ temp0))
				
				(if (not (localproc_2 temp0 param2))
					(= temp1 ([global841 param1] sqrOn: temp0))
					(= temp2 ([global841 temp1] sqrOn: temp0))
					(if
						(and
							(> ([global841 temp1] checker:) 0)
							(or
								(== ([global841 temp2] checker:) 0)
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
					(= temp1 ([global841 param1] sqrOn: temp0))
					(= temp2 ([global841 temp1] sqrOn: temp0))
					(if
						(and
							(< ([global841 temp1] checker:) 0)
							(or
								(== ([global841 temp2] checker:) 0)
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
		([global841 sqrNum] checker: 0)
		(self sqrNum: param1)
		(cond
			((and (== (global800 myColor:) -1) (> param1 28))
				(if (!= (self type:) -2)
					(= global839 1)
				)
				(if (== global836 1)
					(= global836 2)
				)
				([global841 param1] checker: -2)
				(self type: -2)
				(if (== global832 200)
					(self cel: 3 hiCel: 2)
					(= prevCel 3)
				)
			)
			((and (== (global800 myColor:) 1) (< param1 5))
				(if (!= (self type:) 2)
					(= global839 1)
				)
				([global841 param1] checker: 2)
				(self type: 2)
				(if (== global832 200)
					(self cel: 3 hiCel: 2)
					(= prevCel 3)
				)
			)
			(else
				([global841 param1] checker: type)
			)
		)
	)

	(method (jumpPiece param1 param2)
		(cond
			((== (global800 myColor:) -1)
				(if
					(>
						([global841 ([global841 sqrNum] sqrOn: param2)]
							checker:
						)
						0
					)
					(= global816
						(pieces
							firstTrue:
								#findPiece
								([global841 sqrNum] sqrOn: param2)
						)
					)
					(= global812 1)
					([global841 ([global841 sqrNum] sqrOn: param2)] checker: 0)
					([global841 sqrNum] checker: 0)
					(self sqrNum: param1)
					(if (and (> param1 28) (!= (self type:) -2))
						([global841 param1] checker: -2)
						(self type: -2)
						(if (== global832 200)
							(self cel: 3 hiCel: 2)
							(= prevCel 3)
						)
						(= global811 0)
					else
						([global841 param1] checker: type)
						(= global811 (self moreJumps:))
					)
					(if (== global832 200)
						((gCurRoom script:) cue:)
					)
					(return 1)
				else
					(= global920 1)
					(gChar1 say: 1200 15 154 0 2)
					(return 0)
				)
			)
			((< ([global841 ([global841 sqrNum] sqrOn: param2)] checker:) 0)
				(= global816
					(pieces
						firstTrue: #findPiece ([global841 sqrNum] sqrOn: param2)
					)
				)
				(= global812 1)
				([global841 ([global841 sqrNum] sqrOn: param2)] checker: 0)
				([global841 sqrNum] checker: 0)
				(self sqrNum: param1)
				(if (and (< param1 5) (!= (self type:) 2))
					([global841 param1] checker: 2)
					(self type: 2)
					(if (== global832 200)
						(self cel: 3 hiCel: 2)
						(= prevCel 3)
					)
					(= global811 0)
				else
					([global841 param1] checker: type)
					(= global811 (self moreJumps:))
				)
				(if (== global832 200)
					((gCurRoom script:) cue:)
				)
				(return 1)
			)
			(else
				(= global920 1)
				(gChar1 say: 1200 15 154 0 2)
				(return 0)
			)
		)
	)

	(method (moreJumps &tmp temp0 temp1 temp2)
		(if (== (global800 myColor:) -1)
			(for
				((= temp0 3))
				(>= temp0 (if (== type -1) 2 else 0))
				((-- temp0))
				
				(= temp1 ([global841 sqrNum] sqrOn: temp0))
				(= temp2 ([global841 temp1] sqrOn: temp0))
				(if
					(and
						(> ([global841 temp1] checker:) 0)
						(== ([global841 temp2] checker:) 0)
					)
					(return 1)
				)
			)
		else
			(for ((= temp0 0)) (<= temp0 (if (== type 1) 1 else 3)) ((++ temp0))
				(= temp1 ([global841 sqrNum] sqrOn: temp0))
				(= temp2 ([global841 temp1] sqrOn: temp0))
				(if
					(and
						(< ([global841 temp1] checker:) 0)
						(== ([global841 temp2] checker:) 0)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (init)
		(if (== global832 250)
			(cond
				((== global825 -1)
					(if (< (pieces size:) 12)
						(self view: 1250 hiView: 1250 loop: 3 hiLoop: 3)
					else
						(self view: 1252 hiView: 1252 loop: 2 hiLoop: 2)
					)
				)
				((< (pieces size:) 12)
					(self view: 1252 hiView: 1252 loop: 3 hiLoop: 3)
				)
				(else
					(self view: 1250 hiView: 1250 loop: 2 hiLoop: 2)
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
			(self view: 1200 setPri: 10)
			(cond
				((== global825 -1)
					(if (< (pieces size:) 12)
						(self setLoop: 2 1 hiLoop: 2)
					else
						(self setLoop: 0 1 hiLoop: 0)
					)
				)
				((< (pieces size:) 12)
					(self setLoop: 0 1 hiLoop: 0)
				)
				(else
					(self setLoop: 2 1 hiLoop: 2)
				)
			)
		)
		(self x: [local3 (pieces size:)])
		(self y: [local27 (pieces size:)])
		(self xStep: (* 12 [local57 global898]))
		(self yStep: (* 9 [local57 global898]))
		(super init: &rest)
		(pieces add: self)
		(self ignoreActors:)
	)

	(method (reset &tmp temp0)
		(if (!= ((ScriptID 1202 0) size:) 0) ; root
			((ScriptID 1202 0) freeNodes: (ScriptID 1202 0)) ; root, root
			((ScriptID 1202 0) release:) ; root
		)
		((ScriptID 1201 3) setCycle: 0 hide: cel: 0) ; splash
		(if (== (= temp0 (pieces indexOf: self)) 0)
			(if (== global825 -1)
				(= global825 1)
				(= global800 player1)
				(if (== (player1 type:) 1)
					(DisableCursor)
				)
			else
				(EnableCursor)
				(= global825 -1)
				(= global800 player2)
			)
		)
		(self setMotion: 0)
		(self
			x: [local3 temp0]
			y: [local27 temp0]
			priority: 10
			xStep: (* 12 [local57 global898])
			yStep: (* 9 [local57 global898])
		)
		(self
			nsLeft: (- (self x:) 33)
			nsRight: (+ (self x:) 33)
			nsTop: (- (self y:) 34)
			nsBottom: (+ (self y:) 34)
		)
		(if (< temp0 12)
			(self type: -1 sqrNum: (+ temp0 1))
		else
			(self type: 1 sqrNum: (+ temp0 9))
		)
		(cond
			((== global832 200)
				(if (== (self loop:) 2)
					(self setLoop: 0 1 hiLoop: 0 setPri: 10)
				else
					(self setLoop: 2 1 hiLoop: 2 setPri: 10)
				)
				(self
					hiCel: 0
					cel: 1
					setStep:
						(* 12 [local57 global898])
						(* 9 [local57 global898])
					moveSpeed: global898
				)
			)
			((or (== (self view:) 1250) (== (self view:) 1251))
				(self view: 1252 hiView: 1252 cel: 0)
			)
			((or (== (self view:) 1252) (== (self view:) 1253))
				(self view: 1250 hiView: 1250 cel: 0)
			)
		)
		(if (== global832 250)
			(if (< temp0 12)
				(self loop: 3 hiLoop: 3)
			else
				(self loop: 2 hiLoop: 2)
			)
			(self cel: 0 hiCel: 7 setCycle: 0)
		)
		(if (== temp0 23)
			(RedrawCast)
			(if (and (== global799 1) (== global825 -1) (== global799 2))
				(if (== global825 -1)
					(Printf {%s moves first} (player2 playerName:))
				else
					(Printf {%s moves first} (player1 playerName:))
				)
			)
		)
	)
)

(class Sqr of Obj
	(properties
		fwdLeft 0
		fwdRight 0
		bacLeft 0
		bacRight 0
		checker 0
		number 0
		row 0
		col 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
	)

	(method (init)
		(= [global841 global801] self)
		(++ global801)
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
				([global841 temp0] checker: 99)
			)
			((< temp0 13)
				([global841 temp0] checker: -1)
			)
			((< temp0 21)
				([global841 temp0] checker: 0)
			)
			(else
				([global841 temp0] checker: 1)
			)
		)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
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
			((== global832 200)
				(cond
					((== (global838 type:) 2)
						(global838 cel: 3)
					)
					((== (global838 type:) -2)
						(global838 cel: 3)
					)
					(
						(and
							(== (global838 prevView:) (global838 view:))
							(== global832 (gCurRoom picture:))
						)
						(global838 dim:)
					)
				)
				(if
					(and
						(== (global838 prevView:) (global838 view:))
						(== global832 (gCurRoom picture:))
					)
					(gSound play: 801)
					(Printf {here})
					(if (global838 validMove: global802)
						(global838 setPri: 10)
						(if (not global812)
							((gCurRoom script:) cue:)
						)
					else
						(DisableCursor)
						(global838
							setPri: 15
							setStep:
								(* 20 [local57 global898])
								(* 20 [local57 global898])
							setMotion:
								MoveTo
								(global838 prevX:)
								(global838 prevY:)
								global838
						)
					)
				else
					((gCurRoom script:) cue:)
				)
			)
			((== (global838 prevView:) (global838 view:))
				(gSound play: 806 setLoop: 1)
				(if (or (== (global838 type:) -2) (== (global838 type:) 2))
					(cond
						((== (global838 view:) 1250)
							(global838 view: 1251 hiView: 1251)
						)
						((== (global838 view:) 1252)
							(global838 view: 1253 hiView: 1253)
						)
					)
				)
				(global838 setCycle: 0)
				(global838 cel: 0)
				(if (== (global800 myColor:) -1)
					(global838 loop: 3)
				else
					(global838 loop: 2)
				)
				(RedrawCast)
				(global838 setPri: 10)
				((gCurRoom script:) cue:)
			)
			((global838 validMove: global802)
				(global838 setPri: 10)
				(cond
					((== (global838 type:) 2)
						(global838 cel: 3)
					)
					((== (global838 type:) -2)
						(global838 cel: 3)
					)
				)
				(EnableCursor)
				((gCurRoom script:) cue:)
			)
			(else
				(DisableCursor)
				(global838
					setPri: 15
					setStep:
						(* 20 [local57 global898])
						(* 20 [local57 global898])
					setMotion:
						MoveToEndLoop
						(global838 prevX:)
						(global838 prevY:)
						global838
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (== (global800 type:) 1)
			(return 0)
		)
		(cond
			((= temp1 (pieces firstTrue: #handleEvent event))
				(if (and global811 (!= temp1 global838))
					(return 0)
				)
				(if (== (temp1 sqrNum:) 99)
					(return 0)
				)
				(if (not (self myPiece: temp1))
					(return 0)
				)
				(if (and (== (temp1 processEvent: event) 1) global189)
					(= global838 global189)
					(= global801 (global189 sqrNum:))
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
					(if (global189 validMove: temp0)
						(DisableCursor)
						(RedrawCast)
						(= global802 temp0)
						(if (== global832 200)
							(global189 setPri: 10)
							(global189
								posn:
									(+ ([global841 global802] nsLeft:) 33)
									(+ ([global841 global802] nsTop:) 33)
							)
							(gSound play: 801)
							(global189
								nsLeft: (+ ([global841 global802] nsLeft:) 18)
							)
							(global189
								nsRight: (- ([global841 global802] nsRight:) 18)
							)
							(global189
								nsTop: (+ ([global841 global802] nsTop:) 18)
							)
							(global189
								nsBottom:
									(- ([global841 global802] nsBottom:) 18)
							)
							(global189 dim:)
							(if (not global812)
								((gCurRoom script:) cue:)
							)
						else
							(DisableCursor)
							(if
								(global838
									inRect:
										([global841 global802] nsLeft:)
										([global841 global802] nsTop:)
										([global841 global802] nsRight:)
										([global841 global802] nsBottom:)
								)
								(global838 setCycle: 0 cel: 0 setMotion: 0)
								(global838
									posn:
										(+ ([global841 global802] nsLeft:) 33)
										(+ ([global841 global802] nsTop:) 33)
								)
								(global838
									nsLeft:
										(+ ([global841 global802] nsLeft:) 18)
								)
								(global838
									nsRight:
										(- ([global841 global802] nsRight:) 18)
								)
								(global838
									nsTop: (+ ([global841 global802] nsTop:) 18)
								)
								(global838
									nsBottom:
										(- ([global841 global802] nsBottom:) 18)
								)
								(self cue:)
							else
								(global838
									setPri: 15
									setMotion:
										MoveToEndLoop
										(+ ([global841 global802] nsLeft:) 33)
										(+ ([global841 global802] nsTop:) 33)
										self
								)
								(global838
									nsLeft:
										(+ ([global841 global802] nsLeft:) 18)
								)
								(global838
									nsRight:
										(- ([global841 global802] nsRight:) 18)
								)
								(global838
									nsTop: (+ ([global841 global802] nsTop:) 18)
								)
								(global838
									nsBottom:
										(- ([global841 global802] nsBottom:) 18)
								)
							)
						)
					else
						(DisableCursor)
						(if
							(and
								(!= (global189 prevX:) (global189 x:))
								(!= (global189 prevY:) (global189 y:))
							)
							1
						)
						(if (== global832 250)
							((ScriptID 1203 6) doit:) ; findLoop
							(global189
								setPri: 15
								setMotion:
									MoveToEndLoop
									(global189 prevX:)
									(global189 prevY:)
									global189
							)
						else
							(global189
								setPri: 15
								setStep:
									(* 20 [local57 global898])
									(* 20 [local57 global898])
								setMotion:
									MoveTo
									(global189 prevX:)
									(global189 prevY:)
									global189
							)
						)
					)
					(= global189 0)
				)
			)
			(global189
				(= global838 global189)
				(= global801 (global189 sqrNum:))
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
				(= global802 temp0)
				(DisableCursor)
				(if (< 0 global802 33)
					(cond
						((== global832 200)
							(global189
								setPri: 15
								setMotion:
									MoveTo
									(+ ([global841 temp0] nsLeft:) 33)
									(+ ([global841 temp0] nsTop:) 33)
									self
							)
						)
						((global189 validMove: global802)
							(global189
								setPri: 15
								setMotion:
									MoveToEndLoop
									(+ ([global841 temp0] nsLeft:) 33)
									(+ ([global841 temp0] nsTop:) 33)
									self
							)
						)
						(else
							(EnableCursor)
							(global189 dim:)
						)
					)
				else
					(EnableCursor)
					(global189 dim:)
				)
				(= global189 0)
			)
		)
	)

	(method (myPiece param1)
		(if (and (== myColor -1) (> (param1 type:) 0))
			(return 0)
		)
		(if (and (== myColor 1) (< (param1 type:) 0))
			(return 0)
		)
		(return 1)
	)
)

(class DumSqr of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
	)

	(method (init)
		(super init:)
		(dumSqrs add: self)
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
		type 1
		myColor 1
	)
)

(instance player2 of CheckPlayer
	(properties
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
		(= local1 (param1 x:))
		(= local2 (param1 y:))
		(= local51 0)
		(param1
			moveSpeed: global898
			cycleSpeed: global898
			cel: (param1 lastCel:)
		)
	)

	(method (doit param1)
		(param1 x: local1)
		(param1 y: local2)
		(if (param1 cycler:)
			((param1 cycler:) doit:)
		)
		(if (param1 mover:)
			((param1 mover:) doit:)
		)
		(if
			(and
				(== local51 0)
				(not (param1 mover:))
				(not (param1 cycler:))
				(== (param1 cel:) (param1 lastCel:))
				(or
					(< gMouseX (- local1 10))
					(> gMouseX (+ local1 10))
					(< gMouseY (- local2 10))
					(> gMouseY (+ local2 10))
				)
				(u< (= local51 (GetTime)) 15)
			)
			(= local51 15)
		)
		(if (and local51 (u> (GetTime) (+ local51 15)))
			(gLooperDir8 doit: param1 (param1 heading:))
			(gSound2 play: 805 setLoop: 1)
			(param1 cel: 0 setMotion: MoveToEndLoop gMouseX gMouseY)
			(= local51 0)
		)
		(= local1 (param1 x:))
		(= local2 (param1 y:))
	)
)

(instance theArrow of Actor
	(properties
		x 5
		y 300
		view 215
		loop 1
		cel 1
	)

	(method (init)
		(self ignoreActors: cue:)
		(super init: &rest)
	)
)

(instance checkDraw of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 0)
		(for ((= temp0 1)) (< temp0 33) ((++ temp0))
			(switch ([global841 temp0] checker:)
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
		(if global840
			(if (>= global815 (+ local55 20))
				(if (== temp2 local54)
					(return 1)
				else
					(= global840 0)
				)
			)
		else
			(= global840 1)
			(= local54 temp2)
			(= local55 global815)
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

(instance looperDir8 of Code
	(properties)

	(method (doit param1 param2)
		(param1
			loop:
				(cond
					((<= 70 param2 110) 0)
					((<= 250 param2 290) 1)
					((<= 160 param2 200) 2)
					((<= 110 param2 160) 4)
					((<= 20 param2 70) 6)
					((<= 200 param2 250) 5)
					((<= 290 param2 340) 7)
					(else 3)
				)
		)
	)
)

(instance checkerBoard of View
	(properties)

	(method (init)
		(self view: 1201 setLoop: 0 cel: 0 posn: 129 12 setPri: 8 show:)
		(super init:)
	)
)

