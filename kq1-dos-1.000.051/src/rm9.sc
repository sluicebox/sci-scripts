;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm9 0
)

(local
	local0
)

(instance rm9 of Rm
	(properties
		picture 9
		horizon 70
		north 24
		east 10
		south 8
		west 16
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(if (and (not (IsFlag 22)) (!= (Random 0 3) 1))
			(= local0 60)
			(Load rsVIEW 155)
			(LoadMany rsSOUND 30 62)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 163 (gEgo x:) 102) (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 189 (gEgo y:) 85))
			)
			(east
				(gEgo
					posn: 317 (proc0_17 189 (proc0_18 172 (gEgo y:) 156) 98)
				)
			)
			(else
				(= local0 60)
			)
		)
		(gEgo init:)
		(proc0_1)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(smalltree1 init:)
		(smalltree2 init:)
		(smalltree3 init:)
		(smalltree4 init:)
		(smalltree5 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
	)

	(method (doit &tmp temp0)
		(cond
			((and script (!= script momShow))
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
			(script
				(script doit:)
			)
			((> local0 1)
				(-- local0)
			)
			(
				(and
					(not (gEgo inRect: 88 130 125 150))
					(== local0 1)
					(not (IsFlag 1))
				)
				(-- local0)
				(gCurRoom setScript: momShow)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look>')
				(if (Said '[<at,around][/room,clearing,ceder]')
					(Print 9 0) ; "You are standing in a clearing. The view of the forest is most pleasant here."
				)
			)
			((Said '/woman')
				(Print 9 1) ; "There is no fairy here."
			)
		)
	)
)

(instance mom of Actor
	(properties
		description {fairy godmother}
		view 155
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((or (Said 'look,look/woman') (MousedOn self event 3))
				(Print 9 2) ; "She is your fairy godmother."
			)
			((Said 'get,get/woman')
				(Print 9 3) ; "It is impossible to acquire a fairy godmother."
			)
			((or (Said '/woman') (Said 'say,talk,talk'))
				(Print 9 4) ; "There is no need to say, or do, anything."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 9 2) ; "She is your fairy godmother."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance momShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 21) number: 30 init: play:) ; gameSound
				(HandsOff)
				(proc0_15 gEgo 111 140)
				(mom
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					setLoop: 0
					setCycle: Fwd
					setPri: 10
					posn: 40 -5
					setMotion: MoveTo 66 30 self
					setStep: 3 4
					init:
				)
			)
			(1
				(mom setMotion: MoveTo 69 44 self)
			)
			(2
				(mom setMotion: MoveTo 108 77 self)
			)
			(3
				(mom setStep: 2 2 setMotion: MoveTo 101 100 self)
			)
			(4
				(mom setMotion: MoveTo 96 123 self)
			)
			(5
				(mom setStep: 1 1 setMotion: MoveTo 111 135)
				(= seconds 3)
			)
			(6
				(mom
					posn: 111 140
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(7
				(mom setLoop: 2 cel: 0 setCycle: End self)
			)
			(8
				(mom setScript: talkMom)
				(Print 9 5) ; "FAIRY GODMOTHER: "Gentle Sir Graham, I am your fairy godmother.""
				(= seconds 4)
			)
			(9
				(Print 9 6) ; "FAIRY GODMOTHER: "Your quest is indeed noble. What little aid I can offer you is this protective magic spell, effective but a little while.""
				(SetFlag 22)
				(= global124 3000)
				(gCurRoom setRegions: 616) ; rgHalo
				(= seconds 4)
			)
			(10
				((ScriptID 0 21) number: 62 play:) ; gameSound
				(mom setScript: 0 setLoop: 2 cel: 7 setCycle: Beg self)
			)
			(11
				(mom ignoreActors: 1 setLoop: 1 cel: 4 setCycle: Beg self)
			)
			(12
				((ScriptID 0 21) number: 30 play:) ; gameSound
				(mom setLoop: 0 posn: 111 135 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(Print 9 7) ; "FAIRY GODMOTHER: "I shall be watching over you, Sir Graham.""
				(mom setStep: 2 2 setMotion: MoveTo 34 77 self)
			)
			(14
				(mom setStep: 7 7 setMotion: MoveTo 210 -18 self)
			)
			(15
				((ScriptID 0 21) loop: 1 fade:) ; gameSound
				(HandsOn)
				(mom dispose:)
				(self dispose:)
			)
		)
	)
)

(instance talkMom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mom ignoreActors: 0 setLoop: 2 cel: 7 setCycle: CT 1 -1 self)
			)
			(1
				(mom setCycle: End self)
			)
			(2
				(= cycles (Random 3 6))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance bush1 of NewFeature
	(properties
		x 162
		y 79
		noun '/bush'
		nsTop 72
		nsLeft 155
		nsBottom 86
		nsRight 170
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You see lush plants and bushes throughout the Kingdom of Daventry.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 292
		y 91
		noun '/bush'
		nsTop 85
		nsLeft 275
		nsBottom 97
		nsRight 310
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You see lush plants and bushes throughout the Kingdom of Daventry.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 310
		y 158
		noun '/bush'
		nsTop 145
		nsLeft 301
		nsBottom 171
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {You see lush plants and bushes throughout the Kingdom of Daventry.}
	)
)

(instance smalltree1 of NewFeature
	(properties
		x 42
		y 93
		noun '/ceder<little'
		nsTop 77
		nsLeft 24
		nsBottom 109
		nsRight 61
		description {smalltree1}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance smalltree2 of NewFeature
	(properties
		x 69
		y 98
		noun '/ceder<little'
		nsTop 90
		nsLeft 60
		nsBottom 106
		nsRight 79
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance smalltree3 of NewFeature
	(properties
		x 266
		y 134
		noun '/ceder<little'
		nsTop 127
		nsLeft 244
		nsBottom 141
		nsRight 288
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance smalltree4 of NewFeature
	(properties
		x 252
		y 150
		noun '/ceder<little'
		nsTop 146
		nsLeft 231
		nsBottom 155
		nsRight 273
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance smalltree5 of NewFeature
	(properties
		x 17
		y 96
		noun '/ceder<little'
		nsTop 89
		nsLeft 11
		nsBottom 104
		nsRight 23
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 214
		y 11
		noun '/ceder'
		nsTop -1
		nsLeft 110
		nsBottom 23
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 175
		y 54
		noun '/ceder'
		nsTop 23
		nsLeft 165
		nsBottom 85
		nsRight 186
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 207
		y 50
		noun '/ceder'
		nsTop 24
		nsLeft 198
		nsBottom 77
		nsRight 216
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 271
		y 35
		noun '/ceder'
		nsTop 23
		nsLeft 222
		nsBottom 47
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 284
		y 57
		noun '/ceder'
		nsTop 47
		nsLeft 249
		nsBottom 68
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 262
		y 93
		noun '/ceder'
		nsTop 69
		nsLeft 254
		nsBottom 117
		nsRight 271
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 38
		y 38
		noun '/ceder'
		nsBottom 77
		nsRight 77
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Many beautiful trees adorn the green countryside.}
	)
)

