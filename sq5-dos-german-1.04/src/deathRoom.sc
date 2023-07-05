;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Osc)
(use ForwardCounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	deathRoom 0
)

(local
	[local0 200]
	[local200 28] = [58 73 87 103 128 142 136 130 128 132 139 147 160 173 184 191 193 189 189 185 176 165 154 144 121 97 105 120]
	[local228 28] = [90 100 104 106 104 101 106 110 112 116 121 127 129 131 129 126 124 125 129 133 138 145 153 161 168 170 176 185]
	[local256 28] = [0 1 2 3 4 5 6 7 8 9 10 11 12 0 1 2 3 3 4 5 6 2 3 4 3 1 0 1]
	local284
	local285
	[local286 52] = [8 7 7 7 3 3 2 2 3 1 3 2 2 3 3 3 7 2 2 4 2 2 2 2 1 6 6 0 3 1 1 8 1 1 5 2 7 8 8 2 1 6 7 7 7 8 8 8 7 1 3 7]
)

(procedure (localproc_0)
	(iWannaQuit init:)
	(iWannaRestore init:)
	(iWannaRestart init:)
	(gUser canControl: 1 canInput: 1)
	(gTheIconBar enable:)
	(gTheIconBar enable: 2)
	(gTheIconBar select: (gTheIconBar at: 2))
	(gGame setCursor: 999)
)

(instance deathRoom of Rm
	(properties
		picture 200
	)

	(method (init)
		(Palette palSET_INTENSITY 0 255 100)
		(PalVary pvUNINIT)
		(gGame handsOff:)
		(super init:)
		(gSq5Music1 number: 45 loop: -1 play:)
		(gSq5Music2 stop:)
		(switch [local286 global119]
			(0
				(gCurRoom setScript: sRogBeatUp)
			)
			(1
				(gCurRoom setScript: sRogPuked)
			)
			(2
				(gCurRoom setScript: sRogBurned)
			)
			(3
				(gCurRoom setScript: sHeadExplodes)
			)
			(4
				(gCurRoom setScript: sAccordion)
			)
			(5
				(gCurRoom setScript: sFlattened)
			)
			(6
				(gCurRoom setScript: sFly)
			)
			(7
				(gCurRoom setScript: sGeneric)
			)
			(8
				(gCurRoom setScript: sPixelOut)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sRogBeatUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1 view: 2000 loop: 0 cel: 0 x: 24 y: 79 init:)
				(rogPart2
					view: 2000
					loop: 1
					cel: 0
					x: 67
					y: 80
					setPri: 14
					init:
					setCycle: ForwardCounter 2 self
				)
			)
			(1
				(rogPart2 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(rogPart2
					setLoop: -1
					setLoop: 2
					cel: (rogPart2 lastCel:)
					setStep: 2 10
					moveSpeed: 0
					setCycle: 0
					setMotion: MoveTo 67 200 self
				)
			)
			(3
				(rogPart2 hide:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sRogPuked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1 view: 2001 loop: 0 cel: 0 x: 24 y: 79 init:)
				(rogPart2
					view: 2001
					loop: 1
					cel: 0
					x: 67
					y: 80
					setPri: 14
					init:
					setCycle: End self
				)
				(rogPart3
					view: 2001
					loop: 2
					cel: 0
					x: 44
					y: 128
					setPri: 14
					init:
					setCycle: End self
				)
			)
			(1
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sRogBurned of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1 view: 2002 loop: 0 cel: 0 x: 24 y: 79 init:)
				(= seconds 2)
			)
			(1
				(Palette palSET_FROM_RESOURCE 200 2)
				(= ticks 15)
			)
			(2
				(rogPart1 view: 2002 loop: 0 cel: 1 x: 40 y: 73)
				(= ticks 15)
			)
			(3
				(Palette palSET_FROM_RESOURCE 202 2)
				(= local284 0)
				(= ticks 30)
			)
			(4
				(rogPart2
					view: 2002
					loop: 1
					cel: [local256 local284]
					x: [local200 local284]
					y: [local228 local284]
					setPri: 14
					init:
				)
				(= ticks 5)
			)
			(5
				(++ local284)
				(if (< 12 local284 21)
					(rogPart2 loop: 2)
				else
					(rogPart2 loop: 1)
				)
				(rogPart2
					cel: [local256 local284]
					x: [local200 local284]
					y: [local228 local284]
				)
				(if (< local284 27)
					(-- state)
				)
				(= ticks 5)
			)
			(6
				(rogPart2 hide:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sHeadExplodes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1 view: 2003 loop: 0 cel: 0 x: 24 y: 79 init:)
				(rogPart2
					view: 2003
					loop: 1
					cel: 0
					x: 67
					y: 80
					init:
					setPri: 14
					setCycle: End self
				)
			)
			(1
				(rogPart2 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(if (== global119 28)
					(localproc_0)
					(self dispose:)
				else
					(rogPart2 loop: 3 cel: 0)
					(= seconds 2)
				)
			)
			(3
				(rogPart2 dispose:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sAccordion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1
					view: 2004
					loop: 0
					cel: 0
					x: 24
					y: 79
					init:
					setCycle: Osc 3 self
				)
			)
			(1
				(rogPart1 setCycle: End self)
			)
			(2
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sFlattened of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1 view: 2005 loop: 0 cel: 0 x: 24 y: 79 init:)
				(rogPart2
					view: 2005
					loop: 1
					cel: 0
					x: 67
					y: 80
					setPri: 14
					init:
					setCycle: End self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 160 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 120 dsALIGN alCENTER)
				(rogPart1 view: 2006 loop: 0 cel: 0 x: 20 y: 63 init:)
				(= seconds 2)
			)
			(1
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sGeneric of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(rogPart1 view: 2001 loop: 0 cel: 0 x: 24 y: 79 init:)
				(rogPart2
					view: 2001
					loop: 1
					cel: 0
					x: 67
					y: 80
					setPri: 14
					init:
				)
				(rogPart3
					view: 2001
					loop: 2
					cel: 0
					x: 44
					y: 128
					setPri: 14
					init:
				)
				(= seconds 2)
			)
			(1
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sPixelOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rogPart1 view: 2001 loop: 0 cel: 0 x: 24 y: 79 init: addToPic:)
				(rogPart2
					view: 2001
					loop: 1
					cel: 0
					x: 67
					y: 80
					setPri: 14
					init:
					addToPic:
				)
				(rogPart3
					view: 2001
					loop: 2
					cel: 0
					x: 44
					y: 128
					setPri: 14
					init:
					addToPic:
				)
				(= seconds 2)
			)
			(1
				(DrawPic 200 9)
				(= seconds 2)
			)
			(2
				(if (< global119 36)
					(Message msgGET 20 2 0 0 global119 @local0)
				else
					(Message msgGET 20 1 0 0 (- global119 35) @local0)
				)
				(Display @local0 dsCOORD 143 68 dsCOLOR 0 dsBACKGROUND 5 dsFONT 1605 dsWIDTH 140 dsALIGN alCENTER)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance rogPart1 of Prop
	(properties
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogPart2 of Actor
	(properties
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogPart3 of Prop
	(properties
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance iWannaRestart of View
	(properties
		x 50
		y 170
		view 2099
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self cel: 1)
				(gGame restart:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance iWannaRestore of View
	(properties
		x 150
		y 170
		view 2099
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self cel: 1)
				(gGame restore:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance iWannaQuit of View
	(properties
		x 250
		y 170
		view 2099
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self cel: 1)
				(= gQuit 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

