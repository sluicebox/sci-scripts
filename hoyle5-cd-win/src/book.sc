;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1201)
(include sci.sh)
(use Main)
(use checkers)
(use Str)
(use IconBar)
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
	[local7 17] = [200 185 170 155 140 125 110 100 90 80 70 60 50 40 30 20 10]
	[local24 27] = [165 155 145 135 125 115 105 95 85 75 65 55 45 35 25 15 5 0 0 0 0 0 0 0 0 0 0]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp0 (+ (GetTime) param1))
	(while (> temp0 (GetTime))
	)
)

(instance book of Code
	(properties)

	(method (doit &tmp temp0)
		(global809 capSqr: 0)
		(cond
			((== global815 0)
				(global809 fromSqr: 22)
				(global809 toSqr: 18)
			)
			((== global815 1)
				(cond
					((== global801 9)
						(if (== global802 13)
							(global809 fromSqr: 22)
							(global809 toSqr: 18)
							(= global803 1)
						else
							(== global802 14)
							(global809 fromSqr: 22)
							(global809 toSqr: 18)
							(= global803 2)
						)
					)
					((== global801 10)
						(if (== global802 14)
							(global809 fromSqr: 22)
							(global809 toSqr: 17)
							(= global803 3)
						else
							(global809 fromSqr: 21)
							(global809 toSqr: 17)
							(= global803 4)
						)
					)
					((== global801 11)
						(if (== global802 15)
							(global809 fromSqr: 23)
							(global809 toSqr: 18)
							(= global803 5)
						else
							(global809 fromSqr: 24)
							(global809 toSqr: 19)
							(= global803 6)
						)
					)
					((== global801 12)
						(global809 fromSqr: 24)
						(global809 toSqr: 20)
						(= global803 7)
					)
					(else
						(global809 fromSqr: 22)
						(global809 toSqr: 18)
					)
				)
			)
			((== global815 2)
				(if (== global802 16)
					(if (== global801 11)
						(global809 fromSqr: 18)
						(global809 toSqr: 14)
					else
						(global809 fromSqr: 24)
						(global809 toSqr: 20)
						(= global803 35)
					)
				else
					(global809 fromSqr: 25)
					(global809 toSqr: 22)
				)
			)
			((== global815 3)
				(cond
					((== global803 1)
						(cond
							((== global801 12)
								(global809 fromSqr: 24)
								(global809 toSqr: 20)
								(= global803 10)
							)
							((== global801 10)
								(global809 fromSqr: 25)
								(global809 toSqr: 22)
								(= global803 11)
							)
							((== global801 11)
								(global809 fromSqr: 25)
								(global809 toSqr: 22)
								(= global803 12)
							)
							(else
								(global809 fromSqr: 26)
								(global809 toSqr: 22)
								(= global803 13)
							)
						)
					)
					((== global803 2)
						(global809 fromSqr: 24)
						(global809 toSqr: 19)
						(= global803 14)
					)
					((== global803 3)
						(global809 fromSqr: 17)
						(global809 toSqr: 13)
						(= global803 15)
					)
					((== global803 4)
						(cond
							((== global801 12)
								(global809 fromSqr: 24)
								(global809 toSqr: 19)
							)
							((== global801 11)
								(global809 fromSqr: 22)
								(global809 toSqr: 18)
							)
							((== global801 9)
								(global809 fromSqr: 24)
								(global809 toSqr: 20)
								(= global803 16)
							)
							(else
								(global809 fromSqr: 17)
								(global809 toSqr: 14)
							)
						)
					)
					((== global803 5)
						(global809 fromSqr: 27)
						(global809 toSqr: 23)
						(= global803 17)
					)
					((== global803 6)
						(cond
							((and (== global801 9) (== global802 13))
								(global809 fromSqr: 27)
								(global809 toSqr: 24)
								(= global803 18)
							)
							((or (== global801 9) (== global801 16))
								(global809 fromSqr: 22)
								(global809 toSqr: 17)
							)
							(else
								(global809 fromSqr: 22)
								(global809 toSqr: 18)
							)
						)
					)
					((== global803 7)
						(cond
							((and (== global801 10) (== global802 15))
								(global809 fromSqr: 23)
								(global809 toSqr: 18)
							)
							((== global801 8)
								(global809 fromSqr: 22)
								(global809 toSqr: 18)
							)
							(else
								(global809 fromSqr: 28)
								(global809 toSqr: 24)
							)
						)
					)
				)
			)
			((== global815 4)
				(if (== global803 35)
					(global809 fromSqr: 25)
					(global809 toSqr: 22)
				else
					(global809 fromSqr: 29)
					(global809 toSqr: 25)
				)
			)
			((== global815 5)
				(cond
					((== global803 10)
						(cond
							((== global801 8)
								(global809 fromSqr: 27)
								(global809 toSqr: 24)
							)
							((== global801 10)
								(global809 fromSqr: 25)
								(global809 toSqr: 22)
							)
							(else
								(global809 fromSqr: 26)
								(global809 toSqr: 22)
							)
						)
					)
					((== global803 11)
						(global809 fromSqr: 24)
						(global809 toSqr: 20)
					)
					((== global803 12)
						(if (== global802 9)
							(global809 fromSqr: 29)
							(global809 toSqr: 25)
						else
							(global809 fromSqr: 18)
							(global809 toSqr: 14)
						)
					)
					((== global803 13)
						(if (== global801 11)
							(global809 fromSqr: 31)
							(global809 toSqr: 26)
						else
							(global809 fromSqr: 24)
							(global809 toSqr: 20)
						)
					)
					((== global803 14)
						(global809 fromSqr: 25)
						(global809 toSqr: 22)
					)
					((== global803 15)
						(if
							(or
								(and (== global801 11) (== global802 15))
								(== global801 10)
							)
							(global809 fromSqr: 25)
							(global809 toSqr: 22)
						else
							(global809 fromSqr: 24)
							(global809 toSqr: 20)
						)
					)
					((== global803 16)
						(if (and (== global801 6) (== global802 9))
							(global809 fromSqr: 17)
							(global809 toSqr: 14)
						)
					)
					((== global803 17)
						(cond
							((== global801 9)
								(global809 fromSqr: 18)
								(global809 toSqr: 14)
							)
							((== global801 12)
								(global809 fromSqr: 24)
								(global809 toSqr: 19)
							)
							((== global802 8)
								(global809 fromSqr: 23)
								(global809 toSqr: 19)
							)
							((== global801 10)
								(global809 fromSqr: 22)
								(global809 toSqr: 17)
							)
						)
					)
					((== global803 18)
						(if (== global801 16)
							(global809 fromSqr: 31)
							(global809 toSqr: 27)
						else
							(global809 fromSqr: 22)
							(global809 toSqr: 18)
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
				(= global818 0)
				(= global189 0)
				(= global819 0)
				(= global816 0)
				(= global815 0)
				(= global801 0)
				(= global806 0)
				(= global807 0)
				(= global821 0)
				(= global809 (ScriptID 1202 0)) ; root
				(= global808 0)
				(= global811 0)
				(= global812 0)
				(= global834 0)
				(= global833 0)
				(= local2 0)
				(= local3 0)
				(= global828 0)
				(= global826 0)
				(= local5 0)
				(= local6 0)
				(= global835 1)
				(= global836 1)
				(= global840 0)
				(= cycles 1)
			)
			(1
				(cond
					((and (== (global800 type:) 0) ((ScriptID 1203 5) doit:)) ; lostGame
						(if (== global800 (ScriptID 1200 7)) ; player2
							(gChar1 sayReg: 1000 2 64 0 (Random 1 2))
							((ScriptID 1200 6) ; player1
								wins: (+ ((ScriptID 1200 6) wins:) 1) ; player1
							)
							((ScriptID 1200 7) ; player2
								losses: (+ ((ScriptID 1200 7) losses:) 1) ; player2
							)
						else
							(if (> gAttitudeSetting 1)
								(= global920 1)
								(gChar1 say: 15 15 179 0 (Random 1 7))
							else
								(gChar1 sayReg: 1000 2 63 0 (Random 1 2))
							)
							((ScriptID 1200 7) ; player2
								wins: (+ ((ScriptID 1200 7) wins:) 1) ; player2
							)
							((ScriptID 1200 6) ; player1
								losses: (+ ((ScriptID 1200 6) losses:) 1) ; player1
							)
						)
						(proc1200_2)
						(= global748 0)
						((ScriptID 930 0) init: 1270) ; yesNo
						(DisposeScript 930)
						(cond
							(global748
								((ScriptID 1200 8) eachElementDo: #reset) ; squares
								((ScriptID 1200 1) eachElementDo: #reset) ; pieces
								(= state 4)
								(self cue:)
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
					((== (global800 type:) 1)
						(DisableCursor)
						(if local5
							(= local5 0)
							(if (== global836 2)
								(= global836 3)
							)
						else
							(if global839
								(= global839 0)
							)
							(if (== global836 2)
								(= global836 3)
							)
						)
						(localproc_0 (proc0_14))
						(gGame setCursor: 997)
						(= global813 (GetTime))
						(if (not ((ScriptID 1202 0) alphaBeta:)) ; root
							((ScriptID 1202 0) freeNodes: (ScriptID 1202 0)) ; root, root
							((ScriptID 1202 0) release:) ; root
							((ScriptID 1200 7) ; player2
								wins: (+ ((ScriptID 1200 7) wins:) 1) ; player2
							)
							((ScriptID 1200 6) ; player1
								losses: (+ ((ScriptID 1200 6) losses:) 1) ; player1
							)
							(proc1200_2)
							(= global748 0)
							((ScriptID 930 0) init: 1270) ; yesNo
							(DisposeScript 930)
							(cond
								(global748
									((ScriptID 1200 8) eachElementDo: #reset) ; squares
									((ScriptID 1200 1) eachElementDo: #reset) ; pieces
									(= state 4)
									(= ticks 1)
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
					)
					(else
						(if global839
							(= global839 0)
						)
						(cond
							((== global835 2)
								(= global835 3)
							)
							(local6
								(= local6 0)
								(gChar1 smile:)
							)
						)
						(EnableCursor)
						(IconBar enable:)
						(if (== (global800 myColor:) -1)
							(gTheArrow setLoop: 3)
						else
							(gTheArrow setLoop: 1)
						)
					)
				)
			)
			(2
				(if global816
					(DisableCursor)
					(global816
						setPri: 15
						sqrNum: 99
						xStep: [local7 global898]
						yStep: [local24 global898]
						nsLeft: 0
						nsRight: 0
						nsTop: 0
						nsBottom: 0
					)
					(if (== global832 200)
						(= local4 0)
						(global816 setPri: 500)
						(global816 setSpeed: global898)
						(global816 setMotion: MoveTo 700 240 self)
					else
						(= local1 (Random 192 336))
						(= local0 (Random 30 100))
						(= local4 0)
						(gSound play: 804 setLoop: 1)
						(if (== (global800 myColor:) -1)
							(global816 setLoop: 8 cel: 0)
						else
							(global816 setLoop: 9 cel: 0)
						)
						(global816 setSpeed: global898)
						(global816 setCycle: End self)
						(IconBar disable:)
						(DisableCursor)
					)
					(if (Random 0 1)
						(if (== (global800 type:) 1)
							(gChar1 sayPN: 1000 2 82 0 (Random 1 5))
						else
							(gChar1 sayPN: 1000 2 83 0 (Random 1 5))
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if global819
					(global819 setPri: 10)
				)
				(= local3 0)
				(if global816
					(if (== global832 200)
						(gSound play: 803)
					)
					(= temp0 (Random 1 3))
					(if (and (== (global800 type:) 0) (== temp0 3))
						(gChar1 frown:)
					)
					(= local3 global816)
					(global816 posn: 800 240 setPri: 10)
				)
				(= global816 0)
				(if global811
					(if (== (global800 type:) 1)
						(= local6 1)
						(= state 1)
						((ScriptID 1202 0) compuMove:) ; root
					else
						(= local5 1)
						(= state 1)
						(EnableCursor)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(= global816 0)
				(= global811 0)
				(= state 0)
				(++ global815)
				(switch (global800 type:)
					(0
						(cond
							((== global799 1)
								(gTheArrow setLoop: 1)
								(= global800 (ScriptID 1200 6)) ; player1
								(if
									(or
										(== global832 200)
										(== local4 0)
										(not local3)
									)
									(= cycles 1)
								)
							)
							((== global800 (ScriptID 1200 6)) ; player1
								(= global800 (ScriptID 1200 7)) ; player2
								(if
									(or
										(== global832 200)
										(== local4 0)
										(not local3)
									)
									(gTheArrow setLoop: 3)
									(= cycles 1)
								)
							)
							(else
								(= global800 (ScriptID 1200 6)) ; player1
								(if
									(or
										(== global832 200)
										(== local4 0)
										(not local3)
									)
									(gTheArrow setLoop: 1)
									(= cycles 1)
								)
							)
						)
					)
					(1
						((ScriptID 1202 0) freeNodes: (ScriptID 1202 0)) ; root, root
						((ScriptID 1202 0) release:) ; root
						(= global800 (ScriptID 1200 7)) ; player2
						(if (or (== global832 200) (== local4 0) (not local3))
							(gTheArrow setLoop: 3)
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

	(method (doit &tmp temp0 [temp1 79])
		(temp0 ; UNINIT
			format:
				{%3d%3d%3d%3d\r\n}
				global801
				global802
				(global809 fromSqr:)
				(global809 toSqr:)
		)
		(self open: 0 writeString: temp0 close:) ; UNINIT
	)
)

(instance checkers_opt of File
	(properties
		name {checkers.opt}
	)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(temp0
								format:
									{%d%3d%d%d%d}
									global810
									global832
									global385
									global878
									(proc1200_10)
							)
						close:
					)
					(temp0 dispose:)
					(temp1 dispose:)
					(return 1)
				else
					(temp0 dispose:)
					(temp1 dispose:)
					(return 0)
				)
			)
			((self open: 1)
				(self readString: temp1 2)
				(= global810 (temp1 asInteger:))
				(if (!= global799 2)
					(= global810 1)
				)
				(self readString: temp1 4)
				(if
					(and
						(!= (= global832 (temp1 asInteger:)) 200)
						(!= global832 250)
					)
					(= global832 200)
				)
				(self readString: temp1 2)
				(= global385 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global878 (temp1 asInteger:))
				(self readString: temp1 2)
				(proc1200_10 (temp1 asInteger:))
				(temp0 dispose:)
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= global810 1)
				(= global832 200)
				(= global385 7)
				(= global878 0)
				(proc1200_10 0)
				(temp0 dispose:)
				(temp1 dispose:)
				(return 0)
			)
		)
	)
)

(instance splash of Prop
	(properties)

	(method (init param1 param2)
		(gSound2 stop:)
		(gSound2 play: 95 setLoop: 1)
		(= local2 param2)
		(local2 posn: 400 100)
		(if (== (global800 myColor:) -1)
			(local2 loop: 2 cel: 0)
		else
			(local2 loop: 3 cel: 0)
		)
		(self
			view: 1275
			posn: local0 local1
			setLoop: 0
			ignoreActors:
			show:
			cycleSpeed: 5
			setCycle: End self
		)
		(RedrawCast)
		(super init: &rest)
	)

	(method (cue)
		(self hide: cel: 0)
		(RedrawCast)
		(local2 setMotion: 0)
		(gameScript cue:)
	)
)

