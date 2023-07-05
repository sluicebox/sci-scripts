;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm95 0
)

(instance rm95 of Rm
	(properties
		picture 28
	)

	(method (init)
		((ScriptID 0 23) stop:) ; backSound
		(LoadMany rsSOUND 16 15 83)
		(LoadMany rsVIEW 115 116 228)
		(self style: 7)
		(super init:)
		(gAddToPics add: cookie1 cookie2 cookie3 eachElementDo: #init doit:)
		(witch setPri: 8 view: 116 setLoop: 0 posn: 123 129 init:)
		(door setPri: 9 init:)
		(cane setPri: 9 init:)
		(self setScript: openIt)
	)
)

(instance witch of Actor
	(properties)
)

(instance cane of View
	(properties
		x 182
		y 112
		description {window}
		view 228
		loop 1
	)
)

(instance door of Prop
	(properties
		x 111
		y 131
		view 228
	)
)

(instance closeIt of Script
	(properties
		cycles 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(doorSound number: 16 loop: 1 play:)
				(door cel: 4 cycleSpeed: 0 setCycle: CT 1 -1 self)
			)
			(2
				(doorSound number: 83 play:)
				(door setCycle: Beg self)
			)
			(3
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(doorSound number: 15 loop: 1 play:)
				(door cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(door stopUpd:)
				(witch
					setPri: -1
					illegalBits: 0
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 141 149 self
				)
			)
			(2
				(witch setMotion: MoveTo 178 169 self)
			)
			(3
				(witch setMotion: MoveTo 178 186 self)
			)
			(4
				(doorSound stop:)
				(witch setLoop: 1 setCycle: End self)
			)
			(5
				(gEgo
					view: 116
					posn: 187 186
					ignoreActors:
					loop: 2
					cel: 0
					init:
				)
				(witch
					view: 115
					ignoreActors:
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 178 169 self
				)
			)
			(6
				(gEgo stopUpd:)
				(witch setMotion: MoveTo 141 149 self)
			)
			(7
				(witch setMotion: MoveTo 125 131 self)
			)
			(8
				(witch setMotion: MoveTo 125 125 self)
			)
			(9
				(witch loop: 2)
				(= cycles 1)
			)
			(10
				(door setScript: closeIt self)
			)
			(11
				(EgoDead
					{The witch has turned you into a gingerbread man.  Or is that a Graham cracker?}
				)
				(self dispose:)
			)
		)
	)
)

(instance cookie1 of PicView
	(properties
		x 218
		y 169
		description {cookie}
		view 228
		loop 2
	)
)

(instance cookie2 of PicView
	(properties
		x 120
		y 175
		description {cookie}
		view 228
		loop 2
		cel 1
	)
)

(instance cookie3 of PicView
	(properties
		x 102
		y 160
		description {cookie}
		view 228
		loop 2
		cel 2
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

