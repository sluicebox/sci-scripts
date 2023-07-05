;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 246)
(include sci.sh)
(use Main)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm226 0
)

(local
	[local0 2]
	local2
	local3
)

(instance rm226 of Rm
	(properties
		modNum 240
		noun 19
		picture 43
		style 100
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 0 255 26 259 265 259)
		(dummyEgo addToPic:)
		(cliffy addToPic:)
		(wd40 addToPic:)
		(chamber addToPic:)
		(northDoor addToPic:)
		(spike addToPic:)
		(self setScript: activateViewer)
	)
)

(instance dummyEgo of View
	(properties
		x 225
		y 146
		noun 18
		modNum 0
		view 0
		loop 8
		cel 2
		signal 16384
		scaleSignal 1
		scaleX 142
		scaleY 142
	)
)

(instance activateViewer of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(= local2 0)
				(gSq5Music2 number: 106 loop: 1 play:)
				(viewerTop init: self)
				(viewerBottom init: self)
			)
			(2)
			(3
				(viewerTop stopUpd:)
				(viewerBottom stopUpd:)
				(viewerScreen init:)
				(goliath init:)
				(aft init:)
				(wing init:)
				(bridge init:)
				(topsection init:)
				(midSection init:)
				(lowersection init:)
				(tllight init:)
				(trlight init:)
				(lllight init:)
				(lrlight init:)
				(midsectp2 init:)
				(midsectp3 init:)
				(= seconds 3)
			)
			(4
				(if (& global169 $0008)
					(+= state 2)
					(= cycles 1)
				else
					(|= global169 $0008)
					(gMessager say: 2 0 0 1 3 self 246) ; "Captain, I've been making a few scans of the Goliath and I've come up with some interesting information..."
				)
			)
			(5
				(aft show:)
				(midSection show:)
				(midsectp2 show:)
				(midsectp3 show:)
				(= seconds 3)
			)
			(6
				(gMessager say: 2 0 0 4 10 self 246) ; "The engineering spaces are almost completely deserted for example..."
			)
			(7
				(aft hide:)
				(midSection hide:)
				(midsectp2 hide:)
				(midsectp3 hide:)
				(= cycles 5)
			)
			(8
				(= local2 1)
				(gGame handsOn:)
				(exitSign init:)
				(gTheIconBar disable: 0 3 2 4 5 6)
			)
			(9
				(gGame handsOff:)
				(gSq5Music2 number: 106 loop: 1 play:)
				(gCast delete: gEgo)
				(viewerTop setMotion: MoveTo 94 -14 self)
				(viewerBottom setMotion: MoveTo 94 241 self)
				(viewerScreen dispose:)
				(goliath dispose:)
				(aft dispose:)
				(wing dispose:)
				(bridge dispose:)
				(topsection dispose:)
				(midSection dispose:)
				(lowersection dispose:)
				(tllight dispose:)
				(trlight dispose:)
				(lllight dispose:)
				(lrlight dispose:)
				(midsectp2 dispose:)
				(midsectp3 dispose:)
				(exitSign dispose:)
			)
			(10)
			(11
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(class Section of View
	(properties
		z 100
		modNum 246
		view 255
		loop 5
		priority 15
		signal 20496
	)

	(method (init)
		(+= y z)
		(super init: &rest)
		(self hide:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evVERB) (self onMe: event))
				(event claimed: 1)
				(self doVerb: (event message:))
			)
		)
		(event claimed:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if (and (not (IsObject onMeCheck)) (& signal $1000))
				(if
					(or
						(not (or nsLeft nsRight nsTop nsBottom))
						(and
							(<= nsLeft temp0 nsRight)
							(<= nsTop temp1 nsBottom)
						)
					)
					(not
						(IsItSkip
							view
							loop
							cel
							(- temp1 nsTop)
							(- temp0 nsLeft)
						)
					)
				)
			else
				(super onMe: temp0 temp1)
			)
		)
	)

	(method (doit)
		(if local2
			(cond
				((self onMe: gMouseX (- gMouseY 10))
					(if (and (not (self isNotHidden:)) (not local3))
						(= local3 self)
						(self show:)
					)
				)
				((and (self isNotHidden:) (== local3 self))
					(= local3 0)
					(self hide:)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance viewerTop of Actor
	(properties
		x 94
		y -14
		noun 13
		yStep 4
		view 255
		loop 2
		priority 14
		signal 28688
		moveSpeed 3
	)

	(method (init param1)
		(super init: &rest)
		(self posn: 94 -14 setLoop: 2 setMotion: MoveTo 94 48 param1)
	)
)

(instance viewerBottom of Actor
	(properties
		x 94
		y 241
		noun 13
		yStep 4
		view 255
		loop 1
		priority 14
		signal 28688
		moveSpeed 3
	)

	(method (init param1)
		(super init: &rest)
		(self posn: 94 241 setLoop: 1 setMotion: MoveTo 94 177 param1)
	)
)

(instance viewerScreen of View
	(properties
		x 84
		y 79
		noun 12
		view 255
		priority 13
		signal 20496
	)

	(method (init param1)
		(super init: &rest)
		(self setLoop: 0 stopUpd:)
	)
)

(instance goliath of View
	(properties
		x 84
		y 79
		view 255
		loop 4
		priority 14
		signal 16400
	)
)

(instance aft of Section
	(properties
		x 108
		y 99
		noun 3
	)
)

(instance midsectp2 of Section
	(properties
		x 129
		y 94
		noun 7
		cel 7
	)
)

(instance midsectp3 of Section
	(properties
		x 116
		y 94
		noun 9
		cel 6
	)
)

(instance wing of Section
	(properties
		x 108
		y 99
		noun 11
		cel 1
	)
)

(instance bridge of Section
	(properties
		x 108
		y 99
		noun 5
		cel 5
	)
)

(instance topsection of Section
	(properties
		x 108
		y 99
		noun 10
		cel 4
	)
)

(instance midSection of Section
	(properties
		x 108
		y 99
		noun 8
		cel 3
	)
)

(instance lowersection of Section
	(properties
		x 108
		y 99
		noun 6
		cel 2
	)
)

(instance tllight of View
	(properties
		x 29
		y 51
		noun 13
		view 255
		loop 1
		cel 1
		priority 15
		signal 16400
	)
)

(instance trlight of View
	(properties
		x 179
		y 39
		noun 13
		view 255
		loop 1
		cel 2
		priority 15
		signal 16400
	)
)

(instance lllight of View
	(properties
		x 29
		y 131
		noun 13
		view 255
		loop 1
		cel 1
		priority 15
		signal 16400
	)
)

(instance lrlight of View
	(properties
		x 179
		y 142
		noun 13
		view 255
		loop 1
		cel 2
		priority 15
		signal 16400
	)
)

(instance exitSign of View
	(properties
		x 115
		y 221
		z 100
		view 255
		loop 6
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(activateViewer cue:)
		)
	)
)

(instance cliffy of View
	(properties
		x 238
		y 162
		noun 5
		modNum 240
		view 26
		signal 24576
		scaleSignal 1
		scaleX 148
		scaleY 148
	)
)

(instance chamber of View
	(properties
		x 202
		y 132
		noun 8
		modNum 240
		view 259
		loop 2
		priority 9
		signal 22544
	)
)

(instance wd40 of View
	(properties
		x 124
		y 107
		noun 28
		modNum 240
		view 265
		signal 24576
	)

	(method (init)
		(extraView addToPic:)
		(super init: &rest)
	)
)

(instance extraView of View
	(properties
		x 124
		y 107
		noun 28
		modNum 240
		view 265
		loop 1
		priority 1
		signal 16400
	)
)

(instance northDoor of View
	(properties
		x 23
		y 95
		noun 20
		modNum 240
		view 259
		priority 5
		signal 20496
	)
)

(instance spike of View
	(properties
		x 253
		y 101
		noun 25
		modNum 240
		view 244
		loop 2
		priority 11
		signal 16400
	)
)

