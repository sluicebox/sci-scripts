;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n824)
(use n954)
(use LoadMany)
(use Grooper)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	inHerHut 0
)

(synonyms
	(kiss embrace squeeze hug)
)

(local
	local0
	local1
	local2
)

(instance inHerHut of Rm
	(properties
		picture 14
		west 13
		vanishingY 5
	)

	(method (init)
		(super init:)
		(Load rsSOUND 42)
		(Load rsSOUND 36)
		(LoadMany rsVIEW 206 212 14 200 208 106 114 314 2)
		(LoadMany rsSOUND 14 29)
		(door init: ignoreActors: 1 setCel: 16 setPri: 0 setCycle: Beg door)
		(Lamp init:)
		(Couch init:)
		(Carpet init:)
		(GlassTable init:)
		(flowersOnTable init:)
		(Plant init:)
		(Plant2 init:)
		(gAddToPics doit:)
		(proc824_0)
		((= local0 (ScriptID 309 0)) ; agent
			init:
			view: 212
			posn: 55 139
			loop: 0
			setLoop: -1
			setPri: -1
			setCycle: Walk
			setScript: agentScript
		)
		(gEgo
			view: 206
			posn: 55 142
			loop: 0
			setLoop: -1
			observeControl: 16384
			init:
		)
		(self
			setRegions: 300 ; tahiti
			setFeatures:
				Bed
				rugFeature
				windowFeature
				closetFeat
				((Clone windowFeature)
					x: 245
					nsLeft: 230
					nsRight: 260
					yourself:
				)
				((Clone windowFeature)
					y: 40
					x: 160
					nsBottom: 55
					nsLeft: 100
					nsRight: 215
					yourself:
				)
		)
		(smoochSong number: (proc0_5 14) loop: -1 play:)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			((Said 'look/bush')
				(Print 14 0) ; "You see the teeming Tahitian jungle."
			)
			((Said 'look[<around,at][/room][/!*]')
				(if (gCast contains: local0)
					(switch (Random 0 2)
						(0
							(Print 14 1) ; "She notices your snooping and says, " A little nosy, don't you think?""
						)
						(1
							(Print 14 2) ; "Stacy mentions to you, "I don't think you'll find anything of interest.""
						)
						(2
							(Print 14 3) ; "Say, bud," she protests, "Are you in here to see me or to search my bungalow?"
						)
					)
				else
					(Print 14 4) ; "Looking around the room you think to yourself, "Yep! she's flown the coop, all right!""
					(Print 14 5) ; "WOW, what a girl," you think, "So beautiful, yet so mysterious!"
				)
			)
			((Said 'look[<at]//earring')
				(Print 14 6) ; "Stacy has already searched her room, and further searching by you would be pointless."
			)
			((Said 'call<use')
				(Print 14 7) ; "The only phone you can use is the one in your room."
			)
			((Said 'kiss')
				(if (gCast contains: local0)
					(Print 14 8) ; "Why don't you go sit down with her first?"
				else
					(Print 14 9) ; "You kiss yourself a couple times but soon tire of it."
				)
			)
			((Said '(stand[<up]),(get<up)')
				(Print 14 10) ; "You're already standing."
			)
			((Said 'detach/clothes,shirt')
				(if (gCast contains: local0)
					(Print 14 11) ; "You're being a little forward, aren't you?"
				else
					(Print 14 12) ; "You don't need to."
				)
			)
		)
	)
)

(instance Plant of RPicView
	(properties
		y 161
		x 287
		view 14
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/plant][/floor,corner]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 13) ; "There is a beautiful tropical plant in the corner of the hut."
					)
					((Said 'move')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance Plant2 of RPicView
	(properties
		y 83
		x 219
		view 14
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/plant][/floor,corner]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 13) ; "There is a beautiful tropical plant in the corner of the hut."
					)
					((Said 'move')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance Lamp of RPicView
	(properties
		y 67
		x 93
		view 14
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/lamp][/floor,table]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 14) ; "A lamp on a mahogany end table by the bed."
					)
					((Said 'turn[<on,off]')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance flowersOnTable of RPicView
	(properties
		y 77
		x 170
		view 14
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/table,desk,flower][/table,desk]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<on,at]')
						(Print 14 15) ; "A mahogany table with ginger flowers."
						(if (and (gCast contains: note) (not (note z:)))
							(Print 14 16) ; "A folded note rests atop the table."
						)
					)
					((Said 'look<below')
						(Print 14 17) ; "All these tables seem to have four legs."
					)
					((GoToIfSaid self event self 25 'smell' 14 18))
					((Said 'smell')
						(Print 14 19) ; "The ginger fragrance fills the air."
					)
				)
			)
			((Said '[/drawer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 20) ; "A mahogany table with two drawers."
					)
					((Said 'open')
						(Print 14 21) ; "You don't need to open the drawer."
					)
				)
			)
		)
	)
)

(instance Carpet of PV
	(properties
		y 112
		x 204
		view 14
		cel 2
		priority 0
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/carpet,carpet][/floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,on]')
						(Print 14 22) ; "A beautiful hand-woven rug."
					)
					((GoToIfSaid self event self 5 0 14 18))
					((Said 'look[<below]')
						(Print 14 23) ; "Theres nothing of interest under there."
					)
				)
			)
		)
	)
)

(instance rugFeature of RFeature
	(properties
		y 145
		x 75
		nsTop 135
		nsLeft 50
		nsBottom 155
		nsRight 100
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/carpet,carpet][/floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 22) ; "A beautiful hand-woven rug."
					)
					((GoToIfSaid self event self 5 0 14 18))
					((Said 'look[<below]')
						(Print 14 23) ; "Theres nothing of interest under there."
					)
				)
			)
		)
	)
)

(instance GlassTable of RPicView
	(properties
		y 112
		x 204
		view 14
		cel 3
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/carpet,(table[<coffee])][/floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<on,at]')
						(Print 14 24) ; "You see a glass top coffee table sitting on a beautiful hand-woven rug."
					)
				)
			)
		)
	)
)

(instance Couch of RPicView
	(properties
		y 114
		x 237
		view 14
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/couch][/floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 25) ; "A couch."
					)
					((Said 'look<below')
						(Print 14 26) ; "Are you checking the maid's work?"
					)
					((GoToIfSaid self event 220 115 'sit[<on]' 14 18))
					((Said 'sit[<on]')
						(gEgo setScript: sitScript)
					)
				)
			)
		)
	)
)

(instance sitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreControl: -32768 setMotion: MoveTo 225 111 self)
			)
			(1
				(gEgo heading: 270)
				((gEgo looper:) doit: gEgo 270)
				(= cycles 8)
			)
			(2
				(gEgo view: 106 loop: 6 setCel: 0 setCycle: End self)
			)
			(3
				(User canInput: 1)
			)
			(4
				(User canInput: 0)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					view: 206
					loop: 1
					setCycle: Walk
					observeControl: -32768
					setScript: 0
				)
				(HandsOn)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said '(stand[<up]),(get<up)') (== state 3))
				(= cycles 1)
			)
		)
	)
)

(instance Bed of RFeature
	(properties
		y 80
		x 111
		nsTop 65
		nsLeft 81
		nsBottom 105
		nsRight 141
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bed][/floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 27) ; "Satin sheets on a King Size bed, it makes me warm just to think about it."
					)
					((GoToIfSaid self event self 30 'look[<below]' 14 18))
					((Said 'look[<below]')
						(Print 14 28) ; "Just a dusty wooden floor under the bed."
					)
					((Said 'make/')
						(Print 14 29) ; "The maids take care of that."
					)
					((Said 'look[<in]')
						(Print 14 30) ; "You see nothing."
					)
					((Said 'sit[/*]')
						(if (== (gEgo view:) 206)
							(gEgo setScript: egoSitScript)
						else
							(proc0_39) ; "You don't need to do that."
						)
					)
				)
			)
			((Said 'look/pillow')
				(proc0_36) ; "You see nothing special."
			)
		)
	)
)

(instance agentScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(local0 ignoreControl: -32768 setMotion: MoveTo 117 106 self)
				(theSound number: (proc0_5 42) loop: 1 play:)
			)
			(1
				(local0 setLoop: 2)
				(= cycles 1)
			)
			(2
				(local0 view: 14 setLoop: 4 setCycle: End self)
			)
			(3
				(HandsOn)
				(Print 14 31 #at 70 150) ; "She looks at you and says, "Come over and have a seat.""
			)
			(4)
			(5
				(switch (Random 0 1)
					(0
						(Print 14 32 #at 70 150) ; "The heat of passion begins to overcome you."
					)
					(1
						(Print 14 33 #at 70 150) ; "Your heart palpitates as Stacy plants her hot lips on yours."
					)
				)
			)
			(6
				(Print 14 34 #at 70 150) ; "As you embrace, your eyes begin to roll back into your head!"
			)
			(7
				(switch (Random 4 5)
					(4
						(Print 14 35 #at 70 150) ; "You thought you had been kissed by the best until this!"
					)
					(5
						(Print 14 36 #at 70 150) ; "The romantic tenderness of this kiss is overwhelming you."
					)
				)
			)
			(8
				(Print 14 37 #at 70 150) ; "You think to yourself, "MY, MY, MY!""
			)
			(9
				(gEgo
					observeControl: -32768
					ignoreActors: 0
					setLoop: -1
					setScript: 0
				)
				(gEgo hide:)
				(door hide:)
				(local0 dispose:)
				(HandsOff)
				(gGame changeScore: 6)
				(gCurRoom drawPic: 99 setScript: messageSexWithAgentScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk')
				(if (== (gEgo view:) 206)
					(Print 14 38) ; "Sit next to me," she says, "and we'll talk."
				else
					(self setScript: talkScript)
				)
			)
			((Said 'love<me/you')
				(switch (Random 0 2)
					(0
						(Print 14 39) ; "You can't love me," she says, "we just met."
					)
					(1
						(Print 14 40) ; "She looks at you and says, "Don't expect me to believe that one!""
					)
					(2
						(Print 14 41) ; "Love is such a splendid thing," she says, " But I don't think this relationship has reached that level yet."
					)
				)
			)
			((Said 'sit[<on][/bed]')
				(if (== (gEgo view:) 106)
					(Print 14 42) ; "You'll have to stand up first."
				else
					(if (== state 3)
						(self cue:)
					)
					(gEgo setScript: egoSitScript)
				)
			)
			((and (!= (gEgo view:) 106) (== state 3) (Said 'yes'))
				(if (== state 3)
					(self cue:)
				)
				(gEgo setScript: egoSitScript)
			)
			(
				(Said
					'feel,touch,rest,fuck,undress,fondle,make[/woman,love,stacy,boob]'
				)
				(switch (Random 0 2)
					(0
						(Print 14 43) ; ""Patience, John, patience," she says."
					)
					(1
						(Print 14 44) ; "She looks at you and says, "Don't be so crude!""
					)
					(2
						(Print 14 45) ; ""Slow down and just kiss me, ok," she coos."
					)
				)
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(register
						(Print 14 46) ; ""We've talked enough for the evening, don't you think, " replies Stacy."
						(self dispose:)
					)
					((== (gEgo view:) 106)
						(Print 14 47) ; "Why don't you go sit on the bed?"
					)
					(else
						(gEgo setLoop: 8 ignoreActors: 1 setCycle: End self)
					)
				)
			)
			(1
				(Print 14 48) ; "In a small voice of despair, the lovely Stacy says to you, "You know John, this vacation has been beautiful for me except for one thing!""
				(Print 14 49) ; "She continues, "I lost an earring today that is very important to me!""
				(Print 14 50) ; "I've searched everywhere, and, for the life of me, I just can't find it!"
				(Print 14 51) ; "I know it was on when I left the room," she sighs, "but I didn't notice it missing until just before walking into the hotel lobby."
				(Print 14 52) ; "Finally she says, "I know I'd be the happiest woman alive if I could find it!""
				(= register 1)
				(tahiti flags: (| (tahiti flags:) $0400))
				(self dispose:)
			)
		)
	)
)

(instance egoSitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo ignoreActors: setAvoider: Avoid)
				(HandsOff)
				(if
					(and
						(< (gEgo y:) (+ 5 (local0 y:)))
						(< (- (local0 x:) 28) (gEgo x:) (local0 x:))
					)
					(= cycles 1)
				else
					(gEgo
						setMotion:
							MoveTo
							(- (local0 x:) 14)
							(+ 5 (local0 y:))
							self
					)
				)
			)
			(1
				(gEgo
					ignoreControl: -32768
					setMotion: MoveTo (- (local0 x:) 14) (local0 y:) self
				)
			)
			(2
				(gEgo setLoop: 2)
				(= cycles 3)
			)
			(3
				(gEgo
					view: 14
					setLoop: 3
					ignoreControl: -32768
					setCycle: End self
				)
			)
			(4
				(local0 z: 1000)
				(gEgo view: 14 heading: 180)
				(if (gCast contains: local0)
					(gEgo setLoop: 5 cel: 0 setScript: kissScript)
				else
					(gEgo setLoop: 3 cel: 2)
				)
				(HandsOn)
				(User canControl: 0)
				(gEgo setAvoider: 0 ignoreActors: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit')
				(Print 14 53) ; "You're already seated."
			)
			((Said '(stand[<up]),(get<up)')
				(gEgo setScript: egoStandScript)
			)
		)
	)
)

(instance Mushroom of Prop
	(properties
		view 14
		loop 6
	)

	(method (init)
		(super init:)
		(self posn: (+ 10 (gEgo x:)) (- (gEgo y:) 40) setCycle: End self)
	)

	(method (cue)
		(kissScript cue:)
		(self dispose:)
	)
)

(instance kissScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (OneOf (gEgo loop:) 9 8)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOff)
				(gEgo setLoop: 5 setCycle: End self)
			)
			(3
				(Mushroom init:)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(if (Random 0 1)
					(gEgo setLoop: 9 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(6
				(HandsOn)
				(User canControl: 0)
				(local0 cue:)
				(if client
					(self init:)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit')
				(Print 14 53 #at -1 100) ; "You're already seated."
			)
			((Said 'kiss')
				(gEgo cue:)
			)
			((Said '(stand[<up]),(get<up)')
				(gEgo setScript: egoStandScript)
			)
		)
	)
)

(instance egoStandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 z: 0)
				(gEgo setLoop: 3 setCel: 16 setCycle: Beg self)
			)
			(1
				(gEgo
					view: 206
					setLoop: -1
					setCycle: Walk
					observeControl: -16384
					loop: 2
					posn: (gEgo x:) (+ (gEgo y:) 2)
				)
				(HandsOn)
			)
		)
	)
)

(instance messageSexWithAgentScript of Script
	(properties)

	(method (init)
		(gIceKeyDownHandler add: self)
		(gIceMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(gIceMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 14 54 #dispose) ; "The excitement and romance of the evening will be forever emblazoned on your memory! You think to yourself, "There really is a heaven on earth!""
				(tahiti flags: (| (tahiti flags:) $0040))
				(= global142 1)
				(Load rsSOUND 29)
				(self setScript: fireWorkScript)
			)
			(1
				(fireWorkScript dispose:)
				(proc0_3)
				(smoochSong client: self fade: 1)
			)
			(2
				(smoochSong number: 29 loop: -1 play:)
				(HandsOn)
				(User canControl: 0)
				(gCurRoom drawPic: 14)
				(door show:)
				(Lamp init:)
				(Couch init:)
				(Carpet init:)
				(GlassTable init:)
				(flowersOnTable init:)
				(Plant init:)
				(Plant2 init:)
				(bed2 init:)
				(note init:)
				(shirt init: setPri: 4)
				(messedUpBed init:)
				(gAddToPics doit:)
				(gCurRoom setFeatures: messedUpBed)
				(sandals init: ignoreActors:)
				(gEgo
					show:
					ignoreControl: -32768
					view: 314
					loop: 0
					cel: 0
					posn: 144 81
					setPri: 14
				)
			)
			(3
				(bed2 addToPic:)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(sandals dispose:)
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(gEgo
					view: 200
					loop: 0
					heading: 90
					setLoop: -1
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 179 80 self
				)
			)
			(6
				(shirt hide:)
				(gEgo view: 208 loop: 0 setCycle: End self)
			)
			(7
				(gEgo
					observeControl: -32768
					view: 206
					setCycle: Walk
					setLoop: Grooper
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((== state 0)
				(self cue:)
			)
			((super handleEvent: event))
			((Said 'get/note')
				(Print 14 55) ; "You can't quite reach it from here."
			)
			((or (Said 'stand,get[<up,dress]') (Said 'get<out/bed'))
				(gEgo setCycle: End self)
			)
		)
	)
)

(instance fireWorkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register
					((Prop new:)
						init:
						view: 114
						loop: 1
						cel: 0
						x: (Random 20 300)
						y: (Random 20 180)
						setCycle: End
						yourself:
					)
				)
				(= cycles 3)
			)
			(1
				(if local1
					(local1 dispose:)
				)
				(= local1
					((Prop new:)
						init:
						view: 114
						loop: 1
						cel: 0
						x: (Random 20 300)
						y: (Random 20 180)
						setCycle: End
						yourself:
					)
				)
				(= cycles 3)
			)
			(2
				(if local2
					(local2 dispose:)
				)
				(= local2
					((Prop new:)
						init:
						view: 114
						loop: 1
						cel: 0
						x: (Random 20 300)
						y: (Random 20 180)
						setCycle: End
						yourself:
					)
				)
				(= cycles 3)
			)
			(3
				(if register
					(register dispose:)
				)
				(self init:)
			)
		)
	)

	(method (dispose)
		(if register
			(register dispose:)
		)
		(if local1
			(local1 dispose:)
		)
		(if local2
			(local2 dispose:)
		)
		(super dispose:)
	)
)

(instance messedUpBed of PV
	(properties
		y 105
		x 96
		view 314
		loop 3
		priority 6
	)
)

(instance sandals of View
	(properties
		y 81
		x 157
		view 314
		loop 3
		cel 1
	)
)

(instance bed2 of View
	(properties
		y 105
		x 126
		view 314
		loop 4
	)
)

(instance door of Prop
	(properties
		y 140
		x 49
		view 14
		loop 7
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 8192) (not (self script:)))
			(HandsOff)
			(self setScript: doorScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door[<building,room]]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 56) ; "This is the door to Stacy's hut."
					)
					((Said 'close')
						(Print 14 57) ; "It is closed."
					)
					((GoToIfSaid self event 42 146 'open' 14 18))
					((Said 'open')
						(Print 14 58) ; "Ok."
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
				(theSound number: (proc0_5 36) loop: 1 play:)
			)
			(1
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 45) (gEgo y:) self
				)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

(instance smoochSong of Sound
	(properties
		number 14
		loop -1
	)
)

(instance shirt of View
	(properties
		y 70
		x 187
		view 2
		loop 1
		cel 3
	)
)

(instance note of View
	(properties
		y 65
		x 173
		view 114
	)

	(method (init)
		(self setPri: 4)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/note,letter,message>')
				(cond
					((Said 'look[<at]')
						(Print 14 59) ; "On the table you see a note."
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((GoToIfSaid self event self 30 'get,read' 14 18))
					((Said 'get,read')
						(if z
							(proc0_35) ; "You already took that."
						else
							(Print 14 60) ; "You pick up the note."
							(Print 14 61) ; "Dear John, Thanks for making my vacation so wonderful. You were sleeping so peacefully I just couldn't bring myself to wake you. I have urgent business to tend to and must leave. I wish you the best and hope we meet again soon.         Love,         Stacy"
							(Print 14 62) ; "You read and discard it."
							(gGame changeScore: 1)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance closetFeat of Feature
	(properties
		y 150
		x 270
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/closet]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 14 63) ; "A closet."
					)
					((Said 'open,examine')
						(Print 14 64) ; "No need to do that. You won't find a thing!"
					)
				)
			)
		)
	)
)

(instance windowFeature of RFeature
	(properties
		y 60
		x 80
		nsTop 30
		nsLeft 65
		nsBottom 80
		nsRight 90
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,out]')
						(Print 14 0) ; "You see the teeming Tahitian jungle."
					)
				)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		priority 2
	)
)

