;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 166)
(include sci.sh)
(use Main)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm166 0
)

(local
	local0
	[local1 200]
	local201
)

(instance rm166 of Rm
	(properties
		picture 36
		style -32758
	)

	(method (init)
		(super init:)
		(self setScript: sDoAll)
	)
)

(instance sDoAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music1 number: 17 loop: -1 play:)
				(if (gEgo has: 1) ; Floor_Scrubber
					(gEgo put: 1) ; Floor_Scrubber
				)
				(head init:)
				(shirt init:)
				(= seconds 2)
			)
			(1
				(hands
					init:
					setLoop: 4
					setStep: 6 6
					setMotion: MoveTo 117 114 self
				)
			)
			(2
				(eyess init: setCycle: ForwardCounter 4 self)
			)
			(3
				(gGame handsOn:)
				(= local201 1)
				(gTheIconBar disable: 0 3 4 5 6)
				(DrawPic 38 9)
				(Message msgGET 166 1 0 0 1 @local1) ; "Cadet Wilco,  On behalf of the administration I would like to congratulate you on receiving a perfect score on your SAT. Not in the entire history of StarCon Academy has a cadet achieved such high marks. You should be proud."
				(Display
					@local1
					dsCOORD
					(Localize 40 40 40 30 40)
					45
					dsCOLOR
					1
					dsFONT
					999
					dsWIDTH
					(Localize 240 240 240 260 240)
				)
				(Message msgGET 166 1 0 0 2 @local1) ; "On the recommendation of our test analysis computer system, you are to begin training for Captaincy aboard one of our fine star cruisers. Captain Quirk will post your assignment.  You've done the academy proud!  Sincerely,  (Current Chief Commanding Officer's name here.)"
				(Display
					@local1
					dsCOORD
					(Localize 40 40 40 30 40)
					(Localize 109 109 109 100 109)
					dsCOLOR
					1
					dsFONT
					999
					dsWIDTH
					(Localize 240 240 240 260 240)
				)
				(testResults init:)
			)
			(4
				(gGame handsOff:)
				(= local201 0)
				(DrawPic 36 9)
				(hands setLoop: 4 setStep: 6 6 setMotion: MoveTo 114 148 self)
			)
			(5
				(eyess dispose:)
				(hands dispose:)
				(head setLoop: 2)
				(= seconds 5)
			)
			(6
				(head setLoop: 3)
				(= seconds 1)
			)
			(7
				(SetScore 162 100)
				(PalVary pvUNINIT)
				(PalVary pvINIT 1602 1)
				(= seconds 1)
			)
			(8
				(shirt setCel: 1)
				(PalVary pvUNINIT)
				(PalVary pvINIT 1603 1)
				(= seconds 1)
			)
			(9
				(hall init:)
				(= seconds 1)
			)
			(10
				(PalVary pvUNINIT)
				(PalVary pvINIT 1604 3)
				(= seconds 4)
			)
			(11
				(gSq5Music1 fade: 80 10 5 0 self)
			)
			(12
				(PalVary pvUNINIT)
				(gCurRoom newRoom: 165)
			)
		)
	)
)

(instance hall of View
	(properties
		x 82
		y 26
		view 160
		loop 7
		priority 3
		signal 16400
	)
)

(instance shirt of Prop
	(properties
		x 159
		y 146
		view 160
		loop 5
		priority 5
		signal 16400
	)
)

(instance head of Prop
	(properties
		x 139
		y 38
		view 160
		priority 5
		signal 16400
	)
)

(instance eyess of Prop
	(properties
		x 151
		y 67
		view 160
		loop 1
		priority 7
		signal 16400
		cycleSpeed 20
	)
)

(instance hands of Actor
	(properties
		x 117
		y 149
		view 160
		loop 4
		priority 7
		signal 16400
		moveSpeed 1
	)
)

(instance testResults of Feature
	(properties
		y 189
		noun 2
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local201
					(sDoAll cue:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

