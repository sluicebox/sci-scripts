;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use room1)
(use n109)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	startTrn 0
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
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	[local18 4]
	[local22 52]
	local74
	local75
	local76
	[local77 4]
	local81
)

(instance startTrn of Script
	(properties)

	(method (doit)
		(if global532
			(= global532 0)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(switch (= state newState)
			(0
				(= global537 1)
				(= global521 0)
				(= gNotice notice)
				(if (and (== (global302 playing:) 29) global447)
					(SetCursor gTheCursor 1 319 199)
				)
				(= global478
					(= global474
						(= global480
							(= global485
								(= global484
									(= global503 (= global483 (= local81 0)))
								)
							)
						)
					)
				)
				(if
					(or
						((global302 durables:) objectAtIndexQuan: 23)
						((global302 durables:) objectAtIndexQuan: 27)
					)
					(proc0_13 1)
				)
				(++ global481)
				(User canControl: 1)
				(if
					(and
						(not (global302 finishStatus:))
						(>= (global302 monStat:) (global302 monGoal:))
						(>= (global302 hapStat:) (global302 hapGoal:))
						(>= (global302 eduStat:) (global302 eduGoal:))
						(>= (global302 carStat:) (global302 carGoal:))
					)
					(self setScript: (ScriptID 234 0)) ; winnerScript
					(return)
				)
				(= state 1)
				(self cue:)
			)
			(1
				(= script 0)
				(DisposeScript 234)
				(self cue:)
			)
			(2
				(if
					(and
						(not (global302 finishStatus:))
						(>= (global302 monStat:) (global302 monGoal:))
						(>= (global302 hapStat:) (global302 hapGoal:))
						(>= (global302 eduStat:) (global302 eduGoal:))
						(>= (global302 carStat:) (global302 carGoal:))
					)
					(= global448 1)
					(= global505 1)
					(global302 finishStatus: global372)
					(global302 script: 0)
					(= temp10 gTheCursor)
					(= temp9 (User controls:))
					(gGame setCursor: 999 1)
					(User controls: 1)
					(for
						((= temp4 (= temp5 0)))
						(< temp4 ((ScriptID 1 2) size:)) ; players
						((++ temp4))
						
						(if (!= (((ScriptID 1 2) at: temp4) playing:) 3) ; players
							(++ temp5)
						)
					)
					(if (> temp5 1)
						(switch
							(Print ; "What should be done with the remaining player(s)?"
								111
								0
								#button
								{Continue}
								1
								#button
								{Restart}
								2
								#button
								{Quit}
								0
								#width
								150
							)
							(0
								(= gQuit 1)
							)
							(1
								(gTheWalker hide:)
								(proc0_1)
								(if (> temp5 2)
									(SetMenu 771 112 1)
								)
							)
							(2
								(gGame restart:)
							)
						)
					)
					(User controls: temp9)
					(gGame setCursor: temp10 1)
					(= state 35)
					(= cycles 1)
				)
				(if (not global448)
					(= global468 (= global467 (= global466 0)))
					(= global465 (= global469 (= global470 0)))
					(= global471 (= global472 0))
					(if global445
						(= global445 0)
					else
						(= global415 0)
					)
					(= global465 0)
					(= global400 -1)
					(= global401 -1)
					(for ((= local0 0)) (< local0 15) ((++ local0))
						(= [global385 local0] 0)
					)
					(global302 extraCredits: 0)
					(= local13 ((global302 durables:) objectAtIndexQuan: 33))
					(= local14 ((global302 durables:) objectAtIndexQuan: 32))
					(= local15 ((global302 durables:) objectAtIndexQuan: 31))
					(= local16 ((global302 durables:) objectAtIndexQuan: 29))
					(if (and local13 local14 local15)
						(global302
							extraCredits: (+ (global302 extraCredits:) 1)
						)
					)
					(if local16
						(global302
							extraCredits: (+ (global302 extraCredits:) 1)
						)
					)
					(= local1 ((ScriptID 1 2) indexOf: global302)) ; players
					(global302 calcNetWorth:)
					(= global329 1)
					(= global370 (= global402 (= global404 (= global405 0))))
					(if (!= global372 1)
						(gTheWalker signal: (| (gTheWalker signal:) $0004))
						(gTheWalker hide:)
						(proc0_1)
						((ScriptID 232 0) init: 0) ; weekend
						(proc1_8)
						(gTheWalker show:)
						(proc0_1)
					)
					(proc0_7)
					(gASong loop: -1 play: 5)
					(gCalc erase:)
					(if (= local3 ((global302 consumables:) objectAtIndex: 9))
						(if (> (local3 quantity:) (= local4 (Random 0 500)))
							(= local5
								(cond
									((<= local4 (/ (local3 quantity:) 20)) 5000)
									((<= local4 (/ (local3 quantity:) 5)) 500)
									(else 200)
								)
							)
							(proc0_13 (if (== local5 5000) 10 else 5))
							(proc0_10 local5)
							(self
								setScript:
									(ScriptID 116 0) ; lottoScript
									0
									(global302 actualName:)
									local5
							)
							(proc1_8)
							(local3 quantity: 0)
							(return)
						)
						(local3 quantity: 0)
					)
					(self cue:)
				)
			)
			(3
				(if (== global372 1)
					(= state 35)
				)
				(= cycles 1)
			)
			(4
				(if
					(and
						(= local16
							((global302 durables:) objectAtIndexQuan: 29)
						)
						(not (Random 0 6))
					)
					(proc0_13 3)
					(proc0_10 (= local11 (Random 20 100)))
					(self setScript: moveNotice 0 10 local11)
					(return)
				)
				(self cue:)
			)
			(5
				(= cycles 1)
			)
			(6
				(= global414 0)
				(if
					(not
						(= local12
							((global302 durables:) objectAtIndexQuan: 28)
						)
					)
					(global302 relax: (- (global302 relax:) 1))
					(if (< (global302 relax:) 10)
						(global302 relax: 10)
					)
				)
				(if
					(and
						(== (global302 livesAt:) 0)
						(not (Random 0 (global302 relax:)))
						((global302 durables:) size:)
					)
					(for
						((= local0 0))
						(< local0 ((global302 durables:) size:))
						((++ local0))
						
						(if
							(and
								(!=
									(((global302 durables:) at: local0)
										indexNum:
									)
									21
								)
								(!=
									(((global302 durables:) at: local0)
										indexNum:
									)
									22
								)
								(!=
									(((global302 durables:) at: local0)
										indexNum:
									)
									23
								)
								(Random 0 3)
							)
							(= global414 1)
							(((global302 durables:) at: local0) quantity: 0)
						)
					)
					(if global414
						(= global415 15)
						(proc0_13 -4)
						((ScriptID 215 0) init: 0) ; newspaper
						(proc1_8)
						(gASong loop: -1 play: 5)
					)
				)
				(self cue:)
			)
			(7
				(= cycles 1)
			)
			(8
				(= local6 0)
				(for ((= local0 5)) (>= local0 1) ((-- local0))
					(if
						(and
							(= local7
								((global302 consumables:) objectAtIndex: local0)
							)
							(local7 quantity:)
							(not local6)
						)
						(= local6 local0)
					)
				)
				(self cue:)
			)
			(9
				(= cycles 1)
			)
			(10
				(if
					(and
						(= local7 ((global302 consumables:) objectAtIndex: 1))
						(local7 quantity:)
					)
					(cond
						((not ((global302 durables:) objectAtIndex: 21))
							(if (== local6 1)
								(= local6 -1)
							)
							(local7 quantity: 0)
							(proc0_13 -2)
							(self setScript: moveNotice 0 8)
							(return)
						)
						((not ((global302 durables:) objectAtIndex: 22))
							(if (> (local7 quantity:) 6)
								(proc0_13 -1)
								(local7 quantity: 6)
								(self setScript: moveNotice 0 9)
								(return)
							)
						)
						((> (local7 quantity:) 12)
							(local7 quantity: 12)
							(proc0_13 -1)
							(self setScript: moveNotice 0 9)
							(return)
						)
					)
				)
				(self cue:)
			)
			(11
				(= cycles 1)
			)
			(12
				(for ((= local0 5)) (> local0 2) ((-- local0))
					(if
						(= local7
							((global302 consumables:) objectAtIndex: local0)
						)
						(local7 quantity: 0)
					)
				)
				(= local4 1)
				(if (not local6)
					(proc0_13 -2)
					(= local4 (Random 0 3))
					(self setScript: moveNotice 0 0)
					(return)
				)
				(self cue:)
			)
			(13
				(= cycles 1)
			)
			(14
				(if (== local6 -1)
					(= local4 (Random 0 1))
				)
				(if (and (== (global302 relax:) 10) (not (Random 0 4)))
					(= local4 0)
				)
				(= temp1 200)
				(if (< (proc0_11) 500)
					(= temp1 50)
				)
				(if (< (proc0_11) temp1)
					(= temp1 (proc0_11))
				)
				(if (and (> (proc0_11) 0) (not local4))
					(proc0_13 -4)
					(= local8
						(if (> temp1 30)
							(Random 30 temp1)
						else
							temp1
						)
					)
					(proc0_10 (- 0 local8))
					(self setScript: moveNotice 0 3 local8)
					(return)
				)
				(self cue:)
			)
			(15
				(= cycles 1)
			)
			(16
				((global302 consumables:) eachElementDo: #doit)
				(if (not (mod global372 4))
					(= local2 (if (== (global302 livesAt:) 0) 40 else 41))
					(if
						(and
							(= temp6
								((global302 consumables:) objectAtIndex: local2)
							)
							(not (temp6 quantity:))
						)
						(self setScript: moveNotice 0 2 (global302 curRent:))
						(gASong pause: 1)
						(gASoundEffect play: 27 gASong)
						(global302 turnedOver: 0)
						(return)
					)
				)
				(self cue:)
			)
			(17
				(= cycles 1)
			)
			(18
				(global302 dressedForWork:)
				(= temp8
					(switch (global302 whichBody:)
						(0 280)
						(1 284)
						(2 290)
						(3 294)
					)
				)
				(if (== (global302 playing:) 29)
					(= temp8 274)
				)
				(gTheWalker
					view:
						(if (not (global302 weeksOfClothing:))
							(+ temp8 3)
						else
							(+ temp8 (- (global302 wearing:) 34))
						)
				)
				(if (== (global302 weeksOfClothing:) 1)
					(self setScript: moveNotice 0 6)
					(return)
				)
				(self cue:)
			)
			(19
				(= cycles 1)
			)
			(20
				(if (and (not (mod global372 4)) (global302 loanBal:))
					(cond
						((not (global302 paySched:))
							(self setScript: moveNotice 0 5)
							(return)
						)
						((< (global302 paySched:) 0)
							(proc0_13 -1)
							(self setScript: moveNotice 0 4)
							(return)
						)
					)
				)
				(self cue:)
			)
			(21
				(= cycles 1)
			)
			(22
				(= local13 ((global302 durables:) objectAtIndexQuan: 33))
				(= local14 ((global302 durables:) objectAtIndexQuan: 32))
				(= local15 ((global302 durables:) objectAtIndexQuan: 31))
				(for
					((= local0 0))
					(< local0 ((global302 durables:) size:))
					((++ local0))
					
					(if
						(and
							(> (proc0_11) 500)
							(!=
								(((global302 durables:) at: local0) indexNum:)
								33
							)
							(!=
								(((global302 durables:) at: local0) indexNum:)
								31
							)
							(!=
								(((global302 durables:) at: local0) indexNum:)
								32
							)
							(&
								(((global302 durables:) at: local0) attributes:)
								$0040
							)
							(or
								(not
									(&
										(((global302 durables:) at: local0)
											attributes:
										)
										$0038
									)
								)
								(>
									(((global302 durables:) at: local0)
										quantity:
									)
									1
								)
							)
						)
						(= local9
							(if
								(&
									(((global302 durables:) at: local0)
										attributes:
									)
									$0100
								)
								35
							else
								50
							)
						)
						(if (not (Random 0 local9))
							(= local10
								(Random
									(/
										(((global302 durables:) at: local0)
											pricePaid:
										)
										20
									)
									(/
										(((global302 durables:) at: local0)
											pricePaid:
										)
										4
									)
								)
							)
							(proc0_13 -1)
							(proc0_10 (- 0 local10))
							(self setScript: moveNotice 0 1 local10)
							(return)
						)
					)
				)
				(self cue:)
			)
			(23
				(= cycles 1)
			)
			(24
				(= temp0
					(or (global302 invAssHi:) (> (global302 invAss:) 1000))
				)
				(switch global373
					(1
						(= global415 1)
						(proc0_13 -3)
						(if temp0
							(proc0_13 -5)
						)
						((ScriptID 215 0) init: 0) ; newspaper
						(proc1_8)
						(gASong loop: -1 play: 5)
					)
					(2
						(= global415 2)
						(proc0_13 -2)
						(if temp0
							(proc0_13 -2)
						)
						((ScriptID 215 0) init: 0) ; newspaper
						(proc1_8)
						(gASong loop: -1 play: 5)
					)
					(3
						(= global415 3)
						(proc0_13 -1)
						(if temp0
							(proc0_13 -1)
						)
						((ScriptID 215 0) init: 0) ; newspaper
						(proc1_8)
						(gASong loop: -1 play: 5)
					)
					(else
						(if global444
							(if temp0
								(proc0_13 5)
							)
							(= global415 4)
							((ScriptID 215 0) init: 0) ; newspaper
							(proc1_8)
							(gASong loop: -1 play: 5)
						)
					)
				)
				(self cue:)
			)
			(25
				(= cycles 1)
			)
			(26
				(if
					(and
						(not (((ScriptID 1 2) at: 0) finishStatus:)) ; players
						(<= 1 global373 2)
					)
					(= global480 ((ScriptID 1 2) at: 0)) ; players
					(switch (((ScriptID 1 2) at: 0) doScandal: global373) ; players
						(1
							(proc0_13 -7 ((ScriptID 1 2) at: 0)) ; players
							(self setScript: moveNotice 0 7)
							(gASoundEffect play: 30)
							(return)
						)
						(-1
							(proc0_13 -3 ((ScriptID 1 2) at: 0)) ; players
							(self
								setScript:
									moveNotice
									0
									11
									(((ScriptID 1 2) at: 0) wage:) ; players
							)
							(return)
						)
					)
				)
				(self cue:)
			)
			(27
				(= cycles 1)
			)
			(28
				(if
					(and
						(> ((ScriptID 1 2) size:) 1) ; players
						(not (((ScriptID 1 2) at: 1) finishStatus:)) ; players
						(<= 1 global373 2)
					)
					(= global480 ((ScriptID 1 2) at: 1)) ; players
					(switch (((ScriptID 1 2) at: 1) doScandal: global373) ; players
						(1
							(proc0_13 -7 ((ScriptID 1 2) at: 1)) ; players
							(gASoundEffect play: 30)
							(self setScript: moveNotice 0 7)
							(return)
						)
						(-1
							(proc0_13 -3 ((ScriptID 1 2) at: 1)) ; players
							(self
								setScript:
									moveNotice
									0
									11
									(((ScriptID 1 2) at: 1) wage:) ; players
							)
							(return)
						)
					)
				)
				(self cue:)
			)
			(29
				(= cycles 1)
			)
			(30
				(if
					(and
						(> ((ScriptID 1 2) size:) 2) ; players
						(not (((ScriptID 1 2) at: 2) finishStatus:)) ; players
						(<= 1 global373 2)
					)
					(= global480 ((ScriptID 1 2) at: 2)) ; players
					(switch (((ScriptID 1 2) at: 2) doScandal: global373) ; players
						(1
							(proc0_13 -7 ((ScriptID 1 2) at: 2)) ; players
							(gASoundEffect play: 30)
							(self setScript: moveNotice 0 7)
							(return)
						)
						(-1
							(proc0_13 -3 ((ScriptID 1 2) at: 2)) ; players
							(self
								setScript:
									moveNotice
									0
									11
									(((ScriptID 1 2) at: 2) wage:) ; players
							)
							(return)
						)
					)
				)
				(self cue:)
			)
			(31
				(= cycles 1)
			)
			(32
				(if
					(and
						(> ((ScriptID 1 2) size:) 3) ; players
						(not (((ScriptID 1 2) at: 3) finishStatus:)) ; players
						(<= 1 global373 2)
					)
					(= global480 ((ScriptID 1 2) at: 3)) ; players
					(switch (((ScriptID 1 2) at: 3) doScandal: global373) ; players
						(1
							(proc0_13 -7 ((ScriptID 1 2) at: 3)) ; players
							(gASoundEffect play: 30)
							(self setScript: moveNotice 0 7)
							(return)
						)
						(-1
							(proc0_13 -3 ((ScriptID 1 2) at: 3)) ; players
							(self
								setScript:
									moveNotice
									0
									11
									(((ScriptID 1 2) at: 3) wage:) ; players
							)
							(return)
						)
					)
				)
				(= global373 0)
				(self cue:)
			)
			(33
				(= global480 0)
				(= cycles 1)
			)
			(34
				(= temp2 0)
				(= temp3 (global302 durables:))
				(if (temp3 size:)
					(for ((= local0 0)) (< local0 (temp3 size:)) ((++ local0))
						(+=
							temp2
							(*
								(-
									((temp3 at: local0) quantity:)
									(if
										(&
											((temp3 at: local0) attributes:)
											$0038
										)
										1
									else
										0
									)
								)
								((temp3 at: local0) pricePaid:)
							)
						)
					)
				)
				(if
					(and
						(not (global302 cashHi:))
						(<= (global302 cash:) 0)
						(not (global302 weeksOfClothing:))
						(< temp2 200)
					)
					(global302 nakedCount: (+ (global302 nakedCount:) 1))
					(if (> (global302 nakedCount:) 1)
						(global302 nakedCount: 0)
						(= temp7
							(switch (global302 uniform:)
								(34 295)
								(35 125)
								(36 73)
								(else 50)
							)
						)
						(= local76
							(+ (proc109_0 global309 temp7) (Random 1 100))
						)
						(proc0_10 local76)
						(self setScript: moveNotice 0 12 local76)
						(return)
					)
				)
				(self cue:)
			)
			(35
				(= cycles 1)
			)
			(36
				(if gQuit
					(return)
				)
				(gTheWalker forceUpd:)
				(= gNotice 0)
				(= global373 0)
				(client script: 0)
				(moveNotice dispose:)
				(if (gCast contains: notice)
					(notice dispose:)
				)
				(proc0_1)
				(self dispose:)
				(= global473 1)
				(= global474 1)
				(= local81 1)
				(proc0_8)
			)
		)
		(if local81
			(DisposeScript 111)
		)
	)
)

(instance moveNotice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local75 (if global480 global480 else global302))
				(notice view: (+ 310 register) init:)
			)
			(1
				(= cycles 1)
			)
			(2
				(notice stopUpd:)
				(if (!= (gASoundEffect number:) 27)
					(gASoundEffect play: 23)
				)
				(= cycles 1)
			)
			(3
				(if register
					(= local74 0)
					(cond
						((or (== register 7) (== register 11))
							(= local17
								(Format @local22 111 1 (local75 actualName:)) ; "%s"
							)
							(= local74 1)
						)
						((== register 1)
							(= local17
								(Format ; "%s"
									@local22
									111
									1
									700
									(((local75 durables:) at: local0) indexNum:)
								)
							)
							(= local74 1)
						)
					)
					(if local74
						(TextSize @[local18 0] local17 4 0)
						(Display
							local17
							dsCOORD
							(- 160 (/ [local18 3] 2))
							(cond
								((== register 7) 75)
								((== register 11) 65)
								((== register 1) 125)
								(else 125)
							)
							dsCOLOR
							0
							dsBACKGROUND
							-1
							dsFONT
							4
						)
					)
				)
				(if register2
					(cond
						((== register 11)
							(= local17 (Format @global100 111 2 register2)) ; "$%d an hour"
						)
						((== register 10)
							(= local17 (Format @global100 111 3 register2)) ; "$%d"
						)
						((== register 12)
							(= local17 (Format @global100 111 3 register2)) ; "$%d"
						)
						((== register 1)
							(= local17 (Format @global100 111 3 register2)) ; "$%d"
						)
						((== register 2)
							(= local17 (Format @global100 111 3 register2)) ; "$%d"
						)
						((== register 3)
							(= local17 (Format @global100 111 3 register2)) ; "$%d"
						)
					)
					(TextSize @[local18 0] local17 4 0)
					(Display
						local17
						dsCOORD
						(- 160 (/ [local18 3] 2))
						(cond
							((== register 10) 95)
							((== register 12) 95)
							((== register 2) 125)
							((== register 11) 131)
							(else 135)
						)
						dsCOLOR
						0
						dsBACKGROUND
						-1
						dsFONT
						4
					)
				)
				(= cycles 1)
			)
			(4
				(if (== register 3)
					(gTimeKeep doit: 10)
					(ambulance init:)
					(self setScript: moveAmbulance)
					(return)
				)
				(if (== register 0)
					(gTimeKeep doit: 20)
				)
				(proc0_3 240)
				(self cue:)
			)
			(5
				(client script: 0 cue:)
				(notice dispose:)
				(proc0_1)
			)
		)
	)
)

(instance notice of Act
	(properties
		view 310
		priority 5
	)

	(method (init)
		(self
			posn: 159 50
			setPri: priority
			setStep: 16 16
			setMotion: MoveTo 159 143 moveNotice
		)
		(super init:)
	)
)

(instance moveAmbulance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gASoundEffect play: 21)
				(ambulance cel: 0 setMotion: MoveTo 230 155 self)
			)
			(1
				(ambulance posn: 242 155 cel: 1 setMotion: MoveTo 242 50 self)
			)
			(2
				(ambulance posn: 230 60 cel: 2 setMotion: MoveTo 69 60 self)
			)
			(3
				(ambulance posn: 77 80 cel: 3 setMotion: MoveTo 77 155 self)
			)
			(4
				(ambulance posn: 59 155 cel: 0 setMotion: MoveTo 230 155 self)
			)
			(5
				(client script: 0 cue:)
				(ambulance dispose:)
				(proc0_1)
			)
		)
	)
)

(instance ambulance of Act
	(properties
		view 608
		loop 1
		priority 5
		ticksToDo 8
	)

	(method (init)
		(self
			moveSpeed: ((ScriptID 1 7) moveSpeed:) ; marble
			posn: 59 155
			setPri: priority
			setStep: 10 10
			stopUpd:
		)
		(if mover
			(mover b-moveCnt: 0)
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (!= (event type:) evMOUSERELEASE))
			(event claimed: 1)
			(moveAmbulance changeState: 5)
		)
	)
)

