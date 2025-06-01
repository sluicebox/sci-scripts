;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm29 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm29 of Rm
	(properties
		picture 29
		east 28
	)

	(method (init &tmp [temp0 50])
		(gUser canInput: 1 canControl: 1)
		(Load rsVIEW 56)
		(Load rsVIEW (LangSwitch 57 311))
		(Load rsVIEW (LangSwitch 59 313))
		(Load rsVIEW 85)
		(super init:)
		(door init: stopUpd:)
		(clerk init: stopUpd:)
		(gEgo init:)
		(bully init: stopUpd:)
		(if (> global124 0)
			(al3 init: stopUpd: setScript: al3Script)
			(al1Head init: stopUpd: setScript: (al1Script new:))
			(al2Head init: stopUpd: setScript: (al1Script new:))
		else
			(al3 init: addToPic:)
			(al1Head init: addToPic:)
			(al2Head init: addToPic:)
		)
		(gAddToPics add: al1 al2 machine)
		(gAddToPics doit:)
		(= local0 2)
		(= local4 0)
		(= local6 1)
		(= local7 1)
		(switch gPrevRoomNum
			(25
				(HandsOn)
				(gEgo init: loop: 3 cel: 0 posn: 286 130)
				(if (and global247 global248)
					(HandsOff)
					(= global248 0)
					(gCurRoom setScript: makeBurger)
				)
				(= local1 1)
				(gLongSong number: 16 loop: -1 priority: 127 playBed:)
			)
			(28
				(HandsOn)
				(gEgo init:)
				(if (< (gEgo y:) 110)
					(gEgo posn: 200 100)
				)
			)
			(280
				(HandsOn)
				(gEgo init: posn: global245 global246)
				(gLongSong number: 16 loop: -1 priority: 127 playBed:)
			)
			(290
				(gTheMenuBar draw:)
				(SL enable:)
				(HandsOn)
				(NormalEgo 0 0)
				(gEgo posn: 172 111)
				(gLongSong number: 16 loop: -1 priority: 127 playBed:)
			)
			(else
				(gEgo init: posn: 172 111)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (or (== (gEgo onControl: 0) 4) (== (gEgo onControl: 0) 5))
			(gCurRoom newRoom: 28)
		)
		(if
			(and
				(or
					(== (gEgo onControl: 0) 16)
					(== (gEgo onControl: 0) 17)
				)
				(not script)
			)
			(gCurRoom setScript: SitDown)
		)
		(if (gEgo inRect: 282 125 319 135)
			(cond
				(global247
					(if
						(and
							(not local1)
							(not global248)
							(not (gEgo has: 17)) ; Bag_of_Fast_Food
						)
						(gCurRoom newRoom: 25)
					)
				)
				((and (not local2) (not local1))
					(Print 29 0) ; "He's ignoring you because you don't have enough cash."
					(= local2 1)
				)
			)
		else
			(= local1 0)
			(= local2 0)
		)
		(if (and (== (gEgo onControl: 1) 8) (not script))
			(gCurRoom setScript: Bully)
		)
	)

	(method (handleEvent event &tmp [temp0 50])
		(if (event claimed:)
			(return)
		)
		(cond
			((& (event type:) $0040) ; direction
				(if (== local6 0)
					(switch (event message:)
						(JOY_UP
							(gCurRoom setScript: StandUp)
							(event claimed: 1)
						)
						(JOY_RIGHT
							(gCurRoom setScript: StandUp)
							(event claimed: 1)
						)
						(JOY_DOWN
							(event claimed: 1)
							(return)
						)
						(JOY_UPLEFT
							(event claimed: 1)
							(return)
						)
						(JOY_UPRIGHT
							(gCurRoom setScript: StandUp)
							(event claimed: 1)
						)
						(JOY_DOWNRIGHT
							(event claimed: 1)
							(return)
						)
						(JOY_DOWNLEFT
							(event claimed: 1)
							(return)
						)
						(JOY_LEFT
							(event claimed: 1)
							(return)
						)
						(JOY_NULL
							(event claimed: 1)
							(return)
						)
					)
				)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look,look>')
						(cond
							((or (Said '/pane') (Said '<out'))
								(PrintSplit 29 1) ; "Outside, the cold vacuum of space pulls at the fragile steel membrane that surrounds you.  Apprehension grips you as you realize your insignificance in the vastness of the universe.  The whirling cosmic display seems to... you know, the usual science fiction kinda stuff."
							)
							((or (Said '/deck,ceiling') (Said '<up,down'))
								(Print 29 2) ; "The floor below, the ceiling above. The physical laws of the universe are unchanging. Hanging from the ceiling is a menu."
							)
							((Said '/partition')
								(Print 29 3) ; "The cheerfully painted walls keep the floor and the ceiling from slamming into each other."
							)
							((Said '/clerk')
								(Print 29 4) ; "A recent graduate of Pinhead University, the clerk obviously doesn't have the words 'fast food' in his vocabulary. A trained Vorlian wartslug could probably do a better job."
							)
							(
								(Said
									'/alien,being,man,bystander,folk,creature,customer'
								)
								(Print 29 5) ; "Your eyes take in the diversity of alien forms without much interest. After all, you're quite a spacefaring kinda guy."
							)
							((Said '/craft')
								(Print 29 6) ; "The sleek ship parked on this side makes yours look like a real dog."
							)
							((Said '/counter')
								(Print 29 7) ; "The counter is your typical clerk-customer interface."
							)
							((Said '/door')
								(Print 29 8) ; "Yep, that's your basic automatic door."
							)
							((Said '/sign,sign')
								(Print 29 9) ; "You can't really make it out from here, get closer."
							)
							((Said '/dinner,bag,drink,drink')
								(cond
									((gEgo has: 17) ; Bag_of_Fast_Food
										(event claimed: 0)
									)
									((== local7 0)
										(Print 29 10) ; "The tattered remains of your meal lay strewn about the table."
									)
									(else
										(Print 29 11) ; "Why don't you buy a bag of food first?"
									)
								)
							)
							(
								(or
									(Said
										'/astro,astro,video,game,machine,comp[<video]'
									)
									(Said '/astro<astro')
								)
								(if (gEgo inRect: 158 94 200 124)
									(gCurRoom newRoom: 290)
								else
									(Print 29 12) ; "You'll have to get a little closer."
								)
							)
							((Said '/table,chair,booth')
								(Print 29 13) ; "Yes, the cold plastomold tables are like millions of others you've seen."
							)
							((Said '/menu')
								(if (== local6 0)
									(Print 29 14) ; "You can't quite see it from here. You'll have to stand up."
								else
									(= global245 (gEgo x:))
									(= global246 (gEgo y:))
									(gCurRoom newRoom: 280)
								)
							)
							((Said '[<around,at,in][/area,cafe]')
								(PrintSplit 29 15) ; "The decor, like the food, is the same in Monolith Burgers all over the universe. Generic counter clerks are eagerly waiting to help you. Diverse life-forms are crowded around the counter and sitting in booths consuming what can only loosely be termed food."
							)
						)
					)
					((Said 'open,close/door')
						(Print 29 16) ; "It's automatic, just walk near it. This is the future, remember?"
					)
					(
						(or
							(Said 'play/astro,astro,video,game,machine[<video]')
							(Said 'play/astro<astro')
						)
						(if (gEgo inRect: 158 94 200 124)
							(gCurRoom newRoom: 290)
						else
							(Print 29 17) ; "You'll have to get a little closer."
						)
					)
					((Said 'hit,tilt/video,game,machine[<video]')
						(if (gEgo inRect: 158 94 200 124)
							(Print 29 18) ; "The sophisticated electronics resist your feeble tamperings."
						else
							(Print 29 17) ; "You'll have to get a little closer."
						)
					)
					(
						(or
							(Said
								'order,order,buy,buy,get,get,ask[/dinner,dinner,burger,drink,drink]'
							)
							(Said 'talk,talk/clerk')
						)
						(cond
							((not (gEgo inRect: 282 125 319 135))
								(Print 29 19) ; "If you walk over to the clerk, you won't have to shout across the room."
							)
							((gEgo has: 17) ; Bag_of_Fast_Food
								(Print 29 20) ; "Why not eat what you already have before ordering more?"
							)
							((not global248)
								(gCurRoom newRoom: 25)
							)
							(else
								(Print 29 21) ; "He's ignoring you because you don't have enough cash."
							)
						)
					)
					((Said 'read/menu')
						(if (== local6 0)
							(Print 29 14) ; "You can't quite see it from here. You'll have to stand up."
						else
							(= global245 (gEgo x:))
							(= global246 (gEgo y:))
							(gCurRoom newRoom: 280)
						)
					)
					((Said 'read/sign,sign')
						(Print 29 22) ; "You can't really make it out from here, get closer."
					)
					(
						(Said
							'ask,talk,talk/alien,being,man,bystander,folk,creature,customer'
						)
						(Print 29 23) ; "The customers have better things to do than talk to a small-brained biped from a hick planet."
					)
					((Said 'talk,talk')
						(Print 29 24) ; "You mumble to yourself. The other customers eye you suspiciously."
					)
					(
						(Said
							'kiss,kiss/alien,being,man,bystander,folk,creature,customer'
						)
						(Print 29 25) ; "Inter-species relations are frowned upon around here.  You could get yourself killed for trying something like that."
					)
					(
						(Said
							'smell,smell,smell[/man,alien,being,him,bystander,creature,customer]'
						)
						(Print 29 26) ; "The only thing you can smell is the aroma of home-cooked food. Obviously a piped-in smell to mask the odor of the real food."
					)
					((Said 'down,sit[<down]')
						(cond
							((== local6 0)
								(Print 29 27) ; "You're already sitting."
							)
							((gEgo inRect: 173 123 232 156)
								(gCurRoom setScript: SitDown)
							)
							(else
								(Print 29 28) ; "You'll have to get closer to an empty booth first."
							)
						)
					)
					((Said 'up,(get,get<up),stand,stand,(stand,stand<up)')
						(if (== local6 1)
							(Print 29 29) ; "You're already standing."
						else
							(gCurRoom setScript: StandUp)
						)
					)
					((Said 'eat,eat[<dinner]')
						(cond
							((!= local6 0)
								(Print 29 30) ; "You have to sit down to eat."
							)
							((gEgo has: 17) ; Bag_of_Fast_Food
								(gCurRoom setScript: EgoEating)
							)
							(else
								(Print 29 31) ; "You don't have any food."
							)
						)
					)
					((Said 'get,get[<up]/bag')
						(cond
							((gEgo has: 17) ; Bag_of_Fast_Food
								(Print 29 32) ; "You already have it."
							)
							((== local7 0)
								(Print 29 33) ; "Nah, let Mr. Employee of the Week clean it up."
							)
							(else
								(Print 29 34) ; "There's no bag around here."
							)
						)
					)
					(
						(or
							(Said 'throw,get,get[<up,away]/junk,debris')
							(Said 'clean/table')
						)
						(cond
							((gEgo has: 17) ; Bag_of_Fast_Food
								(Print 29 35) ; "It's not trash yet."
							)
							((== local7 0)
								(Print 29 33) ; "Nah, let Mr. Employee of the Week clean it up."
							)
							(else
								(Print 29 36) ; "There's no trash around here."
							)
						)
					)
				)
			)
			((and (== (event type:) evMOUSEBUTTON) (== local6 0))
				(gCurRoom setScript: StandUp)
				(event claimed: 1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 28)
			(gLongSong stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance makeBurger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setLoop: 3 setMotion: MoveTo 248 103 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(clerk setLoop: 4 setMotion: MoveTo 297 105 self)
			)
			(3
				(clerk setLoop: 1)
				(= seconds 2)
			)
			(4
				(clerk setLoop: 0)
				(bag init:)
				(balloon init:)
				(= seconds 4)
			)
			(5
				(balloon dispose:)
				(bag dispose:)
				(Print 29 37) ; "You gingerly pick up the greasy bag. You can hardly wait to have a seat and dig in!"
				(gEgo get: 17) ; Bag_of_Fast_Food
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance SitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 186 141 self)
			)
			(1
				(gEgo view: 85 setLoop: 7 setPri: 15 setCel: 0)
				(if (gEgo has: 17) ; Bag_of_Fast_Food
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
			)
			(2
				(HandsOn)
				(= local6 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance StandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local7 0)
					(bag2 init:)
					(gEgo put: 17) ; Bag_of_Fast_Food
				)
				(gEgo setLoop: 7 setCel: 4 setCycle: Beg self)
			)
			(1
				(gEgo posn: 191 139)
				(RedrawCast)
				(NormalEgo 2 0)
				(= local6 1)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance EgoEating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global159 1)
				(= local6 2)
				(= local5 7)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(cond
					((!= (-- local5) 0)
						(switch (Random 1 2)
							(1
								(self changeState: 10)
							)
							(2
								(self changeState: 20)
							)
						)
					)
					(global249
						(self changeState: 30)
					)
					(else
						(self changeState: 40)
					)
				)
			)
			(10
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(gEgo setLoop: 3 setCycle: End self)
			)
			(14
				(gEgo setLoop: 2 setCel: 0)
				(= cycles 10)
			)
			(15
				(self changeState: 1)
			)
			(20
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(21
				(gEgo setLoop: 5 setCycle: Fwd)
				(= seconds 3)
			)
			(22
				(gEgo setLoop: 4 setCel: 2 setCycle: Beg self)
			)
			(23
				(gEgo setLoop: 2 setCel: 0)
				(= cycles 10)
			)
			(24
				(self changeState: 1)
			)
			(30
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(31
				(gEgo setCycle: Beg self)
			)
			(32
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 4)
			)
			(33
				(Print 29 38) ; "OWWW!!! Hey, what's this in my burger? Oh, it must be my Fun Meal prize! Hey, it's a swell decoder ring!"
				(gEgo get: 7) ; Monolith_Decoder_Ring
				(gGame changeScore: 10)
				(= seconds 3)
			)
			(34
				(self changeState: 40)
			)
			(40
				(Print 29 39) ; "Mmmmmm, that was mighty tasty. Well, maybe mildly tasty. Well, maybe not tasty at all. In fact, it reminded you of the slick skin of a Vorlian mucusworm."
				(gEgo setCycle: 0)
				(gUser canInput: 1)
				(= global159 0)
				(= global249 0)
				(= global244 0)
				(gEgo put: 17) ; Bag_of_Fast_Food
				(= local7 0)
				(= local6 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance Bully of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local4)
					(= local4 1)
					(HandsOff)
					(bBalloon init:)
					(= seconds 3)
				else
					(HandsOff)
					(self changeState: 20)
				)
			)
			(1
				(bBalloon dispose:)
				(ShakeScreen 5)
				(pow init: setCycle: End)
				(door setCycle: End self)
			)
			(2
				(gEgo
					view: (LangSwitch 57 311)
					setLoop: 5
					setCel: 0
					posn: 146 89
					xStep: 5
					yStep: 3
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo 169 113 self
					ignoreControl: 1
				)
			)
			(3
				(stars init: setCycle: Fwd)
				(pow
					setLoop: 4
					setCel: 0
					posn: (gEgo x:) (+ (gEgo y:) 5)
					setPri: 15
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(4
				(pow dispose:)
				(= cycles 2)
			)
			(5
				(bully setCycle: Walk setMotion: MoveTo 146 89 self)
			)
			(6
				(bully setMotion: MoveTo 158 97 self)
			)
			(7
				(door setCycle: Beg)
				(bully setMotion: MoveTo 209 97 self)
			)
			(8
				(bully stopUpd:)
				(stars dispose:)
				(gEgo setLoop: 6 setCycle: End self)
			)
			(9
				(NormalEgo 1 0)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
			(20
				(door setCycle: End)
				(bully setCycle: Walk setMotion: MoveTo 158 97 self)
			)
			(21
				(bully setMotion: MoveTo 146 89 self)
			)
			(22
				(bully setMotion: MoveTo 122 89 self)
			)
			(23
				(door setCycle: Beg self)
			)
			(24
				(bBalloon init: setCel: 1)
				(= seconds 3)
			)
			(25
				(bBalloon dispose:)
				(ShakeScreen 5)
				(pow
					init:
					setLoop: 3
					setCel: 0
					posn: 145 81
					setPri: 15
					setCycle: End
				)
				(= seconds 2)
			)
			(26
				(EgoDead 0 0 10 12) ; "A pulselaser blast to the forehead is not your idea of fun.__Fortunately, it didn't hit anything important."
			)
		)
	)
)

(instance al1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(if (or local3 (!= (gEgo mover:) 0) (!= (rm29 script:) 0))
					(self changeState: 5)
				else
					(= cycles 2)
				)
			)
			(2
				(= local3 1)
				(client setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(client stopUpd:)
				(= local3 0)
				(= seconds (Random 10 20))
			)
			(4
				(self changeState: 1)
			)
			(5
				(= cycles 2)
			)
			(6
				(self changeState: 1)
			)
		)
	)
)

(instance al3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 14))
			)
			(1
				(if (or local3 (!= (gEgo mover:) 0) (!= (rm29 script:) 0))
					(self changeState: 6)
				else
					(= cycles 2)
				)
			)
			(2
				(= local3 1)
				(client setCycle: End)
				(= seconds 2)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client stopUpd:)
				(= local3 0)
				(= seconds (Random 10 20))
			)
			(5
				(self changeState: 1)
			)
			(6
				(= cycles 2)
			)
			(7
				(self changeState: 1)
			)
		)
	)
)

(instance clerk of Actor
	(properties)

	(method (init)
		(super init:)
		(self view: (LangSwitch 59 313) loop: 0 posn: 297 105 ignoreActors: 1)
	)
)

(instance bag of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 59 313)
			setLoop: 2
			setCel: 0
			posn: 295 108
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance bag2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 85
			setLoop: 6
			setCel: 0
			posn: 177 153
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance balloon of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 59 313)
			setLoop: 5
			setCel: 0
			posn: 297 85
			ignoreActors: 1
		)
	)
)

(instance bully of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 57 311)
			loop: 0
			posn: 122 89
			ignoreActors: 1
			setStep: 3 2
		)
	)
)

(instance bBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 57 311)
			setLoop: 2
			setCel: 0
			posn: 177 88
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance pow of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 57 311)
			setLoop: 3
			setCel: 0
			posn: 145 81
			setPri: 15
		)
	)
)

(instance stars of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (LangSwitch 57 311)
			setLoop: 7
			setCel: 0
			posn: (+ (gEgo x:) 3) (- (gEgo y:) 9)
			setPri: (+ (gEgo priority:) 1)
		)
	)
)

(instance al1 of PicView
	(properties
		x 237
		y 164
		view 56
		loop 1
		cel 1
		priority 15
		signal 16384
	)
)

(instance al2 of PicView
	(properties
		x 140
		y 134
		view 56
		loop 1
		cel 2
		priority 15
		signal 16384
	)
)

(instance machine of PicView
	(properties
		x 190
		y 111
		view 56
		loop 1
	)
)

(instance al3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 56 setLoop: 4 setCel: 0 posn: 289 170 setPri: 15)
	)
)

(instance al1Head of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 2
			setCel: 0
			posn: 141 119
			setPri: 14
			ignoreActors: 1
		)
	)
)

(instance al2Head of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 3
			setCel: 0
			posn: 226 149
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 0
			setCel: 0
			posn: 156 95
			setPri: 6
			ignoreActors: 1
		)
	)

	(method (doit)
		(super doit:)
		(if (not (rm29 script:))
			(cond
				(
					(or
						(== (gEgo onControl: 0) 2)
						(== (gEgo onControl: 0) 3)
					)
					(if (> local0 1)
						(= local0 1)
						(self setCycle: End self)
					)
				)
				((< local0 2)
					(= local0 3)
					(self setCycle: Beg self)
				)
			)
		)
	)

	(method (cue)
		(door stopUpd:)
		(= local0 (if (== local0 1) 0 else 2))
	)
)

