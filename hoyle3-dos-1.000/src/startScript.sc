;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use Interface)
(use pachisi)
(use PiecesAtHome)
(use System)

(public
	startScript 2
	diceThrowScript 3
	pachisiScript 4
	playScript 5
	bluePawn1 6
	bluePawn2 7
	bluePawn3 8
	bluePawn4 9
	redPawn1 10
	redPawn2 11
	redPawn3 12
	redPawn4 13
	greenPawn1 14
	greenPawn2 15
	greenPawn3 16
	greenPawn4 17
	yellowPawn1 18
	yellowPawn2 19
	yellowPawn3 20
	yellowPawn4 21
	computerScript 22
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 &tmp temp0 temp1 [temp2 25])
	(cond
		((== (param1 type:) 2)
			((param1 character:) say: (Random 21 23) 0 442 2)
		)
		((== global188 1)
			(Characters say: (Random 18 20) 0 443 2)
		)
		(else
			(Characters
				say: (Format @global550 402 0 (param1 playerName:)) -32768 443 2 ; "%s goes first."
			)
		)
	)
	((ScriptID 400 7) add: param1) ; pachisiPlayerList
	(= temp0 (param1 color:))
	(for ((= temp1 1)) (<= temp1 3) ((++ temp1))
		(if [global407 (= temp0 (+ (mod temp0 4) 1))]
			(cond
				((== temp0 ((ScriptID 400 3) color:)) ; player1
					((ScriptID 400 7) add: (ScriptID 400 3)) ; pachisiPlayerList, player1
				)
				((== temp0 ((ScriptID 400 4) color:)) ; player2
					((ScriptID 400 7) add: (ScriptID 400 4)) ; pachisiPlayerList, player2
				)
				((== temp0 ((ScriptID 400 5) color:)) ; player3
					((ScriptID 400 7) add: (ScriptID 400 5)) ; pachisiPlayerList, player3
				)
				((== temp0 ((ScriptID 400 6) color:)) ; player4
					((ScriptID 400 7) add: (ScriptID 400 6)) ; pachisiPlayerList, player4
				)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(gSong play: 806)
	(= temp2 ((ScriptID 400 7) size:)) ; pachisiPlayerList
	(for ((= temp0 0)) (< temp0 temp2) ((++ temp0))
		(= temp1 ((ScriptID 400 7) at: temp0)) ; pachisiPlayerList
		(if (== (temp1 type:) 1)
			(gGame setCursor: 999 1)
			(= temp3 (Print 402 1 #button {Yes} 0 #button {No} 1)) ; "Would you like to continue the game until all have finished?"
			(break)
		)
	)
	(gSong fade:)
	(return temp3)
)

(instance bluePawn1 of PachisiPiece
	(properties
		loop 2
		hiLoop 2
		color 1
	)
)

(instance bluePawn2 of PachisiPiece
	(properties
		loop 2
		hiLoop 2
		color 1
	)
)

(instance bluePawn3 of PachisiPiece
	(properties
		loop 2
		hiLoop 2
		color 1
	)
)

(instance bluePawn4 of PachisiPiece
	(properties
		loop 2
		hiLoop 2
		color 1
	)
)

(instance redPawn1 of PachisiPiece
	(properties
		loop 1
		hiLoop 1
		color 2
	)
)

(instance redPawn2 of PachisiPiece
	(properties
		loop 1
		hiLoop 1
		color 2
	)
)

(instance redPawn3 of PachisiPiece
	(properties
		loop 1
		hiLoop 1
		color 2
	)
)

(instance redPawn4 of PachisiPiece
	(properties
		loop 1
		hiLoop 1
		color 2
	)
)

(instance greenPawn1 of PachisiPiece
	(properties
		loop 3
		cel 0
		hiLoop 3
		hiCel 1
		color 3
	)
)

(instance greenPawn2 of PachisiPiece
	(properties
		loop 3
		cel 0
		hiLoop 3
		hiCel 1
		color 3
	)
)

(instance greenPawn3 of PachisiPiece
	(properties
		loop 3
		cel 0
		hiLoop 3
		hiCel 1
		color 3
	)
)

(instance greenPawn4 of PachisiPiece
	(properties
		loop 3
		cel 0
		hiLoop 3
		hiCel 1
		color 3
	)
)

(instance yellowPawn1 of PachisiPiece
	(properties
		hiLoop 0
		color 4
	)
)

(instance yellowPawn2 of PachisiPiece
	(properties
		hiLoop 0
		color 4
	)
)

(instance yellowPawn3 of PachisiPiece
	(properties
		hiLoop 0
		color 4
	)
)

(instance yellowPawn4 of PachisiPiece
	(properties
		hiLoop 0
		color 4
	)
)

(instance startScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global178 (ScriptID 400 3)) ; player1
				(= global412 (proc400_1 0))
				(= cycles 1)
			)
			(1
				(if global417
					(Print 402 2) ; "Click to start Pachisi."
				)
				(= local0 0)
				((ScriptID 400 8) add: (global414 at: 0) (global414 at: 1)) ; pachisiKMList
				(if (!= (global178 type:) 0)
					(startCode doit: self)
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 1)
			)
			(3
				(= global178 (ScriptID 400 4)) ; player2
				(if (!= (global178 type:) 0)
					(startCode doit: self)
				else
					(= cycles 1)
				)
			)
			(4
				(= cycles 1)
			)
			(5
				(= global178 (ScriptID 400 5)) ; player3
				(if (!= (global178 type:) 0)
					(startCode doit: self)
				else
					(= cycles 1)
				)
			)
			(6
				(= cycles 1)
			)
			(7
				(= global178 (ScriptID 400 6)) ; player4
				(if (!= (global178 type:) 0)
					(startCode doit: self)
				else
					(= cycles 1)
				)
			)
			(8
				(= cycles 1)
			)
			(9
				((ScriptID 400 8) delete: (global414 at: 0) (global414 at: 1)) ; pachisiKMList
				(localproc_0 local1)
				((local1 start:) becomeActive:)
				(self dispose:)
			)
		)
	)
)

(instance firstRollScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 25])
		(switch (= state newState)
			(0
				(if
					(or
						(and (== local0 25) (== global414 TheShells))
						(and (>= local0 12) (== global414 TheDice))
					)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(global414 eachElementDo: #goToStart self)
			)
			(2
				(if (global414 firstTrue: #mover)
					(-- state)
				)
				(= cycles 5)
			)
			(3
				(global414 eachElementDo: #stopUpd)
				(= cycles 2)
			)
			(4
				(if (== (global178 type:) 2)
					(if (== global178 (ScriptID 400 3)) ; player1
						((global178 character:)
							say: {I roll to see who goes first.}
						)
					else
						((global178 character:) say: (Random 60 62))
					)
				else
					(Format @temp0 402 3 (global178 playerName:)) ; "%s rolls to see who goes first."
					(Characters say: @temp0 -32768)
				)
				(= cycles 1)
			)
			(5
				(= global416 1)
				(if (!= (global178 type:) 2)
					(proc0_3)
					(= global413 1)
				else
					(= seconds 2)
				)
			)
			(6
				(if (global414 firstTrue: #mover)
					(-- state)
				)
				(= cycles 5)
			)
			(7
				(proc0_4)
				(= global416 0)
				(= global413 0)
				(= cycles 1)
			)
			(8
				(gSound play: 100)
				(global414 eachElementDo: #pickup)
				(= global181 0)
				(= seconds 1)
			)
			(9
				(self setScript: diceThrowScript self)
			)
			(10
				(= seconds 2)
			)
			(11
				(if (> (global414 total:) local0)
					(= local0 (global414 total:))
					(= local1 global178)
				)
				(self dispose:)
			)
		)
	)
)

(instance diceThrowScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global507 0)
				(= cycles 1)
			)
			(1
				(for ((= temp0 0)) ((global414 at: temp0) rolling:) ((++ temp0))
				)
				(++ global507)
				((global414 at: temp0) throw:)
				(if (== global507 global509)
					(= global508 (global414 at: temp0))
				)
				(= cycles 10)
			)
			(2
				(if (!= global507 global509)
					(-= state 2)
					(= cycles (Random 1 10))
				)
				((ScriptID 400 10) play:) ; rollSound
			)
			(3
				(global414 eachElementDo: #rolling 0 tally:)
				(self dispose:)
			)
		)
	)
)

(instance pachisiScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global178 ((ScriptID 400 7) at: 0)) ; pachisiPlayerList
				(if (!= 4 (global178 howManyHome:))
					(playCode doit: self)
				else
					(= cycles 1)
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(= global178 ((ScriptID 400 7) at: 1)) ; pachisiPlayerList
				(if (!= 4 (global178 howManyHome:))
					(playCode doit: self)
				else
					(= cycles 1)
				)
			)
			(3
				(= cycles 5)
			)
			(4
				(if
					(and
						(= global178 ((ScriptID 400 7) at: 2)) ; pachisiPlayerList
						(!= 4 (global178 howManyHome:))
					)
					(playCode doit: self)
				else
					(= cycles 1)
				)
			)
			(5
				(= cycles 5)
			)
			(6
				(if
					(and
						(= global178 ((ScriptID 400 7) at: 3)) ; pachisiPlayerList
						(!= 4 (global178 howManyHome:))
					)
					(playCode doit: self)
				else
					(= cycles 1)
				)
			)
			(7
				(= cycles 5)
			)
			(8
				(self init:)
			)
		)
	)
)

(instance playScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 28] temp28)
		(switch (= state newState)
			(0
				(global414
					eachElementDo: #taken 0
					eachElementDo: #goToStart self
				)
			)
			(1
				(if (global414 firstTrue: #mover)
					(-- state)
				)
				(= cycles 5)
			)
			(2
				(global414 eachElementDo: #stopUpd)
				(= global416 1)
				(if (!= (global178 type:) 2)
					((ScriptID 400 8) add: (global414 at: 0) (global414 at: 1)) ; pachisiKMList
					(proc0_3)
					(= global413 1)
				else
					(= seconds 1)
				)
			)
			(3
				(if (global414 firstTrue: #mover)
					(-- state)
				)
				(= cycles 5)
			)
			(4
				(proc0_4)
				(= global413 0)
				(= global416 0)
				(= cycles 1)
			)
			(5
				(if (and (== global414 TheDice) (== (global178 type:) 2))
					(global414 eachElementDo: #hilite)
				)
				(= cycles 10)
			)
			(6
				(if (and (== global414 TheDice) (== (global178 type:) 2))
					(global414 eachElementDo: #dim)
				)
				(= cycles 10)
			)
			(7
				(gSound play: 100)
				(global414 eachElementDo: #pickup)
				(= global181 0)
				(Indicator show: stopUpd:)
				(= seconds 1)
			)
			(8
				(self setScript: diceThrowScript self)
			)
			(9
				(= cycles 1)
			)
			(10
				(global414 eachElementDo: #stopUpd)
				(if (!= (global414 doubles:) 3)
					(= global401 0)
					(if (global178 findMove: 1)
						(if (!= (global178 type:) 2)
							((ScriptID 400 8) ; pachisiKMList
								delete: (global414 at: 0) (global414 at: 1)
							)
							(proc0_3)
						else
							(self setScript: computerScript self)
						)
					else
						(gSound2 play: 902)
						(if (== (global178 type:) 2)
							((global178 character:) say: (Random 57 59) 0 443 2)
						else
							(Characters say: (Random 54 56) -32768 441 2)
						)
						(= cycles 1)
					)
				else
					(if (== (global178 type:) 2)
						((global178 character:) say: (Random 36 38) 0 443 2)
					else
						(Characters say: (Random 33 35) -32768 442 2)
					)
					(global414 doubles: 0)
					(= cycles 1)
				)
			)
			(11
				(proc0_4)
				(= temp28 (== (global178 howManyHome:) 4))
				(global414 eachElementDo: #hilite 1)
				(if (or (not (global414 doubles:)) temp28)
					(if temp28
						(if (== (++ global415) 1)
							(gSound priority: 15 play: 906)
							(cond
								((== (global178 type:) 2)
									((global178 character:)
										say: (Random 51 53) 0 442 -32768
									)
								)
								(global189
									(Characters
										say: (Random 48 50) -32768 443 -32768
									)
								)
								(else
									(Format @temp0 402 4 (global178 playerName:)) ; "Congratulations, %s, you have won."
									(Print @temp0)
								)
							)
						)
						(if
							(or
								(and (== global415 1) (localproc_1))
								(== global415 ((ScriptID 400 7) size:)) ; pachisiPlayerList
							)
							(= gNewRoomNum gCurRoomNum)
							(= gCurRoomNum 0)
							(= global417 1)
						)
					)
					(self dispose:)
				else
					(Indicator hide:)
					(self init:)
				)
			)
		)
	)
)

(instance computerScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 25])
		(switch (= state newState)
			(0
				(self
					register:
						(if (== global414 TheDice)
							(global178 findBestDiceMove:)
						else
							(global178 findBestMove: (TheShells total:) 0 0)
						)
				)
				(if register
					((register piece:) changeSquare: (register aSquare:))
				else
					(self state: (+ state 2))
					(= cycles 1)
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(cond
					((= temp0 (register child:))
						((temp0 piece:) changeSquare: (temp0 aSquare:))
					)
					((and (== global414 TheDice) (== (global178 skill:) 0))
						(register dispose:)
						(self state: (- state 3))
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if register
					(register dispose:)
				)
				(if
					(and
						(not (global414 allTrue: 663))
						(!= (global178 howManyHome:) 4)
					)
					(gSound2 play: 902)
					((global178 character:) say: (Random 57 59) 0 443 2)
				)
				(self dispose:)
			)
		)
	)
)

(instance playCode of Code
	(properties)

	(method (doit param1)
		(if global181
			(global181 dim:)
			(= global181 0)
		)
		(global414 doubles: 0)
		(Indicator changePlayer: global178)
		(param1 setScript: playScript param1)
	)
)

(instance startCode of Code
	(properties)

	(method (doit param1)
		(param1 setScript: firstRollScript param1)
	)
)

