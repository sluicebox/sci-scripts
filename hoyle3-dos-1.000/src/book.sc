;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use MoveToEndLoop)
(use checkers)
(use Interface)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	book 0
	gameScript 1
	checkers_opt 2
	splash 3
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
)

(instance book of Code
	(properties)

	(method (doit &tmp temp0)
		(global243 capSqr: 0)
		(cond
			((== global249 0)
				(global243 fromSqr: 22)
				(global243 toSqr: 18)
			)
			((== global249 1)
				(cond
					((== global235 9)
						(if (== global236 13)
							(global243 fromSqr: 22)
							(global243 toSqr: 18)
							(= global237 1)
						else
							(== global236 14)
							(global243 fromSqr: 22)
							(global243 toSqr: 18)
							(= global237 2)
						)
					)
					((== global235 10)
						(if (== global236 14)
							(global243 fromSqr: 22)
							(global243 toSqr: 17)
							(= global237 3)
						else
							(global243 fromSqr: 21)
							(global243 toSqr: 17)
							(= global237 4)
						)
					)
					((== global235 11)
						(if (== global236 15)
							(global243 fromSqr: 23)
							(global243 toSqr: 18)
							(= global237 5)
						else
							(global243 fromSqr: 24)
							(global243 toSqr: 19)
							(= global237 6)
						)
					)
					((== global235 12)
						(global243 fromSqr: 24)
						(global243 toSqr: 20)
						(= global237 7)
					)
					(else
						(global243 fromSqr: 22)
						(global243 toSqr: 18)
					)
				)
			)
			((== global249 2)
				(if (== global236 16)
					(if (== global235 11)
						(global243 fromSqr: 18)
						(global243 toSqr: 14)
					else
						(global243 fromSqr: 24)
						(global243 toSqr: 20)
						(= global237 35)
					)
				else
					(global243 fromSqr: 25)
					(global243 toSqr: 22)
				)
			)
			((== global249 3)
				(cond
					((== global237 1)
						(cond
							((== global235 12)
								(global243 fromSqr: 24)
								(global243 toSqr: 20)
								(= global237 10)
							)
							((== global235 10)
								(global243 fromSqr: 25)
								(global243 toSqr: 22)
								(= global237 11)
							)
							((== global235 11)
								(global243 fromSqr: 25)
								(global243 toSqr: 22)
								(= global237 12)
							)
							(else
								(global243 fromSqr: 26)
								(global243 toSqr: 22)
								(= global237 13)
							)
						)
					)
					((== global237 2)
						(global243 fromSqr: 24)
						(global243 toSqr: 19)
						(= global237 14)
					)
					((== global237 3)
						(global243 fromSqr: 17)
						(global243 toSqr: 13)
						(= global237 15)
					)
					((== global237 4)
						(cond
							((== global235 12)
								(global243 fromSqr: 24)
								(global243 toSqr: 19)
							)
							((== global235 11)
								(global243 fromSqr: 22)
								(global243 toSqr: 18)
							)
							((== global235 9)
								(global243 fromSqr: 24)
								(global243 toSqr: 20)
								(= global237 16)
							)
							(else
								(global243 fromSqr: 17)
								(global243 toSqr: 14)
							)
						)
					)
					((== global237 5)
						(global243 fromSqr: 27)
						(global243 toSqr: 23)
						(= global237 17)
					)
					((== global237 6)
						(cond
							((and (== global235 9) (== global236 13))
								(global243 fromSqr: 27)
								(global243 toSqr: 24)
								(= global237 18)
							)
							((or (== global235 9) (== global235 16))
								(global243 fromSqr: 22)
								(global243 toSqr: 17)
							)
							(else
								(global243 fromSqr: 22)
								(global243 toSqr: 18)
							)
						)
					)
					((== global237 7)
						(cond
							((and (== global235 10) (== global236 15))
								(global243 fromSqr: 23)
								(global243 toSqr: 18)
							)
							((== global235 8)
								(global243 fromSqr: 22)
								(global243 toSqr: 18)
							)
							(else
								(global243 fromSqr: 28)
								(global243 toSqr: 24)
							)
						)
					)
				)
			)
			((== global249 4)
				(if (== global237 35)
					(global243 fromSqr: 25)
					(global243 toSqr: 22)
				else
					(global243 fromSqr: 29)
					(global243 toSqr: 25)
				)
			)
			((== global249 5)
				(cond
					((== global237 10)
						(cond
							((== global235 8)
								(global243 fromSqr: 27)
								(global243 toSqr: 24)
							)
							((== global235 10)
								(global243 fromSqr: 25)
								(global243 toSqr: 22)
							)
							(else
								(global243 fromSqr: 26)
								(global243 toSqr: 22)
							)
						)
					)
					((== global237 11)
						(global243 fromSqr: 24)
						(global243 toSqr: 20)
					)
					((== global237 12)
						(if (== global236 9)
							(global243 fromSqr: 29)
							(global243 toSqr: 25)
						else
							(global243 fromSqr: 18)
							(global243 toSqr: 14)
						)
					)
					((== global237 13)
						(if (== global235 11)
							(global243 fromSqr: 31)
							(global243 toSqr: 26)
						else
							(global243 fromSqr: 24)
							(global243 toSqr: 20)
						)
					)
					((== global237 14)
						(global243 fromSqr: 25)
						(global243 toSqr: 22)
					)
					((== global237 15)
						(if
							(or
								(and (== global235 11) (== global236 15))
								(== global235 10)
							)
							(global243 fromSqr: 25)
							(global243 toSqr: 22)
						else
							(global243 fromSqr: 24)
							(global243 toSqr: 20)
						)
					)
					((== global237 16)
						(if (and (== global235 6) (== global236 9))
							(global243 fromSqr: 17)
							(global243 toSqr: 14)
						)
					)
					((== global237 17)
						(cond
							((== global235 9)
								(global243 fromSqr: 18)
								(global243 toSqr: 14)
							)
							((== global235 12)
								(global243 fromSqr: 24)
								(global243 toSqr: 19)
							)
							((== global236 8)
								(global243 fromSqr: 23)
								(global243 toSqr: 19)
							)
							((== global235 10)
								(global243 fromSqr: 22)
								(global243 toSqr: 17)
							)
						)
					)
					((== global237 18)
						(if (== global235 16)
							(global243 fromSqr: 31)
							(global243 toSqr: 27)
						else
							(global243 fromSqr: 22)
							(global243 toSqr: 18)
						)
					)
				)
			)
		)
	)
)

(instance gameScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global252 0)
				(= global181 0)
				(= global253 0)
				(= global250 0)
				(= global249 0)
				(= global235 0)
				(= global240 0)
				(= global241 0)
				(= global255 0)
				(= global243 (ScriptID 202 0)) ; root
				(= global242 0)
				(= global245 0)
				(= global246 0)
				(= global268 0)
				(= global267 0)
				(= local2 0)
				(= local3 0)
				(= global262 0)
				(= global260 0)
				(= local5 0)
				(= local6 0)
				(= global269 1)
				(= global270 1)
				(= global274 0)
				(= cycles 1)
			)
			(1
				(cond
					((and (== (global178 type:) 1) ((ScriptID 203 5) doit:)) ; lostGame
						(if (== global178 (ScriptID 200 7)) ; player2
							(gSong play: 803 setLoop: -1)
							(if (== global188 2)
								(Printf 201 0 ((ScriptID 200 6) playerName:)) ; "Congratulations %s. You win!", player1
							else
								(gChar1 say: (Random 36 38) 0 442)
							)
							((ScriptID 200 6) ; player1
								wins: (+ ((ScriptID 200 6) wins:) 1) ; player1
							)
							((ScriptID 200 7) ; player2
								losses: (+ ((ScriptID 200 7) losses:) 1) ; player2
							)
							(proc200_2)
						else
							(if (== global188 2)
								(Printf 201 0 ((ScriptID 200 7) playerName:)) ; "Congratulations %s. You win!", player2
							else
								(gSong play: 906 setLoop: 1)
								(gChar1 say: (Random 33 35) 0 443)
							)
							(Wait 1)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 100)
							((ScriptID 200 7) ; player2
								wins: (+ ((ScriptID 200 7) wins:) 1) ; player2
							)
							((ScriptID 200 6) ; player1
								losses: (+ ((ScriptID 200 6) losses:) 1) ; player1
							)
							(proc200_2)
						)
						((ScriptID 200 8) eachElementDo: #reset) ; squares
						((ScriptID 200 1) eachElementDo: #reset) ; pieces
						(= state 4)
						(self cue:)
					)
					((== (global178 type:) 2)
						(proc0_4)
						(if local5
							(= local5 0)
							(gChar1 say: (Random 30 32) 0 442)
							(if (== global270 2)
								(= global270 3)
							)
						else
							(if global273
								(= global273 0)
								(gSong play: 202 setLoop: 1)
							)
							(if (== global270 2)
								(= global270 3)
								(gChar1 say: (Random 24 26) 0 443 3)
							)
						)
						(gGame setCursor: 30)
						(= global247 (GetTime))
						(if (not ((ScriptID 202 0) alphaBeta:)) ; root
							((ScriptID 202 0) freeNodes: (ScriptID 202 0)) ; root, root
							((ScriptID 202 0) release:) ; root
							(gSong play: 906 setLoop: 1)
							(gChar1 say: (Random 33 35) 0 443)
							(Wait 1)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 20)
							(proc0_6)
							(Wait 100)
							((ScriptID 200 7) ; player2
								wins: (+ ((ScriptID 200 7) wins:) 1) ; player2
							)
							((ScriptID 200 6) ; player1
								losses: (+ ((ScriptID 200 6) losses:) 1) ; player1
							)
							(proc200_2)
							((ScriptID 200 8) eachElementDo: #reset) ; squares
							((ScriptID 200 1) eachElementDo: #reset) ; pieces
							(= state 4)
							(= ticks 1)
						)
					)
					(else
						(if global273
							(= global273 0)
							(gSong play: 202 setLoop: 1)
						)
						(cond
							((== global269 2)
								(= global269 3)
								(gChar1 say: (Random 27 29) 0 441 3)
							)
							(local6
								(= local6 0)
								(gChar1 smile:)
							)
						)
						(proc0_3)
						(if (== (global178 myColor:) -1)
							(gTheArrow setLoop: 2)
						else
							(gTheArrow setLoop: 3)
						)
					)
				)
			)
			(2
				(if global250
					(proc0_4)
					(global250 setPri: 15 sqrNum: 99 xStep: 14 yStep: 10)
					(if (== global266 200)
						(= local4 0)
						(gSound2 play: 904 setLoop: 1)
						(global250 setMotion: MoveTo 350 100 self)
					else
						(= local1 (Random 80 140))
						(= local0 (Random 15 50))
						(= local4 1)
						(gSound2 play: 204 setLoop: 1)
						(global250 setMotion: MoveToEndLoop local0 local1 self)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if global253
					(global253 stopUpd: setPri: 10)
				)
				(= local3 0)
				(if global250
					(if (== global266 200)
						(gSound play: 203)
					)
					(= temp0 (Random 1 3))
					(if (and (== (global178 type:) 1) (== temp0 3))
						(gChar1 frown:)
					)
					(= local3 global250)
					(if (and (== global266 250) local4)
						(splash init: self global250)
					)
					(global250 posn: 400 100 stopUpd: setPri: 10)
				)
				(= global250 0)
				(if global245
					(if (== (global178 type:) 2)
						(= local6 1)
						(= state 1)
						((ScriptID 202 0) compuMove:) ; root
					else
						(cond
							((and (== global188 2) (not global244))
								(proc0_3)
								(if (Print 201 1 #button {Y} 0 #button {N} 1 #at 5 80) ; "Jump Again?"
									(= cycles 1)
									(return)
								)
							)
							((not gModelessDialog)
								(Print 201 2 #at 10 100 #dispose) ; "Jump Again"
							)
						)
						(= local5 1)
						(if (== global266 200)
							(= state 1)
							(proc0_3)
						else
							(= state 0)
						)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(= global250 0)
				(= global245 0)
				(= state 0)
				(++ global249)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(switch (global178 type:)
					(1
						(cond
							((== global188 1)
								(gTheArrow setLoop: 3)
								(= global178 (ScriptID 200 6)) ; player1
								(if
									(or
										(== global266 200)
										(== local4 0)
										(not local3)
									)
									(= cycles 1)
								)
							)
							((== global178 (ScriptID 200 6)) ; player1
								(= global178 (ScriptID 200 7)) ; player2
								(if
									(or
										(== global266 200)
										(== local4 0)
										(not local3)
									)
									(gTheArrow setLoop: 2)
									(= cycles 1)
								)
							)
							(else
								(= global178 (ScriptID 200 6)) ; player1
								(if
									(or
										(== global266 200)
										(== local4 0)
										(not local3)
									)
									(gTheArrow setLoop: 3)
									(= cycles 1)
								)
							)
						)
					)
					(2
						((ScriptID 202 0) freeNodes: (ScriptID 202 0)) ; root, root
						((ScriptID 202 0) release:) ; root
						(= global178 (ScriptID 200 7)) ; player2
						(if (or (== global266 200) (== local4 0) (not local3))
							(gTheArrow setLoop: 2)
							(= cycles 1)
						)
					)
				)
			)
			(5
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance tmp_out of File ; UNUSED
	(properties
		name {tmp.out}
	)

	(method (doit &tmp [temp0 80])
		(Format ; "%3d%3d%3d%3d"
			@temp0
			201
			3
			global235
			global236
			(global243 fromSqr:)
			(global243 toSqr:)
		)
		(self open: 0 writeString: @temp0 close:)
	)
)

(instance checkers_opt of File
	(properties
		name {checkers.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString: (Format @temp0 201 4 global244 global266) ; "%d%3d"
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global244 (ReadNumber (self readString: @temp20 2)))
				(if (!= global188 2)
					(= global244 1)
				)
				(if
					(and
						(!=
							(= global266
								(ReadNumber (self readString: @temp20 4))
							)
							200
						)
						(!= global266 250)
					)
					(= global266 200)
				)
				(self close:)
				(return 0)
			)
			(else
				(= global244 1)
				(= global266 200)
				(return 0)
			)
		)
	)
)

(instance splash of Prop
	(properties)

	(method (init param1 param2)
		(gSound2 stop:)
		(gSound2 play: 903 setLoop: 1)
		(= local2 param2)
		(local2 posn: 400 100)
		(if (== (global178 myColor:) -1)
			(local2 loop: 2 cel: 0)
		else
			(local2 loop: 3 cel: 0)
		)
		(self
			view: 275 species 14
			posn: local0 local1
			setLoop: 0
			ignoreActors:
			show:
			cycleSpeed: 5
			setCycle: End self
		)
		(proc0_1)
		(super init: &rest)
	)

	(method (cue)
		(self hide: cel: 0 forceUpd:)
		(proc0_1)
		(local2 setMotion: 0)
		(gameScript cue:)
	)
)

