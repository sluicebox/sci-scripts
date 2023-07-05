;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
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
	rm180 0
	clock 1
)

(local
	[local0 3] = [3 3 43]
	[local3 3] = [8 8 11]
	local6
	local7
	[local8 4]
	[local12 4]
	[local16 4]
	[local20 4]
	[local24 4]
	[local28 4]
	[local32 12] = [1 1 3 0 1 2 1 0 0 1 0 0]
	[local44 12] = [1 3 0 0 2 1 0 0 0 0 0 0]
	[local56 12] = [2 3 0 0 1 2 0 0 0 0 0 0]
	[local68 12] = [1 1 3 0 1 2 1 0 0 1 0 0]
	[local80 2]
	[local82 3] = [180 180 120]
	local85
	local86
	[local87 3] = [173 173 173]
	[local90 3] = [210 300 300]
	[local93 3] = [15 10 10]
	[local96 3] = [11 11 11]
	local99
	local100
	local101
	local102
	local103
	local104
	local105
	[local106 4]
	[local110 4] = [12 111 26 108]
	[local114 4] = [105 105 124 124]
	local118
	[local119 6]
	local125 = 1
	local126
	local127
	local128 = 1
	local129
	local130
	local131 = 1
	local132 = 1
	local133 = 1
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(if (== [local12 local7] param2)
		(= temp0 [local16 local7])
		(cond
			((!= [local8 local7] param1)
				(= [local12 local7] 0)
			)
			((not param1) 0)
			((and temp0 [local80 (- param1 1)])
				(= [local12 local7] 0)
			)
			((and (not temp0) (not param3))
				(= [local12 local7] 0)
			)
			(else
				(++ local7)
				(= [local80 (- param1 1)] 0)
			)
		)
	)
	(if (== [local24 local85] param2)
		(= temp0 [local28 local85])
		(cond
			((!= [local20 local85] param1)
				(= [local24 local85] 0)
			)
			((not param1) 0)
			((and temp0 [local80 (- param1 1)])
				(= [local24 local85] 0)
			)
			((and (not temp0) (not param3))
				(= [local24 local85] 0)
			)
			(else
				(++ local85)
				(= [local80 (- param1 1)] 0)
			)
		)
	)
)

(procedure (localproc_1 param1)
	(return
		(or
			(and (== [local8 local7] 3) (== [local12 local7] param1))
			(and (== [local20 local85] 3) (== [local24 local85] param1))
		)
	)
)

(instance rm180 of Rm
	(properties
		lookStr {You are in a room filled with clocks and timepieces of all kinds. They were originally all set to Greenwich mean time, but Dr. Brain didn't want anyone to think he was mean, so he reset them.}
		picture 180
		style 7
		south 120
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(= [local0 temp0] [local3 temp0])
			)
		)
		(gCMusic flags: 1)
		(gCMusic2 flags: 1)
		(LoadMany rsVIEW 125 180 185 195 196)
		(Load rsSCRIPT 956 939)
		(LoadMany rsSOUND 50 51 55 60 61 121 180 916 917 918 919)
		(super init:)
		(timeCards init: hide:)
		(drawer init:)
		(if (and (IsFlag 53) (not (gEgo has: 7)) (not (IsFlag 1)))
			(drawer cel: (drawer lastCel:))
			(timeCards show:)
		)
		(wallClock init:)
		(clock init:)
		(books init:)
		(alarmDevice init:)
		(cuckooClock init:)
		(clockRadio init:)
		(sundial init:)
		(hourGlasses init:)
		(elevatorLight init:)
		(elevatorDoor init:)
		(clockRadioFace init: hide:)
		(if (IsFlag 58)
			(= local125 0)
			(switch1 addToPic:)
			(switch2 addToPic:)
			(switch3 addToPic:)
			(switch4 addToPic:)
			(buttonPad init:)
			(alarmLight addToPic:)
			(alarmHammer addToPic:)
			(canElf addToPic:)
			(water addToPic:)
			(waterWheel addToPic:)
			(pool addToPic:)
			(clockHands addToPic:)
			(cuckooDoor addToPic:)
			(cuckoo addToPic:)
		else
			(waterS play:)
			(gCMusic number: 918 flags: 1 setLoop: -1 play:)
			(switch1 init:)
			(switch2 init:)
			(switch3 init:)
			(switch4 init:)
			(alarmLight init:)
			(alarmHammer init:)
			(canElf init:)
			(water init: setCycle: Fwd)
			(waterWheel init: setCycle: Fwd)
			(pool init: setCycle: Fwd)
			(clockHands init:)
			(cuckooDoor init:)
			(cuckoo init:)
		)
		(if (not (IsFlag 58))
			(gCurRoom setScript: beginScript)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(if (IsObject radioS)
			(radioS dispose:)
		)
		(if (IsObject alarmS)
			(alarmS dispose:)
		)
		(if (IsObject birdS)
			(birdS dispose:)
		)
		(if (IsObject waterS)
			(waterS dispose:)
		)
		(if (IsObject voiceS)
			(voiceS dispose:)
		)
		(if (IsObject (ScriptID 190 0)) ; timeClock
			((ScriptID 190 0) dispose:) ; timeClock
		)
		(if (IsObject hourGlass)
			(hourGlass dispose:)
		)
		(LoadMany 0 190 956)
		(super dispose: &rest)
	)
)

(instance timeScript of Script
	(properties)

	(method (doit)
		(cond
			((and (not local128) (not local129) (not local126) (not local125))
				(proc5_0 58 2)
				(gCurRoom setScript: timeDoneScript)
				(self dispose:)
			)
			(local125
				(super doit:)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 0)
				(clockHands setCel: 0)
				(voiceS number: 927 play:)
				(proc5_10 3 180 0)
				(= ticks 300)
			)
			(1
				(= temp0 (+ (clockHands cel:) 1))
				(clockHands setCel: temp0)
				(switch temp0
					(6
						(voiceS number: 928 vol: 80 play:)
						(proc5_10 3 180 1)
					)
					(9
						(voiceS number: 929 play:)
						(proc5_10 3 180 2)
					)
					(11
						(voiceS number: 930 play:)
						(proc5_10 3 180 3)
					)
				)
				(= ticks 300)
			)
			(2
				(if (< (++ register) 11)
					(self changeState: 1)
				else
					(self cue:)
				)
			)
			(3
				(voiceS number: 56 play:)
				(++ global123)
				(proc5_18)
				(gCurRoom setScript: timeScript)
			)
		)
	)
)

(instance beginScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_9 180 4)
				(gGame setCursor: 222 1)
				(cuckooDoor setCycle: End self)
			)
			(1
				(cuckoo setCycle: End self)
			)
			(2
				(cuckoo setLoop: 6 setCel: 0 setCycle: Fwd)
				(gCurRoom setScript: timeScript)
				(self dispose:)
			)
		)
	)
)

(instance timeDoneScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(radioS dispose:)
				(alarmS dispose:)
				(birdS dispose:)
				(waterS dispose:)
				(voiceS dispose:)
				(switch1 addToPic:)
				(switch2 addToPic:)
				(switch3 addToPic:)
				(switch4 addToPic:)
				(buttonPad init:)
				(alarmLight addToPic:)
				(alarmHammer addToPic:)
				(canElf addToPic:)
				(water addToPic:)
				(waterWheel addToPic:)
				(pool addToPic:)
				(clockHands addToPic:)
				(cuckoo addToPic:)
				(cuckooDoor addToPic:)
				(clockRadioFace addToPic:)
				(= cycles 1)
			)
			(1
				(gCMusic stop:)
				(gCMusic2 stop:)
				(gCMusic2 number: 181 setLoop: 1 play: self)
				(wallClock setCycle: Fwd)
			)
			(2
				(wallClock setCycle: 0 addToPic:)
				(= cycles 1)
			)
			(3
				(proc5_10 3 180 5)
				(= ticks 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 88
		y 149
		description {books}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 6) ; "Here are some of Dr. Brain's most timely reference works. There's a copy of Stephen Hawking's "A Brief History of Time", Robert Heinlein's "Time Enough For Love", Martin Heidegger's "Being and Time", and Madeleine L'Engle's "A Wrinkle in Time"."
			)
			(3
				(proc5_9 180 7)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alarmDevice of Feature
	(properties
		x -23
		y 35
		description {alarmDevice}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 8) ; "It's an Acme Intruder Alert Alarm."
			)
			(3
				(proc5_9 180 9)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cuckooClock of Feature
	(properties
		x 178
		y 73
		description {cuckoo water clock}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 10) ; "You've never seen a water-powered cuckoo clock before. This must be another of Dr. Brain's incredible inventions!"
			)
			(3
				(if local125
					(proc5_9 180 11)
				else
					(proc5_9 180 12)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clockRadio of Feature
	(properties
		x 47
		y 129
		description {clockRadio}
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 13) ; "This specially-designed clock radio only plays rap music. Dr. Brain hates rap music, but he got a really good deal on the radio. Besides, an Elf will dance to almost anything."
			)
			(3
				(proc5_9 180 14)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clockRadioFace of Prop
	(properties
		x 53
		y 132
		view 180
		loop 6
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(proc5_9 180 14)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sundial of Feature
	(properties
		x 262
		y 174
		description {sundial}
		sightAngle 180
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 15) ; "Dr. Brain wanted to make sure he could still tell time if the power went out, so he installed this sundial. Of course, he forgot about the minor problem of having two floors of the castle between this room and the sun. That triangular thing in the center is called a "gnomon"."
			)
			(3
				(proc5_9 180 16)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hourGlasses of Feature
	(properties
		x 70
		y 121
		nsTop 76
		nsLeft 47
		nsBottom 127
		nsRight 109
		description {hourglasses}
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 180 17) ; "This desk features a state-of-the-art Acme 40-second time lock. Of course, Acme is in a very small state (it makes Rhode Island look like a continent). A pair of hourglasses has been provided to help open the lock."
			)
			((and (IsFlag 58) (== theVerb 3))
				(if (IsFlag 53)
					(proc5_9 180 18)
				else
					(if local133
						(= local133 0)
						(gGame setCursor: 50 1)
						(hourGlass init:)
					)
					(if (!= local99 global114)
						(hourGlass dispose:)
						(gGame setCursor: 50 1)
						(hourGlass init:)
						(= local99 global114)
					)
					(if (hourGlass show:)
						(drawer setScript: openDrawer)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buttonPad of Feature
	(properties
		nsTop 53
		nsLeft 211
		nsBottom 91
		nsRight 221
		description {button pad}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(proc5_9 180 19)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance switch1 of Prop
	(properties
		x 217
		y 60
		view 180
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(proc5_9 180 20)
			)
			((and (== theVerb 3) (not (IsFlag 58)))
				(gCMusic2 number: 61 setLoop: 1 play:)
				(self setCel: 1)
				(Animate (gCast elements:) 1)
				(if local126
					(= local126 0)
					(radioS pause: 1)
					(canElf setCycle: Beg)
					(clockRadioFace setCycle: 0 hide:)
				else
					(= local126 1)
					(if local127
						(radioS pause: 0)
					else
						(radioS play:)
						(= local127 1)
					)
					(canElf setCycle: Fwd)
					(clockRadioFace setCycle: Fwd show:)
				)
				(Wait 0)
				(Wait 10)
				(self setCel: 0)
				(gCMusic2 number: 60 setLoop: 1 play:)
			)
		)
	)
)

(instance switch2 of Prop
	(properties
		x 217
		y 69
		view 180
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(proc5_9 180 21)
			)
			((and (== theVerb 3) (not (IsFlag 58)))
				(gCMusic2 number: 61 setLoop: 1 play:)
				(self setCel: 1)
				(Animate (gCast elements:) 1)
				(if local125
					(waterS pause: 1)
					(gCMusic pause: 1)
					(= local125 0)
					(clockHands setCycle: 0)
					(water setCycle: 0)
					(waterWheel setCycle: 0)
					(pool setCycle: 0)
				else
					(waterS pause: 0)
					(gCMusic pause: 0)
					(= local125 1)
					(water setCycle: Fwd)
					(waterWheel setCycle: Fwd)
					(pool setCycle: Fwd)
				)
				(if (not local129)
					(alarmS play:)
					(= local129 1)
					(alarmLight setCycle: Fwd)
					(alarmHammer setCycle: Fwd)
				)
				(Wait 0)
				(Wait 10)
				(self setCel: 0)
				(gCMusic2 number: 60 setLoop: 1 play:)
			)
		)
	)
)

(instance switch3 of Prop
	(properties
		x 217
		y 78
		view 180
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 2)
				(proc5_9 180 22)
			)
			((and (== theVerb 3) (not (IsFlag 58)))
				(gCMusic2 number: 61 setLoop: 1 play:)
				(self setCel: 1)
				(if local128
					(cuckoo setLoop: 5 setCel: 255 setCycle: Beg)
					(= temp0 cuckoo)
				else
					(cuckooDoor setCel: 0 setCycle: End)
					(= temp0 cuckooDoor)
				)
				(while (temp0 cycler:)
					(= gGameTime (+ gTickOffset (GetTime)))
					(temp0 doit:)
					(Animate (gCast elements:) 1)
				)
				(if local128
					(= local128 0)
					(= temp0 cuckooDoor)
					(cuckooDoor setCel: 255 setCycle: Beg)
				else
					(= local128 1)
					(= temp0 cuckoo)
					(cuckoo setLoop: 5 setCel: 0 setCycle: End)
				)
				(while (temp0 cycler:)
					(= gGameTime (+ gTickOffset (GetTime)))
					(temp0 doit:)
					(Animate (gCast elements:) 1)
				)
				(if local128
					(cuckoo setLoop: 6 cel: 0 setCycle: Fwd)
				)
				(if (not local125)
					(waterS pause: 0)
					(gCMusic pause: 0)
					(= local125 1)
					(water setCycle: Fwd)
					(waterWheel setCycle: Fwd)
					(pool setCycle: Fwd)
				)
				(self setCel: 0)
				(gCMusic2 number: 60 setLoop: 1 play:)
			)
		)
	)
)

(instance switch4 of Prop
	(properties
		x 217
		y 87
		view 180
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(proc5_9 180 23)
			)
			((and (== theVerb 3) (not (IsFlag 58)))
				(gCMusic2 number: 61 setLoop: 1 play:)
				(self setCel: 1)
				(Animate (gCast elements:) 1)
				(if (and (not local128) local126 local129)
					(alarmS stop:)
					(= local129 0)
					(alarmLight setCycle: Beg)
					(alarmHammer setCycle: Beg)
				)
				(if local126
					(canElf setCycle: Fwd)
					(clockRadioFace setCycle: Fwd show:)
				else
					(canElf setCycle: Beg)
					(clockRadioFace setCycle: 0 hide:)
				)
				(Wait 0)
				(Wait 10)
				(self setCel: 0)
				(gCMusic2 number: 60 setLoop: 1 play:)
			)
		)
	)
)

(instance alarmLight of Prop
	(properties
		x 47
		y 21
		view 180
		loop 1
	)
)

(instance alarmHammer of Prop
	(properties
		x 47
		y 48
		view 180
		loop 2
	)
)

(instance canElf of Prop
	(properties
		x 30
		y 132
		description {dancing elf}
		view 180
		loop 3
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 24) ; "It's one of the famous Dancing Elves. Turn on the radio, and the Elf will dance for you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of Prop
	(properties
		x 162
		y 26
		view 185
	)
)

(instance waterWheel of Prop
	(properties
		x 152
		y 83
		view 185
		loop 1
	)
)

(instance pool of Prop
	(properties
		x 177
		y 96
		view 185
		loop 2
	)
)

(instance clockHands of Prop
	(properties
		x 180
		y 66
		view 185
		loop 3
	)
)

(instance cuckoo of Prop
	(properties
		x 181
		y 51
		description {the cuckoo}
		view 185
		loop 5
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 25) ; "It's a cuckoo, Dr. Brain's favorite bird."
			)
			(3
				(proc5_9 180 26)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (not (mod cel 2)) (== loop 6))
			(birdS play:)
		)
	)
)

(instance cuckooDoor of Prop
	(properties
		x 181
		y 51
		view 185
		loop 4
		cycleSpeed 1
	)
)

(instance drawer of Prop
	(properties
		x 88
		y 145
		description {drawer}
		lookStr {This drawer is fastened by an "Acme Time Lock".}
		view 196
		signal 4096
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 2) (or (gEgo has: 7) (gEgo has: 22)))
				(proc5_9 180 27)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((not (IsFlag 58))
				(proc5_9 180 28)
			)
			((not (IsFlag 53))
				(if local133
					(= local133 0)
					(gGame setCursor: 50 1)
					(hourGlass init:)
				)
				(if (!= local99 global114)
					(gGame setCursor: 50 1)
					(hourGlass dispose:)
					(hourGlass init:)
					(= local99 global114)
				)
				(if (hourGlass show:)
					(drawer setScript: openDrawer)
				)
			)
			((and (not (gEgo has: 7)) (not (gEgo has: 22)))
				(proc5_9 180 29)
			)
			(else
				(proc5_9 180 30)
			)
		)
	)
)

(instance openDrawer of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic number: 121 setLoop: 1 play:)
				(drawer setCycle: End self)
			)
			(1
				(timeCards show:)
				(self dispose:)
			)
		)
	)
)

(instance timeCards of Prop
	(properties
		x 94
		y 154
		description {the time cards}
		view 196
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 31) ; "There is a set of three time cards in the drawer."
			)
			(3
				(gCMusic number: 59 setLoop: 1 play:)
				(gEgo get: 7)
				(timeCards dispose:)
				(Animate (gCast elements:) 1)
				(Wait 0)
				(Wait 30)
				(drawer setScript: closeDrawer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clock of Prop
	(properties
		x 122
		y 82
		description {time clock}
		onMeCheck 2
		view 180
		loop 7
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 180 32) ; "Visitors to the castle need to punch in on this time clock. Dr. Brain is very big on punctuality, and expects you to punch in at exactly the right time."
			)
			(
				(and
					(IsFlag 58)
					(or
						(== theVerb 3)
						(== gTheCursor 69)
						(and (== theVerb 4) (== invItem 7))
					)
				)
				(cond
					((and (gEgo has: 7) (not (IsFlag 1)))
						(if local132
							((ScriptID 190 0) init:) ; timeClock
							(= local132 0)
						)
						((ScriptID 190 0) show:) ; timeClock
						(if (IsFlag 1)
							(gCurRoom setScript: elevatorScript)
						)
					)
					((and (not (gEgo has: 7)) (not (IsFlag 1)))
						(proc5_9 180 33)
					)
					((IsFlag 1)
						(proc5_9 180 34)
					)
					((not (IsFlag 58))
						(proc5_9 180 35)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wallClock of Prop
	(properties
		x 80
		y 70
		description {the wall clock}
		view 180
		loop 8
		cycleSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 36) ; "Another of Dr. Brain's famous garage sale artifacts, this is a clock that runs backwards... sometimes. It doesn't keep very good time even when it's running (but might make a pretty good fan if you attached some fan blades)."
			)
			(3
				(proc5_9 180 37)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigHrGlass of Prop
	(properties
		x 32
		y 59
		view 195
		loop 2
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance littleHrGlass of Prop
	(properties
		x 111
		y 63
		view 195
		loop 3
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance bigSandTop of Prop
	(properties
		x 47
		y 75
		view 195
		loop 12
		cel 7
		priority 15
		signal 16
	)
)

(instance bigSandBot of Prop
	(properties
		x 51
		y 101
		view 195
		loop 7
		cel 7
		priority 15
		signal 16
	)
)

(instance bigTrickle of Prop
	(properties
		x 56
		y 89
		view 195
		loop 4
		priority 15
		signal 16
	)
)

(instance littleSandTop of Prop
	(properties
		x 122
		y 74
		view 195
		loop 8
		cel 5
		priority 15
		signal 16
	)
)

(instance littleSandBot of Prop
	(properties
		x 119
		y 99
		view 195
		loop 9
		cel 5
		priority 15
		signal 16
	)
)

(instance littleTrickle of Prop
	(properties
		x 131
		y 89
		view 195
		loop 5
		priority 15
		signal 16
	)
)

(instance runBigClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bigHourglassS stop:)
				(= local103 1)
				(= local100 0)
				(bigSandTop hide:)
				(bigSandBot hide:)
				(bigTrickle setCycle: 0 hide:)
				(= ticks 1)
			)
			(1
				(if (client cel:)
					(client setCycle: Beg self)
					(bigSandTop loop: 12)
					(bigSandBot x: 40 y: 103 loop: 14)
					(bigTrickle loop: 13)
				else
					(client setCycle: End self)
					(bigSandTop loop: 6)
					(bigSandBot x: 51 y: 101 loop: 7)
					(bigTrickle loop: 4)
				)
			)
			(2
				(bigHourglassS play:)
				(bigSandTop cel: register show:)
				(bigSandBot cel: register show:)
				(bigTrickle setCycle: Fwd show:)
				(= local103 0)
				(= ticks 1)
			)
			(3
				(bigSandTop setCel: register)
				(bigSandBot setCel: register)
				(if (< register 7)
					(= ticks [local90 global114])
				else
					(= ticks 15)
				)
			)
			(4
				(cond
					(local102
						(self changeState: 2)
					)
					((<= (++ register) 7)
						(self changeState: 2)
					)
					(else
						(bigHourglassS stop:)
						(= local103 1)
						(bigTrickle setCycle: 0 hide:)
						(= local100 1)
						(= ticks [local82 global114])
					)
				)
			)
			(5
				(= local100 2)
				(= local103 0)
				(self dispose:)
			)
		)
	)
)

(instance runlittleClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smallHourglassS stop:)
				(= local102 1)
				(= local101 0)
				(littleSandTop hide:)
				(littleSandBot hide:)
				(littleTrickle setCycle: 0 hide:)
				(= ticks 1)
			)
			(1
				(if (client cel:)
					(client setCycle: Beg self)
				else
					(client setCycle: End self)
				)
			)
			(2
				(smallHourglassS play:)
				(littleSandTop cel: register show:)
				(littleSandBot cel: register show:)
				(littleTrickle setCycle: Fwd show:)
				(= local102 0)
				(= ticks 1)
			)
			(3
				(littleSandTop setCel: register)
				(littleSandBot setCel: register)
				(if (< register 5)
					(= ticks [local87 global114])
				else
					(= ticks 15)
				)
			)
			(4
				(cond
					(local103
						(self changeState: 2)
					)
					((<= (++ register) 5)
						(self changeState: 2)
					)
					(else
						(smallHourglassS stop:)
						(= local102 1)
						(littleTrickle setCycle: 0 hide:)
						(= local101 1)
						(= ticks [local82 global114])
					)
				)
			)
			(5
				(= local101 2)
				(= local102 0)
				(self dispose:)
			)
		)
	)
)

(instance buttonIcon of CodeIcon
	(properties
		view 195
		cel 0
		maskView 195
		maskCel 2
	)

	(method (select &tmp temp0 temp1)
		(if (not (& signal $0004))
			(gCMusic2 number: 60 setLoop: 1 play:)
			(cond
				((== value 0)
					(cond
						((== local101 1)
							(localproc_0 2 1 local100)
						)
						((== local100 1 local100)
							(localproc_0 2 2)
						)
						(else
							(localproc_0 0 2 0)
							(= [local80 1] 1)
						)
					)
					(if local100
						(= temp1 0)
					else
						(= temp1 (- 7 (bigSandTop cel:)))
					)
					(bigHrGlass setScript: runBigClock 0 temp1)
				)
				((== value 1)
					(cond
						((== local101 1)
							(localproc_0 1 1 local101)
						)
						((== local100 1)
							(localproc_0 1 2 local101)
						)
						(else
							(localproc_0 0 1 0)
							(= [local80 0] 1)
						)
					)
					(if local101
						(= temp1 0)
					else
						(= temp1 (- 5 (littleSandTop cel:)))
					)
					(littleHrGlass setScript: runlittleClock 0 temp1)
				)
				((== value 2)
					(gCMusic2 number: 51 setLoop: 1 play:)
					(hourGlass enable: [local106 0])
					([local106 0] show:)
					(hourGlass enable: [local106 1])
					([local106 1] show:)
					(hourGlass enable: [local106 3])
					([local106 3] show:)
					(hourGlass disable: [local106 2])
					(= local6 0)
					(= [local80 1] 0)
					(= [local80 1] 0)
					(bigHrGlass setScript: runBigClock 0 0)
					(littleHrGlass setScript: runlittleClock 0 0)
				)
				((== value 3)
					(cond
						((== local101 1)
							(if (localproc_1 1)
								(= local118 1)
							)
						)
						((and (== local100 1) (localproc_1 2))
							(= local118 1)
						)
					)
					(if (not local118)
						(gCMusic number: 55 setLoop: 1 play:)
						(proc5_9 180 38)
					else
						(gCMusic number: 50 setLoop: 1 play:)
					)
					(hourGlass goAway:)
				)
			)
			(gCMusic2 number: 60 setLoop: 1 play:)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 3 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance hourGlass of PuzzleBar
	(properties
		puzzleHeight 200
		bottomHeight 0
		hintFlag 52
		solvedFlag 53
	)

	(method (init &tmp temp0)
		(= local99 global114)
		(= window (hourGlassWindow back: [local0 2] yourself:))
		(LoadMany rsSOUND 182 183)
		(= local104 iconHeight)
		(= local105 (+ iconHeight puzzleHeight 3))
		(self
			add:
				((= [local106 0] (buttonIcon new:))
					loop: [local93 global114]
					maskLoop: [local93 global114]
					value: 0
					nsLeft: [local110 0]
					nsTop: [local114 0]
					yourself:
				)
		)
		(self
			add:
				((= [local106 1] (buttonIcon new:))
					loop: [local96 global114]
					maskLoop: [local96 global114]
					value: 1
					nsLeft: [local110 1]
					nsTop: [local114 1]
					yourself:
				)
		)
		(for ((= temp0 2)) (< temp0 4) ((++ temp0))
			(self
				add:
					((= [local106 temp0] (buttonIcon new:))
						loop: 1
						maskLoop: 1
						value: temp0
						nsLeft: [local110 temp0]
						nsTop: [local114 temp0]
						highlightColor: [local0 0]
						lowlightColor: [local0 1]
						yourself:
					)
			)
		)
		(clockCast
			add:
				bigHrGlass
				(bigSandTop setLoop: 12 yourself:)
				(bigSandBot setLoop: 14 posn: 40 103 yourself:)
				(bigTrickle hide: yourself:)
				littleHrGlass
				littleSandTop
				littleSandBot
				(littleTrickle hide: yourself:)
		)
		(super init: &rest)
	)

	(method (animateOnce)
		(if local130
			(if local86
				(bigHrGlass show:)
				(bigSandTop show:)
				(bigSandBot show:)
				(littleHrGlass show:)
				(littleSandTop show:)
				(littleSandBot show:)
				(= local86 0)
				(Animate (clockCast elements:) 1)
				(if local131
					(self showHelp:)
					(= local131 0)
				)
			)
			(clockCast eachElementDo: #doit)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(clockCast eachElementDo: #motionCue)
			)
			(Animate (clockCast elements:) 1)
			(return 1)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			(or
				(and (<= 0 (event x:) 147) (<= 0 (event y:) 140))
				(& (event type:) $0040) ; direction
			)
			(if (and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
				(= temp0 (event message:))
				(= temp3 (self indexOf: highlightedIcon))
				(switch temp0
					(JOY_UP
						(cond
							((< temp3 2)
								(= temp1 (self at: (- size 3)))
							)
							((< temp3 4)
								(if
									(&
										((= temp1 (self at: (- temp3 2)))
											signal:
										)
										$0004
									)
									(= temp1 (self at: (- size 3)))
								)
							)
							((& ((= temp1 (self at: 2)) signal:) $0004)
								(= temp1 (self at: 3))
							)
						)
						(proc5_20 temp1)
						(self highlight: temp1)
					)
					(JOY_DOWN
						(cond
							((< temp3 2)
								(if (& ((= temp1 (self at: 2)) signal:) $0004)
									(= temp1 (self at: 3))
								)
							)
							((< temp3 4)
								(= temp1 (self at: (- size 3)))
							)
							((& ((= temp1 (self at: 0)) signal:) $0004)
								(= temp1 (self at: 2))
							)
						)
						(proc5_20 temp1)
						(self highlight: temp1)
					)
				)
			)
			(super dispatchEvent: event &rest)
		else
			(= gGameTime (+ gTickOffset (GetTime)))
			(self animateOnce:)
			(event dispose:)
			(return 0)
		)
	)

	(method (show &tmp temp0 temp1)
		(self highlightedIcon: (self at: (- size 3)))
		([local106 2] signal: (& (buttonIcon signal:) $fffb))
		([local106 0] signal: (= temp1 (| (buttonIcon signal:) $0004)))
		([local106 1] signal: temp1)
		([local106 3] signal: temp1)
		(= local6 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch global114
			(0
				(for ((= temp0 0)) (< temp0 12) ((++ temp0))
					(= [local8 temp0] [local44 temp0])
					(= [local20 temp0] [local56 temp0])
				)
			)
			(1
				(for ((= temp0 0)) (< temp0 12) ((++ temp0))
					(= [local8 temp0] [local68 temp0])
					(= [local20 temp0] 0)
				)
			)
			(2
				(for ((= temp0 0)) (< temp0 12) ((++ temp0))
					(= [local8 temp0] [local32 temp0])
					(= [local20 temp0] 0)
				)
			)
		)
		(= local7 0)
		(= local85 0)
		(= local86 1)
		(gGame setCursor: 80 1)
		(bigHrGlass setCycle: 0 cel: 0)
		(littleHrGlass setCycle: 0 cel: 0)
		(bigSandTop setLoop: 12 cel: 7)
		(bigSandBot x: 40 y: 103 setLoop: 14 setCel: 7)
		(littleSandTop cel: 5)
		(littleSandBot cel: 5)
		(= local130 1)
		(super show: &rest)
		(littleHrGlass setScript: 0)
		(bigHrGlass setScript: 0)
		(if local118
			(self solvePuzzle:)
			(proc5_9 180 39)
		)
		(return local118)
	)

	(method (buyClue)
		(if (super buyClue:)
			(if global114
				(proc5_9 180 40)
				(proc5_9 180 41)
			else
				(proc5_9 180 42)
			)
			(Animate (gCast elements:) 1)
		)
	)

	(method (showHelp)
		(proc5_9 180 43)
		(proc5_14 180 44 (if global114 35 else 25) (if global114 35 else 25))
		(Animate (gCast elements:) 1)
	)

	(method (hide)
		(clockCast eachElementDo: #hide)
		(Animate (clockCast elements:) 0)
		(= local130 0)
		(bigHourglassS stop:)
		(smallHourglassS stop:)
		(super hide: &rest)
	)

	(method (dispose)
		(clockCast eachElementDo: #dispose eachElementDo: #delete dispose:)
		(super dispose: &rest)
	)
)

(instance clockCast of Set
	(properties)
)

(instance hourGlassWindow of SysWindow
	(properties
		top 33
		left 26
		bottom 173
		right 173
		back 43
		priority 10
	)

	(method (open)
		(super open: &rest)
		(DrawCel 195 0 0 0 22 15)
	)
)

(instance elfWiggle of Osc ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 4) (< temp0 1))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)
)

(instance waterS of Sound
	(properties
		flags 1
		number 917
		loop -1
	)
)

(instance birdS of Sound
	(properties
		flags 1
		number 916
	)
)

(instance alarmS of Sound
	(properties
		flags 1
		number 919
		priority 5
		loop -1
	)
)

(instance radioS of Sound
	(properties
		flags 1
		number 180
		loop -1
	)
)

(instance voiceS of Sound
	(properties
		flags 1
	)
)

(instance smallHourglassS of Sound
	(properties
		flags 1
		number 183
		loop -1
	)
)

(instance bigHourglassS of Sound
	(properties
		flags 1
		number 182
		loop -1
	)
)

(instance elevatorScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic2 number: 944 setLoop: 1 play:)
				(elevatorLight setCel: 0)
				(= ticks 10)
			)
			(1
				(elevatorLight setCel: 1)
				(= ticks 20)
			)
			(2
				(gCMusic2 number: 937 setLoop: 1 play:)
				(Wait 0)
				(Wait 60)
				(elevatorDoor setCycle: End self)
			)
			(3
				(gEgo get: 22)
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance elevatorLight of Prop
	(properties
		x 274
		y 36
		view 180
		loop 4
	)
)

(instance elevatorDoor of Prop
	(properties
		x 275
		y 94
		description {the elevator door}
		view 180
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 180 45) ; "This looks like an elevator door."
			)
			(3
				(if (IsFlag 1)
					(gCurRoom setScript: elevatorScript)
				else
					(proc5_9 180 46)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closeDrawer of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic number: 121 setLoop: 1 play:)
				(drawer setCycle: Beg self)
			)
			(1
				(drawer stopUpd:)
				(self dispose:)
			)
		)
	)
)

