;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
	[local1 10] = [98 127 146 171 190 220 35 281 50 274]
	[local11 10] = [39 39 33 33 40 40 64 66 124 125]
	local21
	[local22 10]
	[local32 10]
	[local42 10] = [106 107 108 109 110 111 115 116 104 105]
	[local52 10] = [2 4 8 16 32 64 128 256 512 1024]
	local62
	local63
	local64
	local65
	[local66 26] = [102 9 168 56 103 274 167 307 1 2 3 4 5 6 5 4 3 2 1 2 3 4 5 6 0 0]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp5 (+ 6 (* local64 2)))
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(= [local32 temp0] (= temp3 (- (Random 1 temp5) 1)))
		(for ((= temp1 (= temp2 0))) (< temp1 temp0) ((++ temp1))
			(if (== [local32 temp1] temp3)
				(++ temp2)
			)
		)
		(if (> temp2 1)
			(-- temp0)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4)
	(proc5_1)
	(for ((= temp0 0)) (< temp0 local63) ((++ temp0))
		(= temp3 ((= temp1 [local22 [local32 temp0]]) lastCel:))
		(= temp2 1)
		(for ((= temp4 1)) (>= temp2 0) ((++ temp4))
			(temp1 setCel: temp2)
			(Animate (gCast elements:) 1)
			(if (== temp2 temp3)
				(if (< [local32 temp0] 8)
					(toneSound
						number: [local42 [local32 temp0]]
						setLoop: 1
						play:
					)
				else
					(toneSound
						number: [local42 [local32 temp0]]
						setLoop: -1
						play:
					)
				)
				(Wait 0)
				(Wait 12)
			else
				(Wait 0)
				(Wait 2)
			)
			(if (< temp4 temp3)
				(++ temp2)
			else
				(-- temp2)
			)
		)
		(toneSound stop:)
	)
	(proc5_2)
)

(procedure (localproc_2 param1 &tmp temp0)
	(= local62 0)
	(if param1
		(= local63 1)
		(= local0 1)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			([local22 temp0] show:)
		)
	)
	(localproc_1)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		([local22 temp0] hide:)
	)
	(= local0 0)
)

(instance rm100 of Rm
	(properties
		lookStr {This is the front door of Dr. Brain's castle.}
		picture 100
		style 8
	)

	(method (init &tmp temp0)
		(LoadMany rsSOUND 56 104 105 106 107 108 109 110 111 112 113 114 115 116)
		(super init:)
		(if (IsFlag 14)
			(frontDoor cel: (frontDoor lastCel:))
			(doorFeat
				lookStr:
					{You can see the first floor hallway beyond the rolled-up door.}
			)
			(bellFeat init:)
		else
			(doorbell init:)
			(grill init:)
		)
		(doorFeat init:)
		(frontDoor init:)
		(gAddToPics doit:)
		(= local64 global114)
		(gTheIconBar select: (gTheIconBar at: 0) curIcon: (gTheIconBar at: 0))
		(gGame setCursor: 7 1 160 100)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			((= [local22 temp0] (stone new:))
				setLoop: temp0
				posn: [local1 temp0] [local11 temp0]
				onMeCheck: [local52 temp0]
				init:
				hide:
			)
		)
		(for ((= temp0 6)) (< temp0 8) ((++ temp0))
			((= [local22 temp0] (stone new:))
				view: 100
				setLoop: (- temp0 5)
				posn: [local1 temp0] [local11 temp0]
				description: {lamp}
				onMeCheck: [local52 temp0]
				lookStr:
					{Dr. Brain got these lamps at a yard sale. He figured they were just right for illuminating his prized flamingoes.}
				init:
			)
		)
		(for ((= temp0 8)) (< temp0 10) ((++ temp0))
			((= [local22 temp0] (stone new:))
				view: 100
				setLoop: (- temp0 5)
				posn: [local1 temp0] [local11 temp0]
				description: {pink lawn flamingo}
				onMeCheck: [local52 temp0]
				lookStr:
					{Dr. Brain's reputation for brilliance doesn't extend to his taste in lawn decorations.}
				init:
			)
		)
		(grill setScript: grillScript)
	)

	(method (doit)
		(if (and (!= local64 global114) local0)
			(localproc_3)
		)
		(super doit: &rest)
	)
)

(instance stone of Prop
	(properties
		x 99
		y 40
		description {stone}
		lookStr {The stones above the door give a little when you push them, but you can't pull them out.}
		view 105
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(local0
				(if (== view 105)
					(= local65 loop)
				else
					(= local65 (+ loop 5))
				)
				(self setScript: itemIsSelected)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance itemIsSelected of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
				(if (< local65 8)
					(toneSound number: [local42 local65] setLoop: 1 play:)
				else
					(toneSound number: [local42 local65] setLoop: -1 play:)
				)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(toneSound stop:)
				(if (== local65 [local32 local62])
					(self cue:)
				else
					(gCMusic2 number: 56 setVol: 127 setLoop: 1 flags: 1 play:)
					(proc5_9 100 0)
					(localproc_2 0)
					(self dispose:)
				)
			)
			(3
				(if (or (>= (++ local62) local21) (>= local62 local63))
					(if (> (++ local63) local21)
						(Wait 0)
						(Wait 60)
						(gCurRoom setScript: playerHasWon)
					else
						(Wait 0)
						(Wait 20)
						(localproc_2 0)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance frontDoor of Prop
	(properties
		x 158
		y 64
		view 100
	)

	(method (onMe)
		(return 0)
	)
)

(instance doorFeat of Feature
	(properties
		description {front door of the castle}
		onMeCheck 16384
		lookStr {Dr. Brain's front door seems very secure.}
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((IsFlag 14)
				(gCurRoom newRoom: 120)
			)
			(else
				(doorKnock play:)
				(proc5_9 100 1)
			)
		)
	)
)

(instance doorKnock of Sound
	(properties
		flags 1
		number 114
	)
)

(instance doorRoll of Sound
	(properties
		flags 1
		number 113
	)
)

(instance doorBell of Sound
	(properties
		flags 1
		number 112
	)
)

(instance grill of Actor
	(properties
		x 161
		y 86
		description {grill}
		view 100
		loop 5
	)
)

(instance grillScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 300 480))
			)
			(1
				(grill setCycle: End self)
			)
			(2
				(grill setCycle: Beg self)
			)
			(3
				(grill setScript: grillScript)
			)
		)
	)
)

(instance bellFeat of Feature
	(properties
		nsTop 86
		nsLeft 222
		nsBottom 100
		nsRight 244
		description {doorbell}
		lookStr {This looks like every other castle doorbell you've seen.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(proc5_9 100 2)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance doorbell of Prop
	(properties
		x 234
		y 100
		description {doorbell}
		lookStr {This looks like every other castle doorbell you've seen.}
		view 100
		loop 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(= local64 global114)
			(switch global114
				(0
					(= local21 6)
				)
				(1
					(= local21 8)
				)
				(2
					(= local21 10)
				)
			)
			(localproc_0)
			(self setScript: ringDoorbell)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ringDoorbell of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorbell setCel: 1)
				(= ticks 1)
			)
			(1
				(doorBell play:)
				(= ticks 10)
			)
			(2
				(doorbell setCel: 0)
				(= ticks 60)
			)
			(3
				(localproc_2 1)
				(self dispose:)
			)
		)
	)
)

(instance toneSound of Sound
	(properties
		number 8
		priority 10
	)
)

(instance playerHasWon of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(LoadMany
					rsSOUND
					104
					105
					106
					107
					108
					109
					110
					111
					112
					113
					114
					115
					116
				)
				(LoadMany rsVIEW 105)
				(= ticks 1)
			)
			(1
				([local22 register] setCel: 1)
				(toneSound number: [local42 register] play:)
				(= ticks 20)
			)
			(2
				([local22 register] setCel: 0)
				(= ticks 6)
			)
			(3
				(if (< (++ register) 8)
					(self changeState: 0)
				else
					(proc5_0 14)
					(grill setScript: 0)
					(grill setCycle: End self)
				)
			)
			(4
				(grill hide:)
				(frontDoor setCycle: End self)
				(doorRoll play:)
			)
			(5
				(= ticks 180)
			)
			(6
				(if (not (gEgo has: 27))
					(proc5_9 100 3)
				)
				(gEgo get: 27)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

