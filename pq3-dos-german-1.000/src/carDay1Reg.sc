;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 132)
(include sci.sh)
(use Main)
(use rm025)
(use carStuff)
(use Interface)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	carDay1Reg 0
	carDay1Code 1
	ladyCallScript 2
	endFree1Script 3
)

(local
	local0
	local1
)

(instance carDay1Reg of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (== newRoomNumber 25))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance scriptHook1 of Prop
	(properties
		x 1000
		y -1000
		view 260
		loop 2
	)
)

(instance carDay1Code of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(cond
			((and (== gPrevRoomNum 27) (!= global134 2))
				(scriptHook1 init: x: -1000 setScript: noNutScript)
			)
			(global135
				(switch global135
					(1
						(= temp0 (ScriptID 129 0)) ; speederScript
						(= temp1 1)
					)
					(2
						(= temp0 (ScriptID 129 1)) ; lowRiderScript
						(= temp1 1)
					)
					(3
						(= temp0 (ScriptID 129 2)) ; drunkScript
						(= temp1 1)
					)
					(5
						(= temp0 ladyCallScript)
						(= temp1 1)
					)
					(6
						(= temp0 (ScriptID 129 13)) ; alliedScript
						(= temp1 1)
					)
					(10
						(= temp0 (ScriptID 129 4)) ; setUpScript
						(= temp1 (ScriptID 129 0)) ; speederScript
					)
					(20
						(= temp0 (ScriptID 129 4)) ; setUpScript
						(= temp1 (ScriptID 129 1)) ; lowRiderScript
					)
					(30
						(= temp0 (ScriptID 129 4)) ; setUpScript
						(= temp1 (ScriptID 129 2)) ; drunkScript
					)
					(50
						(= temp0 (ScriptID 129 4)) ; setUpScript
						(= temp1 ladyCallScript)
					)
					(60
						(= temp0 (ScriptID 129 4)) ; setUpScript
						(= temp1 (ScriptID 129 13)) ; alliedScript
					)
				)
				((ScriptID 129 3) ; suspCar
					init:
					x: global154
					y: global136
					cel: global153
					setScript: temp0 0 temp1
				)
			)
			((IsFlag 6)
				(scriptHook1 init: x: -1000 setScript: nutCallScript)
			)
			((and (IsFlag 69) (not (IsFlag 211)))
				(scriptHook1 init: x: -1000 setScript: ladyCallScript)
			)
			((and (IsFlag 14) (not (IsFlag 16)) (== gPrevRoomNum 29))
				(if (!= ((gInventory at: 2) owner:) 885) ; handcuff
					(scriptHook1 init: x: -1000 setScript: letDrunkGoScript)
				)
			)
			((and (IsFlag 68) (not (IsFlag 73)))
				(gCurRoom setScript: dilemaScript)
			)
			((and (IsFlag 73) (not (IsFlag 59)))
				(scriptHook1 init: x: -1000 setScript: mallCallScript)
				(SetFlag 59)
			)
			(
				(and
					(IsFlag 211)
					(not (IsFlag 16))
					(not (IsFlag 68))
					(not (gEgo has: 23)) ; license
					(not ((ScriptID 129 3) script:)) ; suspCar
				)
				(switch global127
					(2
						((ScriptID 129 3) ; suspCar
							init:
							y: 999
							setScript: (ScriptID 129 4) 0 (ScriptID 129 0) ; setUpScript, speederScript
						)
					)
					(3
						((ScriptID 129 3) ; suspCar
							init:
							y: (- ((ScriptID 25 1) lastY:) 250) ; mainInset
							setScript: (ScriptID 129 4) 0 (ScriptID 129 1) ; setUpScript, lowRiderScript
						)
					)
					(4
						((ScriptID 129 3) ; suspCar
							init:
							y: 999
							setScript: (ScriptID 129 4) 0 (ScriptID 129 13) ; setUpScript, alliedScript
						)
					)
					(5
						((ScriptID 129 3) ; suspCar
							init:
							y: (- ((ScriptID 25 1) lastY:) 100) ; mainInset
							setScript: (ScriptID 129 4) 0 (ScriptID 129 2) ; setUpScript, drunkScript
						)
					)
				)
			)
			((and (== gPrevRoomNum 204) (== ((gInventory at: 24) owner:) 25)) ; rmDmv, ticket
				(HandsOff)
				((ScriptID 130 5) init: setScript: ticketScript) ; theTicket
			)
		)
	)
)

(instance endFree1Script of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(gCast contains: (ScriptID 129 3)) ; suspCar
						(!= ((ScriptID 129 3) script:) (ScriptID 129 4)) ; suspCar, setUpScript
					)
					((ScriptID 129 3) setScript: goAwayScript self) ; suspCar
				else
					(= cycles 1)
				)
			)
			(1
				(proc25_4 1)
				(Print 132 0) ; "Since you have reached the end of your jurisdiction, you turn around and head in the other direction."
				(if (== ((ScriptID 25 1) heading:) 270) ; mainInset
					(= temp0 1)
					(= temp1 90)
					(= temp2 1)
				else
					(= temp0 12)
					(= temp1 270)
					(= temp2 (- ((ScriptID 25 1) maxUnits:) 1)) ; mainInset
				)
				((ScriptID 25 1) ; mainInset
					freewayFlag: 1
					engineOn: 1
					tZone: 0
					curUnit: temp2
					lastX: temp0
					lastY: 10
					heading: temp1
					whichBlocks:
					getStuff:
				)
				((ScriptID 25 9) cue:) ; streetBox
				(proc0_17 20)
				(SetFlag 214)
				(if (not register)
					(proc130_14)
					(self dispose:)
				else
					(gCurRoom setScript: dilemaScript)
				)
			)
		)
	)
)

(instance goAwayScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(if register
			(= temp1
				(if
					(not
						(= temp0 (/ (- register ((ScriptID 25 1) mySpeed:)) 5)) ; mainInset
					)
					0
				else
					-1
				)
			)
			((ScriptID 129 3) y: (+ ((ScriptID 129 3) y:) (* temp1 temp0))) ; suspCar, suspCar
		)
		(if
			(and
				(== state 1)
				(or
					(> ((ScriptID 129 3) nsTop:) ((ScriptID 25 5) nsBottom:)) ; suspCar, streetFrame
					(< ((ScriptID 129 3) nsBottom:) ((ScriptID 25 5) nsTop:)) ; suspCar, streetFrame
				)
			)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((>= ((ScriptID 129 3) nsTop:) ((ScriptID 25 5) nsBottom:)) 0) ; suspCar, streetFrame
					((>= ((ScriptID 129 3) nsTop:) ((ScriptID 130 7) nsTop:)) ; suspCar, copCar
						(= register (- ((ScriptID 25 1) mySpeed:) 10)) ; mainInset
					)
					((<= ((ScriptID 129 3) nsTop:) ((ScriptID 130 7) nsBottom:)) ; suspCar, copCar
						(= register (+ ((ScriptID 25 1) maxSpeed:) 5)) ; mainInset
					)
					(else
						(++ state)
					)
				)
				(= cycles 1)
			)
			(1 0)
			(2
				(Print 132 1) ; "The car continues on its way."
				(switch global127
					(2
						(SetFlag 12)
					)
					(3
						(SetFlag 216)
					)
					(4
						(SetFlag 15)
					)
					(5
						(SetFlag 215)
					)
				)
				(= seconds 4)
			)
			(3
				(cond
					((not (IsFlag 15))
						(= global127 4)
						(= local1 (ScriptID 129 13)) ; alliedScript
						(= local0 (+ ((ScriptID 25 1) lastY:) 250)) ; mainInset
						(= cycles 1)
					)
					((not (IsFlag 12))
						(= global127 2)
						(= local1 (ScriptID 129 0)) ; speederScript
						(= local0 (+ ((ScriptID 25 1) lastY:) 250)) ; mainInset
						(= cycles 1)
					)
					((and (not (IsFlag 13)) (not (IsFlag 216)))
						(= global127 3)
						(= local1 (ScriptID 129 1)) ; lowRiderScript
						(= local0 (- ((ScriptID 25 1) lastY:) 250)) ; mainInset
						(= cycles 1)
					)
					((and (not (IsFlag 14)) (not (IsFlag 215)))
						(= global127 5)
						(= local1 (ScriptID 129 2)) ; drunkScript
						(= local0 (- ((ScriptID 25 1) lastY:) 100)) ; mainInset
						(= cycles 1)
					)
					(else
						(caller register: 1)
						(self dispose:)
					)
				)
			)
			(4
				((ScriptID 129 3) ; suspCar
					y: local0
					setScript: (ScriptID 129 4) 0 local1 ; setUpScript
				)
				(= global154 -1)
				(if (gCast contains: (ScriptID 129 6)) ; genCar0
					((ScriptID 129 6) dispose:) ; genCar0
				)
				(self dispose:)
			)
		)
	)
)

(instance dilemaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 130 4) fade:) ; carSong
				(= seconds 5)
			)
			(1
				(gCurRoom newRoom: 890) ; dilema
			)
		)
	)
)

(instance noNutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(EgoDead 22) ; "Your failure to secure the deranged man resulted in a few civilian injuries when he attacked a nearby family. You were suspended.  If you can't handle an unarmed man, how can you expect to function when things REALLY get tough?"
			)
		)
	)
)

(instance nutCallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 4) number: 250 play:) ; carSong
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(1
				(Print 132 2) ; "You'd better get to that Aspen Falls call."
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(Print 132 3) ; "You have failed to respond to Aspen Falls in a reasonable amount of time."
				(EgoDead 8) ; "Your failure to respond the Aspen Falls call resulted in a suspension. An officer who doesn't report to assigned calls puts the public in danger."
			)
		)
	)
)

(instance ladyCallScript of Script
	(properties)

	(method (doit)
		(if
			(and
				(OneOf state 1 2 3)
				((ScriptID 25 1) freewayFlag:) ; mainInset
				(or
					(and
						(== ((ScriptID 25 1) heading:) 90) ; mainInset
						(== ((ScriptID 25 1) lastX:) 8) ; mainInset
						(>
							((ScriptID 25 1) curUnit:) ; mainInset
							(/ ((ScriptID 25 1) maxUnits:) 2) ; mainInset
						)
					)
					(and
						(== ((ScriptID 25 1) heading:) 270) ; mainInset
						(== ((ScriptID 25 1) lastX:) 9) ; mainInset
						(<
							((ScriptID 25 1) curUnit:) ; mainInset
							(- ((ScriptID 25 1) maxUnits:) 1) ; mainInset
						)
					)
				)
			)
			(HandsOff)
			(self start: 5 init:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				((ScriptID 130 4) number: 250 play:) ; carSong
				(if (!= global127 1)
					(Print 132 4) ; "DISPATCH: "64S2, Lytton- Officer requesting supervisor at freeway stop.""
					(Print 132 5) ; "SONNY: "Lytton 64S2 copied - Responding to freeway.""
				)
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(2
				(if ((ScriptID 25 1) freewayFlag:) ; mainInset
					(Print 132 6) ; "Better hurry, Bonds!"
				else
					(Print 132 7) ; "Better get to the freeway! You've got an officer waiting on you."
				)
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(if ((ScriptID 25 1) freewayFlag:) ; mainInset
					(Print 132 6) ; "Better hurry, Bonds!"
				else
					(Print 132 7) ; "Better get to the freeway! You've got an officer waiting on you."
				)
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(4
				(HandsOff)
				(Print 132 8) ; "You have failed to respond to the Freeway stop in a reasonable amount of time."
				(EgoDead 18) ; "Your failure to respond to the highway call resulted in a suspension. An officer who doesn't report to assigned calls puts the public in danger!"
			)
			(5
				(Print 132 9) ; "Up ahead you see a black and white pulled off the freeway along with the detained vehicle. You slow down and pull to the side."
				(= global127 1)
				(= cycles 1)
			)
			(6
				(if (not ((ScriptID 25 1) mySpeed:)) ; mainInset
					(self dispose:)
					(gCurRoom newRoom: 29)
				else
					(= start state)
					((ScriptID 25 1) ; mainInset
						calcSpeed: (- ((ScriptID 25 1) mySpeed:) 5) ; mainInset
					)
					(= cycles 3)
				)
			)
			(7
				(self init:)
			)
		)
	)
)

(instance letDrunkGoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(Print 132 10) ; "The drunk, assuming you no longer wish to detain him, drives away."
				(EgoDead 17) ; "You let the intoxicated driver continue on his merry way and a car full of five teenagers died when he rear-ended them going ninety.  You were immediately suspended."
			)
		)
	)
)

(instance mallCallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(if (not (IsFlag 206))
					(Print 132 11) ; "A radio call interrupts your thoughts of being home with Marie tonight:"
					(Print 132 12) ; "DISPATCH: "64S2, Lytton.""
					(Print 132 13) ; "SONNY: "Lytton, 64S2. Go ahead.""
					(Print 132 14) ; "DISPATCH: "Respond to an assault at the Oak Tree Mall, 300 east Rose, S2.""
					(Print 132 15) ; "SONNY: "10-4.""
				)
				(= cycles 1)
			)
			(2
				((ScriptID 130 4) number: 250 play:) ; carSong
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(3
				(Print 132 16) ; "The radio comes to life again:"
				(Print 132 12) ; "DISPATCH: "64S2, Lytton.""
				(Print 132 17) ; "SONNY: "Lytton, 64S2, go ahead.""
				(Print 132 18) ; "DISPATCH: "Respond to an assault at the Oak Tree Mall, S2.""
				(Print 132 15) ; "SONNY: "10-4.""
				(= seconds (if (not gHowFast) 600 else 300))
			)
			(4
				(HandsOff)
				(Print 132 19) ; "You have failed to respond to Oak Tree Mall in a reasonable amount of time."
				(EgoDead 19) ; "Your failure to respond to the mall resulted in a suspension.  An officer who doesn't report to assigned calls puts the public in danger!"
			)
		)
	)
)

(instance ticketScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(ticketSound play:)
				(client cel: 1)
				(= cycles 3)
			)
			(2
				(client cel: 2)
				(= cycles 5)
			)
			(3
				(client cel: 3)
				(= cycles 5)
			)
			(4
				(client cel: 4)
				(= cycles 5)
			)
			(5
				(client cel: 5)
				(= cycles 5)
			)
			(6
				(client cel: 6)
				(= cycles 5)
			)
			(7
				(client cel: 7)
				(= cycles 5)
			)
			(8
				(client cel: 8)
				(= cycles 5)
			)
			(9
				(self dispose:)
				(proc130_14)
			)
		)
	)
)

(instance ticketSound of Sound
	(properties
		number 260
	)
)

