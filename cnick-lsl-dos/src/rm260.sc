;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use Interface)
(use Blk)
(use LoadMany)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0
	local1
	local2
	[local3 80]
	local83
	[local84 7]
	local91
	local92
	local93
)

(procedure (localproc_0)
	(if local1
		(Display 260 7 dsRESTOREPIXELS local1)
	)
	(if local2
		(Display 260 7 dsRESTOREPIXELS local2)
	)
	(= global158 local83)
	(gLongSong2 number: 266 loop: 1 play:)
	(if (> local83 0)
		(Printf 260 26 local83) ; "You pocket your $%d.00 and wish you had won more."
	else
		(Print 260 6) ; "You sadly walk away, your turned-out pockets telling everyone of your gambling "problem.""
	)
	(gCurRoom newRoom: 100)
)

(procedure (localproc_1 param1)
	(if (> param1 0)
		(if (< (+ local83 param1) 0)
			(= local83 10000)
		else
			(+= local83 param1)
		)
	else
		(= local83 10000)
	)
	(if (< local83 0)
		(= local83 0)
	)
	(if (> local83 10000)
		(= local83 10000)
		(= local92 1)
	)
	(Display 260 7 dsRESTOREPIXELS local2)
	(= local2
		(Display (Format @local3 260 1 local83) dsCOORD 165 34 dsCOLOR global130 dsSAVEPIXELS) ; "%5d"
	)
)

(procedure (localproc_2 param1)
	(gLongSong3 number: 260 play:)
	(param1 setCel: 1)
	(Animate (gCast elements:) 0)
	(param1 setCel: 0)
	(Animate (gCast elements:) 0)
	(param1 stopUpd:)
)

(procedure (localproc_3 &tmp temp0)
	(if (mod (= temp0 (/ (+ local0 100) 50)) 2)
		(return (- temp0 1))
	else
		(return temp0)
	)
)

(instance rm260 of Rm
	(properties
		picture 260
		style 10
	)

	(method (init &tmp temp0)
		(Load rsSCRIPT 941)
		(Load rsVIEW 260)
		(LoadMany rsSOUND 260 261 262 263 264 265 266)
		(gLongSong2 loop: 1 vol: 127 flags: 1)
		(gLongSong3 loop: 1 vol: 127 flags: 1)
		(gEgo init: z: 1000 hide:)
		(super init:)
		(playButton init: stopUpd:)
		(increaseButton init: stopUpd:)
		(decreaseButton init: stopUpd:)
		(oddsButton init: stopUpd:)
		(cashOutButton init: stopUpd:)
		(gTheIconBar enable: disable: 4 5)
		(wheelLeft cycleSpeed: 0 init: stopUpd:)
		(wheelCenter cycleSpeed: 0 init: stopUpd:)
		(wheelRight cycleSpeed: 0 init: stopUpd:)
		(= local0 10)
		(= local83 global158)
		(= local1
			(Display (Format @local3 260 0 local0) dsCOORD 105 36 dsCOLOR global130 dsSAVEPIXELS) ; "%d"
		)
		(= local2
			(Display (Format @local3 260 1 local83) dsCOORD 165 34 dsCOLOR global130 dsSAVEPIXELS) ; "%5d"
		)
		(leftTank init:)
		(rightTank init:)
		(for ((= temp0 0)) (< temp0 (+ 4 gHowFast)) ((++ temp0))
			((circle new:)
				moveSpeed: gHowFast
				init:
				cel: temp0
				setPri: temp0
				x: (Random 1 36)
				y: (Random 71 249)
				observeBlocks: leftTank
				setMotion: Wander
			)
		)
		(for ((= temp0 12)) (> temp0 (- 9 gHowFast)) ((-- temp0))
			((circle new:)
				moveSpeed: gHowFast
				init:
				cel: temp0
				setPri: temp0
				x: (Random 302 318)
				y: (Random 66 249)
				observeBlocks: rightTank
				setMotion: Wander
			)
		)
		(stripe0 cycleSpeed: gHowFast setPri: 14 init: stopUpd:)
		(stripe1 cycleSpeed: gHowFast setPri: 14 init: stopUpd:)
		(stripe2 cycleSpeed: gHowFast setPri: 14 init: stopUpd:)
		(stripe3 cycleSpeed: gHowFast setPri: 14 init: stopUpd:)
		(stripe4 cycleSpeed: gHowFast setPri: 14 init: stopUpd:)
		(self setScript: waitASecScript self)
	)

	(method (newRoom)
		(super newRoom: &rest)
		(proc0_32 gWaitCursor)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 2) ; "The numbers at the top of the slot machine indicate the size of your current bet and the total amount of credit you have in the machine."
				(Print 260 3) ; "For help, just Look at the various buttons."
			)
			(2
				(Print 260 4) ; "Click on a button instead of where you just clicked."
			)
			(else 0)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(= local1
				(Display
					(Format @local3 260 0 local0) ; "%d"
					dsCOORD
					105
					36
					dsCOLOR
					global130
					dsSAVEPIXELS
				)
			)
			(= local2
				(Display
					(Format @local3 260 1 local83) ; "%5d"
					dsCOORD
					165
					34
					dsCOLOR
					global130
					dsSAVEPIXELS
				)
			)
		)
		(cond
			(script 0)
			((>= local83 10000)
				(proc0_2)
				(gCurRoom setScript: sWin)
			)
			((gEgo mover:)
				(localproc_0)
			)
			((and (< local83 10) (not (gCurRoom script:)) (not (proc0_6 104)))
				(proc0_7 104)
				(if (== local83 1)
					(= local93 {dollar})
				else
					(= local93 {dollars})
				)
				(if (> local83 0)
					(Printf 260 5 local83 local93) ; "You have only $%d %s left. You need a minimum of $10 dollars to play this machine. Sounds like it's time for a loan."
				else
					(Print 260 6) ; "You sadly walk away, your turned-out pockets telling everyone of your gambling "problem.""
				)
				(if local1
					(Display 260 7 dsRESTOREPIXELS local1)
				)
				(if local2
					(Display 260 7 dsRESTOREPIXELS local2)
				)
				(= global158 local83)
				(gCurRoom newRoom: 100)
				(proc0_8 104)
			)
		)
		(super doit:)
	)
)

(instance waitASecScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(= seconds 1)
			)
			(1
				(proc0_3)
				(proc0_31)
				(self dispose:)
			)
		)
	)
)

(instance sWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong3 number: 265 play: self)
				(Print 260 8 #dispose) ; "Congratulations, Larry! You have broken the house limit."
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if local92
					(Print 260 9) ; "This machine only contains $10,000.00; trust us, we'll mail you the rest."
				)
				(localproc_0)
			)
		)
	)
)

(instance playButton of Prop
	(properties
		x 164
		y 189
		view 260
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 10) ; "Click the Hand here to begin play."
			)
			(2
				(cond
					((< local83 local0)
						(Print 260 11) ; "You don't have enough money!"
					)
					((== local0 0)
						(Print 260 12) ; "You insert zero dollars, and pretend to push the button."
						(Print 260 13) ; "You win zero dollars!"
						(Print 260 14 #at -1 140) ; "(You are so easily amused!)"
					)
					(else
						(localproc_2 playButton)
						(proc0_2)
						(gCurRoom setScript: spinEm)
					)
				)
			)
			(else
				(Print 260 15) ; "Else 2"
			)
		)
	)
)

(instance spinEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 setLoop: -1 number: 261 play:)
				(proc0_2)
				(Display 260 7 dsRESTOREPIXELS local2)
				(= local2
					(Display
						(Format @local3 260 1 (-= local83 local0)) ; "%5d"
						dsCOORD
						165
						34
						dsCOLOR
						global130
						dsSAVEPIXELS
					)
				)
				(wheelLeft setCel: (Random 0 7) setCycle: Fwd)
				(wheelCenter setCel: (Random 0 7) setCycle: Fwd)
				(wheelRight setCel: (Random 0 7) setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(wheelLeft
					setCycle:
						CT
						(if global159
							6
						else
							(* 2 (Random 0 3))
						)
						1
						wheelLeft
				)
				(= seconds 2)
			)
			(2
				(wheelCenter
					setCycle:
						CT
						(if global159
							6
						else
							(* 2 (Random 0 3))
						)
						1
						wheelCenter
				)
				(= seconds 2)
			)
			(3
				(wheelRight
					setCycle:
						CT
						(if global159
							6
						else
							(* 2 (Random 0 3))
						)
						1
						self
				)
			)
			(4
				(= local91 0)
				(gLongSong2 number: 262 setLoop: 1 play:)
				(gLongSong3 setLoop: -1)
				(cond
					((== (wheelLeft cel:) 0)
						(if (== (wheelCenter cel:) 0)
							(if (== (wheelRight cel:) 0)
								(gLongSong3 number: 264 play:)
								(if (> local0 8000)
									(localproc_1 10000)
								else
									(localproc_1 (* 4 local0))
								)
								(= seconds 5)
							else
								(gLongSong3 number: 263 play:)
								(localproc_1 (* 2 local0))
								(= seconds 3)
							)
						else
							(gLongSong3 number: 263 play:)
							(localproc_1 local0)
							(= seconds 2)
						)
					)
					((== (wheelLeft cel:) (wheelCenter cel:) 2)
						(if (== (wheelRight cel:) 2)
							(gLongSong3 number: 264 play:)
							(if (> local0 8000)
								(localproc_1 10000)
							else
								(localproc_1 (* 4 local0))
							)
							(= seconds 5)
						else
							(gLongSong3 number: 263 play:)
							(localproc_1 (* 2 local0))
							(= seconds 3)
						)
					)
					((== (wheelLeft cel:) (wheelCenter cel:) 4)
						(if (== (wheelRight cel:) 4)
							(gLongSong3 number: 264 play:)
							(if (> local0 6400)
								(localproc_1 10000)
							else
								(localproc_1 (* 5 local0))
							)
							(= seconds 6)
						else
							(gLongSong3 number: 263 play:)
							(localproc_1 (* 3 local0))
							(= seconds 4)
						)
					)
					(
						(==
							(wheelLeft cel:)
							(wheelCenter cel:)
							(wheelRight cel:)
							6
						)
						(gLongSong3 number: 264 play: self)
						(jackpotSign cycleSpeed: gHowFast init: setCycle: Fwd)
						(if (> local0 4500)
							(localproc_1 10000)
						else
							(localproc_1 (* 7 local0))
						)
						(= seconds 8)
					)
					(else
						(= local91 (= cycles 1))
					)
				)
				(if (not local91)
					(stripe0 setCycle: End stripe1)
				)
			)
			(5
				(stripe0 setCel: 0 stopUpd:)
				(stripe1 setCel: 0 stopUpd:)
				(stripe2 setCel: 0 stopUpd:)
				(stripe3 setCel: 0 stopUpd:)
				(stripe4 setCel: 0 stopUpd:)
				(gLongSong3 setLoop: 1 stop:)
				(if (IsObject jackpotSign)
					(jackpotSign dispose:)
				)
				(if (> local0 local83)
					(if (> local83 9)
						(= local0 local83)
					else
						(= local0 10)
					)
					(Display 260 7 dsRESTOREPIXELS local1)
					(= local1
						(Display
							(Format @local3 260 0 local0) ; "%d"
							dsCOORD
							105
							36
							dsCOLOR
							global130
							dsSAVEPIXELS
						)
					)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance increaseButton of Prop
	(properties
		x 146
		y 164
		view 260
		loop 2
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 16) ; "Click the Hand here to increase the amount of your bet."
			)
			(else 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (and (self onMe: event) (!= (gCurRoom script:) spinEm))
			(if
				(or
					(< $0000 (event modifiers:) $0005) ; emCTRL | emRIGHT_SHIFT
					(!= ((gTheIconBar curIcon:) message:) 2)
				)
				(super handleEvent: event)
			else
				(switch (event type:)
					(evMOUSEBUTTON
						(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
							(= temp1 (GetTime))
							(while (< (GetTime) (+ 10 temp1))
							)
							(temp0 localize:)
							(cond
								((== local0 10000)
									(Print 260 17) ; "This machine has a $10,000.00 limit."
									(break)
								)
								((< local83 10)
									(Print 260 18) ; "You don't have any more money!"
									(break)
								)
								((< local83 (+ (localproc_3) local0 1))
									(if (mod local83 2)
										(= local0 (- local83 1))
									else
										(= local0 local83)
									)
									(Display 260 7 dsRESTOREPIXELS local1)
									(= local1
										(Display
											(Format @local3 260 0 local0) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											global130
											dsSAVEPIXELS
										)
									)
									(Print 260 18) ; "You don't have any more money!"
									(break)
								)
								(else
									(gLongSong3 number: 260 play:)
									(+= local0 (localproc_3))
									(Display 260 7 dsRESTOREPIXELS local1)
									(= local1
										(Display
											(Format @local3 260 0 local0) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											global130
											dsSAVEPIXELS
										)
									)
								)
							)
							(temp0 dispose:)
						)
						(temp0 dispose:)
						(event claimed: 1)
						(return)
					)
					(evKEYBOARD
						(if (== (event message:) KEY_RETURN)
							(cond
								((== local0 10000)
									(Print 260 17) ; "This machine has a $10,000.00 limit."
								)
								((< local83 (+ (localproc_3) local0 1))
									(if (mod local83 2)
										(= local0 (- local83 1))
									else
										(= local0 local83)
									)
									(Display 260 7 dsRESTOREPIXELS local1)
									(= local1
										(Display
											(Format @local3 260 0 local0) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											global130
											dsSAVEPIXELS
										)
									)
									(Print 260 18) ; "You don't have any more money!"
								)
								(else
									(+= local0 (localproc_3))
									(gLongSong3 number: 260 play:)
									(Display 260 7 dsRESTOREPIXELS local1)
									(= local1
										(Display
											(Format @local3 260 0 local0) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											global130
											dsSAVEPIXELS
										)
									)
								)
							)
							(event claimed: 1)
							(return)
						)
					)
				)
			)
		)
	)
)

(instance decreaseButton of Prop
	(properties
		x 183
		y 164
		view 260
		loop 5
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 19) ; "Click the Hand here to decrease the amount of your bet."
			)
			(else 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (and (self onMe: event) (!= (gCurRoom script:) spinEm))
			(if
				(or
					(< $0000 (event modifiers:) emCTRL)
					(!= ((gTheIconBar curIcon:) message:) 2)
				)
				(super handleEvent: event)
			else
				(switch (event type:)
					(evMOUSEBUTTON
						(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
							(= temp1 (GetTime))
							(while (< (GetTime) (+ 10 temp1))
							)
							(temp0 localize:)
							(if (> local0 10)
								(gLongSong3 number: 260 play:)
								(if (< (-= local0 (localproc_3)) 10)
									(= local0 10)
								)
								(Display 260 7 dsRESTOREPIXELS local1)
								(= local1
									(Display
										(Format @local3 260 0 local0) ; "%d"
										dsCOORD
										105
										36
										dsCOLOR
										global130
										dsSAVEPIXELS
									)
								)
							else
								(Printf 260 20 10) ; "This machine's minimum bet is $%d.00."
								(break)
							)
							(temp0 dispose:)
						)
						(temp0 dispose:)
						(event claimed: 1)
						(return)
					)
					(evKEYBOARD
						(if (== (event message:) KEY_RETURN)
							(if (> local0 10)
								(if (< (-= local0 (localproc_3)) 10)
									(= local0 10)
								)
								(gLongSong3 number: 260 play:)
								(Display 260 7 dsRESTOREPIXELS local1)
								(= local1
									(Display
										(Format @local3 260 0 local0) ; "%d"
										dsCOORD
										105
										36
										dsCOLOR
										global130
										dsSAVEPIXELS
									)
								)
							else
								(Printf 260 21 10) ; "You can't bet less than $%d.00."
							)
							(event claimed: 1)
							(return)
						)
					)
				)
			)
		)
	)
)

(instance oddsButton of Prop
	(properties
		x 193
		y 145
		view 260
		loop 4
	)

	(method (cue)
		(super cue:)
		(Print 260 22 #width 200 #at -1 30) ; "PAYOFF  RESULTS  1 Cherry  2 Cherry Cherry  4 Cherry Cherry Cherry  2 Bell  Bell  4 Bell  Bell  Bell  3 Seven  Seven  5 Seven  Seven  Seven  7 Bar   Bar  Bar"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gLongSong3 number: 260 play:)
				(self setCycle: Beg self)
			)
			(1
				(Print 260 23) ; "Click the Hand here to learn this machine's odds."
			)
			(else 0)
		)
	)
)

(instance cashOutButton of Prop
	(properties
		x 135
		y 144
		view 260
		loop 1
	)

	(method (cue)
		(super cue:)
		(localproc_0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self setCycle: Beg self)
			)
			(1
				(Print 260 24) ; "Click the Hand here to stop playing this machine. Your winnings will be given to you automatically."
			)
			(else 0)
		)
	)
)

(instance wheelLeft of Prop
	(properties
		x 115
		y 92
		view 260
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 25) ; "You hope this will soon match the other two."
			)
			(else 0)
		)
	)

	(method (cue)
		(super cue:)
		(gLongSong3 number: 262 loop: 1 play:)
	)
)

(instance wheelCenter of Prop
	(properties
		x 159
		y 89
		view 260
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 25) ; "You hope this will soon match the other two."
			)
			(else 0)
		)
	)

	(method (cue)
		(super cue:)
		(gLongSong3 number: 262 loop: 1 play:)
	)
)

(instance wheelRight of Prop
	(properties
		x 204
		y 88
		view 260
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 260 25) ; "You hope this will soon match the other two."
			)
			(else 0)
		)
	)
)

(instance circle of Actor
	(properties
		yStep 1
		view 260
		loop 7
		signal 22528
		illegalBits 0
		xStep 1
	)

	(method (doit)
		(super doit: &rest)
		(if (self isBlocked:)
			(self setMotion: Wander)
		)
	)
)

(instance leftTank of Cage
	(properties
		top 70
		left -10
		bottom 210
		right 47
	)
)

(instance rightTank of Cage
	(properties
		top 65
		left 281
		bottom 230
		right 339
	)
)

(instance jackpotSign of Prop
	(properties
		x 159
		y 84
		view 260
		loop 6
		priority 15
		signal 16400
	)
)

(instance stripe0 of Prop
	(properties
		x 129
		y 115
		view 260
		loop 8
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe4 setCel: 0)
		(self setCycle: End stripe1)
	)
)

(instance stripe1 of Prop
	(properties
		x 147
		y 134
		view 260
		loop 9
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe0 setCel: 0)
		(self setCycle: End stripe2)
	)
)

(instance stripe2 of Prop
	(properties
		x 163
		y 154
		view 260
		loop 10
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe1 setCel: 0)
		(self setCycle: End stripe3)
	)
)

(instance stripe3 of Prop
	(properties
		x 180
		y 133
		view 260
		loop 11
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe2 setCel: 0)
		(self setCycle: End stripe4)
	)
)

(instance stripe4 of Prop
	(properties
		x 195
		y 108
		view 260
		loop 12
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe3 setCel: 0)
		(self setCycle: End stripe0)
	)
)

