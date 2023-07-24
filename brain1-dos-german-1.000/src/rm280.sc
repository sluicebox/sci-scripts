;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Talker)
(use Language)
(use IconBar)
(use Osc)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm280 0
	presentArm 1
	altS 2
	head 3
)

(local
	[local0 6] = [45 2 53 13 12 4]
	[local6 6] = [11 0 1 12 4 7]
	[local12 3] = [24 25 26]
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24 = 1
	local25
	[local26 3] = [147 147 144]
	[local29 3] = [150 157 155]
	[local32 6] = [{a negatronic brain assembly} {a set of draft resistors} {a left-handed screwdriver} {a reverse-polarized circumlocutor} {a right-handed widget} {an interactive whatchamacallit}]
	[local38 4] = [{no objects are left.} {is one object:} {are two objects:} {are three objects:}]
	[local42 52]
	[local94 10] = [{} {MOVE FORWARD} {MOVE LEFT} {MOVE BACKWARD} {MOVE RIGHT} {TURN ON} {TURN OFF} {BEGIN} {END} {}]
	[local104 10] = [{} {VORW\8eRTS} {LINKS} {R\9aCKW\8eRTS} {RECHTS} {EINSCHALTEN} {AUSSCHALTEN} {ANFANG} {ENDE} {}]
	[local114 7] = [22 8 22 63 78 78 78]
	[local121 7] = [111 115 130 116 105 120 135]
	[local128 4] = [8 9 10 7]
	[local132 4] = [4 4 4 2]
	[local136 4] = [50 72 100 126]
	[local140 6] = [152 229 191 192 192 193]
	[local146 6] = [{Iron plaque} {Plastic clue sheet} {Blue book} {magnet hand} {fork hand} {dart hand}]
	[local152 5] = [9 9 107 107 107]
	[local157 5] = [30 76 105 120 135]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 1)
	(= temp1 (presentArm loop:))
	(= temp2 local17)
	(= temp3 (= temp4 0))
	(switch param1
		(14
			(presentArm loop: 1)
			(= temp3 1)
		)
		(15
			(presentArm loop: 2)
			(= temp3 2)
		)
		(13
			(presentArm loop: 3)
			(= temp3 3)
		)
		(12
			(= temp4 1)
		)
		(10
			(= temp4 2)
		)
		(11
			(= temp4 3)
		)
		(else
			(= temp0 0)
		)
	)
	(if temp0
		(gCMusic2 number: 951 setLoop: 1 play:)
		(gEgo put: param1)
		(if temp3
			(if temp1
				(gEgo get: local16)
			else
				(= global354 1)
				(presentArm show:)
			)
			(= local16 param1)
			(= global365 (- temp3 1))
		)
		(if temp4
			(presentHead loop: (- temp4 1) 7 0)
			(if temp2
				(if (not global363)
					(gEgo get: local17)
				)
				(= global363 0)
			else
				((ScriptID 285 0) ; maze
					add:
						(head
							cel: global364
							nsTop: [local26 global364]
							nsLeft: [local29 global364]
							init:
							yourself:
						)
				)
				(= global355 1)
				(presentHead show:)
			)
			(= local17 param1)
			(= global364 (- temp4 1))
		)
	)
	(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
	(gGame setCursor: 8)
	(return temp0)
)

(procedure (localproc_1 &tmp temp0)
	(= temp0 0)
	(while (and (== [global301 temp0] [local42 temp0]) (< (++ temp0) 50))
	)
	(if (== temp0 50)
		(return 0)
	else
		(return 1)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 50) ((++ temp0))
		(= [local42 temp0] 0)
	)
	(= local19 3)
	(= local18 2)
	(= [local42 0] 0)
	(= [local42 1] 7)
	(= [local42 2] 9)
	(= [local42 3] 8)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 10] temp15)
	(= temp2 0)
	(for ((= temp15 (- local18 2))) (< temp2 5) ((++ temp15))
		(= temp0 (+ 34 (* temp2 14)))
		(if (== temp2 2)
			(= temp3 [local0 2])
			(= temp4 [local0 3])
		else
			(= temp3 [local0 1])
			(= temp4 [local0 0])
		)
		(Graph grFILL_BOX temp0 31 (+ temp0 8) 124 1 temp4 -1 -1)
		(Graph grUPDATE_BOX temp0 31 (+ temp0 8) 124 1)
		(= temp1 [local42 temp15])
		(if (< 0 temp15 (+ local19 1))
			(Format @temp5 280 57 temp15 (localproc_5 temp1)) ; "%d : %s"
			(proc5_8 @temp5 temp3 31 temp0)
		)
		(++ temp2)
	)
)

(procedure (localproc_4 param1)
	(param1 init: &rest)
)

(procedure (localproc_5 param1)
	(if (== (gGame printLang:) 1)
		(return [local94 param1])
	else
		(return [local104 param1])
	)
)

(instance rm280 of Rm
	(properties
		lookStr {You are in a room filled with spare robot parts. The room is dominated by a large glass case containing a simple maze. A robot torso is attached to one end of the maze. You also see a computer console on the table near the front of the room.}
		picture 280
		style 7
		south 220
	)

	(method (init &tmp temp0 temp1)
		(LoadMany rsVIEW 285 286 287 288 289 290 291 295)
		(LoadMany
			rsSOUND
			55
			58
			59
			60
			61
			62
			262
			280
			914
			931
			934
			935
			937
			941
			942
			944
			943
			947
			948
			951
			953
		)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 6) ((++ temp0))
				(= [local0 temp0] [local6 temp0])
			)
		)
		(if (gEgo has: 8)
			(= local22 1)
		)
		(super init:)
		(gCMusic number: 280 setLoop: -1 flags: 1 play:)
		(gCMusic2 flags: 1)
		(lamp init:)
		(if (not (IsFlag 24))
			(hand1 init: stopUpd:)
		)
		(if (not (IsFlag 26))
			(hand2 init: stopUpd:)
		)
		(if (not (IsFlag 25))
			(hand3 init: stopUpd:)
		)
		(if
			(not
				(or
					(and (IsFlag 18) (> global114 0))
					(and (IsFlag 21) (== global114 2))
					(gEgo has: 12)
				)
			)
			(head1 init: stopUpd:)
		)
		(if
			(not
				(or
					(and (IsFlag 19) (> global114 0))
					(and (IsFlag 22) (== global114 2))
					(gEgo has: 10)
				)
			)
			(head2 init: stopUpd:)
		)
		(if
			(not
				(or
					(and (IsFlag 20) (> global114 0))
					(and (IsFlag 23) (== global114 2))
					(gEgo has: 11)
				)
			)
			(head3 init: stopUpd:)
		)
		(robotSlot init:)
		(robotBody init:)
		(presentHead init: hide:)
		(presentArm init: hide:)
		(elevatorScale init: stopUpd:)
		(rightBulb init:)
		(bigBulb init: setScript: lightChange)
		(topBulb init:)
		(plate init:)
		(table init:)
		(shoe init:)
		(screen init: stopUpd:)
		(powerStrip init:)
		(dropSlot init:)
		(computerSlot init:)
		(computer init:)
		(elevatorDoor init: stopUpd:)
		(shelves init:)
		(shelf init:)
		(pickBox init:)
		(dataCard init: hide:)
		(= [global301 0] 0)
		(= [global301 1] 7)
		(= [global301 2] 9)
		(= [global301 3] 8)
		(= local20 (= local21 0))
		(if (not (and (IsFlag 24) (IsFlag 26) (IsFlag 25)))
			(programmer init:)
		)
		(= global355 (= global354 0))
		(= global363 0)
		(if (not (IsFlag 57))
			(self setScript: Start280)
		)
	)

	(method (dispose)
		(gEgo put: 10)
		(gEgo put: 11)
		(gEgo put: 12)
		(gEgo put: 13)
		(gEgo put: 14)
		(gEgo put: 15)
		(if (IsObject altS)
			(altS dispose:)
		)
		(if (IsObject programmer)
			(programmer dispose:)
		)
		(if (IsObject (ScriptID 285 0)) ; maze
			((ScriptID 285 0) dispose:) ; maze
		)
		(DisposeScript 285)
		(gEgo get: 8)
		(LoadMany 0 973 928 941 939)
		(gCMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance Start280 of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 57)
				(= ticks 200)
			)
			(1
				(proc5_9 (gCurRoom lookStr:))
				(proc5_9 280 0) ; "As you enter the room, the three robot heads on the shelf begin to speak. You know that Dr. Brain has created three models of robots -- one kind is programmed to always tell the truth; another kind always lies; and the third model alternately tells the truth and lies."
				(localproc_4
					head1T
					head1Bust
					head1Eyes
					head1Mouth
					280
					1
					0
					1
					self
				)
			)
			(2
				(localproc_4
					head2T
					head2Bust
					head2Eyes
					head2Mouth
					280
					2
					0
					1
					self
				)
			)
			(3
				(localproc_4
					head3T
					head3Bust
					head3Eyes
					head3Mouth
					280
					3
					0
					1
					self
				)
			)
			(4
				(proc5_9 280 4) ; "Each of these robot heads is obviously a different model. Only the truth-telling head will follow your programming precisely. The lying head will always do the opposite of what you tell it, and the "confused" head will alternately follow your instructions or do the reverse of them."
				(self dispose:)
			)
		)
	)
)

(instance head of IconI
	(properties
		view 287
		loop 1
		signal 132
	)

	(method (mask)
		(DrawCel view loop cel nsLeft nsTop -1)
	)
)

(instance computer of Feature
	(properties
		nsTop 71
		nsLeft 219
		nsBottom 125
		nsRight 310
		description {computer}
		sightAngle 180
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 280 5) ; "This computer console can be used to program a robot in the high-level "Robocomp" programming language. You activate the console by inserting a magnetic data card in the slot."
			)
			((and (== theVerb 4) (== invItem 8))
				(if (not (and (IsFlag 24) (IsFlag 26) (IsFlag 25)))
					(= local21 1)
					(gEgo put: 8)
					(dataCard setScript: cardIntoComputer)
				else
					(proc5_9 280 6) ; "You don't need to write any more programs."
				)
			)
			((== theVerb 3)
				(cond
					((and (IsFlag 24) (IsFlag 26) (IsFlag 25))
						(proc5_9 280 6) ; "You don't need to write any more programs."
					)
					(local21
						(dataCard setScript: cardIntoComputer)
					)
					((gEgo has: 8)
						(= local21 1)
						(gEgo put: 8)
						(dataCard setScript: cardIntoComputer)
					)
					(else
						(programmer show:)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance screen of Actor
	(properties
		x 259
		y 93
		view 280
	)

	(method (onMe)
		(return 0)
	)
)

(instance dataCard of Prop
	(properties
		description {data card}
		view 280
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 280 7) ; "This data card can be used for transporting data between two computer devices."
			)
			(3
				(gEgo get: 8)
				(proc5_13 8)
				(= local21 0)
				(= local20 0)
				(self hide:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance computerSlot of Feature
	(properties
		x 274
		y 124
		nsTop 109
		nsLeft 269
		nsBottom 124
		nsRight 278
		description {data card slot}
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(cond
			((and (IsFlag 24) (IsFlag 26) (IsFlag 25))
				(proc5_9 280 6) ; "You don't need to write any more programs."
			)
			(local20
				(programmer show:)
			)
			((== theVerb 2)
				(Print 280 8) ; "This is a card slot designed for a magnetic data card."
			)
			((and (== theVerb 4) (== invItem 8))
				(= local21 1)
				(gEgo put: 8)
				(dataCard setScript: cardIntoComputer)
			)
			((== theVerb 3)
				(= local21 1)
				(gEgo put: 8)
				(dataCard setScript: cardIntoComputer)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cardIntoComputer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc5_1)
				(if (not local25)
					(screen setCycle: End self)
					(= local25 1)
				else
					(= ticks 1)
				)
			)
			(1
				(gCMusic2 number: 934 setLoop: 1 play:)
				(dataCard loop: 6 cel: 0 x: 272 y: 120 show: setCycle: End self)
			)
			(2
				(proc5_2)
				(programmer show:)
				(= cycles 1)
			)
			(3
				(gCMusic2 number: 935 setLoop: 1 play:)
				(dataCard setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance pickBox of Feature
	(properties
		x 115
		y 188
		nsTop 85
		nsLeft 57
		nsBottom 188
		nsRight 172
		description {robot box}
		onMeCheck 128
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3)
		(cond
			((== theVerb 3)
				(proc5_9 280 9) ; "The maze is sealed. If you want to get one of the objects, you'll have to program the robot to get it for you."
			)
			((== theVerb 2)
				(= temp0 0)
				(if (gEgo has: 19)
					(= temp1 { })
				else
					(++ temp0)
					(= temp1
						{\n- a smooth sheet of stiff plastic with something printed on it}
					)
				)
				(if (gEgo has: 18)
					(= temp2 { })
				else
					(++ temp0)
					(= temp2
						{\n- a large blue book}
					)
				)
				(if (gEgo has: 21)
					(= temp3 { })
				else
					(++ temp0)
					(= temp3
						{\n- an iron plate inscribed with a picture of a robot.}
					)
				)
				(if 1
					(= global408 (Memory memALLOC_CRIT (StrLen [local38 temp0])))
					(= global410 (Memory memALLOC_CRIT (StrLen temp1)))
					(= global412 (Memory memALLOC_CRIT (StrLen temp2)))
					(= global414 (Memory memALLOC_CRIT (StrLen temp3)))
					(= global409 (Memory memALLOC_CRIT (StrLen [local38 temp0])))
					(= global411 (Memory memALLOC_CRIT (StrLen temp1)))
					(= global413 (Memory memALLOC_CRIT (StrLen temp2)))
					(= global415 (Memory memALLOC_CRIT (StrLen temp3)))
					(StrSplitInTwo global408 global409 [local38 temp0])
					(StrSplitInTwo global410 global411 temp1)
					(StrSplitInTwo global412 global413 temp2)
					(StrSplitInTwo global414 global415 temp3)
					(proc5_14 ; "The box contains a maze. Attached to the back is a robot torso. In the front is a drop box. Inside the maze %s %s %s %s"
						280
						10
						global408
						global410
						global412
						global414
						global409
						global411
						global413
						global415
					)
					(Memory memFREE global408)
					(Memory memFREE global410)
					(Memory memFREE global412)
					(Memory memFREE global414)
					(Memory memFREE global409)
					(Memory memFREE global411)
					(Memory memFREE global413)
					(Memory memFREE global415)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plate of Feature
	(properties
		nsTop 97
		nsLeft 198
		nsBottom 105
		nsRight 224
		description {plate}
		sightAngle 180
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 280 11) ; "This electroplate contains the remains of a robot cookie. (That's funny -- you thought robots only liked chips.)"
			)
			((== theVerb 3)
				(proc5_9 280 12) ; "The cookie doesn't look very appetizing, and the plate looks even tougher."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		nsTop 100
		nsLeft 174
		nsBottom 189
		nsRight 319
		description {table}
		sightAngle 180
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(Print 280 13) ; "This is the workbench where Dr. Brain makes new breakthroughs in robotic technology, and occasionally grabs a quick lunch."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shoe of Feature
	(properties
		nsTop 115
		nsBottom 137
		nsRight 37
		description {shoe}
		sightAngle 180
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 280 14) ; "This shoe features rubberized in-sole-ation for working with electrical circuitry."
			)
			((== theVerb 3)
				(proc5_9 280 15) ; "It's not your size."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance powerStrip of Feature
	(properties
		nsTop 137
		nsLeft 21
		nsBottom 149
		nsRight 53
		description {power strip}
		sightAngle 180
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 280 16) ; "This strip supplies power to the robot box and to the Robocomp programming console."
			)
			((== theVerb 3)
				(proc5_9 280 17) ; "Zap! These circuits don't seem to be properly grounded. Better leave the power cords alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dropSlot of Feature
	(properties
		nsTop 132
		nsLeft 70
		nsBottom 142
		nsRight 100
		description {drop slot}
		sightAngle 180
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 280 18) ; "You can get objects from this drop slot if you program the robot to drop them in the slot from the inside."
			)
			((== theVerb 3)
				(proc5_9 280 19) ; "There isn't anything in the slot right now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevatorDoor of Prop
	(properties
		x 102
		y 80
		description {elevator door}
		sightAngle 180
		onMeCheck 4
		view 280
		loop 5
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 280 20) ; "It's an elevator door."
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((and (IsFlag 24) (IsFlag 26) (IsFlag 25))
				(self setScript: openElevator)
			)
			(else
				(proc5_9 280 21) ; "You can't open the elevator doors yet. You'll have to convince the robot to let you into the rest of the castle."
			)
		)
	)
)

(instance openElevator of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc5_1)
				(gCMusic2 number: 944 setLoop: 1 play:)
				(elevatorScale setCycle: End)
				(= cycles 20)
			)
			(1
				(gCMusic2 number: 937 setLoop: 1 play:)
				(Wait 0)
				(Wait 30)
				(elevatorDoor setCycle: End self)
			)
			(2
				(= cycles 70)
			)
			(3
				(proc5_2)
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		nsTop 1
		nsLeft 270
		nsBottom 190
		nsRight 320
		description {three bulb lamp}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 280 22) ; "The store was out of candle bulbs."
			)
			(3
				(gCMusic2 number: 61 setLoop: 1 play:)
				(bigBulb cel: (Random 0 1))
				(topBulb cel: (Random 0 1))
				(rightBulb cel: (Random 0 1))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lightChange of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCMusic2 number: 61 setLoop: 1 play:)
				(bigBulb cel: (Random 0 1))
				(topBulb cel: (Random 0 1))
				(rightBulb cel: (Random 0 1))
				(= cycles (Random 10 80))
			)
			(1
				(bigBulb setScript: self)
			)
		)
	)
)

(instance bigBulb of Prop
	(properties
		x 285
		y 18
		description {big light bulb}
		view 280
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 280 23) ; "Dr. Brain wanted authentic castle lighting, so he decided to illuminate his robot work room with candles. But he kept having to replace them, so he settled on using electric candles."
			)
			(3
				(gCMusic2 number: 60 setLoop: 1 play:)
				(self cel: (- 1 cel))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance topBulb of Prop
	(properties
		x 301
		y 9
		description {light bulb}
		view 280
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 280 23) ; "Dr. Brain wanted authentic castle lighting, so he decided to illuminate his robot work room with candles. But he kept having to replace them, so he settled on using electric candles."
			)
			(3
				(gCMusic2 number: 60 setLoop: 1 play:)
				(self cel: (- 1 cel))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightBulb of Prop
	(properties
		x 315
		y 15
		description {light bulb}
		view 280
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 280 23) ; "Dr. Brain wanted authentic castle lighting, so he decided to illuminate his robot work room with candles. But he kept having to replace them, so he settled on using electric candles."
			)
			(3
				(gCMusic2 number: 60 setLoop: 1 play:)
				(self cel: (- 1 cel))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevatorScale of Prop
	(properties
		x 100
		y 31
		description {elevator indicator}
		view 280
		loop 4
	)
)

(instance shelf of Feature
	(properties
		x 209
		y 95
		nsLeft 153
		nsBottom 95
		nsRight 265
		description {shelf}
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1)
		(= temp0 1)
		(cond
			((== theVerb 2)
				(Print 280 24) ; "These shelves are for storing spare robot heads and hands."
			)
			((== theVerb 4)
				(switch invItem
					(12
						(= temp1 head1)
					)
					(10
						(= temp1 head2)
					)
					(11
						(= temp1 head3)
					)
					(14
						(= temp1 hand1)
					)
					(15
						(= temp1 hand2)
					)
					(13
						(= temp1 hand3)
					)
					(else
						(super doVerb: theVerb invItem &rest)
						(= temp0 0)
					)
				)
				(if temp0
					(gCMusic2 number: 59 setLoop: 1 play:)
					(temp1 init:)
					(gEgo put: invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance head1 of Prop
	(properties
		x 180
		y 47
		description {robot head}
		view 286
		cel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 2)
				(Print 280 25) ; "The robot head with the propeller told you, "I am programmed to always follow instructions precisely. Iron Face also follows instructions precisely.""
			)
			((== theVerb 3)
				(gCMusic2 number: 59 setLoop: 1 play:)
				(gEgo get: 12)
				(proc5_13 12)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance head2 of Prop
	(properties
		x 178
		y 93
		description {robot head}
		view 286
		loop 1
		cel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 2)
				(Print 280 26) ; "The iron-faced robot told you, "I am programmed to always follow instructions precisely. Saucer Head never follows orders correctly.""
			)
			((== theVerb 3)
				(gCMusic2 number: 59 setLoop: 1 play:)
				(self dispose:)
				(gEgo get: 10)
				(proc5_13 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance head3 of Prop
	(properties
		x 226
		y 47
		description {robot head}
		view 286
		loop 2
		cel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 2)
				(Print 280 27) ; "The saucer head robot told you, "I am programmed to always follow instructions precisely. I am the only precise order-follower here.""
			)
			((== theVerb 3)
				(gCMusic2 number: 59 setLoop: 1 play:)
				(self dispose:)
				(gEgo get: 11)
				(proc5_13 11)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hand1 of Prop
	(properties
		x 235
		y 91
		description {magnet hand}
		view 285
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(Print 280 28) ; "This robot hand features an electromagnet. It can pick up a moderately heavy metallic object."
			)
			(3
				(gCMusic2 number: 59 setLoop: 1 play:)
				(gEgo get: 14)
				(proc5_13 14)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hand2 of Prop
	(properties
		x 219
		y 91
		description {fork hand}
		view 285
		cel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(Print 280 29) ; "This robot hand looks like a miniature fork lift. It's designed to carry fairly large and heavy objects."
			)
			(3
				(gCMusic2 number: 59 setLoop: 1 play:)
				(gEgo get: 15)
				(proc5_13 15)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hand3 of Prop
	(properties
		x 203
		y 91
		description {dart hand}
		view 285
		cel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(Print 280 30) ; "This robot hand features a dart gun which can fire a dart with a soft rubber tip. The dart should be able to grab and hold a lightweight, smooth-surfaced object."
			)
			(3
				(gCMusic2 number: 59 setLoop: 1 play:)
				(gEgo get: 13)
				(proc5_13 13)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance presentHead of Prop
	(properties
		x 70
		y 52
		description {robot head}
		view 286
	)

	(method (doVerb theVerb invItem)
		(cond
			((and (== theVerb 4) (localproc_0 invItem)))
			((== theVerb 2)
				(cond
					(global363
						(proc5_9 280 31) ; "This head looks like a few screws are loose."
					)
					((== loop 0)
						(proc5_9 20 10) ; "This robot head told you, "I am programmed to always follow instructions precisely. Iron Face also follows instructions precisely.""
					)
					((== loop 1)
						(proc5_9 20 8) ; "This robot head told you, "I am programmed to always follow instructions precisely. Saucer Head never follows orders correctly.""
					)
					((== loop 2)
						(proc5_9 20 9) ; "This robot head told you, "I am programmed to always follow instructions precisely. I am the only precise order-follower here.""
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance presentArm of Prop
	(properties
		x 75
		y 69
		description {robot arm}
		view 285
		priority 12
		signal 16
	)

	(method (doVerb theVerb invItem)
		(cond
			((and (== theVerb 4) (localproc_0 invItem)))
			((== theVerb 2)
				(switch loop
					(1
						(proc5_9 280 28) ; "This robot hand features an electromagnet. It can pick up a moderately heavy metallic object."
					)
					(2
						(proc5_9 280 29) ; "This robot hand looks like a miniature fork lift. It's designed to carry fairly large and heavy objects."
					)
					(3
						(proc5_9 280 30) ; "This robot hand features a dart gun which can fire a dart with a soft rubber tip. The dart should be able to grab and hold a lightweight, smooth-surfaced object."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance robotBody of Feature
	(properties
		x 69
		y 61
		nsTop 41
		nsLeft 44
		nsBottom 81
		nsRight 94
		description {robot body}
		onMeCheck 8
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 280 32) ; "The robot torso is labelled "IMA Robot". (You've heard of Dr. Brain's Installable Modular Accessory Robots. You can attach one of several types of robot heads and hands for different uses.)"
			)
			((and (== theVerb 4) (== invItem 8))
				(if (not (and (IsFlag 24) (IsFlag 26) (IsFlag 25)))
					(= local20 1)
					(gEgo put: 8)
					(presentHead setScript: doMaze)
				else
					(proc5_9 280 33) ; "You have everything you need from here."
				)
			)
			((and (== theVerb 4) (localproc_0 invItem)))
			((and (== theVerb 4) (== invItem 8))
				(if (not (and (IsFlag 24) (IsFlag 26) (IsFlag 25)))
					(= local20 1)
					(gEgo put: 8)
					(presentHead setScript: doMaze)
				else
					(proc5_9 280 33) ; "You have everything you need from here."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance robotSlot of Feature
	(properties
		x 55
		y 75
		nsTop 60
		nsLeft 49
		nsBottom 76
		nsRight 60
		description {robot data card slot}
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 280 34) ; "This card slot looks like it will accept a data card."
			)
			((and (== theVerb 4) (== invItem 8))
				(if (not (and (IsFlag 24) (IsFlag 26) (IsFlag 25)))
					(= local20 1)
					(gEgo put: 8)
					(presentHead setScript: doMaze)
				else
					(proc5_9 280 33) ; "You have everything you need from here."
				)
			)
			((== theVerb 3)
				(proc5_9 280 35) ; "A data card is required to operate this robot."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance doMaze of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc5_1)
				(= local23 0)
				(if local20
					(gCMusic2 number: 934 setLoop: 1 play:)
					(dataCard
						loop: 7
						cel: 0
						x: 54
						y: 72
						show:
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if global354
					(gCMusic2 number: 941 setLoop: 1 play:)
					(presentArm setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(proc5_2)
				(if local24
					((ScriptID 285 0) init:) ; maze
					(= local24 0)
				)
				(= local23 ((ScriptID 285 0) show:)) ; maze
				(proc5_1)
				(if global354
					(gCMusic2 number: 941 setLoop: 1 play:)
					(presentArm setCycle: Beg self)
				else
					(= ticks 1)
				)
			)
			(3
				(if local20
					(gCMusic2 number: 935 setLoop: 1 play:)
					(dataCard setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(if global363
					(proc5_2)
					(self dispose:)
					(return)
				else
					(= ticks 1)
				)
			)
			(5
				(cond
					((and local23 (== global114 2) [global360 global364])
						(= global363 1)
						(switch (presentHead loop:)
							(0
								(SetFlag 21)
							)
							(1
								(SetFlag 22)
							)
							(2
								(SetFlag 23)
							)
						)
					)
					((and local23 (== global114 1) (>= [global360 global364] 2))
						(= global363 1)
						(switch (presentHead loop:)
							(0
								(SetFlag 18)
							)
							(1
								(SetFlag 19)
							)
							(2
								(SetFlag 20)
							)
						)
					)
					(else
						(proc5_2)
						(if (and (IsFlag 24) (IsFlag 26) (IsFlag 25))
							(elevatorDoor doVerb: 3)
						)
						(self dispose:)
						(return)
					)
				)
				(= ticks 1)
			)
			(6
				(gCMusic2 number: 953 setLoop: 1 play:)
				(client loop: (+ (client loop:) 3) setCycle: End self)
			)
			(7
				(proc5_2)
				(if (and (IsFlag 24) (IsFlag 26) (IsFlag 25))
					(elevatorDoor doVerb: 3)
				)
				(self dispose:)
			)
		)
	)
)

(instance shelves of Feature
	(properties
		x 45
		y 104
		nsBottom 104
		nsRight 90
		description {shelves}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(if 1
					(= global414 (Random 0 5))
					(= global408 (Memory memALLOC_CRIT (StrLen [local32 global414])))
					(= global409 (Memory memALLOC_CRIT (StrLen [local32 global414])))
					(StrSplitInTwo global408 global409 [local32 global414])
					(proc5_14 280 36 global408 global409) ; "The shelf contains tools and spare robot parts, including %s."
					(Memory memFREE global408)
					(Memory memFREE global409)
				)
			)
			((== theVerb 3)
				(proc5_9 280 37) ; "You don't need anything from these shelves."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance programmer of PuzzleBar
	(properties
		puzzleHeight 157
		bottomHeight 0
		hintFlag 42
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 50) ((++ temp0))
			(= [local42 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			(self
				add:
					((editIcon new:)
						loop: (+ temp0 1)
						nsLeft: [local152 temp0]
						nsTop: [local157 temp0]
						value: temp0
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(self
				add:
					((pickIcon new:)
						loop: (+ temp0 3)
						nsLeft: [local114 temp0]
						nsTop: [local121 temp0]
						highlightColor: [local0 4]
						lowlightColor: [local0 5]
						value: temp0
						yourself:
					)
			)
		)
		(self add: (printIcon init:))
		(for ((= temp0 2)) (< temp0 5) ((++ temp0))
			(self
				add:
					((editIcon new:)
						loop: (+ temp0 7)
						nsLeft: [local152 temp0]
						nsTop: [local157 temp0]
						value: temp0
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(self
				add:
					((= [global356 temp0] (displayIcon new:))
						init:
						loop: [local128 temp0]
						cel: [local132 temp0]
						nsTop: [local136 temp0]
						nsLeft: [local140 temp0]
						value: temp0
						signal: (| (displayIcon signal:) $0084)
						yourself:
					)
			)
		)
		(localproc_2)
		(= window pWindow)
		(super init: &rest)
	)

	(method (showHelp)
		(proc5_11 280 38) ; "This console allows you to program the IMA Robot using the sophisticated, high-level "Robocomp" programming language. The commands you enter can be saved to a magnetic data card for remote use."
		(proc5_11 280 39) ; "The triangle keys program the robot hand to move in the indicated direction. The "On" key allows you to activate the current hand's primary function, while "Off" turns the function off."
		(proc5_11 280 40) ; "Use "INS" and "DEL" to add or remove lines of code to/from your program. The up and down arrow keys on the left side of the display screen allow you to inspect or change other lines of your program."
		(proc5_11 280 41) ; "The "CLR" button deletes your entire program from memory -- use it with caution. Use "SAVE" to print your program to a data card for use in a remote robotic unit."
		(proc5_11 280 42) ; "Put a hint coin in the slot for some programming suggestions. You will only be charged one hint coin for as many times as you care to read the hint text."
		(proc5_11 280 43) ; "If you are using a keyboard, type a 'q' for a list of the key mapping."
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(proc5_11 280 44) ; "Choose the correct hand for each object -- the fork lift for the book (blue), the rubber dart gun for the plastic clue sheet (green), and the magnet to get the iron robot plaque (gray)."
			(proc5_11 280 45) ; "Program a set of instructions that will move the robot hand to the object, an "On" instruction to pick up the object, some more commands to move the hand to the drop-off slot, then an "Off" command."
			(proc5_11 280 46) ; "When your program is finished, select "SAVE" to save it to the data card. Pick up the data card with the Hand cursor, and click the data card on the robot's torso to try out your program."
			(proc5_11 280 47) ; "If the program doesn't work correctly, watch where the hand goes, and note the error message you get. Put the data card back in the console, and modify your program until it works correctly."
			(proc5_11 280 48) ; "If you choose the lying robot head, it will always do the opposite of what you tell it to do. Think backwards! One approach is to write a correct program, then replace each of the instructions with its opposite."
			(proc5_11 280 49) ; "The hardest head to program is the one which alternately tells the truth and lies. Write a correct program, then replace every second instruction with its opposite."
			(proc5_11 280 50) ; "If the robot head breaks, replace it with a working head. Remember to adopt a new programming strategy for each head."
		)
	)

	(method (show &tmp temp0)
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 8)
		(= local15 1)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			([global356 temp0] signal: (| ([global356 temp0] signal:) $0004))
		)
		(if (not (IsFlag [local12 0]))
			([global356 0] signal: (& ([global356 0] signal:) $fffb))
		)
		(if (not (IsFlag [local12 1]))
			([global356 1] signal: (& ([global356 0] signal:) $fffb))
		)
		(if (not (IsFlag [local12 2]))
			([global356 2] signal: (& ([global356 0] signal:) $fffb))
		)
		(if global354
			([global356 3]
				loop: (+ global365 5)
				cel: 0
				nsLeft: [local140 (+ global365 3)]
				signal: (& ([global356 0] signal:) $fffb)
			)
		)
		(gKeyDownHandler add: self)
		(super show: &rest)
		(gKeyDownHandler delete: self)
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 8)
	)

	(method (hide)
		(if (and local15 local21 (localproc_1))
			(gCMusic2 number: 55 setLoop: 1 play:)
			(proc5_11 280 51) ; "***WARNING*** New program not printed to data card!"
		)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (== (event type:) evKEYBOARD)
			(= temp1 1)
			(switch (event message:)
				(KEY_f
					(= temp0 2)
				)
				(KEY_b
					(= temp0 4)
				)
				(KEY_l
					(= temp0 3)
				)
				(KEY_r
					(= temp0 5)
				)
				(KEY_o
					(= temp0 6)
				)
				(KEY_t
					(= temp0 7)
				)
				(KEY_s
					(= temp0 8)
				)
				(KEY_d
					(= temp0 10)
				)
				(KEY_i
					(= temp0 9)
				)
				(KEY_c
					(= temp0 11)
				)
				(KEY_n
					(= temp0 1)
				)
				(KEY_p
					(= temp0 0)
				)
				(KEY_q
					(Print 280 52 #at 68 96) ; "KEYBOARD COMMANDS: f - Forward......o - turn On b - Backward......t - Turn off l - Left......d - Delete r - Right......i - Insert s - Save......p - Previous command c - Clear......n - Next command q - Quick look at this list"
				)
				(else
					(= temp1 0)
				)
			)
			(if temp1
				(if (IsObject highlightedIcon)
					(highlightedIcon highlight: 0)
				)
				(programmer highlight: (= temp2 (self at: temp0)))
				(programmer select: temp2 0)
				(proc5_20 temp2)
			)
		)
		(super dispatchEvent: event)
	)
)

(instance pWindow of SysWindow
	(properties
		top 10
		left 10
		bottom 187
		right 263
		back 43
		priority -1
	)

	(method (open &tmp temp0)
		(super open: &rest)
		(DrawCel 295 0 0 0 22 -1)
		(DrawCel 287 0 0 142 22 -1)
		(localproc_3)
	)
)

(instance displayIcon of CodeIcon
	(properties
		view 287
		maskView 287
		maskCel 2
	)

	(method (select)
		(return 1)
	)

	(method (show)
		(if (not (& signal $0004))
			(super show: &rest)
		)
	)

	(method (highlight param1 &tmp temp0)
		(cond
			(param1
				(gCMusic2 number: 58 setLoop: 1 play:)
				(if (> value 2)
					(= temp0 (+ value global365))
				else
					(= temp0 value)
				)
				(Print [local146 temp0] #at 175 159 #time 1 #dispose)
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(instance pickIcon of CodeIcon
	(properties
		view 295
		cel 0
	)

	(method (select)
		(gCMusic2 number: 62 setLoop: 1 play:)
		(if (< local18 50)
			(self cel: 1 show:)
			(= [local42 local18] (+ value 1))
			(if (== local18 (- local19 1))
				(= [local42 local19] 9)
				(++ local19)
				(= [local42 local19] 8)
				(++ local18)
			else
				(++ local18)
			)
			(localproc_3)
			(self cel: 2 show:)
		else
			(gCMusic2 number: 931 setLoop: 1 play:)
			(proc5_11 280 53) ; "Program terminated: You have reached the end of the command module length."
		)
	)

	(method (highlight param1)
		(if param1
			(self cel: 2 show:)
		else
			(self cel: 0 show:)
		)
	)
)

(instance printIcon of CodeIcon
	(properties
		view 295
		loop 12
		cel 0
		nsLeft 78
		nsTop 135
	)

	(method (select &tmp temp0)
		(gCMusic2 number: 62 setLoop: 1 play:)
		(self cel: 1 show:)
		(cond
			((and local21 (not (localproc_1)))
				(gCMusic2 number: 55 setLoop: 1 play:)
				(proc5_11 280 54) ; "No changes were made in program. No data printed to data card."
				(programmer goAway:)
			)
			(local21
				(gCMusic2 number: 262 setLoop: 1 play:)
				(for ((= temp0 0)) (< temp0 50) ((++ temp0))
					(= [global301 temp0] [local42 temp0])
				)
				(= [global301 (- local19 1)] 8)
				(proc5_11 280 55) ; "Commands printed to data card."
				(programmer goAway:)
			)
			(else
				(gCMusic2 number: 55 setLoop: 1 play:)
				(proc5_11 280 56) ; "Data card required in slot to print data."
			)
		)
		(self cel: 2 show:)
		(= local15 0)
	)

	(method (highlight param1)
		(if param1
			(self cel: 2 show:)
		else
			(self cel: 0 show:)
		)
	)
)

(instance editIcon of CodeIcon
	(properties
		view 295
		cel 0
	)

	(method (select &tmp temp0)
		(gCMusic2 number: 62 setLoop: 1 play:)
		(self cel: 1 show:)
		(switch value
			(0
				(if (> local18 2)
					(-- local18)
				)
			)
			(1
				(if (< local18 (- local19 1))
					(++ local18)
				)
			)
			(2
				(if (< (+ local18 1) local19 50)
					(for
						((= temp0 (+ local19 1)))
						(> temp0 local18)
						((-- temp0))
						
						(= [local42 temp0] [local42 (- temp0 1)])
					)
					(++ local19)
					(= [local42 local18] 0)
				)
			)
			(3
				(if (< 1 local18 (- local19 1))
					(for ((= temp0 local18)) (<= temp0 local19) ((++ temp0))
						(= [local42 temp0] [local42 (+ temp0 1)])
					)
					(-- local19)
				)
			)
			(4
				(altS number: 61 setLoop: 1 play:)
				(localproc_2)
			)
		)
		(localproc_3)
		(self cel: 2 show:)
	)

	(method (highlight param1)
		(if param1
			(self cel: 2 show:)
		else
			(self cel: 0 show:)
		)
	)
)

(instance head1T of Talker
	(properties
		x 120
		y 97
		nsTop 4
		nsLeft 157
		view 288
	)

	(method (startText param1 param2 &tmp [temp0 750])
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(Format @temp0 param1 param2)
		(= ticks (* 5 (StrLen @temp0)))
		(mouth setCycle: RTRandCycle ticks)
		(eyes setCycle: (tForward new:))
		(head1Propeller setCycle: (tForward new:))
		(head1Bulb setCycle: (tForward new:))
		(Print @temp0 #at x y #dispose)
	)

	(method (init)
		(super init: &rest)
		(head1Propeller init:)
		(head1Bulb init:)
	)

	(method (doit)
		(if (> (GetTime) ticks)
			(self dispose: disposeWhenDone)
			(return)
		)
		(self cycle: eyes)
		(self cycle: mouth)
		(self cycle: head1Propeller)
		(self cycle: head1Bulb)
	)

	(method (dispose)
		(head1Propeller setCycle: 0)
		(head1Bulb setCycle: 0)
		(super dispose: &rest)
	)
)

(instance head1Bust of View
	(properties
		view 288
		cel 1
	)
)

(instance head1Eyes of Prop
	(properties
		nsTop 35
		nsLeft 23
		view 288
		loop 1
		cycleSpeed 16
	)
)

(instance head1Mouth of Prop
	(properties
		nsTop 59
		nsLeft 30
		view 288
		loop 4
		cycleSpeed 16
	)
)

(instance head1Propeller of Prop
	(properties
		nsTop 2
		nsLeft 23
		view 288
		loop 3
		cycleSpeed 3
	)

	(method (init)
		(self x: (+ (head1T nsLeft:) nsLeft) y: (+ (head1T nsTop:) nsTop))
	)
)

(instance head1Bulb of Prop
	(properties
		nsTop 37
		nsLeft 69
		view 288
		loop 2
		cycleSpeed 21
	)

	(method (init)
		(self x: (+ (head1T nsLeft:) nsLeft) y: (+ (head1T nsTop:) nsTop))
	)
)

(instance head2T of Talker
	(properties
		x 120
		y 128
		nsTop 53
		nsLeft 161
		view 289
	)
)

(instance head2Bust of View
	(properties
		view 289
		cel 1
	)
)

(instance head2Eyes of Prop
	(properties
		nsTop 26
		nsLeft 18
		view 289
		loop 1
		cycleSpeed 27
	)
)

(instance head2Mouth of Prop
	(properties
		nsTop 47
		nsLeft 22
		view 289
		loop 2
		cycleSpeed 10
	)
)

(instance head3T of Talker
	(properties
		x 120
		y 77
		nsTop 7
		nsLeft 200
		view 290
	)

	(method (startText param1 param2 &tmp [temp0 750])
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(Format @temp0 param1 param2)
		(= ticks (* 5 (StrLen @temp0)))
		(if mouth
			(mouth setCycle: RTRandCycle ticks)
		)
		(if eyes
			(eyes setCycle: tOscillate)
		)
		(Print @temp0 #at x y #dispose)
	)
)

(instance head3Bust of View
	(properties
		view 290
		cel 1
	)
)

(instance head3Eyes of Prop
	(properties
		nsTop 32
		nsLeft 22
		view 290
		loop 1
		cycleSpeed 10
	)
)

(instance head3Mouth of Prop
	(properties
		nsTop 47
		nsLeft 35
		view 290
		loop 2
		cycleSpeed 16
	)
)

(instance tOscillate of Osc
	(properties)

	(method (nextCel &tmp temp0)
		(return
			(if (<= (- (= temp0 (GetTime)) cycleCnt) (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt (GetTime))
				(+ (client cel:) cycleDir)
			)
		)
	)
)

(instance tForward of Fwd
	(properties)

	(method (nextCel &tmp temp0)
		(return
			(if (<= (- (= temp0 (GetTime)) cycleCnt) (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt (GetTime))
				(+ (client cel:) cycleDir)
			)
		)
	)
)

(instance altS of Sound
	(properties
		flags 1
	)
)

