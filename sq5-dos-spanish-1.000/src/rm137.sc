;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 137)
(include sci.sh)
(use Main)
(use Feature)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	rm137 0
)

(local
	[local0 4]
	local4
	local5
	local6
	local7
	local8
	[local9 5]
	[local14 20] = [3 4 4 2 4 2 4 3 0 0 2 3 0 4 1 4 1 1 2 4]
	[local34 200]
)

(procedure (localproc_0 param1)
	(= local4 (Localize 55 55 55 47 55))
	(Message msgGET 137 param1 0 0 1 @local34)
	(TextSize @[local0 0] @local34 1605 local8)
	(Display @local34 dsCOORD local7 local4 dsCOLOR 39 dsBACKGROUND 1 dsFONT 1605 dsWIDTH local8)
)

(procedure (localproc_1 param1 param2)
	(+= local4 (+ [local0 2] 2))
	(Message msgGET 137 param1 0 0 param2 @local34)
	(TextSize @[local0 0] @local34 1605 local6)
	(Display @local34 dsCOORD local5 local4 dsCOLOR 36 dsBACKGROUND 1 dsFONT 1605 dsWIDTH local6)
	((= [local9 (- param2 2)] (AnswerBox new:))
		boxnum: (- param2 2)
		x: (Localize 37 37 37 34 37)
		y: (+ local4 (Localize 0 0 0 1 0))
		init:
	)
)

(class AnswerBox of View
	(properties
		view 128
		loop 1
		cel 1
		priority 15
		boxnum 0
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
		(self ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(DrawCel 128 1 0 x y)
				(if (== [local14 global114] boxnum)
					(++ global115)
				)
				(gSq5Music2 number: 124 setLoop: 1 play:)
				(sTest setScript: sNextQuest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rm137 of Rm
	(properties
		picture 24
		style -32758
	)

	(method (init)
		(= local5 (Localize 55 55 55 45 55))
		(= local6 (Localize 235 235 235 245 235))
		(= local7 (Localize 38 38 38 34 38))
		(= local8 (Localize 240 240 240 250 240))
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 128)
		(gEgo view: 1)
		(exitTest init: setOnMeCheck: 1 4)
		(super init:)
		(gGame handsOn:)
		(gTheIconBar disable: 0 3 4)
		(gCurRoom setScript: sTest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(and
					(InRect 20 0 300 200 gMouseX gMouseY)
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982)
			)
			(
				(and
					(not (InRect 20 0 300 200 gMouseX gMouseY))
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 1))
				)
				(gTheIconBar select: (gTheIconBar at: 1))
				(gGame setCursor: 981)
			)
		)
	)
)

(instance sTest of Script
	(properties)

	(method (doit)
		(if (GameIsRestarting)
			(self changeState: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state global114)
				(= cycles 1)
			)
			(1
				(localproc_0 2)
				(localproc_1 2 2)
				(localproc_1 2 3)
				(localproc_1 2 4)
				(localproc_1 2 5)
				(localproc_1 2 6)
			)
			(2
				(localproc_0 3)
				(localproc_1 3 2)
				(localproc_1 3 3)
				(localproc_1 3 4)
				(localproc_1 3 5)
				(localproc_1 3 6)
			)
			(3
				(localproc_0 4)
				(localproc_1 4 2)
				(localproc_1 4 3)
				(localproc_1 4 4)
				(localproc_1 4 5)
				(localproc_1 4 6)
			)
			(4
				(localproc_0 5)
				(localproc_1 5 2)
				(localproc_1 5 3)
				(localproc_1 5 4)
				(localproc_1 5 5)
				(localproc_1 5 6)
			)
			(5
				(localproc_0 6)
				(localproc_1 6 2)
				(localproc_1 6 3)
				(localproc_1 6 4)
				(localproc_1 6 5)
				(localproc_1 6 6)
			)
			(6
				(localproc_0 7)
				(localproc_1 7 2)
				(localproc_1 7 3)
				(localproc_1 7 4)
				(localproc_1 7 5)
				(localproc_1 7 6)
			)
			(7
				(localproc_0 8)
				(localproc_1 8 2)
				(localproc_1 8 3)
				(localproc_1 8 4)
				(localproc_1 8 5)
				(localproc_1 8 6)
			)
			(8
				(localproc_0 9)
				(localproc_1 9 2)
				(localproc_1 9 3)
				(localproc_1 9 4)
				(localproc_1 9 5)
			)
			(9
				(localproc_0 10)
				(localproc_1 10 2)
				(localproc_1 10 3)
				(localproc_1 10 4)
				(localproc_1 10 5)
			)
			(10
				(localproc_0 1)
				(localproc_1 1 2)
				(localproc_1 1 3)
				(localproc_1 1 4)
				(localproc_1 1 5)
				(localproc_1 1 6)
			)
			(11
				(gSq5Music2 number: 125 setLoop: 1 play: self)
			)
			(12
				(gCurRoom newRoom: 135)
				(self dispose:)
			)
		)
	)
)

(instance sNextQuest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ global114)
				(= ticks 45)
			)
			(1
				([local9 0] dispose:)
				([local9 1] dispose:)
				([local9 2] dispose:)
				([local9 3] dispose:)
				(if (not (< 7 global114 10))
					([local9 4] dispose:)
				)
				(DrawPic 24 9)
				(= cycles 1)
			)
			(2
				(if (< global114 10)
					(= cycles 15)
				else
					(= cycles 1)
				)
			)
			(3
				(sTest cue:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4)
				(self dispose:)
			)
		)
	)
)

(instance exitTest of Feature
	(properties
		x 4
		y 20
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom newRoom: 135)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

