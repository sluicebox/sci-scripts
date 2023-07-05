;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use eRS)
(use RotundaRgn)
(use Messager)
(use Talker)
(use Actor)
(use System)

(public
	testRoom 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 param2 param3)
	(switch param1
		(1782
			(param2 nsLeft: 42 nsTop: 16)
			(param3 nsLeft: 44 nsTop: 29)
		)
		(1791
			(param2 nsLeft: 58 nsTop: 17)
			(param3 nsLeft: 58 nsTop: 28)
		)
		(1786
			(param2 nsLeft: 44 nsTop: 16)
			(param3 nsLeft: 42 nsTop: 24)
		)
		(1785
			(param2 nsLeft: 26 nsTop: 16)
			(param3 nsLeft: 26 nsTop: 26)
		)
		(1793
			(param2 nsLeft: 33 nsTop: 15)
			(param3 nsLeft: 31 nsTop: 23)
		)
		(1790
			(param2 nsLeft: 42 nsTop: 14)
			(param3 nsLeft: 33 nsTop: 23)
		)
		(1788
			(param2 nsLeft: 45 nsTop: 17)
			(param3 nsLeft: 44 nsTop: 27)
		)
		(1783
			(param2 nsLeft: 63 nsTop: 17)
			(param3 nsLeft: 63 nsTop: 31)
		)
		(1784
			(param2 nsLeft: 27 nsTop: 20)
			(param3 nsLeft: 25 nsTop: 27)
		)
		(1792
			(param2 nsLeft: 63 nsTop: 19)
			(param3 nsLeft: 66 nsTop: 31)
		)
		(1787
			(param2 nsLeft: 63 nsTop: 18)
			(param3 nsLeft: 61 nsTop: 28)
		)
		(1781
			(param2 nsLeft: 81 nsTop: 20)
			(param3 nsLeft: 78 nsTop: 27)
		)
	)
)

(instance testRoom of LBRoom
	(properties
		picture 780
		style 9
	)

	(method (init)
		(self setRegions: 93) ; RotundaRgn
		(super init:)
		(gTheIconBar disable:)
		(= local1 gMessager)
		(= gMessager convMessager)
		(partyLaura addToPic:)
		(switch global128
			(0
				(= local0 13)
				((ScriptID 21 0) doit: 266) ; addCluesCode, Yvette Delacroix
				(partyPerson1 view: 1782 posn: 92 29 setPri: 3 addToPic:)
				(partyPerson2 view: 1791 posn: 180 19 addToPic:)
				(partyPerson3 view: 1786 posn: 238 42 setPri: 3 addToPic:)
				(partyPerson4 view: 1785 posn: 168 49 setPri: 3 addToPic:)
				(partyPerson5 view: 1790 posn: 60 46 setPri: 9 addToPic:)
			)
			(1
				(= local0 14)
				(partyPerson1 view: 1782 posn: 92 29 setPri: 3 addToPic:)
				(partyPerson2 view: 1791 posn: 135 26 setPri: 1 addToPic:)
				(partyPerson3 view: 1786 posn: 181 38 setPri: 2 addToPic:)
				(partyPerson4 view: 1790 posn: 60 46 setPri: 9 addToPic:)
			)
			(2
				(= local0 4)
				(partyPerson1 view: 1788 posn: 192 20 setPri: 3 addToPic:)
				(partyPerson2 view: 1793 posn: 116 56 setPri: 9 addToPic:)
			)
			(3
				((ScriptID 22 0) doit: $0010) ; triggerAndClock
				(= local0 5)
				(partyPerson1 view: 1788 posn: 104 28 addToPic:)
				(partyPerson2 view: 1783 posn: 159 26 setPri: 2 addToPic:)
				((ScriptID 21 0) doit: 271) ; addCluesCode, Dr. "Tut" Smith
			)
			(4
				(= local0 8)
				(partyPerson1 view: 1784 posn: 212 36 addToPic:)
				(partyPerson2 view: 1791 posn: 99 32 setPri: 2 addToPic:)
			)
			(5
				(= local0 10)
				(partyPerson1 view: 1784 posn: 212 36 addToPic:)
				(partyPerson2 view: 1790 posn: 133 41 setPri: 2 addToPic:)
			)
			(6
				(= local0 1)
				(partyPerson1 view: 1785 posn: 201 49 addToPic:)
				(partyPerson2 view: 1790 posn: 133 41 setPri: 2 addToPic:)
			)
			(7
				(= local0 2)
				(partyPerson1 view: 1786 posn: 194 42 setPri: 2 addToPic:)
				(partyPerson2 view: 1793 posn: 132 53 setPri: 1 addToPic:)
			)
			(8
				(= local0 3)
				(partyPerson1 view: 1788 posn: 125 35 addToPic:)
				(partyPerson2 view: 1790 posn: 230 56 addToPic:)
			)
			(9
				(= local0 11)
				(partyPerson1 view: 1791 posn: 122 40 addToPic:)
				(partyPerson2 view: 1783 posn: 187 31 setPri: 4 addToPic:)
				(partyPerson3 view: 1793 posn: 54 68 addToPic:)
			)
			(10
				(= local0 9)
				(partyPerson1 view: 1784 posn: 243 41 setPri: 4 addToPic:)
				(partyPerson2 view: 1792 posn: 142 35 addToPic:)
				(partyPerson3 view: 1793 posn: 103 68 setPri: 0 addToPic:)
			)
			(11
				(= local0 6)
				(partyPerson1 view: 1782 posn: 103 39 addToPic:)
				(partyPerson2 view: 1785 posn: 197 68 setPri: 0 addToPic:)
			)
			(12
				((ScriptID 22 0) doit: $0002) ; triggerAndClock
				(= local0 7)
				(partyPerson1 view: 1782 posn: 101 39 addToPic:)
				(partyPerson2 view: 1783 posn: 163 25 setPri: 0 addToPic:)
			)
			(13
				(= local0 12)
				(partyPerson1 view: 1787 posn: 94 40 addToPic:)
				(partyPerson2 view: 1785 posn: 181 57 addToPic:)
			)
		)
		(self setScript: sConv)
	)

	(method (newRoom)
		(gTheIconBar enable:)
		(gGameMusic1 fade: 127 5 5 0)
		(super newRoom: &rest)
	)

	(method (dispose)
		(= gMessager local1)
		(super dispose:)
	)
)

(instance sConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: local0 0 0 0 self)
			)
			(2
				(++ global128)
				(gCurRoom newRoom: (RotundaRgn convRoom:))
			)
		)
	)
)

(instance partyLaura of View
	(properties
		x -48
		y 30
		view 1781
		loop 1
	)
)

(instance partyPerson1 of View
	(properties
		loop 1
	)
)

(instance partyPerson2 of View
	(properties
		loop 1
	)
)

(instance partyPerson3 of View
	(properties
		loop 1
	)
)

(instance partyPerson4 of View
	(properties
		loop 1
	)
)

(instance partyPerson5 of View
	(properties
		loop 1
	)
)

(instance tkrParty1 of Talker
	(properties
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
	)

	(method (init)
		(= view (partyPerson1 view:))
		(= x (partyPerson1 x:))
		(= y (partyPerson1 y:))
		(tkrEyes1 view: view loop: 2)
		(tkrMouth1 view: view)
		(localproc_0 view tkrEyes1 tkrMouth1)
		(= textX (* (- x 10) -1))
		(= textY (- 120 y))
		(= font gUserFont)
		(super init: 0 tkrEyes1 tkrMouth1)
	)
)

(instance tkrEyes1 of Prop
	(properties)
)

(instance tkrMouth1 of Prop
	(properties)
)

(instance tkrParty2 of Talker
	(properties
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
	)

	(method (init)
		(= view (partyPerson2 view:))
		(= x (partyPerson2 x:))
		(= y (partyPerson2 y:))
		(tkrEyes2 view: view loop: 2)
		(tkrMouth2 view: view)
		(localproc_0 view tkrEyes2 tkrMouth2)
		(= textX (* (- x 10) -1))
		(= textY (- 120 y))
		(= font gUserFont)
		(super init: 0 tkrEyes2 tkrMouth2)
	)
)

(instance tkrEyes2 of Prop
	(properties)
)

(instance tkrMouth2 of Prop
	(properties)
)

(instance tkrParty3 of Talker
	(properties
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
	)

	(method (init)
		(= view (partyPerson3 view:))
		(= x (partyPerson3 x:))
		(= y (partyPerson3 y:))
		(tkrEyes3 view: view loop: 2)
		(tkrMouth3 view: view)
		(localproc_0 view tkrEyes3 tkrMouth3)
		(= textX (* (- x 10) -1))
		(= textY (- 120 y))
		(= font gUserFont)
		(super init: 0 tkrEyes3 tkrMouth3)
	)
)

(instance tkrEyes3 of Prop
	(properties)
)

(instance tkrMouth3 of Prop
	(properties)
)

(instance tkrParty4 of Talker
	(properties
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
	)

	(method (init)
		(= view (partyPerson4 view:))
		(= x (partyPerson4 x:))
		(= y (partyPerson4 y:))
		(tkrEyes4 view: view loop: 2)
		(tkrMouth4 view: view)
		(localproc_0 view tkrEyes4 tkrMouth4)
		(= textX (* (- x 10) -1))
		(= textY (- 120 y))
		(= font gUserFont)
		(super init: 0 tkrEyes4 tkrMouth4)
	)
)

(instance tkrEyes4 of Prop
	(properties)
)

(instance tkrMouth4 of Prop
	(properties)
)

(instance tkrParty5 of Talker
	(properties
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
	)

	(method (init)
		(= view (partyPerson5 view:))
		(= x (partyPerson5 x:))
		(= y (partyPerson5 y:))
		(tkrEyes5 view: view loop: 2)
		(tkrMouth5 view: view)
		(localproc_0 view tkrEyes5 tkrMouth5)
		(= textX (* (- x 10) -1))
		(= textY (- 120 y))
		(= font gUserFont)
		(super init: 0 tkrEyes5 tkrMouth5)
	)
)

(instance tkrEyes5 of Prop
	(properties)
)

(instance tkrMouth5 of Prop
	(properties)
)

(instance Laura of Talker
	(properties
		x -48
		y 30
		view 1781
		loop 3
		talkWidth 250
		back 15
	)

	(method (init)
		(tkrEyesL view: view loop: 2)
		(tkrMouthL view: view)
		(localproc_0 view tkrEyesL tkrMouthL)
		(= textX 58)
		(= textY (- 120 y))
		(= font gUserFont)
		(super init: 0 tkrEyesL tkrMouthL)
	)
)

(instance tkrEyesL of Prop
	(properties)
)

(instance tkrMouthL of Prop
	(properties)
)

(instance convMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(29 tkrParty1)
					(2 Laura)
					(25 tkrParty2)
					(19 tkrParty1)
					(10 tkrParty1)
					(27
						(if (== global128 9) tkrParty1 else tkrParty2)
					)
					(12 tkrParty1)
					(9 tkrParty2)
					(11
						(if (== global128 7) tkrParty1 else tkrParty3)
					)
					(28
						(switch global128
							(0 tkrParty4)
							(6 tkrParty1)
							(9 tkrParty3)
							(10 tkrParty3)
							(else tkrParty2)
						)
					)
					(6
						(switch global128
							(0 tkrParty5)
							(1 tkrParty4)
							(else tkrParty2)
						)
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

