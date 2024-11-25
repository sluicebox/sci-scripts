;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm91 0
)

(local
	local0
	local1
	[local2 108]
	local110
	local111
	local112 = 40
	local113 = 30
	local114
	local115
	local116
	[local117 28]
	local145
	local146
	local147
	local148 = 1
	local149
	local150
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(= local146 0)
	(= local145 1)
	(if (< (= temp0 (Abs (- param1 param2))) 2)
		(= local145 (if (== temp0 param3) 0 else 2))
	)
	(if (and (< param1 2) (< param2 2) (!= param1 param3))
		(= local146 (if (== param2 0) 6 else -6))
	)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp [temp0 2])
	(return
		(or
			(localproc_2 param1 param2 param3 param4)
			(localproc_3 param1 param2 param3 param4)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0
		(localproc_4
			param1
			param2
			(gEgo x:)
			(- (gEgo y:) 35)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(= temp1
		(localproc_4
			param3
			param4
			(gEgo x:)
			(- (gEgo y:) 35)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(if (== temp0 temp1)
		(return 0)
	)
	(= temp0
		(localproc_4
			(gEgo x:)
			(- (gEgo y:) 35)
			param1
			param2
			param3
			param4
		)
	)
	(= temp1
		(localproc_4
			(gEgo x:)
			(- (gEgo y:) 15)
			param1
			param2
			param3
			param4
		)
	)
	(if (== temp0 temp1)
		(return 0)
	else
		(= local114
			(-
				(/
					(+
						(* param4 (gEgo x:))
						(- (* param4 param1))
						(- (* param2 (gEgo x:)))
						(* param2 param3)
					)
					(- param3 param1)
				)
				(gEgo y:)
			)
		)
		(= local115 (gEgo loop:))
		(if (< (gEgo x:) param1)
			(= local116 1)
		else
			(= local116 0)
		)
		(return 1)
	)
)

(procedure (localproc_3 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0
		(localproc_4
			param1
			param2
			(- (gEgo y:) 25)
			(- (gEgo x:) 8)
			(- (gEgo y:) 25)
			(+ (gEgo x:) 8)
		)
	)
	(= temp1
		(localproc_4
			param3
			param4
			(- (gEgo y:) 25)
			(- (gEgo x:) 8)
			(- (gEgo y:) 25)
			(+ (gEgo x:) 8)
		)
	)
	(if (== temp0 temp1)
		(return 0)
	)
	(= temp0
		(localproc_4
			(- (gEgo y:) 25)
			(- (gEgo x:) 8)
			param1
			param2
			param3
			param4
		)
	)
	(= temp1
		(localproc_4
			(- (gEgo y:) 25)
			(+ (gEgo x:) 8)
			param1
			param2
			param3
			param4
		)
	)
	(if (== temp0 temp1)
		(return 0)
	else
		(= local114 (- -15 (Random 0 20)))
		(= local115 (gEgo loop:))
		(return 1)
	)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6)
	(if
		(>
			(+
				(* param6 param3)
				(- (* param5 param4))
				(* param1 (- param4 param6))
				(* param2 (- param5 param3))
			)
			0
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_5 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(if (< param1 (gEgo x:))
		(= temp1 (+ (- (gEgo x:) param1) (Random 0 35)))
	else
		(= temp1 (- (- (gEgo x:) param1) (Random 0 35)))
	)
	(= temp2 (- (gEgo y:) param2))
	(= temp3 (/ (* temp1 2) 128))
	(/= temp1 8)
	(/= temp2 8)
	(= [local2 param3] param1)
	(= [local2 (+ param3 9)] param2)
	(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
		(= [local2 (+ param3 temp0)] (+ [local2 (+ param3 temp0 -1)] temp1))
		(= [local2 (+ param3 temp0 9)]
			(+ [local2 (+ param3 temp0 8)] (- temp2 temp3))
		)
	)
	(for ((= temp0 5)) (<= temp0 8) ((++ temp0))
		(= [local2 (+ param3 temp0)] (+ [local2 (+ param3 temp0 -1)] temp1))
		(= [local2 (+ param3 temp0 9)]
			(+ [local2 (+ param3 temp0 8)] temp2 temp3)
		)
	)
)

(instance rm91 of Rm
	(properties
		picture 91
		style 8
		horizon 100
		north 93
		east 92
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 81)
		(brigandS stop:)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 91 90 400)
		(Load rsSOUND (SoundFX 73))
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(NormalEgo)
		(gContMusic stop:)
		(brigandS number: (SoundFX 73) init: play:)
		(archer1 setPri: 5 init: stopUpd:)
		(archer2 setPri: 7 init: stopUpd:)
		(archer3 setPri: 15 init: stopUpd:)
		(archer4 setPri: 3 init: stopUpd:)
		(archer5 setPri: 3 init: stopUpd:)
		(archer6 setPri: 3 init: stopUpd:)
		(spearman4 setPri: 13 init: stopUpd:)
		(spearman5 setPri: 13 init: stopUpd:)
		(self setScript: egoEnters)
		(switch gPrevRoomNum
			(93
				(ClearFlag 244)
				(gEgo
					posn: 143 108
					illegalBits: $8200
					setPri: 6
					init:
					setMotion: MoveTo 143 114 egoEnters
				)
			)
			(465 ; brigandArena
				(gEgo
					posn: 143 115
					illegalBits: $8200
					setPri: 6
					init:
					setMotion: MoveTo 143 102 egoEnters
				)
			)
			(else
				(SetFlag 244)
				(= local0 1)
				(spearman1 setPri: 3 init: stopUpd:)
				(spearman2 setPri: 3 init: stopUpd:)
				(spearman3 setPri: 3 init: stopUpd:)
				(gEgo
					posn: 309 158
					illegalBits: $8040
					setPri: 11
					init:
					setMotion: MoveTo 286 158 egoEnters
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp0 (gEgo loop:))
		(= temp1 (gEgo priority:))
		(= temp2 (gEgo x:))
		(= temp3 (gEgo y:))
		(for ((= local147 0)) (<= local147 24) ((+= local147 4))
			(if (!= [local117 local147] 0)
				(localproc_0
					[local117 (+ local147 1)]
					temp0
					[local117 (+ local147 2)]
				)
				(if (< [local117 local147] -29)
					(= local150 1)
					(= [local117 local147] -36)
					(if (== local145 0)
						(= local145 3)
					)
					(if (== local145 2)
						(= local145 4)
					)
				)
				([local117 (+ local147 3)]
					setCel: local145
					setPri: (- temp1 1)
					posn: (+ temp2 local146) (+ temp3 [local117 local147])
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 90])
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint (Format @temp0 91 0 @global401 @global594)) ; "%s, you're in big trouble!%"
					)
				)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							((Said '[<at,around][/place,place,area]')
								(HighPrint 91 1) ; "The cliffs are rocky and riddled with niches that could conceal things. Brigand archers for instance. There is a pile of logs off to the north."
							)
							((Said '[<at]/boulder')
								(HighPrint 91 2) ; "You seem to see movement, but you are not certain what is over there."
							)
							((Said '[<at]/cliff')
								(HighPrint 91 3) ; "The rock walls look steep."
							)
							((Said '[<at]/log')
								(HighPrint 91 4) ; "It is difficult to see them because of the cliff walls, but you think you can make out something or things behind the logs."
							)
							((Said '[<at]/bandit,archer,man')
								(HighPrint 91 5) ; "From what you can see, you realize that you are in a very dangerous situation."
							)
							((or (Said '<up') (Said '/sky'))
								(HighPrint 91 6) ; "You see archers perched on the cliffs."
							)
							((or (Said '<down') (Said '/ground,grass'))
								(HighPrint 91 7) ; "You'd better keep your head up."
							)
							((Said '/south,west')
								(HighPrint 91 8) ; "You see sheer cliff walls."
							)
							((Said '/north')
								(HighPrint 91 9) ; "You see a suspicious pile of logs blocking the passage in this canyon."
							)
							((Said '/east')
								(HighPrint 91 10) ; "You see where the canyon turns north."
							)
						)
					)
					((Said 'japaneseclimbup,climb,climb,hop,hop')
						(cond
							(
								(and
									(< 100 (gEgo x:) 160)
									(& (gEgo onControl: 1) $0200)
								)
								(= local149 1)
								(gEgo setScript: climbOverLogs)
							)
							(
								(and
									(> (gEgo y:) 117)
									(< 100 (gEgo x:) 160)
									(& (gEgo onControl: 1) $0040)
								)
								(= local149 0)
								(gEgo setScript: climbOverLogs)
							)
							(else
								(HighPrint 91 11) ; "The only way to climb is over the logs and you're not in a good place for that."
							)
						)
					)
				)
			)
		)
	)
)

(instance archer1 of Prop
	(properties
		y 87
		x 35
		view 91
		priority 5
	)

	(method (doit)
		(cond
			(
				(and
					(not local1)
					(& (gEgo onControl: 1) $1000)
					(< local111 local112)
				)
				(= local1 1)
				(archer1 setScript: shoot1 0 0)
				(archer2 setScript: shoot2 0 1)
				(archer3 setScript: shoot3 0 2)
				(archer4 setScript: shoot4 0 3)
				(archer5 setScript: shoot5 0 4)
				(archer6 setScript: shoot6 0 5)
			)
			(
				(or
					(& (gEgo onControl: 1) $0001)
					(& (gEgo onControl: 1) $0040)
					(> local111 local112)
				)
				(= local1 0)
				(if (and local148 (> local111 local112))
					(HighPrint 91 12) ; "Looks like the archers are running short on arrows."
					(= local148 0)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(or
				(MouseClaimed archer1 event 3)
				(MouseClaimed archer2 event 3)
				(MouseClaimed archer4 event 3)
				(MouseClaimed archer5 event 3)
				(MouseClaimed archer6 event 3)
			)
			(HighPrint 91 13) ; "A brigand archer!"
		)
	)
)

(instance archer2 of Prop
	(properties
		y 112
		x 27
		view 91
		priority 7
	)
)

(instance archer3 of Prop
	(properties
		y 185
		x 64
		view 91
		loop 1
		priority 5
	)

	(method (handleEvent event)
		(if (MouseClaimed archer3 event 3)
			(HighPrint 91 14) ; "One bad dude!"
		)
	)
)

(instance archer4 of Act
	(properties
		y 77
		x 296
		view 91
		loop 2
		priority 3
		illegalBits 0
	)
)

(instance archer5 of Act
	(properties
		y 75
		x 216
		view 91
		loop 4
		priority 3
		illegalBits 0
	)
)

(instance archer6 of Act
	(properties
		y 80
		x 247
		view 91
		loop 4
		priority 3
		illegalBits 0
	)
)

(instance spearman1 of View
	(properties
		y 123
		x 94
		view 91
		loop 5
		priority 3
	)

	(method (handleEvent event)
		(if
			(or
				(MouseClaimed spearman1 event 3)
				(MouseClaimed spearman2 event 3)
				(MouseClaimed spearman3 event 3)
				(MouseClaimed spearman4 event 3)
				(MouseClaimed spearman5 event 3)
			)
			(HighPrint 91 15) ; "A brigand ground fighter!"
		)
	)
)

(instance spearman2 of View
	(properties
		y 119
		x 119
		view 91
		loop 5
		cel 1
		priority 3
	)
)

(instance spearman3 of View
	(properties
		y 117
		x 146
		view 91
		loop 5
		cel 2
		priority 3
	)
)

(instance spearman4 of Act
	(properties
		y 201
		x 136
		view 91
		loop 6
		priority 13
		illegalBits 0
	)
)

(instance spearman5 of Act
	(properties
		y 211
		x 254
		view 91
		loop 6
		cel 1
		priority 13
	)
)

(class Shooter of Script
	(properties
		arrowPt 0
		arrowID 0
		arrowLoop 0
		addArrowX 0
		addArrowY 0
		archRestCel 0
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not local1)
					(self dispose:)
					(return)
				)
				(= temp0 (gEgo x:))
				(= arrowPt (* register 18))
				(switch register
					(2
						(= addArrowX 11)
						(= addArrowY -55)
						(= archRestCel 4)
						(= arrowLoop 1)
					)
					(3
						(= addArrowX -7)
						(= addArrowY 0)
						(= archRestCel 3)
						(if (< 255 temp0)
							(client setLoop: 4)
							(= arrowLoop 3)
						else
							(client setLoop: 2)
							(= arrowLoop 2)
						)
					)
					(4
						(= addArrowX 0)
						(= addArrowY 4)
						(= archRestCel 3)
						(cond
							((< 194 temp0)
								(client setLoop: 3)
								(= arrowLoop 3)
							)
							((< 183 temp0)
								(client setLoop: 4)
								(= arrowLoop 3)
							)
							(else
								(client setLoop: 2)
								(= arrowLoop 2)
							)
						)
					)
					(5
						(= addArrowX -3)
						(= addArrowY 1)
						(= archRestCel 3)
						(if (< 215 temp0)
							(client setLoop: 2)
							(= arrowLoop 2)
						else
							(client setLoop: 4)
							(= arrowLoop 3)
						)
					)
					(else
						(= addArrowX 9)
						(= addArrowY -26)
						(= archRestCel 2)
						(= arrowLoop 0)
					)
				)
				(= cycles (Random 5 15))
			)
			(1
				(localproc_5
					(+ (client x:) addArrowX)
					(+ (client y:) addArrowY)
					arrowPt
				)
				(client setCycle: CT (- (NumCels client) 2) 1 self)
			)
			(2
				((= arrowID (Prop new:))
					view: 90
					setLoop: arrowLoop
					setCel: 0
					setPri: 11
					ignoreActors:
					posn: [local2 (+ arrowPt 1)] [local2 (+ arrowPt 10)]
					init:
				)
				(client setCel: (+ (client cel:) 1))
				(= cycles 1)
			)
			(3
				(arrowID
					setCel: 1
					posn: [local2 (+ arrowPt 2)] [local2 (+ arrowPt 11)]
				)
				(= cycles 1)
			)
			(4
				(arrowID
					setCel: 2
					posn: [local2 (+ arrowPt 3)] [local2 (+ arrowPt 12)]
				)
				(= cycles 1)
			)
			(5
				(client setCycle: CT archRestCel 1)
				(arrowID posn: [local2 (+ arrowPt 4)] [local2 (+ arrowPt 13)])
				(= cycles 1)
			)
			(6
				(arrowID
					setCel: 3
					posn: [local2 (+ arrowPt 5)] [local2 (+ arrowPt 14)]
				)
				(= cycles 1)
			)
			(7
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1
							[local2 (+ arrowPt 5)]
							[local2 (+ arrowPt 14)]
							[local2 (+ arrowPt 6)]
							[local2 (+ arrowPt 15)]
						)
					)
					(= local110 arrowID)
					(gEgo setScript: egoHit)
					(self changeState: 0)
				else
					(arrowID
						posn: [local2 (+ arrowPt 6)] [local2 (+ arrowPt 15)]
					)
					(= cycles 1)
				)
			)
			(8
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1
							[local2 (+ arrowPt 6)]
							[local2 (+ arrowPt 15)]
							[local2 (+ arrowPt 7)]
							[local2 (+ arrowPt 16)]
						)
					)
					(= local110 arrowID)
					(gEgo setScript: egoHit)
					(self changeState: 0)
				else
					(arrowID
						setCel: 4
						posn: [local2 (+ arrowPt 7)] [local2 (+ arrowPt 16)]
					)
					(= cycles 1)
				)
			)
			(9
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1
							[local2 (+ arrowPt 7)]
							[local2 (+ arrowPt 16)]
							[local2 (+ arrowPt 8)]
							[local2 (+ arrowPt 17)]
						)
					)
					(= local110 arrowID)
					(gEgo setScript: egoHit)
					(self changeState: 0)
				else
					(arrowID
						posn: [local2 (+ arrowPt 8)] [local2 (+ arrowPt 17)]
					)
					(= cycles 1)
				)
			)
			(10
				(if (< (++ local111) local113)
					(arrowID addToPic:)
				else
					(arrowID dispose:)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance shoot1 of Shooter
	(properties)
)

(instance shoot2 of Shooter
	(properties)
)

(instance shoot3 of Shooter
	(properties)
)

(instance shoot4 of Shooter
	(properties)
)

(instance shoot5 of Shooter
	(properties)
)

(instance shoot6 of Shooter
	(properties)
)

(instance egoHit of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(local110 dispose:)
				(cond
					((gEgo has: 33) ; chainmail
						(TakeDamage 10)
					)
					((gEgo has: 8) ; leather
						(TakeDamage 20)
					)
					(else
						(TakeDamage 35)
					)
				)
				(for ((= temp0 0)) (<= temp0 24) ((+= temp0 4))
					(if (not [local117 temp0])
						(= [local117 temp0] local114)
						(= [local117 (+ temp0 1)] local115)
						(= [local117 (+ temp0 2)] local116)
						((= [local117 (+ temp0 3)] (View new:))
							view: 90
							setLoop: 5
							setCel: 1
							ignoreActors:
							init:
						)
						(break)
					)
				)
				(if (or (<= [gEgoStats 14] 0) local150) ; health
					(= cycles 3)
				else
					(self dispose:)
				)
			)
			(1
				(if local150
					(HighPrint 91 16) ; "You have a splintering headache that's doing you in."
				)
				(EgoDead ; "This was not the ending you had in mind when you read the manual on "How to be a Hero". Either you just aren't ready to take on this situation, or there is a better way to accomplish your mission."
					91
					17
					82
					516
					0
					9
					80
					{You knew this job was dangerous....}
				)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
			)
			(1
				(if (not (IsFlag 81))
					(TimePrint 4 91 18) ; "You have a bad feeling about this place."
				)
				(= seconds 4)
			)
			(2
				(archer4
					setLoop: 2
					setCel: 0
					ignoreHorizon:
					setMotion: MoveTo (archer4 x:) (- (archer4 y:) 25)
				)
				(archer5
					setLoop: 3
					setCel: 0
					ignoreHorizon:
					setMotion: MoveTo (archer5 x:) (- (archer5 y:) 25)
				)
				(archer6
					setLoop: 4
					setCel: 0
					ignoreHorizon:
					setMotion: MoveTo (archer6 x:) (- (archer6 y:) 25) self
				)
			)
			(3
				(archer4 stopUpd:)
				(archer5 stopUpd:)
				(archer6 stopUpd:)
				(spearman4
					setLoop: 6
					setCel: 0
					ignoreActors:
					illegalBits: 0
					ignoreHorizon:
					setMotion: MoveTo (spearman4 x:) (- (spearman4 y:) 25) self
				)
			)
			(4
				(spearman5
					setLoop: 6
					setCel: 1
					ignoreActors:
					illegalBits: 0
					ignoreHorizon:
					setMotion: MoveTo (spearman5 x:) (- (spearman5 y:) 25) self
				)
			)
			(5
				(if (not (IsFlag 81))
					(TimePrint 4 91 19) ; "You have an even worse feeling about this place."
				)
				(= seconds 4)
			)
			(6
				(spearman4 stopUpd:)
				(spearman5 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbOverLogs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local149
					(gEgo
						view: 400
						setLoop: 0
						setCel: 0
						illegalBits: 0
						ignoreActors:
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
					)
				else
					(gEgo
						view: 400
						setLoop: 1
						setCel: 0
						illegalBits: 0
						ignoreActors:
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
					)
				)
			)
			(1
				(gEgo
					setCel: 1
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
				)
			)
			(2
				(gEgo
					setCel: 2
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 3) self
				)
			)
			(3
				(if local149
					(gEgo
						setCel: 3
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
					)
				else
					(gEgo
						setCel: 3
						setPri: 7
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
					)
				)
			)
			(4
				(if local149
					(gEgo
						setCel: 4
						setPri: 6
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
					)
				else
					(gEgo
						setCel: 4
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 4) self
					)
				)
			)
			(5
				(if local149
					(gEgo
						setCel: 5
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
					)
				else
					(gEgo
						setCel: 5
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 8) self
					)
				)
			)
			(6
				(if local149
					(gEgo
						setCel: 6
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
					)
				else
					(gEgo
						setCel: 6
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 8) self
					)
				)
			)
			(7
				(if local149
					(gEgo
						view: 0
						setLoop: 3
						setCel: 0
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
					)
				else
					(gEgo
						view: 0
						setLoop: 2
						setCel: 0
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 8) self
					)
				)
			)
			(8
				(NormalEgo)
				(if local149
					(gEgo loop: 3 setPri: 6 illegalBits: $8200)
				else
					(gEgo loop: 2 setPri: 7 illegalBits: $8040)
				)
				(if (and local149 local0)
					(= global265 3)
					(gCurRoom newRoom: 465) ; brigandArena
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance brigandS of Sound
	(properties
		number 73
		priority 3
		loop -1
	)
)

